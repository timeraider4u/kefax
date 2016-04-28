package at.jku.weiner.xtexttest.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import at.jku.weiner.xtexttest.services.XtextTestGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextTestParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_IDENTIFIER", "RULE_TRUE", "RULE_FALSE", "RULE_PACKAGE", "RULE_LANGUAGE", "RULE_IMPORTS", "RULE_SPLITLEXER", "RULE_ASSIGNASSINGLE", "RULE_TIMEOUT", "RULE_KW_EMFTEST", "RULE_DEFAULT", "RULE_OPTIONS", "RULE_PARAMS", "RULE_SOURCE", "RULE_FILE", "RULE_KW_AS", "RULE_POINT", "RULE_SRCTEXT", "RULE_LEXER", "RULE_ASSIGNASDATALIST", "RULE_LEFTPAREN", "RULE_RIGHTPAREN", "RULE_IMPORTER", "RULE_COMMA", "RULE_ASSIGNASLIST", "RULE_ASSIGNASSTRING", "RULE_ASSIGNASBOOL", "RULE_OUTPUT", "RULE_EXPECTED", "RULE_PATTERNS", "RULE_EXCEPTIONS", "RULE_BEFORE_KW", "RULE_AFTER_KW", "RULE_CLASS_KW", "RULE_METHOD_KW", "RULE_INT", "RULE_STRING", "RULE_ISNULL", "RULE_ISNOTNULL", "RULE_ISEMPTY", "RULE_ISSAMEASINPUTFILE", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=45;
    public static final int RULE_IMPORTER=26;
    public static final int RULE_ANY_OTHER=49;
    public static final int RULE_SPLITLEXER=10;
    public static final int RULE_LANGUAGE=8;
    public static final int RULE_ASSIGNASBOOL=30;
    public static final int EOF=-1;
    public static final int RULE_PACKAGE=7;
    public static final int RULE_FALSE=6;
    public static final int RULE_ASSIGNASSINGLE=11;
    public static final int RULE_KW_EMFTEST=13;
    public static final int RULE_ASSIGNASLIST=28;
    public static final int RULE_POINT=20;
    public static final int RULE_PARAMS=16;
    public static final int RULE_INT=39;
    public static final int RULE_CLASS_KW=37;
    public static final int RULE_ASSIGNASSTRING=29;
    public static final int RULE_OPTIONS=15;
    public static final int RULE_ISSAMEASINPUTFILE=44;
    public static final int RULE_TIMEOUT=12;
    public static final int RULE_SRCTEXT=21;
    public static final int RULE_IMPORTS=9;
    public static final int RULE_RIGHTPAREN=25;
    public static final int RULE_PATTERNS=33;
    public static final int RULE_METHOD_KW=38;
    public static final int RULE_ASSIGNASDATALIST=23;
    public static final int RULE_ISEMPTY=43;
    public static final int RULE_EXPECTED=32;
    public static final int RULE_ISNULL=41;
    public static final int RULE_FILE=18;
    public static final int RULE_IDENTIFIER=4;
    public static final int RULE_COMMA=27;
    public static final int RULE_AFTER_KW=36;
    public static final int RULE_SL_COMMENT=47;
    public static final int RULE_ISNOTNULL=42;
    public static final int RULE_DEFAULT=14;
    public static final int RULE_ML_COMMENT=46;
    public static final int RULE_TRUE=5;
    public static final int RULE_BEFORE_KW=35;
    public static final int RULE_SOURCE=17;
    public static final int RULE_LEFTPAREN=24;
    public static final int RULE_STRING=40;
    public static final int RULE_EXCEPTIONS=34;
    public static final int RULE_LEXER=22;
    public static final int RULE_OUTPUT=31;
    public static final int RULE_WS=48;
    public static final int RULE_KW_AS=19;

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
     	
        public void setGrammarAccess(XtextTestGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleModel"
    // InternalXtextTest.g:62:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalXtextTest.g:63:1: ( ruleModel EOF )
            // InternalXtextTest.g:64:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalXtextTest.g:71:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:78:7: ( ( ( rule__Model__Group__0 ) ) )
            // InternalXtextTest.g:80:1: ( ( rule__Model__Group__0 ) )
            {
            // InternalXtextTest.g:80:1: ( ( rule__Model__Group__0 ) )
            // InternalXtextTest.g:81:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalXtextTest.g:82:1: ( rule__Model__Group__0 )
            // InternalXtextTest.g:82:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleXtextTest"
    // InternalXtextTest.g:97:1: entryRuleXtextTest : ruleXtextTest EOF ;
    public final void entryRuleXtextTest() throws RecognitionException {
        try {
            // InternalXtextTest.g:98:1: ( ruleXtextTest EOF )
            // InternalXtextTest.g:99:1: ruleXtextTest EOF
            {
             before(grammarAccess.getXtextTestRule()); 
            pushFollow(FOLLOW_1);
            ruleXtextTest();

            state._fsp--;

             after(grammarAccess.getXtextTestRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXtextTest"


    // $ANTLR start "ruleXtextTest"
    // InternalXtextTest.g:106:1: ruleXtextTest : ( ( rule__XtextTest__Group__0 ) ) ;
    public final void ruleXtextTest() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:113:7: ( ( ( rule__XtextTest__Group__0 ) ) )
            // InternalXtextTest.g:115:1: ( ( rule__XtextTest__Group__0 ) )
            {
            // InternalXtextTest.g:115:1: ( ( rule__XtextTest__Group__0 ) )
            // InternalXtextTest.g:116:1: ( rule__XtextTest__Group__0 )
            {
             before(grammarAccess.getXtextTestAccess().getGroup()); 
            // InternalXtextTest.g:117:1: ( rule__XtextTest__Group__0 )
            // InternalXtextTest.g:117:2: rule__XtextTest__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXtextTestAccess().getGroup()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXtextTest"


    // $ANTLR start "entryRuleEmfTest"
    // InternalXtextTest.g:132:1: entryRuleEmfTest : ruleEmfTest EOF ;
    public final void entryRuleEmfTest() throws RecognitionException {
        try {
            // InternalXtextTest.g:133:1: ( ruleEmfTest EOF )
            // InternalXtextTest.g:134:1: ruleEmfTest EOF
            {
             before(grammarAccess.getEmfTestRule()); 
            pushFollow(FOLLOW_1);
            ruleEmfTest();

            state._fsp--;

             after(grammarAccess.getEmfTestRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEmfTest"


    // $ANTLR start "ruleEmfTest"
    // InternalXtextTest.g:141:1: ruleEmfTest : ( ( rule__EmfTest__Group__0 ) ) ;
    public final void ruleEmfTest() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:148:7: ( ( ( rule__EmfTest__Group__0 ) ) )
            // InternalXtextTest.g:150:1: ( ( rule__EmfTest__Group__0 ) )
            {
            // InternalXtextTest.g:150:1: ( ( rule__EmfTest__Group__0 ) )
            // InternalXtextTest.g:151:1: ( rule__EmfTest__Group__0 )
            {
             before(grammarAccess.getEmfTestAccess().getGroup()); 
            // InternalXtextTest.g:152:1: ( rule__EmfTest__Group__0 )
            // InternalXtextTest.g:152:2: rule__EmfTest__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEmfTestAccess().getGroup()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEmfTest"


    // $ANTLR start "entryRuleImport"
    // InternalXtextTest.g:167:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalXtextTest.g:168:1: ( ruleImport EOF )
            // InternalXtextTest.g:169:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalXtextTest.g:176:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:183:7: ( ( ( rule__Import__Group__0 ) ) )
            // InternalXtextTest.g:185:1: ( ( rule__Import__Group__0 ) )
            {
            // InternalXtextTest.g:185:1: ( ( rule__Import__Group__0 ) )
            // InternalXtextTest.g:186:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalXtextTest.g:187:1: ( rule__Import__Group__0 )
            // InternalXtextTest.g:187:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleBoolean"
    // InternalXtextTest.g:202:1: entryRuleBoolean : ruleBoolean EOF ;
    public final void entryRuleBoolean() throws RecognitionException {
        try {
            // InternalXtextTest.g:203:1: ( ruleBoolean EOF )
            // InternalXtextTest.g:204:1: ruleBoolean EOF
            {
             before(grammarAccess.getBooleanRule()); 
            pushFollow(FOLLOW_1);
            ruleBoolean();

            state._fsp--;

             after(grammarAccess.getBooleanRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // InternalXtextTest.g:211:1: ruleBoolean : ( ( rule__Boolean__Alternatives ) ) ;
    public final void ruleBoolean() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:218:7: ( ( ( rule__Boolean__Alternatives ) ) )
            // InternalXtextTest.g:220:1: ( ( rule__Boolean__Alternatives ) )
            {
            // InternalXtextTest.g:220:1: ( ( rule__Boolean__Alternatives ) )
            // InternalXtextTest.g:221:1: ( rule__Boolean__Alternatives )
            {
             before(grammarAccess.getBooleanAccess().getAlternatives()); 
            // InternalXtextTest.g:222:1: ( rule__Boolean__Alternatives )
            // InternalXtextTest.g:222:2: rule__Boolean__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Boolean__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBooleanAccess().getAlternatives()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRulePackageID"
    // InternalXtextTest.g:237:1: entryRulePackageID : rulePackageID EOF ;
    public final void entryRulePackageID() throws RecognitionException {
        try {
            // InternalXtextTest.g:238:1: ( rulePackageID EOF )
            // InternalXtextTest.g:239:1: rulePackageID EOF
            {
             before(grammarAccess.getPackageIDRule()); 
            pushFollow(FOLLOW_1);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getPackageIDRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePackageID"


    // $ANTLR start "rulePackageID"
    // InternalXtextTest.g:246:1: rulePackageID : ( ( rule__PackageID__Group__0 ) ) ;
    public final void rulePackageID() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:253:7: ( ( ( rule__PackageID__Group__0 ) ) )
            // InternalXtextTest.g:255:1: ( ( rule__PackageID__Group__0 ) )
            {
            // InternalXtextTest.g:255:1: ( ( rule__PackageID__Group__0 ) )
            // InternalXtextTest.g:256:1: ( rule__PackageID__Group__0 )
            {
             before(grammarAccess.getPackageIDAccess().getGroup()); 
            // InternalXtextTest.g:257:1: ( rule__PackageID__Group__0 )
            // InternalXtextTest.g:257:2: rule__PackageID__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PackageID__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPackageIDAccess().getGroup()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePackageID"


    // $ANTLR start "entryRuleLangID"
    // InternalXtextTest.g:272:1: entryRuleLangID : ruleLangID EOF ;
    public final void entryRuleLangID() throws RecognitionException {
        try {
            // InternalXtextTest.g:273:1: ( ruleLangID EOF )
            // InternalXtextTest.g:274:1: ruleLangID EOF
            {
             before(grammarAccess.getLangIDRule()); 
            pushFollow(FOLLOW_1);
            ruleLangID();

            state._fsp--;

             after(grammarAccess.getLangIDRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLangID"


    // $ANTLR start "ruleLangID"
    // InternalXtextTest.g:281:1: ruleLangID : ( RULE_IDENTIFIER ) ;
    public final void ruleLangID() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:288:7: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:290:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:290:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:291:1: RULE_IDENTIFIER
            {
             before(grammarAccess.getLangIDAccess().getIDENTIFIERTerminalRuleCall()); 
            match(input,RULE_IDENTIFIER,FOLLOW_2); 
             after(grammarAccess.getLangIDAccess().getIDENTIFIERTerminalRuleCall()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLangID"


    // $ANTLR start "entryRuleImportID"
    // InternalXtextTest.g:307:1: entryRuleImportID : ruleImportID EOF ;
    public final void entryRuleImportID() throws RecognitionException {
        try {
            // InternalXtextTest.g:308:1: ( ruleImportID EOF )
            // InternalXtextTest.g:309:1: ruleImportID EOF
            {
             before(grammarAccess.getImportIDRule()); 
            pushFollow(FOLLOW_1);
            ruleImportID();

            state._fsp--;

             after(grammarAccess.getImportIDRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImportID"


    // $ANTLR start "ruleImportID"
    // InternalXtextTest.g:316:1: ruleImportID : ( ( rule__ImportID__Group__0 ) ) ;
    public final void ruleImportID() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:323:7: ( ( ( rule__ImportID__Group__0 ) ) )
            // InternalXtextTest.g:325:1: ( ( rule__ImportID__Group__0 ) )
            {
            // InternalXtextTest.g:325:1: ( ( rule__ImportID__Group__0 ) )
            // InternalXtextTest.g:326:1: ( rule__ImportID__Group__0 )
            {
             before(grammarAccess.getImportIDAccess().getGroup()); 
            // InternalXtextTest.g:327:1: ( rule__ImportID__Group__0 )
            // InternalXtextTest.g:327:2: rule__ImportID__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ImportID__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportIDAccess().getGroup()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImportID"


    // $ANTLR start "entryRuleInput"
    // InternalXtextTest.g:342:1: entryRuleInput : ruleInput EOF ;
    public final void entryRuleInput() throws RecognitionException {
        try {
            // InternalXtextTest.g:343:1: ( ruleInput EOF )
            // InternalXtextTest.g:344:1: ruleInput EOF
            {
             before(grammarAccess.getInputRule()); 
            pushFollow(FOLLOW_1);
            ruleInput();

            state._fsp--;

             after(grammarAccess.getInputRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInput"


    // $ANTLR start "ruleInput"
    // InternalXtextTest.g:351:1: ruleInput : ( ( rule__Input__Group__0 ) ) ;
    public final void ruleInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:358:7: ( ( ( rule__Input__Group__0 ) ) )
            // InternalXtextTest.g:360:1: ( ( rule__Input__Group__0 ) )
            {
            // InternalXtextTest.g:360:1: ( ( rule__Input__Group__0 ) )
            // InternalXtextTest.g:361:1: ( rule__Input__Group__0 )
            {
             before(grammarAccess.getInputAccess().getGroup()); 
            // InternalXtextTest.g:362:1: ( rule__Input__Group__0 )
            // InternalXtextTest.g:362:2: rule__Input__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Input__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInputAccess().getGroup()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInput"


    // $ANTLR start "entryRuleTokens"
    // InternalXtextTest.g:377:1: entryRuleTokens : ruleTokens EOF ;
    public final void entryRuleTokens() throws RecognitionException {
        try {
            // InternalXtextTest.g:378:1: ( ruleTokens EOF )
            // InternalXtextTest.g:379:1: ruleTokens EOF
            {
             before(grammarAccess.getTokensRule()); 
            pushFollow(FOLLOW_1);
            ruleTokens();

            state._fsp--;

             after(grammarAccess.getTokensRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTokens"


    // $ANTLR start "ruleTokens"
    // InternalXtextTest.g:386:1: ruleTokens : ( ( rule__Tokens__Group__0 ) ) ;
    public final void ruleTokens() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:393:7: ( ( ( rule__Tokens__Group__0 ) ) )
            // InternalXtextTest.g:395:1: ( ( rule__Tokens__Group__0 ) )
            {
            // InternalXtextTest.g:395:1: ( ( rule__Tokens__Group__0 ) )
            // InternalXtextTest.g:396:1: ( rule__Tokens__Group__0 )
            {
             before(grammarAccess.getTokensAccess().getGroup()); 
            // InternalXtextTest.g:397:1: ( rule__Tokens__Group__0 )
            // InternalXtextTest.g:397:2: rule__Tokens__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Tokens__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTokensAccess().getGroup()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTokens"


    // $ANTLR start "entryRuleMyTokens"
    // InternalXtextTest.g:412:1: entryRuleMyTokens : ruleMyTokens EOF ;
    public final void entryRuleMyTokens() throws RecognitionException {
        try {
            // InternalXtextTest.g:413:1: ( ruleMyTokens EOF )
            // InternalXtextTest.g:414:1: ruleMyTokens EOF
            {
             before(grammarAccess.getMyTokensRule()); 
            pushFollow(FOLLOW_1);
            ruleMyTokens();

            state._fsp--;

             after(grammarAccess.getMyTokensRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMyTokens"


    // $ANTLR start "ruleMyTokens"
    // InternalXtextTest.g:421:1: ruleMyTokens : ( ( rule__MyTokens__Group__0 ) ) ;
    public final void ruleMyTokens() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:428:7: ( ( ( rule__MyTokens__Group__0 ) ) )
            // InternalXtextTest.g:430:1: ( ( rule__MyTokens__Group__0 ) )
            {
            // InternalXtextTest.g:430:1: ( ( rule__MyTokens__Group__0 ) )
            // InternalXtextTest.g:431:1: ( rule__MyTokens__Group__0 )
            {
             before(grammarAccess.getMyTokensAccess().getGroup()); 
            // InternalXtextTest.g:432:1: ( rule__MyTokens__Group__0 )
            // InternalXtextTest.g:432:2: rule__MyTokens__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MyTokens__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMyTokensAccess().getGroup()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyTokens"


    // $ANTLR start "entryRuleElement"
    // InternalXtextTest.g:447:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalXtextTest.g:448:1: ( ruleElement EOF )
            // InternalXtextTest.g:449:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalXtextTest.g:456:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:463:7: ( ( ( rule__Element__Group__0 ) ) )
            // InternalXtextTest.g:465:1: ( ( rule__Element__Group__0 ) )
            {
            // InternalXtextTest.g:465:1: ( ( rule__Element__Group__0 ) )
            // InternalXtextTest.g:466:1: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // InternalXtextTest.g:467:1: ( rule__Element__Group__0 )
            // InternalXtextTest.g:467:2: rule__Element__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getGroup()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleInner"
    // InternalXtextTest.g:482:1: entryRuleInner : ruleInner EOF ;
    public final void entryRuleInner() throws RecognitionException {
        try {
            // InternalXtextTest.g:483:1: ( ruleInner EOF )
            // InternalXtextTest.g:484:1: ruleInner EOF
            {
             before(grammarAccess.getInnerRule()); 
            pushFollow(FOLLOW_1);
            ruleInner();

            state._fsp--;

             after(grammarAccess.getInnerRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInner"


    // $ANTLR start "ruleInner"
    // InternalXtextTest.g:491:1: ruleInner : ( ( rule__Inner__Group__0 ) ) ;
    public final void ruleInner() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:498:7: ( ( ( rule__Inner__Group__0 ) ) )
            // InternalXtextTest.g:500:1: ( ( rule__Inner__Group__0 ) )
            {
            // InternalXtextTest.g:500:1: ( ( rule__Inner__Group__0 ) )
            // InternalXtextTest.g:501:1: ( rule__Inner__Group__0 )
            {
             before(grammarAccess.getInnerAccess().getGroup()); 
            // InternalXtextTest.g:502:1: ( rule__Inner__Group__0 )
            // InternalXtextTest.g:502:2: rule__Inner__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Inner__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInnerAccess().getGroup()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInner"


    // $ANTLR start "entryRuleGenerator"
    // InternalXtextTest.g:517:1: entryRuleGenerator : ruleGenerator EOF ;
    public final void entryRuleGenerator() throws RecognitionException {
        try {
            // InternalXtextTest.g:518:1: ( ruleGenerator EOF )
            // InternalXtextTest.g:519:1: ruleGenerator EOF
            {
             before(grammarAccess.getGeneratorRule()); 
            pushFollow(FOLLOW_1);
            ruleGenerator();

            state._fsp--;

             after(grammarAccess.getGeneratorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGenerator"


    // $ANTLR start "ruleGenerator"
    // InternalXtextTest.g:526:1: ruleGenerator : ( ( rule__Generator__Group__0 ) ) ;
    public final void ruleGenerator() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:533:7: ( ( ( rule__Generator__Group__0 ) ) )
            // InternalXtextTest.g:535:1: ( ( rule__Generator__Group__0 ) )
            {
            // InternalXtextTest.g:535:1: ( ( rule__Generator__Group__0 ) )
            // InternalXtextTest.g:536:1: ( rule__Generator__Group__0 )
            {
             before(grammarAccess.getGeneratorAccess().getGroup()); 
            // InternalXtextTest.g:537:1: ( rule__Generator__Group__0 )
            // InternalXtextTest.g:537:2: rule__Generator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Generator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGeneratorAccess().getGroup()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGenerator"


    // $ANTLR start "entryRuleReplacePatterns"
    // InternalXtextTest.g:552:1: entryRuleReplacePatterns : ruleReplacePatterns EOF ;
    public final void entryRuleReplacePatterns() throws RecognitionException {
        try {
            // InternalXtextTest.g:553:1: ( ruleReplacePatterns EOF )
            // InternalXtextTest.g:554:1: ruleReplacePatterns EOF
            {
             before(grammarAccess.getReplacePatternsRule()); 
            pushFollow(FOLLOW_1);
            ruleReplacePatterns();

            state._fsp--;

             after(grammarAccess.getReplacePatternsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleReplacePatterns"


    // $ANTLR start "ruleReplacePatterns"
    // InternalXtextTest.g:561:1: ruleReplacePatterns : ( ( rule__ReplacePatterns__Group__0 ) ) ;
    public final void ruleReplacePatterns() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:568:7: ( ( ( rule__ReplacePatterns__Group__0 ) ) )
            // InternalXtextTest.g:570:1: ( ( rule__ReplacePatterns__Group__0 ) )
            {
            // InternalXtextTest.g:570:1: ( ( rule__ReplacePatterns__Group__0 ) )
            // InternalXtextTest.g:571:1: ( rule__ReplacePatterns__Group__0 )
            {
             before(grammarAccess.getReplacePatternsAccess().getGroup()); 
            // InternalXtextTest.g:572:1: ( rule__ReplacePatterns__Group__0 )
            // InternalXtextTest.g:572:2: rule__ReplacePatterns__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ReplacePatterns__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReplacePatternsAccess().getGroup()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReplacePatterns"


    // $ANTLR start "entryRuleBefore"
    // InternalXtextTest.g:587:1: entryRuleBefore : ruleBefore EOF ;
    public final void entryRuleBefore() throws RecognitionException {
        try {
            // InternalXtextTest.g:588:1: ( ruleBefore EOF )
            // InternalXtextTest.g:589:1: ruleBefore EOF
            {
             before(grammarAccess.getBeforeRule()); 
            pushFollow(FOLLOW_1);
            ruleBefore();

            state._fsp--;

             after(grammarAccess.getBeforeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBefore"


    // $ANTLR start "ruleBefore"
    // InternalXtextTest.g:596:1: ruleBefore : ( ( rule__Before__Group__0 ) ) ;
    public final void ruleBefore() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:603:7: ( ( ( rule__Before__Group__0 ) ) )
            // InternalXtextTest.g:605:1: ( ( rule__Before__Group__0 ) )
            {
            // InternalXtextTest.g:605:1: ( ( rule__Before__Group__0 ) )
            // InternalXtextTest.g:606:1: ( rule__Before__Group__0 )
            {
             before(grammarAccess.getBeforeAccess().getGroup()); 
            // InternalXtextTest.g:607:1: ( rule__Before__Group__0 )
            // InternalXtextTest.g:607:2: rule__Before__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Before__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBeforeAccess().getGroup()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBefore"


    // $ANTLR start "entryRuleAfter"
    // InternalXtextTest.g:622:1: entryRuleAfter : ruleAfter EOF ;
    public final void entryRuleAfter() throws RecognitionException {
        try {
            // InternalXtextTest.g:623:1: ( ruleAfter EOF )
            // InternalXtextTest.g:624:1: ruleAfter EOF
            {
             before(grammarAccess.getAfterRule()); 
            pushFollow(FOLLOW_1);
            ruleAfter();

            state._fsp--;

             after(grammarAccess.getAfterRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAfter"


    // $ANTLR start "ruleAfter"
    // InternalXtextTest.g:631:1: ruleAfter : ( ( rule__After__Group__0 ) ) ;
    public final void ruleAfter() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:638:7: ( ( ( rule__After__Group__0 ) ) )
            // InternalXtextTest.g:640:1: ( ( rule__After__Group__0 ) )
            {
            // InternalXtextTest.g:640:1: ( ( rule__After__Group__0 ) )
            // InternalXtextTest.g:641:1: ( rule__After__Group__0 )
            {
             before(grammarAccess.getAfterAccess().getGroup()); 
            // InternalXtextTest.g:642:1: ( rule__After__Group__0 )
            // InternalXtextTest.g:642:2: rule__After__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__After__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAfterAccess().getGroup()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAfter"


    // $ANTLR start "entryRuleCodeCall"
    // InternalXtextTest.g:657:1: entryRuleCodeCall : ruleCodeCall EOF ;
    public final void entryRuleCodeCall() throws RecognitionException {
        try {
            // InternalXtextTest.g:658:1: ( ruleCodeCall EOF )
            // InternalXtextTest.g:659:1: ruleCodeCall EOF
            {
             before(grammarAccess.getCodeCallRule()); 
            pushFollow(FOLLOW_1);
            ruleCodeCall();

            state._fsp--;

             after(grammarAccess.getCodeCallRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCodeCall"


    // $ANTLR start "ruleCodeCall"
    // InternalXtextTest.g:666:1: ruleCodeCall : ( ( rule__CodeCall__Group__0 ) ) ;
    public final void ruleCodeCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:673:7: ( ( ( rule__CodeCall__Group__0 ) ) )
            // InternalXtextTest.g:675:1: ( ( rule__CodeCall__Group__0 ) )
            {
            // InternalXtextTest.g:675:1: ( ( rule__CodeCall__Group__0 ) )
            // InternalXtextTest.g:676:1: ( rule__CodeCall__Group__0 )
            {
             before(grammarAccess.getCodeCallAccess().getGroup()); 
            // InternalXtextTest.g:677:1: ( rule__CodeCall__Group__0 )
            // InternalXtextTest.g:677:2: rule__CodeCall__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCodeCallAccess().getGroup()); 

            }


            }


                		/*no after found*/
                 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCodeCall"


    // $ANTLR start "rule__Model__Alternatives_1"
    // InternalXtextTest.g:691:1: rule__Model__Alternatives_1 : ( ( ( rule__Model__XtextTestAssignment_1_0 ) ) | ( ( rule__Model__EmfTestAssignment_1_1 ) ) );
    public final void rule__Model__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:695:1: ( ( ( rule__Model__XtextTestAssignment_1_0 ) ) | ( ( rule__Model__EmfTestAssignment_1_1 ) ) )
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
                    // InternalXtextTest.g:697:1: ( ( rule__Model__XtextTestAssignment_1_0 ) )
                    {
                    // InternalXtextTest.g:697:1: ( ( rule__Model__XtextTestAssignment_1_0 ) )
                    // InternalXtextTest.g:698:1: ( rule__Model__XtextTestAssignment_1_0 )
                    {
                     before(grammarAccess.getModelAccess().getXtextTestAssignment_1_0()); 
                    // InternalXtextTest.g:699:1: ( rule__Model__XtextTestAssignment_1_0 )
                    // InternalXtextTest.g:699:2: rule__Model__XtextTestAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__XtextTestAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getXtextTestAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:706:1: ( ( rule__Model__EmfTestAssignment_1_1 ) )
                    {
                    // InternalXtextTest.g:706:1: ( ( rule__Model__EmfTestAssignment_1_1 ) )
                    // InternalXtextTest.g:707:1: ( rule__Model__EmfTestAssignment_1_1 )
                    {
                     before(grammarAccess.getModelAccess().getEmfTestAssignment_1_1()); 
                    // InternalXtextTest.g:708:1: ( rule__Model__EmfTestAssignment_1_1 )
                    // InternalXtextTest.g:708:2: rule__Model__EmfTestAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__EmfTestAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getEmfTestAssignment_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Alternatives_1"


    // $ANTLR start "rule__Boolean__Alternatives"
    // InternalXtextTest.g:719:1: rule__Boolean__Alternatives : ( ( RULE_TRUE ) | ( RULE_FALSE ) );
    public final void rule__Boolean__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:723:1: ( ( RULE_TRUE ) | ( RULE_FALSE ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_TRUE) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_FALSE) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalXtextTest.g:725:1: ( RULE_TRUE )
                    {
                    // InternalXtextTest.g:725:1: ( RULE_TRUE )
                    // InternalXtextTest.g:726:1: RULE_TRUE
                    {
                     before(grammarAccess.getBooleanAccess().getTRUETerminalRuleCall_0()); 
                    match(input,RULE_TRUE,FOLLOW_2); 
                     after(grammarAccess.getBooleanAccess().getTRUETerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:734:1: ( RULE_FALSE )
                    {
                    // InternalXtextTest.g:734:1: ( RULE_FALSE )
                    // InternalXtextTest.g:735:1: RULE_FALSE
                    {
                     before(grammarAccess.getBooleanAccess().getFALSETerminalRuleCall_1()); 
                    match(input,RULE_FALSE,FOLLOW_2); 
                     after(grammarAccess.getBooleanAccess().getFALSETerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Boolean__Alternatives"


    // $ANTLR start "rule__Input__Alternatives_2"
    // InternalXtextTest.g:747:1: rule__Input__Alternatives_2 : ( ( ( rule__Input__Group_2_0__0 ) ) | ( ( rule__Input__Group_2_1__0 ) ) );
    public final void rule__Input__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:751:1: ( ( ( rule__Input__Group_2_0__0 ) ) | ( ( rule__Input__Group_2_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_SRCTEXT) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_FILE) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalXtextTest.g:753:1: ( ( rule__Input__Group_2_0__0 ) )
                    {
                    // InternalXtextTest.g:753:1: ( ( rule__Input__Group_2_0__0 ) )
                    // InternalXtextTest.g:754:1: ( rule__Input__Group_2_0__0 )
                    {
                     before(grammarAccess.getInputAccess().getGroup_2_0()); 
                    // InternalXtextTest.g:755:1: ( rule__Input__Group_2_0__0 )
                    // InternalXtextTest.g:755:2: rule__Input__Group_2_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Input__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInputAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:762:1: ( ( rule__Input__Group_2_1__0 ) )
                    {
                    // InternalXtextTest.g:762:1: ( ( rule__Input__Group_2_1__0 ) )
                    // InternalXtextTest.g:763:1: ( rule__Input__Group_2_1__0 )
                    {
                     before(grammarAccess.getInputAccess().getGroup_2_1()); 
                    // InternalXtextTest.g:764:1: ( rule__Input__Group_2_1__0 )
                    // InternalXtextTest.g:764:2: rule__Input__Group_2_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Input__Group_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInputAccess().getGroup_2_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Alternatives_2"


    // $ANTLR start "rule__MyTokens__Alternatives_0"
    // InternalXtextTest.g:775:1: rule__MyTokens__Alternatives_0 : ( ( ( rule__MyTokens__TokenAssignment_0_0 ) ) | ( ( rule__MyTokens__StringAssignment_0_1 ) ) );
    public final void rule__MyTokens__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:779:1: ( ( ( rule__MyTokens__TokenAssignment_0_0 ) ) | ( ( rule__MyTokens__StringAssignment_0_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_IDENTIFIER) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_STRING) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalXtextTest.g:781:1: ( ( rule__MyTokens__TokenAssignment_0_0 ) )
                    {
                    // InternalXtextTest.g:781:1: ( ( rule__MyTokens__TokenAssignment_0_0 ) )
                    // InternalXtextTest.g:782:1: ( rule__MyTokens__TokenAssignment_0_0 )
                    {
                     before(grammarAccess.getMyTokensAccess().getTokenAssignment_0_0()); 
                    // InternalXtextTest.g:783:1: ( rule__MyTokens__TokenAssignment_0_0 )
                    // InternalXtextTest.g:783:2: rule__MyTokens__TokenAssignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MyTokens__TokenAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMyTokensAccess().getTokenAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:790:1: ( ( rule__MyTokens__StringAssignment_0_1 ) )
                    {
                    // InternalXtextTest.g:790:1: ( ( rule__MyTokens__StringAssignment_0_1 ) )
                    // InternalXtextTest.g:791:1: ( rule__MyTokens__StringAssignment_0_1 )
                    {
                     before(grammarAccess.getMyTokensAccess().getStringAssignment_0_1()); 
                    // InternalXtextTest.g:792:1: ( rule__MyTokens__StringAssignment_0_1 )
                    // InternalXtextTest.g:792:2: rule__MyTokens__StringAssignment_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__MyTokens__StringAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getMyTokensAccess().getStringAssignment_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyTokens__Alternatives_0"


    // $ANTLR start "rule__Inner__Alternatives_2"
    // InternalXtextTest.g:803:1: rule__Inner__Alternatives_2 : ( ( ( rule__Inner__Group_2_0__0 ) ) | ( ( rule__Inner__Group_2_1__0 ) ) | ( ( rule__Inner__Group_2_2__0 ) ) | ( ( rule__Inner__Group_2_3__0 ) ) | ( ( rule__Inner__Group_2_4__0 ) ) | ( ( rule__Inner__IsNullAssignment_2_5 ) ) | ( ( rule__Inner__IsNotNullAssignment_2_6 ) ) | ( ( rule__Inner__IsEmptyAssignment_2_7 ) ) );
    public final void rule__Inner__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:807:1: ( ( ( rule__Inner__Group_2_0__0 ) ) | ( ( rule__Inner__Group_2_1__0 ) ) | ( ( rule__Inner__Group_2_2__0 ) ) | ( ( rule__Inner__Group_2_3__0 ) ) | ( ( rule__Inner__Group_2_4__0 ) ) | ( ( rule__Inner__IsNullAssignment_2_5 ) ) | ( ( rule__Inner__IsNotNullAssignment_2_6 ) ) | ( ( rule__Inner__IsEmptyAssignment_2_7 ) ) )
            int alt5=8;
            switch ( input.LA(1) ) {
            case RULE_ASSIGNASSINGLE:
                {
                alt5=1;
                }
                break;
            case RULE_ASSIGNASLIST:
                {
                alt5=2;
                }
                break;
            case RULE_ASSIGNASSTRING:
                {
                alt5=3;
                }
                break;
            case RULE_ASSIGNASDATALIST:
                {
                alt5=4;
                }
                break;
            case RULE_ASSIGNASBOOL:
                {
                alt5=5;
                }
                break;
            case RULE_ISNULL:
                {
                alt5=6;
                }
                break;
            case RULE_ISNOTNULL:
                {
                alt5=7;
                }
                break;
            case RULE_ISEMPTY:
                {
                alt5=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalXtextTest.g:809:1: ( ( rule__Inner__Group_2_0__0 ) )
                    {
                    // InternalXtextTest.g:809:1: ( ( rule__Inner__Group_2_0__0 ) )
                    // InternalXtextTest.g:810:1: ( rule__Inner__Group_2_0__0 )
                    {
                     before(grammarAccess.getInnerAccess().getGroup_2_0()); 
                    // InternalXtextTest.g:811:1: ( rule__Inner__Group_2_0__0 )
                    // InternalXtextTest.g:811:2: rule__Inner__Group_2_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Inner__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInnerAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:818:1: ( ( rule__Inner__Group_2_1__0 ) )
                    {
                    // InternalXtextTest.g:818:1: ( ( rule__Inner__Group_2_1__0 ) )
                    // InternalXtextTest.g:819:1: ( rule__Inner__Group_2_1__0 )
                    {
                     before(grammarAccess.getInnerAccess().getGroup_2_1()); 
                    // InternalXtextTest.g:820:1: ( rule__Inner__Group_2_1__0 )
                    // InternalXtextTest.g:820:2: rule__Inner__Group_2_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Inner__Group_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInnerAccess().getGroup_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextTest.g:827:1: ( ( rule__Inner__Group_2_2__0 ) )
                    {
                    // InternalXtextTest.g:827:1: ( ( rule__Inner__Group_2_2__0 ) )
                    // InternalXtextTest.g:828:1: ( rule__Inner__Group_2_2__0 )
                    {
                     before(grammarAccess.getInnerAccess().getGroup_2_2()); 
                    // InternalXtextTest.g:829:1: ( rule__Inner__Group_2_2__0 )
                    // InternalXtextTest.g:829:2: rule__Inner__Group_2_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Inner__Group_2_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInnerAccess().getGroup_2_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXtextTest.g:836:1: ( ( rule__Inner__Group_2_3__0 ) )
                    {
                    // InternalXtextTest.g:836:1: ( ( rule__Inner__Group_2_3__0 ) )
                    // InternalXtextTest.g:837:1: ( rule__Inner__Group_2_3__0 )
                    {
                     before(grammarAccess.getInnerAccess().getGroup_2_3()); 
                    // InternalXtextTest.g:838:1: ( rule__Inner__Group_2_3__0 )
                    // InternalXtextTest.g:838:2: rule__Inner__Group_2_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Inner__Group_2_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInnerAccess().getGroup_2_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXtextTest.g:845:1: ( ( rule__Inner__Group_2_4__0 ) )
                    {
                    // InternalXtextTest.g:845:1: ( ( rule__Inner__Group_2_4__0 ) )
                    // InternalXtextTest.g:846:1: ( rule__Inner__Group_2_4__0 )
                    {
                     before(grammarAccess.getInnerAccess().getGroup_2_4()); 
                    // InternalXtextTest.g:847:1: ( rule__Inner__Group_2_4__0 )
                    // InternalXtextTest.g:847:2: rule__Inner__Group_2_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Inner__Group_2_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInnerAccess().getGroup_2_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXtextTest.g:854:1: ( ( rule__Inner__IsNullAssignment_2_5 ) )
                    {
                    // InternalXtextTest.g:854:1: ( ( rule__Inner__IsNullAssignment_2_5 ) )
                    // InternalXtextTest.g:855:1: ( rule__Inner__IsNullAssignment_2_5 )
                    {
                     before(grammarAccess.getInnerAccess().getIsNullAssignment_2_5()); 
                    // InternalXtextTest.g:856:1: ( rule__Inner__IsNullAssignment_2_5 )
                    // InternalXtextTest.g:856:2: rule__Inner__IsNullAssignment_2_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__Inner__IsNullAssignment_2_5();

                    state._fsp--;


                    }

                     after(grammarAccess.getInnerAccess().getIsNullAssignment_2_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalXtextTest.g:863:1: ( ( rule__Inner__IsNotNullAssignment_2_6 ) )
                    {
                    // InternalXtextTest.g:863:1: ( ( rule__Inner__IsNotNullAssignment_2_6 ) )
                    // InternalXtextTest.g:864:1: ( rule__Inner__IsNotNullAssignment_2_6 )
                    {
                     before(grammarAccess.getInnerAccess().getIsNotNullAssignment_2_6()); 
                    // InternalXtextTest.g:865:1: ( rule__Inner__IsNotNullAssignment_2_6 )
                    // InternalXtextTest.g:865:2: rule__Inner__IsNotNullAssignment_2_6
                    {
                    pushFollow(FOLLOW_2);
                    rule__Inner__IsNotNullAssignment_2_6();

                    state._fsp--;


                    }

                     after(grammarAccess.getInnerAccess().getIsNotNullAssignment_2_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalXtextTest.g:872:1: ( ( rule__Inner__IsEmptyAssignment_2_7 ) )
                    {
                    // InternalXtextTest.g:872:1: ( ( rule__Inner__IsEmptyAssignment_2_7 ) )
                    // InternalXtextTest.g:873:1: ( rule__Inner__IsEmptyAssignment_2_7 )
                    {
                     before(grammarAccess.getInnerAccess().getIsEmptyAssignment_2_7()); 
                    // InternalXtextTest.g:874:1: ( rule__Inner__IsEmptyAssignment_2_7 )
                    // InternalXtextTest.g:874:2: rule__Inner__IsEmptyAssignment_2_7
                    {
                    pushFollow(FOLLOW_2);
                    rule__Inner__IsEmptyAssignment_2_7();

                    state._fsp--;


                    }

                     after(grammarAccess.getInnerAccess().getIsEmptyAssignment_2_7()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Alternatives_2"


    // $ANTLR start "rule__Inner__AssignAsBoolAlternatives_2_4_1_0"
    // InternalXtextTest.g:885:1: rule__Inner__AssignAsBoolAlternatives_2_4_1_0 : ( ( RULE_TRUE ) | ( RULE_FALSE ) );
    public final void rule__Inner__AssignAsBoolAlternatives_2_4_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:889:1: ( ( RULE_TRUE ) | ( RULE_FALSE ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_TRUE) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_FALSE) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalXtextTest.g:891:1: ( RULE_TRUE )
                    {
                    // InternalXtextTest.g:891:1: ( RULE_TRUE )
                    // InternalXtextTest.g:892:1: RULE_TRUE
                    {
                     before(grammarAccess.getInnerAccess().getAssignAsBoolTRUETerminalRuleCall_2_4_1_0_0()); 
                    match(input,RULE_TRUE,FOLLOW_2); 
                     after(grammarAccess.getInnerAccess().getAssignAsBoolTRUETerminalRuleCall_2_4_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:900:1: ( RULE_FALSE )
                    {
                    // InternalXtextTest.g:900:1: ( RULE_FALSE )
                    // InternalXtextTest.g:901:1: RULE_FALSE
                    {
                     before(grammarAccess.getInnerAccess().getAssignAsBoolFALSETerminalRuleCall_2_4_1_0_1()); 
                    match(input,RULE_FALSE,FOLLOW_2); 
                     after(grammarAccess.getInnerAccess().getAssignAsBoolFALSETerminalRuleCall_2_4_1_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__AssignAsBoolAlternatives_2_4_1_0"


    // $ANTLR start "rule__Generator__Alternatives_2_2"
    // InternalXtextTest.g:913:1: rule__Generator__Alternatives_2_2 : ( ( ( rule__Generator__Group_2_2_0__0 ) ) | ( ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 ) ) );
    public final void rule__Generator__Alternatives_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:917:1: ( ( ( rule__Generator__Group_2_2_0__0 ) ) | ( ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ASSIGNASSINGLE) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ISSAMEASINPUTFILE) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalXtextTest.g:919:1: ( ( rule__Generator__Group_2_2_0__0 ) )
                    {
                    // InternalXtextTest.g:919:1: ( ( rule__Generator__Group_2_2_0__0 ) )
                    // InternalXtextTest.g:920:1: ( rule__Generator__Group_2_2_0__0 )
                    {
                     before(grammarAccess.getGeneratorAccess().getGroup_2_2_0()); 
                    // InternalXtextTest.g:921:1: ( rule__Generator__Group_2_2_0__0 )
                    // InternalXtextTest.g:921:2: rule__Generator__Group_2_2_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Generator__Group_2_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getGeneratorAccess().getGroup_2_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:928:1: ( ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 ) )
                    {
                    // InternalXtextTest.g:928:1: ( ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 ) )
                    // InternalXtextTest.g:929:1: ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 )
                    {
                     before(grammarAccess.getGeneratorAccess().getIsSameAsInputFileAssignment_2_2_1()); 
                    // InternalXtextTest.g:930:1: ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 )
                    // InternalXtextTest.g:930:2: rule__Generator__IsSameAsInputFileAssignment_2_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Generator__IsSameAsInputFileAssignment_2_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getGeneratorAccess().getIsSameAsInputFileAssignment_2_2_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Alternatives_2_2"


    // $ANTLR start "rule__Model__Group__0"
    // InternalXtextTest.g:943:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:947:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalXtextTest.g:948:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // InternalXtextTest.g:955:1: rule__Model__Group__0__Impl : ( () ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:959:1: ( ( () ) )
            // InternalXtextTest.g:961:1: ( () )
            {
            // InternalXtextTest.g:961:1: ( () )
            // InternalXtextTest.g:962:1: ()
            {
             before(grammarAccess.getModelAccess().getModelAction_0()); 
            // InternalXtextTest.g:963:1: ()
            // InternalXtextTest.g:965:1: 
            {
            }

             after(grammarAccess.getModelAccess().getModelAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // InternalXtextTest.g:977:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:981:1: ( rule__Model__Group__1__Impl )
            // InternalXtextTest.g:982:2: rule__Model__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // InternalXtextTest.g:988:1: rule__Model__Group__1__Impl : ( ( rule__Model__Alternatives_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:992:1: ( ( ( rule__Model__Alternatives_1 ) ) )
            // InternalXtextTest.g:994:1: ( ( rule__Model__Alternatives_1 ) )
            {
            // InternalXtextTest.g:994:1: ( ( rule__Model__Alternatives_1 ) )
            // InternalXtextTest.g:995:1: ( rule__Model__Alternatives_1 )
            {
             before(grammarAccess.getModelAccess().getAlternatives_1()); 
            // InternalXtextTest.g:996:1: ( rule__Model__Alternatives_1 )
            // InternalXtextTest.g:996:2: rule__Model__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__Model__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__XtextTest__Group__0"
    // InternalXtextTest.g:1012:1: rule__XtextTest__Group__0 : rule__XtextTest__Group__0__Impl rule__XtextTest__Group__1 ;
    public final void rule__XtextTest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1016:1: ( rule__XtextTest__Group__0__Impl rule__XtextTest__Group__1 )
            // InternalXtextTest.g:1017:2: rule__XtextTest__Group__0__Impl rule__XtextTest__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__XtextTest__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__0"


    // $ANTLR start "rule__XtextTest__Group__0__Impl"
    // InternalXtextTest.g:1024:1: rule__XtextTest__Group__0__Impl : ( () ) ;
    public final void rule__XtextTest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1028:1: ( ( () ) )
            // InternalXtextTest.g:1030:1: ( () )
            {
            // InternalXtextTest.g:1030:1: ( () )
            // InternalXtextTest.g:1031:1: ()
            {
             before(grammarAccess.getXtextTestAccess().getXtextTestAction_0()); 
            // InternalXtextTest.g:1032:1: ()
            // InternalXtextTest.g:1034:1: 
            {
            }

             after(grammarAccess.getXtextTestAccess().getXtextTestAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__0__Impl"


    // $ANTLR start "rule__XtextTest__Group__1"
    // InternalXtextTest.g:1046:1: rule__XtextTest__Group__1 : rule__XtextTest__Group__1__Impl rule__XtextTest__Group__2 ;
    public final void rule__XtextTest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1050:1: ( rule__XtextTest__Group__1__Impl rule__XtextTest__Group__2 )
            // InternalXtextTest.g:1051:2: rule__XtextTest__Group__1__Impl rule__XtextTest__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__XtextTest__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__1"


    // $ANTLR start "rule__XtextTest__Group__1__Impl"
    // InternalXtextTest.g:1058:1: rule__XtextTest__Group__1__Impl : ( RULE_PACKAGE ) ;
    public final void rule__XtextTest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1062:1: ( ( RULE_PACKAGE ) )
            // InternalXtextTest.g:1064:1: ( RULE_PACKAGE )
            {
            // InternalXtextTest.g:1064:1: ( RULE_PACKAGE )
            // InternalXtextTest.g:1065:1: RULE_PACKAGE
            {
             before(grammarAccess.getXtextTestAccess().getPACKAGETerminalRuleCall_1()); 
            match(input,RULE_PACKAGE,FOLLOW_2); 
             after(grammarAccess.getXtextTestAccess().getPACKAGETerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__1__Impl"


    // $ANTLR start "rule__XtextTest__Group__2"
    // InternalXtextTest.g:1078:1: rule__XtextTest__Group__2 : rule__XtextTest__Group__2__Impl rule__XtextTest__Group__3 ;
    public final void rule__XtextTest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1082:1: ( rule__XtextTest__Group__2__Impl rule__XtextTest__Group__3 )
            // InternalXtextTest.g:1083:2: rule__XtextTest__Group__2__Impl rule__XtextTest__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__XtextTest__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__2"


    // $ANTLR start "rule__XtextTest__Group__2__Impl"
    // InternalXtextTest.g:1090:1: rule__XtextTest__Group__2__Impl : ( ( rule__XtextTest__PackageAssignment_2 ) ) ;
    public final void rule__XtextTest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1094:1: ( ( ( rule__XtextTest__PackageAssignment_2 ) ) )
            // InternalXtextTest.g:1096:1: ( ( rule__XtextTest__PackageAssignment_2 ) )
            {
            // InternalXtextTest.g:1096:1: ( ( rule__XtextTest__PackageAssignment_2 ) )
            // InternalXtextTest.g:1097:1: ( rule__XtextTest__PackageAssignment_2 )
            {
             before(grammarAccess.getXtextTestAccess().getPackageAssignment_2()); 
            // InternalXtextTest.g:1098:1: ( rule__XtextTest__PackageAssignment_2 )
            // InternalXtextTest.g:1098:2: rule__XtextTest__PackageAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__PackageAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getXtextTestAccess().getPackageAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__2__Impl"


    // $ANTLR start "rule__XtextTest__Group__3"
    // InternalXtextTest.g:1110:1: rule__XtextTest__Group__3 : rule__XtextTest__Group__3__Impl rule__XtextTest__Group__4 ;
    public final void rule__XtextTest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1114:1: ( rule__XtextTest__Group__3__Impl rule__XtextTest__Group__4 )
            // InternalXtextTest.g:1115:2: rule__XtextTest__Group__3__Impl rule__XtextTest__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__XtextTest__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__3"


    // $ANTLR start "rule__XtextTest__Group__3__Impl"
    // InternalXtextTest.g:1122:1: rule__XtextTest__Group__3__Impl : ( RULE_LANGUAGE ) ;
    public final void rule__XtextTest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1126:1: ( ( RULE_LANGUAGE ) )
            // InternalXtextTest.g:1128:1: ( RULE_LANGUAGE )
            {
            // InternalXtextTest.g:1128:1: ( RULE_LANGUAGE )
            // InternalXtextTest.g:1129:1: RULE_LANGUAGE
            {
             before(grammarAccess.getXtextTestAccess().getLANGUAGETerminalRuleCall_3()); 
            match(input,RULE_LANGUAGE,FOLLOW_2); 
             after(grammarAccess.getXtextTestAccess().getLANGUAGETerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__3__Impl"


    // $ANTLR start "rule__XtextTest__Group__4"
    // InternalXtextTest.g:1142:1: rule__XtextTest__Group__4 : rule__XtextTest__Group__4__Impl rule__XtextTest__Group__5 ;
    public final void rule__XtextTest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1146:1: ( rule__XtextTest__Group__4__Impl rule__XtextTest__Group__5 )
            // InternalXtextTest.g:1147:2: rule__XtextTest__Group__4__Impl rule__XtextTest__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__XtextTest__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__4"


    // $ANTLR start "rule__XtextTest__Group__4__Impl"
    // InternalXtextTest.g:1154:1: rule__XtextTest__Group__4__Impl : ( ( rule__XtextTest__LangAssignment_4 ) ) ;
    public final void rule__XtextTest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1158:1: ( ( ( rule__XtextTest__LangAssignment_4 ) ) )
            // InternalXtextTest.g:1160:1: ( ( rule__XtextTest__LangAssignment_4 ) )
            {
            // InternalXtextTest.g:1160:1: ( ( rule__XtextTest__LangAssignment_4 ) )
            // InternalXtextTest.g:1161:1: ( rule__XtextTest__LangAssignment_4 )
            {
             before(grammarAccess.getXtextTestAccess().getLangAssignment_4()); 
            // InternalXtextTest.g:1162:1: ( rule__XtextTest__LangAssignment_4 )
            // InternalXtextTest.g:1162:2: rule__XtextTest__LangAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__LangAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getXtextTestAccess().getLangAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__4__Impl"


    // $ANTLR start "rule__XtextTest__Group__5"
    // InternalXtextTest.g:1174:1: rule__XtextTest__Group__5 : rule__XtextTest__Group__5__Impl rule__XtextTest__Group__6 ;
    public final void rule__XtextTest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1178:1: ( rule__XtextTest__Group__5__Impl rule__XtextTest__Group__6 )
            // InternalXtextTest.g:1179:2: rule__XtextTest__Group__5__Impl rule__XtextTest__Group__6
            {
            pushFollow(FOLLOW_7);
            rule__XtextTest__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__5"


    // $ANTLR start "rule__XtextTest__Group__5__Impl"
    // InternalXtextTest.g:1186:1: rule__XtextTest__Group__5__Impl : ( ( rule__XtextTest__Group_5__0 )? ) ;
    public final void rule__XtextTest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1190:1: ( ( ( rule__XtextTest__Group_5__0 )? ) )
            // InternalXtextTest.g:1192:1: ( ( rule__XtextTest__Group_5__0 )? )
            {
            // InternalXtextTest.g:1192:1: ( ( rule__XtextTest__Group_5__0 )? )
            // InternalXtextTest.g:1193:1: ( rule__XtextTest__Group_5__0 )?
            {
             before(grammarAccess.getXtextTestAccess().getGroup_5()); 
            // InternalXtextTest.g:1194:1: ( rule__XtextTest__Group_5__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_IMPORTS) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalXtextTest.g:1194:2: rule__XtextTest__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XtextTest__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXtextTestAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__5__Impl"


    // $ANTLR start "rule__XtextTest__Group__6"
    // InternalXtextTest.g:1206:1: rule__XtextTest__Group__6 : rule__XtextTest__Group__6__Impl rule__XtextTest__Group__7 ;
    public final void rule__XtextTest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1210:1: ( rule__XtextTest__Group__6__Impl rule__XtextTest__Group__7 )
            // InternalXtextTest.g:1211:2: rule__XtextTest__Group__6__Impl rule__XtextTest__Group__7
            {
            pushFollow(FOLLOW_7);
            rule__XtextTest__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__6"


    // $ANTLR start "rule__XtextTest__Group__6__Impl"
    // InternalXtextTest.g:1218:1: rule__XtextTest__Group__6__Impl : ( ( rule__XtextTest__Group_6__0 )? ) ;
    public final void rule__XtextTest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1222:1: ( ( ( rule__XtextTest__Group_6__0 )? ) )
            // InternalXtextTest.g:1224:1: ( ( rule__XtextTest__Group_6__0 )? )
            {
            // InternalXtextTest.g:1224:1: ( ( rule__XtextTest__Group_6__0 )? )
            // InternalXtextTest.g:1225:1: ( rule__XtextTest__Group_6__0 )?
            {
             before(grammarAccess.getXtextTestAccess().getGroup_6()); 
            // InternalXtextTest.g:1226:1: ( rule__XtextTest__Group_6__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_SPLITLEXER) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalXtextTest.g:1226:2: rule__XtextTest__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XtextTest__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXtextTestAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__6__Impl"


    // $ANTLR start "rule__XtextTest__Group__7"
    // InternalXtextTest.g:1238:1: rule__XtextTest__Group__7 : rule__XtextTest__Group__7__Impl rule__XtextTest__Group__8 ;
    public final void rule__XtextTest__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1242:1: ( rule__XtextTest__Group__7__Impl rule__XtextTest__Group__8 )
            // InternalXtextTest.g:1243:2: rule__XtextTest__Group__7__Impl rule__XtextTest__Group__8
            {
            pushFollow(FOLLOW_8);
            rule__XtextTest__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__7"


    // $ANTLR start "rule__XtextTest__Group__7__Impl"
    // InternalXtextTest.g:1250:1: rule__XtextTest__Group__7__Impl : ( ( rule__XtextTest__InputAssignment_7 ) ) ;
    public final void rule__XtextTest__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1254:1: ( ( ( rule__XtextTest__InputAssignment_7 ) ) )
            // InternalXtextTest.g:1256:1: ( ( rule__XtextTest__InputAssignment_7 ) )
            {
            // InternalXtextTest.g:1256:1: ( ( rule__XtextTest__InputAssignment_7 ) )
            // InternalXtextTest.g:1257:1: ( rule__XtextTest__InputAssignment_7 )
            {
             before(grammarAccess.getXtextTestAccess().getInputAssignment_7()); 
            // InternalXtextTest.g:1258:1: ( rule__XtextTest__InputAssignment_7 )
            // InternalXtextTest.g:1258:2: rule__XtextTest__InputAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__InputAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getXtextTestAccess().getInputAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__7__Impl"


    // $ANTLR start "rule__XtextTest__Group__8"
    // InternalXtextTest.g:1270:1: rule__XtextTest__Group__8 : rule__XtextTest__Group__8__Impl rule__XtextTest__Group__9 ;
    public final void rule__XtextTest__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1274:1: ( rule__XtextTest__Group__8__Impl rule__XtextTest__Group__9 )
            // InternalXtextTest.g:1275:2: rule__XtextTest__Group__8__Impl rule__XtextTest__Group__9
            {
            pushFollow(FOLLOW_8);
            rule__XtextTest__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__8"


    // $ANTLR start "rule__XtextTest__Group__8__Impl"
    // InternalXtextTest.g:1282:1: rule__XtextTest__Group__8__Impl : ( ( rule__XtextTest__Group_8__0 )? ) ;
    public final void rule__XtextTest__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1286:1: ( ( ( rule__XtextTest__Group_8__0 )? ) )
            // InternalXtextTest.g:1288:1: ( ( rule__XtextTest__Group_8__0 )? )
            {
            // InternalXtextTest.g:1288:1: ( ( rule__XtextTest__Group_8__0 )? )
            // InternalXtextTest.g:1289:1: ( rule__XtextTest__Group_8__0 )?
            {
             before(grammarAccess.getXtextTestAccess().getGroup_8()); 
            // InternalXtextTest.g:1290:1: ( rule__XtextTest__Group_8__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_TIMEOUT) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalXtextTest.g:1290:2: rule__XtextTest__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XtextTest__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXtextTestAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__8__Impl"


    // $ANTLR start "rule__XtextTest__Group__9"
    // InternalXtextTest.g:1302:1: rule__XtextTest__Group__9 : rule__XtextTest__Group__9__Impl rule__XtextTest__Group__10 ;
    public final void rule__XtextTest__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1306:1: ( rule__XtextTest__Group__9__Impl rule__XtextTest__Group__10 )
            // InternalXtextTest.g:1307:2: rule__XtextTest__Group__9__Impl rule__XtextTest__Group__10
            {
            pushFollow(FOLLOW_8);
            rule__XtextTest__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__9"


    // $ANTLR start "rule__XtextTest__Group__9__Impl"
    // InternalXtextTest.g:1314:1: rule__XtextTest__Group__9__Impl : ( ( rule__XtextTest__TokensAssignment_9 )? ) ;
    public final void rule__XtextTest__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1318:1: ( ( ( rule__XtextTest__TokensAssignment_9 )? ) )
            // InternalXtextTest.g:1320:1: ( ( rule__XtextTest__TokensAssignment_9 )? )
            {
            // InternalXtextTest.g:1320:1: ( ( rule__XtextTest__TokensAssignment_9 )? )
            // InternalXtextTest.g:1321:1: ( rule__XtextTest__TokensAssignment_9 )?
            {
             before(grammarAccess.getXtextTestAccess().getTokensAssignment_9()); 
            // InternalXtextTest.g:1322:1: ( rule__XtextTest__TokensAssignment_9 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_LEXER) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalXtextTest.g:1322:2: rule__XtextTest__TokensAssignment_9
                    {
                    pushFollow(FOLLOW_2);
                    rule__XtextTest__TokensAssignment_9();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXtextTestAccess().getTokensAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__9__Impl"


    // $ANTLR start "rule__XtextTest__Group__10"
    // InternalXtextTest.g:1334:1: rule__XtextTest__Group__10 : rule__XtextTest__Group__10__Impl rule__XtextTest__Group__11 ;
    public final void rule__XtextTest__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1338:1: ( rule__XtextTest__Group__10__Impl rule__XtextTest__Group__11 )
            // InternalXtextTest.g:1339:2: rule__XtextTest__Group__10__Impl rule__XtextTest__Group__11
            {
            pushFollow(FOLLOW_9);
            rule__XtextTest__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__10"


    // $ANTLR start "rule__XtextTest__Group__10__Impl"
    // InternalXtextTest.g:1346:1: rule__XtextTest__Group__10__Impl : ( ( rule__XtextTest__RootAssignment_10 ) ) ;
    public final void rule__XtextTest__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1350:1: ( ( ( rule__XtextTest__RootAssignment_10 ) ) )
            // InternalXtextTest.g:1352:1: ( ( rule__XtextTest__RootAssignment_10 ) )
            {
            // InternalXtextTest.g:1352:1: ( ( rule__XtextTest__RootAssignment_10 ) )
            // InternalXtextTest.g:1353:1: ( rule__XtextTest__RootAssignment_10 )
            {
             before(grammarAccess.getXtextTestAccess().getRootAssignment_10()); 
            // InternalXtextTest.g:1354:1: ( rule__XtextTest__RootAssignment_10 )
            // InternalXtextTest.g:1354:2: rule__XtextTest__RootAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__RootAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getXtextTestAccess().getRootAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__10__Impl"


    // $ANTLR start "rule__XtextTest__Group__11"
    // InternalXtextTest.g:1366:1: rule__XtextTest__Group__11 : rule__XtextTest__Group__11__Impl rule__XtextTest__Group__12 ;
    public final void rule__XtextTest__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1370:1: ( rule__XtextTest__Group__11__Impl rule__XtextTest__Group__12 )
            // InternalXtextTest.g:1371:2: rule__XtextTest__Group__11__Impl rule__XtextTest__Group__12
            {
            pushFollow(FOLLOW_9);
            rule__XtextTest__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__11"


    // $ANTLR start "rule__XtextTest__Group__11__Impl"
    // InternalXtextTest.g:1378:1: rule__XtextTest__Group__11__Impl : ( ( rule__XtextTest__OutputAssignment_11 )? ) ;
    public final void rule__XtextTest__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1382:1: ( ( ( rule__XtextTest__OutputAssignment_11 )? ) )
            // InternalXtextTest.g:1384:1: ( ( rule__XtextTest__OutputAssignment_11 )? )
            {
            // InternalXtextTest.g:1384:1: ( ( rule__XtextTest__OutputAssignment_11 )? )
            // InternalXtextTest.g:1385:1: ( rule__XtextTest__OutputAssignment_11 )?
            {
             before(grammarAccess.getXtextTestAccess().getOutputAssignment_11()); 
            // InternalXtextTest.g:1386:1: ( rule__XtextTest__OutputAssignment_11 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_OUTPUT) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalXtextTest.g:1386:2: rule__XtextTest__OutputAssignment_11
                    {
                    pushFollow(FOLLOW_2);
                    rule__XtextTest__OutputAssignment_11();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXtextTestAccess().getOutputAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__11__Impl"


    // $ANTLR start "rule__XtextTest__Group__12"
    // InternalXtextTest.g:1398:1: rule__XtextTest__Group__12 : rule__XtextTest__Group__12__Impl rule__XtextTest__Group__13 ;
    public final void rule__XtextTest__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1402:1: ( rule__XtextTest__Group__12__Impl rule__XtextTest__Group__13 )
            // InternalXtextTest.g:1403:2: rule__XtextTest__Group__12__Impl rule__XtextTest__Group__13
            {
            pushFollow(FOLLOW_9);
            rule__XtextTest__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__12"


    // $ANTLR start "rule__XtextTest__Group__12__Impl"
    // InternalXtextTest.g:1410:1: rule__XtextTest__Group__12__Impl : ( ( rule__XtextTest__BeforeAssignment_12 )? ) ;
    public final void rule__XtextTest__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1414:1: ( ( ( rule__XtextTest__BeforeAssignment_12 )? ) )
            // InternalXtextTest.g:1416:1: ( ( rule__XtextTest__BeforeAssignment_12 )? )
            {
            // InternalXtextTest.g:1416:1: ( ( rule__XtextTest__BeforeAssignment_12 )? )
            // InternalXtextTest.g:1417:1: ( rule__XtextTest__BeforeAssignment_12 )?
            {
             before(grammarAccess.getXtextTestAccess().getBeforeAssignment_12()); 
            // InternalXtextTest.g:1418:1: ( rule__XtextTest__BeforeAssignment_12 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_BEFORE_KW) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalXtextTest.g:1418:2: rule__XtextTest__BeforeAssignment_12
                    {
                    pushFollow(FOLLOW_2);
                    rule__XtextTest__BeforeAssignment_12();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXtextTestAccess().getBeforeAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__12__Impl"


    // $ANTLR start "rule__XtextTest__Group__13"
    // InternalXtextTest.g:1430:1: rule__XtextTest__Group__13 : rule__XtextTest__Group__13__Impl ;
    public final void rule__XtextTest__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1434:1: ( rule__XtextTest__Group__13__Impl )
            // InternalXtextTest.g:1435:2: rule__XtextTest__Group__13__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__13__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__13"


    // $ANTLR start "rule__XtextTest__Group__13__Impl"
    // InternalXtextTest.g:1441:1: rule__XtextTest__Group__13__Impl : ( ( rule__XtextTest__AfterAssignment_13 )? ) ;
    public final void rule__XtextTest__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1445:1: ( ( ( rule__XtextTest__AfterAssignment_13 )? ) )
            // InternalXtextTest.g:1447:1: ( ( rule__XtextTest__AfterAssignment_13 )? )
            {
            // InternalXtextTest.g:1447:1: ( ( rule__XtextTest__AfterAssignment_13 )? )
            // InternalXtextTest.g:1448:1: ( rule__XtextTest__AfterAssignment_13 )?
            {
             before(grammarAccess.getXtextTestAccess().getAfterAssignment_13()); 
            // InternalXtextTest.g:1449:1: ( rule__XtextTest__AfterAssignment_13 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_AFTER_KW) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalXtextTest.g:1449:2: rule__XtextTest__AfterAssignment_13
                    {
                    pushFollow(FOLLOW_2);
                    rule__XtextTest__AfterAssignment_13();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXtextTestAccess().getAfterAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group__13__Impl"


    // $ANTLR start "rule__XtextTest__Group_5__0"
    // InternalXtextTest.g:1489:1: rule__XtextTest__Group_5__0 : rule__XtextTest__Group_5__0__Impl rule__XtextTest__Group_5__1 ;
    public final void rule__XtextTest__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1493:1: ( rule__XtextTest__Group_5__0__Impl rule__XtextTest__Group_5__1 )
            // InternalXtextTest.g:1494:2: rule__XtextTest__Group_5__0__Impl rule__XtextTest__Group_5__1
            {
            pushFollow(FOLLOW_5);
            rule__XtextTest__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_5__0"


    // $ANTLR start "rule__XtextTest__Group_5__0__Impl"
    // InternalXtextTest.g:1501:1: rule__XtextTest__Group_5__0__Impl : ( RULE_IMPORTS ) ;
    public final void rule__XtextTest__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1505:1: ( ( RULE_IMPORTS ) )
            // InternalXtextTest.g:1507:1: ( RULE_IMPORTS )
            {
            // InternalXtextTest.g:1507:1: ( RULE_IMPORTS )
            // InternalXtextTest.g:1508:1: RULE_IMPORTS
            {
             before(grammarAccess.getXtextTestAccess().getIMPORTSTerminalRuleCall_5_0()); 
            match(input,RULE_IMPORTS,FOLLOW_2); 
             after(grammarAccess.getXtextTestAccess().getIMPORTSTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_5__0__Impl"


    // $ANTLR start "rule__XtextTest__Group_5__1"
    // InternalXtextTest.g:1521:1: rule__XtextTest__Group_5__1 : rule__XtextTest__Group_5__1__Impl ;
    public final void rule__XtextTest__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1525:1: ( rule__XtextTest__Group_5__1__Impl )
            // InternalXtextTest.g:1526:2: rule__XtextTest__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_5__1"


    // $ANTLR start "rule__XtextTest__Group_5__1__Impl"
    // InternalXtextTest.g:1532:1: rule__XtextTest__Group_5__1__Impl : ( ( rule__XtextTest__ImportsAssignment_5_1 ) ) ;
    public final void rule__XtextTest__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1536:1: ( ( ( rule__XtextTest__ImportsAssignment_5_1 ) ) )
            // InternalXtextTest.g:1538:1: ( ( rule__XtextTest__ImportsAssignment_5_1 ) )
            {
            // InternalXtextTest.g:1538:1: ( ( rule__XtextTest__ImportsAssignment_5_1 ) )
            // InternalXtextTest.g:1539:1: ( rule__XtextTest__ImportsAssignment_5_1 )
            {
             before(grammarAccess.getXtextTestAccess().getImportsAssignment_5_1()); 
            // InternalXtextTest.g:1540:1: ( rule__XtextTest__ImportsAssignment_5_1 )
            // InternalXtextTest.g:1540:2: rule__XtextTest__ImportsAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__ImportsAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getXtextTestAccess().getImportsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_5__1__Impl"


    // $ANTLR start "rule__XtextTest__Group_6__0"
    // InternalXtextTest.g:1556:1: rule__XtextTest__Group_6__0 : rule__XtextTest__Group_6__0__Impl rule__XtextTest__Group_6__1 ;
    public final void rule__XtextTest__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1560:1: ( rule__XtextTest__Group_6__0__Impl rule__XtextTest__Group_6__1 )
            // InternalXtextTest.g:1561:2: rule__XtextTest__Group_6__0__Impl rule__XtextTest__Group_6__1
            {
            pushFollow(FOLLOW_10);
            rule__XtextTest__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_6__0"


    // $ANTLR start "rule__XtextTest__Group_6__0__Impl"
    // InternalXtextTest.g:1568:1: rule__XtextTest__Group_6__0__Impl : ( RULE_SPLITLEXER ) ;
    public final void rule__XtextTest__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1572:1: ( ( RULE_SPLITLEXER ) )
            // InternalXtextTest.g:1574:1: ( RULE_SPLITLEXER )
            {
            // InternalXtextTest.g:1574:1: ( RULE_SPLITLEXER )
            // InternalXtextTest.g:1575:1: RULE_SPLITLEXER
            {
             before(grammarAccess.getXtextTestAccess().getSPLITLEXERTerminalRuleCall_6_0()); 
            match(input,RULE_SPLITLEXER,FOLLOW_2); 
             after(grammarAccess.getXtextTestAccess().getSPLITLEXERTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_6__0__Impl"


    // $ANTLR start "rule__XtextTest__Group_6__1"
    // InternalXtextTest.g:1588:1: rule__XtextTest__Group_6__1 : rule__XtextTest__Group_6__1__Impl rule__XtextTest__Group_6__2 ;
    public final void rule__XtextTest__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1592:1: ( rule__XtextTest__Group_6__1__Impl rule__XtextTest__Group_6__2 )
            // InternalXtextTest.g:1593:2: rule__XtextTest__Group_6__1__Impl rule__XtextTest__Group_6__2
            {
            pushFollow(FOLLOW_11);
            rule__XtextTest__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_6__1"


    // $ANTLR start "rule__XtextTest__Group_6__1__Impl"
    // InternalXtextTest.g:1600:1: rule__XtextTest__Group_6__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__XtextTest__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1604:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:1606:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:1606:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:1607:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getXtextTestAccess().getASSIGNASSINGLETerminalRuleCall_6_1()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getXtextTestAccess().getASSIGNASSINGLETerminalRuleCall_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_6__1__Impl"


    // $ANTLR start "rule__XtextTest__Group_6__2"
    // InternalXtextTest.g:1620:1: rule__XtextTest__Group_6__2 : rule__XtextTest__Group_6__2__Impl ;
    public final void rule__XtextTest__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1624:1: ( rule__XtextTest__Group_6__2__Impl )
            // InternalXtextTest.g:1625:2: rule__XtextTest__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__Group_6__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_6__2"


    // $ANTLR start "rule__XtextTest__Group_6__2__Impl"
    // InternalXtextTest.g:1631:1: rule__XtextTest__Group_6__2__Impl : ( ( rule__XtextTest__BooleanAssignment_6_2 ) ) ;
    public final void rule__XtextTest__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1635:1: ( ( ( rule__XtextTest__BooleanAssignment_6_2 ) ) )
            // InternalXtextTest.g:1637:1: ( ( rule__XtextTest__BooleanAssignment_6_2 ) )
            {
            // InternalXtextTest.g:1637:1: ( ( rule__XtextTest__BooleanAssignment_6_2 ) )
            // InternalXtextTest.g:1638:1: ( rule__XtextTest__BooleanAssignment_6_2 )
            {
             before(grammarAccess.getXtextTestAccess().getBooleanAssignment_6_2()); 
            // InternalXtextTest.g:1639:1: ( rule__XtextTest__BooleanAssignment_6_2 )
            // InternalXtextTest.g:1639:2: rule__XtextTest__BooleanAssignment_6_2
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__BooleanAssignment_6_2();

            state._fsp--;


            }

             after(grammarAccess.getXtextTestAccess().getBooleanAssignment_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_6__2__Impl"


    // $ANTLR start "rule__XtextTest__Group_8__0"
    // InternalXtextTest.g:1657:1: rule__XtextTest__Group_8__0 : rule__XtextTest__Group_8__0__Impl rule__XtextTest__Group_8__1 ;
    public final void rule__XtextTest__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1661:1: ( rule__XtextTest__Group_8__0__Impl rule__XtextTest__Group_8__1 )
            // InternalXtextTest.g:1662:2: rule__XtextTest__Group_8__0__Impl rule__XtextTest__Group_8__1
            {
            pushFollow(FOLLOW_10);
            rule__XtextTest__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_8__0"


    // $ANTLR start "rule__XtextTest__Group_8__0__Impl"
    // InternalXtextTest.g:1669:1: rule__XtextTest__Group_8__0__Impl : ( RULE_TIMEOUT ) ;
    public final void rule__XtextTest__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1673:1: ( ( RULE_TIMEOUT ) )
            // InternalXtextTest.g:1675:1: ( RULE_TIMEOUT )
            {
            // InternalXtextTest.g:1675:1: ( RULE_TIMEOUT )
            // InternalXtextTest.g:1676:1: RULE_TIMEOUT
            {
             before(grammarAccess.getXtextTestAccess().getTIMEOUTTerminalRuleCall_8_0()); 
            match(input,RULE_TIMEOUT,FOLLOW_2); 
             after(grammarAccess.getXtextTestAccess().getTIMEOUTTerminalRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_8__0__Impl"


    // $ANTLR start "rule__XtextTest__Group_8__1"
    // InternalXtextTest.g:1689:1: rule__XtextTest__Group_8__1 : rule__XtextTest__Group_8__1__Impl rule__XtextTest__Group_8__2 ;
    public final void rule__XtextTest__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1693:1: ( rule__XtextTest__Group_8__1__Impl rule__XtextTest__Group_8__2 )
            // InternalXtextTest.g:1694:2: rule__XtextTest__Group_8__1__Impl rule__XtextTest__Group_8__2
            {
            pushFollow(FOLLOW_12);
            rule__XtextTest__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_8__1"


    // $ANTLR start "rule__XtextTest__Group_8__1__Impl"
    // InternalXtextTest.g:1701:1: rule__XtextTest__Group_8__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__XtextTest__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1705:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:1707:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:1707:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:1708:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getXtextTestAccess().getASSIGNASSINGLETerminalRuleCall_8_1()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getXtextTestAccess().getASSIGNASSINGLETerminalRuleCall_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_8__1__Impl"


    // $ANTLR start "rule__XtextTest__Group_8__2"
    // InternalXtextTest.g:1721:1: rule__XtextTest__Group_8__2 : rule__XtextTest__Group_8__2__Impl ;
    public final void rule__XtextTest__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1725:1: ( rule__XtextTest__Group_8__2__Impl )
            // InternalXtextTest.g:1726:2: rule__XtextTest__Group_8__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__Group_8__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_8__2"


    // $ANTLR start "rule__XtextTest__Group_8__2__Impl"
    // InternalXtextTest.g:1732:1: rule__XtextTest__Group_8__2__Impl : ( ( rule__XtextTest__TimeOutAssignment_8_2 ) ) ;
    public final void rule__XtextTest__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1736:1: ( ( ( rule__XtextTest__TimeOutAssignment_8_2 ) ) )
            // InternalXtextTest.g:1738:1: ( ( rule__XtextTest__TimeOutAssignment_8_2 ) )
            {
            // InternalXtextTest.g:1738:1: ( ( rule__XtextTest__TimeOutAssignment_8_2 ) )
            // InternalXtextTest.g:1739:1: ( rule__XtextTest__TimeOutAssignment_8_2 )
            {
             before(grammarAccess.getXtextTestAccess().getTimeOutAssignment_8_2()); 
            // InternalXtextTest.g:1740:1: ( rule__XtextTest__TimeOutAssignment_8_2 )
            // InternalXtextTest.g:1740:2: rule__XtextTest__TimeOutAssignment_8_2
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__TimeOutAssignment_8_2();

            state._fsp--;


            }

             after(grammarAccess.getXtextTestAccess().getTimeOutAssignment_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_8__2__Impl"


    // $ANTLR start "rule__EmfTest__Group__0"
    // InternalXtextTest.g:1758:1: rule__EmfTest__Group__0 : rule__EmfTest__Group__0__Impl rule__EmfTest__Group__1 ;
    public final void rule__EmfTest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1762:1: ( rule__EmfTest__Group__0__Impl rule__EmfTest__Group__1 )
            // InternalXtextTest.g:1763:2: rule__EmfTest__Group__0__Impl rule__EmfTest__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__EmfTest__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__0"


    // $ANTLR start "rule__EmfTest__Group__0__Impl"
    // InternalXtextTest.g:1770:1: rule__EmfTest__Group__0__Impl : ( () ) ;
    public final void rule__EmfTest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1774:1: ( ( () ) )
            // InternalXtextTest.g:1776:1: ( () )
            {
            // InternalXtextTest.g:1776:1: ( () )
            // InternalXtextTest.g:1777:1: ()
            {
             before(grammarAccess.getEmfTestAccess().getEmfTestAction_0()); 
            // InternalXtextTest.g:1778:1: ()
            // InternalXtextTest.g:1780:1: 
            {
            }

             after(grammarAccess.getEmfTestAccess().getEmfTestAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__0__Impl"


    // $ANTLR start "rule__EmfTest__Group__1"
    // InternalXtextTest.g:1792:1: rule__EmfTest__Group__1 : rule__EmfTest__Group__1__Impl rule__EmfTest__Group__2 ;
    public final void rule__EmfTest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1796:1: ( rule__EmfTest__Group__1__Impl rule__EmfTest__Group__2 )
            // InternalXtextTest.g:1797:2: rule__EmfTest__Group__1__Impl rule__EmfTest__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__EmfTest__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__1"


    // $ANTLR start "rule__EmfTest__Group__1__Impl"
    // InternalXtextTest.g:1804:1: rule__EmfTest__Group__1__Impl : ( RULE_KW_EMFTEST ) ;
    public final void rule__EmfTest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1808:1: ( ( RULE_KW_EMFTEST ) )
            // InternalXtextTest.g:1810:1: ( RULE_KW_EMFTEST )
            {
            // InternalXtextTest.g:1810:1: ( RULE_KW_EMFTEST )
            // InternalXtextTest.g:1811:1: RULE_KW_EMFTEST
            {
             before(grammarAccess.getEmfTestAccess().getKW_EMFTESTTerminalRuleCall_1()); 
            match(input,RULE_KW_EMFTEST,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getKW_EMFTESTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__1__Impl"


    // $ANTLR start "rule__EmfTest__Group__2"
    // InternalXtextTest.g:1824:1: rule__EmfTest__Group__2 : rule__EmfTest__Group__2__Impl rule__EmfTest__Group__3 ;
    public final void rule__EmfTest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1828:1: ( rule__EmfTest__Group__2__Impl rule__EmfTest__Group__3 )
            // InternalXtextTest.g:1829:2: rule__EmfTest__Group__2__Impl rule__EmfTest__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__EmfTest__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__2"


    // $ANTLR start "rule__EmfTest__Group__2__Impl"
    // InternalXtextTest.g:1836:1: rule__EmfTest__Group__2__Impl : ( RULE_PACKAGE ) ;
    public final void rule__EmfTest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1840:1: ( ( RULE_PACKAGE ) )
            // InternalXtextTest.g:1842:1: ( RULE_PACKAGE )
            {
            // InternalXtextTest.g:1842:1: ( RULE_PACKAGE )
            // InternalXtextTest.g:1843:1: RULE_PACKAGE
            {
             before(grammarAccess.getEmfTestAccess().getPACKAGETerminalRuleCall_2()); 
            match(input,RULE_PACKAGE,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getPACKAGETerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__2__Impl"


    // $ANTLR start "rule__EmfTest__Group__3"
    // InternalXtextTest.g:1856:1: rule__EmfTest__Group__3 : rule__EmfTest__Group__3__Impl rule__EmfTest__Group__4 ;
    public final void rule__EmfTest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1860:1: ( rule__EmfTest__Group__3__Impl rule__EmfTest__Group__4 )
            // InternalXtextTest.g:1861:2: rule__EmfTest__Group__3__Impl rule__EmfTest__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__EmfTest__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__3"


    // $ANTLR start "rule__EmfTest__Group__3__Impl"
    // InternalXtextTest.g:1868:1: rule__EmfTest__Group__3__Impl : ( ( rule__EmfTest__PackageAssignment_3 ) ) ;
    public final void rule__EmfTest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1872:1: ( ( ( rule__EmfTest__PackageAssignment_3 ) ) )
            // InternalXtextTest.g:1874:1: ( ( rule__EmfTest__PackageAssignment_3 ) )
            {
            // InternalXtextTest.g:1874:1: ( ( rule__EmfTest__PackageAssignment_3 ) )
            // InternalXtextTest.g:1875:1: ( rule__EmfTest__PackageAssignment_3 )
            {
             before(grammarAccess.getEmfTestAccess().getPackageAssignment_3()); 
            // InternalXtextTest.g:1876:1: ( rule__EmfTest__PackageAssignment_3 )
            // InternalXtextTest.g:1876:2: rule__EmfTest__PackageAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__PackageAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEmfTestAccess().getPackageAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__3__Impl"


    // $ANTLR start "rule__EmfTest__Group__4"
    // InternalXtextTest.g:1888:1: rule__EmfTest__Group__4 : rule__EmfTest__Group__4__Impl rule__EmfTest__Group__5 ;
    public final void rule__EmfTest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1892:1: ( rule__EmfTest__Group__4__Impl rule__EmfTest__Group__5 )
            // InternalXtextTest.g:1893:2: rule__EmfTest__Group__4__Impl rule__EmfTest__Group__5
            {
            pushFollow(FOLLOW_5);
            rule__EmfTest__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__4"


    // $ANTLR start "rule__EmfTest__Group__4__Impl"
    // InternalXtextTest.g:1900:1: rule__EmfTest__Group__4__Impl : ( RULE_DEFAULT ) ;
    public final void rule__EmfTest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1904:1: ( ( RULE_DEFAULT ) )
            // InternalXtextTest.g:1906:1: ( RULE_DEFAULT )
            {
            // InternalXtextTest.g:1906:1: ( RULE_DEFAULT )
            // InternalXtextTest.g:1907:1: RULE_DEFAULT
            {
             before(grammarAccess.getEmfTestAccess().getDEFAULTTerminalRuleCall_4()); 
            match(input,RULE_DEFAULT,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getDEFAULTTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__4__Impl"


    // $ANTLR start "rule__EmfTest__Group__5"
    // InternalXtextTest.g:1920:1: rule__EmfTest__Group__5 : rule__EmfTest__Group__5__Impl rule__EmfTest__Group__6 ;
    public final void rule__EmfTest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1924:1: ( rule__EmfTest__Group__5__Impl rule__EmfTest__Group__6 )
            // InternalXtextTest.g:1925:2: rule__EmfTest__Group__5__Impl rule__EmfTest__Group__6
            {
            pushFollow(FOLLOW_14);
            rule__EmfTest__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__5"


    // $ANTLR start "rule__EmfTest__Group__5__Impl"
    // InternalXtextTest.g:1932:1: rule__EmfTest__Group__5__Impl : ( ( rule__EmfTest__MydefaultAssignment_5 ) ) ;
    public final void rule__EmfTest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1936:1: ( ( ( rule__EmfTest__MydefaultAssignment_5 ) ) )
            // InternalXtextTest.g:1938:1: ( ( rule__EmfTest__MydefaultAssignment_5 ) )
            {
            // InternalXtextTest.g:1938:1: ( ( rule__EmfTest__MydefaultAssignment_5 ) )
            // InternalXtextTest.g:1939:1: ( rule__EmfTest__MydefaultAssignment_5 )
            {
             before(grammarAccess.getEmfTestAccess().getMydefaultAssignment_5()); 
            // InternalXtextTest.g:1940:1: ( rule__EmfTest__MydefaultAssignment_5 )
            // InternalXtextTest.g:1940:2: rule__EmfTest__MydefaultAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__MydefaultAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getEmfTestAccess().getMydefaultAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__5__Impl"


    // $ANTLR start "rule__EmfTest__Group__6"
    // InternalXtextTest.g:1952:1: rule__EmfTest__Group__6 : rule__EmfTest__Group__6__Impl rule__EmfTest__Group__7 ;
    public final void rule__EmfTest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1956:1: ( rule__EmfTest__Group__6__Impl rule__EmfTest__Group__7 )
            // InternalXtextTest.g:1957:2: rule__EmfTest__Group__6__Impl rule__EmfTest__Group__7
            {
            pushFollow(FOLLOW_14);
            rule__EmfTest__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__6"


    // $ANTLR start "rule__EmfTest__Group__6__Impl"
    // InternalXtextTest.g:1964:1: rule__EmfTest__Group__6__Impl : ( ( rule__EmfTest__MyimportAssignment_6 )* ) ;
    public final void rule__EmfTest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1968:1: ( ( ( rule__EmfTest__MyimportAssignment_6 )* ) )
            // InternalXtextTest.g:1970:1: ( ( rule__EmfTest__MyimportAssignment_6 )* )
            {
            // InternalXtextTest.g:1970:1: ( ( rule__EmfTest__MyimportAssignment_6 )* )
            // InternalXtextTest.g:1971:1: ( rule__EmfTest__MyimportAssignment_6 )*
            {
             before(grammarAccess.getEmfTestAccess().getMyimportAssignment_6()); 
            // InternalXtextTest.g:1972:1: ( rule__EmfTest__MyimportAssignment_6 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_IMPORTS) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalXtextTest.g:1972:2: rule__EmfTest__MyimportAssignment_6
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__EmfTest__MyimportAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getEmfTestAccess().getMyimportAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__6__Impl"


    // $ANTLR start "rule__EmfTest__Group__7"
    // InternalXtextTest.g:1984:1: rule__EmfTest__Group__7 : rule__EmfTest__Group__7__Impl rule__EmfTest__Group__8 ;
    public final void rule__EmfTest__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1988:1: ( rule__EmfTest__Group__7__Impl rule__EmfTest__Group__8 )
            // InternalXtextTest.g:1989:2: rule__EmfTest__Group__7__Impl rule__EmfTest__Group__8
            {
            pushFollow(FOLLOW_14);
            rule__EmfTest__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__7"


    // $ANTLR start "rule__EmfTest__Group__7__Impl"
    // InternalXtextTest.g:1996:1: rule__EmfTest__Group__7__Impl : ( ( rule__EmfTest__Group_7__0 )? ) ;
    public final void rule__EmfTest__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2000:1: ( ( ( rule__EmfTest__Group_7__0 )? ) )
            // InternalXtextTest.g:2002:1: ( ( rule__EmfTest__Group_7__0 )? )
            {
            // InternalXtextTest.g:2002:1: ( ( rule__EmfTest__Group_7__0 )? )
            // InternalXtextTest.g:2003:1: ( rule__EmfTest__Group_7__0 )?
            {
             before(grammarAccess.getEmfTestAccess().getGroup_7()); 
            // InternalXtextTest.g:2004:1: ( rule__EmfTest__Group_7__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_TIMEOUT) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalXtextTest.g:2004:2: rule__EmfTest__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EmfTest__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEmfTestAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__7__Impl"


    // $ANTLR start "rule__EmfTest__Group__8"
    // InternalXtextTest.g:2016:1: rule__EmfTest__Group__8 : rule__EmfTest__Group__8__Impl rule__EmfTest__Group__9 ;
    public final void rule__EmfTest__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2020:1: ( rule__EmfTest__Group__8__Impl rule__EmfTest__Group__9 )
            // InternalXtextTest.g:2021:2: rule__EmfTest__Group__8__Impl rule__EmfTest__Group__9
            {
            pushFollow(FOLLOW_16);
            rule__EmfTest__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__8"


    // $ANTLR start "rule__EmfTest__Group__8__Impl"
    // InternalXtextTest.g:2028:1: rule__EmfTest__Group__8__Impl : ( ( rule__EmfTest__CodeCallAssignment_8 ) ) ;
    public final void rule__EmfTest__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2032:1: ( ( ( rule__EmfTest__CodeCallAssignment_8 ) ) )
            // InternalXtextTest.g:2034:1: ( ( rule__EmfTest__CodeCallAssignment_8 ) )
            {
            // InternalXtextTest.g:2034:1: ( ( rule__EmfTest__CodeCallAssignment_8 ) )
            // InternalXtextTest.g:2035:1: ( rule__EmfTest__CodeCallAssignment_8 )
            {
             before(grammarAccess.getEmfTestAccess().getCodeCallAssignment_8()); 
            // InternalXtextTest.g:2036:1: ( rule__EmfTest__CodeCallAssignment_8 )
            // InternalXtextTest.g:2036:2: rule__EmfTest__CodeCallAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__CodeCallAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getEmfTestAccess().getCodeCallAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__8__Impl"


    // $ANTLR start "rule__EmfTest__Group__9"
    // InternalXtextTest.g:2048:1: rule__EmfTest__Group__9 : rule__EmfTest__Group__9__Impl rule__EmfTest__Group__10 ;
    public final void rule__EmfTest__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2052:1: ( rule__EmfTest__Group__9__Impl rule__EmfTest__Group__10 )
            // InternalXtextTest.g:2053:2: rule__EmfTest__Group__9__Impl rule__EmfTest__Group__10
            {
            pushFollow(FOLLOW_16);
            rule__EmfTest__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__9"


    // $ANTLR start "rule__EmfTest__Group__9__Impl"
    // InternalXtextTest.g:2060:1: rule__EmfTest__Group__9__Impl : ( ( rule__EmfTest__Group_9__0 )? ) ;
    public final void rule__EmfTest__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2064:1: ( ( ( rule__EmfTest__Group_9__0 )? ) )
            // InternalXtextTest.g:2066:1: ( ( rule__EmfTest__Group_9__0 )? )
            {
            // InternalXtextTest.g:2066:1: ( ( rule__EmfTest__Group_9__0 )? )
            // InternalXtextTest.g:2067:1: ( rule__EmfTest__Group_9__0 )?
            {
             before(grammarAccess.getEmfTestAccess().getGroup_9()); 
            // InternalXtextTest.g:2068:1: ( rule__EmfTest__Group_9__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_OPTIONS) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalXtextTest.g:2068:2: rule__EmfTest__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EmfTest__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEmfTestAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__9__Impl"


    // $ANTLR start "rule__EmfTest__Group__10"
    // InternalXtextTest.g:2080:1: rule__EmfTest__Group__10 : rule__EmfTest__Group__10__Impl rule__EmfTest__Group__11 ;
    public final void rule__EmfTest__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2084:1: ( rule__EmfTest__Group__10__Impl rule__EmfTest__Group__11 )
            // InternalXtextTest.g:2085:2: rule__EmfTest__Group__10__Impl rule__EmfTest__Group__11
            {
            pushFollow(FOLLOW_16);
            rule__EmfTest__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__10"


    // $ANTLR start "rule__EmfTest__Group__10__Impl"
    // InternalXtextTest.g:2092:1: rule__EmfTest__Group__10__Impl : ( ( rule__EmfTest__Group_10__0 )? ) ;
    public final void rule__EmfTest__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2096:1: ( ( ( rule__EmfTest__Group_10__0 )? ) )
            // InternalXtextTest.g:2098:1: ( ( rule__EmfTest__Group_10__0 )? )
            {
            // InternalXtextTest.g:2098:1: ( ( rule__EmfTest__Group_10__0 )? )
            // InternalXtextTest.g:2099:1: ( rule__EmfTest__Group_10__0 )?
            {
             before(grammarAccess.getEmfTestAccess().getGroup_10()); 
            // InternalXtextTest.g:2100:1: ( rule__EmfTest__Group_10__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_PARAMS) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalXtextTest.g:2100:2: rule__EmfTest__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EmfTest__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEmfTestAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__10__Impl"


    // $ANTLR start "rule__EmfTest__Group__11"
    // InternalXtextTest.g:2112:1: rule__EmfTest__Group__11 : rule__EmfTest__Group__11__Impl rule__EmfTest__Group__12 ;
    public final void rule__EmfTest__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2116:1: ( rule__EmfTest__Group__11__Impl rule__EmfTest__Group__12 )
            // InternalXtextTest.g:2117:2: rule__EmfTest__Group__11__Impl rule__EmfTest__Group__12
            {
            pushFollow(FOLLOW_8);
            rule__EmfTest__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__11"


    // $ANTLR start "rule__EmfTest__Group__11__Impl"
    // InternalXtextTest.g:2124:1: rule__EmfTest__Group__11__Impl : ( ( rule__EmfTest__Group_11__0 ) ) ;
    public final void rule__EmfTest__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2128:1: ( ( ( rule__EmfTest__Group_11__0 ) ) )
            // InternalXtextTest.g:2130:1: ( ( rule__EmfTest__Group_11__0 ) )
            {
            // InternalXtextTest.g:2130:1: ( ( rule__EmfTest__Group_11__0 ) )
            // InternalXtextTest.g:2131:1: ( rule__EmfTest__Group_11__0 )
            {
             before(grammarAccess.getEmfTestAccess().getGroup_11()); 
            // InternalXtextTest.g:2132:1: ( rule__EmfTest__Group_11__0 )
            // InternalXtextTest.g:2132:2: rule__EmfTest__Group_11__0
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_11__0();

            state._fsp--;


            }

             after(grammarAccess.getEmfTestAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__11__Impl"


    // $ANTLR start "rule__EmfTest__Group__12"
    // InternalXtextTest.g:2144:1: rule__EmfTest__Group__12 : rule__EmfTest__Group__12__Impl rule__EmfTest__Group__13 ;
    public final void rule__EmfTest__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2148:1: ( rule__EmfTest__Group__12__Impl rule__EmfTest__Group__13 )
            // InternalXtextTest.g:2149:2: rule__EmfTest__Group__12__Impl rule__EmfTest__Group__13
            {
            pushFollow(FOLLOW_17);
            rule__EmfTest__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__12"


    // $ANTLR start "rule__EmfTest__Group__12__Impl"
    // InternalXtextTest.g:2156:1: rule__EmfTest__Group__12__Impl : ( ( rule__EmfTest__RootAssignment_12 ) ) ;
    public final void rule__EmfTest__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2160:1: ( ( ( rule__EmfTest__RootAssignment_12 ) ) )
            // InternalXtextTest.g:2162:1: ( ( rule__EmfTest__RootAssignment_12 ) )
            {
            // InternalXtextTest.g:2162:1: ( ( rule__EmfTest__RootAssignment_12 ) )
            // InternalXtextTest.g:2163:1: ( rule__EmfTest__RootAssignment_12 )
            {
             before(grammarAccess.getEmfTestAccess().getRootAssignment_12()); 
            // InternalXtextTest.g:2164:1: ( rule__EmfTest__RootAssignment_12 )
            // InternalXtextTest.g:2164:2: rule__EmfTest__RootAssignment_12
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__RootAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getEmfTestAccess().getRootAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__12__Impl"


    // $ANTLR start "rule__EmfTest__Group__13"
    // InternalXtextTest.g:2176:1: rule__EmfTest__Group__13 : rule__EmfTest__Group__13__Impl rule__EmfTest__Group__14 ;
    public final void rule__EmfTest__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2180:1: ( rule__EmfTest__Group__13__Impl rule__EmfTest__Group__14 )
            // InternalXtextTest.g:2181:2: rule__EmfTest__Group__13__Impl rule__EmfTest__Group__14
            {
            pushFollow(FOLLOW_17);
            rule__EmfTest__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__13"


    // $ANTLR start "rule__EmfTest__Group__13__Impl"
    // InternalXtextTest.g:2188:1: rule__EmfTest__Group__13__Impl : ( ( rule__EmfTest__BeforeAssignment_13 )? ) ;
    public final void rule__EmfTest__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2192:1: ( ( ( rule__EmfTest__BeforeAssignment_13 )? ) )
            // InternalXtextTest.g:2194:1: ( ( rule__EmfTest__BeforeAssignment_13 )? )
            {
            // InternalXtextTest.g:2194:1: ( ( rule__EmfTest__BeforeAssignment_13 )? )
            // InternalXtextTest.g:2195:1: ( rule__EmfTest__BeforeAssignment_13 )?
            {
             before(grammarAccess.getEmfTestAccess().getBeforeAssignment_13()); 
            // InternalXtextTest.g:2196:1: ( rule__EmfTest__BeforeAssignment_13 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_BEFORE_KW) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalXtextTest.g:2196:2: rule__EmfTest__BeforeAssignment_13
                    {
                    pushFollow(FOLLOW_2);
                    rule__EmfTest__BeforeAssignment_13();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEmfTestAccess().getBeforeAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__13__Impl"


    // $ANTLR start "rule__EmfTest__Group__14"
    // InternalXtextTest.g:2208:1: rule__EmfTest__Group__14 : rule__EmfTest__Group__14__Impl ;
    public final void rule__EmfTest__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2212:1: ( rule__EmfTest__Group__14__Impl )
            // InternalXtextTest.g:2213:2: rule__EmfTest__Group__14__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__14__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__14"


    // $ANTLR start "rule__EmfTest__Group__14__Impl"
    // InternalXtextTest.g:2219:1: rule__EmfTest__Group__14__Impl : ( ( rule__EmfTest__AfterAssignment_14 )? ) ;
    public final void rule__EmfTest__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2223:1: ( ( ( rule__EmfTest__AfterAssignment_14 )? ) )
            // InternalXtextTest.g:2225:1: ( ( rule__EmfTest__AfterAssignment_14 )? )
            {
            // InternalXtextTest.g:2225:1: ( ( rule__EmfTest__AfterAssignment_14 )? )
            // InternalXtextTest.g:2226:1: ( rule__EmfTest__AfterAssignment_14 )?
            {
             before(grammarAccess.getEmfTestAccess().getAfterAssignment_14()); 
            // InternalXtextTest.g:2227:1: ( rule__EmfTest__AfterAssignment_14 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_AFTER_KW) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalXtextTest.g:2227:2: rule__EmfTest__AfterAssignment_14
                    {
                    pushFollow(FOLLOW_2);
                    rule__EmfTest__AfterAssignment_14();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEmfTestAccess().getAfterAssignment_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group__14__Impl"


    // $ANTLR start "rule__EmfTest__Group_7__0"
    // InternalXtextTest.g:2269:1: rule__EmfTest__Group_7__0 : rule__EmfTest__Group_7__0__Impl rule__EmfTest__Group_7__1 ;
    public final void rule__EmfTest__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2273:1: ( rule__EmfTest__Group_7__0__Impl rule__EmfTest__Group_7__1 )
            // InternalXtextTest.g:2274:2: rule__EmfTest__Group_7__0__Impl rule__EmfTest__Group_7__1
            {
            pushFollow(FOLLOW_10);
            rule__EmfTest__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_7__0"


    // $ANTLR start "rule__EmfTest__Group_7__0__Impl"
    // InternalXtextTest.g:2281:1: rule__EmfTest__Group_7__0__Impl : ( RULE_TIMEOUT ) ;
    public final void rule__EmfTest__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2285:1: ( ( RULE_TIMEOUT ) )
            // InternalXtextTest.g:2287:1: ( RULE_TIMEOUT )
            {
            // InternalXtextTest.g:2287:1: ( RULE_TIMEOUT )
            // InternalXtextTest.g:2288:1: RULE_TIMEOUT
            {
             before(grammarAccess.getEmfTestAccess().getTIMEOUTTerminalRuleCall_7_0()); 
            match(input,RULE_TIMEOUT,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getTIMEOUTTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_7__0__Impl"


    // $ANTLR start "rule__EmfTest__Group_7__1"
    // InternalXtextTest.g:2301:1: rule__EmfTest__Group_7__1 : rule__EmfTest__Group_7__1__Impl rule__EmfTest__Group_7__2 ;
    public final void rule__EmfTest__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2305:1: ( rule__EmfTest__Group_7__1__Impl rule__EmfTest__Group_7__2 )
            // InternalXtextTest.g:2306:2: rule__EmfTest__Group_7__1__Impl rule__EmfTest__Group_7__2
            {
            pushFollow(FOLLOW_12);
            rule__EmfTest__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_7__1"


    // $ANTLR start "rule__EmfTest__Group_7__1__Impl"
    // InternalXtextTest.g:2313:1: rule__EmfTest__Group_7__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__EmfTest__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2317:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:2319:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:2319:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:2320:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getEmfTestAccess().getASSIGNASSINGLETerminalRuleCall_7_1()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getASSIGNASSINGLETerminalRuleCall_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_7__1__Impl"


    // $ANTLR start "rule__EmfTest__Group_7__2"
    // InternalXtextTest.g:2333:1: rule__EmfTest__Group_7__2 : rule__EmfTest__Group_7__2__Impl ;
    public final void rule__EmfTest__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2337:1: ( rule__EmfTest__Group_7__2__Impl )
            // InternalXtextTest.g:2338:2: rule__EmfTest__Group_7__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_7__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_7__2"


    // $ANTLR start "rule__EmfTest__Group_7__2__Impl"
    // InternalXtextTest.g:2344:1: rule__EmfTest__Group_7__2__Impl : ( ( rule__EmfTest__TimeOutAssignment_7_2 ) ) ;
    public final void rule__EmfTest__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2348:1: ( ( ( rule__EmfTest__TimeOutAssignment_7_2 ) ) )
            // InternalXtextTest.g:2350:1: ( ( rule__EmfTest__TimeOutAssignment_7_2 ) )
            {
            // InternalXtextTest.g:2350:1: ( ( rule__EmfTest__TimeOutAssignment_7_2 ) )
            // InternalXtextTest.g:2351:1: ( rule__EmfTest__TimeOutAssignment_7_2 )
            {
             before(grammarAccess.getEmfTestAccess().getTimeOutAssignment_7_2()); 
            // InternalXtextTest.g:2352:1: ( rule__EmfTest__TimeOutAssignment_7_2 )
            // InternalXtextTest.g:2352:2: rule__EmfTest__TimeOutAssignment_7_2
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__TimeOutAssignment_7_2();

            state._fsp--;


            }

             after(grammarAccess.getEmfTestAccess().getTimeOutAssignment_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_7__2__Impl"


    // $ANTLR start "rule__EmfTest__Group_9__0"
    // InternalXtextTest.g:2370:1: rule__EmfTest__Group_9__0 : rule__EmfTest__Group_9__0__Impl rule__EmfTest__Group_9__1 ;
    public final void rule__EmfTest__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2374:1: ( rule__EmfTest__Group_9__0__Impl rule__EmfTest__Group_9__1 )
            // InternalXtextTest.g:2375:2: rule__EmfTest__Group_9__0__Impl rule__EmfTest__Group_9__1
            {
            pushFollow(FOLLOW_14);
            rule__EmfTest__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_9__0"


    // $ANTLR start "rule__EmfTest__Group_9__0__Impl"
    // InternalXtextTest.g:2382:1: rule__EmfTest__Group_9__0__Impl : ( RULE_OPTIONS ) ;
    public final void rule__EmfTest__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2386:1: ( ( RULE_OPTIONS ) )
            // InternalXtextTest.g:2388:1: ( RULE_OPTIONS )
            {
            // InternalXtextTest.g:2388:1: ( RULE_OPTIONS )
            // InternalXtextTest.g:2389:1: RULE_OPTIONS
            {
             before(grammarAccess.getEmfTestAccess().getOPTIONSTerminalRuleCall_9_0()); 
            match(input,RULE_OPTIONS,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getOPTIONSTerminalRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_9__0__Impl"


    // $ANTLR start "rule__EmfTest__Group_9__1"
    // InternalXtextTest.g:2402:1: rule__EmfTest__Group_9__1 : rule__EmfTest__Group_9__1__Impl ;
    public final void rule__EmfTest__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2406:1: ( rule__EmfTest__Group_9__1__Impl )
            // InternalXtextTest.g:2407:2: rule__EmfTest__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_9__1"


    // $ANTLR start "rule__EmfTest__Group_9__1__Impl"
    // InternalXtextTest.g:2413:1: rule__EmfTest__Group_9__1__Impl : ( ( rule__EmfTest__OptionCallAssignment_9_1 ) ) ;
    public final void rule__EmfTest__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2417:1: ( ( ( rule__EmfTest__OptionCallAssignment_9_1 ) ) )
            // InternalXtextTest.g:2419:1: ( ( rule__EmfTest__OptionCallAssignment_9_1 ) )
            {
            // InternalXtextTest.g:2419:1: ( ( rule__EmfTest__OptionCallAssignment_9_1 ) )
            // InternalXtextTest.g:2420:1: ( rule__EmfTest__OptionCallAssignment_9_1 )
            {
             before(grammarAccess.getEmfTestAccess().getOptionCallAssignment_9_1()); 
            // InternalXtextTest.g:2421:1: ( rule__EmfTest__OptionCallAssignment_9_1 )
            // InternalXtextTest.g:2421:2: rule__EmfTest__OptionCallAssignment_9_1
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__OptionCallAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getEmfTestAccess().getOptionCallAssignment_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_9__1__Impl"


    // $ANTLR start "rule__EmfTest__Group_10__0"
    // InternalXtextTest.g:2437:1: rule__EmfTest__Group_10__0 : rule__EmfTest__Group_10__0__Impl rule__EmfTest__Group_10__1 ;
    public final void rule__EmfTest__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2441:1: ( rule__EmfTest__Group_10__0__Impl rule__EmfTest__Group_10__1 )
            // InternalXtextTest.g:2442:2: rule__EmfTest__Group_10__0__Impl rule__EmfTest__Group_10__1
            {
            pushFollow(FOLLOW_14);
            rule__EmfTest__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_10__0"


    // $ANTLR start "rule__EmfTest__Group_10__0__Impl"
    // InternalXtextTest.g:2449:1: rule__EmfTest__Group_10__0__Impl : ( RULE_PARAMS ) ;
    public final void rule__EmfTest__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2453:1: ( ( RULE_PARAMS ) )
            // InternalXtextTest.g:2455:1: ( RULE_PARAMS )
            {
            // InternalXtextTest.g:2455:1: ( RULE_PARAMS )
            // InternalXtextTest.g:2456:1: RULE_PARAMS
            {
             before(grammarAccess.getEmfTestAccess().getPARAMSTerminalRuleCall_10_0()); 
            match(input,RULE_PARAMS,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getPARAMSTerminalRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_10__0__Impl"


    // $ANTLR start "rule__EmfTest__Group_10__1"
    // InternalXtextTest.g:2469:1: rule__EmfTest__Group_10__1 : rule__EmfTest__Group_10__1__Impl ;
    public final void rule__EmfTest__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2473:1: ( rule__EmfTest__Group_10__1__Impl )
            // InternalXtextTest.g:2474:2: rule__EmfTest__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_10__1"


    // $ANTLR start "rule__EmfTest__Group_10__1__Impl"
    // InternalXtextTest.g:2480:1: rule__EmfTest__Group_10__1__Impl : ( ( rule__EmfTest__ParamCallAssignment_10_1 ) ) ;
    public final void rule__EmfTest__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2484:1: ( ( ( rule__EmfTest__ParamCallAssignment_10_1 ) ) )
            // InternalXtextTest.g:2486:1: ( ( rule__EmfTest__ParamCallAssignment_10_1 ) )
            {
            // InternalXtextTest.g:2486:1: ( ( rule__EmfTest__ParamCallAssignment_10_1 ) )
            // InternalXtextTest.g:2487:1: ( rule__EmfTest__ParamCallAssignment_10_1 )
            {
             before(grammarAccess.getEmfTestAccess().getParamCallAssignment_10_1()); 
            // InternalXtextTest.g:2488:1: ( rule__EmfTest__ParamCallAssignment_10_1 )
            // InternalXtextTest.g:2488:2: rule__EmfTest__ParamCallAssignment_10_1
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__ParamCallAssignment_10_1();

            state._fsp--;


            }

             after(grammarAccess.getEmfTestAccess().getParamCallAssignment_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_10__1__Impl"


    // $ANTLR start "rule__EmfTest__Group_11__0"
    // InternalXtextTest.g:2504:1: rule__EmfTest__Group_11__0 : rule__EmfTest__Group_11__0__Impl rule__EmfTest__Group_11__1 ;
    public final void rule__EmfTest__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2508:1: ( rule__EmfTest__Group_11__0__Impl rule__EmfTest__Group_11__1 )
            // InternalXtextTest.g:2509:2: rule__EmfTest__Group_11__0__Impl rule__EmfTest__Group_11__1
            {
            pushFollow(FOLLOW_18);
            rule__EmfTest__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_11__0"


    // $ANTLR start "rule__EmfTest__Group_11__0__Impl"
    // InternalXtextTest.g:2516:1: rule__EmfTest__Group_11__0__Impl : ( RULE_SOURCE ) ;
    public final void rule__EmfTest__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2520:1: ( ( RULE_SOURCE ) )
            // InternalXtextTest.g:2522:1: ( RULE_SOURCE )
            {
            // InternalXtextTest.g:2522:1: ( RULE_SOURCE )
            // InternalXtextTest.g:2523:1: RULE_SOURCE
            {
             before(grammarAccess.getEmfTestAccess().getSOURCETerminalRuleCall_11_0()); 
            match(input,RULE_SOURCE,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getSOURCETerminalRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_11__0__Impl"


    // $ANTLR start "rule__EmfTest__Group_11__1"
    // InternalXtextTest.g:2536:1: rule__EmfTest__Group_11__1 : rule__EmfTest__Group_11__1__Impl rule__EmfTest__Group_11__2 ;
    public final void rule__EmfTest__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2540:1: ( rule__EmfTest__Group_11__1__Impl rule__EmfTest__Group_11__2 )
            // InternalXtextTest.g:2541:2: rule__EmfTest__Group_11__1__Impl rule__EmfTest__Group_11__2
            {
            pushFollow(FOLLOW_10);
            rule__EmfTest__Group_11__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_11__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_11__1"


    // $ANTLR start "rule__EmfTest__Group_11__1__Impl"
    // InternalXtextTest.g:2548:1: rule__EmfTest__Group_11__1__Impl : ( RULE_FILE ) ;
    public final void rule__EmfTest__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2552:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:2554:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:2554:1: ( RULE_FILE )
            // InternalXtextTest.g:2555:1: RULE_FILE
            {
             before(grammarAccess.getEmfTestAccess().getFILETerminalRuleCall_11_1()); 
            match(input,RULE_FILE,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getFILETerminalRuleCall_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_11__1__Impl"


    // $ANTLR start "rule__EmfTest__Group_11__2"
    // InternalXtextTest.g:2568:1: rule__EmfTest__Group_11__2 : rule__EmfTest__Group_11__2__Impl rule__EmfTest__Group_11__3 ;
    public final void rule__EmfTest__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2572:1: ( rule__EmfTest__Group_11__2__Impl rule__EmfTest__Group_11__3 )
            // InternalXtextTest.g:2573:2: rule__EmfTest__Group_11__2__Impl rule__EmfTest__Group_11__3
            {
            pushFollow(FOLLOW_19);
            rule__EmfTest__Group_11__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_11__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_11__2"


    // $ANTLR start "rule__EmfTest__Group_11__2__Impl"
    // InternalXtextTest.g:2580:1: rule__EmfTest__Group_11__2__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__EmfTest__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2584:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:2586:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:2586:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:2587:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getEmfTestAccess().getASSIGNASSINGLETerminalRuleCall_11_2()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getASSIGNASSINGLETerminalRuleCall_11_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_11__2__Impl"


    // $ANTLR start "rule__EmfTest__Group_11__3"
    // InternalXtextTest.g:2600:1: rule__EmfTest__Group_11__3 : rule__EmfTest__Group_11__3__Impl ;
    public final void rule__EmfTest__Group_11__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2604:1: ( rule__EmfTest__Group_11__3__Impl )
            // InternalXtextTest.g:2605:2: rule__EmfTest__Group_11__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_11__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_11__3"


    // $ANTLR start "rule__EmfTest__Group_11__3__Impl"
    // InternalXtextTest.g:2611:1: rule__EmfTest__Group_11__3__Impl : ( ( rule__EmfTest__FileAssignment_11_3 ) ) ;
    public final void rule__EmfTest__Group_11__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2615:1: ( ( ( rule__EmfTest__FileAssignment_11_3 ) ) )
            // InternalXtextTest.g:2617:1: ( ( rule__EmfTest__FileAssignment_11_3 ) )
            {
            // InternalXtextTest.g:2617:1: ( ( rule__EmfTest__FileAssignment_11_3 ) )
            // InternalXtextTest.g:2618:1: ( rule__EmfTest__FileAssignment_11_3 )
            {
             before(grammarAccess.getEmfTestAccess().getFileAssignment_11_3()); 
            // InternalXtextTest.g:2619:1: ( rule__EmfTest__FileAssignment_11_3 )
            // InternalXtextTest.g:2619:2: rule__EmfTest__FileAssignment_11_3
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__FileAssignment_11_3();

            state._fsp--;


            }

             after(grammarAccess.getEmfTestAccess().getFileAssignment_11_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_11__3__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalXtextTest.g:2639:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2643:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalXtextTest.g:2644:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // InternalXtextTest.g:2651:1: rule__Import__Group__0__Impl : ( () ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2655:1: ( ( () ) )
            // InternalXtextTest.g:2657:1: ( () )
            {
            // InternalXtextTest.g:2657:1: ( () )
            // InternalXtextTest.g:2658:1: ()
            {
             before(grammarAccess.getImportAccess().getImportAction_0()); 
            // InternalXtextTest.g:2659:1: ()
            // InternalXtextTest.g:2661:1: 
            {
            }

             after(grammarAccess.getImportAccess().getImportAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // InternalXtextTest.g:2673:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2677:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // InternalXtextTest.g:2678:2: rule__Import__Group__1__Impl rule__Import__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Import__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // InternalXtextTest.g:2685:1: rule__Import__Group__1__Impl : ( RULE_IMPORTS ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2689:1: ( ( RULE_IMPORTS ) )
            // InternalXtextTest.g:2691:1: ( RULE_IMPORTS )
            {
            // InternalXtextTest.g:2691:1: ( RULE_IMPORTS )
            // InternalXtextTest.g:2692:1: RULE_IMPORTS
            {
             before(grammarAccess.getImportAccess().getIMPORTSTerminalRuleCall_1()); 
            match(input,RULE_IMPORTS,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getIMPORTSTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__2"
    // InternalXtextTest.g:2705:1: rule__Import__Group__2 : rule__Import__Group__2__Impl rule__Import__Group__3 ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2709:1: ( rule__Import__Group__2__Impl rule__Import__Group__3 )
            // InternalXtextTest.g:2710:2: rule__Import__Group__2__Impl rule__Import__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__Import__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__2"


    // $ANTLR start "rule__Import__Group__2__Impl"
    // InternalXtextTest.g:2717:1: rule__Import__Group__2__Impl : ( ( rule__Import__IdAssignment_2 ) ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2721:1: ( ( ( rule__Import__IdAssignment_2 ) ) )
            // InternalXtextTest.g:2723:1: ( ( rule__Import__IdAssignment_2 ) )
            {
            // InternalXtextTest.g:2723:1: ( ( rule__Import__IdAssignment_2 ) )
            // InternalXtextTest.g:2724:1: ( rule__Import__IdAssignment_2 )
            {
             before(grammarAccess.getImportAccess().getIdAssignment_2()); 
            // InternalXtextTest.g:2725:1: ( rule__Import__IdAssignment_2 )
            // InternalXtextTest.g:2725:2: rule__Import__IdAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Import__IdAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getIdAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__2__Impl"


    // $ANTLR start "rule__Import__Group__3"
    // InternalXtextTest.g:2737:1: rule__Import__Group__3 : rule__Import__Group__3__Impl rule__Import__Group__4 ;
    public final void rule__Import__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2741:1: ( rule__Import__Group__3__Impl rule__Import__Group__4 )
            // InternalXtextTest.g:2742:2: rule__Import__Group__3__Impl rule__Import__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__Import__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__3"


    // $ANTLR start "rule__Import__Group__3__Impl"
    // InternalXtextTest.g:2749:1: rule__Import__Group__3__Impl : ( RULE_KW_AS ) ;
    public final void rule__Import__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2753:1: ( ( RULE_KW_AS ) )
            // InternalXtextTest.g:2755:1: ( RULE_KW_AS )
            {
            // InternalXtextTest.g:2755:1: ( RULE_KW_AS )
            // InternalXtextTest.g:2756:1: RULE_KW_AS
            {
             before(grammarAccess.getImportAccess().getKW_ASTerminalRuleCall_3()); 
            match(input,RULE_KW_AS,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getKW_ASTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__3__Impl"


    // $ANTLR start "rule__Import__Group__4"
    // InternalXtextTest.g:2769:1: rule__Import__Group__4 : rule__Import__Group__4__Impl ;
    public final void rule__Import__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2773:1: ( rule__Import__Group__4__Impl )
            // InternalXtextTest.g:2774:2: rule__Import__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__4"


    // $ANTLR start "rule__Import__Group__4__Impl"
    // InternalXtextTest.g:2780:1: rule__Import__Group__4__Impl : ( ( rule__Import__AliasAssignment_4 ) ) ;
    public final void rule__Import__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2784:1: ( ( ( rule__Import__AliasAssignment_4 ) ) )
            // InternalXtextTest.g:2786:1: ( ( rule__Import__AliasAssignment_4 ) )
            {
            // InternalXtextTest.g:2786:1: ( ( rule__Import__AliasAssignment_4 ) )
            // InternalXtextTest.g:2787:1: ( rule__Import__AliasAssignment_4 )
            {
             before(grammarAccess.getImportAccess().getAliasAssignment_4()); 
            // InternalXtextTest.g:2788:1: ( rule__Import__AliasAssignment_4 )
            // InternalXtextTest.g:2788:2: rule__Import__AliasAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Import__AliasAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getAliasAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__4__Impl"


    // $ANTLR start "rule__PackageID__Group__0"
    // InternalXtextTest.g:2810:1: rule__PackageID__Group__0 : rule__PackageID__Group__0__Impl rule__PackageID__Group__1 ;
    public final void rule__PackageID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2814:1: ( rule__PackageID__Group__0__Impl rule__PackageID__Group__1 )
            // InternalXtextTest.g:2815:2: rule__PackageID__Group__0__Impl rule__PackageID__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__PackageID__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PackageID__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageID__Group__0"


    // $ANTLR start "rule__PackageID__Group__0__Impl"
    // InternalXtextTest.g:2822:1: rule__PackageID__Group__0__Impl : ( RULE_IDENTIFIER ) ;
    public final void rule__PackageID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2826:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:2828:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:2828:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:2829:1: RULE_IDENTIFIER
            {
             before(grammarAccess.getPackageIDAccess().getIDENTIFIERTerminalRuleCall_0()); 
            match(input,RULE_IDENTIFIER,FOLLOW_2); 
             after(grammarAccess.getPackageIDAccess().getIDENTIFIERTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageID__Group__0__Impl"


    // $ANTLR start "rule__PackageID__Group__1"
    // InternalXtextTest.g:2842:1: rule__PackageID__Group__1 : rule__PackageID__Group__1__Impl ;
    public final void rule__PackageID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2846:1: ( rule__PackageID__Group__1__Impl )
            // InternalXtextTest.g:2847:2: rule__PackageID__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PackageID__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageID__Group__1"


    // $ANTLR start "rule__PackageID__Group__1__Impl"
    // InternalXtextTest.g:2853:1: rule__PackageID__Group__1__Impl : ( ( rule__PackageID__Group_1__0 )* ) ;
    public final void rule__PackageID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2857:1: ( ( ( rule__PackageID__Group_1__0 )* ) )
            // InternalXtextTest.g:2859:1: ( ( rule__PackageID__Group_1__0 )* )
            {
            // InternalXtextTest.g:2859:1: ( ( rule__PackageID__Group_1__0 )* )
            // InternalXtextTest.g:2860:1: ( rule__PackageID__Group_1__0 )*
            {
             before(grammarAccess.getPackageIDAccess().getGroup_1()); 
            // InternalXtextTest.g:2861:1: ( rule__PackageID__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_POINT) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalXtextTest.g:2861:2: rule__PackageID__Group_1__0
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__PackageID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getPackageIDAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageID__Group__1__Impl"


    // $ANTLR start "rule__PackageID__Group_1__0"
    // InternalXtextTest.g:2877:1: rule__PackageID__Group_1__0 : rule__PackageID__Group_1__0__Impl rule__PackageID__Group_1__1 ;
    public final void rule__PackageID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2881:1: ( rule__PackageID__Group_1__0__Impl rule__PackageID__Group_1__1 )
            // InternalXtextTest.g:2882:2: rule__PackageID__Group_1__0__Impl rule__PackageID__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__PackageID__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PackageID__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageID__Group_1__0"


    // $ANTLR start "rule__PackageID__Group_1__0__Impl"
    // InternalXtextTest.g:2889:1: rule__PackageID__Group_1__0__Impl : ( RULE_POINT ) ;
    public final void rule__PackageID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2893:1: ( ( RULE_POINT ) )
            // InternalXtextTest.g:2895:1: ( RULE_POINT )
            {
            // InternalXtextTest.g:2895:1: ( RULE_POINT )
            // InternalXtextTest.g:2896:1: RULE_POINT
            {
             before(grammarAccess.getPackageIDAccess().getPOINTTerminalRuleCall_1_0()); 
            match(input,RULE_POINT,FOLLOW_2); 
             after(grammarAccess.getPackageIDAccess().getPOINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageID__Group_1__0__Impl"


    // $ANTLR start "rule__PackageID__Group_1__1"
    // InternalXtextTest.g:2909:1: rule__PackageID__Group_1__1 : rule__PackageID__Group_1__1__Impl ;
    public final void rule__PackageID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2913:1: ( rule__PackageID__Group_1__1__Impl )
            // InternalXtextTest.g:2914:2: rule__PackageID__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PackageID__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageID__Group_1__1"


    // $ANTLR start "rule__PackageID__Group_1__1__Impl"
    // InternalXtextTest.g:2920:1: rule__PackageID__Group_1__1__Impl : ( RULE_IDENTIFIER ) ;
    public final void rule__PackageID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2924:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:2926:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:2926:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:2927:1: RULE_IDENTIFIER
            {
             before(grammarAccess.getPackageIDAccess().getIDENTIFIERTerminalRuleCall_1_1()); 
            match(input,RULE_IDENTIFIER,FOLLOW_2); 
             after(grammarAccess.getPackageIDAccess().getIDENTIFIERTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageID__Group_1__1__Impl"


    // $ANTLR start "rule__ImportID__Group__0"
    // InternalXtextTest.g:2944:1: rule__ImportID__Group__0 : rule__ImportID__Group__0__Impl rule__ImportID__Group__1 ;
    public final void rule__ImportID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2948:1: ( rule__ImportID__Group__0__Impl rule__ImportID__Group__1 )
            // InternalXtextTest.g:2949:2: rule__ImportID__Group__0__Impl rule__ImportID__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__ImportID__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImportID__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportID__Group__0"


    // $ANTLR start "rule__ImportID__Group__0__Impl"
    // InternalXtextTest.g:2956:1: rule__ImportID__Group__0__Impl : ( RULE_IDENTIFIER ) ;
    public final void rule__ImportID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2960:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:2962:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:2962:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:2963:1: RULE_IDENTIFIER
            {
             before(grammarAccess.getImportIDAccess().getIDENTIFIERTerminalRuleCall_0()); 
            match(input,RULE_IDENTIFIER,FOLLOW_2); 
             after(grammarAccess.getImportIDAccess().getIDENTIFIERTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportID__Group__0__Impl"


    // $ANTLR start "rule__ImportID__Group__1"
    // InternalXtextTest.g:2976:1: rule__ImportID__Group__1 : rule__ImportID__Group__1__Impl ;
    public final void rule__ImportID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2980:1: ( rule__ImportID__Group__1__Impl )
            // InternalXtextTest.g:2981:2: rule__ImportID__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImportID__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportID__Group__1"


    // $ANTLR start "rule__ImportID__Group__1__Impl"
    // InternalXtextTest.g:2987:1: rule__ImportID__Group__1__Impl : ( ( rule__ImportID__Group_1__0 )* ) ;
    public final void rule__ImportID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2991:1: ( ( ( rule__ImportID__Group_1__0 )* ) )
            // InternalXtextTest.g:2993:1: ( ( rule__ImportID__Group_1__0 )* )
            {
            // InternalXtextTest.g:2993:1: ( ( rule__ImportID__Group_1__0 )* )
            // InternalXtextTest.g:2994:1: ( rule__ImportID__Group_1__0 )*
            {
             before(grammarAccess.getImportIDAccess().getGroup_1()); 
            // InternalXtextTest.g:2995:1: ( rule__ImportID__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_POINT) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalXtextTest.g:2995:2: rule__ImportID__Group_1__0
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__ImportID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getImportIDAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportID__Group__1__Impl"


    // $ANTLR start "rule__ImportID__Group_1__0"
    // InternalXtextTest.g:3011:1: rule__ImportID__Group_1__0 : rule__ImportID__Group_1__0__Impl rule__ImportID__Group_1__1 ;
    public final void rule__ImportID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3015:1: ( rule__ImportID__Group_1__0__Impl rule__ImportID__Group_1__1 )
            // InternalXtextTest.g:3016:2: rule__ImportID__Group_1__0__Impl rule__ImportID__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__ImportID__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImportID__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportID__Group_1__0"


    // $ANTLR start "rule__ImportID__Group_1__0__Impl"
    // InternalXtextTest.g:3023:1: rule__ImportID__Group_1__0__Impl : ( RULE_POINT ) ;
    public final void rule__ImportID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3027:1: ( ( RULE_POINT ) )
            // InternalXtextTest.g:3029:1: ( RULE_POINT )
            {
            // InternalXtextTest.g:3029:1: ( RULE_POINT )
            // InternalXtextTest.g:3030:1: RULE_POINT
            {
             before(grammarAccess.getImportIDAccess().getPOINTTerminalRuleCall_1_0()); 
            match(input,RULE_POINT,FOLLOW_2); 
             after(grammarAccess.getImportIDAccess().getPOINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportID__Group_1__0__Impl"


    // $ANTLR start "rule__ImportID__Group_1__1"
    // InternalXtextTest.g:3043:1: rule__ImportID__Group_1__1 : rule__ImportID__Group_1__1__Impl ;
    public final void rule__ImportID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3047:1: ( rule__ImportID__Group_1__1__Impl )
            // InternalXtextTest.g:3048:2: rule__ImportID__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImportID__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportID__Group_1__1"


    // $ANTLR start "rule__ImportID__Group_1__1__Impl"
    // InternalXtextTest.g:3054:1: rule__ImportID__Group_1__1__Impl : ( RULE_IDENTIFIER ) ;
    public final void rule__ImportID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3058:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:3060:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:3060:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:3061:1: RULE_IDENTIFIER
            {
             before(grammarAccess.getImportIDAccess().getIDENTIFIERTerminalRuleCall_1_1()); 
            match(input,RULE_IDENTIFIER,FOLLOW_2); 
             after(grammarAccess.getImportIDAccess().getIDENTIFIERTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportID__Group_1__1__Impl"


    // $ANTLR start "rule__Input__Group__0"
    // InternalXtextTest.g:3078:1: rule__Input__Group__0 : rule__Input__Group__0__Impl rule__Input__Group__1 ;
    public final void rule__Input__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3082:1: ( rule__Input__Group__0__Impl rule__Input__Group__1 )
            // InternalXtextTest.g:3083:2: rule__Input__Group__0__Impl rule__Input__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Input__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Input__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group__0"


    // $ANTLR start "rule__Input__Group__0__Impl"
    // InternalXtextTest.g:3090:1: rule__Input__Group__0__Impl : ( () ) ;
    public final void rule__Input__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3094:1: ( ( () ) )
            // InternalXtextTest.g:3096:1: ( () )
            {
            // InternalXtextTest.g:3096:1: ( () )
            // InternalXtextTest.g:3097:1: ()
            {
             before(grammarAccess.getInputAccess().getInputAction_0()); 
            // InternalXtextTest.g:3098:1: ()
            // InternalXtextTest.g:3100:1: 
            {
            }

             after(grammarAccess.getInputAccess().getInputAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group__0__Impl"


    // $ANTLR start "rule__Input__Group__1"
    // InternalXtextTest.g:3112:1: rule__Input__Group__1 : rule__Input__Group__1__Impl rule__Input__Group__2 ;
    public final void rule__Input__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3116:1: ( rule__Input__Group__1__Impl rule__Input__Group__2 )
            // InternalXtextTest.g:3117:2: rule__Input__Group__1__Impl rule__Input__Group__2
            {
            pushFollow(FOLLOW_24);
            rule__Input__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Input__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group__1"


    // $ANTLR start "rule__Input__Group__1__Impl"
    // InternalXtextTest.g:3124:1: rule__Input__Group__1__Impl : ( RULE_SOURCE ) ;
    public final void rule__Input__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3128:1: ( ( RULE_SOURCE ) )
            // InternalXtextTest.g:3130:1: ( RULE_SOURCE )
            {
            // InternalXtextTest.g:3130:1: ( RULE_SOURCE )
            // InternalXtextTest.g:3131:1: RULE_SOURCE
            {
             before(grammarAccess.getInputAccess().getSOURCETerminalRuleCall_1()); 
            match(input,RULE_SOURCE,FOLLOW_2); 
             after(grammarAccess.getInputAccess().getSOURCETerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group__1__Impl"


    // $ANTLR start "rule__Input__Group__2"
    // InternalXtextTest.g:3144:1: rule__Input__Group__2 : rule__Input__Group__2__Impl ;
    public final void rule__Input__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3148:1: ( rule__Input__Group__2__Impl )
            // InternalXtextTest.g:3149:2: rule__Input__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Input__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group__2"


    // $ANTLR start "rule__Input__Group__2__Impl"
    // InternalXtextTest.g:3155:1: rule__Input__Group__2__Impl : ( ( rule__Input__Alternatives_2 ) ) ;
    public final void rule__Input__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3159:1: ( ( ( rule__Input__Alternatives_2 ) ) )
            // InternalXtextTest.g:3161:1: ( ( rule__Input__Alternatives_2 ) )
            {
            // InternalXtextTest.g:3161:1: ( ( rule__Input__Alternatives_2 ) )
            // InternalXtextTest.g:3162:1: ( rule__Input__Alternatives_2 )
            {
             before(grammarAccess.getInputAccess().getAlternatives_2()); 
            // InternalXtextTest.g:3163:1: ( rule__Input__Alternatives_2 )
            // InternalXtextTest.g:3163:2: rule__Input__Alternatives_2
            {
            pushFollow(FOLLOW_2);
            rule__Input__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getInputAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group__2__Impl"


    // $ANTLR start "rule__Input__Group_2_0__0"
    // InternalXtextTest.g:3181:1: rule__Input__Group_2_0__0 : rule__Input__Group_2_0__0__Impl rule__Input__Group_2_0__1 ;
    public final void rule__Input__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3185:1: ( rule__Input__Group_2_0__0__Impl rule__Input__Group_2_0__1 )
            // InternalXtextTest.g:3186:2: rule__Input__Group_2_0__0__Impl rule__Input__Group_2_0__1
            {
            pushFollow(FOLLOW_10);
            rule__Input__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Input__Group_2_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_0__0"


    // $ANTLR start "rule__Input__Group_2_0__0__Impl"
    // InternalXtextTest.g:3193:1: rule__Input__Group_2_0__0__Impl : ( RULE_SRCTEXT ) ;
    public final void rule__Input__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3197:1: ( ( RULE_SRCTEXT ) )
            // InternalXtextTest.g:3199:1: ( RULE_SRCTEXT )
            {
            // InternalXtextTest.g:3199:1: ( RULE_SRCTEXT )
            // InternalXtextTest.g:3200:1: RULE_SRCTEXT
            {
             before(grammarAccess.getInputAccess().getSRCTEXTTerminalRuleCall_2_0_0()); 
            match(input,RULE_SRCTEXT,FOLLOW_2); 
             after(grammarAccess.getInputAccess().getSRCTEXTTerminalRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_0__0__Impl"


    // $ANTLR start "rule__Input__Group_2_0__1"
    // InternalXtextTest.g:3213:1: rule__Input__Group_2_0__1 : rule__Input__Group_2_0__1__Impl rule__Input__Group_2_0__2 ;
    public final void rule__Input__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3217:1: ( rule__Input__Group_2_0__1__Impl rule__Input__Group_2_0__2 )
            // InternalXtextTest.g:3218:2: rule__Input__Group_2_0__1__Impl rule__Input__Group_2_0__2
            {
            pushFollow(FOLLOW_19);
            rule__Input__Group_2_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Input__Group_2_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_0__1"


    // $ANTLR start "rule__Input__Group_2_0__1__Impl"
    // InternalXtextTest.g:3225:1: rule__Input__Group_2_0__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Input__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3229:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:3231:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:3231:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:3232:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getInputAccess().getASSIGNASSINGLETerminalRuleCall_2_0_1()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getInputAccess().getASSIGNASSINGLETerminalRuleCall_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_0__1__Impl"


    // $ANTLR start "rule__Input__Group_2_0__2"
    // InternalXtextTest.g:3245:1: rule__Input__Group_2_0__2 : rule__Input__Group_2_0__2__Impl ;
    public final void rule__Input__Group_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3249:1: ( rule__Input__Group_2_0__2__Impl )
            // InternalXtextTest.g:3250:2: rule__Input__Group_2_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Input__Group_2_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_0__2"


    // $ANTLR start "rule__Input__Group_2_0__2__Impl"
    // InternalXtextTest.g:3256:1: rule__Input__Group_2_0__2__Impl : ( ( rule__Input__TextAssignment_2_0_2 ) ) ;
    public final void rule__Input__Group_2_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3260:1: ( ( ( rule__Input__TextAssignment_2_0_2 ) ) )
            // InternalXtextTest.g:3262:1: ( ( rule__Input__TextAssignment_2_0_2 ) )
            {
            // InternalXtextTest.g:3262:1: ( ( rule__Input__TextAssignment_2_0_2 ) )
            // InternalXtextTest.g:3263:1: ( rule__Input__TextAssignment_2_0_2 )
            {
             before(grammarAccess.getInputAccess().getTextAssignment_2_0_2()); 
            // InternalXtextTest.g:3264:1: ( rule__Input__TextAssignment_2_0_2 )
            // InternalXtextTest.g:3264:2: rule__Input__TextAssignment_2_0_2
            {
            pushFollow(FOLLOW_2);
            rule__Input__TextAssignment_2_0_2();

            state._fsp--;


            }

             after(grammarAccess.getInputAccess().getTextAssignment_2_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_0__2__Impl"


    // $ANTLR start "rule__Input__Group_2_1__0"
    // InternalXtextTest.g:3282:1: rule__Input__Group_2_1__0 : rule__Input__Group_2_1__0__Impl rule__Input__Group_2_1__1 ;
    public final void rule__Input__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3286:1: ( rule__Input__Group_2_1__0__Impl rule__Input__Group_2_1__1 )
            // InternalXtextTest.g:3287:2: rule__Input__Group_2_1__0__Impl rule__Input__Group_2_1__1
            {
            pushFollow(FOLLOW_10);
            rule__Input__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Input__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_1__0"


    // $ANTLR start "rule__Input__Group_2_1__0__Impl"
    // InternalXtextTest.g:3294:1: rule__Input__Group_2_1__0__Impl : ( RULE_FILE ) ;
    public final void rule__Input__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3298:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:3300:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:3300:1: ( RULE_FILE )
            // InternalXtextTest.g:3301:1: RULE_FILE
            {
             before(grammarAccess.getInputAccess().getFILETerminalRuleCall_2_1_0()); 
            match(input,RULE_FILE,FOLLOW_2); 
             after(grammarAccess.getInputAccess().getFILETerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_1__0__Impl"


    // $ANTLR start "rule__Input__Group_2_1__1"
    // InternalXtextTest.g:3314:1: rule__Input__Group_2_1__1 : rule__Input__Group_2_1__1__Impl rule__Input__Group_2_1__2 ;
    public final void rule__Input__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3318:1: ( rule__Input__Group_2_1__1__Impl rule__Input__Group_2_1__2 )
            // InternalXtextTest.g:3319:2: rule__Input__Group_2_1__1__Impl rule__Input__Group_2_1__2
            {
            pushFollow(FOLLOW_19);
            rule__Input__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Input__Group_2_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_1__1"


    // $ANTLR start "rule__Input__Group_2_1__1__Impl"
    // InternalXtextTest.g:3326:1: rule__Input__Group_2_1__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Input__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3330:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:3332:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:3332:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:3333:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getInputAccess().getASSIGNASSINGLETerminalRuleCall_2_1_1()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getInputAccess().getASSIGNASSINGLETerminalRuleCall_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_1__1__Impl"


    // $ANTLR start "rule__Input__Group_2_1__2"
    // InternalXtextTest.g:3346:1: rule__Input__Group_2_1__2 : rule__Input__Group_2_1__2__Impl ;
    public final void rule__Input__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3350:1: ( rule__Input__Group_2_1__2__Impl )
            // InternalXtextTest.g:3351:2: rule__Input__Group_2_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Input__Group_2_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_1__2"


    // $ANTLR start "rule__Input__Group_2_1__2__Impl"
    // InternalXtextTest.g:3357:1: rule__Input__Group_2_1__2__Impl : ( ( rule__Input__FileAssignment_2_1_2 ) ) ;
    public final void rule__Input__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3361:1: ( ( ( rule__Input__FileAssignment_2_1_2 ) ) )
            // InternalXtextTest.g:3363:1: ( ( rule__Input__FileAssignment_2_1_2 ) )
            {
            // InternalXtextTest.g:3363:1: ( ( rule__Input__FileAssignment_2_1_2 ) )
            // InternalXtextTest.g:3364:1: ( rule__Input__FileAssignment_2_1_2 )
            {
             before(grammarAccess.getInputAccess().getFileAssignment_2_1_2()); 
            // InternalXtextTest.g:3365:1: ( rule__Input__FileAssignment_2_1_2 )
            // InternalXtextTest.g:3365:2: rule__Input__FileAssignment_2_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Input__FileAssignment_2_1_2();

            state._fsp--;


            }

             after(grammarAccess.getInputAccess().getFileAssignment_2_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_1__2__Impl"


    // $ANTLR start "rule__Tokens__Group__0"
    // InternalXtextTest.g:3383:1: rule__Tokens__Group__0 : rule__Tokens__Group__0__Impl rule__Tokens__Group__1 ;
    public final void rule__Tokens__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3387:1: ( rule__Tokens__Group__0__Impl rule__Tokens__Group__1 )
            // InternalXtextTest.g:3388:2: rule__Tokens__Group__0__Impl rule__Tokens__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__Tokens__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tokens__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tokens__Group__0"


    // $ANTLR start "rule__Tokens__Group__0__Impl"
    // InternalXtextTest.g:3395:1: rule__Tokens__Group__0__Impl : ( () ) ;
    public final void rule__Tokens__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3399:1: ( ( () ) )
            // InternalXtextTest.g:3401:1: ( () )
            {
            // InternalXtextTest.g:3401:1: ( () )
            // InternalXtextTest.g:3402:1: ()
            {
             before(grammarAccess.getTokensAccess().getTokensAction_0()); 
            // InternalXtextTest.g:3403:1: ()
            // InternalXtextTest.g:3405:1: 
            {
            }

             after(grammarAccess.getTokensAccess().getTokensAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tokens__Group__0__Impl"


    // $ANTLR start "rule__Tokens__Group__1"
    // InternalXtextTest.g:3417:1: rule__Tokens__Group__1 : rule__Tokens__Group__1__Impl rule__Tokens__Group__2 ;
    public final void rule__Tokens__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3421:1: ( rule__Tokens__Group__1__Impl rule__Tokens__Group__2 )
            // InternalXtextTest.g:3422:2: rule__Tokens__Group__1__Impl rule__Tokens__Group__2
            {
            pushFollow(FOLLOW_26);
            rule__Tokens__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tokens__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tokens__Group__1"


    // $ANTLR start "rule__Tokens__Group__1__Impl"
    // InternalXtextTest.g:3429:1: rule__Tokens__Group__1__Impl : ( RULE_LEXER ) ;
    public final void rule__Tokens__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3433:1: ( ( RULE_LEXER ) )
            // InternalXtextTest.g:3435:1: ( RULE_LEXER )
            {
            // InternalXtextTest.g:3435:1: ( RULE_LEXER )
            // InternalXtextTest.g:3436:1: RULE_LEXER
            {
             before(grammarAccess.getTokensAccess().getLEXERTerminalRuleCall_1()); 
            match(input,RULE_LEXER,FOLLOW_2); 
             after(grammarAccess.getTokensAccess().getLEXERTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tokens__Group__1__Impl"


    // $ANTLR start "rule__Tokens__Group__2"
    // InternalXtextTest.g:3449:1: rule__Tokens__Group__2 : rule__Tokens__Group__2__Impl ;
    public final void rule__Tokens__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3453:1: ( rule__Tokens__Group__2__Impl )
            // InternalXtextTest.g:3454:2: rule__Tokens__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Tokens__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tokens__Group__2"


    // $ANTLR start "rule__Tokens__Group__2__Impl"
    // InternalXtextTest.g:3460:1: rule__Tokens__Group__2__Impl : ( ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* ) ) ;
    public final void rule__Tokens__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3464:1: ( ( ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* ) ) )
            // InternalXtextTest.g:3466:1: ( ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* ) )
            {
            // InternalXtextTest.g:3466:1: ( ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* ) )
            // InternalXtextTest.g:3467:1: ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* )
            {
            // InternalXtextTest.g:3467:1: ( ( rule__Tokens__TokensAssignment_2 ) )
            // InternalXtextTest.g:3468:1: ( rule__Tokens__TokensAssignment_2 )
            {
             before(grammarAccess.getTokensAccess().getTokensAssignment_2()); 
            // InternalXtextTest.g:3469:1: ( rule__Tokens__TokensAssignment_2 )
            // InternalXtextTest.g:3469:2: rule__Tokens__TokensAssignment_2
            {
            pushFollow(FOLLOW_27);
            rule__Tokens__TokensAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTokensAccess().getTokensAssignment_2()); 

            }

            // InternalXtextTest.g:3472:1: ( ( rule__Tokens__TokensAssignment_2 )* )
            // InternalXtextTest.g:3473:1: ( rule__Tokens__TokensAssignment_2 )*
            {
             before(grammarAccess.getTokensAccess().getTokensAssignment_2()); 
            // InternalXtextTest.g:3474:1: ( rule__Tokens__TokensAssignment_2 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_IDENTIFIER||LA23_0==RULE_STRING) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalXtextTest.g:3474:2: rule__Tokens__TokensAssignment_2
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__Tokens__TokensAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getTokensAccess().getTokensAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tokens__Group__2__Impl"


    // $ANTLR start "rule__MyTokens__Group__0"
    // InternalXtextTest.g:3493:1: rule__MyTokens__Group__0 : rule__MyTokens__Group__0__Impl rule__MyTokens__Group__1 ;
    public final void rule__MyTokens__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3497:1: ( rule__MyTokens__Group__0__Impl rule__MyTokens__Group__1 )
            // InternalXtextTest.g:3498:2: rule__MyTokens__Group__0__Impl rule__MyTokens__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__MyTokens__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MyTokens__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyTokens__Group__0"


    // $ANTLR start "rule__MyTokens__Group__0__Impl"
    // InternalXtextTest.g:3505:1: rule__MyTokens__Group__0__Impl : ( ( rule__MyTokens__Alternatives_0 ) ) ;
    public final void rule__MyTokens__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3509:1: ( ( ( rule__MyTokens__Alternatives_0 ) ) )
            // InternalXtextTest.g:3511:1: ( ( rule__MyTokens__Alternatives_0 ) )
            {
            // InternalXtextTest.g:3511:1: ( ( rule__MyTokens__Alternatives_0 ) )
            // InternalXtextTest.g:3512:1: ( rule__MyTokens__Alternatives_0 )
            {
             before(grammarAccess.getMyTokensAccess().getAlternatives_0()); 
            // InternalXtextTest.g:3513:1: ( rule__MyTokens__Alternatives_0 )
            // InternalXtextTest.g:3513:2: rule__MyTokens__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__MyTokens__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getMyTokensAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyTokens__Group__0__Impl"


    // $ANTLR start "rule__MyTokens__Group__1"
    // InternalXtextTest.g:3525:1: rule__MyTokens__Group__1 : rule__MyTokens__Group__1__Impl ;
    public final void rule__MyTokens__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3529:1: ( rule__MyTokens__Group__1__Impl )
            // InternalXtextTest.g:3530:2: rule__MyTokens__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MyTokens__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyTokens__Group__1"


    // $ANTLR start "rule__MyTokens__Group__1__Impl"
    // InternalXtextTest.g:3536:1: rule__MyTokens__Group__1__Impl : ( ( rule__MyTokens__Group_1__0 )? ) ;
    public final void rule__MyTokens__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3540:1: ( ( ( rule__MyTokens__Group_1__0 )? ) )
            // InternalXtextTest.g:3542:1: ( ( rule__MyTokens__Group_1__0 )? )
            {
            // InternalXtextTest.g:3542:1: ( ( rule__MyTokens__Group_1__0 )? )
            // InternalXtextTest.g:3543:1: ( rule__MyTokens__Group_1__0 )?
            {
             before(grammarAccess.getMyTokensAccess().getGroup_1()); 
            // InternalXtextTest.g:3544:1: ( rule__MyTokens__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ASSIGNASDATALIST) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalXtextTest.g:3544:2: rule__MyTokens__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MyTokens__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMyTokensAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyTokens__Group__1__Impl"


    // $ANTLR start "rule__MyTokens__Group_1__0"
    // InternalXtextTest.g:3560:1: rule__MyTokens__Group_1__0 : rule__MyTokens__Group_1__0__Impl rule__MyTokens__Group_1__1 ;
    public final void rule__MyTokens__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3564:1: ( rule__MyTokens__Group_1__0__Impl rule__MyTokens__Group_1__1 )
            // InternalXtextTest.g:3565:2: rule__MyTokens__Group_1__0__Impl rule__MyTokens__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__MyTokens__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MyTokens__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyTokens__Group_1__0"


    // $ANTLR start "rule__MyTokens__Group_1__0__Impl"
    // InternalXtextTest.g:3572:1: rule__MyTokens__Group_1__0__Impl : ( RULE_ASSIGNASDATALIST ) ;
    public final void rule__MyTokens__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3576:1: ( ( RULE_ASSIGNASDATALIST ) )
            // InternalXtextTest.g:3578:1: ( RULE_ASSIGNASDATALIST )
            {
            // InternalXtextTest.g:3578:1: ( RULE_ASSIGNASDATALIST )
            // InternalXtextTest.g:3579:1: RULE_ASSIGNASDATALIST
            {
             before(grammarAccess.getMyTokensAccess().getASSIGNASDATALISTTerminalRuleCall_1_0()); 
            match(input,RULE_ASSIGNASDATALIST,FOLLOW_2); 
             after(grammarAccess.getMyTokensAccess().getASSIGNASDATALISTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyTokens__Group_1__0__Impl"


    // $ANTLR start "rule__MyTokens__Group_1__1"
    // InternalXtextTest.g:3592:1: rule__MyTokens__Group_1__1 : rule__MyTokens__Group_1__1__Impl ;
    public final void rule__MyTokens__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3596:1: ( rule__MyTokens__Group_1__1__Impl )
            // InternalXtextTest.g:3597:2: rule__MyTokens__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MyTokens__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyTokens__Group_1__1"


    // $ANTLR start "rule__MyTokens__Group_1__1__Impl"
    // InternalXtextTest.g:3603:1: rule__MyTokens__Group_1__1__Impl : ( ( rule__MyTokens__CountAssignment_1_1 ) ) ;
    public final void rule__MyTokens__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3607:1: ( ( ( rule__MyTokens__CountAssignment_1_1 ) ) )
            // InternalXtextTest.g:3609:1: ( ( rule__MyTokens__CountAssignment_1_1 ) )
            {
            // InternalXtextTest.g:3609:1: ( ( rule__MyTokens__CountAssignment_1_1 ) )
            // InternalXtextTest.g:3610:1: ( rule__MyTokens__CountAssignment_1_1 )
            {
             before(grammarAccess.getMyTokensAccess().getCountAssignment_1_1()); 
            // InternalXtextTest.g:3611:1: ( rule__MyTokens__CountAssignment_1_1 )
            // InternalXtextTest.g:3611:2: rule__MyTokens__CountAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MyTokens__CountAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMyTokensAccess().getCountAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyTokens__Group_1__1__Impl"


    // $ANTLR start "rule__Element__Group__0"
    // InternalXtextTest.g:3627:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3631:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalXtextTest.g:3632:2: rule__Element__Group__0__Impl rule__Element__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__Element__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__0"


    // $ANTLR start "rule__Element__Group__0__Impl"
    // InternalXtextTest.g:3639:1: rule__Element__Group__0__Impl : ( () ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3643:1: ( ( () ) )
            // InternalXtextTest.g:3645:1: ( () )
            {
            // InternalXtextTest.g:3645:1: ( () )
            // InternalXtextTest.g:3646:1: ()
            {
             before(grammarAccess.getElementAccess().getElementAction_0()); 
            // InternalXtextTest.g:3647:1: ()
            // InternalXtextTest.g:3649:1: 
            {
            }

             after(grammarAccess.getElementAccess().getElementAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__0__Impl"


    // $ANTLR start "rule__Element__Group__1"
    // InternalXtextTest.g:3661:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3665:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // InternalXtextTest.g:3666:2: rule__Element__Group__1__Impl rule__Element__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Element__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__1"


    // $ANTLR start "rule__Element__Group__1__Impl"
    // InternalXtextTest.g:3673:1: rule__Element__Group__1__Impl : ( RULE_LEFTPAREN ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3677:1: ( ( RULE_LEFTPAREN ) )
            // InternalXtextTest.g:3679:1: ( RULE_LEFTPAREN )
            {
            // InternalXtextTest.g:3679:1: ( RULE_LEFTPAREN )
            // InternalXtextTest.g:3680:1: RULE_LEFTPAREN
            {
             before(grammarAccess.getElementAccess().getLEFTPARENTerminalRuleCall_1()); 
            match(input,RULE_LEFTPAREN,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getLEFTPARENTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__1__Impl"


    // $ANTLR start "rule__Element__Group__2"
    // InternalXtextTest.g:3693:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3697:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // InternalXtextTest.g:3698:2: rule__Element__Group__2__Impl rule__Element__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Element__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__2"


    // $ANTLR start "rule__Element__Group__2__Impl"
    // InternalXtextTest.g:3705:1: rule__Element__Group__2__Impl : ( ( rule__Element__Group_2__0 )? ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3709:1: ( ( ( rule__Element__Group_2__0 )? ) )
            // InternalXtextTest.g:3711:1: ( ( rule__Element__Group_2__0 )? )
            {
            // InternalXtextTest.g:3711:1: ( ( rule__Element__Group_2__0 )? )
            // InternalXtextTest.g:3712:1: ( rule__Element__Group_2__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_2()); 
            // InternalXtextTest.g:3713:1: ( rule__Element__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_IDENTIFIER) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==RULE_IMPORTER) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // InternalXtextTest.g:3713:2: rule__Element__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Element__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__2__Impl"


    // $ANTLR start "rule__Element__Group__3"
    // InternalXtextTest.g:3725:1: rule__Element__Group__3 : rule__Element__Group__3__Impl rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3729:1: ( rule__Element__Group__3__Impl rule__Element__Group__4 )
            // InternalXtextTest.g:3730:2: rule__Element__Group__3__Impl rule__Element__Group__4
            {
            pushFollow(FOLLOW_29);
            rule__Element__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__3"


    // $ANTLR start "rule__Element__Group__3__Impl"
    // InternalXtextTest.g:3737:1: rule__Element__Group__3__Impl : ( ( rule__Element__NameAssignment_3 ) ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3741:1: ( ( ( rule__Element__NameAssignment_3 ) ) )
            // InternalXtextTest.g:3743:1: ( ( rule__Element__NameAssignment_3 ) )
            {
            // InternalXtextTest.g:3743:1: ( ( rule__Element__NameAssignment_3 ) )
            // InternalXtextTest.g:3744:1: ( rule__Element__NameAssignment_3 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_3()); 
            // InternalXtextTest.g:3745:1: ( rule__Element__NameAssignment_3 )
            // InternalXtextTest.g:3745:2: rule__Element__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Element__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__3__Impl"


    // $ANTLR start "rule__Element__Group__4"
    // InternalXtextTest.g:3757:1: rule__Element__Group__4 : rule__Element__Group__4__Impl rule__Element__Group__5 ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3761:1: ( rule__Element__Group__4__Impl rule__Element__Group__5 )
            // InternalXtextTest.g:3762:2: rule__Element__Group__4__Impl rule__Element__Group__5
            {
            pushFollow(FOLLOW_29);
            rule__Element__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__4"


    // $ANTLR start "rule__Element__Group__4__Impl"
    // InternalXtextTest.g:3769:1: rule__Element__Group__4__Impl : ( ( rule__Element__Group_4__0 )? ) ;
    public final void rule__Element__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3773:1: ( ( ( rule__Element__Group_4__0 )? ) )
            // InternalXtextTest.g:3775:1: ( ( rule__Element__Group_4__0 )? )
            {
            // InternalXtextTest.g:3775:1: ( ( rule__Element__Group_4__0 )? )
            // InternalXtextTest.g:3776:1: ( rule__Element__Group_4__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_4()); 
            // InternalXtextTest.g:3777:1: ( rule__Element__Group_4__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_IDENTIFIER) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalXtextTest.g:3777:2: rule__Element__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Element__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__4__Impl"


    // $ANTLR start "rule__Element__Group__5"
    // InternalXtextTest.g:3789:1: rule__Element__Group__5 : rule__Element__Group__5__Impl ;
    public final void rule__Element__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3793:1: ( rule__Element__Group__5__Impl )
            // InternalXtextTest.g:3794:2: rule__Element__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__5"


    // $ANTLR start "rule__Element__Group__5__Impl"
    // InternalXtextTest.g:3800:1: rule__Element__Group__5__Impl : ( RULE_RIGHTPAREN ) ;
    public final void rule__Element__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3804:1: ( ( RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:3806:1: ( RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:3806:1: ( RULE_RIGHTPAREN )
            // InternalXtextTest.g:3807:1: RULE_RIGHTPAREN
            {
             before(grammarAccess.getElementAccess().getRIGHTPARENTerminalRuleCall_5()); 
            match(input,RULE_RIGHTPAREN,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getRIGHTPARENTerminalRuleCall_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__5__Impl"


    // $ANTLR start "rule__Element__Group_2__0"
    // InternalXtextTest.g:3832:1: rule__Element__Group_2__0 : rule__Element__Group_2__0__Impl rule__Element__Group_2__1 ;
    public final void rule__Element__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3836:1: ( rule__Element__Group_2__0__Impl rule__Element__Group_2__1 )
            // InternalXtextTest.g:3837:2: rule__Element__Group_2__0__Impl rule__Element__Group_2__1
            {
            pushFollow(FOLLOW_30);
            rule__Element__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_2__0"


    // $ANTLR start "rule__Element__Group_2__0__Impl"
    // InternalXtextTest.g:3844:1: rule__Element__Group_2__0__Impl : ( ( rule__Element__ImportingAssignment_2_0 ) ) ;
    public final void rule__Element__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3848:1: ( ( ( rule__Element__ImportingAssignment_2_0 ) ) )
            // InternalXtextTest.g:3850:1: ( ( rule__Element__ImportingAssignment_2_0 ) )
            {
            // InternalXtextTest.g:3850:1: ( ( rule__Element__ImportingAssignment_2_0 ) )
            // InternalXtextTest.g:3851:1: ( rule__Element__ImportingAssignment_2_0 )
            {
             before(grammarAccess.getElementAccess().getImportingAssignment_2_0()); 
            // InternalXtextTest.g:3852:1: ( rule__Element__ImportingAssignment_2_0 )
            // InternalXtextTest.g:3852:2: rule__Element__ImportingAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Element__ImportingAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getImportingAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_2__0__Impl"


    // $ANTLR start "rule__Element__Group_2__1"
    // InternalXtextTest.g:3864:1: rule__Element__Group_2__1 : rule__Element__Group_2__1__Impl ;
    public final void rule__Element__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3868:1: ( rule__Element__Group_2__1__Impl )
            // InternalXtextTest.g:3869:2: rule__Element__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_2__1"


    // $ANTLR start "rule__Element__Group_2__1__Impl"
    // InternalXtextTest.g:3875:1: rule__Element__Group_2__1__Impl : ( RULE_IMPORTER ) ;
    public final void rule__Element__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3879:1: ( ( RULE_IMPORTER ) )
            // InternalXtextTest.g:3881:1: ( RULE_IMPORTER )
            {
            // InternalXtextTest.g:3881:1: ( RULE_IMPORTER )
            // InternalXtextTest.g:3882:1: RULE_IMPORTER
            {
             before(grammarAccess.getElementAccess().getIMPORTERTerminalRuleCall_2_1()); 
            match(input,RULE_IMPORTER,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getIMPORTERTerminalRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_2__1__Impl"


    // $ANTLR start "rule__Element__Group_4__0"
    // InternalXtextTest.g:3899:1: rule__Element__Group_4__0 : rule__Element__Group_4__0__Impl rule__Element__Group_4__1 ;
    public final void rule__Element__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3903:1: ( rule__Element__Group_4__0__Impl rule__Element__Group_4__1 )
            // InternalXtextTest.g:3904:2: rule__Element__Group_4__0__Impl rule__Element__Group_4__1
            {
            pushFollow(FOLLOW_31);
            rule__Element__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4__0"


    // $ANTLR start "rule__Element__Group_4__0__Impl"
    // InternalXtextTest.g:3911:1: rule__Element__Group_4__0__Impl : ( ( rule__Element__InnerAssignment_4_0 ) ) ;
    public final void rule__Element__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3915:1: ( ( ( rule__Element__InnerAssignment_4_0 ) ) )
            // InternalXtextTest.g:3917:1: ( ( rule__Element__InnerAssignment_4_0 ) )
            {
            // InternalXtextTest.g:3917:1: ( ( rule__Element__InnerAssignment_4_0 ) )
            // InternalXtextTest.g:3918:1: ( rule__Element__InnerAssignment_4_0 )
            {
             before(grammarAccess.getElementAccess().getInnerAssignment_4_0()); 
            // InternalXtextTest.g:3919:1: ( rule__Element__InnerAssignment_4_0 )
            // InternalXtextTest.g:3919:2: rule__Element__InnerAssignment_4_0
            {
            pushFollow(FOLLOW_2);
            rule__Element__InnerAssignment_4_0();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getInnerAssignment_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4__0__Impl"


    // $ANTLR start "rule__Element__Group_4__1"
    // InternalXtextTest.g:3931:1: rule__Element__Group_4__1 : rule__Element__Group_4__1__Impl ;
    public final void rule__Element__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3935:1: ( rule__Element__Group_4__1__Impl )
            // InternalXtextTest.g:3936:2: rule__Element__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4__1"


    // $ANTLR start "rule__Element__Group_4__1__Impl"
    // InternalXtextTest.g:3942:1: rule__Element__Group_4__1__Impl : ( ( rule__Element__Group_4_1__0 )* ) ;
    public final void rule__Element__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3946:1: ( ( ( rule__Element__Group_4_1__0 )* ) )
            // InternalXtextTest.g:3948:1: ( ( rule__Element__Group_4_1__0 )* )
            {
            // InternalXtextTest.g:3948:1: ( ( rule__Element__Group_4_1__0 )* )
            // InternalXtextTest.g:3949:1: ( rule__Element__Group_4_1__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_4_1()); 
            // InternalXtextTest.g:3950:1: ( rule__Element__Group_4_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_COMMA) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalXtextTest.g:3950:2: rule__Element__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__Element__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getGroup_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4__1__Impl"


    // $ANTLR start "rule__Element__Group_4_1__0"
    // InternalXtextTest.g:3966:1: rule__Element__Group_4_1__0 : rule__Element__Group_4_1__0__Impl rule__Element__Group_4_1__1 ;
    public final void rule__Element__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3970:1: ( rule__Element__Group_4_1__0__Impl rule__Element__Group_4_1__1 )
            // InternalXtextTest.g:3971:2: rule__Element__Group_4_1__0__Impl rule__Element__Group_4_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Element__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4_1__0"


    // $ANTLR start "rule__Element__Group_4_1__0__Impl"
    // InternalXtextTest.g:3978:1: rule__Element__Group_4_1__0__Impl : ( RULE_COMMA ) ;
    public final void rule__Element__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3982:1: ( ( RULE_COMMA ) )
            // InternalXtextTest.g:3984:1: ( RULE_COMMA )
            {
            // InternalXtextTest.g:3984:1: ( RULE_COMMA )
            // InternalXtextTest.g:3985:1: RULE_COMMA
            {
             before(grammarAccess.getElementAccess().getCOMMATerminalRuleCall_4_1_0()); 
            match(input,RULE_COMMA,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getCOMMATerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4_1__0__Impl"


    // $ANTLR start "rule__Element__Group_4_1__1"
    // InternalXtextTest.g:3998:1: rule__Element__Group_4_1__1 : rule__Element__Group_4_1__1__Impl ;
    public final void rule__Element__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4002:1: ( rule__Element__Group_4_1__1__Impl )
            // InternalXtextTest.g:4003:2: rule__Element__Group_4_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group_4_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4_1__1"


    // $ANTLR start "rule__Element__Group_4_1__1__Impl"
    // InternalXtextTest.g:4009:1: rule__Element__Group_4_1__1__Impl : ( ( rule__Element__InnerAssignment_4_1_1 ) ) ;
    public final void rule__Element__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4013:1: ( ( ( rule__Element__InnerAssignment_4_1_1 ) ) )
            // InternalXtextTest.g:4015:1: ( ( rule__Element__InnerAssignment_4_1_1 ) )
            {
            // InternalXtextTest.g:4015:1: ( ( rule__Element__InnerAssignment_4_1_1 ) )
            // InternalXtextTest.g:4016:1: ( rule__Element__InnerAssignment_4_1_1 )
            {
             before(grammarAccess.getElementAccess().getInnerAssignment_4_1_1()); 
            // InternalXtextTest.g:4017:1: ( rule__Element__InnerAssignment_4_1_1 )
            // InternalXtextTest.g:4017:2: rule__Element__InnerAssignment_4_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Element__InnerAssignment_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getInnerAssignment_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4_1__1__Impl"


    // $ANTLR start "rule__Inner__Group__0"
    // InternalXtextTest.g:4033:1: rule__Inner__Group__0 : rule__Inner__Group__0__Impl rule__Inner__Group__1 ;
    public final void rule__Inner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4037:1: ( rule__Inner__Group__0__Impl rule__Inner__Group__1 )
            // InternalXtextTest.g:4038:2: rule__Inner__Group__0__Impl rule__Inner__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Inner__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Inner__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group__0"


    // $ANTLR start "rule__Inner__Group__0__Impl"
    // InternalXtextTest.g:4045:1: rule__Inner__Group__0__Impl : ( () ) ;
    public final void rule__Inner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4049:1: ( ( () ) )
            // InternalXtextTest.g:4051:1: ( () )
            {
            // InternalXtextTest.g:4051:1: ( () )
            // InternalXtextTest.g:4052:1: ()
            {
             before(grammarAccess.getInnerAccess().getInnerAction_0()); 
            // InternalXtextTest.g:4053:1: ()
            // InternalXtextTest.g:4055:1: 
            {
            }

             after(grammarAccess.getInnerAccess().getInnerAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group__0__Impl"


    // $ANTLR start "rule__Inner__Group__1"
    // InternalXtextTest.g:4067:1: rule__Inner__Group__1 : rule__Inner__Group__1__Impl rule__Inner__Group__2 ;
    public final void rule__Inner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4071:1: ( rule__Inner__Group__1__Impl rule__Inner__Group__2 )
            // InternalXtextTest.g:4072:2: rule__Inner__Group__1__Impl rule__Inner__Group__2
            {
            pushFollow(FOLLOW_33);
            rule__Inner__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Inner__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group__1"


    // $ANTLR start "rule__Inner__Group__1__Impl"
    // InternalXtextTest.g:4079:1: rule__Inner__Group__1__Impl : ( ( rule__Inner__ParameterAssignment_1 ) ) ;
    public final void rule__Inner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4083:1: ( ( ( rule__Inner__ParameterAssignment_1 ) ) )
            // InternalXtextTest.g:4085:1: ( ( rule__Inner__ParameterAssignment_1 ) )
            {
            // InternalXtextTest.g:4085:1: ( ( rule__Inner__ParameterAssignment_1 ) )
            // InternalXtextTest.g:4086:1: ( rule__Inner__ParameterAssignment_1 )
            {
             before(grammarAccess.getInnerAccess().getParameterAssignment_1()); 
            // InternalXtextTest.g:4087:1: ( rule__Inner__ParameterAssignment_1 )
            // InternalXtextTest.g:4087:2: rule__Inner__ParameterAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Inner__ParameterAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getInnerAccess().getParameterAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group__1__Impl"


    // $ANTLR start "rule__Inner__Group__2"
    // InternalXtextTest.g:4099:1: rule__Inner__Group__2 : rule__Inner__Group__2__Impl ;
    public final void rule__Inner__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4103:1: ( rule__Inner__Group__2__Impl )
            // InternalXtextTest.g:4104:2: rule__Inner__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Inner__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group__2"


    // $ANTLR start "rule__Inner__Group__2__Impl"
    // InternalXtextTest.g:4110:1: rule__Inner__Group__2__Impl : ( ( rule__Inner__Alternatives_2 ) ) ;
    public final void rule__Inner__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4114:1: ( ( ( rule__Inner__Alternatives_2 ) ) )
            // InternalXtextTest.g:4116:1: ( ( rule__Inner__Alternatives_2 ) )
            {
            // InternalXtextTest.g:4116:1: ( ( rule__Inner__Alternatives_2 ) )
            // InternalXtextTest.g:4117:1: ( rule__Inner__Alternatives_2 )
            {
             before(grammarAccess.getInnerAccess().getAlternatives_2()); 
            // InternalXtextTest.g:4118:1: ( rule__Inner__Alternatives_2 )
            // InternalXtextTest.g:4118:2: rule__Inner__Alternatives_2
            {
            pushFollow(FOLLOW_2);
            rule__Inner__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getInnerAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group__2__Impl"


    // $ANTLR start "rule__Inner__Group_2_0__0"
    // InternalXtextTest.g:4136:1: rule__Inner__Group_2_0__0 : rule__Inner__Group_2_0__0__Impl rule__Inner__Group_2_0__1 ;
    public final void rule__Inner__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4140:1: ( rule__Inner__Group_2_0__0__Impl rule__Inner__Group_2_0__1 )
            // InternalXtextTest.g:4141:2: rule__Inner__Group_2_0__0__Impl rule__Inner__Group_2_0__1
            {
            pushFollow(FOLLOW_8);
            rule__Inner__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Inner__Group_2_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_0__0"


    // $ANTLR start "rule__Inner__Group_2_0__0__Impl"
    // InternalXtextTest.g:4148:1: rule__Inner__Group_2_0__0__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Inner__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4152:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:4154:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:4154:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:4155:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getInnerAccess().getASSIGNASSINGLETerminalRuleCall_2_0_0()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getInnerAccess().getASSIGNASSINGLETerminalRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_0__0__Impl"


    // $ANTLR start "rule__Inner__Group_2_0__1"
    // InternalXtextTest.g:4168:1: rule__Inner__Group_2_0__1 : rule__Inner__Group_2_0__1__Impl ;
    public final void rule__Inner__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4172:1: ( rule__Inner__Group_2_0__1__Impl )
            // InternalXtextTest.g:4173:2: rule__Inner__Group_2_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Inner__Group_2_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_0__1"


    // $ANTLR start "rule__Inner__Group_2_0__1__Impl"
    // InternalXtextTest.g:4179:1: rule__Inner__Group_2_0__1__Impl : ( ( rule__Inner__AssignAssignment_2_0_1 ) ) ;
    public final void rule__Inner__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4183:1: ( ( ( rule__Inner__AssignAssignment_2_0_1 ) ) )
            // InternalXtextTest.g:4185:1: ( ( rule__Inner__AssignAssignment_2_0_1 ) )
            {
            // InternalXtextTest.g:4185:1: ( ( rule__Inner__AssignAssignment_2_0_1 ) )
            // InternalXtextTest.g:4186:1: ( rule__Inner__AssignAssignment_2_0_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignAssignment_2_0_1()); 
            // InternalXtextTest.g:4187:1: ( rule__Inner__AssignAssignment_2_0_1 )
            // InternalXtextTest.g:4187:2: rule__Inner__AssignAssignment_2_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Inner__AssignAssignment_2_0_1();

            state._fsp--;


            }

             after(grammarAccess.getInnerAccess().getAssignAssignment_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_0__1__Impl"


    // $ANTLR start "rule__Inner__Group_2_1__0"
    // InternalXtextTest.g:4203:1: rule__Inner__Group_2_1__0 : rule__Inner__Group_2_1__0__Impl rule__Inner__Group_2_1__1 ;
    public final void rule__Inner__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4207:1: ( rule__Inner__Group_2_1__0__Impl rule__Inner__Group_2_1__1 )
            // InternalXtextTest.g:4208:2: rule__Inner__Group_2_1__0__Impl rule__Inner__Group_2_1__1
            {
            pushFollow(FOLLOW_8);
            rule__Inner__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Inner__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_1__0"


    // $ANTLR start "rule__Inner__Group_2_1__0__Impl"
    // InternalXtextTest.g:4215:1: rule__Inner__Group_2_1__0__Impl : ( RULE_ASSIGNASLIST ) ;
    public final void rule__Inner__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4219:1: ( ( RULE_ASSIGNASLIST ) )
            // InternalXtextTest.g:4221:1: ( RULE_ASSIGNASLIST )
            {
            // InternalXtextTest.g:4221:1: ( RULE_ASSIGNASLIST )
            // InternalXtextTest.g:4222:1: RULE_ASSIGNASLIST
            {
             before(grammarAccess.getInnerAccess().getASSIGNASLISTTerminalRuleCall_2_1_0()); 
            match(input,RULE_ASSIGNASLIST,FOLLOW_2); 
             after(grammarAccess.getInnerAccess().getASSIGNASLISTTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_1__0__Impl"


    // $ANTLR start "rule__Inner__Group_2_1__1"
    // InternalXtextTest.g:4235:1: rule__Inner__Group_2_1__1 : rule__Inner__Group_2_1__1__Impl rule__Inner__Group_2_1__2 ;
    public final void rule__Inner__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4239:1: ( rule__Inner__Group_2_1__1__Impl rule__Inner__Group_2_1__2 )
            // InternalXtextTest.g:4240:2: rule__Inner__Group_2_1__1__Impl rule__Inner__Group_2_1__2
            {
            pushFollow(FOLLOW_31);
            rule__Inner__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Inner__Group_2_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_1__1"


    // $ANTLR start "rule__Inner__Group_2_1__1__Impl"
    // InternalXtextTest.g:4247:1: rule__Inner__Group_2_1__1__Impl : ( ( rule__Inner__AssignListAssignment_2_1_1 ) ) ;
    public final void rule__Inner__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4251:1: ( ( ( rule__Inner__AssignListAssignment_2_1_1 ) ) )
            // InternalXtextTest.g:4253:1: ( ( rule__Inner__AssignListAssignment_2_1_1 ) )
            {
            // InternalXtextTest.g:4253:1: ( ( rule__Inner__AssignListAssignment_2_1_1 ) )
            // InternalXtextTest.g:4254:1: ( rule__Inner__AssignListAssignment_2_1_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignListAssignment_2_1_1()); 
            // InternalXtextTest.g:4255:1: ( rule__Inner__AssignListAssignment_2_1_1 )
            // InternalXtextTest.g:4255:2: rule__Inner__AssignListAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Inner__AssignListAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getInnerAccess().getAssignListAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_1__1__Impl"


    // $ANTLR start "rule__Inner__Group_2_1__2"
    // InternalXtextTest.g:4267:1: rule__Inner__Group_2_1__2 : rule__Inner__Group_2_1__2__Impl ;
    public final void rule__Inner__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4271:1: ( rule__Inner__Group_2_1__2__Impl )
            // InternalXtextTest.g:4272:2: rule__Inner__Group_2_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Inner__Group_2_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_1__2"


    // $ANTLR start "rule__Inner__Group_2_1__2__Impl"
    // InternalXtextTest.g:4278:1: rule__Inner__Group_2_1__2__Impl : ( ( rule__Inner__Group_2_1_2__0 )* ) ;
    public final void rule__Inner__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4282:1: ( ( ( rule__Inner__Group_2_1_2__0 )* ) )
            // InternalXtextTest.g:4284:1: ( ( rule__Inner__Group_2_1_2__0 )* )
            {
            // InternalXtextTest.g:4284:1: ( ( rule__Inner__Group_2_1_2__0 )* )
            // InternalXtextTest.g:4285:1: ( rule__Inner__Group_2_1_2__0 )*
            {
             before(grammarAccess.getInnerAccess().getGroup_2_1_2()); 
            // InternalXtextTest.g:4286:1: ( rule__Inner__Group_2_1_2__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_COMMA) ) {
                    int LA28_2 = input.LA(2);

                    if ( (LA28_2==RULE_LEFTPAREN) ) {
                        alt28=1;
                    }


                }


                switch (alt28) {
            	case 1 :
            	    // InternalXtextTest.g:4286:2: rule__Inner__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__Inner__Group_2_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getInnerAccess().getGroup_2_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_1__2__Impl"


    // $ANTLR start "rule__Inner__Group_2_1_2__0"
    // InternalXtextTest.g:4304:1: rule__Inner__Group_2_1_2__0 : rule__Inner__Group_2_1_2__0__Impl rule__Inner__Group_2_1_2__1 ;
    public final void rule__Inner__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4308:1: ( rule__Inner__Group_2_1_2__0__Impl rule__Inner__Group_2_1_2__1 )
            // InternalXtextTest.g:4309:2: rule__Inner__Group_2_1_2__0__Impl rule__Inner__Group_2_1_2__1
            {
            pushFollow(FOLLOW_8);
            rule__Inner__Group_2_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Inner__Group_2_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_1_2__0"


    // $ANTLR start "rule__Inner__Group_2_1_2__0__Impl"
    // InternalXtextTest.g:4316:1: rule__Inner__Group_2_1_2__0__Impl : ( RULE_COMMA ) ;
    public final void rule__Inner__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4320:1: ( ( RULE_COMMA ) )
            // InternalXtextTest.g:4322:1: ( RULE_COMMA )
            {
            // InternalXtextTest.g:4322:1: ( RULE_COMMA )
            // InternalXtextTest.g:4323:1: RULE_COMMA
            {
             before(grammarAccess.getInnerAccess().getCOMMATerminalRuleCall_2_1_2_0()); 
            match(input,RULE_COMMA,FOLLOW_2); 
             after(grammarAccess.getInnerAccess().getCOMMATerminalRuleCall_2_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_1_2__0__Impl"


    // $ANTLR start "rule__Inner__Group_2_1_2__1"
    // InternalXtextTest.g:4336:1: rule__Inner__Group_2_1_2__1 : rule__Inner__Group_2_1_2__1__Impl ;
    public final void rule__Inner__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4340:1: ( rule__Inner__Group_2_1_2__1__Impl )
            // InternalXtextTest.g:4341:2: rule__Inner__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Inner__Group_2_1_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_1_2__1"


    // $ANTLR start "rule__Inner__Group_2_1_2__1__Impl"
    // InternalXtextTest.g:4347:1: rule__Inner__Group_2_1_2__1__Impl : ( ( rule__Inner__AssignListAssignment_2_1_2_1 ) ) ;
    public final void rule__Inner__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4351:1: ( ( ( rule__Inner__AssignListAssignment_2_1_2_1 ) ) )
            // InternalXtextTest.g:4353:1: ( ( rule__Inner__AssignListAssignment_2_1_2_1 ) )
            {
            // InternalXtextTest.g:4353:1: ( ( rule__Inner__AssignListAssignment_2_1_2_1 ) )
            // InternalXtextTest.g:4354:1: ( rule__Inner__AssignListAssignment_2_1_2_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignListAssignment_2_1_2_1()); 
            // InternalXtextTest.g:4355:1: ( rule__Inner__AssignListAssignment_2_1_2_1 )
            // InternalXtextTest.g:4355:2: rule__Inner__AssignListAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Inner__AssignListAssignment_2_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getInnerAccess().getAssignListAssignment_2_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_1_2__1__Impl"


    // $ANTLR start "rule__Inner__Group_2_2__0"
    // InternalXtextTest.g:4371:1: rule__Inner__Group_2_2__0 : rule__Inner__Group_2_2__0__Impl rule__Inner__Group_2_2__1 ;
    public final void rule__Inner__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4375:1: ( rule__Inner__Group_2_2__0__Impl rule__Inner__Group_2_2__1 )
            // InternalXtextTest.g:4376:2: rule__Inner__Group_2_2__0__Impl rule__Inner__Group_2_2__1
            {
            pushFollow(FOLLOW_19);
            rule__Inner__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Inner__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_2__0"


    // $ANTLR start "rule__Inner__Group_2_2__0__Impl"
    // InternalXtextTest.g:4383:1: rule__Inner__Group_2_2__0__Impl : ( RULE_ASSIGNASSTRING ) ;
    public final void rule__Inner__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4387:1: ( ( RULE_ASSIGNASSTRING ) )
            // InternalXtextTest.g:4389:1: ( RULE_ASSIGNASSTRING )
            {
            // InternalXtextTest.g:4389:1: ( RULE_ASSIGNASSTRING )
            // InternalXtextTest.g:4390:1: RULE_ASSIGNASSTRING
            {
             before(grammarAccess.getInnerAccess().getASSIGNASSTRINGTerminalRuleCall_2_2_0()); 
            match(input,RULE_ASSIGNASSTRING,FOLLOW_2); 
             after(grammarAccess.getInnerAccess().getASSIGNASSTRINGTerminalRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_2__0__Impl"


    // $ANTLR start "rule__Inner__Group_2_2__1"
    // InternalXtextTest.g:4403:1: rule__Inner__Group_2_2__1 : rule__Inner__Group_2_2__1__Impl ;
    public final void rule__Inner__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4407:1: ( rule__Inner__Group_2_2__1__Impl )
            // InternalXtextTest.g:4408:2: rule__Inner__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Inner__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_2__1"


    // $ANTLR start "rule__Inner__Group_2_2__1__Impl"
    // InternalXtextTest.g:4414:1: rule__Inner__Group_2_2__1__Impl : ( ( rule__Inner__ValueAssignment_2_2_1 ) ) ;
    public final void rule__Inner__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4418:1: ( ( ( rule__Inner__ValueAssignment_2_2_1 ) ) )
            // InternalXtextTest.g:4420:1: ( ( rule__Inner__ValueAssignment_2_2_1 ) )
            {
            // InternalXtextTest.g:4420:1: ( ( rule__Inner__ValueAssignment_2_2_1 ) )
            // InternalXtextTest.g:4421:1: ( rule__Inner__ValueAssignment_2_2_1 )
            {
             before(grammarAccess.getInnerAccess().getValueAssignment_2_2_1()); 
            // InternalXtextTest.g:4422:1: ( rule__Inner__ValueAssignment_2_2_1 )
            // InternalXtextTest.g:4422:2: rule__Inner__ValueAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Inner__ValueAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getInnerAccess().getValueAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_2__1__Impl"


    // $ANTLR start "rule__Inner__Group_2_3__0"
    // InternalXtextTest.g:4438:1: rule__Inner__Group_2_3__0 : rule__Inner__Group_2_3__0__Impl rule__Inner__Group_2_3__1 ;
    public final void rule__Inner__Group_2_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4442:1: ( rule__Inner__Group_2_3__0__Impl rule__Inner__Group_2_3__1 )
            // InternalXtextTest.g:4443:2: rule__Inner__Group_2_3__0__Impl rule__Inner__Group_2_3__1
            {
            pushFollow(FOLLOW_19);
            rule__Inner__Group_2_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Inner__Group_2_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_3__0"


    // $ANTLR start "rule__Inner__Group_2_3__0__Impl"
    // InternalXtextTest.g:4450:1: rule__Inner__Group_2_3__0__Impl : ( RULE_ASSIGNASDATALIST ) ;
    public final void rule__Inner__Group_2_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4454:1: ( ( RULE_ASSIGNASDATALIST ) )
            // InternalXtextTest.g:4456:1: ( RULE_ASSIGNASDATALIST )
            {
            // InternalXtextTest.g:4456:1: ( RULE_ASSIGNASDATALIST )
            // InternalXtextTest.g:4457:1: RULE_ASSIGNASDATALIST
            {
             before(grammarAccess.getInnerAccess().getASSIGNASDATALISTTerminalRuleCall_2_3_0()); 
            match(input,RULE_ASSIGNASDATALIST,FOLLOW_2); 
             after(grammarAccess.getInnerAccess().getASSIGNASDATALISTTerminalRuleCall_2_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_3__0__Impl"


    // $ANTLR start "rule__Inner__Group_2_3__1"
    // InternalXtextTest.g:4470:1: rule__Inner__Group_2_3__1 : rule__Inner__Group_2_3__1__Impl ;
    public final void rule__Inner__Group_2_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4474:1: ( rule__Inner__Group_2_3__1__Impl )
            // InternalXtextTest.g:4475:2: rule__Inner__Group_2_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Inner__Group_2_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_3__1"


    // $ANTLR start "rule__Inner__Group_2_3__1__Impl"
    // InternalXtextTest.g:4481:1: rule__Inner__Group_2_3__1__Impl : ( ( rule__Inner__AssignAsDataAssignment_2_3_1 ) ) ;
    public final void rule__Inner__Group_2_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4485:1: ( ( ( rule__Inner__AssignAsDataAssignment_2_3_1 ) ) )
            // InternalXtextTest.g:4487:1: ( ( rule__Inner__AssignAsDataAssignment_2_3_1 ) )
            {
            // InternalXtextTest.g:4487:1: ( ( rule__Inner__AssignAsDataAssignment_2_3_1 ) )
            // InternalXtextTest.g:4488:1: ( rule__Inner__AssignAsDataAssignment_2_3_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignAsDataAssignment_2_3_1()); 
            // InternalXtextTest.g:4489:1: ( rule__Inner__AssignAsDataAssignment_2_3_1 )
            // InternalXtextTest.g:4489:2: rule__Inner__AssignAsDataAssignment_2_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Inner__AssignAsDataAssignment_2_3_1();

            state._fsp--;


            }

             after(grammarAccess.getInnerAccess().getAssignAsDataAssignment_2_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_3__1__Impl"


    // $ANTLR start "rule__Inner__Group_2_4__0"
    // InternalXtextTest.g:4505:1: rule__Inner__Group_2_4__0 : rule__Inner__Group_2_4__0__Impl rule__Inner__Group_2_4__1 ;
    public final void rule__Inner__Group_2_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4509:1: ( rule__Inner__Group_2_4__0__Impl rule__Inner__Group_2_4__1 )
            // InternalXtextTest.g:4510:2: rule__Inner__Group_2_4__0__Impl rule__Inner__Group_2_4__1
            {
            pushFollow(FOLLOW_11);
            rule__Inner__Group_2_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Inner__Group_2_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_4__0"


    // $ANTLR start "rule__Inner__Group_2_4__0__Impl"
    // InternalXtextTest.g:4517:1: rule__Inner__Group_2_4__0__Impl : ( RULE_ASSIGNASBOOL ) ;
    public final void rule__Inner__Group_2_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4521:1: ( ( RULE_ASSIGNASBOOL ) )
            // InternalXtextTest.g:4523:1: ( RULE_ASSIGNASBOOL )
            {
            // InternalXtextTest.g:4523:1: ( RULE_ASSIGNASBOOL )
            // InternalXtextTest.g:4524:1: RULE_ASSIGNASBOOL
            {
             before(grammarAccess.getInnerAccess().getASSIGNASBOOLTerminalRuleCall_2_4_0()); 
            match(input,RULE_ASSIGNASBOOL,FOLLOW_2); 
             after(grammarAccess.getInnerAccess().getASSIGNASBOOLTerminalRuleCall_2_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_4__0__Impl"


    // $ANTLR start "rule__Inner__Group_2_4__1"
    // InternalXtextTest.g:4537:1: rule__Inner__Group_2_4__1 : rule__Inner__Group_2_4__1__Impl ;
    public final void rule__Inner__Group_2_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4541:1: ( rule__Inner__Group_2_4__1__Impl )
            // InternalXtextTest.g:4542:2: rule__Inner__Group_2_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Inner__Group_2_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_4__1"


    // $ANTLR start "rule__Inner__Group_2_4__1__Impl"
    // InternalXtextTest.g:4548:1: rule__Inner__Group_2_4__1__Impl : ( ( rule__Inner__AssignAsBoolAssignment_2_4_1 ) ) ;
    public final void rule__Inner__Group_2_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4552:1: ( ( ( rule__Inner__AssignAsBoolAssignment_2_4_1 ) ) )
            // InternalXtextTest.g:4554:1: ( ( rule__Inner__AssignAsBoolAssignment_2_4_1 ) )
            {
            // InternalXtextTest.g:4554:1: ( ( rule__Inner__AssignAsBoolAssignment_2_4_1 ) )
            // InternalXtextTest.g:4555:1: ( rule__Inner__AssignAsBoolAssignment_2_4_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignAsBoolAssignment_2_4_1()); 
            // InternalXtextTest.g:4556:1: ( rule__Inner__AssignAsBoolAssignment_2_4_1 )
            // InternalXtextTest.g:4556:2: rule__Inner__AssignAsBoolAssignment_2_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Inner__AssignAsBoolAssignment_2_4_1();

            state._fsp--;


            }

             after(grammarAccess.getInnerAccess().getAssignAsBoolAssignment_2_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__Group_2_4__1__Impl"


    // $ANTLR start "rule__Generator__Group__0"
    // InternalXtextTest.g:4572:1: rule__Generator__Group__0 : rule__Generator__Group__0__Impl rule__Generator__Group__1 ;
    public final void rule__Generator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4576:1: ( rule__Generator__Group__0__Impl rule__Generator__Group__1 )
            // InternalXtextTest.g:4577:2: rule__Generator__Group__0__Impl rule__Generator__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__Generator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Generator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group__0"


    // $ANTLR start "rule__Generator__Group__0__Impl"
    // InternalXtextTest.g:4584:1: rule__Generator__Group__0__Impl : ( () ) ;
    public final void rule__Generator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4588:1: ( ( () ) )
            // InternalXtextTest.g:4590:1: ( () )
            {
            // InternalXtextTest.g:4590:1: ( () )
            // InternalXtextTest.g:4591:1: ()
            {
             before(grammarAccess.getGeneratorAccess().getGeneratorAction_0()); 
            // InternalXtextTest.g:4592:1: ()
            // InternalXtextTest.g:4594:1: 
            {
            }

             after(grammarAccess.getGeneratorAccess().getGeneratorAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group__0__Impl"


    // $ANTLR start "rule__Generator__Group__1"
    // InternalXtextTest.g:4606:1: rule__Generator__Group__1 : rule__Generator__Group__1__Impl rule__Generator__Group__2 ;
    public final void rule__Generator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4610:1: ( rule__Generator__Group__1__Impl rule__Generator__Group__2 )
            // InternalXtextTest.g:4611:2: rule__Generator__Group__1__Impl rule__Generator__Group__2
            {
            pushFollow(FOLLOW_35);
            rule__Generator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Generator__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group__1"


    // $ANTLR start "rule__Generator__Group__1__Impl"
    // InternalXtextTest.g:4618:1: rule__Generator__Group__1__Impl : ( ( rule__Generator__Group_1__0 ) ) ;
    public final void rule__Generator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4622:1: ( ( ( rule__Generator__Group_1__0 ) ) )
            // InternalXtextTest.g:4624:1: ( ( rule__Generator__Group_1__0 ) )
            {
            // InternalXtextTest.g:4624:1: ( ( rule__Generator__Group_1__0 ) )
            // InternalXtextTest.g:4625:1: ( rule__Generator__Group_1__0 )
            {
             before(grammarAccess.getGeneratorAccess().getGroup_1()); 
            // InternalXtextTest.g:4626:1: ( rule__Generator__Group_1__0 )
            // InternalXtextTest.g:4626:2: rule__Generator__Group_1__0
            {
            pushFollow(FOLLOW_2);
            rule__Generator__Group_1__0();

            state._fsp--;


            }

             after(grammarAccess.getGeneratorAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group__1__Impl"


    // $ANTLR start "rule__Generator__Group__2"
    // InternalXtextTest.g:4638:1: rule__Generator__Group__2 : rule__Generator__Group__2__Impl rule__Generator__Group__3 ;
    public final void rule__Generator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4642:1: ( rule__Generator__Group__2__Impl rule__Generator__Group__3 )
            // InternalXtextTest.g:4643:2: rule__Generator__Group__2__Impl rule__Generator__Group__3
            {
            pushFollow(FOLLOW_36);
            rule__Generator__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Generator__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group__2"


    // $ANTLR start "rule__Generator__Group__2__Impl"
    // InternalXtextTest.g:4650:1: rule__Generator__Group__2__Impl : ( ( rule__Generator__Group_2__0 ) ) ;
    public final void rule__Generator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4654:1: ( ( ( rule__Generator__Group_2__0 ) ) )
            // InternalXtextTest.g:4656:1: ( ( rule__Generator__Group_2__0 ) )
            {
            // InternalXtextTest.g:4656:1: ( ( rule__Generator__Group_2__0 ) )
            // InternalXtextTest.g:4657:1: ( rule__Generator__Group_2__0 )
            {
             before(grammarAccess.getGeneratorAccess().getGroup_2()); 
            // InternalXtextTest.g:4658:1: ( rule__Generator__Group_2__0 )
            // InternalXtextTest.g:4658:2: rule__Generator__Group_2__0
            {
            pushFollow(FOLLOW_2);
            rule__Generator__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getGeneratorAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group__2__Impl"


    // $ANTLR start "rule__Generator__Group__3"
    // InternalXtextTest.g:4670:1: rule__Generator__Group__3 : rule__Generator__Group__3__Impl rule__Generator__Group__4 ;
    public final void rule__Generator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4674:1: ( rule__Generator__Group__3__Impl rule__Generator__Group__4 )
            // InternalXtextTest.g:4675:2: rule__Generator__Group__3__Impl rule__Generator__Group__4
            {
            pushFollow(FOLLOW_36);
            rule__Generator__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Generator__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group__3"


    // $ANTLR start "rule__Generator__Group__3__Impl"
    // InternalXtextTest.g:4682:1: rule__Generator__Group__3__Impl : ( ( rule__Generator__Group_3__0 )? ) ;
    public final void rule__Generator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4686:1: ( ( ( rule__Generator__Group_3__0 )? ) )
            // InternalXtextTest.g:4688:1: ( ( rule__Generator__Group_3__0 )? )
            {
            // InternalXtextTest.g:4688:1: ( ( rule__Generator__Group_3__0 )? )
            // InternalXtextTest.g:4689:1: ( rule__Generator__Group_3__0 )?
            {
             before(grammarAccess.getGeneratorAccess().getGroup_3()); 
            // InternalXtextTest.g:4690:1: ( rule__Generator__Group_3__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_PATTERNS) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalXtextTest.g:4690:2: rule__Generator__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Generator__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGeneratorAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group__3__Impl"


    // $ANTLR start "rule__Generator__Group__4"
    // InternalXtextTest.g:4702:1: rule__Generator__Group__4 : rule__Generator__Group__4__Impl ;
    public final void rule__Generator__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4706:1: ( rule__Generator__Group__4__Impl )
            // InternalXtextTest.g:4707:2: rule__Generator__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Generator__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group__4"


    // $ANTLR start "rule__Generator__Group__4__Impl"
    // InternalXtextTest.g:4713:1: rule__Generator__Group__4__Impl : ( ( rule__Generator__Group_4__0 )? ) ;
    public final void rule__Generator__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4717:1: ( ( ( rule__Generator__Group_4__0 )? ) )
            // InternalXtextTest.g:4719:1: ( ( rule__Generator__Group_4__0 )? )
            {
            // InternalXtextTest.g:4719:1: ( ( rule__Generator__Group_4__0 )? )
            // InternalXtextTest.g:4720:1: ( rule__Generator__Group_4__0 )?
            {
             before(grammarAccess.getGeneratorAccess().getGroup_4()); 
            // InternalXtextTest.g:4721:1: ( rule__Generator__Group_4__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_EXPECTED) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalXtextTest.g:4721:2: rule__Generator__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Generator__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGeneratorAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group__4__Impl"


    // $ANTLR start "rule__Generator__Group_1__0"
    // InternalXtextTest.g:4743:1: rule__Generator__Group_1__0 : rule__Generator__Group_1__0__Impl rule__Generator__Group_1__1 ;
    public final void rule__Generator__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4747:1: ( rule__Generator__Group_1__0__Impl rule__Generator__Group_1__1 )
            // InternalXtextTest.g:4748:2: rule__Generator__Group_1__0__Impl rule__Generator__Group_1__1
            {
            pushFollow(FOLLOW_18);
            rule__Generator__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Generator__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_1__0"


    // $ANTLR start "rule__Generator__Group_1__0__Impl"
    // InternalXtextTest.g:4755:1: rule__Generator__Group_1__0__Impl : ( RULE_OUTPUT ) ;
    public final void rule__Generator__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4759:1: ( ( RULE_OUTPUT ) )
            // InternalXtextTest.g:4761:1: ( RULE_OUTPUT )
            {
            // InternalXtextTest.g:4761:1: ( RULE_OUTPUT )
            // InternalXtextTest.g:4762:1: RULE_OUTPUT
            {
             before(grammarAccess.getGeneratorAccess().getOUTPUTTerminalRuleCall_1_0()); 
            match(input,RULE_OUTPUT,FOLLOW_2); 
             after(grammarAccess.getGeneratorAccess().getOUTPUTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_1__0__Impl"


    // $ANTLR start "rule__Generator__Group_1__1"
    // InternalXtextTest.g:4775:1: rule__Generator__Group_1__1 : rule__Generator__Group_1__1__Impl rule__Generator__Group_1__2 ;
    public final void rule__Generator__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4779:1: ( rule__Generator__Group_1__1__Impl rule__Generator__Group_1__2 )
            // InternalXtextTest.g:4780:2: rule__Generator__Group_1__1__Impl rule__Generator__Group_1__2
            {
            pushFollow(FOLLOW_10);
            rule__Generator__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Generator__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_1__1"


    // $ANTLR start "rule__Generator__Group_1__1__Impl"
    // InternalXtextTest.g:4787:1: rule__Generator__Group_1__1__Impl : ( RULE_FILE ) ;
    public final void rule__Generator__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4791:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:4793:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:4793:1: ( RULE_FILE )
            // InternalXtextTest.g:4794:1: RULE_FILE
            {
             before(grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_1_1()); 
            match(input,RULE_FILE,FOLLOW_2); 
             after(grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_1__1__Impl"


    // $ANTLR start "rule__Generator__Group_1__2"
    // InternalXtextTest.g:4807:1: rule__Generator__Group_1__2 : rule__Generator__Group_1__2__Impl rule__Generator__Group_1__3 ;
    public final void rule__Generator__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4811:1: ( rule__Generator__Group_1__2__Impl rule__Generator__Group_1__3 )
            // InternalXtextTest.g:4812:2: rule__Generator__Group_1__2__Impl rule__Generator__Group_1__3
            {
            pushFollow(FOLLOW_19);
            rule__Generator__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Generator__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_1__2"


    // $ANTLR start "rule__Generator__Group_1__2__Impl"
    // InternalXtextTest.g:4819:1: rule__Generator__Group_1__2__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Generator__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4823:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:4825:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:4825:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:4826:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_1_2()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_1__2__Impl"


    // $ANTLR start "rule__Generator__Group_1__3"
    // InternalXtextTest.g:4839:1: rule__Generator__Group_1__3 : rule__Generator__Group_1__3__Impl ;
    public final void rule__Generator__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4843:1: ( rule__Generator__Group_1__3__Impl )
            // InternalXtextTest.g:4844:2: rule__Generator__Group_1__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Generator__Group_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_1__3"


    // $ANTLR start "rule__Generator__Group_1__3__Impl"
    // InternalXtextTest.g:4850:1: rule__Generator__Group_1__3__Impl : ( ( rule__Generator__OutputAssignment_1_3 ) ) ;
    public final void rule__Generator__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4854:1: ( ( ( rule__Generator__OutputAssignment_1_3 ) ) )
            // InternalXtextTest.g:4856:1: ( ( rule__Generator__OutputAssignment_1_3 ) )
            {
            // InternalXtextTest.g:4856:1: ( ( rule__Generator__OutputAssignment_1_3 ) )
            // InternalXtextTest.g:4857:1: ( rule__Generator__OutputAssignment_1_3 )
            {
             before(grammarAccess.getGeneratorAccess().getOutputAssignment_1_3()); 
            // InternalXtextTest.g:4858:1: ( rule__Generator__OutputAssignment_1_3 )
            // InternalXtextTest.g:4858:2: rule__Generator__OutputAssignment_1_3
            {
            pushFollow(FOLLOW_2);
            rule__Generator__OutputAssignment_1_3();

            state._fsp--;


            }

             after(grammarAccess.getGeneratorAccess().getOutputAssignment_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_1__3__Impl"


    // $ANTLR start "rule__Generator__Group_2__0"
    // InternalXtextTest.g:4878:1: rule__Generator__Group_2__0 : rule__Generator__Group_2__0__Impl rule__Generator__Group_2__1 ;
    public final void rule__Generator__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4882:1: ( rule__Generator__Group_2__0__Impl rule__Generator__Group_2__1 )
            // InternalXtextTest.g:4883:2: rule__Generator__Group_2__0__Impl rule__Generator__Group_2__1
            {
            pushFollow(FOLLOW_18);
            rule__Generator__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Generator__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_2__0"


    // $ANTLR start "rule__Generator__Group_2__0__Impl"
    // InternalXtextTest.g:4890:1: rule__Generator__Group_2__0__Impl : ( RULE_EXPECTED ) ;
    public final void rule__Generator__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4894:1: ( ( RULE_EXPECTED ) )
            // InternalXtextTest.g:4896:1: ( RULE_EXPECTED )
            {
            // InternalXtextTest.g:4896:1: ( RULE_EXPECTED )
            // InternalXtextTest.g:4897:1: RULE_EXPECTED
            {
             before(grammarAccess.getGeneratorAccess().getEXPECTEDTerminalRuleCall_2_0()); 
            match(input,RULE_EXPECTED,FOLLOW_2); 
             after(grammarAccess.getGeneratorAccess().getEXPECTEDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_2__0__Impl"


    // $ANTLR start "rule__Generator__Group_2__1"
    // InternalXtextTest.g:4910:1: rule__Generator__Group_2__1 : rule__Generator__Group_2__1__Impl rule__Generator__Group_2__2 ;
    public final void rule__Generator__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4914:1: ( rule__Generator__Group_2__1__Impl rule__Generator__Group_2__2 )
            // InternalXtextTest.g:4915:2: rule__Generator__Group_2__1__Impl rule__Generator__Group_2__2
            {
            pushFollow(FOLLOW_37);
            rule__Generator__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Generator__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_2__1"


    // $ANTLR start "rule__Generator__Group_2__1__Impl"
    // InternalXtextTest.g:4922:1: rule__Generator__Group_2__1__Impl : ( RULE_FILE ) ;
    public final void rule__Generator__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4926:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:4928:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:4928:1: ( RULE_FILE )
            // InternalXtextTest.g:4929:1: RULE_FILE
            {
             before(grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_2_1()); 
            match(input,RULE_FILE,FOLLOW_2); 
             after(grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_2__1__Impl"


    // $ANTLR start "rule__Generator__Group_2__2"
    // InternalXtextTest.g:4942:1: rule__Generator__Group_2__2 : rule__Generator__Group_2__2__Impl ;
    public final void rule__Generator__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4946:1: ( rule__Generator__Group_2__2__Impl )
            // InternalXtextTest.g:4947:2: rule__Generator__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Generator__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_2__2"


    // $ANTLR start "rule__Generator__Group_2__2__Impl"
    // InternalXtextTest.g:4953:1: rule__Generator__Group_2__2__Impl : ( ( rule__Generator__Alternatives_2_2 ) ) ;
    public final void rule__Generator__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4957:1: ( ( ( rule__Generator__Alternatives_2_2 ) ) )
            // InternalXtextTest.g:4959:1: ( ( rule__Generator__Alternatives_2_2 ) )
            {
            // InternalXtextTest.g:4959:1: ( ( rule__Generator__Alternatives_2_2 ) )
            // InternalXtextTest.g:4960:1: ( rule__Generator__Alternatives_2_2 )
            {
             before(grammarAccess.getGeneratorAccess().getAlternatives_2_2()); 
            // InternalXtextTest.g:4961:1: ( rule__Generator__Alternatives_2_2 )
            // InternalXtextTest.g:4961:2: rule__Generator__Alternatives_2_2
            {
            pushFollow(FOLLOW_2);
            rule__Generator__Alternatives_2_2();

            state._fsp--;


            }

             after(grammarAccess.getGeneratorAccess().getAlternatives_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_2__2__Impl"


    // $ANTLR start "rule__Generator__Group_2_2_0__0"
    // InternalXtextTest.g:4979:1: rule__Generator__Group_2_2_0__0 : rule__Generator__Group_2_2_0__0__Impl rule__Generator__Group_2_2_0__1 ;
    public final void rule__Generator__Group_2_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4983:1: ( rule__Generator__Group_2_2_0__0__Impl rule__Generator__Group_2_2_0__1 )
            // InternalXtextTest.g:4984:2: rule__Generator__Group_2_2_0__0__Impl rule__Generator__Group_2_2_0__1
            {
            pushFollow(FOLLOW_19);
            rule__Generator__Group_2_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Generator__Group_2_2_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_2_2_0__0"


    // $ANTLR start "rule__Generator__Group_2_2_0__0__Impl"
    // InternalXtextTest.g:4991:1: rule__Generator__Group_2_2_0__0__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Generator__Group_2_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4995:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:4997:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:4997:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:4998:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_2_2_0_0()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_2_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_2_2_0__0__Impl"


    // $ANTLR start "rule__Generator__Group_2_2_0__1"
    // InternalXtextTest.g:5011:1: rule__Generator__Group_2_2_0__1 : rule__Generator__Group_2_2_0__1__Impl ;
    public final void rule__Generator__Group_2_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5015:1: ( rule__Generator__Group_2_2_0__1__Impl )
            // InternalXtextTest.g:5016:2: rule__Generator__Group_2_2_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Generator__Group_2_2_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_2_2_0__1"


    // $ANTLR start "rule__Generator__Group_2_2_0__1__Impl"
    // InternalXtextTest.g:5022:1: rule__Generator__Group_2_2_0__1__Impl : ( ( rule__Generator__ExpectedAssignment_2_2_0_1 ) ) ;
    public final void rule__Generator__Group_2_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5026:1: ( ( ( rule__Generator__ExpectedAssignment_2_2_0_1 ) ) )
            // InternalXtextTest.g:5028:1: ( ( rule__Generator__ExpectedAssignment_2_2_0_1 ) )
            {
            // InternalXtextTest.g:5028:1: ( ( rule__Generator__ExpectedAssignment_2_2_0_1 ) )
            // InternalXtextTest.g:5029:1: ( rule__Generator__ExpectedAssignment_2_2_0_1 )
            {
             before(grammarAccess.getGeneratorAccess().getExpectedAssignment_2_2_0_1()); 
            // InternalXtextTest.g:5030:1: ( rule__Generator__ExpectedAssignment_2_2_0_1 )
            // InternalXtextTest.g:5030:2: rule__Generator__ExpectedAssignment_2_2_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Generator__ExpectedAssignment_2_2_0_1();

            state._fsp--;


            }

             after(grammarAccess.getGeneratorAccess().getExpectedAssignment_2_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_2_2_0__1__Impl"


    // $ANTLR start "rule__Generator__Group_3__0"
    // InternalXtextTest.g:5046:1: rule__Generator__Group_3__0 : rule__Generator__Group_3__0__Impl rule__Generator__Group_3__1 ;
    public final void rule__Generator__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5050:1: ( rule__Generator__Group_3__0__Impl rule__Generator__Group_3__1 )
            // InternalXtextTest.g:5051:2: rule__Generator__Group_3__0__Impl rule__Generator__Group_3__1
            {
            pushFollow(FOLLOW_38);
            rule__Generator__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Generator__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_3__0"


    // $ANTLR start "rule__Generator__Group_3__0__Impl"
    // InternalXtextTest.g:5058:1: rule__Generator__Group_3__0__Impl : ( RULE_PATTERNS ) ;
    public final void rule__Generator__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5062:1: ( ( RULE_PATTERNS ) )
            // InternalXtextTest.g:5064:1: ( RULE_PATTERNS )
            {
            // InternalXtextTest.g:5064:1: ( RULE_PATTERNS )
            // InternalXtextTest.g:5065:1: RULE_PATTERNS
            {
             before(grammarAccess.getGeneratorAccess().getPATTERNSTerminalRuleCall_3_0()); 
            match(input,RULE_PATTERNS,FOLLOW_2); 
             after(grammarAccess.getGeneratorAccess().getPATTERNSTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_3__0__Impl"


    // $ANTLR start "rule__Generator__Group_3__1"
    // InternalXtextTest.g:5078:1: rule__Generator__Group_3__1 : rule__Generator__Group_3__1__Impl rule__Generator__Group_3__2 ;
    public final void rule__Generator__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5082:1: ( rule__Generator__Group_3__1__Impl rule__Generator__Group_3__2 )
            // InternalXtextTest.g:5083:2: rule__Generator__Group_3__1__Impl rule__Generator__Group_3__2
            {
            pushFollow(FOLLOW_38);
            rule__Generator__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Generator__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_3__1"


    // $ANTLR start "rule__Generator__Group_3__1__Impl"
    // InternalXtextTest.g:5090:1: rule__Generator__Group_3__1__Impl : ( ( rule__Generator__Group_3_1__0 )? ) ;
    public final void rule__Generator__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5094:1: ( ( ( rule__Generator__Group_3_1__0 )? ) )
            // InternalXtextTest.g:5096:1: ( ( rule__Generator__Group_3_1__0 )? )
            {
            // InternalXtextTest.g:5096:1: ( ( rule__Generator__Group_3_1__0 )? )
            // InternalXtextTest.g:5097:1: ( rule__Generator__Group_3_1__0 )?
            {
             before(grammarAccess.getGeneratorAccess().getGroup_3_1()); 
            // InternalXtextTest.g:5098:1: ( rule__Generator__Group_3_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_FILE) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalXtextTest.g:5098:2: rule__Generator__Group_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Generator__Group_3_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGeneratorAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_3__1__Impl"


    // $ANTLR start "rule__Generator__Group_3__2"
    // InternalXtextTest.g:5110:1: rule__Generator__Group_3__2 : rule__Generator__Group_3__2__Impl ;
    public final void rule__Generator__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5114:1: ( rule__Generator__Group_3__2__Impl )
            // InternalXtextTest.g:5115:2: rule__Generator__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Generator__Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_3__2"


    // $ANTLR start "rule__Generator__Group_3__2__Impl"
    // InternalXtextTest.g:5121:1: rule__Generator__Group_3__2__Impl : ( ( rule__Generator__ReplacePatternsAssignment_3_2 )* ) ;
    public final void rule__Generator__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5125:1: ( ( ( rule__Generator__ReplacePatternsAssignment_3_2 )* ) )
            // InternalXtextTest.g:5127:1: ( ( rule__Generator__ReplacePatternsAssignment_3_2 )* )
            {
            // InternalXtextTest.g:5127:1: ( ( rule__Generator__ReplacePatternsAssignment_3_2 )* )
            // InternalXtextTest.g:5128:1: ( rule__Generator__ReplacePatternsAssignment_3_2 )*
            {
             before(grammarAccess.getGeneratorAccess().getReplacePatternsAssignment_3_2()); 
            // InternalXtextTest.g:5129:1: ( rule__Generator__ReplacePatternsAssignment_3_2 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_STRING) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalXtextTest.g:5129:2: rule__Generator__ReplacePatternsAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_39);
            	    rule__Generator__ReplacePatternsAssignment_3_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getGeneratorAccess().getReplacePatternsAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_3__2__Impl"


    // $ANTLR start "rule__Generator__Group_3_1__0"
    // InternalXtextTest.g:5147:1: rule__Generator__Group_3_1__0 : rule__Generator__Group_3_1__0__Impl rule__Generator__Group_3_1__1 ;
    public final void rule__Generator__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5151:1: ( rule__Generator__Group_3_1__0__Impl rule__Generator__Group_3_1__1 )
            // InternalXtextTest.g:5152:2: rule__Generator__Group_3_1__0__Impl rule__Generator__Group_3_1__1
            {
            pushFollow(FOLLOW_10);
            rule__Generator__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Generator__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_3_1__0"


    // $ANTLR start "rule__Generator__Group_3_1__0__Impl"
    // InternalXtextTest.g:5159:1: rule__Generator__Group_3_1__0__Impl : ( RULE_FILE ) ;
    public final void rule__Generator__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5163:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:5165:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:5165:1: ( RULE_FILE )
            // InternalXtextTest.g:5166:1: RULE_FILE
            {
             before(grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_3_1_0()); 
            match(input,RULE_FILE,FOLLOW_2); 
             after(grammarAccess.getGeneratorAccess().getFILETerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_3_1__0__Impl"


    // $ANTLR start "rule__Generator__Group_3_1__1"
    // InternalXtextTest.g:5179:1: rule__Generator__Group_3_1__1 : rule__Generator__Group_3_1__1__Impl rule__Generator__Group_3_1__2 ;
    public final void rule__Generator__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5183:1: ( rule__Generator__Group_3_1__1__Impl rule__Generator__Group_3_1__2 )
            // InternalXtextTest.g:5184:2: rule__Generator__Group_3_1__1__Impl rule__Generator__Group_3_1__2
            {
            pushFollow(FOLLOW_19);
            rule__Generator__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Generator__Group_3_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_3_1__1"


    // $ANTLR start "rule__Generator__Group_3_1__1__Impl"
    // InternalXtextTest.g:5191:1: rule__Generator__Group_3_1__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Generator__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5195:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:5197:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:5197:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:5198:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_3_1_1()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getGeneratorAccess().getASSIGNASSINGLETerminalRuleCall_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_3_1__1__Impl"


    // $ANTLR start "rule__Generator__Group_3_1__2"
    // InternalXtextTest.g:5211:1: rule__Generator__Group_3_1__2 : rule__Generator__Group_3_1__2__Impl ;
    public final void rule__Generator__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5215:1: ( rule__Generator__Group_3_1__2__Impl )
            // InternalXtextTest.g:5216:2: rule__Generator__Group_3_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Generator__Group_3_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_3_1__2"


    // $ANTLR start "rule__Generator__Group_3_1__2__Impl"
    // InternalXtextTest.g:5222:1: rule__Generator__Group_3_1__2__Impl : ( ( rule__Generator__PatternFileAssignment_3_1_2 ) ) ;
    public final void rule__Generator__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5226:1: ( ( ( rule__Generator__PatternFileAssignment_3_1_2 ) ) )
            // InternalXtextTest.g:5228:1: ( ( rule__Generator__PatternFileAssignment_3_1_2 ) )
            {
            // InternalXtextTest.g:5228:1: ( ( rule__Generator__PatternFileAssignment_3_1_2 ) )
            // InternalXtextTest.g:5229:1: ( rule__Generator__PatternFileAssignment_3_1_2 )
            {
             before(grammarAccess.getGeneratorAccess().getPatternFileAssignment_3_1_2()); 
            // InternalXtextTest.g:5230:1: ( rule__Generator__PatternFileAssignment_3_1_2 )
            // InternalXtextTest.g:5230:2: rule__Generator__PatternFileAssignment_3_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Generator__PatternFileAssignment_3_1_2();

            state._fsp--;


            }

             after(grammarAccess.getGeneratorAccess().getPatternFileAssignment_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_3_1__2__Impl"


    // $ANTLR start "rule__Generator__Group_4__0"
    // InternalXtextTest.g:5248:1: rule__Generator__Group_4__0 : rule__Generator__Group_4__0__Impl rule__Generator__Group_4__1 ;
    public final void rule__Generator__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5252:1: ( rule__Generator__Group_4__0__Impl rule__Generator__Group_4__1 )
            // InternalXtextTest.g:5253:2: rule__Generator__Group_4__0__Impl rule__Generator__Group_4__1
            {
            pushFollow(FOLLOW_40);
            rule__Generator__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Generator__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_4__0"


    // $ANTLR start "rule__Generator__Group_4__0__Impl"
    // InternalXtextTest.g:5260:1: rule__Generator__Group_4__0__Impl : ( RULE_EXPECTED ) ;
    public final void rule__Generator__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5264:1: ( ( RULE_EXPECTED ) )
            // InternalXtextTest.g:5266:1: ( RULE_EXPECTED )
            {
            // InternalXtextTest.g:5266:1: ( RULE_EXPECTED )
            // InternalXtextTest.g:5267:1: RULE_EXPECTED
            {
             before(grammarAccess.getGeneratorAccess().getEXPECTEDTerminalRuleCall_4_0()); 
            match(input,RULE_EXPECTED,FOLLOW_2); 
             after(grammarAccess.getGeneratorAccess().getEXPECTEDTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_4__0__Impl"


    // $ANTLR start "rule__Generator__Group_4__1"
    // InternalXtextTest.g:5280:1: rule__Generator__Group_4__1 : rule__Generator__Group_4__1__Impl rule__Generator__Group_4__2 ;
    public final void rule__Generator__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5284:1: ( rule__Generator__Group_4__1__Impl rule__Generator__Group_4__2 )
            // InternalXtextTest.g:5285:2: rule__Generator__Group_4__1__Impl rule__Generator__Group_4__2
            {
            pushFollow(FOLLOW_5);
            rule__Generator__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Generator__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_4__1"


    // $ANTLR start "rule__Generator__Group_4__1__Impl"
    // InternalXtextTest.g:5292:1: rule__Generator__Group_4__1__Impl : ( RULE_EXCEPTIONS ) ;
    public final void rule__Generator__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5296:1: ( ( RULE_EXCEPTIONS ) )
            // InternalXtextTest.g:5298:1: ( RULE_EXCEPTIONS )
            {
            // InternalXtextTest.g:5298:1: ( RULE_EXCEPTIONS )
            // InternalXtextTest.g:5299:1: RULE_EXCEPTIONS
            {
             before(grammarAccess.getGeneratorAccess().getEXCEPTIONSTerminalRuleCall_4_1()); 
            match(input,RULE_EXCEPTIONS,FOLLOW_2); 
             after(grammarAccess.getGeneratorAccess().getEXCEPTIONSTerminalRuleCall_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_4__1__Impl"


    // $ANTLR start "rule__Generator__Group_4__2"
    // InternalXtextTest.g:5312:1: rule__Generator__Group_4__2 : rule__Generator__Group_4__2__Impl ;
    public final void rule__Generator__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5316:1: ( rule__Generator__Group_4__2__Impl )
            // InternalXtextTest.g:5317:2: rule__Generator__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Generator__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_4__2"


    // $ANTLR start "rule__Generator__Group_4__2__Impl"
    // InternalXtextTest.g:5323:1: rule__Generator__Group_4__2__Impl : ( ( rule__Generator__ExceptionAssignment_4_2 ) ) ;
    public final void rule__Generator__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5327:1: ( ( ( rule__Generator__ExceptionAssignment_4_2 ) ) )
            // InternalXtextTest.g:5329:1: ( ( rule__Generator__ExceptionAssignment_4_2 ) )
            {
            // InternalXtextTest.g:5329:1: ( ( rule__Generator__ExceptionAssignment_4_2 ) )
            // InternalXtextTest.g:5330:1: ( rule__Generator__ExceptionAssignment_4_2 )
            {
             before(grammarAccess.getGeneratorAccess().getExceptionAssignment_4_2()); 
            // InternalXtextTest.g:5331:1: ( rule__Generator__ExceptionAssignment_4_2 )
            // InternalXtextTest.g:5331:2: rule__Generator__ExceptionAssignment_4_2
            {
            pushFollow(FOLLOW_2);
            rule__Generator__ExceptionAssignment_4_2();

            state._fsp--;


            }

             after(grammarAccess.getGeneratorAccess().getExceptionAssignment_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__Group_4__2__Impl"


    // $ANTLR start "rule__ReplacePatterns__Group__0"
    // InternalXtextTest.g:5349:1: rule__ReplacePatterns__Group__0 : rule__ReplacePatterns__Group__0__Impl rule__ReplacePatterns__Group__1 ;
    public final void rule__ReplacePatterns__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5353:1: ( rule__ReplacePatterns__Group__0__Impl rule__ReplacePatterns__Group__1 )
            // InternalXtextTest.g:5354:2: rule__ReplacePatterns__Group__0__Impl rule__ReplacePatterns__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__ReplacePatterns__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ReplacePatterns__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReplacePatterns__Group__0"


    // $ANTLR start "rule__ReplacePatterns__Group__0__Impl"
    // InternalXtextTest.g:5361:1: rule__ReplacePatterns__Group__0__Impl : ( ( rule__ReplacePatterns__RegexAssignment_0 ) ) ;
    public final void rule__ReplacePatterns__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5365:1: ( ( ( rule__ReplacePatterns__RegexAssignment_0 ) ) )
            // InternalXtextTest.g:5367:1: ( ( rule__ReplacePatterns__RegexAssignment_0 ) )
            {
            // InternalXtextTest.g:5367:1: ( ( rule__ReplacePatterns__RegexAssignment_0 ) )
            // InternalXtextTest.g:5368:1: ( rule__ReplacePatterns__RegexAssignment_0 )
            {
             before(grammarAccess.getReplacePatternsAccess().getRegexAssignment_0()); 
            // InternalXtextTest.g:5369:1: ( rule__ReplacePatterns__RegexAssignment_0 )
            // InternalXtextTest.g:5369:2: rule__ReplacePatterns__RegexAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ReplacePatterns__RegexAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getReplacePatternsAccess().getRegexAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReplacePatterns__Group__0__Impl"


    // $ANTLR start "rule__ReplacePatterns__Group__1"
    // InternalXtextTest.g:5381:1: rule__ReplacePatterns__Group__1 : rule__ReplacePatterns__Group__1__Impl rule__ReplacePatterns__Group__2 ;
    public final void rule__ReplacePatterns__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5385:1: ( rule__ReplacePatterns__Group__1__Impl rule__ReplacePatterns__Group__2 )
            // InternalXtextTest.g:5386:2: rule__ReplacePatterns__Group__1__Impl rule__ReplacePatterns__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__ReplacePatterns__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ReplacePatterns__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReplacePatterns__Group__1"


    // $ANTLR start "rule__ReplacePatterns__Group__1__Impl"
    // InternalXtextTest.g:5393:1: rule__ReplacePatterns__Group__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__ReplacePatterns__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5397:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:5399:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:5399:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:5400:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getReplacePatternsAccess().getASSIGNASSINGLETerminalRuleCall_1()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getReplacePatternsAccess().getASSIGNASSINGLETerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReplacePatterns__Group__1__Impl"


    // $ANTLR start "rule__ReplacePatterns__Group__2"
    // InternalXtextTest.g:5413:1: rule__ReplacePatterns__Group__2 : rule__ReplacePatterns__Group__2__Impl ;
    public final void rule__ReplacePatterns__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5417:1: ( rule__ReplacePatterns__Group__2__Impl )
            // InternalXtextTest.g:5418:2: rule__ReplacePatterns__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ReplacePatterns__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReplacePatterns__Group__2"


    // $ANTLR start "rule__ReplacePatterns__Group__2__Impl"
    // InternalXtextTest.g:5424:1: rule__ReplacePatterns__Group__2__Impl : ( ( rule__ReplacePatterns__ReplaceAssignment_2 ) ) ;
    public final void rule__ReplacePatterns__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5428:1: ( ( ( rule__ReplacePatterns__ReplaceAssignment_2 ) ) )
            // InternalXtextTest.g:5430:1: ( ( rule__ReplacePatterns__ReplaceAssignment_2 ) )
            {
            // InternalXtextTest.g:5430:1: ( ( rule__ReplacePatterns__ReplaceAssignment_2 ) )
            // InternalXtextTest.g:5431:1: ( rule__ReplacePatterns__ReplaceAssignment_2 )
            {
             before(grammarAccess.getReplacePatternsAccess().getReplaceAssignment_2()); 
            // InternalXtextTest.g:5432:1: ( rule__ReplacePatterns__ReplaceAssignment_2 )
            // InternalXtextTest.g:5432:2: rule__ReplacePatterns__ReplaceAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ReplacePatterns__ReplaceAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getReplacePatternsAccess().getReplaceAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReplacePatterns__Group__2__Impl"


    // $ANTLR start "rule__Before__Group__0"
    // InternalXtextTest.g:5450:1: rule__Before__Group__0 : rule__Before__Group__0__Impl rule__Before__Group__1 ;
    public final void rule__Before__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5454:1: ( rule__Before__Group__0__Impl rule__Before__Group__1 )
            // InternalXtextTest.g:5455:2: rule__Before__Group__0__Impl rule__Before__Group__1
            {
            pushFollow(FOLLOW_41);
            rule__Before__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Before__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Before__Group__0"


    // $ANTLR start "rule__Before__Group__0__Impl"
    // InternalXtextTest.g:5462:1: rule__Before__Group__0__Impl : ( () ) ;
    public final void rule__Before__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5466:1: ( ( () ) )
            // InternalXtextTest.g:5468:1: ( () )
            {
            // InternalXtextTest.g:5468:1: ( () )
            // InternalXtextTest.g:5469:1: ()
            {
             before(grammarAccess.getBeforeAccess().getBeforeAction_0()); 
            // InternalXtextTest.g:5470:1: ()
            // InternalXtextTest.g:5472:1: 
            {
            }

             after(grammarAccess.getBeforeAccess().getBeforeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Before__Group__0__Impl"


    // $ANTLR start "rule__Before__Group__1"
    // InternalXtextTest.g:5484:1: rule__Before__Group__1 : rule__Before__Group__1__Impl rule__Before__Group__2 ;
    public final void rule__Before__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5488:1: ( rule__Before__Group__1__Impl rule__Before__Group__2 )
            // InternalXtextTest.g:5489:2: rule__Before__Group__1__Impl rule__Before__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__Before__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Before__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Before__Group__1"


    // $ANTLR start "rule__Before__Group__1__Impl"
    // InternalXtextTest.g:5496:1: rule__Before__Group__1__Impl : ( RULE_BEFORE_KW ) ;
    public final void rule__Before__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5500:1: ( ( RULE_BEFORE_KW ) )
            // InternalXtextTest.g:5502:1: ( RULE_BEFORE_KW )
            {
            // InternalXtextTest.g:5502:1: ( RULE_BEFORE_KW )
            // InternalXtextTest.g:5503:1: RULE_BEFORE_KW
            {
             before(grammarAccess.getBeforeAccess().getBEFORE_KWTerminalRuleCall_1()); 
            match(input,RULE_BEFORE_KW,FOLLOW_2); 
             after(grammarAccess.getBeforeAccess().getBEFORE_KWTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Before__Group__1__Impl"


    // $ANTLR start "rule__Before__Group__2"
    // InternalXtextTest.g:5516:1: rule__Before__Group__2 : rule__Before__Group__2__Impl ;
    public final void rule__Before__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5520:1: ( rule__Before__Group__2__Impl )
            // InternalXtextTest.g:5521:2: rule__Before__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Before__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Before__Group__2"


    // $ANTLR start "rule__Before__Group__2__Impl"
    // InternalXtextTest.g:5527:1: rule__Before__Group__2__Impl : ( ( rule__Before__CodeCallAssignment_2 ) ) ;
    public final void rule__Before__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5531:1: ( ( ( rule__Before__CodeCallAssignment_2 ) ) )
            // InternalXtextTest.g:5533:1: ( ( rule__Before__CodeCallAssignment_2 ) )
            {
            // InternalXtextTest.g:5533:1: ( ( rule__Before__CodeCallAssignment_2 ) )
            // InternalXtextTest.g:5534:1: ( rule__Before__CodeCallAssignment_2 )
            {
             before(grammarAccess.getBeforeAccess().getCodeCallAssignment_2()); 
            // InternalXtextTest.g:5535:1: ( rule__Before__CodeCallAssignment_2 )
            // InternalXtextTest.g:5535:2: rule__Before__CodeCallAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Before__CodeCallAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBeforeAccess().getCodeCallAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Before__Group__2__Impl"


    // $ANTLR start "rule__After__Group__0"
    // InternalXtextTest.g:5553:1: rule__After__Group__0 : rule__After__Group__0__Impl rule__After__Group__1 ;
    public final void rule__After__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5557:1: ( rule__After__Group__0__Impl rule__After__Group__1 )
            // InternalXtextTest.g:5558:2: rule__After__Group__0__Impl rule__After__Group__1
            {
            pushFollow(FOLLOW_42);
            rule__After__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__After__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__After__Group__0"


    // $ANTLR start "rule__After__Group__0__Impl"
    // InternalXtextTest.g:5565:1: rule__After__Group__0__Impl : ( () ) ;
    public final void rule__After__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5569:1: ( ( () ) )
            // InternalXtextTest.g:5571:1: ( () )
            {
            // InternalXtextTest.g:5571:1: ( () )
            // InternalXtextTest.g:5572:1: ()
            {
             before(grammarAccess.getAfterAccess().getAfterAction_0()); 
            // InternalXtextTest.g:5573:1: ()
            // InternalXtextTest.g:5575:1: 
            {
            }

             after(grammarAccess.getAfterAccess().getAfterAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__After__Group__0__Impl"


    // $ANTLR start "rule__After__Group__1"
    // InternalXtextTest.g:5587:1: rule__After__Group__1 : rule__After__Group__1__Impl rule__After__Group__2 ;
    public final void rule__After__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5591:1: ( rule__After__Group__1__Impl rule__After__Group__2 )
            // InternalXtextTest.g:5592:2: rule__After__Group__1__Impl rule__After__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__After__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__After__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__After__Group__1"


    // $ANTLR start "rule__After__Group__1__Impl"
    // InternalXtextTest.g:5599:1: rule__After__Group__1__Impl : ( RULE_AFTER_KW ) ;
    public final void rule__After__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5603:1: ( ( RULE_AFTER_KW ) )
            // InternalXtextTest.g:5605:1: ( RULE_AFTER_KW )
            {
            // InternalXtextTest.g:5605:1: ( RULE_AFTER_KW )
            // InternalXtextTest.g:5606:1: RULE_AFTER_KW
            {
             before(grammarAccess.getAfterAccess().getAFTER_KWTerminalRuleCall_1()); 
            match(input,RULE_AFTER_KW,FOLLOW_2); 
             after(grammarAccess.getAfterAccess().getAFTER_KWTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__After__Group__1__Impl"


    // $ANTLR start "rule__After__Group__2"
    // InternalXtextTest.g:5619:1: rule__After__Group__2 : rule__After__Group__2__Impl ;
    public final void rule__After__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5623:1: ( rule__After__Group__2__Impl )
            // InternalXtextTest.g:5624:2: rule__After__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__After__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__After__Group__2"


    // $ANTLR start "rule__After__Group__2__Impl"
    // InternalXtextTest.g:5630:1: rule__After__Group__2__Impl : ( ( rule__After__CodeCallAssignment_2 ) ) ;
    public final void rule__After__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5634:1: ( ( ( rule__After__CodeCallAssignment_2 ) ) )
            // InternalXtextTest.g:5636:1: ( ( rule__After__CodeCallAssignment_2 ) )
            {
            // InternalXtextTest.g:5636:1: ( ( rule__After__CodeCallAssignment_2 ) )
            // InternalXtextTest.g:5637:1: ( rule__After__CodeCallAssignment_2 )
            {
             before(grammarAccess.getAfterAccess().getCodeCallAssignment_2()); 
            // InternalXtextTest.g:5638:1: ( rule__After__CodeCallAssignment_2 )
            // InternalXtextTest.g:5638:2: rule__After__CodeCallAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__After__CodeCallAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAfterAccess().getCodeCallAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__After__Group__2__Impl"


    // $ANTLR start "rule__CodeCall__Group__0"
    // InternalXtextTest.g:5656:1: rule__CodeCall__Group__0 : rule__CodeCall__Group__0__Impl rule__CodeCall__Group__1 ;
    public final void rule__CodeCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5660:1: ( rule__CodeCall__Group__0__Impl rule__CodeCall__Group__1 )
            // InternalXtextTest.g:5661:2: rule__CodeCall__Group__0__Impl rule__CodeCall__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__CodeCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CodeCall__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__0"


    // $ANTLR start "rule__CodeCall__Group__0__Impl"
    // InternalXtextTest.g:5668:1: rule__CodeCall__Group__0__Impl : ( () ) ;
    public final void rule__CodeCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5672:1: ( ( () ) )
            // InternalXtextTest.g:5674:1: ( () )
            {
            // InternalXtextTest.g:5674:1: ( () )
            // InternalXtextTest.g:5675:1: ()
            {
             before(grammarAccess.getCodeCallAccess().getCodeCallAction_0()); 
            // InternalXtextTest.g:5676:1: ()
            // InternalXtextTest.g:5678:1: 
            {
            }

             after(grammarAccess.getCodeCallAccess().getCodeCallAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__0__Impl"


    // $ANTLR start "rule__CodeCall__Group__1"
    // InternalXtextTest.g:5690:1: rule__CodeCall__Group__1 : rule__CodeCall__Group__1__Impl rule__CodeCall__Group__2 ;
    public final void rule__CodeCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5694:1: ( rule__CodeCall__Group__1__Impl rule__CodeCall__Group__2 )
            // InternalXtextTest.g:5695:2: rule__CodeCall__Group__1__Impl rule__CodeCall__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__CodeCall__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CodeCall__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__1"


    // $ANTLR start "rule__CodeCall__Group__1__Impl"
    // InternalXtextTest.g:5702:1: rule__CodeCall__Group__1__Impl : ( RULE_CLASS_KW ) ;
    public final void rule__CodeCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5706:1: ( ( RULE_CLASS_KW ) )
            // InternalXtextTest.g:5708:1: ( RULE_CLASS_KW )
            {
            // InternalXtextTest.g:5708:1: ( RULE_CLASS_KW )
            // InternalXtextTest.g:5709:1: RULE_CLASS_KW
            {
             before(grammarAccess.getCodeCallAccess().getCLASS_KWTerminalRuleCall_1()); 
            match(input,RULE_CLASS_KW,FOLLOW_2); 
             after(grammarAccess.getCodeCallAccess().getCLASS_KWTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__1__Impl"


    // $ANTLR start "rule__CodeCall__Group__2"
    // InternalXtextTest.g:5722:1: rule__CodeCall__Group__2 : rule__CodeCall__Group__2__Impl rule__CodeCall__Group__3 ;
    public final void rule__CodeCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5726:1: ( rule__CodeCall__Group__2__Impl rule__CodeCall__Group__3 )
            // InternalXtextTest.g:5727:2: rule__CodeCall__Group__2__Impl rule__CodeCall__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__CodeCall__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CodeCall__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__2"


    // $ANTLR start "rule__CodeCall__Group__2__Impl"
    // InternalXtextTest.g:5734:1: rule__CodeCall__Group__2__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__CodeCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5738:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:5740:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:5740:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:5741:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getCodeCallAccess().getASSIGNASSINGLETerminalRuleCall_2()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getCodeCallAccess().getASSIGNASSINGLETerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__2__Impl"


    // $ANTLR start "rule__CodeCall__Group__3"
    // InternalXtextTest.g:5754:1: rule__CodeCall__Group__3 : rule__CodeCall__Group__3__Impl rule__CodeCall__Group__4 ;
    public final void rule__CodeCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5758:1: ( rule__CodeCall__Group__3__Impl rule__CodeCall__Group__4 )
            // InternalXtextTest.g:5759:2: rule__CodeCall__Group__3__Impl rule__CodeCall__Group__4
            {
            pushFollow(FOLLOW_43);
            rule__CodeCall__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CodeCall__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__3"


    // $ANTLR start "rule__CodeCall__Group__3__Impl"
    // InternalXtextTest.g:5766:1: rule__CodeCall__Group__3__Impl : ( ( rule__CodeCall__MyclassAssignment_3 ) ) ;
    public final void rule__CodeCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5770:1: ( ( ( rule__CodeCall__MyclassAssignment_3 ) ) )
            // InternalXtextTest.g:5772:1: ( ( rule__CodeCall__MyclassAssignment_3 ) )
            {
            // InternalXtextTest.g:5772:1: ( ( rule__CodeCall__MyclassAssignment_3 ) )
            // InternalXtextTest.g:5773:1: ( rule__CodeCall__MyclassAssignment_3 )
            {
             before(grammarAccess.getCodeCallAccess().getMyclassAssignment_3()); 
            // InternalXtextTest.g:5774:1: ( rule__CodeCall__MyclassAssignment_3 )
            // InternalXtextTest.g:5774:2: rule__CodeCall__MyclassAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__MyclassAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCodeCallAccess().getMyclassAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__3__Impl"


    // $ANTLR start "rule__CodeCall__Group__4"
    // InternalXtextTest.g:5786:1: rule__CodeCall__Group__4 : rule__CodeCall__Group__4__Impl rule__CodeCall__Group__5 ;
    public final void rule__CodeCall__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5790:1: ( rule__CodeCall__Group__4__Impl rule__CodeCall__Group__5 )
            // InternalXtextTest.g:5791:2: rule__CodeCall__Group__4__Impl rule__CodeCall__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__CodeCall__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CodeCall__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__4"


    // $ANTLR start "rule__CodeCall__Group__4__Impl"
    // InternalXtextTest.g:5798:1: rule__CodeCall__Group__4__Impl : ( RULE_METHOD_KW ) ;
    public final void rule__CodeCall__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5802:1: ( ( RULE_METHOD_KW ) )
            // InternalXtextTest.g:5804:1: ( RULE_METHOD_KW )
            {
            // InternalXtextTest.g:5804:1: ( RULE_METHOD_KW )
            // InternalXtextTest.g:5805:1: RULE_METHOD_KW
            {
             before(grammarAccess.getCodeCallAccess().getMETHOD_KWTerminalRuleCall_4()); 
            match(input,RULE_METHOD_KW,FOLLOW_2); 
             after(grammarAccess.getCodeCallAccess().getMETHOD_KWTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__4__Impl"


    // $ANTLR start "rule__CodeCall__Group__5"
    // InternalXtextTest.g:5818:1: rule__CodeCall__Group__5 : rule__CodeCall__Group__5__Impl rule__CodeCall__Group__6 ;
    public final void rule__CodeCall__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5822:1: ( rule__CodeCall__Group__5__Impl rule__CodeCall__Group__6 )
            // InternalXtextTest.g:5823:2: rule__CodeCall__Group__5__Impl rule__CodeCall__Group__6
            {
            pushFollow(FOLLOW_5);
            rule__CodeCall__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CodeCall__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__5"


    // $ANTLR start "rule__CodeCall__Group__5__Impl"
    // InternalXtextTest.g:5830:1: rule__CodeCall__Group__5__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__CodeCall__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5834:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:5836:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:5836:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:5837:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getCodeCallAccess().getASSIGNASSINGLETerminalRuleCall_5()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getCodeCallAccess().getASSIGNASSINGLETerminalRuleCall_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__5__Impl"


    // $ANTLR start "rule__CodeCall__Group__6"
    // InternalXtextTest.g:5850:1: rule__CodeCall__Group__6 : rule__CodeCall__Group__6__Impl rule__CodeCall__Group__7 ;
    public final void rule__CodeCall__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5854:1: ( rule__CodeCall__Group__6__Impl rule__CodeCall__Group__7 )
            // InternalXtextTest.g:5855:2: rule__CodeCall__Group__6__Impl rule__CodeCall__Group__7
            {
            pushFollow(FOLLOW_44);
            rule__CodeCall__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CodeCall__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__6"


    // $ANTLR start "rule__CodeCall__Group__6__Impl"
    // InternalXtextTest.g:5862:1: rule__CodeCall__Group__6__Impl : ( ( rule__CodeCall__MethodAssignment_6 ) ) ;
    public final void rule__CodeCall__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5866:1: ( ( ( rule__CodeCall__MethodAssignment_6 ) ) )
            // InternalXtextTest.g:5868:1: ( ( rule__CodeCall__MethodAssignment_6 ) )
            {
            // InternalXtextTest.g:5868:1: ( ( rule__CodeCall__MethodAssignment_6 ) )
            // InternalXtextTest.g:5869:1: ( rule__CodeCall__MethodAssignment_6 )
            {
             before(grammarAccess.getCodeCallAccess().getMethodAssignment_6()); 
            // InternalXtextTest.g:5870:1: ( rule__CodeCall__MethodAssignment_6 )
            // InternalXtextTest.g:5870:2: rule__CodeCall__MethodAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__MethodAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getCodeCallAccess().getMethodAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__6__Impl"


    // $ANTLR start "rule__CodeCall__Group__7"
    // InternalXtextTest.g:5882:1: rule__CodeCall__Group__7 : rule__CodeCall__Group__7__Impl ;
    public final void rule__CodeCall__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5886:1: ( rule__CodeCall__Group__7__Impl )
            // InternalXtextTest.g:5887:2: rule__CodeCall__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__7"


    // $ANTLR start "rule__CodeCall__Group__7__Impl"
    // InternalXtextTest.g:5893:1: rule__CodeCall__Group__7__Impl : ( ( rule__CodeCall__Group_7__0 ) ) ;
    public final void rule__CodeCall__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5897:1: ( ( ( rule__CodeCall__Group_7__0 ) ) )
            // InternalXtextTest.g:5899:1: ( ( rule__CodeCall__Group_7__0 ) )
            {
            // InternalXtextTest.g:5899:1: ( ( rule__CodeCall__Group_7__0 ) )
            // InternalXtextTest.g:5900:1: ( rule__CodeCall__Group_7__0 )
            {
             before(grammarAccess.getCodeCallAccess().getGroup_7()); 
            // InternalXtextTest.g:5901:1: ( rule__CodeCall__Group_7__0 )
            // InternalXtextTest.g:5901:2: rule__CodeCall__Group_7__0
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__Group_7__0();

            state._fsp--;


            }

             after(grammarAccess.getCodeCallAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__7__Impl"


    // $ANTLR start "rule__CodeCall__Group_7__0"
    // InternalXtextTest.g:5929:1: rule__CodeCall__Group_7__0 : rule__CodeCall__Group_7__0__Impl rule__CodeCall__Group_7__1 ;
    public final void rule__CodeCall__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5933:1: ( rule__CodeCall__Group_7__0__Impl rule__CodeCall__Group_7__1 )
            // InternalXtextTest.g:5934:2: rule__CodeCall__Group_7__0__Impl rule__CodeCall__Group_7__1
            {
            pushFollow(FOLLOW_29);
            rule__CodeCall__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CodeCall__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group_7__0"


    // $ANTLR start "rule__CodeCall__Group_7__0__Impl"
    // InternalXtextTest.g:5941:1: rule__CodeCall__Group_7__0__Impl : ( RULE_LEFTPAREN ) ;
    public final void rule__CodeCall__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5945:1: ( ( RULE_LEFTPAREN ) )
            // InternalXtextTest.g:5947:1: ( RULE_LEFTPAREN )
            {
            // InternalXtextTest.g:5947:1: ( RULE_LEFTPAREN )
            // InternalXtextTest.g:5948:1: RULE_LEFTPAREN
            {
             before(grammarAccess.getCodeCallAccess().getLEFTPARENTerminalRuleCall_7_0()); 
            match(input,RULE_LEFTPAREN,FOLLOW_2); 
             after(grammarAccess.getCodeCallAccess().getLEFTPARENTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group_7__0__Impl"


    // $ANTLR start "rule__CodeCall__Group_7__1"
    // InternalXtextTest.g:5961:1: rule__CodeCall__Group_7__1 : rule__CodeCall__Group_7__1__Impl rule__CodeCall__Group_7__2 ;
    public final void rule__CodeCall__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5965:1: ( rule__CodeCall__Group_7__1__Impl rule__CodeCall__Group_7__2 )
            // InternalXtextTest.g:5966:2: rule__CodeCall__Group_7__1__Impl rule__CodeCall__Group_7__2
            {
            pushFollow(FOLLOW_29);
            rule__CodeCall__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CodeCall__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group_7__1"


    // $ANTLR start "rule__CodeCall__Group_7__1__Impl"
    // InternalXtextTest.g:5973:1: rule__CodeCall__Group_7__1__Impl : ( ( rule__CodeCall__Group_7_1__0 )? ) ;
    public final void rule__CodeCall__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5977:1: ( ( ( rule__CodeCall__Group_7_1__0 )? ) )
            // InternalXtextTest.g:5979:1: ( ( rule__CodeCall__Group_7_1__0 )? )
            {
            // InternalXtextTest.g:5979:1: ( ( rule__CodeCall__Group_7_1__0 )? )
            // InternalXtextTest.g:5980:1: ( rule__CodeCall__Group_7_1__0 )?
            {
             before(grammarAccess.getCodeCallAccess().getGroup_7_1()); 
            // InternalXtextTest.g:5981:1: ( rule__CodeCall__Group_7_1__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_IDENTIFIER) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalXtextTest.g:5981:2: rule__CodeCall__Group_7_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CodeCall__Group_7_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCodeCallAccess().getGroup_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group_7__1__Impl"


    // $ANTLR start "rule__CodeCall__Group_7__2"
    // InternalXtextTest.g:5993:1: rule__CodeCall__Group_7__2 : rule__CodeCall__Group_7__2__Impl ;
    public final void rule__CodeCall__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5997:1: ( rule__CodeCall__Group_7__2__Impl )
            // InternalXtextTest.g:5998:2: rule__CodeCall__Group_7__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__Group_7__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group_7__2"


    // $ANTLR start "rule__CodeCall__Group_7__2__Impl"
    // InternalXtextTest.g:6004:1: rule__CodeCall__Group_7__2__Impl : ( RULE_RIGHTPAREN ) ;
    public final void rule__CodeCall__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6008:1: ( ( RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:6010:1: ( RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:6010:1: ( RULE_RIGHTPAREN )
            // InternalXtextTest.g:6011:1: RULE_RIGHTPAREN
            {
             before(grammarAccess.getCodeCallAccess().getRIGHTPARENTerminalRuleCall_7_2()); 
            match(input,RULE_RIGHTPAREN,FOLLOW_2); 
             after(grammarAccess.getCodeCallAccess().getRIGHTPARENTerminalRuleCall_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group_7__2__Impl"


    // $ANTLR start "rule__CodeCall__Group_7_1__0"
    // InternalXtextTest.g:6030:1: rule__CodeCall__Group_7_1__0 : rule__CodeCall__Group_7_1__0__Impl rule__CodeCall__Group_7_1__1 ;
    public final void rule__CodeCall__Group_7_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6034:1: ( rule__CodeCall__Group_7_1__0__Impl rule__CodeCall__Group_7_1__1 )
            // InternalXtextTest.g:6035:2: rule__CodeCall__Group_7_1__0__Impl rule__CodeCall__Group_7_1__1
            {
            pushFollow(FOLLOW_31);
            rule__CodeCall__Group_7_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CodeCall__Group_7_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group_7_1__0"


    // $ANTLR start "rule__CodeCall__Group_7_1__0__Impl"
    // InternalXtextTest.g:6042:1: rule__CodeCall__Group_7_1__0__Impl : ( ( rule__CodeCall__ParamsAssignment_7_1_0 ) ) ;
    public final void rule__CodeCall__Group_7_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6046:1: ( ( ( rule__CodeCall__ParamsAssignment_7_1_0 ) ) )
            // InternalXtextTest.g:6048:1: ( ( rule__CodeCall__ParamsAssignment_7_1_0 ) )
            {
            // InternalXtextTest.g:6048:1: ( ( rule__CodeCall__ParamsAssignment_7_1_0 ) )
            // InternalXtextTest.g:6049:1: ( rule__CodeCall__ParamsAssignment_7_1_0 )
            {
             before(grammarAccess.getCodeCallAccess().getParamsAssignment_7_1_0()); 
            // InternalXtextTest.g:6050:1: ( rule__CodeCall__ParamsAssignment_7_1_0 )
            // InternalXtextTest.g:6050:2: rule__CodeCall__ParamsAssignment_7_1_0
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__ParamsAssignment_7_1_0();

            state._fsp--;


            }

             after(grammarAccess.getCodeCallAccess().getParamsAssignment_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group_7_1__0__Impl"


    // $ANTLR start "rule__CodeCall__Group_7_1__1"
    // InternalXtextTest.g:6062:1: rule__CodeCall__Group_7_1__1 : rule__CodeCall__Group_7_1__1__Impl ;
    public final void rule__CodeCall__Group_7_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6066:1: ( rule__CodeCall__Group_7_1__1__Impl )
            // InternalXtextTest.g:6067:2: rule__CodeCall__Group_7_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__Group_7_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group_7_1__1"


    // $ANTLR start "rule__CodeCall__Group_7_1__1__Impl"
    // InternalXtextTest.g:6073:1: rule__CodeCall__Group_7_1__1__Impl : ( ( rule__CodeCall__Group_7_1_1__0 )* ) ;
    public final void rule__CodeCall__Group_7_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6077:1: ( ( ( rule__CodeCall__Group_7_1_1__0 )* ) )
            // InternalXtextTest.g:6079:1: ( ( rule__CodeCall__Group_7_1_1__0 )* )
            {
            // InternalXtextTest.g:6079:1: ( ( rule__CodeCall__Group_7_1_1__0 )* )
            // InternalXtextTest.g:6080:1: ( rule__CodeCall__Group_7_1_1__0 )*
            {
             before(grammarAccess.getCodeCallAccess().getGroup_7_1_1()); 
            // InternalXtextTest.g:6081:1: ( rule__CodeCall__Group_7_1_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_COMMA) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalXtextTest.g:6081:2: rule__CodeCall__Group_7_1_1__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__CodeCall__Group_7_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getCodeCallAccess().getGroup_7_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group_7_1__1__Impl"


    // $ANTLR start "rule__CodeCall__Group_7_1_1__0"
    // InternalXtextTest.g:6097:1: rule__CodeCall__Group_7_1_1__0 : rule__CodeCall__Group_7_1_1__0__Impl rule__CodeCall__Group_7_1_1__1 ;
    public final void rule__CodeCall__Group_7_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6101:1: ( rule__CodeCall__Group_7_1_1__0__Impl rule__CodeCall__Group_7_1_1__1 )
            // InternalXtextTest.g:6102:2: rule__CodeCall__Group_7_1_1__0__Impl rule__CodeCall__Group_7_1_1__1
            {
            pushFollow(FOLLOW_5);
            rule__CodeCall__Group_7_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CodeCall__Group_7_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group_7_1_1__0"


    // $ANTLR start "rule__CodeCall__Group_7_1_1__0__Impl"
    // InternalXtextTest.g:6109:1: rule__CodeCall__Group_7_1_1__0__Impl : ( RULE_COMMA ) ;
    public final void rule__CodeCall__Group_7_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6113:1: ( ( RULE_COMMA ) )
            // InternalXtextTest.g:6115:1: ( RULE_COMMA )
            {
            // InternalXtextTest.g:6115:1: ( RULE_COMMA )
            // InternalXtextTest.g:6116:1: RULE_COMMA
            {
             before(grammarAccess.getCodeCallAccess().getCOMMATerminalRuleCall_7_1_1_0()); 
            match(input,RULE_COMMA,FOLLOW_2); 
             after(grammarAccess.getCodeCallAccess().getCOMMATerminalRuleCall_7_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group_7_1_1__0__Impl"


    // $ANTLR start "rule__CodeCall__Group_7_1_1__1"
    // InternalXtextTest.g:6129:1: rule__CodeCall__Group_7_1_1__1 : rule__CodeCall__Group_7_1_1__1__Impl ;
    public final void rule__CodeCall__Group_7_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6133:1: ( rule__CodeCall__Group_7_1_1__1__Impl )
            // InternalXtextTest.g:6134:2: rule__CodeCall__Group_7_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__Group_7_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group_7_1_1__1"


    // $ANTLR start "rule__CodeCall__Group_7_1_1__1__Impl"
    // InternalXtextTest.g:6140:1: rule__CodeCall__Group_7_1_1__1__Impl : ( ( rule__CodeCall__ParamsAssignment_7_1_1_1 ) ) ;
    public final void rule__CodeCall__Group_7_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6144:1: ( ( ( rule__CodeCall__ParamsAssignment_7_1_1_1 ) ) )
            // InternalXtextTest.g:6146:1: ( ( rule__CodeCall__ParamsAssignment_7_1_1_1 ) )
            {
            // InternalXtextTest.g:6146:1: ( ( rule__CodeCall__ParamsAssignment_7_1_1_1 ) )
            // InternalXtextTest.g:6147:1: ( rule__CodeCall__ParamsAssignment_7_1_1_1 )
            {
             before(grammarAccess.getCodeCallAccess().getParamsAssignment_7_1_1_1()); 
            // InternalXtextTest.g:6148:1: ( rule__CodeCall__ParamsAssignment_7_1_1_1 )
            // InternalXtextTest.g:6148:2: rule__CodeCall__ParamsAssignment_7_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__ParamsAssignment_7_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getCodeCallAccess().getParamsAssignment_7_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group_7_1_1__1__Impl"


    // $ANTLR start "rule__Model__XtextTestAssignment_1_0"
    // InternalXtextTest.g:6165:1: rule__Model__XtextTestAssignment_1_0 : ( ruleXtextTest ) ;
    public final void rule__Model__XtextTestAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6169:1: ( ( ruleXtextTest ) )
            // InternalXtextTest.g:6170:1: ( ruleXtextTest )
            {
            // InternalXtextTest.g:6170:1: ( ruleXtextTest )
            // InternalXtextTest.g:6171:1: ruleXtextTest
            {
             before(grammarAccess.getModelAccess().getXtextTestXtextTestParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleXtextTest();

            state._fsp--;

             after(grammarAccess.getModelAccess().getXtextTestXtextTestParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__XtextTestAssignment_1_0"


    // $ANTLR start "rule__Model__EmfTestAssignment_1_1"
    // InternalXtextTest.g:6180:1: rule__Model__EmfTestAssignment_1_1 : ( ruleEmfTest ) ;
    public final void rule__Model__EmfTestAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6184:1: ( ( ruleEmfTest ) )
            // InternalXtextTest.g:6185:1: ( ruleEmfTest )
            {
            // InternalXtextTest.g:6185:1: ( ruleEmfTest )
            // InternalXtextTest.g:6186:1: ruleEmfTest
            {
             before(grammarAccess.getModelAccess().getEmfTestEmfTestParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEmfTest();

            state._fsp--;

             after(grammarAccess.getModelAccess().getEmfTestEmfTestParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__EmfTestAssignment_1_1"


    // $ANTLR start "rule__XtextTest__PackageAssignment_2"
    // InternalXtextTest.g:6195:1: rule__XtextTest__PackageAssignment_2 : ( rulePackageID ) ;
    public final void rule__XtextTest__PackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6199:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6200:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6200:1: ( rulePackageID )
            // InternalXtextTest.g:6201:1: rulePackageID
            {
             before(grammarAccess.getXtextTestAccess().getPackagePackageIDParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getPackagePackageIDParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__PackageAssignment_2"


    // $ANTLR start "rule__XtextTest__LangAssignment_4"
    // InternalXtextTest.g:6210:1: rule__XtextTest__LangAssignment_4 : ( ruleLangID ) ;
    public final void rule__XtextTest__LangAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6214:1: ( ( ruleLangID ) )
            // InternalXtextTest.g:6215:1: ( ruleLangID )
            {
            // InternalXtextTest.g:6215:1: ( ruleLangID )
            // InternalXtextTest.g:6216:1: ruleLangID
            {
             before(grammarAccess.getXtextTestAccess().getLangLangIDParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleLangID();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getLangLangIDParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__LangAssignment_4"


    // $ANTLR start "rule__XtextTest__ImportsAssignment_5_1"
    // InternalXtextTest.g:6225:1: rule__XtextTest__ImportsAssignment_5_1 : ( ruleImportID ) ;
    public final void rule__XtextTest__ImportsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6229:1: ( ( ruleImportID ) )
            // InternalXtextTest.g:6230:1: ( ruleImportID )
            {
            // InternalXtextTest.g:6230:1: ( ruleImportID )
            // InternalXtextTest.g:6231:1: ruleImportID
            {
             before(grammarAccess.getXtextTestAccess().getImportsImportIDParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleImportID();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getImportsImportIDParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__ImportsAssignment_5_1"


    // $ANTLR start "rule__XtextTest__BooleanAssignment_6_2"
    // InternalXtextTest.g:6240:1: rule__XtextTest__BooleanAssignment_6_2 : ( ruleBoolean ) ;
    public final void rule__XtextTest__BooleanAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6244:1: ( ( ruleBoolean ) )
            // InternalXtextTest.g:6245:1: ( ruleBoolean )
            {
            // InternalXtextTest.g:6245:1: ( ruleBoolean )
            // InternalXtextTest.g:6246:1: ruleBoolean
            {
             before(grammarAccess.getXtextTestAccess().getBooleanBooleanParserRuleCall_6_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBoolean();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getBooleanBooleanParserRuleCall_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__BooleanAssignment_6_2"


    // $ANTLR start "rule__XtextTest__InputAssignment_7"
    // InternalXtextTest.g:6255:1: rule__XtextTest__InputAssignment_7 : ( ruleInput ) ;
    public final void rule__XtextTest__InputAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6259:1: ( ( ruleInput ) )
            // InternalXtextTest.g:6260:1: ( ruleInput )
            {
            // InternalXtextTest.g:6260:1: ( ruleInput )
            // InternalXtextTest.g:6261:1: ruleInput
            {
             before(grammarAccess.getXtextTestAccess().getInputInputParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleInput();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getInputInputParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__InputAssignment_7"


    // $ANTLR start "rule__XtextTest__TimeOutAssignment_8_2"
    // InternalXtextTest.g:6270:1: rule__XtextTest__TimeOutAssignment_8_2 : ( RULE_INT ) ;
    public final void rule__XtextTest__TimeOutAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6274:1: ( ( RULE_INT ) )
            // InternalXtextTest.g:6275:1: ( RULE_INT )
            {
            // InternalXtextTest.g:6275:1: ( RULE_INT )
            // InternalXtextTest.g:6276:1: RULE_INT
            {
             before(grammarAccess.getXtextTestAccess().getTimeOutINTTerminalRuleCall_8_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getXtextTestAccess().getTimeOutINTTerminalRuleCall_8_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__TimeOutAssignment_8_2"


    // $ANTLR start "rule__XtextTest__TokensAssignment_9"
    // InternalXtextTest.g:6285:1: rule__XtextTest__TokensAssignment_9 : ( ruleTokens ) ;
    public final void rule__XtextTest__TokensAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6289:1: ( ( ruleTokens ) )
            // InternalXtextTest.g:6290:1: ( ruleTokens )
            {
            // InternalXtextTest.g:6290:1: ( ruleTokens )
            // InternalXtextTest.g:6291:1: ruleTokens
            {
             before(grammarAccess.getXtextTestAccess().getTokensTokensParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleTokens();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getTokensTokensParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__TokensAssignment_9"


    // $ANTLR start "rule__XtextTest__RootAssignment_10"
    // InternalXtextTest.g:6300:1: rule__XtextTest__RootAssignment_10 : ( ruleElement ) ;
    public final void rule__XtextTest__RootAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6304:1: ( ( ruleElement ) )
            // InternalXtextTest.g:6305:1: ( ruleElement )
            {
            // InternalXtextTest.g:6305:1: ( ruleElement )
            // InternalXtextTest.g:6306:1: ruleElement
            {
             before(grammarAccess.getXtextTestAccess().getRootElementParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getRootElementParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__RootAssignment_10"


    // $ANTLR start "rule__XtextTest__OutputAssignment_11"
    // InternalXtextTest.g:6315:1: rule__XtextTest__OutputAssignment_11 : ( ruleGenerator ) ;
    public final void rule__XtextTest__OutputAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6319:1: ( ( ruleGenerator ) )
            // InternalXtextTest.g:6320:1: ( ruleGenerator )
            {
            // InternalXtextTest.g:6320:1: ( ruleGenerator )
            // InternalXtextTest.g:6321:1: ruleGenerator
            {
             before(grammarAccess.getXtextTestAccess().getOutputGeneratorParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleGenerator();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getOutputGeneratorParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__OutputAssignment_11"


    // $ANTLR start "rule__XtextTest__BeforeAssignment_12"
    // InternalXtextTest.g:6330:1: rule__XtextTest__BeforeAssignment_12 : ( ruleBefore ) ;
    public final void rule__XtextTest__BeforeAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6334:1: ( ( ruleBefore ) )
            // InternalXtextTest.g:6335:1: ( ruleBefore )
            {
            // InternalXtextTest.g:6335:1: ( ruleBefore )
            // InternalXtextTest.g:6336:1: ruleBefore
            {
             before(grammarAccess.getXtextTestAccess().getBeforeBeforeParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleBefore();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getBeforeBeforeParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__BeforeAssignment_12"


    // $ANTLR start "rule__XtextTest__AfterAssignment_13"
    // InternalXtextTest.g:6345:1: rule__XtextTest__AfterAssignment_13 : ( ruleAfter ) ;
    public final void rule__XtextTest__AfterAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6349:1: ( ( ruleAfter ) )
            // InternalXtextTest.g:6350:1: ( ruleAfter )
            {
            // InternalXtextTest.g:6350:1: ( ruleAfter )
            // InternalXtextTest.g:6351:1: ruleAfter
            {
             before(grammarAccess.getXtextTestAccess().getAfterAfterParserRuleCall_13_0()); 
            pushFollow(FOLLOW_2);
            ruleAfter();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getAfterAfterParserRuleCall_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__AfterAssignment_13"


    // $ANTLR start "rule__EmfTest__PackageAssignment_3"
    // InternalXtextTest.g:6360:1: rule__EmfTest__PackageAssignment_3 : ( rulePackageID ) ;
    public final void rule__EmfTest__PackageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6364:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6365:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6365:1: ( rulePackageID )
            // InternalXtextTest.g:6366:1: rulePackageID
            {
             before(grammarAccess.getEmfTestAccess().getPackagePackageIDParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getEmfTestAccess().getPackagePackageIDParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__PackageAssignment_3"


    // $ANTLR start "rule__EmfTest__MydefaultAssignment_5"
    // InternalXtextTest.g:6375:1: rule__EmfTest__MydefaultAssignment_5 : ( rulePackageID ) ;
    public final void rule__EmfTest__MydefaultAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6379:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6380:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6380:1: ( rulePackageID )
            // InternalXtextTest.g:6381:1: rulePackageID
            {
             before(grammarAccess.getEmfTestAccess().getMydefaultPackageIDParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getEmfTestAccess().getMydefaultPackageIDParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__MydefaultAssignment_5"


    // $ANTLR start "rule__EmfTest__MyimportAssignment_6"
    // InternalXtextTest.g:6390:1: rule__EmfTest__MyimportAssignment_6 : ( ruleImport ) ;
    public final void rule__EmfTest__MyimportAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6394:1: ( ( ruleImport ) )
            // InternalXtextTest.g:6395:1: ( ruleImport )
            {
            // InternalXtextTest.g:6395:1: ( ruleImport )
            // InternalXtextTest.g:6396:1: ruleImport
            {
             before(grammarAccess.getEmfTestAccess().getMyimportImportParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getEmfTestAccess().getMyimportImportParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__MyimportAssignment_6"


    // $ANTLR start "rule__EmfTest__TimeOutAssignment_7_2"
    // InternalXtextTest.g:6405:1: rule__EmfTest__TimeOutAssignment_7_2 : ( RULE_INT ) ;
    public final void rule__EmfTest__TimeOutAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6409:1: ( ( RULE_INT ) )
            // InternalXtextTest.g:6410:1: ( RULE_INT )
            {
            // InternalXtextTest.g:6410:1: ( RULE_INT )
            // InternalXtextTest.g:6411:1: RULE_INT
            {
             before(grammarAccess.getEmfTestAccess().getTimeOutINTTerminalRuleCall_7_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getTimeOutINTTerminalRuleCall_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__TimeOutAssignment_7_2"


    // $ANTLR start "rule__EmfTest__CodeCallAssignment_8"
    // InternalXtextTest.g:6420:1: rule__EmfTest__CodeCallAssignment_8 : ( ruleCodeCall ) ;
    public final void rule__EmfTest__CodeCallAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6424:1: ( ( ruleCodeCall ) )
            // InternalXtextTest.g:6425:1: ( ruleCodeCall )
            {
            // InternalXtextTest.g:6425:1: ( ruleCodeCall )
            // InternalXtextTest.g:6426:1: ruleCodeCall
            {
             before(grammarAccess.getEmfTestAccess().getCodeCallCodeCallParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleCodeCall();

            state._fsp--;

             after(grammarAccess.getEmfTestAccess().getCodeCallCodeCallParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__CodeCallAssignment_8"


    // $ANTLR start "rule__EmfTest__OptionCallAssignment_9_1"
    // InternalXtextTest.g:6435:1: rule__EmfTest__OptionCallAssignment_9_1 : ( ruleCodeCall ) ;
    public final void rule__EmfTest__OptionCallAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6439:1: ( ( ruleCodeCall ) )
            // InternalXtextTest.g:6440:1: ( ruleCodeCall )
            {
            // InternalXtextTest.g:6440:1: ( ruleCodeCall )
            // InternalXtextTest.g:6441:1: ruleCodeCall
            {
             before(grammarAccess.getEmfTestAccess().getOptionCallCodeCallParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCodeCall();

            state._fsp--;

             after(grammarAccess.getEmfTestAccess().getOptionCallCodeCallParserRuleCall_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__OptionCallAssignment_9_1"


    // $ANTLR start "rule__EmfTest__ParamCallAssignment_10_1"
    // InternalXtextTest.g:6450:1: rule__EmfTest__ParamCallAssignment_10_1 : ( ruleCodeCall ) ;
    public final void rule__EmfTest__ParamCallAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6454:1: ( ( ruleCodeCall ) )
            // InternalXtextTest.g:6455:1: ( ruleCodeCall )
            {
            // InternalXtextTest.g:6455:1: ( ruleCodeCall )
            // InternalXtextTest.g:6456:1: ruleCodeCall
            {
             before(grammarAccess.getEmfTestAccess().getParamCallCodeCallParserRuleCall_10_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCodeCall();

            state._fsp--;

             after(grammarAccess.getEmfTestAccess().getParamCallCodeCallParserRuleCall_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__ParamCallAssignment_10_1"


    // $ANTLR start "rule__EmfTest__FileAssignment_11_3"
    // InternalXtextTest.g:6465:1: rule__EmfTest__FileAssignment_11_3 : ( RULE_STRING ) ;
    public final void rule__EmfTest__FileAssignment_11_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6469:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6470:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6470:1: ( RULE_STRING )
            // InternalXtextTest.g:6471:1: RULE_STRING
            {
             before(grammarAccess.getEmfTestAccess().getFileSTRINGTerminalRuleCall_11_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getFileSTRINGTerminalRuleCall_11_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__FileAssignment_11_3"


    // $ANTLR start "rule__EmfTest__RootAssignment_12"
    // InternalXtextTest.g:6480:1: rule__EmfTest__RootAssignment_12 : ( ruleElement ) ;
    public final void rule__EmfTest__RootAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6484:1: ( ( ruleElement ) )
            // InternalXtextTest.g:6485:1: ( ruleElement )
            {
            // InternalXtextTest.g:6485:1: ( ruleElement )
            // InternalXtextTest.g:6486:1: ruleElement
            {
             before(grammarAccess.getEmfTestAccess().getRootElementParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getEmfTestAccess().getRootElementParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__RootAssignment_12"


    // $ANTLR start "rule__EmfTest__BeforeAssignment_13"
    // InternalXtextTest.g:6495:1: rule__EmfTest__BeforeAssignment_13 : ( ruleBefore ) ;
    public final void rule__EmfTest__BeforeAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6499:1: ( ( ruleBefore ) )
            // InternalXtextTest.g:6500:1: ( ruleBefore )
            {
            // InternalXtextTest.g:6500:1: ( ruleBefore )
            // InternalXtextTest.g:6501:1: ruleBefore
            {
             before(grammarAccess.getEmfTestAccess().getBeforeBeforeParserRuleCall_13_0()); 
            pushFollow(FOLLOW_2);
            ruleBefore();

            state._fsp--;

             after(grammarAccess.getEmfTestAccess().getBeforeBeforeParserRuleCall_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__BeforeAssignment_13"


    // $ANTLR start "rule__EmfTest__AfterAssignment_14"
    // InternalXtextTest.g:6510:1: rule__EmfTest__AfterAssignment_14 : ( ruleAfter ) ;
    public final void rule__EmfTest__AfterAssignment_14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6514:1: ( ( ruleAfter ) )
            // InternalXtextTest.g:6515:1: ( ruleAfter )
            {
            // InternalXtextTest.g:6515:1: ( ruleAfter )
            // InternalXtextTest.g:6516:1: ruleAfter
            {
             before(grammarAccess.getEmfTestAccess().getAfterAfterParserRuleCall_14_0()); 
            pushFollow(FOLLOW_2);
            ruleAfter();

            state._fsp--;

             after(grammarAccess.getEmfTestAccess().getAfterAfterParserRuleCall_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__AfterAssignment_14"


    // $ANTLR start "rule__Import__IdAssignment_2"
    // InternalXtextTest.g:6525:1: rule__Import__IdAssignment_2 : ( ruleImportID ) ;
    public final void rule__Import__IdAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6529:1: ( ( ruleImportID ) )
            // InternalXtextTest.g:6530:1: ( ruleImportID )
            {
            // InternalXtextTest.g:6530:1: ( ruleImportID )
            // InternalXtextTest.g:6531:1: ruleImportID
            {
             before(grammarAccess.getImportAccess().getIdImportIDParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleImportID();

            state._fsp--;

             after(grammarAccess.getImportAccess().getIdImportIDParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__IdAssignment_2"


    // $ANTLR start "rule__Import__AliasAssignment_4"
    // InternalXtextTest.g:6540:1: rule__Import__AliasAssignment_4 : ( RULE_IDENTIFIER ) ;
    public final void rule__Import__AliasAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6544:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:6545:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:6545:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:6546:1: RULE_IDENTIFIER
            {
             before(grammarAccess.getImportAccess().getAliasIDENTIFIERTerminalRuleCall_4_0()); 
            match(input,RULE_IDENTIFIER,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getAliasIDENTIFIERTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__AliasAssignment_4"


    // $ANTLR start "rule__Input__TextAssignment_2_0_2"
    // InternalXtextTest.g:6555:1: rule__Input__TextAssignment_2_0_2 : ( RULE_STRING ) ;
    public final void rule__Input__TextAssignment_2_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6559:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6560:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6560:1: ( RULE_STRING )
            // InternalXtextTest.g:6561:1: RULE_STRING
            {
             before(grammarAccess.getInputAccess().getTextSTRINGTerminalRuleCall_2_0_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getInputAccess().getTextSTRINGTerminalRuleCall_2_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__TextAssignment_2_0_2"


    // $ANTLR start "rule__Input__FileAssignment_2_1_2"
    // InternalXtextTest.g:6570:1: rule__Input__FileAssignment_2_1_2 : ( RULE_STRING ) ;
    public final void rule__Input__FileAssignment_2_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6574:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6575:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6575:1: ( RULE_STRING )
            // InternalXtextTest.g:6576:1: RULE_STRING
            {
             before(grammarAccess.getInputAccess().getFileSTRINGTerminalRuleCall_2_1_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getInputAccess().getFileSTRINGTerminalRuleCall_2_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__FileAssignment_2_1_2"


    // $ANTLR start "rule__Tokens__TokensAssignment_2"
    // InternalXtextTest.g:6585:1: rule__Tokens__TokensAssignment_2 : ( ruleMyTokens ) ;
    public final void rule__Tokens__TokensAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6589:1: ( ( ruleMyTokens ) )
            // InternalXtextTest.g:6590:1: ( ruleMyTokens )
            {
            // InternalXtextTest.g:6590:1: ( ruleMyTokens )
            // InternalXtextTest.g:6591:1: ruleMyTokens
            {
             before(grammarAccess.getTokensAccess().getTokensMyTokensParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleMyTokens();

            state._fsp--;

             after(grammarAccess.getTokensAccess().getTokensMyTokensParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tokens__TokensAssignment_2"


    // $ANTLR start "rule__MyTokens__TokenAssignment_0_0"
    // InternalXtextTest.g:6600:1: rule__MyTokens__TokenAssignment_0_0 : ( RULE_IDENTIFIER ) ;
    public final void rule__MyTokens__TokenAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6604:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:6605:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:6605:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:6606:1: RULE_IDENTIFIER
            {
             before(grammarAccess.getMyTokensAccess().getTokenIDENTIFIERTerminalRuleCall_0_0_0()); 
            match(input,RULE_IDENTIFIER,FOLLOW_2); 
             after(grammarAccess.getMyTokensAccess().getTokenIDENTIFIERTerminalRuleCall_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyTokens__TokenAssignment_0_0"


    // $ANTLR start "rule__MyTokens__StringAssignment_0_1"
    // InternalXtextTest.g:6615:1: rule__MyTokens__StringAssignment_0_1 : ( RULE_STRING ) ;
    public final void rule__MyTokens__StringAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6619:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6620:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6620:1: ( RULE_STRING )
            // InternalXtextTest.g:6621:1: RULE_STRING
            {
             before(grammarAccess.getMyTokensAccess().getStringSTRINGTerminalRuleCall_0_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getMyTokensAccess().getStringSTRINGTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyTokens__StringAssignment_0_1"


    // $ANTLR start "rule__MyTokens__CountAssignment_1_1"
    // InternalXtextTest.g:6630:1: rule__MyTokens__CountAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__MyTokens__CountAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6634:1: ( ( RULE_INT ) )
            // InternalXtextTest.g:6635:1: ( RULE_INT )
            {
            // InternalXtextTest.g:6635:1: ( RULE_INT )
            // InternalXtextTest.g:6636:1: RULE_INT
            {
             before(grammarAccess.getMyTokensAccess().getCountINTTerminalRuleCall_1_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMyTokensAccess().getCountINTTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyTokens__CountAssignment_1_1"


    // $ANTLR start "rule__Element__ImportingAssignment_2_0"
    // InternalXtextTest.g:6645:1: rule__Element__ImportingAssignment_2_0 : ( RULE_IDENTIFIER ) ;
    public final void rule__Element__ImportingAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6649:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:6650:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:6650:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:6651:1: RULE_IDENTIFIER
            {
             before(grammarAccess.getElementAccess().getImportingIDENTIFIERTerminalRuleCall_2_0_0()); 
            match(input,RULE_IDENTIFIER,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getImportingIDENTIFIERTerminalRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__ImportingAssignment_2_0"


    // $ANTLR start "rule__Element__NameAssignment_3"
    // InternalXtextTest.g:6660:1: rule__Element__NameAssignment_3 : ( RULE_IDENTIFIER ) ;
    public final void rule__Element__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6664:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:6665:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:6665:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:6666:1: RULE_IDENTIFIER
            {
             before(grammarAccess.getElementAccess().getNameIDENTIFIERTerminalRuleCall_3_0()); 
            match(input,RULE_IDENTIFIER,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getNameIDENTIFIERTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__NameAssignment_3"


    // $ANTLR start "rule__Element__InnerAssignment_4_0"
    // InternalXtextTest.g:6675:1: rule__Element__InnerAssignment_4_0 : ( ruleInner ) ;
    public final void rule__Element__InnerAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6679:1: ( ( ruleInner ) )
            // InternalXtextTest.g:6680:1: ( ruleInner )
            {
            // InternalXtextTest.g:6680:1: ( ruleInner )
            // InternalXtextTest.g:6681:1: ruleInner
            {
             before(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_2);
            ruleInner();

            state._fsp--;

             after(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__InnerAssignment_4_0"


    // $ANTLR start "rule__Element__InnerAssignment_4_1_1"
    // InternalXtextTest.g:6690:1: rule__Element__InnerAssignment_4_1_1 : ( ruleInner ) ;
    public final void rule__Element__InnerAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6694:1: ( ( ruleInner ) )
            // InternalXtextTest.g:6695:1: ( ruleInner )
            {
            // InternalXtextTest.g:6695:1: ( ruleInner )
            // InternalXtextTest.g:6696:1: ruleInner
            {
             before(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_4_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleInner();

            state._fsp--;

             after(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_4_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__InnerAssignment_4_1_1"


    // $ANTLR start "rule__Inner__ParameterAssignment_1"
    // InternalXtextTest.g:6705:1: rule__Inner__ParameterAssignment_1 : ( RULE_IDENTIFIER ) ;
    public final void rule__Inner__ParameterAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6709:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:6710:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:6710:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:6711:1: RULE_IDENTIFIER
            {
             before(grammarAccess.getInnerAccess().getParameterIDENTIFIERTerminalRuleCall_1_0()); 
            match(input,RULE_IDENTIFIER,FOLLOW_2); 
             after(grammarAccess.getInnerAccess().getParameterIDENTIFIERTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__ParameterAssignment_1"


    // $ANTLR start "rule__Inner__AssignAssignment_2_0_1"
    // InternalXtextTest.g:6720:1: rule__Inner__AssignAssignment_2_0_1 : ( ruleElement ) ;
    public final void rule__Inner__AssignAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6724:1: ( ( ruleElement ) )
            // InternalXtextTest.g:6725:1: ( ruleElement )
            {
            // InternalXtextTest.g:6725:1: ( ruleElement )
            // InternalXtextTest.g:6726:1: ruleElement
            {
             before(grammarAccess.getInnerAccess().getAssignElementParserRuleCall_2_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getInnerAccess().getAssignElementParserRuleCall_2_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__AssignAssignment_2_0_1"


    // $ANTLR start "rule__Inner__AssignListAssignment_2_1_1"
    // InternalXtextTest.g:6735:1: rule__Inner__AssignListAssignment_2_1_1 : ( ruleElement ) ;
    public final void rule__Inner__AssignListAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6739:1: ( ( ruleElement ) )
            // InternalXtextTest.g:6740:1: ( ruleElement )
            {
            // InternalXtextTest.g:6740:1: ( ruleElement )
            // InternalXtextTest.g:6741:1: ruleElement
            {
             before(grammarAccess.getInnerAccess().getAssignListElementParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getInnerAccess().getAssignListElementParserRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__AssignListAssignment_2_1_1"


    // $ANTLR start "rule__Inner__AssignListAssignment_2_1_2_1"
    // InternalXtextTest.g:6750:1: rule__Inner__AssignListAssignment_2_1_2_1 : ( ruleElement ) ;
    public final void rule__Inner__AssignListAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6754:1: ( ( ruleElement ) )
            // InternalXtextTest.g:6755:1: ( ruleElement )
            {
            // InternalXtextTest.g:6755:1: ( ruleElement )
            // InternalXtextTest.g:6756:1: ruleElement
            {
             before(grammarAccess.getInnerAccess().getAssignListElementParserRuleCall_2_1_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getInnerAccess().getAssignListElementParserRuleCall_2_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__AssignListAssignment_2_1_2_1"


    // $ANTLR start "rule__Inner__ValueAssignment_2_2_1"
    // InternalXtextTest.g:6765:1: rule__Inner__ValueAssignment_2_2_1 : ( RULE_STRING ) ;
    public final void rule__Inner__ValueAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6769:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6770:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6770:1: ( RULE_STRING )
            // InternalXtextTest.g:6771:1: RULE_STRING
            {
             before(grammarAccess.getInnerAccess().getValueSTRINGTerminalRuleCall_2_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getInnerAccess().getValueSTRINGTerminalRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__ValueAssignment_2_2_1"


    // $ANTLR start "rule__Inner__AssignAsDataAssignment_2_3_1"
    // InternalXtextTest.g:6780:1: rule__Inner__AssignAsDataAssignment_2_3_1 : ( RULE_STRING ) ;
    public final void rule__Inner__AssignAsDataAssignment_2_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6784:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6785:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6785:1: ( RULE_STRING )
            // InternalXtextTest.g:6786:1: RULE_STRING
            {
             before(grammarAccess.getInnerAccess().getAssignAsDataSTRINGTerminalRuleCall_2_3_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getInnerAccess().getAssignAsDataSTRINGTerminalRuleCall_2_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__AssignAsDataAssignment_2_3_1"


    // $ANTLR start "rule__Inner__AssignAsBoolAssignment_2_4_1"
    // InternalXtextTest.g:6795:1: rule__Inner__AssignAsBoolAssignment_2_4_1 : ( ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 ) ) ;
    public final void rule__Inner__AssignAsBoolAssignment_2_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6799:1: ( ( ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 ) ) )
            // InternalXtextTest.g:6800:1: ( ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 ) )
            {
            // InternalXtextTest.g:6800:1: ( ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 ) )
            // InternalXtextTest.g:6801:1: ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 )
            {
             before(grammarAccess.getInnerAccess().getAssignAsBoolAlternatives_2_4_1_0()); 
            // InternalXtextTest.g:6802:1: ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 )
            // InternalXtextTest.g:6802:2: rule__Inner__AssignAsBoolAlternatives_2_4_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Inner__AssignAsBoolAlternatives_2_4_1_0();

            state._fsp--;


            }

             after(grammarAccess.getInnerAccess().getAssignAsBoolAlternatives_2_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__AssignAsBoolAssignment_2_4_1"


    // $ANTLR start "rule__Inner__IsNullAssignment_2_5"
    // InternalXtextTest.g:6811:1: rule__Inner__IsNullAssignment_2_5 : ( RULE_ISNULL ) ;
    public final void rule__Inner__IsNullAssignment_2_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6815:1: ( ( RULE_ISNULL ) )
            // InternalXtextTest.g:6816:1: ( RULE_ISNULL )
            {
            // InternalXtextTest.g:6816:1: ( RULE_ISNULL )
            // InternalXtextTest.g:6817:1: RULE_ISNULL
            {
             before(grammarAccess.getInnerAccess().getIsNullISNULLTerminalRuleCall_2_5_0()); 
            match(input,RULE_ISNULL,FOLLOW_2); 
             after(grammarAccess.getInnerAccess().getIsNullISNULLTerminalRuleCall_2_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__IsNullAssignment_2_5"


    // $ANTLR start "rule__Inner__IsNotNullAssignment_2_6"
    // InternalXtextTest.g:6826:1: rule__Inner__IsNotNullAssignment_2_6 : ( RULE_ISNOTNULL ) ;
    public final void rule__Inner__IsNotNullAssignment_2_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6830:1: ( ( RULE_ISNOTNULL ) )
            // InternalXtextTest.g:6831:1: ( RULE_ISNOTNULL )
            {
            // InternalXtextTest.g:6831:1: ( RULE_ISNOTNULL )
            // InternalXtextTest.g:6832:1: RULE_ISNOTNULL
            {
             before(grammarAccess.getInnerAccess().getIsNotNullISNOTNULLTerminalRuleCall_2_6_0()); 
            match(input,RULE_ISNOTNULL,FOLLOW_2); 
             after(grammarAccess.getInnerAccess().getIsNotNullISNOTNULLTerminalRuleCall_2_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__IsNotNullAssignment_2_6"


    // $ANTLR start "rule__Inner__IsEmptyAssignment_2_7"
    // InternalXtextTest.g:6841:1: rule__Inner__IsEmptyAssignment_2_7 : ( RULE_ISEMPTY ) ;
    public final void rule__Inner__IsEmptyAssignment_2_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6845:1: ( ( RULE_ISEMPTY ) )
            // InternalXtextTest.g:6846:1: ( RULE_ISEMPTY )
            {
            // InternalXtextTest.g:6846:1: ( RULE_ISEMPTY )
            // InternalXtextTest.g:6847:1: RULE_ISEMPTY
            {
             before(grammarAccess.getInnerAccess().getIsEmptyISEMPTYTerminalRuleCall_2_7_0()); 
            match(input,RULE_ISEMPTY,FOLLOW_2); 
             after(grammarAccess.getInnerAccess().getIsEmptyISEMPTYTerminalRuleCall_2_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inner__IsEmptyAssignment_2_7"


    // $ANTLR start "rule__Generator__OutputAssignment_1_3"
    // InternalXtextTest.g:6856:1: rule__Generator__OutputAssignment_1_3 : ( RULE_STRING ) ;
    public final void rule__Generator__OutputAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6860:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6861:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6861:1: ( RULE_STRING )
            // InternalXtextTest.g:6862:1: RULE_STRING
            {
             before(grammarAccess.getGeneratorAccess().getOutputSTRINGTerminalRuleCall_1_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getGeneratorAccess().getOutputSTRINGTerminalRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__OutputAssignment_1_3"


    // $ANTLR start "rule__Generator__ExpectedAssignment_2_2_0_1"
    // InternalXtextTest.g:6871:1: rule__Generator__ExpectedAssignment_2_2_0_1 : ( RULE_STRING ) ;
    public final void rule__Generator__ExpectedAssignment_2_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6875:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6876:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6876:1: ( RULE_STRING )
            // InternalXtextTest.g:6877:1: RULE_STRING
            {
             before(grammarAccess.getGeneratorAccess().getExpectedSTRINGTerminalRuleCall_2_2_0_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getGeneratorAccess().getExpectedSTRINGTerminalRuleCall_2_2_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__ExpectedAssignment_2_2_0_1"


    // $ANTLR start "rule__Generator__IsSameAsInputFileAssignment_2_2_1"
    // InternalXtextTest.g:6886:1: rule__Generator__IsSameAsInputFileAssignment_2_2_1 : ( RULE_ISSAMEASINPUTFILE ) ;
    public final void rule__Generator__IsSameAsInputFileAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6890:1: ( ( RULE_ISSAMEASINPUTFILE ) )
            // InternalXtextTest.g:6891:1: ( RULE_ISSAMEASINPUTFILE )
            {
            // InternalXtextTest.g:6891:1: ( RULE_ISSAMEASINPUTFILE )
            // InternalXtextTest.g:6892:1: RULE_ISSAMEASINPUTFILE
            {
             before(grammarAccess.getGeneratorAccess().getIsSameAsInputFileISSAMEASINPUTFILETerminalRuleCall_2_2_1_0()); 
            match(input,RULE_ISSAMEASINPUTFILE,FOLLOW_2); 
             after(grammarAccess.getGeneratorAccess().getIsSameAsInputFileISSAMEASINPUTFILETerminalRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__IsSameAsInputFileAssignment_2_2_1"


    // $ANTLR start "rule__Generator__PatternFileAssignment_3_1_2"
    // InternalXtextTest.g:6901:1: rule__Generator__PatternFileAssignment_3_1_2 : ( RULE_STRING ) ;
    public final void rule__Generator__PatternFileAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6905:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6906:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6906:1: ( RULE_STRING )
            // InternalXtextTest.g:6907:1: RULE_STRING
            {
             before(grammarAccess.getGeneratorAccess().getPatternFileSTRINGTerminalRuleCall_3_1_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getGeneratorAccess().getPatternFileSTRINGTerminalRuleCall_3_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__PatternFileAssignment_3_1_2"


    // $ANTLR start "rule__Generator__ReplacePatternsAssignment_3_2"
    // InternalXtextTest.g:6916:1: rule__Generator__ReplacePatternsAssignment_3_2 : ( ruleReplacePatterns ) ;
    public final void rule__Generator__ReplacePatternsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6920:1: ( ( ruleReplacePatterns ) )
            // InternalXtextTest.g:6921:1: ( ruleReplacePatterns )
            {
            // InternalXtextTest.g:6921:1: ( ruleReplacePatterns )
            // InternalXtextTest.g:6922:1: ruleReplacePatterns
            {
             before(grammarAccess.getGeneratorAccess().getReplacePatternsReplacePatternsParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_2);
            ruleReplacePatterns();

            state._fsp--;

             after(grammarAccess.getGeneratorAccess().getReplacePatternsReplacePatternsParserRuleCall_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__ReplacePatternsAssignment_3_2"


    // $ANTLR start "rule__Generator__ExceptionAssignment_4_2"
    // InternalXtextTest.g:6931:1: rule__Generator__ExceptionAssignment_4_2 : ( rulePackageID ) ;
    public final void rule__Generator__ExceptionAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6935:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6936:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6936:1: ( rulePackageID )
            // InternalXtextTest.g:6937:1: rulePackageID
            {
             before(grammarAccess.getGeneratorAccess().getExceptionPackageIDParserRuleCall_4_2_0()); 
            pushFollow(FOLLOW_2);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getGeneratorAccess().getExceptionPackageIDParserRuleCall_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Generator__ExceptionAssignment_4_2"


    // $ANTLR start "rule__ReplacePatterns__RegexAssignment_0"
    // InternalXtextTest.g:6946:1: rule__ReplacePatterns__RegexAssignment_0 : ( RULE_STRING ) ;
    public final void rule__ReplacePatterns__RegexAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6950:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6951:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6951:1: ( RULE_STRING )
            // InternalXtextTest.g:6952:1: RULE_STRING
            {
             before(grammarAccess.getReplacePatternsAccess().getRegexSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getReplacePatternsAccess().getRegexSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReplacePatterns__RegexAssignment_0"


    // $ANTLR start "rule__ReplacePatterns__ReplaceAssignment_2"
    // InternalXtextTest.g:6961:1: rule__ReplacePatterns__ReplaceAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ReplacePatterns__ReplaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6965:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6966:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6966:1: ( RULE_STRING )
            // InternalXtextTest.g:6967:1: RULE_STRING
            {
             before(grammarAccess.getReplacePatternsAccess().getReplaceSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getReplacePatternsAccess().getReplaceSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReplacePatterns__ReplaceAssignment_2"


    // $ANTLR start "rule__Before__CodeCallAssignment_2"
    // InternalXtextTest.g:6976:1: rule__Before__CodeCallAssignment_2 : ( ruleCodeCall ) ;
    public final void rule__Before__CodeCallAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6980:1: ( ( ruleCodeCall ) )
            // InternalXtextTest.g:6981:1: ( ruleCodeCall )
            {
            // InternalXtextTest.g:6981:1: ( ruleCodeCall )
            // InternalXtextTest.g:6982:1: ruleCodeCall
            {
             before(grammarAccess.getBeforeAccess().getCodeCallCodeCallParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleCodeCall();

            state._fsp--;

             after(grammarAccess.getBeforeAccess().getCodeCallCodeCallParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Before__CodeCallAssignment_2"


    // $ANTLR start "rule__After__CodeCallAssignment_2"
    // InternalXtextTest.g:6991:1: rule__After__CodeCallAssignment_2 : ( ruleCodeCall ) ;
    public final void rule__After__CodeCallAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6995:1: ( ( ruleCodeCall ) )
            // InternalXtextTest.g:6996:1: ( ruleCodeCall )
            {
            // InternalXtextTest.g:6996:1: ( ruleCodeCall )
            // InternalXtextTest.g:6997:1: ruleCodeCall
            {
             before(grammarAccess.getAfterAccess().getCodeCallCodeCallParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleCodeCall();

            state._fsp--;

             after(grammarAccess.getAfterAccess().getCodeCallCodeCallParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__After__CodeCallAssignment_2"


    // $ANTLR start "rule__CodeCall__MyclassAssignment_3"
    // InternalXtextTest.g:7006:1: rule__CodeCall__MyclassAssignment_3 : ( rulePackageID ) ;
    public final void rule__CodeCall__MyclassAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:7010:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:7011:1: ( rulePackageID )
            {
            // InternalXtextTest.g:7011:1: ( rulePackageID )
            // InternalXtextTest.g:7012:1: rulePackageID
            {
             before(grammarAccess.getCodeCallAccess().getMyclassPackageIDParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getCodeCallAccess().getMyclassPackageIDParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__MyclassAssignment_3"


    // $ANTLR start "rule__CodeCall__MethodAssignment_6"
    // InternalXtextTest.g:7021:1: rule__CodeCall__MethodAssignment_6 : ( rulePackageID ) ;
    public final void rule__CodeCall__MethodAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:7025:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:7026:1: ( rulePackageID )
            {
            // InternalXtextTest.g:7026:1: ( rulePackageID )
            // InternalXtextTest.g:7027:1: rulePackageID
            {
             before(grammarAccess.getCodeCallAccess().getMethodPackageIDParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getCodeCallAccess().getMethodPackageIDParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__MethodAssignment_6"


    // $ANTLR start "rule__CodeCall__ParamsAssignment_7_1_0"
    // InternalXtextTest.g:7036:1: rule__CodeCall__ParamsAssignment_7_1_0 : ( rulePackageID ) ;
    public final void rule__CodeCall__ParamsAssignment_7_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:7040:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:7041:1: ( rulePackageID )
            {
            // InternalXtextTest.g:7041:1: ( rulePackageID )
            // InternalXtextTest.g:7042:1: rulePackageID
            {
             before(grammarAccess.getCodeCallAccess().getParamsPackageIDParserRuleCall_7_1_0_0()); 
            pushFollow(FOLLOW_2);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getCodeCallAccess().getParamsPackageIDParserRuleCall_7_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__ParamsAssignment_7_1_0"


    // $ANTLR start "rule__CodeCall__ParamsAssignment_7_1_1_1"
    // InternalXtextTest.g:7051:1: rule__CodeCall__ParamsAssignment_7_1_1_1 : ( rulePackageID ) ;
    public final void rule__CodeCall__ParamsAssignment_7_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:7055:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:7056:1: ( rulePackageID )
            {
            // InternalXtextTest.g:7056:1: ( rulePackageID )
            // InternalXtextTest.g:7057:1: rulePackageID
            {
             before(grammarAccess.getCodeCallAccess().getParamsPackageIDParserRuleCall_7_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getCodeCallAccess().getParamsPackageIDParserRuleCall_7_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__ParamsAssignment_7_1_1_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020600L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000001401000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000001880000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000002000001200L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000010000000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000010000000012L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00000E0070800800L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000100000000800L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000001000000L});

}