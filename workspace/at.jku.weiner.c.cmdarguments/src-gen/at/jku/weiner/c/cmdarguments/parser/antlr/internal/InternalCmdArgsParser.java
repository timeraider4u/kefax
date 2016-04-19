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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SKW_DOT", "RULE_SKW_DIV", "RULE_SKW_COLON", "RULE_SKW_MINUS", "RULE_SKW_ASSIGN", "RULE_SKW_LEFTPAREN", "RULE_SKW_RIGHTPAREN", "RULE_SKW_COMMA", "RULE_SKW_DOLLAR", "RULE_SKW_BACKSLASH", "RULE_KW_DEFINE", "RULE_KW_INCDIR", "RULE_KW_OUTPUT", "RULE_KW_LANG", "RULE_KW_NOSTDINC", "RULE_KW_INCSYS", "RULE_KW_INCLUDE", "RULE_ID_PART_1", "RULE_ID_PART_2", "RULE_ID", "RULE_LETTER", "RULE_INT", "RULE_DIGIT", "RULE_STRING2", "RULE_NEWLINE", "RULE_WS", "RULE_SKW_HASH", "RULE_LINE_BREAK", "RULE_LINE_COMMENT", "RULE_ANY_OTHER"
    };
    public static final int RULE_SKW_MINUS=7;
    public static final int RULE_ID=23;
    public static final int RULE_NEWLINE=28;
    public static final int RULE_ID_PART_1=21;
    public static final int RULE_KW_INCDIR=15;
    public static final int RULE_ID_PART_2=22;
    public static final int RULE_KW_OUTPUT=16;
    public static final int RULE_ANY_OTHER=33;
    public static final int RULE_SKW_DOLLAR=12;
    public static final int RULE_KW_NOSTDINC=18;
    public static final int RULE_SKW_DOT=4;
    public static final int RULE_SKW_DIV=5;
    public static final int RULE_LINE_BREAK=31;
    public static final int EOF=-1;
    public static final int RULE_LETTER=24;
    public static final int RULE_SKW_RIGHTPAREN=10;
    public static final int RULE_STRING2=27;
    public static final int RULE_KW_INCLUDE=20;
    public static final int RULE_KW_DEFINE=14;
    public static final int RULE_KW_LANG=17;
    public static final int RULE_KW_INCSYS=19;
    public static final int RULE_LINE_COMMENT=32;
    public static final int RULE_INT=25;
    public static final int RULE_SKW_BACKSLASH=13;
    public static final int RULE_SKW_COMMA=11;
    public static final int RULE_WS=29;
    public static final int RULE_DIGIT=26;
    public static final int RULE_SKW_COLON=6;
    public static final int RULE_SKW_LEFTPAREN=9;
    public static final int RULE_SKW_ASSIGN=8;
    public static final int RULE_SKW_HASH=30;

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
    // InternalCmdArgsParser.g:70:1: ruleModel returns [EObject current=null] : ( () ( ( (lv_lines_1_0= ruleCmdLine ) ) ( (this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleCmdLine ) ) )* )? (this_NEWLINE_4= RULE_NEWLINE )? ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_2=null;
        Token this_NEWLINE_4=null;
        EObject lv_lines_1_0 = null;

        EObject lv_lines_3_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:73:28: ( ( () ( ( (lv_lines_1_0= ruleCmdLine ) ) ( (this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleCmdLine ) ) )* )? (this_NEWLINE_4= RULE_NEWLINE )? ) )
            // InternalCmdArgsParser.g:74:1: ( () ( ( (lv_lines_1_0= ruleCmdLine ) ) ( (this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleCmdLine ) ) )* )? (this_NEWLINE_4= RULE_NEWLINE )? )
            {
            // InternalCmdArgsParser.g:74:1: ( () ( ( (lv_lines_1_0= ruleCmdLine ) ) ( (this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleCmdLine ) ) )* )? (this_NEWLINE_4= RULE_NEWLINE )? )
            // InternalCmdArgsParser.g:74:2: () ( ( (lv_lines_1_0= ruleCmdLine ) ) ( (this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleCmdLine ) ) )* )? (this_NEWLINE_4= RULE_NEWLINE )?
            {
            // InternalCmdArgsParser.g:74:2: ()
            // InternalCmdArgsParser.g:75:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:80:2: ( ( (lv_lines_1_0= ruleCmdLine ) ) ( (this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleCmdLine ) ) )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalCmdArgsParser.g:80:3: ( (lv_lines_1_0= ruleCmdLine ) ) ( (this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleCmdLine ) ) )*
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

                    // InternalCmdArgsParser.g:98:2: ( (this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleCmdLine ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_NEWLINE) ) {
                            int LA2_1 = input.LA(2);

                            if ( (LA2_1==RULE_ID||LA2_1==RULE_NEWLINE) ) {
                                alt2=1;
                            }


                        }
                        else if ( (LA2_0==RULE_ID) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:98:3: (this_NEWLINE_2= RULE_NEWLINE )* ( (lv_lines_3_0= ruleCmdLine ) )
                    	    {
                    	    // InternalCmdArgsParser.g:98:3: (this_NEWLINE_2= RULE_NEWLINE )*
                    	    loop1:
                    	    do {
                    	        int alt1=2;
                    	        int LA1_0 = input.LA(1);

                    	        if ( (LA1_0==RULE_NEWLINE) ) {
                    	            alt1=1;
                    	        }


                    	        switch (alt1) {
                    	    	case 1 :
                    	    	    // InternalCmdArgsParser.g:98:4: this_NEWLINE_2= RULE_NEWLINE
                    	    	    {
                    	    	    this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_4); 
                    	    	     
                    	    	        newLeafNode(this_NEWLINE_2, grammarAccess.getModelAccess().getNEWLINETerminalRuleCall_1_1_0()); 
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop1;
                    	        }
                    	    } while (true);

                    	    // InternalCmdArgsParser.g:102:3: ( (lv_lines_3_0= ruleCmdLine ) )
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
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalCmdArgsParser.g:120:6: (this_NEWLINE_4= RULE_NEWLINE )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_NEWLINE) ) {
                alt4=1;
            }
            switch (alt4) {
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
    // InternalCmdArgsParser.g:141:1: ruleCmdLine returns [EObject current=null] : ( () ( (lv_start_1_0= RULE_ID ) ) (this_WS_2= RULE_WS )+ this_SKW_COLON_3= RULE_SKW_COLON this_SKW_ASSIGN_4= RULE_SKW_ASSIGN (this_WS_5= RULE_WS )+ ( ( (lv_arguments_6_0= ruleArgument ) ) ( (this_WS_7= RULE_WS )+ ( (lv_arguments_8_0= ruleArgument ) ) )* ) ) ;
    public final EObject ruleCmdLine() throws RecognitionException {
        EObject current = null;

        Token lv_start_1_0=null;
        Token this_WS_2=null;
        Token this_SKW_COLON_3=null;
        Token this_SKW_ASSIGN_4=null;
        Token this_WS_5=null;
        Token this_WS_7=null;
        EObject lv_arguments_6_0 = null;

        EObject lv_arguments_8_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:144:28: ( ( () ( (lv_start_1_0= RULE_ID ) ) (this_WS_2= RULE_WS )+ this_SKW_COLON_3= RULE_SKW_COLON this_SKW_ASSIGN_4= RULE_SKW_ASSIGN (this_WS_5= RULE_WS )+ ( ( (lv_arguments_6_0= ruleArgument ) ) ( (this_WS_7= RULE_WS )+ ( (lv_arguments_8_0= ruleArgument ) ) )* ) ) )
            // InternalCmdArgsParser.g:145:1: ( () ( (lv_start_1_0= RULE_ID ) ) (this_WS_2= RULE_WS )+ this_SKW_COLON_3= RULE_SKW_COLON this_SKW_ASSIGN_4= RULE_SKW_ASSIGN (this_WS_5= RULE_WS )+ ( ( (lv_arguments_6_0= ruleArgument ) ) ( (this_WS_7= RULE_WS )+ ( (lv_arguments_8_0= ruleArgument ) ) )* ) )
            {
            // InternalCmdArgsParser.g:145:1: ( () ( (lv_start_1_0= RULE_ID ) ) (this_WS_2= RULE_WS )+ this_SKW_COLON_3= RULE_SKW_COLON this_SKW_ASSIGN_4= RULE_SKW_ASSIGN (this_WS_5= RULE_WS )+ ( ( (lv_arguments_6_0= ruleArgument ) ) ( (this_WS_7= RULE_WS )+ ( (lv_arguments_8_0= ruleArgument ) ) )* ) )
            // InternalCmdArgsParser.g:145:2: () ( (lv_start_1_0= RULE_ID ) ) (this_WS_2= RULE_WS )+ this_SKW_COLON_3= RULE_SKW_COLON this_SKW_ASSIGN_4= RULE_SKW_ASSIGN (this_WS_5= RULE_WS )+ ( ( (lv_arguments_6_0= ruleArgument ) ) ( (this_WS_7= RULE_WS )+ ( (lv_arguments_8_0= ruleArgument ) ) )* )
            {
            // InternalCmdArgsParser.g:145:2: ()
            // InternalCmdArgsParser.g:146:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCmdLineAccess().getCmdLineAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:151:2: ( (lv_start_1_0= RULE_ID ) )
            // InternalCmdArgsParser.g:152:1: (lv_start_1_0= RULE_ID )
            {
            // InternalCmdArgsParser.g:152:1: (lv_start_1_0= RULE_ID )
            // InternalCmdArgsParser.g:153:3: lv_start_1_0= RULE_ID
            {
            lv_start_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            			newLeafNode(lv_start_1_0, grammarAccess.getCmdLineAccess().getStartIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCmdLineRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"start",
                    		lv_start_1_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.ID");
            	    

            }


            }

            // InternalCmdArgsParser.g:169:2: (this_WS_2= RULE_WS )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_WS) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalCmdArgsParser.g:169:3: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_6); 
            	     
            	        newLeafNode(this_WS_2, grammarAccess.getCmdLineAccess().getWSTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            this_SKW_COLON_3=(Token)match(input,RULE_SKW_COLON,FOLLOW_7); 
             
                newLeafNode(this_SKW_COLON_3, grammarAccess.getCmdLineAccess().getSKW_COLONTerminalRuleCall_3()); 
                
            this_SKW_ASSIGN_4=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_5); 
             
                newLeafNode(this_SKW_ASSIGN_4, grammarAccess.getCmdLineAccess().getSKW_ASSIGNTerminalRuleCall_4()); 
                
            // InternalCmdArgsParser.g:181:1: (this_WS_5= RULE_WS )+
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
            	    // InternalCmdArgsParser.g:181:2: this_WS_5= RULE_WS
            	    {
            	    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); 
            	     
            	        newLeafNode(this_WS_5, grammarAccess.getCmdLineAccess().getWSTerminalRuleCall_5()); 
            	        

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

            // InternalCmdArgsParser.g:185:3: ( ( (lv_arguments_6_0= ruleArgument ) ) ( (this_WS_7= RULE_WS )+ ( (lv_arguments_8_0= ruleArgument ) ) )* )
            // InternalCmdArgsParser.g:185:4: ( (lv_arguments_6_0= ruleArgument ) ) ( (this_WS_7= RULE_WS )+ ( (lv_arguments_8_0= ruleArgument ) ) )*
            {
            // InternalCmdArgsParser.g:185:4: ( (lv_arguments_6_0= ruleArgument ) )
            // InternalCmdArgsParser.g:186:1: (lv_arguments_6_0= ruleArgument )
            {
            // InternalCmdArgsParser.g:186:1: (lv_arguments_6_0= ruleArgument )
            // InternalCmdArgsParser.g:187:3: lv_arguments_6_0= ruleArgument
            {
             
            	        newCompositeNode(grammarAccess.getCmdLineAccess().getArgumentsArgumentParserRuleCall_6_0_0()); 
            	    
            pushFollow(FOLLOW_9);
            lv_arguments_6_0=ruleArgument();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCmdLineRule());
            	        }
                   		add(
                   			current, 
                   			"arguments",
                    		lv_arguments_6_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.Argument");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalCmdArgsParser.g:203:2: ( (this_WS_7= RULE_WS )+ ( (lv_arguments_8_0= ruleArgument ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_WS) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalCmdArgsParser.g:203:3: (this_WS_7= RULE_WS )+ ( (lv_arguments_8_0= ruleArgument ) )
            	    {
            	    // InternalCmdArgsParser.g:203:3: (this_WS_7= RULE_WS )+
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
            	    	    // InternalCmdArgsParser.g:203:4: this_WS_7= RULE_WS
            	    	    {
            	    	    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_8); 
            	    	     
            	    	        newLeafNode(this_WS_7, grammarAccess.getCmdLineAccess().getWSTerminalRuleCall_6_1_0()); 
            	    	        

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

            	    // InternalCmdArgsParser.g:207:3: ( (lv_arguments_8_0= ruleArgument ) )
            	    // InternalCmdArgsParser.g:208:1: (lv_arguments_8_0= ruleArgument )
            	    {
            	    // InternalCmdArgsParser.g:208:1: (lv_arguments_8_0= ruleArgument )
            	    // InternalCmdArgsParser.g:209:3: lv_arguments_8_0= ruleArgument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCmdLineAccess().getArgumentsArgumentParserRuleCall_6_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_9);
            	    lv_arguments_8_0=ruleArgument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCmdLineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"arguments",
            	            		lv_arguments_8_0, 
            	            		"at.jku.weiner.c.cmdarguments.CmdArgs.Argument");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // InternalCmdArgsParser.g:233:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // InternalCmdArgsParser.g:234:2: (iv_ruleArgument= ruleArgument EOF )
            // InternalCmdArgsParser.g:235:2: iv_ruleArgument= ruleArgument EOF
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
    // InternalCmdArgsParser.g:242:1: ruleArgument returns [EObject current=null] : ( () ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) ) ) ;
    public final EObject ruleArgument() throws RecognitionException {
        EObject current = null;

        Token this_KW_DEFINE_1=null;
        Token lv_incDir_3_0=null;
        Token this_WS_6=null;
        Token this_SKW_MINUS_9=null;
        Token this_KW_INCLUDE_10=null;
        Token this_WS_11=null;
        Token this_KW_OUTPUT_13=null;
        Token this_WS_14=null;
        Token this_KW_LANG_16=null;
        Token this_WS_17=null;
        Token this_SKW_MINUS_19=null;
        Token this_SKW_MINUS_20=null;
        EObject lv_macro_2_0 = null;

        EObject lv_useIncDir_4_0 = null;

        AntlrDatatypeRuleToken lv_incSys_5_0 = null;

        EObject lv_useIncDir_7_0 = null;

        AntlrDatatypeRuleToken lv_nostdinc_8_0 = null;

        EObject lv_include_12_0 = null;

        EObject lv_out_15_0 = null;

        EObject lv_lang_18_0 = null;

        AntlrDatatypeRuleToken lv_option_21_0 = null;

        AntlrDatatypeRuleToken lv_in_22_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:245:28: ( ( () ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) ) ) )
            // InternalCmdArgsParser.g:246:1: ( () ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) ) )
            {
            // InternalCmdArgsParser.g:246:1: ( () ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) ) )
            // InternalCmdArgsParser.g:246:2: () ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) )
            {
            // InternalCmdArgsParser.g:246:2: ()
            // InternalCmdArgsParser.g:247:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArgumentAccess().getArgumentAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:252:2: ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) )
            int alt15=9;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // InternalCmdArgsParser.g:252:3: (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) )
                    {
                    // InternalCmdArgsParser.g:252:3: (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) )
                    // InternalCmdArgsParser.g:252:4: this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) )
                    {
                    this_KW_DEFINE_1=(Token)match(input,RULE_KW_DEFINE,FOLLOW_10); 
                     
                        newLeafNode(this_KW_DEFINE_1, grammarAccess.getArgumentAccess().getKW_DEFINETerminalRuleCall_1_0_0()); 
                        
                    // InternalCmdArgsParser.g:256:1: ( (lv_macro_2_0= ruleMacro ) )
                    // InternalCmdArgsParser.g:257:1: (lv_macro_2_0= ruleMacro )
                    {
                    // InternalCmdArgsParser.g:257:1: (lv_macro_2_0= ruleMacro )
                    // InternalCmdArgsParser.g:258:3: lv_macro_2_0= ruleMacro
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
                    // InternalCmdArgsParser.g:275:6: ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:275:6: ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:275:7: ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) )
                    {
                    // InternalCmdArgsParser.g:275:7: ( (lv_incDir_3_0= RULE_KW_INCDIR ) )
                    // InternalCmdArgsParser.g:276:1: (lv_incDir_3_0= RULE_KW_INCDIR )
                    {
                    // InternalCmdArgsParser.g:276:1: (lv_incDir_3_0= RULE_KW_INCDIR )
                    // InternalCmdArgsParser.g:277:3: lv_incDir_3_0= RULE_KW_INCDIR
                    {
                    lv_incDir_3_0=(Token)match(input,RULE_KW_INCDIR,FOLLOW_10); 

                    			newLeafNode(lv_incDir_3_0, grammarAccess.getArgumentAccess().getIncDirKW_INCDIRTerminalRuleCall_1_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getArgumentRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"incDir",
                            		true, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.KW_INCDIR");
                    	    

                    }


                    }

                    // InternalCmdArgsParser.g:293:2: ( (lv_useIncDir_4_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:294:1: (lv_useIncDir_4_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:294:1: (lv_useIncDir_4_0= rulePathCmd )
                    // InternalCmdArgsParser.g:295:3: lv_useIncDir_4_0= rulePathCmd
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
                    // InternalCmdArgsParser.g:312:6: ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:312:6: ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:312:7: ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) )
                    {
                    // InternalCmdArgsParser.g:312:7: ( (lv_incSys_5_0= ruleIncSys ) )
                    // InternalCmdArgsParser.g:313:1: (lv_incSys_5_0= ruleIncSys )
                    {
                    // InternalCmdArgsParser.g:313:1: (lv_incSys_5_0= ruleIncSys )
                    // InternalCmdArgsParser.g:314:3: lv_incSys_5_0= ruleIncSys
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getIncSysIncSysParserRuleCall_1_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_5);
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

                    // InternalCmdArgsParser.g:330:2: (this_WS_6= RULE_WS )+
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
                    	    // InternalCmdArgsParser.g:330:3: this_WS_6= RULE_WS
                    	    {
                    	    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_11); 
                    	     
                    	        newLeafNode(this_WS_6, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_2_1()); 
                    	        

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

                    // InternalCmdArgsParser.g:334:3: ( (lv_useIncDir_7_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:335:1: (lv_useIncDir_7_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:335:1: (lv_useIncDir_7_0= rulePathCmd )
                    // InternalCmdArgsParser.g:336:3: lv_useIncDir_7_0= rulePathCmd
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
                    // InternalCmdArgsParser.g:353:6: ( (lv_nostdinc_8_0= ruleNoStdInc ) )
                    {
                    // InternalCmdArgsParser.g:353:6: ( (lv_nostdinc_8_0= ruleNoStdInc ) )
                    // InternalCmdArgsParser.g:354:1: (lv_nostdinc_8_0= ruleNoStdInc )
                    {
                    // InternalCmdArgsParser.g:354:1: (lv_nostdinc_8_0= ruleNoStdInc )
                    // InternalCmdArgsParser.g:355:3: lv_nostdinc_8_0= ruleNoStdInc
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
                    // InternalCmdArgsParser.g:372:6: (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:372:6: (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:372:7: this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) )
                    {
                    this_SKW_MINUS_9=(Token)match(input,RULE_SKW_MINUS,FOLLOW_12); 
                     
                        newLeafNode(this_SKW_MINUS_9, grammarAccess.getArgumentAccess().getSKW_MINUSTerminalRuleCall_1_4_0()); 
                        
                    this_KW_INCLUDE_10=(Token)match(input,RULE_KW_INCLUDE,FOLLOW_5); 
                     
                        newLeafNode(this_KW_INCLUDE_10, grammarAccess.getArgumentAccess().getKW_INCLUDETerminalRuleCall_1_4_1()); 
                        
                    // InternalCmdArgsParser.g:380:1: (this_WS_11= RULE_WS )+
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
                    	    // InternalCmdArgsParser.g:380:2: this_WS_11= RULE_WS
                    	    {
                    	    this_WS_11=(Token)match(input,RULE_WS,FOLLOW_11); 
                    	     
                    	        newLeafNode(this_WS_11, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_4_2()); 
                    	        

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

                    // InternalCmdArgsParser.g:384:3: ( (lv_include_12_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:385:1: (lv_include_12_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:385:1: (lv_include_12_0= rulePathCmd )
                    // InternalCmdArgsParser.g:386:3: lv_include_12_0= rulePathCmd
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getIncludePathCmdParserRuleCall_1_4_3_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_include_12_0=rulePathCmd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"include",
                            		lv_include_12_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.PathCmd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalCmdArgsParser.g:403:6: (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:403:6: (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:403:7: this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) )
                    {
                    this_KW_OUTPUT_13=(Token)match(input,RULE_KW_OUTPUT,FOLLOW_5); 
                     
                        newLeafNode(this_KW_OUTPUT_13, grammarAccess.getArgumentAccess().getKW_OUTPUTTerminalRuleCall_1_5_0()); 
                        
                    // InternalCmdArgsParser.g:407:1: (this_WS_14= RULE_WS )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_WS) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:407:2: this_WS_14= RULE_WS
                    	    {
                    	    this_WS_14=(Token)match(input,RULE_WS,FOLLOW_11); 
                    	     
                    	        newLeafNode(this_WS_14, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_5_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);

                    // InternalCmdArgsParser.g:411:3: ( (lv_out_15_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:412:1: (lv_out_15_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:412:1: (lv_out_15_0= rulePathCmd )
                    // InternalCmdArgsParser.g:413:3: lv_out_15_0= rulePathCmd
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getOutPathCmdParserRuleCall_1_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_out_15_0=rulePathCmd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"out",
                            		lv_out_15_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.PathCmd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalCmdArgsParser.g:430:6: (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:430:6: (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:430:7: this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) )
                    {
                    this_KW_LANG_16=(Token)match(input,RULE_KW_LANG,FOLLOW_5); 
                     
                        newLeafNode(this_KW_LANG_16, grammarAccess.getArgumentAccess().getKW_LANGTerminalRuleCall_1_6_0()); 
                        
                    // InternalCmdArgsParser.g:434:1: (this_WS_17= RULE_WS )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_WS) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:434:2: this_WS_17= RULE_WS
                    	    {
                    	    this_WS_17=(Token)match(input,RULE_WS,FOLLOW_11); 
                    	     
                    	        newLeafNode(this_WS_17, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_6_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    // InternalCmdArgsParser.g:438:3: ( (lv_lang_18_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:439:1: (lv_lang_18_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:439:1: (lv_lang_18_0= rulePathCmd )
                    // InternalCmdArgsParser.g:440:3: lv_lang_18_0= rulePathCmd
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getLangPathCmdParserRuleCall_1_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_lang_18_0=rulePathCmd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"lang",
                            		lv_lang_18_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.PathCmd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalCmdArgsParser.g:457:6: (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? )
                    {
                    // InternalCmdArgsParser.g:457:6: (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? )
                    // InternalCmdArgsParser.g:457:7: this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )?
                    {
                    this_SKW_MINUS_19=(Token)match(input,RULE_SKW_MINUS,FOLLOW_13); 
                     
                        newLeafNode(this_SKW_MINUS_19, grammarAccess.getArgumentAccess().getSKW_MINUSTerminalRuleCall_1_7_0()); 
                        
                    // InternalCmdArgsParser.g:461:1: (this_SKW_MINUS_20= RULE_SKW_MINUS )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==RULE_SKW_MINUS) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalCmdArgsParser.g:461:2: this_SKW_MINUS_20= RULE_SKW_MINUS
                            {
                            this_SKW_MINUS_20=(Token)match(input,RULE_SKW_MINUS,FOLLOW_14); 
                             
                                newLeafNode(this_SKW_MINUS_20, grammarAccess.getArgumentAccess().getSKW_MINUSTerminalRuleCall_1_7_1()); 
                                

                            }
                            break;

                    }

                    // InternalCmdArgsParser.g:465:3: ( (lv_option_21_0= ruleOption ) )?
                    int alt14=2;
                    alt14 = dfa14.predict(input);
                    switch (alt14) {
                        case 1 :
                            // InternalCmdArgsParser.g:466:1: (lv_option_21_0= ruleOption )
                            {
                            // InternalCmdArgsParser.g:466:1: (lv_option_21_0= ruleOption )
                            // InternalCmdArgsParser.g:467:3: lv_option_21_0= ruleOption
                            {
                             
                            	        newCompositeNode(grammarAccess.getArgumentAccess().getOptionOptionParserRuleCall_1_7_2_0()); 
                            	    
                            pushFollow(FOLLOW_2);
                            lv_option_21_0=ruleOption();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"option",
                                    		lv_option_21_0, 
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
                    // InternalCmdArgsParser.g:484:6: ( (lv_in_22_0= ruleIdentifier ) )
                    {
                    // InternalCmdArgsParser.g:484:6: ( (lv_in_22_0= ruleIdentifier ) )
                    // InternalCmdArgsParser.g:485:1: (lv_in_22_0= ruleIdentifier )
                    {
                    // InternalCmdArgsParser.g:485:1: (lv_in_22_0= ruleIdentifier )
                    // InternalCmdArgsParser.g:486:3: lv_in_22_0= ruleIdentifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getInIdentifierParserRuleCall_1_8_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_in_22_0=ruleIdentifier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"in",
                            		lv_in_22_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
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


    // $ANTLR start "entryRuleIncSys"
    // InternalCmdArgsParser.g:510:1: entryRuleIncSys returns [String current=null] : iv_ruleIncSys= ruleIncSys EOF ;
    public final String entryRuleIncSys() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIncSys = null;


        try {
            // InternalCmdArgsParser.g:511:1: (iv_ruleIncSys= ruleIncSys EOF )
            // InternalCmdArgsParser.g:512:2: iv_ruleIncSys= ruleIncSys EOF
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
    // InternalCmdArgsParser.g:519:1: ruleIncSys returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS ) ;
    public final AntlrDatatypeRuleToken ruleIncSys() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_MINUS_0=null;
        Token this_KW_INCSYS_1=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:523:6: ( (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS ) )
            // InternalCmdArgsParser.g:524:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS )
            {
            // InternalCmdArgsParser.g:524:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS )
            // InternalCmdArgsParser.g:524:6: this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS
            {
            this_SKW_MINUS_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_15); 

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
    // InternalCmdArgsParser.g:546:1: entryRuleNoStdInc returns [String current=null] : iv_ruleNoStdInc= ruleNoStdInc EOF ;
    public final String entryRuleNoStdInc() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoStdInc = null;


        try {
            // InternalCmdArgsParser.g:547:1: (iv_ruleNoStdInc= ruleNoStdInc EOF )
            // InternalCmdArgsParser.g:548:2: iv_ruleNoStdInc= ruleNoStdInc EOF
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
    // InternalCmdArgsParser.g:555:1: ruleNoStdInc returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC ) ;
    public final AntlrDatatypeRuleToken ruleNoStdInc() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_MINUS_0=null;
        Token this_KW_NOSTDINC_1=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:559:6: ( (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC ) )
            // InternalCmdArgsParser.g:560:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC )
            {
            // InternalCmdArgsParser.g:560:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC )
            // InternalCmdArgsParser.g:560:6: this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC
            {
            this_SKW_MINUS_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_16); 

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


    // $ANTLR start "entryRuleMacro"
    // InternalCmdArgsParser.g:582:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // InternalCmdArgsParser.g:583:2: (iv_ruleMacro= ruleMacro EOF )
            // InternalCmdArgsParser.g:584:2: iv_ruleMacro= ruleMacro EOF
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
    // InternalCmdArgsParser.g:591:1: ruleMacro returns [EObject current=null] : (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro | this_StringMacro_3= ruleStringMacro ) ;
    public final EObject ruleMacro() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleMacro_0 = null;

        EObject this_ObjectMacro_1 = null;

        EObject this_FunctionMacro_2 = null;

        EObject this_StringMacro_3 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:594:28: ( (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro | this_StringMacro_3= ruleStringMacro ) )
            // InternalCmdArgsParser.g:595:1: (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro | this_StringMacro_3= ruleStringMacro )
            {
            // InternalCmdArgsParser.g:595:1: (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro | this_StringMacro_3= ruleStringMacro )
            int alt16=4;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case RULE_SKW_ASSIGN:
                    {
                    alt16=2;
                    }
                    break;
                case EOF:
                case RULE_ID:
                case RULE_NEWLINE:
                case RULE_WS:
                    {
                    alt16=1;
                    }
                    break;
                case RULE_SKW_LEFTPAREN:
                    {
                    alt16=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA16_0==RULE_STRING2) ) {
                alt16=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalCmdArgsParser.g:596:5: this_SimpleMacro_0= ruleSimpleMacro
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
                    // InternalCmdArgsParser.g:606:5: this_ObjectMacro_1= ruleObjectMacro
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
                    // InternalCmdArgsParser.g:616:5: this_FunctionMacro_2= ruleFunctionMacro
                    {
                     
                            newCompositeNode(grammarAccess.getMacroAccess().getFunctionMacroParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_FunctionMacro_2=ruleFunctionMacro();

                    state._fsp--;


                            current = this_FunctionMacro_2;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalCmdArgsParser.g:626:5: this_StringMacro_3= ruleStringMacro
                    {
                     
                            newCompositeNode(grammarAccess.getMacroAccess().getStringMacroParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_StringMacro_3=ruleStringMacro();

                    state._fsp--;


                            current = this_StringMacro_3;
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
    // InternalCmdArgsParser.g:642:1: entryRuleSimpleMacro returns [EObject current=null] : iv_ruleSimpleMacro= ruleSimpleMacro EOF ;
    public final EObject entryRuleSimpleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleMacro = null;


        try {
            // InternalCmdArgsParser.g:643:2: (iv_ruleSimpleMacro= ruleSimpleMacro EOF )
            // InternalCmdArgsParser.g:644:2: iv_ruleSimpleMacro= ruleSimpleMacro EOF
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
    // InternalCmdArgsParser.g:651:1: ruleSimpleMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleSimpleMacro() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:654:28: ( ( () ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // InternalCmdArgsParser.g:655:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // InternalCmdArgsParser.g:655:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) )
            // InternalCmdArgsParser.g:655:2: () ( (lv_name_1_0= ruleIdentifier ) )
            {
            // InternalCmdArgsParser.g:655:2: ()
            // InternalCmdArgsParser.g:656:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSimpleMacroAccess().getSimpleMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:661:2: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalCmdArgsParser.g:662:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalCmdArgsParser.g:662:1: (lv_name_1_0= ruleIdentifier )
            // InternalCmdArgsParser.g:663:3: lv_name_1_0= ruleIdentifier
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
    // InternalCmdArgsParser.g:687:1: entryRuleObjectMacro returns [EObject current=null] : iv_ruleObjectMacro= ruleObjectMacro EOF ;
    public final EObject entryRuleObjectMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectMacro = null;


        try {
            // InternalCmdArgsParser.g:688:2: (iv_ruleObjectMacro= ruleObjectMacro EOF )
            // InternalCmdArgsParser.g:689:2: iv_ruleObjectMacro= ruleObjectMacro EOF
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
    // InternalCmdArgsParser.g:696:1: ruleObjectMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) ) ;
    public final EObject ruleObjectMacro() throws RecognitionException {
        EObject current = null;

        Token this_SKW_ASSIGN_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:699:28: ( ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) ) )
            // InternalCmdArgsParser.g:700:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) )
            {
            // InternalCmdArgsParser.g:700:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) )
            // InternalCmdArgsParser.g:700:2: () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) )
            {
            // InternalCmdArgsParser.g:700:2: ()
            // InternalCmdArgsParser.g:701:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getObjectMacroAccess().getObjectMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:706:2: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalCmdArgsParser.g:707:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalCmdArgsParser.g:707:1: (lv_name_1_0= ruleIdentifier )
            // InternalCmdArgsParser.g:708:3: lv_name_1_0= ruleIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getObjectMacroAccess().getNameIdentifierParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_7);
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

            this_SKW_ASSIGN_2=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_17); 
             
                newLeafNode(this_SKW_ASSIGN_2, grammarAccess.getObjectMacroAccess().getSKW_ASSIGNTerminalRuleCall_2()); 
                
            // InternalCmdArgsParser.g:728:1: ( (lv_value_3_0= ruleMyCode ) )
            // InternalCmdArgsParser.g:729:1: (lv_value_3_0= ruleMyCode )
            {
            // InternalCmdArgsParser.g:729:1: (lv_value_3_0= ruleMyCode )
            // InternalCmdArgsParser.g:730:3: lv_value_3_0= ruleMyCode
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
    // InternalCmdArgsParser.g:754:1: entryRuleFunctionMacro returns [EObject current=null] : iv_ruleFunctionMacro= ruleFunctionMacro EOF ;
    public final EObject entryRuleFunctionMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionMacro = null;


        try {
            // InternalCmdArgsParser.g:755:2: (iv_ruleFunctionMacro= ruleFunctionMacro EOF )
            // InternalCmdArgsParser.g:756:2: iv_ruleFunctionMacro= ruleFunctionMacro EOF
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
    // InternalCmdArgsParser.g:763:1: ruleFunctionMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) ) ;
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
            // InternalCmdArgsParser.g:766:28: ( ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) ) )
            // InternalCmdArgsParser.g:767:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) )
            {
            // InternalCmdArgsParser.g:767:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) )
            // InternalCmdArgsParser.g:767:2: () ( (lv_name_1_0= ruleIdentifier ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) )
            {
            // InternalCmdArgsParser.g:767:2: ()
            // InternalCmdArgsParser.g:768:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFunctionMacroAccess().getFunctionMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:773:2: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalCmdArgsParser.g:774:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalCmdArgsParser.g:774:1: (lv_name_1_0= ruleIdentifier )
            // InternalCmdArgsParser.g:775:3: lv_name_1_0= ruleIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getNameIdentifierParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_18);
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

            this_SKW_LEFTPAREN_2=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_19); 
             
                newLeafNode(this_SKW_LEFTPAREN_2, grammarAccess.getFunctionMacroAccess().getSKW_LEFTPARENTerminalRuleCall_2()); 
                
            // InternalCmdArgsParser.g:795:1: ( ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalCmdArgsParser.g:795:2: ( (lv_params_3_0= ruleIdentifier ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )*
                    {
                    // InternalCmdArgsParser.g:795:2: ( (lv_params_3_0= ruleIdentifier ) )
                    // InternalCmdArgsParser.g:796:1: (lv_params_3_0= ruleIdentifier )
                    {
                    // InternalCmdArgsParser.g:796:1: (lv_params_3_0= ruleIdentifier )
                    // InternalCmdArgsParser.g:797:3: lv_params_3_0= ruleIdentifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getParamsIdentifierParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_20);
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

                    // InternalCmdArgsParser.g:813:2: (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_SKW_COMMA) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:813:3: this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleIdentifier ) )
                    	    {
                    	    this_SKW_COMMA_4=(Token)match(input,RULE_SKW_COMMA,FOLLOW_21); 
                    	     
                    	        newLeafNode(this_SKW_COMMA_4, grammarAccess.getFunctionMacroAccess().getSKW_COMMATerminalRuleCall_3_1_0()); 
                    	        
                    	    // InternalCmdArgsParser.g:817:1: ( (lv_params_5_0= ruleIdentifier ) )
                    	    // InternalCmdArgsParser.g:818:1: (lv_params_5_0= ruleIdentifier )
                    	    {
                    	    // InternalCmdArgsParser.g:818:1: (lv_params_5_0= ruleIdentifier )
                    	    // InternalCmdArgsParser.g:819:3: lv_params_5_0= ruleIdentifier
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getParamsIdentifierParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_20);
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
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            this_SKW_RIGHTPAREN_6=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_7); 
             
                newLeafNode(this_SKW_RIGHTPAREN_6, grammarAccess.getFunctionMacroAccess().getSKW_RIGHTPARENTerminalRuleCall_4()); 
                
            this_SKW_ASSIGN_7=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_17); 
             
                newLeafNode(this_SKW_ASSIGN_7, grammarAccess.getFunctionMacroAccess().getSKW_ASSIGNTerminalRuleCall_5()); 
                
            // InternalCmdArgsParser.g:843:1: ( (lv_value_8_0= ruleMyCode ) )
            // InternalCmdArgsParser.g:844:1: (lv_value_8_0= ruleMyCode )
            {
            // InternalCmdArgsParser.g:844:1: (lv_value_8_0= ruleMyCode )
            // InternalCmdArgsParser.g:845:3: lv_value_8_0= ruleMyCode
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


    // $ANTLR start "entryRuleStringMacro"
    // InternalCmdArgsParser.g:869:1: entryRuleStringMacro returns [EObject current=null] : iv_ruleStringMacro= ruleStringMacro EOF ;
    public final EObject entryRuleStringMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringMacro = null;


        try {
            // InternalCmdArgsParser.g:870:2: (iv_ruleStringMacro= ruleStringMacro EOF )
            // InternalCmdArgsParser.g:871:2: iv_ruleStringMacro= ruleStringMacro EOF
            {
             newCompositeNode(grammarAccess.getStringMacroRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringMacro=ruleStringMacro();

            state._fsp--;

             current =iv_ruleStringMacro; 
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
    // $ANTLR end "entryRuleStringMacro"


    // $ANTLR start "ruleStringMacro"
    // InternalCmdArgsParser.g:878:1: ruleStringMacro returns [EObject current=null] : ( () ( (lv_string_1_0= RULE_STRING2 ) ) ) ;
    public final EObject ruleStringMacro() throws RecognitionException {
        EObject current = null;

        Token lv_string_1_0=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:881:28: ( ( () ( (lv_string_1_0= RULE_STRING2 ) ) ) )
            // InternalCmdArgsParser.g:882:1: ( () ( (lv_string_1_0= RULE_STRING2 ) ) )
            {
            // InternalCmdArgsParser.g:882:1: ( () ( (lv_string_1_0= RULE_STRING2 ) ) )
            // InternalCmdArgsParser.g:882:2: () ( (lv_string_1_0= RULE_STRING2 ) )
            {
            // InternalCmdArgsParser.g:882:2: ()
            // InternalCmdArgsParser.g:883:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringMacroAccess().getStringMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:888:2: ( (lv_string_1_0= RULE_STRING2 ) )
            // InternalCmdArgsParser.g:889:1: (lv_string_1_0= RULE_STRING2 )
            {
            // InternalCmdArgsParser.g:889:1: (lv_string_1_0= RULE_STRING2 )
            // InternalCmdArgsParser.g:890:3: lv_string_1_0= RULE_STRING2
            {
            lv_string_1_0=(Token)match(input,RULE_STRING2,FOLLOW_2); 

            			newLeafNode(lv_string_1_0, grammarAccess.getStringMacroAccess().getStringSTRING2TerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStringMacroRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"string",
                    		lv_string_1_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.STRING2");
            	    

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
    // $ANTLR end "ruleStringMacro"


    // $ANTLR start "entryRulePathCmd"
    // InternalCmdArgsParser.g:914:1: entryRulePathCmd returns [EObject current=null] : iv_rulePathCmd= rulePathCmd EOF ;
    public final EObject entryRulePathCmd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathCmd = null;


        try {
            // InternalCmdArgsParser.g:915:2: (iv_rulePathCmd= rulePathCmd EOF )
            // InternalCmdArgsParser.g:916:2: iv_rulePathCmd= rulePathCmd EOF
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
    // InternalCmdArgsParser.g:923:1: rulePathCmd returns [EObject current=null] : ( ( (lv_path_0_1= ruleIdentifier | lv_path_0_2= RULE_STRING2 ) ) ) ;
    public final EObject rulePathCmd() throws RecognitionException {
        EObject current = null;

        Token lv_path_0_2=null;
        AntlrDatatypeRuleToken lv_path_0_1 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:926:28: ( ( ( (lv_path_0_1= ruleIdentifier | lv_path_0_2= RULE_STRING2 ) ) ) )
            // InternalCmdArgsParser.g:927:1: ( ( (lv_path_0_1= ruleIdentifier | lv_path_0_2= RULE_STRING2 ) ) )
            {
            // InternalCmdArgsParser.g:927:1: ( ( (lv_path_0_1= ruleIdentifier | lv_path_0_2= RULE_STRING2 ) ) )
            // InternalCmdArgsParser.g:928:1: ( (lv_path_0_1= ruleIdentifier | lv_path_0_2= RULE_STRING2 ) )
            {
            // InternalCmdArgsParser.g:928:1: ( (lv_path_0_1= ruleIdentifier | lv_path_0_2= RULE_STRING2 ) )
            // InternalCmdArgsParser.g:929:1: (lv_path_0_1= ruleIdentifier | lv_path_0_2= RULE_STRING2 )
            {
            // InternalCmdArgsParser.g:929:1: (lv_path_0_1= ruleIdentifier | lv_path_0_2= RULE_STRING2 )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_STRING2) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalCmdArgsParser.g:930:3: lv_path_0_1= ruleIdentifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getPathCmdAccess().getPathIdentifierParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_path_0_1=ruleIdentifier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPathCmdRule());
                    	        }
                           		set(
                           			current, 
                           			"path",
                            		lv_path_0_1, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:945:8: lv_path_0_2= RULE_STRING2
                    {
                    lv_path_0_2=(Token)match(input,RULE_STRING2,FOLLOW_2); 

                    			newLeafNode(lv_path_0_2, grammarAccess.getPathCmdAccess().getPathSTRING2TerminalRuleCall_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPathCmdRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"path",
                            		lv_path_0_2, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.STRING2");
                    	    

                    }
                    break;

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
    // $ANTLR end "rulePathCmd"


    // $ANTLR start "entryRuleIdentifier"
    // InternalCmdArgsParser.g:971:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalCmdArgsParser.g:972:1: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalCmdArgsParser.g:973:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalCmdArgsParser.g:980:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:984:6: (this_ID_0= RULE_ID )
            // InternalCmdArgsParser.g:985:5: this_ID_0= RULE_ID
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
    // InternalCmdArgsParser.g:1000:1: entryRuleMyCode returns [String current=null] : iv_ruleMyCode= ruleMyCode EOF ;
    public final String entryRuleMyCode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCode = null;


        try {
            // InternalCmdArgsParser.g:1001:1: (iv_ruleMyCode= ruleMyCode EOF )
            // InternalCmdArgsParser.g:1002:2: iv_ruleMyCode= ruleMyCode EOF
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
    // InternalCmdArgsParser.g:1009:1: ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_OptionChar_0= ruleOptionChar | this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN )+ ;
    public final AntlrDatatypeRuleToken ruleMyCode() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_LEFTPAREN_1=null;
        Token this_SKW_RIGHTPAREN_2=null;
        AntlrDatatypeRuleToken this_OptionChar_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1013:6: ( (this_OptionChar_0= ruleOptionChar | this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN )+ )
            // InternalCmdArgsParser.g:1014:1: (this_OptionChar_0= ruleOptionChar | this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN )+
            {
            // InternalCmdArgsParser.g:1014:1: (this_OptionChar_0= ruleOptionChar | this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN )+
            int cnt20=0;
            loop20:
            do {
                int alt20=4;
                alt20 = dfa20.predict(input);
                switch (alt20) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1015:5: this_OptionChar_0= ruleOptionChar
            	    {
            	     
            	            newCompositeNode(grammarAccess.getMyCodeAccess().getOptionCharParserRuleCall_0()); 
            	        
            	    pushFollow(FOLLOW_22);
            	    this_OptionChar_0=ruleOptionChar();

            	    state._fsp--;


            	    		current.merge(this_OptionChar_0);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;
            	case 2 :
            	    // InternalCmdArgsParser.g:1026:10: this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN
            	    {
            	    this_SKW_LEFTPAREN_1=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_22); 

            	    		current.merge(this_SKW_LEFTPAREN_1);
            	        
            	     
            	        newLeafNode(this_SKW_LEFTPAREN_1, grammarAccess.getMyCodeAccess().getSKW_LEFTPARENTerminalRuleCall_1()); 
            	        

            	    }
            	    break;
            	case 3 :
            	    // InternalCmdArgsParser.g:1034:10: this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN
            	    {
            	    this_SKW_RIGHTPAREN_2=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_22); 

            	    		current.merge(this_SKW_RIGHTPAREN_2);
            	        
            	     
            	        newLeafNode(this_SKW_RIGHTPAREN_2, grammarAccess.getMyCodeAccess().getSKW_RIGHTPARENTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
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


    // $ANTLR start "entryRuleOption"
    // InternalCmdArgsParser.g:1049:1: entryRuleOption returns [String current=null] : iv_ruleOption= ruleOption EOF ;
    public final String entryRuleOption() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOption = null;


        try {
            // InternalCmdArgsParser.g:1050:1: (iv_ruleOption= ruleOption EOF )
            // InternalCmdArgsParser.g:1051:2: iv_ruleOption= ruleOption EOF
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
    // InternalCmdArgsParser.g:1058:1: ruleOption returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_OptionChar_0= ruleOptionChar )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionChar_3= ruleOptionChar )+ )* ) ;
    public final AntlrDatatypeRuleToken ruleOption() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_COMMA_1=null;
        Token this_SKW_MINUS_2=null;
        AntlrDatatypeRuleToken this_OptionChar_0 = null;

        AntlrDatatypeRuleToken this_OptionChar_3 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1062:6: ( ( (this_OptionChar_0= ruleOptionChar )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionChar_3= ruleOptionChar )+ )* ) )
            // InternalCmdArgsParser.g:1063:1: ( (this_OptionChar_0= ruleOptionChar )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionChar_3= ruleOptionChar )+ )* )
            {
            // InternalCmdArgsParser.g:1063:1: ( (this_OptionChar_0= ruleOptionChar )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionChar_3= ruleOptionChar )+ )* )
            // InternalCmdArgsParser.g:1063:2: (this_OptionChar_0= ruleOptionChar )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionChar_3= ruleOptionChar )+ )*
            {
            // InternalCmdArgsParser.g:1063:2: (this_OptionChar_0= ruleOptionChar )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1064:5: this_OptionChar_0= ruleOptionChar
            	    {
            	     
            	            newCompositeNode(grammarAccess.getOptionAccess().getOptionCharParserRuleCall_0()); 
            	        
            	    pushFollow(FOLLOW_23);
            	    this_OptionChar_0=ruleOptionChar();

            	    state._fsp--;


            	    		current.merge(this_OptionChar_0);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            // InternalCmdArgsParser.g:1074:3: (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionChar_3= ruleOptionChar )+ )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_SKW_COMMA) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1074:8: this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionChar_3= ruleOptionChar )+
            	    {
            	    this_SKW_COMMA_1=(Token)match(input,RULE_SKW_COMMA,FOLLOW_24); 

            	    		current.merge(this_SKW_COMMA_1);
            	        
            	     
            	        newLeafNode(this_SKW_COMMA_1, grammarAccess.getOptionAccess().getSKW_COMMATerminalRuleCall_1_0()); 
            	        
            	    // InternalCmdArgsParser.g:1081:1: (this_SKW_MINUS_2= RULE_SKW_MINUS )?
            	    int alt22=2;
            	    int LA22_0 = input.LA(1);

            	    if ( (LA22_0==RULE_SKW_MINUS) ) {
            	        alt22=1;
            	    }
            	    switch (alt22) {
            	        case 1 :
            	            // InternalCmdArgsParser.g:1081:6: this_SKW_MINUS_2= RULE_SKW_MINUS
            	            {
            	            this_SKW_MINUS_2=(Token)match(input,RULE_SKW_MINUS,FOLLOW_25); 

            	            		current.merge(this_SKW_MINUS_2);
            	                
            	             
            	                newLeafNode(this_SKW_MINUS_2, grammarAccess.getOptionAccess().getSKW_MINUSTerminalRuleCall_1_1()); 
            	                

            	            }
            	            break;

            	    }

            	    // InternalCmdArgsParser.g:1088:3: (this_OptionChar_3= ruleOptionChar )+
            	    int cnt23=0;
            	    loop23:
            	    do {
            	        int alt23=2;
            	        alt23 = dfa23.predict(input);
            	        switch (alt23) {
            	    	case 1 :
            	    	    // InternalCmdArgsParser.g:1089:5: this_OptionChar_3= ruleOptionChar
            	    	    {
            	    	     
            	    	            newCompositeNode(grammarAccess.getOptionAccess().getOptionCharParserRuleCall_1_2()); 
            	    	        
            	    	    pushFollow(FOLLOW_23);
            	    	    this_OptionChar_3=ruleOptionChar();

            	    	    state._fsp--;


            	    	    		current.merge(this_OptionChar_3);
            	    	        
            	    	     
            	    	            afterParserOrEnumRuleCall();
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt23 >= 1 ) break loop23;
            	                EarlyExitException eee =
            	                    new EarlyExitException(23, input);
            	                throw eee;
            	        }
            	        cnt23++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop24;
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


    // $ANTLR start "entryRuleOptionChar"
    // InternalCmdArgsParser.g:1107:1: entryRuleOptionChar returns [String current=null] : iv_ruleOptionChar= ruleOptionChar EOF ;
    public final String entryRuleOptionChar() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOptionChar = null;


        try {
            // InternalCmdArgsParser.g:1108:1: (iv_ruleOptionChar= ruleOptionChar EOF )
            // InternalCmdArgsParser.g:1109:2: iv_ruleOptionChar= ruleOptionChar EOF
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
    // InternalCmdArgsParser.g:1116:1: ruleOptionChar returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING2_1= RULE_STRING2 | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_ANY_OTHER_3= RULE_ANY_OTHER ) ;
    public final AntlrDatatypeRuleToken ruleOptionChar() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING2_1=null;
        Token this_SKW_ASSIGN_2=null;
        Token this_ANY_OTHER_3=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1120:6: ( (this_ID_0= RULE_ID | this_STRING2_1= RULE_STRING2 | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_ANY_OTHER_3= RULE_ANY_OTHER ) )
            // InternalCmdArgsParser.g:1121:1: (this_ID_0= RULE_ID | this_STRING2_1= RULE_STRING2 | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_ANY_OTHER_3= RULE_ANY_OTHER )
            {
            // InternalCmdArgsParser.g:1121:1: (this_ID_0= RULE_ID | this_STRING2_1= RULE_STRING2 | this_SKW_ASSIGN_2= RULE_SKW_ASSIGN | this_ANY_OTHER_3= RULE_ANY_OTHER )
            int alt25=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt25=1;
                }
                break;
            case RULE_STRING2:
                {
                alt25=2;
                }
                break;
            case RULE_SKW_ASSIGN:
                {
                alt25=3;
                }
                break;
            case RULE_ANY_OTHER:
                {
                alt25=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalCmdArgsParser.g:1121:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getOptionCharAccess().getIDTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:1129:10: this_STRING2_1= RULE_STRING2
                    {
                    this_STRING2_1=(Token)match(input,RULE_STRING2,FOLLOW_2); 

                    		current.merge(this_STRING2_1);
                        
                     
                        newLeafNode(this_STRING2_1, grammarAccess.getOptionCharAccess().getSTRING2TerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalCmdArgsParser.g:1137:10: this_SKW_ASSIGN_2= RULE_SKW_ASSIGN
                    {
                    this_SKW_ASSIGN_2=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_2); 

                    		current.merge(this_SKW_ASSIGN_2);
                        
                     
                        newLeafNode(this_SKW_ASSIGN_2, grammarAccess.getOptionCharAccess().getSKW_ASSIGNTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalCmdArgsParser.g:1145:10: this_ANY_OTHER_3= RULE_ANY_OTHER
                    {
                    this_ANY_OTHER_3=(Token)match(input,RULE_ANY_OTHER,FOLLOW_2); 

                    		current.merge(this_ANY_OTHER_3);
                        
                     
                        newLeafNode(this_ANY_OTHER_3, grammarAccess.getOptionCharAccess().getANY_OTHERTerminalRuleCall_3()); 
                        

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


    protected DFA15 dfa15 = new DFA15(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA15_eotS =
        "\13\uffff";
    static final String DFA15_eofS =
        "\3\uffff\1\7\7\uffff";
    static final String DFA15_minS =
        "\1\7\2\uffff\1\7\7\uffff";
    static final String DFA15_maxS =
        "\1\27\2\uffff\1\41\7\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\6\1\7\1\11\1\10\1\4\1\3\1\5";
    static final String DFA15_specialS =
        "\13\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\3\6\uffff\1\1\1\2\1\4\1\5\5\uffff\1\6",
            "",
            "",
            "\2\7\11\uffff\1\10\1\11\1\12\2\uffff\1\7\3\uffff\3\7\3\uffff\1\7",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "252:2: ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) )";
        }
    }
    static final String DFA14_eotS =
        "\5\uffff";
    static final String DFA14_eofS =
        "\1\3\1\2\3\uffff";
    static final String DFA14_minS =
        "\2\10\2\uffff\1\6";
    static final String DFA14_maxS =
        "\2\41\2\uffff\1\35";
    static final String DFA14_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA14_specialS =
        "\5\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\2\16\uffff\1\1\3\uffff\1\2\2\3\3\uffff\1\2",
            "\1\2\2\uffff\1\2\13\uffff\1\2\3\uffff\2\2\1\4\3\uffff\1\2",
            "",
            "",
            "\1\3\1\2\6\uffff\4\2\5\uffff\1\2\5\uffff\1\4"
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "465:3: ( (lv_option_21_0= ruleOption ) )?";
        }
    }
    static final String DFA20_eotS =
        "\7\uffff";
    static final String DFA20_eofS =
        "\1\1\1\uffff\1\3\4\uffff";
    static final String DFA20_minS =
        "\1\10\1\uffff\1\10\3\uffff\1\6";
    static final String DFA20_maxS =
        "\1\41\1\uffff\1\41\3\uffff\1\35";
    static final String DFA20_acceptS =
        "\1\uffff\1\4\1\uffff\1\1\1\2\1\3\1\uffff";
    static final String DFA20_specialS =
        "\7\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\3\1\4\1\5\14\uffff\1\2\3\uffff\1\3\2\1\3\uffff\1\3",
            "",
            "\3\3\14\uffff\1\3\3\uffff\2\3\1\6\3\uffff\1\3",
            "",
            "",
            "",
            "\1\1\1\3\6\uffff\4\3\5\uffff\1\3\5\uffff\1\6"
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1014:1: (this_OptionChar_0= ruleOptionChar | this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN )+";
        }
    }
    static final String DFA21_eotS =
        "\5\uffff";
    static final String DFA21_eofS =
        "\1\1\1\uffff\1\3\2\uffff";
    static final String DFA21_minS =
        "\1\10\1\uffff\1\10\1\uffff\1\6";
    static final String DFA21_maxS =
        "\1\41\1\uffff\1\41\1\uffff\1\35";
    static final String DFA21_acceptS =
        "\1\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA21_specialS =
        "\5\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\3\2\uffff\1\1\13\uffff\1\2\3\uffff\1\3\2\1\3\uffff\1\3",
            "",
            "\1\3\2\uffff\1\3\13\uffff\1\3\3\uffff\2\3\1\4\3\uffff\1\3",
            "",
            "\1\1\1\3\6\uffff\4\3\5\uffff\1\3\5\uffff\1\4"
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
            return "()+ loopback of 1063:2: (this_OptionChar_0= ruleOptionChar )+";
        }
    }
    static final String DFA23_eotS =
        "\5\uffff";
    static final String DFA23_eofS =
        "\1\1\1\uffff\1\3\2\uffff";
    static final String DFA23_minS =
        "\1\10\1\uffff\1\10\1\uffff\1\6";
    static final String DFA23_maxS =
        "\1\41\1\uffff\1\41\1\uffff\1\35";
    static final String DFA23_acceptS =
        "\1\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA23_specialS =
        "\5\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\3\2\uffff\1\1\13\uffff\1\2\3\uffff\1\3\2\1\3\uffff\1\3",
            "",
            "\1\3\2\uffff\1\3\13\uffff\1\3\3\uffff\2\3\1\4\3\uffff\1\3",
            "",
            "\1\1\1\3\6\uffff\4\3\5\uffff\1\3\5\uffff\1\4"
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1088:3: (this_OptionChar_3= ruleOptionChar )+";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000010800002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000010800000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000020000040L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000002083C080L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x000000000883C080L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000000002883C080L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000208800182L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000208800102L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000208800700L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000000083C480L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000000000083C080L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000208800702L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000208800902L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000208800180L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000208800100L});

}