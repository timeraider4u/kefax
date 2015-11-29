package at.jku.weiner.c.preprocess.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SKW_AND", "SKW_NOT", "SKW_PLUS", "SKW_STAR", "SKW_MINUS", "SKW_TILDE", "RULE_HASH", "RULE_INCLUDE", "RULE_DEFINE", "RULE_ERROR", "RULE_UNDEF", "RULE_IF", "RULE_IFDEF", "RULE_IFNOTDEF", "RULE_ENDIF", "RULE_PRAGMA", "RULE_LINEFEED", "RULE_CARRIAGERETURN", "RULE_NEWLINE", "RULE_LINEBREAK", "RULE_SPACE", "RULE_TAB", "RULE_WS", "RULE_ID", "RULE_IDENTIFIER", "RULE_LETTER", "RULE_CHAR_LITERAL", "RULE_STRING_LITERAL", "RULE_HEX_LITERAL", "RULE_DECIMAL_LITERAL", "RULE_OCTAL_LITERAL", "RULE_BIN_LITERAL", "RULE_HEX_DIGIT", "RULE_INTEGER_TYPE_SUFFIX", "RULE_FLOAT_LITERAL", "RULE_EXPONENT", "RULE_FLOAT_TYPE_SUFFIX", "RULE_ESCAPE_SEQUENCE", "RULE_OCTAL_ESCAPE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_SKW_AND", "RULE_SKW_ANDAND", "RULE_SKW_ASSIGN", "RULE_SKW_BACKSLASH", "RULE_SKW_CARET", "RULE_SKW_COMMA", "RULE_SKW_COLON", "RULE_SKW_DIV", "RULE_SKW_DOLLAR", "RULE_SKW_DOT", "RULE_SKW_DOUBLEQUOTE", "RULE_SKW_EQUAL", "RULE_SKW_GREATER", "RULE_SKW_GREATEREQUAL", "RULE_SKW_LEFTBRACE", "RULE_SKW_LEFTBRACKET", "RULE_SKW_LEFTPAREN", "RULE_SKW_LEFTSHIFT", "RULE_SKW_LESS", "RULE_SKW_LESSEQUAL", "RULE_SKW_MINUS", "RULE_SKW_MINUSMINUS", "RULE_SKW_MOD", "RULE_SKW_NOT", "RULE_SKW_NOTEQUAL", "RULE_SKW_OR", "RULE_SKW_OROR", "RULE_SKW_PLUS", "RULE_SKW_PLUSPLUS", "RULE_SKW_QUESTION", "RULE_SKW_RIGHTBRACE", "RULE_SKW_RIGHTBRACKET", "RULE_SKW_RIGHTPAREN", "RULE_SKW_RIGHTSHIFT", "RULE_SKW_SEMI", "RULE_SKW_SINGLEQUOTE", "RULE_SKW_STAR", "RULE_SKW_TILDE", "RULE_SKW_UNDERSCORE", "RULE_SPECIAL"
    };
    public static final int RULE_PRAGMA=19;
    public static final int RULE_ID=27;
    public static final int RULE_OCTAL_ESCAPE=42;
    public static final int RULE_SKW_NOT=68;
    public static final int RULE_SKW_RIGHTSHIFT=78;
    public static final int RULE_ESCAPE_SEQUENCE=41;
    public static final int RULE_SKW_DOT=54;
    public static final int RULE_SKW_PLUS=72;
    public static final int RULE_SKW_NOTEQUAL=69;
    public static final int RULE_SKW_GREATEREQUAL=58;
    public static final int SKW_NOT=5;
    public static final int RULE_SKW_RIGHTBRACE=75;
    public static final int EOF=-1;
    public static final int RULE_SKW_LESS=63;
    public static final int RULE_SKW_RIGHTPAREN=77;
    public static final int RULE_SKW_STAR=81;
    public static final int RULE_ENDIF=18;
    public static final int RULE_STRING_LITERAL=31;
    public static final int RULE_LINEBREAK=23;
    public static final int RULE_SKW_PLUSPLUS=73;
    public static final int RULE_SKW_LESSEQUAL=64;
    public static final int RULE_SKW_DOUBLEQUOTE=55;
    public static final int RULE_DECIMAL_LITERAL=33;
    public static final int RULE_HEX_LITERAL=32;
    public static final int RULE_SKW_OROR=71;
    public static final int SKW_AND=4;
    public static final int RULE_SKW_AND=45;
    public static final int RULE_SKW_CARET=49;
    public static final int RULE_OCTAL_LITERAL=34;
    public static final int RULE_SKW_COMMA=50;
    public static final int RULE_SKW_RIGHTBRACKET=76;
    public static final int SKW_PLUS=6;
    public static final int RULE_SPACE=24;
    public static final int RULE_BLOCK_COMMENT=43;
    public static final int RULE_LINEFEED=20;
    public static final int RULE_SKW_COLON=51;
    public static final int RULE_SKW_LEFTPAREN=61;
    public static final int RULE_BIN_LITERAL=35;
    public static final int RULE_SKW_MINUS=65;
    public static final int RULE_SKW_SEMI=79;
    public static final int RULE_IFDEF=16;
    public static final int RULE_NEWLINE=22;
    public static final int RULE_SKW_DOLLAR=53;
    public static final int RULE_SKW_EQUAL=56;
    public static final int RULE_SKW_LEFTSHIFT=62;
    public static final int RULE_SKW_QUESTION=74;
    public static final int RULE_SKW_ANDAND=46;
    public static final int RULE_SKW_DIV=52;
    public static final int RULE_ERROR=13;
    public static final int RULE_SKW_GREATER=57;
    public static final int RULE_HEX_DIGIT=36;
    public static final int RULE_HASH=10;
    public static final int RULE_IDENTIFIER=28;
    public static final int RULE_TAB=25;
    public static final int RULE_SKW_LEFTBRACKET=60;
    public static final int RULE_SKW_SINGLEQUOTE=80;
    public static final int RULE_UNDEF=14;
    public static final int RULE_SKW_MOD=67;
    public static final int RULE_LETTER=29;
    public static final int RULE_SKW_MINUSMINUS=66;
    public static final int SKW_TILDE=9;
    public static final int RULE_FLOAT_TYPE_SUFFIX=40;
    public static final int RULE_IFNOTDEF=17;
    public static final int RULE_EXPONENT=39;
    public static final int RULE_DEFINE=12;
    public static final int RULE_INTEGER_TYPE_SUFFIX=37;
    public static final int RULE_SPECIAL=84;
    public static final int RULE_CARRIAGERETURN=21;
    public static final int RULE_SKW_TILDE=82;
    public static final int RULE_LINE_COMMENT=44;
    public static final int RULE_INCLUDE=11;
    public static final int RULE_SKW_UNDERSCORE=83;
    public static final int RULE_SKW_OR=70;
    public static final int RULE_SKW_BACKSLASH=48;
    public static final int SKW_MINUS=8;
    public static final int RULE_CHAR_LITERAL=30;
    public static final int RULE_WS=26;
    public static final int RULE_IF=15;
    public static final int RULE_SKW_LEFTBRACE=59;
    public static final int RULE_FLOAT_LITERAL=38;
    public static final int SKW_STAR=7;
    public static final int RULE_SKW_ASSIGN=47;

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
    // InternalPreprocessParser.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalPreprocessParser.g:69:2: (iv_ruleModel= ruleModel EOF )
            // InternalPreprocessParser.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalPreprocessParser.g:77:1: ruleModel returns [EObject current=null] : ( () ( (lv_units_1_0= ruleTranslationUnit ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_units_1_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:80:28: ( ( () ( (lv_units_1_0= ruleTranslationUnit ) ) ) )
            // InternalPreprocessParser.g:81:1: ( () ( (lv_units_1_0= ruleTranslationUnit ) ) )
            {
            // InternalPreprocessParser.g:81:1: ( () ( (lv_units_1_0= ruleTranslationUnit ) ) )
            // InternalPreprocessParser.g:81:2: () ( (lv_units_1_0= ruleTranslationUnit ) )
            {
            // InternalPreprocessParser.g:81:2: ()
            // InternalPreprocessParser.g:82:2: 
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

            // InternalPreprocessParser.g:90:2: ( (lv_units_1_0= ruleTranslationUnit ) )
            // InternalPreprocessParser.g:91:1: (lv_units_1_0= ruleTranslationUnit )
            {
            // InternalPreprocessParser.g:91:1: (lv_units_1_0= ruleTranslationUnit )
            // InternalPreprocessParser.g:92:3: lv_units_1_0= ruleTranslationUnit
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
    // InternalPreprocessParser.g:116:1: entryRuleTranslationUnit returns [EObject current=null] : iv_ruleTranslationUnit= ruleTranslationUnit EOF ;
    public final EObject entryRuleTranslationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTranslationUnit = null;


        try {
            // InternalPreprocessParser.g:117:2: (iv_ruleTranslationUnit= ruleTranslationUnit EOF )
            // InternalPreprocessParser.g:118:2: iv_ruleTranslationUnit= ruleTranslationUnit EOF
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
    // InternalPreprocessParser.g:125:1: ruleTranslationUnit returns [EObject current=null] : ( () ( (lv_group_1_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleTranslationUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_group_1_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:128:28: ( ( () ( (lv_group_1_0= ruleGroupOpt ) ) ) )
            // InternalPreprocessParser.g:129:1: ( () ( (lv_group_1_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocessParser.g:129:1: ( () ( (lv_group_1_0= ruleGroupOpt ) ) )
            // InternalPreprocessParser.g:129:2: () ( (lv_group_1_0= ruleGroupOpt ) )
            {
            // InternalPreprocessParser.g:129:2: ()
            // InternalPreprocessParser.g:130:2: 
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

            // InternalPreprocessParser.g:138:2: ( (lv_group_1_0= ruleGroupOpt ) )
            // InternalPreprocessParser.g:139:1: (lv_group_1_0= ruleGroupOpt )
            {
            // InternalPreprocessParser.g:139:1: (lv_group_1_0= ruleGroupOpt )
            // InternalPreprocessParser.g:140:3: lv_group_1_0= ruleGroupOpt
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
    // InternalPreprocessParser.g:164:1: entryRuleGroupOpt returns [EObject current=null] : iv_ruleGroupOpt= ruleGroupOpt EOF ;
    public final EObject entryRuleGroupOpt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOpt = null;


        try {
            // InternalPreprocessParser.g:165:2: (iv_ruleGroupOpt= ruleGroupOpt EOF )
            // InternalPreprocessParser.g:166:2: iv_ruleGroupOpt= ruleGroupOpt EOF
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
    // InternalPreprocessParser.g:173:1: ruleGroupOpt returns [EObject current=null] : ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* ) ;
    public final EObject ruleGroupOpt() throws RecognitionException {
        EObject current = null;

        EObject lv_lines_1_0 = null;

        EObject lv_lines_2_0 = null;

        EObject lv_lines_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:176:28: ( ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* ) )
            // InternalPreprocessParser.g:177:1: ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* )
            {
            // InternalPreprocessParser.g:177:1: ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* )
            // InternalPreprocessParser.g:177:2: () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )*
            {
            // InternalPreprocessParser.g:177:2: ()
            // InternalPreprocessParser.g:178:2: 
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

            // InternalPreprocessParser.g:186:2: ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )*
            loop1:
            do {
                int alt1=4;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // InternalPreprocessParser.g:186:3: ( (lv_lines_1_0= rulePreprocessorDirectives ) )
            	    {
            	    // InternalPreprocessParser.g:186:3: ( (lv_lines_1_0= rulePreprocessorDirectives ) )
            	    // InternalPreprocessParser.g:187:1: (lv_lines_1_0= rulePreprocessorDirectives )
            	    {
            	    // InternalPreprocessParser.g:187:1: (lv_lines_1_0= rulePreprocessorDirectives )
            	    // InternalPreprocessParser.g:188:3: lv_lines_1_0= rulePreprocessorDirectives
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
            	    // InternalPreprocessParser.g:205:6: ( (lv_lines_2_0= ruleNewLineLine ) )
            	    {
            	    // InternalPreprocessParser.g:205:6: ( (lv_lines_2_0= ruleNewLineLine ) )
            	    // InternalPreprocessParser.g:206:1: (lv_lines_2_0= ruleNewLineLine )
            	    {
            	    // InternalPreprocessParser.g:206:1: (lv_lines_2_0= ruleNewLineLine )
            	    // InternalPreprocessParser.g:207:3: lv_lines_2_0= ruleNewLineLine
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
            	    // InternalPreprocessParser.g:224:6: ( (lv_lines_3_0= ruleCode ) )
            	    {
            	    // InternalPreprocessParser.g:224:6: ( (lv_lines_3_0= ruleCode ) )
            	    // InternalPreprocessParser.g:225:1: (lv_lines_3_0= ruleCode )
            	    {
            	    // InternalPreprocessParser.g:225:1: (lv_lines_3_0= ruleCode )
            	    // InternalPreprocessParser.g:226:3: lv_lines_3_0= ruleCode
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
    // InternalPreprocessParser.g:250:1: entryRulePreprocessorDirectives returns [EObject current=null] : iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF ;
    public final EObject entryRulePreprocessorDirectives() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreprocessorDirectives = null;


        try {
            // InternalPreprocessParser.g:251:2: (iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF )
            // InternalPreprocessParser.g:252:2: iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF
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
    // InternalPreprocessParser.g:259:1: rulePreprocessorDirectives returns [EObject current=null] : ( () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= ruleConditionalDirective ) ) | ( (lv_directive_9_0= rulePragmaDirective ) ) | ( (lv_directive_10_0= ruleNullDirective ) ) ) this_NEWLINE_11= RULE_NEWLINE ) ;
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
            // InternalPreprocessParser.g:262:28: ( ( () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= ruleConditionalDirective ) ) | ( (lv_directive_9_0= rulePragmaDirective ) ) | ( (lv_directive_10_0= ruleNullDirective ) ) ) this_NEWLINE_11= RULE_NEWLINE ) )
            // InternalPreprocessParser.g:263:1: ( () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= ruleConditionalDirective ) ) | ( (lv_directive_9_0= rulePragmaDirective ) ) | ( (lv_directive_10_0= ruleNullDirective ) ) ) this_NEWLINE_11= RULE_NEWLINE )
            {
            // InternalPreprocessParser.g:263:1: ( () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= ruleConditionalDirective ) ) | ( (lv_directive_9_0= rulePragmaDirective ) ) | ( (lv_directive_10_0= ruleNullDirective ) ) ) this_NEWLINE_11= RULE_NEWLINE )
            // InternalPreprocessParser.g:263:2: () (this_WS_1= RULE_WS )* this_HASH_2= RULE_HASH (this_WS_3= RULE_WS )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= ruleConditionalDirective ) ) | ( (lv_directive_9_0= rulePragmaDirective ) ) | ( (lv_directive_10_0= ruleNullDirective ) ) ) this_NEWLINE_11= RULE_NEWLINE
            {
            // InternalPreprocessParser.g:263:2: ()
            // InternalPreprocessParser.g:264:2: 
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

            // InternalPreprocessParser.g:272:2: (this_WS_1= RULE_WS )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_WS) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalPreprocessParser.g:272:3: this_WS_1= RULE_WS
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
            // InternalPreprocessParser.g:280:1: (this_WS_3= RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalPreprocessParser.g:280:2: this_WS_3= RULE_WS
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

            // InternalPreprocessParser.g:284:3: ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleUnDefineDirective ) ) | ( (lv_directive_8_0= ruleConditionalDirective ) ) | ( (lv_directive_9_0= rulePragmaDirective ) ) | ( (lv_directive_10_0= ruleNullDirective ) ) )
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
                    // InternalPreprocessParser.g:284:4: ( (lv_directive_4_0= ruleIncludeDirective ) )
                    {
                    // InternalPreprocessParser.g:284:4: ( (lv_directive_4_0= ruleIncludeDirective ) )
                    // InternalPreprocessParser.g:285:1: (lv_directive_4_0= ruleIncludeDirective )
                    {
                    // InternalPreprocessParser.g:285:1: (lv_directive_4_0= ruleIncludeDirective )
                    // InternalPreprocessParser.g:286:3: lv_directive_4_0= ruleIncludeDirective
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
                    // InternalPreprocessParser.g:303:6: ( (lv_directive_5_0= ruleDefineDirective ) )
                    {
                    // InternalPreprocessParser.g:303:6: ( (lv_directive_5_0= ruleDefineDirective ) )
                    // InternalPreprocessParser.g:304:1: (lv_directive_5_0= ruleDefineDirective )
                    {
                    // InternalPreprocessParser.g:304:1: (lv_directive_5_0= ruleDefineDirective )
                    // InternalPreprocessParser.g:305:3: lv_directive_5_0= ruleDefineDirective
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
                    // InternalPreprocessParser.g:322:6: ( (lv_directive_6_0= ruleErrorDirective ) )
                    {
                    // InternalPreprocessParser.g:322:6: ( (lv_directive_6_0= ruleErrorDirective ) )
                    // InternalPreprocessParser.g:323:1: (lv_directive_6_0= ruleErrorDirective )
                    {
                    // InternalPreprocessParser.g:323:1: (lv_directive_6_0= ruleErrorDirective )
                    // InternalPreprocessParser.g:324:3: lv_directive_6_0= ruleErrorDirective
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
                    // InternalPreprocessParser.g:341:6: ( (lv_directive_7_0= ruleUnDefineDirective ) )
                    {
                    // InternalPreprocessParser.g:341:6: ( (lv_directive_7_0= ruleUnDefineDirective ) )
                    // InternalPreprocessParser.g:342:1: (lv_directive_7_0= ruleUnDefineDirective )
                    {
                    // InternalPreprocessParser.g:342:1: (lv_directive_7_0= ruleUnDefineDirective )
                    // InternalPreprocessParser.g:343:3: lv_directive_7_0= ruleUnDefineDirective
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
                    // InternalPreprocessParser.g:360:6: ( (lv_directive_8_0= ruleConditionalDirective ) )
                    {
                    // InternalPreprocessParser.g:360:6: ( (lv_directive_8_0= ruleConditionalDirective ) )
                    // InternalPreprocessParser.g:361:1: (lv_directive_8_0= ruleConditionalDirective )
                    {
                    // InternalPreprocessParser.g:361:1: (lv_directive_8_0= ruleConditionalDirective )
                    // InternalPreprocessParser.g:362:3: lv_directive_8_0= ruleConditionalDirective
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
                    // InternalPreprocessParser.g:379:6: ( (lv_directive_9_0= rulePragmaDirective ) )
                    {
                    // InternalPreprocessParser.g:379:6: ( (lv_directive_9_0= rulePragmaDirective ) )
                    // InternalPreprocessParser.g:380:1: (lv_directive_9_0= rulePragmaDirective )
                    {
                    // InternalPreprocessParser.g:380:1: (lv_directive_9_0= rulePragmaDirective )
                    // InternalPreprocessParser.g:381:3: lv_directive_9_0= rulePragmaDirective
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
                    // InternalPreprocessParser.g:398:6: ( (lv_directive_10_0= ruleNullDirective ) )
                    {
                    // InternalPreprocessParser.g:398:6: ( (lv_directive_10_0= ruleNullDirective ) )
                    // InternalPreprocessParser.g:399:1: (lv_directive_10_0= ruleNullDirective )
                    {
                    // InternalPreprocessParser.g:399:1: (lv_directive_10_0= ruleNullDirective )
                    // InternalPreprocessParser.g:400:3: lv_directive_10_0= ruleNullDirective
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
    // InternalPreprocessParser.g:428:1: entryRuleIncludeDirective returns [EObject current=null] : iv_ruleIncludeDirective= ruleIncludeDirective EOF ;
    public final EObject entryRuleIncludeDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDirective = null;


        try {
            // InternalPreprocessParser.g:429:2: (iv_ruleIncludeDirective= ruleIncludeDirective EOF )
            // InternalPreprocessParser.g:430:2: iv_ruleIncludeDirective= ruleIncludeDirective EOF
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
    // InternalPreprocessParser.g:437:1: ruleIncludeDirective returns [EObject current=null] : ( () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleIncludeDirective() throws RecognitionException {
        EObject current = null;

        Token this_INCLUDE_1=null;
        Token this_WS_2=null;
        AntlrDatatypeRuleToken lv_string_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:440:28: ( ( () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) ) ) )
            // InternalPreprocessParser.g:441:1: ( () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) ) )
            {
            // InternalPreprocessParser.g:441:1: ( () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) ) )
            // InternalPreprocessParser.g:441:2: () this_INCLUDE_1= RULE_INCLUDE (this_WS_2= RULE_WS )+ ( (lv_string_3_0= ruleMyCodeLine ) )
            {
            // InternalPreprocessParser.g:441:2: ()
            // InternalPreprocessParser.g:442:2: 
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
            // InternalPreprocessParser.g:454:1: (this_WS_2= RULE_WS )+
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
            	    // InternalPreprocessParser.g:454:2: this_WS_2= RULE_WS
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

            // InternalPreprocessParser.g:458:3: ( (lv_string_3_0= ruleMyCodeLine ) )
            // InternalPreprocessParser.g:459:1: (lv_string_3_0= ruleMyCodeLine )
            {
            // InternalPreprocessParser.g:459:1: (lv_string_3_0= ruleMyCodeLine )
            // InternalPreprocessParser.g:460:3: lv_string_3_0= ruleMyCodeLine
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
    // InternalPreprocessParser.g:484:1: entryRuleDefineDirective returns [EObject current=null] : iv_ruleDefineDirective= ruleDefineDirective EOF ;
    public final EObject entryRuleDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineDirective = null;


        try {
            // InternalPreprocessParser.g:485:2: (iv_ruleDefineDirective= ruleDefineDirective EOF )
            // InternalPreprocessParser.g:486:2: iv_ruleDefineDirective= ruleDefineDirective EOF
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
    // InternalPreprocessParser.g:493:1: ruleDefineDirective returns [EObject current=null] : (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro ) ;
    public final EObject ruleDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject this_DefineObjectMacro_0 = null;

        EObject this_DefineFunctionLikeMacro_1 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:496:28: ( (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro ) )
            // InternalPreprocessParser.g:497:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )
            {
            // InternalPreprocessParser.g:497:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalPreprocessParser.g:498:2: this_DefineObjectMacro_0= ruleDefineObjectMacro
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
                    // InternalPreprocessParser.g:511:2: this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro
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
    // InternalPreprocessParser.g:530:1: entryRuleDefineObjectMacro returns [EObject current=null] : iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF ;
    public final EObject entryRuleDefineObjectMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineObjectMacro = null;


        try {
            // InternalPreprocessParser.g:531:2: (iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF )
            // InternalPreprocessParser.g:532:2: iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF
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
    // InternalPreprocessParser.g:539:1: ruleDefineObjectMacro returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? ) ;
    public final EObject ruleDefineObjectMacro() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_1=null;
        Token this_WS_2=null;
        Token lv_id_3_0=null;
        Token this_WS_4=null;
        AntlrDatatypeRuleToken lv_string_5_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:542:28: ( ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? ) )
            // InternalPreprocessParser.g:543:1: ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? )
            {
            // InternalPreprocessParser.g:543:1: ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? )
            // InternalPreprocessParser.g:543:2: () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )?
            {
            // InternalPreprocessParser.g:543:2: ()
            // InternalPreprocessParser.g:544:2: 
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
            // InternalPreprocessParser.g:556:1: (this_WS_2= RULE_WS )+
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
            	    // InternalPreprocessParser.g:556:2: this_WS_2= RULE_WS
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

            // InternalPreprocessParser.g:560:3: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocessParser.g:561:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocessParser.g:561:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocessParser.g:562:3: lv_id_3_0= RULE_ID
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

            // InternalPreprocessParser.g:578:2: ( (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_WS) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalPreprocessParser.g:578:3: (this_WS_4= RULE_WS )+ ( (lv_string_5_0= ruleMyDefineLine ) )
                    {
                    // InternalPreprocessParser.g:578:3: (this_WS_4= RULE_WS )+
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
                    	    // InternalPreprocessParser.g:578:4: this_WS_4= RULE_WS
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

                    // InternalPreprocessParser.g:582:3: ( (lv_string_5_0= ruleMyDefineLine ) )
                    // InternalPreprocessParser.g:583:1: (lv_string_5_0= ruleMyDefineLine )
                    {
                    // InternalPreprocessParser.g:583:1: (lv_string_5_0= ruleMyDefineLine )
                    // InternalPreprocessParser.g:584:3: lv_string_5_0= ruleMyDefineLine
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
    // InternalPreprocessParser.g:608:1: entryRuleDefineFunctionLikeMacro returns [EObject current=null] : iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF ;
    public final EObject entryRuleDefineFunctionLikeMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineFunctionLikeMacro = null;


        try {
            // InternalPreprocessParser.g:609:2: (iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF )
            // InternalPreprocessParser.g:610:2: iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF
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
    // InternalPreprocessParser.g:617:1: ruleDefineFunctionLikeMacro returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WS_5= RULE_WS )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WS_8= RULE_WS )+ ( (lv_string_9_0= ruleMyDefineLine ) ) ) ;
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
            // InternalPreprocessParser.g:620:28: ( ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WS_5= RULE_WS )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WS_8= RULE_WS )+ ( (lv_string_9_0= ruleMyDefineLine ) ) ) )
            // InternalPreprocessParser.g:621:1: ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WS_5= RULE_WS )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WS_8= RULE_WS )+ ( (lv_string_9_0= ruleMyDefineLine ) ) )
            {
            // InternalPreprocessParser.g:621:1: ( () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WS_5= RULE_WS )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WS_8= RULE_WS )+ ( (lv_string_9_0= ruleMyDefineLine ) ) )
            // InternalPreprocessParser.g:621:2: () this_DEFINE_1= RULE_DEFINE (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WS_5= RULE_WS )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WS_8= RULE_WS )+ ( (lv_string_9_0= ruleMyDefineLine ) )
            {
            // InternalPreprocessParser.g:621:2: ()
            // InternalPreprocessParser.g:622:2: 
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
            // InternalPreprocessParser.g:634:1: (this_WS_2= RULE_WS )+
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
            	    // InternalPreprocessParser.g:634:2: this_WS_2= RULE_WS
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

            // InternalPreprocessParser.g:638:3: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocessParser.g:639:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocessParser.g:639:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocessParser.g:640:3: lv_id_3_0= RULE_ID
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
            // InternalPreprocessParser.g:660:1: (this_WS_5= RULE_WS )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_WS) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalPreprocessParser.g:660:2: this_WS_5= RULE_WS
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

            // InternalPreprocessParser.g:664:3: ( (lv_list_6_0= ruleIdentifierList ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalPreprocessParser.g:665:1: (lv_list_6_0= ruleIdentifierList )
                    {
                    // InternalPreprocessParser.g:665:1: (lv_list_6_0= ruleIdentifierList )
                    // InternalPreprocessParser.g:666:3: lv_list_6_0= ruleIdentifierList
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
            // InternalPreprocessParser.g:686:1: (this_WS_8= RULE_WS )+
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
            	    // InternalPreprocessParser.g:686:2: this_WS_8= RULE_WS
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

            // InternalPreprocessParser.g:690:3: ( (lv_string_9_0= ruleMyDefineLine ) )
            // InternalPreprocessParser.g:691:1: (lv_string_9_0= ruleMyDefineLine )
            {
            // InternalPreprocessParser.g:691:1: (lv_string_9_0= ruleMyDefineLine )
            // InternalPreprocessParser.g:692:3: lv_string_9_0= ruleMyDefineLine
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
    // InternalPreprocessParser.g:716:1: entryRuleIdentifierList returns [EObject current=null] : iv_ruleIdentifierList= ruleIdentifierList EOF ;
    public final EObject entryRuleIdentifierList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierList = null;


        try {
            // InternalPreprocessParser.g:717:2: (iv_ruleIdentifierList= ruleIdentifierList EOF )
            // InternalPreprocessParser.g:718:2: iv_ruleIdentifierList= ruleIdentifierList EOF
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
    // InternalPreprocessParser.g:725:1: ruleIdentifierList returns [EObject current=null] : ( () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )* ) ;
    public final EObject ruleIdentifierList() throws RecognitionException {
        EObject current = null;

        Token lv_id_1_0=null;
        Token this_SKW_COMMA_2=null;
        Token this_WS_3=null;
        Token lv_id_4_0=null;

         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:728:28: ( ( () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )* ) )
            // InternalPreprocessParser.g:729:1: ( () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )* )
            {
            // InternalPreprocessParser.g:729:1: ( () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )* )
            // InternalPreprocessParser.g:729:2: () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )*
            {
            // InternalPreprocessParser.g:729:2: ()
            // InternalPreprocessParser.g:730:2: 
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

            // InternalPreprocessParser.g:738:2: ( (lv_id_1_0= RULE_ID ) )
            // InternalPreprocessParser.g:739:1: (lv_id_1_0= RULE_ID )
            {
            // InternalPreprocessParser.g:739:1: (lv_id_1_0= RULE_ID )
            // InternalPreprocessParser.g:740:3: lv_id_1_0= RULE_ID
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

            // InternalPreprocessParser.g:756:2: (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_SKW_COMMA) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalPreprocessParser.g:756:3: this_SKW_COMMA_2= RULE_SKW_COMMA (this_WS_3= RULE_WS )* ( (lv_id_4_0= RULE_ID ) )
            	    {
            	    this_SKW_COMMA_2=(Token)match(input,RULE_SKW_COMMA,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_COMMA_2, grammarAccess.getIdentifierListAccess().getSKW_COMMATerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocessParser.g:760:1: (this_WS_3= RULE_WS )*
            	    loop14:
            	    do {
            	        int alt14=2;
            	        int LA14_0 = input.LA(1);

            	        if ( (LA14_0==RULE_WS) ) {
            	            alt14=1;
            	        }


            	        switch (alt14) {
            	    	case 1 :
            	    	    // InternalPreprocessParser.g:760:2: this_WS_3= RULE_WS
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

            	    // InternalPreprocessParser.g:764:3: ( (lv_id_4_0= RULE_ID ) )
            	    // InternalPreprocessParser.g:765:1: (lv_id_4_0= RULE_ID )
            	    {
            	    // InternalPreprocessParser.g:765:1: (lv_id_4_0= RULE_ID )
            	    // InternalPreprocessParser.g:766:3: lv_id_4_0= RULE_ID
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
    // InternalPreprocessParser.g:790:1: entryRuleErrorDirective returns [EObject current=null] : iv_ruleErrorDirective= ruleErrorDirective EOF ;
    public final EObject entryRuleErrorDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorDirective = null;


        try {
            // InternalPreprocessParser.g:791:2: (iv_ruleErrorDirective= ruleErrorDirective EOF )
            // InternalPreprocessParser.g:792:2: iv_ruleErrorDirective= ruleErrorDirective EOF
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
    // InternalPreprocessParser.g:799:1: ruleErrorDirective returns [EObject current=null] : ( () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleErrorDirective() throws RecognitionException {
        EObject current = null;

        Token this_ERROR_1=null;
        Token this_WS_2=null;
        AntlrDatatypeRuleToken lv_msg_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:802:28: ( ( () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) ) )
            // InternalPreprocessParser.g:803:1: ( () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) )
            {
            // InternalPreprocessParser.g:803:1: ( () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) )
            // InternalPreprocessParser.g:803:2: () this_ERROR_1= RULE_ERROR (this_WS_2= RULE_WS )+ ( (lv_msg_3_0= ruleMyCodeLine ) )
            {
            // InternalPreprocessParser.g:803:2: ()
            // InternalPreprocessParser.g:804:2: 
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
            // InternalPreprocessParser.g:816:1: (this_WS_2= RULE_WS )+
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
            	    // InternalPreprocessParser.g:816:2: this_WS_2= RULE_WS
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

            // InternalPreprocessParser.g:820:3: ( (lv_msg_3_0= ruleMyCodeLine ) )
            // InternalPreprocessParser.g:821:1: (lv_msg_3_0= ruleMyCodeLine )
            {
            // InternalPreprocessParser.g:821:1: (lv_msg_3_0= ruleMyCodeLine )
            // InternalPreprocessParser.g:822:3: lv_msg_3_0= ruleMyCodeLine
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
    // InternalPreprocessParser.g:846:1: entryRuleUnDefineDirective returns [EObject current=null] : iv_ruleUnDefineDirective= ruleUnDefineDirective EOF ;
    public final EObject entryRuleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnDefineDirective = null;


        try {
            // InternalPreprocessParser.g:847:2: (iv_ruleUnDefineDirective= ruleUnDefineDirective EOF )
            // InternalPreprocessParser.g:848:2: iv_ruleUnDefineDirective= ruleUnDefineDirective EOF
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
    // InternalPreprocessParser.g:855:1: ruleUnDefineDirective returns [EObject current=null] : ( () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ) ;
    public final EObject ruleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        Token this_UNDEF_1=null;
        Token this_WS_2=null;
        Token lv_id_3_0=null;

         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:858:28: ( ( () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) ) )
            // InternalPreprocessParser.g:859:1: ( () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) )
            {
            // InternalPreprocessParser.g:859:1: ( () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) )
            // InternalPreprocessParser.g:859:2: () this_UNDEF_1= RULE_UNDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) )
            {
            // InternalPreprocessParser.g:859:2: ()
            // InternalPreprocessParser.g:860:2: 
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
            // InternalPreprocessParser.g:872:1: (this_WS_2= RULE_WS )+
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
            	    // InternalPreprocessParser.g:872:2: this_WS_2= RULE_WS
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

            // InternalPreprocessParser.g:876:3: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocessParser.g:877:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocessParser.g:877:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocessParser.g:878:3: lv_id_3_0= RULE_ID
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
    // InternalPreprocessParser.g:902:1: entryRuleConditionalDirective returns [EObject current=null] : iv_ruleConditionalDirective= ruleConditionalDirective EOF ;
    public final EObject entryRuleConditionalDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalDirective = null;


        try {
            // InternalPreprocessParser.g:903:2: (iv_ruleConditionalDirective= ruleConditionalDirective EOF )
            // InternalPreprocessParser.g:904:2: iv_ruleConditionalDirective= ruleConditionalDirective EOF
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
    // InternalPreprocessParser.g:911:1: ruleConditionalDirective returns [EObject current=null] : ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) this_HASH_2= RULE_HASH this_ENDIF_3= RULE_ENDIF (this_WS_4= RULE_WS )* ) ;
    public final EObject ruleConditionalDirective() throws RecognitionException {
        EObject current = null;

        Token this_HASH_2=null;
        Token this_ENDIF_3=null;
        Token this_WS_4=null;
        EObject lv_conditional_1_1 = null;

        EObject lv_conditional_1_2 = null;

        EObject lv_conditional_1_3 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:914:28: ( ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) this_HASH_2= RULE_HASH this_ENDIF_3= RULE_ENDIF (this_WS_4= RULE_WS )* ) )
            // InternalPreprocessParser.g:915:1: ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) this_HASH_2= RULE_HASH this_ENDIF_3= RULE_ENDIF (this_WS_4= RULE_WS )* )
            {
            // InternalPreprocessParser.g:915:1: ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) this_HASH_2= RULE_HASH this_ENDIF_3= RULE_ENDIF (this_WS_4= RULE_WS )* )
            // InternalPreprocessParser.g:915:2: () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) this_HASH_2= RULE_HASH this_ENDIF_3= RULE_ENDIF (this_WS_4= RULE_WS )*
            {
            // InternalPreprocessParser.g:915:2: ()
            // InternalPreprocessParser.g:916:2: 
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

            // InternalPreprocessParser.g:924:2: ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) )
            // InternalPreprocessParser.g:925:1: ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) )
            {
            // InternalPreprocessParser.g:925:1: ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) )
            // InternalPreprocessParser.g:926:1: (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional )
            {
            // InternalPreprocessParser.g:926:1: (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional )
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
                    // InternalPreprocessParser.g:927:3: lv_conditional_1_1= ruleIfConditional
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
                    // InternalPreprocessParser.g:942:8: lv_conditional_1_2= ruleIfDefConditional
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
                    // InternalPreprocessParser.g:957:8: lv_conditional_1_3= ruleIfNotDefConditional
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

            this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_2, grammarAccess.getConditionalDirectiveAccess().getHASHTerminalRuleCall_2()); 
                  
            }
            this_ENDIF_3=(Token)match(input,RULE_ENDIF,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ENDIF_3, grammarAccess.getConditionalDirectiveAccess().getENDIFTerminalRuleCall_3()); 
                  
            }
            // InternalPreprocessParser.g:983:1: (this_WS_4= RULE_WS )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_WS) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalPreprocessParser.g:983:2: this_WS_4= RULE_WS
            	    {
            	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_4, grammarAccess.getConditionalDirectiveAccess().getWSTerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalPreprocessParser.g:995:1: entryRuleIfConditional returns [EObject current=null] : iv_ruleIfConditional= ruleIfConditional EOF ;
    public final EObject entryRuleIfConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfConditional = null;


        try {
            // InternalPreprocessParser.g:996:2: (iv_ruleIfConditional= ruleIfConditional EOF )
            // InternalPreprocessParser.g:997:2: iv_ruleIfConditional= ruleIfConditional EOF
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
    // InternalPreprocessParser.g:1004:1: ruleIfConditional returns [EObject current=null] : ( () this_IF_1= RULE_IF (this_WS_2= RULE_WS )+ ( (lv_expression_3_0= ruleShadowExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleIfConditional() throws RecognitionException {
        EObject current = null;

        Token this_IF_1=null;
        Token this_WS_2=null;
        Token this_NEWLINE_4=null;
        EObject lv_expression_3_0 = null;

        EObject lv_group_5_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1007:28: ( ( () this_IF_1= RULE_IF (this_WS_2= RULE_WS )+ ( (lv_expression_3_0= ruleShadowExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) )
            // InternalPreprocessParser.g:1008:1: ( () this_IF_1= RULE_IF (this_WS_2= RULE_WS )+ ( (lv_expression_3_0= ruleShadowExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocessParser.g:1008:1: ( () this_IF_1= RULE_IF (this_WS_2= RULE_WS )+ ( (lv_expression_3_0= ruleShadowExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            // InternalPreprocessParser.g:1008:2: () this_IF_1= RULE_IF (this_WS_2= RULE_WS )+ ( (lv_expression_3_0= ruleShadowExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) )
            {
            // InternalPreprocessParser.g:1008:2: ()
            // InternalPreprocessParser.g:1009:2: 
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
            // InternalPreprocessParser.g:1021:1: (this_WS_2= RULE_WS )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_WS) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalPreprocessParser.g:1021:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_2, grammarAccess.getIfConditionalAccess().getWSTerminalRuleCall_2()); 
            	          
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

            // InternalPreprocessParser.g:1025:3: ( (lv_expression_3_0= ruleShadowExpression ) )
            // InternalPreprocessParser.g:1026:1: (lv_expression_3_0= ruleShadowExpression )
            {
            // InternalPreprocessParser.g:1026:1: (lv_expression_3_0= ruleShadowExpression )
            // InternalPreprocessParser.g:1027:3: lv_expression_3_0= ruleShadowExpression
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

            this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_4, grammarAccess.getIfConditionalAccess().getNEWLINETerminalRuleCall_4()); 
                  
            }
            // InternalPreprocessParser.g:1047:1: ( (lv_group_5_0= ruleGroupOpt ) )
            // InternalPreprocessParser.g:1048:1: (lv_group_5_0= ruleGroupOpt )
            {
            // InternalPreprocessParser.g:1048:1: (lv_group_5_0= ruleGroupOpt )
            // InternalPreprocessParser.g:1049:3: lv_group_5_0= ruleGroupOpt
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
    // InternalPreprocessParser.g:1073:1: entryRuleIfDefConditional returns [EObject current=null] : iv_ruleIfDefConditional= ruleIfDefConditional EOF ;
    public final EObject entryRuleIfDefConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfDefConditional = null;


        try {
            // InternalPreprocessParser.g:1074:2: (iv_ruleIfDefConditional= ruleIfDefConditional EOF )
            // InternalPreprocessParser.g:1075:2: iv_ruleIfDefConditional= ruleIfDefConditional EOF
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
    // InternalPreprocessParser.g:1082:1: ruleIfDefConditional returns [EObject current=null] : ( () this_IFDEF_1= RULE_IFDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleIfDefConditional() throws RecognitionException {
        EObject current = null;

        Token this_IFDEF_1=null;
        Token this_WS_2=null;
        Token lv_id_3_0=null;
        Token this_NEWLINE_4=null;
        EObject lv_group_5_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1085:28: ( ( () this_IFDEF_1= RULE_IFDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) )
            // InternalPreprocessParser.g:1086:1: ( () this_IFDEF_1= RULE_IFDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocessParser.g:1086:1: ( () this_IFDEF_1= RULE_IFDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            // InternalPreprocessParser.g:1086:2: () this_IFDEF_1= RULE_IFDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) )
            {
            // InternalPreprocessParser.g:1086:2: ()
            // InternalPreprocessParser.g:1087:2: 
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
            // InternalPreprocessParser.g:1099:1: (this_WS_2= RULE_WS )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_WS) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalPreprocessParser.g:1099:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_2, grammarAccess.getIfDefConditionalAccess().getWSTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            // InternalPreprocessParser.g:1103:3: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocessParser.g:1104:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocessParser.g:1104:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocessParser.g:1105:3: lv_id_3_0= RULE_ID
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

            this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_4, grammarAccess.getIfDefConditionalAccess().getNEWLINETerminalRuleCall_4()); 
                  
            }
            // InternalPreprocessParser.g:1125:1: ( (lv_group_5_0= ruleGroupOpt ) )
            // InternalPreprocessParser.g:1126:1: (lv_group_5_0= ruleGroupOpt )
            {
            // InternalPreprocessParser.g:1126:1: (lv_group_5_0= ruleGroupOpt )
            // InternalPreprocessParser.g:1127:3: lv_group_5_0= ruleGroupOpt
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
    // InternalPreprocessParser.g:1151:1: entryRuleIfNotDefConditional returns [EObject current=null] : iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF ;
    public final EObject entryRuleIfNotDefConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfNotDefConditional = null;


        try {
            // InternalPreprocessParser.g:1152:2: (iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF )
            // InternalPreprocessParser.g:1153:2: iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF
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
    // InternalPreprocessParser.g:1160:1: ruleIfNotDefConditional returns [EObject current=null] : ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleIfNotDefConditional() throws RecognitionException {
        EObject current = null;

        Token this_IFNOTDEF_1=null;
        Token this_WS_2=null;
        Token lv_id_3_0=null;
        Token this_NEWLINE_4=null;
        EObject lv_group_5_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1163:28: ( ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) )
            // InternalPreprocessParser.g:1164:1: ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocessParser.g:1164:1: ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            // InternalPreprocessParser.g:1164:2: () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WS_2= RULE_WS )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) )
            {
            // InternalPreprocessParser.g:1164:2: ()
            // InternalPreprocessParser.g:1165:2: 
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
            // InternalPreprocessParser.g:1177:1: (this_WS_2= RULE_WS )+
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
            	    // InternalPreprocessParser.g:1177:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_2, grammarAccess.getIfNotDefConditionalAccess().getWSTerminalRuleCall_2()); 
            	          
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

            // InternalPreprocessParser.g:1181:3: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocessParser.g:1182:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocessParser.g:1182:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocessParser.g:1183:3: lv_id_3_0= RULE_ID
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

            this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_4, grammarAccess.getIfNotDefConditionalAccess().getNEWLINETerminalRuleCall_4()); 
                  
            }
            // InternalPreprocessParser.g:1203:1: ( (lv_group_5_0= ruleGroupOpt ) )
            // InternalPreprocessParser.g:1204:1: (lv_group_5_0= ruleGroupOpt )
            {
            // InternalPreprocessParser.g:1204:1: (lv_group_5_0= ruleGroupOpt )
            // InternalPreprocessParser.g:1205:3: lv_group_5_0= ruleGroupOpt
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


    // $ANTLR start "entryRulePragmaDirective"
    // InternalPreprocessParser.g:1229:1: entryRulePragmaDirective returns [EObject current=null] : iv_rulePragmaDirective= rulePragmaDirective EOF ;
    public final EObject entryRulePragmaDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePragmaDirective = null;


        try {
            // InternalPreprocessParser.g:1230:2: (iv_rulePragmaDirective= rulePragmaDirective EOF )
            // InternalPreprocessParser.g:1231:2: iv_rulePragmaDirective= rulePragmaDirective EOF
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
    // InternalPreprocessParser.g:1238:1: rulePragmaDirective returns [EObject current=null] : ( () this_PRAGMA_1= RULE_PRAGMA ) ;
    public final EObject rulePragmaDirective() throws RecognitionException {
        EObject current = null;

        Token this_PRAGMA_1=null;

         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1241:28: ( ( () this_PRAGMA_1= RULE_PRAGMA ) )
            // InternalPreprocessParser.g:1242:1: ( () this_PRAGMA_1= RULE_PRAGMA )
            {
            // InternalPreprocessParser.g:1242:1: ( () this_PRAGMA_1= RULE_PRAGMA )
            // InternalPreprocessParser.g:1242:2: () this_PRAGMA_1= RULE_PRAGMA
            {
            // InternalPreprocessParser.g:1242:2: ()
            // InternalPreprocessParser.g:1243:2: 
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
    // InternalPreprocessParser.g:1263:1: entryRuleNullDirective returns [EObject current=null] : iv_ruleNullDirective= ruleNullDirective EOF ;
    public final EObject entryRuleNullDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullDirective = null;


        try {
            // InternalPreprocessParser.g:1264:2: (iv_ruleNullDirective= ruleNullDirective EOF )
            // InternalPreprocessParser.g:1265:2: iv_ruleNullDirective= ruleNullDirective EOF
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
    // InternalPreprocessParser.g:1272:1: ruleNullDirective returns [EObject current=null] : () ;
    public final EObject ruleNullDirective() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1275:28: ( () )
            // InternalPreprocessParser.g:1276:1: ()
            {
            // InternalPreprocessParser.g:1276:1: ()
            // InternalPreprocessParser.g:1277:2: 
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
    // InternalPreprocessParser.g:1293:1: entryRuleNewLineLine returns [EObject current=null] : iv_ruleNewLineLine= ruleNewLineLine EOF ;
    public final EObject entryRuleNewLineLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewLineLine = null;


        try {
            // InternalPreprocessParser.g:1294:2: (iv_ruleNewLineLine= ruleNewLineLine EOF )
            // InternalPreprocessParser.g:1295:2: iv_ruleNewLineLine= ruleNewLineLine EOF
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
    // InternalPreprocessParser.g:1302:1: ruleNewLineLine returns [EObject current=null] : ( () this_NEWLINE_1= RULE_NEWLINE ) ;
    public final EObject ruleNewLineLine() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_1=null;

         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1305:28: ( ( () this_NEWLINE_1= RULE_NEWLINE ) )
            // InternalPreprocessParser.g:1306:1: ( () this_NEWLINE_1= RULE_NEWLINE )
            {
            // InternalPreprocessParser.g:1306:1: ( () this_NEWLINE_1= RULE_NEWLINE )
            // InternalPreprocessParser.g:1306:2: () this_NEWLINE_1= RULE_NEWLINE
            {
            // InternalPreprocessParser.g:1306:2: ()
            // InternalPreprocessParser.g:1307:2: 
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
    // InternalPreprocessParser.g:1327:1: entryRuleCode returns [EObject current=null] : iv_ruleCode= ruleCode EOF ;
    public final EObject entryRuleCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCode = null;


        try {
            // InternalPreprocessParser.g:1328:2: (iv_ruleCode= ruleCode EOF )
            // InternalPreprocessParser.g:1329:2: iv_ruleCode= ruleCode EOF
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
    // InternalPreprocessParser.g:1336:1: ruleCode returns [EObject current=null] : ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE ) ;
    public final EObject ruleCode() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_2=null;
        AntlrDatatypeRuleToken lv_code_1_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1339:28: ( ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE ) )
            // InternalPreprocessParser.g:1340:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE )
            {
            // InternalPreprocessParser.g:1340:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE )
            // InternalPreprocessParser.g:1340:2: () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) this_NEWLINE_2= RULE_NEWLINE
            {
            // InternalPreprocessParser.g:1340:2: ()
            // InternalPreprocessParser.g:1341:2: 
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

            // InternalPreprocessParser.g:1349:2: ( (lv_code_1_0= ruleMyCodeLineExtended ) )
            // InternalPreprocessParser.g:1350:1: (lv_code_1_0= ruleMyCodeLineExtended )
            {
            // InternalPreprocessParser.g:1350:1: (lv_code_1_0= ruleMyCodeLineExtended )
            // InternalPreprocessParser.g:1351:3: lv_code_1_0= ruleMyCodeLineExtended
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
    // InternalPreprocessParser.g:1379:1: entryRuleMyCode returns [String current=null] : iv_ruleMyCode= ruleMyCode EOF ;
    public final String entryRuleMyCode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCode = null;


        try {
            // InternalPreprocessParser.g:1380:1: (iv_ruleMyCode= ruleMyCode EOF )
            // InternalPreprocessParser.g:1381:2: iv_ruleMyCode= ruleMyCode EOF
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
    // InternalPreprocessParser.g:1388:1: ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_SpecialKeywords_10= ruleSpecialKeywords | this_Constant_11= ruleConstant ) ;
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
        AntlrDatatypeRuleToken this_SpecialKeywords_10 = null;

        AntlrDatatypeRuleToken this_Constant_11 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1392:6: ( (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_SpecialKeywords_10= ruleSpecialKeywords | this_Constant_11= ruleConstant ) )
            // InternalPreprocessParser.g:1393:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_SpecialKeywords_10= ruleSpecialKeywords | this_Constant_11= ruleConstant )
            {
            // InternalPreprocessParser.g:1393:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_SpecialKeywords_10= ruleSpecialKeywords | this_Constant_11= ruleConstant )
            int alt23=12;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt23=1;
                }
                break;
            case RULE_SPECIAL:
                {
                alt23=2;
                }
                break;
            case RULE_INCLUDE:
                {
                alt23=3;
                }
                break;
            case RULE_DEFINE:
                {
                alt23=4;
                }
                break;
            case RULE_ERROR:
                {
                alt23=5;
                }
                break;
            case RULE_PRAGMA:
                {
                alt23=6;
                }
                break;
            case RULE_IFDEF:
                {
                alt23=7;
                }
                break;
            case RULE_ENDIF:
                {
                alt23=8;
                }
                break;
            case RULE_IFNOTDEF:
                {
                alt23=9;
                }
                break;
            case RULE_IF:
                {
                alt23=10;
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
                alt23=11;
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
                alt23=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalPreprocessParser.g:1393:6: this_ID_0= RULE_ID
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
                    // InternalPreprocessParser.g:1401:10: this_SPECIAL_1= RULE_SPECIAL
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
                    // InternalPreprocessParser.g:1409:10: this_INCLUDE_2= RULE_INCLUDE
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
                    // InternalPreprocessParser.g:1417:10: this_DEFINE_3= RULE_DEFINE
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
                    // InternalPreprocessParser.g:1425:10: this_ERROR_4= RULE_ERROR
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
                    // InternalPreprocessParser.g:1433:10: this_PRAGMA_5= RULE_PRAGMA
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
                    // InternalPreprocessParser.g:1441:10: this_IFDEF_6= RULE_IFDEF
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
                    // InternalPreprocessParser.g:1449:10: this_ENDIF_7= RULE_ENDIF
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
                    // InternalPreprocessParser.g:1457:10: this_IFNOTDEF_8= RULE_IFNOTDEF
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
                    // InternalPreprocessParser.g:1465:10: this_IF_9= RULE_IF
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
                    // InternalPreprocessParser.g:1474:5: this_SpecialKeywords_10= ruleSpecialKeywords
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeAccess().getSpecialKeywordsParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_SpecialKeywords_10=ruleSpecialKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SpecialKeywords_10);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 12 :
                    // InternalPreprocessParser.g:1486:5: this_Constant_11= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeAccess().getConstantParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Constant_11=ruleConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Constant_11);
                          
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
    // InternalPreprocessParser.g:1504:1: entryRuleMyDefineLine returns [String current=null] : iv_ruleMyDefineLine= ruleMyDefineLine EOF ;
    public final String entryRuleMyDefineLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyDefineLine = null;


        try {
            // InternalPreprocessParser.g:1505:1: (iv_ruleMyDefineLine= ruleMyDefineLine EOF )
            // InternalPreprocessParser.g:1506:2: iv_ruleMyDefineLine= ruleMyDefineLine EOF
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
    // InternalPreprocessParser.g:1513:1: ruleMyDefineLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS | this_HASH_2= RULE_HASH )* ;
    public final AntlrDatatypeRuleToken ruleMyDefineLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_1=null;
        Token this_HASH_2=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1517:6: ( (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS | this_HASH_2= RULE_HASH )* )
            // InternalPreprocessParser.g:1518:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS | this_HASH_2= RULE_HASH )*
            {
            // InternalPreprocessParser.g:1518:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS | this_HASH_2= RULE_HASH )*
            loop24:
            do {
                int alt24=4;
                switch ( input.LA(1) ) {
                case RULE_INCLUDE:
                case RULE_DEFINE:
                case RULE_ERROR:
                case RULE_IF:
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
                    alt24=1;
                    }
                    break;
                case RULE_WS:
                    {
                    alt24=2;
                    }
                    break;
                case RULE_HASH:
                    {
                    alt24=3;
                    }
                    break;

                }

                switch (alt24) {
            	case 1 :
            	    // InternalPreprocessParser.g:1519:5: this_MyCode_0= ruleMyCode
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMyDefineLineAccess().getMyCodeParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_20);
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
            	    // InternalPreprocessParser.g:1530:10: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_20); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WS_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_1, grammarAccess.getMyDefineLineAccess().getWSTerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;
            	case 3 :
            	    // InternalPreprocessParser.g:1538:10: this_HASH_2= RULE_HASH
            	    {
            	    this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_20); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_HASH_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_HASH_2, grammarAccess.getMyDefineLineAccess().getHASHTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalPreprocessParser.g:1553:1: entryRuleMyCodeLine returns [String current=null] : iv_ruleMyCodeLine= ruleMyCodeLine EOF ;
    public final String entryRuleMyCodeLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLine = null;


        try {
            // InternalPreprocessParser.g:1554:1: (iv_ruleMyCodeLine= ruleMyCodeLine EOF )
            // InternalPreprocessParser.g:1555:2: iv_ruleMyCodeLine= ruleMyCodeLine EOF
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
    // InternalPreprocessParser.g:1562:1: ruleMyCodeLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+ ;
    public final AntlrDatatypeRuleToken ruleMyCodeLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_1=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1566:6: ( (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+ )
            // InternalPreprocessParser.g:1567:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+
            {
            // InternalPreprocessParser.g:1567:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+
            int cnt25=0;
            loop25:
            do {
                int alt25=3;
                alt25 = dfa25.predict(input);
                switch (alt25) {
            	case 1 :
            	    // InternalPreprocessParser.g:1568:5: this_MyCode_0= ruleMyCode
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMyCodeLineAccess().getMyCodeParserRuleCall_0()); 
            	          
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
            	    // InternalPreprocessParser.g:1579:10: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WS_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_1, grammarAccess.getMyCodeLineAccess().getWSTerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
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
    // InternalPreprocessParser.g:1594:1: entryRuleMyCodeLineExtended returns [String current=null] : iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF ;
    public final String entryRuleMyCodeLineExtended() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtended = null;


        try {
            // InternalPreprocessParser.g:1595:1: (iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF )
            // InternalPreprocessParser.g:1596:2: iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF
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
    // InternalPreprocessParser.g:1603:1: ruleMyCodeLineExtended returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? ) ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtended() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_0=null;
        Token this_HASH_3=null;
        AntlrDatatypeRuleToken this_MyCode_1 = null;

        AntlrDatatypeRuleToken this_MyCodeLine_2 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1607:6: ( ( (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? ) )
            // InternalPreprocessParser.g:1608:1: ( (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? )
            {
            // InternalPreprocessParser.g:1608:1: ( (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? )
            // InternalPreprocessParser.g:1608:2: (this_WS_0= RULE_WS )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )?
            {
            // InternalPreprocessParser.g:1608:2: (this_WS_0= RULE_WS )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_WS) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalPreprocessParser.g:1608:7: this_WS_0= RULE_WS
            	    {
            	    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WS_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WS_0, grammarAccess.getMyCodeLineExtendedAccess().getWSTerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            // InternalPreprocessParser.g:1615:3: (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_INCLUDE && LA28_0<=RULE_ERROR)||(LA28_0>=RULE_IF && LA28_0<=RULE_PRAGMA)||LA28_0==RULE_ID||(LA28_0>=RULE_CHAR_LITERAL && LA28_0<=RULE_BIN_LITERAL)||LA28_0==RULE_FLOAT_LITERAL||(LA28_0>=RULE_SKW_AND && LA28_0<=RULE_SKW_DIV)||(LA28_0>=RULE_SKW_DOT && LA28_0<=RULE_SKW_TILDE)||LA28_0==RULE_SPECIAL) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalPreprocessParser.g:1616:5: this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeLineExtendedAccess().getMyCodeParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_20);
                    this_MyCode_1=ruleMyCode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_MyCode_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalPreprocessParser.g:1626:1: (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
                    loop27:
                    do {
                        int alt27=3;
                        int LA27_0 = input.LA(1);

                        if ( ((LA27_0>=RULE_INCLUDE && LA27_0<=RULE_ERROR)||(LA27_0>=RULE_IF && LA27_0<=RULE_PRAGMA)||(LA27_0>=RULE_WS && LA27_0<=RULE_ID)||(LA27_0>=RULE_CHAR_LITERAL && LA27_0<=RULE_BIN_LITERAL)||LA27_0==RULE_FLOAT_LITERAL||(LA27_0>=RULE_SKW_AND && LA27_0<=RULE_SKW_DIV)||(LA27_0>=RULE_SKW_DOT && LA27_0<=RULE_SKW_TILDE)||LA27_0==RULE_SPECIAL) ) {
                            alt27=1;
                        }
                        else if ( (LA27_0==RULE_HASH) ) {
                            alt27=2;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalPreprocessParser.g:1627:5: this_MyCodeLine_2= ruleMyCodeLine
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	              newCompositeNode(grammarAccess.getMyCodeLineExtendedAccess().getMyCodeLineParserRuleCall_1_1_0()); 
                    	          
                    	    }
                    	    pushFollow(FOLLOW_20);
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
                    	    // InternalPreprocessParser.g:1638:10: this_HASH_3= RULE_HASH
                    	    {
                    	    this_HASH_3=(Token)match(input,RULE_HASH,FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_HASH_3);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_HASH_3, grammarAccess.getMyCodeLineExtendedAccess().getHASHTerminalRuleCall_1_1_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop27;
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
    // InternalPreprocessParser.g:1653:1: entryRuleShadowExpression returns [EObject current=null] : iv_ruleShadowExpression= ruleShadowExpression EOF ;
    public final EObject entryRuleShadowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShadowExpression = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // InternalPreprocessParser.g:1657:2: (iv_ruleShadowExpression= ruleShadowExpression EOF )
            // InternalPreprocessParser.g:1658:2: iv_ruleShadowExpression= ruleShadowExpression EOF
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
    // InternalPreprocessParser.g:1668:1: ruleShadowExpression returns [EObject current=null] : this_ConstantExpression_0= ruleConstantExpression ;
    public final EObject ruleShadowExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConstantExpression_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // InternalPreprocessParser.g:1672:28: (this_ConstantExpression_0= ruleConstantExpression )
            // InternalPreprocessParser.g:1674:2: this_ConstantExpression_0= ruleConstantExpression
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
    // InternalPreprocessParser.g:1696:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalPreprocessParser.g:1697:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalPreprocessParser.g:1698:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalPreprocessParser.g:1705:1: ruleExpression returns [EObject current=null] : ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1708:28: ( ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) ) )
            // InternalPreprocessParser.g:1709:1: ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) )
            {
            // InternalPreprocessParser.g:1709:1: ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) )
            // InternalPreprocessParser.g:1709:2: () ( (lv_expression_1_0= ruleConditionalExpression ) )
            {
            // InternalPreprocessParser.g:1709:2: ()
            // InternalPreprocessParser.g:1710:2: 
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

            // InternalPreprocessParser.g:1718:2: ( (lv_expression_1_0= ruleConditionalExpression ) )
            // InternalPreprocessParser.g:1719:1: (lv_expression_1_0= ruleConditionalExpression )
            {
            // InternalPreprocessParser.g:1719:1: (lv_expression_1_0= ruleConditionalExpression )
            // InternalPreprocessParser.g:1720:3: lv_expression_1_0= ruleConditionalExpression
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
    // InternalPreprocessParser.g:1744:1: entryRuleConstantExpression returns [EObject current=null] : iv_ruleConstantExpression= ruleConstantExpression EOF ;
    public final EObject entryRuleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantExpression = null;


        try {
            // InternalPreprocessParser.g:1745:2: (iv_ruleConstantExpression= ruleConstantExpression EOF )
            // InternalPreprocessParser.g:1746:2: iv_ruleConstantExpression= ruleConstantExpression EOF
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
    // InternalPreprocessParser.g:1753:1: ruleConstantExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) ) ;
    public final EObject ruleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1756:28: ( ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) ) )
            // InternalPreprocessParser.g:1757:1: ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) )
            {
            // InternalPreprocessParser.g:1757:1: ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) )
            // InternalPreprocessParser.g:1757:2: () ( (lv_expr_1_0= ruleConditionalExpression ) )
            {
            // InternalPreprocessParser.g:1757:2: ()
            // InternalPreprocessParser.g:1758:2: 
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

            // InternalPreprocessParser.g:1766:2: ( (lv_expr_1_0= ruleConditionalExpression ) )
            // InternalPreprocessParser.g:1767:1: (lv_expr_1_0= ruleConditionalExpression )
            {
            // InternalPreprocessParser.g:1767:1: (lv_expr_1_0= ruleConditionalExpression )
            // InternalPreprocessParser.g:1768:3: lv_expr_1_0= ruleConditionalExpression
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
    // InternalPreprocessParser.g:1792:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalPreprocessParser.g:1793:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalPreprocessParser.g:1794:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
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
    // InternalPreprocessParser.g:1801:1: ruleConditionalExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_QUESTION_2=null;
        Token this_SKW_COLON_4=null;
        EObject lv_expr_1_0 = null;

        EObject lv_qExpr_3_0 = null;

        EObject lv_cExpr_5_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1804:28: ( ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) )
            // InternalPreprocessParser.g:1805:1: ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
            {
            // InternalPreprocessParser.g:1805:1: ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
            // InternalPreprocessParser.g:1805:2: () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
            {
            // InternalPreprocessParser.g:1805:2: ()
            // InternalPreprocessParser.g:1806:2: 
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

            // InternalPreprocessParser.g:1814:2: ( (lv_expr_1_0= ruleLogicalOrExpression ) )
            // InternalPreprocessParser.g:1815:1: (lv_expr_1_0= ruleLogicalOrExpression )
            {
            // InternalPreprocessParser.g:1815:1: (lv_expr_1_0= ruleLogicalOrExpression )
            // InternalPreprocessParser.g:1816:3: lv_expr_1_0= ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExprLogicalOrExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_22);
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

            // InternalPreprocessParser.g:1832:2: (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_SKW_QUESTION) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalPreprocessParser.g:1832:3: this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) )
                    {
                    this_SKW_QUESTION_2=(Token)match(input,RULE_SKW_QUESTION,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_QUESTION_2, grammarAccess.getConditionalExpressionAccess().getSKW_QUESTIONTerminalRuleCall_2_0()); 
                          
                    }
                    // InternalPreprocessParser.g:1836:1: ( (lv_qExpr_3_0= ruleExpression ) )
                    // InternalPreprocessParser.g:1837:1: (lv_qExpr_3_0= ruleExpression )
                    {
                    // InternalPreprocessParser.g:1837:1: (lv_qExpr_3_0= ruleExpression )
                    // InternalPreprocessParser.g:1838:3: lv_qExpr_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getQExprExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_24);
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

                    this_SKW_COLON_4=(Token)match(input,RULE_SKW_COLON,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_COLON_4, grammarAccess.getConditionalExpressionAccess().getSKW_COLONTerminalRuleCall_2_2()); 
                          
                    }
                    // InternalPreprocessParser.g:1858:1: ( (lv_cExpr_5_0= ruleConditionalExpression ) )
                    // InternalPreprocessParser.g:1859:1: (lv_cExpr_5_0= ruleConditionalExpression )
                    {
                    // InternalPreprocessParser.g:1859:1: (lv_cExpr_5_0= ruleConditionalExpression )
                    // InternalPreprocessParser.g:1860:3: lv_cExpr_5_0= ruleConditionalExpression
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
    // InternalPreprocessParser.g:1884:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalPreprocessParser.g:1885:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalPreprocessParser.g:1886:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
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
    // InternalPreprocessParser.g:1893:1: ruleLogicalOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_OROR_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1896:28: ( ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalPreprocessParser.g:1897:1: ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalPreprocessParser.g:1897:1: ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalPreprocessParser.g:1897:2: () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )*
            {
            // InternalPreprocessParser.g:1897:2: ()
            // InternalPreprocessParser.g:1898:2: 
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

            // InternalPreprocessParser.g:1906:2: ( (lv_expr_1_0= ruleLogicalAndExpression ) )
            // InternalPreprocessParser.g:1907:1: (lv_expr_1_0= ruleLogicalAndExpression )
            {
            // InternalPreprocessParser.g:1907:1: (lv_expr_1_0= ruleLogicalAndExpression )
            // InternalPreprocessParser.g:1908:3: lv_expr_1_0= ruleLogicalAndExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getExprLogicalAndExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_25);
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

            // InternalPreprocessParser.g:1924:2: (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_SKW_OROR) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalPreprocessParser.g:1924:3: this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) )
            	    {
            	    this_SKW_OROR_2=(Token)match(input,RULE_SKW_OROR,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_OROR_2, grammarAccess.getLogicalOrExpressionAccess().getSKW_ORORTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocessParser.g:1928:1: ( (lv_expr_3_0= ruleLogicalAndExpression ) )
            	    // InternalPreprocessParser.g:1929:1: (lv_expr_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalPreprocessParser.g:1929:1: (lv_expr_3_0= ruleLogicalAndExpression )
            	    // InternalPreprocessParser.g:1930:3: lv_expr_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getExprLogicalAndExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_25);
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
            	    break loop30;
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
    // InternalPreprocessParser.g:1954:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalPreprocessParser.g:1955:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalPreprocessParser.g:1956:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
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
    // InternalPreprocessParser.g:1963:1: ruleLogicalAndExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_ANDAND_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:1966:28: ( ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* ) )
            // InternalPreprocessParser.g:1967:1: ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* )
            {
            // InternalPreprocessParser.g:1967:1: ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* )
            // InternalPreprocessParser.g:1967:2: () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )*
            {
            // InternalPreprocessParser.g:1967:2: ()
            // InternalPreprocessParser.g:1968:2: 
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

            // InternalPreprocessParser.g:1976:2: ( (lv_expr_1_0= ruleInclusiveOrExpression ) )
            // InternalPreprocessParser.g:1977:1: (lv_expr_1_0= ruleInclusiveOrExpression )
            {
            // InternalPreprocessParser.g:1977:1: (lv_expr_1_0= ruleInclusiveOrExpression )
            // InternalPreprocessParser.g:1978:3: lv_expr_1_0= ruleInclusiveOrExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getExprInclusiveOrExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_26);
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

            // InternalPreprocessParser.g:1994:2: (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_SKW_ANDAND) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalPreprocessParser.g:1994:3: this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) )
            	    {
            	    this_SKW_ANDAND_2=(Token)match(input,RULE_SKW_ANDAND,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_ANDAND_2, grammarAccess.getLogicalAndExpressionAccess().getSKW_ANDANDTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocessParser.g:1998:1: ( (lv_expr_3_0= ruleInclusiveOrExpression ) )
            	    // InternalPreprocessParser.g:1999:1: (lv_expr_3_0= ruleInclusiveOrExpression )
            	    {
            	    // InternalPreprocessParser.g:1999:1: (lv_expr_3_0= ruleInclusiveOrExpression )
            	    // InternalPreprocessParser.g:2000:3: lv_expr_3_0= ruleInclusiveOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getExprInclusiveOrExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_26);
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
            	    break loop31;
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
    // InternalPreprocessParser.g:2024:1: entryRuleInclusiveOrExpression returns [EObject current=null] : iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF ;
    public final EObject entryRuleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclusiveOrExpression = null;


        try {
            // InternalPreprocessParser.g:2025:2: (iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF )
            // InternalPreprocessParser.g:2026:2: iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF
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
    // InternalPreprocessParser.g:2033:1: ruleInclusiveOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* ) ;
    public final EObject ruleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_OR_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2036:28: ( ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* ) )
            // InternalPreprocessParser.g:2037:1: ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2037:1: ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* )
            // InternalPreprocessParser.g:2037:2: () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )*
            {
            // InternalPreprocessParser.g:2037:2: ()
            // InternalPreprocessParser.g:2038:2: 
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

            // InternalPreprocessParser.g:2046:2: ( (lv_expr_1_0= ruleExclusiveOrExpression ) )
            // InternalPreprocessParser.g:2047:1: (lv_expr_1_0= ruleExclusiveOrExpression )
            {
            // InternalPreprocessParser.g:2047:1: (lv_expr_1_0= ruleExclusiveOrExpression )
            // InternalPreprocessParser.g:2048:3: lv_expr_1_0= ruleExclusiveOrExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExprExclusiveOrExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_27);
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

            // InternalPreprocessParser.g:2064:2: (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_SKW_OR) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalPreprocessParser.g:2064:3: this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) )
            	    {
            	    this_SKW_OR_2=(Token)match(input,RULE_SKW_OR,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_OR_2, grammarAccess.getInclusiveOrExpressionAccess().getSKW_ORTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocessParser.g:2068:1: ( (lv_expr_3_0= ruleExclusiveOrExpression ) )
            	    // InternalPreprocessParser.g:2069:1: (lv_expr_3_0= ruleExclusiveOrExpression )
            	    {
            	    // InternalPreprocessParser.g:2069:1: (lv_expr_3_0= ruleExclusiveOrExpression )
            	    // InternalPreprocessParser.g:2070:3: lv_expr_3_0= ruleExclusiveOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExprExclusiveOrExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_27);
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
            	    break loop32;
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
    // InternalPreprocessParser.g:2094:1: entryRuleExclusiveOrExpression returns [EObject current=null] : iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF ;
    public final EObject entryRuleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusiveOrExpression = null;


        try {
            // InternalPreprocessParser.g:2095:2: (iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF )
            // InternalPreprocessParser.g:2096:2: iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF
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
    // InternalPreprocessParser.g:2103:1: ruleExclusiveOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_CARET_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2106:28: ( ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* ) )
            // InternalPreprocessParser.g:2107:1: ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2107:1: ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* )
            // InternalPreprocessParser.g:2107:2: () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )*
            {
            // InternalPreprocessParser.g:2107:2: ()
            // InternalPreprocessParser.g:2108:2: 
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

            // InternalPreprocessParser.g:2116:2: ( (lv_expr_1_0= ruleAndExpression ) )
            // InternalPreprocessParser.g:2117:1: (lv_expr_1_0= ruleAndExpression )
            {
            // InternalPreprocessParser.g:2117:1: (lv_expr_1_0= ruleAndExpression )
            // InternalPreprocessParser.g:2118:3: lv_expr_1_0= ruleAndExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getExprAndExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_28);
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

            // InternalPreprocessParser.g:2134:2: (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_SKW_CARET) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalPreprocessParser.g:2134:3: this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) )
            	    {
            	    this_SKW_CARET_2=(Token)match(input,RULE_SKW_CARET,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_CARET_2, grammarAccess.getExclusiveOrExpressionAccess().getSKW_CARETTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocessParser.g:2138:1: ( (lv_expr_3_0= ruleAndExpression ) )
            	    // InternalPreprocessParser.g:2139:1: (lv_expr_3_0= ruleAndExpression )
            	    {
            	    // InternalPreprocessParser.g:2139:1: (lv_expr_3_0= ruleAndExpression )
            	    // InternalPreprocessParser.g:2140:3: lv_expr_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getExprAndExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_28);
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
            	    break loop33;
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
    // InternalPreprocessParser.g:2164:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalPreprocessParser.g:2165:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalPreprocessParser.g:2166:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalPreprocessParser.g:2173:1: ruleAndExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_AND_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2176:28: ( ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalPreprocessParser.g:2177:1: ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2177:1: ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* )
            // InternalPreprocessParser.g:2177:2: () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )*
            {
            // InternalPreprocessParser.g:2177:2: ()
            // InternalPreprocessParser.g:2178:2: 
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

            // InternalPreprocessParser.g:2186:2: ( (lv_expr_1_0= ruleEqualityExpression ) )
            // InternalPreprocessParser.g:2187:1: (lv_expr_1_0= ruleEqualityExpression )
            {
            // InternalPreprocessParser.g:2187:1: (lv_expr_1_0= ruleEqualityExpression )
            // InternalPreprocessParser.g:2188:3: lv_expr_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAndExpressionAccess().getExprEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_29);
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

            // InternalPreprocessParser.g:2204:2: (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_SKW_AND) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalPreprocessParser.g:2204:3: this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) )
            	    {
            	    this_SKW_AND_2=(Token)match(input,RULE_SKW_AND,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_AND_2, grammarAccess.getAndExpressionAccess().getSKW_ANDTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocessParser.g:2208:1: ( (lv_expr_3_0= ruleEqualityExpression ) )
            	    // InternalPreprocessParser.g:2209:1: (lv_expr_3_0= ruleEqualityExpression )
            	    {
            	    // InternalPreprocessParser.g:2209:1: (lv_expr_3_0= ruleEqualityExpression )
            	    // InternalPreprocessParser.g:2210:3: lv_expr_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExpressionAccess().getExprEqualityExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
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
            	    break loop34;
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
    // InternalPreprocessParser.g:2234:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalPreprocessParser.g:2235:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalPreprocessParser.g:2236:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalPreprocessParser.g:2243:1: ruleEqualityExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2246:28: ( ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* ) )
            // InternalPreprocessParser.g:2247:1: ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2247:1: ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* )
            // InternalPreprocessParser.g:2247:2: () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )*
            {
            // InternalPreprocessParser.g:2247:2: ()
            // InternalPreprocessParser.g:2248:2: 
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

            // InternalPreprocessParser.g:2256:2: ( (lv_expr_1_0= ruleRelationalExpression ) )
            // InternalPreprocessParser.g:2257:1: (lv_expr_1_0= ruleRelationalExpression )
            {
            // InternalPreprocessParser.g:2257:1: (lv_expr_1_0= ruleRelationalExpression )
            // InternalPreprocessParser.g:2258:3: lv_expr_1_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExprRelationalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_30);
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

            // InternalPreprocessParser.g:2274:2: ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_SKW_EQUAL||LA36_0==RULE_SKW_NOTEQUAL) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalPreprocessParser.g:2274:3: ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) )
            	    {
            	    // InternalPreprocessParser.g:2274:3: ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) )
            	    int alt35=2;
            	    int LA35_0 = input.LA(1);

            	    if ( (LA35_0==RULE_SKW_EQUAL) ) {
            	        alt35=1;
            	    }
            	    else if ( (LA35_0==RULE_SKW_NOTEQUAL) ) {
            	        alt35=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 35, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt35) {
            	        case 1 :
            	            // InternalPreprocessParser.g:2274:4: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
            	            {
            	            // InternalPreprocessParser.g:2274:4: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
            	            // InternalPreprocessParser.g:2275:1: (lv_op_2_0= RULE_SKW_EQUAL )
            	            {
            	            // InternalPreprocessParser.g:2275:1: (lv_op_2_0= RULE_SKW_EQUAL )
            	            // InternalPreprocessParser.g:2276:3: lv_op_2_0= RULE_SKW_EQUAL
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_EQUAL,FOLLOW_23); if (state.failed) return current;
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
            	            // InternalPreprocessParser.g:2293:6: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
            	            {
            	            // InternalPreprocessParser.g:2293:6: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
            	            // InternalPreprocessParser.g:2294:1: (lv_op_3_0= RULE_SKW_NOTEQUAL )
            	            {
            	            // InternalPreprocessParser.g:2294:1: (lv_op_3_0= RULE_SKW_NOTEQUAL )
            	            // InternalPreprocessParser.g:2295:3: lv_op_3_0= RULE_SKW_NOTEQUAL
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_NOTEQUAL,FOLLOW_23); if (state.failed) return current;
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

            	    // InternalPreprocessParser.g:2311:3: ( (lv_expr_4_0= ruleRelationalExpression ) )
            	    // InternalPreprocessParser.g:2312:1: (lv_expr_4_0= ruleRelationalExpression )
            	    {
            	    // InternalPreprocessParser.g:2312:1: (lv_expr_4_0= ruleRelationalExpression )
            	    // InternalPreprocessParser.g:2313:3: lv_expr_4_0= ruleRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExprRelationalExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_30);
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
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalPreprocessParser.g:2337:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalPreprocessParser.g:2338:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalPreprocessParser.g:2339:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalPreprocessParser.g:2346:1: ruleRelationalExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* ) ;
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
            // InternalPreprocessParser.g:2349:28: ( ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* ) )
            // InternalPreprocessParser.g:2350:1: ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2350:1: ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* )
            // InternalPreprocessParser.g:2350:2: () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )*
            {
            // InternalPreprocessParser.g:2350:2: ()
            // InternalPreprocessParser.g:2351:2: 
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

            // InternalPreprocessParser.g:2359:2: ( (lv_expr_1_0= ruleShiftExpression ) )
            // InternalPreprocessParser.g:2360:1: (lv_expr_1_0= ruleShiftExpression )
            {
            // InternalPreprocessParser.g:2360:1: (lv_expr_1_0= ruleShiftExpression )
            // InternalPreprocessParser.g:2361:3: lv_expr_1_0= ruleShiftExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExprShiftExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_31);
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

            // InternalPreprocessParser.g:2377:2: ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=RULE_SKW_GREATER && LA38_0<=RULE_SKW_GREATEREQUAL)||(LA38_0>=RULE_SKW_LESS && LA38_0<=RULE_SKW_LESSEQUAL)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalPreprocessParser.g:2377:3: ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) )
            	    {
            	    // InternalPreprocessParser.g:2377:3: ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) )
            	    int alt37=4;
            	    switch ( input.LA(1) ) {
            	    case RULE_SKW_LESS:
            	        {
            	        alt37=1;
            	        }
            	        break;
            	    case RULE_SKW_GREATER:
            	        {
            	        alt37=2;
            	        }
            	        break;
            	    case RULE_SKW_LESSEQUAL:
            	        {
            	        alt37=3;
            	        }
            	        break;
            	    case RULE_SKW_GREATEREQUAL:
            	        {
            	        alt37=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 37, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt37) {
            	        case 1 :
            	            // InternalPreprocessParser.g:2377:4: ( (lv_op_2_0= RULE_SKW_LESS ) )
            	            {
            	            // InternalPreprocessParser.g:2377:4: ( (lv_op_2_0= RULE_SKW_LESS ) )
            	            // InternalPreprocessParser.g:2378:1: (lv_op_2_0= RULE_SKW_LESS )
            	            {
            	            // InternalPreprocessParser.g:2378:1: (lv_op_2_0= RULE_SKW_LESS )
            	            // InternalPreprocessParser.g:2379:3: lv_op_2_0= RULE_SKW_LESS
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_LESS,FOLLOW_23); if (state.failed) return current;
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
            	            // InternalPreprocessParser.g:2396:6: ( (lv_op_3_0= RULE_SKW_GREATER ) )
            	            {
            	            // InternalPreprocessParser.g:2396:6: ( (lv_op_3_0= RULE_SKW_GREATER ) )
            	            // InternalPreprocessParser.g:2397:1: (lv_op_3_0= RULE_SKW_GREATER )
            	            {
            	            // InternalPreprocessParser.g:2397:1: (lv_op_3_0= RULE_SKW_GREATER )
            	            // InternalPreprocessParser.g:2398:3: lv_op_3_0= RULE_SKW_GREATER
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_GREATER,FOLLOW_23); if (state.failed) return current;
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
            	            // InternalPreprocessParser.g:2415:6: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
            	            {
            	            // InternalPreprocessParser.g:2415:6: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
            	            // InternalPreprocessParser.g:2416:1: (lv_op_4_0= RULE_SKW_LESSEQUAL )
            	            {
            	            // InternalPreprocessParser.g:2416:1: (lv_op_4_0= RULE_SKW_LESSEQUAL )
            	            // InternalPreprocessParser.g:2417:3: lv_op_4_0= RULE_SKW_LESSEQUAL
            	            {
            	            lv_op_4_0=(Token)match(input,RULE_SKW_LESSEQUAL,FOLLOW_23); if (state.failed) return current;
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
            	            // InternalPreprocessParser.g:2434:6: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
            	            {
            	            // InternalPreprocessParser.g:2434:6: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
            	            // InternalPreprocessParser.g:2435:1: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
            	            {
            	            // InternalPreprocessParser.g:2435:1: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
            	            // InternalPreprocessParser.g:2436:3: lv_op_5_0= RULE_SKW_GREATEREQUAL
            	            {
            	            lv_op_5_0=(Token)match(input,RULE_SKW_GREATEREQUAL,FOLLOW_23); if (state.failed) return current;
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

            	    // InternalPreprocessParser.g:2452:3: ( (lv_expr_6_0= ruleShiftExpression ) )
            	    // InternalPreprocessParser.g:2453:1: (lv_expr_6_0= ruleShiftExpression )
            	    {
            	    // InternalPreprocessParser.g:2453:1: (lv_expr_6_0= ruleShiftExpression )
            	    // InternalPreprocessParser.g:2454:3: lv_expr_6_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExprShiftExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_31);
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
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleShiftExpression"
    // InternalPreprocessParser.g:2478:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalPreprocessParser.g:2479:2: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalPreprocessParser.g:2480:2: iv_ruleShiftExpression= ruleShiftExpression EOF
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
    // InternalPreprocessParser.g:2487:1: ruleShiftExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2490:28: ( ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* ) )
            // InternalPreprocessParser.g:2491:1: ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2491:1: ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* )
            // InternalPreprocessParser.g:2491:2: () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )*
            {
            // InternalPreprocessParser.g:2491:2: ()
            // InternalPreprocessParser.g:2492:2: 
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

            // InternalPreprocessParser.g:2500:2: ( (lv_expr_1_0= ruleAdditiveExpression ) )
            // InternalPreprocessParser.g:2501:1: (lv_expr_1_0= ruleAdditiveExpression )
            {
            // InternalPreprocessParser.g:2501:1: (lv_expr_1_0= ruleAdditiveExpression )
            // InternalPreprocessParser.g:2502:3: lv_expr_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getExprAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_32);
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

            // InternalPreprocessParser.g:2518:2: ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_SKW_LEFTSHIFT||LA40_0==RULE_SKW_RIGHTSHIFT) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalPreprocessParser.g:2518:3: ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalPreprocessParser.g:2518:3: ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) )
            	    int alt39=2;
            	    int LA39_0 = input.LA(1);

            	    if ( (LA39_0==RULE_SKW_LEFTSHIFT) ) {
            	        alt39=1;
            	    }
            	    else if ( (LA39_0==RULE_SKW_RIGHTSHIFT) ) {
            	        alt39=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 39, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt39) {
            	        case 1 :
            	            // InternalPreprocessParser.g:2518:4: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
            	            {
            	            // InternalPreprocessParser.g:2518:4: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
            	            // InternalPreprocessParser.g:2519:1: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
            	            {
            	            // InternalPreprocessParser.g:2519:1: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
            	            // InternalPreprocessParser.g:2520:3: lv_op_2_0= RULE_SKW_LEFTSHIFT
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_LEFTSHIFT,FOLLOW_23); if (state.failed) return current;
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
            	            // InternalPreprocessParser.g:2537:6: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
            	            {
            	            // InternalPreprocessParser.g:2537:6: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
            	            // InternalPreprocessParser.g:2538:1: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
            	            {
            	            // InternalPreprocessParser.g:2538:1: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
            	            // InternalPreprocessParser.g:2539:3: lv_op_3_0= RULE_SKW_RIGHTSHIFT
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_RIGHTSHIFT,FOLLOW_23); if (state.failed) return current;
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

            	    // InternalPreprocessParser.g:2555:3: ( (lv_expr_4_0= ruleAdditiveExpression ) )
            	    // InternalPreprocessParser.g:2556:1: (lv_expr_4_0= ruleAdditiveExpression )
            	    {
            	    // InternalPreprocessParser.g:2556:1: (lv_expr_4_0= ruleAdditiveExpression )
            	    // InternalPreprocessParser.g:2557:3: lv_expr_4_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getExprAdditiveExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_32);
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
            	    break loop40;
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
    // InternalPreprocessParser.g:2581:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalPreprocessParser.g:2582:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalPreprocessParser.g:2583:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalPreprocessParser.g:2590:1: ruleAdditiveExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2593:28: ( ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalPreprocessParser.g:2594:1: ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2594:1: ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* )
            // InternalPreprocessParser.g:2594:2: () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )*
            {
            // InternalPreprocessParser.g:2594:2: ()
            // InternalPreprocessParser.g:2595:2: 
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

            // InternalPreprocessParser.g:2603:2: ( (lv_expr_1_0= ruleMultiplicativeExpression ) )
            // InternalPreprocessParser.g:2604:1: (lv_expr_1_0= ruleMultiplicativeExpression )
            {
            // InternalPreprocessParser.g:2604:1: (lv_expr_1_0= ruleMultiplicativeExpression )
            // InternalPreprocessParser.g:2605:3: lv_expr_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExprMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_33);
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

            // InternalPreprocessParser.g:2621:2: ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_SKW_MINUS||LA42_0==RULE_SKW_PLUS) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalPreprocessParser.g:2621:3: ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalPreprocessParser.g:2621:3: ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) )
            	    int alt41=2;
            	    int LA41_0 = input.LA(1);

            	    if ( (LA41_0==RULE_SKW_PLUS) ) {
            	        alt41=1;
            	    }
            	    else if ( (LA41_0==RULE_SKW_MINUS) ) {
            	        alt41=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 41, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt41) {
            	        case 1 :
            	            // InternalPreprocessParser.g:2621:4: ( (lv_op_2_0= RULE_SKW_PLUS ) )
            	            {
            	            // InternalPreprocessParser.g:2621:4: ( (lv_op_2_0= RULE_SKW_PLUS ) )
            	            // InternalPreprocessParser.g:2622:1: (lv_op_2_0= RULE_SKW_PLUS )
            	            {
            	            // InternalPreprocessParser.g:2622:1: (lv_op_2_0= RULE_SKW_PLUS )
            	            // InternalPreprocessParser.g:2623:3: lv_op_2_0= RULE_SKW_PLUS
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_PLUS,FOLLOW_23); if (state.failed) return current;
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
            	            // InternalPreprocessParser.g:2640:6: ( (lv_op_3_0= RULE_SKW_MINUS ) )
            	            {
            	            // InternalPreprocessParser.g:2640:6: ( (lv_op_3_0= RULE_SKW_MINUS ) )
            	            // InternalPreprocessParser.g:2641:1: (lv_op_3_0= RULE_SKW_MINUS )
            	            {
            	            // InternalPreprocessParser.g:2641:1: (lv_op_3_0= RULE_SKW_MINUS )
            	            // InternalPreprocessParser.g:2642:3: lv_op_3_0= RULE_SKW_MINUS
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_23); if (state.failed) return current;
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

            	    // InternalPreprocessParser.g:2658:3: ( (lv_expr_4_0= ruleMultiplicativeExpression ) )
            	    // InternalPreprocessParser.g:2659:1: (lv_expr_4_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalPreprocessParser.g:2659:1: (lv_expr_4_0= ruleMultiplicativeExpression )
            	    // InternalPreprocessParser.g:2660:3: lv_expr_4_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExprMultiplicativeExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_33);
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
            	    break loop42;
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
    // InternalPreprocessParser.g:2684:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalPreprocessParser.g:2685:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalPreprocessParser.g:2686:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalPreprocessParser.g:2693:1: ruleMultiplicativeExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        Token lv_op_4_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_5_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2696:28: ( ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* ) )
            // InternalPreprocessParser.g:2697:1: ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* )
            {
            // InternalPreprocessParser.g:2697:1: ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* )
            // InternalPreprocessParser.g:2697:2: () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )*
            {
            // InternalPreprocessParser.g:2697:2: ()
            // InternalPreprocessParser.g:2698:2: 
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

            // InternalPreprocessParser.g:2706:2: ( (lv_expr_1_0= ruleCastExpression ) )
            // InternalPreprocessParser.g:2707:1: (lv_expr_1_0= ruleCastExpression )
            {
            // InternalPreprocessParser.g:2707:1: (lv_expr_1_0= ruleCastExpression )
            // InternalPreprocessParser.g:2708:3: lv_expr_1_0= ruleCastExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExprCastExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_34);
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

            // InternalPreprocessParser.g:2724:2: ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_SKW_DIV||LA44_0==RULE_SKW_MOD||LA44_0==RULE_SKW_STAR) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalPreprocessParser.g:2724:3: ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) )
            	    {
            	    // InternalPreprocessParser.g:2724:3: ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) )
            	    int alt43=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_SKW_STAR:
            	        {
            	        alt43=1;
            	        }
            	        break;
            	    case RULE_SKW_DIV:
            	        {
            	        alt43=2;
            	        }
            	        break;
            	    case RULE_SKW_MOD:
            	        {
            	        alt43=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 43, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt43) {
            	        case 1 :
            	            // InternalPreprocessParser.g:2724:4: ( (lv_op_2_0= RULE_SKW_STAR ) )
            	            {
            	            // InternalPreprocessParser.g:2724:4: ( (lv_op_2_0= RULE_SKW_STAR ) )
            	            // InternalPreprocessParser.g:2725:1: (lv_op_2_0= RULE_SKW_STAR )
            	            {
            	            // InternalPreprocessParser.g:2725:1: (lv_op_2_0= RULE_SKW_STAR )
            	            // InternalPreprocessParser.g:2726:3: lv_op_2_0= RULE_SKW_STAR
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_STAR,FOLLOW_23); if (state.failed) return current;
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
            	            // InternalPreprocessParser.g:2743:6: ( (lv_op_3_0= RULE_SKW_DIV ) )
            	            {
            	            // InternalPreprocessParser.g:2743:6: ( (lv_op_3_0= RULE_SKW_DIV ) )
            	            // InternalPreprocessParser.g:2744:1: (lv_op_3_0= RULE_SKW_DIV )
            	            {
            	            // InternalPreprocessParser.g:2744:1: (lv_op_3_0= RULE_SKW_DIV )
            	            // InternalPreprocessParser.g:2745:3: lv_op_3_0= RULE_SKW_DIV
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_DIV,FOLLOW_23); if (state.failed) return current;
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
            	            // InternalPreprocessParser.g:2762:6: ( (lv_op_4_0= RULE_SKW_MOD ) )
            	            {
            	            // InternalPreprocessParser.g:2762:6: ( (lv_op_4_0= RULE_SKW_MOD ) )
            	            // InternalPreprocessParser.g:2763:1: (lv_op_4_0= RULE_SKW_MOD )
            	            {
            	            // InternalPreprocessParser.g:2763:1: (lv_op_4_0= RULE_SKW_MOD )
            	            // InternalPreprocessParser.g:2764:3: lv_op_4_0= RULE_SKW_MOD
            	            {
            	            lv_op_4_0=(Token)match(input,RULE_SKW_MOD,FOLLOW_23); if (state.failed) return current;
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

            	    // InternalPreprocessParser.g:2780:3: ( (lv_expr_5_0= ruleCastExpression ) )
            	    // InternalPreprocessParser.g:2781:1: (lv_expr_5_0= ruleCastExpression )
            	    {
            	    // InternalPreprocessParser.g:2781:1: (lv_expr_5_0= ruleCastExpression )
            	    // InternalPreprocessParser.g:2782:3: lv_expr_5_0= ruleCastExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExprCastExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_34);
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
            	    break loop44;
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
    // InternalPreprocessParser.g:2806:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalPreprocessParser.g:2807:2: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalPreprocessParser.g:2808:2: iv_ruleCastExpression= ruleCastExpression EOF
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
    // InternalPreprocessParser.g:2815:1: ruleCastExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2818:28: ( ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // InternalPreprocessParser.g:2819:1: ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // InternalPreprocessParser.g:2819:1: ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // InternalPreprocessParser.g:2819:2: () ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // InternalPreprocessParser.g:2819:2: ()
            // InternalPreprocessParser.g:2820:2: 
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

            // InternalPreprocessParser.g:2828:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // InternalPreprocessParser.g:2829:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // InternalPreprocessParser.g:2829:1: (lv_expr_1_0= ruleUnaryExpression )
            // InternalPreprocessParser.g:2830:3: lv_expr_1_0= ruleUnaryExpression
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
    // InternalPreprocessParser.g:2854:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalPreprocessParser.g:2855:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalPreprocessParser.g:2856:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalPreprocessParser.g:2863:1: ruleUnaryExpression returns [EObject current=null] : ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;

        Enumerator lv_op_2_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2866:28: ( ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) ) )
            // InternalPreprocessParser.g:2867:1: ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) )
            {
            // InternalPreprocessParser.g:2867:1: ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) )
            // InternalPreprocessParser.g:2867:2: () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
            {
            // InternalPreprocessParser.g:2867:2: ()
            // InternalPreprocessParser.g:2868:2: 
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

            // InternalPreprocessParser.g:2876:2: ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID||(LA45_0>=RULE_CHAR_LITERAL && LA45_0<=RULE_BIN_LITERAL)||LA45_0==RULE_FLOAT_LITERAL||LA45_0==RULE_SKW_LEFTPAREN) ) {
                alt45=1;
            }
            else if ( ((LA45_0>=SKW_AND && LA45_0<=SKW_TILDE)) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalPreprocessParser.g:2876:3: ( (lv_expr_1_0= rulePostfixExpression ) )
                    {
                    // InternalPreprocessParser.g:2876:3: ( (lv_expr_1_0= rulePostfixExpression ) )
                    // InternalPreprocessParser.g:2877:1: (lv_expr_1_0= rulePostfixExpression )
                    {
                    // InternalPreprocessParser.g:2877:1: (lv_expr_1_0= rulePostfixExpression )
                    // InternalPreprocessParser.g:2878:3: lv_expr_1_0= rulePostfixExpression
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
                    // InternalPreprocessParser.g:2895:6: ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
                    {
                    // InternalPreprocessParser.g:2895:6: ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
                    // InternalPreprocessParser.g:2895:7: ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) )
                    {
                    // InternalPreprocessParser.g:2895:7: ( (lv_op_2_0= ruleUnaryOperator ) )
                    // InternalPreprocessParser.g:2896:1: (lv_op_2_0= ruleUnaryOperator )
                    {
                    // InternalPreprocessParser.g:2896:1: (lv_op_2_0= ruleUnaryOperator )
                    // InternalPreprocessParser.g:2897:3: lv_op_2_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorEnumRuleCall_1_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_23);
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

                    // InternalPreprocessParser.g:2913:2: ( (lv_expr_3_0= ruleCastExpression ) )
                    // InternalPreprocessParser.g:2914:1: (lv_expr_3_0= ruleCastExpression )
                    {
                    // InternalPreprocessParser.g:2914:1: (lv_expr_3_0= ruleCastExpression )
                    // InternalPreprocessParser.g:2915:3: lv_expr_3_0= ruleCastExpression
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


    // $ANTLR start "entryRulePostfixExpression"
    // InternalPreprocessParser.g:2939:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalPreprocessParser.g:2940:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalPreprocessParser.g:2941:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalPreprocessParser.g:2948:1: rulePostfixExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= rulePrimaryExpression ) ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2951:28: ( ( () ( (lv_expr_1_0= rulePrimaryExpression ) ) ) )
            // InternalPreprocessParser.g:2952:1: ( () ( (lv_expr_1_0= rulePrimaryExpression ) ) )
            {
            // InternalPreprocessParser.g:2952:1: ( () ( (lv_expr_1_0= rulePrimaryExpression ) ) )
            // InternalPreprocessParser.g:2952:2: () ( (lv_expr_1_0= rulePrimaryExpression ) )
            {
            // InternalPreprocessParser.g:2952:2: ()
            // InternalPreprocessParser.g:2953:2: 
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

            // InternalPreprocessParser.g:2961:2: ( (lv_expr_1_0= rulePrimaryExpression ) )
            // InternalPreprocessParser.g:2962:1: (lv_expr_1_0= rulePrimaryExpression )
            {
            // InternalPreprocessParser.g:2962:1: (lv_expr_1_0= rulePrimaryExpression )
            // InternalPreprocessParser.g:2963:3: lv_expr_1_0= rulePrimaryExpression
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
    // InternalPreprocessParser.g:2987:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalPreprocessParser.g:2988:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalPreprocessParser.g:2989:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalPreprocessParser.g:2996:1: rulePrimaryExpression returns [EObject current=null] : ( () ( ( (lv_id_1_0= RULE_ID ) ) | ( (lv_const_2_0= ruleConstant ) ) | (this_SKW_LEFTPAREN_3= RULE_SKW_LEFTPAREN ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN ) ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_id_1_0=null;
        Token this_SKW_LEFTPAREN_3=null;
        Token this_SKW_RIGHTPAREN_5=null;
        AntlrDatatypeRuleToken lv_const_2_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:2999:28: ( ( () ( ( (lv_id_1_0= RULE_ID ) ) | ( (lv_const_2_0= ruleConstant ) ) | (this_SKW_LEFTPAREN_3= RULE_SKW_LEFTPAREN ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN ) ) ) )
            // InternalPreprocessParser.g:3000:1: ( () ( ( (lv_id_1_0= RULE_ID ) ) | ( (lv_const_2_0= ruleConstant ) ) | (this_SKW_LEFTPAREN_3= RULE_SKW_LEFTPAREN ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN ) ) )
            {
            // InternalPreprocessParser.g:3000:1: ( () ( ( (lv_id_1_0= RULE_ID ) ) | ( (lv_const_2_0= ruleConstant ) ) | (this_SKW_LEFTPAREN_3= RULE_SKW_LEFTPAREN ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN ) ) )
            // InternalPreprocessParser.g:3000:2: () ( ( (lv_id_1_0= RULE_ID ) ) | ( (lv_const_2_0= ruleConstant ) ) | (this_SKW_LEFTPAREN_3= RULE_SKW_LEFTPAREN ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN ) )
            {
            // InternalPreprocessParser.g:3000:2: ()
            // InternalPreprocessParser.g:3001:2: 
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

            // InternalPreprocessParser.g:3009:2: ( ( (lv_id_1_0= RULE_ID ) ) | ( (lv_const_2_0= ruleConstant ) ) | (this_SKW_LEFTPAREN_3= RULE_SKW_LEFTPAREN ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN ) )
            int alt46=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt46=1;
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
                alt46=2;
                }
                break;
            case RULE_SKW_LEFTPAREN:
                {
                alt46=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalPreprocessParser.g:3009:3: ( (lv_id_1_0= RULE_ID ) )
                    {
                    // InternalPreprocessParser.g:3009:3: ( (lv_id_1_0= RULE_ID ) )
                    // InternalPreprocessParser.g:3010:1: (lv_id_1_0= RULE_ID )
                    {
                    // InternalPreprocessParser.g:3010:1: (lv_id_1_0= RULE_ID )
                    // InternalPreprocessParser.g:3011:3: lv_id_1_0= RULE_ID
                    {
                    lv_id_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_id_1_0, grammarAccess.getPrimaryExpressionAccess().getIdIDTerminalRuleCall_1_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"id",
                              		lv_id_1_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.ID");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPreprocessParser.g:3028:6: ( (lv_const_2_0= ruleConstant ) )
                    {
                    // InternalPreprocessParser.g:3028:6: ( (lv_const_2_0= ruleConstant ) )
                    // InternalPreprocessParser.g:3029:1: (lv_const_2_0= ruleConstant )
                    {
                    // InternalPreprocessParser.g:3029:1: (lv_const_2_0= ruleConstant )
                    // InternalPreprocessParser.g:3030:3: lv_const_2_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getConstConstantParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_const_2_0=ruleConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"const",
                              		lv_const_2_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.Constant");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalPreprocessParser.g:3047:6: (this_SKW_LEFTPAREN_3= RULE_SKW_LEFTPAREN ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN )
                    {
                    // InternalPreprocessParser.g:3047:6: (this_SKW_LEFTPAREN_3= RULE_SKW_LEFTPAREN ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN )
                    // InternalPreprocessParser.g:3047:7: this_SKW_LEFTPAREN_3= RULE_SKW_LEFTPAREN ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN
                    {
                    this_SKW_LEFTPAREN_3=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LEFTPAREN_3, grammarAccess.getPrimaryExpressionAccess().getSKW_LEFTPARENTerminalRuleCall_1_2_0()); 
                          
                    }
                    // InternalPreprocessParser.g:3051:1: ( (lv_expr_4_0= ruleExpression ) )
                    // InternalPreprocessParser.g:3052:1: (lv_expr_4_0= ruleExpression )
                    {
                    // InternalPreprocessParser.g:3052:1: (lv_expr_4_0= ruleExpression )
                    // InternalPreprocessParser.g:3053:3: lv_expr_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExprExpressionParserRuleCall_1_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_14);
                    lv_expr_4_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_4_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_SKW_RIGHTPAREN_5=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_RIGHTPAREN_5, grammarAccess.getPrimaryExpressionAccess().getSKW_RIGHTPARENTerminalRuleCall_1_2_2()); 
                          
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
    // InternalPreprocessParser.g:3081:1: entryRuleConstant returns [String current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final String entryRuleConstant() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConstant = null;


        try {
            // InternalPreprocessParser.g:3082:1: (iv_ruleConstant= ruleConstant EOF )
            // InternalPreprocessParser.g:3083:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalPreprocessParser.g:3090:1: ruleConstant returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL ) ;
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
            // InternalPreprocessParser.g:3094:6: ( (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL ) )
            // InternalPreprocessParser.g:3095:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL )
            {
            // InternalPreprocessParser.g:3095:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL )
            int alt47=7;
            switch ( input.LA(1) ) {
            case RULE_HEX_LITERAL:
                {
                alt47=1;
                }
                break;
            case RULE_OCTAL_LITERAL:
                {
                alt47=2;
                }
                break;
            case RULE_DECIMAL_LITERAL:
                {
                alt47=3;
                }
                break;
            case RULE_CHAR_LITERAL:
                {
                alt47=4;
                }
                break;
            case RULE_STRING_LITERAL:
                {
                alt47=5;
                }
                break;
            case RULE_FLOAT_LITERAL:
                {
                alt47=6;
                }
                break;
            case RULE_BIN_LITERAL:
                {
                alt47=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalPreprocessParser.g:3095:6: this_HEX_LITERAL_0= RULE_HEX_LITERAL
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
                    // InternalPreprocessParser.g:3103:10: this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL
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
                    // InternalPreprocessParser.g:3111:10: this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL
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
                    // InternalPreprocessParser.g:3119:10: this_CHAR_LITERAL_3= RULE_CHAR_LITERAL
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
                    // InternalPreprocessParser.g:3127:10: this_STRING_LITERAL_4= RULE_STRING_LITERAL
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
                    // InternalPreprocessParser.g:3135:10: this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL
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
                    // InternalPreprocessParser.g:3143:10: this_BIN_LITERAL_6= RULE_BIN_LITERAL
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
    // InternalPreprocessParser.g:3160:1: entryRuleSpecialKeywords returns [String current=null] : iv_ruleSpecialKeywords= ruleSpecialKeywords EOF ;
    public final String entryRuleSpecialKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpecialKeywords = null;


        try {
            // InternalPreprocessParser.g:3161:1: (iv_ruleSpecialKeywords= ruleSpecialKeywords EOF )
            // InternalPreprocessParser.g:3162:2: iv_ruleSpecialKeywords= ruleSpecialKeywords EOF
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
    // InternalPreprocessParser.g:3169:1: ruleSpecialKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_PLUSPLUS_28= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_29= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_30= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_31= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_32= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_33= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_34= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_35= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_36= RULE_SKW_STAR | this_SKW_TILDE_37= RULE_SKW_TILDE ) ;
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
        Token this_SKW_PLUSPLUS_28=null;
        Token this_SKW_QUESTION_29=null;
        Token this_SKW_RIGHTBRACE_30=null;
        Token this_SKW_RIGHTBRACKET_31=null;
        Token this_SKW_RIGHTPAREN_32=null;
        Token this_SKW_RIGHTSHIFT_33=null;
        Token this_SKW_SEMI_34=null;
        Token this_SKW_SINGLEQUOTE_35=null;
        Token this_SKW_STAR_36=null;
        Token this_SKW_TILDE_37=null;

         enterRule(); 
            
        try {
            // InternalPreprocessParser.g:3173:6: ( (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_PLUSPLUS_28= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_29= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_30= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_31= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_32= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_33= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_34= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_35= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_36= RULE_SKW_STAR | this_SKW_TILDE_37= RULE_SKW_TILDE ) )
            // InternalPreprocessParser.g:3174:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_PLUSPLUS_28= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_29= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_30= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_31= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_32= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_33= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_34= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_35= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_36= RULE_SKW_STAR | this_SKW_TILDE_37= RULE_SKW_TILDE )
            {
            // InternalPreprocessParser.g:3174:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_PLUSPLUS_28= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_29= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_30= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_31= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_32= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_33= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_34= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_35= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_36= RULE_SKW_STAR | this_SKW_TILDE_37= RULE_SKW_TILDE )
            int alt48=38;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // InternalPreprocessParser.g:3174:6: this_SKW_AND_0= RULE_SKW_AND
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
                    // InternalPreprocessParser.g:3182:10: this_SKW_ANDAND_1= RULE_SKW_ANDAND
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
                    // InternalPreprocessParser.g:3190:10: this_SKW_ASSIGN_2= RULE_SKW_ASSIGN
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
                    // InternalPreprocessParser.g:3198:10: this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH
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
                    // InternalPreprocessParser.g:3206:10: this_SKW_CARET_4= RULE_SKW_CARET
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
                    // InternalPreprocessParser.g:3214:10: this_SKW_COMMA_5= RULE_SKW_COMMA
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
                    // InternalPreprocessParser.g:3222:10: this_SKW_COLON_6= RULE_SKW_COLON
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
                    // InternalPreprocessParser.g:3230:10: this_SKW_DIV_7= RULE_SKW_DIV
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
                    // InternalPreprocessParser.g:3238:10: this_SKW_DOT_8= RULE_SKW_DOT
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
                    // InternalPreprocessParser.g:3246:10: this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE
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
                    // InternalPreprocessParser.g:3254:10: this_SKW_EQUAL_10= RULE_SKW_EQUAL
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
                    // InternalPreprocessParser.g:3262:10: this_SKW_GREATER_11= RULE_SKW_GREATER
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
                    // InternalPreprocessParser.g:3270:10: this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL
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
                    // InternalPreprocessParser.g:3278:10: this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE
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
                    // InternalPreprocessParser.g:3286:10: this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET
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
                    // InternalPreprocessParser.g:3294:10: this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN
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
                    // InternalPreprocessParser.g:3302:10: this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT
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
                    // InternalPreprocessParser.g:3310:10: this_SKW_LESS_17= RULE_SKW_LESS
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
                    // InternalPreprocessParser.g:3318:10: this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL
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
                    // InternalPreprocessParser.g:3326:10: this_SKW_MINUS_19= RULE_SKW_MINUS
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
                    // InternalPreprocessParser.g:3334:10: this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS
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
                    // InternalPreprocessParser.g:3342:10: this_SKW_MOD_21= RULE_SKW_MOD
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
                    // InternalPreprocessParser.g:3350:10: this_SKW_NOT_22= RULE_SKW_NOT
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
                    // InternalPreprocessParser.g:3358:10: this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL
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
                    // InternalPreprocessParser.g:3366:10: this_SKW_OR_24= RULE_SKW_OR
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
                    // InternalPreprocessParser.g:3374:10: this_SKW_OROR_25= RULE_SKW_OROR
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
                    // InternalPreprocessParser.g:3382:10: this_SKW_PLUS_26= RULE_SKW_PLUS
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
                    // InternalPreprocessParser.g:3390:10: this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS
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
                    // InternalPreprocessParser.g:3398:10: this_SKW_PLUSPLUS_28= RULE_SKW_PLUSPLUS
                    {
                    this_SKW_PLUSPLUS_28=(Token)match(input,RULE_SKW_PLUSPLUS,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_PLUSPLUS_28);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_PLUSPLUS_28, grammarAccess.getSpecialKeywordsAccess().getSKW_PLUSPLUSTerminalRuleCall_28()); 
                          
                    }

                    }
                    break;
                case 30 :
                    // InternalPreprocessParser.g:3406:10: this_SKW_QUESTION_29= RULE_SKW_QUESTION
                    {
                    this_SKW_QUESTION_29=(Token)match(input,RULE_SKW_QUESTION,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_QUESTION_29);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_QUESTION_29, grammarAccess.getSpecialKeywordsAccess().getSKW_QUESTIONTerminalRuleCall_29()); 
                          
                    }

                    }
                    break;
                case 31 :
                    // InternalPreprocessParser.g:3414:10: this_SKW_RIGHTBRACE_30= RULE_SKW_RIGHTBRACE
                    {
                    this_SKW_RIGHTBRACE_30=(Token)match(input,RULE_SKW_RIGHTBRACE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_RIGHTBRACE_30);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_RIGHTBRACE_30, grammarAccess.getSpecialKeywordsAccess().getSKW_RIGHTBRACETerminalRuleCall_30()); 
                          
                    }

                    }
                    break;
                case 32 :
                    // InternalPreprocessParser.g:3422:10: this_SKW_RIGHTBRACKET_31= RULE_SKW_RIGHTBRACKET
                    {
                    this_SKW_RIGHTBRACKET_31=(Token)match(input,RULE_SKW_RIGHTBRACKET,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_RIGHTBRACKET_31);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_RIGHTBRACKET_31, grammarAccess.getSpecialKeywordsAccess().getSKW_RIGHTBRACKETTerminalRuleCall_31()); 
                          
                    }

                    }
                    break;
                case 33 :
                    // InternalPreprocessParser.g:3430:10: this_SKW_RIGHTPAREN_32= RULE_SKW_RIGHTPAREN
                    {
                    this_SKW_RIGHTPAREN_32=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_RIGHTPAREN_32);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_RIGHTPAREN_32, grammarAccess.getSpecialKeywordsAccess().getSKW_RIGHTPARENTerminalRuleCall_32()); 
                          
                    }

                    }
                    break;
                case 34 :
                    // InternalPreprocessParser.g:3438:10: this_SKW_RIGHTSHIFT_33= RULE_SKW_RIGHTSHIFT
                    {
                    this_SKW_RIGHTSHIFT_33=(Token)match(input,RULE_SKW_RIGHTSHIFT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_RIGHTSHIFT_33);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_RIGHTSHIFT_33, grammarAccess.getSpecialKeywordsAccess().getSKW_RIGHTSHIFTTerminalRuleCall_33()); 
                          
                    }

                    }
                    break;
                case 35 :
                    // InternalPreprocessParser.g:3446:10: this_SKW_SEMI_34= RULE_SKW_SEMI
                    {
                    this_SKW_SEMI_34=(Token)match(input,RULE_SKW_SEMI,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_SEMI_34);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_SEMI_34, grammarAccess.getSpecialKeywordsAccess().getSKW_SEMITerminalRuleCall_34()); 
                          
                    }

                    }
                    break;
                case 36 :
                    // InternalPreprocessParser.g:3454:10: this_SKW_SINGLEQUOTE_35= RULE_SKW_SINGLEQUOTE
                    {
                    this_SKW_SINGLEQUOTE_35=(Token)match(input,RULE_SKW_SINGLEQUOTE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_SINGLEQUOTE_35);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_SINGLEQUOTE_35, grammarAccess.getSpecialKeywordsAccess().getSKW_SINGLEQUOTETerminalRuleCall_35()); 
                          
                    }

                    }
                    break;
                case 37 :
                    // InternalPreprocessParser.g:3462:10: this_SKW_STAR_36= RULE_SKW_STAR
                    {
                    this_SKW_STAR_36=(Token)match(input,RULE_SKW_STAR,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_STAR_36);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_STAR_36, grammarAccess.getSpecialKeywordsAccess().getSKW_STARTerminalRuleCall_36()); 
                          
                    }

                    }
                    break;
                case 38 :
                    // InternalPreprocessParser.g:3470:10: this_SKW_TILDE_37= RULE_SKW_TILDE
                    {
                    this_SKW_TILDE_37=(Token)match(input,RULE_SKW_TILDE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_TILDE_37);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_TILDE_37, grammarAccess.getSpecialKeywordsAccess().getSKW_TILDETerminalRuleCall_37()); 
                          
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


    // $ANTLR start "ruleUnaryOperator"
    // InternalPreprocessParser.g:3485:1: ruleUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= SKW_AND ) | (enumLiteral_1= SKW_STAR ) | (enumLiteral_2= SKW_PLUS ) | (enumLiteral_3= SKW_MINUS ) | (enumLiteral_4= SKW_TILDE ) | (enumLiteral_5= SKW_NOT ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // InternalPreprocessParser.g:3487:28: ( ( (enumLiteral_0= SKW_AND ) | (enumLiteral_1= SKW_STAR ) | (enumLiteral_2= SKW_PLUS ) | (enumLiteral_3= SKW_MINUS ) | (enumLiteral_4= SKW_TILDE ) | (enumLiteral_5= SKW_NOT ) ) )
            // InternalPreprocessParser.g:3488:1: ( (enumLiteral_0= SKW_AND ) | (enumLiteral_1= SKW_STAR ) | (enumLiteral_2= SKW_PLUS ) | (enumLiteral_3= SKW_MINUS ) | (enumLiteral_4= SKW_TILDE ) | (enumLiteral_5= SKW_NOT ) )
            {
            // InternalPreprocessParser.g:3488:1: ( (enumLiteral_0= SKW_AND ) | (enumLiteral_1= SKW_STAR ) | (enumLiteral_2= SKW_PLUS ) | (enumLiteral_3= SKW_MINUS ) | (enumLiteral_4= SKW_TILDE ) | (enumLiteral_5= SKW_NOT ) )
            int alt49=6;
            switch ( input.LA(1) ) {
            case SKW_AND:
                {
                alt49=1;
                }
                break;
            case SKW_STAR:
                {
                alt49=2;
                }
                break;
            case SKW_PLUS:
                {
                alt49=3;
                }
                break;
            case SKW_MINUS:
                {
                alt49=4;
                }
                break;
            case SKW_TILDE:
                {
                alt49=5;
                }
                break;
            case SKW_NOT:
                {
                alt49=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalPreprocessParser.g:3488:2: (enumLiteral_0= SKW_AND )
                    {
                    // InternalPreprocessParser.g:3488:2: (enumLiteral_0= SKW_AND )
                    // InternalPreprocessParser.g:3488:7: enumLiteral_0= SKW_AND
                    {
                    enumLiteral_0=(Token)match(input,SKW_AND,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getSKW_ANDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getSKW_ANDEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPreprocessParser.g:3494:6: (enumLiteral_1= SKW_STAR )
                    {
                    // InternalPreprocessParser.g:3494:6: (enumLiteral_1= SKW_STAR )
                    // InternalPreprocessParser.g:3494:11: enumLiteral_1= SKW_STAR
                    {
                    enumLiteral_1=(Token)match(input,SKW_STAR,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getSKW_STAREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getUnaryOperatorAccess().getSKW_STAREnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPreprocessParser.g:3500:6: (enumLiteral_2= SKW_PLUS )
                    {
                    // InternalPreprocessParser.g:3500:6: (enumLiteral_2= SKW_PLUS )
                    // InternalPreprocessParser.g:3500:11: enumLiteral_2= SKW_PLUS
                    {
                    enumLiteral_2=(Token)match(input,SKW_PLUS,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getSKW_PLUSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getUnaryOperatorAccess().getSKW_PLUSEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPreprocessParser.g:3506:6: (enumLiteral_3= SKW_MINUS )
                    {
                    // InternalPreprocessParser.g:3506:6: (enumLiteral_3= SKW_MINUS )
                    // InternalPreprocessParser.g:3506:11: enumLiteral_3= SKW_MINUS
                    {
                    enumLiteral_3=(Token)match(input,SKW_MINUS,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getSKW_MINUSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getUnaryOperatorAccess().getSKW_MINUSEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalPreprocessParser.g:3512:6: (enumLiteral_4= SKW_TILDE )
                    {
                    // InternalPreprocessParser.g:3512:6: (enumLiteral_4= SKW_TILDE )
                    // InternalPreprocessParser.g:3512:11: enumLiteral_4= SKW_TILDE
                    {
                    enumLiteral_4=(Token)match(input,SKW_TILDE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getSKW_TILDEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getUnaryOperatorAccess().getSKW_TILDEEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalPreprocessParser.g:3518:6: (enumLiteral_5= SKW_NOT )
                    {
                    // InternalPreprocessParser.g:3518:6: (enumLiteral_5= SKW_NOT )
                    // InternalPreprocessParser.g:3518:11: enumLiteral_5= SKW_NOT
                    {
                    enumLiteral_5=(Token)match(input,SKW_NOT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getSKW_NOTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getUnaryOperatorAccess().getSKW_NOTEnumLiteralDeclaration_5()); 
                          
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

    // $ANTLR start synpred2_InternalPreprocessParser
    public final void synpred2_InternalPreprocessParser_fragment() throws RecognitionException {   
        EObject lv_lines_2_0 = null;


        // InternalPreprocessParser.g:205:6: ( ( (lv_lines_2_0= ruleNewLineLine ) ) )
        // InternalPreprocessParser.g:205:6: ( (lv_lines_2_0= ruleNewLineLine ) )
        {
        // InternalPreprocessParser.g:205:6: ( (lv_lines_2_0= ruleNewLineLine ) )
        // InternalPreprocessParser.g:206:1: (lv_lines_2_0= ruleNewLineLine )
        {
        // InternalPreprocessParser.g:206:1: (lv_lines_2_0= ruleNewLineLine )
        // InternalPreprocessParser.g:207:3: lv_lines_2_0= ruleNewLineLine
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


        // InternalPreprocessParser.g:224:6: ( ( (lv_lines_3_0= ruleCode ) ) )
        // InternalPreprocessParser.g:224:6: ( (lv_lines_3_0= ruleCode ) )
        {
        // InternalPreprocessParser.g:224:6: ( (lv_lines_3_0= ruleCode ) )
        // InternalPreprocessParser.g:225:1: (lv_lines_3_0= ruleCode )
        {
        // InternalPreprocessParser.g:225:1: (lv_lines_3_0= ruleCode )
        // InternalPreprocessParser.g:226:3: lv_lines_3_0= ruleCode
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

        // InternalPreprocessParser.g:454:2: (this_WS_2= RULE_WS )
        // InternalPreprocessParser.g:454:2: this_WS_2= RULE_WS
        {
        this_WS_2=(Token)match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_InternalPreprocessParser

    // $ANTLR start synpred15_InternalPreprocessParser
    public final void synpred15_InternalPreprocessParser_fragment() throws RecognitionException {   
        Token this_WS_4=null;

        // InternalPreprocessParser.g:578:4: (this_WS_4= RULE_WS )
        // InternalPreprocessParser.g:578:4: this_WS_4= RULE_WS
        {
        this_WS_4=(Token)match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalPreprocessParser

    // $ANTLR start synpred20_InternalPreprocessParser
    public final void synpred20_InternalPreprocessParser_fragment() throws RecognitionException {   
        Token this_WS_8=null;

        // InternalPreprocessParser.g:686:2: (this_WS_8= RULE_WS )
        // InternalPreprocessParser.g:686:2: this_WS_8= RULE_WS
        {
        this_WS_8=(Token)match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_InternalPreprocessParser

    // $ANTLR start synpred23_InternalPreprocessParser
    public final void synpred23_InternalPreprocessParser_fragment() throws RecognitionException {   
        Token this_WS_2=null;

        // InternalPreprocessParser.g:816:2: (this_WS_2= RULE_WS )
        // InternalPreprocessParser.g:816:2: this_WS_2= RULE_WS
        {
        this_WS_2=(Token)match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_InternalPreprocessParser

    // $ANTLR start synpred45_InternalPreprocessParser
    public final void synpred45_InternalPreprocessParser_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_MyCode_0 = null;


        // InternalPreprocessParser.g:1568:5: (this_MyCode_0= ruleMyCode )
        // InternalPreprocessParser.g:1568:5: this_MyCode_0= ruleMyCode
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
    // $ANTLR end synpred45_InternalPreprocessParser

    // $ANTLR start synpred46_InternalPreprocessParser
    public final void synpred46_InternalPreprocessParser_fragment() throws RecognitionException {   
        Token this_WS_1=null;

        // InternalPreprocessParser.g:1579:10: (this_WS_1= RULE_WS )
        // InternalPreprocessParser.g:1579:10: this_WS_1= RULE_WS
        {
        this_WS_1=(Token)match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_InternalPreprocessParser

    // $ANTLR start synpred106_InternalPreprocessParser
    public final void synpred106_InternalPreprocessParser_fragment() throws RecognitionException {   
        Token this_SKW_PLUSPLUS_27=null;

        // InternalPreprocessParser.g:3390:10: (this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS )
        // InternalPreprocessParser.g:3390:10: this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS
        {
        this_SKW_PLUSPLUS_27=(Token)match(input,RULE_SKW_PLUSPLUS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred106_InternalPreprocessParser

    // $ANTLR start synpred107_InternalPreprocessParser
    public final void synpred107_InternalPreprocessParser_fragment() throws RecognitionException {   
        Token this_SKW_PLUSPLUS_28=null;

        // InternalPreprocessParser.g:3398:10: (this_SKW_PLUSPLUS_28= RULE_SKW_PLUSPLUS )
        // InternalPreprocessParser.g:3398:10: this_SKW_PLUSPLUS_28= RULE_SKW_PLUSPLUS
        {
        this_SKW_PLUSPLUS_28=(Token)match(input,RULE_SKW_PLUSPLUS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred107_InternalPreprocessParser

    // Delegated rules

    public final boolean synpred107_InternalPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred107_InternalPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_InternalPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_InternalPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred106_InternalPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_InternalPreprocessParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_InternalPreprocessParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_InternalPreprocessParser_fragment(); // can never throw exception
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
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA48 dfa48 = new DFA48(this);
    static final String DFA1_eotS =
        "\10\uffff";
    static final String DFA1_eofS =
        "\1\1\7\uffff";
    static final String DFA1_minS =
        "\1\12\1\uffff\1\13\1\12\1\0\3\uffff";
    static final String DFA1_maxS =
        "\1\124\1\uffff\1\32\1\124\1\0\3\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\4\3\uffff\1\3\1\1\1\2";
    static final String DFA1_specialS =
        "\4\uffff\1\0\3\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\3\5\1\uffff\5\5\2\uffff\1\4\3\uffff\1\3\1\5\2\uffff\6\5\2\uffff\1\5\6\uffff\10\5\1\uffff\35\5\1\uffff\1\5",
            "",
            "\7\6\1\1\1\6\2\uffff\1\6\3\uffff\1\6",
            "\1\6\3\5\1\uffff\5\5\2\uffff\1\5\3\uffff\1\3\1\5\2\uffff\6\5\2\uffff\1\5\6\uffff\10\5\1\uffff\35\5\1\uffff\1\5",
            "\1\uffff",
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
            return "()* loopback of 186:2: ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )*";
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
                        if ( (synpred2_InternalPreprocessParser()) ) {s = 7;}

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
        "\1\14\2\32\1\26\2\uffff";
    static final String DFA6_maxS =
        "\1\14\1\32\1\33\1\75\2\uffff";
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
            return "497:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )";
        }
    }
    static final String DFA25_eotS =
        "\73\uffff";
    static final String DFA25_eofS =
        "\1\1\72\uffff";
    static final String DFA25_minS =
        "\1\12\1\uffff\67\0\2\uffff";
    static final String DFA25_maxS =
        "\1\124\1\uffff\67\0\2\uffff";
    static final String DFA25_acceptS =
        "\1\uffff\1\3\67\uffff\1\1\1\2";
    static final String DFA25_specialS =
        "\2\uffff\1\44\1\12\1\51\1\22\1\13\1\45\1\56\1\32\1\52\1\20\1\43\1\57\1\10\1\42\1\2\1\46\1\61\1\16\1\33\1\3\1\66\1\25\1\63\1\30\1\5\1\17\1\65\1\31\1\34\1\11\1\36\1\4\1\0\1\35\1\6\1\47\1\26\1\37\1\60\1\15\1\54\1\27\1\62\1\7\1\41\1\1\1\55\1\53\1\50\1\21\1\64\1\24\1\40\1\14\1\23\2\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\1\1\4\1\5\1\6\1\uffff\1\13\1\10\1\12\1\11\1\7\2\uffff\1\1\3\uffff\1\70\1\2\2\uffff\1\64\1\65\1\61\1\63\1\62\1\67\2\uffff\1\66\6\uffff\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\uffff\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\uffff\1\3",
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
            "",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1567:1: (this_MyCode_0= ruleMyCode | this_WS_1= RULE_WS )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_34 = input.LA(1);

                         
                        int index25_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_34);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_47 = input.LA(1);

                         
                        int index25_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_47);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_16 = input.LA(1);

                         
                        int index25_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_16);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA25_21 = input.LA(1);

                         
                        int index25_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_21);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA25_33 = input.LA(1);

                         
                        int index25_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_33);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA25_26 = input.LA(1);

                         
                        int index25_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_26);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA25_36 = input.LA(1);

                         
                        int index25_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_36);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA25_45 = input.LA(1);

                         
                        int index25_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_45);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA25_14 = input.LA(1);

                         
                        int index25_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_14);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA25_31 = input.LA(1);

                         
                        int index25_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_31);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA25_3 = input.LA(1);

                         
                        int index25_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_3);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA25_6 = input.LA(1);

                         
                        int index25_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_6);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA25_55 = input.LA(1);

                         
                        int index25_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_55);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA25_41 = input.LA(1);

                         
                        int index25_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_41);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA25_19 = input.LA(1);

                         
                        int index25_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_19);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA25_27 = input.LA(1);

                         
                        int index25_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_27);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA25_11 = input.LA(1);

                         
                        int index25_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_11);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA25_51 = input.LA(1);

                         
                        int index25_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_51);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA25_5 = input.LA(1);

                         
                        int index25_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_5);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA25_56 = input.LA(1);

                         
                        int index25_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred46_InternalPreprocessParser()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_56);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA25_53 = input.LA(1);

                         
                        int index25_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_53);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA25_23 = input.LA(1);

                         
                        int index25_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_23);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA25_38 = input.LA(1);

                         
                        int index25_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_38);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA25_43 = input.LA(1);

                         
                        int index25_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_43);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA25_25 = input.LA(1);

                         
                        int index25_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA25_29 = input.LA(1);

                         
                        int index25_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_29);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA25_9 = input.LA(1);

                         
                        int index25_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_9);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA25_20 = input.LA(1);

                         
                        int index25_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_20);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA25_30 = input.LA(1);

                         
                        int index25_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_30);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA25_35 = input.LA(1);

                         
                        int index25_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_35);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA25_32 = input.LA(1);

                         
                        int index25_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_32);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA25_39 = input.LA(1);

                         
                        int index25_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_39);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA25_54 = input.LA(1);

                         
                        int index25_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_54);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA25_46 = input.LA(1);

                         
                        int index25_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_46);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA25_15 = input.LA(1);

                         
                        int index25_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_15);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA25_12 = input.LA(1);

                         
                        int index25_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_12);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA25_2 = input.LA(1);

                         
                        int index25_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_2);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA25_7 = input.LA(1);

                         
                        int index25_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_7);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA25_17 = input.LA(1);

                         
                        int index25_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_17);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA25_37 = input.LA(1);

                         
                        int index25_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_37);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA25_50 = input.LA(1);

                         
                        int index25_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_50);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA25_4 = input.LA(1);

                         
                        int index25_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_4);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA25_10 = input.LA(1);

                         
                        int index25_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_10);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA25_49 = input.LA(1);

                         
                        int index25_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_49);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA25_42 = input.LA(1);

                         
                        int index25_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_42);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA25_48 = input.LA(1);

                         
                        int index25_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_48);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA25_8 = input.LA(1);

                         
                        int index25_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_8);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA25_13 = input.LA(1);

                         
                        int index25_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_13);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA25_40 = input.LA(1);

                         
                        int index25_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_40);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA25_18 = input.LA(1);

                         
                        int index25_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_18);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA25_44 = input.LA(1);

                         
                        int index25_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_44);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA25_24 = input.LA(1);

                         
                        int index25_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_24);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA25_52 = input.LA(1);

                         
                        int index25_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_52);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA25_28 = input.LA(1);

                         
                        int index25_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_28);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA25_22 = input.LA(1);

                         
                        int index25_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalPreprocessParser()) ) {s = 57;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index25_22);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA48_eotS =
        "\50\uffff";
    static final String DFA48_eofS =
        "\50\uffff";
    static final String DFA48_minS =
        "\1\55\33\uffff\1\0\13\uffff";
    static final String DFA48_maxS =
        "\1\122\33\uffff\1\0\13\uffff";
    static final String DFA48_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\uffff\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\34\1\35";
    static final String DFA48_specialS =
        "\34\uffff\1\0\13\uffff}>";
    static final String[] DFA48_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "3174:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_PLUSPLUS_28= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_29= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_30= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_31= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_32= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_33= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_34= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_35= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_36= RULE_SKW_STAR | this_SKW_TILDE_37= RULE_SKW_TILDE )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA48_28 = input.LA(1);

                         
                        int index48_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalPreprocessParser()) ) {s = 38;}

                        else if ( (synpred107_InternalPreprocessParser()) ) {s = 39;}

                         
                        input.seek(index48_28);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 48, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xFFDFE04FCC4FBC02L,0x000000000017FFFFL});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000004000400L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000044BF800L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0xFFDFE04FCC0FB800L,0x000000000017FFFFL});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0xFFDFE04FCC0FBC00L,0x000000000017FFFFL});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000000C000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0xFFDFE04FCC0FBBF0L,0x000000000017FFFFL});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0xFFDFE04FCC4FBC00L,0x000000000017FFFFL});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xFFDFE04FCC0FBC02L,0x000000000017FFFFL});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xFFDFE04FCC0FB802L,0x000000000017FFFFL});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0xFFDFE04FC80FBBF0L,0x000000000017FFFFL});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0100000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x8600000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x4000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000102L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0010000000000002L,0x0000000000020008L});

}