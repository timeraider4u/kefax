package at.jku.weiner.c.preprocess.utils.macros;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;

import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.preprocess.parser.antlr.internal.InternalPreprocessLexer;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;

public final class DefinitionFunctionMacro implements DefinitionMacro {
	public static final String VAR_ARGS = "__VA_ARGS__";
	public static final String EMPTY_STR = "";

	private final DefinitionTable definitionTable;
	private final String key;
	private final List<String> idList;
	private final String value;
	private final List<Token> replacements;
	private final boolean variadic;
	private final String varID;

	private boolean enabled = true;
	private long lastID = -1;

	public DefinitionFunctionMacro(final DefinitionTable definitionTable,
			final String key, final IdentifierList idList2, final String replace) {
		this.definitionTable = definitionTable;
		this.key = key;
		this.value = (replace == null) ? "" : replace;
		this.replacements = definitionTable.lexer.getTokens(this.value);
		this.removeWhitespaceFromList(this.replacements, 0,
				this.replacements.size() - 1);
		this.idList = this.copyList(idList2);
		this.variadic = this.isVariadic(idList2);
		if (this.variadic) {
			String tempID = idList2.getVarID();
			if (tempID == null) {
				tempID = DefinitionFunctionMacro.VAR_ARGS;
			}
			this.varID = tempID;
			this.idList.add(tempID);
		} else {
			this.varID = "";
		}
	}

	private List<String> copyList(final IdentifierList idList2) {
		final List<String> result = new ArrayList<String>();
		if (idList2 != null) {
			final List<String> list = idList2.getIdent();
			if (list != null) {
				for (final String str : list) {
					result.add(str);
				}
			}
		}
		return result;
	}

	private boolean isVariadic(final IdentifierList idList2) {
		if (idList2 == null) {
			return false;
		}
		final boolean result = idList2.isVariadic();
		return result;
	}

	@Override
	public String getKey() {
		return this.key;
	}

	@Override
	public boolean equalsMacro(final DefinitionMacro obj) {
		if (!(obj instanceof DefinitionFunctionMacro)) {
			return false;
		}
		final DefinitionFunctionMacro other = (DefinitionFunctionMacro) obj;
		if (!this.key.equals(other.key)) {
			return false;
		}
		if (this.idList.size() != other.idList.size()) {
			return false;
		}
		for (int i = 0; i < this.idList.size(); i++) {
			final String param1 = this.idList.get(i);
			final String param2 = other.idList.get(i);
			if (!(param1.equals(param2))) {
				return false;
			}
		}

		final String val1 = this.value.replaceAll("\\s", "");
		final String val2 = other.value.replaceAll("\\s", "");
		final boolean result = val1.equals(val2);
		return result;
	}

	protected List<Token> getReplacementList() {
		return this.replacements;
	}

	@Override
	public void resolve(final long id, final List<Token> code,
			final MacroRanges ranges) {
		if (this.lastID != id) {
			this.enabled = true;
		}
		this.lastID = id;
		if (!this.enabled) {
			// prevent endless replacement loops
			TokenUtils.print(
					"resolveFor-disabled('" + id + "'), " + ranges.toString()
					+ ", code='", code);
			return;
		}
		MyLog.trace(DefinitionFunctionMacro.class, "resolveFor-start('" + id
				+ "', '" + this.key + "')");
		final List<ArrayList<Token>> replace = this.initializeReplaceList();
		final int closingParenPosition = this.searchForClosingParen(code,
				ranges, replace);
		MyLog.trace(DefinitionFunctionMacro.class, "closingParenPosition='"
				+ closingParenPosition + "'");
		TokenUtils.printList("resolveFor-intermediate('" + id + "', '"
				+ this.key + "')", replace);

		if (ranges.startIndex == closingParenPosition) {
			return;
		}
		this.removeWhitespaceFromList(replace);
		// remove tokens of function-like invocation
		this.removeTokens(code, ranges, closingParenPosition);
		// add replacement tokens
		this.addReplacementTokensToCode(id, code, ranges, replace);
		// rescan
		this.enabled = false;
		TokenUtils.print(
				"resolveFor-rescan('" + id + "'), '" + ranges.toString()
				+ ", code='", code);
		final MacroRanges newRanges = new MacroRanges(ranges.startIndex,
				ranges.startIndex + ranges.addedElements);
		this.definitionTable.resolve(id, code, newRanges);
		TokenUtils.print("resolveFor-end('" + id + "'), '" + ranges.toString()
				+ "', code='", code);
		ranges.update(newRanges, false);
		this.enabled = true;
	}

