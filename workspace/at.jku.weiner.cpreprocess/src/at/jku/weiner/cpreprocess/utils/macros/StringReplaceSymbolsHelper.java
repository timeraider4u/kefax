package at.jku.weiner.cpreprocess.utils.macros;

import java.util.regex.Matcher;

import at.jku.weiner.cpreprocess.utils.StringLiteralInStringLiteralsVisitor;

public class StringReplaceSymbolsHelper implements
StringLiteralInStringLiteralsVisitor {
	StringBuffer result = new StringBuffer("");
	private final String symbol;
	private final String replacement;
	private String text;

	public StringReplaceSymbolsHelper(final String symbol,
			final String replacement) {
		this.symbol = symbol;
		this.replacement = replacement;
	}

	@Override
	public void visitBefore(final String text) {
		this.text = text;
		this.result = new StringBuffer("");
	}

	@Override
	public void visit(final Matcher matcher, final int currIndex,
			final int start, final int end) {
		final String match = this.text.substring(start, end);
		final String str = this.text.substring(currIndex, start);
		final String str2 = this.replace(str, this.symbol, this.replacement);

		// System.out.println("mymatch='" + match + "'");

		// System.out.println("str='" + str + "'");
		// System.out.println("str2='" + str2 + "'");
		this.result.append(str2);
		this.result.append(match);
	}

	@Override
	public void visitAfter(final int currIndex) {
		final String str = this.text.substring(currIndex);
		final String str2 = this.replace(str, this.symbol, this.replacement);
		// System.out.println("str-2='" + str + "'");
		// System.out.println("str2-2='" + str2 + "'");
		this.result.append(str2);
		// return result.toString();
	}

	private String replace(final String string, final String symbol,
			final String replacement) {
		// return string.replace(symbol, replacement);
		return string.replaceAll("\\b" + symbol + "\\b", replacement);
		// "(?=\\W+|^)"+Pattern.quote("[69-3]")+"(?=\\W+|$)"
	}

	public String getText() {
		return this.result.toString();
	}

}
