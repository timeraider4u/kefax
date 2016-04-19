/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
parser grammar InternalCmdArgsParser;

options {
	tokenVocab=InternalCmdArgsLexer;
	superClass=AbstractInternalAntlrParser;
	
}

@header {
package at.jku.weiner.c.cmdarguments.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import at.jku.weiner.c.cmdarguments.services.CmdArgsGrammarAccess;

}

@members {


	private CmdArgsGrammarAccess grammarAccess;
	 	
	public InternalCmdArgsParser(TokenStream input, CmdArgsGrammarAccess grammarAccess) {
		this(input);
		this.grammarAccess = grammarAccess;
		registerRules(grammarAccess.getGrammar());
	}
	
	@Override
	protected String getFirstRuleName() {
		return "Model";	
	} 
	   	   	
	@Override
	protected CmdArgsGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}
}

@rulecatch { 
	catch (RecognitionException re) { 
	    recover(input,re); 
	    appendSkippedTokens();
	}
}




// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	 iv_ruleModel=ruleModel 
	 { $current=$iv_ruleModel.current; } 
	 EOF 
;

// Rule Model
ruleModel returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getModelAccess().getModelAction_0(),
            $current);
    }
)((
(
		{ 
	        newCompositeNode(grammarAccess.getModelAccess().getLinesCmdLineParserRuleCall_1_0_0()); 
	    }
		lv_lines_1_0=ruleCmdLine		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelRule());
	        }
       		add(
       			$current, 
       			"lines",
        		lv_lines_1_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.CmdLine");
	        afterParserOrEnumRuleCall();
	    }

)
)((this_NEWLINE_2=RULE_NEWLINE
    { 
    newLeafNode(this_NEWLINE_2, grammarAccess.getModelAccess().getNEWLINETerminalRuleCall_1_1_0()); 
    }
)+(
(
		{ 
	        newCompositeNode(grammarAccess.getModelAccess().getLinesCmdLineParserRuleCall_1_1_1_0()); 
	    }
		lv_lines_3_0=ruleCmdLine		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelRule());
	        }
       		add(
       			$current, 
       			"lines",
        		lv_lines_3_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.CmdLine");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?(this_NEWLINE_4=RULE_NEWLINE
    { 
    newLeafNode(this_NEWLINE_4, grammarAccess.getModelAccess().getNEWLINETerminalRuleCall_2()); 
    }
)?)
;





// Entry rule entryRuleCmdLine
entryRuleCmdLine returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getCmdLineRule()); }
	 iv_ruleCmdLine=ruleCmdLine 
	 { $current=$iv_ruleCmdLine.current; } 
	 EOF 
;

// Rule CmdLine
ruleCmdLine returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getCmdLineAccess().getCmdLineAction_0(),
            $current);
    }
)(
(
		lv_start_1_0=RULE_ID
		{
			newLeafNode(lv_start_1_0, grammarAccess.getCmdLineAccess().getStartIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCmdLineRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"start",
        		lv_start_1_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.ID");
	    }

)
)(this_WS_2=RULE_WS
    { 
    newLeafNode(this_WS_2, grammarAccess.getCmdLineAccess().getWSTerminalRuleCall_2()); 
    }
)+this_SKW_COLON_3=RULE_SKW_COLON
    { 
    newLeafNode(this_SKW_COLON_3, grammarAccess.getCmdLineAccess().getSKW_COLONTerminalRuleCall_3()); 
    }
this_SKW_ASSIGN_4=RULE_SKW_ASSIGN
    { 
    newLeafNode(this_SKW_ASSIGN_4, grammarAccess.getCmdLineAccess().getSKW_ASSIGNTerminalRuleCall_4()); 
    }
(this_WS_5=RULE_WS
    { 
    newLeafNode(this_WS_5, grammarAccess.getCmdLineAccess().getWSTerminalRuleCall_5()); 
    }
)+((
(
		{ 
	        newCompositeNode(grammarAccess.getCmdLineAccess().getArgumentsArgumentParserRuleCall_6_0_0()); 
	    }
		lv_arguments_6_0=ruleArgument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCmdLineRule());
	        }
       		add(
       			$current, 
       			"arguments",
        		lv_arguments_6_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.Argument");
	        afterParserOrEnumRuleCall();
	    }

)
)((this_WS_7=RULE_WS
    { 
    newLeafNode(this_WS_7, grammarAccess.getCmdLineAccess().getWSTerminalRuleCall_6_1_0()); 
    }
)+(
(
		{ 
	        newCompositeNode(grammarAccess.getCmdLineAccess().getArgumentsArgumentParserRuleCall_6_1_1_0()); 
	    }
		lv_arguments_8_0=ruleArgument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCmdLineRule());
	        }
       		add(
       			$current, 
       			"arguments",
        		lv_arguments_8_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.Argument");
	        afterParserOrEnumRuleCall();
	    }

)
))*))
;





