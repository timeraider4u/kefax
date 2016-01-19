package at.jku.weiner.c.preprocess.utils.macros;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;

import at.jku.weiner.c.preprocess.parser.antlr.internal.InternalPreprocessLexer;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.utils.MyLog;

public final class DefinitionFunctionMacro implements DefinitionMacro {

	private final DefinitionTable definitionTable;
	private final String key;
	private final List<String> idList;
	private final String value;
	private final List<Token> replacements;
	private final boolean variadic;

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
		this.idList = ((idList2 == null) ? new ArrayList<String>() : idList2
				.getId());
		this.variadic = this.isVariadic(idList2);
		if (this.variadic) {
			String varID = idList2.getVarID();
			if (varID == null) {
				varID = "__VA_ARGS__";
			}
			this.idList.add(varID);
		}
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

	@Override
	public void resolve(final long id, final List<Token> code, final Point point) {
		if (this.lastID != id) {
			this.enabled = true;
		}
		this.lastID = id;
		if (!this.enabled) {
			// prevent endless replacement loops
			MyLog.debug("resolveFor-disabled('" + id + "'), currPosition='"
					+ point.x + ")");
			TokenListUtils.print(code);
			return;
		}
		MyLog.trace("resolveFor-start('" + id + "', '" + this.key + "')");
		final List<ArrayList<Token>> replace = this.initializeReplaceList();
		TokenListUtils.printList(replace);

		final int closingParenPosition = this.searchForClosingParen(code,
				point, replace);
		MyLog.trace("closingParenPosition='" + closingParenPosition + "'");
		MyLog.trace("resolveFor-intermediate('" + id + "', '" + this.key + "')");
		TokenListUtils.printList(replace);

		if (point.x == closingParenPosition) {
			return;
			// return -1;
		}
		this.removeWhitespaceFromList(replace);
		// remove tokens of function-like invocation
		this.removeTokens(code, point, closingParenPosition);
		// add replacement tokens
		final Point replacePoint = new Point(point.x, point.y);
		this.addReplacementTokensToCode(id, code, replacePoint, replace);
		// this.removeWhitespaceFromList(code, currPosition, index);
		// rescan
		// this.enabled = false;
		// int lastIndex = currPosition;
		this.definitionTable.resolve(id, code, new Point(point.x,
				replacePoint.y));
		this.enabled = true;
		return;
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
			final Point point, final List<ArrayList<Token>> replace) {
		State currState = new State();
		int paramCount = 0;
		ArrayList<Token> list = this.getListForParamCount(replace, paramCount);
		for (int i = point.x + 1; ((i < code.size()) && (i < point.y)); i++) {
			final Token token = code.get(i);
			final int tokenType = token.getType();
			currState = this.getNextState(currState, tokenType);
			MyLog.trace("currState='" + currState.state + "', openParens='"
					+ currState.openParens + "'");
			if (currState.state == MatchState.Invalid) {
				return point.x;
			} else if (currState.state == MatchState.Done) {
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
		return point.x;
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

	private void removeTokens(final List<Token> code, final Point point,
			final int closingParenPosition) {
		for (int i = closingParenPosition; (i >= point.x); i--) {
			code.remove(i);
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
		MyLog.trace("removeWS Back, start='" + start + "', stop='" + stop
				+ "', size='" + list.size() + "'");
		for (int j = stop; ((j > 0) && (j < list.size()) && this.isWhitespace(
				list, j)); j--) {
			MyLog.trace("remove at stop index='" + j + "'");
			list.remove(j);
		}
		MyLog.trace("removeWS Front, start='" + start + "', stop='" + stop
				+ "', size='" + list.size() + "'");
		for (final int j = start; (j <= stop)
				&& ((j < list.size()) && this.isWhitespace(list, j));) {
			MyLog.trace("remove at start index='" + j + "'");
			list.remove(j);
		}
		MyLog.trace("removeWS Doubles");
		boolean isWs = false;
		for (int j = 0; j < list.size(); j++) {
			if (this.isWhitespace(list, j)) {
				if (isWs) {
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
		MyLog.trace("index='" + index + "', token='" + token.getText()
				+ "', isWs='" + result + "', size='" + list.size() + "'");
		return result;
	}

	private enum ReplacementState {
		Invalid, Normal, Stringify, StringifyEnd, ConcatenateLookAhead, Concatenate, ConcatenateEnd,
	}

	private void addReplacementTokensToCode(final long parenID,
			final List<Token> code, final Point point,
			final List<ArrayList<Token>> replace) {
		ReplacementState state = ReplacementState.Normal;
		for (int i = 0; i < this.replacements.size(); i++) {
			final Token token = this.replacements.get(i);
			final String text = token.getText();
			final int tokenType = token.getType();
			state = this.calculateNextState(state, code, tokenType, i);
			MyLog.trace("addReplacementTokensToCode('" + parenID
					+ "'), state='" + state + "', text='" + text + "'");
			TokenListUtils.printList(replace);
			TokenListUtils.print(code);
			switch (state) {
			case Normal:
				this.addNormalReplacement(parenID, code, point, token, text,
						replace, true);
				break;
			case StringifyEnd:
				this.addStringifyReplacement(parenID, code, point, token, text,
						replace);
				break;
			case ConcatenateEnd:
				this.addConcatenReplacement(parenID, code, point, token, text,
						replace);
				break;
			case ConcatenateLookAhead:
				this.addNormalReplacement(parenID, code, point, token, text,
						replace, false);
				break;
			default:
				break;
			}
			TokenListUtils.print(code);
		}
	}

	private ReplacementState calculateNextState(ReplacementState currState,
			final List<Token> code, final int tokenType, final int i) {
		switch (currState) {
		case Normal: {
			if (tokenType == InternalPreprocessLexer.RULE_HASH) {
				currState = ReplacementState.Stringify;
			} else {
				int hashes = 0;
				for (int j = i + 1; j < this.replacements.size(); j++) {
					final Token token = this.replacements.get(j);
					final int type = token.getType();
					MyLog.trace("j='" + j + "', nextToken='" + token.getText()
							+ "', hashes='" + hashes + "'");
					if (type == InternalPreprocessLexer.RULE_HASH) {
						hashes++;
					} else if (type != InternalPreprocessLexer.RULE_WHITESPACE) {
						if (hashes == 2) {
							currState = ReplacementState.ConcatenateLookAhead;
							break;
						} else {
							currState = ReplacementState.Normal;
							break;
						}
					}
					MyLog.trace("j='" + j + "', nextToken='" + token.getText()
							+ "', hashes='" + hashes + "'");
				}
			}
			break;
		}
		case Stringify: {
			if (tokenType == InternalPreprocessLexer.RULE_HASH) {
				currState = ReplacementState.Concatenate;
			} else if (tokenType == InternalPreprocessLexer.RULE_WHITESPACE) {
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
		case ConcatenateLookAhead: {
			if (tokenType == InternalPreprocessLexer.RULE_HASH) {
				currState = ReplacementState.Stringify;
			}
			break;
		}
		case Concatenate: {
			if (tokenType == InternalPreprocessLexer.RULE_WHITESPACE) {
				currState = ReplacementState.Concatenate;
			} else {
				currState = ReplacementState.ConcatenateEnd;
			}
			break;
		}
		case ConcatenateEnd: {
			if (tokenType == InternalPreprocessLexer.RULE_HASH) {
				currState = ReplacementState.Stringify;
			} else {
				currState = ReplacementState.Normal;
			}
			break;
		}
		default:
			break;
		}
		return currState;
	}

	private void addNormalReplacement(final long parenID,
			final List<Token> code, final Point point, final Token token,
			final String text, final List<ArrayList<Token>> replace,
			final boolean normal) {
		if (this.contains(text)) {
			final ArrayList<Token> list = this.getList(text, replace);
			List<Token> newList = list;
			if (normal) {
				this.enabled = false;
				this.definitionTable.resolve(parenID, list,
						new Point(0, list.size()));
				this.enabled = true;
			}
			TokenListUtils.print(newList);
			for (int j = 0; j < newList.size(); j++) {
				final Token other = newList.get(j);
				code.add(point.x, other);
				point.x++;
				point.y++;
			}
		} else {
			final int type = token.getType();
			if (normal || (type != InternalPreprocessLexer.RULE_WHITESPACE)) {
				List<Token> list = new ArrayList<Token>();
				list.add(token);
				if (normal) {
					// list = this.definitionTable.resolve(this.lastId, list);
				}
				for (int i = 0; i < list.size(); i++) {
					final Token newToken = list.get(i);
					code.add(point.x, newToken);
					point.x++;
					point.y++;
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
			Token token = list.get(i);
			result.add(token);
		}
		return result;
	}

	private void addStringifyReplacement(final long parenID,
			final List<Token> code, final Point point, final Token token,
			final String text, final List<ArrayList<Token>> replace) {
		MyLog.trace("addStringifyReplacement-start('" + parenID + "'), text='"
				+ text + "'");
		TokenListUtils.printList(replace);
		TokenListUtils.print(this.replacements);

		final StringBuffer buffer = new StringBuffer("");
		if (this.contains(text)) {
			final ArrayList<Token> list = this.getList(text, replace);
			TokenListUtils.print(list);
			for (int j = 0; j < list.size(); j++) {
				final Token other = list.get(j);
				final String otherText = other.getText();
				buffer.append(otherText);
			}
		} else {
			buffer.append(text);
		}
		MyLog.trace("addStringifyReplacement-end('" + parenID + "'), text='"
				+ text + "', buffer='" + buffer.toString() + "'");
		final Token newToken = this.getDoubleQuoteToken(buffer);
		code.add(point.x, newToken);
		point.x++;
		point.y++;
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
			final List<Token> code, final Point point, final Token token,
			final String text, final List<ArrayList<Token>> replace) {
		MyLog.trace("addConcatenReplacement at '" + point.x + "' on token='"
				+ text + "'");
		for (int i = point.x; (i > 0) && (i < code.size()); i--) {
			final Token prev = code.get(i);
			final int type = prev.getType();
			if (type == InternalPreprocessLexer.RULE_WHITESPACE) {
				code.remove(i);
				point.x--;
				point.y--;
			}
		}
		this.addNormalReplacement(parenID, code, point, token, text, replace,
				false);
	}

}
