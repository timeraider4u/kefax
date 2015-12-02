package at.jku.weiner.c.preprocess.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import at.jku.weiner.c.preprocess.services.PreprocessGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalPreprocessParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_HASH", "RULE_INCLUDE", "RULE_DEFINE", "RULE_ERROR", "RULE_UNDEF", "RULE_IF", "RULE_DEFINED", "RULE_IFDEF", "RULE_IFNOTDEF", "RULE_ELIF", "RULE_ELSE", "RULE_ENDIF", "RULE_PRAGMA", "RULE_LINEFEED", "RULE_CARRIAGERETURN", "RULE_NEWLINE", "RULE_LINEBREAK", "RULE_SPACE", "RULE_TAB", "RULE_WS", "RULE_ID", "RULE_IDENTIFIER", "RULE_LETTER", "RULE_CHAR_LITERAL", "RULE_STRING_LITERAL", "RULE_HEX_LITERAL", "RULE_DECIMAL_LITERAL", "RULE_OCTAL_LITERAL", "RULE_BIN_LITERAL", "RULE_HEX_DIGIT", "RULE_INTEGER_TYPE_SUFFIX", "RULE_FLOAT_LITERAL", "RULE_EXPONENT", "RULE_FLOAT_TYPE_SUFFIX", "RULE_ESCAPE_SEQUENCE", "RULE_OCTAL_ESCAPE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_SKW_AND", "RULE_SKW_ANDAND", "RULE_SKW_ASSIGN", "RULE_SKW_BACKSLASH", "RULE_SKW_CARET", "RULE_SKW_COMMA", "RULE_SKW_COLON", "RULE_SKW_DIV", "RULE_SKW_DOLLAR", "RULE_SKW_DOT", "RULE_SKW_DOUBLEQUOTE", "RULE_SKW_EQUAL", "RULE_SKW_GREATER", "RULE_SKW_GREATEREQUAL", "RULE_SKW_LEFTBRACE", "RULE_SKW_LEFTBRACKET", "RULE_SKW_LEFTPAREN", "RULE_SKW_LEFTSHIFT", "RULE_SKW_LESS", "RULE_SKW_LESSEQUAL", "RULE_SKW_MINUS", "RULE_SKW_MINUSMINUS", "RULE_SKW_MOD", "RULE_SKW_NOT", "RULE_SKW_NOTEQUAL", "RULE_SKW_OR", "RULE_SKW_OROR", "RULE_SKW_PLUS", "RULE_SKW_PLUSPLUS", "RULE_SKW_QUESTION", "RULE_SKW_RIGHTBRACE", "RULE_SKW_RIGHTBRACKET", "RULE_SKW_RIGHTPAREN", "RULE_SKW_RIGHTSHIFT", "RULE_SKW_SEMI", "RULE_SKW_SINGLEQUOTE", "RULE_SKW_STAR", "RULE_SKW_TILDE", "RULE_SKW_UNDERSCORE", "RULE_SPECIAL", "RULE_HASHRULE_ENDIF"
    };
    public static final int RULE_PRAGMA=16;
    public static final int RULE_ID=24;
    public static final int RULE_OCTAL_ESCAPE=39;
    public static final int RULE_SKW_NOT=65;
    public static final int RULE_SKW_RIGHTSHIFT=75;
    public static final int RULE_ESCAPE_SEQUENCE=38;
    public static final int RULE_HASHRULE_ENDIF=82;
    public static final int RULE_SKW_DOT=51;
    public static final int RULE_DEFINED=10;
    public static final int RULE_SKW_PLUS=69;
    public static final int RULE_SKW_NOTEQUAL=66;
    public static final int RULE_SKW_GREATEREQUAL=55;
    public static final int RULE_SKW_RIGHTBRACE=72;
    public static final int EOF=-1;
    public static final int RULE_SKW_LESS=60;
    public static final int RULE_SKW_RIGHTPAREN=74;
    public static final int RULE_SKW_STAR=78;
    public static final int RULE_ENDIF=15;
    public static final int RULE_STRING_LITERAL=28;
    public static final int RULE_LINEBREAK=20;
    public static final int RULE_SKW_PLUSPLUS=70;
    public static final int RULE_SKW_LESSEQUAL=61;
    public static final int RULE_SKW_DOUBLEQUOTE=52;
    public static final int RULE_DECIMAL_LITERAL=30;
    public static final int RULE_HEX_LITERAL=29;
    public static final int RULE_SKW_OROR=68;
    public static final int RULE_SKW_AND=42;
    public static final int RULE_SKW_CARET=46;
    public static final int RULE_OCTAL_LITERAL=31;
    public static final int RULE_SKW_COMMA=47;
    public static final int RULE_SKW_RIGHTBRACKET=73;
    public static final int RULE_SPACE=21;
    public static final int RULE_BLOCK_COMMENT=40;
    public static final int RULE_LINEFEED=17;
    public static final int RULE_SKW_COLON=48;
    public static final int RULE_SKW_LEFTPAREN=58;
    public static final int RULE_BIN_LITERAL=32;
    public static final int RULE_SKW_MINUS=62;
    public static final int RULE_SKW_SEMI=76;
    public static final int RULE_IFDEF=11;
    public static final int RULE_NEWLINE=19;
    public static final int RULE_SKW_DOLLAR=50;
    public static final int RULE_SKW_EQUAL=53;
    public static final int RULE_SKW_LEFTSHIFT=59;
    public static final int RULE_SKW_QUESTION=71;
    public static final int RULE_SKW_DIV=49;
    public static final int RULE_SKW_ANDAND=43;
    public static final int RULE_ERROR=7;
    public static final int RULE_SKW_GREATER=54;
    public static final int RULE_HEX_DIGIT=33;
    public static final int RULE_HASH=4;
    public static final int RULE_IDENTIFIER=25;
    public static final int RULE_TAB=22;
    public static final int RULE_SKW_LEFTBRACKET=57;
    public static final int RULE_SKW_SINGLEQUOTE=77;
    public static final int RULE_UNDEF=8;
    public static final int RULE_SKW_MOD=64;
    public static final int RULE_LETTER=26;
    public static final int RULE_SKW_MINUSMINUS=63;
    public static final int RULE_FLOAT_TYPE_SUFFIX=37;
    public static final int RULE_IFNOTDEF=12;
    public static final int RULE_EXPONENT=36;
    public static final int RULE_DEFINE=6;
    public static final int RULE_INTEGER_TYPE_SUFFIX=34;
    public static final int RULE_SPECIAL=81;
    public static final int RULE_CARRIAGERETURN=18;
    public static final int RULE_SKW_TILDE=79;
    public static final int RULE_LINE_COMMENT=41;
    public static final int RULE_INCLUDE=5;
    public static final int RULE_SKW_UNDERSCORE=80;
    public static final int RULE_SKW_OR=67;
    public static final int RULE_SKW_BACKSLASH=45;
    public static final int RULE_ELIF=13;
    public static final int RULE_CHAR_LITERAL=27;
    public static final int RULE_WS=23;
    public static final int RULE_IF=9;
    public static final int RULE_SKW_LEFTBRACE=56;
    public static final int RULE_FLOAT_LITERAL=35;
    public static final int RULE_ELSE=14;
    public static final int RULE_SKW_ASSIGN=44;

    // delegates
    // delegators


        public InternalPreprocessParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPreprocessParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPreprocessParser.tokenNames; }
    public String getGrammarFileName() { return "InternalPreprocessParser.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     

    	private PreprocessGrammarAccess grammarAccess;
    	 	
    	public InternalPreprocessParser(TokenStream input, PreprocessGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "Model";	
    	} 
    	   	   	
    	@Override
    	protected PreprocessGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalPreprocessParser.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalPreprocessParser.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalPreprocessParser.g:69:2: iv_ruleModel= ruleModel EOF
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
    // InternalPreprocessParser.g:76:1: ruleModel returns [EObject current=null] : ( () ( (lv_units_1_0= ruleTranslationUnit ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_units_1_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:79:28: ( ( () ( (lv_units_1_0= ruleTranslationUnit ) ) ) )
            // InternalPreprocessParser.g:80:1: ( () ( (lv_units_1_0= ruleTranslationUnit ) ) )
            {
            // InternalPreprocessParser.g:80:1: ( () ( (lv_units_1_0= ruleTranslationUnit ) ) )
            // InternalPreprocessParser.g:80:2: () ( (lv_units_1_0= ruleTranslationUnit ) )
            {
            // InternalPreprocessParser.g:80:2: ()
            // InternalPreprocessParser.g:81:2: 
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

            // InternalPreprocessParser.g:89:2: ( (lv_units_1_0= ruleTranslationUnit ) )
            // InternalPreprocessParser.g:90:1: (lv_units_1_0= ruleTranslationUnit )
            {
            // InternalPreprocessParser.g:90:1: (lv_units_1_0= ruleTranslationUnit )
            // InternalPreprocessParser.g:91:3: lv_units_1_0= ruleTranslationUnit
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
                      		"at.jku.weiner.c.preprocess.Preprocess.TranslationUnit");
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
    // InternalPreprocessParser.g:115:1: entryRuleTranslationUnit returns [EObject current=null] : iv_ruleTranslationUnit= ruleTranslationUnit EOF ;
    public final EObject entryRuleTranslationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTranslationUnit = null;


        try {
            // InternalPreprocessParser.g:116:2: (iv_ruleTranslationUnit= ruleTranslationUnit EOF )
            // InternalPreprocessParser.g:117:2: iv_ruleTranslationUnit= ruleTranslationUnit EOF
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
    // InternalPreprocessParser.g:124:1: ruleTranslationUnit returns [EObject current=null] : ( () ( (lv_group_1_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleTranslationUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_group_1_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:127:28: ( ( () ( (lv_group_1_0= ruleGroupOpt ) ) ) )
            // InternalPreprocessParser.g:128:1: ( () ( (lv_group_1_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocessParser.g:128:1: ( () ( (lv_group_1_0= ruleGroupOpt ) ) )
            // InternalPreprocessParser.g:128:2: () ( (lv_group_1_0= ruleGroupOpt ) )
            {
            // InternalPreprocessParser.g:128:2: ()
            // InternalPreprocessParser.g:129:2: 
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

            // InternalPreprocessParser.g:137:2: ( (lv_group_1_0= ruleGroupOpt ) )
            // InternalPreprocessParser.g:138:1: (lv_group_1_0= ruleGroupOpt )
            {
            // InternalPreprocessParser.g:138:1: (lv_group_1_0= ruleGroupOpt )
            // InternalPreprocessParser.g:139:3: lv_group_1_0= ruleGroupOpt
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
                      		"at.jku.weiner.c.preprocess.Preprocess.GroupOpt");
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
    // InternalPreprocessParser.g:163:1: entryRuleGroupOpt returns [EObject current=null] : iv_ruleGroupOpt= ruleGroupOpt EOF ;
    public final EObject entryRuleGroupOpt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOpt = null;


        try {
            // InternalPreprocessParser.g:164:2: (iv_ruleGroupOpt= ruleGroupOpt EOF )
            // InternalPreprocessParser.g:165:2: iv_ruleGroupOpt= ruleGroupOpt EOF
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
    // InternalPreprocessParser.g:172:1: ruleGroupOpt returns [EObject current=null] : ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* ) ;
    public final EObject ruleGroupOpt() throws RecognitionException {
        EObject current = null;

        EObject lv_lines_1_0 = null;

        EObject lv_lines_2_0 = null;

        EObject lv_lines_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:175:28: ( ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* ) )
            // InternalPreprocessParser.g:176:1: ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* )
            {
            // InternalPreprocessParser.g:176:1: ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* )
            // InternalPreprocessParser.g:176:2: () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )*
            {
            // InternalPreprocessParser.g:176:2: ()
            // InternalPreprocessParser.g:177:2: 
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

            // InternalPreprocessParser.g:185:2: ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )*
            loop1:
            do {
                int alt1=4;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // InternalPreprocessParser.g:185:3: ( (lv_lines_1_0= rulePreprocessorDirectives ) )
            	    {
            	    // InternalPreprocessParser.g:185:3: ( (lv_lines_1_0= rulePreprocessorDirectives ) )
            	    // InternalPreprocessParser.g:186:1: (lv_lines_1_0= rulePreprocessorDirectives )
            	    {
            	    // InternalPreprocessParser.g:186:1: (lv_lines_1_0= rulePreprocessorDirectives )
            	    // InternalPreprocessParser.g:187:3: lv_lines_1_0= rulePreprocessorDirectives
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
            	              		"at.jku.weiner.c.preprocess.Preprocess.PreprocessorDirectives");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalPreprocessParser.g:204:6: ( (lv_lines_2_0= ruleNewLineLine ) )
            	    {
            	    // InternalPreprocessParser.g:204:6: ( (lv_lines_2_0= ruleNewLineLine ) )
            	    // InternalPreprocessParser.g:205:1: (lv_lines_2_0= ruleNewLineLine )
            	    {
            	    // InternalPreprocessParser.g:205:1: (lv_lines_2_0= ruleNewLineLine )
            	    // InternalPreprocessParser.g:206:3: lv_lines_2_0= ruleNewLineLine
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
            	              		"at.jku.weiner.c.preprocess.Preprocess.NewLineLine");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalPreprocessParser.g:223:6: ( (lv_lines_3_0= ruleCode ) )
            	    {
            	    // InternalPreprocessParser.g:223:6: ( (lv_lines_3_0= ruleCode ) )
            	    // InternalPreprocessParser.g:224:1: (lv_lines_3_0= ruleCode )
            	    {
            	    // InternalPreprocessParser.g:224:1: (lv_lines_3_0= ruleCode )
            	    // InternalPreprocessParser.g:225:3: lv_lines_3_0= ruleCode
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
            	              		"at.jku.weiner.c.preprocess.Preprocess.Code");
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
    // InternalPreprocessParser.g:249:1: entryRulePreprocessorDirectives returns [EObject current=null] : iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF ;
    public final EObject entryRulePreprocessorDirectives() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreprocessorDirectives = null;


        try {
            // InternalPreprocessParser.g:250:2: (iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF )
            // InternalPreprocessParser.g:251:2: iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF
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
    // InternalPreprocessParser.g:258:1: rulePreprocessorDirectives returns [EObject current=null] : ( () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= ruleConditionalDirective ) ) | ( (lv_directive_9_0= rulePragmaDirective ) ) | ( (lv_directive_10_0= ruleNullDirective ) ) ) this_NEWLINE_11= RULE_NEWLINE ) ;
    public final EObject rulePreprocessorDirectives() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token this_HASH_2=null;
        Token this_WS_3=null;
        Token this_NEWLINE_11=null;
        EObject lv_directive_4_0 = null;

        EObject lv_directive_5_0 = null;

        EObject lv_directive_6_0 = null;

        EObject lv_directive_7_0 = null;

        EObject lv_directive_8_0 = null;

        EObject lv_directive_9_0 = null;

        EObject lv_directive_10_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:261:28: ( ( () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= ruleConditionalDirective ) ) | ( (lv_directive_9_0= rulePragmaDirective ) ) | ( (lv_directive_10_0= ruleNullDirective ) ) ) this_NEWLINE_11= RULE_NEWLINE ) )
            // InternalPreprocessParser.g:262:1: ( () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= ruleConditionalDirective ) ) | ( (lv_directive_9_0= rulePragmaDirective ) ) | ( (lv_directive_10_0= ruleNullDirective ) ) ) this_NEWLINE_11= RULE_NEWLINE )
            {
            // InternalPreprocessParser.g:262:1: ( () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= ruleConditionalDirective ) ) | ( (lv_directive_9_0= rulePragmaDirective ) ) | ( (lv_directive_10_0= ruleNullDirective ) ) ) this_NEWLINE_11= RULE_NEWLINE )
            // InternalPreprocessParser.g:262:2: () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= ruleConditionalDirective ) ) | ( (lv_directive_9_0= rulePragmaDirective ) ) | ( (lv_directive_10_0= ruleNullDirective ) ) ) this_NEWLINE_11= RULE_NEWLINE
            {
            // InternalPreprocessParser.g:262:2: ()
            // InternalPreprocessParser.g:263:2: 
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

            // InternalPreprocessParser.g:271:2: (this_WS_1= RULE_WS )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_WS) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalPreprocessParser.g:271:3: this_WS_1= RULE_WS
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
            // InternalPreprocessParser.g:279:1: (this_WS_3= RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalPreprocessParser.g:279:2: this_WS_3= RULE_WS
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

            // InternalPreprocessParser.g:283:3: ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= ruleConditionalDirective ) ) | ( (lv_directive_9_0= rulePragmaDirective ) ) | ( (lv_directive_10_0= ruleNullDirective ) ) )
            int alt4=7;
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
            case RULE_IF:
            case RULE_IFDEF:
            case RULE_IFNOTDEF:
                {
                alt4=5;
                }
                break;
            case RULE_PRAGMA:
                {
                alt4=6;
                }
                break;
            case EOF:
            case RULE_NEWLINE:
                {
                alt4=7;
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
                    // InternalPreprocessParser.g:283:4: ( (lv_directive_4_0= ruleIncludeDirective ) )
                    {
                    // InternalPreprocessParser.g:283:4: ( (lv_directive_4_0= ruleIncludeDirective ) )
                    // InternalPreprocessParser.g:284:1: (lv_directive_4_0= ruleIncludeDirective )
                    {
                    // InternalPreprocessParser.g:284:1: (lv_directive_4_0= ruleIncludeDirective )
                    // InternalPreprocessParser.g:285:3: lv_directive_4_0= ruleIncludeDirective
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
                              		"at.jku.weiner.c.preprocess.Preprocess.IncludeDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPreprocessParser.g:302:6: ( (lv_directive_5_0= ruleDefineDirective ) )
                    {
                    // InternalPreprocessParser.g:302:6: ( (lv_directive_5_0= ruleDefineDirective ) )
                    // InternalPreprocessParser.g:303:1: (lv_directive_5_0= ruleDefineDirective )
                    {
                    // InternalPreprocessParser.g:303:1: (lv_directive_5_0= ruleDefineDirective )
                    // InternalPreprocessParser.g:304:3: lv_directive_5_0= ruleDefineDirective
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
                              		"at.jku.weiner.c.preprocess.Preprocess.DefineDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalPreprocessParser.g:321:6: ( (lv_directive_6_0= ruleErrorDirective ) )
                    {
                    // InternalPreprocessParser.g:321:6: ( (lv_directive_6_0= ruleErrorDirective ) )
                    // InternalPreprocessParser.g:322:1: (lv_directive_6_0= ruleErrorDirective )
                    {
                    // InternalPreprocessParser.g:322:1: (lv_directive_6_0= ruleErrorDirective )
                    // InternalPreprocessParser.g:323:3: lv_directive_6_0= ruleErrorDirective
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
                              		"at.jku.weiner.c.preprocess.Preprocess.ErrorDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalPreprocessParser.g:340:6: ( (lv_directive_7_0= ruleUnDefineDirective ) )
                    {
                    // InternalPreprocessParser.g:340:6: ( (lv_directive_7_0= ruleUnDefineDirective ) )
                    // InternalPreprocessParser.g:341:1: (lv_directive_7_0= ruleUnDefineDirective )
                    {
                    // InternalPreprocessParser.g:341:1: (lv_directive_7_0= ruleUnDefineDirective )
                    // InternalPreprocessParser.g:342:3: lv_directive_7_0= ruleUnDefineDirective
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
                              		"at.jku.weiner.c.preprocess.Preprocess.UnDefineDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalPreprocessParser.g:359:6: ( (lv_directive_8_0= ruleConditionalDirective ) )
                    {
                    // InternalPreprocessParser.g:359:6: ( (lv_directive_8_0= ruleConditionalDirective ) )
                    // InternalPreprocessParser.g:360:1: (lv_directive_8_0= ruleConditionalDirective )
                    {
                    // InternalPreprocessParser.g:360:1: (lv_directive_8_0= ruleConditionalDirective )
                    // InternalPreprocessParser.g:361:3: lv_directive_8_0= ruleConditionalDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveConditionalDirectiveParserRuleCall_4_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
                    lv_directive_8_0=ruleConditionalDirective();

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
                              		"at.jku.weiner.c.preprocess.Preprocess.ConditionalDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalPreprocessParser.g:378:6: ( (lv_directive_9_0= rulePragmaDirective ) )
                    {
                    // InternalPreprocessParser.g:378:6: ( (lv_directive_9_0= rulePragmaDirective ) )
                    // InternalPreprocessParser.g:379:1: (lv_directive_9_0= rulePragmaDirective )
                    {
                    // InternalPreprocessParser.g:379:1: (lv_directive_9_0= rulePragmaDirective )
                    // InternalPreprocessParser.g:380:3: lv_directive_9_0= rulePragmaDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectivePragmaDirectiveParserRuleCall_4_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
                    lv_directive_9_0=rulePragmaDirective();

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
                              		"at.jku.weiner.c.preprocess.Preprocess.PragmaDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalPreprocessParser.g:397:6: ( (lv_directive_10_0= ruleNullDirective ) )
                    {
                    // InternalPreprocessParser.g:397:6: ( (lv_directive_10_0= ruleNullDirective ) )
                    // InternalPreprocessParser.g:398:1: (lv_directive_10_0= ruleNullDirective )
                    {
                    // InternalPreprocessParser.g:398:1: (lv_directive_10_0= ruleNullDirective )
                    // InternalPreprocessParser.g:399:3: lv_directive_10_0= ruleNullDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveNullDirectiveParserRuleCall_4_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
                    lv_directive_10_0=ruleNullDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
                      	        }
                             		set(
                             			current, 
                             			"directive",
                              		lv_directive_10_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.NullDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            this_NEWLINE_11=(Token)match(input,RULE_NEWLINE,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_11, grammarAccess.getPreprocessorDirectivesAccess().getNEWLINETerminalRuleCall_5()); 
                  
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
    // InternalPreprocessParser.g:427:1: entryRuleIncludeDirective returns [EObject current=null] : iv_ruleIncludeDirective= ruleIncludeDirective EOF ;
    public final EObject entryRuleIncludeDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDirective = null;


        try {
            // InternalPreprocessParser.g:428:2: (iv_ruleIncludeDirective= ruleIncludeDirective EOF )
            // InternalPreprocessParser.g:429:2: iv_ruleIncludeDirective= ruleIncludeDirective EOF
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
    // InternalPreprocessParser.g:436:1: ruleIncludeDirective returns [EObject current=null] : ( () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleIncludeDirective() throws RecognitionException {
        EObject current = null;

        Token this_INCLUDE_1=null;
        Token this_WS_2=null;
        AntlrDatatypeRuleToken lv_string_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:439:28: ( ( () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) ) ) )
            // InternalPreprocessParser.g:440:1: ( () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) ) )
            {
            // InternalPreprocessParser.g:440:1: ( () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) ) )
            // InternalPreprocessParser.g:440:2: () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) )
            {
            // InternalPreprocessParser.g:440:2: ()
            // InternalPreprocessParser.g:441:2: 
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
            // InternalPreprocessParser.g:453:1: (this_WS_2= RULE_WS )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_WS) ) {
                    int LA5_2 = input.LA(2);

                    if ( (synpred12_InternalPreprocessParser()) ) {
                        alt5=1;
                    }


                }


                switch (alt5) {
            	case 1 :
            	    // InternalPreprocessParser.g:453:2: this_WS_2= RULE_WS
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

            // InternalPreprocessParser.g:457:3: ( (lv_string_3_0= ruleMyCodeLine ) )
            // InternalPreprocessParser.g:458:1: (lv_string_3_0= ruleMyCodeLine )
            {
            // InternalPreprocessParser.g:458:1: (lv_string_3_0= ruleMyCodeLine )
            // InternalPreprocessParser.g:459:3: lv_string_3_0= ruleMyCodeLine
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
                      		"at.jku.weiner.c.preprocess.Preprocess.MyCodeLine");
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
    // InternalPreprocessParser.g:483:1: entryRuleDefineDirective returns [EObject current=null] : iv_ruleDefineDirective= ruleDefineDirective EOF ;
    public final EObject entryRuleDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineDirective = null;


        try {
            // InternalPreprocessParser.g:484:2: (iv_ruleDefineDirective= ruleDefineDirective EOF )
            // InternalPreprocessParser.g:485:2: iv_ruleDefineDirective= ruleDefineDirective EOF
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
    // InternalPreprocessParser.g:492:1: ruleDefineDirective returns [EObject current=null] : (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro ) ;
    public final EObject ruleDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject this_DefineObjectMacro_0 = null;

        EObject this_DefineFunctionLikeMacro_1 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:495:28: ( (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro ) )
            // InternalPreprocessParser.g:496:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )
            {
            // InternalPreprocessParser.g:496:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalPreprocessParser.g:497:2: this_DefineObjectMacro_0= ruleDefineObjectMacro
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
                    // InternalPreprocessParser.g:510:2: this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro
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
    // InternalPreprocessParser.g:529:1: entryRuleDefineObjectMacro returns [EObject current=null] : iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF ;
    public final EObject entryRuleDefineObjectMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineObjectMacro = null;


        try {
            // InternalPreprocessParser.g:530:2: (iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF )
            // InternalPreprocessParser.g:531:2: iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF
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
    // InternalPreprocessParser.g:538:1: ruleDefineObjectMacro returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? ) ;
    public final EObject ruleDefineObjectMacro() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_1=null;
        Token this_WS_2=null;
        Token lv_id_3_0=null;
        Token this_WS_4=null;
        AntlrDatatypeRuleToken lv_string_5_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:541:28: ( ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? ) )
            // InternalPreprocessParser.g:542:1: ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? )
            {
            // InternalPreprocessParser.g:542:1: ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? )
            // InternalPreprocessParser.g:542:2: () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )?
            {
            // InternalPreprocessParser.g:542:2: ()
            // InternalPreprocessParser.g:543:2: 
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
            // InternalPreprocessParser.g:555:1: (this_WS_2= RULE_WS )+
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
            	    // InternalPreprocessParser.g:555:2: this_WS_2= RULE_WS
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

            // InternalPreprocessParser.g:559:3: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocessParser.g:560:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocessParser.g:560:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocessParser.g:561:3: lv_id_3_0= RULE_ID
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
                      		"at.jku.weiner.c.preprocess.Preprocess.ID");
              	    
            }

            }


            }

            // InternalPreprocessParser.g:577:2: ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_WS) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalPreprocessParser.g:577:3: (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) )
                    {
                    // InternalPreprocessParser.g:577:3: (this_WS_4= RULE_WS )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_WS) ) {
                            int LA8_2 = input.LA(2);

                            if ( (synpred15_InternalPreprocessParser()) ) {
                                alt8=1;
                            }


                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalPreprocessParser.g:577:4: this_WS_4= RULE_WS
                    	    {
                    	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
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

                    // InternalPreprocessParser.g:581:3: ( (lv_string_5_0= ruleMyDefineLine ) )
                    // InternalPreprocessParser.g:582:1: (lv_string_5_0= ruleMyDefineLine )
                    {
                    // InternalPreprocessParser.g:582:1: (lv_string_5_0= ruleMyDefineLine )
                    // InternalPreprocessParser.g:583:3: lv_string_5_0= ruleMyDefineLine
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
                              		"at.jku.weiner.c.preprocess.Preprocess.MyDefineLine");
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
    // InternalPreprocessParser.g:607:1: entryRuleDefineFunctionLikeMacro returns [EObject current=null] : iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF ;
    public final EObject entryRuleDefineFunctionLikeMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineFunctionLikeMacro = null;


        try {
            // InternalPreprocessParser.g:608:2: (iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF )
            // InternalPreprocessParser.g:609:2: iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF
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
    // InternalPreprocessParser.g:616:1: ruleDefineFunctionLikeMacro returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WS_5= RULE_WS )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WS_8= RULE_WS )+ ( (lv_string_9_0= ruleMyDefineLine ) ) ) ;
    public final EObject ruleDefineFunctionLikeMacro() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_1=null;
        Token this_WS_2=null;
        Token lv_id_3_0=null;
        Token this_SKW_LEFTPAREN_4=null;
        Token this_WS_5=null;
        Token this_SKW_RIGHTPAREN_7=null;
        Token this_WS_8=null;
        EObject lv_list_6_0 = null;

        AntlrDatatypeRuleToken lv_string_9_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:619:28: ( ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WS_5= RULE_WS )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WS_8= RULE_WS )+ ( (lv_string_9_0= ruleMyDefineLine ) ) ) )
            // InternalPreprocessParser.g:620:1: ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WS_5= RULE_WS )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WS_8= RULE_WS )+ ( (lv_string_9_0= ruleMyDefineLine ) ) )
            {
            // InternalPreprocessParser.g:620:1: ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WS_5= RULE_WS )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WS_8= RULE_WS )+ ( (lv_string_9_0= ruleMyDefineLine ) ) )
            // InternalPreprocessParser.g:620:2: () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WS_5= RULE_WS )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WS_8= RULE_WS )+ ( (lv_string_9_0= ruleMyDefineLine ) )
            {
            // InternalPreprocessParser.g:620:2: ()
            // InternalPreprocessParser.g:621:2: 
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
            // InternalPreprocessParser.g:633:1: (this_WS_2= RULE_WS )+
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
            	    // InternalPreprocessParser.g:633:2: this_WS_2= RULE_WS
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

            // InternalPreprocessParser.g:637:3: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocessParser.g:638:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocessParser.g:638:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocessParser.g:639:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_12); if (state.failed) return current;
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
                      		"at.jku.weiner.c.preprocess.Preprocess.ID");
              	    
            }

            }


            }

            this_SKW_LEFTPAREN_4=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SKW_LEFTPAREN_4, grammarAccess.getDefineFunctionLikeMacroAccess().getSKW_LEFTPARENTerminalRuleCall_4()); 
                  
            }
            // InternalPreprocessParser.g:659:1: (this_WS_5= RULE_WS )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_WS) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalPreprocessParser.g:659:2: this_WS_5= RULE_WS
            	    {
            	    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_5, grammarAccess.getDefineFunctionLikeMacroAccess().getWSTerminalRuleCall_5()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalPreprocessParser.g:663:3: ( (lv_list_6_0= ruleIdentifierList ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalPreprocessParser.g:664:1: (lv_list_6_0= ruleIdentifierList )
                    {
                    // InternalPreprocessParser.g:664:1: (lv_list_6_0= ruleIdentifierList )
                    // InternalPreprocessParser.g:665:3: lv_list_6_0= ruleIdentifierList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefineFunctionLikeMacroAccess().getListIdentifierListParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_14);
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
                              		"at.jku.weiner.c.preprocess.Preprocess.IdentifierList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            this_SKW_RIGHTPAREN_7=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SKW_RIGHTPAREN_7, grammarAccess.getDefineFunctionLikeMacroAccess().getSKW_RIGHTPARENTerminalRuleCall_7()); 
                  
            }
            // InternalPreprocessParser.g:685:1: (this_WS_8= RULE_WS )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_WS) ) {
                    int LA13_2 = input.LA(2);

                    if ( (synpred20_InternalPreprocessParser()) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // InternalPreprocessParser.g:685:2: this_WS_8= RULE_WS
            	    {
            	    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
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

            // InternalPreprocessParser.g:689:3: ( (lv_string_9_0= ruleMyDefineLine ) )
            // InternalPreprocessParser.g:690:1: (lv_string_9_0= ruleMyDefineLine )
            {
            // InternalPreprocessParser.g:690:1: (lv_string_9_0= ruleMyDefineLine )
            // InternalPreprocessParser.g:691:3: lv_string_9_0= ruleMyDefineLine
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
                      		"at.jku.weiner.c.preprocess.Preprocess.MyDefineLine");
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
    // InternalPreprocessParser.g:715:1: entryRuleIdentifierList returns [EObject current=null] : iv_ruleIdentifierList= ruleIdentifierList EOF ;
    public final EObject entryRuleIdentifierList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierList = null;


        try {
            // InternalPreprocessParser.g:716:2: (iv_ruleIdentifierList= ruleIdentifierList EOF )
            // InternalPreprocessParser.g:717:2: iv_ruleIdentifierList= ruleIdentifierList EOF
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
    // InternalPreprocessParser.g:724:1: ruleIdentifierList returns [EObject current=null] : ( () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )* ) ;
    public final EObject ruleIdentifierList() throws RecognitionException {
        EObject current = null;

        Token lv_id_1_0=null;
        Token this_SKW_COMMA_2=null;
        Token this_WS_3=null;
        Token lv_id_4_0=null;

         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:727:28: ( ( () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )* ) )
            // InternalPreprocessParser.g:728:1: ( () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )* )
            {
            // InternalPreprocessParser.g:728:1: ( () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )* )
            // InternalPreprocessParser.g:728:2: () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )*
            {
            // InternalPreprocessParser.g:728:2: ()
            // InternalPreprocessParser.g:729:2: 
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

            // InternalPreprocessParser.g:737:2: ( (lv_id_1_0= RULE_ID ) )
            // InternalPreprocessParser.g:738:1: (lv_id_1_0= RULE_ID )
            {
            // InternalPreprocessParser.g:738:1: (lv_id_1_0= RULE_ID )
            // InternalPreprocessParser.g:739:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FOLLOW_15); if (state.failed) return current;
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
                      		"at.jku.weiner.c.preprocess.Preprocess.ID");
              	    
            }

            }


            }

            // InternalPreprocessParser.g:755:2: (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_SKW_COMMA) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalPreprocessParser.g:755:3: this_SKW_COMMA_2= RULE_SKW_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) )
            	    {
            	    this_SKW_COMMA_2=(Token)match(input,RULE_SKW_COMMA,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_COMMA_2, grammarAccess.getIdentifierListAccess().getSKW_COMMATerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocessParser.g:759:1: (this_WS_3= RULE_WS )*
            	    loop14:
            	    do {
            	        int alt14=2;
            	        int LA14_0 = input.LA(1);

            	        if ( (LA14_0==RULE_WS) ) {
            	            alt14=1;
            	        }


            	        switch (alt14) {
            	    	case 1 :
            	    	    // InternalPreprocessParser.g:759:2: this_WS_3= RULE_WS
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

            	    // InternalPreprocessParser.g:763:3: ( (lv_id_4_0= RULE_ID ) )
            	    // InternalPreprocessParser.g:764:1: (lv_id_4_0= RULE_ID )
            	    {
            	    // InternalPreprocessParser.g:764:1: (lv_id_4_0= RULE_ID )
            	    // InternalPreprocessParser.g:765:3: lv_id_4_0= RULE_ID
            	    {
            	    lv_id_4_0=(Token)match(input,RULE_ID,FOLLOW_15); if (state.failed) return current;
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
            	              		"at.jku.weiner.c.preprocess.Preprocess.ID");
            	      	    
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
    // InternalPreprocessParser.g:789:1: entryRuleErrorDirective returns [EObject current=null] : iv_ruleErrorDirective= ruleErrorDirective EOF ;
    public final EObject entryRuleErrorDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorDirective = null;


        try {
            // InternalPreprocessParser.g:790:2: (iv_ruleErrorDirective= ruleErrorDirective EOF )
            // InternalPreprocessParser.g:791:2: iv_ruleErrorDirective= ruleErrorDirective EOF
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
    // InternalPreprocessParser.g:798:1: ruleErrorDirective returns [EObject current=null] : ( () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleErrorDirective() throws RecognitionException {
        EObject current = null;

        Token this_ERROR_1=null;
        Token this_WS_2=null;
        AntlrDatatypeRuleToken lv_msg_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:801:28: ( ( () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) ) )
            // InternalPreprocessParser.g:802:1: ( () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) )
            {
            // InternalPreprocessParser.g:802:1: ( () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) )
            // InternalPreprocessParser.g:802:2: () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) )
            {
            // InternalPreprocessParser.g:802:2: ()
            // InternalPreprocessParser.g:803:2: 
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
            // InternalPreprocessParser.g:815:1: (this_WS_2= RULE_WS )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_WS) ) {
                    int LA16_2 = input.LA(2);

                    if ( (synpred23_InternalPreprocessParser()) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // InternalPreprocessParser.g:815:2: this_WS_2= RULE_WS
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

            // InternalPreprocessParser.g:819:3: ( (lv_msg_3_0= ruleMyCodeLine ) )
            // InternalPreprocessParser.g:820:1: (lv_msg_3_0= ruleMyCodeLine )
            {
            // InternalPreprocessParser.g:820:1: (lv_msg_3_0= ruleMyCodeLine )
            // InternalPreprocessParser.g:821:3: lv_msg_3_0= ruleMyCodeLine
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
                      		"at.jku.weiner.c.preprocess.Preprocess.MyCodeLine");
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
    // InternalPreprocessParser.g:845:1: entryRuleUnDefineDirective returns [EObject current=null] : iv_ruleUnDefineDirective= ruleUnDefineDirective EOF ;
    public final EObject entryRuleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnDefineDirective = null;


        try {
            // InternalPreprocessParser.g:846:2: (iv_ruleUnDefineDirective= ruleUnDefineDirective EOF )
            // InternalPreprocessParser.g:847:2: iv_ruleUnDefineDirective= ruleUnDefineDirective EOF
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
    // InternalPreprocessParser.g:854:1: ruleUnDefineDirective returns [EObject current=null] : ( () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ) ;
    public final EObject ruleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        Token this_UNDEF_1=null;
        Token this_WS_2=null;
        Token lv_id_3_0=null;

         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:857:28: ( ( () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ) )
            // InternalPreprocessParser.g:858:1: ( () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) )
            {
            // InternalPreprocessParser.g:858:1: ( () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) )
            // InternalPreprocessParser.g:858:2: () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) )
            {
            // InternalPreprocessParser.g:858:2: ()
            // InternalPreprocessParser.g:859:2: 
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
            // InternalPreprocessParser.g:871:1: (this_WS_2= RULE_WS )+
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
            	    // InternalPreprocessParser.g:871:2: this_WS_2= RULE_WS
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

            // InternalPreprocessParser.g:875:3: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocessParser.g:876:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocessParser.g:876:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocessParser.g:877:3: lv_id_3_0= RULE_ID
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
                      		"at.jku.weiner.c.preprocess.Preprocess.ID");
              	    
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


    // $ANTLR start "entryRuleConditionalDirective"
    // InternalPreprocessParser.g:901:1: entryRuleConditionalDirective returns [EObject current=null] : iv_ruleConditionalDirective= ruleConditionalDirective EOF ;
    public final EObject entryRuleConditionalDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalDirective = null;


        try {
            // InternalPreprocessParser.g:902:2: (iv_ruleConditionalDirective= ruleConditionalDirective EOF )
            // InternalPreprocessParser.g:903:2: iv_ruleConditionalDirective= ruleConditionalDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConditionalDirective=ruleConditionalDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalDirective; 
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
    // $ANTLR end "entryRuleConditionalDirective"


    // $ANTLR start "ruleConditionalDirective"
    // InternalPreprocessParser.g:910:1: ruleConditionalDirective returns [EObject current=null] : ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? ( ( ( RULE_HASHRULE_ENDIF ) )=> (this_HASH_4= RULE_HASH this_ENDIF_5= RULE_ENDIF ) ) (this_WS_6= RULE_WS )* ) ;
    public final EObject ruleConditionalDirective() throws RecognitionException {
        EObject current = null;

        Token this_HASH_4=null;
        Token this_ENDIF_5=null;
        Token this_WS_6=null;
        EObject lv_conditional_1_1 = null;

        EObject lv_conditional_1_2 = null;

        EObject lv_conditional_1_3 = null;

        EObject lv_elifs_2_0 = null;

        EObject lv_else_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:913:28: ( ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? ( ( ( RULE_HASHRULE_ENDIF ) )=> (this_HASH_4= RULE_HASH this_ENDIF_5= RULE_ENDIF ) ) (this_WS_6= RULE_WS )* ) )
            // InternalPreprocessParser.g:914:1: ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? ( ( ( RULE_HASHRULE_ENDIF ) )=> (this_HASH_4= RULE_HASH this_ENDIF_5= RULE_ENDIF ) ) (this_WS_6= RULE_WS )* )
            {
            // InternalPreprocessParser.g:914:1: ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? ( ( ( RULE_HASHRULE_ENDIF ) )=> (this_HASH_4= RULE_HASH this_ENDIF_5= RULE_ENDIF ) ) (this_WS_6= RULE_WS )* )
            // InternalPreprocessParser.g:914:2: () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? ( ( ( RULE_HASHRULE_ENDIF ) )=> (this_HASH_4= RULE_HASH this_ENDIF_5= RULE_ENDIF ) ) (this_WS_6= RULE_WS )*
            {
            // InternalPreprocessParser.g:914:2: ()
            // InternalPreprocessParser.g:915:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getConditionalDirectiveAccess().getConditionalDirectiveAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:923:2: ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) )
            // InternalPreprocessParser.g:924:1: ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) )
            {
            // InternalPreprocessParser.g:924:1: ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) )
            // InternalPreprocessParser.g:925:1: (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional )
            {
            // InternalPreprocessParser.g:925:1: (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional )
            int alt18=3;
            switch ( input.LA(1) ) {
            case RULE_IF:
                {
                alt18=1;
                }
                break;
            case RULE_IFDEF:
                {
                alt18=2;
                }
                break;
            case RULE_IFNOTDEF:
                {
                alt18=3;
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
                    // InternalPreprocessParser.g:926:3: lv_conditional_1_1= ruleIfConditional
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalDirectiveAccess().getConditionalIfConditionalParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_16);
                    lv_conditional_1_1=ruleIfConditional();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConditionalDirectiveRule());
                      	        }
                             		set(
                             			current, 
                             			"conditional",
                              		lv_conditional_1_1, 
                              		"at.jku.weiner.c.preprocess.Preprocess.IfConditional");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // InternalPreprocessParser.g:941:8: lv_conditional_1_2= ruleIfDefConditional
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalDirectiveAccess().getConditionalIfDefConditionalParserRuleCall_1_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_16);
                    lv_conditional_1_2=ruleIfDefConditional();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConditionalDirectiveRule());
                      	        }
                             		set(
                             			current, 
                             			"conditional",
                              		lv_conditional_1_2, 
                              		"at.jku.weiner.c.preprocess.Preprocess.IfDefConditional");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 3 :
                    // InternalPreprocessParser.g:956:8: lv_conditional_1_3= ruleIfNotDefConditional
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalDirectiveAccess().getConditionalIfNotDefConditionalParserRuleCall_1_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_16);
                    lv_conditional_1_3=ruleIfNotDefConditional();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConditionalDirectiveRule());
                      	        }
                             		set(
                             			current, 
                             			"conditional",
                              		lv_conditional_1_3, 
                              		"at.jku.weiner.c.preprocess.Preprocess.IfNotDefConditional");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

            }


            }


            }

            // InternalPreprocessParser.g:974:2: ( (lv_elifs_2_0= ruleElIfConditional ) )*
            loop19:
            do {
                int alt19=2;
                alt19 = dfa19.predict(input);
                switch (alt19) {
            	case 1 :
            	    // InternalPreprocessParser.g:975:1: (lv_elifs_2_0= ruleElIfConditional )
            	    {
            	    // InternalPreprocessParser.g:975:1: (lv_elifs_2_0= ruleElIfConditional )
            	    // InternalPreprocessParser.g:976:3: lv_elifs_2_0= ruleElIfConditional
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConditionalDirectiveAccess().getElifsElIfConditionalParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_elifs_2_0=ruleElIfConditional();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getConditionalDirectiveRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elifs",
            	              		lv_elifs_2_0, 
            	              		"at.jku.weiner.c.preprocess.Preprocess.ElIfConditional");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            // InternalPreprocessParser.g:992:3: ( (lv_else_3_0= ruleElseConditional ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_HASH) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==RULE_ELSE||LA20_1==RULE_WS) ) {
                    alt20=1;
                }
            }
            switch (alt20) {
                case 1 :
                    // InternalPreprocessParser.g:993:1: (lv_else_3_0= ruleElseConditional )
                    {
                    // InternalPreprocessParser.g:993:1: (lv_else_3_0= ruleElseConditional )
                    // InternalPreprocessParser.g:994:3: lv_else_3_0= ruleElseConditional
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalDirectiveAccess().getElseElseConditionalParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_16);
                    lv_else_3_0=ruleElseConditional();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConditionalDirectiveRule());
                      	        }
                             		set(
                             			current, 
                             			"else",
                              		lv_else_3_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.ElseConditional");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalPreprocessParser.g:1010:3: ( ( ( RULE_HASHRULE_ENDIF ) )=> (this_HASH_4= RULE_HASH this_ENDIF_5= RULE_ENDIF ) )
            // InternalPreprocessParser.g:1010:4: ( ( RULE_HASHRULE_ENDIF ) )=> (this_HASH_4= RULE_HASH this_ENDIF_5= RULE_ENDIF )
            {
            // InternalPreprocessParser.g:1010:29: (this_HASH_4= RULE_HASH this_ENDIF_5= RULE_ENDIF )
            // InternalPreprocessParser.g:1010:30: this_HASH_4= RULE_HASH this_ENDIF_5= RULE_ENDIF
            {
            this_HASH_4=(Token)match(input,RULE_HASH,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_4, grammarAccess.getConditionalDirectiveAccess().getHASHTerminalRuleCall_4_0_0()); 
                  
            }
            this_ENDIF_5=(Token)match(input,RULE_ENDIF,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ENDIF_5, grammarAccess.getConditionalDirectiveAccess().getENDIFTerminalRuleCall_4_0_1()); 
                  
            }

            }


            }

            // InternalPreprocessParser.g:1018:3: (this_WS_6= RULE_WS )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_WS) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalPreprocessParser.g:1018:4: this_WS_6= RULE_WS
            	    {
            	    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_6, grammarAccess.getConditionalDirectiveAccess().getWSTerminalRuleCall_5()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // $ANTLR end "ruleConditionalDirective"


    // $ANTLR start "entryRuleIfConditional"
    // InternalPreprocessParser.g:1030:1: entryRuleIfConditional returns [EObject current=null] : iv_ruleIfConditional= ruleIfConditional EOF ;
    public final EObject entryRuleIfConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfConditional = null;


        try {
            // InternalPreprocessParser.g:1031:2: (iv_ruleIfConditional= ruleIfConditional EOF )
            // InternalPreprocessParser.g:1032:2: iv_ruleIfConditional= ruleIfConditional EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfConditionalRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfConditional=ruleIfConditional();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfConditional; 
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
    // $ANTLR end "entryRuleIfConditional"


    // $ANTLR start "ruleIfConditional"
    // InternalPreprocessParser.g:1039:1: ruleIfConditional returns [EObject current=null] : ( () this_IF_1= RULE_IF (this_WS_2= RULE_WS )+ ( (lv_expression_3_0= ruleShadowExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleIfConditional() throws RecognitionException {
        EObject current = null;

        Token this_IF_1=null;
        Token this_WS_2=null;
        Token this_NEWLINE_4=null;
        EObject lv_expression_3_0 = null;

        EObject lv_group_5_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1042:28: ( ( () this_IF_1= RULE_IF (this_WS_2= RULE_WS )+ ( (lv_expression_3_0= ruleShadowExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) )
            // InternalPreprocessParser.g:1043:1: ( () this_IF_1= RULE_IF (this_WS_2= RULE_WS )+ ( (lv_expression_3_0= ruleShadowExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocessParser.g:1043:1: ( () this_IF_1= RULE_IF (this_WS_2= RULE_WS )+ ( (lv_expression_3_0= ruleShadowExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            // InternalPreprocessParser.g:1043:2: () this_IF_1= RULE_IF (this_WS_2= RULE_WS )+ ( (lv_expression_3_0= ruleShadowExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) )
            {
            // InternalPreprocessParser.g:1043:2: ()
            // InternalPreprocessParser.g:1044:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getIfConditionalAccess().getIfConditionalAction_0(),
                          current);
                  
            }

            }

            this_IF_1=(Token)match(input,RULE_IF,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_IF_1, grammarAccess.getIfConditionalAccess().getIFTerminalRuleCall_1()); 
                  
            }
            // InternalPreprocessParser.g:1056:1: (this_WS_2= RULE_WS )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_WS) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalPreprocessParser.g:1056:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_2, grammarAccess.getIfConditionalAccess().getWSTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);

            // InternalPreprocessParser.g:1060:3: ( (lv_expression_3_0= ruleShadowExpression ) )
            // InternalPreprocessParser.g:1061:1: (lv_expression_3_0= ruleShadowExpression )
            {
            // InternalPreprocessParser.g:1061:1: (lv_expression_3_0= ruleShadowExpression )
            // InternalPreprocessParser.g:1062:3: lv_expression_3_0= ruleShadowExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfConditionalAccess().getExpressionShadowExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_6);
            lv_expression_3_0=ruleShadowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfConditionalRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_3_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.ShadowExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_4, grammarAccess.getIfConditionalAccess().getNEWLINETerminalRuleCall_4()); 
                  
            }
            // InternalPreprocessParser.g:1082:1: ( (lv_group_5_0= ruleGroupOpt ) )
            // InternalPreprocessParser.g:1083:1: (lv_group_5_0= ruleGroupOpt )
            {
            // InternalPreprocessParser.g:1083:1: (lv_group_5_0= ruleGroupOpt )
            // InternalPreprocessParser.g:1084:3: lv_group_5_0= ruleGroupOpt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfConditionalAccess().getGroupGroupOptParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_group_5_0=ruleGroupOpt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfConditionalRule());
              	        }
                     		set(
                     			current, 
                     			"group",
                      		lv_group_5_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.GroupOpt");
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
    // $ANTLR end "ruleIfConditional"


    // $ANTLR start "entryRuleIfDefConditional"
    // InternalPreprocessParser.g:1108:1: entryRuleIfDefConditional returns [EObject current=null] : iv_ruleIfDefConditional= ruleIfDefConditional EOF ;
    public final EObject entryRuleIfDefConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfDefConditional = null;


        try {
            // InternalPreprocessParser.g:1109:2: (iv_ruleIfDefConditional= ruleIfDefConditional EOF )
            // InternalPreprocessParser.g:1110:2: iv_ruleIfDefConditional= ruleIfDefConditional EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfDefConditionalRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfDefConditional=ruleIfDefConditional();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfDefConditional; 
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
    // $ANTLR end "entryRuleIfDefConditional"


    // $ANTLR start "ruleIfDefConditional"
    // InternalPreprocessParser.g:1117:1: ruleIfDefConditional returns [EObject current=null] : ( () this_IFDEF_1= RULE_IFDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleIfDefConditional() throws RecognitionException {
        EObject current = null;

        Token this_IFDEF_1=null;
        Token this_WS_2=null;
        Token lv_id_3_0=null;
        Token this_NEWLINE_4=null;
        EObject lv_group_5_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1120:28: ( ( () this_IFDEF_1= RULE_IFDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) )
            // InternalPreprocessParser.g:1121:1: ( () this_IFDEF_1= RULE_IFDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocessParser.g:1121:1: ( () this_IFDEF_1= RULE_IFDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            // InternalPreprocessParser.g:1121:2: () this_IFDEF_1= RULE_IFDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) )
            {
            // InternalPreprocessParser.g:1121:2: ()
            // InternalPreprocessParser.g:1122:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getIfDefConditionalAccess().getIfDefConditionalAction_0(),
                          current);
                  
            }

            }

            this_IFDEF_1=(Token)match(input,RULE_IFDEF,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_IFDEF_1, grammarAccess.getIfDefConditionalAccess().getIFDEFTerminalRuleCall_1()); 
                  
            }
            // InternalPreprocessParser.g:1134:1: (this_WS_2= RULE_WS )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_WS) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalPreprocessParser.g:1134:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_2, grammarAccess.getIfDefConditionalAccess().getWSTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);

            // InternalPreprocessParser.g:1138:3: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocessParser.g:1139:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocessParser.g:1139:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocessParser.g:1140:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_id_3_0, grammarAccess.getIfDefConditionalAccess().getIdIDTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIfDefConditionalRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"id",
                      		lv_id_3_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.ID");
              	    
            }

            }


            }

            this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_4, grammarAccess.getIfDefConditionalAccess().getNEWLINETerminalRuleCall_4()); 
                  
            }
            // InternalPreprocessParser.g:1160:1: ( (lv_group_5_0= ruleGroupOpt ) )
            // InternalPreprocessParser.g:1161:1: (lv_group_5_0= ruleGroupOpt )
            {
            // InternalPreprocessParser.g:1161:1: (lv_group_5_0= ruleGroupOpt )
            // InternalPreprocessParser.g:1162:3: lv_group_5_0= ruleGroupOpt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfDefConditionalAccess().getGroupGroupOptParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_group_5_0=ruleGroupOpt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfDefConditionalRule());
              	        }
                     		set(
                     			current, 
                     			"group",
                      		lv_group_5_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.GroupOpt");
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
    // $ANTLR end "ruleIfDefConditional"


    // $ANTLR start "entryRuleIfNotDefConditional"
    // InternalPreprocessParser.g:1186:1: entryRuleIfNotDefConditional returns [EObject current=null] : iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF ;
    public final EObject entryRuleIfNotDefConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfNotDefConditional = null;


        try {
            // InternalPreprocessParser.g:1187:2: (iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF )
            // InternalPreprocessParser.g:1188:2: iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfNotDefConditionalRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfNotDefConditional=ruleIfNotDefConditional();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfNotDefConditional; 
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
    // $ANTLR end "entryRuleIfNotDefConditional"


    // $ANTLR start "ruleIfNotDefConditional"
    // InternalPreprocessParser.g:1195:1: ruleIfNotDefConditional returns [EObject current=null] : ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleIfNotDefConditional() throws RecognitionException {
        EObject current = null;

        Token this_IFNOTDEF_1=null;
        Token this_WS_2=null;
        Token lv_id_3_0=null;
        Token this_NEWLINE_4=null;
        EObject lv_group_5_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1198:28: ( ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) )
            // InternalPreprocessParser.g:1199:1: ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocessParser.g:1199:1: ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            // InternalPreprocessParser.g:1199:2: () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) )
            {
            // InternalPreprocessParser.g:1199:2: ()
            // InternalPreprocessParser.g:1200:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getIfNotDefConditionalAccess().getIfNotDefConditionalAction_0(),
                          current);
                  
            }

            }

            this_IFNOTDEF_1=(Token)match(input,RULE_IFNOTDEF,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_IFNOTDEF_1, grammarAccess.getIfNotDefConditionalAccess().getIFNOTDEFTerminalRuleCall_1()); 
                  
            }
            // InternalPreprocessParser.g:1212:1: (this_WS_2= RULE_WS )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_WS) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalPreprocessParser.g:1212:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_2, grammarAccess.getIfNotDefConditionalAccess().getWSTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            // InternalPreprocessParser.g:1216:3: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocessParser.g:1217:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocessParser.g:1217:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocessParser.g:1218:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_id_3_0, grammarAccess.getIfNotDefConditionalAccess().getIdIDTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIfNotDefConditionalRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"id",
                      		lv_id_3_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.ID");
              	    
            }

            }


            }

            this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_4, grammarAccess.getIfNotDefConditionalAccess().getNEWLINETerminalRuleCall_4()); 
                  
            }
            // InternalPreprocessParser.g:1238:1: ( (lv_group_5_0= ruleGroupOpt ) )
            // InternalPreprocessParser.g:1239:1: (lv_group_5_0= ruleGroupOpt )
            {
            // InternalPreprocessParser.g:1239:1: (lv_group_5_0= ruleGroupOpt )
            // InternalPreprocessParser.g:1240:3: lv_group_5_0= ruleGroupOpt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfNotDefConditionalAccess().getGroupGroupOptParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_group_5_0=ruleGroupOpt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfNotDefConditionalRule());
              	        }
                     		set(
                     			current, 
                     			"group",
                      		lv_group_5_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.GroupOpt");
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
    // $ANTLR end "ruleIfNotDefConditional"


    // $ANTLR start "entryRuleElIfConditional"
    // InternalPreprocessParser.g:1264:1: entryRuleElIfConditional returns [EObject current=null] : iv_ruleElIfConditional= ruleElIfConditional EOF ;
    public final EObject entryRuleElIfConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElIfConditional = null;


        try {
            // InternalPreprocessParser.g:1265:2: (iv_ruleElIfConditional= ruleElIfConditional EOF )
            // InternalPreprocessParser.g:1266:2: iv_ruleElIfConditional= ruleElIfConditional EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElIfConditionalRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleElIfConditional=ruleElIfConditional();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElIfConditional; 
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
    // $ANTLR end "entryRuleElIfConditional"


    // $ANTLR start "ruleElIfConditional"
    // InternalPreprocessParser.g:1273:1: ruleElIfConditional returns [EObject current=null] : ( () ( ( ( RULE_HASH ( RULE_WS )* RULE_ELIF ) )=> (this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELIF_3= RULE_ELIF ) ) (this_WS_4= RULE_WS )+ ( (lv_expression_5_0= ruleShadowExpression ) ) this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleElIfConditional() throws RecognitionException {
        EObject current = null;

        Token this_HASH_1=null;
        Token this_WS_2=null;
        Token this_ELIF_3=null;
        Token this_WS_4=null;
        Token this_NEWLINE_6=null;
        EObject lv_expression_5_0 = null;

        EObject lv_group_7_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1276:28: ( ( () ( ( ( RULE_HASH ( RULE_WS )* RULE_ELIF ) )=> (this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELIF_3= RULE_ELIF ) ) (this_WS_4= RULE_WS )+ ( (lv_expression_5_0= ruleShadowExpression ) ) this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) ) ) )
            // InternalPreprocessParser.g:1277:1: ( () ( ( ( RULE_HASH ( RULE_WS )* RULE_ELIF ) )=> (this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELIF_3= RULE_ELIF ) ) (this_WS_4= RULE_WS )+ ( (lv_expression_5_0= ruleShadowExpression ) ) this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocessParser.g:1277:1: ( () ( ( ( RULE_HASH ( RULE_WS )* RULE_ELIF ) )=> (this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELIF_3= RULE_ELIF ) ) (this_WS_4= RULE_WS )+ ( (lv_expression_5_0= ruleShadowExpression ) ) this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) ) )
            // InternalPreprocessParser.g:1277:2: () ( ( ( RULE_HASH ( RULE_WS )* RULE_ELIF ) )=> (this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELIF_3= RULE_ELIF ) ) (this_WS_4= RULE_WS )+ ( (lv_expression_5_0= ruleShadowExpression ) ) this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) )
            {
            // InternalPreprocessParser.g:1277:2: ()
            // InternalPreprocessParser.g:1278:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getElIfConditionalAccess().getElIfConditionalAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:1286:2: ( ( ( RULE_HASH ( RULE_WS )* RULE_ELIF ) )=> (this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELIF_3= RULE_ELIF ) )
            // InternalPreprocessParser.g:1286:3: ( ( RULE_HASH ( RULE_WS )* RULE_ELIF ) )=> (this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELIF_3= RULE_ELIF )
            {
            // InternalPreprocessParser.g:1286:37: (this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELIF_3= RULE_ELIF )
            // InternalPreprocessParser.g:1286:38: this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELIF_3= RULE_ELIF
            {
            this_HASH_1=(Token)match(input,RULE_HASH,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_1, grammarAccess.getElIfConditionalAccess().getHASHTerminalRuleCall_1_0_0()); 
                  
            }
            // InternalPreprocessParser.g:1290:1: (this_WS_2= RULE_WS )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_WS) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalPreprocessParser.g:1290:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_2, grammarAccess.getElIfConditionalAccess().getWSTerminalRuleCall_1_0_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            this_ELIF_3=(Token)match(input,RULE_ELIF,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ELIF_3, grammarAccess.getElIfConditionalAccess().getELIFTerminalRuleCall_1_0_2()); 
                  
            }

            }


            }

            // InternalPreprocessParser.g:1298:3: (this_WS_4= RULE_WS )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_WS) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalPreprocessParser.g:1298:4: this_WS_4= RULE_WS
            	    {
            	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_4, grammarAccess.getElIfConditionalAccess().getWSTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            // InternalPreprocessParser.g:1302:3: ( (lv_expression_5_0= ruleShadowExpression ) )
            // InternalPreprocessParser.g:1303:1: (lv_expression_5_0= ruleShadowExpression )
            {
            // InternalPreprocessParser.g:1303:1: (lv_expression_5_0= ruleShadowExpression )
            // InternalPreprocessParser.g:1304:3: lv_expression_5_0= ruleShadowExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElIfConditionalAccess().getExpressionShadowExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_6);
            lv_expression_5_0=ruleShadowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElIfConditionalRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_5_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.ShadowExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_NEWLINE_6=(Token)match(input,RULE_NEWLINE,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_6, grammarAccess.getElIfConditionalAccess().getNEWLINETerminalRuleCall_4()); 
                  
            }
            // InternalPreprocessParser.g:1324:1: ( (lv_group_7_0= ruleGroupOpt ) )
            // InternalPreprocessParser.g:1325:1: (lv_group_7_0= ruleGroupOpt )
            {
            // InternalPreprocessParser.g:1325:1: (lv_group_7_0= ruleGroupOpt )
            // InternalPreprocessParser.g:1326:3: lv_group_7_0= ruleGroupOpt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElIfConditionalAccess().getGroupGroupOptParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_group_7_0=ruleGroupOpt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElIfConditionalRule());
              	        }
                     		set(
                     			current, 
                     			"group",
                      		lv_group_7_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.GroupOpt");
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
    // $ANTLR end "ruleElIfConditional"


    // $ANTLR start "entryRuleElseConditional"
    // InternalPreprocessParser.g:1350:1: entryRuleElseConditional returns [EObject current=null] : iv_ruleElseConditional= ruleElseConditional EOF ;
    public final EObject entryRuleElseConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseConditional = null;


        try {
            // InternalPreprocessParser.g:1351:2: (iv_ruleElseConditional= ruleElseConditional EOF )
            // InternalPreprocessParser.g:1352:2: iv_ruleElseConditional= ruleElseConditional EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElseConditionalRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleElseConditional=ruleElseConditional();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElseConditional; 
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
    // $ANTLR end "entryRuleElseConditional"


    // $ANTLR start "ruleElseConditional"
    // InternalPreprocessParser.g:1359:1: ruleElseConditional returns [EObject current=null] : ( () ( ( ( RULE_HASH ( RULE_WS )* RULE_ELSE ) )=> (this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELSE_3= RULE_ELSE ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleElseConditional() throws RecognitionException {
        EObject current = null;

        Token this_HASH_1=null;
        Token this_WS_2=null;
        Token this_ELSE_3=null;
        Token this_NEWLINE_4=null;
        EObject lv_group_5_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1362:28: ( ( () ( ( ( RULE_HASH ( RULE_WS )* RULE_ELSE ) )=> (this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELSE_3= RULE_ELSE ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) )
            // InternalPreprocessParser.g:1363:1: ( () ( ( ( RULE_HASH ( RULE_WS )* RULE_ELSE ) )=> (this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELSE_3= RULE_ELSE ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocessParser.g:1363:1: ( () ( ( ( RULE_HASH ( RULE_WS )* RULE_ELSE ) )=> (this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELSE_3= RULE_ELSE ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            // InternalPreprocessParser.g:1363:2: () ( ( ( RULE_HASH ( RULE_WS )* RULE_ELSE ) )=> (this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELSE_3= RULE_ELSE ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) )
            {
            // InternalPreprocessParser.g:1363:2: ()
            // InternalPreprocessParser.g:1364:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getElseConditionalAccess().getElseConditionalAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:1372:2: ( ( ( RULE_HASH ( RULE_WS )* RULE_ELSE ) )=> (this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELSE_3= RULE_ELSE ) )
            // InternalPreprocessParser.g:1372:3: ( ( RULE_HASH ( RULE_WS )* RULE_ELSE ) )=> (this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELSE_3= RULE_ELSE )
            {
            // InternalPreprocessParser.g:1372:37: (this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELSE_3= RULE_ELSE )
            // InternalPreprocessParser.g:1372:38: this_HASH_1= RULE_HASH (this_WS_2= RULE_WS )* this_ELSE_3= RULE_ELSE
            {
            this_HASH_1=(Token)match(input,RULE_HASH,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_1, grammarAccess.getElseConditionalAccess().getHASHTerminalRuleCall_1_0_0()); 
                  
            }
            // InternalPreprocessParser.g:1376:1: (this_WS_2= RULE_WS )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_WS) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalPreprocessParser.g:1376:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_20); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_2, grammarAccess.getElseConditionalAccess().getWSTerminalRuleCall_1_0_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            this_ELSE_3=(Token)match(input,RULE_ELSE,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ELSE_3, grammarAccess.getElseConditionalAccess().getELSETerminalRuleCall_1_0_2()); 
                  
            }

            }


            }

            this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_4, grammarAccess.getElseConditionalAccess().getNEWLINETerminalRuleCall_2()); 
                  
            }
            // InternalPreprocessParser.g:1388:1: ( (lv_group_5_0= ruleGroupOpt ) )
            // InternalPreprocessParser.g:1389:1: (lv_group_5_0= ruleGroupOpt )
            {
            // InternalPreprocessParser.g:1389:1: (lv_group_5_0= ruleGroupOpt )
            // InternalPreprocessParser.g:1390:3: lv_group_5_0= ruleGroupOpt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElseConditionalAccess().getGroupGroupOptParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_group_5_0=ruleGroupOpt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElseConditionalRule());
              	        }
                     		set(
                     			current, 
                     			"group",
                      		lv_group_5_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.GroupOpt");
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
    // $ANTLR end "ruleElseConditional"


    // $ANTLR start "entryRulePragmaDirective"
    // InternalPreprocessParser.g:1414:1: entryRulePragmaDirective returns [EObject current=null] : iv_rulePragmaDirective= rulePragmaDirective EOF ;
    public final EObject entryRulePragmaDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePragmaDirective = null;


        try {
            // InternalPreprocessParser.g:1415:2: (iv_rulePragmaDirective= rulePragmaDirective EOF )
            // InternalPreprocessParser.g:1416:2: iv_rulePragmaDirective= rulePragmaDirective EOF
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
    // InternalPreprocessParser.g:1423:1: rulePragmaDirective returns [EObject current=null] : ( () this_PRAGMA_1= RULE_PRAGMA ) ;
    public final EObject rulePragmaDirective() throws RecognitionException {
        EObject current = null;

        Token this_PRAGMA_1=null;

         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1426:28: ( ( () this_PRAGMA_1= RULE_PRAGMA ) )
            // InternalPreprocessParser.g:1427:1: ( () this_PRAGMA_1= RULE_PRAGMA )
            {
            // InternalPreprocessParser.g:1427:1: ( () this_PRAGMA_1= RULE_PRAGMA )
            // InternalPreprocessParser.g:1427:2: () this_PRAGMA_1= RULE_PRAGMA
            {
            // InternalPreprocessParser.g:1427:2: ()
            // InternalPreprocessParser.g:1428:2: 
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
    // InternalPreprocessParser.g:1448:1: entryRuleNullDirective returns [EObject current=null] : iv_ruleNullDirective= ruleNullDirective EOF ;
    public final EObject entryRuleNullDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullDirective = null;


        try {
            // InternalPreprocessParser.g:1449:2: (iv_ruleNullDirective= ruleNullDirective EOF )
            // InternalPreprocessParser.g:1450:2: iv_ruleNullDirective= ruleNullDirective EOF
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
    // InternalPreprocessParser.g:1457:1: ruleNullDirective returns [EObject current=null] : () ;
    public final EObject ruleNullDirective() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1460:28: ( () )
            // InternalPreprocessParser.g:1461:1: ()
            {
            // InternalPreprocessParser.g:1461:1: ()
            // InternalPreprocessParser.g:1462:2: 
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
    // InternalPreprocessParser.g:1478:1: entryRuleNewLineLine returns [EObject current=null] : iv_ruleNewLineLine= ruleNewLineLine EOF ;
    public final EObject entryRuleNewLineLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewLineLine = null;


        try {
            // InternalPreprocessParser.g:1479:2: (iv_ruleNewLineLine= ruleNewLineLine EOF )
            // InternalPreprocessParser.g:1480:2: iv_ruleNewLineLine= ruleNewLineLine EOF
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
    // InternalPreprocessParser.g:1487:1: ruleNewLineLine returns [EObject current=null] : ( () this_NEWLINE_1= RULE_NEWLINE ) ;
    public final EObject ruleNewLineLine() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_1=null;

         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1490:28: ( ( () this_NEWLINE_1= RULE_NEWLINE ) )
            // InternalPreprocessParser.g:1491:1: ( () this_NEWLINE_1= RULE_NEWLINE )
            {
            // InternalPreprocessParser.g:1491:1: ( () this_NEWLINE_1= RULE_NEWLINE )
            // InternalPreprocessParser.g:1491:2: () this_NEWLINE_1= RULE_NEWLINE
            {
            // InternalPreprocessParser.g:1491:2: ()
            // InternalPreprocessParser.g:1492:2: 
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
    // InternalPreprocessParser.g:1512:1: entryRuleCode returns [EObject current=null] : iv_ruleCode= ruleCode EOF ;
    public final EObject entryRuleCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCode = null;


        try {
            // InternalPreprocessParser.g:1513:2: (iv_ruleCode= ruleCode EOF )
            // InternalPreprocessParser.g:1514:2: iv_ruleCode= ruleCode EOF
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
    // InternalPreprocessParser.g:1521:1: ruleCode returns [EObject current=null] : ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE ) ;
    public final EObject ruleCode() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_2=null;
        AntlrDatatypeRuleToken lv_code_1_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1524:28: ( ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE ) )
            // InternalPreprocessParser.g:1525:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE )
            {
            // InternalPreprocessParser.g:1525:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE )
            // InternalPreprocessParser.g:1525:2: () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE
            {
            // InternalPreprocessParser.g:1525:2: ()
            // InternalPreprocessParser.g:1526:2: 
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

            // InternalPreprocessParser.g:1534:2: ( (lv_code_1_0= ruleMyCodeLineExtended ) )
            // InternalPreprocessParser.g:1535:1: (lv_code_1_0= ruleMyCodeLineExtended )
            {
            // InternalPreprocessParser.g:1535:1: (lv_code_1_0= ruleMyCodeLineExtended )
            // InternalPreprocessParser.g:1536:3: lv_code_1_0= ruleMyCodeLineExtended
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
                      		"at.jku.weiner.c.preprocess.Preprocess.MyCodeLineExtended");
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
    // InternalPreprocessParser.g:1564:1: entryRuleMyCode returns [String current=null] : iv_ruleMyCode= ruleMyCode EOF ;
    public final String entryRuleMyCode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCode = null;


        try {
            // InternalPreprocessParser.g:1565:1: (iv_ruleMyCode= ruleMyCode EOF )
            // InternalPreprocessParser.g:1566:2: iv_ruleMyCode= ruleMyCode EOF
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
    // InternalPreprocessParser.g:1573:1: ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_SpecialKeywords_11= ruleSpecialKeywords | this_Constant_12= ruleConstant ) ;
    public final AntlrDatatypeRuleToken ruleMyCode() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_SPECIAL_1=null;
        Token this_INCLUDE_2=null;
        Token this_DEFINE_3=null;
        Token this_ERROR_4=null;
        Token this_PRAGMA_5=null;
        Token this_IFDEF_6=null;
        Token this_ENDIF_7=null;
        Token this_IFNOTDEF_8=null;
        Token this_IF_9=null;
        Token this_DEFINED_10=null;
        AntlrDatatypeRuleToken this_SpecialKeywords_11 = null;

        AntlrDatatypeRuleToken this_Constant_12 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1577:6: ( (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_SpecialKeywords_11= ruleSpecialKeywords | this_Constant_12= ruleConstant ) )
            // InternalPreprocessParser.g:1578:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_SpecialKeywords_11= ruleSpecialKeywords | this_Constant_12= ruleConstant )
            {
            // InternalPreprocessParser.g:1578:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_SpecialKeywords_11= ruleSpecialKeywords | this_Constant_12= ruleConstant )
            int alt28=13;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt28=1;
                }
                break;
            case RULE_SPECIAL:
                {
                alt28=2;
                }
                break;
            case RULE_INCLUDE:
                {
                alt28=3;
                }
                break;
            case RULE_DEFINE:
                {
                alt28=4;
                }
                break;
            case RULE_ERROR:
                {
                alt28=5;
                }
                break;
            case RULE_PRAGMA:
                {
                alt28=6;
                }
                break;
            case RULE_IFDEF:
                {
                alt28=7;
                }
                break;
            case RULE_ENDIF:
                {
                alt28=8;
                }
                break;
            case RULE_IFNOTDEF:
                {
                alt28=9;
                }
                break;
            case RULE_IF:
                {
                alt28=10;
                }
                break;
            case RULE_DEFINED:
                {
                alt28=11;
                }
                break;
            case RULE_SKW_AND:
            case RULE_SKW_ANDAND:
            case RULE_SKW_ASSIGN:
            case RULE_SKW_BACKSLASH:
            case RULE_SKW_CARET:
            case RULE_SKW_COMMA:
            case RULE_SKW_COLON:
            case RULE_SKW_DIV:
            case RULE_SKW_DOT:
            case RULE_SKW_DOUBLEQUOTE:
            case RULE_SKW_EQUAL:
            case RULE_SKW_GREATER:
            case RULE_SKW_GREATEREQUAL:
            case RULE_SKW_LEFTBRACE:
            case RULE_SKW_LEFTBRACKET:
            case RULE_SKW_LEFTPAREN:
            case RULE_SKW_LEFTSHIFT:
            case RULE_SKW_LESS:
            case RULE_SKW_LESSEQUAL:
            case RULE_SKW_MINUS:
            case RULE_SKW_MINUSMINUS:
            case RULE_SKW_MOD:
            case RULE_SKW_NOT:
            case RULE_SKW_NOTEQUAL:
            case RULE_SKW_OR:
            case RULE_SKW_OROR:
            case RULE_SKW_PLUS:
            case RULE_SKW_PLUSPLUS:
            case RULE_SKW_QUESTION:
            case RULE_SKW_RIGHTBRACE:
            case RULE_SKW_RIGHTBRACKET:
            case RULE_SKW_RIGHTPAREN:
            case RULE_SKW_RIGHTSHIFT:
            case RULE_SKW_SEMI:
            case RULE_SKW_SINGLEQUOTE:
            case RULE_SKW_STAR:
            case RULE_SKW_TILDE:
                {
                alt28=12;
                }
                break;
            case RULE_CHAR_LITERAL:
            case RULE_STRING_LITERAL:
            case RULE_HEX_LITERAL:
            case RULE_DECIMAL_LITERAL:
            case RULE_OCTAL_LITERAL:
            case RULE_BIN_LITERAL:
            case RULE_FLOAT_LITERAL:
                {
                alt28=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalPreprocessParser.g:1578:6: this_ID_0= RULE_ID
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
                    // InternalPreprocessParser.g:1586:10: this_SPECIAL_1= RULE_SPECIAL
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
                    // InternalPreprocessParser.g:1594:10: this_INCLUDE_2= RULE_INCLUDE
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
                    // InternalPreprocessParser.g:1602:10: this_DEFINE_3= RULE_DEFINE
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
                    // InternalPreprocessParser.g:1610:10: this_ERROR_4= RULE_ERROR
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
                    // InternalPreprocessParser.g:1618:10: this_PRAGMA_5= RULE_PRAGMA
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
                    // InternalPreprocessParser.g:1626:10: this_IFDEF_6= RULE_IFDEF
                    {
                    this_IFDEF_6=(Token)match(input,RULE_IFDEF,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_IFDEF_6);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_IFDEF_6, grammarAccess.getMyCodeAccess().getIFDEFTerminalRuleCall_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalPreprocessParser.g:1634:10: this_ENDIF_7= RULE_ENDIF
                    {
                    this_ENDIF_7=(Token)match(input,RULE_ENDIF,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ENDIF_7);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ENDIF_7, grammarAccess.getMyCodeAccess().getENDIFTerminalRuleCall_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalPreprocessParser.g:1642:10: this_IFNOTDEF_8= RULE_IFNOTDEF
                    {
                    this_IFNOTDEF_8=(Token)match(input,RULE_IFNOTDEF,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_IFNOTDEF_8);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_IFNOTDEF_8, grammarAccess.getMyCodeAccess().getIFNOTDEFTerminalRuleCall_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalPreprocessParser.g:1650:10: this_IF_9= RULE_IF
                    {
                    this_IF_9=(Token)match(input,RULE_IF,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_IF_9);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_IF_9, grammarAccess.getMyCodeAccess().getIFTerminalRuleCall_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalPreprocessParser.g:1658:10: this_DEFINED_10= RULE_DEFINED
                    {
                    this_DEFINED_10=(Token)match(input,RULE_DEFINED,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DEFINED_10);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DEFINED_10, grammarAccess.getMyCodeAccess().getDEFINEDTerminalRuleCall_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // InternalPreprocessParser.g:1667:5: this_SpecialKeywords_11= ruleSpecialKeywords
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeAccess().getSpecialKeywordsParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_SpecialKeywords_11=ruleSpecialKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SpecialKeywords_11);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 13 :
                    // InternalPreprocessParser.g:1679:5: this_Constant_12= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeAccess().getConstantParserRuleCall_12()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Constant_12=ruleConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Constant_12);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
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
    // $ANTLR end "ruleMyCode"


    // $ANTLR start "entryRuleMyDefineLine"
    // InternalPreprocessParser.g:1697:1: entryRuleMyDefineLine returns [String current=null] : iv_ruleMyDefineLine= ruleMyDefineLine EOF ;
    public final String entryRuleMyDefineLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyDefineLine = null;


        try {
            // InternalPreprocessParser.g:1698:1: (iv_ruleMyDefineLine= ruleMyDefineLine EOF )
            // InternalPreprocessParser.g:1699:2: iv_ruleMyDefineLine= ruleMyDefineLine EOF
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
    // InternalPreprocessParser.g:1706:1: ruleMyDefineLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS | this_HASH_2= RULE_HASH )* ;
    public final AntlrDatatypeRuleToken ruleMyDefineLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_1=null;
        Token this_HASH_2=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1710:6: ( (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS | this_HASH_2= RULE_HASH )* )
            // InternalPreprocessParser.g:1711:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS | this_HASH_2= RULE_HASH )*
            {
            // InternalPreprocessParser.g:1711:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS | this_HASH_2= RULE_HASH )*
            loop29:
            do {
                int alt29=4;
                switch ( input.LA(1) ) {
                case RULE_INCLUDE:
                case RULE_DEFINE:
                case RULE_ERROR:
                case RULE_IF:
                case RULE_DEFINED:
                case RULE_IFDEF:
                case RULE_IFNOTDEF:
                case RULE_ENDIF:
                case RULE_PRAGMA:
                case RULE_ID:
                case RULE_CHAR_LITERAL:
                case RULE_STRING_LITERAL:
                case RULE_HEX_LITERAL:
                case RULE_DECIMAL_LITERAL:
                case RULE_OCTAL_LITERAL:
                case RULE_BIN_LITERAL:
                case RULE_FLOAT_LITERAL:
                case RULE_SKW_AND:
                case RULE_SKW_ANDAND:
                case RULE_SKW_ASSIGN:
                case RULE_SKW_BACKSLASH:
                case RULE_SKW_CARET:
                case RULE_SKW_COMMA:
                case RULE_SKW_COLON:
                case RULE_SKW_DIV:
                case RULE_SKW_DOT:
                case RULE_SKW_DOUBLEQUOTE:
                case RULE_SKW_EQUAL:
                case RULE_SKW_GREATER:
                case RULE_SKW_GREATEREQUAL:
                case RULE_SKW_LEFTBRACE:
                case RULE_SKW_LEFTBRACKET:
                case RULE_SKW_LEFTPAREN:
                case RULE_SKW_LEFTSHIFT:
                case RULE_SKW_LESS:
                case RULE_SKW_LESSEQUAL:
                case RULE_SKW_MINUS:
                case RULE_SKW_MINUSMINUS:
                case RULE_SKW_MOD:
                case RULE_SKW_NOT:
                case RULE_SKW_NOTEQUAL:
                case RULE_SKW_OR:
                case RULE_SKW_OROR:
                case RULE_SKW_PLUS:
                case RULE_SKW_PLUSPLUS:
                case RULE_SKW_QUESTION:
                case RULE_SKW_RIGHTBRACE:
                case RULE_SKW_RIGHTBRACKET:
                case RULE_SKW_RIGHTPAREN:
                case RULE_SKW_RIGHTSHIFT:
                case RULE_SKW_SEMI:
                case RULE_SKW_SINGLEQUOTE:
                case RULE_SKW_STAR:
                case RULE_SKW_TILDE:
                case RULE_SPECIAL:
                    {
                    alt29=1;
                    }
                    break;
                case RULE_WS:
                    {
                    alt29=2;
                    }
                    break;
                case RULE_HASH:
                    {
                    alt29=3;
                    }
                    break;

                }

                switch (alt29) {
            	case 1 :
            	    // InternalPreprocessParser.g:1712:5: this_MyCode_0= ruleMyCode
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMyDefineLineAccess().getMyCodeParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_21);
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
            	    // InternalPreprocessParser.g:1723:10: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WS_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_1, grammarAccess.getMyDefineLineAccess().getWSTerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;
            	case 3 :
            	    // InternalPreprocessParser.g:1731:10: this_HASH_2= RULE_HASH
            	    {
            	    this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_HASH_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_HASH_2, grammarAccess.getMyDefineLineAccess().getHASHTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // InternalPreprocessParser.g:1746:1: entryRuleMyCodeLine returns [String current=null] : iv_ruleMyCodeLine= ruleMyCodeLine EOF ;
    public final String entryRuleMyCodeLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLine = null;


        try {
            // InternalPreprocessParser.g:1747:1: (iv_ruleMyCodeLine= ruleMyCodeLine EOF )
            // InternalPreprocessParser.g:1748:2: iv_ruleMyCodeLine= ruleMyCodeLine EOF
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
    // InternalPreprocessParser.g:1755:1: ruleMyCodeLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+ ;
    public final AntlrDatatypeRuleToken ruleMyCodeLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_1=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1759:6: ( (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+ )
            // InternalPreprocessParser.g:1760:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+
            {
            // InternalPreprocessParser.g:1760:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+
            int cnt30=0;
            loop30:
            do {
                int alt30=3;
                alt30 = dfa30.predict(input);
                switch (alt30) {
            	case 1 :
            	    // InternalPreprocessParser.g:1761:5: this_MyCode_0= ruleMyCode
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMyCodeLineAccess().getMyCodeParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_22);
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
            	    // InternalPreprocessParser.g:1772:10: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WS_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_1, grammarAccess.getMyCodeLineAccess().getWSTerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
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
    // InternalPreprocessParser.g:1787:1: entryRuleMyCodeLineExtended returns [String current=null] : iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF ;
    public final String entryRuleMyCodeLineExtended() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtended = null;


        try {
            // InternalPreprocessParser.g:1788:1: (iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF )
            // InternalPreprocessParser.g:1789:2: iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF
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
    // InternalPreprocessParser.g:1796:1: ruleMyCodeLineExtended returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? ) ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtended() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_0=null;
        Token this_HASH_3=null;
        AntlrDatatypeRuleToken this_MyCode_1 = null;

        AntlrDatatypeRuleToken this_MyCodeLine_2 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1800:6: ( ( (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? ) )
            // InternalPreprocessParser.g:1801:1: ( (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? )
            {
            // InternalPreprocessParser.g:1801:1: ( (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? )
            // InternalPreprocessParser.g:1801:2: (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )?
            {
            // InternalPreprocessParser.g:1801:2: (this_WS_0= RULE_WS )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_WS) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalPreprocessParser.g:1801:7: this_WS_0= RULE_WS
            	    {
            	    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WS_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_0, grammarAccess.getMyCodeLineExtendedAccess().getWSTerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            // InternalPreprocessParser.g:1808:3: (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_INCLUDE && LA33_0<=RULE_ERROR)||(LA33_0>=RULE_IF && LA33_0<=RULE_IFNOTDEF)||(LA33_0>=RULE_ENDIF && LA33_0<=RULE_PRAGMA)||LA33_0==RULE_ID||(LA33_0>=RULE_CHAR_LITERAL && LA33_0<=RULE_BIN_LITERAL)||LA33_0==RULE_FLOAT_LITERAL||(LA33_0>=RULE_SKW_AND && LA33_0<=RULE_SKW_DIV)||(LA33_0>=RULE_SKW_DOT && LA33_0<=RULE_SKW_TILDE)||LA33_0==RULE_SPECIAL) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalPreprocessParser.g:1809:5: this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeLineExtendedAccess().getMyCodeParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_21);
                    this_MyCode_1=ruleMyCode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_MyCode_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalPreprocessParser.g:1819:1: (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
                    loop32:
                    do {
                        int alt32=3;
                        int LA32_0 = input.LA(1);

                        if ( ((LA32_0>=RULE_INCLUDE && LA32_0<=RULE_ERROR)||(LA32_0>=RULE_IF && LA32_0<=RULE_IFNOTDEF)||(LA32_0>=RULE_ENDIF && LA32_0<=RULE_PRAGMA)||(LA32_0>=RULE_WS && LA32_0<=RULE_ID)||(LA32_0>=RULE_CHAR_LITERAL && LA32_0<=RULE_BIN_LITERAL)||LA32_0==RULE_FLOAT_LITERAL||(LA32_0>=RULE_SKW_AND && LA32_0<=RULE_SKW_DIV)||(LA32_0>=RULE_SKW_DOT && LA32_0<=RULE_SKW_TILDE)||LA32_0==RULE_SPECIAL) ) {
                            alt32=1;
                        }
                        else if ( (LA32_0==RULE_HASH) ) {
                            alt32=2;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalPreprocessParser.g:1820:5: this_MyCodeLine_2= ruleMyCodeLine
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	              newCompositeNode(grammarAccess.getMyCodeLineExtendedAccess().getMyCodeLineParserRuleCall_1_1_0()); 
                    	          
                    	    }
                    	    pushFollow(FOLLOW_21);
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
                    	    // InternalPreprocessParser.g:1831:10: this_HASH_3= RULE_HASH
                    	    {
                    	    this_HASH_3=(Token)match(input,RULE_HASH,FOLLOW_21); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_HASH_3);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_HASH_3, grammarAccess.getMyCodeLineExtendedAccess().getHASHTerminalRuleCall_1_1_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop32;
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


    // $ANTLR start "entryRuleShadowExpression"
    // InternalPreprocessParser.g:1846:1: entryRuleShadowExpression returns [EObject current=null] : iv_ruleShadowExpression= ruleShadowExpression EOF ;
    public final EObject entryRuleShadowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShadowExpression = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // InternalPreprocessParser.g:1850:2: (iv_ruleShadowExpression= ruleShadowExpression EOF )
            // InternalPreprocessParser.g:1851:2: iv_ruleShadowExpression= ruleShadowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShadowExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleShadowExpression=ruleShadowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShadowExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleShadowExpression"


    // $ANTLR start "ruleShadowExpression"
    // InternalPreprocessParser.g:1861:1: ruleShadowExpression returns [EObject current=null] : this_ConstantExpression_0= ruleConstantExpression ;
    public final EObject ruleShadowExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConstantExpression_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // InternalPreprocessParser.g:1865:28: (this_ConstantExpression_0= ruleConstantExpression )
            // InternalPreprocessParser.g:1867:2: this_ConstantExpression_0= ruleConstantExpression
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getShadowExpressionAccess().getConstantExpressionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_2);
            this_ConstantExpression_0=ruleConstantExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_ConstantExpression_0;
                      afterParserOrEnumRuleCall();
                  
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleShadowExpression"


    // $ANTLR start "entryRuleExpression"
    // InternalPreprocessParser.g:1889:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalPreprocessParser.g:1890:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalPreprocessParser.g:1891:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalPreprocessParser.g:1898:1: ruleExpression returns [EObject current=null] : ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1901:28: ( ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) ) )
            // InternalPreprocessParser.g:1902:1: ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) )
            {
            // InternalPreprocessParser.g:1902:1: ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) )
            // InternalPreprocessParser.g:1902:2: () ( (lv_expression_1_0= ruleConditionalExpression ) )
            {
            // InternalPreprocessParser.g:1902:2: ()
            // InternalPreprocessParser.g:1903:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getExpressionAccess().getExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:1911:2: ( (lv_expression_1_0= ruleConditionalExpression ) )
            // InternalPreprocessParser.g:1912:1: (lv_expression_1_0= ruleConditionalExpression )
            {
            // InternalPreprocessParser.g:1912:1: (lv_expression_1_0= ruleConditionalExpression )
            // InternalPreprocessParser.g:1913:3: lv_expression_1_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionAccess().getExpressionConditionalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_expression_1_0=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_1_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.ConditionalExpression");
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleConstantExpression"
    // InternalPreprocessParser.g:1937:1: entryRuleConstantExpression returns [EObject current=null] : iv_ruleConstantExpression= ruleConstantExpression EOF ;
    public final EObject entryRuleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantExpression = null;


        try {
            // InternalPreprocessParser.g:1938:2: (iv_ruleConstantExpression= ruleConstantExpression EOF )
            // InternalPreprocessParser.g:1939:2: iv_ruleConstantExpression= ruleConstantExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstantExpression=ruleConstantExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantExpression; 
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
    // $ANTLR end "entryRuleConstantExpression"


    // $ANTLR start "ruleConstantExpression"
    // InternalPreprocessParser.g:1946:1: ruleConstantExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) ) ;
    public final EObject ruleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1949:28: ( ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) ) )
            // InternalPreprocessParser.g:1950:1: ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) )
            {
            // InternalPreprocessParser.g:1950:1: ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) )
            // InternalPreprocessParser.g:1950:2: () ( (lv_expr_1_0= ruleConditionalExpression ) )
            {
            // InternalPreprocessParser.g:1950:2: ()
            // InternalPreprocessParser.g:1951:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getConstantExpressionAccess().getConstantExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:1959:2: ( (lv_expr_1_0= ruleConditionalExpression ) )
            // InternalPreprocessParser.g:1960:1: (lv_expr_1_0= ruleConditionalExpression )
            {
            // InternalPreprocessParser.g:1960:1: (lv_expr_1_0= ruleConditionalExpression )
            // InternalPreprocessParser.g:1961:3: lv_expr_1_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstantExpressionAccess().getExprConditionalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_expr_1_0=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConstantExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_1_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.ConditionalExpression");
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
    // $ANTLR end "ruleConstantExpression"


    // $ANTLR start "entryRuleConditionalExpression"
    // InternalPreprocessParser.g:1985:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalPreprocessParser.g:1986:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalPreprocessParser.g:1987:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConditionalExpression=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalExpression; 
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
    // $ANTLR end "entryRuleConditionalExpression"


    // $ANTLR start "ruleConditionalExpression"
    // InternalPreprocessParser.g:1994:1: ruleConditionalExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_QUESTION_2=null;
        Token this_SKW_COLON_4=null;
        EObject lv_expr_1_0 = null;

        EObject lv_qExpr_3_0 = null;

        EObject lv_cExpr_5_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1997:28: ( ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) )
            // InternalPreprocessParser.g:1998:1: ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
            {
            // InternalPreprocessParser.g:1998:1: ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
            // InternalPreprocessParser.g:1998:2: () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
            {
            // InternalPreprocessParser.g:1998:2: ()
            // InternalPreprocessParser.g:1999:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getConditionalExpressionAccess().getConditionalExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:2007:2: ( (lv_expr_1_0= ruleLogicalOrExpression ) )
            // InternalPreprocessParser.g:2008:1: (lv_expr_1_0= ruleLogicalOrExpression )
            {
            // InternalPreprocessParser.g:2008:1: (lv_expr_1_0= ruleLogicalOrExpression )
            // InternalPreprocessParser.g:2009:3: lv_expr_1_0= ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExprLogicalOrExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_23);
            lv_expr_1_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_1_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.LogicalOrExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocessParser.g:2025:2: (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_SKW_QUESTION) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalPreprocessParser.g:2025:3: this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) )
                    {
                    this_SKW_QUESTION_2=(Token)match(input,RULE_SKW_QUESTION,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_QUESTION_2, grammarAccess.getConditionalExpressionAccess().getSKW_QUESTIONTerminalRuleCall_2_0()); 
                          
                    }
                    // InternalPreprocessParser.g:2029:1: ( (lv_qExpr_3_0= ruleExpression ) )
                    // InternalPreprocessParser.g:2030:1: (lv_qExpr_3_0= ruleExpression )
                    {
                    // InternalPreprocessParser.g:2030:1: (lv_qExpr_3_0= ruleExpression )
                    // InternalPreprocessParser.g:2031:3: lv_qExpr_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getQExprExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_25);
                    lv_qExpr_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"qExpr",
                              		lv_qExpr_3_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_SKW_COLON_4=(Token)match(input,RULE_SKW_COLON,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_COLON_4, grammarAccess.getConditionalExpressionAccess().getSKW_COLONTerminalRuleCall_2_2()); 
                          
                    }
                    // InternalPreprocessParser.g:2051:1: ( (lv_cExpr_5_0= ruleConditionalExpression ) )
                    // InternalPreprocessParser.g:2052:1: (lv_cExpr_5_0= ruleConditionalExpression )
                    {
                    // InternalPreprocessParser.g:2052:1: (lv_cExpr_5_0= ruleConditionalExpression )
                    // InternalPreprocessParser.g:2053:3: lv_cExpr_5_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getCExprConditionalExpressionParserRuleCall_2_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_cExpr_5_0=ruleConditionalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"cExpr",
                              		lv_cExpr_5_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.ConditionalExpression");
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
    // $ANTLR end "ruleConditionalExpression"


    // $ANTLR start "entryRuleLogicalOrExpression"
    // InternalPreprocessParser.g:2077:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalPreprocessParser.g:2078:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalPreprocessParser.g:2079:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOrExpression; 
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
    // $ANTLR end "entryRuleLogicalOrExpression"


    // $ANTLR start "ruleLogicalOrExpression"
    // InternalPreprocessParser.g:2086:1: ruleLogicalOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_OROR_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2089:28: ( ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalPreprocessParser.g:2090:1: ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2090:1: ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalPreprocessParser.g:2090:2: () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )*
            {
            // InternalPreprocessParser.g:2090:2: ()
            // InternalPreprocessParser.g:2091:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:2099:2: ( (lv_expr_1_0= ruleLogicalAndExpression ) )
            // InternalPreprocessParser.g:2100:1: (lv_expr_1_0= ruleLogicalAndExpression )
            {
            // InternalPreprocessParser.g:2100:1: (lv_expr_1_0= ruleLogicalAndExpression )
            // InternalPreprocessParser.g:2101:3: lv_expr_1_0= ruleLogicalAndExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getExprLogicalAndExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_26);
            lv_expr_1_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
              	        }
                     		add(
                     			current, 
                     			"expr",
                      		lv_expr_1_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.LogicalAndExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocessParser.g:2117:2: (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_SKW_OROR) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalPreprocessParser.g:2117:3: this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) )
            	    {
            	    this_SKW_OROR_2=(Token)match(input,RULE_SKW_OROR,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_OROR_2, grammarAccess.getLogicalOrExpressionAccess().getSKW_ORORTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocessParser.g:2121:1: ( (lv_expr_3_0= ruleLogicalAndExpression ) )
            	    // InternalPreprocessParser.g:2122:1: (lv_expr_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalPreprocessParser.g:2122:1: (lv_expr_3_0= ruleLogicalAndExpression )
            	    // InternalPreprocessParser.g:2123:3: lv_expr_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getExprLogicalAndExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_26);
            	    lv_expr_3_0=ruleLogicalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expr",
            	              		lv_expr_3_0, 
            	              		"at.jku.weiner.c.preprocess.Preprocess.LogicalAndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
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
    // $ANTLR end "ruleLogicalOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // InternalPreprocessParser.g:2147:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalPreprocessParser.g:2148:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalPreprocessParser.g:2149:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndExpression; 
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
    // $ANTLR end "entryRuleLogicalAndExpression"


    // $ANTLR start "ruleLogicalAndExpression"
    // InternalPreprocessParser.g:2156:1: ruleLogicalAndExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_ANDAND_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2159:28: ( ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* ) )
            // InternalPreprocessParser.g:2160:1: ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2160:1: ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* )
            // InternalPreprocessParser.g:2160:2: () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )*
            {
            // InternalPreprocessParser.g:2160:2: ()
            // InternalPreprocessParser.g:2161:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:2169:2: ( (lv_expr_1_0= ruleInclusiveOrExpression ) )
            // InternalPreprocessParser.g:2170:1: (lv_expr_1_0= ruleInclusiveOrExpression )
            {
            // InternalPreprocessParser.g:2170:1: (lv_expr_1_0= ruleInclusiveOrExpression )
            // InternalPreprocessParser.g:2171:3: lv_expr_1_0= ruleInclusiveOrExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getExprInclusiveOrExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_27);
            lv_expr_1_0=ruleInclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
              	        }
                     		add(
                     			current, 
                     			"expr",
                      		lv_expr_1_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.InclusiveOrExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocessParser.g:2187:2: (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_SKW_ANDAND) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalPreprocessParser.g:2187:3: this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) )
            	    {
            	    this_SKW_ANDAND_2=(Token)match(input,RULE_SKW_ANDAND,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_ANDAND_2, grammarAccess.getLogicalAndExpressionAccess().getSKW_ANDANDTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocessParser.g:2191:1: ( (lv_expr_3_0= ruleInclusiveOrExpression ) )
            	    // InternalPreprocessParser.g:2192:1: (lv_expr_3_0= ruleInclusiveOrExpression )
            	    {
            	    // InternalPreprocessParser.g:2192:1: (lv_expr_3_0= ruleInclusiveOrExpression )
            	    // InternalPreprocessParser.g:2193:3: lv_expr_3_0= ruleInclusiveOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getExprInclusiveOrExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_27);
            	    lv_expr_3_0=ruleInclusiveOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expr",
            	              		lv_expr_3_0, 
            	              		"at.jku.weiner.c.preprocess.Preprocess.InclusiveOrExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleInclusiveOrExpression"
    // InternalPreprocessParser.g:2217:1: entryRuleInclusiveOrExpression returns [EObject current=null] : iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF ;
    public final EObject entryRuleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclusiveOrExpression = null;


        try {
            // InternalPreprocessParser.g:2218:2: (iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF )
            // InternalPreprocessParser.g:2219:2: iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInclusiveOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInclusiveOrExpression=ruleInclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInclusiveOrExpression; 
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
    // $ANTLR end "entryRuleInclusiveOrExpression"


    // $ANTLR start "ruleInclusiveOrExpression"
    // InternalPreprocessParser.g:2226:1: ruleInclusiveOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* ) ;
    public final EObject ruleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_OR_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2229:28: ( ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* ) )
            // InternalPreprocessParser.g:2230:1: ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2230:1: ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* )
            // InternalPreprocessParser.g:2230:2: () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )*
            {
            // InternalPreprocessParser.g:2230:2: ()
            // InternalPreprocessParser.g:2231:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getInclusiveOrExpressionAccess().getInclusiveOrExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:2239:2: ( (lv_expr_1_0= ruleExclusiveOrExpression ) )
            // InternalPreprocessParser.g:2240:1: (lv_expr_1_0= ruleExclusiveOrExpression )
            {
            // InternalPreprocessParser.g:2240:1: (lv_expr_1_0= ruleExclusiveOrExpression )
            // InternalPreprocessParser.g:2241:3: lv_expr_1_0= ruleExclusiveOrExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExprExclusiveOrExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_28);
            lv_expr_1_0=ruleExclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getInclusiveOrExpressionRule());
              	        }
                     		add(
                     			current, 
                     			"expr",
                      		lv_expr_1_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.ExclusiveOrExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocessParser.g:2257:2: (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_SKW_OR) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalPreprocessParser.g:2257:3: this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) )
            	    {
            	    this_SKW_OR_2=(Token)match(input,RULE_SKW_OR,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_OR_2, grammarAccess.getInclusiveOrExpressionAccess().getSKW_ORTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocessParser.g:2261:1: ( (lv_expr_3_0= ruleExclusiveOrExpression ) )
            	    // InternalPreprocessParser.g:2262:1: (lv_expr_3_0= ruleExclusiveOrExpression )
            	    {
            	    // InternalPreprocessParser.g:2262:1: (lv_expr_3_0= ruleExclusiveOrExpression )
            	    // InternalPreprocessParser.g:2263:3: lv_expr_3_0= ruleExclusiveOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExprExclusiveOrExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_expr_3_0=ruleExclusiveOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getInclusiveOrExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expr",
            	              		lv_expr_3_0, 
            	              		"at.jku.weiner.c.preprocess.Preprocess.ExclusiveOrExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
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
    // $ANTLR end "ruleInclusiveOrExpression"


    // $ANTLR start "entryRuleExclusiveOrExpression"
    // InternalPreprocessParser.g:2287:1: entryRuleExclusiveOrExpression returns [EObject current=null] : iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF ;
    public final EObject entryRuleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusiveOrExpression = null;


        try {
            // InternalPreprocessParser.g:2288:2: (iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF )
            // InternalPreprocessParser.g:2289:2: iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExclusiveOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExclusiveOrExpression=ruleExclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExclusiveOrExpression; 
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
    // $ANTLR end "entryRuleExclusiveOrExpression"


    // $ANTLR start "ruleExclusiveOrExpression"
    // InternalPreprocessParser.g:2296:1: ruleExclusiveOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_CARET_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2299:28: ( ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* ) )
            // InternalPreprocessParser.g:2300:1: ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2300:1: ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* )
            // InternalPreprocessParser.g:2300:2: () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )*
            {
            // InternalPreprocessParser.g:2300:2: ()
            // InternalPreprocessParser.g:2301:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getExclusiveOrExpressionAccess().getExclusiveOrExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:2309:2: ( (lv_expr_1_0= ruleAndExpression ) )
            // InternalPreprocessParser.g:2310:1: (lv_expr_1_0= ruleAndExpression )
            {
            // InternalPreprocessParser.g:2310:1: (lv_expr_1_0= ruleAndExpression )
            // InternalPreprocessParser.g:2311:3: lv_expr_1_0= ruleAndExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getExprAndExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_29);
            lv_expr_1_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getExclusiveOrExpressionRule());
              	        }
                     		add(
                     			current, 
                     			"expr",
                      		lv_expr_1_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.AndExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocessParser.g:2327:2: (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_SKW_CARET) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalPreprocessParser.g:2327:3: this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) )
            	    {
            	    this_SKW_CARET_2=(Token)match(input,RULE_SKW_CARET,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_CARET_2, grammarAccess.getExclusiveOrExpressionAccess().getSKW_CARETTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocessParser.g:2331:1: ( (lv_expr_3_0= ruleAndExpression ) )
            	    // InternalPreprocessParser.g:2332:1: (lv_expr_3_0= ruleAndExpression )
            	    {
            	    // InternalPreprocessParser.g:2332:1: (lv_expr_3_0= ruleAndExpression )
            	    // InternalPreprocessParser.g:2333:3: lv_expr_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getExprAndExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_expr_3_0=ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getExclusiveOrExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expr",
            	              		lv_expr_3_0, 
            	              		"at.jku.weiner.c.preprocess.Preprocess.AndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
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
    // $ANTLR end "ruleExclusiveOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalPreprocessParser.g:2357:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalPreprocessParser.g:2358:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalPreprocessParser.g:2359:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpression; 
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
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalPreprocessParser.g:2366:1: ruleAndExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_AND_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2369:28: ( ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalPreprocessParser.g:2370:1: ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2370:1: ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* )
            // InternalPreprocessParser.g:2370:2: () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )*
            {
            // InternalPreprocessParser.g:2370:2: ()
            // InternalPreprocessParser.g:2371:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAndExpressionAccess().getAndExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:2379:2: ( (lv_expr_1_0= ruleEqualityExpression ) )
            // InternalPreprocessParser.g:2380:1: (lv_expr_1_0= ruleEqualityExpression )
            {
            // InternalPreprocessParser.g:2380:1: (lv_expr_1_0= ruleEqualityExpression )
            // InternalPreprocessParser.g:2381:3: lv_expr_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAndExpressionAccess().getExprEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_30);
            lv_expr_1_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
              	        }
                     		add(
                     			current, 
                     			"expr",
                      		lv_expr_1_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.EqualityExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocessParser.g:2397:2: (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_SKW_AND) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalPreprocessParser.g:2397:3: this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) )
            	    {
            	    this_SKW_AND_2=(Token)match(input,RULE_SKW_AND,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_AND_2, grammarAccess.getAndExpressionAccess().getSKW_ANDTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocessParser.g:2401:1: ( (lv_expr_3_0= ruleEqualityExpression ) )
            	    // InternalPreprocessParser.g:2402:1: (lv_expr_3_0= ruleEqualityExpression )
            	    {
            	    // InternalPreprocessParser.g:2402:1: (lv_expr_3_0= ruleEqualityExpression )
            	    // InternalPreprocessParser.g:2403:3: lv_expr_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExpressionAccess().getExprEqualityExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_expr_3_0=ruleEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expr",
            	              		lv_expr_3_0, 
            	              		"at.jku.weiner.c.preprocess.Preprocess.EqualityExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
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
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalPreprocessParser.g:2427:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalPreprocessParser.g:2428:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalPreprocessParser.g:2429:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
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
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // InternalPreprocessParser.g:2436:1: ruleEqualityExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2439:28: ( ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* ) )
            // InternalPreprocessParser.g:2440:1: ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2440:1: ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* )
            // InternalPreprocessParser.g:2440:2: () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )*
            {
            // InternalPreprocessParser.g:2440:2: ()
            // InternalPreprocessParser.g:2441:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEqualityExpressionAccess().getEqualityExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:2449:2: ( (lv_expr_1_0= ruleRelationalExpression ) )
            // InternalPreprocessParser.g:2450:1: (lv_expr_1_0= ruleRelationalExpression )
            {
            // InternalPreprocessParser.g:2450:1: (lv_expr_1_0= ruleRelationalExpression )
            // InternalPreprocessParser.g:2451:3: lv_expr_1_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExprRelationalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_31);
            lv_expr_1_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
              	        }
                     		add(
                     			current, 
                     			"expr",
                      		lv_expr_1_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.RelationalExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocessParser.g:2467:2: ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_SKW_EQUAL||LA41_0==RULE_SKW_NOTEQUAL) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalPreprocessParser.g:2467:3: ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) )
            	    {
            	    // InternalPreprocessParser.g:2467:3: ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) )
            	    int alt40=2;
            	    int LA40_0 = input.LA(1);

            	    if ( (LA40_0==RULE_SKW_EQUAL) ) {
            	        alt40=1;
            	    }
            	    else if ( (LA40_0==RULE_SKW_NOTEQUAL) ) {
            	        alt40=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 40, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt40) {
            	        case 1 :
            	            // InternalPreprocessParser.g:2467:4: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
            	            {
            	            // InternalPreprocessParser.g:2467:4: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
            	            // InternalPreprocessParser.g:2468:1: (lv_op_2_0= RULE_SKW_EQUAL )
            	            {
            	            // InternalPreprocessParser.g:2468:1: (lv_op_2_0= RULE_SKW_EQUAL )
            	            // InternalPreprocessParser.g:2469:3: lv_op_2_0= RULE_SKW_EQUAL
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_EQUAL,FOLLOW_24); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_2_0, grammarAccess.getEqualityExpressionAccess().getOpSKW_EQUALTerminalRuleCall_2_0_0_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getEqualityExpressionRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"op",
            	                      		lv_op_2_0, 
            	                      		"at.jku.weiner.c.Common.SKW_EQUAL");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalPreprocessParser.g:2486:6: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
            	            {
            	            // InternalPreprocessParser.g:2486:6: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
            	            // InternalPreprocessParser.g:2487:1: (lv_op_3_0= RULE_SKW_NOTEQUAL )
            	            {
            	            // InternalPreprocessParser.g:2487:1: (lv_op_3_0= RULE_SKW_NOTEQUAL )
            	            // InternalPreprocessParser.g:2488:3: lv_op_3_0= RULE_SKW_NOTEQUAL
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_NOTEQUAL,FOLLOW_24); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_3_0, grammarAccess.getEqualityExpressionAccess().getOpSKW_NOTEQUALTerminalRuleCall_2_0_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getEqualityExpressionRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"op",
            	                      		lv_op_3_0, 
            	                      		"at.jku.weiner.c.Common.SKW_NOTEQUAL");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalPreprocessParser.g:2504:3: ( (lv_expr_4_0= ruleRelationalExpression ) )
            	    // InternalPreprocessParser.g:2505:1: (lv_expr_4_0= ruleRelationalExpression )
            	    {
            	    // InternalPreprocessParser.g:2505:1: (lv_expr_4_0= ruleRelationalExpression )
            	    // InternalPreprocessParser.g:2506:3: lv_expr_4_0= ruleRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExprRelationalExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_31);
            	    lv_expr_4_0=ruleRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expr",
            	              		lv_expr_4_0, 
            	              		"at.jku.weiner.c.preprocess.Preprocess.RelationalExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
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
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalPreprocessParser.g:2530:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalPreprocessParser.g:2531:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalPreprocessParser.g:2532:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
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
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // InternalPreprocessParser.g:2539:1: ruleRelationalExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        Token lv_op_4_0=null;
        Token lv_op_5_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_6_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2542:28: ( ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* ) )
            // InternalPreprocessParser.g:2543:1: ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2543:1: ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* )
            // InternalPreprocessParser.g:2543:2: () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )*
            {
            // InternalPreprocessParser.g:2543:2: ()
            // InternalPreprocessParser.g:2544:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRelationalExpressionAccess().getRelationalExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:2552:2: ( (lv_expr_1_0= ruleShiftExpression ) )
            // InternalPreprocessParser.g:2553:1: (lv_expr_1_0= ruleShiftExpression )
            {
            // InternalPreprocessParser.g:2553:1: (lv_expr_1_0= ruleShiftExpression )
            // InternalPreprocessParser.g:2554:3: lv_expr_1_0= ruleShiftExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExprShiftExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_32);
            lv_expr_1_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
              	        }
                     		add(
                     			current, 
                     			"expr",
                      		lv_expr_1_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.ShiftExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocessParser.g:2570:2: ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=RULE_SKW_GREATER && LA43_0<=RULE_SKW_GREATEREQUAL)||(LA43_0>=RULE_SKW_LESS && LA43_0<=RULE_SKW_LESSEQUAL)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalPreprocessParser.g:2570:3: ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) )
            	    {
            	    // InternalPreprocessParser.g:2570:3: ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) )
            	    int alt42=4;
            	    switch ( input.LA(1) ) {
            	    case RULE_SKW_LESS:
            	        {
            	        alt42=1;
            	        }
            	        break;
            	    case RULE_SKW_GREATER:
            	        {
            	        alt42=2;
            	        }
            	        break;
            	    case RULE_SKW_LESSEQUAL:
            	        {
            	        alt42=3;
            	        }
            	        break;
            	    case RULE_SKW_GREATEREQUAL:
            	        {
            	        alt42=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 42, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt42) {
            	        case 1 :
            	            // InternalPreprocessParser.g:2570:4: ( (lv_op_2_0= RULE_SKW_LESS ) )
            	            {
            	            // InternalPreprocessParser.g:2570:4: ( (lv_op_2_0= RULE_SKW_LESS ) )
            	            // InternalPreprocessParser.g:2571:1: (lv_op_2_0= RULE_SKW_LESS )
            	            {
            	            // InternalPreprocessParser.g:2571:1: (lv_op_2_0= RULE_SKW_LESS )
            	            // InternalPreprocessParser.g:2572:3: lv_op_2_0= RULE_SKW_LESS
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_LESS,FOLLOW_24); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_2_0, grammarAccess.getRelationalExpressionAccess().getOpSKW_LESSTerminalRuleCall_2_0_0_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"op",
            	                      		lv_op_2_0, 
            	                      		"at.jku.weiner.c.Common.SKW_LESS");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalPreprocessParser.g:2589:6: ( (lv_op_3_0= RULE_SKW_GREATER ) )
            	            {
            	            // InternalPreprocessParser.g:2589:6: ( (lv_op_3_0= RULE_SKW_GREATER ) )
            	            // InternalPreprocessParser.g:2590:1: (lv_op_3_0= RULE_SKW_GREATER )
            	            {
            	            // InternalPreprocessParser.g:2590:1: (lv_op_3_0= RULE_SKW_GREATER )
            	            // InternalPreprocessParser.g:2591:3: lv_op_3_0= RULE_SKW_GREATER
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_GREATER,FOLLOW_24); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_3_0, grammarAccess.getRelationalExpressionAccess().getOpSKW_GREATERTerminalRuleCall_2_0_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"op",
            	                      		lv_op_3_0, 
            	                      		"at.jku.weiner.c.Common.SKW_GREATER");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalPreprocessParser.g:2608:6: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
            	            {
            	            // InternalPreprocessParser.g:2608:6: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
            	            // InternalPreprocessParser.g:2609:1: (lv_op_4_0= RULE_SKW_LESSEQUAL )
            	            {
            	            // InternalPreprocessParser.g:2609:1: (lv_op_4_0= RULE_SKW_LESSEQUAL )
            	            // InternalPreprocessParser.g:2610:3: lv_op_4_0= RULE_SKW_LESSEQUAL
            	            {
            	            lv_op_4_0=(Token)match(input,RULE_SKW_LESSEQUAL,FOLLOW_24); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_4_0, grammarAccess.getRelationalExpressionAccess().getOpSKW_LESSEQUALTerminalRuleCall_2_0_2_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"op",
            	                      		lv_op_4_0, 
            	                      		"at.jku.weiner.c.Common.SKW_LESSEQUAL");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // InternalPreprocessParser.g:2627:6: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
            	            {
            	            // InternalPreprocessParser.g:2627:6: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
            	            // InternalPreprocessParser.g:2628:1: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
            	            {
            	            // InternalPreprocessParser.g:2628:1: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
            	            // InternalPreprocessParser.g:2629:3: lv_op_5_0= RULE_SKW_GREATEREQUAL
            	            {
            	            lv_op_5_0=(Token)match(input,RULE_SKW_GREATEREQUAL,FOLLOW_24); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_5_0, grammarAccess.getRelationalExpressionAccess().getOpSKW_GREATEREQUALTerminalRuleCall_2_0_3_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"op",
            	                      		lv_op_5_0, 
            	                      		"at.jku.weiner.c.Common.SKW_GREATEREQUAL");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalPreprocessParser.g:2645:3: ( (lv_expr_6_0= ruleShiftExpression ) )
            	    // InternalPreprocessParser.g:2646:1: (lv_expr_6_0= ruleShiftExpression )
            	    {
            	    // InternalPreprocessParser.g:2646:1: (lv_expr_6_0= ruleShiftExpression )
            	    // InternalPreprocessParser.g:2647:3: lv_expr_6_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExprShiftExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_expr_6_0=ruleShiftExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expr",
            	              		lv_expr_6_0, 
            	              		"at.jku.weiner.c.preprocess.Preprocess.ShiftExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
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
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleShiftExpression"
    // InternalPreprocessParser.g:2671:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalPreprocessParser.g:2672:2: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalPreprocessParser.g:2673:2: iv_ruleShiftExpression= ruleShiftExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShiftExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleShiftExpression=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShiftExpression; 
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
    // $ANTLR end "entryRuleShiftExpression"


    // $ANTLR start "ruleShiftExpression"
    // InternalPreprocessParser.g:2680:1: ruleShiftExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2683:28: ( ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* ) )
            // InternalPreprocessParser.g:2684:1: ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2684:1: ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* )
            // InternalPreprocessParser.g:2684:2: () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )*
            {
            // InternalPreprocessParser.g:2684:2: ()
            // InternalPreprocessParser.g:2685:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getShiftExpressionAccess().getShiftExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:2693:2: ( (lv_expr_1_0= ruleAdditiveExpression ) )
            // InternalPreprocessParser.g:2694:1: (lv_expr_1_0= ruleAdditiveExpression )
            {
            // InternalPreprocessParser.g:2694:1: (lv_expr_1_0= ruleAdditiveExpression )
            // InternalPreprocessParser.g:2695:3: lv_expr_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getExprAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_33);
            lv_expr_1_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
              	        }
                     		add(
                     			current, 
                     			"expr",
                      		lv_expr_1_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.AdditiveExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocessParser.g:2711:2: ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_SKW_LEFTSHIFT||LA45_0==RULE_SKW_RIGHTSHIFT) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalPreprocessParser.g:2711:3: ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalPreprocessParser.g:2711:3: ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) )
            	    int alt44=2;
            	    int LA44_0 = input.LA(1);

            	    if ( (LA44_0==RULE_SKW_LEFTSHIFT) ) {
            	        alt44=1;
            	    }
            	    else if ( (LA44_0==RULE_SKW_RIGHTSHIFT) ) {
            	        alt44=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 44, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt44) {
            	        case 1 :
            	            // InternalPreprocessParser.g:2711:4: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
            	            {
            	            // InternalPreprocessParser.g:2711:4: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
            	            // InternalPreprocessParser.g:2712:1: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
            	            {
            	            // InternalPreprocessParser.g:2712:1: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
            	            // InternalPreprocessParser.g:2713:3: lv_op_2_0= RULE_SKW_LEFTSHIFT
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_LEFTSHIFT,FOLLOW_24); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_2_0, grammarAccess.getShiftExpressionAccess().getOpSKW_LEFTSHIFTTerminalRuleCall_2_0_0_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getShiftExpressionRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"op",
            	                      		lv_op_2_0, 
            	                      		"at.jku.weiner.c.Common.SKW_LEFTSHIFT");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalPreprocessParser.g:2730:6: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
            	            {
            	            // InternalPreprocessParser.g:2730:6: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
            	            // InternalPreprocessParser.g:2731:1: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
            	            {
            	            // InternalPreprocessParser.g:2731:1: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
            	            // InternalPreprocessParser.g:2732:3: lv_op_3_0= RULE_SKW_RIGHTSHIFT
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_RIGHTSHIFT,FOLLOW_24); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_3_0, grammarAccess.getShiftExpressionAccess().getOpSKW_RIGHTSHIFTTerminalRuleCall_2_0_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getShiftExpressionRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"op",
            	                      		lv_op_3_0, 
            	                      		"at.jku.weiner.c.Common.SKW_RIGHTSHIFT");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalPreprocessParser.g:2748:3: ( (lv_expr_4_0= ruleAdditiveExpression ) )
            	    // InternalPreprocessParser.g:2749:1: (lv_expr_4_0= ruleAdditiveExpression )
            	    {
            	    // InternalPreprocessParser.g:2749:1: (lv_expr_4_0= ruleAdditiveExpression )
            	    // InternalPreprocessParser.g:2750:3: lv_expr_4_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getExprAdditiveExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_33);
            	    lv_expr_4_0=ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expr",
            	              		lv_expr_4_0, 
            	              		"at.jku.weiner.c.preprocess.Preprocess.AdditiveExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
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
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalPreprocessParser.g:2774:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalPreprocessParser.g:2775:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalPreprocessParser.g:2776:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
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
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalPreprocessParser.g:2783:1: ruleAdditiveExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2786:28: ( ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalPreprocessParser.g:2787:1: ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2787:1: ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* )
            // InternalPreprocessParser.g:2787:2: () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )*
            {
            // InternalPreprocessParser.g:2787:2: ()
            // InternalPreprocessParser.g:2788:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:2796:2: ( (lv_expr_1_0= ruleMultiplicativeExpression ) )
            // InternalPreprocessParser.g:2797:1: (lv_expr_1_0= ruleMultiplicativeExpression )
            {
            // InternalPreprocessParser.g:2797:1: (lv_expr_1_0= ruleMultiplicativeExpression )
            // InternalPreprocessParser.g:2798:3: lv_expr_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExprMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_34);
            lv_expr_1_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
              	        }
                     		add(
                     			current, 
                     			"expr",
                      		lv_expr_1_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.MultiplicativeExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocessParser.g:2814:2: ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_SKW_MINUS||LA47_0==RULE_SKW_PLUS) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalPreprocessParser.g:2814:3: ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalPreprocessParser.g:2814:3: ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) )
            	    int alt46=2;
            	    int LA46_0 = input.LA(1);

            	    if ( (LA46_0==RULE_SKW_PLUS) ) {
            	        alt46=1;
            	    }
            	    else if ( (LA46_0==RULE_SKW_MINUS) ) {
            	        alt46=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 46, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt46) {
            	        case 1 :
            	            // InternalPreprocessParser.g:2814:4: ( (lv_op_2_0= RULE_SKW_PLUS ) )
            	            {
            	            // InternalPreprocessParser.g:2814:4: ( (lv_op_2_0= RULE_SKW_PLUS ) )
            	            // InternalPreprocessParser.g:2815:1: (lv_op_2_0= RULE_SKW_PLUS )
            	            {
            	            // InternalPreprocessParser.g:2815:1: (lv_op_2_0= RULE_SKW_PLUS )
            	            // InternalPreprocessParser.g:2816:3: lv_op_2_0= RULE_SKW_PLUS
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_PLUS,FOLLOW_24); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_2_0, grammarAccess.getAdditiveExpressionAccess().getOpSKW_PLUSTerminalRuleCall_2_0_0_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"op",
            	                      		lv_op_2_0, 
            	                      		"at.jku.weiner.c.Common.SKW_PLUS");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalPreprocessParser.g:2833:6: ( (lv_op_3_0= RULE_SKW_MINUS ) )
            	            {
            	            // InternalPreprocessParser.g:2833:6: ( (lv_op_3_0= RULE_SKW_MINUS ) )
            	            // InternalPreprocessParser.g:2834:1: (lv_op_3_0= RULE_SKW_MINUS )
            	            {
            	            // InternalPreprocessParser.g:2834:1: (lv_op_3_0= RULE_SKW_MINUS )
            	            // InternalPreprocessParser.g:2835:3: lv_op_3_0= RULE_SKW_MINUS
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_24); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_3_0, grammarAccess.getAdditiveExpressionAccess().getOpSKW_MINUSTerminalRuleCall_2_0_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"op",
            	                      		lv_op_3_0, 
            	                      		"at.jku.weiner.c.Common.SKW_MINUS");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalPreprocessParser.g:2851:3: ( (lv_expr_4_0= ruleMultiplicativeExpression ) )
            	    // InternalPreprocessParser.g:2852:1: (lv_expr_4_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalPreprocessParser.g:2852:1: (lv_expr_4_0= ruleMultiplicativeExpression )
            	    // InternalPreprocessParser.g:2853:3: lv_expr_4_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExprMultiplicativeExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_expr_4_0=ruleMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expr",
            	              		lv_expr_4_0, 
            	              		"at.jku.weiner.c.preprocess.Preprocess.MultiplicativeExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalPreprocessParser.g:2877:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalPreprocessParser.g:2878:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalPreprocessParser.g:2879:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
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
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalPreprocessParser.g:2886:1: ruleMultiplicativeExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        Token lv_op_4_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_5_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2889:28: ( ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* ) )
            // InternalPreprocessParser.g:2890:1: ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2890:1: ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* )
            // InternalPreprocessParser.g:2890:2: () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )*
            {
            // InternalPreprocessParser.g:2890:2: ()
            // InternalPreprocessParser.g:2891:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:2899:2: ( (lv_expr_1_0= ruleCastExpression ) )
            // InternalPreprocessParser.g:2900:1: (lv_expr_1_0= ruleCastExpression )
            {
            // InternalPreprocessParser.g:2900:1: (lv_expr_1_0= ruleCastExpression )
            // InternalPreprocessParser.g:2901:3: lv_expr_1_0= ruleCastExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExprCastExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_35);
            lv_expr_1_0=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
              	        }
                     		add(
                     			current, 
                     			"expr",
                      		lv_expr_1_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.CastExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocessParser.g:2917:2: ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_SKW_DIV||LA49_0==RULE_SKW_MOD||LA49_0==RULE_SKW_STAR) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalPreprocessParser.g:2917:3: ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) )
            	    {
            	    // InternalPreprocessParser.g:2917:3: ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) )
            	    int alt48=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_SKW_STAR:
            	        {
            	        alt48=1;
            	        }
            	        break;
            	    case RULE_SKW_DIV:
            	        {
            	        alt48=2;
            	        }
            	        break;
            	    case RULE_SKW_MOD:
            	        {
            	        alt48=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 48, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt48) {
            	        case 1 :
            	            // InternalPreprocessParser.g:2917:4: ( (lv_op_2_0= RULE_SKW_STAR ) )
            	            {
            	            // InternalPreprocessParser.g:2917:4: ( (lv_op_2_0= RULE_SKW_STAR ) )
            	            // InternalPreprocessParser.g:2918:1: (lv_op_2_0= RULE_SKW_STAR )
            	            {
            	            // InternalPreprocessParser.g:2918:1: (lv_op_2_0= RULE_SKW_STAR )
            	            // InternalPreprocessParser.g:2919:3: lv_op_2_0= RULE_SKW_STAR
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_STAR,FOLLOW_24); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_2_0, grammarAccess.getMultiplicativeExpressionAccess().getOpSKW_STARTerminalRuleCall_2_0_0_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"op",
            	                      		lv_op_2_0, 
            	                      		"at.jku.weiner.c.Common.SKW_STAR");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalPreprocessParser.g:2936:6: ( (lv_op_3_0= RULE_SKW_DIV ) )
            	            {
            	            // InternalPreprocessParser.g:2936:6: ( (lv_op_3_0= RULE_SKW_DIV ) )
            	            // InternalPreprocessParser.g:2937:1: (lv_op_3_0= RULE_SKW_DIV )
            	            {
            	            // InternalPreprocessParser.g:2937:1: (lv_op_3_0= RULE_SKW_DIV )
            	            // InternalPreprocessParser.g:2938:3: lv_op_3_0= RULE_SKW_DIV
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_DIV,FOLLOW_24); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_3_0, grammarAccess.getMultiplicativeExpressionAccess().getOpSKW_DIVTerminalRuleCall_2_0_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"op",
            	                      		lv_op_3_0, 
            	                      		"at.jku.weiner.c.Common.SKW_DIV");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalPreprocessParser.g:2955:6: ( (lv_op_4_0= RULE_SKW_MOD ) )
            	            {
            	            // InternalPreprocessParser.g:2955:6: ( (lv_op_4_0= RULE_SKW_MOD ) )
            	            // InternalPreprocessParser.g:2956:1: (lv_op_4_0= RULE_SKW_MOD )
            	            {
            	            // InternalPreprocessParser.g:2956:1: (lv_op_4_0= RULE_SKW_MOD )
            	            // InternalPreprocessParser.g:2957:3: lv_op_4_0= RULE_SKW_MOD
            	            {
            	            lv_op_4_0=(Token)match(input,RULE_SKW_MOD,FOLLOW_24); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_4_0, grammarAccess.getMultiplicativeExpressionAccess().getOpSKW_MODTerminalRuleCall_2_0_2_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"op",
            	                      		lv_op_4_0, 
            	                      		"at.jku.weiner.c.Common.SKW_MOD");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalPreprocessParser.g:2973:3: ( (lv_expr_5_0= ruleCastExpression ) )
            	    // InternalPreprocessParser.g:2974:1: (lv_expr_5_0= ruleCastExpression )
            	    {
            	    // InternalPreprocessParser.g:2974:1: (lv_expr_5_0= ruleCastExpression )
            	    // InternalPreprocessParser.g:2975:3: lv_expr_5_0= ruleCastExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExprCastExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_expr_5_0=ruleCastExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expr",
            	              		lv_expr_5_0, 
            	              		"at.jku.weiner.c.preprocess.Preprocess.CastExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
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
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleCastExpression"
    // InternalPreprocessParser.g:2999:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalPreprocessParser.g:3000:2: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalPreprocessParser.g:3001:2: iv_ruleCastExpression= ruleCastExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCastExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCastExpression=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCastExpression; 
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
    // $ANTLR end "entryRuleCastExpression"


    // $ANTLR start "ruleCastExpression"
    // InternalPreprocessParser.g:3008:1: ruleCastExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:3011:28: ( ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // InternalPreprocessParser.g:3012:1: ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // InternalPreprocessParser.g:3012:1: ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // InternalPreprocessParser.g:3012:2: () ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // InternalPreprocessParser.g:3012:2: ()
            // InternalPreprocessParser.g:3013:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getCastExpressionAccess().getCastExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:3021:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // InternalPreprocessParser.g:3022:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // InternalPreprocessParser.g:3022:1: (lv_expr_1_0= ruleUnaryExpression )
            // InternalPreprocessParser.g:3023:3: lv_expr_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCastExpressionAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_expr_1_0=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCastExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_1_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.UnaryExpression");
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
    // $ANTLR end "ruleCastExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalPreprocessParser.g:3047:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalPreprocessParser.g:3048:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalPreprocessParser.g:3049:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
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
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalPreprocessParser.g:3056:1: ruleUnaryExpression returns [EObject current=null] : ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;

        EObject lv_op_2_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:3059:28: ( ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) ) )
            // InternalPreprocessParser.g:3060:1: ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) )
            {
            // InternalPreprocessParser.g:3060:1: ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) )
            // InternalPreprocessParser.g:3060:2: () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
            {
            // InternalPreprocessParser.g:3060:2: ()
            // InternalPreprocessParser.g:3061:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnaryExpressionAccess().getUnaryExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:3069:2: ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_DEFINED||LA50_0==RULE_ID||(LA50_0>=RULE_CHAR_LITERAL && LA50_0<=RULE_BIN_LITERAL)||LA50_0==RULE_FLOAT_LITERAL||LA50_0==RULE_SKW_LEFTPAREN) ) {
                alt50=1;
            }
            else if ( (LA50_0==RULE_SKW_AND||LA50_0==RULE_SKW_MINUS||LA50_0==RULE_SKW_NOT||LA50_0==RULE_SKW_PLUS||(LA50_0>=RULE_SKW_STAR && LA50_0<=RULE_SKW_TILDE)) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalPreprocessParser.g:3069:3: ( (lv_expr_1_0= rulePostfixExpression ) )
                    {
                    // InternalPreprocessParser.g:3069:3: ( (lv_expr_1_0= rulePostfixExpression ) )
                    // InternalPreprocessParser.g:3070:1: (lv_expr_1_0= rulePostfixExpression )
                    {
                    // InternalPreprocessParser.g:3070:1: (lv_expr_1_0= rulePostfixExpression )
                    // InternalPreprocessParser.g:3071:3: lv_expr_1_0= rulePostfixExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_1_0=rulePostfixExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_1_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.PostfixExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPreprocessParser.g:3088:6: ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
                    {
                    // InternalPreprocessParser.g:3088:6: ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
                    // InternalPreprocessParser.g:3088:7: ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) )
                    {
                    // InternalPreprocessParser.g:3088:7: ( (lv_op_2_0= ruleUnaryOperator ) )
                    // InternalPreprocessParser.g:3089:1: (lv_op_2_0= ruleUnaryOperator )
                    {
                    // InternalPreprocessParser.g:3089:1: (lv_op_2_0= ruleUnaryOperator )
                    // InternalPreprocessParser.g:3090:3: lv_op_2_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_1_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_24);
                    lv_op_2_0=ruleUnaryOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"op",
                              		lv_op_2_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.UnaryOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalPreprocessParser.g:3106:2: ( (lv_expr_3_0= ruleCastExpression ) )
                    // InternalPreprocessParser.g:3107:1: (lv_expr_3_0= ruleCastExpression )
                    {
                    // InternalPreprocessParser.g:3107:1: (lv_expr_3_0= ruleCastExpression )
                    // InternalPreprocessParser.g:3108:3: lv_expr_3_0= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprCastExpressionParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_3_0=ruleCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_3_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.CastExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

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
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRuleUnaryOperator"
    // InternalPreprocessParser.g:3132:1: entryRuleUnaryOperator returns [EObject current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final EObject entryRuleUnaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperator = null;


        try {
            // InternalPreprocessParser.g:3133:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalPreprocessParser.g:3134:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator; 
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
    // $ANTLR end "entryRuleUnaryOperator"


    // $ANTLR start "ruleUnaryOperator"
    // InternalPreprocessParser.g:3141:1: ruleUnaryOperator returns [EObject current=null] : ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) ) ;
    public final EObject ruleUnaryOperator() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_0=null;
        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        Token lv_op_4_0=null;
        Token lv_op_5_0=null;
        Token lv_op_6_0=null;

         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:3144:28: ( ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) ) )
            // InternalPreprocessParser.g:3145:1: ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) )
            {
            // InternalPreprocessParser.g:3145:1: ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) )
            int alt51=6;
            switch ( input.LA(1) ) {
            case RULE_SKW_AND:
                {
                alt51=1;
                }
                break;
            case RULE_SKW_STAR:
                {
                alt51=2;
                }
                break;
            case RULE_SKW_PLUS:
                {
                alt51=3;
                }
                break;
            case RULE_SKW_MINUS:
                {
                alt51=4;
                }
                break;
            case RULE_SKW_TILDE:
                {
                alt51=5;
                }
                break;
            case RULE_SKW_NOT:
                {
                alt51=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalPreprocessParser.g:3145:2: ( () ( (lv_op_1_0= RULE_SKW_AND ) ) )
                    {
                    // InternalPreprocessParser.g:3145:2: ( () ( (lv_op_1_0= RULE_SKW_AND ) ) )
                    // InternalPreprocessParser.g:3145:3: () ( (lv_op_1_0= RULE_SKW_AND ) )
                    {
                    // InternalPreprocessParser.g:3145:3: ()
                    // InternalPreprocessParser.g:3146:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getUnaryOperatorAccess().getUnaryOperatorAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalPreprocessParser.g:3154:2: ( (lv_op_1_0= RULE_SKW_AND ) )
                    // InternalPreprocessParser.g:3155:1: (lv_op_1_0= RULE_SKW_AND )
                    {
                    // InternalPreprocessParser.g:3155:1: (lv_op_1_0= RULE_SKW_AND )
                    // InternalPreprocessParser.g:3156:3: lv_op_1_0= RULE_SKW_AND
                    {
                    lv_op_1_0=(Token)match(input,RULE_SKW_AND,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_op_1_0, grammarAccess.getUnaryOperatorAccess().getOpSKW_ANDTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getUnaryOperatorRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"op",
                              		lv_op_1_0, 
                              		"at.jku.weiner.c.Common.SKW_AND");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPreprocessParser.g:3173:6: ( (lv_op_2_0= RULE_SKW_STAR ) )
                    {
                    // InternalPreprocessParser.g:3173:6: ( (lv_op_2_0= RULE_SKW_STAR ) )
                    // InternalPreprocessParser.g:3174:1: (lv_op_2_0= RULE_SKW_STAR )
                    {
                    // InternalPreprocessParser.g:3174:1: (lv_op_2_0= RULE_SKW_STAR )
                    // InternalPreprocessParser.g:3175:3: lv_op_2_0= RULE_SKW_STAR
                    {
                    lv_op_2_0=(Token)match(input,RULE_SKW_STAR,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_op_2_0, grammarAccess.getUnaryOperatorAccess().getOpSKW_STARTerminalRuleCall_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getUnaryOperatorRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"op",
                              		lv_op_2_0, 
                              		"at.jku.weiner.c.Common.SKW_STAR");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalPreprocessParser.g:3192:6: ( (lv_op_3_0= RULE_SKW_PLUS ) )
                    {
                    // InternalPreprocessParser.g:3192:6: ( (lv_op_3_0= RULE_SKW_PLUS ) )
                    // InternalPreprocessParser.g:3193:1: (lv_op_3_0= RULE_SKW_PLUS )
                    {
                    // InternalPreprocessParser.g:3193:1: (lv_op_3_0= RULE_SKW_PLUS )
                    // InternalPreprocessParser.g:3194:3: lv_op_3_0= RULE_SKW_PLUS
                    {
                    lv_op_3_0=(Token)match(input,RULE_SKW_PLUS,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_op_3_0, grammarAccess.getUnaryOperatorAccess().getOpSKW_PLUSTerminalRuleCall_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getUnaryOperatorRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"op",
                              		lv_op_3_0, 
                              		"at.jku.weiner.c.Common.SKW_PLUS");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalPreprocessParser.g:3211:6: ( (lv_op_4_0= RULE_SKW_MINUS ) )
                    {
                    // InternalPreprocessParser.g:3211:6: ( (lv_op_4_0= RULE_SKW_MINUS ) )
                    // InternalPreprocessParser.g:3212:1: (lv_op_4_0= RULE_SKW_MINUS )
                    {
                    // InternalPreprocessParser.g:3212:1: (lv_op_4_0= RULE_SKW_MINUS )
                    // InternalPreprocessParser.g:3213:3: lv_op_4_0= RULE_SKW_MINUS
                    {
                    lv_op_4_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_op_4_0, grammarAccess.getUnaryOperatorAccess().getOpSKW_MINUSTerminalRuleCall_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getUnaryOperatorRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"op",
                              		lv_op_4_0, 
                              		"at.jku.weiner.c.Common.SKW_MINUS");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalPreprocessParser.g:3230:6: ( (lv_op_5_0= RULE_SKW_TILDE ) )
                    {
                    // InternalPreprocessParser.g:3230:6: ( (lv_op_5_0= RULE_SKW_TILDE ) )
                    // InternalPreprocessParser.g:3231:1: (lv_op_5_0= RULE_SKW_TILDE )
                    {
                    // InternalPreprocessParser.g:3231:1: (lv_op_5_0= RULE_SKW_TILDE )
                    // InternalPreprocessParser.g:3232:3: lv_op_5_0= RULE_SKW_TILDE
                    {
                    lv_op_5_0=(Token)match(input,RULE_SKW_TILDE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_op_5_0, grammarAccess.getUnaryOperatorAccess().getOpSKW_TILDETerminalRuleCall_4_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getUnaryOperatorRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"op",
                              		lv_op_5_0, 
                              		"at.jku.weiner.c.Common.SKW_TILDE");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalPreprocessParser.g:3249:6: ( (lv_op_6_0= RULE_SKW_NOT ) )
                    {
                    // InternalPreprocessParser.g:3249:6: ( (lv_op_6_0= RULE_SKW_NOT ) )
                    // InternalPreprocessParser.g:3250:1: (lv_op_6_0= RULE_SKW_NOT )
                    {
                    // InternalPreprocessParser.g:3250:1: (lv_op_6_0= RULE_SKW_NOT )
                    // InternalPreprocessParser.g:3251:3: lv_op_6_0= RULE_SKW_NOT
                    {
                    lv_op_6_0=(Token)match(input,RULE_SKW_NOT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_op_6_0, grammarAccess.getUnaryOperatorAccess().getOpSKW_NOTTerminalRuleCall_5_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getUnaryOperatorRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"op",
                              		lv_op_6_0, 
                              		"at.jku.weiner.c.Common.SKW_NOT");
                      	    
                    }

                    }


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
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "entryRulePostfixExpression"
    // InternalPreprocessParser.g:3275:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalPreprocessParser.g:3276:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalPreprocessParser.g:3277:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
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
    // $ANTLR end "entryRulePostfixExpression"


    // $ANTLR start "rulePostfixExpression"
    // InternalPreprocessParser.g:3284:1: rulePostfixExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= rulePrimaryExpression ) ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:3287:28: ( ( () ( (lv_expr_1_0= rulePrimaryExpression ) ) ) )
            // InternalPreprocessParser.g:3288:1: ( () ( (lv_expr_1_0= rulePrimaryExpression ) ) )
            {
            // InternalPreprocessParser.g:3288:1: ( () ( (lv_expr_1_0= rulePrimaryExpression ) ) )
            // InternalPreprocessParser.g:3288:2: () ( (lv_expr_1_0= rulePrimaryExpression ) )
            {
            // InternalPreprocessParser.g:3288:2: ()
            // InternalPreprocessParser.g:3289:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPostfixExpressionAccess().getPostfixExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:3297:2: ( (lv_expr_1_0= rulePrimaryExpression ) )
            // InternalPreprocessParser.g:3298:1: (lv_expr_1_0= rulePrimaryExpression )
            {
            // InternalPreprocessParser.g:3298:1: (lv_expr_1_0= rulePrimaryExpression )
            // InternalPreprocessParser.g:3299:3: lv_expr_1_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getExprPrimaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_expr_1_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_1_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.PrimaryExpression");
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
    // $ANTLR end "rulePostfixExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalPreprocessParser.g:3323:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalPreprocessParser.g:3324:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalPreprocessParser.g:3325:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
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
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalPreprocessParser.g:3332:1: rulePrimaryExpression returns [EObject current=null] : ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_defined_1_0=null;
        Token lv_id_2_0=null;
        Token lv_defined_3_0=null;
        Token this_SKW_LEFTPAREN_4=null;
        Token lv_id_5_0=null;
        Token this_SKW_RIGHTPAREN_6=null;
        Token this_SKW_LEFTPAREN_8=null;
        Token this_SKW_RIGHTPAREN_10=null;
        AntlrDatatypeRuleToken lv_const_7_0 = null;

        EObject lv_expr_9_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:3335:28: ( ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) ) )
            // InternalPreprocessParser.g:3336:1: ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) )
            {
            // InternalPreprocessParser.g:3336:1: ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) )
            // InternalPreprocessParser.g:3336:2: () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) )
            {
            // InternalPreprocessParser.g:3336:2: ()
            // InternalPreprocessParser.g:3337:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocessParser.g:3345:2: ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) )
            int alt54=4;
            switch ( input.LA(1) ) {
            case RULE_DEFINED:
                {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==RULE_ID) ) {
                    alt54=1;
                }
                else if ( (LA54_1==RULE_SKW_LEFTPAREN) ) {
                    alt54=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                alt54=1;
                }
                break;
            case RULE_SKW_LEFTPAREN:
                {
                int LA54_3 = input.LA(2);

                if ( (LA54_3==RULE_DEFINED||(LA54_3>=RULE_CHAR_LITERAL && LA54_3<=RULE_BIN_LITERAL)||LA54_3==RULE_FLOAT_LITERAL||LA54_3==RULE_SKW_AND||LA54_3==RULE_SKW_LEFTPAREN||LA54_3==RULE_SKW_MINUS||LA54_3==RULE_SKW_NOT||LA54_3==RULE_SKW_PLUS||(LA54_3>=RULE_SKW_STAR && LA54_3<=RULE_SKW_TILDE)) ) {
                    alt54=4;
                }
                else if ( (LA54_3==RULE_ID) ) {
                    int LA54_7 = input.LA(3);

                    if ( ((LA54_7>=RULE_SKW_AND && LA54_7<=RULE_SKW_ANDAND)||LA54_7==RULE_SKW_CARET||LA54_7==RULE_SKW_DIV||(LA54_7>=RULE_SKW_EQUAL && LA54_7<=RULE_SKW_GREATEREQUAL)||(LA54_7>=RULE_SKW_LEFTSHIFT && LA54_7<=RULE_SKW_MINUS)||LA54_7==RULE_SKW_MOD||(LA54_7>=RULE_SKW_NOTEQUAL && LA54_7<=RULE_SKW_PLUS)||LA54_7==RULE_SKW_QUESTION||LA54_7==RULE_SKW_RIGHTSHIFT||LA54_7==RULE_SKW_STAR) ) {
                        alt54=4;
                    }
                    else if ( (LA54_7==RULE_SKW_RIGHTPAREN) ) {
                        int LA54_8 = input.LA(4);

                        if ( (synpred90_InternalPreprocessParser()) ) {
                            alt54=2;
                        }
                        else if ( (true) ) {
                            alt54=4;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 54, 8, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 54, 7, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_CHAR_LITERAL:
            case RULE_STRING_LITERAL:
            case RULE_HEX_LITERAL:
            case RULE_DECIMAL_LITERAL:
            case RULE_OCTAL_LITERAL:
            case RULE_BIN_LITERAL:
            case RULE_FLOAT_LITERAL:
                {
                alt54=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // InternalPreprocessParser.g:3345:3: ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) )
                    {
                    // InternalPreprocessParser.g:3345:3: ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) )
                    // InternalPreprocessParser.g:3345:4: ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) )
                    {
                    // InternalPreprocessParser.g:3345:4: ( (lv_defined_1_0= RULE_DEFINED ) )?
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==RULE_DEFINED) ) {
                        alt52=1;
                    }
                    switch (alt52) {
                        case 1 :
                            // InternalPreprocessParser.g:3346:1: (lv_defined_1_0= RULE_DEFINED )
                            {
                            // InternalPreprocessParser.g:3346:1: (lv_defined_1_0= RULE_DEFINED )
                            // InternalPreprocessParser.g:3347:3: lv_defined_1_0= RULE_DEFINED
                            {
                            lv_defined_1_0=(Token)match(input,RULE_DEFINED,FOLLOW_36); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_defined_1_0, grammarAccess.getPrimaryExpressionAccess().getDefinedDEFINEDTerminalRuleCall_1_0_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"defined",
                                      		true, 
                                      		"at.jku.weiner.c.preprocess.Preprocess.DEFINED");
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // InternalPreprocessParser.g:3363:3: ( (lv_id_2_0= RULE_ID ) )
                    // InternalPreprocessParser.g:3364:1: (lv_id_2_0= RULE_ID )
                    {
                    // InternalPreprocessParser.g:3364:1: (lv_id_2_0= RULE_ID )
                    // InternalPreprocessParser.g:3365:3: lv_id_2_0= RULE_ID
                    {
                    lv_id_2_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_id_2_0, grammarAccess.getPrimaryExpressionAccess().getIdIDTerminalRuleCall_1_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"id",
                              		lv_id_2_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.ID");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPreprocessParser.g:3382:6: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
                    {
                    // InternalPreprocessParser.g:3382:6: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
                    // InternalPreprocessParser.g:3382:7: ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN
                    {
                    // InternalPreprocessParser.g:3382:7: ( (lv_defined_3_0= RULE_DEFINED ) )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==RULE_DEFINED) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // InternalPreprocessParser.g:3383:1: (lv_defined_3_0= RULE_DEFINED )
                            {
                            // InternalPreprocessParser.g:3383:1: (lv_defined_3_0= RULE_DEFINED )
                            // InternalPreprocessParser.g:3384:3: lv_defined_3_0= RULE_DEFINED
                            {
                            lv_defined_3_0=(Token)match(input,RULE_DEFINED,FOLLOW_12); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_defined_3_0, grammarAccess.getPrimaryExpressionAccess().getDefinedDEFINEDTerminalRuleCall_1_1_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"defined",
                                      		true, 
                                      		"at.jku.weiner.c.preprocess.Preprocess.DEFINED");
                              	    
                            }

                            }


                            }
                            break;

                    }

                    this_SKW_LEFTPAREN_4=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LEFTPAREN_4, grammarAccess.getPrimaryExpressionAccess().getSKW_LEFTPARENTerminalRuleCall_1_1_1()); 
                          
                    }
                    // InternalPreprocessParser.g:3404:1: ( (lv_id_5_0= RULE_ID ) )
                    // InternalPreprocessParser.g:3405:1: (lv_id_5_0= RULE_ID )
                    {
                    // InternalPreprocessParser.g:3405:1: (lv_id_5_0= RULE_ID )
                    // InternalPreprocessParser.g:3406:3: lv_id_5_0= RULE_ID
                    {
                    lv_id_5_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_id_5_0, grammarAccess.getPrimaryExpressionAccess().getIdIDTerminalRuleCall_1_1_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"id",
                              		lv_id_5_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.ID");
                      	    
                    }

                    }


                    }

                    this_SKW_RIGHTPAREN_6=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_RIGHTPAREN_6, grammarAccess.getPrimaryExpressionAccess().getSKW_RIGHTPARENTerminalRuleCall_1_1_3()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPreprocessParser.g:3427:6: ( (lv_const_7_0= ruleConstant ) )
                    {
                    // InternalPreprocessParser.g:3427:6: ( (lv_const_7_0= ruleConstant ) )
                    // InternalPreprocessParser.g:3428:1: (lv_const_7_0= ruleConstant )
                    {
                    // InternalPreprocessParser.g:3428:1: (lv_const_7_0= ruleConstant )
                    // InternalPreprocessParser.g:3429:3: lv_const_7_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getConstConstantParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_const_7_0=ruleConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"const",
                              		lv_const_7_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.Constant");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalPreprocessParser.g:3446:6: (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN )
                    {
                    // InternalPreprocessParser.g:3446:6: (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN )
                    // InternalPreprocessParser.g:3446:7: this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN
                    {
                    this_SKW_LEFTPAREN_8=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LEFTPAREN_8, grammarAccess.getPrimaryExpressionAccess().getSKW_LEFTPARENTerminalRuleCall_1_3_0()); 
                          
                    }
                    // InternalPreprocessParser.g:3450:1: ( (lv_expr_9_0= ruleExpression ) )
                    // InternalPreprocessParser.g:3451:1: (lv_expr_9_0= ruleExpression )
                    {
                    // InternalPreprocessParser.g:3451:1: (lv_expr_9_0= ruleExpression )
                    // InternalPreprocessParser.g:3452:3: lv_expr_9_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExprExpressionParserRuleCall_1_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_14);
                    lv_expr_9_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_9_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_SKW_RIGHTPAREN_10=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_RIGHTPAREN_10, grammarAccess.getPrimaryExpressionAccess().getSKW_RIGHTPARENTerminalRuleCall_1_3_2()); 
                          
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
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleConstant"
    // InternalPreprocessParser.g:3480:1: entryRuleConstant returns [String current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final String entryRuleConstant() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConstant = null;


        try {
            // InternalPreprocessParser.g:3481:1: (iv_ruleConstant= ruleConstant EOF )
            // InternalPreprocessParser.g:3482:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant.getText(); 
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
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalPreprocessParser.g:3489:1: ruleConstant returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL ) ;
    public final AntlrDatatypeRuleToken ruleConstant() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_LITERAL_0=null;
        Token this_OCTAL_LITERAL_1=null;
        Token this_DECIMAL_LITERAL_2=null;
        Token this_CHAR_LITERAL_3=null;
        Token this_STRING_LITERAL_4=null;
        Token this_FLOAT_LITERAL_5=null;
        Token this_BIN_LITERAL_6=null;

         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:3493:6: ( (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL ) )
            // InternalPreprocessParser.g:3494:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL )
            {
            // InternalPreprocessParser.g:3494:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL )
            int alt55=7;
            switch ( input.LA(1) ) {
            case RULE_HEX_LITERAL:
                {
                alt55=1;
                }
                break;
            case RULE_OCTAL_LITERAL:
                {
                alt55=2;
                }
                break;
            case RULE_DECIMAL_LITERAL:
                {
                alt55=3;
                }
                break;
            case RULE_CHAR_LITERAL:
                {
                alt55=4;
                }
                break;
            case RULE_STRING_LITERAL:
                {
                alt55=5;
                }
                break;
            case RULE_FLOAT_LITERAL:
                {
                alt55=6;
                }
                break;
            case RULE_BIN_LITERAL:
                {
                alt55=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalPreprocessParser.g:3494:6: this_HEX_LITERAL_0= RULE_HEX_LITERAL
                    {
                    this_HEX_LITERAL_0=(Token)match(input,RULE_HEX_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEX_LITERAL_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEX_LITERAL_0, grammarAccess.getConstantAccess().getHEX_LITERALTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalPreprocessParser.g:3502:10: this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL
                    {
                    this_OCTAL_LITERAL_1=(Token)match(input,RULE_OCTAL_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_OCTAL_LITERAL_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_OCTAL_LITERAL_1, grammarAccess.getConstantAccess().getOCTAL_LITERALTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalPreprocessParser.g:3510:10: this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL
                    {
                    this_DECIMAL_LITERAL_2=(Token)match(input,RULE_DECIMAL_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DECIMAL_LITERAL_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DECIMAL_LITERAL_2, grammarAccess.getConstantAccess().getDECIMAL_LITERALTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalPreprocessParser.g:3518:10: this_CHAR_LITERAL_3= RULE_CHAR_LITERAL
                    {
                    this_CHAR_LITERAL_3=(Token)match(input,RULE_CHAR_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_CHAR_LITERAL_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_CHAR_LITERAL_3, grammarAccess.getConstantAccess().getCHAR_LITERALTerminalRuleCall_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalPreprocessParser.g:3526:10: this_STRING_LITERAL_4= RULE_STRING_LITERAL
                    {
                    this_STRING_LITERAL_4=(Token)match(input,RULE_STRING_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_STRING_LITERAL_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_STRING_LITERAL_4, grammarAccess.getConstantAccess().getSTRING_LITERALTerminalRuleCall_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalPreprocessParser.g:3534:10: this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL
                    {
                    this_FLOAT_LITERAL_5=(Token)match(input,RULE_FLOAT_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_FLOAT_LITERAL_5);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_FLOAT_LITERAL_5, grammarAccess.getConstantAccess().getFLOAT_LITERALTerminalRuleCall_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalPreprocessParser.g:3542:10: this_BIN_LITERAL_6= RULE_BIN_LITERAL
                    {
                    this_BIN_LITERAL_6=(Token)match(input,RULE_BIN_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BIN_LITERAL_6);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BIN_LITERAL_6, grammarAccess.getConstantAccess().getBIN_LITERALTerminalRuleCall_6()); 
                          
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
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleSpecialKeywords"
    // InternalPreprocessParser.g:3559:1: entryRuleSpecialKeywords returns [String current=null] : iv_ruleSpecialKeywords= ruleSpecialKeywords EOF ;
    public final String entryRuleSpecialKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpecialKeywords = null;


        try {
            // InternalPreprocessParser.g:3560:1: (iv_ruleSpecialKeywords= ruleSpecialKeywords EOF )
            // InternalPreprocessParser.g:3561:2: iv_ruleSpecialKeywords= ruleSpecialKeywords EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpecialKeywordsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSpecialKeywords=ruleSpecialKeywords();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpecialKeywords.getText(); 
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
    // $ANTLR end "entryRuleSpecialKeywords"


    // $ANTLR start "ruleSpecialKeywords"
    // InternalPreprocessParser.g:3568:1: ruleSpecialKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE ) ;
    public final AntlrDatatypeRuleToken ruleSpecialKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_AND_0=null;
        Token this_SKW_ANDAND_1=null;
        Token this_SKW_ASSIGN_2=null;
        Token this_SKW_BACKSLASH_3=null;
        Token this_SKW_CARET_4=null;
        Token this_SKW_COMMA_5=null;
        Token this_SKW_COLON_6=null;
        Token this_SKW_DIV_7=null;
        Token this_SKW_DOT_8=null;
        Token this_SKW_DOUBLEQUOTE_9=null;
        Token this_SKW_EQUAL_10=null;
        Token this_SKW_GREATER_11=null;
        Token this_SKW_GREATEREQUAL_12=null;
        Token this_SKW_LEFTBRACE_13=null;
        Token this_SKW_LEFTBRACKET_14=null;
        Token this_SKW_LEFTPAREN_15=null;
        Token this_SKW_LEFTSHIFT_16=null;
        Token this_SKW_LESS_17=null;
        Token this_SKW_LESSEQUAL_18=null;
        Token this_SKW_MINUS_19=null;
        Token this_SKW_MINUSMINUS_20=null;
        Token this_SKW_MOD_21=null;
        Token this_SKW_NOT_22=null;
        Token this_SKW_NOTEQUAL_23=null;
        Token this_SKW_OR_24=null;
        Token this_SKW_OROR_25=null;
        Token this_SKW_PLUS_26=null;
        Token this_SKW_PLUSPLUS_27=null;
        Token this_SKW_QUESTION_28=null;
        Token this_SKW_RIGHTBRACE_29=null;
        Token this_SKW_RIGHTBRACKET_30=null;
        Token this_SKW_RIGHTPAREN_31=null;
        Token this_SKW_RIGHTSHIFT_32=null;
        Token this_SKW_SEMI_33=null;
        Token this_SKW_SINGLEQUOTE_34=null;
        Token this_SKW_STAR_35=null;
        Token this_SKW_TILDE_36=null;

         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:3572:6: ( (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE ) )
            // InternalPreprocessParser.g:3573:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE )
            {
            // InternalPreprocessParser.g:3573:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE )
            int alt56=37;
            switch ( input.LA(1) ) {
            case RULE_SKW_AND:
                {
                alt56=1;
                }
                break;
            case RULE_SKW_ANDAND:
                {
                alt56=2;
                }
                break;
            case RULE_SKW_ASSIGN:
                {
                alt56=3;
                }
                break;
            case RULE_SKW_BACKSLASH:
                {
                alt56=4;
                }
                break;
            case RULE_SKW_CARET:
                {
                alt56=5;
                }
                break;
            case RULE_SKW_COMMA:
                {
                alt56=6;
                }
                break;
            case RULE_SKW_COLON:
                {
                alt56=7;
                }
                break;
            case RULE_SKW_DIV:
                {
                alt56=8;
                }
                break;
            case RULE_SKW_DOT:
                {
                alt56=9;
                }
                break;
            case RULE_SKW_DOUBLEQUOTE:
                {
                alt56=10;
                }
                break;
            case RULE_SKW_EQUAL:
                {
                alt56=11;
                }
                break;
            case RULE_SKW_GREATER:
                {
                alt56=12;
                }
                break;
            case RULE_SKW_GREATEREQUAL:
                {
                alt56=13;
                }
                break;
            case RULE_SKW_LEFTBRACE:
                {
                alt56=14;
                }
                break;
            case RULE_SKW_LEFTBRACKET:
                {
                alt56=15;
                }
                break;
            case RULE_SKW_LEFTPAREN:
                {
                alt56=16;
                }
                break;
            case RULE_SKW_LEFTSHIFT:
                {
                alt56=17;
                }
                break;
            case RULE_SKW_LESS:
                {
                alt56=18;
                }
                break;
            case RULE_SKW_LESSEQUAL:
                {
                alt56=19;
                }
                break;
            case RULE_SKW_MINUS:
                {
                alt56=20;
                }
                break;
            case RULE_SKW_MINUSMINUS:
                {
                alt56=21;
                }
                break;
            case RULE_SKW_MOD:
                {
                alt56=22;
                }
                break;
            case RULE_SKW_NOT:
                {
                alt56=23;
                }
                break;
            case RULE_SKW_NOTEQUAL:
                {
                alt56=24;
                }
                break;
            case RULE_SKW_OR:
                {
                alt56=25;
                }
                break;
            case RULE_SKW_OROR:
                {
                alt56=26;
                }
                break;
            case RULE_SKW_PLUS:
                {
                alt56=27;
                }
                break;
            case RULE_SKW_PLUSPLUS:
                {
                alt56=28;
                }
                break;
            case RULE_SKW_QUESTION:
                {
                alt56=29;
                }
                break;
            case RULE_SKW_RIGHTBRACE:
                {
                alt56=30;
                }
                break;
            case RULE_SKW_RIGHTBRACKET:
                {
                alt56=31;
                }
                break;
            case RULE_SKW_RIGHTPAREN:
                {
                alt56=32;
                }
                break;
            case RULE_SKW_RIGHTSHIFT:
                {
                alt56=33;
                }
                break;
            case RULE_SKW_SEMI:
                {
                alt56=34;
                }
                break;
            case RULE_SKW_SINGLEQUOTE:
                {
                alt56=35;
                }
                break;
            case RULE_SKW_STAR:
                {
                alt56=36;
                }
                break;
            case RULE_SKW_TILDE:
                {
                alt56=37;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalPreprocessParser.g:3573:6: this_SKW_AND_0= RULE_SKW_AND
                    {
                    this_SKW_AND_0=(Token)match(input,RULE_SKW_AND,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_AND_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_AND_0, grammarAccess.getSpecialKeywordsAccess().getSKW_ANDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalPreprocessParser.g:3581:10: this_SKW_ANDAND_1= RULE_SKW_ANDAND
                    {
                    this_SKW_ANDAND_1=(Token)match(input,RULE_SKW_ANDAND,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_ANDAND_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_ANDAND_1, grammarAccess.getSpecialKeywordsAccess().getSKW_ANDANDTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalPreprocessParser.g:3589:10: this_SKW_ASSIGN_2= RULE_SKW_ASSIGN
                    {
                    this_SKW_ASSIGN_2=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_ASSIGN_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_ASSIGN_2, grammarAccess.getSpecialKeywordsAccess().getSKW_ASSIGNTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalPreprocessParser.g:3597:10: this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH
                    {
                    this_SKW_BACKSLASH_3=(Token)match(input,RULE_SKW_BACKSLASH,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_BACKSLASH_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_BACKSLASH_3, grammarAccess.getSpecialKeywordsAccess().getSKW_BACKSLASHTerminalRuleCall_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalPreprocessParser.g:3605:10: this_SKW_CARET_4= RULE_SKW_CARET
                    {
                    this_SKW_CARET_4=(Token)match(input,RULE_SKW_CARET,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_CARET_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_CARET_4, grammarAccess.getSpecialKeywordsAccess().getSKW_CARETTerminalRuleCall_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalPreprocessParser.g:3613:10: this_SKW_COMMA_5= RULE_SKW_COMMA
                    {
                    this_SKW_COMMA_5=(Token)match(input,RULE_SKW_COMMA,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_COMMA_5);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_COMMA_5, grammarAccess.getSpecialKeywordsAccess().getSKW_COMMATerminalRuleCall_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalPreprocessParser.g:3621:10: this_SKW_COLON_6= RULE_SKW_COLON
                    {
                    this_SKW_COLON_6=(Token)match(input,RULE_SKW_COLON,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_COLON_6);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_COLON_6, grammarAccess.getSpecialKeywordsAccess().getSKW_COLONTerminalRuleCall_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalPreprocessParser.g:3629:10: this_SKW_DIV_7= RULE_SKW_DIV
                    {
                    this_SKW_DIV_7=(Token)match(input,RULE_SKW_DIV,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_DIV_7);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_DIV_7, grammarAccess.getSpecialKeywordsAccess().getSKW_DIVTerminalRuleCall_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalPreprocessParser.g:3637:10: this_SKW_DOT_8= RULE_SKW_DOT
                    {
                    this_SKW_DOT_8=(Token)match(input,RULE_SKW_DOT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_DOT_8);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_DOT_8, grammarAccess.getSpecialKeywordsAccess().getSKW_DOTTerminalRuleCall_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalPreprocessParser.g:3645:10: this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE
                    {
                    this_SKW_DOUBLEQUOTE_9=(Token)match(input,RULE_SKW_DOUBLEQUOTE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_DOUBLEQUOTE_9);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_DOUBLEQUOTE_9, grammarAccess.getSpecialKeywordsAccess().getSKW_DOUBLEQUOTETerminalRuleCall_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalPreprocessParser.g:3653:10: this_SKW_EQUAL_10= RULE_SKW_EQUAL
                    {
                    this_SKW_EQUAL_10=(Token)match(input,RULE_SKW_EQUAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_EQUAL_10);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_EQUAL_10, grammarAccess.getSpecialKeywordsAccess().getSKW_EQUALTerminalRuleCall_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // InternalPreprocessParser.g:3661:10: this_SKW_GREATER_11= RULE_SKW_GREATER
                    {
                    this_SKW_GREATER_11=(Token)match(input,RULE_SKW_GREATER,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_GREATER_11);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_GREATER_11, grammarAccess.getSpecialKeywordsAccess().getSKW_GREATERTerminalRuleCall_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // InternalPreprocessParser.g:3669:10: this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL
                    {
                    this_SKW_GREATEREQUAL_12=(Token)match(input,RULE_SKW_GREATEREQUAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_GREATEREQUAL_12);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_GREATEREQUAL_12, grammarAccess.getSpecialKeywordsAccess().getSKW_GREATEREQUALTerminalRuleCall_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // InternalPreprocessParser.g:3677:10: this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE
                    {
                    this_SKW_LEFTBRACE_13=(Token)match(input,RULE_SKW_LEFTBRACE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_LEFTBRACE_13);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LEFTBRACE_13, grammarAccess.getSpecialKeywordsAccess().getSKW_LEFTBRACETerminalRuleCall_13()); 
                          
                    }

                    }
                    break;
                case 15 :
                    // InternalPreprocessParser.g:3685:10: this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET
                    {
                    this_SKW_LEFTBRACKET_14=(Token)match(input,RULE_SKW_LEFTBRACKET,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_LEFTBRACKET_14);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LEFTBRACKET_14, grammarAccess.getSpecialKeywordsAccess().getSKW_LEFTBRACKETTerminalRuleCall_14()); 
                          
                    }

                    }
                    break;
                case 16 :
                    // InternalPreprocessParser.g:3693:10: this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN
                    {
                    this_SKW_LEFTPAREN_15=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_LEFTPAREN_15);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LEFTPAREN_15, grammarAccess.getSpecialKeywordsAccess().getSKW_LEFTPARENTerminalRuleCall_15()); 
                          
                    }

                    }
                    break;
                case 17 :
                    // InternalPreprocessParser.g:3701:10: this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT
                    {
                    this_SKW_LEFTSHIFT_16=(Token)match(input,RULE_SKW_LEFTSHIFT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_LEFTSHIFT_16);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LEFTSHIFT_16, grammarAccess.getSpecialKeywordsAccess().getSKW_LEFTSHIFTTerminalRuleCall_16()); 
                          
                    }

                    }
                    break;
                case 18 :
                    // InternalPreprocessParser.g:3709:10: this_SKW_LESS_17= RULE_SKW_LESS
                    {
                    this_SKW_LESS_17=(Token)match(input,RULE_SKW_LESS,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_LESS_17);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LESS_17, grammarAccess.getSpecialKeywordsAccess().getSKW_LESSTerminalRuleCall_17()); 
                          
                    }

                    }
                    break;
                case 19 :
                    // InternalPreprocessParser.g:3717:10: this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL
                    {
                    this_SKW_LESSEQUAL_18=(Token)match(input,RULE_SKW_LESSEQUAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_LESSEQUAL_18);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LESSEQUAL_18, grammarAccess.getSpecialKeywordsAccess().getSKW_LESSEQUALTerminalRuleCall_18()); 
                          
                    }

                    }
                    break;
                case 20 :
                    // InternalPreprocessParser.g:3725:10: this_SKW_MINUS_19= RULE_SKW_MINUS
                    {
                    this_SKW_MINUS_19=(Token)match(input,RULE_SKW_MINUS,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_MINUS_19);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_MINUS_19, grammarAccess.getSpecialKeywordsAccess().getSKW_MINUSTerminalRuleCall_19()); 
                          
                    }

                    }
                    break;
                case 21 :
                    // InternalPreprocessParser.g:3733:10: this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS
                    {
                    this_SKW_MINUSMINUS_20=(Token)match(input,RULE_SKW_MINUSMINUS,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_MINUSMINUS_20);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_MINUSMINUS_20, grammarAccess.getSpecialKeywordsAccess().getSKW_MINUSMINUSTerminalRuleCall_20()); 
                          
                    }

                    }
                    break;
                case 22 :
                    // InternalPreprocessParser.g:3741:10: this_SKW_MOD_21= RULE_SKW_MOD
                    {
                    this_SKW_MOD_21=(Token)match(input,RULE_SKW_MOD,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_MOD_21);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_MOD_21, grammarAccess.getSpecialKeywordsAccess().getSKW_MODTerminalRuleCall_21()); 
                          
                    }

                    }
                    break;
                case 23 :
                    // InternalPreprocessParser.g:3749:10: this_SKW_NOT_22= RULE_SKW_NOT
                    {
                    this_SKW_NOT_22=(Token)match(input,RULE_SKW_NOT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_NOT_22);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_NOT_22, grammarAccess.getSpecialKeywordsAccess().getSKW_NOTTerminalRuleCall_22()); 
                          
                    }

                    }
                    break;
                case 24 :
                    // InternalPreprocessParser.g:3757:10: this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL
                    {
                    this_SKW_NOTEQUAL_23=(Token)match(input,RULE_SKW_NOTEQUAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_NOTEQUAL_23);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_NOTEQUAL_23, grammarAccess.getSpecialKeywordsAccess().getSKW_NOTEQUALTerminalRuleCall_23()); 
                          
                    }

                    }
                    break;
                case 25 :
                    // InternalPreprocessParser.g:3765:10: this_SKW_OR_24= RULE_SKW_OR
                    {
                    this_SKW_OR_24=(Token)match(input,RULE_SKW_OR,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_OR_24);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_OR_24, grammarAccess.getSpecialKeywordsAccess().getSKW_ORTerminalRuleCall_24()); 
                          
                    }

                    }
                    break;
                case 26 :
                    // InternalPreprocessParser.g:3773:10: this_SKW_OROR_25= RULE_SKW_OROR
                    {
                    this_SKW_OROR_25=(Token)match(input,RULE_SKW_OROR,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_OROR_25);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_OROR_25, grammarAccess.getSpecialKeywordsAccess().getSKW_ORORTerminalRuleCall_25()); 
                          
                    }

                    }
                    break;
                case 27 :
                    // InternalPreprocessParser.g:3781:10: this_SKW_PLUS_26= RULE_SKW_PLUS
                    {
                    this_SKW_PLUS_26=(Token)match(input,RULE_SKW_PLUS,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_PLUS_26);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_PLUS_26, grammarAccess.getSpecialKeywordsAccess().getSKW_PLUSTerminalRuleCall_26()); 
                          
                    }

                    }
                    break;
                case 28 :
                    // InternalPreprocessParser.g:3789:10: this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS
                    {
                    this_SKW_PLUSPLUS_27=(Token)match(input,RULE_SKW_PLUSPLUS,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_PLUSPLUS_27);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_PLUSPLUS_27, grammarAccess.getSpecialKeywordsAccess().getSKW_PLUSPLUSTerminalRuleCall_27()); 
                          
                    }

                    }
                    break;
                case 29 :
                    // InternalPreprocessParser.g:3797:10: this_SKW_QUESTION_28= RULE_SKW_QUESTION
                    {
                    this_SKW_QUESTION_28=(Token)match(input,RULE_SKW_QUESTION,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_QUESTION_28);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_QUESTION_28, grammarAccess.getSpecialKeywordsAccess().getSKW_QUESTIONTerminalRuleCall_28()); 
                          
                    }

                    }
                    break;
                case 30 :
                    // InternalPreprocessParser.g:3805:10: this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE
                    {
                    this_SKW_RIGHTBRACE_29=(Token)match(input,RULE_SKW_RIGHTBRACE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_RIGHTBRACE_29);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_RIGHTBRACE_29, grammarAccess.getSpecialKeywordsAccess().getSKW_RIGHTBRACETerminalRuleCall_29()); 
                          
                    }

                    }
                    break;
                case 31 :
                    // InternalPreprocessParser.g:3813:10: this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET
                    {
                    this_SKW_RIGHTBRACKET_30=(Token)match(input,RULE_SKW_RIGHTBRACKET,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_RIGHTBRACKET_30);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_RIGHTBRACKET_30, grammarAccess.getSpecialKeywordsAccess().getSKW_RIGHTBRACKETTerminalRuleCall_30()); 
                          
                    }

                    }
                    break;
                case 32 :
                    // InternalPreprocessParser.g:3821:10: this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN
                    {
                    this_SKW_RIGHTPAREN_31=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_RIGHTPAREN_31);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_RIGHTPAREN_31, grammarAccess.getSpecialKeywordsAccess().getSKW_RIGHTPARENTerminalRuleCall_31()); 
                          
                    }

                    }
                    break;
                case 33 :
                    // InternalPreprocessParser.g:3829:10: this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT
                    {
                    this_SKW_RIGHTSHIFT_32=(Token)match(input,RULE_SKW_RIGHTSHIFT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_RIGHTSHIFT_32);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_RIGHTSHIFT_32, grammarAccess.getSpecialKeywordsAccess().getSKW_RIGHTSHIFTTerminalRuleCall_32()); 
                          
                    }

                    }
                    break;
                case 34 :
                    // InternalPreprocessParser.g:3837:10: this_SKW_SEMI_33= RULE_SKW_SEMI
                    {
                    this_SKW_SEMI_33=(Token)match(input,RULE_SKW_SEMI,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_SEMI_33);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_SEMI_33, grammarAccess.getSpecialKeywordsAccess().getSKW_SEMITerminalRuleCall_33()); 
                          
                    }

                    }
                    break;
                case 35 :
                    // InternalPreprocessParser.g:3845:10: this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE
                    {
                    this_SKW_SINGLEQUOTE_34=(Token)match(input,RULE_SKW_SINGLEQUOTE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_SINGLEQUOTE_34);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_SINGLEQUOTE_34, grammarAccess.getSpecialKeywordsAccess().getSKW_SINGLEQUOTETerminalRuleCall_34()); 
                          
                    }

                    }
                    break;
                case 36 :
                    // InternalPreprocessParser.g:3853:10: this_SKW_STAR_35= RULE_SKW_STAR
                    {
                    this_SKW_STAR_35=(Token)match(input,RULE_SKW_STAR,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_STAR_35);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_STAR_35, grammarAccess.getSpecialKeywordsAccess().getSKW_STARTerminalRuleCall_35()); 
                          
                    }

                    }
                    break;
                case 37 :
                    // InternalPreprocessParser.g:3861:10: this_SKW_TILDE_36= RULE_SKW_TILDE
                    {
                    this_SKW_TILDE_36=(Token)match(input,RULE_SKW_TILDE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_TILDE_36);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_TILDE_36, grammarAccess.getSpecialKeywordsAccess().getSKW_TILDETerminalRuleCall_36()); 
                          
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
    // $ANTLR end "ruleSpecialKeywords"

    // $ANTLR start synpred2_InternalPreprocessParser
    public final void synpred2_InternalPreprocessParser_fragment() throws RecognitionException {   
        EObject lv_lines_2_0 = null;


        // InternalPreprocessParser.g:204:6: ( ( (lv_lines_2_0= ruleNewLineLine ) ) )
        // InternalPreprocessParser.g:204:6: ( (lv_lines_2_0= ruleNewLineLine ) )
        {
        // InternalPreprocessParser.g:204:6: ( (lv_lines_2_0= ruleNewLineLine ) )
        // InternalPreprocessParser.g:205:1: (lv_lines_2_0= ruleNewLineLine )
        {
        // InternalPreprocessParser.g:205:1: (lv_lines_2_0= ruleNewLineLine )
        // InternalPreprocessParser.g:206:3: lv_lines_2_0= ruleNewLineLine
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
    // $ANTLR end synpred2_InternalPreprocessParser

    // $ANTLR start synpred3_InternalPreprocessParser
    public final void synpred3_InternalPreprocessParser_fragment() throws RecognitionException {   
        EObject lv_lines_3_0 = null;


        // InternalPreprocessParser.g:223:6: ( ( (lv_lines_3_0= ruleCode ) ) )
        // InternalPreprocessParser.g:223:6: ( (lv_lines_3_0= ruleCode ) )
        {
        // InternalPreprocessParser.g:223:6: ( (lv_lines_3_0= ruleCode ) )
        // InternalPreprocessParser.g:224:1: (lv_lines_3_0= ruleCode )
        {
        // InternalPreprocessParser.g:224:1: (lv_lines_3_0= ruleCode )
        // InternalPreprocessParser.g:225:3: lv_lines_3_0= ruleCode
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
    // $ANTLR end synpred3_InternalPreprocessParser

    // $ANTLR start synpred12_InternalPreprocessParser
    public final void synpred12_InternalPreprocessParser_fragment() throws RecognitionException {   
        Token this_WS_2=null;

        // InternalPreprocessParser.g:453:2: (this_WS_2= RULE_WS )
        // InternalPreprocessParser.g:453:2: this_WS_2= RULE_WS
        {
        this_WS_2=(Token)match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_InternalPreprocessParser

    // $ANTLR start synpred15_InternalPreprocessParser
    public final void synpred15_InternalPreprocessParser_fragment() throws RecognitionException {   
        Token this_WS_4=null;

        // InternalPreprocessParser.g:577:4: (this_WS_4= RULE_WS )
        // InternalPreprocessParser.g:577:4: this_WS_4= RULE_WS
        {
        this_WS_4=(Token)match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalPreprocessParser

    // $ANTLR start synpred20_InternalPreprocessParser
    public final void synpred20_InternalPreprocessParser_fragment() throws RecognitionException {   
        Token this_WS_8=null;

        // InternalPreprocessParser.g:685:2: (this_WS_8= RULE_WS )
        // InternalPreprocessParser.g:685:2: this_WS_8= RULE_WS
        {
        this_WS_8=(Token)match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_InternalPreprocessParser

    // $ANTLR start synpred23_InternalPreprocessParser
    public final void synpred23_InternalPreprocessParser_fragment() throws RecognitionException {   
        Token this_WS_2=null;

        // InternalPreprocessParser.g:815:2: (this_WS_2= RULE_WS )
        // InternalPreprocessParser.g:815:2: this_WS_2= RULE_WS
        {
        this_WS_2=(Token)match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_InternalPreprocessParser

    // $ANTLR start synpred29_InternalPreprocessParser
    public final void synpred29_InternalPreprocessParser_fragment() throws RecognitionException {   
        // InternalPreprocessParser.g:1010:4: ( ( RULE_HASHRULE_ENDIF ) )
        // InternalPreprocessParser.g:1010:5: ( RULE_HASHRULE_ENDIF )
        {
        // InternalPreprocessParser.g:1010:5: ( RULE_HASHRULE_ENDIF )
        // InternalPreprocessParser.g:1010:6: RULE_HASHRULE_ENDIF
        {
        match(input,RULE_HASHRULE_ENDIF,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred29_InternalPreprocessParser

    // $ANTLR start synpred56_InternalPreprocessParser
    public final void synpred56_InternalPreprocessParser_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_MyCode_0 = null;


        // InternalPreprocessParser.g:1761:5: (this_MyCode_0= ruleMyCode )
        // InternalPreprocessParser.g:1761:5: this_MyCode_0= ruleMyCode
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
    // $ANTLR end synpred56_InternalPreprocessParser

    // $ANTLR start synpred57_InternalPreprocessParser
    public final void synpred57_InternalPreprocessParser_fragment() throws RecognitionException {   
        Token this_WS_1=null;

        // InternalPreprocessParser.g:1772:10: (this_WS_1= RULE_WS )
        // InternalPreprocessParser.g:1772:10: this_WS_1= RULE_WS
        {
        this_WS_1=(Token)match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_InternalPreprocessParser

    // $ANTLR start synpred90_InternalPreprocessParser
    public final void synpred90_InternalPreprocessParser_fragment() throws RecognitionException {   
        Token lv_defined_3_0=null;
        Token this_SKW_LEFTPAREN_4=null;
        Token lv_id_5_0=null;
        Token this_SKW_RIGHTPAREN_6=null;

        // InternalPreprocessParser.g:3382:6: ( ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) )
        // InternalPreprocessParser.g:3382:6: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
        {
        // InternalPreprocessParser.g:3382:6: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
        // InternalPreprocessParser.g:3382:7: ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN
        {
        // InternalPreprocessParser.g:3382:7: ( (lv_defined_3_0= RULE_DEFINED ) )?
        int alt68=2;
        int LA68_0 = input.LA(1);

        if ( (LA68_0==RULE_DEFINED) ) {
            alt68=1;
        }
        switch (alt68) {
            case 1 :
                // InternalPreprocessParser.g:3383:1: (lv_defined_3_0= RULE_DEFINED )
                {
                // InternalPreprocessParser.g:3383:1: (lv_defined_3_0= RULE_DEFINED )
                // InternalPreprocessParser.g:3384:3: lv_defined_3_0= RULE_DEFINED
                {
                lv_defined_3_0=(Token)match(input,RULE_DEFINED,FOLLOW_12); if (state.failed) return ;

                }


                }
                break;

        }

        this_SKW_LEFTPAREN_4=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_36); if (state.failed) return ;
        // InternalPreprocessParser.g:3404:1: ( (lv_id_5_0= RULE_ID ) )
        // InternalPreprocessParser.g:3405:1: (lv_id_5_0= RULE_ID )
        {
        // InternalPreprocessParser.g:3405:1: (lv_id_5_0= RULE_ID )
        // InternalPreprocessParser.g:3406:3: lv_id_5_0= RULE_ID
        {
        lv_id_5_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return ;

        }


        }

        this_SKW_RIGHTPAREN_6=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred90_InternalPreprocessParser

    // Delegated rules

    public final boolean synpred2_InternalPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_InternalPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_InternalPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred90_InternalPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_InternalPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_InternalPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_InternalPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalPreprocessParser_fragment(); // can never throw exception
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
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA30 dfa30 = new DFA30(this);
    static final String DFA1_eotS =
        "\11\uffff";
    static final String DFA1_eofS =
        "\1\1\10\uffff";
    static final String DFA1_minS =
        "\1\4\1\uffff\1\5\1\4\1\0\1\uffff\1\5\2\uffff";
    static final String DFA1_maxS =
        "\1\121\1\uffff\1\27\1\121\1\0\1\uffff\1\27\2\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\4\3\uffff\1\3\1\uffff\1\1\1\2";
    static final String DFA1_specialS =
        "\4\uffff\1\0\4\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\3\5\1\uffff\4\5\2\uffff\2\5\2\uffff\1\4\3\uffff\1\3\1\5\2\uffff\6\5\2\uffff\1\5\6\uffff\10\5\1\uffff\35\5\1\uffff\1\5",
            "",
            "\5\7\1\uffff\2\7\3\1\1\7\2\uffff\1\7\3\uffff\1\6",
            "\1\7\3\5\1\uffff\4\5\2\uffff\2\5\2\uffff\1\5\3\uffff\1\3\1\5\2\uffff\6\5\2\uffff\1\5\6\uffff\10\5\1\uffff\35\5\1\uffff\1\5",
            "\1\uffff",
            "",
            "\5\7\1\uffff\2\7\2\1\1\uffff\1\7\2\uffff\1\7\3\uffff\1\6",
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
                        if ( (synpred2_InternalPreprocessParser()) ) {s = 8;}

                        else if ( (synpred3_InternalPreprocessParser()) ) {s = 5;}

                         
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
        "\3\uffff\1\4\2\uffff";
    static final String DFA6_minS =
        "\1\6\2\27\1\23\2\uffff";
    static final String DFA6_maxS =
        "\1\6\1\27\1\30\1\72\2\uffff";
    static final String DFA6_acceptS =
        "\4\uffff\1\1\1\2";
    static final String DFA6_specialS =
        "\6\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1",
            "\1\2",
            "\1\2\1\3",
            "\1\4\3\uffff\1\4\42\uffff\1\5",
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
            return "496:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )";
        }
    }
    static final String DFA19_eotS =
        "\5\uffff";
    static final String DFA19_eofS =
        "\5\uffff";
    static final String DFA19_minS =
        "\1\4\1\15\1\uffff\1\15\1\uffff";
    static final String DFA19_maxS =
        "\1\4\1\27\1\uffff\1\27\1\uffff";
    static final String DFA19_acceptS =
        "\2\uffff\1\2\1\uffff\1\1";
    static final String DFA19_specialS =
        "\5\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1",
            "\1\4\2\2\7\uffff\1\3",
            "",
            "\1\4\1\2\10\uffff\1\3",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "()* loopback of 974:2: ( (lv_elifs_2_0= ruleElIfConditional ) )*";
        }
    }
    static final String DFA30_eotS =
        "\74\uffff";
    static final String DFA30_eofS =
        "\1\1\73\uffff";
    static final String DFA30_minS =
        "\1\4\1\uffff\70\0\2\uffff";
    static final String DFA30_maxS =
        "\1\121\1\uffff\70\0\2\uffff";
    static final String DFA30_acceptS =
        "\1\uffff\1\3\70\uffff\1\1\1\2";
    static final String DFA30_specialS =
        "\2\uffff\1\43\1\0\1\41\1\25\1\61\1\22\1\65\1\1\1\34\1\13\1\54\1\57\1\27\1\11\1\45\1\52\1\31\1\51\1\20\1\44\1\21\1\64\1\24\1\7\1\50\1\3\1\36\1\30\1\60\1\17\1\53\1\40\1\5\1\42\1\15\1\47\1\12\1\35\1\10\1\14\1\55\1\37\1\4\1\67\1\23\1\63\1\26\1\66\1\6\1\33\1\16\1\56\1\46\1\2\1\32\1\62\2\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\1\1\4\1\5\1\6\1\uffff\1\13\1\14\1\10\1\12\2\uffff\1\11\1\7\2\uffff\1\1\3\uffff\1\71\1\2\2\uffff\1\65\1\66\1\62\1\64\1\63\1\70\2\uffff\1\67\6\uffff\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\uffff\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\uffff\1\3",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1760:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_3 = input.LA(1);

                         
                        int index30_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA30_9 = input.LA(1);

                         
                        int index30_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA30_55 = input.LA(1);

                         
                        int index30_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_55);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA30_27 = input.LA(1);

                         
                        int index30_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_27);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA30_44 = input.LA(1);

                         
                        int index30_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_44);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA30_34 = input.LA(1);

                         
                        int index30_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_34);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA30_50 = input.LA(1);

                         
                        int index30_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_50);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA30_25 = input.LA(1);

                         
                        int index30_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_25);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA30_40 = input.LA(1);

                         
                        int index30_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_40);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA30_15 = input.LA(1);

                         
                        int index30_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_15);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA30_38 = input.LA(1);

                         
                        int index30_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_38);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA30_11 = input.LA(1);

                         
                        int index30_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_11);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA30_41 = input.LA(1);

                         
                        int index30_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_41);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA30_36 = input.LA(1);

                         
                        int index30_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_36);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA30_52 = input.LA(1);

                         
                        int index30_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_52);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA30_31 = input.LA(1);

                         
                        int index30_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_31);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA30_20 = input.LA(1);

                         
                        int index30_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_20);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA30_22 = input.LA(1);

                         
                        int index30_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_22);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA30_7 = input.LA(1);

                         
                        int index30_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_7);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA30_46 = input.LA(1);

                         
                        int index30_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_46);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA30_24 = input.LA(1);

                         
                        int index30_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_24);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA30_5 = input.LA(1);

                         
                        int index30_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_5);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA30_48 = input.LA(1);

                         
                        int index30_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_48);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA30_14 = input.LA(1);

                         
                        int index30_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_14);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA30_29 = input.LA(1);

                         
                        int index30_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_29);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA30_18 = input.LA(1);

                         
                        int index30_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_18);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA30_56 = input.LA(1);

                         
                        int index30_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_56);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA30_51 = input.LA(1);

                         
                        int index30_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_51);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA30_10 = input.LA(1);

                         
                        int index30_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_10);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA30_39 = input.LA(1);

                         
                        int index30_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_39);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA30_28 = input.LA(1);

                         
                        int index30_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_28);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA30_43 = input.LA(1);

                         
                        int index30_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_43);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA30_33 = input.LA(1);

                         
                        int index30_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_33);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA30_4 = input.LA(1);

                         
                        int index30_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_4);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA30_35 = input.LA(1);

                         
                        int index30_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_35);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA30_2 = input.LA(1);

                         
                        int index30_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_2);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA30_21 = input.LA(1);

                         
                        int index30_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_21);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA30_16 = input.LA(1);

                         
                        int index30_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_16);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA30_54 = input.LA(1);

                         
                        int index30_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_54);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA30_37 = input.LA(1);

                         
                        int index30_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_37);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA30_26 = input.LA(1);

                         
                        int index30_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_26);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA30_19 = input.LA(1);

                         
                        int index30_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_19);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA30_17 = input.LA(1);

                         
                        int index30_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_17);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA30_32 = input.LA(1);

                         
                        int index30_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_32);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA30_12 = input.LA(1);

                         
                        int index30_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_12);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA30_42 = input.LA(1);

                         
                        int index30_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_42);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA30_53 = input.LA(1);

                         
                        int index30_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_53);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA30_13 = input.LA(1);

                         
                        int index30_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_13);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA30_30 = input.LA(1);

                         
                        int index30_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_30);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA30_6 = input.LA(1);

                         
                        int index30_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_6);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA30_57 = input.LA(1);

                         
                        int index30_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocessParser()) ) {s = 59;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_57);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA30_47 = input.LA(1);

                         
                        int index30_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_47);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA30_23 = input.LA(1);

                         
                        int index30_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_23);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA30_8 = input.LA(1);

                         
                        int index30_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_8);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA30_49 = input.LA(1);

                         
                        int index30_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_49);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA30_45 = input.LA(1);

                         
                        int index30_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index30_45);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xFFFBFC09F9899EF2L,0x000000000002FFFFL});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000891BE0L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0xFFFBFC09F9819EE0L,0x000000000002FFFFL});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0xFFFBFC09F9819EF0L,0x000000000002FFFFL});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001800000L,0x0000000000000400L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0xFFFBFC09F9899EF0L,0x000000000002FFFFL});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000804000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xFFFBFC09F9819EF2L,0x000000000002FFFFL});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0xFFFBFC09F9819EE2L,0x000000000002FFFFL});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0xFFFBFC09F9019EE0L,0x000000000002FFFFL});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0020000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x30C0000000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0800000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x4000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0002000000000002L,0x0000000000004001L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000001000000L});

}