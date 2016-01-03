/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.c.cmdarguments.serializer;

import at.jku.weiner.c.cmdarguments.services.CmdArgsGrammarAccess;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class CmdArgsSyntacticSequencer extends AbstractSyntacticSequencer {

	protected CmdArgsGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Model_NEWLINETerminalRuleCall_1_2_q;
	protected AbstractElementAlias match_Model_WSTerminalRuleCall_1_1_a;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (CmdArgsGrammarAccess) access;
		match_Model_NEWLINETerminalRuleCall_1_2_q = new TokenAlias(false, true, grammarAccess.getModelAccess().getNEWLINETerminalRuleCall_1_2());
		match_Model_WSTerminalRuleCall_1_1_a = new TokenAlias(true, true, grammarAccess.getModelAccess().getWSTerminalRuleCall_1_1());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getDEFINERule())
			return getDEFINEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getINCLUDERule())
			return getINCLUDEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getINCSYSRule())
			return getINCSYSToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getNEWLINERule())
			return getNEWLINEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getNOSTDINCRule())
			return getNOSTDINCToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_ASSIGNRule())
			return getSKW_ASSIGNToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_COMMARule())
			return getSKW_COMMAToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_LEFTPARENRule())
			return getSKW_LEFTPARENToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_RIGHTPARENRule())
			return getSKW_RIGHTPARENToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getWSRule())
			return getWSToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal DEFINE: SKW_MINUS 'D';
	 */
	protected String getDEFINEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "-D";
	}
	
	/**
	 * terminal INCLUDE: SKW_MINUS 'I';
	 */
	protected String getINCLUDEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "-I";
	}
	
	/**
	 * terminal INCSYS: SKW_MINUS 'isystem';
	 */
	protected String getINCSYSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "-isystem";
	}
	
	/**
	 * terminal NEWLINE: '\n' | '\r';
	 */
	protected String getNEWLINEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\n";
	}
	
	/**
	 * terminal NOSTDINC: SKW_MINUS 'nostdinc';
	 */
	protected String getNOSTDINCToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "-nostdinc";
	}
	
	/**
	 * terminal SKW_ASSIGN: '=';
	 */
	protected String getSKW_ASSIGNToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "=";
	}
	
	/**
	 * terminal SKW_COMMA: ',';
	 */
	protected String getSKW_COMMAToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ",";
	}
	
	/**
	 * terminal SKW_LEFTPAREN: '(';
	 */
	protected String getSKW_LEFTPARENToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "(";
	}
	
	/**
	 * terminal SKW_RIGHTPAREN: ')';
	 */
	protected String getSKW_RIGHTPARENToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ")";
	}
	
	/**
	 * terminal WS			: (' '|'\t'|'\r'|'\n')+;
	 */
	protected String getWSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return " ";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Model_NEWLINETerminalRuleCall_1_2_q.equals(syntax))
				emit_Model_NEWLINETerminalRuleCall_1_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Model_WSTerminalRuleCall_1_1_a.equals(syntax))
				emit_Model_WSTerminalRuleCall_1_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     NEWLINE?
	 *
	 * This ambiguous syntax occurs at:
	 *     lines+=CmdLine WS* (ambiguity) (rule end)
	 *     lines+=CmdLine WS* (ambiguity) lines+=CmdLine
	 */
	protected void emit_Model_NEWLINETerminalRuleCall_1_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     lines+=CmdLine (ambiguity) NEWLINE? (rule end)
	 *     lines+=CmdLine (ambiguity) NEWLINE? lines+=CmdLine
	 */
	protected void emit_Model_WSTerminalRuleCall_1_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
