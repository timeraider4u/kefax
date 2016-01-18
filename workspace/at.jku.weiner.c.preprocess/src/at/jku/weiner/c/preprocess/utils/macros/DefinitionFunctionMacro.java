package at.jku.weiner.c.preprocess.utils.macros;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;

import at.jku.weiner.c.preprocess.parser.antlr.internal.InternalPreprocessLexer;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.utils.LexerUtils;
import at.jku.weiner.c.preprocess.utils.MyLog;

public final class DefinitionFunctionMacro implements DefinitionMacro {
	
	private final String key;
	private final List<String> idList;
	private final String value;
	private final List<Token> replacements;
	
	private long lastId = -1;
	private int lastIndex = -1;
	
	public DefinitionFunctionMacro(final LexerUtils lexerUtils,
			final String key, final IdentifierList idList, final String replace) {
		this.key = key;
		this.value = (replace == null) ? "" : replace;
		this.replacements = lexerUtils.getTokens(this.value);
		this.idList = ((idList == null) ? new ArrayList<String>() : idList
				.getId());
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
	public boolean resolve(final long id, final List<Token> code,
			final int currPosition) {
		this.initializeLastIdAndLastIndex(id);
		if (currPosition < this.lastIndex) {
			// prevent endless replacement loops
			return false;
		}
		final List<ArrayList<Token>> replace = this.initializeReplaceList();

		final int closingParenPosition = this.searchForClosingParen(code,
				currPosition, replace);
		this.removeWhitespaceFromList(replace);
		MyLog.debug("closingParenPosition='" + closingParenPosition + "'");
		if (currPosition == closingParenPosition) {
			return false;
		}
		// remove tokens of function-like invocation
		this.removeTokens(code, currPosition, closingParenPosition);
		// add replacement tokens
		final int index = this.addReplacementTokensToCode(code, currPosition,
				replace);

		this.lastIndex = index;
		return true;
	}
	
	private void initializeLastIdAndLastIndex(final long id) {
		if (this.lastId != id) {
			this.lastIndex = -1;
		}
		this.lastId = id;
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
			final int currPosition, final List<ArrayList<Token>> replace) {
		State currState = new State();
		int paramCount = 0;
		ArrayList<Token> list = this.getListForParamCount(replace, paramCount);
		for (int i = currPosition + 1; i < code.size(); i++) {
			final Token token = code.get(i);
			final int tokenType = token.getType();
			currState = this.getNextState(currState, tokenType);
			if (currState.state == MatchState.Invalid) {
				return currPosition;
			} else if (currState.state == MatchState.Done) {
				return i;
			} else if (currState.state == MatchState.LookingForRightParen) {
				// looking for right parenthese
				if (currState.openParens == 1) {
					if (tokenType == InternalPreprocessLexer.RULE_SKW_COMMA) {
						paramCount++;
						list = this.getListForParamCount(replace, paramCount);
					} else {
						list.add(token);
					}
				} else {
					list.add(token);
				}
			}
		}
		throw new MacroParentheseNotClosedYetException(code, code.size());
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
			return new ArrayList<Token>();
		}
		return replace.get(paramCount);
	}

	private void removeTokens(final List<Token> code, final int currPosition,
			final int closingParenPosition) {
		for (int i = closingParenPosition; (i >= currPosition); i--) {
			code.remove(i);
		}
	}

	private void removeWhitespaceFromList(final List<ArrayList<Token>> replace) {
		for (int i = 0; i < replace.size(); i++) {
			final ArrayList<Token> list = replace.get(i);
			for (final int j = 0; ((j < list.size()) && this.isWhitespace(list,
					j));) {
				list.remove(j);
			}
			for (final int j = list.size() - 1; ((j > 0) && (j < list.size()) && this
					.isWhitespace(list, j));) {
				list.remove(j);
			}
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
	}

	private boolean isWhitespace(final ArrayList<Token> list, final int index) {
		final Token token = list.get(index);
		final int type = token.getType();
		return (type == InternalPreprocessLexer.RULE_WHITESPACE);
	}

	private enum ReplacementState {
		Invalid, Normal, Stringify, StringifyEnd, Concatenate, ConcatenateEnd,
	}

	private int addReplacementTokensToCode(final List<Token> code,
			final int currPosition, final List<ArrayList<Token>> replace) {
		int index = currPosition;
		ReplacementState state = ReplacementState.Normal;
		for (int i = 0; i < this.replacements.size(); i++) {
			final Token token = this.replacements.get(i);
			final String text = token.getText();
			final int tokenType = token.getType();
			state = this.calculateNextState(state, code, tokenType);
			switch (state) {
				case Normal:
					index = this.addNormalReplacement(code, index, token, text,
							replace);
					break;
				case StringifyEnd:
					index = this.addStrinifyReplacement(code, index, token,
							text, replace);
				default:
					break;
			}
		}
		return index;
	}

	private ReplacementState calculateNextState(ReplacementState currState,
			final List<Token> code, final int tokenType) {
		switch (currState) {
			case Normal: {
				if (tokenType == InternalPreprocessLexer.RULE_HASH) {
					currState = ReplacementState.Stringify;
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

	private int addNormalReplacement(final List<Token> code, int index,
			final Token token, final String text,
			final List<ArrayList<Token>> replace) {
		if (this.idList.contains(text)) {
			final int argIndex = this.idList.indexOf(text);
			final ArrayList<Token> list = replace.get(argIndex);
			for (int j = 0; j < list.size(); j++) {
				final Token other = list.get(j);
				code.add(index, other);
				index++;
			}
		} else {
			code.add(index, token);
			index++;
		}
		return index;
	}

	private int addStrinifyReplacement(final List<Token> code, int index,
			final Token token, final String text,
			final List<ArrayList<Token>> replace) {
		final StringBuffer buffer = new StringBuffer("");
		if (this.idList.contains(text)) {
			final int argIndex = this.idList.indexOf(text);
			final ArrayList<Token> list = replace.get(argIndex);
			for (int j = 0; j < list.size(); j++) {
				final Token other = list.get(j);
				final String otherText = other.getText();
				buffer.append(otherText);
			}
		} else {
			buffer.append(text);
		}
		final Token newToken = this.getDoubleQuoteToken(buffer);
		code.add(index, newToken);
		index++;
		return index;
	}

	private Token getDoubleQuoteToken(final StringBuffer buffer) {
		buffer.insert(0, '"');
		buffer.append('"');
		final String text = buffer.toString();
		final String text2 = text.trim();
		final Token token = new CommonToken(
				InternalPreprocessLexer.RULE_SKW_DOUBLEQUOTE, text2);
		return token;
	}

}
