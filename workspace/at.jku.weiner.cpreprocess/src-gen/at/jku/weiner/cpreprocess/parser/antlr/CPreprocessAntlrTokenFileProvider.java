/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.cpreprocess.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class CPreprocessAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("at/jku/weiner/cpreprocess/parser/antlr/internal/InternalCPreprocess.tokens");
	}
}
