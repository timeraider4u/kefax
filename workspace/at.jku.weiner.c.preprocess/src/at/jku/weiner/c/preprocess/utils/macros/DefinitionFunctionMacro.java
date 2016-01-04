package at.jku.weiner.c.preprocess.utils.macros;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import at.jku.weiner.c.preprocess.preprocess.IdentifierList;

public final class DefinitionFunctionMacro implements DefinitionMacro {

	private static final String REGEX = "\\s*\\(";

	private final String key;
	private final String value;
	private final List<String> list;
	private final Pattern pattern;
	private int openParens = 0;
	private final boolean isVariadic;

	public DefinitionFunctionMacro(final String key, final String value,
			final IdentifierList idList) {
		if (idList == null) {
			this.list = null;
			this.isVariadic = false;
		} else {
			this.list = idList.getId();
			this.isVariadic = idList.isVariadic();
		}
		this.key = key;
		this.value = this.getValue(value);
		this.pattern = Pattern.compile("\\b" + this.key + "\\b"
				+ DefinitionFunctionMacro.REGEX);
	}

	private String getValue(String value2) {
		if (value2 == null) {
			value2 = "";
		}
		return value2;
	}

	@Override
	public String getName() {
		return this.key;
	}

	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof DefinitionFunctionMacro)) {
			return false;
		}
		final DefinitionFunctionMacro other = (DefinitionFunctionMacro) obj;
		if (!this.key.equals(other.key)) {
			return false;
		}
		if (!this.value.equals(other.value)) {
			return false;
		}
		if ((this.list == null) && (other.list != null)) {
			return false;
		}
		if ((this.list != null) && (other.list == null)) {
			return false;
		}
		if ((this.list == null) && (other.list == null)) {
			return true;
		}
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
		return true;
	}

	@Override
	public boolean matches(final String code) {
		return MatchUtils.matches(code, this.pattern);
	}

	@Override
	public String resolve(final String code) {
		final Matcher matcher = this.pattern.matcher(code);
		if (!matcher.find()) {
			return code;
		}
		final StringBuffer result = new StringBuffer("");
		MatchState state = MatchState.Normal;
		this.openParens = 0;
		int nextMatchStartIndex = matcher.start();
		int nextMatchEndIndex = matcher.end();
		for (int i = 0; i < code.length(); i++) {
			final char c = code.charAt(i);
			state = MatchUtils.calculateNextState(c, state);
			if ((state == MatchState.Normal) && (i == nextMatchStartIndex)) {
				this.openParens++;
				i = this.searchForClosingParen(code, result, nextMatchEndIndex);
			} else if (!matcher.find(i)) {
				result.append(code.substring(i));
				return result.toString();
			} else {
				result.append(c);
			}
			nextMatchStartIndex = matcher.start();
			nextMatchEndIndex = matcher.end();
		}
		return result.toString();
	}

	private int searchForClosingParen(final String code,
			final StringBuffer result, int i) {
		MatchState state = MatchState.Normal;
		final List<String> params = new ArrayList<String>();
		StringBuffer param = new StringBuffer("");
		for (; i < code.length(); i++) {
			final char c = code.charAt(i);
			state = MatchUtils.calculateNextState(c, state);
			if (state == MatchState.Normal) {
				if (c == ')') {
					this.openParens--;
					if ((c == ')') && (this.openParens == 0)) {
						final String paramStr = param.toString();
						params.add(paramStr);
						this.startReplacement(result, params);
						return i;
					}
					param.append(c);
				} else if ((c == ',') && (this.openParens == 1)) {
					// found another parameter
					final String paramStr = param.toString();
					params.add(paramStr);
					param = new StringBuffer("");
				} else if (c == '(') {
					this.openParens++;
					param.append(c);
				} else {
					param.append(c);
				}
			} else {
				param.append(c);
			}
		}
		// should never get here
		throw new MacroParentheseNotClosedYetException(code, i);
	}

	private void startReplacement(final StringBuffer result,
			final List<String> params) {
		if (this.list == null) {
			result.append(this.value);
			return;
		}

		String temp = this.value;
		int i;
		for (i = 0; i < this.list.size(); i++) {
			final String key = this.list.get(i).trim();
			String val = params.get(i).trim();
			val = DefinitionTable.resolve(val);
			final DefinitionObjectMacro macro = new DefinitionObjectMacro(key,
					val);
			temp = macro.resolve(temp);
		}

		if (this.isVariadic) {
			final String key = "__VA_ARGS__";
			final StringBuffer variadic = new StringBuffer("");
			boolean isFirst = true;
			for (; i < params.size(); i++) {
				if (!isFirst) {
					variadic.append(", ");
				}
				String val = params.get(i).trim();
				val = DefinitionTable.resolve(val);
				variadic.append(val);
				isFirst = false;
			}
			final DefinitionObjectMacro macro = new DefinitionObjectMacro(key,
					variadic.toString());
			temp = macro.resolve(temp);
		}

		temp = this.resolveConcatenationAndStringification(temp);

		result.append(temp);
	}

	private String resolveConcatenationAndStringification(final String temp) {
		if (!temp.contains("#")) {
			return temp;
		}
		// System.out.println("temp='" + temp + "'");
		final Pattern strPattern = Pattern.compile("#[\\s]*([\\w\\\"\\\\]*)");
		final Matcher strMatcher = strPattern.matcher(temp);
		final Pattern conPattern = Pattern.compile("[\\s]*##[\\s]*");
		final Matcher conMatcher = conPattern.matcher(temp);
		if (!strMatcher.find(0) && !conMatcher.find(0)) {
			return temp;
		}
		MatchState state = MatchState.Normal;
		final StringBuffer result = new StringBuffer("");
		int nextStrMatchStartIndex = -1;
		int nextStrMatchEndIndex = -1;
		int nextConMatchStartIndex = -1;
		int nextConMatchEndIndex = -1;

		if (strMatcher.find(0)) {
			nextStrMatchStartIndex = strMatcher.start();
			nextStrMatchEndIndex = strMatcher.end();
		}
		if (conMatcher.find(0)) {
			nextConMatchStartIndex = conMatcher.start();
			nextConMatchEndIndex = conMatcher.end();
		}
		for (int i = 0; i < temp.length(); i++) {
			final char c = temp.charAt(i);
			state = MatchUtils.calculateNextState(c, state);
			if (state == MatchState.Normal) {
				if (i == nextConMatchStartIndex) {
					// concatenation
					i = nextConMatchEndIndex - 1;
				} else if (i == nextStrMatchStartIndex) {
					// stringification
					final String group2 = strMatcher.group(1);
					final String replace = group2.replace("\\", "\\\\");
					String str = replace.replace("\"", "\\\"");
					// str = DefinitionTable.resolve(str);
					str = "\"" + str + "\"";
					result.append(str);
					i = nextStrMatchEndIndex - 1;
					if (group2.isEmpty()) {
						result.append(" ");
					}
				} else {
					result.append(c);
				}
			} else if (!strMatcher.find(i) && !(conMatcher.find(i))) {
				result.append(temp.substring(i));
				return result.toString();
			} else {
				result.append(c);
			}

			if (strMatcher.find(i)) {
				nextStrMatchStartIndex = strMatcher.start();
				nextStrMatchEndIndex = strMatcher.end();
			}
			if (conMatcher.find(i)) {
				nextConMatchStartIndex = conMatcher.start();
				nextConMatchEndIndex = conMatcher.end();
			}
		}
		return result.toString().trim();
	}
}