	private List<ArrayList<Token>> initializeReplaceList() {
		final List<ArrayList<Token>> replace = new ArrayList<ArrayList<Token>>();
		for (int i = 0; i < this.idList.size(); i++) {
			final ArrayList<Token> list = new ArrayList<Token>();
			replace.add(list);
		}
		return replace;
	}

	private enum MatchState {
		Invalid, LookingForOpenLeftParen, LeftParen, LookingForRightParen, Done,
	}

	private class State {
		public MatchState state = MatchState.LookingForOpenLeftParen;
		public int openParens = 0;
	}

	private int searchForClosingParen(final List<Token> code,
			final MacroRanges ranges, final List<ArrayList<Token>> replace) {
		State currState = new State();
		int paramCount = 0;
		ArrayList<Token> list = this.getListForParamCount(replace, paramCount);
		for (int i = ranges.startIndex + 1; ((i < code.size()) && (i < code
				.size())); i++) {
			final Token token = code.get(i);
			final int tokenType = token.getType();
			currState = this.getNextState(currState, tokenType);
			MyLog.trace(DefinitionFunctionMacro.class, "currState='"
					+ currState.state + "', openParens='"
					+ currState.openParens + "'");
			if (currState.state == MatchState.Invalid) {
				return ranges.startIndex;
			} else if (currState.state == MatchState.Done) {
				if (this.variadic) {
					final int index = replace.size() - 1;
					list = this.getListForParamCount(replace, index);
					TokenUtils.print("variadicAddToken, list='", list);
					if (list.isEmpty()) {
						final Token t = TokenUtils
								.getIDTokenForText(DefinitionFunctionMacro.EMPTY_STR);
						list.add(t);
					}
					TokenUtils.print("variadicAddToken, list='", list);
				}
				return i;
			} else if (currState.state == MatchState.LookingForRightParen) {
				// looking for right parentheses
				if (currState.openParens == 1) {
					if (tokenType == InternalPreprocessLexer.RULE_SKW_COMMA) {
						paramCount++;
						list = this.getListForParamCount(replace, paramCount);
						if (this.variadic && (paramCount >= replace.size())) {
							list.add(token);
						}
					} else {
						list.add(token);
					}
				} else {
					list.add(token);
				}
			}
		}
		if ((currState.state == MatchState.LeftParen)
				|| (currState.state == MatchState.LookingForRightParen)) {
			throw new MacroParentheseNotClosedYetException(code, code.size());
		}
		return ranges.startIndex;
	}

	private State getNextState(final State currState, final int tokenType) {
		switch (currState.state) {
		case LookingForOpenLeftParen: {
			if (tokenType == InternalPreprocessLexer.RULE_SKW_LEFTPAREN) {
				currState.state = MatchState.LeftParen;
				currState.openParens++;
			} else if (tokenType == InternalPreprocessLexer.RULE_WHITESPACE) {
				currState.state = MatchState.LookingForOpenLeftParen;
			} else {
				currState.state = MatchState.Invalid;
			}
			break;
		}
		case LeftParen: {
			if (tokenType == InternalPreprocessLexer.RULE_SKW_RIGHTPAREN) {
				currState.state = MatchState.Done;
				currState.openParens--;
			} else if (tokenType == InternalPreprocessLexer.RULE_SKW_LEFTPAREN) {
				currState.state = MatchState.LookingForRightParen;
				currState.openParens++;
			} else {
				currState.state = MatchState.LookingForRightParen;
			}
			break;
		}
		case LookingForRightParen: {
			if (tokenType == InternalPreprocessLexer.RULE_SKW_LEFTPAREN) {
				currState.openParens++;
			} else if (tokenType == InternalPreprocessLexer.RULE_SKW_RIGHTPAREN) {
				currState.openParens--;
				if (currState.openParens == 0) {
					currState.state = MatchState.Done;
				}
			}
			break;
		}
		default:
			break;
		}
		return currState;
	}

