package at.jku.weiner.cpreprocess.utils.macros;

import java.util.regex.Matcher;

import at.jku.weiner.cpreprocess.utils.StringLiteralInStringLiteralsVisitor;

public class StringMatchingSymbolsHelper implements
StringLiteralInStringLiteralsVisitor {

	private boolean contains = false;
	private final String regex;
	private String text;

	public StringMatchingSymbolsHelper(final String regex) {
		this.regex = regex;
	}

	@Override
	public void visitBefore(final String text) {
		this.text = text;
		this.contains = false;
	}

	@Override
	public void visit(final Matcher matcher, final int currIndex,
			final int start, final int end) {
		final String str = this.text.substring(currIndex, start);
		if (str.matches(this.regex)) {
			this.contains = true;
		}
	}

	@Override
	public void visitAfter(final int currIndex) {
		final String str = this.text.substring(currIndex);
		if (str.matches(this.regex)) {
			this.contains = true;
		}
	}

	public boolean contains() {
		return this.contains;
	}

}
