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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NEWLINE", "RULE_WHITESPACE", "RULE_HASH", "RULE_INCLUDE", "RULE_INCLUDE_NEXT", "RULE_DEFINE", "RULE_SKW_LEFTPAREN", "RULE_SKW_RIGHTPAREN", "RULE_ID", "RULE_SKW_COMMA", "RULE_LINE", "RULE_ERROR", "RULE_WARNING", "RULE_UNDEF", "RULE_ENDIF", "RULE_IF", "RULE_IFDEF", "RULE_IFNOTDEF", "RULE_ELIF", "RULE_ELSE", "RULE_PRAGMA", "RULE_SPECIAL", "RULE_DEFINED", "RULE_VA_ARGS", "RULE_SKW_QUESTION", "RULE_SKW_COLON", "RULE_SKW_OROR", "RULE_SKW_ANDAND", "RULE_SKW_OR", "RULE_SKW_CARET", "RULE_SKW_AND", "RULE_SKW_EQUAL", "RULE_SKW_NOTEQUAL", "RULE_SKW_LESS", "RULE_SKW_GREATER", "RULE_SKW_LESSEQUAL", "RULE_SKW_GREATEREQUAL", "RULE_SKW_LEFTSHIFT", "RULE_SKW_RIGHTSHIFT", "RULE_SKW_PLUS", "RULE_SKW_MINUS", "RULE_SKW_STAR", "RULE_SKW_DIV", "RULE_SKW_MOD", "RULE_SKW_TILDE", "RULE_SKW_NOT", "RULE_SKW_ASSIGN", "RULE_SKW_BACKSLASH", "RULE_SKW_DOT", "RULE_SKW_DOUBLEQUOTE", "RULE_SKW_LEFTBRACE", "RULE_SKW_LEFTBRACKET", "RULE_SKW_MINUSMINUS", "RULE_SKW_PLUSPLUS", "RULE_SKW_RIGHTBRACE", "RULE_SKW_RIGHTBRACKET", "RULE_SKW_SEMI", "RULE_SKW_SINGLEQUOTE", "RULE_HEX_LITERAL", "RULE_OCTAL_LITERAL", "RULE_DECIMAL_LITERAL", "RULE_CHAR_LITERAL", "RULE_STRING_LITERAL", "RULE_FLOAT_LITERAL", "RULE_BIN_LITERAL", "RULE_SKW_UNDERSCORE", "SUPER_NEWLINE", "RULE_SKW_DOLLAR", "RULE_IDENTIFIER", "RULE_LETTER", "RULE_ESCAPE_SEQUENCE", "RULE_HEX_DIGIT", "RULE_INTEGER_TYPE_SUFFIX", "RULE_UNSIGNED_SUFFIX", "RULE_LONG_SUFFIX", "RULE_LONG_LONG_SUFFIX", "RULE_EXPONENT", "RULE_FLOAT_TYPE_SUFFIX", "RULE_OCTAL_ESCAPE", "RULE_HEX_ESCAPE", "RULE_LINEFEED", "RULE_CARRIAGERETURN", "RULE_LINE_END", "RULE_LINEBREAK", "RULE_SPACE", "RULE_TAB", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT"
    };
    public static final int RULE_PRAGMA=24;
    public static final int RULE_ID=12;
    public static final int RULE_OCTAL_ESCAPE=82;
    public static final int RULE_SKW_NOT=49;
    public static final int RULE_LONG_LONG_SUFFIX=79;
    public static final int RULE_ESCAPE_SEQUENCE=74;
    public static final int RULE_SKW_RIGHTSHIFT=42;
    public static final int RULE_SKW_DOT=52;
    public static final int RULE_DEFINED=26;
    public static final int RULE_SKW_PLUS=43;
    public static final int RULE_SKW_NOTEQUAL=36;
    public static final int RULE_SKW_GREATEREQUAL=40;
    public static final int RULE_SKW_RIGHTBRACE=58;
    public static final int EOF=-1;
    public static final int RULE_SKW_LESS=37;
    public static final int RULE_VA_ARGS=27;
    public static final int RULE_SKW_RIGHTPAREN=11;
    public static final int RULE_SKW_STAR=45;
    public static final int RULE_ENDIF=18;
    public static final int RULE_LINEBREAK=87;
    public static final int RULE_STRING_LITERAL=66;
    public static final int RULE_SKW_PLUSPLUS=57;
    public static final int RULE_SKW_DOUBLEQUOTE=53;
    public static final int RULE_SKW_LESSEQUAL=39;
    public static final int RULE_UNSIGNED_SUFFIX=77;
    public static final int RULE_DECIMAL_LITERAL=64;
    public static final int RULE_HEX_LITERAL=62;
    public static final int RULE_SKW_OROR=30;
    public static final int RULE_WARNING=16;
    public static final int RULE_SKW_AND=34;
    public static final int RULE_SKW_CARET=33;
    public static final int RULE_WHITESPACE=5;
    public static final int RULE_OCTAL_LITERAL=63;
    public static final int RULE_SKW_COMMA=13;
    public static final int RULE_SKW_RIGHTBRACKET=59;
    public static final int RULE_SPACE=88;
    public static final int SUPER_NEWLINE=70;
    public static final int RULE_BLOCK_COMMENT=90;
    public static final int RULE_LINEFEED=84;
    public static final int RULE_LINE=14;
    public static final int RULE_SKW_COLON=29;
    public static final int RULE_BIN_LITERAL=68;
    public static final int RULE_SKW_LEFTPAREN=10;
    public static final int RULE_INCLUDE_NEXT=8;
    public static final int RULE_SKW_MINUS=44;
    public static final int RULE_SKW_SEMI=60;
    public static final int RULE_IFDEF=20;
    public static final int RULE_NEWLINE=4;
    public static final int RULE_SKW_DOLLAR=71;
    public static final int RULE_SKW_EQUAL=35;
    public static final int RULE_SKW_LEFTSHIFT=41;
    public static final int RULE_SKW_DIV=46;
    public static final int RULE_SKW_QUESTION=28;
    public static final int RULE_SKW_ANDAND=31;
    public static final int RULE_ERROR=15;
    public static final int RULE_HEX_DIGIT=75;
    public static final int RULE_SKW_GREATER=38;
    public static final int RULE_IDENTIFIER=72;
    public static final int RULE_HASH=6;
    public static final int RULE_TAB=89;
    public static final int RULE_HEX_ESCAPE=83;
    public static final int RULE_SKW_LEFTBRACKET=55;
    public static final int RULE_SKW_SINGLEQUOTE=61;
    public static final int RULE_SKW_MOD=47;
    public static final int RULE_UNDEF=17;
    public static final int RULE_LETTER=73;
    public static final int RULE_SKW_MINUSMINUS=56;
    public static final int RULE_FLOAT_TYPE_SUFFIX=81;
    public static final int RULE_IFNOTDEF=21;
    public static final int RULE_EXPONENT=80;
    public static final int RULE_INTEGER_TYPE_SUFFIX=76;
    public static final int RULE_DEFINE=9;
    public static final int RULE_SPECIAL=25;
    public static final int RULE_CARRIAGERETURN=85;
    public static final int RULE_SKW_TILDE=48;
    public static final int RULE_LINE_COMMENT=91;
    public static final int RULE_INCLUDE=7;
    public static final int RULE_SKW_UNDERSCORE=69;
    public static final int RULE_SKW_BACKSLASH=51;
    public static final int RULE_SKW_OR=32;
    public static final int RULE_CHAR_LITERAL=65;
    public static final int RULE_ELIF=22;
    public static final int RULE_LINE_END=86;
    public static final int RULE_IF=19;
    public static final int RULE_FLOAT_LITERAL=67;
    public static final int RULE_SKW_LEFTBRACE=54;
    public static final int RULE_ELSE=23;
    public static final int RULE_LONG_SUFFIX=78;
    public static final int RULE_SKW_ASSIGN=50;

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
        	return "Preprocess";	
       	}
       	
       	@Override
       	protected PreprocessGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRulePreprocess"
    // InternalPreprocess.g:74:1: entryRulePreprocess returns [EObject current=null] : iv_rulePreprocess= rulePreprocess EOF ;
    public final EObject entryRulePreprocess() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreprocess = null;


        try {
            // InternalPreprocess.g:75:2: (iv_rulePreprocess= rulePreprocess EOF )
            // InternalPreprocess.g:76:2: iv_rulePreprocess= rulePreprocess EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPreprocessRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePreprocess=rulePreprocess();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePreprocess; 
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
    // $ANTLR end "entryRulePreprocess"


    // $ANTLR start "rulePreprocess"
    // InternalPreprocess.g:83:1: rulePreprocess returns [EObject current=null] : ( () ( (lv_group_1_0= ruleGroupOpt2 ) ) ) ;
    public final EObject rulePreprocess() throws RecognitionException {
        EObject current = null;

        EObject lv_group_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:89:7: ( ( () ( (lv_group_1_0= ruleGroupOpt2 ) ) ) )
            // InternalPreprocess.g:91:1: ( () ( (lv_group_1_0= ruleGroupOpt2 ) ) )
            {
            // InternalPreprocess.g:91:1: ( () ( (lv_group_1_0= ruleGroupOpt2 ) ) )
            // InternalPreprocess.g:92:1: () ( (lv_group_1_0= ruleGroupOpt2 ) )
            {
            // InternalPreprocess.g:92:1: ()
            // InternalPreprocess.g:93:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPreprocessAccess().getPreprocessAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocess.g:104:1: ( (lv_group_1_0= ruleGroupOpt2 ) )
            // InternalPreprocess.g:105:1: (lv_group_1_0= ruleGroupOpt2 )
            {
            // InternalPreprocess.g:105:1: (lv_group_1_0= ruleGroupOpt2 )
            // InternalPreprocess.g:106:3: lv_group_1_0= ruleGroupOpt2
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPreprocessAccess().getGroupGroupOpt2ParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_group_1_0=ruleGroupOpt2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPreprocessRule());
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
                  		
                   
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "rulePreprocess"


    // $ANTLR start "entryRuleGroupOpt"
    // InternalPreprocess.g:139:1: entryRuleGroupOpt returns [EObject current=null] : iv_ruleGroupOpt= ruleGroupOpt EOF ;
    public final EObject entryRuleGroupOpt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOpt = null;


        try {
            // InternalPreprocess.g:140:2: (iv_ruleGroupOpt= ruleGroupOpt EOF )
            // InternalPreprocess.g:141:2: iv_ruleGroupOpt= ruleGroupOpt EOF
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
    // InternalPreprocess.g:148:1: ruleGroupOpt returns [EObject current=null] : ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ) ;
    public final EObject ruleGroupOpt() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_2=null;
        EObject lv_lines_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:154:7: ( ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ) )
            // InternalPreprocess.g:156:1: ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* )
            {
            // InternalPreprocess.g:156:1: ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* )
            // InternalPreprocess.g:157:1: () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )*
            {
            // InternalPreprocess.g:157:1: ()
            // InternalPreprocess.g:158:2: 
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

            // InternalPreprocess.g:169:1: ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )*
            loop1:
            do {
                int alt1=2;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // InternalPreprocess.g:170:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE
            	    {
            	    // InternalPreprocess.g:170:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) )
            	    // InternalPreprocess.g:171:1: (lv_lines_1_0= ruleGroupOptTemp1 )
            	    {
            	    // InternalPreprocess.g:171:1: (lv_lines_1_0= ruleGroupOptTemp1 )
            	    // InternalPreprocess.g:172:3: lv_lines_1_0= ruleGroupOptTemp1
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
                  		
                   
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleGroupOpt"


    // $ANTLR start "entryRuleGroupOpt2"
    // InternalPreprocess.g:214:1: entryRuleGroupOpt2 returns [EObject current=null] : iv_ruleGroupOpt2= ruleGroupOpt2 EOF ;
    public final EObject entryRuleGroupOpt2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOpt2 = null;


        try {
            // InternalPreprocess.g:215:2: (iv_ruleGroupOpt2= ruleGroupOpt2 EOF )
            // InternalPreprocess.g:216:2: iv_ruleGroupOpt2= ruleGroupOpt2 EOF
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
    // InternalPreprocess.g:223:1: ruleGroupOpt2 returns [EObject current=null] : ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleGroupOptTemp2 ) )? ) ;
    public final EObject ruleGroupOpt2() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_2=null;
        EObject lv_lines_1_0 = null;

        EObject lv_lines_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:229:7: ( ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleGroupOptTemp2 ) )? ) )
            // InternalPreprocess.g:231:1: ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleGroupOptTemp2 ) )? )
            {
            // InternalPreprocess.g:231:1: ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleGroupOptTemp2 ) )? )
            // InternalPreprocess.g:232:1: () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleGroupOptTemp2 ) )?
            {
            // InternalPreprocess.g:232:1: ()
            // InternalPreprocess.g:233:2: 
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

            // InternalPreprocess.g:244:1: ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // InternalPreprocess.g:245:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE
            	    {
            	    // InternalPreprocess.g:245:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) )
            	    // InternalPreprocess.g:246:1: (lv_lines_1_0= ruleGroupOptTemp1 )
            	    {
            	    // InternalPreprocess.g:246:1: (lv_lines_1_0= ruleGroupOptTemp1 )
            	    // InternalPreprocess.g:247:3: lv_lines_1_0= ruleGroupOptTemp1
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

            // InternalPreprocess.g:275:1: ( (lv_lines_3_0= ruleGroupOptTemp2 ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_WHITESPACE && LA3_0<=RULE_INCLUDE)||(LA3_0>=RULE_DEFINE && LA3_0<=RULE_DEFINED)||(LA3_0>=RULE_SKW_QUESTION && LA3_0<=RULE_BIN_LITERAL)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalPreprocess.g:276:1: (lv_lines_3_0= ruleGroupOptTemp2 )
                    {
                    // InternalPreprocess.g:276:1: (lv_lines_3_0= ruleGroupOptTemp2 )
                    // InternalPreprocess.g:277:3: lv_lines_3_0= ruleGroupOptTemp2
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
                  		
                   
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleGroupOpt2"


    // $ANTLR start "entryRuleGroupOptTemp1"
    // InternalPreprocess.g:310:1: entryRuleGroupOptTemp1 returns [EObject current=null] : iv_ruleGroupOptTemp1= ruleGroupOptTemp1 EOF ;
    public final EObject entryRuleGroupOptTemp1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOptTemp1 = null;


        try {
            // InternalPreprocess.g:311:2: (iv_ruleGroupOptTemp1= ruleGroupOptTemp1 EOF )
            // InternalPreprocess.g:312:2: iv_ruleGroupOptTemp1= ruleGroupOptTemp1 EOF
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
    // InternalPreprocess.g:319:1: ruleGroupOptTemp1 returns [EObject current=null] : (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode ) ;
    public final EObject ruleGroupOptTemp1() throws RecognitionException {
        EObject current = null;

        EObject this_PreprocessorDirectives_0 = null;

        EObject this_NewLineLine_1 = null;

        EObject this_Code_2 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:325:7: ( (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode ) )
            // InternalPreprocess.g:327:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode )
            {
            // InternalPreprocess.g:327:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode )
            int alt4=3;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalPreprocess.g:329:2: this_PreprocessorDirectives_0= rulePreprocessorDirectives
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
                    // InternalPreprocess.g:345:2: this_NewLineLine_1= ruleNewLineLine
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
                    // InternalPreprocess.g:361:2: this_Code_2= ruleCode
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
                  		
                   
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleGroupOptTemp1"


    // $ANTLR start "entryRuleGroupOptTemp2"
    // InternalPreprocess.g:389:1: entryRuleGroupOptTemp2 returns [EObject current=null] : iv_ruleGroupOptTemp2= ruleGroupOptTemp2 EOF ;
    public final EObject entryRuleGroupOptTemp2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOptTemp2 = null;


        try {
            // InternalPreprocess.g:390:2: (iv_ruleGroupOptTemp2= ruleGroupOptTemp2 EOF )
            // InternalPreprocess.g:391:2: iv_ruleGroupOptTemp2= ruleGroupOptTemp2 EOF
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
    // InternalPreprocess.g:398:1: ruleGroupOptTemp2 returns [EObject current=null] : (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_Code_1= ruleCode ) ;
    public final EObject ruleGroupOptTemp2() throws RecognitionException {
        EObject current = null;

        EObject this_PreprocessorDirectives_0 = null;

        EObject this_Code_1 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:404:7: ( (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_Code_1= ruleCode ) )
            // InternalPreprocess.g:406:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_Code_1= ruleCode )
            {
            // InternalPreprocess.g:406:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_Code_1= ruleCode )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalPreprocess.g:408:2: this_PreprocessorDirectives_0= rulePreprocessorDirectives
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
                    // InternalPreprocess.g:424:2: this_Code_1= ruleCode
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
                  		
                   
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleGroupOptTemp2"


    // $ANTLR start "entryRulePreprocessorDirectives"
    // InternalPreprocess.g:452:1: entryRulePreprocessorDirectives returns [EObject current=null] : iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF ;
    public final EObject entryRulePreprocessorDirectives() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreprocessorDirectives = null;


        try {
            // InternalPreprocess.g:453:2: (iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF )
            // InternalPreprocess.g:454:2: iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF
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
    // InternalPreprocess.g:461:1: rulePreprocessorDirectives returns [EObject current=null] : ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleLineDirective ) ) | ( (lv_directive_7_0= ruleErrorDirective ) ) | ( (lv_directive_8_0= ruleWarningDirective ) ) | ( (lv_directive_9_0= ruleUnDefineDirective ) ) | ( (lv_directive_10_0= ruleConditionalDirective ) ) | ( (lv_directive_11_0= rulePragmaDirective ) ) | ( (lv_directive_12_0= ruleNullDirective ) ) ) ) ;
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

        EObject lv_directive_12_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:467:7: ( ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleLineDirective ) ) | ( (lv_directive_7_0= ruleErrorDirective ) ) | ( (lv_directive_8_0= ruleWarningDirective ) ) | ( (lv_directive_9_0= ruleUnDefineDirective ) ) | ( (lv_directive_10_0= ruleConditionalDirective ) ) | ( (lv_directive_11_0= rulePragmaDirective ) ) | ( (lv_directive_12_0= ruleNullDirective ) ) ) ) )
            // InternalPreprocess.g:469:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleLineDirective ) ) | ( (lv_directive_7_0= ruleErrorDirective ) ) | ( (lv_directive_8_0= ruleWarningDirective ) ) | ( (lv_directive_9_0= ruleUnDefineDirective ) ) | ( (lv_directive_10_0= ruleConditionalDirective ) ) | ( (lv_directive_11_0= rulePragmaDirective ) ) | ( (lv_directive_12_0= ruleNullDirective ) ) ) )
            {
            // InternalPreprocess.g:469:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleLineDirective ) ) | ( (lv_directive_7_0= ruleErrorDirective ) ) | ( (lv_directive_8_0= ruleWarningDirective ) ) | ( (lv_directive_9_0= ruleUnDefineDirective ) ) | ( (lv_directive_10_0= ruleConditionalDirective ) ) | ( (lv_directive_11_0= rulePragmaDirective ) ) | ( (lv_directive_12_0= ruleNullDirective ) ) ) )
            // InternalPreprocess.g:470:1: () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleLineDirective ) ) | ( (lv_directive_7_0= ruleErrorDirective ) ) | ( (lv_directive_8_0= ruleWarningDirective ) ) | ( (lv_directive_9_0= ruleUnDefineDirective ) ) | ( (lv_directive_10_0= ruleConditionalDirective ) ) | ( (lv_directive_11_0= rulePragmaDirective ) ) | ( (lv_directive_12_0= ruleNullDirective ) ) )
            {
            // InternalPreprocess.g:470:1: ()
            // InternalPreprocess.g:471:2: 
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

            // InternalPreprocess.g:482:1: (this_WHITESPACE_1= RULE_WHITESPACE )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_WHITESPACE) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalPreprocess.g:482:2: this_WHITESPACE_1= RULE_WHITESPACE
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
            // InternalPreprocess.g:496:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_WHITESPACE) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalPreprocess.g:496:2: this_WHITESPACE_3= RULE_WHITESPACE
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

            // InternalPreprocess.g:503:1: ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleLineDirective ) ) | ( (lv_directive_7_0= ruleErrorDirective ) ) | ( (lv_directive_8_0= ruleWarningDirective ) ) | ( (lv_directive_9_0= ruleUnDefineDirective ) ) | ( (lv_directive_10_0= ruleConditionalDirective ) ) | ( (lv_directive_11_0= rulePragmaDirective ) ) | ( (lv_directive_12_0= ruleNullDirective ) ) )
            int alt8=9;
            switch ( input.LA(1) ) {
            case RULE_INCLUDE:
            case RULE_INCLUDE_NEXT:
                {
                alt8=1;
                }
                break;
            case RULE_DEFINE:
                {
                alt8=2;
                }
                break;
            case RULE_LINE:
                {
                alt8=3;
                }
                break;
            case RULE_ERROR:
                {
                alt8=4;
                }
                break;
            case RULE_WARNING:
                {
                alt8=5;
                }
                break;
            case RULE_UNDEF:
                {
                alt8=6;
                }
                break;
            case RULE_IF:
            case RULE_IFDEF:
            case RULE_IFNOTDEF:
                {
                alt8=7;
                }
                break;
            case RULE_PRAGMA:
                {
                alt8=8;
                }
                break;
            case EOF:
            case RULE_NEWLINE:
                {
                alt8=9;
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
                    // InternalPreprocess.g:504:1: ( (lv_directive_4_0= ruleIncludeDirective ) )
                    {
                    // InternalPreprocess.g:504:1: ( (lv_directive_4_0= ruleIncludeDirective ) )
                    // InternalPreprocess.g:505:1: (lv_directive_4_0= ruleIncludeDirective )
                    {
                    // InternalPreprocess.g:505:1: (lv_directive_4_0= ruleIncludeDirective )
                    // InternalPreprocess.g:506:3: lv_directive_4_0= ruleIncludeDirective
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
                    // InternalPreprocess.g:526:1: ( (lv_directive_5_0= ruleDefineDirective ) )
                    {
                    // InternalPreprocess.g:526:1: ( (lv_directive_5_0= ruleDefineDirective ) )
                    // InternalPreprocess.g:527:1: (lv_directive_5_0= ruleDefineDirective )
                    {
                    // InternalPreprocess.g:527:1: (lv_directive_5_0= ruleDefineDirective )
                    // InternalPreprocess.g:528:3: lv_directive_5_0= ruleDefineDirective
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
                    // InternalPreprocess.g:548:1: ( (lv_directive_6_0= ruleLineDirective ) )
                    {
                    // InternalPreprocess.g:548:1: ( (lv_directive_6_0= ruleLineDirective ) )
                    // InternalPreprocess.g:549:1: (lv_directive_6_0= ruleLineDirective )
                    {
                    // InternalPreprocess.g:549:1: (lv_directive_6_0= ruleLineDirective )
                    // InternalPreprocess.g:550:3: lv_directive_6_0= ruleLineDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveLineDirectiveParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_6_0=ruleLineDirective();

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
                              		"at.jku.weiner.c.preprocess.Preprocess.LineDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalPreprocess.g:570:1: ( (lv_directive_7_0= ruleErrorDirective ) )
                    {
                    // InternalPreprocess.g:570:1: ( (lv_directive_7_0= ruleErrorDirective ) )
                    // InternalPreprocess.g:571:1: (lv_directive_7_0= ruleErrorDirective )
                    {
                    // InternalPreprocess.g:571:1: (lv_directive_7_0= ruleErrorDirective )
                    // InternalPreprocess.g:572:3: lv_directive_7_0= ruleErrorDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveErrorDirectiveParserRuleCall_4_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_7_0=ruleErrorDirective();

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
                              		"at.jku.weiner.c.preprocess.Preprocess.ErrorDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalPreprocess.g:592:1: ( (lv_directive_8_0= ruleWarningDirective ) )
                    {
                    // InternalPreprocess.g:592:1: ( (lv_directive_8_0= ruleWarningDirective ) )
                    // InternalPreprocess.g:593:1: (lv_directive_8_0= ruleWarningDirective )
                    {
                    // InternalPreprocess.g:593:1: (lv_directive_8_0= ruleWarningDirective )
                    // InternalPreprocess.g:594:3: lv_directive_8_0= ruleWarningDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveWarningDirectiveParserRuleCall_4_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_8_0=ruleWarningDirective();

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
                              		"at.jku.weiner.c.preprocess.Preprocess.WarningDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalPreprocess.g:614:1: ( (lv_directive_9_0= ruleUnDefineDirective ) )
                    {
                    // InternalPreprocess.g:614:1: ( (lv_directive_9_0= ruleUnDefineDirective ) )
                    // InternalPreprocess.g:615:1: (lv_directive_9_0= ruleUnDefineDirective )
                    {
                    // InternalPreprocess.g:615:1: (lv_directive_9_0= ruleUnDefineDirective )
                    // InternalPreprocess.g:616:3: lv_directive_9_0= ruleUnDefineDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveUnDefineDirectiveParserRuleCall_4_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_9_0=ruleUnDefineDirective();

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
                              		"at.jku.weiner.c.preprocess.Preprocess.UnDefineDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalPreprocess.g:636:1: ( (lv_directive_10_0= ruleConditionalDirective ) )
                    {
                    // InternalPreprocess.g:636:1: ( (lv_directive_10_0= ruleConditionalDirective ) )
                    // InternalPreprocess.g:637:1: (lv_directive_10_0= ruleConditionalDirective )
                    {
                    // InternalPreprocess.g:637:1: (lv_directive_10_0= ruleConditionalDirective )
                    // InternalPreprocess.g:638:3: lv_directive_10_0= ruleConditionalDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveConditionalDirectiveParserRuleCall_4_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_10_0=ruleConditionalDirective();

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
                              		"at.jku.weiner.c.preprocess.Preprocess.ConditionalDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalPreprocess.g:658:1: ( (lv_directive_11_0= rulePragmaDirective ) )
                    {
                    // InternalPreprocess.g:658:1: ( (lv_directive_11_0= rulePragmaDirective ) )
                    // InternalPreprocess.g:659:1: (lv_directive_11_0= rulePragmaDirective )
                    {
                    // InternalPreprocess.g:659:1: (lv_directive_11_0= rulePragmaDirective )
                    // InternalPreprocess.g:660:3: lv_directive_11_0= rulePragmaDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectivePragmaDirectiveParserRuleCall_4_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_11_0=rulePragmaDirective();

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
                              		"at.jku.weiner.c.preprocess.Preprocess.PragmaDirective");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalPreprocess.g:680:1: ( (lv_directive_12_0= ruleNullDirective ) )
                    {
                    // InternalPreprocess.g:680:1: ( (lv_directive_12_0= ruleNullDirective ) )
                    // InternalPreprocess.g:681:1: (lv_directive_12_0= ruleNullDirective )
                    {
                    // InternalPreprocess.g:681:1: (lv_directive_12_0= ruleNullDirective )
                    // InternalPreprocess.g:682:3: lv_directive_12_0= ruleNullDirective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveNullDirectiveParserRuleCall_4_8_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_12_0=ruleNullDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
                      	        }
                             		set(
                             			current, 
                             			"directive",
                              		lv_directive_12_0, 
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
                  		
                   
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "rulePreprocessorDirectives"


    // $ANTLR start "entryRuleIncludeDirective"
    // InternalPreprocess.g:717:1: entryRuleIncludeDirective returns [EObject current=null] : iv_ruleIncludeDirective= ruleIncludeDirective EOF ;
    public final EObject entryRuleIncludeDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDirective = null;


        try {
            // InternalPreprocess.g:718:2: (iv_ruleIncludeDirective= ruleIncludeDirective EOF )
            // InternalPreprocess.g:719:2: iv_ruleIncludeDirective= ruleIncludeDirective EOF
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
    // InternalPreprocess.g:726:1: ruleIncludeDirective returns [EObject current=null] : ( () (this_INCLUDE_1= RULE_INCLUDE | ( (lv_next_2_0= RULE_INCLUDE_NEXT ) ) ) (this_WHITESPACE_3= RULE_WHITESPACE )+ ( (lv_string_4_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleIncludeDirective() throws RecognitionException {
        EObject current = null;

        Token this_INCLUDE_1=null;
        Token lv_next_2_0=null;
        Token this_WHITESPACE_3=null;
        AntlrDatatypeRuleToken lv_string_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:732:7: ( ( () (this_INCLUDE_1= RULE_INCLUDE | ( (lv_next_2_0= RULE_INCLUDE_NEXT ) ) ) (this_WHITESPACE_3= RULE_WHITESPACE )+ ( (lv_string_4_0= ruleMyCodeLine ) ) ) )
            // InternalPreprocess.g:734:1: ( () (this_INCLUDE_1= RULE_INCLUDE | ( (lv_next_2_0= RULE_INCLUDE_NEXT ) ) ) (this_WHITESPACE_3= RULE_WHITESPACE )+ ( (lv_string_4_0= ruleMyCodeLine ) ) )
            {
            // InternalPreprocess.g:734:1: ( () (this_INCLUDE_1= RULE_INCLUDE | ( (lv_next_2_0= RULE_INCLUDE_NEXT ) ) ) (this_WHITESPACE_3= RULE_WHITESPACE )+ ( (lv_string_4_0= ruleMyCodeLine ) ) )
            // InternalPreprocess.g:735:1: () (this_INCLUDE_1= RULE_INCLUDE | ( (lv_next_2_0= RULE_INCLUDE_NEXT ) ) ) (this_WHITESPACE_3= RULE_WHITESPACE )+ ( (lv_string_4_0= ruleMyCodeLine ) )
            {
            // InternalPreprocess.g:735:1: ()
            // InternalPreprocess.g:736:2: 
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

            // InternalPreprocess.g:747:1: (this_INCLUDE_1= RULE_INCLUDE | ( (lv_next_2_0= RULE_INCLUDE_NEXT ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_INCLUDE) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_INCLUDE_NEXT) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalPreprocess.g:748:1: this_INCLUDE_1= RULE_INCLUDE
                    {
                    this_INCLUDE_1=(Token)match(input,RULE_INCLUDE,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INCLUDE_1, grammarAccess.getIncludeDirectiveAccess().getINCLUDETerminalRuleCall_1_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:756:1: ( (lv_next_2_0= RULE_INCLUDE_NEXT ) )
                    {
                    // InternalPreprocess.g:756:1: ( (lv_next_2_0= RULE_INCLUDE_NEXT ) )
                    // InternalPreprocess.g:757:1: (lv_next_2_0= RULE_INCLUDE_NEXT )
                    {
                    // InternalPreprocess.g:757:1: (lv_next_2_0= RULE_INCLUDE_NEXT )
                    // InternalPreprocess.g:758:3: lv_next_2_0= RULE_INCLUDE_NEXT
                    {
                    lv_next_2_0=(Token)match(input,RULE_INCLUDE_NEXT,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_next_2_0, grammarAccess.getIncludeDirectiveAccess().getNextINCLUDE_NEXTTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getIncludeDirectiveRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"next",
                              		true, 
                              		"at.jku.weiner.c.preprocess.Preprocess.INCLUDE_NEXT");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalPreprocess.g:779:1: (this_WHITESPACE_3= RULE_WHITESPACE )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_WHITESPACE) ) {
                    int LA10_2 = input.LA(2);

                    if ( (synpred18_InternalPreprocess()) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // InternalPreprocess.g:779:2: this_WHITESPACE_3= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_3, grammarAccess.getIncludeDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:786:1: ( (lv_string_4_0= ruleMyCodeLine ) )
            // InternalPreprocess.g:787:1: (lv_string_4_0= ruleMyCodeLine )
            {
            // InternalPreprocess.g:787:1: (lv_string_4_0= ruleMyCodeLine )
            // InternalPreprocess.g:788:3: lv_string_4_0= ruleMyCodeLine
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIncludeDirectiveAccess().getStringMyCodeLineParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_string_4_0=ruleMyCodeLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIncludeDirectiveRule());
              	        }
                     		set(
                     			current, 
                     			"string",
                      		lv_string_4_0, 
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleIncludeDirective"


    // $ANTLR start "entryRuleDefineDirective"
    // InternalPreprocess.g:821:1: entryRuleDefineDirective returns [EObject current=null] : iv_ruleDefineDirective= ruleDefineDirective EOF ;
    public final EObject entryRuleDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineDirective = null;


        try {
            // InternalPreprocess.g:822:2: (iv_ruleDefineDirective= ruleDefineDirective EOF )
            // InternalPreprocess.g:823:2: iv_ruleDefineDirective= ruleDefineDirective EOF
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
    // InternalPreprocess.g:830:1: ruleDefineDirective returns [EObject current=null] : (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro ) ;
    public final EObject ruleDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject this_DefineObjectMacro_0 = null;

        EObject this_DefineFunctionLikeMacro_1 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:836:7: ( (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro ) )
            // InternalPreprocess.g:838:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )
            {
            // InternalPreprocess.g:838:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalPreprocess.g:840:2: this_DefineObjectMacro_0= ruleDefineObjectMacro
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
                    // InternalPreprocess.g:856:2: this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleDefineDirective"


    // $ANTLR start "entryRuleDefineObjectMacro"
    // InternalPreprocess.g:884:1: entryRuleDefineObjectMacro returns [EObject current=null] : iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF ;
    public final EObject entryRuleDefineObjectMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineObjectMacro = null;


        try {
            // InternalPreprocess.g:885:2: (iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF )
            // InternalPreprocess.g:886:2: iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF
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
    // InternalPreprocess.g:893:1: ruleDefineObjectMacro returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLineObject ) ) )? (this_WHITESPACE_6= RULE_WHITESPACE )* ) ;
    public final EObject ruleDefineObjectMacro() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_1=null;
        Token this_WHITESPACE_2=null;
        Token this_WHITESPACE_4=null;
        Token this_WHITESPACE_6=null;
        AntlrDatatypeRuleToken lv_id_3_0 = null;

        AntlrDatatypeRuleToken lv_string_5_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:899:7: ( ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLineObject ) ) )? (this_WHITESPACE_6= RULE_WHITESPACE )* ) )
            // InternalPreprocess.g:901:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLineObject ) ) )? (this_WHITESPACE_6= RULE_WHITESPACE )* )
            {
            // InternalPreprocess.g:901:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLineObject ) ) )? (this_WHITESPACE_6= RULE_WHITESPACE )* )
            // InternalPreprocess.g:902:1: () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLineObject ) ) )? (this_WHITESPACE_6= RULE_WHITESPACE )*
            {
            // InternalPreprocess.g:902:1: ()
            // InternalPreprocess.g:903:2: 
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
            // InternalPreprocess.g:921:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_WHITESPACE) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalPreprocess.g:921:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getDefineObjectMacroAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:928:1: ( (lv_id_3_0= ruleMyCode ) )
            // InternalPreprocess.g:929:1: (lv_id_3_0= ruleMyCode )
            {
            // InternalPreprocess.g:929:1: (lv_id_3_0= ruleMyCode )
            // InternalPreprocess.g:930:3: lv_id_3_0= ruleMyCode
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDefineObjectMacroAccess().getIdMyCodeParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_10);
            lv_id_3_0=ruleMyCode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDefineObjectMacroRule());
              	        }
                     		set(
                     			current, 
                     			"id",
                      		lv_id_3_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.MyCode");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:949:1: ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLineObject ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_WHITESPACE) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==RULE_INCLUDE||(LA14_1>=RULE_DEFINE && LA14_1<=RULE_DEFINED)||(LA14_1>=RULE_SKW_QUESTION && LA14_1<=RULE_BIN_LITERAL)) ) {
                    alt14=1;
                }
                else if ( (LA14_1==RULE_WHITESPACE) ) {
                    int LA14_4 = input.LA(3);

                    if ( (synpred22_InternalPreprocess()) ) {
                        alt14=1;
                    }
                }
            }
            switch (alt14) {
                case 1 :
                    // InternalPreprocess.g:950:1: (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLineObject ) )
                    {
                    // InternalPreprocess.g:950:1: (this_WHITESPACE_4= RULE_WHITESPACE )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_WHITESPACE) ) {
                            int LA13_2 = input.LA(2);

                            if ( (synpred21_InternalPreprocess()) ) {
                                alt13=1;
                            }


                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalPreprocess.g:950:2: this_WHITESPACE_4= RULE_WHITESPACE
                    	    {
                    	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_WHITESPACE_4, grammarAccess.getDefineObjectMacroAccess().getWHITESPACETerminalRuleCall_4_0()); 
                    	          
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

                    // InternalPreprocess.g:957:1: ( (lv_string_5_0= ruleMyDefineLineObject ) )
                    // InternalPreprocess.g:958:1: (lv_string_5_0= ruleMyDefineLineObject )
                    {
                    // InternalPreprocess.g:958:1: (lv_string_5_0= ruleMyDefineLineObject )
                    // InternalPreprocess.g:959:3: lv_string_5_0= ruleMyDefineLineObject
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefineObjectMacroAccess().getStringMyDefineLineObjectParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_10);
                    lv_string_5_0=ruleMyDefineLineObject();

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
                              		"at.jku.weiner.c.preprocess.Preprocess.MyDefineLineObject");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalPreprocess.g:980:1: (this_WHITESPACE_6= RULE_WHITESPACE )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_WHITESPACE) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalPreprocess.g:980:2: this_WHITESPACE_6= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_6=(Token)match(input,RULE_WHITESPACE,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_6, grammarAccess.getDefineObjectMacroAccess().getWHITESPACETerminalRuleCall_5()); 
            	          
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleDefineObjectMacro"


    // $ANTLR start "entryRuleDefineFunctionLikeMacro"
    // InternalPreprocess.g:1001:1: entryRuleDefineFunctionLikeMacro returns [EObject current=null] : iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF ;
    public final EObject entryRuleDefineFunctionLikeMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineFunctionLikeMacro = null;


        try {
            // InternalPreprocess.g:1002:2: (iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF )
            // InternalPreprocess.g:1003:2: iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF
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
    // InternalPreprocess.g:1010:1: ruleDefineFunctionLikeMacro returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN ( (lv_string_8_0= ruleMyDefineLineFunction ) )? ) ;
    public final EObject ruleDefineFunctionLikeMacro() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_1=null;
        Token this_WHITESPACE_2=null;
        Token this_SKW_LEFTPAREN_4=null;
        Token this_WHITESPACE_5=null;
        Token this_SKW_RIGHTPAREN_7=null;
        AntlrDatatypeRuleToken lv_id_3_0 = null;

        EObject lv_list_6_0 = null;

        AntlrDatatypeRuleToken lv_string_8_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1016:7: ( ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN ( (lv_string_8_0= ruleMyDefineLineFunction ) )? ) )
            // InternalPreprocess.g:1018:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN ( (lv_string_8_0= ruleMyDefineLineFunction ) )? )
            {
            // InternalPreprocess.g:1018:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN ( (lv_string_8_0= ruleMyDefineLineFunction ) )? )
            // InternalPreprocess.g:1019:1: () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN ( (lv_string_8_0= ruleMyDefineLineFunction ) )?
            {
            // InternalPreprocess.g:1019:1: ()
            // InternalPreprocess.g:1020:2: 
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
            // InternalPreprocess.g:1038:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_WHITESPACE) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalPreprocess.g:1038:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getDefineFunctionLikeMacroAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:1045:1: ( (lv_id_3_0= ruleMyCode ) )
            // InternalPreprocess.g:1046:1: (lv_id_3_0= ruleMyCode )
            {
            // InternalPreprocess.g:1046:1: (lv_id_3_0= ruleMyCode )
            // InternalPreprocess.g:1047:3: lv_id_3_0= ruleMyCode
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDefineFunctionLikeMacroAccess().getIdMyCodeParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_11);
            lv_id_3_0=ruleMyCode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDefineFunctionLikeMacroRule());
              	        }
                     		set(
                     			current, 
                     			"id",
                      		lv_id_3_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.MyCode");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_SKW_LEFTPAREN_4=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SKW_LEFTPAREN_4, grammarAccess.getDefineFunctionLikeMacroAccess().getSKW_LEFTPARENTerminalRuleCall_4()); 
                  
            }
            // InternalPreprocess.g:1073:1: (this_WHITESPACE_5= RULE_WHITESPACE )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_WHITESPACE) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalPreprocess.g:1073:2: this_WHITESPACE_5= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_5=(Token)match(input,RULE_WHITESPACE,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_5, grammarAccess.getDefineFunctionLikeMacroAccess().getWHITESPACETerminalRuleCall_5()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // InternalPreprocess.g:1080:1: ( (lv_list_6_0= ruleIdentifierList ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID||LA18_0==RULE_SKW_DOT) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalPreprocess.g:1081:1: (lv_list_6_0= ruleIdentifierList )
                    {
                    // InternalPreprocess.g:1081:1: (lv_list_6_0= ruleIdentifierList )
                    // InternalPreprocess.g:1082:3: lv_list_6_0= ruleIdentifierList
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
                              		"at.jku.weiner.c.preprocess.Preprocess.IdentifierList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            this_SKW_RIGHTPAREN_7=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SKW_RIGHTPAREN_7, grammarAccess.getDefineFunctionLikeMacroAccess().getSKW_RIGHTPARENTerminalRuleCall_7()); 
                  
            }
            // InternalPreprocess.g:1108:1: ( (lv_string_8_0= ruleMyDefineLineFunction ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_WHITESPACE && LA19_0<=RULE_INCLUDE)||(LA19_0>=RULE_DEFINE && LA19_0<=RULE_BIN_LITERAL)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalPreprocess.g:1109:1: (lv_string_8_0= ruleMyDefineLineFunction )
                    {
                    // InternalPreprocess.g:1109:1: (lv_string_8_0= ruleMyDefineLineFunction )
                    // InternalPreprocess.g:1110:3: lv_string_8_0= ruleMyDefineLineFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefineFunctionLikeMacroAccess().getStringMyDefineLineFunctionParserRuleCall_8_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_string_8_0=ruleMyDefineLineFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDefineFunctionLikeMacroRule());
                      	        }
                             		set(
                             			current, 
                             			"string",
                              		lv_string_8_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.MyDefineLineFunction");
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
                  		
                   
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleDefineFunctionLikeMacro"


    // $ANTLR start "entryRuleIdentifierList"
    // InternalPreprocess.g:1143:1: entryRuleIdentifierList returns [EObject current=null] : iv_ruleIdentifierList= ruleIdentifierList EOF ;
    public final EObject entryRuleIdentifierList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierList = null;


        try {
            // InternalPreprocess.g:1144:2: (iv_ruleIdentifierList= ruleIdentifierList EOF )
            // InternalPreprocess.g:1145:2: iv_ruleIdentifierList= ruleIdentifierList EOF
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
    // InternalPreprocess.g:1152:1: ruleIdentifierList returns [EObject current=null] : ( () ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) ) ) ;
    public final EObject ruleIdentifierList() throws RecognitionException {
        EObject current = null;

        Token lv_id_1_0=null;
        Token this_WHITESPACE_2=null;
        Token this_SKW_COMMA_3=null;
        Token this_WHITESPACE_4=null;
        Token lv_id_5_0=null;
        Token this_WHITESPACE_6=null;
        Token this_SKW_COMMA_7=null;
        Token this_WHITESPACE_8=null;
        Token lv_varID_10_0=null;
        Token lv_varID_12_0=null;
        AntlrDatatypeRuleToken lv_variadic_9_0 = null;

        AntlrDatatypeRuleToken lv_variadic_11_0 = null;

        AntlrDatatypeRuleToken lv_variadic_13_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1158:7: ( ( () ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) ) ) )
            // InternalPreprocess.g:1160:1: ( () ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) ) )
            {
            // InternalPreprocess.g:1160:1: ( () ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) ) )
            // InternalPreprocess.g:1161:1: () ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) )
            {
            // InternalPreprocess.g:1161:1: ()
            // InternalPreprocess.g:1162:2: 
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

            // InternalPreprocess.g:1173:1: ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==EOF||LA28_1==RULE_WHITESPACE||LA28_1==RULE_SKW_RIGHTPAREN||LA28_1==RULE_SKW_COMMA) ) {
                    alt28=1;
                }
                else if ( (LA28_1==RULE_SKW_DOT) ) {
                    alt28=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA28_0==RULE_SKW_DOT) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalPreprocess.g:1174:1: ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? )
                    {
                    // InternalPreprocess.g:1174:1: ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? )
                    // InternalPreprocess.g:1175:1: ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )?
                    {
                    // InternalPreprocess.g:1175:1: ( (lv_id_1_0= RULE_ID ) )
                    // InternalPreprocess.g:1176:1: (lv_id_1_0= RULE_ID )
                    {
                    // InternalPreprocess.g:1176:1: (lv_id_1_0= RULE_ID )
                    // InternalPreprocess.g:1177:3: lv_id_1_0= RULE_ID
                    {
                    lv_id_1_0=(Token)match(input,RULE_ID,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_id_1_0, grammarAccess.getIdentifierListAccess().getIdIDTerminalRuleCall_1_0_0_0()); 
                      		
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

                    // InternalPreprocess.g:1196:1: ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        alt22 = dfa22.predict(input);
                        switch (alt22) {
                    	case 1 :
                    	    // InternalPreprocess.g:1197:1: (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) )
                    	    {
                    	    // InternalPreprocess.g:1197:1: (this_WHITESPACE_2= RULE_WHITESPACE )*
                    	    loop20:
                    	    do {
                    	        int alt20=2;
                    	        int LA20_0 = input.LA(1);

                    	        if ( (LA20_0==RULE_WHITESPACE) ) {
                    	            alt20=1;
                    	        }


                    	        switch (alt20) {
                    	    	case 1 :
                    	    	    // InternalPreprocess.g:1197:2: this_WHITESPACE_2= RULE_WHITESPACE
                    	    	    {
                    	    	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_16); if (state.failed) return current;
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIdentifierListAccess().getWHITESPACETerminalRuleCall_1_0_1_0()); 
                    	    	          
                    	    	    }

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop20;
                    	        }
                    	    } while (true);

                    	    this_SKW_COMMA_3=(Token)match(input,RULE_SKW_COMMA,FOLLOW_17); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_SKW_COMMA_3, grammarAccess.getIdentifierListAccess().getSKW_COMMATerminalRuleCall_1_0_1_1()); 
                    	          
                    	    }
                    	    // InternalPreprocess.g:1211:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
                    	    loop21:
                    	    do {
                    	        int alt21=2;
                    	        int LA21_0 = input.LA(1);

                    	        if ( (LA21_0==RULE_WHITESPACE) ) {
                    	            alt21=1;
                    	        }


                    	        switch (alt21) {
                    	    	case 1 :
                    	    	    // InternalPreprocess.g:1211:2: this_WHITESPACE_4= RULE_WHITESPACE
                    	    	    {
                    	    	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_17); if (state.failed) return current;
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	          newLeafNode(this_WHITESPACE_4, grammarAccess.getIdentifierListAccess().getWHITESPACETerminalRuleCall_1_0_1_2()); 
                    	    	          
                    	    	    }

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop21;
                    	        }
                    	    } while (true);

                    	    // InternalPreprocess.g:1218:1: ( (lv_id_5_0= RULE_ID ) )
                    	    // InternalPreprocess.g:1219:1: (lv_id_5_0= RULE_ID )
                    	    {
                    	    // InternalPreprocess.g:1219:1: (lv_id_5_0= RULE_ID )
                    	    // InternalPreprocess.g:1220:3: lv_id_5_0= RULE_ID
                    	    {
                    	    lv_id_5_0=(Token)match(input,RULE_ID,FOLLOW_15); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_id_5_0, grammarAccess.getIdentifierListAccess().getIdIDTerminalRuleCall_1_0_1_3_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getIdentifierListRule());
                    	      	        }
                    	             		addWithLastConsumed(
                    	             			current, 
                    	             			"id",
                    	              		lv_id_5_0, 
                    	              		"at.jku.weiner.c.common.Common.ID");
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    // InternalPreprocess.g:1241:1: (this_WHITESPACE_6= RULE_WHITESPACE )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==RULE_WHITESPACE) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalPreprocess.g:1241:2: this_WHITESPACE_6= RULE_WHITESPACE
                    	    {
                    	    this_WHITESPACE_6=(Token)match(input,RULE_WHITESPACE,FOLLOW_15); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_WHITESPACE_6, grammarAccess.getIdentifierListAccess().getWHITESPACETerminalRuleCall_1_0_2()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    // InternalPreprocess.g:1248:1: (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==RULE_SKW_COMMA) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalPreprocess.g:1249:1: this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) )
                            {
                            this_SKW_COMMA_7=(Token)match(input,RULE_SKW_COMMA,FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_SKW_COMMA_7, grammarAccess.getIdentifierListAccess().getSKW_COMMATerminalRuleCall_1_0_3_0()); 
                                  
                            }
                            // InternalPreprocess.g:1256:1: (this_WHITESPACE_8= RULE_WHITESPACE )*
                            loop24:
                            do {
                                int alt24=2;
                                int LA24_0 = input.LA(1);

                                if ( (LA24_0==RULE_WHITESPACE) ) {
                                    alt24=1;
                                }


                                switch (alt24) {
                            	case 1 :
                            	    // InternalPreprocess.g:1256:2: this_WHITESPACE_8= RULE_WHITESPACE
                            	    {
                            	    this_WHITESPACE_8=(Token)match(input,RULE_WHITESPACE,FOLLOW_18); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {
                            	       
                            	          newLeafNode(this_WHITESPACE_8, grammarAccess.getIdentifierListAccess().getWHITESPACETerminalRuleCall_1_0_3_1()); 
                            	          
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop24;
                                }
                            } while (true);

                            // InternalPreprocess.g:1263:1: ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) )
                            int alt25=2;
                            int LA25_0 = input.LA(1);

                            if ( (LA25_0==RULE_SKW_DOT) ) {
                                alt25=1;
                            }
                            else if ( (LA25_0==RULE_ID) ) {
                                alt25=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 25, 0, input);

                                throw nvae;
                            }
                            switch (alt25) {
                                case 1 :
                                    // InternalPreprocess.g:1264:1: ( (lv_variadic_9_0= ruleEllipsis ) )
                                    {
                                    // InternalPreprocess.g:1264:1: ( (lv_variadic_9_0= ruleEllipsis ) )
                                    // InternalPreprocess.g:1265:1: (lv_variadic_9_0= ruleEllipsis )
                                    {
                                    // InternalPreprocess.g:1265:1: (lv_variadic_9_0= ruleEllipsis )
                                    // InternalPreprocess.g:1266:3: lv_variadic_9_0= ruleEllipsis
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getIdentifierListAccess().getVariadicEllipsisParserRuleCall_1_0_3_2_0_0()); 
                                      	    
                                    }
                                    pushFollow(FOLLOW_2);
                                    lv_variadic_9_0=ruleEllipsis();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getIdentifierListRule());
                                      	        }
                                             		set(
                                             			current, 
                                             			"variadic",
                                              		true, 
                                              		"at.jku.weiner.c.common.Common.Ellipsis");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }


                                    }


                                    }
                                    break;
                                case 2 :
                                    // InternalPreprocess.g:1286:1: ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) )
                                    {
                                    // InternalPreprocess.g:1286:1: ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) )
                                    // InternalPreprocess.g:1287:1: ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) )
                                    {
                                    // InternalPreprocess.g:1287:1: ( (lv_varID_10_0= RULE_ID ) )
                                    // InternalPreprocess.g:1288:1: (lv_varID_10_0= RULE_ID )
                                    {
                                    // InternalPreprocess.g:1288:1: (lv_varID_10_0= RULE_ID )
                                    // InternalPreprocess.g:1289:3: lv_varID_10_0= RULE_ID
                                    {
                                    lv_varID_10_0=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_varID_10_0, grammarAccess.getIdentifierListAccess().getVarIDIDTerminalRuleCall_1_0_3_2_1_0_0()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getIdentifierListRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current, 
                                             			"varID",
                                              		lv_varID_10_0, 
                                              		"at.jku.weiner.c.common.Common.ID");
                                      	    
                                    }

                                    }


                                    }

                                    // InternalPreprocess.g:1308:1: ( (lv_variadic_11_0= ruleEllipsis ) )
                                    // InternalPreprocess.g:1309:1: (lv_variadic_11_0= ruleEllipsis )
                                    {
                                    // InternalPreprocess.g:1309:1: (lv_variadic_11_0= ruleEllipsis )
                                    // InternalPreprocess.g:1310:3: lv_variadic_11_0= ruleEllipsis
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getIdentifierListAccess().getVariadicEllipsisParserRuleCall_1_0_3_2_1_1_0()); 
                                      	    
                                    }
                                    pushFollow(FOLLOW_2);
                                    lv_variadic_11_0=ruleEllipsis();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getIdentifierListRule());
                                      	        }
                                             		set(
                                             			current, 
                                             			"variadic",
                                              		true, 
                                              		"at.jku.weiner.c.common.Common.Ellipsis");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }


                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:1338:1: ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) )
                    {
                    // InternalPreprocess.g:1338:1: ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) )
                    // InternalPreprocess.g:1339:1: ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) )
                    {
                    // InternalPreprocess.g:1339:1: ( (lv_varID_12_0= RULE_ID ) )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==RULE_ID) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // InternalPreprocess.g:1340:1: (lv_varID_12_0= RULE_ID )
                            {
                            // InternalPreprocess.g:1340:1: (lv_varID_12_0= RULE_ID )
                            // InternalPreprocess.g:1341:3: lv_varID_12_0= RULE_ID
                            {
                            lv_varID_12_0=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_varID_12_0, grammarAccess.getIdentifierListAccess().getVarIDIDTerminalRuleCall_1_1_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getIdentifierListRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"varID",
                                      		lv_varID_12_0, 
                                      		"at.jku.weiner.c.common.Common.ID");
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // InternalPreprocess.g:1360:1: ( (lv_variadic_13_0= ruleEllipsis ) )
                    // InternalPreprocess.g:1361:1: (lv_variadic_13_0= ruleEllipsis )
                    {
                    // InternalPreprocess.g:1361:1: (lv_variadic_13_0= ruleEllipsis )
                    // InternalPreprocess.g:1362:3: lv_variadic_13_0= ruleEllipsis
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIdentifierListAccess().getVariadicEllipsisParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_variadic_13_0=ruleEllipsis();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIdentifierListRule());
                      	        }
                             		set(
                             			current, 
                             			"variadic",
                              		true, 
                              		"at.jku.weiner.c.common.Common.Ellipsis");
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleIdentifierList"


    // $ANTLR start "entryRuleLineDirective"
    // InternalPreprocess.g:1399:1: entryRuleLineDirective returns [EObject current=null] : iv_ruleLineDirective= ruleLineDirective EOF ;
    public final EObject entryRuleLineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLineDirective = null;


        try {
            // InternalPreprocess.g:1400:2: (iv_ruleLineDirective= ruleLineDirective EOF )
            // InternalPreprocess.g:1401:2: iv_ruleLineDirective= ruleLineDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLineDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLineDirective=ruleLineDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLineDirective; 
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
    // $ANTLR end "entryRuleLineDirective"


    // $ANTLR start "ruleLineDirective"
    // InternalPreprocess.g:1408:1: ruleLineDirective returns [EObject current=null] : ( () this_LINE_1= RULE_LINE (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_line_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_path_5_0= ruleMyCode ) ) )? ) ;
    public final EObject ruleLineDirective() throws RecognitionException {
        EObject current = null;

        Token this_LINE_1=null;
        Token this_WHITESPACE_2=null;
        Token this_WHITESPACE_4=null;
        AntlrDatatypeRuleToken lv_line_3_0 = null;

        AntlrDatatypeRuleToken lv_path_5_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1414:7: ( ( () this_LINE_1= RULE_LINE (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_line_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_path_5_0= ruleMyCode ) ) )? ) )
            // InternalPreprocess.g:1416:1: ( () this_LINE_1= RULE_LINE (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_line_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_path_5_0= ruleMyCode ) ) )? )
            {
            // InternalPreprocess.g:1416:1: ( () this_LINE_1= RULE_LINE (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_line_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_path_5_0= ruleMyCode ) ) )? )
            // InternalPreprocess.g:1417:1: () this_LINE_1= RULE_LINE (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_line_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_path_5_0= ruleMyCode ) ) )?
            {
            // InternalPreprocess.g:1417:1: ()
            // InternalPreprocess.g:1418:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getLineDirectiveAccess().getLineDirectiveAction_0(),
                          current);
                  
            }

            }

            this_LINE_1=(Token)match(input,RULE_LINE,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LINE_1, grammarAccess.getLineDirectiveAccess().getLINETerminalRuleCall_1()); 
                  
            }
            // InternalPreprocess.g:1436:1: (this_WHITESPACE_2= RULE_WHITESPACE )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_WHITESPACE) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalPreprocess.g:1436:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getLineDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // InternalPreprocess.g:1443:1: ( (lv_line_3_0= ruleMyCode ) )
            // InternalPreprocess.g:1444:1: (lv_line_3_0= ruleMyCode )
            {
            // InternalPreprocess.g:1444:1: (lv_line_3_0= ruleMyCode )
            // InternalPreprocess.g:1445:3: lv_line_3_0= ruleMyCode
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLineDirectiveAccess().getLineMyCodeParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_10);
            lv_line_3_0=ruleMyCode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLineDirectiveRule());
              	        }
                     		set(
                     			current, 
                     			"line",
                      		lv_line_3_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.MyCode");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:1464:1: ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_path_5_0= ruleMyCode ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_WHITESPACE) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalPreprocess.g:1465:1: (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_path_5_0= ruleMyCode ) )
                    {
                    // InternalPreprocess.g:1465:1: (this_WHITESPACE_4= RULE_WHITESPACE )+
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
                    	    // InternalPreprocess.g:1465:2: this_WHITESPACE_4= RULE_WHITESPACE
                    	    {
                    	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_WHITESPACE_4, grammarAccess.getLineDirectiveAccess().getWHITESPACETerminalRuleCall_4_0()); 
                    	          
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

                    // InternalPreprocess.g:1472:1: ( (lv_path_5_0= ruleMyCode ) )
                    // InternalPreprocess.g:1473:1: (lv_path_5_0= ruleMyCode )
                    {
                    // InternalPreprocess.g:1473:1: (lv_path_5_0= ruleMyCode )
                    // InternalPreprocess.g:1474:3: lv_path_5_0= ruleMyCode
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLineDirectiveAccess().getPathMyCodeParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_path_5_0=ruleMyCode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLineDirectiveRule());
                      	        }
                             		set(
                             			current, 
                             			"path",
                              		lv_path_5_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.MyCode");
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleLineDirective"


    // $ANTLR start "entryRuleErrorDirective"
    // InternalPreprocess.g:1509:1: entryRuleErrorDirective returns [EObject current=null] : iv_ruleErrorDirective= ruleErrorDirective EOF ;
    public final EObject entryRuleErrorDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorDirective = null;


        try {
            // InternalPreprocess.g:1510:2: (iv_ruleErrorDirective= ruleErrorDirective EOF )
            // InternalPreprocess.g:1511:2: iv_ruleErrorDirective= ruleErrorDirective EOF
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
    // InternalPreprocess.g:1518:1: ruleErrorDirective returns [EObject current=null] : ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? ) ;
    public final EObject ruleErrorDirective() throws RecognitionException {
        EObject current = null;

        Token this_ERROR_1=null;
        Token this_WHITESPACE_2=null;
        AntlrDatatypeRuleToken lv_msg_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1524:7: ( ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? ) )
            // InternalPreprocess.g:1526:1: ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? )
            {
            // InternalPreprocess.g:1526:1: ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? )
            // InternalPreprocess.g:1527:1: () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )?
            {
            // InternalPreprocess.g:1527:1: ()
            // InternalPreprocess.g:1528:2: 
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

            this_ERROR_1=(Token)match(input,RULE_ERROR,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ERROR_1, grammarAccess.getErrorDirectiveAccess().getERRORTerminalRuleCall_1()); 
                  
            }
            // InternalPreprocess.g:1546:1: (this_WHITESPACE_2= RULE_WHITESPACE )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_WHITESPACE) ) {
                    int LA32_2 = input.LA(2);

                    if ( (synpred40_InternalPreprocess()) ) {
                        alt32=1;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // InternalPreprocess.g:1546:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getErrorDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            // InternalPreprocess.g:1553:1: ( (lv_msg_3_0= ruleMyCodeLine ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_WHITESPACE||LA33_0==RULE_INCLUDE||(LA33_0>=RULE_DEFINE && LA33_0<=RULE_DEFINED)||(LA33_0>=RULE_SKW_QUESTION && LA33_0<=RULE_BIN_LITERAL)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalPreprocess.g:1554:1: (lv_msg_3_0= ruleMyCodeLine )
                    {
                    // InternalPreprocess.g:1554:1: (lv_msg_3_0= ruleMyCodeLine )
                    // InternalPreprocess.g:1555:3: lv_msg_3_0= ruleMyCodeLine
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleErrorDirective"


    // $ANTLR start "entryRuleWarningDirective"
    // InternalPreprocess.g:1588:1: entryRuleWarningDirective returns [EObject current=null] : iv_ruleWarningDirective= ruleWarningDirective EOF ;
    public final EObject entryRuleWarningDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWarningDirective = null;


        try {
            // InternalPreprocess.g:1589:2: (iv_ruleWarningDirective= ruleWarningDirective EOF )
            // InternalPreprocess.g:1590:2: iv_ruleWarningDirective= ruleWarningDirective EOF
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
    // InternalPreprocess.g:1597:1: ruleWarningDirective returns [EObject current=null] : ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? ) ;
    public final EObject ruleWarningDirective() throws RecognitionException {
        EObject current = null;

        Token this_WARNING_1=null;
        Token this_WHITESPACE_2=null;
        AntlrDatatypeRuleToken lv_msg_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1603:7: ( ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? ) )
            // InternalPreprocess.g:1605:1: ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? )
            {
            // InternalPreprocess.g:1605:1: ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? )
            // InternalPreprocess.g:1606:1: () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )?
            {
            // InternalPreprocess.g:1606:1: ()
            // InternalPreprocess.g:1607:2: 
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

            this_WARNING_1=(Token)match(input,RULE_WARNING,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_WARNING_1, grammarAccess.getWarningDirectiveAccess().getWARNINGTerminalRuleCall_1()); 
                  
            }
            // InternalPreprocess.g:1625:1: (this_WHITESPACE_2= RULE_WHITESPACE )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_WHITESPACE) ) {
                    int LA34_2 = input.LA(2);

                    if ( (synpred42_InternalPreprocess()) ) {
                        alt34=1;
                    }


                }


                switch (alt34) {
            	case 1 :
            	    // InternalPreprocess.g:1625:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getWarningDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            // InternalPreprocess.g:1632:1: ( (lv_msg_3_0= ruleMyCodeLine ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_WHITESPACE||LA35_0==RULE_INCLUDE||(LA35_0>=RULE_DEFINE && LA35_0<=RULE_DEFINED)||(LA35_0>=RULE_SKW_QUESTION && LA35_0<=RULE_BIN_LITERAL)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalPreprocess.g:1633:1: (lv_msg_3_0= ruleMyCodeLine )
                    {
                    // InternalPreprocess.g:1633:1: (lv_msg_3_0= ruleMyCodeLine )
                    // InternalPreprocess.g:1634:3: lv_msg_3_0= ruleMyCodeLine
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleWarningDirective"


    // $ANTLR start "entryRuleUnDefineDirective"
    // InternalPreprocess.g:1667:1: entryRuleUnDefineDirective returns [EObject current=null] : iv_ruleUnDefineDirective= ruleUnDefineDirective EOF ;
    public final EObject entryRuleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnDefineDirective = null;


        try {
            // InternalPreprocess.g:1668:2: (iv_ruleUnDefineDirective= ruleUnDefineDirective EOF )
            // InternalPreprocess.g:1669:2: iv_ruleUnDefineDirective= ruleUnDefineDirective EOF
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
    // InternalPreprocess.g:1676:1: ruleUnDefineDirective returns [EObject current=null] : ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* ) ;
    public final EObject ruleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        Token this_UNDEF_1=null;
        Token this_WHITESPACE_2=null;
        Token lv_id_3_0=null;
        Token this_WHITESPACE_4=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1682:7: ( ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* ) )
            // InternalPreprocess.g:1684:1: ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* )
            {
            // InternalPreprocess.g:1684:1: ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* )
            // InternalPreprocess.g:1685:1: () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )*
            {
            // InternalPreprocess.g:1685:1: ()
            // InternalPreprocess.g:1686:2: 
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
            // InternalPreprocess.g:1704:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_WHITESPACE) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalPreprocess.g:1704:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getUnDefineDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:1711:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:1712:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:1712:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:1713:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
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

            // InternalPreprocess.g:1732:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_WHITESPACE) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalPreprocess.g:1732:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getUnDefineDirectiveAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleUnDefineDirective"


    // $ANTLR start "entryRuleConditionalDirective"
    // InternalPreprocess.g:1753:1: entryRuleConditionalDirective returns [EObject current=null] : iv_ruleConditionalDirective= ruleConditionalDirective EOF ;
    public final EObject entryRuleConditionalDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalDirective = null;


        try {
            // InternalPreprocess.g:1754:2: (iv_ruleConditionalDirective= ruleConditionalDirective EOF )
            // InternalPreprocess.g:1755:2: iv_ruleConditionalDirective= ruleConditionalDirective EOF
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
    // InternalPreprocess.g:1762:1: ruleConditionalDirective returns [EObject current=null] : ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* ) ;
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
            // InternalPreprocess.g:1768:7: ( ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* ) )
            // InternalPreprocess.g:1770:1: ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* )
            {
            // InternalPreprocess.g:1770:1: ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* )
            // InternalPreprocess.g:1771:1: () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )*
            {
            // InternalPreprocess.g:1771:1: ()
            // InternalPreprocess.g:1772:2: 
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

            // InternalPreprocess.g:1783:1: ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) )
            // InternalPreprocess.g:1784:1: ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) )
            {
            // InternalPreprocess.g:1784:1: ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) )
            // InternalPreprocess.g:1785:1: (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional )
            {
            // InternalPreprocess.g:1785:1: (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional )
            int alt38=3;
            switch ( input.LA(1) ) {
            case RULE_IF:
                {
                alt38=1;
                }
                break;
            case RULE_IFDEF:
                {
                alt38=2;
                }
                break;
            case RULE_IFNOTDEF:
                {
                alt38=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalPreprocess.g:1786:3: lv_conditional_1_1= ruleIfConditional
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
                    // InternalPreprocess.g:1801:8: lv_conditional_1_2= ruleIfDefConditional
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
                    // InternalPreprocess.g:1816:8: lv_conditional_1_3= ruleIfNotDefConditional
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

            // InternalPreprocess.g:1837:1: ( (lv_elifs_2_0= ruleElIfConditional ) )*
            loop39:
            do {
                int alt39=2;
                alt39 = dfa39.predict(input);
                switch (alt39) {
            	case 1 :
            	    // InternalPreprocess.g:1838:1: (lv_elifs_2_0= ruleElIfConditional )
            	    {
            	    // InternalPreprocess.g:1838:1: (lv_elifs_2_0= ruleElIfConditional )
            	    // InternalPreprocess.g:1839:3: lv_elifs_2_0= ruleElIfConditional
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
            	    break loop39;
                }
            } while (true);

            // InternalPreprocess.g:1858:1: ( (lv_else_3_0= ruleElseConditional ) )?
            int alt40=2;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // InternalPreprocess.g:1859:1: (lv_else_3_0= ruleElseConditional )
                    {
                    // InternalPreprocess.g:1859:1: (lv_else_3_0= ruleElseConditional )
                    // InternalPreprocess.g:1860:3: lv_else_3_0= ruleElseConditional
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

            // InternalPreprocess.g:1879:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_WHITESPACE) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalPreprocess.g:1879:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getConditionalDirectiveAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            this_HASH_5=(Token)match(input,RULE_HASH,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_5, grammarAccess.getConditionalDirectiveAccess().getHASHTerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:1893:1: (this_WHITESPACE_6= RULE_WHITESPACE )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_WHITESPACE) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalPreprocess.g:1893:2: this_WHITESPACE_6= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_6=(Token)match(input,RULE_WHITESPACE,FOLLOW_20); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_6, grammarAccess.getConditionalDirectiveAccess().getWHITESPACETerminalRuleCall_6()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            this_ENDIF_7=(Token)match(input,RULE_ENDIF,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ENDIF_7, grammarAccess.getConditionalDirectiveAccess().getENDIFTerminalRuleCall_7()); 
                  
            }
            // InternalPreprocess.g:1907:1: (this_WHITESPACE_8= RULE_WHITESPACE )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_WHITESPACE) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalPreprocess.g:1907:2: this_WHITESPACE_8= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_8=(Token)match(input,RULE_WHITESPACE,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_8, grammarAccess.getConditionalDirectiveAccess().getWHITESPACETerminalRuleCall_8()); 
            	          
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleConditionalDirective"


    // $ANTLR start "entryRuleIfConditional"
    // InternalPreprocess.g:1928:1: entryRuleIfConditional returns [EObject current=null] : iv_ruleIfConditional= ruleIfConditional EOF ;
    public final EObject entryRuleIfConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfConditional = null;


        try {
            // InternalPreprocess.g:1929:2: (iv_ruleIfConditional= ruleIfConditional EOF )
            // InternalPreprocess.g:1930:2: iv_ruleIfConditional= ruleIfConditional EOF
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
    // InternalPreprocess.g:1937:1: ruleIfConditional returns [EObject current=null] : ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleExpression ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleIfConditional() throws RecognitionException {
        EObject current = null;

        Token this_IF_1=null;
        Token this_WHITESPACE_2=null;
        Token this_WHITESPACE_4=null;
        Token this_NEWLINE_5=null;
        EObject lv_expression_3_0 = null;

        EObject lv_group_6_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1943:7: ( ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleExpression ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:1945:1: ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleExpression ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:1945:1: ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleExpression ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:1946:1: () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleExpression ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:1946:1: ()
            // InternalPreprocess.g:1947:2: 
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
            // InternalPreprocess.g:1965:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt44=0;
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_WHITESPACE) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalPreprocess.g:1965:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIfConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt44 >= 1 ) break loop44;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(44, input);
                        throw eee;
                }
                cnt44++;
            } while (true);

            // InternalPreprocess.g:1972:1: ( (lv_expression_3_0= ruleExpression ) )
            // InternalPreprocess.g:1973:1: (lv_expression_3_0= ruleExpression )
            {
            // InternalPreprocess.g:1973:1: (lv_expression_3_0= ruleExpression )
            // InternalPreprocess.g:1974:3: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfConditionalAccess().getExpressionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_21);
            lv_expression_3_0=ruleExpression();

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
                      		"at.jku.weiner.c.common.Common.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:1993:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_WHITESPACE) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalPreprocess.g:1993:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getIfConditionalAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_5, grammarAccess.getIfConditionalAccess().getNEWLINETerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:2007:1: ( (lv_group_6_0= ruleGroupOpt ) )
            // InternalPreprocess.g:2008:1: (lv_group_6_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:2008:1: (lv_group_6_0= ruleGroupOpt )
            // InternalPreprocess.g:2009:3: lv_group_6_0= ruleGroupOpt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfConditionalAccess().getGroupGroupOptParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_group_6_0=ruleGroupOpt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfConditionalRule());
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
                  		
                   
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleIfConditional"


    // $ANTLR start "entryRuleIfDefConditional"
    // InternalPreprocess.g:2042:1: entryRuleIfDefConditional returns [EObject current=null] : iv_ruleIfDefConditional= ruleIfDefConditional EOF ;
    public final EObject entryRuleIfDefConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfDefConditional = null;


        try {
            // InternalPreprocess.g:2043:2: (iv_ruleIfDefConditional= ruleIfDefConditional EOF )
            // InternalPreprocess.g:2044:2: iv_ruleIfDefConditional= ruleIfDefConditional EOF
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
    // InternalPreprocess.g:2051:1: ruleIfDefConditional returns [EObject current=null] : ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleIfDefConditional() throws RecognitionException {
        EObject current = null;

        Token this_IFDEF_1=null;
        Token this_WHITESPACE_2=null;
        Token lv_id_3_0=null;
        Token this_WHITESPACE_4=null;
        Token this_NEWLINE_5=null;
        EObject lv_group_6_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2057:7: ( ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:2059:1: ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:2059:1: ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:2060:1: () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:2060:1: ()
            // InternalPreprocess.g:2061:2: 
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
            // InternalPreprocess.g:2079:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt46=0;
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_WHITESPACE) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalPreprocess.g:2079:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIfDefConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt46 >= 1 ) break loop46;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(46, input);
                        throw eee;
                }
                cnt46++;
            } while (true);

            // InternalPreprocess.g:2086:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:2087:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:2087:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:2088:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_21); if (state.failed) return current;
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

            // InternalPreprocess.g:2107:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_WHITESPACE) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalPreprocess.g:2107:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getIfDefConditionalAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_5, grammarAccess.getIfDefConditionalAccess().getNEWLINETerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:2121:1: ( (lv_group_6_0= ruleGroupOpt ) )
            // InternalPreprocess.g:2122:1: (lv_group_6_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:2122:1: (lv_group_6_0= ruleGroupOpt )
            // InternalPreprocess.g:2123:3: lv_group_6_0= ruleGroupOpt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfDefConditionalAccess().getGroupGroupOptParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_group_6_0=ruleGroupOpt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfDefConditionalRule());
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
                  		
                   
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleIfDefConditional"


    // $ANTLR start "entryRuleIfNotDefConditional"
    // InternalPreprocess.g:2156:1: entryRuleIfNotDefConditional returns [EObject current=null] : iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF ;
    public final EObject entryRuleIfNotDefConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfNotDefConditional = null;


        try {
            // InternalPreprocess.g:2157:2: (iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF )
            // InternalPreprocess.g:2158:2: iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF
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
    // InternalPreprocess.g:2165:1: ruleIfNotDefConditional returns [EObject current=null] : ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleIfNotDefConditional() throws RecognitionException {
        EObject current = null;

        Token this_IFNOTDEF_1=null;
        Token this_WHITESPACE_2=null;
        Token lv_id_3_0=null;
        Token this_WHITESPACE_4=null;
        Token this_NEWLINE_5=null;
        EObject lv_group_6_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2171:7: ( ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:2173:1: ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:2173:1: ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:2174:1: () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:2174:1: ()
            // InternalPreprocess.g:2175:2: 
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
            // InternalPreprocess.g:2193:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_WHITESPACE) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalPreprocess.g:2193:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIfNotDefConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt48 >= 1 ) break loop48;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
            } while (true);

            // InternalPreprocess.g:2200:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:2201:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:2201:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:2202:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_21); if (state.failed) return current;
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

            // InternalPreprocess.g:2221:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_WHITESPACE) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalPreprocess.g:2221:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getIfNotDefConditionalAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_5, grammarAccess.getIfNotDefConditionalAccess().getNEWLINETerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:2235:1: ( (lv_group_6_0= ruleGroupOpt ) )
            // InternalPreprocess.g:2236:1: (lv_group_6_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:2236:1: (lv_group_6_0= ruleGroupOpt )
            // InternalPreprocess.g:2237:3: lv_group_6_0= ruleGroupOpt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfNotDefConditionalAccess().getGroupGroupOptParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_group_6_0=ruleGroupOpt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfNotDefConditionalRule());
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
                  		
                   
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleIfNotDefConditional"


    // $ANTLR start "entryRuleElIfConditional"
    // InternalPreprocess.g:2270:1: entryRuleElIfConditional returns [EObject current=null] : iv_ruleElIfConditional= ruleElIfConditional EOF ;
    public final EObject entryRuleElIfConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElIfConditional = null;


        try {
            // InternalPreprocess.g:2271:2: (iv_ruleElIfConditional= ruleElIfConditional EOF )
            // InternalPreprocess.g:2272:2: iv_ruleElIfConditional= ruleElIfConditional EOF
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
    // InternalPreprocess.g:2279:1: ruleElIfConditional returns [EObject current=null] : ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleExpression ) ) (this_WHITESPACE_7= RULE_WHITESPACE )* this_NEWLINE_8= RULE_NEWLINE ( (lv_group_9_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleElIfConditional() throws RecognitionException {
        EObject current = null;

        Token this_WHITESPACE_1=null;
        Token this_HASH_2=null;
        Token this_WHITESPACE_3=null;
        Token this_ELIF_4=null;
        Token this_WHITESPACE_5=null;
        Token this_WHITESPACE_7=null;
        Token this_NEWLINE_8=null;
        EObject lv_expression_6_0 = null;

        EObject lv_group_9_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2285:7: ( ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleExpression ) ) (this_WHITESPACE_7= RULE_WHITESPACE )* this_NEWLINE_8= RULE_NEWLINE ( (lv_group_9_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:2287:1: ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleExpression ) ) (this_WHITESPACE_7= RULE_WHITESPACE )* this_NEWLINE_8= RULE_NEWLINE ( (lv_group_9_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:2287:1: ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleExpression ) ) (this_WHITESPACE_7= RULE_WHITESPACE )* this_NEWLINE_8= RULE_NEWLINE ( (lv_group_9_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:2288:1: () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleExpression ) ) (this_WHITESPACE_7= RULE_WHITESPACE )* this_NEWLINE_8= RULE_NEWLINE ( (lv_group_9_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:2288:1: ()
            // InternalPreprocess.g:2289:2: 
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

            // InternalPreprocess.g:2300:1: ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF )
            // InternalPreprocess.g:2301:1: (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF
            {
            // InternalPreprocess.g:2301:1: (this_WHITESPACE_1= RULE_WHITESPACE )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_WHITESPACE) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalPreprocess.g:2301:2: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_1_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_2, grammarAccess.getElIfConditionalAccess().getHASHTerminalRuleCall_1_1()); 
                  
            }
            // InternalPreprocess.g:2315:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_WHITESPACE) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalPreprocess.g:2315:2: this_WHITESPACE_3= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_3, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_1_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            this_ELIF_4=(Token)match(input,RULE_ELIF,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ELIF_4, grammarAccess.getElIfConditionalAccess().getELIFTerminalRuleCall_1_3()); 
                  
            }

            }

            // InternalPreprocess.g:2331:1: (this_WHITESPACE_5= RULE_WHITESPACE )+
            int cnt52=0;
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_WHITESPACE) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalPreprocess.g:2331:2: this_WHITESPACE_5= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_5=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_5, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt52 >= 1 ) break loop52;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(52, input);
                        throw eee;
                }
                cnt52++;
            } while (true);

            // InternalPreprocess.g:2338:1: ( (lv_expression_6_0= ruleExpression ) )
            // InternalPreprocess.g:2339:1: (lv_expression_6_0= ruleExpression )
            {
            // InternalPreprocess.g:2339:1: (lv_expression_6_0= ruleExpression )
            // InternalPreprocess.g:2340:3: lv_expression_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElIfConditionalAccess().getExpressionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_21);
            lv_expression_6_0=ruleExpression();

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
                      		"at.jku.weiner.c.common.Common.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:2359:1: (this_WHITESPACE_7= RULE_WHITESPACE )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_WHITESPACE) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalPreprocess.g:2359:2: this_WHITESPACE_7= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_7=(Token)match(input,RULE_WHITESPACE,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_7, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            this_NEWLINE_8=(Token)match(input,RULE_NEWLINE,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_8, grammarAccess.getElIfConditionalAccess().getNEWLINETerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:2373:1: ( (lv_group_9_0= ruleGroupOpt ) )
            // InternalPreprocess.g:2374:1: (lv_group_9_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:2374:1: (lv_group_9_0= ruleGroupOpt )
            // InternalPreprocess.g:2375:3: lv_group_9_0= ruleGroupOpt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElIfConditionalAccess().getGroupGroupOptParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_group_9_0=ruleGroupOpt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElIfConditionalRule());
              	        }
                     		set(
                     			current, 
                     			"group",
                      		lv_group_9_0, 
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleElIfConditional"


    // $ANTLR start "entryRuleElseConditional"
    // InternalPreprocess.g:2408:1: entryRuleElseConditional returns [EObject current=null] : iv_ruleElseConditional= ruleElseConditional EOF ;
    public final EObject entryRuleElseConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseConditional = null;


        try {
            // InternalPreprocess.g:2409:2: (iv_ruleElseConditional= ruleElseConditional EOF )
            // InternalPreprocess.g:2410:2: iv_ruleElseConditional= ruleElseConditional EOF
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
    // InternalPreprocess.g:2417:1: ruleElseConditional returns [EObject current=null] : ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE (this_WHITESPACE_5= RULE_WHITESPACE )* this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) ) ) ;
    public final EObject ruleElseConditional() throws RecognitionException {
        EObject current = null;

        Token this_WHITESPACE_1=null;
        Token this_HASH_2=null;
        Token this_WHITESPACE_3=null;
        Token this_ELSE_4=null;
        Token this_WHITESPACE_5=null;
        Token this_NEWLINE_6=null;
        EObject lv_group_7_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2423:7: ( ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE (this_WHITESPACE_5= RULE_WHITESPACE )* this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:2425:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE (this_WHITESPACE_5= RULE_WHITESPACE )* this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:2425:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE (this_WHITESPACE_5= RULE_WHITESPACE )* this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:2426:1: () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE (this_WHITESPACE_5= RULE_WHITESPACE )* this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:2426:1: ()
            // InternalPreprocess.g:2427:2: 
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

            // InternalPreprocess.g:2438:1: (this_WHITESPACE_1= RULE_WHITESPACE )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_WHITESPACE) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalPreprocess.g:2438:2: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getElseConditionalAccess().getWHITESPACETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_2, grammarAccess.getElseConditionalAccess().getHASHTerminalRuleCall_2()); 
                  
            }
            // InternalPreprocess.g:2452:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_WHITESPACE) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalPreprocess.g:2452:2: this_WHITESPACE_3= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_3, grammarAccess.getElseConditionalAccess().getWHITESPACETerminalRuleCall_3()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            this_ELSE_4=(Token)match(input,RULE_ELSE,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ELSE_4, grammarAccess.getElseConditionalAccess().getELSETerminalRuleCall_4()); 
                  
            }
            // InternalPreprocess.g:2466:1: (this_WHITESPACE_5= RULE_WHITESPACE )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==RULE_WHITESPACE) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalPreprocess.g:2466:2: this_WHITESPACE_5= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_5=(Token)match(input,RULE_WHITESPACE,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_5, grammarAccess.getElseConditionalAccess().getWHITESPACETerminalRuleCall_5()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

            this_NEWLINE_6=(Token)match(input,RULE_NEWLINE,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_6, grammarAccess.getElseConditionalAccess().getNEWLINETerminalRuleCall_6()); 
                  
            }
            // InternalPreprocess.g:2480:1: ( (lv_group_7_0= ruleGroupOpt ) )
            // InternalPreprocess.g:2481:1: (lv_group_7_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:2481:1: (lv_group_7_0= ruleGroupOpt )
            // InternalPreprocess.g:2482:3: lv_group_7_0= ruleGroupOpt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElseConditionalAccess().getGroupGroupOptParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_group_7_0=ruleGroupOpt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElseConditionalRule());
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleElseConditional"


    // $ANTLR start "entryRulePragmaDirective"
    // InternalPreprocess.g:2515:1: entryRulePragmaDirective returns [EObject current=null] : iv_rulePragmaDirective= rulePragmaDirective EOF ;
    public final EObject entryRulePragmaDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePragmaDirective = null;


        try {
            // InternalPreprocess.g:2516:2: (iv_rulePragmaDirective= rulePragmaDirective EOF )
            // InternalPreprocess.g:2517:2: iv_rulePragmaDirective= rulePragmaDirective EOF
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
    // InternalPreprocess.g:2524:1: rulePragmaDirective returns [EObject current=null] : ( () this_PRAGMA_1= RULE_PRAGMA (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_pragma_3_0= ruleMyCodeLine ) )? ) ;
    public final EObject rulePragmaDirective() throws RecognitionException {
        EObject current = null;

        Token this_PRAGMA_1=null;
        Token this_WHITESPACE_2=null;
        AntlrDatatypeRuleToken lv_pragma_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2530:7: ( ( () this_PRAGMA_1= RULE_PRAGMA (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_pragma_3_0= ruleMyCodeLine ) )? ) )
            // InternalPreprocess.g:2532:1: ( () this_PRAGMA_1= RULE_PRAGMA (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_pragma_3_0= ruleMyCodeLine ) )? )
            {
            // InternalPreprocess.g:2532:1: ( () this_PRAGMA_1= RULE_PRAGMA (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_pragma_3_0= ruleMyCodeLine ) )? )
            // InternalPreprocess.g:2533:1: () this_PRAGMA_1= RULE_PRAGMA (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_pragma_3_0= ruleMyCodeLine ) )?
            {
            // InternalPreprocess.g:2533:1: ()
            // InternalPreprocess.g:2534:2: 
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

            this_PRAGMA_1=(Token)match(input,RULE_PRAGMA,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_PRAGMA_1, grammarAccess.getPragmaDirectiveAccess().getPRAGMATerminalRuleCall_1()); 
                  
            }
            // InternalPreprocess.g:2552:1: (this_WHITESPACE_2= RULE_WHITESPACE )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==RULE_WHITESPACE) ) {
                    int LA57_2 = input.LA(2);

                    if ( (synpred66_InternalPreprocess()) ) {
                        alt57=1;
                    }


                }


                switch (alt57) {
            	case 1 :
            	    // InternalPreprocess.g:2552:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getPragmaDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            // InternalPreprocess.g:2559:1: ( (lv_pragma_3_0= ruleMyCodeLine ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_WHITESPACE||LA58_0==RULE_INCLUDE||(LA58_0>=RULE_DEFINE && LA58_0<=RULE_DEFINED)||(LA58_0>=RULE_SKW_QUESTION && LA58_0<=RULE_BIN_LITERAL)) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalPreprocess.g:2560:1: (lv_pragma_3_0= ruleMyCodeLine )
                    {
                    // InternalPreprocess.g:2560:1: (lv_pragma_3_0= ruleMyCodeLine )
                    // InternalPreprocess.g:2561:3: lv_pragma_3_0= ruleMyCodeLine
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPragmaDirectiveAccess().getPragmaMyCodeLineParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_pragma_3_0=ruleMyCodeLine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPragmaDirectiveRule());
                      	        }
                             		set(
                             			current, 
                             			"pragma",
                              		lv_pragma_3_0, 
                              		"at.jku.weiner.c.preprocess.Preprocess.MyCodeLine");
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
                  		
                   
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "rulePragmaDirective"


    // $ANTLR start "entryRuleNullDirective"
    // InternalPreprocess.g:2594:1: entryRuleNullDirective returns [EObject current=null] : iv_ruleNullDirective= ruleNullDirective EOF ;
    public final EObject entryRuleNullDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullDirective = null;


        try {
            // InternalPreprocess.g:2595:2: (iv_ruleNullDirective= ruleNullDirective EOF )
            // InternalPreprocess.g:2596:2: iv_ruleNullDirective= ruleNullDirective EOF
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
    // InternalPreprocess.g:2603:1: ruleNullDirective returns [EObject current=null] : () ;
    public final EObject ruleNullDirective() throws RecognitionException {
        EObject current = null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2609:7: ( () )
            // InternalPreprocess.g:2611:1: ()
            {
            // InternalPreprocess.g:2611:1: ()
            // InternalPreprocess.g:2612:2: 
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleNullDirective"


    // $ANTLR start "entryRuleNewLineLine"
    // InternalPreprocess.g:2635:1: entryRuleNewLineLine returns [EObject current=null] : iv_ruleNewLineLine= ruleNewLineLine EOF ;
    public final EObject entryRuleNewLineLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewLineLine = null;


        try {
            // InternalPreprocess.g:2636:2: (iv_ruleNewLineLine= ruleNewLineLine EOF )
            // InternalPreprocess.g:2637:2: iv_ruleNewLineLine= ruleNewLineLine EOF
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
    // InternalPreprocess.g:2644:1: ruleNewLineLine returns [EObject current=null] : () ;
    public final EObject ruleNewLineLine() throws RecognitionException {
        EObject current = null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2650:7: ( () )
            // InternalPreprocess.g:2652:1: ()
            {
            // InternalPreprocess.g:2652:1: ()
            // InternalPreprocess.g:2653:2: 
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
                  		
                   
            }
        }
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleNewLineLine"


    // $ANTLR start "entryRuleCode"
    // InternalPreprocess.g:2676:1: entryRuleCode returns [EObject current=null] : iv_ruleCode= ruleCode EOF ;
    public final EObject entryRuleCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCode = null;


        try {
            // InternalPreprocess.g:2677:2: (iv_ruleCode= ruleCode EOF )
            // InternalPreprocess.g:2678:2: iv_ruleCode= ruleCode EOF
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
    // InternalPreprocess.g:2685:1: ruleCode returns [EObject current=null] : ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) ) ;
    public final EObject ruleCode() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_code_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2691:7: ( ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) ) )
            // InternalPreprocess.g:2693:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) )
            {
            // InternalPreprocess.g:2693:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) )
            // InternalPreprocess.g:2694:1: () ( (lv_code_1_0= ruleMyCodeLineExtended ) )
            {
            // InternalPreprocess.g:2694:1: ()
            // InternalPreprocess.g:2695:2: 
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

            // InternalPreprocess.g:2706:1: ( (lv_code_1_0= ruleMyCodeLineExtended ) )
            // InternalPreprocess.g:2707:1: (lv_code_1_0= ruleMyCodeLineExtended )
            {
            // InternalPreprocess.g:2707:1: (lv_code_1_0= ruleMyCodeLineExtended )
            // InternalPreprocess.g:2708:3: lv_code_1_0= ruleMyCodeLineExtended
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
                  		
                   
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleCode"


    // $ANTLR start "entryRuleMyCode"
    // InternalPreprocess.g:2741:1: entryRuleMyCode returns [String current=null] : iv_ruleMyCode= ruleMyCode EOF ;
    public final String entryRuleMyCode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCode = null;


        try {
            // InternalPreprocess.g:2742:2: (iv_ruleMyCode= ruleMyCode EOF )
            // InternalPreprocess.g:2743:2: iv_ruleMyCode= ruleMyCode EOF
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
    // InternalPreprocess.g:2750:1: ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_ELIF_11= RULE_ELIF | this_ELSE_12= RULE_ELSE | this_WARNING_13= RULE_WARNING | this_UNDEF_14= RULE_UNDEF | this_LINE_15= RULE_LINE | this_SpecialKeywords_16= ruleSpecialKeywords | this_Constant1_17= ruleConstant1 ) ;
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
        Token this_ELIF_11=null;
        Token this_ELSE_12=null;
        Token this_WARNING_13=null;
        Token this_UNDEF_14=null;
        Token this_LINE_15=null;
        AntlrDatatypeRuleToken this_SpecialKeywords_16 = null;

        AntlrDatatypeRuleToken this_Constant1_17 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2753:28: ( (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_ELIF_11= RULE_ELIF | this_ELSE_12= RULE_ELSE | this_WARNING_13= RULE_WARNING | this_UNDEF_14= RULE_UNDEF | this_LINE_15= RULE_LINE | this_SpecialKeywords_16= ruleSpecialKeywords | this_Constant1_17= ruleConstant1 ) )
            // InternalPreprocess.g:2754:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_ELIF_11= RULE_ELIF | this_ELSE_12= RULE_ELSE | this_WARNING_13= RULE_WARNING | this_UNDEF_14= RULE_UNDEF | this_LINE_15= RULE_LINE | this_SpecialKeywords_16= ruleSpecialKeywords | this_Constant1_17= ruleConstant1 )
            {
            // InternalPreprocess.g:2754:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_ELIF_11= RULE_ELIF | this_ELSE_12= RULE_ELSE | this_WARNING_13= RULE_WARNING | this_UNDEF_14= RULE_UNDEF | this_LINE_15= RULE_LINE | this_SpecialKeywords_16= ruleSpecialKeywords | this_Constant1_17= ruleConstant1 )
            int alt59=18;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt59=1;
                }
                break;
            case RULE_SPECIAL:
                {
                alt59=2;
                }
                break;
            case RULE_INCLUDE:
                {
                alt59=3;
                }
                break;
            case RULE_DEFINE:
                {
                alt59=4;
                }
                break;
            case RULE_ERROR:
                {
                alt59=5;
                }
                break;
            case RULE_PRAGMA:
                {
                alt59=6;
                }
                break;
            case RULE_IFDEF:
                {
                alt59=7;
                }
                break;
            case RULE_ENDIF:
                {
                alt59=8;
                }
                break;
            case RULE_IFNOTDEF:
                {
                alt59=9;
                }
                break;
            case RULE_IF:
                {
                alt59=10;
                }
                break;
            case RULE_DEFINED:
                {
                alt59=11;
                }
                break;
            case RULE_ELIF:
                {
                alt59=12;
                }
                break;
            case RULE_ELSE:
                {
                alt59=13;
                }
                break;
            case RULE_WARNING:
                {
                alt59=14;
                }
                break;
            case RULE_UNDEF:
                {
                alt59=15;
                }
                break;
            case RULE_LINE:
                {
                alt59=16;
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
                alt59=17;
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
                alt59=18;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // InternalPreprocess.g:2754:6: this_ID_0= RULE_ID
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
                    // InternalPreprocess.g:2762:10: this_SPECIAL_1= RULE_SPECIAL
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
                    // InternalPreprocess.g:2770:10: this_INCLUDE_2= RULE_INCLUDE
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
                    // InternalPreprocess.g:2778:10: this_DEFINE_3= RULE_DEFINE
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
                    // InternalPreprocess.g:2786:10: this_ERROR_4= RULE_ERROR
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
                    // InternalPreprocess.g:2794:10: this_PRAGMA_5= RULE_PRAGMA
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
                    // InternalPreprocess.g:2802:10: this_IFDEF_6= RULE_IFDEF
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
                    // InternalPreprocess.g:2810:10: this_ENDIF_7= RULE_ENDIF
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
                    // InternalPreprocess.g:2818:10: this_IFNOTDEF_8= RULE_IFNOTDEF
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
                    // InternalPreprocess.g:2826:10: this_IF_9= RULE_IF
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
                    // InternalPreprocess.g:2834:10: this_DEFINED_10= RULE_DEFINED
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
                    // InternalPreprocess.g:2842:10: this_ELIF_11= RULE_ELIF
                    {
                    this_ELIF_11=(Token)match(input,RULE_ELIF,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ELIF_11);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ELIF_11, grammarAccess.getMyCodeAccess().getELIFTerminalRuleCall_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // InternalPreprocess.g:2850:10: this_ELSE_12= RULE_ELSE
                    {
                    this_ELSE_12=(Token)match(input,RULE_ELSE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ELSE_12);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ELSE_12, grammarAccess.getMyCodeAccess().getELSETerminalRuleCall_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // InternalPreprocess.g:2858:10: this_WARNING_13= RULE_WARNING
                    {
                    this_WARNING_13=(Token)match(input,RULE_WARNING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_WARNING_13);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_WARNING_13, grammarAccess.getMyCodeAccess().getWARNINGTerminalRuleCall_13()); 
                          
                    }

                    }
                    break;
                case 15 :
                    // InternalPreprocess.g:2866:10: this_UNDEF_14= RULE_UNDEF
                    {
                    this_UNDEF_14=(Token)match(input,RULE_UNDEF,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_UNDEF_14);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_UNDEF_14, grammarAccess.getMyCodeAccess().getUNDEFTerminalRuleCall_14()); 
                          
                    }

                    }
                    break;
                case 16 :
                    // InternalPreprocess.g:2874:10: this_LINE_15= RULE_LINE
                    {
                    this_LINE_15=(Token)match(input,RULE_LINE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_LINE_15);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LINE_15, grammarAccess.getMyCodeAccess().getLINETerminalRuleCall_15()); 
                          
                    }

                    }
                    break;
                case 17 :
                    // InternalPreprocess.g:2883:5: this_SpecialKeywords_16= ruleSpecialKeywords
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeAccess().getSpecialKeywordsParserRuleCall_16()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_SpecialKeywords_16=ruleSpecialKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SpecialKeywords_16);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 18 :
                    // InternalPreprocess.g:2895:5: this_Constant1_17= ruleConstant1
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeAccess().getConstant1ParserRuleCall_17()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Constant1_17=ruleConstant1();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Constant1_17);
                          
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


    // $ANTLR start "entryRuleMyDefineLineFunction"
    // InternalPreprocess.g:2913:1: entryRuleMyDefineLineFunction returns [String current=null] : iv_ruleMyDefineLineFunction= ruleMyDefineLineFunction EOF ;
    public final String entryRuleMyDefineLineFunction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyDefineLineFunction = null;


        try {
            // InternalPreprocess.g:2914:2: (iv_ruleMyDefineLineFunction= ruleMyDefineLineFunction EOF )
            // InternalPreprocess.g:2915:2: iv_ruleMyDefineLineFunction= ruleMyDefineLineFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMyDefineLineFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMyDefineLineFunction=ruleMyDefineLineFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMyDefineLineFunction.getText(); 
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
    // $ANTLR end "entryRuleMyDefineLineFunction"


    // $ANTLR start "ruleMyDefineLineFunction"
    // InternalPreprocess.g:2922:1: ruleMyDefineLineFunction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyDefineLineObject_0= ruleMyDefineLineObject | this_HASH_1= RULE_HASH | this_VA_ARGS_2= RULE_VA_ARGS )+ ;
    public final AntlrDatatypeRuleToken ruleMyDefineLineFunction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HASH_1=null;
        Token this_VA_ARGS_2=null;
        AntlrDatatypeRuleToken this_MyDefineLineObject_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2925:28: ( (this_MyDefineLineObject_0= ruleMyDefineLineObject | this_HASH_1= RULE_HASH | this_VA_ARGS_2= RULE_VA_ARGS )+ )
            // InternalPreprocess.g:2926:1: (this_MyDefineLineObject_0= ruleMyDefineLineObject | this_HASH_1= RULE_HASH | this_VA_ARGS_2= RULE_VA_ARGS )+
            {
            // InternalPreprocess.g:2926:1: (this_MyDefineLineObject_0= ruleMyDefineLineObject | this_HASH_1= RULE_HASH | this_VA_ARGS_2= RULE_VA_ARGS )+
            int cnt60=0;
            loop60:
            do {
                int alt60=4;
                switch ( input.LA(1) ) {
                case RULE_WHITESPACE:
                case RULE_INCLUDE:
                case RULE_DEFINE:
                case RULE_SKW_LEFTPAREN:
                case RULE_SKW_RIGHTPAREN:
                case RULE_ID:
                case RULE_SKW_COMMA:
                case RULE_LINE:
                case RULE_ERROR:
                case RULE_WARNING:
                case RULE_UNDEF:
                case RULE_ENDIF:
                case RULE_IF:
                case RULE_IFDEF:
                case RULE_IFNOTDEF:
                case RULE_ELIF:
                case RULE_ELSE:
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
                case RULE_HEX_LITERAL:
                case RULE_OCTAL_LITERAL:
                case RULE_DECIMAL_LITERAL:
                case RULE_CHAR_LITERAL:
                case RULE_STRING_LITERAL:
                case RULE_FLOAT_LITERAL:
                case RULE_BIN_LITERAL:
                    {
                    alt60=1;
                    }
                    break;
                case RULE_HASH:
                    {
                    alt60=2;
                    }
                    break;
                case RULE_VA_ARGS:
                    {
                    alt60=3;
                    }
                    break;

                }

                switch (alt60) {
            	case 1 :
            	    // InternalPreprocess.g:2927:5: this_MyDefineLineObject_0= ruleMyDefineLineObject
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMyDefineLineFunctionAccess().getMyDefineLineObjectParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_14);
            	    this_MyDefineLineObject_0=ruleMyDefineLineObject();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_MyDefineLineObject_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;
            	case 2 :
            	    // InternalPreprocess.g:2938:10: this_HASH_1= RULE_HASH
            	    {
            	    this_HASH_1=(Token)match(input,RULE_HASH,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_HASH_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_HASH_1, grammarAccess.getMyDefineLineFunctionAccess().getHASHTerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;
            	case 3 :
            	    // InternalPreprocess.g:2946:10: this_VA_ARGS_2= RULE_VA_ARGS
            	    {
            	    this_VA_ARGS_2=(Token)match(input,RULE_VA_ARGS,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_VA_ARGS_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_VA_ARGS_2, grammarAccess.getMyDefineLineFunctionAccess().getVA_ARGSTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt60 >= 1 ) break loop60;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(60, input);
                        throw eee;
                }
                cnt60++;
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
    // $ANTLR end "ruleMyDefineLineFunction"


    // $ANTLR start "entryRuleMyDefineLineObject"
    // InternalPreprocess.g:2961:1: entryRuleMyDefineLineObject returns [String current=null] : iv_ruleMyDefineLineObject= ruleMyDefineLineObject EOF ;
    public final String entryRuleMyDefineLineObject() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyDefineLineObject = null;


        try {
            // InternalPreprocess.g:2962:2: (iv_ruleMyDefineLineObject= ruleMyDefineLineObject EOF )
            // InternalPreprocess.g:2963:2: iv_ruleMyDefineLineObject= ruleMyDefineLineObject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMyDefineLineObjectRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMyDefineLineObject=ruleMyDefineLineObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMyDefineLineObject.getText(); 
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
    // $ANTLR end "entryRuleMyDefineLineObject"


    // $ANTLR start "ruleMyDefineLineObject"
    // InternalPreprocess.g:2970:1: ruleMyDefineLineObject returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+ ;
    public final AntlrDatatypeRuleToken ruleMyDefineLineObject() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_1=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2973:28: ( (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+ )
            // InternalPreprocess.g:2974:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+
            {
            // InternalPreprocess.g:2974:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+
            int cnt61=0;
            loop61:
            do {
                int alt61=3;
                alt61 = dfa61.predict(input);
                switch (alt61) {
            	case 1 :
            	    // InternalPreprocess.g:2975:5: this_MyCode_0= ruleMyCode
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMyDefineLineObjectAccess().getMyCodeParserRuleCall_0()); 
            	          
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
            	    // InternalPreprocess.g:2986:10: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WHITESPACE_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getMyDefineLineObjectAccess().getWHITESPACETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt61 >= 1 ) break loop61;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(61, input);
                        throw eee;
                }
                cnt61++;
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
    // $ANTLR end "ruleMyDefineLineObject"


    // $ANTLR start "entryRuleMyCodeLine"
    // InternalPreprocess.g:3001:1: entryRuleMyCodeLine returns [String current=null] : iv_ruleMyCodeLine= ruleMyCodeLine EOF ;
    public final String entryRuleMyCodeLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLine = null;


        try {
            // InternalPreprocess.g:3002:2: (iv_ruleMyCodeLine= ruleMyCodeLine EOF )
            // InternalPreprocess.g:3003:2: iv_ruleMyCodeLine= ruleMyCodeLine EOF
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
    // InternalPreprocess.g:3010:1: ruleMyCodeLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+ ;
    public final AntlrDatatypeRuleToken ruleMyCodeLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_1=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:3013:28: ( (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+ )
            // InternalPreprocess.g:3014:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+
            {
            // InternalPreprocess.g:3014:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+
            int cnt62=0;
            loop62:
            do {
                int alt62=3;
                alt62 = dfa62.predict(input);
                switch (alt62) {
            	case 1 :
            	    // InternalPreprocess.g:3015:5: this_MyCode_0= ruleMyCode
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
            	    // InternalPreprocess.g:3026:10: this_WHITESPACE_1= RULE_WHITESPACE
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
            	    if ( cnt62 >= 1 ) break loop62;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(62, input);
                        throw eee;
                }
                cnt62++;
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
    // InternalPreprocess.g:3041:1: entryRuleMyCodeLineExtended returns [String current=null] : iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF ;
    public final String entryRuleMyCodeLineExtended() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtended = null;


        try {
            // InternalPreprocess.g:3042:2: (iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF )
            // InternalPreprocess.g:3043:2: iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF
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
    // InternalPreprocess.g:3050:1: ruleMyCodeLineExtended returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal ) ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtended() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_MyCodeLineExtendedWSOnly_0 = null;

        AntlrDatatypeRuleToken this_MyCodeLineExtendedNormal_1 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:3053:28: ( (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal ) )
            // InternalPreprocess.g:3054:1: (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal )
            {
            // InternalPreprocess.g:3054:1: (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal )
            int alt63=2;
            alt63 = dfa63.predict(input);
            switch (alt63) {
                case 1 :
                    // InternalPreprocess.g:3055:5: this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly
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
                    // InternalPreprocess.g:3067:5: this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal
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
    // InternalPreprocess.g:3085:1: entryRuleMyCodeLineExtendedWSOnly returns [String current=null] : iv_ruleMyCodeLineExtendedWSOnly= ruleMyCodeLineExtendedWSOnly EOF ;
    public final String entryRuleMyCodeLineExtendedWSOnly() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtendedWSOnly = null;


        try {
            // InternalPreprocess.g:3086:2: (iv_ruleMyCodeLineExtendedWSOnly= ruleMyCodeLineExtendedWSOnly EOF )
            // InternalPreprocess.g:3087:2: iv_ruleMyCodeLineExtendedWSOnly= ruleMyCodeLineExtendedWSOnly EOF
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
    // InternalPreprocess.g:3094:1: ruleMyCodeLineExtendedWSOnly returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_WHITESPACE_0= RULE_WHITESPACE )+ ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtendedWSOnly() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_0=null;

         enterRule(); 
            
        try {
            // InternalPreprocess.g:3097:28: ( (this_WHITESPACE_0= RULE_WHITESPACE )+ )
            // InternalPreprocess.g:3098:1: (this_WHITESPACE_0= RULE_WHITESPACE )+
            {
            // InternalPreprocess.g:3098:1: (this_WHITESPACE_0= RULE_WHITESPACE )+
            int cnt64=0;
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_WHITESPACE) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalPreprocess.g:3098:6: this_WHITESPACE_0= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_0=(Token)match(input,RULE_WHITESPACE,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WHITESPACE_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_0, grammarAccess.getMyCodeLineExtendedWSOnlyAccess().getWHITESPACETerminalRuleCall()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt64 >= 1 ) break loop64;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(64, input);
                        throw eee;
                }
                cnt64++;
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
    // InternalPreprocess.g:3113:1: entryRuleMyCodeLineExtendedNormal returns [String current=null] : iv_ruleMyCodeLineExtendedNormal= ruleMyCodeLineExtendedNormal EOF ;
    public final String entryRuleMyCodeLineExtendedNormal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtendedNormal = null;


        try {
            // InternalPreprocess.g:3114:2: (iv_ruleMyCodeLineExtendedNormal= ruleMyCodeLineExtendedNormal EOF )
            // InternalPreprocess.g:3115:2: iv_ruleMyCodeLineExtendedNormal= ruleMyCodeLineExtendedNormal EOF
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
    // InternalPreprocess.g:3122:1: ruleMyCodeLineExtendedNormal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* ) ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtendedNormal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_0=null;
        Token this_HASH_3=null;
        AntlrDatatypeRuleToken this_MyCode_1 = null;

        AntlrDatatypeRuleToken this_MyCodeLine_2 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:3125:28: ( ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* ) )
            // InternalPreprocess.g:3126:1: ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )
            {
            // InternalPreprocess.g:3126:1: ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )
            // InternalPreprocess.g:3126:2: (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
            {
            // InternalPreprocess.g:3126:2: (this_WHITESPACE_0= RULE_WHITESPACE )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==RULE_WHITESPACE) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalPreprocess.g:3126:7: this_WHITESPACE_0= RULE_WHITESPACE
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
            	    break loop65;
                }
            } while (true);

            // InternalPreprocess.g:3133:3: (this_MyCode_1= ruleMyCode )+
            int cnt66=0;
            loop66:
            do {
                int alt66=2;
                alt66 = dfa66.predict(input);
                switch (alt66) {
            	case 1 :
            	    // InternalPreprocess.g:3134:5: this_MyCode_1= ruleMyCode
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
            	    if ( cnt66 >= 1 ) break loop66;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(66, input);
                        throw eee;
                }
                cnt66++;
            } while (true);

            // InternalPreprocess.g:3144:3: (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
            loop67:
            do {
                int alt67=3;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==RULE_WHITESPACE||LA67_0==RULE_INCLUDE||(LA67_0>=RULE_DEFINE && LA67_0<=RULE_DEFINED)||(LA67_0>=RULE_SKW_QUESTION && LA67_0<=RULE_BIN_LITERAL)) ) {
                    alt67=1;
                }
                else if ( (LA67_0==RULE_HASH) ) {
                    alt67=2;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalPreprocess.g:3145:5: this_MyCodeLine_2= ruleMyCodeLine
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
            	    // InternalPreprocess.g:3156:10: this_HASH_3= RULE_HASH
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
            	    break loop67;
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
    // InternalPreprocess.g:3171:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalPreprocess.g:3172:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalPreprocess.g:3173:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalPreprocess.g:3180:1: rulePrimaryExpression returns [EObject current=null] : ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | ( ( (lv_parentheses_8_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_defined_1_0=null;
        Token lv_id_2_0=null;
        Token lv_defined_3_0=null;
        Token this_SKW_LEFTPAREN_4=null;
        Token lv_id_5_0=null;
        Token this_SKW_RIGHTPAREN_6=null;
        Token lv_parentheses_8_0=null;
        Token this_SKW_RIGHTPAREN_10=null;
        AntlrDatatypeRuleToken lv_const_7_0 = null;

        EObject lv_expr_9_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3186:7: ( ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | ( ( (lv_parentheses_8_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) ) )
            // InternalPreprocess.g:3188:1: ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | ( ( (lv_parentheses_8_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) )
            {
            // InternalPreprocess.g:3188:1: ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | ( ( (lv_parentheses_8_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) )
            // InternalPreprocess.g:3189:1: () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | ( ( (lv_parentheses_8_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) )
            {
            // InternalPreprocess.g:3189:1: ()
            // InternalPreprocess.g:3190:2: 
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

            // InternalPreprocess.g:3201:1: ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | ( ( (lv_parentheses_8_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) )
            int alt70=4;
            switch ( input.LA(1) ) {
            case RULE_DEFINED:
                {
                int LA70_1 = input.LA(2);

                if ( (LA70_1==RULE_SKW_LEFTPAREN) ) {
                    alt70=2;
                }
                else if ( (LA70_1==RULE_ID) ) {
                    alt70=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                alt70=1;
                }
                break;
            case RULE_SKW_LEFTPAREN:
                {
                int LA70_3 = input.LA(2);

                if ( (LA70_3==RULE_SKW_LEFTPAREN||LA70_3==RULE_DEFINED||LA70_3==RULE_SKW_AND||(LA70_3>=RULE_SKW_PLUS && LA70_3<=RULE_SKW_STAR)||(LA70_3>=RULE_SKW_TILDE && LA70_3<=RULE_SKW_NOT)||(LA70_3>=RULE_HEX_LITERAL && LA70_3<=RULE_BIN_LITERAL)) ) {
                    alt70=4;
                }
                else if ( (LA70_3==RULE_ID) ) {
                    int LA70_7 = input.LA(3);

                    if ( (LA70_7==RULE_SKW_RIGHTPAREN) ) {
                        int LA70_8 = input.LA(4);

                        if ( (synpred101_InternalPreprocess()) ) {
                            alt70=2;
                        }
                        else if ( (true) ) {
                            alt70=4;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 70, 8, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA70_7==RULE_SKW_LEFTPAREN||LA70_7==RULE_SKW_QUESTION||(LA70_7>=RULE_SKW_OROR && LA70_7<=RULE_SKW_MOD)) ) {
                        alt70=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 7, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 3, input);

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
                alt70=3;
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
                    // InternalPreprocess.g:3202:1: ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) )
                    {
                    // InternalPreprocess.g:3202:1: ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) )
                    // InternalPreprocess.g:3203:1: ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) )
                    {
                    // InternalPreprocess.g:3203:1: ( (lv_defined_1_0= RULE_DEFINED ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==RULE_DEFINED) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // InternalPreprocess.g:3204:1: (lv_defined_1_0= RULE_DEFINED )
                            {
                            // InternalPreprocess.g:3204:1: (lv_defined_1_0= RULE_DEFINED )
                            // InternalPreprocess.g:3205:3: lv_defined_1_0= RULE_DEFINED
                            {
                            lv_defined_1_0=(Token)match(input,RULE_DEFINED,FOLLOW_25); if (state.failed) return current;
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

                    // InternalPreprocess.g:3224:1: ( (lv_id_2_0= RULE_ID ) )
                    // InternalPreprocess.g:3225:1: (lv_id_2_0= RULE_ID )
                    {
                    // InternalPreprocess.g:3225:1: (lv_id_2_0= RULE_ID )
                    // InternalPreprocess.g:3226:3: lv_id_2_0= RULE_ID
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
                    // InternalPreprocess.g:3248:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
                    {
                    // InternalPreprocess.g:3248:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
                    // InternalPreprocess.g:3249:1: ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN
                    {
                    // InternalPreprocess.g:3249:1: ( (lv_defined_3_0= RULE_DEFINED ) )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==RULE_DEFINED) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // InternalPreprocess.g:3250:1: (lv_defined_3_0= RULE_DEFINED )
                            {
                            // InternalPreprocess.g:3250:1: (lv_defined_3_0= RULE_DEFINED )
                            // InternalPreprocess.g:3251:3: lv_defined_3_0= RULE_DEFINED
                            {
                            lv_defined_3_0=(Token)match(input,RULE_DEFINED,FOLLOW_11); if (state.failed) return current;
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

                    this_SKW_LEFTPAREN_4=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LEFTPAREN_4, grammarAccess.getPrimaryExpressionAccess().getSKW_LEFTPARENTerminalRuleCall_1_1_1()); 
                          
                    }
                    // InternalPreprocess.g:3277:1: ( (lv_id_5_0= RULE_ID ) )
                    // InternalPreprocess.g:3278:1: (lv_id_5_0= RULE_ID )
                    {
                    // InternalPreprocess.g:3278:1: (lv_id_5_0= RULE_ID )
                    // InternalPreprocess.g:3279:3: lv_id_5_0= RULE_ID
                    {
                    lv_id_5_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
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
                    // InternalPreprocess.g:3308:1: ( (lv_const_7_0= ruleConstant1 ) )
                    {
                    // InternalPreprocess.g:3308:1: ( (lv_const_7_0= ruleConstant1 ) )
                    // InternalPreprocess.g:3309:1: (lv_const_7_0= ruleConstant1 )
                    {
                    // InternalPreprocess.g:3309:1: (lv_const_7_0= ruleConstant1 )
                    // InternalPreprocess.g:3310:3: lv_const_7_0= ruleConstant1
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
                    // InternalPreprocess.g:3330:1: ( ( (lv_parentheses_8_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN )
                    {
                    // InternalPreprocess.g:3330:1: ( ( (lv_parentheses_8_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN )
                    // InternalPreprocess.g:3331:1: ( (lv_parentheses_8_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN
                    {
                    // InternalPreprocess.g:3331:1: ( (lv_parentheses_8_0= RULE_SKW_LEFTPAREN ) )
                    // InternalPreprocess.g:3332:1: (lv_parentheses_8_0= RULE_SKW_LEFTPAREN )
                    {
                    // InternalPreprocess.g:3332:1: (lv_parentheses_8_0= RULE_SKW_LEFTPAREN )
                    // InternalPreprocess.g:3333:3: lv_parentheses_8_0= RULE_SKW_LEFTPAREN
                    {
                    lv_parentheses_8_0=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_parentheses_8_0, grammarAccess.getPrimaryExpressionAccess().getParenthesesSKW_LEFTPARENTerminalRuleCall_1_3_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"parentheses",
                              		true, 
                              		"at.jku.weiner.c.common.Common.SKW_LEFTPAREN");
                      	    
                    }

                    }


                    }

                    // InternalPreprocess.g:3352:1: ( (lv_expr_9_0= ruleExpression ) )
                    // InternalPreprocess.g:3353:1: (lv_expr_9_0= ruleExpression )
                    {
                    // InternalPreprocess.g:3353:1: (lv_expr_9_0= ruleExpression )
                    // InternalPreprocess.g:3354:3: lv_expr_9_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExprExpressionParserRuleCall_1_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_13);
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
                  		
                   
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleExpression"
    // InternalPreprocess.g:3398:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
        	
        try {
            // InternalPreprocess.g:3402:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalPreprocess.g:3403:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalPreprocess.g:3413:1: ruleExpression returns [EObject current=null] : this_ConditionalExpression_0= ruleConditionalExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;


         enterRule();
           		/*no init found*/
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
            
        try {
            // InternalPreprocess.g:3420:7: (this_ConditionalExpression_0= ruleConditionalExpression )
            // InternalPreprocess.g:3423:2: this_ConditionalExpression_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExpressionAccess().getConditionalExpressionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_2);
            this_ConditionalExpression_0=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ConditionalExpression_0; 
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

            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleConditionalExpression"
    // InternalPreprocess.g:3452:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalPreprocess.g:3453:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalPreprocess.g:3454:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
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
    // InternalPreprocess.g:3461:1: ruleConditionalExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_QUESTION_2=null;
        Token this_SKW_COLON_4=null;
        EObject this_LogicalOrExpression_0 = null;

        EObject lv_qExpr_3_0 = null;

        EObject lv_cExpr_5_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3467:7: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) )
            // InternalPreprocess.g:3469:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
            {
            // InternalPreprocess.g:3469:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
            // InternalPreprocess.g:3471:2: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getConditionalExpressionAccess().getLogicalOrExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_26);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalOrExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalPreprocess.g:3485:1: ( () this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_SKW_QUESTION) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalPreprocess.g:3486:1: () this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) )
                    {
                    // InternalPreprocess.g:3486:1: ()
                    // InternalPreprocess.g:3487:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getConditionalExpressionAccess().getConditionalExpressionExprAction_1_0(),
                                  current);
                          
                    }

                    }

                    this_SKW_QUESTION_2=(Token)match(input,RULE_SKW_QUESTION,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_QUESTION_2, grammarAccess.getConditionalExpressionAccess().getSKW_QUESTIONTerminalRuleCall_1_1()); 
                          
                    }
                    // InternalPreprocess.g:3505:1: ( (lv_qExpr_3_0= ruleExpression ) )
                    // InternalPreprocess.g:3506:1: (lv_qExpr_3_0= ruleExpression )
                    {
                    // InternalPreprocess.g:3506:1: (lv_qExpr_3_0= ruleExpression )
                    // InternalPreprocess.g:3507:3: lv_qExpr_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getQExprExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_27);
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
                       
                          newLeafNode(this_SKW_COLON_4, grammarAccess.getConditionalExpressionAccess().getSKW_COLONTerminalRuleCall_1_3()); 
                          
                    }
                    // InternalPreprocess.g:3533:1: ( (lv_cExpr_5_0= ruleConditionalExpression ) )
                    // InternalPreprocess.g:3534:1: (lv_cExpr_5_0= ruleConditionalExpression )
                    {
                    // InternalPreprocess.g:3534:1: (lv_cExpr_5_0= ruleConditionalExpression )
                    // InternalPreprocess.g:3535:3: lv_cExpr_5_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getCExprConditionalExpressionParserRuleCall_1_4_0()); 
                      	    
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
                  		
                   
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleConditionalExpression"


    // $ANTLR start "entryRuleLogicalOrExpression"
    // InternalPreprocess.g:3570:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalPreprocess.g:3571:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalPreprocess.g:3572:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
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
    // InternalPreprocess.g:3579:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_SKW_OROR_2= RULE_SKW_OROR ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_OROR_2=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3585:7: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_SKW_OROR_2= RULE_SKW_OROR ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalPreprocess.g:3587:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_SKW_OROR_2= RULE_SKW_OROR ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalPreprocess.g:3587:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_SKW_OROR_2= RULE_SKW_OROR ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalPreprocess.g:3589:2: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_SKW_OROR_2= RULE_SKW_OROR ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_28);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalPreprocess.g:3603:1: ( () this_SKW_OROR_2= RULE_SKW_OROR ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==RULE_SKW_OROR) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalPreprocess.g:3604:1: () this_SKW_OROR_2= RULE_SKW_OROR ( (lv_right_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // InternalPreprocess.g:3604:1: ()
            	    // InternalPreprocess.g:3605:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    this_SKW_OROR_2=(Token)match(input,RULE_SKW_OROR,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_OROR_2, grammarAccess.getLogicalOrExpressionAccess().getSKW_ORORTerminalRuleCall_1_1()); 
            	          
            	    }
            	    // InternalPreprocess.g:3623:1: ( (lv_right_3_0= ruleLogicalAndExpression ) )
            	    // InternalPreprocess.g:3624:1: (lv_right_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalPreprocess.g:3624:1: (lv_right_3_0= ruleLogicalAndExpression )
            	    // InternalPreprocess.g:3625:3: lv_right_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightLogicalAndExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_right_3_0=ruleLogicalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"at.jku.weiner.c.common.Common.LogicalAndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop72;
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleLogicalOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // InternalPreprocess.g:3660:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalPreprocess.g:3661:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalPreprocess.g:3662:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
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
    // InternalPreprocess.g:3669:1: ruleLogicalAndExpression returns [EObject current=null] : (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_ANDAND_2=null;
        EObject this_InclusiveOrExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3675:7: ( (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )* ) )
            // InternalPreprocess.g:3677:1: (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )* )
            {
            // InternalPreprocess.g:3677:1: (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )* )
            // InternalPreprocess.g:3679:2: this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getInclusiveOrExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_29);
            this_InclusiveOrExpression_0=ruleInclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_InclusiveOrExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalPreprocess.g:3693:1: ( () this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==RULE_SKW_ANDAND) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalPreprocess.g:3694:1: () this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_right_3_0= ruleInclusiveOrExpression ) )
            	    {
            	    // InternalPreprocess.g:3694:1: ()
            	    // InternalPreprocess.g:3695:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    this_SKW_ANDAND_2=(Token)match(input,RULE_SKW_ANDAND,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_ANDAND_2, grammarAccess.getLogicalAndExpressionAccess().getSKW_ANDANDTerminalRuleCall_1_1()); 
            	          
            	    }
            	    // InternalPreprocess.g:3713:1: ( (lv_right_3_0= ruleInclusiveOrExpression ) )
            	    // InternalPreprocess.g:3714:1: (lv_right_3_0= ruleInclusiveOrExpression )
            	    {
            	    // InternalPreprocess.g:3714:1: (lv_right_3_0= ruleInclusiveOrExpression )
            	    // InternalPreprocess.g:3715:3: lv_right_3_0= ruleInclusiveOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightInclusiveOrExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_right_3_0=ruleInclusiveOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"at.jku.weiner.c.common.Common.InclusiveOrExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop73;
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleInclusiveOrExpression"
    // InternalPreprocess.g:3750:1: entryRuleInclusiveOrExpression returns [EObject current=null] : iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF ;
    public final EObject entryRuleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclusiveOrExpression = null;


        try {
            // InternalPreprocess.g:3751:2: (iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF )
            // InternalPreprocess.g:3752:2: iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF
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
    // InternalPreprocess.g:3759:1: ruleInclusiveOrExpression returns [EObject current=null] : (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () this_SKW_OR_2= RULE_SKW_OR ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )* ) ;
    public final EObject ruleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_OR_2=null;
        EObject this_ExclusiveOrExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3765:7: ( (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () this_SKW_OR_2= RULE_SKW_OR ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )* ) )
            // InternalPreprocess.g:3767:1: (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () this_SKW_OR_2= RULE_SKW_OR ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )* )
            {
            // InternalPreprocess.g:3767:1: (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () this_SKW_OR_2= RULE_SKW_OR ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )* )
            // InternalPreprocess.g:3769:2: this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () this_SKW_OR_2= RULE_SKW_OR ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExclusiveOrExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_30);
            this_ExclusiveOrExpression_0=ruleExclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ExclusiveOrExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalPreprocess.g:3783:1: ( () this_SKW_OR_2= RULE_SKW_OR ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==RULE_SKW_OR) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalPreprocess.g:3784:1: () this_SKW_OR_2= RULE_SKW_OR ( (lv_right_3_0= ruleExclusiveOrExpression ) )
            	    {
            	    // InternalPreprocess.g:3784:1: ()
            	    // InternalPreprocess.g:3785:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getInclusiveOrExpressionAccess().getInclusiveOrExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    this_SKW_OR_2=(Token)match(input,RULE_SKW_OR,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_OR_2, grammarAccess.getInclusiveOrExpressionAccess().getSKW_ORTerminalRuleCall_1_1()); 
            	          
            	    }
            	    // InternalPreprocess.g:3803:1: ( (lv_right_3_0= ruleExclusiveOrExpression ) )
            	    // InternalPreprocess.g:3804:1: (lv_right_3_0= ruleExclusiveOrExpression )
            	    {
            	    // InternalPreprocess.g:3804:1: (lv_right_3_0= ruleExclusiveOrExpression )
            	    // InternalPreprocess.g:3805:3: lv_right_3_0= ruleExclusiveOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getRightExclusiveOrExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_right_3_0=ruleExclusiveOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getInclusiveOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"at.jku.weiner.c.common.Common.ExclusiveOrExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleInclusiveOrExpression"


    // $ANTLR start "entryRuleExclusiveOrExpression"
    // InternalPreprocess.g:3840:1: entryRuleExclusiveOrExpression returns [EObject current=null] : iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF ;
    public final EObject entryRuleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusiveOrExpression = null;


        try {
            // InternalPreprocess.g:3841:2: (iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF )
            // InternalPreprocess.g:3842:2: iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF
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
    // InternalPreprocess.g:3849:1: ruleExclusiveOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () this_SKW_CARET_2= RULE_SKW_CARET ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_CARET_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3855:7: ( (this_AndExpression_0= ruleAndExpression ( () this_SKW_CARET_2= RULE_SKW_CARET ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalPreprocess.g:3857:1: (this_AndExpression_0= ruleAndExpression ( () this_SKW_CARET_2= RULE_SKW_CARET ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalPreprocess.g:3857:1: (this_AndExpression_0= ruleAndExpression ( () this_SKW_CARET_2= RULE_SKW_CARET ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalPreprocess.g:3859:2: this_AndExpression_0= ruleAndExpression ( () this_SKW_CARET_2= RULE_SKW_CARET ( (lv_right_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_31);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalPreprocess.g:3873:1: ( () this_SKW_CARET_2= RULE_SKW_CARET ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==RULE_SKW_CARET) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalPreprocess.g:3874:1: () this_SKW_CARET_2= RULE_SKW_CARET ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalPreprocess.g:3874:1: ()
            	    // InternalPreprocess.g:3875:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getExclusiveOrExpressionAccess().getExclusiveOrExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    this_SKW_CARET_2=(Token)match(input,RULE_SKW_CARET,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_CARET_2, grammarAccess.getExclusiveOrExpressionAccess().getSKW_CARETTerminalRuleCall_1_1()); 
            	          
            	    }
            	    // InternalPreprocess.g:3893:1: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalPreprocess.g:3894:1: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalPreprocess.g:3894:1: (lv_right_3_0= ruleAndExpression )
            	    // InternalPreprocess.g:3895:3: lv_right_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_31);
            	    lv_right_3_0=ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getExclusiveOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"at.jku.weiner.c.common.Common.AndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop75;
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleExclusiveOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalPreprocess.g:3930:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalPreprocess.g:3931:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalPreprocess.g:3932:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalPreprocess.g:3939:1: ruleAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () this_SKW_AND_2= RULE_SKW_AND ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_AND_2=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3945:7: ( (this_EqualityExpression_0= ruleEqualityExpression ( () this_SKW_AND_2= RULE_SKW_AND ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalPreprocess.g:3947:1: (this_EqualityExpression_0= ruleEqualityExpression ( () this_SKW_AND_2= RULE_SKW_AND ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalPreprocess.g:3947:1: (this_EqualityExpression_0= ruleEqualityExpression ( () this_SKW_AND_2= RULE_SKW_AND ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // InternalPreprocess.g:3949:2: this_EqualityExpression_0= ruleEqualityExpression ( () this_SKW_AND_2= RULE_SKW_AND ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_32);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_EqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalPreprocess.g:3963:1: ( () this_SKW_AND_2= RULE_SKW_AND ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==RULE_SKW_AND) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalPreprocess.g:3964:1: () this_SKW_AND_2= RULE_SKW_AND ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // InternalPreprocess.g:3964:1: ()
            	    // InternalPreprocess.g:3965:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    this_SKW_AND_2=(Token)match(input,RULE_SKW_AND,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_AND_2, grammarAccess.getAndExpressionAccess().getSKW_ANDTerminalRuleCall_1_1()); 
            	          
            	    }
            	    // InternalPreprocess.g:3983:1: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // InternalPreprocess.g:3984:1: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // InternalPreprocess.g:3984:1: (lv_right_3_0= ruleEqualityExpression )
            	    // InternalPreprocess.g:3985:3: lv_right_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExpressionAccess().getRightEqualityExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_right_3_0=ruleEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"at.jku.weiner.c.common.Common.EqualityExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop76;
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalPreprocess.g:4020:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalPreprocess.g:4021:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalPreprocess.g:4022:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalPreprocess.g:4029:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_right_4_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject this_RelationalExpression_0 = null;

        EObject lv_right_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4035:7: ( (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_right_4_0= ruleRelationalExpression ) ) )* ) )
            // InternalPreprocess.g:4037:1: (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_right_4_0= ruleRelationalExpression ) ) )* )
            {
            // InternalPreprocess.g:4037:1: (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_right_4_0= ruleRelationalExpression ) ) )* )
            // InternalPreprocess.g:4039:2: this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_right_4_0= ruleRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_33);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_RelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalPreprocess.g:4053:1: ( () ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_right_4_0= ruleRelationalExpression ) ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( ((LA78_0>=RULE_SKW_EQUAL && LA78_0<=RULE_SKW_NOTEQUAL)) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalPreprocess.g:4054:1: () ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_right_4_0= ruleRelationalExpression ) )
            	    {
            	    // InternalPreprocess.g:4054:1: ()
            	    // InternalPreprocess.g:4055:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getEqualityExpressionAccess().getEqualityExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalPreprocess.g:4066:1: ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) )
            	    int alt77=2;
            	    int LA77_0 = input.LA(1);

            	    if ( (LA77_0==RULE_SKW_EQUAL) ) {
            	        alt77=1;
            	    }
            	    else if ( (LA77_0==RULE_SKW_NOTEQUAL) ) {
            	        alt77=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 77, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt77) {
            	        case 1 :
            	            // InternalPreprocess.g:4067:1: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
            	            {
            	            // InternalPreprocess.g:4067:1: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
            	            // InternalPreprocess.g:4068:1: (lv_op_2_0= RULE_SKW_EQUAL )
            	            {
            	            // InternalPreprocess.g:4068:1: (lv_op_2_0= RULE_SKW_EQUAL )
            	            // InternalPreprocess.g:4069:3: lv_op_2_0= RULE_SKW_EQUAL
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_EQUAL,FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_2_0, grammarAccess.getEqualityExpressionAccess().getOpSKW_EQUALTerminalRuleCall_1_1_0_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getEqualityExpressionRule());
            	              	        }
            	                     		setWithLastConsumed(
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
            	            // InternalPreprocess.g:4089:1: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
            	            {
            	            // InternalPreprocess.g:4089:1: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
            	            // InternalPreprocess.g:4090:1: (lv_op_3_0= RULE_SKW_NOTEQUAL )
            	            {
            	            // InternalPreprocess.g:4090:1: (lv_op_3_0= RULE_SKW_NOTEQUAL )
            	            // InternalPreprocess.g:4091:3: lv_op_3_0= RULE_SKW_NOTEQUAL
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_NOTEQUAL,FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_3_0, grammarAccess.getEqualityExpressionAccess().getOpSKW_NOTEQUALTerminalRuleCall_1_1_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getEqualityExpressionRule());
            	              	        }
            	                     		setWithLastConsumed(
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

            	    // InternalPreprocess.g:4112:1: ( (lv_right_4_0= ruleRelationalExpression ) )
            	    // InternalPreprocess.g:4113:1: (lv_right_4_0= ruleRelationalExpression )
            	    {
            	    // InternalPreprocess.g:4113:1: (lv_right_4_0= ruleRelationalExpression )
            	    // InternalPreprocess.g:4114:3: lv_right_4_0= ruleRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightRelationalExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_33);
            	    lv_right_4_0=ruleRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_4_0, 
            	              		"at.jku.weiner.c.common.Common.RelationalExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop78;
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalPreprocess.g:4149:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalPreprocess.g:4150:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalPreprocess.g:4151:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalPreprocess.g:4158:1: ruleRelationalExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_right_6_0= ruleShiftExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        Token lv_op_4_0=null;
        Token lv_op_5_0=null;
        EObject this_ShiftExpression_0 = null;

        EObject lv_right_6_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4164:7: ( (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_right_6_0= ruleShiftExpression ) ) )* ) )
            // InternalPreprocess.g:4166:1: (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_right_6_0= ruleShiftExpression ) ) )* )
            {
            // InternalPreprocess.g:4166:1: (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_right_6_0= ruleShiftExpression ) ) )* )
            // InternalPreprocess.g:4168:2: this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_right_6_0= ruleShiftExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_34);
            this_ShiftExpression_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ShiftExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalPreprocess.g:4182:1: ( () ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_right_6_0= ruleShiftExpression ) ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( ((LA80_0>=RULE_SKW_LESS && LA80_0<=RULE_SKW_GREATEREQUAL)) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalPreprocess.g:4183:1: () ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_right_6_0= ruleShiftExpression ) )
            	    {
            	    // InternalPreprocess.g:4183:1: ()
            	    // InternalPreprocess.g:4184:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalPreprocess.g:4195:1: ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) )
            	    int alt79=4;
            	    switch ( input.LA(1) ) {
            	    case RULE_SKW_LESS:
            	        {
            	        alt79=1;
            	        }
            	        break;
            	    case RULE_SKW_GREATER:
            	        {
            	        alt79=2;
            	        }
            	        break;
            	    case RULE_SKW_LESSEQUAL:
            	        {
            	        alt79=3;
            	        }
            	        break;
            	    case RULE_SKW_GREATEREQUAL:
            	        {
            	        alt79=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 79, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt79) {
            	        case 1 :
            	            // InternalPreprocess.g:4196:1: ( (lv_op_2_0= RULE_SKW_LESS ) )
            	            {
            	            // InternalPreprocess.g:4196:1: ( (lv_op_2_0= RULE_SKW_LESS ) )
            	            // InternalPreprocess.g:4197:1: (lv_op_2_0= RULE_SKW_LESS )
            	            {
            	            // InternalPreprocess.g:4197:1: (lv_op_2_0= RULE_SKW_LESS )
            	            // InternalPreprocess.g:4198:3: lv_op_2_0= RULE_SKW_LESS
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_LESS,FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_2_0, grammarAccess.getRelationalExpressionAccess().getOpSKW_LESSTerminalRuleCall_1_1_0_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	              	        }
            	                     		setWithLastConsumed(
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
            	            // InternalPreprocess.g:4218:1: ( (lv_op_3_0= RULE_SKW_GREATER ) )
            	            {
            	            // InternalPreprocess.g:4218:1: ( (lv_op_3_0= RULE_SKW_GREATER ) )
            	            // InternalPreprocess.g:4219:1: (lv_op_3_0= RULE_SKW_GREATER )
            	            {
            	            // InternalPreprocess.g:4219:1: (lv_op_3_0= RULE_SKW_GREATER )
            	            // InternalPreprocess.g:4220:3: lv_op_3_0= RULE_SKW_GREATER
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_GREATER,FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_3_0, grammarAccess.getRelationalExpressionAccess().getOpSKW_GREATERTerminalRuleCall_1_1_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	              	        }
            	                     		setWithLastConsumed(
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
            	            // InternalPreprocess.g:4240:1: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
            	            {
            	            // InternalPreprocess.g:4240:1: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
            	            // InternalPreprocess.g:4241:1: (lv_op_4_0= RULE_SKW_LESSEQUAL )
            	            {
            	            // InternalPreprocess.g:4241:1: (lv_op_4_0= RULE_SKW_LESSEQUAL )
            	            // InternalPreprocess.g:4242:3: lv_op_4_0= RULE_SKW_LESSEQUAL
            	            {
            	            lv_op_4_0=(Token)match(input,RULE_SKW_LESSEQUAL,FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_4_0, grammarAccess.getRelationalExpressionAccess().getOpSKW_LESSEQUALTerminalRuleCall_1_1_2_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	              	        }
            	                     		setWithLastConsumed(
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
            	            // InternalPreprocess.g:4262:1: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
            	            {
            	            // InternalPreprocess.g:4262:1: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
            	            // InternalPreprocess.g:4263:1: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
            	            {
            	            // InternalPreprocess.g:4263:1: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
            	            // InternalPreprocess.g:4264:3: lv_op_5_0= RULE_SKW_GREATEREQUAL
            	            {
            	            lv_op_5_0=(Token)match(input,RULE_SKW_GREATEREQUAL,FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_5_0, grammarAccess.getRelationalExpressionAccess().getOpSKW_GREATEREQUALTerminalRuleCall_1_1_3_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	              	        }
            	                     		setWithLastConsumed(
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

            	    // InternalPreprocess.g:4285:1: ( (lv_right_6_0= ruleShiftExpression ) )
            	    // InternalPreprocess.g:4286:1: (lv_right_6_0= ruleShiftExpression )
            	    {
            	    // InternalPreprocess.g:4286:1: (lv_right_6_0= ruleShiftExpression )
            	    // InternalPreprocess.g:4287:3: lv_right_6_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightShiftExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_right_6_0=ruleShiftExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_6_0, 
            	              		"at.jku.weiner.c.common.Common.ShiftExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop80;
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleShiftExpression"
    // InternalPreprocess.g:4322:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalPreprocess.g:4323:2: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalPreprocess.g:4324:2: iv_ruleShiftExpression= ruleShiftExpression EOF
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
    // InternalPreprocess.g:4331:1: ruleShiftExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_right_4_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject this_AdditiveExpression_0 = null;

        EObject lv_right_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4337:7: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_right_4_0= ruleAdditiveExpression ) ) )* ) )
            // InternalPreprocess.g:4339:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_right_4_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalPreprocess.g:4339:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_right_4_0= ruleAdditiveExpression ) ) )* )
            // InternalPreprocess.g:4341:2: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_right_4_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getShiftExpressionAccess().getAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_35);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalPreprocess.g:4355:1: ( () ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_right_4_0= ruleAdditiveExpression ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( ((LA82_0>=RULE_SKW_LEFTSHIFT && LA82_0<=RULE_SKW_RIGHTSHIFT)) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalPreprocess.g:4356:1: () ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_right_4_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalPreprocess.g:4356:1: ()
            	    // InternalPreprocess.g:4357:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalPreprocess.g:4368:1: ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) )
            	    int alt81=2;
            	    int LA81_0 = input.LA(1);

            	    if ( (LA81_0==RULE_SKW_LEFTSHIFT) ) {
            	        alt81=1;
            	    }
            	    else if ( (LA81_0==RULE_SKW_RIGHTSHIFT) ) {
            	        alt81=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 81, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt81) {
            	        case 1 :
            	            // InternalPreprocess.g:4369:1: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
            	            {
            	            // InternalPreprocess.g:4369:1: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
            	            // InternalPreprocess.g:4370:1: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
            	            {
            	            // InternalPreprocess.g:4370:1: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
            	            // InternalPreprocess.g:4371:3: lv_op_2_0= RULE_SKW_LEFTSHIFT
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_LEFTSHIFT,FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_2_0, grammarAccess.getShiftExpressionAccess().getOpSKW_LEFTSHIFTTerminalRuleCall_1_1_0_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getShiftExpressionRule());
            	              	        }
            	                     		setWithLastConsumed(
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
            	            // InternalPreprocess.g:4391:1: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
            	            {
            	            // InternalPreprocess.g:4391:1: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
            	            // InternalPreprocess.g:4392:1: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
            	            {
            	            // InternalPreprocess.g:4392:1: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
            	            // InternalPreprocess.g:4393:3: lv_op_3_0= RULE_SKW_RIGHTSHIFT
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_RIGHTSHIFT,FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_3_0, grammarAccess.getShiftExpressionAccess().getOpSKW_RIGHTSHIFTTerminalRuleCall_1_1_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getShiftExpressionRule());
            	              	        }
            	                     		setWithLastConsumed(
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

            	    // InternalPreprocess.g:4414:1: ( (lv_right_4_0= ruleAdditiveExpression ) )
            	    // InternalPreprocess.g:4415:1: (lv_right_4_0= ruleAdditiveExpression )
            	    {
            	    // InternalPreprocess.g:4415:1: (lv_right_4_0= ruleAdditiveExpression )
            	    // InternalPreprocess.g:4416:3: lv_right_4_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_right_4_0=ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_4_0, 
            	              		"at.jku.weiner.c.common.Common.AdditiveExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop82;
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalPreprocess.g:4451:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalPreprocess.g:4452:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalPreprocess.g:4453:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalPreprocess.g:4460:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_right_4_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_right_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4466:7: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_right_4_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalPreprocess.g:4468:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_right_4_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalPreprocess.g:4468:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_right_4_0= ruleMultiplicativeExpression ) ) )* )
            // InternalPreprocess.g:4470:2: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_right_4_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_36);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalPreprocess.g:4484:1: ( () ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_right_4_0= ruleMultiplicativeExpression ) ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( ((LA84_0>=RULE_SKW_PLUS && LA84_0<=RULE_SKW_MINUS)) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalPreprocess.g:4485:1: () ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_right_4_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalPreprocess.g:4485:1: ()
            	    // InternalPreprocess.g:4486:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalPreprocess.g:4497:1: ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) )
            	    int alt83=2;
            	    int LA83_0 = input.LA(1);

            	    if ( (LA83_0==RULE_SKW_PLUS) ) {
            	        alt83=1;
            	    }
            	    else if ( (LA83_0==RULE_SKW_MINUS) ) {
            	        alt83=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 83, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt83) {
            	        case 1 :
            	            // InternalPreprocess.g:4498:1: ( (lv_op_2_0= RULE_SKW_PLUS ) )
            	            {
            	            // InternalPreprocess.g:4498:1: ( (lv_op_2_0= RULE_SKW_PLUS ) )
            	            // InternalPreprocess.g:4499:1: (lv_op_2_0= RULE_SKW_PLUS )
            	            {
            	            // InternalPreprocess.g:4499:1: (lv_op_2_0= RULE_SKW_PLUS )
            	            // InternalPreprocess.g:4500:3: lv_op_2_0= RULE_SKW_PLUS
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_PLUS,FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_2_0, grammarAccess.getAdditiveExpressionAccess().getOpSKW_PLUSTerminalRuleCall_1_1_0_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	              	        }
            	                     		setWithLastConsumed(
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
            	            // InternalPreprocess.g:4520:1: ( (lv_op_3_0= RULE_SKW_MINUS ) )
            	            {
            	            // InternalPreprocess.g:4520:1: ( (lv_op_3_0= RULE_SKW_MINUS ) )
            	            // InternalPreprocess.g:4521:1: (lv_op_3_0= RULE_SKW_MINUS )
            	            {
            	            // InternalPreprocess.g:4521:1: (lv_op_3_0= RULE_SKW_MINUS )
            	            // InternalPreprocess.g:4522:3: lv_op_3_0= RULE_SKW_MINUS
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_3_0, grammarAccess.getAdditiveExpressionAccess().getOpSKW_MINUSTerminalRuleCall_1_1_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	              	        }
            	                     		setWithLastConsumed(
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

            	    // InternalPreprocess.g:4543:1: ( (lv_right_4_0= ruleMultiplicativeExpression ) )
            	    // InternalPreprocess.g:4544:1: (lv_right_4_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalPreprocess.g:4544:1: (lv_right_4_0= ruleMultiplicativeExpression )
            	    // InternalPreprocess.g:4545:3: lv_right_4_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_right_4_0=ruleMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_4_0, 
            	              		"at.jku.weiner.c.common.Common.MultiplicativeExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop84;
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalPreprocess.g:4580:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalPreprocess.g:4581:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalPreprocess.g:4582:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalPreprocess.g:4589:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_right_5_0= ruleCastExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        Token lv_op_4_0=null;
        EObject this_CastExpression_0 = null;

        EObject lv_right_5_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4595:7: ( (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_right_5_0= ruleCastExpression ) ) )* ) )
            // InternalPreprocess.g:4597:1: (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_right_5_0= ruleCastExpression ) ) )* )
            {
            // InternalPreprocess.g:4597:1: (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_right_5_0= ruleCastExpression ) ) )* )
            // InternalPreprocess.g:4599:2: this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_right_5_0= ruleCastExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getCastExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_37);
            this_CastExpression_0=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_CastExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalPreprocess.g:4613:1: ( () ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_right_5_0= ruleCastExpression ) ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( ((LA86_0>=RULE_SKW_STAR && LA86_0<=RULE_SKW_MOD)) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // InternalPreprocess.g:4614:1: () ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_right_5_0= ruleCastExpression ) )
            	    {
            	    // InternalPreprocess.g:4614:1: ()
            	    // InternalPreprocess.g:4615:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalPreprocess.g:4626:1: ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) )
            	    int alt85=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_SKW_STAR:
            	        {
            	        alt85=1;
            	        }
            	        break;
            	    case RULE_SKW_DIV:
            	        {
            	        alt85=2;
            	        }
            	        break;
            	    case RULE_SKW_MOD:
            	        {
            	        alt85=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 85, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt85) {
            	        case 1 :
            	            // InternalPreprocess.g:4627:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
            	            {
            	            // InternalPreprocess.g:4627:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
            	            // InternalPreprocess.g:4628:1: (lv_op_2_0= RULE_SKW_STAR )
            	            {
            	            // InternalPreprocess.g:4628:1: (lv_op_2_0= RULE_SKW_STAR )
            	            // InternalPreprocess.g:4629:3: lv_op_2_0= RULE_SKW_STAR
            	            {
            	            lv_op_2_0=(Token)match(input,RULE_SKW_STAR,FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_2_0, grammarAccess.getMultiplicativeExpressionAccess().getOpSKW_STARTerminalRuleCall_1_1_0_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
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
            	        case 2 :
            	            // InternalPreprocess.g:4649:1: ( (lv_op_3_0= RULE_SKW_DIV ) )
            	            {
            	            // InternalPreprocess.g:4649:1: ( (lv_op_3_0= RULE_SKW_DIV ) )
            	            // InternalPreprocess.g:4650:1: (lv_op_3_0= RULE_SKW_DIV )
            	            {
            	            // InternalPreprocess.g:4650:1: (lv_op_3_0= RULE_SKW_DIV )
            	            // InternalPreprocess.g:4651:3: lv_op_3_0= RULE_SKW_DIV
            	            {
            	            lv_op_3_0=(Token)match(input,RULE_SKW_DIV,FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_3_0, grammarAccess.getMultiplicativeExpressionAccess().getOpSKW_DIVTerminalRuleCall_1_1_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	              	        }
            	                     		setWithLastConsumed(
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
            	            // InternalPreprocess.g:4671:1: ( (lv_op_4_0= RULE_SKW_MOD ) )
            	            {
            	            // InternalPreprocess.g:4671:1: ( (lv_op_4_0= RULE_SKW_MOD ) )
            	            // InternalPreprocess.g:4672:1: (lv_op_4_0= RULE_SKW_MOD )
            	            {
            	            // InternalPreprocess.g:4672:1: (lv_op_4_0= RULE_SKW_MOD )
            	            // InternalPreprocess.g:4673:3: lv_op_4_0= RULE_SKW_MOD
            	            {
            	            lv_op_4_0=(Token)match(input,RULE_SKW_MOD,FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_op_4_0, grammarAccess.getMultiplicativeExpressionAccess().getOpSKW_MODTerminalRuleCall_1_1_2_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	              	        }
            	                     		setWithLastConsumed(
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

            	    // InternalPreprocess.g:4694:1: ( (lv_right_5_0= ruleCastExpression ) )
            	    // InternalPreprocess.g:4695:1: (lv_right_5_0= ruleCastExpression )
            	    {
            	    // InternalPreprocess.g:4695:1: (lv_right_5_0= ruleCastExpression )
            	    // InternalPreprocess.g:4696:3: lv_right_5_0= ruleCastExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightCastExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_37);
            	    lv_right_5_0=ruleCastExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_5_0, 
            	              		"at.jku.weiner.c.common.Common.CastExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop86;
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleCastExpression"
    // InternalPreprocess.g:4731:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalPreprocess.g:4732:2: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalPreprocess.g:4733:2: iv_ruleCastExpression= ruleCastExpression EOF
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
    // InternalPreprocess.g:4740:1: ruleCastExpression returns [EObject current=null] : this_UnaryExpression_0= ruleUnaryExpression ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryExpression_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4746:7: (this_UnaryExpression_0= ruleUnaryExpression )
            // InternalPreprocess.g:4749:2: this_UnaryExpression_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getCastExpressionAccess().getUnaryExpressionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_2);
            this_UnaryExpression_0=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_UnaryExpression_0; 
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleCastExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalPreprocess.g:4775:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalPreprocess.g:4776:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalPreprocess.g:4777:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalPreprocess.g:4784:1: ruleUnaryExpression returns [EObject current=null] : (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PostfixExpression_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4790:7: ( (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) )
            // InternalPreprocess.g:4792:1: (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
            {
            // InternalPreprocess.g:4792:1: (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_SKW_LEFTPAREN||LA87_0==RULE_ID||LA87_0==RULE_DEFINED||(LA87_0>=RULE_HEX_LITERAL && LA87_0<=RULE_BIN_LITERAL)) ) {
                alt87=1;
            }
            else if ( (LA87_0==RULE_SKW_AND||(LA87_0>=RULE_SKW_PLUS && LA87_0<=RULE_SKW_STAR)||(LA87_0>=RULE_SKW_TILDE && LA87_0<=RULE_SKW_NOT)) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // InternalPreprocess.g:4794:2: this_PostfixExpression_0= rulePostfixExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPostfixExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_PostfixExpression_0=rulePostfixExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PostfixExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:4809:1: ( () ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
                    {
                    // InternalPreprocess.g:4809:1: ( () ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
                    // InternalPreprocess.g:4810:1: () ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) )
                    {
                    // InternalPreprocess.g:4810:1: ()
                    // InternalPreprocess.g:4811:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getUnaryExpressionAccess().getUnaryExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalPreprocess.g:4822:1: ( (lv_op_2_0= ruleUnaryOperator ) )
                    // InternalPreprocess.g:4823:1: (lv_op_2_0= ruleUnaryOperator )
                    {
                    // InternalPreprocess.g:4823:1: (lv_op_2_0= ruleUnaryOperator )
                    // InternalPreprocess.g:4824:3: lv_op_2_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_1_1_0()); 
                      	    
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

                    // InternalPreprocess.g:4843:1: ( (lv_expr_3_0= ruleCastExpression ) )
                    // InternalPreprocess.g:4844:1: (lv_expr_3_0= ruleCastExpression )
                    {
                    // InternalPreprocess.g:4844:1: (lv_expr_3_0= ruleCastExpression )
                    // InternalPreprocess.g:4845:3: lv_expr_3_0= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprCastExpressionParserRuleCall_1_2_0()); 
                      	    
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

            if ( state.backtracking==0 ) {
               leaveRule();
                  		
                   
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRuleUnaryOperator"
    // InternalPreprocess.g:4880:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // InternalPreprocess.g:4881:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalPreprocess.g:4882:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator.getText(); 
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
    // InternalPreprocess.g:4889:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_AND_0= RULE_SKW_AND | this_SKW_STAR_1= RULE_SKW_STAR | this_SKW_PLUS_2= RULE_SKW_PLUS | this_SKW_MINUS_3= RULE_SKW_MINUS | this_SKW_TILDE_4= RULE_SKW_TILDE | this_SKW_NOT_5= RULE_SKW_NOT ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_AND_0=null;
        Token this_SKW_STAR_1=null;
        Token this_SKW_PLUS_2=null;
        Token this_SKW_MINUS_3=null;
        Token this_SKW_TILDE_4=null;
        Token this_SKW_NOT_5=null;

         enterRule(); 
            
        try {
            // InternalPreprocess.g:4892:28: ( (this_SKW_AND_0= RULE_SKW_AND | this_SKW_STAR_1= RULE_SKW_STAR | this_SKW_PLUS_2= RULE_SKW_PLUS | this_SKW_MINUS_3= RULE_SKW_MINUS | this_SKW_TILDE_4= RULE_SKW_TILDE | this_SKW_NOT_5= RULE_SKW_NOT ) )
            // InternalPreprocess.g:4893:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_STAR_1= RULE_SKW_STAR | this_SKW_PLUS_2= RULE_SKW_PLUS | this_SKW_MINUS_3= RULE_SKW_MINUS | this_SKW_TILDE_4= RULE_SKW_TILDE | this_SKW_NOT_5= RULE_SKW_NOT )
            {
            // InternalPreprocess.g:4893:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_STAR_1= RULE_SKW_STAR | this_SKW_PLUS_2= RULE_SKW_PLUS | this_SKW_MINUS_3= RULE_SKW_MINUS | this_SKW_TILDE_4= RULE_SKW_TILDE | this_SKW_NOT_5= RULE_SKW_NOT )
            int alt88=6;
            switch ( input.LA(1) ) {
            case RULE_SKW_AND:
                {
                alt88=1;
                }
                break;
            case RULE_SKW_STAR:
                {
                alt88=2;
                }
                break;
            case RULE_SKW_PLUS:
                {
                alt88=3;
                }
                break;
            case RULE_SKW_MINUS:
                {
                alt88=4;
                }
                break;
            case RULE_SKW_TILDE:
                {
                alt88=5;
                }
                break;
            case RULE_SKW_NOT:
                {
                alt88=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // InternalPreprocess.g:4893:6: this_SKW_AND_0= RULE_SKW_AND
                    {
                    this_SKW_AND_0=(Token)match(input,RULE_SKW_AND,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_AND_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_AND_0, grammarAccess.getUnaryOperatorAccess().getSKW_ANDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:4901:10: this_SKW_STAR_1= RULE_SKW_STAR
                    {
                    this_SKW_STAR_1=(Token)match(input,RULE_SKW_STAR,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_STAR_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_STAR_1, grammarAccess.getUnaryOperatorAccess().getSKW_STARTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalPreprocess.g:4909:10: this_SKW_PLUS_2= RULE_SKW_PLUS
                    {
                    this_SKW_PLUS_2=(Token)match(input,RULE_SKW_PLUS,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_PLUS_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_PLUS_2, grammarAccess.getUnaryOperatorAccess().getSKW_PLUSTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalPreprocess.g:4917:10: this_SKW_MINUS_3= RULE_SKW_MINUS
                    {
                    this_SKW_MINUS_3=(Token)match(input,RULE_SKW_MINUS,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_MINUS_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_MINUS_3, grammarAccess.getUnaryOperatorAccess().getSKW_MINUSTerminalRuleCall_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalPreprocess.g:4925:10: this_SKW_TILDE_4= RULE_SKW_TILDE
                    {
                    this_SKW_TILDE_4=(Token)match(input,RULE_SKW_TILDE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_TILDE_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_TILDE_4, grammarAccess.getUnaryOperatorAccess().getSKW_TILDETerminalRuleCall_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalPreprocess.g:4933:10: this_SKW_NOT_5= RULE_SKW_NOT
                    {
                    this_SKW_NOT_5=(Token)match(input,RULE_SKW_NOT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SKW_NOT_5);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_NOT_5, grammarAccess.getUnaryOperatorAccess().getSKW_NOTTerminalRuleCall_5()); 
                          
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
    // InternalPreprocess.g:4948:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalPreprocess.g:4949:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalPreprocess.g:4950:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalPreprocess.g:4957:1: rulePostfixExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) ) )* ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject lv_suffix_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4963:7: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) ) )* ) )
            // InternalPreprocess.g:4965:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) ) )* )
            {
            // InternalPreprocess.g:4965:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) ) )* )
            // InternalPreprocess.g:4967:2: this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_38);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalPreprocess.g:4981:1: ( () ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==RULE_SKW_LEFTPAREN) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalPreprocess.g:4982:1: () ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )
            	    {
            	    // InternalPreprocess.g:4982:1: ()
            	    // InternalPreprocess.g:4983:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getPostfixExpressionAccess().getPostfixExpressionExprAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalPreprocess.g:4994:1: ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )
            	    // InternalPreprocess.g:4995:1: (lv_suffix_2_0= rulePostfixExpressionSuffixArgument )
            	    {
            	    // InternalPreprocess.g:4995:1: (lv_suffix_2_0= rulePostfixExpressionSuffixArgument )
            	    // InternalPreprocess.g:4996:3: lv_suffix_2_0= rulePostfixExpressionSuffixArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getSuffixPostfixExpressionSuffixArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_suffix_2_0=rulePostfixExpressionSuffixArgument();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"suffix",
            	              		lv_suffix_2_0, 
            	              		"at.jku.weiner.c.common.Common.PostfixExpressionSuffixArgument");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop89;
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "rulePostfixExpression"


    // $ANTLR start "entryRulePostfixExpressionSuffixArgument"
    // InternalPreprocess.g:5031:1: entryRulePostfixExpressionSuffixArgument returns [EObject current=null] : iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF ;
    public final EObject entryRulePostfixExpressionSuffixArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpressionSuffixArgument = null;


        try {
            // InternalPreprocess.g:5032:2: (iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF )
            // InternalPreprocess.g:5033:2: iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF
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
    // InternalPreprocess.g:5040:1: rulePostfixExpressionSuffixArgument returns [EObject current=null] : ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN ) ;
    public final EObject rulePostfixExpressionSuffixArgument() throws RecognitionException {
        EObject current = null;

        Token this_SKW_LEFTPAREN_1=null;
        Token this_SKW_RIGHTPAREN_3=null;
        EObject lv_argumentExpressionList_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:5046:7: ( ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN ) )
            // InternalPreprocess.g:5048:1: ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN )
            {
            // InternalPreprocess.g:5048:1: ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN )
            // InternalPreprocess.g:5049:1: () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN
            {
            // InternalPreprocess.g:5049:1: ()
            // InternalPreprocess.g:5050:2: 
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
            // InternalPreprocess.g:5068:1: ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_SKW_LEFTPAREN||LA90_0==RULE_ID||LA90_0==RULE_DEFINED||LA90_0==RULE_SKW_AND||(LA90_0>=RULE_SKW_PLUS && LA90_0<=RULE_SKW_STAR)||(LA90_0>=RULE_SKW_TILDE && LA90_0<=RULE_SKW_NOT)||(LA90_0>=RULE_HEX_LITERAL && LA90_0<=RULE_BIN_LITERAL)) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalPreprocess.g:5069:1: (lv_argumentExpressionList_2_0= ruleArgumentExpressionList )
                    {
                    // InternalPreprocess.g:5069:1: (lv_argumentExpressionList_2_0= ruleArgumentExpressionList )
                    // InternalPreprocess.g:5070:3: lv_argumentExpressionList_2_0= ruleArgumentExpressionList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPostfixExpressionSuffixArgumentAccess().getArgumentExpressionListArgumentExpressionListParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_13);
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
                  		
                   
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "rulePostfixExpressionSuffixArgument"


    // $ANTLR start "entryRuleArgumentExpressionList"
    // InternalPreprocess.g:5110:1: entryRuleArgumentExpressionList returns [EObject current=null] : iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF ;
    public final EObject entryRuleArgumentExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentExpressionList = null;


        try {
            // InternalPreprocess.g:5111:2: (iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF )
            // InternalPreprocess.g:5112:2: iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF
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
    // InternalPreprocess.g:5119:1: ruleArgumentExpressionList returns [EObject current=null] : ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* ) ;
    public final EObject ruleArgumentExpressionList() throws RecognitionException {
        EObject current = null;

        Token this_SKW_COMMA_1=null;
        EObject lv_expr_0_0 = null;

        EObject lv_expr_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:5125:7: ( ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* ) )
            // InternalPreprocess.g:5127:1: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* )
            {
            // InternalPreprocess.g:5127:1: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* )
            // InternalPreprocess.g:5128:1: ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )*
            {
            // InternalPreprocess.g:5128:1: ( (lv_expr_0_0= ruleConditionalExpression ) )
            // InternalPreprocess.g:5129:1: (lv_expr_0_0= ruleConditionalExpression )
            {
            // InternalPreprocess.g:5129:1: (lv_expr_0_0= ruleConditionalExpression )
            // InternalPreprocess.g:5130:3: lv_expr_0_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArgumentExpressionListAccess().getExprConditionalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_39);
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

            // InternalPreprocess.g:5149:1: (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==RULE_SKW_COMMA) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalPreprocess.g:5150:1: this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) )
            	    {
            	    this_SKW_COMMA_1=(Token)match(input,RULE_SKW_COMMA,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_COMMA_1, grammarAccess.getArgumentExpressionListAccess().getSKW_COMMATerminalRuleCall_1_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:5157:1: ( (lv_expr_2_0= ruleConditionalExpression ) )
            	    // InternalPreprocess.g:5158:1: (lv_expr_2_0= ruleConditionalExpression )
            	    {
            	    // InternalPreprocess.g:5158:1: (lv_expr_2_0= ruleConditionalExpression )
            	    // InternalPreprocess.g:5159:3: lv_expr_2_0= ruleConditionalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArgumentExpressionListAccess().getExprConditionalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_39);
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
            	    break loop91;
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleArgumentExpressionList"


    // $ANTLR start "entryRuleConstant1"
    // InternalPreprocess.g:5194:1: entryRuleConstant1 returns [String current=null] : iv_ruleConstant1= ruleConstant1 EOF ;
    public final String entryRuleConstant1() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConstant1 = null;


        try {
            // InternalPreprocess.g:5195:2: (iv_ruleConstant1= ruleConstant1 EOF )
            // InternalPreprocess.g:5196:2: iv_ruleConstant1= ruleConstant1 EOF
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
    // InternalPreprocess.g:5203:1: ruleConstant1 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HexLiteral_0= ruleHexLiteral | this_OctalLiteral_1= ruleOctalLiteral | this_DecimalLiteral_2= ruleDecimalLiteral | this_CharLiteral_3= ruleCharLiteral | this_StringLiteral_4= ruleStringLiteral | this_FloatLiteral_5= ruleFloatLiteral | this_BinLiteral_6= ruleBinLiteral ) ;
    public final AntlrDatatypeRuleToken ruleConstant1() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_HexLiteral_0 = null;

        AntlrDatatypeRuleToken this_OctalLiteral_1 = null;

        AntlrDatatypeRuleToken this_DecimalLiteral_2 = null;

        AntlrDatatypeRuleToken this_CharLiteral_3 = null;

        AntlrDatatypeRuleToken this_StringLiteral_4 = null;

        AntlrDatatypeRuleToken this_FloatLiteral_5 = null;

        AntlrDatatypeRuleToken this_BinLiteral_6 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:5206:28: ( (this_HexLiteral_0= ruleHexLiteral | this_OctalLiteral_1= ruleOctalLiteral | this_DecimalLiteral_2= ruleDecimalLiteral | this_CharLiteral_3= ruleCharLiteral | this_StringLiteral_4= ruleStringLiteral | this_FloatLiteral_5= ruleFloatLiteral | this_BinLiteral_6= ruleBinLiteral ) )
            // InternalPreprocess.g:5207:1: (this_HexLiteral_0= ruleHexLiteral | this_OctalLiteral_1= ruleOctalLiteral | this_DecimalLiteral_2= ruleDecimalLiteral | this_CharLiteral_3= ruleCharLiteral | this_StringLiteral_4= ruleStringLiteral | this_FloatLiteral_5= ruleFloatLiteral | this_BinLiteral_6= ruleBinLiteral )
            {
            // InternalPreprocess.g:5207:1: (this_HexLiteral_0= ruleHexLiteral | this_OctalLiteral_1= ruleOctalLiteral | this_DecimalLiteral_2= ruleDecimalLiteral | this_CharLiteral_3= ruleCharLiteral | this_StringLiteral_4= ruleStringLiteral | this_FloatLiteral_5= ruleFloatLiteral | this_BinLiteral_6= ruleBinLiteral )
            int alt92=7;
            switch ( input.LA(1) ) {
            case RULE_HEX_LITERAL:
                {
                alt92=1;
                }
                break;
            case RULE_OCTAL_LITERAL:
                {
                alt92=2;
                }
                break;
            case RULE_DECIMAL_LITERAL:
                {
                alt92=3;
                }
                break;
            case RULE_CHAR_LITERAL:
                {
                alt92=4;
                }
                break;
            case RULE_STRING_LITERAL:
                {
                alt92=5;
                }
                break;
            case RULE_FLOAT_LITERAL:
                {
                alt92=6;
                }
                break;
            case RULE_BIN_LITERAL:
                {
                alt92=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // InternalPreprocess.g:5208:5: this_HexLiteral_0= ruleHexLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstant1Access().getHexLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_HexLiteral_0=ruleHexLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HexLiteral_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:5220:5: this_OctalLiteral_1= ruleOctalLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstant1Access().getOctalLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_OctalLiteral_1=ruleOctalLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_OctalLiteral_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalPreprocess.g:5232:5: this_DecimalLiteral_2= ruleDecimalLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstant1Access().getDecimalLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_DecimalLiteral_2=ruleDecimalLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DecimalLiteral_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalPreprocess.g:5244:5: this_CharLiteral_3= ruleCharLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstant1Access().getCharLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_CharLiteral_3=ruleCharLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_CharLiteral_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalPreprocess.g:5256:5: this_StringLiteral_4= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstant1Access().getStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_StringLiteral_4=ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_StringLiteral_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalPreprocess.g:5268:5: this_FloatLiteral_5= ruleFloatLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstant1Access().getFloatLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_FloatLiteral_5=ruleFloatLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_FloatLiteral_5);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalPreprocess.g:5280:5: this_BinLiteral_6= ruleBinLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstant1Access().getBinLiteralParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_BinLiteral_6=ruleBinLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BinLiteral_6);
                          
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
    // $ANTLR end "ruleConstant1"


    // $ANTLR start "entryRuleSpecialKeywords"
    // InternalPreprocess.g:5300:1: entryRuleSpecialKeywords returns [String current=null] : iv_ruleSpecialKeywords= ruleSpecialKeywords EOF ;
    public final String entryRuleSpecialKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpecialKeywords = null;


        try {
            // InternalPreprocess.g:5301:2: (iv_ruleSpecialKeywords= ruleSpecialKeywords EOF )
            // InternalPreprocess.g:5302:2: iv_ruleSpecialKeywords= ruleSpecialKeywords EOF
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
    // InternalPreprocess.g:5309:1: ruleSpecialKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE ) ;
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
            // InternalPreprocess.g:5312:28: ( (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE ) )
            // InternalPreprocess.g:5313:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE )
            {
            // InternalPreprocess.g:5313:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE )
            int alt93=37;
            switch ( input.LA(1) ) {
            case RULE_SKW_AND:
                {
                alt93=1;
                }
                break;
            case RULE_SKW_ANDAND:
                {
                alt93=2;
                }
                break;
            case RULE_SKW_ASSIGN:
                {
                alt93=3;
                }
                break;
            case RULE_SKW_BACKSLASH:
                {
                alt93=4;
                }
                break;
            case RULE_SKW_CARET:
                {
                alt93=5;
                }
                break;
            case RULE_SKW_COMMA:
                {
                alt93=6;
                }
                break;
            case RULE_SKW_COLON:
                {
                alt93=7;
                }
                break;
            case RULE_SKW_DIV:
                {
                alt93=8;
                }
                break;
            case RULE_SKW_DOT:
                {
                alt93=9;
                }
                break;
            case RULE_SKW_DOUBLEQUOTE:
                {
                alt93=10;
                }
                break;
            case RULE_SKW_EQUAL:
                {
                alt93=11;
                }
                break;
            case RULE_SKW_GREATER:
                {
                alt93=12;
                }
                break;
            case RULE_SKW_GREATEREQUAL:
                {
                alt93=13;
                }
                break;
            case RULE_SKW_LEFTBRACE:
                {
                alt93=14;
                }
                break;
            case RULE_SKW_LEFTBRACKET:
                {
                alt93=15;
                }
                break;
            case RULE_SKW_LEFTPAREN:
                {
                alt93=16;
                }
                break;
            case RULE_SKW_LEFTSHIFT:
                {
                alt93=17;
                }
                break;
            case RULE_SKW_LESS:
                {
                alt93=18;
                }
                break;
            case RULE_SKW_LESSEQUAL:
                {
                alt93=19;
                }
                break;
            case RULE_SKW_MINUS:
                {
                alt93=20;
                }
                break;
            case RULE_SKW_MINUSMINUS:
                {
                alt93=21;
                }
                break;
            case RULE_SKW_MOD:
                {
                alt93=22;
                }
                break;
            case RULE_SKW_NOT:
                {
                alt93=23;
                }
                break;
            case RULE_SKW_NOTEQUAL:
                {
                alt93=24;
                }
                break;
            case RULE_SKW_OR:
                {
                alt93=25;
                }
                break;
            case RULE_SKW_OROR:
                {
                alt93=26;
                }
                break;
            case RULE_SKW_PLUS:
                {
                alt93=27;
                }
                break;
            case RULE_SKW_PLUSPLUS:
                {
                alt93=28;
                }
                break;
            case RULE_SKW_QUESTION:
                {
                alt93=29;
                }
                break;
            case RULE_SKW_RIGHTBRACE:
                {
                alt93=30;
                }
                break;
            case RULE_SKW_RIGHTBRACKET:
                {
                alt93=31;
                }
                break;
            case RULE_SKW_RIGHTPAREN:
                {
                alt93=32;
                }
                break;
            case RULE_SKW_RIGHTSHIFT:
                {
                alt93=33;
                }
                break;
            case RULE_SKW_SEMI:
                {
                alt93=34;
                }
                break;
            case RULE_SKW_SINGLEQUOTE:
                {
                alt93=35;
                }
                break;
            case RULE_SKW_STAR:
                {
                alt93=36;
                }
                break;
            case RULE_SKW_TILDE:
                {
                alt93=37;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // InternalPreprocess.g:5313:6: this_SKW_AND_0= RULE_SKW_AND
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
                    // InternalPreprocess.g:5321:10: this_SKW_ANDAND_1= RULE_SKW_ANDAND
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
                    // InternalPreprocess.g:5329:10: this_SKW_ASSIGN_2= RULE_SKW_ASSIGN
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
                    // InternalPreprocess.g:5337:10: this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH
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
                    // InternalPreprocess.g:5345:10: this_SKW_CARET_4= RULE_SKW_CARET
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
                    // InternalPreprocess.g:5353:10: this_SKW_COMMA_5= RULE_SKW_COMMA
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
                    // InternalPreprocess.g:5361:10: this_SKW_COLON_6= RULE_SKW_COLON
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
                    // InternalPreprocess.g:5369:10: this_SKW_DIV_7= RULE_SKW_DIV
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
                    // InternalPreprocess.g:5377:10: this_SKW_DOT_8= RULE_SKW_DOT
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
                    // InternalPreprocess.g:5385:10: this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE
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
                    // InternalPreprocess.g:5393:10: this_SKW_EQUAL_10= RULE_SKW_EQUAL
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
                    // InternalPreprocess.g:5401:10: this_SKW_GREATER_11= RULE_SKW_GREATER
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
                    // InternalPreprocess.g:5409:10: this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL
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
                    // InternalPreprocess.g:5417:10: this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE
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
                    // InternalPreprocess.g:5425:10: this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET
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
                    // InternalPreprocess.g:5433:10: this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN
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
                    // InternalPreprocess.g:5441:10: this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT
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
                    // InternalPreprocess.g:5449:10: this_SKW_LESS_17= RULE_SKW_LESS
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
                    // InternalPreprocess.g:5457:10: this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL
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
                    // InternalPreprocess.g:5465:10: this_SKW_MINUS_19= RULE_SKW_MINUS
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
                    // InternalPreprocess.g:5473:10: this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS
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
                    // InternalPreprocess.g:5481:10: this_SKW_MOD_21= RULE_SKW_MOD
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
                    // InternalPreprocess.g:5489:10: this_SKW_NOT_22= RULE_SKW_NOT
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
                    // InternalPreprocess.g:5497:10: this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL
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
                    // InternalPreprocess.g:5505:10: this_SKW_OR_24= RULE_SKW_OR
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
                    // InternalPreprocess.g:5513:10: this_SKW_OROR_25= RULE_SKW_OROR
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
                    // InternalPreprocess.g:5521:10: this_SKW_PLUS_26= RULE_SKW_PLUS
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
                    // InternalPreprocess.g:5529:10: this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS
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
                    // InternalPreprocess.g:5537:10: this_SKW_QUESTION_28= RULE_SKW_QUESTION
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
                    // InternalPreprocess.g:5545:10: this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE
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
                    // InternalPreprocess.g:5553:10: this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET
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
                    // InternalPreprocess.g:5561:10: this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN
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
                    // InternalPreprocess.g:5569:10: this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT
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
                    // InternalPreprocess.g:5577:10: this_SKW_SEMI_33= RULE_SKW_SEMI
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
                    // InternalPreprocess.g:5585:10: this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE
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
                    // InternalPreprocess.g:5593:10: this_SKW_STAR_35= RULE_SKW_STAR
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
                    // InternalPreprocess.g:5601:10: this_SKW_TILDE_36= RULE_SKW_TILDE
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


    // $ANTLR start "entryRuleEllipsis"
    // InternalPreprocess.g:5616:1: entryRuleEllipsis returns [String current=null] : iv_ruleEllipsis= ruleEllipsis EOF ;
    public final String entryRuleEllipsis() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEllipsis = null;


        try {
            // InternalPreprocess.g:5617:2: (iv_ruleEllipsis= ruleEllipsis EOF )
            // InternalPreprocess.g:5618:2: iv_ruleEllipsis= ruleEllipsis EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEllipsisRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEllipsis=ruleEllipsis();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEllipsis.getText(); 
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
    // $ANTLR end "entryRuleEllipsis"


    // $ANTLR start "ruleEllipsis"
    // InternalPreprocess.g:5625:1: ruleEllipsis returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_DOT_0= RULE_SKW_DOT this_SKW_DOT_1= RULE_SKW_DOT this_SKW_DOT_2= RULE_SKW_DOT ) ;
    public final AntlrDatatypeRuleToken ruleEllipsis() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_DOT_0=null;
        Token this_SKW_DOT_1=null;
        Token this_SKW_DOT_2=null;

         enterRule(); 
            
        try {
            // InternalPreprocess.g:5628:28: ( (this_SKW_DOT_0= RULE_SKW_DOT this_SKW_DOT_1= RULE_SKW_DOT this_SKW_DOT_2= RULE_SKW_DOT ) )
            // InternalPreprocess.g:5629:1: (this_SKW_DOT_0= RULE_SKW_DOT this_SKW_DOT_1= RULE_SKW_DOT this_SKW_DOT_2= RULE_SKW_DOT )
            {
            // InternalPreprocess.g:5629:1: (this_SKW_DOT_0= RULE_SKW_DOT this_SKW_DOT_1= RULE_SKW_DOT this_SKW_DOT_2= RULE_SKW_DOT )
            // InternalPreprocess.g:5629:6: this_SKW_DOT_0= RULE_SKW_DOT this_SKW_DOT_1= RULE_SKW_DOT this_SKW_DOT_2= RULE_SKW_DOT
            {
            this_SKW_DOT_0=(Token)match(input,RULE_SKW_DOT,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_SKW_DOT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SKW_DOT_0, grammarAccess.getEllipsisAccess().getSKW_DOTTerminalRuleCall_0()); 
                  
            }
            this_SKW_DOT_1=(Token)match(input,RULE_SKW_DOT,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_SKW_DOT_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SKW_DOT_1, grammarAccess.getEllipsisAccess().getSKW_DOTTerminalRuleCall_1()); 
                  
            }
            this_SKW_DOT_2=(Token)match(input,RULE_SKW_DOT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_SKW_DOT_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SKW_DOT_2, grammarAccess.getEllipsisAccess().getSKW_DOTTerminalRuleCall_2()); 
                  
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
    // $ANTLR end "ruleEllipsis"


    // $ANTLR start "entryRuleHexLiteral"
    // InternalPreprocess.g:5658:1: entryRuleHexLiteral returns [String current=null] : iv_ruleHexLiteral= ruleHexLiteral EOF ;
    public final String entryRuleHexLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHexLiteral = null;


        try {
            // InternalPreprocess.g:5659:2: (iv_ruleHexLiteral= ruleHexLiteral EOF )
            // InternalPreprocess.g:5660:2: iv_ruleHexLiteral= ruleHexLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHexLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHexLiteral=ruleHexLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHexLiteral.getText(); 
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
    // $ANTLR end "entryRuleHexLiteral"


    // $ANTLR start "ruleHexLiteral"
    // InternalPreprocess.g:5667:1: ruleHexLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_HEX_LITERAL_0= RULE_HEX_LITERAL ;
    public final AntlrDatatypeRuleToken ruleHexLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_LITERAL_0=null;

         enterRule(); 
            
        try {
            // InternalPreprocess.g:5670:28: (this_HEX_LITERAL_0= RULE_HEX_LITERAL )
            // InternalPreprocess.g:5671:5: this_HEX_LITERAL_0= RULE_HEX_LITERAL
            {
            this_HEX_LITERAL_0=(Token)match(input,RULE_HEX_LITERAL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_HEX_LITERAL_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HEX_LITERAL_0, grammarAccess.getHexLiteralAccess().getHEX_LITERALTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleHexLiteral"


    // $ANTLR start "entryRuleOctalLiteral"
    // InternalPreprocess.g:5686:1: entryRuleOctalLiteral returns [String current=null] : iv_ruleOctalLiteral= ruleOctalLiteral EOF ;
    public final String entryRuleOctalLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOctalLiteral = null;


        try {
            // InternalPreprocess.g:5687:2: (iv_ruleOctalLiteral= ruleOctalLiteral EOF )
            // InternalPreprocess.g:5688:2: iv_ruleOctalLiteral= ruleOctalLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOctalLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOctalLiteral=ruleOctalLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOctalLiteral.getText(); 
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
    // $ANTLR end "entryRuleOctalLiteral"


    // $ANTLR start "ruleOctalLiteral"
    // InternalPreprocess.g:5695:1: ruleOctalLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_OCTAL_LITERAL_0= RULE_OCTAL_LITERAL ;
    public final AntlrDatatypeRuleToken ruleOctalLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_OCTAL_LITERAL_0=null;

         enterRule(); 
            
        try {
            // InternalPreprocess.g:5698:28: (this_OCTAL_LITERAL_0= RULE_OCTAL_LITERAL )
            // InternalPreprocess.g:5699:5: this_OCTAL_LITERAL_0= RULE_OCTAL_LITERAL
            {
            this_OCTAL_LITERAL_0=(Token)match(input,RULE_OCTAL_LITERAL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_OCTAL_LITERAL_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_OCTAL_LITERAL_0, grammarAccess.getOctalLiteralAccess().getOCTAL_LITERALTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleOctalLiteral"


    // $ANTLR start "entryRuleDecimalLiteral"
    // InternalPreprocess.g:5714:1: entryRuleDecimalLiteral returns [String current=null] : iv_ruleDecimalLiteral= ruleDecimalLiteral EOF ;
    public final String entryRuleDecimalLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalLiteral = null;


        try {
            // InternalPreprocess.g:5715:2: (iv_ruleDecimalLiteral= ruleDecimalLiteral EOF )
            // InternalPreprocess.g:5716:2: iv_ruleDecimalLiteral= ruleDecimalLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDecimalLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDecimalLiteral=ruleDecimalLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDecimalLiteral.getText(); 
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
    // $ANTLR end "entryRuleDecimalLiteral"


    // $ANTLR start "ruleDecimalLiteral"
    // InternalPreprocess.g:5723:1: ruleDecimalLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DECIMAL_LITERAL_0= RULE_DECIMAL_LITERAL ;
    public final AntlrDatatypeRuleToken ruleDecimalLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECIMAL_LITERAL_0=null;

         enterRule(); 
            
        try {
            // InternalPreprocess.g:5726:28: (this_DECIMAL_LITERAL_0= RULE_DECIMAL_LITERAL )
            // InternalPreprocess.g:5727:5: this_DECIMAL_LITERAL_0= RULE_DECIMAL_LITERAL
            {
            this_DECIMAL_LITERAL_0=(Token)match(input,RULE_DECIMAL_LITERAL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_DECIMAL_LITERAL_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DECIMAL_LITERAL_0, grammarAccess.getDecimalLiteralAccess().getDECIMAL_LITERALTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleDecimalLiteral"


    // $ANTLR start "entryRuleCharLiteral"
    // InternalPreprocess.g:5742:1: entryRuleCharLiteral returns [String current=null] : iv_ruleCharLiteral= ruleCharLiteral EOF ;
    public final String entryRuleCharLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCharLiteral = null;


        try {
            // InternalPreprocess.g:5743:2: (iv_ruleCharLiteral= ruleCharLiteral EOF )
            // InternalPreprocess.g:5744:2: iv_ruleCharLiteral= ruleCharLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCharLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCharLiteral=ruleCharLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCharLiteral.getText(); 
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
    // $ANTLR end "entryRuleCharLiteral"


    // $ANTLR start "ruleCharLiteral"
    // InternalPreprocess.g:5751:1: ruleCharLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_CHAR_LITERAL_0= RULE_CHAR_LITERAL ;
    public final AntlrDatatypeRuleToken ruleCharLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CHAR_LITERAL_0=null;

         enterRule(); 
            
        try {
            // InternalPreprocess.g:5754:28: (this_CHAR_LITERAL_0= RULE_CHAR_LITERAL )
            // InternalPreprocess.g:5755:5: this_CHAR_LITERAL_0= RULE_CHAR_LITERAL
            {
            this_CHAR_LITERAL_0=(Token)match(input,RULE_CHAR_LITERAL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_CHAR_LITERAL_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_CHAR_LITERAL_0, grammarAccess.getCharLiteralAccess().getCHAR_LITERALTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleCharLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalPreprocess.g:5770:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // InternalPreprocess.g:5771:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalPreprocess.g:5772:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText(); 
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
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalPreprocess.g:5779:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_LITERAL_0= RULE_STRING_LITERAL ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_LITERAL_0=null;

         enterRule(); 
            
        try {
            // InternalPreprocess.g:5782:28: (this_STRING_LITERAL_0= RULE_STRING_LITERAL )
            // InternalPreprocess.g:5783:5: this_STRING_LITERAL_0= RULE_STRING_LITERAL
            {
            this_STRING_LITERAL_0=(Token)match(input,RULE_STRING_LITERAL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STRING_LITERAL_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_STRING_LITERAL_0, grammarAccess.getStringLiteralAccess().getSTRING_LITERALTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleFloatLiteral"
    // InternalPreprocess.g:5798:1: entryRuleFloatLiteral returns [String current=null] : iv_ruleFloatLiteral= ruleFloatLiteral EOF ;
    public final String entryRuleFloatLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFloatLiteral = null;


        try {
            // InternalPreprocess.g:5799:2: (iv_ruleFloatLiteral= ruleFloatLiteral EOF )
            // InternalPreprocess.g:5800:2: iv_ruleFloatLiteral= ruleFloatLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloatLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFloatLiteral=ruleFloatLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFloatLiteral.getText(); 
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
    // $ANTLR end "entryRuleFloatLiteral"


    // $ANTLR start "ruleFloatLiteral"
    // InternalPreprocess.g:5807:1: ruleFloatLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_FLOAT_LITERAL_0= RULE_FLOAT_LITERAL ;
    public final AntlrDatatypeRuleToken ruleFloatLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_FLOAT_LITERAL_0=null;

         enterRule(); 
            
        try {
            // InternalPreprocess.g:5810:28: (this_FLOAT_LITERAL_0= RULE_FLOAT_LITERAL )
            // InternalPreprocess.g:5811:5: this_FLOAT_LITERAL_0= RULE_FLOAT_LITERAL
            {
            this_FLOAT_LITERAL_0=(Token)match(input,RULE_FLOAT_LITERAL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_FLOAT_LITERAL_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_FLOAT_LITERAL_0, grammarAccess.getFloatLiteralAccess().getFLOAT_LITERALTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleFloatLiteral"


    // $ANTLR start "entryRuleBinLiteral"
    // InternalPreprocess.g:5826:1: entryRuleBinLiteral returns [String current=null] : iv_ruleBinLiteral= ruleBinLiteral EOF ;
    public final String entryRuleBinLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBinLiteral = null;


        try {
            // InternalPreprocess.g:5827:2: (iv_ruleBinLiteral= ruleBinLiteral EOF )
            // InternalPreprocess.g:5828:2: iv_ruleBinLiteral= ruleBinLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBinLiteral=ruleBinLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinLiteral.getText(); 
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
    // $ANTLR end "entryRuleBinLiteral"


    // $ANTLR start "ruleBinLiteral"
    // InternalPreprocess.g:5835:1: ruleBinLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BIN_LITERAL_0= RULE_BIN_LITERAL ;
    public final AntlrDatatypeRuleToken ruleBinLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BIN_LITERAL_0=null;

         enterRule(); 
            
        try {
            // InternalPreprocess.g:5838:28: (this_BIN_LITERAL_0= RULE_BIN_LITERAL )
            // InternalPreprocess.g:5839:5: this_BIN_LITERAL_0= RULE_BIN_LITERAL
            {
            this_BIN_LITERAL_0=(Token)match(input,RULE_BIN_LITERAL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_BIN_LITERAL_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_BIN_LITERAL_0, grammarAccess.getBinLiteralAccess().getBIN_LITERALTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleBinLiteral"

    // $ANTLR start synpred2_InternalPreprocess
    public final void synpred2_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_NEWLINE_2=null;
        EObject lv_lines_1_0 = null;


        // InternalPreprocess.g:245:1: ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )
        // InternalPreprocess.g:245:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE
        {
        // InternalPreprocess.g:245:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) )
        // InternalPreprocess.g:246:1: (lv_lines_1_0= ruleGroupOptTemp1 )
        {
        // InternalPreprocess.g:246:1: (lv_lines_1_0= ruleGroupOptTemp1 )
        // InternalPreprocess.g:247:3: lv_lines_1_0= ruleGroupOptTemp1
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

    // $ANTLR start synpred18_InternalPreprocess
    public final void synpred18_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_3=null;

        // InternalPreprocess.g:779:2: (this_WHITESPACE_3= RULE_WHITESPACE )
        // InternalPreprocess.g:779:2: this_WHITESPACE_3= RULE_WHITESPACE
        {
        this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_InternalPreprocess

    // $ANTLR start synpred21_InternalPreprocess
    public final void synpred21_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_4=null;

        // InternalPreprocess.g:950:2: (this_WHITESPACE_4= RULE_WHITESPACE )
        // InternalPreprocess.g:950:2: this_WHITESPACE_4= RULE_WHITESPACE
        {
        this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalPreprocess

    // $ANTLR start synpred22_InternalPreprocess
    public final void synpred22_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_4=null;
        AntlrDatatypeRuleToken lv_string_5_0 = null;


        // InternalPreprocess.g:950:1: ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLineObject ) ) )
        // InternalPreprocess.g:950:1: (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLineObject ) )
        {
        // InternalPreprocess.g:950:1: (this_WHITESPACE_4= RULE_WHITESPACE )+
        int cnt94=0;
        loop94:
        do {
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==RULE_WHITESPACE) ) {
                int LA94_2 = input.LA(2);

                if ( (synpred21_InternalPreprocess()) ) {
                    alt94=1;
                }


            }


            switch (alt94) {
        	case 1 :
        	    // InternalPreprocess.g:950:2: this_WHITESPACE_4= RULE_WHITESPACE
        	    {
        	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt94 >= 1 ) break loop94;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(94, input);
                    throw eee;
            }
            cnt94++;
        } while (true);

        // InternalPreprocess.g:957:1: ( (lv_string_5_0= ruleMyDefineLineObject ) )
        // InternalPreprocess.g:958:1: (lv_string_5_0= ruleMyDefineLineObject )
        {
        // InternalPreprocess.g:958:1: (lv_string_5_0= ruleMyDefineLineObject )
        // InternalPreprocess.g:959:3: lv_string_5_0= ruleMyDefineLineObject
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getDefineObjectMacroAccess().getStringMyDefineLineObjectParserRuleCall_4_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_string_5_0=ruleMyDefineLineObject();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred22_InternalPreprocess

    // $ANTLR start synpred40_InternalPreprocess
    public final void synpred40_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_2=null;

        // InternalPreprocess.g:1546:2: (this_WHITESPACE_2= RULE_WHITESPACE )
        // InternalPreprocess.g:1546:2: this_WHITESPACE_2= RULE_WHITESPACE
        {
        this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_InternalPreprocess

    // $ANTLR start synpred42_InternalPreprocess
    public final void synpred42_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_2=null;

        // InternalPreprocess.g:1625:2: (this_WHITESPACE_2= RULE_WHITESPACE )
        // InternalPreprocess.g:1625:2: this_WHITESPACE_2= RULE_WHITESPACE
        {
        this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_InternalPreprocess

    // $ANTLR start synpred66_InternalPreprocess
    public final void synpred66_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_2=null;

        // InternalPreprocess.g:2552:2: (this_WHITESPACE_2= RULE_WHITESPACE )
        // InternalPreprocess.g:2552:2: this_WHITESPACE_2= RULE_WHITESPACE
        {
        this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred66_InternalPreprocess

    // $ANTLR start synpred88_InternalPreprocess
    public final void synpred88_InternalPreprocess_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_MyCode_0 = null;


        // InternalPreprocess.g:2975:5: (this_MyCode_0= ruleMyCode )
        // InternalPreprocess.g:2975:5: this_MyCode_0= ruleMyCode
        {
        if ( state.backtracking==0 ) {
           
                  newCompositeNode(grammarAccess.getMyDefineLineObjectAccess().getMyCodeParserRuleCall_0()); 
              
        }
        pushFollow(FOLLOW_2);
        this_MyCode_0=ruleMyCode();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred88_InternalPreprocess

    // $ANTLR start synpred89_InternalPreprocess
    public final void synpred89_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_1=null;

        // InternalPreprocess.g:2986:10: (this_WHITESPACE_1= RULE_WHITESPACE )
        // InternalPreprocess.g:2986:10: this_WHITESPACE_1= RULE_WHITESPACE
        {
        this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred89_InternalPreprocess

    // $ANTLR start synpred90_InternalPreprocess
    public final void synpred90_InternalPreprocess_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_MyCode_0 = null;


        // InternalPreprocess.g:3015:5: (this_MyCode_0= ruleMyCode )
        // InternalPreprocess.g:3015:5: this_MyCode_0= ruleMyCode
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
    // $ANTLR end synpred90_InternalPreprocess

    // $ANTLR start synpred91_InternalPreprocess
    public final void synpred91_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_1=null;

        // InternalPreprocess.g:3026:10: (this_WHITESPACE_1= RULE_WHITESPACE )
        // InternalPreprocess.g:3026:10: this_WHITESPACE_1= RULE_WHITESPACE
        {
        this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred91_InternalPreprocess

    // $ANTLR start synpred95_InternalPreprocess
    public final void synpred95_InternalPreprocess_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_MyCode_1 = null;


        // InternalPreprocess.g:3134:5: (this_MyCode_1= ruleMyCode )
        // InternalPreprocess.g:3134:5: this_MyCode_1= ruleMyCode
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
    // $ANTLR end synpred95_InternalPreprocess

    // $ANTLR start synpred101_InternalPreprocess
    public final void synpred101_InternalPreprocess_fragment() throws RecognitionException {   
        Token lv_defined_3_0=null;
        Token this_SKW_LEFTPAREN_4=null;
        Token lv_id_5_0=null;
        Token this_SKW_RIGHTPAREN_6=null;

        // InternalPreprocess.g:3248:1: ( ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) )
        // InternalPreprocess.g:3248:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
        {
        // InternalPreprocess.g:3248:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
        // InternalPreprocess.g:3249:1: ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN
        {
        // InternalPreprocess.g:3249:1: ( (lv_defined_3_0= RULE_DEFINED ) )?
        int alt108=2;
        int LA108_0 = input.LA(1);

        if ( (LA108_0==RULE_DEFINED) ) {
            alt108=1;
        }
        switch (alt108) {
            case 1 :
                // InternalPreprocess.g:3250:1: (lv_defined_3_0= RULE_DEFINED )
                {
                // InternalPreprocess.g:3250:1: (lv_defined_3_0= RULE_DEFINED )
                // InternalPreprocess.g:3251:3: lv_defined_3_0= RULE_DEFINED
                {
                lv_defined_3_0=(Token)match(input,RULE_DEFINED,FOLLOW_11); if (state.failed) return ;

                }


                }
                break;

        }

        this_SKW_LEFTPAREN_4=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_25); if (state.failed) return ;
        // InternalPreprocess.g:3277:1: ( (lv_id_5_0= RULE_ID ) )
        // InternalPreprocess.g:3278:1: (lv_id_5_0= RULE_ID )
        {
        // InternalPreprocess.g:3278:1: (lv_id_5_0= RULE_ID )
        // InternalPreprocess.g:3279:3: lv_id_5_0= RULE_ID
        {
        lv_id_5_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return ;

        }


        }

        this_SKW_RIGHTPAREN_6=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred101_InternalPreprocess

    // Delegated rules

    public final boolean synpred90_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalPreprocess_fragment(); // can never throw exception
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
    public final boolean synpred95_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred95_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred91_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred91_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred88_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred88_InternalPreprocess_fragment(); // can never throw exception
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
    public final boolean synpred42_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalPreprocess_fragment(); // can never throw exception
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
    public final boolean synpred40_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_InternalPreprocess_fragment(); // can never throw exception
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
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA66 dfa66 = new DFA66(this);
    static final String DFA1_eotS =
        "\6\uffff";
    static final String DFA1_eofS =
        "\1\1\5\uffff";
    static final String DFA1_minS =
        "\1\4\1\uffff\2\4\1\uffff\1\4";
    static final String DFA1_maxS =
        "\1\104\1\uffff\1\104\1\30\1\uffff\1\30";
    static final String DFA1_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\1\uffff";
    static final String DFA1_specialS =
        "\6\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\4\1\2\1\3\1\4\1\uffff\22\4\1\uffff\51\4",
            "",
            "\1\4\1\2\1\3\1\4\1\uffff\22\4\1\uffff\51\4",
            "\1\4\1\5\1\uffff\3\4\4\uffff\4\4\1\1\3\4\2\1\1\4",
            "",
            "\1\4\1\5\1\uffff\3\4\4\uffff\4\4\1\1\3\4\2\1\1\4"
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
            return "()* loopback of 169:1: ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )*";
        }
    }
    static final String DFA2_eotS =
        "\101\uffff";
    static final String DFA2_eofS =
        "\1\77\100\uffff";
    static final String DFA2_minS =
        "\1\4\76\0\2\uffff";
    static final String DFA2_maxS =
        "\1\104\76\0\2\uffff";
    static final String DFA2_acceptS =
        "\77\uffff\1\2\1\1";
    static final String DFA2_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\2\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\100\1\1\1\2\1\5\1\uffff\1\6\1\42\1\62\1\3\1\30\1\22\1\7\1\20\1\21\1\12\1\14\1\11\1\13\1\16\1\17\1\10\1\4\1\15\1\uffff\1\57\1\31\1\54\1\24\1\53\1\27\1\23\1\35\1\52\1\44\1\36\1\45\1\37\1\43\1\63\1\55\1\46\1\66\1\32\1\50\1\67\1\51\1\25\1\26\1\33\1\34\1\40\1\41\1\47\1\56\1\60\1\61\1\64\1\65\1\70\1\71\1\72\1\73\1\74\1\75\1\76",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            return "()* loopback of 244:1: ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )*";
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
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA2_2 = input.LA(1);

                         
                        int index2_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA2_3 = input.LA(1);

                         
                        int index2_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA2_4 = input.LA(1);

                         
                        int index2_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA2_5 = input.LA(1);

                         
                        int index2_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA2_6 = input.LA(1);

                         
                        int index2_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA2_7 = input.LA(1);

                         
                        int index2_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA2_8 = input.LA(1);

                         
                        int index2_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA2_9 = input.LA(1);

                         
                        int index2_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA2_10 = input.LA(1);

                         
                        int index2_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA2_11 = input.LA(1);

                         
                        int index2_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA2_12 = input.LA(1);

                         
                        int index2_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA2_13 = input.LA(1);

                         
                        int index2_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA2_14 = input.LA(1);

                         
                        int index2_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA2_15 = input.LA(1);

                         
                        int index2_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA2_16 = input.LA(1);

                         
                        int index2_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA2_17 = input.LA(1);

                         
                        int index2_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA2_18 = input.LA(1);

                         
                        int index2_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA2_19 = input.LA(1);

                         
                        int index2_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA2_20 = input.LA(1);

                         
                        int index2_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA2_21 = input.LA(1);

                         
                        int index2_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA2_22 = input.LA(1);

                         
                        int index2_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA2_23 = input.LA(1);

                         
                        int index2_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA2_24 = input.LA(1);

                         
                        int index2_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA2_25 = input.LA(1);

                         
                        int index2_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA2_26 = input.LA(1);

                         
                        int index2_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA2_27 = input.LA(1);

                         
                        int index2_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA2_28 = input.LA(1);

                         
                        int index2_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA2_29 = input.LA(1);

                         
                        int index2_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_29);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA2_30 = input.LA(1);

                         
                        int index2_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_30);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA2_31 = input.LA(1);

                         
                        int index2_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_31);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA2_32 = input.LA(1);

                         
                        int index2_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_32);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA2_33 = input.LA(1);

                         
                        int index2_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_33);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA2_34 = input.LA(1);

                         
                        int index2_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_34);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA2_35 = input.LA(1);

                         
                        int index2_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_35);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA2_36 = input.LA(1);

                         
                        int index2_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_36);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA2_37 = input.LA(1);

                         
                        int index2_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_37);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA2_38 = input.LA(1);

                         
                        int index2_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_38);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA2_39 = input.LA(1);

                         
                        int index2_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_39);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA2_40 = input.LA(1);

                         
                        int index2_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_40);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA2_41 = input.LA(1);

                         
                        int index2_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_41);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA2_42 = input.LA(1);

                         
                        int index2_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_42);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA2_43 = input.LA(1);

                         
                        int index2_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_43);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA2_44 = input.LA(1);

                         
                        int index2_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_44);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA2_45 = input.LA(1);

                         
                        int index2_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_45);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA2_46 = input.LA(1);

                         
                        int index2_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_46);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA2_47 = input.LA(1);

                         
                        int index2_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_47);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA2_48 = input.LA(1);

                         
                        int index2_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_48);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA2_49 = input.LA(1);

                         
                        int index2_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_49);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA2_50 = input.LA(1);

                         
                        int index2_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_50);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA2_51 = input.LA(1);

                         
                        int index2_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_51);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA2_52 = input.LA(1);

                         
                        int index2_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_52);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA2_53 = input.LA(1);

                         
                        int index2_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_53);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA2_54 = input.LA(1);

                         
                        int index2_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_54);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA2_55 = input.LA(1);

                         
                        int index2_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_55);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA2_56 = input.LA(1);

                         
                        int index2_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_56);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA2_57 = input.LA(1);

                         
                        int index2_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_57);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA2_58 = input.LA(1);

                         
                        int index2_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_58);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA2_59 = input.LA(1);

                         
                        int index2_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_59);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA2_60 = input.LA(1);

                         
                        int index2_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_60);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA2_61 = input.LA(1);

                         
                        int index2_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_61);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA2_62 = input.LA(1);

                         
                        int index2_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index2_62);
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
        "\2\104\3\uffff";
    static final String DFA4_acceptS =
        "\2\uffff\1\1\1\2\1\3";
    static final String DFA4_specialS =
        "\5\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\3\1\1\1\2\1\4\1\uffff\22\4\1\uffff\51\4",
            "\1\4\1\1\1\2\1\4\1\uffff\22\4\1\uffff\51\4",
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
            return "327:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode )";
        }
    }
    static final String DFA5_eotS =
        "\4\uffff";
    static final String DFA5_eofS =
        "\1\uffff\1\3\2\uffff";
    static final String DFA5_minS =
        "\2\5\2\uffff";
    static final String DFA5_maxS =
        "\2\104\2\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA5_specialS =
        "\4\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1\1\2\1\3\1\uffff\22\3\1\uffff\51\3",
            "\1\1\1\2\1\3\1\uffff\22\3\1\uffff\51\3",
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
            return "406:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_Code_1= ruleCode )";
        }
    }
    static final String DFA11_eotS =
        "\101\uffff";
    static final String DFA11_eofS =
        "\3\uffff\74\77\2\uffff";
    static final String DFA11_minS =
        "\1\11\2\5\74\4\2\uffff";
    static final String DFA11_maxS =
        "\1\11\1\5\1\104\74\12\2\uffff";
    static final String DFA11_acceptS =
        "\77\uffff\1\1\1\2";
    static final String DFA11_specialS =
        "\101\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\1",
            "\1\2",
            "\1\2\1\uffff\1\5\1\uffff\1\6\1\42\1\62\1\3\1\30\1\22\1\7\1\20\1\21\1\12\1\14\1\11\1\13\1\16\1\17\1\10\1\4\1\15\1\uffff\1\57\1\31\1\54\1\24\1\53\1\27\1\23\1\35\1\52\1\44\1\36\1\45\1\37\1\43\1\63\1\55\1\46\1\66\1\32\1\50\1\67\1\51\1\25\1\26\1\33\1\34\1\40\1\41\1\47\1\56\1\60\1\61\1\64\1\65\1\70\1\71\1\72\1\73\1\74\1\75\1\76",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "\2\77\4\uffff\1\100",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "838:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )";
        }
    }
    static final String DFA22_eotS =
        "\7\uffff";
    static final String DFA22_eofS =
        "\2\3\3\uffff\1\6\1\uffff";
    static final String DFA22_minS =
        "\3\5\1\uffff\2\5\1\uffff";
    static final String DFA22_maxS =
        "\2\15\1\64\1\uffff\2\64\1\uffff";
    static final String DFA22_acceptS =
        "\3\uffff\1\2\2\uffff\1\1";
    static final String DFA22_specialS =
        "\7\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1\5\uffff\1\3\1\uffff\1\2",
            "\1\1\5\uffff\1\3\1\uffff\1\2",
            "\1\4\6\uffff\1\5\47\uffff\1\3",
            "",
            "\1\4\6\uffff\1\5\47\uffff\1\3",
            "\1\6\5\uffff\1\6\1\uffff\1\6\46\uffff\1\3",
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
            return "()* loopback of 1196:1: ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )*";
        }
    }
    static final String DFA39_eotS =
        "\6\uffff";
    static final String DFA39_eofS =
        "\6\uffff";
    static final String DFA39_minS =
        "\4\5\2\uffff";
    static final String DFA39_maxS =
        "\2\6\2\27\2\uffff";
    static final String DFA39_acceptS =
        "\4\uffff\1\2\1\1";
    static final String DFA39_specialS =
        "\6\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\1\1\2",
            "\1\1\1\2",
            "\1\3\14\uffff\1\4\3\uffff\1\5\1\4",
            "\1\3\14\uffff\1\4\3\uffff\1\5\1\4",
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
            return "()* loopback of 1837:1: ( (lv_elifs_2_0= ruleElIfConditional ) )*";
        }
    }
    static final String DFA40_eotS =
        "\6\uffff";
    static final String DFA40_eofS =
        "\6\uffff";
    static final String DFA40_minS =
        "\4\5\2\uffff";
    static final String DFA40_maxS =
        "\2\6\2\27\2\uffff";
    static final String DFA40_acceptS =
        "\4\uffff\1\1\1\2";
    static final String DFA40_specialS =
        "\6\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\1\1\2",
            "\1\1\1\2",
            "\1\3\14\uffff\1\5\4\uffff\1\4",
            "\1\3\14\uffff\1\5\4\uffff\1\4",
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
            return "1858:1: ( (lv_else_3_0= ruleElseConditional ) )?";
        }
    }
    static final String DFA61_eotS =
        "\101\uffff";
    static final String DFA61_eofS =
        "\1\2\100\uffff";
    static final String DFA61_minS =
        "\1\4\1\0\1\uffff\74\0\2\uffff";
    static final String DFA61_maxS =
        "\1\104\1\0\1\uffff\74\0\2\uffff";
    static final String DFA61_acceptS =
        "\2\uffff\1\3\74\uffff\1\2\1\1";
    static final String DFA61_specialS =
        "\1\uffff\1\4\1\uffff\1\72\1\21\1\12\1\46\1\17\1\73\1\42\1\11\1\47\1\1\1\30\1\64\1\10\1\50\1\57\1\26\1\37\1\25\1\66\1\54\1\3\1\62\1\24\1\0\1\55\1\20\1\36\1\67\1\16\1\53\1\5\1\32\1\71\1\2\1\52\1\65\1\33\1\23\1\74\1\43\1\7\1\60\1\22\1\13\1\44\1\27\1\56\1\51\1\31\1\45\1\6\1\15\1\35\1\40\1\63\1\14\1\61\1\34\1\70\1\41\2\uffff}>";
    static final String[] DFA61_transitionS = {
            "\1\2\1\1\1\2\1\5\1\uffff\1\6\1\42\1\62\1\3\1\30\1\22\1\7\1\20\1\21\1\12\1\14\1\11\1\13\1\16\1\17\1\10\1\4\1\15\1\2\1\57\1\31\1\54\1\24\1\53\1\27\1\23\1\35\1\52\1\44\1\36\1\45\1\37\1\43\1\63\1\55\1\46\1\66\1\32\1\50\1\67\1\51\1\25\1\26\1\33\1\34\1\40\1\41\1\47\1\56\1\60\1\61\1\64\1\65\1\70\1\71\1\72\1\73\1\74\1\75\1\76",
            "\1\uffff",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA61_eot = DFA.unpackEncodedString(DFA61_eotS);
    static final short[] DFA61_eof = DFA.unpackEncodedString(DFA61_eofS);
    static final char[] DFA61_min = DFA.unpackEncodedStringToUnsignedChars(DFA61_minS);
    static final char[] DFA61_max = DFA.unpackEncodedStringToUnsignedChars(DFA61_maxS);
    static final short[] DFA61_accept = DFA.unpackEncodedString(DFA61_acceptS);
    static final short[] DFA61_special = DFA.unpackEncodedString(DFA61_specialS);
    static final short[][] DFA61_transition;

    static {
        int numStates = DFA61_transitionS.length;
        DFA61_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA61_transition[i] = DFA.unpackEncodedString(DFA61_transitionS[i]);
        }
    }

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = DFA61_eot;
            this.eof = DFA61_eof;
            this.min = DFA61_min;
            this.max = DFA61_max;
            this.accept = DFA61_accept;
            this.special = DFA61_special;
            this.transition = DFA61_transition;
        }
        public String getDescription() {
            return "()+ loopback of 2974:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_26 = input.LA(1);

                         
                        int index61_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_26);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA61_12 = input.LA(1);

                         
                        int index61_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA61_36 = input.LA(1);

                         
                        int index61_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_36);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA61_23 = input.LA(1);

                         
                        int index61_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_23);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA61_1 = input.LA(1);

                         
                        int index61_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred89_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_1);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA61_33 = input.LA(1);

                         
                        int index61_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_33);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA61_53 = input.LA(1);

                         
                        int index61_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_53);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA61_43 = input.LA(1);

                         
                        int index61_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_43);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA61_15 = input.LA(1);

                         
                        int index61_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_15);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA61_10 = input.LA(1);

                         
                        int index61_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA61_5 = input.LA(1);

                         
                        int index61_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_5);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA61_46 = input.LA(1);

                         
                        int index61_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_46);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA61_58 = input.LA(1);

                         
                        int index61_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_58);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA61_54 = input.LA(1);

                         
                        int index61_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_54);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA61_31 = input.LA(1);

                         
                        int index61_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_31);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA61_7 = input.LA(1);

                         
                        int index61_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_7);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA61_28 = input.LA(1);

                         
                        int index61_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_28);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA61_4 = input.LA(1);

                         
                        int index61_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_4);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA61_45 = input.LA(1);

                         
                        int index61_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_45);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA61_40 = input.LA(1);

                         
                        int index61_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_40);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA61_25 = input.LA(1);

                         
                        int index61_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_25);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA61_20 = input.LA(1);

                         
                        int index61_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_20);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA61_18 = input.LA(1);

                         
                        int index61_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_18);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA61_48 = input.LA(1);

                         
                        int index61_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_48);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA61_13 = input.LA(1);

                         
                        int index61_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_13);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA61_51 = input.LA(1);

                         
                        int index61_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_51);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA61_34 = input.LA(1);

                         
                        int index61_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_34);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA61_39 = input.LA(1);

                         
                        int index61_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_39);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA61_60 = input.LA(1);

                         
                        int index61_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_60);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA61_55 = input.LA(1);

                         
                        int index61_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_55);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA61_29 = input.LA(1);

                         
                        int index61_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_29);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA61_19 = input.LA(1);

                         
                        int index61_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_19);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA61_56 = input.LA(1);

                         
                        int index61_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_56);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA61_62 = input.LA(1);

                         
                        int index61_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_62);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA61_9 = input.LA(1);

                         
                        int index61_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_9);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA61_42 = input.LA(1);

                         
                        int index61_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_42);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA61_47 = input.LA(1);

                         
                        int index61_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_47);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA61_52 = input.LA(1);

                         
                        int index61_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_52);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA61_6 = input.LA(1);

                         
                        int index61_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_6);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA61_11 = input.LA(1);

                         
                        int index61_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_11);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA61_16 = input.LA(1);

                         
                        int index61_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_16);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA61_50 = input.LA(1);

                         
                        int index61_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_50);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA61_37 = input.LA(1);

                         
                        int index61_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_37);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA61_32 = input.LA(1);

                         
                        int index61_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_32);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA61_22 = input.LA(1);

                         
                        int index61_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_22);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA61_27 = input.LA(1);

                         
                        int index61_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_27);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA61_49 = input.LA(1);

                         
                        int index61_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_49);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA61_17 = input.LA(1);

                         
                        int index61_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_17);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA61_44 = input.LA(1);

                         
                        int index61_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_44);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA61_59 = input.LA(1);

                         
                        int index61_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_59);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA61_24 = input.LA(1);

                         
                        int index61_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_24);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA61_57 = input.LA(1);

                         
                        int index61_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_57);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA61_14 = input.LA(1);

                         
                        int index61_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_14);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA61_38 = input.LA(1);

                         
                        int index61_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_38);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA61_21 = input.LA(1);

                         
                        int index61_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_21);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA61_30 = input.LA(1);

                         
                        int index61_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_30);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA61_61 = input.LA(1);

                         
                        int index61_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_61);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA61_35 = input.LA(1);

                         
                        int index61_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_35);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA61_3 = input.LA(1);

                         
                        int index61_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_3);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA61_8 = input.LA(1);

                         
                        int index61_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_8);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA61_41 = input.LA(1);

                         
                        int index61_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_41);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 61, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA62_eotS =
        "\101\uffff";
    static final String DFA62_eofS =
        "\1\1\100\uffff";
    static final String DFA62_minS =
        "\1\4\1\uffff\75\0\2\uffff";
    static final String DFA62_maxS =
        "\1\104\1\uffff\75\0\2\uffff";
    static final String DFA62_acceptS =
        "\1\uffff\1\3\75\uffff\1\1\1\2";
    static final String DFA62_specialS =
        "\2\uffff\1\15\1\72\1\3\1\53\1\65\1\16\1\45\1\2\1\27\1\66\1\21\1\70\1\36\1\14\1\64\1\17\1\60\1\5\1\34\1\63\1\10\1\35\1\71\1\30\1\40\1\12\1\20\1\67\1\1\1\50\1\57\1\25\1\42\1\0\1\23\1\61\1\13\1\41\1\74\1\11\1\56\1\32\1\6\1\51\1\24\1\54\1\44\1\7\1\73\1\52\1\62\1\31\1\47\1\26\1\46\1\55\1\37\1\22\1\33\1\43\1\4\2\uffff}>";
    static final String[] DFA62_transitionS = {
            "\1\1\1\76\1\1\1\4\1\uffff\1\5\1\41\1\61\1\2\1\27\1\21\1\6\1\17\1\20\1\11\1\13\1\10\1\12\1\15\1\16\1\7\1\3\1\14\1\uffff\1\56\1\30\1\53\1\23\1\52\1\26\1\22\1\34\1\51\1\43\1\35\1\44\1\36\1\42\1\62\1\54\1\45\1\65\1\31\1\47\1\66\1\50\1\24\1\25\1\32\1\33\1\37\1\40\1\46\1\55\1\57\1\60\1\63\1\64\1\67\1\70\1\71\1\72\1\73\1\74\1\75",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA62_eot = DFA.unpackEncodedString(DFA62_eotS);
    static final short[] DFA62_eof = DFA.unpackEncodedString(DFA62_eofS);
    static final char[] DFA62_min = DFA.unpackEncodedStringToUnsignedChars(DFA62_minS);
    static final char[] DFA62_max = DFA.unpackEncodedStringToUnsignedChars(DFA62_maxS);
    static final short[] DFA62_accept = DFA.unpackEncodedString(DFA62_acceptS);
    static final short[] DFA62_special = DFA.unpackEncodedString(DFA62_specialS);
    static final short[][] DFA62_transition;

    static {
        int numStates = DFA62_transitionS.length;
        DFA62_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA62_transition[i] = DFA.unpackEncodedString(DFA62_transitionS[i]);
        }
    }

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = DFA62_eot;
            this.eof = DFA62_eof;
            this.min = DFA62_min;
            this.max = DFA62_max;
            this.accept = DFA62_accept;
            this.special = DFA62_special;
            this.transition = DFA62_transition;
        }
        public String getDescription() {
            return "()+ loopback of 3014:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA62_35 = input.LA(1);

                         
                        int index62_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_35);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA62_30 = input.LA(1);

                         
                        int index62_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_30);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA62_9 = input.LA(1);

                         
                        int index62_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_9);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA62_4 = input.LA(1);

                         
                        int index62_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA62_62 = input.LA(1);

                         
                        int index62_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred91_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_62);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA62_19 = input.LA(1);

                         
                        int index62_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_19);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA62_44 = input.LA(1);

                         
                        int index62_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_44);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA62_49 = input.LA(1);

                         
                        int index62_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_49);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA62_22 = input.LA(1);

                         
                        int index62_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_22);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA62_41 = input.LA(1);

                         
                        int index62_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_41);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA62_27 = input.LA(1);

                         
                        int index62_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_27);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA62_38 = input.LA(1);

                         
                        int index62_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_38);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA62_15 = input.LA(1);

                         
                        int index62_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_15);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA62_2 = input.LA(1);

                         
                        int index62_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_2);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA62_7 = input.LA(1);

                         
                        int index62_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_7);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA62_17 = input.LA(1);

                         
                        int index62_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_17);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA62_28 = input.LA(1);

                         
                        int index62_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_28);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA62_12 = input.LA(1);

                         
                        int index62_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_12);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA62_59 = input.LA(1);

                         
                        int index62_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_59);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA62_36 = input.LA(1);

                         
                        int index62_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_36);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA62_46 = input.LA(1);

                         
                        int index62_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_46);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA62_33 = input.LA(1);

                         
                        int index62_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_33);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA62_55 = input.LA(1);

                         
                        int index62_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_55);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA62_10 = input.LA(1);

                         
                        int index62_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_10);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA62_25 = input.LA(1);

                         
                        int index62_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA62_53 = input.LA(1);

                         
                        int index62_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_53);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA62_43 = input.LA(1);

                         
                        int index62_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_43);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA62_60 = input.LA(1);

                         
                        int index62_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_60);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA62_20 = input.LA(1);

                         
                        int index62_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_20);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA62_23 = input.LA(1);

                         
                        int index62_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_23);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA62_14 = input.LA(1);

                         
                        int index62_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_14);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA62_58 = input.LA(1);

                         
                        int index62_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_58);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA62_26 = input.LA(1);

                         
                        int index62_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_26);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA62_39 = input.LA(1);

                         
                        int index62_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_39);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA62_34 = input.LA(1);

                         
                        int index62_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_34);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA62_61 = input.LA(1);

                         
                        int index62_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_61);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA62_48 = input.LA(1);

                         
                        int index62_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_48);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA62_8 = input.LA(1);

                         
                        int index62_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_8);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA62_56 = input.LA(1);

                         
                        int index62_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_56);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA62_54 = input.LA(1);

                         
                        int index62_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_54);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA62_31 = input.LA(1);

                         
                        int index62_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_31);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA62_45 = input.LA(1);

                         
                        int index62_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_45);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA62_51 = input.LA(1);

                         
                        int index62_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_51);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA62_5 = input.LA(1);

                         
                        int index62_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_5);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA62_47 = input.LA(1);

                         
                        int index62_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_47);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA62_57 = input.LA(1);

                         
                        int index62_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_57);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA62_42 = input.LA(1);

                         
                        int index62_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_42);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA62_32 = input.LA(1);

                         
                        int index62_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_32);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA62_18 = input.LA(1);

                         
                        int index62_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_18);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA62_37 = input.LA(1);

                         
                        int index62_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_37);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA62_52 = input.LA(1);

                         
                        int index62_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_52);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA62_21 = input.LA(1);

                         
                        int index62_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_21);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA62_16 = input.LA(1);

                         
                        int index62_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_16);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA62_6 = input.LA(1);

                         
                        int index62_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_6);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA62_11 = input.LA(1);

                         
                        int index62_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_11);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA62_29 = input.LA(1);

                         
                        int index62_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_29);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA62_13 = input.LA(1);

                         
                        int index62_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_13);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA62_24 = input.LA(1);

                         
                        int index62_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_24);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA62_3 = input.LA(1);

                         
                        int index62_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_3);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA62_50 = input.LA(1);

                         
                        int index62_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_50);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA62_40 = input.LA(1);

                         
                        int index62_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index62_40);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 62, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA63_eotS =
        "\4\uffff";
    static final String DFA63_eofS =
        "\1\uffff\1\3\2\uffff";
    static final String DFA63_minS =
        "\1\5\1\4\2\uffff";
    static final String DFA63_maxS =
        "\2\104\2\uffff";
    static final String DFA63_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA63_specialS =
        "\4\uffff}>";
    static final String[] DFA63_transitionS = {
            "\1\1\1\uffff\1\2\1\uffff\22\2\1\uffff\51\2",
            "\1\3\1\1\1\uffff\1\2\1\uffff\22\2\1\uffff\51\2",
            "",
            ""
    };

    static final short[] DFA63_eot = DFA.unpackEncodedString(DFA63_eotS);
    static final short[] DFA63_eof = DFA.unpackEncodedString(DFA63_eofS);
    static final char[] DFA63_min = DFA.unpackEncodedStringToUnsignedChars(DFA63_minS);
    static final char[] DFA63_max = DFA.unpackEncodedStringToUnsignedChars(DFA63_maxS);
    static final short[] DFA63_accept = DFA.unpackEncodedString(DFA63_acceptS);
    static final short[] DFA63_special = DFA.unpackEncodedString(DFA63_specialS);
    static final short[][] DFA63_transition;

    static {
        int numStates = DFA63_transitionS.length;
        DFA63_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA63_transition[i] = DFA.unpackEncodedString(DFA63_transitionS[i]);
        }
    }

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = DFA63_eot;
            this.eof = DFA63_eof;
            this.min = DFA63_min;
            this.max = DFA63_max;
            this.accept = DFA63_accept;
            this.special = DFA63_special;
            this.transition = DFA63_transition;
        }
        public String getDescription() {
            return "3054:1: (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal )";
        }
    }
    static final String DFA66_eotS =
        "\77\uffff";
    static final String DFA66_eofS =
        "\1\75\76\uffff";
    static final String DFA66_minS =
        "\1\4\74\0\2\uffff";
    static final String DFA66_maxS =
        "\1\104\74\0\2\uffff";
    static final String DFA66_acceptS =
        "\75\uffff\1\2\1\1";
    static final String DFA66_specialS =
        "\1\uffff\1\57\1\32\1\6\1\46\1\22\1\62\1\50\1\4\1\65\1\23\1\13\1\73\1\3\1\47\1\55\1\27\1\11\1\52\1\5\1\31\1\56\1\16\1\36\1\63\1\34\1\42\1\14\1\24\1\66\1\67\1\25\1\15\1\43\1\35\1\64\1\37\1\17\1\60\1\33\1\7\1\53\1\12\1\44\1\71\1\26\1\40\1\10\1\21\1\72\1\2\1\30\1\1\1\61\1\0\1\41\1\51\1\54\1\20\1\70\1\45\2\uffff}>";
    static final String[] DFA66_transitionS = {
            "\3\75\1\3\1\uffff\1\4\1\40\1\60\1\1\1\26\1\20\1\5\1\16\1\17\1\10\1\12\1\7\1\11\1\14\1\15\1\6\1\2\1\13\1\uffff\1\55\1\27\1\52\1\22\1\51\1\25\1\21\1\33\1\50\1\42\1\34\1\43\1\35\1\41\1\61\1\53\1\44\1\64\1\30\1\46\1\65\1\47\1\23\1\24\1\31\1\32\1\36\1\37\1\45\1\54\1\56\1\57\1\62\1\63\1\66\1\67\1\70\1\71\1\72\1\73\1\74",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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

    static final short[] DFA66_eot = DFA.unpackEncodedString(DFA66_eotS);
    static final short[] DFA66_eof = DFA.unpackEncodedString(DFA66_eofS);
    static final char[] DFA66_min = DFA.unpackEncodedStringToUnsignedChars(DFA66_minS);
    static final char[] DFA66_max = DFA.unpackEncodedStringToUnsignedChars(DFA66_maxS);
    static final short[] DFA66_accept = DFA.unpackEncodedString(DFA66_acceptS);
    static final short[] DFA66_special = DFA.unpackEncodedString(DFA66_specialS);
    static final short[][] DFA66_transition;

    static {
        int numStates = DFA66_transitionS.length;
        DFA66_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA66_transition[i] = DFA.unpackEncodedString(DFA66_transitionS[i]);
        }
    }

    class DFA66 extends DFA {

        public DFA66(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 66;
            this.eot = DFA66_eot;
            this.eof = DFA66_eof;
            this.min = DFA66_min;
            this.max = DFA66_max;
            this.accept = DFA66_accept;
            this.special = DFA66_special;
            this.transition = DFA66_transition;
        }
        public String getDescription() {
            return "()+ loopback of 3133:3: (this_MyCode_1= ruleMyCode )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA66_54 = input.LA(1);

                         
                        int index66_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_54);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA66_52 = input.LA(1);

                         
                        int index66_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_52);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA66_50 = input.LA(1);

                         
                        int index66_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_50);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA66_13 = input.LA(1);

                         
                        int index66_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_13);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA66_8 = input.LA(1);

                         
                        int index66_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA66_19 = input.LA(1);

                         
                        int index66_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_19);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA66_3 = input.LA(1);

                         
                        int index66_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_3);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA66_40 = input.LA(1);

                         
                        int index66_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_40);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA66_47 = input.LA(1);

                         
                        int index66_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_47);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA66_17 = input.LA(1);

                         
                        int index66_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_17);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA66_42 = input.LA(1);

                         
                        int index66_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_42);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA66_11 = input.LA(1);

                         
                        int index66_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_11);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA66_27 = input.LA(1);

                         
                        int index66_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_27);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA66_32 = input.LA(1);

                         
                        int index66_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_32);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA66_22 = input.LA(1);

                         
                        int index66_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_22);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA66_37 = input.LA(1);

                         
                        int index66_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_37);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA66_58 = input.LA(1);

                         
                        int index66_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_58);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA66_48 = input.LA(1);

                         
                        int index66_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_48);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA66_5 = input.LA(1);

                         
                        int index66_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_5);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA66_10 = input.LA(1);

                         
                        int index66_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_10);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA66_28 = input.LA(1);

                         
                        int index66_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_28);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA66_31 = input.LA(1);

                         
                        int index66_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_31);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA66_45 = input.LA(1);

                         
                        int index66_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_45);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA66_16 = input.LA(1);

                         
                        int index66_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_16);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA66_51 = input.LA(1);

                         
                        int index66_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_51);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA66_20 = input.LA(1);

                         
                        int index66_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_20);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA66_2 = input.LA(1);

                         
                        int index66_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_2);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA66_39 = input.LA(1);

                         
                        int index66_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_39);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA66_25 = input.LA(1);

                         
                        int index66_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_25);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA66_34 = input.LA(1);

                         
                        int index66_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_34);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA66_23 = input.LA(1);

                         
                        int index66_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_23);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA66_36 = input.LA(1);

                         
                        int index66_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_36);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA66_46 = input.LA(1);

                         
                        int index66_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_46);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA66_55 = input.LA(1);

                         
                        int index66_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_55);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA66_26 = input.LA(1);

                         
                        int index66_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_26);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA66_33 = input.LA(1);

                         
                        int index66_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_33);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA66_43 = input.LA(1);

                         
                        int index66_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_43);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA66_60 = input.LA(1);

                         
                        int index66_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_60);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA66_4 = input.LA(1);

                         
                        int index66_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_4);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA66_14 = input.LA(1);

                         
                        int index66_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_14);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA66_7 = input.LA(1);

                         
                        int index66_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_7);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA66_56 = input.LA(1);

                         
                        int index66_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_56);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA66_18 = input.LA(1);

                         
                        int index66_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_18);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA66_41 = input.LA(1);

                         
                        int index66_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_41);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA66_57 = input.LA(1);

                         
                        int index66_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_57);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA66_15 = input.LA(1);

                         
                        int index66_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_15);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA66_21 = input.LA(1);

                         
                        int index66_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_21);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA66_1 = input.LA(1);

                         
                        int index66_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_1);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA66_38 = input.LA(1);

                         
                        int index66_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_38);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA66_53 = input.LA(1);

                         
                        int index66_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_53);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA66_6 = input.LA(1);

                         
                        int index66_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_6);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA66_24 = input.LA(1);

                         
                        int index66_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_24);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA66_35 = input.LA(1);

                         
                        int index66_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_35);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA66_9 = input.LA(1);

                         
                        int index66_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_9);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA66_29 = input.LA(1);

                         
                        int index66_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_29);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA66_30 = input.LA(1);

                         
                        int index66_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_30);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA66_59 = input.LA(1);

                         
                        int index66_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_59);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA66_44 = input.LA(1);

                         
                        int index66_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_44);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA66_49 = input.LA(1);

                         
                        int index66_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_49);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA66_12 = input.LA(1);

                         
                        int index66_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index66_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 66, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0xFFFFFFFFF7FFFEE2L,0x000000000000001FL});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0xFFFFFFFFF7FFFEF2L,0x000000000000001FL});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000013BC3A0L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0xFFFFFFFFF7FFFEE0L,0x000000000000001FL});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0010000000001820L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0xFFFFFFFFFFFFFEE2L,0x000000000000001FL});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000002022L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0010000000001020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0010000000001000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0xFFFFFFFFF7FFFEF0L,0x000000000000001FL});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000001E000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000E00000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0010000000000000L});

}