	private ArrayList<Token> getListForParamCount(
			final List<ArrayList<Token>> replace, final int paramCount) {
		if (paramCount >= replace.size()) {
			if (this.variadic) {
				final int index = replace.size() - 1;
				return replace.get(index);
			} else {
				return new ArrayList<Token>();
			}
		} else {
			return replace.get(paramCount);
		}
	}

	private void removeTokens(final List<Token> code, final MacroRanges ranges,
			final int closingParenPosition) {
		for (int i = closingParenPosition; (i >= ranges.startIndex); i--) {
			code.remove(i);
			ranges.removeElement();
		}
	}

	private void removeWhitespaceFromList(final List<ArrayList<Token>> replace) {
		for (int i = 0; i < replace.size(); i++) {
			final ArrayList<Token> list = replace.get(i);
			this.removeWhitespaceFromList(list, 0, list.size() - 1);
		}
	}

	private void removeWhitespaceFromList(final List<Token> list,
			final int start, final int stop) {
		for (int j = stop; ((j > 0) && (j < list.size()) && this.isWhitespace(
				list, j)); j--) {
			MyLog.trace(DefinitionFunctionMacro.class, "remove at stop index='"
					+ j + "'");
			list.remove(j);
		}
		for (final int j = start; (j <= stop)
				&& ((j < list.size()) && this.isWhitespace(list, j));) {
			MyLog.trace(DefinitionFunctionMacro.class,
					"remove at start index='" + j + "'");
			list.remove(j);
		}
		boolean isWs = false;
		for (int j = 0; j < list.size(); j++) {
			if (this.isWhitespace(list, j)) {
				if (isWs) {
					MyLog.trace(DefinitionFunctionMacro.class,
							"remove at middle index='" + j + "'");
					list.remove(j);
					j--;
				}
				isWs = true;
			} else {
				isWs = false;
			}
		}
	}

	private boolean isWhitespace(final List<Token> list, final int index) {
		final Token token = list.get(index);
		final int type = token.getType();
		final boolean result = (type == InternalPreprocessLexer.RULE_WHITESPACE);
		return result;
	}

	private enum ReplacementState {
		Invalid, Normal, Stringify, StringifyEnd, ConcatenateLookAheadA, ConcatenateLookAheadB, Concatenate1a, Concatenate1b, Concatenate2, ConcatenateEnd, ConcatenateAndEatComma,
	}

	private void addReplacementTokensToCode(final long parenID,
			final List<Token> code, final MacroRanges ranges,
			final List<ArrayList<Token>> replace) {
		ReplacementState state = ReplacementState.Normal;
		Token temp = null;
		boolean addTemporary = true;
		for (int i = 0; i < this.replacements.size(); i++) {
			final Token token = this.replacements.get(i);
			final String text = token.getText();
			final int tokenType = token.getType();
			final int currIndex = ranges.getCurrentInsertionIndex();
			state = this.calculateNextState(state, code, tokenType, i, replace);
			TokenUtils.printList("addReplacementTokensToCode-loop(parenID='"
					+ parenID + "', i='" + i + "'), state='" + state
					+ "', text='" + text + "', index='" + currIndex + "'"
					+ "', replace='", replace);
			TokenUtils.print("addReplacementTokensToCode-loop('" + parenID
					+ "'), code='", code);
			switch (state) {
			case Normal:
				this.addNormalReplacement(parenID, code, ranges, token, text,
						replace, true);
				temp = null;
				break;
			case StringifyEnd:
				this.addStringifyReplacement(parenID, code, ranges, token,
						text, replace);
				temp = null;
				break;
			case Concatenate1a:
				addTemporary = true;
				break;
			case Concatenate1b:
				addTemporary = false;
				break;
			case ConcatenateEnd:
				this.addConcatenReplacement(parenID, code, ranges, token, text,
						replace, temp, addTemporary);
				final int insertionIndex = ranges.getCurrentInsertionIndex();
				final Token current = code.get(insertionIndex - 1);
				// temp = current;
				temp = TokenUtils.copy(current);
				break;
			case ConcatenateLookAheadA:
			case ConcatenateLookAheadB:
				if (temp == null) {
					temp = TokenUtils.copy(token);
				}
				break;
			case ConcatenateAndEatComma:
				if (tokenType == InternalPreprocessLexer.RULE_ID) {
					state = ReplacementState.Normal;
				} else if (tokenType == InternalPreprocessLexer.RULE_VA_ARGS) {
					state = ReplacementState.Normal;
				}
				break;
			default:
				break;
			}
			TokenUtils.print("addReplacementTokensToCode-done('" + parenID
					+ "') code='", code);
		}
	}

