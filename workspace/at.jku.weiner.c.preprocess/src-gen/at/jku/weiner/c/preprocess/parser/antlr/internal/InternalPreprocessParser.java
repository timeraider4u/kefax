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

            if ( ((LA3_0>=RULE_WHITESPACE && LA3_0<=RULE_DEFINED)||(LA3_0>=RULE_SKW_QUESTION && LA3_0<=RULE_SKW_SINGLEQUOTE)) ) {
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
    // InternalPreprocess.g:806:1: ruleDefineObjectMacro returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine2 ) ) )? (this_WHITESPACE_6= RULE_WHITESPACE )* ) ;
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
            // InternalPreprocess.g:812:7: ( ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine2 ) ) )? (this_WHITESPACE_6= RULE_WHITESPACE )* ) )
            // InternalPreprocess.g:814:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine2 ) ) )? (this_WHITESPACE_6= RULE_WHITESPACE )* )
            {
            // InternalPreprocess.g:814:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine2 ) ) )? (this_WHITESPACE_6= RULE_WHITESPACE )* )
            // InternalPreprocess.g:815:1: () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine2 ) ) )? (this_WHITESPACE_6= RULE_WHITESPACE )*
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

            // InternalPreprocess.g:862:1: ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine2 ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_WHITESPACE) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==RULE_WHITESPACE) ) {
                    int LA13_3 = input.LA(3);

                    if ( (synpred20_InternalPreprocess()) ) {
                        alt13=1;
                    }
                }
                else if ( ((LA13_1>=RULE_INCLUDE && LA13_1<=RULE_DEFINED)||(LA13_1>=RULE_SKW_QUESTION && LA13_1<=RULE_SKW_SINGLEQUOTE)) ) {
                    alt13=1;
                }
            }
            switch (alt13) {
                case 1 :
                    // InternalPreprocess.g:863:1: (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine2 ) )
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

                    // InternalPreprocess.g:870:1: ( (lv_string_5_0= ruleMyDefineLine2 ) )
                    // InternalPreprocess.g:871:1: (lv_string_5_0= ruleMyDefineLine2 )
                    {
                    // InternalPreprocess.g:871:1: (lv_string_5_0= ruleMyDefineLine2 )
                    // InternalPreprocess.g:872:3: lv_string_5_0= ruleMyDefineLine2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefineObjectMacroAccess().getStringMyDefineLine2ParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_10);
                    lv_string_5_0=ruleMyDefineLine2();

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
                              		"at.jku.weiner.c.preprocess.Preprocess.MyDefineLine2");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalPreprocess.g:893:1: (this_WHITESPACE_6= RULE_WHITESPACE )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_WHITESPACE) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalPreprocess.g:893:2: this_WHITESPACE_6= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_6=(Token)match(input,RULE_WHITESPACE,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_6, grammarAccess.getDefineObjectMacroAccess().getWHITESPACETerminalRuleCall_5()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end "ruleDefineObjectMacro"


    // $ANTLR start "entryRuleDefineFunctionLikeMacro"
    // InternalPreprocess.g:909:1: entryRuleDefineFunctionLikeMacro returns [EObject current=null] : iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF ;
    public final EObject entryRuleDefineFunctionLikeMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineFunctionLikeMacro = null;


        try {
            // InternalPreprocess.g:910:2: (iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF )
            // InternalPreprocess.g:911:2: iv_ruleDefineFunctionLikeMacro= ruleDefineFunctionLikeMacro EOF
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
    // InternalPreprocess.g:918:1: ruleDefineFunctionLikeMacro returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN ( (lv_replacement_8_0= ruleReplaceLine ) )* ) ;
    public final EObject ruleDefineFunctionLikeMacro() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_1=null;
        Token this_WHITESPACE_2=null;
        Token this_SKW_LEFTPAREN_4=null;
        Token this_WHITESPACE_5=null;
        Token this_SKW_RIGHTPAREN_7=null;
        AntlrDatatypeRuleToken lv_id_3_0 = null;

        EObject lv_list_6_0 = null;

        EObject lv_replacement_8_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:924:7: ( ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN ( (lv_replacement_8_0= ruleReplaceLine ) )* ) )
            // InternalPreprocess.g:926:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN ( (lv_replacement_8_0= ruleReplaceLine ) )* )
            {
            // InternalPreprocess.g:926:1: ( () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN ( (lv_replacement_8_0= ruleReplaceLine ) )* )
            // InternalPreprocess.g:927:1: () this_DEFINE_1= RULE_DEFINE (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= ruleMyCode ) ) this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN (this_WHITESPACE_5= RULE_WHITESPACE )* ( (lv_list_6_0= ruleIdentifierList ) )? this_SKW_RIGHTPAREN_7= RULE_SKW_RIGHTPAREN ( (lv_replacement_8_0= ruleReplaceLine ) )*
            {
            // InternalPreprocess.g:927:1: ()
            // InternalPreprocess.g:928:2: 
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
            // InternalPreprocess.g:946:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_WHITESPACE) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalPreprocess.g:946:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getDefineFunctionLikeMacroAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            // InternalPreprocess.g:953:1: ( (lv_id_3_0= ruleMyCode ) )
            // InternalPreprocess.g:954:1: (lv_id_3_0= ruleMyCode )
            {
            // InternalPreprocess.g:954:1: (lv_id_3_0= ruleMyCode )
            // InternalPreprocess.g:955:3: lv_id_3_0= ruleMyCode
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
            // InternalPreprocess.g:981:1: (this_WHITESPACE_5= RULE_WHITESPACE )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_WHITESPACE) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalPreprocess.g:981:2: this_WHITESPACE_5= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_5=(Token)match(input,RULE_WHITESPACE,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_5, grammarAccess.getDefineFunctionLikeMacroAccess().getWHITESPACETerminalRuleCall_5()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // InternalPreprocess.g:988:1: ( (lv_list_6_0= ruleIdentifierList ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID||LA17_0==RULE_SKW_DOT) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalPreprocess.g:989:1: (lv_list_6_0= ruleIdentifierList )
                    {
                    // InternalPreprocess.g:989:1: (lv_list_6_0= ruleIdentifierList )
                    // InternalPreprocess.g:990:3: lv_list_6_0= ruleIdentifierList
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
            // InternalPreprocess.g:1016:1: ( (lv_replacement_8_0= ruleReplaceLine ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_WHITESPACE||(LA18_0>=RULE_INCLUDE && LA18_0<=RULE_SKW_SINGLEQUOTE)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalPreprocess.g:1017:1: (lv_replacement_8_0= ruleReplaceLine )
            	    {
            	    // InternalPreprocess.g:1017:1: (lv_replacement_8_0= ruleReplaceLine )
            	    // InternalPreprocess.g:1018:3: lv_replacement_8_0= ruleReplaceLine
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDefineFunctionLikeMacroAccess().getReplacementReplaceLineParserRuleCall_8_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_replacement_8_0=ruleReplaceLine();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDefineFunctionLikeMacroRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"replacement",
            	              		lv_replacement_8_0, 
            	              		"at.jku.weiner.c.preprocess.Preprocess.ReplaceLine");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // $ANTLR end "ruleDefineFunctionLikeMacro"


    // $ANTLR start "entryRuleIdentifierList"
    // InternalPreprocess.g:1046:1: entryRuleIdentifierList returns [EObject current=null] : iv_ruleIdentifierList= ruleIdentifierList EOF ;
    public final EObject entryRuleIdentifierList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierList = null;


        try {
            // InternalPreprocess.g:1047:2: (iv_ruleIdentifierList= ruleIdentifierList EOF )
            // InternalPreprocess.g:1048:2: iv_ruleIdentifierList= ruleIdentifierList EOF
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
    // InternalPreprocess.g:1055:1: ruleIdentifierList returns [EObject current=null] : ( () ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) ) ) ;
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
            // InternalPreprocess.g:1061:7: ( ( () ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) ) ) )
            // InternalPreprocess.g:1063:1: ( () ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) ) )
            {
            // InternalPreprocess.g:1063:1: ( () ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) ) )
            // InternalPreprocess.g:1064:1: () ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) )
            {
            // InternalPreprocess.g:1064:1: ()
            // InternalPreprocess.g:1065:2: 
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

            // InternalPreprocess.g:1076:1: ( ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? ) | ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) ) )
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
                    // InternalPreprocess.g:1077:1: ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? )
                    {
                    // InternalPreprocess.g:1077:1: ( ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )? )
                    // InternalPreprocess.g:1078:1: ( (lv_id_1_0= RULE_ID ) ) ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )* (this_WHITESPACE_6= RULE_WHITESPACE )* (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )?
                    {
                    // InternalPreprocess.g:1078:1: ( (lv_id_1_0= RULE_ID ) )
                    // InternalPreprocess.g:1079:1: (lv_id_1_0= RULE_ID )
                    {
                    // InternalPreprocess.g:1079:1: (lv_id_1_0= RULE_ID )
                    // InternalPreprocess.g:1080:3: lv_id_1_0= RULE_ID
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

                    // InternalPreprocess.g:1099:1: ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        alt21 = dfa21.predict(input);
                        switch (alt21) {
                    	case 1 :
                    	    // InternalPreprocess.g:1100:1: (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) )
                    	    {
                    	    // InternalPreprocess.g:1100:1: (this_WHITESPACE_2= RULE_WHITESPACE )*
                    	    loop19:
                    	    do {
                    	        int alt19=2;
                    	        int LA19_0 = input.LA(1);

                    	        if ( (LA19_0==RULE_WHITESPACE) ) {
                    	            alt19=1;
                    	        }


                    	        switch (alt19) {
                    	    	case 1 :
                    	    	    // InternalPreprocess.g:1100:2: this_WHITESPACE_2= RULE_WHITESPACE
                    	    	    {
                    	    	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_16); if (state.failed) return current;
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIdentifierListAccess().getWHITESPACETerminalRuleCall_1_0_1_0()); 
                    	    	          
                    	    	    }

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop19;
                    	        }
                    	    } while (true);

                    	    this_SKW_COMMA_3=(Token)match(input,RULE_SKW_COMMA,FOLLOW_17); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_SKW_COMMA_3, grammarAccess.getIdentifierListAccess().getSKW_COMMATerminalRuleCall_1_0_1_1()); 
                    	          
                    	    }
                    	    // InternalPreprocess.g:1114:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
                    	    loop20:
                    	    do {
                    	        int alt20=2;
                    	        int LA20_0 = input.LA(1);

                    	        if ( (LA20_0==RULE_WHITESPACE) ) {
                    	            alt20=1;
                    	        }


                    	        switch (alt20) {
                    	    	case 1 :
                    	    	    // InternalPreprocess.g:1114:2: this_WHITESPACE_4= RULE_WHITESPACE
                    	    	    {
                    	    	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_17); if (state.failed) return current;
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	          newLeafNode(this_WHITESPACE_4, grammarAccess.getIdentifierListAccess().getWHITESPACETerminalRuleCall_1_0_1_2()); 
                    	    	          
                    	    	    }

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop20;
                    	        }
                    	    } while (true);

                    	    // InternalPreprocess.g:1121:1: ( (lv_id_5_0= RULE_ID ) )
                    	    // InternalPreprocess.g:1122:1: (lv_id_5_0= RULE_ID )
                    	    {
                    	    // InternalPreprocess.g:1122:1: (lv_id_5_0= RULE_ID )
                    	    // InternalPreprocess.g:1123:3: lv_id_5_0= RULE_ID
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
                    	    break loop21;
                        }
                    } while (true);

                    // InternalPreprocess.g:1144:1: (this_WHITESPACE_6= RULE_WHITESPACE )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==RULE_WHITESPACE) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalPreprocess.g:1144:2: this_WHITESPACE_6= RULE_WHITESPACE
                    	    {
                    	    this_WHITESPACE_6=(Token)match(input,RULE_WHITESPACE,FOLLOW_15); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_WHITESPACE_6, grammarAccess.getIdentifierListAccess().getWHITESPACETerminalRuleCall_1_0_2()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    // InternalPreprocess.g:1151:1: (this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==RULE_SKW_COMMA) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // InternalPreprocess.g:1152:1: this_SKW_COMMA_7= RULE_SKW_COMMA (this_WHITESPACE_8= RULE_WHITESPACE )* ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) )
                            {
                            this_SKW_COMMA_7=(Token)match(input,RULE_SKW_COMMA,FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_SKW_COMMA_7, grammarAccess.getIdentifierListAccess().getSKW_COMMATerminalRuleCall_1_0_3_0()); 
                                  
                            }
                            // InternalPreprocess.g:1159:1: (this_WHITESPACE_8= RULE_WHITESPACE )*
                            loop23:
                            do {
                                int alt23=2;
                                int LA23_0 = input.LA(1);

                                if ( (LA23_0==RULE_WHITESPACE) ) {
                                    alt23=1;
                                }


                                switch (alt23) {
                            	case 1 :
                            	    // InternalPreprocess.g:1159:2: this_WHITESPACE_8= RULE_WHITESPACE
                            	    {
                            	    this_WHITESPACE_8=(Token)match(input,RULE_WHITESPACE,FOLLOW_18); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {
                            	       
                            	          newLeafNode(this_WHITESPACE_8, grammarAccess.getIdentifierListAccess().getWHITESPACETerminalRuleCall_1_0_3_1()); 
                            	          
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop23;
                                }
                            } while (true);

                            // InternalPreprocess.g:1166:1: ( ( (lv_variadic_9_0= ruleEllipsis ) ) | ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) ) )
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
                                    // InternalPreprocess.g:1167:1: ( (lv_variadic_9_0= ruleEllipsis ) )
                                    {
                                    // InternalPreprocess.g:1167:1: ( (lv_variadic_9_0= ruleEllipsis ) )
                                    // InternalPreprocess.g:1168:1: (lv_variadic_9_0= ruleEllipsis )
                                    {
                                    // InternalPreprocess.g:1168:1: (lv_variadic_9_0= ruleEllipsis )
                                    // InternalPreprocess.g:1169:3: lv_variadic_9_0= ruleEllipsis
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
                                    // InternalPreprocess.g:1189:1: ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) )
                                    {
                                    // InternalPreprocess.g:1189:1: ( ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) ) )
                                    // InternalPreprocess.g:1190:1: ( (lv_varID_10_0= RULE_ID ) ) ( (lv_variadic_11_0= ruleEllipsis ) )
                                    {
                                    // InternalPreprocess.g:1190:1: ( (lv_varID_10_0= RULE_ID ) )
                                    // InternalPreprocess.g:1191:1: (lv_varID_10_0= RULE_ID )
                                    {
                                    // InternalPreprocess.g:1191:1: (lv_varID_10_0= RULE_ID )
                                    // InternalPreprocess.g:1192:3: lv_varID_10_0= RULE_ID
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

                                    // InternalPreprocess.g:1211:1: ( (lv_variadic_11_0= ruleEllipsis ) )
                                    // InternalPreprocess.g:1212:1: (lv_variadic_11_0= ruleEllipsis )
                                    {
                                    // InternalPreprocess.g:1212:1: (lv_variadic_11_0= ruleEllipsis )
                                    // InternalPreprocess.g:1213:3: lv_variadic_11_0= ruleEllipsis
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
                    // InternalPreprocess.g:1241:1: ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) )
                    {
                    // InternalPreprocess.g:1241:1: ( ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) ) )
                    // InternalPreprocess.g:1242:1: ( (lv_varID_12_0= RULE_ID ) )? ( (lv_variadic_13_0= ruleEllipsis ) )
                    {
                    // InternalPreprocess.g:1242:1: ( (lv_varID_12_0= RULE_ID ) )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==RULE_ID) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalPreprocess.g:1243:1: (lv_varID_12_0= RULE_ID )
                            {
                            // InternalPreprocess.g:1243:1: (lv_varID_12_0= RULE_ID )
                            // InternalPreprocess.g:1244:3: lv_varID_12_0= RULE_ID
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

                    // InternalPreprocess.g:1263:1: ( (lv_variadic_13_0= ruleEllipsis ) )
                    // InternalPreprocess.g:1264:1: (lv_variadic_13_0= ruleEllipsis )
                    {
                    // InternalPreprocess.g:1264:1: (lv_variadic_13_0= ruleEllipsis )
                    // InternalPreprocess.g:1265:3: lv_variadic_13_0= ruleEllipsis
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


    // $ANTLR start "entryRuleReplaceLine"
    // InternalPreprocess.g:1297:1: entryRuleReplaceLine returns [EObject current=null] : iv_ruleReplaceLine= ruleReplaceLine EOF ;
    public final EObject entryRuleReplaceLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReplaceLine = null;


        try {
            // InternalPreprocess.g:1298:2: (iv_ruleReplaceLine= ruleReplaceLine EOF )
            // InternalPreprocess.g:1299:2: iv_ruleReplaceLine= ruleReplaceLine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReplaceLineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReplaceLine=ruleReplaceLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReplaceLine; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReplaceLine"


    // $ANTLR start "ruleReplaceLine"
    // InternalPreprocess.g:1306:1: ruleReplaceLine returns [EObject current=null] : ( () ( (lv_string_1_0= ruleMyDefineLine ) ) (this_HASH_2= RULE_HASH ( ( (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) ) | ( (lv_concatenate_5_0= RULE_HASH ) ) ) )? ) ;
    public final EObject ruleReplaceLine() throws RecognitionException {
        EObject current = null;

        Token this_HASH_2=null;
        Token this_WHITESPACE_3=null;
        Token lv_id_4_0=null;
        Token lv_concatenate_5_0=null;
        AntlrDatatypeRuleToken lv_string_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1312:7: ( ( () ( (lv_string_1_0= ruleMyDefineLine ) ) (this_HASH_2= RULE_HASH ( ( (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) ) | ( (lv_concatenate_5_0= RULE_HASH ) ) ) )? ) )
            // InternalPreprocess.g:1314:1: ( () ( (lv_string_1_0= ruleMyDefineLine ) ) (this_HASH_2= RULE_HASH ( ( (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) ) | ( (lv_concatenate_5_0= RULE_HASH ) ) ) )? )
            {
            // InternalPreprocess.g:1314:1: ( () ( (lv_string_1_0= ruleMyDefineLine ) ) (this_HASH_2= RULE_HASH ( ( (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) ) | ( (lv_concatenate_5_0= RULE_HASH ) ) ) )? )
            // InternalPreprocess.g:1315:1: () ( (lv_string_1_0= ruleMyDefineLine ) ) (this_HASH_2= RULE_HASH ( ( (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) ) | ( (lv_concatenate_5_0= RULE_HASH ) ) ) )?
            {
            // InternalPreprocess.g:1315:1: ()
            // InternalPreprocess.g:1316:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReplaceLineAccess().getReplaceLineAction_0(),
                          current);
                  
            }

            }

            // InternalPreprocess.g:1327:1: ( (lv_string_1_0= ruleMyDefineLine ) )
            // InternalPreprocess.g:1328:1: (lv_string_1_0= ruleMyDefineLine )
            {
            // InternalPreprocess.g:1328:1: (lv_string_1_0= ruleMyDefineLine )
            // InternalPreprocess.g:1329:3: lv_string_1_0= ruleMyDefineLine
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReplaceLineAccess().getStringMyDefineLineParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_20);
            lv_string_1_0=ruleMyDefineLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getReplaceLineRule());
              	        }
                     		set(
                     			current, 
                     			"string",
                      		lv_string_1_0, 
                      		"at.jku.weiner.c.preprocess.Preprocess.MyDefineLine");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalPreprocess.g:1348:1: (this_HASH_2= RULE_HASH ( ( (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) ) | ( (lv_concatenate_5_0= RULE_HASH ) ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_HASH) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalPreprocess.g:1349:1: this_HASH_2= RULE_HASH ( ( (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) ) | ( (lv_concatenate_5_0= RULE_HASH ) ) )
                    {
                    this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HASH_2, grammarAccess.getReplaceLineAccess().getHASHTerminalRuleCall_2_0()); 
                          
                    }
                    // InternalPreprocess.g:1356:1: ( ( (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) ) | ( (lv_concatenate_5_0= RULE_HASH ) ) )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==RULE_WHITESPACE||LA29_0==RULE_ID) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==RULE_HASH) ) {
                        alt29=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalPreprocess.g:1357:1: ( (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) )
                            {
                            // InternalPreprocess.g:1357:1: ( (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) ) )
                            // InternalPreprocess.g:1358:1: (this_WHITESPACE_3= RULE_WHITESPACE )* ( (lv_id_4_0= RULE_ID ) )
                            {
                            // InternalPreprocess.g:1358:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
                            loop28:
                            do {
                                int alt28=2;
                                int LA28_0 = input.LA(1);

                                if ( (LA28_0==RULE_WHITESPACE) ) {
                                    alt28=1;
                                }


                                switch (alt28) {
                            	case 1 :
                            	    // InternalPreprocess.g:1358:2: this_WHITESPACE_3= RULE_WHITESPACE
                            	    {
                            	    this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_17); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {
                            	       
                            	          newLeafNode(this_WHITESPACE_3, grammarAccess.getReplaceLineAccess().getWHITESPACETerminalRuleCall_2_1_0_0()); 
                            	          
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop28;
                                }
                            } while (true);

                            // InternalPreprocess.g:1365:1: ( (lv_id_4_0= RULE_ID ) )
                            // InternalPreprocess.g:1366:1: (lv_id_4_0= RULE_ID )
                            {
                            // InternalPreprocess.g:1366:1: (lv_id_4_0= RULE_ID )
                            // InternalPreprocess.g:1367:3: lv_id_4_0= RULE_ID
                            {
                            lv_id_4_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_id_4_0, grammarAccess.getReplaceLineAccess().getIdIDTerminalRuleCall_2_1_0_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getReplaceLineRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"id",
                                      		lv_id_4_0, 
                                      		"at.jku.weiner.c.common.Common.ID");
                              	    
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalPreprocess.g:1389:1: ( (lv_concatenate_5_0= RULE_HASH ) )
                            {
                            // InternalPreprocess.g:1389:1: ( (lv_concatenate_5_0= RULE_HASH ) )
                            // InternalPreprocess.g:1390:1: (lv_concatenate_5_0= RULE_HASH )
                            {
                            // InternalPreprocess.g:1390:1: (lv_concatenate_5_0= RULE_HASH )
                            // InternalPreprocess.g:1391:3: lv_concatenate_5_0= RULE_HASH
                            {
                            lv_concatenate_5_0=(Token)match(input,RULE_HASH,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_concatenate_5_0, grammarAccess.getReplaceLineAccess().getConcatenateHASHTerminalRuleCall_2_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getReplaceLineRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"concatenate",
                                      		true, 
                                      		"at.jku.weiner.c.preprocess.Preprocess.HASH");
                              	    
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
    // $ANTLR end "ruleReplaceLine"


    // $ANTLR start "entryRuleErrorDirective"
    // InternalPreprocess.g:1423:1: entryRuleErrorDirective returns [EObject current=null] : iv_ruleErrorDirective= ruleErrorDirective EOF ;
    public final EObject entryRuleErrorDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorDirective = null;


        try {
            // InternalPreprocess.g:1424:2: (iv_ruleErrorDirective= ruleErrorDirective EOF )
            // InternalPreprocess.g:1425:2: iv_ruleErrorDirective= ruleErrorDirective EOF
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
    // InternalPreprocess.g:1432:1: ruleErrorDirective returns [EObject current=null] : ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? ) ;
    public final EObject ruleErrorDirective() throws RecognitionException {
        EObject current = null;

        Token this_ERROR_1=null;
        Token this_WHITESPACE_2=null;
        AntlrDatatypeRuleToken lv_msg_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1438:7: ( ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? ) )
            // InternalPreprocess.g:1440:1: ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? )
            {
            // InternalPreprocess.g:1440:1: ( () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? )
            // InternalPreprocess.g:1441:1: () this_ERROR_1= RULE_ERROR (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )?
            {
            // InternalPreprocess.g:1441:1: ()
            // InternalPreprocess.g:1442:2: 
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
            // InternalPreprocess.g:1460:1: (this_WHITESPACE_2= RULE_WHITESPACE )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_WHITESPACE) ) {
                    int LA31_2 = input.LA(2);

                    if ( (synpred38_InternalPreprocess()) ) {
                        alt31=1;
                    }


                }


                switch (alt31) {
            	case 1 :
            	    // InternalPreprocess.g:1460:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getErrorDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            // InternalPreprocess.g:1467:1: ( (lv_msg_3_0= ruleMyCodeLine ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_WHITESPACE||(LA32_0>=RULE_INCLUDE && LA32_0<=RULE_DEFINED)||(LA32_0>=RULE_SKW_QUESTION && LA32_0<=RULE_SKW_SINGLEQUOTE)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalPreprocess.g:1468:1: (lv_msg_3_0= ruleMyCodeLine )
                    {
                    // InternalPreprocess.g:1468:1: (lv_msg_3_0= ruleMyCodeLine )
                    // InternalPreprocess.g:1469:3: lv_msg_3_0= ruleMyCodeLine
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
    // InternalPreprocess.g:1497:1: entryRuleWarningDirective returns [EObject current=null] : iv_ruleWarningDirective= ruleWarningDirective EOF ;
    public final EObject entryRuleWarningDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWarningDirective = null;


        try {
            // InternalPreprocess.g:1498:2: (iv_ruleWarningDirective= ruleWarningDirective EOF )
            // InternalPreprocess.g:1499:2: iv_ruleWarningDirective= ruleWarningDirective EOF
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
    // InternalPreprocess.g:1506:1: ruleWarningDirective returns [EObject current=null] : ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? ) ;
    public final EObject ruleWarningDirective() throws RecognitionException {
        EObject current = null;

        Token this_WARNING_1=null;
        Token this_WHITESPACE_2=null;
        AntlrDatatypeRuleToken lv_msg_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1512:7: ( ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? ) )
            // InternalPreprocess.g:1514:1: ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? )
            {
            // InternalPreprocess.g:1514:1: ( () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )? )
            // InternalPreprocess.g:1515:1: () this_WARNING_1= RULE_WARNING (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_msg_3_0= ruleMyCodeLine ) )?
            {
            // InternalPreprocess.g:1515:1: ()
            // InternalPreprocess.g:1516:2: 
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
            // InternalPreprocess.g:1534:1: (this_WHITESPACE_2= RULE_WHITESPACE )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_WHITESPACE) ) {
                    int LA33_2 = input.LA(2);

                    if ( (synpred40_InternalPreprocess()) ) {
                        alt33=1;
                    }


                }


                switch (alt33) {
            	case 1 :
            	    // InternalPreprocess.g:1534:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getWarningDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            // InternalPreprocess.g:1541:1: ( (lv_msg_3_0= ruleMyCodeLine ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_WHITESPACE||(LA34_0>=RULE_INCLUDE && LA34_0<=RULE_DEFINED)||(LA34_0>=RULE_SKW_QUESTION && LA34_0<=RULE_SKW_SINGLEQUOTE)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalPreprocess.g:1542:1: (lv_msg_3_0= ruleMyCodeLine )
                    {
                    // InternalPreprocess.g:1542:1: (lv_msg_3_0= ruleMyCodeLine )
                    // InternalPreprocess.g:1543:3: lv_msg_3_0= ruleMyCodeLine
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
    // InternalPreprocess.g:1571:1: entryRuleUnDefineDirective returns [EObject current=null] : iv_ruleUnDefineDirective= ruleUnDefineDirective EOF ;
    public final EObject entryRuleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnDefineDirective = null;


        try {
            // InternalPreprocess.g:1572:2: (iv_ruleUnDefineDirective= ruleUnDefineDirective EOF )
            // InternalPreprocess.g:1573:2: iv_ruleUnDefineDirective= ruleUnDefineDirective EOF
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
    // InternalPreprocess.g:1580:1: ruleUnDefineDirective returns [EObject current=null] : ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* ) ;
    public final EObject ruleUnDefineDirective() throws RecognitionException {
        EObject current = null;

        Token this_UNDEF_1=null;
        Token this_WHITESPACE_2=null;
        Token lv_id_3_0=null;
        Token this_WHITESPACE_4=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:1586:7: ( ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* ) )
            // InternalPreprocess.g:1588:1: ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* )
            {
            // InternalPreprocess.g:1588:1: ( () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* )
            // InternalPreprocess.g:1589:1: () this_UNDEF_1= RULE_UNDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )*
            {
            // InternalPreprocess.g:1589:1: ()
            // InternalPreprocess.g:1590:2: 
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
            // InternalPreprocess.g:1608:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_WHITESPACE) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalPreprocess.g:1608:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getUnDefineDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);

            // InternalPreprocess.g:1615:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:1616:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:1616:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:1617:3: lv_id_3_0= RULE_ID
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

            // InternalPreprocess.g:1636:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_WHITESPACE) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalPreprocess.g:1636:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getUnDefineDirectiveAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
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
    // InternalPreprocess.g:1652:1: entryRuleConditionalDirective returns [EObject current=null] : iv_ruleConditionalDirective= ruleConditionalDirective EOF ;
    public final EObject entryRuleConditionalDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalDirective = null;


        try {
            // InternalPreprocess.g:1653:2: (iv_ruleConditionalDirective= ruleConditionalDirective EOF )
            // InternalPreprocess.g:1654:2: iv_ruleConditionalDirective= ruleConditionalDirective EOF
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
    // InternalPreprocess.g:1661:1: ruleConditionalDirective returns [EObject current=null] : ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* ) ;
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
            // InternalPreprocess.g:1667:7: ( ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* ) )
            // InternalPreprocess.g:1669:1: ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* )
            {
            // InternalPreprocess.g:1669:1: ( () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )* )
            // InternalPreprocess.g:1670:1: () ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) ) ( (lv_elifs_2_0= ruleElIfConditional ) )* ( (lv_else_3_0= ruleElseConditional ) )? (this_WHITESPACE_4= RULE_WHITESPACE )* this_HASH_5= RULE_HASH (this_WHITESPACE_6= RULE_WHITESPACE )* this_ENDIF_7= RULE_ENDIF (this_WHITESPACE_8= RULE_WHITESPACE )*
            {
            // InternalPreprocess.g:1670:1: ()
            // InternalPreprocess.g:1671:2: 
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

            // InternalPreprocess.g:1682:1: ( ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) ) )
            // InternalPreprocess.g:1683:1: ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) )
            {
            // InternalPreprocess.g:1683:1: ( (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional ) )
            // InternalPreprocess.g:1684:1: (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional )
            {
            // InternalPreprocess.g:1684:1: (lv_conditional_1_1= ruleIfConditional | lv_conditional_1_2= ruleIfDefConditional | lv_conditional_1_3= ruleIfNotDefConditional )
            int alt37=3;
            switch ( input.LA(1) ) {
            case RULE_IF:
                {
                alt37=1;
                }
                break;
            case RULE_IFDEF:
                {
                alt37=2;
                }
                break;
            case RULE_IFNOTDEF:
                {
                alt37=3;
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
                    // InternalPreprocess.g:1685:3: lv_conditional_1_1= ruleIfConditional
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
                    // InternalPreprocess.g:1700:8: lv_conditional_1_2= ruleIfDefConditional
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
                    // InternalPreprocess.g:1715:8: lv_conditional_1_3= ruleIfNotDefConditional
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

            // InternalPreprocess.g:1736:1: ( (lv_elifs_2_0= ruleElIfConditional ) )*
            loop38:
            do {
                int alt38=2;
                alt38 = dfa38.predict(input);
                switch (alt38) {
            	case 1 :
            	    // InternalPreprocess.g:1737:1: (lv_elifs_2_0= ruleElIfConditional )
            	    {
            	    // InternalPreprocess.g:1737:1: (lv_elifs_2_0= ruleElIfConditional )
            	    // InternalPreprocess.g:1738:3: lv_elifs_2_0= ruleElIfConditional
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
            	    break loop38;
                }
            } while (true);

            // InternalPreprocess.g:1757:1: ( (lv_else_3_0= ruleElseConditional ) )?
            int alt39=2;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // InternalPreprocess.g:1758:1: (lv_else_3_0= ruleElseConditional )
                    {
                    // InternalPreprocess.g:1758:1: (lv_else_3_0= ruleElseConditional )
                    // InternalPreprocess.g:1759:3: lv_else_3_0= ruleElseConditional
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

            // InternalPreprocess.g:1778:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_WHITESPACE) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalPreprocess.g:1778:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getConditionalDirectiveAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            this_HASH_5=(Token)match(input,RULE_HASH,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_5, grammarAccess.getConditionalDirectiveAccess().getHASHTerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:1792:1: (this_WHITESPACE_6= RULE_WHITESPACE )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_WHITESPACE) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalPreprocess.g:1792:2: this_WHITESPACE_6= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_6=(Token)match(input,RULE_WHITESPACE,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_6, grammarAccess.getConditionalDirectiveAccess().getWHITESPACETerminalRuleCall_6()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            this_ENDIF_7=(Token)match(input,RULE_ENDIF,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ENDIF_7, grammarAccess.getConditionalDirectiveAccess().getENDIFTerminalRuleCall_7()); 
                  
            }
            // InternalPreprocess.g:1806:1: (this_WHITESPACE_8= RULE_WHITESPACE )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_WHITESPACE) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalPreprocess.g:1806:2: this_WHITESPACE_8= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_8=(Token)match(input,RULE_WHITESPACE,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_8, grammarAccess.getConditionalDirectiveAccess().getWHITESPACETerminalRuleCall_8()); 
            	          
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
    // InternalPreprocess.g:1822:1: entryRuleIfConditional returns [EObject current=null] : iv_ruleIfConditional= ruleIfConditional EOF ;
    public final EObject entryRuleIfConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfConditional = null;


        try {
            // InternalPreprocess.g:1823:2: (iv_ruleIfConditional= ruleIfConditional EOF )
            // InternalPreprocess.g:1824:2: iv_ruleIfConditional= ruleIfConditional EOF
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
    // InternalPreprocess.g:1831:1: ruleIfConditional returns [EObject current=null] : ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) ;
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
            // InternalPreprocess.g:1837:7: ( ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:1839:1: ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:1839:1: ( () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:1840:1: () this_IF_1= RULE_IF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_expression_3_0= ruleConstantExpression ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:1840:1: ()
            // InternalPreprocess.g:1841:2: 
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
            // InternalPreprocess.g:1859:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt43=0;
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_WHITESPACE) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalPreprocess.g:1859:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIfConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
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

            // InternalPreprocess.g:1866:1: ( (lv_expression_3_0= ruleConstantExpression ) )
            // InternalPreprocess.g:1867:1: (lv_expression_3_0= ruleConstantExpression )
            {
            // InternalPreprocess.g:1867:1: (lv_expression_3_0= ruleConstantExpression )
            // InternalPreprocess.g:1868:3: lv_expression_3_0= ruleConstantExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfConditionalAccess().getExpressionConstantExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_23);
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

            // InternalPreprocess.g:1887:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_WHITESPACE) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalPreprocess.g:1887:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getIfConditionalAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_5, grammarAccess.getIfConditionalAccess().getNEWLINETerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:1901:1: ( (lv_group_6_0= ruleGroupOpt ) )
            // InternalPreprocess.g:1902:1: (lv_group_6_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:1902:1: (lv_group_6_0= ruleGroupOpt )
            // InternalPreprocess.g:1903:3: lv_group_6_0= ruleGroupOpt
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
    // InternalPreprocess.g:1931:1: entryRuleIfDefConditional returns [EObject current=null] : iv_ruleIfDefConditional= ruleIfDefConditional EOF ;
    public final EObject entryRuleIfDefConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfDefConditional = null;


        try {
            // InternalPreprocess.g:1932:2: (iv_ruleIfDefConditional= ruleIfDefConditional EOF )
            // InternalPreprocess.g:1933:2: iv_ruleIfDefConditional= ruleIfDefConditional EOF
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
    // InternalPreprocess.g:1940:1: ruleIfDefConditional returns [EObject current=null] : ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) ;
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
            // InternalPreprocess.g:1946:7: ( ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:1948:1: ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:1948:1: ( () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:1949:1: () this_IFDEF_1= RULE_IFDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:1949:1: ()
            // InternalPreprocess.g:1950:2: 
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
            // InternalPreprocess.g:1968:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt45=0;
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_WHITESPACE) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalPreprocess.g:1968:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIfDefConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt45 >= 1 ) break loop45;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(45, input);
                        throw eee;
                }
                cnt45++;
            } while (true);

            // InternalPreprocess.g:1975:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:1976:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:1976:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:1977:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_23); if (state.failed) return current;
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

            // InternalPreprocess.g:1996:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_WHITESPACE) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalPreprocess.g:1996:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getIfDefConditionalAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_5, grammarAccess.getIfDefConditionalAccess().getNEWLINETerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:2010:1: ( (lv_group_6_0= ruleGroupOpt ) )
            // InternalPreprocess.g:2011:1: (lv_group_6_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:2011:1: (lv_group_6_0= ruleGroupOpt )
            // InternalPreprocess.g:2012:3: lv_group_6_0= ruleGroupOpt
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
    // InternalPreprocess.g:2040:1: entryRuleIfNotDefConditional returns [EObject current=null] : iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF ;
    public final EObject entryRuleIfNotDefConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfNotDefConditional = null;


        try {
            // InternalPreprocess.g:2041:2: (iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF )
            // InternalPreprocess.g:2042:2: iv_ruleIfNotDefConditional= ruleIfNotDefConditional EOF
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
    // InternalPreprocess.g:2049:1: ruleIfNotDefConditional returns [EObject current=null] : ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) ;
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
            // InternalPreprocess.g:2055:7: ( ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:2057:1: ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:2057:1: ( () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:2058:1: () this_IFNOTDEF_1= RULE_IFNOTDEF (this_WHITESPACE_2= RULE_WHITESPACE )+ ( (lv_id_3_0= RULE_ID ) ) (this_WHITESPACE_4= RULE_WHITESPACE )* this_NEWLINE_5= RULE_NEWLINE ( (lv_group_6_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:2058:1: ()
            // InternalPreprocess.g:2059:2: 
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
            // InternalPreprocess.g:2077:1: (this_WHITESPACE_2= RULE_WHITESPACE )+
            int cnt47=0;
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_WHITESPACE) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalPreprocess.g:2077:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getIfNotDefConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt47 >= 1 ) break loop47;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(47, input);
                        throw eee;
                }
                cnt47++;
            } while (true);

            // InternalPreprocess.g:2084:1: ( (lv_id_3_0= RULE_ID ) )
            // InternalPreprocess.g:2085:1: (lv_id_3_0= RULE_ID )
            {
            // InternalPreprocess.g:2085:1: (lv_id_3_0= RULE_ID )
            // InternalPreprocess.g:2086:3: lv_id_3_0= RULE_ID
            {
            lv_id_3_0=(Token)match(input,RULE_ID,FOLLOW_23); if (state.failed) return current;
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

            // InternalPreprocess.g:2105:1: (this_WHITESPACE_4= RULE_WHITESPACE )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_WHITESPACE) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalPreprocess.g:2105:2: this_WHITESPACE_4= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_4, grammarAccess.getIfNotDefConditionalAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_5, grammarAccess.getIfNotDefConditionalAccess().getNEWLINETerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:2119:1: ( (lv_group_6_0= ruleGroupOpt ) )
            // InternalPreprocess.g:2120:1: (lv_group_6_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:2120:1: (lv_group_6_0= ruleGroupOpt )
            // InternalPreprocess.g:2121:3: lv_group_6_0= ruleGroupOpt
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
    // InternalPreprocess.g:2149:1: entryRuleElIfConditional returns [EObject current=null] : iv_ruleElIfConditional= ruleElIfConditional EOF ;
    public final EObject entryRuleElIfConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElIfConditional = null;


        try {
            // InternalPreprocess.g:2150:2: (iv_ruleElIfConditional= ruleElIfConditional EOF )
            // InternalPreprocess.g:2151:2: iv_ruleElIfConditional= ruleElIfConditional EOF
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
    // InternalPreprocess.g:2158:1: ruleElIfConditional returns [EObject current=null] : ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) (this_WHITESPACE_7= RULE_WHITESPACE )* this_NEWLINE_8= RULE_NEWLINE ( (lv_group_9_0= ruleGroupOpt ) ) ) ;
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
            // InternalPreprocess.g:2164:7: ( ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) (this_WHITESPACE_7= RULE_WHITESPACE )* this_NEWLINE_8= RULE_NEWLINE ( (lv_group_9_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:2166:1: ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) (this_WHITESPACE_7= RULE_WHITESPACE )* this_NEWLINE_8= RULE_NEWLINE ( (lv_group_9_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:2166:1: ( () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) (this_WHITESPACE_7= RULE_WHITESPACE )* this_NEWLINE_8= RULE_NEWLINE ( (lv_group_9_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:2167:1: () ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF ) (this_WHITESPACE_5= RULE_WHITESPACE )+ ( (lv_expression_6_0= ruleConstantExpression ) ) (this_WHITESPACE_7= RULE_WHITESPACE )* this_NEWLINE_8= RULE_NEWLINE ( (lv_group_9_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:2167:1: ()
            // InternalPreprocess.g:2168:2: 
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

            // InternalPreprocess.g:2179:1: ( (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF )
            // InternalPreprocess.g:2180:1: (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELIF_4= RULE_ELIF
            {
            // InternalPreprocess.g:2180:1: (this_WHITESPACE_1= RULE_WHITESPACE )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_WHITESPACE) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalPreprocess.g:2180:2: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_1_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_2, grammarAccess.getElIfConditionalAccess().getHASHTerminalRuleCall_1_1()); 
                  
            }
            // InternalPreprocess.g:2194:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_WHITESPACE) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalPreprocess.g:2194:2: this_WHITESPACE_3= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_25); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_3, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_1_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            this_ELIF_4=(Token)match(input,RULE_ELIF,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ELIF_4, grammarAccess.getElIfConditionalAccess().getELIFTerminalRuleCall_1_3()); 
                  
            }

            }

            // InternalPreprocess.g:2210:1: (this_WHITESPACE_5= RULE_WHITESPACE )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_WHITESPACE) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalPreprocess.g:2210:2: this_WHITESPACE_5= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_5=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_5, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt51 >= 1 ) break loop51;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
            } while (true);

            // InternalPreprocess.g:2217:1: ( (lv_expression_6_0= ruleConstantExpression ) )
            // InternalPreprocess.g:2218:1: (lv_expression_6_0= ruleConstantExpression )
            {
            // InternalPreprocess.g:2218:1: (lv_expression_6_0= ruleConstantExpression )
            // InternalPreprocess.g:2219:3: lv_expression_6_0= ruleConstantExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElIfConditionalAccess().getExpressionConstantExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_23);
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

            // InternalPreprocess.g:2238:1: (this_WHITESPACE_7= RULE_WHITESPACE )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_WHITESPACE) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalPreprocess.g:2238:2: this_WHITESPACE_7= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_7=(Token)match(input,RULE_WHITESPACE,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_7, grammarAccess.getElIfConditionalAccess().getWHITESPACETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            this_NEWLINE_8=(Token)match(input,RULE_NEWLINE,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_8, grammarAccess.getElIfConditionalAccess().getNEWLINETerminalRuleCall_5()); 
                  
            }
            // InternalPreprocess.g:2252:1: ( (lv_group_9_0= ruleGroupOpt ) )
            // InternalPreprocess.g:2253:1: (lv_group_9_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:2253:1: (lv_group_9_0= ruleGroupOpt )
            // InternalPreprocess.g:2254:3: lv_group_9_0= ruleGroupOpt
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
    // InternalPreprocess.g:2282:1: entryRuleElseConditional returns [EObject current=null] : iv_ruleElseConditional= ruleElseConditional EOF ;
    public final EObject entryRuleElseConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseConditional = null;


        try {
            // InternalPreprocess.g:2283:2: (iv_ruleElseConditional= ruleElseConditional EOF )
            // InternalPreprocess.g:2284:2: iv_ruleElseConditional= ruleElseConditional EOF
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
    // InternalPreprocess.g:2291:1: ruleElseConditional returns [EObject current=null] : ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE (this_WHITESPACE_5= RULE_WHITESPACE )* this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) ) ) ;
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
            // InternalPreprocess.g:2297:7: ( ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE (this_WHITESPACE_5= RULE_WHITESPACE )* this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) ) ) )
            // InternalPreprocess.g:2299:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE (this_WHITESPACE_5= RULE_WHITESPACE )* this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) ) )
            {
            // InternalPreprocess.g:2299:1: ( () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE (this_WHITESPACE_5= RULE_WHITESPACE )* this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) ) )
            // InternalPreprocess.g:2300:1: () (this_WHITESPACE_1= RULE_WHITESPACE )* this_HASH_2= RULE_HASH (this_WHITESPACE_3= RULE_WHITESPACE )* this_ELSE_4= RULE_ELSE (this_WHITESPACE_5= RULE_WHITESPACE )* this_NEWLINE_6= RULE_NEWLINE ( (lv_group_7_0= ruleGroupOpt ) )
            {
            // InternalPreprocess.g:2300:1: ()
            // InternalPreprocess.g:2301:2: 
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

            // InternalPreprocess.g:2312:1: (this_WHITESPACE_1= RULE_WHITESPACE )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_WHITESPACE) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalPreprocess.g:2312:2: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getElseConditionalAccess().getWHITESPACETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            this_HASH_2=(Token)match(input,RULE_HASH,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_HASH_2, grammarAccess.getElseConditionalAccess().getHASHTerminalRuleCall_2()); 
                  
            }
            // InternalPreprocess.g:2326:1: (this_WHITESPACE_3= RULE_WHITESPACE )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_WHITESPACE) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalPreprocess.g:2326:2: this_WHITESPACE_3= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_3=(Token)match(input,RULE_WHITESPACE,FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_3, grammarAccess.getElseConditionalAccess().getWHITESPACETerminalRuleCall_3()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            this_ELSE_4=(Token)match(input,RULE_ELSE,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ELSE_4, grammarAccess.getElseConditionalAccess().getELSETerminalRuleCall_4()); 
                  
            }
            // InternalPreprocess.g:2340:1: (this_WHITESPACE_5= RULE_WHITESPACE )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_WHITESPACE) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalPreprocess.g:2340:2: this_WHITESPACE_5= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_5=(Token)match(input,RULE_WHITESPACE,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_5, grammarAccess.getElseConditionalAccess().getWHITESPACETerminalRuleCall_5()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            this_NEWLINE_6=(Token)match(input,RULE_NEWLINE,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_6, grammarAccess.getElseConditionalAccess().getNEWLINETerminalRuleCall_6()); 
                  
            }
            // InternalPreprocess.g:2354:1: ( (lv_group_7_0= ruleGroupOpt ) )
            // InternalPreprocess.g:2355:1: (lv_group_7_0= ruleGroupOpt )
            {
            // InternalPreprocess.g:2355:1: (lv_group_7_0= ruleGroupOpt )
            // InternalPreprocess.g:2356:3: lv_group_7_0= ruleGroupOpt
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
    // InternalPreprocess.g:2384:1: entryRulePragmaDirective returns [EObject current=null] : iv_rulePragmaDirective= rulePragmaDirective EOF ;
    public final EObject entryRulePragmaDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePragmaDirective = null;


        try {
            // InternalPreprocess.g:2385:2: (iv_rulePragmaDirective= rulePragmaDirective EOF )
            // InternalPreprocess.g:2386:2: iv_rulePragmaDirective= rulePragmaDirective EOF
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
    // InternalPreprocess.g:2393:1: rulePragmaDirective returns [EObject current=null] : ( () this_PRAGMA_1= RULE_PRAGMA (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_pragma_3_0= ruleMyCodeLine ) )? ) ;
    public final EObject rulePragmaDirective() throws RecognitionException {
        EObject current = null;

        Token this_PRAGMA_1=null;
        Token this_WHITESPACE_2=null;
        AntlrDatatypeRuleToken lv_pragma_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2399:7: ( ( () this_PRAGMA_1= RULE_PRAGMA (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_pragma_3_0= ruleMyCodeLine ) )? ) )
            // InternalPreprocess.g:2401:1: ( () this_PRAGMA_1= RULE_PRAGMA (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_pragma_3_0= ruleMyCodeLine ) )? )
            {
            // InternalPreprocess.g:2401:1: ( () this_PRAGMA_1= RULE_PRAGMA (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_pragma_3_0= ruleMyCodeLine ) )? )
            // InternalPreprocess.g:2402:1: () this_PRAGMA_1= RULE_PRAGMA (this_WHITESPACE_2= RULE_WHITESPACE )* ( (lv_pragma_3_0= ruleMyCodeLine ) )?
            {
            // InternalPreprocess.g:2402:1: ()
            // InternalPreprocess.g:2403:2: 
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
            // InternalPreprocess.g:2421:1: (this_WHITESPACE_2= RULE_WHITESPACE )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==RULE_WHITESPACE) ) {
                    int LA56_2 = input.LA(2);

                    if ( (synpred64_InternalPreprocess()) ) {
                        alt56=1;
                    }


                }


                switch (alt56) {
            	case 1 :
            	    // InternalPreprocess.g:2421:2: this_WHITESPACE_2= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_2, grammarAccess.getPragmaDirectiveAccess().getWHITESPACETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

            // InternalPreprocess.g:2428:1: ( (lv_pragma_3_0= ruleMyCodeLine ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_WHITESPACE||(LA57_0>=RULE_INCLUDE && LA57_0<=RULE_DEFINED)||(LA57_0>=RULE_SKW_QUESTION && LA57_0<=RULE_SKW_SINGLEQUOTE)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalPreprocess.g:2429:1: (lv_pragma_3_0= ruleMyCodeLine )
                    {
                    // InternalPreprocess.g:2429:1: (lv_pragma_3_0= ruleMyCodeLine )
                    // InternalPreprocess.g:2430:3: lv_pragma_3_0= ruleMyCodeLine
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
    // InternalPreprocess.g:2458:1: entryRuleNullDirective returns [EObject current=null] : iv_ruleNullDirective= ruleNullDirective EOF ;
    public final EObject entryRuleNullDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullDirective = null;


        try {
            // InternalPreprocess.g:2459:2: (iv_ruleNullDirective= ruleNullDirective EOF )
            // InternalPreprocess.g:2460:2: iv_ruleNullDirective= ruleNullDirective EOF
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
    // InternalPreprocess.g:2467:1: ruleNullDirective returns [EObject current=null] : () ;
    public final EObject ruleNullDirective() throws RecognitionException {
        EObject current = null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2473:7: ( () )
            // InternalPreprocess.g:2475:1: ()
            {
            // InternalPreprocess.g:2475:1: ()
            // InternalPreprocess.g:2476:2: 
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
    // InternalPreprocess.g:2494:1: entryRuleNewLineLine returns [EObject current=null] : iv_ruleNewLineLine= ruleNewLineLine EOF ;
    public final EObject entryRuleNewLineLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewLineLine = null;


        try {
            // InternalPreprocess.g:2495:2: (iv_ruleNewLineLine= ruleNewLineLine EOF )
            // InternalPreprocess.g:2496:2: iv_ruleNewLineLine= ruleNewLineLine EOF
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
    // InternalPreprocess.g:2503:1: ruleNewLineLine returns [EObject current=null] : () ;
    public final EObject ruleNewLineLine() throws RecognitionException {
        EObject current = null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2509:7: ( () )
            // InternalPreprocess.g:2511:1: ()
            {
            // InternalPreprocess.g:2511:1: ()
            // InternalPreprocess.g:2512:2: 
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
    // InternalPreprocess.g:2530:1: entryRuleCode returns [EObject current=null] : iv_ruleCode= ruleCode EOF ;
    public final EObject entryRuleCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCode = null;


        try {
            // InternalPreprocess.g:2531:2: (iv_ruleCode= ruleCode EOF )
            // InternalPreprocess.g:2532:2: iv_ruleCode= ruleCode EOF
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
    // InternalPreprocess.g:2539:1: ruleCode returns [EObject current=null] : ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) ) ;
    public final EObject ruleCode() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_code_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:2545:7: ( ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) ) )
            // InternalPreprocess.g:2547:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) )
            {
            // InternalPreprocess.g:2547:1: ( () ( (lv_code_1_0= ruleMyCodeLineExtended ) ) )
            // InternalPreprocess.g:2548:1: () ( (lv_code_1_0= ruleMyCodeLineExtended ) )
            {
            // InternalPreprocess.g:2548:1: ()
            // InternalPreprocess.g:2549:2: 
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

            // InternalPreprocess.g:2560:1: ( (lv_code_1_0= ruleMyCodeLineExtended ) )
            // InternalPreprocess.g:2561:1: (lv_code_1_0= ruleMyCodeLineExtended )
            {
            // InternalPreprocess.g:2561:1: (lv_code_1_0= ruleMyCodeLineExtended )
            // InternalPreprocess.g:2562:3: lv_code_1_0= ruleMyCodeLineExtended
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
    // InternalPreprocess.g:2590:1: entryRuleMyCode returns [String current=null] : iv_ruleMyCode= ruleMyCode EOF ;
    public final String entryRuleMyCode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCode = null;


        try {
            // InternalPreprocess.g:2591:2: (iv_ruleMyCode= ruleMyCode EOF )
            // InternalPreprocess.g:2592:2: iv_ruleMyCode= ruleMyCode EOF
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
    // InternalPreprocess.g:2599:1: ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_ELIF_11= RULE_ELIF | this_ELSE_12= RULE_ELSE | this_WARNING_13= RULE_WARNING | this_UNDEF_14= RULE_UNDEF | this_SpecialKeywords_15= ruleSpecialKeywords | this_Constant1_16= ruleConstant1 ) ;
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
        AntlrDatatypeRuleToken this_SpecialKeywords_15 = null;

        AntlrDatatypeRuleToken this_Constant1_16 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2602:28: ( (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_ELIF_11= RULE_ELIF | this_ELSE_12= RULE_ELSE | this_WARNING_13= RULE_WARNING | this_UNDEF_14= RULE_UNDEF | this_SpecialKeywords_15= ruleSpecialKeywords | this_Constant1_16= ruleConstant1 ) )
            // InternalPreprocess.g:2603:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_ELIF_11= RULE_ELIF | this_ELSE_12= RULE_ELSE | this_WARNING_13= RULE_WARNING | this_UNDEF_14= RULE_UNDEF | this_SpecialKeywords_15= ruleSpecialKeywords | this_Constant1_16= ruleConstant1 )
            {
            // InternalPreprocess.g:2603:1: (this_ID_0= RULE_ID | this_SPECIAL_1= RULE_SPECIAL | this_INCLUDE_2= RULE_INCLUDE | this_DEFINE_3= RULE_DEFINE | this_ERROR_4= RULE_ERROR | this_PRAGMA_5= RULE_PRAGMA | this_IFDEF_6= RULE_IFDEF | this_ENDIF_7= RULE_ENDIF | this_IFNOTDEF_8= RULE_IFNOTDEF | this_IF_9= RULE_IF | this_DEFINED_10= RULE_DEFINED | this_ELIF_11= RULE_ELIF | this_ELSE_12= RULE_ELSE | this_WARNING_13= RULE_WARNING | this_UNDEF_14= RULE_UNDEF | this_SpecialKeywords_15= ruleSpecialKeywords | this_Constant1_16= ruleConstant1 )
            int alt58=17;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt58=1;
                }
                break;
            case RULE_SPECIAL:
                {
                alt58=2;
                }
                break;
            case RULE_INCLUDE:
                {
                alt58=3;
                }
                break;
            case RULE_DEFINE:
                {
                alt58=4;
                }
                break;
            case RULE_ERROR:
                {
                alt58=5;
                }
                break;
            case RULE_PRAGMA:
                {
                alt58=6;
                }
                break;
            case RULE_IFDEF:
                {
                alt58=7;
                }
                break;
            case RULE_ENDIF:
                {
                alt58=8;
                }
                break;
            case RULE_IFNOTDEF:
                {
                alt58=9;
                }
                break;
            case RULE_IF:
                {
                alt58=10;
                }
                break;
            case RULE_DEFINED:
                {
                alt58=11;
                }
                break;
            case RULE_ELIF:
                {
                alt58=12;
                }
                break;
            case RULE_ELSE:
                {
                alt58=13;
                }
                break;
            case RULE_WARNING:
                {
                alt58=14;
                }
                break;
            case RULE_UNDEF:
                {
                alt58=15;
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
                alt58=16;
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
                alt58=17;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalPreprocess.g:2603:6: this_ID_0= RULE_ID
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
                    // InternalPreprocess.g:2611:10: this_SPECIAL_1= RULE_SPECIAL
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
                    // InternalPreprocess.g:2619:10: this_INCLUDE_2= RULE_INCLUDE
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
                    // InternalPreprocess.g:2627:10: this_DEFINE_3= RULE_DEFINE
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
                    // InternalPreprocess.g:2635:10: this_ERROR_4= RULE_ERROR
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
                    // InternalPreprocess.g:2643:10: this_PRAGMA_5= RULE_PRAGMA
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
                    // InternalPreprocess.g:2651:10: this_IFDEF_6= RULE_IFDEF
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
                    // InternalPreprocess.g:2659:10: this_ENDIF_7= RULE_ENDIF
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
                    // InternalPreprocess.g:2667:10: this_IFNOTDEF_8= RULE_IFNOTDEF
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
                    // InternalPreprocess.g:2675:10: this_IF_9= RULE_IF
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
                    // InternalPreprocess.g:2683:10: this_DEFINED_10= RULE_DEFINED
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
                    // InternalPreprocess.g:2691:10: this_ELIF_11= RULE_ELIF
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
                    // InternalPreprocess.g:2699:10: this_ELSE_12= RULE_ELSE
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
                    // InternalPreprocess.g:2707:10: this_WARNING_13= RULE_WARNING
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
                    // InternalPreprocess.g:2715:10: this_UNDEF_14= RULE_UNDEF
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
                    // InternalPreprocess.g:2724:5: this_SpecialKeywords_15= ruleSpecialKeywords
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeAccess().getSpecialKeywordsParserRuleCall_15()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_SpecialKeywords_15=ruleSpecialKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SpecialKeywords_15);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 17 :
                    // InternalPreprocess.g:2736:5: this_Constant1_16= ruleConstant1
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMyCodeAccess().getConstant1ParserRuleCall_16()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Constant1_16=ruleConstant1();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Constant1_16);
                          
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
    // InternalPreprocess.g:2754:1: entryRuleMyDefineLine returns [String current=null] : iv_ruleMyDefineLine= ruleMyDefineLine EOF ;
    public final String entryRuleMyDefineLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyDefineLine = null;


        try {
            // InternalPreprocess.g:2755:2: (iv_ruleMyDefineLine= ruleMyDefineLine EOF )
            // InternalPreprocess.g:2756:2: iv_ruleMyDefineLine= ruleMyDefineLine EOF
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
    // InternalPreprocess.g:2763:1: ruleMyDefineLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_VA_ARGS_2= RULE_VA_ARGS )+ ;
    public final AntlrDatatypeRuleToken ruleMyDefineLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_1=null;
        Token this_VA_ARGS_2=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2766:28: ( (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_VA_ARGS_2= RULE_VA_ARGS )+ )
            // InternalPreprocess.g:2767:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_VA_ARGS_2= RULE_VA_ARGS )+
            {
            // InternalPreprocess.g:2767:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_VA_ARGS_2= RULE_VA_ARGS )+
            int cnt59=0;
            loop59:
            do {
                int alt59=4;
                alt59 = dfa59.predict(input);
                switch (alt59) {
            	case 1 :
            	    // InternalPreprocess.g:2768:5: this_MyCode_0= ruleMyCode
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMyDefineLineAccess().getMyCodeParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_14);
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
            	    // InternalPreprocess.g:2779:10: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WHITESPACE_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getMyDefineLineAccess().getWHITESPACETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;
            	case 3 :
            	    // InternalPreprocess.g:2787:10: this_VA_ARGS_2= RULE_VA_ARGS
            	    {
            	    this_VA_ARGS_2=(Token)match(input,RULE_VA_ARGS,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_VA_ARGS_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_VA_ARGS_2, grammarAccess.getMyDefineLineAccess().getVA_ARGSTerminalRuleCall_2()); 
            	          
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
    // $ANTLR end "ruleMyDefineLine"


    // $ANTLR start "entryRuleMyDefineLine2"
    // InternalPreprocess.g:2802:1: entryRuleMyDefineLine2 returns [String current=null] : iv_ruleMyDefineLine2= ruleMyDefineLine2 EOF ;
    public final String entryRuleMyDefineLine2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyDefineLine2 = null;


        try {
            // InternalPreprocess.g:2803:2: (iv_ruleMyDefineLine2= ruleMyDefineLine2 EOF )
            // InternalPreprocess.g:2804:2: iv_ruleMyDefineLine2= ruleMyDefineLine2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMyDefineLine2Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMyDefineLine2=ruleMyDefineLine2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMyDefineLine2.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMyDefineLine2"


    // $ANTLR start "ruleMyDefineLine2"
    // InternalPreprocess.g:2811:1: ruleMyDefineLine2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+ ;
    public final AntlrDatatypeRuleToken ruleMyDefineLine2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_1=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2814:28: ( (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+ )
            // InternalPreprocess.g:2815:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+
            {
            // InternalPreprocess.g:2815:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+
            int cnt60=0;
            loop60:
            do {
                int alt60=3;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_WHITESPACE) ) {
                    int LA60_1 = input.LA(2);

                    if ( (synpred86_InternalPreprocess()) ) {
                        alt60=2;
                    }


                }
                else if ( ((LA60_0>=RULE_INCLUDE && LA60_0<=RULE_DEFINED)||(LA60_0>=RULE_SKW_QUESTION && LA60_0<=RULE_SKW_SINGLEQUOTE)) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalPreprocess.g:2816:5: this_MyCode_0= ruleMyCode
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMyDefineLine2Access().getMyCodeParserRuleCall_0()); 
            	          
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
            	    // InternalPreprocess.g:2827:10: this_WHITESPACE_1= RULE_WHITESPACE
            	    {
            	    this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_WHITESPACE_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_WHITESPACE_1, grammarAccess.getMyDefineLine2Access().getWHITESPACETerminalRuleCall_1()); 
            	          
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
    // $ANTLR end "ruleMyDefineLine2"


    // $ANTLR start "entryRuleMyCodeLine"
    // InternalPreprocess.g:2842:1: entryRuleMyCodeLine returns [String current=null] : iv_ruleMyCodeLine= ruleMyCodeLine EOF ;
    public final String entryRuleMyCodeLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLine = null;


        try {
            // InternalPreprocess.g:2843:2: (iv_ruleMyCodeLine= ruleMyCodeLine EOF )
            // InternalPreprocess.g:2844:2: iv_ruleMyCodeLine= ruleMyCodeLine EOF
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
    // InternalPreprocess.g:2851:1: ruleMyCodeLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+ ;
    public final AntlrDatatypeRuleToken ruleMyCodeLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_1=null;
        AntlrDatatypeRuleToken this_MyCode_0 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2854:28: ( (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+ )
            // InternalPreprocess.g:2855:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+
            {
            // InternalPreprocess.g:2855:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+
            int cnt61=0;
            loop61:
            do {
                int alt61=3;
                alt61 = dfa61.predict(input);
                switch (alt61) {
            	case 1 :
            	    // InternalPreprocess.g:2856:5: this_MyCode_0= ruleMyCode
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
            	    // InternalPreprocess.g:2867:10: this_WHITESPACE_1= RULE_WHITESPACE
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
    // $ANTLR end "ruleMyCodeLine"


    // $ANTLR start "entryRuleMyCodeLineExtended"
    // InternalPreprocess.g:2882:1: entryRuleMyCodeLineExtended returns [String current=null] : iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF ;
    public final String entryRuleMyCodeLineExtended() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtended = null;


        try {
            // InternalPreprocess.g:2883:2: (iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF )
            // InternalPreprocess.g:2884:2: iv_ruleMyCodeLineExtended= ruleMyCodeLineExtended EOF
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
    // InternalPreprocess.g:2891:1: ruleMyCodeLineExtended returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal ) ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtended() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_MyCodeLineExtendedWSOnly_0 = null;

        AntlrDatatypeRuleToken this_MyCodeLineExtendedNormal_1 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2894:28: ( (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal ) )
            // InternalPreprocess.g:2895:1: (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal )
            {
            // InternalPreprocess.g:2895:1: (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal )
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // InternalPreprocess.g:2896:5: this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly
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
                    // InternalPreprocess.g:2908:5: this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal
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
    // InternalPreprocess.g:2926:1: entryRuleMyCodeLineExtendedWSOnly returns [String current=null] : iv_ruleMyCodeLineExtendedWSOnly= ruleMyCodeLineExtendedWSOnly EOF ;
    public final String entryRuleMyCodeLineExtendedWSOnly() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtendedWSOnly = null;


        try {
            // InternalPreprocess.g:2927:2: (iv_ruleMyCodeLineExtendedWSOnly= ruleMyCodeLineExtendedWSOnly EOF )
            // InternalPreprocess.g:2928:2: iv_ruleMyCodeLineExtendedWSOnly= ruleMyCodeLineExtendedWSOnly EOF
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
    // InternalPreprocess.g:2935:1: ruleMyCodeLineExtendedWSOnly returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_WHITESPACE_0= RULE_WHITESPACE )+ ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtendedWSOnly() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_0=null;

         enterRule(); 
            
        try {
            // InternalPreprocess.g:2938:28: ( (this_WHITESPACE_0= RULE_WHITESPACE )+ )
            // InternalPreprocess.g:2939:1: (this_WHITESPACE_0= RULE_WHITESPACE )+
            {
            // InternalPreprocess.g:2939:1: (this_WHITESPACE_0= RULE_WHITESPACE )+
            int cnt63=0;
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_WHITESPACE) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalPreprocess.g:2939:6: this_WHITESPACE_0= RULE_WHITESPACE
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
            	    if ( cnt63 >= 1 ) break loop63;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(63, input);
                        throw eee;
                }
                cnt63++;
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
    // InternalPreprocess.g:2954:1: entryRuleMyCodeLineExtendedNormal returns [String current=null] : iv_ruleMyCodeLineExtendedNormal= ruleMyCodeLineExtendedNormal EOF ;
    public final String entryRuleMyCodeLineExtendedNormal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeLineExtendedNormal = null;


        try {
            // InternalPreprocess.g:2955:2: (iv_ruleMyCodeLineExtendedNormal= ruleMyCodeLineExtendedNormal EOF )
            // InternalPreprocess.g:2956:2: iv_ruleMyCodeLineExtendedNormal= ruleMyCodeLineExtendedNormal EOF
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
    // InternalPreprocess.g:2963:1: ruleMyCodeLineExtendedNormal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* ) ;
    public final AntlrDatatypeRuleToken ruleMyCodeLineExtendedNormal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WHITESPACE_0=null;
        Token this_HASH_3=null;
        AntlrDatatypeRuleToken this_MyCode_1 = null;

        AntlrDatatypeRuleToken this_MyCodeLine_2 = null;


         enterRule(); 
            
        try {
            // InternalPreprocess.g:2966:28: ( ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* ) )
            // InternalPreprocess.g:2967:1: ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )
            {
            // InternalPreprocess.g:2967:1: ( (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )* )
            // InternalPreprocess.g:2967:2: (this_WHITESPACE_0= RULE_WHITESPACE )* (this_MyCode_1= ruleMyCode )+ (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
            {
            // InternalPreprocess.g:2967:2: (this_WHITESPACE_0= RULE_WHITESPACE )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_WHITESPACE) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalPreprocess.g:2967:7: this_WHITESPACE_0= RULE_WHITESPACE
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
            	    break loop64;
                }
            } while (true);

            // InternalPreprocess.g:2974:3: (this_MyCode_1= ruleMyCode )+
            int cnt65=0;
            loop65:
            do {
                int alt65=2;
                alt65 = dfa65.predict(input);
                switch (alt65) {
            	case 1 :
            	    // InternalPreprocess.g:2975:5: this_MyCode_1= ruleMyCode
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
            	    if ( cnt65 >= 1 ) break loop65;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(65, input);
                        throw eee;
                }
                cnt65++;
            } while (true);

            // InternalPreprocess.g:2985:3: (this_MyCodeLine_2= ruleMyCodeLine | this_HASH_3= RULE_HASH )*
            loop66:
            do {
                int alt66=3;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==RULE_WHITESPACE||(LA66_0>=RULE_INCLUDE && LA66_0<=RULE_DEFINED)||(LA66_0>=RULE_SKW_QUESTION && LA66_0<=RULE_SKW_SINGLEQUOTE)) ) {
                    alt66=1;
                }
                else if ( (LA66_0==RULE_HASH) ) {
                    alt66=2;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalPreprocess.g:2986:5: this_MyCodeLine_2= ruleMyCodeLine
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
            	    // InternalPreprocess.g:2997:10: this_HASH_3= RULE_HASH
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
            	    break loop66;
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
    // InternalPreprocess.g:3012:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalPreprocess.g:3013:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalPreprocess.g:3014:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalPreprocess.g:3021:1: rulePrimaryExpression returns [EObject current=null] : ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) ) ;
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
            // InternalPreprocess.g:3027:7: ( ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) ) )
            // InternalPreprocess.g:3029:1: ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) )
            {
            // InternalPreprocess.g:3029:1: ( () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) ) )
            // InternalPreprocess.g:3030:1: () ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) )
            {
            // InternalPreprocess.g:3030:1: ()
            // InternalPreprocess.g:3031:2: 
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

            // InternalPreprocess.g:3042:1: ( ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) | ( (lv_const_7_0= ruleConstant1 ) ) | (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN ) )
            int alt69=4;
            switch ( input.LA(1) ) {
            case RULE_DEFINED:
                {
                int LA69_1 = input.LA(2);

                if ( (LA69_1==RULE_SKW_LEFTPAREN) ) {
                    alt69=2;
                }
                else if ( (LA69_1==RULE_ID) ) {
                    alt69=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                alt69=1;
                }
                break;
            case RULE_SKW_LEFTPAREN:
                {
                int LA69_3 = input.LA(2);

                if ( (LA69_3==RULE_SKW_LEFTPAREN||LA69_3==RULE_DEFINED||LA69_3==RULE_SKW_AND||(LA69_3>=RULE_SKW_PLUS && LA69_3<=RULE_SKW_STAR)||(LA69_3>=RULE_SKW_TILDE && LA69_3<=RULE_BIN_LITERAL)) ) {
                    alt69=4;
                }
                else if ( (LA69_3==RULE_ID) ) {
                    int LA69_7 = input.LA(3);

                    if ( (LA69_7==RULE_SKW_RIGHTPAREN) ) {
                        int LA69_8 = input.LA(4);

                        if ( (synpred98_InternalPreprocess()) ) {
                            alt69=2;
                        }
                        else if ( (true) ) {
                            alt69=4;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 69, 8, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA69_7==RULE_SKW_LEFTPAREN||LA69_7==RULE_SKW_QUESTION||(LA69_7>=RULE_SKW_OROR && LA69_7<=RULE_SKW_MOD)) ) {
                        alt69=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 69, 7, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 3, input);

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
                alt69=3;
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
                    // InternalPreprocess.g:3043:1: ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) )
                    {
                    // InternalPreprocess.g:3043:1: ( ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) ) )
                    // InternalPreprocess.g:3044:1: ( (lv_defined_1_0= RULE_DEFINED ) )? ( (lv_id_2_0= RULE_ID ) )
                    {
                    // InternalPreprocess.g:3044:1: ( (lv_defined_1_0= RULE_DEFINED ) )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==RULE_DEFINED) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // InternalPreprocess.g:3045:1: (lv_defined_1_0= RULE_DEFINED )
                            {
                            // InternalPreprocess.g:3045:1: (lv_defined_1_0= RULE_DEFINED )
                            // InternalPreprocess.g:3046:3: lv_defined_1_0= RULE_DEFINED
                            {
                            lv_defined_1_0=(Token)match(input,RULE_DEFINED,FOLLOW_27); if (state.failed) return current;
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

                    // InternalPreprocess.g:3065:1: ( (lv_id_2_0= RULE_ID ) )
                    // InternalPreprocess.g:3066:1: (lv_id_2_0= RULE_ID )
                    {
                    // InternalPreprocess.g:3066:1: (lv_id_2_0= RULE_ID )
                    // InternalPreprocess.g:3067:3: lv_id_2_0= RULE_ID
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
                    // InternalPreprocess.g:3089:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
                    {
                    // InternalPreprocess.g:3089:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
                    // InternalPreprocess.g:3090:1: ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN
                    {
                    // InternalPreprocess.g:3090:1: ( (lv_defined_3_0= RULE_DEFINED ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==RULE_DEFINED) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // InternalPreprocess.g:3091:1: (lv_defined_3_0= RULE_DEFINED )
                            {
                            // InternalPreprocess.g:3091:1: (lv_defined_3_0= RULE_DEFINED )
                            // InternalPreprocess.g:3092:3: lv_defined_3_0= RULE_DEFINED
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

                    this_SKW_LEFTPAREN_4=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LEFTPAREN_4, grammarAccess.getPrimaryExpressionAccess().getSKW_LEFTPARENTerminalRuleCall_1_1_1()); 
                          
                    }
                    // InternalPreprocess.g:3118:1: ( (lv_id_5_0= RULE_ID ) )
                    // InternalPreprocess.g:3119:1: (lv_id_5_0= RULE_ID )
                    {
                    // InternalPreprocess.g:3119:1: (lv_id_5_0= RULE_ID )
                    // InternalPreprocess.g:3120:3: lv_id_5_0= RULE_ID
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
                    // InternalPreprocess.g:3149:1: ( (lv_const_7_0= ruleConstant1 ) )
                    {
                    // InternalPreprocess.g:3149:1: ( (lv_const_7_0= ruleConstant1 ) )
                    // InternalPreprocess.g:3150:1: (lv_const_7_0= ruleConstant1 )
                    {
                    // InternalPreprocess.g:3150:1: (lv_const_7_0= ruleConstant1 )
                    // InternalPreprocess.g:3151:3: lv_const_7_0= ruleConstant1
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
                    // InternalPreprocess.g:3171:1: (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN )
                    {
                    // InternalPreprocess.g:3171:1: (this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN )
                    // InternalPreprocess.g:3172:1: this_SKW_LEFTPAREN_8= RULE_SKW_LEFTPAREN ( (lv_expr_9_0= ruleExpression ) ) this_SKW_RIGHTPAREN_10= RULE_SKW_RIGHTPAREN
                    {
                    this_SKW_LEFTPAREN_8=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_LEFTPAREN_8, grammarAccess.getPrimaryExpressionAccess().getSKW_LEFTPARENTerminalRuleCall_1_3_0()); 
                          
                    }
                    // InternalPreprocess.g:3179:1: ( (lv_expr_9_0= ruleExpression ) )
                    // InternalPreprocess.g:3180:1: (lv_expr_9_0= ruleExpression )
                    {
                    // InternalPreprocess.g:3180:1: (lv_expr_9_0= ruleExpression )
                    // InternalPreprocess.g:3181:3: lv_expr_9_0= ruleExpression
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
    // InternalPreprocess.g:3220:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
        	
        try {
            // InternalPreprocess.g:3224:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalPreprocess.g:3225:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalPreprocess.g:3235:1: ruleExpression returns [EObject current=null] : ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         enterRule();
           		/*no init found*/
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
            
        try {
            // InternalPreprocess.g:3242:7: ( ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) ) )
            // InternalPreprocess.g:3244:1: ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) )
            {
            // InternalPreprocess.g:3244:1: ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) )
            // InternalPreprocess.g:3245:1: () ( (lv_expression_1_0= ruleConditionalExpression ) )
            {
            // InternalPreprocess.g:3245:1: ()
            // InternalPreprocess.g:3246:2: 
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

            // InternalPreprocess.g:3257:1: ( (lv_expression_1_0= ruleConditionalExpression ) )
            // InternalPreprocess.g:3258:1: (lv_expression_1_0= ruleConditionalExpression )
            {
            // InternalPreprocess.g:3258:1: (lv_expression_1_0= ruleConditionalExpression )
            // InternalPreprocess.g:3259:3: lv_expression_1_0= ruleConditionalExpression
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
    // InternalPreprocess.g:3290:1: entryRuleConstantExpression returns [EObject current=null] : iv_ruleConstantExpression= ruleConstantExpression EOF ;
    public final EObject entryRuleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantExpression = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
        	
        try {
            // InternalPreprocess.g:3294:2: (iv_ruleConstantExpression= ruleConstantExpression EOF )
            // InternalPreprocess.g:3295:2: iv_ruleConstantExpression= ruleConstantExpression EOF
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
    // InternalPreprocess.g:3305:1: ruleConstantExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) ) ;
    public final EObject ruleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;


         enterRule();
           		/*no init found*/
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
            
        try {
            // InternalPreprocess.g:3312:7: ( ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) ) )
            // InternalPreprocess.g:3314:1: ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) )
            {
            // InternalPreprocess.g:3314:1: ( () ( (lv_expr_1_0= ruleConditionalExpression ) ) )
            // InternalPreprocess.g:3315:1: () ( (lv_expr_1_0= ruleConditionalExpression ) )
            {
            // InternalPreprocess.g:3315:1: ()
            // InternalPreprocess.g:3316:2: 
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

            // InternalPreprocess.g:3327:1: ( (lv_expr_1_0= ruleConditionalExpression ) )
            // InternalPreprocess.g:3328:1: (lv_expr_1_0= ruleConditionalExpression )
            {
            // InternalPreprocess.g:3328:1: (lv_expr_1_0= ruleConditionalExpression )
            // InternalPreprocess.g:3329:3: lv_expr_1_0= ruleConditionalExpression
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
    // InternalPreprocess.g:3360:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalPreprocess.g:3361:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalPreprocess.g:3362:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
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
    // InternalPreprocess.g:3369:1: ruleConditionalExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) ;
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
            // InternalPreprocess.g:3375:7: ( ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) )
            // InternalPreprocess.g:3377:1: ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
            {
            // InternalPreprocess.g:3377:1: ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
            // InternalPreprocess.g:3378:1: () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
            {
            // InternalPreprocess.g:3378:1: ()
            // InternalPreprocess.g:3379:2: 
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

            // InternalPreprocess.g:3390:1: ( (lv_expr_1_0= ruleLogicalOrExpression ) )
            // InternalPreprocess.g:3391:1: (lv_expr_1_0= ruleLogicalOrExpression )
            {
            // InternalPreprocess.g:3391:1: (lv_expr_1_0= ruleLogicalOrExpression )
            // InternalPreprocess.g:3392:3: lv_expr_1_0= ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExprLogicalOrExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_28);
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

            // InternalPreprocess.g:3411:1: (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_SKW_QUESTION) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalPreprocess.g:3412:1: this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) )
                    {
                    this_SKW_QUESTION_2=(Token)match(input,RULE_SKW_QUESTION,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SKW_QUESTION_2, grammarAccess.getConditionalExpressionAccess().getSKW_QUESTIONTerminalRuleCall_2_0()); 
                          
                    }
                    // InternalPreprocess.g:3419:1: ( (lv_qExpr_3_0= ruleExpression ) )
                    // InternalPreprocess.g:3420:1: (lv_qExpr_3_0= ruleExpression )
                    {
                    // InternalPreprocess.g:3420:1: (lv_qExpr_3_0= ruleExpression )
                    // InternalPreprocess.g:3421:3: lv_qExpr_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getQExprExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_29);
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
                    // InternalPreprocess.g:3447:1: ( (lv_cExpr_5_0= ruleConditionalExpression ) )
                    // InternalPreprocess.g:3448:1: (lv_cExpr_5_0= ruleConditionalExpression )
                    {
                    // InternalPreprocess.g:3448:1: (lv_cExpr_5_0= ruleConditionalExpression )
                    // InternalPreprocess.g:3449:3: lv_cExpr_5_0= ruleConditionalExpression
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
    // InternalPreprocess.g:3479:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalPreprocess.g:3480:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalPreprocess.g:3481:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
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
    // InternalPreprocess.g:3488:1: ruleLogicalOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_OROR_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3494:7: ( ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalPreprocess.g:3496:1: ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalPreprocess.g:3496:1: ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalPreprocess.g:3497:1: () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )*
            {
            // InternalPreprocess.g:3497:1: ()
            // InternalPreprocess.g:3498:2: 
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

            // InternalPreprocess.g:3509:1: ( (lv_expr_1_0= ruleLogicalAndExpression ) )
            // InternalPreprocess.g:3510:1: (lv_expr_1_0= ruleLogicalAndExpression )
            {
            // InternalPreprocess.g:3510:1: (lv_expr_1_0= ruleLogicalAndExpression )
            // InternalPreprocess.g:3511:3: lv_expr_1_0= ruleLogicalAndExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getExprLogicalAndExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_30);
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

            // InternalPreprocess.g:3530:1: (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==RULE_SKW_OROR) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalPreprocess.g:3531:1: this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) )
            	    {
            	    this_SKW_OROR_2=(Token)match(input,RULE_SKW_OROR,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_OROR_2, grammarAccess.getLogicalOrExpressionAccess().getSKW_ORORTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3538:1: ( (lv_expr_3_0= ruleLogicalAndExpression ) )
            	    // InternalPreprocess.g:3539:1: (lv_expr_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalPreprocess.g:3539:1: (lv_expr_3_0= ruleLogicalAndExpression )
            	    // InternalPreprocess.g:3540:3: lv_expr_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getExprLogicalAndExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_30);
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
    // $ANTLR end "ruleLogicalOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // InternalPreprocess.g:3570:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalPreprocess.g:3571:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalPreprocess.g:3572:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
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
    // InternalPreprocess.g:3579:1: ruleLogicalAndExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_ANDAND_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3585:7: ( ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* ) )
            // InternalPreprocess.g:3587:1: ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* )
            {
            // InternalPreprocess.g:3587:1: ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* )
            // InternalPreprocess.g:3588:1: () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )*
            {
            // InternalPreprocess.g:3588:1: ()
            // InternalPreprocess.g:3589:2: 
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

            // InternalPreprocess.g:3600:1: ( (lv_expr_1_0= ruleInclusiveOrExpression ) )
            // InternalPreprocess.g:3601:1: (lv_expr_1_0= ruleInclusiveOrExpression )
            {
            // InternalPreprocess.g:3601:1: (lv_expr_1_0= ruleInclusiveOrExpression )
            // InternalPreprocess.g:3602:3: lv_expr_1_0= ruleInclusiveOrExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getExprInclusiveOrExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_31);
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

            // InternalPreprocess.g:3621:1: (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==RULE_SKW_ANDAND) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalPreprocess.g:3622:1: this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) )
            	    {
            	    this_SKW_ANDAND_2=(Token)match(input,RULE_SKW_ANDAND,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_ANDAND_2, grammarAccess.getLogicalAndExpressionAccess().getSKW_ANDANDTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3629:1: ( (lv_expr_3_0= ruleInclusiveOrExpression ) )
            	    // InternalPreprocess.g:3630:1: (lv_expr_3_0= ruleInclusiveOrExpression )
            	    {
            	    // InternalPreprocess.g:3630:1: (lv_expr_3_0= ruleInclusiveOrExpression )
            	    // InternalPreprocess.g:3631:3: lv_expr_3_0= ruleInclusiveOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getExprInclusiveOrExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_31);
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
            	    break loop72;
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
    // InternalPreprocess.g:3661:1: entryRuleInclusiveOrExpression returns [EObject current=null] : iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF ;
    public final EObject entryRuleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclusiveOrExpression = null;


        try {
            // InternalPreprocess.g:3662:2: (iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF )
            // InternalPreprocess.g:3663:2: iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF
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
    // InternalPreprocess.g:3670:1: ruleInclusiveOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* ) ;
    public final EObject ruleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_OR_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3676:7: ( ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* ) )
            // InternalPreprocess.g:3678:1: ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* )
            {
            // InternalPreprocess.g:3678:1: ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* )
            // InternalPreprocess.g:3679:1: () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )*
            {
            // InternalPreprocess.g:3679:1: ()
            // InternalPreprocess.g:3680:2: 
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

            // InternalPreprocess.g:3691:1: ( (lv_expr_1_0= ruleExclusiveOrExpression ) )
            // InternalPreprocess.g:3692:1: (lv_expr_1_0= ruleExclusiveOrExpression )
            {
            // InternalPreprocess.g:3692:1: (lv_expr_1_0= ruleExclusiveOrExpression )
            // InternalPreprocess.g:3693:3: lv_expr_1_0= ruleExclusiveOrExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExprExclusiveOrExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_32);
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

            // InternalPreprocess.g:3712:1: (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==RULE_SKW_OR) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalPreprocess.g:3713:1: this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) )
            	    {
            	    this_SKW_OR_2=(Token)match(input,RULE_SKW_OR,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_OR_2, grammarAccess.getInclusiveOrExpressionAccess().getSKW_ORTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3720:1: ( (lv_expr_3_0= ruleExclusiveOrExpression ) )
            	    // InternalPreprocess.g:3721:1: (lv_expr_3_0= ruleExclusiveOrExpression )
            	    {
            	    // InternalPreprocess.g:3721:1: (lv_expr_3_0= ruleExclusiveOrExpression )
            	    // InternalPreprocess.g:3722:3: lv_expr_3_0= ruleExclusiveOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExprExclusiveOrExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_32);
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
    // $ANTLR end "ruleInclusiveOrExpression"


    // $ANTLR start "entryRuleExclusiveOrExpression"
    // InternalPreprocess.g:3752:1: entryRuleExclusiveOrExpression returns [EObject current=null] : iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF ;
    public final EObject entryRuleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusiveOrExpression = null;


        try {
            // InternalPreprocess.g:3753:2: (iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF )
            // InternalPreprocess.g:3754:2: iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF
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
    // InternalPreprocess.g:3761:1: ruleExclusiveOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_CARET_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3767:7: ( ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* ) )
            // InternalPreprocess.g:3769:1: ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* )
            {
            // InternalPreprocess.g:3769:1: ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* )
            // InternalPreprocess.g:3770:1: () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )*
            {
            // InternalPreprocess.g:3770:1: ()
            // InternalPreprocess.g:3771:2: 
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

            // InternalPreprocess.g:3782:1: ( (lv_expr_1_0= ruleAndExpression ) )
            // InternalPreprocess.g:3783:1: (lv_expr_1_0= ruleAndExpression )
            {
            // InternalPreprocess.g:3783:1: (lv_expr_1_0= ruleAndExpression )
            // InternalPreprocess.g:3784:3: lv_expr_1_0= ruleAndExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getExprAndExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_33);
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

            // InternalPreprocess.g:3803:1: (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==RULE_SKW_CARET) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalPreprocess.g:3804:1: this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) )
            	    {
            	    this_SKW_CARET_2=(Token)match(input,RULE_SKW_CARET,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_CARET_2, grammarAccess.getExclusiveOrExpressionAccess().getSKW_CARETTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3811:1: ( (lv_expr_3_0= ruleAndExpression ) )
            	    // InternalPreprocess.g:3812:1: (lv_expr_3_0= ruleAndExpression )
            	    {
            	    // InternalPreprocess.g:3812:1: (lv_expr_3_0= ruleAndExpression )
            	    // InternalPreprocess.g:3813:3: lv_expr_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getExprAndExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_33);
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
            	    break loop74;
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
    // InternalPreprocess.g:3843:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalPreprocess.g:3844:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalPreprocess.g:3845:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalPreprocess.g:3852:1: ruleAndExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_SKW_AND_2=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3858:7: ( ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalPreprocess.g:3860:1: ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalPreprocess.g:3860:1: ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* )
            // InternalPreprocess.g:3861:1: () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )*
            {
            // InternalPreprocess.g:3861:1: ()
            // InternalPreprocess.g:3862:2: 
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

            // InternalPreprocess.g:3873:1: ( (lv_expr_1_0= ruleEqualityExpression ) )
            // InternalPreprocess.g:3874:1: (lv_expr_1_0= ruleEqualityExpression )
            {
            // InternalPreprocess.g:3874:1: (lv_expr_1_0= ruleEqualityExpression )
            // InternalPreprocess.g:3875:3: lv_expr_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAndExpressionAccess().getExprEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_34);
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

            // InternalPreprocess.g:3894:1: (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==RULE_SKW_AND) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalPreprocess.g:3895:1: this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) )
            	    {
            	    this_SKW_AND_2=(Token)match(input,RULE_SKW_AND,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_AND_2, grammarAccess.getAndExpressionAccess().getSKW_ANDTerminalRuleCall_2_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:3902:1: ( (lv_expr_3_0= ruleEqualityExpression ) )
            	    // InternalPreprocess.g:3903:1: (lv_expr_3_0= ruleEqualityExpression )
            	    {
            	    // InternalPreprocess.g:3903:1: (lv_expr_3_0= ruleEqualityExpression )
            	    // InternalPreprocess.g:3904:3: lv_expr_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExpressionAccess().getExprEqualityExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_34);
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
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalPreprocess.g:3934:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalPreprocess.g:3935:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalPreprocess.g:3936:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalPreprocess.g:3943:1: ruleEqualityExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:3949:7: ( ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* ) )
            // InternalPreprocess.g:3951:1: ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* )
            {
            // InternalPreprocess.g:3951:1: ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* )
            // InternalPreprocess.g:3952:1: () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )*
            {
            // InternalPreprocess.g:3952:1: ()
            // InternalPreprocess.g:3953:2: 
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

            // InternalPreprocess.g:3964:1: ( (lv_expr_1_0= ruleRelationalExpression ) )
            // InternalPreprocess.g:3965:1: (lv_expr_1_0= ruleRelationalExpression )
            {
            // InternalPreprocess.g:3965:1: (lv_expr_1_0= ruleRelationalExpression )
            // InternalPreprocess.g:3966:3: lv_expr_1_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExprRelationalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_35);
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

            // InternalPreprocess.g:3985:1: ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( ((LA77_0>=RULE_SKW_EQUAL && LA77_0<=RULE_SKW_NOTEQUAL)) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalPreprocess.g:3986:1: ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) )
            	    {
            	    // InternalPreprocess.g:3986:1: ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) )
            	    int alt76=2;
            	    int LA76_0 = input.LA(1);

            	    if ( (LA76_0==RULE_SKW_EQUAL) ) {
            	        alt76=1;
            	    }
            	    else if ( (LA76_0==RULE_SKW_NOTEQUAL) ) {
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
            	            // InternalPreprocess.g:3987:1: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
            	            {
            	            // InternalPreprocess.g:3987:1: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
            	            // InternalPreprocess.g:3988:1: (lv_op_2_0= RULE_SKW_EQUAL )
            	            {
            	            // InternalPreprocess.g:3988:1: (lv_op_2_0= RULE_SKW_EQUAL )
            	            // InternalPreprocess.g:3989:3: lv_op_2_0= RULE_SKW_EQUAL
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
            	            // InternalPreprocess.g:4009:1: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
            	            {
            	            // InternalPreprocess.g:4009:1: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
            	            // InternalPreprocess.g:4010:1: (lv_op_3_0= RULE_SKW_NOTEQUAL )
            	            {
            	            // InternalPreprocess.g:4010:1: (lv_op_3_0= RULE_SKW_NOTEQUAL )
            	            // InternalPreprocess.g:4011:3: lv_op_3_0= RULE_SKW_NOTEQUAL
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

            	    // InternalPreprocess.g:4032:1: ( (lv_expr_4_0= ruleRelationalExpression ) )
            	    // InternalPreprocess.g:4033:1: (lv_expr_4_0= ruleRelationalExpression )
            	    {
            	    // InternalPreprocess.g:4033:1: (lv_expr_4_0= ruleRelationalExpression )
            	    // InternalPreprocess.g:4034:3: lv_expr_4_0= ruleRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExprRelationalExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_35);
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
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalPreprocess.g:4064:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalPreprocess.g:4065:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalPreprocess.g:4066:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalPreprocess.g:4073:1: ruleRelationalExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* ) ;
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
            // InternalPreprocess.g:4079:7: ( ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* ) )
            // InternalPreprocess.g:4081:1: ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* )
            {
            // InternalPreprocess.g:4081:1: ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* )
            // InternalPreprocess.g:4082:1: () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )*
            {
            // InternalPreprocess.g:4082:1: ()
            // InternalPreprocess.g:4083:2: 
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

            // InternalPreprocess.g:4094:1: ( (lv_expr_1_0= ruleShiftExpression ) )
            // InternalPreprocess.g:4095:1: (lv_expr_1_0= ruleShiftExpression )
            {
            // InternalPreprocess.g:4095:1: (lv_expr_1_0= ruleShiftExpression )
            // InternalPreprocess.g:4096:3: lv_expr_1_0= ruleShiftExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExprShiftExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_36);
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

            // InternalPreprocess.g:4115:1: ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( ((LA79_0>=RULE_SKW_LESS && LA79_0<=RULE_SKW_GREATEREQUAL)) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalPreprocess.g:4116:1: ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) )
            	    {
            	    // InternalPreprocess.g:4116:1: ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) )
            	    int alt78=4;
            	    switch ( input.LA(1) ) {
            	    case RULE_SKW_LESS:
            	        {
            	        alt78=1;
            	        }
            	        break;
            	    case RULE_SKW_GREATER:
            	        {
            	        alt78=2;
            	        }
            	        break;
            	    case RULE_SKW_LESSEQUAL:
            	        {
            	        alt78=3;
            	        }
            	        break;
            	    case RULE_SKW_GREATEREQUAL:
            	        {
            	        alt78=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 78, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt78) {
            	        case 1 :
            	            // InternalPreprocess.g:4117:1: ( (lv_op_2_0= RULE_SKW_LESS ) )
            	            {
            	            // InternalPreprocess.g:4117:1: ( (lv_op_2_0= RULE_SKW_LESS ) )
            	            // InternalPreprocess.g:4118:1: (lv_op_2_0= RULE_SKW_LESS )
            	            {
            	            // InternalPreprocess.g:4118:1: (lv_op_2_0= RULE_SKW_LESS )
            	            // InternalPreprocess.g:4119:3: lv_op_2_0= RULE_SKW_LESS
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
            	            // InternalPreprocess.g:4139:1: ( (lv_op_3_0= RULE_SKW_GREATER ) )
            	            {
            	            // InternalPreprocess.g:4139:1: ( (lv_op_3_0= RULE_SKW_GREATER ) )
            	            // InternalPreprocess.g:4140:1: (lv_op_3_0= RULE_SKW_GREATER )
            	            {
            	            // InternalPreprocess.g:4140:1: (lv_op_3_0= RULE_SKW_GREATER )
            	            // InternalPreprocess.g:4141:3: lv_op_3_0= RULE_SKW_GREATER
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
            	            // InternalPreprocess.g:4161:1: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
            	            {
            	            // InternalPreprocess.g:4161:1: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
            	            // InternalPreprocess.g:4162:1: (lv_op_4_0= RULE_SKW_LESSEQUAL )
            	            {
            	            // InternalPreprocess.g:4162:1: (lv_op_4_0= RULE_SKW_LESSEQUAL )
            	            // InternalPreprocess.g:4163:3: lv_op_4_0= RULE_SKW_LESSEQUAL
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
            	            // InternalPreprocess.g:4183:1: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
            	            {
            	            // InternalPreprocess.g:4183:1: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
            	            // InternalPreprocess.g:4184:1: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
            	            {
            	            // InternalPreprocess.g:4184:1: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
            	            // InternalPreprocess.g:4185:3: lv_op_5_0= RULE_SKW_GREATEREQUAL
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

            	    // InternalPreprocess.g:4206:1: ( (lv_expr_6_0= ruleShiftExpression ) )
            	    // InternalPreprocess.g:4207:1: (lv_expr_6_0= ruleShiftExpression )
            	    {
            	    // InternalPreprocess.g:4207:1: (lv_expr_6_0= ruleShiftExpression )
            	    // InternalPreprocess.g:4208:3: lv_expr_6_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExprShiftExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_36);
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
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleShiftExpression"
    // InternalPreprocess.g:4238:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalPreprocess.g:4239:2: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalPreprocess.g:4240:2: iv_ruleShiftExpression= ruleShiftExpression EOF
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
    // InternalPreprocess.g:4247:1: ruleShiftExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4253:7: ( ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* ) )
            // InternalPreprocess.g:4255:1: ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalPreprocess.g:4255:1: ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* )
            // InternalPreprocess.g:4256:1: () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )*
            {
            // InternalPreprocess.g:4256:1: ()
            // InternalPreprocess.g:4257:2: 
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

            // InternalPreprocess.g:4268:1: ( (lv_expr_1_0= ruleAdditiveExpression ) )
            // InternalPreprocess.g:4269:1: (lv_expr_1_0= ruleAdditiveExpression )
            {
            // InternalPreprocess.g:4269:1: (lv_expr_1_0= ruleAdditiveExpression )
            // InternalPreprocess.g:4270:3: lv_expr_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getExprAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_37);
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

            // InternalPreprocess.g:4289:1: ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( ((LA81_0>=RULE_SKW_LEFTSHIFT && LA81_0<=RULE_SKW_RIGHTSHIFT)) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalPreprocess.g:4290:1: ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalPreprocess.g:4290:1: ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) )
            	    int alt80=2;
            	    int LA80_0 = input.LA(1);

            	    if ( (LA80_0==RULE_SKW_LEFTSHIFT) ) {
            	        alt80=1;
            	    }
            	    else if ( (LA80_0==RULE_SKW_RIGHTSHIFT) ) {
            	        alt80=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 80, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt80) {
            	        case 1 :
            	            // InternalPreprocess.g:4291:1: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
            	            {
            	            // InternalPreprocess.g:4291:1: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
            	            // InternalPreprocess.g:4292:1: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
            	            {
            	            // InternalPreprocess.g:4292:1: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
            	            // InternalPreprocess.g:4293:3: lv_op_2_0= RULE_SKW_LEFTSHIFT
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
            	            // InternalPreprocess.g:4313:1: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
            	            {
            	            // InternalPreprocess.g:4313:1: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
            	            // InternalPreprocess.g:4314:1: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
            	            {
            	            // InternalPreprocess.g:4314:1: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
            	            // InternalPreprocess.g:4315:3: lv_op_3_0= RULE_SKW_RIGHTSHIFT
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

            	    // InternalPreprocess.g:4336:1: ( (lv_expr_4_0= ruleAdditiveExpression ) )
            	    // InternalPreprocess.g:4337:1: (lv_expr_4_0= ruleAdditiveExpression )
            	    {
            	    // InternalPreprocess.g:4337:1: (lv_expr_4_0= ruleAdditiveExpression )
            	    // InternalPreprocess.g:4338:3: lv_expr_4_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getExprAdditiveExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_37);
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
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalPreprocess.g:4368:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalPreprocess.g:4369:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalPreprocess.g:4370:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalPreprocess.g:4377:1: ruleAdditiveExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4383:7: ( ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalPreprocess.g:4385:1: ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalPreprocess.g:4385:1: ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* )
            // InternalPreprocess.g:4386:1: () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )*
            {
            // InternalPreprocess.g:4386:1: ()
            // InternalPreprocess.g:4387:2: 
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

            // InternalPreprocess.g:4398:1: ( (lv_expr_1_0= ruleMultiplicativeExpression ) )
            // InternalPreprocess.g:4399:1: (lv_expr_1_0= ruleMultiplicativeExpression )
            {
            // InternalPreprocess.g:4399:1: (lv_expr_1_0= ruleMultiplicativeExpression )
            // InternalPreprocess.g:4400:3: lv_expr_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExprMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_38);
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

            // InternalPreprocess.g:4419:1: ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( ((LA83_0>=RULE_SKW_PLUS && LA83_0<=RULE_SKW_MINUS)) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalPreprocess.g:4420:1: ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalPreprocess.g:4420:1: ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) )
            	    int alt82=2;
            	    int LA82_0 = input.LA(1);

            	    if ( (LA82_0==RULE_SKW_PLUS) ) {
            	        alt82=1;
            	    }
            	    else if ( (LA82_0==RULE_SKW_MINUS) ) {
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
            	            // InternalPreprocess.g:4421:1: ( (lv_op_2_0= RULE_SKW_PLUS ) )
            	            {
            	            // InternalPreprocess.g:4421:1: ( (lv_op_2_0= RULE_SKW_PLUS ) )
            	            // InternalPreprocess.g:4422:1: (lv_op_2_0= RULE_SKW_PLUS )
            	            {
            	            // InternalPreprocess.g:4422:1: (lv_op_2_0= RULE_SKW_PLUS )
            	            // InternalPreprocess.g:4423:3: lv_op_2_0= RULE_SKW_PLUS
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
            	            // InternalPreprocess.g:4443:1: ( (lv_op_3_0= RULE_SKW_MINUS ) )
            	            {
            	            // InternalPreprocess.g:4443:1: ( (lv_op_3_0= RULE_SKW_MINUS ) )
            	            // InternalPreprocess.g:4444:1: (lv_op_3_0= RULE_SKW_MINUS )
            	            {
            	            // InternalPreprocess.g:4444:1: (lv_op_3_0= RULE_SKW_MINUS )
            	            // InternalPreprocess.g:4445:3: lv_op_3_0= RULE_SKW_MINUS
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

            	    // InternalPreprocess.g:4466:1: ( (lv_expr_4_0= ruleMultiplicativeExpression ) )
            	    // InternalPreprocess.g:4467:1: (lv_expr_4_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalPreprocess.g:4467:1: (lv_expr_4_0= ruleMultiplicativeExpression )
            	    // InternalPreprocess.g:4468:3: lv_expr_4_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExprMultiplicativeExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_38);
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
            	    break loop83;
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
    // InternalPreprocess.g:4498:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalPreprocess.g:4499:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalPreprocess.g:4500:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalPreprocess.g:4507:1: ruleMultiplicativeExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* ) ;
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
            // InternalPreprocess.g:4513:7: ( ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* ) )
            // InternalPreprocess.g:4515:1: ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* )
            {
            // InternalPreprocess.g:4515:1: ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* )
            // InternalPreprocess.g:4516:1: () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )*
            {
            // InternalPreprocess.g:4516:1: ()
            // InternalPreprocess.g:4517:2: 
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

            // InternalPreprocess.g:4528:1: ( (lv_expr_1_0= ruleCastExpression ) )
            // InternalPreprocess.g:4529:1: (lv_expr_1_0= ruleCastExpression )
            {
            // InternalPreprocess.g:4529:1: (lv_expr_1_0= ruleCastExpression )
            // InternalPreprocess.g:4530:3: lv_expr_1_0= ruleCastExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExprCastExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_39);
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

            // InternalPreprocess.g:4549:1: ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( ((LA85_0>=RULE_SKW_STAR && LA85_0<=RULE_SKW_MOD)) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalPreprocess.g:4550:1: ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) )
            	    {
            	    // InternalPreprocess.g:4550:1: ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) )
            	    int alt84=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_SKW_STAR:
            	        {
            	        alt84=1;
            	        }
            	        break;
            	    case RULE_SKW_DIV:
            	        {
            	        alt84=2;
            	        }
            	        break;
            	    case RULE_SKW_MOD:
            	        {
            	        alt84=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 84, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt84) {
            	        case 1 :
            	            // InternalPreprocess.g:4551:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
            	            {
            	            // InternalPreprocess.g:4551:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
            	            // InternalPreprocess.g:4552:1: (lv_op_2_0= RULE_SKW_STAR )
            	            {
            	            // InternalPreprocess.g:4552:1: (lv_op_2_0= RULE_SKW_STAR )
            	            // InternalPreprocess.g:4553:3: lv_op_2_0= RULE_SKW_STAR
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
            	            // InternalPreprocess.g:4573:1: ( (lv_op_3_0= RULE_SKW_DIV ) )
            	            {
            	            // InternalPreprocess.g:4573:1: ( (lv_op_3_0= RULE_SKW_DIV ) )
            	            // InternalPreprocess.g:4574:1: (lv_op_3_0= RULE_SKW_DIV )
            	            {
            	            // InternalPreprocess.g:4574:1: (lv_op_3_0= RULE_SKW_DIV )
            	            // InternalPreprocess.g:4575:3: lv_op_3_0= RULE_SKW_DIV
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
            	            // InternalPreprocess.g:4595:1: ( (lv_op_4_0= RULE_SKW_MOD ) )
            	            {
            	            // InternalPreprocess.g:4595:1: ( (lv_op_4_0= RULE_SKW_MOD ) )
            	            // InternalPreprocess.g:4596:1: (lv_op_4_0= RULE_SKW_MOD )
            	            {
            	            // InternalPreprocess.g:4596:1: (lv_op_4_0= RULE_SKW_MOD )
            	            // InternalPreprocess.g:4597:3: lv_op_4_0= RULE_SKW_MOD
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

            	    // InternalPreprocess.g:4618:1: ( (lv_expr_5_0= ruleCastExpression ) )
            	    // InternalPreprocess.g:4619:1: (lv_expr_5_0= ruleCastExpression )
            	    {
            	    // InternalPreprocess.g:4619:1: (lv_expr_5_0= ruleCastExpression )
            	    // InternalPreprocess.g:4620:3: lv_expr_5_0= ruleCastExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExprCastExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_39);
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
            	    break loop85;
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
    // InternalPreprocess.g:4650:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalPreprocess.g:4651:2: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalPreprocess.g:4652:2: iv_ruleCastExpression= ruleCastExpression EOF
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
    // InternalPreprocess.g:4659:1: ruleCastExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4665:7: ( ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // InternalPreprocess.g:4667:1: ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // InternalPreprocess.g:4667:1: ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // InternalPreprocess.g:4668:1: () ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // InternalPreprocess.g:4668:1: ()
            // InternalPreprocess.g:4669:2: 
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

            // InternalPreprocess.g:4680:1: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // InternalPreprocess.g:4681:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // InternalPreprocess.g:4681:1: (lv_expr_1_0= ruleUnaryExpression )
            // InternalPreprocess.g:4682:3: lv_expr_1_0= ruleUnaryExpression
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
    // InternalPreprocess.g:4710:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalPreprocess.g:4711:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalPreprocess.g:4712:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalPreprocess.g:4719:1: ruleUnaryExpression returns [EObject current=null] : ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;

        EObject lv_op_2_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:4725:7: ( ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) ) )
            // InternalPreprocess.g:4727:1: ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) )
            {
            // InternalPreprocess.g:4727:1: ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) )
            // InternalPreprocess.g:4728:1: () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
            {
            // InternalPreprocess.g:4728:1: ()
            // InternalPreprocess.g:4729:2: 
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

            // InternalPreprocess.g:4740:1: ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RULE_SKW_LEFTPAREN||LA86_0==RULE_ID||LA86_0==RULE_DEFINED||(LA86_0>=RULE_HEX_LITERAL && LA86_0<=RULE_BIN_LITERAL)) ) {
                alt86=1;
            }
            else if ( (LA86_0==RULE_SKW_AND||(LA86_0>=RULE_SKW_PLUS && LA86_0<=RULE_SKW_STAR)||(LA86_0>=RULE_SKW_TILDE && LA86_0<=RULE_SKW_NOT)) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // InternalPreprocess.g:4741:1: ( (lv_expr_1_0= rulePostfixExpression ) )
                    {
                    // InternalPreprocess.g:4741:1: ( (lv_expr_1_0= rulePostfixExpression ) )
                    // InternalPreprocess.g:4742:1: (lv_expr_1_0= rulePostfixExpression )
                    {
                    // InternalPreprocess.g:4742:1: (lv_expr_1_0= rulePostfixExpression )
                    // InternalPreprocess.g:4743:3: lv_expr_1_0= rulePostfixExpression
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
                    // InternalPreprocess.g:4763:1: ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
                    {
                    // InternalPreprocess.g:4763:1: ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
                    // InternalPreprocess.g:4764:1: ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) )
                    {
                    // InternalPreprocess.g:4764:1: ( (lv_op_2_0= ruleUnaryOperator ) )
                    // InternalPreprocess.g:4765:1: (lv_op_2_0= ruleUnaryOperator )
                    {
                    // InternalPreprocess.g:4765:1: (lv_op_2_0= ruleUnaryOperator )
                    // InternalPreprocess.g:4766:3: lv_op_2_0= ruleUnaryOperator
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

                    // InternalPreprocess.g:4785:1: ( (lv_expr_3_0= ruleCastExpression ) )
                    // InternalPreprocess.g:4786:1: (lv_expr_3_0= ruleCastExpression )
                    {
                    // InternalPreprocess.g:4786:1: (lv_expr_3_0= ruleCastExpression )
                    // InternalPreprocess.g:4787:3: lv_expr_3_0= ruleCastExpression
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
    // InternalPreprocess.g:4819:1: entryRuleUnaryOperator returns [EObject current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final EObject entryRuleUnaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperator = null;


        try {
            // InternalPreprocess.g:4820:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalPreprocess.g:4821:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
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
    // InternalPreprocess.g:4828:1: ruleUnaryOperator returns [EObject current=null] : ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) ) ;
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
            // InternalPreprocess.g:4834:7: ( ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) ) )
            // InternalPreprocess.g:4836:1: ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) )
            {
            // InternalPreprocess.g:4836:1: ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) )
            int alt87=6;
            switch ( input.LA(1) ) {
            case RULE_SKW_AND:
                {
                alt87=1;
                }
                break;
            case RULE_SKW_STAR:
                {
                alt87=2;
                }
                break;
            case RULE_SKW_PLUS:
                {
                alt87=3;
                }
                break;
            case RULE_SKW_MINUS:
                {
                alt87=4;
                }
                break;
            case RULE_SKW_TILDE:
                {
                alt87=5;
                }
                break;
            case RULE_SKW_NOT:
                {
                alt87=6;
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
                    // InternalPreprocess.g:4837:1: ( () ( (lv_op_1_0= RULE_SKW_AND ) ) )
                    {
                    // InternalPreprocess.g:4837:1: ( () ( (lv_op_1_0= RULE_SKW_AND ) ) )
                    // InternalPreprocess.g:4838:1: () ( (lv_op_1_0= RULE_SKW_AND ) )
                    {
                    // InternalPreprocess.g:4838:1: ()
                    // InternalPreprocess.g:4839:2: 
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

                    // InternalPreprocess.g:4850:1: ( (lv_op_1_0= RULE_SKW_AND ) )
                    // InternalPreprocess.g:4851:1: (lv_op_1_0= RULE_SKW_AND )
                    {
                    // InternalPreprocess.g:4851:1: (lv_op_1_0= RULE_SKW_AND )
                    // InternalPreprocess.g:4852:3: lv_op_1_0= RULE_SKW_AND
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
                    // InternalPreprocess.g:4874:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
                    {
                    // InternalPreprocess.g:4874:1: ( (lv_op_2_0= RULE_SKW_STAR ) )
                    // InternalPreprocess.g:4875:1: (lv_op_2_0= RULE_SKW_STAR )
                    {
                    // InternalPreprocess.g:4875:1: (lv_op_2_0= RULE_SKW_STAR )
                    // InternalPreprocess.g:4876:3: lv_op_2_0= RULE_SKW_STAR
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
                    // InternalPreprocess.g:4896:1: ( (lv_op_3_0= RULE_SKW_PLUS ) )
                    {
                    // InternalPreprocess.g:4896:1: ( (lv_op_3_0= RULE_SKW_PLUS ) )
                    // InternalPreprocess.g:4897:1: (lv_op_3_0= RULE_SKW_PLUS )
                    {
                    // InternalPreprocess.g:4897:1: (lv_op_3_0= RULE_SKW_PLUS )
                    // InternalPreprocess.g:4898:3: lv_op_3_0= RULE_SKW_PLUS
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
                    // InternalPreprocess.g:4918:1: ( (lv_op_4_0= RULE_SKW_MINUS ) )
                    {
                    // InternalPreprocess.g:4918:1: ( (lv_op_4_0= RULE_SKW_MINUS ) )
                    // InternalPreprocess.g:4919:1: (lv_op_4_0= RULE_SKW_MINUS )
                    {
                    // InternalPreprocess.g:4919:1: (lv_op_4_0= RULE_SKW_MINUS )
                    // InternalPreprocess.g:4920:3: lv_op_4_0= RULE_SKW_MINUS
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
                    // InternalPreprocess.g:4940:1: ( (lv_op_5_0= RULE_SKW_TILDE ) )
                    {
                    // InternalPreprocess.g:4940:1: ( (lv_op_5_0= RULE_SKW_TILDE ) )
                    // InternalPreprocess.g:4941:1: (lv_op_5_0= RULE_SKW_TILDE )
                    {
                    // InternalPreprocess.g:4941:1: (lv_op_5_0= RULE_SKW_TILDE )
                    // InternalPreprocess.g:4942:3: lv_op_5_0= RULE_SKW_TILDE
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
                    // InternalPreprocess.g:4962:1: ( (lv_op_6_0= RULE_SKW_NOT ) )
                    {
                    // InternalPreprocess.g:4962:1: ( (lv_op_6_0= RULE_SKW_NOT ) )
                    // InternalPreprocess.g:4963:1: (lv_op_6_0= RULE_SKW_NOT )
                    {
                    // InternalPreprocess.g:4963:1: (lv_op_6_0= RULE_SKW_NOT )
                    // InternalPreprocess.g:4964:3: lv_op_6_0= RULE_SKW_NOT
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
    // InternalPreprocess.g:4992:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalPreprocess.g:4993:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalPreprocess.g:4994:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalPreprocess.g:5001:1: rulePostfixExpression returns [EObject current=null] : ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_1_0 = null;

        EObject lv_suffix_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:5007:7: ( ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) ) )
            // InternalPreprocess.g:5009:1: ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) )
            {
            // InternalPreprocess.g:5009:1: ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) )
            // InternalPreprocess.g:5010:1: () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* )
            {
            // InternalPreprocess.g:5010:1: ()
            // InternalPreprocess.g:5011:2: 
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

            // InternalPreprocess.g:5022:1: ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* )
            // InternalPreprocess.g:5023:1: ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )*
            {
            // InternalPreprocess.g:5023:1: ( (lv_expr_1_0= rulePrimaryExpression ) )
            // InternalPreprocess.g:5024:1: (lv_expr_1_0= rulePrimaryExpression )
            {
            // InternalPreprocess.g:5024:1: (lv_expr_1_0= rulePrimaryExpression )
            // InternalPreprocess.g:5025:3: lv_expr_1_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getExprPrimaryExpressionParserRuleCall_1_0_0()); 
              	    
            }
            pushFollow(FOLLOW_40);
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

            // InternalPreprocess.g:5044:1: ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==RULE_SKW_LEFTPAREN) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalPreprocess.g:5045:1: (lv_suffix_2_0= rulePostfixExpressionSuffixArgument )
            	    {
            	    // InternalPreprocess.g:5045:1: (lv_suffix_2_0= rulePostfixExpressionSuffixArgument )
            	    // InternalPreprocess.g:5046:3: lv_suffix_2_0= rulePostfixExpressionSuffixArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getSuffixPostfixExpressionSuffixArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_40);
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
            	    break loop88;
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
    // InternalPreprocess.g:5076:1: entryRulePostfixExpressionSuffixArgument returns [EObject current=null] : iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF ;
    public final EObject entryRulePostfixExpressionSuffixArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpressionSuffixArgument = null;


        try {
            // InternalPreprocess.g:5077:2: (iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF )
            // InternalPreprocess.g:5078:2: iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF
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
    // InternalPreprocess.g:5085:1: rulePostfixExpressionSuffixArgument returns [EObject current=null] : ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN ) ;
    public final EObject rulePostfixExpressionSuffixArgument() throws RecognitionException {
        EObject current = null;

        Token this_SKW_LEFTPAREN_1=null;
        Token this_SKW_RIGHTPAREN_3=null;
        EObject lv_argumentExpressionList_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:5091:7: ( ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN ) )
            // InternalPreprocess.g:5093:1: ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN )
            {
            // InternalPreprocess.g:5093:1: ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN )
            // InternalPreprocess.g:5094:1: () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN
            {
            // InternalPreprocess.g:5094:1: ()
            // InternalPreprocess.g:5095:2: 
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
            // InternalPreprocess.g:5113:1: ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==RULE_SKW_LEFTPAREN||LA89_0==RULE_ID||LA89_0==RULE_DEFINED||LA89_0==RULE_SKW_AND||(LA89_0>=RULE_SKW_PLUS && LA89_0<=RULE_SKW_STAR)||(LA89_0>=RULE_SKW_TILDE && LA89_0<=RULE_BIN_LITERAL)) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalPreprocess.g:5114:1: (lv_argumentExpressionList_2_0= ruleArgumentExpressionList )
                    {
                    // InternalPreprocess.g:5114:1: (lv_argumentExpressionList_2_0= ruleArgumentExpressionList )
                    // InternalPreprocess.g:5115:3: lv_argumentExpressionList_2_0= ruleArgumentExpressionList
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
    // InternalPreprocess.g:5150:1: entryRuleArgumentExpressionList returns [EObject current=null] : iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF ;
    public final EObject entryRuleArgumentExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentExpressionList = null;


        try {
            // InternalPreprocess.g:5151:2: (iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF )
            // InternalPreprocess.g:5152:2: iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF
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
    // InternalPreprocess.g:5159:1: ruleArgumentExpressionList returns [EObject current=null] : ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* ) ;
    public final EObject ruleArgumentExpressionList() throws RecognitionException {
        EObject current = null;

        Token this_SKW_COMMA_1=null;
        EObject lv_expr_0_0 = null;

        EObject lv_expr_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalPreprocess.g:5165:7: ( ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* ) )
            // InternalPreprocess.g:5167:1: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* )
            {
            // InternalPreprocess.g:5167:1: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* )
            // InternalPreprocess.g:5168:1: ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )*
            {
            // InternalPreprocess.g:5168:1: ( (lv_expr_0_0= ruleConditionalExpression ) )
            // InternalPreprocess.g:5169:1: (lv_expr_0_0= ruleConditionalExpression )
            {
            // InternalPreprocess.g:5169:1: (lv_expr_0_0= ruleConditionalExpression )
            // InternalPreprocess.g:5170:3: lv_expr_0_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArgumentExpressionListAccess().getExprConditionalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_41);
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

            // InternalPreprocess.g:5189:1: (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==RULE_SKW_COMMA) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // InternalPreprocess.g:5190:1: this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) )
            	    {
            	    this_SKW_COMMA_1=(Token)match(input,RULE_SKW_COMMA,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SKW_COMMA_1, grammarAccess.getArgumentExpressionListAccess().getSKW_COMMATerminalRuleCall_1_0()); 
            	          
            	    }
            	    // InternalPreprocess.g:5197:1: ( (lv_expr_2_0= ruleConditionalExpression ) )
            	    // InternalPreprocess.g:5198:1: (lv_expr_2_0= ruleConditionalExpression )
            	    {
            	    // InternalPreprocess.g:5198:1: (lv_expr_2_0= ruleConditionalExpression )
            	    // InternalPreprocess.g:5199:3: lv_expr_2_0= ruleConditionalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArgumentExpressionListAccess().getExprConditionalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_41);
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
            	    break loop90;
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
    // InternalPreprocess.g:5229:1: entryRuleConstant1 returns [String current=null] : iv_ruleConstant1= ruleConstant1 EOF ;
    public final String entryRuleConstant1() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConstant1 = null;


        try {
            // InternalPreprocess.g:5230:2: (iv_ruleConstant1= ruleConstant1 EOF )
            // InternalPreprocess.g:5231:2: iv_ruleConstant1= ruleConstant1 EOF
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
    // InternalPreprocess.g:5238:1: ruleConstant1 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL ) ;
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
            // InternalPreprocess.g:5241:28: ( (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL ) )
            // InternalPreprocess.g:5242:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL )
            {
            // InternalPreprocess.g:5242:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL | this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL | this_CHAR_LITERAL_3= RULE_CHAR_LITERAL | this_STRING_LITERAL_4= RULE_STRING_LITERAL | this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL | this_BIN_LITERAL_6= RULE_BIN_LITERAL )
            int alt91=7;
            switch ( input.LA(1) ) {
            case RULE_HEX_LITERAL:
                {
                alt91=1;
                }
                break;
            case RULE_OCTAL_LITERAL:
                {
                alt91=2;
                }
                break;
            case RULE_DECIMAL_LITERAL:
                {
                alt91=3;
                }
                break;
            case RULE_CHAR_LITERAL:
                {
                alt91=4;
                }
                break;
            case RULE_STRING_LITERAL:
                {
                alt91=5;
                }
                break;
            case RULE_FLOAT_LITERAL:
                {
                alt91=6;
                }
                break;
            case RULE_BIN_LITERAL:
                {
                alt91=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }

            switch (alt91) {
                case 1 :
                    // InternalPreprocess.g:5242:6: this_HEX_LITERAL_0= RULE_HEX_LITERAL
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
                    // InternalPreprocess.g:5250:10: this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL
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
                    // InternalPreprocess.g:5258:10: this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL
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
                    // InternalPreprocess.g:5266:10: this_CHAR_LITERAL_3= RULE_CHAR_LITERAL
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
                    // InternalPreprocess.g:5274:10: this_STRING_LITERAL_4= RULE_STRING_LITERAL
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
                    // InternalPreprocess.g:5282:10: this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL
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
                    // InternalPreprocess.g:5290:10: this_BIN_LITERAL_6= RULE_BIN_LITERAL
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
    // InternalPreprocess.g:5307:1: entryRuleSpecialKeywords returns [String current=null] : iv_ruleSpecialKeywords= ruleSpecialKeywords EOF ;
    public final String entryRuleSpecialKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpecialKeywords = null;


        try {
            // InternalPreprocess.g:5308:2: (iv_ruleSpecialKeywords= ruleSpecialKeywords EOF )
            // InternalPreprocess.g:5309:2: iv_ruleSpecialKeywords= ruleSpecialKeywords EOF
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
    // InternalPreprocess.g:5316:1: ruleSpecialKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE ) ;
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
            // InternalPreprocess.g:5319:28: ( (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE ) )
            // InternalPreprocess.g:5320:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE )
            {
            // InternalPreprocess.g:5320:1: (this_SKW_AND_0= RULE_SKW_AND | this_SKW_ANDAND_1= RULE_SKW_ANDAND | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH | this_SKW_CARET_4= RULE_SKW_CARET | this_SKW_COMMA_5= RULE_SKW_COMMA | this_SKW_COLON_6= RULE_SKW_COLON | this_SKW_DIV_7= RULE_SKW_DIV | this_SKW_DOT_8= RULE_SKW_DOT | this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE | this_SKW_EQUAL_10= RULE_SKW_EQUAL | this_SKW_GREATER_11= RULE_SKW_GREATER | this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL | this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE | this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET | this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN | this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT | this_SKW_LESS_17= RULE_SKW_LESS | this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL | this_SKW_MINUS_19= RULE_SKW_MINUS | this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS | this_SKW_MOD_21= RULE_SKW_MOD | this_SKW_NOT_22= RULE_SKW_NOT | this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL | this_SKW_OR_24= RULE_SKW_OR | this_SKW_OROR_25= RULE_SKW_OROR | this_SKW_PLUS_26= RULE_SKW_PLUS | this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS | this_SKW_QUESTION_28= RULE_SKW_QUESTION | this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE | this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET | this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN | this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT | this_SKW_SEMI_33= RULE_SKW_SEMI | this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE | this_SKW_STAR_35= RULE_SKW_STAR | this_SKW_TILDE_36= RULE_SKW_TILDE )
            int alt92=37;
            switch ( input.LA(1) ) {
            case RULE_SKW_AND:
                {
                alt92=1;
                }
                break;
            case RULE_SKW_ANDAND:
                {
                alt92=2;
                }
                break;
            case RULE_SKW_ASSIGN:
                {
                alt92=3;
                }
                break;
            case RULE_SKW_BACKSLASH:
                {
                alt92=4;
                }
                break;
            case RULE_SKW_CARET:
                {
                alt92=5;
                }
                break;
            case RULE_SKW_COMMA:
                {
                alt92=6;
                }
                break;
            case RULE_SKW_COLON:
                {
                alt92=7;
                }
                break;
            case RULE_SKW_DIV:
                {
                alt92=8;
                }
                break;
            case RULE_SKW_DOT:
                {
                alt92=9;
                }
                break;
            case RULE_SKW_DOUBLEQUOTE:
                {
                alt92=10;
                }
                break;
            case RULE_SKW_EQUAL:
                {
                alt92=11;
                }
                break;
            case RULE_SKW_GREATER:
                {
                alt92=12;
                }
                break;
            case RULE_SKW_GREATEREQUAL:
                {
                alt92=13;
                }
                break;
            case RULE_SKW_LEFTBRACE:
                {
                alt92=14;
                }
                break;
            case RULE_SKW_LEFTBRACKET:
                {
                alt92=15;
                }
                break;
            case RULE_SKW_LEFTPAREN:
                {
                alt92=16;
                }
                break;
            case RULE_SKW_LEFTSHIFT:
                {
                alt92=17;
                }
                break;
            case RULE_SKW_LESS:
                {
                alt92=18;
                }
                break;
            case RULE_SKW_LESSEQUAL:
                {
                alt92=19;
                }
                break;
            case RULE_SKW_MINUS:
                {
                alt92=20;
                }
                break;
            case RULE_SKW_MINUSMINUS:
                {
                alt92=21;
                }
                break;
            case RULE_SKW_MOD:
                {
                alt92=22;
                }
                break;
            case RULE_SKW_NOT:
                {
                alt92=23;
                }
                break;
            case RULE_SKW_NOTEQUAL:
                {
                alt92=24;
                }
                break;
            case RULE_SKW_OR:
                {
                alt92=25;
                }
                break;
            case RULE_SKW_OROR:
                {
                alt92=26;
                }
                break;
            case RULE_SKW_PLUS:
                {
                alt92=27;
                }
                break;
            case RULE_SKW_PLUSPLUS:
                {
                alt92=28;
                }
                break;
            case RULE_SKW_QUESTION:
                {
                alt92=29;
                }
                break;
            case RULE_SKW_RIGHTBRACE:
                {
                alt92=30;
                }
                break;
            case RULE_SKW_RIGHTBRACKET:
                {
                alt92=31;
                }
                break;
            case RULE_SKW_RIGHTPAREN:
                {
                alt92=32;
                }
                break;
            case RULE_SKW_RIGHTSHIFT:
                {
                alt92=33;
                }
                break;
            case RULE_SKW_SEMI:
                {
                alt92=34;
                }
                break;
            case RULE_SKW_SINGLEQUOTE:
                {
                alt92=35;
                }
                break;
            case RULE_SKW_STAR:
                {
                alt92=36;
                }
                break;
            case RULE_SKW_TILDE:
                {
                alt92=37;
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
                    // InternalPreprocess.g:5320:6: this_SKW_AND_0= RULE_SKW_AND
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
                    // InternalPreprocess.g:5328:10: this_SKW_ANDAND_1= RULE_SKW_ANDAND
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
                    // InternalPreprocess.g:5336:10: this_SKW_ASSIGN_2= RULE_SKW_ASSIGN
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
                    // InternalPreprocess.g:5344:10: this_SKW_BACKSLASH_3= RULE_SKW_BACKSLASH
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
                    // InternalPreprocess.g:5352:10: this_SKW_CARET_4= RULE_SKW_CARET
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
                    // InternalPreprocess.g:5360:10: this_SKW_COMMA_5= RULE_SKW_COMMA
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
                    // InternalPreprocess.g:5368:10: this_SKW_COLON_6= RULE_SKW_COLON
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
                    // InternalPreprocess.g:5376:10: this_SKW_DIV_7= RULE_SKW_DIV
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
                    // InternalPreprocess.g:5384:10: this_SKW_DOT_8= RULE_SKW_DOT
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
                    // InternalPreprocess.g:5392:10: this_SKW_DOUBLEQUOTE_9= RULE_SKW_DOUBLEQUOTE
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
                    // InternalPreprocess.g:5400:10: this_SKW_EQUAL_10= RULE_SKW_EQUAL
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
                    // InternalPreprocess.g:5408:10: this_SKW_GREATER_11= RULE_SKW_GREATER
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
                    // InternalPreprocess.g:5416:10: this_SKW_GREATEREQUAL_12= RULE_SKW_GREATEREQUAL
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
                    // InternalPreprocess.g:5424:10: this_SKW_LEFTBRACE_13= RULE_SKW_LEFTBRACE
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
                    // InternalPreprocess.g:5432:10: this_SKW_LEFTBRACKET_14= RULE_SKW_LEFTBRACKET
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
                    // InternalPreprocess.g:5440:10: this_SKW_LEFTPAREN_15= RULE_SKW_LEFTPAREN
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
                    // InternalPreprocess.g:5448:10: this_SKW_LEFTSHIFT_16= RULE_SKW_LEFTSHIFT
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
                    // InternalPreprocess.g:5456:10: this_SKW_LESS_17= RULE_SKW_LESS
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
                    // InternalPreprocess.g:5464:10: this_SKW_LESSEQUAL_18= RULE_SKW_LESSEQUAL
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
                    // InternalPreprocess.g:5472:10: this_SKW_MINUS_19= RULE_SKW_MINUS
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
                    // InternalPreprocess.g:5480:10: this_SKW_MINUSMINUS_20= RULE_SKW_MINUSMINUS
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
                    // InternalPreprocess.g:5488:10: this_SKW_MOD_21= RULE_SKW_MOD
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
                    // InternalPreprocess.g:5496:10: this_SKW_NOT_22= RULE_SKW_NOT
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
                    // InternalPreprocess.g:5504:10: this_SKW_NOTEQUAL_23= RULE_SKW_NOTEQUAL
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
                    // InternalPreprocess.g:5512:10: this_SKW_OR_24= RULE_SKW_OR
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
                    // InternalPreprocess.g:5520:10: this_SKW_OROR_25= RULE_SKW_OROR
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
                    // InternalPreprocess.g:5528:10: this_SKW_PLUS_26= RULE_SKW_PLUS
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
                    // InternalPreprocess.g:5536:10: this_SKW_PLUSPLUS_27= RULE_SKW_PLUSPLUS
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
                    // InternalPreprocess.g:5544:10: this_SKW_QUESTION_28= RULE_SKW_QUESTION
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
                    // InternalPreprocess.g:5552:10: this_SKW_RIGHTBRACE_29= RULE_SKW_RIGHTBRACE
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
                    // InternalPreprocess.g:5560:10: this_SKW_RIGHTBRACKET_30= RULE_SKW_RIGHTBRACKET
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
                    // InternalPreprocess.g:5568:10: this_SKW_RIGHTPAREN_31= RULE_SKW_RIGHTPAREN
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
                    // InternalPreprocess.g:5576:10: this_SKW_RIGHTSHIFT_32= RULE_SKW_RIGHTSHIFT
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
                    // InternalPreprocess.g:5584:10: this_SKW_SEMI_33= RULE_SKW_SEMI
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
                    // InternalPreprocess.g:5592:10: this_SKW_SINGLEQUOTE_34= RULE_SKW_SINGLEQUOTE
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
                    // InternalPreprocess.g:5600:10: this_SKW_STAR_35= RULE_SKW_STAR
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
                    // InternalPreprocess.g:5608:10: this_SKW_TILDE_36= RULE_SKW_TILDE
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
    // InternalPreprocess.g:5623:1: entryRuleEllipsis returns [String current=null] : iv_ruleEllipsis= ruleEllipsis EOF ;
    public final String entryRuleEllipsis() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEllipsis = null;


        try {
            // InternalPreprocess.g:5624:2: (iv_ruleEllipsis= ruleEllipsis EOF )
            // InternalPreprocess.g:5625:2: iv_ruleEllipsis= ruleEllipsis EOF
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
    // InternalPreprocess.g:5632:1: ruleEllipsis returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_DOT_0= RULE_SKW_DOT this_SKW_DOT_1= RULE_SKW_DOT this_SKW_DOT_2= RULE_SKW_DOT ) ;
    public final AntlrDatatypeRuleToken ruleEllipsis() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_DOT_0=null;
        Token this_SKW_DOT_1=null;
        Token this_SKW_DOT_2=null;

         enterRule(); 
            
        try {
            // InternalPreprocess.g:5635:28: ( (this_SKW_DOT_0= RULE_SKW_DOT this_SKW_DOT_1= RULE_SKW_DOT this_SKW_DOT_2= RULE_SKW_DOT ) )
            // InternalPreprocess.g:5636:1: (this_SKW_DOT_0= RULE_SKW_DOT this_SKW_DOT_1= RULE_SKW_DOT this_SKW_DOT_2= RULE_SKW_DOT )
            {
            // InternalPreprocess.g:5636:1: (this_SKW_DOT_0= RULE_SKW_DOT this_SKW_DOT_1= RULE_SKW_DOT this_SKW_DOT_2= RULE_SKW_DOT )
            // InternalPreprocess.g:5636:6: this_SKW_DOT_0= RULE_SKW_DOT this_SKW_DOT_1= RULE_SKW_DOT this_SKW_DOT_2= RULE_SKW_DOT
            {
            this_SKW_DOT_0=(Token)match(input,RULE_SKW_DOT,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_SKW_DOT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SKW_DOT_0, grammarAccess.getEllipsisAccess().getSKW_DOTTerminalRuleCall_0()); 
                  
            }
            this_SKW_DOT_1=(Token)match(input,RULE_SKW_DOT,FOLLOW_42); if (state.failed) return current;
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

    // $ANTLR start synpred20_InternalPreprocess
    public final void synpred20_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_4=null;
        AntlrDatatypeRuleToken lv_string_5_0 = null;


        // InternalPreprocess.g:863:1: ( (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine2 ) ) )
        // InternalPreprocess.g:863:1: (this_WHITESPACE_4= RULE_WHITESPACE )+ ( (lv_string_5_0= ruleMyDefineLine2 ) )
        {
        // InternalPreprocess.g:863:1: (this_WHITESPACE_4= RULE_WHITESPACE )+
        int cnt93=0;
        loop93:
        do {
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==RULE_WHITESPACE) ) {
                int LA93_2 = input.LA(2);

                if ( (synpred19_InternalPreprocess()) ) {
                    alt93=1;
                }


            }


            switch (alt93) {
        	case 1 :
        	    // InternalPreprocess.g:863:2: this_WHITESPACE_4= RULE_WHITESPACE
        	    {
        	    this_WHITESPACE_4=(Token)match(input,RULE_WHITESPACE,FOLLOW_9); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt93 >= 1 ) break loop93;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(93, input);
                    throw eee;
            }
            cnt93++;
        } while (true);

        // InternalPreprocess.g:870:1: ( (lv_string_5_0= ruleMyDefineLine2 ) )
        // InternalPreprocess.g:871:1: (lv_string_5_0= ruleMyDefineLine2 )
        {
        // InternalPreprocess.g:871:1: (lv_string_5_0= ruleMyDefineLine2 )
        // InternalPreprocess.g:872:3: lv_string_5_0= ruleMyDefineLine2
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getDefineObjectMacroAccess().getStringMyDefineLine2ParserRuleCall_4_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_string_5_0=ruleMyDefineLine2();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred20_InternalPreprocess

    // $ANTLR start synpred38_InternalPreprocess
    public final void synpred38_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_2=null;

        // InternalPreprocess.g:1460:2: (this_WHITESPACE_2= RULE_WHITESPACE )
        // InternalPreprocess.g:1460:2: this_WHITESPACE_2= RULE_WHITESPACE
        {
        this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_InternalPreprocess

    // $ANTLR start synpred40_InternalPreprocess
    public final void synpred40_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_2=null;

        // InternalPreprocess.g:1534:2: (this_WHITESPACE_2= RULE_WHITESPACE )
        // InternalPreprocess.g:1534:2: this_WHITESPACE_2= RULE_WHITESPACE
        {
        this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_InternalPreprocess

    // $ANTLR start synpred64_InternalPreprocess
    public final void synpred64_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_2=null;

        // InternalPreprocess.g:2421:2: (this_WHITESPACE_2= RULE_WHITESPACE )
        // InternalPreprocess.g:2421:2: this_WHITESPACE_2= RULE_WHITESPACE
        {
        this_WHITESPACE_2=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred64_InternalPreprocess

    // $ANTLR start synpred82_InternalPreprocess
    public final void synpred82_InternalPreprocess_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_MyCode_0 = null;


        // InternalPreprocess.g:2768:5: (this_MyCode_0= ruleMyCode )
        // InternalPreprocess.g:2768:5: this_MyCode_0= ruleMyCode
        {
        if ( state.backtracking==0 ) {
           
                  newCompositeNode(grammarAccess.getMyDefineLineAccess().getMyCodeParserRuleCall_0()); 
              
        }
        pushFollow(FOLLOW_2);
        this_MyCode_0=ruleMyCode();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred82_InternalPreprocess

    // $ANTLR start synpred83_InternalPreprocess
    public final void synpred83_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_1=null;

        // InternalPreprocess.g:2779:10: (this_WHITESPACE_1= RULE_WHITESPACE )
        // InternalPreprocess.g:2779:10: this_WHITESPACE_1= RULE_WHITESPACE
        {
        this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred83_InternalPreprocess

    // $ANTLR start synpred84_InternalPreprocess
    public final void synpred84_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_VA_ARGS_2=null;

        // InternalPreprocess.g:2787:10: (this_VA_ARGS_2= RULE_VA_ARGS )
        // InternalPreprocess.g:2787:10: this_VA_ARGS_2= RULE_VA_ARGS
        {
        this_VA_ARGS_2=(Token)match(input,RULE_VA_ARGS,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred84_InternalPreprocess

    // $ANTLR start synpred86_InternalPreprocess
    public final void synpred86_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_1=null;

        // InternalPreprocess.g:2827:10: (this_WHITESPACE_1= RULE_WHITESPACE )
        // InternalPreprocess.g:2827:10: this_WHITESPACE_1= RULE_WHITESPACE
        {
        this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred86_InternalPreprocess

    // $ANTLR start synpred87_InternalPreprocess
    public final void synpred87_InternalPreprocess_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_MyCode_0 = null;


        // InternalPreprocess.g:2856:5: (this_MyCode_0= ruleMyCode )
        // InternalPreprocess.g:2856:5: this_MyCode_0= ruleMyCode
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
    // $ANTLR end synpred87_InternalPreprocess

    // $ANTLR start synpred88_InternalPreprocess
    public final void synpred88_InternalPreprocess_fragment() throws RecognitionException {   
        Token this_WHITESPACE_1=null;

        // InternalPreprocess.g:2867:10: (this_WHITESPACE_1= RULE_WHITESPACE )
        // InternalPreprocess.g:2867:10: this_WHITESPACE_1= RULE_WHITESPACE
        {
        this_WHITESPACE_1=(Token)match(input,RULE_WHITESPACE,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred88_InternalPreprocess

    // $ANTLR start synpred92_InternalPreprocess
    public final void synpred92_InternalPreprocess_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_MyCode_1 = null;


        // InternalPreprocess.g:2975:5: (this_MyCode_1= ruleMyCode )
        // InternalPreprocess.g:2975:5: this_MyCode_1= ruleMyCode
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
    // $ANTLR end synpred92_InternalPreprocess

    // $ANTLR start synpred98_InternalPreprocess
    public final void synpred98_InternalPreprocess_fragment() throws RecognitionException {   
        Token lv_defined_3_0=null;
        Token this_SKW_LEFTPAREN_4=null;
        Token lv_id_5_0=null;
        Token this_SKW_RIGHTPAREN_6=null;

        // InternalPreprocess.g:3089:1: ( ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN ) )
        // InternalPreprocess.g:3089:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
        {
        // InternalPreprocess.g:3089:1: ( ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )
        // InternalPreprocess.g:3090:1: ( (lv_defined_3_0= RULE_DEFINED ) )? this_SKW_LEFTPAREN_4= RULE_SKW_LEFTPAREN ( (lv_id_5_0= RULE_ID ) ) this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN
        {
        // InternalPreprocess.g:3090:1: ( (lv_defined_3_0= RULE_DEFINED ) )?
        int alt109=2;
        int LA109_0 = input.LA(1);

        if ( (LA109_0==RULE_DEFINED) ) {
            alt109=1;
        }
        switch (alt109) {
            case 1 :
                // InternalPreprocess.g:3091:1: (lv_defined_3_0= RULE_DEFINED )
                {
                // InternalPreprocess.g:3091:1: (lv_defined_3_0= RULE_DEFINED )
                // InternalPreprocess.g:3092:3: lv_defined_3_0= RULE_DEFINED
                {
                lv_defined_3_0=(Token)match(input,RULE_DEFINED,FOLLOW_11); if (state.failed) return ;

                }


                }
                break;

        }

        this_SKW_LEFTPAREN_4=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_27); if (state.failed) return ;
        // InternalPreprocess.g:3118:1: ( (lv_id_5_0= RULE_ID ) )
        // InternalPreprocess.g:3119:1: (lv_id_5_0= RULE_ID )
        {
        // InternalPreprocess.g:3119:1: (lv_id_5_0= RULE_ID )
        // InternalPreprocess.g:3120:3: lv_id_5_0= RULE_ID
        {
        lv_id_5_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return ;

        }


        }

        this_SKW_RIGHTPAREN_6=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred98_InternalPreprocess

    // Delegated rules

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
    public final boolean synpred20_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalPreprocess_fragment(); // can never throw exception
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
    public final boolean synpred83_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred83_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_InternalPreprocess_fragment(); // can never throw exception
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
    public final boolean synpred84_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred84_InternalPreprocess_fragment(); // can never throw exception
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
    public final boolean synpred64_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_InternalPreprocess_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred98_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred98_InternalPreprocess_fragment(); // can never throw exception
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
    public final boolean synpred38_InternalPreprocess() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalPreprocess_fragment(); // can never throw exception
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


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA65 dfa65 = new DFA65(this);
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
            "\1\4\1\2\1\3\22\4\1\uffff\51\4",
            "",
            "\1\4\1\2\1\3\22\4\1\uffff\51\4",
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
        "\100\uffff";
    static final String DFA2_eofS =
        "\1\76\77\uffff";
    static final String DFA2_minS =
        "\1\4\75\0\2\uffff";
    static final String DFA2_maxS =
        "\1\102\75\0\2\uffff";
    static final String DFA2_acceptS =
        "\76\uffff\1\2\1\1";
    static final String DFA2_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\2\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\77\1\1\1\2\1\5\1\6\1\41\1\61\1\3\1\27\1\7\1\20\1\21\1\12\1\14\1\11\1\13\1\16\1\17\1\10\1\4\1\15\1\uffff\1\56\1\30\1\53\1\23\1\52\1\26\1\22\1\34\1\51\1\43\1\35\1\44\1\36\1\42\1\62\1\54\1\45\1\65\1\31\1\47\1\66\1\50\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\24\1\25\1\32\1\33\1\37\1\40\1\46\1\55\1\57\1\60\1\63\1\64",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA2_2 = input.LA(1);

                         
                        int index2_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA2_3 = input.LA(1);

                         
                        int index2_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA2_4 = input.LA(1);

                         
                        int index2_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA2_5 = input.LA(1);

                         
                        int index2_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA2_6 = input.LA(1);

                         
                        int index2_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA2_7 = input.LA(1);

                         
                        int index2_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA2_8 = input.LA(1);

                         
                        int index2_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA2_9 = input.LA(1);

                         
                        int index2_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA2_10 = input.LA(1);

                         
                        int index2_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA2_11 = input.LA(1);

                         
                        int index2_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA2_12 = input.LA(1);

                         
                        int index2_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA2_13 = input.LA(1);

                         
                        int index2_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA2_14 = input.LA(1);

                         
                        int index2_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA2_15 = input.LA(1);

                         
                        int index2_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA2_16 = input.LA(1);

                         
                        int index2_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA2_17 = input.LA(1);

                         
                        int index2_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA2_18 = input.LA(1);

                         
                        int index2_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA2_19 = input.LA(1);

                         
                        int index2_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA2_20 = input.LA(1);

                         
                        int index2_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA2_21 = input.LA(1);

                         
                        int index2_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA2_22 = input.LA(1);

                         
                        int index2_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA2_23 = input.LA(1);

                         
                        int index2_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA2_24 = input.LA(1);

                         
                        int index2_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA2_25 = input.LA(1);

                         
                        int index2_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA2_26 = input.LA(1);

                         
                        int index2_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA2_27 = input.LA(1);

                         
                        int index2_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA2_28 = input.LA(1);

                         
                        int index2_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA2_29 = input.LA(1);

                         
                        int index2_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_29);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA2_30 = input.LA(1);

                         
                        int index2_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_30);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA2_31 = input.LA(1);

                         
                        int index2_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_31);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA2_32 = input.LA(1);

                         
                        int index2_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_32);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA2_33 = input.LA(1);

                         
                        int index2_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_33);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA2_34 = input.LA(1);

                         
                        int index2_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_34);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA2_35 = input.LA(1);

                         
                        int index2_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_35);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA2_36 = input.LA(1);

                         
                        int index2_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_36);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA2_37 = input.LA(1);

                         
                        int index2_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_37);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA2_38 = input.LA(1);

                         
                        int index2_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_38);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA2_39 = input.LA(1);

                         
                        int index2_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_39);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA2_40 = input.LA(1);

                         
                        int index2_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_40);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA2_41 = input.LA(1);

                         
                        int index2_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_41);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA2_42 = input.LA(1);

                         
                        int index2_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_42);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA2_43 = input.LA(1);

                         
                        int index2_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_43);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA2_44 = input.LA(1);

                         
                        int index2_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_44);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA2_45 = input.LA(1);

                         
                        int index2_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_45);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA2_46 = input.LA(1);

                         
                        int index2_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_46);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA2_47 = input.LA(1);

                         
                        int index2_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_47);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA2_48 = input.LA(1);

                         
                        int index2_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_48);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA2_49 = input.LA(1);

                         
                        int index2_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_49);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA2_50 = input.LA(1);

                         
                        int index2_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_50);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA2_51 = input.LA(1);

                         
                        int index2_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_51);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA2_52 = input.LA(1);

                         
                        int index2_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_52);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA2_53 = input.LA(1);

                         
                        int index2_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_53);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA2_54 = input.LA(1);

                         
                        int index2_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_54);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA2_55 = input.LA(1);

                         
                        int index2_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_55);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA2_56 = input.LA(1);

                         
                        int index2_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_56);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA2_57 = input.LA(1);

                         
                        int index2_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_57);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA2_58 = input.LA(1);

                         
                        int index2_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_58);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA2_59 = input.LA(1);

                         
                        int index2_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_59);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA2_60 = input.LA(1);

                         
                        int index2_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_60);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA2_61 = input.LA(1);

                         
                        int index2_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index2_61);
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
            "\1\3\1\1\1\2\22\4\1\uffff\51\4",
            "\1\4\1\1\1\2\22\4\1\uffff\51\4",
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
            "\1\1\1\2\22\3\1\uffff\51\3",
            "\1\1\1\2\22\3\1\uffff\51\3",
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
        "\100\uffff";
    static final String DFA10_eofS =
        "\3\uffff\73\77\2\uffff";
    static final String DFA10_minS =
        "\1\10\2\5\73\4\2\uffff";
    static final String DFA10_maxS =
        "\1\10\1\5\1\102\73\11\2\uffff";
    static final String DFA10_acceptS =
        "\76\uffff\1\2\1\1";
    static final String DFA10_specialS =
        "\100\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1",
            "\1\2",
            "\1\2\1\uffff\1\5\1\6\1\41\1\61\1\3\1\27\1\7\1\20\1\21\1\12\1\14\1\11\1\13\1\16\1\17\1\10\1\4\1\15\1\uffff\1\56\1\30\1\53\1\23\1\52\1\26\1\22\1\34\1\51\1\43\1\35\1\44\1\36\1\42\1\62\1\54\1\45\1\65\1\31\1\47\1\66\1\50\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\24\1\25\1\32\1\33\1\37\1\40\1\46\1\55\1\57\1\60\1\63\1\64",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
            "\2\77\3\uffff\1\76",
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
            return "()* loopback of 1099:1: ( (this_WHITESPACE_2= RULE_WHITESPACE )* this_SKW_COMMA_3= RULE_SKW_COMMA (this_WHITESPACE_4= RULE_WHITESPACE )* ( (lv_id_5_0= RULE_ID ) ) )*";
        }
    }
    static final String DFA38_eotS =
        "\6\uffff";
    static final String DFA38_eofS =
        "\6\uffff";
    static final String DFA38_minS =
        "\4\5\2\uffff";
    static final String DFA38_maxS =
        "\2\6\2\25\2\uffff";
    static final String DFA38_acceptS =
        "\4\uffff\1\2\1\1";
    static final String DFA38_specialS =
        "\6\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\1\1\2",
            "\1\1\1\2",
            "\1\3\12\uffff\1\4\3\uffff\1\5\1\4",
            "\1\3\12\uffff\1\4\3\uffff\1\5\1\4",
            "",
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "()* loopback of 1736:1: ( (lv_elifs_2_0= ruleElIfConditional ) )*";
        }
    }
    static final String DFA39_eotS =
        "\6\uffff";
    static final String DFA39_eofS =
        "\6\uffff";
    static final String DFA39_minS =
        "\4\5\2\uffff";
    static final String DFA39_maxS =
        "\2\6\2\25\2\uffff";
    static final String DFA39_acceptS =
        "\4\uffff\1\2\1\1";
    static final String DFA39_specialS =
        "\6\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\1\1\2",
            "\1\1\1\2",
            "\1\3\12\uffff\1\4\4\uffff\1\5",
            "\1\3\12\uffff\1\4\4\uffff\1\5",
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
            return "1757:1: ( (lv_else_3_0= ruleElseConditional ) )?";
        }
    }
    static final String DFA59_eotS =
        "\102\uffff";
    static final String DFA59_eofS =
        "\1\1\101\uffff";
    static final String DFA59_minS =
        "\1\4\1\uffff\75\0\3\uffff";
    static final String DFA59_maxS =
        "\1\102\1\uffff\75\0\3\uffff";
    static final String DFA59_acceptS =
        "\1\uffff\1\4\75\uffff\1\1\1\2\1\3";
    static final String DFA59_specialS =
        "\2\uffff\1\34\1\61\1\7\1\54\1\62\1\33\1\40\1\60\1\51\1\2\1\72\1\30\1\17\1\47\1\23\1\37\1\6\1\55\1\46\1\16\1\27\1\65\1\3\1\45\1\73\1\31\1\50\1\1\1\35\1\56\1\26\1\71\1\41\1\10\1\74\1\24\1\14\1\44\1\32\1\11\1\20\1\66\1\5\1\57\1\63\1\21\1\53\1\4\1\36\1\64\1\22\1\0\1\70\1\43\1\13\1\12\1\42\1\67\1\15\1\52\1\25\3\uffff}>";
    static final String[] DFA59_transitionS = {
            "\1\1\1\75\1\1\1\4\1\5\1\40\1\60\1\2\1\26\1\6\1\17\1\20\1\11\1\13\1\10\1\12\1\15\1\16\1\7\1\3\1\14\1\76\1\55\1\27\1\52\1\22\1\51\1\25\1\21\1\33\1\50\1\42\1\34\1\43\1\35\1\41\1\61\1\53\1\44\1\64\1\30\1\46\1\65\1\47\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\23\1\24\1\31\1\32\1\36\1\37\1\45\1\54\1\56\1\57\1\62\1\63",
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
            "",
            ""
    };

    static final short[] DFA59_eot = DFA.unpackEncodedString(DFA59_eotS);
    static final short[] DFA59_eof = DFA.unpackEncodedString(DFA59_eofS);
    static final char[] DFA59_min = DFA.unpackEncodedStringToUnsignedChars(DFA59_minS);
    static final char[] DFA59_max = DFA.unpackEncodedStringToUnsignedChars(DFA59_maxS);
    static final short[] DFA59_accept = DFA.unpackEncodedString(DFA59_acceptS);
    static final short[] DFA59_special = DFA.unpackEncodedString(DFA59_specialS);
    static final short[][] DFA59_transition;

    static {
        int numStates = DFA59_transitionS.length;
        DFA59_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA59_transition[i] = DFA.unpackEncodedString(DFA59_transitionS[i]);
        }
    }

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = DFA59_eot;
            this.eof = DFA59_eof;
            this.min = DFA59_min;
            this.max = DFA59_max;
            this.accept = DFA59_accept;
            this.special = DFA59_special;
            this.transition = DFA59_transition;
        }
        public String getDescription() {
            return "()+ loopback of 2767:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE | this_VA_ARGS_2= RULE_VA_ARGS )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA59_53 = input.LA(1);

                         
                        int index59_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_53);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA59_29 = input.LA(1);

                         
                        int index59_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_29);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA59_11 = input.LA(1);

                         
                        int index59_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_11);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA59_24 = input.LA(1);

                         
                        int index59_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_24);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA59_49 = input.LA(1);

                         
                        int index59_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_49);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA59_44 = input.LA(1);

                         
                        int index59_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_44);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA59_18 = input.LA(1);

                         
                        int index59_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_18);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA59_4 = input.LA(1);

                         
                        int index59_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_4);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA59_35 = input.LA(1);

                         
                        int index59_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_35);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA59_41 = input.LA(1);

                         
                        int index59_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_41);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA59_57 = input.LA(1);

                         
                        int index59_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_57);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA59_56 = input.LA(1);

                         
                        int index59_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_56);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA59_38 = input.LA(1);

                         
                        int index59_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_38);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA59_60 = input.LA(1);

                         
                        int index59_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_60);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA59_21 = input.LA(1);

                         
                        int index59_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_21);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA59_14 = input.LA(1);

                         
                        int index59_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_14);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA59_42 = input.LA(1);

                         
                        int index59_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_42);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA59_47 = input.LA(1);

                         
                        int index59_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_47);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA59_52 = input.LA(1);

                         
                        int index59_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_52);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA59_16 = input.LA(1);

                         
                        int index59_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_16);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA59_37 = input.LA(1);

                         
                        int index59_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_37);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA59_62 = input.LA(1);

                         
                        int index59_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_InternalPreprocess()) ) {s = 65;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_62);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA59_32 = input.LA(1);

                         
                        int index59_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_32);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA59_22 = input.LA(1);

                         
                        int index59_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_22);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA59_13 = input.LA(1);

                         
                        int index59_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_13);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA59_27 = input.LA(1);

                         
                        int index59_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_27);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA59_40 = input.LA(1);

                         
                        int index59_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_40);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA59_7 = input.LA(1);

                         
                        int index59_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_7);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA59_2 = input.LA(1);

                         
                        int index59_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_2);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA59_30 = input.LA(1);

                         
                        int index59_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_30);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA59_50 = input.LA(1);

                         
                        int index59_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_50);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA59_17 = input.LA(1);

                         
                        int index59_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_17);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA59_8 = input.LA(1);

                         
                        int index59_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_8);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA59_34 = input.LA(1);

                         
                        int index59_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_34);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA59_58 = input.LA(1);

                         
                        int index59_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_58);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA59_55 = input.LA(1);

                         
                        int index59_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_55);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA59_39 = input.LA(1);

                         
                        int index59_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_39);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA59_25 = input.LA(1);

                         
                        int index59_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_25);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA59_20 = input.LA(1);

                         
                        int index59_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_20);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA59_15 = input.LA(1);

                         
                        int index59_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_15);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA59_28 = input.LA(1);

                         
                        int index59_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_28);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA59_10 = input.LA(1);

                         
                        int index59_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_10);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA59_61 = input.LA(1);

                         
                        int index59_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_InternalPreprocess()) ) {s = 64;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_61);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA59_48 = input.LA(1);

                         
                        int index59_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_48);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA59_5 = input.LA(1);

                         
                        int index59_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_5);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA59_19 = input.LA(1);

                         
                        int index59_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_19);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA59_31 = input.LA(1);

                         
                        int index59_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_31);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA59_45 = input.LA(1);

                         
                        int index59_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_45);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA59_9 = input.LA(1);

                         
                        int index59_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_9);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA59_3 = input.LA(1);

                         
                        int index59_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_3);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA59_6 = input.LA(1);

                         
                        int index59_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_6);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA59_46 = input.LA(1);

                         
                        int index59_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_46);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA59_51 = input.LA(1);

                         
                        int index59_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_51);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA59_23 = input.LA(1);

                         
                        int index59_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_23);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA59_43 = input.LA(1);

                         
                        int index59_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_43);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA59_59 = input.LA(1);

                         
                        int index59_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_59);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA59_54 = input.LA(1);

                         
                        int index59_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_54);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA59_33 = input.LA(1);

                         
                        int index59_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_33);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA59_12 = input.LA(1);

                         
                        int index59_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_12);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA59_26 = input.LA(1);

                         
                        int index59_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_26);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA59_36 = input.LA(1);

                         
                        int index59_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_36);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 59, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA61_eotS =
        "\100\uffff";
    static final String DFA61_eofS =
        "\1\1\77\uffff";
    static final String DFA61_minS =
        "\1\4\1\uffff\74\0\2\uffff";
    static final String DFA61_maxS =
        "\1\102\1\uffff\74\0\2\uffff";
    static final String DFA61_acceptS =
        "\1\uffff\1\3\74\uffff\1\1\1\2";
    static final String DFA61_specialS =
        "\2\uffff\1\15\1\40\1\65\1\23\1\63\1\36\1\4\1\51\1\21\1\60\1\55\1\6\1\66\1\17\1\10\1\67\1\0\1\54\1\62\1\35\1\53\1\1\1\30\1\61\1\13\1\44\1\70\1\25\1\50\1\3\1\32\1\71\1\7\1\46\1\56\1\33\1\73\1\24\1\12\1\41\1\31\1\72\1\45\1\14\1\57\1\26\1\2\1\20\1\52\1\5\1\34\1\47\1\37\1\43\1\11\1\22\1\64\1\16\1\27\1\42\2\uffff}>";
    static final String[] DFA61_transitionS = {
            "\1\1\1\75\1\1\1\4\1\5\1\40\1\60\1\2\1\26\1\6\1\17\1\20\1\11\1\13\1\10\1\12\1\15\1\16\1\7\1\3\1\14\1\uffff\1\55\1\27\1\52\1\22\1\51\1\25\1\21\1\33\1\50\1\42\1\34\1\43\1\35\1\41\1\61\1\53\1\44\1\64\1\30\1\46\1\65\1\47\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\23\1\24\1\31\1\32\1\36\1\37\1\45\1\54\1\56\1\57\1\62\1\63",
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
            return "()+ loopback of 2855:1: (this_MyCode_0= ruleMyCode | this_WHITESPACE_1= RULE_WHITESPACE )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_18 = input.LA(1);

                         
                        int index61_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_18);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA61_23 = input.LA(1);

                         
                        int index61_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_23);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA61_48 = input.LA(1);

                         
                        int index61_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_48);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA61_31 = input.LA(1);

                         
                        int index61_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_31);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA61_8 = input.LA(1);

                         
                        int index61_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA61_51 = input.LA(1);

                         
                        int index61_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_51);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA61_13 = input.LA(1);

                         
                        int index61_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_13);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA61_34 = input.LA(1);

                         
                        int index61_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_34);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA61_16 = input.LA(1);

                         
                        int index61_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_16);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA61_56 = input.LA(1);

                         
                        int index61_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_56);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA61_40 = input.LA(1);

                         
                        int index61_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_40);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA61_26 = input.LA(1);

                         
                        int index61_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_26);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA61_45 = input.LA(1);

                         
                        int index61_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_45);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA61_2 = input.LA(1);

                         
                        int index61_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_2);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA61_59 = input.LA(1);

                         
                        int index61_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_59);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA61_15 = input.LA(1);

                         
                        int index61_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_15);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA61_49 = input.LA(1);

                         
                        int index61_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_49);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA61_10 = input.LA(1);

                         
                        int index61_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_10);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA61_57 = input.LA(1);

                         
                        int index61_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_57);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA61_5 = input.LA(1);

                         
                        int index61_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_5);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA61_39 = input.LA(1);

                         
                        int index61_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_39);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA61_29 = input.LA(1);

                         
                        int index61_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_29);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA61_47 = input.LA(1);

                         
                        int index61_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_47);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA61_60 = input.LA(1);

                         
                        int index61_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_60);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA61_24 = input.LA(1);

                         
                        int index61_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_24);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA61_42 = input.LA(1);

                         
                        int index61_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_42);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA61_32 = input.LA(1);

                         
                        int index61_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_32);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA61_37 = input.LA(1);

                         
                        int index61_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_37);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA61_52 = input.LA(1);

                         
                        int index61_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_52);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA61_21 = input.LA(1);

                         
                        int index61_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_21);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA61_7 = input.LA(1);

                         
                        int index61_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_7);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA61_54 = input.LA(1);

                         
                        int index61_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_54);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA61_3 = input.LA(1);

                         
                        int index61_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_3);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA61_41 = input.LA(1);

                         
                        int index61_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_41);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA61_61 = input.LA(1);

                         
                        int index61_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalPreprocess()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_61);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA61_55 = input.LA(1);

                         
                        int index61_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_55);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA61_27 = input.LA(1);

                         
                        int index61_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_27);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA61_44 = input.LA(1);

                         
                        int index61_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_44);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA61_35 = input.LA(1);

                         
                        int index61_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_35);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA61_53 = input.LA(1);

                         
                        int index61_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_53);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA61_30 = input.LA(1);

                         
                        int index61_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_30);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA61_9 = input.LA(1);

                         
                        int index61_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_9);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA61_50 = input.LA(1);

                         
                        int index61_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_50);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA61_22 = input.LA(1);

                         
                        int index61_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_22);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA61_19 = input.LA(1);

                         
                        int index61_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_19);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA61_12 = input.LA(1);

                         
                        int index61_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_12);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA61_36 = input.LA(1);

                         
                        int index61_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_36);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA61_46 = input.LA(1);

                         
                        int index61_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_46);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA61_11 = input.LA(1);

                         
                        int index61_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_11);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA61_25 = input.LA(1);

                         
                        int index61_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_25);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA61_20 = input.LA(1);

                         
                        int index61_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_20);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA61_6 = input.LA(1);

                         
                        int index61_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_6);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA61_58 = input.LA(1);

                         
                        int index61_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_58);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA61_4 = input.LA(1);

                         
                        int index61_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_4);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA61_14 = input.LA(1);

                         
                        int index61_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_14);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA61_17 = input.LA(1);

                         
                        int index61_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_17);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA61_28 = input.LA(1);

                         
                        int index61_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_28);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA61_33 = input.LA(1);

                         
                        int index61_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_33);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA61_43 = input.LA(1);

                         
                        int index61_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_43);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA61_38 = input.LA(1);

                         
                        int index61_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalPreprocess()) ) {s = 62;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_38);
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
        "\4\uffff";
    static final String DFA62_eofS =
        "\1\uffff\1\3\2\uffff";
    static final String DFA62_minS =
        "\1\5\1\4\2\uffff";
    static final String DFA62_maxS =
        "\2\102\2\uffff";
    static final String DFA62_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA62_specialS =
        "\4\uffff}>";
    static final String[] DFA62_transitionS = {
            "\1\1\1\uffff\22\2\1\uffff\51\2",
            "\1\3\1\1\1\uffff\22\2\1\uffff\51\2",
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
            return "2895:1: (this_MyCodeLineExtendedWSOnly_0= ruleMyCodeLineExtendedWSOnly | this_MyCodeLineExtendedNormal_1= ruleMyCodeLineExtendedNormal )";
        }
    }
    static final String DFA65_eotS =
        "\76\uffff";
    static final String DFA65_eofS =
        "\1\74\75\uffff";
    static final String DFA65_minS =
        "\1\4\73\0\2\uffff";
    static final String DFA65_maxS =
        "\1\102\73\0\2\uffff";
    static final String DFA65_acceptS =
        "\74\uffff\1\2\1\1";
    static final String DFA65_specialS =
        "\1\uffff\1\7\1\37\1\63\1\3\1\52\1\57\1\34\1\35\1\60\1\53\1\4\1\62\1\36\1\6\1\50\1\32\1\5\1\55\1\44\1\17\1\25\1\70\1\0\1\45\1\72\1\24\1\47\1\1\1\30\1\54\1\26\1\64\1\43\1\15\1\71\1\27\1\20\1\40\1\31\1\14\1\23\1\67\1\10\1\51\1\61\1\22\1\46\1\11\1\33\1\56\1\21\1\2\1\66\1\42\1\13\1\12\1\41\1\65\1\16\2\uffff}>";
    static final String[] DFA65_transitionS = {
            "\3\74\1\3\1\4\1\37\1\57\1\1\1\25\1\5\1\16\1\17\1\10\1\12\1\7\1\11\1\14\1\15\1\6\1\2\1\13\1\uffff\1\54\1\26\1\51\1\21\1\50\1\24\1\20\1\32\1\47\1\41\1\33\1\42\1\34\1\40\1\60\1\52\1\43\1\63\1\27\1\45\1\64\1\46\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\22\1\23\1\30\1\31\1\35\1\36\1\44\1\53\1\55\1\56\1\61\1\62",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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

    static final short[] DFA65_eot = DFA.unpackEncodedString(DFA65_eotS);
    static final short[] DFA65_eof = DFA.unpackEncodedString(DFA65_eofS);
    static final char[] DFA65_min = DFA.unpackEncodedStringToUnsignedChars(DFA65_minS);
    static final char[] DFA65_max = DFA.unpackEncodedStringToUnsignedChars(DFA65_maxS);
    static final short[] DFA65_accept = DFA.unpackEncodedString(DFA65_acceptS);
    static final short[] DFA65_special = DFA.unpackEncodedString(DFA65_specialS);
    static final short[][] DFA65_transition;

    static {
        int numStates = DFA65_transitionS.length;
        DFA65_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA65_transition[i] = DFA.unpackEncodedString(DFA65_transitionS[i]);
        }
    }

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = DFA65_eot;
            this.eof = DFA65_eof;
            this.min = DFA65_min;
            this.max = DFA65_max;
            this.accept = DFA65_accept;
            this.special = DFA65_special;
            this.transition = DFA65_transition;
        }
        public String getDescription() {
            return "()+ loopback of 2974:3: (this_MyCode_1= ruleMyCode )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA65_23 = input.LA(1);

                         
                        int index65_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_23);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA65_28 = input.LA(1);

                         
                        int index65_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_28);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA65_52 = input.LA(1);

                         
                        int index65_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_52);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA65_4 = input.LA(1);

                         
                        int index65_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA65_11 = input.LA(1);

                         
                        int index65_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_11);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA65_17 = input.LA(1);

                         
                        int index65_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_17);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA65_14 = input.LA(1);

                         
                        int index65_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_14);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA65_1 = input.LA(1);

                         
                        int index65_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_1);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA65_43 = input.LA(1);

                         
                        int index65_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_43);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA65_48 = input.LA(1);

                         
                        int index65_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_48);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA65_56 = input.LA(1);

                         
                        int index65_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_56);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA65_55 = input.LA(1);

                         
                        int index65_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_55);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA65_40 = input.LA(1);

                         
                        int index65_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_40);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA65_34 = input.LA(1);

                         
                        int index65_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_34);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA65_59 = input.LA(1);

                         
                        int index65_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_59);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA65_20 = input.LA(1);

                         
                        int index65_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_20);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA65_37 = input.LA(1);

                         
                        int index65_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_37);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA65_51 = input.LA(1);

                         
                        int index65_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_51);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA65_46 = input.LA(1);

                         
                        int index65_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_46);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA65_41 = input.LA(1);

                         
                        int index65_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_41);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA65_26 = input.LA(1);

                         
                        int index65_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_26);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA65_21 = input.LA(1);

                         
                        int index65_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_21);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA65_31 = input.LA(1);

                         
                        int index65_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_31);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA65_36 = input.LA(1);

                         
                        int index65_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_36);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA65_29 = input.LA(1);

                         
                        int index65_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_29);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA65_39 = input.LA(1);

                         
                        int index65_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_39);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA65_16 = input.LA(1);

                         
                        int index65_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_16);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA65_49 = input.LA(1);

                         
                        int index65_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_49);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA65_7 = input.LA(1);

                         
                        int index65_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_7);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA65_8 = input.LA(1);

                         
                        int index65_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_8);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA65_13 = input.LA(1);

                         
                        int index65_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_13);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA65_2 = input.LA(1);

                         
                        int index65_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_2);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA65_38 = input.LA(1);

                         
                        int index65_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_38);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA65_57 = input.LA(1);

                         
                        int index65_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_57);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA65_54 = input.LA(1);

                         
                        int index65_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_54);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA65_33 = input.LA(1);

                         
                        int index65_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_33);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA65_19 = input.LA(1);

                         
                        int index65_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_19);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA65_24 = input.LA(1);

                         
                        int index65_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_24);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA65_47 = input.LA(1);

                         
                        int index65_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_47);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA65_27 = input.LA(1);

                         
                        int index65_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_27);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA65_15 = input.LA(1);

                         
                        int index65_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_15);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA65_44 = input.LA(1);

                         
                        int index65_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_44);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA65_5 = input.LA(1);

                         
                        int index65_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_5);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA65_10 = input.LA(1);

                         
                        int index65_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_10);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA65_30 = input.LA(1);

                         
                        int index65_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_30);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA65_18 = input.LA(1);

                         
                        int index65_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_18);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA65_50 = input.LA(1);

                         
                        int index65_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_50);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA65_6 = input.LA(1);

                         
                        int index65_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_6);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA65_9 = input.LA(1);

                         
                        int index65_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_9);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA65_45 = input.LA(1);

                         
                        int index65_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_45);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA65_12 = input.LA(1);

                         
                        int index65_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_12);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA65_3 = input.LA(1);

                         
                        int index65_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_3);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA65_32 = input.LA(1);

                         
                        int index65_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_32);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA65_58 = input.LA(1);

                         
                        int index65_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_58);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA65_53 = input.LA(1);

                         
                        int index65_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_53);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA65_42 = input.LA(1);

                         
                        int index65_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_42);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA65_22 = input.LA(1);

                         
                        int index65_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_22);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA65_35 = input.LA(1);

                         
                        int index65_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_35);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA65_25 = input.LA(1);

                         
                        int index65_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalPreprocess()) ) {s = 61;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index65_25);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 65, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0xFFFFFFFFFDFFFFE2L,0x0000000000000007L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0xFFFFFFFFFDFFFFF2L,0x0000000000000007L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000004EE1A0L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0xFFFFFFFFFDFFFFE0L,0x0000000000000007L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0200000000000C20L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0xFFFFFFFFFFFFFFE2L,0x0000000000000007L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000001022L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0200000000000820L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0200000000000800L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000860L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0xFFFFFFFFFDFFFFF0L,0x0000000000000007L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000200020L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000007800000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000018000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000380000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0200000000000000L});

}