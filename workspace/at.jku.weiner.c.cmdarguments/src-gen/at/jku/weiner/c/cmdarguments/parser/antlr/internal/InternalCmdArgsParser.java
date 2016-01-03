package at.jku.weiner.c.cmdarguments.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import at.jku.weiner.c.cmdarguments.services.CmdArgsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalCmdArgsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NEWLINE", "RULE_DEFINE", "RULE_INCLUDE", "RULE_INCSYS", "RULE_NOSTDINC", "RULE_SKW_ASSIGN", "RULE_SKW_LEFTPAREN", "RULE_SKW_COMMA", "RULE_SKW_RIGHTPAREN", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_HASH", "RULE_SKW_MINUS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_SKW_MINUS=17;
    public static final int RULE_ID=13;
    public static final int RULE_NEWLINE=4;
    public static final int RULE_ANY_OTHER=21;
    public static final int RULE_INCSYS=7;
    public static final int RULE_HASH=16;
    public static final int RULE_SL_COMMENT=19;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=18;
    public static final int RULE_SKW_RIGHTPAREN=12;
    public static final int RULE_STRING=15;
    public static final int RULE_DEFINE=5;
    public static final int RULE_NOSTDINC=8;
    public static final int RULE_INCLUDE=6;
    public static final int RULE_INT=14;
    public static final int RULE_SKW_COMMA=11;
    public static final int RULE_WS=20;
    public static final int RULE_SKW_ASSIGN=9;
    public static final int RULE_SKW_LEFTPAREN=10;

    // delegates
    // delegators


        public InternalCmdArgsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCmdArgsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCmdArgsParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCmdArgs.g"; }



     	private CmdArgsGrammarAccess grammarAccess;
     	
        public InternalCmdArgsParser(TokenStream input, CmdArgsGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected CmdArgsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalCmdArgs.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalCmdArgs.g:69:2: (iv_ruleModel= ruleModel EOF )
            // InternalCmdArgs.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalCmdArgs.g:77:1: ruleModel returns [EObject current=null] : ( () ( ( (lv_line_1_0= ruleCmdLine ) ) (this_NEWLINE_2= RULE_NEWLINE )? )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_2=null;
        EObject lv_line_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:83:7: ( ( () ( ( (lv_line_1_0= ruleCmdLine ) ) (this_NEWLINE_2= RULE_NEWLINE )? )* ) )
            // InternalCmdArgs.g:85:1: ( () ( ( (lv_line_1_0= ruleCmdLine ) ) (this_NEWLINE_2= RULE_NEWLINE )? )* )
            {
            // InternalCmdArgs.g:85:1: ( () ( ( (lv_line_1_0= ruleCmdLine ) ) (this_NEWLINE_2= RULE_NEWLINE )? )* )
            // InternalCmdArgs.g:86:1: () ( ( (lv_line_1_0= ruleCmdLine ) ) (this_NEWLINE_2= RULE_NEWLINE )? )*
            {
            // InternalCmdArgs.g:86:1: ()
            // InternalCmdArgs.g:87:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

            // InternalCmdArgs.g:95:1: ( ( (lv_line_1_0= ruleCmdLine ) ) (this_NEWLINE_2= RULE_NEWLINE )? )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_DEFINE && LA2_0<=RULE_NOSTDINC)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCmdArgs.g:96:1: ( (lv_line_1_0= ruleCmdLine ) ) (this_NEWLINE_2= RULE_NEWLINE )?
            	    {
            	    // InternalCmdArgs.g:96:1: ( (lv_line_1_0= ruleCmdLine ) )
            	    // InternalCmdArgs.g:97:1: (lv_line_1_0= ruleCmdLine )
            	    {
            	    // InternalCmdArgs.g:97:1: (lv_line_1_0= ruleCmdLine )
            	    // InternalCmdArgs.g:98:3: lv_line_1_0= ruleCmdLine
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getLineCmdLineParserRuleCall_1_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_line_1_0=ruleCmdLine();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"line",
            	            		lv_line_1_0, 
            	            		"at.jku.weiner.c.cmdarguments.CmdArgs.CmdLine");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // InternalCmdArgs.g:117:1: (this_NEWLINE_2= RULE_NEWLINE )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==RULE_NEWLINE) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // InternalCmdArgs.g:117:2: this_NEWLINE_2= RULE_NEWLINE
            	            {
            	            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_3); 
            	             
            	                newLeafNode(this_NEWLINE_2, grammarAccess.getModelAccess().getNEWLINETerminalRuleCall_1_1()); 
            	                

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleCmdLine"
    // InternalCmdArgs.g:135:1: entryRuleCmdLine returns [EObject current=null] : iv_ruleCmdLine= ruleCmdLine EOF ;
    public final EObject entryRuleCmdLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCmdLine = null;


        try {
            // InternalCmdArgs.g:136:2: (iv_ruleCmdLine= ruleCmdLine EOF )
            // InternalCmdArgs.g:137:2: iv_ruleCmdLine= ruleCmdLine EOF
            {
             newCompositeNode(grammarAccess.getCmdLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCmdLine=ruleCmdLine();

            state._fsp--;

             current =iv_ruleCmdLine; 
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
    // $ANTLR end "entryRuleCmdLine"


    // $ANTLR start "ruleCmdLine"
    // InternalCmdArgs.g:144:1: ruleCmdLine returns [EObject current=null] : ( () ( (lv_arguments_1_0= ruleArgument ) )+ ) ;
    public final EObject ruleCmdLine() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:150:7: ( ( () ( (lv_arguments_1_0= ruleArgument ) )+ ) )
            // InternalCmdArgs.g:152:1: ( () ( (lv_arguments_1_0= ruleArgument ) )+ )
            {
            // InternalCmdArgs.g:152:1: ( () ( (lv_arguments_1_0= ruleArgument ) )+ )
            // InternalCmdArgs.g:153:1: () ( (lv_arguments_1_0= ruleArgument ) )+
            {
            // InternalCmdArgs.g:153:1: ()
            // InternalCmdArgs.g:154:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCmdLineAccess().getCmdLineAction_0(),
                        current);
                

            }

            // InternalCmdArgs.g:162:1: ( (lv_arguments_1_0= ruleArgument ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                switch ( input.LA(1) ) {
                case RULE_DEFINE:
                    {
                    alt3=1;
                    }
                    break;
                case RULE_INCLUDE:
                    {
                    alt3=1;
                    }
                    break;
                case RULE_INCSYS:
                    {
                    alt3=1;
                    }
                    break;
                case RULE_NOSTDINC:
                    {
                    alt3=1;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // InternalCmdArgs.g:163:1: (lv_arguments_1_0= ruleArgument )
            	    {
            	    // InternalCmdArgs.g:163:1: (lv_arguments_1_0= ruleArgument )
            	    // InternalCmdArgs.g:164:3: lv_arguments_1_0= ruleArgument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCmdLineAccess().getArgumentsArgumentParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_arguments_1_0=ruleArgument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCmdLineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"arguments",
            	            		lv_arguments_1_0, 
            	            		"at.jku.weiner.c.cmdarguments.CmdArgs.Argument");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
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
    // $ANTLR end "ruleCmdLine"


    // $ANTLR start "entryRuleArgument"
    // InternalCmdArgs.g:192:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // InternalCmdArgs.g:193:2: (iv_ruleArgument= ruleArgument EOF )
            // InternalCmdArgs.g:194:2: iv_ruleArgument= ruleArgument EOF
            {
             newCompositeNode(grammarAccess.getArgumentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArgument=ruleArgument();

            state._fsp--;

             current =iv_ruleArgument; 
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
    // $ANTLR end "entryRuleArgument"


    // $ANTLR start "ruleArgument"
    // InternalCmdArgs.g:201:1: ruleArgument returns [EObject current=null] : ( () ( (this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | (this_INCLUDE_3= RULE_INCLUDE ( (lv_include_4_0= ruleIncludeCmd ) ) ) | (this_INCSYS_5= RULE_INCSYS ( (lv_include_6_0= ruleIncludeCmd ) ) ) | ( (lv_nostdinc_7_0= RULE_NOSTDINC ) ) ) ) ;
    public final EObject ruleArgument() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_1=null;
        Token this_INCLUDE_3=null;
        Token this_INCSYS_5=null;
        Token lv_nostdinc_7_0=null;
        EObject lv_macro_2_0 = null;

        EObject lv_include_4_0 = null;

        EObject lv_include_6_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:207:7: ( ( () ( (this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | (this_INCLUDE_3= RULE_INCLUDE ( (lv_include_4_0= ruleIncludeCmd ) ) ) | (this_INCSYS_5= RULE_INCSYS ( (lv_include_6_0= ruleIncludeCmd ) ) ) | ( (lv_nostdinc_7_0= RULE_NOSTDINC ) ) ) ) )
            // InternalCmdArgs.g:209:1: ( () ( (this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | (this_INCLUDE_3= RULE_INCLUDE ( (lv_include_4_0= ruleIncludeCmd ) ) ) | (this_INCSYS_5= RULE_INCSYS ( (lv_include_6_0= ruleIncludeCmd ) ) ) | ( (lv_nostdinc_7_0= RULE_NOSTDINC ) ) ) )
            {
            // InternalCmdArgs.g:209:1: ( () ( (this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | (this_INCLUDE_3= RULE_INCLUDE ( (lv_include_4_0= ruleIncludeCmd ) ) ) | (this_INCSYS_5= RULE_INCSYS ( (lv_include_6_0= ruleIncludeCmd ) ) ) | ( (lv_nostdinc_7_0= RULE_NOSTDINC ) ) ) )
            // InternalCmdArgs.g:210:1: () ( (this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | (this_INCLUDE_3= RULE_INCLUDE ( (lv_include_4_0= ruleIncludeCmd ) ) ) | (this_INCSYS_5= RULE_INCSYS ( (lv_include_6_0= ruleIncludeCmd ) ) ) | ( (lv_nostdinc_7_0= RULE_NOSTDINC ) ) )
            {
            // InternalCmdArgs.g:210:1: ()
            // InternalCmdArgs.g:211:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArgumentAccess().getArgumentAction_0(),
                        current);
                

            }

            // InternalCmdArgs.g:219:1: ( (this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | (this_INCLUDE_3= RULE_INCLUDE ( (lv_include_4_0= ruleIncludeCmd ) ) ) | (this_INCSYS_5= RULE_INCSYS ( (lv_include_6_0= ruleIncludeCmd ) ) ) | ( (lv_nostdinc_7_0= RULE_NOSTDINC ) ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case RULE_DEFINE:
                {
                alt4=1;
                }
                break;
            case RULE_INCLUDE:
                {
                alt4=2;
                }
                break;
            case RULE_INCSYS:
                {
                alt4=3;
                }
                break;
            case RULE_NOSTDINC:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalCmdArgs.g:220:1: (this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) ) )
                    {
                    // InternalCmdArgs.g:220:1: (this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) ) )
                    // InternalCmdArgs.g:221:1: this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) )
                    {
                    this_DEFINE_1=(Token)match(input,RULE_DEFINE,FOLLOW_4); 
                     
                        newLeafNode(this_DEFINE_1, grammarAccess.getArgumentAccess().getDEFINETerminalRuleCall_1_0_0()); 
                        
                    // InternalCmdArgs.g:228:1: ( (lv_macro_2_0= ruleMacro ) )
                    // InternalCmdArgs.g:229:1: (lv_macro_2_0= ruleMacro )
                    {
                    // InternalCmdArgs.g:229:1: (lv_macro_2_0= ruleMacro )
                    // InternalCmdArgs.g:230:3: lv_macro_2_0= ruleMacro
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getMacroMacroParserRuleCall_1_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_macro_2_0=ruleMacro();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"macro",
                            		lv_macro_2_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.Macro");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCmdArgs.g:252:1: (this_INCLUDE_3= RULE_INCLUDE ( (lv_include_4_0= ruleIncludeCmd ) ) )
                    {
                    // InternalCmdArgs.g:252:1: (this_INCLUDE_3= RULE_INCLUDE ( (lv_include_4_0= ruleIncludeCmd ) ) )
                    // InternalCmdArgs.g:253:1: this_INCLUDE_3= RULE_INCLUDE ( (lv_include_4_0= ruleIncludeCmd ) )
                    {
                    this_INCLUDE_3=(Token)match(input,RULE_INCLUDE,FOLLOW_4); 
                     
                        newLeafNode(this_INCLUDE_3, grammarAccess.getArgumentAccess().getINCLUDETerminalRuleCall_1_1_0()); 
                        
                    // InternalCmdArgs.g:260:1: ( (lv_include_4_0= ruleIncludeCmd ) )
                    // InternalCmdArgs.g:261:1: (lv_include_4_0= ruleIncludeCmd )
                    {
                    // InternalCmdArgs.g:261:1: (lv_include_4_0= ruleIncludeCmd )
                    // InternalCmdArgs.g:262:3: lv_include_4_0= ruleIncludeCmd
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getIncludeIncludeCmdParserRuleCall_1_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_include_4_0=ruleIncludeCmd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"include",
                            		lv_include_4_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.IncludeCmd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCmdArgs.g:284:1: (this_INCSYS_5= RULE_INCSYS ( (lv_include_6_0= ruleIncludeCmd ) ) )
                    {
                    // InternalCmdArgs.g:284:1: (this_INCSYS_5= RULE_INCSYS ( (lv_include_6_0= ruleIncludeCmd ) ) )
                    // InternalCmdArgs.g:285:1: this_INCSYS_5= RULE_INCSYS ( (lv_include_6_0= ruleIncludeCmd ) )
                    {
                    this_INCSYS_5=(Token)match(input,RULE_INCSYS,FOLLOW_4); 
                     
                        newLeafNode(this_INCSYS_5, grammarAccess.getArgumentAccess().getINCSYSTerminalRuleCall_1_2_0()); 
                        
                    // InternalCmdArgs.g:292:1: ( (lv_include_6_0= ruleIncludeCmd ) )
                    // InternalCmdArgs.g:293:1: (lv_include_6_0= ruleIncludeCmd )
                    {
                    // InternalCmdArgs.g:293:1: (lv_include_6_0= ruleIncludeCmd )
                    // InternalCmdArgs.g:294:3: lv_include_6_0= ruleIncludeCmd
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getIncludeIncludeCmdParserRuleCall_1_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_include_6_0=ruleIncludeCmd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"include",
                            		lv_include_6_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.IncludeCmd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalCmdArgs.g:316:1: ( (lv_nostdinc_7_0= RULE_NOSTDINC ) )
                    {
                    // InternalCmdArgs.g:316:1: ( (lv_nostdinc_7_0= RULE_NOSTDINC ) )
                    // InternalCmdArgs.g:317:1: (lv_nostdinc_7_0= RULE_NOSTDINC )
                    {
                    // InternalCmdArgs.g:317:1: (lv_nostdinc_7_0= RULE_NOSTDINC )
                    // InternalCmdArgs.g:318:3: lv_nostdinc_7_0= RULE_NOSTDINC
                    {
                    lv_nostdinc_7_0=(Token)match(input,RULE_NOSTDINC,FOLLOW_2); 

                    			newLeafNode(lv_nostdinc_7_0, grammarAccess.getArgumentAccess().getNostdincNOSTDINCTerminalRuleCall_1_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getArgumentRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"nostdinc",
                            		true, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.NOSTDINC");
                    	    

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleArgument"


    // $ANTLR start "entryRuleMacro"
    // InternalCmdArgs.g:348:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // InternalCmdArgs.g:349:2: (iv_ruleMacro= ruleMacro EOF )
            // InternalCmdArgs.g:350:2: iv_ruleMacro= ruleMacro EOF
            {
             newCompositeNode(grammarAccess.getMacroRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMacro=ruleMacro();

            state._fsp--;

             current =iv_ruleMacro; 
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
    // $ANTLR end "entryRuleMacro"


    // $ANTLR start "ruleMacro"
    // InternalCmdArgs.g:357:1: ruleMacro returns [EObject current=null] : (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro ) ;
    public final EObject ruleMacro() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleMacro_0 = null;

        EObject this_ObjectMacro_1 = null;

        EObject this_FunctionMacro_2 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:363:7: ( (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro ) )
            // InternalCmdArgs.g:365:1: (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro )
            {
            // InternalCmdArgs.g:365:1: (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case RULE_SKW_ASSIGN:
                    {
                    alt5=2;
                    }
                    break;
                case RULE_SKW_LEFTPAREN:
                    {
                    alt5=3;
                    }
                    break;
                case EOF:
                case RULE_NEWLINE:
                case RULE_DEFINE:
                case RULE_INCLUDE:
                case RULE_INCSYS:
                case RULE_NOSTDINC:
                    {
                    alt5=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalCmdArgs.g:367:5: this_SimpleMacro_0= ruleSimpleMacro
                    {
                     
                            newCompositeNode(grammarAccess.getMacroAccess().getSimpleMacroParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_SimpleMacro_0=ruleSimpleMacro();

                    state._fsp--;

                     
                            current = this_SimpleMacro_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalCmdArgs.g:380:5: this_ObjectMacro_1= ruleObjectMacro
                    {
                     
                            newCompositeNode(grammarAccess.getMacroAccess().getObjectMacroParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ObjectMacro_1=ruleObjectMacro();

                    state._fsp--;

                     
                            current = this_ObjectMacro_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalCmdArgs.g:393:5: this_FunctionMacro_2= ruleFunctionMacro
                    {
                     
                            newCompositeNode(grammarAccess.getMacroAccess().getFunctionMacroParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_FunctionMacro_2=ruleFunctionMacro();

                    state._fsp--;

                     
                            current = this_FunctionMacro_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

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
    // $ANTLR end "ruleMacro"


    // $ANTLR start "entryRuleSimpleMacro"
    // InternalCmdArgs.g:413:1: entryRuleSimpleMacro returns [EObject current=null] : iv_ruleSimpleMacro= ruleSimpleMacro EOF ;
    public final EObject entryRuleSimpleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleMacro = null;


        try {
            // InternalCmdArgs.g:414:2: (iv_ruleSimpleMacro= ruleSimpleMacro EOF )
            // InternalCmdArgs.g:415:2: iv_ruleSimpleMacro= ruleSimpleMacro EOF
            {
             newCompositeNode(grammarAccess.getSimpleMacroRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleMacro=ruleSimpleMacro();

            state._fsp--;

             current =iv_ruleSimpleMacro; 
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
    // $ANTLR end "entryRuleSimpleMacro"


    // $ANTLR start "ruleSimpleMacro"
    // InternalCmdArgs.g:422:1: ruleSimpleMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleSimpleMacro() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:428:7: ( ( () ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // InternalCmdArgs.g:430:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // InternalCmdArgs.g:430:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) )
            // InternalCmdArgs.g:431:1: () ( (lv_name_1_0= ruleIdentifier ) )
            {
            // InternalCmdArgs.g:431:1: ()
            // InternalCmdArgs.g:432:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSimpleMacroAccess().getSimpleMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgs.g:440:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalCmdArgs.g:441:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalCmdArgs.g:441:1: (lv_name_1_0= ruleIdentifier )
            // InternalCmdArgs.g:442:3: lv_name_1_0= ruleIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getSimpleMacroAccess().getNameIdentifierParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSimpleMacroRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
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
    // $ANTLR end "ruleSimpleMacro"


    // $ANTLR start "entryRuleObjectMacro"
    // InternalCmdArgs.g:470:1: entryRuleObjectMacro returns [EObject current=null] : iv_ruleObjectMacro= ruleObjectMacro EOF ;
    public final EObject entryRuleObjectMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectMacro = null;


        try {
            // InternalCmdArgs.g:471:2: (iv_ruleObjectMacro= ruleObjectMacro EOF )
            // InternalCmdArgs.g:472:2: iv_ruleObjectMacro= ruleObjectMacro EOF
            {
             newCompositeNode(grammarAccess.getObjectMacroRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObjectMacro=ruleObjectMacro();

            state._fsp--;

             current =iv_ruleObjectMacro; 
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
    // $ANTLR end "entryRuleObjectMacro"


    // $ANTLR start "ruleObjectMacro"
    // InternalCmdArgs.g:479:1: ruleObjectMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) ) ;
    public final EObject ruleObjectMacro() throws RecognitionException {
        EObject current = null;

        Token this_SKW_ASSIGN_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:485:7: ( ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) ) )
            // InternalCmdArgs.g:487:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) )
            {
            // InternalCmdArgs.g:487:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) )
            // InternalCmdArgs.g:488:1: () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) )
            {
            // InternalCmdArgs.g:488:1: ()
            // InternalCmdArgs.g:489:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getObjectMacroAccess().getObjectMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgs.g:497:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalCmdArgs.g:498:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalCmdArgs.g:498:1: (lv_name_1_0= ruleIdentifier )
            // InternalCmdArgs.g:499:3: lv_name_1_0= ruleIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getObjectMacroAccess().getNameIdentifierParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getObjectMacroRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_SKW_ASSIGN_2=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_6); 
             
                newLeafNode(this_SKW_ASSIGN_2, grammarAccess.getObjectMacroAccess().getSKW_ASSIGNTerminalRuleCall_2()); 
                
            // InternalCmdArgs.g:525:1: ( (lv_value_3_0= ruleMyCode ) )
            // InternalCmdArgs.g:526:1: (lv_value_3_0= ruleMyCode )
            {
            // InternalCmdArgs.g:526:1: (lv_value_3_0= ruleMyCode )
            // InternalCmdArgs.g:527:3: lv_value_3_0= ruleMyCode
            {
             
            	        newCompositeNode(grammarAccess.getObjectMacroAccess().getValueMyCodeParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleMyCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getObjectMacroRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.MyCode");
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
    // $ANTLR end "ruleObjectMacro"


    // $ANTLR start "entryRuleFunctionMacro"
    // InternalCmdArgs.g:555:1: entryRuleFunctionMacro returns [EObject current=null] : iv_ruleFunctionMacro= ruleFunctionMacro EOF ;
    public final EObject entryRuleFunctionMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionMacro = null;


        try {
            // InternalCmdArgs.g:556:2: (iv_ruleFunctionMacro= ruleFunctionMacro EOF )
            // InternalCmdArgs.g:557:2: iv_ruleFunctionMacro= ruleFunctionMacro EOF
            {
             newCompositeNode(grammarAccess.getFunctionMacroRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionMacro=ruleFunctionMacro();

            state._fsp--;

             current =iv_ruleFunctionMacro; 
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
    // $ANTLR end "entryRuleFunctionMacro"


    // $ANTLR start "ruleFunctionMacro"
    // InternalCmdArgs.g:564:1: ruleFunctionMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) ) ;
    public final EObject ruleFunctionMacro() throws RecognitionException {
        EObject current = null;

        Token this_SKW_LEFTPAREN_2=null;
        Token this_SKW_COMMA_4=null;
        Token this_SKW_RIGHTPAREN_6=null;
        Token this_SKW_ASSIGN_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_params_3_0 = null;

        AntlrDatatypeRuleToken lv_params_5_0 = null;

        AntlrDatatypeRuleToken lv_value_8_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:570:7: ( ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) ) )
            // InternalCmdArgs.g:572:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) )
            {
            // InternalCmdArgs.g:572:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) )
            // InternalCmdArgs.g:573:1: () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) )
            {
            // InternalCmdArgs.g:573:1: ()
            // InternalCmdArgs.g:574:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFunctionMacroAccess().getFunctionMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgs.g:582:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalCmdArgs.g:583:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalCmdArgs.g:583:1: (lv_name_1_0= ruleIdentifier )
            // InternalCmdArgs.g:584:3: lv_name_1_0= ruleIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getNameIdentifierParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_7);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFunctionMacroRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_SKW_LEFTPAREN_2=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_8); 
             
                newLeafNode(this_SKW_LEFTPAREN_2, grammarAccess.getFunctionMacroAccess().getSKW_LEFTPARENTerminalRuleCall_2()); 
                
            // InternalCmdArgs.g:610:1: ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalCmdArgs.g:611:1: ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )*
                    {
                    // InternalCmdArgs.g:611:1: ( (lv_params_3_0= ruleIdentifier ) )
                    // InternalCmdArgs.g:612:1: (lv_params_3_0= ruleIdentifier )
                    {
                    // InternalCmdArgs.g:612:1: (lv_params_3_0= ruleIdentifier )
                    // InternalCmdArgs.g:613:3: lv_params_3_0= ruleIdentifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getParamsIdentifierParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_9);
                    lv_params_3_0=ruleIdentifier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFunctionMacroRule());
                    	        }
                           		add(
                           			current, 
                           			"params",
                            		lv_params_3_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalCmdArgs.g:632:1: (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==RULE_SKW_COMMA) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalCmdArgs.g:633:1: this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) )
                    	    {
                    	    this_SKW_COMMA_4=(Token)match(input,RULE_SKW_COMMA,FOLLOW_4); 
                    	     
                    	        newLeafNode(this_SKW_COMMA_4, grammarAccess.getFunctionMacroAccess().getSKW_COMMATerminalRuleCall_3_1_0()); 
                    	        
                    	    // InternalCmdArgs.g:640:1: ( (lv_params_5_0= ruleIdentifier ) )
                    	    // InternalCmdArgs.g:641:1: (lv_params_5_0= ruleIdentifier )
                    	    {
                    	    // InternalCmdArgs.g:641:1: (lv_params_5_0= ruleIdentifier )
                    	    // InternalCmdArgs.g:642:3: lv_params_5_0= ruleIdentifier
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getParamsIdentifierParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_9);
                    	    lv_params_5_0=ruleIdentifier();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFunctionMacroRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"params",
                    	            		lv_params_5_0, 
                    	            		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            this_SKW_RIGHTPAREN_6=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_5); 
             
                newLeafNode(this_SKW_RIGHTPAREN_6, grammarAccess.getFunctionMacroAccess().getSKW_RIGHTPARENTerminalRuleCall_4()); 
                
            this_SKW_ASSIGN_7=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_6); 
             
                newLeafNode(this_SKW_ASSIGN_7, grammarAccess.getFunctionMacroAccess().getSKW_ASSIGNTerminalRuleCall_5()); 
                
            // InternalCmdArgs.g:679:1: ( (lv_value_8_0= ruleMyCode ) )
            // InternalCmdArgs.g:680:1: (lv_value_8_0= ruleMyCode )
            {
            // InternalCmdArgs.g:680:1: (lv_value_8_0= ruleMyCode )
            // InternalCmdArgs.g:681:3: lv_value_8_0= ruleMyCode
            {
             
            	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getValueMyCodeParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_8_0=ruleMyCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFunctionMacroRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_8_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.MyCode");
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
    // $ANTLR end "ruleFunctionMacro"


    // $ANTLR start "entryRuleIncludeCmd"
    // InternalCmdArgs.g:709:1: entryRuleIncludeCmd returns [EObject current=null] : iv_ruleIncludeCmd= ruleIncludeCmd EOF ;
    public final EObject entryRuleIncludeCmd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeCmd = null;


        try {
            // InternalCmdArgs.g:710:2: (iv_ruleIncludeCmd= ruleIncludeCmd EOF )
            // InternalCmdArgs.g:711:2: iv_ruleIncludeCmd= ruleIncludeCmd EOF
            {
             newCompositeNode(grammarAccess.getIncludeCmdRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIncludeCmd=ruleIncludeCmd();

            state._fsp--;

             current =iv_ruleIncludeCmd; 
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
    // $ANTLR end "entryRuleIncludeCmd"


    // $ANTLR start "ruleIncludeCmd"
    // InternalCmdArgs.g:718:1: ruleIncludeCmd returns [EObject current=null] : ( (lv_name_0_0= ruleIdentifier ) ) ;
    public final EObject ruleIncludeCmd() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:724:7: ( ( (lv_name_0_0= ruleIdentifier ) ) )
            // InternalCmdArgs.g:726:1: ( (lv_name_0_0= ruleIdentifier ) )
            {
            // InternalCmdArgs.g:726:1: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalCmdArgs.g:727:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalCmdArgs.g:727:1: (lv_name_0_0= ruleIdentifier )
            // InternalCmdArgs.g:728:3: lv_name_0_0= ruleIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getIncludeCmdAccess().getNameIdentifierParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIncludeCmdRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleIncludeCmd"


    // $ANTLR start "entryRuleIdentifier"
    // InternalCmdArgs.g:754:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalCmdArgs.g:755:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalCmdArgs.g:756:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
             newCompositeNode(grammarAccess.getIdentifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;

             current =iv_ruleIdentifier.getText(); 
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
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // InternalCmdArgs.g:763:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalCmdArgs.g:766:28: (this_ID_0= RULE_ID )
            // InternalCmdArgs.g:767:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleMyCode"
    // InternalCmdArgs.g:782:1: entryRuleMyCode returns [String current=null] : iv_ruleMyCode= ruleMyCode EOF ;
    public final String entryRuleMyCode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCode = null;


        try {
            // InternalCmdArgs.g:783:2: (iv_ruleMyCode= ruleMyCode EOF )
            // InternalCmdArgs.g:784:2: iv_ruleMyCode= ruleMyCode EOF
            {
             newCompositeNode(grammarAccess.getMyCodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMyCode=ruleMyCode();

            state._fsp--;

             current =iv_ruleMyCode.getText(); 
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
    // $ANTLR end "entryRuleMyCode"


    // $ANTLR start "ruleMyCode"
    // InternalCmdArgs.g:791:1: ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_HASH_3= RULE_HASH | this_SKW_COMMA_4= RULE_SKW_COMMA | this_SKW_LEFTPAREN_5= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )+ ;
    public final AntlrDatatypeRuleToken ruleMyCode() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_INT_1=null;
        Token this_STRING_2=null;
        Token this_HASH_3=null;
        Token this_SKW_COMMA_4=null;
        Token this_SKW_LEFTPAREN_5=null;
        Token this_SKW_RIGHTPAREN_6=null;

         enterRule(); 
            
        try {
            // InternalCmdArgs.g:794:28: ( (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_HASH_3= RULE_HASH | this_SKW_COMMA_4= RULE_SKW_COMMA | this_SKW_LEFTPAREN_5= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )+ )
            // InternalCmdArgs.g:795:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_HASH_3= RULE_HASH | this_SKW_COMMA_4= RULE_SKW_COMMA | this_SKW_LEFTPAREN_5= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )+
            {
            // InternalCmdArgs.g:795:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_HASH_3= RULE_HASH | this_SKW_COMMA_4= RULE_SKW_COMMA | this_SKW_LEFTPAREN_5= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN )+
            int cnt8=0;
            loop8:
            do {
                int alt8=8;
                switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt8=1;
                    }
                    break;
                case RULE_INT:
                    {
                    alt8=2;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt8=3;
                    }
                    break;
                case RULE_HASH:
                    {
                    alt8=4;
                    }
                    break;
                case RULE_SKW_COMMA:
                    {
                    alt8=5;
                    }
                    break;
                case RULE_SKW_LEFTPAREN:
                    {
                    alt8=6;
                    }
                    break;
                case RULE_SKW_RIGHTPAREN:
                    {
                    alt8=7;
                    }
                    break;

                }

                switch (alt8) {
            	case 1 :
            	    // InternalCmdArgs.g:795:6: this_ID_0= RULE_ID
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getMyCodeAccess().getIDTerminalRuleCall_0()); 
            	        

            	    }
            	    break;
            	case 2 :
            	    // InternalCmdArgs.g:803:10: this_INT_1= RULE_INT
            	    {
            	    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_10); 

            	    		current.merge(this_INT_1);
            	        
            	     
            	        newLeafNode(this_INT_1, grammarAccess.getMyCodeAccess().getINTTerminalRuleCall_1()); 
            	        

            	    }
            	    break;
            	case 3 :
            	    // InternalCmdArgs.g:811:10: this_STRING_2= RULE_STRING
            	    {
            	    this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_10); 

            	    		current.merge(this_STRING_2);
            	        
            	     
            	        newLeafNode(this_STRING_2, grammarAccess.getMyCodeAccess().getSTRINGTerminalRuleCall_2()); 
            	        

            	    }
            	    break;
            	case 4 :
            	    // InternalCmdArgs.g:819:10: this_HASH_3= RULE_HASH
            	    {
            	    this_HASH_3=(Token)match(input,RULE_HASH,FOLLOW_10); 

            	    		current.merge(this_HASH_3);
            	        
            	     
            	        newLeafNode(this_HASH_3, grammarAccess.getMyCodeAccess().getHASHTerminalRuleCall_3()); 
            	        

            	    }
            	    break;
            	case 5 :
            	    // InternalCmdArgs.g:827:10: this_SKW_COMMA_4= RULE_SKW_COMMA
            	    {
            	    this_SKW_COMMA_4=(Token)match(input,RULE_SKW_COMMA,FOLLOW_10); 

            	    		current.merge(this_SKW_COMMA_4);
            	        
            	     
            	        newLeafNode(this_SKW_COMMA_4, grammarAccess.getMyCodeAccess().getSKW_COMMATerminalRuleCall_4()); 
            	        

            	    }
            	    break;
            	case 6 :
            	    // InternalCmdArgs.g:835:10: this_SKW_LEFTPAREN_5= RULE_SKW_LEFTPAREN
            	    {
            	    this_SKW_LEFTPAREN_5=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_10); 

            	    		current.merge(this_SKW_LEFTPAREN_5);
            	        
            	     
            	        newLeafNode(this_SKW_LEFTPAREN_5, grammarAccess.getMyCodeAccess().getSKW_LEFTPARENTerminalRuleCall_5()); 
            	        

            	    }
            	    break;
            	case 7 :
            	    // InternalCmdArgs.g:843:10: this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN
            	    {
            	    this_SKW_RIGHTPAREN_6=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_10); 

            	    		current.merge(this_SKW_RIGHTPAREN_6);
            	        
            	     
            	        newLeafNode(this_SKW_RIGHTPAREN_6, grammarAccess.getMyCodeAccess().getSKW_RIGHTPARENTerminalRuleCall_6()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


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
    // $ANTLR end "ruleMyCode"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000001F2L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000001FC00L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x000000000001FC02L});

}