	private ReplacementState calculateNextState(ReplacementState currState,
			final List<Token> code, final int tokenType, final int i,
			final List<ArrayList<Token>> replace) {
		switch (currState) {
		case Normal: {
			if (tokenType == InternalPreprocessLexer.RULE_HASH) {
				currState = ReplacementState.Stringify;
			} else {
				final boolean lookAHead = this.lookAHead(i, currState, true);
				final boolean lookAHead2 = this.lookAHead2(i, currState,
						replace);
				if (lookAHead2) {
					currState = ReplacementState.ConcatenateAndEatComma;
				} else if (lookAHead) {
					currState = ReplacementState.ConcatenateLookAheadA;
				} else {
					currState = ReplacementState.Normal;
				}
			}
			break;
		}
		case Stringify: {
			if (tokenType == InternalPreprocessLexer.RULE_WHITESPACE) {
				currState = ReplacementState.Stringify;
			} else {
				currState = ReplacementState.StringifyEnd;
			}
			break;
		}
		case StringifyEnd: {
			if (tokenType == InternalPreprocessLexer.RULE_HASH) {
				currState = ReplacementState.Stringify;
			} else {
				currState = ReplacementState.Normal;
			}
			break;
		}
		case ConcatenateLookAheadA: {
			if (tokenType == InternalPreprocessLexer.RULE_HASH) {
				currState = ReplacementState.Concatenate1a;
			}
			break;
		}
		case ConcatenateLookAheadB: {
			if (tokenType == InternalPreprocessLexer.RULE_HASH) {
				currState = ReplacementState.Concatenate1b;
			}
			break;
		}
		case Concatenate1a: {
			if (tokenType == InternalPreprocessLexer.RULE_WHITESPACE) {
				currState = ReplacementState.Concatenate1a;
			} else if (tokenType == InternalPreprocessLexer.RULE_HASH) {
				currState = ReplacementState.Concatenate2;
			}
			break;
		}
		case Concatenate1b: {
			if (tokenType == InternalPreprocessLexer.RULE_WHITESPACE) {
				currState = ReplacementState.Concatenate1b;
			} else if (tokenType == InternalPreprocessLexer.RULE_HASH) {
				currState = ReplacementState.Concatenate2;
			}
			break;
		}
		case Concatenate2: {
			if (tokenType == InternalPreprocessLexer.RULE_WHITESPACE) {
				currState = ReplacementState.Concatenate2;
			} else {
				currState = ReplacementState.ConcatenateEnd;
			}
			break;
		}
		case ConcatenateEnd: {
			boolean incI = true;
			if (tokenType == InternalPreprocessLexer.RULE_HASH) {
				incI = false;
			}
			final boolean lookAHead = this.lookAHead(i, currState, incI);
			if (lookAHead) {
				if (tokenType == InternalPreprocessLexer.RULE_HASH) {
					currState = ReplacementState.Concatenate1b;
				} else {
					currState = ReplacementState.ConcatenateLookAheadB;
				}
			} else {
				currState = ReplacementState.Normal;
			}
			break;
		}
		case ConcatenateAndEatComma:
			currState = ReplacementState.ConcatenateAndEatComma;
			break;
		// case ConcatenateAndEatCommaEnd:
		// currState = ReplacementState.Normal;
		// break;
		default:
			break;
		}
		return currState;
	}

	private boolean lookAHead(final int i, final ReplacementState currState,
			final boolean incI) {
		int start = i;
		if (incI) {
			start++;
		}
		int hashes = 0;
		for (int j = start; j < this.replacements.size(); j++) {
			final Token token = this.replacements.get(j);
			final int type = token.getType();
			MyLog.trace(DefinitionFunctionMacro.class, "j='" + j
					+ "', nextToken='" + token.getText() + "', hashes='"
					+ hashes + "'");
			if (type == InternalPreprocessLexer.RULE_HASH) {
				hashes++;
			} else if (type != InternalPreprocessLexer.RULE_WHITESPACE) {
				if (hashes == 2) {
					return true;
				} else {
					return false;
				}
			}
			MyLog.trace(DefinitionFunctionMacro.class, "j='" + j
					+ "', nextToken='" + token.getText() + "', hashes='"
					+ hashes + "'");
		}
		return false;
	}

