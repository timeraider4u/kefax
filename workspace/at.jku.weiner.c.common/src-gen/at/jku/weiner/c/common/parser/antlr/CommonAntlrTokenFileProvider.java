/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.c.common.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class CommonAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("at/jku/weiner/c/common/parser/antlr/internal/InternalCommon.tokens");
	}
}
