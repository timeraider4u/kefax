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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_PACKAGE", "RULE_LANGUAGE", "RULE_IMPORTS", "RULE_SPLITLEXER", "RULE_ASSIGNASSINGLE", "RULE_TRUE", "RULE_FALSE", "RULE_IDENTIFIER", "RULE_POINT", "RULE_SOURCE", "RULE_SRCTEXT", "RULE_STRING", "RULE_FILE", "RULE_LEXER", "RULE_ASSIGNASDATALIST", "RULE_INT", "RULE_LEFTPAREN", "RULE_IMPORTER", "RULE_COMMA", "RULE_RIGHTPAREN", "RULE_ASSIGNASLIST", "RULE_ASSIGNASSTRING", "RULE_ASSIGNASBOOL", "RULE_ISNULL", "RULE_ISNOTNULL", "RULE_OUTPUT", "RULE_EXPECTED", "RULE_ISSAMEASINPUTFILE", "RULE_PATTERNS", "RULE_EXCEPTIONS", "RULE_BEFORE_KW", "RULE_CLASS_KW", "RULE_METHOD_KW", "RULE_AFTER_KW", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=38;
    public static final int RULE_SRCTEXT=14;
    public static final int RULE_RIGHTPAREN=23;
    public static final int RULE_IMPORTS=6;
    public static final int RULE_IMPORTER=21;
    public static final int RULE_METHOD_KW=36;
    public static final int RULE_PATTERNS=32;
    public static final int RULE_ASSIGNASDATALIST=18;
    public static final int RULE_ANY_OTHER=42;
    public static final int RULE_SPLITLEXER=7;
    public static final int RULE_ASSIGNASBOOL=26;
    public static final int RULE_LANGUAGE=5;
    public static final int RULE_EXPECTED=30;
    public static final int RULE_ISNULL=27;
    public static final int RULE_FILE=16;
    public static final int RULE_COMMA=22;
    public static final int RULE_IDENTIFIER=11;
    public static final int RULE_AFTER_KW=37;
    public static final int RULE_SL_COMMENT=40;
    public static final int EOF=-1;
    public static final int RULE_ISNOTNULL=28;
    public static final int RULE_ML_COMMENT=39;
    public static final int RULE_BEFORE_KW=34;
    public static final int RULE_TRUE=9;
    public static final int RULE_LEFTPAREN=20;
    public static final int RULE_PACKAGE=4;
    public static final int RULE_FALSE=10;
    public static final int RULE_SOURCE=13;
    public static final int RULE_STRING=15;
    public static final int RULE_ASSIGNASSINGLE=8;
    public static final int RULE_ASSIGNASLIST=24;
    public static final int RULE_EXCEPTIONS=33;
    public static final int RULE_POINT=12;
    public static final int RULE_LEXER=17;
    public static final int RULE_OUTPUT=29;
    public static final int RULE_INT=19;
    public static final int RULE_CLASS_KW=35;
    public static final int RULE_ASSIGNASSTRING=25;
    public static final int RULE_WS=41;
    public static final int RULE_ISSAMEASINPUTFILE=31;

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
    // InternalXtextTest.g:77:1: ruleXtextTest returns [EObject current=null] : ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )? (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )? ( (lv_input_10_0= ruleInput ) ) ( (lv_tokens_11_0= ruleTokens ) )? ( (lv_root_12_0= ruleElement ) ) ( (lv_output_13_0= ruleGenerator ) )? ( (lv_before_14_0= ruleBefore ) )? ( (lv_after_15_0= ruleAfter ) )? ) ;
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
            // InternalXtextTest.g:83:7: ( ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )? (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )? ( (lv_input_10_0= ruleInput ) ) ( (lv_tokens_11_0= ruleTokens ) )? ( (lv_root_12_0= ruleElement ) ) ( (lv_output_13_0= ruleGenerator ) )? ( (lv_before_14_0= ruleBefore ) )? ( (lv_after_15_0= ruleAfter ) )? ) )
            // InternalXtextTest.g:85:1: ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )? (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )? ( (lv_input_10_0= ruleInput ) ) ( (lv_tokens_11_0= ruleTokens ) )? ( (lv_root_12_0= ruleElement ) ) ( (lv_output_13_0= ruleGenerator ) )? ( (lv_before_14_0= ruleBefore ) )? ( (lv_after_15_0= ruleAfter ) )? )
            {
            // InternalXtextTest.g:85:1: ( () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )? (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )? ( (lv_input_10_0= ruleInput ) ) ( (lv_tokens_11_0= ruleTokens ) )? ( (lv_root_12_0= ruleElement ) ) ( (lv_output_13_0= ruleGenerator ) )? ( (lv_before_14_0= ruleBefore ) )? ( (lv_after_15_0= ruleAfter ) )? )
            // InternalXtextTest.g:86:1: () this_PACKAGE_1= RULE_PACKAGE ( (lv_package_2_0= rulePackageID ) ) this_LANGUAGE_3= RULE_LANGUAGE ( (lv_lang_4_0= ruleLangID ) ) (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )? (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )? ( (lv_input_10_0= ruleInput ) ) ( (lv_tokens_11_0= ruleTokens ) )? ( (lv_root_12_0= ruleElement ) ) ( (lv_output_13_0= ruleGenerator ) )? ( (lv_before_14_0= ruleBefore ) )? ( (lv_after_15_0= ruleAfter ) )?
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

            // InternalXtextTest.g:151:1: (this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_IMPORTS) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalXtextTest.g:152:1: this_IMPORTS_5= RULE_IMPORTS ( (lv_imports_6_0= ruleImportID ) )
                    {
                    this_IMPORTS_5=(Token)match(input,RULE_IMPORTS,FOLLOW_3); 
                     
                        newLeafNode(this_IMPORTS_5, grammarAccess.getXtextTestAccess().getIMPORTSTerminalRuleCall_5_0()); 
                        
                    // InternalXtextTest.g:159:1: ( (lv_imports_6_0= ruleImportID ) )
                    // InternalXtextTest.g:160:1: (lv_imports_6_0= ruleImportID )
                    {
                    // InternalXtextTest.g:160:1: (lv_imports_6_0= ruleImportID )
                    // InternalXtextTest.g:161:3: lv_imports_6_0= ruleImportID
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

            // InternalXtextTest.g:182:1: (this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_SPLITLEXER) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalXtextTest.g:183:1: this_SPLITLEXER_7= RULE_SPLITLEXER this_ASSIGNASSINGLE_8= RULE_ASSIGNASSINGLE ( (lv_boolean_9_0= ruleBoolean ) )
                    {
                    this_SPLITLEXER_7=(Token)match(input,RULE_SPLITLEXER,FOLLOW_6); 
                     
                        newLeafNode(this_SPLITLEXER_7, grammarAccess.getXtextTestAccess().getSPLITLEXERTerminalRuleCall_6_0()); 
                        
                    this_ASSIGNASSINGLE_8=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_7); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_8, grammarAccess.getXtextTestAccess().getASSIGNASSINGLETerminalRuleCall_6_1()); 
                        
                    // InternalXtextTest.g:197:1: ( (lv_boolean_9_0= ruleBoolean ) )
                    // InternalXtextTest.g:198:1: (lv_boolean_9_0= ruleBoolean )
                    {
                    // InternalXtextTest.g:198:1: (lv_boolean_9_0= ruleBoolean )
                    // InternalXtextTest.g:199:3: lv_boolean_9_0= ruleBoolean
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

            // InternalXtextTest.g:220:1: ( (lv_input_10_0= ruleInput ) )
            // InternalXtextTest.g:221:1: (lv_input_10_0= ruleInput )
            {
            // InternalXtextTest.g:221:1: (lv_input_10_0= ruleInput )
            // InternalXtextTest.g:222:3: lv_input_10_0= ruleInput
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

            // InternalXtextTest.g:241:1: ( (lv_tokens_11_0= ruleTokens ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_LEXER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalXtextTest.g:242:1: (lv_tokens_11_0= ruleTokens )
                    {
                    // InternalXtextTest.g:242:1: (lv_tokens_11_0= ruleTokens )
                    // InternalXtextTest.g:243:3: lv_tokens_11_0= ruleTokens
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

            // InternalXtextTest.g:262:1: ( (lv_root_12_0= ruleElement ) )
            // InternalXtextTest.g:263:1: (lv_root_12_0= ruleElement )
            {
            // InternalXtextTest.g:263:1: (lv_root_12_0= ruleElement )
            // InternalXtextTest.g:264:3: lv_root_12_0= ruleElement
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

            // InternalXtextTest.g:283:1: ( (lv_output_13_0= ruleGenerator ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_OUTPUT) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalXtextTest.g:284:1: (lv_output_13_0= ruleGenerator )
                    {
                    // InternalXtextTest.g:284:1: (lv_output_13_0= ruleGenerator )
                    // InternalXtextTest.g:285:3: lv_output_13_0= ruleGenerator
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

            // InternalXtextTest.g:304:1: ( (lv_before_14_0= ruleBefore ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_BEFORE_KW) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalXtextTest.g:305:1: (lv_before_14_0= ruleBefore )
                    {
                    // InternalXtextTest.g:305:1: (lv_before_14_0= ruleBefore )
                    // InternalXtextTest.g:306:3: lv_before_14_0= ruleBefore
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

            // InternalXtextTest.g:325:1: ( (lv_after_15_0= ruleAfter ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_AFTER_KW) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalXtextTest.g:326:1: (lv_after_15_0= ruleAfter )
                    {
                    // InternalXtextTest.g:326:1: (lv_after_15_0= ruleAfter )
                    // InternalXtextTest.g:327:3: lv_after_15_0= ruleAfter
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


    // $ANTLR start "entryRuleBoolean"
    // InternalXtextTest.g:355:1: entryRuleBoolean returns [String current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final String entryRuleBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBoolean = null;


        try {
            // InternalXtextTest.g:356:2: (iv_ruleBoolean= ruleBoolean EOF )
            // InternalXtextTest.g:357:2: iv_ruleBoolean= ruleBoolean EOF
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
    // InternalXtextTest.g:364:1: ruleBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_TRUE_0= RULE_TRUE | this_FALSE_1= RULE_FALSE ) ;
    public final AntlrDatatypeRuleToken ruleBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_TRUE_0=null;
        Token this_FALSE_1=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:367:28: ( (this_TRUE_0= RULE_TRUE | this_FALSE_1= RULE_FALSE ) )
            // InternalXtextTest.g:368:1: (this_TRUE_0= RULE_TRUE | this_FALSE_1= RULE_FALSE )
            {
            // InternalXtextTest.g:368:1: (this_TRUE_0= RULE_TRUE | this_FALSE_1= RULE_FALSE )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_TRUE) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_FALSE) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalXtextTest.g:368:6: this_TRUE_0= RULE_TRUE
                    {
                    this_TRUE_0=(Token)match(input,RULE_TRUE,FOLLOW_2); 

                    		current.merge(this_TRUE_0);
                        
                     
                        newLeafNode(this_TRUE_0, grammarAccess.getBooleanAccess().getTRUETerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:376:10: this_FALSE_1= RULE_FALSE
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
    // InternalXtextTest.g:391:1: entryRulePackageID returns [String current=null] : iv_rulePackageID= rulePackageID EOF ;
    public final String entryRulePackageID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePackageID = null;


        try {
            // InternalXtextTest.g:392:2: (iv_rulePackageID= rulePackageID EOF )
            // InternalXtextTest.g:393:2: iv_rulePackageID= rulePackageID EOF
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
    // InternalXtextTest.g:400:1: rulePackageID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* ) ;
    public final AntlrDatatypeRuleToken rulePackageID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IDENTIFIER_0=null;
        Token this_POINT_1=null;
        Token this_IDENTIFIER_2=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:403:28: ( (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* ) )
            // InternalXtextTest.g:404:1: (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* )
            {
            // InternalXtextTest.g:404:1: (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* )
            // InternalXtextTest.g:404:6: this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )*
            {
            this_IDENTIFIER_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_12); 

            		current.merge(this_IDENTIFIER_0);
                
             
                newLeafNode(this_IDENTIFIER_0, grammarAccess.getPackageIDAccess().getIDENTIFIERTerminalRuleCall_0()); 
                
            // InternalXtextTest.g:411:1: (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_POINT) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalXtextTest.g:411:6: this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER
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
            	    break loop8;
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
    // InternalXtextTest.g:433:1: entryRuleLangID returns [String current=null] : iv_ruleLangID= ruleLangID EOF ;
    public final String entryRuleLangID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLangID = null;


        try {
            // InternalXtextTest.g:434:2: (iv_ruleLangID= ruleLangID EOF )
            // InternalXtextTest.g:435:2: iv_ruleLangID= ruleLangID EOF
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
    // InternalXtextTest.g:442:1: ruleLangID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_IDENTIFIER_0= RULE_IDENTIFIER ;
    public final AntlrDatatypeRuleToken ruleLangID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IDENTIFIER_0=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:445:28: (this_IDENTIFIER_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:446:5: this_IDENTIFIER_0= RULE_IDENTIFIER
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
    // InternalXtextTest.g:461:1: entryRuleImportID returns [String current=null] : iv_ruleImportID= ruleImportID EOF ;
    public final String entryRuleImportID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportID = null;


        try {
            // InternalXtextTest.g:462:2: (iv_ruleImportID= ruleImportID EOF )
            // InternalXtextTest.g:463:2: iv_ruleImportID= ruleImportID EOF
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
    // InternalXtextTest.g:470:1: ruleImportID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* ) ;
    public final AntlrDatatypeRuleToken ruleImportID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IDENTIFIER_0=null;
        Token this_POINT_1=null;
        Token this_IDENTIFIER_2=null;

         enterRule(); 
            
        try {
            // InternalXtextTest.g:473:28: ( (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* ) )
            // InternalXtextTest.g:474:1: (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* )
            {
            // InternalXtextTest.g:474:1: (this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )* )
            // InternalXtextTest.g:474:6: this_IDENTIFIER_0= RULE_IDENTIFIER (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )*
            {
            this_IDENTIFIER_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_12); 

            		current.merge(this_IDENTIFIER_0);
                
             
                newLeafNode(this_IDENTIFIER_0, grammarAccess.getImportIDAccess().getIDENTIFIERTerminalRuleCall_0()); 
                
            // InternalXtextTest.g:481:1: (this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_POINT) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalXtextTest.g:481:6: this_POINT_1= RULE_POINT this_IDENTIFIER_2= RULE_IDENTIFIER
            	    {
            	    this_POINT_1=(Token)match(input,RULE_POINT,FOLLOW_3); 

            	    		current.merge(this_POINT_1);
            	        
            	     
            	        newLeafNode(this_POINT_1, grammarAccess.getImportIDAccess().getPOINTTerminalRuleCall_1_0()); 
            	        
            	    this_IDENTIFIER_2=(Token)match(input,RULE_IDENTIFIER,FOLLOW_12); 

            	    		current.merge(this_IDENTIFIER_2);
            	        
            	     
            	        newLeafNode(this_IDENTIFIER_2, grammarAccess.getImportIDAccess().getIDENTIFIERTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop9;
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
    // InternalXtextTest.g:503:1: entryRuleInput returns [EObject current=null] : iv_ruleInput= ruleInput EOF ;
    public final EObject entryRuleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInput = null;


        try {
            // InternalXtextTest.g:504:2: (iv_ruleInput= ruleInput EOF )
            // InternalXtextTest.g:505:2: iv_ruleInput= ruleInput EOF
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
    // InternalXtextTest.g:512:1: ruleInput returns [EObject current=null] : ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) ) ;
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
            // InternalXtextTest.g:518:7: ( ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) ) )
            // InternalXtextTest.g:520:1: ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) )
            {
            // InternalXtextTest.g:520:1: ( () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) ) )
            // InternalXtextTest.g:521:1: () this_SOURCE_1= RULE_SOURCE ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) )
            {
            // InternalXtextTest.g:521:1: ()
            // InternalXtextTest.g:522:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInputAccess().getInputAction_0(),
                        current);
                

            }

            this_SOURCE_1=(Token)match(input,RULE_SOURCE,FOLLOW_13); 
             
                newLeafNode(this_SOURCE_1, grammarAccess.getInputAccess().getSOURCETerminalRuleCall_1()); 
                
            // InternalXtextTest.g:537:1: ( (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) ) | (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_SRCTEXT) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_FILE) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalXtextTest.g:538:1: (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:538:1: (this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:539:1: this_SRCTEXT_2= RULE_SRCTEXT this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_text_4_0= RULE_STRING ) )
                    {
                    this_SRCTEXT_2=(Token)match(input,RULE_SRCTEXT,FOLLOW_6); 
                     
                        newLeafNode(this_SRCTEXT_2, grammarAccess.getInputAccess().getSRCTEXTTerminalRuleCall_2_0_0()); 
                        
                    this_ASSIGNASSINGLE_3=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_14); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_3, grammarAccess.getInputAccess().getASSIGNASSINGLETerminalRuleCall_2_0_1()); 
                        
                    // InternalXtextTest.g:553:1: ( (lv_text_4_0= RULE_STRING ) )
                    // InternalXtextTest.g:554:1: (lv_text_4_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:554:1: (lv_text_4_0= RULE_STRING )
                    // InternalXtextTest.g:555:3: lv_text_4_0= RULE_STRING
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
                    // InternalXtextTest.g:577:1: (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:577:1: (this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:578:1: this_FILE_5= RULE_FILE this_ASSIGNASSINGLE_6= RULE_ASSIGNASSINGLE ( (lv_file_7_0= RULE_STRING ) )
                    {
                    this_FILE_5=(Token)match(input,RULE_FILE,FOLLOW_6); 
                     
                        newLeafNode(this_FILE_5, grammarAccess.getInputAccess().getFILETerminalRuleCall_2_1_0()); 
                        
                    this_ASSIGNASSINGLE_6=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_14); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_6, grammarAccess.getInputAccess().getASSIGNASSINGLETerminalRuleCall_2_1_1()); 
                        
                    // InternalXtextTest.g:592:1: ( (lv_file_7_0= RULE_STRING ) )
                    // InternalXtextTest.g:593:1: (lv_file_7_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:593:1: (lv_file_7_0= RULE_STRING )
                    // InternalXtextTest.g:594:3: lv_file_7_0= RULE_STRING
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
    // InternalXtextTest.g:626:1: entryRuleTokens returns [EObject current=null] : iv_ruleTokens= ruleTokens EOF ;
    public final EObject entryRuleTokens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTokens = null;


        try {
            // InternalXtextTest.g:627:2: (iv_ruleTokens= ruleTokens EOF )
            // InternalXtextTest.g:628:2: iv_ruleTokens= ruleTokens EOF
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
    // InternalXtextTest.g:635:1: ruleTokens returns [EObject current=null] : ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+ ) ;
    public final EObject ruleTokens() throws RecognitionException {
        EObject current = null;

        Token this_LEXER_1=null;
        EObject lv_tokens_2_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:641:7: ( ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+ ) )
            // InternalXtextTest.g:643:1: ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+ )
            {
            // InternalXtextTest.g:643:1: ( () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+ )
            // InternalXtextTest.g:644:1: () this_LEXER_1= RULE_LEXER ( (lv_tokens_2_0= ruleMyTokens ) )+
            {
            // InternalXtextTest.g:644:1: ()
            // InternalXtextTest.g:645:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTokensAccess().getTokensAction_0(),
                        current);
                

            }

            this_LEXER_1=(Token)match(input,RULE_LEXER,FOLLOW_3); 
             
                newLeafNode(this_LEXER_1, grammarAccess.getTokensAccess().getLEXERTerminalRuleCall_1()); 
                
            // InternalXtextTest.g:660:1: ( (lv_tokens_2_0= ruleMyTokens ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_IDENTIFIER) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalXtextTest.g:661:1: (lv_tokens_2_0= ruleMyTokens )
            	    {
            	    // InternalXtextTest.g:661:1: (lv_tokens_2_0= ruleMyTokens )
            	    // InternalXtextTest.g:662:3: lv_tokens_2_0= ruleMyTokens
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
    // InternalXtextTest.g:690:1: entryRuleMyTokens returns [EObject current=null] : iv_ruleMyTokens= ruleMyTokens EOF ;
    public final EObject entryRuleMyTokens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyTokens = null;


        try {
            // InternalXtextTest.g:691:2: (iv_ruleMyTokens= ruleMyTokens EOF )
            // InternalXtextTest.g:692:2: iv_ruleMyTokens= ruleMyTokens EOF
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
    // InternalXtextTest.g:699:1: ruleMyTokens returns [EObject current=null] : ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) (this_ASSIGNASDATALIST_1= RULE_ASSIGNASDATALIST ( (lv_count_2_0= RULE_INT ) ) )? ) ;
    public final EObject ruleMyTokens() throws RecognitionException {
        EObject current = null;

        Token lv_token_0_0=null;
        Token this_ASSIGNASDATALIST_1=null;
        Token lv_count_2_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:705:7: ( ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) (this_ASSIGNASDATALIST_1= RULE_ASSIGNASDATALIST ( (lv_count_2_0= RULE_INT ) ) )? ) )
            // InternalXtextTest.g:707:1: ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) (this_ASSIGNASDATALIST_1= RULE_ASSIGNASDATALIST ( (lv_count_2_0= RULE_INT ) ) )? )
            {
            // InternalXtextTest.g:707:1: ( ( (lv_token_0_0= RULE_IDENTIFIER ) ) (this_ASSIGNASDATALIST_1= RULE_ASSIGNASDATALIST ( (lv_count_2_0= RULE_INT ) ) )? )
            // InternalXtextTest.g:708:1: ( (lv_token_0_0= RULE_IDENTIFIER ) ) (this_ASSIGNASDATALIST_1= RULE_ASSIGNASDATALIST ( (lv_count_2_0= RULE_INT ) ) )?
            {
            // InternalXtextTest.g:708:1: ( (lv_token_0_0= RULE_IDENTIFIER ) )
            // InternalXtextTest.g:709:1: (lv_token_0_0= RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:709:1: (lv_token_0_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:710:3: lv_token_0_0= RULE_IDENTIFIER
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

            // InternalXtextTest.g:729:1: (this_ASSIGNASDATALIST_1= RULE_ASSIGNASDATALIST ( (lv_count_2_0= RULE_INT ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ASSIGNASDATALIST) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalXtextTest.g:730:1: this_ASSIGNASDATALIST_1= RULE_ASSIGNASDATALIST ( (lv_count_2_0= RULE_INT ) )
                    {
                    this_ASSIGNASDATALIST_1=(Token)match(input,RULE_ASSIGNASDATALIST,FOLLOW_17); 
                     
                        newLeafNode(this_ASSIGNASDATALIST_1, grammarAccess.getMyTokensAccess().getASSIGNASDATALISTTerminalRuleCall_1_0()); 
                        
                    // InternalXtextTest.g:737:1: ( (lv_count_2_0= RULE_INT ) )
                    // InternalXtextTest.g:738:1: (lv_count_2_0= RULE_INT )
                    {
                    // InternalXtextTest.g:738:1: (lv_count_2_0= RULE_INT )
                    // InternalXtextTest.g:739:3: lv_count_2_0= RULE_INT
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
    // InternalXtextTest.g:769:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalXtextTest.g:770:2: (iv_ruleElement= ruleElement EOF )
            // InternalXtextTest.g:771:2: iv_ruleElement= ruleElement EOF
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
    // InternalXtextTest.g:778:1: ruleElement returns [EObject current=null] : ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )? ( (lv_name_4_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )? this_RIGHTPAREN_8= RULE_RIGHTPAREN ) ;
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
            // InternalXtextTest.g:784:7: ( ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )? ( (lv_name_4_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )? this_RIGHTPAREN_8= RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:786:1: ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )? ( (lv_name_4_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )? this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:786:1: ( () this_LEFTPAREN_1= RULE_LEFTPAREN ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )? ( (lv_name_4_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )? this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            // InternalXtextTest.g:787:1: () this_LEFTPAREN_1= RULE_LEFTPAREN ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )? ( (lv_name_4_0= RULE_IDENTIFIER ) ) ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )? this_RIGHTPAREN_8= RULE_RIGHTPAREN
            {
            // InternalXtextTest.g:787:1: ()
            // InternalXtextTest.g:788:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getElementAccess().getElementAction_0(),
                        current);
                

            }

            this_LEFTPAREN_1=(Token)match(input,RULE_LEFTPAREN,FOLLOW_3); 
             
                newLeafNode(this_LEFTPAREN_1, grammarAccess.getElementAccess().getLEFTPARENTerminalRuleCall_1()); 
                
            // InternalXtextTest.g:803:1: ( ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_IDENTIFIER) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==RULE_IMPORTER) ) {
                    alt13=1;
                }
            }
            switch (alt13) {
                case 1 :
                    // InternalXtextTest.g:804:1: ( (lv_importing_2_0= RULE_IDENTIFIER ) ) this_IMPORTER_3= RULE_IMPORTER
                    {
                    // InternalXtextTest.g:804:1: ( (lv_importing_2_0= RULE_IDENTIFIER ) )
                    // InternalXtextTest.g:805:1: (lv_importing_2_0= RULE_IDENTIFIER )
                    {
                    // InternalXtextTest.g:805:1: (lv_importing_2_0= RULE_IDENTIFIER )
                    // InternalXtextTest.g:806:3: lv_importing_2_0= RULE_IDENTIFIER
                    {
                    lv_importing_2_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_18); 

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

            // InternalXtextTest.g:834:1: ( (lv_name_4_0= RULE_IDENTIFIER ) )
            // InternalXtextTest.g:835:1: (lv_name_4_0= RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:835:1: (lv_name_4_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:836:3: lv_name_4_0= RULE_IDENTIFIER
            {
            lv_name_4_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_19); 

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

            // InternalXtextTest.g:855:1: ( ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_IDENTIFIER) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalXtextTest.g:856:1: ( (lv_inner_5_0= ruleInner ) ) (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )*
                    {
                    // InternalXtextTest.g:856:1: ( (lv_inner_5_0= ruleInner ) )
                    // InternalXtextTest.g:857:1: (lv_inner_5_0= ruleInner )
                    {
                    // InternalXtextTest.g:857:1: (lv_inner_5_0= ruleInner )
                    // InternalXtextTest.g:858:3: lv_inner_5_0= ruleInner
                    {
                     
                    	        newCompositeNode(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_20);
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

                    // InternalXtextTest.g:877:1: (this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_COMMA) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalXtextTest.g:878:1: this_COMMA_6= RULE_COMMA ( (lv_inner_7_0= ruleInner ) )
                    	    {
                    	    this_COMMA_6=(Token)match(input,RULE_COMMA,FOLLOW_3); 
                    	     
                    	        newLeafNode(this_COMMA_6, grammarAccess.getElementAccess().getCOMMATerminalRuleCall_4_1_0()); 
                    	        
                    	    // InternalXtextTest.g:885:1: ( (lv_inner_7_0= ruleInner ) )
                    	    // InternalXtextTest.g:886:1: (lv_inner_7_0= ruleInner )
                    	    {
                    	    // InternalXtextTest.g:886:1: (lv_inner_7_0= ruleInner )
                    	    // InternalXtextTest.g:887:3: lv_inner_7_0= ruleInner
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_20);
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
                    	    break loop14;
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
    // InternalXtextTest.g:926:1: entryRuleInner returns [EObject current=null] : iv_ruleInner= ruleInner EOF ;
    public final EObject entryRuleInner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInner = null;


        try {
            // InternalXtextTest.g:927:2: (iv_ruleInner= ruleInner EOF )
            // InternalXtextTest.g:928:2: iv_ruleInner= ruleInner EOF
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
    // InternalXtextTest.g:935:1: ruleInner returns [EObject current=null] : ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) ) ) ;
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
        EObject lv_assign_3_0 = null;

        EObject lv_assignList_5_0 = null;

        EObject lv_assignList_7_0 = null;


         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:941:7: ( ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) ) ) )
            // InternalXtextTest.g:943:1: ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) ) )
            {
            // InternalXtextTest.g:943:1: ( () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) ) )
            // InternalXtextTest.g:944:1: () ( (lv_parameter_1_0= RULE_IDENTIFIER ) ) ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) )
            {
            // InternalXtextTest.g:944:1: ()
            // InternalXtextTest.g:945:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInnerAccess().getInnerAction_0(),
                        current);
                

            }

            // InternalXtextTest.g:953:1: ( (lv_parameter_1_0= RULE_IDENTIFIER ) )
            // InternalXtextTest.g:954:1: (lv_parameter_1_0= RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:954:1: (lv_parameter_1_0= RULE_IDENTIFIER )
            // InternalXtextTest.g:955:3: lv_parameter_1_0= RULE_IDENTIFIER
            {
            lv_parameter_1_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_21); 

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

            // InternalXtextTest.g:974:1: ( (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) ) | (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* ) | (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) ) | (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) ) | (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) ) | ( (lv_isNull_14_0= RULE_ISNULL ) ) | ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) ) )
            int alt18=7;
            switch ( input.LA(1) ) {
            case RULE_ASSIGNASSINGLE:
                {
                alt18=1;
                }
                break;
            case RULE_ASSIGNASLIST:
                {
                alt18=2;
                }
                break;
            case RULE_ASSIGNASSTRING:
                {
                alt18=3;
                }
                break;
            case RULE_ASSIGNASDATALIST:
                {
                alt18=4;
                }
                break;
            case RULE_ASSIGNASBOOL:
                {
                alt18=5;
                }
                break;
            case RULE_ISNULL:
                {
                alt18=6;
                }
                break;
            case RULE_ISNOTNULL:
                {
                alt18=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalXtextTest.g:975:1: (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) )
                    {
                    // InternalXtextTest.g:975:1: (this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) ) )
                    // InternalXtextTest.g:976:1: this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_assign_3_0= ruleElement ) )
                    {
                    this_ASSIGNASSINGLE_2=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_8); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_2, grammarAccess.getInnerAccess().getASSIGNASSINGLETerminalRuleCall_2_0_0()); 
                        
                    // InternalXtextTest.g:983:1: ( (lv_assign_3_0= ruleElement ) )
                    // InternalXtextTest.g:984:1: (lv_assign_3_0= ruleElement )
                    {
                    // InternalXtextTest.g:984:1: (lv_assign_3_0= ruleElement )
                    // InternalXtextTest.g:985:3: lv_assign_3_0= ruleElement
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
                    // InternalXtextTest.g:1007:1: (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* )
                    {
                    // InternalXtextTest.g:1007:1: (this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )* )
                    // InternalXtextTest.g:1008:1: this_ASSIGNASLIST_4= RULE_ASSIGNASLIST ( (lv_assignList_5_0= ruleElement ) ) (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )*
                    {
                    this_ASSIGNASLIST_4=(Token)match(input,RULE_ASSIGNASLIST,FOLLOW_8); 
                     
                        newLeafNode(this_ASSIGNASLIST_4, grammarAccess.getInnerAccess().getASSIGNASLISTTerminalRuleCall_2_1_0()); 
                        
                    // InternalXtextTest.g:1015:1: ( (lv_assignList_5_0= ruleElement ) )
                    // InternalXtextTest.g:1016:1: (lv_assignList_5_0= ruleElement )
                    {
                    // InternalXtextTest.g:1016:1: (lv_assignList_5_0= ruleElement )
                    // InternalXtextTest.g:1017:3: lv_assignList_5_0= ruleElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getInnerAccess().getAssignListElementParserRuleCall_2_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_22);
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

                    // InternalXtextTest.g:1036:1: (this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_COMMA) ) {
                            int LA16_1 = input.LA(2);

                            if ( (LA16_1==RULE_LEFTPAREN) ) {
                                alt16=1;
                            }


                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalXtextTest.g:1037:1: this_COMMA_6= RULE_COMMA ( (lv_assignList_7_0= ruleElement ) )
                    	    {
                    	    this_COMMA_6=(Token)match(input,RULE_COMMA,FOLLOW_8); 
                    	     
                    	        newLeafNode(this_COMMA_6, grammarAccess.getInnerAccess().getCOMMATerminalRuleCall_2_1_2_0()); 
                    	        
                    	    // InternalXtextTest.g:1044:1: ( (lv_assignList_7_0= ruleElement ) )
                    	    // InternalXtextTest.g:1045:1: (lv_assignList_7_0= ruleElement )
                    	    {
                    	    // InternalXtextTest.g:1045:1: (lv_assignList_7_0= ruleElement )
                    	    // InternalXtextTest.g:1046:3: lv_assignList_7_0= ruleElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInnerAccess().getAssignListElementParserRuleCall_2_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_22);
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
                    	    break loop16;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // InternalXtextTest.g:1070:1: (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:1070:1: (this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:1071:1: this_ASSIGNASSTRING_8= RULE_ASSIGNASSTRING ( (lv_value_9_0= RULE_STRING ) )
                    {
                    this_ASSIGNASSTRING_8=(Token)match(input,RULE_ASSIGNASSTRING,FOLLOW_14); 
                     
                        newLeafNode(this_ASSIGNASSTRING_8, grammarAccess.getInnerAccess().getASSIGNASSTRINGTerminalRuleCall_2_2_0()); 
                        
                    // InternalXtextTest.g:1078:1: ( (lv_value_9_0= RULE_STRING ) )
                    // InternalXtextTest.g:1079:1: (lv_value_9_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1079:1: (lv_value_9_0= RULE_STRING )
                    // InternalXtextTest.g:1080:3: lv_value_9_0= RULE_STRING
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
                    // InternalXtextTest.g:1102:1: (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:1102:1: (this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:1103:1: this_ASSIGNASDATALIST_10= RULE_ASSIGNASDATALIST ( (lv_assignAsData_11_0= RULE_STRING ) )
                    {
                    this_ASSIGNASDATALIST_10=(Token)match(input,RULE_ASSIGNASDATALIST,FOLLOW_14); 
                     
                        newLeafNode(this_ASSIGNASDATALIST_10, grammarAccess.getInnerAccess().getASSIGNASDATALISTTerminalRuleCall_2_3_0()); 
                        
                    // InternalXtextTest.g:1110:1: ( (lv_assignAsData_11_0= RULE_STRING ) )
                    // InternalXtextTest.g:1111:1: (lv_assignAsData_11_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1111:1: (lv_assignAsData_11_0= RULE_STRING )
                    // InternalXtextTest.g:1112:3: lv_assignAsData_11_0= RULE_STRING
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
                    // InternalXtextTest.g:1134:1: (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) )
                    {
                    // InternalXtextTest.g:1134:1: (this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) ) )
                    // InternalXtextTest.g:1135:1: this_ASSIGNASBOOL_12= RULE_ASSIGNASBOOL ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) )
                    {
                    this_ASSIGNASBOOL_12=(Token)match(input,RULE_ASSIGNASBOOL,FOLLOW_7); 
                     
                        newLeafNode(this_ASSIGNASBOOL_12, grammarAccess.getInnerAccess().getASSIGNASBOOLTerminalRuleCall_2_4_0()); 
                        
                    // InternalXtextTest.g:1142:1: ( ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) ) )
                    // InternalXtextTest.g:1143:1: ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) )
                    {
                    // InternalXtextTest.g:1143:1: ( (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE ) )
                    // InternalXtextTest.g:1144:1: (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE )
                    {
                    // InternalXtextTest.g:1144:1: (lv_assignAsBool_13_1= RULE_TRUE | lv_assignAsBool_13_2= RULE_FALSE )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_TRUE) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==RULE_FALSE) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalXtextTest.g:1145:3: lv_assignAsBool_13_1= RULE_TRUE
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
                            // InternalXtextTest.g:1160:8: lv_assignAsBool_13_2= RULE_FALSE
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
                    // InternalXtextTest.g:1184:1: ( (lv_isNull_14_0= RULE_ISNULL ) )
                    {
                    // InternalXtextTest.g:1184:1: ( (lv_isNull_14_0= RULE_ISNULL ) )
                    // InternalXtextTest.g:1185:1: (lv_isNull_14_0= RULE_ISNULL )
                    {
                    // InternalXtextTest.g:1185:1: (lv_isNull_14_0= RULE_ISNULL )
                    // InternalXtextTest.g:1186:3: lv_isNull_14_0= RULE_ISNULL
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
                    // InternalXtextTest.g:1206:1: ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) )
                    {
                    // InternalXtextTest.g:1206:1: ( (lv_isNotNull_15_0= RULE_ISNOTNULL ) )
                    // InternalXtextTest.g:1207:1: (lv_isNotNull_15_0= RULE_ISNOTNULL )
                    {
                    // InternalXtextTest.g:1207:1: (lv_isNotNull_15_0= RULE_ISNOTNULL )
                    // InternalXtextTest.g:1208:3: lv_isNotNull_15_0= RULE_ISNOTNULL
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
    // InternalXtextTest.g:1238:1: entryRuleGenerator returns [EObject current=null] : iv_ruleGenerator= ruleGenerator EOF ;
    public final EObject entryRuleGenerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenerator = null;


        try {
            // InternalXtextTest.g:1239:2: (iv_ruleGenerator= ruleGenerator EOF )
            // InternalXtextTest.g:1240:2: iv_ruleGenerator= ruleGenerator EOF
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
    // InternalXtextTest.g:1247:1: ruleGenerator returns [EObject current=null] : ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? ) ;
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
            // InternalXtextTest.g:1253:7: ( ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? ) )
            // InternalXtextTest.g:1255:1: ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? )
            {
            // InternalXtextTest.g:1255:1: ( () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )? )
            // InternalXtextTest.g:1256:1: () (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) ) (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) ) (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )? (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )?
            {
            // InternalXtextTest.g:1256:1: ()
            // InternalXtextTest.g:1257:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getGeneratorAccess().getGeneratorAction_0(),
                        current);
                

            }

            // InternalXtextTest.g:1265:1: (this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) ) )
            // InternalXtextTest.g:1266:1: this_OUTPUT_1= RULE_OUTPUT this_FILE_2= RULE_FILE this_ASSIGNASSINGLE_3= RULE_ASSIGNASSINGLE ( (lv_output_4_0= RULE_STRING ) )
            {
            this_OUTPUT_1=(Token)match(input,RULE_OUTPUT,FOLLOW_23); 
             
                newLeafNode(this_OUTPUT_1, grammarAccess.getGeneratorAccess().getOUTPUTTerminalRuleCall_1_0()); 
                
            this_FILE_2=(Token)match(input,RULE_FILE,FOLLOW_6); 
             
                newLeafNode(this_FILE_2, grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_1_1()); 
                
            this_ASSIGNASSINGLE_3=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_14); 
             
                newLeafNode(this_ASSIGNASSINGLE_3, grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_1_2()); 
                
            // InternalXtextTest.g:1287:1: ( (lv_output_4_0= RULE_STRING ) )
            // InternalXtextTest.g:1288:1: (lv_output_4_0= RULE_STRING )
            {
            // InternalXtextTest.g:1288:1: (lv_output_4_0= RULE_STRING )
            // InternalXtextTest.g:1289:3: lv_output_4_0= RULE_STRING
            {
            lv_output_4_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

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

            // InternalXtextTest.g:1310:1: (this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) ) )
            // InternalXtextTest.g:1311:1: this_EXPECTED_5= RULE_EXPECTED this_FILE_6= RULE_FILE ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) )
            {
            this_EXPECTED_5=(Token)match(input,RULE_EXPECTED,FOLLOW_23); 
             
                newLeafNode(this_EXPECTED_5, grammarAccess.getGeneratorAccess().getEXPECTEDTerminalRuleCall_2_0()); 
                
            this_FILE_6=(Token)match(input,RULE_FILE,FOLLOW_25); 
             
                newLeafNode(this_FILE_6, grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_2_1()); 
                
            // InternalXtextTest.g:1325:1: ( (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) ) | ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ASSIGNASSINGLE) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_ISSAMEASINPUTFILE) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalXtextTest.g:1326:1: (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) )
                    {
                    // InternalXtextTest.g:1326:1: (this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) ) )
                    // InternalXtextTest.g:1327:1: this_ASSIGNASSINGLE_7= RULE_ASSIGNASSINGLE ( (lv_expected_8_0= RULE_STRING ) )
                    {
                    this_ASSIGNASSINGLE_7=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_14); 
                     
                        newLeafNode(this_ASSIGNASSINGLE_7, grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_2_2_0_0()); 
                        
                    // InternalXtextTest.g:1334:1: ( (lv_expected_8_0= RULE_STRING ) )
                    // InternalXtextTest.g:1335:1: (lv_expected_8_0= RULE_STRING )
                    {
                    // InternalXtextTest.g:1335:1: (lv_expected_8_0= RULE_STRING )
                    // InternalXtextTest.g:1336:3: lv_expected_8_0= RULE_STRING
                    {
                    lv_expected_8_0=(Token)match(input,RULE_STRING,FOLLOW_26); 

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
                    // InternalXtextTest.g:1358:1: ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) )
                    {
                    // InternalXtextTest.g:1358:1: ( (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE ) )
                    // InternalXtextTest.g:1359:1: (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE )
                    {
                    // InternalXtextTest.g:1359:1: (lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE )
                    // InternalXtextTest.g:1360:3: lv_isSameAsInputFile_9_0= RULE_ISSAMEASINPUTFILE
                    {
                    lv_isSameAsInputFile_9_0=(Token)match(input,RULE_ISSAMEASINPUTFILE,FOLLOW_26); 

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

            // InternalXtextTest.g:1383:1: (this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_PATTERNS) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalXtextTest.g:1384:1: this_PATTERNS_10= RULE_PATTERNS (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )? ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )*
                    {
                    this_PATTERNS_10=(Token)match(input,RULE_PATTERNS,FOLLOW_27); 
                     
                        newLeafNode(this_PATTERNS_10, grammarAccess.getGeneratorAccess().getPATTERNSTerminalRuleCall_3_0()); 
                        
                    // InternalXtextTest.g:1391:1: (this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) ) )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==RULE_FILE) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalXtextTest.g:1392:1: this_FILE_11= RULE_FILE this_ASSIGNASSINGLE_12= RULE_ASSIGNASSINGLE ( (lv_patternFile_13_0= RULE_STRING ) )
                            {
                            this_FILE_11=(Token)match(input,RULE_FILE,FOLLOW_6); 
                             
                                newLeafNode(this_FILE_11, grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_3_1_0()); 
                                
                            this_ASSIGNASSINGLE_12=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_14); 
                             
                                newLeafNode(this_ASSIGNASSINGLE_12, grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_3_1_1()); 
                                
                            // InternalXtextTest.g:1406:1: ( (lv_patternFile_13_0= RULE_STRING ) )
                            // InternalXtextTest.g:1407:1: (lv_patternFile_13_0= RULE_STRING )
                            {
                            // InternalXtextTest.g:1407:1: (lv_patternFile_13_0= RULE_STRING )
                            // InternalXtextTest.g:1408:3: lv_patternFile_13_0= RULE_STRING
                            {
                            lv_patternFile_13_0=(Token)match(input,RULE_STRING,FOLLOW_28); 

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

                    // InternalXtextTest.g:1429:1: ( (lv_replacePatterns_14_0= ruleReplacePatterns ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==RULE_STRING) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalXtextTest.g:1430:1: (lv_replacePatterns_14_0= ruleReplacePatterns )
                    	    {
                    	    // InternalXtextTest.g:1430:1: (lv_replacePatterns_14_0= ruleReplacePatterns )
                    	    // InternalXtextTest.g:1431:3: lv_replacePatterns_14_0= ruleReplacePatterns
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getGeneratorAccess().getReplacePatternsReplacePatternsParserRuleCall_3_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_28);
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
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalXtextTest.g:1452:1: (this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_EXPECTED) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalXtextTest.g:1453:1: this_EXPECTED_15= RULE_EXPECTED this_EXCEPTIONS_16= RULE_EXCEPTIONS ( (lv_exception_17_0= rulePackageID ) )
                    {
                    this_EXPECTED_15=(Token)match(input,RULE_EXPECTED,FOLLOW_29); 
                     
                        newLeafNode(this_EXPECTED_15, grammarAccess.getGeneratorAccess().getEXPECTEDTerminalRuleCall_4_0()); 
                        
                    this_EXCEPTIONS_16=(Token)match(input,RULE_EXCEPTIONS,FOLLOW_3); 
                     
                        newLeafNode(this_EXCEPTIONS_16, grammarAccess.getGeneratorAccess().getEXCEPTIONSTerminalRuleCall_4_1()); 
                        
                    // InternalXtextTest.g:1467:1: ( (lv_exception_17_0= rulePackageID ) )
                    // InternalXtextTest.g:1468:1: (lv_exception_17_0= rulePackageID )
                    {
                    // InternalXtextTest.g:1468:1: (lv_exception_17_0= rulePackageID )
                    // InternalXtextTest.g:1469:3: lv_exception_17_0= rulePackageID
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
    // InternalXtextTest.g:1499:1: entryRuleReplacePatterns returns [EObject current=null] : iv_ruleReplacePatterns= ruleReplacePatterns EOF ;
    public final EObject entryRuleReplacePatterns() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReplacePatterns = null;


        try {
            // InternalXtextTest.g:1500:2: (iv_ruleReplacePatterns= ruleReplacePatterns EOF )
            // InternalXtextTest.g:1501:2: iv_ruleReplacePatterns= ruleReplacePatterns EOF
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
    // InternalXtextTest.g:1508:1: ruleReplacePatterns returns [EObject current=null] : ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleReplacePatterns() throws RecognitionException {
        EObject current = null;

        Token lv_regex_0_0=null;
        Token this_ASSIGNASSINGLE_1=null;
        Token lv_replace_2_0=null;

         enterRule();
           		/*no init found*/
            
        try {
            // InternalXtextTest.g:1514:7: ( ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) ) )
            // InternalXtextTest.g:1516:1: ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) )
            {
            // InternalXtextTest.g:1516:1: ( ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) ) )
            // InternalXtextTest.g:1517:1: ( (lv_regex_0_0= RULE_STRING ) ) this_ASSIGNASSINGLE_1= RULE_ASSIGNASSINGLE ( (lv_replace_2_0= RULE_STRING ) )
            {
            // InternalXtextTest.g:1517:1: ( (lv_regex_0_0= RULE_STRING ) )
            // InternalXtextTest.g:1518:1: (lv_regex_0_0= RULE_STRING )
            {
            // InternalXtextTest.g:1518:1: (lv_regex_0_0= RULE_STRING )
            // InternalXtextTest.g:1519:3: lv_regex_0_0= RULE_STRING
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
                
            // InternalXtextTest.g:1545:1: ( (lv_replace_2_0= RULE_STRING ) )
            // InternalXtextTest.g:1546:1: (lv_replace_2_0= RULE_STRING )
            {
            // InternalXtextTest.g:1546:1: (lv_replace_2_0= RULE_STRING )
            // InternalXtextTest.g:1547:3: lv_replace_2_0= RULE_STRING
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
    // InternalXtextTest.g:1575:1: entryRuleBefore returns [EObject current=null] : iv_ruleBefore= ruleBefore EOF ;
    public final EObject entryRuleBefore() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBefore = null;


        try {
            // InternalXtextTest.g:1576:2: (iv_ruleBefore= ruleBefore EOF )
            // InternalXtextTest.g:1577:2: iv_ruleBefore= ruleBefore EOF
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
    // InternalXtextTest.g:1584:1: ruleBefore returns [EObject current=null] : (this_BEFORE_KW_0= RULE_BEFORE_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN ) ;
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
            // InternalXtextTest.g:1590:7: ( (this_BEFORE_KW_0= RULE_BEFORE_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:1592:1: (this_BEFORE_KW_0= RULE_BEFORE_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:1592:1: (this_BEFORE_KW_0= RULE_BEFORE_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            // InternalXtextTest.g:1593:1: this_BEFORE_KW_0= RULE_BEFORE_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN
            {
            this_BEFORE_KW_0=(Token)match(input,RULE_BEFORE_KW,FOLLOW_30); 
             
                newLeafNode(this_BEFORE_KW_0, grammarAccess.getBeforeAccess().getBEFORE_KWTerminalRuleCall_0()); 
                
            this_CLASS_KW_1=(Token)match(input,RULE_CLASS_KW,FOLLOW_6); 
             
                newLeafNode(this_CLASS_KW_1, grammarAccess.getBeforeAccess().getCLASS_KWTerminalRuleCall_1()); 
                
            this_ASSIGNASSINGLE_2=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_3); 
             
                newLeafNode(this_ASSIGNASSINGLE_2, grammarAccess.getBeforeAccess().getASSIGNASSINGLETerminalRuleCall_2()); 
                
            // InternalXtextTest.g:1614:1: ( (lv_myclass_3_0= rulePackageID ) )
            // InternalXtextTest.g:1615:1: (lv_myclass_3_0= rulePackageID )
            {
            // InternalXtextTest.g:1615:1: (lv_myclass_3_0= rulePackageID )
            // InternalXtextTest.g:1616:3: lv_myclass_3_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getBeforeAccess().getMyclassPackageIDParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_31);
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
                
            // InternalXtextTest.g:1649:1: ( (lv_method_6_0= rulePackageID ) )
            // InternalXtextTest.g:1650:1: (lv_method_6_0= rulePackageID )
            {
            // InternalXtextTest.g:1650:1: (lv_method_6_0= rulePackageID )
            // InternalXtextTest.g:1651:3: lv_method_6_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getBeforeAccess().getMethodPackageIDParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_32);
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

            this_LEFTPAREN_7=(Token)match(input,RULE_LEFTPAREN,FOLLOW_33); 
             
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
    // InternalXtextTest.g:1693:1: entryRuleAfter returns [EObject current=null] : iv_ruleAfter= ruleAfter EOF ;
    public final EObject entryRuleAfter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAfter = null;


        try {
            // InternalXtextTest.g:1694:2: (iv_ruleAfter= ruleAfter EOF )
            // InternalXtextTest.g:1695:2: iv_ruleAfter= ruleAfter EOF
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
    // InternalXtextTest.g:1702:1: ruleAfter returns [EObject current=null] : (this_AFTER_KW_0= RULE_AFTER_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN ) ;
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
            // InternalXtextTest.g:1708:7: ( (this_AFTER_KW_0= RULE_AFTER_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:1710:1: (this_AFTER_KW_0= RULE_AFTER_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:1710:1: (this_AFTER_KW_0= RULE_AFTER_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN )
            // InternalXtextTest.g:1711:1: this_AFTER_KW_0= RULE_AFTER_KW this_CLASS_KW_1= RULE_CLASS_KW this_ASSIGNASSINGLE_2= RULE_ASSIGNASSINGLE ( (lv_myclass_3_0= rulePackageID ) ) this_METHOD_KW_4= RULE_METHOD_KW this_ASSIGNASSINGLE_5= RULE_ASSIGNASSINGLE ( (lv_method_6_0= rulePackageID ) ) this_LEFTPAREN_7= RULE_LEFTPAREN this_RIGHTPAREN_8= RULE_RIGHTPAREN
            {
            this_AFTER_KW_0=(Token)match(input,RULE_AFTER_KW,FOLLOW_30); 
             
                newLeafNode(this_AFTER_KW_0, grammarAccess.getAfterAccess().getAFTER_KWTerminalRuleCall_0()); 
                
            this_CLASS_KW_1=(Token)match(input,RULE_CLASS_KW,FOLLOW_6); 
             
                newLeafNode(this_CLASS_KW_1, grammarAccess.getAfterAccess().getCLASS_KWTerminalRuleCall_1()); 
                
            this_ASSIGNASSINGLE_2=(Token)match(input,RULE_ASSIGNASSINGLE,FOLLOW_3); 
             
                newLeafNode(this_ASSIGNASSINGLE_2, grammarAccess.getAfterAccess().getASSIGNASSINGLETerminalRuleCall_2()); 
                
            // InternalXtextTest.g:1732:1: ( (lv_myclass_3_0= rulePackageID ) )
            // InternalXtextTest.g:1733:1: (lv_myclass_3_0= rulePackageID )
            {
            // InternalXtextTest.g:1733:1: (lv_myclass_3_0= rulePackageID )
            // InternalXtextTest.g:1734:3: lv_myclass_3_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getAfterAccess().getMyclassPackageIDParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_31);
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
                
            // InternalXtextTest.g:1767:1: ( (lv_method_6_0= rulePackageID ) )
            // InternalXtextTest.g:1768:1: (lv_method_6_0= rulePackageID )
            {
            // InternalXtextTest.g:1768:1: (lv_method_6_0= rulePackageID )
            // InternalXtextTest.g:1769:3: lv_method_6_0= rulePackageID
            {
             
            	        newCompositeNode(grammarAccess.getAfterAccess().getMethodPackageIDParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_32);
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

            this_LEFTPAREN_7=(Token)match(input,RULE_LEFTPAREN,FOLLOW_33); 
             
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000020C0L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000002420000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000002400000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800800L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000000001F040100L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000080000100L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000140000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000040018002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040008002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000800000L});

}