	private boolean lookAHead2(final int start,
			final ReplacementState currState,
			final List<ArrayList<Token>> replace) {
		final Token current = this.replacements.get(start);
		final int currType = current.getType();
		MyLog.trace(DefinitionFunctionMacro.class, "lookAHead2: start='"
				+ start + "', nextToken='" + current.getText() + "'");
		if (currType != InternalPreprocessLexer.RULE_SKW_COMMA) {
			return false;
		}
		int hashes = 0;
		for (int j = start + 1; j < this.replacements.size(); j++) {
			final Token token = this.replacements.get(j);
			final int type = token.getType();
			MyLog.trace(DefinitionFunctionMacro.class, "j='" + j
					+ "', nextToken='" + token.getText() + "', hashes='"
					+ hashes + "'");
			if (type == InternalPreprocessLexer.RULE_HASH) {
				hashes++;
			} else if (type != InternalPreprocessLexer.RULE_WHITESPACE) {
				if (hashes == 2) {
					final String name = token.getText();
					final boolean rightType = ((type == InternalPreprocessLexer.RULE_ID) || (type == InternalPreprocessLexer.RULE_VA_ARGS));
					final boolean varIsEmpty = this.variadicIsEmpty(replace);
					final boolean rightName = this.varID.equals(name);
					MyLog.trace(DefinitionFunctionMacro.class, "name='" + name
							+ "', rightType='" + rightType + "', varIsEmpty='"
							+ varIsEmpty + "', rightName='" + rightName + "'");
					if (rightType && varIsEmpty && rightName) {
						return true;
					}
					return false;
				} else {
					return false;
				}
			}
			MyLog.trace(DefinitionFunctionMacro.class, "j='" + j
					+ "', nextToken='" + token.getText() + "', hashes='"
					+ hashes + "'");
		}
		return false;
	}

	private final boolean variadicIsEmpty(final List<ArrayList<Token>> replace) {
		if (replace.isEmpty()) {
			return true;
		}
		final List<Token> varArgsList = replace.get(replace.size() - 1);
		if (varArgsList.isEmpty()) {
			return true;
		} else if (varArgsList.size() != 1) {
			return false;
		}
		final Token token = varArgsList.get(0);
		final String text = token.getText();
		final boolean result = DefinitionFunctionMacro.EMPTY_STR.equals(text);
		return result;
	}

	private void addNormalReplacement(final long parenID,
			final List<Token> code, final MacroRanges ranges,
			final Token token, final String text,
			final List<ArrayList<Token>> replace, final boolean normal) {
		if (this.contains(text)) {
			final ArrayList<Token> list = this.getList(text, replace);
			final List<Token> newList = list;
			if (normal) {
				// this.enabled = false;
				final MacroRanges newRange = new MacroRanges(0, list.size());
				this.definitionTable.resolve(parenID, list, newRange);
				this.enabled = true;
			}
			TokenUtils.print("addNormalReplacement-containsText, list='", list);
			for (int j = 0; j < newList.size(); j++) {
				final Token other = newList.get(j);
				final int index = ranges.getCurrentInsertionIndex();
				MyLog.trace(DefinitionFunctionMacro.class,
						"addNormalReplacement('" + parenID
								+ "')-for1, add token='" + other.getText()
								+ "' at '" + index + "'");
				code.add(index, other);
				ranges.addElement();
			}
		} else {
			final int type = token.getType();
			if (normal || (type != InternalPreprocessLexer.RULE_WHITESPACE)) {
				final List<Token> list = new ArrayList<Token>();
				list.add(token);
				// if (normal) {
				// // list = this.definitionTable.resolve(this.lastId, list);
				// }
				for (int i = 0; i < list.size(); i++) {
					final Token newToken = list.get(i);
					final int index = ranges.getCurrentInsertionIndex();
					MyLog.trace(
							DefinitionFunctionMacro.class,
							"addNormalReplacement('" + parenID
									+ "')-for2, add token='"
									+ newToken.getText() + "' at '" + index
									+ "'");
					code.add(index, newToken);
					ranges.addElement();
				}
			}
		}
	}

