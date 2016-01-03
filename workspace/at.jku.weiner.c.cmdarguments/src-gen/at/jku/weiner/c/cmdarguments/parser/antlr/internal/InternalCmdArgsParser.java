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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_NEWLINE", "RULE_DEFINE", "RULE_INCLUDE", "RULE_INCSYS", "RULE_NOSTDINC", "RULE_SKW_ASSIGN", "RULE_SKW_LEFTPAREN", "RULE_SKW_COMMA", "RULE_SKW_RIGHTPAREN", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_HASH", "RULE_ANY_OTHER", "RULE_SKW_MINUS", "RULE_ML_COMMENT", "RULE_SL_COMMENT"
    };
    public static final int RULE_SKW_MINUS=19;
    public static final int RULE_ID=14;
    public static final int RULE_NEWLINE=5;
    public static final int RULE_ANY_OTHER=18;
    public static final int RULE_INCSYS=8;
    public static final int RULE_HASH=17;
    public static final int RULE_SL_COMMENT=21;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=20;
    public static final int RULE_SKW_RIGHTPAREN=13;
    public static final int RULE_STRING=16;
    public static final int RULE_DEFINE=6;
    public static final int RULE_NOSTDINC=9;
    public static final int RULE_INCLUDE=7;
    public static final int RULE_INT=15;
    public static final int RULE_SKW_COMMA=12;
    public static final int RULE_WS=4;
    public static final int RULE_SKW_ASSIGN=10;
    public static final int RULE_SKW_LEFTPAREN=11;

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
    // InternalCmdArgs.g:77:1: ruleModel returns [EObject current=null] : ( () ( ( (lv_lines_1_0= ruleCmdLine ) ) (this_WS_2= RULE_WS )* (this_NEWLINE_3= RULE_NEWLINE )? )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token this_WS_2=null;
        Token this_NEWLINE_3=null;
        EObject lv_lines_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:83:7: ( ( () ( ( (lv_lines_1_0= ruleCmdLine ) ) (this_WS_2= RULE_WS )* (this_NEWLINE_3= RULE_NEWLINE )? )* ) )
            // InternalCmdArgs.g:85:1: ( () ( ( (lv_lines_1_0= ruleCmdLine ) ) (this_WS_2= RULE_WS )* (this_NEWLINE_3= RULE_NEWLINE )? )* )
            {
            // InternalCmdArgs.g:85:1: ( () ( ( (lv_lines_1_0= ruleCmdLine ) ) (this_WS_2= RULE_WS )* (this_NEWLINE_3= RULE_NEWLINE )? )* )
            // InternalCmdArgs.g:86:1: () ( ( (lv_lines_1_0= ruleCmdLine ) ) (this_WS_2= RULE_WS )* (this_NEWLINE_3= RULE_NEWLINE )? )*
            {
            // InternalCmdArgs.g:86:1: ()
            // InternalCmdArgs.g:87:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

            // InternalCmdArgs.g:95:1: ( ( (lv_lines_1_0= ruleCmdLine ) ) (this_WS_2= RULE_WS )* (this_NEWLINE_3= RULE_NEWLINE )? )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=RULE_DEFINE && LA3_0<=RULE_NOSTDINC)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCmdArgs.g:96:1: ( (lv_lines_1_0= ruleCmdLine ) ) (this_WS_2= RULE_WS )* (this_NEWLINE_3= RULE_NEWLINE )?
            	    {
            	    // InternalCmdArgs.g:96:1: ( (lv_lines_1_0= ruleCmdLine ) )
            	    // InternalCmdArgs.g:97:1: (lv_lines_1_0= ruleCmdLine )
            	    {
            	    // InternalCmdArgs.g:97:1: (lv_lines_1_0= ruleCmdLine )
            	    // InternalCmdArgs.g:98:3: lv_lines_1_0= ruleCmdLine
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getLinesCmdLineParserRuleCall_1_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_lines_1_0=ruleCmdLine();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"lines",
            	            		lv_lines_1_0, 
            	            		"at.jku.weiner.c.cmdarguments.CmdArgs.CmdLine");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // InternalCmdArgs.g:117:1: (this_WS_2= RULE_WS )*
            	    loop1:
            	    do {
            	        int alt1=2;
            	        int LA1_0 = input.LA(1);

            	        if ( (LA1_0==RULE_WS) ) {
            	            alt1=1;
            	        }


            	        switch (alt1) {
            	    	case 1 :
            	    	    // InternalCmdArgs.g:117:2: this_WS_2= RULE_WS
            	    	    {
            	    	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_3); 
            	    	     
            	    	        newLeafNode(this_WS_2, grammarAccess.getModelAccess().getWSTerminalRuleCall_1_1()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop1;
            	        }
            	    } while (true);

            	    // InternalCmdArgs.g:124:1: (this_NEWLINE_3= RULE_NEWLINE )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==RULE_NEWLINE) ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // InternalCmdArgs.g:124:2: this_NEWLINE_3= RULE_NEWLINE
            	            {
            	            this_NEWLINE_3=(Token)match(input,RULE_NEWLINE,FOLLOW_3); 
            	             
            	                newLeafNode(this_NEWLINE_3, grammarAccess.getModelAccess().getNEWLINETerminalRuleCall_1_2()); 
            	                

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // InternalCmdArgs.g:142:1: entryRuleCmdLine returns [EObject current=null] : iv_ruleCmdLine= ruleCmdLine EOF ;
    public final EObject entryRuleCmdLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCmdLine = null;


        try {
            // InternalCmdArgs.g:143:2: (iv_ruleCmdLine= ruleCmdLine EOF )
            // InternalCmdArgs.g:144:2: iv_ruleCmdLine= ruleCmdLine EOF
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
    // InternalCmdArgs.g:151:1: ruleCmdLine returns [EObject current=null] : ( () ( (lv_arguments_1_0= ruleArgument ) )+ ) ;
    public final EObject ruleCmdLine() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:157:7: ( ( () ( (lv_arguments_1_0= ruleArgument ) )+ ) )
            // InternalCmdArgs.g:159:1: ( () ( (lv_arguments_1_0= ruleArgument ) )+ )
            {
            // InternalCmdArgs.g:159:1: ( () ( (lv_arguments_1_0= ruleArgument ) )+ )
            // InternalCmdArgs.g:160:1: () ( (lv_arguments_1_0= ruleArgument ) )+
            {
            // InternalCmdArgs.g:160:1: ()
            // InternalCmdArgs.g:161:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCmdLineAccess().getCmdLineAction_0(),
                        current);
                

            }

            // InternalCmdArgs.g:169:1: ( (lv_arguments_1_0= ruleArgument ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                switch ( input.LA(1) ) {
                case RULE_DEFINE:
                    {
                    alt4=1;
                    }
                    break;
                case RULE_INCLUDE:
                    {
                    alt4=1;
                    }
                    break;
                case RULE_INCSYS:
                    {
                    alt4=1;
                    }
                    break;
                case RULE_NOSTDINC:
                    {
                    alt4=1;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // InternalCmdArgs.g:170:1: (lv_arguments_1_0= ruleArgument )
            	    {
            	    // InternalCmdArgs.g:170:1: (lv_arguments_1_0= ruleArgument )
            	    // InternalCmdArgs.g:171:3: lv_arguments_1_0= ruleArgument
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
    // InternalCmdArgs.g:199:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // InternalCmdArgs.g:200:2: (iv_ruleArgument= ruleArgument EOF )
            // InternalCmdArgs.g:201:2: iv_ruleArgument= ruleArgument EOF
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
    // InternalCmdArgs.g:208:1: ruleArgument returns [EObject current=null] : ( () ( (this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_INCLUDE ) ) ( (lv_useIncDir_4_0= ruleUseIncludeDirCmd ) ) ) | ( ( (lv_incSys_5_0= RULE_INCSYS ) ) ( (lv_useIncDir_6_0= ruleUseIncludeDirCmd ) ) ) | ( (lv_nostdinc_7_0= RULE_NOSTDINC ) ) ) ) ;
    public final EObject ruleArgument() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_1=null;
        Token lv_incDir_3_0=null;
        Token lv_incSys_5_0=null;
        Token lv_nostdinc_7_0=null;
        EObject lv_macro_2_0 = null;

        EObject lv_useIncDir_4_0 = null;

        EObject lv_useIncDir_6_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:214:7: ( ( () ( (this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_INCLUDE ) ) ( (lv_useIncDir_4_0= ruleUseIncludeDirCmd ) ) ) | ( ( (lv_incSys_5_0= RULE_INCSYS ) ) ( (lv_useIncDir_6_0= ruleUseIncludeDirCmd ) ) ) | ( (lv_nostdinc_7_0= RULE_NOSTDINC ) ) ) ) )
            // InternalCmdArgs.g:216:1: ( () ( (this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_INCLUDE ) ) ( (lv_useIncDir_4_0= ruleUseIncludeDirCmd ) ) ) | ( ( (lv_incSys_5_0= RULE_INCSYS ) ) ( (lv_useIncDir_6_0= ruleUseIncludeDirCmd ) ) ) | ( (lv_nostdinc_7_0= RULE_NOSTDINC ) ) ) )
            {
            // InternalCmdArgs.g:216:1: ( () ( (this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_INCLUDE ) ) ( (lv_useIncDir_4_0= ruleUseIncludeDirCmd ) ) ) | ( ( (lv_incSys_5_0= RULE_INCSYS ) ) ( (lv_useIncDir_6_0= ruleUseIncludeDirCmd ) ) ) | ( (lv_nostdinc_7_0= RULE_NOSTDINC ) ) ) )
            // InternalCmdArgs.g:217:1: () ( (this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_INCLUDE ) ) ( (lv_useIncDir_4_0= ruleUseIncludeDirCmd ) ) ) | ( ( (lv_incSys_5_0= RULE_INCSYS ) ) ( (lv_useIncDir_6_0= ruleUseIncludeDirCmd ) ) ) | ( (lv_nostdinc_7_0= RULE_NOSTDINC ) ) )
            {
            // InternalCmdArgs.g:217:1: ()
            // InternalCmdArgs.g:218:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArgumentAccess().getArgumentAction_0(),
                        current);
                

            }

            // InternalCmdArgs.g:226:1: ( (this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_INCLUDE ) ) ( (lv_useIncDir_4_0= ruleUseIncludeDirCmd ) ) ) | ( ( (lv_incSys_5_0= RULE_INCSYS ) ) ( (lv_useIncDir_6_0= ruleUseIncludeDirCmd ) ) ) | ( (lv_nostdinc_7_0= RULE_NOSTDINC ) ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case RULE_DEFINE:
                {
                alt5=1;
                }
                break;
            case RULE_INCLUDE:
                {
                alt5=2;
                }
                break;
            case RULE_INCSYS:
                {
                alt5=3;
                }
                break;
            case RULE_NOSTDINC:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalCmdArgs.g:227:1: (this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) ) )
                    {
                    // InternalCmdArgs.g:227:1: (this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) ) )
                    // InternalCmdArgs.g:228:1: this_DEFINE_1= RULE_DEFINE ( (lv_macro_2_0= ruleMacro ) )
                    {
                    this_DEFINE_1=(Token)match(input,RULE_DEFINE,FOLLOW_4); 
                     
                        newLeafNode(this_DEFINE_1, grammarAccess.getArgumentAccess().getDEFINETerminalRuleCall_1_0_0()); 
                        
                    // InternalCmdArgs.g:235:1: ( (lv_macro_2_0= ruleMacro ) )
                    // InternalCmdArgs.g:236:1: (lv_macro_2_0= ruleMacro )
                    {
                    // InternalCmdArgs.g:236:1: (lv_macro_2_0= ruleMacro )
                    // InternalCmdArgs.g:237:3: lv_macro_2_0= ruleMacro
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
                    // InternalCmdArgs.g:259:1: ( ( (lv_incDir_3_0= RULE_INCLUDE ) ) ( (lv_useIncDir_4_0= ruleUseIncludeDirCmd ) ) )
                    {
                    // InternalCmdArgs.g:259:1: ( ( (lv_incDir_3_0= RULE_INCLUDE ) ) ( (lv_useIncDir_4_0= ruleUseIncludeDirCmd ) ) )
                    // InternalCmdArgs.g:260:1: ( (lv_incDir_3_0= RULE_INCLUDE ) ) ( (lv_useIncDir_4_0= ruleUseIncludeDirCmd ) )
                    {
                    // InternalCmdArgs.g:260:1: ( (lv_incDir_3_0= RULE_INCLUDE ) )
                    // InternalCmdArgs.g:261:1: (lv_incDir_3_0= RULE_INCLUDE )
                    {
                    // InternalCmdArgs.g:261:1: (lv_incDir_3_0= RULE_INCLUDE )
                    // InternalCmdArgs.g:262:3: lv_incDir_3_0= RULE_INCLUDE
                    {
                    lv_incDir_3_0=(Token)match(input,RULE_INCLUDE,FOLLOW_5); 

                    			newLeafNode(lv_incDir_3_0, grammarAccess.getArgumentAccess().getIncDirINCLUDETerminalRuleCall_1_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getArgumentRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"incDir",
                            		true, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.INCLUDE");
                    	    

                    }


                    }

                    // InternalCmdArgs.g:281:1: ( (lv_useIncDir_4_0= ruleUseIncludeDirCmd ) )
                    // InternalCmdArgs.g:282:1: (lv_useIncDir_4_0= ruleUseIncludeDirCmd )
                    {
                    // InternalCmdArgs.g:282:1: (lv_useIncDir_4_0= ruleUseIncludeDirCmd )
                    // InternalCmdArgs.g:283:3: lv_useIncDir_4_0= ruleUseIncludeDirCmd
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getUseIncDirUseIncludeDirCmdParserRuleCall_1_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_useIncDir_4_0=ruleUseIncludeDirCmd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"useIncDir",
                            		lv_useIncDir_4_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.UseIncludeDirCmd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCmdArgs.g:305:1: ( ( (lv_incSys_5_0= RULE_INCSYS ) ) ( (lv_useIncDir_6_0= ruleUseIncludeDirCmd ) ) )
                    {
                    // InternalCmdArgs.g:305:1: ( ( (lv_incSys_5_0= RULE_INCSYS ) ) ( (lv_useIncDir_6_0= ruleUseIncludeDirCmd ) ) )
                    // InternalCmdArgs.g:306:1: ( (lv_incSys_5_0= RULE_INCSYS ) ) ( (lv_useIncDir_6_0= ruleUseIncludeDirCmd ) )
                    {
                    // InternalCmdArgs.g:306:1: ( (lv_incSys_5_0= RULE_INCSYS ) )
                    // InternalCmdArgs.g:307:1: (lv_incSys_5_0= RULE_INCSYS )
                    {
                    // InternalCmdArgs.g:307:1: (lv_incSys_5_0= RULE_INCSYS )
                    // InternalCmdArgs.g:308:3: lv_incSys_5_0= RULE_INCSYS
                    {
                    lv_incSys_5_0=(Token)match(input,RULE_INCSYS,FOLLOW_5); 

                    			newLeafNode(lv_incSys_5_0, grammarAccess.getArgumentAccess().getIncSysINCSYSTerminalRuleCall_1_2_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getArgumentRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"incSys",
                            		true, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.INCSYS");
                    	    

                    }


                    }

                    // InternalCmdArgs.g:327:1: ( (lv_useIncDir_6_0= ruleUseIncludeDirCmd ) )
                    // InternalCmdArgs.g:328:1: (lv_useIncDir_6_0= ruleUseIncludeDirCmd )
                    {
                    // InternalCmdArgs.g:328:1: (lv_useIncDir_6_0= ruleUseIncludeDirCmd )
                    // InternalCmdArgs.g:329:3: lv_useIncDir_6_0= ruleUseIncludeDirCmd
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getUseIncDirUseIncludeDirCmdParserRuleCall_1_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_useIncDir_6_0=ruleUseIncludeDirCmd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"useIncDir",
                            		lv_useIncDir_6_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.UseIncludeDirCmd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalCmdArgs.g:351:1: ( (lv_nostdinc_7_0= RULE_NOSTDINC ) )
                    {
                    // InternalCmdArgs.g:351:1: ( (lv_nostdinc_7_0= RULE_NOSTDINC ) )
                    // InternalCmdArgs.g:352:1: (lv_nostdinc_7_0= RULE_NOSTDINC )
                    {
                    // InternalCmdArgs.g:352:1: (lv_nostdinc_7_0= RULE_NOSTDINC )
                    // InternalCmdArgs.g:353:3: lv_nostdinc_7_0= RULE_NOSTDINC
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
    // InternalCmdArgs.g:383:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // InternalCmdArgs.g:384:2: (iv_ruleMacro= ruleMacro EOF )
            // InternalCmdArgs.g:385:2: iv_ruleMacro= ruleMacro EOF
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
    // InternalCmdArgs.g:392:1: ruleMacro returns [EObject current=null] : (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro ) ;
    public final EObject ruleMacro() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleMacro_0 = null;

        EObject this_ObjectMacro_1 = null;

        EObject this_FunctionMacro_2 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:398:7: ( (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro ) )
            // InternalCmdArgs.g:400:1: (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro )
            {
            // InternalCmdArgs.g:400:1: (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case EOF:
                case RULE_WS:
                case RULE_NEWLINE:
                case RULE_DEFINE:
                case RULE_INCLUDE:
                case RULE_INCSYS:
                case RULE_NOSTDINC:
                    {
                    alt6=1;
                    }
                    break;
                case RULE_SKW_LEFTPAREN:
                    {
                    alt6=3;
                    }
                    break;
                case RULE_SKW_ASSIGN:
                    {
                    alt6=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalCmdArgs.g:402:5: this_SimpleMacro_0= ruleSimpleMacro
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
                    // InternalCmdArgs.g:415:5: this_ObjectMacro_1= ruleObjectMacro
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
                    // InternalCmdArgs.g:428:5: this_FunctionMacro_2= ruleFunctionMacro
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
    // InternalCmdArgs.g:448:1: entryRuleSimpleMacro returns [EObject current=null] : iv_ruleSimpleMacro= ruleSimpleMacro EOF ;
    public final EObject entryRuleSimpleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleMacro = null;


        try {
            // InternalCmdArgs.g:449:2: (iv_ruleSimpleMacro= ruleSimpleMacro EOF )
            // InternalCmdArgs.g:450:2: iv_ruleSimpleMacro= ruleSimpleMacro EOF
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
    // InternalCmdArgs.g:457:1: ruleSimpleMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleSimpleMacro() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:463:7: ( ( () ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // InternalCmdArgs.g:465:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // InternalCmdArgs.g:465:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) )
            // InternalCmdArgs.g:466:1: () ( (lv_name_1_0= ruleIdentifier ) )
            {
            // InternalCmdArgs.g:466:1: ()
            // InternalCmdArgs.g:467:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSimpleMacroAccess().getSimpleMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgs.g:475:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalCmdArgs.g:476:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalCmdArgs.g:476:1: (lv_name_1_0= ruleIdentifier )
            // InternalCmdArgs.g:477:3: lv_name_1_0= ruleIdentifier
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
    // InternalCmdArgs.g:505:1: entryRuleObjectMacro returns [EObject current=null] : iv_ruleObjectMacro= ruleObjectMacro EOF ;
    public final EObject entryRuleObjectMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectMacro = null;


        try {
            // InternalCmdArgs.g:506:2: (iv_ruleObjectMacro= ruleObjectMacro EOF )
            // InternalCmdArgs.g:507:2: iv_ruleObjectMacro= ruleObjectMacro EOF
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
    // InternalCmdArgs.g:514:1: ruleObjectMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) ) ;
    public final EObject ruleObjectMacro() throws RecognitionException {
        EObject current = null;

        Token this_SKW_ASSIGN_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:520:7: ( ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) ) )
            // InternalCmdArgs.g:522:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) )
            {
            // InternalCmdArgs.g:522:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) )
            // InternalCmdArgs.g:523:1: () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) )
            {
            // InternalCmdArgs.g:523:1: ()
            // InternalCmdArgs.g:524:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getObjectMacroAccess().getObjectMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgs.g:532:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalCmdArgs.g:533:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalCmdArgs.g:533:1: (lv_name_1_0= ruleIdentifier )
            // InternalCmdArgs.g:534:3: lv_name_1_0= ruleIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getObjectMacroAccess().getNameIdentifierParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_6);
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

            this_SKW_ASSIGN_2=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_7); 
             
                newLeafNode(this_SKW_ASSIGN_2, grammarAccess.getObjectMacroAccess().getSKW_ASSIGNTerminalRuleCall_2()); 
                
            // InternalCmdArgs.g:560:1: ( (lv_value_3_0= ruleMyCode ) )
            // InternalCmdArgs.g:561:1: (lv_value_3_0= ruleMyCode )
            {
            // InternalCmdArgs.g:561:1: (lv_value_3_0= ruleMyCode )
            // InternalCmdArgs.g:562:3: lv_value_3_0= ruleMyCode
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
    // InternalCmdArgs.g:590:1: entryRuleFunctionMacro returns [EObject current=null] : iv_ruleFunctionMacro= ruleFunctionMacro EOF ;
    public final EObject entryRuleFunctionMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionMacro = null;


        try {
            // InternalCmdArgs.g:591:2: (iv_ruleFunctionMacro= ruleFunctionMacro EOF )
            // InternalCmdArgs.g:592:2: iv_ruleFunctionMacro= ruleFunctionMacro EOF
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
    // InternalCmdArgs.g:599:1: ruleFunctionMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) ) ;
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
            // InternalCmdArgs.g:605:7: ( ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) ) )
            // InternalCmdArgs.g:607:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) )
            {
            // InternalCmdArgs.g:607:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) )
            // InternalCmdArgs.g:608:1: () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) )
            {
            // InternalCmdArgs.g:608:1: ()
            // InternalCmdArgs.g:609:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFunctionMacroAccess().getFunctionMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgs.g:617:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalCmdArgs.g:618:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalCmdArgs.g:618:1: (lv_name_1_0= ruleIdentifier )
            // InternalCmdArgs.g:619:3: lv_name_1_0= ruleIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getNameIdentifierParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_8);
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

            this_SKW_LEFTPAREN_2=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_9); 
             
                newLeafNode(this_SKW_LEFTPAREN_2, grammarAccess.getFunctionMacroAccess().getSKW_LEFTPARENTerminalRuleCall_2()); 
                
            // InternalCmdArgs.g:645:1: ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalCmdArgs.g:646:1: ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )*
                    {
                    // InternalCmdArgs.g:646:1: ( (lv_params_3_0= ruleIdentifier ) )
                    // InternalCmdArgs.g:647:1: (lv_params_3_0= ruleIdentifier )
                    {
                    // InternalCmdArgs.g:647:1: (lv_params_3_0= ruleIdentifier )
                    // InternalCmdArgs.g:648:3: lv_params_3_0= ruleIdentifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getParamsIdentifierParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_10);
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

                    // InternalCmdArgs.g:667:1: (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_SKW_COMMA) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalCmdArgs.g:668:1: this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) )
                    	    {
                    	    this_SKW_COMMA_4=(Token)match(input,RULE_SKW_COMMA,FOLLOW_4); 
                    	     
                    	        newLeafNode(this_SKW_COMMA_4, grammarAccess.getFunctionMacroAccess().getSKW_COMMATerminalRuleCall_3_1_0()); 
                    	        
                    	    // InternalCmdArgs.g:675:1: ( (lv_params_5_0= ruleIdentifier ) )
                    	    // InternalCmdArgs.g:676:1: (lv_params_5_0= ruleIdentifier )
                    	    {
                    	    // InternalCmdArgs.g:676:1: (lv_params_5_0= ruleIdentifier )
                    	    // InternalCmdArgs.g:677:3: lv_params_5_0= ruleIdentifier
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getParamsIdentifierParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_10);
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
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            this_SKW_RIGHTPAREN_6=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_6); 
             
                newLeafNode(this_SKW_RIGHTPAREN_6, grammarAccess.getFunctionMacroAccess().getSKW_RIGHTPARENTerminalRuleCall_4()); 
                
            this_SKW_ASSIGN_7=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_7); 
             
                newLeafNode(this_SKW_ASSIGN_7, grammarAccess.getFunctionMacroAccess().getSKW_ASSIGNTerminalRuleCall_5()); 
                
            // InternalCmdArgs.g:714:1: ( (lv_value_8_0= ruleMyCode ) )
            // InternalCmdArgs.g:715:1: (lv_value_8_0= ruleMyCode )
            {
            // InternalCmdArgs.g:715:1: (lv_value_8_0= ruleMyCode )
            // InternalCmdArgs.g:716:3: lv_value_8_0= ruleMyCode
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


    // $ANTLR start "entryRuleUseIncludeDirCmd"
    // InternalCmdArgs.g:744:1: entryRuleUseIncludeDirCmd returns [EObject current=null] : iv_ruleUseIncludeDirCmd= ruleUseIncludeDirCmd EOF ;
    public final EObject entryRuleUseIncludeDirCmd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUseIncludeDirCmd = null;


        try {
            // InternalCmdArgs.g:745:2: (iv_ruleUseIncludeDirCmd= ruleUseIncludeDirCmd EOF )
            // InternalCmdArgs.g:746:2: iv_ruleUseIncludeDirCmd= ruleUseIncludeDirCmd EOF
            {
             newCompositeNode(grammarAccess.getUseIncludeDirCmdRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUseIncludeDirCmd=ruleUseIncludeDirCmd();

            state._fsp--;

             current =iv_ruleUseIncludeDirCmd; 
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
    // $ANTLR end "entryRuleUseIncludeDirCmd"


    // $ANTLR start "ruleUseIncludeDirCmd"
    // InternalCmdArgs.g:753:1: ruleUseIncludeDirCmd returns [EObject current=null] : ( (lv_path_0_0= rulePath ) ) ;
    public final EObject ruleUseIncludeDirCmd() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_path_0_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:759:7: ( ( (lv_path_0_0= rulePath ) ) )
            // InternalCmdArgs.g:761:1: ( (lv_path_0_0= rulePath ) )
            {
            // InternalCmdArgs.g:761:1: ( (lv_path_0_0= rulePath ) )
            // InternalCmdArgs.g:762:1: (lv_path_0_0= rulePath )
            {
            // InternalCmdArgs.g:762:1: (lv_path_0_0= rulePath )
            // InternalCmdArgs.g:763:3: lv_path_0_0= rulePath
            {
             
            	        newCompositeNode(grammarAccess.getUseIncludeDirCmdAccess().getPathPathParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_path_0_0=rulePath();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getUseIncludeDirCmdRule());
            	        }
                   		set(
                   			current, 
                   			"path",
                    		lv_path_0_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.Path");
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
    // $ANTLR end "ruleUseIncludeDirCmd"


    // $ANTLR start "entryRuleIdentifier"
    // InternalCmdArgs.g:789:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalCmdArgs.g:790:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalCmdArgs.g:791:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalCmdArgs.g:798:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalCmdArgs.g:801:28: (this_ID_0= RULE_ID )
            // InternalCmdArgs.g:802:5: this_ID_0= RULE_ID
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
    // InternalCmdArgs.g:817:1: entryRuleMyCode returns [String current=null] : iv_ruleMyCode= ruleMyCode EOF ;
    public final String entryRuleMyCode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCode = null;


        try {
            // InternalCmdArgs.g:818:2: (iv_ruleMyCode= ruleMyCode EOF )
            // InternalCmdArgs.g:819:2: iv_ruleMyCode= ruleMyCode EOF
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
    // InternalCmdArgs.g:826:1: ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_HASH_3= RULE_HASH | this_SKW_COMMA_4= RULE_SKW_COMMA | this_SKW_LEFTPAREN_5= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN | this_ANY_OTHER_7= RULE_ANY_OTHER )+ ;
    public final AntlrDatatypeRuleToken ruleMyCode() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_INT_1=null;
        Token this_STRING_2=null;
        Token this_HASH_3=null;
        Token this_SKW_COMMA_4=null;
        Token this_SKW_LEFTPAREN_5=null;
        Token this_SKW_RIGHTPAREN_6=null;
        Token this_ANY_OTHER_7=null;

         enterRule(); 
            
        try {
            // InternalCmdArgs.g:829:28: ( (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_HASH_3= RULE_HASH | this_SKW_COMMA_4= RULE_SKW_COMMA | this_SKW_LEFTPAREN_5= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN | this_ANY_OTHER_7= RULE_ANY_OTHER )+ )
            // InternalCmdArgs.g:830:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_HASH_3= RULE_HASH | this_SKW_COMMA_4= RULE_SKW_COMMA | this_SKW_LEFTPAREN_5= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN | this_ANY_OTHER_7= RULE_ANY_OTHER )+
            {
            // InternalCmdArgs.g:830:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_HASH_3= RULE_HASH | this_SKW_COMMA_4= RULE_SKW_COMMA | this_SKW_LEFTPAREN_5= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN | this_ANY_OTHER_7= RULE_ANY_OTHER )+
            int cnt9=0;
            loop9:
            do {
                int alt9=9;
                switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt9=1;
                    }
                    break;
                case RULE_INT:
                    {
                    alt9=2;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt9=3;
                    }
                    break;
                case RULE_HASH:
                    {
                    alt9=4;
                    }
                    break;
                case RULE_SKW_COMMA:
                    {
                    alt9=5;
                    }
                    break;
                case RULE_SKW_LEFTPAREN:
                    {
                    alt9=6;
                    }
                    break;
                case RULE_SKW_RIGHTPAREN:
                    {
                    alt9=7;
                    }
                    break;
                case RULE_ANY_OTHER:
                    {
                    alt9=8;
                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // InternalCmdArgs.g:830:6: this_ID_0= RULE_ID
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getMyCodeAccess().getIDTerminalRuleCall_0()); 
            	        

            	    }
            	    break;
            	case 2 :
            	    // InternalCmdArgs.g:838:10: this_INT_1= RULE_INT
            	    {
            	    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_11); 

            	    		current.merge(this_INT_1);
            	        
            	     
            	        newLeafNode(this_INT_1, grammarAccess.getMyCodeAccess().getINTTerminalRuleCall_1()); 
            	        

            	    }
            	    break;
            	case 3 :
            	    // InternalCmdArgs.g:846:10: this_STRING_2= RULE_STRING
            	    {
            	    this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_11); 

            	    		current.merge(this_STRING_2);
            	        
            	     
            	        newLeafNode(this_STRING_2, grammarAccess.getMyCodeAccess().getSTRINGTerminalRuleCall_2()); 
            	        

            	    }
            	    break;
            	case 4 :
            	    // InternalCmdArgs.g:854:10: this_HASH_3= RULE_HASH
            	    {
            	    this_HASH_3=(Token)match(input,RULE_HASH,FOLLOW_11); 

            	    		current.merge(this_HASH_3);
            	        
            	     
            	        newLeafNode(this_HASH_3, grammarAccess.getMyCodeAccess().getHASHTerminalRuleCall_3()); 
            	        

            	    }
            	    break;
            	case 5 :
            	    // InternalCmdArgs.g:862:10: this_SKW_COMMA_4= RULE_SKW_COMMA
            	    {
            	    this_SKW_COMMA_4=(Token)match(input,RULE_SKW_COMMA,FOLLOW_11); 

            	    		current.merge(this_SKW_COMMA_4);
            	        
            	     
            	        newLeafNode(this_SKW_COMMA_4, grammarAccess.getMyCodeAccess().getSKW_COMMATerminalRuleCall_4()); 
            	        

            	    }
            	    break;
            	case 6 :
            	    // InternalCmdArgs.g:870:10: this_SKW_LEFTPAREN_5= RULE_SKW_LEFTPAREN
            	    {
            	    this_SKW_LEFTPAREN_5=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_11); 

            	    		current.merge(this_SKW_LEFTPAREN_5);
            	        
            	     
            	        newLeafNode(this_SKW_LEFTPAREN_5, grammarAccess.getMyCodeAccess().getSKW_LEFTPARENTerminalRuleCall_5()); 
            	        

            	    }
            	    break;
            	case 7 :
            	    // InternalCmdArgs.g:878:10: this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN
            	    {
            	    this_SKW_RIGHTPAREN_6=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_11); 

            	    		current.merge(this_SKW_RIGHTPAREN_6);
            	        
            	     
            	        newLeafNode(this_SKW_RIGHTPAREN_6, grammarAccess.getMyCodeAccess().getSKW_RIGHTPARENTerminalRuleCall_6()); 
            	        

            	    }
            	    break;
            	case 8 :
            	    // InternalCmdArgs.g:886:10: this_ANY_OTHER_7= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_7=(Token)match(input,RULE_ANY_OTHER,FOLLOW_11); 

            	    		current.merge(this_ANY_OTHER_7);
            	        
            	     
            	        newLeafNode(this_ANY_OTHER_7, grammarAccess.getMyCodeAccess().getANY_OTHERTerminalRuleCall_7()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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


    // $ANTLR start "entryRulePath"
    // InternalCmdArgs.g:901:1: entryRulePath returns [String current=null] : iv_rulePath= rulePath EOF ;
    public final String entryRulePath() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePath = null;


        try {
            // InternalCmdArgs.g:902:2: (iv_rulePath= rulePath EOF )
            // InternalCmdArgs.g:903:2: iv_rulePath= rulePath EOF
            {
             newCompositeNode(grammarAccess.getPathRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePath=rulePath();

            state._fsp--;

             current =iv_rulePath.getText(); 
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
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // InternalCmdArgs.g:910:1: rulePath returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_HASH_3= RULE_HASH | this_SKW_COMMA_4= RULE_SKW_COMMA | this_ANY_OTHER_5= RULE_ANY_OTHER )+ ;
    public final AntlrDatatypeRuleToken rulePath() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_INT_1=null;
        Token this_STRING_2=null;
        Token this_HASH_3=null;
        Token this_SKW_COMMA_4=null;
        Token this_ANY_OTHER_5=null;

         enterRule(); 
            
        try {
            // InternalCmdArgs.g:913:28: ( (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_HASH_3= RULE_HASH | this_SKW_COMMA_4= RULE_SKW_COMMA | this_ANY_OTHER_5= RULE_ANY_OTHER )+ )
            // InternalCmdArgs.g:914:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_HASH_3= RULE_HASH | this_SKW_COMMA_4= RULE_SKW_COMMA | this_ANY_OTHER_5= RULE_ANY_OTHER )+
            {
            // InternalCmdArgs.g:914:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_HASH_3= RULE_HASH | this_SKW_COMMA_4= RULE_SKW_COMMA | this_ANY_OTHER_5= RULE_ANY_OTHER )+
            int cnt10=0;
            loop10:
            do {
                int alt10=7;
                switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt10=1;
                    }
                    break;
                case RULE_INT:
                    {
                    alt10=2;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt10=3;
                    }
                    break;
                case RULE_HASH:
                    {
                    alt10=4;
                    }
                    break;
                case RULE_SKW_COMMA:
                    {
                    alt10=5;
                    }
                    break;
                case RULE_ANY_OTHER:
                    {
                    alt10=6;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // InternalCmdArgs.g:914:6: this_ID_0= RULE_ID
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getPathAccess().getIDTerminalRuleCall_0()); 
            	        

            	    }
            	    break;
            	case 2 :
            	    // InternalCmdArgs.g:922:10: this_INT_1= RULE_INT
            	    {
            	    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_12); 

            	    		current.merge(this_INT_1);
            	        
            	     
            	        newLeafNode(this_INT_1, grammarAccess.getPathAccess().getINTTerminalRuleCall_1()); 
            	        

            	    }
            	    break;
            	case 3 :
            	    // InternalCmdArgs.g:930:10: this_STRING_2= RULE_STRING
            	    {
            	    this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_12); 

            	    		current.merge(this_STRING_2);
            	        
            	     
            	        newLeafNode(this_STRING_2, grammarAccess.getPathAccess().getSTRINGTerminalRuleCall_2()); 
            	        

            	    }
            	    break;
            	case 4 :
            	    // InternalCmdArgs.g:938:10: this_HASH_3= RULE_HASH
            	    {
            	    this_HASH_3=(Token)match(input,RULE_HASH,FOLLOW_12); 

            	    		current.merge(this_HASH_3);
            	        
            	     
            	        newLeafNode(this_HASH_3, grammarAccess.getPathAccess().getHASHTerminalRuleCall_3()); 
            	        

            	    }
            	    break;
            	case 5 :
            	    // InternalCmdArgs.g:946:10: this_SKW_COMMA_4= RULE_SKW_COMMA
            	    {
            	    this_SKW_COMMA_4=(Token)match(input,RULE_SKW_COMMA,FOLLOW_12); 

            	    		current.merge(this_SKW_COMMA_4);
            	        
            	     
            	        newLeafNode(this_SKW_COMMA_4, grammarAccess.getPathAccess().getSKW_COMMATerminalRuleCall_4()); 
            	        

            	    }
            	    break;
            	case 6 :
            	    // InternalCmdArgs.g:954:10: this_ANY_OTHER_5= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_5=(Token)match(input,RULE_ANY_OTHER,FOLLOW_12); 

            	    		current.merge(this_ANY_OTHER_5);
            	        
            	     
            	        newLeafNode(this_ANY_OTHER_5, grammarAccess.getPathAccess().getANY_OTHERTerminalRuleCall_5()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
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
    // $ANTLR end "rulePath"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000003F2L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000007D000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000007F800L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000000000007F802L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000000000007D002L});

}