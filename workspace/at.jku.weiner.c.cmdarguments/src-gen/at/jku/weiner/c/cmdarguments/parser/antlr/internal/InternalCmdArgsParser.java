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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SKW_DOT", "RULE_SKW_DIV", "RULE_SKW_COLON", "RULE_SKW_MINUS", "RULE_SKW_ASSIGN", "RULE_SKW_LEFTPAREN", "RULE_SKW_RIGHTPAREN", "RULE_SKW_COMMA", "RULE_SKW_DOLLAR", "RULE_SKW_BACKSLASH", "RULE_KW_DEFINE", "RULE_KW_INCDIR", "RULE_KW_OUTPUT", "RULE_KW_LANG", "RULE_KW_NOSTDINC", "RULE_KW_INCSYS", "RULE_KW_INCLUDE", "RULE_KW_VAR", "RULE_ID_PART_1", "RULE_ID_PART_2", "RULE_ID", "RULE_LETTER", "RULE_INT", "RULE_DIGIT", "RULE_STRING2", "RULE_NEWLINE", "RULE_WS", "RULE_SKW_HASH", "RULE_LINE_BREAK", "RULE_LINE_COMMENT", "RULE_ANY_OTHER"
    };
    public static final int RULE_SKW_MINUS=7;
    public static final int RULE_ID=24;
    public static final int RULE_NEWLINE=29;
    public static final int RULE_ID_PART_1=22;
    public static final int RULE_KW_INCDIR=15;
    public static final int RULE_ID_PART_2=23;
    public static final int RULE_KW_OUTPUT=16;
    public static final int RULE_ANY_OTHER=34;
    public static final int RULE_SKW_DOLLAR=12;
    public static final int RULE_KW_NOSTDINC=18;
    public static final int RULE_SKW_DOT=4;
    public static final int RULE_SKW_DIV=5;
    public static final int RULE_LINE_BREAK=32;
    public static final int EOF=-1;
    public static final int RULE_LETTER=25;
    public static final int RULE_KW_VAR=21;
    public static final int RULE_SKW_RIGHTPAREN=10;
    public static final int RULE_STRING2=28;
    public static final int RULE_KW_INCLUDE=20;
    public static final int RULE_KW_DEFINE=14;
    public static final int RULE_KW_LANG=17;
    public static final int RULE_KW_INCSYS=19;
    public static final int RULE_LINE_COMMENT=33;
    public static final int RULE_INT=26;
    public static final int RULE_SKW_BACKSLASH=13;
    public static final int RULE_SKW_COMMA=11;
    public static final int RULE_WS=30;
    public static final int RULE_DIGIT=27;
    public static final int RULE_SKW_COLON=6;
    public static final int RULE_SKW_LEFTPAREN=9;
    public static final int RULE_SKW_ASSIGN=8;
    public static final int RULE_SKW_HASH=31;

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

            if ( (LA3_0==RULE_KW_VAR||LA3_0==RULE_ID) ) {
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

                            if ( (LA2_1==RULE_KW_VAR||LA2_1==RULE_ID||LA2_1==RULE_NEWLINE) ) {
                                alt2=1;
                            }


                        }
                        else if ( (LA2_0==RULE_KW_VAR||LA2_0==RULE_ID) ) {
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
    // InternalCmdArgsParser.g:141:1: ruleCmdLine returns [EObject current=null] : ( () ( (lv_start_1_0= ruleIdentifier ) ) (this_WS_2= RULE_WS )+ this_SKW_COLON_3= RULE_SKW_COLON this_SKW_ASSIGN_4= RULE_SKW_ASSIGN (this_WS_5= RULE_WS )+ ( ( (lv_arguments_6_0= ruleArgument ) ) ( (this_WS_7= RULE_WS )+ ( (lv_arguments_8_0= ruleArgument ) ) )* ) ) ;
    public final EObject ruleCmdLine() throws RecognitionException {
        EObject current = null;

        Token this_WS_2=null;
        Token this_SKW_COLON_3=null;
        Token this_SKW_ASSIGN_4=null;
        Token this_WS_5=null;
        Token this_WS_7=null;
        AntlrDatatypeRuleToken lv_start_1_0 = null;

        EObject lv_arguments_6_0 = null;

        EObject lv_arguments_8_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:144:28: ( ( () ( (lv_start_1_0= ruleIdentifier ) ) (this_WS_2= RULE_WS )+ this_SKW_COLON_3= RULE_SKW_COLON this_SKW_ASSIGN_4= RULE_SKW_ASSIGN (this_WS_5= RULE_WS )+ ( ( (lv_arguments_6_0= ruleArgument ) ) ( (this_WS_7= RULE_WS )+ ( (lv_arguments_8_0= ruleArgument ) ) )* ) ) )
            // InternalCmdArgsParser.g:145:1: ( () ( (lv_start_1_0= ruleIdentifier ) ) (this_WS_2= RULE_WS )+ this_SKW_COLON_3= RULE_SKW_COLON this_SKW_ASSIGN_4= RULE_SKW_ASSIGN (this_WS_5= RULE_WS )+ ( ( (lv_arguments_6_0= ruleArgument ) ) ( (this_WS_7= RULE_WS )+ ( (lv_arguments_8_0= ruleArgument ) ) )* ) )
            {
            // InternalCmdArgsParser.g:145:1: ( () ( (lv_start_1_0= ruleIdentifier ) ) (this_WS_2= RULE_WS )+ this_SKW_COLON_3= RULE_SKW_COLON this_SKW_ASSIGN_4= RULE_SKW_ASSIGN (this_WS_5= RULE_WS )+ ( ( (lv_arguments_6_0= ruleArgument ) ) ( (this_WS_7= RULE_WS )+ ( (lv_arguments_8_0= ruleArgument ) ) )* ) )
            // InternalCmdArgsParser.g:145:2: () ( (lv_start_1_0= ruleIdentifier ) ) (this_WS_2= RULE_WS )+ this_SKW_COLON_3= RULE_SKW_COLON this_SKW_ASSIGN_4= RULE_SKW_ASSIGN (this_WS_5= RULE_WS )+ ( ( (lv_arguments_6_0= ruleArgument ) ) ( (this_WS_7= RULE_WS )+ ( (lv_arguments_8_0= ruleArgument ) ) )* )
            {
            // InternalCmdArgsParser.g:145:2: ()
            // InternalCmdArgsParser.g:146:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCmdLineAccess().getCmdLineAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:151:2: ( (lv_start_1_0= ruleIdentifier ) )
            // InternalCmdArgsParser.g:152:1: (lv_start_1_0= ruleIdentifier )
            {
            // InternalCmdArgsParser.g:152:1: (lv_start_1_0= ruleIdentifier )
            // InternalCmdArgsParser.g:153:3: lv_start_1_0= ruleIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getCmdLineAccess().getStartIdentifierParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_5);
            lv_start_1_0=ruleIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCmdLineRule());
            	        }
                   		set(
                   			current, 
                   			"start",
                    		lv_start_1_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
            	        afterParserOrEnumRuleCall();
            	    

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
                    lv_incDir_3_0=(Token)match(input,RULE_KW_INCDIR,FOLLOW_11); 

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
                    	    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_12); 
                    	     
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
                    this_SKW_MINUS_9=(Token)match(input,RULE_SKW_MINUS,FOLLOW_13); 
                     
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
                    	    this_WS_11=(Token)match(input,RULE_WS,FOLLOW_12); 
                    	     
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
                    	    this_WS_14=(Token)match(input,RULE_WS,FOLLOW_12); 
                    	     
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
                    	    this_WS_17=(Token)match(input,RULE_WS,FOLLOW_12); 
                    	     
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
                    this_SKW_MINUS_19=(Token)match(input,RULE_SKW_MINUS,FOLLOW_14); 
                     
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
                            this_SKW_MINUS_20=(Token)match(input,RULE_SKW_MINUS,FOLLOW_15); 
                             
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
            this_SKW_MINUS_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_16); 

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
            this_SKW_MINUS_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_17); 

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
            alt16 = dfa16.predict(input);
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
    // InternalCmdArgsParser.g:651:1: ruleSimpleMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) ) ;
    public final EObject ruleSimpleMacro() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:654:28: ( ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) ) )
            // InternalCmdArgsParser.g:655:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) )
            {
            // InternalCmdArgsParser.g:655:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) )
            // InternalCmdArgsParser.g:655:2: () ( (lv_name_1_0= ruleMacroLegalPart ) )
            {
            // InternalCmdArgsParser.g:655:2: ()
            // InternalCmdArgsParser.g:656:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSimpleMacroAccess().getSimpleMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:661:2: ( (lv_name_1_0= ruleMacroLegalPart ) )
            // InternalCmdArgsParser.g:662:1: (lv_name_1_0= ruleMacroLegalPart )
            {
            // InternalCmdArgsParser.g:662:1: (lv_name_1_0= ruleMacroLegalPart )
            // InternalCmdArgsParser.g:663:3: lv_name_1_0= ruleMacroLegalPart
            {
             
            	        newCompositeNode(grammarAccess.getSimpleMacroAccess().getNameMacroLegalPartParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleMacroLegalPart();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSimpleMacroRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.MacroLegalPart");
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
    // InternalCmdArgsParser.g:696:1: ruleObjectMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) ) ;
    public final EObject ruleObjectMacro() throws RecognitionException {
        EObject current = null;

        Token this_SKW_ASSIGN_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:699:28: ( ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) ) )
            // InternalCmdArgsParser.g:700:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) )
            {
            // InternalCmdArgsParser.g:700:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) )
            // InternalCmdArgsParser.g:700:2: () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) )
            {
            // InternalCmdArgsParser.g:700:2: ()
            // InternalCmdArgsParser.g:701:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getObjectMacroAccess().getObjectMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:706:2: ( (lv_name_1_0= ruleMacroLegalPart ) )
            // InternalCmdArgsParser.g:707:1: (lv_name_1_0= ruleMacroLegalPart )
            {
            // InternalCmdArgsParser.g:707:1: (lv_name_1_0= ruleMacroLegalPart )
            // InternalCmdArgsParser.g:708:3: lv_name_1_0= ruleMacroLegalPart
            {
             
            	        newCompositeNode(grammarAccess.getObjectMacroAccess().getNameMacroLegalPartParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_7);
            lv_name_1_0=ruleMacroLegalPart();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getObjectMacroRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.MacroLegalPart");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_SKW_ASSIGN_2=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_18); 
             
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
    // InternalCmdArgsParser.g:763:1: ruleFunctionMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) ) ;
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
            // InternalCmdArgsParser.g:766:28: ( ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) ) )
            // InternalCmdArgsParser.g:767:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) )
            {
            // InternalCmdArgsParser.g:767:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) )
            // InternalCmdArgsParser.g:767:2: () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) )
            {
            // InternalCmdArgsParser.g:767:2: ()
            // InternalCmdArgsParser.g:768:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFunctionMacroAccess().getFunctionMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:773:2: ( (lv_name_1_0= ruleMacroLegalPart ) )
            // InternalCmdArgsParser.g:774:1: (lv_name_1_0= ruleMacroLegalPart )
            {
            // InternalCmdArgsParser.g:774:1: (lv_name_1_0= ruleMacroLegalPart )
            // InternalCmdArgsParser.g:775:3: lv_name_1_0= ruleMacroLegalPart
            {
             
            	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getNameMacroLegalPartParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_19);
            lv_name_1_0=ruleMacroLegalPart();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFunctionMacroRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.MacroLegalPart");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_SKW_LEFTPAREN_2=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_20); 
             
                newLeafNode(this_SKW_LEFTPAREN_2, grammarAccess.getFunctionMacroAccess().getSKW_LEFTPARENTerminalRuleCall_2()); 
                
            // InternalCmdArgsParser.g:795:1: ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_KW_NOSTDINC && LA18_0<=RULE_KW_VAR)||LA18_0==RULE_ID||LA18_0==RULE_ANY_OTHER) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalCmdArgsParser.g:795:2: ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )*
                    {
                    // InternalCmdArgsParser.g:795:2: ( (lv_params_3_0= ruleMacroLegalPart ) )
                    // InternalCmdArgsParser.g:796:1: (lv_params_3_0= ruleMacroLegalPart )
                    {
                    // InternalCmdArgsParser.g:796:1: (lv_params_3_0= ruleMacroLegalPart )
                    // InternalCmdArgsParser.g:797:3: lv_params_3_0= ruleMacroLegalPart
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getParamsMacroLegalPartParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_21);
                    lv_params_3_0=ruleMacroLegalPart();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFunctionMacroRule());
                    	        }
                           		add(
                           			current, 
                           			"params",
                            		lv_params_3_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.MacroLegalPart");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalCmdArgsParser.g:813:2: (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_SKW_COMMA) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:813:3: this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) )
                    	    {
                    	    this_SKW_COMMA_4=(Token)match(input,RULE_SKW_COMMA,FOLLOW_22); 
                    	     
                    	        newLeafNode(this_SKW_COMMA_4, grammarAccess.getFunctionMacroAccess().getSKW_COMMATerminalRuleCall_3_1_0()); 
                    	        
                    	    // InternalCmdArgsParser.g:817:1: ( (lv_params_5_0= ruleMacroLegalPart ) )
                    	    // InternalCmdArgsParser.g:818:1: (lv_params_5_0= ruleMacroLegalPart )
                    	    {
                    	    // InternalCmdArgsParser.g:818:1: (lv_params_5_0= ruleMacroLegalPart )
                    	    // InternalCmdArgsParser.g:819:3: lv_params_5_0= ruleMacroLegalPart
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getParamsMacroLegalPartParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_21);
                    	    lv_params_5_0=ruleMacroLegalPart();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFunctionMacroRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"params",
                    	            		lv_params_5_0, 
                    	            		"at.jku.weiner.c.cmdarguments.CmdArgs.MacroLegalPart");
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
                
            this_SKW_ASSIGN_7=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_18); 
             
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
    // InternalCmdArgsParser.g:923:1: rulePathCmd returns [EObject current=null] : ( () ( (lv_path_1_0= rulePathLegalPart ) ) ) ;
    public final EObject rulePathCmd() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_path_1_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:926:28: ( ( () ( (lv_path_1_0= rulePathLegalPart ) ) ) )
            // InternalCmdArgsParser.g:927:1: ( () ( (lv_path_1_0= rulePathLegalPart ) ) )
            {
            // InternalCmdArgsParser.g:927:1: ( () ( (lv_path_1_0= rulePathLegalPart ) ) )
            // InternalCmdArgsParser.g:927:2: () ( (lv_path_1_0= rulePathLegalPart ) )
            {
            // InternalCmdArgsParser.g:927:2: ()
            // InternalCmdArgsParser.g:928:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPathCmdAccess().getPathCmdAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:933:2: ( (lv_path_1_0= rulePathLegalPart ) )
            // InternalCmdArgsParser.g:934:1: (lv_path_1_0= rulePathLegalPart )
            {
            // InternalCmdArgsParser.g:934:1: (lv_path_1_0= rulePathLegalPart )
            // InternalCmdArgsParser.g:935:3: lv_path_1_0= rulePathLegalPart
            {
             
            	        newCompositeNode(grammarAccess.getPathCmdAccess().getPathPathLegalPartParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_path_1_0=rulePathLegalPart();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPathCmdRule());
            	        }
                   		set(
                   			current, 
                   			"path",
                    		lv_path_1_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.PathLegalPart");
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
    // $ANTLR end "rulePathCmd"


    // $ANTLR start "entryRulePathLegalPart"
    // InternalCmdArgsParser.g:959:1: entryRulePathLegalPart returns [String current=null] : iv_rulePathLegalPart= rulePathLegalPart EOF ;
    public final String entryRulePathLegalPart() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePathLegalPart = null;


        try {
            // InternalCmdArgsParser.g:960:1: (iv_rulePathLegalPart= rulePathLegalPart EOF )
            // InternalCmdArgsParser.g:961:2: iv_rulePathLegalPart= rulePathLegalPart EOF
            {
             newCompositeNode(grammarAccess.getPathLegalPartRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathLegalPart=rulePathLegalPart();

            state._fsp--;

             current =iv_rulePathLegalPart.getText(); 
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
    // $ANTLR end "entryRulePathLegalPart"


    // $ANTLR start "rulePathLegalPart"
    // InternalCmdArgsParser.g:968:1: rulePathLegalPart returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_KW_NOSTDINC_2= RULE_KW_NOSTDINC | this_KW_INCSYS_3= RULE_KW_INCSYS | this_KW_INCLUDE_4= RULE_KW_INCLUDE ) ;
    public final AntlrDatatypeRuleToken rulePathLegalPart() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING2_1=null;
        Token this_KW_NOSTDINC_2=null;
        Token this_KW_INCSYS_3=null;
        Token this_KW_INCLUDE_4=null;
        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:972:6: ( (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_KW_NOSTDINC_2= RULE_KW_NOSTDINC | this_KW_INCSYS_3= RULE_KW_INCSYS | this_KW_INCLUDE_4= RULE_KW_INCLUDE ) )
            // InternalCmdArgsParser.g:973:1: (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_KW_NOSTDINC_2= RULE_KW_NOSTDINC | this_KW_INCSYS_3= RULE_KW_INCSYS | this_KW_INCLUDE_4= RULE_KW_INCLUDE )
            {
            // InternalCmdArgsParser.g:973:1: (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_KW_NOSTDINC_2= RULE_KW_NOSTDINC | this_KW_INCSYS_3= RULE_KW_INCSYS | this_KW_INCLUDE_4= RULE_KW_INCLUDE )
            int alt19=5;
            switch ( input.LA(1) ) {
            case RULE_KW_VAR:
            case RULE_ID:
                {
                alt19=1;
                }
                break;
            case RULE_STRING2:
                {
                alt19=2;
                }
                break;
            case RULE_KW_NOSTDINC:
                {
                alt19=3;
                }
                break;
            case RULE_KW_INCSYS:
                {
                alt19=4;
                }
                break;
            case RULE_KW_INCLUDE:
                {
                alt19=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalCmdArgsParser.g:974:5: this_Identifier_0= ruleIdentifier
                    {
                     
                            newCompositeNode(grammarAccess.getPathLegalPartAccess().getIdentifierParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Identifier_0=ruleIdentifier();

                    state._fsp--;


                    		current.merge(this_Identifier_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:985:10: this_STRING2_1= RULE_STRING2
                    {
                    this_STRING2_1=(Token)match(input,RULE_STRING2,FOLLOW_2); 

                    		current.merge(this_STRING2_1);
                        
                     
                        newLeafNode(this_STRING2_1, grammarAccess.getPathLegalPartAccess().getSTRING2TerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalCmdArgsParser.g:993:10: this_KW_NOSTDINC_2= RULE_KW_NOSTDINC
                    {
                    this_KW_NOSTDINC_2=(Token)match(input,RULE_KW_NOSTDINC,FOLLOW_2); 

                    		current.merge(this_KW_NOSTDINC_2);
                        
                     
                        newLeafNode(this_KW_NOSTDINC_2, grammarAccess.getPathLegalPartAccess().getKW_NOSTDINCTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalCmdArgsParser.g:1001:10: this_KW_INCSYS_3= RULE_KW_INCSYS
                    {
                    this_KW_INCSYS_3=(Token)match(input,RULE_KW_INCSYS,FOLLOW_2); 

                    		current.merge(this_KW_INCSYS_3);
                        
                     
                        newLeafNode(this_KW_INCSYS_3, grammarAccess.getPathLegalPartAccess().getKW_INCSYSTerminalRuleCall_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalCmdArgsParser.g:1009:10: this_KW_INCLUDE_4= RULE_KW_INCLUDE
                    {
                    this_KW_INCLUDE_4=(Token)match(input,RULE_KW_INCLUDE,FOLLOW_2); 

                    		current.merge(this_KW_INCLUDE_4);
                        
                     
                        newLeafNode(this_KW_INCLUDE_4, grammarAccess.getPathLegalPartAccess().getKW_INCLUDETerminalRuleCall_4()); 
                        

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
    // $ANTLR end "rulePathLegalPart"


    // $ANTLR start "entryRuleMacroLegalPart"
    // InternalCmdArgsParser.g:1024:1: entryRuleMacroLegalPart returns [String current=null] : iv_ruleMacroLegalPart= ruleMacroLegalPart EOF ;
    public final String entryRuleMacroLegalPart() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMacroLegalPart = null;


        try {
            // InternalCmdArgsParser.g:1025:1: (iv_ruleMacroLegalPart= ruleMacroLegalPart EOF )
            // InternalCmdArgsParser.g:1026:2: iv_ruleMacroLegalPart= ruleMacroLegalPart EOF
            {
             newCompositeNode(grammarAccess.getMacroLegalPartRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMacroLegalPart=ruleMacroLegalPart();

            state._fsp--;

             current =iv_ruleMacroLegalPart.getText(); 
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
    // $ANTLR end "entryRuleMacroLegalPart"


    // $ANTLR start "ruleMacroLegalPart"
    // InternalCmdArgsParser.g:1033:1: ruleMacroLegalPart returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Identifier_0= ruleIdentifier | this_KW_NOSTDINC_1= RULE_KW_NOSTDINC | this_KW_INCSYS_2= RULE_KW_INCSYS | this_KW_INCLUDE_3= RULE_KW_INCLUDE | this_ANY_OTHER_4= RULE_ANY_OTHER ) ;
    public final AntlrDatatypeRuleToken ruleMacroLegalPart() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_KW_NOSTDINC_1=null;
        Token this_KW_INCSYS_2=null;
        Token this_KW_INCLUDE_3=null;
        Token this_ANY_OTHER_4=null;
        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1037:6: ( (this_Identifier_0= ruleIdentifier | this_KW_NOSTDINC_1= RULE_KW_NOSTDINC | this_KW_INCSYS_2= RULE_KW_INCSYS | this_KW_INCLUDE_3= RULE_KW_INCLUDE | this_ANY_OTHER_4= RULE_ANY_OTHER ) )
            // InternalCmdArgsParser.g:1038:1: (this_Identifier_0= ruleIdentifier | this_KW_NOSTDINC_1= RULE_KW_NOSTDINC | this_KW_INCSYS_2= RULE_KW_INCSYS | this_KW_INCLUDE_3= RULE_KW_INCLUDE | this_ANY_OTHER_4= RULE_ANY_OTHER )
            {
            // InternalCmdArgsParser.g:1038:1: (this_Identifier_0= ruleIdentifier | this_KW_NOSTDINC_1= RULE_KW_NOSTDINC | this_KW_INCSYS_2= RULE_KW_INCSYS | this_KW_INCLUDE_3= RULE_KW_INCLUDE | this_ANY_OTHER_4= RULE_ANY_OTHER )
            int alt20=5;
            switch ( input.LA(1) ) {
            case RULE_KW_VAR:
            case RULE_ID:
                {
                alt20=1;
                }
                break;
            case RULE_KW_NOSTDINC:
                {
                alt20=2;
                }
                break;
            case RULE_KW_INCSYS:
                {
                alt20=3;
                }
                break;
            case RULE_KW_INCLUDE:
                {
                alt20=4;
                }
                break;
            case RULE_ANY_OTHER:
                {
                alt20=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalCmdArgsParser.g:1039:5: this_Identifier_0= ruleIdentifier
                    {
                     
                            newCompositeNode(grammarAccess.getMacroLegalPartAccess().getIdentifierParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Identifier_0=ruleIdentifier();

                    state._fsp--;


                    		current.merge(this_Identifier_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:1050:10: this_KW_NOSTDINC_1= RULE_KW_NOSTDINC
                    {
                    this_KW_NOSTDINC_1=(Token)match(input,RULE_KW_NOSTDINC,FOLLOW_2); 

                    		current.merge(this_KW_NOSTDINC_1);
                        
                     
                        newLeafNode(this_KW_NOSTDINC_1, grammarAccess.getMacroLegalPartAccess().getKW_NOSTDINCTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalCmdArgsParser.g:1058:10: this_KW_INCSYS_2= RULE_KW_INCSYS
                    {
                    this_KW_INCSYS_2=(Token)match(input,RULE_KW_INCSYS,FOLLOW_2); 

                    		current.merge(this_KW_INCSYS_2);
                        
                     
                        newLeafNode(this_KW_INCSYS_2, grammarAccess.getMacroLegalPartAccess().getKW_INCSYSTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalCmdArgsParser.g:1066:10: this_KW_INCLUDE_3= RULE_KW_INCLUDE
                    {
                    this_KW_INCLUDE_3=(Token)match(input,RULE_KW_INCLUDE,FOLLOW_2); 

                    		current.merge(this_KW_INCLUDE_3);
                        
                     
                        newLeafNode(this_KW_INCLUDE_3, grammarAccess.getMacroLegalPartAccess().getKW_INCLUDETerminalRuleCall_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalCmdArgsParser.g:1074:10: this_ANY_OTHER_4= RULE_ANY_OTHER
                    {
                    this_ANY_OTHER_4=(Token)match(input,RULE_ANY_OTHER,FOLLOW_2); 

                    		current.merge(this_ANY_OTHER_4);
                        
                     
                        newLeafNode(this_ANY_OTHER_4, grammarAccess.getMacroLegalPartAccess().getANY_OTHERTerminalRuleCall_4()); 
                        

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
    // $ANTLR end "ruleMacroLegalPart"


    // $ANTLR start "entryRuleMyCode"
    // InternalCmdArgsParser.g:1089:1: entryRuleMyCode returns [String current=null] : iv_ruleMyCode= ruleMyCode EOF ;
    public final String entryRuleMyCode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCode = null;


        try {
            // InternalCmdArgsParser.g:1090:1: (iv_ruleMyCode= ruleMyCode EOF )
            // InternalCmdArgsParser.g:1091:2: iv_ruleMyCode= ruleMyCode EOF
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
    // InternalCmdArgsParser.g:1098:1: ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN | this_KW_NOSTDINC_4= RULE_KW_NOSTDINC | this_KW_INCSYS_5= RULE_KW_INCSYS | this_KW_INCLUDE_6= RULE_KW_INCLUDE | this_ANY_OTHER_7= RULE_ANY_OTHER )+ ;
    public final AntlrDatatypeRuleToken ruleMyCode() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING2_1=null;
        Token this_SKW_LEFTPAREN_2=null;
        Token this_SKW_RIGHTPAREN_3=null;
        Token this_KW_NOSTDINC_4=null;
        Token this_KW_INCSYS_5=null;
        Token this_KW_INCLUDE_6=null;
        Token this_ANY_OTHER_7=null;
        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1102:6: ( (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN | this_KW_NOSTDINC_4= RULE_KW_NOSTDINC | this_KW_INCSYS_5= RULE_KW_INCSYS | this_KW_INCLUDE_6= RULE_KW_INCLUDE | this_ANY_OTHER_7= RULE_ANY_OTHER )+ )
            // InternalCmdArgsParser.g:1103:1: (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN | this_KW_NOSTDINC_4= RULE_KW_NOSTDINC | this_KW_INCSYS_5= RULE_KW_INCSYS | this_KW_INCLUDE_6= RULE_KW_INCLUDE | this_ANY_OTHER_7= RULE_ANY_OTHER )+
            {
            // InternalCmdArgsParser.g:1103:1: (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN | this_KW_NOSTDINC_4= RULE_KW_NOSTDINC | this_KW_INCSYS_5= RULE_KW_INCSYS | this_KW_INCLUDE_6= RULE_KW_INCLUDE | this_ANY_OTHER_7= RULE_ANY_OTHER )+
            int cnt21=0;
            loop21:
            do {
                int alt21=9;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1104:5: this_Identifier_0= ruleIdentifier
            	    {
            	     
            	            newCompositeNode(grammarAccess.getMyCodeAccess().getIdentifierParserRuleCall_0()); 
            	        
            	    pushFollow(FOLLOW_23);
            	    this_Identifier_0=ruleIdentifier();

            	    state._fsp--;


            	    		current.merge(this_Identifier_0);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;
            	case 2 :
            	    // InternalCmdArgsParser.g:1115:10: this_STRING2_1= RULE_STRING2
            	    {
            	    this_STRING2_1=(Token)match(input,RULE_STRING2,FOLLOW_23); 

            	    		current.merge(this_STRING2_1);
            	        
            	     
            	        newLeafNode(this_STRING2_1, grammarAccess.getMyCodeAccess().getSTRING2TerminalRuleCall_1()); 
            	        

            	    }
            	    break;
            	case 3 :
            	    // InternalCmdArgsParser.g:1123:10: this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN
            	    {
            	    this_SKW_LEFTPAREN_2=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_23); 

            	    		current.merge(this_SKW_LEFTPAREN_2);
            	        
            	     
            	        newLeafNode(this_SKW_LEFTPAREN_2, grammarAccess.getMyCodeAccess().getSKW_LEFTPARENTerminalRuleCall_2()); 
            	        

            	    }
            	    break;
            	case 4 :
            	    // InternalCmdArgsParser.g:1131:10: this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN
            	    {
            	    this_SKW_RIGHTPAREN_3=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_23); 

            	    		current.merge(this_SKW_RIGHTPAREN_3);
            	        
            	     
            	        newLeafNode(this_SKW_RIGHTPAREN_3, grammarAccess.getMyCodeAccess().getSKW_RIGHTPARENTerminalRuleCall_3()); 
            	        

            	    }
            	    break;
            	case 5 :
            	    // InternalCmdArgsParser.g:1139:10: this_KW_NOSTDINC_4= RULE_KW_NOSTDINC
            	    {
            	    this_KW_NOSTDINC_4=(Token)match(input,RULE_KW_NOSTDINC,FOLLOW_23); 

            	    		current.merge(this_KW_NOSTDINC_4);
            	        
            	     
            	        newLeafNode(this_KW_NOSTDINC_4, grammarAccess.getMyCodeAccess().getKW_NOSTDINCTerminalRuleCall_4()); 
            	        

            	    }
            	    break;
            	case 6 :
            	    // InternalCmdArgsParser.g:1147:10: this_KW_INCSYS_5= RULE_KW_INCSYS
            	    {
            	    this_KW_INCSYS_5=(Token)match(input,RULE_KW_INCSYS,FOLLOW_23); 

            	    		current.merge(this_KW_INCSYS_5);
            	        
            	     
            	        newLeafNode(this_KW_INCSYS_5, grammarAccess.getMyCodeAccess().getKW_INCSYSTerminalRuleCall_5()); 
            	        

            	    }
            	    break;
            	case 7 :
            	    // InternalCmdArgsParser.g:1155:10: this_KW_INCLUDE_6= RULE_KW_INCLUDE
            	    {
            	    this_KW_INCLUDE_6=(Token)match(input,RULE_KW_INCLUDE,FOLLOW_23); 

            	    		current.merge(this_KW_INCLUDE_6);
            	        
            	     
            	        newLeafNode(this_KW_INCLUDE_6, grammarAccess.getMyCodeAccess().getKW_INCLUDETerminalRuleCall_6()); 
            	        

            	    }
            	    break;
            	case 8 :
            	    // InternalCmdArgsParser.g:1163:10: this_ANY_OTHER_7= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_7=(Token)match(input,RULE_ANY_OTHER,FOLLOW_23); 

            	    		current.merge(this_ANY_OTHER_7);
            	        
            	     
            	        newLeafNode(this_ANY_OTHER_7, grammarAccess.getMyCodeAccess().getANY_OTHERTerminalRuleCall_7()); 
            	        

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
    // InternalCmdArgsParser.g:1178:1: entryRuleOption returns [String current=null] : iv_ruleOption= ruleOption EOF ;
    public final String entryRuleOption() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOption = null;


        try {
            // InternalCmdArgsParser.g:1179:1: (iv_ruleOption= ruleOption EOF )
            // InternalCmdArgsParser.g:1180:2: iv_ruleOption= ruleOption EOF
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
    // InternalCmdArgsParser.g:1187:1: ruleOption returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_OptionPart_0= ruleOptionPart )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )* ) ;
    public final AntlrDatatypeRuleToken ruleOption() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_COMMA_1=null;
        Token this_SKW_MINUS_2=null;
        AntlrDatatypeRuleToken this_OptionPart_0 = null;

        AntlrDatatypeRuleToken this_OptionPart_3 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1191:6: ( ( (this_OptionPart_0= ruleOptionPart )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )* ) )
            // InternalCmdArgsParser.g:1192:1: ( (this_OptionPart_0= ruleOptionPart )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )* )
            {
            // InternalCmdArgsParser.g:1192:1: ( (this_OptionPart_0= ruleOptionPart )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )* )
            // InternalCmdArgsParser.g:1192:2: (this_OptionPart_0= ruleOptionPart )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )*
            {
            // InternalCmdArgsParser.g:1192:2: (this_OptionPart_0= ruleOptionPart )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                alt22 = dfa22.predict(input);
                switch (alt22) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1193:5: this_OptionPart_0= ruleOptionPart
            	    {
            	     
            	            newCompositeNode(grammarAccess.getOptionAccess().getOptionPartParserRuleCall_0()); 
            	        
            	    pushFollow(FOLLOW_24);
            	    this_OptionPart_0=ruleOptionPart();

            	    state._fsp--;


            	    		current.merge(this_OptionPart_0);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);

            // InternalCmdArgsParser.g:1203:3: (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_SKW_COMMA) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1203:8: this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+
            	    {
            	    this_SKW_COMMA_1=(Token)match(input,RULE_SKW_COMMA,FOLLOW_25); 

            	    		current.merge(this_SKW_COMMA_1);
            	        
            	     
            	        newLeafNode(this_SKW_COMMA_1, grammarAccess.getOptionAccess().getSKW_COMMATerminalRuleCall_1_0()); 
            	        
            	    // InternalCmdArgsParser.g:1210:1: (this_SKW_MINUS_2= RULE_SKW_MINUS )?
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0==RULE_SKW_MINUS) ) {
            	        alt23=1;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // InternalCmdArgsParser.g:1210:6: this_SKW_MINUS_2= RULE_SKW_MINUS
            	            {
            	            this_SKW_MINUS_2=(Token)match(input,RULE_SKW_MINUS,FOLLOW_26); 

            	            		current.merge(this_SKW_MINUS_2);
            	                
            	             
            	                newLeafNode(this_SKW_MINUS_2, grammarAccess.getOptionAccess().getSKW_MINUSTerminalRuleCall_1_1()); 
            	                

            	            }
            	            break;

            	    }

            	    // InternalCmdArgsParser.g:1217:3: (this_OptionPart_3= ruleOptionPart )+
            	    int cnt24=0;
            	    loop24:
            	    do {
            	        int alt24=2;
            	        alt24 = dfa24.predict(input);
            	        switch (alt24) {
            	    	case 1 :
            	    	    // InternalCmdArgsParser.g:1218:5: this_OptionPart_3= ruleOptionPart
            	    	    {
            	    	     
            	    	            newCompositeNode(grammarAccess.getOptionAccess().getOptionPartParserRuleCall_1_2()); 
            	    	        
            	    	    pushFollow(FOLLOW_24);
            	    	    this_OptionPart_3=ruleOptionPart();

            	    	    state._fsp--;


            	    	    		current.merge(this_OptionPart_3);
            	    	        
            	    	     
            	    	            afterParserOrEnumRuleCall();
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt24 >= 1 ) break loop24;
            	                EarlyExitException eee =
            	                    new EarlyExitException(24, input);
            	                throw eee;
            	        }
            	        cnt24++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop25;
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


    // $ANTLR start "entryRuleOptionPart"
    // InternalCmdArgsParser.g:1236:1: entryRuleOptionPart returns [String current=null] : iv_ruleOptionPart= ruleOptionPart EOF ;
    public final String entryRuleOptionPart() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOptionPart = null;


        try {
            // InternalCmdArgsParser.g:1237:1: (iv_ruleOptionPart= ruleOptionPart EOF )
            // InternalCmdArgsParser.g:1238:2: iv_ruleOptionPart= ruleOptionPart EOF
            {
             newCompositeNode(grammarAccess.getOptionPartRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOptionPart=ruleOptionPart();

            state._fsp--;

             current =iv_ruleOptionPart.getText(); 
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
    // $ANTLR end "entryRuleOptionPart"


    // $ANTLR start "ruleOptionPart"
    // InternalCmdArgsParser.g:1245:1: ruleOptionPart returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_OptionLegalStart_0= ruleOptionLegalStart (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )* ) ;
    public final AntlrDatatypeRuleToken ruleOptionPart() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_OptionLegalStart_0 = null;

        AntlrDatatypeRuleToken this_OptionLegalContinuation_1 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1249:6: ( (this_OptionLegalStart_0= ruleOptionLegalStart (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )* ) )
            // InternalCmdArgsParser.g:1250:1: (this_OptionLegalStart_0= ruleOptionLegalStart (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )* )
            {
            // InternalCmdArgsParser.g:1250:1: (this_OptionLegalStart_0= ruleOptionLegalStart (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )* )
            // InternalCmdArgsParser.g:1251:5: this_OptionLegalStart_0= ruleOptionLegalStart (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )*
            {
             
                    newCompositeNode(grammarAccess.getOptionPartAccess().getOptionLegalStartParserRuleCall_0()); 
                
            pushFollow(FOLLOW_27);
            this_OptionLegalStart_0=ruleOptionLegalStart();

            state._fsp--;


            		current.merge(this_OptionLegalStart_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalCmdArgsParser.g:1261:1: (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_SKW_ASSIGN||(LA26_0>=RULE_KW_NOSTDINC && LA26_0<=RULE_KW_INCLUDE)||LA26_0==RULE_ANY_OTHER) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1262:5: this_OptionLegalContinuation_1= ruleOptionLegalContinuation
            	    {
            	     
            	            newCompositeNode(grammarAccess.getOptionPartAccess().getOptionLegalContinuationParserRuleCall_1()); 
            	        
            	    pushFollow(FOLLOW_27);
            	    this_OptionLegalContinuation_1=ruleOptionLegalContinuation();

            	    state._fsp--;


            	    		current.merge(this_OptionLegalContinuation_1);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // $ANTLR end "ruleOptionPart"


    // $ANTLR start "entryRuleOptionLegalStart"
    // InternalCmdArgsParser.g:1280:1: entryRuleOptionLegalStart returns [String current=null] : iv_ruleOptionLegalStart= ruleOptionLegalStart EOF ;
    public final String entryRuleOptionLegalStart() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOptionLegalStart = null;


        try {
            // InternalCmdArgsParser.g:1281:1: (iv_ruleOptionLegalStart= ruleOptionLegalStart EOF )
            // InternalCmdArgsParser.g:1282:2: iv_ruleOptionLegalStart= ruleOptionLegalStart EOF
            {
             newCompositeNode(grammarAccess.getOptionLegalStartRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOptionLegalStart=ruleOptionLegalStart();

            state._fsp--;

             current =iv_ruleOptionLegalStart.getText(); 
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
    // $ANTLR end "entryRuleOptionLegalStart"


    // $ANTLR start "ruleOptionLegalStart"
    // InternalCmdArgsParser.g:1289:1: ruleOptionLegalStart returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 ) ;
    public final AntlrDatatypeRuleToken ruleOptionLegalStart() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING2_1=null;
        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1293:6: ( (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 ) )
            // InternalCmdArgsParser.g:1294:1: (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 )
            {
            // InternalCmdArgsParser.g:1294:1: (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_KW_VAR||LA27_0==RULE_ID) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_STRING2) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalCmdArgsParser.g:1295:5: this_Identifier_0= ruleIdentifier
                    {
                     
                            newCompositeNode(grammarAccess.getOptionLegalStartAccess().getIdentifierParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Identifier_0=ruleIdentifier();

                    state._fsp--;


                    		current.merge(this_Identifier_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:1306:10: this_STRING2_1= RULE_STRING2
                    {
                    this_STRING2_1=(Token)match(input,RULE_STRING2,FOLLOW_2); 

                    		current.merge(this_STRING2_1);
                        
                     
                        newLeafNode(this_STRING2_1, grammarAccess.getOptionLegalStartAccess().getSTRING2TerminalRuleCall_1()); 
                        

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
    // $ANTLR end "ruleOptionLegalStart"


    // $ANTLR start "entryRuleOptionLegalContinuation"
    // InternalCmdArgsParser.g:1321:1: entryRuleOptionLegalContinuation returns [String current=null] : iv_ruleOptionLegalContinuation= ruleOptionLegalContinuation EOF ;
    public final String entryRuleOptionLegalContinuation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOptionLegalContinuation = null;


        try {
            // InternalCmdArgsParser.g:1322:1: (iv_ruleOptionLegalContinuation= ruleOptionLegalContinuation EOF )
            // InternalCmdArgsParser.g:1323:2: iv_ruleOptionLegalContinuation= ruleOptionLegalContinuation EOF
            {
             newCompositeNode(grammarAccess.getOptionLegalContinuationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOptionLegalContinuation=ruleOptionLegalContinuation();

            state._fsp--;

             current =iv_ruleOptionLegalContinuation.getText(); 
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
    // $ANTLR end "entryRuleOptionLegalContinuation"


    // $ANTLR start "ruleOptionLegalContinuation"
    // InternalCmdArgsParser.g:1330:1: ruleOptionLegalContinuation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_KW_NOSTDINC_0= RULE_KW_NOSTDINC | this_KW_INCSYS_1= RULE_KW_INCSYS | this_KW_INCLUDE_2= RULE_KW_INCLUDE | this_SKW_ASSIGN_3= RULE_SKW_ASSIGN | this_ANY_OTHER_4= RULE_ANY_OTHER ) ;
    public final AntlrDatatypeRuleToken ruleOptionLegalContinuation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_KW_NOSTDINC_0=null;
        Token this_KW_INCSYS_1=null;
        Token this_KW_INCLUDE_2=null;
        Token this_SKW_ASSIGN_3=null;
        Token this_ANY_OTHER_4=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1334:6: ( (this_KW_NOSTDINC_0= RULE_KW_NOSTDINC | this_KW_INCSYS_1= RULE_KW_INCSYS | this_KW_INCLUDE_2= RULE_KW_INCLUDE | this_SKW_ASSIGN_3= RULE_SKW_ASSIGN | this_ANY_OTHER_4= RULE_ANY_OTHER ) )
            // InternalCmdArgsParser.g:1335:1: (this_KW_NOSTDINC_0= RULE_KW_NOSTDINC | this_KW_INCSYS_1= RULE_KW_INCSYS | this_KW_INCLUDE_2= RULE_KW_INCLUDE | this_SKW_ASSIGN_3= RULE_SKW_ASSIGN | this_ANY_OTHER_4= RULE_ANY_OTHER )
            {
            // InternalCmdArgsParser.g:1335:1: (this_KW_NOSTDINC_0= RULE_KW_NOSTDINC | this_KW_INCSYS_1= RULE_KW_INCSYS | this_KW_INCLUDE_2= RULE_KW_INCLUDE | this_SKW_ASSIGN_3= RULE_SKW_ASSIGN | this_ANY_OTHER_4= RULE_ANY_OTHER )
            int alt28=5;
            switch ( input.LA(1) ) {
            case RULE_KW_NOSTDINC:
                {
                alt28=1;
                }
                break;
            case RULE_KW_INCSYS:
                {
                alt28=2;
                }
                break;
            case RULE_KW_INCLUDE:
                {
                alt28=3;
                }
                break;
            case RULE_SKW_ASSIGN:
                {
                alt28=4;
                }
                break;
            case RULE_ANY_OTHER:
                {
                alt28=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalCmdArgsParser.g:1335:6: this_KW_NOSTDINC_0= RULE_KW_NOSTDINC
                    {
                    this_KW_NOSTDINC_0=(Token)match(input,RULE_KW_NOSTDINC,FOLLOW_2); 

                    		current.merge(this_KW_NOSTDINC_0);
                        
                     
                        newLeafNode(this_KW_NOSTDINC_0, grammarAccess.getOptionLegalContinuationAccess().getKW_NOSTDINCTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:1343:10: this_KW_INCSYS_1= RULE_KW_INCSYS
                    {
                    this_KW_INCSYS_1=(Token)match(input,RULE_KW_INCSYS,FOLLOW_2); 

                    		current.merge(this_KW_INCSYS_1);
                        
                     
                        newLeafNode(this_KW_INCSYS_1, grammarAccess.getOptionLegalContinuationAccess().getKW_INCSYSTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalCmdArgsParser.g:1351:10: this_KW_INCLUDE_2= RULE_KW_INCLUDE
                    {
                    this_KW_INCLUDE_2=(Token)match(input,RULE_KW_INCLUDE,FOLLOW_2); 

                    		current.merge(this_KW_INCLUDE_2);
                        
                     
                        newLeafNode(this_KW_INCLUDE_2, grammarAccess.getOptionLegalContinuationAccess().getKW_INCLUDETerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalCmdArgsParser.g:1359:10: this_SKW_ASSIGN_3= RULE_SKW_ASSIGN
                    {
                    this_SKW_ASSIGN_3=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_2); 

                    		current.merge(this_SKW_ASSIGN_3);
                        
                     
                        newLeafNode(this_SKW_ASSIGN_3, grammarAccess.getOptionLegalContinuationAccess().getSKW_ASSIGNTerminalRuleCall_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalCmdArgsParser.g:1367:10: this_ANY_OTHER_4= RULE_ANY_OTHER
                    {
                    this_ANY_OTHER_4=(Token)match(input,RULE_ANY_OTHER,FOLLOW_2); 

                    		current.merge(this_ANY_OTHER_4);
                        
                     
                        newLeafNode(this_ANY_OTHER_4, grammarAccess.getOptionLegalContinuationAccess().getANY_OTHERTerminalRuleCall_4()); 
                        

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
    // $ANTLR end "ruleOptionLegalContinuation"


    // $ANTLR start "entryRuleIdentifier"
    // InternalCmdArgsParser.g:1382:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalCmdArgsParser.g:1383:1: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalCmdArgsParser.g:1384:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalCmdArgsParser.g:1391:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_KW_VAR_1= RULE_KW_VAR ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_KW_VAR_1=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1395:6: ( (this_ID_0= RULE_ID | this_KW_VAR_1= RULE_KW_VAR ) )
            // InternalCmdArgsParser.g:1396:1: (this_ID_0= RULE_ID | this_KW_VAR_1= RULE_KW_VAR )
            {
            // InternalCmdArgsParser.g:1396:1: (this_ID_0= RULE_ID | this_KW_VAR_1= RULE_KW_VAR )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            else if ( (LA29_0==RULE_KW_VAR) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalCmdArgsParser.g:1396:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:1404:10: this_KW_VAR_1= RULE_KW_VAR
                    {
                    this_KW_VAR_1=(Token)match(input,RULE_KW_VAR,FOLLOW_2); 

                    		current.merge(this_KW_VAR_1);
                        
                     
                        newLeafNode(this_KW_VAR_1, grammarAccess.getIdentifierAccess().getKW_VARTerminalRuleCall_1()); 
                        

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
    // $ANTLR end "ruleIdentifier"

    // Delegated rules


    protected DFA15 dfa15 = new DFA15(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA24 dfa24 = new DFA24(this);
    static final String DFA15_eotS =
        "\13\uffff";
    static final String DFA15_eofS =
        "\3\uffff\1\10\7\uffff";
    static final String DFA15_minS =
        "\1\7\2\uffff\1\7\7\uffff";
    static final String DFA15_maxS =
        "\1\30\2\uffff\1\36\7\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\6\1\7\1\11\1\4\1\10\1\3\1\5";
    static final String DFA15_specialS =
        "\13\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\3\6\uffff\1\1\1\2\1\4\1\5\3\uffff\1\6\2\uffff\1\6",
            "",
            "",
            "\1\10\12\uffff\1\7\1\11\1\12\1\10\2\uffff\1\10\3\uffff\3\10",
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
        "\6\uffff";
    static final String DFA14_eofS =
        "\1\4\2\3\3\uffff";
    static final String DFA14_minS =
        "\1\25\2\10\2\uffff\1\6";
    static final String DFA14_maxS =
        "\1\36\2\42\2\uffff\1\36";
    static final String DFA14_acceptS =
        "\3\uffff\1\1\1\2\1\uffff";
    static final String DFA14_specialS =
        "\6\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\2\2\uffff\1\1\3\uffff\1\3\2\4",
            "\1\3\2\uffff\1\3\6\uffff\4\3\2\uffff\1\3\3\uffff\2\3\1\5\3\uffff\1\3",
            "\1\3\2\uffff\1\3\6\uffff\4\3\2\uffff\1\3\3\uffff\2\3\1\5\3\uffff\1\3",
            "",
            "",
            "\1\4\1\3\6\uffff\4\3\3\uffff\1\3\2\uffff\1\3\5\uffff\1\5"
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
    static final String DFA16_eotS =
        "\13\uffff";
    static final String DFA16_eofS =
        "\1\uffff\6\11\4\uffff";
    static final String DFA16_minS =
        "\1\22\6\10\4\uffff";
    static final String DFA16_maxS =
        "\1\42\6\36\4\uffff";
    static final String DFA16_acceptS =
        "\7\uffff\1\4\1\3\1\1\1\2";
    static final String DFA16_specialS =
        "\13\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\3\1\4\1\5\1\2\2\uffff\1\1\3\uffff\1\7\5\uffff\1\6",
            "\1\12\1\10\13\uffff\1\11\2\uffff\1\11\4\uffff\2\11",
            "\1\12\1\10\13\uffff\1\11\2\uffff\1\11\4\uffff\2\11",
            "\1\12\1\10\13\uffff\1\11\2\uffff\1\11\4\uffff\2\11",
            "\1\12\1\10\13\uffff\1\11\2\uffff\1\11\4\uffff\2\11",
            "\1\12\1\10\13\uffff\1\11\2\uffff\1\11\4\uffff\2\11",
            "\1\12\1\10\13\uffff\1\11\2\uffff\1\11\4\uffff\2\11",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "595:1: (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro | this_StringMacro_3= ruleStringMacro )";
        }
    }
    static final String DFA21_eotS =
        "\15\uffff";
    static final String DFA21_eofS =
        "\1\1\1\uffff\2\14\11\uffff";
    static final String DFA21_minS =
        "\1\11\1\uffff\2\11\7\uffff\1\6\1\uffff";
    static final String DFA21_maxS =
        "\1\42\1\uffff\2\42\7\uffff\1\36\1\uffff";
    static final String DFA21_acceptS =
        "\1\uffff\1\11\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\1";
    static final String DFA21_specialS =
        "\15\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\5\1\6\7\uffff\1\7\1\10\1\11\1\3\2\uffff\1\2\3\uffff\1\4\2\1\3\uffff\1\12",
            "",
            "\2\14\7\uffff\4\14\2\uffff\1\14\3\uffff\2\14\1\13\3\uffff\1\14",
            "\2\14\7\uffff\4\14\2\uffff\1\14\3\uffff\2\14\1\13\3\uffff\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\1\1\14\6\uffff\4\14\3\uffff\1\14\2\uffff\1\14\5\uffff\1\13",
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
            return "()+ loopback of 1103:1: (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN | this_KW_NOSTDINC_4= RULE_KW_NOSTDINC | this_KW_INCSYS_5= RULE_KW_INCSYS | this_KW_INCLUDE_6= RULE_KW_INCLUDE | this_ANY_OTHER_7= RULE_ANY_OTHER )+";
        }
    }
    static final String DFA22_eotS =
        "\6\uffff";
    static final String DFA22_eofS =
        "\1\1\1\uffff\2\4\2\uffff";
    static final String DFA22_minS =
        "\1\13\1\uffff\2\10\1\uffff\1\6";
    static final String DFA22_maxS =
        "\1\36\1\uffff\2\42\1\uffff\1\36";
    static final String DFA22_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\1\uffff";
    static final String DFA22_specialS =
        "\6\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1\11\uffff\1\3\2\uffff\1\2\3\uffff\1\4\2\1",
            "",
            "\1\4\2\uffff\1\4\6\uffff\4\4\2\uffff\1\4\3\uffff\2\4\1\5\3\uffff\1\4",
            "\1\4\2\uffff\1\4\6\uffff\4\4\2\uffff\1\4\3\uffff\2\4\1\5\3\uffff\1\4",
            "",
            "\1\1\1\4\6\uffff\4\4\3\uffff\1\4\2\uffff\1\4\5\uffff\1\5"
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
            return "()+ loopback of 1192:2: (this_OptionPart_0= ruleOptionPart )+";
        }
    }
    static final String DFA24_eotS =
        "\6\uffff";
    static final String DFA24_eofS =
        "\1\1\1\uffff\2\4\2\uffff";
    static final String DFA24_minS =
        "\1\13\1\uffff\2\10\1\uffff\1\6";
    static final String DFA24_maxS =
        "\1\36\1\uffff\2\42\1\uffff\1\36";
    static final String DFA24_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\1\uffff";
    static final String DFA24_specialS =
        "\6\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\1\11\uffff\1\3\2\uffff\1\2\3\uffff\1\4\2\1",
            "",
            "\1\4\2\uffff\1\4\6\uffff\4\4\2\uffff\1\4\3\uffff\2\4\1\5\3\uffff\1\4",
            "\1\4\2\uffff\1\4\6\uffff\4\4\2\uffff\1\4\3\uffff\2\4\1\5\3\uffff\1\4",
            "",
            "\1\1\1\4\6\uffff\4\4\3\uffff\1\4\2\uffff\1\4\5\uffff\1\5"
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
            return "()+ loopback of 1217:3: (this_OptionPart_3= ruleOptionPart )+";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000021200002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000021200000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000040000040L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000006123C080L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000004313C0000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000313C0000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000713C0000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000031200082L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000031200002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000004313C0600L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000004213C0400L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000004213C0000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000004313C0602L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000031200802L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000031200080L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000031200000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00000004001C0102L});

}