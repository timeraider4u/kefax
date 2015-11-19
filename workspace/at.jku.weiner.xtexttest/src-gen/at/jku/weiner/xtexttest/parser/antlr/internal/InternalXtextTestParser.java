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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_PACKAGE", "RULE_LANGUAGE", "RULE_SPLITLEXER", "RULE_ASSIGNASSINGLE", "RULE_IDENTIFIER", "RULE_POINT", "RULE_SOURCE", "RULE_SRCTEXT", "RULE_STRING", "RULE_FILE", "RULE_LEXER", "RULE_ASSIGNASDATALIST", "RULE_INT", "RULE_LEFTPAREN", "RULE_COMMA", "RULE_RIGHTPAREN", "RULE_ASSIGNASLIST", "RULE_ASSIGNASSTRING", "RULE_OUTPUT", "RULE_EXPECTED", "RULE_ISSAMEASINPUTFILE", "RULE_PATTERNS", "RULE_EXCEPTIONS", "RULE_BEFORE_KW", "RULE_CLASS_KW", "RULE_METHOD_KW", "RULE_AFTER_KW", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'"
    };
    public static final int RULE_ID=31;
    public static final int RULE_SRCTEXT=11;
    public static final int RULE_RIGHTPAREN=19;
    public static final int RULE_METHOD_KW=29;
    public static final int RULE_PATTERNS=25;
    public static final int RULE_ASSIGNASDATALIST=15;
    public static final int RULE_ANY_OTHER=35;
    public static final int RULE_SPLITLEXER=6;
    public static final int RULE_LANGUAGE=5;
    public static final int RULE_EXPECTED=23;
    public static final int RULE_FILE=13;
    public static final int RULE_COMMA=18;
    public static final int RULE_IDENTIFIER=8;
    public static final int RULE_AFTER_KW=30;
    public static final int RULE_SL_COMMENT=33;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=32;
    public static final int RULE_BEFORE_KW=27;
    public static final int RULE_LEFTPAREN=17;
    public static final int RULE_PACKAGE=4;
    public static final int RULE_SOURCE=10;
    public static final int RULE_STRING=12;
    public static final int RULE_ASSIGNASSINGLE=7;
    public static final int RULE_ASSIGNASLIST=20;
    public static final int T__36=36;
    public static final int RULE_EXCEPTIONS=26;
    public static final int T__37=37;
    public static final int RULE_POINT=9;
    public static final int RULE_LEXER=14;
    public static final int RULE_OUTPUT=22;
    public static final int RULE_INT=16;
    public static final int RULE_CLASS_KW=28;
    public static final int RULE_ASSIGNASSTRING=21;
    public static final int RULE_WS=34;
    public static final int RULE_ISSAMEASINPUTFILE=24;

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
    // InternalXtextTest.g:77:1: ruleXtextTest returns [EObject current=null] : ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_SPLITLEXER_5= RULE_SPLITLEXER this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_boolean_7_0= ruleBoolean ) ) )? ( (lv_input_8_0= ruleInput ) ) ( (lv_tokens_9_0= ruleTokens ) )? ( (lv_root_10_0= ruleElement ) ) ( (lv_output_11_0= ruleGenerator ) )? ( (lv_before_12_0= ruleBefore ) )? ( (lv_after_13_0= ruleAfter ) )? ) ;
    public final EObject ruleXtextTest() throws RecognitionException {
        EObject current = null;

        Token this_PACKAGE_1=null;
        Token this_LANGUAGE_3=null;
        Token this_SPLITLEXER_5=null;
        Token this_ASSIGNASSINGLE_6=null;
        AntlrDatatypeRuleToken lv_package_2_0 = null;

        AntlrDatatypeRuleToken lv_lang_4_0 = null;

        AntlrDatatypeRuleToken lv_boolean_7_0 = null;

        EObject lv_input_8_0 = null;

        EObject lv_tokens_9_0 = null;

        EObject lv_root_10_0 = null;

        EObject lv_output_11_0 = null;

        EObject lv_before_12_0 = null;

        EObject lv_after_13_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:83:7: ( ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_SPLITLEXER_5= RULE_SPLITLEXER this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_boolean_7_0= ruleBoolean ) ) )? ( (lv_input_8_0= ruleInput ) ) ( (lv_tokens_9_0= ruleTokens ) )? ( (lv_root_10_0= ruleElement ) ) ( (lv_output_11_0= ruleGenerator ) )? ( (lv_before_12_0= ruleBefore ) )? ( (lv_after_13_0= ruleAfter ) )? ) )
            // InternalXtextTest.g:85:1: ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_SPLITLEXER_5= RULE_SPLITLEXER this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_boolean_7_0= ruleBoolean ) ) )? ( (lv_input_8_0= ruleInput ) ) ( (lv_tokens_9_0= ruleTokens ) )? ( (lv_root_10_0= ruleElement ) ) ( (lv_output_11_0= ruleGenerator ) )? ( (lv_before_12_0= ruleBefore ) )? ( (lv_after_13_0= ruleAfter ) )? )
            {
            // InternalXtextTest.g:85:1: ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_SPLITLEXER_5= RULE_SPLITLEXER this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_boolean_7_0= ruleBoolean ) ) )? ( (lv_input_8_0= ruleInput ) ) ( (lv_tokens_9_0= ruleTokens ) )? ( (lv_root_10_0= ruleElement ) ) ( (lv_output_11_0= ruleGenerator ) )? ( (lv_before_12_0= ruleBefore ) )? ( (lv_after_13_0= ruleAfter ) )? )
            // InternalXtextTest.g:86:1: () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_SPLITLEXER_5= RULE_SPLITLEXER this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_boolean_7_0= ruleBoolean ) ) )? ( (lv_input_8_0= ruleInput ) ) ( (lv_tokens_9_0= ruleTokens ) )? ( (lv_root_10_0= ruleElement ) ) ( (lv_output_11_0= ruleGenerator ) )? ( (lv_before_12_0= ruleBefore ) )? ( (lv_after_13_0= ruleAfter ) )?
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

            // InternalXtextTest.g:151:1: (this_SPLITLEXER_5= RULE_SPLITLEXER this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_boolean_7_0= ruleBoolean ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_SPLITLEXER) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalXtextTest.g:152:1: this_SPLITLEXER_5= RULE_SPLITLEXER this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_boolean_7_0= ruleBoolean ) )
                    {
                    this_SPLITLEXER_5=(Token)match(input,RULE_SPLITLEXER,FOLLOW_6); 
                     
                        newLeafNode(this_SPLITLEXER_5, grammarAccess.getXtextTestAccess().getSPLITLEXERTerminalRuleCall_5_0()); 
                        
                    this_ASSIGNASSINGLE_6=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_7); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_6, grammarAccess.getXtextTestAccess().getASSIGNASSINGLETerminalRuleCall_5_1()); 
                        
                    // InternalXtextTest.g:166:1: ( (lv_boolean_7_0= ruleBoolean ) )
                    // InternalXtextTest.g:167:1: (lv_boolean_7_0= ruleBoolean )
                    {
                    // InternalXtextTest.g:167:1: (lv_boolean_7_0= ruleBoolean )
                    // InternalXtextTest.g:168:3: lv_boolean_7_0= ruleBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getBooleanBooleanParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_boolean_7_0=ruleBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"boolean",
                            		lv_boolean_7_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Boolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalXtextTest.g:189:1: ( (lv_input_8_0= ruleInput ) )
            // InternalXtextTest.g:190:1: (lv_input_8_0= ruleInput )
            {
            // InternalXtextTest.g:190:1: (lv_input_8_0= ruleInput )
            // InternalXtextTest.g:191:3: lv_input_8_0= ruleInput
            {
             
            	        newCompositeNode(grammarAccess.getXtextTestAccess().getInputInputParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_8);
            lv_input_8_0=ruleInput();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
            	        }
                   		set(
                   			current, 
                   			"input",
                    		lv_input_8_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.Input");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalXtextTest.g:210:1: ( (lv_tokens_9_0= ruleTokens ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_LEXER) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalXtextTest.g:211:1: (lv_tokens_9_0= ruleTokens )
                    {
                    // InternalXtextTest.g:211:1: (lv_tokens_9_0= ruleTokens )
                    // InternalXtextTest.g:212:3: lv_tokens_9_0= ruleTokens
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getTokensTokensParserRuleCall_7_0()); 
                    	    
                    pushFollow(FOLLOW_8);
                    lv_tokens_9_0=ruleTokens();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"tokens",
                            		lv_tokens_9_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Tokens");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalXtextTest.g:231:1: ( (lv_root_10_0= ruleElement ) )
            // InternalXtextTest.g:232:1: (lv_root_10_0= ruleElement )
            {
            // InternalXtextTest.g:232:1: (lv_root_10_0= ruleElement )
            // InternalXtextTest.g:233:3: lv_root_10_0= ruleElement
            {
             
            	        newCompositeNode(grammarAccess.getXtextTestAccess().getRootElementParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_9);
            lv_root_10_0=ruleElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
            	        }
                   		set(
                   			current, 
                   			"root",
                    		lv_root_10_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.Element");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalXtextTest.g:252:1: ( (lv_output_11_0= ruleGenerator ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_OUTPUT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalXtextTest.g:253:1: (lv_output_11_0= ruleGenerator )
                    {
                    // InternalXtextTest.g:253:1: (lv_output_11_0= ruleGenerator )
                    // InternalXtextTest.g:254:3: lv_output_11_0= ruleGenerator
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getOutputGeneratorParserRuleCall_9_0()); 
                    	    
                    pushFollow(FOLLOW_10);
                    lv_output_11_0=ruleGenerator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"output",
                            		lv_output_11_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Generator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalXtextTest.g:273:1: ( (lv_before_12_0= ruleBefore ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_BEFORE_KW) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalXtextTest.g:274:1: (lv_before_12_0= ruleBefore )
                    {
                    // InternalXtextTest.g:274:1: (lv_before_12_0= ruleBefore )
                    // InternalXtextTest.g:275:3: lv_before_12_0= ruleBefore
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getBeforeBeforeParserRuleCall_10_0()); 
                    	    
                    pushFollow(FOLLOW_11);
                    lv_before_12_0=ruleBefore();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"before",
                            		lv_before_12_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Before");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalXtextTest.g:294:1: ( (lv_after_13_0= ruleAfter ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_AFTER_KW) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalXtextTest.g:295:1: (lv_after_13_0= ruleAfter )
                    {
                    // InternalXtextTest.g:295:1: (lv_after_13_0= ruleAfter )
                    // InternalXtextTest.g:296:3: lv_after_13_0= ruleAfter
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getAfterAfterParserRuleCall_11_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_after_13_0=ruleAfter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"after",
                            		lv_after_13_0, 
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


    // $ANTLR start "entryRuleBoolean"
    // InternalXtextTest.g:324:1: entryRuleBoolean returns [String current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final String entryRuleBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBoolean = null;


        try {
            // InternalXtextTest.g:325:2: (iv_ruleBoolean= ruleBoolean EOF )
            // InternalXtextTest.g:326:2: iv_ruleBoolean= ruleBoolean EOF
            {
             newCompositeNode(grammarAccess.getBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolean=ruleBoolean();

            state._fsp--;

             current =iv_ruleBoolean.getText(); 
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
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // InternalXtextTest.g:333:1: ruleBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:336:28: ( (kw= 'true' | kw= 'false' ) )
            // InternalXtextTest.g:337:1: (kw= 'true' | kw= 'false' )
            {
            // InternalXtextTest.g:337:1: (kw= 'true' | kw= 'false' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==36) ) {
                alt6=1;
            }
            else if ( (LA6_0==37) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalXtextTest.g:338:2: kw= 'true'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBooleanAccess().getTrueKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:345:2: kw= 'false'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBooleanAccess().getFalseKeyword_1()); 
                        

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
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRulePackageID"
    // InternalXtextTest.g:358:1: entryRulePackageID returns [String current=null] : iv_rulePackageID= rulePackageID EOF ;
    public final String entryRulePackageID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePackageID = null;


        try {
            // InternalXtextTest.g:359:2: (iv_rulePackageID= rulePackageID EOF )
            // InternalXtextTest.g:360:2: iv_rulePackageID= rulePackageID EOF
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
    // InternalXtextTest.g:367:1: rulePackageID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* ) ;
    public final AntlrDatatypeRuleToken rulePackageID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IDENTIFIER_0=null;
        Token this_POINT_1=null;
        Token this_IDENTIFIER_2=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:370:28: ( (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* ) )
            // InternalXtextTest.g:371:1: (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* )
            {
            // InternalXtextTest.g:371:1: (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* )
            // InternalXtextTest.g:371:6: this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )*
            {
            this_IDENTIFIER_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_12); 

            		current.merge(this_IDENTIFIER_0);
                
             
                newLeafNode(this_IDENTIFIER_0, grammarAccess.getPackageIDAccess().getIDENTIFIERTerminalRuleCall_0()); 
                
            // InternalXtextTest.g:378:1: (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_POINT) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalXtextTest.g:378:6: this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER
            	    {
            	    this_POINT_1=(Token)match(input,RULE_POINT,FOLLOW_3); 

            	    		current.merge(this_POINT_1);
            	        
            	     
            	        newLeafNode(this_POINT_1, grammarAccess.getPackageIDAccess().getPOINTTerminalRuleCall_1_0()); 
            	        
            	    this_IDENTIFIER_2=(Token)match(input,RULE_IDENTIFIER,FOLLOW_12); 

            	    		current.merge(this_IDENTIFIER_2);
            	        
            	     
            	        newLeafNode(this_IDENTIFIER_2, grammarAccess.getPackageIDAccess().getIDENTIFIERTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // InternalXtextTest.g:400:1: entryRuleLangID returns [String current=null] : iv_ruleLangID= ruleLangID EOF ;
    public final String entryRuleLangID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLangID = null;


        try {
            // InternalXtextTest.g:401:2: (iv_ruleLangID= ruleLangID EOF )
            // InternalXtextTest.g:402:2: iv_ruleLangID= ruleLangID EOF
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
    // InternalXtextTest.g:409:1: ruleLangID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_IDENTIFIER_0= RULE_IDENTIFIER ;
    public final AntlrDatatypeRuleToken ruleLangID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IDENTIFIER_0=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:412:28: (this_IDENTIFIER_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:413:5: this_IDENTIFIER_0= RULE_IDENTIFIER
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
    // InternalXtextTest.g:428:1: entryRuleInput returns [EObject current=null] : iv_ruleInput= ruleInput EOF ;
    public final EObject entryRuleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInput = null;


        try {
            // InternalXtextTest.g:429:2: (iv_ruleInput= ruleInput EOF )
            // InternalXtextTest.g:430:2: iv_ruleInput= ruleInput EOF
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
    // InternalXtextTest.g:437:1: ruleInput returns [EObject current=null] : ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) ) ;
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
            // InternalXtextTest.g:443:7: ( ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) ) )
            // InternalXtextTest.g:445:1: ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) )
            {
            // InternalXtextTest.g:445:1: ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) )
            // InternalXtextTest.g:446:1: () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) )
            {
            // InternalXtextTest.g:446:1: ()
            // InternalXtextTest.g:447:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInputAccess().getInputAction_0(),
                        current);
                

            }

            this_SOURCE_1=(Token)match(input,RULE_SOURCE,FOLLOW_13); 
             
                newLeafNode(this_SOURCE_1, grammarAccess.getInputAccess().getSOURCETerminalRuleCall_1()); 
                
            // InternalXtextTest.g:462:1: ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_SRCTEXT) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_FILE) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalXtextTest.g:463:1: (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:463:1: (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:464:1: this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) )
                    {
                    this_SRCTEXT_2=(Token)match(input,RULE_SRCTEXT,FOLLOW_6); 
                     
                        newLeafNode(this_SRCTEXT_2, grammarAccess.getInputAccess().getSRCTEXTTerminalRuleCall_2_0_0()); 
                        
                    this_ASSIGNASSINGLE_3=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_14); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_3, grammarAccess.getInputAccess().getASSIGNASSINGLETerminalRuleCall_2_0_1()); 
                        
                    // InternalXtextTest.g:478:1: ( (lv_text_4_0= RULE_STRING ) )
                    // InternalXtextTest.g:479:1: (lv_text_4_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:479:1: (lv_text_4_0= RULE_STRING )
                    // InternalXtextTest.g:480:3: lv_text_4_0= RULE_STRING
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
                    // InternalXtextTest.g:502:1: (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:502:1: (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:503:1: this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) )
                    {
                    this_FILE_5=(Token)match(input,RULE_FILE,FOLLOW_6); 
                     
                        newLeafNode(this_FILE_5, grammarAccess.getInputAccess().getFILETerminalRuleCall_2_1_0()); 
                        
                    this_ASSIGNASSINGLE_6=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_14); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_6, grammarAccess.getInputAccess().getASSIGNASSINGLETerminalRuleCall_2_1_1()); 
                        
                    // InternalXtextTest.g:517:1: ( (lv_file_7_0= RULE_STRING ) )
                    // InternalXtextTest.g:518:1: (lv_file_7_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:518:1: (lv_file_7_0= RULE_STRING )
                    // InternalXtextTest.g:519:3: lv_file_7_0= RULE_STRING
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
    // InternalXtextTest.g:551:1: entryRuleTokens returns [EObject current=null] : iv_ruleTokens= ruleTokens EOF ;
    public final EObject entryRuleTokens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTokens = null;


        try {
            // InternalXtextTest.g:552:2: (iv_ruleTokens= ruleTokens EOF )
            // InternalXtextTest.g:553:2: iv_ruleTokens= ruleTokens EOF
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
    // InternalXtextTest.g:560:1: ruleTokens returns [EObject current=null] : ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+ ) ;
    public final EObject ruleTokens() throws RecognitionException {
        EObject current = null;

        Token this_LEXER_1=null;
        EObject lv_tokens_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:566:7: ( ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+ ) )
            // InternalXtextTest.g:568:1: ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+ )
            {
            // InternalXtextTest.g:568:1: ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+ )
            // InternalXtextTest.g:569:1: () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+
            {
            // InternalXtextTest.g:569:1: ()
            // InternalXtextTest.g:570:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTokensAccess().getTokensAction_0(),
                        current);
                

            }

            this_LEXER_1=(Token)match(input,RULE_LEXER,FOLLOW_3); 
             
                newLeafNode(this_LEXER_1, grammarAccess.getTokensAccess().getLEXERTerminalRuleCall_1()); 
                
            // InternalXtextTest.g:585:1: ( (lv_tokens_2_0= ruleMyTokens ) )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_IDENTIFIER) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalXtextTest.g:586:1: (lv_tokens_2_0= ruleMyTokens )
            	    {
            	    // InternalXtextTest.g:586:1: (lv_tokens_2_0= ruleMyTokens )
            	    // InternalXtextTest.g:587:3: lv_tokens_2_0= ruleMyTokens
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTokensAccess().getTokensMyTokensParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_15);
            	    lv_tokens_2_0=ruleMyTokens();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTokensRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"tokens",
            	            		lv_tokens_2_0, 
            	            		"at.jku.weiner.xtexttest.XtextTest.MyTokens");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


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


    // $ANTLR start "entryRuleMyTokens"
    // InternalXtextTest.g:615:1: entryRuleMyTokens returns [EObject current=null] : iv_ruleMyTokens= ruleMyTokens EOF ;
    public final EObject entryRuleMyTokens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyTokens = null;


        try {
            // InternalXtextTest.g:616:2: (iv_ruleMyTokens= ruleMyTokens EOF )
            // InternalXtextTest.g:617:2: iv_ruleMyTokens= ruleMyTokens EOF
            {
             newCompositeNode(grammarAccess.getMyTokensRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMyTokens=ruleMyTokens();

            state._fsp--;

             current =iv_ruleMyTokens; 
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
    // $ANTLR end "entryRuleMyTokens"


    // $ANTLR start "ruleMyTokens"
    // InternalXtextTest.g:624:1: ruleMyTokens returns [EObject current=null] : ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) (this_ASSIGNASDATALIST_1= RULE_ASSIGNASDATALIST ( (lv_count_2_0= RULE_INT ) ) )? ) ;
    public final EObject ruleMyTokens() throws RecognitionException {
        EObject current = null;

        Token lv_token_0_0=null;
        Token this_ASSIGNASDATALIST_1=null;
        Token lv_count_2_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:630:7: ( ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) (this_ASSIGNASDATALIST_1= RULE_ASSIGNASDATALIST ( (lv_count_2_0= RULE_INT ) ) )? ) )
            // InternalXtextTest.g:632:1: ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) (this_ASSIGNASDATALIST_1= RULE_ASSIGNASDATALIST ( (lv_count_2_0= RULE_INT ) ) )? )
            {
            // InternalXtextTest.g:632:1: ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) (this_ASSIGNASDATALIST_1= RULE_ASSIGNASDATALIST ( (lv_count_2_0= RULE_INT ) ) )? )
            // InternalXtextTest.g:633:1: ( (lv_token_0_0= RULE_IDENTIFIER ) ) (this_ASSIGNASDATALIST_1= RULE_ASSIGNASDATALIST ( (lv_count_2_0= RULE_INT ) ) )?
            {
            // InternalXtextTest.g:633:1: ( (lv_token_0_0= RULE_IDENTIFIER ) )
            // InternalXtextTest.g:634:1: (lv_token_0_0= RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:634:1: (lv_token_0_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:635:3: lv_token_0_0= RULE_IDENTIFIER
            {
            lv_token_0_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_16); 

            			newLeafNode(lv_token_0_0, grammarAccess.getMyTokensAccess().getTokenIDENTIFIERTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMyTokensRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"token",
                    		lv_token_0_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.IDENTIFIER");
            	    

            }


            }

            // InternalXtextTest.g:654:1: (this_ASSIGNASDATALIST_1= RULE_ASSIGNASDATALIST ( (lv_count_2_0= RULE_INT ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ASSIGNASDATALIST) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalXtextTest.g:655:1: this_ASSIGNASDATALIST_1= RULE_ASSIGNASDATALIST ( (lv_count_2_0= RULE_INT ) )
                    {
                    this_ASSIGNASDATALIST_1=(Token)match(input,RULE_ASSIGNASDATALIST,FOLLOW_17); 
                     
                        newLeafNode(this_ASSIGNASDATALIST_1, grammarAccess.getMyTokensAccess().getASSIGNASDATALISTTerminalRuleCall_1_0()); 
                        
                    // InternalXtextTest.g:662:1: ( (lv_count_2_0= RULE_INT ) )
                    // InternalXtextTest.g:663:1: (lv_count_2_0= RULE_INT )
                    {
                    // InternalXtextTest.g:663:1: (lv_count_2_0= RULE_INT )
                    // InternalXtextTest.g:664:3: lv_count_2_0= RULE_INT
                    {
                    lv_count_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			newLeafNode(lv_count_2_0, grammarAccess.getMyTokensAccess().getCountINTTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMyTokensRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"count",
                            		lv_count_2_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

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
    // $ANTLR end "ruleMyTokens"


    // $ANTLR start "entryRuleElement"
    // InternalXtextTest.g:694:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalXtextTest.g:695:2: (iv_ruleElement= ruleElement EOF )
            // InternalXtextTest.g:696:2: iv_ruleElement= ruleElement EOF
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
    // InternalXtextTest.g:703:1: ruleElement returns [EObject current=null] : ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( (lv_name_2_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_3_0= ruleInner ) ) (this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) ) )* )? this_RIGHTPAREN_6= RULE_RIGHTPAREN ) ;
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
            // InternalXtextTest.g:709:7: ( ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( (lv_name_2_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_3_0= ruleInner ) ) (this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) ) )* )? this_RIGHTPAREN_6= RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:711:1: ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( (lv_name_2_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_3_0= ruleInner ) ) (this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) ) )* )? this_RIGHTPAREN_6= RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:711:1: ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( (lv_name_2_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_3_0= ruleInner ) ) (this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) ) )* )? this_RIGHTPAREN_6= RULE_RIGHTPAREN )
            // InternalXtextTest.g:712:1: () this_LEFTPAREN_1= RULE_LEFTPAREN ( (lv_name_2_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_3_0= ruleInner ) ) (this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) ) )* )? this_RIGHTPAREN_6= RULE_RIGHTPAREN
            {
            // InternalXtextTest.g:712:1: ()
            // InternalXtextTest.g:713:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getElementAccess().getElementAction_0(),
                        current);
                

            }

            this_LEFTPAREN_1=(Token)match(input,RULE_LEFTPAREN,FOLLOW_3); 
             
                newLeafNode(this_LEFTPAREN_1, grammarAccess.getElementAccess().getLEFTPARENTerminalRuleCall_1()); 
                
            // InternalXtextTest.g:728:1: ( (lv_name_2_0= RULE_IDENTIFIER ) )
            // InternalXtextTest.g:729:1: (lv_name_2_0= RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:729:1: (lv_name_2_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:730:3: lv_name_2_0= RULE_IDENTIFIER
            {
            lv_name_2_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_18); 

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

            // InternalXtextTest.g:749:1: ( ( (lv_inner_3_0= ruleInner ) ) (this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_IDENTIFIER) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalXtextTest.g:750:1: ( (lv_inner_3_0= ruleInner ) ) (this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) ) )*
                    {
                    // InternalXtextTest.g:750:1: ( (lv_inner_3_0= ruleInner ) )
                    // InternalXtextTest.g:751:1: (lv_inner_3_0= ruleInner )
                    {
                    // InternalXtextTest.g:751:1: (lv_inner_3_0= ruleInner )
                    // InternalXtextTest.g:752:3: lv_inner_3_0= ruleInner
                    {
                     
                    	        newCompositeNode(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_19);
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

                    // InternalXtextTest.g:771:1: (this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_COMMA) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalXtextTest.g:772:1: this_COMMA_4= RULE_COMMA ( (lv_inner_5_0= ruleInner ) )
                    	    {
                    	    this_COMMA_4=(Token)match(input,RULE_COMMA,FOLLOW_3); 
                    	     
                    	        newLeafNode(this_COMMA_4, grammarAccess.getElementAccess().getCOMMATerminalRuleCall_3_1_0()); 
                    	        
                    	    // InternalXtextTest.g:779:1: ( (lv_inner_5_0= ruleInner ) )
                    	    // InternalXtextTest.g:780:1: (lv_inner_5_0= ruleInner )
                    	    {
                    	    // InternalXtextTest.g:780:1: (lv_inner_5_0= ruleInner )
                    	    // InternalXtextTest.g:781:3: lv_inner_5_0= ruleInner
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_19);
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
                    	    break loop11;
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
    // InternalXtextTest.g:820:1: entryRuleInner returns [EObject current=null] : iv_ruleInner= ruleInner EOF ;
    public final EObject entryRuleInner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInner = null;


        try {
            // InternalXtextTest.g:821:2: (iv_ruleInner= ruleInner EOF )
            // InternalXtextTest.g:822:2: iv_ruleInner= ruleInner EOF
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
    // InternalXtextTest.g:829:1: ruleInner returns [EObject current=null] : ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) ) ) ;
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
            // InternalXtextTest.g:835:7: ( ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) ) ) )
            // InternalXtextTest.g:837:1: ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) ) )
            {
            // InternalXtextTest.g:837:1: ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) ) )
            // InternalXtextTest.g:838:1: () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) )
            {
            // InternalXtextTest.g:838:1: ()
            // InternalXtextTest.g:839:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInnerAccess().getInnerAction_0(),
                        current);
                

            }

            // InternalXtextTest.g:847:1: ( (lv_parameter_1_0= RULE_IDENTIFIER ) )
            // InternalXtextTest.g:848:1: (lv_parameter_1_0= RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:848:1: (lv_parameter_1_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:849:3: lv_parameter_1_0= RULE_IDENTIFIER
            {
            lv_parameter_1_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_20); 

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

            // InternalXtextTest.g:868:1: ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) )
            int alt14=4;
            switch ( input.LA(1) ) {
            case RULE_ASSIGNASSINGLE:
                {
                alt14=1;
                }
                break;
            case RULE_ASSIGNASLIST:
                {
                alt14=2;
                }
                break;
            case RULE_ASSIGNASSTRING:
                {
                alt14=3;
                }
                break;
            case RULE_ASSIGNASDATALIST:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalXtextTest.g:869:1: (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) )
                    {
                    // InternalXtextTest.g:869:1: (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) )
                    // InternalXtextTest.g:870:1: this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) )
                    {
                    this_ASSIGNASSINGLE_2=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_8); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_2, grammarAccess.getInnerAccess().getASSIGNASSINGLETerminalRuleCall_2_0_0()); 
                        
                    // InternalXtextTest.g:877:1: ( (lv_assign_3_0= ruleElement ) )
                    // InternalXtextTest.g:878:1: (lv_assign_3_0= ruleElement )
                    {
                    // InternalXtextTest.g:878:1: (lv_assign_3_0= ruleElement )
                    // InternalXtextTest.g:879:3: lv_assign_3_0= ruleElement
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
                    // InternalXtextTest.g:901:1: (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* )
                    {
                    // InternalXtextTest.g:901:1: (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* )
                    // InternalXtextTest.g:902:1: this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )*
                    {
                    this_ASSIGNASLIST_4=(Token)match(input,RULE_ASSIGNASLIST,FOLLOW_8); 
                     
                        newLeafNode(this_ASSIGNASLIST_4, grammarAccess.getInnerAccess().getASSIGNASLISTTerminalRuleCall_2_1_0()); 
                        
                    // InternalXtextTest.g:909:1: ( (lv_assignList_5_0= ruleElement ) )
                    // InternalXtextTest.g:910:1: (lv_assignList_5_0= ruleElement )
                    {
                    // InternalXtextTest.g:910:1: (lv_assignList_5_0= ruleElement )
                    // InternalXtextTest.g:911:3: lv_assignList_5_0= ruleElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getInnerAccess().getAssignListElementParserRuleCall_2_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_21);
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

                    // InternalXtextTest.g:930:1: (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_COMMA) ) {
                            int LA13_1 = input.LA(2);

                            if ( (LA13_1==RULE_LEFTPAREN) ) {
                                alt13=1;
                            }


                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalXtextTest.g:931:1: this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) )
                    	    {
                    	    this_COMMA_6=(Token)match(input,RULE_COMMA,FOLLOW_8); 
                    	     
                    	        newLeafNode(this_COMMA_6, grammarAccess.getInnerAccess().getCOMMATerminalRuleCall_2_1_2_0()); 
                    	        
                    	    // InternalXtextTest.g:938:1: ( (lv_assignList_7_0= ruleElement ) )
                    	    // InternalXtextTest.g:939:1: (lv_assignList_7_0= ruleElement )
                    	    {
                    	    // InternalXtextTest.g:939:1: (lv_assignList_7_0= ruleElement )
                    	    // InternalXtextTest.g:940:3: lv_assignList_7_0= ruleElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInnerAccess().getAssignListElementParserRuleCall_2_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_21);
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
                    	    break loop13;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // InternalXtextTest.g:964:1: (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:964:1: (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:965:1: this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) )
                    {
                    this_ASSIGNASSTRING_8=(Token)match(input,RULE_ASSIGNASSTRING,FOLLOW_14); 
                     
                        newLeafNode(this_ASSIGNASSTRING_8, grammarAccess.getInnerAccess().getASSIGNASSTRINGTerminalRuleCall_2_2_0()); 
                        
                    // InternalXtextTest.g:972:1: ( (lv_value_9_0= RULE_STRING ) )
                    // InternalXtextTest.g:973:1: (lv_value_9_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:973:1: (lv_value_9_0= RULE_STRING )
                    // InternalXtextTest.g:974:3: lv_value_9_0= RULE_STRING
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
                    // InternalXtextTest.g:996:1: (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:996:1: (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:997:1: this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) )
                    {
                    this_ASSIGNASDATALIST_10=(Token)match(input,RULE_ASSIGNASDATALIST,FOLLOW_14); 
                     
                        newLeafNode(this_ASSIGNASDATALIST_10, grammarAccess.getInnerAccess().getASSIGNASDATALISTTerminalRuleCall_2_3_0()); 
                        
                    // InternalXtextTest.g:1004:1: ( (lv_assignAsData_11_0= RULE_STRING ) )
                    // InternalXtextTest.g:1005:1: (lv_assignAsData_11_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1005:1: (lv_assignAsData_11_0= RULE_STRING )
                    // InternalXtextTest.g:1006:3: lv_assignAsData_11_0= RULE_STRING
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
    // InternalXtextTest.g:1038:1: entryRuleGenerator returns [EObject current=null] : iv_ruleGenerator= ruleGenerator EOF ;
    public final EObject entryRuleGenerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenerator = null;


        try {
            // InternalXtextTest.g:1039:2: (iv_ruleGenerator= ruleGenerator EOF )
            // InternalXtextTest.g:1040:2: iv_ruleGenerator= ruleGenerator EOF
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
    // InternalXtextTest.g:1047:1: ruleGenerator returns [EObject current=null] : ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? ) ;
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
            // InternalXtextTest.g:1053:7: ( ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? ) )
            // InternalXtextTest.g:1055:1: ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? )
            {
            // InternalXtextTest.g:1055:1: ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? )
            // InternalXtextTest.g:1056:1: () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )?
            {
            // InternalXtextTest.g:1056:1: ()
            // InternalXtextTest.g:1057:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getGeneratorAccess().getGeneratorAction_0(),
                        current);
                

            }

            // InternalXtextTest.g:1065:1: (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) )
            // InternalXtextTest.g:1066:1: this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) )
            {
            this_OUTPUT_1=(Token)match(input,RULE_OUTPUT,FOLLOW_22); 
             
                newLeafNode(this_OUTPUT_1, grammarAccess.getGeneratorAccess().getOUTPUTTerminalRuleCall_1_0()); 
                
            this_FILE_2=(Token)match(input,RULE_FILE,FOLLOW_6); 
             
                newLeafNode(this_FILE_2, grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_1_1()); 
                
            this_ASSIGNASSINGLE_3=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_14); 
             
                newLeafNode(this_ASSIGNASSINGLE_3, grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_1_2()); 
                
            // InternalXtextTest.g:1087:1: ( (lv_output_4_0= RULE_STRING ) )
            // InternalXtextTest.g:1088:1: (lv_output_4_0= RULE_STRING )
            {
            // InternalXtextTest.g:1088:1: (lv_output_4_0= RULE_STRING )
            // InternalXtextTest.g:1089:3: lv_output_4_0= RULE_STRING
            {
            lv_output_4_0=(Token)match(input,RULE_STRING,FOLLOW_23); 

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

            // InternalXtextTest.g:1110:1: (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) )
            // InternalXtextTest.g:1111:1: this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) )
            {
            this_EXPECTED_5=(Token)match(input,RULE_EXPECTED,FOLLOW_22); 
             
                newLeafNode(this_EXPECTED_5, grammarAccess.getGeneratorAccess().getEXPECTEDTerminalRuleCall_2_0()); 
                
            this_FILE_6=(Token)match(input,RULE_FILE,FOLLOW_24); 
             
                newLeafNode(this_FILE_6, grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_2_1()); 
                
            // InternalXtextTest.g:1125:1: ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ASSIGNASSINGLE) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_ISSAMEASINPUTFILE) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalXtextTest.g:1126:1: (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:1126:1: (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:1127:1: this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) )
                    {
                    this_ASSIGNASSINGLE_7=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_14); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_7, grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_2_2_0_0()); 
                        
                    // InternalXtextTest.g:1134:1: ( (lv_expected_8_0= RULE_STRING ) )
                    // InternalXtextTest.g:1135:1: (lv_expected_8_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1135:1: (lv_expected_8_0= RULE_STRING )
                    // InternalXtextTest.g:1136:3: lv_expected_8_0= RULE_STRING
                    {
                    lv_expected_8_0=(Token)match(input,RULE_STRING,FOLLOW_25); 

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
                    // InternalXtextTest.g:1158:1: ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) )
                    {
                    // InternalXtextTest.g:1158:1: ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) )
                    // InternalXtextTest.g:1159:1: (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE )
                    {
                    // InternalXtextTest.g:1159:1: (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE )
                    // InternalXtextTest.g:1160:3: lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE
                    {
                    lv_isSameAsInputFile_9_0=(Token)match(input,RULE_ISSAMEASINPUTFILE,FOLLOW_25); 

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

            // InternalXtextTest.g:1183:1: (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_PATTERNS) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalXtextTest.g:1184:1: this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )*
                    {
                    this_PATTERNS_10=(Token)match(input,RULE_PATTERNS,FOLLOW_26); 
                     
                        newLeafNode(this_PATTERNS_10, grammarAccess.getGeneratorAccess().getPATTERNSTerminalRuleCall_3_0()); 
                        
                    // InternalXtextTest.g:1191:1: (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==RULE_FILE) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalXtextTest.g:1192:1: this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) )
                            {
                            this_FILE_11=(Token)match(input,RULE_FILE,FOLLOW_6); 
                             
                                newLeafNode(this_FILE_11, grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_3_1_0()); 
                                
                            this_ASSIGNASSINGLE_12=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_14); 
                             
                                newLeafNode(this_ASSIGNASSINGLE_12, grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_3_1_1()); 
                                
                            // InternalXtextTest.g:1206:1: ( (lv_patternFile_13_0= RULE_STRING ) )
                            // InternalXtextTest.g:1207:1: (lv_patternFile_13_0= RULE_STRING )
                            {
                            // InternalXtextTest.g:1207:1: (lv_patternFile_13_0= RULE_STRING )
                            // InternalXtextTest.g:1208:3: lv_patternFile_13_0= RULE_STRING
                            {
                            lv_patternFile_13_0=(Token)match(input,RULE_STRING,FOLLOW_27); 

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

                    // InternalXtextTest.g:1229:1: ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_STRING) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalXtextTest.g:1230:1: (lv_replacePatterns_14_0= ruleReplacePatterns )
                    	    {
                    	    // InternalXtextTest.g:1230:1: (lv_replacePatterns_14_0= ruleReplacePatterns )
                    	    // InternalXtextTest.g:1231:3: lv_replacePatterns_14_0= ruleReplacePatterns
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getGeneratorAccess().getReplacePatternsReplacePatternsParserRuleCall_3_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_27);
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
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalXtextTest.g:1252:1: (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_EXPECTED) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalXtextTest.g:1253:1: this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) )
                    {
                    this_EXPECTED_15=(Token)match(input,RULE_EXPECTED,FOLLOW_28); 
                     
                        newLeafNode(this_EXPECTED_15, grammarAccess.getGeneratorAccess().getEXPECTEDTerminalRuleCall_4_0()); 
                        
                    this_EXCEPTIONS_16=(Token)match(input,RULE_EXCEPTIONS,FOLLOW_3); 
                     
                        newLeafNode(this_EXCEPTIONS_16, grammarAccess.getGeneratorAccess().getEXCEPTIONSTerminalRuleCall_4_1()); 
                        
                    // InternalXtextTest.g:1267:1: ( (lv_exception_17_0= rulePackageID ) )
                    // InternalXtextTest.g:1268:1: (lv_exception_17_0= rulePackageID )
                    {
                    // InternalXtextTest.g:1268:1: (lv_exception_17_0= rulePackageID )
                    // InternalXtextTest.g:1269:3: lv_exception_17_0= rulePackageID
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
    // InternalXtextTest.g:1299:1: entryRuleReplacePatterns returns [EObject current=null] : iv_ruleReplacePatterns= ruleReplacePatterns EOF ;
    public final EObject entryRuleReplacePatterns() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReplacePatterns = null;


        try {
            // InternalXtextTest.g:1300:2: (iv_ruleReplacePatterns= ruleReplacePatterns EOF )
            // InternalXtextTest.g:1301:2: iv_ruleReplacePatterns= ruleReplacePatterns EOF
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
    // InternalXtextTest.g:1308:1: ruleReplacePatterns returns [EObject current=null] : ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleReplacePatterns() throws RecognitionException {
        EObject current = null;

        Token lv_regex_0_0=null;
        Token this_ASSIGNASSINGLE_1=null;
        Token lv_replace_2_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:1314:7: ( ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) ) )
            // InternalXtextTest.g:1316:1: ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) )
            {
            // InternalXtextTest.g:1316:1: ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) )
            // InternalXtextTest.g:1317:1: ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) )
            {
            // InternalXtextTest.g:1317:1: ( (lv_regex_0_0= RULE_STRING ) )
            // InternalXtextTest.g:1318:1: (lv_regex_0_0= RULE_STRING )
            {
            // InternalXtextTest.g:1318:1: (lv_regex_0_0= RULE_STRING )
            // InternalXtextTest.g:1319:3: lv_regex_0_0= RULE_STRING
            {
            lv_regex_0_0=(Token)match(input,RULE_STRING,FOLLOW_6); 

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

            this_ASSIGNASSINGLE_1=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_14); 
             
                newLeafNode(this_ASSIGNASSINGLE_1, grammarAccess.getReplacePatternsAccess().getASSIGNASSINGLETerminalRuleCall_1()); 
                
            // InternalXtextTest.g:1345:1: ( (lv_replace_2_0= RULE_STRING ) )
            // InternalXtextTest.g:1346:1: (lv_replace_2_0= RULE_STRING )
            {
            // InternalXtextTest.g:1346:1: (lv_replace_2_0= RULE_STRING )
            // InternalXtextTest.g:1347:3: lv_replace_2_0= RULE_STRING
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
    // InternalXtextTest.g:1375:1: entryRuleBefore returns [EObject current=null] : iv_ruleBefore= ruleBefore EOF ;
    public final EObject entryRuleBefore() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBefore = null;


        try {
            // InternalXtextTest.g:1376:2: (iv_ruleBefore= ruleBefore EOF )
            // InternalXtextTest.g:1377:2: iv_ruleBefore= ruleBefore EOF
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
    // InternalXtextTest.g:1384:1: ruleBefore returns [EObject current=null] : (this_BEFORE_KW_0= RULE_BEFORE_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN ) ;
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
            // InternalXtextTest.g:1390:7: ( (this_BEFORE_KW_0= RULE_BEFORE_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:1392:1: (this_BEFORE_KW_0= RULE_BEFORE_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:1392:1: (this_BEFORE_KW_0= RULE_BEFORE_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            // InternalXtextTest.g:1393:1: this_BEFORE_KW_0= RULE_BEFORE_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN
            {
            this_BEFORE_KW_0=(Token)match(input,RULE_BEFORE_KW,FOLLOW_29); 
             
                newLeafNode(this_BEFORE_KW_0, grammarAccess.getBeforeAccess().getBEFORE_KWTerminalRuleCall_0()); 
                
            this_CLASS_KW_1=(Token)match(input,RULE_CLASS_KW,FOLLOW_6); 
             
                newLeafNode(this_CLASS_KW_1, grammarAccess.getBeforeAccess().getCLASS_KWTerminalRuleCall_1()); 
                
            this_ASSIGNASSINGLE_2=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_3); 
             
                newLeafNode(this_ASSIGNASSINGLE_2, grammarAccess.getBeforeAccess().getASSIGNASSINGLETerminalRuleCall_2()); 
                
            // InternalXtextTest.g:1414:1: ( (lv_myclass_3_0= rulePackageID ) )
            // InternalXtextTest.g:1415:1: (lv_myclass_3_0= rulePackageID )
            {
            // InternalXtextTest.g:1415:1: (lv_myclass_3_0= rulePackageID )
            // InternalXtextTest.g:1416:3: lv_myclass_3_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getBeforeAccess().getMyclassPackageIDParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_30);
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

            this_METHOD_KW_4=(Token)match(input,RULE_METHOD_KW,FOLLOW_6); 
             
                newLeafNode(this_METHOD_KW_4, grammarAccess.getBeforeAccess().getMETHOD_KWTerminalRuleCall_4()); 
                
            this_ASSIGNASSINGLE_5=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_3); 
             
                newLeafNode(this_ASSIGNASSINGLE_5, grammarAccess.getBeforeAccess().getASSIGNASSINGLETerminalRuleCall_5()); 
                
            // InternalXtextTest.g:1449:1: ( (lv_method_6_0= rulePackageID ) )
            // InternalXtextTest.g:1450:1: (lv_method_6_0= rulePackageID )
            {
            // InternalXtextTest.g:1450:1: (lv_method_6_0= rulePackageID )
            // InternalXtextTest.g:1451:3: lv_method_6_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getBeforeAccess().getMethodPackageIDParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_31);
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

            this_LEFTPAREN_7=(Token)match(input,RULE_LEFTPAREN,FOLLOW_32); 
             
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
    // InternalXtextTest.g:1493:1: entryRuleAfter returns [EObject current=null] : iv_ruleAfter= ruleAfter EOF ;
    public final EObject entryRuleAfter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAfter = null;


        try {
            // InternalXtextTest.g:1494:2: (iv_ruleAfter= ruleAfter EOF )
            // InternalXtextTest.g:1495:2: iv_ruleAfter= ruleAfter EOF
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
    // InternalXtextTest.g:1502:1: ruleAfter returns [EObject current=null] : (this_AFTER_KW_0= RULE_AFTER_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN ) ;
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
            // InternalXtextTest.g:1508:7: ( (this_AFTER_KW_0= RULE_AFTER_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:1510:1: (this_AFTER_KW_0= RULE_AFTER_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:1510:1: (this_AFTER_KW_0= RULE_AFTER_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            // InternalXtextTest.g:1511:1: this_AFTER_KW_0= RULE_AFTER_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN
            {
            this_AFTER_KW_0=(Token)match(input,RULE_AFTER_KW,FOLLOW_29); 
             
                newLeafNode(this_AFTER_KW_0, grammarAccess.getAfterAccess().getAFTER_KWTerminalRuleCall_0()); 
                
            this_CLASS_KW_1=(Token)match(input,RULE_CLASS_KW,FOLLOW_6); 
             
                newLeafNode(this_CLASS_KW_1, grammarAccess.getAfterAccess().getCLASS_KWTerminalRuleCall_1()); 
                
            this_ASSIGNASSINGLE_2=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_3); 
             
                newLeafNode(this_ASSIGNASSINGLE_2, grammarAccess.getAfterAccess().getASSIGNASSINGLETerminalRuleCall_2()); 
                
            // InternalXtextTest.g:1532:1: ( (lv_myclass_3_0= rulePackageID ) )
            // InternalXtextTest.g:1533:1: (lv_myclass_3_0= rulePackageID )
            {
            // InternalXtextTest.g:1533:1: (lv_myclass_3_0= rulePackageID )
            // InternalXtextTest.g:1534:3: lv_myclass_3_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getAfterAccess().getMyclassPackageIDParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_30);
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

            this_METHOD_KW_4=(Token)match(input,RULE_METHOD_KW,FOLLOW_6); 
             
                newLeafNode(this_METHOD_KW_4, grammarAccess.getAfterAccess().getMETHOD_KWTerminalRuleCall_4()); 
                
            this_ASSIGNASSINGLE_5=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_3); 
             
                newLeafNode(this_ASSIGNASSINGLE_5, grammarAccess.getAfterAccess().getASSIGNASSINGLETerminalRuleCall_5()); 
                
            // InternalXtextTest.g:1567:1: ( (lv_method_6_0= rulePackageID ) )
            // InternalXtextTest.g:1568:1: (lv_method_6_0= rulePackageID )
            {
            // InternalXtextTest.g:1568:1: (lv_method_6_0= rulePackageID )
            // InternalXtextTest.g:1569:3: lv_method_6_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getAfterAccess().getMethodPackageIDParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_31);
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

            this_LEFTPAREN_7=(Token)match(input,RULE_LEFTPAREN,FOLLOW_32); 
             
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000048400002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000048000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000080100L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000308080L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000001000080L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000803002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000801002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000080000L});

}