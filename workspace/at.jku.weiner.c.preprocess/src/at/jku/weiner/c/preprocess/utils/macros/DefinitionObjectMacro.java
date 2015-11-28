package at.jku.weiner.c.preprocess.utils.macros;

import java.util.regex.Pattern;

import at.jku.weiner.c.preprocess.utils.StringLiteralInStringLiteralsHelper;

class DefinitionObjectMacro implements DefinitionMacro {

	private final String macroID;
	private final String replacement;
	private final String regex;
	private final Pattern pattern;
	private final StringReplaceSymbolsHelper helper;
	private final StringMatchingSymbolsHelper matcher;

	public DefinitionObjectMacro(final String key, final String value) {
		this.macroID = key;
		this.replacement = this.getValue(value);
		this.regex = "\\b" + key + "\\b";
		this.pattern = Pattern.compile(this.regex);
		this.helper = new StringReplaceSymbolsHelperDefaultReplace(
				this.macroID, this.replacement);
		this.matcher = new StringMatchingSymbolsHelper(this.pattern);
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
	}

	@Override
	public String getName() {
		return this.macroID;
	}

}
