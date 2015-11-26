/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.cpreprocess.serializer;

import at.jku.weiner.cpreprocess.services.CPreprocessGrammarAccess;
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
public class CPreprocessSyntacticSequencer extends AbstractSyntacticSequencer {

	protected CPreprocessGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ConditionalDirective_WSTerminalRuleCall_2_p;
	protected AbstractElementAlias match_DefineFunctionLikeMacro_WSTerminalRuleCall_2_p;
	protected AbstractElementAlias match_DefineFunctionLikeMacro_WSTerminalRuleCall_5_a;
	protected AbstractElementAlias match_DefineFunctionLikeMacro_WSTerminalRuleCall_8_p;
	protected AbstractElementAlias match_DefineObjectMacro_WSTerminalRuleCall_2_p;
	protected AbstractElementAlias match_DefineObjectMacro_WSTerminalRuleCall_4_0_p;
	protected AbstractElementAlias match_ErrorDirective_WSTerminalRuleCall_2_p;
	protected AbstractElementAlias match_IdentifierList_WSTerminalRuleCall_2_1_a;
	protected AbstractElementAlias match_IncludeDirective_WSTerminalRuleCall_2_p;
	protected AbstractElementAlias match_PreprocessorDirectives_WSTerminalRuleCall_1_a;
	protected AbstractElementAlias match_PreprocessorDirectives_WSTerminalRuleCall_3_a;
	protected AbstractElementAlias match_UnDefineDirective_WSTerminalRuleCall_2_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (CPreprocessGrammarAccess) access;
		match_ConditionalDirective_WSTerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getConditionalDirectiveAccess().getWSTerminalRuleCall_2());
		match_DefineFunctionLikeMacro_WSTerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getDefineFunctionLikeMacroAccess().getWSTerminalRuleCall_2());
		match_DefineFunctionLikeMacro_WSTerminalRuleCall_5_a = new TokenAlias(true, true, grammarAccess.getDefineFunctionLikeMacroAccess().getWSTerminalRuleCall_5());
		match_DefineFunctionLikeMacro_WSTerminalRuleCall_8_p = new TokenAlias(true, false, grammarAccess.getDefineFunctionLikeMacroAccess().getWSTerminalRuleCall_8());
		match_DefineObjectMacro_WSTerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getDefineObjectMacroAccess().getWSTerminalRuleCall_2());
		match_DefineObjectMacro_WSTerminalRuleCall_4_0_p = new TokenAlias(true, false, grammarAccess.getDefineObjectMacroAccess().getWSTerminalRuleCall_4_0());
		match_ErrorDirective_WSTerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getErrorDirectiveAccess().getWSTerminalRuleCall_2());
		match_IdentifierList_WSTerminalRuleCall_2_1_a = new TokenAlias(true, true, grammarAccess.getIdentifierListAccess().getWSTerminalRuleCall_2_1());
		match_IncludeDirective_WSTerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getIncludeDirectiveAccess().getWSTerminalRuleCall_2());
		match_PreprocessorDirectives_WSTerminalRuleCall_1_a = new TokenAlias(true, true, grammarAccess.getPreprocessorDirectivesAccess().getWSTerminalRuleCall_1());
		match_PreprocessorDirectives_WSTerminalRuleCall_3_a = new TokenAlias(true, true, grammarAccess.getPreprocessorDirectivesAccess().getWSTerminalRuleCall_3());
		match_UnDefineDirective_WSTerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getUnDefineDirectiveAccess().getWSTerminalRuleCall_2());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getCOMMARule())
			return getCOMMAToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getDEFINERule())
			return getDEFINEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getENDIFRule())
			return getENDIFToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getERRORRule())
			return getERRORToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getHASHRule())
			return getHASHToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getIFDEFRule())
			return getIFDEFToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getINCLUDERule())
			return getINCLUDEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getLPARENRule())
			return getLPARENToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getNEWLINERule())
			return getNEWLINEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getPRAGMARule())
			return getPRAGMAToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getRPARENRule())
			return getRPARENToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getUNDEFRule())
			return getUNDEFToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getWSRule())
			return getWSToken(semanticObject, ruleCall, node);
		return "";
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
	 * terminal DEFINE: 'define';
	 */
	protected String getDEFINEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "define";
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
	 * terminal IFDEF: 'ifdef';
	 */
	protected String getIFDEFToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "ifdef";
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
	 * terminal LPAREN: '(';
	 */
	protected String getLPARENToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "(";
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
	 * terminal RPAREN: ')';
	 */
	protected String getRPARENToken(EObject semanticObject, RuleCall ruleCall, INode node) {
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
			if(match_ConditionalDirective_WSTerminalRuleCall_2_p.equals(syntax))
				emit_ConditionalDirective_WSTerminalRuleCall_2_p(semanticObject, getLastNavigableState(), syntaxNodes);
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
			else if(match_ErrorDirective_WSTerminalRuleCall_2_p.equals(syntax))
				emit_ErrorDirective_WSTerminalRuleCall_2_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_IdentifierList_WSTerminalRuleCall_2_1_a.equals(syntax))
				emit_IdentifierList_WSTerminalRuleCall_2_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
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
	 *     WS+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) IFDEF (ambiguity) id=ID
	 */
	protected void emit_ConditionalDirective_WSTerminalRuleCall_2_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     id=ID LPAREN (ambiguity) RPAREN WS+ string=MyDefineLine
	 *     id=ID LPAREN (ambiguity) list=IdentifierList
	 */
	protected void emit_DefineFunctionLikeMacro_WSTerminalRuleCall_5_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS+
	 *
	 * This ambiguous syntax occurs at:
	 *     id=ID LPAREN WS* RPAREN (ambiguity) string=MyDefineLine
	 *     list=IdentifierList RPAREN (ambiguity) string=MyDefineLine
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
	 *     id+=ID COMMA (ambiguity) id+=ID
	 */
	protected void emit_IdentifierList_WSTerminalRuleCall_2_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
