package at.jku.weiner.cpreprocess.generator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.eclipse.emf.common.util.EList;

import at.jku.weiner.cpreprocess.cPreprocess.IdentifierList;

class DefinitionFunctionMacro implements DefinitionMacro {

	private final String key;
	private final String value;
	private final IdentifierList idList;
	private final EList<String> list;

	public DefinitionFunctionMacro(final String key, final String value,
			final IdentifierList list) {
		this.idList = list;
		this.list = this.getList(list);
		this.key = key;
		this.value = this.getValue(value);
	}

	private String getValue(String value2) {
		if (value2 == null) {
			value2 = "";
		}
		return value2;
	}

	private EList<String> getList(final IdentifierList list) {
		if (this.idList == null) {
			return null;
		}
		return this.idList.getId();
	}

	@Override
	public String resolve(final String code) {
		if (this.list == null) {
			return this.resolveZeroArguments(code);
		}
		return this.resolveForParameters(code);
	}

	private String resolveZeroArguments(final String code) {
		final String result = code.replaceAll(this.key + "\\s*\\([\\s]*\\)",
				this.value);
		return result;
	}

	private String resolveForParameters(final String code) {
		final StringBuffer result = new StringBuffer("");
		final Pattern pattern = Pattern.compile(this.key + "\\s*\\(.*\\)");
		final Matcher matcher = pattern.matcher(code);

		int start = 0;
		while (matcher.find()) {
			final int tempStart = matcher.start();
			final int tempEnd = matcher.end();
			result.append(code.substring(start, tempStart));
			start = tempEnd;
			final String match = code.substring(tempStart, tempEnd);
			System.out.println("match='" + match + "'");
			final String replaceMatch = this.resolveForMatch(code, match);
			result.append(replaceMatch);
		}
		System.out.println("");
		result.append(code.substring(start));
		return result.toString();
	}

	private String resolveForMatch(final String code, final String match) {
		// final Pattern pattern = Pattern.compile(this.key + ".*)");
		// final Matcher matcher = pattern.matcher(code);
		String result = this.value;
		final String inner = this.getInner(match);
		int nextIndex = 0;
		int currIndex = 0;
		System.out.println("inner='" + inner + "'");
		for (final String param : this.list) {
			nextIndex = inner.indexOf(",", currIndex);
			if ((nextIndex < 0)) {
				nextIndex = inner.length();
			}
			final String paramValue = this.getParamValue(inner, currIndex,
					nextIndex);
			System.out.println("currIndex='" + currIndex + "'");
			System.out.println("nextIndex='" + nextIndex + "'");
			System.out.println("param='" + param + "'");
			System.out.println("paramValue='" + paramValue + "'");
			result = this.replaceAndIgnoreQuotes(result, param, paramValue);
			currIndex = nextIndex + 1;
		}
		System.out.println("-----------");
		return result;
	}

	/***
	 * Remove 'id', any whitespace characters and '(' at the start. Remove ')'
	 * at the end
	 */
	private String getInner(final String match) {
		final int start = match.indexOf("(");
		final String result = match.substring(start + 1, match.length() - 1);
		return result;
	}

	private String getParamValue(final String inner, final int currIndex,
			final int nextIndex) {
		final String paramValue = inner.substring(currIndex, nextIndex).trim();
		final String result = DefinitionTable.resolve(paramValue);
		return result;
	}

	private String replaceAndIgnoreQuotes(final String string,
			final String param, final String paramValue) {
		final StringBuffer result = new StringBuffer("");
		final String regex = "\"(?:\\\\\"|[^\"])*?\"";
		final Pattern pattern = Pattern
				// .compile("[^\\\\]?[\\\"].*[^\\\\]?[\\\"].*");
				.compile(regex);
		final Matcher matcher = pattern.matcher(string);
		int start = 0;
		while (matcher.find()) {
			final int tempStart = this.getNextMatcherStart(string,
					matcher.start());
			final int tempEnd = matcher.end();
			final String match = string.substring(tempStart, tempEnd);

			System.out.println("mymatch='" + match + "'");
			final String str = string.substring(start, tempStart);
			final String str2 = str.replace(param, paramValue);
			System.out.println("str='" + str + "'");
			System.out.println("str2='" + str2 + "'");
			result.append(str2);
			result.append(match);
			start = tempEnd;
		}
		final String str = string.substring(start);
		final String str2 = str.replace(param, paramValue);
		System.out.println("str-2='" + str + "'");
		System.out.println("str2-2='" + str2 + "'");
		result.append(str2);
		return result.toString();
		// return string.replace(param, paramValue);
	}

	private int getNextMatcherStart(final String string, final int start) {
		final char c = string.charAt(start);
		final boolean firstPartIsQuote = (c == '"');
		if (firstPartIsQuote) {
			return start;
		}
		return start + 1;
	}

}
