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
import java.util.Map;
import java.util.HashMap;
public class InternalCPreprocessParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_HASH", "RULE_INCLUDE", "RULE_DEFINE", "RULE_ERROR", "RULE_UNDEF", "RULE_PRAGMA", "RULE_LPAREN", "RULE_RPAREN", "RULE_COMMA", "RULE_LINEFEED", "RULE_CARRIAGERETURN", "RULE_NEWLINE", "RULE_BACKSLASH", "RULE_LINEBREAK", "RULE_SPACE", "RULE_TAB", "RULE_WS", "RULE_ID", "RULE_ID_NONDIGIT", "RULE_DIGIT", "RULE_NONDIGIT_LETTER", "RULE_UNIVERSAL_CHARACTER", "RULE_HEX_QUAD", "RULE_HEXADECIMAL_DIGIT", "RULE_SPECIAL"
    };
    public static final int RULE_PRAGMA=9;
    public static final int RULE_ID=21;
    public static final int RULE_NEWLINE=15;
    public static final int RULE_ID_NONDIGIT=22;
    public static final int RULE_NONDIGIT_LETTER=24;
    public static final int RULE_ERROR=7;
    public static final int RULE_COMMA=12;
    public static final int RULE_HASH=4;
    public static final int RULE_TAB=19;
    public static final int RULE_UNDEF=8;
    public static final int EOF=-1;
    public static final int RULE_HEXADECIMAL_DIGIT=27;
    public static final int RULE_LINEBREAK=17;
    public static final int RULE_DEFINE=6;
    public static final int RULE_SPECIAL=28;
    public static final int RULE_LPAREN=10;
    public static final int RULE_CARRIAGERETURN=14;
    public static final int RULE_INCLUDE=5;
    public static final int RULE_BACKSLASH=16;
    public static final int RULE_RPAREN=11;
    public static final int RULE_WS=20;
    public static final int RULE_DIGIT=23;
    public static final int RULE_SPACE=18;
    public static final int RULE_UNIVERSAL_CHARACTER=25;
    public static final int RULE_LINEFEED=13;
    public static final int RULE_HEX_QUAD=26;

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



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     

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
    // InternalCPreprocessParser.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalCPreprocessParser.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalCPreprocessParser.g:69:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCPreprocessParser.g:76:1: ruleModel returns [EObject current=null] : ( () ( (lv_units_1_0= ruleTranslationUnit ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_units_1_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:79:28: ( ( () ( (lv_units_1_0= ruleTranslationUnit ) ) ) )
            // InternalCPreprocessParser.g:80:1: ( () ( (lv_units_1_0= ruleTranslationUnit ) ) )
            {
            // InternalCPreprocessParser.g:80:1: ( () ( (lv_units_1_0= ruleTranslationUnit ) ) )
            // InternalCPreprocessParser.g:80:2: () ( (lv_units_1_0= ruleTranslationUnit ) )
            {
            // InternalCPreprocessParser.g:80:2: ()
            // InternalCPreprocessParser.g:81:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getModelAccess().getModelAction_0(),
                          current);
                  
            }

            }

            // InternalCPreprocessParser.g:89:2: ( (lv_units_1_0= ruleTranslationUnit ) )
            // InternalCPreprocessParser.g:90:1: (lv_units_1_0= ruleTranslationUnit )
            {
            // InternalCPreprocessParser.g:90:1: (lv_units_1_0= ruleTranslationUnit )
            // InternalCPreprocessParser.g:91:3: lv_units_1_0= ruleTranslationUnit
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModelAccess().getUnitsTranslationUnitParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_units_1_0=ruleTranslationUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleTranslationUnit"
    // InternalCPreprocessParser.g:115:1: entryRuleTranslationUnit returns [EObject current=null] : iv_ruleTranslationUnit= ruleTranslationUnit EOF ;
    public final EObject entryRuleTranslationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTranslationUnit = null;


        try {
            // InternalCPreprocessParser.g:116:2: (iv_ruleTranslationUnit= ruleTranslationUnit EOF )
            // InternalCPreprocessParser.g:117:2: iv_ruleTranslationUnit= ruleTranslationUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTranslationUnitRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTranslationUnit=ruleTranslationUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTranslationUnit; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCPreprocessParser.g:124:1: ruleTranslationUnit returns [EObject current=null] : ( () ( (lv_group_1_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleTranslationUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_group_1_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:127:28: ( ( () ( (lv_group_1_0= ruleGroupOpt ) ) ) )
            // InternalCPreprocessParser.g:128:1: ( () ( (lv_group_1_0= ruleGroupOpt ) ) )
            {
            // InternalCPreprocessParser.g:128:1: ( () ( (lv_group_1_0= ruleGroupOpt ) ) )
            // InternalCPreprocessParser.g:128:2: () ( (lv_group_1_0= ruleGroupOpt ) )
            {
            // InternalCPreprocessParser.g:128:2: ()
            // InternalCPreprocessParser.g:129:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getTranslationUnitAccess().getTranslationUnitAction_0(),
                          current);
                  
            }

            }

            // InternalCPreprocessParser.g:137:2: ( (lv_group_1_0= ruleGroupOpt ) )
            // InternalCPreprocessParser.g:138:1: (lv_group_1_0= ruleGroupOpt )
            {
            // InternalCPreprocessParser.g:138:1: (lv_group_1_0= ruleGroupOpt )
            // InternalCPreprocessParser.g:139:3: lv_group_1_0= ruleGroupOpt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTranslationUnitAccess().getGroupGroupOptParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_group_1_0=ruleGroupOpt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleTranslationUnit"


    // $ANTLR start "entryRuleGroupOpt"
    // InternalCPreprocessParser.g:163:1: entryRuleGroupOpt returns [EObject current=null] : iv_ruleGroupOpt= ruleGroupOpt EOF ;
    public final EObject entryRuleGroupOpt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOpt = null;


        try {
            // InternalCPreprocessParser.g:164:2: (iv_ruleGroupOpt= ruleGroupOpt EOF )
            // InternalCPreprocessParser.g:165:2: iv_ruleGroupOpt= ruleGroupOpt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGroupOptRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGroupOpt=ruleGroupOpt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGroupOpt; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCPreprocessParser.g:172:1: ruleGroupOpt returns [EObject current=null] : ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* ) ;
    public final EObject ruleGroupOpt() throws RecognitionException {
        EObject current = null;

        EObject lv_lines_1_0 = null;

        EObject lv_lines_2_0 = null;

        EObject lv_lines_3_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:175:28: ( ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* ) )
            // InternalCPreprocessParser.g:176:1: ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* )
            {
            // InternalCPreprocessParser.g:176:1: ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* )
            // InternalCPreprocessParser.g:176:2: () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )*
            {
            // InternalCPreprocessParser.g:176:2: ()
            // InternalCPreprocessParser.g:177:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getGroupOptAccess().getGroupOptAction_0(),
                          current);
                  
            }

            }

            // InternalCPreprocessParser.g:185:2: ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )*
            loop1:
            do {
                int alt1=4;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // InternalCPreprocessParser.g:185:3: ( (lv_lines_1_0= rulePreprocessorDirectives ) )
            	    {
            	    // InternalCPreprocessParser.g:185:3: ( (lv_lines_1_0= rulePreprocessorDirectives ) )
            	    // InternalCPreprocessParser.g:186:1: (lv_lines_1_0= rulePreprocessorDirectives )
            	    {
            	    // InternalCPreprocessParser.g:186:1: (lv_lines_1_0= rulePreprocessorDirectives )
            	    // InternalCPreprocessParser.g:187:3: lv_lines_1_0= rulePreprocessorDirectives
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGroupOptAccess().getLinesPreprocessorDirectivesParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_lines_1_0=rulePreprocessorDirectives();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }
            	    break;
            	case 2 :
            	    // InternalCPreprocessParser.g:204:6: ( (lv_lines_2_0= ruleNewLineLine ) )
            	    {
            	    // InternalCPreprocessParser.g:204:6: ( (lv_lines_2_0= ruleNewLineLine ) )
            	    // InternalCPreprocessParser.g:205:1: (lv_lines_2_0= ruleNewLineLine )
            	    {
            	    // InternalCPreprocessParser.g:205:1: (lv_lines_2_0= ruleNewLineLine )
            	    // InternalCPreprocessParser.g:206:3: lv_lines_2_0= ruleNewLineLine
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGroupOptAccess().getLinesNewLineLineParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_lines_2_0=ruleNewLineLine();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }
            	    break;
            	case 3 :
            	    // InternalCPreprocessParser.g:223:6: ( (lv_lines_3_0= ruleCode ) )
            	    {
            	    // InternalCPreprocessParser.g:223:6: ( (lv_lines_3_0= ruleCode ) )
            	    // InternalCPreprocessParser.g:224:1: (lv_lines_3_0= ruleCode )
            	    {
            	    // InternalCPreprocessParser.g:224:1: (lv_lines_3_0= ruleCode )
            	    // InternalCPreprocessParser.g:225:3: lv_lines_3_0= ruleCode
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGroupOptAccess().getLinesCodeParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_lines_3_0=ruleCode();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleGroupOpt"


    // $ANTLR start "entryRulePreprocessorDirectives"
    // InternalCPreprocessParser.g:249:1: entryRulePreprocessorDirectives returns [EObject current=null] : iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF ;
    public final EObject entryRulePreprocessorDirectives() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreprocessorDirectives = null;


        try {
            // InternalCPreprocessParser.g:250:2: (iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF )
            // InternalCPreprocessParser.g:251:2: iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPreprocessorDirectivesRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePreprocessorDirectives=rulePreprocessorDirectives();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePreprocessorDirectives; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCPreprocessParser.g:258:1: rulePreprocessorDirectives returns [EObject current=null] : ( () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= rulePragmaDirective ) ) | ( (lv_directive_9_0= ruleNullDirective ) ) ) this_NEWLINE_10= RULE_NEWLINE ) ;
    public final EObject rulePreprocessorDirectives() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token this_HASH_2=null;
        Token this_WS_3=null;
        Token this_NEWLINE_10=null;
        EObject lv_directive_4_0 = null;

        EObject lv_directive_5_0 = null;

        EObject lv_directive_6_0 = null;

        EObject lv_directive_7_0 = null;

        EObject lv_directive_8_0 = null;

        EObject lv_directive_9_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:261:28: ( ( () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= rulePragmaDirective ) ) | ( (lv_directive_9_0= ruleNullDirective ) ) ) this_NEWLINE_10= RULE_NEWLINE ) )
            // InternalCPreprocessParser.g:262:1: ( () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= rulePragmaDirective ) ) | ( (lv_directive_9_0= ruleNullDirective ) ) ) this_NEWLINE_10= RULE_NEWLINE )
            {
            // InternalCPreprocessParser.g:262:1: ( () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= rulePragmaDirective ) ) | ( (lv_directive_9_0= ruleNullDirective ) ) ) this_NEWLINE_10= RULE_NEWLINE )
            // InternalCPreprocessParser.g:262:2: () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= rulePragmaDirective ) ) | ( (lv_directive_9_0= ruleNullDirective ) ) ) this_NEWLINE_10= RULE_NEWLINE
            {
            // InternalCPreprocessParser.g:262:2: ()
            // InternalCPreprocessParser.g:263:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPreprocessorDirectivesAccess().getPreprocessorDirectivesAction_0(),
                          current);
                  
            }

            }

            // InternalCPreprocessParser.g:271:2: (this_WS_1= RULE_WS )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_WS) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCPreprocessParser.g:271:3: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_1, grammarAccess.getPreprocessorDirectivesAccess().getWSTerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_2, grammarAccess.getPreprocessorDirectivesAccess().getHASHTerminalRuleCall_2()); 
                  
            }
            // InternalCPreprocessParser.g:279:1: (this_WS_3= RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCPreprocessParser.g:279:2: this_WS_3= RULE_WS
            	    {
            	    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_3, grammarAccess.getPreprocessorDirectivesAccess().getWSTerminalRuleCall_3()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalCPreprocessParser.g:283:3: ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= rulePragmaDirective ) ) | ( (lv_directive_9_0= ruleNullDirective ) ) )
            int alt4=6;
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
            case EOF:
            case RULE_NEWLINE:
                {
                alt4=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalCPreprocessParser.g:283:4: ( (lv_directive_4_0= ruleIncludeDirective ) )
                    {
                    // InternalCPreprocessParser.g:283:4: ( (lv_directive_4_0= ruleIncludeDirective ) )
                    // InternalCPreprocessParser.g:284:1: (lv_directive_4_0= ruleIncludeDirective )
                    {
                    // InternalCPreprocessParser.g:284:1: (lv_directive_4_0= ruleIncludeDirective )
                    // InternalCPreprocessParser.g:285:3: lv_directive_4_0= ruleIncludeDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveIncludeDirectiveParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
                    lv_directive_4_0=ruleIncludeDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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


                    }
                    break;
                case 2 :
                    // InternalCPreprocessParser.g:302:6: ( (lv_directive_5_0= ruleDefineDirective ) )
                    {
                    // InternalCPreprocessParser.g:302:6: ( (lv_directive_5_0= ruleDefineDirective ) )
                    // InternalCPreprocessParser.g:303:1: (lv_directive_5_0= ruleDefineDirective )
                    {
                    // InternalCPreprocessParser.g:303:1: (lv_directive_5_0= ruleDefineDirective )
                    // InternalCPreprocessParser.g:304:3: lv_directive_5_0= ruleDefineDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveDefineDirectiveParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
                    lv_directive_5_0=ruleDefineDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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


                    }
                    break;
                case 3 :
                    // InternalCPreprocessParser.g:321:6: ( (lv_directive_6_0= ruleErrorDirective ) )
                    {
                    // InternalCPreprocessParser.g:321:6: ( (lv_directive_6_0= ruleErrorDirective ) )
                    // InternalCPreprocessParser.g:322:1: (lv_directive_6_0= ruleErrorDirective )
                    {
                    // InternalCPreprocessParser.g:322:1: (lv_directive_6_0= ruleErrorDirective )
                    // InternalCPreprocessParser.g:323:3: lv_directive_6_0= ruleErrorDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveErrorDirectiveParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
                    lv_directive_6_0=ruleErrorDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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


                    }
                    break;
                case 4 :
                    // InternalCPreprocessParser.g:340:6: ( (lv_directive_7_0= ruleUnDefineDirective ) )
                    {
                    // InternalCPreprocessParser.g:340:6: ( (lv_directive_7_0= ruleUnDefineDirective ) )
                    // InternalCPreprocessParser.g:341:1: (lv_directive_7_0= ruleUnDefineDirective )
                    {
                    // InternalCPreprocessParser.g:341:1: (lv_directive_7_0= ruleUnDefineDirective )
                    // InternalCPreprocessParser.g:342:3: lv_directive_7_0= ruleUnDefineDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveUnDefineDirectiveParserRuleCall_4_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
                    lv_directive_7_0=ruleUnDefineDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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


                    }
                    break;
                case 5 :
                    // InternalCPreprocessParser.g:359:6: ( (lv_directive_8_0= rulePragmaDirective ) )
                    {
                    // InternalCPreprocessParser.g:359:6: ( (lv_directive_8_0= rulePragmaDirective ) )
                    // InternalCPreprocessParser.g:360:1: (lv_directive_8_0= rulePragmaDirective )
                    {
                    // InternalCPreprocessParser.g:360:1: (lv_directive_8_0= rulePragmaDirective )
                    // InternalCPreprocessParser.g:361:3: lv_directive_8_0= rulePragmaDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectivePragmaDirectiveParserRuleCall_4_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
                    lv_directive_8_0=rulePragmaDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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


                    }
                    break;
                case 6 :
                    // InternalCPreprocessParser.g:378:6: ( (lv_directive_9_0= ruleNullDirective ) )
                    {
                    // InternalCPreprocessParser.g:378:6: ( (lv_directive_9_0= ruleNullDirective ) )
                    // InternalCPreprocessParser.g:379:1: (lv_directive_9_0= ruleNullDirective )
                    {
                    // InternalCPreprocessParser.g:379:1: (lv_directive_9_0= ruleNullDirective )
                    // InternalCPreprocessParser.g:380:3: lv_directive_9_0= ruleNullDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveNullDirectiveParserRuleCall_4_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
                    lv_directive_9_0=ruleNullDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
                      	        }
                             		set(
                             			current, 
                             			"directive",
                              		lv_directive_9_0, 
                              		"at.jku.weiner.cpreprocess.CPreprocess.NullDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            this_NEWLINE_10=(Token)match(input,RULE_NEWLINE,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_10, grammarAccess.getPreprocessorDirectivesAccess().getNEWLINETerminalRuleCall_5()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePreprocessorDirectives"


    // $ANTLR start "entryRuleIncludeDirective"
    // InternalCPreprocessParser.g:408:1: entryRuleIncludeDirective returns [EObject current=null] : iv_ruleIncludeDirective= ruleIncludeDirective EOF ;
    public final EObject entryRuleIncludeDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDirective = null;


        try {
            // InternalCPreprocessParser.g:409:2: (iv_ruleIncludeDirective= ruleIncludeDirective EOF )
            // InternalCPreprocessParser.g:410:2: iv_ruleIncludeDirective= ruleIncludeDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIncludeDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIncludeDirective=ruleIncludeDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIncludeDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCPreprocessParser.g:417:1: ruleIncludeDirective returns [EObject current=null] : ( () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleIncludeDirective() throws RecognitionException {
        EObject current = null;

        Token this_INCLUDE_1=null;
        Token this_WS_2=null;
        AntlrDatatypeRuleToken lv_string_3_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:420:28: ( ( () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) ) ) )
            // InternalCPreprocessParser.g:421:1: ( () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) ) )
            {
            // InternalCPreprocessParser.g:421:1: ( () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) ) )
            // InternalCPreprocessParser.g:421:2: () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) )
            {
            // InternalCPreprocessParser.g:421:2: ()
            // InternalCPreprocessParser.g:422:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getIncludeDirectiveAccess().getIncludeDirectiveAction_0(),
                          current);
                  
            }

            }

            this_INCLUDE_1=(Token)match(input,RULE_INCLUDE,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INCLUDE_1, grammarAccess.getIncludeDirectiveAccess().getINCLUDETerminalRuleCall_1()); 
                  
            }
            // InternalCPreprocessParser.g:434:1: (this_WS_2= RULE_WS )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_WS) ) {
                    int LA5_2 = input.LA(2);

                    if ( (synpred11_InternalCPreprocessParser()) ) {
                        alt5=1;
                    }


                }


                switch (alt5) {
            	case 1 :
            	    // InternalCPreprocessParser.g:434:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_2, grammarAccess.getIncludeDirectiveAccess().getWSTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            // InternalCPreprocessParser.g:438:3: ( (lv_string_3_0= ruleMyCodeLine ) )
            // InternalCPreprocessParser.g:439:1: (lv_string_3_0= ruleMyCodeLine )
            {
            // InternalCPreprocessParser.g:439:1: (lv_string_3_0= ruleMyCodeLine )
            // InternalCPreprocessParser.g:440:3: lv_string_3_0= ruleMyCodeLine
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIncludeDirectiveAccess().getStringMyCodeLineParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_string_3_0=ruleMyCodeLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleIncludeDirective"


    // $ANTLR start "entryRuleDefineDirective"
    // InternalCPreprocessParser.g:464:1: entryRuleDefineDirective returns [EObject current=null] : iv_ruleDefineDirective= ruleDefineDirective EOF ;
    public final EObject entryRuleDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineDirective = null;


        try {
            // InternalCPreprocessParser.g:465:2: (iv_ruleDefineDirective= ruleDefineDirective EOF )
            // InternalCPreprocessParser.g:466:2: iv_ruleDefineDirective= ruleDefineDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefineDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDefineDirective=ruleDefineDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefineDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCPreprocessParser.g:473:1: ruleDefineDirective returns [EObject current=null] : (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro ) ;
    public final EObject ruleDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject this_DefineObjectMacro_0 = null;

        EObject this_DefineFunctionLikeMacro_1 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:476:28: ( (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro ) )
            // InternalCPreprocessParser.g:477:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )
            {
            // InternalCPreprocessParser.g:477:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalCPreprocessParser.g:478:2: this_DefineObjectMacro_0= ruleDefineObjectMacro
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDefineDirectiveAccess().getDefineObjectMacroParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_DefineObjectMacro_0=ruleDefineObjectMacro();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_DefineObjectMacro_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalCPreprocessParser.g:491:2: this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDefineDirectiveAccess().getDefineFunctionLikeMacroParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_DefineFunctionLikeMacro_1=ruleDefineFunctionLikeMacro();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_DefineFunctionLikeMacro_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleDefineDirective"


    // $ANTLR start "entryRuleDefineObjectMacro"
    // InternalCPreprocessParser.g:510:1: entryRuleDefineObjectMacro returns [EObject current=null] : iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF ;
    public final EObject entryRuleDefineObjectMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineObjectMacro = null;


        try {
            // InternalCPreprocessParser.g:511:2: (iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF )
            // InternalCPreprocessParser.g:512:2: iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefineObjectMacroRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDefineObjectMacro=ruleDefineObjectMacro();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefineObjectMacro; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDefineObjectMacro"


    // $ANTLR start "ruleDefineObjectMacro"
    // InternalCPreprocessParser.g:519:1: ruleDefineObjectMacro returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? ) ;
    public final EObject ruleDefineObjectMacro() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_1=null;
        Token this_WS_2=null;
        Token lv_id_3_0=null;
        Token this_WS_4=null;
        AntlrDatatypeRuleToken lv_string_5_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:522:28: ( ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? ) )
            // InternalCPreprocessParser.g:523:1: ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? )
            {
            // InternalCPreprocessParser.g:523:1: ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? )
            // InternalCPreprocessParser.g:523:2: () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )?
            {
            // InternalCPreprocessParser.g:523:2: ()
            // InternalCPreprocessParser.g:524:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getDefineObjectMacroAccess().getDefineObjectMacroAction_0(),
                          current);
                  
            }

            }

            this_DEFINE_1=(Token)match(input,RULE_DEFINE,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DEFINE_1, grammarAccess.getDefineObjectMacroAccess().getDEFINETerminalRuleCall_1()); 
                  
            }
            // InternalCPreprocessParser.g:536:1: (this_WS_2= RULE_WS )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_WS) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalCPreprocessParser.g:536:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_2, grammarAccess.getDefineObjectMacroAccess().getWSTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            // InternalCPreprocessParser.g:540:3: ( (lv_id_3_0= RULE_ID ) )
            // InternalCPreprocessParser.g:541:1: (lv_id_3_0= RULE_ID )
            {
            // InternalCPreprocessParser.g:541:1: (lv_id_3_0= RULE_ID )
            // InternalCPreprocessParser.g:542:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_id_3_0, grammarAccess.getDefineObjectMacroAccess().getIdIDTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDefineObjectMacroRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"id",
                      		lv_id_3_0, 
                      		"at.jku.weiner.cpreprocess.CPreprocess.ID");
              	    
            }

            }


            }

            // InternalCPreprocessParser.g:558:2: ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_WS) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalCPreprocessParser.g:558:3: (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) )
                    {
                    // InternalCPreprocessParser.g:558:3: (this_WS_4= RULE_WS )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_WS) ) {
                            int LA8_2 = input.LA(2);

                            if ( (synpred14_InternalCPreprocessParser()) ) {
                                alt8=1;
                            }


                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalCPreprocessParser.g:558:4: this_WS_4= RULE_WS
                    	    {
                    	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_WS_4, grammarAccess.getDefineObjectMacroAccess().getWSTerminalRuleCall_4_0()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    // InternalCPreprocessParser.g:562:3: ( (lv_string_5_0= ruleMyDefineLine ) )
                    // InternalCPreprocessParser.g:563:1: (lv_string_5_0= ruleMyDefineLine )
                    {
                    // InternalCPreprocessParser.g:563:1: (lv_string_5_0= ruleMyDefineLine )
                    // InternalCPreprocessParser.g:564:3: lv_string_5_0= ruleMyDefineLine
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefineObjectMacroAccess().getStringMyDefineLineParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_string_5_0=ruleMyDefineLine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDefineObjectMacroRule());
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
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleDefineObjectMacro"


    // $ANTLR start "entryRuleDefineFunctionLikeMacro"
    // InternalCPreprocessParser.g:588:1: entryRuleDefineFunctionLikeMacro returns [EObject current=null] : iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF ;
    public final EObject entryRuleDefineFunctionLikeMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineFunctionLikeMacro = null;


        try {
            // InternalCPreprocessParser.g:589:2: (iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF )
            // InternalCPreprocessParser.g:590:2: iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefineFunctionLikeMacroRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDefineFunctionLikeMacro=ruleDefineFunctionLikeMacro();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefineFunctionLikeMacro; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDefineFunctionLikeMacro"


    // $ANTLR start "ruleDefineFunctionLikeMacro"
    // InternalCPreprocessParser.g:597:1: ruleDefineFunctionLikeMacro returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_LPAREN_4= RULE_LPAREN (this_WS_5= RULE_WS )* ( (lv_list_6_0= ruleIdentifierList ) )? this_RPAREN_7= RULE_RPAREN (this_WS_8= RULE_WS )+ ( (lv_string_9_0= ruleMyDefineLine ) ) ) ;
    public final EObject ruleDefineFunctionLikeMacro() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_1=null;
        Token this_WS_2=null;
        Token lv_id_3_0=null;
        Token this_LPAREN_4=null;
        Token this_WS_5=null;
        Token this_RPAREN_7=null;
        Token this_WS_8=null;
        EObject lv_list_6_0 = null;

        AntlrDatatypeRuleToken lv_string_9_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:600:28: ( ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_LPAREN_4= RULE_LPAREN (this_WS_5= RULE_WS )* ( (lv_list_6_0= ruleIdentifierList ) )? this_RPAREN_7= RULE_RPAREN (this_WS_8= RULE_WS )+ ( (lv_string_9_0= ruleMyDefineLine ) ) ) )
            // InternalCPreprocessParser.g:601:1: ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_LPAREN_4= RULE_LPAREN (this_WS_5= RULE_WS )* ( (lv_list_6_0= ruleIdentifierList ) )? this_RPAREN_7= RULE_RPAREN (this_WS_8= RULE_WS )+ ( (lv_string_9_0= ruleMyDefineLine ) ) )
            {
            // InternalCPreprocessParser.g:601:1: ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_LPAREN_4= RULE_LPAREN (this_WS_5= RULE_WS )* ( (lv_list_6_0= ruleIdentifierList ) )? this_RPAREN_7= RULE_RPAREN (this_WS_8= RULE_WS )+ ( (lv_string_9_0= ruleMyDefineLine ) ) )
            // InternalCPreprocessParser.g:601:2: () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_LPAREN_4= RULE_LPAREN (this_WS_5= RULE_WS )* ( (lv_list_6_0= ruleIdentifierList ) )? this_RPAREN_7= RULE_RPAREN (this_WS_8= RULE_WS )+ ( (lv_string_9_0= ruleMyDefineLine ) )
            {
            // InternalCPreprocessParser.g:601:2: ()
            // InternalCPreprocessParser.g:602:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getDefineFunctionLikeMacroAccess().getDefineFunctionLikeMacroAction_0(),
                          current);
                  
            }

            }

            this_DEFINE_1=(Token)match(input,RULE_DEFINE,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DEFINE_1, grammarAccess.getDefineFunctionLikeMacroAccess().getDEFINETerminalRuleCall_1()); 
                  
            }
            // InternalCPreprocessParser.g:614:1: (this_WS_2= RULE_WS )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_WS) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalCPreprocessParser.g:614:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_2, grammarAccess.getDefineFunctionLikeMacroAccess().getWSTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            // InternalCPreprocessParser.g:618:3: ( (lv_id_3_0= RULE_ID ) )
            // InternalCPreprocessParser.g:619:1: (lv_id_3_0= RULE_ID )
            {
            // InternalCPreprocessParser.g:619:1: (lv_id_3_0= RULE_ID )
            // InternalCPreprocessParser.g:620:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_id_3_0, grammarAccess.getDefineFunctionLikeMacroAccess().getIdIDTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDefineFunctionLikeMacroRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"id",
                      		lv_id_3_0, 
                      		"at.jku.weiner.cpreprocess.CPreprocess.ID");
              	    
            }

            }


            }

            this_LPAREN_4=(Token)match(input,RULE_LPAREN,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LPAREN_4, grammarAccess.getDefineFunctionLikeMacroAccess().getLPARENTerminalRuleCall_4()); 
                  
            }
            // InternalCPreprocessParser.g:640:1: (this_WS_5= RULE_WS )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_WS) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalCPreprocessParser.g:640:2: this_WS_5= RULE_WS
            	    {
            	    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_5, grammarAccess.getDefineFunctionLikeMacroAccess().getWSTerminalRuleCall_5()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalCPreprocessParser.g:644:3: ( (lv_list_6_0= ruleIdentifierList ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalCPreprocessParser.g:645:1: (lv_list_6_0= ruleIdentifierList )
                    {
                    // InternalCPreprocessParser.g:645:1: (lv_list_6_0= ruleIdentifierList )
                    // InternalCPreprocessParser.g:646:3: lv_list_6_0= ruleIdentifierList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefineFunctionLikeMacroAccess().getListIdentifierListParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_13);
                    lv_list_6_0=ruleIdentifierList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDefineFunctionLikeMacroRule());
                      	        }
                             		set(
                             			current, 
                             			"list",
                              		lv_list_6_0, 
                              		"at.jku.weiner.cpreprocess.CPreprocess.IdentifierList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            this_RPAREN_7=(Token)match(input,RULE_RPAREN,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RPAREN_7, grammarAccess.getDefineFunctionLikeMacroAccess().getRPARENTerminalRuleCall_7()); 
                  
            }
            // InternalCPreprocessParser.g:666:1: (this_WS_8= RULE_WS )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_WS) ) {
                    int LA13_2 = input.LA(2);

                    if ( (synpred19_InternalCPreprocessParser()) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // InternalCPreprocessParser.g:666:2: this_WS_8= RULE_WS
            	    {
            	    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_8, grammarAccess.getDefineFunctionLikeMacroAccess().getWSTerminalRuleCall_8()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            // InternalCPreprocessParser.g:670:3: ( (lv_string_9_0= ruleMyDefineLine ) )
            // InternalCPreprocessParser.g:671:1: (lv_string_9_0= ruleMyDefineLine )
            {
            // InternalCPreprocessParser.g:671:1: (lv_string_9_0= ruleMyDefineLine )
            // InternalCPreprocessParser.g:672:3: lv_string_9_0= ruleMyDefineLine
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDefineFunctionLikeMacroAccess().getStringMyDefineLineParserRuleCall_9_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_string_9_0=ruleMyDefineLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDefineFunctionLikeMacroRule());
              	        }
                     		set(
                     			current, 
                     			"string",
                      		lv_string_9_0, 
                      		"at.jku.weiner.cpreprocess.CPreprocess.MyDefineLine");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleDefineFunctionLikeMacro"


    // $ANTLR start "entryRuleIdentifierList"
    // InternalCPreprocessParser.g:696:1: entryRuleIdentifierList returns [EObject current=null] : iv_ruleIdentifierList= ruleIdentifierList EOF ;
    public final EObject entryRuleIdentifierList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierList = null;


        try {
            // InternalCPreprocessParser.g:697:2: (iv_ruleIdentifierList= ruleIdentifierList EOF )
            // InternalCPreprocessParser.g:698:2: iv_ruleIdentifierList= ruleIdentifierList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIdentifierList=ruleIdentifierList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifierList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIdentifierList"


    // $ANTLR start "ruleIdentifierList"
    // InternalCPreprocessParser.g:705:1: ruleIdentifierList returns [EObject current=null] : ( () ( (lv_id_1_0= RULE_ID ) ) (this_COMMA_2= RULE_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )* ) ;
    public final EObject ruleIdentifierList() throws RecognitionException {
        EObject current = null;

        Token lv_id_1_0=null;
        Token this_COMMA_2=null;
        Token this_WS_3=null;
        Token lv_id_4_0=null;

         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:708:28: ( ( () ( (lv_id_1_0= RULE_ID ) ) (this_COMMA_2= RULE_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )* ) )
            // InternalCPreprocessParser.g:709:1: ( () ( (lv_id_1_0= RULE_ID ) ) (this_COMMA_2= RULE_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )* )
            {
            // InternalCPreprocessParser.g:709:1: ( () ( (lv_id_1_0= RULE_ID ) ) (this_COMMA_2= RULE_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )* )
            // InternalCPreprocessParser.g:709:2: () ( (lv_id_1_0= RULE_ID ) ) (this_COMMA_2= RULE_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )*
            {
            // InternalCPreprocessParser.g:709:2: ()
            // InternalCPreprocessParser.g:710:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getIdentifierListAccess().getIdentifierListAction_0(),
                          current);
                  
            }

            }

            // InternalCPreprocessParser.g:718:2: ( (lv_id_1_0= RULE_ID ) )
            // InternalCPreprocessParser.g:719:1: (lv_id_1_0= RULE_ID )
            {
            // InternalCPreprocessParser.g:719:1: (lv_id_1_0= RULE_ID )
            // InternalCPreprocessParser.g:720:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_id_1_0, grammarAccess.getIdentifierListAccess().getIdIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIdentifierListRule());
              	        }
                     		addWithLastConsumed(
                     			current, 
                     			"id",
                      		lv_id_1_0, 
                      		"at.jku.weiner.cpreprocess.CPreprocess.ID");
              	    
            }

            }


            }

            // InternalCPreprocessParser.g:736:2: (this_COMMA_2= RULE_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_COMMA) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalCPreprocessParser.g:736:3: this_COMMA_2= RULE_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) )
            	    {
            	    this_COMMA_2=(Token)match(input,RULE_COMMA,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_COMMA_2, grammarAccess.getIdentifierListAccess().getCOMMATerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalCPreprocessParser.g:740:1: (this_WS_3= RULE_WS )*
            	    loop14:
            	    do {
            	        int alt14=2;
            	        int LA14_0 = input.LA(1);

            	        if ( (LA14_0==RULE_WS) ) {
            	            alt14=1;
            	        }


            	        switch (alt14) {
            	    	case 1 :
            	    	    // InternalCPreprocessParser.g:740:2: this_WS_3= RULE_WS
            	    	    {
            	    	    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_WS_3, grammarAccess.getIdentifierListAccess().getWSTerminalRuleCall_2_1()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop14;
            	        }
            	    } while (true);

            	    // InternalCPreprocessParser.g:744:3: ( (lv_id_4_0= RULE_ID ) )
            	    // InternalCPreprocessParser.g:745:1: (lv_id_4_0= RULE_ID )
            	    {
            	    // InternalCPreprocessParser.g:745:1: (lv_id_4_0= RULE_ID )
            	    // InternalCPreprocessParser.g:746:3: lv_id_4_0= RULE_ID
            	    {
            	    lv_id_4_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_id_4_0, grammarAccess.getIdentifierListAccess().getIdIDTerminalRuleCall_2_2_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getIdentifierListRule());
            	      	        }
            	             		addWithLastConsumed(
            	             			current, 
            	             			"id",
            	              		lv_id_4_0, 
            	              		"at.jku.weiner.cpreprocess.CPreprocess.ID");
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleIdentifierList"


    // $ANTLR start "entryRuleErrorDirective"
    // InternalCPreprocessParser.g:770:1: entryRuleErrorDirective returns [EObject current=null] : iv_ruleErrorDirective= ruleErrorDirective EOF ;
    public final EObject entryRuleErrorDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorDirective = null;


        try {
            // InternalCPreprocessParser.g:771:2: (iv_ruleErrorDirective= ruleErrorDirective EOF )
            // InternalCPreprocessParser.g:772:2: iv_ruleErrorDirective= ruleErrorDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleErrorDirective=ruleErrorDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCPreprocessParser.g:779:1: ruleErrorDirective returns [EObject current=null] : ( () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleErrorDirective() throws RecognitionException {
        EObject current = null;

        Token this_ERROR_1=null;
        Token this_WS_2=null;
        AntlrDatatypeRuleToken lv_msg_3_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:782:28: ( ( () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) ) )
            // InternalCPreprocessParser.g:783:1: ( () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) )
            {
            // InternalCPreprocessParser.g:783:1: ( () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) )
            // InternalCPreprocessParser.g:783:2: () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) )
            {
            // InternalCPreprocessParser.g:783:2: ()
            // InternalCPreprocessParser.g:784:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getErrorDirectiveAccess().getErrorDirectiveAction_0(),
                          current);
                  
            }

            }

            this_ERROR_1=(Token)match(input,RULE_ERROR,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ERROR_1, grammarAccess.getErrorDirectiveAccess().getERRORTerminalRuleCall_1()); 
                  
            }
            // InternalCPreprocessParser.g:796:1: (this_WS_2= RULE_WS )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_WS) ) {
                    int LA16_2 = input.LA(2);

                    if ( (synpred22_InternalCPreprocessParser()) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // InternalCPreprocessParser.g:796:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_2, grammarAccess.getErrorDirectiveAccess().getWSTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            // InternalCPreprocessParser.g:800:3: ( (lv_msg_3_0= ruleMyCodeLine ) )
            // InternalCPreprocessParser.g:801:1: (lv_msg_3_0= ruleMyCodeLine )
            {
            // InternalCPreprocessParser.g:801:1: (lv_msg_3_0= ruleMyCodeLine )
            // InternalCPreprocessParser.g:802:3: lv_msg_3_0= ruleMyCodeLine
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getErrorDirectiveAccess().getMsgMyCodeLineParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_msg_3_0=ruleMyCodeLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleErrorDirective"


    // $ANTLR start "entryRuleUnDefineDirective"
    // InternalCPreprocessParser.g:826:1: entryRuleUnDefineDirective returns [EObject current=null] : iv_ruleUnDefineDirective= ruleUnDefineDirective EOF ;
    public final EObject entryRuleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnDefineDirective = null;


        try {
            // InternalCPreprocessParser.g:827:2: (iv_ruleUnDefineDirective= ruleUnDefineDirective EOF )
            // InternalCPreprocessParser.g:828:2: iv_ruleUnDefineDirective= ruleUnDefineDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnDefineDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnDefineDirective=ruleUnDefineDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnDefineDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCPreprocessParser.g:835:1: ruleUnDefineDirective returns [EObject current=null] : ( () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ) ;
    public final EObject ruleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        Token this_UNDEF_1=null;
        Token this_WS_2=null;
        Token lv_id_3_0=null;

         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:838:28: ( ( () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ) )
            // InternalCPreprocessParser.g:839:1: ( () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) )
            {
            // InternalCPreprocessParser.g:839:1: ( () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) )
            // InternalCPreprocessParser.g:839:2: () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) )
            {
            // InternalCPreprocessParser.g:839:2: ()
            // InternalCPreprocessParser.g:840:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnDefineDirectiveAccess().getUnDefineDirectiveAction_0(),
                          current);
                  
            }

            }

            this_UNDEF_1=(Token)match(input,RULE_UNDEF,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_UNDEF_1, grammarAccess.getUnDefineDirectiveAccess().getUNDEFTerminalRuleCall_1()); 
                  
            }
            // InternalCPreprocessParser.g:852:1: (this_WS_2= RULE_WS )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_WS) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalCPreprocessParser.g:852:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_2, grammarAccess.getUnDefineDirectiveAccess().getWSTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);

            // InternalCPreprocessParser.g:856:3: ( (lv_id_3_0= RULE_ID ) )
            // InternalCPreprocessParser.g:857:1: (lv_id_3_0= RULE_ID )
            {
            // InternalCPreprocessParser.g:857:1: (lv_id_3_0= RULE_ID )
            // InternalCPreprocessParser.g:858:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_id_3_0, grammarAccess.getUnDefineDirectiveAccess().getIdIDTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleUnDefineDirective"


    // $ANTLR start "entryRulePragmaDirective"
    // InternalCPreprocessParser.g:882:1: entryRulePragmaDirective returns [EObject current=null] : iv_rulePragmaDirective= rulePragmaDirective EOF ;
    public final EObject entryRulePragmaDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePragmaDirective = null;


        try {
            // InternalCPreprocessParser.g:883:2: (iv_rulePragmaDirective= rulePragmaDirective EOF )
            // InternalCPreprocessParser.g:884:2: iv_rulePragmaDirective= rulePragmaDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPragmaDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePragmaDirective=rulePragmaDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePragmaDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCPreprocessParser.g:891:1: rulePragmaDirective returns [EObject current=null] : ( () this_PRAGMA_1= RULE_PRAGMA ) ;
    public final EObject rulePragmaDirective() throws RecognitionException {
        EObject current = null;

        Token this_PRAGMA_1=null;

         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:894:28: ( ( () this_PRAGMA_1= RULE_PRAGMA ) )
            // InternalCPreprocessParser.g:895:1: ( () this_PRAGMA_1= RULE_PRAGMA )
            {
            // InternalCPreprocessParser.g:895:1: ( () this_PRAGMA_1= RULE_PRAGMA )
            // InternalCPreprocessParser.g:895:2: () this_PRAGMA_1= RULE_PRAGMA
            {
            // InternalCPreprocessParser.g:895:2: ()
            // InternalCPreprocessParser.g:896:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPragmaDirectiveAccess().getPragmaDirectiveAction_0(),
                          current);
                  
            }

            }

            this_PRAGMA_1=(Token)match(input,RULE_PRAGMA,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_PRAGMA_1, grammarAccess.getPragmaDirectiveAccess().getPRAGMATerminalRuleCall_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePragmaDirective"


    // $ANTLR start "entryRuleNullDirective"
    // InternalCPreprocessParser.g:916:1: entryRuleNullDirective returns [EObject current=null] : iv_ruleNullDirective= ruleNullDirective EOF ;
    public final EObject entryRuleNullDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullDirective = null;


        try {
            // InternalCPreprocessParser.g:917:2: (iv_ruleNullDirective= ruleNullDirective EOF )
            // InternalCPreprocessParser.g:918:2: iv_ruleNullDirective= ruleNullDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNullDirective=ruleNullDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNullDirective"


    // $ANTLR start "ruleNullDirective"
    // InternalCPreprocessParser.g:925:1: ruleNullDirective returns [EObject current=null] : () ;
    public final EObject ruleNullDirective() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:928:28: ( () )
            // InternalCPreprocessParser.g:929:1: ()
            {
            // InternalCPreprocessParser.g:929:1: ()
            // InternalCPreprocessParser.g:930:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getNullDirectiveAccess().getNullDirectiveAction(),
                          current);
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNullDirective"


    // $ANTLR start "entryRuleNewLineLine"
    // InternalCPreprocessParser.g:946:1: entryRuleNewLineLine returns [EObject current=null] : iv_ruleNewLineLine= ruleNewLineLine EOF ;
    public final EObject entryRuleNewLineLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewLineLine = null;


        try {
            // InternalCPreprocessParser.g:947:2: (iv_ruleNewLineLine= ruleNewLineLine EOF )
            // InternalCPreprocessParser.g:948:2: iv_ruleNewLineLine= ruleNewLineLine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNewLineLineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNewLineLine=ruleNewLineLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNewLineLine; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCPreprocessParser.g:955:1: ruleNewLineLine returns [EObject current=null] : ( () this_NEWLINE_1= RULE_NEWLINE ) ;
    public final EObject ruleNewLineLine() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_1=null;

         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:958:28: ( ( () this_NEWLINE_1= RULE_NEWLINE ) )
            // InternalCPreprocessParser.g:959:1: ( () this_NEWLINE_1= RULE_NEWLINE )
            {
            // InternalCPreprocessParser.g:959:1: ( () this_NEWLINE_1= RULE_NEWLINE )
            // InternalCPreprocessParser.g:959:2: () this_NEWLINE_1= RULE_NEWLINE
            {
            // InternalCPreprocessParser.g:959:2: ()
            // InternalCPreprocessParser.g:960:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getNewLineLineAccess().getNewLineLineAction_0(),
                          current);
                  
            }

            }

            this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_1, grammarAccess.getNewLineLineAccess().getNEWLINETerminalRuleCall_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleNewLineLine"


    // $ANTLR start "entryRuleCode"
    // InternalCPreprocessParser.g:980:1: entryRuleCode returns [EObject current=null] : iv_ruleCode= ruleCode EOF ;
    public final EObject entryRuleCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCode = null;


        try {
            // InternalCPreprocessParser.g:981:2: (iv_ruleCode= ruleCode EOF )
            // InternalCPreprocessParser.g:982:2: iv_ruleCode= ruleCode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCodeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCode=ruleCode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCPreprocessParser.g:989:1: ruleCode returns [EObject current=null] : ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE ) ;
    public final EObject ruleCode() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_2=null;
        AntlrDatatypeRuleToken lv_code_1_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:992:28: ( ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE ) )
            // InternalCPreprocessParser.g:993:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE )
            {
            // InternalCPreprocessParser.g:993:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE )
            // InternalCPreprocessParser.g:993:2: () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE
            {
            // InternalCPreprocessParser.g:993:2: ()
            // InternalCPreprocessParser.g:994:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getCodeAccess().getCodeAction_0(),
                          current);
                  
            }

            }

            // InternalCPreprocessParser.g:1002:2: ( (lv_code_1_0= ruleMyCodeLineExtended ) )
            // InternalCPreprocessParser.g:1003:1: (lv_code_1_0= ruleMyCodeLineExtended )
            {
            // InternalCPreprocessParser.g:1003:1: (lv_code_1_0= ruleMyCodeLineExtended )
            // InternalCPreprocessParser.g:1004:3: lv_code_1_0= ruleMyCodeLineExtended
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCodeAccess().getCodeMyCodeLineExtendedParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_6);
            lv_code_1_0=ruleMyCodeLineExtended();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_2, grammarAccess.getCodeAccess().getNEWLINETerminalRuleCall_2()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleCode"


    // $ANTLR start "entryRuleMyCode"
    // InternalCPreprocessParser.g:1032:1: entryRuleMyCode returns [String current=null] : iv_ruleMyCode= ruleMyCode EOF ;
    public final String entryRuleMyCode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCode = null;


        try {
            // InternalCPreprocessParser.g:1033:1: (iv_ruleMyCode= ruleMyCode EOF )
            // InternalCPreprocessParser.g:1034:2: iv_ruleMyCode= ruleMyCode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMyCodeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMyCode=ruleMyCode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMyCode.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCPreprocessParser.g:1041:1: ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_LPAREN_6= RULE_LPAREN | this_RPAREN_7= RULE_RPAREN | this_COMMA_8= RULE_COMMA ) ;
    public final AntlrDatatypeRuleToken ruleMyCode() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_SPECIAL_1=null;
        Token this_INCLUDE_2=null;
        Token this_DEFINE_3=null;
        Token this_ERROR_4=null;
        Token this_PRAGMA_5=null;
        Token this_LPAREN_6=null;
        Token this_RPAREN_7=null;
        Token this_COMMA_8=null;

         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:1045:6: ( (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_LPAREN_6= RULE_LPAREN | this_RPAREN_7= RULE_RPAREN | this_COMMA_8= RULE_COMMA ) )
            // InternalCPreprocessParser.g:1046:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_LPAREN_6= RULE_LPAREN | this_RPAREN_7= RULE_RPAREN | this_COMMA_8= RULE_COMMA )
            {
            // InternalCPreprocessParser.g:1046:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_LPAREN_6= RULE_LPAREN | this_RPAREN_7= RULE_RPAREN | this_COMMA_8= RULE_COMMA )
            int alt18=9;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt18=1;
                }
                break;
            case RULE_SPECIAL:
                {
                alt18=2;
                }
                break;
            case RULE_INCLUDE:
                {
                alt18=3;
                }
                break;
            case RULE_DEFINE:
                {
                alt18=4;
                }
                break;
            case RULE_ERROR:
                {
                alt18=5;
                }
                break;
            case RULE_PRAGMA:
                {
                alt18=6;
                }
                break;
            case RULE_LPAREN:
                {
                alt18=7;
                }
                break;
            case RULE_RPAREN:
                {
                alt18=8;
                }
                break;
            case RULE_COMMA:
                {
                alt18=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalCPreprocessParser.g:1046:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getMyCodeAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalCPreprocessParser.g:1054:10: this_SPECIAL_1= RULE_SPECIAL
                    {
                    this_SPECIAL_1=(Token)match(input,RULE_SPECIAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SPECIAL_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SPECIAL_1, grammarAccess.getMyCodeAccess().getSPECIALTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalCPreprocessParser.g:1062:10: this_INCLUDE_2= RULE_INCLUDE
                    {
                    this_INCLUDE_2=(Token)match(input,RULE_INCLUDE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INCLUDE_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INCLUDE_2, grammarAccess.getMyCodeAccess().getINCLUDETerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalCPreprocessParser.g:1070:10: this_DEFINE_3= RULE_DEFINE
                    {
                    this_DEFINE_3=(Token)match(input,RULE_DEFINE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DEFINE_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DEFINE_3, grammarAccess.getMyCodeAccess().getDEFINETerminalRuleCall_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalCPreprocessParser.g:1078:10: this_ERROR_4= RULE_ERROR
                    {
                    this_ERROR_4=(Token)match(input,RULE_ERROR,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ERROR_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ERROR_4, grammarAccess.getMyCodeAccess().getERRORTerminalRuleCall_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalCPreprocessParser.g:1086:10: this_PRAGMA_5= RULE_PRAGMA
                    {
                    this_PRAGMA_5=(Token)match(input,RULE_PRAGMA,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_PRAGMA_5);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_PRAGMA_5, grammarAccess.getMyCodeAccess().getPRAGMATerminalRuleCall_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalCPreprocessParser.g:1094:10: this_LPAREN_6= RULE_LPAREN
                    {
                    this_LPAREN_6=(Token)match(input,RULE_LPAREN,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_LPAREN_6);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LPAREN_6, grammarAccess.getMyCodeAccess().getLPARENTerminalRuleCall_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalCPreprocessParser.g:1102:10: this_RPAREN_7= RULE_RPAREN
                    {
                    this_RPAREN_7=(Token)match(input,RULE_RPAREN,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_RPAREN_7);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPAREN_7, grammarAccess.getMyCodeAccess().getRPARENTerminalRuleCall_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalCPreprocessParser.g:1110:10: this_COMMA_8= RULE_COMMA
                    {
                    this_COMMA_8=(Token)match(input,RULE_COMMA,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_COMMA_8);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_COMMA_8, grammarAccess.getMyCodeAccess().getCOMMATerminalRuleCall_8()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
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
    // $ANTLR end "ruleMyCode"


    // $ANTLR start "entryRuleMyDefineLine"
    // InternalCPreprocessParser.g:1125:1: entryRuleMyDefineLine returns [String current=null] : iv_ruleMyDefineLine= ruleMyDefineLine EOF ;
    public final String entryRuleMyDefineLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyDefineLine = null;


        try {
            // InternalCPreprocessParser.g:1126:1: (iv_ruleMyDefineLine= ruleMyDefineLine EOF )
            // InternalCPreprocessParser.g:1127:2: iv_ruleMyDefineLine= ruleMyDefineLine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMyDefineLineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMyDefineLine=ruleMyDefineLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMyDefineLine.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCPreprocessParser.g:1134:1: ruleMyDefineLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )* ;
    public final AntlrDatatypeRuleToken ruleMyDefineLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_1=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:1138:6: ( (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )* )
            // InternalCPreprocessParser.g:1139:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )*
            {
            // InternalCPreprocessParser.g:1139:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )*
            loop19:
            do {
                int alt19=3;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=RULE_INCLUDE && LA19_0<=RULE_ERROR)||(LA19_0>=RULE_PRAGMA && LA19_0<=RULE_COMMA)||LA19_0==RULE_ID||LA19_0==RULE_SPECIAL) ) {
                    alt19=1;
                }
                else if ( (LA19_0==RULE_WS) ) {
                    alt19=2;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalCPreprocessParser.g:1140:5: this_MyCode_0= ruleMyCode
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMyDefineLineAccess().getMyCodeParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_15);
            	    this_MyCode_0=ruleMyCode();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_MyCode_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;
            	case 2 :
            	    // InternalCPreprocessParser.g:1151:10: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_15); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WS_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_1, grammarAccess.getMyDefineLineAccess().getWSTerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
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
    // $ANTLR end "ruleMyDefineLine"


    // $ANTLR start "entryRuleMyCodeLine"
    // InternalCPreprocessParser.g:1166:1: entryRuleMyCodeLine returns [String current=null] : iv_ruleMyCodeLine= ruleMyCodeLine EOF ;
    public final String entryRuleMyCodeLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLine = null;


        try {
            // InternalCPreprocessParser.g:1167:1: (iv_ruleMyCodeLine= ruleMyCodeLine EOF )
            // InternalCPreprocessParser.g:1168:2: iv_ruleMyCodeLine= ruleMyCodeLine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMyCodeLineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMyCodeLine=ruleMyCodeLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMyCodeLine.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCPreprocessParser.g:1175:1: ruleMyCodeLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+ ;
    public final AntlrDatatypeRuleToken ruleMyCodeLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_1=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:1179:6: ( (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+ )
            // InternalCPreprocessParser.g:1180:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+
            {
            // InternalCPreprocessParser.g:1180:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+
            int cnt20=0;
            loop20:
            do {
                int alt20=3;
                alt20 = dfa20.predict(input);
                switch (alt20) {
            	case 1 :
            	    // InternalCPreprocessParser.g:1181:5: this_MyCode_0= ruleMyCode
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMyCodeLineAccess().getMyCodeParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_15);
            	    this_MyCode_0=ruleMyCode();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_MyCode_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;
            	case 2 :
            	    // InternalCPreprocessParser.g:1192:10: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_15); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WS_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_1, grammarAccess.getMyCodeLineAccess().getWSTerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
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
    // $ANTLR end "ruleMyCodeLine"


    // $ANTLR start "entryRuleMyCodeLineExtended"
    // InternalCPreprocessParser.g:1207:1: entryRuleMyCodeLineExtended returns [String current=null] : iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF ;
    public final String entryRuleMyCodeLineExtended() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtended = null;


        try {
            // InternalCPreprocessParser.g:1208:1: (iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF )
            // InternalCPreprocessParser.g:1209:2: iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMyCodeLineExtendedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMyCodeLineExtended=ruleMyCodeLineExtended();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMyCodeLineExtended.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCPreprocessParser.g:1216:1: ruleMyCodeLineExtended returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? ) ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtended() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_0=null;
        Token this_HASH_3=null;
        AntlrDatatypeRuleToken this_MyCode_1 = null;

        AntlrDatatypeRuleToken this_MyCodeLine_2 = null;


         enterRule(); 
            
        try {
            // InternalCPreprocessParser.g:1220:6: ( ( (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? ) )
            // InternalCPreprocessParser.g:1221:1: ( (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? )
            {
            // InternalCPreprocessParser.g:1221:1: ( (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? )
            // InternalCPreprocessParser.g:1221:2: (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )?
            {
            // InternalCPreprocessParser.g:1221:2: (this_WS_0= RULE_WS )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_WS) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalCPreprocessParser.g:1221:7: this_WS_0= RULE_WS
            	    {
            	    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_15); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WS_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_0, grammarAccess.getMyCodeLineExtendedAccess().getWSTerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // InternalCPreprocessParser.g:1228:3: (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_INCLUDE && LA23_0<=RULE_ERROR)||(LA23_0>=RULE_PRAGMA && LA23_0<=RULE_COMMA)||LA23_0==RULE_ID||LA23_0==RULE_SPECIAL) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalCPreprocessParser.g:1229:5: this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeLineExtendedAccess().getMyCodeParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_16);
                    this_MyCode_1=ruleMyCode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_MyCode_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalCPreprocessParser.g:1239:1: (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
                    loop22:
                    do {
                        int alt22=3;
                        int LA22_0 = input.LA(1);

                        if ( ((LA22_0>=RULE_INCLUDE && LA22_0<=RULE_ERROR)||(LA22_0>=RULE_PRAGMA && LA22_0<=RULE_COMMA)||(LA22_0>=RULE_WS && LA22_0<=RULE_ID)||LA22_0==RULE_SPECIAL) ) {
                            alt22=1;
                        }
                        else if ( (LA22_0==RULE_HASH) ) {
                            alt22=2;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalCPreprocessParser.g:1240:5: this_MyCodeLine_2= ruleMyCodeLine
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	              newCompositeNode(grammarAccess.getMyCodeLineExtendedAccess().getMyCodeLineParserRuleCall_1_1_0()); 
                    	          
                    	    }
                    	    pushFollow(FOLLOW_16);
                    	    this_MyCodeLine_2=ruleMyCodeLine();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_MyCodeLine_2);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	              afterParserOrEnumRuleCall();
                    	          
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalCPreprocessParser.g:1251:10: this_HASH_3= RULE_HASH
                    	    {
                    	    this_HASH_3=(Token)match(input,RULE_HASH,FOLLOW_16); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_HASH_3);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_HASH_3, grammarAccess.getMyCodeLineExtendedAccess().getHASHTerminalRuleCall_1_1_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
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
    // $ANTLR end "ruleMyCodeLineExtended"

    // $ANTLR start synpred2_InternalCPreprocessParser
    public final void synpred2_InternalCPreprocessParser_fragment() throws RecognitionException {   
        EObject lv_lines_2_0 = null;


        // InternalCPreprocessParser.g:204:6: ( ( (lv_lines_2_0= ruleNewLineLine ) ) )
        // InternalCPreprocessParser.g:204:6: ( (lv_lines_2_0= ruleNewLineLine ) )
        {
        // InternalCPreprocessParser.g:204:6: ( (lv_lines_2_0= ruleNewLineLine ) )
        // InternalCPreprocessParser.g:205:1: (lv_lines_2_0= ruleNewLineLine )
        {
        // InternalCPreprocessParser.g:205:1: (lv_lines_2_0= ruleNewLineLine )
        // InternalCPreprocessParser.g:206:3: lv_lines_2_0= ruleNewLineLine
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getGroupOptAccess().getLinesNewLineLineParserRuleCall_1_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_lines_2_0=ruleNewLineLine();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred2_InternalCPreprocessParser

    // $ANTLR start synpred3_InternalCPreprocessParser
    public final void synpred3_InternalCPreprocessParser_fragment() throws RecognitionException {   
        EObject lv_lines_3_0 = null;


        // InternalCPreprocessParser.g:223:6: ( ( (lv_lines_3_0= ruleCode ) ) )
        // InternalCPreprocessParser.g:223:6: ( (lv_lines_3_0= ruleCode ) )
        {
        // InternalCPreprocessParser.g:223:6: ( (lv_lines_3_0= ruleCode ) )
        // InternalCPreprocessParser.g:224:1: (lv_lines_3_0= ruleCode )
        {
        // InternalCPreprocessParser.g:224:1: (lv_lines_3_0= ruleCode )
        // InternalCPreprocessParser.g:225:3: lv_lines_3_0= ruleCode
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getGroupOptAccess().getLinesCodeParserRuleCall_1_2_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_lines_3_0=ruleCode();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred3_InternalCPreprocessParser

    // $ANTLR start synpred11_InternalCPreprocessParser
    public final void synpred11_InternalCPreprocessParser_fragment() throws RecognitionException {   
        Token this_WS_2=null;

        // InternalCPreprocessParser.g:434:2: (this_WS_2= RULE_WS )
        // InternalCPreprocessParser.g:434:2: this_WS_2= RULE_WS
        {
        this_WS_2=(Token)match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_InternalCPreprocessParser

    // $ANTLR start synpred14_InternalCPreprocessParser
    public final void synpred14_InternalCPreprocessParser_fragment() throws RecognitionException {   
        Token this_WS_4=null;

        // InternalCPreprocessParser.g:558:4: (this_WS_4= RULE_WS )
        // InternalCPreprocessParser.g:558:4: this_WS_4= RULE_WS
        {
        this_WS_4=(Token)match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalCPreprocessParser

    // $ANTLR start synpred19_InternalCPreprocessParser
    public final void synpred19_InternalCPreprocessParser_fragment() throws RecognitionException {   
        Token this_WS_8=null;

        // InternalCPreprocessParser.g:666:2: (this_WS_8= RULE_WS )
        // InternalCPreprocessParser.g:666:2: this_WS_8= RULE_WS
        {
        this_WS_8=(Token)match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_InternalCPreprocessParser

    // $ANTLR start synpred22_InternalCPreprocessParser
    public final void synpred22_InternalCPreprocessParser_fragment() throws RecognitionException {   
        Token this_WS_2=null;

        // InternalCPreprocessParser.g:796:2: (this_WS_2= RULE_WS )
        // InternalCPreprocessParser.g:796:2: this_WS_2= RULE_WS
        {
        this_WS_2=(Token)match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_InternalCPreprocessParser

    // $ANTLR start synpred34_InternalCPreprocessParser
    public final void synpred34_InternalCPreprocessParser_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_MyCode_0 = null;


        // InternalCPreprocessParser.g:1181:5: (this_MyCode_0= ruleMyCode )
        // InternalCPreprocessParser.g:1181:5: this_MyCode_0= ruleMyCode
        {
        if ( state.backtracking==0 ) {
           
                  newCompositeNode(grammarAccess.getMyCodeLineAccess().getMyCodeParserRuleCall_0()); 
              
        }
        pushFollow(FOLLOW_2);
        this_MyCode_0=ruleMyCode();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_InternalCPreprocessParser

    // $ANTLR start synpred35_InternalCPreprocessParser
    public final void synpred35_InternalCPreprocessParser_fragment() throws RecognitionException {   
        Token this_WS_1=null;

        // InternalCPreprocessParser.g:1192:10: (this_WS_1= RULE_WS )
        // InternalCPreprocessParser.g:1192:10: this_WS_1= RULE_WS
        {
        this_WS_1=(Token)match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_InternalCPreprocessParser

    // Delegated rules

    public final boolean synpred34_InternalCPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalCPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalCPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalCPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalCPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalCPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalCPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalCPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalCPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalCPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalCPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalCPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalCPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalCPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalCPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalCPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA1_eotS =
        "\7\uffff";
    static final String DFA1_eofS =
        "\1\1\6\uffff";
    static final String DFA1_minS =
        "\1\4\1\uffff\1\4\1\uffff\1\0\2\uffff";
    static final String DFA1_maxS =
        "\1\34\1\uffff\1\34\1\uffff\1\0\2\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\4\1\uffff\1\1\1\uffff\1\3\1\2";
    static final String DFA1_specialS =
        "\4\uffff\1\0\2\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\3\3\5\1\uffff\4\5\2\uffff\1\4\4\uffff\1\2\1\5\6\uffff\1\5",
            "",
            "\1\3\3\5\1\uffff\4\5\2\uffff\1\5\4\uffff\1\2\1\5\6\uffff\1\5",
            "",
            "\1\uffff",
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
            return "()* loopback of 185:2: ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA1_4 = input.LA(1);

                         
                        int index1_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalCPreprocessParser()) ) {s = 6;}

                        else if ( (synpred3_InternalCPreprocessParser()) ) {s = 5;}

                         
                        input.seek(index1_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 1, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA6_eotS =
        "\6\uffff";
    static final String DFA6_eofS =
        "\3\uffff\1\5\2\uffff";
    static final String DFA6_minS =
        "\1\6\2\24\1\12\2\uffff";
    static final String DFA6_maxS =
        "\1\6\1\24\1\25\1\24\2\uffff";
    static final String DFA6_acceptS =
        "\4\uffff\1\2\1\1";
    static final String DFA6_specialS =
        "\6\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1",
            "\1\2",
            "\1\2\1\3",
            "\1\4\4\uffff\1\5\4\uffff\1\5",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "477:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )";
        }
    }
    static final String DFA20_eotS =
        "\16\uffff";
    static final String DFA20_eofS =
        "\1\1\15\uffff";
    static final String DFA20_minS =
        "\1\4\1\uffff\12\0\2\uffff";
    static final String DFA20_maxS =
        "\1\34\1\uffff\12\0\2\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\3\12\uffff\1\1\1\2";
    static final String DFA20_specialS =
        "\2\uffff\1\11\1\0\1\2\1\7\1\3\1\10\1\6\1\5\1\1\1\4\2\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\1\1\4\1\5\1\6\1\uffff\1\7\1\10\1\11\1\12\2\uffff\1\1\4\uffff\1\13\1\2\6\uffff\1\3",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1180:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_3 = input.LA(1);

                         
                        int index20_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalCPreprocessParser()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA20_10 = input.LA(1);

                         
                        int index20_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalCPreprocessParser()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_10);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA20_4 = input.LA(1);

                         
                        int index20_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalCPreprocessParser()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA20_6 = input.LA(1);

                         
                        int index20_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalCPreprocessParser()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA20_11 = input.LA(1);

                         
                        int index20_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalCPreprocessParser()) ) {s = 13;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_11);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA20_9 = input.LA(1);

                         
                        int index20_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalCPreprocessParser()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA20_8 = input.LA(1);

                         
                        int index20_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalCPreprocessParser()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA20_5 = input.LA(1);

                         
                        int index20_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalCPreprocessParser()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_5);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA20_7 = input.LA(1);

                         
                        int index20_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalCPreprocessParser()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_7);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA20_2 = input.LA(1);

                         
                        int index20_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalCPreprocessParser()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000010309EF2L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000001083E0L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000010301EE0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000300800L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000010301EE2L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000010301EF2L});

}