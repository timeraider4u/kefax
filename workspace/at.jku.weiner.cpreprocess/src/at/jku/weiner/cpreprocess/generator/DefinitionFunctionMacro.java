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
		final StringBuffer result = new StringBuffer("");
		if (this.list == null) {
			this.resolveZeroArguments(result, code);
		} else {
			this.resolveForParameters(result, code);
		}
		return result.toString();
	}

	private void resolveZeroArguments(final StringBuffer result,
			final String code) {
		final String newCode = code.replaceAll(this.key + "\\s*\\([\\s]*\\)",
				this.value);
		result.append(newCode);
	}

	private void resolveForParameters(final StringBuffer result,
			final String code) {
		System.out.println("resolveForParameters='" + code + "'");
		final Pattern pattern = Pattern.compile(this.key + "\\s*\\(");
		final Matcher matcher = pattern.matcher(code);

		int currIndex = 0;
		while (matcher.find(currIndex)) {
			final int matchStart = matcher.start();
			final int matchEnd = matcher.end();
			final String previous = code.substring(currIndex, matchStart);
			System.out.println("previous='" + previous + "'");
			result.append(previous);
			final int nextIndex = this.replaceAllParams(result, code, matchEnd);
			System.out.println("nextIndex='" + nextIndex + "'");
			currIndex = nextIndex + 1;
		}
		final String lastPart = code.substring(currIndex);
		System.out.println("lastPart='" + lastPart + "'");
		result.append(lastPart);
		System.out.println("");
	}

	private int replaceAllParams(final StringBuffer result, final String code,
			final int startIndex) {
		int currIndex = startIndex;
		int paramIndex = 0;
		int indexComma = code.indexOf(",", startIndex);
		int indexLParen = code.indexOf("(", startIndex);
		int indexRParen = code.indexOf(")", startIndex);
		System.out.println("this.value='" + this.value + "'");
		String paramValue = this.value;
		int parentheses = 0;
		while (indexComma >= 0) {
			while (indexComma > indexLParen) {
				parentheses++;
				currIndex = indexRParen + 1;
				indexComma = code.indexOf(",", currIndex);
				indexLParen = code.indexOf("(", currIndex);
				indexRParen = code.indexOf(")", currIndex);
			}

			paramValue = this.replaceSingleParam(code, currIndex, indexComma,
					paramIndex, paramValue);

			currIndex = indexComma + 1;
			indexComma = code.indexOf(",", currIndex);
			indexLParen = code.indexOf("(", currIndex);
			indexRParen = code.indexOf(")", currIndex);

			paramIndex++;

		}
		paramValue = this.replaceSingleParam(code, currIndex, indexRParen,
				paramIndex, paramValue);
		result.append(paramValue);
		return indexRParen;
	}

	private String replaceSingleParam(final String code, final int startIndex,
			final int endIndex, final int paramIndex, final String paramValue) {
		final String param = this.list.get(paramIndex);
		final String paramCode = this.getParamCode(code, startIndex, endIndex);
		System.out.println("paramCode='" + paramCode + "'");
		System.out.println("param='" + param + "'");
		System.out.println("paramValue='" + paramValue + "'");
		final String result = this.replaceAndIgnoreQuotes(paramCode, param,
				paramValue);
		return result;
	}

	private String getParamCode(final String code, final int startIndex,
			final int endIndex) {
		final String paramCodeTemp = code.substring(startIndex, endIndex)
				.trim();
		final String result = DefinitionTable.resolve(paramCodeTemp);
		return result;
	}

	private String replaceAndIgnoreQuotes(final String paramCode,
			final String param, final String paramValue) {
		final StringBuffer result = new StringBuffer("");
		final String regex = "\"(?:\\\\\"|[^\"])*?\"";
		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(paramValue);
		int start = 0;
		while (matcher.find()) {
			final int tempStart = this.getNextMatcherStart(paramValue,
					matcher.start());
			final int tempEnd = matcher.end();
			final String match = paramValue.substring(tempStart, tempEnd);

			// System.out.println("mymatch='" + match + "'");
			final String str = paramValue.substring(start, tempStart);
			final String str2 = str.replace(param, paramCode);
			// System.out.println("str='" + str + "'");
			// System.out.println("str2='" + str2 + "'");
			result.append(str2);
			result.append(match);
			start = tempEnd;
		}
		final String str = paramValue.substring(start);
		final String str2 = str.replace(param, paramCode);
		// System.out.println("str-2='" + str + "'");
		System.out.println("str2-2='" + str2 + "'");
		result.append(str2);
		return result.toString();
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
