package at.jku.weiner.c.preprocess.utils.macros;

import java.util.List;
import java.util.regex.Pattern;

import org.antlr.runtime.Token;
import org.eclipse.emf.common.util.EList;

import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.utils.MyLog;

public final class DefinitionFunctionMacro implements DefinitionMacro {
	
	private static final String REGEX = "\\s*\\(";
	
	private final String key;
	private final List<String> list;
	private final Pattern pattern;
	private final int openParens = 0;
	private final boolean isVariadic;
	private final String varID;

	private final EList<ReplaceLine> replacements;
	private final String defaultValue;
	
	public DefinitionFunctionMacro(final String key,
			final IdentifierList idList, final EList<ReplaceLine> replacements) {
		if (idList == null) {
			this.list = null;
			this.isVariadic = false;
			this.varID = null;
		} else {
			this.list = idList.getId();
			this.isVariadic = idList.isVariadic();
			this.varID = idList.getVarID();
		}
		this.key = key;
		this.replacements = replacements;
		this.pattern = Pattern.compile("\\b" + this.key + "\\b"
				+ DefinitionFunctionMacro.REGEX);
		this.defaultValue = this.getDefaultValue();
	}
	
	private String getDefaultValue() {
		if (this.replacements == null) {
			return "";
		}
		final StringBuffer buffer = new StringBuffer("");
		for (final ReplaceLine line : this.replacements) {
			buffer.append(line.getString());
		}
		return buffer.toString().trim();
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
		if ((this.list == null) && (other.list != null)) {
			return false;
		}
		if ((this.list != null) && (other.list == null)) {
			return false;
		}
		if ((this.replacements == null) && (other.replacements != null)) {
			return false;
		}
		if ((this.replacements != null) && (other.replacements == null)) {
			return false;
		}
		if (this.list != null) {
			if (this.list.size() != other.list.size()) {
				return false;
			}
			for (int i = 0; i < this.list.size(); i++) {
				final String param1 = this.list.get(i);
				final String param2 = other.list.get(i);
				if (!(param1.equals(param2))) {
					return false;
				}
			}
		}
		if (this.replacements != null) {
			if ((this.replacements.size() != other.replacements.size())) {
				return false;
			}
			final StringBuffer buffer1 = new StringBuffer("");
			final StringBuffer buffer2 = new StringBuffer("");
			for (int i = 0; i < this.replacements.size(); i++) {
				final ReplaceLine line1 = this.replacements.get(i);
				final ReplaceLine line2 = other.replacements.get(i);
				String str1 = line1.getString();
				if (str1 != null) {
					str1 = str1.trim();
				}
				String id1 = line1.getId();
				if (id1 != null) {
					id1 = id1.trim();
				}
				
				String str2 = line2.getString();
				if (str2 != null) {
					str2 = str2.trim();
				}
				String id2 = line2.getId();
				if (id2 != null) {
					id2 = id2.trim();
				}
				buffer1.append(str1);
				buffer2.append(str2);
				buffer1.append(id1);
				buffer2.append(id2);
				buffer1.append(line1.isConcatenate());
				buffer2.append(line2.isConcatenate());
			}
			final String str1 = buffer1.toString();
			final String str2 = buffer2.toString();
			if (!str1.equals(str2)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public int resolve(final StringBuffer result, final List<Token> code,
			final int currPosition) {
		code.remove(currPosition);
		// final Matcher matcher = this.pattern.matcher(code);
		// if (!matcher.find()) {
		// return code;
		// }
		// final StringBuffer result = new StringBuffer("");
		// MatchState state = MatchState.Normal;
		// this.openParens = 0;
		// int nextMatchStartIndex = matcher.start();
		// int nextMatchEndIndex = matcher.end();
		// for (int i = 0; i < code.length(); i++) {
		// final char c = code.charAt(i);
		// state = MatchUtils.calculateNextState(c, state);
		// if ((state == MatchState.Normal) && (i == nextMatchStartIndex)) {
		// this.openParens++;
		// i = this.searchForClosingParen(originalText, code, result,
		// nextMatchEndIndex);
		// } else if (!matcher.find(i)) {
		// result.append(code.substring(i));
		// return result.toString();
		// } else {
		// result.append(c);
		// }
		// nextMatchStartIndex = matcher.start();
		// nextMatchEndIndex = matcher.end();
		// }
		// return result.toString();
		return currPosition + 1;
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
