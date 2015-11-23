package at.jku.weiner.cpreprocess.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReplaceSymbolsHelper {
	// private static final String REGEX = "\"(?:\\\\\"|[^\"])*?\"";
	// private static final String REGEX = "\".*?\"";
	// private static final String REGEX = "\"([^\n\"\\]+|\\\\.)*\"";
	/***
	 * @see <a
	 *      href="http://stackoverflow.com/questions/18547501/regex-to-replace-all-string-literals-in-a-java-file/27225768#27225768">http://stackoverflow.com/questions/18547501/regex-to-replace-all-string-literals-in-a-java-file/27225768#27225768</a>
	 */
	private static final String REGEX = "\"(?:\\\\[\\\\'\"tnbfru01234567]|[^\\\\\"])*?\"";

	public static String replaceAndIgnoreQuotes(final String text,
			final String symbol, final String replacement) {
		final StringBuffer result = new StringBuffer("");
		final Pattern pattern = Pattern
				.compile(StringReplaceSymbolsHelper.REGEX);
		final Matcher matcher = pattern.matcher(text);
		int start = 0;
		while (matcher.find()) {
			final int tempStart = StringReplaceSymbolsHelper
					.getNextMatcherStart(text, matcher.start());
			final int tempEnd = matcher.end();
			final String match = text.substring(tempStart, tempEnd);

			// System.out.println("mymatch='" + match + "'");
			final String str = text.substring(start, tempStart);
			final String str2 = StringReplaceSymbolsHelper.replace(str, symbol,
					replacement);
			// System.out.println("str='" + str + "'");
			// System.out.println("str2='" + str2 + "'");
			result.append(str2);
			result.append(match);
			start = tempEnd;
		}
		final String str = text.substring(start);
		final String str2 = StringReplaceSymbolsHelper.replace(str, symbol,
				replacement);
		// System.out.println("str-2='" + str + "'");
		// System.out.println("str2-2='" + str2 + "'");
		result.append(str2);
		return result.toString();
	}

	private static int getNextMatcherStart(final String string, final int start) {
		final char c = string.charAt(start);
		final boolean firstPartIsQuote = (c == '"');
		if (firstPartIsQuote) {
			return start;
		}
		return start + 1;
	}

	private static String replace(final String string, final String symbol,
			final String replacement) {
		// return string.replace(symbol, replacement);
		return string.replaceAll("\\b" + symbol + "\\b", replacement);
		// "(?=\\W+|^)"+Pattern.quote("[69-3]")+"(?=\\W+|$)"
	}

}
