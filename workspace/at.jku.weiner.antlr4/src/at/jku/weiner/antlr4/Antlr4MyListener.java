package at.jku.weiner.antlr4;

import org.antlr.parser.antlr4.ANTLRv4Parser.GrammarSpecContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.ParserRuleSpecContext;
import org.antlr.parser.antlr4.ANTLRv4ParserBaseListener;

import at.jku.weiner.log.MyLog;

public class Antlr4MyListener extends ANTLRv4ParserBaseListener {

	private final StringBuffer	buffer;
	private final Antlr4Factory	factory;
	private Grammar				grammar;
	private Rule				rule;
	
	public Antlr4MyListener() {
		this.buffer = new StringBuffer("");
		this.factory = Antlr4Factory.eINSTANCE;
		this.rule = null;
	}

	@Override
	public void enterGrammarSpec(final GrammarSpecContext ctx) {
		this.grammar = this.factory.createGrammar();
		final String id = ctx.identifier().getText();
		this.grammar.setIdentifier(id);
		MyLog.log(Antlr4MyListener.class, "antlr4-id='" + id + "'");
		this.buffer.append("enterGrammarSpec id='" + id + "'!");
	}
	
	@Override
	public void enterParserRuleSpec(final ParserRuleSpecContext ctx) {
		this.rule = this.factory.createParserRuleSpec();
		final String id = ctx.RULE_REF().getText();
		MyLog.log(Antlr4MyListener.class, "rule-id='" + id + "'");
		this.rule.setIdentifier(id);
		this.grammar.getRules().add(this.rule);
	}

	@Override
	public String toString() {
		return this.buffer.toString();
	}
}
