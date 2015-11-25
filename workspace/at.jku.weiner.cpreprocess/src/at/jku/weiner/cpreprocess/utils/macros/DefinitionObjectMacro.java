package at.jku.weiner.cpreprocess.utils.macros;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import at.jku.weiner.cpreprocess.utils.StringReplaceSymbolsHelper;

class DefinitionObjectMacro implements DefinitionMacro {

	private final String key;
	private final String value;
	private final Pattern pattern;

	public DefinitionObjectMacro(final String key, final String value) {
		this.key = key;
		this.value = this.getValue(value);
		this.pattern = Pattern.compile("\\b" + key + "\\b");
	}

	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof DefinitionObjectMacro)) {
			return false;
		}
		final DefinitionObjectMacro other = (DefinitionObjectMacro) obj;
		if (!(this.key.equals(other.key))) {
			return false;
		}
		return this.value.equals(other.value);
	}

	private String getValue(String value2) {
		if (value2 == null) {
			value2 = "";
		}
		return value2;
	}

	@Override
	public String resolve(final String code) {
		if (!this.matches(code)) {
			return code;
		}
		return StringReplaceSymbolsHelper.replaceAndIgnoreQuotes(code,
				this.key, this.value);
	}

	@Override
	public boolean matches(final String code) {
		final Matcher matcher = this.pattern.matcher(code);
		return matcher.find();
	}

	@Override
	public String getName() {
		return this.key;
	}

}
