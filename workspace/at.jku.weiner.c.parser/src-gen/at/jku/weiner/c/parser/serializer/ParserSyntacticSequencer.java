/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.c.parser.serializer;

import at.jku.weiner.c.parser.services.ParserGrammarAccess;
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
public class ParserSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ParserGrammarAccess grammarAccess;
	protected AbstractElementAlias match_GccAttribute___SKW_LEFTPARENTerminalRuleCall_2_0_SKW_RIGHTPARENTerminalRuleCall_2_2__q;
	protected AbstractElementAlias match_Initializer_SKW_COMMATerminalRuleCall_1_1_2_q;
	protected AbstractElementAlias match_ParameterTypeList___SKW_COMMATerminalRuleCall_2_0_ELLIPSISTerminalRuleCall_2_1__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ParserGrammarAccess) access;
		match_GccAttribute___SKW_LEFTPARENTerminalRuleCall_2_0_SKW_RIGHTPARENTerminalRuleCall_2_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGccAttributeAccess().getSKW_LEFTPARENTerminalRuleCall_2_0()), new TokenAlias(false, false, grammarAccess.getGccAttributeAccess().getSKW_RIGHTPARENTerminalRuleCall_2_2()));
		match_Initializer_SKW_COMMATerminalRuleCall_1_1_2_q = new TokenAlias(false, true, grammarAccess.getInitializerAccess().getSKW_COMMATerminalRuleCall_1_1_2());
		match_ParameterTypeList___SKW_COMMATerminalRuleCall_2_0_ELLIPSISTerminalRuleCall_2_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getParameterTypeListAccess().getSKW_COMMATerminalRuleCall_2_0()), new TokenAlias(false, false, grammarAccess.getParameterTypeListAccess().getELLIPSISTerminalRuleCall_2_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getARROWRule())
			return getARROWToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getELLIPSISRule())
			return getELLIPSISToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getKW_ATTRIBUTERule())
			return getKW_ATTRIBUTEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getKW_ENUMRule())
			return getKW_ENUMToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getKW_WHILERule())
			return getKW_WHILEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_ANDRule())
			return getSKW_ANDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_ANDANDRule())
			return getSKW_ANDANDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_ASSIGNRule())
			return getSKW_ASSIGNToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_CARETRule())
			return getSKW_CARETToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_COLONRule())
			return getSKW_COLONToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_COMMARule())
			return getSKW_COMMAToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_DOTRule())
			return getSKW_DOTToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_LEFTBRACERule())
			return getSKW_LEFTBRACEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_LEFTBRACKETRule())
			return getSKW_LEFTBRACKETToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_LEFTPARENRule())
			return getSKW_LEFTPARENToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_MINUSMINUSRule())
			return getSKW_MINUSMINUSToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_ORRule())
			return getSKW_ORToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_ORORRule())
			return getSKW_ORORToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_PLUSPLUSRule())
			return getSKW_PLUSPLUSToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_QUESTIONRule())
			return getSKW_QUESTIONToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_RIGHTBRACERule())
			return getSKW_RIGHTBRACEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_RIGHTBRACKETRule())
			return getSKW_RIGHTBRACKETToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_RIGHTPARENRule())
			return getSKW_RIGHTPARENToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_SEMIRule())
			return getSKW_SEMIToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal ARROW: SKW_MINUS SKW_GREATER;
	 */
	protected String getARROWToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "->";
	}
	
	/**
	 * terminal ELLIPSIS: SKW_DOT SKW_DOT SKW_DOT;
	 */
	protected String getELLIPSISToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ".";
	}
	
	/**
	 * terminal KW_ATTRIBUTE: SKW_UNDERSCORE SKW_UNDERSCORE 'attribute' SKW_UNDERSCORE SKW_UNDERSCORE;
	 */
	protected String getKW_ATTRIBUTEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "_attribute";
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
	 * terminal SKW_AND: '&';
	 */
	protected String getSKW_ANDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "&";
	}
	
	/**
	 * terminal SKW_ANDAND: SKW_AND SKW_AND;
	 */
	protected String getSKW_ANDANDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "&";
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
	 * terminal SKW_CARET: '^';
	 */
	protected String getSKW_CARETToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "^";
	}
	
	/**
	 * terminal SKW_COLON: ':';
	 */
	protected String getSKW_COLONToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ":";
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
	 * terminal SKW_DOT: '.';
	 */
	protected String getSKW_DOTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ".";
	}
	
	/**
	 * terminal SKW_LEFTBRACE: '{';
	 */
	protected String getSKW_LEFTBRACEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "{";
	}
	
	/**
	 * terminal SKW_LEFTBRACKET: '[';
	 */
	protected String getSKW_LEFTBRACKETToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "[";
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
	 * terminal SKW_MINUSMINUS: SKW_MINUS SKW_MINUS;
	 */
	protected String getSKW_MINUSMINUSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "-";
	}
	
	/**
	 * terminal SKW_OR: '|';
	 */
	protected String getSKW_ORToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "|";
	}
	
	/**
	 * terminal SKW_OROR: SKW_OR SKW_OR;
	 */
	protected String getSKW_ORORToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "|";
	}
	
	/**
	 * terminal SKW_PLUSPLUS: SKW_PLUS SKW_PLUS;
	 */
	protected String getSKW_PLUSPLUSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "+";
	}
	
	/**
	 * terminal SKW_QUESTION: '?';
	 */
	protected String getSKW_QUESTIONToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "?";
	}
	
	/**
	 * terminal SKW_RIGHTBRACE: '}';
	 */
	protected String getSKW_RIGHTBRACEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "}";
	}
	
	/**
	 * terminal SKW_RIGHTBRACKET: ']';
	 */
	protected String getSKW_RIGHTBRACKETToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "]";
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
	 * terminal SKW_SEMI: ';';
	 */
	protected String getSKW_SEMIToken(EObject semanticObject, RuleCall ruleCall, INode node) {
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
			if(match_GccAttribute___SKW_LEFTPARENTerminalRuleCall_2_0_SKW_RIGHTPARENTerminalRuleCall_2_2__q.equals(syntax))
				emit_GccAttribute___SKW_LEFTPARENTerminalRuleCall_2_0_SKW_RIGHTPARENTerminalRuleCall_2_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Initializer_SKW_COMMATerminalRuleCall_1_1_2_q.equals(syntax))
				emit_Initializer_SKW_COMMATerminalRuleCall_1_1_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ParameterTypeList___SKW_COMMATerminalRuleCall_2_0_ELLIPSISTerminalRuleCall_2_1__q.equals(syntax))
				emit_ParameterTypeList___SKW_COMMATerminalRuleCall_2_0_ELLIPSISTerminalRuleCall_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     (SKW_LEFTPAREN SKW_RIGHTPAREN)?
	 *
	 * This ambiguous syntax occurs at:
	 *     const=Constant1 (ambiguity) (rule end)
	 *     id=ID (ambiguity) (rule end)
	 */
	protected void emit_GccAttribute___SKW_LEFTPARENTerminalRuleCall_2_0_SKW_RIGHTPARENTerminalRuleCall_2_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     SKW_COMMA?
	 *
	 * This ambiguous syntax occurs at:
	 *     list=InitializerList (ambiguity) SKW_RIGHTBRACE (rule end)
	 */
	protected void emit_Initializer_SKW_COMMATerminalRuleCall_1_1_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (SKW_COMMA ELLIPSIS)?
	 *
	 * This ambiguous syntax occurs at:
	 *     list=ParameterList (ambiguity) (rule end)
	 */
	protected void emit_ParameterTypeList___SKW_COMMATerminalRuleCall_2_0_ELLIPSISTerminalRuleCall_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
