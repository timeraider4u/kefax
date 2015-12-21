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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NEWLINE", "RULE_WHITESPACE", "RULE_HASH", "RULE_INCLUDE", "RULE_DEFINE", "RULE_ID", "RULE_SKW_LEFTPAREN", "RULE_SKW_RIGHTPAREN", "RULE_SKW_COMMA", "RULE_ERROR", "RULE_WARNING", "RULE_UNDEF", "RULE_ENDIF", "RULE_IF", "RULE_IFDEF", "RULE_IFNOTDEF", "RULE_ELIF", "RULE_ELSE", "RULE_PRAGMA", "RULE_SPECIAL", "RULE_DEFINED", "RULE_SKW_QUESTION", "RULE_SKW_COLON", "RULE_SKW_OROR", "RULE_SKW_ANDAND", "RULE_SKW_OR", "RULE_SKW_CARET", "RULE_SKW_AND", "RULE_SKW_EQUAL", "RULE_SKW_NOTEQUAL", "RULE_SKW_LESS", "RULE_SKW_GREATER", "RULE_SKW_LESSEQUAL", "RULE_SKW_GREATEREQUAL", "RULE_SKW_LEFTSHIFT", "RULE_SKW_RIGHTSHIFT", "RULE_SKW_PLUS", "RULE_SKW_MINUS", "RULE_SKW_STAR", "RULE_SKW_DIV", "RULE_SKW_MOD", "RULE_SKW_TILDE", "RULE_SKW_NOT", "RULE_HEX_LITERAL", "RULE_OCTAL_LITERAL", "RULE_DECIMAL_LITERAL", "RULE_CHAR_LITERAL", "RULE_STRING_LITERAL", "RULE_FLOAT_LITERAL", "RULE_BIN_LITERAL", "RULE_SKW_ASSIGN", "RULE_SKW_BACKSLASH", "RULE_SKW_DOT", "RULE_SKW_DOUBLEQUOTE", "RULE_SKW_LEFTBRACE", "RULE_SKW_LEFTBRACKET", "RULE_SKW_MINUSMINUS", "RULE_SKW_PLUSPLUS", "RULE_SKW_RIGHTBRACE", "RULE_SKW_RIGHTBRACKET", "RULE_SKW_SEMI", "RULE_SKW_SINGLEQUOTE", "RULE_END_OF_FILE", "SUPER_NEWLINE", "RULE_SKW_DOLLAR", "RULE_SKW_UNDERSCORE", "RULE_IDENTIFIER", "RULE_LETTER", "RULE_ESCAPE_SEQUENCE", "RULE_HEX_DIGIT", "RULE_INTEGER_TYPE_SUFFIX", "RULE_EXPONENT", "RULE_FLOAT_TYPE_SUFFIX", "RULE_OCTAL_ESCAPE", "RULE_LINEFEED", "RULE_CARRIAGERETURN", "RULE_LINE_END", "RULE_LINEBREAK", "RULE_SPACE", "RULE_TAB", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT"
    };
    public static final int RULE_PRAGMA=22;
    public static final int RULE_ID=9;
    public static final int RULE_OCTAL_ESCAPE=77;
    public static final int RULE_SKW_NOT=46;
    public static final int RULE_ESCAPE_SEQUENCE=72;
    public static final int RULE_SKW_RIGHTSHIFT=39;
    public static final int RULE_SKW_DOT=56;
    public static final int RULE_DEFINED=24;
    public static final int RULE_SKW_NOTEQUAL=33;
    public static final int RULE_SKW_GREATEREQUAL=37;
    public static final int RULE_SKW_PLUS=40;
    public static final int RULE_SKW_RIGHTBRACE=62;
    public static final int EOF=-1;
    public static final int RULE_SKW_LESS=34;
    public static final int RULE_SKW_RIGHTPAREN=11;
    public static final int RULE_SKW_STAR=42;
    public static final int RULE_ENDIF=16;
    public static final int RULE_LINEBREAK=81;
    public static final int RULE_STRING_LITERAL=51;
    public static final int RULE_SKW_PLUSPLUS=61;
    public static final int RULE_SKW_DOUBLEQUOTE=57;
    public static final int RULE_SKW_LESSEQUAL=36;
    public static final int RULE_DECIMAL_LITERAL=49;
    public static final int RULE_HEX_LITERAL=47;
    public static final int RULE_SKW_OROR=27;
    public static final int RULE_WARNING=14;
    public static final int RULE_SKW_AND=31;
    public static final int RULE_SKW_CARET=30;
    public static final int RULE_WHITESPACE=5;
    public static final int RULE_OCTAL_LITERAL=48;
    public static final int RULE_SKW_COMMA=12;
    public static final int RULE_SKW_RIGHTBRACKET=63;
    public static final int RULE_SPACE=82;
    public static final int SUPER_NEWLINE=67;
    public static final int RULE_BLOCK_COMMENT=84;
    public static final int RULE_LINEFEED=78;
    public static final int RULE_SKW_COLON=26;
    public static final int RULE_BIN_LITERAL=53;
    public static final int RULE_SKW_LEFTPAREN=10;
    public static final int RULE_SKW_MINUS=41;
    public static final int RULE_SKW_SEMI=64;
    public static final int RULE_IFDEF=18;
    public static final int RULE_NEWLINE=4;
    public static final int RULE_SKW_DOLLAR=68;
    public static final int RULE_SKW_EQUAL=32;
    public static final int RULE_SKW_LEFTSHIFT=38;
    public static final int RULE_SKW_DIV=43;
    public static final int RULE_SKW_QUESTION=25;
    public static final int RULE_SKW_ANDAND=28;
    public static final int RULE_ERROR=13;
    public static final int RULE_HEX_DIGIT=73;
    public static final int RULE_SKW_GREATER=35;
    public static final int RULE_IDENTIFIER=70;
    public static final int RULE_HASH=6;
    public static final int RULE_TAB=83;
    public static final int RULE_SKW_LEFTBRACKET=59;
    public static final int RULE_SKW_SINGLEQUOTE=65;
    public static final int RULE_SKW_MOD=44;
    public static final int RULE_UNDEF=15;
    public static final int RULE_LETTER=71;
    public static final int RULE_SKW_MINUSMINUS=60;
    public static final int RULE_FLOAT_TYPE_SUFFIX=76;
    public static final int RULE_IFNOTDEF=19;
    public static final int RULE_EXPONENT=75;
    public static final int RULE_INTEGER_TYPE_SUFFIX=74;
    public static final int RULE_DEFINE=8;
    public static final int RULE_SPECIAL=23;
    public static final int RULE_CARRIAGERETURN=79;
    public static final int RULE_SKW_TILDE=45;
    public static final int RULE_LINE_COMMENT=85;
    public static final int RULE_END_OF_FILE=66;
    public static final int RULE_INCLUDE=7;
    public static final int RULE_SKW_UNDERSCORE=69;
    public static final int RULE_SKW_BACKSLASH=55;
    public static final int RULE_SKW_OR=29;
    public static final int RULE_CHAR_LITERAL=50;
    public static final int RULE_ELIF=20;
    public static final int RULE_LINE_END=80;
    public static final int RULE_IF=17;
    public static final int RULE_SKW_LEFTBRACE=58;
    public static final int RULE_FLOAT_LITERAL=52;
    public static final int RULE_ELSE=21;
    public static final int RULE_SKW_ASSIGN=54;

    // delegates
    // delegators


        public InternalPreprocessParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPreprocessParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPreprocessParser.tokenNames; }
    public String getGrammarFileName() { return "InternalPreprocess.g"; }



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
    // InternalPreprocess.g:74:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalPreprocess.g:75:2: (iv_ruleModel= ruleModel EOF )
            // InternalPreprocess.g:76:2: iv_ruleModel= ruleModel EOF
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
    // InternalPreprocess.g:83:1: ruleModel returns [EObject current=null] : ( () ( (lv_units_1_0= ruleTranslationUnit ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_units_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:89:7: ( ( () ( (lv_units_1_0= ruleTranslationUnit ) ) ) )
            // InternalPreprocess.g:91:1: ( () ( (lv_units_1_0= ruleTranslationUnit ) ) )
            {
            // InternalPreprocess.g:91:1: ( () ( (lv_units_1_0= ruleTranslationUnit ) ) )
            // InternalPreprocess.g:92:1: () ( (lv_units_1_0= ruleTranslationUnit ) )
            {
            // InternalPreprocess.g:92:1: ()
            // InternalPreprocess.g:93:2: 
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

            // InternalPreprocess.g:104:1: ( (lv_units_1_0= ruleTranslationUnit ) )
            // InternalPreprocess.g:105:1: (lv_units_1_0= ruleTranslationUnit )
            {
            // InternalPreprocess.g:105:1: (lv_units_1_0= ruleTranslationUnit )
            // InternalPreprocess.g:106:3: lv_units_1_0= ruleTranslationUnit
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
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:134:1: entryRuleTranslationUnit returns [EObject current=null] : iv_ruleTranslationUnit= ruleTranslationUnit EOF ;
    public final EObject entryRuleTranslationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTranslationUnit = null;


        try {
            // InternalPreprocess.g:135:2: (iv_ruleTranslationUnit= ruleTranslationUnit EOF )
            // InternalPreprocess.g:136:2: iv_ruleTranslationUnit= ruleTranslationUnit EOF
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
    // InternalPreprocess.g:143:1: ruleTranslationUnit returns [EObject current=null] : ( () ( (lv_group_1_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleTranslationUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_group_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:149:7: ( ( () ( (lv_group_1_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:151:1: ( () ( (lv_group_1_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:151:1: ( () ( (lv_group_1_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:152:1: () ( (lv_group_1_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:152:1: ()
            // InternalPreprocess.g:153:2: 
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

            // InternalPreprocess.g:164:1: ( (lv_group_1_0= ruleGroupOpt ) )
            // InternalPreprocess.g:165:1: (lv_group_1_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:165:1: (lv_group_1_0= ruleGroupOpt )
            // InternalPreprocess.g:166:3: lv_group_1_0= ruleGroupOpt
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
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:194:1: entryRuleGroupOpt returns [EObject current=null] : iv_ruleGroupOpt= ruleGroupOpt EOF ;
    public final EObject entryRuleGroupOpt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOpt = null;


        try {
            // InternalPreprocess.g:195:2: (iv_ruleGroupOpt= ruleGroupOpt EOF )
            // InternalPreprocess.g:196:2: iv_ruleGroupOpt= ruleGroupOpt EOF
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
    // InternalPreprocess.g:203:1: ruleGroupOpt returns [EObject current=null] : ( () ( ( (lv_lines_1_0= ruleGroupOptTemp ) ) this_NEWLINE_2= RULE_NEWLINE )* ) ;
    public final EObject ruleGroupOpt() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_2=null;
        EObject lv_lines_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:209:7: ( ( () ( ( (lv_lines_1_0= ruleGroupOptTemp ) ) this_NEWLINE_2= RULE_NEWLINE )* ) )
            // InternalPreprocess.g:211:1: ( () ( ( (lv_lines_1_0= ruleGroupOptTemp ) ) this_NEWLINE_2= RULE_NEWLINE )* )
            {
            // InternalPreprocess.g:211:1: ( () ( ( (lv_lines_1_0= ruleGroupOptTemp ) ) this_NEWLINE_2= RULE_NEWLINE )* )
            // InternalPreprocess.g:212:1: () ( ( (lv_lines_1_0= ruleGroupOptTemp ) ) this_NEWLINE_2= RULE_NEWLINE )*
            {
            // InternalPreprocess.g:212:1: ()
            // InternalPreprocess.g:213:2: 
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

            // InternalPreprocess.g:224:1: ( ( (lv_lines_1_0= ruleGroupOptTemp ) ) this_NEWLINE_2= RULE_NEWLINE )*
            loop1:
            do {
                int alt1=2;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // InternalPreprocess.g:225:1: ( (lv_lines_1_0= ruleGroupOptTemp ) ) this_NEWLINE_2= RULE_NEWLINE
            	    {
            	    // InternalPreprocess.g:225:1: ( (lv_lines_1_0= ruleGroupOptTemp ) )
            	    // InternalPreprocess.g:226:1: (lv_lines_1_0= ruleGroupOptTemp )
            	    {
            	    // InternalPreprocess.g:226:1: (lv_lines_1_0= ruleGroupOptTemp )
            	    // InternalPreprocess.g:227:3: lv_lines_1_0= ruleGroupOptTemp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGroupOptAccess().getLinesGroupOptTempParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_lines_1_0=ruleGroupOptTemp();

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
            	              		"at.jku.weiner.c.preprocess.Preprocess.GroupOptTemp");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_2, grammarAccess.getGroupOptAccess().getNEWLINETerminalRuleCall_1_1()); 
            	          
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
                  		/*no after found*/
                   
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


    // $ANTLR start "entryRuleGroupOptTemp"
    // InternalPreprocess.g:264:1: entryRuleGroupOptTemp returns [EObject current=null] : iv_ruleGroupOptTemp= ruleGroupOptTemp EOF ;
    public final EObject entryRuleGroupOptTemp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOptTemp = null;


        try {
            // InternalPreprocess.g:265:2: (iv_ruleGroupOptTemp= ruleGroupOptTemp EOF )
            // InternalPreprocess.g:266:2: iv_ruleGroupOptTemp= ruleGroupOptTemp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGroupOptTempRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGroupOptTemp=ruleGroupOptTemp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGroupOptTemp; 
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
    // $ANTLR end "entryRuleGroupOptTemp"


    // $ANTLR start "ruleGroupOptTemp"
    // InternalPreprocess.g:273:1: ruleGroupOptTemp returns [EObject current=null] : (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode ) ;
    public final EObject ruleGroupOptTemp() throws RecognitionException {
        EObject current = null;

        EObject this_PreprocessorDirectives_0 = null;

        EObject this_NewLineLine_1 = null;

        EObject this_Code_2 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:279:7: ( (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode ) )
            // InternalPreprocess.g:281:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode )
            {
            // InternalPreprocess.g:281:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode )
            int alt2=3;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalPreprocess.g:283:2: this_PreprocessorDirectives_0= rulePreprocessorDirectives
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGroupOptTempAccess().getPreprocessorDirectivesParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_PreprocessorDirectives_0=rulePreprocessorDirectives();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PreprocessorDirectives_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:299:2: this_NewLineLine_1= ruleNewLineLine
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGroupOptTempAccess().getNewLineLineParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_NewLineLine_1=ruleNewLineLine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NewLineLine_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalPreprocess.g:315:2: this_Code_2= ruleCode
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGroupOptTempAccess().getCodeParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Code_2=ruleCode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Code_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // $ANTLR end "ruleGroupOptTemp"


    // $ANTLR start "entryRulePreprocessorDirectives"
    // InternalPreprocess.g:338:1: entryRulePreprocessorDirectives returns [EObject current=null] : iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF ;
    public final EObject entryRulePreprocessorDirectives() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreprocessorDirectives = null;


        try {
            // InternalPreprocess.g:339:2: (iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF )
            // InternalPreprocess.g:340:2: iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF
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
    // InternalPreprocess.g:347:1: rulePreprocessorDirectives returns [EObject current=null] : ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) ) ) ;
    public final EObject rulePreprocessorDirectives() throws RecognitionException {
        EObject current = null;

        Token this_WHITESPACE_1=null;
        Token this_HASH_2=null;
        Token this_WHITESPACE_3=null;
        EObject lv_directive_4_0 = null;

        EObject lv_directive_5_0 = null;

        EObject lv_directive_6_0 = null;

        EObject lv_directive_7_0 = null;

        EObject lv_directive_8_0 = null;

        EObject lv_directive_9_0 = null;

        EObject lv_directive_10_0 = null;

        EObject lv_directive_11_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:353:7: ( ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) ) ) )
            // InternalPreprocess.g:355:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) ) )
            {
            // InternalPreprocess.g:355:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) ) )
            // InternalPreprocess.g:356:1: () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) )
            {
            // InternalPreprocess.g:356:1: ()
            // InternalPreprocess.g:357:2: 
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

            // InternalPreprocess.g:368:1: (this_WHITESPACE_1= RULE_WHITESPACE )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_WHITESPACE) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalPreprocess.g:368:2: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getPreprocessorDirectivesAccess().getWHITESPACETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_2, grammarAccess.getPreprocessorDirectivesAccess().getHASHTerminalRuleCall_2()); 
                  
            }
            // InternalPreprocess.g:382:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_WHITESPACE) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalPreprocess.g:382:2: this_WHITESPACE_3= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_3, grammarAccess.getPreprocessorDirectivesAccess().getWHITESPACETerminalRuleCall_3()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalPreprocess.g:389:1: ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) )
            int alt5=8;
            switch ( input.LA(1) ) {
            case RULE_INCLUDE:
                {
                alt5=1;
                }
                break;
            case RULE_DEFINE:
                {
                alt5=2;
                }
                break;
            case RULE_ERROR:
                {
                alt5=3;
                }
                break;
            case RULE_WARNING:
                {
                alt5=4;
                }
                break;
            case RULE_UNDEF:
                {
                alt5=5;
                }
                break;
            case RULE_IF:
            case RULE_IFDEF:
            case RULE_IFNOTDEF:
                {
                alt5=6;
                }
                break;
            case RULE_PRAGMA:
                {
                alt5=7;
                }
                break;
            case EOF:
            case RULE_NEWLINE:
                {
                alt5=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalPreprocess.g:390:1: ( (lv_directive_4_0= ruleIncludeDirective ) )
                    {
                    // InternalPreprocess.g:390:1: ( (lv_directive_4_0= ruleIncludeDirective ) )
                    // InternalPreprocess.g:391:1: (lv_directive_4_0= ruleIncludeDirective )
                    {
                    // InternalPreprocess.g:391:1: (lv_directive_4_0= ruleIncludeDirective )
                    // InternalPreprocess.g:392:3: lv_directive_4_0= ruleIncludeDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveIncludeDirectiveParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalPreprocess.g:412:1: ( (lv_directive_5_0= ruleDefineDirective ) )
                    {
                    // InternalPreprocess.g:412:1: ( (lv_directive_5_0= ruleDefineDirective ) )
                    // InternalPreprocess.g:413:1: (lv_directive_5_0= ruleDefineDirective )
                    {
                    // InternalPreprocess.g:413:1: (lv_directive_5_0= ruleDefineDirective )
                    // InternalPreprocess.g:414:3: lv_directive_5_0= ruleDefineDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveDefineDirectiveParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalPreprocess.g:434:1: ( (lv_directive_6_0= ruleErrorDirective ) )
                    {
                    // InternalPreprocess.g:434:1: ( (lv_directive_6_0= ruleErrorDirective ) )
                    // InternalPreprocess.g:435:1: (lv_directive_6_0= ruleErrorDirective )
                    {
                    // InternalPreprocess.g:435:1: (lv_directive_6_0= ruleErrorDirective )
                    // InternalPreprocess.g:436:3: lv_directive_6_0= ruleErrorDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveErrorDirectiveParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                    // InternalPreprocess.g:456:1: ( (lv_directive_7_0= ruleWarningDirective ) )
                    {
                    // InternalPreprocess.g:456:1: ( (lv_directive_7_0= ruleWarningDirective ) )
                    // InternalPreprocess.g:457:1: (lv_directive_7_0= ruleWarningDirective )
                    {
                    // InternalPreprocess.g:457:1: (lv_directive_7_0= ruleWarningDirective )
                    // InternalPreprocess.g:458:3: lv_directive_7_0= ruleWarningDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveWarningDirectiveParserRuleCall_4_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_7_0=ruleWarningDirective();

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
                              		"at.jku.weiner.c.preprocess.Preprocess.WarningDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalPreprocess.g:478:1: ( (lv_directive_8_0= ruleUnDefineDirective ) )
                    {
                    // InternalPreprocess.g:478:1: ( (lv_directive_8_0= ruleUnDefineDirective ) )
                    // InternalPreprocess.g:479:1: (lv_directive_8_0= ruleUnDefineDirective )
                    {
                    // InternalPreprocess.g:479:1: (lv_directive_8_0= ruleUnDefineDirective )
                    // InternalPreprocess.g:480:3: lv_directive_8_0= ruleUnDefineDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveUnDefineDirectiveParserRuleCall_4_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_8_0=ruleUnDefineDirective();

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
                              		"at.jku.weiner.c.preprocess.Preprocess.UnDefineDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalPreprocess.g:500:1: ( (lv_directive_9_0= ruleConditionalDirective ) )
                    {
                    // InternalPreprocess.g:500:1: ( (lv_directive_9_0= ruleConditionalDirective ) )
                    // InternalPreprocess.g:501:1: (lv_directive_9_0= ruleConditionalDirective )
                    {
                    // InternalPreprocess.g:501:1: (lv_directive_9_0= ruleConditionalDirective )
                    // InternalPreprocess.g:502:3: lv_directive_9_0= ruleConditionalDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveConditionalDirectiveParserRuleCall_4_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_9_0=ruleConditionalDirective();

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
                              		"at.jku.weiner.c.preprocess.Preprocess.ConditionalDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalPreprocess.g:522:1: ( (lv_directive_10_0= rulePragmaDirective ) )
                    {
                    // InternalPreprocess.g:522:1: ( (lv_directive_10_0= rulePragmaDirective ) )
                    // InternalPreprocess.g:523:1: (lv_directive_10_0= rulePragmaDirective )
                    {
                    // InternalPreprocess.g:523:1: (lv_directive_10_0= rulePragmaDirective )
                    // InternalPreprocess.g:524:3: lv_directive_10_0= rulePragmaDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectivePragmaDirectiveParserRuleCall_4_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_10_0=rulePragmaDirective();

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
                              		"at.jku.weiner.c.preprocess.Preprocess.PragmaDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalPreprocess.g:544:1: ( (lv_directive_11_0= ruleNullDirective ) )
                    {
                    // InternalPreprocess.g:544:1: ( (lv_directive_11_0= ruleNullDirective ) )
                    // InternalPreprocess.g:545:1: (lv_directive_11_0= ruleNullDirective )
                    {
                    // InternalPreprocess.g:545:1: (lv_directive_11_0= ruleNullDirective )
                    // InternalPreprocess.g:546:3: lv_directive_11_0= ruleNullDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveNullDirectiveParserRuleCall_4_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_11_0=ruleNullDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
                      	        }
                             		set(
                             			current, 
                             			"directive",
                              		lv_directive_11_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.NullDirective");
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
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:576:1: entryRuleIncludeDirective returns [EObject current=null] : iv_ruleIncludeDirective= ruleIncludeDirective EOF ;
    public final EObject entryRuleIncludeDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDirective = null;


        try {
            // InternalPreprocess.g:577:2: (iv_ruleIncludeDirective= ruleIncludeDirective EOF )
            // InternalPreprocess.g:578:2: iv_ruleIncludeDirective= ruleIncludeDirective EOF
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
    // InternalPreprocess.g:585:1: ruleIncludeDirective returns [EObject current=null] : ( () this_INCLUDE_1= RULE_INCLUDE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_string_3_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleIncludeDirective() throws RecognitionException {
        EObject current = null;

        Token this_INCLUDE_1=null;
        Token this_WHITESPACE_2=null;
        AntlrDatatypeRuleToken lv_string_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:591:7: ( ( () this_INCLUDE_1= RULE_INCLUDE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_string_3_0= ruleMyCodeLine ) ) ) )
            // InternalPreprocess.g:593:1: ( () this_INCLUDE_1= RULE_INCLUDE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_string_3_0= ruleMyCodeLine ) ) )
            {
            // InternalPreprocess.g:593:1: ( () this_INCLUDE_1= RULE_INCLUDE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_string_3_0= ruleMyCodeLine ) ) )
            // InternalPreprocess.g:594:1: () this_INCLUDE_1= RULE_INCLUDE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_string_3_0= ruleMyCodeLine ) )
            {
            // InternalPreprocess.g:594:1: ()
            // InternalPreprocess.g:595:2: 
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
            // InternalPreprocess.g:613:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_WHITESPACE) ) {
                    int LA6_2 = input.LA(2);

                    if ( (synpred13_InternalPreprocess()) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // InternalPreprocess.g:613:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIncludeDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // InternalPreprocess.g:620:1: ( (lv_string_3_0= ruleMyCodeLine ) )
            // InternalPreprocess.g:621:1: (lv_string_3_0= ruleMyCodeLine )
            {
            // InternalPreprocess.g:621:1: (lv_string_3_0= ruleMyCodeLine )
            // InternalPreprocess.g:622:3: lv_string_3_0= ruleMyCodeLine
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
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:650:1: entryRuleDefineDirective returns [EObject current=null] : iv_ruleDefineDirective= ruleDefineDirective EOF ;
    public final EObject entryRuleDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineDirective = null;


        try {
            // InternalPreprocess.g:651:2: (iv_ruleDefineDirective= ruleDefineDirective EOF )
            // InternalPreprocess.g:652:2: iv_ruleDefineDirective= ruleDefineDirective EOF
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
    // InternalPreprocess.g:659:1: ruleDefineDirective returns [EObject current=null] : (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro ) ;
    public final EObject ruleDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject this_DefineObjectMacro_0 = null;

        EObject this_DefineFunctionLikeMacro_1 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:665:7: ( (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro ) )
            // InternalPreprocess.g:667:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )
            {
            // InternalPreprocess.g:667:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // InternalPreprocess.g:669:2: this_DefineObjectMacro_0= ruleDefineObjectMacro
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
                    // InternalPreprocess.g:685:2: this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro
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
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:708:1: entryRuleDefineObjectMacro returns [EObject current=null] : iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF ;
    public final EObject entryRuleDefineObjectMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineObjectMacro = null;


        try {
            // InternalPreprocess.g:709:2: (iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF )
            // InternalPreprocess.g:710:2: iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF
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
    // InternalPreprocess.g:717:1: ruleDefineObjectMacro returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? ) ;
    public final EObject ruleDefineObjectMacro() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_1=null;
        Token this_WHITESPACE_2=null;
        Token lv_id_3_0=null;
        Token this_WHITESPACE_4=null;
        AntlrDatatypeRuleToken lv_string_5_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:723:7: ( ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? ) )
            // InternalPreprocess.g:725:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? )
            {
            // InternalPreprocess.g:725:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? )
            // InternalPreprocess.g:726:1: () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )?
            {
            // InternalPreprocess.g:726:1: ()
            // InternalPreprocess.g:727:2: 
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
            // InternalPreprocess.g:745:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_WHITESPACE) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalPreprocess.g:745:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getDefineObjectMacroAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:752:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:753:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:753:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:754:3: lv_id_3_0= RULE_ID
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
                      		"at.jku.weiner.c.common.Common.ID");
              	    
            }

            }


            }

            // InternalPreprocess.g:773:1: ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_WHITESPACE) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalPreprocess.g:774:1: (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) )
                    {
                    // InternalPreprocess.g:774:1: (this_WHITESPACE_4= RULE_WHITESPACE )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_WHITESPACE) ) {
                            int LA9_2 = input.LA(2);

                            if ( (synpred16_InternalPreprocess()) ) {
                                alt9=1;
                            }


                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalPreprocess.g:774:2: this_WHITESPACE_4= RULE_WHITESPACE
                    	    {
                    	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_11); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_WHITESPACE_4, grammarAccess.getDefineObjectMacroAccess().getWHITESPACETerminalRuleCall_4_0()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    // InternalPreprocess.g:781:1: ( (lv_string_5_0= ruleMyDefineLine ) )
                    // InternalPreprocess.g:782:1: (lv_string_5_0= ruleMyDefineLine )
                    {
                    // InternalPreprocess.g:782:1: (lv_string_5_0= ruleMyDefineLine )
                    // InternalPreprocess.g:783:3: lv_string_5_0= ruleMyDefineLine
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
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:813:1: entryRuleDefineFunctionLikeMacro returns [EObject current=null] : iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF ;
    public final EObject entryRuleDefineFunctionLikeMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineFunctionLikeMacro = null;


        try {
            // InternalPreprocess.g:814:2: (iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF )
            // InternalPreprocess.g:815:2: iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF
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
    // InternalPreprocess.g:822:1: ruleDefineFunctionLikeMacro returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WHITESPACE_8= RULE_WHITESPACE )+ ( (lv_string_9_0= ruleMyDefineLine ) ) ) ;
    public final EObject ruleDefineFunctionLikeMacro() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_1=null;
        Token this_WHITESPACE_2=null;
        Token lv_id_3_0=null;
        Token this_SKW_LEFTPAREN_4=null;
        Token this_WHITESPACE_5=null;
        Token this_SKW_RIGHTPAREN_7=null;
        Token this_WHITESPACE_8=null;
        EObject lv_list_6_0 = null;

        AntlrDatatypeRuleToken lv_string_9_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:828:7: ( ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WHITESPACE_8= RULE_WHITESPACE )+ ( (lv_string_9_0= ruleMyDefineLine ) ) ) )
            // InternalPreprocess.g:830:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WHITESPACE_8= RULE_WHITESPACE )+ ( (lv_string_9_0= ruleMyDefineLine ) ) )
            {
            // InternalPreprocess.g:830:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WHITESPACE_8= RULE_WHITESPACE )+ ( (lv_string_9_0= ruleMyDefineLine ) ) )
            // InternalPreprocess.g:831:1: () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WHITESPACE_8= RULE_WHITESPACE )+ ( (lv_string_9_0= ruleMyDefineLine ) )
            {
            // InternalPreprocess.g:831:1: ()
            // InternalPreprocess.g:832:2: 
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
            // InternalPreprocess.g:850:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_WHITESPACE) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalPreprocess.g:850:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getDefineFunctionLikeMacroAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            // InternalPreprocess.g:857:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:858:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:858:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:859:3: lv_id_3_0= RULE_ID
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
                      		"at.jku.weiner.c.common.Common.ID");
              	    
            }

            }


            }

            this_SKW_LEFTPAREN_4=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SKW_LEFTPAREN_4, grammarAccess.getDefineFunctionLikeMacroAccess().getSKW_LEFTPARENTerminalRuleCall_4()); 
                  
            }
            // InternalPreprocess.g:885:1: (this_WHITESPACE_5= RULE_WHITESPACE )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_WHITESPACE) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalPreprocess.g:885:2: this_WHITESPACE_5= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_5=(Token)match(input,RULE_WHITESPACE,FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_5, grammarAccess.getDefineFunctionLikeMacroAccess().getWHITESPACETerminalRuleCall_5()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // InternalPreprocess.g:892:1: ( (lv_list_6_0= ruleIdentifierList ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalPreprocess.g:893:1: (lv_list_6_0= ruleIdentifierList )
                    {
                    // InternalPreprocess.g:893:1: (lv_list_6_0= ruleIdentifierList )
                    // InternalPreprocess.g:894:3: lv_list_6_0= ruleIdentifierList
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
            // InternalPreprocess.g:920:1: (this_WHITESPACE_8= RULE_WHITESPACE )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_WHITESPACE) ) {
                    int LA14_2 = input.LA(2);

                    if ( (synpred21_InternalPreprocess()) ) {
                        alt14=1;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // InternalPreprocess.g:920:2: this_WHITESPACE_8= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_8=(Token)match(input,RULE_WHITESPACE,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_8, grammarAccess.getDefineFunctionLikeMacroAccess().getWHITESPACETerminalRuleCall_8()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);

            // InternalPreprocess.g:927:1: ( (lv_string_9_0= ruleMyDefineLine ) )
            // InternalPreprocess.g:928:1: (lv_string_9_0= ruleMyDefineLine )
            {
            // InternalPreprocess.g:928:1: (lv_string_9_0= ruleMyDefineLine )
            // InternalPreprocess.g:929:3: lv_string_9_0= ruleMyDefineLine
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
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:957:1: entryRuleIdentifierList returns [EObject current=null] : iv_ruleIdentifierList= ruleIdentifierList EOF ;
    public final EObject entryRuleIdentifierList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierList = null;


        try {
            // InternalPreprocess.g:958:2: (iv_ruleIdentifierList= ruleIdentifierList EOF )
            // InternalPreprocess.g:959:2: iv_ruleIdentifierList= ruleIdentifierList EOF
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
    // InternalPreprocess.g:966:1: ruleIdentifierList returns [EObject current=null] : ( () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) )* ) ;
    public final EObject ruleIdentifierList() throws RecognitionException {
        EObject current = null;

        Token lv_id_1_0=null;
        Token this_SKW_COMMA_2=null;
        Token this_WHITESPACE_3=null;
        Token lv_id_4_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:972:7: ( ( () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) )* ) )
            // InternalPreprocess.g:974:1: ( () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) )* )
            {
            // InternalPreprocess.g:974:1: ( () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) )* )
            // InternalPreprocess.g:975:1: () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) )*
            {
            // InternalPreprocess.g:975:1: ()
            // InternalPreprocess.g:976:2: 
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

            // InternalPreprocess.g:987:1: ( (lv_id_1_0= RULE_ID ) )
            // InternalPreprocess.g:988:1: (lv_id_1_0= RULE_ID )
            {
            // InternalPreprocess.g:988:1: (lv_id_1_0= RULE_ID )
            // InternalPreprocess.g:989:3: lv_id_1_0= RULE_ID
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
                      		"at.jku.weiner.c.common.Common.ID");
              	    
            }

            }


            }

            // InternalPreprocess.g:1008:1: (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_SKW_COMMA) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalPreprocess.g:1009:1: this_SKW_COMMA_2= RULE_SKW_COMMA (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) )
            	    {
            	    this_SKW_COMMA_2=(Token)match(input,RULE_SKW_COMMA,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_COMMA_2, grammarAccess.getIdentifierListAccess().getSKW_COMMATerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:1016:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
            	    loop15:
            	    do {
            	        int alt15=2;
            	        int LA15_0 = input.LA(1);

            	        if ( (LA15_0==RULE_WHITESPACE) ) {
            	            alt15=1;
            	        }


            	        switch (alt15) {
            	    	case 1 :
            	    	    // InternalPreprocess.g:1016:2: this_WHITESPACE_3= RULE_WHITESPACE
            	    	    {
            	    	    this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_WHITESPACE_3, grammarAccess.getIdentifierListAccess().getWHITESPACETerminalRuleCall_2_1()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop15;
            	        }
            	    } while (true);

            	    // InternalPreprocess.g:1023:1: ( (lv_id_4_0= RULE_ID ) )
            	    // InternalPreprocess.g:1024:1: (lv_id_4_0= RULE_ID )
            	    {
            	    // InternalPreprocess.g:1024:1: (lv_id_4_0= RULE_ID )
            	    // InternalPreprocess.g:1025:3: lv_id_4_0= RULE_ID
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
            	              		"at.jku.weiner.c.common.Common.ID");
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:1055:1: entryRuleErrorDirective returns [EObject current=null] : iv_ruleErrorDirective= ruleErrorDirective EOF ;
    public final EObject entryRuleErrorDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorDirective = null;


        try {
            // InternalPreprocess.g:1056:2: (iv_ruleErrorDirective= ruleErrorDirective EOF )
            // InternalPreprocess.g:1057:2: iv_ruleErrorDirective= ruleErrorDirective EOF
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
    // InternalPreprocess.g:1064:1: ruleErrorDirective returns [EObject current=null] : ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleErrorDirective() throws RecognitionException {
        EObject current = null;

        Token this_ERROR_1=null;
        Token this_WHITESPACE_2=null;
        AntlrDatatypeRuleToken lv_msg_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1070:7: ( ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) ) )
            // InternalPreprocess.g:1072:1: ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) )
            {
            // InternalPreprocess.g:1072:1: ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) )
            // InternalPreprocess.g:1073:1: () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) )
            {
            // InternalPreprocess.g:1073:1: ()
            // InternalPreprocess.g:1074:2: 
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
            // InternalPreprocess.g:1092:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_WHITESPACE) ) {
                    int LA17_2 = input.LA(2);

                    if ( (synpred24_InternalPreprocess()) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // InternalPreprocess.g:1092:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getErrorDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:1099:1: ( (lv_msg_3_0= ruleMyCodeLine ) )
            // InternalPreprocess.g:1100:1: (lv_msg_3_0= ruleMyCodeLine )
            {
            // InternalPreprocess.g:1100:1: (lv_msg_3_0= ruleMyCodeLine )
            // InternalPreprocess.g:1101:3: lv_msg_3_0= ruleMyCodeLine
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
                  		/*no after found*/
                   
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


    // $ANTLR start "entryRuleWarningDirective"
    // InternalPreprocess.g:1129:1: entryRuleWarningDirective returns [EObject current=null] : iv_ruleWarningDirective= ruleWarningDirective EOF ;
    public final EObject entryRuleWarningDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWarningDirective = null;


        try {
            // InternalPreprocess.g:1130:2: (iv_ruleWarningDirective= ruleWarningDirective EOF )
            // InternalPreprocess.g:1131:2: iv_ruleWarningDirective= ruleWarningDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWarningDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWarningDirective=ruleWarningDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWarningDirective; 
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
    // $ANTLR end "entryRuleWarningDirective"


    // $ANTLR start "ruleWarningDirective"
    // InternalPreprocess.g:1138:1: ruleWarningDirective returns [EObject current=null] : ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleWarningDirective() throws RecognitionException {
        EObject current = null;

        Token this_WARNING_1=null;
        Token this_WHITESPACE_2=null;
        AntlrDatatypeRuleToken lv_msg_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1144:7: ( ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) ) )
            // InternalPreprocess.g:1146:1: ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) )
            {
            // InternalPreprocess.g:1146:1: ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) )
            // InternalPreprocess.g:1147:1: () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) )
            {
            // InternalPreprocess.g:1147:1: ()
            // InternalPreprocess.g:1148:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getWarningDirectiveAccess().getWarningDirectiveAction_0(),
                          current);
                  
            }

            }

            this_WARNING_1=(Token)match(input,RULE_WARNING,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_WARNING_1, grammarAccess.getWarningDirectiveAccess().getWARNINGTerminalRuleCall_1()); 
                  
            }
            // InternalPreprocess.g:1166:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_WHITESPACE) ) {
                    int LA18_2 = input.LA(2);

                    if ( (synpred25_InternalPreprocess()) ) {
                        alt18=1;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // InternalPreprocess.g:1166:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getWarningDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            // InternalPreprocess.g:1173:1: ( (lv_msg_3_0= ruleMyCodeLine ) )
            // InternalPreprocess.g:1174:1: (lv_msg_3_0= ruleMyCodeLine )
            {
            // InternalPreprocess.g:1174:1: (lv_msg_3_0= ruleMyCodeLine )
            // InternalPreprocess.g:1175:3: lv_msg_3_0= ruleMyCodeLine
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getWarningDirectiveAccess().getMsgMyCodeLineParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_msg_3_0=ruleMyCodeLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getWarningDirectiveRule());
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
                  		/*no after found*/
                   
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
    // $ANTLR end "ruleWarningDirective"


    // $ANTLR start "entryRuleUnDefineDirective"
    // InternalPreprocess.g:1203:1: entryRuleUnDefineDirective returns [EObject current=null] : iv_ruleUnDefineDirective= ruleUnDefineDirective EOF ;
    public final EObject entryRuleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnDefineDirective = null;


        try {
            // InternalPreprocess.g:1204:2: (iv_ruleUnDefineDirective= ruleUnDefineDirective EOF )
            // InternalPreprocess.g:1205:2: iv_ruleUnDefineDirective= ruleUnDefineDirective EOF
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
    // InternalPreprocess.g:1212:1: ruleUnDefineDirective returns [EObject current=null] : ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) ) ;
    public final EObject ruleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        Token this_UNDEF_1=null;
        Token this_WHITESPACE_2=null;
        Token lv_id_3_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1218:7: ( ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) ) )
            // InternalPreprocess.g:1220:1: ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) )
            {
            // InternalPreprocess.g:1220:1: ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) )
            // InternalPreprocess.g:1221:1: () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) )
            {
            // InternalPreprocess.g:1221:1: ()
            // InternalPreprocess.g:1222:2: 
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
            // InternalPreprocess.g:1240:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_WHITESPACE) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalPreprocess.g:1240:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getUnDefineDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);

            // InternalPreprocess.g:1247:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:1248:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:1248:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:1249:3: lv_id_3_0= RULE_ID
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
                      		"at.jku.weiner.c.common.Common.ID");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:1277:1: entryRuleConditionalDirective returns [EObject current=null] : iv_ruleConditionalDirective= ruleConditionalDirective EOF ;
    public final EObject entryRuleConditionalDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalDirective = null;


        try {
            // InternalPreprocess.g:1278:2: (iv_ruleConditionalDirective= ruleConditionalDirective EOF )
            // InternalPreprocess.g:1279:2: iv_ruleConditionalDirective= ruleConditionalDirective EOF
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
    // InternalPreprocess.g:1286:1: ruleConditionalDirective returns [EObject current=null] : ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* ) ;
    public final EObject ruleConditionalDirective() throws RecognitionException {
        EObject current = null;

        Token this_WHITESPACE_4=null;
        Token this_HASH_5=null;
        Token this_WHITESPACE_6=null;
        Token this_ENDIF_7=null;
        Token this_WHITESPACE_8=null;
        EObject lv_conditional_1_1 = null;

        EObject lv_conditional_1_2 = null;

        EObject lv_conditional_1_3 = null;

        EObject lv_elifs_2_0 = null;

        EObject lv_else_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1292:7: ( ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* ) )
            // InternalPreprocess.g:1294:1: ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* )
            {
            // InternalPreprocess.g:1294:1: ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* )
            // InternalPreprocess.g:1295:1: () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )*
            {
            // InternalPreprocess.g:1295:1: ()
            // InternalPreprocess.g:1296:2: 
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

            // InternalPreprocess.g:1307:1: ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) )
            // InternalPreprocess.g:1308:1: ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) )
            {
            // InternalPreprocess.g:1308:1: ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) )
            // InternalPreprocess.g:1309:1: (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional )
            {
            // InternalPreprocess.g:1309:1: (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional )
            int alt20=3;
            switch ( input.LA(1) ) {
            case RULE_IF:
                {
                alt20=1;
                }
                break;
            case RULE_IFDEF:
                {
                alt20=2;
                }
                break;
            case RULE_IFNOTDEF:
                {
                alt20=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalPreprocess.g:1310:3: lv_conditional_1_1= ruleIfConditional
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalDirectiveAccess().getConditionalIfConditionalParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_5);
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
                    // InternalPreprocess.g:1325:8: lv_conditional_1_2= ruleIfDefConditional
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalDirectiveAccess().getConditionalIfDefConditionalParserRuleCall_1_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_5);
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
                    // InternalPreprocess.g:1340:8: lv_conditional_1_3= ruleIfNotDefConditional
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalDirectiveAccess().getConditionalIfNotDefConditionalParserRuleCall_1_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_5);
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

            // InternalPreprocess.g:1361:1: ( (lv_elifs_2_0= ruleElIfConditional ) )*
            loop21:
            do {
                int alt21=2;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // InternalPreprocess.g:1362:1: (lv_elifs_2_0= ruleElIfConditional )
            	    {
            	    // InternalPreprocess.g:1362:1: (lv_elifs_2_0= ruleElIfConditional )
            	    // InternalPreprocess.g:1363:3: lv_elifs_2_0= ruleElIfConditional
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConditionalDirectiveAccess().getElifsElIfConditionalParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_5);
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
            	    break loop21;
                }
            } while (true);

            // InternalPreprocess.g:1382:1: ( (lv_else_3_0= ruleElseConditional ) )?
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalPreprocess.g:1383:1: (lv_else_3_0= ruleElseConditional )
                    {
                    // InternalPreprocess.g:1383:1: (lv_else_3_0= ruleElseConditional )
                    // InternalPreprocess.g:1384:3: lv_else_3_0= ruleElseConditional
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalDirectiveAccess().getElseElseConditionalParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_5);
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

            // InternalPreprocess.g:1403:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_WHITESPACE) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalPreprocess.g:1403:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getConditionalDirectiveAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            this_HASH_5=(Token)match(input,RULE_HASH,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_5, grammarAccess.getConditionalDirectiveAccess().getHASHTerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:1417:1: (this_WHITESPACE_6= RULE_WHITESPACE )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_WHITESPACE) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalPreprocess.g:1417:2: this_WHITESPACE_6= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_6=(Token)match(input,RULE_WHITESPACE,FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_6, grammarAccess.getConditionalDirectiveAccess().getWHITESPACETerminalRuleCall_6()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            this_ENDIF_7=(Token)match(input,RULE_ENDIF,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ENDIF_7, grammarAccess.getConditionalDirectiveAccess().getENDIFTerminalRuleCall_7()); 
                  
            }
            // InternalPreprocess.g:1431:1: (this_WHITESPACE_8= RULE_WHITESPACE )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_WHITESPACE) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalPreprocess.g:1431:2: this_WHITESPACE_8= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_8=(Token)match(input,RULE_WHITESPACE,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_8, grammarAccess.getConditionalDirectiveAccess().getWHITESPACETerminalRuleCall_8()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:1447:1: entryRuleIfConditional returns [EObject current=null] : iv_ruleIfConditional= ruleIfConditional EOF ;
    public final EObject entryRuleIfConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfConditional = null;


        try {
            // InternalPreprocess.g:1448:2: (iv_ruleIfConditional= ruleIfConditional EOF )
            // InternalPreprocess.g:1449:2: iv_ruleIfConditional= ruleIfConditional EOF
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
    // InternalPreprocess.g:1456:1: ruleIfConditional returns [EObject current=null] : ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleIfConditional() throws RecognitionException {
        EObject current = null;

        Token this_IF_1=null;
        Token this_WHITESPACE_2=null;
        Token this_NEWLINE_4=null;
        EObject lv_expression_3_0 = null;

        EObject lv_group_5_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1462:7: ( ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:1464:1: ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:1464:1: ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:1465:1: () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:1465:1: ()
            // InternalPreprocess.g:1466:2: 
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
            // InternalPreprocess.g:1484:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_WHITESPACE) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalPreprocess.g:1484:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIfConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:1491:1: ( (lv_expression_3_0= ruleConstantExpression ) )
            // InternalPreprocess.g:1492:1: (lv_expression_3_0= ruleConstantExpression )
            {
            // InternalPreprocess.g:1492:1: (lv_expression_3_0= ruleConstantExpression )
            // InternalPreprocess.g:1493:3: lv_expression_3_0= ruleConstantExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfConditionalAccess().getExpressionConstantExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_3);
            lv_expression_3_0=ruleConstantExpression();

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
                      		"at.jku.weiner.c.common.Common.ConstantExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_4, grammarAccess.getIfConditionalAccess().getNEWLINETerminalRuleCall_4()); 
                  
            }
            // InternalPreprocess.g:1519:1: ( (lv_group_5_0= ruleGroupOpt ) )
            // InternalPreprocess.g:1520:1: (lv_group_5_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:1520:1: (lv_group_5_0= ruleGroupOpt )
            // InternalPreprocess.g:1521:3: lv_group_5_0= ruleGroupOpt
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
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:1549:1: entryRuleIfDefConditional returns [EObject current=null] : iv_ruleIfDefConditional= ruleIfDefConditional EOF ;
    public final EObject entryRuleIfDefConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfDefConditional = null;


        try {
            // InternalPreprocess.g:1550:2: (iv_ruleIfDefConditional= ruleIfDefConditional EOF )
            // InternalPreprocess.g:1551:2: iv_ruleIfDefConditional= ruleIfDefConditional EOF
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
    // InternalPreprocess.g:1558:1: ruleIfDefConditional returns [EObject current=null] : ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleIfDefConditional() throws RecognitionException {
        EObject current = null;

        Token this_IFDEF_1=null;
        Token this_WHITESPACE_2=null;
        Token lv_id_3_0=null;
        Token this_NEWLINE_4=null;
        EObject lv_group_5_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1564:7: ( ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:1566:1: ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:1566:1: ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:1567:1: () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:1567:1: ()
            // InternalPreprocess.g:1568:2: 
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
            // InternalPreprocess.g:1586:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_WHITESPACE) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalPreprocess.g:1586:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIfDefConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);

            // InternalPreprocess.g:1593:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:1594:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:1594:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:1595:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_3); if (state.failed) return current;
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
                      		"at.jku.weiner.c.common.Common.ID");
              	    
            }

            }


            }

            this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_4, grammarAccess.getIfDefConditionalAccess().getNEWLINETerminalRuleCall_4()); 
                  
            }
            // InternalPreprocess.g:1621:1: ( (lv_group_5_0= ruleGroupOpt ) )
            // InternalPreprocess.g:1622:1: (lv_group_5_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:1622:1: (lv_group_5_0= ruleGroupOpt )
            // InternalPreprocess.g:1623:3: lv_group_5_0= ruleGroupOpt
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
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:1651:1: entryRuleIfNotDefConditional returns [EObject current=null] : iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF ;
    public final EObject entryRuleIfNotDefConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfNotDefConditional = null;


        try {
            // InternalPreprocess.g:1652:2: (iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF )
            // InternalPreprocess.g:1653:2: iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF
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
    // InternalPreprocess.g:1660:1: ruleIfNotDefConditional returns [EObject current=null] : ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleIfNotDefConditional() throws RecognitionException {
        EObject current = null;

        Token this_IFNOTDEF_1=null;
        Token this_WHITESPACE_2=null;
        Token lv_id_3_0=null;
        Token this_NEWLINE_4=null;
        EObject lv_group_5_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1666:7: ( ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:1668:1: ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:1668:1: ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:1669:1: () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:1669:1: ()
            // InternalPreprocess.g:1670:2: 
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
            // InternalPreprocess.g:1688:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_WHITESPACE) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalPreprocess.g:1688:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIfNotDefConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);

            // InternalPreprocess.g:1695:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:1696:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:1696:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:1697:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_3); if (state.failed) return current;
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
                      		"at.jku.weiner.c.common.Common.ID");
              	    
            }

            }


            }

            this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_4, grammarAccess.getIfNotDefConditionalAccess().getNEWLINETerminalRuleCall_4()); 
                  
            }
            // InternalPreprocess.g:1723:1: ( (lv_group_5_0= ruleGroupOpt ) )
            // InternalPreprocess.g:1724:1: (lv_group_5_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:1724:1: (lv_group_5_0= ruleGroupOpt )
            // InternalPreprocess.g:1725:3: lv_group_5_0= ruleGroupOpt
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
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:1753:1: entryRuleElIfConditional returns [EObject current=null] : iv_ruleElIfConditional= ruleElIfConditional EOF ;
    public final EObject entryRuleElIfConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElIfConditional = null;


        try {
            // InternalPreprocess.g:1754:2: (iv_ruleElIfConditional= ruleElIfConditional EOF )
            // InternalPreprocess.g:1755:2: iv_ruleElIfConditional= ruleElIfConditional EOF
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
    // InternalPreprocess.g:1762:1: ruleElIfConditional returns [EObject current=null] : ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) this_NEWLINE_7= RULE_NEWLINE ( (lv_group_8_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleElIfConditional() throws RecognitionException {
        EObject current = null;

        Token this_WHITESPACE_1=null;
        Token this_HASH_2=null;
        Token this_WHITESPACE_3=null;
        Token this_ELIF_4=null;
        Token this_WHITESPACE_5=null;
        Token this_NEWLINE_7=null;
        EObject lv_expression_6_0 = null;

        EObject lv_group_8_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1768:7: ( ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) this_NEWLINE_7= RULE_NEWLINE ( (lv_group_8_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:1770:1: ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) this_NEWLINE_7= RULE_NEWLINE ( (lv_group_8_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:1770:1: ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) this_NEWLINE_7= RULE_NEWLINE ( (lv_group_8_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:1771:1: () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) this_NEWLINE_7= RULE_NEWLINE ( (lv_group_8_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:1771:1: ()
            // InternalPreprocess.g:1772:2: 
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

            // InternalPreprocess.g:1783:1: ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF )
            // InternalPreprocess.g:1784:1: (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF
            {
            // InternalPreprocess.g:1784:1: (this_WHITESPACE_1= RULE_WHITESPACE )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_WHITESPACE) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalPreprocess.g:1784:2: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_1_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_2, grammarAccess.getElIfConditionalAccess().getHASHTerminalRuleCall_1_1()); 
                  
            }
            // InternalPreprocess.g:1798:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_WHITESPACE) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalPreprocess.g:1798:2: this_WHITESPACE_3= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_3, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_1_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            this_ELIF_4=(Token)match(input,RULE_ELIF,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ELIF_4, grammarAccess.getElIfConditionalAccess().getELIFTerminalRuleCall_1_3()); 
                  
            }

            }

            // InternalPreprocess.g:1814:1: (this_WHITESPACE_5= RULE_WHITESPACE )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_WHITESPACE) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalPreprocess.g:1814:2: this_WHITESPACE_5= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_5=(Token)match(input,RULE_WHITESPACE,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_5, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);

            // InternalPreprocess.g:1821:1: ( (lv_expression_6_0= ruleConstantExpression ) )
            // InternalPreprocess.g:1822:1: (lv_expression_6_0= ruleConstantExpression )
            {
            // InternalPreprocess.g:1822:1: (lv_expression_6_0= ruleConstantExpression )
            // InternalPreprocess.g:1823:3: lv_expression_6_0= ruleConstantExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElIfConditionalAccess().getExpressionConstantExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_3);
            lv_expression_6_0=ruleConstantExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElIfConditionalRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_6_0, 
                      		"at.jku.weiner.c.common.Common.ConstantExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_7, grammarAccess.getElIfConditionalAccess().getNEWLINETerminalRuleCall_4()); 
                  
            }
            // InternalPreprocess.g:1849:1: ( (lv_group_8_0= ruleGroupOpt ) )
            // InternalPreprocess.g:1850:1: (lv_group_8_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:1850:1: (lv_group_8_0= ruleGroupOpt )
            // InternalPreprocess.g:1851:3: lv_group_8_0= ruleGroupOpt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElIfConditionalAccess().getGroupGroupOptParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_group_8_0=ruleGroupOpt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElIfConditionalRule());
              	        }
                     		set(
                     			current, 
                     			"group",
                      		lv_group_8_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.GroupOpt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:1879:1: entryRuleElseConditional returns [EObject current=null] : iv_ruleElseConditional= ruleElseConditional EOF ;
    public final EObject entryRuleElseConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseConditional = null;


        try {
            // InternalPreprocess.g:1880:2: (iv_ruleElseConditional= ruleElseConditional EOF )
            // InternalPreprocess.g:1881:2: iv_ruleElseConditional= ruleElseConditional EOF
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
    // InternalPreprocess.g:1888:1: ruleElseConditional returns [EObject current=null] : ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleElseConditional() throws RecognitionException {
        EObject current = null;

        Token this_WHITESPACE_1=null;
        Token this_HASH_2=null;
        Token this_WHITESPACE_3=null;
        Token this_ELSE_4=null;
        Token this_NEWLINE_5=null;
        EObject lv_group_6_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1894:7: ( ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:1896:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:1896:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:1897:1: () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:1897:1: ()
            // InternalPreprocess.g:1898:2: 
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

            // InternalPreprocess.g:1909:1: (this_WHITESPACE_1= RULE_WHITESPACE )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_WHITESPACE) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalPreprocess.g:1909:2: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getElseConditionalAccess().getWHITESPACETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_2, grammarAccess.getElseConditionalAccess().getHASHTerminalRuleCall_2()); 
                  
            }
            // InternalPreprocess.g:1923:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_WHITESPACE) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalPreprocess.g:1923:2: this_WHITESPACE_3= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_3, grammarAccess.getElseConditionalAccess().getWHITESPACETerminalRuleCall_3()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            this_ELSE_4=(Token)match(input,RULE_ELSE,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ELSE_4, grammarAccess.getElseConditionalAccess().getELSETerminalRuleCall_4()); 
                  
            }
            this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_5, grammarAccess.getElseConditionalAccess().getNEWLINETerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:1944:1: ( (lv_group_6_0= ruleGroupOpt ) )
            // InternalPreprocess.g:1945:1: (lv_group_6_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:1945:1: (lv_group_6_0= ruleGroupOpt )
            // InternalPreprocess.g:1946:3: lv_group_6_0= ruleGroupOpt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElseConditionalAccess().getGroupGroupOptParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_group_6_0=ruleGroupOpt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElseConditionalRule());
              	        }
                     		set(
                     			current, 
                     			"group",
                      		lv_group_6_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.GroupOpt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:1974:1: entryRulePragmaDirective returns [EObject current=null] : iv_rulePragmaDirective= rulePragmaDirective EOF ;
    public final EObject entryRulePragmaDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePragmaDirective = null;


        try {
            // InternalPreprocess.g:1975:2: (iv_rulePragmaDirective= rulePragmaDirective EOF )
            // InternalPreprocess.g:1976:2: iv_rulePragmaDirective= rulePragmaDirective EOF
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
    // InternalPreprocess.g:1983:1: rulePragmaDirective returns [EObject current=null] : ( () this_PRAGMA_1= RULE_PRAGMA ) ;
    public final EObject rulePragmaDirective() throws RecognitionException {
        EObject current = null;

        Token this_PRAGMA_1=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1989:7: ( ( () this_PRAGMA_1= RULE_PRAGMA ) )
            // InternalPreprocess.g:1991:1: ( () this_PRAGMA_1= RULE_PRAGMA )
            {
            // InternalPreprocess.g:1991:1: ( () this_PRAGMA_1= RULE_PRAGMA )
            // InternalPreprocess.g:1992:1: () this_PRAGMA_1= RULE_PRAGMA
            {
            // InternalPreprocess.g:1992:1: ()
            // InternalPreprocess.g:1993:2: 
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
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:2020:1: entryRuleNullDirective returns [EObject current=null] : iv_ruleNullDirective= ruleNullDirective EOF ;
    public final EObject entryRuleNullDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullDirective = null;


        try {
            // InternalPreprocess.g:2021:2: (iv_ruleNullDirective= ruleNullDirective EOF )
            // InternalPreprocess.g:2022:2: iv_ruleNullDirective= ruleNullDirective EOF
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
    // InternalPreprocess.g:2029:1: ruleNullDirective returns [EObject current=null] : () ;
    public final EObject ruleNullDirective() throws RecognitionException {
        EObject current = null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2035:7: ( () )
            // InternalPreprocess.g:2037:1: ()
            {
            // InternalPreprocess.g:2037:1: ()
            // InternalPreprocess.g:2038:2: 
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
                  		/*no after found*/
                   
            }
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNullDirective"


    // $ANTLR start "entryRuleNewLineLine"
    // InternalPreprocess.g:2056:1: entryRuleNewLineLine returns [EObject current=null] : iv_ruleNewLineLine= ruleNewLineLine EOF ;
    public final EObject entryRuleNewLineLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewLineLine = null;


        try {
            // InternalPreprocess.g:2057:2: (iv_ruleNewLineLine= ruleNewLineLine EOF )
            // InternalPreprocess.g:2058:2: iv_ruleNewLineLine= ruleNewLineLine EOF
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
    // InternalPreprocess.g:2065:1: ruleNewLineLine returns [EObject current=null] : () ;
    public final EObject ruleNewLineLine() throws RecognitionException {
        EObject current = null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2071:7: ( () )
            // InternalPreprocess.g:2073:1: ()
            {
            // InternalPreprocess.g:2073:1: ()
            // InternalPreprocess.g:2074:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getNewLineLineAccess().getNewLineLineAction(),
                          current);
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
            }
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNewLineLine"


    // $ANTLR start "entryRuleCode"
    // InternalPreprocess.g:2092:1: entryRuleCode returns [EObject current=null] : iv_ruleCode= ruleCode EOF ;
    public final EObject entryRuleCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCode = null;


        try {
            // InternalPreprocess.g:2093:2: (iv_ruleCode= ruleCode EOF )
            // InternalPreprocess.g:2094:2: iv_ruleCode= ruleCode EOF
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
    // InternalPreprocess.g:2101:1: ruleCode returns [EObject current=null] : ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) ) ;
    public final EObject ruleCode() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_code_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2107:7: ( ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) ) )
            // InternalPreprocess.g:2109:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) )
            {
            // InternalPreprocess.g:2109:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) )
            // InternalPreprocess.g:2110:1: () ( (lv_code_1_0= ruleMyCodeLineExtended ) )
            {
            // InternalPreprocess.g:2110:1: ()
            // InternalPreprocess.g:2111:2: 
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

            // InternalPreprocess.g:2122:1: ( (lv_code_1_0= ruleMyCodeLineExtended ) )
            // InternalPreprocess.g:2123:1: (lv_code_1_0= ruleMyCodeLineExtended )
            {
            // InternalPreprocess.g:2123:1: (lv_code_1_0= ruleMyCodeLineExtended )
            // InternalPreprocess.g:2124:3: lv_code_1_0= ruleMyCodeLineExtended
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCodeAccess().getCodeMyCodeLineExtendedParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
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


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:2152:1: entryRuleMyCode returns [String current=null] : iv_ruleMyCode= ruleMyCode EOF ;
    public final String entryRuleMyCode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCode = null;


        try {
            // InternalPreprocess.g:2153:2: (iv_ruleMyCode= ruleMyCode EOF )
            // InternalPreprocess.g:2154:2: iv_ruleMyCode= ruleMyCode EOF
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
    // InternalPreprocess.g:2161:1: ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_SpecialKeywords_11= ruleSpecialKeywords | this_Constant1_12= ruleConstant1 ) ;
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

        AntlrDatatypeRuleToken this_Constant1_12 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2164:28: ( (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_SpecialKeywords_11= ruleSpecialKeywords | this_Constant1_12= ruleConstant1 ) )
            // InternalPreprocess.g:2165:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_SpecialKeywords_11= ruleSpecialKeywords | this_Constant1_12= ruleConstant1 )
            {
            // InternalPreprocess.g:2165:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_SpecialKeywords_11= ruleSpecialKeywords | this_Constant1_12= ruleConstant1 )
            int alt34=13;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt34=1;
                }
                break;
            case RULE_SPECIAL:
                {
                alt34=2;
                }
                break;
            case RULE_INCLUDE:
                {
                alt34=3;
                }
                break;
            case RULE_DEFINE:
                {
                alt34=4;
                }
                break;
            case RULE_ERROR:
                {
                alt34=5;
                }
                break;
            case RULE_PRAGMA:
                {
                alt34=6;
                }
                break;
            case RULE_IFDEF:
                {
                alt34=7;
                }
                break;
            case RULE_ENDIF:
                {
                alt34=8;
                }
                break;
            case RULE_IFNOTDEF:
                {
                alt34=9;
                }
                break;
            case RULE_IF:
                {
                alt34=10;
                }
                break;
            case RULE_DEFINED:
                {
                alt34=11;
                }
                break;
            case RULE_SKW_LEFTPAREN:
            case RULE_SKW_RIGHTPAREN:
            case RULE_SKW_COMMA:
            case RULE_SKW_QUESTION:
            case RULE_SKW_COLON:
            case RULE_SKW_OROR:
            case RULE_SKW_ANDAND:
            case RULE_SKW_OR:
            case RULE_SKW_CARET:
            case RULE_SKW_AND:
            case RULE_SKW_EQUAL:
            case RULE_SKW_NOTEQUAL:
            case RULE_SKW_LESS:
            case RULE_SKW_GREATER:
            case RULE_SKW_LESSEQUAL:
            case RULE_SKW_GREATEREQUAL:
            case RULE_SKW_LEFTSHIFT:
            case RULE_SKW_RIGHTSHIFT:
            case RULE_SKW_PLUS:
            case RULE_SKW_MINUS:
            case RULE_SKW_STAR:
            case RULE_SKW_DIV:
            case RULE_SKW_MOD:
            case RULE_SKW_TILDE:
            case RULE_SKW_NOT:
            case RULE_SKW_ASSIGN:
            case RULE_SKW_BACKSLASH:
            case RULE_SKW_DOT:
            case RULE_SKW_DOUBLEQUOTE:
            case RULE_SKW_LEFTBRACE:
            case RULE_SKW_LEFTBRACKET:
            case RULE_SKW_MINUSMINUS:
            case RULE_SKW_PLUSPLUS:
            case RULE_SKW_RIGHTBRACE:
            case RULE_SKW_RIGHTBRACKET:
            case RULE_SKW_SEMI:
            case RULE_SKW_SINGLEQUOTE:
                {
                alt34=12;
                }
                break;
            case RULE_HEX_LITERAL:
            case RULE_OCTAL_LITERAL:
            case RULE_DECIMAL_LITERAL:
            case RULE_CHAR_LITERAL:
            case RULE_STRING_LITERAL:
            case RULE_FLOAT_LITERAL:
            case RULE_BIN_LITERAL:
                {
                alt34=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalPreprocess.g:2165:6: this_ID_0= RULE_ID
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
                    // InternalPreprocess.g:2173:10: this_SPECIAL_1= RULE_SPECIAL
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
                    // InternalPreprocess.g:2181:10: this_INCLUDE_2= RULE_INCLUDE
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
                    // InternalPreprocess.g:2189:10: this_DEFINE_3= RULE_DEFINE
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
                    // InternalPreprocess.g:2197:10: this_ERROR_4= RULE_ERROR
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
                    // InternalPreprocess.g:2205:10: this_PRAGMA_5= RULE_PRAGMA
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
                    // InternalPreprocess.g:2213:10: this_IFDEF_6= RULE_IFDEF
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
                    // InternalPreprocess.g:2221:10: this_ENDIF_7= RULE_ENDIF
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
                    // InternalPreprocess.g:2229:10: this_IFNOTDEF_8= RULE_IFNOTDEF
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
                    // InternalPreprocess.g:2237:10: this_IF_9= RULE_IF
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
                    // InternalPreprocess.g:2245:10: this_DEFINED_10= RULE_DEFINED
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
                    // InternalPreprocess.g:2254:5: this_SpecialKeywords_11= ruleSpecialKeywords
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
                    // InternalPreprocess.g:2266:5: this_Constant1_12= ruleConstant1
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeAccess().getConstant1ParserRuleCall_12()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Constant1_12=ruleConstant1();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Constant1_12);
                          
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
    // InternalPreprocess.g:2284:1: entryRuleMyDefineLine returns [String current=null] : iv_ruleMyDefineLine= ruleMyDefineLine EOF ;
    public final String entryRuleMyDefineLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyDefineLine = null;


        try {
            // InternalPreprocess.g:2285:2: (iv_ruleMyDefineLine= ruleMyDefineLine EOF )
            // InternalPreprocess.g:2286:2: iv_ruleMyDefineLine= ruleMyDefineLine EOF
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
    // InternalPreprocess.g:2293:1: ruleMyDefineLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_HASH_2= RULE_HASH )* ;
    public final AntlrDatatypeRuleToken ruleMyDefineLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_1=null;
        Token this_HASH_2=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2296:28: ( (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_HASH_2= RULE_HASH )* )
            // InternalPreprocess.g:2297:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_HASH_2= RULE_HASH )*
            {
            // InternalPreprocess.g:2297:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_HASH_2= RULE_HASH )*
            loop35:
            do {
                int alt35=4;
                switch ( input.LA(1) ) {
                case RULE_INCLUDE:
                case RULE_DEFINE:
                case RULE_ID:
                case RULE_SKW_LEFTPAREN:
                case RULE_SKW_RIGHTPAREN:
                case RULE_SKW_COMMA:
                case RULE_ERROR:
                case RULE_ENDIF:
                case RULE_IF:
                case RULE_IFDEF:
                case RULE_IFNOTDEF:
                case RULE_PRAGMA:
                case RULE_SPECIAL:
                case RULE_DEFINED:
                case RULE_SKW_QUESTION:
                case RULE_SKW_COLON:
                case RULE_SKW_OROR:
                case RULE_SKW_ANDAND:
                case RULE_SKW_OR:
                case RULE_SKW_CARET:
                case RULE_SKW_AND:
                case RULE_SKW_EQUAL:
                case RULE_SKW_NOTEQUAL:
                case RULE_SKW_LESS:
                case RULE_SKW_GREATER:
                case RULE_SKW_LESSEQUAL:
                case RULE_SKW_GREATEREQUAL:
                case RULE_SKW_LEFTSHIFT:
                case RULE_SKW_RIGHTSHIFT:
                case RULE_SKW_PLUS:
                case RULE_SKW_MINUS:
                case RULE_SKW_STAR:
                case RULE_SKW_DIV:
                case RULE_SKW_MOD:
                case RULE_SKW_TILDE:
                case RULE_SKW_NOT:
                case RULE_HEX_LITERAL:
                case RULE_OCTAL_LITERAL:
                case RULE_DECIMAL_LITERAL:
                case RULE_CHAR_LITERAL:
                case RULE_STRING_LITERAL:
                case RULE_FLOAT_LITERAL:
                case RULE_BIN_LITERAL:
                case RULE_SKW_ASSIGN:
                case RULE_SKW_BACKSLASH:
                case RULE_SKW_DOT:
                case RULE_SKW_DOUBLEQUOTE:
                case RULE_SKW_LEFTBRACE:
                case RULE_SKW_LEFTBRACKET:
                case RULE_SKW_MINUSMINUS:
                case RULE_SKW_PLUSPLUS:
                case RULE_SKW_RIGHTBRACE:
                case RULE_SKW_RIGHTBRACKET:
                case RULE_SKW_SEMI:
                case RULE_SKW_SINGLEQUOTE:
                    {
                    alt35=1;
                    }
                    break;
                case RULE_WHITESPACE:
                    {
                    alt35=2;
                    }
                    break;
                case RULE_HASH:
                    {
                    alt35=3;
                    }
                    break;

                }

                switch (alt35) {
            	case 1 :
            	    // InternalPreprocess.g:2298:5: this_MyCode_0= ruleMyCode
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMyDefineLineAccess().getMyCodeParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_4);
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
            	    // InternalPreprocess.g:2309:10: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WHITESPACE_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getMyDefineLineAccess().getWHITESPACETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;
            	case 3 :
            	    // InternalPreprocess.g:2317:10: this_HASH_2= RULE_HASH
            	    {
            	    this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_HASH_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_HASH_2, grammarAccess.getMyDefineLineAccess().getHASHTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // InternalPreprocess.g:2332:1: entryRuleMyCodeLine returns [String current=null] : iv_ruleMyCodeLine= ruleMyCodeLine EOF ;
    public final String entryRuleMyCodeLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLine = null;


        try {
            // InternalPreprocess.g:2333:2: (iv_ruleMyCodeLine= ruleMyCodeLine EOF )
            // InternalPreprocess.g:2334:2: iv_ruleMyCodeLine= ruleMyCodeLine EOF
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
    // InternalPreprocess.g:2341:1: ruleMyCodeLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+ ;
    public final AntlrDatatypeRuleToken ruleMyCodeLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_1=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2344:28: ( (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+ )
            // InternalPreprocess.g:2345:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+
            {
            // InternalPreprocess.g:2345:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+
            int cnt36=0;
            loop36:
            do {
                int alt36=3;
                alt36 = dfa36.predict(input);
                switch (alt36) {
            	case 1 :
            	    // InternalPreprocess.g:2346:5: this_MyCode_0= ruleMyCode
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMyCodeLineAccess().getMyCodeParserRuleCall_0()); 
            	          
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
            	    // InternalPreprocess.g:2357:10: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_20); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WHITESPACE_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getMyCodeLineAccess().getWHITESPACETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
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
    // InternalPreprocess.g:2372:1: entryRuleMyCodeLineExtended returns [String current=null] : iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF ;
    public final String entryRuleMyCodeLineExtended() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtended = null;


        try {
            // InternalPreprocess.g:2373:2: (iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF )
            // InternalPreprocess.g:2374:2: iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF
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
    // InternalPreprocess.g:2381:1: ruleMyCodeLineExtended returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? ) ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtended() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_0=null;
        Token this_HASH_3=null;
        AntlrDatatypeRuleToken this_MyCode_1 = null;

        AntlrDatatypeRuleToken this_MyCodeLine_2 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2384:28: ( ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? ) )
            // InternalPreprocess.g:2385:1: ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? )
            {
            // InternalPreprocess.g:2385:1: ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )? )
            // InternalPreprocess.g:2385:2: (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )?
            {
            // InternalPreprocess.g:2385:2: (this_WHITESPACE_0= RULE_WHITESPACE )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_WHITESPACE) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalPreprocess.g:2385:7: this_WHITESPACE_0= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_0=(Token)match(input,RULE_WHITESPACE,FOLLOW_20); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WHITESPACE_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_0, grammarAccess.getMyCodeLineExtendedAccess().getWHITESPACETerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            // InternalPreprocess.g:2392:3: (this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_INCLUDE && LA39_0<=RULE_ERROR)||(LA39_0>=RULE_ENDIF && LA39_0<=RULE_IFNOTDEF)||(LA39_0>=RULE_PRAGMA && LA39_0<=RULE_SKW_SINGLEQUOTE)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalPreprocess.g:2393:5: this_MyCode_1= ruleMyCode (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeLineExtendedAccess().getMyCodeParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_4);
                    this_MyCode_1=ruleMyCode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_MyCode_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalPreprocess.g:2403:1: (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
                    loop38:
                    do {
                        int alt38=3;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==RULE_WHITESPACE||(LA38_0>=RULE_INCLUDE && LA38_0<=RULE_ERROR)||(LA38_0>=RULE_ENDIF && LA38_0<=RULE_IFNOTDEF)||(LA38_0>=RULE_PRAGMA && LA38_0<=RULE_SKW_SINGLEQUOTE)) ) {
                            alt38=1;
                        }
                        else if ( (LA38_0==RULE_HASH) ) {
                            alt38=2;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalPreprocess.g:2404:5: this_MyCodeLine_2= ruleMyCodeLine
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	              newCompositeNode(grammarAccess.getMyCodeLineExtendedAccess().getMyCodeLineParserRuleCall_1_1_0()); 
                    	          
                    	    }
                    	    pushFollow(FOLLOW_4);
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
                    	    // InternalPreprocess.g:2415:10: this_HASH_3= RULE_HASH
                    	    {
                    	    this_HASH_3=(Token)match(input,RULE_HASH,FOLLOW_4); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_HASH_3);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_HASH_3, grammarAccess.getMyCodeLineExtendedAccess().getHASHTerminalRuleCall_1_1_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop38;
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


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalPreprocess.g:2430:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalPreprocess.g:2431:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalPreprocess.g:2432:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalPreprocess.g:2439:1: rulePrimaryExpression returns [EObject current=null] : ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) ) ;
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
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2445:7: ( ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) ) )
            // InternalPreprocess.g:2447:1: ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) )
            {
            // InternalPreprocess.g:2447:1: ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) )
            // InternalPreprocess.g:2448:1: () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) )
            {
            // InternalPreprocess.g:2448:1: ()
            // InternalPreprocess.g:2449:2: 
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

            // InternalPreprocess.g:2460:1: ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) )
            int alt42=4;
            switch ( input.LA(1) ) {
            case RULE_DEFINED:
                {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==RULE_SKW_LEFTPAREN) ) {
                    alt42=2;
                }
                else if ( (LA42_1==RULE_ID) ) {
                    alt42=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                alt42=1;
                }
                break;
            case RULE_SKW_LEFTPAREN:
                {
                int LA42_3 = input.LA(2);

                if ( (LA42_3==RULE_SKW_LEFTPAREN||LA42_3==RULE_DEFINED||LA42_3==RULE_SKW_AND||(LA42_3>=RULE_SKW_PLUS && LA42_3<=RULE_SKW_STAR)||(LA42_3>=RULE_SKW_TILDE && LA42_3<=RULE_BIN_LITERAL)) ) {
                    alt42=4;
                }
                else if ( (LA42_3==RULE_ID) ) {
                    int LA42_7 = input.LA(3);

                    if ( (LA42_7==RULE_SKW_RIGHTPAREN) ) {
                        int LA42_8 = input.LA(4);

                        if ( (synpred66_InternalPreprocess()) ) {
                            alt42=2;
                        }
                        else if ( (true) ) {
                            alt42=4;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 42, 8, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA42_7==RULE_SKW_LEFTPAREN||LA42_7==RULE_SKW_QUESTION||(LA42_7>=RULE_SKW_OROR && LA42_7<=RULE_SKW_MOD)) ) {
                        alt42=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 42, 7, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX_LITERAL:
            case RULE_OCTAL_LITERAL:
            case RULE_DECIMAL_LITERAL:
            case RULE_CHAR_LITERAL:
            case RULE_STRING_LITERAL:
            case RULE_FLOAT_LITERAL:
            case RULE_BIN_LITERAL:
                {
                alt42=3;
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
                    // InternalPreprocess.g:2461:1: ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) )
                    {
                    // InternalPreprocess.g:2461:1: ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) )
                    // InternalPreprocess.g:2462:1: ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) )
                    {
                    // InternalPreprocess.g:2462:1: ( (lv_defined_1_0= RULE_DEFINED ) )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==RULE_DEFINED) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // InternalPreprocess.g:2463:1: (lv_defined_1_0= RULE_DEFINED )
                            {
                            // InternalPreprocess.g:2463:1: (lv_defined_1_0= RULE_DEFINED )
                            // InternalPreprocess.g:2464:3: lv_defined_1_0= RULE_DEFINED
                            {
                            lv_defined_1_0=(Token)match(input,RULE_DEFINED,FOLLOW_21); if (state.failed) return current;
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

                    // InternalPreprocess.g:2483:1: ( (lv_id_2_0= RULE_ID ) )
                    // InternalPreprocess.g:2484:1: (lv_id_2_0= RULE_ID )
                    {
                    // InternalPreprocess.g:2484:1: (lv_id_2_0= RULE_ID )
                    // InternalPreprocess.g:2485:3: lv_id_2_0= RULE_ID
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
                              		"at.jku.weiner.c.common.Common.ID");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:2507:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
                    {
                    // InternalPreprocess.g:2507:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
                    // InternalPreprocess.g:2508:1: ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN
                    {
                    // InternalPreprocess.g:2508:1: ( (lv_defined_3_0= RULE_DEFINED ) )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==RULE_DEFINED) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // InternalPreprocess.g:2509:1: (lv_defined_3_0= RULE_DEFINED )
                            {
                            // InternalPreprocess.g:2509:1: (lv_defined_3_0= RULE_DEFINED )
                            // InternalPreprocess.g:2510:3: lv_defined_3_0= RULE_DEFINED
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

                    this_SKW_LEFTPAREN_4=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LEFTPAREN_4, grammarAccess.getPrimaryExpressionAccess().getSKW_LEFTPARENTerminalRuleCall_1_1_1()); 
                          
                    }
                    // InternalPreprocess.g:2536:1: ( (lv_id_5_0= RULE_ID ) )
                    // InternalPreprocess.g:2537:1: (lv_id_5_0= RULE_ID )
                    {
                    // InternalPreprocess.g:2537:1: (lv_id_5_0= RULE_ID )
                    // InternalPreprocess.g:2538:3: lv_id_5_0= RULE_ID
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
                              		"at.jku.weiner.c.common.Common.ID");
                      	    
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
                    // InternalPreprocess.g:2567:1: ( (lv_const_7_0= ruleConstant1 ) )
                    {
                    // InternalPreprocess.g:2567:1: ( (lv_const_7_0= ruleConstant1 ) )
                    // InternalPreprocess.g:2568:1: (lv_const_7_0= ruleConstant1 )
                    {
                    // InternalPreprocess.g:2568:1: (lv_const_7_0= ruleConstant1 )
                    // InternalPreprocess.g:2569:3: lv_const_7_0= ruleConstant1
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getConstConstant1ParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_const_7_0=ruleConstant1();

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
                              		"at.jku.weiner.c.common.Common.Constant1");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalPreprocess.g:2589:1: (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN )
                    {
                    // InternalPreprocess.g:2589:1: (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN )
                    // InternalPreprocess.g:2590:1: this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN
                    {
                    this_SKW_LEFTPAREN_8=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LEFTPAREN_8, grammarAccess.getPrimaryExpressionAccess().getSKW_LEFTPARENTerminalRuleCall_1_3_0()); 
                          
                    }
                    // InternalPreprocess.g:2597:1: ( (lv_expr_9_0= ruleExpression ) )
                    // InternalPreprocess.g:2598:1: (lv_expr_9_0= ruleExpression )
                    {
                    // InternalPreprocess.g:2598:1: (lv_expr_9_0= ruleExpression )
                    // InternalPreprocess.g:2599:3: lv_expr_9_0= ruleExpression
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
                              		"at.jku.weiner.c.common.Common.Expression");
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
                  		/*no after found*/
                   
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


    // $ANTLR start "entryRuleExpression"
    // InternalPreprocess.g:2638:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
        	
        try {
            // InternalPreprocess.g:2642:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalPreprocess.g:2643:2: iv_ruleExpression= ruleExpression EOF
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalPreprocess.g:2653:1: ruleExpression returns [EObject current=null] : ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         enterRule();
           		/*no init found*/
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
            
        try {
            // InternalPreprocess.g:2660:7: ( ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) ) )
            // InternalPreprocess.g:2662:1: ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) )
            {
            // InternalPreprocess.g:2662:1: ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) )
            // InternalPreprocess.g:2663:1: () ( (lv_expression_1_0= ruleConditionalExpression ) )
            {
            // InternalPreprocess.g:2663:1: ()
            // InternalPreprocess.g:2664:2: 
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

            // InternalPreprocess.g:2675:1: ( (lv_expression_1_0= ruleConditionalExpression ) )
            // InternalPreprocess.g:2676:1: (lv_expression_1_0= ruleConditionalExpression )
            {
            // InternalPreprocess.g:2676:1: (lv_expression_1_0= ruleConditionalExpression )
            // InternalPreprocess.g:2677:3: lv_expression_1_0= ruleConditionalExpression
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
                      		"at.jku.weiner.c.common.Common.ConditionalExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleConstantExpression"
    // InternalPreprocess.g:2708:1: entryRuleConstantExpression returns [EObject current=null] : iv_ruleConstantExpression= ruleConstantExpression EOF ;
    public final EObject entryRuleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantExpression = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
        	
        try {
            // InternalPreprocess.g:2712:2: (iv_ruleConstantExpression= ruleConstantExpression EOF )
            // InternalPreprocess.g:2713:2: iv_ruleConstantExpression= ruleConstantExpression EOF
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleConstantExpression"


    // $ANTLR start "ruleConstantExpression"
    // InternalPreprocess.g:2723:1: ruleConstantExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) ) ;
    public final EObject ruleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;


         enterRule();
           		/*no init found*/
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
            
        try {
            // InternalPreprocess.g:2730:7: ( ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) ) )
            // InternalPreprocess.g:2732:1: ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) )
            {
            // InternalPreprocess.g:2732:1: ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) )
            // InternalPreprocess.g:2733:1: () ( (lv_expr_1_0= ruleConditionalExpression ) )
            {
            // InternalPreprocess.g:2733:1: ()
            // InternalPreprocess.g:2734:2: 
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

            // InternalPreprocess.g:2745:1: ( (lv_expr_1_0= ruleConditionalExpression ) )
            // InternalPreprocess.g:2746:1: (lv_expr_1_0= ruleConditionalExpression )
            {
            // InternalPreprocess.g:2746:1: (lv_expr_1_0= ruleConditionalExpression )
            // InternalPreprocess.g:2747:3: lv_expr_1_0= ruleConditionalExpression
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
                      		"at.jku.weiner.c.common.Common.ConditionalExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // $ANTLR end "ruleConstantExpression"


    // $ANTLR start "entryRuleConditionalExpression"
    // InternalPreprocess.g:2778:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalPreprocess.g:2779:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalPreprocess.g:2780:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
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
    // InternalPreprocess.g:2787:1: ruleConditionalExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_QUESTION_2=null;
        Token this_SKW_COLON_4=null;
        EObject lv_expr_1_0 = null;

        EObject lv_qExpr_3_0 = null;

        EObject lv_cExpr_5_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2793:7: ( ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) )
            // InternalPreprocess.g:2795:1: ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
            {
            // InternalPreprocess.g:2795:1: ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
            // InternalPreprocess.g:2796:1: () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
            {
            // InternalPreprocess.g:2796:1: ()
            // InternalPreprocess.g:2797:2: 
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

            // InternalPreprocess.g:2808:1: ( (lv_expr_1_0= ruleLogicalOrExpression ) )
            // InternalPreprocess.g:2809:1: (lv_expr_1_0= ruleLogicalOrExpression )
            {
            // InternalPreprocess.g:2809:1: (lv_expr_1_0= ruleLogicalOrExpression )
            // InternalPreprocess.g:2810:3: lv_expr_1_0= ruleLogicalOrExpression
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
                      		"at.jku.weiner.c.common.Common.LogicalOrExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:2829:1: (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_SKW_QUESTION) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalPreprocess.g:2830:1: this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) )
                    {
                    this_SKW_QUESTION_2=(Token)match(input,RULE_SKW_QUESTION,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_QUESTION_2, grammarAccess.getConditionalExpressionAccess().getSKW_QUESTIONTerminalRuleCall_2_0()); 
                          
                    }
                    // InternalPreprocess.g:2837:1: ( (lv_qExpr_3_0= ruleExpression ) )
                    // InternalPreprocess.g:2838:1: (lv_qExpr_3_0= ruleExpression )
                    {
                    // InternalPreprocess.g:2838:1: (lv_qExpr_3_0= ruleExpression )
                    // InternalPreprocess.g:2839:3: lv_qExpr_3_0= ruleExpression
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
                              		"at.jku.weiner.c.common.Common.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_SKW_COLON_4=(Token)match(input,RULE_SKW_COLON,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_COLON_4, grammarAccess.getConditionalExpressionAccess().getSKW_COLONTerminalRuleCall_2_2()); 
                          
                    }
                    // InternalPreprocess.g:2865:1: ( (lv_cExpr_5_0= ruleConditionalExpression ) )
                    // InternalPreprocess.g:2866:1: (lv_cExpr_5_0= ruleConditionalExpression )
                    {
                    // InternalPreprocess.g:2866:1: (lv_cExpr_5_0= ruleConditionalExpression )
                    // InternalPreprocess.g:2867:3: lv_cExpr_5_0= ruleConditionalExpression
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
                              		"at.jku.weiner.c.common.Common.ConditionalExpression");
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
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:2897:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalPreprocess.g:2898:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalPreprocess.g:2899:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
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
    // InternalPreprocess.g:2906:1: ruleLogicalOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_OROR_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2912:7: ( ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalPreprocess.g:2914:1: ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalPreprocess.g:2914:1: ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalPreprocess.g:2915:1: () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )*
            {
            // InternalPreprocess.g:2915:1: ()
            // InternalPreprocess.g:2916:2: 
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

            // InternalPreprocess.g:2927:1: ( (lv_expr_1_0= ruleLogicalAndExpression ) )
            // InternalPreprocess.g:2928:1: (lv_expr_1_0= ruleLogicalAndExpression )
            {
            // InternalPreprocess.g:2928:1: (lv_expr_1_0= ruleLogicalAndExpression )
            // InternalPreprocess.g:2929:3: lv_expr_1_0= ruleLogicalAndExpression
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
                      		"at.jku.weiner.c.common.Common.LogicalAndExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:2948:1: (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_SKW_OROR) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalPreprocess.g:2949:1: this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) )
            	    {
            	    this_SKW_OROR_2=(Token)match(input,RULE_SKW_OROR,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_OROR_2, grammarAccess.getLogicalOrExpressionAccess().getSKW_ORORTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:2956:1: ( (lv_expr_3_0= ruleLogicalAndExpression ) )
            	    // InternalPreprocess.g:2957:1: (lv_expr_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalPreprocess.g:2957:1: (lv_expr_3_0= ruleLogicalAndExpression )
            	    // InternalPreprocess.g:2958:3: lv_expr_3_0= ruleLogicalAndExpression
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
            	              		"at.jku.weiner.c.common.Common.LogicalAndExpression");
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
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:2988:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalPreprocess.g:2989:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalPreprocess.g:2990:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
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
    // InternalPreprocess.g:2997:1: ruleLogicalAndExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_ANDAND_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3003:7: ( ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* ) )
            // InternalPreprocess.g:3005:1: ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* )
            {
            // InternalPreprocess.g:3005:1: ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* )
            // InternalPreprocess.g:3006:1: () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )*
            {
            // InternalPreprocess.g:3006:1: ()
            // InternalPreprocess.g:3007:2: 
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

            // InternalPreprocess.g:3018:1: ( (lv_expr_1_0= ruleInclusiveOrExpression ) )
            // InternalPreprocess.g:3019:1: (lv_expr_1_0= ruleInclusiveOrExpression )
            {
            // InternalPreprocess.g:3019:1: (lv_expr_1_0= ruleInclusiveOrExpression )
            // InternalPreprocess.g:3020:3: lv_expr_1_0= ruleInclusiveOrExpression
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
                      		"at.jku.weiner.c.common.Common.InclusiveOrExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:3039:1: (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_SKW_ANDAND) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalPreprocess.g:3040:1: this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) )
            	    {
            	    this_SKW_ANDAND_2=(Token)match(input,RULE_SKW_ANDAND,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_ANDAND_2, grammarAccess.getLogicalAndExpressionAccess().getSKW_ANDANDTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3047:1: ( (lv_expr_3_0= ruleInclusiveOrExpression ) )
            	    // InternalPreprocess.g:3048:1: (lv_expr_3_0= ruleInclusiveOrExpression )
            	    {
            	    // InternalPreprocess.g:3048:1: (lv_expr_3_0= ruleInclusiveOrExpression )
            	    // InternalPreprocess.g:3049:3: lv_expr_3_0= ruleInclusiveOrExpression
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
            	              		"at.jku.weiner.c.common.Common.InclusiveOrExpression");
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
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:3079:1: entryRuleInclusiveOrExpression returns [EObject current=null] : iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF ;
    public final EObject entryRuleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclusiveOrExpression = null;


        try {
            // InternalPreprocess.g:3080:2: (iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF )
            // InternalPreprocess.g:3081:2: iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF
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
    // InternalPreprocess.g:3088:1: ruleInclusiveOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* ) ;
    public final EObject ruleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_OR_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3094:7: ( ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* ) )
            // InternalPreprocess.g:3096:1: ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* )
            {
            // InternalPreprocess.g:3096:1: ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* )
            // InternalPreprocess.g:3097:1: () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )*
            {
            // InternalPreprocess.g:3097:1: ()
            // InternalPreprocess.g:3098:2: 
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

            // InternalPreprocess.g:3109:1: ( (lv_expr_1_0= ruleExclusiveOrExpression ) )
            // InternalPreprocess.g:3110:1: (lv_expr_1_0= ruleExclusiveOrExpression )
            {
            // InternalPreprocess.g:3110:1: (lv_expr_1_0= ruleExclusiveOrExpression )
            // InternalPreprocess.g:3111:3: lv_expr_1_0= ruleExclusiveOrExpression
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
                      		"at.jku.weiner.c.common.Common.ExclusiveOrExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:3130:1: (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_SKW_OR) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalPreprocess.g:3131:1: this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) )
            	    {
            	    this_SKW_OR_2=(Token)match(input,RULE_SKW_OR,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_OR_2, grammarAccess.getInclusiveOrExpressionAccess().getSKW_ORTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3138:1: ( (lv_expr_3_0= ruleExclusiveOrExpression ) )
            	    // InternalPreprocess.g:3139:1: (lv_expr_3_0= ruleExclusiveOrExpression )
            	    {
            	    // InternalPreprocess.g:3139:1: (lv_expr_3_0= ruleExclusiveOrExpression )
            	    // InternalPreprocess.g:3140:3: lv_expr_3_0= ruleExclusiveOrExpression
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
            	              		"at.jku.weiner.c.common.Common.ExclusiveOrExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:3170:1: entryRuleExclusiveOrExpression returns [EObject current=null] : iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF ;
    public final EObject entryRuleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusiveOrExpression = null;


        try {
            // InternalPreprocess.g:3171:2: (iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF )
            // InternalPreprocess.g:3172:2: iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF
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
    // InternalPreprocess.g:3179:1: ruleExclusiveOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_CARET_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3185:7: ( ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* ) )
            // InternalPreprocess.g:3187:1: ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* )
            {
            // InternalPreprocess.g:3187:1: ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* )
            // InternalPreprocess.g:3188:1: () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )*
            {
            // InternalPreprocess.g:3188:1: ()
            // InternalPreprocess.g:3189:2: 
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

            // InternalPreprocess.g:3200:1: ( (lv_expr_1_0= ruleAndExpression ) )
            // InternalPreprocess.g:3201:1: (lv_expr_1_0= ruleAndExpression )
            {
            // InternalPreprocess.g:3201:1: (lv_expr_1_0= ruleAndExpression )
            // InternalPreprocess.g:3202:3: lv_expr_1_0= ruleAndExpression
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
                      		"at.jku.weiner.c.common.Common.AndExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:3221:1: (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_SKW_CARET) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalPreprocess.g:3222:1: this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) )
            	    {
            	    this_SKW_CARET_2=(Token)match(input,RULE_SKW_CARET,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_CARET_2, grammarAccess.getExclusiveOrExpressionAccess().getSKW_CARETTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3229:1: ( (lv_expr_3_0= ruleAndExpression ) )
            	    // InternalPreprocess.g:3230:1: (lv_expr_3_0= ruleAndExpression )
            	    {
            	    // InternalPreprocess.g:3230:1: (lv_expr_3_0= ruleAndExpression )
            	    // InternalPreprocess.g:3231:3: lv_expr_3_0= ruleAndExpression
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
            	              		"at.jku.weiner.c.common.Common.AndExpression");
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
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:3261:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalPreprocess.g:3262:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalPreprocess.g:3263:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalPreprocess.g:3270:1: ruleAndExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_AND_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3276:7: ( ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalPreprocess.g:3278:1: ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalPreprocess.g:3278:1: ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* )
            // InternalPreprocess.g:3279:1: () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )*
            {
            // InternalPreprocess.g:3279:1: ()
            // InternalPreprocess.g:3280:2: 
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

            // InternalPreprocess.g:3291:1: ( (lv_expr_1_0= ruleEqualityExpression ) )
            // InternalPreprocess.g:3292:1: (lv_expr_1_0= ruleEqualityExpression )
            {
            // InternalPreprocess.g:3292:1: (lv_expr_1_0= ruleEqualityExpression )
            // InternalPreprocess.g:3293:3: lv_expr_1_0= ruleEqualityExpression
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
                      		"at.jku.weiner.c.common.Common.EqualityExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:3312:1: (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_SKW_AND) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalPreprocess.g:3313:1: this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) )
            	    {
            	    this_SKW_AND_2=(Token)match(input,RULE_SKW_AND,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_AND_2, grammarAccess.getAndExpressionAccess().getSKW_ANDTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3320:1: ( (lv_expr_3_0= ruleEqualityExpression ) )
            	    // InternalPreprocess.g:3321:1: (lv_expr_3_0= ruleEqualityExpression )
            	    {
            	    // InternalPreprocess.g:3321:1: (lv_expr_3_0= ruleEqualityExpression )
            	    // InternalPreprocess.g:3322:3: lv_expr_3_0= ruleEqualityExpression
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
            	              		"at.jku.weiner.c.common.Common.EqualityExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:3352:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalPreprocess.g:3353:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalPreprocess.g:3354:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalPreprocess.g:3361:1: ruleEqualityExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3367:7: ( ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* ) )
            // InternalPreprocess.g:3369:1: ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* )
            {
            // InternalPreprocess.g:3369:1: ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* )
            // InternalPreprocess.g:3370:1: () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )*
            {
            // InternalPreprocess.g:3370:1: ()
            // InternalPreprocess.g:3371:2: 
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

            // InternalPreprocess.g:3382:1: ( (lv_expr_1_0= ruleRelationalExpression ) )
            // InternalPreprocess.g:3383:1: (lv_expr_1_0= ruleRelationalExpression )
            {
            // InternalPreprocess.g:3383:1: (lv_expr_1_0= ruleRelationalExpression )
            // InternalPreprocess.g:3384:3: lv_expr_1_0= ruleRelationalExpression
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
                      		"at.jku.weiner.c.common.Common.RelationalExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:3403:1: ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=RULE_SKW_EQUAL && LA50_0<=RULE_SKW_NOTEQUAL)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalPreprocess.g:3404:1: ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) )
            	    {
            	    // InternalPreprocess.g:3404:1: ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) )
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);

            	    if ( (LA49_0==RULE_SKW_EQUAL) ) {
            	        alt49=1;
            	    }
            	    else if ( (LA49_0==RULE_SKW_NOTEQUAL) ) {
            	        alt49=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 49, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt49) {
            	        case 1 :
            	            // InternalPreprocess.g:3405:1: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
            	            {
            	            // InternalPreprocess.g:3405:1: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
            	            // InternalPreprocess.g:3406:1: (lv_op_2_0= RULE_SKW_EQUAL )
            	            {
            	            // InternalPreprocess.g:3406:1: (lv_op_2_0= RULE_SKW_EQUAL )
            	            // InternalPreprocess.g:3407:3: lv_op_2_0= RULE_SKW_EQUAL
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_EQUAL,FOLLOW_22); if (state.failed) return current;
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
            	                      		"at.jku.weiner.c.common.Common.SKW_EQUAL");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalPreprocess.g:3427:1: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
            	            {
            	            // InternalPreprocess.g:3427:1: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
            	            // InternalPreprocess.g:3428:1: (lv_op_3_0= RULE_SKW_NOTEQUAL )
            	            {
            	            // InternalPreprocess.g:3428:1: (lv_op_3_0= RULE_SKW_NOTEQUAL )
            	            // InternalPreprocess.g:3429:3: lv_op_3_0= RULE_SKW_NOTEQUAL
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_NOTEQUAL,FOLLOW_22); if (state.failed) return current;
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
            	                      		"at.jku.weiner.c.common.Common.SKW_NOTEQUAL");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalPreprocess.g:3450:1: ( (lv_expr_4_0= ruleRelationalExpression ) )
            	    // InternalPreprocess.g:3451:1: (lv_expr_4_0= ruleRelationalExpression )
            	    {
            	    // InternalPreprocess.g:3451:1: (lv_expr_4_0= ruleRelationalExpression )
            	    // InternalPreprocess.g:3452:3: lv_expr_4_0= ruleRelationalExpression
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
            	              		"at.jku.weiner.c.common.Common.RelationalExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:3482:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalPreprocess.g:3483:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalPreprocess.g:3484:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalPreprocess.g:3491:1: ruleRelationalExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        Token lv_op_4_0=null;
        Token lv_op_5_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_6_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3497:7: ( ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* ) )
            // InternalPreprocess.g:3499:1: ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* )
            {
            // InternalPreprocess.g:3499:1: ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* )
            // InternalPreprocess.g:3500:1: () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )*
            {
            // InternalPreprocess.g:3500:1: ()
            // InternalPreprocess.g:3501:2: 
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

            // InternalPreprocess.g:3512:1: ( (lv_expr_1_0= ruleShiftExpression ) )
            // InternalPreprocess.g:3513:1: (lv_expr_1_0= ruleShiftExpression )
            {
            // InternalPreprocess.g:3513:1: (lv_expr_1_0= ruleShiftExpression )
            // InternalPreprocess.g:3514:3: lv_expr_1_0= ruleShiftExpression
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
                      		"at.jku.weiner.c.common.Common.ShiftExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:3533:1: ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( ((LA52_0>=RULE_SKW_LESS && LA52_0<=RULE_SKW_GREATEREQUAL)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalPreprocess.g:3534:1: ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) )
            	    {
            	    // InternalPreprocess.g:3534:1: ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) )
            	    int alt51=4;
            	    switch ( input.LA(1) ) {
            	    case RULE_SKW_LESS:
            	        {
            	        alt51=1;
            	        }
            	        break;
            	    case RULE_SKW_GREATER:
            	        {
            	        alt51=2;
            	        }
            	        break;
            	    case RULE_SKW_LESSEQUAL:
            	        {
            	        alt51=3;
            	        }
            	        break;
            	    case RULE_SKW_GREATEREQUAL:
            	        {
            	        alt51=4;
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
            	            // InternalPreprocess.g:3535:1: ( (lv_op_2_0= RULE_SKW_LESS ) )
            	            {
            	            // InternalPreprocess.g:3535:1: ( (lv_op_2_0= RULE_SKW_LESS ) )
            	            // InternalPreprocess.g:3536:1: (lv_op_2_0= RULE_SKW_LESS )
            	            {
            	            // InternalPreprocess.g:3536:1: (lv_op_2_0= RULE_SKW_LESS )
            	            // InternalPreprocess.g:3537:3: lv_op_2_0= RULE_SKW_LESS
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_LESS,FOLLOW_22); if (state.failed) return current;
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
            	                      		"at.jku.weiner.c.common.Common.SKW_LESS");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalPreprocess.g:3557:1: ( (lv_op_3_0= RULE_SKW_GREATER ) )
            	            {
            	            // InternalPreprocess.g:3557:1: ( (lv_op_3_0= RULE_SKW_GREATER ) )
            	            // InternalPreprocess.g:3558:1: (lv_op_3_0= RULE_SKW_GREATER )
            	            {
            	            // InternalPreprocess.g:3558:1: (lv_op_3_0= RULE_SKW_GREATER )
            	            // InternalPreprocess.g:3559:3: lv_op_3_0= RULE_SKW_GREATER
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_GREATER,FOLLOW_22); if (state.failed) return current;
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
            	                      		"at.jku.weiner.c.common.Common.SKW_GREATER");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalPreprocess.g:3579:1: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
            	            {
            	            // InternalPreprocess.g:3579:1: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
            	            // InternalPreprocess.g:3580:1: (lv_op_4_0= RULE_SKW_LESSEQUAL )
            	            {
            	            // InternalPreprocess.g:3580:1: (lv_op_4_0= RULE_SKW_LESSEQUAL )
            	            // InternalPreprocess.g:3581:3: lv_op_4_0= RULE_SKW_LESSEQUAL
            	            {
            	            lv_op_4_0=(Token)match(input,RULE_SKW_LESSEQUAL,FOLLOW_22); if (state.failed) return current;
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
            	                      		"at.jku.weiner.c.common.Common.SKW_LESSEQUAL");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // InternalPreprocess.g:3601:1: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
            	            {
            	            // InternalPreprocess.g:3601:1: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
            	            // InternalPreprocess.g:3602:1: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
            	            {
            	            // InternalPreprocess.g:3602:1: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
            	            // InternalPreprocess.g:3603:3: lv_op_5_0= RULE_SKW_GREATEREQUAL
            	            {
            	            lv_op_5_0=(Token)match(input,RULE_SKW_GREATEREQUAL,FOLLOW_22); if (state.failed) return current;
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
            	                      		"at.jku.weiner.c.common.Common.SKW_GREATEREQUAL");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalPreprocess.g:3624:1: ( (lv_expr_6_0= ruleShiftExpression ) )
            	    // InternalPreprocess.g:3625:1: (lv_expr_6_0= ruleShiftExpression )
            	    {
            	    // InternalPreprocess.g:3625:1: (lv_expr_6_0= ruleShiftExpression )
            	    // InternalPreprocess.g:3626:3: lv_expr_6_0= ruleShiftExpression
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
            	              		"at.jku.weiner.c.common.Common.ShiftExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:3656:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalPreprocess.g:3657:2: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalPreprocess.g:3658:2: iv_ruleShiftExpression= ruleShiftExpression EOF
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
    // InternalPreprocess.g:3665:1: ruleShiftExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3671:7: ( ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* ) )
            // InternalPreprocess.g:3673:1: ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalPreprocess.g:3673:1: ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* )
            // InternalPreprocess.g:3674:1: () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )*
            {
            // InternalPreprocess.g:3674:1: ()
            // InternalPreprocess.g:3675:2: 
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

            // InternalPreprocess.g:3686:1: ( (lv_expr_1_0= ruleAdditiveExpression ) )
            // InternalPreprocess.g:3687:1: (lv_expr_1_0= ruleAdditiveExpression )
            {
            // InternalPreprocess.g:3687:1: (lv_expr_1_0= ruleAdditiveExpression )
            // InternalPreprocess.g:3688:3: lv_expr_1_0= ruleAdditiveExpression
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
                      		"at.jku.weiner.c.common.Common.AdditiveExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:3707:1: ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( ((LA54_0>=RULE_SKW_LEFTSHIFT && LA54_0<=RULE_SKW_RIGHTSHIFT)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalPreprocess.g:3708:1: ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalPreprocess.g:3708:1: ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) )
            	    int alt53=2;
            	    int LA53_0 = input.LA(1);

            	    if ( (LA53_0==RULE_SKW_LEFTSHIFT) ) {
            	        alt53=1;
            	    }
            	    else if ( (LA53_0==RULE_SKW_RIGHTSHIFT) ) {
            	        alt53=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 53, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt53) {
            	        case 1 :
            	            // InternalPreprocess.g:3709:1: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
            	            {
            	            // InternalPreprocess.g:3709:1: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
            	            // InternalPreprocess.g:3710:1: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
            	            {
            	            // InternalPreprocess.g:3710:1: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
            	            // InternalPreprocess.g:3711:3: lv_op_2_0= RULE_SKW_LEFTSHIFT
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_LEFTSHIFT,FOLLOW_22); if (state.failed) return current;
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
            	                      		"at.jku.weiner.c.common.Common.SKW_LEFTSHIFT");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalPreprocess.g:3731:1: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
            	            {
            	            // InternalPreprocess.g:3731:1: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
            	            // InternalPreprocess.g:3732:1: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
            	            {
            	            // InternalPreprocess.g:3732:1: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
            	            // InternalPreprocess.g:3733:3: lv_op_3_0= RULE_SKW_RIGHTSHIFT
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_RIGHTSHIFT,FOLLOW_22); if (state.failed) return current;
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
            	                      		"at.jku.weiner.c.common.Common.SKW_RIGHTSHIFT");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalPreprocess.g:3754:1: ( (lv_expr_4_0= ruleAdditiveExpression ) )
            	    // InternalPreprocess.g:3755:1: (lv_expr_4_0= ruleAdditiveExpression )
            	    {
            	    // InternalPreprocess.g:3755:1: (lv_expr_4_0= ruleAdditiveExpression )
            	    // InternalPreprocess.g:3756:3: lv_expr_4_0= ruleAdditiveExpression
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
            	              		"at.jku.weiner.c.common.Common.AdditiveExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:3786:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalPreprocess.g:3787:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalPreprocess.g:3788:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalPreprocess.g:3795:1: ruleAdditiveExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3801:7: ( ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalPreprocess.g:3803:1: ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalPreprocess.g:3803:1: ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* )
            // InternalPreprocess.g:3804:1: () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )*
            {
            // InternalPreprocess.g:3804:1: ()
            // InternalPreprocess.g:3805:2: 
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

            // InternalPreprocess.g:3816:1: ( (lv_expr_1_0= ruleMultiplicativeExpression ) )
            // InternalPreprocess.g:3817:1: (lv_expr_1_0= ruleMultiplicativeExpression )
            {
            // InternalPreprocess.g:3817:1: (lv_expr_1_0= ruleMultiplicativeExpression )
            // InternalPreprocess.g:3818:3: lv_expr_1_0= ruleMultiplicativeExpression
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
                      		"at.jku.weiner.c.common.Common.MultiplicativeExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:3837:1: ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( ((LA56_0>=RULE_SKW_PLUS && LA56_0<=RULE_SKW_MINUS)) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalPreprocess.g:3838:1: ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalPreprocess.g:3838:1: ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) )
            	    int alt55=2;
            	    int LA55_0 = input.LA(1);

            	    if ( (LA55_0==RULE_SKW_PLUS) ) {
            	        alt55=1;
            	    }
            	    else if ( (LA55_0==RULE_SKW_MINUS) ) {
            	        alt55=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 55, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt55) {
            	        case 1 :
            	            // InternalPreprocess.g:3839:1: ( (lv_op_2_0= RULE_SKW_PLUS ) )
            	            {
            	            // InternalPreprocess.g:3839:1: ( (lv_op_2_0= RULE_SKW_PLUS ) )
            	            // InternalPreprocess.g:3840:1: (lv_op_2_0= RULE_SKW_PLUS )
            	            {
            	            // InternalPreprocess.g:3840:1: (lv_op_2_0= RULE_SKW_PLUS )
            	            // InternalPreprocess.g:3841:3: lv_op_2_0= RULE_SKW_PLUS
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_PLUS,FOLLOW_22); if (state.failed) return current;
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
            	                      		"at.jku.weiner.c.common.Common.SKW_PLUS");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalPreprocess.g:3861:1: ( (lv_op_3_0= RULE_SKW_MINUS ) )
            	            {
            	            // InternalPreprocess.g:3861:1: ( (lv_op_3_0= RULE_SKW_MINUS ) )
            	            // InternalPreprocess.g:3862:1: (lv_op_3_0= RULE_SKW_MINUS )
            	            {
            	            // InternalPreprocess.g:3862:1: (lv_op_3_0= RULE_SKW_MINUS )
            	            // InternalPreprocess.g:3863:3: lv_op_3_0= RULE_SKW_MINUS
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_22); if (state.failed) return current;
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
            	                      		"at.jku.weiner.c.common.Common.SKW_MINUS");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalPreprocess.g:3884:1: ( (lv_expr_4_0= ruleMultiplicativeExpression ) )
            	    // InternalPreprocess.g:3885:1: (lv_expr_4_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalPreprocess.g:3885:1: (lv_expr_4_0= ruleMultiplicativeExpression )
            	    // InternalPreprocess.g:3886:3: lv_expr_4_0= ruleMultiplicativeExpression
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
            	              		"at.jku.weiner.c.common.Common.MultiplicativeExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:3916:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalPreprocess.g:3917:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalPreprocess.g:3918:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalPreprocess.g:3925:1: ruleMultiplicativeExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        Token lv_op_4_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_5_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3931:7: ( ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* ) )
            // InternalPreprocess.g:3933:1: ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* )
            {
            // InternalPreprocess.g:3933:1: ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* )
            // InternalPreprocess.g:3934:1: () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )*
            {
            // InternalPreprocess.g:3934:1: ()
            // InternalPreprocess.g:3935:2: 
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

            // InternalPreprocess.g:3946:1: ( (lv_expr_1_0= ruleCastExpression ) )
            // InternalPreprocess.g:3947:1: (lv_expr_1_0= ruleCastExpression )
            {
            // InternalPreprocess.g:3947:1: (lv_expr_1_0= ruleCastExpression )
            // InternalPreprocess.g:3948:3: lv_expr_1_0= ruleCastExpression
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
                      		"at.jku.weiner.c.common.Common.CastExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:3967:1: ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( ((LA58_0>=RULE_SKW_STAR && LA58_0<=RULE_SKW_MOD)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalPreprocess.g:3968:1: ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) )
            	    {
            	    // InternalPreprocess.g:3968:1: ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) )
            	    int alt57=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_SKW_STAR:
            	        {
            	        alt57=1;
            	        }
            	        break;
            	    case RULE_SKW_DIV:
            	        {
            	        alt57=2;
            	        }
            	        break;
            	    case RULE_SKW_MOD:
            	        {
            	        alt57=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 57, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt57) {
            	        case 1 :
            	            // InternalPreprocess.g:3969:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
            	            {
            	            // InternalPreprocess.g:3969:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
            	            // InternalPreprocess.g:3970:1: (lv_op_2_0= RULE_SKW_STAR )
            	            {
            	            // InternalPreprocess.g:3970:1: (lv_op_2_0= RULE_SKW_STAR )
            	            // InternalPreprocess.g:3971:3: lv_op_2_0= RULE_SKW_STAR
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_STAR,FOLLOW_22); if (state.failed) return current;
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
            	                      		"at.jku.weiner.c.common.Common.SKW_STAR");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalPreprocess.g:3991:1: ( (lv_op_3_0= RULE_SKW_DIV ) )
            	            {
            	            // InternalPreprocess.g:3991:1: ( (lv_op_3_0= RULE_SKW_DIV ) )
            	            // InternalPreprocess.g:3992:1: (lv_op_3_0= RULE_SKW_DIV )
            	            {
            	            // InternalPreprocess.g:3992:1: (lv_op_3_0= RULE_SKW_DIV )
            	            // InternalPreprocess.g:3993:3: lv_op_3_0= RULE_SKW_DIV
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_DIV,FOLLOW_22); if (state.failed) return current;
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
            	                      		"at.jku.weiner.c.common.Common.SKW_DIV");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalPreprocess.g:4013:1: ( (lv_op_4_0= RULE_SKW_MOD ) )
            	            {
            	            // InternalPreprocess.g:4013:1: ( (lv_op_4_0= RULE_SKW_MOD ) )
            	            // InternalPreprocess.g:4014:1: (lv_op_4_0= RULE_SKW_MOD )
            	            {
            	            // InternalPreprocess.g:4014:1: (lv_op_4_0= RULE_SKW_MOD )
            	            // InternalPreprocess.g:4015:3: lv_op_4_0= RULE_SKW_MOD
            	            {
            	            lv_op_4_0=(Token)match(input,RULE_SKW_MOD,FOLLOW_22); if (state.failed) return current;
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
            	                      		"at.jku.weiner.c.common.Common.SKW_MOD");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalPreprocess.g:4036:1: ( (lv_expr_5_0= ruleCastExpression ) )
            	    // InternalPreprocess.g:4037:1: (lv_expr_5_0= ruleCastExpression )
            	    {
            	    // InternalPreprocess.g:4037:1: (lv_expr_5_0= ruleCastExpression )
            	    // InternalPreprocess.g:4038:3: lv_expr_5_0= ruleCastExpression
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
            	              		"at.jku.weiner.c.common.Common.CastExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:4068:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalPreprocess.g:4069:2: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalPreprocess.g:4070:2: iv_ruleCastExpression= ruleCastExpression EOF
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
    // InternalPreprocess.g:4077:1: ruleCastExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4083:7: ( ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // InternalPreprocess.g:4085:1: ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // InternalPreprocess.g:4085:1: ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // InternalPreprocess.g:4086:1: () ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // InternalPreprocess.g:4086:1: ()
            // InternalPreprocess.g:4087:2: 
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

            // InternalPreprocess.g:4098:1: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // InternalPreprocess.g:4099:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // InternalPreprocess.g:4099:1: (lv_expr_1_0= ruleUnaryExpression )
            // InternalPreprocess.g:4100:3: lv_expr_1_0= ruleUnaryExpression
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
                      		"at.jku.weiner.c.common.Common.UnaryExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:4128:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalPreprocess.g:4129:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalPreprocess.g:4130:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalPreprocess.g:4137:1: ruleUnaryExpression returns [EObject current=null] : ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;

        EObject lv_op_2_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4143:7: ( ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) ) )
            // InternalPreprocess.g:4145:1: ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) )
            {
            // InternalPreprocess.g:4145:1: ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) )
            // InternalPreprocess.g:4146:1: () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
            {
            // InternalPreprocess.g:4146:1: ()
            // InternalPreprocess.g:4147:2: 
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

            // InternalPreprocess.g:4158:1: ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=RULE_ID && LA59_0<=RULE_SKW_LEFTPAREN)||LA59_0==RULE_DEFINED||(LA59_0>=RULE_HEX_LITERAL && LA59_0<=RULE_BIN_LITERAL)) ) {
                alt59=1;
            }
            else if ( (LA59_0==RULE_SKW_AND||(LA59_0>=RULE_SKW_PLUS && LA59_0<=RULE_SKW_STAR)||(LA59_0>=RULE_SKW_TILDE && LA59_0<=RULE_SKW_NOT)) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalPreprocess.g:4159:1: ( (lv_expr_1_0= rulePostfixExpression ) )
                    {
                    // InternalPreprocess.g:4159:1: ( (lv_expr_1_0= rulePostfixExpression ) )
                    // InternalPreprocess.g:4160:1: (lv_expr_1_0= rulePostfixExpression )
                    {
                    // InternalPreprocess.g:4160:1: (lv_expr_1_0= rulePostfixExpression )
                    // InternalPreprocess.g:4161:3: lv_expr_1_0= rulePostfixExpression
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
                              		"at.jku.weiner.c.common.Common.PostfixExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:4181:1: ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
                    {
                    // InternalPreprocess.g:4181:1: ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
                    // InternalPreprocess.g:4182:1: ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) )
                    {
                    // InternalPreprocess.g:4182:1: ( (lv_op_2_0= ruleUnaryOperator ) )
                    // InternalPreprocess.g:4183:1: (lv_op_2_0= ruleUnaryOperator )
                    {
                    // InternalPreprocess.g:4183:1: (lv_op_2_0= ruleUnaryOperator )
                    // InternalPreprocess.g:4184:3: lv_op_2_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_1_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_22);
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
                              		"at.jku.weiner.c.common.Common.UnaryOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalPreprocess.g:4203:1: ( (lv_expr_3_0= ruleCastExpression ) )
                    // InternalPreprocess.g:4204:1: (lv_expr_3_0= ruleCastExpression )
                    {
                    // InternalPreprocess.g:4204:1: (lv_expr_3_0= ruleCastExpression )
                    // InternalPreprocess.g:4205:3: lv_expr_3_0= ruleCastExpression
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
                              		"at.jku.weiner.c.common.Common.CastExpression");
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
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:4237:1: entryRuleUnaryOperator returns [EObject current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final EObject entryRuleUnaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperator = null;


        try {
            // InternalPreprocess.g:4238:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalPreprocess.g:4239:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
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
    // InternalPreprocess.g:4246:1: ruleUnaryOperator returns [EObject current=null] : ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) ) ;
    public final EObject ruleUnaryOperator() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_0=null;
        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        Token lv_op_4_0=null;
        Token lv_op_5_0=null;
        Token lv_op_6_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4252:7: ( ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) ) )
            // InternalPreprocess.g:4254:1: ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) )
            {
            // InternalPreprocess.g:4254:1: ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) )
            int alt60=6;
            switch ( input.LA(1) ) {
            case RULE_SKW_AND:
                {
                alt60=1;
                }
                break;
            case RULE_SKW_STAR:
                {
                alt60=2;
                }
                break;
            case RULE_SKW_PLUS:
                {
                alt60=3;
                }
                break;
            case RULE_SKW_MINUS:
                {
                alt60=4;
                }
                break;
            case RULE_SKW_TILDE:
                {
                alt60=5;
                }
                break;
            case RULE_SKW_NOT:
                {
                alt60=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // InternalPreprocess.g:4255:1: ( () ( (lv_op_1_0= RULE_SKW_AND ) ) )
                    {
                    // InternalPreprocess.g:4255:1: ( () ( (lv_op_1_0= RULE_SKW_AND ) ) )
                    // InternalPreprocess.g:4256:1: () ( (lv_op_1_0= RULE_SKW_AND ) )
                    {
                    // InternalPreprocess.g:4256:1: ()
                    // InternalPreprocess.g:4257:2: 
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

                    // InternalPreprocess.g:4268:1: ( (lv_op_1_0= RULE_SKW_AND ) )
                    // InternalPreprocess.g:4269:1: (lv_op_1_0= RULE_SKW_AND )
                    {
                    // InternalPreprocess.g:4269:1: (lv_op_1_0= RULE_SKW_AND )
                    // InternalPreprocess.g:4270:3: lv_op_1_0= RULE_SKW_AND
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
                              		"at.jku.weiner.c.common.Common.SKW_AND");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:4292:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
                    {
                    // InternalPreprocess.g:4292:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
                    // InternalPreprocess.g:4293:1: (lv_op_2_0= RULE_SKW_STAR )
                    {
                    // InternalPreprocess.g:4293:1: (lv_op_2_0= RULE_SKW_STAR )
                    // InternalPreprocess.g:4294:3: lv_op_2_0= RULE_SKW_STAR
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
                              		"at.jku.weiner.c.common.Common.SKW_STAR");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalPreprocess.g:4314:1: ( (lv_op_3_0= RULE_SKW_PLUS ) )
                    {
                    // InternalPreprocess.g:4314:1: ( (lv_op_3_0= RULE_SKW_PLUS ) )
                    // InternalPreprocess.g:4315:1: (lv_op_3_0= RULE_SKW_PLUS )
                    {
                    // InternalPreprocess.g:4315:1: (lv_op_3_0= RULE_SKW_PLUS )
                    // InternalPreprocess.g:4316:3: lv_op_3_0= RULE_SKW_PLUS
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
                              		"at.jku.weiner.c.common.Common.SKW_PLUS");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalPreprocess.g:4336:1: ( (lv_op_4_0= RULE_SKW_MINUS ) )
                    {
                    // InternalPreprocess.g:4336:1: ( (lv_op_4_0= RULE_SKW_MINUS ) )
                    // InternalPreprocess.g:4337:1: (lv_op_4_0= RULE_SKW_MINUS )
                    {
                    // InternalPreprocess.g:4337:1: (lv_op_4_0= RULE_SKW_MINUS )
                    // InternalPreprocess.g:4338:3: lv_op_4_0= RULE_SKW_MINUS
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
                              		"at.jku.weiner.c.common.Common.SKW_MINUS");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalPreprocess.g:4358:1: ( (lv_op_5_0= RULE_SKW_TILDE ) )
                    {
                    // InternalPreprocess.g:4358:1: ( (lv_op_5_0= RULE_SKW_TILDE ) )
                    // InternalPreprocess.g:4359:1: (lv_op_5_0= RULE_SKW_TILDE )
                    {
                    // InternalPreprocess.g:4359:1: (lv_op_5_0= RULE_SKW_TILDE )
                    // InternalPreprocess.g:4360:3: lv_op_5_0= RULE_SKW_TILDE
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
                              		"at.jku.weiner.c.common.Common.SKW_TILDE");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalPreprocess.g:4380:1: ( (lv_op_6_0= RULE_SKW_NOT ) )
                    {
                    // InternalPreprocess.g:4380:1: ( (lv_op_6_0= RULE_SKW_NOT ) )
                    // InternalPreprocess.g:4381:1: (lv_op_6_0= RULE_SKW_NOT )
                    {
                    // InternalPreprocess.g:4381:1: (lv_op_6_0= RULE_SKW_NOT )
                    // InternalPreprocess.g:4382:3: lv_op_6_0= RULE_SKW_NOT
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
                              		"at.jku.weiner.c.common.Common.SKW_NOT");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // InternalPreprocess.g:4410:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalPreprocess.g:4411:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalPreprocess.g:4412:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalPreprocess.g:4419:1: rulePostfixExpression returns [EObject current=null] : ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;

        EObject lv_suffix_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4425:7: ( ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) ) )
            // InternalPreprocess.g:4427:1: ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) )
            {
            // InternalPreprocess.g:4427:1: ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) )
            // InternalPreprocess.g:4428:1: () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* )
            {
            // InternalPreprocess.g:4428:1: ()
            // InternalPreprocess.g:4429:2: 
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

            // InternalPreprocess.g:4440:1: ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* )
            // InternalPreprocess.g:4441:1: ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )*
            {
            // InternalPreprocess.g:4441:1: ( (lv_expr_1_0= rulePrimaryExpression ) )
            // InternalPreprocess.g:4442:1: (lv_expr_1_0= rulePrimaryExpression )
            {
            // InternalPreprocess.g:4442:1: (lv_expr_1_0= rulePrimaryExpression )
            // InternalPreprocess.g:4443:3: lv_expr_1_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getExprPrimaryExpressionParserRuleCall_1_0_0()); 
              	    
            }
            pushFollow(FOLLOW_35);
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

            // InternalPreprocess.g:4462:1: ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==RULE_SKW_LEFTPAREN) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalPreprocess.g:4463:1: (lv_suffix_2_0= rulePostfixExpressionSuffixArgument )
            	    {
            	    // InternalPreprocess.g:4463:1: (lv_suffix_2_0= rulePostfixExpressionSuffixArgument )
            	    // InternalPreprocess.g:4464:3: lv_suffix_2_0= rulePostfixExpressionSuffixArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getSuffixPostfixExpressionSuffixArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_suffix_2_0=rulePostfixExpressionSuffixArgument();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"suffix",
            	              		lv_suffix_2_0, 
            	              		"at.jku.weiner.c.common.Common.PostfixExpressionSuffixArgument");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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


    // $ANTLR start "entryRulePostfixExpressionSuffixArgument"
    // InternalPreprocess.g:4494:1: entryRulePostfixExpressionSuffixArgument returns [EObject current=null] : iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF ;
    public final EObject entryRulePostfixExpressionSuffixArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpressionSuffixArgument = null;


        try {
            // InternalPreprocess.g:4495:2: (iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF )
            // InternalPreprocess.g:4496:2: iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionSuffixArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePostfixExpressionSuffixArgument=rulePostfixExpressionSuffixArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpressionSuffixArgument; 
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
    // $ANTLR end "entryRulePostfixExpressionSuffixArgument"


    // $ANTLR start "rulePostfixExpressionSuffixArgument"
    // InternalPreprocess.g:4503:1: rulePostfixExpressionSuffixArgument returns [EObject current=null] : ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN ) ;
    public final EObject rulePostfixExpressionSuffixArgument() throws RecognitionException {
        EObject current = null;

        Token this_SKW_LEFTPAREN_1=null;
        Token this_SKW_RIGHTPAREN_3=null;
        EObject lv_argumentExpressionList_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4509:7: ( ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN ) )
            // InternalPreprocess.g:4511:1: ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN )
            {
            // InternalPreprocess.g:4511:1: ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN )
            // InternalPreprocess.g:4512:1: () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN
            {
            // InternalPreprocess.g:4512:1: ()
            // InternalPreprocess.g:4513:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPostfixExpressionSuffixArgumentAccess().getPostfixExpressionSuffixArgumentAction_0(),
                          current);
                  
            }

            }

            this_SKW_LEFTPAREN_1=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SKW_LEFTPAREN_1, grammarAccess.getPostfixExpressionSuffixArgumentAccess().getSKW_LEFTPARENTerminalRuleCall_1()); 
                  
            }
            // InternalPreprocess.g:4531:1: ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( ((LA62_0>=RULE_ID && LA62_0<=RULE_SKW_LEFTPAREN)||LA62_0==RULE_DEFINED||LA62_0==RULE_SKW_AND||(LA62_0>=RULE_SKW_PLUS && LA62_0<=RULE_SKW_STAR)||(LA62_0>=RULE_SKW_TILDE && LA62_0<=RULE_BIN_LITERAL)) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalPreprocess.g:4532:1: (lv_argumentExpressionList_2_0= ruleArgumentExpressionList )
                    {
                    // InternalPreprocess.g:4532:1: (lv_argumentExpressionList_2_0= ruleArgumentExpressionList )
                    // InternalPreprocess.g:4533:3: lv_argumentExpressionList_2_0= ruleArgumentExpressionList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPostfixExpressionSuffixArgumentAccess().getArgumentExpressionListArgumentExpressionListParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_14);
                    lv_argumentExpressionList_2_0=ruleArgumentExpressionList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPostfixExpressionSuffixArgumentRule());
                      	        }
                             		set(
                             			current, 
                             			"argumentExpressionList",
                              		lv_argumentExpressionList_2_0, 
                              		"at.jku.weiner.c.common.Common.ArgumentExpressionList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            this_SKW_RIGHTPAREN_3=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SKW_RIGHTPAREN_3, grammarAccess.getPostfixExpressionSuffixArgumentAccess().getSKW_RIGHTPARENTerminalRuleCall_3()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // $ANTLR end "rulePostfixExpressionSuffixArgument"


    // $ANTLR start "entryRuleArgumentExpressionList"
    // InternalPreprocess.g:4568:1: entryRuleArgumentExpressionList returns [EObject current=null] : iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF ;
    public final EObject entryRuleArgumentExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentExpressionList = null;


        try {
            // InternalPreprocess.g:4569:2: (iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF )
            // InternalPreprocess.g:4570:2: iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentExpressionListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArgumentExpressionList=ruleArgumentExpressionList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgumentExpressionList; 
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
    // $ANTLR end "entryRuleArgumentExpressionList"


    // $ANTLR start "ruleArgumentExpressionList"
    // InternalPreprocess.g:4577:1: ruleArgumentExpressionList returns [EObject current=null] : ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* ) ;
    public final EObject ruleArgumentExpressionList() throws RecognitionException {
        EObject current = null;

        Token this_SKW_COMMA_1=null;
        EObject lv_expr_0_0 = null;

        EObject lv_expr_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4583:7: ( ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* ) )
            // InternalPreprocess.g:4585:1: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* )
            {
            // InternalPreprocess.g:4585:1: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* )
            // InternalPreprocess.g:4586:1: ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )*
            {
            // InternalPreprocess.g:4586:1: ( (lv_expr_0_0= ruleConditionalExpression ) )
            // InternalPreprocess.g:4587:1: (lv_expr_0_0= ruleConditionalExpression )
            {
            // InternalPreprocess.g:4587:1: (lv_expr_0_0= ruleConditionalExpression )
            // InternalPreprocess.g:4588:3: lv_expr_0_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArgumentExpressionListAccess().getExprConditionalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_15);
            lv_expr_0_0=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getArgumentExpressionListRule());
              	        }
                     		add(
                     			current, 
                     			"expr",
                      		lv_expr_0_0, 
                      		"at.jku.weiner.c.common.Common.ConditionalExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:4607:1: (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_SKW_COMMA) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalPreprocess.g:4608:1: this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) )
            	    {
            	    this_SKW_COMMA_1=(Token)match(input,RULE_SKW_COMMA,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_COMMA_1, grammarAccess.getArgumentExpressionListAccess().getSKW_COMMATerminalRuleCall_1_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:4615:1: ( (lv_expr_2_0= ruleConditionalExpression ) )
            	    // InternalPreprocess.g:4616:1: (lv_expr_2_0= ruleConditionalExpression )
            	    {
            	    // InternalPreprocess.g:4616:1: (lv_expr_2_0= ruleConditionalExpression )
            	    // InternalPreprocess.g:4617:3: lv_expr_2_0= ruleConditionalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArgumentExpressionListAccess().getExprConditionalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_expr_2_0=ruleConditionalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getArgumentExpressionListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expr",
            	              		lv_expr_2_0, 
            	              		"at.jku.weiner.c.common.Common.ConditionalExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  		/*no after found*/
                   
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
    // $ANTLR end "ruleArgumentExpressionList"


    // $ANTLR start "entryRuleConstant1"
    // InternalPreprocess.g:4647:1: entryRuleConstant1 returns [String current=null] : iv_ruleConstant1= ruleConstant1 EOF ;
    public final String entryRuleConstant1() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConstant1 = null;


        try {
            // InternalPreprocess.g:4648:2: (iv_ruleConstant1= ruleConstant1 EOF )
            // InternalPreprocess.g:4649:2: iv_ruleConstant1= ruleConstant1 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstant1Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstant1=ruleConstant1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant1.getText(); 
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
    // $ANTLR end "entryRuleConstant1"


    // $ANTLR start "ruleConstant1"
    // InternalPreprocess.g:4656:1: ruleConstant1 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL ) ;
    public final AntlrDatatypeRuleToken ruleConstant1() throws RecognitionException {
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
            // InternalPreprocess.g:4659:28: ( (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL ) )
            // InternalPreprocess.g:4660:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL )
            {
            // InternalPreprocess.g:4660:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL )
            int alt64=7;
            switch ( input.LA(1) ) {
            case RULE_HEX_LITERAL:
                {
                alt64=1;
                }
                break;
            case RULE_OCTAL_LITERAL:
                {
                alt64=2;
                }
                break;
            case RULE_DECIMAL_LITERAL:
                {
                alt64=3;
                }
                break;
            case RULE_CHAR_LITERAL:
                {
                alt64=4;
                }
                break;
            case RULE_STRING_LITERAL:
                {
                alt64=5;
                }
                break;
            case RULE_FLOAT_LITERAL:
                {
                alt64=6;
                }
                break;
            case RULE_BIN_LITERAL:
                {
                alt64=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // InternalPreprocess.g:4660:6: this_HEX_LITERAL_0= RULE_HEX_LITERAL
                    {
                    this_HEX_LITERAL_0=(Token)match(input,RULE_HEX_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEX_LITERAL_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEX_LITERAL_0, grammarAccess.getConstant1Access().getHEX_LITERALTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:4668:10: this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL
                    {
                    this_OCTAL_LITERAL_1=(Token)match(input,RULE_OCTAL_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_OCTAL_LITERAL_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_OCTAL_LITERAL_1, grammarAccess.getConstant1Access().getOCTAL_LITERALTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalPreprocess.g:4676:10: this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL
                    {
                    this_DECIMAL_LITERAL_2=(Token)match(input,RULE_DECIMAL_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DECIMAL_LITERAL_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DECIMAL_LITERAL_2, grammarAccess.getConstant1Access().getDECIMAL_LITERALTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalPreprocess.g:4684:10: this_CHAR_LITERAL_3= RULE_CHAR_LITERAL
                    {
                    this_CHAR_LITERAL_3=(Token)match(input,RULE_CHAR_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_CHAR_LITERAL_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_CHAR_LITERAL_3, grammarAccess.getConstant1Access().getCHAR_LITERALTerminalRuleCall_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalPreprocess.g:4692:10: this_STRING_LITERAL_4= RULE_STRING_LITERAL
                    {
                    this_STRING_LITERAL_4=(Token)match(input,RULE_STRING_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_STRING_LITERAL_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_STRING_LITERAL_4, grammarAccess.getConstant1Access().getSTRING_LITERALTerminalRuleCall_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalPreprocess.g:4700:10: this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL
                    {
                    this_FLOAT_LITERAL_5=(Token)match(input,RULE_FLOAT_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_FLOAT_LITERAL_5);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_FLOAT_LITERAL_5, grammarAccess.getConstant1Access().getFLOAT_LITERALTerminalRuleCall_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalPreprocess.g:4708:10: this_BIN_LITERAL_6= RULE_BIN_LITERAL
                    {
                    this_BIN_LITERAL_6=(Token)match(input,RULE_BIN_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BIN_LITERAL_6);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BIN_LITERAL_6, grammarAccess.getConstant1Access().getBIN_LITERALTerminalRuleCall_6()); 
                          
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
    // $ANTLR end "ruleConstant1"


    // $ANTLR start "entryRuleSpecialKeywords"
    // InternalPreprocess.g:4725:1: entryRuleSpecialKeywords returns [String current=null] : iv_ruleSpecialKeywords= ruleSpecialKeywords EOF ;
    public final String entryRuleSpecialKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpecialKeywords = null;


        try {
            // InternalPreprocess.g:4726:2: (iv_ruleSpecialKeywords= ruleSpecialKeywords EOF )
            // InternalPreprocess.g:4727:2: iv_ruleSpecialKeywords= ruleSpecialKeywords EOF
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
    // InternalPreprocess.g:4734:1: ruleSpecialKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE ) ;
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
            // InternalPreprocess.g:4737:28: ( (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE ) )
            // InternalPreprocess.g:4738:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE )
            {
            // InternalPreprocess.g:4738:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE )
            int alt65=37;
            switch ( input.LA(1) ) {
            case RULE_SKW_AND:
                {
                alt65=1;
                }
                break;
            case RULE_SKW_ANDAND:
                {
                alt65=2;
                }
                break;
            case RULE_SKW_ASSIGN:
                {
                alt65=3;
                }
                break;
            case RULE_SKW_BACKSLASH:
                {
                alt65=4;
                }
                break;
            case RULE_SKW_CARET:
                {
                alt65=5;
                }
                break;
            case RULE_SKW_COMMA:
                {
                alt65=6;
                }
                break;
            case RULE_SKW_COLON:
                {
                alt65=7;
                }
                break;
            case RULE_SKW_DIV:
                {
                alt65=8;
                }
                break;
            case RULE_SKW_DOT:
                {
                alt65=9;
                }
                break;
            case RULE_SKW_DOUBLEQUOTE:
                {
                alt65=10;
                }
                break;
            case RULE_SKW_EQUAL:
                {
                alt65=11;
                }
                break;
            case RULE_SKW_GREATER:
                {
                alt65=12;
                }
                break;
            case RULE_SKW_GREATEREQUAL:
                {
                alt65=13;
                }
                break;
            case RULE_SKW_LEFTBRACE:
                {
                alt65=14;
                }
                break;
            case RULE_SKW_LEFTBRACKET:
                {
                alt65=15;
                }
                break;
            case RULE_SKW_LEFTPAREN:
                {
                alt65=16;
                }
                break;
            case RULE_SKW_LEFTSHIFT:
                {
                alt65=17;
                }
                break;
            case RULE_SKW_LESS:
                {
                alt65=18;
                }
                break;
            case RULE_SKW_LESSEQUAL:
                {
                alt65=19;
                }
                break;
            case RULE_SKW_MINUS:
                {
                alt65=20;
                }
                break;
            case RULE_SKW_MINUSMINUS:
                {
                alt65=21;
                }
                break;
            case RULE_SKW_MOD:
                {
                alt65=22;
                }
                break;
            case RULE_SKW_NOT:
                {
                alt65=23;
                }
                break;
            case RULE_SKW_NOTEQUAL:
                {
                alt65=24;
                }
                break;
            case RULE_SKW_OR:
                {
                alt65=25;
                }
                break;
            case RULE_SKW_OROR:
                {
                alt65=26;
                }
                break;
            case RULE_SKW_PLUS:
                {
                alt65=27;
                }
                break;
            case RULE_SKW_PLUSPLUS:
                {
                alt65=28;
                }
                break;
            case RULE_SKW_QUESTION:
                {
                alt65=29;
                }
                break;
            case RULE_SKW_RIGHTBRACE:
                {
                alt65=30;
                }
                break;
            case RULE_SKW_RIGHTBRACKET:
                {
                alt65=31;
                }
                break;
            case RULE_SKW_RIGHTPAREN:
                {
                alt65=32;
                }
                break;
            case RULE_SKW_RIGHTSHIFT:
                {
                alt65=33;
                }
                break;
            case RULE_SKW_SEMI:
                {
                alt65=34;
                }
                break;
            case RULE_SKW_SINGLEQUOTE:
                {
                alt65=35;
                }
                break;
            case RULE_SKW_STAR:
                {
                alt65=36;
                }
                break;
            case RULE_SKW_TILDE:
                {
                alt65=37;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // InternalPreprocess.g:4738:6: this_SKW_AND_0= RULE_SKW_AND
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
                    // InternalPreprocess.g:4746:10: this_SKW_ANDAND_1= RULE_SKW_ANDAND
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
                    // InternalPreprocess.g:4754:10: this_SKW_ASSIGN_2= RULE_SKW_ASSIGN
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
                    // InternalPreprocess.g:4762:10: this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH
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
                    // InternalPreprocess.g:4770:10: this_SKW_CARET_4= RULE_SKW_CARET
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
                    // InternalPreprocess.g:4778:10: this_SKW_COMMA_5= RULE_SKW_COMMA
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
                    // InternalPreprocess.g:4786:10: this_SKW_COLON_6= RULE_SKW_COLON
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
                    // InternalPreprocess.g:4794:10: this_SKW_DIV_7= RULE_SKW_DIV
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
                    // InternalPreprocess.g:4802:10: this_SKW_DOT_8= RULE_SKW_DOT
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
                    // InternalPreprocess.g:4810:10: this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE
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
                    // InternalPreprocess.g:4818:10: this_SKW_EQUAL_10= RULE_SKW_EQUAL
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
                    // InternalPreprocess.g:4826:10: this_SKW_GREATER_11= RULE_SKW_GREATER
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
                    // InternalPreprocess.g:4834:10: this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL
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
                    // InternalPreprocess.g:4842:10: this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE
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
                    // InternalPreprocess.g:4850:10: this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET
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
                    // InternalPreprocess.g:4858:10: this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN
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
                    // InternalPreprocess.g:4866:10: this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT
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
                    // InternalPreprocess.g:4874:10: this_SKW_LESS_17= RULE_SKW_LESS
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
                    // InternalPreprocess.g:4882:10: this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL
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
                    // InternalPreprocess.g:4890:10: this_SKW_MINUS_19= RULE_SKW_MINUS
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
                    // InternalPreprocess.g:4898:10: this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS
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
                    // InternalPreprocess.g:4906:10: this_SKW_MOD_21= RULE_SKW_MOD
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
                    // InternalPreprocess.g:4914:10: this_SKW_NOT_22= RULE_SKW_NOT
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
                    // InternalPreprocess.g:4922:10: this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL
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
                    // InternalPreprocess.g:4930:10: this_SKW_OR_24= RULE_SKW_OR
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
                    // InternalPreprocess.g:4938:10: this_SKW_OROR_25= RULE_SKW_OROR
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
                    // InternalPreprocess.g:4946:10: this_SKW_PLUS_26= RULE_SKW_PLUS
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
                    // InternalPreprocess.g:4954:10: this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS
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
                    // InternalPreprocess.g:4962:10: this_SKW_QUESTION_28= RULE_SKW_QUESTION
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
                    // InternalPreprocess.g:4970:10: this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE
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
                    // InternalPreprocess.g:4978:10: this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET
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
                    // InternalPreprocess.g:4986:10: this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN
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
                    // InternalPreprocess.g:4994:10: this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT
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
                    // InternalPreprocess.g:5002:10: this_SKW_SEMI_33= RULE_SKW_SEMI
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
                    // InternalPreprocess.g:5010:10: this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE
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
                    // InternalPreprocess.g:5018:10: this_SKW_STAR_35= RULE_SKW_STAR
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
                    // InternalPreprocess.g:5026:10: this_SKW_TILDE_36= RULE_SKW_TILDE
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

    // $ANTLR start synpred3_InternalPreprocess
    public final void synpred3_InternalPreprocess_fragment() throws RecognitionException {   
        EObject this_NewLineLine_1 = null;


        // InternalPreprocess.g:299:2: (this_NewLineLine_1= ruleNewLineLine )
        // InternalPreprocess.g:299:2: this_NewLineLine_1= ruleNewLineLine
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_2);
        this_NewLineLine_1=ruleNewLineLine();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalPreprocess

    // $ANTLR start synpred13_InternalPreprocess
    public final void synpred13_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_2=null;

        // InternalPreprocess.g:613:2: (this_WHITESPACE_2= RULE_WHITESPACE )
        // InternalPreprocess.g:613:2: this_WHITESPACE_2= RULE_WHITESPACE
        {
        this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalPreprocess

    // $ANTLR start synpred16_InternalPreprocess
    public final void synpred16_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_4=null;

        // InternalPreprocess.g:774:2: (this_WHITESPACE_4= RULE_WHITESPACE )
        // InternalPreprocess.g:774:2: this_WHITESPACE_4= RULE_WHITESPACE
        {
        this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalPreprocess

    // $ANTLR start synpred21_InternalPreprocess
    public final void synpred21_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_8=null;

        // InternalPreprocess.g:920:2: (this_WHITESPACE_8= RULE_WHITESPACE )
        // InternalPreprocess.g:920:2: this_WHITESPACE_8= RULE_WHITESPACE
        {
        this_WHITESPACE_8=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalPreprocess

    // $ANTLR start synpred24_InternalPreprocess
    public final void synpred24_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_2=null;

        // InternalPreprocess.g:1092:2: (this_WHITESPACE_2= RULE_WHITESPACE )
        // InternalPreprocess.g:1092:2: this_WHITESPACE_2= RULE_WHITESPACE
        {
        this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_InternalPreprocess

    // $ANTLR start synpred25_InternalPreprocess
    public final void synpred25_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_2=null;

        // InternalPreprocess.g:1166:2: (this_WHITESPACE_2= RULE_WHITESPACE )
        // InternalPreprocess.g:1166:2: this_WHITESPACE_2= RULE_WHITESPACE
        {
        this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_InternalPreprocess

    // $ANTLR start synpred57_InternalPreprocess
    public final void synpred57_InternalPreprocess_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_MyCode_0 = null;


        // InternalPreprocess.g:2346:5: (this_MyCode_0= ruleMyCode )
        // InternalPreprocess.g:2346:5: this_MyCode_0= ruleMyCode
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
    // $ANTLR end synpred57_InternalPreprocess

    // $ANTLR start synpred58_InternalPreprocess
    public final void synpred58_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_1=null;

        // InternalPreprocess.g:2357:10: (this_WHITESPACE_1= RULE_WHITESPACE )
        // InternalPreprocess.g:2357:10: this_WHITESPACE_1= RULE_WHITESPACE
        {
        this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_InternalPreprocess

    // $ANTLR start synpred66_InternalPreprocess
    public final void synpred66_InternalPreprocess_fragment() throws RecognitionException {   
        Token lv_defined_3_0=null;
        Token this_SKW_LEFTPAREN_4=null;
        Token lv_id_5_0=null;
        Token this_SKW_RIGHTPAREN_6=null;

        // InternalPreprocess.g:2507:1: ( ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) )
        // InternalPreprocess.g:2507:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
        {
        // InternalPreprocess.g:2507:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
        // InternalPreprocess.g:2508:1: ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN
        {
        // InternalPreprocess.g:2508:1: ( (lv_defined_3_0= RULE_DEFINED ) )?
        int alt70=2;
        int LA70_0 = input.LA(1);

        if ( (LA70_0==RULE_DEFINED) ) {
            alt70=1;
        }
        switch (alt70) {
            case 1 :
                // InternalPreprocess.g:2509:1: (lv_defined_3_0= RULE_DEFINED )
                {
                // InternalPreprocess.g:2509:1: (lv_defined_3_0= RULE_DEFINED )
                // InternalPreprocess.g:2510:3: lv_defined_3_0= RULE_DEFINED
                {
                lv_defined_3_0=(Token)match(input,RULE_DEFINED,FOLLOW_12); if (state.failed) return ;

                }


                }
                break;

        }

        this_SKW_LEFTPAREN_4=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_21); if (state.failed) return ;
        // InternalPreprocess.g:2536:1: ( (lv_id_5_0= RULE_ID ) )
        // InternalPreprocess.g:2537:1: (lv_id_5_0= RULE_ID )
        {
        // InternalPreprocess.g:2537:1: (lv_id_5_0= RULE_ID )
        // InternalPreprocess.g:2538:3: lv_id_5_0= RULE_ID
        {
        lv_id_5_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return ;

        }


        }

        this_SKW_RIGHTPAREN_6=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred66_InternalPreprocess

    // Delegated rules

    public final boolean synpred3_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred66_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred66_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalPreprocess_fragment(); // can never throw exception
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
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA36 dfa36 = new DFA36(this);
    static final String DFA1_eotS =
        "\6\uffff";
    static final String DFA1_eofS =
        "\1\1\5\uffff";
    static final String DFA1_minS =
        "\1\4\1\uffff\2\4\1\uffff\1\4";
    static final String DFA1_maxS =
        "\1\101\1\uffff\1\101\1\26\1\uffff\1\26";
    static final String DFA1_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\1\uffff";
    static final String DFA1_specialS =
        "\6\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\4\1\2\1\3\7\4\2\uffff\4\4\2\uffff\54\4",
            "",
            "\1\4\1\2\1\3\7\4\2\uffff\4\4\2\uffff\54\4",
            "\1\4\1\5\1\uffff\2\4\4\uffff\3\4\1\1\3\4\2\1\1\4",
            "",
            "\1\4\1\5\1\uffff\2\4\4\uffff\3\4\1\1\3\4\2\1\1\4"
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
            return "()* loopback of 224:1: ( ( (lv_lines_1_0= ruleGroupOptTemp ) ) this_NEWLINE_2= RULE_NEWLINE )*";
        }
    }
    static final String DFA2_eotS =
        "\7\uffff";
    static final String DFA2_eofS =
        "\1\4\1\5\5\uffff";
    static final String DFA2_minS =
        "\2\4\1\uffff\2\0\2\uffff";
    static final String DFA2_maxS =
        "\2\101\1\uffff\2\0\2\uffff";
    static final String DFA2_acceptS =
        "\2\uffff\1\1\2\uffff\1\3\1\2";
    static final String DFA2_specialS =
        "\3\uffff\1\1\1\0\2\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\3\1\1\1\2\7\5\2\uffff\4\5\2\uffff\54\5",
            "\1\5\1\1\1\2\7\5\2\uffff\4\5\2\uffff\54\5",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "281:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA2_4 = input.LA(1);

                         
                        int index2_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalPreprocess()) ) {s = 6;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index2_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA2_3 = input.LA(1);

                         
                        int index2_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalPreprocess()) ) {s = 6;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index2_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 2, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA7_eotS =
        "\6\uffff";
    static final String DFA7_eofS =
        "\3\uffff\1\4\2\uffff";
    static final String DFA7_minS =
        "\1\10\2\5\1\4\2\uffff";
    static final String DFA7_maxS =
        "\1\10\1\5\1\11\1\12\2\uffff";
    static final String DFA7_acceptS =
        "\4\uffff\1\1\1\2";
    static final String DFA7_specialS =
        "\6\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1",
            "\1\2",
            "\1\2\3\uffff\1\3",
            "\2\4\4\uffff\1\5",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "667:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )";
        }
    }
    static final String DFA21_eotS =
        "\6\uffff";
    static final String DFA21_eofS =
        "\6\uffff";
    static final String DFA21_minS =
        "\4\5\2\uffff";
    static final String DFA21_maxS =
        "\2\6\2\25\2\uffff";
    static final String DFA21_acceptS =
        "\4\uffff\1\2\1\1";
    static final String DFA21_specialS =
        "\6\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\1\1\2",
            "\1\1\1\2",
            "\1\3\12\uffff\1\4\3\uffff\1\5\1\4",
            "\1\3\12\uffff\1\4\3\uffff\1\5\1\4",
            "",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "()* loopback of 1361:1: ( (lv_elifs_2_0= ruleElIfConditional ) )*";
        }
    }
    static final String DFA22_eotS =
        "\6\uffff";
    static final String DFA22_eofS =
        "\6\uffff";
    static final String DFA22_minS =
        "\4\5\2\uffff";
    static final String DFA22_maxS =
        "\2\6\2\25\2\uffff";
    static final String DFA22_acceptS =
        "\4\uffff\1\2\1\1";
    static final String DFA22_specialS =
        "\6\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1\1\2",
            "\1\1\1\2",
            "\1\3\12\uffff\1\4\4\uffff\1\5",
            "\1\3\12\uffff\1\4\4\uffff\1\5",
            "",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "1382:1: ( (lv_else_3_0= ruleElseConditional ) )?";
        }
    }
    static final String DFA36_eotS =
        "\74\uffff";
    static final String DFA36_eofS =
        "\1\1\73\uffff";
    static final String DFA36_minS =
        "\1\4\1\uffff\70\0\2\uffff";
    static final String DFA36_maxS =
        "\1\101\1\uffff\70\0\2\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\3\70\uffff\1\1\1\2";
    static final String DFA36_specialS =
        "\2\uffff\1\30\1\61\1\5\1\64\1\21\1\54\1\33\1\6\1\50\1\10\1\57\1\65\1\40\1\1\1\34\1\4\1\66\1\27\1\11\1\45\1\55\1\25\1\56\1\22\1\47\1\17\1\62\1\31\1\13\1\42\1\2\1\35\1\43\1\14\1\36\1\3\1\20\1\53\1\32\1\41\1\26\1\60\1\23\1\67\1\37\1\0\1\24\1\63\1\15\1\7\1\52\1\12\1\46\1\16\1\44\1\51\2\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\1\71\1\1\1\4\1\5\1\2\1\34\1\54\1\22\1\6\2\uffff\1\11\1\13\1\10\1\12\2\uffff\1\7\1\3\1\14\1\51\1\23\1\46\1\16\1\45\1\21\1\15\1\27\1\44\1\36\1\30\1\37\1\31\1\35\1\55\1\47\1\40\1\60\1\24\1\42\1\61\1\43\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\17\1\20\1\25\1\26\1\32\1\33\1\41\1\50\1\52\1\53\1\56\1\57",
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

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "()+ loopback of 2345:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_47 = input.LA(1);

                         
                        int index36_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_47);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA36_15 = input.LA(1);

                         
                        int index36_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_15);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA36_32 = input.LA(1);

                         
                        int index36_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_32);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA36_37 = input.LA(1);

                         
                        int index36_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_37);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA36_17 = input.LA(1);

                         
                        int index36_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_17);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA36_4 = input.LA(1);

                         
                        int index36_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_4);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA36_9 = input.LA(1);

                         
                        int index36_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_9);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA36_51 = input.LA(1);

                         
                        int index36_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_51);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA36_11 = input.LA(1);

                         
                        int index36_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_11);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA36_20 = input.LA(1);

                         
                        int index36_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_20);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA36_53 = input.LA(1);

                         
                        int index36_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_53);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA36_30 = input.LA(1);

                         
                        int index36_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_30);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA36_35 = input.LA(1);

                         
                        int index36_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_35);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA36_50 = input.LA(1);

                         
                        int index36_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_50);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA36_55 = input.LA(1);

                         
                        int index36_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_55);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA36_27 = input.LA(1);

                         
                        int index36_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_27);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA36_38 = input.LA(1);

                         
                        int index36_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_38);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA36_6 = input.LA(1);

                         
                        int index36_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_6);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA36_25 = input.LA(1);

                         
                        int index36_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_25);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA36_44 = input.LA(1);

                         
                        int index36_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_44);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA36_48 = input.LA(1);

                         
                        int index36_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_48);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA36_23 = input.LA(1);

                         
                        int index36_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_23);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA36_42 = input.LA(1);

                         
                        int index36_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_42);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA36_19 = input.LA(1);

                         
                        int index36_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_19);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA36_2 = input.LA(1);

                         
                        int index36_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_2);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA36_29 = input.LA(1);

                         
                        int index36_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_29);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA36_40 = input.LA(1);

                         
                        int index36_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_40);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA36_8 = input.LA(1);

                         
                        int index36_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_8);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA36_16 = input.LA(1);

                         
                        int index36_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_16);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA36_33 = input.LA(1);

                         
                        int index36_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_33);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA36_36 = input.LA(1);

                         
                        int index36_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_36);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA36_46 = input.LA(1);

                         
                        int index36_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_46);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA36_14 = input.LA(1);

                         
                        int index36_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_14);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA36_41 = input.LA(1);

                         
                        int index36_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_41);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA36_31 = input.LA(1);

                         
                        int index36_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_31);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA36_34 = input.LA(1);

                         
                        int index36_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_34);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA36_56 = input.LA(1);

                         
                        int index36_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_56);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA36_21 = input.LA(1);

                         
                        int index36_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_21);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA36_54 = input.LA(1);

                         
                        int index36_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_54);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA36_26 = input.LA(1);

                         
                        int index36_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_26);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA36_10 = input.LA(1);

                         
                        int index36_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_10);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA36_57 = input.LA(1);

                         
                        int index36_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred58_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_57);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA36_52 = input.LA(1);

                         
                        int index36_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_52);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA36_39 = input.LA(1);

                         
                        int index36_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_39);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA36_7 = input.LA(1);

                         
                        int index36_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_7);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA36_22 = input.LA(1);

                         
                        int index36_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_22);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA36_24 = input.LA(1);

                         
                        int index36_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_24);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA36_12 = input.LA(1);

                         
                        int index36_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_12);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA36_43 = input.LA(1);

                         
                        int index36_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_43);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA36_3 = input.LA(1);

                         
                        int index36_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_3);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA36_28 = input.LA(1);

                         
                        int index36_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_28);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA36_49 = input.LA(1);

                         
                        int index36_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_49);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA36_5 = input.LA(1);

                         
                        int index36_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_5);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA36_13 = input.LA(1);

                         
                        int index36_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_13);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA36_18 = input.LA(1);

                         
                        int index36_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_18);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA36_45 = input.LA(1);

                         
                        int index36_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_45);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 36, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0xFFFFFFFFFFCF3FE2L,0x0000000000000003L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000004EE1A0L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0xFFFFFFFFFFCF3FA0L,0x0000000000000003L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0xFFFFFFFFFFCF3FE0L,0x0000000000000003L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000A20L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0xFFFFFFFFFFCF3FF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000200020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xFFFFFFFFFFCF3FA2L,0x0000000000000003L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0xFFFFFFFFFFCF3F80L,0x0000000000000003L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000003C00000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000030000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x00001C0000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000402L});

}