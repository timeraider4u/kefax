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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NEWLINE", "RULE_INCLUDE", "RULE_DEFINE", "RULE_ID", "RULE_UNDEF", "RULE_ERROR", "RULE_PRAGMA", "RULE_MYCODE", "RULE_LINEFEED", "RULE_CARRIAGERETURN", "RULE_BACKSLASH", "RULE_LINEBREAK", "RULE_SPACE", "RULE_TAB", "RULE_WS", "RULE_HASH", "RULE_IDENTIFIER", "RULE_LETTER"
    };
    public static final int RULE_PRAGMA=10;
    public static final int RULE_ID=7;
    public static final int RULE_NEWLINE=4;
    public static final int RULE_ERROR=9;
    public static final int RULE_IDENTIFIER=20;
    public static final int RULE_HASH=19;
    public static final int RULE_TAB=17;
    public static final int RULE_UNDEF=8;
    public static final int EOF=-1;
    public static final int RULE_LETTER=21;
    public static final int RULE_LINEBREAK=15;
    public static final int RULE_DEFINE=6;
    public static final int RULE_CARRIAGERETURN=13;
    public static final int RULE_INCLUDE=5;
    public static final int RULE_BACKSLASH=14;
    public static final int RULE_MYCODE=11;
    public static final int RULE_WS=18;
    public static final int RULE_SPACE=16;
    public static final int RULE_LINEFEED=12;

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
                case RULE_INCLUDE:
                case RULE_DEFINE:
                case RULE_UNDEF:
                case RULE_ERROR:
                case RULE_PRAGMA:
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
    // InternalCPreprocess.g:238:1: rulePreprocessorDirectives returns [EObject current=null] : ( () ( ( (lv_directive_1_0= ruleIncludeDirective ) ) | ( (lv_directive_2_0= ruleDefineDirective ) ) | ( (lv_directive_3_0= ruleUnDefineDirective ) ) | ( (lv_directive_4_0= ruleErrorDirective ) ) | ( (lv_directive_5_0= rulePragmaDirective ) ) ) this_NEWLINE_6= RULE_NEWLINE ) ;
    public final EObject rulePreprocessorDirectives() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_6=null;
        EObject lv_directive_1_0 = null;

        EObject lv_directive_2_0 = null;

        EObject lv_directive_3_0 = null;

        EObject lv_directive_4_0 = null;

        EObject lv_directive_5_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:244:7: ( ( () ( ( (lv_directive_1_0= ruleIncludeDirective ) ) | ( (lv_directive_2_0= ruleDefineDirective ) ) | ( (lv_directive_3_0= ruleUnDefineDirective ) ) | ( (lv_directive_4_0= ruleErrorDirective ) ) | ( (lv_directive_5_0= rulePragmaDirective ) ) ) this_NEWLINE_6= RULE_NEWLINE ) )
            // InternalCPreprocess.g:246:1: ( () ( ( (lv_directive_1_0= ruleIncludeDirective ) ) | ( (lv_directive_2_0= ruleDefineDirective ) ) | ( (lv_directive_3_0= ruleUnDefineDirective ) ) | ( (lv_directive_4_0= ruleErrorDirective ) ) | ( (lv_directive_5_0= rulePragmaDirective ) ) ) this_NEWLINE_6= RULE_NEWLINE )
            {
            // InternalCPreprocess.g:246:1: ( () ( ( (lv_directive_1_0= ruleIncludeDirective ) ) | ( (lv_directive_2_0= ruleDefineDirective ) ) | ( (lv_directive_3_0= ruleUnDefineDirective ) ) | ( (lv_directive_4_0= ruleErrorDirective ) ) | ( (lv_directive_5_0= rulePragmaDirective ) ) ) this_NEWLINE_6= RULE_NEWLINE )
            // InternalCPreprocess.g:247:1: () ( ( (lv_directive_1_0= ruleIncludeDirective ) ) | ( (lv_directive_2_0= ruleDefineDirective ) ) | ( (lv_directive_3_0= ruleUnDefineDirective ) ) | ( (lv_directive_4_0= ruleErrorDirective ) ) | ( (lv_directive_5_0= rulePragmaDirective ) ) ) this_NEWLINE_6= RULE_NEWLINE
            {
            // InternalCPreprocess.g:247:1: ()
            // InternalCPreprocess.g:248:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPreprocessorDirectivesAccess().getPreprocessorDirectivesAction_0(),
                        current);
                

            }

            // InternalCPreprocess.g:256:1: ( ( (lv_directive_1_0= ruleIncludeDirective ) ) | ( (lv_directive_2_0= ruleDefineDirective ) ) | ( (lv_directive_3_0= ruleUnDefineDirective ) ) | ( (lv_directive_4_0= ruleErrorDirective ) ) | ( (lv_directive_5_0= rulePragmaDirective ) ) )
            int alt2=5;
            switch ( input.LA(1) ) {
            case RULE_INCLUDE:
                {
                alt2=1;
                }
                break;
            case RULE_DEFINE:
                {
                alt2=2;
                }
                break;
            case RULE_UNDEF:
                {
                alt2=3;
                }
                break;
            case RULE_ERROR:
                {
                alt2=4;
                }
                break;
            case RULE_PRAGMA:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalCPreprocess.g:257:1: ( (lv_directive_1_0= ruleIncludeDirective ) )
                    {
                    // InternalCPreprocess.g:257:1: ( (lv_directive_1_0= ruleIncludeDirective ) )
                    // InternalCPreprocess.g:258:1: (lv_directive_1_0= ruleIncludeDirective )
                    {
                    // InternalCPreprocess.g:258:1: (lv_directive_1_0= ruleIncludeDirective )
                    // InternalCPreprocess.g:259:3: lv_directive_1_0= ruleIncludeDirective
                    {
                     
                    	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveIncludeDirectiveParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_4);
                    lv_directive_1_0=ruleIncludeDirective();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
                    	        }
                           		set(
                           			current, 
                           			"directive",
                            		lv_directive_1_0, 
                            		"at.jku.weiner.cpreprocess.CPreprocess.IncludeDirective");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCPreprocess.g:279:1: ( (lv_directive_2_0= ruleDefineDirective ) )
                    {
                    // InternalCPreprocess.g:279:1: ( (lv_directive_2_0= ruleDefineDirective ) )
                    // InternalCPreprocess.g:280:1: (lv_directive_2_0= ruleDefineDirective )
                    {
                    // InternalCPreprocess.g:280:1: (lv_directive_2_0= ruleDefineDirective )
                    // InternalCPreprocess.g:281:3: lv_directive_2_0= ruleDefineDirective
                    {
                     
                    	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveDefineDirectiveParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_4);
                    lv_directive_2_0=ruleDefineDirective();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
                    	        }
                           		set(
                           			current, 
                           			"directive",
                            		lv_directive_2_0, 
                            		"at.jku.weiner.cpreprocess.CPreprocess.DefineDirective");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCPreprocess.g:301:1: ( (lv_directive_3_0= ruleUnDefineDirective ) )
                    {
                    // InternalCPreprocess.g:301:1: ( (lv_directive_3_0= ruleUnDefineDirective ) )
                    // InternalCPreprocess.g:302:1: (lv_directive_3_0= ruleUnDefineDirective )
                    {
                    // InternalCPreprocess.g:302:1: (lv_directive_3_0= ruleUnDefineDirective )
                    // InternalCPreprocess.g:303:3: lv_directive_3_0= ruleUnDefineDirective
                    {
                     
                    	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveUnDefineDirectiveParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_4);
                    lv_directive_3_0=ruleUnDefineDirective();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
                    	        }
                           		set(
                           			current, 
                           			"directive",
                            		lv_directive_3_0, 
                            		"at.jku.weiner.cpreprocess.CPreprocess.UnDefineDirective");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalCPreprocess.g:323:1: ( (lv_directive_4_0= ruleErrorDirective ) )
                    {
                    // InternalCPreprocess.g:323:1: ( (lv_directive_4_0= ruleErrorDirective ) )
                    // InternalCPreprocess.g:324:1: (lv_directive_4_0= ruleErrorDirective )
                    {
                    // InternalCPreprocess.g:324:1: (lv_directive_4_0= ruleErrorDirective )
                    // InternalCPreprocess.g:325:3: lv_directive_4_0= ruleErrorDirective
                    {
                     
                    	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveErrorDirectiveParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_4);
                    lv_directive_4_0=ruleErrorDirective();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
                    	        }
                           		set(
                           			current, 
                           			"directive",
                            		lv_directive_4_0, 
                            		"at.jku.weiner.cpreprocess.CPreprocess.ErrorDirective");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalCPreprocess.g:345:1: ( (lv_directive_5_0= rulePragmaDirective ) )
                    {
                    // InternalCPreprocess.g:345:1: ( (lv_directive_5_0= rulePragmaDirective ) )
                    // InternalCPreprocess.g:346:1: (lv_directive_5_0= rulePragmaDirective )
                    {
                    // InternalCPreprocess.g:346:1: (lv_directive_5_0= rulePragmaDirective )
                    // InternalCPreprocess.g:347:3: lv_directive_5_0= rulePragmaDirective
                    {
                     
                    	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectivePragmaDirectiveParserRuleCall_1_4_0()); 
                    	    
                    pushFollow(FOLLOW_4);
                    lv_directive_5_0=rulePragmaDirective();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
                    	        }
                           		set(
                           			current, 
                           			"directive",
                            		lv_directive_5_0, 
                            		"at.jku.weiner.cpreprocess.CPreprocess.PragmaDirective");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            this_NEWLINE_6=(Token)match(input,RULE_NEWLINE,FOLLOW_2); 
             
                newLeafNode(this_NEWLINE_6, grammarAccess.getPreprocessorDirectivesAccess().getNEWLINETerminalRuleCall_2()); 
                

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
    // InternalCPreprocess.g:384:1: entryRuleIncludeDirective returns [EObject current=null] : iv_ruleIncludeDirective= ruleIncludeDirective EOF ;
    public final EObject entryRuleIncludeDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDirective = null;


        try {
            // InternalCPreprocess.g:385:2: (iv_ruleIncludeDirective= ruleIncludeDirective EOF )
            // InternalCPreprocess.g:386:2: iv_ruleIncludeDirective= ruleIncludeDirective EOF
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
    // InternalCPreprocess.g:393:1: ruleIncludeDirective returns [EObject current=null] : ( () this_INCLUDE_1= RULE_INCLUDE ( (lv_string_2_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleIncludeDirective() throws RecognitionException {
        EObject current = null;

        Token this_INCLUDE_1=null;
        AntlrDatatypeRuleToken lv_string_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:399:7: ( ( () this_INCLUDE_1= RULE_INCLUDE ( (lv_string_2_0= ruleMyCodeLine ) ) ) )
            // InternalCPreprocess.g:401:1: ( () this_INCLUDE_1= RULE_INCLUDE ( (lv_string_2_0= ruleMyCodeLine ) ) )
            {
            // InternalCPreprocess.g:401:1: ( () this_INCLUDE_1= RULE_INCLUDE ( (lv_string_2_0= ruleMyCodeLine ) ) )
            // InternalCPreprocess.g:402:1: () this_INCLUDE_1= RULE_INCLUDE ( (lv_string_2_0= ruleMyCodeLine ) )
            {
            // InternalCPreprocess.g:402:1: ()
            // InternalCPreprocess.g:403:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIncludeDirectiveAccess().getIncludeDirectiveAction_0(),
                        current);
                

            }

            this_INCLUDE_1=(Token)match(input,RULE_INCLUDE,FOLLOW_5); 
             
                newLeafNode(this_INCLUDE_1, grammarAccess.getIncludeDirectiveAccess().getINCLUDETerminalRuleCall_1()); 
                
            // InternalCPreprocess.g:418:1: ( (lv_string_2_0= ruleMyCodeLine ) )
            // InternalCPreprocess.g:419:1: (lv_string_2_0= ruleMyCodeLine )
            {
            // InternalCPreprocess.g:419:1: (lv_string_2_0= ruleMyCodeLine )
            // InternalCPreprocess.g:420:3: lv_string_2_0= ruleMyCodeLine
            {
             
            	        newCompositeNode(grammarAccess.getIncludeDirectiveAccess().getStringMyCodeLineParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_string_2_0=ruleMyCodeLine();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIncludeDirectiveRule());
            	        }
                   		set(
                   			current, 
                   			"string",
                    		lv_string_2_0, 
                    		"at.jku.weiner.cpreprocess.CPreprocess.MyCodeLine");
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
    // $ANTLR end "ruleIncludeDirective"


    // $ANTLR start "entryRuleDefineDirective"
    // InternalCPreprocess.g:448:1: entryRuleDefineDirective returns [EObject current=null] : iv_ruleDefineDirective= ruleDefineDirective EOF ;
    public final EObject entryRuleDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineDirective = null;


        try {
            // InternalCPreprocess.g:449:2: (iv_ruleDefineDirective= ruleDefineDirective EOF )
            // InternalCPreprocess.g:450:2: iv_ruleDefineDirective= ruleDefineDirective EOF
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
    // InternalCPreprocess.g:457:1: ruleDefineDirective returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE ( (lv_id_2_0= RULE_ID ) ) ( (lv_string_3_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleDefineDirective() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_1=null;
        Token lv_id_2_0=null;
        AntlrDatatypeRuleToken lv_string_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:463:7: ( ( () this_DEFINE_1= RULE_DEFINE ( (lv_id_2_0= RULE_ID ) ) ( (lv_string_3_0= ruleMyCodeLine ) ) ) )
            // InternalCPreprocess.g:465:1: ( () this_DEFINE_1= RULE_DEFINE ( (lv_id_2_0= RULE_ID ) ) ( (lv_string_3_0= ruleMyCodeLine ) ) )
            {
            // InternalCPreprocess.g:465:1: ( () this_DEFINE_1= RULE_DEFINE ( (lv_id_2_0= RULE_ID ) ) ( (lv_string_3_0= ruleMyCodeLine ) ) )
            // InternalCPreprocess.g:466:1: () this_DEFINE_1= RULE_DEFINE ( (lv_id_2_0= RULE_ID ) ) ( (lv_string_3_0= ruleMyCodeLine ) )
            {
            // InternalCPreprocess.g:466:1: ()
            // InternalCPreprocess.g:467:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDefineDirectiveAccess().getDefineDirectiveAction_0(),
                        current);
                

            }

            this_DEFINE_1=(Token)match(input,RULE_DEFINE,FOLLOW_6); 
             
                newLeafNode(this_DEFINE_1, grammarAccess.getDefineDirectiveAccess().getDEFINETerminalRuleCall_1()); 
                
            // InternalCPreprocess.g:482:1: ( (lv_id_2_0= RULE_ID ) )
            // InternalCPreprocess.g:483:1: (lv_id_2_0= RULE_ID )
            {
            // InternalCPreprocess.g:483:1: (lv_id_2_0= RULE_ID )
            // InternalCPreprocess.g:484:3: lv_id_2_0= RULE_ID
            {
            lv_id_2_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            			newLeafNode(lv_id_2_0, grammarAccess.getDefineDirectiveAccess().getIdIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDefineDirectiveRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_2_0, 
                    		"at.jku.weiner.cpreprocess.CPreprocess.ID");
            	    

            }


            }

            // InternalCPreprocess.g:503:1: ( (lv_string_3_0= ruleMyCodeLine ) )
            // InternalCPreprocess.g:504:1: (lv_string_3_0= ruleMyCodeLine )
            {
            // InternalCPreprocess.g:504:1: (lv_string_3_0= ruleMyCodeLine )
            // InternalCPreprocess.g:505:3: lv_string_3_0= ruleMyCodeLine
            {
             
            	        newCompositeNode(grammarAccess.getDefineDirectiveAccess().getStringMyCodeLineParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_string_3_0=ruleMyCodeLine();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDefineDirectiveRule());
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
    // $ANTLR end "ruleDefineDirective"


    // $ANTLR start "entryRuleUnDefineDirective"
    // InternalCPreprocess.g:533:1: entryRuleUnDefineDirective returns [EObject current=null] : iv_ruleUnDefineDirective= ruleUnDefineDirective EOF ;
    public final EObject entryRuleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnDefineDirective = null;


        try {
            // InternalCPreprocess.g:534:2: (iv_ruleUnDefineDirective= ruleUnDefineDirective EOF )
            // InternalCPreprocess.g:535:2: iv_ruleUnDefineDirective= ruleUnDefineDirective EOF
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
    // InternalCPreprocess.g:542:1: ruleUnDefineDirective returns [EObject current=null] : ( () this_UNDEF_1= RULE_UNDEF ( (lv_id_2_0= RULE_ID ) ) ) ;
    public final EObject ruleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        Token this_UNDEF_1=null;
        Token lv_id_2_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:548:7: ( ( () this_UNDEF_1= RULE_UNDEF ( (lv_id_2_0= RULE_ID ) ) ) )
            // InternalCPreprocess.g:550:1: ( () this_UNDEF_1= RULE_UNDEF ( (lv_id_2_0= RULE_ID ) ) )
            {
            // InternalCPreprocess.g:550:1: ( () this_UNDEF_1= RULE_UNDEF ( (lv_id_2_0= RULE_ID ) ) )
            // InternalCPreprocess.g:551:1: () this_UNDEF_1= RULE_UNDEF ( (lv_id_2_0= RULE_ID ) )
            {
            // InternalCPreprocess.g:551:1: ()
            // InternalCPreprocess.g:552:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUnDefineDirectiveAccess().getUnDefineDirectiveAction_0(),
                        current);
                

            }

            this_UNDEF_1=(Token)match(input,RULE_UNDEF,FOLLOW_6); 
             
                newLeafNode(this_UNDEF_1, grammarAccess.getUnDefineDirectiveAccess().getUNDEFTerminalRuleCall_1()); 
                
            // InternalCPreprocess.g:567:1: ( (lv_id_2_0= RULE_ID ) )
            // InternalCPreprocess.g:568:1: (lv_id_2_0= RULE_ID )
            {
            // InternalCPreprocess.g:568:1: (lv_id_2_0= RULE_ID )
            // InternalCPreprocess.g:569:3: lv_id_2_0= RULE_ID
            {
            lv_id_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            			newLeafNode(lv_id_2_0, grammarAccess.getUnDefineDirectiveAccess().getIdIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUnDefineDirectiveRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_2_0, 
                    		"at.jku.weiner.cpreprocess.CPreprocess.ID");
            	    

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
    // $ANTLR end "ruleUnDefineDirective"


    // $ANTLR start "entryRuleErrorDirective"
    // InternalCPreprocess.g:597:1: entryRuleErrorDirective returns [EObject current=null] : iv_ruleErrorDirective= ruleErrorDirective EOF ;
    public final EObject entryRuleErrorDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorDirective = null;


        try {
            // InternalCPreprocess.g:598:2: (iv_ruleErrorDirective= ruleErrorDirective EOF )
            // InternalCPreprocess.g:599:2: iv_ruleErrorDirective= ruleErrorDirective EOF
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
    // InternalCPreprocess.g:606:1: ruleErrorDirective returns [EObject current=null] : ( () this_ERROR_1= RULE_ERROR ( (lv_msg_2_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleErrorDirective() throws RecognitionException {
        EObject current = null;

        Token this_ERROR_1=null;
        AntlrDatatypeRuleToken lv_msg_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:612:7: ( ( () this_ERROR_1= RULE_ERROR ( (lv_msg_2_0= ruleMyCodeLine ) ) ) )
            // InternalCPreprocess.g:614:1: ( () this_ERROR_1= RULE_ERROR ( (lv_msg_2_0= ruleMyCodeLine ) ) )
            {
            // InternalCPreprocess.g:614:1: ( () this_ERROR_1= RULE_ERROR ( (lv_msg_2_0= ruleMyCodeLine ) ) )
            // InternalCPreprocess.g:615:1: () this_ERROR_1= RULE_ERROR ( (lv_msg_2_0= ruleMyCodeLine ) )
            {
            // InternalCPreprocess.g:615:1: ()
            // InternalCPreprocess.g:616:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getErrorDirectiveAccess().getErrorDirectiveAction_0(),
                        current);
                

            }

            this_ERROR_1=(Token)match(input,RULE_ERROR,FOLLOW_5); 
             
                newLeafNode(this_ERROR_1, grammarAccess.getErrorDirectiveAccess().getERRORTerminalRuleCall_1()); 
                
            // InternalCPreprocess.g:631:1: ( (lv_msg_2_0= ruleMyCodeLine ) )
            // InternalCPreprocess.g:632:1: (lv_msg_2_0= ruleMyCodeLine )
            {
            // InternalCPreprocess.g:632:1: (lv_msg_2_0= ruleMyCodeLine )
            // InternalCPreprocess.g:633:3: lv_msg_2_0= ruleMyCodeLine
            {
             
            	        newCompositeNode(grammarAccess.getErrorDirectiveAccess().getMsgMyCodeLineParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_msg_2_0=ruleMyCodeLine();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getErrorDirectiveRule());
            	        }
                   		set(
                   			current, 
                   			"msg",
                    		lv_msg_2_0, 
                    		"at.jku.weiner.cpreprocess.CPreprocess.MyCodeLine");
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
    // $ANTLR end "ruleErrorDirective"


    // $ANTLR start "entryRulePragmaDirective"
    // InternalCPreprocess.g:661:1: entryRulePragmaDirective returns [EObject current=null] : iv_rulePragmaDirective= rulePragmaDirective EOF ;
    public final EObject entryRulePragmaDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePragmaDirective = null;


        try {
            // InternalCPreprocess.g:662:2: (iv_rulePragmaDirective= rulePragmaDirective EOF )
            // InternalCPreprocess.g:663:2: iv_rulePragmaDirective= rulePragmaDirective EOF
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
    // InternalCPreprocess.g:670:1: rulePragmaDirective returns [EObject current=null] : ( () this_PRAGMA_1= RULE_PRAGMA ) ;
    public final EObject rulePragmaDirective() throws RecognitionException {
        EObject current = null;

        Token this_PRAGMA_1=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:676:7: ( ( () this_PRAGMA_1= RULE_PRAGMA ) )
            // InternalCPreprocess.g:678:1: ( () this_PRAGMA_1= RULE_PRAGMA )
            {
            // InternalCPreprocess.g:678:1: ( () this_PRAGMA_1= RULE_PRAGMA )
            // InternalCPreprocess.g:679:1: () this_PRAGMA_1= RULE_PRAGMA
            {
            // InternalCPreprocess.g:679:1: ()
            // InternalCPreprocess.g:680:5: 
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
    // $ANTLR end "rulePragmaDirective"


    // $ANTLR start "entryRuleNewLineLine"
    // InternalCPreprocess.g:704:1: entryRuleNewLineLine returns [EObject current=null] : iv_ruleNewLineLine= ruleNewLineLine EOF ;
    public final EObject entryRuleNewLineLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewLineLine = null;


        try {
            // InternalCPreprocess.g:705:2: (iv_ruleNewLineLine= ruleNewLineLine EOF )
            // InternalCPreprocess.g:706:2: iv_ruleNewLineLine= ruleNewLineLine EOF
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
    // InternalCPreprocess.g:713:1: ruleNewLineLine returns [EObject current=null] : ( () this_NEWLINE_1= RULE_NEWLINE ) ;
    public final EObject ruleNewLineLine() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_1=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:719:7: ( ( () this_NEWLINE_1= RULE_NEWLINE ) )
            // InternalCPreprocess.g:721:1: ( () this_NEWLINE_1= RULE_NEWLINE )
            {
            // InternalCPreprocess.g:721:1: ( () this_NEWLINE_1= RULE_NEWLINE )
            // InternalCPreprocess.g:722:1: () this_NEWLINE_1= RULE_NEWLINE
            {
            // InternalCPreprocess.g:722:1: ()
            // InternalCPreprocess.g:723:5: 
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
    // InternalCPreprocess.g:747:1: entryRuleCode returns [EObject current=null] : iv_ruleCode= ruleCode EOF ;
    public final EObject entryRuleCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCode = null;


        try {
            // InternalCPreprocess.g:748:2: (iv_ruleCode= ruleCode EOF )
            // InternalCPreprocess.g:749:2: iv_ruleCode= ruleCode EOF
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
    // InternalCPreprocess.g:756:1: ruleCode returns [EObject current=null] : ( () ( (lv_code_1_0= RULE_MYCODE ) ) this_NEWLINE_2= RULE_NEWLINE ) ;
    public final EObject ruleCode() throws RecognitionException {
        EObject current = null;

        Token lv_code_1_0=null;
        Token this_NEWLINE_2=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalCPreprocess.g:762:7: ( ( () ( (lv_code_1_0= RULE_MYCODE ) ) this_NEWLINE_2= RULE_NEWLINE ) )
            // InternalCPreprocess.g:764:1: ( () ( (lv_code_1_0= RULE_MYCODE ) ) this_NEWLINE_2= RULE_NEWLINE )
            {
            // InternalCPreprocess.g:764:1: ( () ( (lv_code_1_0= RULE_MYCODE ) ) this_NEWLINE_2= RULE_NEWLINE )
            // InternalCPreprocess.g:765:1: () ( (lv_code_1_0= RULE_MYCODE ) ) this_NEWLINE_2= RULE_NEWLINE
            {
            // InternalCPreprocess.g:765:1: ()
            // InternalCPreprocess.g:766:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCodeAccess().getCodeAction_0(),
                        current);
                

            }

            // InternalCPreprocess.g:774:1: ( (lv_code_1_0= RULE_MYCODE ) )
            // InternalCPreprocess.g:775:1: (lv_code_1_0= RULE_MYCODE )
            {
            // InternalCPreprocess.g:775:1: (lv_code_1_0= RULE_MYCODE )
            // InternalCPreprocess.g:776:3: lv_code_1_0= RULE_MYCODE
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


    // $ANTLR start "entryRuleMyCodeLine"
    // InternalCPreprocess.g:811:1: entryRuleMyCodeLine returns [String current=null] : iv_ruleMyCodeLine= ruleMyCodeLine EOF ;
    public final String entryRuleMyCodeLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLine = null;


        try {
            // InternalCPreprocess.g:812:2: (iv_ruleMyCodeLine= ruleMyCodeLine EOF )
            // InternalCPreprocess.g:813:2: iv_ruleMyCodeLine= ruleMyCodeLine EOF
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
    // InternalCPreprocess.g:820:1: ruleMyCodeLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_MYCODE_0= RULE_MYCODE ;
    public final AntlrDatatypeRuleToken ruleMyCodeLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_MYCODE_0=null;

         enterRule(); 
            
        try {
            // InternalCPreprocess.g:823:28: (this_MYCODE_0= RULE_MYCODE )
            // InternalCPreprocess.g:824:5: this_MYCODE_0= RULE_MYCODE
            {
            this_MYCODE_0=(Token)match(input,RULE_MYCODE,FOLLOW_2); 

            		current.merge(this_MYCODE_0);
                
             
                newLeafNode(this_MYCODE_0, grammarAccess.getMyCodeLineAccess().getMYCODETerminalRuleCall()); 
                

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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000F72L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000080L});

}