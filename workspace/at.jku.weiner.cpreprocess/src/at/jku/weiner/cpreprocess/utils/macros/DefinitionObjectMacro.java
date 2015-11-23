package at.jku.weiner.cpreprocess.utils.macros;

class DefinitionObjectMacro implements DefinitionMacro {

	private final String key;
	private final String value;

	public DefinitionObjectMacro(final String key, final String value) {
		this.key = key;
		this.value = this.getValue(value);
	}

	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof DefinitionObjectMacro)) {
			return false;
		}
		final DefinitionObjectMacro other = (DefinitionObjectMacro) obj;
		if (!(this.key.equals(other.key))) {
			return false;
		}
		return this.value.equals(other.value);
	}

	private String getValue(String value2) {
		if (value2 == null) {
			value2 = "";
		}
		return value2;
	}

	@Override
	public String resolve(final String code) {
		return code.replace(this.key, this.value);
	}

	@Override
	public String getName() {
		return this.key;
	}

}
