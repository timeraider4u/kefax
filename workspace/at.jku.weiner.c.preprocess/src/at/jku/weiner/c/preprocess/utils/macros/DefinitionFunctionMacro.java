package at.jku.weiner.c.preprocess.utils.macros;

import java.util.ArrayList;
import java.util.List;

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
		if (this.lastId != id) {
			this.lastIndex = -1;
		}
		this.lastId = id;
		if (currPosition < this.lastIndex) {
			// prevent endless replacement loops
			return false;
		}
		final List<ArrayList<Token>> replace = new ArrayList<ArrayList<Token>>();
		for (int i = 0; i < this.idList.size(); i++) {
			final ArrayList<Token> list = new ArrayList<Token>();
			replace.add(list);
		}
		
		final int closingParenPosition = this.searchForClosingParen(code,
				currPosition, replace);
		MyLog.debug("closingParenPosition='" + closingParenPosition + "'");
		if (currPosition == closingParenPosition) {
			return false;
		}
		// remove tokens of function-like invocation
		for (int i = closingParenPosition; (i >= currPosition); i--) {
			code.remove(i);
		}
		// add replacement tokens
		int index = currPosition;
		for (int i = 0; i < this.replacements.size(); i++) {
			final Token token = this.replacements.get(i);
			final String text = token.getText();
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
		}
		
		this.lastIndex = index;
		return true;
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
		ArrayList<Token> list = replace.get(paramCount);

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
				if ((currState.openParens == 1)
						&& (tokenType == InternalPreprocessLexer.RULE_SKW_COMMA)) {
					paramCount++;
					list = replace.get(paramCount);
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
	
	// private int searchForClosingParen(final String originalText,
	// final String code, final StringBuffer result, int i) {
	// MatchState state = MatchState.Normal;
	// final List<String> params = new ArrayList<String>();
	// StringBuffer param = new StringBuffer("");
	// for (; i < code.length(); i++) {
	// final char c = code.charAt(i);
	// state = MatchUtils.calculateNextState(c, state);
	// if (state == MatchState.Normal) {
	// if (c == ')') {
	// this.openParens--;
	// if ((c == ')') && (this.openParens == 0)) {
	// final String paramStr = param.toString();
	// params.add(paramStr);
	// this.startReplacement(originalText, result, params);
	// return i;
	// }
	// param.append(c);
	// } else if ((c == ',') && (this.openParens == 1)) {
	// // found another parameter
	// final String paramStr = param.toString();
	// params.add(paramStr);
	// param = new StringBuffer("");
	// } else if (c == '(') {
	// this.openParens++;
	// param.append(c);
	// } else {
	// param.append(c);
	// }
	// } else {
	// param.append(c);
	// }
	// }
	// // should never get here
	// throw new MacroParentheseNotClosedYetException(code, i);
	// }
	//
	// private void startReplacement(final String originalText,
	// final StringBuffer result, final List<String> params) {
	// if (this.list == null) {
	// result.append(this.defaultValue);
	// return;
	// }
	// if (this.replacements == null) {
	// result.append(this.defaultValue);
	// return;
	// }
	//
	// final StringBuffer temp = new StringBuffer("");
	// boolean concatenate = false;
	// for (int i = 0; i < this.replacements.size(); i++) {
	// final ReplaceLine line = this.replacements.get(i);
	// String string = line.getString();
	// if (string == null) {
	// string = "";
	// }
	// MyLog.debug("id='" + this.key + "' i='" + i + "', string=' "
	// + string + "', temp='" + temp.toString() + "'");
	// String id = line.getId();
	//
	// int j;
	// for (j = 0; j < this.list.size(); j++) {
	// final String key = this.list.get(j).trim();
	// final String orig = params.get(j).trim();
	// final String val = DefinitionTable.fullResolve(orig);
	// final DefinitionObjectMacro macro = new DefinitionObjectMacro(
	// key, val);
	// MyLog.debug("key='" + key + "', orig='" + orig + "', val='"
	// + val + "'");
	// string = this.resolveWithRespectToConcate(originalText, macro,
	// string, line.isConcatenate(), concatenate, orig);
	// MyLog.debug("id='" + this.key + "' i='" + i
	// + "', string-after-resolve=' " + string + "', temp='"
	// + temp.toString() + "'");
	// if (id != null) {
	// if (id.equals(key)) {
	// id = orig;
	// }
	// // id = macro.resolve(id);
	// }
	// }
	//
	// if (this.isVariadic) {
	// String key = null;
	// if (this.varID == null) {
	// key = "__VA_ARGS__";
	// } else {
	// key = this.varID;
	// }
	// final StringBuffer orig = new StringBuffer("");
	// final StringBuffer variadic = new StringBuffer("");
	// boolean isFirst = true;
	// for (; j < params.size(); j++) {
	// if (!isFirst) {
	// orig.append(", ");
	// variadic.append(", ");
	// }
	// final String origVal = params.get(j).trim();
	// final String val = DefinitionTable.fullResolve(origVal);
	// variadic.append(val);
	// orig.append(origVal);
	// isFirst = false;
	// }
	// final DefinitionObjectMacro macro = new DefinitionObjectMacro(
	// key, variadic.toString());
	// // string = macro.resolve(string);
	// string = this.resolveWithRespectToConcate(originalText, macro,
	// string, line.isConcatenate(), concatenate,
	// orig.toString());
	// if (id != null) {
	// if (id.equals(key)) {
	// id = orig.toString();
	// }
	// }
	// }
	// // concatenation
	// if (concatenate) {
	// string = string.replaceAll("^\\s+", "");
	// }
	// // concatenation - prepare for next loop
	// if (line.isConcatenate()) {
	// concatenate = true;
	// string = string.replaceAll("\\s+$", "");
	// } else {
	// concatenate = false;
	// }
	// temp.append(string);
	// // stringify
	// if (id != null) {
	// final String newStr = id.replace("\\\"", "\\\\\"").replace(
	// "\"", "\\\"");
	// temp.append("\"");
	// temp.append(newStr);
	// temp.append("\"");
	// }
	// }
	// final String myTemp = temp.toString().trim();
	// final String temp2 = DefinitionTable.fullResolve(myTemp);
	// result.append(temp2);
	// }
	//
	// private String resolveWithRespectToConcate(final String original,
	// final DefinitionObjectMacro macro, final String string,
	// final boolean concatFirst, final boolean concatSecond,
	// final String orig) {
	// String result = macro.resolve(original, string);
	// if (!concatFirst && !concatSecond) {
	// return result;
	// }
	// final String myKey = macro.getName();
	// final DefinitionObjectMacro macro2 = new DefinitionObjectMacro(myKey,
	// orig);
	// if (concatFirst) {
	// MyLog.debug("concatFirst!");
	// final Pattern pattern = Pattern.compile("\\b" + macro.getName()
	// + "\\s*$");
	// final Matcher matcher = pattern.matcher(string);
	// if (!matcher.find()) {
	// return result;
	// }
	// final String string1 = macro.resolve(original,
	// string.substring(0, matcher.start()));
	// String string2 = string.substring(matcher.start(), matcher.end());
	// string2 = macro2.resolve(original, string2);
	// result = string1 + string2;
	// MyLog.debug("key='" + this.key + "', orig='" + orig + "'");
	// MyLog.debug("string1='" + string1 + "'");
	// MyLog.debug("string2='" + string2 + "'");
	// MyLog.debug("result='" + result + "'");
	// }
	//
	// if (concatSecond) {
	// MyLog.debug("concatSecond!");
	// MyLog.debug("string='" + string + "'");
	// final Pattern pattern = Pattern.compile("^\\s*" + macro.getName()
	// + "\\b");
	// final Matcher matcher = pattern.matcher(string);
	// if (!matcher.find()) {
	// return result;
	// }
	// String string1 = string.substring(matcher.start(), matcher.end());
	// string1 = macro2.resolve(original, string1);
	// MyLog.debug("matcher.end()='" + matcher.end() + "'");
	// MyLog.debug("string.length()='" + string.length() + "'");
	// final String string2 = macro.resolve(original,
	// string.substring(matcher.end(), string.length()));
	// result = string1 + string2;
	// }
	// return result;
	// }
	//
	// private String resolveConcatenationAndStringification(final String temp)
	// {
	// if (!temp.contains("#")) {
	// return temp;
	// }
	// MyLog.debug("temp='" + temp + "'");
	// final Pattern strPattern = Pattern.compile("#[\\s]*([\\w\\\"\\\\]*)");
	// final Matcher strMatcher = strPattern.matcher(temp);
	// final Pattern conPattern = Pattern.compile("[\\s]*##[\\s]*");
	// final Matcher conMatcher = conPattern.matcher(temp);
	// if (!strMatcher.find(0) && !conMatcher.find(0)) {
	// return temp;
	// }
	// MatchState state = MatchState.Normal;
	// final StringBuffer result = new StringBuffer("");
	// int nextStrMatchStartIndex = -1;
	// int nextStrMatchEndIndex = -1;
	// int nextConMatchStartIndex = -1;
	// int nextConMatchEndIndex = -1;
	//
	// if (strMatcher.find(0)) {
	// nextStrMatchStartIndex = strMatcher.start();
	// nextStrMatchEndIndex = strMatcher.end();
	// }
	// if (conMatcher.find(0)) {
	// nextConMatchStartIndex = conMatcher.start();
	// nextConMatchEndIndex = conMatcher.end();
	// }
	// for (int i = 0; i < temp.length(); i++) {
	// final char c = temp.charAt(i);
	// state = MatchUtils.calculateNextState(c, state);
	// if (state == MatchState.Normal) {
	// if (i == nextConMatchStartIndex) {
	// // concatenation
	// i = nextConMatchEndIndex - 1;
	// } else if (i == nextStrMatchStartIndex) {
	// // stringification
	// final String group2 = strMatcher.group(1);
	// final String replace = group2.replace("\\", "\\\\");
	// String str = replace.replace("\"", "\\\"");
	// // str = DefinitionTable.resolve(str);
	// str = "\"" + str + "\"";
	// result.append(str);
	// i = nextStrMatchEndIndex - 1;
	// if (group2.isEmpty()) {
	// result.append(" ");
	// }
	// } else {
	// result.append(c);
	// }
	// } else if (!strMatcher.find(i) && !(conMatcher.find(i))) {
	// result.append(temp.substring(i));
	// return result.toString();
	// } else {
	// result.append(c);
	// }
	//
	// if (strMatcher.find(i)) {
	// nextStrMatchStartIndex = strMatcher.start();
	// nextStrMatchEndIndex = strMatcher.end();
	// }
	// if (conMatcher.find(i)) {
	// nextConMatchStartIndex = conMatcher.start();
	// nextConMatchEndIndex = conMatcher.end();
	// }
	// }
	// return result.toString().trim();
	// }

}
