package at.jku.weiner.c.preprocess.utils.macros;

import java.awt.Point;
import java.util.List;

import org.antlr.runtime.Token;

public interface DefinitionMacro {

	public String getKey();

	public boolean equalsMacro(DefinitionMacro other);

	public void resolve(long id, List<Token> code, Point range);

}