// Entry rule entryRuleArgument
entryRuleArgument returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getArgumentRule()); }
	 iv_ruleArgument=ruleArgument 
	 { $current=$iv_ruleArgument.current; } 
	 EOF 
;

// Rule Argument
ruleArgument returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getArgumentAccess().getArgumentAction_0(),
            $current);
    }
)((
    { 
        newCompositeNode(grammarAccess.getArgumentAccess().getDefineParserRuleCall_1_0_0()); 
    }
ruleDefine
    {
        afterParserOrEnumRuleCall();
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getArgumentAccess().getMacroMacroParserRuleCall_1_0_1_0()); 
	    }
		lv_macro_2_0=ruleMacro		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getArgumentRule());
	        }
       		set(
       			$current, 
       			"macro",
        		lv_macro_2_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.Macro");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |((
(
		{ 
	        newCompositeNode(grammarAccess.getArgumentAccess().getIncDirIncDirParserRuleCall_1_1_0_0()); 
	    }
		lv_incDir_3_0=ruleIncDir		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getArgumentRule());
	        }
       		set(
       			$current, 
       			"incDir",
        		true, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.IncDir");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getArgumentAccess().getUseIncDirPathCmdParserRuleCall_1_1_1_0()); 
	    }
		lv_useIncDir_4_0=rulePathCmd		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getArgumentRule());
	        }
       		set(
       			$current, 
       			"useIncDir",
        		lv_useIncDir_4_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.PathCmd");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |((
(
		{ 
	        newCompositeNode(grammarAccess.getArgumentAccess().getIncSysIncSysParserRuleCall_1_2_0_0()); 
	    }
		lv_incSys_5_0=ruleIncSys		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getArgumentRule());
	        }
       		set(
       			$current, 
       			"incSys",
        		true, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.IncSys");
	        afterParserOrEnumRuleCall();
	    }

)
)(this_WS_6=RULE_WS
    { 
    newLeafNode(this_WS_6, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_2_1()); 
    }
)+(
(
		{ 
	        newCompositeNode(grammarAccess.getArgumentAccess().getUseIncDirPathCmdParserRuleCall_1_2_2_0()); 
	    }
		lv_useIncDir_7_0=rulePathCmd		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getArgumentRule());
	        }
       		set(
       			$current, 
       			"useIncDir",
        		lv_useIncDir_7_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.PathCmd");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getArgumentAccess().getNostdincNoStdIncParserRuleCall_1_3_0()); 
	    }
		lv_nostdinc_8_0=ruleNoStdInc		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getArgumentRule());
	        }
       		set(
       			$current, 
       			"nostdinc",
        		true, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.NoStdInc");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
    { 
        newCompositeNode(grammarAccess.getArgumentAccess().getIncludeParserRuleCall_1_4_0()); 
    }
ruleInclude
    {
        afterParserOrEnumRuleCall();
    }
(this_WS_10=RULE_WS
    { 
    newLeafNode(this_WS_10, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_4_1()); 
    }
)+(
(
		{ 
	        newCompositeNode(grammarAccess.getArgumentAccess().getIncludePathCmdParserRuleCall_1_4_2_0()); 
	    }
		lv_include_11_0=rulePathCmd		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getArgumentRule());
	        }
       		set(
       			$current, 
       			"include",
        		lv_include_11_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.PathCmd");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |(
    { 
        newCompositeNode(grammarAccess.getArgumentAccess().getOutputParserRuleCall_1_5_0()); 
    }
ruleOutput
    {
        afterParserOrEnumRuleCall();
    }
(this_WS_13=RULE_WS
    { 
    newLeafNode(this_WS_13, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_5_1()); 
    }
)+(
(
		{ 
	        newCompositeNode(grammarAccess.getArgumentAccess().getOutPathCmdParserRuleCall_1_5_2_0()); 
	    }
		lv_out_14_0=rulePathCmd		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getArgumentRule());
	        }
       		set(
       			$current, 
       			"out",
        		lv_out_14_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.PathCmd");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |(
    { 
        newCompositeNode(grammarAccess.getArgumentAccess().getLangParserRuleCall_1_6_0()); 
    }
ruleLang
    {
        afterParserOrEnumRuleCall();
    }
(this_WS_16=RULE_WS
    { 
    newLeafNode(this_WS_16, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_6_1()); 
    }
)+(
(
		{ 
	        newCompositeNode(grammarAccess.getArgumentAccess().getLangPathCmdParserRuleCall_1_6_2_0()); 
	    }
		lv_lang_17_0=rulePathCmd		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getArgumentRule());
	        }
       		set(
       			$current, 
       			"lang",
        		lv_lang_17_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.PathCmd");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |(this_SKW_MINUS_18=RULE_SKW_MINUS
    { 
    newLeafNode(this_SKW_MINUS_18, grammarAccess.getArgumentAccess().getSKW_MINUSTerminalRuleCall_1_7_0()); 
    }
(this_SKW_MINUS_19=RULE_SKW_MINUS
    { 
    newLeafNode(this_SKW_MINUS_19, grammarAccess.getArgumentAccess().getSKW_MINUSTerminalRuleCall_1_7_1()); 
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getArgumentAccess().getOptionOptionParserRuleCall_1_7_2_0()); 
	    }
		lv_option_20_0=ruleOption		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getArgumentRule());
	        }
       		set(
       			$current, 
       			"option",
        		lv_option_20_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.Option");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getArgumentAccess().getInOptionParserRuleCall_1_8_0()); 
	    }
		lv_in_21_0=ruleOption		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getArgumentRule());
	        }
       		set(
       			$current, 
       			"in",
        		lv_in_21_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.Option");
	        afterParserOrEnumRuleCall();
	    }

)
)))
;





