/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.c.serializer;

import at.jku.weiner.c.services.CGrammarAccess;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class CSyntacticSequencer extends AbstractSyntacticSequencer {

	protected CGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Initializer_COMMATerminalRuleCall_1_1_2_q;
	protected AbstractElementAlias match_ParameterTypeList___COMMATerminalRuleCall_2_0_ELLIPSISTerminalRuleCall_2_1__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (CGrammarAccess) access;
		match_Initializer_COMMATerminalRuleCall_1_1_2_q = new TokenAlias(false, true, grammarAccess.getInitializerAccess().getCOMMATerminalRuleCall_1_1_2());
		match_ParameterTypeList___COMMATerminalRuleCall_2_0_ELLIPSISTerminalRuleCall_2_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getParameterTypeListAccess().getCOMMATerminalRuleCall_2_0()), new TokenAlias(false, false, grammarAccess.getParameterTypeListAccess().getELLIPSISTerminalRuleCall_2_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getANDRule())
			return getANDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getANDANDRule())
			return getANDANDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getARROWRule())
			return getARROWToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getASSIGNRule())
			return getASSIGNToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getCARETRule())
			return getCARETToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getCOLONRule())
			return getCOLONToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getCOMMARule())
			return getCOMMAToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getDOTRule())
			return getDOTToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getELLIPSISRule())
			return getELLIPSISToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getKW_ENUMRule())
			return getKW_ENUMToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getKW_WHILERule())
			return getKW_WHILEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getLEFTBRACERule())
			return getLEFTBRACEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getLEFTBRACKETRule())
			return getLEFTBRACKETToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getLEFTPARENRule())
			return getLEFTPARENToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getMINUSMINUSRule())
			return getMINUSMINUSToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getORRule())
			return getORToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getORORRule())
			return getORORToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getPLUSPLUSRule())
			return getPLUSPLUSToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getQUESTIONRule())
			return getQUESTIONToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getRIGHTBRACERule())
			return getRIGHTBRACEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getRIGHTBRACKETRule())
			return getRIGHTBRACKETToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getRIGHTPARENRule())
			return getRIGHTPARENToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSEMIRule())
			return getSEMIToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal AND: '&';
	 */
	protected String getANDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "&";
	}
	
	/**
	 * terminal ANDAND: AND AND;
	 */
	protected String getANDANDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "&";
	}
	
	/**
	 * terminal ARROW: MINUS GREATER;
	 */
	protected String getARROWToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "->";
	}
	
	/**
	 * terminal ASSIGN: '=';
	 */
	protected String getASSIGNToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "=";
	}
	
	/**
	 * terminal CARET: '^';
	 */
	protected String getCARETToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "^";
	}
	
	/**
	 * terminal COLON: ':';
	 */
	protected String getCOLONToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ":";
	}
	
	/**
	 * terminal COMMA: ',';
	 */
	protected String getCOMMAToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ",";
	}
	
	/**
	 * terminal DOT: '.';
	 */
	protected String getDOTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ".";
	}
	
	/**
	 * terminal ELLIPSIS: DOT DOT DOT;
	 */
	protected String getELLIPSISToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ".";
	}
	
	/**
	 * terminal KW_ENUM : 'enum';
	 */
	protected String getKW_ENUMToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "enum";
	}
	
	/**
	 * terminal KW_WHILE : 'while';
	 */
	protected String getKW_WHILEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "while";
	}
	
	/**
	 * terminal LEFTBRACE: '{';
	 */
	protected String getLEFTBRACEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "{";
	}
	
	/**
	 * terminal LEFTBRACKET: '[';
	 */
	protected String getLEFTBRACKETToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "[";
	}
	
	/**
	 * terminal LEFTPAREN: '(';
	 */
	protected String getLEFTPARENToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "(";
	}
	
	/**
	 * terminal MINUSMINUS: MINUS MINUS;
	 */
	protected String getMINUSMINUSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "-";
	}
	
	/**
	 * terminal OR: '|';
	 */
	protected String getORToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "|";
	}
	
	/**
	 * terminal OROR: OR OR;
	 */
	protected String getORORToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "|";
	}
	
	/**
	 * terminal PLUSPLUS: PLUS PLUS;
	 */
	protected String getPLUSPLUSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "+";
	}
	
	/**
	 * terminal QUESTION: '?';
	 */
	protected String getQUESTIONToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "?";
	}
	
	/**
	 * terminal RIGHTBRACE: '}';
	 */
	protected String getRIGHTBRACEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "}";
	}
	
	/**
	 * terminal RIGHTBRACKET: ']';
	 */
	protected String getRIGHTBRACKETToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "]";
	}
	
	/**
	 * terminal RIGHTPAREN: ')';
	 */
	protected String getRIGHTPARENToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ")";
	}
	
	/**
	 * terminal SEMI: ';';
	 */
	protected String getSEMIToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ";";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Initializer_COMMATerminalRuleCall_1_1_2_q.equals(syntax))
				emit_Initializer_COMMATerminalRuleCall_1_1_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ParameterTypeList___COMMATerminalRuleCall_2_0_ELLIPSISTerminalRuleCall_2_1__q.equals(syntax))
				emit_ParameterTypeList___COMMATerminalRuleCall_2_0_ELLIPSISTerminalRuleCall_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     COMMA?
	 *
	 * This ambiguous syntax occurs at:
	 *     list=InitializerList (ambiguity) RIGHTBRACE (rule end)
	 */
	protected void emit_Initializer_COMMATerminalRuleCall_1_1_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (COMMA ELLIPSIS)?
	 *
	 * This ambiguous syntax occurs at:
	 *     list=ParameterList (ambiguity) (rule end)
	 */
	protected void emit_ParameterTypeList___COMMATerminalRuleCall_2_0_ELLIPSISTerminalRuleCall_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
