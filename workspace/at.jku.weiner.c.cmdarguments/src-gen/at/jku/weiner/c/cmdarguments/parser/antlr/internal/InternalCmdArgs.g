/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
grammar InternalCmdArgs;

options {
	superClass=AbstractInternalAntlrParser;
	
	
}

@lexer::header {
package at.jku.weiner.c.cmdarguments.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
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

@parser::members {

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
   		/*no init found*/
    }
    @after { leaveRule();
    		/*no after found*/
     }:

(
(
    {
        $current = forceCreateModelElement(
            grammarAccess.getModelAccess().getModelAction_0(),
            $current);
    }
)


(
(
		{ 
	        newCompositeNode(grammarAccess.getModelAccess().getArgumentsArgumentParserRuleCall_1_0()); 
	    }
		lv_arguments_1_0=ruleArgument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelRule());
	        }
       		add(
       			$current, 
       			"arguments",
        		lv_arguments_1_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.Argument");
	        afterParserOrEnumRuleCall();
	    }

)
)*

)


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
   		/*no init found*/
    }
    @after { leaveRule();
    		/*no after found*/
     }:

(
(
    {
        $current = forceCreateModelElement(
            grammarAccess.getArgumentAccess().getArgumentAction_0(),
            $current);
    }
)


(
(
	otherlv_1='-D' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getArgumentAccess().getDKeyword_1_0_0());
    }



(
(
		{ 
	        newCompositeNode(grammarAccess.getArgumentAccess().getNameIdentifierParserRuleCall_1_0_1_0()); 
	    }
		lv_name_2_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getArgumentRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
	        afterParserOrEnumRuleCall();
	    }

)
)

)


    |
(
	otherlv_3='-I' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getArgumentAccess().getIKeyword_1_1_0());
    }



(
(
		{ 
	        newCompositeNode(grammarAccess.getArgumentAccess().getDirIdentifierParserRuleCall_1_1_1_0()); 
	    }
		lv_dir_4_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getArgumentRule());
	        }
       		set(
       			$current, 
       			"dir",
        		lv_dir_4_0, 
        		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
	        afterParserOrEnumRuleCall();
	    }

)
)

)

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
    @after { leaveRule(); }:
    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall()); 
    }

    ;





RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