// Entry rule entryRuleDefine
entryRuleDefine returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getDefineRule()); } 
	 iv_ruleDefine=ruleDefine 
	 { $current=$iv_ruleDefine.current.getText(); }  
	 EOF 
;

// Rule Define
ruleDefine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
    this_KW_DEFINE_0=RULE_KW_DEFINE    {
		$current.merge(this_KW_DEFINE_0);
    }

    { 
    newLeafNode(this_KW_DEFINE_0, grammarAccess.getDefineAccess().getKW_DEFINETerminalRuleCall()); 
    }

    ;





// Entry rule entryRuleIncDir
entryRuleIncDir returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getIncDirRule()); } 
	 iv_ruleIncDir=ruleIncDir 
	 { $current=$iv_ruleIncDir.current.getText(); }  
	 EOF 
;

// Rule IncDir
ruleIncDir returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
    this_KW_INCDIR_0=RULE_KW_INCDIR    {
		$current.merge(this_KW_INCDIR_0);
    }

    { 
    newLeafNode(this_KW_INCDIR_0, grammarAccess.getIncDirAccess().getKW_INCDIRTerminalRuleCall()); 
    }

    ;





// Entry rule entryRuleIncSys
entryRuleIncSys returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getIncSysRule()); } 
	 iv_ruleIncSys=ruleIncSys 
	 { $current=$iv_ruleIncSys.current.getText(); }  
	 EOF 
;

// Rule IncSys
ruleIncSys returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
(    this_SKW_MINUS_0=RULE_SKW_MINUS    {
		$current.merge(this_SKW_MINUS_0);
    }

    { 
    newLeafNode(this_SKW_MINUS_0, grammarAccess.getIncSysAccess().getSKW_MINUSTerminalRuleCall_0()); 
    }
    this_KW_INCSYS_1=RULE_KW_INCSYS    {
		$current.merge(this_KW_INCSYS_1);
    }

    { 
    newLeafNode(this_KW_INCSYS_1, grammarAccess.getIncSysAccess().getKW_INCSYSTerminalRuleCall_1()); 
    }
)
    ;





// Entry rule entryRuleNoStdInc
entryRuleNoStdInc returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getNoStdIncRule()); } 
	 iv_ruleNoStdInc=ruleNoStdInc 
	 { $current=$iv_ruleNoStdInc.current.getText(); }  
	 EOF 
;

