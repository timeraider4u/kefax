package at.jku.weiner.c.preprocess.utils.macros;

import java.util.regex.Matcher;

import at.jku.weiner.c.preprocess.utils.StringLiteralInStringLiteralsVisitor;

public abstract class StringReplaceSymbolsHelper implements
		StringLiteralInStringLiteralsVisitor {
	StringBuffer result = new StringBuffer("");
	private String text;

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
		final String str2 = this.replace(str);
		// System.out.println("str='" + str + "'");
		// System.out.println("str2='" + str2 + "'");
		this.result.append(str2);
		this.result.append(match);
	}

	@Override
	public void visitAfter(final int currIndex) {
		final String str = this.text.substring(currIndex);
		final String str2 = this.replace(str);
		// System.out.println("str-2='" + str + "'");
		// System.out.println("str2-2='" + str2 + "'");
		this.result.append(str2);
		// return result.toString();
	}

	protected abstract String replace(final String string);

	public String getText() {
		return this.result.toString();
	}

}
