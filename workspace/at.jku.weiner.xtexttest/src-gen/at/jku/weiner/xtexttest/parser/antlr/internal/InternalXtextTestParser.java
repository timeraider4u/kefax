package at.jku.weiner.xtexttest.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import at.jku.weiner.xtexttest.services.XtextTestGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextTestParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_PACKAGE", "RULE_LANGUAGE", "RULE_IDENTIFIER", "RULE_POINT", "RULE_SOURCE", "RULE_SRCTEXT", "RULE_ASSIGNASSINGLE", "RULE_STRING", "RULE_FILE", "RULE_LEXER", "RULE_LEFTPAREN", "RULE_COMMA", "RULE_RIGHTPAREN", "RULE_ASSIGNASLIST", "RULE_ASSIGNASSTRING", "RULE_ASSIGNASDATALIST", "RULE_OUTPUT", "RULE_EXPECTED", "RULE_ISSAMEASINPUTFILE", "RULE_PATTERNS", "RULE_EXCEPTIONS", "RULE_BEFORE_KW", "RULE_CLASS_KW", "RULE_METHOD_KW", "RULE_AFTER_KW", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=29;
    public static final int RULE_SRCTEXT=9;
    public static final int RULE_RIGHTPAREN=16;
    public static final int RULE_METHOD_KW=27;
    public static final int RULE_PATTERNS=23;
    public static final int RULE_ASSIGNASDATALIST=19;
    public static final int RULE_ANY_OTHER=34;
    public static final int RULE_LANGUAGE=5;
    public static final int RULE_EXPECTED=21;
    public static final int RULE_FILE=12;
    public static final int RULE_IDENTIFIER=6;
    public static final int RULE_COMMA=15;
    public static final int RULE_AFTER_KW=28;
    public static final int RULE_SL_COMMENT=32;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=31;
    public static final int RULE_BEFORE_KW=25;
    public static final int RULE_PACKAGE=4;
    public static final int RULE_SOURCE=8;
    public static final int RULE_STRING=11;
    public static final int RULE_LEFTPAREN=14;
    public static final int RULE_ASSIGNASSINGLE=10;
    public static final int RULE_ASSIGNASLIST=17;
    public static final int RULE_EXCEPTIONS=24;
    public static final int RULE_POINT=7;
    public static final int RULE_LEXER=13;
    public static final int RULE_OUTPUT=20;
    public static final int RULE_INT=30;
    public static final int RULE_CLASS_KW=26;
    public static final int RULE_ASSIGNASSTRING=18;
    public static final int RULE_WS=33;
    public static final int RULE_ISSAMEASINPUTFILE=22;

    // delegates
    // delegators


        public InternalXtextTestParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXtextTestParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXtextTestParser.tokenNames; }
    public String getGrammarFileName() { return "InternalXtextTest.g"; }



     	private XtextTestGrammarAccess grammarAccess;
     	
        public InternalXtextTestParser(TokenStream input, XtextTestGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "XtextTest";	
       	}
       	
       	@Override
       	protected XtextTestGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleXtextTest"
    // InternalXtextTest.g:68:1: entryRuleXtextTest returns [EObject current=null] : iv_ruleXtextTest= ruleXtextTest EOF ;
    public final EObject entryRuleXtextTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXtextTest = null;


        try {
            // InternalXtextTest.g:69:2: (iv_ruleXtextTest= ruleXtextTest EOF )
            // InternalXtextTest.g:70:2: iv_ruleXtextTest= ruleXtextTest EOF
            {
             newCompositeNode(grammarAccess.getXtextTestRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXtextTest=ruleXtextTest();

            state._fsp--;

             current =iv_ruleXtextTest; 
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
    // $ANTLR end "entryRuleXtextTest"


    // $ANTLR start "ruleXtextTest"
    // InternalXtextTest.g:77:1: ruleXtextTest returns [EObject current=null] : ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) ( (lv_input_5_0= ruleInput ) ) ( (lv_tokens_6_0= ruleTokens ) )? ( (lv_root_7_0= ruleElement ) ) ( (lv_output_8_0= ruleGenerator ) )? ( (lv_before_9_0= ruleBefore ) )? ( (lv_after_10_0= ruleAfter ) )? ) ;
    public final EObject ruleXtextTest() throws RecognitionException {
        EObject current = null;

        Token this_PACKAGE_1=null;
        Token this_LANGUAGE_3=null;
        AntlrDatatypeRuleToken lv_package_2_0 = null;

        AntlrDatatypeRuleToken lv_lang_4_0 = null;

        EObject lv_input_5_0 = null;

        EObject lv_tokens_6_0 = null;

        EObject lv_root_7_0 = null;

        EObject lv_output_8_0 = null;

        EObject lv_before_9_0 = null;

        EObject lv_after_10_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:83:7: ( ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) ( (lv_input_5_0= ruleInput ) ) ( (lv_tokens_6_0= ruleTokens ) )? ( (lv_root_7_0= ruleElement ) ) ( (lv_output_8_0= ruleGenerator ) )? ( (lv_before_9_0= ruleBefore ) )? ( (lv_after_10_0= ruleAfter ) )? ) )
            // InternalXtextTest.g:85:1: ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) ( (lv_input_5_0= ruleInput ) ) ( (lv_tokens_6_0= ruleTokens ) )? ( (lv_root_7_0= ruleElement ) ) ( (lv_output_8_0= ruleGenerator ) )? ( (lv_before_9_0= ruleBefore ) )? ( (lv_after_10_0= ruleAfter ) )? )
            {
            // InternalXtextTest.g:85:1: ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) ( (lv_input_5_0= ruleInput ) ) ( (lv_tokens_6_0= ruleTokens ) )? ( (lv_root_7_0= ruleElement ) ) ( (lv_output_8_0= ruleGenerator ) )? ( (lv_before_9_0= ruleBefore ) )? ( (lv_after_10_0= ruleAfter ) )? )
            // InternalXtextTest.g:86:1: () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) ( (lv_input_5_0= ruleInput ) ) ( (lv_tokens_6_0= ruleTokens ) )? ( (lv_root_7_0= ruleElement ) ) ( (lv_output_8_0= ruleGenerator ) )? ( (lv_before_9_0= ruleBefore ) )? ( (lv_after_10_0= ruleAfter ) )?
            {
            // InternalXtextTest.g:86:1: ()
            // InternalXtextTest.g:87:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getXtextTestAccess().getXtextTestAction_0(),
                        current);
                

            }

            this_PACKAGE_1=(Token)match(input,RULE_PACKAGE,FOLLOW_3); 
             
                newLeafNode(this_PACKAGE_1, grammarAccess.getXtextTestAccess().getPACKAGETerminalRuleCall_1()); 
                
            // InternalXtextTest.g:102:1: ( (lv_package_2_0= rulePackageID ) )
            // InternalXtextTest.g:103:1: (lv_package_2_0= rulePackageID )
            {
            // InternalXtextTest.g:103:1: (lv_package_2_0= rulePackageID )
            // InternalXtextTest.g:104:3: lv_package_2_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getXtextTestAccess().getPackagePackageIDParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_4);
            lv_package_2_0=rulePackageID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
            	        }
                   		set(
                   			current, 
                   			"package",
                    		lv_package_2_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.PackageID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_LANGUAGE_3=(Token)match(input,RULE_LANGUAGE,FOLLOW_3); 
             
                newLeafNode(this_LANGUAGE_3, grammarAccess.getXtextTestAccess().getLANGUAGETerminalRuleCall_3()); 
                
            // InternalXtextTest.g:130:1: ( (lv_lang_4_0= ruleLangID ) )
            // InternalXtextTest.g:131:1: (lv_lang_4_0= ruleLangID )
            {
            // InternalXtextTest.g:131:1: (lv_lang_4_0= ruleLangID )
            // InternalXtextTest.g:132:3: lv_lang_4_0= ruleLangID
            {
             
            	        newCompositeNode(grammarAccess.getXtextTestAccess().getLangLangIDParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_5);
            lv_lang_4_0=ruleLangID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
            	        }
                   		set(
                   			current, 
                   			"lang",
                    		lv_lang_4_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.LangID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalXtextTest.g:151:1: ( (lv_input_5_0= ruleInput ) )
            // InternalXtextTest.g:152:1: (lv_input_5_0= ruleInput )
            {
            // InternalXtextTest.g:152:1: (lv_input_5_0= ruleInput )
            // InternalXtextTest.g:153:3: lv_input_5_0= ruleInput
            {
             
            	        newCompositeNode(grammarAccess.getXtextTestAccess().getInputInputParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_6);
            lv_input_5_0=ruleInput();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
            	        }
                   		set(
                   			current, 
                   			"input",
                    		lv_input_5_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.Input");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalXtextTest.g:172:1: ( (lv_tokens_6_0= ruleTokens ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_LEXER) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalXtextTest.g:173:1: (lv_tokens_6_0= ruleTokens )
                    {
                    // InternalXtextTest.g:173:1: (lv_tokens_6_0= ruleTokens )
                    // InternalXtextTest.g:174:3: lv_tokens_6_0= ruleTokens
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getTokensTokensParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_6);
                    lv_tokens_6_0=ruleTokens();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"tokens",
                            		lv_tokens_6_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Tokens");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalXtextTest.g:193:1: ( (lv_root_7_0= ruleElement ) )
            // InternalXtextTest.g:194:1: (lv_root_7_0= ruleElement )
            {
            // InternalXtextTest.g:194:1: (lv_root_7_0= ruleElement )
            // InternalXtextTest.g:195:3: lv_root_7_0= ruleElement
            {
             
            	        newCompositeNode(grammarAccess.getXtextTestAccess().getRootElementParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_7);
            lv_root_7_0=ruleElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
            	        }
                   		set(
                   			current, 
                   			"root",
                    		lv_root_7_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.Element");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalXtextTest.g:214:1: ( (lv_output_8_0= ruleGenerator ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_OUTPUT) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalXtextTest.g:215:1: (lv_output_8_0= ruleGenerator )
                    {
                    // InternalXtextTest.g:215:1: (lv_output_8_0= ruleGenerator )
                    // InternalXtextTest.g:216:3: lv_output_8_0= ruleGenerator
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getOutputGeneratorParserRuleCall_8_0()); 
                    	    
                    pushFollow(FOLLOW_8);
                    lv_output_8_0=ruleGenerator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"output",
                            		lv_output_8_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Generator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalXtextTest.g:235:1: ( (lv_before_9_0= ruleBefore ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_BEFORE_KW) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalXtextTest.g:236:1: (lv_before_9_0= ruleBefore )
                    {
                    // InternalXtextTest.g:236:1: (lv_before_9_0= ruleBefore )
                    // InternalXtextTest.g:237:3: lv_before_9_0= ruleBefore
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getBeforeBeforeParserRuleCall_9_0()); 
                    	    
                    pushFollow(FOLLOW_9);
                    lv_before_9_0=ruleBefore();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"before",
                            		lv_before_9_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Before");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalXtextTest.g:256:1: ( (lv_after_10_0= ruleAfter ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_AFTER_KW) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalXtextTest.g:257:1: (lv_after_10_0= ruleAfter )
                    {
                    // InternalXtextTest.g:257:1: (lv_after_10_0= ruleAfter )
                    // InternalXtextTest.g:258:3: lv_after_10_0= ruleAfter
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getAfterAfterParserRuleCall_10_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_after_10_0=ruleAfter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"after",
                            		lv_after_10_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.After");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleXtextTest"


    // $ANTLR start "entryRulePackageID"
    // InternalXtextTest.g:286:1: entryRulePackageID returns [String current=null] : iv_rulePackageID= rulePackageID EOF ;
    public final String entryRulePackageID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePackageID = null;


        try {
            // InternalXtextTest.g:287:2: (iv_rulePackageID= rulePackageID EOF )
            // InternalXtextTest.g:288:2: iv_rulePackageID= rulePackageID EOF
            {
             newCompositeNode(grammarAccess.getPackageIDRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackageID=rulePackageID();

            state._fsp--;

             current =iv_rulePackageID.getText(); 
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
    // $ANTLR end "entryRulePackageID"


    // $ANTLR start "rulePackageID"
    // InternalXtextTest.g:295:1: rulePackageID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* ) ;
    public final AntlrDatatypeRuleToken rulePackageID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IDENTIFIER_0=null;
        Token this_POINT_1=null;
        Token this_IDENTIFIER_2=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:298:28: ( (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* ) )
            // InternalXtextTest.g:299:1: (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* )
            {
            // InternalXtextTest.g:299:1: (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* )
            // InternalXtextTest.g:299:6: this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )*
            {
            this_IDENTIFIER_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_10); 

            		current.merge(this_IDENTIFIER_0);
                
             
                newLeafNode(this_IDENTIFIER_0, grammarAccess.getPackageIDAccess().getIDENTIFIERTerminalRuleCall_0()); 
                
            // InternalXtextTest.g:306:1: (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_POINT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalXtextTest.g:306:6: this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER
            	    {
            	    this_POINT_1=(Token)match(input,RULE_POINT,FOLLOW_3); 

            	    		current.merge(this_POINT_1);
            	        
            	     
            	        newLeafNode(this_POINT_1, grammarAccess.getPackageIDAccess().getPOINTTerminalRuleCall_1_0()); 
            	        
            	    this_IDENTIFIER_2=(Token)match(input,RULE_IDENTIFIER,FOLLOW_10); 

            	    		current.merge(this_IDENTIFIER_2);
            	        
            	     
            	        newLeafNode(this_IDENTIFIER_2, grammarAccess.getPackageIDAccess().getIDENTIFIERTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "rulePackageID"


    // $ANTLR start "entryRuleLangID"
    // InternalXtextTest.g:328:1: entryRuleLangID returns [String current=null] : iv_ruleLangID= ruleLangID EOF ;
    public final String entryRuleLangID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLangID = null;


        try {
            // InternalXtextTest.g:329:2: (iv_ruleLangID= ruleLangID EOF )
            // InternalXtextTest.g:330:2: iv_ruleLangID= ruleLangID EOF
            {
             newCompositeNode(grammarAccess.getLangIDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLangID=ruleLangID();

            state._fsp--;

             current =iv_ruleLangID.getText(); 
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
    // $ANTLR end "entryRuleLangID"


    // $ANTLR start "ruleLangID"
    // InternalXtextTest.g:337:1: ruleLangID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_IDENTIFIER_0= RULE_IDENTIFIER ;
    public final AntlrDatatypeRuleToken ruleLangID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IDENTIFIER_0=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:340:28: (this_IDENTIFIER_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:341:5: this_IDENTIFIER_0= RULE_IDENTIFIER
            {
            this_IDENTIFIER_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_2); 

            		current.merge(this_IDENTIFIER_0);
                
             
                newLeafNode(this_IDENTIFIER_0, grammarAccess.getLangIDAccess().getIDENTIFIERTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleLangID"


    // $ANTLR start "entryRuleInput"
    // InternalXtextTest.g:356:1: entryRuleInput returns [EObject current=null] : iv_ruleInput= ruleInput EOF ;
    public final EObject entryRuleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInput = null;


        try {
            // InternalXtextTest.g:357:2: (iv_ruleInput= ruleInput EOF )
            // InternalXtextTest.g:358:2: iv_ruleInput= ruleInput EOF
            {
             newCompositeNode(grammarAccess.getInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInput=ruleInput();

            state._fsp--;

             current =iv_ruleInput; 
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
    // $ANTLR end "entryRuleInput"


    // $ANTLR start "ruleInput"
    // InternalXtextTest.g:365:1: ruleInput returns [EObject current=null] : ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) ) ;
    public final EObject ruleInput() throws RecognitionException {
        EObject current = null;

        Token this_SOURCE_1=null;
        Token this_SRCTEXT_2=null;
        Token this_ASSIGNASSINGLE_3=null;
        Token lv_text_4_0=null;
        Token this_FILE_5=null;
        Token this_ASSIGNASSINGLE_6=null;
        Token lv_file_7_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:371:7: ( ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) ) )
            // InternalXtextTest.g:373:1: ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) )
            {
            // InternalXtextTest.g:373:1: ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) )
            // InternalXtextTest.g:374:1: () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) )
            {
            // InternalXtextTest.g:374:1: ()
            // InternalXtextTest.g:375:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInputAccess().getInputAction_0(),
                        current);
                

            }

            this_SOURCE_1=(Token)match(input,RULE_SOURCE,FOLLOW_11); 
             
                newLeafNode(this_SOURCE_1, grammarAccess.getInputAccess().getSOURCETerminalRuleCall_1()); 
                
            // InternalXtextTest.g:390:1: ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_SRCTEXT) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_FILE) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalXtextTest.g:391:1: (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:391:1: (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:392:1: this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) )
                    {
                    this_SRCTEXT_2=(Token)match(input,RULE_SRCTEXT,FOLLOW_12); 
                     
                        newLeafNode(this_SRCTEXT_2, grammarAccess.getInputAccess().getSRCTEXTTerminalRuleCall_2_0_0()); 
                        
                    this_ASSIGNASSINGLE_3=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_13); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_3, grammarAccess.getInputAccess().getASSIGNASSINGLETerminalRuleCall_2_0_1()); 
                        
                    // InternalXtextTest.g:406:1: ( (lv_text_4_0= RULE_STRING ) )
                    // InternalXtextTest.g:407:1: (lv_text_4_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:407:1: (lv_text_4_0= RULE_STRING )
                    // InternalXtextTest.g:408:3: lv_text_4_0= RULE_STRING
                    {
                    lv_text_4_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			newLeafNode(lv_text_4_0, grammarAccess.getInputAccess().getTextSTRINGTerminalRuleCall_2_0_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInputRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"text",
                            		lv_text_4_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:430:1: (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:430:1: (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:431:1: this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) )
                    {
                    this_FILE_5=(Token)match(input,RULE_FILE,FOLLOW_12); 
                     
                        newLeafNode(this_FILE_5, grammarAccess.getInputAccess().getFILETerminalRuleCall_2_1_0()); 
                        
                    this_ASSIGNASSINGLE_6=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_13); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_6, grammarAccess.getInputAccess().getASSIGNASSINGLETerminalRuleCall_2_1_1()); 
                        
                    // InternalXtextTest.g:445:1: ( (lv_file_7_0= RULE_STRING ) )
                    // InternalXtextTest.g:446:1: (lv_file_7_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:446:1: (lv_file_7_0= RULE_STRING )
                    // InternalXtextTest.g:447:3: lv_file_7_0= RULE_STRING
                    {
                    lv_file_7_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			newLeafNode(lv_file_7_0, grammarAccess.getInputAccess().getFileSTRINGTerminalRuleCall_2_1_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInputRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"file",
                            		lv_file_7_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

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
    // $ANTLR end "ruleInput"


    // $ANTLR start "entryRuleTokens"
    // InternalXtextTest.g:479:1: entryRuleTokens returns [EObject current=null] : iv_ruleTokens= ruleTokens EOF ;
    public final EObject entryRuleTokens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTokens = null;


        try {
            // InternalXtextTest.g:480:2: (iv_ruleTokens= ruleTokens EOF )
            // InternalXtextTest.g:481:2: iv_ruleTokens= ruleTokens EOF
            {
             newCompositeNode(grammarAccess.getTokensRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTokens=ruleTokens();

            state._fsp--;

             current =iv_ruleTokens; 
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
    // $ANTLR end "entryRuleTokens"


    // $ANTLR start "ruleTokens"
    // InternalXtextTest.g:488:1: ruleTokens returns [EObject current=null] : ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= RULE_IDENTIFIER ) )+ ) ;
    public final EObject ruleTokens() throws RecognitionException {
        EObject current = null;

        Token this_LEXER_1=null;
        Token lv_tokens_2_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:494:7: ( ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= RULE_IDENTIFIER ) )+ ) )
            // InternalXtextTest.g:496:1: ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= RULE_IDENTIFIER ) )+ )
            {
            // InternalXtextTest.g:496:1: ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= RULE_IDENTIFIER ) )+ )
            // InternalXtextTest.g:497:1: () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= RULE_IDENTIFIER ) )+
            {
            // InternalXtextTest.g:497:1: ()
            // InternalXtextTest.g:498:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTokensAccess().getTokensAction_0(),
                        current);
                

            }

            this_LEXER_1=(Token)match(input,RULE_LEXER,FOLLOW_3); 
             
                newLeafNode(this_LEXER_1, grammarAccess.getTokensAccess().getLEXERTerminalRuleCall_1()); 
                
            // InternalXtextTest.g:513:1: ( (lv_tokens_2_0= RULE_IDENTIFIER ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_IDENTIFIER) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalXtextTest.g:514:1: (lv_tokens_2_0= RULE_IDENTIFIER )
            	    {
            	    // InternalXtextTest.g:514:1: (lv_tokens_2_0= RULE_IDENTIFIER )
            	    // InternalXtextTest.g:515:3: lv_tokens_2_0= RULE_IDENTIFIER
            	    {
            	    lv_tokens_2_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_14); 

            	    			newLeafNode(lv_tokens_2_0, grammarAccess.getTokensAccess().getTokensIDENTIFIERTerminalRuleCall_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getTokensRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"tokens",
            	            		lv_tokens_2_0, 
            	            		"at.jku.weiner.xtexttest.XtextTest.IDENTIFIER");
            	    	    

            	    }


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
    // $ANTLR end "ruleTokens"


    // $ANTLR start "entryRuleElement"
    // InternalXtextTest.g:543:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalXtextTest.g:544:2: (iv_ruleElement= ruleElement EOF )
            // InternalXtextTest.g:545:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalXtextTest.g:552:1: ruleElement returns [EObject current=null] : ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( (lv_name_2_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_3_0= ruleInner ) ) (this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) ) )* )? this_RIGHTPAREN_6= RULE_RIGHTPAREN ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token this_LEFTPAREN_1=null;
        Token lv_name_2_0=null;
        Token this_COMMA_4=null;
        Token this_RIGHTPAREN_6=null;
        EObject lv_inner_3_0 = null;

        EObject lv_inner_5_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:558:7: ( ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( (lv_name_2_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_3_0= ruleInner ) ) (this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) ) )* )? this_RIGHTPAREN_6= RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:560:1: ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( (lv_name_2_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_3_0= ruleInner ) ) (this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) ) )* )? this_RIGHTPAREN_6= RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:560:1: ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( (lv_name_2_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_3_0= ruleInner ) ) (this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) ) )* )? this_RIGHTPAREN_6= RULE_RIGHTPAREN )
            // InternalXtextTest.g:561:1: () this_LEFTPAREN_1= RULE_LEFTPAREN ( (lv_name_2_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_3_0= ruleInner ) ) (this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) ) )* )? this_RIGHTPAREN_6= RULE_RIGHTPAREN
            {
            // InternalXtextTest.g:561:1: ()
            // InternalXtextTest.g:562:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getElementAccess().getElementAction_0(),
                        current);
                

            }

            this_LEFTPAREN_1=(Token)match(input,RULE_LEFTPAREN,FOLLOW_3); 
             
                newLeafNode(this_LEFTPAREN_1, grammarAccess.getElementAccess().getLEFTPARENTerminalRuleCall_1()); 
                
            // InternalXtextTest.g:577:1: ( (lv_name_2_0= RULE_IDENTIFIER ) )
            // InternalXtextTest.g:578:1: (lv_name_2_0= RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:578:1: (lv_name_2_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:579:3: lv_name_2_0= RULE_IDENTIFIER
            {
            lv_name_2_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_15); 

            			newLeafNode(lv_name_2_0, grammarAccess.getElementAccess().getNameIDENTIFIERTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getElementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.IDENTIFIER");
            	    

            }


            }

            // InternalXtextTest.g:598:1: ( ( (lv_inner_3_0= ruleInner ) ) (this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_IDENTIFIER) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalXtextTest.g:599:1: ( (lv_inner_3_0= ruleInner ) ) (this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) ) )*
                    {
                    // InternalXtextTest.g:599:1: ( (lv_inner_3_0= ruleInner ) )
                    // InternalXtextTest.g:600:1: (lv_inner_3_0= ruleInner )
                    {
                    // InternalXtextTest.g:600:1: (lv_inner_3_0= ruleInner )
                    // InternalXtextTest.g:601:3: lv_inner_3_0= ruleInner
                    {
                     
                    	        newCompositeNode(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_16);
                    lv_inner_3_0=ruleInner();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getElementRule());
                    	        }
                           		add(
                           			current, 
                           			"inner",
                            		lv_inner_3_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Inner");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalXtextTest.g:620:1: (this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_COMMA) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalXtextTest.g:621:1: this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) )
                    	    {
                    	    this_COMMA_4=(Token)match(input,RULE_COMMA,FOLLOW_3); 
                    	     
                    	        newLeafNode(this_COMMA_4, grammarAccess.getElementAccess().getCOMMATerminalRuleCall_3_1_0()); 
                    	        
                    	    // InternalXtextTest.g:628:1: ( (lv_inner_5_0= ruleInner ) )
                    	    // InternalXtextTest.g:629:1: (lv_inner_5_0= ruleInner )
                    	    {
                    	    // InternalXtextTest.g:629:1: (lv_inner_5_0= ruleInner )
                    	    // InternalXtextTest.g:630:3: lv_inner_5_0= ruleInner
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_16);
                    	    lv_inner_5_0=ruleInner();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getElementRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"inner",
                    	            		lv_inner_5_0, 
                    	            		"at.jku.weiner.xtexttest.XtextTest.Inner");
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
                    break;

            }

            this_RIGHTPAREN_6=(Token)match(input,RULE_RIGHTPAREN,FOLLOW_2); 
             
                newLeafNode(this_RIGHTPAREN_6, grammarAccess.getElementAccess().getRIGHTPARENTerminalRuleCall_4()); 
                

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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleInner"
    // InternalXtextTest.g:669:1: entryRuleInner returns [EObject current=null] : iv_ruleInner= ruleInner EOF ;
    public final EObject entryRuleInner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInner = null;


        try {
            // InternalXtextTest.g:670:2: (iv_ruleInner= ruleInner EOF )
            // InternalXtextTest.g:671:2: iv_ruleInner= ruleInner EOF
            {
             newCompositeNode(grammarAccess.getInnerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInner=ruleInner();

            state._fsp--;

             current =iv_ruleInner; 
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
    // $ANTLR end "entryRuleInner"


    // $ANTLR start "ruleInner"
    // InternalXtextTest.g:678:1: ruleInner returns [EObject current=null] : ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) ) ) ;
    public final EObject ruleInner() throws RecognitionException {
        EObject current = null;

        Token lv_parameter_1_0=null;
        Token this_ASSIGNASSINGLE_2=null;
        Token this_ASSIGNASLIST_4=null;
        Token this_COMMA_6=null;
        Token this_ASSIGNASSTRING_8=null;
        Token lv_value_9_0=null;
        Token this_ASSIGNASDATALIST_10=null;
        Token lv_assignAsData_11_0=null;
        EObject lv_assign_3_0 = null;

        EObject lv_assignList_5_0 = null;

        EObject lv_assignList_7_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:684:7: ( ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) ) ) )
            // InternalXtextTest.g:686:1: ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) ) )
            {
            // InternalXtextTest.g:686:1: ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) ) )
            // InternalXtextTest.g:687:1: () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) )
            {
            // InternalXtextTest.g:687:1: ()
            // InternalXtextTest.g:688:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInnerAccess().getInnerAction_0(),
                        current);
                

            }

            // InternalXtextTest.g:696:1: ( (lv_parameter_1_0= RULE_IDENTIFIER ) )
            // InternalXtextTest.g:697:1: (lv_parameter_1_0= RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:697:1: (lv_parameter_1_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:698:3: lv_parameter_1_0= RULE_IDENTIFIER
            {
            lv_parameter_1_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_17); 

            			newLeafNode(lv_parameter_1_0, grammarAccess.getInnerAccess().getParameterIDENTIFIERTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInnerRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"parameter",
                    		lv_parameter_1_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.IDENTIFIER");
            	    

            }


            }

            // InternalXtextTest.g:717:1: ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case RULE_ASSIGNASSINGLE:
                {
                alt11=1;
                }
                break;
            case RULE_ASSIGNASLIST:
                {
                alt11=2;
                }
                break;
            case RULE_ASSIGNASSTRING:
                {
                alt11=3;
                }
                break;
            case RULE_ASSIGNASDATALIST:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalXtextTest.g:718:1: (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) )
                    {
                    // InternalXtextTest.g:718:1: (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) )
                    // InternalXtextTest.g:719:1: this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) )
                    {
                    this_ASSIGNASSINGLE_2=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_6); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_2, grammarAccess.getInnerAccess().getASSIGNASSINGLETerminalRuleCall_2_0_0()); 
                        
                    // InternalXtextTest.g:726:1: ( (lv_assign_3_0= ruleElement ) )
                    // InternalXtextTest.g:727:1: (lv_assign_3_0= ruleElement )
                    {
                    // InternalXtextTest.g:727:1: (lv_assign_3_0= ruleElement )
                    // InternalXtextTest.g:728:3: lv_assign_3_0= ruleElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getInnerAccess().getAssignElementParserRuleCall_2_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_assign_3_0=ruleElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInnerRule());
                    	        }
                           		set(
                           			current, 
                           			"assign",
                            		lv_assign_3_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Element");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:750:1: (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* )
                    {
                    // InternalXtextTest.g:750:1: (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* )
                    // InternalXtextTest.g:751:1: this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )*
                    {
                    this_ASSIGNASLIST_4=(Token)match(input,RULE_ASSIGNASLIST,FOLLOW_6); 
                     
                        newLeafNode(this_ASSIGNASLIST_4, grammarAccess.getInnerAccess().getASSIGNASLISTTerminalRuleCall_2_1_0()); 
                        
                    // InternalXtextTest.g:758:1: ( (lv_assignList_5_0= ruleElement ) )
                    // InternalXtextTest.g:759:1: (lv_assignList_5_0= ruleElement )
                    {
                    // InternalXtextTest.g:759:1: (lv_assignList_5_0= ruleElement )
                    // InternalXtextTest.g:760:3: lv_assignList_5_0= ruleElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getInnerAccess().getAssignListElementParserRuleCall_2_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_18);
                    lv_assignList_5_0=ruleElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInnerRule());
                    	        }
                           		add(
                           			current, 
                           			"assignList",
                            		lv_assignList_5_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Element");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalXtextTest.g:779:1: (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_COMMA) ) {
                            int LA10_1 = input.LA(2);

                            if ( (LA10_1==RULE_LEFTPAREN) ) {
                                alt10=1;
                            }


                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalXtextTest.g:780:1: this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) )
                    	    {
                    	    this_COMMA_6=(Token)match(input,RULE_COMMA,FOLLOW_6); 
                    	     
                    	        newLeafNode(this_COMMA_6, grammarAccess.getInnerAccess().getCOMMATerminalRuleCall_2_1_2_0()); 
                    	        
                    	    // InternalXtextTest.g:787:1: ( (lv_assignList_7_0= ruleElement ) )
                    	    // InternalXtextTest.g:788:1: (lv_assignList_7_0= ruleElement )
                    	    {
                    	    // InternalXtextTest.g:788:1: (lv_assignList_7_0= ruleElement )
                    	    // InternalXtextTest.g:789:3: lv_assignList_7_0= ruleElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInnerAccess().getAssignListElementParserRuleCall_2_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_18);
                    	    lv_assignList_7_0=ruleElement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInnerRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"assignList",
                    	            		lv_assignList_7_0, 
                    	            		"at.jku.weiner.xtexttest.XtextTest.Element");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // InternalXtextTest.g:813:1: (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:813:1: (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:814:1: this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) )
                    {
                    this_ASSIGNASSTRING_8=(Token)match(input,RULE_ASSIGNASSTRING,FOLLOW_13); 
                     
                        newLeafNode(this_ASSIGNASSTRING_8, grammarAccess.getInnerAccess().getASSIGNASSTRINGTerminalRuleCall_2_2_0()); 
                        
                    // InternalXtextTest.g:821:1: ( (lv_value_9_0= RULE_STRING ) )
                    // InternalXtextTest.g:822:1: (lv_value_9_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:822:1: (lv_value_9_0= RULE_STRING )
                    // InternalXtextTest.g:823:3: lv_value_9_0= RULE_STRING
                    {
                    lv_value_9_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			newLeafNode(lv_value_9_0, grammarAccess.getInnerAccess().getValueSTRINGTerminalRuleCall_2_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInnerRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_9_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalXtextTest.g:845:1: (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:845:1: (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:846:1: this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) )
                    {
                    this_ASSIGNASDATALIST_10=(Token)match(input,RULE_ASSIGNASDATALIST,FOLLOW_13); 
                     
                        newLeafNode(this_ASSIGNASDATALIST_10, grammarAccess.getInnerAccess().getASSIGNASDATALISTTerminalRuleCall_2_3_0()); 
                        
                    // InternalXtextTest.g:853:1: ( (lv_assignAsData_11_0= RULE_STRING ) )
                    // InternalXtextTest.g:854:1: (lv_assignAsData_11_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:854:1: (lv_assignAsData_11_0= RULE_STRING )
                    // InternalXtextTest.g:855:3: lv_assignAsData_11_0= RULE_STRING
                    {
                    lv_assignAsData_11_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			newLeafNode(lv_assignAsData_11_0, grammarAccess.getInnerAccess().getAssignAsDataSTRINGTerminalRuleCall_2_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInnerRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"assignAsData",
                            		lv_assignAsData_11_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

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
    // $ANTLR end "ruleInner"


    // $ANTLR start "entryRuleGenerator"
    // InternalXtextTest.g:887:1: entryRuleGenerator returns [EObject current=null] : iv_ruleGenerator= ruleGenerator EOF ;
    public final EObject entryRuleGenerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenerator = null;


        try {
            // InternalXtextTest.g:888:2: (iv_ruleGenerator= ruleGenerator EOF )
            // InternalXtextTest.g:889:2: iv_ruleGenerator= ruleGenerator EOF
            {
             newCompositeNode(grammarAccess.getGeneratorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGenerator=ruleGenerator();

            state._fsp--;

             current =iv_ruleGenerator; 
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
    // $ANTLR end "entryRuleGenerator"


    // $ANTLR start "ruleGenerator"
    // InternalXtextTest.g:896:1: ruleGenerator returns [EObject current=null] : ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? ) ;
    public final EObject ruleGenerator() throws RecognitionException {
        EObject current = null;

        Token this_OUTPUT_1=null;
        Token this_FILE_2=null;
        Token this_ASSIGNASSINGLE_3=null;
        Token lv_output_4_0=null;
        Token this_EXPECTED_5=null;
        Token this_FILE_6=null;
        Token this_ASSIGNASSINGLE_7=null;
        Token lv_expected_8_0=null;
        Token lv_isSameAsInputFile_9_0=null;
        Token this_PATTERNS_10=null;
        Token this_FILE_11=null;
        Token this_ASSIGNASSINGLE_12=null;
        Token lv_patternFile_13_0=null;
        Token this_EXPECTED_15=null;
        Token this_EXCEPTIONS_16=null;
        EObject lv_replacePatterns_14_0 = null;

        AntlrDatatypeRuleToken lv_exception_17_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:902:7: ( ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? ) )
            // InternalXtextTest.g:904:1: ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? )
            {
            // InternalXtextTest.g:904:1: ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? )
            // InternalXtextTest.g:905:1: () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )?
            {
            // InternalXtextTest.g:905:1: ()
            // InternalXtextTest.g:906:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getGeneratorAccess().getGeneratorAction_0(),
                        current);
                

            }

            // InternalXtextTest.g:914:1: (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) )
            // InternalXtextTest.g:915:1: this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) )
            {
            this_OUTPUT_1=(Token)match(input,RULE_OUTPUT,FOLLOW_19); 
             
                newLeafNode(this_OUTPUT_1, grammarAccess.getGeneratorAccess().getOUTPUTTerminalRuleCall_1_0()); 
                
            this_FILE_2=(Token)match(input,RULE_FILE,FOLLOW_12); 
             
                newLeafNode(this_FILE_2, grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_1_1()); 
                
            this_ASSIGNASSINGLE_3=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_13); 
             
                newLeafNode(this_ASSIGNASSINGLE_3, grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_1_2()); 
                
            // InternalXtextTest.g:936:1: ( (lv_output_4_0= RULE_STRING ) )
            // InternalXtextTest.g:937:1: (lv_output_4_0= RULE_STRING )
            {
            // InternalXtextTest.g:937:1: (lv_output_4_0= RULE_STRING )
            // InternalXtextTest.g:938:3: lv_output_4_0= RULE_STRING
            {
            lv_output_4_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            			newLeafNode(lv_output_4_0, grammarAccess.getGeneratorAccess().getOutputSTRINGTerminalRuleCall_1_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getGeneratorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"output",
                    		lv_output_4_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }


            }

            // InternalXtextTest.g:959:1: (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) )
            // InternalXtextTest.g:960:1: this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) )
            {
            this_EXPECTED_5=(Token)match(input,RULE_EXPECTED,FOLLOW_19); 
             
                newLeafNode(this_EXPECTED_5, grammarAccess.getGeneratorAccess().getEXPECTEDTerminalRuleCall_2_0()); 
                
            this_FILE_6=(Token)match(input,RULE_FILE,FOLLOW_21); 
             
                newLeafNode(this_FILE_6, grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_2_1()); 
                
            // InternalXtextTest.g:974:1: ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ASSIGNASSINGLE) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ISSAMEASINPUTFILE) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalXtextTest.g:975:1: (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:975:1: (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:976:1: this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) )
                    {
                    this_ASSIGNASSINGLE_7=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_13); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_7, grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_2_2_0_0()); 
                        
                    // InternalXtextTest.g:983:1: ( (lv_expected_8_0= RULE_STRING ) )
                    // InternalXtextTest.g:984:1: (lv_expected_8_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:984:1: (lv_expected_8_0= RULE_STRING )
                    // InternalXtextTest.g:985:3: lv_expected_8_0= RULE_STRING
                    {
                    lv_expected_8_0=(Token)match(input,RULE_STRING,FOLLOW_22); 

                    			newLeafNode(lv_expected_8_0, grammarAccess.getGeneratorAccess().getExpectedSTRINGTerminalRuleCall_2_2_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGeneratorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"expected",
                            		lv_expected_8_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:1007:1: ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) )
                    {
                    // InternalXtextTest.g:1007:1: ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) )
                    // InternalXtextTest.g:1008:1: (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE )
                    {
                    // InternalXtextTest.g:1008:1: (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE )
                    // InternalXtextTest.g:1009:3: lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE
                    {
                    lv_isSameAsInputFile_9_0=(Token)match(input,RULE_ISSAMEASINPUTFILE,FOLLOW_22); 

                    			newLeafNode(lv_isSameAsInputFile_9_0, grammarAccess.getGeneratorAccess().getIsSameAsInputFileISSAMEASINPUTFILETerminalRuleCall_2_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGeneratorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"isSameAsInputFile",
                            		true, 
                            		"at.jku.weiner.xtexttest.XtextTest.ISSAMEASINPUTFILE");
                    	    

                    }


                    }


                    }
                    break;

            }


            }

            // InternalXtextTest.g:1032:1: (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_PATTERNS) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalXtextTest.g:1033:1: this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )*
                    {
                    this_PATTERNS_10=(Token)match(input,RULE_PATTERNS,FOLLOW_23); 
                     
                        newLeafNode(this_PATTERNS_10, grammarAccess.getGeneratorAccess().getPATTERNSTerminalRuleCall_3_0()); 
                        
                    // InternalXtextTest.g:1040:1: (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==RULE_FILE) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalXtextTest.g:1041:1: this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) )
                            {
                            this_FILE_11=(Token)match(input,RULE_FILE,FOLLOW_12); 
                             
                                newLeafNode(this_FILE_11, grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_3_1_0()); 
                                
                            this_ASSIGNASSINGLE_12=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_13); 
                             
                                newLeafNode(this_ASSIGNASSINGLE_12, grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_3_1_1()); 
                                
                            // InternalXtextTest.g:1055:1: ( (lv_patternFile_13_0= RULE_STRING ) )
                            // InternalXtextTest.g:1056:1: (lv_patternFile_13_0= RULE_STRING )
                            {
                            // InternalXtextTest.g:1056:1: (lv_patternFile_13_0= RULE_STRING )
                            // InternalXtextTest.g:1057:3: lv_patternFile_13_0= RULE_STRING
                            {
                            lv_patternFile_13_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

                            			newLeafNode(lv_patternFile_13_0, grammarAccess.getGeneratorAccess().getPatternFileSTRINGTerminalRuleCall_3_1_2_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getGeneratorRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"patternFile",
                                    		lv_patternFile_13_0, 
                                    		"org.eclipse.xtext.common.Terminals.STRING");
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalXtextTest.g:1078:1: ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_STRING) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalXtextTest.g:1079:1: (lv_replacePatterns_14_0= ruleReplacePatterns )
                    	    {
                    	    // InternalXtextTest.g:1079:1: (lv_replacePatterns_14_0= ruleReplacePatterns )
                    	    // InternalXtextTest.g:1080:3: lv_replacePatterns_14_0= ruleReplacePatterns
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getGeneratorAccess().getReplacePatternsReplacePatternsParserRuleCall_3_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_24);
                    	    lv_replacePatterns_14_0=ruleReplacePatterns();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getGeneratorRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"replacePatterns",
                    	            		lv_replacePatterns_14_0, 
                    	            		"at.jku.weiner.xtexttest.XtextTest.ReplacePatterns");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalXtextTest.g:1101:1: (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_EXPECTED) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalXtextTest.g:1102:1: this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) )
                    {
                    this_EXPECTED_15=(Token)match(input,RULE_EXPECTED,FOLLOW_25); 
                     
                        newLeafNode(this_EXPECTED_15, grammarAccess.getGeneratorAccess().getEXPECTEDTerminalRuleCall_4_0()); 
                        
                    this_EXCEPTIONS_16=(Token)match(input,RULE_EXCEPTIONS,FOLLOW_3); 
                     
                        newLeafNode(this_EXCEPTIONS_16, grammarAccess.getGeneratorAccess().getEXCEPTIONSTerminalRuleCall_4_1()); 
                        
                    // InternalXtextTest.g:1116:1: ( (lv_exception_17_0= rulePackageID ) )
                    // InternalXtextTest.g:1117:1: (lv_exception_17_0= rulePackageID )
                    {
                    // InternalXtextTest.g:1117:1: (lv_exception_17_0= rulePackageID )
                    // InternalXtextTest.g:1118:3: lv_exception_17_0= rulePackageID
                    {
                     
                    	        newCompositeNode(grammarAccess.getGeneratorAccess().getExceptionPackageIDParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_exception_17_0=rulePackageID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getGeneratorRule());
                    	        }
                           		set(
                           			current, 
                           			"exception",
                            		lv_exception_17_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.PackageID");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleGenerator"


    // $ANTLR start "entryRuleReplacePatterns"
    // InternalXtextTest.g:1148:1: entryRuleReplacePatterns returns [EObject current=null] : iv_ruleReplacePatterns= ruleReplacePatterns EOF ;
    public final EObject entryRuleReplacePatterns() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReplacePatterns = null;


        try {
            // InternalXtextTest.g:1149:2: (iv_ruleReplacePatterns= ruleReplacePatterns EOF )
            // InternalXtextTest.g:1150:2: iv_ruleReplacePatterns= ruleReplacePatterns EOF
            {
             newCompositeNode(grammarAccess.getReplacePatternsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReplacePatterns=ruleReplacePatterns();

            state._fsp--;

             current =iv_ruleReplacePatterns; 
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
    // $ANTLR end "entryRuleReplacePatterns"


    // $ANTLR start "ruleReplacePatterns"
    // InternalXtextTest.g:1157:1: ruleReplacePatterns returns [EObject current=null] : ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleReplacePatterns() throws RecognitionException {
        EObject current = null;

        Token lv_regex_0_0=null;
        Token this_ASSIGNASSINGLE_1=null;
        Token lv_replace_2_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:1163:7: ( ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) ) )
            // InternalXtextTest.g:1165:1: ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) )
            {
            // InternalXtextTest.g:1165:1: ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) )
            // InternalXtextTest.g:1166:1: ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) )
            {
            // InternalXtextTest.g:1166:1: ( (lv_regex_0_0= RULE_STRING ) )
            // InternalXtextTest.g:1167:1: (lv_regex_0_0= RULE_STRING )
            {
            // InternalXtextTest.g:1167:1: (lv_regex_0_0= RULE_STRING )
            // InternalXtextTest.g:1168:3: lv_regex_0_0= RULE_STRING
            {
            lv_regex_0_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            			newLeafNode(lv_regex_0_0, grammarAccess.getReplacePatternsAccess().getRegexSTRINGTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getReplacePatternsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"regex",
                    		lv_regex_0_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }

            this_ASSIGNASSINGLE_1=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_13); 
             
                newLeafNode(this_ASSIGNASSINGLE_1, grammarAccess.getReplacePatternsAccess().getASSIGNASSINGLETerminalRuleCall_1()); 
                
            // InternalXtextTest.g:1194:1: ( (lv_replace_2_0= RULE_STRING ) )
            // InternalXtextTest.g:1195:1: (lv_replace_2_0= RULE_STRING )
            {
            // InternalXtextTest.g:1195:1: (lv_replace_2_0= RULE_STRING )
            // InternalXtextTest.g:1196:3: lv_replace_2_0= RULE_STRING
            {
            lv_replace_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            			newLeafNode(lv_replace_2_0, grammarAccess.getReplacePatternsAccess().getReplaceSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getReplacePatternsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"replace",
                    		lv_replace_2_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

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
    // $ANTLR end "ruleReplacePatterns"


    // $ANTLR start "entryRuleBefore"
    // InternalXtextTest.g:1224:1: entryRuleBefore returns [EObject current=null] : iv_ruleBefore= ruleBefore EOF ;
    public final EObject entryRuleBefore() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBefore = null;


        try {
            // InternalXtextTest.g:1225:2: (iv_ruleBefore= ruleBefore EOF )
            // InternalXtextTest.g:1226:2: iv_ruleBefore= ruleBefore EOF
            {
             newCompositeNode(grammarAccess.getBeforeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBefore=ruleBefore();

            state._fsp--;

             current =iv_ruleBefore; 
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
    // $ANTLR end "entryRuleBefore"


    // $ANTLR start "ruleBefore"
    // InternalXtextTest.g:1233:1: ruleBefore returns [EObject current=null] : (this_BEFORE_KW_0= RULE_BEFORE_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN ) ;
    public final EObject ruleBefore() throws RecognitionException {
        EObject current = null;

        Token this_BEFORE_KW_0=null;
        Token this_CLASS_KW_1=null;
        Token this_ASSIGNASSINGLE_2=null;
        Token this_METHOD_KW_4=null;
        Token this_ASSIGNASSINGLE_5=null;
        Token this_LEFTPAREN_7=null;
        Token this_RIGHTPAREN_8=null;
        AntlrDatatypeRuleToken lv_myclass_3_0 = null;

        AntlrDatatypeRuleToken lv_method_6_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:1239:7: ( (this_BEFORE_KW_0= RULE_BEFORE_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:1241:1: (this_BEFORE_KW_0= RULE_BEFORE_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:1241:1: (this_BEFORE_KW_0= RULE_BEFORE_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            // InternalXtextTest.g:1242:1: this_BEFORE_KW_0= RULE_BEFORE_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN
            {
            this_BEFORE_KW_0=(Token)match(input,RULE_BEFORE_KW,FOLLOW_26); 
             
                newLeafNode(this_BEFORE_KW_0, grammarAccess.getBeforeAccess().getBEFORE_KWTerminalRuleCall_0()); 
                
            this_CLASS_KW_1=(Token)match(input,RULE_CLASS_KW,FOLLOW_12); 
             
                newLeafNode(this_CLASS_KW_1, grammarAccess.getBeforeAccess().getCLASS_KWTerminalRuleCall_1()); 
                
            this_ASSIGNASSINGLE_2=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_3); 
             
                newLeafNode(this_ASSIGNASSINGLE_2, grammarAccess.getBeforeAccess().getASSIGNASSINGLETerminalRuleCall_2()); 
                
            // InternalXtextTest.g:1263:1: ( (lv_myclass_3_0= rulePackageID ) )
            // InternalXtextTest.g:1264:1: (lv_myclass_3_0= rulePackageID )
            {
            // InternalXtextTest.g:1264:1: (lv_myclass_3_0= rulePackageID )
            // InternalXtextTest.g:1265:3: lv_myclass_3_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getBeforeAccess().getMyclassPackageIDParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_27);
            lv_myclass_3_0=rulePackageID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBeforeRule());
            	        }
                   		set(
                   			current, 
                   			"myclass",
                    		lv_myclass_3_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.PackageID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_METHOD_KW_4=(Token)match(input,RULE_METHOD_KW,FOLLOW_12); 
             
                newLeafNode(this_METHOD_KW_4, grammarAccess.getBeforeAccess().getMETHOD_KWTerminalRuleCall_4()); 
                
            this_ASSIGNASSINGLE_5=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_3); 
             
                newLeafNode(this_ASSIGNASSINGLE_5, grammarAccess.getBeforeAccess().getASSIGNASSINGLETerminalRuleCall_5()); 
                
            // InternalXtextTest.g:1298:1: ( (lv_method_6_0= rulePackageID ) )
            // InternalXtextTest.g:1299:1: (lv_method_6_0= rulePackageID )
            {
            // InternalXtextTest.g:1299:1: (lv_method_6_0= rulePackageID )
            // InternalXtextTest.g:1300:3: lv_method_6_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getBeforeAccess().getMethodPackageIDParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_28);
            lv_method_6_0=rulePackageID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBeforeRule());
            	        }
                   		set(
                   			current, 
                   			"method",
                    		lv_method_6_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.PackageID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_LEFTPAREN_7=(Token)match(input,RULE_LEFTPAREN,FOLLOW_29); 
             
                newLeafNode(this_LEFTPAREN_7, grammarAccess.getBeforeAccess().getLEFTPARENTerminalRuleCall_7()); 
                
            this_RIGHTPAREN_8=(Token)match(input,RULE_RIGHTPAREN,FOLLOW_2); 
             
                newLeafNode(this_RIGHTPAREN_8, grammarAccess.getBeforeAccess().getRIGHTPARENTerminalRuleCall_8()); 
                

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
    // $ANTLR end "ruleBefore"


    // $ANTLR start "entryRuleAfter"
    // InternalXtextTest.g:1342:1: entryRuleAfter returns [EObject current=null] : iv_ruleAfter= ruleAfter EOF ;
    public final EObject entryRuleAfter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAfter = null;


        try {
            // InternalXtextTest.g:1343:2: (iv_ruleAfter= ruleAfter EOF )
            // InternalXtextTest.g:1344:2: iv_ruleAfter= ruleAfter EOF
            {
             newCompositeNode(grammarAccess.getAfterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAfter=ruleAfter();

            state._fsp--;

             current =iv_ruleAfter; 
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
    // $ANTLR end "entryRuleAfter"


    // $ANTLR start "ruleAfter"
    // InternalXtextTest.g:1351:1: ruleAfter returns [EObject current=null] : (this_AFTER_KW_0= RULE_AFTER_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN ) ;
    public final EObject ruleAfter() throws RecognitionException {
        EObject current = null;

        Token this_AFTER_KW_0=null;
        Token this_CLASS_KW_1=null;
        Token this_ASSIGNASSINGLE_2=null;
        Token this_METHOD_KW_4=null;
        Token this_ASSIGNASSINGLE_5=null;
        Token this_LEFTPAREN_7=null;
        Token this_RIGHTPAREN_8=null;
        AntlrDatatypeRuleToken lv_myclass_3_0 = null;

        AntlrDatatypeRuleToken lv_method_6_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:1357:7: ( (this_AFTER_KW_0= RULE_AFTER_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:1359:1: (this_AFTER_KW_0= RULE_AFTER_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:1359:1: (this_AFTER_KW_0= RULE_AFTER_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            // InternalXtextTest.g:1360:1: this_AFTER_KW_0= RULE_AFTER_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN
            {
            this_AFTER_KW_0=(Token)match(input,RULE_AFTER_KW,FOLLOW_26); 
             
                newLeafNode(this_AFTER_KW_0, grammarAccess.getAfterAccess().getAFTER_KWTerminalRuleCall_0()); 
                
            this_CLASS_KW_1=(Token)match(input,RULE_CLASS_KW,FOLLOW_12); 
             
                newLeafNode(this_CLASS_KW_1, grammarAccess.getAfterAccess().getCLASS_KWTerminalRuleCall_1()); 
                
            this_ASSIGNASSINGLE_2=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_3); 
             
                newLeafNode(this_ASSIGNASSINGLE_2, grammarAccess.getAfterAccess().getASSIGNASSINGLETerminalRuleCall_2()); 
                
            // InternalXtextTest.g:1381:1: ( (lv_myclass_3_0= rulePackageID ) )
            // InternalXtextTest.g:1382:1: (lv_myclass_3_0= rulePackageID )
            {
            // InternalXtextTest.g:1382:1: (lv_myclass_3_0= rulePackageID )
            // InternalXtextTest.g:1383:3: lv_myclass_3_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getAfterAccess().getMyclassPackageIDParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_27);
            lv_myclass_3_0=rulePackageID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAfterRule());
            	        }
                   		set(
                   			current, 
                   			"myclass",
                    		lv_myclass_3_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.PackageID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_METHOD_KW_4=(Token)match(input,RULE_METHOD_KW,FOLLOW_12); 
             
                newLeafNode(this_METHOD_KW_4, grammarAccess.getAfterAccess().getMETHOD_KWTerminalRuleCall_4()); 
                
            this_ASSIGNASSINGLE_5=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_3); 
             
                newLeafNode(this_ASSIGNASSINGLE_5, grammarAccess.getAfterAccess().getASSIGNASSINGLETerminalRuleCall_5()); 
                
            // InternalXtextTest.g:1416:1: ( (lv_method_6_0= rulePackageID ) )
            // InternalXtextTest.g:1417:1: (lv_method_6_0= rulePackageID )
            {
            // InternalXtextTest.g:1417:1: (lv_method_6_0= rulePackageID )
            // InternalXtextTest.g:1418:3: lv_method_6_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getAfterAccess().getMethodPackageIDParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_28);
            lv_method_6_0=rulePackageID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAfterRule());
            	        }
                   		set(
                   			current, 
                   			"method",
                    		lv_method_6_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.PackageID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_LEFTPAREN_7=(Token)match(input,RULE_LEFTPAREN,FOLLOW_29); 
             
                newLeafNode(this_LEFTPAREN_7, grammarAccess.getAfterAccess().getLEFTPARENTerminalRuleCall_7()); 
                
            this_RIGHTPAREN_8=(Token)match(input,RULE_RIGHTPAREN,FOLLOW_2); 
             
                newLeafNode(this_RIGHTPAREN_8, grammarAccess.getAfterAccess().getRIGHTPARENTerminalRuleCall_8()); 
                

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
    // $ANTLR end "ruleAfter"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000012100002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000012000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000000000E0400L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000A00002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000201802L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000200802L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000010000L});

}