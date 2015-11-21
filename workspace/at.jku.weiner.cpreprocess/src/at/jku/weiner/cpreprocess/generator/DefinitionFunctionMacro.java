package at.jku.weiner.cpreprocess.generator;

class DefinitionFunctionMacro implements DefinitionMacro {

	private final String key;
	private final String value;

	public DefinitionFunctionMacro(final String key, final String value) {
		this.key = key;
		this.value = this.getValue(value);
	}

	private String getValue(String value2) {
		if (value2 == null) {
			value2 = "";
		}
		return value2;
	}

	@Override
	public String resolve(final String code) {
		final String result = code.replace(this.key + "()", this.key);
		return result.replace(this.key, this.value);
	}

}
