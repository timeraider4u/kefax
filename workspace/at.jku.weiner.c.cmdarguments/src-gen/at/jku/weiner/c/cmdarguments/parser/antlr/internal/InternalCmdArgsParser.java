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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SKW_DOT", "RULE_SKW_DIV", "RULE_SKW_COLON", "RULE_SKW_MINUS", "RULE_SKW_ASSIGN", "RULE_SKW_LEFTPAREN", "RULE_SKW_RIGHTPAREN", "RULE_SKW_COMMA", "RULE_SKW_DOLLAR", "RULE_SKW_BACKSLASH", "RULE_KW_DEFINE", "RULE_KW_INCDIR", "RULE_KW_OUTPUT", "RULE_KW_LANG", "RULE_KW_NOSTDINC", "RULE_KW_INCSYS", "RULE_KW_INCLUDE", "RULE_KW_VAR", "RULE_ID_PART_1", "RULE_ID_PART_2", "RULE_ID", "RULE_LETTER", "RULE_INT", "RULE_QUOTE1", "RULE_DIGIT", "RULE_NEWLINE", "RULE_WS", "RULE_SKW_HASH1", "RULE_SKW_HASH2", "RULE_LINE_BREAK", "RULE_LINE_COMMENT", "RULE_ANY_OTHER"
    };
    public static final int RULE_SKW_MINUS=7;
    public static final int RULE_ID=24;
    public static final int RULE_NEWLINE=29;
    public static final int RULE_ID_PART_1=22;
    public static final int RULE_KW_INCDIR=15;
    public static final int RULE_ID_PART_2=23;
    public static final int RULE_KW_OUTPUT=16;
    public static final int RULE_ANY_OTHER=35;
    public static final int RULE_SKW_DOLLAR=12;
    public static final int RULE_KW_NOSTDINC=18;
    public static final int RULE_SKW_DOT=4;
    public static final int RULE_SKW_DIV=5;
    public static final int RULE_LINE_BREAK=33;
    public static final int EOF=-1;
    public static final int RULE_LETTER=25;
    public static final int RULE_KW_VAR=21;
    public static final int RULE_SKW_RIGHTPAREN=10;
    public static final int RULE_KW_INCLUDE=20;
    public static final int RULE_KW_DEFINE=14;
    public static final int RULE_KW_LANG=17;
    public static final int RULE_QUOTE1=27;
    public static final int RULE_SKW_HASH2=32;
    public static final int RULE_SKW_HASH1=31;
    public static final int RULE_KW_INCSYS=19;
    public static final int RULE_LINE_COMMENT=34;
    public static final int RULE_INT=26;
    public static final int RULE_SKW_BACKSLASH=13;
    public static final int RULE_SKW_COMMA=11;
    public static final int RULE_WS=30;
    public static final int RULE_DIGIT=28;
    public static final int RULE_SKW_COLON=6;
    public static final int RULE_SKW_LEFTPAREN=9;
    public static final int RULE_SKW_ASSIGN=8;

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
    // InternalCmdArgsParser.g:309:1: ruleAssignment returns [EObject current=null] : ( ( (lv_start_0_0= ruleIdentifier ) ) (this_WS_1= RULE_WS )+ this_SKW_COLON_2= RULE_SKW_COLON this_SKW_ASSIGN_3= RULE_SKW_ASSIGN (this_WS_4= RULE_WS )+ ( ( (lv_arguments_5_0= ruleArgument ) ) ( (this_WS_6= RULE_WS )+ ( (lv_arguments_7_0= ruleArgument ) ) )* ) (this_WS_8= RULE_WS )? ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token this_SKW_COLON_2=null;
        Token this_SKW_ASSIGN_3=null;
        Token this_WS_4=null;
        Token this_WS_6=null;
        Token this_WS_8=null;
        AntlrDatatypeRuleToken lv_start_0_0 = null;

        EObject lv_arguments_5_0 = null;

        EObject lv_arguments_7_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:312:28: ( ( ( (lv_start_0_0= ruleIdentifier ) ) (this_WS_1= RULE_WS )+ this_SKW_COLON_2= RULE_SKW_COLON this_SKW_ASSIGN_3= RULE_SKW_ASSIGN (this_WS_4= RULE_WS )+ ( ( (lv_arguments_5_0= ruleArgument ) ) ( (this_WS_6= RULE_WS )+ ( (lv_arguments_7_0= ruleArgument ) ) )* ) (this_WS_8= RULE_WS )? ) )
            // InternalCmdArgsParser.g:313:1: ( ( (lv_start_0_0= ruleIdentifier ) ) (this_WS_1= RULE_WS )+ this_SKW_COLON_2= RULE_SKW_COLON this_SKW_ASSIGN_3= RULE_SKW_ASSIGN (this_WS_4= RULE_WS )+ ( ( (lv_arguments_5_0= ruleArgument ) ) ( (this_WS_6= RULE_WS )+ ( (lv_arguments_7_0= ruleArgument ) ) )* ) (this_WS_8= RULE_WS )? )
            {
            // InternalCmdArgsParser.g:313:1: ( ( (lv_start_0_0= ruleIdentifier ) ) (this_WS_1= RULE_WS )+ this_SKW_COLON_2= RULE_SKW_COLON this_SKW_ASSIGN_3= RULE_SKW_ASSIGN (this_WS_4= RULE_WS )+ ( ( (lv_arguments_5_0= ruleArgument ) ) ( (this_WS_6= RULE_WS )+ ( (lv_arguments_7_0= ruleArgument ) ) )* ) (this_WS_8= RULE_WS )? )
            // InternalCmdArgsParser.g:313:2: ( (lv_start_0_0= ruleIdentifier ) ) (this_WS_1= RULE_WS )+ this_SKW_COLON_2= RULE_SKW_COLON this_SKW_ASSIGN_3= RULE_SKW_ASSIGN (this_WS_4= RULE_WS )+ ( ( (lv_arguments_5_0= ruleArgument ) ) ( (this_WS_6= RULE_WS )+ ( (lv_arguments_7_0= ruleArgument ) ) )* ) (this_WS_8= RULE_WS )?
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
                alt15 = dfa15.predict(input);
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

            // InternalCmdArgsParser.g:387:5: (this_WS_8= RULE_WS )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_WS) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalCmdArgsParser.g:387:6: this_WS_8= RULE_WS
                    {
                    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_2); 
                     
                        newLeafNode(this_WS_8, grammarAccess.getAssignmentAccess().getWSTerminalRuleCall_6()); 
                        

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
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleArgument"
    // InternalCmdArgsParser.g:399:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // InternalCmdArgsParser.g:400:2: (iv_ruleArgument= ruleArgument EOF )
            // InternalCmdArgsParser.g:401:2: iv_ruleArgument= ruleArgument EOF
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
    // InternalCmdArgsParser.g:408:1: ruleArgument returns [EObject current=null] : ( () ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) ) ) ;
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
            // InternalCmdArgsParser.g:411:28: ( ( () ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) ) ) )
            // InternalCmdArgsParser.g:412:1: ( () ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) ) )
            {
            // InternalCmdArgsParser.g:412:1: ( () ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) ) )
            // InternalCmdArgsParser.g:412:2: () ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) )
            {
            // InternalCmdArgsParser.g:412:2: ()
            // InternalCmdArgsParser.g:413:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArgumentAccess().getArgumentAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:418:2: ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) )
            int alt23=9;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalCmdArgsParser.g:418:3: (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) )
                    {
                    // InternalCmdArgsParser.g:418:3: (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) )
                    // InternalCmdArgsParser.g:418:4: this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) )
                    {
                    this_KW_DEFINE_1=(Token)match(input,RULE_KW_DEFINE,FOLLOW_13); 
                     
                        newLeafNode(this_KW_DEFINE_1, grammarAccess.getArgumentAccess().getKW_DEFINETerminalRuleCall_1_0_0()); 
                        
                    // InternalCmdArgsParser.g:422:1: ( (lv_macro_2_0= ruleMacro ) )
                    // InternalCmdArgsParser.g:423:1: (lv_macro_2_0= ruleMacro )
                    {
                    // InternalCmdArgsParser.g:423:1: (lv_macro_2_0= ruleMacro )
                    // InternalCmdArgsParser.g:424:3: lv_macro_2_0= ruleMacro
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
                    // InternalCmdArgsParser.g:441:6: ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:441:6: ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:441:7: ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) )
                    {
                    // InternalCmdArgsParser.g:441:7: ( (lv_incDir_3_0= RULE_KW_INCDIR ) )
                    // InternalCmdArgsParser.g:442:1: (lv_incDir_3_0= RULE_KW_INCDIR )
                    {
                    // InternalCmdArgsParser.g:442:1: (lv_incDir_3_0= RULE_KW_INCDIR )
                    // InternalCmdArgsParser.g:443:3: lv_incDir_3_0= RULE_KW_INCDIR
                    {
                    lv_incDir_3_0=(Token)match(input,RULE_KW_INCDIR,FOLLOW_13); 

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

                    // InternalCmdArgsParser.g:459:2: ( (lv_useIncDir_4_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:460:1: (lv_useIncDir_4_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:460:1: (lv_useIncDir_4_0= rulePathCmd )
                    // InternalCmdArgsParser.g:461:3: lv_useIncDir_4_0= rulePathCmd
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
                    // InternalCmdArgsParser.g:478:6: ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:478:6: ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:478:7: ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) )
                    {
                    // InternalCmdArgsParser.g:478:7: ( (lv_incSys_5_0= ruleIncSys ) )
                    // InternalCmdArgsParser.g:479:1: (lv_incSys_5_0= ruleIncSys )
                    {
                    // InternalCmdArgsParser.g:479:1: (lv_incSys_5_0= ruleIncSys )
                    // InternalCmdArgsParser.g:480:3: lv_incSys_5_0= ruleIncSys
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

                    // InternalCmdArgsParser.g:496:2: (this_WS_6= RULE_WS )+
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
                    	    // InternalCmdArgsParser.g:496:3: this_WS_6= RULE_WS
                    	    {
                    	    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_14); 
                    	     
                    	        newLeafNode(this_WS_6, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_2_1()); 
                    	        

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

                    // InternalCmdArgsParser.g:500:3: ( (lv_useIncDir_7_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:501:1: (lv_useIncDir_7_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:501:1: (lv_useIncDir_7_0= rulePathCmd )
                    // InternalCmdArgsParser.g:502:3: lv_useIncDir_7_0= rulePathCmd
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
                    // InternalCmdArgsParser.g:519:6: ( (lv_nostdinc_8_0= ruleNoStdInc ) )
                    {
                    // InternalCmdArgsParser.g:519:6: ( (lv_nostdinc_8_0= ruleNoStdInc ) )
                    // InternalCmdArgsParser.g:520:1: (lv_nostdinc_8_0= ruleNoStdInc )
                    {
                    // InternalCmdArgsParser.g:520:1: (lv_nostdinc_8_0= ruleNoStdInc )
                    // InternalCmdArgsParser.g:521:3: lv_nostdinc_8_0= ruleNoStdInc
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
                    // InternalCmdArgsParser.g:538:6: (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:538:6: (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:538:7: this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) )
                    {
                    this_SKW_MINUS_9=(Token)match(input,RULE_SKW_MINUS,FOLLOW_15); 
                     
                        newLeafNode(this_SKW_MINUS_9, grammarAccess.getArgumentAccess().getSKW_MINUSTerminalRuleCall_1_4_0()); 
                        
                    this_KW_INCLUDE_10=(Token)match(input,RULE_KW_INCLUDE,FOLLOW_9); 
                     
                        newLeafNode(this_KW_INCLUDE_10, grammarAccess.getArgumentAccess().getKW_INCLUDETerminalRuleCall_1_4_1()); 
                        
                    // InternalCmdArgsParser.g:546:1: (this_WS_11= RULE_WS )+
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
                    	    // InternalCmdArgsParser.g:546:2: this_WS_11= RULE_WS
                    	    {
                    	    this_WS_11=(Token)match(input,RULE_WS,FOLLOW_14); 
                    	     
                    	        newLeafNode(this_WS_11, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_4_2()); 
                    	        

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

                    // InternalCmdArgsParser.g:550:3: ( (lv_include_12_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:551:1: (lv_include_12_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:551:1: (lv_include_12_0= rulePathCmd )
                    // InternalCmdArgsParser.g:552:3: lv_include_12_0= rulePathCmd
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
                    // InternalCmdArgsParser.g:569:6: (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:569:6: (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:569:7: this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) )
                    {
                    this_KW_OUTPUT_13=(Token)match(input,RULE_KW_OUTPUT,FOLLOW_9); 
                     
                        newLeafNode(this_KW_OUTPUT_13, grammarAccess.getArgumentAccess().getKW_OUTPUTTerminalRuleCall_1_5_0()); 
                        
                    // InternalCmdArgsParser.g:573:1: (this_WS_14= RULE_WS )+
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
                    	    // InternalCmdArgsParser.g:573:2: this_WS_14= RULE_WS
                    	    {
                    	    this_WS_14=(Token)match(input,RULE_WS,FOLLOW_14); 
                    	     
                    	        newLeafNode(this_WS_14, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_5_1()); 
                    	        

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

                    // InternalCmdArgsParser.g:577:3: ( (lv_out_15_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:578:1: (lv_out_15_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:578:1: (lv_out_15_0= rulePathCmd )
                    // InternalCmdArgsParser.g:579:3: lv_out_15_0= rulePathCmd
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
                    // InternalCmdArgsParser.g:596:6: (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) )
                    {
                    // InternalCmdArgsParser.g:596:6: (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) )
                    // InternalCmdArgsParser.g:596:7: this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) )
                    {
                    this_KW_LANG_16=(Token)match(input,RULE_KW_LANG,FOLLOW_9); 
                     
                        newLeafNode(this_KW_LANG_16, grammarAccess.getArgumentAccess().getKW_LANGTerminalRuleCall_1_6_0()); 
                        
                    // InternalCmdArgsParser.g:600:1: (this_WS_17= RULE_WS )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_WS) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:600:2: this_WS_17= RULE_WS
                    	    {
                    	    this_WS_17=(Token)match(input,RULE_WS,FOLLOW_14); 
                    	     
                    	        newLeafNode(this_WS_17, grammarAccess.getArgumentAccess().getWSTerminalRuleCall_1_6_1()); 
                    	        

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

                    // InternalCmdArgsParser.g:604:3: ( (lv_lang_18_0= rulePathCmd ) )
                    // InternalCmdArgsParser.g:605:1: (lv_lang_18_0= rulePathCmd )
                    {
                    // InternalCmdArgsParser.g:605:1: (lv_lang_18_0= rulePathCmd )
                    // InternalCmdArgsParser.g:606:3: lv_lang_18_0= rulePathCmd
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
                    // InternalCmdArgsParser.g:623:6: (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? )
                    {
                    // InternalCmdArgsParser.g:623:6: (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? )
                    // InternalCmdArgsParser.g:623:7: this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )?
                    {
                    this_SKW_MINUS_19=(Token)match(input,RULE_SKW_MINUS,FOLLOW_16); 
                     
                        newLeafNode(this_SKW_MINUS_19, grammarAccess.getArgumentAccess().getSKW_MINUSTerminalRuleCall_1_7_0()); 
                        
                    // InternalCmdArgsParser.g:627:1: (this_SKW_MINUS_20= RULE_SKW_MINUS )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==RULE_SKW_MINUS) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalCmdArgsParser.g:627:2: this_SKW_MINUS_20= RULE_SKW_MINUS
                            {
                            this_SKW_MINUS_20=(Token)match(input,RULE_SKW_MINUS,FOLLOW_17); 
                             
                                newLeafNode(this_SKW_MINUS_20, grammarAccess.getArgumentAccess().getSKW_MINUSTerminalRuleCall_1_7_1()); 
                                

                            }
                            break;

                    }

                    // InternalCmdArgsParser.g:631:3: ( (lv_option_21_0= ruleOption ) )?
                    int alt22=2;
                    alt22 = dfa22.predict(input);
                    switch (alt22) {
                        case 1 :
                            // InternalCmdArgsParser.g:632:1: (lv_option_21_0= ruleOption )
                            {
                            // InternalCmdArgsParser.g:632:1: (lv_option_21_0= ruleOption )
                            // InternalCmdArgsParser.g:633:3: lv_option_21_0= ruleOption
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
                    // InternalCmdArgsParser.g:650:6: ( (lv_in_22_0= ruleIdentifier ) )
                    {
                    // InternalCmdArgsParser.g:650:6: ( (lv_in_22_0= ruleIdentifier ) )
                    // InternalCmdArgsParser.g:651:1: (lv_in_22_0= ruleIdentifier )
                    {
                    // InternalCmdArgsParser.g:651:1: (lv_in_22_0= ruleIdentifier )
                    // InternalCmdArgsParser.g:652:3: lv_in_22_0= ruleIdentifier
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
    // InternalCmdArgsParser.g:676:1: entryRuleIncSys returns [String current=null] : iv_ruleIncSys= ruleIncSys EOF ;
    public final String entryRuleIncSys() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIncSys = null;


        try {
            // InternalCmdArgsParser.g:677:1: (iv_ruleIncSys= ruleIncSys EOF )
            // InternalCmdArgsParser.g:678:2: iv_ruleIncSys= ruleIncSys EOF
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
    // InternalCmdArgsParser.g:685:1: ruleIncSys returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS ) ;
    public final AntlrDatatypeRuleToken ruleIncSys() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_MINUS_0=null;
        Token this_KW_INCSYS_1=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:689:6: ( (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS ) )
            // InternalCmdArgsParser.g:690:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS )
            {
            // InternalCmdArgsParser.g:690:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS )
            // InternalCmdArgsParser.g:690:6: this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_INCSYS_1= RULE_KW_INCSYS
            {
            this_SKW_MINUS_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_18); 

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
    // InternalCmdArgsParser.g:712:1: entryRuleNoStdInc returns [String current=null] : iv_ruleNoStdInc= ruleNoStdInc EOF ;
    public final String entryRuleNoStdInc() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoStdInc = null;


        try {
            // InternalCmdArgsParser.g:713:1: (iv_ruleNoStdInc= ruleNoStdInc EOF )
            // InternalCmdArgsParser.g:714:2: iv_ruleNoStdInc= ruleNoStdInc EOF
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
    // InternalCmdArgsParser.g:721:1: ruleNoStdInc returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC ) ;
    public final AntlrDatatypeRuleToken ruleNoStdInc() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_MINUS_0=null;
        Token this_KW_NOSTDINC_1=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:725:6: ( (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC ) )
            // InternalCmdArgsParser.g:726:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC )
            {
            // InternalCmdArgsParser.g:726:1: (this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC )
            // InternalCmdArgsParser.g:726:6: this_SKW_MINUS_0= RULE_SKW_MINUS this_KW_NOSTDINC_1= RULE_KW_NOSTDINC
            {
            this_SKW_MINUS_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_19); 

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
    // InternalCmdArgsParser.g:748:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // InternalCmdArgsParser.g:749:2: (iv_ruleMacro= ruleMacro EOF )
            // InternalCmdArgsParser.g:750:2: iv_ruleMacro= ruleMacro EOF
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
    // InternalCmdArgsParser.g:757:1: ruleMacro returns [EObject current=null] : (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro | this_StringMacro_3= ruleStringMacro ) ;
    public final EObject ruleMacro() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleMacro_0 = null;

        EObject this_ObjectMacro_1 = null;

        EObject this_FunctionMacro_2 = null;

        EObject this_StringMacro_3 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:760:28: ( (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro | this_StringMacro_3= ruleStringMacro ) )
            // InternalCmdArgsParser.g:761:1: (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro | this_StringMacro_3= ruleStringMacro )
            {
            // InternalCmdArgsParser.g:761:1: (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro | this_StringMacro_3= ruleStringMacro )
            int alt24=4;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // InternalCmdArgsParser.g:762:5: this_SimpleMacro_0= ruleSimpleMacro
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
                    // InternalCmdArgsParser.g:772:5: this_ObjectMacro_1= ruleObjectMacro
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
                    // InternalCmdArgsParser.g:782:5: this_FunctionMacro_2= ruleFunctionMacro
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
                    // InternalCmdArgsParser.g:792:5: this_StringMacro_3= ruleStringMacro
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
    // InternalCmdArgsParser.g:808:1: entryRuleSimpleMacro returns [EObject current=null] : iv_ruleSimpleMacro= ruleSimpleMacro EOF ;
    public final EObject entryRuleSimpleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleMacro = null;


        try {
            // InternalCmdArgsParser.g:809:2: (iv_ruleSimpleMacro= ruleSimpleMacro EOF )
            // InternalCmdArgsParser.g:810:2: iv_ruleSimpleMacro= ruleSimpleMacro EOF
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
    // InternalCmdArgsParser.g:817:1: ruleSimpleMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) ) ;
    public final EObject ruleSimpleMacro() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:820:28: ( ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) ) )
            // InternalCmdArgsParser.g:821:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) )
            {
            // InternalCmdArgsParser.g:821:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) )
            // InternalCmdArgsParser.g:821:2: () ( (lv_name_1_0= ruleMacroLegalPart ) )
            {
            // InternalCmdArgsParser.g:821:2: ()
            // InternalCmdArgsParser.g:822:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSimpleMacroAccess().getSimpleMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:827:2: ( (lv_name_1_0= ruleMacroLegalPart ) )
            // InternalCmdArgsParser.g:828:1: (lv_name_1_0= ruleMacroLegalPart )
            {
            // InternalCmdArgsParser.g:828:1: (lv_name_1_0= ruleMacroLegalPart )
            // InternalCmdArgsParser.g:829:3: lv_name_1_0= ruleMacroLegalPart
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
    // InternalCmdArgsParser.g:853:1: entryRuleObjectMacro returns [EObject current=null] : iv_ruleObjectMacro= ruleObjectMacro EOF ;
    public final EObject entryRuleObjectMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectMacro = null;


        try {
            // InternalCmdArgsParser.g:854:2: (iv_ruleObjectMacro= ruleObjectMacro EOF )
            // InternalCmdArgsParser.g:855:2: iv_ruleObjectMacro= ruleObjectMacro EOF
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
    // InternalCmdArgsParser.g:862:1: ruleObjectMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) ) ;
    public final EObject ruleObjectMacro() throws RecognitionException {
        EObject current = null;

        Token this_SKW_ASSIGN_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:865:28: ( ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) ) )
            // InternalCmdArgsParser.g:866:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) )
            {
            // InternalCmdArgsParser.g:866:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) ) )
            // InternalCmdArgsParser.g:866:2: () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_ASSIGN_2= RULE_SKW_ASSIGN ( (lv_value_3_0= ruleMyCode ) )
            {
            // InternalCmdArgsParser.g:866:2: ()
            // InternalCmdArgsParser.g:867:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getObjectMacroAccess().getObjectMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:872:2: ( (lv_name_1_0= ruleMacroLegalPart ) )
            // InternalCmdArgsParser.g:873:1: (lv_name_1_0= ruleMacroLegalPart )
            {
            // InternalCmdArgsParser.g:873:1: (lv_name_1_0= ruleMacroLegalPart )
            // InternalCmdArgsParser.g:874:3: lv_name_1_0= ruleMacroLegalPart
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

            this_SKW_ASSIGN_2=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_20); 
             
                newLeafNode(this_SKW_ASSIGN_2, grammarAccess.getObjectMacroAccess().getSKW_ASSIGNTerminalRuleCall_2()); 
                
            // InternalCmdArgsParser.g:894:1: ( (lv_value_3_0= ruleMyCode ) )
            // InternalCmdArgsParser.g:895:1: (lv_value_3_0= ruleMyCode )
            {
            // InternalCmdArgsParser.g:895:1: (lv_value_3_0= ruleMyCode )
            // InternalCmdArgsParser.g:896:3: lv_value_3_0= ruleMyCode
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
    // InternalCmdArgsParser.g:920:1: entryRuleFunctionMacro returns [EObject current=null] : iv_ruleFunctionMacro= ruleFunctionMacro EOF ;
    public final EObject entryRuleFunctionMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionMacro = null;


        try {
            // InternalCmdArgsParser.g:921:2: (iv_ruleFunctionMacro= ruleFunctionMacro EOF )
            // InternalCmdArgsParser.g:922:2: iv_ruleFunctionMacro= ruleFunctionMacro EOF
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
    // InternalCmdArgsParser.g:929:1: ruleFunctionMacro returns [EObject current=null] : ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) ) ;
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
            // InternalCmdArgsParser.g:932:28: ( ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) ) )
            // InternalCmdArgsParser.g:933:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) )
            {
            // InternalCmdArgsParser.g:933:1: ( () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) ) )
            // InternalCmdArgsParser.g:933:2: () ( (lv_name_1_0= ruleMacroLegalPart ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )? this_SKW_RIGHTPAREN_6= RULE_SKW_RIGHTPAREN this_SKW_ASSIGN_7= RULE_SKW_ASSIGN ( (lv_value_8_0= ruleMyCode ) )
            {
            // InternalCmdArgsParser.g:933:2: ()
            // InternalCmdArgsParser.g:934:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFunctionMacroAccess().getFunctionMacroAction_0(),
                        current);
                

            }

            // InternalCmdArgsParser.g:939:2: ( (lv_name_1_0= ruleMacroLegalPart ) )
            // InternalCmdArgsParser.g:940:1: (lv_name_1_0= ruleMacroLegalPart )
            {
            // InternalCmdArgsParser.g:940:1: (lv_name_1_0= ruleMacroLegalPart )
            // InternalCmdArgsParser.g:941:3: lv_name_1_0= ruleMacroLegalPart
            {
             
            	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getNameMacroLegalPartParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_21);
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

            this_SKW_LEFTPAREN_2=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_22); 
             
                newLeafNode(this_SKW_LEFTPAREN_2, grammarAccess.getFunctionMacroAccess().getSKW_LEFTPARENTerminalRuleCall_2()); 
                
            // InternalCmdArgsParser.g:961:1: ( ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_KW_NOSTDINC && LA26_0<=RULE_KW_VAR)||LA26_0==RULE_ID||LA26_0==RULE_ANY_OTHER) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalCmdArgsParser.g:961:2: ( (lv_params_3_0= ruleMacroLegalPart ) ) (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )*
                    {
                    // InternalCmdArgsParser.g:961:2: ( (lv_params_3_0= ruleMacroLegalPart ) )
                    // InternalCmdArgsParser.g:962:1: (lv_params_3_0= ruleMacroLegalPart )
                    {
                    // InternalCmdArgsParser.g:962:1: (lv_params_3_0= ruleMacroLegalPart )
                    // InternalCmdArgsParser.g:963:3: lv_params_3_0= ruleMacroLegalPart
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getParamsMacroLegalPartParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_23);
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

                    // InternalCmdArgsParser.g:979:2: (this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==RULE_SKW_COMMA) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:979:3: this_SKW_COMMA_4= RULE_SKW_COMMA ( (lv_params_5_0= ruleMacroLegalPart ) )
                    	    {
                    	    this_SKW_COMMA_4=(Token)match(input,RULE_SKW_COMMA,FOLLOW_24); 
                    	     
                    	        newLeafNode(this_SKW_COMMA_4, grammarAccess.getFunctionMacroAccess().getSKW_COMMATerminalRuleCall_3_1_0()); 
                    	        
                    	    // InternalCmdArgsParser.g:983:1: ( (lv_params_5_0= ruleMacroLegalPart ) )
                    	    // InternalCmdArgsParser.g:984:1: (lv_params_5_0= ruleMacroLegalPart )
                    	    {
                    	    // InternalCmdArgsParser.g:984:1: (lv_params_5_0= ruleMacroLegalPart )
                    	    // InternalCmdArgsParser.g:985:3: lv_params_5_0= ruleMacroLegalPart
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionMacroAccess().getParamsMacroLegalPartParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_23);
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
                    	    break loop25;
                        }
                    } while (true);


                    }
                    break;

            }

            this_SKW_RIGHTPAREN_6=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_11); 
             
                newLeafNode(this_SKW_RIGHTPAREN_6, grammarAccess.getFunctionMacroAccess().getSKW_RIGHTPARENTerminalRuleCall_4()); 
                
            this_SKW_ASSIGN_7=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_20); 
             
                newLeafNode(this_SKW_ASSIGN_7, grammarAccess.getFunctionMacroAccess().getSKW_ASSIGNTerminalRuleCall_5()); 
                
            // InternalCmdArgsParser.g:1009:1: ( (lv_value_8_0= ruleMyCode ) )
            // InternalCmdArgsParser.g:1010:1: (lv_value_8_0= ruleMyCode )
            {
            // InternalCmdArgsParser.g:1010:1: (lv_value_8_0= ruleMyCode )
            // InternalCmdArgsParser.g:1011:3: lv_value_8_0= ruleMyCode
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
    // InternalCmdArgsParser.g:1035:1: entryRuleStringMacro returns [EObject current=null] : iv_ruleStringMacro= ruleStringMacro EOF ;
    public final EObject entryRuleStringMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringMacro = null;


        try {
            // InternalCmdArgsParser.g:1036:2: (iv_ruleStringMacro= ruleStringMacro EOF )
            // InternalCmdArgsParser.g:1037:2: iv_ruleStringMacro= ruleStringMacro EOF
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
    // InternalCmdArgsParser.g:1044:1: ruleStringMacro returns [EObject current=null] : ( () this_QUOTE1_1= RULE_QUOTE1 ( (lv_macro_2_0= ruleMacro ) ) this_QUOTE1_3= RULE_QUOTE1 ) ;
    public final EObject ruleStringMacro() throws RecognitionException {
        EObject current = null;

        Token this_QUOTE1_1=null;
        Token this_QUOTE1_3=null;
        EObject lv_macro_2_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1047:28: ( ( () this_QUOTE1_1= RULE_QUOTE1 ( (lv_macro_2_0= ruleMacro ) ) this_QUOTE1_3= RULE_QUOTE1 ) )
            // InternalCmdArgsParser.g:1048:1: ( () this_QUOTE1_1= RULE_QUOTE1 ( (lv_macro_2_0= ruleMacro ) ) this_QUOTE1_3= RULE_QUOTE1 )
            {
            // InternalCmdArgsParser.g:1048:1: ( () this_QUOTE1_1= RULE_QUOTE1 ( (lv_macro_2_0= ruleMacro ) ) this_QUOTE1_3= RULE_QUOTE1 )
            // InternalCmdArgsParser.g:1048:2: () this_QUOTE1_1= RULE_QUOTE1 ( (lv_macro_2_0= ruleMacro ) ) this_QUOTE1_3= RULE_QUOTE1
            {
            // InternalCmdArgsParser.g:1048:2: ()
            // InternalCmdArgsParser.g:1049:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringMacroAccess().getStringMacroAction_0(),
                        current);
                

            }

            this_QUOTE1_1=(Token)match(input,RULE_QUOTE1,FOLLOW_13); 
             
                newLeafNode(this_QUOTE1_1, grammarAccess.getStringMacroAccess().getQUOTE1TerminalRuleCall_1()); 
                
            // InternalCmdArgsParser.g:1058:1: ( (lv_macro_2_0= ruleMacro ) )
            // InternalCmdArgsParser.g:1059:1: (lv_macro_2_0= ruleMacro )
            {
            // InternalCmdArgsParser.g:1059:1: (lv_macro_2_0= ruleMacro )
            // InternalCmdArgsParser.g:1060:3: lv_macro_2_0= ruleMacro
            {
             
            	        newCompositeNode(grammarAccess.getStringMacroAccess().getMacroMacroParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_25);
            lv_macro_2_0=ruleMacro();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStringMacroRule());
            	        }
                   		set(
                   			current, 
                   			"macro",
                    		lv_macro_2_0, 
                    		"at.jku.weiner.c.cmdarguments.CmdArgs.Macro");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_QUOTE1_3=(Token)match(input,RULE_QUOTE1,FOLLOW_2); 
             
                newLeafNode(this_QUOTE1_3, grammarAccess.getStringMacroAccess().getQUOTE1TerminalRuleCall_3()); 
                

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
    // InternalCmdArgsParser.g:1088:1: entryRulePathCmd returns [EObject current=null] : iv_rulePathCmd= rulePathCmd EOF ;
    public final EObject entryRulePathCmd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathCmd = null;


        try {
            // InternalCmdArgsParser.g:1089:2: (iv_rulePathCmd= rulePathCmd EOF )
            // InternalCmdArgsParser.g:1090:2: iv_rulePathCmd= rulePathCmd EOF
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
    // InternalCmdArgsParser.g:1097:1: rulePathCmd returns [EObject current=null] : ( ( () ( (lv_path_1_0= rulePathLegalPart1 ) ) ) | (this_QUOTE1_2= RULE_QUOTE1 ( (lv_path_3_0= rulePathLegalPart2 ) ) this_QUOTE1_4= RULE_QUOTE1 ) ) ;
    public final EObject rulePathCmd() throws RecognitionException {
        EObject current = null;

        Token this_QUOTE1_2=null;
        Token this_QUOTE1_4=null;
        AntlrDatatypeRuleToken lv_path_1_0 = null;

        AntlrDatatypeRuleToken lv_path_3_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1100:28: ( ( ( () ( (lv_path_1_0= rulePathLegalPart1 ) ) ) | (this_QUOTE1_2= RULE_QUOTE1 ( (lv_path_3_0= rulePathLegalPart2 ) ) this_QUOTE1_4= RULE_QUOTE1 ) ) )
            // InternalCmdArgsParser.g:1101:1: ( ( () ( (lv_path_1_0= rulePathLegalPart1 ) ) ) | (this_QUOTE1_2= RULE_QUOTE1 ( (lv_path_3_0= rulePathLegalPart2 ) ) this_QUOTE1_4= RULE_QUOTE1 ) )
            {
            // InternalCmdArgsParser.g:1101:1: ( ( () ( (lv_path_1_0= rulePathLegalPart1 ) ) ) | (this_QUOTE1_2= RULE_QUOTE1 ( (lv_path_3_0= rulePathLegalPart2 ) ) this_QUOTE1_4= RULE_QUOTE1 ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=RULE_KW_NOSTDINC && LA27_0<=RULE_KW_VAR)||LA27_0==RULE_ID||LA27_0==RULE_ANY_OTHER) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_QUOTE1) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalCmdArgsParser.g:1101:2: ( () ( (lv_path_1_0= rulePathLegalPart1 ) ) )
                    {
                    // InternalCmdArgsParser.g:1101:2: ( () ( (lv_path_1_0= rulePathLegalPart1 ) ) )
                    // InternalCmdArgsParser.g:1101:3: () ( (lv_path_1_0= rulePathLegalPart1 ) )
                    {
                    // InternalCmdArgsParser.g:1101:3: ()
                    // InternalCmdArgsParser.g:1102:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPathCmdAccess().getPathCmdAction_0_0(),
                                current);
                        

                    }

                    // InternalCmdArgsParser.g:1107:2: ( (lv_path_1_0= rulePathLegalPart1 ) )
                    // InternalCmdArgsParser.g:1108:1: (lv_path_1_0= rulePathLegalPart1 )
                    {
                    // InternalCmdArgsParser.g:1108:1: (lv_path_1_0= rulePathLegalPart1 )
                    // InternalCmdArgsParser.g:1109:3: lv_path_1_0= rulePathLegalPart1
                    {
                     
                    	        newCompositeNode(grammarAccess.getPathCmdAccess().getPathPathLegalPart1ParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_path_1_0=rulePathLegalPart1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPathCmdRule());
                    	        }
                           		set(
                           			current, 
                           			"path",
                            		lv_path_1_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.PathLegalPart1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:1126:6: (this_QUOTE1_2= RULE_QUOTE1 ( (lv_path_3_0= rulePathLegalPart2 ) ) this_QUOTE1_4= RULE_QUOTE1 )
                    {
                    // InternalCmdArgsParser.g:1126:6: (this_QUOTE1_2= RULE_QUOTE1 ( (lv_path_3_0= rulePathLegalPart2 ) ) this_QUOTE1_4= RULE_QUOTE1 )
                    // InternalCmdArgsParser.g:1126:7: this_QUOTE1_2= RULE_QUOTE1 ( (lv_path_3_0= rulePathLegalPart2 ) ) this_QUOTE1_4= RULE_QUOTE1
                    {
                    this_QUOTE1_2=(Token)match(input,RULE_QUOTE1,FOLLOW_26); 
                     
                        newLeafNode(this_QUOTE1_2, grammarAccess.getPathCmdAccess().getQUOTE1TerminalRuleCall_1_0()); 
                        
                    // InternalCmdArgsParser.g:1130:1: ( (lv_path_3_0= rulePathLegalPart2 ) )
                    // InternalCmdArgsParser.g:1131:1: (lv_path_3_0= rulePathLegalPart2 )
                    {
                    // InternalCmdArgsParser.g:1131:1: (lv_path_3_0= rulePathLegalPart2 )
                    // InternalCmdArgsParser.g:1132:3: lv_path_3_0= rulePathLegalPart2
                    {
                     
                    	        newCompositeNode(grammarAccess.getPathCmdAccess().getPathPathLegalPart2ParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_25);
                    lv_path_3_0=rulePathLegalPart2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPathCmdRule());
                    	        }
                           		set(
                           			current, 
                           			"path",
                            		lv_path_3_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.PathLegalPart2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    this_QUOTE1_4=(Token)match(input,RULE_QUOTE1,FOLLOW_2); 
                     
                        newLeafNode(this_QUOTE1_4, grammarAccess.getPathCmdAccess().getQUOTE1TerminalRuleCall_1_2()); 
                        

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
    // $ANTLR end "rulePathCmd"


    // $ANTLR start "entryRulePathLegalPartCommon"
    // InternalCmdArgsParser.g:1160:1: entryRulePathLegalPartCommon returns [String current=null] : iv_rulePathLegalPartCommon= rulePathLegalPartCommon EOF ;
    public final String entryRulePathLegalPartCommon() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePathLegalPartCommon = null;


        try {
            // InternalCmdArgsParser.g:1161:1: (iv_rulePathLegalPartCommon= rulePathLegalPartCommon EOF )
            // InternalCmdArgsParser.g:1162:2: iv_rulePathLegalPartCommon= rulePathLegalPartCommon EOF
            {
             newCompositeNode(grammarAccess.getPathLegalPartCommonRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathLegalPartCommon=rulePathLegalPartCommon();

            state._fsp--;

             current =iv_rulePathLegalPartCommon.getText(); 
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
    // $ANTLR end "entryRulePathLegalPartCommon"


    // $ANTLR start "rulePathLegalPartCommon"
    // InternalCmdArgsParser.g:1169:1: rulePathLegalPartCommon returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Identifier_0= ruleIdentifier | this_KW_NOSTDINC_1= RULE_KW_NOSTDINC | this_KW_INCSYS_2= RULE_KW_INCSYS | this_KW_INCLUDE_3= RULE_KW_INCLUDE | this_ANY_OTHER_4= RULE_ANY_OTHER ) ;
    public final AntlrDatatypeRuleToken rulePathLegalPartCommon() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_KW_NOSTDINC_1=null;
        Token this_KW_INCSYS_2=null;
        Token this_KW_INCLUDE_3=null;
        Token this_ANY_OTHER_4=null;
        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1173:6: ( (this_Identifier_0= ruleIdentifier | this_KW_NOSTDINC_1= RULE_KW_NOSTDINC | this_KW_INCSYS_2= RULE_KW_INCSYS | this_KW_INCLUDE_3= RULE_KW_INCLUDE | this_ANY_OTHER_4= RULE_ANY_OTHER ) )
            // InternalCmdArgsParser.g:1174:1: (this_Identifier_0= ruleIdentifier | this_KW_NOSTDINC_1= RULE_KW_NOSTDINC | this_KW_INCSYS_2= RULE_KW_INCSYS | this_KW_INCLUDE_3= RULE_KW_INCLUDE | this_ANY_OTHER_4= RULE_ANY_OTHER )
            {
            // InternalCmdArgsParser.g:1174:1: (this_Identifier_0= ruleIdentifier | this_KW_NOSTDINC_1= RULE_KW_NOSTDINC | this_KW_INCSYS_2= RULE_KW_INCSYS | this_KW_INCLUDE_3= RULE_KW_INCLUDE | this_ANY_OTHER_4= RULE_ANY_OTHER )
            int alt28=5;
            switch ( input.LA(1) ) {
            case RULE_KW_VAR:
            case RULE_ID:
                {
                alt28=1;
                }
                break;
            case RULE_KW_NOSTDINC:
                {
                alt28=2;
                }
                break;
            case RULE_KW_INCSYS:
                {
                alt28=3;
                }
                break;
            case RULE_KW_INCLUDE:
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
                    // InternalCmdArgsParser.g:1175:5: this_Identifier_0= ruleIdentifier
                    {
                     
                            newCompositeNode(grammarAccess.getPathLegalPartCommonAccess().getIdentifierParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Identifier_0=ruleIdentifier();

                    state._fsp--;


                    		current.merge(this_Identifier_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:1186:10: this_KW_NOSTDINC_1= RULE_KW_NOSTDINC
                    {
                    this_KW_NOSTDINC_1=(Token)match(input,RULE_KW_NOSTDINC,FOLLOW_2); 

                    		current.merge(this_KW_NOSTDINC_1);
                        
                     
                        newLeafNode(this_KW_NOSTDINC_1, grammarAccess.getPathLegalPartCommonAccess().getKW_NOSTDINCTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalCmdArgsParser.g:1194:10: this_KW_INCSYS_2= RULE_KW_INCSYS
                    {
                    this_KW_INCSYS_2=(Token)match(input,RULE_KW_INCSYS,FOLLOW_2); 

                    		current.merge(this_KW_INCSYS_2);
                        
                     
                        newLeafNode(this_KW_INCSYS_2, grammarAccess.getPathLegalPartCommonAccess().getKW_INCSYSTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalCmdArgsParser.g:1202:10: this_KW_INCLUDE_3= RULE_KW_INCLUDE
                    {
                    this_KW_INCLUDE_3=(Token)match(input,RULE_KW_INCLUDE,FOLLOW_2); 

                    		current.merge(this_KW_INCLUDE_3);
                        
                     
                        newLeafNode(this_KW_INCLUDE_3, grammarAccess.getPathLegalPartCommonAccess().getKW_INCLUDETerminalRuleCall_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalCmdArgsParser.g:1210:10: this_ANY_OTHER_4= RULE_ANY_OTHER
                    {
                    this_ANY_OTHER_4=(Token)match(input,RULE_ANY_OTHER,FOLLOW_2); 

                    		current.merge(this_ANY_OTHER_4);
                        
                     
                        newLeafNode(this_ANY_OTHER_4, grammarAccess.getPathLegalPartCommonAccess().getANY_OTHERTerminalRuleCall_4()); 
                        

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
    // $ANTLR end "rulePathLegalPartCommon"


    // $ANTLR start "entryRulePathLegalPart1"
    // InternalCmdArgsParser.g:1225:1: entryRulePathLegalPart1 returns [String current=null] : iv_rulePathLegalPart1= rulePathLegalPart1 EOF ;
    public final String entryRulePathLegalPart1() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePathLegalPart1 = null;


        try {
            // InternalCmdArgsParser.g:1226:1: (iv_rulePathLegalPart1= rulePathLegalPart1 EOF )
            // InternalCmdArgsParser.g:1227:2: iv_rulePathLegalPart1= rulePathLegalPart1 EOF
            {
             newCompositeNode(grammarAccess.getPathLegalPart1Rule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathLegalPart1=rulePathLegalPart1();

            state._fsp--;

             current =iv_rulePathLegalPart1.getText(); 
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
    // $ANTLR end "entryRulePathLegalPart1"


    // $ANTLR start "rulePathLegalPart1"
    // InternalCmdArgsParser.g:1234:1: rulePathLegalPart1 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_PathLegalPartCommon_0= rulePathLegalPartCommon )+ ;
    public final AntlrDatatypeRuleToken rulePathLegalPart1() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_PathLegalPartCommon_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1238:6: ( (this_PathLegalPartCommon_0= rulePathLegalPartCommon )+ )
            // InternalCmdArgsParser.g:1239:1: (this_PathLegalPartCommon_0= rulePathLegalPartCommon )+
            {
            // InternalCmdArgsParser.g:1239:1: (this_PathLegalPartCommon_0= rulePathLegalPartCommon )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                alt29 = dfa29.predict(input);
                switch (alt29) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1240:5: this_PathLegalPartCommon_0= rulePathLegalPartCommon
            	    {
            	     
            	            newCompositeNode(grammarAccess.getPathLegalPart1Access().getPathLegalPartCommonParserRuleCall()); 
            	        
            	    pushFollow(FOLLOW_27);
            	    this_PathLegalPartCommon_0=rulePathLegalPartCommon();

            	    state._fsp--;


            	    		current.merge(this_PathLegalPartCommon_0);
            	        
            	     
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
    // $ANTLR end "rulePathLegalPart1"


    // $ANTLR start "entryRulePathLegalPart2"
    // InternalCmdArgsParser.g:1258:1: entryRulePathLegalPart2 returns [String current=null] : iv_rulePathLegalPart2= rulePathLegalPart2 EOF ;
    public final String entryRulePathLegalPart2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePathLegalPart2 = null;


        try {
            // InternalCmdArgsParser.g:1259:1: (iv_rulePathLegalPart2= rulePathLegalPart2 EOF )
            // InternalCmdArgsParser.g:1260:2: iv_rulePathLegalPart2= rulePathLegalPart2 EOF
            {
             newCompositeNode(grammarAccess.getPathLegalPart2Rule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathLegalPart2=rulePathLegalPart2();

            state._fsp--;

             current =iv_rulePathLegalPart2.getText(); 
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
    // $ANTLR end "entryRulePathLegalPart2"


    // $ANTLR start "rulePathLegalPart2"
    // InternalCmdArgsParser.g:1267:1: rulePathLegalPart2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_PathLegalPartCommon_0= rulePathLegalPartCommon | this_WS_1= RULE_WS )+ ;
    public final AntlrDatatypeRuleToken rulePathLegalPart2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_1=null;
        AntlrDatatypeRuleToken this_PathLegalPartCommon_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1271:6: ( (this_PathLegalPartCommon_0= rulePathLegalPartCommon | this_WS_1= RULE_WS )+ )
            // InternalCmdArgsParser.g:1272:1: (this_PathLegalPartCommon_0= rulePathLegalPartCommon | this_WS_1= RULE_WS )+
            {
            // InternalCmdArgsParser.g:1272:1: (this_PathLegalPartCommon_0= rulePathLegalPartCommon | this_WS_1= RULE_WS )+
            int cnt30=0;
            loop30:
            do {
                int alt30=3;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=RULE_KW_NOSTDINC && LA30_0<=RULE_KW_VAR)||LA30_0==RULE_ID||LA30_0==RULE_ANY_OTHER) ) {
                    alt30=1;
                }
                else if ( (LA30_0==RULE_WS) ) {
                    alt30=2;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1273:5: this_PathLegalPartCommon_0= rulePathLegalPartCommon
            	    {
            	     
            	            newCompositeNode(grammarAccess.getPathLegalPart2Access().getPathLegalPartCommonParserRuleCall_0()); 
            	        
            	    pushFollow(FOLLOW_28);
            	    this_PathLegalPartCommon_0=rulePathLegalPartCommon();

            	    state._fsp--;


            	    		current.merge(this_PathLegalPartCommon_0);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;
            	case 2 :
            	    // InternalCmdArgsParser.g:1284:10: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_28); 

            	    		current.merge(this_WS_1);
            	        
            	     
            	        newLeafNode(this_WS_1, grammarAccess.getPathLegalPart2Access().getWSTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
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
    // $ANTLR end "rulePathLegalPart2"


    // $ANTLR start "entryRuleMacroLegalPart"
    // InternalCmdArgsParser.g:1299:1: entryRuleMacroLegalPart returns [String current=null] : iv_ruleMacroLegalPart= ruleMacroLegalPart EOF ;
    public final String entryRuleMacroLegalPart() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMacroLegalPart = null;


        try {
            // InternalCmdArgsParser.g:1300:1: (iv_ruleMacroLegalPart= ruleMacroLegalPart EOF )
            // InternalCmdArgsParser.g:1301:2: iv_ruleMacroLegalPart= ruleMacroLegalPart EOF
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
    // InternalCmdArgsParser.g:1308:1: ruleMacroLegalPart returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Identifier_0= ruleIdentifier | this_KW_NOSTDINC_1= RULE_KW_NOSTDINC | this_KW_INCSYS_2= RULE_KW_INCSYS | this_KW_INCLUDE_3= RULE_KW_INCLUDE | this_ANY_OTHER_4= RULE_ANY_OTHER ) ;
    public final AntlrDatatypeRuleToken ruleMacroLegalPart() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_KW_NOSTDINC_1=null;
        Token this_KW_INCSYS_2=null;
        Token this_KW_INCLUDE_3=null;
        Token this_ANY_OTHER_4=null;
        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1312:6: ( (this_Identifier_0= ruleIdentifier | this_KW_NOSTDINC_1= RULE_KW_NOSTDINC | this_KW_INCSYS_2= RULE_KW_INCSYS | this_KW_INCLUDE_3= RULE_KW_INCLUDE | this_ANY_OTHER_4= RULE_ANY_OTHER ) )
            // InternalCmdArgsParser.g:1313:1: (this_Identifier_0= ruleIdentifier | this_KW_NOSTDINC_1= RULE_KW_NOSTDINC | this_KW_INCSYS_2= RULE_KW_INCSYS | this_KW_INCLUDE_3= RULE_KW_INCLUDE | this_ANY_OTHER_4= RULE_ANY_OTHER )
            {
            // InternalCmdArgsParser.g:1313:1: (this_Identifier_0= ruleIdentifier | this_KW_NOSTDINC_1= RULE_KW_NOSTDINC | this_KW_INCSYS_2= RULE_KW_INCSYS | this_KW_INCLUDE_3= RULE_KW_INCLUDE | this_ANY_OTHER_4= RULE_ANY_OTHER )
            int alt31=5;
            switch ( input.LA(1) ) {
            case RULE_KW_VAR:
            case RULE_ID:
                {
                alt31=1;
                }
                break;
            case RULE_KW_NOSTDINC:
                {
                alt31=2;
                }
                break;
            case RULE_KW_INCSYS:
                {
                alt31=3;
                }
                break;
            case RULE_KW_INCLUDE:
                {
                alt31=4;
                }
                break;
            case RULE_ANY_OTHER:
                {
                alt31=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalCmdArgsParser.g:1314:5: this_Identifier_0= ruleIdentifier
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
                    // InternalCmdArgsParser.g:1325:10: this_KW_NOSTDINC_1= RULE_KW_NOSTDINC
                    {
                    this_KW_NOSTDINC_1=(Token)match(input,RULE_KW_NOSTDINC,FOLLOW_2); 

                    		current.merge(this_KW_NOSTDINC_1);
                        
                     
                        newLeafNode(this_KW_NOSTDINC_1, grammarAccess.getMacroLegalPartAccess().getKW_NOSTDINCTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalCmdArgsParser.g:1333:10: this_KW_INCSYS_2= RULE_KW_INCSYS
                    {
                    this_KW_INCSYS_2=(Token)match(input,RULE_KW_INCSYS,FOLLOW_2); 

                    		current.merge(this_KW_INCSYS_2);
                        
                     
                        newLeafNode(this_KW_INCSYS_2, grammarAccess.getMacroLegalPartAccess().getKW_INCSYSTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalCmdArgsParser.g:1341:10: this_KW_INCLUDE_3= RULE_KW_INCLUDE
                    {
                    this_KW_INCLUDE_3=(Token)match(input,RULE_KW_INCLUDE,FOLLOW_2); 

                    		current.merge(this_KW_INCLUDE_3);
                        
                     
                        newLeafNode(this_KW_INCLUDE_3, grammarAccess.getMacroLegalPartAccess().getKW_INCLUDETerminalRuleCall_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalCmdArgsParser.g:1349:10: this_ANY_OTHER_4= RULE_ANY_OTHER
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
    // InternalCmdArgsParser.g:1364:1: entryRuleMyCode returns [String current=null] : iv_ruleMyCode= ruleMyCode EOF ;
    public final String entryRuleMyCode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyCode = null;


        try {
            // InternalCmdArgsParser.g:1365:1: (iv_ruleMyCode= ruleMyCode EOF )
            // InternalCmdArgsParser.g:1366:2: iv_ruleMyCode= ruleMyCode EOF
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
    // InternalCmdArgsParser.g:1373:1: ruleMyCode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Identifier_0= ruleIdentifier | this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN | this_KW_NOSTDINC_3= RULE_KW_NOSTDINC | this_KW_INCSYS_4= RULE_KW_INCSYS | this_KW_INCLUDE_5= RULE_KW_INCLUDE | this_ANY_OTHER_6= RULE_ANY_OTHER | this_SKW_HASH2_7= RULE_SKW_HASH2 | this_SKW_COMMA_8= RULE_SKW_COMMA )+ ;
    public final AntlrDatatypeRuleToken ruleMyCode() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_LEFTPAREN_1=null;
        Token this_SKW_RIGHTPAREN_2=null;
        Token this_KW_NOSTDINC_3=null;
        Token this_KW_INCSYS_4=null;
        Token this_KW_INCLUDE_5=null;
        Token this_ANY_OTHER_6=null;
        Token this_SKW_HASH2_7=null;
        Token this_SKW_COMMA_8=null;
        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1377:6: ( (this_Identifier_0= ruleIdentifier | this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN | this_KW_NOSTDINC_3= RULE_KW_NOSTDINC | this_KW_INCSYS_4= RULE_KW_INCSYS | this_KW_INCLUDE_5= RULE_KW_INCLUDE | this_ANY_OTHER_6= RULE_ANY_OTHER | this_SKW_HASH2_7= RULE_SKW_HASH2 | this_SKW_COMMA_8= RULE_SKW_COMMA )+ )
            // InternalCmdArgsParser.g:1378:1: (this_Identifier_0= ruleIdentifier | this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN | this_KW_NOSTDINC_3= RULE_KW_NOSTDINC | this_KW_INCSYS_4= RULE_KW_INCSYS | this_KW_INCLUDE_5= RULE_KW_INCLUDE | this_ANY_OTHER_6= RULE_ANY_OTHER | this_SKW_HASH2_7= RULE_SKW_HASH2 | this_SKW_COMMA_8= RULE_SKW_COMMA )+
            {
            // InternalCmdArgsParser.g:1378:1: (this_Identifier_0= ruleIdentifier | this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN | this_KW_NOSTDINC_3= RULE_KW_NOSTDINC | this_KW_INCSYS_4= RULE_KW_INCSYS | this_KW_INCLUDE_5= RULE_KW_INCLUDE | this_ANY_OTHER_6= RULE_ANY_OTHER | this_SKW_HASH2_7= RULE_SKW_HASH2 | this_SKW_COMMA_8= RULE_SKW_COMMA )+
            int cnt32=0;
            loop32:
            do {
                int alt32=10;
                alt32 = dfa32.predict(input);
                switch (alt32) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1379:5: this_Identifier_0= ruleIdentifier
            	    {
            	     
            	            newCompositeNode(grammarAccess.getMyCodeAccess().getIdentifierParserRuleCall_0()); 
            	        
            	    pushFollow(FOLLOW_29);
            	    this_Identifier_0=ruleIdentifier();

            	    state._fsp--;


            	    		current.merge(this_Identifier_0);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;
            	case 2 :
            	    // InternalCmdArgsParser.g:1390:10: this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN
            	    {
            	    this_SKW_LEFTPAREN_1=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_29); 

            	    		current.merge(this_SKW_LEFTPAREN_1);
            	        
            	     
            	        newLeafNode(this_SKW_LEFTPAREN_1, grammarAccess.getMyCodeAccess().getSKW_LEFTPARENTerminalRuleCall_1()); 
            	        

            	    }
            	    break;
            	case 3 :
            	    // InternalCmdArgsParser.g:1398:10: this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN
            	    {
            	    this_SKW_RIGHTPAREN_2=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_29); 

            	    		current.merge(this_SKW_RIGHTPAREN_2);
            	        
            	     
            	        newLeafNode(this_SKW_RIGHTPAREN_2, grammarAccess.getMyCodeAccess().getSKW_RIGHTPARENTerminalRuleCall_2()); 
            	        

            	    }
            	    break;
            	case 4 :
            	    // InternalCmdArgsParser.g:1406:10: this_KW_NOSTDINC_3= RULE_KW_NOSTDINC
            	    {
            	    this_KW_NOSTDINC_3=(Token)match(input,RULE_KW_NOSTDINC,FOLLOW_29); 

            	    		current.merge(this_KW_NOSTDINC_3);
            	        
            	     
            	        newLeafNode(this_KW_NOSTDINC_3, grammarAccess.getMyCodeAccess().getKW_NOSTDINCTerminalRuleCall_3()); 
            	        

            	    }
            	    break;
            	case 5 :
            	    // InternalCmdArgsParser.g:1414:10: this_KW_INCSYS_4= RULE_KW_INCSYS
            	    {
            	    this_KW_INCSYS_4=(Token)match(input,RULE_KW_INCSYS,FOLLOW_29); 

            	    		current.merge(this_KW_INCSYS_4);
            	        
            	     
            	        newLeafNode(this_KW_INCSYS_4, grammarAccess.getMyCodeAccess().getKW_INCSYSTerminalRuleCall_4()); 
            	        

            	    }
            	    break;
            	case 6 :
            	    // InternalCmdArgsParser.g:1422:10: this_KW_INCLUDE_5= RULE_KW_INCLUDE
            	    {
            	    this_KW_INCLUDE_5=(Token)match(input,RULE_KW_INCLUDE,FOLLOW_29); 

            	    		current.merge(this_KW_INCLUDE_5);
            	        
            	     
            	        newLeafNode(this_KW_INCLUDE_5, grammarAccess.getMyCodeAccess().getKW_INCLUDETerminalRuleCall_5()); 
            	        

            	    }
            	    break;
            	case 7 :
            	    // InternalCmdArgsParser.g:1430:10: this_ANY_OTHER_6= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_6=(Token)match(input,RULE_ANY_OTHER,FOLLOW_29); 

            	    		current.merge(this_ANY_OTHER_6);
            	        
            	     
            	        newLeafNode(this_ANY_OTHER_6, grammarAccess.getMyCodeAccess().getANY_OTHERTerminalRuleCall_6()); 
            	        

            	    }
            	    break;
            	case 8 :
            	    // InternalCmdArgsParser.g:1438:10: this_SKW_HASH2_7= RULE_SKW_HASH2
            	    {
            	    this_SKW_HASH2_7=(Token)match(input,RULE_SKW_HASH2,FOLLOW_29); 

            	    		current.merge(this_SKW_HASH2_7);
            	        
            	     
            	        newLeafNode(this_SKW_HASH2_7, grammarAccess.getMyCodeAccess().getSKW_HASH2TerminalRuleCall_7()); 
            	        

            	    }
            	    break;
            	case 9 :
            	    // InternalCmdArgsParser.g:1446:10: this_SKW_COMMA_8= RULE_SKW_COMMA
            	    {
            	    this_SKW_COMMA_8=(Token)match(input,RULE_SKW_COMMA,FOLLOW_29); 

            	    		current.merge(this_SKW_COMMA_8);
            	        
            	     
            	        newLeafNode(this_SKW_COMMA_8, grammarAccess.getMyCodeAccess().getSKW_COMMATerminalRuleCall_8()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
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
    // InternalCmdArgsParser.g:1461:1: entryRuleOption returns [String current=null] : iv_ruleOption= ruleOption EOF ;
    public final String entryRuleOption() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOption = null;


        try {
            // InternalCmdArgsParser.g:1462:1: (iv_ruleOption= ruleOption EOF )
            // InternalCmdArgsParser.g:1463:2: iv_ruleOption= ruleOption EOF
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
    // InternalCmdArgsParser.g:1470:1: ruleOption returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_OptionPart_0= ruleOptionPart )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )* ) ;
    public final AntlrDatatypeRuleToken ruleOption() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SKW_COMMA_1=null;
        Token this_SKW_MINUS_2=null;
        AntlrDatatypeRuleToken this_OptionPart_0 = null;

        AntlrDatatypeRuleToken this_OptionPart_3 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1474:6: ( ( (this_OptionPart_0= ruleOptionPart )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )* ) )
            // InternalCmdArgsParser.g:1475:1: ( (this_OptionPart_0= ruleOptionPart )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )* )
            {
            // InternalCmdArgsParser.g:1475:1: ( (this_OptionPart_0= ruleOptionPart )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )* )
            // InternalCmdArgsParser.g:1475:2: (this_OptionPart_0= ruleOptionPart )+ (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )*
            {
            // InternalCmdArgsParser.g:1475:2: (this_OptionPart_0= ruleOptionPart )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                alt33 = dfa33.predict(input);
                switch (alt33) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1476:5: this_OptionPart_0= ruleOptionPart
            	    {
            	     
            	            newCompositeNode(grammarAccess.getOptionAccess().getOptionPartParserRuleCall_0()); 
            	        
            	    pushFollow(FOLLOW_30);
            	    this_OptionPart_0=ruleOptionPart();

            	    state._fsp--;


            	    		current.merge(this_OptionPart_0);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);

            // InternalCmdArgsParser.g:1486:3: (this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+ )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_SKW_COMMA) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1486:8: this_SKW_COMMA_1= RULE_SKW_COMMA (this_SKW_MINUS_2= RULE_SKW_MINUS )? (this_OptionPart_3= ruleOptionPart )+
            	    {
            	    this_SKW_COMMA_1=(Token)match(input,RULE_SKW_COMMA,FOLLOW_31); 

            	    		current.merge(this_SKW_COMMA_1);
            	        
            	     
            	        newLeafNode(this_SKW_COMMA_1, grammarAccess.getOptionAccess().getSKW_COMMATerminalRuleCall_1_0()); 
            	        
            	    // InternalCmdArgsParser.g:1493:1: (this_SKW_MINUS_2= RULE_SKW_MINUS )?
            	    int alt34=2;
            	    int LA34_0 = input.LA(1);

            	    if ( (LA34_0==RULE_SKW_MINUS) ) {
            	        alt34=1;
            	    }
            	    switch (alt34) {
            	        case 1 :
            	            // InternalCmdArgsParser.g:1493:6: this_SKW_MINUS_2= RULE_SKW_MINUS
            	            {
            	            this_SKW_MINUS_2=(Token)match(input,RULE_SKW_MINUS,FOLLOW_32); 

            	            		current.merge(this_SKW_MINUS_2);
            	                
            	             
            	                newLeafNode(this_SKW_MINUS_2, grammarAccess.getOptionAccess().getSKW_MINUSTerminalRuleCall_1_1()); 
            	                

            	            }
            	            break;

            	    }

            	    // InternalCmdArgsParser.g:1500:3: (this_OptionPart_3= ruleOptionPart )+
            	    int cnt35=0;
            	    loop35:
            	    do {
            	        int alt35=2;
            	        alt35 = dfa35.predict(input);
            	        switch (alt35) {
            	    	case 1 :
            	    	    // InternalCmdArgsParser.g:1501:5: this_OptionPart_3= ruleOptionPart
            	    	    {
            	    	     
            	    	            newCompositeNode(grammarAccess.getOptionAccess().getOptionPartParserRuleCall_1_2()); 
            	    	        
            	    	    pushFollow(FOLLOW_30);
            	    	    this_OptionPart_3=ruleOptionPart();

            	    	    state._fsp--;


            	    	    		current.merge(this_OptionPart_3);
            	    	        
            	    	     
            	    	            afterParserOrEnumRuleCall();
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt35 >= 1 ) break loop35;
            	                EarlyExitException eee =
            	                    new EarlyExitException(35, input);
            	                throw eee;
            	        }
            	        cnt35++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // InternalCmdArgsParser.g:1519:1: entryRuleOptionPart returns [String current=null] : iv_ruleOptionPart= ruleOptionPart EOF ;
    public final String entryRuleOptionPart() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOptionPart = null;


        try {
            // InternalCmdArgsParser.g:1520:1: (iv_ruleOptionPart= ruleOptionPart EOF )
            // InternalCmdArgsParser.g:1521:2: iv_ruleOptionPart= ruleOptionPart EOF
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
    // InternalCmdArgsParser.g:1528:1: ruleOptionPart returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_OptionLegalStart_0= ruleOptionLegalStart (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )* ) ;
    public final AntlrDatatypeRuleToken ruleOptionPart() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_OptionLegalStart_0 = null;

        AntlrDatatypeRuleToken this_OptionLegalContinuation_1 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1532:6: ( (this_OptionLegalStart_0= ruleOptionLegalStart (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )* ) )
            // InternalCmdArgsParser.g:1533:1: (this_OptionLegalStart_0= ruleOptionLegalStart (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )* )
            {
            // InternalCmdArgsParser.g:1533:1: (this_OptionLegalStart_0= ruleOptionLegalStart (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )* )
            // InternalCmdArgsParser.g:1534:5: this_OptionLegalStart_0= ruleOptionLegalStart (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )*
            {
             
                    newCompositeNode(grammarAccess.getOptionPartAccess().getOptionLegalStartParserRuleCall_0()); 
                
            pushFollow(FOLLOW_33);
            this_OptionLegalStart_0=ruleOptionLegalStart();

            state._fsp--;


            		current.merge(this_OptionLegalStart_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalCmdArgsParser.g:1544:1: (this_OptionLegalContinuation_1= ruleOptionLegalContinuation )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_SKW_ASSIGN||(LA37_0>=RULE_KW_NOSTDINC && LA37_0<=RULE_KW_INCLUDE)||LA37_0==RULE_ANY_OTHER) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalCmdArgsParser.g:1545:5: this_OptionLegalContinuation_1= ruleOptionLegalContinuation
            	    {
            	     
            	            newCompositeNode(grammarAccess.getOptionPartAccess().getOptionLegalContinuationParserRuleCall_1()); 
            	        
            	    pushFollow(FOLLOW_33);
            	    this_OptionLegalContinuation_1=ruleOptionLegalContinuation();

            	    state._fsp--;


            	    		current.merge(this_OptionLegalContinuation_1);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop37;
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
    // InternalCmdArgsParser.g:1563:1: entryRuleOptionLegalStart returns [String current=null] : iv_ruleOptionLegalStart= ruleOptionLegalStart EOF ;
    public final String entryRuleOptionLegalStart() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOptionLegalStart = null;


        try {
            // InternalCmdArgsParser.g:1564:1: (iv_ruleOptionLegalStart= ruleOptionLegalStart EOF )
            // InternalCmdArgsParser.g:1565:2: iv_ruleOptionLegalStart= ruleOptionLegalStart EOF
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
    // InternalCmdArgsParser.g:1572:1: ruleOptionLegalStart returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleOptionLegalStart() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1576:6: (this_Identifier_0= ruleIdentifier )
            // InternalCmdArgsParser.g:1578:5: this_Identifier_0= ruleIdentifier
            {
             
                    newCompositeNode(grammarAccess.getOptionLegalStartAccess().getIdentifierParserRuleCall()); 
                
            pushFollow(FOLLOW_2);
            this_Identifier_0=ruleIdentifier();

            state._fsp--;


            		current.merge(this_Identifier_0);
                
             
                    afterParserOrEnumRuleCall();
                

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
    // InternalCmdArgsParser.g:1596:1: entryRuleOptionLegalContinuation returns [String current=null] : iv_ruleOptionLegalContinuation= ruleOptionLegalContinuation EOF ;
    public final String entryRuleOptionLegalContinuation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOptionLegalContinuation = null;


        try {
            // InternalCmdArgsParser.g:1597:1: (iv_ruleOptionLegalContinuation= ruleOptionLegalContinuation EOF )
            // InternalCmdArgsParser.g:1598:2: iv_ruleOptionLegalContinuation= ruleOptionLegalContinuation EOF
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
    // InternalCmdArgsParser.g:1605:1: ruleOptionLegalContinuation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_KW_NOSTDINC_0= RULE_KW_NOSTDINC | this_KW_INCSYS_1= RULE_KW_INCSYS | this_KW_INCLUDE_2= RULE_KW_INCLUDE | this_SKW_ASSIGN_3= RULE_SKW_ASSIGN | this_ANY_OTHER_4= RULE_ANY_OTHER ) ;
    public final AntlrDatatypeRuleToken ruleOptionLegalContinuation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_KW_NOSTDINC_0=null;
        Token this_KW_INCSYS_1=null;
        Token this_KW_INCLUDE_2=null;
        Token this_SKW_ASSIGN_3=null;
        Token this_ANY_OTHER_4=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1609:6: ( (this_KW_NOSTDINC_0= RULE_KW_NOSTDINC | this_KW_INCSYS_1= RULE_KW_INCSYS | this_KW_INCLUDE_2= RULE_KW_INCLUDE | this_SKW_ASSIGN_3= RULE_SKW_ASSIGN | this_ANY_OTHER_4= RULE_ANY_OTHER ) )
            // InternalCmdArgsParser.g:1610:1: (this_KW_NOSTDINC_0= RULE_KW_NOSTDINC | this_KW_INCSYS_1= RULE_KW_INCSYS | this_KW_INCLUDE_2= RULE_KW_INCLUDE | this_SKW_ASSIGN_3= RULE_SKW_ASSIGN | this_ANY_OTHER_4= RULE_ANY_OTHER )
            {
            // InternalCmdArgsParser.g:1610:1: (this_KW_NOSTDINC_0= RULE_KW_NOSTDINC | this_KW_INCSYS_1= RULE_KW_INCSYS | this_KW_INCLUDE_2= RULE_KW_INCLUDE | this_SKW_ASSIGN_3= RULE_SKW_ASSIGN | this_ANY_OTHER_4= RULE_ANY_OTHER )
            int alt38=5;
            switch ( input.LA(1) ) {
            case RULE_KW_NOSTDINC:
                {
                alt38=1;
                }
                break;
            case RULE_KW_INCSYS:
                {
                alt38=2;
                }
                break;
            case RULE_KW_INCLUDE:
                {
                alt38=3;
                }
                break;
            case RULE_SKW_ASSIGN:
                {
                alt38=4;
                }
                break;
            case RULE_ANY_OTHER:
                {
                alt38=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalCmdArgsParser.g:1610:6: this_KW_NOSTDINC_0= RULE_KW_NOSTDINC
                    {
                    this_KW_NOSTDINC_0=(Token)match(input,RULE_KW_NOSTDINC,FOLLOW_2); 

                    		current.merge(this_KW_NOSTDINC_0);
                        
                     
                        newLeafNode(this_KW_NOSTDINC_0, grammarAccess.getOptionLegalContinuationAccess().getKW_NOSTDINCTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:1618:10: this_KW_INCSYS_1= RULE_KW_INCSYS
                    {
                    this_KW_INCSYS_1=(Token)match(input,RULE_KW_INCSYS,FOLLOW_2); 

                    		current.merge(this_KW_INCSYS_1);
                        
                     
                        newLeafNode(this_KW_INCSYS_1, grammarAccess.getOptionLegalContinuationAccess().getKW_INCSYSTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalCmdArgsParser.g:1626:10: this_KW_INCLUDE_2= RULE_KW_INCLUDE
                    {
                    this_KW_INCLUDE_2=(Token)match(input,RULE_KW_INCLUDE,FOLLOW_2); 

                    		current.merge(this_KW_INCLUDE_2);
                        
                     
                        newLeafNode(this_KW_INCLUDE_2, grammarAccess.getOptionLegalContinuationAccess().getKW_INCLUDETerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalCmdArgsParser.g:1634:10: this_SKW_ASSIGN_3= RULE_SKW_ASSIGN
                    {
                    this_SKW_ASSIGN_3=(Token)match(input,RULE_SKW_ASSIGN,FOLLOW_2); 

                    		current.merge(this_SKW_ASSIGN_3);
                        
                     
                        newLeafNode(this_SKW_ASSIGN_3, grammarAccess.getOptionLegalContinuationAccess().getSKW_ASSIGNTerminalRuleCall_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalCmdArgsParser.g:1642:10: this_ANY_OTHER_4= RULE_ANY_OTHER
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
    // InternalCmdArgsParser.g:1657:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalCmdArgsParser.g:1658:1: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalCmdArgsParser.g:1659:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalCmdArgsParser.g:1666:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID (this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID )* ) | this_KW_VAR_4= RULE_KW_VAR ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_SKW_COLON_1=null;
        Token this_SKW_BACKSLASH_2=null;
        Token this_ID_3=null;
        Token this_KW_VAR_4=null;

         enterRule(); 
            
        try {
            // InternalCmdArgsParser.g:1670:6: ( ( (this_ID_0= RULE_ID (this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID )* ) | this_KW_VAR_4= RULE_KW_VAR ) )
            // InternalCmdArgsParser.g:1671:1: ( (this_ID_0= RULE_ID (this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID )* ) | this_KW_VAR_4= RULE_KW_VAR )
            {
            // InternalCmdArgsParser.g:1671:1: ( (this_ID_0= RULE_ID (this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID )* ) | this_KW_VAR_4= RULE_KW_VAR )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_KW_VAR) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalCmdArgsParser.g:1671:2: (this_ID_0= RULE_ID (this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID )* )
                    {
                    // InternalCmdArgsParser.g:1671:2: (this_ID_0= RULE_ID (this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID )* )
                    // InternalCmdArgsParser.g:1671:7: this_ID_0= RULE_ID (this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID )*
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_34); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0_0()); 
                        
                    // InternalCmdArgsParser.g:1678:1: (this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==RULE_SKW_COLON) ) {
                            int LA39_1 = input.LA(2);

                            if ( (LA39_1==RULE_SKW_BACKSLASH) ) {
                                alt39=1;
                            }


                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalCmdArgsParser.g:1678:6: this_SKW_COLON_1= RULE_SKW_COLON this_SKW_BACKSLASH_2= RULE_SKW_BACKSLASH this_ID_3= RULE_ID
                    	    {
                    	    this_SKW_COLON_1=(Token)match(input,RULE_SKW_COLON,FOLLOW_35); 

                    	    		current.merge(this_SKW_COLON_1);
                    	        
                    	     
                    	        newLeafNode(this_SKW_COLON_1, grammarAccess.getIdentifierAccess().getSKW_COLONTerminalRuleCall_0_1_0()); 
                    	        
                    	    this_SKW_BACKSLASH_2=(Token)match(input,RULE_SKW_BACKSLASH,FOLLOW_36); 

                    	    		current.merge(this_SKW_BACKSLASH_2);
                    	        
                    	     
                    	        newLeafNode(this_SKW_BACKSLASH_2, grammarAccess.getIdentifierAccess().getSKW_BACKSLASHTerminalRuleCall_0_1_1()); 
                    	        
                    	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_34); 

                    	    		current.merge(this_ID_3);
                    	        
                    	     
                    	        newLeafNode(this_ID_3, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0_1_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalCmdArgsParser.g:1700:10: this_KW_VAR_4= RULE_KW_VAR
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
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA35 dfa35 = new DFA35(this);
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
    static final String DFA15_eotS =
        "\13\uffff";
    static final String DFA15_eofS =
        "\2\2\1\uffff\2\5\2\uffff\1\5\2\uffff\1\5";
    static final String DFA15_minS =
        "\1\25\1\7\1\uffff\2\6\1\uffff\1\15\1\6\1\30\2\6";
    static final String DFA15_maxS =
        "\2\36\1\uffff\2\36\1\uffff\2\36\1\30\2\36";
    static final String DFA15_acceptS =
        "\2\uffff\1\2\2\uffff\1\1\5\uffff";
    static final String DFA15_specialS =
        "\13\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\2\2\uffff\1\2\4\uffff\1\2\1\1",
            "\1\5\6\uffff\4\5\3\uffff\1\4\2\uffff\1\3\4\uffff\1\2\1\5",
            "",
            "\1\6\16\uffff\1\5\2\uffff\1\5\4\uffff\1\5\1\7",
            "\1\2\16\uffff\1\5\2\uffff\1\5\4\uffff\1\5\1\7",
            "",
            "\1\10\17\uffff\2\2",
            "\1\2\1\5\6\uffff\4\5\3\uffff\1\5\2\uffff\1\5\4\uffff\1\5\1\11",
            "\1\12",
            "\1\2\1\5\6\uffff\4\5\3\uffff\1\5\2\uffff\1\5\5\uffff\1\11",
            "\1\6\16\uffff\1\5\2\uffff\1\5\4\uffff\1\5\1\7"
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
            return "()* loopback of 365:2: ( (this_WS_6= RULE_WS )+ ( (lv_arguments_7_0= ruleArgument ) ) )*";
        }
    }
    static final String DFA23_eotS =
        "\13\uffff";
    static final String DFA23_eofS =
        "\3\uffff\1\10\7\uffff";
    static final String DFA23_minS =
        "\1\7\2\uffff\1\7\7\uffff";
    static final String DFA23_maxS =
        "\1\30\2\uffff\1\36\7\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\6\1\7\1\11\1\5\1\10\1\4\1\3";
    static final String DFA23_specialS =
        "\13\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\3\6\uffff\1\1\1\2\1\4\1\5\3\uffff\1\6\2\uffff\1\6",
            "",
            "",
            "\1\10\12\uffff\1\11\1\12\1\7\1\10\2\uffff\1\10\4\uffff\2\10",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
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
            return "418:2: ( (this_KW_DEFINE_1= RULE_KW_DEFINE ( (lv_macro_2_0= ruleMacro ) ) ) | ( ( (lv_incDir_3_0= RULE_KW_INCDIR ) ) ( (lv_useIncDir_4_0= rulePathCmd ) ) ) | ( ( (lv_incSys_5_0= ruleIncSys ) ) (this_WS_6= RULE_WS )+ ( (lv_useIncDir_7_0= rulePathCmd ) ) ) | ( (lv_nostdinc_8_0= ruleNoStdInc ) ) | (this_SKW_MINUS_9= RULE_SKW_MINUS this_KW_INCLUDE_10= RULE_KW_INCLUDE (this_WS_11= RULE_WS )+ ( (lv_include_12_0= rulePathCmd ) ) ) | (this_KW_OUTPUT_13= RULE_KW_OUTPUT (this_WS_14= RULE_WS )+ ( (lv_out_15_0= rulePathCmd ) ) ) | (this_KW_LANG_16= RULE_KW_LANG (this_WS_17= RULE_WS )+ ( (lv_lang_18_0= rulePathCmd ) ) ) | (this_SKW_MINUS_19= RULE_SKW_MINUS (this_SKW_MINUS_20= RULE_SKW_MINUS )? ( (lv_option_21_0= ruleOption ) )? ) | ( (lv_in_22_0= ruleIdentifier ) ) )";
        }
    }
    static final String DFA22_eotS =
        "\12\uffff";
    static final String DFA22_eofS =
        "\1\3\2\5\3\uffff\1\5\2\uffff\1\5";
    static final String DFA22_minS =
        "\1\25\2\6\1\uffff\1\15\1\uffff\1\6\1\30\2\6";
    static final String DFA22_maxS =
        "\1\36\2\43\1\uffff\1\36\1\uffff\1\36\1\30\1\36\1\43";
    static final String DFA22_acceptS =
        "\3\uffff\1\2\1\uffff\1\1\4\uffff";
    static final String DFA22_specialS =
        "\12\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\2\2\uffff\1\1\4\uffff\2\3",
            "\1\4\1\uffff\1\5\2\uffff\1\5\6\uffff\4\5\2\uffff\1\5\4\uffff\1\5\1\6\4\uffff\1\5",
            "\1\3\1\uffff\1\5\2\uffff\1\5\6\uffff\4\5\2\uffff\1\5\4\uffff\1\5\1\6\4\uffff\1\5",
            "",
            "\1\7\17\uffff\2\3",
            "",
            "\1\3\1\5\6\uffff\4\5\3\uffff\1\5\2\uffff\1\5\4\uffff\1\5\1\10",
            "\1\11",
            "\1\3\1\5\6\uffff\4\5\3\uffff\1\5\2\uffff\1\5\4\uffff\1\5\1\10",
            "\1\4\1\uffff\1\5\2\uffff\1\5\6\uffff\4\5\2\uffff\1\5\4\uffff\1\5\1\6\4\uffff\1\5"
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
            return "631:3: ( (lv_option_21_0= ruleOption ) )?";
        }
    }
    static final String DFA24_eotS =
        "\16\uffff";
    static final String DFA24_eofS =
        "\1\uffff\6\13\6\uffff\1\13";
    static final String DFA24_minS =
        "\1\22\1\6\5\10\1\uffff\1\15\3\uffff\1\30\1\6";
    static final String DFA24_maxS =
        "\1\43\6\36\1\uffff\1\15\3\uffff\1\30\1\36";
    static final String DFA24_acceptS =
        "\7\uffff\1\4\1\uffff\1\2\1\3\1\1\2\uffff";
    static final String DFA24_specialS =
        "\16\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\3\1\4\1\5\1\2\2\uffff\1\1\2\uffff\1\7\7\uffff\1\6",
            "\1\10\1\uffff\1\11\1\12\13\uffff\1\13\2\uffff\1\13\2\uffff\1\13\1\uffff\2\13",
            "\1\11\1\12\13\uffff\1\13\2\uffff\1\13\2\uffff\1\13\1\uffff\2\13",
            "\1\11\1\12\13\uffff\1\13\2\uffff\1\13\2\uffff\1\13\1\uffff\2\13",
            "\1\11\1\12\13\uffff\1\13\2\uffff\1\13\2\uffff\1\13\1\uffff\2\13",
            "\1\11\1\12\13\uffff\1\13\2\uffff\1\13\2\uffff\1\13\1\uffff\2\13",
            "\1\11\1\12\13\uffff\1\13\2\uffff\1\13\2\uffff\1\13\1\uffff\2\13",
            "",
            "\1\14",
            "",
            "",
            "",
            "\1\15",
            "\1\10\1\uffff\1\11\1\12\13\uffff\1\13\2\uffff\1\13\2\uffff\1\13\1\uffff\2\13"
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
            return "761:1: (this_SimpleMacro_0= ruleSimpleMacro | this_ObjectMacro_1= ruleObjectMacro | this_FunctionMacro_2= ruleFunctionMacro | this_StringMacro_3= ruleStringMacro )";
        }
    }
    static final String DFA29_eotS =
        "\12\uffff";
    static final String DFA29_eofS =
        "\1\1\1\uffff\2\4\2\uffff\1\4\2\uffff\1\4";
    static final String DFA29_minS =
        "\1\22\1\uffff\2\6\1\uffff\1\15\1\6\1\30\2\6";
    static final String DFA29_maxS =
        "\1\43\1\uffff\2\43\1\uffff\2\36\1\30\1\36\1\43";
    static final String DFA29_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\5\uffff";
    static final String DFA29_specialS =
        "\12\uffff}>";
    static final String[] DFA29_transitionS = {
            "\3\4\1\3\2\uffff\1\2\4\uffff\2\1\4\uffff\1\4",
            "",
            "\1\5\13\uffff\4\4\2\uffff\1\4\4\uffff\1\4\1\6\4\uffff\1\4",
            "\1\1\13\uffff\4\4\2\uffff\1\4\4\uffff\1\4\1\6\4\uffff\1\4",
            "",
            "\1\7\17\uffff\2\1",
            "\1\1\1\4\6\uffff\4\4\3\uffff\1\4\2\uffff\1\4\4\uffff\1\4\1\10",
            "\1\11",
            "\1\1\1\4\6\uffff\4\4\3\uffff\1\4\2\uffff\1\4\4\uffff\1\4\1\10",
            "\1\5\13\uffff\4\4\2\uffff\1\4\4\uffff\1\4\1\6\4\uffff\1\4"
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
            return "()+ loopback of 1239:1: (this_PathLegalPartCommon_0= rulePathLegalPartCommon )+";
        }
    }
    static final String DFA32_eotS =
        "\22\uffff";
    static final String DFA32_eofS =
        "\1\1\1\uffff\2\16\11\uffff\1\16\3\uffff\1\16";
    static final String DFA32_minS =
        "\1\11\1\uffff\2\6\10\uffff\1\15\1\6\1\uffff\1\30\2\6";
    static final String DFA32_maxS =
        "\1\43\1\uffff\2\43\10\uffff\2\36\1\uffff\1\30\1\36\1\43";
    static final String DFA32_acceptS =
        "\1\uffff\1\12\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\2\uffff\1\1\3\uffff";
    static final String DFA32_specialS =
        "\22\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\4\1\5\1\13\6\uffff\1\6\1\7\1\10\1\3\2\uffff\1\2\2\uffff\1\1\1\uffff\2\1\1\uffff\1\12\2\uffff\1\11",
            "",
            "\1\14\2\uffff\3\16\6\uffff\4\16\2\uffff\1\16\2\uffff\1\16\1\uffff\1\16\1\15\1\uffff\1\16\2\uffff\1\16",
            "\1\1\2\uffff\3\16\6\uffff\4\16\2\uffff\1\16\2\uffff\1\16\1\uffff\1\16\1\15\1\uffff\1\16\2\uffff\1\16",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\17\17\uffff\2\1",
            "\1\1\1\16\6\uffff\4\16\3\uffff\1\16\2\uffff\1\16\4\uffff\1\16\1\20",
            "",
            "\1\21",
            "\1\1\1\16\6\uffff\4\16\3\uffff\1\16\2\uffff\1\16\4\uffff\1\16\1\20",
            "\1\14\2\uffff\3\16\6\uffff\4\16\2\uffff\1\16\2\uffff\1\16\1\uffff\1\16\1\15\1\uffff\1\16\2\uffff\1\16"
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1378:1: (this_Identifier_0= ruleIdentifier | this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN | this_SKW_RIGHTPAREN_2= RULE_SKW_RIGHTPAREN | this_KW_NOSTDINC_3= RULE_KW_NOSTDINC | this_KW_INCSYS_4= RULE_KW_INCSYS | this_KW_INCLUDE_5= RULE_KW_INCLUDE | this_ANY_OTHER_6= RULE_ANY_OTHER | this_SKW_HASH2_7= RULE_SKW_HASH2 | this_SKW_COMMA_8= RULE_SKW_COMMA )+";
        }
    }
    static final String DFA33_eotS =
        "\12\uffff";
    static final String DFA33_eofS =
        "\1\1\1\uffff\2\6\1\uffff\1\6\3\uffff\1\6";
    static final String DFA33_minS =
        "\1\13\1\uffff\2\6\1\15\1\6\1\uffff\1\30\2\6";
    static final String DFA33_maxS =
        "\1\36\1\uffff\2\43\2\36\1\uffff\1\30\1\36\1\43";
    static final String DFA33_acceptS =
        "\1\uffff\1\2\4\uffff\1\1\3\uffff";
    static final String DFA33_specialS =
        "\12\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\1\11\uffff\1\3\2\uffff\1\2\4\uffff\2\1",
            "",
            "\1\4\1\uffff\1\6\2\uffff\1\6\6\uffff\4\6\2\uffff\1\6\4\uffff\1\6\1\5\4\uffff\1\6",
            "\1\1\1\uffff\1\6\2\uffff\1\6\6\uffff\4\6\2\uffff\1\6\4\uffff\1\6\1\5\4\uffff\1\6",
            "\1\7\17\uffff\2\1",
            "\1\1\1\6\6\uffff\4\6\3\uffff\1\6\2\uffff\1\6\4\uffff\1\6\1\10",
            "",
            "\1\11",
            "\1\1\1\6\6\uffff\4\6\3\uffff\1\6\2\uffff\1\6\4\uffff\1\6\1\10",
            "\1\4\1\uffff\1\6\2\uffff\1\6\6\uffff\4\6\2\uffff\1\6\4\uffff\1\6\1\5\4\uffff\1\6"
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1475:2: (this_OptionPart_0= ruleOptionPart )+";
        }
    }
    static final String DFA35_eotS =
        "\12\uffff";
    static final String DFA35_eofS =
        "\1\1\1\uffff\2\5\2\uffff\1\5\2\uffff\1\5";
    static final String DFA35_minS =
        "\1\13\1\uffff\2\6\1\15\1\uffff\1\6\1\30\2\6";
    static final String DFA35_maxS =
        "\1\36\1\uffff\2\43\1\36\1\uffff\1\36\1\30\1\36\1\43";
    static final String DFA35_acceptS =
        "\1\uffff\1\2\3\uffff\1\1\4\uffff";
    static final String DFA35_specialS =
        "\12\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\1\11\uffff\1\3\2\uffff\1\2\4\uffff\2\1",
            "",
            "\1\4\1\uffff\1\5\2\uffff\1\5\6\uffff\4\5\2\uffff\1\5\4\uffff\1\5\1\6\4\uffff\1\5",
            "\1\1\1\uffff\1\5\2\uffff\1\5\6\uffff\4\5\2\uffff\1\5\4\uffff\1\5\1\6\4\uffff\1\5",
            "\1\7\17\uffff\2\1",
            "",
            "\1\1\1\5\6\uffff\4\5\3\uffff\1\5\2\uffff\1\5\4\uffff\1\5\1\10",
            "\1\11",
            "\1\1\1\5\6\uffff\4\5\3\uffff\1\5\2\uffff\1\5\4\uffff\1\5\1\10",
            "\1\4\1\uffff\1\5\2\uffff\1\5\6\uffff\4\5\2\uffff\1\5\4\uffff\1\5\1\6\4\uffff\1\5"
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
            return "()+ loopback of 1500:3: (this_OptionPart_3= ruleOptionPart )+";
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
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000008093C0000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000008493C0000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001200082L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001200002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000009013C0E00L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000008013C0400L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00000008013C0000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000008413C0000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00000008013C0002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x00000008413C0002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000009013C0E02L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000001200802L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000001200080L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00000008001C0102L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000001000000L});

}