package at.jku.weiner.c.preprocess.utils.macros;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;

import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.utils.StringLiteralInStringLiteralsHelper;

class DefinitionFunctionMacro implements DefinitionMacro {

	private static final String REGEX_NO_PARAMS = "\\s*\\([\\s]*\\)";

	private final String key;
	private final String value;
	private final IdentifierList idList;
	private final EList<String> list;
	private final Pattern pattern;
	private final StringMatchingSymbolsHelper matcher;

	public DefinitionFunctionMacro(final String key, final String value,
			final IdentifierList list) {
		this.idList = list;
		this.list = this.getList(list);
		this.key = key;
		this.value = this.getValue(value);
		this.pattern = this.getPattern();
		this.matcher = new StringMatchingSymbolsHelper(this.pattern);
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

	private Pattern getPattern() {
		if (this.idList == null) {
			return Pattern.compile(this.key
					+ DefinitionFunctionMacro.REGEX_NO_PARAMS);
		}
		return Pattern.compile(this.key + "\\s*\\(");
	}

	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof DefinitionFunctionMacro)) {
			return false;
		}
		final DefinitionFunctionMacro other = (DefinitionFunctionMacro) obj;
		if (!this.key.equals(other.key)) {
			return false;
		}
		if (!this.value.equals(other.value)) {
			return false;
		}
		if ((this.list == null) && (other.list != null)) {
			return false;
		}
		if ((this.list != null) && (other.list == null)) {
			return false;
		}
		if ((this.list == null) && (other.list == null)) {
			return true;
		}
		if (this.list.size() != other.list.size()) {
			return false;
		}
		for (int i = 0; i < this.list.size(); i++) {
			final String param1 = this.list.get(i);
			final String param2 = other.list.get(i);
			if (!(param1.equals(param2))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean matches(final String code) {
		StringLiteralInStringLiteralsHelper.iterate(code, this.matcher);
		return this.matcher.contains();
	}

	@Override
	public String resolve(final String code) {
		final StringReplaceSymbolsFunctionMacroReplace helper = new StringReplaceSymbolsFunctionMacroReplace(
				this.list);
		StringLiteralInStringLiteralsHelper.iterate(code, helper);
		return helper.getText();
	}

	class StringReplaceSymbolsFunctionMacroReplace extends
			StringReplaceSymbolsHelper {

		private final EList<String> list2;

		public StringReplaceSymbolsFunctionMacroReplace(final EList<String> list) {
			this.list2 = list;
		}

		@Override
		public String getText() {
			return this.result.toString();
		}

		@Override
		protected String replace(final String string) {
			final StringBuffer result = new StringBuffer("");
			if (this.list2 == null) {
				DefinitionFunctionMacro.this.resolveZeroArguments(result,
						string);
			} else {
				DefinitionFunctionMacro.this.resolveForParameters(result,
						string);
				DefinitionFunctionMacro.this.resolveStringifiaction(result);
				DefinitionFunctionMacro.this.resolveConcatenation(result);
			}
			return result.toString();
		}
	}

	private void resolveZeroArguments(final StringBuffer result,
			final String code) {
		final String newCode = code.replaceAll(this.key
				+ DefinitionFunctionMacro.REGEX_NO_PARAMS, this.value);
		result.append(newCode);
	}

	private void resolveForParameters(final StringBuffer result,
			final String code) {
		// System.out.println("resolveForParameters='" + code + "'");
		final Matcher matcher = this.pattern.matcher(code);

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
			final String paramCode = this.getParamCode(paramIndex, nextParam);
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
		final StringReplaceSymbolsHelper visitor = new StringReplaceSymbolsHelperDefaultReplace(
				param, paramCode);
		// System.out.println("paramCode='" + paramCode + "'");
		// System.out.println("param='" + param + "'");
		// System.out.println("paramValue='" + paramValue + "'");
		StringLiteralInStringLiteralsHelper.iterate(paramValue, visitor);
		final String result = visitor.getText();
		// System.out.println("result='" + result + "'");
		return result;
	}

	private String getParamCode(final int paramIndex, final String paramCode) {
		final String param = this.list.get(paramIndex);
		final String paramCodeTemp = paramCode.trim();
		if (this.partOfStringification(param)) {
			return paramCodeTemp;
		}
		final String result = DefinitionTable.resolve(paramCodeTemp);
		return result;
	}

	@Override
	public String getName() {
		return this.key;
	}

	private boolean partOfStringification(final String param) {
		final Pattern strPattern = Pattern.compile("#\\b" + param + "\\b");
		final Matcher matcher = strPattern.matcher(this.value);
		return matcher.find();
	}

	private void resolveStringifiaction(final StringBuffer result) {
		String intermediate = result.toString();
		if (!intermediate.contains("#")) {
			return;
		}
		result.delete(0, result.length());
		final Pattern pattern = Pattern.compile("#([^\\p{Space}]+)\\b");
		final Matcher matcher = pattern.matcher(intermediate);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			final String original = matcher.group();
			final StringBuilder builder = new StringBuilder(intermediate);
			final String removedQuotes = matcher.group().replace("\"", "\\\"");
			builder.replace(matcher.start(), matcher.end(), removedQuotes);
			intermediate = builder.toString();
		}
		intermediate = intermediate
				.replaceAll("#([^\\p{Space}]+)\\b", "\"$1\"");

		result.append(intermediate);
	}

	public void resolveConcatenation(final StringBuffer result) {
		String intermediate = result.toString();
		if (!intermediate.contains("#")) {
			return;
		}
		result.delete(0, result.length());
		intermediate = intermediate.replaceAll("\\s##\\s", "");
		result.append(intermediate);
	}

}
