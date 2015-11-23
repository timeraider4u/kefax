package at.jku.weiner.cpreprocess.generator;

interface DefinitionMacro {

	public String getName();

	public String resolve(String code);

}
