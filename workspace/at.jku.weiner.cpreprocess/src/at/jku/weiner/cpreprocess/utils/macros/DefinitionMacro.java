package at.jku.weiner.cpreprocess.utils.macros;

interface DefinitionMacro {

	public String getName();

	public String resolve(String code);

}
