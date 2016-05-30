package at.jku.weiner.antlr4.tree;

import at.jku.weiner.antlr4.Grammar;
import at.jku.weiner.antlr4.Rule;

public interface MyMetamodelListener {

	public void visitGrammar(Grammar grammar);

	public void visitTopRule(Rule rule);

	public void visitRule(Rule parent, Rule rule);

}
