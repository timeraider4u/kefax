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
    // InternalCmdArgsParser.g:141:1: ruleCmdLine returns [EObject current=null] : (this_Assignment_0= ruleAssignment | this_Target_1= ruleTarget ) ;
    public final EObject ruleCmdLine() throws RecognitionException {
        EObject current = null;

        EObject this_Assignment_0 = null;

        EObject this_Target_1 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:144:28: ( (this_Assignment_0= ruleAssignment | this_Target_1= ruleTarget ) )
            // InternalCmdArgsParser.g:145:1: (this_Assignment_0= ruleAssignment | this_Target_1= ruleTarget )
            {
            // InternalCmdArgsParser.g:145:1: (this_Assignment_0= ruleAssignment | this_Target_1= ruleTarget )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalCmdArgsParser.g:146:5: this_Assignment_0= ruleAssignment
                    {
                     
                            newCompositeNode(grammarAccess.getCmdLineAccess().getAssignmentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Assignment_0=ruleAssignment();

                    state._fsp--;


                            current = this_Assignment_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:156:5: this_Target_1= ruleTarget
                    {
                     
                            newCompositeNode(grammarAccess.getCmdLineAccess().getTargetParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Target_1=ruleTarget();

                    state._fsp--;


                            current = this_Target_1;
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
    // $ANTLR end "ruleCmdLine"


    // $ANTLR start "entryRuleTarget"
    // InternalCmdArgsParser.g:172:1: entryRuleTarget returns [EObject current=null] : iv_ruleTarget= ruleTarget EOF ;
    public final EObject entryRuleTarget() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTarget = null;


        try {
            // InternalCmdArgsParser.g:173:2: (iv_ruleTarget= ruleTarget EOF )
            // InternalCmdArgsParser.g:174:2: iv_ruleTarget= ruleTarget EOF
            {
             newCompositeNode(grammarAccess.getTargetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTarget=ruleTarget();

            state._fsp--;

             current =iv_ruleTarget; 
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
    // $ANTLR end "entryRuleTarget"


    // $ANTLR start "ruleTarget"
    // InternalCmdArgsParser.g:181:1: ruleTarget returns [EObject current=null] : ( ( (lv_start_0_0= ruleIdentifier ) ) this_SKW_COLON_1= RULE_SKW_COLON ( ruleFillUp ( (lv_arguments_3_0= ruleArgument ) ) )* (this_WS_4= RULE_WS )* this_NEWLINE_5= RULE_NEWLINE ) ;
    public final EObject ruleTarget() throws RecognitionException {
        EObject current = null;

        Token this_SKW_COLON_1=null;
        Token this_WS_4=null;
        Token this_NEWLINE_5=null;
        AntlrDatatypeRuleToken lv_start_0_0 = null;

        EObject lv_arguments_3_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:184:28: ( ( ( (lv_start_0_0= ruleIdentifier ) ) this_SKW_COLON_1= RULE_SKW_COLON ( ruleFillUp ( (lv_arguments_3_0= ruleArgument ) ) )* (this_WS_4= RULE_WS )* this_NEWLINE_5= RULE_NEWLINE ) )
            // InternalCmdArgsParser.g:185:1: ( ( (lv_start_0_0= ruleIdentifier ) ) this_SKW_COLON_1= RULE_SKW_COLON ( ruleFillUp ( (lv_arguments_3_0= ruleArgument ) ) )* (this_WS_4= RULE_WS )* this_NEWLINE_5= RULE_NEWLINE )
            {
            // InternalCmdArgsParser.g:185:1: ( ( (lv_start_0_0= ruleIdentifier ) ) this_SKW_COLON_1= RULE_SKW_COLON ( ruleFillUp ( (lv_arguments_3_0= ruleArgument ) ) )* (this_WS_4= RULE_WS )* this_NEWLINE_5= RULE_NEWLINE )
            // InternalCmdArgsParser.g:185:2: ( (lv_start_0_0= ruleIdentifier ) ) this_SKW_COLON_1= RULE_SKW_COLON ( ruleFillUp ( (lv_arguments_3_0= ruleArgument ) ) )* (this_WS_4= RULE_WS )* this_NEWLINE_5= RULE_NEWLINE
            {
            // InternalCmdArgsParser.g:185:2: ( (lv_start_0_0= ruleIdentifier ) )
            // InternalCmdArgsParser.g:186:1: (lv_start_0_0= ruleIdentifier )
            {
            // InternalCmdArgsParser.g:186:1: (lv_start_0_0= ruleIdentifier )
            // InternalCmdArgsParser.g:187:3: lv_start_0_0= ruleIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getTargetAccess().getStartIdentifierParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_5);
            lv_start_0_0=ruleIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTargetRule());
            	        }
                   		set(
                   			current, 
                   			"start",
                    		lv_start_0_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_SKW_COLON_1=(Token)match(input,RULE_SKW_COLON,FOLLOW_6); 
             
                newLeafNode(this_SKW_COLON_1, grammarAccess.getTargetAccess().getSKW_COLONTerminalRuleCall_1()); 
                
            // InternalCmdArgsParser.g:207:1: ( ruleFillUp ( (lv_arguments_3_0= ruleArgument ) ) )*
            loop6:
            do {
                int alt6=2;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // InternalCmdArgsParser.g:208:5: ruleFillUp ( (lv_arguments_3_0= ruleArgument ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTargetAccess().getFillUpParserRuleCall_2_0()); 
            	        
            	    pushFollow(FOLLOW_7);
            	    ruleFillUp();

            	    state._fsp--;


            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalCmdArgsParser.g:215:1: ( (lv_arguments_3_0= ruleArgument ) )
            	    // InternalCmdArgsParser.g:216:1: (lv_arguments_3_0= ruleArgument )
            	    {
            	    // InternalCmdArgsParser.g:216:1: (lv_arguments_3_0= ruleArgument )
            	    // InternalCmdArgsParser.g:217:3: lv_arguments_3_0= ruleArgument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTargetAccess().getArgumentsArgumentParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_arguments_3_0=ruleArgument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTargetRule());
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
            	    break loop6;
                }
            } while (true);

            // InternalCmdArgsParser.g:233:4: (this_WS_4= RULE_WS )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_WS) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalCmdArgsParser.g:233:5: this_WS_4= RULE_WS
            	    {
            	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_6); 
            	     
            	        newLeafNode(this_WS_4, grammarAccess.getTargetAccess().getWSTerminalRuleCall_3()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_2); 
             
                newLeafNode(this_NEWLINE_5, grammarAccess.getTargetAccess().getNEWLINETerminalRuleCall_4()); 
                

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
    // $ANTLR end "ruleTarget"


    // $ANTLR start "entryRuleFillUp"
    // InternalCmdArgsParser.g:249:1: entryRuleFillUp returns [String current=null] : iv_ruleFillUp= ruleFillUp EOF ;
    public final String entryRuleFillUp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFillUp = null;


        try {
            // InternalCmdArgsParser.g:250:1: (iv_ruleFillUp= ruleFillUp EOF )
            // InternalCmdArgsParser.g:251:2: iv_ruleFillUp= ruleFillUp EOF
            {
             newCompositeNode(grammarAccess.getFillUpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFillUp=ruleFillUp();

            state._fsp--;

             current =iv_ruleFillUp.getText(); 
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
    // $ANTLR end "entryRuleFillUp"


    // $ANTLR start "ruleFillUp"
    // InternalCmdArgsParser.g:258:1: ruleFillUp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WS_0= RULE_WS )+ | ( (this_WS_1= RULE_WS )* this_NEWLINE_2= RULE_NEWLINE (this_WS_3= RULE_WS )+ ) ) ;
    public final AntlrDatatypeRuleToken ruleFillUp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_0=null;
        Token this_WS_1=null;
        Token this_NEWLINE_2=null;
        Token this_WS_3=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:262:6: ( ( (this_WS_0= RULE_WS )+ | ( (this_WS_1= RULE_WS )* this_NEWLINE_2= RULE_NEWLINE (this_WS_3= RULE_WS )+ ) ) )
            // InternalCmdArgsParser.g:263:1: ( (this_WS_0= RULE_WS )+ | ( (this_WS_1= RULE_WS )* this_NEWLINE_2= RULE_NEWLINE (this_WS_3= RULE_WS )+ ) )
            {
            // InternalCmdArgsParser.g:263:1: ( (this_WS_0= RULE_WS )+ | ( (this_WS_1= RULE_WS )* this_NEWLINE_2= RULE_NEWLINE (this_WS_3= RULE_WS )+ ) )
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalCmdArgsParser.g:263:2: (this_WS_0= RULE_WS )+
                    {
                    // InternalCmdArgsParser.g:263:2: (this_WS_0= RULE_WS )+
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
                    	    // InternalCmdArgsParser.g:263:7: this_WS_0= RULE_WS
                    	    {
                    	    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_8); 

                    	    		current.merge(this_WS_0);
                    	        
                    	     
                    	        newLeafNode(this_WS_0, grammarAccess.getFillUpAccess().getWSTerminalRuleCall_0()); 
                    	        

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
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:271:6: ( (this_WS_1= RULE_WS )* this_NEWLINE_2= RULE_NEWLINE (this_WS_3= RULE_WS )+ )
                    {
                    // InternalCmdArgsParser.g:271:6: ( (this_WS_1= RULE_WS )* this_NEWLINE_2= RULE_NEWLINE (this_WS_3= RULE_WS )+ )
                    // InternalCmdArgsParser.g:271:7: (this_WS_1= RULE_WS )* this_NEWLINE_2= RULE_NEWLINE (this_WS_3= RULE_WS )+
                    {
                    // InternalCmdArgsParser.g:271:7: (this_WS_1= RULE_WS )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_WS) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:271:12: this_WS_1= RULE_WS
                    	    {
                    	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_6); 

                    	    		current.merge(this_WS_1);
                    	        
                    	     
                    	        newLeafNode(this_WS_1, grammarAccess.getFillUpAccess().getWSTerminalRuleCall_1_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_9); 

                    		current.merge(this_NEWLINE_2);
                        
                     
                        newLeafNode(this_NEWLINE_2, grammarAccess.getFillUpAccess().getNEWLINETerminalRuleCall_1_1()); 
                        
                    // InternalCmdArgsParser.g:285:1: (this_WS_3= RULE_WS )+
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
                    	    // InternalCmdArgsParser.g:285:6: this_WS_3= RULE_WS
                    	    {
                    	    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_8); 

                    	    		current.merge(this_WS_3);
                    	        
                    	     
                    	        newLeafNode(this_WS_3, grammarAccess.getFillUpAccess().getWSTerminalRuleCall_1_2()); 
                    	        

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
    // $ANTLR end "ruleFillUp"


    // $ANTLR start "entryRuleAssignment"
    // InternalCmdArgsParser.g:300:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalCmdArgsParser.g:301:2: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalCmdArgsParser.g:302:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
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
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalCmdArgsParser.g:309:1: ruleAssignment returns [EObject current=null] : ( ( (lv_start_0_0= ruleIdentifier ) ) (this_WS_1= RULE_WS )+ this_SKW_COLON_2= RULE_SKW_COLON this_SKW_ASSIGN_3= RULE_SKW_ASSIGN (this_WS_4= RULE_WS )+ ( ( (lv_arguments_5_0= ruleArgument ) ) ( (this_WS_6= RULE_WS )+ ( (lv_arguments_7_0= ruleArgument ) ) )* ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token this_SKW_COLON_2=null;
        Token this_SKW_ASSIGN_3=null;
        Token this_WS_4=null;
        Token this_WS_6=null;
        AntlrDatatypeRuleToken lv_start_0_0 = null;

        EObject lv_arguments_5_0 = null;

        EObject lv_arguments_7_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:312:28: ( ( ( (lv_start_0_0= ruleIdentifier ) ) (this_WS_1= RULE_WS )+ this_SKW_COLON_2= RULE_SKW_COLON this_SKW_ASSIGN_3= RULE_SKW_ASSIGN (this_WS_4= RULE_WS )+ ( ( (lv_arguments_5_0= ruleArgument ) ) ( (this_WS_6= RULE_WS )+ ( (lv_arguments_7_0= ruleArgument ) ) )* ) ) )
            // InternalCmdArgsParser.g:313:1: ( ( (lv_start_0_0= ruleIdentifier ) ) (this_WS_1= RULE_WS )+ this_SKW_COLON_2= RULE_SKW_COLON this_SKW_ASSIGN_3= RULE_SKW_ASSIGN (this_WS_4= RULE_WS )+ ( ( (lv_arguments_5_0= ruleArgument ) ) ( (this_WS_6= RULE_WS )+ ( (lv_arguments_7_0= ruleArgument ) ) )* ) )
            {
            // InternalCmdArgsParser.g:313:1: ( ( (lv_start_0_0= ruleIdentifier ) ) (this_WS_1= RULE_WS )+ this_SKW_COLON_2= RULE_SKW_COLON this_SKW_ASSIGN_3= RULE_SKW_ASSIGN (this_WS_4= RULE_WS )+ ( ( (lv_arguments_5_0= ruleArgument ) ) ( (this_WS_6= RULE_WS )+ ( (lv_arguments_7_0= ruleArgument ) ) )* ) )
            // InternalCmdArgsParser.g:313:2: ( (lv_start_0_0= ruleIdentifier ) ) (this_WS_1= RULE_WS )+ this_SKW_COLON_2= RULE_SKW_COLON this_SKW_ASSIGN_3= RULE_SKW_ASSIGN (this_WS_4= RULE_WS )+ ( ( (lv_arguments_5_0= ruleArgument ) ) ( (this_WS_6= RULE_WS )+ ( (lv_arguments_7_0= ruleArgument ) ) )* )
            {
            // InternalCmdArgsParser.g:313:2: ( (lv_start_0_0= ruleIdentifier ) )
            // InternalCmdArgsParser.g:314:1: (lv_start_0_0= ruleIdentifier )
            {
            // InternalCmdArgsParser.g:314:1: (lv_start_0_0= ruleIdentifier )
            // InternalCmdArgsParser.g:315:3: lv_start_0_0= ruleIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getAssignmentAccess().getStartIdentifierParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_9);
            lv_start_0_0=ruleIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
            	        }
                   		set(
                   			current, 
                   			"start",
                    		lv_start_0_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalCmdArgsParser.g:331:2: (this_WS_1= RULE_WS )+
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
            	    // InternalCmdArgsParser.g:331:3: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_10); 
            	     
            	        newLeafNode(this_WS_1, grammarAccess.getAssignmentAccess().getWSTerminalRuleCall_1()); 
            	        

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

            this_SKW_COLON_2=(Token)match(input,RULE_SKW_COLON,FOLLOW_11); 
             
                newLeafNode(this_SKW_COLON_2, grammarAccess.getAssignmentAccess().getSKW_COLONTerminalRuleCall_2()); 
                
            this_SKW_ASSIGN_3=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_9); 
             
                newLeafNode(this_SKW_ASSIGN_3, grammarAccess.getAssignmentAccess().getSKW_ASSIGNTerminalRuleCall_3()); 
                
            // InternalCmdArgsParser.g:343:1: (this_WS_4= RULE_WS )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_WS) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalCmdArgsParser.g:343:2: this_WS_4= RULE_WS
            	    {
            	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_12); 
            	     
            	        newLeafNode(this_WS_4, grammarAccess.getAssignmentAccess().getWSTerminalRuleCall_4()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            // InternalCmdArgsParser.g:347:3: ( ( (lv_arguments_5_0= ruleArgument ) ) ( (this_WS_6= RULE_WS )+ ( (lv_arguments_7_0= ruleArgument ) ) )* )
            // InternalCmdArgsParser.g:347:4: ( (lv_arguments_5_0= ruleArgument ) ) ( (this_WS_6= RULE_WS )+ ( (lv_arguments_7_0= ruleArgument ) ) )*
            {
            // InternalCmdArgsParser.g:347:4: ( (lv_arguments_5_0= ruleArgument ) )
            // InternalCmdArgsParser.g:348:1: (lv_arguments_5_0= ruleArgument )
            {
            // InternalCmdArgsParser.g:348:1: (lv_arguments_5_0= ruleArgument )
            // InternalCmdArgsParser.g:349:3: lv_arguments_5_0= ruleArgument
            {
             
            	        newCompositeNode(grammarAccess.getAssignmentAccess().getArgumentsArgumentParserRuleCall_5_0_0()); 
            	    
            pushFollow(FOLLOW_8);
            lv_arguments_5_0=ruleArgument();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
            	        }
                   		add(
                   			current, 
                   			"arguments",
                    		lv_arguments_5_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.Argument");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalCmdArgsParser.g:365:2: ( (this_WS_6= RULE_WS )+ ( (lv_arguments_7_0= ruleArgument ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_WS) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalCmdArgsParser.g:365:3: (this_WS_6= RULE_WS )+ ( (lv_arguments_7_0= ruleArgument ) )
            	    {
            	    // InternalCmdArgsParser.g:365:3: (this_WS_6= RULE_WS )+
            	    int cnt14=0;
            	    loop14:
            	    do {
            	        int alt14=2;
            	        int LA14_0 = input.LA(1);

            	        if ( (LA14_0==RULE_WS) ) {
            	            alt14=1;
            	        }


            	        switch (alt14) {
            	    	case 1 :
            	    	    // InternalCmdArgsParser.g:365:4: this_WS_6= RULE_WS
            	    	    {
            	    	    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_12); 
            	    	     
            	    	        newLeafNode(this_WS_6, grammarAccess.getAssignmentAccess().getWSTerminalRuleCall_5_1_0()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt14 >= 1 ) break loop14;
            	                EarlyExitException eee =
            	                    new EarlyExitException(14, input);
            	                throw eee;
            	        }
            	        cnt14++;
            	    } while (true);

            	    // InternalCmdArgsParser.g:369:3: ( (lv_arguments_7_0= ruleArgument ) )
            	    // InternalCmdArgsParser.g:370:1: (lv_arguments_7_0= ruleArgument )
            	    {
            	    // InternalCmdArgsParser.g:370:1: (lv_arguments_7_0= ruleArgument )
            	    // InternalCmdArgsParser.g:371:3: lv_arguments_7_0= ruleArgument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssignmentAccess().getArgumentsArgumentParserRuleCall_5_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_8);
            	    lv_arguments_7_0=ruleArgument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"arguments",
            	            		lv_arguments_7_0, 
            	            		"at.jku.weiner.c.cmdarguments.CmdArgs.Argument");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleArgument"
    // InternalCmdArgsParser.g:395:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // InternalCmdArgsParser.g:396:2: (iv_ruleArgument= ruleArgument EOF )
            // InternalCmdArgsParser.g:397:2: iv_ruleArgument= ruleArgument EOF
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
    // InternalCmdArgsParser.g:404:1: ruleArgument returns [EObject current=null] : ( () ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) ) ) ;
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
            // InternalCmdArgsParser.g:407:28: ( ( () ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) ) ) )
            // InternalCmdArgsParser.g:408:1: ( () ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) ) )
            {
            // InternalCmdArgsParser.g:408:1: ( () ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) ) )
            // InternalCmdArgsParser.g:408:2: () ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) )
            {
            // InternalCmdArgsParser.g:408:2: ()
            // InternalCmdArgsParser.g:409:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArgumentAccess().getArgumentAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:414:2: ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) )
            int alt22=9;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalCmdArgsParser.g:414:3: (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) )
                    {
                    // InternalCmdArgsParser.g:414:3: (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) )
                    // InternalCmdArgsParser.g:414:4: this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) )
                    {
                    this_KW_DEFINE_1=(Token)match(input,RULE_KW_DEFINE,FOLLOW_13); 
                     
                        newLeafNode(this_KW_DEFINE_1, grammarAccess.getArgumentAccess().getKW_DEFINETerminalRuleCall_1_0_0()); 
                        
                    // InternalCmdArgsParser.g:418:1: ( (lv_macro_2_0= ruleMacro ) )
                    // InternalCmdArgsParser.g:419:1: (lv_macro_2_0= ruleMacro )
                    {
                    // InternalCmdArgsParser.g:419:1: (lv_macro_2_0= ruleMacro )
                    // InternalCmdArgsParser.g:420:3: lv_macro_2_0= ruleMacro
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
                    // InternalCmdArgsParser.g:437:6: ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:437:6: ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:437:7: ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) )
                    {
                    // InternalCmdArgsParser.g:437:7: ( (lv_incDir_3_0= RULE_KW_INCDIR ) )
                    // InternalCmdArgsParser.g:438:1: (lv_incDir_3_0= RULE_KW_INCDIR )
                    {
                    // InternalCmdArgsParser.g:438:1: (lv_incDir_3_0= RULE_KW_INCDIR )
                    // InternalCmdArgsParser.g:439:3: lv_incDir_3_0= RULE_KW_INCDIR
                    {
                    lv_incDir_3_0=(Token)match(input,RULE_KW_INCDIR,FOLLOW_14); 

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

                    // InternalCmdArgsParser.g:455:2: ( (lv_useIncDir_4_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:456:1: (lv_useIncDir_4_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:456:1: (lv_useIncDir_4_0= rulePathCmd )
                    // InternalCmdArgsParser.g:457:3: lv_useIncDir_4_0= rulePathCmd
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
                    // InternalCmdArgsParser.g:474:6: ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:474:6: ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:474:7: ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) )
                    {
                    // InternalCmdArgsParser.g:474:7: ( (lv_incSys_5_0= ruleIncSys ) )
                    // InternalCmdArgsParser.g:475:1: (lv_incSys_5_0= ruleIncSys )
                    {
                    // InternalCmdArgsParser.g:475:1: (lv_incSys_5_0= ruleIncSys )
                    // InternalCmdArgsParser.g:476:3: lv_incSys_5_0= ruleIncSys
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

                    // InternalCmdArgsParser.g:492:2: (this_WS_6= RULE_WS )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_WS) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:492:3: this_WS_6= RULE_WS
                    	    {
                    	    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_15); 
                    	     
                    	        newLeafNode(this_WS_6, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_2_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    // InternalCmdArgsParser.g:496:3: ( (lv_useIncDir_7_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:497:1: (lv_useIncDir_7_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:497:1: (lv_useIncDir_7_0= rulePathCmd )
                    // InternalCmdArgsParser.g:498:3: lv_useIncDir_7_0= rulePathCmd
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
                    // InternalCmdArgsParser.g:515:6: ( (lv_nostdinc_8_0= ruleNoStdInc ) )
                    {
                    // InternalCmdArgsParser.g:515:6: ( (lv_nostdinc_8_0= ruleNoStdInc ) )
                    // InternalCmdArgsParser.g:516:1: (lv_nostdinc_8_0= ruleNoStdInc )
                    {
                    // InternalCmdArgsParser.g:516:1: (lv_nostdinc_8_0= ruleNoStdInc )
                    // InternalCmdArgsParser.g:517:3: lv_nostdinc_8_0= ruleNoStdInc
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
                    // InternalCmdArgsParser.g:534:6: (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:534:6: (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:534:7: this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) )
                    {
                    this_SKW_MINUS_9=(Token)match(input,RULE_SKW_MINUS,FOLLOW_16); 
                     
                        newLeafNode(this_SKW_MINUS_9, grammarAccess.getArgumentAccess().getSKW_MINUSTerminalRuleCall_1_4_0()); 
                        
                    this_KW_INCLUDE_10=(Token)match(input,RULE_KW_INCLUDE,FOLLOW_9); 
                     
                        newLeafNode(this_KW_INCLUDE_10, grammarAccess.getArgumentAccess().getKW_INCLUDETerminalRuleCall_1_4_1()); 
                        
                    // InternalCmdArgsParser.g:542:1: (this_WS_11= RULE_WS )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_WS) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:542:2: this_WS_11= RULE_WS
                    	    {
                    	    this_WS_11=(Token)match(input,RULE_WS,FOLLOW_15); 
                    	     
                    	        newLeafNode(this_WS_11, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_4_2()); 
                    	        

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

                    // InternalCmdArgsParser.g:546:3: ( (lv_include_12_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:547:1: (lv_include_12_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:547:1: (lv_include_12_0= rulePathCmd )
                    // InternalCmdArgsParser.g:548:3: lv_include_12_0= rulePathCmd
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
                    // InternalCmdArgsParser.g:565:6: (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:565:6: (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:565:7: this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) )
                    {
                    this_KW_OUTPUT_13=(Token)match(input,RULE_KW_OUTPUT,FOLLOW_9); 
                     
                        newLeafNode(this_KW_OUTPUT_13, grammarAccess.getArgumentAccess().getKW_OUTPUTTerminalRuleCall_1_5_0()); 
                        
                    // InternalCmdArgsParser.g:569:1: (this_WS_14= RULE_WS )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==RULE_WS) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:569:2: this_WS_14= RULE_WS
                    	    {
                    	    this_WS_14=(Token)match(input,RULE_WS,FOLLOW_15); 
                    	     
                    	        newLeafNode(this_WS_14, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_5_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    // InternalCmdArgsParser.g:573:3: ( (lv_out_15_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:574:1: (lv_out_15_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:574:1: (lv_out_15_0= rulePathCmd )
                    // InternalCmdArgsParser.g:575:3: lv_out_15_0= rulePathCmd
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
                    // InternalCmdArgsParser.g:592:6: (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:592:6: (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:592:7: this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) )
                    {
                    this_KW_LANG_16=(Token)match(input,RULE_KW_LANG,FOLLOW_9); 
                     
                        newLeafNode(this_KW_LANG_16, grammarAccess.getArgumentAccess().getKW_LANGTerminalRuleCall_1_6_0()); 
                        
                    // InternalCmdArgsParser.g:596:1: (this_WS_17= RULE_WS )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_WS) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:596:2: this_WS_17= RULE_WS
                    	    {
                    	    this_WS_17=(Token)match(input,RULE_WS,FOLLOW_15); 
                    	     
                    	        newLeafNode(this_WS_17, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_6_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    // InternalCmdArgsParser.g:600:3: ( (lv_lang_18_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:601:1: (lv_lang_18_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:601:1: (lv_lang_18_0= rulePathCmd )
                    // InternalCmdArgsParser.g:602:3: lv_lang_18_0= rulePathCmd
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
                    // InternalCmdArgsParser.g:619:6: (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? )
                    {
                    // InternalCmdArgsParser.g:619:6: (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? )
                    // InternalCmdArgsParser.g:619:7: this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )?
                    {
                    this_SKW_MINUS_19=(Token)match(input,RULE_SKW_MINUS,FOLLOW_17); 
                     
                        newLeafNode(this_SKW_MINUS_19, grammarAccess.getArgumentAccess().getSKW_MINUSTerminalRuleCall_1_7_0()); 
                        
                    // InternalCmdArgsParser.g:623:1: (this_SKW_MINUS_20= RULE_SKW_MINUS )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==RULE_SKW_MINUS) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalCmdArgsParser.g:623:2: this_SKW_MINUS_20= RULE_SKW_MINUS
                            {
                            this_SKW_MINUS_20=(Token)match(input,RULE_SKW_MINUS,FOLLOW_18); 
                             
                                newLeafNode(this_SKW_MINUS_20, grammarAccess.getArgumentAccess().getSKW_MINUSTerminalRuleCall_1_7_1()); 
                                

                            }
                            break;

                    }

                    // InternalCmdArgsParser.g:627:3: ( (lv_option_21_0= ruleOption ) )?
                    int alt21=2;
                    alt21 = dfa21.predict(input);
                    switch (alt21) {
                        case 1 :
                            // InternalCmdArgsParser.g:628:1: (lv_option_21_0= ruleOption )
                            {
                            // InternalCmdArgsParser.g:628:1: (lv_option_21_0= ruleOption )
                            // InternalCmdArgsParser.g:629:3: lv_option_21_0= ruleOption
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
                    // InternalCmdArgsParser.g:646:6: ( (lv_in_22_0= ruleIdentifier ) )
                    {
                    // InternalCmdArgsParser.g:646:6: ( (lv_in_22_0= ruleIdentifier ) )
                    // InternalCmdArgsParser.g:647:1: (lv_in_22_0= ruleIdentifier )
                    {
                    // InternalCmdArgsParser.g:647:1: (lv_in_22_0= ruleIdentifier )
                    // InternalCmdArgsParser.g:648:3: lv_in_22_0= ruleIdentifier
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
    // InternalCmdArgsParser.g:672:1: entryRuleIncSys returns [String current=null] : iv_ruleIncSys= ruleIncSys EOF ;
    public final String entryRuleIncSys() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIncSys = null;


        try {
            // InternalCmdArgsParser.g:673:1: (iv_ruleIncSys= ruleIncSys EOF )
            // InternalCmdArgsParser.g:674:2: iv_ruleIncSys= ruleIncSys EOF
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
    // InternalCmdArgsParser.g:681:1: ruleIncSys returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS ) ;
    public final AntlrDatatypeRuleToken ruleIncSys() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_MINUS_0=null;
        Token this_KW_INCSYS_1=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:685:6: ( (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS ) )
            // InternalCmdArgsParser.g:686:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS )
            {
            // InternalCmdArgsParser.g:686:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS )
            // InternalCmdArgsParser.g:686:6: this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS
            {
            this_SKW_MINUS_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_19); 

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
    // InternalCmdArgsParser.g:708:1: entryRuleNoStdInc returns [String current=null] : iv_ruleNoStdInc= ruleNoStdInc EOF ;
    public final String entryRuleNoStdInc() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoStdInc = null;


        try {
            // InternalCmdArgsParser.g:709:1: (iv_ruleNoStdInc= ruleNoStdInc EOF )
            // InternalCmdArgsParser.g:710:2: iv_ruleNoStdInc= ruleNoStdInc EOF
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
    // InternalCmdArgsParser.g:717:1: ruleNoStdInc returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC ) ;
    public final AntlrDatatypeRuleToken ruleNoStdInc() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_MINUS_0=null;
        Token this_KW_NOSTDINC_1=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:721:6: ( (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC ) )
            // InternalCmdArgsParser.g:722:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC )
            {
            // InternalCmdArgsParser.g:722:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC )
            // InternalCmdArgsParser.g:722:6: this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC
            {
            this_SKW_MINUS_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_20); 

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
    // InternalCmdArgsParser.g:744:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // InternalCmdArgsParser.g:745:2: (iv_ruleMacro= ruleMacro EOF )
            // InternalCmdArgsParser.g:746:2: iv_ruleMacro= ruleMacro EOF
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
    // InternalCmdArgsParser.g:753:1: ruleMacro returns [EObject current=null] : (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro | this_StringMacro_3= ruleStringMacro ) ;
    public final EObject ruleMacro() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleMacro_0 = null;

        EObject this_ObjectMacro_1 = null;

        EObject this_FunctionMacro_2 = null;

        EObject this_StringMacro_3 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:756:28: ( (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro | this_StringMacro_3= ruleStringMacro ) )
            // InternalCmdArgsParser.g:757:1: (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro | this_StringMacro_3= ruleStringMacro )
            {
            // InternalCmdArgsParser.g:757:1: (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro | this_StringMacro_3= ruleStringMacro )
            int alt23=4;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalCmdArgsParser.g:758:5: this_SimpleMacro_0= ruleSimpleMacro
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
                    // InternalCmdArgsParser.g:768:5: this_ObjectMacro_1= ruleObjectMacro
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
                    // InternalCmdArgsParser.g:778:5: this_FunctionMacro_2= ruleFunctionMacro
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
                    // InternalCmdArgsParser.g:788:5: this_StringMacro_3= ruleStringMacro
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
    // InternalCmdArgsParser.g:804:1: entryRuleSimpleMacro returns [EObject current=null] : iv_ruleSimpleMacro= ruleSimpleMacro EOF ;
    public final EObject entryRuleSimpleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleMacro = null;


        try {
            // InternalCmdArgsParser.g:805:2: (iv_ruleSimpleMacro= ruleSimpleMacro EOF )
            // InternalCmdArgsParser.g:806:2: iv_ruleSimpleMacro= ruleSimpleMacro EOF
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
    // InternalCmdArgsParser.g:813:1: ruleSimpleMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) ) ;
    public final EObject ruleSimpleMacro() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:816:28: ( ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) ) )
            // InternalCmdArgsParser.g:817:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) )
            {
            // InternalCmdArgsParser.g:817:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) )
            // InternalCmdArgsParser.g:817:2: () ( (lv_name_1_0= ruleMacroLegalPart ) )
            {
            // InternalCmdArgsParser.g:817:2: ()
            // InternalCmdArgsParser.g:818:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSimpleMacroAccess().getSimpleMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:823:2: ( (lv_name_1_0= ruleMacroLegalPart ) )
            // InternalCmdArgsParser.g:824:1: (lv_name_1_0= ruleMacroLegalPart )
            {
            // InternalCmdArgsParser.g:824:1: (lv_name_1_0= ruleMacroLegalPart )
            // InternalCmdArgsParser.g:825:3: lv_name_1_0= ruleMacroLegalPart
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
    // InternalCmdArgsParser.g:849:1: entryRuleObjectMacro returns [EObject current=null] : iv_ruleObjectMacro= ruleObjectMacro EOF ;
    public final EObject entryRuleObjectMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectMacro = null;


        try {
            // InternalCmdArgsParser.g:850:2: (iv_ruleObjectMacro= ruleObjectMacro EOF )
            // InternalCmdArgsParser.g:851:2: iv_ruleObjectMacro= ruleObjectMacro EOF
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
    // InternalCmdArgsParser.g:858:1: ruleObjectMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) ) ;
    public final EObject ruleObjectMacro() throws RecognitionException {
        EObject current = null;

        Token this_SKW_ASSIGN_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:861:28: ( ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) ) )
            // InternalCmdArgsParser.g:862:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) )
            {
            // InternalCmdArgsParser.g:862:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) )
            // InternalCmdArgsParser.g:862:2: () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) )
            {
            // InternalCmdArgsParser.g:862:2: ()
            // InternalCmdArgsParser.g:863:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getObjectMacroAccess().getObjectMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:868:2: ( (lv_name_1_0= ruleMacroLegalPart ) )
            // InternalCmdArgsParser.g:869:1: (lv_name_1_0= ruleMacroLegalPart )
            {
            // InternalCmdArgsParser.g:869:1: (lv_name_1_0= ruleMacroLegalPart )
            // InternalCmdArgsParser.g:870:3: lv_name_1_0= ruleMacroLegalPart
            {
             
            	        newCompositeNode(grammarAccess.getObjectMacroAccess().getNameMacroLegalPartParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_11);
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

            this_SKW_ASSIGN_2=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_21); 
             
                newLeafNode(this_SKW_ASSIGN_2, grammarAccess.getObjectMacroAccess().getSKW_ASSIGNTerminalRuleCall_2()); 
                
            // InternalCmdArgsParser.g:890:1: ( (lv_value_3_0= ruleMyCode ) )
            // InternalCmdArgsParser.g:891:1: (lv_value_3_0= ruleMyCode )
            {
            // InternalCmdArgsParser.g:891:1: (lv_value_3_0= ruleMyCode )
            // InternalCmdArgsParser.g:892:3: lv_value_3_0= ruleMyCode
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
    // InternalCmdArgsParser.g:916:1: entryRuleFunctionMacro returns [EObject current=null] : iv_ruleFunctionMacro= ruleFunctionMacro EOF ;
    public final EObject entryRuleFunctionMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionMacro = null;


        try {
            // InternalCmdArgsParser.g:917:2: (iv_ruleFunctionMacro= ruleFunctionMacro EOF )
            // InternalCmdArgsParser.g:918:2: iv_ruleFunctionMacro= ruleFunctionMacro EOF
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
    // InternalCmdArgsParser.g:925:1: ruleFunctionMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) ) ;
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
            // InternalCmdArgsParser.g:928:28: ( ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) ) )
            // InternalCmdArgsParser.g:929:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) )
            {
            // InternalCmdArgsParser.g:929:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) )
            // InternalCmdArgsParser.g:929:2: () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) )
            {
            // InternalCmdArgsParser.g:929:2: ()
            // InternalCmdArgsParser.g:930:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFunctionMacroAccess().getFunctionMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:935:2: ( (lv_name_1_0= ruleMacroLegalPart ) )
            // InternalCmdArgsParser.g:936:1: (lv_name_1_0= ruleMacroLegalPart )
            {
            // InternalCmdArgsParser.g:936:1: (lv_name_1_0= ruleMacroLegalPart )
            // InternalCmdArgsParser.g:937:3: lv_name_1_0= ruleMacroLegalPart
            {
             
            	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getNameMacroLegalPartParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_22);
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

            this_SKW_LEFTPAREN_2=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_23); 
             
                newLeafNode(this_SKW_LEFTPAREN_2, grammarAccess.getFunctionMacroAccess().getSKW_LEFTPARENTerminalRuleCall_2()); 
                
            // InternalCmdArgsParser.g:957:1: ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_KW_NOSTDINC && LA25_0<=RULE_KW_VAR)||LA25_0==RULE_ID||LA25_0==RULE_ANY_OTHER) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalCmdArgsParser.g:957:2: ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )*
                    {
                    // InternalCmdArgsParser.g:957:2: ( (lv_params_3_0= ruleMacroLegalPart ) )
                    // InternalCmdArgsParser.g:958:1: (lv_params_3_0= ruleMacroLegalPart )
                    {
                    // InternalCmdArgsParser.g:958:1: (lv_params_3_0= ruleMacroLegalPart )
                    // InternalCmdArgsParser.g:959:3: lv_params_3_0= ruleMacroLegalPart
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getParamsMacroLegalPartParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_24);
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

                    // InternalCmdArgsParser.g:975:2: (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==RULE_SKW_COMMA) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:975:3: this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) )
                    	    {
                    	    this_SKW_COMMA_4=(Token)match(input,RULE_SKW_COMMA,FOLLOW_25); 
                    	     
                    	        newLeafNode(this_SKW_COMMA_4, grammarAccess.getFunctionMacroAccess().getSKW_COMMATerminalRuleCall_3_1_0()); 
                    	        
                    	    // InternalCmdArgsParser.g:979:1: ( (lv_params_5_0= ruleMacroLegalPart ) )
                    	    // InternalCmdArgsParser.g:980:1: (lv_params_5_0= ruleMacroLegalPart )
                    	    {
                    	    // InternalCmdArgsParser.g:980:1: (lv_params_5_0= ruleMacroLegalPart )
                    	    // InternalCmdArgsParser.g:981:3: lv_params_5_0= ruleMacroLegalPart
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getParamsMacroLegalPartParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_24);
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
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            this_SKW_RIGHTPAREN_6=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_11); 
             
                newLeafNode(this_SKW_RIGHTPAREN_6, grammarAccess.getFunctionMacroAccess().getSKW_RIGHTPARENTerminalRuleCall_4()); 
                
            this_SKW_ASSIGN_7=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_21); 
             
                newLeafNode(this_SKW_ASSIGN_7, grammarAccess.getFunctionMacroAccess().getSKW_ASSIGNTerminalRuleCall_5()); 
                
            // InternalCmdArgsParser.g:1005:1: ( (lv_value_8_0= ruleMyCode ) )
            // InternalCmdArgsParser.g:1006:1: (lv_value_8_0= ruleMyCode )
            {
            // InternalCmdArgsParser.g:1006:1: (lv_value_8_0= ruleMyCode )
            // InternalCmdArgsParser.g:1007:3: lv_value_8_0= ruleMyCode
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
    // InternalCmdArgsParser.g:1031:1: entryRuleStringMacro returns [EObject current=null] : iv_ruleStringMacro= ruleStringMacro EOF ;
    public final EObject entryRuleStringMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringMacro = null;


        try {
            // InternalCmdArgsParser.g:1032:2: (iv_ruleStringMacro= ruleStringMacro EOF )
            // InternalCmdArgsParser.g:1033:2: iv_ruleStringMacro= ruleStringMacro EOF
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
    // InternalCmdArgsParser.g:1040:1: ruleStringMacro returns [EObject current=null] : ( () ( (lv_string_1_0= RULE_STRING2 ) ) ) ;
    public final EObject ruleStringMacro() throws RecognitionException {
        EObject current = null;

        Token lv_string_1_0=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1043:28: ( ( () ( (lv_string_1_0= RULE_STRING2 ) ) ) )
            // InternalCmdArgsParser.g:1044:1: ( () ( (lv_string_1_0= RULE_STRING2 ) ) )
            {
            // InternalCmdArgsParser.g:1044:1: ( () ( (lv_string_1_0= RULE_STRING2 ) ) )
            // InternalCmdArgsParser.g:1044:2: () ( (lv_string_1_0= RULE_STRING2 ) )
            {
            // InternalCmdArgsParser.g:1044:2: ()
            // InternalCmdArgsParser.g:1045:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringMacroAccess().getStringMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:1050:2: ( (lv_string_1_0= RULE_STRING2 ) )
            // InternalCmdArgsParser.g:1051:1: (lv_string_1_0= RULE_STRING2 )
            {
            // InternalCmdArgsParser.g:1051:1: (lv_string_1_0= RULE_STRING2 )
            // InternalCmdArgsParser.g:1052:3: lv_string_1_0= RULE_STRING2
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
    // InternalCmdArgsParser.g:1076:1: entryRulePathCmd returns [EObject current=null] : iv_rulePathCmd= rulePathCmd EOF ;
    public final EObject entryRulePathCmd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathCmd = null;


        try {
            // InternalCmdArgsParser.g:1077:2: (iv_rulePathCmd= rulePathCmd EOF )
            // InternalCmdArgsParser.g:1078:2: iv_rulePathCmd= rulePathCmd EOF
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
    // InternalCmdArgsParser.g:1085:1: rulePathCmd returns [EObject current=null] : ( () ( (lv_path_1_0= rulePathLegalPart ) ) ) ;
    public final EObject rulePathCmd() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_path_1_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1088:28: ( ( () ( (lv_path_1_0= rulePathLegalPart ) ) ) )
            // InternalCmdArgsParser.g:1089:1: ( () ( (lv_path_1_0= rulePathLegalPart ) ) )
            {
            // InternalCmdArgsParser.g:1089:1: ( () ( (lv_path_1_0= rulePathLegalPart ) ) )
            // InternalCmdArgsParser.g:1089:2: () ( (lv_path_1_0= rulePathLegalPart ) )
            {
            // InternalCmdArgsParser.g:1089:2: ()
            // InternalCmdArgsParser.g:1090:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPathCmdAccess().getPathCmdAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:1095:2: ( (lv_path_1_0= rulePathLegalPart ) )
            // InternalCmdArgsParser.g:1096:1: (lv_path_1_0= rulePathLegalPart )
            {
            // InternalCmdArgsParser.g:1096:1: (lv_path_1_0= rulePathLegalPart )
            // InternalCmdArgsParser.g:1097:3: lv_path_1_0= rulePathLegalPart
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
    // InternalCmdArgsParser.g:1121:1: entryRulePathLegalPart returns [String current=null] : iv_rulePathLegalPart= rulePathLegalPart EOF ;
    public final String entryRulePathLegalPart() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePathLegalPart = null;


        try {
            // InternalCmdArgsParser.g:1122:1: (iv_rulePathLegalPart= rulePathLegalPart EOF )
            // InternalCmdArgsParser.g:1123:2: iv_rulePathLegalPart= rulePathLegalPart EOF
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
    // InternalCmdArgsParser.g:1130:1: rulePathLegalPart returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_KW_NOSTDINC_2= RULE_KW_NOSTDINC | this_KW_INCSYS_3= RULE_KW_INCSYS | this_KW_INCLUDE_4= RULE_KW_INCLUDE ) ;
    public final AntlrDatatypeRuleToken rulePathLegalPart() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING2_1=null;
        Token this_KW_NOSTDINC_2=null;
        Token this_KW_INCSYS_3=null;
        Token this_KW_INCLUDE_4=null;
        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1134:6: ( (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_KW_NOSTDINC_2= RULE_KW_NOSTDINC | this_KW_INCSYS_3= RULE_KW_INCSYS | this_KW_INCLUDE_4= RULE_KW_INCLUDE ) )
            // InternalCmdArgsParser.g:1135:1: (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_KW_NOSTDINC_2= RULE_KW_NOSTDINC | this_KW_INCSYS_3= RULE_KW_INCSYS | this_KW_INCLUDE_4= RULE_KW_INCLUDE )
            {
            // InternalCmdArgsParser.g:1135:1: (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_KW_NOSTDINC_2= RULE_KW_NOSTDINC | this_KW_INCSYS_3= RULE_KW_INCSYS | this_KW_INCLUDE_4= RULE_KW_INCLUDE )
            int alt26=5;
            switch ( input.LA(1) ) {
            case RULE_KW_VAR:
            case RULE_ID:
                {
                alt26=1;
                }
                break;
            case RULE_STRING2:
                {
                alt26=2;
                }
                break;
            case RULE_KW_NOSTDINC:
                {
                alt26=3;
                }
                break;
            case RULE_KW_INCSYS:
                {
                alt26=4;
                }
                break;
            case RULE_KW_INCLUDE:
                {
                alt26=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalCmdArgsParser.g:1136:5: this_Identifier_0= ruleIdentifier
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
                    // InternalCmdArgsParser.g:1147:10: this_STRING2_1= RULE_STRING2
                    {
                    this_STRING2_1=(Token)match(input,RULE_STRING2,FOLLOW_2); 

                    		current.merge(this_STRING2_1);
                        
                     
                        newLeafNode(this_STRING2_1, grammarAccess.getPathLegalPartAccess().getSTRING2TerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalCmdArgsParser.g:1155:10: this_KW_NOSTDINC_2= RULE_KW_NOSTDINC
                    {
                    this_KW_NOSTDINC_2=(Token)match(input,RULE_KW_NOSTDINC,FOLLOW_2); 

                    		current.merge(this_KW_NOSTDINC_2);
                        
                     
                        newLeafNode(this_KW_NOSTDINC_2, grammarAccess.getPathLegalPartAccess().getKW_NOSTDINCTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalCmdArgsParser.g:1163:10: this_KW_INCSYS_3= RULE_KW_INCSYS
                    {
                    this_KW_INCSYS_3=(Token)match(input,RULE_KW_INCSYS,FOLLOW_2); 

                    		current.merge(this_KW_INCSYS_3);
                        
                     
                        newLeafNode(this_KW_INCSYS_3, grammarAccess.getPathLegalPartAccess().getKW_INCSYSTerminalRuleCall_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalCmdArgsParser.g:1171:10: this_KW_INCLUDE_4= RULE_KW_INCLUDE
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
    // InternalCmdArgsParser.g:1186:1: entryRuleMacroLegalPart returns [String current=null] : iv_ruleMacroLegalPart= ruleMacroLegalPart EOF ;
    public final String entryRuleMacroLegalPart() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMacroLegalPart = null;


        try {
            // InternalCmdArgsParser.g:1187:1: (iv_ruleMacroLegalPart= ruleMacroLegalPart EOF )
            // InternalCmdArgsParser.g:1188:2: iv_ruleMacroLegalPart= ruleMacroLegalPart EOF
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
    // InternalCmdArgsParser.g:1195:1: ruleMacroLegalPart returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Identifier_0= ruleIdentifier | this_KW_NOSTDINC_1= RULE_KW_NOSTDINC | this_KW_INCSYS_2= RULE_KW_INCSYS | this_KW_INCLUDE_3= RULE_KW_INCLUDE | this_ANY_OTHER_4= RULE_ANY_OTHER ) ;
    public final AntlrDatatypeRuleToken ruleMacroLegalPart() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_KW_NOSTDINC_1=null;
        Token this_KW_INCSYS_2=null;
        Token this_KW_INCLUDE_3=null;
        Token this_ANY_OTHER_4=null;
        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1199:6: ( (this_Identifier_0= ruleIdentifier | this_KW_NOSTDINC_1= RULE_KW_NOSTDINC | this_KW_INCSYS_2= RULE_KW_INCSYS | this_KW_INCLUDE_3= RULE_KW_INCLUDE | this_ANY_OTHER_4= RULE_ANY_OTHER ) )
            // InternalCmdArgsParser.g:1200:1: (this_Identifier_0= ruleIdentifier | this_KW_NOSTDINC_1= RULE_KW_NOSTDINC | this_KW_INCSYS_2= RULE_KW_INCSYS | this_KW_INCLUDE_3= RULE_KW_INCLUDE | this_ANY_OTHER_4= RULE_ANY_OTHER )
            {
            // InternalCmdArgsParser.g:1200:1: (this_Identifier_0= ruleIdentifier | this_KW_NOSTDINC_1= RULE_KW_NOSTDINC | this_KW_INCSYS_2= RULE_KW_INCSYS | this_KW_INCLUDE_3= RULE_KW_INCLUDE | this_ANY_OTHER_4= RULE_ANY_OTHER )
            int alt27=5;
            switch ( input.LA(1) ) {
            case RULE_KW_VAR:
            case RULE_ID:
                {
                alt27=1;
                }
                break;
            case RULE_KW_NOSTDINC:
                {
                alt27=2;
                }
                break;
            case RULE_KW_INCSYS:
                {
                alt27=3;
                }
                break;
            case RULE_KW_INCLUDE:
                {
                alt27=4;
                }
                break;
            case RULE_ANY_OTHER:
                {
                alt27=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalCmdArgsParser.g:1201:5: this_Identifier_0= ruleIdentifier
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
                    // InternalCmdArgsParser.g:1212:10: this_KW_NOSTDINC_1= RULE_KW_NOSTDINC
                    {
                    this_KW_NOSTDINC_1=(Token)match(input,RULE_KW_NOSTDINC,FOLLOW_2); 

                    		current.merge(this_KW_NOSTDINC_1);
                        
                     
                        newLeafNode(this_KW_NOSTDINC_1, grammarAccess.getMacroLegalPartAccess().getKW_NOSTDINCTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalCmdArgsParser.g:1220:10: this_KW_INCSYS_2= RULE_KW_INCSYS
                    {
                    this_KW_INCSYS_2=(Token)match(input,RULE_KW_INCSYS,FOLLOW_2); 

                    		current.merge(this_KW_INCSYS_2);
                        
                     
                        newLeafNode(this_KW_INCSYS_2, grammarAccess.getMacroLegalPartAccess().getKW_INCSYSTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalCmdArgsParser.g:1228:10: this_KW_INCLUDE_3= RULE_KW_INCLUDE
                    {
                    this_KW_INCLUDE_3=(Token)match(input,RULE_KW_INCLUDE,FOLLOW_2); 

                    		current.merge(this_KW_INCLUDE_3);
                        
                     
                        newLeafNode(this_KW_INCLUDE_3, grammarAccess.getMacroLegalPartAccess().getKW_INCLUDETerminalRuleCall_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalCmdArgsParser.g:1236:10: this_ANY_OTHER_4= RULE_ANY_OTHER
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
    // InternalCmdArgsParser.g:1251:1: entryRuleMyCode returns [String current=null] : iv_ruleMyCode= ruleMyCode EOF ;
    public final String entryRuleMyCode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCode = null;


        try {
            // InternalCmdArgsParser.g:1252:1: (iv_ruleMyCode= ruleMyCode EOF )
            // InternalCmdArgsParser.g:1253:2: iv_ruleMyCode= ruleMyCode EOF
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
    // InternalCmdArgsParser.g:1260:1: ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN | this_KW_NOSTDINC_4= RULE_KW_NOSTDINC | this_KW_INCSYS_5= RULE_KW_INCSYS | this_KW_INCLUDE_6= RULE_KW_INCLUDE | this_ANY_OTHER_7= RULE_ANY_OTHER )+ ;
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
            // InternalCmdArgsParser.g:1264:6: ( (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN | this_KW_NOSTDINC_4= RULE_KW_NOSTDINC | this_KW_INCSYS_5= RULE_KW_INCSYS | this_KW_INCLUDE_6= RULE_KW_INCLUDE | this_ANY_OTHER_7= RULE_ANY_OTHER )+ )
            // InternalCmdArgsParser.g:1265:1: (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN | this_KW_NOSTDINC_4= RULE_KW_NOSTDINC | this_KW_INCSYS_5= RULE_KW_INCSYS | this_KW_INCLUDE_6= RULE_KW_INCLUDE | this_ANY_OTHER_7= RULE_ANY_OTHER )+
            {
            // InternalCmdArgsParser.g:1265:1: (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN | this_KW_NOSTDINC_4= RULE_KW_NOSTDINC | this_KW_INCSYS_5= RULE_KW_INCSYS | this_KW_INCLUDE_6= RULE_KW_INCLUDE | this_ANY_OTHER_7= RULE_ANY_OTHER )+
            int cnt28=0;
            loop28:
            do {
                int alt28=9;
                alt28 = dfa28.predict(input);
                switch (alt28) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1266:5: this_Identifier_0= ruleIdentifier
            	    {
            	     
            	            newCompositeNode(grammarAccess.getMyCodeAccess().getIdentifierParserRuleCall_0()); 
            	        
            	    pushFollow(FOLLOW_26);
            	    this_Identifier_0=ruleIdentifier();

            	    state._fsp--;


            	    		current.merge(this_Identifier_0);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;
            	case 2 :
            	    // InternalCmdArgsParser.g:1277:10: this_STRING2_1= RULE_STRING2
            	    {
            	    this_STRING2_1=(Token)match(input,RULE_STRING2,FOLLOW_26); 

            	    		current.merge(this_STRING2_1);
            	        
            	     
            	        newLeafNode(this_STRING2_1, grammarAccess.getMyCodeAccess().getSTRING2TerminalRuleCall_1()); 
            	        

            	    }
            	    break;
            	case 3 :
            	    // InternalCmdArgsParser.g:1285:10: this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN
            	    {
            	    this_SKW_LEFTPAREN_2=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_26); 

            	    		current.merge(this_SKW_LEFTPAREN_2);
            	        
            	     
            	        newLeafNode(this_SKW_LEFTPAREN_2, grammarAccess.getMyCodeAccess().getSKW_LEFTPARENTerminalRuleCall_2()); 
            	        

            	    }
            	    break;
            	case 4 :
            	    // InternalCmdArgsParser.g:1293:10: this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN
            	    {
            	    this_SKW_RIGHTPAREN_3=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_26); 

            	    		current.merge(this_SKW_RIGHTPAREN_3);
            	        
            	     
            	        newLeafNode(this_SKW_RIGHTPAREN_3, grammarAccess.getMyCodeAccess().getSKW_RIGHTPARENTerminalRuleCall_3()); 
            	        

            	    }
            	    break;
            	case 5 :
            	    // InternalCmdArgsParser.g:1301:10: this_KW_NOSTDINC_4= RULE_KW_NOSTDINC
            	    {
            	    this_KW_NOSTDINC_4=(Token)match(input,RULE_KW_NOSTDINC,FOLLOW_26); 

            	    		current.merge(this_KW_NOSTDINC_4);
            	        
            	     
            	        newLeafNode(this_KW_NOSTDINC_4, grammarAccess.getMyCodeAccess().getKW_NOSTDINCTerminalRuleCall_4()); 
            	        

            	    }
            	    break;
            	case 6 :
            	    // InternalCmdArgsParser.g:1309:10: this_KW_INCSYS_5= RULE_KW_INCSYS
            	    {
            	    this_KW_INCSYS_5=(Token)match(input,RULE_KW_INCSYS,FOLLOW_26); 

            	    		current.merge(this_KW_INCSYS_5);
            	        
            	     
            	        newLeafNode(this_KW_INCSYS_5, grammarAccess.getMyCodeAccess().getKW_INCSYSTerminalRuleCall_5()); 
            	        

            	    }
            	    break;
            	case 7 :
            	    // InternalCmdArgsParser.g:1317:10: this_KW_INCLUDE_6= RULE_KW_INCLUDE
            	    {
            	    this_KW_INCLUDE_6=(Token)match(input,RULE_KW_INCLUDE,FOLLOW_26); 

            	    		current.merge(this_KW_INCLUDE_6);
            	        
            	     
            	        newLeafNode(this_KW_INCLUDE_6, grammarAccess.getMyCodeAccess().getKW_INCLUDETerminalRuleCall_6()); 
            	        

            	    }
            	    break;
            	case 8 :
            	    // InternalCmdArgsParser.g:1325:10: this_ANY_OTHER_7= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_7=(Token)match(input,RULE_ANY_OTHER,FOLLOW_26); 

            	    		current.merge(this_ANY_OTHER_7);
            	        
            	     
            	        newLeafNode(this_ANY_OTHER_7, grammarAccess.getMyCodeAccess().getANY_OTHERTerminalRuleCall_7()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
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
    // InternalCmdArgsParser.g:1340:1: entryRuleOption returns [String current=null] : iv_ruleOption= ruleOption EOF ;
    public final String entryRuleOption() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOption = null;


        try {
            // InternalCmdArgsParser.g:1341:1: (iv_ruleOption= ruleOption EOF )
            // InternalCmdArgsParser.g:1342:2: iv_ruleOption= ruleOption EOF
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
    // InternalCmdArgsParser.g:1349:1: ruleOption returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_OptionPart_0= ruleOptionPart )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )* ) ;
    public final AntlrDatatypeRuleToken ruleOption() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_COMMA_1=null;
        Token this_SKW_MINUS_2=null;
        AntlrDatatypeRuleToken this_OptionPart_0 = null;

        AntlrDatatypeRuleToken this_OptionPart_3 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1353:6: ( ( (this_OptionPart_0= ruleOptionPart )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )* ) )
            // InternalCmdArgsParser.g:1354:1: ( (this_OptionPart_0= ruleOptionPart )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )* )
            {
            // InternalCmdArgsParser.g:1354:1: ( (this_OptionPart_0= ruleOptionPart )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )* )
            // InternalCmdArgsParser.g:1354:2: (this_OptionPart_0= ruleOptionPart )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )*
            {
            // InternalCmdArgsParser.g:1354:2: (this_OptionPart_0= ruleOptionPart )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                alt29 = dfa29.predict(input);
                switch (alt29) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1355:5: this_OptionPart_0= ruleOptionPart
            	    {
            	     
            	            newCompositeNode(grammarAccess.getOptionAccess().getOptionPartParserRuleCall_0()); 
            	        
            	    pushFollow(FOLLOW_27);
            	    this_OptionPart_0=ruleOptionPart();

            	    state._fsp--;


            	    		current.merge(this_OptionPart_0);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);

            // InternalCmdArgsParser.g:1365:3: (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_SKW_COMMA) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1365:8: this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+
            	    {
            	    this_SKW_COMMA_1=(Token)match(input,RULE_SKW_COMMA,FOLLOW_28); 

            	    		current.merge(this_SKW_COMMA_1);
            	        
            	     
            	        newLeafNode(this_SKW_COMMA_1, grammarAccess.getOptionAccess().getSKW_COMMATerminalRuleCall_1_0()); 
            	        
            	    // InternalCmdArgsParser.g:1372:1: (this_SKW_MINUS_2= RULE_SKW_MINUS )?
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==RULE_SKW_MINUS) ) {
            	        alt30=1;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // InternalCmdArgsParser.g:1372:6: this_SKW_MINUS_2= RULE_SKW_MINUS
            	            {
            	            this_SKW_MINUS_2=(Token)match(input,RULE_SKW_MINUS,FOLLOW_29); 

            	            		current.merge(this_SKW_MINUS_2);
            	                
            	             
            	                newLeafNode(this_SKW_MINUS_2, grammarAccess.getOptionAccess().getSKW_MINUSTerminalRuleCall_1_1()); 
            	                

            	            }
            	            break;

            	    }

            	    // InternalCmdArgsParser.g:1379:3: (this_OptionPart_3= ruleOptionPart )+
            	    int cnt31=0;
            	    loop31:
            	    do {
            	        int alt31=2;
            	        alt31 = dfa31.predict(input);
            	        switch (alt31) {
            	    	case 1 :
            	    	    // InternalCmdArgsParser.g:1380:5: this_OptionPart_3= ruleOptionPart
            	    	    {
            	    	     
            	    	            newCompositeNode(grammarAccess.getOptionAccess().getOptionPartParserRuleCall_1_2()); 
            	    	        
            	    	    pushFollow(FOLLOW_27);
            	    	    this_OptionPart_3=ruleOptionPart();

            	    	    state._fsp--;


            	    	    		current.merge(this_OptionPart_3);
            	    	        
            	    	     
            	    	            afterParserOrEnumRuleCall();
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt31 >= 1 ) break loop31;
            	                EarlyExitException eee =
            	                    new EarlyExitException(31, input);
            	                throw eee;
            	        }
            	        cnt31++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // InternalCmdArgsParser.g:1398:1: entryRuleOptionPart returns [String current=null] : iv_ruleOptionPart= ruleOptionPart EOF ;
    public final String entryRuleOptionPart() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOptionPart = null;


        try {
            // InternalCmdArgsParser.g:1399:1: (iv_ruleOptionPart= ruleOptionPart EOF )
            // InternalCmdArgsParser.g:1400:2: iv_ruleOptionPart= ruleOptionPart EOF
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
    // InternalCmdArgsParser.g:1407:1: ruleOptionPart returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_OptionLegalStart_0= ruleOptionLegalStart (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )* ) ;
    public final AntlrDatatypeRuleToken ruleOptionPart() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_OptionLegalStart_0 = null;

        AntlrDatatypeRuleToken this_OptionLegalContinuation_1 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1411:6: ( (this_OptionLegalStart_0= ruleOptionLegalStart (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )* ) )
            // InternalCmdArgsParser.g:1412:1: (this_OptionLegalStart_0= ruleOptionLegalStart (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )* )
            {
            // InternalCmdArgsParser.g:1412:1: (this_OptionLegalStart_0= ruleOptionLegalStart (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )* )
            // InternalCmdArgsParser.g:1413:5: this_OptionLegalStart_0= ruleOptionLegalStart (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )*
            {
             
                    newCompositeNode(grammarAccess.getOptionPartAccess().getOptionLegalStartParserRuleCall_0()); 
                
            pushFollow(FOLLOW_30);
            this_OptionLegalStart_0=ruleOptionLegalStart();

            state._fsp--;


            		current.merge(this_OptionLegalStart_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalCmdArgsParser.g:1423:1: (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_SKW_ASSIGN||(LA33_0>=RULE_KW_NOSTDINC && LA33_0<=RULE_KW_INCLUDE)||LA33_0==RULE_ANY_OTHER) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1424:5: this_OptionLegalContinuation_1= ruleOptionLegalContinuation
            	    {
            	     
            	            newCompositeNode(grammarAccess.getOptionPartAccess().getOptionLegalContinuationParserRuleCall_1()); 
            	        
            	    pushFollow(FOLLOW_30);
            	    this_OptionLegalContinuation_1=ruleOptionLegalContinuation();

            	    state._fsp--;


            	    		current.merge(this_OptionLegalContinuation_1);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop33;
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
    // InternalCmdArgsParser.g:1442:1: entryRuleOptionLegalStart returns [String current=null] : iv_ruleOptionLegalStart= ruleOptionLegalStart EOF ;
    public final String entryRuleOptionLegalStart() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOptionLegalStart = null;


        try {
            // InternalCmdArgsParser.g:1443:1: (iv_ruleOptionLegalStart= ruleOptionLegalStart EOF )
            // InternalCmdArgsParser.g:1444:2: iv_ruleOptionLegalStart= ruleOptionLegalStart EOF
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
    // InternalCmdArgsParser.g:1451:1: ruleOptionLegalStart returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 ) ;
    public final AntlrDatatypeRuleToken ruleOptionLegalStart() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING2_1=null;
        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1455:6: ( (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 ) )
            // InternalCmdArgsParser.g:1456:1: (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 )
            {
            // InternalCmdArgsParser.g:1456:1: (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_KW_VAR||LA34_0==RULE_ID) ) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_STRING2) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalCmdArgsParser.g:1457:5: this_Identifier_0= ruleIdentifier
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
                    // InternalCmdArgsParser.g:1468:10: this_STRING2_1= RULE_STRING2
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
    // InternalCmdArgsParser.g:1483:1: entryRuleOptionLegalContinuation returns [String current=null] : iv_ruleOptionLegalContinuation= ruleOptionLegalContinuation EOF ;
    public final String entryRuleOptionLegalContinuation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOptionLegalContinuation = null;


        try {
            // InternalCmdArgsParser.g:1484:1: (iv_ruleOptionLegalContinuation= ruleOptionLegalContinuation EOF )
            // InternalCmdArgsParser.g:1485:2: iv_ruleOptionLegalContinuation= ruleOptionLegalContinuation EOF
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
    // InternalCmdArgsParser.g:1492:1: ruleOptionLegalContinuation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_KW_NOSTDINC_0= RULE_KW_NOSTDINC | this_KW_INCSYS_1= RULE_KW_INCSYS | this_KW_INCLUDE_2= RULE_KW_INCLUDE | this_SKW_ASSIGN_3= RULE_SKW_ASSIGN | this_ANY_OTHER_4= RULE_ANY_OTHER ) ;
    public final AntlrDatatypeRuleToken ruleOptionLegalContinuation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_KW_NOSTDINC_0=null;
        Token this_KW_INCSYS_1=null;
        Token this_KW_INCLUDE_2=null;
        Token this_SKW_ASSIGN_3=null;
        Token this_ANY_OTHER_4=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1496:6: ( (this_KW_NOSTDINC_0= RULE_KW_NOSTDINC | this_KW_INCSYS_1= RULE_KW_INCSYS | this_KW_INCLUDE_2= RULE_KW_INCLUDE | this_SKW_ASSIGN_3= RULE_SKW_ASSIGN | this_ANY_OTHER_4= RULE_ANY_OTHER ) )
            // InternalCmdArgsParser.g:1497:1: (this_KW_NOSTDINC_0= RULE_KW_NOSTDINC | this_KW_INCSYS_1= RULE_KW_INCSYS | this_KW_INCLUDE_2= RULE_KW_INCLUDE | this_SKW_ASSIGN_3= RULE_SKW_ASSIGN | this_ANY_OTHER_4= RULE_ANY_OTHER )
            {
            // InternalCmdArgsParser.g:1497:1: (this_KW_NOSTDINC_0= RULE_KW_NOSTDINC | this_KW_INCSYS_1= RULE_KW_INCSYS | this_KW_INCLUDE_2= RULE_KW_INCLUDE | this_SKW_ASSIGN_3= RULE_SKW_ASSIGN | this_ANY_OTHER_4= RULE_ANY_OTHER )
            int alt35=5;
            switch ( input.LA(1) ) {
            case RULE_KW_NOSTDINC:
                {
                alt35=1;
                }
                break;
            case RULE_KW_INCSYS:
                {
                alt35=2;
                }
                break;
            case RULE_KW_INCLUDE:
                {
                alt35=3;
                }
                break;
            case RULE_SKW_ASSIGN:
                {
                alt35=4;
                }
                break;
            case RULE_ANY_OTHER:
                {
                alt35=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalCmdArgsParser.g:1497:6: this_KW_NOSTDINC_0= RULE_KW_NOSTDINC
                    {
                    this_KW_NOSTDINC_0=(Token)match(input,RULE_KW_NOSTDINC,FOLLOW_2); 

                    		current.merge(this_KW_NOSTDINC_0);
                        
                     
                        newLeafNode(this_KW_NOSTDINC_0, grammarAccess.getOptionLegalContinuationAccess().getKW_NOSTDINCTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:1505:10: this_KW_INCSYS_1= RULE_KW_INCSYS
                    {
                    this_KW_INCSYS_1=(Token)match(input,RULE_KW_INCSYS,FOLLOW_2); 

                    		current.merge(this_KW_INCSYS_1);
                        
                     
                        newLeafNode(this_KW_INCSYS_1, grammarAccess.getOptionLegalContinuationAccess().getKW_INCSYSTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalCmdArgsParser.g:1513:10: this_KW_INCLUDE_2= RULE_KW_INCLUDE
                    {
                    this_KW_INCLUDE_2=(Token)match(input,RULE_KW_INCLUDE,FOLLOW_2); 

                    		current.merge(this_KW_INCLUDE_2);
                        
                     
                        newLeafNode(this_KW_INCLUDE_2, grammarAccess.getOptionLegalContinuationAccess().getKW_INCLUDETerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalCmdArgsParser.g:1521:10: this_SKW_ASSIGN_3= RULE_SKW_ASSIGN
                    {
                    this_SKW_ASSIGN_3=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_2); 

                    		current.merge(this_SKW_ASSIGN_3);
                        
                     
                        newLeafNode(this_SKW_ASSIGN_3, grammarAccess.getOptionLegalContinuationAccess().getSKW_ASSIGNTerminalRuleCall_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalCmdArgsParser.g:1529:10: this_ANY_OTHER_4= RULE_ANY_OTHER
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
    // InternalCmdArgsParser.g:1544:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalCmdArgsParser.g:1545:1: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalCmdArgsParser.g:1546:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalCmdArgsParser.g:1553:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID (this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID )* ) | this_KW_VAR_4= RULE_KW_VAR ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_SKW_COLON_1=null;
        Token this_SKW_BACKSLASH_2=null;
        Token this_ID_3=null;
        Token this_KW_VAR_4=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1557:6: ( ( (this_ID_0= RULE_ID (this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID )* ) | this_KW_VAR_4= RULE_KW_VAR ) )
            // InternalCmdArgsParser.g:1558:1: ( (this_ID_0= RULE_ID (this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID )* ) | this_KW_VAR_4= RULE_KW_VAR )
            {
            // InternalCmdArgsParser.g:1558:1: ( (this_ID_0= RULE_ID (this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID )* ) | this_KW_VAR_4= RULE_KW_VAR )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            else if ( (LA37_0==RULE_KW_VAR) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalCmdArgsParser.g:1558:2: (this_ID_0= RULE_ID (this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID )* )
                    {
                    // InternalCmdArgsParser.g:1558:2: (this_ID_0= RULE_ID (this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID )* )
                    // InternalCmdArgsParser.g:1558:7: this_ID_0= RULE_ID (this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID )*
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_31); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0_0()); 
                        
                    // InternalCmdArgsParser.g:1565:1: (this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==RULE_SKW_COLON) ) {
                            int LA36_1 = input.LA(2);

                            if ( (LA36_1==RULE_SKW_BACKSLASH) ) {
                                alt36=1;
                            }


                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:1565:6: this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID
                    	    {
                    	    this_SKW_COLON_1=(Token)match(input,RULE_SKW_COLON,FOLLOW_32); 

                    	    		current.merge(this_SKW_COLON_1);
                    	        
                    	     
                    	        newLeafNode(this_SKW_COLON_1, grammarAccess.getIdentifierAccess().getSKW_COLONTerminalRuleCall_0_1_0()); 
                    	        
                    	    this_SKW_BACKSLASH_2=(Token)match(input,RULE_SKW_BACKSLASH,FOLLOW_33); 

                    	    		current.merge(this_SKW_BACKSLASH_2);
                    	        
                    	     
                    	        newLeafNode(this_SKW_BACKSLASH_2, grammarAccess.getIdentifierAccess().getSKW_BACKSLASHTerminalRuleCall_0_1_1()); 
                    	        
                    	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_31); 

                    	    		current.merge(this_ID_3);
                    	        
                    	     
                    	        newLeafNode(this_ID_3, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0_1_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:1587:10: this_KW_VAR_4= RULE_KW_VAR
                    {
                    this_KW_VAR_4=(Token)match(input,RULE_KW_VAR,FOLLOW_2); 

                    		current.merge(this_KW_VAR_4);
                        
                     
                        newLeafNode(this_KW_VAR_4, grammarAccess.getIdentifierAccess().getKW_VARTerminalRuleCall_1()); 
                        

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


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA31 dfa31 = new DFA31(this);
    static final String DFA5_eotS =
        "\10\uffff";
    static final String DFA5_eofS =
        "\10\uffff";
    static final String DFA5_minS =
        "\1\25\2\6\1\15\2\uffff\1\30\1\6";
    static final String DFA5_maxS =
        "\1\30\3\36\2\uffff\1\30\1\36";
    static final String DFA5_acceptS =
        "\4\uffff\1\1\1\2\2\uffff";
    static final String DFA5_specialS =
        "\10\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\2\uffff\1\1",
            "\1\3\27\uffff\1\4",
            "\1\5\27\uffff\1\4",
            "\1\6\17\uffff\2\5",
            "",
            "",
            "\1\7",
            "\1\3\27\uffff\1\4"
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
            return "145:1: (this_Assignment_0= ruleAssignment | this_Target_1= ruleTarget )";
        }
    }
    static final String DFA6_eotS =
        "\5\uffff";
    static final String DFA6_eofS =
        "\2\uffff\1\4\2\uffff";
    static final String DFA6_minS =
        "\1\35\1\7\1\25\2\uffff";
    static final String DFA6_maxS =
        "\3\36\2\uffff";
    static final String DFA6_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA6_specialS =
        "\5\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\2\1\1",
            "\1\3\6\uffff\4\3\3\uffff\1\3\2\uffff\1\3\4\uffff\1\2\1\1",
            "\1\4\2\uffff\1\4\4\uffff\1\4\1\3",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "()* loopback of 207:1: ( ruleFillUp ( (lv_arguments_3_0= ruleArgument ) ) )*";
        }
    }
    static final String DFA11_eotS =
        "\4\uffff";
    static final String DFA11_eofS =
        "\1\uffff\1\3\2\uffff";
    static final String DFA11_minS =
        "\1\35\1\7\2\uffff";
    static final String DFA11_maxS =
        "\2\36\2\uffff";
    static final String DFA11_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA11_specialS =
        "\4\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\2\1\1",
            "\1\3\6\uffff\4\3\3\uffff\1\3\2\uffff\1\3\4\uffff\1\2\1\1",
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
            return "263:1: ( (this_WS_0= RULE_WS )+ | ( (this_WS_1= RULE_WS )* this_NEWLINE_2= RULE_NEWLINE (this_WS_3= RULE_WS )+ ) )";
        }
    }
    static final String DFA22_eotS =
        "\13\uffff";
    static final String DFA22_eofS =
        "\3\uffff\1\10\7\uffff";
    static final String DFA22_minS =
        "\1\7\2\uffff\1\7\7\uffff";
    static final String DFA22_maxS =
        "\1\30\2\uffff\1\36\7\uffff";
    static final String DFA22_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\6\1\7\1\11\1\5\1\10\1\4\1\3";
    static final String DFA22_specialS =
        "\13\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\3\6\uffff\1\1\1\2\1\4\1\5\3\uffff\1\6\2\uffff\1\6",
            "",
            "",
            "\1\10\12\uffff\1\11\1\12\1\7\1\10\2\uffff\1\10\3\uffff\3\10",
            "",
            "",
            "",
            "",
            "",
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
            return "414:2: ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) )";
        }
    }
    static final String DFA21_eotS =
        "\11\uffff";
    static final String DFA21_eofS =
        "\1\4\2\3\5\uffff\1\3";
    static final String DFA21_minS =
        "\1\25\2\6\2\uffff\1\15\1\6\1\30\1\6";
    static final String DFA21_maxS =
        "\1\36\2\42\2\uffff\2\36\1\30\1\42";
    static final String DFA21_acceptS =
        "\3\uffff\1\1\1\2\4\uffff";
    static final String DFA21_specialS =
        "\11\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\2\2\uffff\1\1\3\uffff\1\3\2\4",
            "\1\5\1\uffff\1\3\2\uffff\1\3\6\uffff\4\3\2\uffff\1\3\3\uffff\2\3\1\6\3\uffff\1\3",
            "\1\4\1\uffff\1\3\2\uffff\1\3\6\uffff\4\3\2\uffff\1\3\3\uffff\2\3\1\6\3\uffff\1\3",
            "",
            "",
            "\1\7\17\uffff\2\4",
            "\1\4\1\3\6\uffff\4\3\3\uffff\1\3\2\uffff\1\3\4\uffff\1\3\1\6",
            "\1\10",
            "\1\5\1\uffff\1\3\2\uffff\1\3\6\uffff\4\3\2\uffff\1\3\3\uffff\2\3\1\6\3\uffff\1\3"
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
            return "627:3: ( (lv_option_21_0= ruleOption ) )?";
        }
    }
    static final String DFA23_eotS =
        "\16\uffff";
    static final String DFA23_eofS =
        "\1\uffff\6\12\6\uffff\1\12";
    static final String DFA23_minS =
        "\1\22\1\6\5\10\1\uffff\1\15\3\uffff\1\30\1\6";
    static final String DFA23_maxS =
        "\1\42\6\36\1\uffff\1\15\3\uffff\1\30\1\36";
    static final String DFA23_acceptS =
        "\7\uffff\1\4\1\uffff\1\2\1\1\1\3\2\uffff";
    static final String DFA23_specialS =
        "\16\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\3\1\4\1\5\1\2\2\uffff\1\1\3\uffff\1\7\5\uffff\1\6",
            "\1\10\1\uffff\1\11\1\13\13\uffff\1\12\2\uffff\1\12\4\uffff\2\12",
            "\1\11\1\13\13\uffff\1\12\2\uffff\1\12\4\uffff\2\12",
            "\1\11\1\13\13\uffff\1\12\2\uffff\1\12\4\uffff\2\12",
            "\1\11\1\13\13\uffff\1\12\2\uffff\1\12\4\uffff\2\12",
            "\1\11\1\13\13\uffff\1\12\2\uffff\1\12\4\uffff\2\12",
            "\1\11\1\13\13\uffff\1\12\2\uffff\1\12\4\uffff\2\12",
            "",
            "\1\14",
            "",
            "",
            "",
            "\1\15",
            "\1\10\1\uffff\1\11\1\13\13\uffff\1\12\2\uffff\1\12\4\uffff\2\12"
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
            return "757:1: (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro | this_StringMacro_3= ruleStringMacro )";
        }
    }
    static final String DFA28_eotS =
        "\20\uffff";
    static final String DFA28_eofS =
        "\1\1\1\uffff\2\15\13\uffff\1\15";
    static final String DFA28_minS =
        "\1\11\1\uffff\2\6\7\uffff\1\15\1\6\1\uffff\1\30\1\6";
    static final String DFA28_maxS =
        "\1\42\1\uffff\2\42\7\uffff\2\36\1\uffff\1\30\1\42";
    static final String DFA28_acceptS =
        "\1\uffff\1\11\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff\1\1\2\uffff";
    static final String DFA28_specialS =
        "\20\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\5\1\6\7\uffff\1\7\1\10\1\11\1\3\2\uffff\1\2\3\uffff\1\4\2\1\3\uffff\1\12",
            "",
            "\1\13\2\uffff\2\15\7\uffff\4\15\2\uffff\1\15\3\uffff\2\15\1\14\3\uffff\1\15",
            "\1\1\2\uffff\2\15\7\uffff\4\15\2\uffff\1\15\3\uffff\2\15\1\14\3\uffff\1\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16\17\uffff\2\1",
            "\1\1\1\15\6\uffff\4\15\3\uffff\1\15\2\uffff\1\15\4\uffff\1\15\1\14",
            "",
            "\1\17",
            "\1\13\2\uffff\2\15\7\uffff\4\15\2\uffff\1\15\3\uffff\2\15\1\14\3\uffff\1\15"
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1265:1: (this_Identifier_0= ruleIdentifier | this_STRING2_1= RULE_STRING2 | this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN | this_KW_NOSTDINC_4= RULE_KW_NOSTDINC | this_KW_INCSYS_5= RULE_KW_INCSYS | this_KW_INCLUDE_6= RULE_KW_INCLUDE | this_ANY_OTHER_7= RULE_ANY_OTHER )+";
        }
    }
    static final String DFA29_eotS =
        "\11\uffff";
    static final String DFA29_eofS =
        "\1\1\1\uffff\2\4\4\uffff\1\4";
    static final String DFA29_minS =
        "\1\13\1\uffff\2\6\1\uffff\1\15\1\6\1\30\1\6";
    static final String DFA29_maxS =
        "\1\36\1\uffff\2\42\1\uffff\2\36\1\30\1\42";
    static final String DFA29_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\4\uffff";
    static final String DFA29_specialS =
        "\11\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\1\11\uffff\1\3\2\uffff\1\2\3\uffff\1\4\2\1",
            "",
            "\1\5\1\uffff\1\4\2\uffff\1\4\6\uffff\4\4\2\uffff\1\4\3\uffff\2\4\1\6\3\uffff\1\4",
            "\1\1\1\uffff\1\4\2\uffff\1\4\6\uffff\4\4\2\uffff\1\4\3\uffff\2\4\1\6\3\uffff\1\4",
            "",
            "\1\7\17\uffff\2\1",
            "\1\1\1\4\6\uffff\4\4\3\uffff\1\4\2\uffff\1\4\4\uffff\1\4\1\6",
            "\1\10",
            "\1\5\1\uffff\1\4\2\uffff\1\4\6\uffff\4\4\2\uffff\1\4\3\uffff\2\4\1\6\3\uffff\1\4"
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1354:2: (this_OptionPart_0= ruleOptionPart )+";
        }
    }
    static final String DFA31_eotS =
        "\11\uffff";
    static final String DFA31_eofS =
        "\1\1\1\uffff\2\4\4\uffff\1\4";
    static final String DFA31_minS =
        "\1\13\1\uffff\2\6\1\uffff\1\15\1\6\1\30\1\6";
    static final String DFA31_maxS =
        "\1\36\1\uffff\2\42\1\uffff\2\36\1\30\1\42";
    static final String DFA31_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\4\uffff";
    static final String DFA31_specialS =
        "\11\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\1\11\uffff\1\3\2\uffff\1\2\3\uffff\1\4\2\1",
            "",
            "\1\5\1\uffff\1\4\2\uffff\1\4\6\uffff\4\4\2\uffff\1\4\3\uffff\2\4\1\6\3\uffff\1\4",
            "\1\1\1\uffff\1\4\2\uffff\1\4\6\uffff\4\4\2\uffff\1\4\3\uffff\2\4\1\6\3\uffff\1\4",
            "",
            "\1\7\17\uffff\2\1",
            "\1\1\1\4\6\uffff\4\4\3\uffff\1\4\2\uffff\1\4\4\uffff\1\4\1\6",
            "\1\10",
            "\1\5\1\uffff\1\4\2\uffff\1\4\6\uffff\4\4\2\uffff\1\4\3\uffff\2\4\1\6\3\uffff\1\4"
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1379:3: (this_OptionPart_3= ruleOptionPart )+";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000021200002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000021200000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000123C080L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000040000040L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000000004123C080L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000004113C0000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000000113C0000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00000000513C0000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000011200082L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000011200002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000004113C0600L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000004013C0400L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00000004013C0000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000004113C0602L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000011200802L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000011200080L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000011200000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00000004001C0102L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000001000000L});

}