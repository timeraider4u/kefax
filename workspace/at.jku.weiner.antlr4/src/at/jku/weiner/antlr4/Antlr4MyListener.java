package at.jku.weiner.antlr4;

import org.antlr.parser.antlr4.ANTLRv4Parser.GrammarSpecContext;
import org.antlr.parser.antlr4.ANTLRv4ParserBaseListener;

import at.jku.weiner.log.MyLog;

public class Antlr4MyListener extends ANTLRv4ParserBaseListener {

	private final StringBuffer	buffer	= new StringBuffer("");

	@Override
	public void enterGrammarSpec(final GrammarSpecContext ctx) {
		final String id = ctx.identifier().getText();
		MyLog.log(Antlr4MyListener.class, "antlr4-id='" + id + "'");
		this.buffer.append("enterGrammarSpec id='" + id + "'!");
	}

	@Override
	public String toString() {
		return this.buffer.toString();
	}
}
