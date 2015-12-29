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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_IDENTIFIER", "RULE_TRUE", "RULE_FALSE", "RULE_PACKAGE", "RULE_LANGUAGE", "RULE_IMPORTS", "RULE_SPLITLEXER", "RULE_ASSIGNASSINGLE", "RULE_KW_EMFTEST", "RULE_DEFAULT", "RULE_SOURCE", "RULE_FILE", "RULE_KW_AS", "RULE_POINT", "RULE_SRCTEXT", "RULE_LEXER", "RULE_ASSIGNASDATALIST", "RULE_LEFTPAREN", "RULE_RIGHTPAREN", "RULE_IMPORTER", "RULE_COMMA", "RULE_ASSIGNASLIST", "RULE_ASSIGNASSTRING", "RULE_ASSIGNASBOOL", "RULE_OUTPUT", "RULE_EXPECTED", "RULE_PATTERNS", "RULE_EXCEPTIONS", "RULE_BEFORE_KW", "RULE_CLASS_KW", "RULE_METHOD_KW", "RULE_AFTER_KW", "RULE_STRING", "RULE_INT", "RULE_ISNULL", "RULE_ISNOTNULL", "RULE_ISSAMEASINPUTFILE", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=41;
    public static final int RULE_IMPORTER=23;
    public static final int RULE_ANY_OTHER=45;
    public static final int RULE_SPLITLEXER=10;
    public static final int RULE_LANGUAGE=8;
    public static final int RULE_ASSIGNASBOOL=27;
    public static final int EOF=-1;
    public static final int RULE_PACKAGE=7;
    public static final int RULE_FALSE=6;
    public static final int RULE_ASSIGNASSINGLE=11;
    public static final int RULE_KW_EMFTEST=12;
    public static final int RULE_ASSIGNASLIST=25;
    public static final int RULE_POINT=17;
    public static final int RULE_INT=37;
    public static final int RULE_CLASS_KW=33;
    public static final int RULE_ASSIGNASSTRING=26;
    public static final int RULE_ISSAMEASINPUTFILE=40;
    public static final int RULE_SRCTEXT=18;
    public static final int RULE_IMPORTS=9;
    public static final int RULE_RIGHTPAREN=22;
    public static final int RULE_PATTERNS=30;
    public static final int RULE_METHOD_KW=34;
    public static final int RULE_ASSIGNASDATALIST=20;
    public static final int RULE_EXPECTED=29;
    public static final int RULE_ISNULL=38;
    public static final int RULE_FILE=15;
    public static final int RULE_IDENTIFIER=4;
    public static final int RULE_COMMA=24;
    public static final int RULE_AFTER_KW=35;
    public static final int RULE_SL_COMMENT=43;
    public static final int RULE_ISNOTNULL=39;
    public static final int RULE_DEFAULT=13;
    public static final int RULE_TRUE=5;
    public static final int RULE_BEFORE_KW=32;
    public static final int RULE_ML_COMMENT=42;
    public static final int RULE_SOURCE=14;
    public static final int RULE_LEFTPAREN=21;
    public static final int RULE_STRING=36;
    public static final int RULE_EXCEPTIONS=31;
    public static final int RULE_LEXER=19;
    public static final int RULE_OUTPUT=28;
    public static final int RULE_WS=44;
    public static final int RULE_KW_AS=16;

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
    // InternalXtextTest.g:757:1: rule__Inner__Alternatives_2 : ( ( ( rule__Inner__Group_2_0__0 ) ) | ( ( rule__Inner__Group_2_1__0 ) ) | ( ( rule__Inner__Group_2_2__0 ) ) | ( ( rule__Inner__Group_2_3__0 ) ) | ( ( rule__Inner__Group_2_4__0 ) ) | ( ( rule__Inner__IsNullAssignment_2_5 ) ) | ( ( rule__Inner__IsNotNullAssignment_2_6 ) ) );
    public final void rule__Inner__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:761:1: ( ( ( rule__Inner__Group_2_0__0 ) ) | ( ( rule__Inner__Group_2_1__0 ) ) | ( ( rule__Inner__Group_2_2__0 ) ) | ( ( rule__Inner__Group_2_3__0 ) ) | ( ( rule__Inner__Group_2_4__0 ) ) | ( ( rule__Inner__IsNullAssignment_2_5 ) ) | ( ( rule__Inner__IsNotNullAssignment_2_6 ) ) )
            int alt4=7;
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

            }
        }
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
    // InternalXtextTest.g:830:1: rule__Inner__AssignAsBoolAlternatives_2_4_1_0 : ( ( RULE_TRUE ) | ( RULE_FALSE ) );
    public final void rule__Inner__AssignAsBoolAlternatives_2_4_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:834:1: ( ( RULE_TRUE ) | ( RULE_FALSE ) )
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
                    // InternalXtextTest.g:836:1: ( RULE_TRUE )
                    {
                    // InternalXtextTest.g:836:1: ( RULE_TRUE )
                    // InternalXtextTest.g:837:1: RULE_TRUE
                    {
                     before(grammarAccess.getInnerAccess().getAssignAsBoolTRUETerminalRuleCall_2_4_1_0_0()); 
                    match(input,RULE_TRUE,FOLLOW_2); 
                     after(grammarAccess.getInnerAccess().getAssignAsBoolTRUETerminalRuleCall_2_4_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:845:1: ( RULE_FALSE )
                    {
                    // InternalXtextTest.g:845:1: ( RULE_FALSE )
                    // InternalXtextTest.g:846:1: RULE_FALSE
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
    // InternalXtextTest.g:858:1: rule__Generator__Alternatives_2_2 : ( ( ( rule__Generator__Group_2_2_0__0 ) ) | ( ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 ) ) );
    public final void rule__Generator__Alternatives_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:862:1: ( ( ( rule__Generator__Group_2_2_0__0 ) ) | ( ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 ) ) )
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
                    // InternalXtextTest.g:864:1: ( ( rule__Generator__Group_2_2_0__0 ) )
                    {
                    // InternalXtextTest.g:864:1: ( ( rule__Generator__Group_2_2_0__0 ) )
                    // InternalXtextTest.g:865:1: ( rule__Generator__Group_2_2_0__0 )
                    {
                     before(grammarAccess.getGeneratorAccess().getGroup_2_2_0()); 
                    // InternalXtextTest.g:866:1: ( rule__Generator__Group_2_2_0__0 )
                    // InternalXtextTest.g:866:2: rule__Generator__Group_2_2_0__0
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
                    // InternalXtextTest.g:873:1: ( ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 ) )
                    {
                    // InternalXtextTest.g:873:1: ( ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 ) )
                    // InternalXtextTest.g:874:1: ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 )
                    {
                     before(grammarAccess.getGeneratorAccess().getIsSameAsInputFileAssignment_2_2_1()); 
                    // InternalXtextTest.g:875:1: ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 )
                    // InternalXtextTest.g:875:2: rule__Generator__IsSameAsInputFileAssignment_2_2_1
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
    // InternalXtextTest.g:888:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:892:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalXtextTest.g:893:2: rule__Model__Group__0__Impl rule__Model__Group__1
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
    // InternalXtextTest.g:900:1: rule__Model__Group__0__Impl : ( () ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:904:1: ( ( () ) )
            // InternalXtextTest.g:906:1: ( () )
            {
            // InternalXtextTest.g:906:1: ( () )
            // InternalXtextTest.g:907:1: ()
            {
             before(grammarAccess.getModelAccess().getModelAction_0()); 
            // InternalXtextTest.g:908:1: ()
            // InternalXtextTest.g:910:1: 
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
    // InternalXtextTest.g:922:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:926:1: ( rule__Model__Group__1__Impl )
            // InternalXtextTest.g:927:2: rule__Model__Group__1__Impl
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
    // InternalXtextTest.g:933:1: rule__Model__Group__1__Impl : ( ( rule__Model__Alternatives_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:937:1: ( ( ( rule__Model__Alternatives_1 ) ) )
            // InternalXtextTest.g:939:1: ( ( rule__Model__Alternatives_1 ) )
            {
            // InternalXtextTest.g:939:1: ( ( rule__Model__Alternatives_1 ) )
            // InternalXtextTest.g:940:1: ( rule__Model__Alternatives_1 )
            {
             before(grammarAccess.getModelAccess().getAlternatives_1()); 
            // InternalXtextTest.g:941:1: ( rule__Model__Alternatives_1 )
            // InternalXtextTest.g:941:2: rule__Model__Alternatives_1
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
    // InternalXtextTest.g:957:1: rule__XtextTest__Group__0 : rule__XtextTest__Group__0__Impl rule__XtextTest__Group__1 ;
    public final void rule__XtextTest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:961:1: ( rule__XtextTest__Group__0__Impl rule__XtextTest__Group__1 )
            // InternalXtextTest.g:962:2: rule__XtextTest__Group__0__Impl rule__XtextTest__Group__1
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
    // InternalXtextTest.g:969:1: rule__XtextTest__Group__0__Impl : ( () ) ;
    public final void rule__XtextTest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:973:1: ( ( () ) )
            // InternalXtextTest.g:975:1: ( () )
            {
            // InternalXtextTest.g:975:1: ( () )
            // InternalXtextTest.g:976:1: ()
            {
             before(grammarAccess.getXtextTestAccess().getXtextTestAction_0()); 
            // InternalXtextTest.g:977:1: ()
            // InternalXtextTest.g:979:1: 
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
    // InternalXtextTest.g:991:1: rule__XtextTest__Group__1 : rule__XtextTest__Group__1__Impl rule__XtextTest__Group__2 ;
    public final void rule__XtextTest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:995:1: ( rule__XtextTest__Group__1__Impl rule__XtextTest__Group__2 )
            // InternalXtextTest.g:996:2: rule__XtextTest__Group__1__Impl rule__XtextTest__Group__2
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
    // InternalXtextTest.g:1003:1: rule__XtextTest__Group__1__Impl : ( RULE_PACKAGE ) ;
    public final void rule__XtextTest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1007:1: ( ( RULE_PACKAGE ) )
            // InternalXtextTest.g:1009:1: ( RULE_PACKAGE )
            {
            // InternalXtextTest.g:1009:1: ( RULE_PACKAGE )
            // InternalXtextTest.g:1010:1: RULE_PACKAGE
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
    // InternalXtextTest.g:1023:1: rule__XtextTest__Group__2 : rule__XtextTest__Group__2__Impl rule__XtextTest__Group__3 ;
    public final void rule__XtextTest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1027:1: ( rule__XtextTest__Group__2__Impl rule__XtextTest__Group__3 )
            // InternalXtextTest.g:1028:2: rule__XtextTest__Group__2__Impl rule__XtextTest__Group__3
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
    // InternalXtextTest.g:1035:1: rule__XtextTest__Group__2__Impl : ( ( rule__XtextTest__PackageAssignment_2 ) ) ;
    public final void rule__XtextTest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1039:1: ( ( ( rule__XtextTest__PackageAssignment_2 ) ) )
            // InternalXtextTest.g:1041:1: ( ( rule__XtextTest__PackageAssignment_2 ) )
            {
            // InternalXtextTest.g:1041:1: ( ( rule__XtextTest__PackageAssignment_2 ) )
            // InternalXtextTest.g:1042:1: ( rule__XtextTest__PackageAssignment_2 )
            {
             before(grammarAccess.getXtextTestAccess().getPackageAssignment_2()); 
            // InternalXtextTest.g:1043:1: ( rule__XtextTest__PackageAssignment_2 )
            // InternalXtextTest.g:1043:2: rule__XtextTest__PackageAssignment_2
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
    // InternalXtextTest.g:1055:1: rule__XtextTest__Group__3 : rule__XtextTest__Group__3__Impl rule__XtextTest__Group__4 ;
    public final void rule__XtextTest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1059:1: ( rule__XtextTest__Group__3__Impl rule__XtextTest__Group__4 )
            // InternalXtextTest.g:1060:2: rule__XtextTest__Group__3__Impl rule__XtextTest__Group__4
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
    // InternalXtextTest.g:1067:1: rule__XtextTest__Group__3__Impl : ( RULE_LANGUAGE ) ;
    public final void rule__XtextTest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1071:1: ( ( RULE_LANGUAGE ) )
            // InternalXtextTest.g:1073:1: ( RULE_LANGUAGE )
            {
            // InternalXtextTest.g:1073:1: ( RULE_LANGUAGE )
            // InternalXtextTest.g:1074:1: RULE_LANGUAGE
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
    // InternalXtextTest.g:1087:1: rule__XtextTest__Group__4 : rule__XtextTest__Group__4__Impl rule__XtextTest__Group__5 ;
    public final void rule__XtextTest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1091:1: ( rule__XtextTest__Group__4__Impl rule__XtextTest__Group__5 )
            // InternalXtextTest.g:1092:2: rule__XtextTest__Group__4__Impl rule__XtextTest__Group__5
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
    // InternalXtextTest.g:1099:1: rule__XtextTest__Group__4__Impl : ( ( rule__XtextTest__LangAssignment_4 ) ) ;
    public final void rule__XtextTest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1103:1: ( ( ( rule__XtextTest__LangAssignment_4 ) ) )
            // InternalXtextTest.g:1105:1: ( ( rule__XtextTest__LangAssignment_4 ) )
            {
            // InternalXtextTest.g:1105:1: ( ( rule__XtextTest__LangAssignment_4 ) )
            // InternalXtextTest.g:1106:1: ( rule__XtextTest__LangAssignment_4 )
            {
             before(grammarAccess.getXtextTestAccess().getLangAssignment_4()); 
            // InternalXtextTest.g:1107:1: ( rule__XtextTest__LangAssignment_4 )
            // InternalXtextTest.g:1107:2: rule__XtextTest__LangAssignment_4
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
    // InternalXtextTest.g:1119:1: rule__XtextTest__Group__5 : rule__XtextTest__Group__5__Impl rule__XtextTest__Group__6 ;
    public final void rule__XtextTest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1123:1: ( rule__XtextTest__Group__5__Impl rule__XtextTest__Group__6 )
            // InternalXtextTest.g:1124:2: rule__XtextTest__Group__5__Impl rule__XtextTest__Group__6
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
    // InternalXtextTest.g:1131:1: rule__XtextTest__Group__5__Impl : ( ( rule__XtextTest__Group_5__0 )? ) ;
    public final void rule__XtextTest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1135:1: ( ( ( rule__XtextTest__Group_5__0 )? ) )
            // InternalXtextTest.g:1137:1: ( ( rule__XtextTest__Group_5__0 )? )
            {
            // InternalXtextTest.g:1137:1: ( ( rule__XtextTest__Group_5__0 )? )
            // InternalXtextTest.g:1138:1: ( rule__XtextTest__Group_5__0 )?
            {
             before(grammarAccess.getXtextTestAccess().getGroup_5()); 
            // InternalXtextTest.g:1139:1: ( rule__XtextTest__Group_5__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_IMPORTS) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalXtextTest.g:1139:2: rule__XtextTest__Group_5__0
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
    // InternalXtextTest.g:1151:1: rule__XtextTest__Group__6 : rule__XtextTest__Group__6__Impl rule__XtextTest__Group__7 ;
    public final void rule__XtextTest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1155:1: ( rule__XtextTest__Group__6__Impl rule__XtextTest__Group__7 )
            // InternalXtextTest.g:1156:2: rule__XtextTest__Group__6__Impl rule__XtextTest__Group__7
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
    // InternalXtextTest.g:1163:1: rule__XtextTest__Group__6__Impl : ( ( rule__XtextTest__Group_6__0 )? ) ;
    public final void rule__XtextTest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1167:1: ( ( ( rule__XtextTest__Group_6__0 )? ) )
            // InternalXtextTest.g:1169:1: ( ( rule__XtextTest__Group_6__0 )? )
            {
            // InternalXtextTest.g:1169:1: ( ( rule__XtextTest__Group_6__0 )? )
            // InternalXtextTest.g:1170:1: ( rule__XtextTest__Group_6__0 )?
            {
             before(grammarAccess.getXtextTestAccess().getGroup_6()); 
            // InternalXtextTest.g:1171:1: ( rule__XtextTest__Group_6__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_SPLITLEXER) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalXtextTest.g:1171:2: rule__XtextTest__Group_6__0
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
    // InternalXtextTest.g:1183:1: rule__XtextTest__Group__7 : rule__XtextTest__Group__7__Impl rule__XtextTest__Group__8 ;
    public final void rule__XtextTest__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1187:1: ( rule__XtextTest__Group__7__Impl rule__XtextTest__Group__8 )
            // InternalXtextTest.g:1188:2: rule__XtextTest__Group__7__Impl rule__XtextTest__Group__8
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
    // InternalXtextTest.g:1195:1: rule__XtextTest__Group__7__Impl : ( ( rule__XtextTest__InputAssignment_7 ) ) ;
    public final void rule__XtextTest__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1199:1: ( ( ( rule__XtextTest__InputAssignment_7 ) ) )
            // InternalXtextTest.g:1201:1: ( ( rule__XtextTest__InputAssignment_7 ) )
            {
            // InternalXtextTest.g:1201:1: ( ( rule__XtextTest__InputAssignment_7 ) )
            // InternalXtextTest.g:1202:1: ( rule__XtextTest__InputAssignment_7 )
            {
             before(grammarAccess.getXtextTestAccess().getInputAssignment_7()); 
            // InternalXtextTest.g:1203:1: ( rule__XtextTest__InputAssignment_7 )
            // InternalXtextTest.g:1203:2: rule__XtextTest__InputAssignment_7
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
    // InternalXtextTest.g:1215:1: rule__XtextTest__Group__8 : rule__XtextTest__Group__8__Impl rule__XtextTest__Group__9 ;
    public final void rule__XtextTest__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1219:1: ( rule__XtextTest__Group__8__Impl rule__XtextTest__Group__9 )
            // InternalXtextTest.g:1220:2: rule__XtextTest__Group__8__Impl rule__XtextTest__Group__9
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
    // InternalXtextTest.g:1227:1: rule__XtextTest__Group__8__Impl : ( ( rule__XtextTest__TokensAssignment_8 )? ) ;
    public final void rule__XtextTest__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1231:1: ( ( ( rule__XtextTest__TokensAssignment_8 )? ) )
            // InternalXtextTest.g:1233:1: ( ( rule__XtextTest__TokensAssignment_8 )? )
            {
            // InternalXtextTest.g:1233:1: ( ( rule__XtextTest__TokensAssignment_8 )? )
            // InternalXtextTest.g:1234:1: ( rule__XtextTest__TokensAssignment_8 )?
            {
             before(grammarAccess.getXtextTestAccess().getTokensAssignment_8()); 
            // InternalXtextTest.g:1235:1: ( rule__XtextTest__TokensAssignment_8 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_LEXER) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalXtextTest.g:1235:2: rule__XtextTest__TokensAssignment_8
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
    // InternalXtextTest.g:1247:1: rule__XtextTest__Group__9 : rule__XtextTest__Group__9__Impl rule__XtextTest__Group__10 ;
    public final void rule__XtextTest__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1251:1: ( rule__XtextTest__Group__9__Impl rule__XtextTest__Group__10 )
            // InternalXtextTest.g:1252:2: rule__XtextTest__Group__9__Impl rule__XtextTest__Group__10
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
    // InternalXtextTest.g:1259:1: rule__XtextTest__Group__9__Impl : ( ( rule__XtextTest__RootAssignment_9 ) ) ;
    public final void rule__XtextTest__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1263:1: ( ( ( rule__XtextTest__RootAssignment_9 ) ) )
            // InternalXtextTest.g:1265:1: ( ( rule__XtextTest__RootAssignment_9 ) )
            {
            // InternalXtextTest.g:1265:1: ( ( rule__XtextTest__RootAssignment_9 ) )
            // InternalXtextTest.g:1266:1: ( rule__XtextTest__RootAssignment_9 )
            {
             before(grammarAccess.getXtextTestAccess().getRootAssignment_9()); 
            // InternalXtextTest.g:1267:1: ( rule__XtextTest__RootAssignment_9 )
            // InternalXtextTest.g:1267:2: rule__XtextTest__RootAssignment_9
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
    // InternalXtextTest.g:1279:1: rule__XtextTest__Group__10 : rule__XtextTest__Group__10__Impl rule__XtextTest__Group__11 ;
    public final void rule__XtextTest__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1283:1: ( rule__XtextTest__Group__10__Impl rule__XtextTest__Group__11 )
            // InternalXtextTest.g:1284:2: rule__XtextTest__Group__10__Impl rule__XtextTest__Group__11
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
    // InternalXtextTest.g:1291:1: rule__XtextTest__Group__10__Impl : ( ( rule__XtextTest__OutputAssignment_10 )? ) ;
    public final void rule__XtextTest__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1295:1: ( ( ( rule__XtextTest__OutputAssignment_10 )? ) )
            // InternalXtextTest.g:1297:1: ( ( rule__XtextTest__OutputAssignment_10 )? )
            {
            // InternalXtextTest.g:1297:1: ( ( rule__XtextTest__OutputAssignment_10 )? )
            // InternalXtextTest.g:1298:1: ( rule__XtextTest__OutputAssignment_10 )?
            {
             before(grammarAccess.getXtextTestAccess().getOutputAssignment_10()); 
            // InternalXtextTest.g:1299:1: ( rule__XtextTest__OutputAssignment_10 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_OUTPUT) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalXtextTest.g:1299:2: rule__XtextTest__OutputAssignment_10
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
    // InternalXtextTest.g:1311:1: rule__XtextTest__Group__11 : rule__XtextTest__Group__11__Impl rule__XtextTest__Group__12 ;
    public final void rule__XtextTest__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1315:1: ( rule__XtextTest__Group__11__Impl rule__XtextTest__Group__12 )
            // InternalXtextTest.g:1316:2: rule__XtextTest__Group__11__Impl rule__XtextTest__Group__12
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
    // InternalXtextTest.g:1323:1: rule__XtextTest__Group__11__Impl : ( ( rule__XtextTest__BeforeAssignment_11 )? ) ;
    public final void rule__XtextTest__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1327:1: ( ( ( rule__XtextTest__BeforeAssignment_11 )? ) )
            // InternalXtextTest.g:1329:1: ( ( rule__XtextTest__BeforeAssignment_11 )? )
            {
            // InternalXtextTest.g:1329:1: ( ( rule__XtextTest__BeforeAssignment_11 )? )
            // InternalXtextTest.g:1330:1: ( rule__XtextTest__BeforeAssignment_11 )?
            {
             before(grammarAccess.getXtextTestAccess().getBeforeAssignment_11()); 
            // InternalXtextTest.g:1331:1: ( rule__XtextTest__BeforeAssignment_11 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_BEFORE_KW) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalXtextTest.g:1331:2: rule__XtextTest__BeforeAssignment_11
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
    // InternalXtextTest.g:1343:1: rule__XtextTest__Group__12 : rule__XtextTest__Group__12__Impl ;
    public final void rule__XtextTest__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1347:1: ( rule__XtextTest__Group__12__Impl )
            // InternalXtextTest.g:1348:2: rule__XtextTest__Group__12__Impl
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
    // InternalXtextTest.g:1354:1: rule__XtextTest__Group__12__Impl : ( ( rule__XtextTest__AfterAssignment_12 )? ) ;
    public final void rule__XtextTest__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1358:1: ( ( ( rule__XtextTest__AfterAssignment_12 )? ) )
            // InternalXtextTest.g:1360:1: ( ( rule__XtextTest__AfterAssignment_12 )? )
            {
            // InternalXtextTest.g:1360:1: ( ( rule__XtextTest__AfterAssignment_12 )? )
            // InternalXtextTest.g:1361:1: ( rule__XtextTest__AfterAssignment_12 )?
            {
             before(grammarAccess.getXtextTestAccess().getAfterAssignment_12()); 
            // InternalXtextTest.g:1362:1: ( rule__XtextTest__AfterAssignment_12 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_AFTER_KW) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalXtextTest.g:1362:2: rule__XtextTest__AfterAssignment_12
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
    // InternalXtextTest.g:1400:1: rule__XtextTest__Group_5__0 : rule__XtextTest__Group_5__0__Impl rule__XtextTest__Group_5__1 ;
    public final void rule__XtextTest__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1404:1: ( rule__XtextTest__Group_5__0__Impl rule__XtextTest__Group_5__1 )
            // InternalXtextTest.g:1405:2: rule__XtextTest__Group_5__0__Impl rule__XtextTest__Group_5__1
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
    // InternalXtextTest.g:1412:1: rule__XtextTest__Group_5__0__Impl : ( RULE_IMPORTS ) ;
    public final void rule__XtextTest__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1416:1: ( ( RULE_IMPORTS ) )
            // InternalXtextTest.g:1418:1: ( RULE_IMPORTS )
            {
            // InternalXtextTest.g:1418:1: ( RULE_IMPORTS )
            // InternalXtextTest.g:1419:1: RULE_IMPORTS
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
    // InternalXtextTest.g:1432:1: rule__XtextTest__Group_5__1 : rule__XtextTest__Group_5__1__Impl ;
    public final void rule__XtextTest__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1436:1: ( rule__XtextTest__Group_5__1__Impl )
            // InternalXtextTest.g:1437:2: rule__XtextTest__Group_5__1__Impl
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
    // InternalXtextTest.g:1443:1: rule__XtextTest__Group_5__1__Impl : ( ( rule__XtextTest__ImportsAssignment_5_1 ) ) ;
    public final void rule__XtextTest__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1447:1: ( ( ( rule__XtextTest__ImportsAssignment_5_1 ) ) )
            // InternalXtextTest.g:1449:1: ( ( rule__XtextTest__ImportsAssignment_5_1 ) )
            {
            // InternalXtextTest.g:1449:1: ( ( rule__XtextTest__ImportsAssignment_5_1 ) )
            // InternalXtextTest.g:1450:1: ( rule__XtextTest__ImportsAssignment_5_1 )
            {
             before(grammarAccess.getXtextTestAccess().getImportsAssignment_5_1()); 
            // InternalXtextTest.g:1451:1: ( rule__XtextTest__ImportsAssignment_5_1 )
            // InternalXtextTest.g:1451:2: rule__XtextTest__ImportsAssignment_5_1
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
    // InternalXtextTest.g:1467:1: rule__XtextTest__Group_6__0 : rule__XtextTest__Group_6__0__Impl rule__XtextTest__Group_6__1 ;
    public final void rule__XtextTest__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1471:1: ( rule__XtextTest__Group_6__0__Impl rule__XtextTest__Group_6__1 )
            // InternalXtextTest.g:1472:2: rule__XtextTest__Group_6__0__Impl rule__XtextTest__Group_6__1
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
    // InternalXtextTest.g:1479:1: rule__XtextTest__Group_6__0__Impl : ( RULE_SPLITLEXER ) ;
    public final void rule__XtextTest__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1483:1: ( ( RULE_SPLITLEXER ) )
            // InternalXtextTest.g:1485:1: ( RULE_SPLITLEXER )
            {
            // InternalXtextTest.g:1485:1: ( RULE_SPLITLEXER )
            // InternalXtextTest.g:1486:1: RULE_SPLITLEXER
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
    // InternalXtextTest.g:1499:1: rule__XtextTest__Group_6__1 : rule__XtextTest__Group_6__1__Impl rule__XtextTest__Group_6__2 ;
    public final void rule__XtextTest__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1503:1: ( rule__XtextTest__Group_6__1__Impl rule__XtextTest__Group_6__2 )
            // InternalXtextTest.g:1504:2: rule__XtextTest__Group_6__1__Impl rule__XtextTest__Group_6__2
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
    // InternalXtextTest.g:1511:1: rule__XtextTest__Group_6__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__XtextTest__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1515:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:1517:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:1517:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:1518:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:1531:1: rule__XtextTest__Group_6__2 : rule__XtextTest__Group_6__2__Impl ;
    public final void rule__XtextTest__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1535:1: ( rule__XtextTest__Group_6__2__Impl )
            // InternalXtextTest.g:1536:2: rule__XtextTest__Group_6__2__Impl
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
    // InternalXtextTest.g:1542:1: rule__XtextTest__Group_6__2__Impl : ( ( rule__XtextTest__BooleanAssignment_6_2 ) ) ;
    public final void rule__XtextTest__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1546:1: ( ( ( rule__XtextTest__BooleanAssignment_6_2 ) ) )
            // InternalXtextTest.g:1548:1: ( ( rule__XtextTest__BooleanAssignment_6_2 ) )
            {
            // InternalXtextTest.g:1548:1: ( ( rule__XtextTest__BooleanAssignment_6_2 ) )
            // InternalXtextTest.g:1549:1: ( rule__XtextTest__BooleanAssignment_6_2 )
            {
             before(grammarAccess.getXtextTestAccess().getBooleanAssignment_6_2()); 
            // InternalXtextTest.g:1550:1: ( rule__XtextTest__BooleanAssignment_6_2 )
            // InternalXtextTest.g:1550:2: rule__XtextTest__BooleanAssignment_6_2
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
    // InternalXtextTest.g:1568:1: rule__EmfTest__Group__0 : rule__EmfTest__Group__0__Impl rule__EmfTest__Group__1 ;
    public final void rule__EmfTest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1572:1: ( rule__EmfTest__Group__0__Impl rule__EmfTest__Group__1 )
            // InternalXtextTest.g:1573:2: rule__EmfTest__Group__0__Impl rule__EmfTest__Group__1
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
    // InternalXtextTest.g:1580:1: rule__EmfTest__Group__0__Impl : ( () ) ;
    public final void rule__EmfTest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1584:1: ( ( () ) )
            // InternalXtextTest.g:1586:1: ( () )
            {
            // InternalXtextTest.g:1586:1: ( () )
            // InternalXtextTest.g:1587:1: ()
            {
             before(grammarAccess.getEmfTestAccess().getEmfTestAction_0()); 
            // InternalXtextTest.g:1588:1: ()
            // InternalXtextTest.g:1590:1: 
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
    // InternalXtextTest.g:1602:1: rule__EmfTest__Group__1 : rule__EmfTest__Group__1__Impl rule__EmfTest__Group__2 ;
    public final void rule__EmfTest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1606:1: ( rule__EmfTest__Group__1__Impl rule__EmfTest__Group__2 )
            // InternalXtextTest.g:1607:2: rule__EmfTest__Group__1__Impl rule__EmfTest__Group__2
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
    // InternalXtextTest.g:1614:1: rule__EmfTest__Group__1__Impl : ( RULE_KW_EMFTEST ) ;
    public final void rule__EmfTest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1618:1: ( ( RULE_KW_EMFTEST ) )
            // InternalXtextTest.g:1620:1: ( RULE_KW_EMFTEST )
            {
            // InternalXtextTest.g:1620:1: ( RULE_KW_EMFTEST )
            // InternalXtextTest.g:1621:1: RULE_KW_EMFTEST
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
    // InternalXtextTest.g:1634:1: rule__EmfTest__Group__2 : rule__EmfTest__Group__2__Impl rule__EmfTest__Group__3 ;
    public final void rule__EmfTest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1638:1: ( rule__EmfTest__Group__2__Impl rule__EmfTest__Group__3 )
            // InternalXtextTest.g:1639:2: rule__EmfTest__Group__2__Impl rule__EmfTest__Group__3
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
    // InternalXtextTest.g:1646:1: rule__EmfTest__Group__2__Impl : ( RULE_PACKAGE ) ;
    public final void rule__EmfTest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1650:1: ( ( RULE_PACKAGE ) )
            // InternalXtextTest.g:1652:1: ( RULE_PACKAGE )
            {
            // InternalXtextTest.g:1652:1: ( RULE_PACKAGE )
            // InternalXtextTest.g:1653:1: RULE_PACKAGE
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
    // InternalXtextTest.g:1666:1: rule__EmfTest__Group__3 : rule__EmfTest__Group__3__Impl rule__EmfTest__Group__4 ;
    public final void rule__EmfTest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1670:1: ( rule__EmfTest__Group__3__Impl rule__EmfTest__Group__4 )
            // InternalXtextTest.g:1671:2: rule__EmfTest__Group__3__Impl rule__EmfTest__Group__4
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
    // InternalXtextTest.g:1678:1: rule__EmfTest__Group__3__Impl : ( ( rule__EmfTest__PackageAssignment_3 ) ) ;
    public final void rule__EmfTest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1682:1: ( ( ( rule__EmfTest__PackageAssignment_3 ) ) )
            // InternalXtextTest.g:1684:1: ( ( rule__EmfTest__PackageAssignment_3 ) )
            {
            // InternalXtextTest.g:1684:1: ( ( rule__EmfTest__PackageAssignment_3 ) )
            // InternalXtextTest.g:1685:1: ( rule__EmfTest__PackageAssignment_3 )
            {
             before(grammarAccess.getEmfTestAccess().getPackageAssignment_3()); 
            // InternalXtextTest.g:1686:1: ( rule__EmfTest__PackageAssignment_3 )
            // InternalXtextTest.g:1686:2: rule__EmfTest__PackageAssignment_3
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
    // InternalXtextTest.g:1698:1: rule__EmfTest__Group__4 : rule__EmfTest__Group__4__Impl rule__EmfTest__Group__5 ;
    public final void rule__EmfTest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1702:1: ( rule__EmfTest__Group__4__Impl rule__EmfTest__Group__5 )
            // InternalXtextTest.g:1703:2: rule__EmfTest__Group__4__Impl rule__EmfTest__Group__5
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
    // InternalXtextTest.g:1710:1: rule__EmfTest__Group__4__Impl : ( RULE_DEFAULT ) ;
    public final void rule__EmfTest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1714:1: ( ( RULE_DEFAULT ) )
            // InternalXtextTest.g:1716:1: ( RULE_DEFAULT )
            {
            // InternalXtextTest.g:1716:1: ( RULE_DEFAULT )
            // InternalXtextTest.g:1717:1: RULE_DEFAULT
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
    // InternalXtextTest.g:1730:1: rule__EmfTest__Group__5 : rule__EmfTest__Group__5__Impl rule__EmfTest__Group__6 ;
    public final void rule__EmfTest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1734:1: ( rule__EmfTest__Group__5__Impl rule__EmfTest__Group__6 )
            // InternalXtextTest.g:1735:2: rule__EmfTest__Group__5__Impl rule__EmfTest__Group__6
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
    // InternalXtextTest.g:1742:1: rule__EmfTest__Group__5__Impl : ( ( rule__EmfTest__MydefaultAssignment_5 ) ) ;
    public final void rule__EmfTest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1746:1: ( ( ( rule__EmfTest__MydefaultAssignment_5 ) ) )
            // InternalXtextTest.g:1748:1: ( ( rule__EmfTest__MydefaultAssignment_5 ) )
            {
            // InternalXtextTest.g:1748:1: ( ( rule__EmfTest__MydefaultAssignment_5 ) )
            // InternalXtextTest.g:1749:1: ( rule__EmfTest__MydefaultAssignment_5 )
            {
             before(grammarAccess.getEmfTestAccess().getMydefaultAssignment_5()); 
            // InternalXtextTest.g:1750:1: ( rule__EmfTest__MydefaultAssignment_5 )
            // InternalXtextTest.g:1750:2: rule__EmfTest__MydefaultAssignment_5
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
    // InternalXtextTest.g:1762:1: rule__EmfTest__Group__6 : rule__EmfTest__Group__6__Impl rule__EmfTest__Group__7 ;
    public final void rule__EmfTest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1766:1: ( rule__EmfTest__Group__6__Impl rule__EmfTest__Group__7 )
            // InternalXtextTest.g:1767:2: rule__EmfTest__Group__6__Impl rule__EmfTest__Group__7
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
    // InternalXtextTest.g:1774:1: rule__EmfTest__Group__6__Impl : ( ( rule__EmfTest__MyimportAssignment_6 )* ) ;
    public final void rule__EmfTest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1778:1: ( ( ( rule__EmfTest__MyimportAssignment_6 )* ) )
            // InternalXtextTest.g:1780:1: ( ( rule__EmfTest__MyimportAssignment_6 )* )
            {
            // InternalXtextTest.g:1780:1: ( ( rule__EmfTest__MyimportAssignment_6 )* )
            // InternalXtextTest.g:1781:1: ( rule__EmfTest__MyimportAssignment_6 )*
            {
             before(grammarAccess.getEmfTestAccess().getMyimportAssignment_6()); 
            // InternalXtextTest.g:1782:1: ( rule__EmfTest__MyimportAssignment_6 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_IMPORTS) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalXtextTest.g:1782:2: rule__EmfTest__MyimportAssignment_6
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
    // InternalXtextTest.g:1794:1: rule__EmfTest__Group__7 : rule__EmfTest__Group__7__Impl rule__EmfTest__Group__8 ;
    public final void rule__EmfTest__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1798:1: ( rule__EmfTest__Group__7__Impl rule__EmfTest__Group__8 )
            // InternalXtextTest.g:1799:2: rule__EmfTest__Group__7__Impl rule__EmfTest__Group__8
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
    // InternalXtextTest.g:1806:1: rule__EmfTest__Group__7__Impl : ( ( rule__EmfTest__CodeCallAssignment_7 ) ) ;
    public final void rule__EmfTest__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1810:1: ( ( ( rule__EmfTest__CodeCallAssignment_7 ) ) )
            // InternalXtextTest.g:1812:1: ( ( rule__EmfTest__CodeCallAssignment_7 ) )
            {
            // InternalXtextTest.g:1812:1: ( ( rule__EmfTest__CodeCallAssignment_7 ) )
            // InternalXtextTest.g:1813:1: ( rule__EmfTest__CodeCallAssignment_7 )
            {
             before(grammarAccess.getEmfTestAccess().getCodeCallAssignment_7()); 
            // InternalXtextTest.g:1814:1: ( rule__EmfTest__CodeCallAssignment_7 )
            // InternalXtextTest.g:1814:2: rule__EmfTest__CodeCallAssignment_7
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
    // InternalXtextTest.g:1826:1: rule__EmfTest__Group__8 : rule__EmfTest__Group__8__Impl rule__EmfTest__Group__9 ;
    public final void rule__EmfTest__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1830:1: ( rule__EmfTest__Group__8__Impl rule__EmfTest__Group__9 )
            // InternalXtextTest.g:1831:2: rule__EmfTest__Group__8__Impl rule__EmfTest__Group__9
            {
            pushFollow(FOLLOW_8);
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
    // InternalXtextTest.g:1838:1: rule__EmfTest__Group__8__Impl : ( ( rule__EmfTest__Group_8__0 ) ) ;
    public final void rule__EmfTest__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1842:1: ( ( ( rule__EmfTest__Group_8__0 ) ) )
            // InternalXtextTest.g:1844:1: ( ( rule__EmfTest__Group_8__0 ) )
            {
            // InternalXtextTest.g:1844:1: ( ( rule__EmfTest__Group_8__0 ) )
            // InternalXtextTest.g:1845:1: ( rule__EmfTest__Group_8__0 )
            {
             before(grammarAccess.getEmfTestAccess().getGroup_8()); 
            // InternalXtextTest.g:1846:1: ( rule__EmfTest__Group_8__0 )
            // InternalXtextTest.g:1846:2: rule__EmfTest__Group_8__0
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_8__0();

            state._fsp--;


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
    // InternalXtextTest.g:1858:1: rule__EmfTest__Group__9 : rule__EmfTest__Group__9__Impl ;
    public final void rule__EmfTest__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1862:1: ( rule__EmfTest__Group__9__Impl )
            // InternalXtextTest.g:1863:2: rule__EmfTest__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__Group__9__Impl();

            state._fsp--;


            }

        }
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
    // InternalXtextTest.g:1869:1: rule__EmfTest__Group__9__Impl : ( ( rule__EmfTest__RootAssignment_9 ) ) ;
    public final void rule__EmfTest__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1873:1: ( ( ( rule__EmfTest__RootAssignment_9 ) ) )
            // InternalXtextTest.g:1875:1: ( ( rule__EmfTest__RootAssignment_9 ) )
            {
            // InternalXtextTest.g:1875:1: ( ( rule__EmfTest__RootAssignment_9 ) )
            // InternalXtextTest.g:1876:1: ( rule__EmfTest__RootAssignment_9 )
            {
             before(grammarAccess.getEmfTestAccess().getRootAssignment_9()); 
            // InternalXtextTest.g:1877:1: ( rule__EmfTest__RootAssignment_9 )
            // InternalXtextTest.g:1877:2: rule__EmfTest__RootAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__RootAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getEmfTestAccess().getRootAssignment_9()); 

            }


            }

        }
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


    // $ANTLR start "rule__EmfTest__Group_8__0"
    // InternalXtextTest.g:1909:1: rule__EmfTest__Group_8__0 : rule__EmfTest__Group_8__0__Impl rule__EmfTest__Group_8__1 ;
    public final void rule__EmfTest__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1913:1: ( rule__EmfTest__Group_8__0__Impl rule__EmfTest__Group_8__1 )
            // InternalXtextTest.g:1914:2: rule__EmfTest__Group_8__0__Impl rule__EmfTest__Group_8__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalXtextTest.g:1921:1: rule__EmfTest__Group_8__0__Impl : ( RULE_SOURCE ) ;
    public final void rule__EmfTest__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1925:1: ( ( RULE_SOURCE ) )
            // InternalXtextTest.g:1927:1: ( RULE_SOURCE )
            {
            // InternalXtextTest.g:1927:1: ( RULE_SOURCE )
            // InternalXtextTest.g:1928:1: RULE_SOURCE
            {
             before(grammarAccess.getEmfTestAccess().getSOURCETerminalRuleCall_8_0()); 
            match(input,RULE_SOURCE,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getSOURCETerminalRuleCall_8_0()); 

            }


            }

        }
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
    // InternalXtextTest.g:1941:1: rule__EmfTest__Group_8__1 : rule__EmfTest__Group_8__1__Impl rule__EmfTest__Group_8__2 ;
    public final void rule__EmfTest__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1945:1: ( rule__EmfTest__Group_8__1__Impl rule__EmfTest__Group_8__2 )
            // InternalXtextTest.g:1946:2: rule__EmfTest__Group_8__1__Impl rule__EmfTest__Group_8__2
            {
            pushFollow(FOLLOW_10);
            rule__EmfTest__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_8__2();

            state._fsp--;


            }

        }
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
    // InternalXtextTest.g:1953:1: rule__EmfTest__Group_8__1__Impl : ( RULE_FILE ) ;
    public final void rule__EmfTest__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1957:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:1959:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:1959:1: ( RULE_FILE )
            // InternalXtextTest.g:1960:1: RULE_FILE
            {
             before(grammarAccess.getEmfTestAccess().getFILETerminalRuleCall_8_1()); 
            match(input,RULE_FILE,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getFILETerminalRuleCall_8_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__EmfTest__Group_8__2"
    // InternalXtextTest.g:1973:1: rule__EmfTest__Group_8__2 : rule__EmfTest__Group_8__2__Impl rule__EmfTest__Group_8__3 ;
    public final void rule__EmfTest__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1977:1: ( rule__EmfTest__Group_8__2__Impl rule__EmfTest__Group_8__3 )
            // InternalXtextTest.g:1978:2: rule__EmfTest__Group_8__2__Impl rule__EmfTest__Group_8__3
            {
            pushFollow(FOLLOW_17);
            rule__EmfTest__Group_8__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_8__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_8__2"


    // $ANTLR start "rule__EmfTest__Group_8__2__Impl"
    // InternalXtextTest.g:1985:1: rule__EmfTest__Group_8__2__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__EmfTest__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1989:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:1991:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:1991:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:1992:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getEmfTestAccess().getASSIGNASSINGLETerminalRuleCall_8_2()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getASSIGNASSINGLETerminalRuleCall_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_8__2__Impl"


    // $ANTLR start "rule__EmfTest__Group_8__3"
    // InternalXtextTest.g:2005:1: rule__EmfTest__Group_8__3 : rule__EmfTest__Group_8__3__Impl ;
    public final void rule__EmfTest__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2009:1: ( rule__EmfTest__Group_8__3__Impl )
            // InternalXtextTest.g:2010:2: rule__EmfTest__Group_8__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__Group_8__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_8__3"


    // $ANTLR start "rule__EmfTest__Group_8__3__Impl"
    // InternalXtextTest.g:2016:1: rule__EmfTest__Group_8__3__Impl : ( ( rule__EmfTest__FileAssignment_8_3 ) ) ;
    public final void rule__EmfTest__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2020:1: ( ( ( rule__EmfTest__FileAssignment_8_3 ) ) )
            // InternalXtextTest.g:2022:1: ( ( rule__EmfTest__FileAssignment_8_3 ) )
            {
            // InternalXtextTest.g:2022:1: ( ( rule__EmfTest__FileAssignment_8_3 ) )
            // InternalXtextTest.g:2023:1: ( rule__EmfTest__FileAssignment_8_3 )
            {
             before(grammarAccess.getEmfTestAccess().getFileAssignment_8_3()); 
            // InternalXtextTest.g:2024:1: ( rule__EmfTest__FileAssignment_8_3 )
            // InternalXtextTest.g:2024:2: rule__EmfTest__FileAssignment_8_3
            {
            pushFollow(FOLLOW_2);
            rule__EmfTest__FileAssignment_8_3();

            state._fsp--;


            }

             after(grammarAccess.getEmfTestAccess().getFileAssignment_8_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__Group_8__3__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalXtextTest.g:2044:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2048:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalXtextTest.g:2049:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalXtextTest.g:2056:1: rule__Import__Group__0__Impl : ( () ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2060:1: ( ( () ) )
            // InternalXtextTest.g:2062:1: ( () )
            {
            // InternalXtextTest.g:2062:1: ( () )
            // InternalXtextTest.g:2063:1: ()
            {
             before(grammarAccess.getImportAccess().getImportAction_0()); 
            // InternalXtextTest.g:2064:1: ()
            // InternalXtextTest.g:2066:1: 
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
    // InternalXtextTest.g:2078:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2082:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // InternalXtextTest.g:2083:2: rule__Import__Group__1__Impl rule__Import__Group__2
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
    // InternalXtextTest.g:2090:1: rule__Import__Group__1__Impl : ( RULE_IMPORTS ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2094:1: ( ( RULE_IMPORTS ) )
            // InternalXtextTest.g:2096:1: ( RULE_IMPORTS )
            {
            // InternalXtextTest.g:2096:1: ( RULE_IMPORTS )
            // InternalXtextTest.g:2097:1: RULE_IMPORTS
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
    // InternalXtextTest.g:2110:1: rule__Import__Group__2 : rule__Import__Group__2__Impl rule__Import__Group__3 ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2114:1: ( rule__Import__Group__2__Impl rule__Import__Group__3 )
            // InternalXtextTest.g:2115:2: rule__Import__Group__2__Impl rule__Import__Group__3
            {
            pushFollow(FOLLOW_19);
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
    // InternalXtextTest.g:2122:1: rule__Import__Group__2__Impl : ( ( rule__Import__IdAssignment_2 ) ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2126:1: ( ( ( rule__Import__IdAssignment_2 ) ) )
            // InternalXtextTest.g:2128:1: ( ( rule__Import__IdAssignment_2 ) )
            {
            // InternalXtextTest.g:2128:1: ( ( rule__Import__IdAssignment_2 ) )
            // InternalXtextTest.g:2129:1: ( rule__Import__IdAssignment_2 )
            {
             before(grammarAccess.getImportAccess().getIdAssignment_2()); 
            // InternalXtextTest.g:2130:1: ( rule__Import__IdAssignment_2 )
            // InternalXtextTest.g:2130:2: rule__Import__IdAssignment_2
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
    // InternalXtextTest.g:2142:1: rule__Import__Group__3 : rule__Import__Group__3__Impl rule__Import__Group__4 ;
    public final void rule__Import__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2146:1: ( rule__Import__Group__3__Impl rule__Import__Group__4 )
            // InternalXtextTest.g:2147:2: rule__Import__Group__3__Impl rule__Import__Group__4
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
    // InternalXtextTest.g:2154:1: rule__Import__Group__3__Impl : ( RULE_KW_AS ) ;
    public final void rule__Import__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2158:1: ( ( RULE_KW_AS ) )
            // InternalXtextTest.g:2160:1: ( RULE_KW_AS )
            {
            // InternalXtextTest.g:2160:1: ( RULE_KW_AS )
            // InternalXtextTest.g:2161:1: RULE_KW_AS
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
    // InternalXtextTest.g:2174:1: rule__Import__Group__4 : rule__Import__Group__4__Impl ;
    public final void rule__Import__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2178:1: ( rule__Import__Group__4__Impl )
            // InternalXtextTest.g:2179:2: rule__Import__Group__4__Impl
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
    // InternalXtextTest.g:2185:1: rule__Import__Group__4__Impl : ( ( rule__Import__AliasAssignment_4 ) ) ;
    public final void rule__Import__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2189:1: ( ( ( rule__Import__AliasAssignment_4 ) ) )
            // InternalXtextTest.g:2191:1: ( ( rule__Import__AliasAssignment_4 ) )
            {
            // InternalXtextTest.g:2191:1: ( ( rule__Import__AliasAssignment_4 ) )
            // InternalXtextTest.g:2192:1: ( rule__Import__AliasAssignment_4 )
            {
             before(grammarAccess.getImportAccess().getAliasAssignment_4()); 
            // InternalXtextTest.g:2193:1: ( rule__Import__AliasAssignment_4 )
            // InternalXtextTest.g:2193:2: rule__Import__AliasAssignment_4
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
    // InternalXtextTest.g:2215:1: rule__PackageID__Group__0 : rule__PackageID__Group__0__Impl rule__PackageID__Group__1 ;
    public final void rule__PackageID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2219:1: ( rule__PackageID__Group__0__Impl rule__PackageID__Group__1 )
            // InternalXtextTest.g:2220:2: rule__PackageID__Group__0__Impl rule__PackageID__Group__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalXtextTest.g:2227:1: rule__PackageID__Group__0__Impl : ( RULE_IDENTIFIER ) ;
    public final void rule__PackageID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2231:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:2233:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:2233:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:2234:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:2247:1: rule__PackageID__Group__1 : rule__PackageID__Group__1__Impl ;
    public final void rule__PackageID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2251:1: ( rule__PackageID__Group__1__Impl )
            // InternalXtextTest.g:2252:2: rule__PackageID__Group__1__Impl
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
    // InternalXtextTest.g:2258:1: rule__PackageID__Group__1__Impl : ( ( rule__PackageID__Group_1__0 )* ) ;
    public final void rule__PackageID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2262:1: ( ( ( rule__PackageID__Group_1__0 )* ) )
            // InternalXtextTest.g:2264:1: ( ( rule__PackageID__Group_1__0 )* )
            {
            // InternalXtextTest.g:2264:1: ( ( rule__PackageID__Group_1__0 )* )
            // InternalXtextTest.g:2265:1: ( rule__PackageID__Group_1__0 )*
            {
             before(grammarAccess.getPackageIDAccess().getGroup_1()); 
            // InternalXtextTest.g:2266:1: ( rule__PackageID__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_POINT) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalXtextTest.g:2266:2: rule__PackageID__Group_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__PackageID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // InternalXtextTest.g:2282:1: rule__PackageID__Group_1__0 : rule__PackageID__Group_1__0__Impl rule__PackageID__Group_1__1 ;
    public final void rule__PackageID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2286:1: ( rule__PackageID__Group_1__0__Impl rule__PackageID__Group_1__1 )
            // InternalXtextTest.g:2287:2: rule__PackageID__Group_1__0__Impl rule__PackageID__Group_1__1
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
    // InternalXtextTest.g:2294:1: rule__PackageID__Group_1__0__Impl : ( RULE_POINT ) ;
    public final void rule__PackageID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2298:1: ( ( RULE_POINT ) )
            // InternalXtextTest.g:2300:1: ( RULE_POINT )
            {
            // InternalXtextTest.g:2300:1: ( RULE_POINT )
            // InternalXtextTest.g:2301:1: RULE_POINT
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
    // InternalXtextTest.g:2314:1: rule__PackageID__Group_1__1 : rule__PackageID__Group_1__1__Impl ;
    public final void rule__PackageID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2318:1: ( rule__PackageID__Group_1__1__Impl )
            // InternalXtextTest.g:2319:2: rule__PackageID__Group_1__1__Impl
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
    // InternalXtextTest.g:2325:1: rule__PackageID__Group_1__1__Impl : ( RULE_IDENTIFIER ) ;
    public final void rule__PackageID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2329:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:2331:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:2331:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:2332:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:2349:1: rule__ImportID__Group__0 : rule__ImportID__Group__0__Impl rule__ImportID__Group__1 ;
    public final void rule__ImportID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2353:1: ( rule__ImportID__Group__0__Impl rule__ImportID__Group__1 )
            // InternalXtextTest.g:2354:2: rule__ImportID__Group__0__Impl rule__ImportID__Group__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalXtextTest.g:2361:1: rule__ImportID__Group__0__Impl : ( RULE_IDENTIFIER ) ;
    public final void rule__ImportID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2365:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:2367:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:2367:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:2368:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:2381:1: rule__ImportID__Group__1 : rule__ImportID__Group__1__Impl ;
    public final void rule__ImportID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2385:1: ( rule__ImportID__Group__1__Impl )
            // InternalXtextTest.g:2386:2: rule__ImportID__Group__1__Impl
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
    // InternalXtextTest.g:2392:1: rule__ImportID__Group__1__Impl : ( ( rule__ImportID__Group_1__0 )* ) ;
    public final void rule__ImportID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2396:1: ( ( ( rule__ImportID__Group_1__0 )* ) )
            // InternalXtextTest.g:2398:1: ( ( rule__ImportID__Group_1__0 )* )
            {
            // InternalXtextTest.g:2398:1: ( ( rule__ImportID__Group_1__0 )* )
            // InternalXtextTest.g:2399:1: ( rule__ImportID__Group_1__0 )*
            {
             before(grammarAccess.getImportIDAccess().getGroup_1()); 
            // InternalXtextTest.g:2400:1: ( rule__ImportID__Group_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_POINT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalXtextTest.g:2400:2: rule__ImportID__Group_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__ImportID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalXtextTest.g:2416:1: rule__ImportID__Group_1__0 : rule__ImportID__Group_1__0__Impl rule__ImportID__Group_1__1 ;
    public final void rule__ImportID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2420:1: ( rule__ImportID__Group_1__0__Impl rule__ImportID__Group_1__1 )
            // InternalXtextTest.g:2421:2: rule__ImportID__Group_1__0__Impl rule__ImportID__Group_1__1
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
    // InternalXtextTest.g:2428:1: rule__ImportID__Group_1__0__Impl : ( RULE_POINT ) ;
    public final void rule__ImportID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2432:1: ( ( RULE_POINT ) )
            // InternalXtextTest.g:2434:1: ( RULE_POINT )
            {
            // InternalXtextTest.g:2434:1: ( RULE_POINT )
            // InternalXtextTest.g:2435:1: RULE_POINT
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
    // InternalXtextTest.g:2448:1: rule__ImportID__Group_1__1 : rule__ImportID__Group_1__1__Impl ;
    public final void rule__ImportID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2452:1: ( rule__ImportID__Group_1__1__Impl )
            // InternalXtextTest.g:2453:2: rule__ImportID__Group_1__1__Impl
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
    // InternalXtextTest.g:2459:1: rule__ImportID__Group_1__1__Impl : ( RULE_IDENTIFIER ) ;
    public final void rule__ImportID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2463:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:2465:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:2465:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:2466:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:2483:1: rule__Input__Group__0 : rule__Input__Group__0__Impl rule__Input__Group__1 ;
    public final void rule__Input__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2487:1: ( rule__Input__Group__0__Impl rule__Input__Group__1 )
            // InternalXtextTest.g:2488:2: rule__Input__Group__0__Impl rule__Input__Group__1
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
    // InternalXtextTest.g:2495:1: rule__Input__Group__0__Impl : ( () ) ;
    public final void rule__Input__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2499:1: ( ( () ) )
            // InternalXtextTest.g:2501:1: ( () )
            {
            // InternalXtextTest.g:2501:1: ( () )
            // InternalXtextTest.g:2502:1: ()
            {
             before(grammarAccess.getInputAccess().getInputAction_0()); 
            // InternalXtextTest.g:2503:1: ()
            // InternalXtextTest.g:2505:1: 
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
    // InternalXtextTest.g:2517:1: rule__Input__Group__1 : rule__Input__Group__1__Impl rule__Input__Group__2 ;
    public final void rule__Input__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2521:1: ( rule__Input__Group__1__Impl rule__Input__Group__2 )
            // InternalXtextTest.g:2522:2: rule__Input__Group__1__Impl rule__Input__Group__2
            {
            pushFollow(FOLLOW_22);
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
    // InternalXtextTest.g:2529:1: rule__Input__Group__1__Impl : ( RULE_SOURCE ) ;
    public final void rule__Input__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2533:1: ( ( RULE_SOURCE ) )
            // InternalXtextTest.g:2535:1: ( RULE_SOURCE )
            {
            // InternalXtextTest.g:2535:1: ( RULE_SOURCE )
            // InternalXtextTest.g:2536:1: RULE_SOURCE
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
    // InternalXtextTest.g:2549:1: rule__Input__Group__2 : rule__Input__Group__2__Impl ;
    public final void rule__Input__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2553:1: ( rule__Input__Group__2__Impl )
            // InternalXtextTest.g:2554:2: rule__Input__Group__2__Impl
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
    // InternalXtextTest.g:2560:1: rule__Input__Group__2__Impl : ( ( rule__Input__Alternatives_2 ) ) ;
    public final void rule__Input__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2564:1: ( ( ( rule__Input__Alternatives_2 ) ) )
            // InternalXtextTest.g:2566:1: ( ( rule__Input__Alternatives_2 ) )
            {
            // InternalXtextTest.g:2566:1: ( ( rule__Input__Alternatives_2 ) )
            // InternalXtextTest.g:2567:1: ( rule__Input__Alternatives_2 )
            {
             before(grammarAccess.getInputAccess().getAlternatives_2()); 
            // InternalXtextTest.g:2568:1: ( rule__Input__Alternatives_2 )
            // InternalXtextTest.g:2568:2: rule__Input__Alternatives_2
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
    // InternalXtextTest.g:2586:1: rule__Input__Group_2_0__0 : rule__Input__Group_2_0__0__Impl rule__Input__Group_2_0__1 ;
    public final void rule__Input__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2590:1: ( rule__Input__Group_2_0__0__Impl rule__Input__Group_2_0__1 )
            // InternalXtextTest.g:2591:2: rule__Input__Group_2_0__0__Impl rule__Input__Group_2_0__1
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
    // InternalXtextTest.g:2598:1: rule__Input__Group_2_0__0__Impl : ( RULE_SRCTEXT ) ;
    public final void rule__Input__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2602:1: ( ( RULE_SRCTEXT ) )
            // InternalXtextTest.g:2604:1: ( RULE_SRCTEXT )
            {
            // InternalXtextTest.g:2604:1: ( RULE_SRCTEXT )
            // InternalXtextTest.g:2605:1: RULE_SRCTEXT
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
    // InternalXtextTest.g:2618:1: rule__Input__Group_2_0__1 : rule__Input__Group_2_0__1__Impl rule__Input__Group_2_0__2 ;
    public final void rule__Input__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2622:1: ( rule__Input__Group_2_0__1__Impl rule__Input__Group_2_0__2 )
            // InternalXtextTest.g:2623:2: rule__Input__Group_2_0__1__Impl rule__Input__Group_2_0__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalXtextTest.g:2630:1: rule__Input__Group_2_0__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Input__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2634:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:2636:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:2636:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:2637:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:2650:1: rule__Input__Group_2_0__2 : rule__Input__Group_2_0__2__Impl ;
    public final void rule__Input__Group_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2654:1: ( rule__Input__Group_2_0__2__Impl )
            // InternalXtextTest.g:2655:2: rule__Input__Group_2_0__2__Impl
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
    // InternalXtextTest.g:2661:1: rule__Input__Group_2_0__2__Impl : ( ( rule__Input__TextAssignment_2_0_2 ) ) ;
    public final void rule__Input__Group_2_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2665:1: ( ( ( rule__Input__TextAssignment_2_0_2 ) ) )
            // InternalXtextTest.g:2667:1: ( ( rule__Input__TextAssignment_2_0_2 ) )
            {
            // InternalXtextTest.g:2667:1: ( ( rule__Input__TextAssignment_2_0_2 ) )
            // InternalXtextTest.g:2668:1: ( rule__Input__TextAssignment_2_0_2 )
            {
             before(grammarAccess.getInputAccess().getTextAssignment_2_0_2()); 
            // InternalXtextTest.g:2669:1: ( rule__Input__TextAssignment_2_0_2 )
            // InternalXtextTest.g:2669:2: rule__Input__TextAssignment_2_0_2
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
    // InternalXtextTest.g:2687:1: rule__Input__Group_2_1__0 : rule__Input__Group_2_1__0__Impl rule__Input__Group_2_1__1 ;
    public final void rule__Input__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2691:1: ( rule__Input__Group_2_1__0__Impl rule__Input__Group_2_1__1 )
            // InternalXtextTest.g:2692:2: rule__Input__Group_2_1__0__Impl rule__Input__Group_2_1__1
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
    // InternalXtextTest.g:2699:1: rule__Input__Group_2_1__0__Impl : ( RULE_FILE ) ;
    public final void rule__Input__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2703:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:2705:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:2705:1: ( RULE_FILE )
            // InternalXtextTest.g:2706:1: RULE_FILE
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
    // InternalXtextTest.g:2719:1: rule__Input__Group_2_1__1 : rule__Input__Group_2_1__1__Impl rule__Input__Group_2_1__2 ;
    public final void rule__Input__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2723:1: ( rule__Input__Group_2_1__1__Impl rule__Input__Group_2_1__2 )
            // InternalXtextTest.g:2724:2: rule__Input__Group_2_1__1__Impl rule__Input__Group_2_1__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalXtextTest.g:2731:1: rule__Input__Group_2_1__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Input__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2735:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:2737:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:2737:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:2738:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:2751:1: rule__Input__Group_2_1__2 : rule__Input__Group_2_1__2__Impl ;
    public final void rule__Input__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2755:1: ( rule__Input__Group_2_1__2__Impl )
            // InternalXtextTest.g:2756:2: rule__Input__Group_2_1__2__Impl
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
    // InternalXtextTest.g:2762:1: rule__Input__Group_2_1__2__Impl : ( ( rule__Input__FileAssignment_2_1_2 ) ) ;
    public final void rule__Input__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2766:1: ( ( ( rule__Input__FileAssignment_2_1_2 ) ) )
            // InternalXtextTest.g:2768:1: ( ( rule__Input__FileAssignment_2_1_2 ) )
            {
            // InternalXtextTest.g:2768:1: ( ( rule__Input__FileAssignment_2_1_2 ) )
            // InternalXtextTest.g:2769:1: ( rule__Input__FileAssignment_2_1_2 )
            {
             before(grammarAccess.getInputAccess().getFileAssignment_2_1_2()); 
            // InternalXtextTest.g:2770:1: ( rule__Input__FileAssignment_2_1_2 )
            // InternalXtextTest.g:2770:2: rule__Input__FileAssignment_2_1_2
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
    // InternalXtextTest.g:2788:1: rule__Tokens__Group__0 : rule__Tokens__Group__0__Impl rule__Tokens__Group__1 ;
    public final void rule__Tokens__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2792:1: ( rule__Tokens__Group__0__Impl rule__Tokens__Group__1 )
            // InternalXtextTest.g:2793:2: rule__Tokens__Group__0__Impl rule__Tokens__Group__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalXtextTest.g:2800:1: rule__Tokens__Group__0__Impl : ( () ) ;
    public final void rule__Tokens__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2804:1: ( ( () ) )
            // InternalXtextTest.g:2806:1: ( () )
            {
            // InternalXtextTest.g:2806:1: ( () )
            // InternalXtextTest.g:2807:1: ()
            {
             before(grammarAccess.getTokensAccess().getTokensAction_0()); 
            // InternalXtextTest.g:2808:1: ()
            // InternalXtextTest.g:2810:1: 
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
    // InternalXtextTest.g:2822:1: rule__Tokens__Group__1 : rule__Tokens__Group__1__Impl rule__Tokens__Group__2 ;
    public final void rule__Tokens__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2826:1: ( rule__Tokens__Group__1__Impl rule__Tokens__Group__2 )
            // InternalXtextTest.g:2827:2: rule__Tokens__Group__1__Impl rule__Tokens__Group__2
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
    // InternalXtextTest.g:2834:1: rule__Tokens__Group__1__Impl : ( RULE_LEXER ) ;
    public final void rule__Tokens__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2838:1: ( ( RULE_LEXER ) )
            // InternalXtextTest.g:2840:1: ( RULE_LEXER )
            {
            // InternalXtextTest.g:2840:1: ( RULE_LEXER )
            // InternalXtextTest.g:2841:1: RULE_LEXER
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
    // InternalXtextTest.g:2854:1: rule__Tokens__Group__2 : rule__Tokens__Group__2__Impl ;
    public final void rule__Tokens__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2858:1: ( rule__Tokens__Group__2__Impl )
            // InternalXtextTest.g:2859:2: rule__Tokens__Group__2__Impl
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
    // InternalXtextTest.g:2865:1: rule__Tokens__Group__2__Impl : ( ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* ) ) ;
    public final void rule__Tokens__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2869:1: ( ( ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* ) ) )
            // InternalXtextTest.g:2871:1: ( ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* ) )
            {
            // InternalXtextTest.g:2871:1: ( ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* ) )
            // InternalXtextTest.g:2872:1: ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* )
            {
            // InternalXtextTest.g:2872:1: ( ( rule__Tokens__TokensAssignment_2 ) )
            // InternalXtextTest.g:2873:1: ( rule__Tokens__TokensAssignment_2 )
            {
             before(grammarAccess.getTokensAccess().getTokensAssignment_2()); 
            // InternalXtextTest.g:2874:1: ( rule__Tokens__TokensAssignment_2 )
            // InternalXtextTest.g:2874:2: rule__Tokens__TokensAssignment_2
            {
            pushFollow(FOLLOW_24);
            rule__Tokens__TokensAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTokensAccess().getTokensAssignment_2()); 

            }

            // InternalXtextTest.g:2877:1: ( ( rule__Tokens__TokensAssignment_2 )* )
            // InternalXtextTest.g:2878:1: ( rule__Tokens__TokensAssignment_2 )*
            {
             before(grammarAccess.getTokensAccess().getTokensAssignment_2()); 
            // InternalXtextTest.g:2879:1: ( rule__Tokens__TokensAssignment_2 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_IDENTIFIER) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalXtextTest.g:2879:2: rule__Tokens__TokensAssignment_2
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__Tokens__TokensAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalXtextTest.g:2898:1: rule__MyTokens__Group__0 : rule__MyTokens__Group__0__Impl rule__MyTokens__Group__1 ;
    public final void rule__MyTokens__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2902:1: ( rule__MyTokens__Group__0__Impl rule__MyTokens__Group__1 )
            // InternalXtextTest.g:2903:2: rule__MyTokens__Group__0__Impl rule__MyTokens__Group__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalXtextTest.g:2910:1: rule__MyTokens__Group__0__Impl : ( ( rule__MyTokens__TokenAssignment_0 ) ) ;
    public final void rule__MyTokens__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2914:1: ( ( ( rule__MyTokens__TokenAssignment_0 ) ) )
            // InternalXtextTest.g:2916:1: ( ( rule__MyTokens__TokenAssignment_0 ) )
            {
            // InternalXtextTest.g:2916:1: ( ( rule__MyTokens__TokenAssignment_0 ) )
            // InternalXtextTest.g:2917:1: ( rule__MyTokens__TokenAssignment_0 )
            {
             before(grammarAccess.getMyTokensAccess().getTokenAssignment_0()); 
            // InternalXtextTest.g:2918:1: ( rule__MyTokens__TokenAssignment_0 )
            // InternalXtextTest.g:2918:2: rule__MyTokens__TokenAssignment_0
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
    // InternalXtextTest.g:2930:1: rule__MyTokens__Group__1 : rule__MyTokens__Group__1__Impl ;
    public final void rule__MyTokens__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2934:1: ( rule__MyTokens__Group__1__Impl )
            // InternalXtextTest.g:2935:2: rule__MyTokens__Group__1__Impl
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
    // InternalXtextTest.g:2941:1: rule__MyTokens__Group__1__Impl : ( ( rule__MyTokens__Group_1__0 )? ) ;
    public final void rule__MyTokens__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2945:1: ( ( ( rule__MyTokens__Group_1__0 )? ) )
            // InternalXtextTest.g:2947:1: ( ( rule__MyTokens__Group_1__0 )? )
            {
            // InternalXtextTest.g:2947:1: ( ( rule__MyTokens__Group_1__0 )? )
            // InternalXtextTest.g:2948:1: ( rule__MyTokens__Group_1__0 )?
            {
             before(grammarAccess.getMyTokensAccess().getGroup_1()); 
            // InternalXtextTest.g:2949:1: ( rule__MyTokens__Group_1__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ASSIGNASDATALIST) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalXtextTest.g:2949:2: rule__MyTokens__Group_1__0
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
    // InternalXtextTest.g:2965:1: rule__MyTokens__Group_1__0 : rule__MyTokens__Group_1__0__Impl rule__MyTokens__Group_1__1 ;
    public final void rule__MyTokens__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2969:1: ( rule__MyTokens__Group_1__0__Impl rule__MyTokens__Group_1__1 )
            // InternalXtextTest.g:2970:2: rule__MyTokens__Group_1__0__Impl rule__MyTokens__Group_1__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalXtextTest.g:2977:1: rule__MyTokens__Group_1__0__Impl : ( RULE_ASSIGNASDATALIST ) ;
    public final void rule__MyTokens__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2981:1: ( ( RULE_ASSIGNASDATALIST ) )
            // InternalXtextTest.g:2983:1: ( RULE_ASSIGNASDATALIST )
            {
            // InternalXtextTest.g:2983:1: ( RULE_ASSIGNASDATALIST )
            // InternalXtextTest.g:2984:1: RULE_ASSIGNASDATALIST
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
    // InternalXtextTest.g:2997:1: rule__MyTokens__Group_1__1 : rule__MyTokens__Group_1__1__Impl ;
    public final void rule__MyTokens__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3001:1: ( rule__MyTokens__Group_1__1__Impl )
            // InternalXtextTest.g:3002:2: rule__MyTokens__Group_1__1__Impl
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
    // InternalXtextTest.g:3008:1: rule__MyTokens__Group_1__1__Impl : ( ( rule__MyTokens__CountAssignment_1_1 ) ) ;
    public final void rule__MyTokens__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3012:1: ( ( ( rule__MyTokens__CountAssignment_1_1 ) ) )
            // InternalXtextTest.g:3014:1: ( ( rule__MyTokens__CountAssignment_1_1 ) )
            {
            // InternalXtextTest.g:3014:1: ( ( rule__MyTokens__CountAssignment_1_1 ) )
            // InternalXtextTest.g:3015:1: ( rule__MyTokens__CountAssignment_1_1 )
            {
             before(grammarAccess.getMyTokensAccess().getCountAssignment_1_1()); 
            // InternalXtextTest.g:3016:1: ( rule__MyTokens__CountAssignment_1_1 )
            // InternalXtextTest.g:3016:2: rule__MyTokens__CountAssignment_1_1
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
    // InternalXtextTest.g:3032:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3036:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalXtextTest.g:3037:2: rule__Element__Group__0__Impl rule__Element__Group__1
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
    // InternalXtextTest.g:3044:1: rule__Element__Group__0__Impl : ( () ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3048:1: ( ( () ) )
            // InternalXtextTest.g:3050:1: ( () )
            {
            // InternalXtextTest.g:3050:1: ( () )
            // InternalXtextTest.g:3051:1: ()
            {
             before(grammarAccess.getElementAccess().getElementAction_0()); 
            // InternalXtextTest.g:3052:1: ()
            // InternalXtextTest.g:3054:1: 
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
    // InternalXtextTest.g:3066:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3070:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // InternalXtextTest.g:3071:2: rule__Element__Group__1__Impl rule__Element__Group__2
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
    // InternalXtextTest.g:3078:1: rule__Element__Group__1__Impl : ( RULE_LEFTPAREN ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3082:1: ( ( RULE_LEFTPAREN ) )
            // InternalXtextTest.g:3084:1: ( RULE_LEFTPAREN )
            {
            // InternalXtextTest.g:3084:1: ( RULE_LEFTPAREN )
            // InternalXtextTest.g:3085:1: RULE_LEFTPAREN
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
    // InternalXtextTest.g:3098:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3102:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // InternalXtextTest.g:3103:2: rule__Element__Group__2__Impl rule__Element__Group__3
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
    // InternalXtextTest.g:3110:1: rule__Element__Group__2__Impl : ( ( rule__Element__Group_2__0 )? ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3114:1: ( ( ( rule__Element__Group_2__0 )? ) )
            // InternalXtextTest.g:3116:1: ( ( rule__Element__Group_2__0 )? )
            {
            // InternalXtextTest.g:3116:1: ( ( rule__Element__Group_2__0 )? )
            // InternalXtextTest.g:3117:1: ( rule__Element__Group_2__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_2()); 
            // InternalXtextTest.g:3118:1: ( rule__Element__Group_2__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_IDENTIFIER) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==RULE_IMPORTER) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // InternalXtextTest.g:3118:2: rule__Element__Group_2__0
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
    // InternalXtextTest.g:3130:1: rule__Element__Group__3 : rule__Element__Group__3__Impl rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3134:1: ( rule__Element__Group__3__Impl rule__Element__Group__4 )
            // InternalXtextTest.g:3135:2: rule__Element__Group__3__Impl rule__Element__Group__4
            {
            pushFollow(FOLLOW_27);
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
    // InternalXtextTest.g:3142:1: rule__Element__Group__3__Impl : ( ( rule__Element__NameAssignment_3 ) ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3146:1: ( ( ( rule__Element__NameAssignment_3 ) ) )
            // InternalXtextTest.g:3148:1: ( ( rule__Element__NameAssignment_3 ) )
            {
            // InternalXtextTest.g:3148:1: ( ( rule__Element__NameAssignment_3 ) )
            // InternalXtextTest.g:3149:1: ( rule__Element__NameAssignment_3 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_3()); 
            // InternalXtextTest.g:3150:1: ( rule__Element__NameAssignment_3 )
            // InternalXtextTest.g:3150:2: rule__Element__NameAssignment_3
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
    // InternalXtextTest.g:3162:1: rule__Element__Group__4 : rule__Element__Group__4__Impl rule__Element__Group__5 ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3166:1: ( rule__Element__Group__4__Impl rule__Element__Group__5 )
            // InternalXtextTest.g:3167:2: rule__Element__Group__4__Impl rule__Element__Group__5
            {
            pushFollow(FOLLOW_27);
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
    // InternalXtextTest.g:3174:1: rule__Element__Group__4__Impl : ( ( rule__Element__Group_4__0 )? ) ;
    public final void rule__Element__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3178:1: ( ( ( rule__Element__Group_4__0 )? ) )
            // InternalXtextTest.g:3180:1: ( ( rule__Element__Group_4__0 )? )
            {
            // InternalXtextTest.g:3180:1: ( ( rule__Element__Group_4__0 )? )
            // InternalXtextTest.g:3181:1: ( rule__Element__Group_4__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_4()); 
            // InternalXtextTest.g:3182:1: ( rule__Element__Group_4__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_IDENTIFIER) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalXtextTest.g:3182:2: rule__Element__Group_4__0
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
    // InternalXtextTest.g:3194:1: rule__Element__Group__5 : rule__Element__Group__5__Impl ;
    public final void rule__Element__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3198:1: ( rule__Element__Group__5__Impl )
            // InternalXtextTest.g:3199:2: rule__Element__Group__5__Impl
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
    // InternalXtextTest.g:3205:1: rule__Element__Group__5__Impl : ( RULE_RIGHTPAREN ) ;
    public final void rule__Element__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3209:1: ( ( RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:3211:1: ( RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:3211:1: ( RULE_RIGHTPAREN )
            // InternalXtextTest.g:3212:1: RULE_RIGHTPAREN
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
    // InternalXtextTest.g:3237:1: rule__Element__Group_2__0 : rule__Element__Group_2__0__Impl rule__Element__Group_2__1 ;
    public final void rule__Element__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3241:1: ( rule__Element__Group_2__0__Impl rule__Element__Group_2__1 )
            // InternalXtextTest.g:3242:2: rule__Element__Group_2__0__Impl rule__Element__Group_2__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalXtextTest.g:3249:1: rule__Element__Group_2__0__Impl : ( ( rule__Element__ImportingAssignment_2_0 ) ) ;
    public final void rule__Element__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3253:1: ( ( ( rule__Element__ImportingAssignment_2_0 ) ) )
            // InternalXtextTest.g:3255:1: ( ( rule__Element__ImportingAssignment_2_0 ) )
            {
            // InternalXtextTest.g:3255:1: ( ( rule__Element__ImportingAssignment_2_0 ) )
            // InternalXtextTest.g:3256:1: ( rule__Element__ImportingAssignment_2_0 )
            {
             before(grammarAccess.getElementAccess().getImportingAssignment_2_0()); 
            // InternalXtextTest.g:3257:1: ( rule__Element__ImportingAssignment_2_0 )
            // InternalXtextTest.g:3257:2: rule__Element__ImportingAssignment_2_0
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
    // InternalXtextTest.g:3269:1: rule__Element__Group_2__1 : rule__Element__Group_2__1__Impl ;
    public final void rule__Element__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3273:1: ( rule__Element__Group_2__1__Impl )
            // InternalXtextTest.g:3274:2: rule__Element__Group_2__1__Impl
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
    // InternalXtextTest.g:3280:1: rule__Element__Group_2__1__Impl : ( RULE_IMPORTER ) ;
    public final void rule__Element__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3284:1: ( ( RULE_IMPORTER ) )
            // InternalXtextTest.g:3286:1: ( RULE_IMPORTER )
            {
            // InternalXtextTest.g:3286:1: ( RULE_IMPORTER )
            // InternalXtextTest.g:3287:1: RULE_IMPORTER
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
    // InternalXtextTest.g:3304:1: rule__Element__Group_4__0 : rule__Element__Group_4__0__Impl rule__Element__Group_4__1 ;
    public final void rule__Element__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3308:1: ( rule__Element__Group_4__0__Impl rule__Element__Group_4__1 )
            // InternalXtextTest.g:3309:2: rule__Element__Group_4__0__Impl rule__Element__Group_4__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalXtextTest.g:3316:1: rule__Element__Group_4__0__Impl : ( ( rule__Element__InnerAssignment_4_0 ) ) ;
    public final void rule__Element__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3320:1: ( ( ( rule__Element__InnerAssignment_4_0 ) ) )
            // InternalXtextTest.g:3322:1: ( ( rule__Element__InnerAssignment_4_0 ) )
            {
            // InternalXtextTest.g:3322:1: ( ( rule__Element__InnerAssignment_4_0 ) )
            // InternalXtextTest.g:3323:1: ( rule__Element__InnerAssignment_4_0 )
            {
             before(grammarAccess.getElementAccess().getInnerAssignment_4_0()); 
            // InternalXtextTest.g:3324:1: ( rule__Element__InnerAssignment_4_0 )
            // InternalXtextTest.g:3324:2: rule__Element__InnerAssignment_4_0
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
    // InternalXtextTest.g:3336:1: rule__Element__Group_4__1 : rule__Element__Group_4__1__Impl ;
    public final void rule__Element__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3340:1: ( rule__Element__Group_4__1__Impl )
            // InternalXtextTest.g:3341:2: rule__Element__Group_4__1__Impl
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
    // InternalXtextTest.g:3347:1: rule__Element__Group_4__1__Impl : ( ( rule__Element__Group_4_1__0 )* ) ;
    public final void rule__Element__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3351:1: ( ( ( rule__Element__Group_4_1__0 )* ) )
            // InternalXtextTest.g:3353:1: ( ( rule__Element__Group_4_1__0 )* )
            {
            // InternalXtextTest.g:3353:1: ( ( rule__Element__Group_4_1__0 )* )
            // InternalXtextTest.g:3354:1: ( rule__Element__Group_4_1__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_4_1()); 
            // InternalXtextTest.g:3355:1: ( rule__Element__Group_4_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_COMMA) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalXtextTest.g:3355:2: rule__Element__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__Element__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalXtextTest.g:3371:1: rule__Element__Group_4_1__0 : rule__Element__Group_4_1__0__Impl rule__Element__Group_4_1__1 ;
    public final void rule__Element__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3375:1: ( rule__Element__Group_4_1__0__Impl rule__Element__Group_4_1__1 )
            // InternalXtextTest.g:3376:2: rule__Element__Group_4_1__0__Impl rule__Element__Group_4_1__1
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
    // InternalXtextTest.g:3383:1: rule__Element__Group_4_1__0__Impl : ( RULE_COMMA ) ;
    public final void rule__Element__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3387:1: ( ( RULE_COMMA ) )
            // InternalXtextTest.g:3389:1: ( RULE_COMMA )
            {
            // InternalXtextTest.g:3389:1: ( RULE_COMMA )
            // InternalXtextTest.g:3390:1: RULE_COMMA
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
    // InternalXtextTest.g:3403:1: rule__Element__Group_4_1__1 : rule__Element__Group_4_1__1__Impl ;
    public final void rule__Element__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3407:1: ( rule__Element__Group_4_1__1__Impl )
            // InternalXtextTest.g:3408:2: rule__Element__Group_4_1__1__Impl
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
    // InternalXtextTest.g:3414:1: rule__Element__Group_4_1__1__Impl : ( ( rule__Element__InnerAssignment_4_1_1 ) ) ;
    public final void rule__Element__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3418:1: ( ( ( rule__Element__InnerAssignment_4_1_1 ) ) )
            // InternalXtextTest.g:3420:1: ( ( rule__Element__InnerAssignment_4_1_1 ) )
            {
            // InternalXtextTest.g:3420:1: ( ( rule__Element__InnerAssignment_4_1_1 ) )
            // InternalXtextTest.g:3421:1: ( rule__Element__InnerAssignment_4_1_1 )
            {
             before(grammarAccess.getElementAccess().getInnerAssignment_4_1_1()); 
            // InternalXtextTest.g:3422:1: ( rule__Element__InnerAssignment_4_1_1 )
            // InternalXtextTest.g:3422:2: rule__Element__InnerAssignment_4_1_1
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
    // InternalXtextTest.g:3438:1: rule__Inner__Group__0 : rule__Inner__Group__0__Impl rule__Inner__Group__1 ;
    public final void rule__Inner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3442:1: ( rule__Inner__Group__0__Impl rule__Inner__Group__1 )
            // InternalXtextTest.g:3443:2: rule__Inner__Group__0__Impl rule__Inner__Group__1
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
    // InternalXtextTest.g:3450:1: rule__Inner__Group__0__Impl : ( () ) ;
    public final void rule__Inner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3454:1: ( ( () ) )
            // InternalXtextTest.g:3456:1: ( () )
            {
            // InternalXtextTest.g:3456:1: ( () )
            // InternalXtextTest.g:3457:1: ()
            {
             before(grammarAccess.getInnerAccess().getInnerAction_0()); 
            // InternalXtextTest.g:3458:1: ()
            // InternalXtextTest.g:3460:1: 
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
    // InternalXtextTest.g:3472:1: rule__Inner__Group__1 : rule__Inner__Group__1__Impl rule__Inner__Group__2 ;
    public final void rule__Inner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3476:1: ( rule__Inner__Group__1__Impl rule__Inner__Group__2 )
            // InternalXtextTest.g:3477:2: rule__Inner__Group__1__Impl rule__Inner__Group__2
            {
            pushFollow(FOLLOW_31);
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
    // InternalXtextTest.g:3484:1: rule__Inner__Group__1__Impl : ( ( rule__Inner__ParameterAssignment_1 ) ) ;
    public final void rule__Inner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3488:1: ( ( ( rule__Inner__ParameterAssignment_1 ) ) )
            // InternalXtextTest.g:3490:1: ( ( rule__Inner__ParameterAssignment_1 ) )
            {
            // InternalXtextTest.g:3490:1: ( ( rule__Inner__ParameterAssignment_1 ) )
            // InternalXtextTest.g:3491:1: ( rule__Inner__ParameterAssignment_1 )
            {
             before(grammarAccess.getInnerAccess().getParameterAssignment_1()); 
            // InternalXtextTest.g:3492:1: ( rule__Inner__ParameterAssignment_1 )
            // InternalXtextTest.g:3492:2: rule__Inner__ParameterAssignment_1
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
    // InternalXtextTest.g:3504:1: rule__Inner__Group__2 : rule__Inner__Group__2__Impl ;
    public final void rule__Inner__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3508:1: ( rule__Inner__Group__2__Impl )
            // InternalXtextTest.g:3509:2: rule__Inner__Group__2__Impl
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
    // InternalXtextTest.g:3515:1: rule__Inner__Group__2__Impl : ( ( rule__Inner__Alternatives_2 ) ) ;
    public final void rule__Inner__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3519:1: ( ( ( rule__Inner__Alternatives_2 ) ) )
            // InternalXtextTest.g:3521:1: ( ( rule__Inner__Alternatives_2 ) )
            {
            // InternalXtextTest.g:3521:1: ( ( rule__Inner__Alternatives_2 ) )
            // InternalXtextTest.g:3522:1: ( rule__Inner__Alternatives_2 )
            {
             before(grammarAccess.getInnerAccess().getAlternatives_2()); 
            // InternalXtextTest.g:3523:1: ( rule__Inner__Alternatives_2 )
            // InternalXtextTest.g:3523:2: rule__Inner__Alternatives_2
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
    // InternalXtextTest.g:3541:1: rule__Inner__Group_2_0__0 : rule__Inner__Group_2_0__0__Impl rule__Inner__Group_2_0__1 ;
    public final void rule__Inner__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3545:1: ( rule__Inner__Group_2_0__0__Impl rule__Inner__Group_2_0__1 )
            // InternalXtextTest.g:3546:2: rule__Inner__Group_2_0__0__Impl rule__Inner__Group_2_0__1
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
    // InternalXtextTest.g:3553:1: rule__Inner__Group_2_0__0__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Inner__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3557:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:3559:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:3559:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:3560:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:3573:1: rule__Inner__Group_2_0__1 : rule__Inner__Group_2_0__1__Impl ;
    public final void rule__Inner__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3577:1: ( rule__Inner__Group_2_0__1__Impl )
            // InternalXtextTest.g:3578:2: rule__Inner__Group_2_0__1__Impl
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
    // InternalXtextTest.g:3584:1: rule__Inner__Group_2_0__1__Impl : ( ( rule__Inner__AssignAssignment_2_0_1 ) ) ;
    public final void rule__Inner__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3588:1: ( ( ( rule__Inner__AssignAssignment_2_0_1 ) ) )
            // InternalXtextTest.g:3590:1: ( ( rule__Inner__AssignAssignment_2_0_1 ) )
            {
            // InternalXtextTest.g:3590:1: ( ( rule__Inner__AssignAssignment_2_0_1 ) )
            // InternalXtextTest.g:3591:1: ( rule__Inner__AssignAssignment_2_0_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignAssignment_2_0_1()); 
            // InternalXtextTest.g:3592:1: ( rule__Inner__AssignAssignment_2_0_1 )
            // InternalXtextTest.g:3592:2: rule__Inner__AssignAssignment_2_0_1
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
    // InternalXtextTest.g:3608:1: rule__Inner__Group_2_1__0 : rule__Inner__Group_2_1__0__Impl rule__Inner__Group_2_1__1 ;
    public final void rule__Inner__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3612:1: ( rule__Inner__Group_2_1__0__Impl rule__Inner__Group_2_1__1 )
            // InternalXtextTest.g:3613:2: rule__Inner__Group_2_1__0__Impl rule__Inner__Group_2_1__1
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
    // InternalXtextTest.g:3620:1: rule__Inner__Group_2_1__0__Impl : ( RULE_ASSIGNASLIST ) ;
    public final void rule__Inner__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3624:1: ( ( RULE_ASSIGNASLIST ) )
            // InternalXtextTest.g:3626:1: ( RULE_ASSIGNASLIST )
            {
            // InternalXtextTest.g:3626:1: ( RULE_ASSIGNASLIST )
            // InternalXtextTest.g:3627:1: RULE_ASSIGNASLIST
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
    // InternalXtextTest.g:3640:1: rule__Inner__Group_2_1__1 : rule__Inner__Group_2_1__1__Impl rule__Inner__Group_2_1__2 ;
    public final void rule__Inner__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3644:1: ( rule__Inner__Group_2_1__1__Impl rule__Inner__Group_2_1__2 )
            // InternalXtextTest.g:3645:2: rule__Inner__Group_2_1__1__Impl rule__Inner__Group_2_1__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalXtextTest.g:3652:1: rule__Inner__Group_2_1__1__Impl : ( ( rule__Inner__AssignListAssignment_2_1_1 ) ) ;
    public final void rule__Inner__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3656:1: ( ( ( rule__Inner__AssignListAssignment_2_1_1 ) ) )
            // InternalXtextTest.g:3658:1: ( ( rule__Inner__AssignListAssignment_2_1_1 ) )
            {
            // InternalXtextTest.g:3658:1: ( ( rule__Inner__AssignListAssignment_2_1_1 ) )
            // InternalXtextTest.g:3659:1: ( rule__Inner__AssignListAssignment_2_1_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignListAssignment_2_1_1()); 
            // InternalXtextTest.g:3660:1: ( rule__Inner__AssignListAssignment_2_1_1 )
            // InternalXtextTest.g:3660:2: rule__Inner__AssignListAssignment_2_1_1
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
    // InternalXtextTest.g:3672:1: rule__Inner__Group_2_1__2 : rule__Inner__Group_2_1__2__Impl ;
    public final void rule__Inner__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3676:1: ( rule__Inner__Group_2_1__2__Impl )
            // InternalXtextTest.g:3677:2: rule__Inner__Group_2_1__2__Impl
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
    // InternalXtextTest.g:3683:1: rule__Inner__Group_2_1__2__Impl : ( ( rule__Inner__Group_2_1_2__0 )* ) ;
    public final void rule__Inner__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3687:1: ( ( ( rule__Inner__Group_2_1_2__0 )* ) )
            // InternalXtextTest.g:3689:1: ( ( rule__Inner__Group_2_1_2__0 )* )
            {
            // InternalXtextTest.g:3689:1: ( ( rule__Inner__Group_2_1_2__0 )* )
            // InternalXtextTest.g:3690:1: ( rule__Inner__Group_2_1_2__0 )*
            {
             before(grammarAccess.getInnerAccess().getGroup_2_1_2()); 
            // InternalXtextTest.g:3691:1: ( rule__Inner__Group_2_1_2__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_COMMA) ) {
                    int LA21_2 = input.LA(2);

                    if ( (LA21_2==RULE_LEFTPAREN) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // InternalXtextTest.g:3691:2: rule__Inner__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__Inner__Group_2_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalXtextTest.g:3709:1: rule__Inner__Group_2_1_2__0 : rule__Inner__Group_2_1_2__0__Impl rule__Inner__Group_2_1_2__1 ;
    public final void rule__Inner__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3713:1: ( rule__Inner__Group_2_1_2__0__Impl rule__Inner__Group_2_1_2__1 )
            // InternalXtextTest.g:3714:2: rule__Inner__Group_2_1_2__0__Impl rule__Inner__Group_2_1_2__1
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
    // InternalXtextTest.g:3721:1: rule__Inner__Group_2_1_2__0__Impl : ( RULE_COMMA ) ;
    public final void rule__Inner__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3725:1: ( ( RULE_COMMA ) )
            // InternalXtextTest.g:3727:1: ( RULE_COMMA )
            {
            // InternalXtextTest.g:3727:1: ( RULE_COMMA )
            // InternalXtextTest.g:3728:1: RULE_COMMA
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
    // InternalXtextTest.g:3741:1: rule__Inner__Group_2_1_2__1 : rule__Inner__Group_2_1_2__1__Impl ;
    public final void rule__Inner__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3745:1: ( rule__Inner__Group_2_1_2__1__Impl )
            // InternalXtextTest.g:3746:2: rule__Inner__Group_2_1_2__1__Impl
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
    // InternalXtextTest.g:3752:1: rule__Inner__Group_2_1_2__1__Impl : ( ( rule__Inner__AssignListAssignment_2_1_2_1 ) ) ;
    public final void rule__Inner__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3756:1: ( ( ( rule__Inner__AssignListAssignment_2_1_2_1 ) ) )
            // InternalXtextTest.g:3758:1: ( ( rule__Inner__AssignListAssignment_2_1_2_1 ) )
            {
            // InternalXtextTest.g:3758:1: ( ( rule__Inner__AssignListAssignment_2_1_2_1 ) )
            // InternalXtextTest.g:3759:1: ( rule__Inner__AssignListAssignment_2_1_2_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignListAssignment_2_1_2_1()); 
            // InternalXtextTest.g:3760:1: ( rule__Inner__AssignListAssignment_2_1_2_1 )
            // InternalXtextTest.g:3760:2: rule__Inner__AssignListAssignment_2_1_2_1
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
    // InternalXtextTest.g:3776:1: rule__Inner__Group_2_2__0 : rule__Inner__Group_2_2__0__Impl rule__Inner__Group_2_2__1 ;
    public final void rule__Inner__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3780:1: ( rule__Inner__Group_2_2__0__Impl rule__Inner__Group_2_2__1 )
            // InternalXtextTest.g:3781:2: rule__Inner__Group_2_2__0__Impl rule__Inner__Group_2_2__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalXtextTest.g:3788:1: rule__Inner__Group_2_2__0__Impl : ( RULE_ASSIGNASSTRING ) ;
    public final void rule__Inner__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3792:1: ( ( RULE_ASSIGNASSTRING ) )
            // InternalXtextTest.g:3794:1: ( RULE_ASSIGNASSTRING )
            {
            // InternalXtextTest.g:3794:1: ( RULE_ASSIGNASSTRING )
            // InternalXtextTest.g:3795:1: RULE_ASSIGNASSTRING
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
    // InternalXtextTest.g:3808:1: rule__Inner__Group_2_2__1 : rule__Inner__Group_2_2__1__Impl ;
    public final void rule__Inner__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3812:1: ( rule__Inner__Group_2_2__1__Impl )
            // InternalXtextTest.g:3813:2: rule__Inner__Group_2_2__1__Impl
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
    // InternalXtextTest.g:3819:1: rule__Inner__Group_2_2__1__Impl : ( ( rule__Inner__ValueAssignment_2_2_1 ) ) ;
    public final void rule__Inner__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3823:1: ( ( ( rule__Inner__ValueAssignment_2_2_1 ) ) )
            // InternalXtextTest.g:3825:1: ( ( rule__Inner__ValueAssignment_2_2_1 ) )
            {
            // InternalXtextTest.g:3825:1: ( ( rule__Inner__ValueAssignment_2_2_1 ) )
            // InternalXtextTest.g:3826:1: ( rule__Inner__ValueAssignment_2_2_1 )
            {
             before(grammarAccess.getInnerAccess().getValueAssignment_2_2_1()); 
            // InternalXtextTest.g:3827:1: ( rule__Inner__ValueAssignment_2_2_1 )
            // InternalXtextTest.g:3827:2: rule__Inner__ValueAssignment_2_2_1
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
    // InternalXtextTest.g:3843:1: rule__Inner__Group_2_3__0 : rule__Inner__Group_2_3__0__Impl rule__Inner__Group_2_3__1 ;
    public final void rule__Inner__Group_2_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3847:1: ( rule__Inner__Group_2_3__0__Impl rule__Inner__Group_2_3__1 )
            // InternalXtextTest.g:3848:2: rule__Inner__Group_2_3__0__Impl rule__Inner__Group_2_3__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalXtextTest.g:3855:1: rule__Inner__Group_2_3__0__Impl : ( RULE_ASSIGNASDATALIST ) ;
    public final void rule__Inner__Group_2_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3859:1: ( ( RULE_ASSIGNASDATALIST ) )
            // InternalXtextTest.g:3861:1: ( RULE_ASSIGNASDATALIST )
            {
            // InternalXtextTest.g:3861:1: ( RULE_ASSIGNASDATALIST )
            // InternalXtextTest.g:3862:1: RULE_ASSIGNASDATALIST
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
    // InternalXtextTest.g:3875:1: rule__Inner__Group_2_3__1 : rule__Inner__Group_2_3__1__Impl ;
    public final void rule__Inner__Group_2_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3879:1: ( rule__Inner__Group_2_3__1__Impl )
            // InternalXtextTest.g:3880:2: rule__Inner__Group_2_3__1__Impl
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
    // InternalXtextTest.g:3886:1: rule__Inner__Group_2_3__1__Impl : ( ( rule__Inner__AssignAsDataAssignment_2_3_1 ) ) ;
    public final void rule__Inner__Group_2_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3890:1: ( ( ( rule__Inner__AssignAsDataAssignment_2_3_1 ) ) )
            // InternalXtextTest.g:3892:1: ( ( rule__Inner__AssignAsDataAssignment_2_3_1 ) )
            {
            // InternalXtextTest.g:3892:1: ( ( rule__Inner__AssignAsDataAssignment_2_3_1 ) )
            // InternalXtextTest.g:3893:1: ( rule__Inner__AssignAsDataAssignment_2_3_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignAsDataAssignment_2_3_1()); 
            // InternalXtextTest.g:3894:1: ( rule__Inner__AssignAsDataAssignment_2_3_1 )
            // InternalXtextTest.g:3894:2: rule__Inner__AssignAsDataAssignment_2_3_1
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
    // InternalXtextTest.g:3910:1: rule__Inner__Group_2_4__0 : rule__Inner__Group_2_4__0__Impl rule__Inner__Group_2_4__1 ;
    public final void rule__Inner__Group_2_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3914:1: ( rule__Inner__Group_2_4__0__Impl rule__Inner__Group_2_4__1 )
            // InternalXtextTest.g:3915:2: rule__Inner__Group_2_4__0__Impl rule__Inner__Group_2_4__1
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
    // InternalXtextTest.g:3922:1: rule__Inner__Group_2_4__0__Impl : ( RULE_ASSIGNASBOOL ) ;
    public final void rule__Inner__Group_2_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3926:1: ( ( RULE_ASSIGNASBOOL ) )
            // InternalXtextTest.g:3928:1: ( RULE_ASSIGNASBOOL )
            {
            // InternalXtextTest.g:3928:1: ( RULE_ASSIGNASBOOL )
            // InternalXtextTest.g:3929:1: RULE_ASSIGNASBOOL
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
    // InternalXtextTest.g:3942:1: rule__Inner__Group_2_4__1 : rule__Inner__Group_2_4__1__Impl ;
    public final void rule__Inner__Group_2_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3946:1: ( rule__Inner__Group_2_4__1__Impl )
            // InternalXtextTest.g:3947:2: rule__Inner__Group_2_4__1__Impl
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
    // InternalXtextTest.g:3953:1: rule__Inner__Group_2_4__1__Impl : ( ( rule__Inner__AssignAsBoolAssignment_2_4_1 ) ) ;
    public final void rule__Inner__Group_2_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3957:1: ( ( ( rule__Inner__AssignAsBoolAssignment_2_4_1 ) ) )
            // InternalXtextTest.g:3959:1: ( ( rule__Inner__AssignAsBoolAssignment_2_4_1 ) )
            {
            // InternalXtextTest.g:3959:1: ( ( rule__Inner__AssignAsBoolAssignment_2_4_1 ) )
            // InternalXtextTest.g:3960:1: ( rule__Inner__AssignAsBoolAssignment_2_4_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignAsBoolAssignment_2_4_1()); 
            // InternalXtextTest.g:3961:1: ( rule__Inner__AssignAsBoolAssignment_2_4_1 )
            // InternalXtextTest.g:3961:2: rule__Inner__AssignAsBoolAssignment_2_4_1
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
    // InternalXtextTest.g:3977:1: rule__Generator__Group__0 : rule__Generator__Group__0__Impl rule__Generator__Group__1 ;
    public final void rule__Generator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3981:1: ( rule__Generator__Group__0__Impl rule__Generator__Group__1 )
            // InternalXtextTest.g:3982:2: rule__Generator__Group__0__Impl rule__Generator__Group__1
            {
            pushFollow(FOLLOW_32);
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
    // InternalXtextTest.g:3989:1: rule__Generator__Group__0__Impl : ( () ) ;
    public final void rule__Generator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3993:1: ( ( () ) )
            // InternalXtextTest.g:3995:1: ( () )
            {
            // InternalXtextTest.g:3995:1: ( () )
            // InternalXtextTest.g:3996:1: ()
            {
             before(grammarAccess.getGeneratorAccess().getGeneratorAction_0()); 
            // InternalXtextTest.g:3997:1: ()
            // InternalXtextTest.g:3999:1: 
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
    // InternalXtextTest.g:4011:1: rule__Generator__Group__1 : rule__Generator__Group__1__Impl rule__Generator__Group__2 ;
    public final void rule__Generator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4015:1: ( rule__Generator__Group__1__Impl rule__Generator__Group__2 )
            // InternalXtextTest.g:4016:2: rule__Generator__Group__1__Impl rule__Generator__Group__2
            {
            pushFollow(FOLLOW_33);
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
    // InternalXtextTest.g:4023:1: rule__Generator__Group__1__Impl : ( ( rule__Generator__Group_1__0 ) ) ;
    public final void rule__Generator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4027:1: ( ( ( rule__Generator__Group_1__0 ) ) )
            // InternalXtextTest.g:4029:1: ( ( rule__Generator__Group_1__0 ) )
            {
            // InternalXtextTest.g:4029:1: ( ( rule__Generator__Group_1__0 ) )
            // InternalXtextTest.g:4030:1: ( rule__Generator__Group_1__0 )
            {
             before(grammarAccess.getGeneratorAccess().getGroup_1()); 
            // InternalXtextTest.g:4031:1: ( rule__Generator__Group_1__0 )
            // InternalXtextTest.g:4031:2: rule__Generator__Group_1__0
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
    // InternalXtextTest.g:4043:1: rule__Generator__Group__2 : rule__Generator__Group__2__Impl rule__Generator__Group__3 ;
    public final void rule__Generator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4047:1: ( rule__Generator__Group__2__Impl rule__Generator__Group__3 )
            // InternalXtextTest.g:4048:2: rule__Generator__Group__2__Impl rule__Generator__Group__3
            {
            pushFollow(FOLLOW_34);
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
    // InternalXtextTest.g:4055:1: rule__Generator__Group__2__Impl : ( ( rule__Generator__Group_2__0 ) ) ;
    public final void rule__Generator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4059:1: ( ( ( rule__Generator__Group_2__0 ) ) )
            // InternalXtextTest.g:4061:1: ( ( rule__Generator__Group_2__0 ) )
            {
            // InternalXtextTest.g:4061:1: ( ( rule__Generator__Group_2__0 ) )
            // InternalXtextTest.g:4062:1: ( rule__Generator__Group_2__0 )
            {
             before(grammarAccess.getGeneratorAccess().getGroup_2()); 
            // InternalXtextTest.g:4063:1: ( rule__Generator__Group_2__0 )
            // InternalXtextTest.g:4063:2: rule__Generator__Group_2__0
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
    // InternalXtextTest.g:4075:1: rule__Generator__Group__3 : rule__Generator__Group__3__Impl rule__Generator__Group__4 ;
    public final void rule__Generator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4079:1: ( rule__Generator__Group__3__Impl rule__Generator__Group__4 )
            // InternalXtextTest.g:4080:2: rule__Generator__Group__3__Impl rule__Generator__Group__4
            {
            pushFollow(FOLLOW_34);
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
    // InternalXtextTest.g:4087:1: rule__Generator__Group__3__Impl : ( ( rule__Generator__Group_3__0 )? ) ;
    public final void rule__Generator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4091:1: ( ( ( rule__Generator__Group_3__0 )? ) )
            // InternalXtextTest.g:4093:1: ( ( rule__Generator__Group_3__0 )? )
            {
            // InternalXtextTest.g:4093:1: ( ( rule__Generator__Group_3__0 )? )
            // InternalXtextTest.g:4094:1: ( rule__Generator__Group_3__0 )?
            {
             before(grammarAccess.getGeneratorAccess().getGroup_3()); 
            // InternalXtextTest.g:4095:1: ( rule__Generator__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_PATTERNS) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalXtextTest.g:4095:2: rule__Generator__Group_3__0
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
    // InternalXtextTest.g:4107:1: rule__Generator__Group__4 : rule__Generator__Group__4__Impl ;
    public final void rule__Generator__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4111:1: ( rule__Generator__Group__4__Impl )
            // InternalXtextTest.g:4112:2: rule__Generator__Group__4__Impl
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
    // InternalXtextTest.g:4118:1: rule__Generator__Group__4__Impl : ( ( rule__Generator__Group_4__0 )? ) ;
    public final void rule__Generator__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4122:1: ( ( ( rule__Generator__Group_4__0 )? ) )
            // InternalXtextTest.g:4124:1: ( ( rule__Generator__Group_4__0 )? )
            {
            // InternalXtextTest.g:4124:1: ( ( rule__Generator__Group_4__0 )? )
            // InternalXtextTest.g:4125:1: ( rule__Generator__Group_4__0 )?
            {
             before(grammarAccess.getGeneratorAccess().getGroup_4()); 
            // InternalXtextTest.g:4126:1: ( rule__Generator__Group_4__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_EXPECTED) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalXtextTest.g:4126:2: rule__Generator__Group_4__0
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
    // InternalXtextTest.g:4148:1: rule__Generator__Group_1__0 : rule__Generator__Group_1__0__Impl rule__Generator__Group_1__1 ;
    public final void rule__Generator__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4152:1: ( rule__Generator__Group_1__0__Impl rule__Generator__Group_1__1 )
            // InternalXtextTest.g:4153:2: rule__Generator__Group_1__0__Impl rule__Generator__Group_1__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalXtextTest.g:4160:1: rule__Generator__Group_1__0__Impl : ( RULE_OUTPUT ) ;
    public final void rule__Generator__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4164:1: ( ( RULE_OUTPUT ) )
            // InternalXtextTest.g:4166:1: ( RULE_OUTPUT )
            {
            // InternalXtextTest.g:4166:1: ( RULE_OUTPUT )
            // InternalXtextTest.g:4167:1: RULE_OUTPUT
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
    // InternalXtextTest.g:4180:1: rule__Generator__Group_1__1 : rule__Generator__Group_1__1__Impl rule__Generator__Group_1__2 ;
    public final void rule__Generator__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4184:1: ( rule__Generator__Group_1__1__Impl rule__Generator__Group_1__2 )
            // InternalXtextTest.g:4185:2: rule__Generator__Group_1__1__Impl rule__Generator__Group_1__2
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
    // InternalXtextTest.g:4192:1: rule__Generator__Group_1__1__Impl : ( RULE_FILE ) ;
    public final void rule__Generator__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4196:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:4198:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:4198:1: ( RULE_FILE )
            // InternalXtextTest.g:4199:1: RULE_FILE
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
    // InternalXtextTest.g:4212:1: rule__Generator__Group_1__2 : rule__Generator__Group_1__2__Impl rule__Generator__Group_1__3 ;
    public final void rule__Generator__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4216:1: ( rule__Generator__Group_1__2__Impl rule__Generator__Group_1__3 )
            // InternalXtextTest.g:4217:2: rule__Generator__Group_1__2__Impl rule__Generator__Group_1__3
            {
            pushFollow(FOLLOW_17);
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
    // InternalXtextTest.g:4224:1: rule__Generator__Group_1__2__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Generator__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4228:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:4230:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:4230:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:4231:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:4244:1: rule__Generator__Group_1__3 : rule__Generator__Group_1__3__Impl ;
    public final void rule__Generator__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4248:1: ( rule__Generator__Group_1__3__Impl )
            // InternalXtextTest.g:4249:2: rule__Generator__Group_1__3__Impl
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
    // InternalXtextTest.g:4255:1: rule__Generator__Group_1__3__Impl : ( ( rule__Generator__OutputAssignment_1_3 ) ) ;
    public final void rule__Generator__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4259:1: ( ( ( rule__Generator__OutputAssignment_1_3 ) ) )
            // InternalXtextTest.g:4261:1: ( ( rule__Generator__OutputAssignment_1_3 ) )
            {
            // InternalXtextTest.g:4261:1: ( ( rule__Generator__OutputAssignment_1_3 ) )
            // InternalXtextTest.g:4262:1: ( rule__Generator__OutputAssignment_1_3 )
            {
             before(grammarAccess.getGeneratorAccess().getOutputAssignment_1_3()); 
            // InternalXtextTest.g:4263:1: ( rule__Generator__OutputAssignment_1_3 )
            // InternalXtextTest.g:4263:2: rule__Generator__OutputAssignment_1_3
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
    // InternalXtextTest.g:4283:1: rule__Generator__Group_2__0 : rule__Generator__Group_2__0__Impl rule__Generator__Group_2__1 ;
    public final void rule__Generator__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4287:1: ( rule__Generator__Group_2__0__Impl rule__Generator__Group_2__1 )
            // InternalXtextTest.g:4288:2: rule__Generator__Group_2__0__Impl rule__Generator__Group_2__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalXtextTest.g:4295:1: rule__Generator__Group_2__0__Impl : ( RULE_EXPECTED ) ;
    public final void rule__Generator__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4299:1: ( ( RULE_EXPECTED ) )
            // InternalXtextTest.g:4301:1: ( RULE_EXPECTED )
            {
            // InternalXtextTest.g:4301:1: ( RULE_EXPECTED )
            // InternalXtextTest.g:4302:1: RULE_EXPECTED
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
    // InternalXtextTest.g:4315:1: rule__Generator__Group_2__1 : rule__Generator__Group_2__1__Impl rule__Generator__Group_2__2 ;
    public final void rule__Generator__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4319:1: ( rule__Generator__Group_2__1__Impl rule__Generator__Group_2__2 )
            // InternalXtextTest.g:4320:2: rule__Generator__Group_2__1__Impl rule__Generator__Group_2__2
            {
            pushFollow(FOLLOW_35);
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
    // InternalXtextTest.g:4327:1: rule__Generator__Group_2__1__Impl : ( RULE_FILE ) ;
    public final void rule__Generator__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4331:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:4333:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:4333:1: ( RULE_FILE )
            // InternalXtextTest.g:4334:1: RULE_FILE
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
    // InternalXtextTest.g:4347:1: rule__Generator__Group_2__2 : rule__Generator__Group_2__2__Impl ;
    public final void rule__Generator__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4351:1: ( rule__Generator__Group_2__2__Impl )
            // InternalXtextTest.g:4352:2: rule__Generator__Group_2__2__Impl
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
    // InternalXtextTest.g:4358:1: rule__Generator__Group_2__2__Impl : ( ( rule__Generator__Alternatives_2_2 ) ) ;
    public final void rule__Generator__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4362:1: ( ( ( rule__Generator__Alternatives_2_2 ) ) )
            // InternalXtextTest.g:4364:1: ( ( rule__Generator__Alternatives_2_2 ) )
            {
            // InternalXtextTest.g:4364:1: ( ( rule__Generator__Alternatives_2_2 ) )
            // InternalXtextTest.g:4365:1: ( rule__Generator__Alternatives_2_2 )
            {
             before(grammarAccess.getGeneratorAccess().getAlternatives_2_2()); 
            // InternalXtextTest.g:4366:1: ( rule__Generator__Alternatives_2_2 )
            // InternalXtextTest.g:4366:2: rule__Generator__Alternatives_2_2
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
    // InternalXtextTest.g:4384:1: rule__Generator__Group_2_2_0__0 : rule__Generator__Group_2_2_0__0__Impl rule__Generator__Group_2_2_0__1 ;
    public final void rule__Generator__Group_2_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4388:1: ( rule__Generator__Group_2_2_0__0__Impl rule__Generator__Group_2_2_0__1 )
            // InternalXtextTest.g:4389:2: rule__Generator__Group_2_2_0__0__Impl rule__Generator__Group_2_2_0__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalXtextTest.g:4396:1: rule__Generator__Group_2_2_0__0__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Generator__Group_2_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4400:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:4402:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:4402:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:4403:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:4416:1: rule__Generator__Group_2_2_0__1 : rule__Generator__Group_2_2_0__1__Impl ;
    public final void rule__Generator__Group_2_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4420:1: ( rule__Generator__Group_2_2_0__1__Impl )
            // InternalXtextTest.g:4421:2: rule__Generator__Group_2_2_0__1__Impl
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
    // InternalXtextTest.g:4427:1: rule__Generator__Group_2_2_0__1__Impl : ( ( rule__Generator__ExpectedAssignment_2_2_0_1 ) ) ;
    public final void rule__Generator__Group_2_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4431:1: ( ( ( rule__Generator__ExpectedAssignment_2_2_0_1 ) ) )
            // InternalXtextTest.g:4433:1: ( ( rule__Generator__ExpectedAssignment_2_2_0_1 ) )
            {
            // InternalXtextTest.g:4433:1: ( ( rule__Generator__ExpectedAssignment_2_2_0_1 ) )
            // InternalXtextTest.g:4434:1: ( rule__Generator__ExpectedAssignment_2_2_0_1 )
            {
             before(grammarAccess.getGeneratorAccess().getExpectedAssignment_2_2_0_1()); 
            // InternalXtextTest.g:4435:1: ( rule__Generator__ExpectedAssignment_2_2_0_1 )
            // InternalXtextTest.g:4435:2: rule__Generator__ExpectedAssignment_2_2_0_1
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
    // InternalXtextTest.g:4451:1: rule__Generator__Group_3__0 : rule__Generator__Group_3__0__Impl rule__Generator__Group_3__1 ;
    public final void rule__Generator__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4455:1: ( rule__Generator__Group_3__0__Impl rule__Generator__Group_3__1 )
            // InternalXtextTest.g:4456:2: rule__Generator__Group_3__0__Impl rule__Generator__Group_3__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalXtextTest.g:4463:1: rule__Generator__Group_3__0__Impl : ( RULE_PATTERNS ) ;
    public final void rule__Generator__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4467:1: ( ( RULE_PATTERNS ) )
            // InternalXtextTest.g:4469:1: ( RULE_PATTERNS )
            {
            // InternalXtextTest.g:4469:1: ( RULE_PATTERNS )
            // InternalXtextTest.g:4470:1: RULE_PATTERNS
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
    // InternalXtextTest.g:4483:1: rule__Generator__Group_3__1 : rule__Generator__Group_3__1__Impl rule__Generator__Group_3__2 ;
    public final void rule__Generator__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4487:1: ( rule__Generator__Group_3__1__Impl rule__Generator__Group_3__2 )
            // InternalXtextTest.g:4488:2: rule__Generator__Group_3__1__Impl rule__Generator__Group_3__2
            {
            pushFollow(FOLLOW_36);
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
    // InternalXtextTest.g:4495:1: rule__Generator__Group_3__1__Impl : ( ( rule__Generator__Group_3_1__0 )? ) ;
    public final void rule__Generator__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4499:1: ( ( ( rule__Generator__Group_3_1__0 )? ) )
            // InternalXtextTest.g:4501:1: ( ( rule__Generator__Group_3_1__0 )? )
            {
            // InternalXtextTest.g:4501:1: ( ( rule__Generator__Group_3_1__0 )? )
            // InternalXtextTest.g:4502:1: ( rule__Generator__Group_3_1__0 )?
            {
             before(grammarAccess.getGeneratorAccess().getGroup_3_1()); 
            // InternalXtextTest.g:4503:1: ( rule__Generator__Group_3_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_FILE) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalXtextTest.g:4503:2: rule__Generator__Group_3_1__0
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
    // InternalXtextTest.g:4515:1: rule__Generator__Group_3__2 : rule__Generator__Group_3__2__Impl ;
    public final void rule__Generator__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4519:1: ( rule__Generator__Group_3__2__Impl )
            // InternalXtextTest.g:4520:2: rule__Generator__Group_3__2__Impl
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
    // InternalXtextTest.g:4526:1: rule__Generator__Group_3__2__Impl : ( ( rule__Generator__ReplacePatternsAssignment_3_2 )* ) ;
    public final void rule__Generator__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4530:1: ( ( ( rule__Generator__ReplacePatternsAssignment_3_2 )* ) )
            // InternalXtextTest.g:4532:1: ( ( rule__Generator__ReplacePatternsAssignment_3_2 )* )
            {
            // InternalXtextTest.g:4532:1: ( ( rule__Generator__ReplacePatternsAssignment_3_2 )* )
            // InternalXtextTest.g:4533:1: ( rule__Generator__ReplacePatternsAssignment_3_2 )*
            {
             before(grammarAccess.getGeneratorAccess().getReplacePatternsAssignment_3_2()); 
            // InternalXtextTest.g:4534:1: ( rule__Generator__ReplacePatternsAssignment_3_2 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_STRING) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalXtextTest.g:4534:2: rule__Generator__ReplacePatternsAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_37);
            	    rule__Generator__ReplacePatternsAssignment_3_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalXtextTest.g:4552:1: rule__Generator__Group_3_1__0 : rule__Generator__Group_3_1__0__Impl rule__Generator__Group_3_1__1 ;
    public final void rule__Generator__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4556:1: ( rule__Generator__Group_3_1__0__Impl rule__Generator__Group_3_1__1 )
            // InternalXtextTest.g:4557:2: rule__Generator__Group_3_1__0__Impl rule__Generator__Group_3_1__1
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
    // InternalXtextTest.g:4564:1: rule__Generator__Group_3_1__0__Impl : ( RULE_FILE ) ;
    public final void rule__Generator__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4568:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:4570:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:4570:1: ( RULE_FILE )
            // InternalXtextTest.g:4571:1: RULE_FILE
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
    // InternalXtextTest.g:4584:1: rule__Generator__Group_3_1__1 : rule__Generator__Group_3_1__1__Impl rule__Generator__Group_3_1__2 ;
    public final void rule__Generator__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4588:1: ( rule__Generator__Group_3_1__1__Impl rule__Generator__Group_3_1__2 )
            // InternalXtextTest.g:4589:2: rule__Generator__Group_3_1__1__Impl rule__Generator__Group_3_1__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalXtextTest.g:4596:1: rule__Generator__Group_3_1__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Generator__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4600:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:4602:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:4602:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:4603:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:4616:1: rule__Generator__Group_3_1__2 : rule__Generator__Group_3_1__2__Impl ;
    public final void rule__Generator__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4620:1: ( rule__Generator__Group_3_1__2__Impl )
            // InternalXtextTest.g:4621:2: rule__Generator__Group_3_1__2__Impl
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
    // InternalXtextTest.g:4627:1: rule__Generator__Group_3_1__2__Impl : ( ( rule__Generator__PatternFileAssignment_3_1_2 ) ) ;
    public final void rule__Generator__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4631:1: ( ( ( rule__Generator__PatternFileAssignment_3_1_2 ) ) )
            // InternalXtextTest.g:4633:1: ( ( rule__Generator__PatternFileAssignment_3_1_2 ) )
            {
            // InternalXtextTest.g:4633:1: ( ( rule__Generator__PatternFileAssignment_3_1_2 ) )
            // InternalXtextTest.g:4634:1: ( rule__Generator__PatternFileAssignment_3_1_2 )
            {
             before(grammarAccess.getGeneratorAccess().getPatternFileAssignment_3_1_2()); 
            // InternalXtextTest.g:4635:1: ( rule__Generator__PatternFileAssignment_3_1_2 )
            // InternalXtextTest.g:4635:2: rule__Generator__PatternFileAssignment_3_1_2
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
    // InternalXtextTest.g:4653:1: rule__Generator__Group_4__0 : rule__Generator__Group_4__0__Impl rule__Generator__Group_4__1 ;
    public final void rule__Generator__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4657:1: ( rule__Generator__Group_4__0__Impl rule__Generator__Group_4__1 )
            // InternalXtextTest.g:4658:2: rule__Generator__Group_4__0__Impl rule__Generator__Group_4__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalXtextTest.g:4665:1: rule__Generator__Group_4__0__Impl : ( RULE_EXPECTED ) ;
    public final void rule__Generator__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4669:1: ( ( RULE_EXPECTED ) )
            // InternalXtextTest.g:4671:1: ( RULE_EXPECTED )
            {
            // InternalXtextTest.g:4671:1: ( RULE_EXPECTED )
            // InternalXtextTest.g:4672:1: RULE_EXPECTED
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
    // InternalXtextTest.g:4685:1: rule__Generator__Group_4__1 : rule__Generator__Group_4__1__Impl rule__Generator__Group_4__2 ;
    public final void rule__Generator__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4689:1: ( rule__Generator__Group_4__1__Impl rule__Generator__Group_4__2 )
            // InternalXtextTest.g:4690:2: rule__Generator__Group_4__1__Impl rule__Generator__Group_4__2
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
    // InternalXtextTest.g:4697:1: rule__Generator__Group_4__1__Impl : ( RULE_EXCEPTIONS ) ;
    public final void rule__Generator__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4701:1: ( ( RULE_EXCEPTIONS ) )
            // InternalXtextTest.g:4703:1: ( RULE_EXCEPTIONS )
            {
            // InternalXtextTest.g:4703:1: ( RULE_EXCEPTIONS )
            // InternalXtextTest.g:4704:1: RULE_EXCEPTIONS
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
    // InternalXtextTest.g:4717:1: rule__Generator__Group_4__2 : rule__Generator__Group_4__2__Impl ;
    public final void rule__Generator__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4721:1: ( rule__Generator__Group_4__2__Impl )
            // InternalXtextTest.g:4722:2: rule__Generator__Group_4__2__Impl
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
    // InternalXtextTest.g:4728:1: rule__Generator__Group_4__2__Impl : ( ( rule__Generator__ExceptionAssignment_4_2 ) ) ;
    public final void rule__Generator__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4732:1: ( ( ( rule__Generator__ExceptionAssignment_4_2 ) ) )
            // InternalXtextTest.g:4734:1: ( ( rule__Generator__ExceptionAssignment_4_2 ) )
            {
            // InternalXtextTest.g:4734:1: ( ( rule__Generator__ExceptionAssignment_4_2 ) )
            // InternalXtextTest.g:4735:1: ( rule__Generator__ExceptionAssignment_4_2 )
            {
             before(grammarAccess.getGeneratorAccess().getExceptionAssignment_4_2()); 
            // InternalXtextTest.g:4736:1: ( rule__Generator__ExceptionAssignment_4_2 )
            // InternalXtextTest.g:4736:2: rule__Generator__ExceptionAssignment_4_2
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
    // InternalXtextTest.g:4754:1: rule__ReplacePatterns__Group__0 : rule__ReplacePatterns__Group__0__Impl rule__ReplacePatterns__Group__1 ;
    public final void rule__ReplacePatterns__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4758:1: ( rule__ReplacePatterns__Group__0__Impl rule__ReplacePatterns__Group__1 )
            // InternalXtextTest.g:4759:2: rule__ReplacePatterns__Group__0__Impl rule__ReplacePatterns__Group__1
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
    // InternalXtextTest.g:4766:1: rule__ReplacePatterns__Group__0__Impl : ( ( rule__ReplacePatterns__RegexAssignment_0 ) ) ;
    public final void rule__ReplacePatterns__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4770:1: ( ( ( rule__ReplacePatterns__RegexAssignment_0 ) ) )
            // InternalXtextTest.g:4772:1: ( ( rule__ReplacePatterns__RegexAssignment_0 ) )
            {
            // InternalXtextTest.g:4772:1: ( ( rule__ReplacePatterns__RegexAssignment_0 ) )
            // InternalXtextTest.g:4773:1: ( rule__ReplacePatterns__RegexAssignment_0 )
            {
             before(grammarAccess.getReplacePatternsAccess().getRegexAssignment_0()); 
            // InternalXtextTest.g:4774:1: ( rule__ReplacePatterns__RegexAssignment_0 )
            // InternalXtextTest.g:4774:2: rule__ReplacePatterns__RegexAssignment_0
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
    // InternalXtextTest.g:4786:1: rule__ReplacePatterns__Group__1 : rule__ReplacePatterns__Group__1__Impl rule__ReplacePatterns__Group__2 ;
    public final void rule__ReplacePatterns__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4790:1: ( rule__ReplacePatterns__Group__1__Impl rule__ReplacePatterns__Group__2 )
            // InternalXtextTest.g:4791:2: rule__ReplacePatterns__Group__1__Impl rule__ReplacePatterns__Group__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalXtextTest.g:4798:1: rule__ReplacePatterns__Group__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__ReplacePatterns__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4802:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:4804:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:4804:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:4805:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:4818:1: rule__ReplacePatterns__Group__2 : rule__ReplacePatterns__Group__2__Impl ;
    public final void rule__ReplacePatterns__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4822:1: ( rule__ReplacePatterns__Group__2__Impl )
            // InternalXtextTest.g:4823:2: rule__ReplacePatterns__Group__2__Impl
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
    // InternalXtextTest.g:4829:1: rule__ReplacePatterns__Group__2__Impl : ( ( rule__ReplacePatterns__ReplaceAssignment_2 ) ) ;
    public final void rule__ReplacePatterns__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4833:1: ( ( ( rule__ReplacePatterns__ReplaceAssignment_2 ) ) )
            // InternalXtextTest.g:4835:1: ( ( rule__ReplacePatterns__ReplaceAssignment_2 ) )
            {
            // InternalXtextTest.g:4835:1: ( ( rule__ReplacePatterns__ReplaceAssignment_2 ) )
            // InternalXtextTest.g:4836:1: ( rule__ReplacePatterns__ReplaceAssignment_2 )
            {
             before(grammarAccess.getReplacePatternsAccess().getReplaceAssignment_2()); 
            // InternalXtextTest.g:4837:1: ( rule__ReplacePatterns__ReplaceAssignment_2 )
            // InternalXtextTest.g:4837:2: rule__ReplacePatterns__ReplaceAssignment_2
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
    // InternalXtextTest.g:4855:1: rule__Before__Group__0 : rule__Before__Group__0__Impl rule__Before__Group__1 ;
    public final void rule__Before__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4859:1: ( rule__Before__Group__0__Impl rule__Before__Group__1 )
            // InternalXtextTest.g:4860:2: rule__Before__Group__0__Impl rule__Before__Group__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalXtextTest.g:4867:1: rule__Before__Group__0__Impl : ( RULE_BEFORE_KW ) ;
    public final void rule__Before__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4871:1: ( ( RULE_BEFORE_KW ) )
            // InternalXtextTest.g:4873:1: ( RULE_BEFORE_KW )
            {
            // InternalXtextTest.g:4873:1: ( RULE_BEFORE_KW )
            // InternalXtextTest.g:4874:1: RULE_BEFORE_KW
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
    // InternalXtextTest.g:4887:1: rule__Before__Group__1 : rule__Before__Group__1__Impl rule__Before__Group__2 ;
    public final void rule__Before__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4891:1: ( rule__Before__Group__1__Impl rule__Before__Group__2 )
            // InternalXtextTest.g:4892:2: rule__Before__Group__1__Impl rule__Before__Group__2
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
    // InternalXtextTest.g:4899:1: rule__Before__Group__1__Impl : ( RULE_CLASS_KW ) ;
    public final void rule__Before__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4903:1: ( ( RULE_CLASS_KW ) )
            // InternalXtextTest.g:4905:1: ( RULE_CLASS_KW )
            {
            // InternalXtextTest.g:4905:1: ( RULE_CLASS_KW )
            // InternalXtextTest.g:4906:1: RULE_CLASS_KW
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
    // InternalXtextTest.g:4919:1: rule__Before__Group__2 : rule__Before__Group__2__Impl rule__Before__Group__3 ;
    public final void rule__Before__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4923:1: ( rule__Before__Group__2__Impl rule__Before__Group__3 )
            // InternalXtextTest.g:4924:2: rule__Before__Group__2__Impl rule__Before__Group__3
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
    // InternalXtextTest.g:4931:1: rule__Before__Group__2__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Before__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4935:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:4937:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:4937:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:4938:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:4951:1: rule__Before__Group__3 : rule__Before__Group__3__Impl rule__Before__Group__4 ;
    public final void rule__Before__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4955:1: ( rule__Before__Group__3__Impl rule__Before__Group__4 )
            // InternalXtextTest.g:4956:2: rule__Before__Group__3__Impl rule__Before__Group__4
            {
            pushFollow(FOLLOW_40);
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
    // InternalXtextTest.g:4963:1: rule__Before__Group__3__Impl : ( ( rule__Before__MyclassAssignment_3 ) ) ;
    public final void rule__Before__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4967:1: ( ( ( rule__Before__MyclassAssignment_3 ) ) )
            // InternalXtextTest.g:4969:1: ( ( rule__Before__MyclassAssignment_3 ) )
            {
            // InternalXtextTest.g:4969:1: ( ( rule__Before__MyclassAssignment_3 ) )
            // InternalXtextTest.g:4970:1: ( rule__Before__MyclassAssignment_3 )
            {
             before(grammarAccess.getBeforeAccess().getMyclassAssignment_3()); 
            // InternalXtextTest.g:4971:1: ( rule__Before__MyclassAssignment_3 )
            // InternalXtextTest.g:4971:2: rule__Before__MyclassAssignment_3
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
    // InternalXtextTest.g:4983:1: rule__Before__Group__4 : rule__Before__Group__4__Impl rule__Before__Group__5 ;
    public final void rule__Before__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4987:1: ( rule__Before__Group__4__Impl rule__Before__Group__5 )
            // InternalXtextTest.g:4988:2: rule__Before__Group__4__Impl rule__Before__Group__5
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
    // InternalXtextTest.g:4995:1: rule__Before__Group__4__Impl : ( RULE_METHOD_KW ) ;
    public final void rule__Before__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4999:1: ( ( RULE_METHOD_KW ) )
            // InternalXtextTest.g:5001:1: ( RULE_METHOD_KW )
            {
            // InternalXtextTest.g:5001:1: ( RULE_METHOD_KW )
            // InternalXtextTest.g:5002:1: RULE_METHOD_KW
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
    // InternalXtextTest.g:5015:1: rule__Before__Group__5 : rule__Before__Group__5__Impl rule__Before__Group__6 ;
    public final void rule__Before__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5019:1: ( rule__Before__Group__5__Impl rule__Before__Group__6 )
            // InternalXtextTest.g:5020:2: rule__Before__Group__5__Impl rule__Before__Group__6
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
    // InternalXtextTest.g:5027:1: rule__Before__Group__5__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Before__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5031:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:5033:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:5033:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:5034:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:5047:1: rule__Before__Group__6 : rule__Before__Group__6__Impl rule__Before__Group__7 ;
    public final void rule__Before__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5051:1: ( rule__Before__Group__6__Impl rule__Before__Group__7 )
            // InternalXtextTest.g:5052:2: rule__Before__Group__6__Impl rule__Before__Group__7
            {
            pushFollow(FOLLOW_41);
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
    // InternalXtextTest.g:5059:1: rule__Before__Group__6__Impl : ( ( rule__Before__MethodAssignment_6 ) ) ;
    public final void rule__Before__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5063:1: ( ( ( rule__Before__MethodAssignment_6 ) ) )
            // InternalXtextTest.g:5065:1: ( ( rule__Before__MethodAssignment_6 ) )
            {
            // InternalXtextTest.g:5065:1: ( ( rule__Before__MethodAssignment_6 ) )
            // InternalXtextTest.g:5066:1: ( rule__Before__MethodAssignment_6 )
            {
             before(grammarAccess.getBeforeAccess().getMethodAssignment_6()); 
            // InternalXtextTest.g:5067:1: ( rule__Before__MethodAssignment_6 )
            // InternalXtextTest.g:5067:2: rule__Before__MethodAssignment_6
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
    // InternalXtextTest.g:5079:1: rule__Before__Group__7 : rule__Before__Group__7__Impl rule__Before__Group__8 ;
    public final void rule__Before__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5083:1: ( rule__Before__Group__7__Impl rule__Before__Group__8 )
            // InternalXtextTest.g:5084:2: rule__Before__Group__7__Impl rule__Before__Group__8
            {
            pushFollow(FOLLOW_42);
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
    // InternalXtextTest.g:5091:1: rule__Before__Group__7__Impl : ( RULE_LEFTPAREN ) ;
    public final void rule__Before__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5095:1: ( ( RULE_LEFTPAREN ) )
            // InternalXtextTest.g:5097:1: ( RULE_LEFTPAREN )
            {
            // InternalXtextTest.g:5097:1: ( RULE_LEFTPAREN )
            // InternalXtextTest.g:5098:1: RULE_LEFTPAREN
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
    // InternalXtextTest.g:5111:1: rule__Before__Group__8 : rule__Before__Group__8__Impl ;
    public final void rule__Before__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5115:1: ( rule__Before__Group__8__Impl )
            // InternalXtextTest.g:5116:2: rule__Before__Group__8__Impl
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
    // InternalXtextTest.g:5122:1: rule__Before__Group__8__Impl : ( RULE_RIGHTPAREN ) ;
    public final void rule__Before__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5126:1: ( ( RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:5128:1: ( RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:5128:1: ( RULE_RIGHTPAREN )
            // InternalXtextTest.g:5129:1: RULE_RIGHTPAREN
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
    // InternalXtextTest.g:5160:1: rule__After__Group__0 : rule__After__Group__0__Impl rule__After__Group__1 ;
    public final void rule__After__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5164:1: ( rule__After__Group__0__Impl rule__After__Group__1 )
            // InternalXtextTest.g:5165:2: rule__After__Group__0__Impl rule__After__Group__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalXtextTest.g:5172:1: rule__After__Group__0__Impl : ( RULE_AFTER_KW ) ;
    public final void rule__After__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5176:1: ( ( RULE_AFTER_KW ) )
            // InternalXtextTest.g:5178:1: ( RULE_AFTER_KW )
            {
            // InternalXtextTest.g:5178:1: ( RULE_AFTER_KW )
            // InternalXtextTest.g:5179:1: RULE_AFTER_KW
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
    // InternalXtextTest.g:5192:1: rule__After__Group__1 : rule__After__Group__1__Impl rule__After__Group__2 ;
    public final void rule__After__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5196:1: ( rule__After__Group__1__Impl rule__After__Group__2 )
            // InternalXtextTest.g:5197:2: rule__After__Group__1__Impl rule__After__Group__2
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
    // InternalXtextTest.g:5204:1: rule__After__Group__1__Impl : ( RULE_CLASS_KW ) ;
    public final void rule__After__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5208:1: ( ( RULE_CLASS_KW ) )
            // InternalXtextTest.g:5210:1: ( RULE_CLASS_KW )
            {
            // InternalXtextTest.g:5210:1: ( RULE_CLASS_KW )
            // InternalXtextTest.g:5211:1: RULE_CLASS_KW
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
    // InternalXtextTest.g:5224:1: rule__After__Group__2 : rule__After__Group__2__Impl rule__After__Group__3 ;
    public final void rule__After__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5228:1: ( rule__After__Group__2__Impl rule__After__Group__3 )
            // InternalXtextTest.g:5229:2: rule__After__Group__2__Impl rule__After__Group__3
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
    // InternalXtextTest.g:5236:1: rule__After__Group__2__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__After__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5240:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:5242:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:5242:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:5243:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:5256:1: rule__After__Group__3 : rule__After__Group__3__Impl rule__After__Group__4 ;
    public final void rule__After__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5260:1: ( rule__After__Group__3__Impl rule__After__Group__4 )
            // InternalXtextTest.g:5261:2: rule__After__Group__3__Impl rule__After__Group__4
            {
            pushFollow(FOLLOW_40);
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
    // InternalXtextTest.g:5268:1: rule__After__Group__3__Impl : ( ( rule__After__MyclassAssignment_3 ) ) ;
    public final void rule__After__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5272:1: ( ( ( rule__After__MyclassAssignment_3 ) ) )
            // InternalXtextTest.g:5274:1: ( ( rule__After__MyclassAssignment_3 ) )
            {
            // InternalXtextTest.g:5274:1: ( ( rule__After__MyclassAssignment_3 ) )
            // InternalXtextTest.g:5275:1: ( rule__After__MyclassAssignment_3 )
            {
             before(grammarAccess.getAfterAccess().getMyclassAssignment_3()); 
            // InternalXtextTest.g:5276:1: ( rule__After__MyclassAssignment_3 )
            // InternalXtextTest.g:5276:2: rule__After__MyclassAssignment_3
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
    // InternalXtextTest.g:5288:1: rule__After__Group__4 : rule__After__Group__4__Impl rule__After__Group__5 ;
    public final void rule__After__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5292:1: ( rule__After__Group__4__Impl rule__After__Group__5 )
            // InternalXtextTest.g:5293:2: rule__After__Group__4__Impl rule__After__Group__5
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
    // InternalXtextTest.g:5300:1: rule__After__Group__4__Impl : ( RULE_METHOD_KW ) ;
    public final void rule__After__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5304:1: ( ( RULE_METHOD_KW ) )
            // InternalXtextTest.g:5306:1: ( RULE_METHOD_KW )
            {
            // InternalXtextTest.g:5306:1: ( RULE_METHOD_KW )
            // InternalXtextTest.g:5307:1: RULE_METHOD_KW
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
    // InternalXtextTest.g:5320:1: rule__After__Group__5 : rule__After__Group__5__Impl rule__After__Group__6 ;
    public final void rule__After__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5324:1: ( rule__After__Group__5__Impl rule__After__Group__6 )
            // InternalXtextTest.g:5325:2: rule__After__Group__5__Impl rule__After__Group__6
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
    // InternalXtextTest.g:5332:1: rule__After__Group__5__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__After__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5336:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:5338:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:5338:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:5339:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:5352:1: rule__After__Group__6 : rule__After__Group__6__Impl rule__After__Group__7 ;
    public final void rule__After__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5356:1: ( rule__After__Group__6__Impl rule__After__Group__7 )
            // InternalXtextTest.g:5357:2: rule__After__Group__6__Impl rule__After__Group__7
            {
            pushFollow(FOLLOW_41);
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
    // InternalXtextTest.g:5364:1: rule__After__Group__6__Impl : ( ( rule__After__MethodAssignment_6 ) ) ;
    public final void rule__After__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5368:1: ( ( ( rule__After__MethodAssignment_6 ) ) )
            // InternalXtextTest.g:5370:1: ( ( rule__After__MethodAssignment_6 ) )
            {
            // InternalXtextTest.g:5370:1: ( ( rule__After__MethodAssignment_6 ) )
            // InternalXtextTest.g:5371:1: ( rule__After__MethodAssignment_6 )
            {
             before(grammarAccess.getAfterAccess().getMethodAssignment_6()); 
            // InternalXtextTest.g:5372:1: ( rule__After__MethodAssignment_6 )
            // InternalXtextTest.g:5372:2: rule__After__MethodAssignment_6
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
    // InternalXtextTest.g:5384:1: rule__After__Group__7 : rule__After__Group__7__Impl rule__After__Group__8 ;
    public final void rule__After__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5388:1: ( rule__After__Group__7__Impl rule__After__Group__8 )
            // InternalXtextTest.g:5389:2: rule__After__Group__7__Impl rule__After__Group__8
            {
            pushFollow(FOLLOW_42);
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
    // InternalXtextTest.g:5396:1: rule__After__Group__7__Impl : ( RULE_LEFTPAREN ) ;
    public final void rule__After__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5400:1: ( ( RULE_LEFTPAREN ) )
            // InternalXtextTest.g:5402:1: ( RULE_LEFTPAREN )
            {
            // InternalXtextTest.g:5402:1: ( RULE_LEFTPAREN )
            // InternalXtextTest.g:5403:1: RULE_LEFTPAREN
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
    // InternalXtextTest.g:5416:1: rule__After__Group__8 : rule__After__Group__8__Impl ;
    public final void rule__After__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5420:1: ( rule__After__Group__8__Impl )
            // InternalXtextTest.g:5421:2: rule__After__Group__8__Impl
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
    // InternalXtextTest.g:5427:1: rule__After__Group__8__Impl : ( RULE_RIGHTPAREN ) ;
    public final void rule__After__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5431:1: ( ( RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:5433:1: ( RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:5433:1: ( RULE_RIGHTPAREN )
            // InternalXtextTest.g:5434:1: RULE_RIGHTPAREN
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
    // InternalXtextTest.g:5465:1: rule__CodeCall__Group__0 : rule__CodeCall__Group__0__Impl rule__CodeCall__Group__1 ;
    public final void rule__CodeCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5469:1: ( rule__CodeCall__Group__0__Impl rule__CodeCall__Group__1 )
            // InternalXtextTest.g:5470:2: rule__CodeCall__Group__0__Impl rule__CodeCall__Group__1
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
    // InternalXtextTest.g:5477:1: rule__CodeCall__Group__0__Impl : ( RULE_CLASS_KW ) ;
    public final void rule__CodeCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5481:1: ( ( RULE_CLASS_KW ) )
            // InternalXtextTest.g:5483:1: ( RULE_CLASS_KW )
            {
            // InternalXtextTest.g:5483:1: ( RULE_CLASS_KW )
            // InternalXtextTest.g:5484:1: RULE_CLASS_KW
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
    // InternalXtextTest.g:5497:1: rule__CodeCall__Group__1 : rule__CodeCall__Group__1__Impl rule__CodeCall__Group__2 ;
    public final void rule__CodeCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5501:1: ( rule__CodeCall__Group__1__Impl rule__CodeCall__Group__2 )
            // InternalXtextTest.g:5502:2: rule__CodeCall__Group__1__Impl rule__CodeCall__Group__2
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
    // InternalXtextTest.g:5509:1: rule__CodeCall__Group__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__CodeCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5513:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:5515:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:5515:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:5516:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:5529:1: rule__CodeCall__Group__2 : rule__CodeCall__Group__2__Impl rule__CodeCall__Group__3 ;
    public final void rule__CodeCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5533:1: ( rule__CodeCall__Group__2__Impl rule__CodeCall__Group__3 )
            // InternalXtextTest.g:5534:2: rule__CodeCall__Group__2__Impl rule__CodeCall__Group__3
            {
            pushFollow(FOLLOW_40);
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
    // InternalXtextTest.g:5541:1: rule__CodeCall__Group__2__Impl : ( ( rule__CodeCall__MyclassAssignment_2 ) ) ;
    public final void rule__CodeCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5545:1: ( ( ( rule__CodeCall__MyclassAssignment_2 ) ) )
            // InternalXtextTest.g:5547:1: ( ( rule__CodeCall__MyclassAssignment_2 ) )
            {
            // InternalXtextTest.g:5547:1: ( ( rule__CodeCall__MyclassAssignment_2 ) )
            // InternalXtextTest.g:5548:1: ( rule__CodeCall__MyclassAssignment_2 )
            {
             before(grammarAccess.getCodeCallAccess().getMyclassAssignment_2()); 
            // InternalXtextTest.g:5549:1: ( rule__CodeCall__MyclassAssignment_2 )
            // InternalXtextTest.g:5549:2: rule__CodeCall__MyclassAssignment_2
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
    // InternalXtextTest.g:5561:1: rule__CodeCall__Group__3 : rule__CodeCall__Group__3__Impl rule__CodeCall__Group__4 ;
    public final void rule__CodeCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5565:1: ( rule__CodeCall__Group__3__Impl rule__CodeCall__Group__4 )
            // InternalXtextTest.g:5566:2: rule__CodeCall__Group__3__Impl rule__CodeCall__Group__4
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
    // InternalXtextTest.g:5573:1: rule__CodeCall__Group__3__Impl : ( RULE_METHOD_KW ) ;
    public final void rule__CodeCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5577:1: ( ( RULE_METHOD_KW ) )
            // InternalXtextTest.g:5579:1: ( RULE_METHOD_KW )
            {
            // InternalXtextTest.g:5579:1: ( RULE_METHOD_KW )
            // InternalXtextTest.g:5580:1: RULE_METHOD_KW
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
    // InternalXtextTest.g:5593:1: rule__CodeCall__Group__4 : rule__CodeCall__Group__4__Impl rule__CodeCall__Group__5 ;
    public final void rule__CodeCall__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5597:1: ( rule__CodeCall__Group__4__Impl rule__CodeCall__Group__5 )
            // InternalXtextTest.g:5598:2: rule__CodeCall__Group__4__Impl rule__CodeCall__Group__5
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
    // InternalXtextTest.g:5605:1: rule__CodeCall__Group__4__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__CodeCall__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5609:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:5611:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:5611:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:5612:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:5625:1: rule__CodeCall__Group__5 : rule__CodeCall__Group__5__Impl rule__CodeCall__Group__6 ;
    public final void rule__CodeCall__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5629:1: ( rule__CodeCall__Group__5__Impl rule__CodeCall__Group__6 )
            // InternalXtextTest.g:5630:2: rule__CodeCall__Group__5__Impl rule__CodeCall__Group__6
            {
            pushFollow(FOLLOW_41);
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
    // InternalXtextTest.g:5637:1: rule__CodeCall__Group__5__Impl : ( ( rule__CodeCall__MethodAssignment_5 ) ) ;
    public final void rule__CodeCall__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5641:1: ( ( ( rule__CodeCall__MethodAssignment_5 ) ) )
            // InternalXtextTest.g:5643:1: ( ( rule__CodeCall__MethodAssignment_5 ) )
            {
            // InternalXtextTest.g:5643:1: ( ( rule__CodeCall__MethodAssignment_5 ) )
            // InternalXtextTest.g:5644:1: ( rule__CodeCall__MethodAssignment_5 )
            {
             before(grammarAccess.getCodeCallAccess().getMethodAssignment_5()); 
            // InternalXtextTest.g:5645:1: ( rule__CodeCall__MethodAssignment_5 )
            // InternalXtextTest.g:5645:2: rule__CodeCall__MethodAssignment_5
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


    // $ANTLR start "rule__CodeCall__Group__6"
    // InternalXtextTest.g:5657:1: rule__CodeCall__Group__6 : rule__CodeCall__Group__6__Impl rule__CodeCall__Group__7 ;
    public final void rule__CodeCall__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5661:1: ( rule__CodeCall__Group__6__Impl rule__CodeCall__Group__7 )
            // InternalXtextTest.g:5662:2: rule__CodeCall__Group__6__Impl rule__CodeCall__Group__7
            {
            pushFollow(FOLLOW_27);
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
    // InternalXtextTest.g:5669:1: rule__CodeCall__Group__6__Impl : ( RULE_LEFTPAREN ) ;
    public final void rule__CodeCall__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5673:1: ( ( RULE_LEFTPAREN ) )
            // InternalXtextTest.g:5675:1: ( RULE_LEFTPAREN )
            {
            // InternalXtextTest.g:5675:1: ( RULE_LEFTPAREN )
            // InternalXtextTest.g:5676:1: RULE_LEFTPAREN
            {
             before(grammarAccess.getCodeCallAccess().getLEFTPARENTerminalRuleCall_6()); 
            match(input,RULE_LEFTPAREN,FOLLOW_2); 
             after(grammarAccess.getCodeCallAccess().getLEFTPARENTerminalRuleCall_6()); 

            }


            }

        }
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
    // InternalXtextTest.g:5689:1: rule__CodeCall__Group__7 : rule__CodeCall__Group__7__Impl rule__CodeCall__Group__8 ;
    public final void rule__CodeCall__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5693:1: ( rule__CodeCall__Group__7__Impl rule__CodeCall__Group__8 )
            // InternalXtextTest.g:5694:2: rule__CodeCall__Group__7__Impl rule__CodeCall__Group__8
            {
            pushFollow(FOLLOW_27);
            rule__CodeCall__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CodeCall__Group__8();

            state._fsp--;


            }

        }
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
    // InternalXtextTest.g:5701:1: rule__CodeCall__Group__7__Impl : ( ( rule__CodeCall__Group_7__0 )? ) ;
    public final void rule__CodeCall__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5705:1: ( ( ( rule__CodeCall__Group_7__0 )? ) )
            // InternalXtextTest.g:5707:1: ( ( rule__CodeCall__Group_7__0 )? )
            {
            // InternalXtextTest.g:5707:1: ( ( rule__CodeCall__Group_7__0 )? )
            // InternalXtextTest.g:5708:1: ( rule__CodeCall__Group_7__0 )?
            {
             before(grammarAccess.getCodeCallAccess().getGroup_7()); 
            // InternalXtextTest.g:5709:1: ( rule__CodeCall__Group_7__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_IDENTIFIER) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalXtextTest.g:5709:2: rule__CodeCall__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CodeCall__Group_7__0();

                    state._fsp--;


                    }
                    break;

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


    // $ANTLR start "rule__CodeCall__Group__8"
    // InternalXtextTest.g:5721:1: rule__CodeCall__Group__8 : rule__CodeCall__Group__8__Impl ;
    public final void rule__CodeCall__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5725:1: ( rule__CodeCall__Group__8__Impl )
            // InternalXtextTest.g:5726:2: rule__CodeCall__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__8"


    // $ANTLR start "rule__CodeCall__Group__8__Impl"
    // InternalXtextTest.g:5732:1: rule__CodeCall__Group__8__Impl : ( RULE_RIGHTPAREN ) ;
    public final void rule__CodeCall__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5736:1: ( ( RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:5738:1: ( RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:5738:1: ( RULE_RIGHTPAREN )
            // InternalXtextTest.g:5739:1: RULE_RIGHTPAREN
            {
             before(grammarAccess.getCodeCallAccess().getRIGHTPARENTerminalRuleCall_8()); 
            match(input,RULE_RIGHTPAREN,FOLLOW_2); 
             after(grammarAccess.getCodeCallAccess().getRIGHTPARENTerminalRuleCall_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__Group__8__Impl"


    // $ANTLR start "rule__CodeCall__Group_7__0"
    // InternalXtextTest.g:5770:1: rule__CodeCall__Group_7__0 : rule__CodeCall__Group_7__0__Impl rule__CodeCall__Group_7__1 ;
    public final void rule__CodeCall__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5774:1: ( rule__CodeCall__Group_7__0__Impl rule__CodeCall__Group_7__1 )
            // InternalXtextTest.g:5775:2: rule__CodeCall__Group_7__0__Impl rule__CodeCall__Group_7__1
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
    // InternalXtextTest.g:5782:1: rule__CodeCall__Group_7__0__Impl : ( ( rule__CodeCall__ParamsAssignment_7_0 ) ) ;
    public final void rule__CodeCall__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5786:1: ( ( ( rule__CodeCall__ParamsAssignment_7_0 ) ) )
            // InternalXtextTest.g:5788:1: ( ( rule__CodeCall__ParamsAssignment_7_0 ) )
            {
            // InternalXtextTest.g:5788:1: ( ( rule__CodeCall__ParamsAssignment_7_0 ) )
            // InternalXtextTest.g:5789:1: ( rule__CodeCall__ParamsAssignment_7_0 )
            {
             before(grammarAccess.getCodeCallAccess().getParamsAssignment_7_0()); 
            // InternalXtextTest.g:5790:1: ( rule__CodeCall__ParamsAssignment_7_0 )
            // InternalXtextTest.g:5790:2: rule__CodeCall__ParamsAssignment_7_0
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__ParamsAssignment_7_0();

            state._fsp--;


            }

             after(grammarAccess.getCodeCallAccess().getParamsAssignment_7_0()); 

            }


            }

        }
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
    // InternalXtextTest.g:5802:1: rule__CodeCall__Group_7__1 : rule__CodeCall__Group_7__1__Impl ;
    public final void rule__CodeCall__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5806:1: ( rule__CodeCall__Group_7__1__Impl )
            // InternalXtextTest.g:5807:2: rule__CodeCall__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__Group_7__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalXtextTest.g:5813:1: rule__CodeCall__Group_7__1__Impl : ( ( rule__CodeCall__Group_7_1__0 )* ) ;
    public final void rule__CodeCall__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5817:1: ( ( ( rule__CodeCall__Group_7_1__0 )* ) )
            // InternalXtextTest.g:5819:1: ( ( rule__CodeCall__Group_7_1__0 )* )
            {
            // InternalXtextTest.g:5819:1: ( ( rule__CodeCall__Group_7_1__0 )* )
            // InternalXtextTest.g:5820:1: ( rule__CodeCall__Group_7_1__0 )*
            {
             before(grammarAccess.getCodeCallAccess().getGroup_7_1()); 
            // InternalXtextTest.g:5821:1: ( rule__CodeCall__Group_7_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_COMMA) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalXtextTest.g:5821:2: rule__CodeCall__Group_7_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__CodeCall__Group_7_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

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


    // $ANTLR start "rule__CodeCall__Group_7_1__0"
    // InternalXtextTest.g:5837:1: rule__CodeCall__Group_7_1__0 : rule__CodeCall__Group_7_1__0__Impl rule__CodeCall__Group_7_1__1 ;
    public final void rule__CodeCall__Group_7_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5841:1: ( rule__CodeCall__Group_7_1__0__Impl rule__CodeCall__Group_7_1__1 )
            // InternalXtextTest.g:5842:2: rule__CodeCall__Group_7_1__0__Impl rule__CodeCall__Group_7_1__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalXtextTest.g:5849:1: rule__CodeCall__Group_7_1__0__Impl : ( RULE_COMMA ) ;
    public final void rule__CodeCall__Group_7_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5853:1: ( ( RULE_COMMA ) )
            // InternalXtextTest.g:5855:1: ( RULE_COMMA )
            {
            // InternalXtextTest.g:5855:1: ( RULE_COMMA )
            // InternalXtextTest.g:5856:1: RULE_COMMA
            {
             before(grammarAccess.getCodeCallAccess().getCOMMATerminalRuleCall_7_1_0()); 
            match(input,RULE_COMMA,FOLLOW_2); 
             after(grammarAccess.getCodeCallAccess().getCOMMATerminalRuleCall_7_1_0()); 

            }


            }

        }
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
    // InternalXtextTest.g:5869:1: rule__CodeCall__Group_7_1__1 : rule__CodeCall__Group_7_1__1__Impl ;
    public final void rule__CodeCall__Group_7_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5873:1: ( rule__CodeCall__Group_7_1__1__Impl )
            // InternalXtextTest.g:5874:2: rule__CodeCall__Group_7_1__1__Impl
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
    // InternalXtextTest.g:5880:1: rule__CodeCall__Group_7_1__1__Impl : ( ( rule__CodeCall__ParamsAssignment_7_1_1 ) ) ;
    public final void rule__CodeCall__Group_7_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5884:1: ( ( ( rule__CodeCall__ParamsAssignment_7_1_1 ) ) )
            // InternalXtextTest.g:5886:1: ( ( rule__CodeCall__ParamsAssignment_7_1_1 ) )
            {
            // InternalXtextTest.g:5886:1: ( ( rule__CodeCall__ParamsAssignment_7_1_1 ) )
            // InternalXtextTest.g:5887:1: ( rule__CodeCall__ParamsAssignment_7_1_1 )
            {
             before(grammarAccess.getCodeCallAccess().getParamsAssignment_7_1_1()); 
            // InternalXtextTest.g:5888:1: ( rule__CodeCall__ParamsAssignment_7_1_1 )
            // InternalXtextTest.g:5888:2: rule__CodeCall__ParamsAssignment_7_1_1
            {
            pushFollow(FOLLOW_2);
            rule__CodeCall__ParamsAssignment_7_1_1();

            state._fsp--;


            }

             after(grammarAccess.getCodeCallAccess().getParamsAssignment_7_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Model__XtextTestAssignment_1_0"
    // InternalXtextTest.g:5905:1: rule__Model__XtextTestAssignment_1_0 : ( ruleXtextTest ) ;
    public final void rule__Model__XtextTestAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5909:1: ( ( ruleXtextTest ) )
            // InternalXtextTest.g:5910:1: ( ruleXtextTest )
            {
            // InternalXtextTest.g:5910:1: ( ruleXtextTest )
            // InternalXtextTest.g:5911:1: ruleXtextTest
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
    // InternalXtextTest.g:5920:1: rule__Model__EmfTestAssignment_1_1 : ( ruleEmfTest ) ;
    public final void rule__Model__EmfTestAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5924:1: ( ( ruleEmfTest ) )
            // InternalXtextTest.g:5925:1: ( ruleEmfTest )
            {
            // InternalXtextTest.g:5925:1: ( ruleEmfTest )
            // InternalXtextTest.g:5926:1: ruleEmfTest
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
    // InternalXtextTest.g:5935:1: rule__XtextTest__PackageAssignment_2 : ( rulePackageID ) ;
    public final void rule__XtextTest__PackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5939:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:5940:1: ( rulePackageID )
            {
            // InternalXtextTest.g:5940:1: ( rulePackageID )
            // InternalXtextTest.g:5941:1: rulePackageID
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
    // InternalXtextTest.g:5950:1: rule__XtextTest__LangAssignment_4 : ( ruleLangID ) ;
    public final void rule__XtextTest__LangAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5954:1: ( ( ruleLangID ) )
            // InternalXtextTest.g:5955:1: ( ruleLangID )
            {
            // InternalXtextTest.g:5955:1: ( ruleLangID )
            // InternalXtextTest.g:5956:1: ruleLangID
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
    // InternalXtextTest.g:5965:1: rule__XtextTest__ImportsAssignment_5_1 : ( ruleImportID ) ;
    public final void rule__XtextTest__ImportsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5969:1: ( ( ruleImportID ) )
            // InternalXtextTest.g:5970:1: ( ruleImportID )
            {
            // InternalXtextTest.g:5970:1: ( ruleImportID )
            // InternalXtextTest.g:5971:1: ruleImportID
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
    // InternalXtextTest.g:5980:1: rule__XtextTest__BooleanAssignment_6_2 : ( ruleBoolean ) ;
    public final void rule__XtextTest__BooleanAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5984:1: ( ( ruleBoolean ) )
            // InternalXtextTest.g:5985:1: ( ruleBoolean )
            {
            // InternalXtextTest.g:5985:1: ( ruleBoolean )
            // InternalXtextTest.g:5986:1: ruleBoolean
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
    // InternalXtextTest.g:5995:1: rule__XtextTest__InputAssignment_7 : ( ruleInput ) ;
    public final void rule__XtextTest__InputAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:5999:1: ( ( ruleInput ) )
            // InternalXtextTest.g:6000:1: ( ruleInput )
            {
            // InternalXtextTest.g:6000:1: ( ruleInput )
            // InternalXtextTest.g:6001:1: ruleInput
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
    // InternalXtextTest.g:6010:1: rule__XtextTest__TokensAssignment_8 : ( ruleTokens ) ;
    public final void rule__XtextTest__TokensAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6014:1: ( ( ruleTokens ) )
            // InternalXtextTest.g:6015:1: ( ruleTokens )
            {
            // InternalXtextTest.g:6015:1: ( ruleTokens )
            // InternalXtextTest.g:6016:1: ruleTokens
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
    // InternalXtextTest.g:6025:1: rule__XtextTest__RootAssignment_9 : ( ruleElement ) ;
    public final void rule__XtextTest__RootAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6029:1: ( ( ruleElement ) )
            // InternalXtextTest.g:6030:1: ( ruleElement )
            {
            // InternalXtextTest.g:6030:1: ( ruleElement )
            // InternalXtextTest.g:6031:1: ruleElement
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
    // InternalXtextTest.g:6040:1: rule__XtextTest__OutputAssignment_10 : ( ruleGenerator ) ;
    public final void rule__XtextTest__OutputAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6044:1: ( ( ruleGenerator ) )
            // InternalXtextTest.g:6045:1: ( ruleGenerator )
            {
            // InternalXtextTest.g:6045:1: ( ruleGenerator )
            // InternalXtextTest.g:6046:1: ruleGenerator
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
    // InternalXtextTest.g:6055:1: rule__XtextTest__BeforeAssignment_11 : ( ruleBefore ) ;
    public final void rule__XtextTest__BeforeAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6059:1: ( ( ruleBefore ) )
            // InternalXtextTest.g:6060:1: ( ruleBefore )
            {
            // InternalXtextTest.g:6060:1: ( ruleBefore )
            // InternalXtextTest.g:6061:1: ruleBefore
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
    // InternalXtextTest.g:6070:1: rule__XtextTest__AfterAssignment_12 : ( ruleAfter ) ;
    public final void rule__XtextTest__AfterAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6074:1: ( ( ruleAfter ) )
            // InternalXtextTest.g:6075:1: ( ruleAfter )
            {
            // InternalXtextTest.g:6075:1: ( ruleAfter )
            // InternalXtextTest.g:6076:1: ruleAfter
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
    // InternalXtextTest.g:6085:1: rule__EmfTest__PackageAssignment_3 : ( rulePackageID ) ;
    public final void rule__EmfTest__PackageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6089:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6090:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6090:1: ( rulePackageID )
            // InternalXtextTest.g:6091:1: rulePackageID
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
    // InternalXtextTest.g:6100:1: rule__EmfTest__MydefaultAssignment_5 : ( rulePackageID ) ;
    public final void rule__EmfTest__MydefaultAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6104:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6105:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6105:1: ( rulePackageID )
            // InternalXtextTest.g:6106:1: rulePackageID
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
    // InternalXtextTest.g:6115:1: rule__EmfTest__MyimportAssignment_6 : ( ruleImport ) ;
    public final void rule__EmfTest__MyimportAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6119:1: ( ( ruleImport ) )
            // InternalXtextTest.g:6120:1: ( ruleImport )
            {
            // InternalXtextTest.g:6120:1: ( ruleImport )
            // InternalXtextTest.g:6121:1: ruleImport
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
    // InternalXtextTest.g:6130:1: rule__EmfTest__CodeCallAssignment_7 : ( ruleCodeCall ) ;
    public final void rule__EmfTest__CodeCallAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6134:1: ( ( ruleCodeCall ) )
            // InternalXtextTest.g:6135:1: ( ruleCodeCall )
            {
            // InternalXtextTest.g:6135:1: ( ruleCodeCall )
            // InternalXtextTest.g:6136:1: ruleCodeCall
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


    // $ANTLR start "rule__EmfTest__FileAssignment_8_3"
    // InternalXtextTest.g:6145:1: rule__EmfTest__FileAssignment_8_3 : ( RULE_STRING ) ;
    public final void rule__EmfTest__FileAssignment_8_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6149:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6150:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6150:1: ( RULE_STRING )
            // InternalXtextTest.g:6151:1: RULE_STRING
            {
             before(grammarAccess.getEmfTestAccess().getFileSTRINGTerminalRuleCall_8_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getEmfTestAccess().getFileSTRINGTerminalRuleCall_8_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__FileAssignment_8_3"


    // $ANTLR start "rule__EmfTest__RootAssignment_9"
    // InternalXtextTest.g:6160:1: rule__EmfTest__RootAssignment_9 : ( ruleElement ) ;
    public final void rule__EmfTest__RootAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6164:1: ( ( ruleElement ) )
            // InternalXtextTest.g:6165:1: ( ruleElement )
            {
            // InternalXtextTest.g:6165:1: ( ruleElement )
            // InternalXtextTest.g:6166:1: ruleElement
            {
             before(grammarAccess.getEmfTestAccess().getRootElementParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getEmfTestAccess().getRootElementParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EmfTest__RootAssignment_9"


    // $ANTLR start "rule__Import__IdAssignment_2"
    // InternalXtextTest.g:6175:1: rule__Import__IdAssignment_2 : ( ruleImportID ) ;
    public final void rule__Import__IdAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6179:1: ( ( ruleImportID ) )
            // InternalXtextTest.g:6180:1: ( ruleImportID )
            {
            // InternalXtextTest.g:6180:1: ( ruleImportID )
            // InternalXtextTest.g:6181:1: ruleImportID
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
    // InternalXtextTest.g:6190:1: rule__Import__AliasAssignment_4 : ( RULE_IDENTIFIER ) ;
    public final void rule__Import__AliasAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6194:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:6195:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:6195:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:6196:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:6205:1: rule__Input__TextAssignment_2_0_2 : ( RULE_STRING ) ;
    public final void rule__Input__TextAssignment_2_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6209:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6210:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6210:1: ( RULE_STRING )
            // InternalXtextTest.g:6211:1: RULE_STRING
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
    // InternalXtextTest.g:6220:1: rule__Input__FileAssignment_2_1_2 : ( RULE_STRING ) ;
    public final void rule__Input__FileAssignment_2_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6224:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6225:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6225:1: ( RULE_STRING )
            // InternalXtextTest.g:6226:1: RULE_STRING
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
    // InternalXtextTest.g:6235:1: rule__Tokens__TokensAssignment_2 : ( ruleMyTokens ) ;
    public final void rule__Tokens__TokensAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6239:1: ( ( ruleMyTokens ) )
            // InternalXtextTest.g:6240:1: ( ruleMyTokens )
            {
            // InternalXtextTest.g:6240:1: ( ruleMyTokens )
            // InternalXtextTest.g:6241:1: ruleMyTokens
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
    // InternalXtextTest.g:6250:1: rule__MyTokens__TokenAssignment_0 : ( RULE_IDENTIFIER ) ;
    public final void rule__MyTokens__TokenAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6254:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:6255:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:6255:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:6256:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:6265:1: rule__MyTokens__CountAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__MyTokens__CountAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6269:1: ( ( RULE_INT ) )
            // InternalXtextTest.g:6270:1: ( RULE_INT )
            {
            // InternalXtextTest.g:6270:1: ( RULE_INT )
            // InternalXtextTest.g:6271:1: RULE_INT
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
    // InternalXtextTest.g:6280:1: rule__Element__ImportingAssignment_2_0 : ( RULE_IDENTIFIER ) ;
    public final void rule__Element__ImportingAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6284:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:6285:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:6285:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:6286:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:6295:1: rule__Element__NameAssignment_3 : ( RULE_IDENTIFIER ) ;
    public final void rule__Element__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6299:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:6300:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:6300:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:6301:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:6310:1: rule__Element__InnerAssignment_4_0 : ( ruleInner ) ;
    public final void rule__Element__InnerAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6314:1: ( ( ruleInner ) )
            // InternalXtextTest.g:6315:1: ( ruleInner )
            {
            // InternalXtextTest.g:6315:1: ( ruleInner )
            // InternalXtextTest.g:6316:1: ruleInner
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
    // InternalXtextTest.g:6325:1: rule__Element__InnerAssignment_4_1_1 : ( ruleInner ) ;
    public final void rule__Element__InnerAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6329:1: ( ( ruleInner ) )
            // InternalXtextTest.g:6330:1: ( ruleInner )
            {
            // InternalXtextTest.g:6330:1: ( ruleInner )
            // InternalXtextTest.g:6331:1: ruleInner
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
    // InternalXtextTest.g:6340:1: rule__Inner__ParameterAssignment_1 : ( RULE_IDENTIFIER ) ;
    public final void rule__Inner__ParameterAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6344:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:6345:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:6345:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:6346:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:6355:1: rule__Inner__AssignAssignment_2_0_1 : ( ruleElement ) ;
    public final void rule__Inner__AssignAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6359:1: ( ( ruleElement ) )
            // InternalXtextTest.g:6360:1: ( ruleElement )
            {
            // InternalXtextTest.g:6360:1: ( ruleElement )
            // InternalXtextTest.g:6361:1: ruleElement
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
    // InternalXtextTest.g:6370:1: rule__Inner__AssignListAssignment_2_1_1 : ( ruleElement ) ;
    public final void rule__Inner__AssignListAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6374:1: ( ( ruleElement ) )
            // InternalXtextTest.g:6375:1: ( ruleElement )
            {
            // InternalXtextTest.g:6375:1: ( ruleElement )
            // InternalXtextTest.g:6376:1: ruleElement
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
    // InternalXtextTest.g:6385:1: rule__Inner__AssignListAssignment_2_1_2_1 : ( ruleElement ) ;
    public final void rule__Inner__AssignListAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6389:1: ( ( ruleElement ) )
            // InternalXtextTest.g:6390:1: ( ruleElement )
            {
            // InternalXtextTest.g:6390:1: ( ruleElement )
            // InternalXtextTest.g:6391:1: ruleElement
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
    // InternalXtextTest.g:6400:1: rule__Inner__ValueAssignment_2_2_1 : ( RULE_STRING ) ;
    public final void rule__Inner__ValueAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6404:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6405:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6405:1: ( RULE_STRING )
            // InternalXtextTest.g:6406:1: RULE_STRING
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
    // InternalXtextTest.g:6415:1: rule__Inner__AssignAsDataAssignment_2_3_1 : ( RULE_STRING ) ;
    public final void rule__Inner__AssignAsDataAssignment_2_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6419:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6420:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6420:1: ( RULE_STRING )
            // InternalXtextTest.g:6421:1: RULE_STRING
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
    // InternalXtextTest.g:6430:1: rule__Inner__AssignAsBoolAssignment_2_4_1 : ( ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 ) ) ;
    public final void rule__Inner__AssignAsBoolAssignment_2_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6434:1: ( ( ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 ) ) )
            // InternalXtextTest.g:6435:1: ( ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 ) )
            {
            // InternalXtextTest.g:6435:1: ( ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 ) )
            // InternalXtextTest.g:6436:1: ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 )
            {
             before(grammarAccess.getInnerAccess().getAssignAsBoolAlternatives_2_4_1_0()); 
            // InternalXtextTest.g:6437:1: ( rule__Inner__AssignAsBoolAlternatives_2_4_1_0 )
            // InternalXtextTest.g:6437:2: rule__Inner__AssignAsBoolAlternatives_2_4_1_0
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
    // InternalXtextTest.g:6446:1: rule__Inner__IsNullAssignment_2_5 : ( RULE_ISNULL ) ;
    public final void rule__Inner__IsNullAssignment_2_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6450:1: ( ( RULE_ISNULL ) )
            // InternalXtextTest.g:6451:1: ( RULE_ISNULL )
            {
            // InternalXtextTest.g:6451:1: ( RULE_ISNULL )
            // InternalXtextTest.g:6452:1: RULE_ISNULL
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
    // InternalXtextTest.g:6461:1: rule__Inner__IsNotNullAssignment_2_6 : ( RULE_ISNOTNULL ) ;
    public final void rule__Inner__IsNotNullAssignment_2_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6465:1: ( ( RULE_ISNOTNULL ) )
            // InternalXtextTest.g:6466:1: ( RULE_ISNOTNULL )
            {
            // InternalXtextTest.g:6466:1: ( RULE_ISNOTNULL )
            // InternalXtextTest.g:6467:1: RULE_ISNOTNULL
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


    // $ANTLR start "rule__Generator__OutputAssignment_1_3"
    // InternalXtextTest.g:6476:1: rule__Generator__OutputAssignment_1_3 : ( RULE_STRING ) ;
    public final void rule__Generator__OutputAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6480:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6481:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6481:1: ( RULE_STRING )
            // InternalXtextTest.g:6482:1: RULE_STRING
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
    // InternalXtextTest.g:6491:1: rule__Generator__ExpectedAssignment_2_2_0_1 : ( RULE_STRING ) ;
    public final void rule__Generator__ExpectedAssignment_2_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6495:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6496:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6496:1: ( RULE_STRING )
            // InternalXtextTest.g:6497:1: RULE_STRING
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
    // InternalXtextTest.g:6506:1: rule__Generator__IsSameAsInputFileAssignment_2_2_1 : ( RULE_ISSAMEASINPUTFILE ) ;
    public final void rule__Generator__IsSameAsInputFileAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6510:1: ( ( RULE_ISSAMEASINPUTFILE ) )
            // InternalXtextTest.g:6511:1: ( RULE_ISSAMEASINPUTFILE )
            {
            // InternalXtextTest.g:6511:1: ( RULE_ISSAMEASINPUTFILE )
            // InternalXtextTest.g:6512:1: RULE_ISSAMEASINPUTFILE
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
    // InternalXtextTest.g:6521:1: rule__Generator__PatternFileAssignment_3_1_2 : ( RULE_STRING ) ;
    public final void rule__Generator__PatternFileAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6525:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6526:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6526:1: ( RULE_STRING )
            // InternalXtextTest.g:6527:1: RULE_STRING
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
    // InternalXtextTest.g:6536:1: rule__Generator__ReplacePatternsAssignment_3_2 : ( ruleReplacePatterns ) ;
    public final void rule__Generator__ReplacePatternsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6540:1: ( ( ruleReplacePatterns ) )
            // InternalXtextTest.g:6541:1: ( ruleReplacePatterns )
            {
            // InternalXtextTest.g:6541:1: ( ruleReplacePatterns )
            // InternalXtextTest.g:6542:1: ruleReplacePatterns
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
    // InternalXtextTest.g:6551:1: rule__Generator__ExceptionAssignment_4_2 : ( rulePackageID ) ;
    public final void rule__Generator__ExceptionAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6555:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6556:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6556:1: ( rulePackageID )
            // InternalXtextTest.g:6557:1: rulePackageID
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
    // InternalXtextTest.g:6566:1: rule__ReplacePatterns__RegexAssignment_0 : ( RULE_STRING ) ;
    public final void rule__ReplacePatterns__RegexAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6570:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6571:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6571:1: ( RULE_STRING )
            // InternalXtextTest.g:6572:1: RULE_STRING
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
    // InternalXtextTest.g:6581:1: rule__ReplacePatterns__ReplaceAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ReplacePatterns__ReplaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6585:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:6586:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:6586:1: ( RULE_STRING )
            // InternalXtextTest.g:6587:1: RULE_STRING
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
    // InternalXtextTest.g:6596:1: rule__Before__MyclassAssignment_3 : ( rulePackageID ) ;
    public final void rule__Before__MyclassAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6600:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6601:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6601:1: ( rulePackageID )
            // InternalXtextTest.g:6602:1: rulePackageID
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
    // InternalXtextTest.g:6611:1: rule__Before__MethodAssignment_6 : ( rulePackageID ) ;
    public final void rule__Before__MethodAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6615:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6616:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6616:1: ( rulePackageID )
            // InternalXtextTest.g:6617:1: rulePackageID
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
    // InternalXtextTest.g:6626:1: rule__After__MyclassAssignment_3 : ( rulePackageID ) ;
    public final void rule__After__MyclassAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6630:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6631:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6631:1: ( rulePackageID )
            // InternalXtextTest.g:6632:1: rulePackageID
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
    // InternalXtextTest.g:6641:1: rule__After__MethodAssignment_6 : ( rulePackageID ) ;
    public final void rule__After__MethodAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6645:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6646:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6646:1: ( rulePackageID )
            // InternalXtextTest.g:6647:1: rulePackageID
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
    // InternalXtextTest.g:6656:1: rule__CodeCall__MyclassAssignment_2 : ( rulePackageID ) ;
    public final void rule__CodeCall__MyclassAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6660:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6661:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6661:1: ( rulePackageID )
            // InternalXtextTest.g:6662:1: rulePackageID
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
    // InternalXtextTest.g:6671:1: rule__CodeCall__MethodAssignment_5 : ( rulePackageID ) ;
    public final void rule__CodeCall__MethodAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6675:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6676:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6676:1: ( rulePackageID )
            // InternalXtextTest.g:6677:1: rulePackageID
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


    // $ANTLR start "rule__CodeCall__ParamsAssignment_7_0"
    // InternalXtextTest.g:6686:1: rule__CodeCall__ParamsAssignment_7_0 : ( rulePackageID ) ;
    public final void rule__CodeCall__ParamsAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6690:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6691:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6691:1: ( rulePackageID )
            // InternalXtextTest.g:6692:1: rulePackageID
            {
             before(grammarAccess.getCodeCallAccess().getParamsPackageIDParserRuleCall_7_0_0()); 
            pushFollow(FOLLOW_2);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getCodeCallAccess().getParamsPackageIDParserRuleCall_7_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__ParamsAssignment_7_0"


    // $ANTLR start "rule__CodeCall__ParamsAssignment_7_1_1"
    // InternalXtextTest.g:6701:1: rule__CodeCall__ParamsAssignment_7_1_1 : ( rulePackageID ) ;
    public final void rule__CodeCall__ParamsAssignment_7_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:6705:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:6706:1: ( rulePackageID )
            {
            // InternalXtextTest.g:6706:1: ( rulePackageID )
            // InternalXtextTest.g:6707:1: rulePackageID
            {
             before(grammarAccess.getCodeCallAccess().getParamsPackageIDParserRuleCall_7_1_1_0()); 
            pushFollow(FOLLOW_2);
            rulePackageID();

            state._fsp--;

             after(grammarAccess.getCodeCallAccess().getParamsPackageIDParserRuleCall_7_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeCall__ParamsAssignment_7_1_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001080L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004600L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000910000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000200000200L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x000000C00E100800L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000010000000800L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000001000008000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000400000L});

}