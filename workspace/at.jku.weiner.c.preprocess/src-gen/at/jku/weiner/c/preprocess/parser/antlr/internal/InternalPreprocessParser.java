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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NEWLINE", "RULE_WHITESPACE", "RULE_HASH", "RULE_INCLUDE", "RULE_DEFINE", "RULE_ID", "RULE_SKW_LEFTPAREN", "RULE_SKW_RIGHTPAREN", "RULE_SKW_COMMA", "RULE_ERROR", "RULE_WARNING", "RULE_UNDEF", "RULE_ENDIF", "RULE_IF", "RULE_IFDEF", "RULE_IFNOTDEF", "RULE_ELIF", "RULE_ELSE", "RULE_PRAGMA", "RULE_SPECIAL", "RULE_DEFINED", "RULE_SKW_QUESTION", "RULE_SKW_COLON", "RULE_SKW_OROR", "RULE_SKW_ANDAND", "RULE_SKW_OR", "RULE_SKW_CARET", "RULE_SKW_AND", "RULE_SKW_EQUAL", "RULE_SKW_NOTEQUAL", "RULE_SKW_LESS", "RULE_SKW_GREATER", "RULE_SKW_LESSEQUAL", "RULE_SKW_GREATEREQUAL", "RULE_SKW_LEFTSHIFT", "RULE_SKW_RIGHTSHIFT", "RULE_SKW_PLUS", "RULE_SKW_MINUS", "RULE_SKW_STAR", "RULE_SKW_DIV", "RULE_SKW_MOD", "RULE_SKW_TILDE", "RULE_SKW_NOT", "RULE_HEX_LITERAL", "RULE_OCTAL_LITERAL", "RULE_DECIMAL_LITERAL", "RULE_CHAR_LITERAL", "RULE_STRING_LITERAL", "RULE_FLOAT_LITERAL", "RULE_BIN_LITERAL", "RULE_SKW_ASSIGN", "RULE_SKW_BACKSLASH", "RULE_SKW_DOT", "RULE_SKW_DOUBLEQUOTE", "RULE_SKW_LEFTBRACE", "RULE_SKW_LEFTBRACKET", "RULE_SKW_MINUSMINUS", "RULE_SKW_PLUSPLUS", "RULE_SKW_RIGHTBRACE", "RULE_SKW_RIGHTBRACKET", "RULE_SKW_SEMI", "RULE_SKW_SINGLEQUOTE", "SUPER_NEWLINE", "RULE_SKW_DOLLAR", "RULE_SKW_UNDERSCORE", "RULE_IDENTIFIER", "RULE_LETTER", "RULE_ESCAPE_SEQUENCE", "RULE_HEX_DIGIT", "RULE_INTEGER_TYPE_SUFFIX", "RULE_EXPONENT", "RULE_FLOAT_TYPE_SUFFIX", "RULE_OCTAL_ESCAPE", "RULE_LINEFEED", "RULE_CARRIAGERETURN", "RULE_LINE_END", "RULE_LINEBREAK", "RULE_SPACE", "RULE_TAB", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT"
    };
    public static final int RULE_PRAGMA=22;
    public static final int RULE_ID=9;
    public static final int RULE_OCTAL_ESCAPE=76;
    public static final int RULE_SKW_NOT=46;
    public static final int RULE_ESCAPE_SEQUENCE=71;
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
    public static final int RULE_LINEBREAK=80;
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
    public static final int RULE_SPACE=81;
    public static final int SUPER_NEWLINE=66;
    public static final int RULE_BLOCK_COMMENT=83;
    public static final int RULE_LINEFEED=77;
    public static final int RULE_SKW_COLON=26;
    public static final int RULE_BIN_LITERAL=53;
    public static final int RULE_SKW_LEFTPAREN=10;
    public static final int RULE_SKW_MINUS=41;
    public static final int RULE_SKW_SEMI=64;
    public static final int RULE_IFDEF=18;
    public static final int RULE_NEWLINE=4;
    public static final int RULE_SKW_DOLLAR=67;
    public static final int RULE_SKW_EQUAL=32;
    public static final int RULE_SKW_LEFTSHIFT=38;
    public static final int RULE_SKW_DIV=43;
    public static final int RULE_SKW_QUESTION=25;
    public static final int RULE_SKW_ANDAND=28;
    public static final int RULE_ERROR=13;
    public static final int RULE_HEX_DIGIT=72;
    public static final int RULE_SKW_GREATER=35;
    public static final int RULE_IDENTIFIER=69;
    public static final int RULE_HASH=6;
    public static final int RULE_TAB=82;
    public static final int RULE_SKW_LEFTBRACKET=59;
    public static final int RULE_SKW_SINGLEQUOTE=65;
    public static final int RULE_SKW_MOD=44;
    public static final int RULE_UNDEF=15;
    public static final int RULE_LETTER=70;
    public static final int RULE_SKW_MINUSMINUS=60;
    public static final int RULE_FLOAT_TYPE_SUFFIX=75;
    public static final int RULE_IFNOTDEF=19;
    public static final int RULE_EXPONENT=74;
    public static final int RULE_INTEGER_TYPE_SUFFIX=73;
    public static final int RULE_DEFINE=8;
    public static final int RULE_SPECIAL=23;
    public static final int RULE_CARRIAGERETURN=78;
    public static final int RULE_SKW_TILDE=45;
    public static final int RULE_LINE_COMMENT=84;
    public static final int RULE_INCLUDE=7;
    public static final int RULE_SKW_UNDERSCORE=68;
    public static final int RULE_SKW_BACKSLASH=55;
    public static final int RULE_SKW_OR=29;
    public static final int RULE_CHAR_LITERAL=50;
    public static final int RULE_ELIF=20;
    public static final int RULE_LINE_END=79;
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
    // InternalPreprocess.g:143:1: ruleTranslationUnit returns [EObject current=null] : ( () ( (lv_group_1_0= ruleGroupOpt2 ) ) ) ;
    public final EObject ruleTranslationUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_group_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:149:7: ( ( () ( (lv_group_1_0= ruleGroupOpt2 ) ) ) )
            // InternalPreprocess.g:151:1: ( () ( (lv_group_1_0= ruleGroupOpt2 ) ) )
            {
            // InternalPreprocess.g:151:1: ( () ( (lv_group_1_0= ruleGroupOpt2 ) ) )
            // InternalPreprocess.g:152:1: () ( (lv_group_1_0= ruleGroupOpt2 ) )
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

            // InternalPreprocess.g:164:1: ( (lv_group_1_0= ruleGroupOpt2 ) )
            // InternalPreprocess.g:165:1: (lv_group_1_0= ruleGroupOpt2 )
            {
            // InternalPreprocess.g:165:1: (lv_group_1_0= ruleGroupOpt2 )
            // InternalPreprocess.g:166:3: lv_group_1_0= ruleGroupOpt2
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTranslationUnitAccess().getGroupGroupOpt2ParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_group_1_0=ruleGroupOpt2();

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
                      		"at.jku.weiner.c.preprocess.Preprocess.GroupOpt2");
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
    // InternalPreprocess.g:203:1: ruleGroupOpt returns [EObject current=null] : ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ) ;
    public final EObject ruleGroupOpt() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_2=null;
        EObject lv_lines_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:209:7: ( ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ) )
            // InternalPreprocess.g:211:1: ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* )
            {
            // InternalPreprocess.g:211:1: ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* )
            // InternalPreprocess.g:212:1: () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )*
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

            // InternalPreprocess.g:224:1: ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )*
            loop1:
            do {
                int alt1=2;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // InternalPreprocess.g:225:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE
            	    {
            	    // InternalPreprocess.g:225:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) )
            	    // InternalPreprocess.g:226:1: (lv_lines_1_0= ruleGroupOptTemp1 )
            	    {
            	    // InternalPreprocess.g:226:1: (lv_lines_1_0= ruleGroupOptTemp1 )
            	    // InternalPreprocess.g:227:3: lv_lines_1_0= ruleGroupOptTemp1
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGroupOptAccess().getLinesGroupOptTemp1ParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_lines_1_0=ruleGroupOptTemp1();

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
            	              		"at.jku.weiner.c.preprocess.Preprocess.GroupOptTemp1");
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


    // $ANTLR start "entryRuleGroupOpt2"
    // InternalPreprocess.g:264:1: entryRuleGroupOpt2 returns [EObject current=null] : iv_ruleGroupOpt2= ruleGroupOpt2 EOF ;
    public final EObject entryRuleGroupOpt2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOpt2 = null;


        try {
            // InternalPreprocess.g:265:2: (iv_ruleGroupOpt2= ruleGroupOpt2 EOF )
            // InternalPreprocess.g:266:2: iv_ruleGroupOpt2= ruleGroupOpt2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGroupOpt2Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGroupOpt2=ruleGroupOpt2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGroupOpt2; 
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
    // $ANTLR end "entryRuleGroupOpt2"


    // $ANTLR start "ruleGroupOpt2"
    // InternalPreprocess.g:273:1: ruleGroupOpt2 returns [EObject current=null] : ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleGroupOptTemp2 ) )? ) ;
    public final EObject ruleGroupOpt2() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_2=null;
        EObject lv_lines_1_0 = null;

        EObject lv_lines_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:279:7: ( ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleGroupOptTemp2 ) )? ) )
            // InternalPreprocess.g:281:1: ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleGroupOptTemp2 ) )? )
            {
            // InternalPreprocess.g:281:1: ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleGroupOptTemp2 ) )? )
            // InternalPreprocess.g:282:1: () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleGroupOptTemp2 ) )?
            {
            // InternalPreprocess.g:282:1: ()
            // InternalPreprocess.g:283:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getGroupOpt2Access().getGroupOpt2Action_0(),
                          current);
                  
            }

            }

            // InternalPreprocess.g:294:1: ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // InternalPreprocess.g:295:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE
            	    {
            	    // InternalPreprocess.g:295:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) )
            	    // InternalPreprocess.g:296:1: (lv_lines_1_0= ruleGroupOptTemp1 )
            	    {
            	    // InternalPreprocess.g:296:1: (lv_lines_1_0= ruleGroupOptTemp1 )
            	    // InternalPreprocess.g:297:3: lv_lines_1_0= ruleGroupOptTemp1
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGroupOpt2Access().getLinesGroupOptTemp1ParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_lines_1_0=ruleGroupOptTemp1();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGroupOpt2Rule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"lines",
            	              		lv_lines_1_0, 
            	              		"at.jku.weiner.c.preprocess.Preprocess.GroupOptTemp1");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_2, grammarAccess.getGroupOpt2Access().getNEWLINETerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalPreprocess.g:325:1: ( (lv_lines_3_0= ruleGroupOptTemp2 ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_WHITESPACE && LA3_0<=RULE_ERROR)||(LA3_0>=RULE_ENDIF && LA3_0<=RULE_IFNOTDEF)||(LA3_0>=RULE_PRAGMA && LA3_0<=RULE_SKW_SINGLEQUOTE)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalPreprocess.g:326:1: (lv_lines_3_0= ruleGroupOptTemp2 )
                    {
                    // InternalPreprocess.g:326:1: (lv_lines_3_0= ruleGroupOptTemp2 )
                    // InternalPreprocess.g:327:3: lv_lines_3_0= ruleGroupOptTemp2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGroupOpt2Access().getLinesGroupOptTemp2ParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_lines_3_0=ruleGroupOptTemp2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getGroupOpt2Rule());
                      	        }
                             		add(
                             			current, 
                             			"lines",
                              		lv_lines_3_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.GroupOptTemp2");
                      	        afterParserOrEnumRuleCall();
                      	    
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
    // $ANTLR end "ruleGroupOpt2"


    // $ANTLR start "entryRuleGroupOptTemp1"
    // InternalPreprocess.g:355:1: entryRuleGroupOptTemp1 returns [EObject current=null] : iv_ruleGroupOptTemp1= ruleGroupOptTemp1 EOF ;
    public final EObject entryRuleGroupOptTemp1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOptTemp1 = null;


        try {
            // InternalPreprocess.g:356:2: (iv_ruleGroupOptTemp1= ruleGroupOptTemp1 EOF )
            // InternalPreprocess.g:357:2: iv_ruleGroupOptTemp1= ruleGroupOptTemp1 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGroupOptTemp1Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGroupOptTemp1=ruleGroupOptTemp1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGroupOptTemp1; 
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
    // $ANTLR end "entryRuleGroupOptTemp1"


    // $ANTLR start "ruleGroupOptTemp1"
    // InternalPreprocess.g:364:1: ruleGroupOptTemp1 returns [EObject current=null] : (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode ) ;
    public final EObject ruleGroupOptTemp1() throws RecognitionException {
        EObject current = null;

        EObject this_PreprocessorDirectives_0 = null;

        EObject this_NewLineLine_1 = null;

        EObject this_Code_2 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:370:7: ( (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode ) )
            // InternalPreprocess.g:372:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode )
            {
            // InternalPreprocess.g:372:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode )
            int alt4=3;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalPreprocess.g:374:2: this_PreprocessorDirectives_0= rulePreprocessorDirectives
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGroupOptTemp1Access().getPreprocessorDirectivesParserRuleCall_0()); 
                          
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
                    // InternalPreprocess.g:390:2: this_NewLineLine_1= ruleNewLineLine
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGroupOptTemp1Access().getNewLineLineParserRuleCall_1()); 
                          
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
                    // InternalPreprocess.g:406:2: this_Code_2= ruleCode
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGroupOptTemp1Access().getCodeParserRuleCall_2()); 
                          
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
    // $ANTLR end "ruleGroupOptTemp1"


    // $ANTLR start "entryRuleGroupOptTemp2"
    // InternalPreprocess.g:429:1: entryRuleGroupOptTemp2 returns [EObject current=null] : iv_ruleGroupOptTemp2= ruleGroupOptTemp2 EOF ;
    public final EObject entryRuleGroupOptTemp2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOptTemp2 = null;


        try {
            // InternalPreprocess.g:430:2: (iv_ruleGroupOptTemp2= ruleGroupOptTemp2 EOF )
            // InternalPreprocess.g:431:2: iv_ruleGroupOptTemp2= ruleGroupOptTemp2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGroupOptTemp2Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGroupOptTemp2=ruleGroupOptTemp2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGroupOptTemp2; 
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
    // $ANTLR end "entryRuleGroupOptTemp2"


    // $ANTLR start "ruleGroupOptTemp2"
    // InternalPreprocess.g:438:1: ruleGroupOptTemp2 returns [EObject current=null] : (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_Code_1= ruleCode ) ;
    public final EObject ruleGroupOptTemp2() throws RecognitionException {
        EObject current = null;

        EObject this_PreprocessorDirectives_0 = null;

        EObject this_Code_1 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:444:7: ( (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_Code_1= ruleCode ) )
            // InternalPreprocess.g:446:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_Code_1= ruleCode )
            {
            // InternalPreprocess.g:446:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_Code_1= ruleCode )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalPreprocess.g:448:2: this_PreprocessorDirectives_0= rulePreprocessorDirectives
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGroupOptTemp2Access().getPreprocessorDirectivesParserRuleCall_0()); 
                          
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
                    // InternalPreprocess.g:464:2: this_Code_1= ruleCode
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGroupOptTemp2Access().getCodeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Code_1=ruleCode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Code_1; 
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
    // $ANTLR end "ruleGroupOptTemp2"


    // $ANTLR start "entryRulePreprocessorDirectives"
    // InternalPreprocess.g:487:1: entryRulePreprocessorDirectives returns [EObject current=null] : iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF ;
    public final EObject entryRulePreprocessorDirectives() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreprocessorDirectives = null;


        try {
            // InternalPreprocess.g:488:2: (iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF )
            // InternalPreprocess.g:489:2: iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF
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
    // InternalPreprocess.g:496:1: rulePreprocessorDirectives returns [EObject current=null] : ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) ) ) ;
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
            // InternalPreprocess.g:502:7: ( ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) ) ) )
            // InternalPreprocess.g:504:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) ) )
            {
            // InternalPreprocess.g:504:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) ) )
            // InternalPreprocess.g:505:1: () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) )
            {
            // InternalPreprocess.g:505:1: ()
            // InternalPreprocess.g:506:2: 
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

            // InternalPreprocess.g:517:1: (this_WHITESPACE_1= RULE_WHITESPACE )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_WHITESPACE) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalPreprocess.g:517:2: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getPreprocessorDirectivesAccess().getWHITESPACETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_2, grammarAccess.getPreprocessorDirectivesAccess().getHASHTerminalRuleCall_2()); 
                  
            }
            // InternalPreprocess.g:531:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_WHITESPACE) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalPreprocess.g:531:2: this_WHITESPACE_3= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_3, grammarAccess.getPreprocessorDirectivesAccess().getWHITESPACETerminalRuleCall_3()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalPreprocess.g:538:1: ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) )
            int alt8=8;
            switch ( input.LA(1) ) {
            case RULE_INCLUDE:
                {
                alt8=1;
                }
                break;
            case RULE_DEFINE:
                {
                alt8=2;
                }
                break;
            case RULE_ERROR:
                {
                alt8=3;
                }
                break;
            case RULE_WARNING:
                {
                alt8=4;
                }
                break;
            case RULE_UNDEF:
                {
                alt8=5;
                }
                break;
            case RULE_IF:
            case RULE_IFDEF:
            case RULE_IFNOTDEF:
                {
                alt8=6;
                }
                break;
            case RULE_PRAGMA:
                {
                alt8=7;
                }
                break;
            case EOF:
            case RULE_NEWLINE:
                {
                alt8=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalPreprocess.g:539:1: ( (lv_directive_4_0= ruleIncludeDirective ) )
                    {
                    // InternalPreprocess.g:539:1: ( (lv_directive_4_0= ruleIncludeDirective ) )
                    // InternalPreprocess.g:540:1: (lv_directive_4_0= ruleIncludeDirective )
                    {
                    // InternalPreprocess.g:540:1: (lv_directive_4_0= ruleIncludeDirective )
                    // InternalPreprocess.g:541:3: lv_directive_4_0= ruleIncludeDirective
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
                    // InternalPreprocess.g:561:1: ( (lv_directive_5_0= ruleDefineDirective ) )
                    {
                    // InternalPreprocess.g:561:1: ( (lv_directive_5_0= ruleDefineDirective ) )
                    // InternalPreprocess.g:562:1: (lv_directive_5_0= ruleDefineDirective )
                    {
                    // InternalPreprocess.g:562:1: (lv_directive_5_0= ruleDefineDirective )
                    // InternalPreprocess.g:563:3: lv_directive_5_0= ruleDefineDirective
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
                    // InternalPreprocess.g:583:1: ( (lv_directive_6_0= ruleErrorDirective ) )
                    {
                    // InternalPreprocess.g:583:1: ( (lv_directive_6_0= ruleErrorDirective ) )
                    // InternalPreprocess.g:584:1: (lv_directive_6_0= ruleErrorDirective )
                    {
                    // InternalPreprocess.g:584:1: (lv_directive_6_0= ruleErrorDirective )
                    // InternalPreprocess.g:585:3: lv_directive_6_0= ruleErrorDirective
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
                    // InternalPreprocess.g:605:1: ( (lv_directive_7_0= ruleWarningDirective ) )
                    {
                    // InternalPreprocess.g:605:1: ( (lv_directive_7_0= ruleWarningDirective ) )
                    // InternalPreprocess.g:606:1: (lv_directive_7_0= ruleWarningDirective )
                    {
                    // InternalPreprocess.g:606:1: (lv_directive_7_0= ruleWarningDirective )
                    // InternalPreprocess.g:607:3: lv_directive_7_0= ruleWarningDirective
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
                    // InternalPreprocess.g:627:1: ( (lv_directive_8_0= ruleUnDefineDirective ) )
                    {
                    // InternalPreprocess.g:627:1: ( (lv_directive_8_0= ruleUnDefineDirective ) )
                    // InternalPreprocess.g:628:1: (lv_directive_8_0= ruleUnDefineDirective )
                    {
                    // InternalPreprocess.g:628:1: (lv_directive_8_0= ruleUnDefineDirective )
                    // InternalPreprocess.g:629:3: lv_directive_8_0= ruleUnDefineDirective
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
                    // InternalPreprocess.g:649:1: ( (lv_directive_9_0= ruleConditionalDirective ) )
                    {
                    // InternalPreprocess.g:649:1: ( (lv_directive_9_0= ruleConditionalDirective ) )
                    // InternalPreprocess.g:650:1: (lv_directive_9_0= ruleConditionalDirective )
                    {
                    // InternalPreprocess.g:650:1: (lv_directive_9_0= ruleConditionalDirective )
                    // InternalPreprocess.g:651:3: lv_directive_9_0= ruleConditionalDirective
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
                    // InternalPreprocess.g:671:1: ( (lv_directive_10_0= rulePragmaDirective ) )
                    {
                    // InternalPreprocess.g:671:1: ( (lv_directive_10_0= rulePragmaDirective ) )
                    // InternalPreprocess.g:672:1: (lv_directive_10_0= rulePragmaDirective )
                    {
                    // InternalPreprocess.g:672:1: (lv_directive_10_0= rulePragmaDirective )
                    // InternalPreprocess.g:673:3: lv_directive_10_0= rulePragmaDirective
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
                    // InternalPreprocess.g:693:1: ( (lv_directive_11_0= ruleNullDirective ) )
                    {
                    // InternalPreprocess.g:693:1: ( (lv_directive_11_0= ruleNullDirective ) )
                    // InternalPreprocess.g:694:1: (lv_directive_11_0= ruleNullDirective )
                    {
                    // InternalPreprocess.g:694:1: (lv_directive_11_0= ruleNullDirective )
                    // InternalPreprocess.g:695:3: lv_directive_11_0= ruleNullDirective
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
    // InternalPreprocess.g:725:1: entryRuleIncludeDirective returns [EObject current=null] : iv_ruleIncludeDirective= ruleIncludeDirective EOF ;
    public final EObject entryRuleIncludeDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDirective = null;


        try {
            // InternalPreprocess.g:726:2: (iv_ruleIncludeDirective= ruleIncludeDirective EOF )
            // InternalPreprocess.g:727:2: iv_ruleIncludeDirective= ruleIncludeDirective EOF
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
    // InternalPreprocess.g:734:1: ruleIncludeDirective returns [EObject current=null] : ( () this_INCLUDE_1= RULE_INCLUDE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_string_3_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleIncludeDirective() throws RecognitionException {
        EObject current = null;

        Token this_INCLUDE_1=null;
        Token this_WHITESPACE_2=null;
        AntlrDatatypeRuleToken lv_string_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:740:7: ( ( () this_INCLUDE_1= RULE_INCLUDE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_string_3_0= ruleMyCodeLine ) ) ) )
            // InternalPreprocess.g:742:1: ( () this_INCLUDE_1= RULE_INCLUDE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_string_3_0= ruleMyCodeLine ) ) )
            {
            // InternalPreprocess.g:742:1: ( () this_INCLUDE_1= RULE_INCLUDE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_string_3_0= ruleMyCodeLine ) ) )
            // InternalPreprocess.g:743:1: () this_INCLUDE_1= RULE_INCLUDE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_string_3_0= ruleMyCodeLine ) )
            {
            // InternalPreprocess.g:743:1: ()
            // InternalPreprocess.g:744:2: 
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

            this_INCLUDE_1=(Token)match(input,RULE_INCLUDE,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INCLUDE_1, grammarAccess.getIncludeDirectiveAccess().getINCLUDETerminalRuleCall_1()); 
                  
            }
            // InternalPreprocess.g:762:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
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
            	    // InternalPreprocess.g:762:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIncludeDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:769:1: ( (lv_string_3_0= ruleMyCodeLine ) )
            // InternalPreprocess.g:770:1: (lv_string_3_0= ruleMyCodeLine )
            {
            // InternalPreprocess.g:770:1: (lv_string_3_0= ruleMyCodeLine )
            // InternalPreprocess.g:771:3: lv_string_3_0= ruleMyCodeLine
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
    // InternalPreprocess.g:799:1: entryRuleDefineDirective returns [EObject current=null] : iv_ruleDefineDirective= ruleDefineDirective EOF ;
    public final EObject entryRuleDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineDirective = null;


        try {
            // InternalPreprocess.g:800:2: (iv_ruleDefineDirective= ruleDefineDirective EOF )
            // InternalPreprocess.g:801:2: iv_ruleDefineDirective= ruleDefineDirective EOF
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
    // InternalPreprocess.g:808:1: ruleDefineDirective returns [EObject current=null] : (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro ) ;
    public final EObject ruleDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject this_DefineObjectMacro_0 = null;

        EObject this_DefineFunctionLikeMacro_1 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:814:7: ( (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro ) )
            // InternalPreprocess.g:816:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )
            {
            // InternalPreprocess.g:816:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // InternalPreprocess.g:818:2: this_DefineObjectMacro_0= ruleDefineObjectMacro
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
                    // InternalPreprocess.g:834:2: this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro
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
    // InternalPreprocess.g:857:1: entryRuleDefineObjectMacro returns [EObject current=null] : iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF ;
    public final EObject entryRuleDefineObjectMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineObjectMacro = null;


        try {
            // InternalPreprocess.g:858:2: (iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF )
            // InternalPreprocess.g:859:2: iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF
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
    // InternalPreprocess.g:866:1: ruleDefineObjectMacro returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? ) ;
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
            // InternalPreprocess.g:872:7: ( ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? ) )
            // InternalPreprocess.g:874:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? )
            {
            // InternalPreprocess.g:874:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? )
            // InternalPreprocess.g:875:1: () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )?
            {
            // InternalPreprocess.g:875:1: ()
            // InternalPreprocess.g:876:2: 
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

            this_DEFINE_1=(Token)match(input,RULE_DEFINE,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DEFINE_1, grammarAccess.getDefineObjectMacroAccess().getDEFINETerminalRuleCall_1()); 
                  
            }
            // InternalPreprocess.g:894:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
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
            	    // InternalPreprocess.g:894:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getDefineObjectMacroAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:901:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:902:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:902:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:903:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
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

            // InternalPreprocess.g:922:1: ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_WHITESPACE) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalPreprocess.g:923:1: (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) )
                    {
                    // InternalPreprocess.g:923:1: (this_WHITESPACE_4= RULE_WHITESPACE )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_WHITESPACE) ) {
                            int LA12_2 = input.LA(2);

                            if ( (synpred19_InternalPreprocess()) ) {
                                alt12=1;
                            }


                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalPreprocess.g:923:2: this_WHITESPACE_4= RULE_WHITESPACE
                    	    {
                    	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_WHITESPACE_4, grammarAccess.getDefineObjectMacroAccess().getWHITESPACETerminalRuleCall_4_0()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    // InternalPreprocess.g:930:1: ( (lv_string_5_0= ruleMyDefineLine ) )
                    // InternalPreprocess.g:931:1: (lv_string_5_0= ruleMyDefineLine )
                    {
                    // InternalPreprocess.g:931:1: (lv_string_5_0= ruleMyDefineLine )
                    // InternalPreprocess.g:932:3: lv_string_5_0= ruleMyDefineLine
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
    // InternalPreprocess.g:962:1: entryRuleDefineFunctionLikeMacro returns [EObject current=null] : iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF ;
    public final EObject entryRuleDefineFunctionLikeMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineFunctionLikeMacro = null;


        try {
            // InternalPreprocess.g:963:2: (iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF )
            // InternalPreprocess.g:964:2: iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF
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
    // InternalPreprocess.g:971:1: ruleDefineFunctionLikeMacro returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WHITESPACE_8= RULE_WHITESPACE )+ ( (lv_string_9_0= ruleMyDefineLine ) ) ) ;
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
            // InternalPreprocess.g:977:7: ( ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WHITESPACE_8= RULE_WHITESPACE )+ ( (lv_string_9_0= ruleMyDefineLine ) ) ) )
            // InternalPreprocess.g:979:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WHITESPACE_8= RULE_WHITESPACE )+ ( (lv_string_9_0= ruleMyDefineLine ) ) )
            {
            // InternalPreprocess.g:979:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WHITESPACE_8= RULE_WHITESPACE )+ ( (lv_string_9_0= ruleMyDefineLine ) ) )
            // InternalPreprocess.g:980:1: () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN (this_WHITESPACE_8= RULE_WHITESPACE )+ ( (lv_string_9_0= ruleMyDefineLine ) )
            {
            // InternalPreprocess.g:980:1: ()
            // InternalPreprocess.g:981:2: 
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

            this_DEFINE_1=(Token)match(input,RULE_DEFINE,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DEFINE_1, grammarAccess.getDefineFunctionLikeMacroAccess().getDEFINETerminalRuleCall_1()); 
                  
            }
            // InternalPreprocess.g:999:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_WHITESPACE) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalPreprocess.g:999:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getDefineFunctionLikeMacroAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:1006:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:1007:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:1007:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:1008:3: lv_id_3_0= RULE_ID
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
            // InternalPreprocess.g:1034:1: (this_WHITESPACE_5= RULE_WHITESPACE )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_WHITESPACE) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalPreprocess.g:1034:2: this_WHITESPACE_5= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_5=(Token)match(input,RULE_WHITESPACE,FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_5, grammarAccess.getDefineFunctionLikeMacroAccess().getWHITESPACETerminalRuleCall_5()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // InternalPreprocess.g:1041:1: ( (lv_list_6_0= ruleIdentifierList ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalPreprocess.g:1042:1: (lv_list_6_0= ruleIdentifierList )
                    {
                    // InternalPreprocess.g:1042:1: (lv_list_6_0= ruleIdentifierList )
                    // InternalPreprocess.g:1043:3: lv_list_6_0= ruleIdentifierList
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

            this_SKW_RIGHTPAREN_7=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SKW_RIGHTPAREN_7, grammarAccess.getDefineFunctionLikeMacroAccess().getSKW_RIGHTPARENTerminalRuleCall_7()); 
                  
            }
            // InternalPreprocess.g:1069:1: (this_WHITESPACE_8= RULE_WHITESPACE )+
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
            	    // InternalPreprocess.g:1069:2: this_WHITESPACE_8= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_8=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_8, grammarAccess.getDefineFunctionLikeMacroAccess().getWHITESPACETerminalRuleCall_8()); 
            	          
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

            // InternalPreprocess.g:1076:1: ( (lv_string_9_0= ruleMyDefineLine ) )
            // InternalPreprocess.g:1077:1: (lv_string_9_0= ruleMyDefineLine )
            {
            // InternalPreprocess.g:1077:1: (lv_string_9_0= ruleMyDefineLine )
            // InternalPreprocess.g:1078:3: lv_string_9_0= ruleMyDefineLine
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
    // InternalPreprocess.g:1106:1: entryRuleIdentifierList returns [EObject current=null] : iv_ruleIdentifierList= ruleIdentifierList EOF ;
    public final EObject entryRuleIdentifierList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierList = null;


        try {
            // InternalPreprocess.g:1107:2: (iv_ruleIdentifierList= ruleIdentifierList EOF )
            // InternalPreprocess.g:1108:2: iv_ruleIdentifierList= ruleIdentifierList EOF
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
    // InternalPreprocess.g:1115:1: ruleIdentifierList returns [EObject current=null] : ( () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) )* ) ;
    public final EObject ruleIdentifierList() throws RecognitionException {
        EObject current = null;

        Token lv_id_1_0=null;
        Token this_SKW_COMMA_2=null;
        Token this_WHITESPACE_3=null;
        Token lv_id_4_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1121:7: ( ( () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) )* ) )
            // InternalPreprocess.g:1123:1: ( () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) )* )
            {
            // InternalPreprocess.g:1123:1: ( () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) )* )
            // InternalPreprocess.g:1124:1: () ( (lv_id_1_0= RULE_ID ) ) (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) )*
            {
            // InternalPreprocess.g:1124:1: ()
            // InternalPreprocess.g:1125:2: 
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

            // InternalPreprocess.g:1136:1: ( (lv_id_1_0= RULE_ID ) )
            // InternalPreprocess.g:1137:1: (lv_id_1_0= RULE_ID )
            {
            // InternalPreprocess.g:1137:1: (lv_id_1_0= RULE_ID )
            // InternalPreprocess.g:1138:3: lv_id_1_0= RULE_ID
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

            // InternalPreprocess.g:1157:1: (this_SKW_COMMA_2= RULE_SKW_COMMA (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_SKW_COMMA) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalPreprocess.g:1158:1: this_SKW_COMMA_2= RULE_SKW_COMMA (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) )
            	    {
            	    this_SKW_COMMA_2=(Token)match(input,RULE_SKW_COMMA,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_COMMA_2, grammarAccess.getIdentifierListAccess().getSKW_COMMATerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:1165:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==RULE_WHITESPACE) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // InternalPreprocess.g:1165:2: this_WHITESPACE_3= RULE_WHITESPACE
            	    	    {
            	    	    this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_10); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_WHITESPACE_3, grammarAccess.getIdentifierListAccess().getWHITESPACETerminalRuleCall_2_1()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop18;
            	        }
            	    } while (true);

            	    // InternalPreprocess.g:1172:1: ( (lv_id_4_0= RULE_ID ) )
            	    // InternalPreprocess.g:1173:1: (lv_id_4_0= RULE_ID )
            	    {
            	    // InternalPreprocess.g:1173:1: (lv_id_4_0= RULE_ID )
            	    // InternalPreprocess.g:1174:3: lv_id_4_0= RULE_ID
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
            	    break loop19;
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
    // InternalPreprocess.g:1204:1: entryRuleErrorDirective returns [EObject current=null] : iv_ruleErrorDirective= ruleErrorDirective EOF ;
    public final EObject entryRuleErrorDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorDirective = null;


        try {
            // InternalPreprocess.g:1205:2: (iv_ruleErrorDirective= ruleErrorDirective EOF )
            // InternalPreprocess.g:1206:2: iv_ruleErrorDirective= ruleErrorDirective EOF
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
    // InternalPreprocess.g:1213:1: ruleErrorDirective returns [EObject current=null] : ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleErrorDirective() throws RecognitionException {
        EObject current = null;

        Token this_ERROR_1=null;
        Token this_WHITESPACE_2=null;
        AntlrDatatypeRuleToken lv_msg_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1219:7: ( ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) ) )
            // InternalPreprocess.g:1221:1: ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) )
            {
            // InternalPreprocess.g:1221:1: ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) )
            // InternalPreprocess.g:1222:1: () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) )
            {
            // InternalPreprocess.g:1222:1: ()
            // InternalPreprocess.g:1223:2: 
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

            this_ERROR_1=(Token)match(input,RULE_ERROR,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ERROR_1, grammarAccess.getErrorDirectiveAccess().getERRORTerminalRuleCall_1()); 
                  
            }
            // InternalPreprocess.g:1241:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_WHITESPACE) ) {
                    int LA20_2 = input.LA(2);

                    if ( (synpred27_InternalPreprocess()) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // InternalPreprocess.g:1241:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getErrorDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:1248:1: ( (lv_msg_3_0= ruleMyCodeLine ) )
            // InternalPreprocess.g:1249:1: (lv_msg_3_0= ruleMyCodeLine )
            {
            // InternalPreprocess.g:1249:1: (lv_msg_3_0= ruleMyCodeLine )
            // InternalPreprocess.g:1250:3: lv_msg_3_0= ruleMyCodeLine
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
    // InternalPreprocess.g:1278:1: entryRuleWarningDirective returns [EObject current=null] : iv_ruleWarningDirective= ruleWarningDirective EOF ;
    public final EObject entryRuleWarningDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWarningDirective = null;


        try {
            // InternalPreprocess.g:1279:2: (iv_ruleWarningDirective= ruleWarningDirective EOF )
            // InternalPreprocess.g:1280:2: iv_ruleWarningDirective= ruleWarningDirective EOF
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
    // InternalPreprocess.g:1287:1: ruleWarningDirective returns [EObject current=null] : ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleWarningDirective() throws RecognitionException {
        EObject current = null;

        Token this_WARNING_1=null;
        Token this_WHITESPACE_2=null;
        AntlrDatatypeRuleToken lv_msg_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1293:7: ( ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) ) )
            // InternalPreprocess.g:1295:1: ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) )
            {
            // InternalPreprocess.g:1295:1: ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) ) )
            // InternalPreprocess.g:1296:1: () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_msg_3_0= ruleMyCodeLine ) )
            {
            // InternalPreprocess.g:1296:1: ()
            // InternalPreprocess.g:1297:2: 
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

            this_WARNING_1=(Token)match(input,RULE_WARNING,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_WARNING_1, grammarAccess.getWarningDirectiveAccess().getWARNINGTerminalRuleCall_1()); 
                  
            }
            // InternalPreprocess.g:1315:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_WHITESPACE) ) {
                    int LA21_2 = input.LA(2);

                    if ( (synpred28_InternalPreprocess()) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // InternalPreprocess.g:1315:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getWarningDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:1322:1: ( (lv_msg_3_0= ruleMyCodeLine ) )
            // InternalPreprocess.g:1323:1: (lv_msg_3_0= ruleMyCodeLine )
            {
            // InternalPreprocess.g:1323:1: (lv_msg_3_0= ruleMyCodeLine )
            // InternalPreprocess.g:1324:3: lv_msg_3_0= ruleMyCodeLine
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
    // InternalPreprocess.g:1352:1: entryRuleUnDefineDirective returns [EObject current=null] : iv_ruleUnDefineDirective= ruleUnDefineDirective EOF ;
    public final EObject entryRuleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnDefineDirective = null;


        try {
            // InternalPreprocess.g:1353:2: (iv_ruleUnDefineDirective= ruleUnDefineDirective EOF )
            // InternalPreprocess.g:1354:2: iv_ruleUnDefineDirective= ruleUnDefineDirective EOF
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
    // InternalPreprocess.g:1361:1: ruleUnDefineDirective returns [EObject current=null] : ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) ) ;
    public final EObject ruleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        Token this_UNDEF_1=null;
        Token this_WHITESPACE_2=null;
        Token lv_id_3_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1367:7: ( ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) ) )
            // InternalPreprocess.g:1369:1: ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) )
            {
            // InternalPreprocess.g:1369:1: ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) )
            // InternalPreprocess.g:1370:1: () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) )
            {
            // InternalPreprocess.g:1370:1: ()
            // InternalPreprocess.g:1371:2: 
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

            this_UNDEF_1=(Token)match(input,RULE_UNDEF,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_UNDEF_1, grammarAccess.getUnDefineDirectiveAccess().getUNDEFTerminalRuleCall_1()); 
                  
            }
            // InternalPreprocess.g:1389:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_WHITESPACE) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalPreprocess.g:1389:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getUnDefineDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:1396:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:1397:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:1397:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:1398:3: lv_id_3_0= RULE_ID
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
    // InternalPreprocess.g:1426:1: entryRuleConditionalDirective returns [EObject current=null] : iv_ruleConditionalDirective= ruleConditionalDirective EOF ;
    public final EObject entryRuleConditionalDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalDirective = null;


        try {
            // InternalPreprocess.g:1427:2: (iv_ruleConditionalDirective= ruleConditionalDirective EOF )
            // InternalPreprocess.g:1428:2: iv_ruleConditionalDirective= ruleConditionalDirective EOF
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
    // InternalPreprocess.g:1435:1: ruleConditionalDirective returns [EObject current=null] : ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* ) ;
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
            // InternalPreprocess.g:1441:7: ( ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* ) )
            // InternalPreprocess.g:1443:1: ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* )
            {
            // InternalPreprocess.g:1443:1: ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* )
            // InternalPreprocess.g:1444:1: () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )*
            {
            // InternalPreprocess.g:1444:1: ()
            // InternalPreprocess.g:1445:2: 
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

            // InternalPreprocess.g:1456:1: ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) )
            // InternalPreprocess.g:1457:1: ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) )
            {
            // InternalPreprocess.g:1457:1: ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) )
            // InternalPreprocess.g:1458:1: (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional )
            {
            // InternalPreprocess.g:1458:1: (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional )
            int alt23=3;
            switch ( input.LA(1) ) {
            case RULE_IF:
                {
                alt23=1;
                }
                break;
            case RULE_IFDEF:
                {
                alt23=2;
                }
                break;
            case RULE_IFNOTDEF:
                {
                alt23=3;
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
                    // InternalPreprocess.g:1459:3: lv_conditional_1_1= ruleIfConditional
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalDirectiveAccess().getConditionalIfConditionalParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
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
                    // InternalPreprocess.g:1474:8: lv_conditional_1_2= ruleIfDefConditional
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalDirectiveAccess().getConditionalIfDefConditionalParserRuleCall_1_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
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
                    // InternalPreprocess.g:1489:8: lv_conditional_1_3= ruleIfNotDefConditional
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalDirectiveAccess().getConditionalIfNotDefConditionalParserRuleCall_1_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
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

            // InternalPreprocess.g:1510:1: ( (lv_elifs_2_0= ruleElIfConditional ) )*
            loop24:
            do {
                int alt24=2;
                alt24 = dfa24.predict(input);
                switch (alt24) {
            	case 1 :
            	    // InternalPreprocess.g:1511:1: (lv_elifs_2_0= ruleElIfConditional )
            	    {
            	    // InternalPreprocess.g:1511:1: (lv_elifs_2_0= ruleElIfConditional )
            	    // InternalPreprocess.g:1512:3: lv_elifs_2_0= ruleElIfConditional
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConditionalDirectiveAccess().getElifsElIfConditionalParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_6);
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
            	    break loop24;
                }
            } while (true);

            // InternalPreprocess.g:1531:1: ( (lv_else_3_0= ruleElseConditional ) )?
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // InternalPreprocess.g:1532:1: (lv_else_3_0= ruleElseConditional )
                    {
                    // InternalPreprocess.g:1532:1: (lv_else_3_0= ruleElseConditional )
                    // InternalPreprocess.g:1533:3: lv_else_3_0= ruleElseConditional
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalDirectiveAccess().getElseElseConditionalParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
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

            // InternalPreprocess.g:1552:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_WHITESPACE) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalPreprocess.g:1552:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getConditionalDirectiveAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            this_HASH_5=(Token)match(input,RULE_HASH,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_5, grammarAccess.getConditionalDirectiveAccess().getHASHTerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:1566:1: (this_WHITESPACE_6= RULE_WHITESPACE )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_WHITESPACE) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalPreprocess.g:1566:2: this_WHITESPACE_6= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_6=(Token)match(input,RULE_WHITESPACE,FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_6, grammarAccess.getConditionalDirectiveAccess().getWHITESPACETerminalRuleCall_6()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            this_ENDIF_7=(Token)match(input,RULE_ENDIF,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ENDIF_7, grammarAccess.getConditionalDirectiveAccess().getENDIFTerminalRuleCall_7()); 
                  
            }
            // InternalPreprocess.g:1580:1: (this_WHITESPACE_8= RULE_WHITESPACE )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_WHITESPACE) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalPreprocess.g:1580:2: this_WHITESPACE_8= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_8=(Token)match(input,RULE_WHITESPACE,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_8, grammarAccess.getConditionalDirectiveAccess().getWHITESPACETerminalRuleCall_8()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // InternalPreprocess.g:1596:1: entryRuleIfConditional returns [EObject current=null] : iv_ruleIfConditional= ruleIfConditional EOF ;
    public final EObject entryRuleIfConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfConditional = null;


        try {
            // InternalPreprocess.g:1597:2: (iv_ruleIfConditional= ruleIfConditional EOF )
            // InternalPreprocess.g:1598:2: iv_ruleIfConditional= ruleIfConditional EOF
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
    // InternalPreprocess.g:1605:1: ruleIfConditional returns [EObject current=null] : ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) ;
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
            // InternalPreprocess.g:1611:7: ( ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:1613:1: ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:1613:1: ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:1614:1: () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:1614:1: ()
            // InternalPreprocess.g:1615:2: 
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

            this_IF_1=(Token)match(input,RULE_IF,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_IF_1, grammarAccess.getIfConditionalAccess().getIFTerminalRuleCall_1()); 
                  
            }
            // InternalPreprocess.g:1633:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_WHITESPACE) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalPreprocess.g:1633:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIfConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);

            // InternalPreprocess.g:1640:1: ( (lv_expression_3_0= ruleConstantExpression ) )
            // InternalPreprocess.g:1641:1: (lv_expression_3_0= ruleConstantExpression )
            {
            // InternalPreprocess.g:1641:1: (lv_expression_3_0= ruleConstantExpression )
            // InternalPreprocess.g:1642:3: lv_expression_3_0= ruleConstantExpression
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
            // InternalPreprocess.g:1668:1: ( (lv_group_5_0= ruleGroupOpt ) )
            // InternalPreprocess.g:1669:1: (lv_group_5_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:1669:1: (lv_group_5_0= ruleGroupOpt )
            // InternalPreprocess.g:1670:3: lv_group_5_0= ruleGroupOpt
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
    // InternalPreprocess.g:1698:1: entryRuleIfDefConditional returns [EObject current=null] : iv_ruleIfDefConditional= ruleIfDefConditional EOF ;
    public final EObject entryRuleIfDefConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfDefConditional = null;


        try {
            // InternalPreprocess.g:1699:2: (iv_ruleIfDefConditional= ruleIfDefConditional EOF )
            // InternalPreprocess.g:1700:2: iv_ruleIfDefConditional= ruleIfDefConditional EOF
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
    // InternalPreprocess.g:1707:1: ruleIfDefConditional returns [EObject current=null] : ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) ;
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
            // InternalPreprocess.g:1713:7: ( ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:1715:1: ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:1715:1: ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:1716:1: () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:1716:1: ()
            // InternalPreprocess.g:1717:2: 
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

            this_IFDEF_1=(Token)match(input,RULE_IFDEF,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_IFDEF_1, grammarAccess.getIfDefConditionalAccess().getIFDEFTerminalRuleCall_1()); 
                  
            }
            // InternalPreprocess.g:1735:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_WHITESPACE) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalPreprocess.g:1735:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIfDefConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:1742:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:1743:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:1743:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:1744:3: lv_id_3_0= RULE_ID
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
            // InternalPreprocess.g:1770:1: ( (lv_group_5_0= ruleGroupOpt ) )
            // InternalPreprocess.g:1771:1: (lv_group_5_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:1771:1: (lv_group_5_0= ruleGroupOpt )
            // InternalPreprocess.g:1772:3: lv_group_5_0= ruleGroupOpt
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
    // InternalPreprocess.g:1800:1: entryRuleIfNotDefConditional returns [EObject current=null] : iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF ;
    public final EObject entryRuleIfNotDefConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfNotDefConditional = null;


        try {
            // InternalPreprocess.g:1801:2: (iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF )
            // InternalPreprocess.g:1802:2: iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF
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
    // InternalPreprocess.g:1809:1: ruleIfNotDefConditional returns [EObject current=null] : ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) ;
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
            // InternalPreprocess.g:1815:7: ( ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:1817:1: ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:1817:1: ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:1818:1: () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) this_NEWLINE_4= RULE_NEWLINE ( (lv_group_5_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:1818:1: ()
            // InternalPreprocess.g:1819:2: 
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

            this_IFNOTDEF_1=(Token)match(input,RULE_IFNOTDEF,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_IFNOTDEF_1, grammarAccess.getIfNotDefConditionalAccess().getIFNOTDEFTerminalRuleCall_1()); 
                  
            }
            // InternalPreprocess.g:1837:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
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
            	    // InternalPreprocess.g:1837:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIfNotDefConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:1844:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:1845:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:1845:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:1846:3: lv_id_3_0= RULE_ID
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
            // InternalPreprocess.g:1872:1: ( (lv_group_5_0= ruleGroupOpt ) )
            // InternalPreprocess.g:1873:1: (lv_group_5_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:1873:1: (lv_group_5_0= ruleGroupOpt )
            // InternalPreprocess.g:1874:3: lv_group_5_0= ruleGroupOpt
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
    // InternalPreprocess.g:1902:1: entryRuleElIfConditional returns [EObject current=null] : iv_ruleElIfConditional= ruleElIfConditional EOF ;
    public final EObject entryRuleElIfConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElIfConditional = null;


        try {
            // InternalPreprocess.g:1903:2: (iv_ruleElIfConditional= ruleElIfConditional EOF )
            // InternalPreprocess.g:1904:2: iv_ruleElIfConditional= ruleElIfConditional EOF
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
    // InternalPreprocess.g:1911:1: ruleElIfConditional returns [EObject current=null] : ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) this_NEWLINE_7= RULE_NEWLINE ( (lv_group_8_0= ruleGroupOpt ) ) ) ;
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
            // InternalPreprocess.g:1917:7: ( ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) this_NEWLINE_7= RULE_NEWLINE ( (lv_group_8_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:1919:1: ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) this_NEWLINE_7= RULE_NEWLINE ( (lv_group_8_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:1919:1: ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) this_NEWLINE_7= RULE_NEWLINE ( (lv_group_8_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:1920:1: () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) this_NEWLINE_7= RULE_NEWLINE ( (lv_group_8_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:1920:1: ()
            // InternalPreprocess.g:1921:2: 
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

            // InternalPreprocess.g:1932:1: ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF )
            // InternalPreprocess.g:1933:1: (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF
            {
            // InternalPreprocess.g:1933:1: (this_WHITESPACE_1= RULE_WHITESPACE )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_WHITESPACE) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalPreprocess.g:1933:2: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_1_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_2, grammarAccess.getElIfConditionalAccess().getHASHTerminalRuleCall_1_1()); 
                  
            }
            // InternalPreprocess.g:1947:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_WHITESPACE) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalPreprocess.g:1947:2: this_WHITESPACE_3= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_3, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_1_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            this_ELIF_4=(Token)match(input,RULE_ELIF,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ELIF_4, grammarAccess.getElIfConditionalAccess().getELIFTerminalRuleCall_1_3()); 
                  
            }

            }

            // InternalPreprocess.g:1963:1: (this_WHITESPACE_5= RULE_WHITESPACE )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_WHITESPACE) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalPreprocess.g:1963:2: this_WHITESPACE_5= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_5=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_5, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);

            // InternalPreprocess.g:1970:1: ( (lv_expression_6_0= ruleConstantExpression ) )
            // InternalPreprocess.g:1971:1: (lv_expression_6_0= ruleConstantExpression )
            {
            // InternalPreprocess.g:1971:1: (lv_expression_6_0= ruleConstantExpression )
            // InternalPreprocess.g:1972:3: lv_expression_6_0= ruleConstantExpression
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
            // InternalPreprocess.g:1998:1: ( (lv_group_8_0= ruleGroupOpt ) )
            // InternalPreprocess.g:1999:1: (lv_group_8_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:1999:1: (lv_group_8_0= ruleGroupOpt )
            // InternalPreprocess.g:2000:3: lv_group_8_0= ruleGroupOpt
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
    // InternalPreprocess.g:2028:1: entryRuleElseConditional returns [EObject current=null] : iv_ruleElseConditional= ruleElseConditional EOF ;
    public final EObject entryRuleElseConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseConditional = null;


        try {
            // InternalPreprocess.g:2029:2: (iv_ruleElseConditional= ruleElseConditional EOF )
            // InternalPreprocess.g:2030:2: iv_ruleElseConditional= ruleElseConditional EOF
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
    // InternalPreprocess.g:2037:1: ruleElseConditional returns [EObject current=null] : ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) ;
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
            // InternalPreprocess.g:2043:7: ( ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:2045:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:2045:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:2046:1: () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:2046:1: ()
            // InternalPreprocess.g:2047:2: 
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

            // InternalPreprocess.g:2058:1: (this_WHITESPACE_1= RULE_WHITESPACE )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_WHITESPACE) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalPreprocess.g:2058:2: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getElseConditionalAccess().getWHITESPACETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_2, grammarAccess.getElseConditionalAccess().getHASHTerminalRuleCall_2()); 
                  
            }
            // InternalPreprocess.g:2072:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_WHITESPACE) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalPreprocess.g:2072:2: this_WHITESPACE_3= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_3, grammarAccess.getElseConditionalAccess().getWHITESPACETerminalRuleCall_3()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop36;
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
            // InternalPreprocess.g:2093:1: ( (lv_group_6_0= ruleGroupOpt ) )
            // InternalPreprocess.g:2094:1: (lv_group_6_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:2094:1: (lv_group_6_0= ruleGroupOpt )
            // InternalPreprocess.g:2095:3: lv_group_6_0= ruleGroupOpt
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
    // InternalPreprocess.g:2123:1: entryRulePragmaDirective returns [EObject current=null] : iv_rulePragmaDirective= rulePragmaDirective EOF ;
    public final EObject entryRulePragmaDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePragmaDirective = null;


        try {
            // InternalPreprocess.g:2124:2: (iv_rulePragmaDirective= rulePragmaDirective EOF )
            // InternalPreprocess.g:2125:2: iv_rulePragmaDirective= rulePragmaDirective EOF
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
    // InternalPreprocess.g:2132:1: rulePragmaDirective returns [EObject current=null] : ( () this_PRAGMA_1= RULE_PRAGMA ) ;
    public final EObject rulePragmaDirective() throws RecognitionException {
        EObject current = null;

        Token this_PRAGMA_1=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2138:7: ( ( () this_PRAGMA_1= RULE_PRAGMA ) )
            // InternalPreprocess.g:2140:1: ( () this_PRAGMA_1= RULE_PRAGMA )
            {
            // InternalPreprocess.g:2140:1: ( () this_PRAGMA_1= RULE_PRAGMA )
            // InternalPreprocess.g:2141:1: () this_PRAGMA_1= RULE_PRAGMA
            {
            // InternalPreprocess.g:2141:1: ()
            // InternalPreprocess.g:2142:2: 
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
    // InternalPreprocess.g:2169:1: entryRuleNullDirective returns [EObject current=null] : iv_ruleNullDirective= ruleNullDirective EOF ;
    public final EObject entryRuleNullDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullDirective = null;


        try {
            // InternalPreprocess.g:2170:2: (iv_ruleNullDirective= ruleNullDirective EOF )
            // InternalPreprocess.g:2171:2: iv_ruleNullDirective= ruleNullDirective EOF
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
    // InternalPreprocess.g:2178:1: ruleNullDirective returns [EObject current=null] : () ;
    public final EObject ruleNullDirective() throws RecognitionException {
        EObject current = null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2184:7: ( () )
            // InternalPreprocess.g:2186:1: ()
            {
            // InternalPreprocess.g:2186:1: ()
            // InternalPreprocess.g:2187:2: 
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
    // InternalPreprocess.g:2205:1: entryRuleNewLineLine returns [EObject current=null] : iv_ruleNewLineLine= ruleNewLineLine EOF ;
    public final EObject entryRuleNewLineLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewLineLine = null;


        try {
            // InternalPreprocess.g:2206:2: (iv_ruleNewLineLine= ruleNewLineLine EOF )
            // InternalPreprocess.g:2207:2: iv_ruleNewLineLine= ruleNewLineLine EOF
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
    // InternalPreprocess.g:2214:1: ruleNewLineLine returns [EObject current=null] : () ;
    public final EObject ruleNewLineLine() throws RecognitionException {
        EObject current = null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2220:7: ( () )
            // InternalPreprocess.g:2222:1: ()
            {
            // InternalPreprocess.g:2222:1: ()
            // InternalPreprocess.g:2223:2: 
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
    // InternalPreprocess.g:2241:1: entryRuleCode returns [EObject current=null] : iv_ruleCode= ruleCode EOF ;
    public final EObject entryRuleCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCode = null;


        try {
            // InternalPreprocess.g:2242:2: (iv_ruleCode= ruleCode EOF )
            // InternalPreprocess.g:2243:2: iv_ruleCode= ruleCode EOF
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
    // InternalPreprocess.g:2250:1: ruleCode returns [EObject current=null] : ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) ) ;
    public final EObject ruleCode() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_code_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2256:7: ( ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) ) )
            // InternalPreprocess.g:2258:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) )
            {
            // InternalPreprocess.g:2258:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) )
            // InternalPreprocess.g:2259:1: () ( (lv_code_1_0= ruleMyCodeLineExtended ) )
            {
            // InternalPreprocess.g:2259:1: ()
            // InternalPreprocess.g:2260:2: 
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

            // InternalPreprocess.g:2271:1: ( (lv_code_1_0= ruleMyCodeLineExtended ) )
            // InternalPreprocess.g:2272:1: (lv_code_1_0= ruleMyCodeLineExtended )
            {
            // InternalPreprocess.g:2272:1: (lv_code_1_0= ruleMyCodeLineExtended )
            // InternalPreprocess.g:2273:3: lv_code_1_0= ruleMyCodeLineExtended
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
    // InternalPreprocess.g:2301:1: entryRuleMyCode returns [String current=null] : iv_ruleMyCode= ruleMyCode EOF ;
    public final String entryRuleMyCode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCode = null;


        try {
            // InternalPreprocess.g:2302:2: (iv_ruleMyCode= ruleMyCode EOF )
            // InternalPreprocess.g:2303:2: iv_ruleMyCode= ruleMyCode EOF
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
    // InternalPreprocess.g:2310:1: ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_SpecialKeywords_11= ruleSpecialKeywords | this_Constant1_12= ruleConstant1 ) ;
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
            // InternalPreprocess.g:2313:28: ( (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_SpecialKeywords_11= ruleSpecialKeywords | this_Constant1_12= ruleConstant1 ) )
            // InternalPreprocess.g:2314:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_SpecialKeywords_11= ruleSpecialKeywords | this_Constant1_12= ruleConstant1 )
            {
            // InternalPreprocess.g:2314:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_SpecialKeywords_11= ruleSpecialKeywords | this_Constant1_12= ruleConstant1 )
            int alt37=13;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt37=1;
                }
                break;
            case RULE_SPECIAL:
                {
                alt37=2;
                }
                break;
            case RULE_INCLUDE:
                {
                alt37=3;
                }
                break;
            case RULE_DEFINE:
                {
                alt37=4;
                }
                break;
            case RULE_ERROR:
                {
                alt37=5;
                }
                break;
            case RULE_PRAGMA:
                {
                alt37=6;
                }
                break;
            case RULE_IFDEF:
                {
                alt37=7;
                }
                break;
            case RULE_ENDIF:
                {
                alt37=8;
                }
                break;
            case RULE_IFNOTDEF:
                {
                alt37=9;
                }
                break;
            case RULE_IF:
                {
                alt37=10;
                }
                break;
            case RULE_DEFINED:
                {
                alt37=11;
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
                alt37=12;
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
                alt37=13;
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
                    // InternalPreprocess.g:2314:6: this_ID_0= RULE_ID
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
                    // InternalPreprocess.g:2322:10: this_SPECIAL_1= RULE_SPECIAL
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
                    // InternalPreprocess.g:2330:10: this_INCLUDE_2= RULE_INCLUDE
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
                    // InternalPreprocess.g:2338:10: this_DEFINE_3= RULE_DEFINE
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
                    // InternalPreprocess.g:2346:10: this_ERROR_4= RULE_ERROR
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
                    // InternalPreprocess.g:2354:10: this_PRAGMA_5= RULE_PRAGMA
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
                    // InternalPreprocess.g:2362:10: this_IFDEF_6= RULE_IFDEF
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
                    // InternalPreprocess.g:2370:10: this_ENDIF_7= RULE_ENDIF
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
                    // InternalPreprocess.g:2378:10: this_IFNOTDEF_8= RULE_IFNOTDEF
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
                    // InternalPreprocess.g:2386:10: this_IF_9= RULE_IF
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
                    // InternalPreprocess.g:2394:10: this_DEFINED_10= RULE_DEFINED
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
                    // InternalPreprocess.g:2403:5: this_SpecialKeywords_11= ruleSpecialKeywords
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
                    // InternalPreprocess.g:2415:5: this_Constant1_12= ruleConstant1
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
    // InternalPreprocess.g:2433:1: entryRuleMyDefineLine returns [String current=null] : iv_ruleMyDefineLine= ruleMyDefineLine EOF ;
    public final String entryRuleMyDefineLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyDefineLine = null;


        try {
            // InternalPreprocess.g:2434:2: (iv_ruleMyDefineLine= ruleMyDefineLine EOF )
            // InternalPreprocess.g:2435:2: iv_ruleMyDefineLine= ruleMyDefineLine EOF
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
    // InternalPreprocess.g:2442:1: ruleMyDefineLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_HASH_2= RULE_HASH )* ;
    public final AntlrDatatypeRuleToken ruleMyDefineLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_1=null;
        Token this_HASH_2=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2445:28: ( (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_HASH_2= RULE_HASH )* )
            // InternalPreprocess.g:2446:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_HASH_2= RULE_HASH )*
            {
            // InternalPreprocess.g:2446:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_HASH_2= RULE_HASH )*
            loop38:
            do {
                int alt38=4;
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
                    alt38=1;
                    }
                    break;
                case RULE_WHITESPACE:
                    {
                    alt38=2;
                    }
                    break;
                case RULE_HASH:
                    {
                    alt38=3;
                    }
                    break;

                }

                switch (alt38) {
            	case 1 :
            	    // InternalPreprocess.g:2447:5: this_MyCode_0= ruleMyCode
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
            	    // InternalPreprocess.g:2458:10: this_WHITESPACE_1= RULE_WHITESPACE
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
            	    // InternalPreprocess.g:2466:10: this_HASH_2= RULE_HASH
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
            	    break loop38;
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
    // InternalPreprocess.g:2481:1: entryRuleMyCodeLine returns [String current=null] : iv_ruleMyCodeLine= ruleMyCodeLine EOF ;
    public final String entryRuleMyCodeLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLine = null;


        try {
            // InternalPreprocess.g:2482:2: (iv_ruleMyCodeLine= ruleMyCodeLine EOF )
            // InternalPreprocess.g:2483:2: iv_ruleMyCodeLine= ruleMyCodeLine EOF
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
    // InternalPreprocess.g:2490:1: ruleMyCodeLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+ ;
    public final AntlrDatatypeRuleToken ruleMyCodeLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_1=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2493:28: ( (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+ )
            // InternalPreprocess.g:2494:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+
            {
            // InternalPreprocess.g:2494:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+
            int cnt39=0;
            loop39:
            do {
                int alt39=3;
                alt39 = dfa39.predict(input);
                switch (alt39) {
            	case 1 :
            	    // InternalPreprocess.g:2495:5: this_MyCode_0= ruleMyCode
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMyCodeLineAccess().getMyCodeParserRuleCall_0()); 
            	          
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
            	    // InternalPreprocess.g:2506:10: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WHITESPACE_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getMyCodeLineAccess().getWHITESPACETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt39 >= 1 ) break loop39;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(39, input);
                        throw eee;
                }
                cnt39++;
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
    // InternalPreprocess.g:2521:1: entryRuleMyCodeLineExtended returns [String current=null] : iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF ;
    public final String entryRuleMyCodeLineExtended() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtended = null;


        try {
            // InternalPreprocess.g:2522:2: (iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF )
            // InternalPreprocess.g:2523:2: iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF
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
    // InternalPreprocess.g:2530:1: ruleMyCodeLineExtended returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal ) ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtended() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_MyCodeLineExtendedWSOnly_0 = null;

        AntlrDatatypeRuleToken this_MyCodeLineExtendedNormal_1 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2533:28: ( (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal ) )
            // InternalPreprocess.g:2534:1: (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal )
            {
            // InternalPreprocess.g:2534:1: (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal )
            int alt40=2;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // InternalPreprocess.g:2535:5: this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeLineExtendedAccess().getMyCodeLineExtendedWSOnlyParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_MyCodeLineExtendedWSOnly_0=ruleMyCodeLineExtendedWSOnly();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_MyCodeLineExtendedWSOnly_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:2547:5: this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeLineExtendedAccess().getMyCodeLineExtendedNormalParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_MyCodeLineExtendedNormal_1=ruleMyCodeLineExtendedNormal();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_MyCodeLineExtendedNormal_1);
                          
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
    // $ANTLR end "ruleMyCodeLineExtended"


    // $ANTLR start "entryRuleMyCodeLineExtendedWSOnly"
    // InternalPreprocess.g:2565:1: entryRuleMyCodeLineExtendedWSOnly returns [String current=null] : iv_ruleMyCodeLineExtendedWSOnly= ruleMyCodeLineExtendedWSOnly EOF ;
    public final String entryRuleMyCodeLineExtendedWSOnly() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtendedWSOnly = null;


        try {
            // InternalPreprocess.g:2566:2: (iv_ruleMyCodeLineExtendedWSOnly= ruleMyCodeLineExtendedWSOnly EOF )
            // InternalPreprocess.g:2567:2: iv_ruleMyCodeLineExtendedWSOnly= ruleMyCodeLineExtendedWSOnly EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMyCodeLineExtendedWSOnlyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMyCodeLineExtendedWSOnly=ruleMyCodeLineExtendedWSOnly();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMyCodeLineExtendedWSOnly.getText(); 
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
    // $ANTLR end "entryRuleMyCodeLineExtendedWSOnly"


    // $ANTLR start "ruleMyCodeLineExtendedWSOnly"
    // InternalPreprocess.g:2574:1: ruleMyCodeLineExtendedWSOnly returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_WHITESPACE_0= RULE_WHITESPACE )+ ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtendedWSOnly() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_0=null;

         enterRule(); 
            
        try {
            // InternalPreprocess.g:2577:28: ( (this_WHITESPACE_0= RULE_WHITESPACE )+ )
            // InternalPreprocess.g:2578:1: (this_WHITESPACE_0= RULE_WHITESPACE )+
            {
            // InternalPreprocess.g:2578:1: (this_WHITESPACE_0= RULE_WHITESPACE )+
            int cnt41=0;
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_WHITESPACE) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalPreprocess.g:2578:6: this_WHITESPACE_0= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_0=(Token)match(input,RULE_WHITESPACE,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WHITESPACE_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_0, grammarAccess.getMyCodeLineExtendedWSOnlyAccess().getWHITESPACETerminalRuleCall()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt41 >= 1 ) break loop41;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(41, input);
                        throw eee;
                }
                cnt41++;
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
    // $ANTLR end "ruleMyCodeLineExtendedWSOnly"


    // $ANTLR start "entryRuleMyCodeLineExtendedNormal"
    // InternalPreprocess.g:2593:1: entryRuleMyCodeLineExtendedNormal returns [String current=null] : iv_ruleMyCodeLineExtendedNormal= ruleMyCodeLineExtendedNormal EOF ;
    public final String entryRuleMyCodeLineExtendedNormal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtendedNormal = null;


        try {
            // InternalPreprocess.g:2594:2: (iv_ruleMyCodeLineExtendedNormal= ruleMyCodeLineExtendedNormal EOF )
            // InternalPreprocess.g:2595:2: iv_ruleMyCodeLineExtendedNormal= ruleMyCodeLineExtendedNormal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMyCodeLineExtendedNormalRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMyCodeLineExtendedNormal=ruleMyCodeLineExtendedNormal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMyCodeLineExtendedNormal.getText(); 
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
    // $ANTLR end "entryRuleMyCodeLineExtendedNormal"


    // $ANTLR start "ruleMyCodeLineExtendedNormal"
    // InternalPreprocess.g:2602:1: ruleMyCodeLineExtendedNormal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* ) ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtendedNormal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_0=null;
        Token this_HASH_3=null;
        AntlrDatatypeRuleToken this_MyCode_1 = null;

        AntlrDatatypeRuleToken this_MyCodeLine_2 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2605:28: ( ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* ) )
            // InternalPreprocess.g:2606:1: ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )
            {
            // InternalPreprocess.g:2606:1: ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )
            // InternalPreprocess.g:2606:2: (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
            {
            // InternalPreprocess.g:2606:2: (this_WHITESPACE_0= RULE_WHITESPACE )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_WHITESPACE) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalPreprocess.g:2606:7: this_WHITESPACE_0= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_0=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WHITESPACE_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_0, grammarAccess.getMyCodeLineExtendedNormalAccess().getWHITESPACETerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            // InternalPreprocess.g:2613:3: (this_MyCode_1= ruleMyCode )+
            int cnt43=0;
            loop43:
            do {
                int alt43=2;
                alt43 = dfa43.predict(input);
                switch (alt43) {
            	case 1 :
            	    // InternalPreprocess.g:2614:5: this_MyCode_1= ruleMyCode
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMyCodeLineExtendedNormalAccess().getMyCodeParserRuleCall_1()); 
            	          
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

            	    }
            	    break;

            	default :
            	    if ( cnt43 >= 1 ) break loop43;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(43, input);
                        throw eee;
                }
                cnt43++;
            } while (true);

            // InternalPreprocess.g:2624:3: (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
            loop44:
            do {
                int alt44=3;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_WHITESPACE||(LA44_0>=RULE_INCLUDE && LA44_0<=RULE_ERROR)||(LA44_0>=RULE_ENDIF && LA44_0<=RULE_IFNOTDEF)||(LA44_0>=RULE_PRAGMA && LA44_0<=RULE_SKW_SINGLEQUOTE)) ) {
                    alt44=1;
                }
                else if ( (LA44_0==RULE_HASH) ) {
                    alt44=2;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalPreprocess.g:2625:5: this_MyCodeLine_2= ruleMyCodeLine
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMyCodeLineExtendedNormalAccess().getMyCodeLineParserRuleCall_2_0()); 
            	          
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
            	    // InternalPreprocess.g:2636:10: this_HASH_3= RULE_HASH
            	    {
            	    this_HASH_3=(Token)match(input,RULE_HASH,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_HASH_3);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_HASH_3, grammarAccess.getMyCodeLineExtendedNormalAccess().getHASHTerminalRuleCall_2_1()); 
            	          
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
    // $ANTLR end "ruleMyCodeLineExtendedNormal"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalPreprocess.g:2651:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalPreprocess.g:2652:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalPreprocess.g:2653:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalPreprocess.g:2660:1: rulePrimaryExpression returns [EObject current=null] : ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) ) ;
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
            // InternalPreprocess.g:2666:7: ( ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) ) )
            // InternalPreprocess.g:2668:1: ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) )
            {
            // InternalPreprocess.g:2668:1: ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) )
            // InternalPreprocess.g:2669:1: () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) )
            {
            // InternalPreprocess.g:2669:1: ()
            // InternalPreprocess.g:2670:2: 
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

            // InternalPreprocess.g:2681:1: ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) )
            int alt47=4;
            switch ( input.LA(1) ) {
            case RULE_DEFINED:
                {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==RULE_ID) ) {
                    alt47=1;
                }
                else if ( (LA47_1==RULE_SKW_LEFTPAREN) ) {
                    alt47=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                alt47=1;
                }
                break;
            case RULE_SKW_LEFTPAREN:
                {
                int LA47_3 = input.LA(2);

                if ( (LA47_3==RULE_SKW_LEFTPAREN||LA47_3==RULE_DEFINED||LA47_3==RULE_SKW_AND||(LA47_3>=RULE_SKW_PLUS && LA47_3<=RULE_SKW_STAR)||(LA47_3>=RULE_SKW_TILDE && LA47_3<=RULE_BIN_LITERAL)) ) {
                    alt47=4;
                }
                else if ( (LA47_3==RULE_ID) ) {
                    int LA47_7 = input.LA(3);

                    if ( (LA47_7==RULE_SKW_LEFTPAREN||LA47_7==RULE_SKW_QUESTION||(LA47_7>=RULE_SKW_OROR && LA47_7<=RULE_SKW_MOD)) ) {
                        alt47=4;
                    }
                    else if ( (LA47_7==RULE_SKW_RIGHTPAREN) ) {
                        int LA47_8 = input.LA(4);

                        if ( (synpred71_InternalPreprocess()) ) {
                            alt47=2;
                        }
                        else if ( (true) ) {
                            alt47=4;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 47, 8, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 7, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 3, input);

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
                alt47=3;
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
                    // InternalPreprocess.g:2682:1: ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) )
                    {
                    // InternalPreprocess.g:2682:1: ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) )
                    // InternalPreprocess.g:2683:1: ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) )
                    {
                    // InternalPreprocess.g:2683:1: ( (lv_defined_1_0= RULE_DEFINED ) )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==RULE_DEFINED) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // InternalPreprocess.g:2684:1: (lv_defined_1_0= RULE_DEFINED )
                            {
                            // InternalPreprocess.g:2684:1: (lv_defined_1_0= RULE_DEFINED )
                            // InternalPreprocess.g:2685:3: lv_defined_1_0= RULE_DEFINED
                            {
                            lv_defined_1_0=(Token)match(input,RULE_DEFINED,FOLLOW_20); if (state.failed) return current;
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

                    // InternalPreprocess.g:2704:1: ( (lv_id_2_0= RULE_ID ) )
                    // InternalPreprocess.g:2705:1: (lv_id_2_0= RULE_ID )
                    {
                    // InternalPreprocess.g:2705:1: (lv_id_2_0= RULE_ID )
                    // InternalPreprocess.g:2706:3: lv_id_2_0= RULE_ID
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
                    // InternalPreprocess.g:2728:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
                    {
                    // InternalPreprocess.g:2728:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
                    // InternalPreprocess.g:2729:1: ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN
                    {
                    // InternalPreprocess.g:2729:1: ( (lv_defined_3_0= RULE_DEFINED ) )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==RULE_DEFINED) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalPreprocess.g:2730:1: (lv_defined_3_0= RULE_DEFINED )
                            {
                            // InternalPreprocess.g:2730:1: (lv_defined_3_0= RULE_DEFINED )
                            // InternalPreprocess.g:2731:3: lv_defined_3_0= RULE_DEFINED
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

                    this_SKW_LEFTPAREN_4=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LEFTPAREN_4, grammarAccess.getPrimaryExpressionAccess().getSKW_LEFTPARENTerminalRuleCall_1_1_1()); 
                          
                    }
                    // InternalPreprocess.g:2757:1: ( (lv_id_5_0= RULE_ID ) )
                    // InternalPreprocess.g:2758:1: (lv_id_5_0= RULE_ID )
                    {
                    // InternalPreprocess.g:2758:1: (lv_id_5_0= RULE_ID )
                    // InternalPreprocess.g:2759:3: lv_id_5_0= RULE_ID
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
                    // InternalPreprocess.g:2788:1: ( (lv_const_7_0= ruleConstant1 ) )
                    {
                    // InternalPreprocess.g:2788:1: ( (lv_const_7_0= ruleConstant1 ) )
                    // InternalPreprocess.g:2789:1: (lv_const_7_0= ruleConstant1 )
                    {
                    // InternalPreprocess.g:2789:1: (lv_const_7_0= ruleConstant1 )
                    // InternalPreprocess.g:2790:3: lv_const_7_0= ruleConstant1
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
                    // InternalPreprocess.g:2810:1: (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN )
                    {
                    // InternalPreprocess.g:2810:1: (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN )
                    // InternalPreprocess.g:2811:1: this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN
                    {
                    this_SKW_LEFTPAREN_8=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LEFTPAREN_8, grammarAccess.getPrimaryExpressionAccess().getSKW_LEFTPARENTerminalRuleCall_1_3_0()); 
                          
                    }
                    // InternalPreprocess.g:2818:1: ( (lv_expr_9_0= ruleExpression ) )
                    // InternalPreprocess.g:2819:1: (lv_expr_9_0= ruleExpression )
                    {
                    // InternalPreprocess.g:2819:1: (lv_expr_9_0= ruleExpression )
                    // InternalPreprocess.g:2820:3: lv_expr_9_0= ruleExpression
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
    // InternalPreprocess.g:2859:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
        	
        try {
            // InternalPreprocess.g:2863:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalPreprocess.g:2864:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalPreprocess.g:2874:1: ruleExpression returns [EObject current=null] : ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         enterRule();
           		/*no init found*/
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
            
        try {
            // InternalPreprocess.g:2881:7: ( ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) ) )
            // InternalPreprocess.g:2883:1: ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) )
            {
            // InternalPreprocess.g:2883:1: ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) )
            // InternalPreprocess.g:2884:1: () ( (lv_expression_1_0= ruleConditionalExpression ) )
            {
            // InternalPreprocess.g:2884:1: ()
            // InternalPreprocess.g:2885:2: 
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

            // InternalPreprocess.g:2896:1: ( (lv_expression_1_0= ruleConditionalExpression ) )
            // InternalPreprocess.g:2897:1: (lv_expression_1_0= ruleConditionalExpression )
            {
            // InternalPreprocess.g:2897:1: (lv_expression_1_0= ruleConditionalExpression )
            // InternalPreprocess.g:2898:3: lv_expression_1_0= ruleConditionalExpression
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
    // InternalPreprocess.g:2929:1: entryRuleConstantExpression returns [EObject current=null] : iv_ruleConstantExpression= ruleConstantExpression EOF ;
    public final EObject entryRuleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantExpression = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
        	
        try {
            // InternalPreprocess.g:2933:2: (iv_ruleConstantExpression= ruleConstantExpression EOF )
            // InternalPreprocess.g:2934:2: iv_ruleConstantExpression= ruleConstantExpression EOF
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
    // InternalPreprocess.g:2944:1: ruleConstantExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) ) ;
    public final EObject ruleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;


         enterRule();
           		/*no init found*/
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
            
        try {
            // InternalPreprocess.g:2951:7: ( ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) ) )
            // InternalPreprocess.g:2953:1: ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) )
            {
            // InternalPreprocess.g:2953:1: ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) )
            // InternalPreprocess.g:2954:1: () ( (lv_expr_1_0= ruleConditionalExpression ) )
            {
            // InternalPreprocess.g:2954:1: ()
            // InternalPreprocess.g:2955:2: 
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

            // InternalPreprocess.g:2966:1: ( (lv_expr_1_0= ruleConditionalExpression ) )
            // InternalPreprocess.g:2967:1: (lv_expr_1_0= ruleConditionalExpression )
            {
            // InternalPreprocess.g:2967:1: (lv_expr_1_0= ruleConditionalExpression )
            // InternalPreprocess.g:2968:3: lv_expr_1_0= ruleConditionalExpression
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
    // InternalPreprocess.g:2999:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalPreprocess.g:3000:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalPreprocess.g:3001:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
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
    // InternalPreprocess.g:3008:1: ruleConditionalExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) ;
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
            // InternalPreprocess.g:3014:7: ( ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) )
            // InternalPreprocess.g:3016:1: ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
            {
            // InternalPreprocess.g:3016:1: ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
            // InternalPreprocess.g:3017:1: () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
            {
            // InternalPreprocess.g:3017:1: ()
            // InternalPreprocess.g:3018:2: 
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

            // InternalPreprocess.g:3029:1: ( (lv_expr_1_0= ruleLogicalOrExpression ) )
            // InternalPreprocess.g:3030:1: (lv_expr_1_0= ruleLogicalOrExpression )
            {
            // InternalPreprocess.g:3030:1: (lv_expr_1_0= ruleLogicalOrExpression )
            // InternalPreprocess.g:3031:3: lv_expr_1_0= ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExprLogicalOrExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_21);
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

            // InternalPreprocess.g:3050:1: (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_SKW_QUESTION) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalPreprocess.g:3051:1: this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) )
                    {
                    this_SKW_QUESTION_2=(Token)match(input,RULE_SKW_QUESTION,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_QUESTION_2, grammarAccess.getConditionalExpressionAccess().getSKW_QUESTIONTerminalRuleCall_2_0()); 
                          
                    }
                    // InternalPreprocess.g:3058:1: ( (lv_qExpr_3_0= ruleExpression ) )
                    // InternalPreprocess.g:3059:1: (lv_qExpr_3_0= ruleExpression )
                    {
                    // InternalPreprocess.g:3059:1: (lv_qExpr_3_0= ruleExpression )
                    // InternalPreprocess.g:3060:3: lv_qExpr_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getQExprExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_22);
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

                    this_SKW_COLON_4=(Token)match(input,RULE_SKW_COLON,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_COLON_4, grammarAccess.getConditionalExpressionAccess().getSKW_COLONTerminalRuleCall_2_2()); 
                          
                    }
                    // InternalPreprocess.g:3086:1: ( (lv_cExpr_5_0= ruleConditionalExpression ) )
                    // InternalPreprocess.g:3087:1: (lv_cExpr_5_0= ruleConditionalExpression )
                    {
                    // InternalPreprocess.g:3087:1: (lv_cExpr_5_0= ruleConditionalExpression )
                    // InternalPreprocess.g:3088:3: lv_cExpr_5_0= ruleConditionalExpression
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
    // InternalPreprocess.g:3118:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalPreprocess.g:3119:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalPreprocess.g:3120:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
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
    // InternalPreprocess.g:3127:1: ruleLogicalOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_OROR_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3133:7: ( ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalPreprocess.g:3135:1: ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalPreprocess.g:3135:1: ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalPreprocess.g:3136:1: () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )*
            {
            // InternalPreprocess.g:3136:1: ()
            // InternalPreprocess.g:3137:2: 
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

            // InternalPreprocess.g:3148:1: ( (lv_expr_1_0= ruleLogicalAndExpression ) )
            // InternalPreprocess.g:3149:1: (lv_expr_1_0= ruleLogicalAndExpression )
            {
            // InternalPreprocess.g:3149:1: (lv_expr_1_0= ruleLogicalAndExpression )
            // InternalPreprocess.g:3150:3: lv_expr_1_0= ruleLogicalAndExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getExprLogicalAndExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_23);
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

            // InternalPreprocess.g:3169:1: (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_SKW_OROR) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalPreprocess.g:3170:1: this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) )
            	    {
            	    this_SKW_OROR_2=(Token)match(input,RULE_SKW_OROR,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_OROR_2, grammarAccess.getLogicalOrExpressionAccess().getSKW_ORORTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3177:1: ( (lv_expr_3_0= ruleLogicalAndExpression ) )
            	    // InternalPreprocess.g:3178:1: (lv_expr_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalPreprocess.g:3178:1: (lv_expr_3_0= ruleLogicalAndExpression )
            	    // InternalPreprocess.g:3179:3: lv_expr_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getExprLogicalAndExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_23);
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
            	    break loop49;
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
    // InternalPreprocess.g:3209:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalPreprocess.g:3210:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalPreprocess.g:3211:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
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
    // InternalPreprocess.g:3218:1: ruleLogicalAndExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_ANDAND_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3224:7: ( ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* ) )
            // InternalPreprocess.g:3226:1: ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* )
            {
            // InternalPreprocess.g:3226:1: ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* )
            // InternalPreprocess.g:3227:1: () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )*
            {
            // InternalPreprocess.g:3227:1: ()
            // InternalPreprocess.g:3228:2: 
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

            // InternalPreprocess.g:3239:1: ( (lv_expr_1_0= ruleInclusiveOrExpression ) )
            // InternalPreprocess.g:3240:1: (lv_expr_1_0= ruleInclusiveOrExpression )
            {
            // InternalPreprocess.g:3240:1: (lv_expr_1_0= ruleInclusiveOrExpression )
            // InternalPreprocess.g:3241:3: lv_expr_1_0= ruleInclusiveOrExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getExprInclusiveOrExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_24);
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

            // InternalPreprocess.g:3260:1: (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_SKW_ANDAND) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalPreprocess.g:3261:1: this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) )
            	    {
            	    this_SKW_ANDAND_2=(Token)match(input,RULE_SKW_ANDAND,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_ANDAND_2, grammarAccess.getLogicalAndExpressionAccess().getSKW_ANDANDTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3268:1: ( (lv_expr_3_0= ruleInclusiveOrExpression ) )
            	    // InternalPreprocess.g:3269:1: (lv_expr_3_0= ruleInclusiveOrExpression )
            	    {
            	    // InternalPreprocess.g:3269:1: (lv_expr_3_0= ruleInclusiveOrExpression )
            	    // InternalPreprocess.g:3270:3: lv_expr_3_0= ruleInclusiveOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getExprInclusiveOrExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_24);
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
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleInclusiveOrExpression"
    // InternalPreprocess.g:3300:1: entryRuleInclusiveOrExpression returns [EObject current=null] : iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF ;
    public final EObject entryRuleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclusiveOrExpression = null;


        try {
            // InternalPreprocess.g:3301:2: (iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF )
            // InternalPreprocess.g:3302:2: iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF
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
    // InternalPreprocess.g:3309:1: ruleInclusiveOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* ) ;
    public final EObject ruleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_OR_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3315:7: ( ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* ) )
            // InternalPreprocess.g:3317:1: ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* )
            {
            // InternalPreprocess.g:3317:1: ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* )
            // InternalPreprocess.g:3318:1: () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )*
            {
            // InternalPreprocess.g:3318:1: ()
            // InternalPreprocess.g:3319:2: 
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

            // InternalPreprocess.g:3330:1: ( (lv_expr_1_0= ruleExclusiveOrExpression ) )
            // InternalPreprocess.g:3331:1: (lv_expr_1_0= ruleExclusiveOrExpression )
            {
            // InternalPreprocess.g:3331:1: (lv_expr_1_0= ruleExclusiveOrExpression )
            // InternalPreprocess.g:3332:3: lv_expr_1_0= ruleExclusiveOrExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExprExclusiveOrExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_25);
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

            // InternalPreprocess.g:3351:1: (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_SKW_OR) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalPreprocess.g:3352:1: this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) )
            	    {
            	    this_SKW_OR_2=(Token)match(input,RULE_SKW_OR,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_OR_2, grammarAccess.getInclusiveOrExpressionAccess().getSKW_ORTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3359:1: ( (lv_expr_3_0= ruleExclusiveOrExpression ) )
            	    // InternalPreprocess.g:3360:1: (lv_expr_3_0= ruleExclusiveOrExpression )
            	    {
            	    // InternalPreprocess.g:3360:1: (lv_expr_3_0= ruleExclusiveOrExpression )
            	    // InternalPreprocess.g:3361:3: lv_expr_3_0= ruleExclusiveOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExprExclusiveOrExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_25);
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
            	    break loop51;
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
    // InternalPreprocess.g:3391:1: entryRuleExclusiveOrExpression returns [EObject current=null] : iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF ;
    public final EObject entryRuleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusiveOrExpression = null;


        try {
            // InternalPreprocess.g:3392:2: (iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF )
            // InternalPreprocess.g:3393:2: iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF
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
    // InternalPreprocess.g:3400:1: ruleExclusiveOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_CARET_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3406:7: ( ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* ) )
            // InternalPreprocess.g:3408:1: ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* )
            {
            // InternalPreprocess.g:3408:1: ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* )
            // InternalPreprocess.g:3409:1: () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )*
            {
            // InternalPreprocess.g:3409:1: ()
            // InternalPreprocess.g:3410:2: 
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

            // InternalPreprocess.g:3421:1: ( (lv_expr_1_0= ruleAndExpression ) )
            // InternalPreprocess.g:3422:1: (lv_expr_1_0= ruleAndExpression )
            {
            // InternalPreprocess.g:3422:1: (lv_expr_1_0= ruleAndExpression )
            // InternalPreprocess.g:3423:3: lv_expr_1_0= ruleAndExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getExprAndExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_26);
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

            // InternalPreprocess.g:3442:1: (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_SKW_CARET) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalPreprocess.g:3443:1: this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) )
            	    {
            	    this_SKW_CARET_2=(Token)match(input,RULE_SKW_CARET,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_CARET_2, grammarAccess.getExclusiveOrExpressionAccess().getSKW_CARETTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3450:1: ( (lv_expr_3_0= ruleAndExpression ) )
            	    // InternalPreprocess.g:3451:1: (lv_expr_3_0= ruleAndExpression )
            	    {
            	    // InternalPreprocess.g:3451:1: (lv_expr_3_0= ruleAndExpression )
            	    // InternalPreprocess.g:3452:3: lv_expr_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getExprAndExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_26);
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
    // $ANTLR end "ruleExclusiveOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalPreprocess.g:3482:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalPreprocess.g:3483:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalPreprocess.g:3484:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalPreprocess.g:3491:1: ruleAndExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_AND_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3497:7: ( ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalPreprocess.g:3499:1: ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalPreprocess.g:3499:1: ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* )
            // InternalPreprocess.g:3500:1: () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )*
            {
            // InternalPreprocess.g:3500:1: ()
            // InternalPreprocess.g:3501:2: 
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

            // InternalPreprocess.g:3512:1: ( (lv_expr_1_0= ruleEqualityExpression ) )
            // InternalPreprocess.g:3513:1: (lv_expr_1_0= ruleEqualityExpression )
            {
            // InternalPreprocess.g:3513:1: (lv_expr_1_0= ruleEqualityExpression )
            // InternalPreprocess.g:3514:3: lv_expr_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAndExpressionAccess().getExprEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_27);
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

            // InternalPreprocess.g:3533:1: (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_SKW_AND) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalPreprocess.g:3534:1: this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) )
            	    {
            	    this_SKW_AND_2=(Token)match(input,RULE_SKW_AND,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_AND_2, grammarAccess.getAndExpressionAccess().getSKW_ANDTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3541:1: ( (lv_expr_3_0= ruleEqualityExpression ) )
            	    // InternalPreprocess.g:3542:1: (lv_expr_3_0= ruleEqualityExpression )
            	    {
            	    // InternalPreprocess.g:3542:1: (lv_expr_3_0= ruleEqualityExpression )
            	    // InternalPreprocess.g:3543:3: lv_expr_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExpressionAccess().getExprEqualityExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_27);
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
            	    break loop53;
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
    // InternalPreprocess.g:3573:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalPreprocess.g:3574:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalPreprocess.g:3575:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalPreprocess.g:3582:1: ruleEqualityExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3588:7: ( ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* ) )
            // InternalPreprocess.g:3590:1: ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* )
            {
            // InternalPreprocess.g:3590:1: ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* )
            // InternalPreprocess.g:3591:1: () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )*
            {
            // InternalPreprocess.g:3591:1: ()
            // InternalPreprocess.g:3592:2: 
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

            // InternalPreprocess.g:3603:1: ( (lv_expr_1_0= ruleRelationalExpression ) )
            // InternalPreprocess.g:3604:1: (lv_expr_1_0= ruleRelationalExpression )
            {
            // InternalPreprocess.g:3604:1: (lv_expr_1_0= ruleRelationalExpression )
            // InternalPreprocess.g:3605:3: lv_expr_1_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExprRelationalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_28);
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

            // InternalPreprocess.g:3624:1: ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( ((LA55_0>=RULE_SKW_EQUAL && LA55_0<=RULE_SKW_NOTEQUAL)) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalPreprocess.g:3625:1: ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) )
            	    {
            	    // InternalPreprocess.g:3625:1: ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) )
            	    int alt54=2;
            	    int LA54_0 = input.LA(1);

            	    if ( (LA54_0==RULE_SKW_EQUAL) ) {
            	        alt54=1;
            	    }
            	    else if ( (LA54_0==RULE_SKW_NOTEQUAL) ) {
            	        alt54=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 54, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt54) {
            	        case 1 :
            	            // InternalPreprocess.g:3626:1: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
            	            {
            	            // InternalPreprocess.g:3626:1: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
            	            // InternalPreprocess.g:3627:1: (lv_op_2_0= RULE_SKW_EQUAL )
            	            {
            	            // InternalPreprocess.g:3627:1: (lv_op_2_0= RULE_SKW_EQUAL )
            	            // InternalPreprocess.g:3628:3: lv_op_2_0= RULE_SKW_EQUAL
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_EQUAL,FOLLOW_9); if (state.failed) return current;
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
            	            // InternalPreprocess.g:3648:1: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
            	            {
            	            // InternalPreprocess.g:3648:1: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
            	            // InternalPreprocess.g:3649:1: (lv_op_3_0= RULE_SKW_NOTEQUAL )
            	            {
            	            // InternalPreprocess.g:3649:1: (lv_op_3_0= RULE_SKW_NOTEQUAL )
            	            // InternalPreprocess.g:3650:3: lv_op_3_0= RULE_SKW_NOTEQUAL
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_NOTEQUAL,FOLLOW_9); if (state.failed) return current;
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

            	    // InternalPreprocess.g:3671:1: ( (lv_expr_4_0= ruleRelationalExpression ) )
            	    // InternalPreprocess.g:3672:1: (lv_expr_4_0= ruleRelationalExpression )
            	    {
            	    // InternalPreprocess.g:3672:1: (lv_expr_4_0= ruleRelationalExpression )
            	    // InternalPreprocess.g:3673:3: lv_expr_4_0= ruleRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExprRelationalExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_28);
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
            	    break loop55;
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
    // InternalPreprocess.g:3703:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalPreprocess.g:3704:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalPreprocess.g:3705:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalPreprocess.g:3712:1: ruleRelationalExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* ) ;
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
            // InternalPreprocess.g:3718:7: ( ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* ) )
            // InternalPreprocess.g:3720:1: ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* )
            {
            // InternalPreprocess.g:3720:1: ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* )
            // InternalPreprocess.g:3721:1: () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )*
            {
            // InternalPreprocess.g:3721:1: ()
            // InternalPreprocess.g:3722:2: 
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

            // InternalPreprocess.g:3733:1: ( (lv_expr_1_0= ruleShiftExpression ) )
            // InternalPreprocess.g:3734:1: (lv_expr_1_0= ruleShiftExpression )
            {
            // InternalPreprocess.g:3734:1: (lv_expr_1_0= ruleShiftExpression )
            // InternalPreprocess.g:3735:3: lv_expr_1_0= ruleShiftExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExprShiftExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_29);
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

            // InternalPreprocess.g:3754:1: ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( ((LA57_0>=RULE_SKW_LESS && LA57_0<=RULE_SKW_GREATEREQUAL)) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalPreprocess.g:3755:1: ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) )
            	    {
            	    // InternalPreprocess.g:3755:1: ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) )
            	    int alt56=4;
            	    switch ( input.LA(1) ) {
            	    case RULE_SKW_LESS:
            	        {
            	        alt56=1;
            	        }
            	        break;
            	    case RULE_SKW_GREATER:
            	        {
            	        alt56=2;
            	        }
            	        break;
            	    case RULE_SKW_LESSEQUAL:
            	        {
            	        alt56=3;
            	        }
            	        break;
            	    case RULE_SKW_GREATEREQUAL:
            	        {
            	        alt56=4;
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
            	            // InternalPreprocess.g:3756:1: ( (lv_op_2_0= RULE_SKW_LESS ) )
            	            {
            	            // InternalPreprocess.g:3756:1: ( (lv_op_2_0= RULE_SKW_LESS ) )
            	            // InternalPreprocess.g:3757:1: (lv_op_2_0= RULE_SKW_LESS )
            	            {
            	            // InternalPreprocess.g:3757:1: (lv_op_2_0= RULE_SKW_LESS )
            	            // InternalPreprocess.g:3758:3: lv_op_2_0= RULE_SKW_LESS
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_LESS,FOLLOW_9); if (state.failed) return current;
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
            	            // InternalPreprocess.g:3778:1: ( (lv_op_3_0= RULE_SKW_GREATER ) )
            	            {
            	            // InternalPreprocess.g:3778:1: ( (lv_op_3_0= RULE_SKW_GREATER ) )
            	            // InternalPreprocess.g:3779:1: (lv_op_3_0= RULE_SKW_GREATER )
            	            {
            	            // InternalPreprocess.g:3779:1: (lv_op_3_0= RULE_SKW_GREATER )
            	            // InternalPreprocess.g:3780:3: lv_op_3_0= RULE_SKW_GREATER
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_GREATER,FOLLOW_9); if (state.failed) return current;
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
            	            // InternalPreprocess.g:3800:1: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
            	            {
            	            // InternalPreprocess.g:3800:1: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
            	            // InternalPreprocess.g:3801:1: (lv_op_4_0= RULE_SKW_LESSEQUAL )
            	            {
            	            // InternalPreprocess.g:3801:1: (lv_op_4_0= RULE_SKW_LESSEQUAL )
            	            // InternalPreprocess.g:3802:3: lv_op_4_0= RULE_SKW_LESSEQUAL
            	            {
            	            lv_op_4_0=(Token)match(input,RULE_SKW_LESSEQUAL,FOLLOW_9); if (state.failed) return current;
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
            	            // InternalPreprocess.g:3822:1: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
            	            {
            	            // InternalPreprocess.g:3822:1: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
            	            // InternalPreprocess.g:3823:1: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
            	            {
            	            // InternalPreprocess.g:3823:1: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
            	            // InternalPreprocess.g:3824:3: lv_op_5_0= RULE_SKW_GREATEREQUAL
            	            {
            	            lv_op_5_0=(Token)match(input,RULE_SKW_GREATEREQUAL,FOLLOW_9); if (state.failed) return current;
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

            	    // InternalPreprocess.g:3845:1: ( (lv_expr_6_0= ruleShiftExpression ) )
            	    // InternalPreprocess.g:3846:1: (lv_expr_6_0= ruleShiftExpression )
            	    {
            	    // InternalPreprocess.g:3846:1: (lv_expr_6_0= ruleShiftExpression )
            	    // InternalPreprocess.g:3847:3: lv_expr_6_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExprShiftExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
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
            	    break loop57;
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
    // InternalPreprocess.g:3877:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalPreprocess.g:3878:2: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalPreprocess.g:3879:2: iv_ruleShiftExpression= ruleShiftExpression EOF
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
    // InternalPreprocess.g:3886:1: ruleShiftExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3892:7: ( ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* ) )
            // InternalPreprocess.g:3894:1: ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalPreprocess.g:3894:1: ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* )
            // InternalPreprocess.g:3895:1: () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )*
            {
            // InternalPreprocess.g:3895:1: ()
            // InternalPreprocess.g:3896:2: 
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

            // InternalPreprocess.g:3907:1: ( (lv_expr_1_0= ruleAdditiveExpression ) )
            // InternalPreprocess.g:3908:1: (lv_expr_1_0= ruleAdditiveExpression )
            {
            // InternalPreprocess.g:3908:1: (lv_expr_1_0= ruleAdditiveExpression )
            // InternalPreprocess.g:3909:3: lv_expr_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getExprAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_30);
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

            // InternalPreprocess.g:3928:1: ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( ((LA59_0>=RULE_SKW_LEFTSHIFT && LA59_0<=RULE_SKW_RIGHTSHIFT)) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalPreprocess.g:3929:1: ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalPreprocess.g:3929:1: ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) )
            	    int alt58=2;
            	    int LA58_0 = input.LA(1);

            	    if ( (LA58_0==RULE_SKW_LEFTSHIFT) ) {
            	        alt58=1;
            	    }
            	    else if ( (LA58_0==RULE_SKW_RIGHTSHIFT) ) {
            	        alt58=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 58, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt58) {
            	        case 1 :
            	            // InternalPreprocess.g:3930:1: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
            	            {
            	            // InternalPreprocess.g:3930:1: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
            	            // InternalPreprocess.g:3931:1: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
            	            {
            	            // InternalPreprocess.g:3931:1: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
            	            // InternalPreprocess.g:3932:3: lv_op_2_0= RULE_SKW_LEFTSHIFT
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_LEFTSHIFT,FOLLOW_9); if (state.failed) return current;
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
            	            // InternalPreprocess.g:3952:1: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
            	            {
            	            // InternalPreprocess.g:3952:1: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
            	            // InternalPreprocess.g:3953:1: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
            	            {
            	            // InternalPreprocess.g:3953:1: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
            	            // InternalPreprocess.g:3954:3: lv_op_3_0= RULE_SKW_RIGHTSHIFT
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_RIGHTSHIFT,FOLLOW_9); if (state.failed) return current;
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

            	    // InternalPreprocess.g:3975:1: ( (lv_expr_4_0= ruleAdditiveExpression ) )
            	    // InternalPreprocess.g:3976:1: (lv_expr_4_0= ruleAdditiveExpression )
            	    {
            	    // InternalPreprocess.g:3976:1: (lv_expr_4_0= ruleAdditiveExpression )
            	    // InternalPreprocess.g:3977:3: lv_expr_4_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getExprAdditiveExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_30);
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
            	    break loop59;
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
    // InternalPreprocess.g:4007:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalPreprocess.g:4008:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalPreprocess.g:4009:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalPreprocess.g:4016:1: ruleAdditiveExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4022:7: ( ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalPreprocess.g:4024:1: ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalPreprocess.g:4024:1: ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* )
            // InternalPreprocess.g:4025:1: () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )*
            {
            // InternalPreprocess.g:4025:1: ()
            // InternalPreprocess.g:4026:2: 
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

            // InternalPreprocess.g:4037:1: ( (lv_expr_1_0= ruleMultiplicativeExpression ) )
            // InternalPreprocess.g:4038:1: (lv_expr_1_0= ruleMultiplicativeExpression )
            {
            // InternalPreprocess.g:4038:1: (lv_expr_1_0= ruleMultiplicativeExpression )
            // InternalPreprocess.g:4039:3: lv_expr_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExprMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_31);
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

            // InternalPreprocess.g:4058:1: ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( ((LA61_0>=RULE_SKW_PLUS && LA61_0<=RULE_SKW_MINUS)) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalPreprocess.g:4059:1: ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalPreprocess.g:4059:1: ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) )
            	    int alt60=2;
            	    int LA60_0 = input.LA(1);

            	    if ( (LA60_0==RULE_SKW_PLUS) ) {
            	        alt60=1;
            	    }
            	    else if ( (LA60_0==RULE_SKW_MINUS) ) {
            	        alt60=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 60, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt60) {
            	        case 1 :
            	            // InternalPreprocess.g:4060:1: ( (lv_op_2_0= RULE_SKW_PLUS ) )
            	            {
            	            // InternalPreprocess.g:4060:1: ( (lv_op_2_0= RULE_SKW_PLUS ) )
            	            // InternalPreprocess.g:4061:1: (lv_op_2_0= RULE_SKW_PLUS )
            	            {
            	            // InternalPreprocess.g:4061:1: (lv_op_2_0= RULE_SKW_PLUS )
            	            // InternalPreprocess.g:4062:3: lv_op_2_0= RULE_SKW_PLUS
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_PLUS,FOLLOW_9); if (state.failed) return current;
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
            	            // InternalPreprocess.g:4082:1: ( (lv_op_3_0= RULE_SKW_MINUS ) )
            	            {
            	            // InternalPreprocess.g:4082:1: ( (lv_op_3_0= RULE_SKW_MINUS ) )
            	            // InternalPreprocess.g:4083:1: (lv_op_3_0= RULE_SKW_MINUS )
            	            {
            	            // InternalPreprocess.g:4083:1: (lv_op_3_0= RULE_SKW_MINUS )
            	            // InternalPreprocess.g:4084:3: lv_op_3_0= RULE_SKW_MINUS
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_9); if (state.failed) return current;
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

            	    // InternalPreprocess.g:4105:1: ( (lv_expr_4_0= ruleMultiplicativeExpression ) )
            	    // InternalPreprocess.g:4106:1: (lv_expr_4_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalPreprocess.g:4106:1: (lv_expr_4_0= ruleMultiplicativeExpression )
            	    // InternalPreprocess.g:4107:3: lv_expr_4_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExprMultiplicativeExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_31);
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
            	    break loop61;
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
    // InternalPreprocess.g:4137:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalPreprocess.g:4138:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalPreprocess.g:4139:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalPreprocess.g:4146:1: ruleMultiplicativeExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* ) ;
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
            // InternalPreprocess.g:4152:7: ( ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* ) )
            // InternalPreprocess.g:4154:1: ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* )
            {
            // InternalPreprocess.g:4154:1: ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* )
            // InternalPreprocess.g:4155:1: () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )*
            {
            // InternalPreprocess.g:4155:1: ()
            // InternalPreprocess.g:4156:2: 
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

            // InternalPreprocess.g:4167:1: ( (lv_expr_1_0= ruleCastExpression ) )
            // InternalPreprocess.g:4168:1: (lv_expr_1_0= ruleCastExpression )
            {
            // InternalPreprocess.g:4168:1: (lv_expr_1_0= ruleCastExpression )
            // InternalPreprocess.g:4169:3: lv_expr_1_0= ruleCastExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExprCastExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_32);
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

            // InternalPreprocess.g:4188:1: ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( ((LA63_0>=RULE_SKW_STAR && LA63_0<=RULE_SKW_MOD)) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalPreprocess.g:4189:1: ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) )
            	    {
            	    // InternalPreprocess.g:4189:1: ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) )
            	    int alt62=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_SKW_STAR:
            	        {
            	        alt62=1;
            	        }
            	        break;
            	    case RULE_SKW_DIV:
            	        {
            	        alt62=2;
            	        }
            	        break;
            	    case RULE_SKW_MOD:
            	        {
            	        alt62=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 62, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt62) {
            	        case 1 :
            	            // InternalPreprocess.g:4190:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
            	            {
            	            // InternalPreprocess.g:4190:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
            	            // InternalPreprocess.g:4191:1: (lv_op_2_0= RULE_SKW_STAR )
            	            {
            	            // InternalPreprocess.g:4191:1: (lv_op_2_0= RULE_SKW_STAR )
            	            // InternalPreprocess.g:4192:3: lv_op_2_0= RULE_SKW_STAR
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_STAR,FOLLOW_9); if (state.failed) return current;
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
            	            // InternalPreprocess.g:4212:1: ( (lv_op_3_0= RULE_SKW_DIV ) )
            	            {
            	            // InternalPreprocess.g:4212:1: ( (lv_op_3_0= RULE_SKW_DIV ) )
            	            // InternalPreprocess.g:4213:1: (lv_op_3_0= RULE_SKW_DIV )
            	            {
            	            // InternalPreprocess.g:4213:1: (lv_op_3_0= RULE_SKW_DIV )
            	            // InternalPreprocess.g:4214:3: lv_op_3_0= RULE_SKW_DIV
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_DIV,FOLLOW_9); if (state.failed) return current;
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
            	            // InternalPreprocess.g:4234:1: ( (lv_op_4_0= RULE_SKW_MOD ) )
            	            {
            	            // InternalPreprocess.g:4234:1: ( (lv_op_4_0= RULE_SKW_MOD ) )
            	            // InternalPreprocess.g:4235:1: (lv_op_4_0= RULE_SKW_MOD )
            	            {
            	            // InternalPreprocess.g:4235:1: (lv_op_4_0= RULE_SKW_MOD )
            	            // InternalPreprocess.g:4236:3: lv_op_4_0= RULE_SKW_MOD
            	            {
            	            lv_op_4_0=(Token)match(input,RULE_SKW_MOD,FOLLOW_9); if (state.failed) return current;
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

            	    // InternalPreprocess.g:4257:1: ( (lv_expr_5_0= ruleCastExpression ) )
            	    // InternalPreprocess.g:4258:1: (lv_expr_5_0= ruleCastExpression )
            	    {
            	    // InternalPreprocess.g:4258:1: (lv_expr_5_0= ruleCastExpression )
            	    // InternalPreprocess.g:4259:3: lv_expr_5_0= ruleCastExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExprCastExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_32);
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
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleCastExpression"
    // InternalPreprocess.g:4289:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalPreprocess.g:4290:2: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalPreprocess.g:4291:2: iv_ruleCastExpression= ruleCastExpression EOF
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
    // InternalPreprocess.g:4298:1: ruleCastExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4304:7: ( ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // InternalPreprocess.g:4306:1: ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // InternalPreprocess.g:4306:1: ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // InternalPreprocess.g:4307:1: () ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // InternalPreprocess.g:4307:1: ()
            // InternalPreprocess.g:4308:2: 
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

            // InternalPreprocess.g:4319:1: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // InternalPreprocess.g:4320:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // InternalPreprocess.g:4320:1: (lv_expr_1_0= ruleUnaryExpression )
            // InternalPreprocess.g:4321:3: lv_expr_1_0= ruleUnaryExpression
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
    // InternalPreprocess.g:4349:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalPreprocess.g:4350:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalPreprocess.g:4351:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalPreprocess.g:4358:1: ruleUnaryExpression returns [EObject current=null] : ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;

        EObject lv_op_2_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4364:7: ( ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) ) )
            // InternalPreprocess.g:4366:1: ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) )
            {
            // InternalPreprocess.g:4366:1: ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) )
            // InternalPreprocess.g:4367:1: () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
            {
            // InternalPreprocess.g:4367:1: ()
            // InternalPreprocess.g:4368:2: 
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

            // InternalPreprocess.g:4379:1: ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( ((LA64_0>=RULE_ID && LA64_0<=RULE_SKW_LEFTPAREN)||LA64_0==RULE_DEFINED||(LA64_0>=RULE_HEX_LITERAL && LA64_0<=RULE_BIN_LITERAL)) ) {
                alt64=1;
            }
            else if ( (LA64_0==RULE_SKW_AND||(LA64_0>=RULE_SKW_PLUS && LA64_0<=RULE_SKW_STAR)||(LA64_0>=RULE_SKW_TILDE && LA64_0<=RULE_SKW_NOT)) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // InternalPreprocess.g:4380:1: ( (lv_expr_1_0= rulePostfixExpression ) )
                    {
                    // InternalPreprocess.g:4380:1: ( (lv_expr_1_0= rulePostfixExpression ) )
                    // InternalPreprocess.g:4381:1: (lv_expr_1_0= rulePostfixExpression )
                    {
                    // InternalPreprocess.g:4381:1: (lv_expr_1_0= rulePostfixExpression )
                    // InternalPreprocess.g:4382:3: lv_expr_1_0= rulePostfixExpression
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
                    // InternalPreprocess.g:4402:1: ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
                    {
                    // InternalPreprocess.g:4402:1: ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
                    // InternalPreprocess.g:4403:1: ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) )
                    {
                    // InternalPreprocess.g:4403:1: ( (lv_op_2_0= ruleUnaryOperator ) )
                    // InternalPreprocess.g:4404:1: (lv_op_2_0= ruleUnaryOperator )
                    {
                    // InternalPreprocess.g:4404:1: (lv_op_2_0= ruleUnaryOperator )
                    // InternalPreprocess.g:4405:3: lv_op_2_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_1_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_9);
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

                    // InternalPreprocess.g:4424:1: ( (lv_expr_3_0= ruleCastExpression ) )
                    // InternalPreprocess.g:4425:1: (lv_expr_3_0= ruleCastExpression )
                    {
                    // InternalPreprocess.g:4425:1: (lv_expr_3_0= ruleCastExpression )
                    // InternalPreprocess.g:4426:3: lv_expr_3_0= ruleCastExpression
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
    // InternalPreprocess.g:4458:1: entryRuleUnaryOperator returns [EObject current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final EObject entryRuleUnaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperator = null;


        try {
            // InternalPreprocess.g:4459:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalPreprocess.g:4460:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
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
    // InternalPreprocess.g:4467:1: ruleUnaryOperator returns [EObject current=null] : ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) ) ;
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
            // InternalPreprocess.g:4473:7: ( ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) ) )
            // InternalPreprocess.g:4475:1: ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) )
            {
            // InternalPreprocess.g:4475:1: ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) )
            int alt65=6;
            switch ( input.LA(1) ) {
            case RULE_SKW_AND:
                {
                alt65=1;
                }
                break;
            case RULE_SKW_STAR:
                {
                alt65=2;
                }
                break;
            case RULE_SKW_PLUS:
                {
                alt65=3;
                }
                break;
            case RULE_SKW_MINUS:
                {
                alt65=4;
                }
                break;
            case RULE_SKW_TILDE:
                {
                alt65=5;
                }
                break;
            case RULE_SKW_NOT:
                {
                alt65=6;
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
                    // InternalPreprocess.g:4476:1: ( () ( (lv_op_1_0= RULE_SKW_AND ) ) )
                    {
                    // InternalPreprocess.g:4476:1: ( () ( (lv_op_1_0= RULE_SKW_AND ) ) )
                    // InternalPreprocess.g:4477:1: () ( (lv_op_1_0= RULE_SKW_AND ) )
                    {
                    // InternalPreprocess.g:4477:1: ()
                    // InternalPreprocess.g:4478:2: 
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

                    // InternalPreprocess.g:4489:1: ( (lv_op_1_0= RULE_SKW_AND ) )
                    // InternalPreprocess.g:4490:1: (lv_op_1_0= RULE_SKW_AND )
                    {
                    // InternalPreprocess.g:4490:1: (lv_op_1_0= RULE_SKW_AND )
                    // InternalPreprocess.g:4491:3: lv_op_1_0= RULE_SKW_AND
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
                    // InternalPreprocess.g:4513:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
                    {
                    // InternalPreprocess.g:4513:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
                    // InternalPreprocess.g:4514:1: (lv_op_2_0= RULE_SKW_STAR )
                    {
                    // InternalPreprocess.g:4514:1: (lv_op_2_0= RULE_SKW_STAR )
                    // InternalPreprocess.g:4515:3: lv_op_2_0= RULE_SKW_STAR
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
                    // InternalPreprocess.g:4535:1: ( (lv_op_3_0= RULE_SKW_PLUS ) )
                    {
                    // InternalPreprocess.g:4535:1: ( (lv_op_3_0= RULE_SKW_PLUS ) )
                    // InternalPreprocess.g:4536:1: (lv_op_3_0= RULE_SKW_PLUS )
                    {
                    // InternalPreprocess.g:4536:1: (lv_op_3_0= RULE_SKW_PLUS )
                    // InternalPreprocess.g:4537:3: lv_op_3_0= RULE_SKW_PLUS
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
                    // InternalPreprocess.g:4557:1: ( (lv_op_4_0= RULE_SKW_MINUS ) )
                    {
                    // InternalPreprocess.g:4557:1: ( (lv_op_4_0= RULE_SKW_MINUS ) )
                    // InternalPreprocess.g:4558:1: (lv_op_4_0= RULE_SKW_MINUS )
                    {
                    // InternalPreprocess.g:4558:1: (lv_op_4_0= RULE_SKW_MINUS )
                    // InternalPreprocess.g:4559:3: lv_op_4_0= RULE_SKW_MINUS
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
                    // InternalPreprocess.g:4579:1: ( (lv_op_5_0= RULE_SKW_TILDE ) )
                    {
                    // InternalPreprocess.g:4579:1: ( (lv_op_5_0= RULE_SKW_TILDE ) )
                    // InternalPreprocess.g:4580:1: (lv_op_5_0= RULE_SKW_TILDE )
                    {
                    // InternalPreprocess.g:4580:1: (lv_op_5_0= RULE_SKW_TILDE )
                    // InternalPreprocess.g:4581:3: lv_op_5_0= RULE_SKW_TILDE
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
                    // InternalPreprocess.g:4601:1: ( (lv_op_6_0= RULE_SKW_NOT ) )
                    {
                    // InternalPreprocess.g:4601:1: ( (lv_op_6_0= RULE_SKW_NOT ) )
                    // InternalPreprocess.g:4602:1: (lv_op_6_0= RULE_SKW_NOT )
                    {
                    // InternalPreprocess.g:4602:1: (lv_op_6_0= RULE_SKW_NOT )
                    // InternalPreprocess.g:4603:3: lv_op_6_0= RULE_SKW_NOT
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
    // InternalPreprocess.g:4631:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalPreprocess.g:4632:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalPreprocess.g:4633:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalPreprocess.g:4640:1: rulePostfixExpression returns [EObject current=null] : ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;

        EObject lv_suffix_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4646:7: ( ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) ) )
            // InternalPreprocess.g:4648:1: ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) )
            {
            // InternalPreprocess.g:4648:1: ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) )
            // InternalPreprocess.g:4649:1: () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* )
            {
            // InternalPreprocess.g:4649:1: ()
            // InternalPreprocess.g:4650:2: 
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

            // InternalPreprocess.g:4661:1: ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* )
            // InternalPreprocess.g:4662:1: ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )*
            {
            // InternalPreprocess.g:4662:1: ( (lv_expr_1_0= rulePrimaryExpression ) )
            // InternalPreprocess.g:4663:1: (lv_expr_1_0= rulePrimaryExpression )
            {
            // InternalPreprocess.g:4663:1: (lv_expr_1_0= rulePrimaryExpression )
            // InternalPreprocess.g:4664:3: lv_expr_1_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getExprPrimaryExpressionParserRuleCall_1_0_0()); 
              	    
            }
            pushFollow(FOLLOW_33);
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

            // InternalPreprocess.g:4683:1: ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==RULE_SKW_LEFTPAREN) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalPreprocess.g:4684:1: (lv_suffix_2_0= rulePostfixExpressionSuffixArgument )
            	    {
            	    // InternalPreprocess.g:4684:1: (lv_suffix_2_0= rulePostfixExpressionSuffixArgument )
            	    // InternalPreprocess.g:4685:3: lv_suffix_2_0= rulePostfixExpressionSuffixArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getSuffixPostfixExpressionSuffixArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_33);
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
            	    break loop66;
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
    // InternalPreprocess.g:4715:1: entryRulePostfixExpressionSuffixArgument returns [EObject current=null] : iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF ;
    public final EObject entryRulePostfixExpressionSuffixArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpressionSuffixArgument = null;


        try {
            // InternalPreprocess.g:4716:2: (iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF )
            // InternalPreprocess.g:4717:2: iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF
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
    // InternalPreprocess.g:4724:1: rulePostfixExpressionSuffixArgument returns [EObject current=null] : ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN ) ;
    public final EObject rulePostfixExpressionSuffixArgument() throws RecognitionException {
        EObject current = null;

        Token this_SKW_LEFTPAREN_1=null;
        Token this_SKW_RIGHTPAREN_3=null;
        EObject lv_argumentExpressionList_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4730:7: ( ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN ) )
            // InternalPreprocess.g:4732:1: ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN )
            {
            // InternalPreprocess.g:4732:1: ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN )
            // InternalPreprocess.g:4733:1: () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN
            {
            // InternalPreprocess.g:4733:1: ()
            // InternalPreprocess.g:4734:2: 
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

            this_SKW_LEFTPAREN_1=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SKW_LEFTPAREN_1, grammarAccess.getPostfixExpressionSuffixArgumentAccess().getSKW_LEFTPARENTerminalRuleCall_1()); 
                  
            }
            // InternalPreprocess.g:4752:1: ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( ((LA67_0>=RULE_ID && LA67_0<=RULE_SKW_LEFTPAREN)||LA67_0==RULE_DEFINED||LA67_0==RULE_SKW_AND||(LA67_0>=RULE_SKW_PLUS && LA67_0<=RULE_SKW_STAR)||(LA67_0>=RULE_SKW_TILDE && LA67_0<=RULE_BIN_LITERAL)) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalPreprocess.g:4753:1: (lv_argumentExpressionList_2_0= ruleArgumentExpressionList )
                    {
                    // InternalPreprocess.g:4753:1: (lv_argumentExpressionList_2_0= ruleArgumentExpressionList )
                    // InternalPreprocess.g:4754:3: lv_argumentExpressionList_2_0= ruleArgumentExpressionList
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
    // InternalPreprocess.g:4789:1: entryRuleArgumentExpressionList returns [EObject current=null] : iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF ;
    public final EObject entryRuleArgumentExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentExpressionList = null;


        try {
            // InternalPreprocess.g:4790:2: (iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF )
            // InternalPreprocess.g:4791:2: iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF
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
    // InternalPreprocess.g:4798:1: ruleArgumentExpressionList returns [EObject current=null] : ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* ) ;
    public final EObject ruleArgumentExpressionList() throws RecognitionException {
        EObject current = null;

        Token this_SKW_COMMA_1=null;
        EObject lv_expr_0_0 = null;

        EObject lv_expr_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4804:7: ( ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* ) )
            // InternalPreprocess.g:4806:1: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* )
            {
            // InternalPreprocess.g:4806:1: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* )
            // InternalPreprocess.g:4807:1: ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )*
            {
            // InternalPreprocess.g:4807:1: ( (lv_expr_0_0= ruleConditionalExpression ) )
            // InternalPreprocess.g:4808:1: (lv_expr_0_0= ruleConditionalExpression )
            {
            // InternalPreprocess.g:4808:1: (lv_expr_0_0= ruleConditionalExpression )
            // InternalPreprocess.g:4809:3: lv_expr_0_0= ruleConditionalExpression
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

            // InternalPreprocess.g:4828:1: (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==RULE_SKW_COMMA) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalPreprocess.g:4829:1: this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) )
            	    {
            	    this_SKW_COMMA_1=(Token)match(input,RULE_SKW_COMMA,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_COMMA_1, grammarAccess.getArgumentExpressionListAccess().getSKW_COMMATerminalRuleCall_1_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:4836:1: ( (lv_expr_2_0= ruleConditionalExpression ) )
            	    // InternalPreprocess.g:4837:1: (lv_expr_2_0= ruleConditionalExpression )
            	    {
            	    // InternalPreprocess.g:4837:1: (lv_expr_2_0= ruleConditionalExpression )
            	    // InternalPreprocess.g:4838:3: lv_expr_2_0= ruleConditionalExpression
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
            	    break loop68;
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
    // InternalPreprocess.g:4868:1: entryRuleConstant1 returns [String current=null] : iv_ruleConstant1= ruleConstant1 EOF ;
    public final String entryRuleConstant1() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConstant1 = null;


        try {
            // InternalPreprocess.g:4869:2: (iv_ruleConstant1= ruleConstant1 EOF )
            // InternalPreprocess.g:4870:2: iv_ruleConstant1= ruleConstant1 EOF
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
    // InternalPreprocess.g:4877:1: ruleConstant1 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL ) ;
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
            // InternalPreprocess.g:4880:28: ( (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL ) )
            // InternalPreprocess.g:4881:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL )
            {
            // InternalPreprocess.g:4881:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL )
            int alt69=7;
            switch ( input.LA(1) ) {
            case RULE_HEX_LITERAL:
                {
                alt69=1;
                }
                break;
            case RULE_OCTAL_LITERAL:
                {
                alt69=2;
                }
                break;
            case RULE_DECIMAL_LITERAL:
                {
                alt69=3;
                }
                break;
            case RULE_CHAR_LITERAL:
                {
                alt69=4;
                }
                break;
            case RULE_STRING_LITERAL:
                {
                alt69=5;
                }
                break;
            case RULE_FLOAT_LITERAL:
                {
                alt69=6;
                }
                break;
            case RULE_BIN_LITERAL:
                {
                alt69=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // InternalPreprocess.g:4881:6: this_HEX_LITERAL_0= RULE_HEX_LITERAL
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
                    // InternalPreprocess.g:4889:10: this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL
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
                    // InternalPreprocess.g:4897:10: this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL
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
                    // InternalPreprocess.g:4905:10: this_CHAR_LITERAL_3= RULE_CHAR_LITERAL
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
                    // InternalPreprocess.g:4913:10: this_STRING_LITERAL_4= RULE_STRING_LITERAL
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
                    // InternalPreprocess.g:4921:10: this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL
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
                    // InternalPreprocess.g:4929:10: this_BIN_LITERAL_6= RULE_BIN_LITERAL
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
    // InternalPreprocess.g:4946:1: entryRuleSpecialKeywords returns [String current=null] : iv_ruleSpecialKeywords= ruleSpecialKeywords EOF ;
    public final String entryRuleSpecialKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpecialKeywords = null;


        try {
            // InternalPreprocess.g:4947:2: (iv_ruleSpecialKeywords= ruleSpecialKeywords EOF )
            // InternalPreprocess.g:4948:2: iv_ruleSpecialKeywords= ruleSpecialKeywords EOF
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
    // InternalPreprocess.g:4955:1: ruleSpecialKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE ) ;
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
            // InternalPreprocess.g:4958:28: ( (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE ) )
            // InternalPreprocess.g:4959:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE )
            {
            // InternalPreprocess.g:4959:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE )
            int alt70=37;
            switch ( input.LA(1) ) {
            case RULE_SKW_AND:
                {
                alt70=1;
                }
                break;
            case RULE_SKW_ANDAND:
                {
                alt70=2;
                }
                break;
            case RULE_SKW_ASSIGN:
                {
                alt70=3;
                }
                break;
            case RULE_SKW_BACKSLASH:
                {
                alt70=4;
                }
                break;
            case RULE_SKW_CARET:
                {
                alt70=5;
                }
                break;
            case RULE_SKW_COMMA:
                {
                alt70=6;
                }
                break;
            case RULE_SKW_COLON:
                {
                alt70=7;
                }
                break;
            case RULE_SKW_DIV:
                {
                alt70=8;
                }
                break;
            case RULE_SKW_DOT:
                {
                alt70=9;
                }
                break;
            case RULE_SKW_DOUBLEQUOTE:
                {
                alt70=10;
                }
                break;
            case RULE_SKW_EQUAL:
                {
                alt70=11;
                }
                break;
            case RULE_SKW_GREATER:
                {
                alt70=12;
                }
                break;
            case RULE_SKW_GREATEREQUAL:
                {
                alt70=13;
                }
                break;
            case RULE_SKW_LEFTBRACE:
                {
                alt70=14;
                }
                break;
            case RULE_SKW_LEFTBRACKET:
                {
                alt70=15;
                }
                break;
            case RULE_SKW_LEFTPAREN:
                {
                alt70=16;
                }
                break;
            case RULE_SKW_LEFTSHIFT:
                {
                alt70=17;
                }
                break;
            case RULE_SKW_LESS:
                {
                alt70=18;
                }
                break;
            case RULE_SKW_LESSEQUAL:
                {
                alt70=19;
                }
                break;
            case RULE_SKW_MINUS:
                {
                alt70=20;
                }
                break;
            case RULE_SKW_MINUSMINUS:
                {
                alt70=21;
                }
                break;
            case RULE_SKW_MOD:
                {
                alt70=22;
                }
                break;
            case RULE_SKW_NOT:
                {
                alt70=23;
                }
                break;
            case RULE_SKW_NOTEQUAL:
                {
                alt70=24;
                }
                break;
            case RULE_SKW_OR:
                {
                alt70=25;
                }
                break;
            case RULE_SKW_OROR:
                {
                alt70=26;
                }
                break;
            case RULE_SKW_PLUS:
                {
                alt70=27;
                }
                break;
            case RULE_SKW_PLUSPLUS:
                {
                alt70=28;
                }
                break;
            case RULE_SKW_QUESTION:
                {
                alt70=29;
                }
                break;
            case RULE_SKW_RIGHTBRACE:
                {
                alt70=30;
                }
                break;
            case RULE_SKW_RIGHTBRACKET:
                {
                alt70=31;
                }
                break;
            case RULE_SKW_RIGHTPAREN:
                {
                alt70=32;
                }
                break;
            case RULE_SKW_RIGHTSHIFT:
                {
                alt70=33;
                }
                break;
            case RULE_SKW_SEMI:
                {
                alt70=34;
                }
                break;
            case RULE_SKW_SINGLEQUOTE:
                {
                alt70=35;
                }
                break;
            case RULE_SKW_STAR:
                {
                alt70=36;
                }
                break;
            case RULE_SKW_TILDE:
                {
                alt70=37;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // InternalPreprocess.g:4959:6: this_SKW_AND_0= RULE_SKW_AND
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
                    // InternalPreprocess.g:4967:10: this_SKW_ANDAND_1= RULE_SKW_ANDAND
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
                    // InternalPreprocess.g:4975:10: this_SKW_ASSIGN_2= RULE_SKW_ASSIGN
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
                    // InternalPreprocess.g:4983:10: this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH
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
                    // InternalPreprocess.g:4991:10: this_SKW_CARET_4= RULE_SKW_CARET
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
                    // InternalPreprocess.g:4999:10: this_SKW_COMMA_5= RULE_SKW_COMMA
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
                    // InternalPreprocess.g:5007:10: this_SKW_COLON_6= RULE_SKW_COLON
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
                    // InternalPreprocess.g:5015:10: this_SKW_DIV_7= RULE_SKW_DIV
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
                    // InternalPreprocess.g:5023:10: this_SKW_DOT_8= RULE_SKW_DOT
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
                    // InternalPreprocess.g:5031:10: this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE
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
                    // InternalPreprocess.g:5039:10: this_SKW_EQUAL_10= RULE_SKW_EQUAL
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
                    // InternalPreprocess.g:5047:10: this_SKW_GREATER_11= RULE_SKW_GREATER
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
                    // InternalPreprocess.g:5055:10: this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL
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
                    // InternalPreprocess.g:5063:10: this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE
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
                    // InternalPreprocess.g:5071:10: this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET
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
                    // InternalPreprocess.g:5079:10: this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN
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
                    // InternalPreprocess.g:5087:10: this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT
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
                    // InternalPreprocess.g:5095:10: this_SKW_LESS_17= RULE_SKW_LESS
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
                    // InternalPreprocess.g:5103:10: this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL
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
                    // InternalPreprocess.g:5111:10: this_SKW_MINUS_19= RULE_SKW_MINUS
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
                    // InternalPreprocess.g:5119:10: this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS
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
                    // InternalPreprocess.g:5127:10: this_SKW_MOD_21= RULE_SKW_MOD
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
                    // InternalPreprocess.g:5135:10: this_SKW_NOT_22= RULE_SKW_NOT
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
                    // InternalPreprocess.g:5143:10: this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL
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
                    // InternalPreprocess.g:5151:10: this_SKW_OR_24= RULE_SKW_OR
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
                    // InternalPreprocess.g:5159:10: this_SKW_OROR_25= RULE_SKW_OROR
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
                    // InternalPreprocess.g:5167:10: this_SKW_PLUS_26= RULE_SKW_PLUS
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
                    // InternalPreprocess.g:5175:10: this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS
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
                    // InternalPreprocess.g:5183:10: this_SKW_QUESTION_28= RULE_SKW_QUESTION
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
                    // InternalPreprocess.g:5191:10: this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE
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
                    // InternalPreprocess.g:5199:10: this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET
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
                    // InternalPreprocess.g:5207:10: this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN
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
                    // InternalPreprocess.g:5215:10: this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT
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
                    // InternalPreprocess.g:5223:10: this_SKW_SEMI_33= RULE_SKW_SEMI
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
                    // InternalPreprocess.g:5231:10: this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE
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
                    // InternalPreprocess.g:5239:10: this_SKW_STAR_35= RULE_SKW_STAR
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
                    // InternalPreprocess.g:5247:10: this_SKW_TILDE_36= RULE_SKW_TILDE
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

    // $ANTLR start synpred2_InternalPreprocess
    public final void synpred2_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_NEWLINE_2=null;
        EObject lv_lines_1_0 = null;


        // InternalPreprocess.g:295:1: ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )
        // InternalPreprocess.g:295:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE
        {
        // InternalPreprocess.g:295:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) )
        // InternalPreprocess.g:296:1: (lv_lines_1_0= ruleGroupOptTemp1 )
        {
        // InternalPreprocess.g:296:1: (lv_lines_1_0= ruleGroupOptTemp1 )
        // InternalPreprocess.g:297:3: lv_lines_1_0= ruleGroupOptTemp1
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getGroupOpt2Access().getLinesGroupOptTemp1ParserRuleCall_1_0_0()); 
          	    
        }
        pushFollow(FOLLOW_3);
        lv_lines_1_0=ruleGroupOptTemp1();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalPreprocess

    // $ANTLR start synpred16_InternalPreprocess
    public final void synpred16_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_2=null;

        // InternalPreprocess.g:762:2: (this_WHITESPACE_2= RULE_WHITESPACE )
        // InternalPreprocess.g:762:2: this_WHITESPACE_2= RULE_WHITESPACE
        {
        this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalPreprocess

    // $ANTLR start synpred19_InternalPreprocess
    public final void synpred19_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_4=null;

        // InternalPreprocess.g:923:2: (this_WHITESPACE_4= RULE_WHITESPACE )
        // InternalPreprocess.g:923:2: this_WHITESPACE_4= RULE_WHITESPACE
        {
        this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_InternalPreprocess

    // $ANTLR start synpred24_InternalPreprocess
    public final void synpred24_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_8=null;

        // InternalPreprocess.g:1069:2: (this_WHITESPACE_8= RULE_WHITESPACE )
        // InternalPreprocess.g:1069:2: this_WHITESPACE_8= RULE_WHITESPACE
        {
        this_WHITESPACE_8=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_InternalPreprocess

    // $ANTLR start synpred27_InternalPreprocess
    public final void synpred27_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_2=null;

        // InternalPreprocess.g:1241:2: (this_WHITESPACE_2= RULE_WHITESPACE )
        // InternalPreprocess.g:1241:2: this_WHITESPACE_2= RULE_WHITESPACE
        {
        this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_InternalPreprocess

    // $ANTLR start synpred28_InternalPreprocess
    public final void synpred28_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_2=null;

        // InternalPreprocess.g:1315:2: (this_WHITESPACE_2= RULE_WHITESPACE )
        // InternalPreprocess.g:1315:2: this_WHITESPACE_2= RULE_WHITESPACE
        {
        this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_InternalPreprocess

    // $ANTLR start synpred60_InternalPreprocess
    public final void synpred60_InternalPreprocess_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_MyCode_0 = null;


        // InternalPreprocess.g:2495:5: (this_MyCode_0= ruleMyCode )
        // InternalPreprocess.g:2495:5: this_MyCode_0= ruleMyCode
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
    // $ANTLR end synpred60_InternalPreprocess

    // $ANTLR start synpred61_InternalPreprocess
    public final void synpred61_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_1=null;

        // InternalPreprocess.g:2506:10: (this_WHITESPACE_1= RULE_WHITESPACE )
        // InternalPreprocess.g:2506:10: this_WHITESPACE_1= RULE_WHITESPACE
        {
        this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred61_InternalPreprocess

    // $ANTLR start synpred65_InternalPreprocess
    public final void synpred65_InternalPreprocess_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_MyCode_1 = null;


        // InternalPreprocess.g:2614:5: (this_MyCode_1= ruleMyCode )
        // InternalPreprocess.g:2614:5: this_MyCode_1= ruleMyCode
        {
        if ( state.backtracking==0 ) {
           
                  newCompositeNode(grammarAccess.getMyCodeLineExtendedNormalAccess().getMyCodeParserRuleCall_1()); 
              
        }
        pushFollow(FOLLOW_2);
        this_MyCode_1=ruleMyCode();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred65_InternalPreprocess

    // $ANTLR start synpred71_InternalPreprocess
    public final void synpred71_InternalPreprocess_fragment() throws RecognitionException {   
        Token lv_defined_3_0=null;
        Token this_SKW_LEFTPAREN_4=null;
        Token lv_id_5_0=null;
        Token this_SKW_RIGHTPAREN_6=null;

        // InternalPreprocess.g:2728:1: ( ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) )
        // InternalPreprocess.g:2728:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
        {
        // InternalPreprocess.g:2728:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
        // InternalPreprocess.g:2729:1: ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN
        {
        // InternalPreprocess.g:2729:1: ( (lv_defined_3_0= RULE_DEFINED ) )?
        int alt74=2;
        int LA74_0 = input.LA(1);

        if ( (LA74_0==RULE_DEFINED) ) {
            alt74=1;
        }
        switch (alt74) {
            case 1 :
                // InternalPreprocess.g:2730:1: (lv_defined_3_0= RULE_DEFINED )
                {
                // InternalPreprocess.g:2730:1: (lv_defined_3_0= RULE_DEFINED )
                // InternalPreprocess.g:2731:3: lv_defined_3_0= RULE_DEFINED
                {
                lv_defined_3_0=(Token)match(input,RULE_DEFINED,FOLLOW_12); if (state.failed) return ;

                }


                }
                break;

        }

        this_SKW_LEFTPAREN_4=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_20); if (state.failed) return ;
        // InternalPreprocess.g:2757:1: ( (lv_id_5_0= RULE_ID ) )
        // InternalPreprocess.g:2758:1: (lv_id_5_0= RULE_ID )
        {
        // InternalPreprocess.g:2758:1: (lv_id_5_0= RULE_ID )
        // InternalPreprocess.g:2759:3: lv_id_5_0= RULE_ID
        {
        lv_id_5_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return ;

        }


        }

        this_SKW_RIGHTPAREN_6=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred71_InternalPreprocess

    // Delegated rules

    public final boolean synpred27_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred71_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalPreprocess_fragment(); // can never throw exception
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
    public final boolean synpred61_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_InternalPreprocess_fragment(); // can never throw exception
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
    public final boolean synpred19_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred65_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred65_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_InternalPreprocess_fragment(); // can never throw exception
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
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA43 dfa43 = new DFA43(this);
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
            return "()* loopback of 224:1: ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )*";
        }
    }
    static final String DFA2_eotS =
        "\74\uffff";
    static final String DFA2_eofS =
        "\1\72\73\uffff";
    static final String DFA2_minS =
        "\1\4\71\0\2\uffff";
    static final String DFA2_maxS =
        "\1\101\71\0\2\uffff";
    static final String DFA2_acceptS =
        "\72\uffff\1\2\1\1";
    static final String DFA2_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\2\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\73\1\1\1\2\1\5\1\6\1\3\1\35\1\55\1\23\1\7\2\uffff\1\12\1\14\1\11\1\13\2\uffff\1\10\1\4\1\15\1\52\1\24\1\47\1\17\1\46\1\22\1\16\1\30\1\45\1\37\1\31\1\40\1\32\1\36\1\56\1\50\1\41\1\61\1\25\1\43\1\62\1\44\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\20\1\21\1\26\1\27\1\33\1\34\1\42\1\51\1\53\1\54\1\57\1\60",
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
            return "()* loopback of 294:1: ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA2_1 = input.LA(1);

                         
                        int index2_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA2_2 = input.LA(1);

                         
                        int index2_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA2_3 = input.LA(1);

                         
                        int index2_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA2_4 = input.LA(1);

                         
                        int index2_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA2_5 = input.LA(1);

                         
                        int index2_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA2_6 = input.LA(1);

                         
                        int index2_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA2_7 = input.LA(1);

                         
                        int index2_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA2_8 = input.LA(1);

                         
                        int index2_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA2_9 = input.LA(1);

                         
                        int index2_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA2_10 = input.LA(1);

                         
                        int index2_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA2_11 = input.LA(1);

                         
                        int index2_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA2_12 = input.LA(1);

                         
                        int index2_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA2_13 = input.LA(1);

                         
                        int index2_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA2_14 = input.LA(1);

                         
                        int index2_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA2_15 = input.LA(1);

                         
                        int index2_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA2_16 = input.LA(1);

                         
                        int index2_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA2_17 = input.LA(1);

                         
                        int index2_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA2_18 = input.LA(1);

                         
                        int index2_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA2_19 = input.LA(1);

                         
                        int index2_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA2_20 = input.LA(1);

                         
                        int index2_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA2_21 = input.LA(1);

                         
                        int index2_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA2_22 = input.LA(1);

                         
                        int index2_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA2_23 = input.LA(1);

                         
                        int index2_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA2_24 = input.LA(1);

                         
                        int index2_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA2_25 = input.LA(1);

                         
                        int index2_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA2_26 = input.LA(1);

                         
                        int index2_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA2_27 = input.LA(1);

                         
                        int index2_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA2_28 = input.LA(1);

                         
                        int index2_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA2_29 = input.LA(1);

                         
                        int index2_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_29);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA2_30 = input.LA(1);

                         
                        int index2_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_30);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA2_31 = input.LA(1);

                         
                        int index2_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_31);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA2_32 = input.LA(1);

                         
                        int index2_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_32);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA2_33 = input.LA(1);

                         
                        int index2_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_33);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA2_34 = input.LA(1);

                         
                        int index2_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_34);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA2_35 = input.LA(1);

                         
                        int index2_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_35);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA2_36 = input.LA(1);

                         
                        int index2_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_36);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA2_37 = input.LA(1);

                         
                        int index2_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_37);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA2_38 = input.LA(1);

                         
                        int index2_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_38);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA2_39 = input.LA(1);

                         
                        int index2_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_39);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA2_40 = input.LA(1);

                         
                        int index2_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_40);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA2_41 = input.LA(1);

                         
                        int index2_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_41);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA2_42 = input.LA(1);

                         
                        int index2_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_42);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA2_43 = input.LA(1);

                         
                        int index2_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_43);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA2_44 = input.LA(1);

                         
                        int index2_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_44);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA2_45 = input.LA(1);

                         
                        int index2_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_45);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA2_46 = input.LA(1);

                         
                        int index2_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_46);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA2_47 = input.LA(1);

                         
                        int index2_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_47);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA2_48 = input.LA(1);

                         
                        int index2_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_48);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA2_49 = input.LA(1);

                         
                        int index2_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_49);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA2_50 = input.LA(1);

                         
                        int index2_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_50);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA2_51 = input.LA(1);

                         
                        int index2_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_51);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA2_52 = input.LA(1);

                         
                        int index2_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_52);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA2_53 = input.LA(1);

                         
                        int index2_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_53);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA2_54 = input.LA(1);

                         
                        int index2_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_54);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA2_55 = input.LA(1);

                         
                        int index2_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_55);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA2_56 = input.LA(1);

                         
                        int index2_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_56);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA2_57 = input.LA(1);

                         
                        int index2_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index2_57);
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
    static final String DFA4_eotS =
        "\5\uffff";
    static final String DFA4_eofS =
        "\1\3\1\4\3\uffff";
    static final String DFA4_minS =
        "\2\4\3\uffff";
    static final String DFA4_maxS =
        "\2\101\3\uffff";
    static final String DFA4_acceptS =
        "\2\uffff\1\1\1\2\1\3";
    static final String DFA4_specialS =
        "\5\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\3\1\1\1\2\7\4\2\uffff\4\4\2\uffff\54\4",
            "\1\4\1\1\1\2\7\4\2\uffff\4\4\2\uffff\54\4",
            "",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "372:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode )";
        }
    }
    static final String DFA5_eotS =
        "\4\uffff";
    static final String DFA5_eofS =
        "\1\uffff\1\3\2\uffff";
    static final String DFA5_minS =
        "\2\5\2\uffff";
    static final String DFA5_maxS =
        "\2\101\2\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA5_specialS =
        "\4\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1\1\2\7\3\2\uffff\4\3\2\uffff\54\3",
            "\1\1\1\2\7\3\2\uffff\4\3\2\uffff\54\3",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "446:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_Code_1= ruleCode )";
        }
    }
    static final String DFA10_eotS =
        "\6\uffff";
    static final String DFA10_eofS =
        "\3\uffff\1\5\2\uffff";
    static final String DFA10_minS =
        "\1\10\2\5\1\4\2\uffff";
    static final String DFA10_maxS =
        "\1\10\1\5\1\11\1\12\2\uffff";
    static final String DFA10_acceptS =
        "\4\uffff\1\2\1\1";
    static final String DFA10_specialS =
        "\6\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1",
            "\1\2",
            "\1\2\3\uffff\1\3",
            "\2\5\4\uffff\1\4",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "816:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )";
        }
    }
    static final String DFA24_eotS =
        "\6\uffff";
    static final String DFA24_eofS =
        "\6\uffff";
    static final String DFA24_minS =
        "\4\5\2\uffff";
    static final String DFA24_maxS =
        "\2\6\2\25\2\uffff";
    static final String DFA24_acceptS =
        "\4\uffff\1\1\1\2";
    static final String DFA24_specialS =
        "\6\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\1\1\2",
            "\1\1\1\2",
            "\1\3\12\uffff\1\5\3\uffff\1\4\1\5",
            "\1\3\12\uffff\1\5\3\uffff\1\4\1\5",
            "",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "()* loopback of 1510:1: ( (lv_elifs_2_0= ruleElIfConditional ) )*";
        }
    }
    static final String DFA25_eotS =
        "\6\uffff";
    static final String DFA25_eofS =
        "\6\uffff";
    static final String DFA25_minS =
        "\4\5\2\uffff";
    static final String DFA25_maxS =
        "\2\6\2\25\2\uffff";
    static final String DFA25_acceptS =
        "\4\uffff\1\2\1\1";
    static final String DFA25_specialS =
        "\6\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\1\1\2",
            "\1\1\1\2",
            "\1\3\12\uffff\1\4\4\uffff\1\5",
            "\1\3\12\uffff\1\4\4\uffff\1\5",
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
            return "1531:1: ( (lv_else_3_0= ruleElseConditional ) )?";
        }
    }
    static final String DFA39_eotS =
        "\74\uffff";
    static final String DFA39_eofS =
        "\1\1\73\uffff";
    static final String DFA39_minS =
        "\1\4\1\uffff\70\0\2\uffff";
    static final String DFA39_maxS =
        "\1\101\1\uffff\70\0\2\uffff";
    static final String DFA39_acceptS =
        "\1\uffff\1\3\70\uffff\1\1\1\2";
    static final String DFA39_specialS =
        "\2\uffff\1\63\1\2\1\35\1\66\1\21\1\41\1\1\1\24\1\45\1\22\1\61\1\7\1\31\1\53\1\10\1\32\1\60\1\13\1\56\1\23\1\4\1\43\1\30\1\57\1\46\1\0\1\64\1\52\1\44\1\3\1\65\1\20\1\12\1\42\1\16\1\67\1\36\1\11\1\37\1\5\1\26\1\54\1\14\1\40\1\50\1\25\1\34\1\55\1\33\1\62\1\15\1\47\1\6\1\27\1\51\1\17\2\uffff}>";
    static final String[] DFA39_transitionS = {
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

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "()+ loopback of 2494:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA39_27 = input.LA(1);

                         
                        int index39_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_27);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA39_8 = input.LA(1);

                         
                        int index39_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_8);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA39_3 = input.LA(1);

                         
                        int index39_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA39_31 = input.LA(1);

                         
                        int index39_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_31);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA39_22 = input.LA(1);

                         
                        int index39_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_22);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA39_41 = input.LA(1);

                         
                        int index39_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_41);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA39_54 = input.LA(1);

                         
                        int index39_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_54);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA39_13 = input.LA(1);

                         
                        int index39_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_13);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA39_16 = input.LA(1);

                         
                        int index39_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_16);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA39_39 = input.LA(1);

                         
                        int index39_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_39);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA39_34 = input.LA(1);

                         
                        int index39_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_34);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA39_19 = input.LA(1);

                         
                        int index39_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_19);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA39_44 = input.LA(1);

                         
                        int index39_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_44);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA39_52 = input.LA(1);

                         
                        int index39_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_52);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA39_36 = input.LA(1);

                         
                        int index39_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_36);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA39_57 = input.LA(1);

                         
                        int index39_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred61_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_57);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA39_33 = input.LA(1);

                         
                        int index39_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_33);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA39_6 = input.LA(1);

                         
                        int index39_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_6);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA39_11 = input.LA(1);

                         
                        int index39_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_11);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA39_21 = input.LA(1);

                         
                        int index39_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_21);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA39_9 = input.LA(1);

                         
                        int index39_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_9);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA39_47 = input.LA(1);

                         
                        int index39_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_47);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA39_42 = input.LA(1);

                         
                        int index39_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_42);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA39_55 = input.LA(1);

                         
                        int index39_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_55);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA39_24 = input.LA(1);

                         
                        int index39_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_24);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA39_14 = input.LA(1);

                         
                        int index39_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_14);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA39_17 = input.LA(1);

                         
                        int index39_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_17);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA39_50 = input.LA(1);

                         
                        int index39_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_50);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA39_48 = input.LA(1);

                         
                        int index39_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_48);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA39_4 = input.LA(1);

                         
                        int index39_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_4);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA39_38 = input.LA(1);

                         
                        int index39_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_38);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA39_40 = input.LA(1);

                         
                        int index39_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_40);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA39_45 = input.LA(1);

                         
                        int index39_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_45);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA39_7 = input.LA(1);

                         
                        int index39_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_7);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA39_35 = input.LA(1);

                         
                        int index39_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_35);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA39_23 = input.LA(1);

                         
                        int index39_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_23);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA39_30 = input.LA(1);

                         
                        int index39_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_30);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA39_10 = input.LA(1);

                         
                        int index39_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_10);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA39_26 = input.LA(1);

                         
                        int index39_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_26);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA39_53 = input.LA(1);

                         
                        int index39_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_53);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA39_46 = input.LA(1);

                         
                        int index39_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_46);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA39_56 = input.LA(1);

                         
                        int index39_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_56);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA39_29 = input.LA(1);

                         
                        int index39_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_29);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA39_15 = input.LA(1);

                         
                        int index39_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_15);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA39_43 = input.LA(1);

                         
                        int index39_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_43);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA39_49 = input.LA(1);

                         
                        int index39_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_49);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA39_20 = input.LA(1);

                         
                        int index39_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_20);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA39_25 = input.LA(1);

                         
                        int index39_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_25);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA39_18 = input.LA(1);

                         
                        int index39_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_18);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA39_12 = input.LA(1);

                         
                        int index39_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_12);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA39_51 = input.LA(1);

                         
                        int index39_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_51);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA39_2 = input.LA(1);

                         
                        int index39_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_2);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA39_28 = input.LA(1);

                         
                        int index39_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_28);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA39_32 = input.LA(1);

                         
                        int index39_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_32);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA39_5 = input.LA(1);

                         
                        int index39_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_5);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA39_37 = input.LA(1);

                         
                        int index39_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalPreprocess()) ) {s = 58;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_37);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 39, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA40_eotS =
        "\4\uffff";
    static final String DFA40_eofS =
        "\1\uffff\1\3\2\uffff";
    static final String DFA40_minS =
        "\1\5\1\4\2\uffff";
    static final String DFA40_maxS =
        "\2\101\2\uffff";
    static final String DFA40_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA40_specialS =
        "\4\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\1\1\uffff\7\2\2\uffff\4\2\2\uffff\54\2",
            "\1\3\1\1\1\uffff\7\2\2\uffff\4\2\2\uffff\54\2",
            "",
            ""
    };

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "2534:1: (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal )";
        }
    }
    static final String DFA43_eotS =
        "\72\uffff";
    static final String DFA43_eofS =
        "\1\70\71\uffff";
    static final String DFA43_minS =
        "\1\4\67\0\2\uffff";
    static final String DFA43_maxS =
        "\1\101\67\0\2\uffff";
    static final String DFA43_acceptS =
        "\70\uffff\1\2\1\1";
    static final String DFA43_specialS =
        "\1\uffff\1\24\1\64\1\11\1\35\1\60\1\22\1\46\1\25\1\0\1\44\1\21\1\15\1\62\1\36\1\12\1\57\1\1\1\30\1\50\1\13\1\37\1\65\1\27\1\34\1\14\1\23\1\63\1\53\1\32\1\7\1\42\1\16\1\56\1\45\1\6\1\61\1\17\1\10\1\66\1\3\1\43\1\52\1\26\1\47\1\4\1\31\1\51\1\2\1\54\1\33\1\5\1\41\1\20\1\40\1\55\2\uffff}>";
    static final String[] DFA43_transitionS = {
            "\3\70\1\3\1\4\1\1\1\33\1\53\1\21\1\5\2\uffff\1\10\1\12\1\7\1\11\2\uffff\1\6\1\2\1\13\1\50\1\22\1\45\1\15\1\44\1\20\1\14\1\26\1\43\1\35\1\27\1\36\1\30\1\34\1\54\1\46\1\37\1\57\1\23\1\41\1\60\1\42\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\16\1\17\1\24\1\25\1\31\1\32\1\40\1\47\1\51\1\52\1\55\1\56",
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

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "()+ loopback of 2613:3: (this_MyCode_1= ruleMyCode )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA43_9 = input.LA(1);

                         
                        int index43_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA43_17 = input.LA(1);

                         
                        int index43_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_17);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA43_48 = input.LA(1);

                         
                        int index43_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_48);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA43_40 = input.LA(1);

                         
                        int index43_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_40);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA43_45 = input.LA(1);

                         
                        int index43_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_45);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA43_51 = input.LA(1);

                         
                        int index43_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_51);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA43_35 = input.LA(1);

                         
                        int index43_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_35);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA43_30 = input.LA(1);

                         
                        int index43_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_30);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA43_38 = input.LA(1);

                         
                        int index43_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_38);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA43_3 = input.LA(1);

                         
                        int index43_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_3);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA43_15 = input.LA(1);

                         
                        int index43_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_15);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA43_20 = input.LA(1);

                         
                        int index43_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_20);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA43_25 = input.LA(1);

                         
                        int index43_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_25);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA43_12 = input.LA(1);

                         
                        int index43_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_12);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA43_32 = input.LA(1);

                         
                        int index43_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_32);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA43_37 = input.LA(1);

                         
                        int index43_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_37);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA43_53 = input.LA(1);

                         
                        int index43_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_53);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA43_11 = input.LA(1);

                         
                        int index43_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_11);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA43_6 = input.LA(1);

                         
                        int index43_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_6);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA43_26 = input.LA(1);

                         
                        int index43_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_26);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA43_1 = input.LA(1);

                         
                        int index43_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_1);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA43_8 = input.LA(1);

                         
                        int index43_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_8);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA43_43 = input.LA(1);

                         
                        int index43_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_43);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA43_23 = input.LA(1);

                         
                        int index43_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_23);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA43_18 = input.LA(1);

                         
                        int index43_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_18);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA43_46 = input.LA(1);

                         
                        int index43_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_46);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA43_29 = input.LA(1);

                         
                        int index43_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_29);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA43_50 = input.LA(1);

                         
                        int index43_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_50);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA43_24 = input.LA(1);

                         
                        int index43_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_24);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA43_4 = input.LA(1);

                         
                        int index43_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_4);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA43_14 = input.LA(1);

                         
                        int index43_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_14);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA43_21 = input.LA(1);

                         
                        int index43_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_21);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA43_54 = input.LA(1);

                         
                        int index43_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_54);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA43_52 = input.LA(1);

                         
                        int index43_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_52);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA43_31 = input.LA(1);

                         
                        int index43_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_31);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA43_41 = input.LA(1);

                         
                        int index43_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_41);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA43_10 = input.LA(1);

                         
                        int index43_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_10);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA43_34 = input.LA(1);

                         
                        int index43_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_34);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA43_7 = input.LA(1);

                         
                        int index43_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_7);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA43_44 = input.LA(1);

                         
                        int index43_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_44);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA43_19 = input.LA(1);

                         
                        int index43_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_19);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA43_47 = input.LA(1);

                         
                        int index43_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_47);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA43_42 = input.LA(1);

                         
                        int index43_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_42);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA43_28 = input.LA(1);

                         
                        int index43_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_28);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA43_49 = input.LA(1);

                         
                        int index43_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_49);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA43_55 = input.LA(1);

                         
                        int index43_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_55);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA43_33 = input.LA(1);

                         
                        int index43_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_33);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA43_16 = input.LA(1);

                         
                        int index43_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_16);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA43_5 = input.LA(1);

                         
                        int index43_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_5);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA43_36 = input.LA(1);

                         
                        int index43_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_36);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA43_13 = input.LA(1);

                         
                        int index43_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_13);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA43_27 = input.LA(1);

                         
                        int index43_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_27);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA43_2 = input.LA(1);

                         
                        int index43_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_2);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA43_22 = input.LA(1);

                         
                        int index43_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_22);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA43_39 = input.LA(1);

                         
                        int index43_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalPreprocess()) ) {s = 57;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index43_39);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 43, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0xFFFFFFFFFFCF3FE2L,0x0000000000000003L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0xFFFFFFFFFFCF3FF2L,0x0000000000000003L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000004EE1A0L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0xFFFFFFFFFFCF3FE0L,0x0000000000000003L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000A20L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0xFFFFFFFFFFCF3FF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000200020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000003C00000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000030000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00001C0000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000402L});

}