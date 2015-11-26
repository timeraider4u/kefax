package at.jku.weiner.cpreprocess.utils.macros;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import at.jku.weiner.cpreprocess.utils.StringLiteralInStringLiteralsVisitor;

public class StringMatchingSymbolsHelper implements
		StringLiteralInStringLiteralsVisitor {

	private boolean contains = false;
	private String text;
	private final Pattern pattern;

	public StringMatchingSymbolsHelper(final Pattern pattern) {
		this.pattern = pattern;
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
		this.match(str);
	}

	@Override
	public void visitAfter(final int currIndex) {
		final String str = this.text.substring(currIndex);
		this.match(str);
	}

	private void match(final String text) {
		final Matcher matcher = this.pattern.matcher(text);
		if (matcher.find()) {
			this.contains = true;
		}
	}

	public boolean contains() {
		return this.contains;
	}

}
