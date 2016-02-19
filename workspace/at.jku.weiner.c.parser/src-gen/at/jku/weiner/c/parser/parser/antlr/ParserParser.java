/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.c.parser.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import at.jku.weiner.c.parser.services.ParserGrammarAccess;

public class ParserParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private ParserGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WHITESPACE", "RULE_NEWLINE", "RULE_LINEDIRECTIVE", "RULE_IGNORED", "RULE_SPECIAL");
	}
	
	@Override
	protected at.jku.weiner.c.parser.parser.antlr.internal.InternalParserParser createParser(XtextTokenStream stream) {
		return new at.jku.weiner.c.parser.parser.antlr.internal.InternalParserParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Parser";
	}
	
	public ParserGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ParserGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
