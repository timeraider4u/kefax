/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.cpreprocess.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractParserRuleElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class CPreprocessGrammarAccess extends AbstractGrammarElementFinder {
	
	public class ModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.Model");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cModelAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cUnitsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cUnitsTranslationUnitParserRuleCall_1_0 = (RuleCall)cUnitsAssignment_1.eContents().get(0);
		
		//Model:
		//	{Model} units+=TranslationUnit;
		@Override public ParserRule getRule() { return rule; }
		
		//{Model} units+=TranslationUnit
		public Group getGroup() { return cGroup; }
		
		//{Model}
		public Action getModelAction_0() { return cModelAction_0; }
		
		//units+=TranslationUnit
		public Assignment getUnitsAssignment_1() { return cUnitsAssignment_1; }
		
		//TranslationUnit
		public RuleCall getUnitsTranslationUnitParserRuleCall_1_0() { return cUnitsTranslationUnitParserRuleCall_1_0; }
	}
	public class TranslationUnitElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.TranslationUnit");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cTranslationUnitAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cLinesAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cLinesPreprocessorDirectivesParserRuleCall_1_0_0 = (RuleCall)cLinesAssignment_1_0.eContents().get(0);
		private final Assignment cLinesAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cLinesNewLineLineParserRuleCall_1_1_0 = (RuleCall)cLinesAssignment_1_1.eContents().get(0);
		private final Assignment cLinesAssignment_1_2 = (Assignment)cAlternatives_1.eContents().get(2);
		private final RuleCall cLinesCodeParserRuleCall_1_2_0 = (RuleCall)cLinesAssignment_1_2.eContents().get(0);
		
		//TranslationUnit:
		//	{TranslationUnit} (lines+=PreprocessorDirectives
		//	| lines+=NewLineLine
		//	| lines+=Code)*;
		@Override public ParserRule getRule() { return rule; }
		
		//{TranslationUnit} (lines+=PreprocessorDirectives | lines+=NewLineLine | lines+=Code)*
		public Group getGroup() { return cGroup; }
		
		//{TranslationUnit}
		public Action getTranslationUnitAction_0() { return cTranslationUnitAction_0; }
		
		//(lines+=PreprocessorDirectives | lines+=NewLineLine | lines+=Code)*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//lines+=PreprocessorDirectives
		public Assignment getLinesAssignment_1_0() { return cLinesAssignment_1_0; }
		
		//PreprocessorDirectives
		public RuleCall getLinesPreprocessorDirectivesParserRuleCall_1_0_0() { return cLinesPreprocessorDirectivesParserRuleCall_1_0_0; }
		
		//lines+=NewLineLine
		public Assignment getLinesAssignment_1_1() { return cLinesAssignment_1_1; }
		
		//NewLineLine
		public RuleCall getLinesNewLineLineParserRuleCall_1_1_0() { return cLinesNewLineLineParserRuleCall_1_1_0; }
		
		//lines+=Code
		public Assignment getLinesAssignment_1_2() { return cLinesAssignment_1_2; }
		
		//Code
		public RuleCall getLinesCodeParserRuleCall_1_2_0() { return cLinesCodeParserRuleCall_1_2_0; }
	}
	public class PreprocessorDirectivesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.PreprocessorDirectives");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cPreprocessorDirectivesAction_0 = (Action)cGroup.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final RuleCall cHASHTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final RuleCall cWSTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cDirectiveAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final RuleCall cDirectiveIncludeDirectiveParserRuleCall_4_0_0 = (RuleCall)cDirectiveAssignment_4_0.eContents().get(0);
		private final Assignment cDirectiveAssignment_4_1 = (Assignment)cAlternatives_4.eContents().get(1);
		private final RuleCall cDirectiveDefineDirectiveParserRuleCall_4_1_0 = (RuleCall)cDirectiveAssignment_4_1.eContents().get(0);
		private final Assignment cDirectiveAssignment_4_2 = (Assignment)cAlternatives_4.eContents().get(2);
		private final RuleCall cDirectiveErrorDirectiveParserRuleCall_4_2_0 = (RuleCall)cDirectiveAssignment_4_2.eContents().get(0);
		private final Assignment cDirectiveAssignment_4_3 = (Assignment)cAlternatives_4.eContents().get(3);
		private final RuleCall cDirectiveUnDefineDirectiveParserRuleCall_4_3_0 = (RuleCall)cDirectiveAssignment_4_3.eContents().get(0);
		private final Assignment cDirectiveAssignment_4_4 = (Assignment)cAlternatives_4.eContents().get(4);
		private final RuleCall cDirectivePragmaDirectiveParserRuleCall_4_4_0 = (RuleCall)cDirectiveAssignment_4_4.eContents().get(0);
		private final RuleCall cNEWLINETerminalRuleCall_5 = (RuleCall)cGroup.eContents().get(5);
		
		//PreprocessorDirectives SourceCodeLine:
		//	{PreprocessorDirectives} WS* HASH WS* (directive=IncludeDirective
		//	| directive=DefineDirective
		//	| directive=ErrorDirective
		//	| directive=UnDefineDirective
		//	| directive=PragmaDirective) NEWLINE
		@Override public ParserRule getRule() { return rule; }
		
		//{PreprocessorDirectives} WS* HASH WS* (directive=IncludeDirective | directive=DefineDirective | directive=ErrorDirective
		//| directive=UnDefineDirective | directive=PragmaDirective) NEWLINE
		public Group getGroup() { return cGroup; }
		
		//{PreprocessorDirectives}
		public Action getPreprocessorDirectivesAction_0() { return cPreprocessorDirectivesAction_0; }
		
		//WS*
		public RuleCall getWSTerminalRuleCall_1() { return cWSTerminalRuleCall_1; }
		
		//HASH
		public RuleCall getHASHTerminalRuleCall_2() { return cHASHTerminalRuleCall_2; }
		
		//WS*
		public RuleCall getWSTerminalRuleCall_3() { return cWSTerminalRuleCall_3; }
		
		//(directive=IncludeDirective | directive=DefineDirective | directive=ErrorDirective | directive=UnDefineDirective |
		//directive=PragmaDirective)
		public Alternatives getAlternatives_4() { return cAlternatives_4; }
		
		//directive=IncludeDirective
		public Assignment getDirectiveAssignment_4_0() { return cDirectiveAssignment_4_0; }
		
		//IncludeDirective
		public RuleCall getDirectiveIncludeDirectiveParserRuleCall_4_0_0() { return cDirectiveIncludeDirectiveParserRuleCall_4_0_0; }
		
		//directive=DefineDirective
		public Assignment getDirectiveAssignment_4_1() { return cDirectiveAssignment_4_1; }
		
		//DefineDirective
		public RuleCall getDirectiveDefineDirectiveParserRuleCall_4_1_0() { return cDirectiveDefineDirectiveParserRuleCall_4_1_0; }
		
		//directive=ErrorDirective
		public Assignment getDirectiveAssignment_4_2() { return cDirectiveAssignment_4_2; }
		
		//ErrorDirective
		public RuleCall getDirectiveErrorDirectiveParserRuleCall_4_2_0() { return cDirectiveErrorDirectiveParserRuleCall_4_2_0; }
		
		//directive=UnDefineDirective
		public Assignment getDirectiveAssignment_4_3() { return cDirectiveAssignment_4_3; }
		
		//UnDefineDirective
		public RuleCall getDirectiveUnDefineDirectiveParserRuleCall_4_3_0() { return cDirectiveUnDefineDirectiveParserRuleCall_4_3_0; }
		
		//directive=PragmaDirective
		public Assignment getDirectiveAssignment_4_4() { return cDirectiveAssignment_4_4; }
		
		//PragmaDirective
		public RuleCall getDirectivePragmaDirectiveParserRuleCall_4_4_0() { return cDirectivePragmaDirectiveParserRuleCall_4_4_0; }
		
		//NEWLINE
		public RuleCall getNEWLINETerminalRuleCall_5() { return cNEWLINETerminalRuleCall_5; }
	}
	public class IncludeDirectiveElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.IncludeDirective");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cIncludeDirectiveAction_0 = (Action)cGroup.eContents().get(0);
		private final RuleCall cINCLUDETerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final Assignment cStringAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cStringMyCodeLineParserRuleCall_3_0 = (RuleCall)cStringAssignment_3.eContents().get(0);
		
		//IncludeDirective:
		//	{IncludeDirective} INCLUDE WS+ string=MyCodeLine;
		@Override public ParserRule getRule() { return rule; }
		
		//{IncludeDirective} INCLUDE WS+ string=MyCodeLine
		public Group getGroup() { return cGroup; }
		
		//{IncludeDirective}
		public Action getIncludeDirectiveAction_0() { return cIncludeDirectiveAction_0; }
		
		//INCLUDE
		public RuleCall getINCLUDETerminalRuleCall_1() { return cINCLUDETerminalRuleCall_1; }
		
		//WS+
		public RuleCall getWSTerminalRuleCall_2() { return cWSTerminalRuleCall_2; }
		
		//string=MyCodeLine
		public Assignment getStringAssignment_3() { return cStringAssignment_3; }
		
		//MyCodeLine
		public RuleCall getStringMyCodeLineParserRuleCall_3_0() { return cStringMyCodeLineParserRuleCall_3_0; }
	}
	public class DefineDirectiveElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.DefineDirective");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cDefineDirectiveAction_0 = (Action)cGroup.eContents().get(0);
		private final RuleCall cDEFINETerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final Assignment cIdAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cIdIDTerminalRuleCall_3_0 = (RuleCall)cIdAssignment_3.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_4 = (RuleCall)cGroup.eContents().get(4);
		private final Assignment cStringAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cStringMyCodeLineParserRuleCall_5_0 = (RuleCall)cStringAssignment_5.eContents().get(0);
		
		//DefineDirective:
		//	{DefineDirective} DEFINE WS+ id=ID WS* string=MyCodeLine;
		@Override public ParserRule getRule() { return rule; }
		
		//{DefineDirective} DEFINE WS+ id=ID WS* string=MyCodeLine
		public Group getGroup() { return cGroup; }
		
		//{DefineDirective}
		public Action getDefineDirectiveAction_0() { return cDefineDirectiveAction_0; }
		
		//DEFINE
		public RuleCall getDEFINETerminalRuleCall_1() { return cDEFINETerminalRuleCall_1; }
		
		//WS+
		public RuleCall getWSTerminalRuleCall_2() { return cWSTerminalRuleCall_2; }
		
		//id=ID
		public Assignment getIdAssignment_3() { return cIdAssignment_3; }
		
		//ID
		public RuleCall getIdIDTerminalRuleCall_3_0() { return cIdIDTerminalRuleCall_3_0; }
		
		//WS*
		public RuleCall getWSTerminalRuleCall_4() { return cWSTerminalRuleCall_4; }
		
		//string=MyCodeLine
		public Assignment getStringAssignment_5() { return cStringAssignment_5; }
		
		//MyCodeLine
		public RuleCall getStringMyCodeLineParserRuleCall_5_0() { return cStringMyCodeLineParserRuleCall_5_0; }
	}
	public class ErrorDirectiveElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.ErrorDirective");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cErrorDirectiveAction_0 = (Action)cGroup.eContents().get(0);
		private final RuleCall cERRORTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final Assignment cMsgAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cMsgMyCodeLineParserRuleCall_3_0 = (RuleCall)cMsgAssignment_3.eContents().get(0);
		
		//ErrorDirective:
		//	{ErrorDirective} ERROR WS+ msg=MyCodeLine;
		@Override public ParserRule getRule() { return rule; }
		
		//{ErrorDirective} ERROR WS+ msg=MyCodeLine
		public Group getGroup() { return cGroup; }
		
		//{ErrorDirective}
		public Action getErrorDirectiveAction_0() { return cErrorDirectiveAction_0; }
		
		//ERROR
		public RuleCall getERRORTerminalRuleCall_1() { return cERRORTerminalRuleCall_1; }
		
		//WS+
		public RuleCall getWSTerminalRuleCall_2() { return cWSTerminalRuleCall_2; }
		
		//msg=MyCodeLine
		public Assignment getMsgAssignment_3() { return cMsgAssignment_3; }
		
		//MyCodeLine
		public RuleCall getMsgMyCodeLineParserRuleCall_3_0() { return cMsgMyCodeLineParserRuleCall_3_0; }
	}
	public class UnDefineDirectiveElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.UnDefineDirective");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cUnDefineDirectiveAction_0 = (Action)cGroup.eContents().get(0);
		private final RuleCall cUNDEFTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final Assignment cIdAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cIdIDTerminalRuleCall_3_0 = (RuleCall)cIdAssignment_3.eContents().get(0);
		
		//UnDefineDirective:
		//	{UnDefineDirective} UNDEF WS+ id=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//{UnDefineDirective} UNDEF WS+ id=ID
		public Group getGroup() { return cGroup; }
		
		//{UnDefineDirective}
		public Action getUnDefineDirectiveAction_0() { return cUnDefineDirectiveAction_0; }
		
		//UNDEF
		public RuleCall getUNDEFTerminalRuleCall_1() { return cUNDEFTerminalRuleCall_1; }
		
		//WS+
		public RuleCall getWSTerminalRuleCall_2() { return cWSTerminalRuleCall_2; }
		
		//id=ID
		public Assignment getIdAssignment_3() { return cIdAssignment_3; }
		
		//ID
		public RuleCall getIdIDTerminalRuleCall_3_0() { return cIdIDTerminalRuleCall_3_0; }
	}
	public class PragmaDirectiveElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.PragmaDirective");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cPragmaDirectiveAction_0 = (Action)cGroup.eContents().get(0);
		private final RuleCall cPRAGMATerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//PragmaDirective:
		//	{PragmaDirective} PRAGMA;
		@Override public ParserRule getRule() { return rule; }
		
		//{PragmaDirective} PRAGMA
		public Group getGroup() { return cGroup; }
		
		//{PragmaDirective}
		public Action getPragmaDirectiveAction_0() { return cPragmaDirectiveAction_0; }
		
		//PRAGMA
		public RuleCall getPRAGMATerminalRuleCall_1() { return cPRAGMATerminalRuleCall_1; }
	}
	public class NewLineLineElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.NewLineLine");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cNewLineLineAction_0 = (Action)cGroup.eContents().get(0);
		private final RuleCall cNEWLINETerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//NewLineLine SourceCodeLine:
		//	{NewLineLine} NEWLINE
		@Override public ParserRule getRule() { return rule; }
		
		//{NewLineLine} NEWLINE
		public Group getGroup() { return cGroup; }
		
		//{NewLineLine}
		public Action getNewLineLineAction_0() { return cNewLineLineAction_0; }
		
		//NEWLINE
		public RuleCall getNEWLINETerminalRuleCall_1() { return cNEWLINETerminalRuleCall_1; }
	}
	public class CodeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.Code");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cCodeAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cCodeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cCodeMyCodeLineExtendedParserRuleCall_1_0 = (RuleCall)cCodeAssignment_1.eContents().get(0);
		private final RuleCall cNEWLINETerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		
		//Code SourceCodeLine:
		//	{Code} code=MyCodeLineExtended
		//	NEWLINE
		@Override public ParserRule getRule() { return rule; }
		
		//{Code} code=MyCodeLineExtended NEWLINE
		public Group getGroup() { return cGroup; }
		
		//{Code}
		public Action getCodeAction_0() { return cCodeAction_0; }
		
		//code=MyCodeLineExtended
		public Assignment getCodeAssignment_1() { return cCodeAssignment_1; }
		
		//MyCodeLineExtended
		public RuleCall getCodeMyCodeLineExtendedParserRuleCall_1_0() { return cCodeMyCodeLineExtendedParserRuleCall_1_0; }
		
		//NEWLINE
		public RuleCall getNEWLINETerminalRuleCall_2() { return cNEWLINETerminalRuleCall_2; }
	}
	public class MyCodeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.MyCode");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cSPECIALTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cINCLUDETerminalRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cDEFINETerminalRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cERRORTerminalRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cPRAGMATerminalRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		
		//MyCode:
		//	ID | SPECIAL | INCLUDE | DEFINE | ERROR | PRAGMA;
		@Override public ParserRule getRule() { return rule; }
		
		//ID | SPECIAL | INCLUDE | DEFINE | ERROR | PRAGMA
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//SPECIAL
		public RuleCall getSPECIALTerminalRuleCall_1() { return cSPECIALTerminalRuleCall_1; }
		
		//INCLUDE
		public RuleCall getINCLUDETerminalRuleCall_2() { return cINCLUDETerminalRuleCall_2; }
		
		//DEFINE
		public RuleCall getDEFINETerminalRuleCall_3() { return cDEFINETerminalRuleCall_3; }
		
		//ERROR
		public RuleCall getERRORTerminalRuleCall_4() { return cERRORTerminalRuleCall_4; }
		
		//PRAGMA
		public RuleCall getPRAGMATerminalRuleCall_5() { return cPRAGMATerminalRuleCall_5; }
	}
	public class MyCodeLineElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.MyCodeLine");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cMyCodeParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//MyCodeLine:
		//	MyCode | WS+;
		@Override public ParserRule getRule() { return rule; }
		
		//MyCode | WS+
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//MyCode
		public RuleCall getMyCodeParserRuleCall_0() { return cMyCodeParserRuleCall_0; }
		
		//WS
		public RuleCall getWSTerminalRuleCall_1() { return cWSTerminalRuleCall_1; }
	}
	public class MyCodeLineExtendedElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.MyCodeLineExtended");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final RuleCall cMyCodeParserRuleCall_1_0 = (RuleCall)cGroup_1.eContents().get(0);
		private final Alternatives cAlternatives_1_1 = (Alternatives)cGroup_1.eContents().get(1);
		private final RuleCall cMyCodeLineParserRuleCall_1_1_0 = (RuleCall)cAlternatives_1_1.eContents().get(0);
		private final RuleCall cHASHTerminalRuleCall_1_1_1 = (RuleCall)cAlternatives_1_1.eContents().get(1);
		
		//MyCodeLineExtended:
		//	WS* (MyCode (MyCodeLine | HASH)*)?;
		@Override public ParserRule getRule() { return rule; }
		
		//WS* (MyCode (MyCodeLine | HASH)*)?
		public Group getGroup() { return cGroup; }
		
		//WS*
		public RuleCall getWSTerminalRuleCall_0() { return cWSTerminalRuleCall_0; }
		
		//(MyCode (MyCodeLine | HASH)*)?
		public Group getGroup_1() { return cGroup_1; }
		
		//MyCode
		public RuleCall getMyCodeParserRuleCall_1_0() { return cMyCodeParserRuleCall_1_0; }
		
		//(MyCodeLine | HASH)*
		public Alternatives getAlternatives_1_1() { return cAlternatives_1_1; }
		
		//MyCodeLine
		public RuleCall getMyCodeLineParserRuleCall_1_1_0() { return cMyCodeLineParserRuleCall_1_1_0; }
		
		//HASH
		public RuleCall getHASHTerminalRuleCall_1_1_1() { return cHASHTerminalRuleCall_1_1_1; }
	}
	
	
	private final ModelElements pModel;
	private final TranslationUnitElements pTranslationUnit;
	private final PreprocessorDirectivesElements pPreprocessorDirectives;
	private final IncludeDirectiveElements pIncludeDirective;
	private final DefineDirectiveElements pDefineDirective;
	private final ErrorDirectiveElements pErrorDirective;
	private final UnDefineDirectiveElements pUnDefineDirective;
	private final PragmaDirectiveElements pPragmaDirective;
	private final NewLineLineElements pNewLineLine;
	private final CodeElements pCode;
	private final MyCodeElements pMyCode;
	private final MyCodeLineElements pMyCodeLine;
	private final MyCodeLineExtendedElements pMyCodeLineExtended;
	private final TerminalRule tHASH;
	private final TerminalRule tINCLUDE;
	private final TerminalRule tDEFINE;
	private final TerminalRule tERROR;
	private final TerminalRule tUNDEF;
	private final TerminalRule tPRAGMA;
	private final TerminalRule tLINEFEED;
	private final TerminalRule tCARRIAGERETURN;
	private final TerminalRule tNEWLINE;
	private final TerminalRule tBACKSLASH;
	private final TerminalRule tLINEBREAK;
	private final TerminalRule tSPACE;
	private final TerminalRule tTAB;
	private final TerminalRule tWS;
	private final TerminalRule tID;
	private final TerminalRule tID_NONDIGIT;
	private final TerminalRule tDIGIT;
	private final TerminalRule tNONDIGIT_LETTER;
	private final TerminalRule tUNIVERSAL_CHARACTER;
	private final TerminalRule tHEX_QUAD;
	private final TerminalRule tHEXADECIMAL_DIGIT;
	private final TerminalRule tSPECIAL;
	
	private final Grammar grammar;

	@Inject
	public CPreprocessGrammarAccess(GrammarProvider grammarProvider) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.pModel = new ModelElements();
		this.pTranslationUnit = new TranslationUnitElements();
		this.pPreprocessorDirectives = new PreprocessorDirectivesElements();
		this.pIncludeDirective = new IncludeDirectiveElements();
		this.pDefineDirective = new DefineDirectiveElements();
		this.pErrorDirective = new ErrorDirectiveElements();
		this.pUnDefineDirective = new UnDefineDirectiveElements();
		this.pPragmaDirective = new PragmaDirectiveElements();
		this.pNewLineLine = new NewLineLineElements();
		this.pCode = new CodeElements();
		this.pMyCode = new MyCodeElements();
		this.pMyCodeLine = new MyCodeLineElements();
		this.pMyCodeLineExtended = new MyCodeLineExtendedElements();
		this.tHASH = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.HASH");
		this.tINCLUDE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.INCLUDE");
		this.tDEFINE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.DEFINE");
		this.tERROR = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.ERROR");
		this.tUNDEF = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.UNDEF");
		this.tPRAGMA = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.PRAGMA");
		this.tLINEFEED = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.LINEFEED");
		this.tCARRIAGERETURN = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.CARRIAGERETURN");
		this.tNEWLINE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.NEWLINE");
		this.tBACKSLASH = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.BACKSLASH");
		this.tLINEBREAK = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.LINEBREAK");
		this.tSPACE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.SPACE");
		this.tTAB = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.TAB");
		this.tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.WS");
		this.tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.ID");
		this.tID_NONDIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.ID_NONDIGIT");
		this.tDIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.DIGIT");
		this.tNONDIGIT_LETTER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.NONDIGIT_LETTER");
		this.tUNIVERSAL_CHARACTER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.UNIVERSAL_CHARACTER");
		this.tHEX_QUAD = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.HEX_QUAD");
		this.tHEXADECIMAL_DIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.HEXADECIMAL_DIGIT");
		this.tSPECIAL = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "at.jku.weiner.cpreprocess.CPreprocess.SPECIAL");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("at.jku.weiner.cpreprocess.CPreprocess".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	
	//Model:
	//	{Model} units+=TranslationUnit;
	public ModelElements getModelAccess() {
		return pModel;
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}
	
	//TranslationUnit:
	//	{TranslationUnit} (lines+=PreprocessorDirectives
	//	| lines+=NewLineLine
	//	| lines+=Code)*;
	public TranslationUnitElements getTranslationUnitAccess() {
		return pTranslationUnit;
	}
	
	public ParserRule getTranslationUnitRule() {
		return getTranslationUnitAccess().getRule();
	}
	
	//PreprocessorDirectives SourceCodeLine:
	//	{PreprocessorDirectives} WS* HASH WS* (directive=IncludeDirective
	//	| directive=DefineDirective
	//	| directive=ErrorDirective
	//	| directive=UnDefineDirective
	//	| directive=PragmaDirective) NEWLINE
	public PreprocessorDirectivesElements getPreprocessorDirectivesAccess() {
		return pPreprocessorDirectives;
	}
	
	public ParserRule getPreprocessorDirectivesRule() {
		return getPreprocessorDirectivesAccess().getRule();
	}
	
	//IncludeDirective:
	//	{IncludeDirective} INCLUDE WS+ string=MyCodeLine;
	public IncludeDirectiveElements getIncludeDirectiveAccess() {
		return pIncludeDirective;
	}
	
	public ParserRule getIncludeDirectiveRule() {
		return getIncludeDirectiveAccess().getRule();
	}
	
	//DefineDirective:
	//	{DefineDirective} DEFINE WS+ id=ID WS* string=MyCodeLine;
	public DefineDirectiveElements getDefineDirectiveAccess() {
		return pDefineDirective;
	}
	
	public ParserRule getDefineDirectiveRule() {
		return getDefineDirectiveAccess().getRule();
	}
	
	//ErrorDirective:
	//	{ErrorDirective} ERROR WS+ msg=MyCodeLine;
	public ErrorDirectiveElements getErrorDirectiveAccess() {
		return pErrorDirective;
	}
	
	public ParserRule getErrorDirectiveRule() {
		return getErrorDirectiveAccess().getRule();
	}
	
	//UnDefineDirective:
	//	{UnDefineDirective} UNDEF WS+ id=ID;
	public UnDefineDirectiveElements getUnDefineDirectiveAccess() {
		return pUnDefineDirective;
	}
	
	public ParserRule getUnDefineDirectiveRule() {
		return getUnDefineDirectiveAccess().getRule();
	}
	
	//PragmaDirective:
	//	{PragmaDirective} PRAGMA;
	public PragmaDirectiveElements getPragmaDirectiveAccess() {
		return pPragmaDirective;
	}
	
	public ParserRule getPragmaDirectiveRule() {
		return getPragmaDirectiveAccess().getRule();
	}
	
	//NewLineLine SourceCodeLine:
	//	{NewLineLine} NEWLINE
	public NewLineLineElements getNewLineLineAccess() {
		return pNewLineLine;
	}
	
	public ParserRule getNewLineLineRule() {
		return getNewLineLineAccess().getRule();
	}
	
	//Code SourceCodeLine:
	//	{Code} code=MyCodeLineExtended
	//	NEWLINE
	public CodeElements getCodeAccess() {
		return pCode;
	}
	
	public ParserRule getCodeRule() {
		return getCodeAccess().getRule();
	}
	
	//MyCode:
	//	ID | SPECIAL | INCLUDE | DEFINE | ERROR | PRAGMA;
	public MyCodeElements getMyCodeAccess() {
		return pMyCode;
	}
	
	public ParserRule getMyCodeRule() {
		return getMyCodeAccess().getRule();
	}
	
	//MyCodeLine:
	//	MyCode | WS+;
	public MyCodeLineElements getMyCodeLineAccess() {
		return pMyCodeLine;
	}
	
	public ParserRule getMyCodeLineRule() {
		return getMyCodeLineAccess().getRule();
	}
	
	//MyCodeLineExtended:
	//	WS* (MyCode (MyCodeLine | HASH)*)?;
	public MyCodeLineExtendedElements getMyCodeLineExtendedAccess() {
		return pMyCodeLineExtended;
	}
	
	public ParserRule getMyCodeLineExtendedRule() {
		return getMyCodeLineExtendedAccess().getRule();
	}
	
	//terminal HASH:
	//	'#';
	public TerminalRule getHASHRule() {
		return tHASH;
	}
	
	//terminal INCLUDE:
	//	'include';
	public TerminalRule getINCLUDERule() {
		return tINCLUDE;
	}
	
	//terminal DEFINE:
	//	'define';
	public TerminalRule getDEFINERule() {
		return tDEFINE;
	}
	
	//terminal ERROR:
	//	'error';
	public TerminalRule getERRORRule() {
		return tERROR;
	}
	
	//terminal UNDEF:
	//	'undef';
	public TerminalRule getUNDEFRule() {
		return tUNDEF;
	}
	
	//terminal PRAGMA:
	//	'pragma';
	public TerminalRule getPRAGMARule() {
		return tPRAGMA;
	}
	
	//terminal fragment LINEFEED:
	//	'\n';
	public TerminalRule getLINEFEEDRule() {
		return tLINEFEED;
	}
	
	//terminal fragment CARRIAGERETURN:
	//	'\r';
	public TerminalRule getCARRIAGERETURNRule() {
		return tCARRIAGERETURN;
	}
	
	//terminal NEWLINE:
	//	CARRIAGERETURN | LINEFEED;
	public TerminalRule getNEWLINERule() {
		return tNEWLINE;
	}
	
	//terminal fragment BACKSLASH:
	//	'\\';
	public TerminalRule getBACKSLASHRule() {
		return tBACKSLASH;
	}
	
	//terminal fragment LINEBREAK:
	//	BACKSLASH NEWLINE;
	public TerminalRule getLINEBREAKRule() {
		return tLINEBREAK;
	}
	
	//terminal fragment SPACE:
	//	' ';
	public TerminalRule getSPACERule() {
		return tSPACE;
	}
	
	//terminal fragment TAB:
	//	'\t';
	public TerminalRule getTABRule() {
		return tTAB;
	}
	
	//terminal WS:
	//	SPACE | TAB | LINEBREAK;
	public TerminalRule getWSRule() {
		return tWS;
	}
	
	//terminal ID:
	//	ID_NONDIGIT (ID_NONDIGIT
	//	| DIGIT)*;
	public TerminalRule getIDRule() {
		return tID;
	}
	
	//terminal fragment ID_NONDIGIT:
	//	NONDIGIT_LETTER
	//	| UNIVERSAL_CHARACTER;
	public TerminalRule getID_NONDIGITRule() {
		return tID_NONDIGIT;
	}
	
	//terminal fragment DIGIT:
	//	'0'..'9';
	public TerminalRule getDIGITRule() {
		return tDIGIT;
	}
	
	//terminal fragment NONDIGIT_LETTER:
	//	'a'..'z'
	//	| 'A'..'Z'
	//	| '_';
	public TerminalRule getNONDIGIT_LETTERRule() {
		return tNONDIGIT_LETTER;
	}
	
	//terminal fragment UNIVERSAL_CHARACTER:
	//	'\\u' HEX_QUAD
	//	| '\\U' HEX_QUAD HEX_QUAD;
	public TerminalRule getUNIVERSAL_CHARACTERRule() {
		return tUNIVERSAL_CHARACTER;
	}
	
	//terminal fragment HEX_QUAD:
	//	HEXADECIMAL_DIGIT HEXADECIMAL_DIGIT
	//	HEXADECIMAL_DIGIT HEXADECIMAL_DIGIT;
	public TerminalRule getHEX_QUADRule() {
		return tHEX_QUAD;
	}
	
	//terminal fragment HEXADECIMAL_DIGIT:
	//	'0'..'9'
	//	| 'a'..'f'
	//	| 'A'..'F';
	public TerminalRule getHEXADECIMAL_DIGITRule() {
		return tHEXADECIMAL_DIGIT;
	}
	
	//terminal SPECIAL:
	//	.;
	public TerminalRule getSPECIALRule() {
		return tSPECIAL;
	}
}
