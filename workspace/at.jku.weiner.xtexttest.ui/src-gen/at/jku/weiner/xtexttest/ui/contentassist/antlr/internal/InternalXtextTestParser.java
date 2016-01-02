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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_IDENTIFIER", "RULE_TRUE", "RULE_FALSE", "RULE_PACKAGE", "RULE_LANGUAGE", "RULE_IMPORTS", "RULE_SPLITLEXER", "RULE_ASSIGNASSINGLE", "RULE_KW_EMFTEST", "RULE_DEFAULT", "RULE_OPTIONS", "RULE_SOURCE", "RULE_FILE", "RULE_KW_AS", "RULE_POINT", "RULE_SRCTEXT", "RULE_LEXER", "RULE_ASSIGNASDATALIST", "RULE_LEFTPAREN", "RULE_RIGHTPAREN", "RULE_IMPORTER", "RULE_COMMA", "RULE_ASSIGNASLIST", "RULE_ASSIGNASSTRING", "RULE_ASSIGNASBOOL", "RULE_OUTPUT", "RULE_EXPECTED", "RULE_PATTERNS", "RULE_EXCEPTIONS", "RULE_BEFORE_KW", "RULE_CLASS_KW", "RULE_METHOD_KW", "RULE_AFTER_KW", "RULE_STRING", "RULE_INT", "RULE_ISNULL", "RULE_ISNOTNULL", "RULE_ISEMPTY", "RULE_ISSAMEASINPUTFILE", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=43;
    public static final int RULE_IMPORTER=24;
    public static final int RULE_ANY_OTHER=47;
    public static final int RULE_SPLITLEXER=10;
    public static final int RULE_LANGUAGE=8;
    public static final int RULE_ASSIGNASBOOL=28;
    public static final int EOF=-1;
    public static final int RULE_PACKAGE=7;
    public static final int RULE_FALSE=6;
    public static final int RULE_ASSIGNASSINGLE=11;
    public static final int RULE_KW_EMFTEST=12;
    public static final int RULE_ASSIGNASLIST=26;
    public static final int RULE_POINT=18;
    public static final int RULE_INT=38;
    public static final int RULE_CLASS_KW=34;
    public static final int RULE_ASSIGNASSTRING=27;
    public static final int RULE_OPTIONS=14;
    public static final int RULE_ISSAMEASINPUTFILE=42;
    public static final int RULE_SRCTEXT=19;
    public static final int RULE_IMPORTS=9;
    public static final int RULE_RIGHTPAREN=23;
    public static final int RULE_PATTERNS=31;
    public static final int RULE_METHOD_KW=35;
    public static final int RULE_ASSIGNASDATALIST=21;
    public static final int RULE_EXPECTED=30;
    public static final int RULE_ISNULL=39;
    public static final int RULE_ISEMPTY=41;
    public static final int RULE_FILE=16;
    public static final int RULE_IDENTIFIER=4;
    public static final int RULE_COMMA=25;
    public static final int RULE_AFTER_KW=36;
    public static final int RULE_SL_COMMENT=45;
    public static final int RULE_ISNOTNULL=40;
    public static final int RULE_DEFAULT=13;
    public static final int RULE_ML_COMMENT=44;
    public static final int RULE_TRUE=5;
    public static final int RULE_BEFORE_KW=33;
    public static final int RULE_SOURCE=15;
    public static final int RULE_LEFTPAREN=22;
    public static final int RULE_STRING=37;
    public static final int RULE_EXCEPTIONS=32;
    public static final int RULE_LEXER=20;
    public static final int RULE_OUTPUT=29;
    public static final int RULE_WS=46;
    public static final int RULE_KW_AS=17;

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
    // InternalXtextTest.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalXtextTest.g:62:1: ( ruleModel EOF )
            // InternalXtextTest.g:63:1: ruleModel EOF
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
    // InternalXtextTest.g:70:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:77:7: ( ( ( rule__Model__Group__0 ) ) )
            // InternalXtextTest.g:79:1: ( ( rule__Model__Group__0 ) )
            {
            // InternalXtextTest.g:79:1: ( ( rule__Model__Group__0 ) )
            // InternalXtextTest.g:80:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalXtextTest.g:81:1: ( rule__Model__Group__0 )
            // InternalXtextTest.g:81:2: rule__Model__Group__0
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
    // InternalXtextTest.g:95:1: entryRuleXtextTest : ruleXtextTest EOF ;
    public final void entryRuleXtextTest() throws RecognitionException {
        try {
            // InternalXtextTest.g:96:1: ( ruleXtextTest EOF )
            // InternalXtextTest.g:97:1: ruleXtextTest EOF
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
    // InternalXtextTest.g:104:1: ruleXtextTest : ( ( rule__XtextTest__Group__0 ) ) ;
    public final void ruleXtextTest() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:111:7: ( ( ( rule__XtextTest__Group__0 ) ) )
            // InternalXtextTest.g:113:1: ( ( rule__XtextTest__Group__0 ) )
            {
            // InternalXtextTest.g:113:1: ( ( rule__XtextTest__Group__0 ) )
            // InternalXtextTest.g:114:1: ( rule__XtextTest__Group__0 )
            {
             before(grammarAccess.getXtextTestAccess().getGroup()); 
            // InternalXtextTest.g:115:1: ( rule__XtextTest__Group__0 )
            // InternalXtextTest.g:115:2: rule__XtextTest__Group__0
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
    // InternalXtextTest.g:129:1: entryRuleEmfTest : ruleEmfTest EOF ;
    public final void entryRuleEmfTest() throws RecognitionException {
        try {
            // InternalXtextTest.g:130:1: ( ruleEmfTest EOF )
            // InternalXtextTest.g:131:1: ruleEmfTest EOF
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
    // InternalXtextTest.g:138:1: ruleEmfTest : ( ( rule__EmfTest__Group__0 ) ) ;
    public final void ruleEmfTest() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:145:7: ( ( ( rule__EmfTest__Group__0 ) ) )
            // InternalXtextTest.g:147:1: ( ( rule__EmfTest__Group__0 ) )
            {
            // InternalXtextTest.g:147:1: ( ( rule__EmfTest__Group__0 ) )
            // InternalXtextTest.g:148:1: ( rule__EmfTest__Group__0 )
            {
             before(grammarAccess.getEmfTestAccess().getGroup()); 
            // InternalXtextTest.g:149:1: ( rule__EmfTest__Group__0 )
            // InternalXtextTest.g:149:2: rule__EmfTest__Group__0
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
    // InternalXtextTest.g:163:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalXtextTest.g:164:1: ( ruleImport EOF )
            // InternalXtextTest.g:165:1: ruleImport EOF
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
    // InternalXtextTest.g:172:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:179:7: ( ( ( rule__Import__Group__0 ) ) )
            // InternalXtextTest.g:181:1: ( ( rule__Import__Group__0 ) )
            {
            // InternalXtextTest.g:181:1: ( ( rule__Import__Group__0 ) )
            // InternalXtextTest.g:182:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalXtextTest.g:183:1: ( rule__Import__Group__0 )
            // InternalXtextTest.g:183:2: rule__Import__Group__0
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
    // InternalXtextTest.g:197:1: entryRuleBoolean : ruleBoolean EOF ;
    public final void entryRuleBoolean() throws RecognitionException {
        try {
            // InternalXtextTest.g:198:1: ( ruleBoolean EOF )
            // InternalXtextTest.g:199:1: ruleBoolean EOF
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
    // InternalXtextTest.g:206:1: ruleBoolean : ( ( rule__Boolean__Alternatives ) ) ;
    public final void ruleBoolean() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:213:7: ( ( ( rule__Boolean__Alternatives ) ) )
            // InternalXtextTest.g:215:1: ( ( rule__Boolean__Alternatives ) )
            {
            // InternalXtextTest.g:215:1: ( ( rule__Boolean__Alternatives ) )
            // InternalXtextTest.g:216:1: ( rule__Boolean__Alternatives )
            {
             before(grammarAccess.getBooleanAccess().getAlternatives()); 
            // InternalXtextTest.g:217:1: ( rule__Boolean__Alternatives )
            // InternalXtextTest.g:217:2: rule__Boolean__Alternatives
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
    // InternalXtextTest.g:231:1: entryRulePackageID : rulePackageID EOF ;
    public final void entryRulePackageID() throws RecognitionException {
        try {
            // InternalXtextTest.g:232:1: ( rulePackageID EOF )
            // InternalXtextTest.g:233:1: rulePackageID EOF
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
    // InternalXtextTest.g:240:1: rulePackageID : ( ( rule__PackageID__Group__0 ) ) ;
    public final void rulePackageID() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:247:7: ( ( ( rule__PackageID__Group__0 ) ) )
            // InternalXtextTest.g:249:1: ( ( rule__PackageID__Group__0 ) )
            {
            // InternalXtextTest.g:249:1: ( ( rule__PackageID__Group__0 ) )
            // InternalXtextTest.g:250:1: ( rule__PackageID__Group__0 )
            {
             before(grammarAccess.getPackageIDAccess().getGroup()); 
            // InternalXtextTest.g:251:1: ( rule__PackageID__Group__0 )
            // InternalXtextTest.g:251:2: rule__PackageID__Group__0
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
    // InternalXtextTest.g:265:1: entryRuleLangID : ruleLangID EOF ;
    public final void entryRuleLangID() throws RecognitionException {
        try {
            // InternalXtextTest.g:266:1: ( ruleLangID EOF )
            // InternalXtextTest.g:267:1: ruleLangID EOF
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
    // InternalXtextTest.g:274:1: ruleLangID : ( RULE_IDENTIFIER ) ;
    public final void ruleLangID() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:281:7: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:283:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:283:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:284:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:299:1: entryRuleImportID : ruleImportID EOF ;
    public final void entryRuleImportID() throws RecognitionException {
        try {
            // InternalXtextTest.g:300:1: ( ruleImportID EOF )
            // InternalXtextTest.g:301:1: ruleImportID EOF
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
    // InternalXtextTest.g:308:1: ruleImportID : ( ( rule__ImportID__Group__0 ) ) ;
    public final void ruleImportID() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:315:7: ( ( ( rule__ImportID__Group__0 ) ) )
            // InternalXtextTest.g:317:1: ( ( rule__ImportID__Group__0 ) )
            {
            // InternalXtextTest.g:317:1: ( ( rule__ImportID__Group__0 ) )
            // InternalXtextTest.g:318:1: ( rule__ImportID__Group__0 )
            {
             before(grammarAccess.getImportIDAccess().getGroup()); 
            // InternalXtextTest.g:319:1: ( rule__ImportID__Group__0 )
            // InternalXtextTest.g:319:2: rule__ImportID__Group__0
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
    // InternalXtextTest.g:333:1: entryRuleInput : ruleInput EOF ;
    public final void entryRuleInput() throws RecognitionException {
        try {
            // InternalXtextTest.g:334:1: ( ruleInput EOF )
            // InternalXtextTest.g:335:1: ruleInput EOF
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
    // InternalXtextTest.g:342:1: ruleInput : ( ( rule__Input__Group__0 ) ) ;
    public final void ruleInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:349:7: ( ( ( rule__Input__Group__0 ) ) )
            // InternalXtextTest.g:351:1: ( ( rule__Input__Group__0 ) )
            {
            // InternalXtextTest.g:351:1: ( ( rule__Input__Group__0 ) )
            // InternalXtextTest.g:352:1: ( rule__Input__Group__0 )
            {
             before(grammarAccess.getInputAccess().getGroup()); 
            // InternalXtextTest.g:353:1: ( rule__Input__Group__0 )
            // InternalXtextTest.g:353:2: rule__Input__Group__0
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
    // InternalXtextTest.g:367:1: entryRuleTokens : ruleTokens EOF ;
    public final void entryRuleTokens() throws RecognitionException {
        try {
            // InternalXtextTest.g:368:1: ( ruleTokens EOF )
            // InternalXtextTest.g:369:1: ruleTokens EOF
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
    // InternalXtextTest.g:376:1: ruleTokens : ( ( rule__Tokens__Group__0 ) ) ;
    public final void ruleTokens() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:383:7: ( ( ( rule__Tokens__Group__0 ) ) )
            // InternalXtextTest.g:385:1: ( ( rule__Tokens__Group__0 ) )
            {
            // InternalXtextTest.g:385:1: ( ( rule__Tokens__Group__0 ) )
            // InternalXtextTest.g:386:1: ( rule__Tokens__Group__0 )
            {
             before(grammarAccess.getTokensAccess().getGroup()); 
            // InternalXtextTest.g:387:1: ( rule__Tokens__Group__0 )
            // InternalXtextTest.g:387:2: rule__Tokens__Group__0
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
    // InternalXtextTest.g:401:1: entryRuleMyTokens : ruleMyTokens EOF ;
    public final void entryRuleMyTokens() throws RecognitionException {
        try {
            // InternalXtextTest.g:402:1: ( ruleMyTokens EOF )
            // InternalXtextTest.g:403:1: ruleMyTokens EOF
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
    // InternalXtextTest.g:410:1: ruleMyTokens : ( ( rule__MyTokens__Group__0 ) ) ;
    public final void ruleMyTokens() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:417:7: ( ( ( rule__MyTokens__Group__0 ) ) )
            // InternalXtextTest.g:419:1: ( ( rule__MyTokens__Group__0 ) )
            {
            // InternalXtextTest.g:419:1: ( ( rule__MyTokens__Group__0 ) )
            // InternalXtextTest.g:420:1: ( rule__MyTokens__Group__0 )
            {
             before(grammarAccess.getMyTokensAccess().getGroup()); 
            // InternalXtextTest.g:421:1: ( rule__MyTokens__Group__0 )
            // InternalXtextTest.g:421:2: rule__MyTokens__Group__0
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
    // InternalXtextTest.g:435:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalXtextTest.g:436:1: ( ruleElement EOF )
            // InternalXtextTest.g:437:1: ruleElement EOF
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
    // InternalXtextTest.g:444:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:451:7: ( ( ( rule__Element__Group__0 ) ) )
            // InternalXtextTest.g:453:1: ( ( rule__Element__Group__0 ) )
            {
            // InternalXtextTest.g:453:1: ( ( rule__Element__Group__0 ) )
            // InternalXtextTest.g:454:1: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // InternalXtextTest.g:455:1: ( rule__Element__Group__0 )
            // InternalXtextTest.g:455:2: rule__Element__Group__0
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
    // InternalXtextTest.g:469:1: entryRuleInner : ruleInner EOF ;
    public final void entryRuleInner() throws RecognitionException {
        try {
            // InternalXtextTest.g:470:1: ( ruleInner EOF )
            // InternalXtextTest.g:471:1: ruleInner EOF
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
    // InternalXtextTest.g:478:1: ruleInner : ( ( rule__Inner__Group__0 ) ) ;
    public final void ruleInner() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:485:7: ( ( ( rule__Inner__Group__0 ) ) )
            // InternalXtextTest.g:487:1: ( ( rule__Inner__Group__0 ) )
            {
            // InternalXtextTest.g:487:1: ( ( rule__Inner__Group__0 ) )
            // InternalXtextTest.g:488:1: ( rule__Inner__Group__0 )
            {
             before(grammarAccess.getInnerAccess().getGroup()); 
            // InternalXtextTest.g:489:1: ( rule__Inner__Group__0 )
            // InternalXtextTest.g:489:2: rule__Inner__Group__0
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
    // InternalXtextTest.g:503:1: entryRuleGenerator : ruleGenerator EOF ;
    public final void entryRuleGenerator() throws RecognitionException {
        try {
            // InternalXtextTest.g:504:1: ( ruleGenerator EOF )
            // InternalXtextTest.g:505:1: ruleGenerator EOF
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
    // InternalXtextTest.g:512:1: ruleGenerator : ( ( rule__Generator__Group__0 ) ) ;
    public final void ruleGenerator() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:519:7: ( ( ( rule__Generator__Group__0 ) ) )
            // InternalXtextTest.g:521:1: ( ( rule__Generator__Group__0 ) )
            {
            // InternalXtextTest.g:521:1: ( ( rule__Generator__Group__0 ) )
            // InternalXtextTest.g:522:1: ( rule__Generator__Group__0 )
            {
             before(grammarAccess.getGeneratorAccess().getGroup()); 
            // InternalXtextTest.g:523:1: ( rule__Generator__Group__0 )
            // InternalXtextTest.g:523:2: rule__Generator__Group__0
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
    // InternalXtextTest.g:537:1: entryRuleReplacePatterns : ruleReplacePatterns EOF ;
    public final void entryRuleReplacePatterns() throws RecognitionException {
        try {
            // InternalXtextTest.g:538:1: ( ruleReplacePatterns EOF )
            // InternalXtextTest.g:539:1: ruleReplacePatterns EOF
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
    // InternalXtextTest.g:546:1: ruleReplacePatterns : ( ( rule__ReplacePatterns__Group__0 ) ) ;
    public final void ruleReplacePatterns() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:553:7: ( ( ( rule__ReplacePatterns__Group__0 ) ) )
            // InternalXtextTest.g:555:1: ( ( rule__ReplacePatterns__Group__0 ) )
            {
            // InternalXtextTest.g:555:1: ( ( rule__ReplacePatterns__Group__0 ) )
            // InternalXtextTest.g:556:1: ( rule__ReplacePatterns__Group__0 )
            {
             before(grammarAccess.getReplacePatternsAccess().getGroup()); 
            // InternalXtextTest.g:557:1: ( rule__ReplacePatterns__Group__0 )
            // InternalXtextTest.g:557:2: rule__ReplacePatterns__Group__0
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
    // InternalXtextTest.g:571:1: entryRuleBefore : ruleBefore EOF ;
    public final void entryRuleBefore() throws RecognitionException {
        try {
            // InternalXtextTest.g:572:1: ( ruleBefore EOF )
            // InternalXtextTest.g:573:1: ruleBefore EOF
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
    // InternalXtextTest.g:580:1: ruleBefore : ( ( rule__Before__Group__0 ) ) ;
    public final void ruleBefore() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:587:7: ( ( ( rule__Before__Group__0 ) ) )
            // InternalXtextTest.g:589:1: ( ( rule__Before__Group__0 ) )
            {
            // InternalXtextTest.g:589:1: ( ( rule__Before__Group__0 ) )
            // InternalXtextTest.g:590:1: ( rule__Before__Group__0 )
            {
             before(grammarAccess.getBeforeAccess().getGroup()); 
            // InternalXtextTest.g:591:1: ( rule__Before__Group__0 )
            // InternalXtextTest.g:591:2: rule__Before__Group__0
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
    // InternalXtextTest.g:605:1: entryRuleAfter : ruleAfter EOF ;
    public final void entryRuleAfter() throws RecognitionException {
        try {
            // InternalXtextTest.g:606:1: ( ruleAfter EOF )
            // InternalXtextTest.g:607:1: ruleAfter EOF
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
    // InternalXtextTest.g:614:1: ruleAfter : ( ( rule__After__Group__0 ) ) ;
    public final void ruleAfter() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:621:7: ( ( ( rule__After__Group__0 ) ) )
            // InternalXtextTest.g:623:1: ( ( rule__After__Group__0 ) )
            {
            // InternalXtextTest.g:623:1: ( ( rule__After__Group__0 ) )
            // InternalXtextTest.g:624:1: ( rule__After__Group__0 )
            {
             before(grammarAccess.getAfterAccess().getGroup()); 
            // InternalXtextTest.g:625:1: ( rule__After__Group__0 )
            // InternalXtextTest.g:625:2: rule__After__Group__0
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
    // InternalXtextTest.g:639:1: entryRuleCodeCall : ruleCodeCall EOF ;
    public final void entryRuleCodeCall() throws RecognitionException {
        try {
            // InternalXtextTest.g:640:1: ( ruleCodeCall EOF )
            // InternalXtextTest.g:641:1: ruleCodeCall EOF
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
    // InternalXtextTest.g:648:1: ruleCodeCall : ( ( rule__CodeCall__Group__0 ) ) ;
    public final void ruleCodeCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:655:7: ( ( ( rule__CodeCall__Group__0 ) ) )
            // InternalXtextTest.g:657:1: ( ( rule__CodeCall__Group__0 ) )
            {
            // InternalXtextTest.g:657:1: ( ( rule__CodeCall__Group__0 ) )
            // InternalXtextTest.g:658:1: ( rule__CodeCall__Group__0 )
            {
             before(grammarAccess.getCodeCallAccess().getGroup()); 
            // InternalXtextTest.g:659:1: ( rule__CodeCall__Group__0 )
            // InternalXtextTest.g:659:2: rule__CodeCall__Group__0
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
    // InternalXtextTest.g:673:1: rule__Model__Alternatives_1 : ( ( ( rule__Model__XtextTestAssignment_1_0 ) ) | ( ( rule__Model__EmfTestAssignment_1_1 ) ) );
    public final void rule__Model__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:677:1: ( ( ( rule__Model__XtextTestAssignment_1_0 ) ) | ( ( rule__Model__EmfTestAssignment_1_1 ) ) )
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
                    // InternalXtextTest.g:679:1: ( ( rule__Model__XtextTestAssignment_1_0 ) )
                    {
                    // InternalXtextTest.g:679:1: ( ( rule__Model__XtextTestAssignment_1_0 ) )
                    // InternalXtextTest.g:680:1: ( rule__Model__XtextTestAssignment_1_0 )
                    {
                     before(grammarAccess.getModelAccess().getXtextTestAssignment_1_0()); 
                    // InternalXtextTest.g:681:1: ( rule__Model__XtextTestAssignment_1_0 )
                    // InternalXtextTest.g:681:2: rule__Model__XtextTestAssignment_1_0
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
                    // InternalXtextTest.g:688:1: ( ( rule__Model__EmfTestAssignment_1_1 ) )
                    {
                    // InternalXtextTest.g:688:1: ( ( rule__Model__EmfTestAssignment_1_1 ) )
                    // InternalXtextTest.g:689:1: ( rule__Model__EmfTestAssignment_1_1 )
                    {
                     before(grammarAccess.getModelAccess().getEmfTestAssignment_1_1()); 
                    // InternalXtextTest.g:690:1: ( rule__Model__EmfTestAssignment_1_1 )
                    // InternalXtextTest.g:690:2: rule__Model__EmfTestAssignment_1_1
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
    // InternalXtextTest.g:701:1: rule__Boolean__Alternatives : ( ( RULE_TRUE ) | ( RULE_FALSE ) );
    public final void rule__Boolean__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:705:1: ( ( RULE_TRUE ) | ( RULE_FALSE ) )
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
                    // InternalXtextTest.g:707:1: ( RULE_TRUE )
                    {
                    // InternalXtextTest.g:707:1: ( RULE_TRUE )
                    // InternalXtextTest.g:708:1: RULE_TRUE
                    {
                     before(grammarAccess.getBooleanAccess().getTRUETerminalRuleCall_0()); 
                    match(input,RULE_TRUE,FOLLOW_2); 
                     after(grammarAccess.getBooleanAccess().getTRUETerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:716:1: ( RULE_FALSE )
                    {
                    // InternalXtextTest.g:716:1: ( RULE_FALSE )
                    // InternalXtextTest.g:717:1: RULE_FALSE
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
    // InternalXtextTest.g:729:1: rule__Input__Alternatives_2 : ( ( ( rule__Input__Group_2_0__0 ) ) | ( ( rule__Input__Group_2_1__0 ) ) );
    public final void rule__Input__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:733:1: ( ( ( rule__Input__Group_2_0__0 ) ) | ( ( rule__Input__Group_2_1__0 ) ) )
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
                    // InternalXtextTest.g:735:1: ( ( rule__Input__Group_2_0__0 ) )
                    {
                    // InternalXtextTest.g:735:1: ( ( rule__Input__Group_2_0__0 ) )
                    // InternalXtextTest.g:736:1: ( rule__Input__Group_2_0__0 )
                    {
                     before(grammarAccess.getInputAccess().getGroup_2_0()); 
                    // InternalXtextTest.g:737:1: ( rule__Input__Group_2_0__0 )
                    // InternalXtextTest.g:737:2: rule__Input__Group_2_0__0
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
                    // InternalXtextTest.g:744:1: ( ( rule__Input__Group_2_1__0 ) )
                    {
                    // InternalXtextTest.g:744:1: ( ( rule__Input__Group_2_1__0 ) )
                    // InternalXtextTest.g:745:1: ( rule__Input__Group_2_1__0 )
                    {
                     before(grammarAccess.getInputAccess().getGroup_2_1()); 
                    // InternalXtextTest.g:746:1: ( rule__Input__Group_2_1__0 )
                    // InternalXtextTest.g:746:2: rule__Input__Group_2_1__0
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


    // $ANTLR start "rule__Inner__Alternatives_2"
    // InternalXtextTest.g:757:1: rule__Inner__Alternatives_2 : ( ( ( rule__Inner__Group_2_0__0 ) ) | ( ( rule__Inner__Group_2_1__0 ) ) | ( ( rule__Inner__Group_2_2__0 ) ) | ( ( rule__Inner__Group_2_3__0 ) ) | ( ( rule__Inner__Group_2_4__0 ) ) | ( ( rule__Inner__IsNullAssignment_2_5 ) ) | ( ( rule__Inner__IsNotNullAssignment_2_6 ) ) | ( ( rule__Inner__IsEmptyAssignment_2_7 ) ) );
    public final void rule__Inner__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:761:1: ( ( ( rule__Inner__Group_2_0__0 ) ) | ( ( rule__Inner__Group_2_1__0 ) ) | ( ( rule__Inner__Group_2_2__0 ) ) | ( ( rule__Inner__Group_2_3__0 ) ) | ( ( rule__Inner__Group_2_4__0 ) ) | ( ( rule__Inner__IsNullAssignment_2_5 ) ) | ( ( rule__Inner__IsNotNullAssignment_2_6 ) ) | ( ( rule__Inner__IsEmptyAssignment_2_7 ) ) )
            int alt4=8;
            switch ( input.LA(1) ) {
            case RULE_ASSIGNASSINGLE:
                {
                alt4=1;
                }
                break;
            case RULE_ASSIGNASLIST:
                {
                alt4=2;
                }
                break;
            case RULE_ASSIGNASSTRING:
                {
                alt4=3;
                }
                break;
            case RULE_ASSIGNASDATALIST:
                {
                alt4=4;
                }
                break;
            case RULE_ASSIGNASBOOL:
                {
                alt4=5;
                }
                break;
            case RULE_ISNULL:
                {
                alt4=6;
                }
                break;
            case RULE_ISNOTNULL:
                {
                alt4=7;
                }
                break;
            case RULE_ISEMPTY:
                {
                alt4=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalXtextTest.g:763:1: ( ( rule__Inner__Group_2_0__0 ) )
                    {
                    // InternalXtextTest.g:763:1: ( ( rule__Inner__Group_2_0__0 ) )
                    // InternalXtextTest.g:764:1: ( rule__Inner__Group_2_0__0 )
                    {
                     before(grammarAccess.getInnerAccess().getGroup_2_0()); 
                    // InternalXtextTest.g:765:1: ( rule__Inner__Group_2_0__0 )
                    // InternalXtextTest.g:765:2: rule__Inner__Group_2_0__0
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
                    // InternalXtextTest.g:772:1: ( ( rule__Inner__Group_2_1__0 ) )
                    {
                    // InternalXtextTest.g:772:1: ( ( rule__Inner__Group_2_1__0 ) )
                    // InternalXtextTest.g:773:1: ( rule__Inner__Group_2_1__0 )
                    {
                     before(grammarAccess.getInnerAccess().getGroup_2_1()); 
                    // InternalXtextTest.g:774:1: ( rule__Inner__Group_2_1__0 )
                    // InternalXtextTest.g:774:2: rule__Inner__Group_2_1__0
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
                    // InternalXtextTest.g:781:1: ( ( rule__Inner__Group_2_2__0 ) )
                    {
                    // InternalXtextTest.g:781:1: ( ( rule__Inner__Group_2_2__0 ) )
                    // InternalXtextTest.g:782:1: ( rule__Inner__Group_2_2__0 )
                    {
                     before(grammarAccess.getInnerAccess().getGroup_2_2()); 
                    // InternalXtextTest.g:783:1: ( rule__Inner__Group_2_2__0 )
                    // InternalXtextTest.g:783:2: rule__Inner__Group_2_2__0
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
                    // InternalXtextTest.g:790:1: ( ( rule__Inner__Group_2_3__0 ) )
                    {
                    // InternalXtextTest.g:790:1: ( ( rule__Inner__Group_2_3__0 ) )
                    // InternalXtextTest.g:791:1: ( rule__Inner__Group_2_3__0 )
                    {
                     before(grammarAccess.getInnerAccess().getGroup_2_3()); 
                    // InternalXtextTest.g:792:1: ( rule__Inner__Group_2_3__0 )
                    // InternalXtextTest.g:792:2: rule__Inner__Group_2_3__0
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
                    // InternalXtextTest.g:799:1: ( ( rule__Inner__Group_2_4__0 ) )
                    {
                    // InternalXtextTest.g:799:1: ( ( rule__Inner__Group_2_4__0 ) )
                    // InternalXtextTest.g:800:1: ( rule__Inner__Group_2_4__0 )
                    {
                     before(grammarAccess.getInnerAccess().getGroup_2_4()); 
                    // InternalXtextTest.g:801:1: ( rule__Inner__Group_2_4__0 )
                    // InternalXtextTest.g:801:2: rule__Inner__Group_2_4__0
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
                    // InternalXtextTest.g:808:1: ( ( rule__Inner__IsNullAssignment_2_5 ) )
                    {
                    // InternalXtextTest.g:808:1: ( ( rule__Inner__IsNullAssignment_2_5 ) )
                    // InternalXtextTest.g:809:1: ( rule__Inner__IsNullAssignment_2_5 )
                    {
                     before(grammarAccess.getInnerAccess().getIsNullAssignment_2_5()); 
                    // InternalXtextTest.g:810:1: ( rule__Inner__IsNullAssignment_2_5 )
                    // InternalXtextTest.g:810:2: rule__Inner__IsNullAssignment_2_5
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
                    // InternalXtextTest.g:817:1: ( ( rule__Inner__IsNotNullAssignment_2_6 ) )
                    {
                    // InternalXtextTest.g:817:1: ( ( rule__Inner__IsNotNullAssignment_2_6 ) )
                    // InternalXtextTest.g:818:1: ( rule__Inner__IsNotNullAssignment_2_6 )
                    {
                     before(grammarAccess.getInnerAccess().getIsNotNullAssignment_2_6()); 
                    // InternalXtextTest.g:819:1: ( rule__Inner__IsNotNullAssignment_2_6 )
                    // InternalXtextTest.g:819:2: rule__Inner__IsNotNullAssignment_2_6
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
                    // InternalXtextTest.g:826:1: ( ( rule__Inner__IsEmptyAssignment_2_7 ) )
                    {
                    // InternalXtextTest.g:826:1: ( ( rule__Inner__IsEmptyAssignment_2_7 ) )
                    // InternalXtextTest.g:827:1: ( rule__Inner__IsEmptyAssignment_2_7 )
                    {
                     before(grammarAccess.getInnerAccess().getIsEmptyAssignment_2_7()); 
                    // InternalXtextTest.g:828:1: ( rule__Inner__IsEmptyAssignment_2_7 )
                    // InternalXtextTest.g:828:2: rule__Inner__IsEmptyAssignment_2_7
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
    // InternalXtextTest.g:839:1: rule__Inner__AssignAsBoolAlternatives_2_4_1_0 : ( ( RULE_TRUE ) | ( RULE_FALSE ) );
    public final void rule__Inner__AssignAsBoolAlternatives_2_4_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:843:1: ( ( RULE_TRUE ) | ( RULE_FALSE ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_TRUE) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_FALSE) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalXtextTest.g:845:1: ( RULE_TRUE )
                    {
                    // InternalXtextTest.g:845:1: ( RULE_TRUE )
                    // InternalXtextTest.g:846:1: RULE_TRUE
                    {
                     before(grammarAccess.getInnerAccess().getAssignAsBoolTRUETerminalRuleCall_2_4_1_0_0()); 
                    match(input,RULE_TRUE,FOLLOW_2); 
                     after(grammarAccess.getInnerAccess().getAssignAsBoolTRUETerminalRuleCall_2_4_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:854:1: ( RULE_FALSE )
                    {
                    // InternalXtextTest.g:854:1: ( RULE_FALSE )
                    // InternalXtextTest.g:855:1: RULE_FALSE
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
    // InternalXtextTest.g:867:1: rule__Generator__Alternatives_2_2 : ( ( ( rule__Generator__Group_2_2_0__0 ) ) | ( ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 ) ) );
    public final void rule__Generator__Alternatives_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:871:1: ( ( ( rule__Generator__Group_2_2_0__0 ) ) | ( ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ASSIGNASSINGLE) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ISSAMEASINPUTFILE) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalXtextTest.g:873:1: ( ( rule__Generator__Group_2_2_0__0 ) )
                    {
                    // InternalXtextTest.g:873:1: ( ( rule__Generator__Group_2_2_0__0 ) )
                    // InternalXtextTest.g:874:1: ( rule__Generator__Group_2_2_0__0 )
                    {
                     before(grammarAccess.getGeneratorAccess().getGroup_2_2_0()); 
                    // InternalXtextTest.g:875:1: ( rule__Generator__Group_2_2_0__0 )
                    // InternalXtextTest.g:875:2: rule__Generator__Group_2_2_0__0
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
                    // InternalXtextTest.g:882:1: ( ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 ) )
                    {
                    // InternalXtextTest.g:882:1: ( ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 ) )
                    // InternalXtextTest.g:883:1: ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 )
                    {
                     before(grammarAccess.getGeneratorAccess().getIsSameAsInputFileAssignment_2_2_1()); 
                    // InternalXtextTest.g:884:1: ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 )
                    // InternalXtextTest.g:884:2: rule__Generator__IsSameAsInputFileAssignment_2_2_1
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
    // InternalXtextTest.g:897:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:901:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalXtextTest.g:902:2: rule__Model__Group__0__Impl rule__Model__Group__1
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
    // InternalXtextTest.g:909:1: rule__Model__Group__0__Impl : ( () ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:913:1: ( ( () ) )
            // InternalXtextTest.g:915:1: ( () )
            {
            // InternalXtextTest.g:915:1: ( () )
            // InternalXtextTest.g:916:1: ()
            {
             before(grammarAccess.getModelAccess().getModelAction_0()); 
            // InternalXtextTest.g:917:1: ()
            // InternalXtextTest.g:919:1: 
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
    // InternalXtextTest.g:931:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:935:1: ( rule__Model__Group__1__Impl )
            // InternalXtextTest.g:936:2: rule__Model__Group__1__Impl
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
    // InternalXtextTest.g:942:1: rule__Model__Group__1__Impl : ( ( rule__Model__Alternatives_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:946:1: ( ( ( rule__Model__Alternatives_1 ) ) )
            // InternalXtextTest.g:948:1: ( ( rule__Model__Alternatives_1 ) )
            {
            // InternalXtextTest.g:948:1: ( ( rule__Model__Alternatives_1 ) )
            // InternalXtextTest.g:949:1: ( rule__Model__Alternatives_1 )
            {
             before(grammarAccess.getModelAccess().getAlternatives_1()); 
            // InternalXtextTest.g:950:1: ( rule__Model__Alternatives_1 )
            // InternalXtextTest.g:950:2: rule__Model__Alternatives_1
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
    // InternalXtextTest.g:966:1: rule__XtextTest__Group__0 : rule__XtextTest__Group__0__Impl rule__XtextTest__Group__1 ;
    public final void rule__XtextTest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:970:1: ( rule__XtextTest__Group__0__Impl rule__XtextTest__Group__1 )
            // InternalXtextTest.g:971:2: rule__XtextTest__Group__0__Impl rule__XtextTest__Group__1
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
    // InternalXtextTest.g:978:1: rule__XtextTest__Group__0__Impl : ( () ) ;
    public final void rule__XtextTest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:982:1: ( ( () ) )
            // InternalXtextTest.g:984:1: ( () )
            {
            // InternalXtextTest.g:984:1: ( () )
            // InternalXtextTest.g:985:1: ()
            {
             before(grammarAccess.getXtextTestAccess().getXtextTestAction_0()); 
            // InternalXtextTest.g:986:1: ()
            // InternalXtextTest.g:988:1: 
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
    // InternalXtextTest.g:1000:1: rule__XtextTest__Group__1 : rule__XtextTest__Group__1__Impl rule__XtextTest__Group__2 ;
    public final void rule__XtextTest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1004:1: ( rule__XtextTest__Group__1__Impl rule__XtextTest__Group__2 )
            // InternalXtextTest.g:1005:2: rule__XtextTest__Group__1__Impl rule__XtextTest__Group__2
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
    // InternalXtextTest.g:1012:1: rule__XtextTest__Group__1__Impl : ( RULE_PACKAGE ) ;
    public final void rule__XtextTest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1016:1: ( ( RULE_PACKAGE ) )
            // InternalXtextTest.g:1018:1: ( RULE_PACKAGE )
            {
            // InternalXtextTest.g:1018:1: ( RULE_PACKAGE )
            // InternalXtextTest.g:1019:1: RULE_PACKAGE
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
    // InternalXtextTest.g:1032:1: rule__XtextTest__Group__2 : rule__XtextTest__Group__2__Impl rule__XtextTest__Group__3 ;
    public final void rule__XtextTest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1036:1: ( rule__XtextTest__Group__2__Impl rule__XtextTest__Group__3 )
            // InternalXtextTest.g:1037:2: rule__XtextTest__Group__2__Impl rule__XtextTest__Group__3
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
    // InternalXtextTest.g:1044:1: rule__XtextTest__Group__2__Impl : ( ( rule__XtextTest__PackageAssignment_2 ) ) ;
    public final void rule__XtextTest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1048:1: ( ( ( rule__XtextTest__PackageAssignment_2 ) ) )
            // InternalXtextTest.g:1050:1: ( ( rule__XtextTest__PackageAssignment_2 ) )
            {
            // InternalXtextTest.g:1050:1: ( ( rule__XtextTest__PackageAssignment_2 ) )
            // InternalXtextTest.g:1051:1: ( rule__XtextTest__PackageAssignment_2 )
            {
             before(grammarAccess.getXtextTestAccess().getPackageAssignment_2()); 
            // InternalXtextTest.g:1052:1: ( rule__XtextTest__PackageAssignment_2 )
            // InternalXtextTest.g:1052:2: rule__XtextTest__PackageAssignment_2
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
    // InternalXtextTest.g:1064:1: rule__XtextTest__Group__3 : rule__XtextTest__Group__3__Impl rule__XtextTest__Group__4 ;
    public final void rule__XtextTest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1068:1: ( rule__XtextTest__Group__3__Impl rule__XtextTest__Group__4 )
            // InternalXtextTest.g:1069:2: rule__XtextTest__Group__3__Impl rule__XtextTest__Group__4
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
    // InternalXtextTest.g:1076:1: rule__XtextTest__Group__3__Impl : ( RULE_LANGUAGE ) ;
    public final void rule__XtextTest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1080:1: ( ( RULE_LANGUAGE ) )
            // InternalXtextTest.g:1082:1: ( RULE_LANGUAGE )
            {
            // InternalXtextTest.g:1082:1: ( RULE_LANGUAGE )
            // InternalXtextTest.g:1083:1: RULE_LANGUAGE
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
    // InternalXtextTest.g:1096:1: rule__XtextTest__Group__4 : rule__XtextTest__Group__4__Impl rule__XtextTest__Group__5 ;
    public final void rule__XtextTest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1100:1: ( rule__XtextTest__Group__4__Impl rule__XtextTest__Group__5 )
            // InternalXtextTest.g:1101:2: rule__XtextTest__Group__4__Impl rule__XtextTest__Group__5
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
    // InternalXtextTest.g:1108:1: rule__XtextTest__Group__4__Impl : ( ( rule__XtextTest__LangAssignment_4 ) ) ;
    public final void rule__XtextTest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1112:1: ( ( ( rule__XtextTest__LangAssignment_4 ) ) )
            // InternalXtextTest.g:1114:1: ( ( rule__XtextTest__LangAssignment_4 ) )
            {
            // InternalXtextTest.g:1114:1: ( ( rule__XtextTest__LangAssignment_4 ) )
            // InternalXtextTest.g:1115:1: ( rule__XtextTest__LangAssignment_4 )
            {
             before(grammarAccess.getXtextTestAccess().getLangAssignment_4()); 
            // InternalXtextTest.g:1116:1: ( rule__XtextTest__LangAssignment_4 )
            // InternalXtextTest.g:1116:2: rule__XtextTest__LangAssignment_4
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
    // InternalXtextTest.g:1128:1: rule__XtextTest__Group__5 : rule__XtextTest__Group__5__Impl rule__XtextTest__Group__6 ;
    public final void rule__XtextTest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1132:1: ( rule__XtextTest__Group__5__Impl rule__XtextTest__Group__6 )
            // InternalXtextTest.g:1133:2: rule__XtextTest__Group__5__Impl rule__XtextTest__Group__6
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
    // InternalXtextTest.g:1140:1: rule__XtextTest__Group__5__Impl : ( ( rule__XtextTest__Group_5__0 )? ) ;
    public final void rule__XtextTest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1144:1: ( ( ( rule__XtextTest__Group_5__0 )? ) )
            // InternalXtextTest.g:1146:1: ( ( rule__XtextTest__Group_5__0 )? )
            {
            // InternalXtextTest.g:1146:1: ( ( rule__XtextTest__Group_5__0 )? )
            // InternalXtextTest.g:1147:1: ( rule__XtextTest__Group_5__0 )?
            {
             before(grammarAccess.getXtextTestAccess().getGroup_5()); 
            // InternalXtextTest.g:1148:1: ( rule__XtextTest__Group_5__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_IMPORTS) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalXtextTest.g:1148:2: rule__XtextTest__Group_5__0
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
    // InternalXtextTest.g:1160:1: rule__XtextTest__Group__6 : rule__XtextTest__Group__6__Impl rule__XtextTest__Group__7 ;
    public final void rule__XtextTest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1164:1: ( rule__XtextTest__Group__6__Impl rule__XtextTest__Group__7 )
            // InternalXtextTest.g:1165:2: rule__XtextTest__Group__6__Impl rule__XtextTest__Group__7
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
    // InternalXtextTest.g:1172:1: rule__XtextTest__Group__6__Impl : ( ( rule__XtextTest__Group_6__0 )? ) ;
    public final void rule__XtextTest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1176:1: ( ( ( rule__XtextTest__Group_6__0 )? ) )
            // InternalXtextTest.g:1178:1: ( ( rule__XtextTest__Group_6__0 )? )
            {
            // InternalXtextTest.g:1178:1: ( ( rule__XtextTest__Group_6__0 )? )
            // InternalXtextTest.g:1179:1: ( rule__XtextTest__Group_6__0 )?
            {
             before(grammarAccess.getXtextTestAccess().getGroup_6()); 
            // InternalXtextTest.g:1180:1: ( rule__XtextTest__Group_6__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_SPLITLEXER) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalXtextTest.g:1180:2: rule__XtextTest__Group_6__0
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
    // InternalXtextTest.g:1192:1: rule__XtextTest__Group__7 : rule__XtextTest__Group__7__Impl rule__XtextTest__Group__8 ;
    public final void rule__XtextTest__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1196:1: ( rule__XtextTest__Group__7__Impl rule__XtextTest__Group__8 )
            // InternalXtextTest.g:1197:2: rule__XtextTest__Group__7__Impl rule__XtextTest__Group__8
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
    // InternalXtextTest.g:1204:1: rule__XtextTest__Group__7__Impl : ( ( rule__XtextTest__InputAssignment_7 ) ) ;
    public final void rule__XtextTest__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1208:1: ( ( ( rule__XtextTest__InputAssignment_7 ) ) )
            // InternalXtextTest.g:1210:1: ( ( rule__XtextTest__InputAssignment_7 ) )
            {
            // InternalXtextTest.g:1210:1: ( ( rule__XtextTest__InputAssignment_7 ) )
            // InternalXtextTest.g:1211:1: ( rule__XtextTest__InputAssignment_7 )
            {
             before(grammarAccess.getXtextTestAccess().getInputAssignment_7()); 
            // InternalXtextTest.g:1212:1: ( rule__XtextTest__InputAssignment_7 )
            // InternalXtextTest.g:1212:2: rule__XtextTest__InputAssignment_7
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
    // InternalXtextTest.g:1224:1: rule__XtextTest__Group__8 : rule__XtextTest__Group__8__Impl rule__XtextTest__Group__9 ;
    public final void rule__XtextTest__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1228:1: ( rule__XtextTest__Group__8__Impl rule__XtextTest__Group__9 )
            // InternalXtextTest.g:1229:2: rule__XtextTest__Group__8__Impl rule__XtextTest__Group__9
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
    // InternalXtextTest.g:1236:1: rule__XtextTest__Group__8__Impl : ( ( rule__XtextTest__TokensAssignment_8 )? ) ;
    public final void rule__XtextTest__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1240:1: ( ( ( rule__XtextTest__TokensAssignment_8 )? ) )
            // InternalXtextTest.g:1242:1: ( ( rule__XtextTest__TokensAssignment_8 )? )
            {
            // InternalXtextTest.g:1242:1: ( ( rule__XtextTest__TokensAssignment_8 )? )
            // InternalXtextTest.g:1243:1: ( rule__XtextTest__TokensAssignment_8 )?
            {
             before(grammarAccess.getXtextTestAccess().getTokensAssignment_8()); 
            // InternalXtextTest.g:1244:1: ( rule__XtextTest__TokensAssignment_8 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_LEXER) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalXtextTest.g:1244:2: rule__XtextTest__TokensAssignment_8
                    {
                    pushFollow(FOLLOW_2);
                    rule__XtextTest__TokensAssignment_8();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXtextTestAccess().getTokensAssignment_8()); 

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
    // InternalXtextTest.g:1256:1: rule__XtextTest__Group__9 : rule__XtextTest__Group__9__Impl rule__XtextTest__Group__10 ;
    public final void rule__XtextTest__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1260:1: ( rule__XtextTest__Group__9__Impl rule__XtextTest__Group__10 )
            // InternalXtextTest.g:1261:2: rule__XtextTest__Group__9__Impl rule__XtextTest__Group__10
            {
            pushFollow(FOLLOW_9);
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
    // InternalXtextTest.g:1268:1: rule__XtextTest__Group__9__Impl : ( ( rule__XtextTest__RootAssignment_9 ) ) ;
    public final void rule__XtextTest__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1272:1: ( ( ( rule__XtextTest__RootAssignment_9 ) ) )
            // InternalXtextTest.g:1274:1: ( ( rule__XtextTest__RootAssignment_9 ) )
            {
            // InternalXtextTest.g:1274:1: ( ( rule__XtextTest__RootAssignment_9 ) )
            // InternalXtextTest.g:1275:1: ( rule__XtextTest__RootAssignment_9 )
            {
             before(grammarAccess.getXtextTestAccess().getRootAssignment_9()); 
            // InternalXtextTest.g:1276:1: ( rule__XtextTest__RootAssignment_9 )
            // InternalXtextTest.g:1276:2: rule__XtextTest__RootAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__RootAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getXtextTestAccess().getRootAssignment_9()); 

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
    // InternalXtextTest.g:1288:1: rule__XtextTest__Group__10 : rule__XtextTest__Group__10__Impl rule__XtextTest__Group__11 ;
    public final void rule__XtextTest__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1292:1: ( rule__XtextTest__Group__10__Impl rule__XtextTest__Group__11 )
            // InternalXtextTest.g:1293:2: rule__XtextTest__Group__10__Impl rule__XtextTest__Group__11
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
    // InternalXtextTest.g:1300:1: rule__XtextTest__Group__10__Impl : ( ( rule__XtextTest__OutputAssignment_10 )? ) ;
    public final void rule__XtextTest__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1304:1: ( ( ( rule__XtextTest__OutputAssignment_10 )? ) )
            // InternalXtextTest.g:1306:1: ( ( rule__XtextTest__OutputAssignment_10 )? )
            {
            // InternalXtextTest.g:1306:1: ( ( rule__XtextTest__OutputAssignment_10 )? )
            // InternalXtextTest.g:1307:1: ( rule__XtextTest__OutputAssignment_10 )?
            {
             before(grammarAccess.getXtextTestAccess().getOutputAssignment_10()); 
            // InternalXtextTest.g:1308:1: ( rule__XtextTest__OutputAssignment_10 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_OUTPUT) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalXtextTest.g:1308:2: rule__XtextTest__OutputAssignment_10
                    {
                    pushFollow(FOLLOW_2);
                    rule__XtextTest__OutputAssignment_10();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXtextTestAccess().getOutputAssignment_10()); 

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
    // InternalXtextTest.g:1320:1: rule__XtextTest__Group__11 : rule__XtextTest__Group__11__Impl rule__XtextTest__Group__12 ;
    public final void rule__XtextTest__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1324:1: ( rule__XtextTest__Group__11__Impl rule__XtextTest__Group__12 )
            // InternalXtextTest.g:1325:2: rule__XtextTest__Group__11__Impl rule__XtextTest__Group__12
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
    // InternalXtextTest.g:1332:1: rule__XtextTest__Group__11__Impl : ( ( rule__XtextTest__BeforeAssignment_11 )? ) ;
    public final void rule__XtextTest__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1336:1: ( ( ( rule__XtextTest__BeforeAssignment_11 )? ) )
            // InternalXtextTest.g:1338:1: ( ( rule__XtextTest__BeforeAssignment_11 )? )
            {
            // InternalXtextTest.g:1338:1: ( ( rule__XtextTest__BeforeAssignment_11 )? )
            // InternalXtextTest.g:1339:1: ( rule__XtextTest__BeforeAssignment_11 )?
            {
             before(grammarAccess.getXtextTestAccess().getBeforeAssignment_11()); 
            // InternalXtextTest.g:1340:1: ( rule__XtextTest__BeforeAssignment_11 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_BEFORE_KW) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalXtextTest.g:1340:2: rule__XtextTest__BeforeAssignment_11
                    {
                    pushFollow(FOLLOW_2);
                    rule__XtextTest__BeforeAssignment_11();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXtextTestAccess().getBeforeAssignment_11()); 

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
    // InternalXtextTest.g:1352:1: rule__XtextTest__Group__12 : rule__XtextTest__Group__12__Impl ;
    public final void rule__XtextTest__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1356:1: ( rule__XtextTest__Group__12__Impl )
            // InternalXtextTest.g:1357:2: rule__XtextTest__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__12__Impl();

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
    // InternalXtextTest.g:1363:1: rule__XtextTest__Group__12__Impl : ( ( rule__XtextTest__AfterAssignment_12 )? ) ;
    public final void rule__XtextTest__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1367:1: ( ( ( rule__XtextTest__AfterAssignment_12 )? ) )
            // InternalXtextTest.g:1369:1: ( ( rule__XtextTest__AfterAssignment_12 )? )
            {
            // InternalXtextTest.g:1369:1: ( ( rule__XtextTest__AfterAssignment_12 )? )
            // InternalXtextTest.g:1370:1: ( rule__XtextTest__AfterAssignment_12 )?
            {
             before(grammarAccess.getXtextTestAccess().getAfterAssignment_12()); 
            // InternalXtextTest.g:1371:1: ( rule__XtextTest__AfterAssignment_12 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_AFTER_KW) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalXtextTest.g:1371:2: rule__XtextTest__AfterAssignment_12
                    {
                    pushFollow(FOLLOW_2);
                    rule__XtextTest__AfterAssignment_12();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXtextTestAccess().getAfterAssignment_12()); 

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


    // $ANTLR start "rule__XtextTest__Group_5__0"
    // InternalXtextTest.g:1409:1: rule__XtextTest__Group_5__0 : rule__XtextTest__Group_5__0__Impl rule__XtextTest__Group_5__1 ;
    public final void rule__XtextTest__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1413:1: ( rule__XtextTest__Group_5__0__Impl rule__XtextTest__Group_5__1 )
            // InternalXtextTest.g:1414:2: rule__XtextTest__Group_5__0__Impl rule__XtextTest__Group_5__1
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
    // InternalXtextTest.g:1421:1: rule__XtextTest__Group_5__0__Impl : ( RULE_IMPORTS ) ;
    public final void rule__XtextTest__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1425:1: ( ( RULE_IMPORTS ) )
            // InternalXtextTest.g:1427:1: ( RULE_IMPORTS )
            {
            // InternalXtextTest.g:1427:1: ( RULE_IMPORTS )
            // InternalXtextTest.g:1428:1: RULE_IMPORTS
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
    // InternalXtextTest.g:1441:1: rule__XtextTest__Group_5__1 : rule__XtextTest__Group_5__1__Impl ;
    public final void rule__XtextTest__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1445:1: ( rule__XtextTest__Group_5__1__Impl )
            // InternalXtextTest.g:1446:2: rule__XtextTest__Group_5__1__Impl
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
    // InternalXtextTest.g:1452:1: rule__XtextTest__Group_5__1__Impl : ( ( rule__XtextTest__ImportsAssignment_5_1 ) ) ;
    public final void rule__XtextTest__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1456:1: ( ( ( rule__XtextTest__ImportsAssignment_5_1 ) ) )
            // InternalXtextTest.g:1458:1: ( ( rule__XtextTest__ImportsAssignment_5_1 ) )
            {
            // InternalXtextTest.g:1458:1: ( ( rule__XtextTest__ImportsAssignment_5_1 ) )
            // InternalXtextTest.g:1459:1: ( rule__XtextTest__ImportsAssignment_5_1 )
            {
             before(grammarAccess.getXtextTestAccess().getImportsAssignment_5_1()); 
            // InternalXtextTest.g:1460:1: ( rule__XtextTest__ImportsAssignment_5_1 )
            // InternalXtextTest.g:1460:2: rule__XtextTest__ImportsAssignment_5_1
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
    // InternalXtextTest.g:1476:1: rule__XtextTest__Group_6__0 : rule__XtextTest__Group_6__0__Impl rule__XtextTest__Group_6__1 ;
    public final void rule__XtextTest__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1480:1: ( rule__XtextTest__Group_6__0__Impl rule__XtextTest__Group_6__1 )
            // InternalXtextTest.g:1481:2: rule__XtextTest__Group_6__0__Impl rule__XtextTest__Group_6__1
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
    // InternalXtextTest.g:1488:1: rule__XtextTest__Group_6__0__Impl : ( RULE_SPLITLEXER ) ;
    public final void rule__XtextTest__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1492:1: ( ( RULE_SPLITLEXER ) )
            // InternalXtextTest.g:1494:1: ( RULE_SPLITLEXER )
            {
            // InternalXtextTest.g:1494:1: ( RULE_SPLITLEXER )
            // InternalXtextTest.g:1495:1: RULE_SPLITLEXER
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
    // InternalXtextTest.g:1508:1: rule__XtextTest__Group_6__1 : rule__XtextTest__Group_6__1__Impl rule__XtextTest__Group_6__2 ;
    public final void rule__XtextTest__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1512:1: ( rule__XtextTest__Group_6__1__Impl rule__XtextTest__Group_6__2 )
            // InternalXtextTest.g:1513:2: rule__XtextTest__Group_6__1__Impl rule__XtextTest__Group_6__2
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
    // InternalXtextTest.g:1520:1: rule__XtextTest__Group_6__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__XtextTest__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1524:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:1526:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:1526:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:1527:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:1540:1: rule__XtextTest__Group_6__2 : rule__XtextTest__Group_6__2__Impl ;
    public final void rule__XtextTest__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1544:1: ( rule__XtextTest__Group_6__2__Impl )
            // InternalXtextTest.g:1545:2: rule__XtextTest__Group_6__2__Impl
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
    // InternalXtextTest.g:1551:1: rule__XtextTest__Group_6__2__Impl : ( ( rule__XtextTest__BooleanAssignment_6_2 ) ) ;
    public final void rule__XtextTest__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1555:1: ( ( ( rule__XtextTest__BooleanAssignment_6_2 ) ) )
            // InternalXtextTest.g:1557:1: ( ( rule__XtextTest__BooleanAssignment_6_2 ) )
            {
            // InternalXtextTest.g:1557:1: ( ( rule__XtextTest__BooleanAssignment_6_2 ) )
            // InternalXtextTest.g:1558:1: ( rule__XtextTest__BooleanAssignment_6_2 )
            {
             before(grammarAccess.getXtextTestAccess().getBooleanAssignment_6_2()); 
            // InternalXtextTest.g:1559:1: ( rule__XtextTest__BooleanAssignment_6_2 )
            // InternalXtextTest.g:1559:2: rule__XtextTest__BooleanAssignment_6_2
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


    // $ANTLR start "rule__EmfTest__Group__0"
    // InternalXtextTest.g:1577:1: rule__EmfTest__Group__0 : rule__EmfTest__Group__0__Impl rule__EmfTest__Group__1 ;
    public final void rule__EmfTest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1581:1: ( rule__EmfTest__Group__0__Impl rule__EmfTest__Group__1 )
            // InternalXtextTest.g:1582:2: rule__EmfTest__Group__0__Impl rule__EmfTest__Group__1
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
    // InternalXtextTest.g:1589:1: rule__EmfTest__Group__0__Impl : ( () ) ;
    public final void rule__EmfTest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1593:1: ( ( () ) )
            // InternalXtextTest.g:1595:1: ( () )
            {
            // InternalXtextTest.g:1595:1: ( () )
            // InternalXtextTest.g:1596:1: ()
            {
             before(grammarAccess.getEmfTestAccess().getEmfTestAction_0()); 
            // InternalXtextTest.g:1597:1: ()
            // InternalXtextTest.g:1599:1: 
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
    // InternalXtextTest.g:1611:1: rule__EmfTest__Group__1 : rule__EmfTest__Group__1__Impl rule__EmfTest__Group__2 ;
    public final void rule__EmfTest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1615:1: ( rule__EmfTest__Group__1__Impl rule__EmfTest__Group__2 )
            // InternalXtextTest.g:1616:2: rule__EmfTest__Group__1__Impl rule__EmfTest__Group__2
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
    // InternalXtextTest.g:1623:1: rule__EmfTest__Group__1__Impl : ( RULE_KW_EMFTEST ) ;
    public final void rule__EmfTest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1627:1: ( ( RULE_KW_EMFTEST ) )
            // InternalXtextTest.g:1629:1: ( RULE_KW_EMFTEST )
            {
            // InternalXtextTest.g:1629:1: ( RULE_KW_EMFTEST )
            // InternalXtextTest.g:1630:1: RULE_KW_EMFTEST
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
    // InternalXtextTest.g:1643:1: rule__EmfTest__Group__2 : rule__EmfTest__Group__2__Impl rule__EmfTest__Group__3 ;
    public final void rule__EmfTest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1647:1: ( rule__EmfTest__Group__2__Impl rule__EmfTest__Group__3 )
            // InternalXtextTest.g:1648:2: rule__EmfTest__Group__2__Impl rule__EmfTest__Group__3
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
    // InternalXtextTest.g:1655:1: rule__EmfTest__Group__2__Impl : ( RULE_PACKAGE ) ;
    public final void rule__EmfTest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1659:1: ( ( RULE_PACKAGE ) )
            // InternalXtextTest.g:1661:1: ( RULE_PACKAGE )
            {
            // InternalXtextTest.g:1661:1: ( RULE_PACKAGE )
            // InternalXtextTest.g:1662:1: RULE_PACKAGE
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
    // InternalXtextTest.g:1675:1: rule__EmfTest__Group__3 : rule__EmfTest__Group__3__Impl rule__EmfTest__Group__4 ;
    public final void rule__EmfTest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1679:1: ( rule__EmfTest__Group__3__Impl rule__EmfTest__Group__4 )
            // InternalXtextTest.g:1680:2: rule__EmfTest__Group__3__Impl rule__EmfTest__Group__4
            {
            pushFollow(FOLLOW_12);
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
    // InternalXtextTest.g:1687:1: rule__EmfTest__Group__3__Impl : ( ( rule__EmfTest__PackageAssignment_3 ) ) ;
    public final void rule__EmfTest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1691:1: ( ( ( rule__EmfTest__PackageAssignment_3 ) ) )
            // InternalXtextTest.g:1693:1: ( ( rule__EmfTest__PackageAssignment_3 ) )
            {
            // InternalXtextTest.g:1693:1: ( ( rule__EmfTest__PackageAssignment_3 ) )
            // InternalXtextTest.g:1694:1: ( rule__EmfTest__PackageAssignment_3 )
            {
             before(grammarAccess.getEmfTestAccess().getPackageAssignment_3()); 
            // InternalXtextTest.g:1695:1: ( rule__EmfTest__PackageAssignment_3 )
            // InternalXtextTest.g:1695:2: rule__EmfTest__PackageAssignment_3
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
    // InternalXtextTest.g:1707:1: rule__EmfTest__Group__4 : rule__EmfTest__Group__4__Impl rule__EmfTest__Group__5 ;
    public final void rule__EmfTest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1711:1: ( rule__EmfTest__Group__4__Impl rule__EmfTest__Group__5 )
            // InternalXtextTest.g:1712:2: rule__EmfTest__Group__4__Impl rule__EmfTest__Group__5
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
    // InternalXtextTest.g:1719:1: rule__EmfTest__Group__4__Impl : ( RULE_DEFAULT ) ;
    public final void rule__EmfTest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1723:1: ( ( RULE_DEFAULT ) )
            // InternalXtextTest.g:1725:1: ( RULE_DEFAULT )
            {
            // InternalXtextTest.g:1725:1: ( RULE_DEFAULT )
            // InternalXtextTest.g:1726:1: RULE_DEFAULT
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
    // InternalXtextTest.g:1739:1: rule__EmfTest__Group__5 : rule__EmfTest__Group__5__Impl rule__EmfTest__Group__6 ;
    public final void rule__EmfTest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1743:1: ( rule__EmfTest__Group__5__Impl rule__EmfTest__Group__6 )
            // InternalXtextTest.g:1744:2: rule__EmfTest__Group__5__Impl rule__EmfTest__Group__6
            {
            pushFollow(FOLLOW_13);
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
    // InternalXtextTest.g:1751:1: rule__EmfTest__Group__5__Impl : ( ( rule__EmfTest__MydefaultAssignment_5 ) ) ;
    public final void rule__EmfTest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1755:1: ( ( ( rule__EmfTest__MydefaultAssignment_5 ) ) )
            // InternalXtextTest.g:1757:1: ( ( rule__EmfTest__MydefaultAssignment_5 ) )
            {
            // InternalXtextTest.g:1757:1: ( ( rule__EmfTest__MydefaultAssignment_5 ) )
            // InternalXtextTest.g:1758:1: ( rule__EmfTest__MydefaultAssignment_5 )
            {
             before(grammarAccess.getEmfTestAccess().getMydefaultAssignment_5()); 
            // InternalXtextTest.g:1759:1: ( rule__EmfTest__MydefaultAssignment_5 )
            // InternalXtextTest.g:1759:2: rule__EmfTest__MydefaultAssignment_5
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
    // InternalXtextTest.g:1771:1: rule__EmfTest__Group__6 : rule__EmfTest__Group__6__Impl rule__EmfTest__Group__7 ;
    public final void rule__EmfTest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1775:1: ( rule__EmfTest__Group__6__Impl rule__EmfTest__Group__7 )
            // InternalXtextTest.g:1776:2: rule__EmfTest__Group__6__Impl rule__EmfTest__Group__7
            {
            pushFollow(FOLLOW_13);
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
    // InternalXtextTest.g:1783:1: rule__EmfTest__Group__6__Impl : ( ( rule__EmfTest__MyimportAssignment_6 )* ) ;
    public final void rule__EmfTest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1787:1: ( ( ( rule__EmfTest__MyimportAssignment_6 )* ) )
            // InternalXtextTest.g:1789:1: ( ( rule__EmfTest__MyimportAssignment_6 )* )
            {
            // InternalXtextTest.g:1789:1: ( ( rule__EmfTest__MyimportAssignment_6 )* )
            // InternalXtextTest.g:1790:1: ( rule__EmfTest__MyimportAssignment_6 )*
            {
             before(grammarAccess.getEmfTestAccess().getMyimportAssignment_6()); 
            // InternalXtextTest.g:1791:1: ( rule__EmfTest__MyimportAssignment_6 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_IMPORTS) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalXtextTest.g:1791:2: rule__EmfTest__MyimportAssignment_6
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__EmfTest__MyimportAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // InternalXtextTest.g:1803:1: rule__EmfTest__Group__7 : rule__EmfTest__Group__7__Impl rule__EmfTest__Group__8 ;
    public final void rule__EmfTest__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1807:1: ( rule__EmfTest__Group__7__Impl rule__EmfTest__Group__8 )
            // InternalXtextTest.g:1808:2: rule__EmfTest__Group__7__Impl rule__EmfTest__Group__8
            {
            pushFollow(FOLLOW_15);
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
    // InternalXtextTest.g:1815:1: rule__EmfTest__Group__7__Impl : ( ( rule__EmfTest__CodeCallAssignment_7 ) ) ;
    public final void rule__EmfTest__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1819:1: ( ( ( rule__EmfTest__CodeCallAssignment_7 ) ) )
            // InternalXtextTest.g:1821:1: ( ( rule__EmfTest__CodeCallAssignment_7 ) )
            {
            // InternalXtextTest.g:1821:1: ( ( rule__EmfTest__CodeCallAssignment_7 ) )
            // InternalXtextTest.g:1822:1: ( rule__EmfTest__CodeCallAssignment_7 )
            {
             before(grammarAccess.getEmfTestAccess().getCodeCallAssignment_7()); 
            // InternalXtextTest.g:1823:1: ( rule__EmfTest__CodeCallAssignment_7 )
            // InternalXtextTest.g:1823:2: rule__EmfTest__CodeCallAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__CodeCallAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getEmfTestAccess().getCodeCallAssignment_7()); 

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
    // InternalXtextTest.g:1835:1: rule__EmfTest__Group__8 : rule__EmfTest__Group__8__Impl rule__EmfTest__Group__9 ;
    public final void rule__EmfTest__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1839:1: ( rule__EmfTest__Group__8__Impl rule__EmfTest__Group__9 )
            // InternalXtextTest.g:1840:2: rule__EmfTest__Group__8__Impl rule__EmfTest__Group__9
            {
            pushFollow(FOLLOW_15);
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
    // InternalXtextTest.g:1847:1: rule__EmfTest__Group__8__Impl : ( ( rule__EmfTest__Group_8__0 )? ) ;
    public final void rule__EmfTest__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1851:1: ( ( ( rule__EmfTest__Group_8__0 )? ) )
            // InternalXtextTest.g:1853:1: ( ( rule__EmfTest__Group_8__0 )? )
            {
            // InternalXtextTest.g:1853:1: ( ( rule__EmfTest__Group_8__0 )? )
            // InternalXtextTest.g:1854:1: ( rule__EmfTest__Group_8__0 )?
            {
             before(grammarAccess.getEmfTestAccess().getGroup_8()); 
            // InternalXtextTest.g:1855:1: ( rule__EmfTest__Group_8__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_OPTIONS) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalXtextTest.g:1855:2: rule__EmfTest__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EmfTest__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEmfTestAccess().getGroup_8()); 

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
    // InternalXtextTest.g:1867:1: rule__EmfTest__Group__9 : rule__EmfTest__Group__9__Impl rule__EmfTest__Group__10 ;
    public final void rule__EmfTest__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1871:1: ( rule__EmfTest__Group__9__Impl rule__EmfTest__Group__10 )
            // InternalXtextTest.g:1872:2: rule__EmfTest__Group__9__Impl rule__EmfTest__Group__10
            {
            pushFollow(FOLLOW_8);
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
    // InternalXtextTest.g:1879:1: rule__EmfTest__Group__9__Impl : ( ( rule__EmfTest__Group_9__0 ) ) ;
    public final void rule__EmfTest__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1883:1: ( ( ( rule__EmfTest__Group_9__0 ) ) )
            // InternalXtextTest.g:1885:1: ( ( rule__EmfTest__Group_9__0 ) )
            {
            // InternalXtextTest.g:1885:1: ( ( rule__EmfTest__Group_9__0 ) )
            // InternalXtextTest.g:1886:1: ( rule__EmfTest__Group_9__0 )
            {
             before(grammarAccess.getEmfTestAccess().getGroup_9()); 
            // InternalXtextTest.g:1887:1: ( rule__EmfTest__Group_9__0 )
            // InternalXtextTest.g:1887:2: rule__EmfTest__Group_9__0
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_9__0();

            state._fsp--;


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
    // InternalXtextTest.g:1899:1: rule__EmfTest__Group__10 : rule__EmfTest__Group__10__Impl rule__EmfTest__Group__11 ;
    public final void rule__EmfTest__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1903:1: ( rule__EmfTest__Group__10__Impl rule__EmfTest__Group__11 )
            // InternalXtextTest.g:1904:2: rule__EmfTest__Group__10__Impl rule__EmfTest__Group__11
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
    // InternalXtextTest.g:1911:1: rule__EmfTest__Group__10__Impl : ( ( rule__EmfTest__RootAssignment_10 ) ) ;
    public final void rule__EmfTest__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1915:1: ( ( ( rule__EmfTest__RootAssignment_10 ) ) )
            // InternalXtextTest.g:1917:1: ( ( rule__EmfTest__RootAssignment_10 ) )
            {
            // InternalXtextTest.g:1917:1: ( ( rule__EmfTest__RootAssignment_10 ) )
            // InternalXtextTest.g:1918:1: ( rule__EmfTest__RootAssignment_10 )
            {
             before(grammarAccess.getEmfTestAccess().getRootAssignment_10()); 
            // InternalXtextTest.g:1919:1: ( rule__EmfTest__RootAssignment_10 )
            // InternalXtextTest.g:1919:2: rule__EmfTest__RootAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__RootAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getEmfTestAccess().getRootAssignment_10()); 

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
    // InternalXtextTest.g:1931:1: rule__EmfTest__Group__11 : rule__EmfTest__Group__11__Impl rule__EmfTest__Group__12 ;
    public final void rule__EmfTest__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1935:1: ( rule__EmfTest__Group__11__Impl rule__EmfTest__Group__12 )
            // InternalXtextTest.g:1936:2: rule__EmfTest__Group__11__Impl rule__EmfTest__Group__12
            {
            pushFollow(FOLLOW_16);
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
    // InternalXtextTest.g:1943:1: rule__EmfTest__Group__11__Impl : ( ( rule__EmfTest__BeforeAssignment_11 )? ) ;
    public final void rule__EmfTest__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1947:1: ( ( ( rule__EmfTest__BeforeAssignment_11 )? ) )
            // InternalXtextTest.g:1949:1: ( ( rule__EmfTest__BeforeAssignment_11 )? )
            {
            // InternalXtextTest.g:1949:1: ( ( rule__EmfTest__BeforeAssignment_11 )? )
            // InternalXtextTest.g:1950:1: ( rule__EmfTest__BeforeAssignment_11 )?
            {
             before(grammarAccess.getEmfTestAccess().getBeforeAssignment_11()); 
            // InternalXtextTest.g:1951:1: ( rule__EmfTest__BeforeAssignment_11 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_BEFORE_KW) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalXtextTest.g:1951:2: rule__EmfTest__BeforeAssignment_11
                    {
                    pushFollow(FOLLOW_2);
                    rule__EmfTest__BeforeAssignment_11();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEmfTestAccess().getBeforeAssignment_11()); 

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
    // InternalXtextTest.g:1963:1: rule__EmfTest__Group__12 : rule__EmfTest__Group__12__Impl ;
    public final void rule__EmfTest__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1967:1: ( rule__EmfTest__Group__12__Impl )
            // InternalXtextTest.g:1968:2: rule__EmfTest__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__12__Impl();

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
    // InternalXtextTest.g:1974:1: rule__EmfTest__Group__12__Impl : ( ( rule__EmfTest__AfterAssignment_12 )? ) ;
    public final void rule__EmfTest__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1978:1: ( ( ( rule__EmfTest__AfterAssignment_12 )? ) )
            // InternalXtextTest.g:1980:1: ( ( rule__EmfTest__AfterAssignment_12 )? )
            {
            // InternalXtextTest.g:1980:1: ( ( rule__EmfTest__AfterAssignment_12 )? )
            // InternalXtextTest.g:1981:1: ( rule__EmfTest__AfterAssignment_12 )?
            {
             before(grammarAccess.getEmfTestAccess().getAfterAssignment_12()); 
            // InternalXtextTest.g:1982:1: ( rule__EmfTest__AfterAssignment_12 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_AFTER_KW) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalXtextTest.g:1982:2: rule__EmfTest__AfterAssignment_12
                    {
                    pushFollow(FOLLOW_2);
                    rule__EmfTest__AfterAssignment_12();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEmfTestAccess().getAfterAssignment_12()); 

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


    // $ANTLR start "rule__EmfTest__Group_8__0"
    // InternalXtextTest.g:2020:1: rule__EmfTest__Group_8__0 : rule__EmfTest__Group_8__0__Impl rule__EmfTest__Group_8__1 ;
    public final void rule__EmfTest__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2024:1: ( rule__EmfTest__Group_8__0__Impl rule__EmfTest__Group_8__1 )
            // InternalXtextTest.g:2025:2: rule__EmfTest__Group_8__0__Impl rule__EmfTest__Group_8__1
            {
            pushFollow(FOLLOW_13);
            rule__EmfTest__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_8__1();

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
    // $ANTLR end "rule__EmfTest__Group_8__0"


    // $ANTLR start "rule__EmfTest__Group_8__0__Impl"
    // InternalXtextTest.g:2032:1: rule__EmfTest__Group_8__0__Impl : ( RULE_OPTIONS ) ;
    public final void rule__EmfTest__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2036:1: ( ( RULE_OPTIONS ) )
            // InternalXtextTest.g:2038:1: ( RULE_OPTIONS )
            {
            // InternalXtextTest.g:2038:1: ( RULE_OPTIONS )
            // InternalXtextTest.g:2039:1: RULE_OPTIONS
            {
             before(grammarAccess.getEmfTestAccess().getOPTIONSTerminalRuleCall_8_0()); 
            match(input,RULE_OPTIONS,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getOPTIONSTerminalRuleCall_8_0()); 

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
    // $ANTLR end "rule__EmfTest__Group_8__0__Impl"


    // $ANTLR start "rule__EmfTest__Group_8__1"
    // InternalXtextTest.g:2052:1: rule__EmfTest__Group_8__1 : rule__EmfTest__Group_8__1__Impl ;
    public final void rule__EmfTest__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2056:1: ( rule__EmfTest__Group_8__1__Impl )
            // InternalXtextTest.g:2057:2: rule__EmfTest__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_8__1__Impl();

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
    // $ANTLR end "rule__EmfTest__Group_8__1"


    // $ANTLR start "rule__EmfTest__Group_8__1__Impl"
    // InternalXtextTest.g:2063:1: rule__EmfTest__Group_8__1__Impl : ( ( rule__EmfTest__OptionCallAssignment_8_1 ) ) ;
    public final void rule__EmfTest__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2067:1: ( ( ( rule__EmfTest__OptionCallAssignment_8_1 ) ) )
            // InternalXtextTest.g:2069:1: ( ( rule__EmfTest__OptionCallAssignment_8_1 ) )
            {
            // InternalXtextTest.g:2069:1: ( ( rule__EmfTest__OptionCallAssignment_8_1 ) )
            // InternalXtextTest.g:2070:1: ( rule__EmfTest__OptionCallAssignment_8_1 )
            {
             before(grammarAccess.getEmfTestAccess().getOptionCallAssignment_8_1()); 
            // InternalXtextTest.g:2071:1: ( rule__EmfTest__OptionCallAssignment_8_1 )
            // InternalXtextTest.g:2071:2: rule__EmfTest__OptionCallAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__OptionCallAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getEmfTestAccess().getOptionCallAssignment_8_1()); 

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
    // $ANTLR end "rule__EmfTest__Group_8__1__Impl"


    // $ANTLR start "rule__EmfTest__Group_9__0"
    // InternalXtextTest.g:2087:1: rule__EmfTest__Group_9__0 : rule__EmfTest__Group_9__0__Impl rule__EmfTest__Group_9__1 ;
    public final void rule__EmfTest__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2091:1: ( rule__EmfTest__Group_9__0__Impl rule__EmfTest__Group_9__1 )
            // InternalXtextTest.g:2092:2: rule__EmfTest__Group_9__0__Impl rule__EmfTest__Group_9__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalXtextTest.g:2099:1: rule__EmfTest__Group_9__0__Impl : ( RULE_SOURCE ) ;
    public final void rule__EmfTest__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2103:1: ( ( RULE_SOURCE ) )
            // InternalXtextTest.g:2105:1: ( RULE_SOURCE )
            {
            // InternalXtextTest.g:2105:1: ( RULE_SOURCE )
            // InternalXtextTest.g:2106:1: RULE_SOURCE
            {
             before(grammarAccess.getEmfTestAccess().getSOURCETerminalRuleCall_9_0()); 
            match(input,RULE_SOURCE,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getSOURCETerminalRuleCall_9_0()); 

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
    // InternalXtextTest.g:2119:1: rule__EmfTest__Group_9__1 : rule__EmfTest__Group_9__1__Impl rule__EmfTest__Group_9__2 ;
    public final void rule__EmfTest__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2123:1: ( rule__EmfTest__Group_9__1__Impl rule__EmfTest__Group_9__2 )
            // InternalXtextTest.g:2124:2: rule__EmfTest__Group_9__1__Impl rule__EmfTest__Group_9__2
            {
            pushFollow(FOLLOW_10);
            rule__EmfTest__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_9__2();

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
    // InternalXtextTest.g:2131:1: rule__EmfTest__Group_9__1__Impl : ( RULE_FILE ) ;
    public final void rule__EmfTest__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2135:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:2137:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:2137:1: ( RULE_FILE )
            // InternalXtextTest.g:2138:1: RULE_FILE
            {
             before(grammarAccess.getEmfTestAccess().getFILETerminalRuleCall_9_1()); 
            match(input,RULE_FILE,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getFILETerminalRuleCall_9_1()); 

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


    // $ANTLR start "rule__EmfTest__Group_9__2"
    // InternalXtextTest.g:2151:1: rule__EmfTest__Group_9__2 : rule__EmfTest__Group_9__2__Impl rule__EmfTest__Group_9__3 ;
    public final void rule__EmfTest__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2155:1: ( rule__EmfTest__Group_9__2__Impl rule__EmfTest__Group_9__3 )
            // InternalXtextTest.g:2156:2: rule__EmfTest__Group_9__2__Impl rule__EmfTest__Group_9__3
            {
            pushFollow(FOLLOW_18);
            rule__EmfTest__Group_9__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_9__3();

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
    // $ANTLR end "rule__EmfTest__Group_9__2"


    // $ANTLR start "rule__EmfTest__Group_9__2__Impl"
    // InternalXtextTest.g:2163:1: rule__EmfTest__Group_9__2__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__EmfTest__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2167:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:2169:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:2169:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:2170:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getEmfTestAccess().getASSIGNASSINGLETerminalRuleCall_9_2()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getASSIGNASSINGLETerminalRuleCall_9_2()); 

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
    // $ANTLR end "rule__EmfTest__Group_9__2__Impl"


    // $ANTLR start "rule__EmfTest__Group_9__3"
    // InternalXtextTest.g:2183:1: rule__EmfTest__Group_9__3 : rule__EmfTest__Group_9__3__Impl ;
    public final void rule__EmfTest__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2187:1: ( rule__EmfTest__Group_9__3__Impl )
            // InternalXtextTest.g:2188:2: rule__EmfTest__Group_9__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_9__3__Impl();

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
    // $ANTLR end "rule__EmfTest__Group_9__3"


    // $ANTLR start "rule__EmfTest__Group_9__3__Impl"
    // InternalXtextTest.g:2194:1: rule__EmfTest__Group_9__3__Impl : ( ( rule__EmfTest__FileAssignment_9_3 ) ) ;
    public final void rule__EmfTest__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2198:1: ( ( ( rule__EmfTest__FileAssignment_9_3 ) ) )
            // InternalXtextTest.g:2200:1: ( ( rule__EmfTest__FileAssignment_9_3 ) )
            {
            // InternalXtextTest.g:2200:1: ( ( rule__EmfTest__FileAssignment_9_3 ) )
            // InternalXtextTest.g:2201:1: ( rule__EmfTest__FileAssignment_9_3 )
            {
             before(grammarAccess.getEmfTestAccess().getFileAssignment_9_3()); 
            // InternalXtextTest.g:2202:1: ( rule__EmfTest__FileAssignment_9_3 )
            // InternalXtextTest.g:2202:2: rule__EmfTest__FileAssignment_9_3
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__FileAssignment_9_3();

            state._fsp--;


            }

             after(grammarAccess.getEmfTestAccess().getFileAssignment_9_3()); 

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
    // $ANTLR end "rule__EmfTest__Group_9__3__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalXtextTest.g:2222:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2226:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalXtextTest.g:2227:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalXtextTest.g:2234:1: rule__Import__Group__0__Impl : ( () ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2238:1: ( ( () ) )
            // InternalXtextTest.g:2240:1: ( () )
            {
            // InternalXtextTest.g:2240:1: ( () )
            // InternalXtextTest.g:2241:1: ()
            {
             before(grammarAccess.getImportAccess().getImportAction_0()); 
            // InternalXtextTest.g:2242:1: ()
            // InternalXtextTest.g:2244:1: 
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
    // InternalXtextTest.g:2256:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2260:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // InternalXtextTest.g:2261:2: rule__Import__Group__1__Impl rule__Import__Group__2
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
    // InternalXtextTest.g:2268:1: rule__Import__Group__1__Impl : ( RULE_IMPORTS ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2272:1: ( ( RULE_IMPORTS ) )
            // InternalXtextTest.g:2274:1: ( RULE_IMPORTS )
            {
            // InternalXtextTest.g:2274:1: ( RULE_IMPORTS )
            // InternalXtextTest.g:2275:1: RULE_IMPORTS
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
    // InternalXtextTest.g:2288:1: rule__Import__Group__2 : rule__Import__Group__2__Impl rule__Import__Group__3 ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2292:1: ( rule__Import__Group__2__Impl rule__Import__Group__3 )
            // InternalXtextTest.g:2293:2: rule__Import__Group__2__Impl rule__Import__Group__3
            {
            pushFollow(FOLLOW_20);
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
    // InternalXtextTest.g:2300:1: rule__Import__Group__2__Impl : ( ( rule__Import__IdAssignment_2 ) ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2304:1: ( ( ( rule__Import__IdAssignment_2 ) ) )
            // InternalXtextTest.g:2306:1: ( ( rule__Import__IdAssignment_2 ) )
            {
            // InternalXtextTest.g:2306:1: ( ( rule__Import__IdAssignment_2 ) )
            // InternalXtextTest.g:2307:1: ( rule__Import__IdAssignment_2 )
            {
             before(grammarAccess.getImportAccess().getIdAssignment_2()); 
            // InternalXtextTest.g:2308:1: ( rule__Import__IdAssignment_2 )
            // InternalXtextTest.g:2308:2: rule__Import__IdAssignment_2
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
    // InternalXtextTest.g:2320:1: rule__Import__Group__3 : rule__Import__Group__3__Impl rule__Import__Group__4 ;
    public final void rule__Import__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2324:1: ( rule__Import__Group__3__Impl rule__Import__Group__4 )
            // InternalXtextTest.g:2325:2: rule__Import__Group__3__Impl rule__Import__Group__4
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
    // InternalXtextTest.g:2332:1: rule__Import__Group__3__Impl : ( RULE_KW_AS ) ;
    public final void rule__Import__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2336:1: ( ( RULE_KW_AS ) )
            // InternalXtextTest.g:2338:1: ( RULE_KW_AS )
            {
            // InternalXtextTest.g:2338:1: ( RULE_KW_AS )
            // InternalXtextTest.g:2339:1: RULE_KW_AS
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
    // InternalXtextTest.g:2352:1: rule__Import__Group__4 : rule__Import__Group__4__Impl ;
    public final void rule__Import__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2356:1: ( rule__Import__Group__4__Impl )
            // InternalXtextTest.g:2357:2: rule__Import__Group__4__Impl
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
    // InternalXtextTest.g:2363:1: rule__Import__Group__4__Impl : ( ( rule__Import__AliasAssignment_4 ) ) ;
    public final void rule__Import__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2367:1: ( ( ( rule__Import__AliasAssignment_4 ) ) )
            // InternalXtextTest.g:2369:1: ( ( rule__Import__AliasAssignment_4 ) )
            {
            // InternalXtextTest.g:2369:1: ( ( rule__Import__AliasAssignment_4 ) )
            // InternalXtextTest.g:2370:1: ( rule__Import__AliasAssignment_4 )
            {
             before(grammarAccess.getImportAccess().getAliasAssignment_4()); 
            // InternalXtextTest.g:2371:1: ( rule__Import__AliasAssignment_4 )
            // InternalXtextTest.g:2371:2: rule__Import__AliasAssignment_4
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
    // InternalXtextTest.g:2393:1: rule__PackageID__Group__0 : rule__PackageID__Group__0__Impl rule__PackageID__Group__1 ;
    public final void rule__PackageID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2397:1: ( rule__PackageID__Group__0__Impl rule__PackageID__Group__1 )
            // InternalXtextTest.g:2398:2: rule__PackageID__Group__0__Impl rule__PackageID__Group__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalXtextTest.g:2405:1: rule__PackageID__Group__0__Impl : ( RULE_IDENTIFIER ) ;
    public final void rule__PackageID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2409:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:2411:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:2411:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:2412:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:2425:1: rule__PackageID__Group__1 : rule__PackageID__Group__1__Impl ;
    public final void rule__PackageID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2429:1: ( rule__PackageID__Group__1__Impl )
            // InternalXtextTest.g:2430:2: rule__PackageID__Group__1__Impl
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
    // InternalXtextTest.g:2436:1: rule__PackageID__Group__1__Impl : ( ( rule__PackageID__Group_1__0 )* ) ;
    public final void rule__PackageID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2440:1: ( ( ( rule__PackageID__Group_1__0 )* ) )
            // InternalXtextTest.g:2442:1: ( ( rule__PackageID__Group_1__0 )* )
            {
            // InternalXtextTest.g:2442:1: ( ( rule__PackageID__Group_1__0 )* )
            // InternalXtextTest.g:2443:1: ( rule__PackageID__Group_1__0 )*
            {
             before(grammarAccess.getPackageIDAccess().getGroup_1()); 
            // InternalXtextTest.g:2444:1: ( rule__PackageID__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_POINT) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalXtextTest.g:2444:2: rule__PackageID__Group_1__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__PackageID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalXtextTest.g:2460:1: rule__PackageID__Group_1__0 : rule__PackageID__Group_1__0__Impl rule__PackageID__Group_1__1 ;
    public final void rule__PackageID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2464:1: ( rule__PackageID__Group_1__0__Impl rule__PackageID__Group_1__1 )
            // InternalXtextTest.g:2465:2: rule__PackageID__Group_1__0__Impl rule__PackageID__Group_1__1
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
    // InternalXtextTest.g:2472:1: rule__PackageID__Group_1__0__Impl : ( RULE_POINT ) ;
    public final void rule__PackageID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2476:1: ( ( RULE_POINT ) )
            // InternalXtextTest.g:2478:1: ( RULE_POINT )
            {
            // InternalXtextTest.g:2478:1: ( RULE_POINT )
            // InternalXtextTest.g:2479:1: RULE_POINT
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
    // InternalXtextTest.g:2492:1: rule__PackageID__Group_1__1 : rule__PackageID__Group_1__1__Impl ;
    public final void rule__PackageID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2496:1: ( rule__PackageID__Group_1__1__Impl )
            // InternalXtextTest.g:2497:2: rule__PackageID__Group_1__1__Impl
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
    // InternalXtextTest.g:2503:1: rule__PackageID__Group_1__1__Impl : ( RULE_IDENTIFIER ) ;
    public final void rule__PackageID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2507:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:2509:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:2509:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:2510:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:2527:1: rule__ImportID__Group__0 : rule__ImportID__Group__0__Impl rule__ImportID__Group__1 ;
    public final void rule__ImportID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2531:1: ( rule__ImportID__Group__0__Impl rule__ImportID__Group__1 )
            // InternalXtextTest.g:2532:2: rule__ImportID__Group__0__Impl rule__ImportID__Group__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalXtextTest.g:2539:1: rule__ImportID__Group__0__Impl : ( RULE_IDENTIFIER ) ;
    public final void rule__ImportID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2543:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:2545:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:2545:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:2546:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:2559:1: rule__ImportID__Group__1 : rule__ImportID__Group__1__Impl ;
    public final void rule__ImportID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2563:1: ( rule__ImportID__Group__1__Impl )
            // InternalXtextTest.g:2564:2: rule__ImportID__Group__1__Impl
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
    // InternalXtextTest.g:2570:1: rule__ImportID__Group__1__Impl : ( ( rule__ImportID__Group_1__0 )* ) ;
    public final void rule__ImportID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2574:1: ( ( ( rule__ImportID__Group_1__0 )* ) )
            // InternalXtextTest.g:2576:1: ( ( rule__ImportID__Group_1__0 )* )
            {
            // InternalXtextTest.g:2576:1: ( ( rule__ImportID__Group_1__0 )* )
            // InternalXtextTest.g:2577:1: ( rule__ImportID__Group_1__0 )*
            {
             before(grammarAccess.getImportIDAccess().getGroup_1()); 
            // InternalXtextTest.g:2578:1: ( rule__ImportID__Group_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_POINT) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalXtextTest.g:2578:2: rule__ImportID__Group_1__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__ImportID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // InternalXtextTest.g:2594:1: rule__ImportID__Group_1__0 : rule__ImportID__Group_1__0__Impl rule__ImportID__Group_1__1 ;
    public final void rule__ImportID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2598:1: ( rule__ImportID__Group_1__0__Impl rule__ImportID__Group_1__1 )
            // InternalXtextTest.g:2599:2: rule__ImportID__Group_1__0__Impl rule__ImportID__Group_1__1
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
    // InternalXtextTest.g:2606:1: rule__ImportID__Group_1__0__Impl : ( RULE_POINT ) ;
    public final void rule__ImportID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2610:1: ( ( RULE_POINT ) )
            // InternalXtextTest.g:2612:1: ( RULE_POINT )
            {
            // InternalXtextTest.g:2612:1: ( RULE_POINT )
            // InternalXtextTest.g:2613:1: RULE_POINT
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
    // InternalXtextTest.g:2626:1: rule__ImportID__Group_1__1 : rule__ImportID__Group_1__1__Impl ;
    public final void rule__ImportID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2630:1: ( rule__ImportID__Group_1__1__Impl )
            // InternalXtextTest.g:2631:2: rule__ImportID__Group_1__1__Impl
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
    // InternalXtextTest.g:2637:1: rule__ImportID__Group_1__1__Impl : ( RULE_IDENTIFIER ) ;
    public final void rule__ImportID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2641:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:2643:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:2643:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:2644:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:2661:1: rule__Input__Group__0 : rule__Input__Group__0__Impl rule__Input__Group__1 ;
    public final void rule__Input__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2665:1: ( rule__Input__Group__0__Impl rule__Input__Group__1 )
            // InternalXtextTest.g:2666:2: rule__Input__Group__0__Impl rule__Input__Group__1
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
    // InternalXtextTest.g:2673:1: rule__Input__Group__0__Impl : ( () ) ;
    public final void rule__Input__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2677:1: ( ( () ) )
            // InternalXtextTest.g:2679:1: ( () )
            {
            // InternalXtextTest.g:2679:1: ( () )
            // InternalXtextTest.g:2680:1: ()
            {
             before(grammarAccess.getInputAccess().getInputAction_0()); 
            // InternalXtextTest.g:2681:1: ()
            // InternalXtextTest.g:2683:1: 
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
    // InternalXtextTest.g:2695:1: rule__Input__Group__1 : rule__Input__Group__1__Impl rule__Input__Group__2 ;
    public final void rule__Input__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2699:1: ( rule__Input__Group__1__Impl rule__Input__Group__2 )
            // InternalXtextTest.g:2700:2: rule__Input__Group__1__Impl rule__Input__Group__2
            {
            pushFollow(FOLLOW_23);
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
    // InternalXtextTest.g:2707:1: rule__Input__Group__1__Impl : ( RULE_SOURCE ) ;
    public final void rule__Input__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2711:1: ( ( RULE_SOURCE ) )
            // InternalXtextTest.g:2713:1: ( RULE_SOURCE )
            {
            // InternalXtextTest.g:2713:1: ( RULE_SOURCE )
            // InternalXtextTest.g:2714:1: RULE_SOURCE
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
    // InternalXtextTest.g:2727:1: rule__Input__Group__2 : rule__Input__Group__2__Impl ;
    public final void rule__Input__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2731:1: ( rule__Input__Group__2__Impl )
            // InternalXtextTest.g:2732:2: rule__Input__Group__2__Impl
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
    // InternalXtextTest.g:2738:1: rule__Input__Group__2__Impl : ( ( rule__Input__Alternatives_2 ) ) ;
    public final void rule__Input__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2742:1: ( ( ( rule__Input__Alternatives_2 ) ) )
            // InternalXtextTest.g:2744:1: ( ( rule__Input__Alternatives_2 ) )
            {
            // InternalXtextTest.g:2744:1: ( ( rule__Input__Alternatives_2 ) )
            // InternalXtextTest.g:2745:1: ( rule__Input__Alternatives_2 )
            {
             before(grammarAccess.getInputAccess().getAlternatives_2()); 
            // InternalXtextTest.g:2746:1: ( rule__Input__Alternatives_2 )
            // InternalXtextTest.g:2746:2: rule__Input__Alternatives_2
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
    // InternalXtextTest.g:2764:1: rule__Input__Group_2_0__0 : rule__Input__Group_2_0__0__Impl rule__Input__Group_2_0__1 ;
    public final void rule__Input__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2768:1: ( rule__Input__Group_2_0__0__Impl rule__Input__Group_2_0__1 )
            // InternalXtextTest.g:2769:2: rule__Input__Group_2_0__0__Impl rule__Input__Group_2_0__1
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
    // InternalXtextTest.g:2776:1: rule__Input__Group_2_0__0__Impl : ( RULE_SRCTEXT ) ;
    public final void rule__Input__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2780:1: ( ( RULE_SRCTEXT ) )
            // InternalXtextTest.g:2782:1: ( RULE_SRCTEXT )
            {
            // InternalXtextTest.g:2782:1: ( RULE_SRCTEXT )
            // InternalXtextTest.g:2783:1: RULE_SRCTEXT
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
    // InternalXtextTest.g:2796:1: rule__Input__Group_2_0__1 : rule__Input__Group_2_0__1__Impl rule__Input__Group_2_0__2 ;
    public final void rule__Input__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2800:1: ( rule__Input__Group_2_0__1__Impl rule__Input__Group_2_0__2 )
            // InternalXtextTest.g:2801:2: rule__Input__Group_2_0__1__Impl rule__Input__Group_2_0__2
            {
            pushFollow(FOLLOW_18);
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
    // InternalXtextTest.g:2808:1: rule__Input__Group_2_0__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Input__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2812:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:2814:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:2814:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:2815:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:2828:1: rule__Input__Group_2_0__2 : rule__Input__Group_2_0__2__Impl ;
    public final void rule__Input__Group_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2832:1: ( rule__Input__Group_2_0__2__Impl )
            // InternalXtextTest.g:2833:2: rule__Input__Group_2_0__2__Impl
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
    // InternalXtextTest.g:2839:1: rule__Input__Group_2_0__2__Impl : ( ( rule__Input__TextAssignment_2_0_2 ) ) ;
    public final void rule__Input__Group_2_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2843:1: ( ( ( rule__Input__TextAssignment_2_0_2 ) ) )
            // InternalXtextTest.g:2845:1: ( ( rule__Input__TextAssignment_2_0_2 ) )
            {
            // InternalXtextTest.g:2845:1: ( ( rule__Input__TextAssignment_2_0_2 ) )
            // InternalXtextTest.g:2846:1: ( rule__Input__TextAssignment_2_0_2 )
            {
             before(grammarAccess.getInputAccess().getTextAssignment_2_0_2()); 
            // InternalXtextTest.g:2847:1: ( rule__Input__TextAssignment_2_0_2 )
            // InternalXtextTest.g:2847:2: rule__Input__TextAssignment_2_0_2
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
    // InternalXtextTest.g:2865:1: rule__Input__Group_2_1__0 : rule__Input__Group_2_1__0__Impl rule__Input__Group_2_1__1 ;
    public final void rule__Input__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2869:1: ( rule__Input__Group_2_1__0__Impl rule__Input__Group_2_1__1 )
            // InternalXtextTest.g:2870:2: rule__Input__Group_2_1__0__Impl rule__Input__Group_2_1__1
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
    // InternalXtextTest.g:2877:1: rule__Input__Group_2_1__0__Impl : ( RULE_FILE ) ;
    public final void rule__Input__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2881:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:2883:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:2883:1: ( RULE_FILE )
            // InternalXtextTest.g:2884:1: RULE_FILE
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
    // InternalXtextTest.g:2897:1: rule__Input__Group_2_1__1 : rule__Input__Group_2_1__1__Impl rule__Input__Group_2_1__2 ;
    public final void rule__Input__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2901:1: ( rule__Input__Group_2_1__1__Impl rule__Input__Group_2_1__2 )
            // InternalXtextTest.g:2902:2: rule__Input__Group_2_1__1__Impl rule__Input__Group_2_1__2
            {
            pushFollow(FOLLOW_18);
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
    // InternalXtextTest.g:2909:1: rule__Input__Group_2_1__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Input__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2913:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:2915:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:2915:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:2916:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:2929:1: rule__Input__Group_2_1__2 : rule__Input__Group_2_1__2__Impl ;
    public final void rule__Input__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2933:1: ( rule__Input__Group_2_1__2__Impl )
            // InternalXtextTest.g:2934:2: rule__Input__Group_2_1__2__Impl
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
    // InternalXtextTest.g:2940:1: rule__Input__Group_2_1__2__Impl : ( ( rule__Input__FileAssignment_2_1_2 ) ) ;
    public final void rule__Input__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2944:1: ( ( ( rule__Input__FileAssignment_2_1_2 ) ) )
            // InternalXtextTest.g:2946:1: ( ( rule__Input__FileAssignment_2_1_2 ) )
            {
            // InternalXtextTest.g:2946:1: ( ( rule__Input__FileAssignment_2_1_2 ) )
            // InternalXtextTest.g:2947:1: ( rule__Input__FileAssignment_2_1_2 )
            {
             before(grammarAccess.getInputAccess().getFileAssignment_2_1_2()); 
            // InternalXtextTest.g:2948:1: ( rule__Input__FileAssignment_2_1_2 )
            // InternalXtextTest.g:2948:2: rule__Input__FileAssignment_2_1_2
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
    // InternalXtextTest.g:2966:1: rule__Tokens__Group__0 : rule__Tokens__Group__0__Impl rule__Tokens__Group__1 ;
    public final void rule__Tokens__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2970:1: ( rule__Tokens__Group__0__Impl rule__Tokens__Group__1 )
            // InternalXtextTest.g:2971:2: rule__Tokens__Group__0__Impl rule__Tokens__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalXtextTest.g:2978:1: rule__Tokens__Group__0__Impl : ( () ) ;
    public final void rule__Tokens__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2982:1: ( ( () ) )
            // InternalXtextTest.g:2984:1: ( () )
            {
            // InternalXtextTest.g:2984:1: ( () )
            // InternalXtextTest.g:2985:1: ()
            {
             before(grammarAccess.getTokensAccess().getTokensAction_0()); 
            // InternalXtextTest.g:2986:1: ()
            // InternalXtextTest.g:2988:1: 
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
    // InternalXtextTest.g:3000:1: rule__Tokens__Group__1 : rule__Tokens__Group__1__Impl rule__Tokens__Group__2 ;
    public final void rule__Tokens__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3004:1: ( rule__Tokens__Group__1__Impl rule__Tokens__Group__2 )
            // InternalXtextTest.g:3005:2: rule__Tokens__Group__1__Impl rule__Tokens__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalXtextTest.g:3012:1: rule__Tokens__Group__1__Impl : ( RULE_LEXER ) ;
    public final void rule__Tokens__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3016:1: ( ( RULE_LEXER ) )
            // InternalXtextTest.g:3018:1: ( RULE_LEXER )
            {
            // InternalXtextTest.g:3018:1: ( RULE_LEXER )
            // InternalXtextTest.g:3019:1: RULE_LEXER
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
    // InternalXtextTest.g:3032:1: rule__Tokens__Group__2 : rule__Tokens__Group__2__Impl ;
    public final void rule__Tokens__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3036:1: ( rule__Tokens__Group__2__Impl )
            // InternalXtextTest.g:3037:2: rule__Tokens__Group__2__Impl
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
    // InternalXtextTest.g:3043:1: rule__Tokens__Group__2__Impl : ( ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* ) ) ;
    public final void rule__Tokens__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3047:1: ( ( ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* ) ) )
            // InternalXtextTest.g:3049:1: ( ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* ) )
            {
            // InternalXtextTest.g:3049:1: ( ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* ) )
            // InternalXtextTest.g:3050:1: ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* )
            {
            // InternalXtextTest.g:3050:1: ( ( rule__Tokens__TokensAssignment_2 ) )
            // InternalXtextTest.g:3051:1: ( rule__Tokens__TokensAssignment_2 )
            {
             before(grammarAccess.getTokensAccess().getTokensAssignment_2()); 
            // InternalXtextTest.g:3052:1: ( rule__Tokens__TokensAssignment_2 )
            // InternalXtextTest.g:3052:2: rule__Tokens__TokensAssignment_2
            {
            pushFollow(FOLLOW_25);
            rule__Tokens__TokensAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTokensAccess().getTokensAssignment_2()); 

            }

            // InternalXtextTest.g:3055:1: ( ( rule__Tokens__TokensAssignment_2 )* )
            // InternalXtextTest.g:3056:1: ( rule__Tokens__TokensAssignment_2 )*
            {
             before(grammarAccess.getTokensAccess().getTokensAssignment_2()); 
            // InternalXtextTest.g:3057:1: ( rule__Tokens__TokensAssignment_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_IDENTIFIER) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalXtextTest.g:3057:2: rule__Tokens__TokensAssignment_2
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__Tokens__TokensAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalXtextTest.g:3076:1: rule__MyTokens__Group__0 : rule__MyTokens__Group__0__Impl rule__MyTokens__Group__1 ;
    public final void rule__MyTokens__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3080:1: ( rule__MyTokens__Group__0__Impl rule__MyTokens__Group__1 )
            // InternalXtextTest.g:3081:2: rule__MyTokens__Group__0__Impl rule__MyTokens__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalXtextTest.g:3088:1: rule__MyTokens__Group__0__Impl : ( ( rule__MyTokens__TokenAssignment_0 ) ) ;
    public final void rule__MyTokens__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3092:1: ( ( ( rule__MyTokens__TokenAssignment_0 ) ) )
            // InternalXtextTest.g:3094:1: ( ( rule__MyTokens__TokenAssignment_0 ) )
            {
            // InternalXtextTest.g:3094:1: ( ( rule__MyTokens__TokenAssignment_0 ) )
            // InternalXtextTest.g:3095:1: ( rule__MyTokens__TokenAssignment_0 )
            {
             before(grammarAccess.getMyTokensAccess().getTokenAssignment_0()); 
            // InternalXtextTest.g:3096:1: ( rule__MyTokens__TokenAssignment_0 )
            // InternalXtextTest.g:3096:2: rule__MyTokens__TokenAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__MyTokens__TokenAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMyTokensAccess().getTokenAssignment_0()); 

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
    // InternalXtextTest.g:3108:1: rule__MyTokens__Group__1 : rule__MyTokens__Group__1__Impl ;
    public final void rule__MyTokens__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3112:1: ( rule__MyTokens__Group__1__Impl )
            // InternalXtextTest.g:3113:2: rule__MyTokens__Group__1__Impl
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
    // InternalXtextTest.g:3119:1: rule__MyTokens__Group__1__Impl : ( ( rule__MyTokens__Group_1__0 )? ) ;
    public final void rule__MyTokens__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3123:1: ( ( ( rule__MyTokens__Group_1__0 )? ) )
            // InternalXtextTest.g:3125:1: ( ( rule__MyTokens__Group_1__0 )? )
            {
            // InternalXtextTest.g:3125:1: ( ( rule__MyTokens__Group_1__0 )? )
            // InternalXtextTest.g:3126:1: ( rule__MyTokens__Group_1__0 )?
            {
             before(grammarAccess.getMyTokensAccess().getGroup_1()); 
            // InternalXtextTest.g:3127:1: ( rule__MyTokens__Group_1__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ASSIGNASDATALIST) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalXtextTest.g:3127:2: rule__MyTokens__Group_1__0
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
    // InternalXtextTest.g:3143:1: rule__MyTokens__Group_1__0 : rule__MyTokens__Group_1__0__Impl rule__MyTokens__Group_1__1 ;
    public final void rule__MyTokens__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3147:1: ( rule__MyTokens__Group_1__0__Impl rule__MyTokens__Group_1__1 )
            // InternalXtextTest.g:3148:2: rule__MyTokens__Group_1__0__Impl rule__MyTokens__Group_1__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalXtextTest.g:3155:1: rule__MyTokens__Group_1__0__Impl : ( RULE_ASSIGNASDATALIST ) ;
    public final void rule__MyTokens__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3159:1: ( ( RULE_ASSIGNASDATALIST ) )
            // InternalXtextTest.g:3161:1: ( RULE_ASSIGNASDATALIST )
            {
            // InternalXtextTest.g:3161:1: ( RULE_ASSIGNASDATALIST )
            // InternalXtextTest.g:3162:1: RULE_ASSIGNASDATALIST
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
    // InternalXtextTest.g:3175:1: rule__MyTokens__Group_1__1 : rule__MyTokens__Group_1__1__Impl ;
    public final void rule__MyTokens__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3179:1: ( rule__MyTokens__Group_1__1__Impl )
            // InternalXtextTest.g:3180:2: rule__MyTokens__Group_1__1__Impl
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
    // InternalXtextTest.g:3186:1: rule__MyTokens__Group_1__1__Impl : ( ( rule__MyTokens__CountAssignment_1_1 ) ) ;
    public final void rule__MyTokens__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3190:1: ( ( ( rule__MyTokens__CountAssignment_1_1 ) ) )
            // InternalXtextTest.g:3192:1: ( ( rule__MyTokens__CountAssignment_1_1 ) )
            {
            // InternalXtextTest.g:3192:1: ( ( rule__MyTokens__CountAssignment_1_1 ) )
            // InternalXtextTest.g:3193:1: ( rule__MyTokens__CountAssignment_1_1 )
            {
             before(grammarAccess.getMyTokensAccess().getCountAssignment_1_1()); 
            // InternalXtextTest.g:3194:1: ( rule__MyTokens__CountAssignment_1_1 )
            // InternalXtextTest.g:3194:2: rule__MyTokens__CountAssignment_1_1
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
    // InternalXtextTest.g:3210:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3214:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalXtextTest.g:3215:2: rule__Element__Group__0__Impl rule__Element__Group__1
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
    // InternalXtextTest.g:3222:1: rule__Element__Group__0__Impl : ( () ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3226:1: ( ( () ) )
            // InternalXtextTest.g:3228:1: ( () )
            {
            // InternalXtextTest.g:3228:1: ( () )
            // InternalXtextTest.g:3229:1: ()
            {
             before(grammarAccess.getElementAccess().getElementAction_0()); 
            // InternalXtextTest.g:3230:1: ()
            // InternalXtextTest.g:3232:1: 
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
    // InternalXtextTest.g:3244:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3248:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // InternalXtextTest.g:3249:2: rule__Element__Group__1__Impl rule__Element__Group__2
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
    // InternalXtextTest.g:3256:1: rule__Element__Group__1__Impl : ( RULE_LEFTPAREN ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3260:1: ( ( RULE_LEFTPAREN ) )
            // InternalXtextTest.g:3262:1: ( RULE_LEFTPAREN )
            {
            // InternalXtextTest.g:3262:1: ( RULE_LEFTPAREN )
            // InternalXtextTest.g:3263:1: RULE_LEFTPAREN
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
    // InternalXtextTest.g:3276:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3280:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // InternalXtextTest.g:3281:2: rule__Element__Group__2__Impl rule__Element__Group__3
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
    // InternalXtextTest.g:3288:1: rule__Element__Group__2__Impl : ( ( rule__Element__Group_2__0 )? ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3292:1: ( ( ( rule__Element__Group_2__0 )? ) )
            // InternalXtextTest.g:3294:1: ( ( rule__Element__Group_2__0 )? )
            {
            // InternalXtextTest.g:3294:1: ( ( rule__Element__Group_2__0 )? )
            // InternalXtextTest.g:3295:1: ( rule__Element__Group_2__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_2()); 
            // InternalXtextTest.g:3296:1: ( rule__Element__Group_2__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_IDENTIFIER) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==RULE_IMPORTER) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // InternalXtextTest.g:3296:2: rule__Element__Group_2__0
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
    // InternalXtextTest.g:3308:1: rule__Element__Group__3 : rule__Element__Group__3__Impl rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3312:1: ( rule__Element__Group__3__Impl rule__Element__Group__4 )
            // InternalXtextTest.g:3313:2: rule__Element__Group__3__Impl rule__Element__Group__4
            {
            pushFollow(FOLLOW_28);
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
    // InternalXtextTest.g:3320:1: rule__Element__Group__3__Impl : ( ( rule__Element__NameAssignment_3 ) ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3324:1: ( ( ( rule__Element__NameAssignment_3 ) ) )
            // InternalXtextTest.g:3326:1: ( ( rule__Element__NameAssignment_3 ) )
            {
            // InternalXtextTest.g:3326:1: ( ( rule__Element__NameAssignment_3 ) )
            // InternalXtextTest.g:3327:1: ( rule__Element__NameAssignment_3 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_3()); 
            // InternalXtextTest.g:3328:1: ( rule__Element__NameAssignment_3 )
            // InternalXtextTest.g:3328:2: rule__Element__NameAssignment_3
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
    // InternalXtextTest.g:3340:1: rule__Element__Group__4 : rule__Element__Group__4__Impl rule__Element__Group__5 ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3344:1: ( rule__Element__Group__4__Impl rule__Element__Group__5 )
            // InternalXtextTest.g:3345:2: rule__Element__Group__4__Impl rule__Element__Group__5
            {
            pushFollow(FOLLOW_28);
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
    // InternalXtextTest.g:3352:1: rule__Element__Group__4__Impl : ( ( rule__Element__Group_4__0 )? ) ;
    public final void rule__Element__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3356:1: ( ( ( rule__Element__Group_4__0 )? ) )
            // InternalXtextTest.g:3358:1: ( ( rule__Element__Group_4__0 )? )
            {
            // InternalXtextTest.g:3358:1: ( ( rule__Element__Group_4__0 )? )
            // InternalXtextTest.g:3359:1: ( rule__Element__Group_4__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_4()); 
            // InternalXtextTest.g:3360:1: ( rule__Element__Group_4__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_IDENTIFIER) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalXtextTest.g:3360:2: rule__Element__Group_4__0
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
    // InternalXtextTest.g:3372:1: rule__Element__Group__5 : rule__Element__Group__5__Impl ;
    public final void rule__Element__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3376:1: ( rule__Element__Group__5__Impl )
            // InternalXtextTest.g:3377:2: rule__Element__Group__5__Impl
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
    // InternalXtextTest.g:3383:1: rule__Element__Group__5__Impl : ( RULE_RIGHTPAREN ) ;
    public final void rule__Element__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3387:1: ( ( RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:3389:1: ( RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:3389:1: ( RULE_RIGHTPAREN )
            // InternalXtextTest.g:3390:1: RULE_RIGHTPAREN
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
    // InternalXtextTest.g:3415:1: rule__Element__Group_2__0 : rule__Element__Group_2__0__Impl rule__Element__Group_2__1 ;
    public final void rule__Element__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3419:1: ( rule__Element__Group_2__0__Impl rule__Element__Group_2__1 )
            // InternalXtextTest.g:3420:2: rule__Element__Group_2__0__Impl rule__Element__Group_2__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalXtextTest.g:3427:1: rule__Element__Group_2__0__Impl : ( ( rule__Element__ImportingAssignment_2_0 ) ) ;
    public final void rule__Element__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3431:1: ( ( ( rule__Element__ImportingAssignment_2_0 ) ) )
            // InternalXtextTest.g:3433:1: ( ( rule__Element__ImportingAssignment_2_0 ) )
            {
            // InternalXtextTest.g:3433:1: ( ( rule__Element__ImportingAssignment_2_0 ) )
            // InternalXtextTest.g:3434:1: ( rule__Element__ImportingAssignment_2_0 )
            {
             before(grammarAccess.getElementAccess().getImportingAssignment_2_0()); 
            // InternalXtextTest.g:3435:1: ( rule__Element__ImportingAssignment_2_0 )
            // InternalXtextTest.g:3435:2: rule__Element__ImportingAssignment_2_0
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
    // InternalXtextTest.g:3447:1: rule__Element__Group_2__1 : rule__Element__Group_2__1__Impl ;
    public final void rule__Element__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3451:1: ( rule__Element__Group_2__1__Impl )
            // InternalXtextTest.g:3452:2: rule__Element__Group_2__1__Impl
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
    // InternalXtextTest.g:3458:1: rule__Element__Group_2__1__Impl : ( RULE_IMPORTER ) ;
    public final void rule__Element__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3462:1: ( ( RULE_IMPORTER ) )
            // InternalXtextTest.g:3464:1: ( RULE_IMPORTER )
            {
            // InternalXtextTest.g:3464:1: ( RULE_IMPORTER )
            // InternalXtextTest.g:3465:1: RULE_IMPORTER
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
    // InternalXtextTest.g:3482:1: rule__Element__Group_4__0 : rule__Element__Group_4__0__Impl rule__Element__Group_4__1 ;
    public final void rule__Element__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3486:1: ( rule__Element__Group_4__0__Impl rule__Element__Group_4__1 )
            // InternalXtextTest.g:3487:2: rule__Element__Group_4__0__Impl rule__Element__Group_4__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalXtextTest.g:3494:1: rule__Element__Group_4__0__Impl : ( ( rule__Element__InnerAssignment_4_0 ) ) ;
    public final void rule__Element__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3498:1: ( ( ( rule__Element__InnerAssignment_4_0 ) ) )
            // InternalXtextTest.g:3500:1: ( ( rule__Element__InnerAssignment_4_0 ) )
            {
            // InternalXtextTest.g:3500:1: ( ( rule__Element__InnerAssignment_4_0 ) )
            // InternalXtextTest.g:3501:1: ( rule__Element__InnerAssignment_4_0 )
            {
             before(grammarAccess.getElementAccess().getInnerAssignment_4_0()); 
            // InternalXtextTest.g:3502:1: ( rule__Element__InnerAssignment_4_0 )
            // InternalXtextTest.g:3502:2: rule__Element__InnerAssignment_4_0
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
    // InternalXtextTest.g:3514:1: rule__Element__Group_4__1 : rule__Element__Group_4__1__Impl ;
    public final void rule__Element__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3518:1: ( rule__Element__Group_4__1__Impl )
            // InternalXtextTest.g:3519:2: rule__Element__Group_4__1__Impl
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
    // InternalXtextTest.g:3525:1: rule__Element__Group_4__1__Impl : ( ( rule__Element__Group_4_1__0 )* ) ;
    public final void rule__Element__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3529:1: ( ( ( rule__Element__Group_4_1__0 )* ) )
            // InternalXtextTest.g:3531:1: ( ( rule__Element__Group_4_1__0 )* )
            {
            // InternalXtextTest.g:3531:1: ( ( rule__Element__Group_4_1__0 )* )
            // InternalXtextTest.g:3532:1: ( rule__Element__Group_4_1__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_4_1()); 
            // InternalXtextTest.g:3533:1: ( rule__Element__Group_4_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_COMMA) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalXtextTest.g:3533:2: rule__Element__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__Element__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalXtextTest.g:3549:1: rule__Element__Group_4_1__0 : rule__Element__Group_4_1__0__Impl rule__Element__Group_4_1__1 ;
    public final void rule__Element__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3553:1: ( rule__Element__Group_4_1__0__Impl rule__Element__Group_4_1__1 )
            // InternalXtextTest.g:3554:2: rule__Element__Group_4_1__0__Impl rule__Element__Group_4_1__1
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
    // InternalXtextTest.g:3561:1: rule__Element__Group_4_1__0__Impl : ( RULE_COMMA ) ;
    public final void rule__Element__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3565:1: ( ( RULE_COMMA ) )
            // InternalXtextTest.g:3567:1: ( RULE_COMMA )
            {
            // InternalXtextTest.g:3567:1: ( RULE_COMMA )
            // InternalXtextTest.g:3568:1: RULE_COMMA
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
    // InternalXtextTest.g:3581:1: rule__Element__Group_4_1__1 : rule__Element__Group_4_1__1__Impl ;
    public final void rule__Element__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3585:1: ( rule__Element__Group_4_1__1__Impl )
            // InternalXtextTest.g:3586:2: rule__Element__Group_4_1__1__Impl
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
    // InternalXtextTest.g:3592:1: rule__Element__Group_4_1__1__Impl : ( ( rule__Element__InnerAssignment_4_1_1 ) ) ;
    public final void rule__Element__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3596:1: ( ( ( rule__Element__InnerAssignment_4_1_1 ) ) )
            // InternalXtextTest.g:3598:1: ( ( rule__Element__InnerAssignment_4_1_1 ) )
            {
            // InternalXtextTest.g:3598:1: ( ( rule__Element__InnerAssignment_4_1_1 ) )
            // InternalXtextTest.g:3599:1: ( rule__Element__InnerAssignment_4_1_1 )
            {
             before(grammarAccess.getElementAccess().getInnerAssignment_4_1_1()); 
            // InternalXtextTest.g:3600:1: ( rule__Element__InnerAssignment_4_1_1 )
            // InternalXtextTest.g:3600:2: rule__Element__InnerAssignment_4_1_1
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
    // InternalXtextTest.g:3616:1: rule__Inner__Group__0 : rule__Inner__Group__0__Impl rule__Inner__Group__1 ;
    public final void rule__Inner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3620:1: ( rule__Inner__Group__0__Impl rule__Inner__Group__1 )
            // InternalXtextTest.g:3621:2: rule__Inner__Group__0__Impl rule__Inner__Group__1
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
    // InternalXtextTest.g:3628:1: rule__Inner__Group__0__Impl : ( () ) ;
    public final void rule__Inner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3632:1: ( ( () ) )
            // InternalXtextTest.g:3634:1: ( () )
            {
            // InternalXtextTest.g:3634:1: ( () )
            // InternalXtextTest.g:3635:1: ()
            {
             before(grammarAccess.getInnerAccess().getInnerAction_0()); 
            // InternalXtextTest.g:3636:1: ()
            // InternalXtextTest.g:3638:1: 
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
    // InternalXtextTest.g:3650:1: rule__Inner__Group__1 : rule__Inner__Group__1__Impl rule__Inner__Group__2 ;
    public final void rule__Inner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3654:1: ( rule__Inner__Group__1__Impl rule__Inner__Group__2 )
            // InternalXtextTest.g:3655:2: rule__Inner__Group__1__Impl rule__Inner__Group__2
            {
            pushFollow(FOLLOW_32);
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
    // InternalXtextTest.g:3662:1: rule__Inner__Group__1__Impl : ( ( rule__Inner__ParameterAssignment_1 ) ) ;
    public final void rule__Inner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3666:1: ( ( ( rule__Inner__ParameterAssignment_1 ) ) )
            // InternalXtextTest.g:3668:1: ( ( rule__Inner__ParameterAssignment_1 ) )
            {
            // InternalXtextTest.g:3668:1: ( ( rule__Inner__ParameterAssignment_1 ) )
            // InternalXtextTest.g:3669:1: ( rule__Inner__ParameterAssignment_1 )
            {
             before(grammarAccess.getInnerAccess().getParameterAssignment_1()); 
            // InternalXtextTest.g:3670:1: ( rule__Inner__ParameterAssignment_1 )
            // InternalXtextTest.g:3670:2: rule__Inner__ParameterAssignment_1
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
    // InternalXtextTest.g:3682:1: rule__Inner__Group__2 : rule__Inner__Group__2__Impl ;
    public final void rule__Inner__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3686:1: ( rule__Inner__Group__2__Impl )
            // InternalXtextTest.g:3687:2: rule__Inner__Group__2__Impl
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
    // InternalXtextTest.g:3693:1: rule__Inner__Group__2__Impl : ( ( rule__Inner__Alternatives_2 ) ) ;
    public final void rule__Inner__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3697:1: ( ( ( rule__Inner__Alternatives_2 ) ) )
            // InternalXtextTest.g:3699:1: ( ( rule__Inner__Alternatives_2 ) )
            {
            // InternalXtextTest.g:3699:1: ( ( rule__Inner__Alternatives_2 ) )
            // InternalXtextTest.g:3700:1: ( rule__Inner__Alternatives_2 )
            {
             before(grammarAccess.getInnerAccess().getAlternatives_2()); 
            // InternalXtextTest.g:3701:1: ( rule__Inner__Alternatives_2 )
            // InternalXtextTest.g:3701:2: rule__Inner__Alternatives_2
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
    // InternalXtextTest.g:3719:1: rule__Inner__Group_2_0__0 : rule__Inner__Group_2_0__0__Impl rule__Inner__Group_2_0__1 ;
    public final void rule__Inner__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3723:1: ( rule__Inner__Group_2_0__0__Impl rule__Inner__Group_2_0__1 )
            // InternalXtextTest.g:3724:2: rule__Inner__Group_2_0__0__Impl rule__Inner__Group_2_0__1
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
    // InternalXtextTest.g:3731:1: rule__Inner__Group_2_0__0__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Inner__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3735:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:3737:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:3737:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:3738:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:3751:1: rule__Inner__Group_2_0__1 : rule__Inner__Group_2_0__1__Impl ;
    public final void rule__Inner__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3755:1: ( rule__Inner__Group_2_0__1__Impl )
            // InternalXtextTest.g:3756:2: rule__Inner__Group_2_0__1__Impl
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
    // InternalXtextTest.g:3762:1: rule__Inner__Group_2_0__1__Impl : ( ( rule__Inner__AssignAssignment_2_0_1 ) ) ;
    public final void rule__Inner__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3766:1: ( ( ( rule__Inner__AssignAssignment_2_0_1 ) ) )
            // InternalXtextTest.g:3768:1: ( ( rule__Inner__AssignAssignment_2_0_1 ) )
            {
            // InternalXtextTest.g:3768:1: ( ( rule__Inner__AssignAssignment_2_0_1 ) )
            // InternalXtextTest.g:3769:1: ( rule__Inner__AssignAssignment_2_0_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignAssignment_2_0_1()); 
            // InternalXtextTest.g:3770:1: ( rule__Inner__AssignAssignment_2_0_1 )
            // InternalXtextTest.g:3770:2: rule__Inner__AssignAssignment_2_0_1
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
    // InternalXtextTest.g:3786:1: rule__Inner__Group_2_1__0 : rule__Inner__Group_2_1__0__Impl rule__Inner__Group_2_1__1 ;
    public final void rule__Inner__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3790:1: ( rule__Inner__Group_2_1__0__Impl rule__Inner__Group_2_1__1 )
            // InternalXtextTest.g:3791:2: rule__Inner__Group_2_1__0__Impl rule__Inner__Group_2_1__1
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
    // InternalXtextTest.g:3798:1: rule__Inner__Group_2_1__0__Impl : ( RULE_ASSIGNASLIST ) ;
    public final void rule__Inner__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3802:1: ( ( RULE_ASSIGNASLIST ) )
            // InternalXtextTest.g:3804:1: ( RULE_ASSIGNASLIST )
            {
            // InternalXtextTest.g:3804:1: ( RULE_ASSIGNASLIST )
            // InternalXtextTest.g:3805:1: RULE_ASSIGNASLIST
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
    // InternalXtextTest.g:3818:1: rule__Inner__Group_2_1__1 : rule__Inner__Group_2_1__1__Impl rule__Inner__Group_2_1__2 ;
    public final void rule__Inner__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3822:1: ( rule__Inner__Group_2_1__1__Impl rule__Inner__Group_2_1__2 )
            // InternalXtextTest.g:3823:2: rule__Inner__Group_2_1__1__Impl rule__Inner__Group_2_1__2
            {
            pushFollow(FOLLOW_30);
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
    // InternalXtextTest.g:3830:1: rule__Inner__Group_2_1__1__Impl : ( ( rule__Inner__AssignListAssignment_2_1_1 ) ) ;
    public final void rule__Inner__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3834:1: ( ( ( rule__Inner__AssignListAssignment_2_1_1 ) ) )
            // InternalXtextTest.g:3836:1: ( ( rule__Inner__AssignListAssignment_2_1_1 ) )
            {
            // InternalXtextTest.g:3836:1: ( ( rule__Inner__AssignListAssignment_2_1_1 ) )
            // InternalXtextTest.g:3837:1: ( rule__Inner__AssignListAssignment_2_1_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignListAssignment_2_1_1()); 
            // InternalXtextTest.g:3838:1: ( rule__Inner__AssignListAssignment_2_1_1 )
            // InternalXtextTest.g:3838:2: rule__Inner__AssignListAssignment_2_1_1
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
    // InternalXtextTest.g:3850:1: rule__Inner__Group_2_1__2 : rule__Inner__Group_2_1__2__Impl ;
    public final void rule__Inner__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3854:1: ( rule__Inner__Group_2_1__2__Impl )
            // InternalXtextTest.g:3855:2: rule__Inner__Group_2_1__2__Impl
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
    // InternalXtextTest.g:3861:1: rule__Inner__Group_2_1__2__Impl : ( ( rule__Inner__Group_2_1_2__0 )* ) ;
    public final void rule__Inner__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3865:1: ( ( ( rule__Inner__Group_2_1_2__0 )* ) )
            // InternalXtextTest.g:3867:1: ( ( rule__Inner__Group_2_1_2__0 )* )
            {
            // InternalXtextTest.g:3867:1: ( ( rule__Inner__Group_2_1_2__0 )* )
            // InternalXtextTest.g:3868:1: ( rule__Inner__Group_2_1_2__0 )*
            {
             before(grammarAccess.getInnerAccess().getGroup_2_1_2()); 
            // InternalXtextTest.g:3869:1: ( rule__Inner__Group_2_1_2__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_COMMA) ) {
                    int LA24_2 = input.LA(2);

                    if ( (LA24_2==RULE_LEFTPAREN) ) {
                        alt24=1;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // InternalXtextTest.g:3869:2: rule__Inner__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__Inner__Group_2_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalXtextTest.g:3887:1: rule__Inner__Group_2_1_2__0 : rule__Inner__Group_2_1_2__0__Impl rule__Inner__Group_2_1_2__1 ;
    public final void rule__Inner__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3891:1: ( rule__Inner__Group_2_1_2__0__Impl rule__Inner__Group_2_1_2__1 )
            // InternalXtextTest.g:3892:2: rule__Inner__Group_2_1_2__0__Impl rule__Inner__Group_2_1_2__1
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
    // InternalXtextTest.g:3899:1: rule__Inner__Group_2_1_2__0__Impl : ( RULE_COMMA ) ;
    public final void rule__Inner__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3903:1: ( ( RULE_COMMA ) )
            // InternalXtextTest.g:3905:1: ( RULE_COMMA )
            {
            // InternalXtextTest.g:3905:1: ( RULE_COMMA )
            // InternalXtextTest.g:3906:1: RULE_COMMA
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
    // InternalXtextTest.g:3919:1: rule__Inner__Group_2_1_2__1 : rule__Inner__Group_2_1_2__1__Impl ;
    public final void rule__Inner__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3923:1: ( rule__Inner__Group_2_1_2__1__Impl )
            // InternalXtextTest.g:3924:2: rule__Inner__Group_2_1_2__1__Impl
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
    // InternalXtextTest.g:3930:1: rule__Inner__Group_2_1_2__1__Impl : ( ( rule__Inner__AssignListAssignment_2_1_2_1 ) ) ;
    public final void rule__Inner__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3934:1: ( ( ( rule__Inner__AssignListAssignment_2_1_2_1 ) ) )
            // InternalXtextTest.g:3936:1: ( ( rule__Inner__AssignListAssignment_2_1_2_1 ) )
            {
            // InternalXtextTest.g:3936:1: ( ( rule__Inner__AssignListAssignment_2_1_2_1 ) )
            // InternalXtextTest.g:3937:1: ( rule__Inner__AssignListAssignment_2_1_2_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignListAssignment_2_1_2_1()); 
            // InternalXtextTest.g:3938:1: ( rule__Inner__AssignListAssignment_2_1_2_1 )
            // InternalXtextTest.g:3938:2: rule__Inner__AssignListAssignment_2_1_2_1
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
    // InternalXtextTest.g:3954:1: rule__Inner__Group_2_2__0 : rule__Inner__Group_2_2__0__Impl rule__Inner__Group_2_2__1 ;
    public final void rule__Inner__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3958:1: ( rule__Inner__Group_2_2__0__Impl rule__Inner__Group_2_2__1 )
            // InternalXtextTest.g:3959:2: rule__Inner__Group_2_2__0__Impl rule__Inner__Group_2_2__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalXtextTest.g:3966:1: rule__Inner__Group_2_2__0__Impl : ( RULE_ASSIGNASSTRING ) ;
    public final void rule__Inner__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3970:1: ( ( RULE_ASSIGNASSTRING ) )
            // InternalXtextTest.g:3972:1: ( RULE_ASSIGNASSTRING )
            {
            // InternalXtextTest.g:3972:1: ( RULE_ASSIGNASSTRING )
            // InternalXtextTest.g:3973:1: RULE_ASSIGNASSTRING
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
    // InternalXtextTest.g:3986:1: rule__Inner__Group_2_2__1 : rule__Inner__Group_2_2__1__Impl ;
    public final void rule__Inner__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3990:1: ( rule__Inner__Group_2_2__1__Impl )
            // InternalXtextTest.g:3991:2: rule__Inner__Group_2_2__1__Impl
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
    // InternalXtextTest.g:3997:1: rule__Inner__Group_2_2__1__Impl : ( ( rule__Inner__ValueAssignment_2_2_1 ) ) ;
    public final void rule__Inner__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4001:1: ( ( ( rule__Inner__ValueAssignment_2_2_1 ) ) )
            // InternalXtextTest.g:4003:1: ( ( rule__Inner__ValueAssignment_2_2_1 ) )
            {
            // InternalXtextTest.g:4003:1: ( ( rule__Inner__ValueAssignment_2_2_1 ) )
            // InternalXtextTest.g:4004:1: ( rule__Inner__ValueAssignment_2_2_1 )
            {
             before(grammarAccess.getInnerAccess().getValueAssignment_2_2_1()); 
            // InternalXtextTest.g:4005:1: ( rule__Inner__ValueAssignment_2_2_1 )
            // InternalXtextTest.g:4005:2: rule__Inner__ValueAssignment_2_2_1
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
    // InternalXtextTest.g:4021:1: rule__Inner__Group_2_3__0 : rule__Inner__Group_2_3__0__Impl rule__Inner__Group_2_3__1 ;
    public final void rule__Inner__Group_2_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4025:1: ( rule__Inner__Group_2_3__0__Impl rule__Inner__Group_2_3__1 )
            // InternalXtextTest.g:4026:2: rule__Inner__Group_2_3__0__Impl rule__Inner__Group_2_3__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalXtextTest.g:4033:1: rule__Inner__Group_2_3__0__Impl : ( RULE_ASSIGNASDATALIST ) ;
    public final void rule__Inner__Group_2_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4037:1: ( ( RULE_ASSIGNASDATALIST ) )
            // InternalXtextTest.g:4039:1: ( RULE_ASSIGNASDATALIST )
            {
            // InternalXtextTest.g:4039:1: ( RULE_ASSIGNASDATALIST )
            // InternalXtextTest.g:4040:1: RULE_ASSIGNASDATALIST
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
    // InternalXtextTest.g:4053:1: rule__Inner__Group_2_3__1 : rule__Inner__Group_2_3__1__Impl ;
    public final void rule__Inner__Group_2_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4057:1: ( rule__Inner__Group_2_3__1__Impl )
            // InternalXtextTest.g:4058:2: rule__Inner__Group_2_3__1__Impl
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
    // InternalXtextTest.g:4064:1: rule__Inner__Group_2_3__1__Impl : ( ( rule__Inner__AssignAsDataAssignment_2_3_1 ) ) ;
    public final void rule__Inner__Group_2_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4068:1: ( ( ( rule__Inner__AssignAsDataAssignment_2_3_1 ) ) )
            // InternalXtextTest.g:4070:1: ( ( rule__Inner__AssignAsDataAssignment_2_3_1 ) )
            {
            // InternalXtextTest.g:4070:1: ( ( rule__Inner__AssignAsDataAssignment_2_3_1 ) )
            // InternalXtextTest.g:4071:1: ( rule__Inner__AssignAsDataAssignment_2_3_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignAsDataAssignment_2_3_1()); 
            // InternalXtextTest.g:4072:1: ( rule__Inner__AssignAsDataAssignment_2_3_1 )
            // InternalXtextTest.g:4072:2: rule__Inner__AssignAsDataAssignment_2_3_1
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
    // InternalXtextTest.g:4088:1: rule__Inner__Group_2_4__0 : rule__Inner__Group_2_4__0__Impl rule__Inner__Group_2_4__1 ;
    public final void rule__Inner__Group_2_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4092:1: ( rule__Inner__Group_2_4__0__Impl rule__Inner__Group_2_4__1 )
            // InternalXtextTest.g:4093:2: rule__Inner__Group_2_4__0__Impl rule__Inner__Group_2_4__1
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
    // InternalXtextTest.g:4100:1: rule__Inner__Group_2_4__0__Impl : ( RULE_ASSIGNASBOOL ) ;
    public final void rule__Inner__Group_2_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4104:1: ( ( RULE_ASSIGNASBOOL ) )
            // InternalXtextTest.g:4106:1: ( RULE_ASSIGNASBOOL )
            {
            // InternalXtextTest.g:4106:1: ( RULE_ASSIGNASBOOL )
            // InternalXtextTest.g:4107:1: RULE_ASSIGNASBOOL
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
    // InternalXtextTest.g:4120:1: rule__Inner__Group_2_4__1 : rule__Inner__Group_2_4__1__Impl ;
    public final void rule__Inner__Group_2_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4124:1: ( rule__Inner__Group_2_4__1__Impl )
            // InternalXtextTest.g:4125:2: rule__Inner__Group_2_4__1__Impl
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
    // InternalXtextTest.g:4131:1: rule__Inner__Group_2_4__1__Impl : ( ( rule__Inner__AssignAsBoolAssignment_2_4_1 ) ) ;
    public final void rule__Inner__Group_2_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4135:1: ( ( ( rule__Inner__AssignAsBoolAssignment_2_4_1 ) ) )
            // InternalXtextTest.g:4137:1: ( ( rule__Inner__AssignAsBoolAssignment_2_4_1 ) )
            {
            // InternalXtextTest.g:4137:1: ( ( rule__Inner__AssignAsBoolAssignment_2_4_1 ) )
            // InternalXtextTest.g:4138:1: ( rule__Inner__AssignAsBoolAssignment_2_4_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignAsBoolAssignment_2_4_1()); 
            // InternalXtextTest.g:4139:1: ( rule__Inner__AssignAsBoolAssignment_2_4_1 )
            // InternalXtextTest.g:4139:2: rule__Inner__AssignAsBoolAssignment_2_4_1
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
    // InternalXtextTest.g:4155:1: rule__Generator__Group__0 : rule__Generator__Group__0__Impl rule__Generator__Group__1 ;
    public final void rule__Generator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4159:1: ( rule__Generator__Group__0__Impl rule__Generator__Group__1 )
            // InternalXtextTest.g:4160:2: rule__Generator__Group__0__Impl rule__Generator__Group__1
            {
            pushFollow(FOLLOW_33);
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
    // InternalXtextTest.g:4167:1: rule__Generator__Group__0__Impl : ( () ) ;
    public final void rule__Generator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4171:1: ( ( () ) )
            // InternalXtextTest.g:4173:1: ( () )
            {
            // InternalXtextTest.g:4173:1: ( () )
            // InternalXtextTest.g:4174:1: ()
            {
             before(grammarAccess.getGeneratorAccess().getGeneratorAction_0()); 
            // InternalXtextTest.g:4175:1: ()
            // InternalXtextTest.g:4177:1: 
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
    // InternalXtextTest.g:4189:1: rule__Generator__Group__1 : rule__Generator__Group__1__Impl rule__Generator__Group__2 ;
    public final void rule__Generator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4193:1: ( rule__Generator__Group__1__Impl rule__Generator__Group__2 )
            // InternalXtextTest.g:4194:2: rule__Generator__Group__1__Impl rule__Generator__Group__2
            {
            pushFollow(FOLLOW_34);
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
    // InternalXtextTest.g:4201:1: rule__Generator__Group__1__Impl : ( ( rule__Generator__Group_1__0 ) ) ;
    public final void rule__Generator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4205:1: ( ( ( rule__Generator__Group_1__0 ) ) )
            // InternalXtextTest.g:4207:1: ( ( rule__Generator__Group_1__0 ) )
            {
            // InternalXtextTest.g:4207:1: ( ( rule__Generator__Group_1__0 ) )
            // InternalXtextTest.g:4208:1: ( rule__Generator__Group_1__0 )
            {
             before(grammarAccess.getGeneratorAccess().getGroup_1()); 
            // InternalXtextTest.g:4209:1: ( rule__Generator__Group_1__0 )
            // InternalXtextTest.g:4209:2: rule__Generator__Group_1__0
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
    // InternalXtextTest.g:4221:1: rule__Generator__Group__2 : rule__Generator__Group__2__Impl rule__Generator__Group__3 ;
    public final void rule__Generator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4225:1: ( rule__Generator__Group__2__Impl rule__Generator__Group__3 )
            // InternalXtextTest.g:4226:2: rule__Generator__Group__2__Impl rule__Generator__Group__3
            {
            pushFollow(FOLLOW_35);
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
    // InternalXtextTest.g:4233:1: rule__Generator__Group__2__Impl : ( ( rule__Generator__Group_2__0 ) ) ;
    public final void rule__Generator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4237:1: ( ( ( rule__Generator__Group_2__0 ) ) )
            // InternalXtextTest.g:4239:1: ( ( rule__Generator__Group_2__0 ) )
            {
            // InternalXtextTest.g:4239:1: ( ( rule__Generator__Group_2__0 ) )
            // InternalXtextTest.g:4240:1: ( rule__Generator__Group_2__0 )
            {
             before(grammarAccess.getGeneratorAccess().getGroup_2()); 
            // InternalXtextTest.g:4241:1: ( rule__Generator__Group_2__0 )
            // InternalXtextTest.g:4241:2: rule__Generator__Group_2__0
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
    // InternalXtextTest.g:4253:1: rule__Generator__Group__3 : rule__Generator__Group__3__Impl rule__Generator__Group__4 ;
    public final void rule__Generator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4257:1: ( rule__Generator__Group__3__Impl rule__Generator__Group__4 )
            // InternalXtextTest.g:4258:2: rule__Generator__Group__3__Impl rule__Generator__Group__4
            {
            pushFollow(FOLLOW_35);
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
    // InternalXtextTest.g:4265:1: rule__Generator__Group__3__Impl : ( ( rule__Generator__Group_3__0 )? ) ;
    public final void rule__Generator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4269:1: ( ( ( rule__Generator__Group_3__0 )? ) )
            // InternalXtextTest.g:4271:1: ( ( rule__Generator__Group_3__0 )? )
            {
            // InternalXtextTest.g:4271:1: ( ( rule__Generator__Group_3__0 )? )
            // InternalXtextTest.g:4272:1: ( rule__Generator__Group_3__0 )?
            {
             before(grammarAccess.getGeneratorAccess().getGroup_3()); 
            // InternalXtextTest.g:4273:1: ( rule__Generator__Group_3__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_PATTERNS) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalXtextTest.g:4273:2: rule__Generator__Group_3__0
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
    // InternalXtextTest.g:4285:1: rule__Generator__Group__4 : rule__Generator__Group__4__Impl ;
    public final void rule__Generator__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4289:1: ( rule__Generator__Group__4__Impl )
            // InternalXtextTest.g:4290:2: rule__Generator__Group__4__Impl
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
    // InternalXtextTest.g:4296:1: rule__Generator__Group__4__Impl : ( ( rule__Generator__Group_4__0 )? ) ;
    public final void rule__Generator__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4300:1: ( ( ( rule__Generator__Group_4__0 )? ) )
            // InternalXtextTest.g:4302:1: ( ( rule__Generator__Group_4__0 )? )
            {
            // InternalXtextTest.g:4302:1: ( ( rule__Generator__Group_4__0 )? )
            // InternalXtextTest.g:4303:1: ( rule__Generator__Group_4__0 )?
            {
             before(grammarAccess.getGeneratorAccess().getGroup_4()); 
            // InternalXtextTest.g:4304:1: ( rule__Generator__Group_4__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_EXPECTED) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalXtextTest.g:4304:2: rule__Generator__Group_4__0
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
    // InternalXtextTest.g:4326:1: rule__Generator__Group_1__0 : rule__Generator__Group_1__0__Impl rule__Generator__Group_1__1 ;
    public final void rule__Generator__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4330:1: ( rule__Generator__Group_1__0__Impl rule__Generator__Group_1__1 )
            // InternalXtextTest.g:4331:2: rule__Generator__Group_1__0__Impl rule__Generator__Group_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalXtextTest.g:4338:1: rule__Generator__Group_1__0__Impl : ( RULE_OUTPUT ) ;
    public final void rule__Generator__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4342:1: ( ( RULE_OUTPUT ) )
            // InternalXtextTest.g:4344:1: ( RULE_OUTPUT )
            {
            // InternalXtextTest.g:4344:1: ( RULE_OUTPUT )
            // InternalXtextTest.g:4345:1: RULE_OUTPUT
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
    // InternalXtextTest.g:4358:1: rule__Generator__Group_1__1 : rule__Generator__Group_1__1__Impl rule__Generator__Group_1__2 ;
    public final void rule__Generator__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4362:1: ( rule__Generator__Group_1__1__Impl rule__Generator__Group_1__2 )
            // InternalXtextTest.g:4363:2: rule__Generator__Group_1__1__Impl rule__Generator__Group_1__2
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
    // InternalXtextTest.g:4370:1: rule__Generator__Group_1__1__Impl : ( RULE_FILE ) ;
    public final void rule__Generator__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4374:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:4376:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:4376:1: ( RULE_FILE )
            // InternalXtextTest.g:4377:1: RULE_FILE
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
    // InternalXtextTest.g:4390:1: rule__Generator__Group_1__2 : rule__Generator__Group_1__2__Impl rule__Generator__Group_1__3 ;
    public final void rule__Generator__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4394:1: ( rule__Generator__Group_1__2__Impl rule__Generator__Group_1__3 )
            // InternalXtextTest.g:4395:2: rule__Generator__Group_1__2__Impl rule__Generator__Group_1__3
            {
            pushFollow(FOLLOW_18);
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
    // InternalXtextTest.g:4402:1: rule__Generator__Group_1__2__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Generator__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4406:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:4408:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:4408:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:4409:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:4422:1: rule__Generator__Group_1__3 : rule__Generator__Group_1__3__Impl ;
    public final void rule__Generator__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4426:1: ( rule__Generator__Group_1__3__Impl )
            // InternalXtextTest.g:4427:2: rule__Generator__Group_1__3__Impl
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
    // InternalXtextTest.g:4433:1: rule__Generator__Group_1__3__Impl : ( ( rule__Generator__OutputAssignment_1_3 ) ) ;
    public final void rule__Generator__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4437:1: ( ( ( rule__Generator__OutputAssignment_1_3 ) ) )
            // InternalXtextTest.g:4439:1: ( ( rule__Generator__OutputAssignment_1_3 ) )
            {
            // InternalXtextTest.g:4439:1: ( ( rule__Generator__OutputAssignment_1_3 ) )
            // InternalXtextTest.g:4440:1: ( rule__Generator__OutputAssignment_1_3 )
            {
             before(grammarAccess.getGeneratorAccess().getOutputAssignment_1_3()); 
            // InternalXtextTest.g:4441:1: ( rule__Generator__OutputAssignment_1_3 )
            // InternalXtextTest.g:4441:2: rule__Generator__OutputAssignment_1_3
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
    // InternalXtextTest.g:4461:1: rule__Generator__Group_2__0 : rule__Generator__Group_2__0__Impl rule__Generator__Group_2__1 ;
    public final void rule__Generator__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4465:1: ( rule__Generator__Group_2__0__Impl rule__Generator__Group_2__1 )
            // InternalXtextTest.g:4466:2: rule__Generator__Group_2__0__Impl rule__Generator__Group_2__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalXtextTest.g:4473:1: rule__Generator__Group_2__0__Impl : ( RULE_EXPECTED ) ;
    public final void rule__Generator__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4477:1: ( ( RULE_EXPECTED ) )
            // InternalXtextTest.g:4479:1: ( RULE_EXPECTED )
            {
            // InternalXtextTest.g:4479:1: ( RULE_EXPECTED )
            // InternalXtextTest.g:4480:1: RULE_EXPECTED
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
    // InternalXtextTest.g:4493:1: rule__Generator__Group_2__1 : rule__Generator__Group_2__1__Impl rule__Generator__Group_2__2 ;
    public final void rule__Generator__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4497:1: ( rule__Generator__Group_2__1__Impl rule__Generator__Group_2__2 )
            // InternalXtextTest.g:4498:2: rule__Generator__Group_2__1__Impl rule__Generator__Group_2__2
            {
            pushFollow(FOLLOW_36);
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
    // InternalXtextTest.g:4505:1: rule__Generator__Group_2__1__Impl : ( RULE_FILE ) ;
    public final void rule__Generator__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4509:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:4511:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:4511:1: ( RULE_FILE )
            // InternalXtextTest.g:4512:1: RULE_FILE
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
    // InternalXtextTest.g:4525:1: rule__Generator__Group_2__2 : rule__Generator__Group_2__2__Impl ;
    public final void rule__Generator__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4529:1: ( rule__Generator__Group_2__2__Impl )
            // InternalXtextTest.g:4530:2: rule__Generator__Group_2__2__Impl
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
    // InternalXtextTest.g:4536:1: rule__Generator__Group_2__2__Impl : ( ( rule__Generator__Alternatives_2_2 ) ) ;
    public final void rule__Generator__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4540:1: ( ( ( rule__Generator__Alternatives_2_2 ) ) )
            // InternalXtextTest.g:4542:1: ( ( rule__Generator__Alternatives_2_2 ) )
            {
            // InternalXtextTest.g:4542:1: ( ( rule__Generator__Alternatives_2_2 ) )
            // InternalXtextTest.g:4543:1: ( rule__Generator__Alternatives_2_2 )
            {
             before(grammarAccess.getGeneratorAccess().getAlternatives_2_2()); 
            // InternalXtextTest.g:4544:1: ( rule__Generator__Alternatives_2_2 )
            // InternalXtextTest.g:4544:2: rule__Generator__Alternatives_2_2
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
    // InternalXtextTest.g:4562:1: rule__Generator__Group_2_2_0__0 : rule__Generator__Group_2_2_0__0__Impl rule__Generator__Group_2_2_0__1 ;
    public final void rule__Generator__Group_2_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4566:1: ( rule__Generator__Group_2_2_0__0__Impl rule__Generator__Group_2_2_0__1 )
            // InternalXtextTest.g:4567:2: rule__Generator__Group_2_2_0__0__Impl rule__Generator__Group_2_2_0__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalXtextTest.g:4574:1: rule__Generator__Group_2_2_0__0__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Generator__Group_2_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4578:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:4580:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:4580:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:4581:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:4594:1: rule__Generator__Group_2_2_0__1 : rule__Generator__Group_2_2_0__1__Impl ;
    public final void rule__Generator__Group_2_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4598:1: ( rule__Generator__Group_2_2_0__1__Impl )
            // InternalXtextTest.g:4599:2: rule__Generator__Group_2_2_0__1__Impl
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
    // InternalXtextTest.g:4605:1: rule__Generator__Group_2_2_0__1__Impl : ( ( rule__Generator__ExpectedAssignment_2_2_0_1 ) ) ;
    public final void rule__Generator__Group_2_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4609:1: ( ( ( rule__Generator__ExpectedAssignment_2_2_0_1 ) ) )
            // InternalXtextTest.g:4611:1: ( ( rule__Generator__ExpectedAssignment_2_2_0_1 ) )
            {
            // InternalXtextTest.g:4611:1: ( ( rule__Generator__ExpectedAssignment_2_2_0_1 ) )
            // InternalXtextTest.g:4612:1: ( rule__Generator__ExpectedAssignment_2_2_0_1 )
            {
             before(grammarAccess.getGeneratorAccess().getExpectedAssignment_2_2_0_1()); 
            // InternalXtextTest.g:4613:1: ( rule__Generator__ExpectedAssignment_2_2_0_1 )
            // InternalXtextTest.g:4613:2: rule__Generator__ExpectedAssignment_2_2_0_1
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
    // InternalXtextTest.g:4629:1: rule__Generator__Group_3__0 : rule__Generator__Group_3__0__Impl rule__Generator__Group_3__1 ;
    public final void rule__Generator__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4633:1: ( rule__Generator__Group_3__0__Impl rule__Generator__Group_3__1 )
            // InternalXtextTest.g:4634:2: rule__Generator__Group_3__0__Impl rule__Generator__Group_3__1
            {
            pushFollow(FOLLOW_37);
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
    // InternalXtextTest.g:4641:1: rule__Generator__Group_3__0__Impl : ( RULE_PATTERNS ) ;
    public final void rule__Generator__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4645:1: ( ( RULE_PATTERNS ) )
            // InternalXtextTest.g:4647:1: ( RULE_PATTERNS )
            {
            // InternalXtextTest.g:4647:1: ( RULE_PATTERNS )
            // InternalXtextTest.g:4648:1: RULE_PATTERNS
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
    // InternalXtextTest.g:4661:1: rule__Generator__Group_3__1 : rule__Generator__Group_3__1__Impl rule__Generator__Group_3__2 ;
    public final void rule__Generator__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4665:1: ( rule__Generator__Group_3__1__Impl rule__Generator__Group_3__2 )
            // InternalXtextTest.g:4666:2: rule__Generator__Group_3__1__Impl rule__Generator__Group_3__2
            {
            pushFollow(FOLLOW_37);
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
    // InternalXtextTest.g:4673:1: rule__Generator__Group_3__1__Impl : ( ( rule__Generator__Group_3_1__0 )? ) ;
    public final void rule__Generator__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4677:1: ( ( ( rule__Generator__Group_3_1__0 )? ) )
            // InternalXtextTest.g:4679:1: ( ( rule__Generator__Group_3_1__0 )? )
            {
            // InternalXtextTest.g:4679:1: ( ( rule__Generator__Group_3_1__0 )? )
            // InternalXtextTest.g:4680:1: ( rule__Generator__Group_3_1__0 )?
            {
             before(grammarAccess.getGeneratorAccess().getGroup_3_1()); 
            // InternalXtextTest.g:4681:1: ( rule__Generator__Group_3_1__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_FILE) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalXtextTest.g:4681:2: rule__Generator__Group_3_1__0
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
    // InternalXtextTest.g:4693:1: rule__Generator__Group_3__2 : rule__Generator__Group_3__2__Impl ;
    public final void rule__Generator__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4697:1: ( rule__Generator__Group_3__2__Impl )
            // InternalXtextTest.g:4698:2: rule__Generator__Group_3__2__Impl
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
    // InternalXtextTest.g:4704:1: rule__Generator__Group_3__2__Impl : ( ( rule__Generator__ReplacePatternsAssignment_3_2 )* ) ;
    public final void rule__Generator__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4708:1: ( ( ( rule__Generator__ReplacePatternsAssignment_3_2 )* ) )
            // InternalXtextTest.g:4710:1: ( ( rule__Generator__ReplacePatternsAssignment_3_2 )* )
            {
            // InternalXtextTest.g:4710:1: ( ( rule__Generator__ReplacePatternsAssignment_3_2 )* )
            // InternalXtextTest.g:4711:1: ( rule__Generator__ReplacePatternsAssignment_3_2 )*
            {
             before(grammarAccess.getGeneratorAccess().getReplacePatternsAssignment_3_2()); 
            // InternalXtextTest.g:4712:1: ( rule__Generator__ReplacePatternsAssignment_3_2 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_STRING) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalXtextTest.g:4712:2: rule__Generator__ReplacePatternsAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_38);
            	    rule__Generator__ReplacePatternsAssignment_3_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // InternalXtextTest.g:4730:1: rule__Generator__Group_3_1__0 : rule__Generator__Group_3_1__0__Impl rule__Generator__Group_3_1__1 ;
    public final void rule__Generator__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4734:1: ( rule__Generator__Group_3_1__0__Impl rule__Generator__Group_3_1__1 )
            // InternalXtextTest.g:4735:2: rule__Generator__Group_3_1__0__Impl rule__Generator__Group_3_1__1
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
    // InternalXtextTest.g:4742:1: rule__Generator__Group_3_1__0__Impl : ( RULE_FILE ) ;
    public final void rule__Generator__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4746:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:4748:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:4748:1: ( RULE_FILE )
            // InternalXtextTest.g:4749:1: RULE_FILE
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
    // InternalXtextTest.g:4762:1: rule__Generator__Group_3_1__1 : rule__Generator__Group_3_1__1__Impl rule__Generator__Group_3_1__2 ;
    public final void rule__Generator__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4766:1: ( rule__Generator__Group_3_1__1__Impl rule__Generator__Group_3_1__2 )
            // InternalXtextTest.g:4767:2: rule__Generator__Group_3_1__1__Impl rule__Generator__Group_3_1__2
            {
            pushFollow(FOLLOW_18);
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
    // InternalXtextTest.g:4774:1: rule__Generator__Group_3_1__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Generator__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4778:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:4780:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:4780:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:4781:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:4794:1: rule__Generator__Group_3_1__2 : rule__Generator__Group_3_1__2__Impl ;
    public final void rule__Generator__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4798:1: ( rule__Generator__Group_3_1__2__Impl )
            // InternalXtextTest.g:4799:2: rule__Generator__Group_3_1__2__Impl
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
    // InternalXtextTest.g:4805:1: rule__Generator__Group_3_1__2__Impl : ( ( rule__Generator__PatternFileAssignment_3_1_2 ) ) ;
    public final void rule__Generator__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4809:1: ( ( ( rule__Generator__PatternFileAssignment_3_1_2 ) ) )
            // InternalXtextTest.g:4811:1: ( ( rule__Generator__PatternFileAssignment_3_1_2 ) )
            {
            // InternalXtextTest.g:4811:1: ( ( rule__Generator__PatternFileAssignment_3_1_2 ) )
            // InternalXtextTest.g:4812:1: ( rule__Generator__PatternFileAssignment_3_1_2 )
            {
             before(grammarAccess.getGeneratorAccess().getPatternFileAssignment_3_1_2()); 
            // InternalXtextTest.g:4813:1: ( rule__Generator__PatternFileAssignment_3_1_2 )
            // InternalXtextTest.g:4813:2: rule__Generator__PatternFileAssignment_3_1_2
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
    // InternalXtextTest.g:4831:1: rule__Generator__Group_4__0 : rule__Generator__Group_4__0__Impl rule__Generator__Group_4__1 ;
    public final void rule__Generator__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4835:1: ( rule__Generator__Group_4__0__Impl rule__Generator__Group_4__1 )
            // InternalXtextTest.g:4836:2: rule__Generator__Group_4__0__Impl rule__Generator__Group_4__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalXtextTest.g:4843:1: rule__Generator__Group_4__0__Impl : ( RULE_EXPECTED ) ;
    public final void rule__Generator__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4847:1: ( ( RULE_EXPECTED ) )
            // InternalXtextTest.g:4849:1: ( RULE_EXPECTED )
            {
            // InternalXtextTest.g:4849:1: ( RULE_EXPECTED )
            // InternalXtextTest.g:4850:1: RULE_EXPECTED
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
    // InternalXtextTest.g:4863:1: rule__Generator__Group_4__1 : rule__Generator__Group_4__1__Impl rule__Generator__Group_4__2 ;
    public final void rule__Generator__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4867:1: ( rule__Generator__Group_4__1__Impl rule__Generator__Group_4__2 )
            // InternalXtextTest.g:4868:2: rule__Generator__Group_4__1__Impl rule__Generator__Group_4__2
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
    // InternalXtextTest.g:4875:1: rule__Generator__Group_4__1__Impl : ( RULE_EXCEPTIONS ) ;
    public final void rule__Generator__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4879:1: ( ( RULE_EXCEPTIONS ) )
            // InternalXtextTest.g:4881:1: ( RULE_EXCEPTIONS )
            {
            // InternalXtextTest.g:4881:1: ( RULE_EXCEPTIONS )
            // InternalXtextTest.g:4882:1: RULE_EXCEPTIONS
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
    // InternalXtextTest.g:4895:1: rule__Generator__Group_4__2 : rule__Generator__Group_4__2__Impl ;
    public final void rule__Generator__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4899:1: ( rule__Generator__Group_4__2__Impl )
            // InternalXtextTest.g:4900:2: rule__Generator__Group_4__2__Impl
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
    // InternalXtextTest.g:4906:1: rule__Generator__Group_4__2__Impl : ( ( rule__Generator__ExceptionAssignment_4_2 ) ) ;
    public final void rule__Generator__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4910:1: ( ( ( rule__Generator__ExceptionAssignment_4_2 ) ) )
            // InternalXtextTest.g:4912:1: ( ( rule__Generator__ExceptionAssignment_4_2 ) )
            {
            // InternalXtextTest.g:4912:1: ( ( rule__Generator__ExceptionAssignment_4_2 ) )
            // InternalXtextTest.g:4913:1: ( rule__Generator__ExceptionAssignment_4_2 )
            {
             before(grammarAccess.getGeneratorAccess().getExceptionAssignment_4_2()); 
            // InternalXtextTest.g:4914:1: ( rule__Generator__ExceptionAssignment_4_2 )
            // InternalXtextTest.g:4914:2: rule__Generator__ExceptionAssignment_4_2
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
    // InternalXtextTest.g:4932:1: rule__ReplacePatterns__Group__0 : rule__ReplacePatterns__Group__0__Impl rule__ReplacePatterns__Group__1 ;
    public final void rule__ReplacePatterns__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4936:1: ( rule__ReplacePatterns__Group__0__Impl rule__ReplacePatterns__Group__1 )
            // InternalXtextTest.g:4937:2: rule__ReplacePatterns__Group__0__Impl rule__ReplacePatterns__Group__1
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
    // InternalXtextTest.g:4944:1: rule__ReplacePatterns__Group__0__Impl : ( ( rule__ReplacePatterns__RegexAssignment_0 ) ) ;
    public final void rule__ReplacePatterns__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4948:1: ( ( ( rule__ReplacePatterns__RegexAssignment_0 ) ) )
            // InternalXtextTest.g:4950:1: ( ( rule__ReplacePatterns__RegexAssignment_0 ) )
            {
            // InternalXtextTest.g:4950:1: ( ( rule__ReplacePatterns__RegexAssignment_0 ) )
            // InternalXtextTest.g:4951:1: ( rule__ReplacePatterns__RegexAssignment_0 )
            {
             before(grammarAccess.getReplacePatternsAccess().getRegexAssignment_0()); 
            // InternalXtextTest.g:4952:1: ( rule__ReplacePatterns__RegexAssignment_0 )
            // InternalXtextTest.g:4952:2: rule__ReplacePatterns__RegexAssignment_0
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
    // InternalXtextTest.g:4964:1: rule__ReplacePatterns__Group__1 : rule__ReplacePatterns__Group__1__Impl rule__ReplacePatterns__Group__2 ;
    public final void rule__ReplacePatterns__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4968:1: ( rule__ReplacePatterns__Group__1__Impl rule__ReplacePatterns__Group__2 )
            // InternalXtextTest.g:4969:2: rule__ReplacePatterns__Group__1__Impl rule__ReplacePatterns__Group__2
            {
            pushFollow(FOLLOW_18);
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
    // InternalXtextTest.g:4976:1: rule__ReplacePatterns__Group__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__ReplacePatterns__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4980:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:4982:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:4982:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:4983:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:4996:1: rule__ReplacePatterns__Group__2 : rule__ReplacePatterns__Group__2__Impl ;
    public final void rule__ReplacePatterns__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5000:1: ( rule__ReplacePatterns__Group__2__Impl )
            // InternalXtextTest.g:5001:2: rule__ReplacePatterns__Group__2__Impl
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
    // InternalXtextTest.g:5007:1: rule__ReplacePatterns__Group__2__Impl : ( ( rule__ReplacePatterns__ReplaceAssignment_2 ) ) ;
    public final void rule__ReplacePatterns__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5011:1: ( ( ( rule__ReplacePatterns__ReplaceAssignment_2 ) ) )
            // InternalXtextTest.g:5013:1: ( ( rule__ReplacePatterns__ReplaceAssignment_2 ) )
            {
            // InternalXtextTest.g:5013:1: ( ( rule__ReplacePatterns__ReplaceAssignment_2 ) )
            // InternalXtextTest.g:5014:1: ( rule__ReplacePatterns__ReplaceAssignment_2 )
            {
             before(grammarAccess.getReplacePatternsAccess().getReplaceAssignment_2()); 
            // InternalXtextTest.g:5015:1: ( rule__ReplacePatterns__ReplaceAssignment_2 )
            // InternalXtextTest.g:5015:2: rule__ReplacePatterns__ReplaceAssignment_2
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
    // InternalXtextTest.g:5033:1: rule__Before__Group__0 : rule__Before__Group__0__Impl rule__Before__Group__1 ;
    public final void rule__Before__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5037:1: ( rule__Before__Group__0__Impl rule__Before__Group__1 )
            // InternalXtextTest.g:5038:2: rule__Before__Group__0__Impl rule__Before__Group__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalXtextTest.g:5045:1: rule__Before__Group__0__Impl : ( RULE_BEFORE_KW ) ;
    public final void rule__Before__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5049:1: ( ( RULE_BEFORE_KW ) )
            // InternalXtextTest.g:5051:1: ( RULE_BEFORE_KW )
            {
            // InternalXtextTest.g:5051:1: ( RULE_BEFORE_KW )
            // InternalXtextTest.g:5052:1: RULE_BEFORE_KW
            {
             before(grammarAccess.getBeforeAccess().getBEFORE_KWTerminalRuleCall_0()); 
            match(input,RULE_BEFORE_KW,FOLLOW_2); 
             after(grammarAccess.getBeforeAccess().getBEFORE_KWTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__Before__Group__0__Impl"


    // $ANTLR start "rule__Before__Group__1"
    // InternalXtextTest.g:5065:1: rule__Before__Group__1 : rule__Before__Group__1__Impl rule__Before__Group__2 ;
    public final void rule__Before__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5069:1: ( rule__Before__Group__1__Impl rule__Before__Group__2 )
            // InternalXtextTest.g:5070:2: rule__Before__Group__1__Impl rule__Before__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalXtextTest.g:5077:1: rule__Before__Group__1__Impl : ( RULE_CLASS_KW ) ;
    public final void rule__Before__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5081:1: ( ( RULE_CLASS_KW ) )
            // InternalXtextTest.g:5083:1: ( RULE_CLASS_KW )
            {
            // InternalXtextTest.g:5083:1: ( RULE_CLASS_KW )
            // InternalXtextTest.g:5084:1: RULE_CLASS_KW
            {
             before(grammarAccess.getBeforeAccess().getCLASS_KWTerminalRuleCall_1()); 
            match(input,RULE_CLASS_KW,FOLLOW_2); 
             after(grammarAccess.getBeforeAccess().getCLASS_KWTerminalRuleCall_1()); 

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
    // InternalXtextTest.g:5097:1: rule__Before__Group__2 : rule__Before__Group__2__Impl rule__Before__Group__3 ;
    public final void rule__Before__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5101:1: ( rule__Before__Group__2__Impl rule__Before__Group__3 )
            // InternalXtextTest.g:5102:2: rule__Before__Group__2__Impl rule__Before__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Before__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Before__Group__3();

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
    // InternalXtextTest.g:5109:1: rule__Before__Group__2__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Before__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5113:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:5115:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:5115:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:5116:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getBeforeAccess().getASSIGNASSINGLETerminalRuleCall_2()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getBeforeAccess().getASSIGNASSINGLETerminalRuleCall_2()); 

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


    // $ANTLR start "rule__Before__Group__3"
    // InternalXtextTest.g:5129:1: rule__Before__Group__3 : rule__Before__Group__3__Impl rule__Before__Group__4 ;
    public final void rule__Before__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5133:1: ( rule__Before__Group__3__Impl rule__Before__Group__4 )
            // InternalXtextTest.g:5134:2: rule__Before__Group__3__Impl rule__Before__Group__4
            {
            pushFollow(FOLLOW_41);
            rule__Before__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Before__Group__4();

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
    // $ANTLR end "rule__Before__Group__3"


    // $ANTLR start "rule__Before__Group__3__Impl"
    // InternalXtextTest.g:5141:1: rule__Before__Group__3__Impl : ( ( rule__Before__MyclassAssignment_3 ) ) ;
    public final void rule__Before__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5145:1: ( ( ( rule__Before__MyclassAssignment_3 ) ) )
            // InternalXtextTest.g:5147:1: ( ( rule__Before__MyclassAssignment_3 ) )
            {
            // InternalXtextTest.g:5147:1: ( ( rule__Before__MyclassAssignment_3 ) )
            // InternalXtextTest.g:5148:1: ( rule__Before__MyclassAssignment_3 )
            {
             before(grammarAccess.getBeforeAccess().getMyclassAssignment_3()); 
            // InternalXtextTest.g:5149:1: ( rule__Before__MyclassAssignment_3 )
            // InternalXtextTest.g:5149:2: rule__Before__MyclassAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Before__MyclassAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getBeforeAccess().getMyclassAssignment_3()); 

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
    // $ANTLR end "rule__Before__Group__3__Impl"


    // $ANTLR start "rule__Before__Group__4"
    // InternalXtextTest.g:5161:1: rule__Before__Group__4 : rule__Before__Group__4__Impl rule__Before__Group__5 ;
    public final void rule__Before__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5165:1: ( rule__Before__Group__4__Impl rule__Before__Group__5 )
            // InternalXtextTest.g:5166:2: rule__Before__Group__4__Impl rule__Before__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__Before__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Before__Group__5();

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
    // $ANTLR end "rule__Before__Group__4"


    // $ANTLR start "rule__Before__Group__4__Impl"
    // InternalXtextTest.g:5173:1: rule__Before__Group__4__Impl : ( RULE_METHOD_KW ) ;
    public final void rule__Before__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5177:1: ( ( RULE_METHOD_KW ) )
            // InternalXtextTest.g:5179:1: ( RULE_METHOD_KW )
            {
            // InternalXtextTest.g:5179:1: ( RULE_METHOD_KW )
            // InternalXtextTest.g:5180:1: RULE_METHOD_KW
            {
             before(grammarAccess.getBeforeAccess().getMETHOD_KWTerminalRuleCall_4()); 
            match(input,RULE_METHOD_KW,FOLLOW_2); 
             after(grammarAccess.getBeforeAccess().getMETHOD_KWTerminalRuleCall_4()); 

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
    // $ANTLR end "rule__Before__Group__4__Impl"


    // $ANTLR start "rule__Before__Group__5"
    // InternalXtextTest.g:5193:1: rule__Before__Group__5 : rule__Before__Group__5__Impl rule__Before__Group__6 ;
    public final void rule__Before__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5197:1: ( rule__Before__Group__5__Impl rule__Before__Group__6 )
            // InternalXtextTest.g:5198:2: rule__Before__Group__5__Impl rule__Before__Group__6
            {
            pushFollow(FOLLOW_5);
            rule__Before__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Before__Group__6();

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
    // $ANTLR end "rule__Before__Group__5"


    // $ANTLR start "rule__Before__Group__5__Impl"
    // InternalXtextTest.g:5205:1: rule__Before__Group__5__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Before__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5209:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:5211:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:5211:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:5212:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getBeforeAccess().getASSIGNASSINGLETerminalRuleCall_5()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getBeforeAccess().getASSIGNASSINGLETerminalRuleCall_5()); 

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
    // $ANTLR end "rule__Before__Group__5__Impl"


    // $ANTLR start "rule__Before__Group__6"
    // InternalXtextTest.g:5225:1: rule__Before__Group__6 : rule__Before__Group__6__Impl rule__Before__Group__7 ;
    public final void rule__Before__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5229:1: ( rule__Before__Group__6__Impl rule__Before__Group__7 )
            // InternalXtextTest.g:5230:2: rule__Before__Group__6__Impl rule__Before__Group__7
            {
            pushFollow(FOLLOW_42);
            rule__Before__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Before__Group__7();

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
    // $ANTLR end "rule__Before__Group__6"


    // $ANTLR start "rule__Before__Group__6__Impl"
    // InternalXtextTest.g:5237:1: rule__Before__Group__6__Impl : ( ( rule__Before__MethodAssignment_6 ) ) ;
    public final void rule__Before__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5241:1: ( ( ( rule__Before__MethodAssignment_6 ) ) )
            // InternalXtextTest.g:5243:1: ( ( rule__Before__MethodAssignment_6 ) )
            {
            // InternalXtextTest.g:5243:1: ( ( rule__Before__MethodAssignment_6 ) )
            // InternalXtextTest.g:5244:1: ( rule__Before__MethodAssignment_6 )
            {
             before(grammarAccess.getBeforeAccess().getMethodAssignment_6()); 
            // InternalXtextTest.g:5245:1: ( rule__Before__MethodAssignment_6 )
            // InternalXtextTest.g:5245:2: rule__Before__MethodAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Before__MethodAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getBeforeAccess().getMethodAssignment_6()); 

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
    // $ANTLR end "rule__Before__Group__6__Impl"


    // $ANTLR start "rule__Before__Group__7"
    // InternalXtextTest.g:5257:1: rule__Before__Group__7 : rule__Before__Group__7__Impl rule__Before__Group__8 ;
    public final void rule__Before__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5261:1: ( rule__Before__Group__7__Impl rule__Before__Group__8 )
            // InternalXtextTest.g:5262:2: rule__Before__Group__7__Impl rule__Before__Group__8
            {
            pushFollow(FOLLOW_43);
            rule__Before__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Before__Group__8();

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
    // $ANTLR end "rule__Before__Group__7"


    // $ANTLR start "rule__Before__Group__7__Impl"
    // InternalXtextTest.g:5269:1: rule__Before__Group__7__Impl : ( RULE_LEFTPAREN ) ;
    public final void rule__Before__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5273:1: ( ( RULE_LEFTPAREN ) )
            // InternalXtextTest.g:5275:1: ( RULE_LEFTPAREN )
            {
            // InternalXtextTest.g:5275:1: ( RULE_LEFTPAREN )
            // InternalXtextTest.g:5276:1: RULE_LEFTPAREN
            {
             before(grammarAccess.getBeforeAccess().getLEFTPARENTerminalRuleCall_7()); 
            match(input,RULE_LEFTPAREN,FOLLOW_2); 
             after(grammarAccess.getBeforeAccess().getLEFTPARENTerminalRuleCall_7()); 

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
    // $ANTLR end "rule__Before__Group__7__Impl"


    // $ANTLR start "rule__Before__Group__8"
    // InternalXtextTest.g:5289:1: rule__Before__Group__8 : rule__Before__Group__8__Impl ;
    public final void rule__Before__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5293:1: ( rule__Before__Group__8__Impl )
            // InternalXtextTest.g:5294:2: rule__Before__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Before__Group__8__Impl();

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
    // $ANTLR end "rule__Before__Group__8"


    // $ANTLR start "rule__Before__Group__8__Impl"
    // InternalXtextTest.g:5300:1: rule__Before__Group__8__Impl : ( RULE_RIGHTPAREN ) ;
    public final void rule__Before__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5304:1: ( ( RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:5306:1: ( RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:5306:1: ( RULE_RIGHTPAREN )
            // InternalXtextTest.g:5307:1: RULE_RIGHTPAREN
            {
             before(grammarAccess.getBeforeAccess().getRIGHTPARENTerminalRuleCall_8()); 
            match(input,RULE_RIGHTPAREN,FOLLOW_2); 
             after(grammarAccess.getBeforeAccess().getRIGHTPARENTerminalRuleCall_8()); 

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
    // $ANTLR end "rule__Before__Group__8__Impl"


    // $ANTLR start "rule__After__Group__0"
    // InternalXtextTest.g:5338:1: rule__After__Group__0 : rule__After__Group__0__Impl rule__After__Group__1 ;
    public final void rule__After__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5342:1: ( rule__After__Group__0__Impl rule__After__Group__1 )
            // InternalXtextTest.g:5343:2: rule__After__Group__0__Impl rule__After__Group__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalXtextTest.g:5350:1: rule__After__Group__0__Impl : ( RULE_AFTER_KW ) ;
    public final void rule__After__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5354:1: ( ( RULE_AFTER_KW ) )
            // InternalXtextTest.g:5356:1: ( RULE_AFTER_KW )
            {
            // InternalXtextTest.g:5356:1: ( RULE_AFTER_KW )
            // InternalXtextTest.g:5357:1: RULE_AFTER_KW
            {
             before(grammarAccess.getAfterAccess().getAFTER_KWTerminalRuleCall_0()); 
            match(input,RULE_AFTER_KW,FOLLOW_2); 
             after(grammarAccess.getAfterAccess().getAFTER_KWTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__After__Group__0__Impl"


    // $ANTLR start "rule__After__Group__1"
    // InternalXtextTest.g:5370:1: rule__After__Group__1 : rule__After__Group__1__Impl rule__After__Group__2 ;
    public final void rule__After__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5374:1: ( rule__After__Group__1__Impl rule__After__Group__2 )
            // InternalXtextTest.g:5375:2: rule__After__Group__1__Impl rule__After__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalXtextTest.g:5382:1: rule__After__Group__1__Impl : ( RULE_CLASS_KW ) ;
    public final void rule__After__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5386:1: ( ( RULE_CLASS_KW ) )
            // InternalXtextTest.g:5388:1: ( RULE_CLASS_KW )
            {
            // InternalXtextTest.g:5388:1: ( RULE_CLASS_KW )
            // InternalXtextTest.g:5389:1: RULE_CLASS_KW
            {
             before(grammarAccess.getAfterAccess().getCLASS_KWTerminalRuleCall_1()); 
            match(input,RULE_CLASS_KW,FOLLOW_2); 
             after(grammarAccess.getAfterAccess().getCLASS_KWTerminalRuleCall_1()); 

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
    // InternalXtextTest.g:5402:1: rule__After__Group__2 : rule__After__Group__2__Impl rule__After__Group__3 ;
    public final void rule__After__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5406:1: ( rule__After__Group__2__Impl rule__After__Group__3 )
            // InternalXtextTest.g:5407:2: rule__After__Group__2__Impl rule__After__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__After__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__After__Group__3();

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
    // InternalXtextTest.g:5414:1: rule__After__Group__2__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__After__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5418:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:5420:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:5420:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:5421:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getAfterAccess().getASSIGNASSINGLETerminalRuleCall_2()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getAfterAccess().getASSIGNASSINGLETerminalRuleCall_2()); 

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


    // $ANTLR start "rule__After__Group__3"
    // InternalXtextTest.g:5434:1: rule__After__Group__3 : rule__After__Group__3__Impl rule__After__Group__4 ;
    public final void rule__After__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5438:1: ( rule__After__Group__3__Impl rule__After__Group__4 )
            // InternalXtextTest.g:5439:2: rule__After__Group__3__Impl rule__After__Group__4
            {
            pushFollow(FOLLOW_41);
            rule__After__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__After__Group__4();

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
    // $ANTLR end "rule__After__Group__3"


    // $ANTLR start "rule__After__Group__3__Impl"
    // InternalXtextTest.g:5446:1: rule__After__Group__3__Impl : ( ( rule__After__MyclassAssignment_3 ) ) ;
    public final void rule__After__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5450:1: ( ( ( rule__After__MyclassAssignment_3 ) ) )
            // InternalXtextTest.g:5452:1: ( ( rule__After__MyclassAssignment_3 ) )
            {
            // InternalXtextTest.g:5452:1: ( ( rule__After__MyclassAssignment_3 ) )
            // InternalXtextTest.g:5453:1: ( rule__After__MyclassAssignment_3 )
            {
             before(grammarAccess.getAfterAccess().getMyclassAssignment_3()); 
            // InternalXtextTest.g:5454:1: ( rule__After__MyclassAssignment_3 )
            // InternalXtextTest.g:5454:2: rule__After__MyclassAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__After__MyclassAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAfterAccess().getMyclassAssignment_3()); 

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
    // $ANTLR end "rule__After__Group__3__Impl"


    // $ANTLR start "rule__After__Group__4"
    // InternalXtextTest.g:5466:1: rule__After__Group__4 : rule__After__Group__4__Impl rule__After__Group__5 ;
    public final void rule__After__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5470:1: ( rule__After__Group__4__Impl rule__After__Group__5 )
            // InternalXtextTest.g:5471:2: rule__After__Group__4__Impl rule__After__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__After__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__After__Group__5();

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
    // $ANTLR end "rule__After__Group__4"


    // $ANTLR start "rule__After__Group__4__Impl"
    // InternalXtextTest.g:5478:1: rule__After__Group__4__Impl : ( RULE_METHOD_KW ) ;
    public final void rule__After__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5482:1: ( ( RULE_METHOD_KW ) )
            // InternalXtextTest.g:5484:1: ( RULE_METHOD_KW )
            {
            // InternalXtextTest.g:5484:1: ( RULE_METHOD_KW )
            // InternalXtextTest.g:5485:1: RULE_METHOD_KW
            {
             before(grammarAccess.getAfterAccess().getMETHOD_KWTerminalRuleCall_4()); 
            match(input,RULE_METHOD_KW,FOLLOW_2); 
             after(grammarAccess.getAfterAccess().getMETHOD_KWTerminalRuleCall_4()); 

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
    // $ANTLR end "rule__After__Group__4__Impl"


    // $ANTLR start "rule__After__Group__5"
    // InternalXtextTest.g:5498:1: rule__After__Group__5 : rule__After__Group__5__Impl rule__After__Group__6 ;
    public final void rule__After__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5502:1: ( rule__After__Group__5__Impl rule__After__Group__6 )
            // InternalXtextTest.g:5503:2: rule__After__Group__5__Impl rule__After__Group__6
            {
            pushFollow(FOLLOW_5);
            rule__After__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__After__Group__6();

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
    // $ANTLR end "rule__After__Group__5"


    // $ANTLR start "rule__After__Group__5__Impl"
    // InternalXtextTest.g:5510:1: rule__After__Group__5__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__After__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5514:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:5516:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:5516:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:5517:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getAfterAccess().getASSIGNASSINGLETerminalRuleCall_5()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getAfterAccess().getASSIGNASSINGLETerminalRuleCall_5()); 

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
    // $ANTLR end "rule__After__Group__5__Impl"


    // $ANTLR start "rule__After__Group__6"
    // InternalXtextTest.g:5530:1: rule__After__Group__6 : rule__After__Group__6__Impl rule__After__Group__7 ;
    public final void rule__After__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5534:1: ( rule__After__Group__6__Impl rule__After__Group__7 )
            // InternalXtextTest.g:5535:2: rule__After__Group__6__Impl rule__After__Group__7
            {
            pushFollow(FOLLOW_42);
            rule__After__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__After__Group__7();

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
    // $ANTLR end "rule__After__Group__6"


    // $ANTLR start "rule__After__Group__6__Impl"
    // InternalXtextTest.g:5542:1: rule__After__Group__6__Impl : ( ( rule__After__MethodAssignment_6 ) ) ;
    public final void rule__After__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5546:1: ( ( ( rule__After__MethodAssignment_6 ) ) )
            // InternalXtextTest.g:5548:1: ( ( rule__After__MethodAssignment_6 ) )
            {
            // InternalXtextTest.g:5548:1: ( ( rule__After__MethodAssignment_6 ) )
            // InternalXtextTest.g:5549:1: ( rule__After__MethodAssignment_6 )
            {
             before(grammarAccess.getAfterAccess().getMethodAssignment_6()); 
            // InternalXtextTest.g:5550:1: ( rule__After__MethodAssignment_6 )
            // InternalXtextTest.g:5550:2: rule__After__MethodAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__After__MethodAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getAfterAccess().getMethodAssignment_6()); 

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
    // $ANTLR end "rule__After__Group__6__Impl"


    // $ANTLR start "rule__After__Group__7"
    // InternalXtextTest.g:5562:1: rule__After__Group__7 : rule__After__Group__7__Impl rule__After__Group__8 ;
    public final void rule__After__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5566:1: ( rule__After__Group__7__Impl rule__After__Group__8 )
            // InternalXtextTest.g:5567:2: rule__After__Group__7__Impl rule__After__Group__8
            {
            pushFollow(FOLLOW_43);
            rule__After__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__After__Group__8();

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
    // $ANTLR end "rule__After__Group__7"


    // $ANTLR start "rule__After__Group__7__Impl"
    // InternalXtextTest.g:5574:1: rule__After__Group__7__Impl : ( RULE_LEFTPAREN ) ;
    public final void rule__After__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5578:1: ( ( RULE_LEFTPAREN ) )
            // InternalXtextTest.g:5580:1: ( RULE_LEFTPAREN )
            {
            // InternalXtextTest.g:5580:1: ( RULE_LEFTPAREN )
            // InternalXtextTest.g:5581:1: RULE_LEFTPAREN
            {
             before(grammarAccess.getAfterAccess().getLEFTPARENTerminalRuleCall_7()); 
            match(input,RULE_LEFTPAREN,FOLLOW_2); 
             after(grammarAccess.getAfterAccess().getLEFTPARENTerminalRuleCall_7()); 

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
    // $ANTLR end "rule__After__Group__7__Impl"


    // $ANTLR start "rule__After__Group__8"
    // InternalXtextTest.g:5594:1: rule__After__Group__8 : rule__After__Group__8__Impl ;
    public final void rule__After__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5598:1: ( rule__After__Group__8__Impl )
            // InternalXtextTest.g:5599:2: rule__After__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__After__Group__8__Impl();

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
    // $ANTLR end "rule__After__Group__8"


    // $ANTLR start "rule__After__Group__8__Impl"
    // InternalXtextTest.g:5605:1: rule__After__Group__8__Impl : ( RULE_RIGHTPAREN ) ;
    public final void rule__After__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5609:1: ( ( RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:5611:1: ( RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:5611:1: ( RULE_RIGHTPAREN )
            // InternalXtextTest.g:5612:1: RULE_RIGHTPAREN
            {
             before(grammarAccess.getAfterAccess().getRIGHTPARENTerminalRuleCall_8()); 
            match(input,RULE_RIGHTPAREN,FOLLOW_2); 
             after(grammarAccess.getAfterAccess().getRIGHTPARENTerminalRuleCall_8()); 

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
    // $ANTLR end "rule__After__Group__8__Impl"


    // $ANTLR start "rule__CodeCall__Group__0"
    // InternalXtextTest.g:5643:1: rule__CodeCall__Group__0 : rule__CodeCall__Group__0__Impl rule__CodeCall__Group__1 ;
    public final void rule__CodeCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5647:1: ( rule__CodeCall__Group__0__Impl rule__CodeCall__Group__1 )
            // InternalXtextTest.g:5648:2: rule__CodeCall__Group__0__Impl rule__CodeCall__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalXtextTest.g:5655:1: rule__CodeCall__Group__0__Impl : ( RULE_CLASS_KW ) ;
    public final void rule__CodeCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5659:1: ( ( RULE_CLASS_KW ) )
            // InternalXtextTest.g:5661:1: ( RULE_CLASS_KW )
            {
            // InternalXtextTest.g:5661:1: ( RULE_CLASS_KW )
            // InternalXtextTest.g:5662:1: RULE_CLASS_KW
            {
             before(grammarAccess.getCodeCallAccess().getCLASS_KWTerminalRuleCall_0()); 
            match(input,RULE_CLASS_KW,FOLLOW_2); 
             after(grammarAccess.getCodeCallAccess().getCLASS_KWTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__CodeCall__Group__0__Impl"


    // $ANTLR start "rule__CodeCall__Group__1"
    // InternalXtextTest.g:5675:1: rule__CodeCall__Group__1 : rule__CodeCall__Group__1__Impl rule__CodeCall__Group__2 ;
    public final void rule__CodeCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5679:1: ( rule__CodeCall__Group__1__Impl rule__CodeCall__Group__2 )
            // InternalXtextTest.g:5680:2: rule__CodeCall__Group__1__Impl rule__CodeCall__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalXtextTest.g:5687:1: rule__CodeCall__Group__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__CodeCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5691:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:5693:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:5693:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:5694:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getCodeCallAccess().getASSIGNASSINGLETerminalRuleCall_1()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getCodeCallAccess().getASSIGNASSINGLETerminalRuleCall_1()); 

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
    // InternalXtextTest.g:5707:1: rule__CodeCall__Group__2 : rule__CodeCall__Group__2__Impl rule__CodeCall__Group__3 ;
    public final void rule__CodeCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5711:1: ( rule__CodeCall__Group__2__Impl rule__CodeCall__Group__3 )
            // InternalXtextTest.g:5712:2: rule__CodeCall__Group__2__Impl rule__CodeCall__Group__3
            {
            pushFollow(FOLLOW_41);
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
    // InternalXtextTest.g:5719:1: rule__CodeCall__Group__2__Impl : ( ( rule__CodeCall__MyclassAssignment_2 ) ) ;
    public final void rule__CodeCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5723:1: ( ( ( rule__CodeCall__MyclassAssignment_2 ) ) )
            // InternalXtextTest.g:5725:1: ( ( rule__CodeCall__MyclassAssignment_2 ) )
            {
            // InternalXtextTest.g:5725:1: ( ( rule__CodeCall__MyclassAssignment_2 ) )
            // InternalXtextTest.g:5726:1: ( rule__CodeCall__MyclassAssignment_2 )
            {
             before(grammarAccess.getCodeCallAccess().getMyclassAssignment_2()); 
            // InternalXtextTest.g:5727:1: ( rule__CodeCall__MyclassAssignment_2 )
            // InternalXtextTest.g:5727:2: rule__CodeCall__MyclassAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__MyclassAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCodeCallAccess().getMyclassAssignment_2()); 

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
    // InternalXtextTest.g:5739:1: rule__CodeCall__Group__3 : rule__CodeCall__Group__3__Impl rule__CodeCall__Group__4 ;
    public final void rule__CodeCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5743:1: ( rule__CodeCall__Group__3__Impl rule__CodeCall__Group__4 )
            // InternalXtextTest.g:5744:2: rule__CodeCall__Group__3__Impl rule__CodeCall__Group__4
            {
            pushFollow(FOLLOW_10);
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
    // InternalXtextTest.g:5751:1: rule__CodeCall__Group__3__Impl : ( RULE_METHOD_KW ) ;
    public final void rule__CodeCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5755:1: ( ( RULE_METHOD_KW ) )
            // InternalXtextTest.g:5757:1: ( RULE_METHOD_KW )
            {
            // InternalXtextTest.g:5757:1: ( RULE_METHOD_KW )
            // InternalXtextTest.g:5758:1: RULE_METHOD_KW
            {
             before(grammarAccess.getCodeCallAccess().getMETHOD_KWTerminalRuleCall_3()); 
            match(input,RULE_METHOD_KW,FOLLOW_2); 
             after(grammarAccess.getCodeCallAccess().getMETHOD_KWTerminalRuleCall_3()); 

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
    // InternalXtextTest.g:5771:1: rule__CodeCall__Group__4 : rule__CodeCall__Group__4__Impl rule__CodeCall__Group__5 ;
    public final void rule__CodeCall__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5775:1: ( rule__CodeCall__Group__4__Impl rule__CodeCall__Group__5 )
            // InternalXtextTest.g:5776:2: rule__CodeCall__Group__4__Impl rule__CodeCall__Group__5
            {
            pushFollow(FOLLOW_5);
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
    // InternalXtextTest.g:5783:1: rule__CodeCall__Group__4__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__CodeCall__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5787:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:5789:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:5789:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:5790:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getCodeCallAccess().getASSIGNASSINGLETerminalRuleCall_4()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getCodeCallAccess().getASSIGNASSINGLETerminalRuleCall_4()); 

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
    // InternalXtextTest.g:5803:1: rule__CodeCall__Group__5 : rule__CodeCall__Group__5__Impl ;
    public final void rule__CodeCall__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5807:1: ( rule__CodeCall__Group__5__Impl )
            // InternalXtextTest.g:5808:2: rule__CodeCall__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__Group__5__Impl();

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
    // InternalXtextTest.g:5814:1: rule__CodeCall__Group__5__Impl : ( ( rule__CodeCall__MethodAssignment_5 ) ) ;
    public final void rule__CodeCall__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5818:1: ( ( ( rule__CodeCall__MethodAssignment_5 ) ) )
            // InternalXtextTest.g:5820:1: ( ( rule__CodeCall__MethodAssignment_5 ) )
            {
            // InternalXtextTest.g:5820:1: ( ( rule__CodeCall__MethodAssignment_5 ) )
            // InternalXtextTest.g:5821:1: ( rule__CodeCall__MethodAssignment_5 )
            {
             before(grammarAccess.getCodeCallAccess().getMethodAssignment_5()); 
            // InternalXtextTest.g:5822:1: ( rule__CodeCall__MethodAssignment_5 )
            // InternalXtextTest.g:5822:2: rule__CodeCall__MethodAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__MethodAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getCodeCallAccess().getMethodAssignment_5()); 

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


    // $ANTLR start "rule__Model__XtextTestAssignment_1_0"
    // InternalXtextTest.g:5847:1: rule__Model__XtextTestAssignment_1_0 : ( ruleXtextTest ) ;
    public final void rule__Model__XtextTestAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5851:1: ( ( ruleXtextTest ) )
            // InternalXtextTest.g:5852:1: ( ruleXtextTest )
            {
            // InternalXtextTest.g:5852:1: ( ruleXtextTest )
            // InternalXtextTest.g:5853:1: ruleXtextTest
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
    // InternalXtextTest.g:5862:1: rule__Model__EmfTestAssignment_1_1 : ( ruleEmfTest ) ;
    public final void rule__Model__EmfTestAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5866:1: ( ( ruleEmfTest ) )
            // InternalXtextTest.g:5867:1: ( ruleEmfTest )
            {
            // InternalXtextTest.g:5867:1: ( ruleEmfTest )
            // InternalXtextTest.g:5868:1: ruleEmfTest
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
    // InternalXtextTest.g:5877:1: rule__XtextTest__PackageAssignment_2 : ( rulePackageID ) ;
    public final void rule__XtextTest__PackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5881:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:5882:1: ( rulePackageID )
            {
            // InternalXtextTest.g:5882:1: ( rulePackageID )
            // InternalXtextTest.g:5883:1: rulePackageID
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
    // InternalXtextTest.g:5892:1: rule__XtextTest__LangAssignment_4 : ( ruleLangID ) ;
    public final void rule__XtextTest__LangAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5896:1: ( ( ruleLangID ) )
            // InternalXtextTest.g:5897:1: ( ruleLangID )
            {
            // InternalXtextTest.g:5897:1: ( ruleLangID )
            // InternalXtextTest.g:5898:1: ruleLangID
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
    // InternalXtextTest.g:5907:1: rule__XtextTest__ImportsAssignment_5_1 : ( ruleImportID ) ;
    public final void rule__XtextTest__ImportsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5911:1: ( ( ruleImportID ) )
            // InternalXtextTest.g:5912:1: ( ruleImportID )
            {
            // InternalXtextTest.g:5912:1: ( ruleImportID )
            // InternalXtextTest.g:5913:1: ruleImportID
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
    // InternalXtextTest.g:5922:1: rule__XtextTest__BooleanAssignment_6_2 : ( ruleBoolean ) ;
    public final void rule__XtextTest__BooleanAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5926:1: ( ( ruleBoolean ) )
            // InternalXtextTest.g:5927:1: ( ruleBoolean )
            {
            // InternalXtextTest.g:5927:1: ( ruleBoolean )
            // InternalXtextTest.g:5928:1: ruleBoolean
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
    // InternalXtextTest.g:5937:1: rule__XtextTest__InputAssignment_7 : ( ruleInput ) ;
    public final void rule__XtextTest__InputAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5941:1: ( ( ruleInput ) )
            // InternalXtextTest.g:5942:1: ( ruleInput )
            {
            // InternalXtextTest.g:5942:1: ( ruleInput )
            // InternalXtextTest.g:5943:1: ruleInput
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


    // $ANTLR start "rule__XtextTest__TokensAssignment_8"
    // InternalXtextTest.g:5952:1: rule__XtextTest__TokensAssignment_8 : ( ruleTokens ) ;
    public final void rule__XtextTest__TokensAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5956:1: ( ( ruleTokens ) )
            // InternalXtextTest.g:5957:1: ( ruleTokens )
            {
            // InternalXtextTest.g:5957:1: ( ruleTokens )
            // InternalXtextTest.g:5958:1: ruleTokens
            {
             before(grammarAccess.getXtextTestAccess().getTokensTokensParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleTokens();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getTokensTokensParserRuleCall_8_0()); 

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
    // $ANTLR end "rule__XtextTest__TokensAssignment_8"


    // $ANTLR start "rule__XtextTest__RootAssignment_9"
    // InternalXtextTest.g:5967:1: rule__XtextTest__RootAssignment_9 : ( ruleElement ) ;
    public final void rule__XtextTest__RootAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5971:1: ( ( ruleElement ) )
            // InternalXtextTest.g:5972:1: ( ruleElement )
            {
            // InternalXtextTest.g:5972:1: ( ruleElement )
            // InternalXtextTest.g:5973:1: ruleElement
            {
             before(grammarAccess.getXtextTestAccess().getRootElementParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getRootElementParserRuleCall_9_0()); 

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
    // $ANTLR end "rule__XtextTest__RootAssignment_9"


    // $ANTLR start "rule__XtextTest__OutputAssignment_10"
    // InternalXtextTest.g:5982:1: rule__XtextTest__OutputAssignment_10 : ( ruleGenerator ) ;
    public final void rule__XtextTest__OutputAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5986:1: ( ( ruleGenerator ) )
            // InternalXtextTest.g:5987:1: ( ruleGenerator )
            {
            // InternalXtextTest.g:5987:1: ( ruleGenerator )
            // InternalXtextTest.g:5988:1: ruleGenerator
            {
             before(grammarAccess.getXtextTestAccess().getOutputGeneratorParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleGenerator();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getOutputGeneratorParserRuleCall_10_0()); 

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
    // $ANTLR end "rule__XtextTest__OutputAssignment_10"


    // $ANTLR start "rule__XtextTest__BeforeAssignment_11"
    // InternalXtextTest.g:5997:1: rule__XtextTest__BeforeAssignment_11 : ( ruleBefore ) ;
    public final void rule__XtextTest__BeforeAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6001:1: ( ( ruleBefore ) )
            // InternalXtextTest.g:6002:1: ( ruleBefore )
            {
            // InternalXtextTest.g:6002:1: ( ruleBefore )
            // InternalXtextTest.g:6003:1: ruleBefore
            {
             before(grammarAccess.getXtextTestAccess().getBeforeBeforeParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleBefore();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getBeforeBeforeParserRuleCall_11_0()); 

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
    // $ANTLR end "rule__XtextTest__BeforeAssignment_11"


    // $ANTLR start "rule__XtextTest__AfterAssignment_12"
    // InternalXtextTest.g:6012:1: rule__XtextTest__AfterAssignment_12 : ( ruleAfter ) ;
    public final void rule__XtextTest__AfterAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6016:1: ( ( ruleAfter ) )
            // InternalXtextTest.g:6017:1: ( ruleAfter )
            {
            // InternalXtextTest.g:6017:1: ( ruleAfter )
            // InternalXtextTest.g:6018:1: ruleAfter
            {
             before(grammarAccess.getXtextTestAccess().getAfterAfterParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleAfter();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getAfterAfterParserRuleCall_12_0()); 

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
    // $ANTLR end "rule__XtextTest__AfterAssignment_12"


    // $ANTLR start "rule__EmfTest__PackageAssignment_3"
    // InternalXtextTest.g:6027:1: rule__EmfTest__PackageAssignment_3 : ( rulePackageID ) ;
    public final void rule__EmfTest__PackageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6031:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6032:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6032:1: ( rulePackageID )
            // InternalXtextTest.g:6033:1: rulePackageID
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
    // InternalXtextTest.g:6042:1: rule__EmfTest__MydefaultAssignment_5 : ( rulePackageID ) ;
    public final void rule__EmfTest__MydefaultAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6046:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6047:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6047:1: ( rulePackageID )
            // InternalXtextTest.g:6048:1: rulePackageID
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
    // InternalXtextTest.g:6057:1: rule__EmfTest__MyimportAssignment_6 : ( ruleImport ) ;
    public final void rule__EmfTest__MyimportAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6061:1: ( ( ruleImport ) )
            // InternalXtextTest.g:6062:1: ( ruleImport )
            {
            // InternalXtextTest.g:6062:1: ( ruleImport )
            // InternalXtextTest.g:6063:1: ruleImport
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


    // $ANTLR start "rule__EmfTest__CodeCallAssignment_7"
    // InternalXtextTest.g:6072:1: rule__EmfTest__CodeCallAssignment_7 : ( ruleCodeCall ) ;
    public final void rule__EmfTest__CodeCallAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6076:1: ( ( ruleCodeCall ) )
            // InternalXtextTest.g:6077:1: ( ruleCodeCall )
            {
            // InternalXtextTest.g:6077:1: ( ruleCodeCall )
            // InternalXtextTest.g:6078:1: ruleCodeCall
            {
             before(grammarAccess.getEmfTestAccess().getCodeCallCodeCallParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleCodeCall();

            state._fsp--;

             after(grammarAccess.getEmfTestAccess().getCodeCallCodeCallParserRuleCall_7_0()); 

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
    // $ANTLR end "rule__EmfTest__CodeCallAssignment_7"


    // $ANTLR start "rule__EmfTest__OptionCallAssignment_8_1"
    // InternalXtextTest.g:6087:1: rule__EmfTest__OptionCallAssignment_8_1 : ( ruleCodeCall ) ;
    public final void rule__EmfTest__OptionCallAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6091:1: ( ( ruleCodeCall ) )
            // InternalXtextTest.g:6092:1: ( ruleCodeCall )
            {
            // InternalXtextTest.g:6092:1: ( ruleCodeCall )
            // InternalXtextTest.g:6093:1: ruleCodeCall
            {
             before(grammarAccess.getEmfTestAccess().getOptionCallCodeCallParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCodeCall();

            state._fsp--;

             after(grammarAccess.getEmfTestAccess().getOptionCallCodeCallParserRuleCall_8_1_0()); 

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
    // $ANTLR end "rule__EmfTest__OptionCallAssignment_8_1"


    // $ANTLR start "rule__EmfTest__FileAssignment_9_3"
    // InternalXtextTest.g:6102:1: rule__EmfTest__FileAssignment_9_3 : ( RULE_STRING ) ;
    public final void rule__EmfTest__FileAssignment_9_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6106:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6107:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6107:1: ( RULE_STRING )
            // InternalXtextTest.g:6108:1: RULE_STRING
            {
             before(grammarAccess.getEmfTestAccess().getFileSTRINGTerminalRuleCall_9_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getFileSTRINGTerminalRuleCall_9_3_0()); 

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
    // $ANTLR end "rule__EmfTest__FileAssignment_9_3"


    // $ANTLR start "rule__EmfTest__RootAssignment_10"
    // InternalXtextTest.g:6117:1: rule__EmfTest__RootAssignment_10 : ( ruleElement ) ;
    public final void rule__EmfTest__RootAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6121:1: ( ( ruleElement ) )
            // InternalXtextTest.g:6122:1: ( ruleElement )
            {
            // InternalXtextTest.g:6122:1: ( ruleElement )
            // InternalXtextTest.g:6123:1: ruleElement
            {
             before(grammarAccess.getEmfTestAccess().getRootElementParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getEmfTestAccess().getRootElementParserRuleCall_10_0()); 

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
    // $ANTLR end "rule__EmfTest__RootAssignment_10"


    // $ANTLR start "rule__EmfTest__BeforeAssignment_11"
    // InternalXtextTest.g:6132:1: rule__EmfTest__BeforeAssignment_11 : ( ruleBefore ) ;
    public final void rule__EmfTest__BeforeAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6136:1: ( ( ruleBefore ) )
            // InternalXtextTest.g:6137:1: ( ruleBefore )
            {
            // InternalXtextTest.g:6137:1: ( ruleBefore )
            // InternalXtextTest.g:6138:1: ruleBefore
            {
             before(grammarAccess.getEmfTestAccess().getBeforeBeforeParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleBefore();

            state._fsp--;

             after(grammarAccess.getEmfTestAccess().getBeforeBeforeParserRuleCall_11_0()); 

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
    // $ANTLR end "rule__EmfTest__BeforeAssignment_11"


    // $ANTLR start "rule__EmfTest__AfterAssignment_12"
    // InternalXtextTest.g:6147:1: rule__EmfTest__AfterAssignment_12 : ( ruleAfter ) ;
    public final void rule__EmfTest__AfterAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6151:1: ( ( ruleAfter ) )
            // InternalXtextTest.g:6152:1: ( ruleAfter )
            {
            // InternalXtextTest.g:6152:1: ( ruleAfter )
            // InternalXtextTest.g:6153:1: ruleAfter
            {
             before(grammarAccess.getEmfTestAccess().getAfterAfterParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleAfter();

            state._fsp--;

             after(grammarAccess.getEmfTestAccess().getAfterAfterParserRuleCall_12_0()); 

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
    // $ANTLR end "rule__EmfTest__AfterAssignment_12"


    // $ANTLR start "rule__Import__IdAssignment_2"
    // InternalXtextTest.g:6162:1: rule__Import__IdAssignment_2 : ( ruleImportID ) ;
    public final void rule__Import__IdAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6166:1: ( ( ruleImportID ) )
            // InternalXtextTest.g:6167:1: ( ruleImportID )
            {
            // InternalXtextTest.g:6167:1: ( ruleImportID )
            // InternalXtextTest.g:6168:1: ruleImportID
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
    // InternalXtextTest.g:6177:1: rule__Import__AliasAssignment_4 : ( RULE_IDENTIFIER ) ;
    public final void rule__Import__AliasAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6181:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:6182:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:6182:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:6183:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:6192:1: rule__Input__TextAssignment_2_0_2 : ( RULE_STRING ) ;
    public final void rule__Input__TextAssignment_2_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6196:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6197:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6197:1: ( RULE_STRING )
            // InternalXtextTest.g:6198:1: RULE_STRING
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
    // InternalXtextTest.g:6207:1: rule__Input__FileAssignment_2_1_2 : ( RULE_STRING ) ;
    public final void rule__Input__FileAssignment_2_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6211:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6212:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6212:1: ( RULE_STRING )
            // InternalXtextTest.g:6213:1: RULE_STRING
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
    // InternalXtextTest.g:6222:1: rule__Tokens__TokensAssignment_2 : ( ruleMyTokens ) ;
    public final void rule__Tokens__TokensAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6226:1: ( ( ruleMyTokens ) )
            // InternalXtextTest.g:6227:1: ( ruleMyTokens )
            {
            // InternalXtextTest.g:6227:1: ( ruleMyTokens )
            // InternalXtextTest.g:6228:1: ruleMyTokens
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


    // $ANTLR start "rule__MyTokens__TokenAssignment_0"
    // InternalXtextTest.g:6237:1: rule__MyTokens__TokenAssignment_0 : ( RULE_IDENTIFIER ) ;
    public final void rule__MyTokens__TokenAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6241:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:6242:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:6242:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:6243:1: RULE_IDENTIFIER
            {
             before(grammarAccess.getMyTokensAccess().getTokenIDENTIFIERTerminalRuleCall_0_0()); 
            match(input,RULE_IDENTIFIER,FOLLOW_2); 
             after(grammarAccess.getMyTokensAccess().getTokenIDENTIFIERTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__MyTokens__TokenAssignment_0"


    // $ANTLR start "rule__MyTokens__CountAssignment_1_1"
    // InternalXtextTest.g:6252:1: rule__MyTokens__CountAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__MyTokens__CountAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6256:1: ( ( RULE_INT ) )
            // InternalXtextTest.g:6257:1: ( RULE_INT )
            {
            // InternalXtextTest.g:6257:1: ( RULE_INT )
            // InternalXtextTest.g:6258:1: RULE_INT
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
    // InternalXtextTest.g:6267:1: rule__Element__ImportingAssignment_2_0 : ( RULE_IDENTIFIER ) ;
    public final void rule__Element__ImportingAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6271:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:6272:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:6272:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:6273:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:6282:1: rule__Element__NameAssignment_3 : ( RULE_IDENTIFIER ) ;
    public final void rule__Element__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6286:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:6287:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:6287:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:6288:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:6297:1: rule__Element__InnerAssignment_4_0 : ( ruleInner ) ;
    public final void rule__Element__InnerAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6301:1: ( ( ruleInner ) )
            // InternalXtextTest.g:6302:1: ( ruleInner )
            {
            // InternalXtextTest.g:6302:1: ( ruleInner )
            // InternalXtextTest.g:6303:1: ruleInner
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
    // InternalXtextTest.g:6312:1: rule__Element__InnerAssignment_4_1_1 : ( ruleInner ) ;
    public final void rule__Element__InnerAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6316:1: ( ( ruleInner ) )
            // InternalXtextTest.g:6317:1: ( ruleInner )
            {
            // InternalXtextTest.g:6317:1: ( ruleInner )
            // InternalXtextTest.g:6318:1: ruleInner
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
    // InternalXtextTest.g:6327:1: rule__Inner__ParameterAssignment_1 : ( RULE_IDENTIFIER ) ;
    public final void rule__Inner__ParameterAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6331:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:6332:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:6332:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:6333:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:6342:1: rule__Inner__AssignAssignment_2_0_1 : ( ruleElement ) ;
    public final void rule__Inner__AssignAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6346:1: ( ( ruleElement ) )
            // InternalXtextTest.g:6347:1: ( ruleElement )
            {
            // InternalXtextTest.g:6347:1: ( ruleElement )
            // InternalXtextTest.g:6348:1: ruleElement
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
    // InternalXtextTest.g:6357:1: rule__Inner__AssignListAssignment_2_1_1 : ( ruleElement ) ;
    public final void rule__Inner__AssignListAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6361:1: ( ( ruleElement ) )
            // InternalXtextTest.g:6362:1: ( ruleElement )
            {
            // InternalXtextTest.g:6362:1: ( ruleElement )
            // InternalXtextTest.g:6363:1: ruleElement
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
    // InternalXtextTest.g:6372:1: rule__Inner__AssignListAssignment_2_1_2_1 : ( ruleElement ) ;
    public final void rule__Inner__AssignListAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6376:1: ( ( ruleElement ) )
            // InternalXtextTest.g:6377:1: ( ruleElement )
            {
            // InternalXtextTest.g:6377:1: ( ruleElement )
            // InternalXtextTest.g:6378:1: ruleElement
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
    // InternalXtextTest.g:6387:1: rule__Inner__ValueAssignment_2_2_1 : ( RULE_STRING ) ;
    public final void rule__Inner__ValueAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6391:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6392:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6392:1: ( RULE_STRING )
            // InternalXtextTest.g:6393:1: RULE_STRING
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
    // InternalXtextTest.g:6402:1: rule__Inner__AssignAsDataAssignment_2_3_1 : ( RULE_STRING ) ;
    public final void rule__Inner__AssignAsDataAssignment_2_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6406:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6407:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6407:1: ( RULE_STRING )
            // InternalXtextTest.g:6408:1: RULE_STRING
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
    // InternalXtextTest.g:6417:1: rule__Inner__AssignAsBoolAssignment_2_4_1 : ( ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 ) ) ;
    public final void rule__Inner__AssignAsBoolAssignment_2_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6421:1: ( ( ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 ) ) )
            // InternalXtextTest.g:6422:1: ( ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 ) )
            {
            // InternalXtextTest.g:6422:1: ( ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 ) )
            // InternalXtextTest.g:6423:1: ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 )
            {
             before(grammarAccess.getInnerAccess().getAssignAsBoolAlternatives_2_4_1_0()); 
            // InternalXtextTest.g:6424:1: ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 )
            // InternalXtextTest.g:6424:2: rule__Inner__AssignAsBoolAlternatives_2_4_1_0
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
    // InternalXtextTest.g:6433:1: rule__Inner__IsNullAssignment_2_5 : ( RULE_ISNULL ) ;
    public final void rule__Inner__IsNullAssignment_2_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6437:1: ( ( RULE_ISNULL ) )
            // InternalXtextTest.g:6438:1: ( RULE_ISNULL )
            {
            // InternalXtextTest.g:6438:1: ( RULE_ISNULL )
            // InternalXtextTest.g:6439:1: RULE_ISNULL
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
    // InternalXtextTest.g:6448:1: rule__Inner__IsNotNullAssignment_2_6 : ( RULE_ISNOTNULL ) ;
    public final void rule__Inner__IsNotNullAssignment_2_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6452:1: ( ( RULE_ISNOTNULL ) )
            // InternalXtextTest.g:6453:1: ( RULE_ISNOTNULL )
            {
            // InternalXtextTest.g:6453:1: ( RULE_ISNOTNULL )
            // InternalXtextTest.g:6454:1: RULE_ISNOTNULL
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
    // InternalXtextTest.g:6463:1: rule__Inner__IsEmptyAssignment_2_7 : ( RULE_ISEMPTY ) ;
    public final void rule__Inner__IsEmptyAssignment_2_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6467:1: ( ( RULE_ISEMPTY ) )
            // InternalXtextTest.g:6468:1: ( RULE_ISEMPTY )
            {
            // InternalXtextTest.g:6468:1: ( RULE_ISEMPTY )
            // InternalXtextTest.g:6469:1: RULE_ISEMPTY
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
    // InternalXtextTest.g:6478:1: rule__Generator__OutputAssignment_1_3 : ( RULE_STRING ) ;
    public final void rule__Generator__OutputAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6482:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6483:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6483:1: ( RULE_STRING )
            // InternalXtextTest.g:6484:1: RULE_STRING
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
    // InternalXtextTest.g:6493:1: rule__Generator__ExpectedAssignment_2_2_0_1 : ( RULE_STRING ) ;
    public final void rule__Generator__ExpectedAssignment_2_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6497:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6498:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6498:1: ( RULE_STRING )
            // InternalXtextTest.g:6499:1: RULE_STRING
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
    // InternalXtextTest.g:6508:1: rule__Generator__IsSameAsInputFileAssignment_2_2_1 : ( RULE_ISSAMEASINPUTFILE ) ;
    public final void rule__Generator__IsSameAsInputFileAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6512:1: ( ( RULE_ISSAMEASINPUTFILE ) )
            // InternalXtextTest.g:6513:1: ( RULE_ISSAMEASINPUTFILE )
            {
            // InternalXtextTest.g:6513:1: ( RULE_ISSAMEASINPUTFILE )
            // InternalXtextTest.g:6514:1: RULE_ISSAMEASINPUTFILE
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
    // InternalXtextTest.g:6523:1: rule__Generator__PatternFileAssignment_3_1_2 : ( RULE_STRING ) ;
    public final void rule__Generator__PatternFileAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6527:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6528:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6528:1: ( RULE_STRING )
            // InternalXtextTest.g:6529:1: RULE_STRING
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
    // InternalXtextTest.g:6538:1: rule__Generator__ReplacePatternsAssignment_3_2 : ( ruleReplacePatterns ) ;
    public final void rule__Generator__ReplacePatternsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6542:1: ( ( ruleReplacePatterns ) )
            // InternalXtextTest.g:6543:1: ( ruleReplacePatterns )
            {
            // InternalXtextTest.g:6543:1: ( ruleReplacePatterns )
            // InternalXtextTest.g:6544:1: ruleReplacePatterns
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
    // InternalXtextTest.g:6553:1: rule__Generator__ExceptionAssignment_4_2 : ( rulePackageID ) ;
    public final void rule__Generator__ExceptionAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6557:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6558:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6558:1: ( rulePackageID )
            // InternalXtextTest.g:6559:1: rulePackageID
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
    // InternalXtextTest.g:6568:1: rule__ReplacePatterns__RegexAssignment_0 : ( RULE_STRING ) ;
    public final void rule__ReplacePatterns__RegexAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6572:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6573:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6573:1: ( RULE_STRING )
            // InternalXtextTest.g:6574:1: RULE_STRING
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
    // InternalXtextTest.g:6583:1: rule__ReplacePatterns__ReplaceAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ReplacePatterns__ReplaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6587:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6588:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6588:1: ( RULE_STRING )
            // InternalXtextTest.g:6589:1: RULE_STRING
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


    // $ANTLR start "rule__Before__MyclassAssignment_3"
    // InternalXtextTest.g:6598:1: rule__Before__MyclassAssignment_3 : ( rulePackageID ) ;
    public final void rule__Before__MyclassAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6602:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6603:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6603:1: ( rulePackageID )
            // InternalXtextTest.g:6604:1: rulePackageID
            {
             before(grammarAccess.getBeforeAccess().getMyclassPackageIDParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getBeforeAccess().getMyclassPackageIDParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__Before__MyclassAssignment_3"


    // $ANTLR start "rule__Before__MethodAssignment_6"
    // InternalXtextTest.g:6613:1: rule__Before__MethodAssignment_6 : ( rulePackageID ) ;
    public final void rule__Before__MethodAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6617:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6618:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6618:1: ( rulePackageID )
            // InternalXtextTest.g:6619:1: rulePackageID
            {
             before(grammarAccess.getBeforeAccess().getMethodPackageIDParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getBeforeAccess().getMethodPackageIDParserRuleCall_6_0()); 

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
    // $ANTLR end "rule__Before__MethodAssignment_6"


    // $ANTLR start "rule__After__MyclassAssignment_3"
    // InternalXtextTest.g:6628:1: rule__After__MyclassAssignment_3 : ( rulePackageID ) ;
    public final void rule__After__MyclassAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6632:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6633:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6633:1: ( rulePackageID )
            // InternalXtextTest.g:6634:1: rulePackageID
            {
             before(grammarAccess.getAfterAccess().getMyclassPackageIDParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getAfterAccess().getMyclassPackageIDParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__After__MyclassAssignment_3"


    // $ANTLR start "rule__After__MethodAssignment_6"
    // InternalXtextTest.g:6643:1: rule__After__MethodAssignment_6 : ( rulePackageID ) ;
    public final void rule__After__MethodAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6647:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6648:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6648:1: ( rulePackageID )
            // InternalXtextTest.g:6649:1: rulePackageID
            {
             before(grammarAccess.getAfterAccess().getMethodPackageIDParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getAfterAccess().getMethodPackageIDParserRuleCall_6_0()); 

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
    // $ANTLR end "rule__After__MethodAssignment_6"


    // $ANTLR start "rule__CodeCall__MyclassAssignment_2"
    // InternalXtextTest.g:6658:1: rule__CodeCall__MyclassAssignment_2 : ( rulePackageID ) ;
    public final void rule__CodeCall__MyclassAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6662:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6663:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6663:1: ( rulePackageID )
            // InternalXtextTest.g:6664:1: rulePackageID
            {
             before(grammarAccess.getCodeCallAccess().getMyclassPackageIDParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getCodeCallAccess().getMyclassPackageIDParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__CodeCall__MyclassAssignment_2"


    // $ANTLR start "rule__CodeCall__MethodAssignment_5"
    // InternalXtextTest.g:6673:1: rule__CodeCall__MethodAssignment_5 : ( rulePackageID ) ;
    public final void rule__CodeCall__MethodAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6677:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6678:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6678:1: ( rulePackageID )
            // InternalXtextTest.g:6679:1: rulePackageID
            {
             before(grammarAccess.getCodeCallAccess().getMethodPackageIDParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getCodeCallAccess().getMethodPackageIDParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__CodeCall__MethodAssignment_5"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001080L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008600L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000500000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000001220000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000400000200L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000001200000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x000003801C200800L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000040000000800L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000002000010000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000800000L});

}