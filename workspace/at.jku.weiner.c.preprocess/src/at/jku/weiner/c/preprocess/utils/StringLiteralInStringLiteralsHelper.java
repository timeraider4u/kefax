package at.jku.weiner.c.preprocess.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringLiteralInStringLiteralsHelper {
	// private static final String REGEX = "\"(?:\\\\\"|[^\"])*?\"";
	// private static final String REGEX = "\".*?\"";
	// private static final String REGEX = "\"([^\n\"\\]+|\\\\.)*\"";
	/***
	 * @see <a
	 *      href="http://stackoverflow.com/questions/18547501/regex-to-replace-all-string-literals-in-a-java-file/27225768#27225768">http://stackoverflow.com/questions/18547501/regex-to-replace-all-string-literals-in-a-java-file/27225768#27225768</a>
	 */
	private static final String REGEX = "\"(?:\\\\[\\\\'\"tnbfru01234567]|[^\\\\\"])*?\"";

	public static void iterate(final String text,
			final StringLiteralInStringLiteralsVisitor visitor) {
		final Pattern pattern = Pattern
				.compile(StringLiteralInStringLiteralsHelper.REGEX);
		final Matcher matcher = pattern.matcher(text);
		int currIndex = 0;
		visitor.visitBefore(text);
		while (matcher.find(currIndex)) {
			final int tempStart = matcher.start(); // StringReplaceSymbolsHelper
			// .StringReplaceSymbolsHelper.getNextMatcherStart(text,
			// matcher.start());
			final int tempEnd = matcher.end();
			visitor.visit(matcher, currIndex, tempStart, tempEnd);
			currIndex = tempEnd;
		}
		visitor.visitAfter(currIndex);
	}

	private static int getNextMatcherStart(final String string, final int start) {
		final char c = string.charAt(start);
		final boolean firstPartIsQuote = (c == '"');
		if (firstPartIsQuote) {
			return start;
		}
		return start + 1;
	}

}
