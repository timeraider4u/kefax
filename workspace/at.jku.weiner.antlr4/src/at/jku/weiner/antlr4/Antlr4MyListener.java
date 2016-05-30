package at.jku.weiner.antlr4;

import org.antlr.parser.antlr4.ANTLRv4Parser.GrammarSpecContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.ParserRuleSpecContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.RulerefContext;
import org.antlr.parser.antlr4.ANTLRv4ParserBaseListener;
import org.eclipse.emf.common.util.EList;

import at.jku.weiner.log.MyLog;

public class Antlr4MyListener extends ANTLRv4ParserBaseListener {
	
	private final StringBuffer	buffer;
	private final Antlr4Factory	factory;
	private Grammar				grammar;
	private Rule				currRule;

	public Antlr4MyListener() {
		this.buffer = new StringBuffer("");
		this.factory = Antlr4Factory.eINSTANCE;
		this.currRule = null;
	}
	
	@Override
	public void enterGrammarSpec(final GrammarSpecContext ctx) {
		this.grammar = this.factory.createGrammar();
		final String id = ctx.identifier().getText();
		this.getGrammar().setIdentifier(id);
		MyLog.log(Antlr4MyListener.class, "antlr4-id='" + id + "'");
		this.buffer.append("enterGrammarSpec id='" + id + "'!");
	}

	@Override
	public void exitGrammarSpec(final GrammarSpecContext ctx) {
		final EList<Rule> rules = this.getGrammar().getRules();
		for (int i = 0; i < rules.size(); i++) {
			final Rule rule = rules.get(i);
			final String ruleId = rule.getIdentifier();
			MyLog.log(Antlr4MyListener.class, "rule(" + i + "')='" + ruleId
					+ "'");
			final EList<Rule> rulesRefs = rule.getReferencesBy();
			for (int j = 0; j < rulesRefs.size(); j++) {
				final Rule ruleRef = rulesRefs.get(j);
				final String ruleRefId = ruleRef.getIdentifier();
				MyLog.log(Antlr4MyListener.class, "rule(" + i + "')='" + ruleId
						+ "', ref('" + j + ")='" + ruleRefId + "'");
			}

		}
	}

	@Override
	public void enterParserRuleSpec(final ParserRuleSpecContext ctx) {
		final String id = ctx.RULE_REF().getText();
		this.currRule = this.findRuleBy(id);
		MyLog.log(Antlr4MyListener.class, "rule-id='" + id + "'");
		this.currRule.setIdentifier(id);
		this.getGrammar().getRules().add(this.currRule);
	}
	
	@Override
	public void enterRuleref(final RulerefContext ctx) {
		final String id = ctx.RULE_REF().getText();
		MyLog.log(Antlr4MyListener.class, "enterRuleref id='" + id + "'");
		final Rule ref = this.findRuleBy(id);
		ref.getReferencesBy().add(this.currRule);
		// this.currRule.getReferencesBy().add(ref);
	}

	private Rule findRuleBy(final String id) {
		final EList<Rule> rules = this.getGrammar().getRules();
		for (int i = 0; i < rules.size(); i++) {
			final Rule result = rules.get(i);
			final String ruleId = result.getIdentifier();
			if (id.equals(ruleId)) {
				return result;
			}
		}
		final Rule result = this.factory.createParserRuleSpec();
		result.setIdentifier(id);
		this.getGrammar().getRules().add(result);
		return result;
	}
	
	@Override
	public String toString() {
		return this.buffer.toString();
	}
	
	public Grammar getGrammar() {
		return this.grammar;
	}
	
}