// Rule NoStdInc
ruleNoStdInc returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
(    this_SKW_MINUS_0=RULE_SKW_MINUS    {
		$current.merge(this_SKW_MINUS_0);
    }

    { 
    newLeafNode(this_SKW_MINUS_0, grammarAccess.getNoStdIncAccess().getSKW_MINUSTerminalRuleCall_0()); 
    }
    this_KW_NOSTDINC_1=RULE_KW_NOSTDINC    {
		$current.merge(this_KW_NOSTDINC_1);
    }

    { 
    newLeafNode(this_KW_NOSTDINC_1, grammarAccess.getNoStdIncAccess().getKW_NOSTDINCTerminalRuleCall_1()); 
    }
)
    ;





// Entry rule entryRuleInclude
entryRuleInclude returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getIncludeRule()); } 
	 iv_ruleInclude=ruleInclude 
	 { $current=$iv_ruleInclude.current.getText(); }  
	 EOF 
;

// Rule Include
ruleInclude returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
(    this_SKW_MINUS_0=RULE_SKW_MINUS    {
		$current.merge(this_SKW_MINUS_0);
    }

    { 
    newLeafNode(this_SKW_MINUS_0, grammarAccess.getIncludeAccess().getSKW_MINUSTerminalRuleCall_0()); 
    }
    this_KW_INCLUDE_1=RULE_KW_INCLUDE    {
		$current.merge(this_KW_INCLUDE_1);
    }

    { 
    newLeafNode(this_KW_INCLUDE_1, grammarAccess.getIncludeAccess().getKW_INCLUDETerminalRuleCall_1()); 
    }
)
    ;





// Entry rule entryRuleOutput
entryRuleOutput returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getOutputRule()); } 
	 iv_ruleOutput=ruleOutput 
	 { $current=$iv_ruleOutput.current.getText(); }  
	 EOF 
;

// Rule Output
ruleOutput returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
    this_KW_OUTPUT_0=RULE_KW_OUTPUT    {
		$current.merge(this_KW_OUTPUT_0);
    }

    { 
    newLeafNode(this_KW_OUTPUT_0, grammarAccess.getOutputAccess().getKW_OUTPUTTerminalRuleCall()); 
    }

    ;





// Entry rule entryRuleLang
entryRuleLang returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getLangRule()); } 
	 iv_ruleLang=ruleLang 
	 { $current=$iv_ruleLang.current.getText(); }  
	 EOF 
;

// Rule Lang
ruleLang returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
    this_KW_LANG_0=RULE_KW_LANG    {
		$current.merge(this_KW_LANG_0);
    }

    { 
    newLeafNode(this_KW_LANG_0, grammarAccess.getLangAccess().getKW_LANGTerminalRuleCall()); 
    }

    ;





// Entry rule entryRuleMacro
entryRuleMacro returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getMacroRule()); }
	 iv_ruleMacro=ruleMacro 
	 { $current=$iv_ruleMacro.current; } 
	 EOF 
;

// Rule Macro
ruleMacro returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getMacroAccess().getSimpleMacroParserRuleCall_0()); 
    }
    this_SimpleMacro_0=ruleSimpleMacro
    {
        $current = $this_SimpleMacro_0.current;
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getMacroAccess().getObjectMacroParserRuleCall_1()); 
    }
    this_ObjectMacro_1=ruleObjectMacro
    {
        $current = $this_ObjectMacro_1.current;
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getMacroAccess().getFunctionMacroParserRuleCall_2()); 
    }
    this_FunctionMacro_2=ruleFunctionMacro
    {
        $current = $this_FunctionMacro_2.current;
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getMacroAccess().getStringMacroParserRuleCall_3()); 
    }
    this_StringMacro_3=ruleStringMacro
    {
        $current = $this_StringMacro_3.current;
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleSimpleMacro
entryRuleSimpleMacro returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getSimpleMacroRule()); }
	 iv_ruleSimpleMacro=ruleSimpleMacro 
	 { $current=$iv_ruleSimpleMacro.current; } 
	 EOF 
;

// Rule SimpleMacro
ruleSimpleMacro returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getSimpleMacroAccess().getSimpleMacroAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getSimpleMacroAccess().getNameIdentifierParserRuleCall_1_0()); 
	    }
		lv_name_1_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSimpleMacroRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleObjectMacro
entryRuleObjectMacro returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getObjectMacroRule()); }
	 iv_ruleObjectMacro=ruleObjectMacro 
	 { $current=$iv_ruleObjectMacro.current; } 
	 EOF 
;

