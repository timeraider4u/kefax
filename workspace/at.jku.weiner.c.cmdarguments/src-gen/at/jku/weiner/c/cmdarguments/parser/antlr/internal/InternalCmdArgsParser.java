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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'-D'", "'-I'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

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
    // InternalCmdArgs.g:77:1: ruleModel returns [EObject current=null] : ( () ( (lv_arguments_1_0= ruleArgument ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_1_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:83:7: ( ( () ( (lv_arguments_1_0= ruleArgument ) )* ) )
            // InternalCmdArgs.g:85:1: ( () ( (lv_arguments_1_0= ruleArgument ) )* )
            {
            // InternalCmdArgs.g:85:1: ( () ( (lv_arguments_1_0= ruleArgument ) )* )
            // InternalCmdArgs.g:86:1: () ( (lv_arguments_1_0= ruleArgument ) )*
            {
            // InternalCmdArgs.g:86:1: ()
            // InternalCmdArgs.g:87:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

            // InternalCmdArgs.g:95:1: ( (lv_arguments_1_0= ruleArgument ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCmdArgs.g:96:1: (lv_arguments_1_0= ruleArgument )
            	    {
            	    // InternalCmdArgs.g:96:1: (lv_arguments_1_0= ruleArgument )
            	    // InternalCmdArgs.g:97:3: lv_arguments_1_0= ruleArgument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getArgumentsArgumentParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_arguments_1_0=ruleArgument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
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
            	    break loop1;
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


    // $ANTLR start "entryRuleArgument"
    // InternalCmdArgs.g:125:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // InternalCmdArgs.g:126:2: (iv_ruleArgument= ruleArgument EOF )
            // InternalCmdArgs.g:127:2: iv_ruleArgument= ruleArgument EOF
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
    // InternalCmdArgs.g:134:1: ruleArgument returns [EObject current=null] : ( () ( (otherlv_1= '-D' ( (lv_name_2_0= ruleIdentifier ) ) ) | (otherlv_3= '-I' ( (lv_dir_4_0= ruleIdentifier ) ) ) ) ) ;
    public final EObject ruleArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_dir_4_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalCmdArgs.g:140:7: ( ( () ( (otherlv_1= '-D' ( (lv_name_2_0= ruleIdentifier ) ) ) | (otherlv_3= '-I' ( (lv_dir_4_0= ruleIdentifier ) ) ) ) ) )
            // InternalCmdArgs.g:142:1: ( () ( (otherlv_1= '-D' ( (lv_name_2_0= ruleIdentifier ) ) ) | (otherlv_3= '-I' ( (lv_dir_4_0= ruleIdentifier ) ) ) ) )
            {
            // InternalCmdArgs.g:142:1: ( () ( (otherlv_1= '-D' ( (lv_name_2_0= ruleIdentifier ) ) ) | (otherlv_3= '-I' ( (lv_dir_4_0= ruleIdentifier ) ) ) ) )
            // InternalCmdArgs.g:143:1: () ( (otherlv_1= '-D' ( (lv_name_2_0= ruleIdentifier ) ) ) | (otherlv_3= '-I' ( (lv_dir_4_0= ruleIdentifier ) ) ) )
            {
            // InternalCmdArgs.g:143:1: ()
            // InternalCmdArgs.g:144:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArgumentAccess().getArgumentAction_0(),
                        current);
                

            }

            // InternalCmdArgs.g:152:1: ( (otherlv_1= '-D' ( (lv_name_2_0= ruleIdentifier ) ) ) | (otherlv_3= '-I' ( (lv_dir_4_0= ruleIdentifier ) ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalCmdArgs.g:153:1: (otherlv_1= '-D' ( (lv_name_2_0= ruleIdentifier ) ) )
                    {
                    // InternalCmdArgs.g:153:1: (otherlv_1= '-D' ( (lv_name_2_0= ruleIdentifier ) ) )
                    // InternalCmdArgs.g:154:2: otherlv_1= '-D' ( (lv_name_2_0= ruleIdentifier ) )
                    {
                    otherlv_1=(Token)match(input,11,FOLLOW_4); 

                        	newLeafNode(otherlv_1, grammarAccess.getArgumentAccess().getDKeyword_1_0_0());
                        
                    // InternalCmdArgs.g:161:1: ( (lv_name_2_0= ruleIdentifier ) )
                    // InternalCmdArgs.g:162:1: (lv_name_2_0= ruleIdentifier )
                    {
                    // InternalCmdArgs.g:162:1: (lv_name_2_0= ruleIdentifier )
                    // InternalCmdArgs.g:163:3: lv_name_2_0= ruleIdentifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getNameIdentifierParserRuleCall_1_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_name_2_0=ruleIdentifier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_2_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCmdArgs.g:185:1: (otherlv_3= '-I' ( (lv_dir_4_0= ruleIdentifier ) ) )
                    {
                    // InternalCmdArgs.g:185:1: (otherlv_3= '-I' ( (lv_dir_4_0= ruleIdentifier ) ) )
                    // InternalCmdArgs.g:186:2: otherlv_3= '-I' ( (lv_dir_4_0= ruleIdentifier ) )
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_4); 

                        	newLeafNode(otherlv_3, grammarAccess.getArgumentAccess().getIKeyword_1_1_0());
                        
                    // InternalCmdArgs.g:193:1: ( (lv_dir_4_0= ruleIdentifier ) )
                    // InternalCmdArgs.g:194:1: (lv_dir_4_0= ruleIdentifier )
                    {
                    // InternalCmdArgs.g:194:1: (lv_dir_4_0= ruleIdentifier )
                    // InternalCmdArgs.g:195:3: lv_dir_4_0= ruleIdentifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getArgumentAccess().getDirIdentifierParserRuleCall_1_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_dir_4_0=ruleIdentifier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArgumentRule());
                    	        }
                           		set(
                           			current, 
                           			"dir",
                            		lv_dir_4_0, 
                            		"at.jku.weiner.c.cmdarguments.CmdArgs.Identifier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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


    // $ANTLR start "entryRuleIdentifier"
    // InternalCmdArgs.g:227:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalCmdArgs.g:228:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalCmdArgs.g:229:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalCmdArgs.g:236:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalCmdArgs.g:239:28: (this_ID_0= RULE_ID )
            // InternalCmdArgs.g:240:5: this_ID_0= RULE_ID
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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});

}