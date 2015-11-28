package at.jku.weiner.c.preprocess.utils;

import java.util.regex.Matcher;

public interface StringLiteralInStringLiteralsVisitor {

	public void visitBefore(String text);

	public void visit(final Matcher matcher, int currIndex, int start, int end);

	public void visitAfter(int currIndex);

}
