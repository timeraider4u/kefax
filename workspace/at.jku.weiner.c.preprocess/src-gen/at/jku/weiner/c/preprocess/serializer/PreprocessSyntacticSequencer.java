/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.c.preprocess.serializer;

import at.jku.weiner.c.preprocess.services.PreprocessGrammarAccess;
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
public class PreprocessSyntacticSequencer extends AbstractSyntacticSequencer {

	protected PreprocessGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ConditionalDirective_WSTerminalRuleCall_4_a;
	protected AbstractElementAlias match_ConditionalDirective_WSTerminalRuleCall_6_a;
	protected AbstractElementAlias match_ConditionalDirective_WSTerminalRuleCall_8_a;
	protected AbstractElementAlias match_DefineFunctionLikeMacro_WSTerminalRuleCall_2_p;
	protected AbstractElementAlias match_DefineFunctionLikeMacro_WSTerminalRuleCall_5_a;
	protected AbstractElementAlias match_DefineFunctionLikeMacro_WSTerminalRuleCall_8_p;
	protected AbstractElementAlias match_DefineObjectMacro_WSTerminalRuleCall_2_p;
	protected AbstractElementAlias match_DefineObjectMacro_WSTerminalRuleCall_4_0_p;
	protected AbstractElementAlias match_ElIfConditional_WSTerminalRuleCall_1_0_a;
	protected AbstractElementAlias match_ElIfConditional_WSTerminalRuleCall_1_2_a;
	protected AbstractElementAlias match_ElIfConditional_WSTerminalRuleCall_2_p;
	protected AbstractElementAlias match_ElseConditional_WSTerminalRuleCall_1_a;
	protected AbstractElementAlias match_ElseConditional_WSTerminalRuleCall_3_a;
	protected AbstractElementAlias match_ErrorDirective_WSTerminalRuleCall_2_p;
	protected AbstractElementAlias match_IdentifierList_WSTerminalRuleCall_2_1_a;
	protected AbstractElementAlias match_IfConditional_WSTerminalRuleCall_2_p;
	protected AbstractElementAlias match_IfDefConditional_WSTerminalRuleCall_2_p;
	protected AbstractElementAlias match_IfNotDefConditional_WSTerminalRuleCall_2_p;
	protected AbstractElementAlias match_IncludeDirective_WSTerminalRuleCall_2_p;
	protected AbstractElementAlias match_PreprocessorDirectives_WSTerminalRuleCall_1_a;
	protected AbstractElementAlias match_PreprocessorDirectives_WSTerminalRuleCall_3_a;
	protected AbstractElementAlias match_UnDefineDirective_WSTerminalRuleCall_2_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (PreprocessGrammarAccess) access;
		match_ConditionalDirective_WSTerminalRuleCall_4_a = new TokenAlias(true, true, grammarAccess.getConditionalDirectiveAccess().getWSTerminalRuleCall_4());
		match_ConditionalDirective_WSTerminalRuleCall_6_a = new TokenAlias(true, true, grammarAccess.getConditionalDirectiveAccess().getWSTerminalRuleCall_6());
		match_ConditionalDirective_WSTerminalRuleCall_8_a = new TokenAlias(true, true, grammarAccess.getConditionalDirectiveAccess().getWSTerminalRuleCall_8());
		match_DefineFunctionLikeMacro_WSTerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getDefineFunctionLikeMacroAccess().getWSTerminalRuleCall_2());
		match_DefineFunctionLikeMacro_WSTerminalRuleCall_5_a = new TokenAlias(true, true, grammarAccess.getDefineFunctionLikeMacroAccess().getWSTerminalRuleCall_5());
		match_DefineFunctionLikeMacro_WSTerminalRuleCall_8_p = new TokenAlias(true, false, grammarAccess.getDefineFunctionLikeMacroAccess().getWSTerminalRuleCall_8());
		match_DefineObjectMacro_WSTerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getDefineObjectMacroAccess().getWSTerminalRuleCall_2());
		match_DefineObjectMacro_WSTerminalRuleCall_4_0_p = new TokenAlias(true, false, grammarAccess.getDefineObjectMacroAccess().getWSTerminalRuleCall_4_0());
		match_ElIfConditional_WSTerminalRuleCall_1_0_a = new TokenAlias(true, true, grammarAccess.getElIfConditionalAccess().getWSTerminalRuleCall_1_0());
		match_ElIfConditional_WSTerminalRuleCall_1_2_a = new TokenAlias(true, true, grammarAccess.getElIfConditionalAccess().getWSTerminalRuleCall_1_2());
		match_ElIfConditional_WSTerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getElIfConditionalAccess().getWSTerminalRuleCall_2());
		match_ElseConditional_WSTerminalRuleCall_1_a = new TokenAlias(true, true, grammarAccess.getElseConditionalAccess().getWSTerminalRuleCall_1());
		match_ElseConditional_WSTerminalRuleCall_3_a = new TokenAlias(true, true, grammarAccess.getElseConditionalAccess().getWSTerminalRuleCall_3());
		match_ErrorDirective_WSTerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getErrorDirectiveAccess().getWSTerminalRuleCall_2());
		match_IdentifierList_WSTerminalRuleCall_2_1_a = new TokenAlias(true, true, grammarAccess.getIdentifierListAccess().getWSTerminalRuleCall_2_1());
		match_IfConditional_WSTerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getIfConditionalAccess().getWSTerminalRuleCall_2());
		match_IfDefConditional_WSTerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getIfDefConditionalAccess().getWSTerminalRuleCall_2());
		match_IfNotDefConditional_WSTerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getIfNotDefConditionalAccess().getWSTerminalRuleCall_2());
		match_IncludeDirective_WSTerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getIncludeDirectiveAccess().getWSTerminalRuleCall_2());
		match_PreprocessorDirectives_WSTerminalRuleCall_1_a = new TokenAlias(true, true, grammarAccess.getPreprocessorDirectivesAccess().getWSTerminalRuleCall_1());
		match_PreprocessorDirectives_WSTerminalRuleCall_3_a = new TokenAlias(true, true, grammarAccess.getPreprocessorDirectivesAccess().getWSTerminalRuleCall_3());
		match_UnDefineDirective_WSTerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getUnDefineDirectiveAccess().getWSTerminalRuleCall_2());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getDEFINERule())
			return getDEFINEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getDEFINEDRule())
			return getDEFINEDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getELIFRule())
			return getELIFToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getELSERule())
			return getELSEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getENDIFRule())
			return getENDIFToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getERRORRule())
			return getERRORToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getHASHRule())
			return getHASHToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getIFRule())
			return getIFToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getIFDEFRule())
			return getIFDEFToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getIFNOTDEFRule())
			return getIFNOTDEFToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getINCLUDERule())
			return getINCLUDEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getNEWLINERule())
			return getNEWLINEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getPRAGMARule())
			return getPRAGMAToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_ANDRule())
			return getSKW_ANDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_ANDANDRule())
			return getSKW_ANDANDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_CARETRule())
			return getSKW_CARETToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_COLONRule())
			return getSKW_COLONToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_COMMARule())
			return getSKW_COMMAToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_LEFTPARENRule())
			return getSKW_LEFTPARENToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_ORRule())
			return getSKW_ORToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_ORORRule())
			return getSKW_ORORToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_QUESTIONRule())
			return getSKW_QUESTIONToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSKW_RIGHTPARENRule())
			return getSKW_RIGHTPARENToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getUNDEFRule())
			return getUNDEFToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getWSRule())
			return getWSToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal DEFINE: 'define';
	 */
	protected String getDEFINEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "define";
	}
	
	/**
	 * terminal DEFINED: 'defined';
	 */
	protected String getDEFINEDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "defined";
	}
	
	/**
	 * terminal ELIF: 'elif';
	 */
	protected String getELIFToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "elif";
	}
	
	/**
	 * terminal ELSE: 'else';
	 */
	protected String getELSEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "else";
	}
	
	/**
	 * terminal ENDIF: 'endif';
	 */
	protected String getENDIFToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "endif";
	}
	
	/**
	 * terminal ERROR: 'error';
	 */
	protected String getERRORToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "error";
	}
	
	/**
	 * terminal HASH: '#';
	 */
	protected String getHASHToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "#";
	}
	
	/**
	 * terminal IF: 'if';
	 */
	protected String getIFToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "if";
	}
	
	/**
	 * terminal IFDEF: 'ifdef';
	 */
	protected String getIFDEFToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "ifdef";
	}
	
	/**
	 * terminal IFNOTDEF: 'ifndef';
	 */
	protected String getIFNOTDEFToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "ifndef";
	}
	
	/**
	 * terminal INCLUDE: 'include';
	 */
	protected String getINCLUDEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "include";
	}
	
	/**
	 * terminal NEWLINE: (CARRIAGERETURN | LINEFEED) ;
	 */
	protected String getNEWLINEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\r";
	}
	
	/**
	 * terminal PRAGMA: 'pragma';
	 */
	protected String getPRAGMAToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "pragma";
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
	 * terminal SKW_LEFTPAREN: '(';
	 */
	protected String getSKW_LEFTPARENToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "(";
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
	 * terminal SKW_QUESTION: '?';
	 */
	protected String getSKW_QUESTIONToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "?";
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
	 * terminal UNDEF: 'undef';
	 */
	protected String getUNDEFToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "undef";
	}
	
	/**
	 * terminal WS: (SPACE | TAB | LINE_COMMENT | BLOCK_COMMENT | LINEBREAK);
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
			if(match_ConditionalDirective_WSTerminalRuleCall_4_a.equals(syntax))
				emit_ConditionalDirective_WSTerminalRuleCall_4_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ConditionalDirective_WSTerminalRuleCall_6_a.equals(syntax))
				emit_ConditionalDirective_WSTerminalRuleCall_6_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ConditionalDirective_WSTerminalRuleCall_8_a.equals(syntax))
				emit_ConditionalDirective_WSTerminalRuleCall_8_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DefineFunctionLikeMacro_WSTerminalRuleCall_2_p.equals(syntax))
				emit_DefineFunctionLikeMacro_WSTerminalRuleCall_2_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DefineFunctionLikeMacro_WSTerminalRuleCall_5_a.equals(syntax))
				emit_DefineFunctionLikeMacro_WSTerminalRuleCall_5_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DefineFunctionLikeMacro_WSTerminalRuleCall_8_p.equals(syntax))
				emit_DefineFunctionLikeMacro_WSTerminalRuleCall_8_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DefineObjectMacro_WSTerminalRuleCall_2_p.equals(syntax))
				emit_DefineObjectMacro_WSTerminalRuleCall_2_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DefineObjectMacro_WSTerminalRuleCall_4_0_p.equals(syntax))
				emit_DefineObjectMacro_WSTerminalRuleCall_4_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ElIfConditional_WSTerminalRuleCall_1_0_a.equals(syntax))
				emit_ElIfConditional_WSTerminalRuleCall_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ElIfConditional_WSTerminalRuleCall_1_2_a.equals(syntax))
				emit_ElIfConditional_WSTerminalRuleCall_1_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ElIfConditional_WSTerminalRuleCall_2_p.equals(syntax))
				emit_ElIfConditional_WSTerminalRuleCall_2_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ElseConditional_WSTerminalRuleCall_1_a.equals(syntax))
				emit_ElseConditional_WSTerminalRuleCall_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ElseConditional_WSTerminalRuleCall_3_a.equals(syntax))
				emit_ElseConditional_WSTerminalRuleCall_3_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ErrorDirective_WSTerminalRuleCall_2_p.equals(syntax))
				emit_ErrorDirective_WSTerminalRuleCall_2_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_IdentifierList_WSTerminalRuleCall_2_1_a.equals(syntax))
				emit_IdentifierList_WSTerminalRuleCall_2_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_IfConditional_WSTerminalRuleCall_2_p.equals(syntax))
				emit_IfConditional_WSTerminalRuleCall_2_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_IfDefConditional_WSTerminalRuleCall_2_p.equals(syntax))
				emit_IfDefConditional_WSTerminalRuleCall_2_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_IfNotDefConditional_WSTerminalRuleCall_2_p.equals(syntax))
				emit_IfNotDefConditional_WSTerminalRuleCall_2_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_IncludeDirective_WSTerminalRuleCall_2_p.equals(syntax))
				emit_IncludeDirective_WSTerminalRuleCall_2_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PreprocessorDirectives_WSTerminalRuleCall_1_a.equals(syntax))
				emit_PreprocessorDirectives_WSTerminalRuleCall_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PreprocessorDirectives_WSTerminalRuleCall_3_a.equals(syntax))
				emit_PreprocessorDirectives_WSTerminalRuleCall_3_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_UnDefineDirective_WSTerminalRuleCall_2_p.equals(syntax))
				emit_UnDefineDirective_WSTerminalRuleCall_2_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     conditional=IfConditional (ambiguity) HASH WS* ENDIF WS* (rule end)
	 *     conditional=IfDefConditional (ambiguity) HASH WS* ENDIF WS* (rule end)
	 *     conditional=IfNotDefConditional (ambiguity) HASH WS* ENDIF WS* (rule end)
	 *     elifs+=ElIfConditional (ambiguity) HASH WS* ENDIF WS* (rule end)
	 *     else=ElseConditional (ambiguity) HASH WS* ENDIF WS* (rule end)
	 */
	protected void emit_ConditionalDirective_WSTerminalRuleCall_4_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     conditional=IfConditional WS* HASH (ambiguity) ENDIF WS* (rule end)
	 *     conditional=IfDefConditional WS* HASH (ambiguity) ENDIF WS* (rule end)
	 *     conditional=IfNotDefConditional WS* HASH (ambiguity) ENDIF WS* (rule end)
	 *     elifs+=ElIfConditional WS* HASH (ambiguity) ENDIF WS* (rule end)
	 *     else=ElseConditional WS* HASH (ambiguity) ENDIF WS* (rule end)
	 */
	protected void emit_ConditionalDirective_WSTerminalRuleCall_6_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     conditional=IfConditional WS* HASH WS* ENDIF (ambiguity) (rule end)
	 *     conditional=IfDefConditional WS* HASH WS* ENDIF (ambiguity) (rule end)
	 *     conditional=IfNotDefConditional WS* HASH WS* ENDIF (ambiguity) (rule end)
	 *     elifs+=ElIfConditional WS* HASH WS* ENDIF (ambiguity) (rule end)
	 *     else=ElseConditional WS* HASH WS* ENDIF (ambiguity) (rule end)
	 */
	protected void emit_ConditionalDirective_WSTerminalRuleCall_8_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) DEFINE (ambiguity) id=ID
	 */
	protected void emit_DefineFunctionLikeMacro_WSTerminalRuleCall_2_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     id=ID SKW_LEFTPAREN (ambiguity) SKW_RIGHTPAREN WS+ string=MyDefineLine
	 *     id=ID SKW_LEFTPAREN (ambiguity) list=IdentifierList
	 */
	protected void emit_DefineFunctionLikeMacro_WSTerminalRuleCall_5_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS+
	 *
	 * This ambiguous syntax occurs at:
	 *     id=ID SKW_LEFTPAREN WS* SKW_RIGHTPAREN (ambiguity) string=MyDefineLine
	 *     list=IdentifierList SKW_RIGHTPAREN (ambiguity) string=MyDefineLine
	 */
	protected void emit_DefineFunctionLikeMacro_WSTerminalRuleCall_8_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) DEFINE (ambiguity) id=ID
	 */
	protected void emit_DefineObjectMacro_WSTerminalRuleCall_2_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS+
	 *
	 * This ambiguous syntax occurs at:
	 *     id=ID (ambiguity) string=MyDefineLine
	 */
	protected void emit_DefineObjectMacro_WSTerminalRuleCall_4_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) HASH WS* ELIF WS+ expression=ShadowExpression
	 */
	protected void emit_ElIfConditional_WSTerminalRuleCall_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) WS* HASH (ambiguity) ELIF WS+ expression=ShadowExpression
	 */
	protected void emit_ElIfConditional_WSTerminalRuleCall_1_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) WS* HASH WS* ELIF (ambiguity) expression=ShadowExpression
	 */
	protected void emit_ElIfConditional_WSTerminalRuleCall_2_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) HASH WS* ELSE NEWLINE group=GroupOpt
	 */
	protected void emit_ElseConditional_WSTerminalRuleCall_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) WS* HASH (ambiguity) ELSE NEWLINE group=GroupOpt
	 */
	protected void emit_ElseConditional_WSTerminalRuleCall_3_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) ERROR (ambiguity) msg=MyCodeLine
	 */
	protected void emit_ErrorDirective_WSTerminalRuleCall_2_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     id+=ID SKW_COMMA (ambiguity) id+=ID
	 */
	protected void emit_IdentifierList_WSTerminalRuleCall_2_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) IF (ambiguity) expression=ShadowExpression
	 */
	protected void emit_IfConditional_WSTerminalRuleCall_2_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) IFDEF (ambiguity) id=ID
	 */
	protected void emit_IfDefConditional_WSTerminalRuleCall_2_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) IFNOTDEF (ambiguity) id=ID
	 */
	protected void emit_IfNotDefConditional_WSTerminalRuleCall_2_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) INCLUDE (ambiguity) string=MyCodeLine
	 */
	protected void emit_IncludeDirective_WSTerminalRuleCall_2_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) HASH WS* directive=ConditionalDirective
	 *     (rule start) (ambiguity) HASH WS* directive=DefineDirective
	 *     (rule start) (ambiguity) HASH WS* directive=ErrorDirective
	 *     (rule start) (ambiguity) HASH WS* directive=IncludeDirective
	 *     (rule start) (ambiguity) HASH WS* directive=NullDirective
	 *     (rule start) (ambiguity) HASH WS* directive=PragmaDirective
	 *     (rule start) (ambiguity) HASH WS* directive=UnDefineDirective
	 */
	protected void emit_PreprocessorDirectives_WSTerminalRuleCall_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) WS* HASH (ambiguity) directive=ConditionalDirective
	 *     (rule start) WS* HASH (ambiguity) directive=DefineDirective
	 *     (rule start) WS* HASH (ambiguity) directive=ErrorDirective
	 *     (rule start) WS* HASH (ambiguity) directive=IncludeDirective
	 *     (rule start) WS* HASH (ambiguity) directive=NullDirective
	 *     (rule start) WS* HASH (ambiguity) directive=PragmaDirective
	 *     (rule start) WS* HASH (ambiguity) directive=UnDefineDirective
	 */
	protected void emit_PreprocessorDirectives_WSTerminalRuleCall_3_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) UNDEF (ambiguity) id=ID
	 */
	protected void emit_UnDefineDirective_WSTerminalRuleCall_2_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