// Rule ObjectMacro
ruleObjectMacro returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getObjectMacroAccess().getObjectMacroAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getObjectMacroAccess().getNameIdentifierParserRuleCall_1_0()); 
	    }
		lv_name_1_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getObjectMacroRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
	        afterParserOrEnumRuleCall();
	    }

)
)this_SKW_ASSIGN_2=RULE_SKW_ASSIGN
    { 
    newLeafNode(this_SKW_ASSIGN_2, grammarAccess.getObjectMacroAccess().getSKW_ASSIGNTerminalRuleCall_2()); 
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getObjectMacroAccess().getValueMyCodeParserRuleCall_3_0()); 
	    }
		lv_value_3_0=ruleMyCode		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getObjectMacroRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_3_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.MyCode");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleFunctionMacro
entryRuleFunctionMacro returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getFunctionMacroRule()); }
	 iv_ruleFunctionMacro=ruleFunctionMacro 
	 { $current=$iv_ruleFunctionMacro.current; } 
	 EOF 
;

// Rule FunctionMacro
ruleFunctionMacro returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getFunctionMacroAccess().getFunctionMacroAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getNameIdentifierParserRuleCall_1_0()); 
	    }
		lv_name_1_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFunctionMacroRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
	        afterParserOrEnumRuleCall();
	    }

)
)this_SKW_LEFTPAREN_2=RULE_SKW_LEFTPAREN
    { 
    newLeafNode(this_SKW_LEFTPAREN_2, grammarAccess.getFunctionMacroAccess().getSKW_LEFTPARENTerminalRuleCall_2()); 
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getParamsIdentifierParserRuleCall_3_0_0()); 
	    }
		lv_params_3_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFunctionMacroRule());
	        }
       		add(
       			$current, 
       			"params",
        		lv_params_3_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
	        afterParserOrEnumRuleCall();
	    }

)
)(this_SKW_COMMA_4=RULE_SKW_COMMA
    { 
    newLeafNode(this_SKW_COMMA_4, grammarAccess.getFunctionMacroAccess().getSKW_COMMATerminalRuleCall_3_1_0()); 
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getParamsIdentifierParserRuleCall_3_1_1_0()); 
	    }
		lv_params_5_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFunctionMacroRule());
	        }
       		add(
       			$current, 
       			"params",
        		lv_params_5_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?this_SKW_RIGHTPAREN_6=RULE_SKW_RIGHTPAREN
    { 
    newLeafNode(this_SKW_RIGHTPAREN_6, grammarAccess.getFunctionMacroAccess().getSKW_RIGHTPARENTerminalRuleCall_4()); 
    }
this_SKW_ASSIGN_7=RULE_SKW_ASSIGN
    { 
    newLeafNode(this_SKW_ASSIGN_7, grammarAccess.getFunctionMacroAccess().getSKW_ASSIGNTerminalRuleCall_5()); 
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getValueMyCodeParserRuleCall_6_0()); 
	    }
		lv_value_8_0=ruleMyCode		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFunctionMacroRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_8_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.MyCode");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleStringMacro
entryRuleStringMacro returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getStringMacroRule()); }
	 iv_ruleStringMacro=ruleStringMacro 
	 { $current=$iv_ruleStringMacro.current; } 
	 EOF 
;

// Rule StringMacro
ruleStringMacro returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getStringMacroAccess().getStringMacroAction_0(),
            $current);
    }
)(
(
		lv_string_1_0=RULE_STRING
		{
			newLeafNode(lv_string_1_0, grammarAccess.getStringMacroAccess().getStringSTRINGTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getStringMacroRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"string",
        		lv_string_1_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.STRING");
	    }

)
))
;





// Entry rule entryRulePathCmd
entryRulePathCmd returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getPathCmdRule()); }
	 iv_rulePathCmd=rulePathCmd 
	 { $current=$iv_rulePathCmd.current; } 
	 EOF 
;

// Rule PathCmd
rulePathCmd returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getPathCmdAccess().getPathPathParserRuleCall_0()); 
	    }
		lv_path_0_0=rulePath		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPathCmdRule());
	        }
       		set(
       			$current, 
       			"path",
        		lv_path_0_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.Path");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleIdentifier
entryRuleIdentifier returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getIdentifierRule()); } 
	 iv_ruleIdentifier=ruleIdentifier 
	 { $current=$iv_ruleIdentifier.current.getText(); }  
	 EOF 
