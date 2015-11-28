package at.jku.weiner.c.preprocess.utils.macros;

public class StringReplaceSymbolsHelperDefaultReplace extends
		StringReplaceSymbolsHelper {

	private final String symbol;
	private final String replacement;

	public StringReplaceSymbolsHelperDefaultReplace(final String symbol,
			final String replacement) {
		this.symbol = symbol;
		this.replacement = replacement;
		if (this.replacement == null) {
			throw new IllegalArgumentException("replacement can not be null!");
		}
	}

	@Override
	protected String replace(final String string) {
		if (string == null) {
			return "";
		}
		// return string.replace(symbol, replacement);
		// "(?=\\W+|^)"+Pattern.quote("[69-3]")+"(?=\\W+|$)"
		return string.replaceAll("\\b" + this.symbol + "\\b", this.replacement);
	}

}
