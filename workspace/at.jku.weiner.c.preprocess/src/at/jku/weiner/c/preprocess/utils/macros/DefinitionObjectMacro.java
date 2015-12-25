package at.jku.weiner.c.preprocess.utils.macros;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DefinitionObjectMacro implements DefinitionMacro {
	
	private final String macroID;
	private final String replacement;
	private final String regex;
	private final Pattern pattern;
	
	public DefinitionObjectMacro(final String key, final String value) {
		this.macroID = key;
		this.replacement = this.getValue(value);
		this.regex = "\\b" + key + "\\b";
		this.pattern = Pattern.compile(this.regex);
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof DefinitionObjectMacro)) {
			return false;
		}
		final DefinitionObjectMacro other = (DefinitionObjectMacro) obj;
		if (!(this.macroID.equals(other.macroID))) {
			return false;
		}
		return this.replacement.equals(other.replacement);
	}
	
	private String getValue(String value2) {
		if (value2 == null) {
			value2 = "";
		}
		return value2;
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
		int nextMatchStartIndex = matcher.start();
		int nextMatchEndIndex = matcher.end();
		for (int i = 0; i < code.length(); i++) {
			final char c = code.charAt(i);
			state = MatchUtils.calculateNextState(c, state);
			if ((state == MatchState.Normal) && (i == nextMatchStartIndex)) {
				result.append(this.replacement);
				i = nextMatchEndIndex - 1;
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
	
	@Override
	public String getName() {
		return this.macroID;
	}
	
}
