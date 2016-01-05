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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NEWLINE", "RULE_WHITESPACE", "RULE_HASH", "RULE_INCLUDE", "RULE_DEFINE", "RULE_SKW_LEFTPAREN", "RULE_SKW_RIGHTPAREN", "RULE_ID", "RULE_SKW_COMMA", "RULE_ERROR", "RULE_WARNING", "RULE_UNDEF", "RULE_ENDIF", "RULE_IF", "RULE_IFDEF", "RULE_IFNOTDEF", "RULE_ELIF", "RULE_ELSE", "RULE_PRAGMA", "RULE_SPECIAL", "RULE_DEFINED", "RULE_VA_ARGS", "RULE_SKW_QUESTION", "RULE_SKW_COLON", "RULE_SKW_OROR", "RULE_SKW_ANDAND", "RULE_SKW_OR", "RULE_SKW_CARET", "RULE_SKW_AND", "RULE_SKW_EQUAL", "RULE_SKW_NOTEQUAL", "RULE_SKW_LESS", "RULE_SKW_GREATER", "RULE_SKW_LESSEQUAL", "RULE_SKW_GREATEREQUAL", "RULE_SKW_LEFTSHIFT", "RULE_SKW_RIGHTSHIFT", "RULE_SKW_PLUS", "RULE_SKW_MINUS", "RULE_SKW_STAR", "RULE_SKW_DIV", "RULE_SKW_MOD", "RULE_SKW_TILDE", "RULE_SKW_NOT", "RULE_HEX_LITERAL", "RULE_OCTAL_LITERAL", "RULE_DECIMAL_LITERAL", "RULE_CHAR_LITERAL", "RULE_STRING_LITERAL", "RULE_FLOAT_LITERAL", "RULE_BIN_LITERAL", "RULE_SKW_ASSIGN", "RULE_SKW_BACKSLASH", "RULE_SKW_DOT", "RULE_SKW_DOUBLEQUOTE", "RULE_SKW_LEFTBRACE", "RULE_SKW_LEFTBRACKET", "RULE_SKW_MINUSMINUS", "RULE_SKW_PLUSPLUS", "RULE_SKW_RIGHTBRACE", "RULE_SKW_RIGHTBRACKET", "RULE_SKW_SEMI", "RULE_SKW_SINGLEQUOTE", "RULE_SKW_UNDERSCORE", "SUPER_NEWLINE", "RULE_SKW_DOLLAR", "RULE_IDENTIFIER", "RULE_LETTER", "RULE_ESCAPE_SEQUENCE", "RULE_HEX_DIGIT", "RULE_INTEGER_TYPE_SUFFIX", "RULE_EXPONENT", "RULE_FLOAT_TYPE_SUFFIX", "RULE_OCTAL_ESCAPE", "RULE_HEX_ESCAPE", "RULE_LINEFEED", "RULE_CARRIAGERETURN", "RULE_LINE_END", "RULE_LINEBREAK", "RULE_SPACE", "RULE_TAB", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT"
    };
    public static final int RULE_PRAGMA=22;
    public static final int RULE_ID=11;
    public static final int RULE_OCTAL_ESCAPE=77;
    public static final int RULE_SKW_NOT=47;
    public static final int RULE_ESCAPE_SEQUENCE=72;
    public static final int RULE_SKW_RIGHTSHIFT=40;
    public static final int RULE_SKW_DOT=57;
    public static final int RULE_DEFINED=24;
    public static final int RULE_SKW_NOTEQUAL=34;
    public static final int RULE_SKW_GREATEREQUAL=38;
    public static final int RULE_SKW_PLUS=41;
    public static final int RULE_SKW_RIGHTBRACE=63;
    public static final int EOF=-1;
    public static final int RULE_SKW_LESS=35;
    public static final int RULE_VA_ARGS=25;
    public static final int RULE_SKW_RIGHTPAREN=10;
    public static final int RULE_SKW_STAR=43;
    public static final int RULE_ENDIF=16;
    public static final int RULE_LINEBREAK=82;
    public static final int RULE_STRING_LITERAL=52;
    public static final int RULE_SKW_PLUSPLUS=62;
    public static final int RULE_SKW_DOUBLEQUOTE=58;
    public static final int RULE_SKW_LESSEQUAL=37;
    public static final int RULE_DECIMAL_LITERAL=50;
    public static final int RULE_HEX_LITERAL=48;
    public static final int RULE_SKW_OROR=28;
    public static final int RULE_WARNING=14;
    public static final int RULE_SKW_AND=32;
    public static final int RULE_SKW_CARET=31;
    public static final int RULE_WHITESPACE=5;
    public static final int RULE_OCTAL_LITERAL=49;
    public static final int RULE_SKW_COMMA=12;
    public static final int RULE_SKW_RIGHTBRACKET=64;
    public static final int RULE_SPACE=83;
    public static final int SUPER_NEWLINE=68;
    public static final int RULE_BLOCK_COMMENT=85;
    public static final int RULE_LINEFEED=79;
    public static final int RULE_SKW_COLON=27;
    public static final int RULE_BIN_LITERAL=54;
    public static final int RULE_SKW_LEFTPAREN=9;
    public static final int RULE_SKW_MINUS=42;
    public static final int RULE_SKW_SEMI=65;
    public static final int RULE_IFDEF=18;
    public static final int RULE_NEWLINE=4;
    public static final int RULE_SKW_DOLLAR=69;
    public static final int RULE_SKW_EQUAL=33;
    public static final int RULE_SKW_LEFTSHIFT=39;
    public static final int RULE_SKW_DIV=44;
    public static final int RULE_SKW_QUESTION=26;
    public static final int RULE_SKW_ANDAND=29;
    public static final int RULE_ERROR=13;
    public static final int RULE_HEX_DIGIT=73;
    public static final int RULE_SKW_GREATER=36;
    public static final int RULE_IDENTIFIER=70;
    public static final int RULE_HASH=6;
    public static final int RULE_TAB=84;
    public static final int RULE_HEX_ESCAPE=78;
    public static final int RULE_SKW_LEFTBRACKET=60;
    public static final int RULE_SKW_SINGLEQUOTE=66;
    public static final int RULE_SKW_MOD=45;
    public static final int RULE_UNDEF=15;
    public static final int RULE_LETTER=71;
    public static final int RULE_SKW_MINUSMINUS=61;
    public static final int RULE_FLOAT_TYPE_SUFFIX=76;
    public static final int RULE_IFNOTDEF=19;
    public static final int RULE_EXPONENT=75;
    public static final int RULE_INTEGER_TYPE_SUFFIX=74;
    public static final int RULE_DEFINE=8;
    public static final int RULE_SPECIAL=23;
    public static final int RULE_CARRIAGERETURN=80;
    public static final int RULE_SKW_TILDE=46;
    public static final int RULE_LINE_COMMENT=86;
    public static final int RULE_INCLUDE=7;
    public static final int RULE_SKW_UNDERSCORE=67;
    public static final int RULE_SKW_BACKSLASH=56;
    public static final int RULE_SKW_OR=30;
    public static final int RULE_CHAR_LITERAL=51;
    public static final int RULE_ELIF=20;
    public static final int RULE_LINE_END=81;
    public static final int RULE_IF=17;
    public static final int RULE_SKW_LEFTBRACE=59;
    public static final int RULE_FLOAT_LITERAL=53;
    public static final int RULE_ELSE=21;
    public static final int RULE_SKW_ASSIGN=55;

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
    // $ANTLR end "rulePreprocess"


    // $ANTLR start "entryRuleGroupOpt"
    // InternalPreprocess.g:134:1: entryRuleGroupOpt returns [EObject current=null] : iv_ruleGroupOpt= ruleGroupOpt EOF ;
    public final EObject entryRuleGroupOpt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOpt = null;


        try {
            // InternalPreprocess.g:135:2: (iv_ruleGroupOpt= ruleGroupOpt EOF )
            // InternalPreprocess.g:136:2: iv_ruleGroupOpt= ruleGroupOpt EOF
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
    // InternalPreprocess.g:143:1: ruleGroupOpt returns [EObject current=null] : ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ) ;
    public final EObject ruleGroupOpt() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_2=null;
        EObject lv_lines_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:149:7: ( ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ) )
            // InternalPreprocess.g:151:1: ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* )
            {
            // InternalPreprocess.g:151:1: ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* )
            // InternalPreprocess.g:152:1: () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )*
            {
            // InternalPreprocess.g:152:1: ()
            // InternalPreprocess.g:153:2: 
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

            // InternalPreprocess.g:164:1: ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )*
            loop1:
            do {
                int alt1=2;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // InternalPreprocess.g:165:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE
            	    {
            	    // InternalPreprocess.g:165:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) )
            	    // InternalPreprocess.g:166:1: (lv_lines_1_0= ruleGroupOptTemp1 )
            	    {
            	    // InternalPreprocess.g:166:1: (lv_lines_1_0= ruleGroupOptTemp1 )
            	    // InternalPreprocess.g:167:3: lv_lines_1_0= ruleGroupOptTemp1
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
    // InternalPreprocess.g:204:1: entryRuleGroupOpt2 returns [EObject current=null] : iv_ruleGroupOpt2= ruleGroupOpt2 EOF ;
    public final EObject entryRuleGroupOpt2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOpt2 = null;


        try {
            // InternalPreprocess.g:205:2: (iv_ruleGroupOpt2= ruleGroupOpt2 EOF )
            // InternalPreprocess.g:206:2: iv_ruleGroupOpt2= ruleGroupOpt2 EOF
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
    // InternalPreprocess.g:213:1: ruleGroupOpt2 returns [EObject current=null] : ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleGroupOptTemp2 ) )? ) ;
    public final EObject ruleGroupOpt2() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_2=null;
        EObject lv_lines_1_0 = null;

        EObject lv_lines_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:219:7: ( ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleGroupOptTemp2 ) )? ) )
            // InternalPreprocess.g:221:1: ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleGroupOptTemp2 ) )? )
            {
            // InternalPreprocess.g:221:1: ( () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleGroupOptTemp2 ) )? )
            // InternalPreprocess.g:222:1: () ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleGroupOptTemp2 ) )?
            {
            // InternalPreprocess.g:222:1: ()
            // InternalPreprocess.g:223:2: 
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

            // InternalPreprocess.g:234:1: ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // InternalPreprocess.g:235:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE
            	    {
            	    // InternalPreprocess.g:235:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) )
            	    // InternalPreprocess.g:236:1: (lv_lines_1_0= ruleGroupOptTemp1 )
            	    {
            	    // InternalPreprocess.g:236:1: (lv_lines_1_0= ruleGroupOptTemp1 )
            	    // InternalPreprocess.g:237:3: lv_lines_1_0= ruleGroupOptTemp1
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

            // InternalPreprocess.g:265:1: ( (lv_lines_3_0= ruleGroupOptTemp2 ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_WHITESPACE && LA3_0<=RULE_ERROR)||(LA3_0>=RULE_ENDIF && LA3_0<=RULE_DEFINED)||(LA3_0>=RULE_SKW_QUESTION && LA3_0<=RULE_SKW_SINGLEQUOTE)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalPreprocess.g:266:1: (lv_lines_3_0= ruleGroupOptTemp2 )
                    {
                    // InternalPreprocess.g:266:1: (lv_lines_3_0= ruleGroupOptTemp2 )
                    // InternalPreprocess.g:267:3: lv_lines_3_0= ruleGroupOptTemp2
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
    // InternalPreprocess.g:295:1: entryRuleGroupOptTemp1 returns [EObject current=null] : iv_ruleGroupOptTemp1= ruleGroupOptTemp1 EOF ;
    public final EObject entryRuleGroupOptTemp1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOptTemp1 = null;


        try {
            // InternalPreprocess.g:296:2: (iv_ruleGroupOptTemp1= ruleGroupOptTemp1 EOF )
            // InternalPreprocess.g:297:2: iv_ruleGroupOptTemp1= ruleGroupOptTemp1 EOF
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
    // InternalPreprocess.g:304:1: ruleGroupOptTemp1 returns [EObject current=null] : (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode ) ;
    public final EObject ruleGroupOptTemp1() throws RecognitionException {
        EObject current = null;

        EObject this_PreprocessorDirectives_0 = null;

        EObject this_NewLineLine_1 = null;

        EObject this_Code_2 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:310:7: ( (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode ) )
            // InternalPreprocess.g:312:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode )
            {
            // InternalPreprocess.g:312:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode )
            int alt4=3;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalPreprocess.g:314:2: this_PreprocessorDirectives_0= rulePreprocessorDirectives
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
                    // InternalPreprocess.g:330:2: this_NewLineLine_1= ruleNewLineLine
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
                    // InternalPreprocess.g:346:2: this_Code_2= ruleCode
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
    // InternalPreprocess.g:369:1: entryRuleGroupOptTemp2 returns [EObject current=null] : iv_ruleGroupOptTemp2= ruleGroupOptTemp2 EOF ;
    public final EObject entryRuleGroupOptTemp2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOptTemp2 = null;


        try {
            // InternalPreprocess.g:370:2: (iv_ruleGroupOptTemp2= ruleGroupOptTemp2 EOF )
            // InternalPreprocess.g:371:2: iv_ruleGroupOptTemp2= ruleGroupOptTemp2 EOF
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
    // InternalPreprocess.g:378:1: ruleGroupOptTemp2 returns [EObject current=null] : (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_Code_1= ruleCode ) ;
    public final EObject ruleGroupOptTemp2() throws RecognitionException {
        EObject current = null;

        EObject this_PreprocessorDirectives_0 = null;

        EObject this_Code_1 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:384:7: ( (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_Code_1= ruleCode ) )
            // InternalPreprocess.g:386:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_Code_1= ruleCode )
            {
            // InternalPreprocess.g:386:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_Code_1= ruleCode )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalPreprocess.g:388:2: this_PreprocessorDirectives_0= rulePreprocessorDirectives
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
                    // InternalPreprocess.g:404:2: this_Code_1= ruleCode
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
    // InternalPreprocess.g:427:1: entryRulePreprocessorDirectives returns [EObject current=null] : iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF ;
    public final EObject entryRulePreprocessorDirectives() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreprocessorDirectives = null;


        try {
            // InternalPreprocess.g:428:2: (iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF )
            // InternalPreprocess.g:429:2: iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF
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
    // InternalPreprocess.g:436:1: rulePreprocessorDirectives returns [EObject current=null] : ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) ) ) ;
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
            // InternalPreprocess.g:442:7: ( ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) ) ) )
            // InternalPreprocess.g:444:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) ) )
            {
            // InternalPreprocess.g:444:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) ) )
            // InternalPreprocess.g:445:1: () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) )
            {
            // InternalPreprocess.g:445:1: ()
            // InternalPreprocess.g:446:2: 
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

            // InternalPreprocess.g:457:1: (this_WHITESPACE_1= RULE_WHITESPACE )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_WHITESPACE) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalPreprocess.g:457:2: this_WHITESPACE_1= RULE_WHITESPACE
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
            // InternalPreprocess.g:471:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_WHITESPACE) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalPreprocess.g:471:2: this_WHITESPACE_3= RULE_WHITESPACE
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

            // InternalPreprocess.g:478:1: ( ( (lv_directive_4_0= ruleIncludeDirective ) ) | ( (lv_directive_5_0= ruleDefineDirective ) ) | ( (lv_directive_6_0= ruleErrorDirective ) ) | ( (lv_directive_7_0= ruleWarningDirective ) ) | ( (lv_directive_8_0= ruleUnDefineDirective ) ) | ( (lv_directive_9_0= ruleConditionalDirective ) ) | ( (lv_directive_10_0= rulePragmaDirective ) ) | ( (lv_directive_11_0= ruleNullDirective ) ) )
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
                    // InternalPreprocess.g:479:1: ( (lv_directive_4_0= ruleIncludeDirective ) )
                    {
                    // InternalPreprocess.g:479:1: ( (lv_directive_4_0= ruleIncludeDirective ) )
                    // InternalPreprocess.g:480:1: (lv_directive_4_0= ruleIncludeDirective )
                    {
                    // InternalPreprocess.g:480:1: (lv_directive_4_0= ruleIncludeDirective )
                    // InternalPreprocess.g:481:3: lv_directive_4_0= ruleIncludeDirective
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
                    // InternalPreprocess.g:501:1: ( (lv_directive_5_0= ruleDefineDirective ) )
                    {
                    // InternalPreprocess.g:501:1: ( (lv_directive_5_0= ruleDefineDirective ) )
                    // InternalPreprocess.g:502:1: (lv_directive_5_0= ruleDefineDirective )
                    {
                    // InternalPreprocess.g:502:1: (lv_directive_5_0= ruleDefineDirective )
                    // InternalPreprocess.g:503:3: lv_directive_5_0= ruleDefineDirective
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
                    // InternalPreprocess.g:523:1: ( (lv_directive_6_0= ruleErrorDirective ) )
                    {
                    // InternalPreprocess.g:523:1: ( (lv_directive_6_0= ruleErrorDirective ) )
                    // InternalPreprocess.g:524:1: (lv_directive_6_0= ruleErrorDirective )
                    {
                    // InternalPreprocess.g:524:1: (lv_directive_6_0= ruleErrorDirective )
                    // InternalPreprocess.g:525:3: lv_directive_6_0= ruleErrorDirective
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
                    // InternalPreprocess.g:545:1: ( (lv_directive_7_0= ruleWarningDirective ) )
                    {
                    // InternalPreprocess.g:545:1: ( (lv_directive_7_0= ruleWarningDirective ) )
                    // InternalPreprocess.g:546:1: (lv_directive_7_0= ruleWarningDirective )
                    {
                    // InternalPreprocess.g:546:1: (lv_directive_7_0= ruleWarningDirective )
                    // InternalPreprocess.g:547:3: lv_directive_7_0= ruleWarningDirective
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
                    // InternalPreprocess.g:567:1: ( (lv_directive_8_0= ruleUnDefineDirective ) )
                    {
                    // InternalPreprocess.g:567:1: ( (lv_directive_8_0= ruleUnDefineDirective ) )
                    // InternalPreprocess.g:568:1: (lv_directive_8_0= ruleUnDefineDirective )
                    {
                    // InternalPreprocess.g:568:1: (lv_directive_8_0= ruleUnDefineDirective )
                    // InternalPreprocess.g:569:3: lv_directive_8_0= ruleUnDefineDirective
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
                    // InternalPreprocess.g:589:1: ( (lv_directive_9_0= ruleConditionalDirective ) )
                    {
                    // InternalPreprocess.g:589:1: ( (lv_directive_9_0= ruleConditionalDirective ) )
                    // InternalPreprocess.g:590:1: (lv_directive_9_0= ruleConditionalDirective )
                    {
                    // InternalPreprocess.g:590:1: (lv_directive_9_0= ruleConditionalDirective )
                    // InternalPreprocess.g:591:3: lv_directive_9_0= ruleConditionalDirective
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
                    // InternalPreprocess.g:611:1: ( (lv_directive_10_0= rulePragmaDirective ) )
                    {
                    // InternalPreprocess.g:611:1: ( (lv_directive_10_0= rulePragmaDirective ) )
                    // InternalPreprocess.g:612:1: (lv_directive_10_0= rulePragmaDirective )
                    {
                    // InternalPreprocess.g:612:1: (lv_directive_10_0= rulePragmaDirective )
                    // InternalPreprocess.g:613:3: lv_directive_10_0= rulePragmaDirective
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
                    // InternalPreprocess.g:633:1: ( (lv_directive_11_0= ruleNullDirective ) )
                    {
                    // InternalPreprocess.g:633:1: ( (lv_directive_11_0= ruleNullDirective ) )
                    // InternalPreprocess.g:634:1: (lv_directive_11_0= ruleNullDirective )
                    {
                    // InternalPreprocess.g:634:1: (lv_directive_11_0= ruleNullDirective )
                    // InternalPreprocess.g:635:3: lv_directive_11_0= ruleNullDirective
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
    // InternalPreprocess.g:665:1: entryRuleIncludeDirective returns [EObject current=null] : iv_ruleIncludeDirective= ruleIncludeDirective EOF ;
    public final EObject entryRuleIncludeDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDirective = null;


        try {
            // InternalPreprocess.g:666:2: (iv_ruleIncludeDirective= ruleIncludeDirective EOF )
            // InternalPreprocess.g:667:2: iv_ruleIncludeDirective= ruleIncludeDirective EOF
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
    // InternalPreprocess.g:674:1: ruleIncludeDirective returns [EObject current=null] : ( () this_INCLUDE_1= RULE_INCLUDE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_string_3_0= ruleMyCodeLine ) ) ) ;
    public final EObject ruleIncludeDirective() throws RecognitionException {
        EObject current = null;

        Token this_INCLUDE_1=null;
        Token this_WHITESPACE_2=null;
        AntlrDatatypeRuleToken lv_string_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:680:7: ( ( () this_INCLUDE_1= RULE_INCLUDE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_string_3_0= ruleMyCodeLine ) ) ) )
            // InternalPreprocess.g:682:1: ( () this_INCLUDE_1= RULE_INCLUDE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_string_3_0= ruleMyCodeLine ) ) )
            {
            // InternalPreprocess.g:682:1: ( () this_INCLUDE_1= RULE_INCLUDE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_string_3_0= ruleMyCodeLine ) ) )
            // InternalPreprocess.g:683:1: () this_INCLUDE_1= RULE_INCLUDE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_string_3_0= ruleMyCodeLine ) )
            {
            // InternalPreprocess.g:683:1: ()
            // InternalPreprocess.g:684:2: 
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
            // InternalPreprocess.g:702:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
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
            	    // InternalPreprocess.g:702:2: this_WHITESPACE_2= RULE_WHITESPACE
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

            // InternalPreprocess.g:709:1: ( (lv_string_3_0= ruleMyCodeLine ) )
            // InternalPreprocess.g:710:1: (lv_string_3_0= ruleMyCodeLine )
            {
            // InternalPreprocess.g:710:1: (lv_string_3_0= ruleMyCodeLine )
            // InternalPreprocess.g:711:3: lv_string_3_0= ruleMyCodeLine
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
    // InternalPreprocess.g:739:1: entryRuleDefineDirective returns [EObject current=null] : iv_ruleDefineDirective= ruleDefineDirective EOF ;
    public final EObject entryRuleDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineDirective = null;


        try {
            // InternalPreprocess.g:740:2: (iv_ruleDefineDirective= ruleDefineDirective EOF )
            // InternalPreprocess.g:741:2: iv_ruleDefineDirective= ruleDefineDirective EOF
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
    // InternalPreprocess.g:748:1: ruleDefineDirective returns [EObject current=null] : (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro ) ;
    public final EObject ruleDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject this_DefineObjectMacro_0 = null;

        EObject this_DefineFunctionLikeMacro_1 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:754:7: ( (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro ) )
            // InternalPreprocess.g:756:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )
            {
            // InternalPreprocess.g:756:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // InternalPreprocess.g:758:2: this_DefineObjectMacro_0= ruleDefineObjectMacro
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
                    // InternalPreprocess.g:774:2: this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro
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
    // InternalPreprocess.g:797:1: entryRuleDefineObjectMacro returns [EObject current=null] : iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF ;
    public final EObject entryRuleDefineObjectMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineObjectMacro = null;


        try {
            // InternalPreprocess.g:798:2: (iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF )
            // InternalPreprocess.g:799:2: iv_ruleDefineObjectMacro= ruleDefineObjectMacro EOF
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
    // InternalPreprocess.g:806:1: ruleDefineObjectMacro returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? ) ;
    public final EObject ruleDefineObjectMacro() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_1=null;
        Token this_WHITESPACE_2=null;
        Token this_WHITESPACE_4=null;
        AntlrDatatypeRuleToken lv_id_3_0 = null;

        AntlrDatatypeRuleToken lv_string_5_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:812:7: ( ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? ) )
            // InternalPreprocess.g:814:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? )
            {
            // InternalPreprocess.g:814:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )? )
            // InternalPreprocess.g:815:1: () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )?
            {
            // InternalPreprocess.g:815:1: ()
            // InternalPreprocess.g:816:2: 
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
            // InternalPreprocess.g:834:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
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
            	    // InternalPreprocess.g:834:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
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

            // InternalPreprocess.g:841:1: ( (lv_id_3_0= ruleMyCode ) )
            // InternalPreprocess.g:842:1: (lv_id_3_0= ruleMyCode )
            {
            // InternalPreprocess.g:842:1: (lv_id_3_0= ruleMyCode )
            // InternalPreprocess.g:843:3: lv_id_3_0= ruleMyCode
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

            // InternalPreprocess.g:862:1: ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_WHITESPACE) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalPreprocess.g:863:1: (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine ) )
                    {
                    // InternalPreprocess.g:863:1: (this_WHITESPACE_4= RULE_WHITESPACE )+
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
                    	    // InternalPreprocess.g:863:2: this_WHITESPACE_4= RULE_WHITESPACE
                    	    {
                    	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_11); if (state.failed) return current;
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

                    // InternalPreprocess.g:870:1: ( (lv_string_5_0= ruleMyDefineLine ) )
                    // InternalPreprocess.g:871:1: (lv_string_5_0= ruleMyDefineLine )
                    {
                    // InternalPreprocess.g:871:1: (lv_string_5_0= ruleMyDefineLine )
                    // InternalPreprocess.g:872:3: lv_string_5_0= ruleMyDefineLine
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
    // InternalPreprocess.g:902:1: entryRuleDefineFunctionLikeMacro returns [EObject current=null] : iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF ;
    public final EObject entryRuleDefineFunctionLikeMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineFunctionLikeMacro = null;


        try {
            // InternalPreprocess.g:903:2: (iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF )
            // InternalPreprocess.g:904:2: iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF
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
    // InternalPreprocess.g:911:1: ruleDefineFunctionLikeMacro returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN ( (this_WHITESPACE_8= RULE_WHITESPACE )* ( (lv_string_9_0= ruleMyDefineLine ) ) )? ) ;
    public final EObject ruleDefineFunctionLikeMacro() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_1=null;
        Token this_WHITESPACE_2=null;
        Token this_SKW_LEFTPAREN_4=null;
        Token this_WHITESPACE_5=null;
        Token this_SKW_RIGHTPAREN_7=null;
        Token this_WHITESPACE_8=null;
        AntlrDatatypeRuleToken lv_id_3_0 = null;

        EObject lv_list_6_0 = null;

        AntlrDatatypeRuleToken lv_string_9_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:917:7: ( ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN ( (this_WHITESPACE_8= RULE_WHITESPACE )* ( (lv_string_9_0= ruleMyDefineLine ) ) )? ) )
            // InternalPreprocess.g:919:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN ( (this_WHITESPACE_8= RULE_WHITESPACE )* ( (lv_string_9_0= ruleMyDefineLine ) ) )? )
            {
            // InternalPreprocess.g:919:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN ( (this_WHITESPACE_8= RULE_WHITESPACE )* ( (lv_string_9_0= ruleMyDefineLine ) ) )? )
            // InternalPreprocess.g:920:1: () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN ( (this_WHITESPACE_8= RULE_WHITESPACE )* ( (lv_string_9_0= ruleMyDefineLine ) ) )?
            {
            // InternalPreprocess.g:920:1: ()
            // InternalPreprocess.g:921:2: 
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
            // InternalPreprocess.g:939:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
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
            	    // InternalPreprocess.g:939:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
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

            // InternalPreprocess.g:946:1: ( (lv_id_3_0= ruleMyCode ) )
            // InternalPreprocess.g:947:1: (lv_id_3_0= ruleMyCode )
            {
            // InternalPreprocess.g:947:1: (lv_id_3_0= ruleMyCode )
            // InternalPreprocess.g:948:3: lv_id_3_0= ruleMyCode
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDefineFunctionLikeMacroAccess().getIdMyCodeParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_12);
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

            this_SKW_LEFTPAREN_4=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SKW_LEFTPAREN_4, grammarAccess.getDefineFunctionLikeMacroAccess().getSKW_LEFTPARENTerminalRuleCall_4()); 
                  
            }
            // InternalPreprocess.g:974:1: (this_WHITESPACE_5= RULE_WHITESPACE )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_WHITESPACE) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalPreprocess.g:974:2: this_WHITESPACE_5= RULE_WHITESPACE
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

            // InternalPreprocess.g:981:1: ( (lv_list_6_0= ruleIdentifierList ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID||LA16_0==RULE_SKW_DOT) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalPreprocess.g:982:1: (lv_list_6_0= ruleIdentifierList )
                    {
                    // InternalPreprocess.g:982:1: (lv_list_6_0= ruleIdentifierList )
                    // InternalPreprocess.g:983:3: lv_list_6_0= ruleIdentifierList
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

            this_SKW_RIGHTPAREN_7=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SKW_RIGHTPAREN_7, grammarAccess.getDefineFunctionLikeMacroAccess().getSKW_RIGHTPARENTerminalRuleCall_7()); 
                  
            }
            // InternalPreprocess.g:1009:1: ( (this_WHITESPACE_8= RULE_WHITESPACE )* ( (lv_string_9_0= ruleMyDefineLine ) ) )?
            int alt18=2;
            switch ( input.LA(1) ) {
                case RULE_WHITESPACE:
                case RULE_HASH:
                case RULE_INCLUDE:
                case RULE_DEFINE:
                case RULE_SKW_LEFTPAREN:
                case RULE_SKW_RIGHTPAREN:
                case RULE_ID:
                case RULE_SKW_COMMA:
                case RULE_ERROR:
                case RULE_ENDIF:
                case RULE_IF:
                case RULE_IFDEF:
                case RULE_IFNOTDEF:
                case RULE_ELIF:
                case RULE_ELSE:
                case RULE_PRAGMA:
                case RULE_SPECIAL:
                case RULE_DEFINED:
                case RULE_VA_ARGS:
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
                    alt18=1;
                    }
                    break;
                case RULE_NEWLINE:
                    {
                    int LA18_2 = input.LA(2);

                    if ( (synpred25_InternalPreprocess()) ) {
                        alt18=1;
                    }
                    }
                    break;
                case EOF:
                    {
                    int LA18_3 = input.LA(2);

                    if ( (synpred25_InternalPreprocess()) ) {
                        alt18=1;
                    }
                    }
                    break;
            }

            switch (alt18) {
                case 1 :
                    // InternalPreprocess.g:1010:1: (this_WHITESPACE_8= RULE_WHITESPACE )* ( (lv_string_9_0= ruleMyDefineLine ) )
                    {
                    // InternalPreprocess.g:1010:1: (this_WHITESPACE_8= RULE_WHITESPACE )*
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
                    	    // InternalPreprocess.g:1010:2: this_WHITESPACE_8= RULE_WHITESPACE
                    	    {
                    	    this_WHITESPACE_8=(Token)match(input,RULE_WHITESPACE,FOLLOW_11); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_WHITESPACE_8, grammarAccess.getDefineFunctionLikeMacroAccess().getWHITESPACETerminalRuleCall_8_0()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    // InternalPreprocess.g:1017:1: ( (lv_string_9_0= ruleMyDefineLine ) )
                    // InternalPreprocess.g:1018:1: (lv_string_9_0= ruleMyDefineLine )
                    {
                    // InternalPreprocess.g:1018:1: (lv_string_9_0= ruleMyDefineLine )
                    // InternalPreprocess.g:1019:3: lv_string_9_0= ruleMyDefineLine
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefineFunctionLikeMacroAccess().getStringMyDefineLineParserRuleCall_8_1_0()); 
                      	    
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
    // $ANTLR end "ruleDefineFunctionLikeMacro"


    // $ANTLR start "entryRuleIdentifierList"
    // InternalPreprocess.g:1049:1: entryRuleIdentifierList returns [EObject current=null] : iv_ruleIdentifierList= ruleIdentifierList EOF ;
    public final EObject entryRuleIdentifierList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierList = null;


        try {
            // InternalPreprocess.g:1050:2: (iv_ruleIdentifierList= ruleIdentifierList EOF )
            // InternalPreprocess.g:1051:2: iv_ruleIdentifierList= ruleIdentifierList EOF
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
    // InternalPreprocess.g:1058:1: ruleIdentifierList returns [EObject current=null] : ( () ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) ) ) ;
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
            // InternalPreprocess.g:1064:7: ( ( () ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) ) ) )
            // InternalPreprocess.g:1066:1: ( () ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) ) )
            {
            // InternalPreprocess.g:1066:1: ( () ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) ) )
            // InternalPreprocess.g:1067:1: () ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) )
            {
            // InternalPreprocess.g:1067:1: ()
            // InternalPreprocess.g:1068:2: 
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

            // InternalPreprocess.g:1079:1: ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==RULE_SKW_DOT) ) {
                    alt27=2;
                }
                else if ( (LA27_1==EOF||LA27_1==RULE_WHITESPACE||LA27_1==RULE_SKW_RIGHTPAREN||LA27_1==RULE_SKW_COMMA) ) {
                    alt27=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA27_0==RULE_SKW_DOT) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalPreprocess.g:1080:1: ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? )
                    {
                    // InternalPreprocess.g:1080:1: ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? )
                    // InternalPreprocess.g:1081:1: ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )?
                    {
                    // InternalPreprocess.g:1081:1: ( (lv_id_1_0= RULE_ID ) )
                    // InternalPreprocess.g:1082:1: (lv_id_1_0= RULE_ID )
                    {
                    // InternalPreprocess.g:1082:1: (lv_id_1_0= RULE_ID )
                    // InternalPreprocess.g:1083:3: lv_id_1_0= RULE_ID
                    {
                    lv_id_1_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
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

                    // InternalPreprocess.g:1102:1: ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        alt21 = dfa21.predict(input);
                        switch (alt21) {
                    	case 1 :
                    	    // InternalPreprocess.g:1103:1: (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) )
                    	    {
                    	    // InternalPreprocess.g:1103:1: (this_WHITESPACE_2= RULE_WHITESPACE )*
                    	    loop19:
                    	    do {
                    	        int alt19=2;
                    	        int LA19_0 = input.LA(1);

                    	        if ( (LA19_0==RULE_WHITESPACE) ) {
                    	            alt19=1;
                    	        }


                    	        switch (alt19) {
                    	    	case 1 :
                    	    	    // InternalPreprocess.g:1103:2: this_WHITESPACE_2= RULE_WHITESPACE
                    	    	    {
                    	    	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_17); if (state.failed) return current;
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIdentifierListAccess().getWHITESPACETerminalRuleCall_1_0_1_0()); 
                    	    	          
                    	    	    }

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop19;
                    	        }
                    	    } while (true);

                    	    this_SKW_COMMA_3=(Token)match(input,RULE_SKW_COMMA,FOLLOW_18); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_SKW_COMMA_3, grammarAccess.getIdentifierListAccess().getSKW_COMMATerminalRuleCall_1_0_1_1()); 
                    	          
                    	    }
                    	    // InternalPreprocess.g:1117:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
                    	    loop20:
                    	    do {
                    	        int alt20=2;
                    	        int LA20_0 = input.LA(1);

                    	        if ( (LA20_0==RULE_WHITESPACE) ) {
                    	            alt20=1;
                    	        }


                    	        switch (alt20) {
                    	    	case 1 :
                    	    	    // InternalPreprocess.g:1117:2: this_WHITESPACE_4= RULE_WHITESPACE
                    	    	    {
                    	    	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_18); if (state.failed) return current;
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	          newLeafNode(this_WHITESPACE_4, grammarAccess.getIdentifierListAccess().getWHITESPACETerminalRuleCall_1_0_1_2()); 
                    	    	          
                    	    	    }

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop20;
                    	        }
                    	    } while (true);

                    	    // InternalPreprocess.g:1124:1: ( (lv_id_5_0= RULE_ID ) )
                    	    // InternalPreprocess.g:1125:1: (lv_id_5_0= RULE_ID )
                    	    {
                    	    // InternalPreprocess.g:1125:1: (lv_id_5_0= RULE_ID )
                    	    // InternalPreprocess.g:1126:3: lv_id_5_0= RULE_ID
                    	    {
                    	    lv_id_5_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
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
                    	    break loop21;
                        }
                    } while (true);

                    // InternalPreprocess.g:1147:1: (this_WHITESPACE_6= RULE_WHITESPACE )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==RULE_WHITESPACE) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalPreprocess.g:1147:2: this_WHITESPACE_6= RULE_WHITESPACE
                    	    {
                    	    this_WHITESPACE_6=(Token)match(input,RULE_WHITESPACE,FOLLOW_16); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_WHITESPACE_6, grammarAccess.getIdentifierListAccess().getWHITESPACETerminalRuleCall_1_0_2()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    // InternalPreprocess.g:1154:1: (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==RULE_SKW_COMMA) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // InternalPreprocess.g:1155:1: this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) )
                            {
                            this_SKW_COMMA_7=(Token)match(input,RULE_SKW_COMMA,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_SKW_COMMA_7, grammarAccess.getIdentifierListAccess().getSKW_COMMATerminalRuleCall_1_0_3_0()); 
                                  
                            }
                            // InternalPreprocess.g:1162:1: (this_WHITESPACE_8= RULE_WHITESPACE )*
                            loop23:
                            do {
                                int alt23=2;
                                int LA23_0 = input.LA(1);

                                if ( (LA23_0==RULE_WHITESPACE) ) {
                                    alt23=1;
                                }


                                switch (alt23) {
                            	case 1 :
                            	    // InternalPreprocess.g:1162:2: this_WHITESPACE_8= RULE_WHITESPACE
                            	    {
                            	    this_WHITESPACE_8=(Token)match(input,RULE_WHITESPACE,FOLLOW_19); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {
                            	       
                            	          newLeafNode(this_WHITESPACE_8, grammarAccess.getIdentifierListAccess().getWHITESPACETerminalRuleCall_1_0_3_1()); 
                            	          
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop23;
                                }
                            } while (true);

                            // InternalPreprocess.g:1169:1: ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) )
                            int alt24=2;
                            int LA24_0 = input.LA(1);

                            if ( (LA24_0==RULE_SKW_DOT) ) {
                                alt24=1;
                            }
                            else if ( (LA24_0==RULE_ID) ) {
                                alt24=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 24, 0, input);

                                throw nvae;
                            }
                            switch (alt24) {
                                case 1 :
                                    // InternalPreprocess.g:1170:1: ( (lv_variadic_9_0= ruleEllipsis ) )
                                    {
                                    // InternalPreprocess.g:1170:1: ( (lv_variadic_9_0= ruleEllipsis ) )
                                    // InternalPreprocess.g:1171:1: (lv_variadic_9_0= ruleEllipsis )
                                    {
                                    // InternalPreprocess.g:1171:1: (lv_variadic_9_0= ruleEllipsis )
                                    // InternalPreprocess.g:1172:3: lv_variadic_9_0= ruleEllipsis
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
                                    // InternalPreprocess.g:1192:1: ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) )
                                    {
                                    // InternalPreprocess.g:1192:1: ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) )
                                    // InternalPreprocess.g:1193:1: ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) )
                                    {
                                    // InternalPreprocess.g:1193:1: ( (lv_varID_10_0= RULE_ID ) )
                                    // InternalPreprocess.g:1194:1: (lv_varID_10_0= RULE_ID )
                                    {
                                    // InternalPreprocess.g:1194:1: (lv_varID_10_0= RULE_ID )
                                    // InternalPreprocess.g:1195:3: lv_varID_10_0= RULE_ID
                                    {
                                    lv_varID_10_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
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

                                    // InternalPreprocess.g:1214:1: ( (lv_variadic_11_0= ruleEllipsis ) )
                                    // InternalPreprocess.g:1215:1: (lv_variadic_11_0= ruleEllipsis )
                                    {
                                    // InternalPreprocess.g:1215:1: (lv_variadic_11_0= ruleEllipsis )
                                    // InternalPreprocess.g:1216:3: lv_variadic_11_0= ruleEllipsis
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
                    // InternalPreprocess.g:1244:1: ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) )
                    {
                    // InternalPreprocess.g:1244:1: ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) )
                    // InternalPreprocess.g:1245:1: ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) )
                    {
                    // InternalPreprocess.g:1245:1: ( (lv_varID_12_0= RULE_ID ) )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==RULE_ID) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalPreprocess.g:1246:1: (lv_varID_12_0= RULE_ID )
                            {
                            // InternalPreprocess.g:1246:1: (lv_varID_12_0= RULE_ID )
                            // InternalPreprocess.g:1247:3: lv_varID_12_0= RULE_ID
                            {
                            lv_varID_12_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
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

                    // InternalPreprocess.g:1266:1: ( (lv_variadic_13_0= ruleEllipsis ) )
                    // InternalPreprocess.g:1267:1: (lv_variadic_13_0= ruleEllipsis )
                    {
                    // InternalPreprocess.g:1267:1: (lv_variadic_13_0= ruleEllipsis )
                    // InternalPreprocess.g:1268:3: lv_variadic_13_0= ruleEllipsis
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
    // InternalPreprocess.g:1300:1: entryRuleErrorDirective returns [EObject current=null] : iv_ruleErrorDirective= ruleErrorDirective EOF ;
    public final EObject entryRuleErrorDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorDirective = null;


        try {
            // InternalPreprocess.g:1301:2: (iv_ruleErrorDirective= ruleErrorDirective EOF )
            // InternalPreprocess.g:1302:2: iv_ruleErrorDirective= ruleErrorDirective EOF
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
    // InternalPreprocess.g:1309:1: ruleErrorDirective returns [EObject current=null] : ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? ) ;
    public final EObject ruleErrorDirective() throws RecognitionException {
        EObject current = null;

        Token this_ERROR_1=null;
        Token this_WHITESPACE_2=null;
        AntlrDatatypeRuleToken lv_msg_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1315:7: ( ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? ) )
            // InternalPreprocess.g:1317:1: ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? )
            {
            // InternalPreprocess.g:1317:1: ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? )
            // InternalPreprocess.g:1318:1: () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )?
            {
            // InternalPreprocess.g:1318:1: ()
            // InternalPreprocess.g:1319:2: 
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
            // InternalPreprocess.g:1337:1: (this_WHITESPACE_2= RULE_WHITESPACE )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_WHITESPACE) ) {
                    int LA28_2 = input.LA(2);

                    if ( (synpred35_InternalPreprocess()) ) {
                        alt28=1;
                    }


                }


                switch (alt28) {
            	case 1 :
            	    // InternalPreprocess.g:1337:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getErrorDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            // InternalPreprocess.g:1344:1: ( (lv_msg_3_0= ruleMyCodeLine ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_WHITESPACE||(LA29_0>=RULE_INCLUDE && LA29_0<=RULE_ERROR)||(LA29_0>=RULE_ENDIF && LA29_0<=RULE_DEFINED)||(LA29_0>=RULE_SKW_QUESTION && LA29_0<=RULE_SKW_SINGLEQUOTE)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalPreprocess.g:1345:1: (lv_msg_3_0= ruleMyCodeLine )
                    {
                    // InternalPreprocess.g:1345:1: (lv_msg_3_0= ruleMyCodeLine )
                    // InternalPreprocess.g:1346:3: lv_msg_3_0= ruleMyCodeLine
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
    // InternalPreprocess.g:1374:1: entryRuleWarningDirective returns [EObject current=null] : iv_ruleWarningDirective= ruleWarningDirective EOF ;
    public final EObject entryRuleWarningDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWarningDirective = null;


        try {
            // InternalPreprocess.g:1375:2: (iv_ruleWarningDirective= ruleWarningDirective EOF )
            // InternalPreprocess.g:1376:2: iv_ruleWarningDirective= ruleWarningDirective EOF
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
    // InternalPreprocess.g:1383:1: ruleWarningDirective returns [EObject current=null] : ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? ) ;
    public final EObject ruleWarningDirective() throws RecognitionException {
        EObject current = null;

        Token this_WARNING_1=null;
        Token this_WHITESPACE_2=null;
        AntlrDatatypeRuleToken lv_msg_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1389:7: ( ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? ) )
            // InternalPreprocess.g:1391:1: ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? )
            {
            // InternalPreprocess.g:1391:1: ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? )
            // InternalPreprocess.g:1392:1: () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )?
            {
            // InternalPreprocess.g:1392:1: ()
            // InternalPreprocess.g:1393:2: 
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
            // InternalPreprocess.g:1411:1: (this_WHITESPACE_2= RULE_WHITESPACE )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_WHITESPACE) ) {
                    int LA30_2 = input.LA(2);

                    if ( (synpred37_InternalPreprocess()) ) {
                        alt30=1;
                    }


                }


                switch (alt30) {
            	case 1 :
            	    // InternalPreprocess.g:1411:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getWarningDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            // InternalPreprocess.g:1418:1: ( (lv_msg_3_0= ruleMyCodeLine ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_WHITESPACE||(LA31_0>=RULE_INCLUDE && LA31_0<=RULE_ERROR)||(LA31_0>=RULE_ENDIF && LA31_0<=RULE_DEFINED)||(LA31_0>=RULE_SKW_QUESTION && LA31_0<=RULE_SKW_SINGLEQUOTE)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalPreprocess.g:1419:1: (lv_msg_3_0= ruleMyCodeLine )
                    {
                    // InternalPreprocess.g:1419:1: (lv_msg_3_0= ruleMyCodeLine )
                    // InternalPreprocess.g:1420:3: lv_msg_3_0= ruleMyCodeLine
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
    // InternalPreprocess.g:1448:1: entryRuleUnDefineDirective returns [EObject current=null] : iv_ruleUnDefineDirective= ruleUnDefineDirective EOF ;
    public final EObject entryRuleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnDefineDirective = null;


        try {
            // InternalPreprocess.g:1449:2: (iv_ruleUnDefineDirective= ruleUnDefineDirective EOF )
            // InternalPreprocess.g:1450:2: iv_ruleUnDefineDirective= ruleUnDefineDirective EOF
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
    // InternalPreprocess.g:1457:1: ruleUnDefineDirective returns [EObject current=null] : ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* ) ;
    public final EObject ruleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        Token this_UNDEF_1=null;
        Token this_WHITESPACE_2=null;
        Token lv_id_3_0=null;
        Token this_WHITESPACE_4=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1463:7: ( ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* ) )
            // InternalPreprocess.g:1465:1: ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* )
            {
            // InternalPreprocess.g:1465:1: ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* )
            // InternalPreprocess.g:1466:1: () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )*
            {
            // InternalPreprocess.g:1466:1: ()
            // InternalPreprocess.g:1467:2: 
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
            // InternalPreprocess.g:1485:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_WHITESPACE) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalPreprocess.g:1485:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getUnDefineDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);

            // InternalPreprocess.g:1492:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:1493:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:1493:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:1494:3: lv_id_3_0= RULE_ID
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

            // InternalPreprocess.g:1513:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_WHITESPACE) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalPreprocess.g:1513:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getUnDefineDirectiveAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
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
    // InternalPreprocess.g:1529:1: entryRuleConditionalDirective returns [EObject current=null] : iv_ruleConditionalDirective= ruleConditionalDirective EOF ;
    public final EObject entryRuleConditionalDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalDirective = null;


        try {
            // InternalPreprocess.g:1530:2: (iv_ruleConditionalDirective= ruleConditionalDirective EOF )
            // InternalPreprocess.g:1531:2: iv_ruleConditionalDirective= ruleConditionalDirective EOF
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
    // InternalPreprocess.g:1538:1: ruleConditionalDirective returns [EObject current=null] : ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* ) ;
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
            // InternalPreprocess.g:1544:7: ( ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* ) )
            // InternalPreprocess.g:1546:1: ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* )
            {
            // InternalPreprocess.g:1546:1: ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* )
            // InternalPreprocess.g:1547:1: () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )*
            {
            // InternalPreprocess.g:1547:1: ()
            // InternalPreprocess.g:1548:2: 
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

            // InternalPreprocess.g:1559:1: ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) )
            // InternalPreprocess.g:1560:1: ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) )
            {
            // InternalPreprocess.g:1560:1: ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) )
            // InternalPreprocess.g:1561:1: (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional )
            {
            // InternalPreprocess.g:1561:1: (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional )
            int alt34=3;
            switch ( input.LA(1) ) {
            case RULE_IF:
                {
                alt34=1;
                }
                break;
            case RULE_IFDEF:
                {
                alt34=2;
                }
                break;
            case RULE_IFNOTDEF:
                {
                alt34=3;
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
                    // InternalPreprocess.g:1562:3: lv_conditional_1_1= ruleIfConditional
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
                    // InternalPreprocess.g:1577:8: lv_conditional_1_2= ruleIfDefConditional
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
                    // InternalPreprocess.g:1592:8: lv_conditional_1_3= ruleIfNotDefConditional
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

            // InternalPreprocess.g:1613:1: ( (lv_elifs_2_0= ruleElIfConditional ) )*
            loop35:
            do {
                int alt35=2;
                alt35 = dfa35.predict(input);
                switch (alt35) {
            	case 1 :
            	    // InternalPreprocess.g:1614:1: (lv_elifs_2_0= ruleElIfConditional )
            	    {
            	    // InternalPreprocess.g:1614:1: (lv_elifs_2_0= ruleElIfConditional )
            	    // InternalPreprocess.g:1615:3: lv_elifs_2_0= ruleElIfConditional
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
            	    break loop35;
                }
            } while (true);

            // InternalPreprocess.g:1634:1: ( (lv_else_3_0= ruleElseConditional ) )?
            int alt36=2;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // InternalPreprocess.g:1635:1: (lv_else_3_0= ruleElseConditional )
                    {
                    // InternalPreprocess.g:1635:1: (lv_else_3_0= ruleElseConditional )
                    // InternalPreprocess.g:1636:3: lv_else_3_0= ruleElseConditional
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

            // InternalPreprocess.g:1655:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_WHITESPACE) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalPreprocess.g:1655:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getConditionalDirectiveAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            this_HASH_5=(Token)match(input,RULE_HASH,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_5, grammarAccess.getConditionalDirectiveAccess().getHASHTerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:1669:1: (this_WHITESPACE_6= RULE_WHITESPACE )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_WHITESPACE) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalPreprocess.g:1669:2: this_WHITESPACE_6= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_6=(Token)match(input,RULE_WHITESPACE,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_6, grammarAccess.getConditionalDirectiveAccess().getWHITESPACETerminalRuleCall_6()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            this_ENDIF_7=(Token)match(input,RULE_ENDIF,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ENDIF_7, grammarAccess.getConditionalDirectiveAccess().getENDIFTerminalRuleCall_7()); 
                  
            }
            // InternalPreprocess.g:1683:1: (this_WHITESPACE_8= RULE_WHITESPACE )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_WHITESPACE) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalPreprocess.g:1683:2: this_WHITESPACE_8= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_8=(Token)match(input,RULE_WHITESPACE,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_8, grammarAccess.getConditionalDirectiveAccess().getWHITESPACETerminalRuleCall_8()); 
            	          
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
    // InternalPreprocess.g:1699:1: entryRuleIfConditional returns [EObject current=null] : iv_ruleIfConditional= ruleIfConditional EOF ;
    public final EObject entryRuleIfConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfConditional = null;


        try {
            // InternalPreprocess.g:1700:2: (iv_ruleIfConditional= ruleIfConditional EOF )
            // InternalPreprocess.g:1701:2: iv_ruleIfConditional= ruleIfConditional EOF
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
    // InternalPreprocess.g:1708:1: ruleIfConditional returns [EObject current=null] : ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) ;
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
            // InternalPreprocess.g:1714:7: ( ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:1716:1: ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:1716:1: ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:1717:1: () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:1717:1: ()
            // InternalPreprocess.g:1718:2: 
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
            // InternalPreprocess.g:1736:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt40=0;
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_WHITESPACE) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalPreprocess.g:1736:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIfConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt40 >= 1 ) break loop40;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(40, input);
                        throw eee;
                }
                cnt40++;
            } while (true);

            // InternalPreprocess.g:1743:1: ( (lv_expression_3_0= ruleConstantExpression ) )
            // InternalPreprocess.g:1744:1: (lv_expression_3_0= ruleConstantExpression )
            {
            // InternalPreprocess.g:1744:1: (lv_expression_3_0= ruleConstantExpression )
            // InternalPreprocess.g:1745:3: lv_expression_3_0= ruleConstantExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfConditionalAccess().getExpressionConstantExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_22);
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

            // InternalPreprocess.g:1764:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_WHITESPACE) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalPreprocess.g:1764:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getIfConditionalAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_5, grammarAccess.getIfConditionalAccess().getNEWLINETerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:1778:1: ( (lv_group_6_0= ruleGroupOpt ) )
            // InternalPreprocess.g:1779:1: (lv_group_6_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:1779:1: (lv_group_6_0= ruleGroupOpt )
            // InternalPreprocess.g:1780:3: lv_group_6_0= ruleGroupOpt
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
    // InternalPreprocess.g:1808:1: entryRuleIfDefConditional returns [EObject current=null] : iv_ruleIfDefConditional= ruleIfDefConditional EOF ;
    public final EObject entryRuleIfDefConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfDefConditional = null;


        try {
            // InternalPreprocess.g:1809:2: (iv_ruleIfDefConditional= ruleIfDefConditional EOF )
            // InternalPreprocess.g:1810:2: iv_ruleIfDefConditional= ruleIfDefConditional EOF
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
    // InternalPreprocess.g:1817:1: ruleIfDefConditional returns [EObject current=null] : ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) ;
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
            // InternalPreprocess.g:1823:7: ( ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:1825:1: ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:1825:1: ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:1826:1: () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:1826:1: ()
            // InternalPreprocess.g:1827:2: 
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
            // InternalPreprocess.g:1845:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt42=0;
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_WHITESPACE) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalPreprocess.g:1845:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIfDefConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt42 >= 1 ) break loop42;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(42, input);
                        throw eee;
                }
                cnt42++;
            } while (true);

            // InternalPreprocess.g:1852:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:1853:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:1853:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:1854:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
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

            // InternalPreprocess.g:1873:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_WHITESPACE) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalPreprocess.g:1873:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getIfDefConditionalAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_5, grammarAccess.getIfDefConditionalAccess().getNEWLINETerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:1887:1: ( (lv_group_6_0= ruleGroupOpt ) )
            // InternalPreprocess.g:1888:1: (lv_group_6_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:1888:1: (lv_group_6_0= ruleGroupOpt )
            // InternalPreprocess.g:1889:3: lv_group_6_0= ruleGroupOpt
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
    // InternalPreprocess.g:1917:1: entryRuleIfNotDefConditional returns [EObject current=null] : iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF ;
    public final EObject entryRuleIfNotDefConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfNotDefConditional = null;


        try {
            // InternalPreprocess.g:1918:2: (iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF )
            // InternalPreprocess.g:1919:2: iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF
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
    // InternalPreprocess.g:1926:1: ruleIfNotDefConditional returns [EObject current=null] : ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) ;
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
            // InternalPreprocess.g:1932:7: ( ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:1934:1: ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:1934:1: ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:1935:1: () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:1935:1: ()
            // InternalPreprocess.g:1936:2: 
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
            // InternalPreprocess.g:1954:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
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
            	    // InternalPreprocess.g:1954:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIfNotDefConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:1961:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:1962:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:1962:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:1963:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
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

            // InternalPreprocess.g:1982:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_WHITESPACE) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalPreprocess.g:1982:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getIfNotDefConditionalAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_5, grammarAccess.getIfNotDefConditionalAccess().getNEWLINETerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:1996:1: ( (lv_group_6_0= ruleGroupOpt ) )
            // InternalPreprocess.g:1997:1: (lv_group_6_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:1997:1: (lv_group_6_0= ruleGroupOpt )
            // InternalPreprocess.g:1998:3: lv_group_6_0= ruleGroupOpt
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
    // InternalPreprocess.g:2026:1: entryRuleElIfConditional returns [EObject current=null] : iv_ruleElIfConditional= ruleElIfConditional EOF ;
    public final EObject entryRuleElIfConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElIfConditional = null;


        try {
            // InternalPreprocess.g:2027:2: (iv_ruleElIfConditional= ruleElIfConditional EOF )
            // InternalPreprocess.g:2028:2: iv_ruleElIfConditional= ruleElIfConditional EOF
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
    // InternalPreprocess.g:2035:1: ruleElIfConditional returns [EObject current=null] : ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) (this_WHITESPACE_7= RULE_WHITESPACE )* this_NEWLINE_8= RULE_NEWLINE ( (lv_group_9_0= ruleGroupOpt ) ) ) ;
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
            // InternalPreprocess.g:2041:7: ( ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) (this_WHITESPACE_7= RULE_WHITESPACE )* this_NEWLINE_8= RULE_NEWLINE ( (lv_group_9_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:2043:1: ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) (this_WHITESPACE_7= RULE_WHITESPACE )* this_NEWLINE_8= RULE_NEWLINE ( (lv_group_9_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:2043:1: ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) (this_WHITESPACE_7= RULE_WHITESPACE )* this_NEWLINE_8= RULE_NEWLINE ( (lv_group_9_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:2044:1: () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) (this_WHITESPACE_7= RULE_WHITESPACE )* this_NEWLINE_8= RULE_NEWLINE ( (lv_group_9_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:2044:1: ()
            // InternalPreprocess.g:2045:2: 
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

            // InternalPreprocess.g:2056:1: ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF )
            // InternalPreprocess.g:2057:1: (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF
            {
            // InternalPreprocess.g:2057:1: (this_WHITESPACE_1= RULE_WHITESPACE )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_WHITESPACE) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalPreprocess.g:2057:2: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_1_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_2, grammarAccess.getElIfConditionalAccess().getHASHTerminalRuleCall_1_1()); 
                  
            }
            // InternalPreprocess.g:2071:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_WHITESPACE) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalPreprocess.g:2071:2: this_WHITESPACE_3= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_3, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_1_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            this_ELIF_4=(Token)match(input,RULE_ELIF,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ELIF_4, grammarAccess.getElIfConditionalAccess().getELIFTerminalRuleCall_1_3()); 
                  
            }

            }

            // InternalPreprocess.g:2087:1: (this_WHITESPACE_5= RULE_WHITESPACE )+
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
            	    // InternalPreprocess.g:2087:2: this_WHITESPACE_5= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_5=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_5, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:2094:1: ( (lv_expression_6_0= ruleConstantExpression ) )
            // InternalPreprocess.g:2095:1: (lv_expression_6_0= ruleConstantExpression )
            {
            // InternalPreprocess.g:2095:1: (lv_expression_6_0= ruleConstantExpression )
            // InternalPreprocess.g:2096:3: lv_expression_6_0= ruleConstantExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElIfConditionalAccess().getExpressionConstantExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_22);
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

            // InternalPreprocess.g:2115:1: (this_WHITESPACE_7= RULE_WHITESPACE )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_WHITESPACE) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalPreprocess.g:2115:2: this_WHITESPACE_7= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_7=(Token)match(input,RULE_WHITESPACE,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_7, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            this_NEWLINE_8=(Token)match(input,RULE_NEWLINE,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_8, grammarAccess.getElIfConditionalAccess().getNEWLINETerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:2129:1: ( (lv_group_9_0= ruleGroupOpt ) )
            // InternalPreprocess.g:2130:1: (lv_group_9_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:2130:1: (lv_group_9_0= ruleGroupOpt )
            // InternalPreprocess.g:2131:3: lv_group_9_0= ruleGroupOpt
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
    // InternalPreprocess.g:2159:1: entryRuleElseConditional returns [EObject current=null] : iv_ruleElseConditional= ruleElseConditional EOF ;
    public final EObject entryRuleElseConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseConditional = null;


        try {
            // InternalPreprocess.g:2160:2: (iv_ruleElseConditional= ruleElseConditional EOF )
            // InternalPreprocess.g:2161:2: iv_ruleElseConditional= ruleElseConditional EOF
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
    // InternalPreprocess.g:2168:1: ruleElseConditional returns [EObject current=null] : ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE (this_WHITESPACE_5= RULE_WHITESPACE )* this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) ) ) ;
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
            // InternalPreprocess.g:2174:7: ( ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE (this_WHITESPACE_5= RULE_WHITESPACE )* this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:2176:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE (this_WHITESPACE_5= RULE_WHITESPACE )* this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:2176:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE (this_WHITESPACE_5= RULE_WHITESPACE )* this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:2177:1: () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE (this_WHITESPACE_5= RULE_WHITESPACE )* this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:2177:1: ()
            // InternalPreprocess.g:2178:2: 
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

            // InternalPreprocess.g:2189:1: (this_WHITESPACE_1= RULE_WHITESPACE )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_WHITESPACE) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalPreprocess.g:2189:2: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getElseConditionalAccess().getWHITESPACETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_2, grammarAccess.getElseConditionalAccess().getHASHTerminalRuleCall_2()); 
                  
            }
            // InternalPreprocess.g:2203:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_WHITESPACE) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalPreprocess.g:2203:2: this_WHITESPACE_3= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_25); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_3, grammarAccess.getElseConditionalAccess().getWHITESPACETerminalRuleCall_3()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            this_ELSE_4=(Token)match(input,RULE_ELSE,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ELSE_4, grammarAccess.getElseConditionalAccess().getELSETerminalRuleCall_4()); 
                  
            }
            // InternalPreprocess.g:2217:1: (this_WHITESPACE_5= RULE_WHITESPACE )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_WHITESPACE) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalPreprocess.g:2217:2: this_WHITESPACE_5= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_5=(Token)match(input,RULE_WHITESPACE,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_5, grammarAccess.getElseConditionalAccess().getWHITESPACETerminalRuleCall_5()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            this_NEWLINE_6=(Token)match(input,RULE_NEWLINE,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_6, grammarAccess.getElseConditionalAccess().getNEWLINETerminalRuleCall_6()); 
                  
            }
            // InternalPreprocess.g:2231:1: ( (lv_group_7_0= ruleGroupOpt ) )
            // InternalPreprocess.g:2232:1: (lv_group_7_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:2232:1: (lv_group_7_0= ruleGroupOpt )
            // InternalPreprocess.g:2233:3: lv_group_7_0= ruleGroupOpt
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
    // InternalPreprocess.g:2261:1: entryRulePragmaDirective returns [EObject current=null] : iv_rulePragmaDirective= rulePragmaDirective EOF ;
    public final EObject entryRulePragmaDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePragmaDirective = null;


        try {
            // InternalPreprocess.g:2262:2: (iv_rulePragmaDirective= rulePragmaDirective EOF )
            // InternalPreprocess.g:2263:2: iv_rulePragmaDirective= rulePragmaDirective EOF
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
    // InternalPreprocess.g:2270:1: rulePragmaDirective returns [EObject current=null] : ( () this_PRAGMA_1= RULE_PRAGMA (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_pragma_3_0= ruleMyCodeLine ) )? ) ;
    public final EObject rulePragmaDirective() throws RecognitionException {
        EObject current = null;

        Token this_PRAGMA_1=null;
        Token this_WHITESPACE_2=null;
        AntlrDatatypeRuleToken lv_pragma_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2276:7: ( ( () this_PRAGMA_1= RULE_PRAGMA (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_pragma_3_0= ruleMyCodeLine ) )? ) )
            // InternalPreprocess.g:2278:1: ( () this_PRAGMA_1= RULE_PRAGMA (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_pragma_3_0= ruleMyCodeLine ) )? )
            {
            // InternalPreprocess.g:2278:1: ( () this_PRAGMA_1= RULE_PRAGMA (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_pragma_3_0= ruleMyCodeLine ) )? )
            // InternalPreprocess.g:2279:1: () this_PRAGMA_1= RULE_PRAGMA (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_pragma_3_0= ruleMyCodeLine ) )?
            {
            // InternalPreprocess.g:2279:1: ()
            // InternalPreprocess.g:2280:2: 
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
            // InternalPreprocess.g:2298:1: (this_WHITESPACE_2= RULE_WHITESPACE )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_WHITESPACE) ) {
                    int LA53_2 = input.LA(2);

                    if ( (synpred61_InternalPreprocess()) ) {
                        alt53=1;
                    }


                }


                switch (alt53) {
            	case 1 :
            	    // InternalPreprocess.g:2298:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getPragmaDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            // InternalPreprocess.g:2305:1: ( (lv_pragma_3_0= ruleMyCodeLine ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_WHITESPACE||(LA54_0>=RULE_INCLUDE && LA54_0<=RULE_ERROR)||(LA54_0>=RULE_ENDIF && LA54_0<=RULE_DEFINED)||(LA54_0>=RULE_SKW_QUESTION && LA54_0<=RULE_SKW_SINGLEQUOTE)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalPreprocess.g:2306:1: (lv_pragma_3_0= ruleMyCodeLine )
                    {
                    // InternalPreprocess.g:2306:1: (lv_pragma_3_0= ruleMyCodeLine )
                    // InternalPreprocess.g:2307:3: lv_pragma_3_0= ruleMyCodeLine
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
    // InternalPreprocess.g:2335:1: entryRuleNullDirective returns [EObject current=null] : iv_ruleNullDirective= ruleNullDirective EOF ;
    public final EObject entryRuleNullDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullDirective = null;


        try {
            // InternalPreprocess.g:2336:2: (iv_ruleNullDirective= ruleNullDirective EOF )
            // InternalPreprocess.g:2337:2: iv_ruleNullDirective= ruleNullDirective EOF
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
    // InternalPreprocess.g:2344:1: ruleNullDirective returns [EObject current=null] : () ;
    public final EObject ruleNullDirective() throws RecognitionException {
        EObject current = null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2350:7: ( () )
            // InternalPreprocess.g:2352:1: ()
            {
            // InternalPreprocess.g:2352:1: ()
            // InternalPreprocess.g:2353:2: 
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
    // InternalPreprocess.g:2371:1: entryRuleNewLineLine returns [EObject current=null] : iv_ruleNewLineLine= ruleNewLineLine EOF ;
    public final EObject entryRuleNewLineLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewLineLine = null;


        try {
            // InternalPreprocess.g:2372:2: (iv_ruleNewLineLine= ruleNewLineLine EOF )
            // InternalPreprocess.g:2373:2: iv_ruleNewLineLine= ruleNewLineLine EOF
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
    // InternalPreprocess.g:2380:1: ruleNewLineLine returns [EObject current=null] : () ;
    public final EObject ruleNewLineLine() throws RecognitionException {
        EObject current = null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2386:7: ( () )
            // InternalPreprocess.g:2388:1: ()
            {
            // InternalPreprocess.g:2388:1: ()
            // InternalPreprocess.g:2389:2: 
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
    // InternalPreprocess.g:2407:1: entryRuleCode returns [EObject current=null] : iv_ruleCode= ruleCode EOF ;
    public final EObject entryRuleCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCode = null;


        try {
            // InternalPreprocess.g:2408:2: (iv_ruleCode= ruleCode EOF )
            // InternalPreprocess.g:2409:2: iv_ruleCode= ruleCode EOF
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
    // InternalPreprocess.g:2416:1: ruleCode returns [EObject current=null] : ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) ) ;
    public final EObject ruleCode() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_code_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2422:7: ( ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) ) )
            // InternalPreprocess.g:2424:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) )
            {
            // InternalPreprocess.g:2424:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) )
            // InternalPreprocess.g:2425:1: () ( (lv_code_1_0= ruleMyCodeLineExtended ) )
            {
            // InternalPreprocess.g:2425:1: ()
            // InternalPreprocess.g:2426:2: 
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

            // InternalPreprocess.g:2437:1: ( (lv_code_1_0= ruleMyCodeLineExtended ) )
            // InternalPreprocess.g:2438:1: (lv_code_1_0= ruleMyCodeLineExtended )
            {
            // InternalPreprocess.g:2438:1: (lv_code_1_0= ruleMyCodeLineExtended )
            // InternalPreprocess.g:2439:3: lv_code_1_0= ruleMyCodeLineExtended
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
    // InternalPreprocess.g:2467:1: entryRuleMyCode returns [String current=null] : iv_ruleMyCode= ruleMyCode EOF ;
    public final String entryRuleMyCode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCode = null;


        try {
            // InternalPreprocess.g:2468:2: (iv_ruleMyCode= ruleMyCode EOF )
            // InternalPreprocess.g:2469:2: iv_ruleMyCode= ruleMyCode EOF
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
    // InternalPreprocess.g:2476:1: ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_ELIF_11= RULE_ELIF | this_ELSE_12= RULE_ELSE | this_SpecialKeywords_13= ruleSpecialKeywords | this_Constant1_14= ruleConstant1 ) ;
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
        AntlrDatatypeRuleToken this_SpecialKeywords_13 = null;

        AntlrDatatypeRuleToken this_Constant1_14 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2479:28: ( (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_ELIF_11= RULE_ELIF | this_ELSE_12= RULE_ELSE | this_SpecialKeywords_13= ruleSpecialKeywords | this_Constant1_14= ruleConstant1 ) )
            // InternalPreprocess.g:2480:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_ELIF_11= RULE_ELIF | this_ELSE_12= RULE_ELSE | this_SpecialKeywords_13= ruleSpecialKeywords | this_Constant1_14= ruleConstant1 )
            {
            // InternalPreprocess.g:2480:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_ELIF_11= RULE_ELIF | this_ELSE_12= RULE_ELSE | this_SpecialKeywords_13= ruleSpecialKeywords | this_Constant1_14= ruleConstant1 )
            int alt55=15;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt55=1;
                }
                break;
            case RULE_SPECIAL:
                {
                alt55=2;
                }
                break;
            case RULE_INCLUDE:
                {
                alt55=3;
                }
                break;
            case RULE_DEFINE:
                {
                alt55=4;
                }
                break;
            case RULE_ERROR:
                {
                alt55=5;
                }
                break;
            case RULE_PRAGMA:
                {
                alt55=6;
                }
                break;
            case RULE_IFDEF:
                {
                alt55=7;
                }
                break;
            case RULE_ENDIF:
                {
                alt55=8;
                }
                break;
            case RULE_IFNOTDEF:
                {
                alt55=9;
                }
                break;
            case RULE_IF:
                {
                alt55=10;
                }
                break;
            case RULE_DEFINED:
                {
                alt55=11;
                }
                break;
            case RULE_ELIF:
                {
                alt55=12;
                }
                break;
            case RULE_ELSE:
                {
                alt55=13;
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
                alt55=14;
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
                alt55=15;
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
                    // InternalPreprocess.g:2480:6: this_ID_0= RULE_ID
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
                    // InternalPreprocess.g:2488:10: this_SPECIAL_1= RULE_SPECIAL
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
                    // InternalPreprocess.g:2496:10: this_INCLUDE_2= RULE_INCLUDE
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
                    // InternalPreprocess.g:2504:10: this_DEFINE_3= RULE_DEFINE
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
                    // InternalPreprocess.g:2512:10: this_ERROR_4= RULE_ERROR
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
                    // InternalPreprocess.g:2520:10: this_PRAGMA_5= RULE_PRAGMA
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
                    // InternalPreprocess.g:2528:10: this_IFDEF_6= RULE_IFDEF
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
                    // InternalPreprocess.g:2536:10: this_ENDIF_7= RULE_ENDIF
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
                    // InternalPreprocess.g:2544:10: this_IFNOTDEF_8= RULE_IFNOTDEF
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
                    // InternalPreprocess.g:2552:10: this_IF_9= RULE_IF
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
                    // InternalPreprocess.g:2560:10: this_DEFINED_10= RULE_DEFINED
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
                    // InternalPreprocess.g:2568:10: this_ELIF_11= RULE_ELIF
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
                    // InternalPreprocess.g:2576:10: this_ELSE_12= RULE_ELSE
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
                    // InternalPreprocess.g:2585:5: this_SpecialKeywords_13= ruleSpecialKeywords
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeAccess().getSpecialKeywordsParserRuleCall_13()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_SpecialKeywords_13=ruleSpecialKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SpecialKeywords_13);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 15 :
                    // InternalPreprocess.g:2597:5: this_Constant1_14= ruleConstant1
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeAccess().getConstant1ParserRuleCall_14()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Constant1_14=ruleConstant1();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Constant1_14);
                          
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
    // InternalPreprocess.g:2615:1: entryRuleMyDefineLine returns [String current=null] : iv_ruleMyDefineLine= ruleMyDefineLine EOF ;
    public final String entryRuleMyDefineLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyDefineLine = null;


        try {
            // InternalPreprocess.g:2616:2: (iv_ruleMyDefineLine= ruleMyDefineLine EOF )
            // InternalPreprocess.g:2617:2: iv_ruleMyDefineLine= ruleMyDefineLine EOF
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
    // InternalPreprocess.g:2624:1: ruleMyDefineLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_HASH_2= RULE_HASH | this_VA_ARGS_3= RULE_VA_ARGS )* ;
    public final AntlrDatatypeRuleToken ruleMyDefineLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_1=null;
        Token this_HASH_2=null;
        Token this_VA_ARGS_3=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2627:28: ( (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_HASH_2= RULE_HASH | this_VA_ARGS_3= RULE_VA_ARGS )* )
            // InternalPreprocess.g:2628:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_HASH_2= RULE_HASH | this_VA_ARGS_3= RULE_VA_ARGS )*
            {
            // InternalPreprocess.g:2628:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_HASH_2= RULE_HASH | this_VA_ARGS_3= RULE_VA_ARGS )*
            loop56:
            do {
                int alt56=5;
                switch ( input.LA(1) ) {
                case RULE_INCLUDE:
                case RULE_DEFINE:
                case RULE_SKW_LEFTPAREN:
                case RULE_SKW_RIGHTPAREN:
                case RULE_ID:
                case RULE_SKW_COMMA:
                case RULE_ERROR:
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
                    alt56=1;
                    }
                    break;
                case RULE_WHITESPACE:
                    {
                    alt56=2;
                    }
                    break;
                case RULE_HASH:
                    {
                    alt56=3;
                    }
                    break;
                case RULE_VA_ARGS:
                    {
                    alt56=4;
                    }
                    break;

                }

                switch (alt56) {
            	case 1 :
            	    // InternalPreprocess.g:2629:5: this_MyCode_0= ruleMyCode
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
            	    // InternalPreprocess.g:2640:10: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_15); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WHITESPACE_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getMyDefineLineAccess().getWHITESPACETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;
            	case 3 :
            	    // InternalPreprocess.g:2648:10: this_HASH_2= RULE_HASH
            	    {
            	    this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_15); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_HASH_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_HASH_2, grammarAccess.getMyDefineLineAccess().getHASHTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;
            	case 4 :
            	    // InternalPreprocess.g:2656:10: this_VA_ARGS_3= RULE_VA_ARGS
            	    {
            	    this_VA_ARGS_3=(Token)match(input,RULE_VA_ARGS,FOLLOW_15); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_VA_ARGS_3);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_VA_ARGS_3, grammarAccess.getMyDefineLineAccess().getVA_ARGSTerminalRuleCall_3()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop56;
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
    // InternalPreprocess.g:2671:1: entryRuleMyCodeLine returns [String current=null] : iv_ruleMyCodeLine= ruleMyCodeLine EOF ;
    public final String entryRuleMyCodeLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLine = null;


        try {
            // InternalPreprocess.g:2672:2: (iv_ruleMyCodeLine= ruleMyCodeLine EOF )
            // InternalPreprocess.g:2673:2: iv_ruleMyCodeLine= ruleMyCodeLine EOF
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
    // InternalPreprocess.g:2680:1: ruleMyCodeLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+ ;
    public final AntlrDatatypeRuleToken ruleMyCodeLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_1=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2683:28: ( (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+ )
            // InternalPreprocess.g:2684:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+
            {
            // InternalPreprocess.g:2684:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+
            int cnt57=0;
            loop57:
            do {
                int alt57=3;
                alt57 = dfa57.predict(input);
                switch (alt57) {
            	case 1 :
            	    // InternalPreprocess.g:2685:5: this_MyCode_0= ruleMyCode
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
            	    // InternalPreprocess.g:2696:10: this_WHITESPACE_1= RULE_WHITESPACE
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
            	    if ( cnt57 >= 1 ) break loop57;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(57, input);
                        throw eee;
                }
                cnt57++;
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
    // InternalPreprocess.g:2711:1: entryRuleMyCodeLineExtended returns [String current=null] : iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF ;
    public final String entryRuleMyCodeLineExtended() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtended = null;


        try {
            // InternalPreprocess.g:2712:2: (iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF )
            // InternalPreprocess.g:2713:2: iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF
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
    // InternalPreprocess.g:2720:1: ruleMyCodeLineExtended returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal ) ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtended() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_MyCodeLineExtendedWSOnly_0 = null;

        AntlrDatatypeRuleToken this_MyCodeLineExtendedNormal_1 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2723:28: ( (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal ) )
            // InternalPreprocess.g:2724:1: (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal )
            {
            // InternalPreprocess.g:2724:1: (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal )
            int alt58=2;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // InternalPreprocess.g:2725:5: this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly
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
                    // InternalPreprocess.g:2737:5: this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal
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
    // InternalPreprocess.g:2755:1: entryRuleMyCodeLineExtendedWSOnly returns [String current=null] : iv_ruleMyCodeLineExtendedWSOnly= ruleMyCodeLineExtendedWSOnly EOF ;
    public final String entryRuleMyCodeLineExtendedWSOnly() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtendedWSOnly = null;


        try {
            // InternalPreprocess.g:2756:2: (iv_ruleMyCodeLineExtendedWSOnly= ruleMyCodeLineExtendedWSOnly EOF )
            // InternalPreprocess.g:2757:2: iv_ruleMyCodeLineExtendedWSOnly= ruleMyCodeLineExtendedWSOnly EOF
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
    // InternalPreprocess.g:2764:1: ruleMyCodeLineExtendedWSOnly returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_WHITESPACE_0= RULE_WHITESPACE )+ ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtendedWSOnly() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_0=null;

         enterRule(); 
            
        try {
            // InternalPreprocess.g:2767:28: ( (this_WHITESPACE_0= RULE_WHITESPACE )+ )
            // InternalPreprocess.g:2768:1: (this_WHITESPACE_0= RULE_WHITESPACE )+
            {
            // InternalPreprocess.g:2768:1: (this_WHITESPACE_0= RULE_WHITESPACE )+
            int cnt59=0;
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_WHITESPACE) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalPreprocess.g:2768:6: this_WHITESPACE_0= RULE_WHITESPACE
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
            	    if ( cnt59 >= 1 ) break loop59;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(59, input);
                        throw eee;
                }
                cnt59++;
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
    // InternalPreprocess.g:2783:1: entryRuleMyCodeLineExtendedNormal returns [String current=null] : iv_ruleMyCodeLineExtendedNormal= ruleMyCodeLineExtendedNormal EOF ;
    public final String entryRuleMyCodeLineExtendedNormal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtendedNormal = null;


        try {
            // InternalPreprocess.g:2784:2: (iv_ruleMyCodeLineExtendedNormal= ruleMyCodeLineExtendedNormal EOF )
            // InternalPreprocess.g:2785:2: iv_ruleMyCodeLineExtendedNormal= ruleMyCodeLineExtendedNormal EOF
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
    // InternalPreprocess.g:2792:1: ruleMyCodeLineExtendedNormal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* ) ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtendedNormal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_0=null;
        Token this_HASH_3=null;
        AntlrDatatypeRuleToken this_MyCode_1 = null;

        AntlrDatatypeRuleToken this_MyCodeLine_2 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2795:28: ( ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* ) )
            // InternalPreprocess.g:2796:1: ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )
            {
            // InternalPreprocess.g:2796:1: ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )
            // InternalPreprocess.g:2796:2: (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
            {
            // InternalPreprocess.g:2796:2: (this_WHITESPACE_0= RULE_WHITESPACE )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_WHITESPACE) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalPreprocess.g:2796:7: this_WHITESPACE_0= RULE_WHITESPACE
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
            	    break loop60;
                }
            } while (true);

            // InternalPreprocess.g:2803:3: (this_MyCode_1= ruleMyCode )+
            int cnt61=0;
            loop61:
            do {
                int alt61=2;
                alt61 = dfa61.predict(input);
                switch (alt61) {
            	case 1 :
            	    // InternalPreprocess.g:2804:5: this_MyCode_1= ruleMyCode
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
            	    if ( cnt61 >= 1 ) break loop61;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(61, input);
                        throw eee;
                }
                cnt61++;
            } while (true);

            // InternalPreprocess.g:2814:3: (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
            loop62:
            do {
                int alt62=3;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_WHITESPACE||(LA62_0>=RULE_INCLUDE && LA62_0<=RULE_ERROR)||(LA62_0>=RULE_ENDIF && LA62_0<=RULE_DEFINED)||(LA62_0>=RULE_SKW_QUESTION && LA62_0<=RULE_SKW_SINGLEQUOTE)) ) {
                    alt62=1;
                }
                else if ( (LA62_0==RULE_HASH) ) {
                    alt62=2;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalPreprocess.g:2815:5: this_MyCodeLine_2= ruleMyCodeLine
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
            	    // InternalPreprocess.g:2826:10: this_HASH_3= RULE_HASH
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
            	    break loop62;
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
    // InternalPreprocess.g:2841:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalPreprocess.g:2842:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalPreprocess.g:2843:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalPreprocess.g:2850:1: rulePrimaryExpression returns [EObject current=null] : ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) ) ;
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
            // InternalPreprocess.g:2856:7: ( ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) ) )
            // InternalPreprocess.g:2858:1: ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) )
            {
            // InternalPreprocess.g:2858:1: ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) )
            // InternalPreprocess.g:2859:1: () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) )
            {
            // InternalPreprocess.g:2859:1: ()
            // InternalPreprocess.g:2860:2: 
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

            // InternalPreprocess.g:2871:1: ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) )
            int alt65=4;
            switch ( input.LA(1) ) {
            case RULE_DEFINED:
                {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==RULE_SKW_LEFTPAREN) ) {
                    alt65=2;
                }
                else if ( (LA65_1==RULE_ID) ) {
                    alt65=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                alt65=1;
                }
                break;
            case RULE_SKW_LEFTPAREN:
                {
                int LA65_3 = input.LA(2);

                if ( (LA65_3==RULE_SKW_LEFTPAREN||LA65_3==RULE_DEFINED||LA65_3==RULE_SKW_AND||(LA65_3>=RULE_SKW_PLUS && LA65_3<=RULE_SKW_STAR)||(LA65_3>=RULE_SKW_TILDE && LA65_3<=RULE_BIN_LITERAL)) ) {
                    alt65=4;
                }
                else if ( (LA65_3==RULE_ID) ) {
                    int LA65_7 = input.LA(3);

                    if ( (LA65_7==RULE_SKW_LEFTPAREN||LA65_7==RULE_SKW_QUESTION||(LA65_7>=RULE_SKW_OROR && LA65_7<=RULE_SKW_MOD)) ) {
                        alt65=4;
                    }
                    else if ( (LA65_7==RULE_SKW_RIGHTPAREN) ) {
                        int LA65_8 = input.LA(4);

                        if ( (synpred92_InternalPreprocess()) ) {
                            alt65=2;
                        }
                        else if ( (true) ) {
                            alt65=4;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 65, 8, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 65, 7, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 3, input);

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
                alt65=3;
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
                    // InternalPreprocess.g:2872:1: ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) )
                    {
                    // InternalPreprocess.g:2872:1: ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) )
                    // InternalPreprocess.g:2873:1: ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) )
                    {
                    // InternalPreprocess.g:2873:1: ( (lv_defined_1_0= RULE_DEFINED ) )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==RULE_DEFINED) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // InternalPreprocess.g:2874:1: (lv_defined_1_0= RULE_DEFINED )
                            {
                            // InternalPreprocess.g:2874:1: (lv_defined_1_0= RULE_DEFINED )
                            // InternalPreprocess.g:2875:3: lv_defined_1_0= RULE_DEFINED
                            {
                            lv_defined_1_0=(Token)match(input,RULE_DEFINED,FOLLOW_26); if (state.failed) return current;
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

                    // InternalPreprocess.g:2894:1: ( (lv_id_2_0= RULE_ID ) )
                    // InternalPreprocess.g:2895:1: (lv_id_2_0= RULE_ID )
                    {
                    // InternalPreprocess.g:2895:1: (lv_id_2_0= RULE_ID )
                    // InternalPreprocess.g:2896:3: lv_id_2_0= RULE_ID
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
                    // InternalPreprocess.g:2918:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
                    {
                    // InternalPreprocess.g:2918:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
                    // InternalPreprocess.g:2919:1: ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN
                    {
                    // InternalPreprocess.g:2919:1: ( (lv_defined_3_0= RULE_DEFINED ) )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==RULE_DEFINED) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // InternalPreprocess.g:2920:1: (lv_defined_3_0= RULE_DEFINED )
                            {
                            // InternalPreprocess.g:2920:1: (lv_defined_3_0= RULE_DEFINED )
                            // InternalPreprocess.g:2921:3: lv_defined_3_0= RULE_DEFINED
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

                    this_SKW_LEFTPAREN_4=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LEFTPAREN_4, grammarAccess.getPrimaryExpressionAccess().getSKW_LEFTPARENTerminalRuleCall_1_1_1()); 
                          
                    }
                    // InternalPreprocess.g:2947:1: ( (lv_id_5_0= RULE_ID ) )
                    // InternalPreprocess.g:2948:1: (lv_id_5_0= RULE_ID )
                    {
                    // InternalPreprocess.g:2948:1: (lv_id_5_0= RULE_ID )
                    // InternalPreprocess.g:2949:3: lv_id_5_0= RULE_ID
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
                    // InternalPreprocess.g:2978:1: ( (lv_const_7_0= ruleConstant1 ) )
                    {
                    // InternalPreprocess.g:2978:1: ( (lv_const_7_0= ruleConstant1 ) )
                    // InternalPreprocess.g:2979:1: (lv_const_7_0= ruleConstant1 )
                    {
                    // InternalPreprocess.g:2979:1: (lv_const_7_0= ruleConstant1 )
                    // InternalPreprocess.g:2980:3: lv_const_7_0= ruleConstant1
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
                    // InternalPreprocess.g:3000:1: (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN )
                    {
                    // InternalPreprocess.g:3000:1: (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN )
                    // InternalPreprocess.g:3001:1: this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN
                    {
                    this_SKW_LEFTPAREN_8=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LEFTPAREN_8, grammarAccess.getPrimaryExpressionAccess().getSKW_LEFTPARENTerminalRuleCall_1_3_0()); 
                          
                    }
                    // InternalPreprocess.g:3008:1: ( (lv_expr_9_0= ruleExpression ) )
                    // InternalPreprocess.g:3009:1: (lv_expr_9_0= ruleExpression )
                    {
                    // InternalPreprocess.g:3009:1: (lv_expr_9_0= ruleExpression )
                    // InternalPreprocess.g:3010:3: lv_expr_9_0= ruleExpression
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
    // InternalPreprocess.g:3049:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
        	
        try {
            // InternalPreprocess.g:3053:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalPreprocess.g:3054:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalPreprocess.g:3064:1: ruleExpression returns [EObject current=null] : ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         enterRule();
           		/*no init found*/
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
            
        try {
            // InternalPreprocess.g:3071:7: ( ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) ) )
            // InternalPreprocess.g:3073:1: ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) )
            {
            // InternalPreprocess.g:3073:1: ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) )
            // InternalPreprocess.g:3074:1: () ( (lv_expression_1_0= ruleConditionalExpression ) )
            {
            // InternalPreprocess.g:3074:1: ()
            // InternalPreprocess.g:3075:2: 
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

            // InternalPreprocess.g:3086:1: ( (lv_expression_1_0= ruleConditionalExpression ) )
            // InternalPreprocess.g:3087:1: (lv_expression_1_0= ruleConditionalExpression )
            {
            // InternalPreprocess.g:3087:1: (lv_expression_1_0= ruleConditionalExpression )
            // InternalPreprocess.g:3088:3: lv_expression_1_0= ruleConditionalExpression
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
    // InternalPreprocess.g:3119:1: entryRuleConstantExpression returns [EObject current=null] : iv_ruleConstantExpression= ruleConstantExpression EOF ;
    public final EObject entryRuleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantExpression = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
        	
        try {
            // InternalPreprocess.g:3123:2: (iv_ruleConstantExpression= ruleConstantExpression EOF )
            // InternalPreprocess.g:3124:2: iv_ruleConstantExpression= ruleConstantExpression EOF
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
    // InternalPreprocess.g:3134:1: ruleConstantExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) ) ;
    public final EObject ruleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;


         enterRule();
           		/*no init found*/
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
            
        try {
            // InternalPreprocess.g:3141:7: ( ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) ) )
            // InternalPreprocess.g:3143:1: ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) )
            {
            // InternalPreprocess.g:3143:1: ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) )
            // InternalPreprocess.g:3144:1: () ( (lv_expr_1_0= ruleConditionalExpression ) )
            {
            // InternalPreprocess.g:3144:1: ()
            // InternalPreprocess.g:3145:2: 
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

            // InternalPreprocess.g:3156:1: ( (lv_expr_1_0= ruleConditionalExpression ) )
            // InternalPreprocess.g:3157:1: (lv_expr_1_0= ruleConditionalExpression )
            {
            // InternalPreprocess.g:3157:1: (lv_expr_1_0= ruleConditionalExpression )
            // InternalPreprocess.g:3158:3: lv_expr_1_0= ruleConditionalExpression
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
    // InternalPreprocess.g:3189:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalPreprocess.g:3190:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalPreprocess.g:3191:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
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
    // InternalPreprocess.g:3198:1: ruleConditionalExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) ;
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
            // InternalPreprocess.g:3204:7: ( ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) )
            // InternalPreprocess.g:3206:1: ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
            {
            // InternalPreprocess.g:3206:1: ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
            // InternalPreprocess.g:3207:1: () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
            {
            // InternalPreprocess.g:3207:1: ()
            // InternalPreprocess.g:3208:2: 
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

            // InternalPreprocess.g:3219:1: ( (lv_expr_1_0= ruleLogicalOrExpression ) )
            // InternalPreprocess.g:3220:1: (lv_expr_1_0= ruleLogicalOrExpression )
            {
            // InternalPreprocess.g:3220:1: (lv_expr_1_0= ruleLogicalOrExpression )
            // InternalPreprocess.g:3221:3: lv_expr_1_0= ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExprLogicalOrExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_27);
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

            // InternalPreprocess.g:3240:1: (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_SKW_QUESTION) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalPreprocess.g:3241:1: this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) )
                    {
                    this_SKW_QUESTION_2=(Token)match(input,RULE_SKW_QUESTION,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_QUESTION_2, grammarAccess.getConditionalExpressionAccess().getSKW_QUESTIONTerminalRuleCall_2_0()); 
                          
                    }
                    // InternalPreprocess.g:3248:1: ( (lv_qExpr_3_0= ruleExpression ) )
                    // InternalPreprocess.g:3249:1: (lv_qExpr_3_0= ruleExpression )
                    {
                    // InternalPreprocess.g:3249:1: (lv_qExpr_3_0= ruleExpression )
                    // InternalPreprocess.g:3250:3: lv_qExpr_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getQExprExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_28);
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
                    // InternalPreprocess.g:3276:1: ( (lv_cExpr_5_0= ruleConditionalExpression ) )
                    // InternalPreprocess.g:3277:1: (lv_cExpr_5_0= ruleConditionalExpression )
                    {
                    // InternalPreprocess.g:3277:1: (lv_cExpr_5_0= ruleConditionalExpression )
                    // InternalPreprocess.g:3278:3: lv_cExpr_5_0= ruleConditionalExpression
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
    // InternalPreprocess.g:3308:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalPreprocess.g:3309:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalPreprocess.g:3310:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
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
    // InternalPreprocess.g:3317:1: ruleLogicalOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_OROR_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3323:7: ( ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalPreprocess.g:3325:1: ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalPreprocess.g:3325:1: ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalPreprocess.g:3326:1: () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )*
            {
            // InternalPreprocess.g:3326:1: ()
            // InternalPreprocess.g:3327:2: 
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

            // InternalPreprocess.g:3338:1: ( (lv_expr_1_0= ruleLogicalAndExpression ) )
            // InternalPreprocess.g:3339:1: (lv_expr_1_0= ruleLogicalAndExpression )
            {
            // InternalPreprocess.g:3339:1: (lv_expr_1_0= ruleLogicalAndExpression )
            // InternalPreprocess.g:3340:3: lv_expr_1_0= ruleLogicalAndExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getExprLogicalAndExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_29);
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

            // InternalPreprocess.g:3359:1: (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==RULE_SKW_OROR) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalPreprocess.g:3360:1: this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) )
            	    {
            	    this_SKW_OROR_2=(Token)match(input,RULE_SKW_OROR,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_OROR_2, grammarAccess.getLogicalOrExpressionAccess().getSKW_ORORTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3367:1: ( (lv_expr_3_0= ruleLogicalAndExpression ) )
            	    // InternalPreprocess.g:3368:1: (lv_expr_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalPreprocess.g:3368:1: (lv_expr_3_0= ruleLogicalAndExpression )
            	    // InternalPreprocess.g:3369:3: lv_expr_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getExprLogicalAndExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
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
            	    break loop67;
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
    // InternalPreprocess.g:3399:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalPreprocess.g:3400:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalPreprocess.g:3401:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
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
    // InternalPreprocess.g:3408:1: ruleLogicalAndExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_ANDAND_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3414:7: ( ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* ) )
            // InternalPreprocess.g:3416:1: ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* )
            {
            // InternalPreprocess.g:3416:1: ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* )
            // InternalPreprocess.g:3417:1: () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )*
            {
            // InternalPreprocess.g:3417:1: ()
            // InternalPreprocess.g:3418:2: 
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

            // InternalPreprocess.g:3429:1: ( (lv_expr_1_0= ruleInclusiveOrExpression ) )
            // InternalPreprocess.g:3430:1: (lv_expr_1_0= ruleInclusiveOrExpression )
            {
            // InternalPreprocess.g:3430:1: (lv_expr_1_0= ruleInclusiveOrExpression )
            // InternalPreprocess.g:3431:3: lv_expr_1_0= ruleInclusiveOrExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getExprInclusiveOrExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_30);
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

            // InternalPreprocess.g:3450:1: (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==RULE_SKW_ANDAND) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalPreprocess.g:3451:1: this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) )
            	    {
            	    this_SKW_ANDAND_2=(Token)match(input,RULE_SKW_ANDAND,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_ANDAND_2, grammarAccess.getLogicalAndExpressionAccess().getSKW_ANDANDTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3458:1: ( (lv_expr_3_0= ruleInclusiveOrExpression ) )
            	    // InternalPreprocess.g:3459:1: (lv_expr_3_0= ruleInclusiveOrExpression )
            	    {
            	    // InternalPreprocess.g:3459:1: (lv_expr_3_0= ruleInclusiveOrExpression )
            	    // InternalPreprocess.g:3460:3: lv_expr_3_0= ruleInclusiveOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getExprInclusiveOrExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_30);
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
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleInclusiveOrExpression"
    // InternalPreprocess.g:3490:1: entryRuleInclusiveOrExpression returns [EObject current=null] : iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF ;
    public final EObject entryRuleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclusiveOrExpression = null;


        try {
            // InternalPreprocess.g:3491:2: (iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF )
            // InternalPreprocess.g:3492:2: iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF
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
    // InternalPreprocess.g:3499:1: ruleInclusiveOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* ) ;
    public final EObject ruleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_OR_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3505:7: ( ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* ) )
            // InternalPreprocess.g:3507:1: ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* )
            {
            // InternalPreprocess.g:3507:1: ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* )
            // InternalPreprocess.g:3508:1: () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )*
            {
            // InternalPreprocess.g:3508:1: ()
            // InternalPreprocess.g:3509:2: 
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

            // InternalPreprocess.g:3520:1: ( (lv_expr_1_0= ruleExclusiveOrExpression ) )
            // InternalPreprocess.g:3521:1: (lv_expr_1_0= ruleExclusiveOrExpression )
            {
            // InternalPreprocess.g:3521:1: (lv_expr_1_0= ruleExclusiveOrExpression )
            // InternalPreprocess.g:3522:3: lv_expr_1_0= ruleExclusiveOrExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExprExclusiveOrExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_31);
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

            // InternalPreprocess.g:3541:1: (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==RULE_SKW_OR) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalPreprocess.g:3542:1: this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) )
            	    {
            	    this_SKW_OR_2=(Token)match(input,RULE_SKW_OR,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_OR_2, grammarAccess.getInclusiveOrExpressionAccess().getSKW_ORTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3549:1: ( (lv_expr_3_0= ruleExclusiveOrExpression ) )
            	    // InternalPreprocess.g:3550:1: (lv_expr_3_0= ruleExclusiveOrExpression )
            	    {
            	    // InternalPreprocess.g:3550:1: (lv_expr_3_0= ruleExclusiveOrExpression )
            	    // InternalPreprocess.g:3551:3: lv_expr_3_0= ruleExclusiveOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExprExclusiveOrExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_31);
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
            	    break loop69;
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
    // InternalPreprocess.g:3581:1: entryRuleExclusiveOrExpression returns [EObject current=null] : iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF ;
    public final EObject entryRuleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusiveOrExpression = null;


        try {
            // InternalPreprocess.g:3582:2: (iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF )
            // InternalPreprocess.g:3583:2: iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF
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
    // InternalPreprocess.g:3590:1: ruleExclusiveOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_CARET_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3596:7: ( ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* ) )
            // InternalPreprocess.g:3598:1: ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* )
            {
            // InternalPreprocess.g:3598:1: ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* )
            // InternalPreprocess.g:3599:1: () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )*
            {
            // InternalPreprocess.g:3599:1: ()
            // InternalPreprocess.g:3600:2: 
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

            // InternalPreprocess.g:3611:1: ( (lv_expr_1_0= ruleAndExpression ) )
            // InternalPreprocess.g:3612:1: (lv_expr_1_0= ruleAndExpression )
            {
            // InternalPreprocess.g:3612:1: (lv_expr_1_0= ruleAndExpression )
            // InternalPreprocess.g:3613:3: lv_expr_1_0= ruleAndExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getExprAndExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_32);
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

            // InternalPreprocess.g:3632:1: (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==RULE_SKW_CARET) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalPreprocess.g:3633:1: this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) )
            	    {
            	    this_SKW_CARET_2=(Token)match(input,RULE_SKW_CARET,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_CARET_2, grammarAccess.getExclusiveOrExpressionAccess().getSKW_CARETTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3640:1: ( (lv_expr_3_0= ruleAndExpression ) )
            	    // InternalPreprocess.g:3641:1: (lv_expr_3_0= ruleAndExpression )
            	    {
            	    // InternalPreprocess.g:3641:1: (lv_expr_3_0= ruleAndExpression )
            	    // InternalPreprocess.g:3642:3: lv_expr_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getExprAndExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_32);
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
            	    break loop70;
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
    // InternalPreprocess.g:3672:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalPreprocess.g:3673:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalPreprocess.g:3674:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalPreprocess.g:3681:1: ruleAndExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_AND_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3687:7: ( ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalPreprocess.g:3689:1: ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalPreprocess.g:3689:1: ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* )
            // InternalPreprocess.g:3690:1: () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )*
            {
            // InternalPreprocess.g:3690:1: ()
            // InternalPreprocess.g:3691:2: 
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

            // InternalPreprocess.g:3702:1: ( (lv_expr_1_0= ruleEqualityExpression ) )
            // InternalPreprocess.g:3703:1: (lv_expr_1_0= ruleEqualityExpression )
            {
            // InternalPreprocess.g:3703:1: (lv_expr_1_0= ruleEqualityExpression )
            // InternalPreprocess.g:3704:3: lv_expr_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAndExpressionAccess().getExprEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_33);
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

            // InternalPreprocess.g:3723:1: (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==RULE_SKW_AND) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalPreprocess.g:3724:1: this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) )
            	    {
            	    this_SKW_AND_2=(Token)match(input,RULE_SKW_AND,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_AND_2, grammarAccess.getAndExpressionAccess().getSKW_ANDTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3731:1: ( (lv_expr_3_0= ruleEqualityExpression ) )
            	    // InternalPreprocess.g:3732:1: (lv_expr_3_0= ruleEqualityExpression )
            	    {
            	    // InternalPreprocess.g:3732:1: (lv_expr_3_0= ruleEqualityExpression )
            	    // InternalPreprocess.g:3733:3: lv_expr_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExpressionAccess().getExprEqualityExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_33);
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
            	    break loop71;
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
    // InternalPreprocess.g:3763:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalPreprocess.g:3764:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalPreprocess.g:3765:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalPreprocess.g:3772:1: ruleEqualityExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3778:7: ( ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* ) )
            // InternalPreprocess.g:3780:1: ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* )
            {
            // InternalPreprocess.g:3780:1: ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* )
            // InternalPreprocess.g:3781:1: () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )*
            {
            // InternalPreprocess.g:3781:1: ()
            // InternalPreprocess.g:3782:2: 
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

            // InternalPreprocess.g:3793:1: ( (lv_expr_1_0= ruleRelationalExpression ) )
            // InternalPreprocess.g:3794:1: (lv_expr_1_0= ruleRelationalExpression )
            {
            // InternalPreprocess.g:3794:1: (lv_expr_1_0= ruleRelationalExpression )
            // InternalPreprocess.g:3795:3: lv_expr_1_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExprRelationalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_34);
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

            // InternalPreprocess.g:3814:1: ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( ((LA73_0>=RULE_SKW_EQUAL && LA73_0<=RULE_SKW_NOTEQUAL)) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalPreprocess.g:3815:1: ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) )
            	    {
            	    // InternalPreprocess.g:3815:1: ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) )
            	    int alt72=2;
            	    int LA72_0 = input.LA(1);

            	    if ( (LA72_0==RULE_SKW_EQUAL) ) {
            	        alt72=1;
            	    }
            	    else if ( (LA72_0==RULE_SKW_NOTEQUAL) ) {
            	        alt72=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 72, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt72) {
            	        case 1 :
            	            // InternalPreprocess.g:3816:1: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
            	            {
            	            // InternalPreprocess.g:3816:1: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
            	            // InternalPreprocess.g:3817:1: (lv_op_2_0= RULE_SKW_EQUAL )
            	            {
            	            // InternalPreprocess.g:3817:1: (lv_op_2_0= RULE_SKW_EQUAL )
            	            // InternalPreprocess.g:3818:3: lv_op_2_0= RULE_SKW_EQUAL
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
            	            // InternalPreprocess.g:3838:1: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
            	            {
            	            // InternalPreprocess.g:3838:1: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
            	            // InternalPreprocess.g:3839:1: (lv_op_3_0= RULE_SKW_NOTEQUAL )
            	            {
            	            // InternalPreprocess.g:3839:1: (lv_op_3_0= RULE_SKW_NOTEQUAL )
            	            // InternalPreprocess.g:3840:3: lv_op_3_0= RULE_SKW_NOTEQUAL
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

            	    // InternalPreprocess.g:3861:1: ( (lv_expr_4_0= ruleRelationalExpression ) )
            	    // InternalPreprocess.g:3862:1: (lv_expr_4_0= ruleRelationalExpression )
            	    {
            	    // InternalPreprocess.g:3862:1: (lv_expr_4_0= ruleRelationalExpression )
            	    // InternalPreprocess.g:3863:3: lv_expr_4_0= ruleRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExprRelationalExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_34);
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
            	    break loop73;
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
    // InternalPreprocess.g:3893:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalPreprocess.g:3894:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalPreprocess.g:3895:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalPreprocess.g:3902:1: ruleRelationalExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* ) ;
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
            // InternalPreprocess.g:3908:7: ( ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* ) )
            // InternalPreprocess.g:3910:1: ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* )
            {
            // InternalPreprocess.g:3910:1: ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* )
            // InternalPreprocess.g:3911:1: () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )*
            {
            // InternalPreprocess.g:3911:1: ()
            // InternalPreprocess.g:3912:2: 
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

            // InternalPreprocess.g:3923:1: ( (lv_expr_1_0= ruleShiftExpression ) )
            // InternalPreprocess.g:3924:1: (lv_expr_1_0= ruleShiftExpression )
            {
            // InternalPreprocess.g:3924:1: (lv_expr_1_0= ruleShiftExpression )
            // InternalPreprocess.g:3925:3: lv_expr_1_0= ruleShiftExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExprShiftExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_35);
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

            // InternalPreprocess.g:3944:1: ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( ((LA75_0>=RULE_SKW_LESS && LA75_0<=RULE_SKW_GREATEREQUAL)) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalPreprocess.g:3945:1: ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) )
            	    {
            	    // InternalPreprocess.g:3945:1: ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) )
            	    int alt74=4;
            	    switch ( input.LA(1) ) {
            	    case RULE_SKW_LESS:
            	        {
            	        alt74=1;
            	        }
            	        break;
            	    case RULE_SKW_GREATER:
            	        {
            	        alt74=2;
            	        }
            	        break;
            	    case RULE_SKW_LESSEQUAL:
            	        {
            	        alt74=3;
            	        }
            	        break;
            	    case RULE_SKW_GREATEREQUAL:
            	        {
            	        alt74=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 74, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt74) {
            	        case 1 :
            	            // InternalPreprocess.g:3946:1: ( (lv_op_2_0= RULE_SKW_LESS ) )
            	            {
            	            // InternalPreprocess.g:3946:1: ( (lv_op_2_0= RULE_SKW_LESS ) )
            	            // InternalPreprocess.g:3947:1: (lv_op_2_0= RULE_SKW_LESS )
            	            {
            	            // InternalPreprocess.g:3947:1: (lv_op_2_0= RULE_SKW_LESS )
            	            // InternalPreprocess.g:3948:3: lv_op_2_0= RULE_SKW_LESS
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
            	            // InternalPreprocess.g:3968:1: ( (lv_op_3_0= RULE_SKW_GREATER ) )
            	            {
            	            // InternalPreprocess.g:3968:1: ( (lv_op_3_0= RULE_SKW_GREATER ) )
            	            // InternalPreprocess.g:3969:1: (lv_op_3_0= RULE_SKW_GREATER )
            	            {
            	            // InternalPreprocess.g:3969:1: (lv_op_3_0= RULE_SKW_GREATER )
            	            // InternalPreprocess.g:3970:3: lv_op_3_0= RULE_SKW_GREATER
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
            	            // InternalPreprocess.g:3990:1: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
            	            {
            	            // InternalPreprocess.g:3990:1: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
            	            // InternalPreprocess.g:3991:1: (lv_op_4_0= RULE_SKW_LESSEQUAL )
            	            {
            	            // InternalPreprocess.g:3991:1: (lv_op_4_0= RULE_SKW_LESSEQUAL )
            	            // InternalPreprocess.g:3992:3: lv_op_4_0= RULE_SKW_LESSEQUAL
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
            	            // InternalPreprocess.g:4012:1: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
            	            {
            	            // InternalPreprocess.g:4012:1: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
            	            // InternalPreprocess.g:4013:1: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
            	            {
            	            // InternalPreprocess.g:4013:1: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
            	            // InternalPreprocess.g:4014:3: lv_op_5_0= RULE_SKW_GREATEREQUAL
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

            	    // InternalPreprocess.g:4035:1: ( (lv_expr_6_0= ruleShiftExpression ) )
            	    // InternalPreprocess.g:4036:1: (lv_expr_6_0= ruleShiftExpression )
            	    {
            	    // InternalPreprocess.g:4036:1: (lv_expr_6_0= ruleShiftExpression )
            	    // InternalPreprocess.g:4037:3: lv_expr_6_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExprShiftExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_35);
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
            	    break loop75;
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
    // InternalPreprocess.g:4067:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalPreprocess.g:4068:2: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalPreprocess.g:4069:2: iv_ruleShiftExpression= ruleShiftExpression EOF
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
    // InternalPreprocess.g:4076:1: ruleShiftExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4082:7: ( ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* ) )
            // InternalPreprocess.g:4084:1: ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalPreprocess.g:4084:1: ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* )
            // InternalPreprocess.g:4085:1: () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )*
            {
            // InternalPreprocess.g:4085:1: ()
            // InternalPreprocess.g:4086:2: 
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

            // InternalPreprocess.g:4097:1: ( (lv_expr_1_0= ruleAdditiveExpression ) )
            // InternalPreprocess.g:4098:1: (lv_expr_1_0= ruleAdditiveExpression )
            {
            // InternalPreprocess.g:4098:1: (lv_expr_1_0= ruleAdditiveExpression )
            // InternalPreprocess.g:4099:3: lv_expr_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getExprAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_36);
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

            // InternalPreprocess.g:4118:1: ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( ((LA77_0>=RULE_SKW_LEFTSHIFT && LA77_0<=RULE_SKW_RIGHTSHIFT)) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalPreprocess.g:4119:1: ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalPreprocess.g:4119:1: ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) )
            	    int alt76=2;
            	    int LA76_0 = input.LA(1);

            	    if ( (LA76_0==RULE_SKW_LEFTSHIFT) ) {
            	        alt76=1;
            	    }
            	    else if ( (LA76_0==RULE_SKW_RIGHTSHIFT) ) {
            	        alt76=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 76, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt76) {
            	        case 1 :
            	            // InternalPreprocess.g:4120:1: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
            	            {
            	            // InternalPreprocess.g:4120:1: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
            	            // InternalPreprocess.g:4121:1: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
            	            {
            	            // InternalPreprocess.g:4121:1: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
            	            // InternalPreprocess.g:4122:3: lv_op_2_0= RULE_SKW_LEFTSHIFT
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
            	            // InternalPreprocess.g:4142:1: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
            	            {
            	            // InternalPreprocess.g:4142:1: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
            	            // InternalPreprocess.g:4143:1: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
            	            {
            	            // InternalPreprocess.g:4143:1: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
            	            // InternalPreprocess.g:4144:3: lv_op_3_0= RULE_SKW_RIGHTSHIFT
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

            	    // InternalPreprocess.g:4165:1: ( (lv_expr_4_0= ruleAdditiveExpression ) )
            	    // InternalPreprocess.g:4166:1: (lv_expr_4_0= ruleAdditiveExpression )
            	    {
            	    // InternalPreprocess.g:4166:1: (lv_expr_4_0= ruleAdditiveExpression )
            	    // InternalPreprocess.g:4167:3: lv_expr_4_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getExprAdditiveExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_36);
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
            	    break loop77;
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
    // InternalPreprocess.g:4197:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalPreprocess.g:4198:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalPreprocess.g:4199:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalPreprocess.g:4206:1: ruleAdditiveExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4212:7: ( ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalPreprocess.g:4214:1: ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalPreprocess.g:4214:1: ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* )
            // InternalPreprocess.g:4215:1: () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )*
            {
            // InternalPreprocess.g:4215:1: ()
            // InternalPreprocess.g:4216:2: 
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

            // InternalPreprocess.g:4227:1: ( (lv_expr_1_0= ruleMultiplicativeExpression ) )
            // InternalPreprocess.g:4228:1: (lv_expr_1_0= ruleMultiplicativeExpression )
            {
            // InternalPreprocess.g:4228:1: (lv_expr_1_0= ruleMultiplicativeExpression )
            // InternalPreprocess.g:4229:3: lv_expr_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExprMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_37);
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

            // InternalPreprocess.g:4248:1: ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( ((LA79_0>=RULE_SKW_PLUS && LA79_0<=RULE_SKW_MINUS)) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalPreprocess.g:4249:1: ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalPreprocess.g:4249:1: ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) )
            	    int alt78=2;
            	    int LA78_0 = input.LA(1);

            	    if ( (LA78_0==RULE_SKW_PLUS) ) {
            	        alt78=1;
            	    }
            	    else if ( (LA78_0==RULE_SKW_MINUS) ) {
            	        alt78=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 78, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt78) {
            	        case 1 :
            	            // InternalPreprocess.g:4250:1: ( (lv_op_2_0= RULE_SKW_PLUS ) )
            	            {
            	            // InternalPreprocess.g:4250:1: ( (lv_op_2_0= RULE_SKW_PLUS ) )
            	            // InternalPreprocess.g:4251:1: (lv_op_2_0= RULE_SKW_PLUS )
            	            {
            	            // InternalPreprocess.g:4251:1: (lv_op_2_0= RULE_SKW_PLUS )
            	            // InternalPreprocess.g:4252:3: lv_op_2_0= RULE_SKW_PLUS
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
            	            // InternalPreprocess.g:4272:1: ( (lv_op_3_0= RULE_SKW_MINUS ) )
            	            {
            	            // InternalPreprocess.g:4272:1: ( (lv_op_3_0= RULE_SKW_MINUS ) )
            	            // InternalPreprocess.g:4273:1: (lv_op_3_0= RULE_SKW_MINUS )
            	            {
            	            // InternalPreprocess.g:4273:1: (lv_op_3_0= RULE_SKW_MINUS )
            	            // InternalPreprocess.g:4274:3: lv_op_3_0= RULE_SKW_MINUS
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

            	    // InternalPreprocess.g:4295:1: ( (lv_expr_4_0= ruleMultiplicativeExpression ) )
            	    // InternalPreprocess.g:4296:1: (lv_expr_4_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalPreprocess.g:4296:1: (lv_expr_4_0= ruleMultiplicativeExpression )
            	    // InternalPreprocess.g:4297:3: lv_expr_4_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExprMultiplicativeExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_37);
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
            	    break loop79;
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
    // InternalPreprocess.g:4327:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalPreprocess.g:4328:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalPreprocess.g:4329:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalPreprocess.g:4336:1: ruleMultiplicativeExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* ) ;
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
            // InternalPreprocess.g:4342:7: ( ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* ) )
            // InternalPreprocess.g:4344:1: ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* )
            {
            // InternalPreprocess.g:4344:1: ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* )
            // InternalPreprocess.g:4345:1: () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )*
            {
            // InternalPreprocess.g:4345:1: ()
            // InternalPreprocess.g:4346:2: 
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

            // InternalPreprocess.g:4357:1: ( (lv_expr_1_0= ruleCastExpression ) )
            // InternalPreprocess.g:4358:1: (lv_expr_1_0= ruleCastExpression )
            {
            // InternalPreprocess.g:4358:1: (lv_expr_1_0= ruleCastExpression )
            // InternalPreprocess.g:4359:3: lv_expr_1_0= ruleCastExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExprCastExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_38);
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

            // InternalPreprocess.g:4378:1: ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( ((LA81_0>=RULE_SKW_STAR && LA81_0<=RULE_SKW_MOD)) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalPreprocess.g:4379:1: ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) )
            	    {
            	    // InternalPreprocess.g:4379:1: ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) )
            	    int alt80=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_SKW_STAR:
            	        {
            	        alt80=1;
            	        }
            	        break;
            	    case RULE_SKW_DIV:
            	        {
            	        alt80=2;
            	        }
            	        break;
            	    case RULE_SKW_MOD:
            	        {
            	        alt80=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 80, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt80) {
            	        case 1 :
            	            // InternalPreprocess.g:4380:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
            	            {
            	            // InternalPreprocess.g:4380:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
            	            // InternalPreprocess.g:4381:1: (lv_op_2_0= RULE_SKW_STAR )
            	            {
            	            // InternalPreprocess.g:4381:1: (lv_op_2_0= RULE_SKW_STAR )
            	            // InternalPreprocess.g:4382:3: lv_op_2_0= RULE_SKW_STAR
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
            	            // InternalPreprocess.g:4402:1: ( (lv_op_3_0= RULE_SKW_DIV ) )
            	            {
            	            // InternalPreprocess.g:4402:1: ( (lv_op_3_0= RULE_SKW_DIV ) )
            	            // InternalPreprocess.g:4403:1: (lv_op_3_0= RULE_SKW_DIV )
            	            {
            	            // InternalPreprocess.g:4403:1: (lv_op_3_0= RULE_SKW_DIV )
            	            // InternalPreprocess.g:4404:3: lv_op_3_0= RULE_SKW_DIV
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
            	            // InternalPreprocess.g:4424:1: ( (lv_op_4_0= RULE_SKW_MOD ) )
            	            {
            	            // InternalPreprocess.g:4424:1: ( (lv_op_4_0= RULE_SKW_MOD ) )
            	            // InternalPreprocess.g:4425:1: (lv_op_4_0= RULE_SKW_MOD )
            	            {
            	            // InternalPreprocess.g:4425:1: (lv_op_4_0= RULE_SKW_MOD )
            	            // InternalPreprocess.g:4426:3: lv_op_4_0= RULE_SKW_MOD
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

            	    // InternalPreprocess.g:4447:1: ( (lv_expr_5_0= ruleCastExpression ) )
            	    // InternalPreprocess.g:4448:1: (lv_expr_5_0= ruleCastExpression )
            	    {
            	    // InternalPreprocess.g:4448:1: (lv_expr_5_0= ruleCastExpression )
            	    // InternalPreprocess.g:4449:3: lv_expr_5_0= ruleCastExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExprCastExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_38);
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
            	    break loop81;
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
    // InternalPreprocess.g:4479:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalPreprocess.g:4480:2: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalPreprocess.g:4481:2: iv_ruleCastExpression= ruleCastExpression EOF
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
    // InternalPreprocess.g:4488:1: ruleCastExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4494:7: ( ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // InternalPreprocess.g:4496:1: ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // InternalPreprocess.g:4496:1: ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // InternalPreprocess.g:4497:1: () ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // InternalPreprocess.g:4497:1: ()
            // InternalPreprocess.g:4498:2: 
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

            // InternalPreprocess.g:4509:1: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // InternalPreprocess.g:4510:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // InternalPreprocess.g:4510:1: (lv_expr_1_0= ruleUnaryExpression )
            // InternalPreprocess.g:4511:3: lv_expr_1_0= ruleUnaryExpression
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
    // InternalPreprocess.g:4539:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalPreprocess.g:4540:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalPreprocess.g:4541:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalPreprocess.g:4548:1: ruleUnaryExpression returns [EObject current=null] : ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;

        EObject lv_op_2_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4554:7: ( ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) ) )
            // InternalPreprocess.g:4556:1: ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) )
            {
            // InternalPreprocess.g:4556:1: ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) )
            // InternalPreprocess.g:4557:1: () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
            {
            // InternalPreprocess.g:4557:1: ()
            // InternalPreprocess.g:4558:2: 
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

            // InternalPreprocess.g:4569:1: ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_SKW_LEFTPAREN||LA82_0==RULE_ID||LA82_0==RULE_DEFINED||(LA82_0>=RULE_HEX_LITERAL && LA82_0<=RULE_BIN_LITERAL)) ) {
                alt82=1;
            }
            else if ( (LA82_0==RULE_SKW_AND||(LA82_0>=RULE_SKW_PLUS && LA82_0<=RULE_SKW_STAR)||(LA82_0>=RULE_SKW_TILDE && LA82_0<=RULE_SKW_NOT)) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // InternalPreprocess.g:4570:1: ( (lv_expr_1_0= rulePostfixExpression ) )
                    {
                    // InternalPreprocess.g:4570:1: ( (lv_expr_1_0= rulePostfixExpression ) )
                    // InternalPreprocess.g:4571:1: (lv_expr_1_0= rulePostfixExpression )
                    {
                    // InternalPreprocess.g:4571:1: (lv_expr_1_0= rulePostfixExpression )
                    // InternalPreprocess.g:4572:3: lv_expr_1_0= rulePostfixExpression
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
                    // InternalPreprocess.g:4592:1: ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
                    {
                    // InternalPreprocess.g:4592:1: ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
                    // InternalPreprocess.g:4593:1: ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) )
                    {
                    // InternalPreprocess.g:4593:1: ( (lv_op_2_0= ruleUnaryOperator ) )
                    // InternalPreprocess.g:4594:1: (lv_op_2_0= ruleUnaryOperator )
                    {
                    // InternalPreprocess.g:4594:1: (lv_op_2_0= ruleUnaryOperator )
                    // InternalPreprocess.g:4595:3: lv_op_2_0= ruleUnaryOperator
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

                    // InternalPreprocess.g:4614:1: ( (lv_expr_3_0= ruleCastExpression ) )
                    // InternalPreprocess.g:4615:1: (lv_expr_3_0= ruleCastExpression )
                    {
                    // InternalPreprocess.g:4615:1: (lv_expr_3_0= ruleCastExpression )
                    // InternalPreprocess.g:4616:3: lv_expr_3_0= ruleCastExpression
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
    // InternalPreprocess.g:4648:1: entryRuleUnaryOperator returns [EObject current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final EObject entryRuleUnaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperator = null;


        try {
            // InternalPreprocess.g:4649:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalPreprocess.g:4650:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
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
    // InternalPreprocess.g:4657:1: ruleUnaryOperator returns [EObject current=null] : ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) ) ;
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
            // InternalPreprocess.g:4663:7: ( ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) ) )
            // InternalPreprocess.g:4665:1: ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) )
            {
            // InternalPreprocess.g:4665:1: ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) )
            int alt83=6;
            switch ( input.LA(1) ) {
            case RULE_SKW_AND:
                {
                alt83=1;
                }
                break;
            case RULE_SKW_STAR:
                {
                alt83=2;
                }
                break;
            case RULE_SKW_PLUS:
                {
                alt83=3;
                }
                break;
            case RULE_SKW_MINUS:
                {
                alt83=4;
                }
                break;
            case RULE_SKW_TILDE:
                {
                alt83=5;
                }
                break;
            case RULE_SKW_NOT:
                {
                alt83=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // InternalPreprocess.g:4666:1: ( () ( (lv_op_1_0= RULE_SKW_AND ) ) )
                    {
                    // InternalPreprocess.g:4666:1: ( () ( (lv_op_1_0= RULE_SKW_AND ) ) )
                    // InternalPreprocess.g:4667:1: () ( (lv_op_1_0= RULE_SKW_AND ) )
                    {
                    // InternalPreprocess.g:4667:1: ()
                    // InternalPreprocess.g:4668:2: 
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

                    // InternalPreprocess.g:4679:1: ( (lv_op_1_0= RULE_SKW_AND ) )
                    // InternalPreprocess.g:4680:1: (lv_op_1_0= RULE_SKW_AND )
                    {
                    // InternalPreprocess.g:4680:1: (lv_op_1_0= RULE_SKW_AND )
                    // InternalPreprocess.g:4681:3: lv_op_1_0= RULE_SKW_AND
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
                    // InternalPreprocess.g:4703:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
                    {
                    // InternalPreprocess.g:4703:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
                    // InternalPreprocess.g:4704:1: (lv_op_2_0= RULE_SKW_STAR )
                    {
                    // InternalPreprocess.g:4704:1: (lv_op_2_0= RULE_SKW_STAR )
                    // InternalPreprocess.g:4705:3: lv_op_2_0= RULE_SKW_STAR
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
                    // InternalPreprocess.g:4725:1: ( (lv_op_3_0= RULE_SKW_PLUS ) )
                    {
                    // InternalPreprocess.g:4725:1: ( (lv_op_3_0= RULE_SKW_PLUS ) )
                    // InternalPreprocess.g:4726:1: (lv_op_3_0= RULE_SKW_PLUS )
                    {
                    // InternalPreprocess.g:4726:1: (lv_op_3_0= RULE_SKW_PLUS )
                    // InternalPreprocess.g:4727:3: lv_op_3_0= RULE_SKW_PLUS
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
                    // InternalPreprocess.g:4747:1: ( (lv_op_4_0= RULE_SKW_MINUS ) )
                    {
                    // InternalPreprocess.g:4747:1: ( (lv_op_4_0= RULE_SKW_MINUS ) )
                    // InternalPreprocess.g:4748:1: (lv_op_4_0= RULE_SKW_MINUS )
                    {
                    // InternalPreprocess.g:4748:1: (lv_op_4_0= RULE_SKW_MINUS )
                    // InternalPreprocess.g:4749:3: lv_op_4_0= RULE_SKW_MINUS
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
                    // InternalPreprocess.g:4769:1: ( (lv_op_5_0= RULE_SKW_TILDE ) )
                    {
                    // InternalPreprocess.g:4769:1: ( (lv_op_5_0= RULE_SKW_TILDE ) )
                    // InternalPreprocess.g:4770:1: (lv_op_5_0= RULE_SKW_TILDE )
                    {
                    // InternalPreprocess.g:4770:1: (lv_op_5_0= RULE_SKW_TILDE )
                    // InternalPreprocess.g:4771:3: lv_op_5_0= RULE_SKW_TILDE
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
                    // InternalPreprocess.g:4791:1: ( (lv_op_6_0= RULE_SKW_NOT ) )
                    {
                    // InternalPreprocess.g:4791:1: ( (lv_op_6_0= RULE_SKW_NOT ) )
                    // InternalPreprocess.g:4792:1: (lv_op_6_0= RULE_SKW_NOT )
                    {
                    // InternalPreprocess.g:4792:1: (lv_op_6_0= RULE_SKW_NOT )
                    // InternalPreprocess.g:4793:3: lv_op_6_0= RULE_SKW_NOT
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
    // InternalPreprocess.g:4821:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalPreprocess.g:4822:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalPreprocess.g:4823:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalPreprocess.g:4830:1: rulePostfixExpression returns [EObject current=null] : ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;

        EObject lv_suffix_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4836:7: ( ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) ) )
            // InternalPreprocess.g:4838:1: ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) )
            {
            // InternalPreprocess.g:4838:1: ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) )
            // InternalPreprocess.g:4839:1: () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* )
            {
            // InternalPreprocess.g:4839:1: ()
            // InternalPreprocess.g:4840:2: 
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

            // InternalPreprocess.g:4851:1: ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* )
            // InternalPreprocess.g:4852:1: ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )*
            {
            // InternalPreprocess.g:4852:1: ( (lv_expr_1_0= rulePrimaryExpression ) )
            // InternalPreprocess.g:4853:1: (lv_expr_1_0= rulePrimaryExpression )
            {
            // InternalPreprocess.g:4853:1: (lv_expr_1_0= rulePrimaryExpression )
            // InternalPreprocess.g:4854:3: lv_expr_1_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getExprPrimaryExpressionParserRuleCall_1_0_0()); 
              	    
            }
            pushFollow(FOLLOW_39);
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

            // InternalPreprocess.g:4873:1: ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==RULE_SKW_LEFTPAREN) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalPreprocess.g:4874:1: (lv_suffix_2_0= rulePostfixExpressionSuffixArgument )
            	    {
            	    // InternalPreprocess.g:4874:1: (lv_suffix_2_0= rulePostfixExpressionSuffixArgument )
            	    // InternalPreprocess.g:4875:3: lv_suffix_2_0= rulePostfixExpressionSuffixArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getSuffixPostfixExpressionSuffixArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_39);
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
            	    break loop84;
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
    // InternalPreprocess.g:4905:1: entryRulePostfixExpressionSuffixArgument returns [EObject current=null] : iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF ;
    public final EObject entryRulePostfixExpressionSuffixArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpressionSuffixArgument = null;


        try {
            // InternalPreprocess.g:4906:2: (iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF )
            // InternalPreprocess.g:4907:2: iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF
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
    // InternalPreprocess.g:4914:1: rulePostfixExpressionSuffixArgument returns [EObject current=null] : ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN ) ;
    public final EObject rulePostfixExpressionSuffixArgument() throws RecognitionException {
        EObject current = null;

        Token this_SKW_LEFTPAREN_1=null;
        Token this_SKW_RIGHTPAREN_3=null;
        EObject lv_argumentExpressionList_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4920:7: ( ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN ) )
            // InternalPreprocess.g:4922:1: ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN )
            {
            // InternalPreprocess.g:4922:1: ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN )
            // InternalPreprocess.g:4923:1: () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN
            {
            // InternalPreprocess.g:4923:1: ()
            // InternalPreprocess.g:4924:2: 
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
            // InternalPreprocess.g:4942:1: ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==RULE_SKW_LEFTPAREN||LA85_0==RULE_ID||LA85_0==RULE_DEFINED||LA85_0==RULE_SKW_AND||(LA85_0>=RULE_SKW_PLUS && LA85_0<=RULE_SKW_STAR)||(LA85_0>=RULE_SKW_TILDE && LA85_0<=RULE_BIN_LITERAL)) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalPreprocess.g:4943:1: (lv_argumentExpressionList_2_0= ruleArgumentExpressionList )
                    {
                    // InternalPreprocess.g:4943:1: (lv_argumentExpressionList_2_0= ruleArgumentExpressionList )
                    // InternalPreprocess.g:4944:3: lv_argumentExpressionList_2_0= ruleArgumentExpressionList
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
    // InternalPreprocess.g:4979:1: entryRuleArgumentExpressionList returns [EObject current=null] : iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF ;
    public final EObject entryRuleArgumentExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentExpressionList = null;


        try {
            // InternalPreprocess.g:4980:2: (iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF )
            // InternalPreprocess.g:4981:2: iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF
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
    // InternalPreprocess.g:4988:1: ruleArgumentExpressionList returns [EObject current=null] : ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* ) ;
    public final EObject ruleArgumentExpressionList() throws RecognitionException {
        EObject current = null;

        Token this_SKW_COMMA_1=null;
        EObject lv_expr_0_0 = null;

        EObject lv_expr_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4994:7: ( ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* ) )
            // InternalPreprocess.g:4996:1: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* )
            {
            // InternalPreprocess.g:4996:1: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* )
            // InternalPreprocess.g:4997:1: ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )*
            {
            // InternalPreprocess.g:4997:1: ( (lv_expr_0_0= ruleConditionalExpression ) )
            // InternalPreprocess.g:4998:1: (lv_expr_0_0= ruleConditionalExpression )
            {
            // InternalPreprocess.g:4998:1: (lv_expr_0_0= ruleConditionalExpression )
            // InternalPreprocess.g:4999:3: lv_expr_0_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArgumentExpressionListAccess().getExprConditionalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_40);
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

            // InternalPreprocess.g:5018:1: (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==RULE_SKW_COMMA) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // InternalPreprocess.g:5019:1: this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) )
            	    {
            	    this_SKW_COMMA_1=(Token)match(input,RULE_SKW_COMMA,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_COMMA_1, grammarAccess.getArgumentExpressionListAccess().getSKW_COMMATerminalRuleCall_1_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:5026:1: ( (lv_expr_2_0= ruleConditionalExpression ) )
            	    // InternalPreprocess.g:5027:1: (lv_expr_2_0= ruleConditionalExpression )
            	    {
            	    // InternalPreprocess.g:5027:1: (lv_expr_2_0= ruleConditionalExpression )
            	    // InternalPreprocess.g:5028:3: lv_expr_2_0= ruleConditionalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArgumentExpressionListAccess().getExprConditionalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_40);
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
            	    break loop86;
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
    // InternalPreprocess.g:5058:1: entryRuleConstant1 returns [String current=null] : iv_ruleConstant1= ruleConstant1 EOF ;
    public final String entryRuleConstant1() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConstant1 = null;


        try {
            // InternalPreprocess.g:5059:2: (iv_ruleConstant1= ruleConstant1 EOF )
            // InternalPreprocess.g:5060:2: iv_ruleConstant1= ruleConstant1 EOF
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
    // InternalPreprocess.g:5067:1: ruleConstant1 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL ) ;
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
            // InternalPreprocess.g:5070:28: ( (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL ) )
            // InternalPreprocess.g:5071:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL )
            {
            // InternalPreprocess.g:5071:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL )
            int alt87=7;
            switch ( input.LA(1) ) {
            case RULE_HEX_LITERAL:
                {
                alt87=1;
                }
                break;
            case RULE_OCTAL_LITERAL:
                {
                alt87=2;
                }
                break;
            case RULE_DECIMAL_LITERAL:
                {
                alt87=3;
                }
                break;
            case RULE_CHAR_LITERAL:
                {
                alt87=4;
                }
                break;
            case RULE_STRING_LITERAL:
                {
                alt87=5;
                }
                break;
            case RULE_FLOAT_LITERAL:
                {
                alt87=6;
                }
                break;
            case RULE_BIN_LITERAL:
                {
                alt87=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // InternalPreprocess.g:5071:6: this_HEX_LITERAL_0= RULE_HEX_LITERAL
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
                    // InternalPreprocess.g:5079:10: this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL
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
                    // InternalPreprocess.g:5087:10: this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL
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
                    // InternalPreprocess.g:5095:10: this_CHAR_LITERAL_3= RULE_CHAR_LITERAL
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
                    // InternalPreprocess.g:5103:10: this_STRING_LITERAL_4= RULE_STRING_LITERAL
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
                    // InternalPreprocess.g:5111:10: this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL
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
                    // InternalPreprocess.g:5119:10: this_BIN_LITERAL_6= RULE_BIN_LITERAL
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
    // InternalPreprocess.g:5136:1: entryRuleSpecialKeywords returns [String current=null] : iv_ruleSpecialKeywords= ruleSpecialKeywords EOF ;
    public final String entryRuleSpecialKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpecialKeywords = null;


        try {
            // InternalPreprocess.g:5137:2: (iv_ruleSpecialKeywords= ruleSpecialKeywords EOF )
            // InternalPreprocess.g:5138:2: iv_ruleSpecialKeywords= ruleSpecialKeywords EOF
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
    // InternalPreprocess.g:5145:1: ruleSpecialKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE ) ;
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
            // InternalPreprocess.g:5148:28: ( (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE ) )
            // InternalPreprocess.g:5149:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE )
            {
            // InternalPreprocess.g:5149:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE )
            int alt88=37;
            switch ( input.LA(1) ) {
            case RULE_SKW_AND:
                {
                alt88=1;
                }
                break;
            case RULE_SKW_ANDAND:
                {
                alt88=2;
                }
                break;
            case RULE_SKW_ASSIGN:
                {
                alt88=3;
                }
                break;
            case RULE_SKW_BACKSLASH:
                {
                alt88=4;
                }
                break;
            case RULE_SKW_CARET:
                {
                alt88=5;
                }
                break;
            case RULE_SKW_COMMA:
                {
                alt88=6;
                }
                break;
            case RULE_SKW_COLON:
                {
                alt88=7;
                }
                break;
            case RULE_SKW_DIV:
                {
                alt88=8;
                }
                break;
            case RULE_SKW_DOT:
                {
                alt88=9;
                }
                break;
            case RULE_SKW_DOUBLEQUOTE:
                {
                alt88=10;
                }
                break;
            case RULE_SKW_EQUAL:
                {
                alt88=11;
                }
                break;
            case RULE_SKW_GREATER:
                {
                alt88=12;
                }
                break;
            case RULE_SKW_GREATEREQUAL:
                {
                alt88=13;
                }
                break;
            case RULE_SKW_LEFTBRACE:
                {
                alt88=14;
                }
                break;
            case RULE_SKW_LEFTBRACKET:
                {
                alt88=15;
                }
                break;
            case RULE_SKW_LEFTPAREN:
                {
                alt88=16;
                }
                break;
            case RULE_SKW_LEFTSHIFT:
                {
                alt88=17;
                }
                break;
            case RULE_SKW_LESS:
                {
                alt88=18;
                }
                break;
            case RULE_SKW_LESSEQUAL:
                {
                alt88=19;
                }
                break;
            case RULE_SKW_MINUS:
                {
                alt88=20;
                }
                break;
            case RULE_SKW_MINUSMINUS:
                {
                alt88=21;
                }
                break;
            case RULE_SKW_MOD:
                {
                alt88=22;
                }
                break;
            case RULE_SKW_NOT:
                {
                alt88=23;
                }
                break;
            case RULE_SKW_NOTEQUAL:
                {
                alt88=24;
                }
                break;
            case RULE_SKW_OR:
                {
                alt88=25;
                }
                break;
            case RULE_SKW_OROR:
                {
                alt88=26;
                }
                break;
            case RULE_SKW_PLUS:
                {
                alt88=27;
                }
                break;
            case RULE_SKW_PLUSPLUS:
                {
                alt88=28;
                }
                break;
            case RULE_SKW_QUESTION:
                {
                alt88=29;
                }
                break;
            case RULE_SKW_RIGHTBRACE:
                {
                alt88=30;
                }
                break;
            case RULE_SKW_RIGHTBRACKET:
                {
                alt88=31;
                }
                break;
            case RULE_SKW_RIGHTPAREN:
                {
                alt88=32;
                }
                break;
            case RULE_SKW_RIGHTSHIFT:
                {
                alt88=33;
                }
                break;
            case RULE_SKW_SEMI:
                {
                alt88=34;
                }
                break;
            case RULE_SKW_SINGLEQUOTE:
                {
                alt88=35;
                }
                break;
            case RULE_SKW_STAR:
                {
                alt88=36;
                }
                break;
            case RULE_SKW_TILDE:
                {
                alt88=37;
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
                    // InternalPreprocess.g:5149:6: this_SKW_AND_0= RULE_SKW_AND
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
                    // InternalPreprocess.g:5157:10: this_SKW_ANDAND_1= RULE_SKW_ANDAND
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
                    // InternalPreprocess.g:5165:10: this_SKW_ASSIGN_2= RULE_SKW_ASSIGN
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
                    // InternalPreprocess.g:5173:10: this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH
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
                    // InternalPreprocess.g:5181:10: this_SKW_CARET_4= RULE_SKW_CARET
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
                    // InternalPreprocess.g:5189:10: this_SKW_COMMA_5= RULE_SKW_COMMA
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
                    // InternalPreprocess.g:5197:10: this_SKW_COLON_6= RULE_SKW_COLON
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
                    // InternalPreprocess.g:5205:10: this_SKW_DIV_7= RULE_SKW_DIV
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
                    // InternalPreprocess.g:5213:10: this_SKW_DOT_8= RULE_SKW_DOT
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
                    // InternalPreprocess.g:5221:10: this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE
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
                    // InternalPreprocess.g:5229:10: this_SKW_EQUAL_10= RULE_SKW_EQUAL
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
                    // InternalPreprocess.g:5237:10: this_SKW_GREATER_11= RULE_SKW_GREATER
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
                    // InternalPreprocess.g:5245:10: this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL
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
                    // InternalPreprocess.g:5253:10: this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE
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
                    // InternalPreprocess.g:5261:10: this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET
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
                    // InternalPreprocess.g:5269:10: this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN
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
                    // InternalPreprocess.g:5277:10: this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT
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
                    // InternalPreprocess.g:5285:10: this_SKW_LESS_17= RULE_SKW_LESS
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
                    // InternalPreprocess.g:5293:10: this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL
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
                    // InternalPreprocess.g:5301:10: this_SKW_MINUS_19= RULE_SKW_MINUS
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
                    // InternalPreprocess.g:5309:10: this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS
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
                    // InternalPreprocess.g:5317:10: this_SKW_MOD_21= RULE_SKW_MOD
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
                    // InternalPreprocess.g:5325:10: this_SKW_NOT_22= RULE_SKW_NOT
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
                    // InternalPreprocess.g:5333:10: this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL
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
                    // InternalPreprocess.g:5341:10: this_SKW_OR_24= RULE_SKW_OR
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
                    // InternalPreprocess.g:5349:10: this_SKW_OROR_25= RULE_SKW_OROR
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
                    // InternalPreprocess.g:5357:10: this_SKW_PLUS_26= RULE_SKW_PLUS
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
                    // InternalPreprocess.g:5365:10: this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS
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
                    // InternalPreprocess.g:5373:10: this_SKW_QUESTION_28= RULE_SKW_QUESTION
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
                    // InternalPreprocess.g:5381:10: this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE
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
                    // InternalPreprocess.g:5389:10: this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET
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
                    // InternalPreprocess.g:5397:10: this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN
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
                    // InternalPreprocess.g:5405:10: this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT
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
                    // InternalPreprocess.g:5413:10: this_SKW_SEMI_33= RULE_SKW_SEMI
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
                    // InternalPreprocess.g:5421:10: this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE
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
                    // InternalPreprocess.g:5429:10: this_SKW_STAR_35= RULE_SKW_STAR
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
                    // InternalPreprocess.g:5437:10: this_SKW_TILDE_36= RULE_SKW_TILDE
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
    // InternalPreprocess.g:5452:1: entryRuleEllipsis returns [String current=null] : iv_ruleEllipsis= ruleEllipsis EOF ;
    public final String entryRuleEllipsis() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEllipsis = null;


        try {
            // InternalPreprocess.g:5453:2: (iv_ruleEllipsis= ruleEllipsis EOF )
            // InternalPreprocess.g:5454:2: iv_ruleEllipsis= ruleEllipsis EOF
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
    // InternalPreprocess.g:5461:1: ruleEllipsis returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_DOT_0= RULE_SKW_DOT this_SKW_DOT_1= RULE_SKW_DOT this_SKW_DOT_2= RULE_SKW_DOT ) ;
    public final AntlrDatatypeRuleToken ruleEllipsis() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_DOT_0=null;
        Token this_SKW_DOT_1=null;
        Token this_SKW_DOT_2=null;

         enterRule(); 
            
        try {
            // InternalPreprocess.g:5464:28: ( (this_SKW_DOT_0= RULE_SKW_DOT this_SKW_DOT_1= RULE_SKW_DOT this_SKW_DOT_2= RULE_SKW_DOT ) )
            // InternalPreprocess.g:5465:1: (this_SKW_DOT_0= RULE_SKW_DOT this_SKW_DOT_1= RULE_SKW_DOT this_SKW_DOT_2= RULE_SKW_DOT )
            {
            // InternalPreprocess.g:5465:1: (this_SKW_DOT_0= RULE_SKW_DOT this_SKW_DOT_1= RULE_SKW_DOT this_SKW_DOT_2= RULE_SKW_DOT )
            // InternalPreprocess.g:5465:6: this_SKW_DOT_0= RULE_SKW_DOT this_SKW_DOT_1= RULE_SKW_DOT this_SKW_DOT_2= RULE_SKW_DOT
            {
            this_SKW_DOT_0=(Token)match(input,RULE_SKW_DOT,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_SKW_DOT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SKW_DOT_0, grammarAccess.getEllipsisAccess().getSKW_DOTTerminalRuleCall_0()); 
                  
            }
            this_SKW_DOT_1=(Token)match(input,RULE_SKW_DOT,FOLLOW_41); if (state.failed) return current;
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

    // $ANTLR start synpred2_InternalPreprocess
    public final void synpred2_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_NEWLINE_2=null;
        EObject lv_lines_1_0 = null;


        // InternalPreprocess.g:235:1: ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )
        // InternalPreprocess.g:235:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE
        {
        // InternalPreprocess.g:235:1: ( (lv_lines_1_0= ruleGroupOptTemp1 ) )
        // InternalPreprocess.g:236:1: (lv_lines_1_0= ruleGroupOptTemp1 )
        {
        // InternalPreprocess.g:236:1: (lv_lines_1_0= ruleGroupOptTemp1 )
        // InternalPreprocess.g:237:3: lv_lines_1_0= ruleGroupOptTemp1
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

        // InternalPreprocess.g:702:2: (this_WHITESPACE_2= RULE_WHITESPACE )
        // InternalPreprocess.g:702:2: this_WHITESPACE_2= RULE_WHITESPACE
        {
        this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalPreprocess

    // $ANTLR start synpred19_InternalPreprocess
    public final void synpred19_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_4=null;

        // InternalPreprocess.g:863:2: (this_WHITESPACE_4= RULE_WHITESPACE )
        // InternalPreprocess.g:863:2: this_WHITESPACE_4= RULE_WHITESPACE
        {
        this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_InternalPreprocess

    // $ANTLR start synpred24_InternalPreprocess
    public final void synpred24_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_8=null;

        // InternalPreprocess.g:1010:2: (this_WHITESPACE_8= RULE_WHITESPACE )
        // InternalPreprocess.g:1010:2: this_WHITESPACE_8= RULE_WHITESPACE
        {
        this_WHITESPACE_8=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_InternalPreprocess

    // $ANTLR start synpred25_InternalPreprocess
    public final void synpred25_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_8=null;
        AntlrDatatypeRuleToken lv_string_9_0 = null;


        // InternalPreprocess.g:1010:1: ( (this_WHITESPACE_8= RULE_WHITESPACE )* ( (lv_string_9_0= ruleMyDefineLine ) ) )
        // InternalPreprocess.g:1010:1: (this_WHITESPACE_8= RULE_WHITESPACE )* ( (lv_string_9_0= ruleMyDefineLine ) )
        {
        // InternalPreprocess.g:1010:1: (this_WHITESPACE_8= RULE_WHITESPACE )*
        loop90:
        do {
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_WHITESPACE) ) {
                int LA90_2 = input.LA(2);

                if ( (synpred24_InternalPreprocess()) ) {
                    alt90=1;
                }


            }


            switch (alt90) {
        	case 1 :
        	    // InternalPreprocess.g:1010:2: this_WHITESPACE_8= RULE_WHITESPACE
        	    {
        	    this_WHITESPACE_8=(Token)match(input,RULE_WHITESPACE,FOLLOW_11); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop90;
            }
        } while (true);

        // InternalPreprocess.g:1017:1: ( (lv_string_9_0= ruleMyDefineLine ) )
        // InternalPreprocess.g:1018:1: (lv_string_9_0= ruleMyDefineLine )
        {
        // InternalPreprocess.g:1018:1: (lv_string_9_0= ruleMyDefineLine )
        // InternalPreprocess.g:1019:3: lv_string_9_0= ruleMyDefineLine
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getDefineFunctionLikeMacroAccess().getStringMyDefineLineParserRuleCall_8_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_string_9_0=ruleMyDefineLine();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred25_InternalPreprocess

    // $ANTLR start synpred35_InternalPreprocess
    public final void synpred35_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_2=null;

        // InternalPreprocess.g:1337:2: (this_WHITESPACE_2= RULE_WHITESPACE )
        // InternalPreprocess.g:1337:2: this_WHITESPACE_2= RULE_WHITESPACE
        {
        this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_InternalPreprocess

    // $ANTLR start synpred37_InternalPreprocess
    public final void synpred37_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_2=null;

        // InternalPreprocess.g:1411:2: (this_WHITESPACE_2= RULE_WHITESPACE )
        // InternalPreprocess.g:1411:2: this_WHITESPACE_2= RULE_WHITESPACE
        {
        this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_InternalPreprocess

    // $ANTLR start synpred61_InternalPreprocess
    public final void synpred61_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_2=null;

        // InternalPreprocess.g:2298:2: (this_WHITESPACE_2= RULE_WHITESPACE )
        // InternalPreprocess.g:2298:2: this_WHITESPACE_2= RULE_WHITESPACE
        {
        this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred61_InternalPreprocess

    // $ANTLR start synpred81_InternalPreprocess
    public final void synpred81_InternalPreprocess_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_MyCode_0 = null;


        // InternalPreprocess.g:2685:5: (this_MyCode_0= ruleMyCode )
        // InternalPreprocess.g:2685:5: this_MyCode_0= ruleMyCode
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
    // $ANTLR end synpred81_InternalPreprocess

    // $ANTLR start synpred82_InternalPreprocess
    public final void synpred82_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_1=null;

        // InternalPreprocess.g:2696:10: (this_WHITESPACE_1= RULE_WHITESPACE )
        // InternalPreprocess.g:2696:10: this_WHITESPACE_1= RULE_WHITESPACE
        {
        this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred82_InternalPreprocess

    // $ANTLR start synpred86_InternalPreprocess
    public final void synpred86_InternalPreprocess_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_MyCode_1 = null;


        // InternalPreprocess.g:2804:5: (this_MyCode_1= ruleMyCode )
        // InternalPreprocess.g:2804:5: this_MyCode_1= ruleMyCode
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
    // $ANTLR end synpred86_InternalPreprocess

    // $ANTLR start synpred92_InternalPreprocess
    public final void synpred92_InternalPreprocess_fragment() throws RecognitionException {   
        Token lv_defined_3_0=null;
        Token this_SKW_LEFTPAREN_4=null;
        Token lv_id_5_0=null;
        Token this_SKW_RIGHTPAREN_6=null;

        // InternalPreprocess.g:2918:1: ( ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) )
        // InternalPreprocess.g:2918:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
        {
        // InternalPreprocess.g:2918:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
        // InternalPreprocess.g:2919:1: ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN
        {
        // InternalPreprocess.g:2919:1: ( (lv_defined_3_0= RULE_DEFINED ) )?
        int alt103=2;
        int LA103_0 = input.LA(1);

        if ( (LA103_0==RULE_DEFINED) ) {
            alt103=1;
        }
        switch (alt103) {
            case 1 :
                // InternalPreprocess.g:2920:1: (lv_defined_3_0= RULE_DEFINED )
                {
                // InternalPreprocess.g:2920:1: (lv_defined_3_0= RULE_DEFINED )
                // InternalPreprocess.g:2921:3: lv_defined_3_0= RULE_DEFINED
                {
                lv_defined_3_0=(Token)match(input,RULE_DEFINED,FOLLOW_12); if (state.failed) return ;

                }


                }
                break;

        }

        this_SKW_LEFTPAREN_4=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_26); if (state.failed) return ;
        // InternalPreprocess.g:2947:1: ( (lv_id_5_0= RULE_ID ) )
        // InternalPreprocess.g:2948:1: (lv_id_5_0= RULE_ID )
        {
        // InternalPreprocess.g:2948:1: (lv_id_5_0= RULE_ID )
        // InternalPreprocess.g:2949:3: lv_id_5_0= RULE_ID
        {
        lv_id_5_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return ;

        }


        }

        this_SKW_RIGHTPAREN_6=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred92_InternalPreprocess

    // Delegated rules

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
    public final boolean synpred82_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred82_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_InternalPreprocess_fragment(); // can never throw exception
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
    public final boolean synpred81_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred81_InternalPreprocess_fragment(); // can never throw exception
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
    public final boolean synpred37_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalPreprocess_fragment(); // can never throw exception
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
    public final boolean synpred35_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalPreprocess_fragment(); // can never throw exception
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
    public final boolean synpred92_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_InternalPreprocess_fragment(); // can never throw exception
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


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA57 dfa57 = new DFA57(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA61 dfa61 = new DFA61(this);
    static final String DFA1_eotS =
        "\6\uffff";
    static final String DFA1_eofS =
        "\1\1\5\uffff";
    static final String DFA1_minS =
        "\1\4\1\uffff\2\4\1\uffff\1\4";
    static final String DFA1_maxS =
        "\1\102\1\uffff\1\102\1\26\1\uffff\1\26";
    static final String DFA1_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\1\uffff";
    static final String DFA1_specialS =
        "\6\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\4\1\2\1\3\7\4\2\uffff\11\4\1\uffff\51\4",
            "",
            "\1\4\1\2\1\3\7\4\2\uffff\11\4\1\uffff\51\4",
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
            return "()* loopback of 164:1: ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )*";
        }
    }
    static final String DFA2_eotS =
        "\76\uffff";
    static final String DFA2_eofS =
        "\1\74\75\uffff";
    static final String DFA2_minS =
        "\1\4\73\0\2\uffff";
    static final String DFA2_maxS =
        "\1\102\73\0\2\uffff";
    static final String DFA2_acceptS =
        "\74\uffff\1\2\1\1";
    static final String DFA2_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\2\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\75\1\1\1\2\1\5\1\6\1\37\1\57\1\3\1\25\1\7\2\uffff\1\12\1\14\1\11\1\13\1\16\1\17\1\10\1\4\1\15\1\uffff\1\54\1\26\1\51\1\21\1\50\1\24\1\20\1\32\1\47\1\41\1\33\1\42\1\34\1\40\1\60\1\52\1\43\1\63\1\27\1\45\1\64\1\46\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\22\1\23\1\30\1\31\1\35\1\36\1\44\1\53\1\55\1\56\1\61\1\62",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            return "()* loopback of 234:1: ( ( (lv_lines_1_0= ruleGroupOptTemp1 ) ) this_NEWLINE_2= RULE_NEWLINE )*";
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
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA2_2 = input.LA(1);

                         
                        int index2_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA2_3 = input.LA(1);

                         
                        int index2_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA2_4 = input.LA(1);

                         
                        int index2_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA2_5 = input.LA(1);

                         
                        int index2_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA2_6 = input.LA(1);

                         
                        int index2_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA2_7 = input.LA(1);

                         
                        int index2_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA2_8 = input.LA(1);

                         
                        int index2_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA2_9 = input.LA(1);

                         
                        int index2_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA2_10 = input.LA(1);

                         
                        int index2_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA2_11 = input.LA(1);

                         
                        int index2_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA2_12 = input.LA(1);

                         
                        int index2_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA2_13 = input.LA(1);

                         
                        int index2_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA2_14 = input.LA(1);

                         
                        int index2_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA2_15 = input.LA(1);

                         
                        int index2_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA2_16 = input.LA(1);

                         
                        int index2_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA2_17 = input.LA(1);

                         
                        int index2_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA2_18 = input.LA(1);

                         
                        int index2_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA2_19 = input.LA(1);

                         
                        int index2_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA2_20 = input.LA(1);

                         
                        int index2_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA2_21 = input.LA(1);

                         
                        int index2_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA2_22 = input.LA(1);

                         
                        int index2_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA2_23 = input.LA(1);

                         
                        int index2_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA2_24 = input.LA(1);

                         
                        int index2_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA2_25 = input.LA(1);

                         
                        int index2_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA2_26 = input.LA(1);

                         
                        int index2_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA2_27 = input.LA(1);

                         
                        int index2_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA2_28 = input.LA(1);

                         
                        int index2_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA2_29 = input.LA(1);

                         
                        int index2_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_29);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA2_30 = input.LA(1);

                         
                        int index2_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_30);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA2_31 = input.LA(1);

                         
                        int index2_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_31);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA2_32 = input.LA(1);

                         
                        int index2_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_32);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA2_33 = input.LA(1);

                         
                        int index2_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_33);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA2_34 = input.LA(1);

                         
                        int index2_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_34);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA2_35 = input.LA(1);

                         
                        int index2_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_35);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA2_36 = input.LA(1);

                         
                        int index2_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_36);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA2_37 = input.LA(1);

                         
                        int index2_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_37);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA2_38 = input.LA(1);

                         
                        int index2_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_38);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA2_39 = input.LA(1);

                         
                        int index2_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_39);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA2_40 = input.LA(1);

                         
                        int index2_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_40);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA2_41 = input.LA(1);

                         
                        int index2_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_41);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA2_42 = input.LA(1);

                         
                        int index2_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_42);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA2_43 = input.LA(1);

                         
                        int index2_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_43);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA2_44 = input.LA(1);

                         
                        int index2_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_44);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA2_45 = input.LA(1);

                         
                        int index2_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_45);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA2_46 = input.LA(1);

                         
                        int index2_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_46);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA2_47 = input.LA(1);

                         
                        int index2_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_47);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA2_48 = input.LA(1);

                         
                        int index2_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_48);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA2_49 = input.LA(1);

                         
                        int index2_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_49);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA2_50 = input.LA(1);

                         
                        int index2_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_50);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA2_51 = input.LA(1);

                         
                        int index2_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_51);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA2_52 = input.LA(1);

                         
                        int index2_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_52);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA2_53 = input.LA(1);

                         
                        int index2_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_53);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA2_54 = input.LA(1);

                         
                        int index2_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_54);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA2_55 = input.LA(1);

                         
                        int index2_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_55);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA2_56 = input.LA(1);

                         
                        int index2_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_56);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA2_57 = input.LA(1);

                         
                        int index2_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_57);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA2_58 = input.LA(1);

                         
                        int index2_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_58);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA2_59 = input.LA(1);

                         
                        int index2_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index2_59);
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
        "\2\102\3\uffff";
    static final String DFA4_acceptS =
        "\2\uffff\1\1\1\2\1\3";
    static final String DFA4_specialS =
        "\5\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\3\1\1\1\2\7\4\2\uffff\11\4\1\uffff\51\4",
            "\1\4\1\1\1\2\7\4\2\uffff\11\4\1\uffff\51\4",
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
            return "312:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_NewLineLine_1= ruleNewLineLine | this_Code_2= ruleCode )";
        }
    }
    static final String DFA5_eotS =
        "\4\uffff";
    static final String DFA5_eofS =
        "\1\uffff\1\3\2\uffff";
    static final String DFA5_minS =
        "\2\5\2\uffff";
    static final String DFA5_maxS =
        "\2\102\2\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA5_specialS =
        "\4\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1\1\2\7\3\2\uffff\11\3\1\uffff\51\3",
            "\1\1\1\2\7\3\2\uffff\11\3\1\uffff\51\3",
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
            return "386:1: (this_PreprocessorDirectives_0= rulePreprocessorDirectives | this_Code_1= ruleCode )";
        }
    }
    static final String DFA10_eotS =
        "\76\uffff";
    static final String DFA10_eofS =
        "\3\uffff\71\74\2\uffff";
    static final String DFA10_minS =
        "\1\10\2\5\71\4\2\uffff";
    static final String DFA10_maxS =
        "\1\10\1\5\1\102\71\11\2\uffff";
    static final String DFA10_acceptS =
        "\74\uffff\1\1\1\2";
    static final String DFA10_specialS =
        "\76\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1",
            "\1\2",
            "\1\2\1\uffff\1\5\1\6\1\37\1\57\1\3\1\25\1\7\2\uffff\1\12\1\14\1\11\1\13\1\16\1\17\1\10\1\4\1\15\1\uffff\1\54\1\26\1\51\1\21\1\50\1\24\1\20\1\32\1\47\1\41\1\33\1\42\1\34\1\40\1\60\1\52\1\43\1\63\1\27\1\45\1\64\1\46\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\22\1\23\1\30\1\31\1\35\1\36\1\44\1\53\1\55\1\56\1\61\1\62",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
            "\2\74\3\uffff\1\75",
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
            return "756:1: (this_DefineObjectMacro_0= ruleDefineObjectMacro | this_DefineFunctionLikeMacro_1= ruleDefineFunctionLikeMacro )";
        }
    }
    static final String DFA21_eotS =
        "\7\uffff";
    static final String DFA21_eofS =
        "\2\3\3\uffff\1\6\1\uffff";
    static final String DFA21_minS =
        "\3\5\1\uffff\2\5\1\uffff";
    static final String DFA21_maxS =
        "\2\14\1\71\1\uffff\2\71\1\uffff";
    static final String DFA21_acceptS =
        "\3\uffff\1\2\2\uffff\1\1";
    static final String DFA21_specialS =
        "\7\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\1\4\uffff\1\3\1\uffff\1\2",
            "\1\1\4\uffff\1\3\1\uffff\1\2",
            "\1\4\5\uffff\1\5\55\uffff\1\3",
            "",
            "\1\4\5\uffff\1\5\55\uffff\1\3",
            "\1\6\4\uffff\1\6\1\uffff\1\6\54\uffff\1\3",
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
            return "()* loopback of 1102:1: ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )*";
        }
    }
    static final String DFA35_eotS =
        "\6\uffff";
    static final String DFA35_eofS =
        "\6\uffff";
    static final String DFA35_minS =
        "\4\5\2\uffff";
    static final String DFA35_maxS =
        "\2\6\2\25\2\uffff";
    static final String DFA35_acceptS =
        "\4\uffff\1\2\1\1";
    static final String DFA35_specialS =
        "\6\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\1\1\2",
            "\1\1\1\2",
            "\1\3\12\uffff\1\4\3\uffff\1\5\1\4",
            "\1\3\12\uffff\1\4\3\uffff\1\5\1\4",
            "",
            ""
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "()* loopback of 1613:1: ( (lv_elifs_2_0= ruleElIfConditional ) )*";
        }
    }
    static final String DFA36_eotS =
        "\6\uffff";
    static final String DFA36_eofS =
        "\6\uffff";
    static final String DFA36_minS =
        "\4\5\2\uffff";
    static final String DFA36_maxS =
        "\2\6\2\25\2\uffff";
    static final String DFA36_acceptS =
        "\4\uffff\1\1\1\2";
    static final String DFA36_specialS =
        "\6\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\1\2",
            "\1\1\1\2",
            "\1\3\12\uffff\1\5\4\uffff\1\4",
            "\1\3\12\uffff\1\5\4\uffff\1\4",
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
            return "1634:1: ( (lv_else_3_0= ruleElseConditional ) )?";
        }
    }
    static final String DFA57_eotS =
        "\76\uffff";
    static final String DFA57_eofS =
        "\1\1\75\uffff";
    static final String DFA57_minS =
        "\1\4\1\uffff\72\0\2\uffff";
    static final String DFA57_maxS =
        "\1\102\1\uffff\72\0\2\uffff";
    static final String DFA57_acceptS =
        "\1\uffff\1\3\72\uffff\1\1\1\2";
    static final String DFA57_specialS =
        "\2\uffff\1\41\1\14\1\60\1\31\1\2\1\42\1\36\1\57\1\46\1\4\1\45\1\13\1\25\1\12\1\23\1\64\1\15\1\43\1\66\1\21\1\47\1\32\1\7\1\56\1\16\1\65\1\40\1\5\1\70\1\17\1\11\1\37\1\30\1\61\1\51\1\6\1\71\1\27\1\1\1\53\1\24\1\67\1\44\1\22\1\50\1\10\1\34\1\62\1\3\1\20\1\55\1\63\1\33\1\52\1\0\1\26\1\54\1\35\2\uffff}>";
    static final String[] DFA57_transitionS = {
            "\1\1\1\73\1\1\1\4\1\5\1\36\1\56\1\2\1\24\1\6\2\uffff\1\11\1\13\1\10\1\12\1\15\1\16\1\7\1\3\1\14\1\uffff\1\53\1\25\1\50\1\20\1\47\1\23\1\17\1\31\1\46\1\40\1\32\1\41\1\33\1\37\1\57\1\51\1\42\1\62\1\26\1\44\1\63\1\45\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\21\1\22\1\27\1\30\1\34\1\35\1\43\1\52\1\54\1\55\1\60\1\61",
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
            "",
            ""
    };

    static final short[] DFA57_eot = DFA.unpackEncodedString(DFA57_eotS);
    static final short[] DFA57_eof = DFA.unpackEncodedString(DFA57_eofS);
    static final char[] DFA57_min = DFA.unpackEncodedStringToUnsignedChars(DFA57_minS);
    static final char[] DFA57_max = DFA.unpackEncodedStringToUnsignedChars(DFA57_maxS);
    static final short[] DFA57_accept = DFA.unpackEncodedString(DFA57_acceptS);
    static final short[] DFA57_special = DFA.unpackEncodedString(DFA57_specialS);
    static final short[][] DFA57_transition;

    static {
        int numStates = DFA57_transitionS.length;
        DFA57_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA57_transition[i] = DFA.unpackEncodedString(DFA57_transitionS[i]);
        }
    }

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = DFA57_eot;
            this.eof = DFA57_eof;
            this.min = DFA57_min;
            this.max = DFA57_max;
            this.accept = DFA57_accept;
            this.special = DFA57_special;
            this.transition = DFA57_transition;
        }
        public String getDescription() {
            return "()+ loopback of 2684:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA57_56 = input.LA(1);

                         
                        int index57_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_56);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA57_40 = input.LA(1);

                         
                        int index57_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_40);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA57_6 = input.LA(1);

                         
                        int index57_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA57_50 = input.LA(1);

                         
                        int index57_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_50);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA57_11 = input.LA(1);

                         
                        int index57_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_11);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA57_29 = input.LA(1);

                         
                        int index57_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_29);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA57_37 = input.LA(1);

                         
                        int index57_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_37);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA57_24 = input.LA(1);

                         
                        int index57_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_24);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA57_47 = input.LA(1);

                         
                        int index57_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_47);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA57_32 = input.LA(1);

                         
                        int index57_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_32);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA57_15 = input.LA(1);

                         
                        int index57_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_15);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA57_13 = input.LA(1);

                         
                        int index57_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_13);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA57_3 = input.LA(1);

                         
                        int index57_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_3);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA57_18 = input.LA(1);

                         
                        int index57_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_18);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA57_26 = input.LA(1);

                         
                        int index57_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_26);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA57_31 = input.LA(1);

                         
                        int index57_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_31);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA57_51 = input.LA(1);

                         
                        int index57_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_51);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA57_21 = input.LA(1);

                         
                        int index57_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_21);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA57_45 = input.LA(1);

                         
                        int index57_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_45);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA57_16 = input.LA(1);

                         
                        int index57_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_16);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA57_42 = input.LA(1);

                         
                        int index57_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_42);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA57_14 = input.LA(1);

                         
                        int index57_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_14);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA57_57 = input.LA(1);

                         
                        int index57_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_57);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA57_39 = input.LA(1);

                         
                        int index57_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_39);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA57_34 = input.LA(1);

                         
                        int index57_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_34);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA57_5 = input.LA(1);

                         
                        int index57_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_5);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA57_23 = input.LA(1);

                         
                        int index57_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_23);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA57_54 = input.LA(1);

                         
                        int index57_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_54);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA57_48 = input.LA(1);

                         
                        int index57_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_48);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA57_59 = input.LA(1);

                         
                        int index57_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_59);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA57_8 = input.LA(1);

                         
                        int index57_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_8);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA57_33 = input.LA(1);

                         
                        int index57_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_33);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA57_28 = input.LA(1);

                         
                        int index57_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_28);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA57_2 = input.LA(1);

                         
                        int index57_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_2);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA57_7 = input.LA(1);

                         
                        int index57_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_7);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA57_19 = input.LA(1);

                         
                        int index57_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_19);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA57_44 = input.LA(1);

                         
                        int index57_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_44);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA57_12 = input.LA(1);

                         
                        int index57_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_12);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA57_10 = input.LA(1);

                         
                        int index57_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_10);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA57_22 = input.LA(1);

                         
                        int index57_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_22);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA57_46 = input.LA(1);

                         
                        int index57_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_46);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA57_36 = input.LA(1);

                         
                        int index57_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_36);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA57_55 = input.LA(1);

                         
                        int index57_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_55);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA57_41 = input.LA(1);

                         
                        int index57_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_41);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA57_58 = input.LA(1);

                         
                        int index57_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_58);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA57_52 = input.LA(1);

                         
                        int index57_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_52);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA57_25 = input.LA(1);

                         
                        int index57_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_25);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA57_9 = input.LA(1);

                         
                        int index57_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_9);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA57_4 = input.LA(1);

                         
                        int index57_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_4);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA57_35 = input.LA(1);

                         
                        int index57_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_35);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA57_49 = input.LA(1);

                         
                        int index57_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_49);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA57_53 = input.LA(1);

                         
                        int index57_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_53);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA57_17 = input.LA(1);

                         
                        int index57_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_17);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA57_27 = input.LA(1);

                         
                        int index57_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_27);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA57_20 = input.LA(1);

                         
                        int index57_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_20);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA57_43 = input.LA(1);

                         
                        int index57_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_43);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA57_30 = input.LA(1);

                         
                        int index57_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_30);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA57_38 = input.LA(1);

                         
                        int index57_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalPreprocess()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_38);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 57, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA58_eotS =
        "\4\uffff";
    static final String DFA58_eofS =
        "\1\uffff\1\3\2\uffff";
    static final String DFA58_minS =
        "\1\5\1\4\2\uffff";
    static final String DFA58_maxS =
        "\2\102\2\uffff";
    static final String DFA58_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA58_specialS =
        "\4\uffff}>";
    static final String[] DFA58_transitionS = {
            "\1\1\1\uffff\7\2\2\uffff\11\2\1\uffff\51\2",
            "\1\3\1\1\1\uffff\7\2\2\uffff\11\2\1\uffff\51\2",
            "",
            ""
    };

    static final short[] DFA58_eot = DFA.unpackEncodedString(DFA58_eotS);
    static final short[] DFA58_eof = DFA.unpackEncodedString(DFA58_eofS);
    static final char[] DFA58_min = DFA.unpackEncodedStringToUnsignedChars(DFA58_minS);
    static final char[] DFA58_max = DFA.unpackEncodedStringToUnsignedChars(DFA58_maxS);
    static final short[] DFA58_accept = DFA.unpackEncodedString(DFA58_acceptS);
    static final short[] DFA58_special = DFA.unpackEncodedString(DFA58_specialS);
    static final short[][] DFA58_transition;

    static {
        int numStates = DFA58_transitionS.length;
        DFA58_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA58_transition[i] = DFA.unpackEncodedString(DFA58_transitionS[i]);
        }
    }

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = DFA58_eot;
            this.eof = DFA58_eof;
            this.min = DFA58_min;
            this.max = DFA58_max;
            this.accept = DFA58_accept;
            this.special = DFA58_special;
            this.transition = DFA58_transition;
        }
        public String getDescription() {
            return "2724:1: (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal )";
        }
    }
    static final String DFA61_eotS =
        "\74\uffff";
    static final String DFA61_eofS =
        "\1\72\73\uffff";
    static final String DFA61_minS =
        "\1\4\71\0\2\uffff";
    static final String DFA61_maxS =
        "\1\102\71\0\2\uffff";
    static final String DFA61_acceptS =
        "\72\uffff\1\2\1\1";
    static final String DFA61_specialS =
        "\1\uffff\1\16\1\57\1\11\1\35\1\64\1\14\1\56\1\32\1\4\1\43\1\15\1\63\1\47\1\7\1\17\1\67\1\5\1\13\1\22\1\66\1\3\1\40\1\51\1\23\1\45\1\2\1\30\1\52\1\21\1\70\1\36\1\6\1\55\1\20\1\12\1\37\1\24\1\53\1\44\1\65\1\1\1\50\1\60\1\31\1\41\1\0\1\25\1\61\1\10\1\27\1\46\1\62\1\26\1\34\1\54\1\42\1\33\2\uffff}>";
    static final String[] DFA61_transitionS = {
            "\3\72\1\3\1\4\1\35\1\55\1\1\1\23\1\5\2\uffff\1\10\1\12\1\7\1\11\1\14\1\15\1\6\1\2\1\13\1\uffff\1\52\1\24\1\47\1\17\1\46\1\22\1\16\1\30\1\45\1\37\1\31\1\40\1\32\1\36\1\56\1\50\1\41\1\61\1\25\1\43\1\62\1\44\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\20\1\21\1\26\1\27\1\33\1\34\1\42\1\51\1\53\1\54\1\57\1\60",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            return "()+ loopback of 2803:3: (this_MyCode_1= ruleMyCode )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_46 = input.LA(1);

                         
                        int index61_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_46);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA61_41 = input.LA(1);

                         
                        int index61_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_41);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA61_26 = input.LA(1);

                         
                        int index61_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_26);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA61_21 = input.LA(1);

                         
                        int index61_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_21);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA61_9 = input.LA(1);

                         
                        int index61_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_9);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA61_17 = input.LA(1);

                         
                        int index61_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_17);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA61_32 = input.LA(1);

                         
                        int index61_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_32);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA61_14 = input.LA(1);

                         
                        int index61_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_14);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA61_49 = input.LA(1);

                         
                        int index61_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_49);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA61_3 = input.LA(1);

                         
                        int index61_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_3);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA61_35 = input.LA(1);

                         
                        int index61_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_35);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA61_18 = input.LA(1);

                         
                        int index61_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_18);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA61_6 = input.LA(1);

                         
                        int index61_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_6);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA61_11 = input.LA(1);

                         
                        int index61_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_11);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA61_1 = input.LA(1);

                         
                        int index61_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_1);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA61_15 = input.LA(1);

                         
                        int index61_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_15);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA61_34 = input.LA(1);

                         
                        int index61_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_34);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA61_29 = input.LA(1);

                         
                        int index61_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_29);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA61_19 = input.LA(1);

                         
                        int index61_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA61_24 = input.LA(1);

                         
                        int index61_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_24);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA61_37 = input.LA(1);

                         
                        int index61_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_37);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA61_47 = input.LA(1);

                         
                        int index61_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_47);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA61_53 = input.LA(1);

                         
                        int index61_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_53);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA61_50 = input.LA(1);

                         
                        int index61_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_50);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA61_27 = input.LA(1);

                         
                        int index61_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_27);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA61_44 = input.LA(1);

                         
                        int index61_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_44);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA61_8 = input.LA(1);

                         
                        int index61_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_8);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA61_57 = input.LA(1);

                         
                        int index61_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_57);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA61_54 = input.LA(1);

                         
                        int index61_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_54);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA61_4 = input.LA(1);

                         
                        int index61_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_4);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA61_31 = input.LA(1);

                         
                        int index61_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_31);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA61_36 = input.LA(1);

                         
                        int index61_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_36);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA61_22 = input.LA(1);

                         
                        int index61_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_22);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA61_45 = input.LA(1);

                         
                        int index61_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_45);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA61_56 = input.LA(1);

                         
                        int index61_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_56);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA61_10 = input.LA(1);

                         
                        int index61_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_10);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA61_39 = input.LA(1);

                         
                        int index61_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_39);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA61_25 = input.LA(1);

                         
                        int index61_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_25);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA61_51 = input.LA(1);

                         
                        int index61_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_51);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA61_13 = input.LA(1);

                         
                        int index61_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_13);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA61_42 = input.LA(1);

                         
                        int index61_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_42);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA61_23 = input.LA(1);

                         
                        int index61_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_23);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA61_28 = input.LA(1);

                         
                        int index61_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_28);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA61_38 = input.LA(1);

                         
                        int index61_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_38);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA61_55 = input.LA(1);

                         
                        int index61_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_55);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA61_33 = input.LA(1);

                         
                        int index61_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_33);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA61_7 = input.LA(1);

                         
                        int index61_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_7);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA61_2 = input.LA(1);

                         
                        int index61_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_2);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA61_43 = input.LA(1);

                         
                        int index61_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_43);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA61_48 = input.LA(1);

                         
                        int index61_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_48);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA61_52 = input.LA(1);

                         
                        int index61_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_52);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA61_12 = input.LA(1);

                         
                        int index61_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_12);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA61_5 = input.LA(1);

                         
                        int index61_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_5);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA61_40 = input.LA(1);

                         
                        int index61_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_40);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA61_20 = input.LA(1);

                         
                        int index61_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_20);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA61_16 = input.LA(1);

                         
                        int index61_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_16);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA61_30 = input.LA(1);

                         
                        int index61_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalPreprocess()) ) {s = 59;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index61_30);
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
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0xFFFFFFFFFDFF3FE2L,0x0000000000000007L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0xFFFFFFFFFDFF3FF2L,0x0000000000000007L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000004EE1A0L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0xFFFFFFFFFDFF3FE0L,0x0000000000000007L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0xFFFFFFFFFFFF3FE0L,0x0000000000000007L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0200000000000C20L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0xFFFFFFFFFFFF3FE2L,0x0000000000000007L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000001022L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0200000000000820L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0200000000000800L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0xFFFFFFFFFDFF3FF0L,0x0000000000000007L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000200020L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000007800000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000018000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000380000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0200000000000000L});

}