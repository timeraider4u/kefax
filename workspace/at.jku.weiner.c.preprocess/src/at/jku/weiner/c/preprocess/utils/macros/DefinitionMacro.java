package at.jku.weiner.c.preprocess.utils.macros;

interface DefinitionMacro {

	public String getName();

	public boolean matches(String originalText, String code);

	public String resolve(String originalText, String code);

}