;

// Rule Identifier
ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall()); 
    }

    ;





// Entry rule entryRuleMyCode
entryRuleMyCode returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getMyCodeRule()); } 
	 iv_ruleMyCode=ruleMyCode 
	 { $current=$iv_ruleMyCode.current.getText(); }  
	 EOF 
;

// Rule MyCode
ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
(
    { 
        newCompositeNode(grammarAccess.getMyCodeAccess().getMyCodeCharParserRuleCall()); 
    }
    this_MyCodeChar_0=ruleMyCodeChar    {
		$current.merge(this_MyCodeChar_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }
)+
    ;





// Entry rule entryRuleMyCodeChar
entryRuleMyCodeChar returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getMyCodeCharRule()); } 
	 iv_ruleMyCodeChar=ruleMyCodeChar 
	 { $current=$iv_ruleMyCodeChar.current.getText(); }  
	 EOF 
;

// Rule MyCodeChar
ruleMyCodeChar returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
(
    { 
        newCompositeNode(grammarAccess.getMyCodeCharAccess().getPathCharParserRuleCall_0()); 
    }
    this_PathChar_0=rulePathChar    {
		$current.merge(this_PathChar_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    |    this_SKW_LEFTPAREN_1=RULE_SKW_LEFTPAREN    {
		$current.merge(this_SKW_LEFTPAREN_1);
    }

    { 
    newLeafNode(this_SKW_LEFTPAREN_1, grammarAccess.getMyCodeCharAccess().getSKW_LEFTPARENTerminalRuleCall_1()); 
    }

    |    this_SKW_RIGHTPAREN_2=RULE_SKW_RIGHTPAREN    {
		$current.merge(this_SKW_RIGHTPAREN_2);
    }

    { 
    newLeafNode(this_SKW_RIGHTPAREN_2, grammarAccess.getMyCodeCharAccess().getSKW_RIGHTPARENTerminalRuleCall_2()); 
    }
)
    ;





// Entry rule entryRulePath
entryRulePath returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getPathRule()); } 
	 iv_rulePath=rulePath 
	 { $current=$iv_rulePath.current.getText(); }  
	 EOF 
;

// Rule Path
rulePath returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
(
    { 
        newCompositeNode(grammarAccess.getPathAccess().getPathCharParserRuleCall()); 
    }
    this_PathChar_0=rulePathChar    {
		$current.merge(this_PathChar_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }
)+
    ;





// Entry rule entryRulePathChar
entryRulePathChar returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getPathCharRule()); } 
	 iv_rulePathChar=rulePathChar 
	 { $current=$iv_rulePathChar.current.getText(); }  
	 EOF 
;

// Rule PathChar
rulePathChar returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
(
    { 
        newCompositeNode(grammarAccess.getPathCharAccess().getOptionCharParserRuleCall_0()); 
    }
    this_OptionChar_0=ruleOptionChar    {
		$current.merge(this_OptionChar_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getPathCharAccess().getNonOptionCharParserRuleCall_1()); 
    }
    this_NonOptionChar_1=ruleNonOptionChar    {
		$current.merge(this_NonOptionChar_1);
    }

    { 
        afterParserOrEnumRuleCall();
    }
)
    ;





// Entry rule entryRuleOption
entryRuleOption returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getOptionRule()); } 
	 iv_ruleOption=ruleOption 
	 { $current=$iv_ruleOption.current.getText(); }  
	 EOF 
;

// Rule Option
ruleOption returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
(
    { 
        newCompositeNode(grammarAccess.getOptionAccess().getNonOptionCharParserRuleCall_0()); 
    }
    this_NonOptionChar_0=ruleNonOptionChar    {
		$current.merge(this_NonOptionChar_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }
(
    { 
        newCompositeNode(grammarAccess.getOptionAccess().getOptionCharParserRuleCall_1_0()); 
    }
    this_OptionChar_1=ruleOptionChar    {
		$current.merge(this_OptionChar_1);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getOptionAccess().getNonOptionCharParserRuleCall_1_1()); 
    }
    this_NonOptionChar_2=ruleNonOptionChar    {
		$current.merge(this_NonOptionChar_2);
    }

    { 
        afterParserOrEnumRuleCall();
    }
)*)
    ;





