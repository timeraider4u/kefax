package at.jku.weiner.cpreprocess.utils.macros;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import at.jku.weiner.cpreprocess.utils.StringLiteralInStringLiteralsHelper;

class DefinitionObjectMacro implements DefinitionMacro {

	private final String key;
	private final String value;
	private final String regex;
	private final Pattern pattern;
	private final StringReplaceSymbolsHelper helper;
	private final StringMatchingSymbolsHelper matcher;

	public DefinitionObjectMacro(final String key, final String value) {
		this.key = key;
		this.value = this.getValue(value);
		this.regex = "\\b" + key + "\\b";
		this.pattern = Pattern.compile(this.regex);
		this.helper = new StringReplaceSymbolsHelper(key, value);
		this.matcher = new StringMatchingSymbolsHelper(this.regex);
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
		StringLiteralInStringLiteralsHelper.iterate(code, this.helper);
		return this.helper.getText();
	}

	@Override
	public boolean matches(final String code) {
		StringLiteralInStringLiteralsHelper.iterate(code, this.matcher);
		return this.matcher.contains();
		// final Matcher matcher = this.pattern.matcher(code);
		// return matcher.find();
	}

	@Override
	public String getName() {
		return this.key;
	}

}
