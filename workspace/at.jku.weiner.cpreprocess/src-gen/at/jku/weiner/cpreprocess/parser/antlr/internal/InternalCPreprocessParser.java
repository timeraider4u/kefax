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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NEWLINE", "RULE_MYCODE", "RULE_HASH", "RULE_BACKSLASH", "RULE_WHITESPACE", "'include'"
    };
    public static final int RULE_NEWLINE=4;
    public static final int RULE_BACKSLASH=7;
    public static final int RULE_HASH=6;
    public static final int RULE_WHITESPACE=8;
    public static final int RULE_MYCODE=5;
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
    // InternalCPreprocess.g:134:1: ruleTranslationUnit returns [EObject current=null] : ( () ( ( (lv_lines_1_0= ruleNewLineLine ) ) | ( (lv_lines_2_0= ruleCode ) ) )* ) ;
    public final EObject ruleTranslationUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_lines_1_0 = null;

        EObject lv_lines_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:140:7: ( ( () ( ( (lv_lines_1_0= ruleNewLineLine ) ) | ( (lv_lines_2_0= ruleCode ) ) )* ) )
            // InternalCPreprocess.g:142:1: ( () ( ( (lv_lines_1_0= ruleNewLineLine ) ) | ( (lv_lines_2_0= ruleCode ) ) )* )
            {
            // InternalCPreprocess.g:142:1: ( () ( ( (lv_lines_1_0= ruleNewLineLine ) ) | ( (lv_lines_2_0= ruleCode ) ) )* )
            // InternalCPreprocess.g:143:1: () ( ( (lv_lines_1_0= ruleNewLineLine ) ) | ( (lv_lines_2_0= ruleCode ) ) )*
            {
            // InternalCPreprocess.g:143:1: ()
            // InternalCPreprocess.g:144:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTranslationUnitAccess().getTranslationUnitAction_0(),
                        current);
                

            }

            // InternalCPreprocess.g:152:1: ( ( (lv_lines_1_0= ruleNewLineLine ) ) | ( (lv_lines_2_0= ruleCode ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_NEWLINE) ) {
                    alt1=1;
                }
                else if ( (LA1_0==RULE_MYCODE) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCPreprocess.g:153:1: ( (lv_lines_1_0= ruleNewLineLine ) )
            	    {
            	    // InternalCPreprocess.g:153:1: ( (lv_lines_1_0= ruleNewLineLine ) )
            	    // InternalCPreprocess.g:154:1: (lv_lines_1_0= ruleNewLineLine )
            	    {
            	    // InternalCPreprocess.g:154:1: (lv_lines_1_0= ruleNewLineLine )
            	    // InternalCPreprocess.g:155:3: lv_lines_1_0= ruleNewLineLine
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTranslationUnitAccess().getLinesNewLineLineParserRuleCall_1_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_lines_1_0=ruleNewLineLine();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTranslationUnitRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"lines",
            	            		lv_lines_1_0, 
            	            		"at.jku.weiner.cpreprocess.CPreprocess.NewLineLine");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalCPreprocess.g:175:1: ( (lv_lines_2_0= ruleCode ) )
            	    {
            	    // InternalCPreprocess.g:175:1: ( (lv_lines_2_0= ruleCode ) )
            	    // InternalCPreprocess.g:176:1: (lv_lines_2_0= ruleCode )
            	    {
            	    // InternalCPreprocess.g:176:1: (lv_lines_2_0= ruleCode )
            	    // InternalCPreprocess.g:177:3: lv_lines_2_0= ruleCode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTranslationUnitAccess().getLinesCodeParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_lines_2_0=ruleCode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTranslationUnitRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"lines",
            	            		lv_lines_2_0, 
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


    // $ANTLR start "entryRuleIncludeDirective"
    // InternalCPreprocess.g:209:1: entryRuleIncludeDirective returns [EObject current=null] : iv_ruleIncludeDirective= ruleIncludeDirective EOF ;
    public final EObject entryRuleIncludeDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDirective = null;


        try {
            // InternalCPreprocess.g:210:2: (iv_ruleIncludeDirective= ruleIncludeDirective EOF )
            // InternalCPreprocess.g:211:2: iv_ruleIncludeDirective= ruleIncludeDirective EOF
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
    // InternalCPreprocess.g:218:1: ruleIncludeDirective returns [EObject current=null] : ( () otherlv_1= 'include' ( (lv_string_2_0= RULE_NEWLINE ) ) ) ;
    public final EObject ruleIncludeDirective() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_string_2_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:224:7: ( ( () otherlv_1= 'include' ( (lv_string_2_0= RULE_NEWLINE ) ) ) )
            // InternalCPreprocess.g:226:1: ( () otherlv_1= 'include' ( (lv_string_2_0= RULE_NEWLINE ) ) )
            {
            // InternalCPreprocess.g:226:1: ( () otherlv_1= 'include' ( (lv_string_2_0= RULE_NEWLINE ) ) )
            // InternalCPreprocess.g:227:1: () otherlv_1= 'include' ( (lv_string_2_0= RULE_NEWLINE ) )
            {
            // InternalCPreprocess.g:227:1: ()
            // InternalCPreprocess.g:228:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIncludeDirectiveAccess().getIncludeDirectiveAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,9,FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getIncludeDirectiveAccess().getIncludeKeyword_1());
                
            // InternalCPreprocess.g:243:1: ( (lv_string_2_0= RULE_NEWLINE ) )
            // InternalCPreprocess.g:244:1: (lv_string_2_0= RULE_NEWLINE )
            {
            // InternalCPreprocess.g:244:1: (lv_string_2_0= RULE_NEWLINE )
            // InternalCPreprocess.g:245:3: lv_string_2_0= RULE_NEWLINE
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
    // InternalCPreprocess.g:273:1: entryRuleNewLineLine returns [EObject current=null] : iv_ruleNewLineLine= ruleNewLineLine EOF ;
    public final EObject entryRuleNewLineLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewLineLine = null;


        try {
            // InternalCPreprocess.g:274:2: (iv_ruleNewLineLine= ruleNewLineLine EOF )
            // InternalCPreprocess.g:275:2: iv_ruleNewLineLine= ruleNewLineLine EOF
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
    // InternalCPreprocess.g:282:1: ruleNewLineLine returns [EObject current=null] : ( () this_NEWLINE_1= RULE_NEWLINE ) ;
    public final EObject ruleNewLineLine() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_1=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:288:7: ( ( () this_NEWLINE_1= RULE_NEWLINE ) )
            // InternalCPreprocess.g:290:1: ( () this_NEWLINE_1= RULE_NEWLINE )
            {
            // InternalCPreprocess.g:290:1: ( () this_NEWLINE_1= RULE_NEWLINE )
            // InternalCPreprocess.g:291:1: () this_NEWLINE_1= RULE_NEWLINE
            {
            // InternalCPreprocess.g:291:1: ()
            // InternalCPreprocess.g:292:5: 
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
    // InternalCPreprocess.g:316:1: entryRuleCode returns [EObject current=null] : iv_ruleCode= ruleCode EOF ;
    public final EObject entryRuleCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCode = null;


        try {
            // InternalCPreprocess.g:317:2: (iv_ruleCode= ruleCode EOF )
            // InternalCPreprocess.g:318:2: iv_ruleCode= ruleCode EOF
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
    // InternalCPreprocess.g:325:1: ruleCode returns [EObject current=null] : ( () ( (lv_code_1_0= RULE_MYCODE ) ) this_NEWLINE_2= RULE_NEWLINE ) ;
    public final EObject ruleCode() throws RecognitionException {
        EObject current = null;

        Token lv_code_1_0=null;
        Token this_NEWLINE_2=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:331:7: ( ( () ( (lv_code_1_0= RULE_MYCODE ) ) this_NEWLINE_2= RULE_NEWLINE ) )
            // InternalCPreprocess.g:333:1: ( () ( (lv_code_1_0= RULE_MYCODE ) ) this_NEWLINE_2= RULE_NEWLINE )
            {
            // InternalCPreprocess.g:333:1: ( () ( (lv_code_1_0= RULE_MYCODE ) ) this_NEWLINE_2= RULE_NEWLINE )
            // InternalCPreprocess.g:334:1: () ( (lv_code_1_0= RULE_MYCODE ) ) this_NEWLINE_2= RULE_NEWLINE
            {
            // InternalCPreprocess.g:334:1: ()
            // InternalCPreprocess.g:335:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCodeAccess().getCodeAction_0(),
                        current);
                

            }

            // InternalCPreprocess.g:343:1: ( (lv_code_1_0= RULE_MYCODE ) )
            // InternalCPreprocess.g:344:1: (lv_code_1_0= RULE_MYCODE )
            {
            // InternalCPreprocess.g:344:1: (lv_code_1_0= RULE_MYCODE )
            // InternalCPreprocess.g:345:3: lv_code_1_0= RULE_MYCODE
            {
            lv_code_1_0=(Token)match(input,RULE_MYCODE,FOLLOW_4); 

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});

}