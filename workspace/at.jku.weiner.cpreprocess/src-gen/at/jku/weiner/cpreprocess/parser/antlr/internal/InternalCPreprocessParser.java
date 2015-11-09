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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_HASH", "RULE_NEWLINE", "RULE_MYCODE", "RULE_BACKSLASH", "RULE_WHITESPACE", "'include'"
    };
    public static final int RULE_NEWLINE=5;
    public static final int RULE_BACKSLASH=7;
    public static final int RULE_HASH=4;
    public static final int RULE_WHITESPACE=8;
    public static final int RULE_MYCODE=6;
    public static final int EOF=-1;
    public static final int T__9=9;

    // delegates
    // delegators


        public InternalCPreprocessParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCPreprocessParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCPreprocessParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCPreprocess.g"; }



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
    // InternalCPreprocess.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalCPreprocess.g:69:2: (iv_ruleModel= ruleModel EOF )
            // InternalCPreprocess.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalCPreprocess.g:77:1: ruleModel returns [EObject current=null] : ( () ( (lv_units_1_0= ruleTranslationUnit ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_units_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:83:7: ( ( () ( (lv_units_1_0= ruleTranslationUnit ) ) ) )
            // InternalCPreprocess.g:85:1: ( () ( (lv_units_1_0= ruleTranslationUnit ) ) )
            {
            // InternalCPreprocess.g:85:1: ( () ( (lv_units_1_0= ruleTranslationUnit ) ) )
            // InternalCPreprocess.g:86:1: () ( (lv_units_1_0= ruleTranslationUnit ) )
            {
            // InternalCPreprocess.g:86:1: ()
            // InternalCPreprocess.g:87:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

            // InternalCPreprocess.g:95:1: ( (lv_units_1_0= ruleTranslationUnit ) )
            // InternalCPreprocess.g:96:1: (lv_units_1_0= ruleTranslationUnit )
            {
            // InternalCPreprocess.g:96:1: (lv_units_1_0= ruleTranslationUnit )
            // InternalCPreprocess.g:97:3: lv_units_1_0= ruleTranslationUnit
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
                		/*no after found*/
                 
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
    // InternalCPreprocess.g:125:1: entryRuleTranslationUnit returns [EObject current=null] : iv_ruleTranslationUnit= ruleTranslationUnit EOF ;
    public final EObject entryRuleTranslationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTranslationUnit = null;


        try {
            // InternalCPreprocess.g:126:2: (iv_ruleTranslationUnit= ruleTranslationUnit EOF )
            // InternalCPreprocess.g:127:2: iv_ruleTranslationUnit= ruleTranslationUnit EOF
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
    // InternalCPreprocess.g:134:1: ruleTranslationUnit returns [EObject current=null] : ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* ) ;
    public final EObject ruleTranslationUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_lines_1_0 = null;

        EObject lv_lines_2_0 = null;

        EObject lv_lines_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:140:7: ( ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* ) )
            // InternalCPreprocess.g:142:1: ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* )
            {
            // InternalCPreprocess.g:142:1: ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* )
            // InternalCPreprocess.g:143:1: () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )*
            {
            // InternalCPreprocess.g:143:1: ()
            // InternalCPreprocess.g:144:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTranslationUnitAccess().getTranslationUnitAction_0(),
                        current);
                

            }

            // InternalCPreprocess.g:152:1: ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )*
            loop1:
            do {
                int alt1=4;
                switch ( input.LA(1) ) {
                case RULE_HASH:
                    {
                    alt1=1;
                    }
                    break;
                case RULE_NEWLINE:
                    {
                    alt1=2;
                    }
                    break;
                case RULE_MYCODE:
                    {
                    alt1=3;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // InternalCPreprocess.g:153:1: ( (lv_lines_1_0= rulePreprocessorDirectives ) )
            	    {
            	    // InternalCPreprocess.g:153:1: ( (lv_lines_1_0= rulePreprocessorDirectives ) )
            	    // InternalCPreprocess.g:154:1: (lv_lines_1_0= rulePreprocessorDirectives )
            	    {
            	    // InternalCPreprocess.g:154:1: (lv_lines_1_0= rulePreprocessorDirectives )
            	    // InternalCPreprocess.g:155:3: lv_lines_1_0= rulePreprocessorDirectives
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTranslationUnitAccess().getLinesPreprocessorDirectivesParserRuleCall_1_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_lines_1_0=rulePreprocessorDirectives();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTranslationUnitRule());
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
            	    // InternalCPreprocess.g:175:1: ( (lv_lines_2_0= ruleNewLineLine ) )
            	    {
            	    // InternalCPreprocess.g:175:1: ( (lv_lines_2_0= ruleNewLineLine ) )
            	    // InternalCPreprocess.g:176:1: (lv_lines_2_0= ruleNewLineLine )
            	    {
            	    // InternalCPreprocess.g:176:1: (lv_lines_2_0= ruleNewLineLine )
            	    // InternalCPreprocess.g:177:3: lv_lines_2_0= ruleNewLineLine
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTranslationUnitAccess().getLinesNewLineLineParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_lines_2_0=ruleNewLineLine();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTranslationUnitRule());
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
            	    // InternalCPreprocess.g:197:1: ( (lv_lines_3_0= ruleCode ) )
            	    {
            	    // InternalCPreprocess.g:197:1: ( (lv_lines_3_0= ruleCode ) )
            	    // InternalCPreprocess.g:198:1: (lv_lines_3_0= ruleCode )
            	    {
            	    // InternalCPreprocess.g:198:1: (lv_lines_3_0= ruleCode )
            	    // InternalCPreprocess.g:199:3: lv_lines_3_0= ruleCode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTranslationUnitAccess().getLinesCodeParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_lines_3_0=ruleCode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTranslationUnitRule());
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
                		/*no after found*/
                 
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


    // $ANTLR start "entryRulePreprocessorDirectives"
    // InternalCPreprocess.g:229:1: entryRulePreprocessorDirectives returns [EObject current=null] : iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF ;
    public final EObject entryRulePreprocessorDirectives() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreprocessorDirectives = null;


        try {
            // InternalCPreprocess.g:230:2: (iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF )
            // InternalCPreprocess.g:231:2: iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF
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
    // InternalCPreprocess.g:238:1: rulePreprocessorDirectives returns [EObject current=null] : ( () this_HASH_1= RULE_HASH ( (lv_directive_2_0= ruleIncludeDirective ) ) this_NEWLINE_3= RULE_NEWLINE ) ;
    public final EObject rulePreprocessorDirectives() throws RecognitionException {
        EObject current = null;

        Token this_HASH_1=null;
        Token this_NEWLINE_3=null;
        EObject lv_directive_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:244:7: ( ( () this_HASH_1= RULE_HASH ( (lv_directive_2_0= ruleIncludeDirective ) ) this_NEWLINE_3= RULE_NEWLINE ) )
            // InternalCPreprocess.g:246:1: ( () this_HASH_1= RULE_HASH ( (lv_directive_2_0= ruleIncludeDirective ) ) this_NEWLINE_3= RULE_NEWLINE )
            {
            // InternalCPreprocess.g:246:1: ( () this_HASH_1= RULE_HASH ( (lv_directive_2_0= ruleIncludeDirective ) ) this_NEWLINE_3= RULE_NEWLINE )
            // InternalCPreprocess.g:247:1: () this_HASH_1= RULE_HASH ( (lv_directive_2_0= ruleIncludeDirective ) ) this_NEWLINE_3= RULE_NEWLINE
            {
            // InternalCPreprocess.g:247:1: ()
            // InternalCPreprocess.g:248:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPreprocessorDirectivesAccess().getPreprocessorDirectivesAction_0(),
                        current);
                

            }

            this_HASH_1=(Token)match(input,RULE_HASH,FOLLOW_4); 
             
                newLeafNode(this_HASH_1, grammarAccess.getPreprocessorDirectivesAccess().getHASHTerminalRuleCall_1()); 
                
            // InternalCPreprocess.g:263:1: ( (lv_directive_2_0= ruleIncludeDirective ) )
            // InternalCPreprocess.g:264:1: (lv_directive_2_0= ruleIncludeDirective )
            {
            // InternalCPreprocess.g:264:1: (lv_directive_2_0= ruleIncludeDirective )
            // InternalCPreprocess.g:265:3: lv_directive_2_0= ruleIncludeDirective
            {
             
            	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveIncludeDirectiveParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_5);
            lv_directive_2_0=ruleIncludeDirective();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
            	        }
                   		set(
                   			current, 
                   			"directive",
                    		lv_directive_2_0, 
                    		"at.jku.weiner.cpreprocess.CPreprocess.IncludeDirective");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_NEWLINE_3=(Token)match(input,RULE_NEWLINE,FOLLOW_2); 
             
                newLeafNode(this_NEWLINE_3, grammarAccess.getPreprocessorDirectivesAccess().getNEWLINETerminalRuleCall_3()); 
                

            }


            }

             leaveRule();
                		/*no after found*/
                 
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
    // InternalCPreprocess.g:300:1: entryRuleIncludeDirective returns [EObject current=null] : iv_ruleIncludeDirective= ruleIncludeDirective EOF ;
    public final EObject entryRuleIncludeDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDirective = null;


        try {
            // InternalCPreprocess.g:301:2: (iv_ruleIncludeDirective= ruleIncludeDirective EOF )
            // InternalCPreprocess.g:302:2: iv_ruleIncludeDirective= ruleIncludeDirective EOF
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
    // InternalCPreprocess.g:309:1: ruleIncludeDirective returns [EObject current=null] : ( () otherlv_1= 'include' ( (lv_string_2_0= RULE_NEWLINE ) ) ) ;
    public final EObject ruleIncludeDirective() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_string_2_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:315:7: ( ( () otherlv_1= 'include' ( (lv_string_2_0= RULE_NEWLINE ) ) ) )
            // InternalCPreprocess.g:317:1: ( () otherlv_1= 'include' ( (lv_string_2_0= RULE_NEWLINE ) ) )
            {
            // InternalCPreprocess.g:317:1: ( () otherlv_1= 'include' ( (lv_string_2_0= RULE_NEWLINE ) ) )
            // InternalCPreprocess.g:318:1: () otherlv_1= 'include' ( (lv_string_2_0= RULE_NEWLINE ) )
            {
            // InternalCPreprocess.g:318:1: ()
            // InternalCPreprocess.g:319:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIncludeDirectiveAccess().getIncludeDirectiveAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,9,FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getIncludeDirectiveAccess().getIncludeKeyword_1());
                
            // InternalCPreprocess.g:334:1: ( (lv_string_2_0= RULE_NEWLINE ) )
            // InternalCPreprocess.g:335:1: (lv_string_2_0= RULE_NEWLINE )
            {
            // InternalCPreprocess.g:335:1: (lv_string_2_0= RULE_NEWLINE )
            // InternalCPreprocess.g:336:3: lv_string_2_0= RULE_NEWLINE
            {
            lv_string_2_0=(Token)match(input,RULE_NEWLINE,FOLLOW_2); 

            			newLeafNode(lv_string_2_0, grammarAccess.getIncludeDirectiveAccess().getStringNEWLINETerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIncludeDirectiveRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"string",
                    		lv_string_2_0, 
                    		"at.jku.weiner.cpreprocess.CPreprocess.NEWLINE");
            	    

            }


            }


            }


            }

             leaveRule();
                		/*no after found*/
                 
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


    // $ANTLR start "entryRuleNewLineLine"
    // InternalCPreprocess.g:364:1: entryRuleNewLineLine returns [EObject current=null] : iv_ruleNewLineLine= ruleNewLineLine EOF ;
    public final EObject entryRuleNewLineLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewLineLine = null;


        try {
            // InternalCPreprocess.g:365:2: (iv_ruleNewLineLine= ruleNewLineLine EOF )
            // InternalCPreprocess.g:366:2: iv_ruleNewLineLine= ruleNewLineLine EOF
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
    // InternalCPreprocess.g:373:1: ruleNewLineLine returns [EObject current=null] : ( () this_NEWLINE_1= RULE_NEWLINE ) ;
    public final EObject ruleNewLineLine() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_1=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:379:7: ( ( () this_NEWLINE_1= RULE_NEWLINE ) )
            // InternalCPreprocess.g:381:1: ( () this_NEWLINE_1= RULE_NEWLINE )
            {
            // InternalCPreprocess.g:381:1: ( () this_NEWLINE_1= RULE_NEWLINE )
            // InternalCPreprocess.g:382:1: () this_NEWLINE_1= RULE_NEWLINE
            {
            // InternalCPreprocess.g:382:1: ()
            // InternalCPreprocess.g:383:5: 
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
                		/*no after found*/
                 
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
    // InternalCPreprocess.g:407:1: entryRuleCode returns [EObject current=null] : iv_ruleCode= ruleCode EOF ;
    public final EObject entryRuleCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCode = null;


        try {
            // InternalCPreprocess.g:408:2: (iv_ruleCode= ruleCode EOF )
            // InternalCPreprocess.g:409:2: iv_ruleCode= ruleCode EOF
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
    // InternalCPreprocess.g:416:1: ruleCode returns [EObject current=null] : ( () ( (lv_code_1_0= RULE_MYCODE ) ) this_NEWLINE_2= RULE_NEWLINE ) ;
    public final EObject ruleCode() throws RecognitionException {
        EObject current = null;

        Token lv_code_1_0=null;
        Token this_NEWLINE_2=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:422:7: ( ( () ( (lv_code_1_0= RULE_MYCODE ) ) this_NEWLINE_2= RULE_NEWLINE ) )
            // InternalCPreprocess.g:424:1: ( () ( (lv_code_1_0= RULE_MYCODE ) ) this_NEWLINE_2= RULE_NEWLINE )
            {
            // InternalCPreprocess.g:424:1: ( () ( (lv_code_1_0= RULE_MYCODE ) ) this_NEWLINE_2= RULE_NEWLINE )
            // InternalCPreprocess.g:425:1: () ( (lv_code_1_0= RULE_MYCODE ) ) this_NEWLINE_2= RULE_NEWLINE
            {
            // InternalCPreprocess.g:425:1: ()
            // InternalCPreprocess.g:426:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCodeAccess().getCodeAction_0(),
                        current);
                

            }

            // InternalCPreprocess.g:434:1: ( (lv_code_1_0= RULE_MYCODE ) )
            // InternalCPreprocess.g:435:1: (lv_code_1_0= RULE_MYCODE )
            {
            // InternalCPreprocess.g:435:1: (lv_code_1_0= RULE_MYCODE )
            // InternalCPreprocess.g:436:3: lv_code_1_0= RULE_MYCODE
            {
            lv_code_1_0=(Token)match(input,RULE_MYCODE,FOLLOW_5); 

            			newLeafNode(lv_code_1_0, grammarAccess.getCodeAccess().getCodeMYCODETerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCodeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"code",
                    		lv_code_1_0, 
                    		"at.jku.weiner.cpreprocess.CPreprocess.MYCODE");
            	    

            }


            }

            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_2); 
             
                newLeafNode(this_NEWLINE_2, grammarAccess.getCodeAccess().getNEWLINETerminalRuleCall_2()); 
                

            }


            }

             leaveRule();
                		/*no after found*/
                 
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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000072L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});

}