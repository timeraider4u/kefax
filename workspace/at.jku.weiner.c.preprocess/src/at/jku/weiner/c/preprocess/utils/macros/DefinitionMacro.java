package at.jku.weiner.c.preprocess.utils.macros;

import java.util.List;

import org.antlr.runtime.Token;

public interface DefinitionMacro {
	
	public boolean equalsMacro(DefinitionMacro other);

	public int resolve(StringBuffer result, List<Token> code, int currPosition);

}