// Entry rule entryRuleNonOptionChar
entryRuleNonOptionChar returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getNonOptionCharRule()); } 
	 iv_ruleNonOptionChar=ruleNonOptionChar 
	 { $current=$iv_ruleNonOptionChar.current.getText(); }  
	 EOF 
;

// Rule NonOptionChar
ruleNonOptionChar returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getNonOptionCharAccess().getIDTerminalRuleCall_0()); 
    }

    |    this_STRING_1=RULE_STRING    {
		$current.merge(this_STRING_1);
    }

    { 
    newLeafNode(this_STRING_1, grammarAccess.getNonOptionCharAccess().getSTRINGTerminalRuleCall_1()); 
    }

    |    this_SKW_ASSIGN_2=RULE_SKW_ASSIGN    {
		$current.merge(this_SKW_ASSIGN_2);
    }

    { 
    newLeafNode(this_SKW_ASSIGN_2, grammarAccess.getNonOptionCharAccess().getSKW_ASSIGNTerminalRuleCall_2()); 
    }

    |    this_SKW_COMMA_3=RULE_SKW_COMMA    {
		$current.merge(this_SKW_COMMA_3);
    }

    { 
    newLeafNode(this_SKW_COMMA_3, grammarAccess.getNonOptionCharAccess().getSKW_COMMATerminalRuleCall_3()); 
    }

    |    this_ANY_OTHER_4=RULE_ANY_OTHER    {
		$current.merge(this_ANY_OTHER_4);
    }

    { 
    newLeafNode(this_ANY_OTHER_4, grammarAccess.getNonOptionCharAccess().getANY_OTHERTerminalRuleCall_4()); 
    }
)
    ;





// Entry rule entryRuleOptionChar
entryRuleOptionChar returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getOptionCharRule()); } 
	 iv_ruleOptionChar=ruleOptionChar 
	 { $current=$iv_ruleOptionChar.current.getText(); }  
	 EOF 
;

// Rule OptionChar
ruleOptionChar returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
(    this_SKW_MINUS_0=RULE_SKW_MINUS    {
		$current.merge(this_SKW_MINUS_0);
    }

    { 
    newLeafNode(this_SKW_MINUS_0, grammarAccess.getOptionCharAccess().getSKW_MINUSTerminalRuleCall_0()); 
    }

    |    this_KW_DEFINE_1=RULE_KW_DEFINE    {
		$current.merge(this_KW_DEFINE_1);
    }

    { 
    newLeafNode(this_KW_DEFINE_1, grammarAccess.getOptionCharAccess().getKW_DEFINETerminalRuleCall_1()); 
    }

    |    this_KW_INCDIR_2=RULE_KW_INCDIR    {
		$current.merge(this_KW_INCDIR_2);
    }

    { 
    newLeafNode(this_KW_INCDIR_2, grammarAccess.getOptionCharAccess().getKW_INCDIRTerminalRuleCall_2()); 
    }

    |    this_KW_NOSTDINC_3=RULE_KW_NOSTDINC    {
		$current.merge(this_KW_NOSTDINC_3);
    }

    { 
    newLeafNode(this_KW_NOSTDINC_3, grammarAccess.getOptionCharAccess().getKW_NOSTDINCTerminalRuleCall_3()); 
    }

    |    this_KW_INCSYS_4=RULE_KW_INCSYS    {
		$current.merge(this_KW_INCSYS_4);
    }

    { 
    newLeafNode(this_KW_INCSYS_4, grammarAccess.getOptionCharAccess().getKW_INCSYSTerminalRuleCall_4()); 
    }

    |    this_KW_INCLUDE_5=RULE_KW_INCLUDE    {
		$current.merge(this_KW_INCLUDE_5);
    }

    { 
    newLeafNode(this_KW_INCLUDE_5, grammarAccess.getOptionCharAccess().getKW_INCLUDETerminalRuleCall_5()); 
    }

    |    this_KW_LANG_6=RULE_KW_LANG    {
		$current.merge(this_KW_LANG_6);
    }

    { 
    newLeafNode(this_KW_LANG_6, grammarAccess.getOptionCharAccess().getKW_LANGTerminalRuleCall_6()); 
    }

    |    this_KW_OUTPUT_7=RULE_KW_OUTPUT    {
		$current.merge(this_KW_OUTPUT_7);
    }

    { 
    newLeafNode(this_KW_OUTPUT_7, grammarAccess.getOptionCharAccess().getKW_OUTPUTTerminalRuleCall_7()); 
    }
)
    ;





