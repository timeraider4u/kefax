package at.jku.weiner.cpreprocess.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import at.jku.weiner.cpreprocess.services.CPreprocessGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalCPreprocessParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_HASH", "RULE_INCLUDE", "RULE_DEFINE", "RULE_ERROR", "RULE_UNDEF", "RULE_PRAGMA", "RULE_LINEFEED", "RULE_CARRIAGERETURN", "RULE_NEWLINE", "RULE_BACKSLASH", "RULE_LINEBREAK", "RULE_SPACE", "RULE_TAB", "RULE_WS", "RULE_ID", "RULE_ID_NONDIGIT", "RULE_DIGIT", "RULE_NONDIGIT_LETTER", "RULE_UNIVERSAL_CHARACTER", "RULE_HEX_QUAD", "RULE_HEXADECIMAL_DIGIT", "RULE_SPECIAL"
    };
    public static final int RULE_PRAGMA=9;
    public static final int RULE_ID=18;
    public static final int RULE_NEWLINE=12;
    public static final int RULE_ID_NONDIGIT=19;
    public static final int RULE_NONDIGIT_LETTER=21;
    public static final int RULE_ERROR=7;
    public static final int RULE_HASH=4;
    public static final int RULE_TAB=16;
    public static final int RULE_UNDEF=8;
    public static final int EOF=-1;
    public static final int RULE_HEXADECIMAL_DIGIT=24;
    public static final int RULE_LINEBREAK=14;
    public static final int RULE_DEFINE=6;
    public static final int RULE_SPECIAL=25;
    public static final int RULE_CARRIAGERETURN=11;
    public static final int RULE_INCLUDE=5;
    public static final int RULE_BACKSLASH=13;
    public static final int RULE_WS=17;
    public static final int RULE_DIGIT=20;
    public static final int RULE_SPACE=15;
    public static final int RULE_UNIVERSAL_CHARACTER=22;
    public static final int RULE_LINEFEED=10;
    public static final int RULE_HEX_QUAD=23;

    // delegates
    // delegators


        public InternalCPreprocessParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCPreprocessParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCPreprocessParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCPreprocessParser.g"; }




    	private CPreprocessGrammarAccess grammarAccess;
    	 	
    	public InternalCPreprocessParser(TokenStream input, CPreprocessGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "Model";	
    	} 
    	   	   	
    	@Override
    	protected CPreprocessGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalCPreprocessParser.g:61:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalCPreprocessParser.g:62:2: (iv_ruleModel= ruleModel EOF )
            // InternalCPreprocessParser.g:63:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalCPreprocessParser.g:70:1: ruleModel returns [EObject current=null] : ( () ( (lv_units_1_0= ruleTranslationUnit ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_units_1_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:73:28: ( ( () ( (lv_units_1_0= ruleTranslationUnit ) ) ) )
            // InternalCPreprocessParser.g:74:1: ( () ( (lv_units_1_0= ruleTranslationUnit ) ) )
            {
            // InternalCPreprocessParser.g:74:1: ( () ( (lv_units_1_0= ruleTranslationUnit ) ) )
            // InternalCPreprocessParser.g:74:2: () ( (lv_units_1_0= ruleTranslationUnit ) )
            {
            // InternalCPreprocessParser.g:74:2: ()
            // InternalCPreprocessParser.g:75:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

            // InternalCPreprocessParser.g:80:2: ( (lv_units_1_0= ruleTranslationUnit ) )
            // InternalCPreprocessParser.g:81:1: (lv_units_1_0= ruleTranslationUnit )
            {
            // InternalCPreprocessParser.g:81:1: (lv_units_1_0= ruleTranslationUnit )
            // InternalCPreprocessParser.g:82:3: lv_units_1_0= ruleTranslationUnit
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getUnitsTranslationUnitParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_units_1_0=ruleTranslationUnit();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		add(
                   			current, 
                   			"units",
                    		lv_units_1_0, 
                    		"at.jku.weiner.cpreprocess.CPreprocess.TranslationUnit");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleTranslationUnit"
    // InternalCPreprocessParser.g:106:1: entryRuleTranslationUnit returns [EObject current=null] : iv_ruleTranslationUnit= ruleTranslationUnit EOF ;
    public final EObject entryRuleTranslationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTranslationUnit = null;


        try {
            // InternalCPreprocessParser.g:107:2: (iv_ruleTranslationUnit= ruleTranslationUnit EOF )
            // InternalCPreprocessParser.g:108:2: iv_ruleTranslationUnit= ruleTranslationUnit EOF
            {
             newCompositeNode(grammarAccess.getTranslationUnitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTranslationUnit=ruleTranslationUnit();

            state._fsp--;

             current =iv_ruleTranslationUnit; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTranslationUnit"


    // $ANTLR start "ruleTranslationUnit"
    // InternalCPreprocessParser.g:115:1: ruleTranslationUnit returns [EObject current=null] : ( () ( (lv_group_1_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleTranslationUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_group_1_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:118:28: ( ( () ( (lv_group_1_0= ruleGroupOpt ) ) ) )
            // InternalCPreprocessParser.g:119:1: ( () ( (lv_group_1_0= ruleGroupOpt ) ) )
            {
            // InternalCPreprocessParser.g:119:1: ( () ( (lv_group_1_0= ruleGroupOpt ) ) )
            // InternalCPreprocessParser.g:119:2: () ( (lv_group_1_0= ruleGroupOpt ) )
            {
            // InternalCPreprocessParser.g:119:2: ()
            // InternalCPreprocessParser.g:120:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTranslationUnitAccess().getTranslationUnitAction_0(),
                        current);
                

            }

            // InternalCPreprocessParser.g:125:2: ( (lv_group_1_0= ruleGroupOpt ) )
            // InternalCPreprocessParser.g:126:1: (lv_group_1_0= ruleGroupOpt )
            {
            // InternalCPreprocessParser.g:126:1: (lv_group_1_0= ruleGroupOpt )
            // InternalCPreprocessParser.g:127:3: lv_group_1_0= ruleGroupOpt
            {
             
            	        newCompositeNode(grammarAccess.getTranslationUnitAccess().getGroupGroupOptParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_group_1_0=ruleGroupOpt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTranslationUnitRule());
            	        }
                   		set(
                   			current, 
                   			"group",
                    		lv_group_1_0, 
                    		"at.jku.weiner.cpreprocess.CPreprocess.GroupOpt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTranslationUnit"


    // $ANTLR start "entryRuleGroupOpt"
    // InternalCPreprocessParser.g:151:1: entryRuleGroupOpt returns [EObject current=null] : iv_ruleGroupOpt= ruleGroupOpt EOF ;
    public final EObject entryRuleGroupOpt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOpt = null;


        try {
            // InternalCPreprocessParser.g:152:2: (iv_ruleGroupOpt= ruleGroupOpt EOF )
            // InternalCPreprocessParser.g:153:2: iv_ruleGroupOpt= ruleGroupOpt EOF
            {
             newCompositeNode(grammarAccess.getGroupOptRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGroupOpt=ruleGroupOpt();

            state._fsp--;

             current =iv_ruleGroupOpt; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGroupOpt"


    // $ANTLR start "ruleGroupOpt"
    // InternalCPreprocessParser.g:160:1: ruleGroupOpt returns [EObject current=null] : ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* ) ;
    public final EObject ruleGroupOpt() throws RecognitionException {
        EObject current = null;

        EObject lv_lines_1_0 = null;

        EObject lv_lines_2_0 = null;

        EObject lv_lines_3_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:163:28: ( ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* ) )
            // InternalCPreprocessParser.g:164:1: ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* )
            {
            // InternalCPreprocessParser.g:164:1: ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* )
            // InternalCPreprocessParser.g:164:2: () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )*
            {
            // InternalCPreprocessParser.g:164:2: ()
            // InternalCPreprocessParser.g:165:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getGroupOptAccess().getGroupOptAction_0(),
                        current);
                

            }

            // InternalCPreprocessParser.g:170:2: ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )*
            loop1:
            do {
                int alt1=4;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // InternalCPreprocessParser.g:170:3: ( (lv_lines_1_0= rulePreprocessorDirectives ) )
            	    {
            	    // InternalCPreprocessParser.g:170:3: ( (lv_lines_1_0= rulePreprocessorDirectives ) )
            	    // InternalCPreprocessParser.g:171:1: (lv_lines_1_0= rulePreprocessorDirectives )
            	    {
            	    // InternalCPreprocessParser.g:171:1: (lv_lines_1_0= rulePreprocessorDirectives )
            	    // InternalCPreprocessParser.g:172:3: lv_lines_1_0= rulePreprocessorDirectives
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGroupOptAccess().getLinesPreprocessorDirectivesParserRuleCall_1_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_lines_1_0=rulePreprocessorDirectives();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGroupOptRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"lines",
            	            		lv_lines_1_0, 
            	            		"at.jku.weiner.cpreprocess.CPreprocess.PreprocessorDirectives");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalCPreprocessParser.g:189:6: ( (lv_lines_2_0= ruleNewLineLine ) )
            	    {
            	    // InternalCPreprocessParser.g:189:6: ( (lv_lines_2_0= ruleNewLineLine ) )
            	    // InternalCPreprocessParser.g:190:1: (lv_lines_2_0= ruleNewLineLine )
            	    {
            	    // InternalCPreprocessParser.g:190:1: (lv_lines_2_0= ruleNewLineLine )
            	    // InternalCPreprocessParser.g:191:3: lv_lines_2_0= ruleNewLineLine
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGroupOptAccess().getLinesNewLineLineParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_lines_2_0=ruleNewLineLine();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGroupOptRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"lines",
            	            		lv_lines_2_0, 
            	            		"at.jku.weiner.cpreprocess.CPreprocess.NewLineLine");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalCPreprocessParser.g:208:6: ( (lv_lines_3_0= ruleCode ) )
            	    {
            	    // InternalCPreprocessParser.g:208:6: ( (lv_lines_3_0= ruleCode ) )
            	    // InternalCPreprocessParser.g:209:1: (lv_lines_3_0= ruleCode )
            	    {
            	    // InternalCPreprocessParser.g:209:1: (lv_lines_3_0= ruleCode )
            	    // InternalCPreprocessParser.g:210:3: lv_lines_3_0= ruleCode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGroupOptAccess().getLinesCodeParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_lines_3_0=ruleCode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGroupOptRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"lines",
            	            		lv_lines_3_0, 
            	            		"at.jku.weiner.cpreprocess.CPreprocess.Code");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGroupOpt"


    // $ANTLR start "entryRulePreprocessorDirectives"
    // InternalCPreprocessParser.g:234:1: entryRulePreprocessorDirectives returns [EObject current=null] : iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF ;
    public final EObject entryRulePreprocessorDirectives() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreprocessorDirectives = null;


        try {
            // InternalCPreprocessParser.g:235:2: (iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF )
            // InternalCPreprocessParser.g:236:2: iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF
            {
             newCompositeNode(grammarAccess.getPreprocessorDirectivesRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePreprocessorDirectives=rulePreprocessorDirectives();

            state._fsp--;

             current =iv_rulePreprocessorDirectives; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePreprocessorDirectives"


    // $ANTLR start "rulePreprocessorDirectives"
    // InternalCPreprocessParser.g:243:1: rulePreprocessorDirectives returns [EObject current=null] : ( () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= rulePragmaDirective ) ) ) this_NEWLINE_9= RULE_NEWLINE ) ;
    public final EObject rulePreprocessorDirectives() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token this_HASH_2=null;
        Token this_WS_3=null;
        Token this_NEWLINE_9=null;
        EObject lv_directive_4_0 = null;

        EObject lv_directive_5_0 = null;

        EObject lv_directive_6_0 = null;

        EObject lv_directive_7_0 = null;

        EObject lv_directive_8_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:246:28: ( ( () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= rulePragmaDirective ) ) ) this_NEWLINE_9= RULE_NEWLINE ) )
            // InternalCPreprocessParser.g:247:1: ( () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= rulePragmaDirective ) ) ) this_NEWLINE_9= RULE_NEWLINE )
            {
            // InternalCPreprocessParser.g:247:1: ( () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= rulePragmaDirective ) ) ) this_NEWLINE_9= RULE_NEWLINE )
            // InternalCPreprocessParser.g:247:2: () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= rulePragmaDirective ) ) ) this_NEWLINE_9= RULE_NEWLINE
            {
            // InternalCPreprocessParser.g:247:2: ()
            // InternalCPreprocessParser.g:248:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPreprocessorDirectivesAccess().getPreprocessorDirectivesAction_0(),
                        current);
                

            }

            // InternalCPreprocessParser.g:253:2: (this_WS_1= RULE_WS )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_WS) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCPreprocessParser.g:253:3: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_4); 
            	     
            	        newLeafNode(this_WS_1, grammarAccess.getPreprocessorDirectivesAccess().getWSTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_5); 
             
                newLeafNode(this_HASH_2, grammarAccess.getPreprocessorDirectivesAccess().getHASHTerminalRuleCall_2()); 
                
            // InternalCPreprocessParser.g:261:1: (this_WS_3= RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCPreprocessParser.g:261:2: this_WS_3= RULE_WS
            	    {
            	    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_5); 
            	     
            	        newLeafNode(this_WS_3, grammarAccess.getPreprocessorDirectivesAccess().getWSTerminalRuleCall_3()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalCPreprocessParser.g:265:3: ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= rulePragmaDirective ) ) )
            int alt4=5;
            switch ( input.LA(1) ) {
            case RULE_INCLUDE:
                {
                alt4=1;
                }
                break;
            case RULE_DEFINE:
                {
                alt4=2;
                }
                break;
            case RULE_ERROR:
                {
                alt4=3;
                }
                break;
            case RULE_UNDEF:
                {
                alt4=4;
                }
                break;
            case RULE_PRAGMA:
                {
                alt4=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalCPreprocessParser.g:265:4: ( (lv_directive_4_0= ruleIncludeDirective ) )
                    {
                    // InternalCPreprocessParser.g:265:4: ( (lv_directive_4_0= ruleIncludeDirective ) )
                    // InternalCPreprocessParser.g:266:1: (lv_directive_4_0= ruleIncludeDirective )
                    {
                    // InternalCPreprocessParser.g:266:1: (lv_directive_4_0= ruleIncludeDirective )
                    // InternalCPreprocessParser.g:267:3: lv_directive_4_0= ruleIncludeDirective
                    {
                     
                    	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveIncludeDirectiveParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_6);
                    lv_directive_4_0=ruleIncludeDirective();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
                    	        }
                           		set(
                           			current, 
                           			"directive",
                            		lv_directive_4_0, 
                            		"at.jku.weiner.cpreprocess.CPreprocess.IncludeDirective");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCPreprocessParser.g:284:6: ( (lv_directive_5_0= ruleDefineDirective ) )
                    {
                    // InternalCPreprocessParser.g:284:6: ( (lv_directive_5_0= ruleDefineDirective ) )
                    // InternalCPreprocessParser.g:285:1: (lv_directive_5_0= ruleDefineDirective )
                    {
                    // InternalCPreprocessParser.g:285:1: (lv_directive_5_0= ruleDefineDirective )
                    // InternalCPreprocessParser.g:286:3: lv_directive_5_0= ruleDefineDirective
                    {
                     
                    	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveDefineDirectiveParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_6);
                    lv_directive_5_0=ruleDefineDirective();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
                    	        }
                           		set(
                           			current, 
                           			"directive",
                            		lv_directive_5_0, 
                            		"at.jku.weiner.cpreprocess.CPreprocess.DefineDirective");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCPreprocessParser.g:303:6: ( (lv_directive_6_0= ruleErrorDirective ) )
                    {
                    // InternalCPreprocessParser.g:303:6: ( (lv_directive_6_0= ruleErrorDirective ) )
                    // InternalCPreprocessParser.g:304:1: (lv_directive_6_0= ruleErrorDirective )
                    {
                    // InternalCPreprocessParser.g:304:1: (lv_directive_6_0= ruleErrorDirective )
                    // InternalCPreprocessParser.g:305:3: lv_directive_6_0= ruleErrorDirective
                    {
                     
                    	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveErrorDirectiveParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FOLLOW_6);
                    lv_directive_6_0=ruleErrorDirective();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
                    	        }
                           		set(
                           			current, 
                           			"directive",
                            		lv_directive_6_0, 
                            		"at.jku.weiner.cpreprocess.CPreprocess.ErrorDirective");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalCPreprocessParser.g:322:6: ( (lv_directive_7_0= ruleUnDefineDirective ) )
                    {
                    // InternalCPreprocessParser.g:322:6: ( (lv_directive_7_0= ruleUnDefineDirective ) )
                    // InternalCPreprocessParser.g:323:1: (lv_directive_7_0= ruleUnDefineDirective )
                    {
                    // InternalCPreprocessParser.g:323:1: (lv_directive_7_0= ruleUnDefineDirective )
                    // InternalCPreprocessParser.g:324:3: lv_directive_7_0= ruleUnDefineDirective
                    {
                     
                    	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveUnDefineDirectiveParserRuleCall_4_3_0()); 
                    	    
                    pushFollow(FOLLOW_6);
                    lv_directive_7_0=ruleUnDefineDirective();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
                    	        }
                           		set(
                           			current, 
                           			"directive",
                            		lv_directive_7_0, 
                            		"at.jku.weiner.cpreprocess.CPreprocess.UnDefineDirective");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalCPreprocessParser.g:341:6: ( (lv_directive_8_0= rulePragmaDirective ) )
                    {
                    // InternalCPreprocessParser.g:341:6: ( (lv_directive_8_0= rulePragmaDirective ) )
                    // InternalCPreprocessParser.g:342:1: (lv_directive_8_0= rulePragmaDirective )
                    {
                    // InternalCPreprocessParser.g:342:1: (lv_directive_8_0= rulePragmaDirective )
                    // InternalCPreprocessParser.g:343:3: lv_directive_8_0= rulePragmaDirective
                    {
                     
                    	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectivePragmaDirectiveParserRuleCall_4_4_0()); 
                    	    
                    pushFollow(FOLLOW_6);
                    lv_directive_8_0=rulePragmaDirective();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
                    	        }
                           		set(
                           			current, 
                           			"directive",
                            		lv_directive_8_0, 
                            		"at.jku.weiner.cpreprocess.CPreprocess.PragmaDirective");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            this_NEWLINE_9=(Token)match(input,RULE_NEWLINE,FOLLOW_2); 
             
                newLeafNode(this_NEWLINE_9, grammarAccess.getPreprocessorDirectivesAccess().getNEWLINETerminalRuleCall_5()); 
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePreprocessorDirectives"


    // $ANTLR start "entryRuleIncludeDirective"
    // InternalCPreprocessParser.g:371:1: entryRuleIncludeDirective returns [EObject current=null] : iv_ruleIncludeDirective= ruleIncludeDirective EOF ;
    public final EObject entryRuleIncludeDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDirective = null;


        try {
            // InternalCPreprocessParser.g:372:2: (iv_ruleIncludeDirective= ruleIncludeDirective EOF )
            // InternalCPreprocessParser.g:373:2: iv_ruleIncludeDirective= ruleIncludeDirective EOF
            {
             newCompositeNode(grammarAccess.getIncludeDirectiveRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIncludeDirective=ruleIncludeDirective();

            state._fsp--;

             current =iv_ruleIncludeDirective; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIncludeDirective"


    // $ANTLR start "ruleIncludeDirective"
    // InternalCPreprocessParser.g:380:1: ruleIncludeDirective returns [EObject current=null] : ( () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleIncludeDirective() throws RecognitionException {
        EObject current = null;

        Token this_INCLUDE_1=null;
        Token this_WS_2=null;
        AntlrDatatypeRuleToken lv_string_3_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:383:28: ( ( () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) ) ) )
            // InternalCPreprocessParser.g:384:1: ( () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) ) )
            {
            // InternalCPreprocessParser.g:384:1: ( () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) ) )
            // InternalCPreprocessParser.g:384:2: () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) )
            {
            // InternalCPreprocessParser.g:384:2: ()
            // InternalCPreprocessParser.g:385:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIncludeDirectiveAccess().getIncludeDirectiveAction_0(),
                        current);
                

            }

            this_INCLUDE_1=(Token)match(input,RULE_INCLUDE,FOLLOW_7); 
             
                newLeafNode(this_INCLUDE_1, grammarAccess.getIncludeDirectiveAccess().getINCLUDETerminalRuleCall_1()); 
                
            // InternalCPreprocessParser.g:394:1: (this_WS_2= RULE_WS )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_WS) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalCPreprocessParser.g:394:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_8); 
            	     
            	        newLeafNode(this_WS_2, grammarAccess.getIncludeDirectiveAccess().getWSTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            // InternalCPreprocessParser.g:398:3: ( (lv_string_3_0= ruleMyCodeLine ) )
            // InternalCPreprocessParser.g:399:1: (lv_string_3_0= ruleMyCodeLine )
            {
            // InternalCPreprocessParser.g:399:1: (lv_string_3_0= ruleMyCodeLine )
            // InternalCPreprocessParser.g:400:3: lv_string_3_0= ruleMyCodeLine
            {
             
            	        newCompositeNode(grammarAccess.getIncludeDirectiveAccess().getStringMyCodeLineParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_string_3_0=ruleMyCodeLine();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIncludeDirectiveRule());
            	        }
                   		set(
                   			current, 
                   			"string",
                    		lv_string_3_0, 
                    		"at.jku.weiner.cpreprocess.CPreprocess.MyCodeLine");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIncludeDirective"


    // $ANTLR start "entryRuleDefineDirective"
    // InternalCPreprocessParser.g:424:1: entryRuleDefineDirective returns [EObject current=null] : iv_ruleDefineDirective= ruleDefineDirective EOF ;
    public final EObject entryRuleDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineDirective = null;


        try {
            // InternalCPreprocessParser.g:425:2: (iv_ruleDefineDirective= ruleDefineDirective EOF )
            // InternalCPreprocessParser.g:426:2: iv_ruleDefineDirective= ruleDefineDirective EOF
            {
             newCompositeNode(grammarAccess.getDefineDirectiveRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefineDirective=ruleDefineDirective();

            state._fsp--;

             current =iv_ruleDefineDirective; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefineDirective"


    // $ANTLR start "ruleDefineDirective"
    // InternalCPreprocessParser.g:433:1: ruleDefineDirective returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) (this_WS_4= RULE_WS )* ( (lv_string_5_0= ruleMyDefineLine ) ) ) ;
    public final EObject ruleDefineDirective() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_1=null;
        Token this_WS_2=null;
        Token lv_id_3_0=null;
        Token this_WS_4=null;
        AntlrDatatypeRuleToken lv_string_5_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:436:28: ( ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) (this_WS_4= RULE_WS )* ( (lv_string_5_0= ruleMyDefineLine ) ) ) )
            // InternalCPreprocessParser.g:437:1: ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) (this_WS_4= RULE_WS )* ( (lv_string_5_0= ruleMyDefineLine ) ) )
            {
            // InternalCPreprocessParser.g:437:1: ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) (this_WS_4= RULE_WS )* ( (lv_string_5_0= ruleMyDefineLine ) ) )
            // InternalCPreprocessParser.g:437:2: () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) (this_WS_4= RULE_WS )* ( (lv_string_5_0= ruleMyDefineLine ) )
            {
            // InternalCPreprocessParser.g:437:2: ()
            // InternalCPreprocessParser.g:438:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDefineDirectiveAccess().getDefineDirectiveAction_0(),
                        current);
                

            }

            this_DEFINE_1=(Token)match(input,RULE_DEFINE,FOLLOW_7); 
             
                newLeafNode(this_DEFINE_1, grammarAccess.getDefineDirectiveAccess().getDEFINETerminalRuleCall_1()); 
                
            // InternalCPreprocessParser.g:447:1: (this_WS_2= RULE_WS )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_WS) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalCPreprocessParser.g:447:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_9); 
            	     
            	        newLeafNode(this_WS_2, grammarAccess.getDefineDirectiveAccess().getWSTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // InternalCPreprocessParser.g:451:3: ( (lv_id_3_0= RULE_ID ) )
            // InternalCPreprocessParser.g:452:1: (lv_id_3_0= RULE_ID )
            {
            // InternalCPreprocessParser.g:452:1: (lv_id_3_0= RULE_ID )
            // InternalCPreprocessParser.g:453:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            			newLeafNode(lv_id_3_0, grammarAccess.getDefineDirectiveAccess().getIdIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDefineDirectiveRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_3_0, 
                    		"at.jku.weiner.cpreprocess.CPreprocess.ID");
            	    

            }


            }

            // InternalCPreprocessParser.g:469:2: (this_WS_4= RULE_WS )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_WS) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalCPreprocessParser.g:469:3: this_WS_4= RULE_WS
            	    {
            	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_8); 
            	     
            	        newLeafNode(this_WS_4, grammarAccess.getDefineDirectiveAccess().getWSTerminalRuleCall_4()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalCPreprocessParser.g:473:3: ( (lv_string_5_0= ruleMyDefineLine ) )
            // InternalCPreprocessParser.g:474:1: (lv_string_5_0= ruleMyDefineLine )
            {
            // InternalCPreprocessParser.g:474:1: (lv_string_5_0= ruleMyDefineLine )
            // InternalCPreprocessParser.g:475:3: lv_string_5_0= ruleMyDefineLine
            {
             
            	        newCompositeNode(grammarAccess.getDefineDirectiveAccess().getStringMyDefineLineParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_string_5_0=ruleMyDefineLine();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDefineDirectiveRule());
            	        }
                   		set(
                   			current, 
                   			"string",
                    		lv_string_5_0, 
                    		"at.jku.weiner.cpreprocess.CPreprocess.MyDefineLine");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefineDirective"


    // $ANTLR start "entryRuleErrorDirective"
    // InternalCPreprocessParser.g:499:1: entryRuleErrorDirective returns [EObject current=null] : iv_ruleErrorDirective= ruleErrorDirective EOF ;
    public final EObject entryRuleErrorDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorDirective = null;


        try {
            // InternalCPreprocessParser.g:500:2: (iv_ruleErrorDirective= ruleErrorDirective EOF )
            // InternalCPreprocessParser.g:501:2: iv_ruleErrorDirective= ruleErrorDirective EOF
            {
             newCompositeNode(grammarAccess.getErrorDirectiveRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleErrorDirective=ruleErrorDirective();

            state._fsp--;

             current =iv_ruleErrorDirective; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorDirective"


    // $ANTLR start "ruleErrorDirective"
    // InternalCPreprocessParser.g:508:1: ruleErrorDirective returns [EObject current=null] : ( () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleErrorDirective() throws RecognitionException {
        EObject current = null;

        Token this_ERROR_1=null;
        Token this_WS_2=null;
        AntlrDatatypeRuleToken lv_msg_3_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:511:28: ( ( () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) ) )
            // InternalCPreprocessParser.g:512:1: ( () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) )
            {
            // InternalCPreprocessParser.g:512:1: ( () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) )
            // InternalCPreprocessParser.g:512:2: () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) )
            {
            // InternalCPreprocessParser.g:512:2: ()
            // InternalCPreprocessParser.g:513:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getErrorDirectiveAccess().getErrorDirectiveAction_0(),
                        current);
                

            }

            this_ERROR_1=(Token)match(input,RULE_ERROR,FOLLOW_7); 
             
                newLeafNode(this_ERROR_1, grammarAccess.getErrorDirectiveAccess().getERRORTerminalRuleCall_1()); 
                
            // InternalCPreprocessParser.g:522:1: (this_WS_2= RULE_WS )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_WS) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalCPreprocessParser.g:522:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_8); 
            	     
            	        newLeafNode(this_WS_2, grammarAccess.getErrorDirectiveAccess().getWSTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            // InternalCPreprocessParser.g:526:3: ( (lv_msg_3_0= ruleMyCodeLine ) )
            // InternalCPreprocessParser.g:527:1: (lv_msg_3_0= ruleMyCodeLine )
            {
            // InternalCPreprocessParser.g:527:1: (lv_msg_3_0= ruleMyCodeLine )
            // InternalCPreprocessParser.g:528:3: lv_msg_3_0= ruleMyCodeLine
            {
             
            	        newCompositeNode(grammarAccess.getErrorDirectiveAccess().getMsgMyCodeLineParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_msg_3_0=ruleMyCodeLine();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getErrorDirectiveRule());
            	        }
                   		set(
                   			current, 
                   			"msg",
                    		lv_msg_3_0, 
                    		"at.jku.weiner.cpreprocess.CPreprocess.MyCodeLine");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleErrorDirective"


    // $ANTLR start "entryRuleUnDefineDirective"
    // InternalCPreprocessParser.g:552:1: entryRuleUnDefineDirective returns [EObject current=null] : iv_ruleUnDefineDirective= ruleUnDefineDirective EOF ;
    public final EObject entryRuleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnDefineDirective = null;


        try {
            // InternalCPreprocessParser.g:553:2: (iv_ruleUnDefineDirective= ruleUnDefineDirective EOF )
            // InternalCPreprocessParser.g:554:2: iv_ruleUnDefineDirective= ruleUnDefineDirective EOF
            {
             newCompositeNode(grammarAccess.getUnDefineDirectiveRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnDefineDirective=ruleUnDefineDirective();

            state._fsp--;

             current =iv_ruleUnDefineDirective; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnDefineDirective"


    // $ANTLR start "ruleUnDefineDirective"
    // InternalCPreprocessParser.g:561:1: ruleUnDefineDirective returns [EObject current=null] : ( () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ) ;
    public final EObject ruleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        Token this_UNDEF_1=null;
        Token this_WS_2=null;
        Token lv_id_3_0=null;

         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:564:28: ( ( () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ) )
            // InternalCPreprocessParser.g:565:1: ( () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) )
            {
            // InternalCPreprocessParser.g:565:1: ( () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) )
            // InternalCPreprocessParser.g:565:2: () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) )
            {
            // InternalCPreprocessParser.g:565:2: ()
            // InternalCPreprocessParser.g:566:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUnDefineDirectiveAccess().getUnDefineDirectiveAction_0(),
                        current);
                

            }

            this_UNDEF_1=(Token)match(input,RULE_UNDEF,FOLLOW_7); 
             
                newLeafNode(this_UNDEF_1, grammarAccess.getUnDefineDirectiveAccess().getUNDEFTerminalRuleCall_1()); 
                
            // InternalCPreprocessParser.g:575:1: (this_WS_2= RULE_WS )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_WS) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalCPreprocessParser.g:575:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_9); 
            	     
            	        newLeafNode(this_WS_2, grammarAccess.getUnDefineDirectiveAccess().getWSTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            // InternalCPreprocessParser.g:579:3: ( (lv_id_3_0= RULE_ID ) )
            // InternalCPreprocessParser.g:580:1: (lv_id_3_0= RULE_ID )
            {
            // InternalCPreprocessParser.g:580:1: (lv_id_3_0= RULE_ID )
            // InternalCPreprocessParser.g:581:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            			newLeafNode(lv_id_3_0, grammarAccess.getUnDefineDirectiveAccess().getIdIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUnDefineDirectiveRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_3_0, 
                    		"at.jku.weiner.cpreprocess.CPreprocess.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnDefineDirective"


    // $ANTLR start "entryRulePragmaDirective"
    // InternalCPreprocessParser.g:605:1: entryRulePragmaDirective returns [EObject current=null] : iv_rulePragmaDirective= rulePragmaDirective EOF ;
    public final EObject entryRulePragmaDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePragmaDirective = null;


        try {
            // InternalCPreprocessParser.g:606:2: (iv_rulePragmaDirective= rulePragmaDirective EOF )
            // InternalCPreprocessParser.g:607:2: iv_rulePragmaDirective= rulePragmaDirective EOF
            {
             newCompositeNode(grammarAccess.getPragmaDirectiveRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePragmaDirective=rulePragmaDirective();

            state._fsp--;

             current =iv_rulePragmaDirective; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePragmaDirective"


    // $ANTLR start "rulePragmaDirective"
    // InternalCPreprocessParser.g:614:1: rulePragmaDirective returns [EObject current=null] : ( () this_PRAGMA_1= RULE_PRAGMA ) ;
    public final EObject rulePragmaDirective() throws RecognitionException {
        EObject current = null;

        Token this_PRAGMA_1=null;

         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:617:28: ( ( () this_PRAGMA_1= RULE_PRAGMA ) )
            // InternalCPreprocessParser.g:618:1: ( () this_PRAGMA_1= RULE_PRAGMA )
            {
            // InternalCPreprocessParser.g:618:1: ( () this_PRAGMA_1= RULE_PRAGMA )
            // InternalCPreprocessParser.g:618:2: () this_PRAGMA_1= RULE_PRAGMA
            {
            // InternalCPreprocessParser.g:618:2: ()
            // InternalCPreprocessParser.g:619:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPragmaDirectiveAccess().getPragmaDirectiveAction_0(),
                        current);
                

            }

            this_PRAGMA_1=(Token)match(input,RULE_PRAGMA,FOLLOW_2); 
             
                newLeafNode(this_PRAGMA_1, grammarAccess.getPragmaDirectiveAccess().getPRAGMATerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePragmaDirective"


    // $ANTLR start "entryRuleNewLineLine"
    // InternalCPreprocessParser.g:636:1: entryRuleNewLineLine returns [EObject current=null] : iv_ruleNewLineLine= ruleNewLineLine EOF ;
    public final EObject entryRuleNewLineLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewLineLine = null;


        try {
            // InternalCPreprocessParser.g:637:2: (iv_ruleNewLineLine= ruleNewLineLine EOF )
            // InternalCPreprocessParser.g:638:2: iv_ruleNewLineLine= ruleNewLineLine EOF
            {
             newCompositeNode(grammarAccess.getNewLineLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNewLineLine=ruleNewLineLine();

            state._fsp--;

             current =iv_ruleNewLineLine; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNewLineLine"


    // $ANTLR start "ruleNewLineLine"
    // InternalCPreprocessParser.g:645:1: ruleNewLineLine returns [EObject current=null] : ( () this_NEWLINE_1= RULE_NEWLINE ) ;
    public final EObject ruleNewLineLine() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_1=null;

         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:648:28: ( ( () this_NEWLINE_1= RULE_NEWLINE ) )
            // InternalCPreprocessParser.g:649:1: ( () this_NEWLINE_1= RULE_NEWLINE )
            {
            // InternalCPreprocessParser.g:649:1: ( () this_NEWLINE_1= RULE_NEWLINE )
            // InternalCPreprocessParser.g:649:2: () this_NEWLINE_1= RULE_NEWLINE
            {
            // InternalCPreprocessParser.g:649:2: ()
            // InternalCPreprocessParser.g:650:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNewLineLineAccess().getNewLineLineAction_0(),
                        current);
                

            }

            this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_2); 
             
                newLeafNode(this_NEWLINE_1, grammarAccess.getNewLineLineAccess().getNEWLINETerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNewLineLine"


    // $ANTLR start "entryRuleCode"
    // InternalCPreprocessParser.g:667:1: entryRuleCode returns [EObject current=null] : iv_ruleCode= ruleCode EOF ;
    public final EObject entryRuleCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCode = null;


        try {
            // InternalCPreprocessParser.g:668:2: (iv_ruleCode= ruleCode EOF )
            // InternalCPreprocessParser.g:669:2: iv_ruleCode= ruleCode EOF
            {
             newCompositeNode(grammarAccess.getCodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCode=ruleCode();

            state._fsp--;

             current =iv_ruleCode; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCode"


    // $ANTLR start "ruleCode"
    // InternalCPreprocessParser.g:676:1: ruleCode returns [EObject current=null] : ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE ) ;
    public final EObject ruleCode() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_2=null;
        AntlrDatatypeRuleToken lv_code_1_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:679:28: ( ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE ) )
            // InternalCPreprocessParser.g:680:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE )
            {
            // InternalCPreprocessParser.g:680:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE )
            // InternalCPreprocessParser.g:680:2: () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE
            {
            // InternalCPreprocessParser.g:680:2: ()
            // InternalCPreprocessParser.g:681:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCodeAccess().getCodeAction_0(),
                        current);
                

            }

            // InternalCPreprocessParser.g:686:2: ( (lv_code_1_0= ruleMyCodeLineExtended ) )
            // InternalCPreprocessParser.g:687:1: (lv_code_1_0= ruleMyCodeLineExtended )
            {
            // InternalCPreprocessParser.g:687:1: (lv_code_1_0= ruleMyCodeLineExtended )
            // InternalCPreprocessParser.g:688:3: lv_code_1_0= ruleMyCodeLineExtended
            {
             
            	        newCompositeNode(grammarAccess.getCodeAccess().getCodeMyCodeLineExtendedParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_6);
            lv_code_1_0=ruleMyCodeLineExtended();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCodeRule());
            	        }
                   		set(
                   			current, 
                   			"code",
                    		lv_code_1_0, 
                    		"at.jku.weiner.cpreprocess.CPreprocess.MyCodeLineExtended");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_2); 
             
                newLeafNode(this_NEWLINE_2, grammarAccess.getCodeAccess().getNEWLINETerminalRuleCall_2()); 
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCode"


    // $ANTLR start "entryRuleMyCode"
    // InternalCPreprocessParser.g:716:1: entryRuleMyCode returns [String current=null] : iv_ruleMyCode= ruleMyCode EOF ;
    public final String entryRuleMyCode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCode = null;


        try {
            // InternalCPreprocessParser.g:717:1: (iv_ruleMyCode= ruleMyCode EOF )
            // InternalCPreprocessParser.g:718:2: iv_ruleMyCode= ruleMyCode EOF
            {
             newCompositeNode(grammarAccess.getMyCodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMyCode=ruleMyCode();

            state._fsp--;

             current =iv_ruleMyCode.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMyCode"


    // $ANTLR start "ruleMyCode"
    // InternalCPreprocessParser.g:725:1: ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA ) ;
    public final AntlrDatatypeRuleToken ruleMyCode() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_SPECIAL_1=null;
        Token this_INCLUDE_2=null;
        Token this_DEFINE_3=null;
        Token this_ERROR_4=null;
        Token this_PRAGMA_5=null;

         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:729:6: ( (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA ) )
            // InternalCPreprocessParser.g:730:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA )
            {
            // InternalCPreprocessParser.g:730:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA )
            int alt10=6;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt10=1;
                }
                break;
            case RULE_SPECIAL:
                {
                alt10=2;
                }
                break;
            case RULE_INCLUDE:
                {
                alt10=3;
                }
                break;
            case RULE_DEFINE:
                {
                alt10=4;
                }
                break;
            case RULE_ERROR:
                {
                alt10=5;
                }
                break;
            case RULE_PRAGMA:
                {
                alt10=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalCPreprocessParser.g:730:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getMyCodeAccess().getIDTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalCPreprocessParser.g:738:10: this_SPECIAL_1= RULE_SPECIAL
                    {
                    this_SPECIAL_1=(Token)match(input,RULE_SPECIAL,FOLLOW_2); 

                    		current.merge(this_SPECIAL_1);
                        
                     
                        newLeafNode(this_SPECIAL_1, grammarAccess.getMyCodeAccess().getSPECIALTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalCPreprocessParser.g:746:10: this_INCLUDE_2= RULE_INCLUDE
                    {
                    this_INCLUDE_2=(Token)match(input,RULE_INCLUDE,FOLLOW_2); 

                    		current.merge(this_INCLUDE_2);
                        
                     
                        newLeafNode(this_INCLUDE_2, grammarAccess.getMyCodeAccess().getINCLUDETerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalCPreprocessParser.g:754:10: this_DEFINE_3= RULE_DEFINE
                    {
                    this_DEFINE_3=(Token)match(input,RULE_DEFINE,FOLLOW_2); 

                    		current.merge(this_DEFINE_3);
                        
                     
                        newLeafNode(this_DEFINE_3, grammarAccess.getMyCodeAccess().getDEFINETerminalRuleCall_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalCPreprocessParser.g:762:10: this_ERROR_4= RULE_ERROR
                    {
                    this_ERROR_4=(Token)match(input,RULE_ERROR,FOLLOW_2); 

                    		current.merge(this_ERROR_4);
                        
                     
                        newLeafNode(this_ERROR_4, grammarAccess.getMyCodeAccess().getERRORTerminalRuleCall_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalCPreprocessParser.g:770:10: this_PRAGMA_5= RULE_PRAGMA
                    {
                    this_PRAGMA_5=(Token)match(input,RULE_PRAGMA,FOLLOW_2); 

                    		current.merge(this_PRAGMA_5);
                        
                     
                        newLeafNode(this_PRAGMA_5, grammarAccess.getMyCodeAccess().getPRAGMATerminalRuleCall_5()); 
                        

                    }
                    break;

            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMyCode"


    // $ANTLR start "entryRuleMyDefineLine"
    // InternalCPreprocessParser.g:785:1: entryRuleMyDefineLine returns [String current=null] : iv_ruleMyDefineLine= ruleMyDefineLine EOF ;
    public final String entryRuleMyDefineLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyDefineLine = null;


        try {
            // InternalCPreprocessParser.g:786:1: (iv_ruleMyDefineLine= ruleMyDefineLine EOF )
            // InternalCPreprocessParser.g:787:2: iv_ruleMyDefineLine= ruleMyDefineLine EOF
            {
             newCompositeNode(grammarAccess.getMyDefineLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMyDefineLine=ruleMyDefineLine();

            state._fsp--;

             current =iv_ruleMyDefineLine.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMyDefineLine"


    // $ANTLR start "ruleMyDefineLine"
    // InternalCPreprocessParser.g:794:1: ruleMyDefineLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )* ;
    public final AntlrDatatypeRuleToken ruleMyDefineLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_1=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:798:6: ( (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )* )
            // InternalCPreprocessParser.g:799:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )*
            {
            // InternalCPreprocessParser.g:799:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=RULE_INCLUDE && LA11_0<=RULE_ERROR)||LA11_0==RULE_PRAGMA||LA11_0==RULE_ID||LA11_0==RULE_SPECIAL) ) {
                    alt11=1;
                }
                else if ( (LA11_0==RULE_WS) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalCPreprocessParser.g:800:5: this_MyCode_0= ruleMyCode
            	    {
            	     
            	            newCompositeNode(grammarAccess.getMyDefineLineAccess().getMyCodeParserRuleCall_0()); 
            	        
            	    pushFollow(FOLLOW_10);
            	    this_MyCode_0=ruleMyCode();

            	    state._fsp--;


            	    		current.merge(this_MyCode_0);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;
            	case 2 :
            	    // InternalCPreprocessParser.g:811:10: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_10); 

            	    		current.merge(this_WS_1);
            	        
            	     
            	        newLeafNode(this_WS_1, grammarAccess.getMyDefineLineAccess().getWSTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMyDefineLine"


    // $ANTLR start "entryRuleMyCodeLine"
    // InternalCPreprocessParser.g:826:1: entryRuleMyCodeLine returns [String current=null] : iv_ruleMyCodeLine= ruleMyCodeLine EOF ;
    public final String entryRuleMyCodeLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLine = null;


        try {
            // InternalCPreprocessParser.g:827:1: (iv_ruleMyCodeLine= ruleMyCodeLine EOF )
            // InternalCPreprocessParser.g:828:2: iv_ruleMyCodeLine= ruleMyCodeLine EOF
            {
             newCompositeNode(grammarAccess.getMyCodeLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMyCodeLine=ruleMyCodeLine();

            state._fsp--;

             current =iv_ruleMyCodeLine.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMyCodeLine"


    // $ANTLR start "ruleMyCodeLine"
    // InternalCPreprocessParser.g:835:1: ruleMyCodeLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+ ;
    public final AntlrDatatypeRuleToken ruleMyCodeLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_1=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:839:6: ( (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+ )
            // InternalCPreprocessParser.g:840:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+
            {
            // InternalCPreprocessParser.g:840:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+
            int cnt12=0;
            loop12:
            do {
                int alt12=3;
                switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt12=1;
                    }
                    break;
                case RULE_SPECIAL:
                    {
                    alt12=1;
                    }
                    break;
                case RULE_INCLUDE:
                    {
                    alt12=1;
                    }
                    break;
                case RULE_DEFINE:
                    {
                    alt12=1;
                    }
                    break;
                case RULE_ERROR:
                    {
                    alt12=1;
                    }
                    break;
                case RULE_PRAGMA:
                    {
                    alt12=1;
                    }
                    break;
                case RULE_WS:
                    {
                    alt12=2;
                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // InternalCPreprocessParser.g:841:5: this_MyCode_0= ruleMyCode
            	    {
            	     
            	            newCompositeNode(grammarAccess.getMyCodeLineAccess().getMyCodeParserRuleCall_0()); 
            	        
            	    pushFollow(FOLLOW_10);
            	    this_MyCode_0=ruleMyCode();

            	    state._fsp--;


            	    		current.merge(this_MyCode_0);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;
            	case 2 :
            	    // InternalCPreprocessParser.g:852:10: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_10); 

            	    		current.merge(this_WS_1);
            	        
            	     
            	        newLeafNode(this_WS_1, grammarAccess.getMyCodeLineAccess().getWSTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMyCodeLine"


    // $ANTLR start "entryRuleMyCodeLineExtended"
    // InternalCPreprocessParser.g:867:1: entryRuleMyCodeLineExtended returns [String current=null] : iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF ;
    public final String entryRuleMyCodeLineExtended() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtended = null;


        try {
            // InternalCPreprocessParser.g:868:1: (iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF )
            // InternalCPreprocessParser.g:869:2: iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF
            {
             newCompositeNode(grammarAccess.getMyCodeLineExtendedRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMyCodeLineExtended=ruleMyCodeLineExtended();

            state._fsp--;

             current =iv_ruleMyCodeLineExtended.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMyCodeLineExtended"


    // $ANTLR start "ruleMyCodeLineExtended"
    // InternalCPreprocessParser.g:876:1: ruleMyCodeLineExtended returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? ) ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtended() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_0=null;
        Token this_HASH_3=null;
        AntlrDatatypeRuleToken this_MyCode_1 = null;

        AntlrDatatypeRuleToken this_MyCodeLine_2 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:880:6: ( ( (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? ) )
            // InternalCPreprocessParser.g:881:1: ( (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? )
            {
            // InternalCPreprocessParser.g:881:1: ( (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? )
            // InternalCPreprocessParser.g:881:2: (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )?
            {
            // InternalCPreprocessParser.g:881:2: (this_WS_0= RULE_WS )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_WS) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalCPreprocessParser.g:881:7: this_WS_0= RULE_WS
            	    {
            	    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_10); 

            	    		current.merge(this_WS_0);
            	        
            	     
            	        newLeafNode(this_WS_0, grammarAccess.getMyCodeLineExtendedAccess().getWSTerminalRuleCall_0()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // InternalCPreprocessParser.g:888:3: (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=RULE_INCLUDE && LA15_0<=RULE_ERROR)||LA15_0==RULE_PRAGMA||LA15_0==RULE_ID||LA15_0==RULE_SPECIAL) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalCPreprocessParser.g:889:5: this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
                    {
                     
                            newCompositeNode(grammarAccess.getMyCodeLineExtendedAccess().getMyCodeParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_11);
                    this_MyCode_1=ruleMyCode();

                    state._fsp--;


                    		current.merge(this_MyCode_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalCPreprocessParser.g:899:1: (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
                    loop14:
                    do {
                        int alt14=3;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>=RULE_INCLUDE && LA14_0<=RULE_ERROR)||LA14_0==RULE_PRAGMA||(LA14_0>=RULE_WS && LA14_0<=RULE_ID)||LA14_0==RULE_SPECIAL) ) {
                            alt14=1;
                        }
                        else if ( (LA14_0==RULE_HASH) ) {
                            alt14=2;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalCPreprocessParser.g:900:5: this_MyCodeLine_2= ruleMyCodeLine
                    	    {
                    	     
                    	            newCompositeNode(grammarAccess.getMyCodeLineExtendedAccess().getMyCodeLineParserRuleCall_1_1_0()); 
                    	        
                    	    pushFollow(FOLLOW_11);
                    	    this_MyCodeLine_2=ruleMyCodeLine();

                    	    state._fsp--;


                    	    		current.merge(this_MyCodeLine_2);
                    	        
                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalCPreprocessParser.g:911:10: this_HASH_3= RULE_HASH
                    	    {
                    	    this_HASH_3=(Token)match(input,RULE_HASH,FOLLOW_11); 

                    	    		current.merge(this_HASH_3);
                    	        
                    	     
                    	        newLeafNode(this_HASH_3, grammarAccess.getMyCodeLineExtendedAccess().getHASHTerminalRuleCall_1_1_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMyCodeLineExtended"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\6\uffff";
    static final String DFA1_eofS =
        "\1\1\5\uffff";
    static final String DFA1_minS =
        "\1\4\1\uffff\1\4\3\uffff";
    static final String DFA1_maxS =
        "\1\31\1\uffff\1\31\3\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\4\1\uffff\1\1\1\2\1\3";
    static final String DFA1_specialS =
        "\6\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\3\3\5\1\uffff\1\5\2\uffff\1\4\4\uffff\1\2\1\5\6\uffff\1\5",
            "",
            "\1\3\3\5\1\uffff\1\5\2\uffff\1\5\4\uffff\1\2\1\5\6\uffff\1\5",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "()* loopback of 170:2: ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000020612F2L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000203E0L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000020602E0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000020602E2L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000020602F2L});

}