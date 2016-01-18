package at.jku.weiner.c.preprocess.utils.macros;

import java.util.List;

import org.antlr.runtime.Token;

public interface DefinitionMacro {

	public String getKey();

	public boolean equalsMacro(DefinitionMacro other);

	public int resolve(long id, List<Token> code, int currPosition);

}
