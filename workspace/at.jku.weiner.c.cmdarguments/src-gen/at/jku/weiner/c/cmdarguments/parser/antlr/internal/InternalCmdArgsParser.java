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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SKW_MINUS", "RULE_SKW_ASSIGN", "RULE_SKW_LEFTPAREN", "RULE_SKW_RIGHTPAREN", "RULE_SKW_COMMA", "RULE_KW_DEFINE", "RULE_KW_INCDIR", "RULE_KW_OUTPUT", "RULE_KW_LANG", "RULE_KW_NOSTDINC", "RULE_KW_INCSYS", "RULE_KW_INCLUDE", "RULE_LETTER", "RULE_DIGIT", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_NEWLINE", "RULE_WS", "RULE_LINE_COMMENT", "RULE_ANY_OTHER"
    };
    public static final int RULE_SKW_MINUS=4;
    public static final int RULE_ID=18;
    public static final int RULE_NEWLINE=21;
    public static final int RULE_KW_INCDIR=10;
    public static final int RULE_KW_OUTPUT=11;
    public static final int RULE_ANY_OTHER=24;
    public static final int RULE_KW_NOSTDINC=13;
    public static final int EOF=-1;
    public static final int RULE_LETTER=16;
    public static final int RULE_SKW_RIGHTPAREN=7;
    public static final int RULE_KW_INCLUDE=15;
    public static final int RULE_STRING=20;
    public static final int RULE_KW_DEFINE=9;
    public static final int RULE_KW_LANG=12;
    public static final int RULE_LINE_COMMENT=23;
    public static final int RULE_KW_INCSYS=14;
    public static final int RULE_INT=19;
    public static final int RULE_SKW_COMMA=8;
    public static final int RULE_WS=22;
    public static final int RULE_DIGIT=17;
    public static final int RULE_SKW_ASSIGN=5;
    public static final int RULE_SKW_LEFTPAREN=6;

    // delegates
    // delegators


        public InternalCmdArgsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCmdArgsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCmdArgsParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCmdArgsParser.g"; }




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
    // InternalCmdArgsParser.g:61:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalCmdArgsParser.g:62:2: (iv_ruleModel= ruleModel EOF )
            // InternalCmdArgsParser.g:63:2: iv_ruleModel= ruleModel EOF
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
    // InternalCmdArgsParser.g:70:1: ruleModel returns [EObject current=null] : ( () ( ( (lv_lines_1_0= ruleCmdLine ) ) (this_NEWLINE_2= RULE_NEWLINE ( (lv_lines_3_0= ruleCmdLine ) ) )* )? (this_NEWLINE_4= RULE_NEWLINE )? ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_2=null;
        Token this_NEWLINE_4=null;
        EObject lv_lines_1_0 = null;

        EObject lv_lines_3_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:73:28: ( ( () ( ( (lv_lines_1_0= ruleCmdLine ) ) (this_NEWLINE_2= RULE_NEWLINE ( (lv_lines_3_0= ruleCmdLine ) ) )* )? (this_NEWLINE_4= RULE_NEWLINE )? ) )
            // InternalCmdArgsParser.g:74:1: ( () ( ( (lv_lines_1_0= ruleCmdLine ) ) (this_NEWLINE_2= RULE_NEWLINE ( (lv_lines_3_0= ruleCmdLine ) ) )* )? (this_NEWLINE_4= RULE_NEWLINE )? )
            {
            // InternalCmdArgsParser.g:74:1: ( () ( ( (lv_lines_1_0= ruleCmdLine ) ) (this_NEWLINE_2= RULE_NEWLINE ( (lv_lines_3_0= ruleCmdLine ) ) )* )? (this_NEWLINE_4= RULE_NEWLINE )? )
            // InternalCmdArgsParser.g:74:2: () ( ( (lv_lines_1_0= ruleCmdLine ) ) (this_NEWLINE_2= RULE_NEWLINE ( (lv_lines_3_0= ruleCmdLine ) ) )* )? (this_NEWLINE_4= RULE_NEWLINE )?
            {
            // InternalCmdArgsParser.g:74:2: ()
            // InternalCmdArgsParser.g:75:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:80:2: ( ( (lv_lines_1_0= ruleCmdLine ) ) (this_NEWLINE_2= RULE_NEWLINE ( (lv_lines_3_0= ruleCmdLine ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=RULE_SKW_MINUS && LA2_0<=RULE_SKW_ASSIGN)||(LA2_0>=RULE_SKW_COMMA && LA2_0<=RULE_KW_LANG)||(LA2_0>=RULE_ID && LA2_0<=RULE_STRING)||LA2_0==RULE_ANY_OTHER) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalCmdArgsParser.g:80:3: ( (lv_lines_1_0= ruleCmdLine ) ) (this_NEWLINE_2= RULE_NEWLINE ( (lv_lines_3_0= ruleCmdLine ) ) )*
                    {
                    // InternalCmdArgsParser.g:80:3: ( (lv_lines_1_0= ruleCmdLine ) )
                    // InternalCmdArgsParser.g:81:1: (lv_lines_1_0= ruleCmdLine )
                    {
                    // InternalCmdArgsParser.g:81:1: (lv_lines_1_0= ruleCmdLine )
                    // InternalCmdArgsParser.g:82:3: lv_lines_1_0= ruleCmdLine
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

                    // InternalCmdArgsParser.g:98:2: (this_NEWLINE_2= RULE_NEWLINE ( (lv_lines_3_0= ruleCmdLine ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_NEWLINE) ) {
                            int LA1_1 = input.LA(2);

                            if ( ((LA1_1>=RULE_SKW_MINUS && LA1_1<=RULE_SKW_ASSIGN)||(LA1_1>=RULE_SKW_COMMA && LA1_1<=RULE_KW_LANG)||(LA1_1>=RULE_ID && LA1_1<=RULE_STRING)||LA1_1==RULE_ANY_OTHER) ) {
                                alt1=1;
                            }


                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:98:3: this_NEWLINE_2= RULE_NEWLINE ( (lv_lines_3_0= ruleCmdLine ) )
                    	    {
                    	    this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_4); 
                    	     
                    	        newLeafNode(this_NEWLINE_2, grammarAccess.getModelAccess().getNEWLINETerminalRuleCall_1_1_0()); 
                    	        
                    	    // InternalCmdArgsParser.g:102:1: ( (lv_lines_3_0= ruleCmdLine ) )
                    	    // InternalCmdArgsParser.g:103:1: (lv_lines_3_0= ruleCmdLine )
                    	    {
                    	    // InternalCmdArgsParser.g:103:1: (lv_lines_3_0= ruleCmdLine )
                    	    // InternalCmdArgsParser.g:104:3: lv_lines_3_0= ruleCmdLine
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getLinesCmdLineParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_3);
                    	    lv_lines_3_0=ruleCmdLine();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"lines",
                    	            		lv_lines_3_0, 
                    	            		"at.jku.weiner.c.cmdarguments.CmdArgs.CmdLine");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalCmdArgsParser.g:120:6: (this_NEWLINE_4= RULE_NEWLINE )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_NEWLINE) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalCmdArgsParser.g:120:7: this_NEWLINE_4= RULE_NEWLINE
                    {
                    this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_2); 
                     
                        newLeafNode(this_NEWLINE_4, grammarAccess.getModelAccess().getNEWLINETerminalRuleCall_2()); 
                        

                    }
                    break;

            }


            }


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleCmdLine"
    // InternalCmdArgsParser.g:132:1: entryRuleCmdLine returns [EObject current=null] : iv_ruleCmdLine= ruleCmdLine EOF ;
    public final EObject entryRuleCmdLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCmdLine = null;


        try {
            // InternalCmdArgsParser.g:133:2: (iv_ruleCmdLine= ruleCmdLine EOF )
            // InternalCmdArgsParser.g:134:2: iv_ruleCmdLine= ruleCmdLine EOF
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
    // InternalCmdArgsParser.g:141:1: ruleCmdLine returns [EObject current=null] : ( () ( ( (lv_arguments_1_0= ruleArgument ) ) ( (this_WS_2= RULE_WS )+ ( (lv_arguments_3_0= ruleArgument ) ) )* ) ) ;
    public final EObject ruleCmdLine() throws RecognitionException {
        EObject current = null;

        Token this_WS_2=null;
        EObject lv_arguments_1_0 = null;

        EObject lv_arguments_3_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:144:28: ( ( () ( ( (lv_arguments_1_0= ruleArgument ) ) ( (this_WS_2= RULE_WS )+ ( (lv_arguments_3_0= ruleArgument ) ) )* ) ) )
            // InternalCmdArgsParser.g:145:1: ( () ( ( (lv_arguments_1_0= ruleArgument ) ) ( (this_WS_2= RULE_WS )+ ( (lv_arguments_3_0= ruleArgument ) ) )* ) )
            {
            // InternalCmdArgsParser.g:145:1: ( () ( ( (lv_arguments_1_0= ruleArgument ) ) ( (this_WS_2= RULE_WS )+ ( (lv_arguments_3_0= ruleArgument ) ) )* ) )
            // InternalCmdArgsParser.g:145:2: () ( ( (lv_arguments_1_0= ruleArgument ) ) ( (this_WS_2= RULE_WS )+ ( (lv_arguments_3_0= ruleArgument ) ) )* )
            {
            // InternalCmdArgsParser.g:145:2: ()
            // InternalCmdArgsParser.g:146:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCmdLineAccess().getCmdLineAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:151:2: ( ( (lv_arguments_1_0= ruleArgument ) ) ( (this_WS_2= RULE_WS )+ ( (lv_arguments_3_0= ruleArgument ) ) )* )
            // InternalCmdArgsParser.g:151:3: ( (lv_arguments_1_0= ruleArgument ) ) ( (this_WS_2= RULE_WS )+ ( (lv_arguments_3_0= ruleArgument ) ) )*
            {
            // InternalCmdArgsParser.g:151:3: ( (lv_arguments_1_0= ruleArgument ) )
            // InternalCmdArgsParser.g:152:1: (lv_arguments_1_0= ruleArgument )
            {
            // InternalCmdArgsParser.g:152:1: (lv_arguments_1_0= ruleArgument )
            // InternalCmdArgsParser.g:153:3: lv_arguments_1_0= ruleArgument
            {
             
            	        newCompositeNode(grammarAccess.getCmdLineAccess().getArgumentsArgumentParserRuleCall_1_0_0()); 
            	    
            pushFollow(FOLLOW_5);
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

            // InternalCmdArgsParser.g:169:2: ( (this_WS_2= RULE_WS )+ ( (lv_arguments_3_0= ruleArgument ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_WS) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalCmdArgsParser.g:169:3: (this_WS_2= RULE_WS )+ ( (lv_arguments_3_0= ruleArgument ) )
            	    {
            	    // InternalCmdArgsParser.g:169:3: (this_WS_2= RULE_WS )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==RULE_WS) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalCmdArgsParser.g:169:4: this_WS_2= RULE_WS
            	    	    {
            	    	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_6); 
            	    	     
            	    	        newLeafNode(this_WS_2, grammarAccess.getCmdLineAccess().getWSTerminalRuleCall_1_1_0()); 
            	    	        

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

            	    // InternalCmdArgsParser.g:173:3: ( (lv_arguments_3_0= ruleArgument ) )
            	    // InternalCmdArgsParser.g:174:1: (lv_arguments_3_0= ruleArgument )
            	    {
            	    // InternalCmdArgsParser.g:174:1: (lv_arguments_3_0= ruleArgument )
            	    // InternalCmdArgsParser.g:175:3: lv_arguments_3_0= ruleArgument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCmdLineAccess().getArgumentsArgumentParserRuleCall_1_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_5);
            	    lv_arguments_3_0=ruleArgument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCmdLineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"arguments",
            	            		lv_arguments_3_0, 
            	            		"at.jku.weiner.c.cmdarguments.CmdArgs.Argument");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }


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
    // $ANTLR end "ruleCmdLine"


    // $ANTLR start "entryRuleArgument"
    // InternalCmdArgsParser.g:199:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // InternalCmdArgsParser.g:200:2: (iv_ruleArgument= ruleArgument EOF )
            // InternalCmdArgsParser.g:201:2: iv_ruleArgument= ruleArgument EOF
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
    // InternalCmdArgsParser.g:208:1: ruleArgument returns [EObject current=null] : ( () ( ( ruleDefine ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= ruleIncDir ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | ( ruleInclude (this_WS_10= RULE_WS )+ ( (lv_include_11_0= rulePathCmd ) ) ) | ( ruleOutput (this_WS_13= RULE_WS )+ ( (lv_out_14_0= rulePathCmd ) ) ) | ( ruleLang (this_WS_16= RULE_WS )+ ( (lv_lang_17_0= rulePathCmd ) ) ) | (this_SKW_MINUS_18= RULE_SKW_MINUS ( (lv_option_19_0= ruleOption ) )? ) | ( (lv_in_20_0= ruleOption ) ) ) ) ;
    public final EObject ruleArgument() throws RecognitionException {
        EObject current = null;

        Token this_WS_6=null;
        Token this_WS_10=null;
        Token this_WS_13=null;
        Token this_WS_16=null;
        Token this_SKW_MINUS_18=null;
        EObject lv_macro_2_0 = null;

        AntlrDatatypeRuleToken lv_incDir_3_0 = null;

        EObject lv_useIncDir_4_0 = null;

        AntlrDatatypeRuleToken lv_incSys_5_0 = null;

        EObject lv_useIncDir_7_0 = null;

        AntlrDatatypeRuleToken lv_nostdinc_8_0 = null;

        EObject lv_include_11_0 = null;

        EObject lv_out_14_0 = null;

        EObject lv_lang_17_0 = null;

        AntlrDatatypeRuleToken lv_option_19_0 = null;

        AntlrDatatypeRuleToken lv_in_20_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:211:28: ( ( () ( ( ruleDefine ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= ruleIncDir ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | ( ruleInclude (this_WS_10= RULE_WS )+ ( (lv_include_11_0= rulePathCmd ) ) ) | ( ruleOutput (this_WS_13= RULE_WS )+ ( (lv_out_14_0= rulePathCmd ) ) ) | ( ruleLang (this_WS_16= RULE_WS )+ ( (lv_lang_17_0= rulePathCmd ) ) ) | (this_SKW_MINUS_18= RULE_SKW_MINUS ( (lv_option_19_0= ruleOption ) )? ) | ( (lv_in_20_0= ruleOption ) ) ) ) )
            // InternalCmdArgsParser.g:212:1: ( () ( ( ruleDefine ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= ruleIncDir ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | ( ruleInclude (this_WS_10= RULE_WS )+ ( (lv_include_11_0= rulePathCmd ) ) ) | ( ruleOutput (this_WS_13= RULE_WS )+ ( (lv_out_14_0= rulePathCmd ) ) ) | ( ruleLang (this_WS_16= RULE_WS )+ ( (lv_lang_17_0= rulePathCmd ) ) ) | (this_SKW_MINUS_18= RULE_SKW_MINUS ( (lv_option_19_0= ruleOption ) )? ) | ( (lv_in_20_0= ruleOption ) ) ) )
            {
            // InternalCmdArgsParser.g:212:1: ( () ( ( ruleDefine ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= ruleIncDir ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | ( ruleInclude (this_WS_10= RULE_WS )+ ( (lv_include_11_0= rulePathCmd ) ) ) | ( ruleOutput (this_WS_13= RULE_WS )+ ( (lv_out_14_0= rulePathCmd ) ) ) | ( ruleLang (this_WS_16= RULE_WS )+ ( (lv_lang_17_0= rulePathCmd ) ) ) | (this_SKW_MINUS_18= RULE_SKW_MINUS ( (lv_option_19_0= ruleOption ) )? ) | ( (lv_in_20_0= ruleOption ) ) ) )
            // InternalCmdArgsParser.g:212:2: () ( ( ruleDefine ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= ruleIncDir ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | ( ruleInclude (this_WS_10= RULE_WS )+ ( (lv_include_11_0= rulePathCmd ) ) ) | ( ruleOutput (this_WS_13= RULE_WS )+ ( (lv_out_14_0= rulePathCmd ) ) ) | ( ruleLang (this_WS_16= RULE_WS )+ ( (lv_lang_17_0= rulePathCmd ) ) ) | (this_SKW_MINUS_18= RULE_SKW_MINUS ( (lv_option_19_0= ruleOption ) )? ) | ( (lv_in_20_0= ruleOption ) ) )
            {
            // InternalCmdArgsParser.g:212:2: ()
            // InternalCmdArgsParser.g:213:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArgumentAccess().getArgumentAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:218:2: ( ( ruleDefine ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= ruleIncDir ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | ( ruleInclude (this_WS_10= RULE_WS )+ ( (lv_include_11_0= rulePathCmd ) ) ) | ( ruleOutput (this_WS_13= RULE_WS )+ ( (lv_out_14_0= rulePathCmd ) ) ) | ( ruleLang (this_WS_16= RULE_WS )+ ( (lv_lang_17_0= rulePathCmd ) ) ) | (this_SKW_MINUS_18= RULE_SKW_MINUS ( (lv_option_19_0= ruleOption ) )? ) | ( (lv_in_20_0= ruleOption ) ) )
            int alt11=9;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalCmdArgsParser.g:218:3: ( ruleDefine ( (lv_macro_2_0= ruleMacro ) ) )
                    {
                    // InternalCmdArgsParser.g:218:3: ( ruleDefine ( (lv_macro_2_0= ruleMacro ) ) )
                    // InternalCmdArgsParser.g:219:5: ruleDefine ( (lv_macro_2_0= ruleMacro ) )
                    {
                     
                            newCompositeNode(grammarAccess.getArgumentAccess().getDefineParserRuleCall_1_0_0()); 
                        
                    pushFollow(FOLLOW_7);
                    ruleDefine();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        
                    // InternalCmdArgsParser.g:226:1: ( (lv_macro_2_0= ruleMacro ) )
                    // InternalCmdArgsParser.g:227:1: (lv_macro_2_0= ruleMacro )
                    {
                    // InternalCmdArgsParser.g:227:1: (lv_macro_2_0= ruleMacro )
                    // InternalCmdArgsParser.g:228:3: lv_macro_2_0= ruleMacro
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
                    // InternalCmdArgsParser.g:245:6: ( ( (lv_incDir_3_0= ruleIncDir ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:245:6: ( ( (lv_incDir_3_0= ruleIncDir ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:245:7: ( (lv_incDir_3_0= ruleIncDir ) ) ( (lv_useIncDir_4_0= rulePathCmd ) )
                    {
                    // InternalCmdArgsParser.g:245:7: ( (lv_incDir_3_0= ruleIncDir ) )
                    // InternalCmdArgsParser.g:246:1: (lv_incDir_3_0= ruleIncDir )
                    {
                    // InternalCmdArgsParser.g:246:1: (lv_incDir_3_0= ruleIncDir )
                    // InternalCmdArgsParser.g:247:3: lv_incDir_3_0= ruleIncDir
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getIncDirIncDirParserRuleCall_1_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_8);
                    lv_incDir_3_0=ruleIncDir();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"incDir",
                            		true, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.IncDir");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalCmdArgsParser.g:263:2: ( (lv_useIncDir_4_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:264:1: (lv_useIncDir_4_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:264:1: (lv_useIncDir_4_0= rulePathCmd )
                    // InternalCmdArgsParser.g:265:3: lv_useIncDir_4_0= rulePathCmd
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getUseIncDirPathCmdParserRuleCall_1_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_useIncDir_4_0=rulePathCmd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"useIncDir",
                            		lv_useIncDir_4_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.PathCmd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCmdArgsParser.g:282:6: ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:282:6: ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:282:7: ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) )
                    {
                    // InternalCmdArgsParser.g:282:7: ( (lv_incSys_5_0= ruleIncSys ) )
                    // InternalCmdArgsParser.g:283:1: (lv_incSys_5_0= ruleIncSys )
                    {
                    // InternalCmdArgsParser.g:283:1: (lv_incSys_5_0= ruleIncSys )
                    // InternalCmdArgsParser.g:284:3: lv_incSys_5_0= ruleIncSys
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getIncSysIncSysParserRuleCall_1_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_9);
                    lv_incSys_5_0=ruleIncSys();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"incSys",
                            		true, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.IncSys");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalCmdArgsParser.g:300:2: (this_WS_6= RULE_WS )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==RULE_WS) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:300:3: this_WS_6= RULE_WS
                    	    {
                    	    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_10); 
                    	     
                    	        newLeafNode(this_WS_6, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_2_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    // InternalCmdArgsParser.g:304:3: ( (lv_useIncDir_7_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:305:1: (lv_useIncDir_7_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:305:1: (lv_useIncDir_7_0= rulePathCmd )
                    // InternalCmdArgsParser.g:306:3: lv_useIncDir_7_0= rulePathCmd
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getUseIncDirPathCmdParserRuleCall_1_2_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_useIncDir_7_0=rulePathCmd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"useIncDir",
                            		lv_useIncDir_7_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.PathCmd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalCmdArgsParser.g:323:6: ( (lv_nostdinc_8_0= ruleNoStdInc ) )
                    {
                    // InternalCmdArgsParser.g:323:6: ( (lv_nostdinc_8_0= ruleNoStdInc ) )
                    // InternalCmdArgsParser.g:324:1: (lv_nostdinc_8_0= ruleNoStdInc )
                    {
                    // InternalCmdArgsParser.g:324:1: (lv_nostdinc_8_0= ruleNoStdInc )
                    // InternalCmdArgsParser.g:325:3: lv_nostdinc_8_0= ruleNoStdInc
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getNostdincNoStdIncParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_nostdinc_8_0=ruleNoStdInc();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"nostdinc",
                            		true, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.NoStdInc");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalCmdArgsParser.g:342:6: ( ruleInclude (this_WS_10= RULE_WS )+ ( (lv_include_11_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:342:6: ( ruleInclude (this_WS_10= RULE_WS )+ ( (lv_include_11_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:343:5: ruleInclude (this_WS_10= RULE_WS )+ ( (lv_include_11_0= rulePathCmd ) )
                    {
                     
                            newCompositeNode(grammarAccess.getArgumentAccess().getIncludeParserRuleCall_1_4_0()); 
                        
                    pushFollow(FOLLOW_9);
                    ruleInclude();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        
                    // InternalCmdArgsParser.g:350:1: (this_WS_10= RULE_WS )+
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
                    	    // InternalCmdArgsParser.g:350:2: this_WS_10= RULE_WS
                    	    {
                    	    this_WS_10=(Token)match(input,RULE_WS,FOLLOW_10); 
                    	     
                    	        newLeafNode(this_WS_10, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_4_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    // InternalCmdArgsParser.g:354:3: ( (lv_include_11_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:355:1: (lv_include_11_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:355:1: (lv_include_11_0= rulePathCmd )
                    // InternalCmdArgsParser.g:356:3: lv_include_11_0= rulePathCmd
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getIncludePathCmdParserRuleCall_1_4_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_include_11_0=rulePathCmd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"include",
                            		lv_include_11_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.PathCmd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalCmdArgsParser.g:373:6: ( ruleOutput (this_WS_13= RULE_WS )+ ( (lv_out_14_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:373:6: ( ruleOutput (this_WS_13= RULE_WS )+ ( (lv_out_14_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:374:5: ruleOutput (this_WS_13= RULE_WS )+ ( (lv_out_14_0= rulePathCmd ) )
                    {
                     
                            newCompositeNode(grammarAccess.getArgumentAccess().getOutputParserRuleCall_1_5_0()); 
                        
                    pushFollow(FOLLOW_9);
                    ruleOutput();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        
                    // InternalCmdArgsParser.g:381:1: (this_WS_13= RULE_WS )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_WS) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:381:2: this_WS_13= RULE_WS
                    	    {
                    	    this_WS_13=(Token)match(input,RULE_WS,FOLLOW_10); 
                    	     
                    	        newLeafNode(this_WS_13, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_5_1()); 
                    	        

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

                    // InternalCmdArgsParser.g:385:3: ( (lv_out_14_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:386:1: (lv_out_14_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:386:1: (lv_out_14_0= rulePathCmd )
                    // InternalCmdArgsParser.g:387:3: lv_out_14_0= rulePathCmd
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getOutPathCmdParserRuleCall_1_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_out_14_0=rulePathCmd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"out",
                            		lv_out_14_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.PathCmd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalCmdArgsParser.g:404:6: ( ruleLang (this_WS_16= RULE_WS )+ ( (lv_lang_17_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:404:6: ( ruleLang (this_WS_16= RULE_WS )+ ( (lv_lang_17_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:405:5: ruleLang (this_WS_16= RULE_WS )+ ( (lv_lang_17_0= rulePathCmd ) )
                    {
                     
                            newCompositeNode(grammarAccess.getArgumentAccess().getLangParserRuleCall_1_6_0()); 
                        
                    pushFollow(FOLLOW_9);
                    ruleLang();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        
                    // InternalCmdArgsParser.g:412:1: (this_WS_16= RULE_WS )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_WS) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:412:2: this_WS_16= RULE_WS
                    	    {
                    	    this_WS_16=(Token)match(input,RULE_WS,FOLLOW_10); 
                    	     
                    	        newLeafNode(this_WS_16, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_6_1()); 
                    	        

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

                    // InternalCmdArgsParser.g:416:3: ( (lv_lang_17_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:417:1: (lv_lang_17_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:417:1: (lv_lang_17_0= rulePathCmd )
                    // InternalCmdArgsParser.g:418:3: lv_lang_17_0= rulePathCmd
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getLangPathCmdParserRuleCall_1_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_lang_17_0=rulePathCmd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"lang",
                            		lv_lang_17_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.PathCmd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalCmdArgsParser.g:435:6: (this_SKW_MINUS_18= RULE_SKW_MINUS ( (lv_option_19_0= ruleOption ) )? )
                    {
                    // InternalCmdArgsParser.g:435:6: (this_SKW_MINUS_18= RULE_SKW_MINUS ( (lv_option_19_0= ruleOption ) )? )
                    // InternalCmdArgsParser.g:435:7: this_SKW_MINUS_18= RULE_SKW_MINUS ( (lv_option_19_0= ruleOption ) )?
                    {
                    this_SKW_MINUS_18=(Token)match(input,RULE_SKW_MINUS,FOLLOW_11); 
                     
                        newLeafNode(this_SKW_MINUS_18, grammarAccess.getArgumentAccess().getSKW_MINUSTerminalRuleCall_1_7_0()); 
                        
                    // InternalCmdArgsParser.g:439:1: ( (lv_option_19_0= ruleOption ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==RULE_SKW_ASSIGN||LA10_0==RULE_SKW_COMMA||(LA10_0>=RULE_ID && LA10_0<=RULE_STRING)||LA10_0==RULE_ANY_OTHER) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalCmdArgsParser.g:440:1: (lv_option_19_0= ruleOption )
                            {
                            // InternalCmdArgsParser.g:440:1: (lv_option_19_0= ruleOption )
                            // InternalCmdArgsParser.g:441:3: lv_option_19_0= ruleOption
                            {
                             
                            	        newCompositeNode(grammarAccess.getArgumentAccess().getOptionOptionParserRuleCall_1_7_1_0()); 
                            	    
                            pushFollow(FOLLOW_2);
                            lv_option_19_0=ruleOption();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"option",
                                    		lv_option_19_0, 
                                    		"at.jku.weiner.c.cmdarguments.CmdArgs.Option");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalCmdArgsParser.g:458:6: ( (lv_in_20_0= ruleOption ) )
                    {
                    // InternalCmdArgsParser.g:458:6: ( (lv_in_20_0= ruleOption ) )
                    // InternalCmdArgsParser.g:459:1: (lv_in_20_0= ruleOption )
                    {
                    // InternalCmdArgsParser.g:459:1: (lv_in_20_0= ruleOption )
                    // InternalCmdArgsParser.g:460:3: lv_in_20_0= ruleOption
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getInOptionParserRuleCall_1_8_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_in_20_0=ruleOption();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"in",
                            		lv_in_20_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.Option");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


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
    // $ANTLR end "ruleArgument"


    // $ANTLR start "entryRuleDefine"
    // InternalCmdArgsParser.g:484:1: entryRuleDefine returns [String current=null] : iv_ruleDefine= ruleDefine EOF ;
    public final String entryRuleDefine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDefine = null;


        try {
            // InternalCmdArgsParser.g:485:1: (iv_ruleDefine= ruleDefine EOF )
            // InternalCmdArgsParser.g:486:2: iv_ruleDefine= ruleDefine EOF
            {
             newCompositeNode(grammarAccess.getDefineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefine=ruleDefine();

            state._fsp--;

             current =iv_ruleDefine.getText(); 
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
    // $ANTLR end "entryRuleDefine"


    // $ANTLR start "ruleDefine"
    // InternalCmdArgsParser.g:493:1: ruleDefine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_KW_DEFINE_0= RULE_KW_DEFINE ;
    public final AntlrDatatypeRuleToken ruleDefine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_KW_DEFINE_0=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:497:6: (this_KW_DEFINE_0= RULE_KW_DEFINE )
            // InternalCmdArgsParser.g:498:5: this_KW_DEFINE_0= RULE_KW_DEFINE
            {
            this_KW_DEFINE_0=(Token)match(input,RULE_KW_DEFINE,FOLLOW_2); 

            		current.merge(this_KW_DEFINE_0);
                
             
                newLeafNode(this_KW_DEFINE_0, grammarAccess.getDefineAccess().getKW_DEFINETerminalRuleCall()); 
                

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
    // $ANTLR end "ruleDefine"


    // $ANTLR start "entryRuleIncDir"
    // InternalCmdArgsParser.g:513:1: entryRuleIncDir returns [String current=null] : iv_ruleIncDir= ruleIncDir EOF ;
    public final String entryRuleIncDir() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIncDir = null;


        try {
            // InternalCmdArgsParser.g:514:1: (iv_ruleIncDir= ruleIncDir EOF )
            // InternalCmdArgsParser.g:515:2: iv_ruleIncDir= ruleIncDir EOF
            {
             newCompositeNode(grammarAccess.getIncDirRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIncDir=ruleIncDir();

            state._fsp--;

             current =iv_ruleIncDir.getText(); 
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
    // $ANTLR end "entryRuleIncDir"


    // $ANTLR start "ruleIncDir"
    // InternalCmdArgsParser.g:522:1: ruleIncDir returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_KW_INCDIR_0= RULE_KW_INCDIR ;
    public final AntlrDatatypeRuleToken ruleIncDir() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_KW_INCDIR_0=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:526:6: (this_KW_INCDIR_0= RULE_KW_INCDIR )
            // InternalCmdArgsParser.g:527:5: this_KW_INCDIR_0= RULE_KW_INCDIR
            {
            this_KW_INCDIR_0=(Token)match(input,RULE_KW_INCDIR,FOLLOW_2); 

            		current.merge(this_KW_INCDIR_0);
                
             
                newLeafNode(this_KW_INCDIR_0, grammarAccess.getIncDirAccess().getKW_INCDIRTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleIncDir"


    // $ANTLR start "entryRuleIncSys"
    // InternalCmdArgsParser.g:542:1: entryRuleIncSys returns [String current=null] : iv_ruleIncSys= ruleIncSys EOF ;
    public final String entryRuleIncSys() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIncSys = null;


        try {
            // InternalCmdArgsParser.g:543:1: (iv_ruleIncSys= ruleIncSys EOF )
            // InternalCmdArgsParser.g:544:2: iv_ruleIncSys= ruleIncSys EOF
            {
             newCompositeNode(grammarAccess.getIncSysRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIncSys=ruleIncSys();

            state._fsp--;

             current =iv_ruleIncSys.getText(); 
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
    // $ANTLR end "entryRuleIncSys"


    // $ANTLR start "ruleIncSys"
    // InternalCmdArgsParser.g:551:1: ruleIncSys returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS ) ;
    public final AntlrDatatypeRuleToken ruleIncSys() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_MINUS_0=null;
        Token this_KW_INCSYS_1=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:555:6: ( (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS ) )
            // InternalCmdArgsParser.g:556:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS )
            {
            // InternalCmdArgsParser.g:556:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS )
            // InternalCmdArgsParser.g:556:6: this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS
            {
            this_SKW_MINUS_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_12); 

            		current.merge(this_SKW_MINUS_0);
                
             
                newLeafNode(this_SKW_MINUS_0, grammarAccess.getIncSysAccess().getSKW_MINUSTerminalRuleCall_0()); 
                
            this_KW_INCSYS_1=(Token)match(input,RULE_KW_INCSYS,FOLLOW_2); 

            		current.merge(this_KW_INCSYS_1);
                
             
                newLeafNode(this_KW_INCSYS_1, grammarAccess.getIncSysAccess().getKW_INCSYSTerminalRuleCall_1()); 
                

            }


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
    // $ANTLR end "ruleIncSys"


    // $ANTLR start "entryRuleNoStdInc"
    // InternalCmdArgsParser.g:578:1: entryRuleNoStdInc returns [String current=null] : iv_ruleNoStdInc= ruleNoStdInc EOF ;
    public final String entryRuleNoStdInc() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoStdInc = null;


        try {
            // InternalCmdArgsParser.g:579:1: (iv_ruleNoStdInc= ruleNoStdInc EOF )
            // InternalCmdArgsParser.g:580:2: iv_ruleNoStdInc= ruleNoStdInc EOF
            {
             newCompositeNode(grammarAccess.getNoStdIncRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNoStdInc=ruleNoStdInc();

            state._fsp--;

             current =iv_ruleNoStdInc.getText(); 
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
    // $ANTLR end "entryRuleNoStdInc"


    // $ANTLR start "ruleNoStdInc"
    // InternalCmdArgsParser.g:587:1: ruleNoStdInc returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC ) ;
    public final AntlrDatatypeRuleToken ruleNoStdInc() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_MINUS_0=null;
        Token this_KW_NOSTDINC_1=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:591:6: ( (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC ) )
            // InternalCmdArgsParser.g:592:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC )
            {
            // InternalCmdArgsParser.g:592:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC )
            // InternalCmdArgsParser.g:592:6: this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC
            {
            this_SKW_MINUS_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_13); 

            		current.merge(this_SKW_MINUS_0);
                
             
                newLeafNode(this_SKW_MINUS_0, grammarAccess.getNoStdIncAccess().getSKW_MINUSTerminalRuleCall_0()); 
                
            this_KW_NOSTDINC_1=(Token)match(input,RULE_KW_NOSTDINC,FOLLOW_2); 

            		current.merge(this_KW_NOSTDINC_1);
                
             
                newLeafNode(this_KW_NOSTDINC_1, grammarAccess.getNoStdIncAccess().getKW_NOSTDINCTerminalRuleCall_1()); 
                

            }


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
    // $ANTLR end "ruleNoStdInc"


    // $ANTLR start "entryRuleInclude"
    // InternalCmdArgsParser.g:614:1: entryRuleInclude returns [String current=null] : iv_ruleInclude= ruleInclude EOF ;
    public final String entryRuleInclude() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInclude = null;


        try {
            // InternalCmdArgsParser.g:615:1: (iv_ruleInclude= ruleInclude EOF )
            // InternalCmdArgsParser.g:616:2: iv_ruleInclude= ruleInclude EOF
            {
             newCompositeNode(grammarAccess.getIncludeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInclude=ruleInclude();

            state._fsp--;

             current =iv_ruleInclude.getText(); 
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
    // $ANTLR end "entryRuleInclude"


    // $ANTLR start "ruleInclude"
    // InternalCmdArgsParser.g:623:1: ruleInclude returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCLUDE_1= RULE_KW_INCLUDE ) ;
    public final AntlrDatatypeRuleToken ruleInclude() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_MINUS_0=null;
        Token this_KW_INCLUDE_1=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:627:6: ( (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCLUDE_1= RULE_KW_INCLUDE ) )
            // InternalCmdArgsParser.g:628:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCLUDE_1= RULE_KW_INCLUDE )
            {
            // InternalCmdArgsParser.g:628:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCLUDE_1= RULE_KW_INCLUDE )
            // InternalCmdArgsParser.g:628:6: this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCLUDE_1= RULE_KW_INCLUDE
            {
            this_SKW_MINUS_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_14); 

            		current.merge(this_SKW_MINUS_0);
                
             
                newLeafNode(this_SKW_MINUS_0, grammarAccess.getIncludeAccess().getSKW_MINUSTerminalRuleCall_0()); 
                
            this_KW_INCLUDE_1=(Token)match(input,RULE_KW_INCLUDE,FOLLOW_2); 

            		current.merge(this_KW_INCLUDE_1);
                
             
                newLeafNode(this_KW_INCLUDE_1, grammarAccess.getIncludeAccess().getKW_INCLUDETerminalRuleCall_1()); 
                

            }


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
    // $ANTLR end "ruleInclude"


    // $ANTLR start "entryRuleOutput"
    // InternalCmdArgsParser.g:650:1: entryRuleOutput returns [String current=null] : iv_ruleOutput= ruleOutput EOF ;
    public final String entryRuleOutput() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOutput = null;


        try {
            // InternalCmdArgsParser.g:651:1: (iv_ruleOutput= ruleOutput EOF )
            // InternalCmdArgsParser.g:652:2: iv_ruleOutput= ruleOutput EOF
            {
             newCompositeNode(grammarAccess.getOutputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutput=ruleOutput();

            state._fsp--;

             current =iv_ruleOutput.getText(); 
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
    // $ANTLR end "entryRuleOutput"


    // $ANTLR start "ruleOutput"
    // InternalCmdArgsParser.g:659:1: ruleOutput returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_KW_OUTPUT_0= RULE_KW_OUTPUT ;
    public final AntlrDatatypeRuleToken ruleOutput() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_KW_OUTPUT_0=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:663:6: (this_KW_OUTPUT_0= RULE_KW_OUTPUT )
            // InternalCmdArgsParser.g:664:5: this_KW_OUTPUT_0= RULE_KW_OUTPUT
            {
            this_KW_OUTPUT_0=(Token)match(input,RULE_KW_OUTPUT,FOLLOW_2); 

            		current.merge(this_KW_OUTPUT_0);
                
             
                newLeafNode(this_KW_OUTPUT_0, grammarAccess.getOutputAccess().getKW_OUTPUTTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleOutput"


    // $ANTLR start "entryRuleLang"
    // InternalCmdArgsParser.g:679:1: entryRuleLang returns [String current=null] : iv_ruleLang= ruleLang EOF ;
    public final String entryRuleLang() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLang = null;


        try {
            // InternalCmdArgsParser.g:680:1: (iv_ruleLang= ruleLang EOF )
            // InternalCmdArgsParser.g:681:2: iv_ruleLang= ruleLang EOF
            {
             newCompositeNode(grammarAccess.getLangRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLang=ruleLang();

            state._fsp--;

             current =iv_ruleLang.getText(); 
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
    // $ANTLR end "entryRuleLang"


    // $ANTLR start "ruleLang"
    // InternalCmdArgsParser.g:688:1: ruleLang returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_KW_LANG_0= RULE_KW_LANG ;
    public final AntlrDatatypeRuleToken ruleLang() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_KW_LANG_0=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:692:6: (this_KW_LANG_0= RULE_KW_LANG )
            // InternalCmdArgsParser.g:693:5: this_KW_LANG_0= RULE_KW_LANG
            {
            this_KW_LANG_0=(Token)match(input,RULE_KW_LANG,FOLLOW_2); 

            		current.merge(this_KW_LANG_0);
                
             
                newLeafNode(this_KW_LANG_0, grammarAccess.getLangAccess().getKW_LANGTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleLang"


    // $ANTLR start "entryRuleMacro"
    // InternalCmdArgsParser.g:708:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // InternalCmdArgsParser.g:709:2: (iv_ruleMacro= ruleMacro EOF )
            // InternalCmdArgsParser.g:710:2: iv_ruleMacro= ruleMacro EOF
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
    // InternalCmdArgsParser.g:717:1: ruleMacro returns [EObject current=null] : (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro ) ;
    public final EObject ruleMacro() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleMacro_0 = null;

        EObject this_ObjectMacro_1 = null;

        EObject this_FunctionMacro_2 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:720:28: ( (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro ) )
            // InternalCmdArgsParser.g:721:1: (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro )
            {
            // InternalCmdArgsParser.g:721:1: (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case RULE_SKW_LEFTPAREN:
                    {
                    alt12=3;
                    }
                    break;
                case EOF:
                case RULE_NEWLINE:
                case RULE_WS:
                    {
                    alt12=1;
                    }
                    break;
                case RULE_SKW_ASSIGN:
                    {
                    alt12=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalCmdArgsParser.g:722:5: this_SimpleMacro_0= ruleSimpleMacro
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
                    // InternalCmdArgsParser.g:732:5: this_ObjectMacro_1= ruleObjectMacro
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
                    // InternalCmdArgsParser.g:742:5: this_FunctionMacro_2= ruleFunctionMacro
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
    // InternalCmdArgsParser.g:758:1: entryRuleSimpleMacro returns [EObject current=null] : iv_ruleSimpleMacro= ruleSimpleMacro EOF ;
    public final EObject entryRuleSimpleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleMacro = null;


        try {
            // InternalCmdArgsParser.g:759:2: (iv_ruleSimpleMacro= ruleSimpleMacro EOF )
            // InternalCmdArgsParser.g:760:2: iv_ruleSimpleMacro= ruleSimpleMacro EOF
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
    // InternalCmdArgsParser.g:767:1: ruleSimpleMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleSimpleMacro() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:770:28: ( ( () ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // InternalCmdArgsParser.g:771:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // InternalCmdArgsParser.g:771:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) )
            // InternalCmdArgsParser.g:771:2: () ( (lv_name_1_0= ruleIdentifier ) )
            {
            // InternalCmdArgsParser.g:771:2: ()
            // InternalCmdArgsParser.g:772:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSimpleMacroAccess().getSimpleMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:777:2: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalCmdArgsParser.g:778:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalCmdArgsParser.g:778:1: (lv_name_1_0= ruleIdentifier )
            // InternalCmdArgsParser.g:779:3: lv_name_1_0= ruleIdentifier
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
    // InternalCmdArgsParser.g:803:1: entryRuleObjectMacro returns [EObject current=null] : iv_ruleObjectMacro= ruleObjectMacro EOF ;
    public final EObject entryRuleObjectMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectMacro = null;


        try {
            // InternalCmdArgsParser.g:804:2: (iv_ruleObjectMacro= ruleObjectMacro EOF )
            // InternalCmdArgsParser.g:805:2: iv_ruleObjectMacro= ruleObjectMacro EOF
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
    // InternalCmdArgsParser.g:812:1: ruleObjectMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) ) ;
    public final EObject ruleObjectMacro() throws RecognitionException {
        EObject current = null;

        Token this_SKW_ASSIGN_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:815:28: ( ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) ) )
            // InternalCmdArgsParser.g:816:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) )
            {
            // InternalCmdArgsParser.g:816:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) )
            // InternalCmdArgsParser.g:816:2: () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) )
            {
            // InternalCmdArgsParser.g:816:2: ()
            // InternalCmdArgsParser.g:817:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getObjectMacroAccess().getObjectMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:822:2: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalCmdArgsParser.g:823:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalCmdArgsParser.g:823:1: (lv_name_1_0= ruleIdentifier )
            // InternalCmdArgsParser.g:824:3: lv_name_1_0= ruleIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getObjectMacroAccess().getNameIdentifierParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_15);
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

            this_SKW_ASSIGN_2=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_16); 
             
                newLeafNode(this_SKW_ASSIGN_2, grammarAccess.getObjectMacroAccess().getSKW_ASSIGNTerminalRuleCall_2()); 
                
            // InternalCmdArgsParser.g:844:1: ( (lv_value_3_0= ruleMyCode ) )
            // InternalCmdArgsParser.g:845:1: (lv_value_3_0= ruleMyCode )
            {
            // InternalCmdArgsParser.g:845:1: (lv_value_3_0= ruleMyCode )
            // InternalCmdArgsParser.g:846:3: lv_value_3_0= ruleMyCode
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
    // InternalCmdArgsParser.g:870:1: entryRuleFunctionMacro returns [EObject current=null] : iv_ruleFunctionMacro= ruleFunctionMacro EOF ;
    public final EObject entryRuleFunctionMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionMacro = null;


        try {
            // InternalCmdArgsParser.g:871:2: (iv_ruleFunctionMacro= ruleFunctionMacro EOF )
            // InternalCmdArgsParser.g:872:2: iv_ruleFunctionMacro= ruleFunctionMacro EOF
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
    // InternalCmdArgsParser.g:879:1: ruleFunctionMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) ) ;
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
            
        try {
            // InternalCmdArgsParser.g:882:28: ( ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) ) )
            // InternalCmdArgsParser.g:883:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) )
            {
            // InternalCmdArgsParser.g:883:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) )
            // InternalCmdArgsParser.g:883:2: () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) )
            {
            // InternalCmdArgsParser.g:883:2: ()
            // InternalCmdArgsParser.g:884:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFunctionMacroAccess().getFunctionMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:889:2: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalCmdArgsParser.g:890:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalCmdArgsParser.g:890:1: (lv_name_1_0= ruleIdentifier )
            // InternalCmdArgsParser.g:891:3: lv_name_1_0= ruleIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getNameIdentifierParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_17);
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

            this_SKW_LEFTPAREN_2=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_18); 
             
                newLeafNode(this_SKW_LEFTPAREN_2, grammarAccess.getFunctionMacroAccess().getSKW_LEFTPARENTerminalRuleCall_2()); 
                
            // InternalCmdArgsParser.g:911:1: ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalCmdArgsParser.g:911:2: ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )*
                    {
                    // InternalCmdArgsParser.g:911:2: ( (lv_params_3_0= ruleIdentifier ) )
                    // InternalCmdArgsParser.g:912:1: (lv_params_3_0= ruleIdentifier )
                    {
                    // InternalCmdArgsParser.g:912:1: (lv_params_3_0= ruleIdentifier )
                    // InternalCmdArgsParser.g:913:3: lv_params_3_0= ruleIdentifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getParamsIdentifierParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_19);
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

                    // InternalCmdArgsParser.g:929:2: (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_SKW_COMMA) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:929:3: this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) )
                    	    {
                    	    this_SKW_COMMA_4=(Token)match(input,RULE_SKW_COMMA,FOLLOW_7); 
                    	     
                    	        newLeafNode(this_SKW_COMMA_4, grammarAccess.getFunctionMacroAccess().getSKW_COMMATerminalRuleCall_3_1_0()); 
                    	        
                    	    // InternalCmdArgsParser.g:933:1: ( (lv_params_5_0= ruleIdentifier ) )
                    	    // InternalCmdArgsParser.g:934:1: (lv_params_5_0= ruleIdentifier )
                    	    {
                    	    // InternalCmdArgsParser.g:934:1: (lv_params_5_0= ruleIdentifier )
                    	    // InternalCmdArgsParser.g:935:3: lv_params_5_0= ruleIdentifier
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getParamsIdentifierParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_19);
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
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            this_SKW_RIGHTPAREN_6=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_15); 
             
                newLeafNode(this_SKW_RIGHTPAREN_6, grammarAccess.getFunctionMacroAccess().getSKW_RIGHTPARENTerminalRuleCall_4()); 
                
            this_SKW_ASSIGN_7=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_16); 
             
                newLeafNode(this_SKW_ASSIGN_7, grammarAccess.getFunctionMacroAccess().getSKW_ASSIGNTerminalRuleCall_5()); 
                
            // InternalCmdArgsParser.g:959:1: ( (lv_value_8_0= ruleMyCode ) )
            // InternalCmdArgsParser.g:960:1: (lv_value_8_0= ruleMyCode )
            {
            // InternalCmdArgsParser.g:960:1: (lv_value_8_0= ruleMyCode )
            // InternalCmdArgsParser.g:961:3: lv_value_8_0= ruleMyCode
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


    // $ANTLR start "entryRulePathCmd"
    // InternalCmdArgsParser.g:985:1: entryRulePathCmd returns [EObject current=null] : iv_rulePathCmd= rulePathCmd EOF ;
    public final EObject entryRulePathCmd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathCmd = null;


        try {
            // InternalCmdArgsParser.g:986:2: (iv_rulePathCmd= rulePathCmd EOF )
            // InternalCmdArgsParser.g:987:2: iv_rulePathCmd= rulePathCmd EOF
            {
             newCompositeNode(grammarAccess.getPathCmdRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathCmd=rulePathCmd();

            state._fsp--;

             current =iv_rulePathCmd; 
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
    // $ANTLR end "entryRulePathCmd"


    // $ANTLR start "rulePathCmd"
    // InternalCmdArgsParser.g:994:1: rulePathCmd returns [EObject current=null] : ( (lv_path_0_0= rulePath ) ) ;
    public final EObject rulePathCmd() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:997:28: ( ( (lv_path_0_0= rulePath ) ) )
            // InternalCmdArgsParser.g:998:1: ( (lv_path_0_0= rulePath ) )
            {
            // InternalCmdArgsParser.g:998:1: ( (lv_path_0_0= rulePath ) )
            // InternalCmdArgsParser.g:999:1: (lv_path_0_0= rulePath )
            {
            // InternalCmdArgsParser.g:999:1: (lv_path_0_0= rulePath )
            // InternalCmdArgsParser.g:1000:3: lv_path_0_0= rulePath
            {
             
            	        newCompositeNode(grammarAccess.getPathCmdAccess().getPathPathParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_path_0_0=rulePath();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPathCmdRule());
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
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathCmd"


    // $ANTLR start "entryRuleIdentifier"
    // InternalCmdArgsParser.g:1024:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalCmdArgsParser.g:1025:1: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalCmdArgsParser.g:1026:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalCmdArgsParser.g:1033:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1037:6: (this_ID_0= RULE_ID )
            // InternalCmdArgsParser.g:1038:5: this_ID_0= RULE_ID
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
    // InternalCmdArgsParser.g:1053:1: entryRuleMyCode returns [String current=null] : iv_ruleMyCode= ruleMyCode EOF ;
    public final String entryRuleMyCode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCode = null;


        try {
            // InternalCmdArgsParser.g:1054:1: (iv_ruleMyCode= ruleMyCode EOF )
            // InternalCmdArgsParser.g:1055:2: iv_ruleMyCode= ruleMyCode EOF
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
    // InternalCmdArgsParser.g:1062:1: ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MyCodeChar_0= ruleMyCodeChar )+ ;
    public final AntlrDatatypeRuleToken ruleMyCode() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_MyCodeChar_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1066:6: ( (this_MyCodeChar_0= ruleMyCodeChar )+ )
            // InternalCmdArgsParser.g:1067:1: (this_MyCodeChar_0= ruleMyCodeChar )+
            {
            // InternalCmdArgsParser.g:1067:1: (this_MyCodeChar_0= ruleMyCodeChar )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=RULE_SKW_MINUS && LA15_0<=RULE_KW_INCLUDE)||(LA15_0>=RULE_ID && LA15_0<=RULE_STRING)||LA15_0==RULE_ANY_OTHER) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1068:5: this_MyCodeChar_0= ruleMyCodeChar
            	    {
            	     
            	            newCompositeNode(grammarAccess.getMyCodeAccess().getMyCodeCharParserRuleCall()); 
            	        
            	    pushFollow(FOLLOW_20);
            	    this_MyCodeChar_0=ruleMyCodeChar();

            	    state._fsp--;


            	    		current.merge(this_MyCodeChar_0);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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


    // $ANTLR start "entryRuleMyCodeChar"
    // InternalCmdArgsParser.g:1086:1: entryRuleMyCodeChar returns [String current=null] : iv_ruleMyCodeChar= ruleMyCodeChar EOF ;
    public final String entryRuleMyCodeChar() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCodeChar = null;


        try {
            // InternalCmdArgsParser.g:1087:1: (iv_ruleMyCodeChar= ruleMyCodeChar EOF )
            // InternalCmdArgsParser.g:1088:2: iv_ruleMyCodeChar= ruleMyCodeChar EOF
            {
             newCompositeNode(grammarAccess.getMyCodeCharRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMyCodeChar=ruleMyCodeChar();

            state._fsp--;

             current =iv_ruleMyCodeChar.getText(); 
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
    // $ANTLR end "entryRuleMyCodeChar"


    // $ANTLR start "ruleMyCodeChar"
    // InternalCmdArgsParser.g:1095:1: ruleMyCodeChar returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_PathChar_0= rulePathChar | this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN ) ;
    public final AntlrDatatypeRuleToken ruleMyCodeChar() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_LEFTPAREN_1=null;
        Token this_SKW_RIGHTPAREN_2=null;
        AntlrDatatypeRuleToken this_PathChar_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1099:6: ( (this_PathChar_0= rulePathChar | this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN ) )
            // InternalCmdArgsParser.g:1100:1: (this_PathChar_0= rulePathChar | this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN )
            {
            // InternalCmdArgsParser.g:1100:1: (this_PathChar_0= rulePathChar | this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN )
            int alt16=3;
            switch ( input.LA(1) ) {
            case RULE_SKW_MINUS:
            case RULE_SKW_ASSIGN:
            case RULE_SKW_COMMA:
            case RULE_KW_DEFINE:
            case RULE_KW_INCDIR:
            case RULE_KW_OUTPUT:
            case RULE_KW_LANG:
            case RULE_KW_NOSTDINC:
            case RULE_KW_INCSYS:
            case RULE_KW_INCLUDE:
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
            case RULE_ANY_OTHER:
                {
                alt16=1;
                }
                break;
            case RULE_SKW_LEFTPAREN:
                {
                alt16=2;
                }
                break;
            case RULE_SKW_RIGHTPAREN:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalCmdArgsParser.g:1101:5: this_PathChar_0= rulePathChar
                    {
                     
                            newCompositeNode(grammarAccess.getMyCodeCharAccess().getPathCharParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_PathChar_0=rulePathChar();

                    state._fsp--;


                    		current.merge(this_PathChar_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:1112:10: this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN
                    {
                    this_SKW_LEFTPAREN_1=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_2); 

                    		current.merge(this_SKW_LEFTPAREN_1);
                        
                     
                        newLeafNode(this_SKW_LEFTPAREN_1, grammarAccess.getMyCodeCharAccess().getSKW_LEFTPARENTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalCmdArgsParser.g:1120:10: this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN
                    {
                    this_SKW_RIGHTPAREN_2=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_2); 

                    		current.merge(this_SKW_RIGHTPAREN_2);
                        
                     
                        newLeafNode(this_SKW_RIGHTPAREN_2, grammarAccess.getMyCodeCharAccess().getSKW_RIGHTPARENTerminalRuleCall_2()); 
                        

                    }
                    break;

            }


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
    // $ANTLR end "ruleMyCodeChar"


    // $ANTLR start "entryRulePath"
    // InternalCmdArgsParser.g:1135:1: entryRulePath returns [String current=null] : iv_rulePath= rulePath EOF ;
    public final String entryRulePath() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePath = null;


        try {
            // InternalCmdArgsParser.g:1136:1: (iv_rulePath= rulePath EOF )
            // InternalCmdArgsParser.g:1137:2: iv_rulePath= rulePath EOF
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
    // InternalCmdArgsParser.g:1144:1: rulePath returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_PathChar_0= rulePathChar )+ ;
    public final AntlrDatatypeRuleToken rulePath() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_PathChar_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1148:6: ( (this_PathChar_0= rulePathChar )+ )
            // InternalCmdArgsParser.g:1149:1: (this_PathChar_0= rulePathChar )+
            {
            // InternalCmdArgsParser.g:1149:1: (this_PathChar_0= rulePathChar )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=RULE_SKW_MINUS && LA17_0<=RULE_SKW_ASSIGN)||(LA17_0>=RULE_SKW_COMMA && LA17_0<=RULE_KW_INCLUDE)||(LA17_0>=RULE_ID && LA17_0<=RULE_STRING)||LA17_0==RULE_ANY_OTHER) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1150:5: this_PathChar_0= rulePathChar
            	    {
            	     
            	            newCompositeNode(grammarAccess.getPathAccess().getPathCharParserRuleCall()); 
            	        
            	    pushFollow(FOLLOW_21);
            	    this_PathChar_0=rulePathChar();

            	    state._fsp--;


            	    		current.merge(this_PathChar_0);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
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


    // $ANTLR start "entryRulePathChar"
    // InternalCmdArgsParser.g:1168:1: entryRulePathChar returns [String current=null] : iv_rulePathChar= rulePathChar EOF ;
    public final String entryRulePathChar() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePathChar = null;


        try {
            // InternalCmdArgsParser.g:1169:1: (iv_rulePathChar= rulePathChar EOF )
            // InternalCmdArgsParser.g:1170:2: iv_rulePathChar= rulePathChar EOF
            {
             newCompositeNode(grammarAccess.getPathCharRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathChar=rulePathChar();

            state._fsp--;

             current =iv_rulePathChar.getText(); 
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
    // $ANTLR end "entryRulePathChar"


    // $ANTLR start "rulePathChar"
    // InternalCmdArgsParser.g:1177:1: rulePathChar returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_OptionChar_0= ruleOptionChar | this_NonOptionChar_1= ruleNonOptionChar ) ;
    public final AntlrDatatypeRuleToken rulePathChar() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_OptionChar_0 = null;

        AntlrDatatypeRuleToken this_NonOptionChar_1 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1181:6: ( (this_OptionChar_0= ruleOptionChar | this_NonOptionChar_1= ruleNonOptionChar ) )
            // InternalCmdArgsParser.g:1182:1: (this_OptionChar_0= ruleOptionChar | this_NonOptionChar_1= ruleNonOptionChar )
            {
            // InternalCmdArgsParser.g:1182:1: (this_OptionChar_0= ruleOptionChar | this_NonOptionChar_1= ruleNonOptionChar )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_SKW_MINUS||(LA18_0>=RULE_KW_DEFINE && LA18_0<=RULE_KW_INCLUDE)) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_SKW_ASSIGN||LA18_0==RULE_SKW_COMMA||(LA18_0>=RULE_ID && LA18_0<=RULE_STRING)||LA18_0==RULE_ANY_OTHER) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalCmdArgsParser.g:1183:5: this_OptionChar_0= ruleOptionChar
                    {
                     
                            newCompositeNode(grammarAccess.getPathCharAccess().getOptionCharParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_OptionChar_0=ruleOptionChar();

                    state._fsp--;


                    		current.merge(this_OptionChar_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:1195:5: this_NonOptionChar_1= ruleNonOptionChar
                    {
                     
                            newCompositeNode(grammarAccess.getPathCharAccess().getNonOptionCharParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_NonOptionChar_1=ruleNonOptionChar();

                    state._fsp--;


                    		current.merge(this_NonOptionChar_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


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
    // $ANTLR end "rulePathChar"


    // $ANTLR start "entryRuleOption"
    // InternalCmdArgsParser.g:1213:1: entryRuleOption returns [String current=null] : iv_ruleOption= ruleOption EOF ;
    public final String entryRuleOption() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOption = null;


        try {
            // InternalCmdArgsParser.g:1214:1: (iv_ruleOption= ruleOption EOF )
            // InternalCmdArgsParser.g:1215:2: iv_ruleOption= ruleOption EOF
            {
             newCompositeNode(grammarAccess.getOptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOption=ruleOption();

            state._fsp--;

             current =iv_ruleOption.getText(); 
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
    // $ANTLR end "entryRuleOption"


    // $ANTLR start "ruleOption"
    // InternalCmdArgsParser.g:1222:1: ruleOption returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NonOptionChar_0= ruleNonOptionChar (this_OptionChar_1= ruleOptionChar | this_NonOptionChar_2= ruleNonOptionChar )* ) ;
    public final AntlrDatatypeRuleToken ruleOption() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_NonOptionChar_0 = null;

        AntlrDatatypeRuleToken this_OptionChar_1 = null;

        AntlrDatatypeRuleToken this_NonOptionChar_2 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1226:6: ( (this_NonOptionChar_0= ruleNonOptionChar (this_OptionChar_1= ruleOptionChar | this_NonOptionChar_2= ruleNonOptionChar )* ) )
            // InternalCmdArgsParser.g:1227:1: (this_NonOptionChar_0= ruleNonOptionChar (this_OptionChar_1= ruleOptionChar | this_NonOptionChar_2= ruleNonOptionChar )* )
            {
            // InternalCmdArgsParser.g:1227:1: (this_NonOptionChar_0= ruleNonOptionChar (this_OptionChar_1= ruleOptionChar | this_NonOptionChar_2= ruleNonOptionChar )* )
            // InternalCmdArgsParser.g:1228:5: this_NonOptionChar_0= ruleNonOptionChar (this_OptionChar_1= ruleOptionChar | this_NonOptionChar_2= ruleNonOptionChar )*
            {
             
                    newCompositeNode(grammarAccess.getOptionAccess().getNonOptionCharParserRuleCall_0()); 
                
            pushFollow(FOLLOW_21);
            this_NonOptionChar_0=ruleNonOptionChar();

            state._fsp--;


            		current.merge(this_NonOptionChar_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalCmdArgsParser.g:1238:1: (this_OptionChar_1= ruleOptionChar | this_NonOptionChar_2= ruleNonOptionChar )*
            loop19:
            do {
                int alt19=3;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_SKW_MINUS||(LA19_0>=RULE_KW_DEFINE && LA19_0<=RULE_KW_INCLUDE)) ) {
                    alt19=1;
                }
                else if ( (LA19_0==RULE_SKW_ASSIGN||LA19_0==RULE_SKW_COMMA||(LA19_0>=RULE_ID && LA19_0<=RULE_STRING)||LA19_0==RULE_ANY_OTHER) ) {
                    alt19=2;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1239:5: this_OptionChar_1= ruleOptionChar
            	    {
            	     
            	            newCompositeNode(grammarAccess.getOptionAccess().getOptionCharParserRuleCall_1_0()); 
            	        
            	    pushFollow(FOLLOW_21);
            	    this_OptionChar_1=ruleOptionChar();

            	    state._fsp--;


            	    		current.merge(this_OptionChar_1);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;
            	case 2 :
            	    // InternalCmdArgsParser.g:1251:5: this_NonOptionChar_2= ruleNonOptionChar
            	    {
            	     
            	            newCompositeNode(grammarAccess.getOptionAccess().getNonOptionCharParserRuleCall_1_1()); 
            	        
            	    pushFollow(FOLLOW_21);
            	    this_NonOptionChar_2=ruleNonOptionChar();

            	    state._fsp--;


            	    		current.merge(this_NonOptionChar_2);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


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
    // $ANTLR end "ruleOption"


    // $ANTLR start "entryRuleNonOptionChar"
    // InternalCmdArgsParser.g:1269:1: entryRuleNonOptionChar returns [String current=null] : iv_ruleNonOptionChar= ruleNonOptionChar EOF ;
    public final String entryRuleNonOptionChar() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNonOptionChar = null;


        try {
            // InternalCmdArgsParser.g:1270:1: (iv_ruleNonOptionChar= ruleNonOptionChar EOF )
            // InternalCmdArgsParser.g:1271:2: iv_ruleNonOptionChar= ruleNonOptionChar EOF
            {
             newCompositeNode(grammarAccess.getNonOptionCharRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNonOptionChar=ruleNonOptionChar();

            state._fsp--;

             current =iv_ruleNonOptionChar.getText(); 
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
    // $ANTLR end "entryRuleNonOptionChar"


    // $ANTLR start "ruleNonOptionChar"
    // InternalCmdArgsParser.g:1278:1: ruleNonOptionChar returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_SKW_ASSIGN_3= RULE_SKW_ASSIGN | this_SKW_COMMA_4= RULE_SKW_COMMA | this_ANY_OTHER_5= RULE_ANY_OTHER ) ;
    public final AntlrDatatypeRuleToken ruleNonOptionChar() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_INT_1=null;
        Token this_STRING_2=null;
        Token this_SKW_ASSIGN_3=null;
        Token this_SKW_COMMA_4=null;
        Token this_ANY_OTHER_5=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1282:6: ( (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_SKW_ASSIGN_3= RULE_SKW_ASSIGN | this_SKW_COMMA_4= RULE_SKW_COMMA | this_ANY_OTHER_5= RULE_ANY_OTHER ) )
            // InternalCmdArgsParser.g:1283:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_SKW_ASSIGN_3= RULE_SKW_ASSIGN | this_SKW_COMMA_4= RULE_SKW_COMMA | this_ANY_OTHER_5= RULE_ANY_OTHER )
            {
            // InternalCmdArgsParser.g:1283:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_SKW_ASSIGN_3= RULE_SKW_ASSIGN | this_SKW_COMMA_4= RULE_SKW_COMMA | this_ANY_OTHER_5= RULE_ANY_OTHER )
            int alt20=6;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt20=1;
                }
                break;
            case RULE_INT:
                {
                alt20=2;
                }
                break;
            case RULE_STRING:
                {
                alt20=3;
                }
                break;
            case RULE_SKW_ASSIGN:
                {
                alt20=4;
                }
                break;
            case RULE_SKW_COMMA:
                {
                alt20=5;
                }
                break;
            case RULE_ANY_OTHER:
                {
                alt20=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalCmdArgsParser.g:1283:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getNonOptionCharAccess().getIDTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:1291:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getNonOptionCharAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalCmdArgsParser.g:1299:10: this_STRING_2= RULE_STRING
                    {
                    this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    		current.merge(this_STRING_2);
                        
                     
                        newLeafNode(this_STRING_2, grammarAccess.getNonOptionCharAccess().getSTRINGTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalCmdArgsParser.g:1307:10: this_SKW_ASSIGN_3= RULE_SKW_ASSIGN
                    {
                    this_SKW_ASSIGN_3=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_2); 

                    		current.merge(this_SKW_ASSIGN_3);
                        
                     
                        newLeafNode(this_SKW_ASSIGN_3, grammarAccess.getNonOptionCharAccess().getSKW_ASSIGNTerminalRuleCall_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalCmdArgsParser.g:1315:10: this_SKW_COMMA_4= RULE_SKW_COMMA
                    {
                    this_SKW_COMMA_4=(Token)match(input,RULE_SKW_COMMA,FOLLOW_2); 

                    		current.merge(this_SKW_COMMA_4);
                        
                     
                        newLeafNode(this_SKW_COMMA_4, grammarAccess.getNonOptionCharAccess().getSKW_COMMATerminalRuleCall_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalCmdArgsParser.g:1323:10: this_ANY_OTHER_5= RULE_ANY_OTHER
                    {
                    this_ANY_OTHER_5=(Token)match(input,RULE_ANY_OTHER,FOLLOW_2); 

                    		current.merge(this_ANY_OTHER_5);
                        
                     
                        newLeafNode(this_ANY_OTHER_5, grammarAccess.getNonOptionCharAccess().getANY_OTHERTerminalRuleCall_5()); 
                        

                    }
                    break;

            }


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
    // $ANTLR end "ruleNonOptionChar"


    // $ANTLR start "entryRuleOptionChar"
    // InternalCmdArgsParser.g:1338:1: entryRuleOptionChar returns [String current=null] : iv_ruleOptionChar= ruleOptionChar EOF ;
    public final String entryRuleOptionChar() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOptionChar = null;


        try {
            // InternalCmdArgsParser.g:1339:1: (iv_ruleOptionChar= ruleOptionChar EOF )
            // InternalCmdArgsParser.g:1340:2: iv_ruleOptionChar= ruleOptionChar EOF
            {
             newCompositeNode(grammarAccess.getOptionCharRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOptionChar=ruleOptionChar();

            state._fsp--;

             current =iv_ruleOptionChar.getText(); 
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
    // $ANTLR end "entryRuleOptionChar"


    // $ANTLR start "ruleOptionChar"
    // InternalCmdArgsParser.g:1347:1: ruleOptionChar returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_MINUS_0= RULE_SKW_MINUS | this_KW_DEFINE_1= RULE_KW_DEFINE | this_KW_INCDIR_2= RULE_KW_INCDIR | this_KW_NOSTDINC_3= RULE_KW_NOSTDINC | this_KW_INCSYS_4= RULE_KW_INCSYS | this_KW_INCLUDE_5= RULE_KW_INCLUDE | this_KW_LANG_6= RULE_KW_LANG | this_KW_OUTPUT_7= RULE_KW_OUTPUT ) ;
    public final AntlrDatatypeRuleToken ruleOptionChar() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_MINUS_0=null;
        Token this_KW_DEFINE_1=null;
        Token this_KW_INCDIR_2=null;
        Token this_KW_NOSTDINC_3=null;
        Token this_KW_INCSYS_4=null;
        Token this_KW_INCLUDE_5=null;
        Token this_KW_LANG_6=null;
        Token this_KW_OUTPUT_7=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1351:6: ( (this_SKW_MINUS_0= RULE_SKW_MINUS | this_KW_DEFINE_1= RULE_KW_DEFINE | this_KW_INCDIR_2= RULE_KW_INCDIR | this_KW_NOSTDINC_3= RULE_KW_NOSTDINC | this_KW_INCSYS_4= RULE_KW_INCSYS | this_KW_INCLUDE_5= RULE_KW_INCLUDE | this_KW_LANG_6= RULE_KW_LANG | this_KW_OUTPUT_7= RULE_KW_OUTPUT ) )
            // InternalCmdArgsParser.g:1352:1: (this_SKW_MINUS_0= RULE_SKW_MINUS | this_KW_DEFINE_1= RULE_KW_DEFINE | this_KW_INCDIR_2= RULE_KW_INCDIR | this_KW_NOSTDINC_3= RULE_KW_NOSTDINC | this_KW_INCSYS_4= RULE_KW_INCSYS | this_KW_INCLUDE_5= RULE_KW_INCLUDE | this_KW_LANG_6= RULE_KW_LANG | this_KW_OUTPUT_7= RULE_KW_OUTPUT )
            {
            // InternalCmdArgsParser.g:1352:1: (this_SKW_MINUS_0= RULE_SKW_MINUS | this_KW_DEFINE_1= RULE_KW_DEFINE | this_KW_INCDIR_2= RULE_KW_INCDIR | this_KW_NOSTDINC_3= RULE_KW_NOSTDINC | this_KW_INCSYS_4= RULE_KW_INCSYS | this_KW_INCLUDE_5= RULE_KW_INCLUDE | this_KW_LANG_6= RULE_KW_LANG | this_KW_OUTPUT_7= RULE_KW_OUTPUT )
            int alt21=8;
            switch ( input.LA(1) ) {
            case RULE_SKW_MINUS:
                {
                alt21=1;
                }
                break;
            case RULE_KW_DEFINE:
                {
                alt21=2;
                }
                break;
            case RULE_KW_INCDIR:
                {
                alt21=3;
                }
                break;
            case RULE_KW_NOSTDINC:
                {
                alt21=4;
                }
                break;
            case RULE_KW_INCSYS:
                {
                alt21=5;
                }
                break;
            case RULE_KW_INCLUDE:
                {
                alt21=6;
                }
                break;
            case RULE_KW_LANG:
                {
                alt21=7;
                }
                break;
            case RULE_KW_OUTPUT:
                {
                alt21=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalCmdArgsParser.g:1352:6: this_SKW_MINUS_0= RULE_SKW_MINUS
                    {
                    this_SKW_MINUS_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_2); 

                    		current.merge(this_SKW_MINUS_0);
                        
                     
                        newLeafNode(this_SKW_MINUS_0, grammarAccess.getOptionCharAccess().getSKW_MINUSTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:1360:10: this_KW_DEFINE_1= RULE_KW_DEFINE
                    {
                    this_KW_DEFINE_1=(Token)match(input,RULE_KW_DEFINE,FOLLOW_2); 

                    		current.merge(this_KW_DEFINE_1);
                        
                     
                        newLeafNode(this_KW_DEFINE_1, grammarAccess.getOptionCharAccess().getKW_DEFINETerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalCmdArgsParser.g:1368:10: this_KW_INCDIR_2= RULE_KW_INCDIR
                    {
                    this_KW_INCDIR_2=(Token)match(input,RULE_KW_INCDIR,FOLLOW_2); 

                    		current.merge(this_KW_INCDIR_2);
                        
                     
                        newLeafNode(this_KW_INCDIR_2, grammarAccess.getOptionCharAccess().getKW_INCDIRTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalCmdArgsParser.g:1376:10: this_KW_NOSTDINC_3= RULE_KW_NOSTDINC
                    {
                    this_KW_NOSTDINC_3=(Token)match(input,RULE_KW_NOSTDINC,FOLLOW_2); 

                    		current.merge(this_KW_NOSTDINC_3);
                        
                     
                        newLeafNode(this_KW_NOSTDINC_3, grammarAccess.getOptionCharAccess().getKW_NOSTDINCTerminalRuleCall_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalCmdArgsParser.g:1384:10: this_KW_INCSYS_4= RULE_KW_INCSYS
                    {
                    this_KW_INCSYS_4=(Token)match(input,RULE_KW_INCSYS,FOLLOW_2); 

                    		current.merge(this_KW_INCSYS_4);
                        
                     
                        newLeafNode(this_KW_INCSYS_4, grammarAccess.getOptionCharAccess().getKW_INCSYSTerminalRuleCall_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalCmdArgsParser.g:1392:10: this_KW_INCLUDE_5= RULE_KW_INCLUDE
                    {
                    this_KW_INCLUDE_5=(Token)match(input,RULE_KW_INCLUDE,FOLLOW_2); 

                    		current.merge(this_KW_INCLUDE_5);
                        
                     
                        newLeafNode(this_KW_INCLUDE_5, grammarAccess.getOptionCharAccess().getKW_INCLUDETerminalRuleCall_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalCmdArgsParser.g:1400:10: this_KW_LANG_6= RULE_KW_LANG
                    {
                    this_KW_LANG_6=(Token)match(input,RULE_KW_LANG,FOLLOW_2); 

                    		current.merge(this_KW_LANG_6);
                        
                     
                        newLeafNode(this_KW_LANG_6, grammarAccess.getOptionCharAccess().getKW_LANGTerminalRuleCall_6()); 
                        

                    }
                    break;
                case 8 :
                    // InternalCmdArgsParser.g:1408:10: this_KW_OUTPUT_7= RULE_KW_OUTPUT
                    {
                    this_KW_OUTPUT_7=(Token)match(input,RULE_KW_OUTPUT,FOLLOW_2); 

                    		current.merge(this_KW_OUTPUT_7);
                        
                     
                        newLeafNode(this_KW_OUTPUT_7, grammarAccess.getOptionCharAccess().getKW_OUTPUTTerminalRuleCall_7()); 
                        

                    }
                    break;

            }


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
    // $ANTLR end "ruleOptionChar"

    // Delegated rules


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\13\uffff";
    static final String DFA11_eofS =
        "\3\uffff\1\7\7\uffff";
    static final String DFA11_minS =
        "\1\4\2\uffff\1\5\7\uffff";
    static final String DFA11_maxS =
        "\1\30\2\uffff\1\30\7\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\6\1\7\1\11\1\10\1\5\1\4\1\3";
    static final String DFA11_specialS =
        "\13\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\3\1\6\2\uffff\1\6\1\1\1\2\1\4\1\5\5\uffff\3\6\3\uffff\1\6",
            "",
            "",
            "\1\7\2\uffff\1\7\4\uffff\1\11\1\12\1\10\2\uffff\5\7\1\uffff\1\7",
            "",
            "",
            "",
            "",
            "",
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
            return "218:2: ( ( ruleDefine ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= ruleIncDir ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | ( ruleInclude (this_WS_10= RULE_WS )+ ( (lv_include_11_0= rulePathCmd ) ) ) | ( ruleOutput (this_WS_13= RULE_WS )+ ( (lv_out_14_0= rulePathCmd ) ) ) | ( ruleLang (this_WS_16= RULE_WS )+ ( (lv_lang_17_0= rulePathCmd ) ) ) | (this_SKW_MINUS_18= RULE_SKW_MINUS ( (lv_option_19_0= ruleOption ) )? ) | ( (lv_in_20_0= ruleOption ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000011C1F30L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000015C1F30L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000011CFF30L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000015CFF30L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000011C1F32L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000000011CFFF0L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000040080L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000000011CFFF2L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000000011CFF32L});

}