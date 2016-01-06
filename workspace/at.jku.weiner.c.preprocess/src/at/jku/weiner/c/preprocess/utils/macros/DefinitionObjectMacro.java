package at.jku.weiner.c.preprocess.utils.macros;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DefinitionObjectMacro implements DefinitionMacro {

	private final String macroID;
	private final String replacement;
	private final String regex;
	private final Pattern pattern;
	private final boolean isIdentical;
	private final boolean valueContainsKey;
	private String lastExpansion = null;
	private String lastOriginal = null;

	public DefinitionObjectMacro(final String key, final String value) {
		this.macroID = key;
		this.replacement = this.getValue(value);
		this.regex = "\\b" + key + "\\b";
		this.pattern = Pattern.compile(this.regex);
		if (key.equals(value)) {
			this.isIdentical = true;
		} else {
			this.isIdentical = false;
		}
		if (this.replacement.matches(".*" + this.regex + ".*")) {
			this.valueContainsKey = true;
		} else {
			this.valueContainsKey = false;
		}
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
	public boolean matches(final String originalText, final String code) {
		if (!this.preCheck(originalText, code)) {
			return false;
		}
		return MatchUtils.matches(code, this.pattern);
	}

	private boolean preCheck(final String originalText, final String code) {
		if ((code == null) || code.isEmpty()) {
			return false;
		}
		if (this.isIdentical) {
			return false;
		}
		if ((this.valueContainsKey) && code.equals(this.lastExpansion)) {
			return false;
		}
		if ((this.valueContainsKey) && originalText.equals(this.lastOriginal)) {
			return false;
		}
		return true;
	}

	@Override
	public String resolve(final String originalText, final String code) {
		if (!this.preCheck(originalText, code)) {
			return code;
		}
		this.lastOriginal = originalText;
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
		this.lastExpansion = result.toString();
		return this.lastExpansion;
	}

	@Override
	public String getName() {
		return this.macroID;
	}

}
