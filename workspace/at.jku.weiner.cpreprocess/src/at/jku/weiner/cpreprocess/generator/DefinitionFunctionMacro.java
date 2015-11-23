package at.jku.weiner.cpreprocess.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;

import at.jku.weiner.cpreprocess.cPreprocess.IdentifierList;
import at.jku.weiner.cpreprocess.utils.StringReplaceSymbolsHelper;

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
		// System.out.println("resolveForParameters='" + code + "'");
		final Pattern pattern = Pattern.compile(this.key + "\\s*\\(");
		final Matcher matcher = pattern.matcher(code);

		int currIndex = 0;
		while (matcher.find(currIndex)) {
			final int matchStart = matcher.start();
			final int matchEnd = matcher.end();
			final String previous = code.substring(currIndex, matchStart);
			// System.out.println("previous='" + previous + "'");
			result.append(previous);
			final int nextIndex = this.replaceAllParams(result, code,
					matchStart, matchEnd);
			// System.out.println("nextIndex='" + nextIndex + "'");
			currIndex = nextIndex;
		}
		final String lastPart = code.substring(currIndex);
		// System.out.println("lastPart='" + lastPart + "'");
		result.append(lastPart);
		// System.out.println("");
	}

	private int replaceAllParams(final StringBuffer result, final String code,
			final int matchStart, final int matchEnd) {

		int currIndex = matchEnd;
		String paramValue = this.value;
		// build up parameters list from code section
		final MacroParentheseHelper helper = new MacroParentheseHelper(code,
				matchEnd);
		final List<String> replaceParams = new ArrayList<String>();
		while (helper.hasMoreParams()) {
			final String nextParam = helper.getNextParam();
			replaceParams.add(nextParam);
			currIndex = helper.getIndex();
		}
		// check how many parameters
		if (replaceParams.size() != this.list.size()) {
			final String original = code.substring(matchStart, currIndex);
			result.append(original);
			return currIndex;
		}
		// iterate all parameters
		for (int paramIndex = 0; paramIndex < replaceParams.size(); paramIndex++) {
			final String nextParam = replaceParams.get(paramIndex);
			final String paramCode = this.getParamCode(nextParam);
			paramValue = this.replaceSingleParam(code, paramCode, paramIndex,
					paramValue);
		}
		// ending
		result.append(paramValue);
		return currIndex;
	}

	private String replaceSingleParam(final String code,
			final String paramCode, final int paramIndex,
			final String paramValue) {
		final String param = this.list.get(paramIndex);
		// System.out.println("paramCode='" + paramCode + "'");
		// System.out.println("param='" + param + "'");
		// System.out.println("paramValue='" + paramValue + "'");
		final String result = StringReplaceSymbolsHelper
				.replaceAndIgnoreQuotes(paramValue, param, paramCode);
		// System.out.println("result='" + result + "'");
		return result;
	}

	private String getParamCode(final String paramCode) {
		final String paramCodeTemp = paramCode.trim();
		final String result = DefinitionTable.resolve(paramCodeTemp);
		return result;
	}

	@Override
	public String getName() {
		return this.key;
	}

}
