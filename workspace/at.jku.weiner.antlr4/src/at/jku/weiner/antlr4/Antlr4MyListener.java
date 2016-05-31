package at.jku.weiner.antlr4;

import org.antlr.parser.antlr4.ANTLRv4Parser.GrammarSpecContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.ParserRuleSpecContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.RulerefContext;
import org.antlr.parser.antlr4.ANTLRv4ParserBaseListener;
import org.eclipse.emf.ecore.EClass;

import at.jku.weiner.antlr4.utils.MetamodelUtils;
import at.jku.weiner.log.MyLog;

public class Antlr4MyListener extends ANTLRv4ParserBaseListener {

	private final MetamodelUtils	mmUtils;
	private String					currId;
	
	public Antlr4MyListener(final MetamodelUtils mmUtils) {
		this.mmUtils = mmUtils;
		this.currId = null;
	}

	@Override
	public void enterGrammarSpec(final GrammarSpecContext ctx) {
		final String id = ctx.identifier().getText();
		MyLog.log(Antlr4MyListener.class, "antlr4-id='" + id + "'");
	}
	
	@Override
	public void exitGrammarSpec(final GrammarSpecContext ctx) {
		final EClass topNode = this.mmUtils.getTopClazz();
		final String topName = topNode.getName();
		final String name = this.mmUtils.getMMName();
		final EClass grammarClazz = this.mmUtils.createOrFindEClass(name);

		this.mmUtils.addContainment(grammarClazz, topNode, topName);

		// final EList<Rule> rules = this.getGrammar().getRules();
		// for (int i = 0; i < rules.size(); i++) {
		// final Rule rule = rules.get(i);
		// final String ruleId = rule.getIdentifier();
		// MyLog.log(Antlr4MyListener.class, "rule(" + i + "')='" + ruleId
		// + "'");
		// final EList<Rule> rulesRefs = rule.getReferencesBy();
		// for (int j = 0; j < rulesRefs.size(); j++) {
		// final Rule ruleRef = rulesRefs.get(j);
		// final String ruleRefId = ruleRef.getIdentifier();
		// MyLog.log(Antlr4MyListener.class, "rule(" + i + "')='" + ruleId
		// + "', ref('" + j + ")='" + ruleRefId + "'");
		// }
		//
		// }
		try {
			this.mmUtils.save();
		} catch (Exception ex) {
			MyLog.errorNoThrows(Antlr4MyListener.class, ex);
		}
	}
	
	@Override
	public void enterParserRuleSpec(final ParserRuleSpecContext ctx) {
		this.currId = ctx.RULE_REF().getText();
		this.mmUtils.createOrFindEClass(this.currId);
		MyLog.log(Antlr4MyListener.class, "rule-id='" + this.currId + "'");
	}

	@Override
	public void enterRuleref(final RulerefContext ctx) {
		final String id = ctx.RULE_REF().getText();
		MyLog.log(Antlr4MyListener.class, "enterRuleref id='" + id + "'");
		this.mmUtils.addContainment(this.currId, id, id);
	}
	
	// private Rule findRuleBy(final String id) {
	// final EList<Rule> rules = this.getGrammar().getRules();
	// for (int i = 0; i < rules.size(); i++) {
	// final Rule result = rules.get(i);
	// final String ruleId = result.getIdentifier();
	// if (id.equals(ruleId)) {
	// return result;
	// }
	// }
	// final Rule result = this.factory.createParserRuleSpec();
	// result.setIdentifier(id);
	// this.getGrammar().getRules().add(result);
	// return result;
	// }
	
}
