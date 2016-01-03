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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_PACKAGE", "RULE_LANGUAGE", "RULE_IMPORTS", "RULE_SPLITLEXER", "RULE_ASSIGNASSINGLE", "RULE_KW_EMFTEST", "RULE_DEFAULT", "RULE_OPTIONS", "RULE_SOURCE", "RULE_FILE", "RULE_STRING", "RULE_KW_AS", "RULE_IDENTIFIER", "RULE_TRUE", "RULE_FALSE", "RULE_POINT", "RULE_SRCTEXT", "RULE_LEXER", "RULE_ASSIGNASDATALIST", "RULE_INT", "RULE_LEFTPAREN", "RULE_IMPORTER", "RULE_COMMA", "RULE_RIGHTPAREN", "RULE_ASSIGNASLIST", "RULE_ASSIGNASSTRING", "RULE_ASSIGNASBOOL", "RULE_ISNULL", "RULE_ISNOTNULL", "RULE_ISEMPTY", "RULE_OUTPUT", "RULE_EXPECTED", "RULE_ISSAMEASINPUTFILE", "RULE_PATTERNS", "RULE_EXCEPTIONS", "RULE_BEFORE_KW", "RULE_AFTER_KW", "RULE_CLASS_KW", "RULE_METHOD_KW", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=43;
    public static final int RULE_IMPORTER=25;
    public static final int RULE_ANY_OTHER=47;
    public static final int RULE_SPLITLEXER=7;
    public static final int RULE_LANGUAGE=5;
    public static final int RULE_ASSIGNASBOOL=30;
    public static final int EOF=-1;
    public static final int RULE_FALSE=18;
    public static final int RULE_PACKAGE=4;
    public static final int RULE_ASSIGNASSINGLE=8;
    public static final int RULE_KW_EMFTEST=9;
    public static final int RULE_ASSIGNASLIST=28;
    public static final int RULE_POINT=19;
    public static final int RULE_INT=23;
    public static final int RULE_CLASS_KW=41;
    public static final int RULE_ASSIGNASSTRING=29;
    public static final int RULE_OPTIONS=11;
    public static final int RULE_ISSAMEASINPUTFILE=36;
    public static final int RULE_SRCTEXT=20;
    public static final int RULE_IMPORTS=6;
    public static final int RULE_RIGHTPAREN=27;
    public static final int RULE_PATTERNS=37;
    public static final int RULE_METHOD_KW=42;
    public static final int RULE_ASSIGNASDATALIST=22;
    public static final int RULE_ISNULL=31;
    public static final int RULE_ISEMPTY=33;
    public static final int RULE_EXPECTED=35;
    public static final int RULE_FILE=13;
    public static final int RULE_IDENTIFIER=16;
    public static final int RULE_COMMA=26;
    public static final int RULE_AFTER_KW=40;
    public static final int RULE_SL_COMMENT=45;
    public static final int RULE_ISNOTNULL=32;
    public static final int RULE_DEFAULT=10;
    public static final int RULE_ML_COMMENT=44;
    public static final int RULE_TRUE=17;
    public static final int RULE_BEFORE_KW=39;
    public static final int RULE_STRING=14;
    public static final int RULE_SOURCE=12;
    public static final int RULE_LEFTPAREN=24;
    public static final int RULE_EXCEPTIONS=38;
    public static final int RULE_LEXER=21;
    public static final int RULE_OUTPUT=34;
    public static final int RULE_WS=46;
    public static final int RULE_KW_AS=15;

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


    // $ANTLR start "entryRuleXtextTest"
    // InternalXtextTest.g:150:1: entryRuleXtextTest returns [EObject current=null] : iv_ruleXtextTest= ruleXtextTest EOF ;
    public final EObject entryRuleXtextTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXtextTest = null;


        try {
            // InternalXtextTest.g:151:2: (iv_ruleXtextTest= ruleXtextTest EOF )
            // InternalXtextTest.g:152:2: iv_ruleXtextTest= ruleXtextTest EOF
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
    // InternalXtextTest.g:159:1: ruleXtextTest returns [EObject current=null] : ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )? (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )? ( (lv_input_10_0= ruleInput ) ) ( (lv_tokens_11_0= ruleTokens ) )? ( (lv_root_12_0= ruleElement ) ) ( (lv_output_13_0= ruleGenerator ) )? ( (lv_before_14_0= ruleBefore ) )? ( (lv_after_15_0= ruleAfter ) )? ) ;
    public final EObject ruleXtextTest() throws RecognitionException {
        EObject current = null;

        Token this_PACKAGE_1=null;
        Token this_LANGUAGE_3=null;
        Token this_IMPORTS_5=null;
        Token this_SPLITLEXER_7=null;
        Token this_ASSIGNASSINGLE_8=null;
        AntlrDatatypeRuleToken lv_package_2_0 = null;

        AntlrDatatypeRuleToken lv_lang_4_0 = null;

        AntlrDatatypeRuleToken lv_imports_6_0 = null;

        AntlrDatatypeRuleToken lv_boolean_9_0 = null;

        EObject lv_input_10_0 = null;

        EObject lv_tokens_11_0 = null;

        EObject lv_root_12_0 = null;

        EObject lv_output_13_0 = null;

        EObject lv_before_14_0 = null;

        EObject lv_after_15_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:165:7: ( ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )? (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )? ( (lv_input_10_0= ruleInput ) ) ( (lv_tokens_11_0= ruleTokens ) )? ( (lv_root_12_0= ruleElement ) ) ( (lv_output_13_0= ruleGenerator ) )? ( (lv_before_14_0= ruleBefore ) )? ( (lv_after_15_0= ruleAfter ) )? ) )
            // InternalXtextTest.g:167:1: ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )? (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )? ( (lv_input_10_0= ruleInput ) ) ( (lv_tokens_11_0= ruleTokens ) )? ( (lv_root_12_0= ruleElement ) ) ( (lv_output_13_0= ruleGenerator ) )? ( (lv_before_14_0= ruleBefore ) )? ( (lv_after_15_0= ruleAfter ) )? )
            {
            // InternalXtextTest.g:167:1: ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )? (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )? ( (lv_input_10_0= ruleInput ) ) ( (lv_tokens_11_0= ruleTokens ) )? ( (lv_root_12_0= ruleElement ) ) ( (lv_output_13_0= ruleGenerator ) )? ( (lv_before_14_0= ruleBefore ) )? ( (lv_after_15_0= ruleAfter ) )? )
            // InternalXtextTest.g:168:1: () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )? (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )? ( (lv_input_10_0= ruleInput ) ) ( (lv_tokens_11_0= ruleTokens ) )? ( (lv_root_12_0= ruleElement ) ) ( (lv_output_13_0= ruleGenerator ) )? ( (lv_before_14_0= ruleBefore ) )? ( (lv_after_15_0= ruleAfter ) )?
            {
            // InternalXtextTest.g:168:1: ()
            // InternalXtextTest.g:169:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getXtextTestAccess().getXtextTestAction_0(),
                        current);
                

            }

            this_PACKAGE_1=(Token)match(input,RULE_PACKAGE,FOLLOW_3); 
             
                newLeafNode(this_PACKAGE_1, grammarAccess.getXtextTestAccess().getPACKAGETerminalRuleCall_1()); 
                
            // InternalXtextTest.g:184:1: ( (lv_package_2_0= rulePackageID ) )
            // InternalXtextTest.g:185:1: (lv_package_2_0= rulePackageID )
            {
            // InternalXtextTest.g:185:1: (lv_package_2_0= rulePackageID )
            // InternalXtextTest.g:186:3: lv_package_2_0= rulePackageID
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
                
            // InternalXtextTest.g:212:1: ( (lv_lang_4_0= ruleLangID ) )
            // InternalXtextTest.g:213:1: (lv_lang_4_0= ruleLangID )
            {
            // InternalXtextTest.g:213:1: (lv_lang_4_0= ruleLangID )
            // InternalXtextTest.g:214:3: lv_lang_4_0= ruleLangID
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

            // InternalXtextTest.g:233:1: (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_IMPORTS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalXtextTest.g:234:1: this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) )
                    {
                    this_IMPORTS_5=(Token)match(input,RULE_IMPORTS,FOLLOW_3); 
                     
                        newLeafNode(this_IMPORTS_5, grammarAccess.getXtextTestAccess().getIMPORTSTerminalRuleCall_5_0()); 
                        
                    // InternalXtextTest.g:241:1: ( (lv_imports_6_0= ruleImportID ) )
                    // InternalXtextTest.g:242:1: (lv_imports_6_0= ruleImportID )
                    {
                    // InternalXtextTest.g:242:1: (lv_imports_6_0= ruleImportID )
                    // InternalXtextTest.g:243:3: lv_imports_6_0= ruleImportID
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

            // InternalXtextTest.g:264:1: (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_SPLITLEXER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalXtextTest.g:265:1: this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) )
                    {
                    this_SPLITLEXER_7=(Token)match(input,RULE_SPLITLEXER,FOLLOW_6); 
                     
                        newLeafNode(this_SPLITLEXER_7, grammarAccess.getXtextTestAccess().getSPLITLEXERTerminalRuleCall_6_0()); 
                        
                    this_ASSIGNASSINGLE_8=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_7); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_8, grammarAccess.getXtextTestAccess().getASSIGNASSINGLETerminalRuleCall_6_1()); 
                        
                    // InternalXtextTest.g:279:1: ( (lv_boolean_9_0= ruleBoolean ) )
                    // InternalXtextTest.g:280:1: (lv_boolean_9_0= ruleBoolean )
                    {
                    // InternalXtextTest.g:280:1: (lv_boolean_9_0= ruleBoolean )
                    // InternalXtextTest.g:281:3: lv_boolean_9_0= ruleBoolean
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

            // InternalXtextTest.g:302:1: ( (lv_input_10_0= ruleInput ) )
            // InternalXtextTest.g:303:1: (lv_input_10_0= ruleInput )
            {
            // InternalXtextTest.g:303:1: (lv_input_10_0= ruleInput )
            // InternalXtextTest.g:304:3: lv_input_10_0= ruleInput
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

            // InternalXtextTest.g:323:1: ( (lv_tokens_11_0= ruleTokens ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_LEXER) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalXtextTest.g:324:1: (lv_tokens_11_0= ruleTokens )
                    {
                    // InternalXtextTest.g:324:1: (lv_tokens_11_0= ruleTokens )
                    // InternalXtextTest.g:325:3: lv_tokens_11_0= ruleTokens
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getTokensTokensParserRuleCall_8_0()); 
                    	    
                    pushFollow(FOLLOW_8);
                    lv_tokens_11_0=ruleTokens();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"tokens",
                            		lv_tokens_11_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Tokens");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalXtextTest.g:344:1: ( (lv_root_12_0= ruleElement ) )
            // InternalXtextTest.g:345:1: (lv_root_12_0= ruleElement )
            {
            // InternalXtextTest.g:345:1: (lv_root_12_0= ruleElement )
            // InternalXtextTest.g:346:3: lv_root_12_0= ruleElement
            {
             
            	        newCompositeNode(grammarAccess.getXtextTestAccess().getRootElementParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_9);
            lv_root_12_0=ruleElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
            	        }
                   		set(
                   			current, 
                   			"root",
                    		lv_root_12_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.Element");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalXtextTest.g:365:1: ( (lv_output_13_0= ruleGenerator ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_OUTPUT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalXtextTest.g:366:1: (lv_output_13_0= ruleGenerator )
                    {
                    // InternalXtextTest.g:366:1: (lv_output_13_0= ruleGenerator )
                    // InternalXtextTest.g:367:3: lv_output_13_0= ruleGenerator
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getOutputGeneratorParserRuleCall_10_0()); 
                    	    
                    pushFollow(FOLLOW_10);
                    lv_output_13_0=ruleGenerator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"output",
                            		lv_output_13_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Generator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalXtextTest.g:386:1: ( (lv_before_14_0= ruleBefore ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_BEFORE_KW) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalXtextTest.g:387:1: (lv_before_14_0= ruleBefore )
                    {
                    // InternalXtextTest.g:387:1: (lv_before_14_0= ruleBefore )
                    // InternalXtextTest.g:388:3: lv_before_14_0= ruleBefore
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getBeforeBeforeParserRuleCall_11_0()); 
                    	    
                    pushFollow(FOLLOW_11);
                    lv_before_14_0=ruleBefore();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"before",
                            		lv_before_14_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Before");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalXtextTest.g:407:1: ( (lv_after_15_0= ruleAfter ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_AFTER_KW) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalXtextTest.g:408:1: (lv_after_15_0= ruleAfter )
                    {
                    // InternalXtextTest.g:408:1: (lv_after_15_0= ruleAfter )
                    // InternalXtextTest.g:409:3: lv_after_15_0= ruleAfter
                    {
                     
                    	        newCompositeNode(grammarAccess.getXtextTestAccess().getAfterAfterParserRuleCall_12_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_after_15_0=ruleAfter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getXtextTestRule());
                    	        }
                           		set(
                           			current, 
                           			"after",
                            		lv_after_15_0, 
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


    // $ANTLR start "entryRuleEmfTest"
    // InternalXtextTest.g:437:1: entryRuleEmfTest returns [EObject current=null] : iv_ruleEmfTest= ruleEmfTest EOF ;
    public final EObject entryRuleEmfTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmfTest = null;


        try {
            // InternalXtextTest.g:438:2: (iv_ruleEmfTest= ruleEmfTest EOF )
            // InternalXtextTest.g:439:2: iv_ruleEmfTest= ruleEmfTest EOF
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
    // InternalXtextTest.g:446:1: ruleEmfTest returns [EObject current=null] : ( () this_KW_EMFTEST_1= RULE_KW_EMFTEST this_PACKAGE_2= RULE_PACKAGE ( (lv_package_3_0= rulePackageID ) ) this_DEFAULT_4= RULE_DEFAULT ( (lv_mydefault_5_0= rulePackageID ) ) ( (lv_myimport_6_0= ruleImport ) )* ( (lv_codeCall_7_0= ruleCodeCall ) ) (this_OPTIONS_8= RULE_OPTIONS ( (lv_optionCall_9_0= ruleCodeCall ) ) )? (this_SOURCE_10= RULE_SOURCE this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_file_13_0= RULE_STRING ) ) ) ( (lv_root_14_0= ruleElement ) ) ( (lv_before_15_0= ruleBefore ) )? ( (lv_after_16_0= ruleAfter ) )? ) ;
    public final EObject ruleEmfTest() throws RecognitionException {
        EObject current = null;

        Token this_KW_EMFTEST_1=null;
        Token this_PACKAGE_2=null;
        Token this_DEFAULT_4=null;
        Token this_OPTIONS_8=null;
        Token this_SOURCE_10=null;
        Token this_FILE_11=null;
        Token this_ASSIGNASSINGLE_12=null;
        Token lv_file_13_0=null;
        AntlrDatatypeRuleToken lv_package_3_0 = null;

        AntlrDatatypeRuleToken lv_mydefault_5_0 = null;

        EObject lv_myimport_6_0 = null;

        EObject lv_codeCall_7_0 = null;

        EObject lv_optionCall_9_0 = null;

        EObject lv_root_14_0 = null;

        EObject lv_before_15_0 = null;

        EObject lv_after_16_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:452:7: ( ( () this_KW_EMFTEST_1= RULE_KW_EMFTEST this_PACKAGE_2= RULE_PACKAGE ( (lv_package_3_0= rulePackageID ) ) this_DEFAULT_4= RULE_DEFAULT ( (lv_mydefault_5_0= rulePackageID ) ) ( (lv_myimport_6_0= ruleImport ) )* ( (lv_codeCall_7_0= ruleCodeCall ) ) (this_OPTIONS_8= RULE_OPTIONS ( (lv_optionCall_9_0= ruleCodeCall ) ) )? (this_SOURCE_10= RULE_SOURCE this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_file_13_0= RULE_STRING ) ) ) ( (lv_root_14_0= ruleElement ) ) ( (lv_before_15_0= ruleBefore ) )? ( (lv_after_16_0= ruleAfter ) )? ) )
            // InternalXtextTest.g:454:1: ( () this_KW_EMFTEST_1= RULE_KW_EMFTEST this_PACKAGE_2= RULE_PACKAGE ( (lv_package_3_0= rulePackageID ) ) this_DEFAULT_4= RULE_DEFAULT ( (lv_mydefault_5_0= rulePackageID ) ) ( (lv_myimport_6_0= ruleImport ) )* ( (lv_codeCall_7_0= ruleCodeCall ) ) (this_OPTIONS_8= RULE_OPTIONS ( (lv_optionCall_9_0= ruleCodeCall ) ) )? (this_SOURCE_10= RULE_SOURCE this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_file_13_0= RULE_STRING ) ) ) ( (lv_root_14_0= ruleElement ) ) ( (lv_before_15_0= ruleBefore ) )? ( (lv_after_16_0= ruleAfter ) )? )
            {
            // InternalXtextTest.g:454:1: ( () this_KW_EMFTEST_1= RULE_KW_EMFTEST this_PACKAGE_2= RULE_PACKAGE ( (lv_package_3_0= rulePackageID ) ) this_DEFAULT_4= RULE_DEFAULT ( (lv_mydefault_5_0= rulePackageID ) ) ( (lv_myimport_6_0= ruleImport ) )* ( (lv_codeCall_7_0= ruleCodeCall ) ) (this_OPTIONS_8= RULE_OPTIONS ( (lv_optionCall_9_0= ruleCodeCall ) ) )? (this_SOURCE_10= RULE_SOURCE this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_file_13_0= RULE_STRING ) ) ) ( (lv_root_14_0= ruleElement ) ) ( (lv_before_15_0= ruleBefore ) )? ( (lv_after_16_0= ruleAfter ) )? )
            // InternalXtextTest.g:455:1: () this_KW_EMFTEST_1= RULE_KW_EMFTEST this_PACKAGE_2= RULE_PACKAGE ( (lv_package_3_0= rulePackageID ) ) this_DEFAULT_4= RULE_DEFAULT ( (lv_mydefault_5_0= rulePackageID ) ) ( (lv_myimport_6_0= ruleImport ) )* ( (lv_codeCall_7_0= ruleCodeCall ) ) (this_OPTIONS_8= RULE_OPTIONS ( (lv_optionCall_9_0= ruleCodeCall ) ) )? (this_SOURCE_10= RULE_SOURCE this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_file_13_0= RULE_STRING ) ) ) ( (lv_root_14_0= ruleElement ) ) ( (lv_before_15_0= ruleBefore ) )? ( (lv_after_16_0= ruleAfter ) )?
            {
            // InternalXtextTest.g:455:1: ()
            // InternalXtextTest.g:456:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEmfTestAccess().getEmfTestAction_0(),
                        current);
                

            }

            this_KW_EMFTEST_1=(Token)match(input,RULE_KW_EMFTEST,FOLLOW_12); 
             
                newLeafNode(this_KW_EMFTEST_1, grammarAccess.getEmfTestAccess().getKW_EMFTESTTerminalRuleCall_1()); 
                
            this_PACKAGE_2=(Token)match(input,RULE_PACKAGE,FOLLOW_3); 
             
                newLeafNode(this_PACKAGE_2, grammarAccess.getEmfTestAccess().getPACKAGETerminalRuleCall_2()); 
                
            // InternalXtextTest.g:478:1: ( (lv_package_3_0= rulePackageID ) )
            // InternalXtextTest.g:479:1: (lv_package_3_0= rulePackageID )
            {
            // InternalXtextTest.g:479:1: (lv_package_3_0= rulePackageID )
            // InternalXtextTest.g:480:3: lv_package_3_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getEmfTestAccess().getPackagePackageIDParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_13);
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
                
            // InternalXtextTest.g:506:1: ( (lv_mydefault_5_0= rulePackageID ) )
            // InternalXtextTest.g:507:1: (lv_mydefault_5_0= rulePackageID )
            {
            // InternalXtextTest.g:507:1: (lv_mydefault_5_0= rulePackageID )
            // InternalXtextTest.g:508:3: lv_mydefault_5_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getEmfTestAccess().getMydefaultPackageIDParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_14);
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

            // InternalXtextTest.g:527:1: ( (lv_myimport_6_0= ruleImport ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_IMPORTS) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalXtextTest.g:528:1: (lv_myimport_6_0= ruleImport )
            	    {
            	    // InternalXtextTest.g:528:1: (lv_myimport_6_0= ruleImport )
            	    // InternalXtextTest.g:529:3: lv_myimport_6_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEmfTestAccess().getMyimportImportParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_14);
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
            	    break loop8;
                }
            } while (true);

            // InternalXtextTest.g:548:1: ( (lv_codeCall_7_0= ruleCodeCall ) )
            // InternalXtextTest.g:549:1: (lv_codeCall_7_0= ruleCodeCall )
            {
            // InternalXtextTest.g:549:1: (lv_codeCall_7_0= ruleCodeCall )
            // InternalXtextTest.g:550:3: lv_codeCall_7_0= ruleCodeCall
            {
             
            	        newCompositeNode(grammarAccess.getEmfTestAccess().getCodeCallCodeCallParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_15);
            lv_codeCall_7_0=ruleCodeCall();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEmfTestRule());
            	        }
                   		set(
                   			current, 
                   			"codeCall",
                    		lv_codeCall_7_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.CodeCall");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalXtextTest.g:569:1: (this_OPTIONS_8= RULE_OPTIONS ( (lv_optionCall_9_0= ruleCodeCall ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_OPTIONS) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalXtextTest.g:570:1: this_OPTIONS_8= RULE_OPTIONS ( (lv_optionCall_9_0= ruleCodeCall ) )
                    {
                    this_OPTIONS_8=(Token)match(input,RULE_OPTIONS,FOLLOW_14); 
                     
                        newLeafNode(this_OPTIONS_8, grammarAccess.getEmfTestAccess().getOPTIONSTerminalRuleCall_8_0()); 
                        
                    // InternalXtextTest.g:577:1: ( (lv_optionCall_9_0= ruleCodeCall ) )
                    // InternalXtextTest.g:578:1: (lv_optionCall_9_0= ruleCodeCall )
                    {
                    // InternalXtextTest.g:578:1: (lv_optionCall_9_0= ruleCodeCall )
                    // InternalXtextTest.g:579:3: lv_optionCall_9_0= ruleCodeCall
                    {
                     
                    	        newCompositeNode(grammarAccess.getEmfTestAccess().getOptionCallCodeCallParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_16);
                    lv_optionCall_9_0=ruleCodeCall();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEmfTestRule());
                    	        }
                           		set(
                           			current, 
                           			"optionCall",
                            		lv_optionCall_9_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.CodeCall");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalXtextTest.g:600:1: (this_SOURCE_10= RULE_SOURCE this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_file_13_0= RULE_STRING ) ) )
            // InternalXtextTest.g:601:1: this_SOURCE_10= RULE_SOURCE this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_file_13_0= RULE_STRING ) )
            {
            this_SOURCE_10=(Token)match(input,RULE_SOURCE,FOLLOW_17); 
             
                newLeafNode(this_SOURCE_10, grammarAccess.getEmfTestAccess().getSOURCETerminalRuleCall_9_0()); 
                
            this_FILE_11=(Token)match(input,RULE_FILE,FOLLOW_6); 
             
                newLeafNode(this_FILE_11, grammarAccess.getEmfTestAccess().getFILETerminalRuleCall_9_1()); 
                
            this_ASSIGNASSINGLE_12=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_18); 
             
                newLeafNode(this_ASSIGNASSINGLE_12, grammarAccess.getEmfTestAccess().getASSIGNASSINGLETerminalRuleCall_9_2()); 
                
            // InternalXtextTest.g:622:1: ( (lv_file_13_0= RULE_STRING ) )
            // InternalXtextTest.g:623:1: (lv_file_13_0= RULE_STRING )
            {
            // InternalXtextTest.g:623:1: (lv_file_13_0= RULE_STRING )
            // InternalXtextTest.g:624:3: lv_file_13_0= RULE_STRING
            {
            lv_file_13_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            			newLeafNode(lv_file_13_0, grammarAccess.getEmfTestAccess().getFileSTRINGTerminalRuleCall_9_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEmfTestRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"file",
                    		lv_file_13_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }


            }

            // InternalXtextTest.g:645:1: ( (lv_root_14_0= ruleElement ) )
            // InternalXtextTest.g:646:1: (lv_root_14_0= ruleElement )
            {
            // InternalXtextTest.g:646:1: (lv_root_14_0= ruleElement )
            // InternalXtextTest.g:647:3: lv_root_14_0= ruleElement
            {
             
            	        newCompositeNode(grammarAccess.getEmfTestAccess().getRootElementParserRuleCall_10_0()); 
            	    
            pushFollow(FOLLOW_10);
            lv_root_14_0=ruleElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEmfTestRule());
            	        }
                   		set(
                   			current, 
                   			"root",
                    		lv_root_14_0, 
                    		"at.jku.weiner.xtexttest.XtextTest.Element");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalXtextTest.g:666:1: ( (lv_before_15_0= ruleBefore ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_BEFORE_KW) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalXtextTest.g:667:1: (lv_before_15_0= ruleBefore )
                    {
                    // InternalXtextTest.g:667:1: (lv_before_15_0= ruleBefore )
                    // InternalXtextTest.g:668:3: lv_before_15_0= ruleBefore
                    {
                     
                    	        newCompositeNode(grammarAccess.getEmfTestAccess().getBeforeBeforeParserRuleCall_11_0()); 
                    	    
                    pushFollow(FOLLOW_11);
                    lv_before_15_0=ruleBefore();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEmfTestRule());
                    	        }
                           		set(
                           			current, 
                           			"before",
                            		lv_before_15_0, 
                            		"at.jku.weiner.xtexttest.XtextTest.Before");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalXtextTest.g:687:1: ( (lv_after_16_0= ruleAfter ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_AFTER_KW) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalXtextTest.g:688:1: (lv_after_16_0= ruleAfter )
                    {
                    // InternalXtextTest.g:688:1: (lv_after_16_0= ruleAfter )
                    // InternalXtextTest.g:689:3: lv_after_16_0= ruleAfter
                    {
                     
                    	        newCompositeNode(grammarAccess.getEmfTestAccess().getAfterAfterParserRuleCall_12_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_after_16_0=ruleAfter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEmfTestRule());
                    	        }
                           		set(
                           			current, 
                           			"after",
                            		lv_after_16_0, 
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
    // $ANTLR end "ruleEmfTest"


    // $ANTLR start "entryRuleImport"
    // InternalXtextTest.g:717:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalXtextTest.g:718:2: (iv_ruleImport= ruleImport EOF )
            // InternalXtextTest.g:719:2: iv_ruleImport= ruleImport EOF
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
    // InternalXtextTest.g:726:1: ruleImport returns [EObject current=null] : ( () this_IMPORTS_1= RULE_IMPORTS ( (lv_id_2_0= ruleImportID ) ) this_KW_AS_3= RULE_KW_AS ( (lv_alias_4_0= RULE_IDENTIFIER ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token this_IMPORTS_1=null;
        Token this_KW_AS_3=null;
        Token lv_alias_4_0=null;
        AntlrDatatypeRuleToken lv_id_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:732:7: ( ( () this_IMPORTS_1= RULE_IMPORTS ( (lv_id_2_0= ruleImportID ) ) this_KW_AS_3= RULE_KW_AS ( (lv_alias_4_0= RULE_IDENTIFIER ) ) ) )
            // InternalXtextTest.g:734:1: ( () this_IMPORTS_1= RULE_IMPORTS ( (lv_id_2_0= ruleImportID ) ) this_KW_AS_3= RULE_KW_AS ( (lv_alias_4_0= RULE_IDENTIFIER ) ) )
            {
            // InternalXtextTest.g:734:1: ( () this_IMPORTS_1= RULE_IMPORTS ( (lv_id_2_0= ruleImportID ) ) this_KW_AS_3= RULE_KW_AS ( (lv_alias_4_0= RULE_IDENTIFIER ) ) )
            // InternalXtextTest.g:735:1: () this_IMPORTS_1= RULE_IMPORTS ( (lv_id_2_0= ruleImportID ) ) this_KW_AS_3= RULE_KW_AS ( (lv_alias_4_0= RULE_IDENTIFIER ) )
            {
            // InternalXtextTest.g:735:1: ()
            // InternalXtextTest.g:736:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getImportAccess().getImportAction_0(),
                        current);
                

            }

            this_IMPORTS_1=(Token)match(input,RULE_IMPORTS,FOLLOW_3); 
             
                newLeafNode(this_IMPORTS_1, grammarAccess.getImportAccess().getIMPORTSTerminalRuleCall_1()); 
                
            // InternalXtextTest.g:751:1: ( (lv_id_2_0= ruleImportID ) )
            // InternalXtextTest.g:752:1: (lv_id_2_0= ruleImportID )
            {
            // InternalXtextTest.g:752:1: (lv_id_2_0= ruleImportID )
            // InternalXtextTest.g:753:3: lv_id_2_0= ruleImportID
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getIdImportIDParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_19);
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
                
            // InternalXtextTest.g:779:1: ( (lv_alias_4_0= RULE_IDENTIFIER ) )
            // InternalXtextTest.g:780:1: (lv_alias_4_0= RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:780:1: (lv_alias_4_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:781:3: lv_alias_4_0= RULE_IDENTIFIER
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleBoolean"
    // InternalXtextTest.g:809:1: entryRuleBoolean returns [String current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final String entryRuleBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBoolean = null;


        try {
            // InternalXtextTest.g:810:2: (iv_ruleBoolean= ruleBoolean EOF )
            // InternalXtextTest.g:811:2: iv_ruleBoolean= ruleBoolean EOF
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
    // InternalXtextTest.g:818:1: ruleBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_TRUE_0= RULE_TRUE | this_FALSE_1= RULE_FALSE ) ;
    public final AntlrDatatypeRuleToken ruleBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_TRUE_0=null;
        Token this_FALSE_1=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:821:28: ( (this_TRUE_0= RULE_TRUE | this_FALSE_1= RULE_FALSE ) )
            // InternalXtextTest.g:822:1: (this_TRUE_0= RULE_TRUE | this_FALSE_1= RULE_FALSE )
            {
            // InternalXtextTest.g:822:1: (this_TRUE_0= RULE_TRUE | this_FALSE_1= RULE_FALSE )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_TRUE) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_FALSE) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalXtextTest.g:822:6: this_TRUE_0= RULE_TRUE
                    {
                    this_TRUE_0=(Token)match(input,RULE_TRUE,FOLLOW_2); 

                    		current.merge(this_TRUE_0);
                        
                     
                        newLeafNode(this_TRUE_0, grammarAccess.getBooleanAccess().getTRUETerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:830:10: this_FALSE_1= RULE_FALSE
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
    // InternalXtextTest.g:845:1: entryRulePackageID returns [String current=null] : iv_rulePackageID= rulePackageID EOF ;
    public final String entryRulePackageID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePackageID = null;


        try {
            // InternalXtextTest.g:846:2: (iv_rulePackageID= rulePackageID EOF )
            // InternalXtextTest.g:847:2: iv_rulePackageID= rulePackageID EOF
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
    // InternalXtextTest.g:854:1: rulePackageID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* ) ;
    public final AntlrDatatypeRuleToken rulePackageID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IDENTIFIER_0=null;
        Token this_POINT_1=null;
        Token this_IDENTIFIER_2=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:857:28: ( (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* ) )
            // InternalXtextTest.g:858:1: (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* )
            {
            // InternalXtextTest.g:858:1: (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* )
            // InternalXtextTest.g:858:6: this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )*
            {
            this_IDENTIFIER_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_20); 

            		current.merge(this_IDENTIFIER_0);
                
             
                newLeafNode(this_IDENTIFIER_0, grammarAccess.getPackageIDAccess().getIDENTIFIERTerminalRuleCall_0()); 
                
            // InternalXtextTest.g:865:1: (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_POINT) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalXtextTest.g:865:6: this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER
            	    {
            	    this_POINT_1=(Token)match(input,RULE_POINT,FOLLOW_3); 

            	    		current.merge(this_POINT_1);
            	        
            	     
            	        newLeafNode(this_POINT_1, grammarAccess.getPackageIDAccess().getPOINTTerminalRuleCall_1_0()); 
            	        
            	    this_IDENTIFIER_2=(Token)match(input,RULE_IDENTIFIER,FOLLOW_20); 

            	    		current.merge(this_IDENTIFIER_2);
            	        
            	     
            	        newLeafNode(this_IDENTIFIER_2, grammarAccess.getPackageIDAccess().getIDENTIFIERTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // InternalXtextTest.g:887:1: entryRuleLangID returns [String current=null] : iv_ruleLangID= ruleLangID EOF ;
    public final String entryRuleLangID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLangID = null;


        try {
            // InternalXtextTest.g:888:2: (iv_ruleLangID= ruleLangID EOF )
            // InternalXtextTest.g:889:2: iv_ruleLangID= ruleLangID EOF
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
    // InternalXtextTest.g:896:1: ruleLangID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_IDENTIFIER_0= RULE_IDENTIFIER ;
    public final AntlrDatatypeRuleToken ruleLangID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IDENTIFIER_0=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:899:28: (this_IDENTIFIER_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:900:5: this_IDENTIFIER_0= RULE_IDENTIFIER
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
    // InternalXtextTest.g:915:1: entryRuleImportID returns [String current=null] : iv_ruleImportID= ruleImportID EOF ;
    public final String entryRuleImportID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportID = null;


        try {
            // InternalXtextTest.g:916:2: (iv_ruleImportID= ruleImportID EOF )
            // InternalXtextTest.g:917:2: iv_ruleImportID= ruleImportID EOF
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
    // InternalXtextTest.g:924:1: ruleImportID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* ) ;
    public final AntlrDatatypeRuleToken ruleImportID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IDENTIFIER_0=null;
        Token this_POINT_1=null;
        Token this_IDENTIFIER_2=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:927:28: ( (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* ) )
            // InternalXtextTest.g:928:1: (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* )
            {
            // InternalXtextTest.g:928:1: (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* )
            // InternalXtextTest.g:928:6: this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )*
            {
            this_IDENTIFIER_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_20); 

            		current.merge(this_IDENTIFIER_0);
                
             
                newLeafNode(this_IDENTIFIER_0, grammarAccess.getImportIDAccess().getIDENTIFIERTerminalRuleCall_0()); 
                
            // InternalXtextTest.g:935:1: (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_POINT) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalXtextTest.g:935:6: this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER
            	    {
            	    this_POINT_1=(Token)match(input,RULE_POINT,FOLLOW_3); 

            	    		current.merge(this_POINT_1);
            	        
            	     
            	        newLeafNode(this_POINT_1, grammarAccess.getImportIDAccess().getPOINTTerminalRuleCall_1_0()); 
            	        
            	    this_IDENTIFIER_2=(Token)match(input,RULE_IDENTIFIER,FOLLOW_20); 

            	    		current.merge(this_IDENTIFIER_2);
            	        
            	     
            	        newLeafNode(this_IDENTIFIER_2, grammarAccess.getImportIDAccess().getIDENTIFIERTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // InternalXtextTest.g:957:1: entryRuleInput returns [EObject current=null] : iv_ruleInput= ruleInput EOF ;
    public final EObject entryRuleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInput = null;


        try {
            // InternalXtextTest.g:958:2: (iv_ruleInput= ruleInput EOF )
            // InternalXtextTest.g:959:2: iv_ruleInput= ruleInput EOF
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
    // InternalXtextTest.g:966:1: ruleInput returns [EObject current=null] : ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) ) ;
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
            // InternalXtextTest.g:972:7: ( ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) ) )
            // InternalXtextTest.g:974:1: ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) )
            {
            // InternalXtextTest.g:974:1: ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) )
            // InternalXtextTest.g:975:1: () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) )
            {
            // InternalXtextTest.g:975:1: ()
            // InternalXtextTest.g:976:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInputAccess().getInputAction_0(),
                        current);
                

            }

            this_SOURCE_1=(Token)match(input,RULE_SOURCE,FOLLOW_21); 
             
                newLeafNode(this_SOURCE_1, grammarAccess.getInputAccess().getSOURCETerminalRuleCall_1()); 
                
            // InternalXtextTest.g:991:1: ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_SRCTEXT) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_FILE) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalXtextTest.g:992:1: (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:992:1: (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:993:1: this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) )
                    {
                    this_SRCTEXT_2=(Token)match(input,RULE_SRCTEXT,FOLLOW_6); 
                     
                        newLeafNode(this_SRCTEXT_2, grammarAccess.getInputAccess().getSRCTEXTTerminalRuleCall_2_0_0()); 
                        
                    this_ASSIGNASSINGLE_3=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_18); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_3, grammarAccess.getInputAccess().getASSIGNASSINGLETerminalRuleCall_2_0_1()); 
                        
                    // InternalXtextTest.g:1007:1: ( (lv_text_4_0= RULE_STRING ) )
                    // InternalXtextTest.g:1008:1: (lv_text_4_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1008:1: (lv_text_4_0= RULE_STRING )
                    // InternalXtextTest.g:1009:3: lv_text_4_0= RULE_STRING
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
                    // InternalXtextTest.g:1031:1: (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:1031:1: (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:1032:1: this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) )
                    {
                    this_FILE_5=(Token)match(input,RULE_FILE,FOLLOW_6); 
                     
                        newLeafNode(this_FILE_5, grammarAccess.getInputAccess().getFILETerminalRuleCall_2_1_0()); 
                        
                    this_ASSIGNASSINGLE_6=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_18); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_6, grammarAccess.getInputAccess().getASSIGNASSINGLETerminalRuleCall_2_1_1()); 
                        
                    // InternalXtextTest.g:1046:1: ( (lv_file_7_0= RULE_STRING ) )
                    // InternalXtextTest.g:1047:1: (lv_file_7_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1047:1: (lv_file_7_0= RULE_STRING )
                    // InternalXtextTest.g:1048:3: lv_file_7_0= RULE_STRING
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
    // InternalXtextTest.g:1080:1: entryRuleTokens returns [EObject current=null] : iv_ruleTokens= ruleTokens EOF ;
    public final EObject entryRuleTokens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTokens = null;


        try {
            // InternalXtextTest.g:1081:2: (iv_ruleTokens= ruleTokens EOF )
            // InternalXtextTest.g:1082:2: iv_ruleTokens= ruleTokens EOF
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
    // InternalXtextTest.g:1089:1: ruleTokens returns [EObject current=null] : ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+ ) ;
    public final EObject ruleTokens() throws RecognitionException {
        EObject current = null;

        Token this_LEXER_1=null;
        EObject lv_tokens_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:1095:7: ( ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+ ) )
            // InternalXtextTest.g:1097:1: ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+ )
            {
            // InternalXtextTest.g:1097:1: ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+ )
            // InternalXtextTest.g:1098:1: () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+
            {
            // InternalXtextTest.g:1098:1: ()
            // InternalXtextTest.g:1099:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTokensAccess().getTokensAction_0(),
                        current);
                

            }

            this_LEXER_1=(Token)match(input,RULE_LEXER,FOLLOW_22); 
             
                newLeafNode(this_LEXER_1, grammarAccess.getTokensAccess().getLEXERTerminalRuleCall_1()); 
                
            // InternalXtextTest.g:1114:1: ( (lv_tokens_2_0= ruleMyTokens ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_STRING||LA16_0==RULE_IDENTIFIER) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalXtextTest.g:1115:1: (lv_tokens_2_0= ruleMyTokens )
            	    {
            	    // InternalXtextTest.g:1115:1: (lv_tokens_2_0= ruleMyTokens )
            	    // InternalXtextTest.g:1116:3: lv_tokens_2_0= ruleMyTokens
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTokensAccess().getTokensMyTokensParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_23);
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
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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
    // InternalXtextTest.g:1144:1: entryRuleMyTokens returns [EObject current=null] : iv_ruleMyTokens= ruleMyTokens EOF ;
    public final EObject entryRuleMyTokens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyTokens = null;


        try {
            // InternalXtextTest.g:1145:2: (iv_ruleMyTokens= ruleMyTokens EOF )
            // InternalXtextTest.g:1146:2: iv_ruleMyTokens= ruleMyTokens EOF
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
    // InternalXtextTest.g:1153:1: ruleMyTokens returns [EObject current=null] : ( ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) | ( (lv_string_1_0= RULE_STRING ) ) ) (this_ASSIGNASDATALIST_2= RULE_ASSIGNASDATALIST ( (lv_count_3_0= RULE_INT ) ) )? ) ;
    public final EObject ruleMyTokens() throws RecognitionException {
        EObject current = null;

        Token lv_token_0_0=null;
        Token lv_string_1_0=null;
        Token this_ASSIGNASDATALIST_2=null;
        Token lv_count_3_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:1159:7: ( ( ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) | ( (lv_string_1_0= RULE_STRING ) ) ) (this_ASSIGNASDATALIST_2= RULE_ASSIGNASDATALIST ( (lv_count_3_0= RULE_INT ) ) )? ) )
            // InternalXtextTest.g:1161:1: ( ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) | ( (lv_string_1_0= RULE_STRING ) ) ) (this_ASSIGNASDATALIST_2= RULE_ASSIGNASDATALIST ( (lv_count_3_0= RULE_INT ) ) )? )
            {
            // InternalXtextTest.g:1161:1: ( ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) | ( (lv_string_1_0= RULE_STRING ) ) ) (this_ASSIGNASDATALIST_2= RULE_ASSIGNASDATALIST ( (lv_count_3_0= RULE_INT ) ) )? )
            // InternalXtextTest.g:1162:1: ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) | ( (lv_string_1_0= RULE_STRING ) ) ) (this_ASSIGNASDATALIST_2= RULE_ASSIGNASDATALIST ( (lv_count_3_0= RULE_INT ) ) )?
            {
            // InternalXtextTest.g:1162:1: ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) | ( (lv_string_1_0= RULE_STRING ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_IDENTIFIER) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_STRING) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalXtextTest.g:1163:1: ( (lv_token_0_0= RULE_IDENTIFIER ) )
                    {
                    // InternalXtextTest.g:1163:1: ( (lv_token_0_0= RULE_IDENTIFIER ) )
                    // InternalXtextTest.g:1164:1: (lv_token_0_0= RULE_IDENTIFIER )
                    {
                    // InternalXtextTest.g:1164:1: (lv_token_0_0= RULE_IDENTIFIER )
                    // InternalXtextTest.g:1165:3: lv_token_0_0= RULE_IDENTIFIER
                    {
                    lv_token_0_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_24); 

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
                    // InternalXtextTest.g:1185:1: ( (lv_string_1_0= RULE_STRING ) )
                    {
                    // InternalXtextTest.g:1185:1: ( (lv_string_1_0= RULE_STRING ) )
                    // InternalXtextTest.g:1186:1: (lv_string_1_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1186:1: (lv_string_1_0= RULE_STRING )
                    // InternalXtextTest.g:1187:3: lv_string_1_0= RULE_STRING
                    {
                    lv_string_1_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

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

            // InternalXtextTest.g:1208:1: (this_ASSIGNASDATALIST_2= RULE_ASSIGNASDATALIST ( (lv_count_3_0= RULE_INT ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ASSIGNASDATALIST) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalXtextTest.g:1209:1: this_ASSIGNASDATALIST_2= RULE_ASSIGNASDATALIST ( (lv_count_3_0= RULE_INT ) )
                    {
                    this_ASSIGNASDATALIST_2=(Token)match(input,RULE_ASSIGNASDATALIST,FOLLOW_25); 
                     
                        newLeafNode(this_ASSIGNASDATALIST_2, grammarAccess.getMyTokensAccess().getASSIGNASDATALISTTerminalRuleCall_1_0()); 
                        
                    // InternalXtextTest.g:1216:1: ( (lv_count_3_0= RULE_INT ) )
                    // InternalXtextTest.g:1217:1: (lv_count_3_0= RULE_INT )
                    {
                    // InternalXtextTest.g:1217:1: (lv_count_3_0= RULE_INT )
                    // InternalXtextTest.g:1218:3: lv_count_3_0= RULE_INT
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
    // InternalXtextTest.g:1248:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalXtextTest.g:1249:2: (iv_ruleElement= ruleElement EOF )
            // InternalXtextTest.g:1250:2: iv_ruleElement= ruleElement EOF
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
    // InternalXtextTest.g:1257:1: ruleElement returns [EObject current=null] : ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )? ( (lv_name_4_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )? this_RIGHTPAREN_8= RULE_RIGHTPAREN ) ;
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
            // InternalXtextTest.g:1263:7: ( ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )? ( (lv_name_4_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )? this_RIGHTPAREN_8= RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:1265:1: ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )? ( (lv_name_4_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )? this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:1265:1: ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )? ( (lv_name_4_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )? this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            // InternalXtextTest.g:1266:1: () this_LEFTPAREN_1= RULE_LEFTPAREN ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )? ( (lv_name_4_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )? this_RIGHTPAREN_8= RULE_RIGHTPAREN
            {
            // InternalXtextTest.g:1266:1: ()
            // InternalXtextTest.g:1267:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getElementAccess().getElementAction_0(),
                        current);
                

            }

            this_LEFTPAREN_1=(Token)match(input,RULE_LEFTPAREN,FOLLOW_3); 
             
                newLeafNode(this_LEFTPAREN_1, grammarAccess.getElementAccess().getLEFTPARENTerminalRuleCall_1()); 
                
            // InternalXtextTest.g:1282:1: ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_IDENTIFIER) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==RULE_IMPORTER) ) {
                    alt19=1;
                }
            }
            switch (alt19) {
                case 1 :
                    // InternalXtextTest.g:1283:1: ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER
                    {
                    // InternalXtextTest.g:1283:1: ( (lv_importing_2_0= RULE_IDENTIFIER ) )
                    // InternalXtextTest.g:1284:1: (lv_importing_2_0= RULE_IDENTIFIER )
                    {
                    // InternalXtextTest.g:1284:1: (lv_importing_2_0= RULE_IDENTIFIER )
                    // InternalXtextTest.g:1285:3: lv_importing_2_0= RULE_IDENTIFIER
                    {
                    lv_importing_2_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_26); 

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

            // InternalXtextTest.g:1313:1: ( (lv_name_4_0= RULE_IDENTIFIER ) )
            // InternalXtextTest.g:1314:1: (lv_name_4_0= RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:1314:1: (lv_name_4_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:1315:3: lv_name_4_0= RULE_IDENTIFIER
            {
            lv_name_4_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_27); 

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

            // InternalXtextTest.g:1334:1: ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_IDENTIFIER) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalXtextTest.g:1335:1: ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )*
                    {
                    // InternalXtextTest.g:1335:1: ( (lv_inner_5_0= ruleInner ) )
                    // InternalXtextTest.g:1336:1: (lv_inner_5_0= ruleInner )
                    {
                    // InternalXtextTest.g:1336:1: (lv_inner_5_0= ruleInner )
                    // InternalXtextTest.g:1337:3: lv_inner_5_0= ruleInner
                    {
                     
                    	        newCompositeNode(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_28);
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

                    // InternalXtextTest.g:1356:1: (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_COMMA) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalXtextTest.g:1357:1: this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) )
                    	    {
                    	    this_COMMA_6=(Token)match(input,RULE_COMMA,FOLLOW_3); 
                    	     
                    	        newLeafNode(this_COMMA_6, grammarAccess.getElementAccess().getCOMMATerminalRuleCall_4_1_0()); 
                    	        
                    	    // InternalXtextTest.g:1364:1: ( (lv_inner_7_0= ruleInner ) )
                    	    // InternalXtextTest.g:1365:1: (lv_inner_7_0= ruleInner )
                    	    {
                    	    // InternalXtextTest.g:1365:1: (lv_inner_7_0= ruleInner )
                    	    // InternalXtextTest.g:1366:3: lv_inner_7_0= ruleInner
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_28);
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
                    	    break loop20;
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
    // InternalXtextTest.g:1405:1: entryRuleInner returns [EObject current=null] : iv_ruleInner= ruleInner EOF ;
    public final EObject entryRuleInner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInner = null;


        try {
            // InternalXtextTest.g:1406:2: (iv_ruleInner= ruleInner EOF )
            // InternalXtextTest.g:1407:2: iv_ruleInner= ruleInner EOF
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
    // InternalXtextTest.g:1414:1: ruleInner returns [EObject current=null] : ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) | ( (lv_isEmpty_16_0= RULE_ISEMPTY ) ) ) ) ;
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
            // InternalXtextTest.g:1420:7: ( ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) | ( (lv_isEmpty_16_0= RULE_ISEMPTY ) ) ) ) )
            // InternalXtextTest.g:1422:1: ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) | ( (lv_isEmpty_16_0= RULE_ISEMPTY ) ) ) )
            {
            // InternalXtextTest.g:1422:1: ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) | ( (lv_isEmpty_16_0= RULE_ISEMPTY ) ) ) )
            // InternalXtextTest.g:1423:1: () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) | ( (lv_isEmpty_16_0= RULE_ISEMPTY ) ) )
            {
            // InternalXtextTest.g:1423:1: ()
            // InternalXtextTest.g:1424:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInnerAccess().getInnerAction_0(),
                        current);
                

            }

            // InternalXtextTest.g:1432:1: ( (lv_parameter_1_0= RULE_IDENTIFIER ) )
            // InternalXtextTest.g:1433:1: (lv_parameter_1_0= RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:1433:1: (lv_parameter_1_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:1434:3: lv_parameter_1_0= RULE_IDENTIFIER
            {
            lv_parameter_1_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_29); 

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

            // InternalXtextTest.g:1453:1: ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) | ( (lv_isEmpty_16_0= RULE_ISEMPTY ) ) )
            int alt24=8;
            switch ( input.LA(1) ) {
            case RULE_ASSIGNASSINGLE:
                {
                alt24=1;
                }
                break;
            case RULE_ASSIGNASLIST:
                {
                alt24=2;
                }
                break;
            case RULE_ASSIGNASSTRING:
                {
                alt24=3;
                }
                break;
            case RULE_ASSIGNASDATALIST:
                {
                alt24=4;
                }
                break;
            case RULE_ASSIGNASBOOL:
                {
                alt24=5;
                }
                break;
            case RULE_ISNULL:
                {
                alt24=6;
                }
                break;
            case RULE_ISNOTNULL:
                {
                alt24=7;
                }
                break;
            case RULE_ISEMPTY:
                {
                alt24=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalXtextTest.g:1454:1: (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) )
                    {
                    // InternalXtextTest.g:1454:1: (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) )
                    // InternalXtextTest.g:1455:1: this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) )
                    {
                    this_ASSIGNASSINGLE_2=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_8); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_2, grammarAccess.getInnerAccess().getASSIGNASSINGLETerminalRuleCall_2_0_0()); 
                        
                    // InternalXtextTest.g:1462:1: ( (lv_assign_3_0= ruleElement ) )
                    // InternalXtextTest.g:1463:1: (lv_assign_3_0= ruleElement )
                    {
                    // InternalXtextTest.g:1463:1: (lv_assign_3_0= ruleElement )
                    // InternalXtextTest.g:1464:3: lv_assign_3_0= ruleElement
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
                    // InternalXtextTest.g:1486:1: (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* )
                    {
                    // InternalXtextTest.g:1486:1: (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* )
                    // InternalXtextTest.g:1487:1: this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )*
                    {
                    this_ASSIGNASLIST_4=(Token)match(input,RULE_ASSIGNASLIST,FOLLOW_8); 
                     
                        newLeafNode(this_ASSIGNASLIST_4, grammarAccess.getInnerAccess().getASSIGNASLISTTerminalRuleCall_2_1_0()); 
                        
                    // InternalXtextTest.g:1494:1: ( (lv_assignList_5_0= ruleElement ) )
                    // InternalXtextTest.g:1495:1: (lv_assignList_5_0= ruleElement )
                    {
                    // InternalXtextTest.g:1495:1: (lv_assignList_5_0= ruleElement )
                    // InternalXtextTest.g:1496:3: lv_assignList_5_0= ruleElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getInnerAccess().getAssignListElementParserRuleCall_2_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_30);
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

                    // InternalXtextTest.g:1515:1: (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==RULE_COMMA) ) {
                            int LA22_1 = input.LA(2);

                            if ( (LA22_1==RULE_LEFTPAREN) ) {
                                alt22=1;
                            }


                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalXtextTest.g:1516:1: this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) )
                    	    {
                    	    this_COMMA_6=(Token)match(input,RULE_COMMA,FOLLOW_8); 
                    	     
                    	        newLeafNode(this_COMMA_6, grammarAccess.getInnerAccess().getCOMMATerminalRuleCall_2_1_2_0()); 
                    	        
                    	    // InternalXtextTest.g:1523:1: ( (lv_assignList_7_0= ruleElement ) )
                    	    // InternalXtextTest.g:1524:1: (lv_assignList_7_0= ruleElement )
                    	    {
                    	    // InternalXtextTest.g:1524:1: (lv_assignList_7_0= ruleElement )
                    	    // InternalXtextTest.g:1525:3: lv_assignList_7_0= ruleElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInnerAccess().getAssignListElementParserRuleCall_2_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_30);
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
                    	    break loop22;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // InternalXtextTest.g:1549:1: (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:1549:1: (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:1550:1: this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) )
                    {
                    this_ASSIGNASSTRING_8=(Token)match(input,RULE_ASSIGNASSTRING,FOLLOW_18); 
                     
                        newLeafNode(this_ASSIGNASSTRING_8, grammarAccess.getInnerAccess().getASSIGNASSTRINGTerminalRuleCall_2_2_0()); 
                        
                    // InternalXtextTest.g:1557:1: ( (lv_value_9_0= RULE_STRING ) )
                    // InternalXtextTest.g:1558:1: (lv_value_9_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1558:1: (lv_value_9_0= RULE_STRING )
                    // InternalXtextTest.g:1559:3: lv_value_9_0= RULE_STRING
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
                    // InternalXtextTest.g:1581:1: (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:1581:1: (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:1582:1: this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) )
                    {
                    this_ASSIGNASDATALIST_10=(Token)match(input,RULE_ASSIGNASDATALIST,FOLLOW_18); 
                     
                        newLeafNode(this_ASSIGNASDATALIST_10, grammarAccess.getInnerAccess().getASSIGNASDATALISTTerminalRuleCall_2_3_0()); 
                        
                    // InternalXtextTest.g:1589:1: ( (lv_assignAsData_11_0= RULE_STRING ) )
                    // InternalXtextTest.g:1590:1: (lv_assignAsData_11_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1590:1: (lv_assignAsData_11_0= RULE_STRING )
                    // InternalXtextTest.g:1591:3: lv_assignAsData_11_0= RULE_STRING
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
                    // InternalXtextTest.g:1613:1: (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) )
                    {
                    // InternalXtextTest.g:1613:1: (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) )
                    // InternalXtextTest.g:1614:1: this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) )
                    {
                    this_ASSIGNASBOOL_12=(Token)match(input,RULE_ASSIGNASBOOL,FOLLOW_7); 
                     
                        newLeafNode(this_ASSIGNASBOOL_12, grammarAccess.getInnerAccess().getASSIGNASBOOLTerminalRuleCall_2_4_0()); 
                        
                    // InternalXtextTest.g:1621:1: ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) )
                    // InternalXtextTest.g:1622:1: ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) )
                    {
                    // InternalXtextTest.g:1622:1: ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) )
                    // InternalXtextTest.g:1623:1: (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE )
                    {
                    // InternalXtextTest.g:1623:1: (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE )
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==RULE_TRUE) ) {
                        alt23=1;
                    }
                    else if ( (LA23_0==RULE_FALSE) ) {
                        alt23=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 0, input);

                        throw nvae;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalXtextTest.g:1624:3: lv_assignAsBool_13_1= RULE_TRUE
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
                            // InternalXtextTest.g:1639:8: lv_assignAsBool_13_2= RULE_FALSE
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
                    // InternalXtextTest.g:1663:1: ( (lv_isNull_14_0= RULE_ISNULL ) )
                    {
                    // InternalXtextTest.g:1663:1: ( (lv_isNull_14_0= RULE_ISNULL ) )
                    // InternalXtextTest.g:1664:1: (lv_isNull_14_0= RULE_ISNULL )
                    {
                    // InternalXtextTest.g:1664:1: (lv_isNull_14_0= RULE_ISNULL )
                    // InternalXtextTest.g:1665:3: lv_isNull_14_0= RULE_ISNULL
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
                    // InternalXtextTest.g:1685:1: ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) )
                    {
                    // InternalXtextTest.g:1685:1: ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) )
                    // InternalXtextTest.g:1686:1: (lv_isNotNull_15_0= RULE_ISNOTNULL )
                    {
                    // InternalXtextTest.g:1686:1: (lv_isNotNull_15_0= RULE_ISNOTNULL )
                    // InternalXtextTest.g:1687:3: lv_isNotNull_15_0= RULE_ISNOTNULL
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
                    // InternalXtextTest.g:1707:1: ( (lv_isEmpty_16_0= RULE_ISEMPTY ) )
                    {
                    // InternalXtextTest.g:1707:1: ( (lv_isEmpty_16_0= RULE_ISEMPTY ) )
                    // InternalXtextTest.g:1708:1: (lv_isEmpty_16_0= RULE_ISEMPTY )
                    {
                    // InternalXtextTest.g:1708:1: (lv_isEmpty_16_0= RULE_ISEMPTY )
                    // InternalXtextTest.g:1709:3: lv_isEmpty_16_0= RULE_ISEMPTY
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
    // InternalXtextTest.g:1739:1: entryRuleGenerator returns [EObject current=null] : iv_ruleGenerator= ruleGenerator EOF ;
    public final EObject entryRuleGenerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenerator = null;


        try {
            // InternalXtextTest.g:1740:2: (iv_ruleGenerator= ruleGenerator EOF )
            // InternalXtextTest.g:1741:2: iv_ruleGenerator= ruleGenerator EOF
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
    // InternalXtextTest.g:1748:1: ruleGenerator returns [EObject current=null] : ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? ) ;
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
            // InternalXtextTest.g:1754:7: ( ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? ) )
            // InternalXtextTest.g:1756:1: ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? )
            {
            // InternalXtextTest.g:1756:1: ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? )
            // InternalXtextTest.g:1757:1: () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )?
            {
            // InternalXtextTest.g:1757:1: ()
            // InternalXtextTest.g:1758:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getGeneratorAccess().getGeneratorAction_0(),
                        current);
                

            }

            // InternalXtextTest.g:1766:1: (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) )
            // InternalXtextTest.g:1767:1: this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) )
            {
            this_OUTPUT_1=(Token)match(input,RULE_OUTPUT,FOLLOW_17); 
             
                newLeafNode(this_OUTPUT_1, grammarAccess.getGeneratorAccess().getOUTPUTTerminalRuleCall_1_0()); 
                
            this_FILE_2=(Token)match(input,RULE_FILE,FOLLOW_6); 
             
                newLeafNode(this_FILE_2, grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_1_1()); 
                
            this_ASSIGNASSINGLE_3=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_18); 
             
                newLeafNode(this_ASSIGNASSINGLE_3, grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_1_2()); 
                
            // InternalXtextTest.g:1788:1: ( (lv_output_4_0= RULE_STRING ) )
            // InternalXtextTest.g:1789:1: (lv_output_4_0= RULE_STRING )
            {
            // InternalXtextTest.g:1789:1: (lv_output_4_0= RULE_STRING )
            // InternalXtextTest.g:1790:3: lv_output_4_0= RULE_STRING
            {
            lv_output_4_0=(Token)match(input,RULE_STRING,FOLLOW_31); 

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

            // InternalXtextTest.g:1811:1: (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) )
            // InternalXtextTest.g:1812:1: this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) )
            {
            this_EXPECTED_5=(Token)match(input,RULE_EXPECTED,FOLLOW_17); 
             
                newLeafNode(this_EXPECTED_5, grammarAccess.getGeneratorAccess().getEXPECTEDTerminalRuleCall_2_0()); 
                
            this_FILE_6=(Token)match(input,RULE_FILE,FOLLOW_32); 
             
                newLeafNode(this_FILE_6, grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_2_1()); 
                
            // InternalXtextTest.g:1826:1: ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ASSIGNASSINGLE) ) {
                alt25=1;
            }
            else if ( (LA25_0==RULE_ISSAMEASINPUTFILE) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalXtextTest.g:1827:1: (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:1827:1: (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:1828:1: this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) )
                    {
                    this_ASSIGNASSINGLE_7=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_18); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_7, grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_2_2_0_0()); 
                        
                    // InternalXtextTest.g:1835:1: ( (lv_expected_8_0= RULE_STRING ) )
                    // InternalXtextTest.g:1836:1: (lv_expected_8_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1836:1: (lv_expected_8_0= RULE_STRING )
                    // InternalXtextTest.g:1837:3: lv_expected_8_0= RULE_STRING
                    {
                    lv_expected_8_0=(Token)match(input,RULE_STRING,FOLLOW_33); 

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
                    // InternalXtextTest.g:1859:1: ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) )
                    {
                    // InternalXtextTest.g:1859:1: ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) )
                    // InternalXtextTest.g:1860:1: (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE )
                    {
                    // InternalXtextTest.g:1860:1: (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE )
                    // InternalXtextTest.g:1861:3: lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE
                    {
                    lv_isSameAsInputFile_9_0=(Token)match(input,RULE_ISSAMEASINPUTFILE,FOLLOW_33); 

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

            // InternalXtextTest.g:1884:1: (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_PATTERNS) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalXtextTest.g:1885:1: this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )*
                    {
                    this_PATTERNS_10=(Token)match(input,RULE_PATTERNS,FOLLOW_34); 
                     
                        newLeafNode(this_PATTERNS_10, grammarAccess.getGeneratorAccess().getPATTERNSTerminalRuleCall_3_0()); 
                        
                    // InternalXtextTest.g:1892:1: (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==RULE_FILE) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalXtextTest.g:1893:1: this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) )
                            {
                            this_FILE_11=(Token)match(input,RULE_FILE,FOLLOW_6); 
                             
                                newLeafNode(this_FILE_11, grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_3_1_0()); 
                                
                            this_ASSIGNASSINGLE_12=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_18); 
                             
                                newLeafNode(this_ASSIGNASSINGLE_12, grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_3_1_1()); 
                                
                            // InternalXtextTest.g:1907:1: ( (lv_patternFile_13_0= RULE_STRING ) )
                            // InternalXtextTest.g:1908:1: (lv_patternFile_13_0= RULE_STRING )
                            {
                            // InternalXtextTest.g:1908:1: (lv_patternFile_13_0= RULE_STRING )
                            // InternalXtextTest.g:1909:3: lv_patternFile_13_0= RULE_STRING
                            {
                            lv_patternFile_13_0=(Token)match(input,RULE_STRING,FOLLOW_35); 

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

                    // InternalXtextTest.g:1930:1: ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==RULE_STRING) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalXtextTest.g:1931:1: (lv_replacePatterns_14_0= ruleReplacePatterns )
                    	    {
                    	    // InternalXtextTest.g:1931:1: (lv_replacePatterns_14_0= ruleReplacePatterns )
                    	    // InternalXtextTest.g:1932:3: lv_replacePatterns_14_0= ruleReplacePatterns
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getGeneratorAccess().getReplacePatternsReplacePatternsParserRuleCall_3_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_35);
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
                    	    break loop27;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalXtextTest.g:1953:1: (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_EXPECTED) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalXtextTest.g:1954:1: this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) )
                    {
                    this_EXPECTED_15=(Token)match(input,RULE_EXPECTED,FOLLOW_36); 
                     
                        newLeafNode(this_EXPECTED_15, grammarAccess.getGeneratorAccess().getEXPECTEDTerminalRuleCall_4_0()); 
                        
                    this_EXCEPTIONS_16=(Token)match(input,RULE_EXCEPTIONS,FOLLOW_3); 
                     
                        newLeafNode(this_EXCEPTIONS_16, grammarAccess.getGeneratorAccess().getEXCEPTIONSTerminalRuleCall_4_1()); 
                        
                    // InternalXtextTest.g:1968:1: ( (lv_exception_17_0= rulePackageID ) )
                    // InternalXtextTest.g:1969:1: (lv_exception_17_0= rulePackageID )
                    {
                    // InternalXtextTest.g:1969:1: (lv_exception_17_0= rulePackageID )
                    // InternalXtextTest.g:1970:3: lv_exception_17_0= rulePackageID
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
    // InternalXtextTest.g:2000:1: entryRuleReplacePatterns returns [EObject current=null] : iv_ruleReplacePatterns= ruleReplacePatterns EOF ;
    public final EObject entryRuleReplacePatterns() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReplacePatterns = null;


        try {
            // InternalXtextTest.g:2001:2: (iv_ruleReplacePatterns= ruleReplacePatterns EOF )
            // InternalXtextTest.g:2002:2: iv_ruleReplacePatterns= ruleReplacePatterns EOF
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
    // InternalXtextTest.g:2009:1: ruleReplacePatterns returns [EObject current=null] : ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleReplacePatterns() throws RecognitionException {
        EObject current = null;

        Token lv_regex_0_0=null;
        Token this_ASSIGNASSINGLE_1=null;
        Token lv_replace_2_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:2015:7: ( ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) ) )
            // InternalXtextTest.g:2017:1: ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) )
            {
            // InternalXtextTest.g:2017:1: ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) )
            // InternalXtextTest.g:2018:1: ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) )
            {
            // InternalXtextTest.g:2018:1: ( (lv_regex_0_0= RULE_STRING ) )
            // InternalXtextTest.g:2019:1: (lv_regex_0_0= RULE_STRING )
            {
            // InternalXtextTest.g:2019:1: (lv_regex_0_0= RULE_STRING )
            // InternalXtextTest.g:2020:3: lv_regex_0_0= RULE_STRING
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

            this_ASSIGNASSINGLE_1=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_18); 
             
                newLeafNode(this_ASSIGNASSINGLE_1, grammarAccess.getReplacePatternsAccess().getASSIGNASSINGLETerminalRuleCall_1()); 
                
            // InternalXtextTest.g:2046:1: ( (lv_replace_2_0= RULE_STRING ) )
            // InternalXtextTest.g:2047:1: (lv_replace_2_0= RULE_STRING )
            {
            // InternalXtextTest.g:2047:1: (lv_replace_2_0= RULE_STRING )
            // InternalXtextTest.g:2048:3: lv_replace_2_0= RULE_STRING
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
    // InternalXtextTest.g:2076:1: entryRuleBefore returns [EObject current=null] : iv_ruleBefore= ruleBefore EOF ;
    public final EObject entryRuleBefore() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBefore = null;


        try {
            // InternalXtextTest.g:2077:2: (iv_ruleBefore= ruleBefore EOF )
            // InternalXtextTest.g:2078:2: iv_ruleBefore= ruleBefore EOF
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
    // InternalXtextTest.g:2085:1: ruleBefore returns [EObject current=null] : ( () this_BEFORE_KW_1= RULE_BEFORE_KW ( (lv_codeCall_2_0= ruleCodeCall ) ) ) ;
    public final EObject ruleBefore() throws RecognitionException {
        EObject current = null;

        Token this_BEFORE_KW_1=null;
        EObject lv_codeCall_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:2091:7: ( ( () this_BEFORE_KW_1= RULE_BEFORE_KW ( (lv_codeCall_2_0= ruleCodeCall ) ) ) )
            // InternalXtextTest.g:2093:1: ( () this_BEFORE_KW_1= RULE_BEFORE_KW ( (lv_codeCall_2_0= ruleCodeCall ) ) )
            {
            // InternalXtextTest.g:2093:1: ( () this_BEFORE_KW_1= RULE_BEFORE_KW ( (lv_codeCall_2_0= ruleCodeCall ) ) )
            // InternalXtextTest.g:2094:1: () this_BEFORE_KW_1= RULE_BEFORE_KW ( (lv_codeCall_2_0= ruleCodeCall ) )
            {
            // InternalXtextTest.g:2094:1: ()
            // InternalXtextTest.g:2095:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBeforeAccess().getBeforeAction_0(),
                        current);
                

            }

            this_BEFORE_KW_1=(Token)match(input,RULE_BEFORE_KW,FOLLOW_14); 
             
                newLeafNode(this_BEFORE_KW_1, grammarAccess.getBeforeAccess().getBEFORE_KWTerminalRuleCall_1()); 
                
            // InternalXtextTest.g:2110:1: ( (lv_codeCall_2_0= ruleCodeCall ) )
            // InternalXtextTest.g:2111:1: (lv_codeCall_2_0= ruleCodeCall )
            {
            // InternalXtextTest.g:2111:1: (lv_codeCall_2_0= ruleCodeCall )
            // InternalXtextTest.g:2112:3: lv_codeCall_2_0= ruleCodeCall
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
    // InternalXtextTest.g:2140:1: entryRuleAfter returns [EObject current=null] : iv_ruleAfter= ruleAfter EOF ;
    public final EObject entryRuleAfter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAfter = null;


        try {
            // InternalXtextTest.g:2141:2: (iv_ruleAfter= ruleAfter EOF )
            // InternalXtextTest.g:2142:2: iv_ruleAfter= ruleAfter EOF
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
    // InternalXtextTest.g:2149:1: ruleAfter returns [EObject current=null] : ( () this_AFTER_KW_1= RULE_AFTER_KW ( (lv_codeCall_2_0= ruleCodeCall ) ) ) ;
    public final EObject ruleAfter() throws RecognitionException {
        EObject current = null;

        Token this_AFTER_KW_1=null;
        EObject lv_codeCall_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:2155:7: ( ( () this_AFTER_KW_1= RULE_AFTER_KW ( (lv_codeCall_2_0= ruleCodeCall ) ) ) )
            // InternalXtextTest.g:2157:1: ( () this_AFTER_KW_1= RULE_AFTER_KW ( (lv_codeCall_2_0= ruleCodeCall ) ) )
            {
            // InternalXtextTest.g:2157:1: ( () this_AFTER_KW_1= RULE_AFTER_KW ( (lv_codeCall_2_0= ruleCodeCall ) ) )
            // InternalXtextTest.g:2158:1: () this_AFTER_KW_1= RULE_AFTER_KW ( (lv_codeCall_2_0= ruleCodeCall ) )
            {
            // InternalXtextTest.g:2158:1: ()
            // InternalXtextTest.g:2159:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAfterAccess().getAfterAction_0(),
                        current);
                

            }

            this_AFTER_KW_1=(Token)match(input,RULE_AFTER_KW,FOLLOW_14); 
             
                newLeafNode(this_AFTER_KW_1, grammarAccess.getAfterAccess().getAFTER_KWTerminalRuleCall_1()); 
                
            // InternalXtextTest.g:2174:1: ( (lv_codeCall_2_0= ruleCodeCall ) )
            // InternalXtextTest.g:2175:1: (lv_codeCall_2_0= ruleCodeCall )
            {
            // InternalXtextTest.g:2175:1: (lv_codeCall_2_0= ruleCodeCall )
            // InternalXtextTest.g:2176:3: lv_codeCall_2_0= ruleCodeCall
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


    // $ANTLR start "entryRuleCodeCall"
    // InternalXtextTest.g:2204:1: entryRuleCodeCall returns [EObject current=null] : iv_ruleCodeCall= ruleCodeCall EOF ;
    public final EObject entryRuleCodeCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodeCall = null;


        try {
            // InternalXtextTest.g:2205:2: (iv_ruleCodeCall= ruleCodeCall EOF )
            // InternalXtextTest.g:2206:2: iv_ruleCodeCall= ruleCodeCall EOF
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
    // InternalXtextTest.g:2213:1: ruleCodeCall returns [EObject current=null] : ( () this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) (this_LEFTPAREN_7= RULE_LEFTPAREN ( ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )* )? this_RIGHTPAREN_11= RULE_RIGHTPAREN ) ) ;
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
            // InternalXtextTest.g:2219:7: ( ( () this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) (this_LEFTPAREN_7= RULE_LEFTPAREN ( ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )* )? this_RIGHTPAREN_11= RULE_RIGHTPAREN ) ) )
            // InternalXtextTest.g:2221:1: ( () this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) (this_LEFTPAREN_7= RULE_LEFTPAREN ( ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )* )? this_RIGHTPAREN_11= RULE_RIGHTPAREN ) )
            {
            // InternalXtextTest.g:2221:1: ( () this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) (this_LEFTPAREN_7= RULE_LEFTPAREN ( ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )* )? this_RIGHTPAREN_11= RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:2222:1: () this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) (this_LEFTPAREN_7= RULE_LEFTPAREN ( ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )* )? this_RIGHTPAREN_11= RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:2222:1: ()
            // InternalXtextTest.g:2223:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCodeCallAccess().getCodeCallAction_0(),
                        current);
                

            }

            this_CLASS_KW_1=(Token)match(input,RULE_CLASS_KW,FOLLOW_6); 
             
                newLeafNode(this_CLASS_KW_1, grammarAccess.getCodeCallAccess().getCLASS_KWTerminalRuleCall_1()); 
                
            this_ASSIGNASSINGLE_2=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_3); 
             
                newLeafNode(this_ASSIGNASSINGLE_2, grammarAccess.getCodeCallAccess().getASSIGNASSINGLETerminalRuleCall_2()); 
                
            // InternalXtextTest.g:2245:1: ( (lv_myclass_3_0= rulePackageID ) )
            // InternalXtextTest.g:2246:1: (lv_myclass_3_0= rulePackageID )
            {
            // InternalXtextTest.g:2246:1: (lv_myclass_3_0= rulePackageID )
            // InternalXtextTest.g:2247:3: lv_myclass_3_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getCodeCallAccess().getMyclassPackageIDParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_37);
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
                
            // InternalXtextTest.g:2280:1: ( (lv_method_6_0= rulePackageID ) )
            // InternalXtextTest.g:2281:1: (lv_method_6_0= rulePackageID )
            {
            // InternalXtextTest.g:2281:1: (lv_method_6_0= rulePackageID )
            // InternalXtextTest.g:2282:3: lv_method_6_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getCodeCallAccess().getMethodPackageIDParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_38);
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

            // InternalXtextTest.g:2301:1: (this_LEFTPAREN_7= RULE_LEFTPAREN ( ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )* )? this_RIGHTPAREN_11= RULE_RIGHTPAREN )
            // InternalXtextTest.g:2302:1: this_LEFTPAREN_7= RULE_LEFTPAREN ( ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )* )? this_RIGHTPAREN_11= RULE_RIGHTPAREN
            {
            this_LEFTPAREN_7=(Token)match(input,RULE_LEFTPAREN,FOLLOW_27); 
             
                newLeafNode(this_LEFTPAREN_7, grammarAccess.getCodeCallAccess().getLEFTPARENTerminalRuleCall_7_0()); 
                
            // InternalXtextTest.g:2309:1: ( ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )* )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_IDENTIFIER) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalXtextTest.g:2310:1: ( (lv_params_8_0= rulePackageID ) ) (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )*
                    {
                    // InternalXtextTest.g:2310:1: ( (lv_params_8_0= rulePackageID ) )
                    // InternalXtextTest.g:2311:1: (lv_params_8_0= rulePackageID )
                    {
                    // InternalXtextTest.g:2311:1: (lv_params_8_0= rulePackageID )
                    // InternalXtextTest.g:2312:3: lv_params_8_0= rulePackageID
                    {
                     
                    	        newCompositeNode(grammarAccess.getCodeCallAccess().getParamsPackageIDParserRuleCall_7_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_28);
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

                    // InternalXtextTest.g:2331:1: (this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==RULE_COMMA) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalXtextTest.g:2332:1: this_COMMA_9= RULE_COMMA ( (lv_params_10_0= rulePackageID ) )
                    	    {
                    	    this_COMMA_9=(Token)match(input,RULE_COMMA,FOLLOW_3); 
                    	     
                    	        newLeafNode(this_COMMA_9, grammarAccess.getCodeCallAccess().getCOMMATerminalRuleCall_7_1_1_0()); 
                    	        
                    	    // InternalXtextTest.g:2339:1: ( (lv_params_10_0= rulePackageID ) )
                    	    // InternalXtextTest.g:2340:1: (lv_params_10_0= rulePackageID )
                    	    {
                    	    // InternalXtextTest.g:2340:1: (lv_params_10_0= rulePackageID )
                    	    // InternalXtextTest.g:2341:3: lv_params_10_0= rulePackageID
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getCodeCallAccess().getParamsPackageIDParserRuleCall_7_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_28);
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
                    	    break loop30;
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
    // $ANTLR end "ruleCodeCall"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000018400000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000018000000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000020000000040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000008010000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000003F0400100L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000001000000100L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000002800000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000800006002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000800004002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000001000000L});

}