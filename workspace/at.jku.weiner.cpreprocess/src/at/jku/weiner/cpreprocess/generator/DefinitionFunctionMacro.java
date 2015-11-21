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
		this.key = key + "(";
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
		final StringBuffer result = new StringBuffer("");
		final Pattern pattern = Pattern.compile(this.key + ".*)");
		final Matcher matcher = pattern.matcher(code);

		int start = 0;
		while (matcher.find()) {
			final int tempStart = matcher.start();
			final int tempEnd = matcher.end() - 1;
			result.append(code.substring(start, tempStart));
			start = tempEnd;
			final String match = code.substring(tempStart, tempEnd);
			final String replaceMatch = this.replaceMatch(code, match);
			result.append(replaceMatch);
		}
		result.append(code.substring(start));
		return result.toString();
	}

	private String replaceMatch(final String code, final String match) {
		if (this.list == null) {
			return this.resolveZeroArguments(code, match);
		}
		return this.resolveForParameters(code, match);
	}

	private String resolveZeroArguments(final String code, final String match) {
		final String result = match.replace(this.key + ")", this.value);
		return result;
	}

	private String resolveForParameters(final String code, final String match) {
		// final Pattern pattern = Pattern.compile(this.key + ".*)");
		// final Matcher matcher = pattern.matcher(code);
		String result = this.value;
		final String inner = this.getInner(match);
		int nextIndex = 0;
		int currIndex = 0;
		// System.out.println("inner='" + inner + "'");
		for (final String param : this.list) {
			nextIndex = inner.indexOf(",", currIndex);
			if ((nextIndex < 0)) {
				nextIndex = inner.length();
			}
			final String paramValue = inner.substring(currIndex, nextIndex)
					.trim();
			// System.out.println("currIndex='" + currIndex + "'");
			// System.out.println("nextIndex='" + nextIndex + "'");
			// System.out.println("param='" + param + "'");
			// System.out.println("paramValue='" + paramValue + "'");
			result = this.replaceAndIgnoreQuotes(result, param, paramValue);
			result = result.replaceAll("([^\"]?)" + param, "$1" + paramValue);
			currIndex = nextIndex + 1;
		}
		// System.out.println("-----------");
		return result;
	}

	/***
	 * Remove 'id', any whitespace characters and '(' at the start. Remove ')'
	 * at the end
	 */
	private String getInner(final String match) {
		final int start = this.key.length();
		final String result = match.substring(start, match.length() - 1);
		return result;
	}

	private String replaceAndIgnoreQuotes(final String string,
			final String param, final String paramValue) {
		final StringBuffer result = new StringBuffer("");
		int start = string.indexOf("\"");
		final Pattern pattern = Pattern.compile("[^\\]\"");
		final Matcher matcher = pattern.matcher(string);
		while (matcher.find()) {
			final int tempStart = matcher.start();
			start = string.indexOf("\"", start + 1);
		}
		result.append(string.substring(start));
		return result.toString();
	}

}
