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

	public DefinitionFunctionMacro(final String key, final String value,
			final IdentifierList list) {
		this(key, value, ((list == null) ? null : list.getId()));
	}
	
	public DefinitionFunctionMacro(final String key, final String value,
			final List<String> list) {
		this.list = list;
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
		for (int i = 0; i < this.list.size(); i++) {
			final String key = this.list.get(i).trim();
			final String val = params.get(i).trim();
			final DefinitionObjectMacro macro = new DefinitionObjectMacro(key,
					val);
			temp = macro.resolve(temp);
		}
		temp = this.resolveConcatenation(temp);
		temp = this.resolveStringification(temp);
		
		result.append(temp);
	}
	
	private String resolveConcatenation(String result) {
		if (!result.contains("#")) {
			return result;
		}
		result = result.replaceAll("\\s##\\s", "");
		return result;
	}
	
	private String resolveStringification(final String code) {
		if (!code.contains("#")) {
			return code;
		}
		final Pattern strPattern = Pattern.compile("#[\\s]*([\\w\\\"\\\\]+)");
		final Matcher strMatcher = strPattern.matcher(code);
		if (!strMatcher.find()) {
			return code;
		}
		MatchState state = MatchState.Normal;
		final StringBuffer result = new StringBuffer("");
		int nextMatchStartIndex = strMatcher.start();
		int nextMatchEndIndex = strMatcher.end();
		for (int i = 0; i < code.length(); i++) {
			final char c = code.charAt(i);
			state = MatchUtils.calculateNextState(c, state);
			if ((state == MatchState.Normal) && (i == nextMatchStartIndex)) {
				// do replacement!!!
				final String group2 = strMatcher.group(1);
				// final String replace = group2.replace("\\", "\\\\");
				final String str = "\"" + group2.replace("\"", "\\\"") + "\"";
				result.append(str);
				i = nextMatchEndIndex - 1;
			} else if (!strMatcher.find(i)) {
				result.append(code.substring(i));
				return result.toString();
			} else {
				result.append(c);
			}
			nextMatchStartIndex = strMatcher.start();
			nextMatchEndIndex = strMatcher.end();
		}
		// code = code.replaceAll("#\\s*([^\\p{Space}]+)\\b", "\\\"$1\\\"");
		return result.toString();
	}
	
}