	private boolean contains(final String text) {
		if (this.idList.contains(text)) {
			return true;
		}
		return false;
	}

	private ArrayList<Token> getList(final String text,
			final List<ArrayList<Token>> replace) {
		final int argIndex = this.idList.indexOf(text);
		final ArrayList<Token> list = replace.get(argIndex);
		final ArrayList<Token> result = new ArrayList<Token>();
		for (int i = 0; i < list.size(); i++) {
			final Token token = list.get(i);
			final String newTokenText = token.getText();
			final int newTokenType = token.getType();
			final Token newToken = new CommonToken(newTokenType, newTokenText);
			result.add(newToken);
		}
		return result;
	}

	private void addStringifyReplacement(final long parenID,
			final List<Token> code, final MacroRanges ranges,
			final Token token, final String text,
			final List<ArrayList<Token>> replace) {
		MyLog.trace(DefinitionFunctionMacro.class,
				"addStringifyReplacement-start('" + parenID + "'), text='"
						+ text + "'");

		final StringBuffer buffer = new StringBuffer("");
		if (this.contains(text)) {
			final ArrayList<Token> list = this.getList(text, replace);
			for (int j = 0; j < list.size(); j++) {
				final Token other = list.get(j);
				final String otherText = other.getText();
				buffer.append(otherText);
			}
		} else {
			buffer.append(text);
		}
		MyLog.trace(DefinitionFunctionMacro.class,
				"addStringifyReplacement-end('" + parenID + "'), text='" + text
						+ "', buffer='" + buffer.toString() + "'");
		final Token newToken = this.getDoubleQuoteToken(buffer);
		final int index = ranges.getCurrentInsertionIndex();
		code.add(index, newToken);
		ranges.addElement();
	}

	private Token getDoubleQuoteToken(final StringBuffer buffer) {
		final String text = buffer.toString();
		final String text2 = text.replace("\\\"", "\\\\\"");
		final String text3 = text2.replace("\"", "\\\"");
		final String text4 = text3.trim();
		final String text5 = '"' + text4 + '"';
		final Token token = new CommonToken(
				InternalPreprocessLexer.RULE_SKW_DOUBLEQUOTE, text5);
		return token;
	}

	private void addConcatenReplacement(final long parenID,
			final List<Token> code, final MacroRanges ranges,
			final Token token, final String text,
			final List<ArrayList<Token>> replace, final Token temp,
			final boolean addTemporary) {
		final String oldText = temp.getText();
		MyLog.trace(DefinitionFunctionMacro.class,
				"addConcatenReplacement at '" + ranges.toString()
						+ "' on token='" + text + "', temp='" + oldText
						+ "', temporary='" + addTemporary + "'");
		TokenUtils.print("addConcatenReplacement - begin, tempCode='", code);
		if (addTemporary) {
			this.addNormalReplacement(parenID, code, ranges, temp, oldText,
					replace, false);
		}
		TokenUtils.print(
				"addConcatenReplacement - afterAddTemporary, tempCode='", code);
		final int insertionIndex = ranges.getCurrentInsertionIndex();
		MyLog.trace(DefinitionFunctionMacro.class,
				"addConcatenReplacement, temp insertionIndex='"
						+ insertionIndex + "'");
		this.addNormalReplacement(parenID, code, ranges, token, text, replace,
				false);
		TokenUtils.print(
				"addConcatenReplacement - afterSecondAddition, tempCode='",
				code);
		if ((insertionIndex < 0) || (insertionIndex >= code.size())) {
			return;
		}
		TokenUtils.print("addConcatenReplacement, tempCode='", code);
		final Token prev = code.get(insertionIndex - 1);
		final Token next = code.get(insertionIndex);
		final int oldType = prev.getType();
		if (oldType == InternalPreprocessLexer.RULE_ID) {
			final String prevText = prev.getText();
			final String nextText = next.getText();
			code.remove(insertionIndex);
			ranges.undoInsertion();
			prev.setText(prevText + nextText);
		}
	}
}
