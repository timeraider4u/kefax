package at.jku.weiner.c.preprocess.utils.macros;

interface DefinitionMacro {

	public String getName();

	public boolean matches(String code);

	public String resolve(String code);

}
