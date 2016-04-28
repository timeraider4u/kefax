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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_PACKAGE", "RULE_LANGUAGE", "RULE_IMPORTS", "RULE_SPLITLEXER", "RULE_ASSIGNASSINGLE", "RULE_TIMEOUT", "RULE_INT", "RULE_KW_EMFTEST", "RULE_DEFAULT", "RULE_OPTIONS", "RULE_PARAMS", "RULE_SOURCE", "RULE_FILE", "RULE_STRING", "RULE_KW_AS", "RULE_IDENTIFIER", "RULE_TRUE", "RULE_FALSE", "RULE_POINT", "RULE_SRCTEXT", "RULE_LEXER", "RULE_ASSIGNASDATALIST", "RULE_LEFTPAREN", "RULE_IMPORTER", "RULE_COMMA", "RULE_RIGHTPAREN", "RULE_ASSIGNASLIST", "RULE_ASSIGNASSTRING", "RULE_ASSIGNASBOOL", "RULE_ISNULL", "RULE_ISNOTNULL", "RULE_ISEMPTY", "RULE_OUTPUT", "RULE_EXPECTED", "RULE_ISSAMEASINPUTFILE", "RULE_PATTERNS", "RULE_EXCEPTIONS", "RULE_BEFORE_KW", "RULE_AFTER_KW", "RULE_CLASS_KW", "RULE_METHOD_KW", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=45;
    public static final int RULE_IMPORTER=27;
    public static final int RULE_ANY_OTHER=49;
    public static final int RULE_SPLITLEXER=7;
    public static final int RULE_LANGUAGE=5;
    public static final int RULE_ASSIGNASBOOL=32;
    public static final int EOF=-1;
    public static final int RULE_PACKAGE=4;
    public static final int RULE_FALSE=21;
    public static final int RULE_ASSIGNASSINGLE=8;
    public static final int RULE_KW_EMFTEST=11;
    public static final int RULE_ASSIGNASLIST=30;
    public static final int RULE_POINT=22;
    public static final int RULE_PARAMS=14;
    public static final int RULE_INT=10;
    public static final int RULE_CLASS_KW=43;
    public static final int RULE_ASSIGNASSTRING=31;
    public static final int RULE_OPTIONS=13;
    public static final int RULE_ISSAMEASINPUTFILE=38;
    public static final int RULE_TIMEOUT=9;
    public static final int RULE_SRCTEXT=23;
    public static final int RULE_IMPORTS=6;
    public static final int RULE_RIGHTPAREN=29;
    public static final int RULE_METHOD_KW=44;
    public static final int RULE_PATTERNS=39;
    public static final int RULE_ASSIGNASDATALIST=25;
    public static final int RULE_ISNULL=33;
    public static final int RULE_ISEMPTY=35;
    public static final int RULE_EXPECTED=37;
    public static final int RULE_FILE=16;
    public static final int RULE_IDENTIFIER=19;
    public static final int RULE_COMMA=28;
    public static final int RULE_AFTER_KW=42;
    public static final int RULE_SL_COMMENT=47;
    public static final int RULE_ISNOTNULL=34;
    public static final int RULE_DEFAULT=12;
    public static final int RULE_ML_COMMENT=46;
    public static final int RULE_TRUE=20;
    public static final int RULE_BEFORE_KW=41;
    public static final int RULE_STRING=17;
    public static final int RULE_SOURCE=15;
    public static final int RULE_LEFTPAREN=26;
    public static final int RULE_EXCEPTIONS=40;
    public static final int RULE_LEXER=24;
    public static final int RULE_OUTPUT=36;
    public static final int RULE_WS=48;
    public static final int RULE_KW_AS=18;

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
        	return "Model";	
       	}
       	
       	@Override
       	protected XtextTestGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalXtextTest.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalXtextTest.g:69:2: (iv_ruleModel= ruleModel EOF )
            // InternalXtextTest.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalXtextTest.g:77:1: ruleModel returns [EObject current=null] : ( () ( ( (lv_xtextTest_1_0= ruleXtextTest ) ) | ( (lv_emfTest_2_0= ruleEmfTest ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_xtextTest_1_0 = null;

        EObject lv_emfTest_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:83:7: ( ( () ( ( (lv_xtextTest_1_0= ruleXtextTest ) ) | ( (lv_emfTest_2_0= ruleEmfTest ) ) ) ) )
            // InternalXtextTest.g:85:1: ( () ( ( (lv_xtextTest_1_0= ruleXtextTest ) ) | ( (lv_emfTest_2_0= ruleEmfTest ) ) ) )
            {
            // InternalXtextTest.g:85:1: ( () ( ( (lv_xtextTest_1_0= ruleXtextTest ) ) | ( (lv_emfTest_2_0= ruleEmfTest ) ) ) )
            // InternalXtextTest.g:86:1: () ( ( (lv_xtextTest_1_0= ruleXtextTest ) ) | ( (lv_emfTest_2_0= ruleEmfTest ) ) )
            {
            // InternalXtextTest.g:86:1: ()
            // InternalXtextTest.g:87:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

            // InternalXtextTest.g:95:1: ( ( (lv_xtextTest_1_0= ruleXtextTest ) ) | ( (lv_emfTest_2_0= ruleEmfTest ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_PACKAGE) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_KW_EMFTEST) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalXtextTest.g:96:1: ( (lv_xtextTest_1_0= ruleXtextTest ) )
                    {
                    // InternalXtextTest.g:96:1: ( (lv_xtextTest_1_0= ruleXtextTest ) )
                    // InternalXtextTest.g:97:1: (lv_xtextTest_1_0= ruleXtextTest )
                    {
                    // InternalXtextTest.g:97:1: (lv_xtextTest_1_0= ruleXtextTest )
                    // InternalXtextTest.g:98:3: lv_xtextTest_1_0= ruleXtextTest
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getXtextTestXtextTestParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_xtextTest_1_0=ruleXtextTest();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"xtextTest",
                            		lv_xtextTest_1_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.XtextTest");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:118:1: ( (lv_emfTest_2_0= ruleEmfTest ) )
                    {
                    // InternalXtextTest.g:118:1: ( (lv_emfTest_2_0= ruleEmfTest ) )
                    // InternalXtextTest.g:119:1: (lv_emfTest_2_0= ruleEmfTest )
                    {
                    // InternalXtextTest.g:119:1: (lv_emfTest_2_0= ruleEmfTest )
                    // InternalXtextTest.g:120:3: lv_emfTest_2_0= ruleEmfTest
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getEmfTestEmfTestParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_emfTest_2_0=ruleEmfTest();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"emfTest",
                            		lv_emfTest_2_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.EmfTest");
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleXtextTest"
    // InternalXtextTest.g:155:1: entryRuleXtextTest returns [EObject current=null] : iv_ruleXtextTest= ruleXtextTest EOF ;
    public final EObject entryRuleXtextTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXtextTest = null;


        try {
            // InternalXtextTest.g:156:2: (iv_ruleXtextTest= ruleXtextTest EOF )
            // InternalXtextTest.g:157:2: iv_ruleXtextTest= ruleXtextTest EOF
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
    // InternalXtextTest.g:164:1: ruleXtextTest returns [EObject current=null] : ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )? (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )? ( (lv_input_10_0= ruleInput ) ) (this_TIMEOUT_11= RULE_TIMEOUT this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_timeOut_13_0= RULE_INT ) ) )? ( (lv_tokens_14_0= ruleTokens ) )? ( (lv_root_15_0= ruleElement ) ) ( (lv_output_16_0= ruleGenerator ) )? ( (lv_before_17_0= ruleBefore ) )? ( (lv_after_18_0= ruleAfter ) )? ) ;
    public final EObject ruleXtextTest() throws RecognitionException {
        EObject current = null;

        Token this_PACKAGE_1=null;
        Token this_LANGUAGE_3=null;
        Token this_IMPORTS_5=null;
        Token this_SPLITLEXER_7=null;
        Token this_ASSIGNASSINGLE_8=null;
        Token this_TIMEOUT_11=null;
        Token this_ASSIGNASSINGLE_12=null;
        Token lv_timeOut_13_0=null;
        AntlrDatatypeRuleToken lv_package_2_0 = null;

        AntlrDatatypeRuleToken lv_lang_4_0 = null;

        AntlrDatatypeRuleToken lv_imports_6_0 = null;

        AntlrDatatypeRuleToken lv_boolean_9_0 = null;

        EObject lv_input_10_0 = null;

        EObject lv_tokens_14_0 = null;

        EObject lv_root_15_0 = null;

        EObject lv_output_16_0 = null;

        EObject lv_before_17_0 = null;

        EObject lv_after_18_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:170:7: ( ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )? (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )? ( (lv_input_10_0= ruleInput ) ) (this_TIMEOUT_11= RULE_TIMEOUT this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_timeOut_13_0= RULE_INT ) ) )? ( (lv_tokens_14_0= ruleTokens ) )? ( (lv_root_15_0= ruleElement ) ) ( (lv_output_16_0= ruleGenerator ) )? ( (lv_before_17_0= ruleBefore ) )? ( (lv_after_18_0= ruleAfter ) )? ) )
            // InternalXtextTest.g:172:1: ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )? (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )? ( (lv_input_10_0= ruleInput ) ) (this_TIMEOUT_11= RULE_TIMEOUT this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_timeOut_13_0= RULE_INT ) ) )? ( (lv_tokens_14_0= ruleTokens ) )? ( (lv_root_15_0= ruleElement ) ) ( (lv_output_16_0= ruleGenerator ) )? ( (lv_before_17_0= ruleBefore ) )? ( (lv_after_18_0= ruleAfter ) )? )
            {
            // InternalXtextTest.g:172:1: ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )? (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )? ( (lv_input_10_0= ruleInput ) ) (this_TIMEOUT_11= RULE_TIMEOUT this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_timeOut_13_0= RULE_INT ) ) )? ( (lv_tokens_14_0= ruleTokens ) )? ( (lv_root_15_0= ruleElement ) ) ( (lv_output_16_0= ruleGenerator ) )? ( (lv_before_17_0= ruleBefore ) )? ( (lv_after_18_0= ruleAfter ) )? )
            // InternalXtextTest.g:173:1: () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )? (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )? ( (lv_input_10_0= ruleInput ) ) (this_TIMEOUT_11= RULE_TIMEOUT this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_timeOut_13_0= RULE_INT ) ) )? ( (lv_tokens_14_0= ruleTokens ) )? ( (lv_root_15_0= ruleElement ) ) ( (lv_output_16_0= ruleGenerator ) )? ( (lv_before_17_0= ruleBefore ) )? ( (lv_after_18_0= ruleAfter ) )?
            {
            // InternalXtextTest.g:173:1: ()
            // InternalXtextTest.g:174:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getXtextTestAccess().getXtextTestAction_0(),
                        current);
                

            }

            this_PACKAGE_1=(Token)match(input,RULE_PACKAGE,FOLLOW_3); 
             
                newLeafNode(this_PACKAGE_1, grammarAccess.getXtextTestAccess().getPACKAGETerminalRuleCall_1()); 
                
            // InternalXtextTest.g:189:1: ( (lv_package_2_0= rulePackageID ) )
            // InternalXtextTest.g:190:1: (lv_package_2_0= rulePackageID )
            {
            // InternalXtextTest.g:190:1: (lv_package_2_0= rulePackageID )
            // InternalXtextTest.g:191:3: lv_package_2_0= rulePackageID
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
                
            // InternalXtextTest.g:217:1: ( (lv_lang_4_0= ruleLangID ) )
            // InternalXtextTest.g:218:1: (lv_lang_4_0= ruleLangID )
            {
            // InternalXtextTest.g:218:1: (lv_lang_4_0= ruleLangID )
            // InternalXtextTest.g:219:3: lv_lang_4_0= ruleLangID
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

            // InternalXtextTest.g:238:1: (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_IMPORTS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalXtextTest.g:239:1: this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) )
                    {
                    this_IMPORTS_5=(Token)match(input,RULE_IMPORTS,FOLLOW_3); 
                     
                        newLeafNode(this_IMPORTS_5, grammarAccess.getXtextTestAccess().getIMPORTSTerminalRuleCall_5_0()); 
                        
                    // InternalXtextTest.g:246:1: ( (lv_imports_6_0= ruleImportID ) )
                    // InternalXtextTest.g:247:1: (lv_imports_6_0= ruleImportID )
                    {
                    // InternalXtextTest.g:247:1: (lv_imports_6_0= ruleImportID )
                    // InternalXtextTest.g:248:3: lv_imports_6_0= ruleImportID
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getImportsImportIDParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_imports_6_0=ruleImportID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"imports",
                            		lv_imports_6_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.ImportID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalXtextTest.g:269:1: (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_SPLITLEXER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalXtextTest.g:270:1: this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) )
                    {
                    this_SPLITLEXER_7=(Token)match(input,RULE_SPLITLEXER,FOLLOW_6); 
                     
                        newLeafNode(this_SPLITLEXER_7, grammarAccess.getXtextTestAccess().getSPLITLEXERTerminalRuleCall_6_0()); 
                        
                    this_ASSIGNASSINGLE_8=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_7); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_8, grammarAccess.getXtextTestAccess().getASSIGNASSINGLETerminalRuleCall_6_1()); 
                        
                    // InternalXtextTest.g:284:1: ( (lv_boolean_9_0= ruleBoolean ) )
                    // InternalXtextTest.g:285:1: (lv_boolean_9_0= ruleBoolean )
                    {
                    // InternalXtextTest.g:285:1: (lv_boolean_9_0= ruleBoolean )
                    // InternalXtextTest.g:286:3: lv_boolean_9_0= ruleBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getBooleanBooleanParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_boolean_9_0=ruleBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"boolean",
                            		lv_boolean_9_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Boolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalXtextTest.g:307:1: ( (lv_input_10_0= ruleInput ) )
            // InternalXtextTest.g:308:1: (lv_input_10_0= ruleInput )
            {
            // InternalXtextTest.g:308:1: (lv_input_10_0= ruleInput )
            // InternalXtextTest.g:309:3: lv_input_10_0= ruleInput
            {
             
            	        newCompositeNode(grammarAccess.getXtextTestAccess().getInputInputParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_8);
            lv_input_10_0=ruleInput();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
            	        }
                   		set(
                   			current, 
                   			"input",
                    		lv_input_10_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.Input");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalXtextTest.g:328:1: (this_TIMEOUT_11= RULE_TIMEOUT this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_timeOut_13_0= RULE_INT ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_TIMEOUT) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalXtextTest.g:329:1: this_TIMEOUT_11= RULE_TIMEOUT this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_timeOut_13_0= RULE_INT ) )
                    {
                    this_TIMEOUT_11=(Token)match(input,RULE_TIMEOUT,FOLLOW_6); 
                     
                        newLeafNode(this_TIMEOUT_11, grammarAccess.getXtextTestAccess().getTIMEOUTTerminalRuleCall_8_0()); 
                        
                    this_ASSIGNASSINGLE_12=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_9); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_12, grammarAccess.getXtextTestAccess().getASSIGNASSINGLETerminalRuleCall_8_1()); 
                        
                    // InternalXtextTest.g:343:1: ( (lv_timeOut_13_0= RULE_INT ) )
                    // InternalXtextTest.g:344:1: (lv_timeOut_13_0= RULE_INT )
                    {
                    // InternalXtextTest.g:344:1: (lv_timeOut_13_0= RULE_INT )
                    // InternalXtextTest.g:345:3: lv_timeOut_13_0= RULE_INT
                    {
                    lv_timeOut_13_0=(Token)match(input,RULE_INT,FOLLOW_8); 

                    			newLeafNode(lv_timeOut_13_0, grammarAccess.getXtextTestAccess().getTimeOutINTTerminalRuleCall_8_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getXtextTestRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"timeOut",
                            		lv_timeOut_13_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalXtextTest.g:366:1: ( (lv_tokens_14_0= ruleTokens ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_LEXER) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalXtextTest.g:367:1: (lv_tokens_14_0= ruleTokens )
                    {
                    // InternalXtextTest.g:367:1: (lv_tokens_14_0= ruleTokens )
                    // InternalXtextTest.g:368:3: lv_tokens_14_0= ruleTokens
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getTokensTokensParserRuleCall_9_0()); 
                    	    
                    pushFollow(FOLLOW_8);
                    lv_tokens_14_0=ruleTokens();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"tokens",
                            		lv_tokens_14_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Tokens");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalXtextTest.g:387:1: ( (lv_root_15_0= ruleElement ) )
            // InternalXtextTest.g:388:1: (lv_root_15_0= ruleElement )
            {
            // InternalXtextTest.g:388:1: (lv_root_15_0= ruleElement )
            // InternalXtextTest.g:389:3: lv_root_15_0= ruleElement
            {
             
            	        newCompositeNode(grammarAccess.getXtextTestAccess().getRootElementParserRuleCall_10_0()); 
            	    
            pushFollow(FOLLOW_10);
            lv_root_15_0=ruleElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
            	        }
                   		set(
                   			current, 
                   			"root",
                    		lv_root_15_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.Element");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalXtextTest.g:408:1: ( (lv_output_16_0= ruleGenerator ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_OUTPUT) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalXtextTest.g:409:1: (lv_output_16_0= ruleGenerator )
                    {
                    // InternalXtextTest.g:409:1: (lv_output_16_0= ruleGenerator )
                    // InternalXtextTest.g:410:3: lv_output_16_0= ruleGenerator
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getOutputGeneratorParserRuleCall_11_0()); 
                    	    
                    pushFollow(FOLLOW_11);
                    lv_output_16_0=ruleGenerator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"output",
                            		lv_output_16_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Generator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalXtextTest.g:429:1: ( (lv_before_17_0= ruleBefore ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_BEFORE_KW) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalXtextTest.g:430:1: (lv_before_17_0= ruleBefore )
                    {
                    // InternalXtextTest.g:430:1: (lv_before_17_0= ruleBefore )
                    // InternalXtextTest.g:431:3: lv_before_17_0= ruleBefore
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getBeforeBeforeParserRuleCall_12_0()); 
                    	    
                    pushFollow(FOLLOW_12);
                    lv_before_17_0=ruleBefore();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"before",
                            		lv_before_17_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Before");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalXtextTest.g:450:1: ( (lv_after_18_0= ruleAfter ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_AFTER_KW) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalXtextTest.g:451:1: (lv_after_18_0= ruleAfter )
                    {
                    // InternalXtextTest.g:451:1: (lv_after_18_0= ruleAfter )
                    // InternalXtextTest.g:452:3: lv_after_18_0= ruleAfter
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getAfterAfterParserRuleCall_13_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_after_18_0=ruleAfter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"after",
                            		lv_after_18_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.After");
                    	        afterParserOrEnumRuleCall();
                    	    

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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleXtextTest"


    // $ANTLR start "entryRuleEmfTest"
    // InternalXtextTest.g:485:1: entryRuleEmfTest returns [EObject current=null] : iv_ruleEmfTest= ruleEmfTest EOF ;
    public final EObject entryRuleEmfTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmfTest = null;


        try {
            // InternalXtextTest.g:486:2: (iv_ruleEmfTest= ruleEmfTest EOF )
            // InternalXtextTest.g:487:2: iv_ruleEmfTest= ruleEmfTest EOF
            {
             newCompositeNode(grammarAccess.getEmfTestRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEmfTest=ruleEmfTest();

            state._fsp--;

             current =iv_ruleEmfTest; 
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
    // $ANTLR end "entryRuleEmfTest"


    // $ANTLR start "ruleEmfTest"
    // InternalXtextTest.g:494:1: ruleEmfTest returns [EObject current=null] : ( () this_KW_EMFTEST_1= RULE_KW_EMFTEST this_PACKAGE_2= RULE_PACKAGE ( (lv_package_3_0= rulePackageID ) ) this_DEFAULT_4= RULE_DEFAULT ( (lv_mydefault_5_0= rulePackageID ) ) ( (lv_myimport_6_0= ruleImport ) )* (this_TIMEOUT_7= RULE_TIMEOUT this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_timeOut_9_0= RULE_INT ) ) )? ( (lv_codeCall_10_0= ruleCodeCall ) ) (this_OPTIONS_11= RULE_OPTIONS ( (lv_optionCall_12_0= ruleCodeCall ) ) )? (this_PARAMS_13= RULE_PARAMS ( (lv_paramCall_14_0= ruleCodeCall ) ) )? (this_SOURCE_15= RULE_SOURCE this_FILE_16= RULE_FILE this_ASSIGNASSINGLE_17= RULE_ASSIGNASSINGLE ( (lv_file_18_0= RULE_STRING ) ) ) ( (lv_root_19_0= ruleElement ) ) ( (lv_before_20_0= ruleBefore ) )? ( (lv_after_21_0= ruleAfter ) )? ) ;
    public final EObject ruleEmfTest() throws RecognitionException {
        EObject current = null;

        Token this_KW_EMFTEST_1=null;
        Token this_PACKAGE_2=null;
        Token this_DEFAULT_4=null;
        Token this_TIMEOUT_7=null;
        Token this_ASSIGNASSINGLE_8=null;
        Token lv_timeOut_9_0=null;
        Token this_OPTIONS_11=null;
        Token this_PARAMS_13=null;
        Token this_SOURCE_15=null;
        Token this_FILE_16=null;
        Token this_ASSIGNASSINGLE_17=null;
        Token lv_file_18_0=null;
        AntlrDatatypeRuleToken lv_package_3_0 = null;

        AntlrDatatypeRuleToken lv_mydefault_5_0 = null;

        EObject lv_myimport_6_0 = null;

        EObject lv_codeCall_10_0 = null;

        EObject lv_optionCall_12_0 = null;

        EObject lv_paramCall_14_0 = null;

        EObject lv_root_19_0 = null;

        EObject lv_before_20_0 = null;

        EObject lv_after_21_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:500:7: ( ( () this_KW_EMFTEST_1= RULE_KW_EMFTEST this_PACKAGE_2= RULE_PACKAGE ( (lv_package_3_0= rulePackageID ) ) this_DEFAULT_4= RULE_DEFAULT ( (lv_mydefault_5_0= rulePackageID ) ) ( (lv_myimport_6_0= ruleImport ) )* (this_TIMEOUT_7= RULE_TIMEOUT this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_timeOut_9_0= RULE_INT ) ) )? ( (lv_codeCall_10_0= ruleCodeCall ) ) (this_OPTIONS_11= RULE_OPTIONS ( (lv_optionCall_12_0= ruleCodeCall ) ) )? (this_PARAMS_13= RULE_PARAMS ( (lv_paramCall_14_0= ruleCodeCall ) ) )? (this_SOURCE_15= RULE_SOURCE this_FILE_16= RULE_FILE this_ASSIGNASSINGLE_17= RULE_ASSIGNASSINGLE ( (lv_file_18_0= RULE_STRING ) ) ) ( (lv_root_19_0= ruleElement ) ) ( (lv_before_20_0= ruleBefore ) )? ( (lv_after_21_0= ruleAfter ) )? ) )
            // InternalXtextTest.g:502:1: ( () this_KW_EMFTEST_1= RULE_KW_EMFTEST this_PACKAGE_2= RULE_PACKAGE ( (lv_package_3_0= rulePackageID ) ) this_DEFAULT_4= RULE_DEFAULT ( (lv_mydefault_5_0= rulePackageID ) ) ( (lv_myimport_6_0= ruleImport ) )* (this_TIMEOUT_7= RULE_TIMEOUT this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_timeOut_9_0= RULE_INT ) ) )? ( (lv_codeCall_10_0= ruleCodeCall ) ) (this_OPTIONS_11= RULE_OPTIONS ( (lv_optionCall_12_0= ruleCodeCall ) ) )? (this_PARAMS_13= RULE_PARAMS ( (lv_paramCall_14_0= ruleCodeCall ) ) )? (this_SOURCE_15= RULE_SOURCE this_FILE_16= RULE_FILE this_ASSIGNASSINGLE_17= RULE_ASSIGNASSINGLE ( (lv_file_18_0= RULE_STRING ) ) ) ( (lv_root_19_0= ruleElement ) ) ( (lv_before_20_0= ruleBefore ) )? ( (lv_after_21_0= ruleAfter ) )? )
            {
            // InternalXtextTest.g:502:1: ( () this_KW_EMFTEST_1= RULE_KW_EMFTEST this_PACKAGE_2= RULE_PACKAGE ( (lv_package_3_0= rulePackageID ) ) this_DEFAULT_4= RULE_DEFAULT ( (lv_mydefault_5_0= rulePackageID ) ) ( (lv_myimport_6_0= ruleImport ) )* (this_TIMEOUT_7= RULE_TIMEOUT this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_timeOut_9_0= RULE_INT ) ) )? ( (lv_codeCall_10_0= ruleCodeCall ) ) (this_OPTIONS_11= RULE_OPTIONS ( (lv_optionCall_12_0= ruleCodeCall ) ) )? (this_PARAMS_13= RULE_PARAMS ( (lv_paramCall_14_0= ruleCodeCall ) ) )? (this_SOURCE_15= RULE_SOURCE this_FILE_16= RULE_FILE this_ASSIGNASSINGLE_17= RULE_ASSIGNASSINGLE ( (lv_file_18_0= RULE_STRING ) ) ) ( (lv_root_19_0= ruleElement ) ) ( (lv_before_20_0= ruleBefore ) )? ( (lv_after_21_0= ruleAfter ) )? )
            // InternalXtextTest.g:503:1: () this_KW_EMFTEST_1= RULE_KW_EMFTEST this_PACKAGE_2= RULE_PACKAGE ( (lv_package_3_0= rulePackageID ) ) this_DEFAULT_4= RULE_DEFAULT ( (lv_mydefault_5_0= rulePackageID ) ) ( (lv_myimport_6_0= ruleImport ) )* (this_TIMEOUT_7= RULE_TIMEOUT this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_timeOut_9_0= RULE_INT ) ) )? ( (lv_codeCall_10_0= ruleCodeCall ) ) (this_OPTIONS_11= RULE_OPTIONS ( (lv_optionCall_12_0= ruleCodeCall ) ) )? (this_PARAMS_13= RULE_PARAMS ( (lv_paramCall_14_0= ruleCodeCall ) ) )? (this_SOURCE_15= RULE_SOURCE this_FILE_16= RULE_FILE this_ASSIGNASSINGLE_17= RULE_ASSIGNASSINGLE ( (lv_file_18_0= RULE_STRING ) ) ) ( (lv_root_19_0= ruleElement ) ) ( (lv_before_20_0= ruleBefore ) )? ( (lv_after_21_0= ruleAfter ) )?
            {
            // InternalXtextTest.g:503:1: ()
            // InternalXtextTest.g:504:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEmfTestAccess().getEmfTestAction_0(),
                        current);
                

            }

            this_KW_EMFTEST_1=(Token)match(input,RULE_KW_EMFTEST,FOLLOW_13); 
             
                newLeafNode(this_KW_EMFTEST_1, grammarAccess.getEmfTestAccess().getKW_EMFTESTTerminalRuleCall_1()); 
                
            this_PACKAGE_2=(Token)match(input,RULE_PACKAGE,FOLLOW_3); 
             
                newLeafNode(this_PACKAGE_2, grammarAccess.getEmfTestAccess().getPACKAGETerminalRuleCall_2()); 
                
            // InternalXtextTest.g:526:1: ( (lv_package_3_0= rulePackageID ) )
            // InternalXtextTest.g:527:1: (lv_package_3_0= rulePackageID )
            {
            // InternalXtextTest.g:527:1: (lv_package_3_0= rulePackageID )
            // InternalXtextTest.g:528:3: lv_package_3_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getEmfTestAccess().getPackagePackageIDParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_14);
            lv_package_3_0=rulePackageID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEmfTestRule());
            	        }
                   		set(
                   			current, 
                   			"package",
                    		lv_package_3_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.PackageID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_DEFAULT_4=(Token)match(input,RULE_DEFAULT,FOLLOW_3); 
             
                newLeafNode(this_DEFAULT_4, grammarAccess.getEmfTestAccess().getDEFAULTTerminalRuleCall_4()); 
                
            // InternalXtextTest.g:554:1: ( (lv_mydefault_5_0= rulePackageID ) )
            // InternalXtextTest.g:555:1: (lv_mydefault_5_0= rulePackageID )
            {
            // InternalXtextTest.g:555:1: (lv_mydefault_5_0= rulePackageID )
            // InternalXtextTest.g:556:3: lv_mydefault_5_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getEmfTestAccess().getMydefaultPackageIDParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_15);
            lv_mydefault_5_0=rulePackageID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEmfTestRule());
            	        }
                   		set(
                   			current, 
                   			"mydefault",
                    		lv_mydefault_5_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.PackageID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalXtextTest.g:575:1: ( (lv_myimport_6_0= ruleImport ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_IMPORTS) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalXtextTest.g:576:1: (lv_myimport_6_0= ruleImport )
            	    {
            	    // InternalXtextTest.g:576:1: (lv_myimport_6_0= ruleImport )
            	    // InternalXtextTest.g:577:3: lv_myimport_6_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEmfTestAccess().getMyimportImportParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_15);
            	    lv_myimport_6_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEmfTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"myimport",
            	            		lv_myimport_6_0, 
            	            		"at.jku.weiner.xtexttest.XtextTest.Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // InternalXtextTest.g:596:1: (this_TIMEOUT_7= RULE_TIMEOUT this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_timeOut_9_0= RULE_INT ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_TIMEOUT) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalXtextTest.g:597:1: this_TIMEOUT_7= RULE_TIMEOUT this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_timeOut_9_0= RULE_INT ) )
                    {
                    this_TIMEOUT_7=(Token)match(input,RULE_TIMEOUT,FOLLOW_6); 
                     
                        newLeafNode(this_TIMEOUT_7, grammarAccess.getEmfTestAccess().getTIMEOUTTerminalRuleCall_7_0()); 
                        
                    this_ASSIGNASSINGLE_8=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_9); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_8, grammarAccess.getEmfTestAccess().getASSIGNASSINGLETerminalRuleCall_7_1()); 
                        
                    // InternalXtextTest.g:611:1: ( (lv_timeOut_9_0= RULE_INT ) )
                    // InternalXtextTest.g:612:1: (lv_timeOut_9_0= RULE_INT )
                    {
                    // InternalXtextTest.g:612:1: (lv_timeOut_9_0= RULE_INT )
                    // InternalXtextTest.g:613:3: lv_timeOut_9_0= RULE_INT
                    {
                    lv_timeOut_9_0=(Token)match(input,RULE_INT,FOLLOW_15); 

                    			newLeafNode(lv_timeOut_9_0, grammarAccess.getEmfTestAccess().getTimeOutINTTerminalRuleCall_7_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEmfTestRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"timeOut",
                            		lv_timeOut_9_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalXtextTest.g:634:1: ( (lv_codeCall_10_0= ruleCodeCall ) )
            // InternalXtextTest.g:635:1: (lv_codeCall_10_0= ruleCodeCall )
            {
            // InternalXtextTest.g:635:1: (lv_codeCall_10_0= ruleCodeCall )
            // InternalXtextTest.g:636:3: lv_codeCall_10_0= ruleCodeCall
            {
             
            	        newCompositeNode(grammarAccess.getEmfTestAccess().getCodeCallCodeCallParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_16);
            lv_codeCall_10_0=ruleCodeCall();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEmfTestRule());
            	        }
                   		set(
                   			current, 
                   			"codeCall",
                    		lv_codeCall_10_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.CodeCall");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalXtextTest.g:655:1: (this_OPTIONS_11= RULE_OPTIONS ( (lv_optionCall_12_0= ruleCodeCall ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_OPTIONS) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalXtextTest.g:656:1: this_OPTIONS_11= RULE_OPTIONS ( (lv_optionCall_12_0= ruleCodeCall ) )
                    {
                    this_OPTIONS_11=(Token)match(input,RULE_OPTIONS,FOLLOW_15); 
                     
                        newLeafNode(this_OPTIONS_11, grammarAccess.getEmfTestAccess().getOPTIONSTerminalRuleCall_9_0()); 
                        
                    // InternalXtextTest.g:663:1: ( (lv_optionCall_12_0= ruleCodeCall ) )
                    // InternalXtextTest.g:664:1: (lv_optionCall_12_0= ruleCodeCall )
                    {
                    // InternalXtextTest.g:664:1: (lv_optionCall_12_0= ruleCodeCall )
                    // InternalXtextTest.g:665:3: lv_optionCall_12_0= ruleCodeCall
                    {
                     
                    	        newCompositeNode(grammarAccess.getEmfTestAccess().getOptionCallCodeCallParserRuleCall_9_1_0()); 
                    	    
                    pushFollow(FOLLOW_17);
                    lv_optionCall_12_0=ruleCodeCall();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEmfTestRule());
                    	        }
                           		set(
                           			current, 
                           			"optionCall",
                            		lv_optionCall_12_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.CodeCall");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalXtextTest.g:686:1: (this_PARAMS_13= RULE_PARAMS ( (lv_paramCall_14_0= ruleCodeCall ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_PARAMS) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalXtextTest.g:687:1: this_PARAMS_13= RULE_PARAMS ( (lv_paramCall_14_0= ruleCodeCall ) )
                    {
                    this_PARAMS_13=(Token)match(input,RULE_PARAMS,FOLLOW_15); 
                     
                        newLeafNode(this_PARAMS_13, grammarAccess.getEmfTestAccess().getPARAMSTerminalRuleCall_10_0()); 
                        
                    // InternalXtextTest.g:694:1: ( (lv_paramCall_14_0= ruleCodeCall ) )
                    // InternalXtextTest.g:695:1: (lv_paramCall_14_0= ruleCodeCall )
                    {
                    // InternalXtextTest.g:695:1: (lv_paramCall_14_0= ruleCodeCall )
                    // InternalXtextTest.g:696:3: lv_paramCall_14_0= ruleCodeCall
                    {
                     
                    	        newCompositeNode(grammarAccess.getEmfTestAccess().getParamCallCodeCallParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_18);
                    lv_paramCall_14_0=ruleCodeCall();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEmfTestRule());
                    	        }
                           		set(
                           			current, 
                           			"paramCall",
                            		lv_paramCall_14_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.CodeCall");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalXtextTest.g:717:1: (this_SOURCE_15= RULE_SOURCE this_FILE_16= RULE_FILE this_ASSIGNASSINGLE_17= RULE_ASSIGNASSINGLE ( (lv_file_18_0= RULE_STRING ) ) )
            // InternalXtextTest.g:718:1: this_SOURCE_15= RULE_SOURCE this_FILE_16= RULE_FILE this_ASSIGNASSINGLE_17= RULE_ASSIGNASSINGLE ( (lv_file_18_0= RULE_STRING ) )
            {
            this_SOURCE_15=(Token)match(input,RULE_SOURCE,FOLLOW_19); 
             
                newLeafNode(this_SOURCE_15, grammarAccess.getEmfTestAccess().getSOURCETerminalRuleCall_11_0()); 
                
            this_FILE_16=(Token)match(input,RULE_FILE,FOLLOW_6); 
             
                newLeafNode(this_FILE_16, grammarAccess.getEmfTestAccess().getFILETerminalRuleCall_11_1()); 
                
            this_ASSIGNASSINGLE_17=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_20); 
             
                newLeafNode(this_ASSIGNASSINGLE_17, grammarAccess.getEmfTestAccess().getASSIGNASSINGLETerminalRuleCall_11_2()); 
                
            // InternalXtextTest.g:739:1: ( (lv_file_18_0= RULE_STRING ) )
            // InternalXtextTest.g:740:1: (lv_file_18_0= RULE_STRING )
            {
            // InternalXtextTest.g:740:1: (lv_file_18_0= RULE_STRING )
            // InternalXtextTest.g:741:3: lv_file_18_0= RULE_STRING
            {
            lv_file_18_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            			newLeafNode(lv_file_18_0, grammarAccess.getEmfTestAccess().getFileSTRINGTerminalRuleCall_11_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEmfTestRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"file",
                    		lv_file_18_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }


            }

            // InternalXtextTest.g:762:1: ( (lv_root_19_0= ruleElement ) )
            // InternalXtextTest.g:763:1: (lv_root_19_0= ruleElement )
            {
            // InternalXtextTest.g:763:1: (lv_root_19_0= ruleElement )
            // InternalXtextTest.g:764:3: lv_root_19_0= ruleElement
            {
             
            	        newCompositeNode(grammarAccess.getEmfTestAccess().getRootElementParserRuleCall_12_0()); 
            	    
            pushFollow(FOLLOW_11);
            lv_root_19_0=ruleElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEmfTestRule());
            	        }
                   		set(
                   			current, 
                   			"root",
                    		lv_root_19_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.Element");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalXtextTest.g:783:1: ( (lv_before_20_0= ruleBefore ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_BEFORE_KW) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalXtextTest.g:784:1: (lv_before_20_0= ruleBefore )
                    {
                    // InternalXtextTest.g:784:1: (lv_before_20_0= ruleBefore )
                    // InternalXtextTest.g:785:3: lv_before_20_0= ruleBefore
                    {
                     
                    	        newCompositeNode(grammarAccess.getEmfTestAccess().getBeforeBeforeParserRuleCall_13_0()); 
                    	    
                    pushFollow(FOLLOW_12);
                    lv_before_20_0=ruleBefore();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEmfTestRule());
                    	        }
                           		set(
                           			current, 
                           			"before",
                            		lv_before_20_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Before");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalXtextTest.g:804:1: ( (lv_after_21_0= ruleAfter ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_AFTER_KW) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalXtextTest.g:805:1: (lv_after_21_0= ruleAfter )
                    {
                    // InternalXtextTest.g:805:1: (lv_after_21_0= ruleAfter )
                    // InternalXtextTest.g:806:3: lv_after_21_0= ruleAfter
                    {
                     
                    	        newCompositeNode(grammarAccess.getEmfTestAccess().getAfterAfterParserRuleCall_14_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_after_21_0=ruleAfter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEmfTestRule());
                    	        }
                           		set(
                           			current, 
                           			"after",
                            		lv_after_21_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.After");
                    	        afterParserOrEnumRuleCall();
                    	    

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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleEmfTest"


    // $ANTLR start "entryRuleImport"
    // InternalXtextTest.g:839:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalXtextTest.g:840:2: (iv_ruleImport= ruleImport EOF )
            // InternalXtextTest.g:841:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalXtextTest.g:848:1: ruleImport returns [EObject current=null] : ( () this_IMPORTS_1= RULE_IMPORTS ( (lv_id_2_0= ruleImportID ) ) this_KW_AS_3= RULE_KW_AS ( (lv_alias_4_0= RULE_IDENTIFIER ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token this_IMPORTS_1=null;
        Token this_KW_AS_3=null;
        Token lv_alias_4_0=null;
        AntlrDatatypeRuleToken lv_id_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:854:7: ( ( () this_IMPORTS_1= RULE_IMPORTS ( (lv_id_2_0= ruleImportID ) ) this_KW_AS_3= RULE_KW_AS ( (lv_alias_4_0= RULE_IDENTIFIER ) ) ) )
            // InternalXtextTest.g:856:1: ( () this_IMPORTS_1= RULE_IMPORTS ( (lv_id_2_0= ruleImportID ) ) this_KW_AS_3= RULE_KW_AS ( (lv_alias_4_0= RULE_IDENTIFIER ) ) )
            {
            // InternalXtextTest.g:856:1: ( () this_IMPORTS_1= RULE_IMPORTS ( (lv_id_2_0= ruleImportID ) ) this_KW_AS_3= RULE_KW_AS ( (lv_alias_4_0= RULE_IDENTIFIER ) ) )
            // InternalXtextTest.g:857:1: () this_IMPORTS_1= RULE_IMPORTS ( (lv_id_2_0= ruleImportID ) ) this_KW_AS_3= RULE_KW_AS ( (lv_alias_4_0= RULE_IDENTIFIER ) )
            {
            // InternalXtextTest.g:857:1: ()
            // InternalXtextTest.g:858:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getImportAccess().getImportAction_0(),
                        current);
                

            }

            this_IMPORTS_1=(Token)match(input,RULE_IMPORTS,FOLLOW_3); 
             
                newLeafNode(this_IMPORTS_1, grammarAccess.getImportAccess().getIMPORTSTerminalRuleCall_1()); 
                
            // InternalXtextTest.g:873:1: ( (lv_id_2_0= ruleImportID ) )
            // InternalXtextTest.g:874:1: (lv_id_2_0= ruleImportID )
            {
            // InternalXtextTest.g:874:1: (lv_id_2_0= ruleImportID )
            // InternalXtextTest.g:875:3: lv_id_2_0= ruleImportID
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getIdImportIDParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_21);
            lv_id_2_0=ruleImportID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getImportRule());
            	        }
                   		set(
                   			current, 
                   			"id",
                    		lv_id_2_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.ImportID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_KW_AS_3=(Token)match(input,RULE_KW_AS,FOLLOW_3); 
             
                newLeafNode(this_KW_AS_3, grammarAccess.getImportAccess().getKW_ASTerminalRuleCall_3()); 
                
            // InternalXtextTest.g:901:1: ( (lv_alias_4_0= RULE_IDENTIFIER ) )
            // InternalXtextTest.g:902:1: (lv_alias_4_0= RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:902:1: (lv_alias_4_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:903:3: lv_alias_4_0= RULE_IDENTIFIER
            {
            lv_alias_4_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_2); 

            			newLeafNode(lv_alias_4_0, grammarAccess.getImportAccess().getAliasIDENTIFIERTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getImportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"alias",
                    		lv_alias_4_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.IDENTIFIER");
            	    

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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleBoolean"
    // InternalXtextTest.g:936:1: entryRuleBoolean returns [String current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final String entryRuleBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBoolean = null;


        try {
            // InternalXtextTest.g:937:2: (iv_ruleBoolean= ruleBoolean EOF )
            // InternalXtextTest.g:938:2: iv_ruleBoolean= ruleBoolean EOF
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
    // InternalXtextTest.g:945:1: ruleBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_TRUE_0= RULE_TRUE | this_FALSE_1= RULE_FALSE ) ;
    public final AntlrDatatypeRuleToken ruleBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_TRUE_0=null;
        Token this_FALSE_1=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:948:28: ( (this_TRUE_0= RULE_TRUE | this_FALSE_1= RULE_FALSE ) )
            // InternalXtextTest.g:949:1: (this_TRUE_0= RULE_TRUE | this_FALSE_1= RULE_FALSE )
            {
            // InternalXtextTest.g:949:1: (this_TRUE_0= RULE_TRUE | this_FALSE_1= RULE_FALSE )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_TRUE) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_FALSE) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalXtextTest.g:949:6: this_TRUE_0= RULE_TRUE
                    {
                    this_TRUE_0=(Token)match(input,RULE_TRUE,FOLLOW_2); 

                    		current.merge(this_TRUE_0);
                        
                     
                        newLeafNode(this_TRUE_0, grammarAccess.getBooleanAccess().getTRUETerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:957:10: this_FALSE_1= RULE_FALSE
                    {
                    this_FALSE_1=(Token)match(input,RULE_FALSE,FOLLOW_2); 

                    		current.merge(this_FALSE_1);
                        
                     
                        newLeafNode(this_FALSE_1, grammarAccess.getBooleanAccess().getFALSETerminalRuleCall_1()); 
                        

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
    // InternalXtextTest.g:972:1: entryRulePackageID returns [String current=null] : iv_rulePackageID= rulePackageID EOF ;
    public final String entryRulePackageID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePackageID = null;


        try {
            // InternalXtextTest.g:973:2: (iv_rulePackageID= rulePackageID EOF )
            // InternalXtextTest.g:974:2: iv_rulePackageID= rulePackageID EOF
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
    // InternalXtextTest.g:981:1: rulePackageID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* ) ;
    public final AntlrDatatypeRuleToken rulePackageID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IDENTIFIER_0=null;
        Token this_POINT_1=null;
        Token this_IDENTIFIER_2=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:984:28: ( (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* ) )
            // InternalXtextTest.g:985:1: (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* )
            {
            // InternalXtextTest.g:985:1: (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* )
            // InternalXtextTest.g:985:6: this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )*
            {
            this_IDENTIFIER_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_22); 

            		current.merge(this_IDENTIFIER_0);
                
             
                newLeafNode(this_IDENTIFIER_0, grammarAccess.getPackageIDAccess().getIDENTIFIERTerminalRuleCall_0()); 
                
            // InternalXtextTest.g:992:1: (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_POINT) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalXtextTest.g:992:6: this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER
            	    {
            	    this_POINT_1=(Token)match(input,RULE_POINT,FOLLOW_3); 

            	    		current.merge(this_POINT_1);
            	        
            	     
            	        newLeafNode(this_POINT_1, grammarAccess.getPackageIDAccess().getPOINTTerminalRuleCall_1_0()); 
            	        
            	    this_IDENTIFIER_2=(Token)match(input,RULE_IDENTIFIER,FOLLOW_22); 

            	    		current.merge(this_IDENTIFIER_2);
            	        
            	     
            	        newLeafNode(this_IDENTIFIER_2, grammarAccess.getPackageIDAccess().getIDENTIFIERTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalXtextTest.g:1014:1: entryRuleLangID returns [String current=null] : iv_ruleLangID= ruleLangID EOF ;
    public final String entryRuleLangID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLangID = null;


        try {
            // InternalXtextTest.g:1015:2: (iv_ruleLangID= ruleLangID EOF )
            // InternalXtextTest.g:1016:2: iv_ruleLangID= ruleLangID EOF
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
    // InternalXtextTest.g:1023:1: ruleLangID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_IDENTIFIER_0= RULE_IDENTIFIER ;
    public final AntlrDatatypeRuleToken ruleLangID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IDENTIFIER_0=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:1026:28: (this_IDENTIFIER_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:1027:5: this_IDENTIFIER_0= RULE_IDENTIFIER
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


    // $ANTLR start "entryRuleImportID"
    // InternalXtextTest.g:1042:1: entryRuleImportID returns [String current=null] : iv_ruleImportID= ruleImportID EOF ;
    public final String entryRuleImportID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportID = null;


        try {
            // InternalXtextTest.g:1043:2: (iv_ruleImportID= ruleImportID EOF )
            // InternalXtextTest.g:1044:2: iv_ruleImportID= ruleImportID EOF
            {
             newCompositeNode(grammarAccess.getImportIDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImportID=ruleImportID();

            state._fsp--;

             current =iv_ruleImportID.getText(); 
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
    // $ANTLR end "entryRuleImportID"


    // $ANTLR start "ruleImportID"
    // InternalXtextTest.g:1051:1: ruleImportID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* ) ;
    public final AntlrDatatypeRuleToken ruleImportID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IDENTIFIER_0=null;
        Token this_POINT_1=null;
        Token this_IDENTIFIER_2=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:1054:28: ( (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* ) )
            // InternalXtextTest.g:1055:1: (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* )
            {
            // InternalXtextTest.g:1055:1: (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* )
            // InternalXtextTest.g:1055:6: this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )*
            {
            this_IDENTIFIER_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_22); 

            		current.merge(this_IDENTIFIER_0);
                
             
                newLeafNode(this_IDENTIFIER_0, grammarAccess.getImportIDAccess().getIDENTIFIERTerminalRuleCall_0()); 
                
            // InternalXtextTest.g:1062:1: (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_POINT) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalXtextTest.g:1062:6: this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER
            	    {
            	    this_POINT_1=(Token)match(input,RULE_POINT,FOLLOW_3); 

            	    		current.merge(this_POINT_1);
            	        
            	     
            	        newLeafNode(this_POINT_1, grammarAccess.getImportIDAccess().getPOINTTerminalRuleCall_1_0()); 
            	        
            	    this_IDENTIFIER_2=(Token)match(input,RULE_IDENTIFIER,FOLLOW_22); 

            	    		current.merge(this_IDENTIFIER_2);
            	        
            	     
            	        newLeafNode(this_IDENTIFIER_2, grammarAccess.getImportIDAccess().getIDENTIFIERTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // $ANTLR end "ruleImportID"


    // $ANTLR start "entryRuleInput"
    // InternalXtextTest.g:1084:1: entryRuleInput returns [EObject current=null] : iv_ruleInput= ruleInput EOF ;
    public final EObject entryRuleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInput = null;


        try {
            // InternalXtextTest.g:1085:2: (iv_ruleInput= ruleInput EOF )
            // InternalXtextTest.g:1086:2: iv_ruleInput= ruleInput EOF
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
    // InternalXtextTest.g:1093:1: ruleInput returns [EObject current=null] : ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) ) ;
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
            // InternalXtextTest.g:1099:7: ( ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) ) )
            // InternalXtextTest.g:1101:1: ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) )
            {
            // InternalXtextTest.g:1101:1: ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) )
            // InternalXtextTest.g:1102:1: () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) )
            {
            // InternalXtextTest.g:1102:1: ()
            // InternalXtextTest.g:1103:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInputAccess().getInputAction_0(),
                        current);
                

            }

            this_SOURCE_1=(Token)match(input,RULE_SOURCE,FOLLOW_23); 
             
                newLeafNode(this_SOURCE_1, grammarAccess.getInputAccess().getSOURCETerminalRuleCall_1()); 
                
            // InternalXtextTest.g:1118:1: ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_SRCTEXT) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_FILE) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalXtextTest.g:1119:1: (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:1119:1: (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:1120:1: this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) )
                    {
                    this_SRCTEXT_2=(Token)match(input,RULE_SRCTEXT,FOLLOW_6); 
                     
                        newLeafNode(this_SRCTEXT_2, grammarAccess.getInputAccess().getSRCTEXTTerminalRuleCall_2_0_0()); 
                        
                    this_ASSIGNASSINGLE_3=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_20); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_3, grammarAccess.getInputAccess().getASSIGNASSINGLETerminalRuleCall_2_0_1()); 
                        
                    // InternalXtextTest.g:1134:1: ( (lv_text_4_0= RULE_STRING ) )
                    // InternalXtextTest.g:1135:1: (lv_text_4_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1135:1: (lv_text_4_0= RULE_STRING )
                    // InternalXtextTest.g:1136:3: lv_text_4_0= RULE_STRING
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
                    // InternalXtextTest.g:1158:1: (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:1158:1: (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:1159:1: this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) )
                    {
                    this_FILE_5=(Token)match(input,RULE_FILE,FOLLOW_6); 
                     
                        newLeafNode(this_FILE_5, grammarAccess.getInputAccess().getFILETerminalRuleCall_2_1_0()); 
                        
                    this_ASSIGNASSINGLE_6=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_20); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_6, grammarAccess.getInputAccess().getASSIGNASSINGLETerminalRuleCall_2_1_1()); 
                        
                    // InternalXtextTest.g:1173:1: ( (lv_file_7_0= RULE_STRING ) )
                    // InternalXtextTest.g:1174:1: (lv_file_7_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1174:1: (lv_file_7_0= RULE_STRING )
                    // InternalXtextTest.g:1175:3: lv_file_7_0= RULE_STRING
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
                		
                 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleInput"


    // $ANTLR start "entryRuleTokens"
    // InternalXtextTest.g:1212:1: entryRuleTokens returns [EObject current=null] : iv_ruleTokens= ruleTokens EOF ;
    public final EObject entryRuleTokens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTokens = null;


        try {
            // InternalXtextTest.g:1213:2: (iv_ruleTokens= ruleTokens EOF )
            // InternalXtextTest.g:1214:2: iv_ruleTokens= ruleTokens EOF
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
    // InternalXtextTest.g:1221:1: ruleTokens returns [EObject current=null] : ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+ ) ;
    public final EObject ruleTokens() throws RecognitionException {
        EObject current = null;

        Token this_LEXER_1=null;
        EObject lv_tokens_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:1227:7: ( ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+ ) )
            // InternalXtextTest.g:1229:1: ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+ )
            {
            // InternalXtextTest.g:1229:1: ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+ )
            // InternalXtextTest.g:1230:1: () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+
            {
            // InternalXtextTest.g:1230:1: ()
            // InternalXtextTest.g:1231:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTokensAccess().getTokensAction_0(),
                        current);
                

            }

            this_LEXER_1=(Token)match(input,RULE_LEXER,FOLLOW_24); 
             
                newLeafNode(this_LEXER_1, grammarAccess.getTokensAccess().getLEXERTerminalRuleCall_1()); 
                
            // InternalXtextTest.g:1246:1: ( (lv_tokens_2_0= ruleMyTokens ) )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_STRING||LA19_0==RULE_IDENTIFIER) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalXtextTest.g:1247:1: (lv_tokens_2_0= ruleMyTokens )
            	    {
            	    // InternalXtextTest.g:1247:1: (lv_tokens_2_0= ruleMyTokens )
            	    // InternalXtextTest.g:1248:3: lv_tokens_2_0= ruleMyTokens
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTokensAccess().getTokensMyTokensParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_25);
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
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleTokens"


    // $ANTLR start "entryRuleMyTokens"
    // InternalXtextTest.g:1281:1: entryRuleMyTokens returns [EObject current=null] : iv_ruleMyTokens= ruleMyTokens EOF ;
    public final EObject entryRuleMyTokens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyTokens = null;


        try {
            // InternalXtextTest.g:1282:2: (iv_ruleMyTokens= ruleMyTokens EOF )
            // InternalXtextTest.g:1283:2: iv_ruleMyTokens= ruleMyTokens EOF
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
    // InternalXtextTest.g:1290:1: ruleMyTokens returns [EObject current=null] : ( ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) | ( (lv_string_1_0= RULE_STRING ) ) ) (this_ASSIGNASDATALIST_2= RULE_ASSIGNASDATALIST ( (lv_count_3_0= RULE_INT ) ) )? ) ;
    public final EObject ruleMyTokens() throws RecognitionException {
        EObject current = null;

        Token lv_token_0_0=null;
        Token lv_string_1_0=null;
        Token this_ASSIGNASDATALIST_2=null;
        Token lv_count_3_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:1296:7: ( ( ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) | ( (lv_string_1_0= RULE_STRING ) ) ) (this_ASSIGNASDATALIST_2= RULE_ASSIGNASDATALIST ( (lv_count_3_0= RULE_INT ) ) )? ) )
            // InternalXtextTest.g:1298:1: ( ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) | ( (lv_string_1_0= RULE_STRING ) ) ) (this_ASSIGNASDATALIST_2= RULE_ASSIGNASDATALIST ( (lv_count_3_0= RULE_INT ) ) )? )
            {
            // InternalXtextTest.g:1298:1: ( ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) | ( (lv_string_1_0= RULE_STRING ) ) ) (this_ASSIGNASDATALIST_2= RULE_ASSIGNASDATALIST ( (lv_count_3_0= RULE_INT ) ) )? )
            // InternalXtextTest.g:1299:1: ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) | ( (lv_string_1_0= RULE_STRING ) ) ) (this_ASSIGNASDATALIST_2= RULE_ASSIGNASDATALIST ( (lv_count_3_0= RULE_INT ) ) )?
            {
            // InternalXtextTest.g:1299:1: ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) | ( (lv_string_1_0= RULE_STRING ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_IDENTIFIER) ) {
                alt20=1;
            }
            else if ( (LA20_0==RULE_STRING) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalXtextTest.g:1300:1: ( (lv_token_0_0= RULE_IDENTIFIER ) )
                    {
                    // InternalXtextTest.g:1300:1: ( (lv_token_0_0= RULE_IDENTIFIER ) )
                    // InternalXtextTest.g:1301:1: (lv_token_0_0= RULE_IDENTIFIER )
                    {
                    // InternalXtextTest.g:1301:1: (lv_token_0_0= RULE_IDENTIFIER )
                    // InternalXtextTest.g:1302:3: lv_token_0_0= RULE_IDENTIFIER
                    {
                    lv_token_0_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_26); 

                    			newLeafNode(lv_token_0_0, grammarAccess.getMyTokensAccess().getTokenIDENTIFIERTerminalRuleCall_0_0_0()); 
                    		

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


                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:1322:1: ( (lv_string_1_0= RULE_STRING ) )
                    {
                    // InternalXtextTest.g:1322:1: ( (lv_string_1_0= RULE_STRING ) )
                    // InternalXtextTest.g:1323:1: (lv_string_1_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1323:1: (lv_string_1_0= RULE_STRING )
                    // InternalXtextTest.g:1324:3: lv_string_1_0= RULE_STRING
                    {
                    lv_string_1_0=(Token)match(input,RULE_STRING,FOLLOW_26); 

                    			newLeafNode(lv_string_1_0, grammarAccess.getMyTokensAccess().getStringSTRINGTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMyTokensRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"string",
                            		lv_string_1_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalXtextTest.g:1345:1: (this_ASSIGNASDATALIST_2= RULE_ASSIGNASDATALIST ( (lv_count_3_0= RULE_INT ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ASSIGNASDATALIST) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalXtextTest.g:1346:1: this_ASSIGNASDATALIST_2= RULE_ASSIGNASDATALIST ( (lv_count_3_0= RULE_INT ) )
                    {
                    this_ASSIGNASDATALIST_2=(Token)match(input,RULE_ASSIGNASDATALIST,FOLLOW_9); 
                     
                        newLeafNode(this_ASSIGNASDATALIST_2, grammarAccess.getMyTokensAccess().getASSIGNASDATALISTTerminalRuleCall_1_0()); 
                        
                    // InternalXtextTest.g:1353:1: ( (lv_count_3_0= RULE_INT ) )
                    // InternalXtextTest.g:1354:1: (lv_count_3_0= RULE_INT )
                    {
                    // InternalXtextTest.g:1354:1: (lv_count_3_0= RULE_INT )
                    // InternalXtextTest.g:1355:3: lv_count_3_0= RULE_INT
                    {
                    lv_count_3_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			newLeafNode(lv_count_3_0, grammarAccess.getMyTokensAccess().getCountINTTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMyTokensRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"count",
                            		lv_count_3_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleMyTokens"


    // $ANTLR start "entryRuleElement"
    // InternalXtextTest.g:1390:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalXtextTest.g:1391:2: (iv_ruleElement= ruleElement EOF )
            // InternalXtextTest.g:1392:2: iv_ruleElement= ruleElement EOF
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
    // InternalXtextTest.g:1399:1: ruleElement returns [EObject current=null] : ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )? ( (lv_name_4_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )? this_RIGHTPAREN_8= RULE_RIGHTPAREN ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token this_LEFTPAREN_1=null;
        Token lv_importing_2_0=null;
        Token this_IMPORTER_3=null;
        Token lv_name_4_0=null;
        Token this_COMMA_6=null;
        Token this_RIGHTPAREN_8=null;
        EObject lv_inner_5_0 = null;

        EObject lv_inner_7_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:1405:7: ( ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )? ( (lv_name_4_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )? this_RIGHTPAREN_8= RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:1407:1: ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )? ( (lv_name_4_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )? this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:1407:1: ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )? ( (lv_name_4_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )? this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            // InternalXtextTest.g:1408:1: () this_LEFTPAREN_1= RULE_LEFTPAREN ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )? ( (lv_name_4_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )? this_RIGHTPAREN_8= RULE_RIGHTPAREN
            {
            // InternalXtextTest.g:1408:1: ()
            // InternalXtextTest.g:1409:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getElementAccess().getElementAction_0(),
                        current);
                

            }

            this_LEFTPAREN_1=(Token)match(input,RULE_LEFTPAREN,FOLLOW_3); 
             
                newLeafNode(this_LEFTPAREN_1, grammarAccess.getElementAccess().getLEFTPARENTerminalRuleCall_1()); 
                
            // InternalXtextTest.g:1424:1: ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_IDENTIFIER) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==RULE_IMPORTER) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // InternalXtextTest.g:1425:1: ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER
                    {
                    // InternalXtextTest.g:1425:1: ( (lv_importing_2_0= RULE_IDENTIFIER ) )
                    // InternalXtextTest.g:1426:1: (lv_importing_2_0= RULE_IDENTIFIER )
                    {
                    // InternalXtextTest.g:1426:1: (lv_importing_2_0= RULE_IDENTIFIER )
                    // InternalXtextTest.g:1427:3: lv_importing_2_0= RULE_IDENTIFIER
                    {
                    lv_importing_2_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_27); 

                    			newLeafNode(lv_importing_2_0, grammarAccess.getElementAccess().getImportingIDENTIFIERTerminalRuleCall_2_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getElementRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"importing",
                            		lv_importing_2_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.IDENTIFIER");
                    	    

                    }


                    }

                    this_IMPORTER_3=(Token)match(input,RULE_IMPORTER,FOLLOW_3); 
                     
                        newLeafNode(this_IMPORTER_3, grammarAccess.getElementAccess().getIMPORTERTerminalRuleCall_2_1()); 
                        

                    }
                    break;

            }

            // InternalXtextTest.g:1455:1: ( (lv_name_4_0= RULE_IDENTIFIER ) )
            // InternalXtextTest.g:1456:1: (lv_name_4_0= RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:1456:1: (lv_name_4_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:1457:3: lv_name_4_0= RULE_IDENTIFIER
            {
            lv_name_4_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_28); 

            			newLeafNode(lv_name_4_0, grammarAccess.getElementAccess().getNameIDENTIFIERTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getElementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.IDENTIFIER");
            	    

            }


            }

            // InternalXtextTest.g:1476:1: ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_IDENTIFIER) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalXtextTest.g:1477:1: ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )*
                    {
                    // InternalXtextTest.g:1477:1: ( (lv_inner_5_0= ruleInner ) )
                    // InternalXtextTest.g:1478:1: (lv_inner_5_0= ruleInner )
                    {
                    // InternalXtextTest.g:1478:1: (lv_inner_5_0= ruleInner )
                    // InternalXtextTest.g:1479:3: lv_inner_5_0= ruleInner
                    {
                     
                    	        newCompositeNode(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_29);
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

                    // InternalXtextTest.g:1498:1: (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==RULE_COMMA) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalXtextTest.g:1499:1: this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) )
                    	    {
                    	    this_COMMA_6=(Token)match(input,RULE_COMMA,FOLLOW_3); 
                    	     
                    	        newLeafNode(this_COMMA_6, grammarAccess.getElementAccess().getCOMMATerminalRuleCall_4_1_0()); 
                    	        
                    	    // InternalXtextTest.g:1506:1: ( (lv_inner_7_0= ruleInner ) )
                    	    // InternalXtextTest.g:1507:1: (lv_inner_7_0= ruleInner )
                    	    {
                    	    // InternalXtextTest.g:1507:1: (lv_inner_7_0= ruleInner )
                    	    // InternalXtextTest.g:1508:3: lv_inner_7_0= ruleInner
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_29);
                    	    lv_inner_7_0=ruleInner();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getElementRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"inner",
                    	            		lv_inner_7_0, 
                    	            		"at.jku.weiner.xtexttest.XtextTest.Inner");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            this_RIGHTPAREN_8=(Token)match(input,RULE_RIGHTPAREN,FOLLOW_2); 
             
                newLeafNode(this_RIGHTPAREN_8, grammarAccess.getElementAccess().getRIGHTPARENTerminalRuleCall_5()); 
                

            }


            }

             leaveRule();
                		
                 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleInner"
    // InternalXtextTest.g:1552:1: entryRuleInner returns [EObject current=null] : iv_ruleInner= ruleInner EOF ;
    public final EObject entryRuleInner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInner = null;


        try {
            // InternalXtextTest.g:1553:2: (iv_ruleInner= ruleInner EOF )
            // InternalXtextTest.g:1554:2: iv_ruleInner= ruleInner EOF
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
    // InternalXtextTest.g:1561:1: ruleInner returns [EObject current=null] : ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) | ( (lv_isEmpty_16_0= RULE_ISEMPTY ) ) ) ) ;
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
        Token this_ASSIGNASBOOL_12=null;
        Token lv_assignAsBool_13_1=null;
        Token lv_assignAsBool_13_2=null;
        Token lv_isNull_14_0=null;
        Token lv_isNotNull_15_0=null;
        Token lv_isEmpty_16_0=null;
        EObject lv_assign_3_0 = null;

        EObject lv_assignList_5_0 = null;

        EObject lv_assignList_7_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:1567:7: ( ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) | ( (lv_isEmpty_16_0= RULE_ISEMPTY ) ) ) ) )
            // InternalXtextTest.g:1569:1: ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) | ( (lv_isEmpty_16_0= RULE_ISEMPTY ) ) ) )
            {
            // InternalXtextTest.g:1569:1: ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) | ( (lv_isEmpty_16_0= RULE_ISEMPTY ) ) ) )
            // InternalXtextTest.g:1570:1: () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) | ( (lv_isEmpty_16_0= RULE_ISEMPTY ) ) )
            {
            // InternalXtextTest.g:1570:1: ()
            // InternalXtextTest.g:1571:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInnerAccess().getInnerAction_0(),
                        current);
                

            }

            // InternalXtextTest.g:1579:1: ( (lv_parameter_1_0= RULE_IDENTIFIER ) )
            // InternalXtextTest.g:1580:1: (lv_parameter_1_0= RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:1580:1: (lv_parameter_1_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:1581:3: lv_parameter_1_0= RULE_IDENTIFIER
            {
            lv_parameter_1_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_30); 

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

            // InternalXtextTest.g:1600:1: ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) | ( (lv_isEmpty_16_0= RULE_ISEMPTY ) ) )
            int alt27=8;
            switch ( input.LA(1) ) {
            case RULE_ASSIGNASSINGLE:
                {
                alt27=1;
                }
                break;
            case RULE_ASSIGNASLIST:
                {
                alt27=2;
                }
                break;
            case RULE_ASSIGNASSTRING:
                {
                alt27=3;
                }
                break;
            case RULE_ASSIGNASDATALIST:
                {
                alt27=4;
                }
                break;
            case RULE_ASSIGNASBOOL:
                {
                alt27=5;
                }
                break;
            case RULE_ISNULL:
                {
                alt27=6;
                }
                break;
            case RULE_ISNOTNULL:
                {
                alt27=7;
                }
                break;
            case RULE_ISEMPTY:
                {
                alt27=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalXtextTest.g:1601:1: (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) )
                    {
                    // InternalXtextTest.g:1601:1: (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) )
                    // InternalXtextTest.g:1602:1: this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) )
                    {
                    this_ASSIGNASSINGLE_2=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_8); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_2, grammarAccess.getInnerAccess().getASSIGNASSINGLETerminalRuleCall_2_0_0()); 
                        
                    // InternalXtextTest.g:1609:1: ( (lv_assign_3_0= ruleElement ) )
                    // InternalXtextTest.g:1610:1: (lv_assign_3_0= ruleElement )
                    {
                    // InternalXtextTest.g:1610:1: (lv_assign_3_0= ruleElement )
                    // InternalXtextTest.g:1611:3: lv_assign_3_0= ruleElement
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
                    // InternalXtextTest.g:1633:1: (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* )
                    {
                    // InternalXtextTest.g:1633:1: (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* )
                    // InternalXtextTest.g:1634:1: this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )*
                    {
                    this_ASSIGNASLIST_4=(Token)match(input,RULE_ASSIGNASLIST,FOLLOW_8); 
                     
                        newLeafNode(this_ASSIGNASLIST_4, grammarAccess.getInnerAccess().getASSIGNASLISTTerminalRuleCall_2_1_0()); 
                        
                    // InternalXtextTest.g:1641:1: ( (lv_assignList_5_0= ruleElement ) )
                    // InternalXtextTest.g:1642:1: (lv_assignList_5_0= ruleElement )
                    {
                    // InternalXtextTest.g:1642:1: (lv_assignList_5_0= ruleElement )
                    // InternalXtextTest.g:1643:3: lv_assignList_5_0= ruleElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getInnerAccess().getAssignListElementParserRuleCall_2_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_31);
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

                    // InternalXtextTest.g:1662:1: (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==RULE_COMMA) ) {
                            int LA25_1 = input.LA(2);

                            if ( (LA25_1==RULE_LEFTPAREN) ) {
                                alt25=1;
                            }


                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalXtextTest.g:1663:1: this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) )
                    	    {
                    	    this_COMMA_6=(Token)match(input,RULE_COMMA,FOLLOW_8); 
                    	     
                    	        newLeafNode(this_COMMA_6, grammarAccess.getInnerAccess().getCOMMATerminalRuleCall_2_1_2_0()); 
                    	        
                    	    // InternalXtextTest.g:1670:1: ( (lv_assignList_7_0= ruleElement ) )
                    	    // InternalXtextTest.g:1671:1: (lv_assignList_7_0= ruleElement )
                    	    {
                    	    // InternalXtextTest.g:1671:1: (lv_assignList_7_0= ruleElement )
                    	    // InternalXtextTest.g:1672:3: lv_assignList_7_0= ruleElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInnerAccess().getAssignListElementParserRuleCall_2_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_31);
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
                    	    break loop25;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // InternalXtextTest.g:1696:1: (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:1696:1: (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:1697:1: this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) )
                    {
                    this_ASSIGNASSTRING_8=(Token)match(input,RULE_ASSIGNASSTRING,FOLLOW_20); 
                     
                        newLeafNode(this_ASSIGNASSTRING_8, grammarAccess.getInnerAccess().getASSIGNASSTRINGTerminalRuleCall_2_2_0()); 
                        
                    // InternalXtextTest.g:1704:1: ( (lv_value_9_0= RULE_STRING ) )
                    // InternalXtextTest.g:1705:1: (lv_value_9_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1705:1: (lv_value_9_0= RULE_STRING )
                    // InternalXtextTest.g:1706:3: lv_value_9_0= RULE_STRING
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
                    // InternalXtextTest.g:1728:1: (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:1728:1: (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:1729:1: this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) )
                    {
                    this_ASSIGNASDATALIST_10=(Token)match(input,RULE_ASSIGNASDATALIST,FOLLOW_20); 
                     
                        newLeafNode(this_ASSIGNASDATALIST_10, grammarAccess.getInnerAccess().getASSIGNASDATALISTTerminalRuleCall_2_3_0()); 
                        
                    // InternalXtextTest.g:1736:1: ( (lv_assignAsData_11_0= RULE_STRING ) )
                    // InternalXtextTest.g:1737:1: (lv_assignAsData_11_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1737:1: (lv_assignAsData_11_0= RULE_STRING )
                    // InternalXtextTest.g:1738:3: lv_assignAsData_11_0= RULE_STRING
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
                case 5 :
                    // InternalXtextTest.g:1760:1: (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) )
                    {
                    // InternalXtextTest.g:1760:1: (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) )
                    // InternalXtextTest.g:1761:1: this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) )
                    {
                    this_ASSIGNASBOOL_12=(Token)match(input,RULE_ASSIGNASBOOL,FOLLOW_7); 
                     
                        newLeafNode(this_ASSIGNASBOOL_12, grammarAccess.getInnerAccess().getASSIGNASBOOLTerminalRuleCall_2_4_0()); 
                        
                    // InternalXtextTest.g:1768:1: ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) )
                    // InternalXtextTest.g:1769:1: ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) )
                    {
                    // InternalXtextTest.g:1769:1: ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) )
                    // InternalXtextTest.g:1770:1: (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE )
                    {
                    // InternalXtextTest.g:1770:1: (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==RULE_TRUE) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==RULE_FALSE) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalXtextTest.g:1771:3: lv_assignAsBool_13_1= RULE_TRUE
                            {
                            lv_assignAsBool_13_1=(Token)match(input,RULE_TRUE,FOLLOW_2); 

                            			newLeafNode(lv_assignAsBool_13_1, grammarAccess.getInnerAccess().getAssignAsBoolTRUETerminalRuleCall_2_4_1_0_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getInnerRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"assignAsBool",
                                    		lv_assignAsBool_13_1, 
                                    		"at.jku.weiner.xtexttest.XtextTest.TRUE");
                            	    

                            }
                            break;
                        case 2 :
                            // InternalXtextTest.g:1786:8: lv_assignAsBool_13_2= RULE_FALSE
                            {
                            lv_assignAsBool_13_2=(Token)match(input,RULE_FALSE,FOLLOW_2); 

                            			newLeafNode(lv_assignAsBool_13_2, grammarAccess.getInnerAccess().getAssignAsBoolFALSETerminalRuleCall_2_4_1_0_1()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getInnerRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"assignAsBool",
                                    		lv_assignAsBool_13_2, 
                                    		"at.jku.weiner.xtexttest.XtextTest.FALSE");
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalXtextTest.g:1810:1: ( (lv_isNull_14_0= RULE_ISNULL ) )
                    {
                    // InternalXtextTest.g:1810:1: ( (lv_isNull_14_0= RULE_ISNULL ) )
                    // InternalXtextTest.g:1811:1: (lv_isNull_14_0= RULE_ISNULL )
                    {
                    // InternalXtextTest.g:1811:1: (lv_isNull_14_0= RULE_ISNULL )
                    // InternalXtextTest.g:1812:3: lv_isNull_14_0= RULE_ISNULL
                    {
                    lv_isNull_14_0=(Token)match(input,RULE_ISNULL,FOLLOW_2); 

                    			newLeafNode(lv_isNull_14_0, grammarAccess.getInnerAccess().getIsNullISNULLTerminalRuleCall_2_5_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInnerRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"isNull",
                            		true, 
                            		"at.jku.weiner.xtexttest.XtextTest.ISNULL");
                    	    

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalXtextTest.g:1832:1: ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) )
                    {
                    // InternalXtextTest.g:1832:1: ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) )
                    // InternalXtextTest.g:1833:1: (lv_isNotNull_15_0= RULE_ISNOTNULL )
                    {
                    // InternalXtextTest.g:1833:1: (lv_isNotNull_15_0= RULE_ISNOTNULL )
                    // InternalXtextTest.g:1834:3: lv_isNotNull_15_0= RULE_ISNOTNULL
                    {
                    lv_isNotNull_15_0=(Token)match(input,RULE_ISNOTNULL,FOLLOW_2); 

                    			newLeafNode(lv_isNotNull_15_0, grammarAccess.getInnerAccess().getIsNotNullISNOTNULLTerminalRuleCall_2_6_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInnerRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"isNotNull",
                            		true, 
                            		"at.jku.weiner.xtexttest.XtextTest.ISNOTNULL");
                    	    

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalXtextTest.g:1854:1: ( (lv_isEmpty_16_0= RULE_ISEMPTY ) )
                    {
                    // InternalXtextTest.g:1854:1: ( (lv_isEmpty_16_0= RULE_ISEMPTY ) )
                    // InternalXtextTest.g:1855:1: (lv_isEmpty_16_0= RULE_ISEMPTY )
                    {
                    // InternalXtextTest.g:1855:1: (lv_isEmpty_16_0= RULE_ISEMPTY )
                    // InternalXtextTest.g:1856:3: lv_isEmpty_16_0= RULE_ISEMPTY
                    {
                    lv_isEmpty_16_0=(Token)match(input,RULE_ISEMPTY,FOLLOW_2); 

                    			newLeafNode(lv_isEmpty_16_0, grammarAccess.getInnerAccess().getIsEmptyISEMPTYTerminalRuleCall_2_7_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInnerRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"isEmpty",
                            		true, 
                            		"at.jku.weiner.xtexttest.XtextTest.ISEMPTY");
                    	    

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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleInner"


    // $ANTLR start "entryRuleGenerator"
    // InternalXtextTest.g:1891:1: entryRuleGenerator returns [EObject current=null] : iv_ruleGenerator= ruleGenerator EOF ;
    public final EObject entryRuleGenerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenerator = null;


        try {
            // InternalXtextTest.g:1892:2: (iv_ruleGenerator= ruleGenerator EOF )
            // InternalXtextTest.g:1893:2: iv_ruleGenerator= ruleGenerator EOF
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
    // InternalXtextTest.g:1900:1: ruleGenerator returns [EObject current=null] : ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? ) ;
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
            // InternalXtextTest.g:1906:7: ( ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? ) )
            // InternalXtextTest.g:1908:1: ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? )
            {
            // InternalXtextTest.g:1908:1: ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? )
            // InternalXtextTest.g:1909:1: () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )?
            {
            // InternalXtextTest.g:1909:1: ()
            // InternalXtextTest.g:1910:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getGeneratorAccess().getGeneratorAction_0(),
                        current);
                

            }

            // InternalXtextTest.g:1918:1: (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) )
            // InternalXtextTest.g:1919:1: this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) )
            {
            this_OUTPUT_1=(Token)match(input,RULE_OUTPUT,FOLLOW_19); 
             
                newLeafNode(this_OUTPUT_1, grammarAccess.getGeneratorAccess().getOUTPUTTerminalRuleCall_1_0()); 
                
            this_FILE_2=(Token)match(input,RULE_FILE,FOLLOW_6); 
             
                newLeafNode(this_FILE_2, grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_1_1()); 
                
            this_ASSIGNASSINGLE_3=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_20); 
             
                newLeafNode(this_ASSIGNASSINGLE_3, grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_1_2()); 
                
            // InternalXtextTest.g:1940:1: ( (lv_output_4_0= RULE_STRING ) )
            // InternalXtextTest.g:1941:1: (lv_output_4_0= RULE_STRING )
            {
            // InternalXtextTest.g:1941:1: (lv_output_4_0= RULE_STRING )
            // InternalXtextTest.g:1942:3: lv_output_4_0= RULE_STRING
            {
            lv_output_4_0=(Token)match(input,RULE_STRING,FOLLOW_32); 

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

            // InternalXtextTest.g:1963:1: (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) )
            // InternalXtextTest.g:1964:1: this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) )
            {
            this_EXPECTED_5=(Token)match(input,RULE_EXPECTED,FOLLOW_19); 
             
                newLeafNode(this_EXPECTED_5, grammarAccess.getGeneratorAccess().getEXPECTEDTerminalRuleCall_2_0()); 
                
            this_FILE_6=(Token)match(input,RULE_FILE,FOLLOW_33); 
             
                newLeafNode(this_FILE_6, grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_2_1()); 
                
            // InternalXtextTest.g:1978:1: ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ASSIGNASSINGLE) ) {
                alt28=1;
            }
            else if ( (LA28_0==RULE_ISSAMEASINPUTFILE) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalXtextTest.g:1979:1: (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:1979:1: (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:1980:1: this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) )
                    {
                    this_ASSIGNASSINGLE_7=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_20); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_7, grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_2_2_0_0()); 
                        
                    // InternalXtextTest.g:1987:1: ( (lv_expected_8_0= RULE_STRING ) )
                    // InternalXtextTest.g:1988:1: (lv_expected_8_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1988:1: (lv_expected_8_0= RULE_STRING )
                    // InternalXtextTest.g:1989:3: lv_expected_8_0= RULE_STRING
                    {
                    lv_expected_8_0=(Token)match(input,RULE_STRING,FOLLOW_34); 

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
                    // InternalXtextTest.g:2011:1: ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) )
                    {
                    // InternalXtextTest.g:2011:1: ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) )
                    // InternalXtextTest.g:2012:1: (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE )
                    {
                    // InternalXtextTest.g:2012:1: (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE )
                    // InternalXtextTest.g:2013:3: lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE
                    {
                    lv_isSameAsInputFile_9_0=(Token)match(input,RULE_ISSAMEASINPUTFILE,FOLLOW_34); 

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

            // InternalXtextTest.g:2036:1: (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_PATTERNS) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalXtextTest.g:2037:1: this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )*
                    {
                    this_PATTERNS_10=(Token)match(input,RULE_PATTERNS,FOLLOW_35); 
                     
                        newLeafNode(this_PATTERNS_10, grammarAccess.getGeneratorAccess().getPATTERNSTerminalRuleCall_3_0()); 
                        
                    // InternalXtextTest.g:2044:1: (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==RULE_FILE) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalXtextTest.g:2045:1: this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) )
                            {
                            this_FILE_11=(Token)match(input,RULE_FILE,FOLLOW_6); 
                             
                                newLeafNode(this_FILE_11, grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_3_1_0()); 
                                
                            this_ASSIGNASSINGLE_12=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_20); 
                             
                                newLeafNode(this_ASSIGNASSINGLE_12, grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_3_1_1()); 
                                
                            // InternalXtextTest.g:2059:1: ( (lv_patternFile_13_0= RULE_STRING ) )
                            // InternalXtextTest.g:2060:1: (lv_patternFile_13_0= RULE_STRING )
                            {
                            // InternalXtextTest.g:2060:1: (lv_patternFile_13_0= RULE_STRING )
                            // InternalXtextTest.g:2061:3: lv_patternFile_13_0= RULE_STRING
                            {
                            lv_patternFile_13_0=(Token)match(input,RULE_STRING,FOLLOW_36); 

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

                    // InternalXtextTest.g:2082:1: ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==RULE_STRING) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalXtextTest.g:2083:1: (lv_replacePatterns_14_0= ruleReplacePatterns )
                    	    {
                    	    // InternalXtextTest.g:2083:1: (lv_replacePatterns_14_0= ruleReplacePatterns )
                    	    // InternalXtextTest.g:2084:3: lv_replacePatterns_14_0= ruleReplacePatterns
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getGeneratorAccess().getReplacePatternsReplacePatternsParserRuleCall_3_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_36);
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
                    	    break loop30;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalXtextTest.g:2105:1: (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_EXPECTED) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalXtextTest.g:2106:1: this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) )
                    {
                    this_EXPECTED_15=(Token)match(input,RULE_EXPECTED,FOLLOW_37); 
                     
                        newLeafNode(this_EXPECTED_15, grammarAccess.getGeneratorAccess().getEXPECTEDTerminalRuleCall_4_0()); 
                        
                    this_EXCEPTIONS_16=(Token)match(input,RULE_EXCEPTIONS,FOLLOW_3); 
                     
                        newLeafNode(this_EXCEPTIONS_16, grammarAccess.getGeneratorAccess().getEXCEPTIONSTerminalRuleCall_4_1()); 
                        
                    // InternalXtextTest.g:2120:1: ( (lv_exception_17_0= rulePackageID ) )
                    // InternalXtextTest.g:2121:1: (lv_exception_17_0= rulePackageID )
                    {
                    // InternalXtextTest.g:2121:1: (lv_exception_17_0= rulePackageID )
                    // InternalXtextTest.g:2122:3: lv_exception_17_0= rulePackageID
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
                		
                 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleGenerator"


    // $ANTLR start "entryRuleReplacePatterns"
    // InternalXtextTest.g:2157:1: entryRuleReplacePatterns returns [EObject current=null] : iv_ruleReplacePatterns= ruleReplacePatterns EOF ;
    public final EObject entryRuleReplacePatterns() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReplacePatterns = null;


        try {
            // InternalXtextTest.g:2158:2: (iv_ruleReplacePatterns= ruleReplacePatterns EOF )
            // InternalXtextTest.g:2159:2: iv_ruleReplacePatterns= ruleReplacePatterns EOF
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
    // InternalXtextTest.g:2166:1: ruleReplacePatterns returns [EObject current=null] : ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleReplacePatterns() throws RecognitionException {
        EObject current = null;

        Token lv_regex_0_0=null;
        Token this_ASSIGNASSINGLE_1=null;
        Token lv_replace_2_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:2172:7: ( ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) ) )
            // InternalXtextTest.g:2174:1: ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) )
            {
            // InternalXtextTest.g:2174:1: ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) )
            // InternalXtextTest.g:2175:1: ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) )
            {
            // InternalXtextTest.g:2175:1: ( (lv_regex_0_0= RULE_STRING ) )
            // InternalXtextTest.g:2176:1: (lv_regex_0_0= RULE_STRING )
            {
            // InternalXtextTest.g:2176:1: (lv_regex_0_0= RULE_STRING )
            // InternalXtextTest.g:2177:3: lv_regex_0_0= RULE_STRING
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

            this_ASSIGNASSINGLE_1=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_20); 
             
                newLeafNode(this_ASSIGNASSINGLE_1, grammarAccess.getReplacePatternsAccess().getASSIGNASSINGLETerminalRuleCall_1()); 
                
            // InternalXtextTest.g:2203:1: ( (lv_replace_2_0= RULE_STRING ) )
            // InternalXtextTest.g:2204:1: (lv_replace_2_0= RULE_STRING )
            {
            // InternalXtextTest.g:2204:1: (lv_replace_2_0= RULE_STRING )
            // InternalXtextTest.g:2205:3: lv_replace_2_0= RULE_STRING
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
                		
                 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleReplacePatterns"


    // $ANTLR start "entryRuleBefore"
    // InternalXtextTest.g:2238:1: entryRuleBefore returns [EObject current=null] : iv_ruleBefore= ruleBefore EOF ;
    public final EObject entryRuleBefore() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBefore = null;


        try {
            // InternalXtextTest.g:2239:2: (iv_ruleBefore= ruleBefore EOF )
            // InternalXtextTest.g:2240:2: iv_ruleBefore= ruleBefore EOF
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
    // InternalXtextTest.g:2247:1: ruleBefore returns [EObject current=null] : ( () this_BEFORE_KW_1= RULE_BEFORE_KW ( (lv_codeCall_2_0= ruleCodeCall ) ) ) ;
    public final EObject ruleBefore() throws RecognitionException {
        EObject current = null;

        Token this_BEFORE_KW_1=null;
        EObject lv_codeCall_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:2253:7: ( ( () this_BEFORE_KW_1= RULE_BEFORE_KW ( (lv_codeCall_2_0= ruleCodeCall ) ) ) )
            // InternalXtextTest.g:2255:1: ( () this_BEFORE_KW_1= RULE_BEFORE_KW ( (lv_codeCall_2_0= ruleCodeCall ) ) )
            {
            // InternalXtextTest.g:2255:1: ( () this_BEFORE_KW_1= RULE_BEFORE_KW ( (lv_codeCall_2_0= ruleCodeCall ) ) )
            // InternalXtextTest.g:2256:1: () this_BEFORE_KW_1= RULE_BEFORE_KW ( (lv_codeCall_2_0= ruleCodeCall ) )
            {
            // InternalXtextTest.g:2256:1: ()
            // InternalXtextTest.g:2257:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBeforeAccess().getBeforeAction_0(),
                        current);
                

            }

            this_BEFORE_KW_1=(Token)match(input,RULE_BEFORE_KW,FOLLOW_15); 
             
                newLeafNode(this_BEFORE_KW_1, grammarAccess.getBeforeAccess().getBEFORE_KWTerminalRuleCall_1()); 
                
            // InternalXtextTest.g:2272:1: ( (lv_codeCall_2_0= ruleCodeCall ) )
            // InternalXtextTest.g:2273:1: (lv_codeCall_2_0= ruleCodeCall )
            {
            // InternalXtextTest.g:2273:1: (lv_codeCall_2_0= ruleCodeCall )
            // InternalXtextTest.g:2274:3: lv_codeCall_2_0= ruleCodeCall
            {
             
            	        newCompositeNode(grammarAccess.getBeforeAccess().getCodeCallCodeCallParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_codeCall_2_0=ruleCodeCall();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBeforeRule());
            	        }
                   		set(
                   			current, 
                   			"codeCall",
                    		lv_codeCall_2_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.CodeCall");
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleBefore"


    // $ANTLR start "entryRuleAfter"
    // InternalXtextTest.g:2307:1: entryRuleAfter returns [EObject current=null] : iv_ruleAfter= ruleAfter EOF ;
    public final EObject entryRuleAfter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAfter = null;


        try {
            // InternalXtextTest.g:2308:2: (iv_ruleAfter= ruleAfter EOF )
            // InternalXtextTest.g:2309:2: iv_ruleAfter= ruleAfter EOF
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
    // InternalXtextTest.g:2316:1: ruleAfter returns [EObject current=null] : ( () this_AFTER_KW_1= RULE_AFTER_KW ( (lv_codeCall_2_0= ruleCodeCall ) ) ) ;
    public final EObject ruleAfter() throws RecognitionException {
        EObject current = null;

        Token this_AFTER_KW_1=null;
        EObject lv_codeCall_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:2322:7: ( ( () this_AFTER_KW_1= RULE_AFTER_KW ( (lv_codeCall_2_0= ruleCodeCall ) ) ) )
            // InternalXtextTest.g:2324:1: ( () this_AFTER_KW_1= RULE_AFTER_KW ( (lv_codeCall_2_0= ruleCodeCall ) ) )
            {
            // InternalXtextTest.g:2324:1: ( () this_AFTER_KW_1= RULE_AFTER_KW ( (lv_codeCall_2_0= ruleCodeCall ) ) )
            // InternalXtextTest.g:2325:1: () this_AFTER_KW_1= RULE_AFTER_KW ( (lv_codeCall_2_0= ruleCodeCall ) )
            {
            // InternalXtextTest.g:2325:1: ()
            // InternalXtextTest.g:2326:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAfterAccess().getAfterAction_0(),
                        current);
                

            }

            this_AFTER_KW_1=(Token)match(input,RULE_AFTER_KW,FOLLOW_15); 
             
                newLeafNode(this_AFTER_KW_1, grammarAccess.getAfterAccess().getAFTER_KWTerminalRuleCall_1()); 
                
            // InternalXtextTest.g:2341:1: ( (lv_codeCall_2_0= ruleCodeCall ) )
            // InternalXtextTest.g:2342:1: (lv_codeCall_2_0= ruleCodeCall )
            {
            // InternalXtextTest.g:2342:1: (lv_codeCall_2_0= ruleCodeCall )
            // InternalXtextTest.g:2343:3: lv_codeCall_2_0= ruleCodeCall
            {
             
            	        newCompositeNode(grammarAccess.getAfterAccess().getCodeCallCodeCallParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_codeCall_2_0=ruleCodeCall();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAfterRule());
            	        }
                   		set(
                   			current, 
                   			"codeCall",
                    		lv_codeCall_2_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.CodeCall");
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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleAfter"


    // $ANTLR start "entryRuleCodeCall"
    // InternalXtextTest.g:2376:1: entryRuleCodeCall returns [EObject current=null] : iv_ruleCodeCall= ruleCodeCall EOF ;
    public final EObject entryRuleCodeCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodeCall = null;


        try {
            // InternalXtextTest.g:2377:2: (iv_ruleCodeCall= ruleCodeCall EOF )
            // InternalXtextTest.g:2378:2: iv_ruleCodeCall= ruleCodeCall EOF
            {
             newCompositeNode(grammarAccess.getCodeCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCodeCall=ruleCodeCall();

            state._fsp--;

             current =iv_ruleCodeCall; 
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
    // $ANTLR end "entryRuleCodeCall"


    // $ANTLR start "ruleCodeCall"
    // InternalXtextTest.g:2385:1: ruleCodeCall returns [EObject current=null] : ( () this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) (this_LEFTPAREN_7= RULE_LEFTPAREN ( ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )* )? this_RIGHTPAREN_11= RULE_RIGHTPAREN ) ) ;
    public final EObject ruleCodeCall() throws RecognitionException {
        EObject current = null;

        Token this_CLASS_KW_1=null;
        Token this_ASSIGNASSINGLE_2=null;
        Token this_METHOD_KW_4=null;
        Token this_ASSIGNASSINGLE_5=null;
        Token this_LEFTPAREN_7=null;
        Token this_COMMA_9=null;
        Token this_RIGHTPAREN_11=null;
        AntlrDatatypeRuleToken lv_myclass_3_0 = null;

        AntlrDatatypeRuleToken lv_method_6_0 = null;

        AntlrDatatypeRuleToken lv_params_8_0 = null;

        AntlrDatatypeRuleToken lv_params_10_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:2391:7: ( ( () this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) (this_LEFTPAREN_7= RULE_LEFTPAREN ( ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )* )? this_RIGHTPAREN_11= RULE_RIGHTPAREN ) ) )
            // InternalXtextTest.g:2393:1: ( () this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) (this_LEFTPAREN_7= RULE_LEFTPAREN ( ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )* )? this_RIGHTPAREN_11= RULE_RIGHTPAREN ) )
            {
            // InternalXtextTest.g:2393:1: ( () this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) (this_LEFTPAREN_7= RULE_LEFTPAREN ( ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )* )? this_RIGHTPAREN_11= RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:2394:1: () this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) (this_LEFTPAREN_7= RULE_LEFTPAREN ( ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )* )? this_RIGHTPAREN_11= RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:2394:1: ()
            // InternalXtextTest.g:2395:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCodeCallAccess().getCodeCallAction_0(),
                        current);
                

            }

            this_CLASS_KW_1=(Token)match(input,RULE_CLASS_KW,FOLLOW_6); 
             
                newLeafNode(this_CLASS_KW_1, grammarAccess.getCodeCallAccess().getCLASS_KWTerminalRuleCall_1()); 
                
            this_ASSIGNASSINGLE_2=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_3); 
             
                newLeafNode(this_ASSIGNASSINGLE_2, grammarAccess.getCodeCallAccess().getASSIGNASSINGLETerminalRuleCall_2()); 
                
            // InternalXtextTest.g:2417:1: ( (lv_myclass_3_0= rulePackageID ) )
            // InternalXtextTest.g:2418:1: (lv_myclass_3_0= rulePackageID )
            {
            // InternalXtextTest.g:2418:1: (lv_myclass_3_0= rulePackageID )
            // InternalXtextTest.g:2419:3: lv_myclass_3_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getCodeCallAccess().getMyclassPackageIDParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_38);
            lv_myclass_3_0=rulePackageID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCodeCallRule());
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
             
                newLeafNode(this_METHOD_KW_4, grammarAccess.getCodeCallAccess().getMETHOD_KWTerminalRuleCall_4()); 
                
            this_ASSIGNASSINGLE_5=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_3); 
             
                newLeafNode(this_ASSIGNASSINGLE_5, grammarAccess.getCodeCallAccess().getASSIGNASSINGLETerminalRuleCall_5()); 
                
            // InternalXtextTest.g:2452:1: ( (lv_method_6_0= rulePackageID ) )
            // InternalXtextTest.g:2453:1: (lv_method_6_0= rulePackageID )
            {
            // InternalXtextTest.g:2453:1: (lv_method_6_0= rulePackageID )
            // InternalXtextTest.g:2454:3: lv_method_6_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getCodeCallAccess().getMethodPackageIDParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_39);
            lv_method_6_0=rulePackageID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCodeCallRule());
            	        }
                   		set(
                   			current, 
                   			"method",
                    		lv_method_6_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.PackageID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalXtextTest.g:2473:1: (this_LEFTPAREN_7= RULE_LEFTPAREN ( ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )* )? this_RIGHTPAREN_11= RULE_RIGHTPAREN )
            // InternalXtextTest.g:2474:1: this_LEFTPAREN_7= RULE_LEFTPAREN ( ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )* )? this_RIGHTPAREN_11= RULE_RIGHTPAREN
            {
            this_LEFTPAREN_7=(Token)match(input,RULE_LEFTPAREN,FOLLOW_28); 
             
                newLeafNode(this_LEFTPAREN_7, grammarAccess.getCodeCallAccess().getLEFTPARENTerminalRuleCall_7_0()); 
                
            // InternalXtextTest.g:2481:1: ( ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_IDENTIFIER) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalXtextTest.g:2482:1: ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )*
                    {
                    // InternalXtextTest.g:2482:1: ( (lv_params_8_0= rulePackageID ) )
                    // InternalXtextTest.g:2483:1: (lv_params_8_0= rulePackageID )
                    {
                    // InternalXtextTest.g:2483:1: (lv_params_8_0= rulePackageID )
                    // InternalXtextTest.g:2484:3: lv_params_8_0= rulePackageID
                    {
                     
                    	        newCompositeNode(grammarAccess.getCodeCallAccess().getParamsPackageIDParserRuleCall_7_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_29);
                    lv_params_8_0=rulePackageID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCodeCallRule());
                    	        }
                           		add(
                           			current, 
                           			"params",
                            		lv_params_8_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.PackageID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalXtextTest.g:2503:1: (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==RULE_COMMA) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalXtextTest.g:2504:1: this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) )
                    	    {
                    	    this_COMMA_9=(Token)match(input,RULE_COMMA,FOLLOW_3); 
                    	     
                    	        newLeafNode(this_COMMA_9, grammarAccess.getCodeCallAccess().getCOMMATerminalRuleCall_7_1_1_0()); 
                    	        
                    	    // InternalXtextTest.g:2511:1: ( (lv_params_10_0= rulePackageID ) )
                    	    // InternalXtextTest.g:2512:1: (lv_params_10_0= rulePackageID )
                    	    {
                    	    // InternalXtextTest.g:2512:1: (lv_params_10_0= rulePackageID )
                    	    // InternalXtextTest.g:2513:3: lv_params_10_0= rulePackageID
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getCodeCallAccess().getParamsPackageIDParserRuleCall_7_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_29);
                    	    lv_params_10_0=rulePackageID();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getCodeCallRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"params",
                    	            		lv_params_10_0, 
                    	            		"at.jku.weiner.xtexttest.XtextTest.PackageID");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }
                    break;

            }

            this_RIGHTPAREN_11=(Token)match(input,RULE_RIGHTPAREN,FOLLOW_2); 
             
                newLeafNode(this_RIGHTPAREN_11, grammarAccess.getCodeCallAccess().getRIGHTPARENTerminalRuleCall_7_2()); 
                

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


            	/*no after found*/


        }
        return current;
    }
    // $ANTLR end "ruleCodeCall"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000080C0L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000005000200L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000061000000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000080000000240L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000810000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00000000000A0002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000020080000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000FC2000100L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000004000000100L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000000A000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000002000030002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000002000020002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000004000000L});

}