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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_IDENTIFIER", "RULE_PACKAGE", "RULE_LANGUAGE", "RULE_SPLITLEXER", "RULE_ASSIGNASSINGLE", "RULE_POINT", "RULE_SOURCE", "RULE_SRCTEXT", "RULE_FILE", "RULE_LEXER", "RULE_ASSIGNASDATALIST", "RULE_LEFTPAREN", "RULE_RIGHTPAREN", "RULE_COMMA", "RULE_ASSIGNASLIST", "RULE_ASSIGNASSTRING", "RULE_OUTPUT", "RULE_EXPECTED", "RULE_PATTERNS", "RULE_EXCEPTIONS", "RULE_BEFORE_KW", "RULE_CLASS_KW", "RULE_METHOD_KW", "RULE_AFTER_KW", "RULE_STRING", "RULE_INT", "RULE_ISSAMEASINPUTFILE", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'"
    };
    public static final int RULE_ID=31;
    public static final int RULE_SRCTEXT=11;
    public static final int RULE_RIGHTPAREN=16;
    public static final int RULE_METHOD_KW=26;
    public static final int RULE_PATTERNS=22;
    public static final int RULE_ASSIGNASDATALIST=14;
    public static final int RULE_ANY_OTHER=35;
    public static final int RULE_SPLITLEXER=7;
    public static final int RULE_LANGUAGE=6;
    public static final int RULE_EXPECTED=21;
    public static final int RULE_FILE=12;
    public static final int RULE_COMMA=17;
    public static final int RULE_IDENTIFIER=4;
    public static final int RULE_AFTER_KW=27;
    public static final int RULE_SL_COMMENT=33;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=32;
    public static final int RULE_BEFORE_KW=24;
    public static final int RULE_STRING=28;
    public static final int RULE_PACKAGE=5;
    public static final int RULE_SOURCE=10;
    public static final int RULE_LEFTPAREN=15;
    public static final int RULE_ASSIGNASSINGLE=8;
    public static final int RULE_ASSIGNASLIST=18;
    public static final int T__36=36;
    public static final int RULE_EXCEPTIONS=23;
    public static final int T__37=37;
    public static final int RULE_POINT=9;
    public static final int RULE_LEXER=13;
    public static final int RULE_OUTPUT=20;
    public static final int RULE_INT=29;
    public static final int RULE_CLASS_KW=25;
    public static final int RULE_ASSIGNASSTRING=19;
    public static final int RULE_WS=34;
    public static final int RULE_ISSAMEASINPUTFILE=30;

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




    // $ANTLR start "entryRuleXtextTest"
    // InternalXtextTest.g:61:1: entryRuleXtextTest : ruleXtextTest EOF ;
    public final void entryRuleXtextTest() throws RecognitionException {
        try {
            // InternalXtextTest.g:62:1: ( ruleXtextTest EOF )
            // InternalXtextTest.g:63:1: ruleXtextTest EOF
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
    // InternalXtextTest.g:70:1: ruleXtextTest : ( ( rule__XtextTest__Group__0 ) ) ;
    public final void ruleXtextTest() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:77:7: ( ( ( rule__XtextTest__Group__0 ) ) )
            // InternalXtextTest.g:79:1: ( ( rule__XtextTest__Group__0 ) )
            {
            // InternalXtextTest.g:79:1: ( ( rule__XtextTest__Group__0 ) )
            // InternalXtextTest.g:80:1: ( rule__XtextTest__Group__0 )
            {
             before(grammarAccess.getXtextTestAccess().getGroup()); 
            // InternalXtextTest.g:81:1: ( rule__XtextTest__Group__0 )
            // InternalXtextTest.g:81:2: rule__XtextTest__Group__0
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


    // $ANTLR start "entryRuleBoolean"
    // InternalXtextTest.g:95:1: entryRuleBoolean : ruleBoolean EOF ;
    public final void entryRuleBoolean() throws RecognitionException {
        try {
            // InternalXtextTest.g:96:1: ( ruleBoolean EOF )
            // InternalXtextTest.g:97:1: ruleBoolean EOF
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
    // InternalXtextTest.g:104:1: ruleBoolean : ( ( rule__Boolean__Alternatives ) ) ;
    public final void ruleBoolean() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:111:7: ( ( ( rule__Boolean__Alternatives ) ) )
            // InternalXtextTest.g:113:1: ( ( rule__Boolean__Alternatives ) )
            {
            // InternalXtextTest.g:113:1: ( ( rule__Boolean__Alternatives ) )
            // InternalXtextTest.g:114:1: ( rule__Boolean__Alternatives )
            {
             before(grammarAccess.getBooleanAccess().getAlternatives()); 
            // InternalXtextTest.g:115:1: ( rule__Boolean__Alternatives )
            // InternalXtextTest.g:115:2: rule__Boolean__Alternatives
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
    // InternalXtextTest.g:129:1: entryRulePackageID : rulePackageID EOF ;
    public final void entryRulePackageID() throws RecognitionException {
        try {
            // InternalXtextTest.g:130:1: ( rulePackageID EOF )
            // InternalXtextTest.g:131:1: rulePackageID EOF
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
    // InternalXtextTest.g:138:1: rulePackageID : ( ( rule__PackageID__Group__0 ) ) ;
    public final void rulePackageID() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:145:7: ( ( ( rule__PackageID__Group__0 ) ) )
            // InternalXtextTest.g:147:1: ( ( rule__PackageID__Group__0 ) )
            {
            // InternalXtextTest.g:147:1: ( ( rule__PackageID__Group__0 ) )
            // InternalXtextTest.g:148:1: ( rule__PackageID__Group__0 )
            {
             before(grammarAccess.getPackageIDAccess().getGroup()); 
            // InternalXtextTest.g:149:1: ( rule__PackageID__Group__0 )
            // InternalXtextTest.g:149:2: rule__PackageID__Group__0
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
    // InternalXtextTest.g:163:1: entryRuleLangID : ruleLangID EOF ;
    public final void entryRuleLangID() throws RecognitionException {
        try {
            // InternalXtextTest.g:164:1: ( ruleLangID EOF )
            // InternalXtextTest.g:165:1: ruleLangID EOF
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
    // InternalXtextTest.g:172:1: ruleLangID : ( RULE_IDENTIFIER ) ;
    public final void ruleLangID() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:179:7: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:181:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:181:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:182:1: RULE_IDENTIFIER
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


    // $ANTLR start "entryRuleInput"
    // InternalXtextTest.g:197:1: entryRuleInput : ruleInput EOF ;
    public final void entryRuleInput() throws RecognitionException {
        try {
            // InternalXtextTest.g:198:1: ( ruleInput EOF )
            // InternalXtextTest.g:199:1: ruleInput EOF
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
    // InternalXtextTest.g:206:1: ruleInput : ( ( rule__Input__Group__0 ) ) ;
    public final void ruleInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:213:7: ( ( ( rule__Input__Group__0 ) ) )
            // InternalXtextTest.g:215:1: ( ( rule__Input__Group__0 ) )
            {
            // InternalXtextTest.g:215:1: ( ( rule__Input__Group__0 ) )
            // InternalXtextTest.g:216:1: ( rule__Input__Group__0 )
            {
             before(grammarAccess.getInputAccess().getGroup()); 
            // InternalXtextTest.g:217:1: ( rule__Input__Group__0 )
            // InternalXtextTest.g:217:2: rule__Input__Group__0
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
    // InternalXtextTest.g:231:1: entryRuleTokens : ruleTokens EOF ;
    public final void entryRuleTokens() throws RecognitionException {
        try {
            // InternalXtextTest.g:232:1: ( ruleTokens EOF )
            // InternalXtextTest.g:233:1: ruleTokens EOF
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
    // InternalXtextTest.g:240:1: ruleTokens : ( ( rule__Tokens__Group__0 ) ) ;
    public final void ruleTokens() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:247:7: ( ( ( rule__Tokens__Group__0 ) ) )
            // InternalXtextTest.g:249:1: ( ( rule__Tokens__Group__0 ) )
            {
            // InternalXtextTest.g:249:1: ( ( rule__Tokens__Group__0 ) )
            // InternalXtextTest.g:250:1: ( rule__Tokens__Group__0 )
            {
             before(grammarAccess.getTokensAccess().getGroup()); 
            // InternalXtextTest.g:251:1: ( rule__Tokens__Group__0 )
            // InternalXtextTest.g:251:2: rule__Tokens__Group__0
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
    // InternalXtextTest.g:265:1: entryRuleMyTokens : ruleMyTokens EOF ;
    public final void entryRuleMyTokens() throws RecognitionException {
        try {
            // InternalXtextTest.g:266:1: ( ruleMyTokens EOF )
            // InternalXtextTest.g:267:1: ruleMyTokens EOF
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
    // InternalXtextTest.g:274:1: ruleMyTokens : ( ( rule__MyTokens__Group__0 ) ) ;
    public final void ruleMyTokens() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:281:7: ( ( ( rule__MyTokens__Group__0 ) ) )
            // InternalXtextTest.g:283:1: ( ( rule__MyTokens__Group__0 ) )
            {
            // InternalXtextTest.g:283:1: ( ( rule__MyTokens__Group__0 ) )
            // InternalXtextTest.g:284:1: ( rule__MyTokens__Group__0 )
            {
             before(grammarAccess.getMyTokensAccess().getGroup()); 
            // InternalXtextTest.g:285:1: ( rule__MyTokens__Group__0 )
            // InternalXtextTest.g:285:2: rule__MyTokens__Group__0
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
    // InternalXtextTest.g:299:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalXtextTest.g:300:1: ( ruleElement EOF )
            // InternalXtextTest.g:301:1: ruleElement EOF
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
    // InternalXtextTest.g:308:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:315:7: ( ( ( rule__Element__Group__0 ) ) )
            // InternalXtextTest.g:317:1: ( ( rule__Element__Group__0 ) )
            {
            // InternalXtextTest.g:317:1: ( ( rule__Element__Group__0 ) )
            // InternalXtextTest.g:318:1: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // InternalXtextTest.g:319:1: ( rule__Element__Group__0 )
            // InternalXtextTest.g:319:2: rule__Element__Group__0
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
    // InternalXtextTest.g:333:1: entryRuleInner : ruleInner EOF ;
    public final void entryRuleInner() throws RecognitionException {
        try {
            // InternalXtextTest.g:334:1: ( ruleInner EOF )
            // InternalXtextTest.g:335:1: ruleInner EOF
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
    // InternalXtextTest.g:342:1: ruleInner : ( ( rule__Inner__Group__0 ) ) ;
    public final void ruleInner() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:349:7: ( ( ( rule__Inner__Group__0 ) ) )
            // InternalXtextTest.g:351:1: ( ( rule__Inner__Group__0 ) )
            {
            // InternalXtextTest.g:351:1: ( ( rule__Inner__Group__0 ) )
            // InternalXtextTest.g:352:1: ( rule__Inner__Group__0 )
            {
             before(grammarAccess.getInnerAccess().getGroup()); 
            // InternalXtextTest.g:353:1: ( rule__Inner__Group__0 )
            // InternalXtextTest.g:353:2: rule__Inner__Group__0
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
    // InternalXtextTest.g:367:1: entryRuleGenerator : ruleGenerator EOF ;
    public final void entryRuleGenerator() throws RecognitionException {
        try {
            // InternalXtextTest.g:368:1: ( ruleGenerator EOF )
            // InternalXtextTest.g:369:1: ruleGenerator EOF
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
    // InternalXtextTest.g:376:1: ruleGenerator : ( ( rule__Generator__Group__0 ) ) ;
    public final void ruleGenerator() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:383:7: ( ( ( rule__Generator__Group__0 ) ) )
            // InternalXtextTest.g:385:1: ( ( rule__Generator__Group__0 ) )
            {
            // InternalXtextTest.g:385:1: ( ( rule__Generator__Group__0 ) )
            // InternalXtextTest.g:386:1: ( rule__Generator__Group__0 )
            {
             before(grammarAccess.getGeneratorAccess().getGroup()); 
            // InternalXtextTest.g:387:1: ( rule__Generator__Group__0 )
            // InternalXtextTest.g:387:2: rule__Generator__Group__0
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
    // InternalXtextTest.g:401:1: entryRuleReplacePatterns : ruleReplacePatterns EOF ;
    public final void entryRuleReplacePatterns() throws RecognitionException {
        try {
            // InternalXtextTest.g:402:1: ( ruleReplacePatterns EOF )
            // InternalXtextTest.g:403:1: ruleReplacePatterns EOF
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
    // InternalXtextTest.g:410:1: ruleReplacePatterns : ( ( rule__ReplacePatterns__Group__0 ) ) ;
    public final void ruleReplacePatterns() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:417:7: ( ( ( rule__ReplacePatterns__Group__0 ) ) )
            // InternalXtextTest.g:419:1: ( ( rule__ReplacePatterns__Group__0 ) )
            {
            // InternalXtextTest.g:419:1: ( ( rule__ReplacePatterns__Group__0 ) )
            // InternalXtextTest.g:420:1: ( rule__ReplacePatterns__Group__0 )
            {
             before(grammarAccess.getReplacePatternsAccess().getGroup()); 
            // InternalXtextTest.g:421:1: ( rule__ReplacePatterns__Group__0 )
            // InternalXtextTest.g:421:2: rule__ReplacePatterns__Group__0
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
    // InternalXtextTest.g:435:1: entryRuleBefore : ruleBefore EOF ;
    public final void entryRuleBefore() throws RecognitionException {
        try {
            // InternalXtextTest.g:436:1: ( ruleBefore EOF )
            // InternalXtextTest.g:437:1: ruleBefore EOF
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
    // InternalXtextTest.g:444:1: ruleBefore : ( ( rule__Before__Group__0 ) ) ;
    public final void ruleBefore() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:451:7: ( ( ( rule__Before__Group__0 ) ) )
            // InternalXtextTest.g:453:1: ( ( rule__Before__Group__0 ) )
            {
            // InternalXtextTest.g:453:1: ( ( rule__Before__Group__0 ) )
            // InternalXtextTest.g:454:1: ( rule__Before__Group__0 )
            {
             before(grammarAccess.getBeforeAccess().getGroup()); 
            // InternalXtextTest.g:455:1: ( rule__Before__Group__0 )
            // InternalXtextTest.g:455:2: rule__Before__Group__0
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
    // InternalXtextTest.g:469:1: entryRuleAfter : ruleAfter EOF ;
    public final void entryRuleAfter() throws RecognitionException {
        try {
            // InternalXtextTest.g:470:1: ( ruleAfter EOF )
            // InternalXtextTest.g:471:1: ruleAfter EOF
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
    // InternalXtextTest.g:478:1: ruleAfter : ( ( rule__After__Group__0 ) ) ;
    public final void ruleAfter() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalXtextTest.g:485:7: ( ( ( rule__After__Group__0 ) ) )
            // InternalXtextTest.g:487:1: ( ( rule__After__Group__0 ) )
            {
            // InternalXtextTest.g:487:1: ( ( rule__After__Group__0 ) )
            // InternalXtextTest.g:488:1: ( rule__After__Group__0 )
            {
             before(grammarAccess.getAfterAccess().getGroup()); 
            // InternalXtextTest.g:489:1: ( rule__After__Group__0 )
            // InternalXtextTest.g:489:2: rule__After__Group__0
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


    // $ANTLR start "rule__Boolean__Alternatives"
    // InternalXtextTest.g:503:1: rule__Boolean__Alternatives : ( ( 'true' ) | ( 'false' ) );
    public final void rule__Boolean__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:507:1: ( ( 'true' ) | ( 'false' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==36) ) {
                alt1=1;
            }
            else if ( (LA1_0==37) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalXtextTest.g:509:1: ( 'true' )
                    {
                    // InternalXtextTest.g:509:1: ( 'true' )
                    // InternalXtextTest.g:510:1: 'true'
                    {
                     before(grammarAccess.getBooleanAccess().getTrueKeyword_0()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getBooleanAccess().getTrueKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:520:1: ( 'false' )
                    {
                    // InternalXtextTest.g:520:1: ( 'false' )
                    // InternalXtextTest.g:521:1: 'false'
                    {
                     before(grammarAccess.getBooleanAccess().getFalseKeyword_1()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getBooleanAccess().getFalseKeyword_1()); 

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
    // InternalXtextTest.g:535:1: rule__Input__Alternatives_2 : ( ( ( rule__Input__Group_2_0__0 ) ) | ( ( rule__Input__Group_2_1__0 ) ) );
    public final void rule__Input__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:539:1: ( ( ( rule__Input__Group_2_0__0 ) ) | ( ( rule__Input__Group_2_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_SRCTEXT) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_FILE) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalXtextTest.g:541:1: ( ( rule__Input__Group_2_0__0 ) )
                    {
                    // InternalXtextTest.g:541:1: ( ( rule__Input__Group_2_0__0 ) )
                    // InternalXtextTest.g:542:1: ( rule__Input__Group_2_0__0 )
                    {
                     before(grammarAccess.getInputAccess().getGroup_2_0()); 
                    // InternalXtextTest.g:543:1: ( rule__Input__Group_2_0__0 )
                    // InternalXtextTest.g:543:2: rule__Input__Group_2_0__0
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
                    // InternalXtextTest.g:550:1: ( ( rule__Input__Group_2_1__0 ) )
                    {
                    // InternalXtextTest.g:550:1: ( ( rule__Input__Group_2_1__0 ) )
                    // InternalXtextTest.g:551:1: ( rule__Input__Group_2_1__0 )
                    {
                     before(grammarAccess.getInputAccess().getGroup_2_1()); 
                    // InternalXtextTest.g:552:1: ( rule__Input__Group_2_1__0 )
                    // InternalXtextTest.g:552:2: rule__Input__Group_2_1__0
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
    // InternalXtextTest.g:563:1: rule__Inner__Alternatives_2 : ( ( ( rule__Inner__Group_2_0__0 ) ) | ( ( rule__Inner__Group_2_1__0 ) ) | ( ( rule__Inner__Group_2_2__0 ) ) | ( ( rule__Inner__Group_2_3__0 ) ) );
    public final void rule__Inner__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:567:1: ( ( ( rule__Inner__Group_2_0__0 ) ) | ( ( rule__Inner__Group_2_1__0 ) ) | ( ( rule__Inner__Group_2_2__0 ) ) | ( ( rule__Inner__Group_2_3__0 ) ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case RULE_ASSIGNASSINGLE:
                {
                alt3=1;
                }
                break;
            case RULE_ASSIGNASLIST:
                {
                alt3=2;
                }
                break;
            case RULE_ASSIGNASSTRING:
                {
                alt3=3;
                }
                break;
            case RULE_ASSIGNASDATALIST:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalXtextTest.g:569:1: ( ( rule__Inner__Group_2_0__0 ) )
                    {
                    // InternalXtextTest.g:569:1: ( ( rule__Inner__Group_2_0__0 ) )
                    // InternalXtextTest.g:570:1: ( rule__Inner__Group_2_0__0 )
                    {
                     before(grammarAccess.getInnerAccess().getGroup_2_0()); 
                    // InternalXtextTest.g:571:1: ( rule__Inner__Group_2_0__0 )
                    // InternalXtextTest.g:571:2: rule__Inner__Group_2_0__0
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
                    // InternalXtextTest.g:578:1: ( ( rule__Inner__Group_2_1__0 ) )
                    {
                    // InternalXtextTest.g:578:1: ( ( rule__Inner__Group_2_1__0 ) )
                    // InternalXtextTest.g:579:1: ( rule__Inner__Group_2_1__0 )
                    {
                     before(grammarAccess.getInnerAccess().getGroup_2_1()); 
                    // InternalXtextTest.g:580:1: ( rule__Inner__Group_2_1__0 )
                    // InternalXtextTest.g:580:2: rule__Inner__Group_2_1__0
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
                    // InternalXtextTest.g:587:1: ( ( rule__Inner__Group_2_2__0 ) )
                    {
                    // InternalXtextTest.g:587:1: ( ( rule__Inner__Group_2_2__0 ) )
                    // InternalXtextTest.g:588:1: ( rule__Inner__Group_2_2__0 )
                    {
                     before(grammarAccess.getInnerAccess().getGroup_2_2()); 
                    // InternalXtextTest.g:589:1: ( rule__Inner__Group_2_2__0 )
                    // InternalXtextTest.g:589:2: rule__Inner__Group_2_2__0
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
                    // InternalXtextTest.g:596:1: ( ( rule__Inner__Group_2_3__0 ) )
                    {
                    // InternalXtextTest.g:596:1: ( ( rule__Inner__Group_2_3__0 ) )
                    // InternalXtextTest.g:597:1: ( rule__Inner__Group_2_3__0 )
                    {
                     before(grammarAccess.getInnerAccess().getGroup_2_3()); 
                    // InternalXtextTest.g:598:1: ( rule__Inner__Group_2_3__0 )
                    // InternalXtextTest.g:598:2: rule__Inner__Group_2_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Inner__Group_2_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInnerAccess().getGroup_2_3()); 

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


    // $ANTLR start "rule__Generator__Alternatives_2_2"
    // InternalXtextTest.g:609:1: rule__Generator__Alternatives_2_2 : ( ( ( rule__Generator__Group_2_2_0__0 ) ) | ( ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 ) ) );
    public final void rule__Generator__Alternatives_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:613:1: ( ( ( rule__Generator__Group_2_2_0__0 ) ) | ( ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ASSIGNASSINGLE) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_ISSAMEASINPUTFILE) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalXtextTest.g:615:1: ( ( rule__Generator__Group_2_2_0__0 ) )
                    {
                    // InternalXtextTest.g:615:1: ( ( rule__Generator__Group_2_2_0__0 ) )
                    // InternalXtextTest.g:616:1: ( rule__Generator__Group_2_2_0__0 )
                    {
                     before(grammarAccess.getGeneratorAccess().getGroup_2_2_0()); 
                    // InternalXtextTest.g:617:1: ( rule__Generator__Group_2_2_0__0 )
                    // InternalXtextTest.g:617:2: rule__Generator__Group_2_2_0__0
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
                    // InternalXtextTest.g:624:1: ( ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 ) )
                    {
                    // InternalXtextTest.g:624:1: ( ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 ) )
                    // InternalXtextTest.g:625:1: ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 )
                    {
                     before(grammarAccess.getGeneratorAccess().getIsSameAsInputFileAssignment_2_2_1()); 
                    // InternalXtextTest.g:626:1: ( rule__Generator__IsSameAsInputFileAssignment_2_2_1 )
                    // InternalXtextTest.g:626:2: rule__Generator__IsSameAsInputFileAssignment_2_2_1
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


    // $ANTLR start "rule__XtextTest__Group__0"
    // InternalXtextTest.g:639:1: rule__XtextTest__Group__0 : rule__XtextTest__Group__0__Impl rule__XtextTest__Group__1 ;
    public final void rule__XtextTest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:643:1: ( rule__XtextTest__Group__0__Impl rule__XtextTest__Group__1 )
            // InternalXtextTest.g:644:2: rule__XtextTest__Group__0__Impl rule__XtextTest__Group__1
            {
            pushFollow(FOLLOW_3);
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
    // InternalXtextTest.g:651:1: rule__XtextTest__Group__0__Impl : ( () ) ;
    public final void rule__XtextTest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:655:1: ( ( () ) )
            // InternalXtextTest.g:657:1: ( () )
            {
            // InternalXtextTest.g:657:1: ( () )
            // InternalXtextTest.g:658:1: ()
            {
             before(grammarAccess.getXtextTestAccess().getXtextTestAction_0()); 
            // InternalXtextTest.g:659:1: ()
            // InternalXtextTest.g:661:1: 
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
    // InternalXtextTest.g:673:1: rule__XtextTest__Group__1 : rule__XtextTest__Group__1__Impl rule__XtextTest__Group__2 ;
    public final void rule__XtextTest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:677:1: ( rule__XtextTest__Group__1__Impl rule__XtextTest__Group__2 )
            // InternalXtextTest.g:678:2: rule__XtextTest__Group__1__Impl rule__XtextTest__Group__2
            {
            pushFollow(FOLLOW_4);
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
    // InternalXtextTest.g:685:1: rule__XtextTest__Group__1__Impl : ( RULE_PACKAGE ) ;
    public final void rule__XtextTest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:689:1: ( ( RULE_PACKAGE ) )
            // InternalXtextTest.g:691:1: ( RULE_PACKAGE )
            {
            // InternalXtextTest.g:691:1: ( RULE_PACKAGE )
            // InternalXtextTest.g:692:1: RULE_PACKAGE
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
    // InternalXtextTest.g:705:1: rule__XtextTest__Group__2 : rule__XtextTest__Group__2__Impl rule__XtextTest__Group__3 ;
    public final void rule__XtextTest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:709:1: ( rule__XtextTest__Group__2__Impl rule__XtextTest__Group__3 )
            // InternalXtextTest.g:710:2: rule__XtextTest__Group__2__Impl rule__XtextTest__Group__3
            {
            pushFollow(FOLLOW_5);
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
    // InternalXtextTest.g:717:1: rule__XtextTest__Group__2__Impl : ( ( rule__XtextTest__PackageAssignment_2 ) ) ;
    public final void rule__XtextTest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:721:1: ( ( ( rule__XtextTest__PackageAssignment_2 ) ) )
            // InternalXtextTest.g:723:1: ( ( rule__XtextTest__PackageAssignment_2 ) )
            {
            // InternalXtextTest.g:723:1: ( ( rule__XtextTest__PackageAssignment_2 ) )
            // InternalXtextTest.g:724:1: ( rule__XtextTest__PackageAssignment_2 )
            {
             before(grammarAccess.getXtextTestAccess().getPackageAssignment_2()); 
            // InternalXtextTest.g:725:1: ( rule__XtextTest__PackageAssignment_2 )
            // InternalXtextTest.g:725:2: rule__XtextTest__PackageAssignment_2
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
    // InternalXtextTest.g:737:1: rule__XtextTest__Group__3 : rule__XtextTest__Group__3__Impl rule__XtextTest__Group__4 ;
    public final void rule__XtextTest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:741:1: ( rule__XtextTest__Group__3__Impl rule__XtextTest__Group__4 )
            // InternalXtextTest.g:742:2: rule__XtextTest__Group__3__Impl rule__XtextTest__Group__4
            {
            pushFollow(FOLLOW_4);
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
    // InternalXtextTest.g:749:1: rule__XtextTest__Group__3__Impl : ( RULE_LANGUAGE ) ;
    public final void rule__XtextTest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:753:1: ( ( RULE_LANGUAGE ) )
            // InternalXtextTest.g:755:1: ( RULE_LANGUAGE )
            {
            // InternalXtextTest.g:755:1: ( RULE_LANGUAGE )
            // InternalXtextTest.g:756:1: RULE_LANGUAGE
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
    // InternalXtextTest.g:769:1: rule__XtextTest__Group__4 : rule__XtextTest__Group__4__Impl rule__XtextTest__Group__5 ;
    public final void rule__XtextTest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:773:1: ( rule__XtextTest__Group__4__Impl rule__XtextTest__Group__5 )
            // InternalXtextTest.g:774:2: rule__XtextTest__Group__4__Impl rule__XtextTest__Group__5
            {
            pushFollow(FOLLOW_6);
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
    // InternalXtextTest.g:781:1: rule__XtextTest__Group__4__Impl : ( ( rule__XtextTest__LangAssignment_4 ) ) ;
    public final void rule__XtextTest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:785:1: ( ( ( rule__XtextTest__LangAssignment_4 ) ) )
            // InternalXtextTest.g:787:1: ( ( rule__XtextTest__LangAssignment_4 ) )
            {
            // InternalXtextTest.g:787:1: ( ( rule__XtextTest__LangAssignment_4 ) )
            // InternalXtextTest.g:788:1: ( rule__XtextTest__LangAssignment_4 )
            {
             before(grammarAccess.getXtextTestAccess().getLangAssignment_4()); 
            // InternalXtextTest.g:789:1: ( rule__XtextTest__LangAssignment_4 )
            // InternalXtextTest.g:789:2: rule__XtextTest__LangAssignment_4
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
    // InternalXtextTest.g:801:1: rule__XtextTest__Group__5 : rule__XtextTest__Group__5__Impl rule__XtextTest__Group__6 ;
    public final void rule__XtextTest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:805:1: ( rule__XtextTest__Group__5__Impl rule__XtextTest__Group__6 )
            // InternalXtextTest.g:806:2: rule__XtextTest__Group__5__Impl rule__XtextTest__Group__6
            {
            pushFollow(FOLLOW_6);
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
    // InternalXtextTest.g:813:1: rule__XtextTest__Group__5__Impl : ( ( rule__XtextTest__Group_5__0 )? ) ;
    public final void rule__XtextTest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:817:1: ( ( ( rule__XtextTest__Group_5__0 )? ) )
            // InternalXtextTest.g:819:1: ( ( rule__XtextTest__Group_5__0 )? )
            {
            // InternalXtextTest.g:819:1: ( ( rule__XtextTest__Group_5__0 )? )
            // InternalXtextTest.g:820:1: ( rule__XtextTest__Group_5__0 )?
            {
             before(grammarAccess.getXtextTestAccess().getGroup_5()); 
            // InternalXtextTest.g:821:1: ( rule__XtextTest__Group_5__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_SPLITLEXER) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalXtextTest.g:821:2: rule__XtextTest__Group_5__0
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
    // InternalXtextTest.g:833:1: rule__XtextTest__Group__6 : rule__XtextTest__Group__6__Impl rule__XtextTest__Group__7 ;
    public final void rule__XtextTest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:837:1: ( rule__XtextTest__Group__6__Impl rule__XtextTest__Group__7 )
            // InternalXtextTest.g:838:2: rule__XtextTest__Group__6__Impl rule__XtextTest__Group__7
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
    // InternalXtextTest.g:845:1: rule__XtextTest__Group__6__Impl : ( ( rule__XtextTest__InputAssignment_6 ) ) ;
    public final void rule__XtextTest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:849:1: ( ( ( rule__XtextTest__InputAssignment_6 ) ) )
            // InternalXtextTest.g:851:1: ( ( rule__XtextTest__InputAssignment_6 ) )
            {
            // InternalXtextTest.g:851:1: ( ( rule__XtextTest__InputAssignment_6 ) )
            // InternalXtextTest.g:852:1: ( rule__XtextTest__InputAssignment_6 )
            {
             before(grammarAccess.getXtextTestAccess().getInputAssignment_6()); 
            // InternalXtextTest.g:853:1: ( rule__XtextTest__InputAssignment_6 )
            // InternalXtextTest.g:853:2: rule__XtextTest__InputAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__InputAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getXtextTestAccess().getInputAssignment_6()); 

            }


            }

        }
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
    // InternalXtextTest.g:865:1: rule__XtextTest__Group__7 : rule__XtextTest__Group__7__Impl rule__XtextTest__Group__8 ;
    public final void rule__XtextTest__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:869:1: ( rule__XtextTest__Group__7__Impl rule__XtextTest__Group__8 )
            // InternalXtextTest.g:870:2: rule__XtextTest__Group__7__Impl rule__XtextTest__Group__8
            {
            pushFollow(FOLLOW_7);
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
    // InternalXtextTest.g:877:1: rule__XtextTest__Group__7__Impl : ( ( rule__XtextTest__TokensAssignment_7 )? ) ;
    public final void rule__XtextTest__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:881:1: ( ( ( rule__XtextTest__TokensAssignment_7 )? ) )
            // InternalXtextTest.g:883:1: ( ( rule__XtextTest__TokensAssignment_7 )? )
            {
            // InternalXtextTest.g:883:1: ( ( rule__XtextTest__TokensAssignment_7 )? )
            // InternalXtextTest.g:884:1: ( rule__XtextTest__TokensAssignment_7 )?
            {
             before(grammarAccess.getXtextTestAccess().getTokensAssignment_7()); 
            // InternalXtextTest.g:885:1: ( rule__XtextTest__TokensAssignment_7 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_LEXER) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalXtextTest.g:885:2: rule__XtextTest__TokensAssignment_7
                    {
                    pushFollow(FOLLOW_2);
                    rule__XtextTest__TokensAssignment_7();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXtextTestAccess().getTokensAssignment_7()); 

            }


            }

        }
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
    // InternalXtextTest.g:897:1: rule__XtextTest__Group__8 : rule__XtextTest__Group__8__Impl rule__XtextTest__Group__9 ;
    public final void rule__XtextTest__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:901:1: ( rule__XtextTest__Group__8__Impl rule__XtextTest__Group__9 )
            // InternalXtextTest.g:902:2: rule__XtextTest__Group__8__Impl rule__XtextTest__Group__9
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
    // InternalXtextTest.g:909:1: rule__XtextTest__Group__8__Impl : ( ( rule__XtextTest__RootAssignment_8 ) ) ;
    public final void rule__XtextTest__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:913:1: ( ( ( rule__XtextTest__RootAssignment_8 ) ) )
            // InternalXtextTest.g:915:1: ( ( rule__XtextTest__RootAssignment_8 ) )
            {
            // InternalXtextTest.g:915:1: ( ( rule__XtextTest__RootAssignment_8 ) )
            // InternalXtextTest.g:916:1: ( rule__XtextTest__RootAssignment_8 )
            {
             before(grammarAccess.getXtextTestAccess().getRootAssignment_8()); 
            // InternalXtextTest.g:917:1: ( rule__XtextTest__RootAssignment_8 )
            // InternalXtextTest.g:917:2: rule__XtextTest__RootAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__RootAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getXtextTestAccess().getRootAssignment_8()); 

            }


            }

        }
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
    // InternalXtextTest.g:929:1: rule__XtextTest__Group__9 : rule__XtextTest__Group__9__Impl rule__XtextTest__Group__10 ;
    public final void rule__XtextTest__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:933:1: ( rule__XtextTest__Group__9__Impl rule__XtextTest__Group__10 )
            // InternalXtextTest.g:934:2: rule__XtextTest__Group__9__Impl rule__XtextTest__Group__10
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
    // InternalXtextTest.g:941:1: rule__XtextTest__Group__9__Impl : ( ( rule__XtextTest__OutputAssignment_9 )? ) ;
    public final void rule__XtextTest__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:945:1: ( ( ( rule__XtextTest__OutputAssignment_9 )? ) )
            // InternalXtextTest.g:947:1: ( ( rule__XtextTest__OutputAssignment_9 )? )
            {
            // InternalXtextTest.g:947:1: ( ( rule__XtextTest__OutputAssignment_9 )? )
            // InternalXtextTest.g:948:1: ( rule__XtextTest__OutputAssignment_9 )?
            {
             before(grammarAccess.getXtextTestAccess().getOutputAssignment_9()); 
            // InternalXtextTest.g:949:1: ( rule__XtextTest__OutputAssignment_9 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_OUTPUT) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalXtextTest.g:949:2: rule__XtextTest__OutputAssignment_9
                    {
                    pushFollow(FOLLOW_2);
                    rule__XtextTest__OutputAssignment_9();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXtextTestAccess().getOutputAssignment_9()); 

            }


            }

        }
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
    // InternalXtextTest.g:961:1: rule__XtextTest__Group__10 : rule__XtextTest__Group__10__Impl rule__XtextTest__Group__11 ;
    public final void rule__XtextTest__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:965:1: ( rule__XtextTest__Group__10__Impl rule__XtextTest__Group__11 )
            // InternalXtextTest.g:966:2: rule__XtextTest__Group__10__Impl rule__XtextTest__Group__11
            {
            pushFollow(FOLLOW_8);
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
    // InternalXtextTest.g:973:1: rule__XtextTest__Group__10__Impl : ( ( rule__XtextTest__BeforeAssignment_10 )? ) ;
    public final void rule__XtextTest__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:977:1: ( ( ( rule__XtextTest__BeforeAssignment_10 )? ) )
            // InternalXtextTest.g:979:1: ( ( rule__XtextTest__BeforeAssignment_10 )? )
            {
            // InternalXtextTest.g:979:1: ( ( rule__XtextTest__BeforeAssignment_10 )? )
            // InternalXtextTest.g:980:1: ( rule__XtextTest__BeforeAssignment_10 )?
            {
             before(grammarAccess.getXtextTestAccess().getBeforeAssignment_10()); 
            // InternalXtextTest.g:981:1: ( rule__XtextTest__BeforeAssignment_10 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_BEFORE_KW) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalXtextTest.g:981:2: rule__XtextTest__BeforeAssignment_10
                    {
                    pushFollow(FOLLOW_2);
                    rule__XtextTest__BeforeAssignment_10();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXtextTestAccess().getBeforeAssignment_10()); 

            }


            }

        }
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
    // InternalXtextTest.g:993:1: rule__XtextTest__Group__11 : rule__XtextTest__Group__11__Impl ;
    public final void rule__XtextTest__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:997:1: ( rule__XtextTest__Group__11__Impl )
            // InternalXtextTest.g:998:2: rule__XtextTest__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__Group__11__Impl();

            state._fsp--;


            }

        }
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
    // InternalXtextTest.g:1004:1: rule__XtextTest__Group__11__Impl : ( ( rule__XtextTest__AfterAssignment_11 )? ) ;
    public final void rule__XtextTest__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1008:1: ( ( ( rule__XtextTest__AfterAssignment_11 )? ) )
            // InternalXtextTest.g:1010:1: ( ( rule__XtextTest__AfterAssignment_11 )? )
            {
            // InternalXtextTest.g:1010:1: ( ( rule__XtextTest__AfterAssignment_11 )? )
            // InternalXtextTest.g:1011:1: ( rule__XtextTest__AfterAssignment_11 )?
            {
             before(grammarAccess.getXtextTestAccess().getAfterAssignment_11()); 
            // InternalXtextTest.g:1012:1: ( rule__XtextTest__AfterAssignment_11 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_AFTER_KW) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalXtextTest.g:1012:2: rule__XtextTest__AfterAssignment_11
                    {
                    pushFollow(FOLLOW_2);
                    rule__XtextTest__AfterAssignment_11();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXtextTestAccess().getAfterAssignment_11()); 

            }


            }

        }
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


    // $ANTLR start "rule__XtextTest__Group_5__0"
    // InternalXtextTest.g:1048:1: rule__XtextTest__Group_5__0 : rule__XtextTest__Group_5__0__Impl rule__XtextTest__Group_5__1 ;
    public final void rule__XtextTest__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1052:1: ( rule__XtextTest__Group_5__0__Impl rule__XtextTest__Group_5__1 )
            // InternalXtextTest.g:1053:2: rule__XtextTest__Group_5__0__Impl rule__XtextTest__Group_5__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalXtextTest.g:1060:1: rule__XtextTest__Group_5__0__Impl : ( RULE_SPLITLEXER ) ;
    public final void rule__XtextTest__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1064:1: ( ( RULE_SPLITLEXER ) )
            // InternalXtextTest.g:1066:1: ( RULE_SPLITLEXER )
            {
            // InternalXtextTest.g:1066:1: ( RULE_SPLITLEXER )
            // InternalXtextTest.g:1067:1: RULE_SPLITLEXER
            {
             before(grammarAccess.getXtextTestAccess().getSPLITLEXERTerminalRuleCall_5_0()); 
            match(input,RULE_SPLITLEXER,FOLLOW_2); 
             after(grammarAccess.getXtextTestAccess().getSPLITLEXERTerminalRuleCall_5_0()); 

            }


            }

        }
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
    // InternalXtextTest.g:1080:1: rule__XtextTest__Group_5__1 : rule__XtextTest__Group_5__1__Impl rule__XtextTest__Group_5__2 ;
    public final void rule__XtextTest__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1084:1: ( rule__XtextTest__Group_5__1__Impl rule__XtextTest__Group_5__2 )
            // InternalXtextTest.g:1085:2: rule__XtextTest__Group_5__1__Impl rule__XtextTest__Group_5__2
            {
            pushFollow(FOLLOW_10);
            rule__XtextTest__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XtextTest__Group_5__2();

            state._fsp--;


            }

        }
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
    // InternalXtextTest.g:1092:1: rule__XtextTest__Group_5__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__XtextTest__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1096:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:1098:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:1098:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:1099:1: RULE_ASSIGNASSINGLE
            {
             before(grammarAccess.getXtextTestAccess().getASSIGNASSINGLETerminalRuleCall_5_1()); 
            match(input,RULE_ASSIGNASSINGLE,FOLLOW_2); 
             after(grammarAccess.getXtextTestAccess().getASSIGNASSINGLETerminalRuleCall_5_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__XtextTest__Group_5__2"
    // InternalXtextTest.g:1112:1: rule__XtextTest__Group_5__2 : rule__XtextTest__Group_5__2__Impl ;
    public final void rule__XtextTest__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1116:1: ( rule__XtextTest__Group_5__2__Impl )
            // InternalXtextTest.g:1117:2: rule__XtextTest__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_5__2"


    // $ANTLR start "rule__XtextTest__Group_5__2__Impl"
    // InternalXtextTest.g:1123:1: rule__XtextTest__Group_5__2__Impl : ( ( rule__XtextTest__BooleanAssignment_5_2 ) ) ;
    public final void rule__XtextTest__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1127:1: ( ( ( rule__XtextTest__BooleanAssignment_5_2 ) ) )
            // InternalXtextTest.g:1129:1: ( ( rule__XtextTest__BooleanAssignment_5_2 ) )
            {
            // InternalXtextTest.g:1129:1: ( ( rule__XtextTest__BooleanAssignment_5_2 ) )
            // InternalXtextTest.g:1130:1: ( rule__XtextTest__BooleanAssignment_5_2 )
            {
             before(grammarAccess.getXtextTestAccess().getBooleanAssignment_5_2()); 
            // InternalXtextTest.g:1131:1: ( rule__XtextTest__BooleanAssignment_5_2 )
            // InternalXtextTest.g:1131:2: rule__XtextTest__BooleanAssignment_5_2
            {
            pushFollow(FOLLOW_2);
            rule__XtextTest__BooleanAssignment_5_2();

            state._fsp--;


            }

             after(grammarAccess.getXtextTestAccess().getBooleanAssignment_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__Group_5__2__Impl"


    // $ANTLR start "rule__PackageID__Group__0"
    // InternalXtextTest.g:1149:1: rule__PackageID__Group__0 : rule__PackageID__Group__0__Impl rule__PackageID__Group__1 ;
    public final void rule__PackageID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1153:1: ( rule__PackageID__Group__0__Impl rule__PackageID__Group__1 )
            // InternalXtextTest.g:1154:2: rule__PackageID__Group__0__Impl rule__PackageID__Group__1
            {
            pushFollow(FOLLOW_11);
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
    // InternalXtextTest.g:1161:1: rule__PackageID__Group__0__Impl : ( RULE_IDENTIFIER ) ;
    public final void rule__PackageID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1165:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:1167:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:1167:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:1168:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:1181:1: rule__PackageID__Group__1 : rule__PackageID__Group__1__Impl ;
    public final void rule__PackageID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1185:1: ( rule__PackageID__Group__1__Impl )
            // InternalXtextTest.g:1186:2: rule__PackageID__Group__1__Impl
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
    // InternalXtextTest.g:1192:1: rule__PackageID__Group__1__Impl : ( ( rule__PackageID__Group_1__0 )* ) ;
    public final void rule__PackageID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1196:1: ( ( ( rule__PackageID__Group_1__0 )* ) )
            // InternalXtextTest.g:1198:1: ( ( rule__PackageID__Group_1__0 )* )
            {
            // InternalXtextTest.g:1198:1: ( ( rule__PackageID__Group_1__0 )* )
            // InternalXtextTest.g:1199:1: ( rule__PackageID__Group_1__0 )*
            {
             before(grammarAccess.getPackageIDAccess().getGroup_1()); 
            // InternalXtextTest.g:1200:1: ( rule__PackageID__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_POINT) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalXtextTest.g:1200:2: rule__PackageID__Group_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__PackageID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // InternalXtextTest.g:1216:1: rule__PackageID__Group_1__0 : rule__PackageID__Group_1__0__Impl rule__PackageID__Group_1__1 ;
    public final void rule__PackageID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1220:1: ( rule__PackageID__Group_1__0__Impl rule__PackageID__Group_1__1 )
            // InternalXtextTest.g:1221:2: rule__PackageID__Group_1__0__Impl rule__PackageID__Group_1__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalXtextTest.g:1228:1: rule__PackageID__Group_1__0__Impl : ( RULE_POINT ) ;
    public final void rule__PackageID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1232:1: ( ( RULE_POINT ) )
            // InternalXtextTest.g:1234:1: ( RULE_POINT )
            {
            // InternalXtextTest.g:1234:1: ( RULE_POINT )
            // InternalXtextTest.g:1235:1: RULE_POINT
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
    // InternalXtextTest.g:1248:1: rule__PackageID__Group_1__1 : rule__PackageID__Group_1__1__Impl ;
    public final void rule__PackageID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1252:1: ( rule__PackageID__Group_1__1__Impl )
            // InternalXtextTest.g:1253:2: rule__PackageID__Group_1__1__Impl
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
    // InternalXtextTest.g:1259:1: rule__PackageID__Group_1__1__Impl : ( RULE_IDENTIFIER ) ;
    public final void rule__PackageID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1263:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:1265:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:1265:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:1266:1: RULE_IDENTIFIER
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


    // $ANTLR start "rule__Input__Group__0"
    // InternalXtextTest.g:1283:1: rule__Input__Group__0 : rule__Input__Group__0__Impl rule__Input__Group__1 ;
    public final void rule__Input__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1287:1: ( rule__Input__Group__0__Impl rule__Input__Group__1 )
            // InternalXtextTest.g:1288:2: rule__Input__Group__0__Impl rule__Input__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalXtextTest.g:1295:1: rule__Input__Group__0__Impl : ( () ) ;
    public final void rule__Input__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1299:1: ( ( () ) )
            // InternalXtextTest.g:1301:1: ( () )
            {
            // InternalXtextTest.g:1301:1: ( () )
            // InternalXtextTest.g:1302:1: ()
            {
             before(grammarAccess.getInputAccess().getInputAction_0()); 
            // InternalXtextTest.g:1303:1: ()
            // InternalXtextTest.g:1305:1: 
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
    // InternalXtextTest.g:1317:1: rule__Input__Group__1 : rule__Input__Group__1__Impl rule__Input__Group__2 ;
    public final void rule__Input__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1321:1: ( rule__Input__Group__1__Impl rule__Input__Group__2 )
            // InternalXtextTest.g:1322:2: rule__Input__Group__1__Impl rule__Input__Group__2
            {
            pushFollow(FOLLOW_13);
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
    // InternalXtextTest.g:1329:1: rule__Input__Group__1__Impl : ( RULE_SOURCE ) ;
    public final void rule__Input__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1333:1: ( ( RULE_SOURCE ) )
            // InternalXtextTest.g:1335:1: ( RULE_SOURCE )
            {
            // InternalXtextTest.g:1335:1: ( RULE_SOURCE )
            // InternalXtextTest.g:1336:1: RULE_SOURCE
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
    // InternalXtextTest.g:1349:1: rule__Input__Group__2 : rule__Input__Group__2__Impl ;
    public final void rule__Input__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1353:1: ( rule__Input__Group__2__Impl )
            // InternalXtextTest.g:1354:2: rule__Input__Group__2__Impl
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
    // InternalXtextTest.g:1360:1: rule__Input__Group__2__Impl : ( ( rule__Input__Alternatives_2 ) ) ;
    public final void rule__Input__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1364:1: ( ( ( rule__Input__Alternatives_2 ) ) )
            // InternalXtextTest.g:1366:1: ( ( rule__Input__Alternatives_2 ) )
            {
            // InternalXtextTest.g:1366:1: ( ( rule__Input__Alternatives_2 ) )
            // InternalXtextTest.g:1367:1: ( rule__Input__Alternatives_2 )
            {
             before(grammarAccess.getInputAccess().getAlternatives_2()); 
            // InternalXtextTest.g:1368:1: ( rule__Input__Alternatives_2 )
            // InternalXtextTest.g:1368:2: rule__Input__Alternatives_2
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
    // InternalXtextTest.g:1386:1: rule__Input__Group_2_0__0 : rule__Input__Group_2_0__0__Impl rule__Input__Group_2_0__1 ;
    public final void rule__Input__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1390:1: ( rule__Input__Group_2_0__0__Impl rule__Input__Group_2_0__1 )
            // InternalXtextTest.g:1391:2: rule__Input__Group_2_0__0__Impl rule__Input__Group_2_0__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalXtextTest.g:1398:1: rule__Input__Group_2_0__0__Impl : ( RULE_SRCTEXT ) ;
    public final void rule__Input__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1402:1: ( ( RULE_SRCTEXT ) )
            // InternalXtextTest.g:1404:1: ( RULE_SRCTEXT )
            {
            // InternalXtextTest.g:1404:1: ( RULE_SRCTEXT )
            // InternalXtextTest.g:1405:1: RULE_SRCTEXT
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
    // InternalXtextTest.g:1418:1: rule__Input__Group_2_0__1 : rule__Input__Group_2_0__1__Impl rule__Input__Group_2_0__2 ;
    public final void rule__Input__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1422:1: ( rule__Input__Group_2_0__1__Impl rule__Input__Group_2_0__2 )
            // InternalXtextTest.g:1423:2: rule__Input__Group_2_0__1__Impl rule__Input__Group_2_0__2
            {
            pushFollow(FOLLOW_14);
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
    // InternalXtextTest.g:1430:1: rule__Input__Group_2_0__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Input__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1434:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:1436:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:1436:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:1437:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:1450:1: rule__Input__Group_2_0__2 : rule__Input__Group_2_0__2__Impl ;
    public final void rule__Input__Group_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1454:1: ( rule__Input__Group_2_0__2__Impl )
            // InternalXtextTest.g:1455:2: rule__Input__Group_2_0__2__Impl
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
    // InternalXtextTest.g:1461:1: rule__Input__Group_2_0__2__Impl : ( ( rule__Input__TextAssignment_2_0_2 ) ) ;
    public final void rule__Input__Group_2_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1465:1: ( ( ( rule__Input__TextAssignment_2_0_2 ) ) )
            // InternalXtextTest.g:1467:1: ( ( rule__Input__TextAssignment_2_0_2 ) )
            {
            // InternalXtextTest.g:1467:1: ( ( rule__Input__TextAssignment_2_0_2 ) )
            // InternalXtextTest.g:1468:1: ( rule__Input__TextAssignment_2_0_2 )
            {
             before(grammarAccess.getInputAccess().getTextAssignment_2_0_2()); 
            // InternalXtextTest.g:1469:1: ( rule__Input__TextAssignment_2_0_2 )
            // InternalXtextTest.g:1469:2: rule__Input__TextAssignment_2_0_2
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
    // InternalXtextTest.g:1487:1: rule__Input__Group_2_1__0 : rule__Input__Group_2_1__0__Impl rule__Input__Group_2_1__1 ;
    public final void rule__Input__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1491:1: ( rule__Input__Group_2_1__0__Impl rule__Input__Group_2_1__1 )
            // InternalXtextTest.g:1492:2: rule__Input__Group_2_1__0__Impl rule__Input__Group_2_1__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalXtextTest.g:1499:1: rule__Input__Group_2_1__0__Impl : ( RULE_FILE ) ;
    public final void rule__Input__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1503:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:1505:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:1505:1: ( RULE_FILE )
            // InternalXtextTest.g:1506:1: RULE_FILE
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
    // InternalXtextTest.g:1519:1: rule__Input__Group_2_1__1 : rule__Input__Group_2_1__1__Impl rule__Input__Group_2_1__2 ;
    public final void rule__Input__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1523:1: ( rule__Input__Group_2_1__1__Impl rule__Input__Group_2_1__2 )
            // InternalXtextTest.g:1524:2: rule__Input__Group_2_1__1__Impl rule__Input__Group_2_1__2
            {
            pushFollow(FOLLOW_14);
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
    // InternalXtextTest.g:1531:1: rule__Input__Group_2_1__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Input__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1535:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:1537:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:1537:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:1538:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:1551:1: rule__Input__Group_2_1__2 : rule__Input__Group_2_1__2__Impl ;
    public final void rule__Input__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1555:1: ( rule__Input__Group_2_1__2__Impl )
            // InternalXtextTest.g:1556:2: rule__Input__Group_2_1__2__Impl
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
    // InternalXtextTest.g:1562:1: rule__Input__Group_2_1__2__Impl : ( ( rule__Input__FileAssignment_2_1_2 ) ) ;
    public final void rule__Input__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1566:1: ( ( ( rule__Input__FileAssignment_2_1_2 ) ) )
            // InternalXtextTest.g:1568:1: ( ( rule__Input__FileAssignment_2_1_2 ) )
            {
            // InternalXtextTest.g:1568:1: ( ( rule__Input__FileAssignment_2_1_2 ) )
            // InternalXtextTest.g:1569:1: ( rule__Input__FileAssignment_2_1_2 )
            {
             before(grammarAccess.getInputAccess().getFileAssignment_2_1_2()); 
            // InternalXtextTest.g:1570:1: ( rule__Input__FileAssignment_2_1_2 )
            // InternalXtextTest.g:1570:2: rule__Input__FileAssignment_2_1_2
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
    // InternalXtextTest.g:1588:1: rule__Tokens__Group__0 : rule__Tokens__Group__0__Impl rule__Tokens__Group__1 ;
    public final void rule__Tokens__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1592:1: ( rule__Tokens__Group__0__Impl rule__Tokens__Group__1 )
            // InternalXtextTest.g:1593:2: rule__Tokens__Group__0__Impl rule__Tokens__Group__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalXtextTest.g:1600:1: rule__Tokens__Group__0__Impl : ( () ) ;
    public final void rule__Tokens__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1604:1: ( ( () ) )
            // InternalXtextTest.g:1606:1: ( () )
            {
            // InternalXtextTest.g:1606:1: ( () )
            // InternalXtextTest.g:1607:1: ()
            {
             before(grammarAccess.getTokensAccess().getTokensAction_0()); 
            // InternalXtextTest.g:1608:1: ()
            // InternalXtextTest.g:1610:1: 
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
    // InternalXtextTest.g:1622:1: rule__Tokens__Group__1 : rule__Tokens__Group__1__Impl rule__Tokens__Group__2 ;
    public final void rule__Tokens__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1626:1: ( rule__Tokens__Group__1__Impl rule__Tokens__Group__2 )
            // InternalXtextTest.g:1627:2: rule__Tokens__Group__1__Impl rule__Tokens__Group__2
            {
            pushFollow(FOLLOW_4);
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
    // InternalXtextTest.g:1634:1: rule__Tokens__Group__1__Impl : ( RULE_LEXER ) ;
    public final void rule__Tokens__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1638:1: ( ( RULE_LEXER ) )
            // InternalXtextTest.g:1640:1: ( RULE_LEXER )
            {
            // InternalXtextTest.g:1640:1: ( RULE_LEXER )
            // InternalXtextTest.g:1641:1: RULE_LEXER
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
    // InternalXtextTest.g:1654:1: rule__Tokens__Group__2 : rule__Tokens__Group__2__Impl ;
    public final void rule__Tokens__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1658:1: ( rule__Tokens__Group__2__Impl )
            // InternalXtextTest.g:1659:2: rule__Tokens__Group__2__Impl
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
    // InternalXtextTest.g:1665:1: rule__Tokens__Group__2__Impl : ( ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* ) ) ;
    public final void rule__Tokens__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1669:1: ( ( ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* ) ) )
            // InternalXtextTest.g:1671:1: ( ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* ) )
            {
            // InternalXtextTest.g:1671:1: ( ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* ) )
            // InternalXtextTest.g:1672:1: ( ( rule__Tokens__TokensAssignment_2 ) ) ( ( rule__Tokens__TokensAssignment_2 )* )
            {
            // InternalXtextTest.g:1672:1: ( ( rule__Tokens__TokensAssignment_2 ) )
            // InternalXtextTest.g:1673:1: ( rule__Tokens__TokensAssignment_2 )
            {
             before(grammarAccess.getTokensAccess().getTokensAssignment_2()); 
            // InternalXtextTest.g:1674:1: ( rule__Tokens__TokensAssignment_2 )
            // InternalXtextTest.g:1674:2: rule__Tokens__TokensAssignment_2
            {
            pushFollow(FOLLOW_16);
            rule__Tokens__TokensAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTokensAccess().getTokensAssignment_2()); 

            }

            // InternalXtextTest.g:1677:1: ( ( rule__Tokens__TokensAssignment_2 )* )
            // InternalXtextTest.g:1678:1: ( rule__Tokens__TokensAssignment_2 )*
            {
             before(grammarAccess.getTokensAccess().getTokensAssignment_2()); 
            // InternalXtextTest.g:1679:1: ( rule__Tokens__TokensAssignment_2 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_IDENTIFIER) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalXtextTest.g:1679:2: rule__Tokens__TokensAssignment_2
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Tokens__TokensAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // InternalXtextTest.g:1698:1: rule__MyTokens__Group__0 : rule__MyTokens__Group__0__Impl rule__MyTokens__Group__1 ;
    public final void rule__MyTokens__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1702:1: ( rule__MyTokens__Group__0__Impl rule__MyTokens__Group__1 )
            // InternalXtextTest.g:1703:2: rule__MyTokens__Group__0__Impl rule__MyTokens__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalXtextTest.g:1710:1: rule__MyTokens__Group__0__Impl : ( ( rule__MyTokens__TokenAssignment_0 ) ) ;
    public final void rule__MyTokens__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1714:1: ( ( ( rule__MyTokens__TokenAssignment_0 ) ) )
            // InternalXtextTest.g:1716:1: ( ( rule__MyTokens__TokenAssignment_0 ) )
            {
            // InternalXtextTest.g:1716:1: ( ( rule__MyTokens__TokenAssignment_0 ) )
            // InternalXtextTest.g:1717:1: ( rule__MyTokens__TokenAssignment_0 )
            {
             before(grammarAccess.getMyTokensAccess().getTokenAssignment_0()); 
            // InternalXtextTest.g:1718:1: ( rule__MyTokens__TokenAssignment_0 )
            // InternalXtextTest.g:1718:2: rule__MyTokens__TokenAssignment_0
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
    // InternalXtextTest.g:1730:1: rule__MyTokens__Group__1 : rule__MyTokens__Group__1__Impl ;
    public final void rule__MyTokens__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1734:1: ( rule__MyTokens__Group__1__Impl )
            // InternalXtextTest.g:1735:2: rule__MyTokens__Group__1__Impl
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
    // InternalXtextTest.g:1741:1: rule__MyTokens__Group__1__Impl : ( ( rule__MyTokens__Group_1__0 )? ) ;
    public final void rule__MyTokens__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1745:1: ( ( ( rule__MyTokens__Group_1__0 )? ) )
            // InternalXtextTest.g:1747:1: ( ( rule__MyTokens__Group_1__0 )? )
            {
            // InternalXtextTest.g:1747:1: ( ( rule__MyTokens__Group_1__0 )? )
            // InternalXtextTest.g:1748:1: ( rule__MyTokens__Group_1__0 )?
            {
             before(grammarAccess.getMyTokensAccess().getGroup_1()); 
            // InternalXtextTest.g:1749:1: ( rule__MyTokens__Group_1__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ASSIGNASDATALIST) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalXtextTest.g:1749:2: rule__MyTokens__Group_1__0
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
    // InternalXtextTest.g:1765:1: rule__MyTokens__Group_1__0 : rule__MyTokens__Group_1__0__Impl rule__MyTokens__Group_1__1 ;
    public final void rule__MyTokens__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1769:1: ( rule__MyTokens__Group_1__0__Impl rule__MyTokens__Group_1__1 )
            // InternalXtextTest.g:1770:2: rule__MyTokens__Group_1__0__Impl rule__MyTokens__Group_1__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalXtextTest.g:1777:1: rule__MyTokens__Group_1__0__Impl : ( RULE_ASSIGNASDATALIST ) ;
    public final void rule__MyTokens__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1781:1: ( ( RULE_ASSIGNASDATALIST ) )
            // InternalXtextTest.g:1783:1: ( RULE_ASSIGNASDATALIST )
            {
            // InternalXtextTest.g:1783:1: ( RULE_ASSIGNASDATALIST )
            // InternalXtextTest.g:1784:1: RULE_ASSIGNASDATALIST
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
    // InternalXtextTest.g:1797:1: rule__MyTokens__Group_1__1 : rule__MyTokens__Group_1__1__Impl ;
    public final void rule__MyTokens__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1801:1: ( rule__MyTokens__Group_1__1__Impl )
            // InternalXtextTest.g:1802:2: rule__MyTokens__Group_1__1__Impl
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
    // InternalXtextTest.g:1808:1: rule__MyTokens__Group_1__1__Impl : ( ( rule__MyTokens__CountAssignment_1_1 ) ) ;
    public final void rule__MyTokens__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1812:1: ( ( ( rule__MyTokens__CountAssignment_1_1 ) ) )
            // InternalXtextTest.g:1814:1: ( ( rule__MyTokens__CountAssignment_1_1 ) )
            {
            // InternalXtextTest.g:1814:1: ( ( rule__MyTokens__CountAssignment_1_1 ) )
            // InternalXtextTest.g:1815:1: ( rule__MyTokens__CountAssignment_1_1 )
            {
             before(grammarAccess.getMyTokensAccess().getCountAssignment_1_1()); 
            // InternalXtextTest.g:1816:1: ( rule__MyTokens__CountAssignment_1_1 )
            // InternalXtextTest.g:1816:2: rule__MyTokens__CountAssignment_1_1
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
    // InternalXtextTest.g:1832:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1836:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalXtextTest.g:1837:2: rule__Element__Group__0__Impl rule__Element__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalXtextTest.g:1844:1: rule__Element__Group__0__Impl : ( () ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1848:1: ( ( () ) )
            // InternalXtextTest.g:1850:1: ( () )
            {
            // InternalXtextTest.g:1850:1: ( () )
            // InternalXtextTest.g:1851:1: ()
            {
             before(grammarAccess.getElementAccess().getElementAction_0()); 
            // InternalXtextTest.g:1852:1: ()
            // InternalXtextTest.g:1854:1: 
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
    // InternalXtextTest.g:1866:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1870:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // InternalXtextTest.g:1871:2: rule__Element__Group__1__Impl rule__Element__Group__2
            {
            pushFollow(FOLLOW_4);
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
    // InternalXtextTest.g:1878:1: rule__Element__Group__1__Impl : ( RULE_LEFTPAREN ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1882:1: ( ( RULE_LEFTPAREN ) )
            // InternalXtextTest.g:1884:1: ( RULE_LEFTPAREN )
            {
            // InternalXtextTest.g:1884:1: ( RULE_LEFTPAREN )
            // InternalXtextTest.g:1885:1: RULE_LEFTPAREN
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
    // InternalXtextTest.g:1898:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1902:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // InternalXtextTest.g:1903:2: rule__Element__Group__2__Impl rule__Element__Group__3
            {
            pushFollow(FOLLOW_19);
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
    // InternalXtextTest.g:1910:1: rule__Element__Group__2__Impl : ( ( rule__Element__NameAssignment_2 ) ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1914:1: ( ( ( rule__Element__NameAssignment_2 ) ) )
            // InternalXtextTest.g:1916:1: ( ( rule__Element__NameAssignment_2 ) )
            {
            // InternalXtextTest.g:1916:1: ( ( rule__Element__NameAssignment_2 ) )
            // InternalXtextTest.g:1917:1: ( rule__Element__NameAssignment_2 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_2()); 
            // InternalXtextTest.g:1918:1: ( rule__Element__NameAssignment_2 )
            // InternalXtextTest.g:1918:2: rule__Element__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Element__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getNameAssignment_2()); 

            }


            }

        }
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
    // InternalXtextTest.g:1930:1: rule__Element__Group__3 : rule__Element__Group__3__Impl rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1934:1: ( rule__Element__Group__3__Impl rule__Element__Group__4 )
            // InternalXtextTest.g:1935:2: rule__Element__Group__3__Impl rule__Element__Group__4
            {
            pushFollow(FOLLOW_19);
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
    // InternalXtextTest.g:1942:1: rule__Element__Group__3__Impl : ( ( rule__Element__Group_3__0 )? ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1946:1: ( ( ( rule__Element__Group_3__0 )? ) )
            // InternalXtextTest.g:1948:1: ( ( rule__Element__Group_3__0 )? )
            {
            // InternalXtextTest.g:1948:1: ( ( rule__Element__Group_3__0 )? )
            // InternalXtextTest.g:1949:1: ( rule__Element__Group_3__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_3()); 
            // InternalXtextTest.g:1950:1: ( rule__Element__Group_3__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_IDENTIFIER) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalXtextTest.g:1950:2: rule__Element__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Element__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementAccess().getGroup_3()); 

            }


            }

        }
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
    // InternalXtextTest.g:1962:1: rule__Element__Group__4 : rule__Element__Group__4__Impl ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1966:1: ( rule__Element__Group__4__Impl )
            // InternalXtextTest.g:1967:2: rule__Element__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // InternalXtextTest.g:1973:1: rule__Element__Group__4__Impl : ( RULE_RIGHTPAREN ) ;
    public final void rule__Element__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:1977:1: ( ( RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:1979:1: ( RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:1979:1: ( RULE_RIGHTPAREN )
            // InternalXtextTest.g:1980:1: RULE_RIGHTPAREN
            {
             before(grammarAccess.getElementAccess().getRIGHTPARENTerminalRuleCall_4()); 
            match(input,RULE_RIGHTPAREN,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getRIGHTPARENTerminalRuleCall_4()); 

            }


            }

        }
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


    // $ANTLR start "rule__Element__Group_3__0"
    // InternalXtextTest.g:2003:1: rule__Element__Group_3__0 : rule__Element__Group_3__0__Impl rule__Element__Group_3__1 ;
    public final void rule__Element__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2007:1: ( rule__Element__Group_3__0__Impl rule__Element__Group_3__1 )
            // InternalXtextTest.g:2008:2: rule__Element__Group_3__0__Impl rule__Element__Group_3__1
            {
            pushFollow(FOLLOW_20);
            rule__Element__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3__0"


    // $ANTLR start "rule__Element__Group_3__0__Impl"
    // InternalXtextTest.g:2015:1: rule__Element__Group_3__0__Impl : ( ( rule__Element__InnerAssignment_3_0 ) ) ;
    public final void rule__Element__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2019:1: ( ( ( rule__Element__InnerAssignment_3_0 ) ) )
            // InternalXtextTest.g:2021:1: ( ( rule__Element__InnerAssignment_3_0 ) )
            {
            // InternalXtextTest.g:2021:1: ( ( rule__Element__InnerAssignment_3_0 ) )
            // InternalXtextTest.g:2022:1: ( rule__Element__InnerAssignment_3_0 )
            {
             before(grammarAccess.getElementAccess().getInnerAssignment_3_0()); 
            // InternalXtextTest.g:2023:1: ( rule__Element__InnerAssignment_3_0 )
            // InternalXtextTest.g:2023:2: rule__Element__InnerAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__Element__InnerAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getInnerAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3__0__Impl"


    // $ANTLR start "rule__Element__Group_3__1"
    // InternalXtextTest.g:2035:1: rule__Element__Group_3__1 : rule__Element__Group_3__1__Impl ;
    public final void rule__Element__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2039:1: ( rule__Element__Group_3__1__Impl )
            // InternalXtextTest.g:2040:2: rule__Element__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3__1"


    // $ANTLR start "rule__Element__Group_3__1__Impl"
    // InternalXtextTest.g:2046:1: rule__Element__Group_3__1__Impl : ( ( rule__Element__Group_3_1__0 )* ) ;
    public final void rule__Element__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2050:1: ( ( ( rule__Element__Group_3_1__0 )* ) )
            // InternalXtextTest.g:2052:1: ( ( rule__Element__Group_3_1__0 )* )
            {
            // InternalXtextTest.g:2052:1: ( ( rule__Element__Group_3_1__0 )* )
            // InternalXtextTest.g:2053:1: ( rule__Element__Group_3_1__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_3_1()); 
            // InternalXtextTest.g:2054:1: ( rule__Element__Group_3_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_COMMA) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalXtextTest.g:2054:2: rule__Element__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__Element__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3__1__Impl"


    // $ANTLR start "rule__Element__Group_3_1__0"
    // InternalXtextTest.g:2070:1: rule__Element__Group_3_1__0 : rule__Element__Group_3_1__0__Impl rule__Element__Group_3_1__1 ;
    public final void rule__Element__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2074:1: ( rule__Element__Group_3_1__0__Impl rule__Element__Group_3_1__1 )
            // InternalXtextTest.g:2075:2: rule__Element__Group_3_1__0__Impl rule__Element__Group_3_1__1
            {
            pushFollow(FOLLOW_4);
            rule__Element__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3_1__0"


    // $ANTLR start "rule__Element__Group_3_1__0__Impl"
    // InternalXtextTest.g:2082:1: rule__Element__Group_3_1__0__Impl : ( RULE_COMMA ) ;
    public final void rule__Element__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2086:1: ( ( RULE_COMMA ) )
            // InternalXtextTest.g:2088:1: ( RULE_COMMA )
            {
            // InternalXtextTest.g:2088:1: ( RULE_COMMA )
            // InternalXtextTest.g:2089:1: RULE_COMMA
            {
             before(grammarAccess.getElementAccess().getCOMMATerminalRuleCall_3_1_0()); 
            match(input,RULE_COMMA,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getCOMMATerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3_1__0__Impl"


    // $ANTLR start "rule__Element__Group_3_1__1"
    // InternalXtextTest.g:2102:1: rule__Element__Group_3_1__1 : rule__Element__Group_3_1__1__Impl ;
    public final void rule__Element__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2106:1: ( rule__Element__Group_3_1__1__Impl )
            // InternalXtextTest.g:2107:2: rule__Element__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3_1__1"


    // $ANTLR start "rule__Element__Group_3_1__1__Impl"
    // InternalXtextTest.g:2113:1: rule__Element__Group_3_1__1__Impl : ( ( rule__Element__InnerAssignment_3_1_1 ) ) ;
    public final void rule__Element__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2117:1: ( ( ( rule__Element__InnerAssignment_3_1_1 ) ) )
            // InternalXtextTest.g:2119:1: ( ( rule__Element__InnerAssignment_3_1_1 ) )
            {
            // InternalXtextTest.g:2119:1: ( ( rule__Element__InnerAssignment_3_1_1 ) )
            // InternalXtextTest.g:2120:1: ( rule__Element__InnerAssignment_3_1_1 )
            {
             before(grammarAccess.getElementAccess().getInnerAssignment_3_1_1()); 
            // InternalXtextTest.g:2121:1: ( rule__Element__InnerAssignment_3_1_1 )
            // InternalXtextTest.g:2121:2: rule__Element__InnerAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Element__InnerAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getInnerAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3_1__1__Impl"


    // $ANTLR start "rule__Inner__Group__0"
    // InternalXtextTest.g:2137:1: rule__Inner__Group__0 : rule__Inner__Group__0__Impl rule__Inner__Group__1 ;
    public final void rule__Inner__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2141:1: ( rule__Inner__Group__0__Impl rule__Inner__Group__1 )
            // InternalXtextTest.g:2142:2: rule__Inner__Group__0__Impl rule__Inner__Group__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalXtextTest.g:2149:1: rule__Inner__Group__0__Impl : ( () ) ;
    public final void rule__Inner__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2153:1: ( ( () ) )
            // InternalXtextTest.g:2155:1: ( () )
            {
            // InternalXtextTest.g:2155:1: ( () )
            // InternalXtextTest.g:2156:1: ()
            {
             before(grammarAccess.getInnerAccess().getInnerAction_0()); 
            // InternalXtextTest.g:2157:1: ()
            // InternalXtextTest.g:2159:1: 
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
    // InternalXtextTest.g:2171:1: rule__Inner__Group__1 : rule__Inner__Group__1__Impl rule__Inner__Group__2 ;
    public final void rule__Inner__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2175:1: ( rule__Inner__Group__1__Impl rule__Inner__Group__2 )
            // InternalXtextTest.g:2176:2: rule__Inner__Group__1__Impl rule__Inner__Group__2
            {
            pushFollow(FOLLOW_22);
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
    // InternalXtextTest.g:2183:1: rule__Inner__Group__1__Impl : ( ( rule__Inner__ParameterAssignment_1 ) ) ;
    public final void rule__Inner__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2187:1: ( ( ( rule__Inner__ParameterAssignment_1 ) ) )
            // InternalXtextTest.g:2189:1: ( ( rule__Inner__ParameterAssignment_1 ) )
            {
            // InternalXtextTest.g:2189:1: ( ( rule__Inner__ParameterAssignment_1 ) )
            // InternalXtextTest.g:2190:1: ( rule__Inner__ParameterAssignment_1 )
            {
             before(grammarAccess.getInnerAccess().getParameterAssignment_1()); 
            // InternalXtextTest.g:2191:1: ( rule__Inner__ParameterAssignment_1 )
            // InternalXtextTest.g:2191:2: rule__Inner__ParameterAssignment_1
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
    // InternalXtextTest.g:2203:1: rule__Inner__Group__2 : rule__Inner__Group__2__Impl ;
    public final void rule__Inner__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2207:1: ( rule__Inner__Group__2__Impl )
            // InternalXtextTest.g:2208:2: rule__Inner__Group__2__Impl
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
    // InternalXtextTest.g:2214:1: rule__Inner__Group__2__Impl : ( ( rule__Inner__Alternatives_2 ) ) ;
    public final void rule__Inner__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2218:1: ( ( ( rule__Inner__Alternatives_2 ) ) )
            // InternalXtextTest.g:2220:1: ( ( rule__Inner__Alternatives_2 ) )
            {
            // InternalXtextTest.g:2220:1: ( ( rule__Inner__Alternatives_2 ) )
            // InternalXtextTest.g:2221:1: ( rule__Inner__Alternatives_2 )
            {
             before(grammarAccess.getInnerAccess().getAlternatives_2()); 
            // InternalXtextTest.g:2222:1: ( rule__Inner__Alternatives_2 )
            // InternalXtextTest.g:2222:2: rule__Inner__Alternatives_2
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
    // InternalXtextTest.g:2240:1: rule__Inner__Group_2_0__0 : rule__Inner__Group_2_0__0__Impl rule__Inner__Group_2_0__1 ;
    public final void rule__Inner__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2244:1: ( rule__Inner__Group_2_0__0__Impl rule__Inner__Group_2_0__1 )
            // InternalXtextTest.g:2245:2: rule__Inner__Group_2_0__0__Impl rule__Inner__Group_2_0__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalXtextTest.g:2252:1: rule__Inner__Group_2_0__0__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Inner__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2256:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:2258:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:2258:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:2259:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:2272:1: rule__Inner__Group_2_0__1 : rule__Inner__Group_2_0__1__Impl ;
    public final void rule__Inner__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2276:1: ( rule__Inner__Group_2_0__1__Impl )
            // InternalXtextTest.g:2277:2: rule__Inner__Group_2_0__1__Impl
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
    // InternalXtextTest.g:2283:1: rule__Inner__Group_2_0__1__Impl : ( ( rule__Inner__AssignAssignment_2_0_1 ) ) ;
    public final void rule__Inner__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2287:1: ( ( ( rule__Inner__AssignAssignment_2_0_1 ) ) )
            // InternalXtextTest.g:2289:1: ( ( rule__Inner__AssignAssignment_2_0_1 ) )
            {
            // InternalXtextTest.g:2289:1: ( ( rule__Inner__AssignAssignment_2_0_1 ) )
            // InternalXtextTest.g:2290:1: ( rule__Inner__AssignAssignment_2_0_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignAssignment_2_0_1()); 
            // InternalXtextTest.g:2291:1: ( rule__Inner__AssignAssignment_2_0_1 )
            // InternalXtextTest.g:2291:2: rule__Inner__AssignAssignment_2_0_1
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
    // InternalXtextTest.g:2307:1: rule__Inner__Group_2_1__0 : rule__Inner__Group_2_1__0__Impl rule__Inner__Group_2_1__1 ;
    public final void rule__Inner__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2311:1: ( rule__Inner__Group_2_1__0__Impl rule__Inner__Group_2_1__1 )
            // InternalXtextTest.g:2312:2: rule__Inner__Group_2_1__0__Impl rule__Inner__Group_2_1__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalXtextTest.g:2319:1: rule__Inner__Group_2_1__0__Impl : ( RULE_ASSIGNASLIST ) ;
    public final void rule__Inner__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2323:1: ( ( RULE_ASSIGNASLIST ) )
            // InternalXtextTest.g:2325:1: ( RULE_ASSIGNASLIST )
            {
            // InternalXtextTest.g:2325:1: ( RULE_ASSIGNASLIST )
            // InternalXtextTest.g:2326:1: RULE_ASSIGNASLIST
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
    // InternalXtextTest.g:2339:1: rule__Inner__Group_2_1__1 : rule__Inner__Group_2_1__1__Impl rule__Inner__Group_2_1__2 ;
    public final void rule__Inner__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2343:1: ( rule__Inner__Group_2_1__1__Impl rule__Inner__Group_2_1__2 )
            // InternalXtextTest.g:2344:2: rule__Inner__Group_2_1__1__Impl rule__Inner__Group_2_1__2
            {
            pushFollow(FOLLOW_20);
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
    // InternalXtextTest.g:2351:1: rule__Inner__Group_2_1__1__Impl : ( ( rule__Inner__AssignListAssignment_2_1_1 ) ) ;
    public final void rule__Inner__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2355:1: ( ( ( rule__Inner__AssignListAssignment_2_1_1 ) ) )
            // InternalXtextTest.g:2357:1: ( ( rule__Inner__AssignListAssignment_2_1_1 ) )
            {
            // InternalXtextTest.g:2357:1: ( ( rule__Inner__AssignListAssignment_2_1_1 ) )
            // InternalXtextTest.g:2358:1: ( rule__Inner__AssignListAssignment_2_1_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignListAssignment_2_1_1()); 
            // InternalXtextTest.g:2359:1: ( rule__Inner__AssignListAssignment_2_1_1 )
            // InternalXtextTest.g:2359:2: rule__Inner__AssignListAssignment_2_1_1
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
    // InternalXtextTest.g:2371:1: rule__Inner__Group_2_1__2 : rule__Inner__Group_2_1__2__Impl ;
    public final void rule__Inner__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2375:1: ( rule__Inner__Group_2_1__2__Impl )
            // InternalXtextTest.g:2376:2: rule__Inner__Group_2_1__2__Impl
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
    // InternalXtextTest.g:2382:1: rule__Inner__Group_2_1__2__Impl : ( ( rule__Inner__Group_2_1_2__0 )* ) ;
    public final void rule__Inner__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2386:1: ( ( ( rule__Inner__Group_2_1_2__0 )* ) )
            // InternalXtextTest.g:2388:1: ( ( rule__Inner__Group_2_1_2__0 )* )
            {
            // InternalXtextTest.g:2388:1: ( ( rule__Inner__Group_2_1_2__0 )* )
            // InternalXtextTest.g:2389:1: ( rule__Inner__Group_2_1_2__0 )*
            {
             before(grammarAccess.getInnerAccess().getGroup_2_1_2()); 
            // InternalXtextTest.g:2390:1: ( rule__Inner__Group_2_1_2__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_COMMA) ) {
                    int LA15_2 = input.LA(2);

                    if ( (LA15_2==RULE_LEFTPAREN) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // InternalXtextTest.g:2390:2: rule__Inner__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__Inner__Group_2_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalXtextTest.g:2408:1: rule__Inner__Group_2_1_2__0 : rule__Inner__Group_2_1_2__0__Impl rule__Inner__Group_2_1_2__1 ;
    public final void rule__Inner__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2412:1: ( rule__Inner__Group_2_1_2__0__Impl rule__Inner__Group_2_1_2__1 )
            // InternalXtextTest.g:2413:2: rule__Inner__Group_2_1_2__0__Impl rule__Inner__Group_2_1_2__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalXtextTest.g:2420:1: rule__Inner__Group_2_1_2__0__Impl : ( RULE_COMMA ) ;
    public final void rule__Inner__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2424:1: ( ( RULE_COMMA ) )
            // InternalXtextTest.g:2426:1: ( RULE_COMMA )
            {
            // InternalXtextTest.g:2426:1: ( RULE_COMMA )
            // InternalXtextTest.g:2427:1: RULE_COMMA
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
    // InternalXtextTest.g:2440:1: rule__Inner__Group_2_1_2__1 : rule__Inner__Group_2_1_2__1__Impl ;
    public final void rule__Inner__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2444:1: ( rule__Inner__Group_2_1_2__1__Impl )
            // InternalXtextTest.g:2445:2: rule__Inner__Group_2_1_2__1__Impl
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
    // InternalXtextTest.g:2451:1: rule__Inner__Group_2_1_2__1__Impl : ( ( rule__Inner__AssignListAssignment_2_1_2_1 ) ) ;
    public final void rule__Inner__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2455:1: ( ( ( rule__Inner__AssignListAssignment_2_1_2_1 ) ) )
            // InternalXtextTest.g:2457:1: ( ( rule__Inner__AssignListAssignment_2_1_2_1 ) )
            {
            // InternalXtextTest.g:2457:1: ( ( rule__Inner__AssignListAssignment_2_1_2_1 ) )
            // InternalXtextTest.g:2458:1: ( rule__Inner__AssignListAssignment_2_1_2_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignListAssignment_2_1_2_1()); 
            // InternalXtextTest.g:2459:1: ( rule__Inner__AssignListAssignment_2_1_2_1 )
            // InternalXtextTest.g:2459:2: rule__Inner__AssignListAssignment_2_1_2_1
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
    // InternalXtextTest.g:2475:1: rule__Inner__Group_2_2__0 : rule__Inner__Group_2_2__0__Impl rule__Inner__Group_2_2__1 ;
    public final void rule__Inner__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2479:1: ( rule__Inner__Group_2_2__0__Impl rule__Inner__Group_2_2__1 )
            // InternalXtextTest.g:2480:2: rule__Inner__Group_2_2__0__Impl rule__Inner__Group_2_2__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalXtextTest.g:2487:1: rule__Inner__Group_2_2__0__Impl : ( RULE_ASSIGNASSTRING ) ;
    public final void rule__Inner__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2491:1: ( ( RULE_ASSIGNASSTRING ) )
            // InternalXtextTest.g:2493:1: ( RULE_ASSIGNASSTRING )
            {
            // InternalXtextTest.g:2493:1: ( RULE_ASSIGNASSTRING )
            // InternalXtextTest.g:2494:1: RULE_ASSIGNASSTRING
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
    // InternalXtextTest.g:2507:1: rule__Inner__Group_2_2__1 : rule__Inner__Group_2_2__1__Impl ;
    public final void rule__Inner__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2511:1: ( rule__Inner__Group_2_2__1__Impl )
            // InternalXtextTest.g:2512:2: rule__Inner__Group_2_2__1__Impl
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
    // InternalXtextTest.g:2518:1: rule__Inner__Group_2_2__1__Impl : ( ( rule__Inner__ValueAssignment_2_2_1 ) ) ;
    public final void rule__Inner__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2522:1: ( ( ( rule__Inner__ValueAssignment_2_2_1 ) ) )
            // InternalXtextTest.g:2524:1: ( ( rule__Inner__ValueAssignment_2_2_1 ) )
            {
            // InternalXtextTest.g:2524:1: ( ( rule__Inner__ValueAssignment_2_2_1 ) )
            // InternalXtextTest.g:2525:1: ( rule__Inner__ValueAssignment_2_2_1 )
            {
             before(grammarAccess.getInnerAccess().getValueAssignment_2_2_1()); 
            // InternalXtextTest.g:2526:1: ( rule__Inner__ValueAssignment_2_2_1 )
            // InternalXtextTest.g:2526:2: rule__Inner__ValueAssignment_2_2_1
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
    // InternalXtextTest.g:2542:1: rule__Inner__Group_2_3__0 : rule__Inner__Group_2_3__0__Impl rule__Inner__Group_2_3__1 ;
    public final void rule__Inner__Group_2_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2546:1: ( rule__Inner__Group_2_3__0__Impl rule__Inner__Group_2_3__1 )
            // InternalXtextTest.g:2547:2: rule__Inner__Group_2_3__0__Impl rule__Inner__Group_2_3__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalXtextTest.g:2554:1: rule__Inner__Group_2_3__0__Impl : ( RULE_ASSIGNASDATALIST ) ;
    public final void rule__Inner__Group_2_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2558:1: ( ( RULE_ASSIGNASDATALIST ) )
            // InternalXtextTest.g:2560:1: ( RULE_ASSIGNASDATALIST )
            {
            // InternalXtextTest.g:2560:1: ( RULE_ASSIGNASDATALIST )
            // InternalXtextTest.g:2561:1: RULE_ASSIGNASDATALIST
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
    // InternalXtextTest.g:2574:1: rule__Inner__Group_2_3__1 : rule__Inner__Group_2_3__1__Impl ;
    public final void rule__Inner__Group_2_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2578:1: ( rule__Inner__Group_2_3__1__Impl )
            // InternalXtextTest.g:2579:2: rule__Inner__Group_2_3__1__Impl
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
    // InternalXtextTest.g:2585:1: rule__Inner__Group_2_3__1__Impl : ( ( rule__Inner__AssignAsDataAssignment_2_3_1 ) ) ;
    public final void rule__Inner__Group_2_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2589:1: ( ( ( rule__Inner__AssignAsDataAssignment_2_3_1 ) ) )
            // InternalXtextTest.g:2591:1: ( ( rule__Inner__AssignAsDataAssignment_2_3_1 ) )
            {
            // InternalXtextTest.g:2591:1: ( ( rule__Inner__AssignAsDataAssignment_2_3_1 ) )
            // InternalXtextTest.g:2592:1: ( rule__Inner__AssignAsDataAssignment_2_3_1 )
            {
             before(grammarAccess.getInnerAccess().getAssignAsDataAssignment_2_3_1()); 
            // InternalXtextTest.g:2593:1: ( rule__Inner__AssignAsDataAssignment_2_3_1 )
            // InternalXtextTest.g:2593:2: rule__Inner__AssignAsDataAssignment_2_3_1
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


    // $ANTLR start "rule__Generator__Group__0"
    // InternalXtextTest.g:2609:1: rule__Generator__Group__0 : rule__Generator__Group__0__Impl rule__Generator__Group__1 ;
    public final void rule__Generator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2613:1: ( rule__Generator__Group__0__Impl rule__Generator__Group__1 )
            // InternalXtextTest.g:2614:2: rule__Generator__Group__0__Impl rule__Generator__Group__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalXtextTest.g:2621:1: rule__Generator__Group__0__Impl : ( () ) ;
    public final void rule__Generator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2625:1: ( ( () ) )
            // InternalXtextTest.g:2627:1: ( () )
            {
            // InternalXtextTest.g:2627:1: ( () )
            // InternalXtextTest.g:2628:1: ()
            {
             before(grammarAccess.getGeneratorAccess().getGeneratorAction_0()); 
            // InternalXtextTest.g:2629:1: ()
            // InternalXtextTest.g:2631:1: 
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
    // InternalXtextTest.g:2643:1: rule__Generator__Group__1 : rule__Generator__Group__1__Impl rule__Generator__Group__2 ;
    public final void rule__Generator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2647:1: ( rule__Generator__Group__1__Impl rule__Generator__Group__2 )
            // InternalXtextTest.g:2648:2: rule__Generator__Group__1__Impl rule__Generator__Group__2
            {
            pushFollow(FOLLOW_24);
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
    // InternalXtextTest.g:2655:1: rule__Generator__Group__1__Impl : ( ( rule__Generator__Group_1__0 ) ) ;
    public final void rule__Generator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2659:1: ( ( ( rule__Generator__Group_1__0 ) ) )
            // InternalXtextTest.g:2661:1: ( ( rule__Generator__Group_1__0 ) )
            {
            // InternalXtextTest.g:2661:1: ( ( rule__Generator__Group_1__0 ) )
            // InternalXtextTest.g:2662:1: ( rule__Generator__Group_1__0 )
            {
             before(grammarAccess.getGeneratorAccess().getGroup_1()); 
            // InternalXtextTest.g:2663:1: ( rule__Generator__Group_1__0 )
            // InternalXtextTest.g:2663:2: rule__Generator__Group_1__0
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
    // InternalXtextTest.g:2675:1: rule__Generator__Group__2 : rule__Generator__Group__2__Impl rule__Generator__Group__3 ;
    public final void rule__Generator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2679:1: ( rule__Generator__Group__2__Impl rule__Generator__Group__3 )
            // InternalXtextTest.g:2680:2: rule__Generator__Group__2__Impl rule__Generator__Group__3
            {
            pushFollow(FOLLOW_25);
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
    // InternalXtextTest.g:2687:1: rule__Generator__Group__2__Impl : ( ( rule__Generator__Group_2__0 ) ) ;
    public final void rule__Generator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2691:1: ( ( ( rule__Generator__Group_2__0 ) ) )
            // InternalXtextTest.g:2693:1: ( ( rule__Generator__Group_2__0 ) )
            {
            // InternalXtextTest.g:2693:1: ( ( rule__Generator__Group_2__0 ) )
            // InternalXtextTest.g:2694:1: ( rule__Generator__Group_2__0 )
            {
             before(grammarAccess.getGeneratorAccess().getGroup_2()); 
            // InternalXtextTest.g:2695:1: ( rule__Generator__Group_2__0 )
            // InternalXtextTest.g:2695:2: rule__Generator__Group_2__0
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
    // InternalXtextTest.g:2707:1: rule__Generator__Group__3 : rule__Generator__Group__3__Impl rule__Generator__Group__4 ;
    public final void rule__Generator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2711:1: ( rule__Generator__Group__3__Impl rule__Generator__Group__4 )
            // InternalXtextTest.g:2712:2: rule__Generator__Group__3__Impl rule__Generator__Group__4
            {
            pushFollow(FOLLOW_25);
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
    // InternalXtextTest.g:2719:1: rule__Generator__Group__3__Impl : ( ( rule__Generator__Group_3__0 )? ) ;
    public final void rule__Generator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2723:1: ( ( ( rule__Generator__Group_3__0 )? ) )
            // InternalXtextTest.g:2725:1: ( ( rule__Generator__Group_3__0 )? )
            {
            // InternalXtextTest.g:2725:1: ( ( rule__Generator__Group_3__0 )? )
            // InternalXtextTest.g:2726:1: ( rule__Generator__Group_3__0 )?
            {
             before(grammarAccess.getGeneratorAccess().getGroup_3()); 
            // InternalXtextTest.g:2727:1: ( rule__Generator__Group_3__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_PATTERNS) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalXtextTest.g:2727:2: rule__Generator__Group_3__0
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
    // InternalXtextTest.g:2739:1: rule__Generator__Group__4 : rule__Generator__Group__4__Impl ;
    public final void rule__Generator__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2743:1: ( rule__Generator__Group__4__Impl )
            // InternalXtextTest.g:2744:2: rule__Generator__Group__4__Impl
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
    // InternalXtextTest.g:2750:1: rule__Generator__Group__4__Impl : ( ( rule__Generator__Group_4__0 )? ) ;
    public final void rule__Generator__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2754:1: ( ( ( rule__Generator__Group_4__0 )? ) )
            // InternalXtextTest.g:2756:1: ( ( rule__Generator__Group_4__0 )? )
            {
            // InternalXtextTest.g:2756:1: ( ( rule__Generator__Group_4__0 )? )
            // InternalXtextTest.g:2757:1: ( rule__Generator__Group_4__0 )?
            {
             before(grammarAccess.getGeneratorAccess().getGroup_4()); 
            // InternalXtextTest.g:2758:1: ( rule__Generator__Group_4__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_EXPECTED) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalXtextTest.g:2758:2: rule__Generator__Group_4__0
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
    // InternalXtextTest.g:2780:1: rule__Generator__Group_1__0 : rule__Generator__Group_1__0__Impl rule__Generator__Group_1__1 ;
    public final void rule__Generator__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2784:1: ( rule__Generator__Group_1__0__Impl rule__Generator__Group_1__1 )
            // InternalXtextTest.g:2785:2: rule__Generator__Group_1__0__Impl rule__Generator__Group_1__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalXtextTest.g:2792:1: rule__Generator__Group_1__0__Impl : ( RULE_OUTPUT ) ;
    public final void rule__Generator__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2796:1: ( ( RULE_OUTPUT ) )
            // InternalXtextTest.g:2798:1: ( RULE_OUTPUT )
            {
            // InternalXtextTest.g:2798:1: ( RULE_OUTPUT )
            // InternalXtextTest.g:2799:1: RULE_OUTPUT
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
    // InternalXtextTest.g:2812:1: rule__Generator__Group_1__1 : rule__Generator__Group_1__1__Impl rule__Generator__Group_1__2 ;
    public final void rule__Generator__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2816:1: ( rule__Generator__Group_1__1__Impl rule__Generator__Group_1__2 )
            // InternalXtextTest.g:2817:2: rule__Generator__Group_1__1__Impl rule__Generator__Group_1__2
            {
            pushFollow(FOLLOW_9);
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
    // InternalXtextTest.g:2824:1: rule__Generator__Group_1__1__Impl : ( RULE_FILE ) ;
    public final void rule__Generator__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2828:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:2830:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:2830:1: ( RULE_FILE )
            // InternalXtextTest.g:2831:1: RULE_FILE
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
    // InternalXtextTest.g:2844:1: rule__Generator__Group_1__2 : rule__Generator__Group_1__2__Impl rule__Generator__Group_1__3 ;
    public final void rule__Generator__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2848:1: ( rule__Generator__Group_1__2__Impl rule__Generator__Group_1__3 )
            // InternalXtextTest.g:2849:2: rule__Generator__Group_1__2__Impl rule__Generator__Group_1__3
            {
            pushFollow(FOLLOW_14);
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
    // InternalXtextTest.g:2856:1: rule__Generator__Group_1__2__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Generator__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2860:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:2862:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:2862:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:2863:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:2876:1: rule__Generator__Group_1__3 : rule__Generator__Group_1__3__Impl ;
    public final void rule__Generator__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2880:1: ( rule__Generator__Group_1__3__Impl )
            // InternalXtextTest.g:2881:2: rule__Generator__Group_1__3__Impl
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
    // InternalXtextTest.g:2887:1: rule__Generator__Group_1__3__Impl : ( ( rule__Generator__OutputAssignment_1_3 ) ) ;
    public final void rule__Generator__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2891:1: ( ( ( rule__Generator__OutputAssignment_1_3 ) ) )
            // InternalXtextTest.g:2893:1: ( ( rule__Generator__OutputAssignment_1_3 ) )
            {
            // InternalXtextTest.g:2893:1: ( ( rule__Generator__OutputAssignment_1_3 ) )
            // InternalXtextTest.g:2894:1: ( rule__Generator__OutputAssignment_1_3 )
            {
             before(grammarAccess.getGeneratorAccess().getOutputAssignment_1_3()); 
            // InternalXtextTest.g:2895:1: ( rule__Generator__OutputAssignment_1_3 )
            // InternalXtextTest.g:2895:2: rule__Generator__OutputAssignment_1_3
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
    // InternalXtextTest.g:2915:1: rule__Generator__Group_2__0 : rule__Generator__Group_2__0__Impl rule__Generator__Group_2__1 ;
    public final void rule__Generator__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2919:1: ( rule__Generator__Group_2__0__Impl rule__Generator__Group_2__1 )
            // InternalXtextTest.g:2920:2: rule__Generator__Group_2__0__Impl rule__Generator__Group_2__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalXtextTest.g:2927:1: rule__Generator__Group_2__0__Impl : ( RULE_EXPECTED ) ;
    public final void rule__Generator__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2931:1: ( ( RULE_EXPECTED ) )
            // InternalXtextTest.g:2933:1: ( RULE_EXPECTED )
            {
            // InternalXtextTest.g:2933:1: ( RULE_EXPECTED )
            // InternalXtextTest.g:2934:1: RULE_EXPECTED
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
    // InternalXtextTest.g:2947:1: rule__Generator__Group_2__1 : rule__Generator__Group_2__1__Impl rule__Generator__Group_2__2 ;
    public final void rule__Generator__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2951:1: ( rule__Generator__Group_2__1__Impl rule__Generator__Group_2__2 )
            // InternalXtextTest.g:2952:2: rule__Generator__Group_2__1__Impl rule__Generator__Group_2__2
            {
            pushFollow(FOLLOW_27);
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
    // InternalXtextTest.g:2959:1: rule__Generator__Group_2__1__Impl : ( RULE_FILE ) ;
    public final void rule__Generator__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2963:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:2965:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:2965:1: ( RULE_FILE )
            // InternalXtextTest.g:2966:1: RULE_FILE
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
    // InternalXtextTest.g:2979:1: rule__Generator__Group_2__2 : rule__Generator__Group_2__2__Impl ;
    public final void rule__Generator__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2983:1: ( rule__Generator__Group_2__2__Impl )
            // InternalXtextTest.g:2984:2: rule__Generator__Group_2__2__Impl
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
    // InternalXtextTest.g:2990:1: rule__Generator__Group_2__2__Impl : ( ( rule__Generator__Alternatives_2_2 ) ) ;
    public final void rule__Generator__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:2994:1: ( ( ( rule__Generator__Alternatives_2_2 ) ) )
            // InternalXtextTest.g:2996:1: ( ( rule__Generator__Alternatives_2_2 ) )
            {
            // InternalXtextTest.g:2996:1: ( ( rule__Generator__Alternatives_2_2 ) )
            // InternalXtextTest.g:2997:1: ( rule__Generator__Alternatives_2_2 )
            {
             before(grammarAccess.getGeneratorAccess().getAlternatives_2_2()); 
            // InternalXtextTest.g:2998:1: ( rule__Generator__Alternatives_2_2 )
            // InternalXtextTest.g:2998:2: rule__Generator__Alternatives_2_2
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
    // InternalXtextTest.g:3016:1: rule__Generator__Group_2_2_0__0 : rule__Generator__Group_2_2_0__0__Impl rule__Generator__Group_2_2_0__1 ;
    public final void rule__Generator__Group_2_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3020:1: ( rule__Generator__Group_2_2_0__0__Impl rule__Generator__Group_2_2_0__1 )
            // InternalXtextTest.g:3021:2: rule__Generator__Group_2_2_0__0__Impl rule__Generator__Group_2_2_0__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalXtextTest.g:3028:1: rule__Generator__Group_2_2_0__0__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Generator__Group_2_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3032:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:3034:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:3034:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:3035:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:3048:1: rule__Generator__Group_2_2_0__1 : rule__Generator__Group_2_2_0__1__Impl ;
    public final void rule__Generator__Group_2_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3052:1: ( rule__Generator__Group_2_2_0__1__Impl )
            // InternalXtextTest.g:3053:2: rule__Generator__Group_2_2_0__1__Impl
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
    // InternalXtextTest.g:3059:1: rule__Generator__Group_2_2_0__1__Impl : ( ( rule__Generator__ExpectedAssignment_2_2_0_1 ) ) ;
    public final void rule__Generator__Group_2_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3063:1: ( ( ( rule__Generator__ExpectedAssignment_2_2_0_1 ) ) )
            // InternalXtextTest.g:3065:1: ( ( rule__Generator__ExpectedAssignment_2_2_0_1 ) )
            {
            // InternalXtextTest.g:3065:1: ( ( rule__Generator__ExpectedAssignment_2_2_0_1 ) )
            // InternalXtextTest.g:3066:1: ( rule__Generator__ExpectedAssignment_2_2_0_1 )
            {
             before(grammarAccess.getGeneratorAccess().getExpectedAssignment_2_2_0_1()); 
            // InternalXtextTest.g:3067:1: ( rule__Generator__ExpectedAssignment_2_2_0_1 )
            // InternalXtextTest.g:3067:2: rule__Generator__ExpectedAssignment_2_2_0_1
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
    // InternalXtextTest.g:3083:1: rule__Generator__Group_3__0 : rule__Generator__Group_3__0__Impl rule__Generator__Group_3__1 ;
    public final void rule__Generator__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3087:1: ( rule__Generator__Group_3__0__Impl rule__Generator__Group_3__1 )
            // InternalXtextTest.g:3088:2: rule__Generator__Group_3__0__Impl rule__Generator__Group_3__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalXtextTest.g:3095:1: rule__Generator__Group_3__0__Impl : ( RULE_PATTERNS ) ;
    public final void rule__Generator__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3099:1: ( ( RULE_PATTERNS ) )
            // InternalXtextTest.g:3101:1: ( RULE_PATTERNS )
            {
            // InternalXtextTest.g:3101:1: ( RULE_PATTERNS )
            // InternalXtextTest.g:3102:1: RULE_PATTERNS
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
    // InternalXtextTest.g:3115:1: rule__Generator__Group_3__1 : rule__Generator__Group_3__1__Impl rule__Generator__Group_3__2 ;
    public final void rule__Generator__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3119:1: ( rule__Generator__Group_3__1__Impl rule__Generator__Group_3__2 )
            // InternalXtextTest.g:3120:2: rule__Generator__Group_3__1__Impl rule__Generator__Group_3__2
            {
            pushFollow(FOLLOW_28);
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
    // InternalXtextTest.g:3127:1: rule__Generator__Group_3__1__Impl : ( ( rule__Generator__Group_3_1__0 )? ) ;
    public final void rule__Generator__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3131:1: ( ( ( rule__Generator__Group_3_1__0 )? ) )
            // InternalXtextTest.g:3133:1: ( ( rule__Generator__Group_3_1__0 )? )
            {
            // InternalXtextTest.g:3133:1: ( ( rule__Generator__Group_3_1__0 )? )
            // InternalXtextTest.g:3134:1: ( rule__Generator__Group_3_1__0 )?
            {
             before(grammarAccess.getGeneratorAccess().getGroup_3_1()); 
            // InternalXtextTest.g:3135:1: ( rule__Generator__Group_3_1__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_FILE) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalXtextTest.g:3135:2: rule__Generator__Group_3_1__0
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
    // InternalXtextTest.g:3147:1: rule__Generator__Group_3__2 : rule__Generator__Group_3__2__Impl ;
    public final void rule__Generator__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3151:1: ( rule__Generator__Group_3__2__Impl )
            // InternalXtextTest.g:3152:2: rule__Generator__Group_3__2__Impl
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
    // InternalXtextTest.g:3158:1: rule__Generator__Group_3__2__Impl : ( ( rule__Generator__ReplacePatternsAssignment_3_2 )* ) ;
    public final void rule__Generator__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3162:1: ( ( ( rule__Generator__ReplacePatternsAssignment_3_2 )* ) )
            // InternalXtextTest.g:3164:1: ( ( rule__Generator__ReplacePatternsAssignment_3_2 )* )
            {
            // InternalXtextTest.g:3164:1: ( ( rule__Generator__ReplacePatternsAssignment_3_2 )* )
            // InternalXtextTest.g:3165:1: ( rule__Generator__ReplacePatternsAssignment_3_2 )*
            {
             before(grammarAccess.getGeneratorAccess().getReplacePatternsAssignment_3_2()); 
            // InternalXtextTest.g:3166:1: ( rule__Generator__ReplacePatternsAssignment_3_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_STRING) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalXtextTest.g:3166:2: rule__Generator__ReplacePatternsAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_29);
            	    rule__Generator__ReplacePatternsAssignment_3_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalXtextTest.g:3184:1: rule__Generator__Group_3_1__0 : rule__Generator__Group_3_1__0__Impl rule__Generator__Group_3_1__1 ;
    public final void rule__Generator__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3188:1: ( rule__Generator__Group_3_1__0__Impl rule__Generator__Group_3_1__1 )
            // InternalXtextTest.g:3189:2: rule__Generator__Group_3_1__0__Impl rule__Generator__Group_3_1__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalXtextTest.g:3196:1: rule__Generator__Group_3_1__0__Impl : ( RULE_FILE ) ;
    public final void rule__Generator__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3200:1: ( ( RULE_FILE ) )
            // InternalXtextTest.g:3202:1: ( RULE_FILE )
            {
            // InternalXtextTest.g:3202:1: ( RULE_FILE )
            // InternalXtextTest.g:3203:1: RULE_FILE
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
    // InternalXtextTest.g:3216:1: rule__Generator__Group_3_1__1 : rule__Generator__Group_3_1__1__Impl rule__Generator__Group_3_1__2 ;
    public final void rule__Generator__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3220:1: ( rule__Generator__Group_3_1__1__Impl rule__Generator__Group_3_1__2 )
            // InternalXtextTest.g:3221:2: rule__Generator__Group_3_1__1__Impl rule__Generator__Group_3_1__2
            {
            pushFollow(FOLLOW_14);
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
    // InternalXtextTest.g:3228:1: rule__Generator__Group_3_1__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Generator__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3232:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:3234:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:3234:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:3235:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:3248:1: rule__Generator__Group_3_1__2 : rule__Generator__Group_3_1__2__Impl ;
    public final void rule__Generator__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3252:1: ( rule__Generator__Group_3_1__2__Impl )
            // InternalXtextTest.g:3253:2: rule__Generator__Group_3_1__2__Impl
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
    // InternalXtextTest.g:3259:1: rule__Generator__Group_3_1__2__Impl : ( ( rule__Generator__PatternFileAssignment_3_1_2 ) ) ;
    public final void rule__Generator__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3263:1: ( ( ( rule__Generator__PatternFileAssignment_3_1_2 ) ) )
            // InternalXtextTest.g:3265:1: ( ( rule__Generator__PatternFileAssignment_3_1_2 ) )
            {
            // InternalXtextTest.g:3265:1: ( ( rule__Generator__PatternFileAssignment_3_1_2 ) )
            // InternalXtextTest.g:3266:1: ( rule__Generator__PatternFileAssignment_3_1_2 )
            {
             before(grammarAccess.getGeneratorAccess().getPatternFileAssignment_3_1_2()); 
            // InternalXtextTest.g:3267:1: ( rule__Generator__PatternFileAssignment_3_1_2 )
            // InternalXtextTest.g:3267:2: rule__Generator__PatternFileAssignment_3_1_2
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
    // InternalXtextTest.g:3285:1: rule__Generator__Group_4__0 : rule__Generator__Group_4__0__Impl rule__Generator__Group_4__1 ;
    public final void rule__Generator__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3289:1: ( rule__Generator__Group_4__0__Impl rule__Generator__Group_4__1 )
            // InternalXtextTest.g:3290:2: rule__Generator__Group_4__0__Impl rule__Generator__Group_4__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalXtextTest.g:3297:1: rule__Generator__Group_4__0__Impl : ( RULE_EXPECTED ) ;
    public final void rule__Generator__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3301:1: ( ( RULE_EXPECTED ) )
            // InternalXtextTest.g:3303:1: ( RULE_EXPECTED )
            {
            // InternalXtextTest.g:3303:1: ( RULE_EXPECTED )
            // InternalXtextTest.g:3304:1: RULE_EXPECTED
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
    // InternalXtextTest.g:3317:1: rule__Generator__Group_4__1 : rule__Generator__Group_4__1__Impl rule__Generator__Group_4__2 ;
    public final void rule__Generator__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3321:1: ( rule__Generator__Group_4__1__Impl rule__Generator__Group_4__2 )
            // InternalXtextTest.g:3322:2: rule__Generator__Group_4__1__Impl rule__Generator__Group_4__2
            {
            pushFollow(FOLLOW_4);
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
    // InternalXtextTest.g:3329:1: rule__Generator__Group_4__1__Impl : ( RULE_EXCEPTIONS ) ;
    public final void rule__Generator__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3333:1: ( ( RULE_EXCEPTIONS ) )
            // InternalXtextTest.g:3335:1: ( RULE_EXCEPTIONS )
            {
            // InternalXtextTest.g:3335:1: ( RULE_EXCEPTIONS )
            // InternalXtextTest.g:3336:1: RULE_EXCEPTIONS
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
    // InternalXtextTest.g:3349:1: rule__Generator__Group_4__2 : rule__Generator__Group_4__2__Impl ;
    public final void rule__Generator__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3353:1: ( rule__Generator__Group_4__2__Impl )
            // InternalXtextTest.g:3354:2: rule__Generator__Group_4__2__Impl
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
    // InternalXtextTest.g:3360:1: rule__Generator__Group_4__2__Impl : ( ( rule__Generator__ExceptionAssignment_4_2 ) ) ;
    public final void rule__Generator__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3364:1: ( ( ( rule__Generator__ExceptionAssignment_4_2 ) ) )
            // InternalXtextTest.g:3366:1: ( ( rule__Generator__ExceptionAssignment_4_2 ) )
            {
            // InternalXtextTest.g:3366:1: ( ( rule__Generator__ExceptionAssignment_4_2 ) )
            // InternalXtextTest.g:3367:1: ( rule__Generator__ExceptionAssignment_4_2 )
            {
             before(grammarAccess.getGeneratorAccess().getExceptionAssignment_4_2()); 
            // InternalXtextTest.g:3368:1: ( rule__Generator__ExceptionAssignment_4_2 )
            // InternalXtextTest.g:3368:2: rule__Generator__ExceptionAssignment_4_2
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
    // InternalXtextTest.g:3386:1: rule__ReplacePatterns__Group__0 : rule__ReplacePatterns__Group__0__Impl rule__ReplacePatterns__Group__1 ;
    public final void rule__ReplacePatterns__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3390:1: ( rule__ReplacePatterns__Group__0__Impl rule__ReplacePatterns__Group__1 )
            // InternalXtextTest.g:3391:2: rule__ReplacePatterns__Group__0__Impl rule__ReplacePatterns__Group__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalXtextTest.g:3398:1: rule__ReplacePatterns__Group__0__Impl : ( ( rule__ReplacePatterns__RegexAssignment_0 ) ) ;
    public final void rule__ReplacePatterns__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3402:1: ( ( ( rule__ReplacePatterns__RegexAssignment_0 ) ) )
            // InternalXtextTest.g:3404:1: ( ( rule__ReplacePatterns__RegexAssignment_0 ) )
            {
            // InternalXtextTest.g:3404:1: ( ( rule__ReplacePatterns__RegexAssignment_0 ) )
            // InternalXtextTest.g:3405:1: ( rule__ReplacePatterns__RegexAssignment_0 )
            {
             before(grammarAccess.getReplacePatternsAccess().getRegexAssignment_0()); 
            // InternalXtextTest.g:3406:1: ( rule__ReplacePatterns__RegexAssignment_0 )
            // InternalXtextTest.g:3406:2: rule__ReplacePatterns__RegexAssignment_0
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
    // InternalXtextTest.g:3418:1: rule__ReplacePatterns__Group__1 : rule__ReplacePatterns__Group__1__Impl rule__ReplacePatterns__Group__2 ;
    public final void rule__ReplacePatterns__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3422:1: ( rule__ReplacePatterns__Group__1__Impl rule__ReplacePatterns__Group__2 )
            // InternalXtextTest.g:3423:2: rule__ReplacePatterns__Group__1__Impl rule__ReplacePatterns__Group__2
            {
            pushFollow(FOLLOW_14);
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
    // InternalXtextTest.g:3430:1: rule__ReplacePatterns__Group__1__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__ReplacePatterns__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3434:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:3436:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:3436:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:3437:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:3450:1: rule__ReplacePatterns__Group__2 : rule__ReplacePatterns__Group__2__Impl ;
    public final void rule__ReplacePatterns__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3454:1: ( rule__ReplacePatterns__Group__2__Impl )
            // InternalXtextTest.g:3455:2: rule__ReplacePatterns__Group__2__Impl
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
    // InternalXtextTest.g:3461:1: rule__ReplacePatterns__Group__2__Impl : ( ( rule__ReplacePatterns__ReplaceAssignment_2 ) ) ;
    public final void rule__ReplacePatterns__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3465:1: ( ( ( rule__ReplacePatterns__ReplaceAssignment_2 ) ) )
            // InternalXtextTest.g:3467:1: ( ( rule__ReplacePatterns__ReplaceAssignment_2 ) )
            {
            // InternalXtextTest.g:3467:1: ( ( rule__ReplacePatterns__ReplaceAssignment_2 ) )
            // InternalXtextTest.g:3468:1: ( rule__ReplacePatterns__ReplaceAssignment_2 )
            {
             before(grammarAccess.getReplacePatternsAccess().getReplaceAssignment_2()); 
            // InternalXtextTest.g:3469:1: ( rule__ReplacePatterns__ReplaceAssignment_2 )
            // InternalXtextTest.g:3469:2: rule__ReplacePatterns__ReplaceAssignment_2
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
    // InternalXtextTest.g:3487:1: rule__Before__Group__0 : rule__Before__Group__0__Impl rule__Before__Group__1 ;
    public final void rule__Before__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3491:1: ( rule__Before__Group__0__Impl rule__Before__Group__1 )
            // InternalXtextTest.g:3492:2: rule__Before__Group__0__Impl rule__Before__Group__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalXtextTest.g:3499:1: rule__Before__Group__0__Impl : ( RULE_BEFORE_KW ) ;
    public final void rule__Before__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3503:1: ( ( RULE_BEFORE_KW ) )
            // InternalXtextTest.g:3505:1: ( RULE_BEFORE_KW )
            {
            // InternalXtextTest.g:3505:1: ( RULE_BEFORE_KW )
            // InternalXtextTest.g:3506:1: RULE_BEFORE_KW
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
    // InternalXtextTest.g:3519:1: rule__Before__Group__1 : rule__Before__Group__1__Impl rule__Before__Group__2 ;
    public final void rule__Before__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3523:1: ( rule__Before__Group__1__Impl rule__Before__Group__2 )
            // InternalXtextTest.g:3524:2: rule__Before__Group__1__Impl rule__Before__Group__2
            {
            pushFollow(FOLLOW_9);
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
    // InternalXtextTest.g:3531:1: rule__Before__Group__1__Impl : ( RULE_CLASS_KW ) ;
    public final void rule__Before__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3535:1: ( ( RULE_CLASS_KW ) )
            // InternalXtextTest.g:3537:1: ( RULE_CLASS_KW )
            {
            // InternalXtextTest.g:3537:1: ( RULE_CLASS_KW )
            // InternalXtextTest.g:3538:1: RULE_CLASS_KW
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
    // InternalXtextTest.g:3551:1: rule__Before__Group__2 : rule__Before__Group__2__Impl rule__Before__Group__3 ;
    public final void rule__Before__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3555:1: ( rule__Before__Group__2__Impl rule__Before__Group__3 )
            // InternalXtextTest.g:3556:2: rule__Before__Group__2__Impl rule__Before__Group__3
            {
            pushFollow(FOLLOW_4);
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
    // InternalXtextTest.g:3563:1: rule__Before__Group__2__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Before__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3567:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:3569:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:3569:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:3570:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:3583:1: rule__Before__Group__3 : rule__Before__Group__3__Impl rule__Before__Group__4 ;
    public final void rule__Before__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3587:1: ( rule__Before__Group__3__Impl rule__Before__Group__4 )
            // InternalXtextTest.g:3588:2: rule__Before__Group__3__Impl rule__Before__Group__4
            {
            pushFollow(FOLLOW_32);
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
    // InternalXtextTest.g:3595:1: rule__Before__Group__3__Impl : ( ( rule__Before__MyclassAssignment_3 ) ) ;
    public final void rule__Before__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3599:1: ( ( ( rule__Before__MyclassAssignment_3 ) ) )
            // InternalXtextTest.g:3601:1: ( ( rule__Before__MyclassAssignment_3 ) )
            {
            // InternalXtextTest.g:3601:1: ( ( rule__Before__MyclassAssignment_3 ) )
            // InternalXtextTest.g:3602:1: ( rule__Before__MyclassAssignment_3 )
            {
             before(grammarAccess.getBeforeAccess().getMyclassAssignment_3()); 
            // InternalXtextTest.g:3603:1: ( rule__Before__MyclassAssignment_3 )
            // InternalXtextTest.g:3603:2: rule__Before__MyclassAssignment_3
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
    // InternalXtextTest.g:3615:1: rule__Before__Group__4 : rule__Before__Group__4__Impl rule__Before__Group__5 ;
    public final void rule__Before__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3619:1: ( rule__Before__Group__4__Impl rule__Before__Group__5 )
            // InternalXtextTest.g:3620:2: rule__Before__Group__4__Impl rule__Before__Group__5
            {
            pushFollow(FOLLOW_9);
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
    // InternalXtextTest.g:3627:1: rule__Before__Group__4__Impl : ( RULE_METHOD_KW ) ;
    public final void rule__Before__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3631:1: ( ( RULE_METHOD_KW ) )
            // InternalXtextTest.g:3633:1: ( RULE_METHOD_KW )
            {
            // InternalXtextTest.g:3633:1: ( RULE_METHOD_KW )
            // InternalXtextTest.g:3634:1: RULE_METHOD_KW
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
    // InternalXtextTest.g:3647:1: rule__Before__Group__5 : rule__Before__Group__5__Impl rule__Before__Group__6 ;
    public final void rule__Before__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3651:1: ( rule__Before__Group__5__Impl rule__Before__Group__6 )
            // InternalXtextTest.g:3652:2: rule__Before__Group__5__Impl rule__Before__Group__6
            {
            pushFollow(FOLLOW_4);
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
    // InternalXtextTest.g:3659:1: rule__Before__Group__5__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__Before__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3663:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:3665:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:3665:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:3666:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:3679:1: rule__Before__Group__6 : rule__Before__Group__6__Impl rule__Before__Group__7 ;
    public final void rule__Before__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3683:1: ( rule__Before__Group__6__Impl rule__Before__Group__7 )
            // InternalXtextTest.g:3684:2: rule__Before__Group__6__Impl rule__Before__Group__7
            {
            pushFollow(FOLLOW_33);
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
    // InternalXtextTest.g:3691:1: rule__Before__Group__6__Impl : ( ( rule__Before__MethodAssignment_6 ) ) ;
    public final void rule__Before__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3695:1: ( ( ( rule__Before__MethodAssignment_6 ) ) )
            // InternalXtextTest.g:3697:1: ( ( rule__Before__MethodAssignment_6 ) )
            {
            // InternalXtextTest.g:3697:1: ( ( rule__Before__MethodAssignment_6 ) )
            // InternalXtextTest.g:3698:1: ( rule__Before__MethodAssignment_6 )
            {
             before(grammarAccess.getBeforeAccess().getMethodAssignment_6()); 
            // InternalXtextTest.g:3699:1: ( rule__Before__MethodAssignment_6 )
            // InternalXtextTest.g:3699:2: rule__Before__MethodAssignment_6
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
    // InternalXtextTest.g:3711:1: rule__Before__Group__7 : rule__Before__Group__7__Impl rule__Before__Group__8 ;
    public final void rule__Before__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3715:1: ( rule__Before__Group__7__Impl rule__Before__Group__8 )
            // InternalXtextTest.g:3716:2: rule__Before__Group__7__Impl rule__Before__Group__8
            {
            pushFollow(FOLLOW_34);
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
    // InternalXtextTest.g:3723:1: rule__Before__Group__7__Impl : ( RULE_LEFTPAREN ) ;
    public final void rule__Before__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3727:1: ( ( RULE_LEFTPAREN ) )
            // InternalXtextTest.g:3729:1: ( RULE_LEFTPAREN )
            {
            // InternalXtextTest.g:3729:1: ( RULE_LEFTPAREN )
            // InternalXtextTest.g:3730:1: RULE_LEFTPAREN
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
    // InternalXtextTest.g:3743:1: rule__Before__Group__8 : rule__Before__Group__8__Impl ;
    public final void rule__Before__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3747:1: ( rule__Before__Group__8__Impl )
            // InternalXtextTest.g:3748:2: rule__Before__Group__8__Impl
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
    // InternalXtextTest.g:3754:1: rule__Before__Group__8__Impl : ( RULE_RIGHTPAREN ) ;
    public final void rule__Before__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3758:1: ( ( RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:3760:1: ( RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:3760:1: ( RULE_RIGHTPAREN )
            // InternalXtextTest.g:3761:1: RULE_RIGHTPAREN
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
    // InternalXtextTest.g:3792:1: rule__After__Group__0 : rule__After__Group__0__Impl rule__After__Group__1 ;
    public final void rule__After__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3796:1: ( rule__After__Group__0__Impl rule__After__Group__1 )
            // InternalXtextTest.g:3797:2: rule__After__Group__0__Impl rule__After__Group__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalXtextTest.g:3804:1: rule__After__Group__0__Impl : ( RULE_AFTER_KW ) ;
    public final void rule__After__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3808:1: ( ( RULE_AFTER_KW ) )
            // InternalXtextTest.g:3810:1: ( RULE_AFTER_KW )
            {
            // InternalXtextTest.g:3810:1: ( RULE_AFTER_KW )
            // InternalXtextTest.g:3811:1: RULE_AFTER_KW
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
    // InternalXtextTest.g:3824:1: rule__After__Group__1 : rule__After__Group__1__Impl rule__After__Group__2 ;
    public final void rule__After__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3828:1: ( rule__After__Group__1__Impl rule__After__Group__2 )
            // InternalXtextTest.g:3829:2: rule__After__Group__1__Impl rule__After__Group__2
            {
            pushFollow(FOLLOW_9);
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
    // InternalXtextTest.g:3836:1: rule__After__Group__1__Impl : ( RULE_CLASS_KW ) ;
    public final void rule__After__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3840:1: ( ( RULE_CLASS_KW ) )
            // InternalXtextTest.g:3842:1: ( RULE_CLASS_KW )
            {
            // InternalXtextTest.g:3842:1: ( RULE_CLASS_KW )
            // InternalXtextTest.g:3843:1: RULE_CLASS_KW
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
    // InternalXtextTest.g:3856:1: rule__After__Group__2 : rule__After__Group__2__Impl rule__After__Group__3 ;
    public final void rule__After__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3860:1: ( rule__After__Group__2__Impl rule__After__Group__3 )
            // InternalXtextTest.g:3861:2: rule__After__Group__2__Impl rule__After__Group__3
            {
            pushFollow(FOLLOW_4);
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
    // InternalXtextTest.g:3868:1: rule__After__Group__2__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__After__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3872:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:3874:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:3874:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:3875:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:3888:1: rule__After__Group__3 : rule__After__Group__3__Impl rule__After__Group__4 ;
    public final void rule__After__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3892:1: ( rule__After__Group__3__Impl rule__After__Group__4 )
            // InternalXtextTest.g:3893:2: rule__After__Group__3__Impl rule__After__Group__4
            {
            pushFollow(FOLLOW_32);
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
    // InternalXtextTest.g:3900:1: rule__After__Group__3__Impl : ( ( rule__After__MyclassAssignment_3 ) ) ;
    public final void rule__After__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3904:1: ( ( ( rule__After__MyclassAssignment_3 ) ) )
            // InternalXtextTest.g:3906:1: ( ( rule__After__MyclassAssignment_3 ) )
            {
            // InternalXtextTest.g:3906:1: ( ( rule__After__MyclassAssignment_3 ) )
            // InternalXtextTest.g:3907:1: ( rule__After__MyclassAssignment_3 )
            {
             before(grammarAccess.getAfterAccess().getMyclassAssignment_3()); 
            // InternalXtextTest.g:3908:1: ( rule__After__MyclassAssignment_3 )
            // InternalXtextTest.g:3908:2: rule__After__MyclassAssignment_3
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
    // InternalXtextTest.g:3920:1: rule__After__Group__4 : rule__After__Group__4__Impl rule__After__Group__5 ;
    public final void rule__After__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3924:1: ( rule__After__Group__4__Impl rule__After__Group__5 )
            // InternalXtextTest.g:3925:2: rule__After__Group__4__Impl rule__After__Group__5
            {
            pushFollow(FOLLOW_9);
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
    // InternalXtextTest.g:3932:1: rule__After__Group__4__Impl : ( RULE_METHOD_KW ) ;
    public final void rule__After__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3936:1: ( ( RULE_METHOD_KW ) )
            // InternalXtextTest.g:3938:1: ( RULE_METHOD_KW )
            {
            // InternalXtextTest.g:3938:1: ( RULE_METHOD_KW )
            // InternalXtextTest.g:3939:1: RULE_METHOD_KW
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
    // InternalXtextTest.g:3952:1: rule__After__Group__5 : rule__After__Group__5__Impl rule__After__Group__6 ;
    public final void rule__After__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3956:1: ( rule__After__Group__5__Impl rule__After__Group__6 )
            // InternalXtextTest.g:3957:2: rule__After__Group__5__Impl rule__After__Group__6
            {
            pushFollow(FOLLOW_4);
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
    // InternalXtextTest.g:3964:1: rule__After__Group__5__Impl : ( RULE_ASSIGNASSINGLE ) ;
    public final void rule__After__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3968:1: ( ( RULE_ASSIGNASSINGLE ) )
            // InternalXtextTest.g:3970:1: ( RULE_ASSIGNASSINGLE )
            {
            // InternalXtextTest.g:3970:1: ( RULE_ASSIGNASSINGLE )
            // InternalXtextTest.g:3971:1: RULE_ASSIGNASSINGLE
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
    // InternalXtextTest.g:3984:1: rule__After__Group__6 : rule__After__Group__6__Impl rule__After__Group__7 ;
    public final void rule__After__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:3988:1: ( rule__After__Group__6__Impl rule__After__Group__7 )
            // InternalXtextTest.g:3989:2: rule__After__Group__6__Impl rule__After__Group__7
            {
            pushFollow(FOLLOW_33);
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
    // InternalXtextTest.g:3996:1: rule__After__Group__6__Impl : ( ( rule__After__MethodAssignment_6 ) ) ;
    public final void rule__After__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4000:1: ( ( ( rule__After__MethodAssignment_6 ) ) )
            // InternalXtextTest.g:4002:1: ( ( rule__After__MethodAssignment_6 ) )
            {
            // InternalXtextTest.g:4002:1: ( ( rule__After__MethodAssignment_6 ) )
            // InternalXtextTest.g:4003:1: ( rule__After__MethodAssignment_6 )
            {
             before(grammarAccess.getAfterAccess().getMethodAssignment_6()); 
            // InternalXtextTest.g:4004:1: ( rule__After__MethodAssignment_6 )
            // InternalXtextTest.g:4004:2: rule__After__MethodAssignment_6
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
    // InternalXtextTest.g:4016:1: rule__After__Group__7 : rule__After__Group__7__Impl rule__After__Group__8 ;
    public final void rule__After__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4020:1: ( rule__After__Group__7__Impl rule__After__Group__8 )
            // InternalXtextTest.g:4021:2: rule__After__Group__7__Impl rule__After__Group__8
            {
            pushFollow(FOLLOW_34);
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
    // InternalXtextTest.g:4028:1: rule__After__Group__7__Impl : ( RULE_LEFTPAREN ) ;
    public final void rule__After__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4032:1: ( ( RULE_LEFTPAREN ) )
            // InternalXtextTest.g:4034:1: ( RULE_LEFTPAREN )
            {
            // InternalXtextTest.g:4034:1: ( RULE_LEFTPAREN )
            // InternalXtextTest.g:4035:1: RULE_LEFTPAREN
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
    // InternalXtextTest.g:4048:1: rule__After__Group__8 : rule__After__Group__8__Impl ;
    public final void rule__After__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4052:1: ( rule__After__Group__8__Impl )
            // InternalXtextTest.g:4053:2: rule__After__Group__8__Impl
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
    // InternalXtextTest.g:4059:1: rule__After__Group__8__Impl : ( RULE_RIGHTPAREN ) ;
    public final void rule__After__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4063:1: ( ( RULE_RIGHTPAREN ) )
            // InternalXtextTest.g:4065:1: ( RULE_RIGHTPAREN )
            {
            // InternalXtextTest.g:4065:1: ( RULE_RIGHTPAREN )
            // InternalXtextTest.g:4066:1: RULE_RIGHTPAREN
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


    // $ANTLR start "rule__XtextTest__PackageAssignment_2"
    // InternalXtextTest.g:4098:1: rule__XtextTest__PackageAssignment_2 : ( rulePackageID ) ;
    public final void rule__XtextTest__PackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4102:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:4103:1: ( rulePackageID )
            {
            // InternalXtextTest.g:4103:1: ( rulePackageID )
            // InternalXtextTest.g:4104:1: rulePackageID
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
    // InternalXtextTest.g:4113:1: rule__XtextTest__LangAssignment_4 : ( ruleLangID ) ;
    public final void rule__XtextTest__LangAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4117:1: ( ( ruleLangID ) )
            // InternalXtextTest.g:4118:1: ( ruleLangID )
            {
            // InternalXtextTest.g:4118:1: ( ruleLangID )
            // InternalXtextTest.g:4119:1: ruleLangID
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


    // $ANTLR start "rule__XtextTest__BooleanAssignment_5_2"
    // InternalXtextTest.g:4128:1: rule__XtextTest__BooleanAssignment_5_2 : ( ruleBoolean ) ;
    public final void rule__XtextTest__BooleanAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4132:1: ( ( ruleBoolean ) )
            // InternalXtextTest.g:4133:1: ( ruleBoolean )
            {
            // InternalXtextTest.g:4133:1: ( ruleBoolean )
            // InternalXtextTest.g:4134:1: ruleBoolean
            {
             before(grammarAccess.getXtextTestAccess().getBooleanBooleanParserRuleCall_5_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBoolean();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getBooleanBooleanParserRuleCall_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__BooleanAssignment_5_2"


    // $ANTLR start "rule__XtextTest__InputAssignment_6"
    // InternalXtextTest.g:4143:1: rule__XtextTest__InputAssignment_6 : ( ruleInput ) ;
    public final void rule__XtextTest__InputAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4147:1: ( ( ruleInput ) )
            // InternalXtextTest.g:4148:1: ( ruleInput )
            {
            // InternalXtextTest.g:4148:1: ( ruleInput )
            // InternalXtextTest.g:4149:1: ruleInput
            {
             before(grammarAccess.getXtextTestAccess().getInputInputParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleInput();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getInputInputParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__InputAssignment_6"


    // $ANTLR start "rule__XtextTest__TokensAssignment_7"
    // InternalXtextTest.g:4158:1: rule__XtextTest__TokensAssignment_7 : ( ruleTokens ) ;
    public final void rule__XtextTest__TokensAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4162:1: ( ( ruleTokens ) )
            // InternalXtextTest.g:4163:1: ( ruleTokens )
            {
            // InternalXtextTest.g:4163:1: ( ruleTokens )
            // InternalXtextTest.g:4164:1: ruleTokens
            {
             before(grammarAccess.getXtextTestAccess().getTokensTokensParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleTokens();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getTokensTokensParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__TokensAssignment_7"


    // $ANTLR start "rule__XtextTest__RootAssignment_8"
    // InternalXtextTest.g:4173:1: rule__XtextTest__RootAssignment_8 : ( ruleElement ) ;
    public final void rule__XtextTest__RootAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4177:1: ( ( ruleElement ) )
            // InternalXtextTest.g:4178:1: ( ruleElement )
            {
            // InternalXtextTest.g:4178:1: ( ruleElement )
            // InternalXtextTest.g:4179:1: ruleElement
            {
             before(grammarAccess.getXtextTestAccess().getRootElementParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getRootElementParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__RootAssignment_8"


    // $ANTLR start "rule__XtextTest__OutputAssignment_9"
    // InternalXtextTest.g:4188:1: rule__XtextTest__OutputAssignment_9 : ( ruleGenerator ) ;
    public final void rule__XtextTest__OutputAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4192:1: ( ( ruleGenerator ) )
            // InternalXtextTest.g:4193:1: ( ruleGenerator )
            {
            // InternalXtextTest.g:4193:1: ( ruleGenerator )
            // InternalXtextTest.g:4194:1: ruleGenerator
            {
             before(grammarAccess.getXtextTestAccess().getOutputGeneratorParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleGenerator();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getOutputGeneratorParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__OutputAssignment_9"


    // $ANTLR start "rule__XtextTest__BeforeAssignment_10"
    // InternalXtextTest.g:4203:1: rule__XtextTest__BeforeAssignment_10 : ( ruleBefore ) ;
    public final void rule__XtextTest__BeforeAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4207:1: ( ( ruleBefore ) )
            // InternalXtextTest.g:4208:1: ( ruleBefore )
            {
            // InternalXtextTest.g:4208:1: ( ruleBefore )
            // InternalXtextTest.g:4209:1: ruleBefore
            {
             before(grammarAccess.getXtextTestAccess().getBeforeBeforeParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleBefore();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getBeforeBeforeParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__BeforeAssignment_10"


    // $ANTLR start "rule__XtextTest__AfterAssignment_11"
    // InternalXtextTest.g:4218:1: rule__XtextTest__AfterAssignment_11 : ( ruleAfter ) ;
    public final void rule__XtextTest__AfterAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4222:1: ( ( ruleAfter ) )
            // InternalXtextTest.g:4223:1: ( ruleAfter )
            {
            // InternalXtextTest.g:4223:1: ( ruleAfter )
            // InternalXtextTest.g:4224:1: ruleAfter
            {
             before(grammarAccess.getXtextTestAccess().getAfterAfterParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleAfter();

            state._fsp--;

             after(grammarAccess.getXtextTestAccess().getAfterAfterParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XtextTest__AfterAssignment_11"


    // $ANTLR start "rule__Input__TextAssignment_2_0_2"
    // InternalXtextTest.g:4233:1: rule__Input__TextAssignment_2_0_2 : ( RULE_STRING ) ;
    public final void rule__Input__TextAssignment_2_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4237:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:4238:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:4238:1: ( RULE_STRING )
            // InternalXtextTest.g:4239:1: RULE_STRING
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
    // InternalXtextTest.g:4248:1: rule__Input__FileAssignment_2_1_2 : ( RULE_STRING ) ;
    public final void rule__Input__FileAssignment_2_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4252:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:4253:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:4253:1: ( RULE_STRING )
            // InternalXtextTest.g:4254:1: RULE_STRING
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
    // InternalXtextTest.g:4263:1: rule__Tokens__TokensAssignment_2 : ( ruleMyTokens ) ;
    public final void rule__Tokens__TokensAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4267:1: ( ( ruleMyTokens ) )
            // InternalXtextTest.g:4268:1: ( ruleMyTokens )
            {
            // InternalXtextTest.g:4268:1: ( ruleMyTokens )
            // InternalXtextTest.g:4269:1: ruleMyTokens
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
    // InternalXtextTest.g:4278:1: rule__MyTokens__TokenAssignment_0 : ( RULE_IDENTIFIER ) ;
    public final void rule__MyTokens__TokenAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4282:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:4283:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:4283:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:4284:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:4293:1: rule__MyTokens__CountAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__MyTokens__CountAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4297:1: ( ( RULE_INT ) )
            // InternalXtextTest.g:4298:1: ( RULE_INT )
            {
            // InternalXtextTest.g:4298:1: ( RULE_INT )
            // InternalXtextTest.g:4299:1: RULE_INT
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


    // $ANTLR start "rule__Element__NameAssignment_2"
    // InternalXtextTest.g:4308:1: rule__Element__NameAssignment_2 : ( RULE_IDENTIFIER ) ;
    public final void rule__Element__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4312:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:4313:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:4313:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:4314:1: RULE_IDENTIFIER
            {
             before(grammarAccess.getElementAccess().getNameIDENTIFIERTerminalRuleCall_2_0()); 
            match(input,RULE_IDENTIFIER,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getNameIDENTIFIERTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__NameAssignment_2"


    // $ANTLR start "rule__Element__InnerAssignment_3_0"
    // InternalXtextTest.g:4323:1: rule__Element__InnerAssignment_3_0 : ( ruleInner ) ;
    public final void rule__Element__InnerAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4327:1: ( ( ruleInner ) )
            // InternalXtextTest.g:4328:1: ( ruleInner )
            {
            // InternalXtextTest.g:4328:1: ( ruleInner )
            // InternalXtextTest.g:4329:1: ruleInner
            {
             before(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleInner();

            state._fsp--;

             after(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__InnerAssignment_3_0"


    // $ANTLR start "rule__Element__InnerAssignment_3_1_1"
    // InternalXtextTest.g:4338:1: rule__Element__InnerAssignment_3_1_1 : ( ruleInner ) ;
    public final void rule__Element__InnerAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4342:1: ( ( ruleInner ) )
            // InternalXtextTest.g:4343:1: ( ruleInner )
            {
            // InternalXtextTest.g:4343:1: ( ruleInner )
            // InternalXtextTest.g:4344:1: ruleInner
            {
             before(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleInner();

            state._fsp--;

             after(grammarAccess.getElementAccess().getInnerInnerParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__InnerAssignment_3_1_1"


    // $ANTLR start "rule__Inner__ParameterAssignment_1"
    // InternalXtextTest.g:4353:1: rule__Inner__ParameterAssignment_1 : ( RULE_IDENTIFIER ) ;
    public final void rule__Inner__ParameterAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4357:1: ( ( RULE_IDENTIFIER ) )
            // InternalXtextTest.g:4358:1: ( RULE_IDENTIFIER )
            {
            // InternalXtextTest.g:4358:1: ( RULE_IDENTIFIER )
            // InternalXtextTest.g:4359:1: RULE_IDENTIFIER
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
    // InternalXtextTest.g:4368:1: rule__Inner__AssignAssignment_2_0_1 : ( ruleElement ) ;
    public final void rule__Inner__AssignAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4372:1: ( ( ruleElement ) )
            // InternalXtextTest.g:4373:1: ( ruleElement )
            {
            // InternalXtextTest.g:4373:1: ( ruleElement )
            // InternalXtextTest.g:4374:1: ruleElement
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
    // InternalXtextTest.g:4383:1: rule__Inner__AssignListAssignment_2_1_1 : ( ruleElement ) ;
    public final void rule__Inner__AssignListAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4387:1: ( ( ruleElement ) )
            // InternalXtextTest.g:4388:1: ( ruleElement )
            {
            // InternalXtextTest.g:4388:1: ( ruleElement )
            // InternalXtextTest.g:4389:1: ruleElement
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
    // InternalXtextTest.g:4398:1: rule__Inner__AssignListAssignment_2_1_2_1 : ( ruleElement ) ;
    public final void rule__Inner__AssignListAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4402:1: ( ( ruleElement ) )
            // InternalXtextTest.g:4403:1: ( ruleElement )
            {
            // InternalXtextTest.g:4403:1: ( ruleElement )
            // InternalXtextTest.g:4404:1: ruleElement
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
    // InternalXtextTest.g:4413:1: rule__Inner__ValueAssignment_2_2_1 : ( RULE_STRING ) ;
    public final void rule__Inner__ValueAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4417:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:4418:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:4418:1: ( RULE_STRING )
            // InternalXtextTest.g:4419:1: RULE_STRING
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
    // InternalXtextTest.g:4428:1: rule__Inner__AssignAsDataAssignment_2_3_1 : ( RULE_STRING ) ;
    public final void rule__Inner__AssignAsDataAssignment_2_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4432:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:4433:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:4433:1: ( RULE_STRING )
            // InternalXtextTest.g:4434:1: RULE_STRING
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


    // $ANTLR start "rule__Generator__OutputAssignment_1_3"
    // InternalXtextTest.g:4443:1: rule__Generator__OutputAssignment_1_3 : ( RULE_STRING ) ;
    public final void rule__Generator__OutputAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4447:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:4448:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:4448:1: ( RULE_STRING )
            // InternalXtextTest.g:4449:1: RULE_STRING
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
    // InternalXtextTest.g:4458:1: rule__Generator__ExpectedAssignment_2_2_0_1 : ( RULE_STRING ) ;
    public final void rule__Generator__ExpectedAssignment_2_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4462:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:4463:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:4463:1: ( RULE_STRING )
            // InternalXtextTest.g:4464:1: RULE_STRING
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
    // InternalXtextTest.g:4473:1: rule__Generator__IsSameAsInputFileAssignment_2_2_1 : ( RULE_ISSAMEASINPUTFILE ) ;
    public final void rule__Generator__IsSameAsInputFileAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4477:1: ( ( RULE_ISSAMEASINPUTFILE ) )
            // InternalXtextTest.g:4478:1: ( RULE_ISSAMEASINPUTFILE )
            {
            // InternalXtextTest.g:4478:1: ( RULE_ISSAMEASINPUTFILE )
            // InternalXtextTest.g:4479:1: RULE_ISSAMEASINPUTFILE
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
    // InternalXtextTest.g:4488:1: rule__Generator__PatternFileAssignment_3_1_2 : ( RULE_STRING ) ;
    public final void rule__Generator__PatternFileAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4492:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:4493:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:4493:1: ( RULE_STRING )
            // InternalXtextTest.g:4494:1: RULE_STRING
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
    // InternalXtextTest.g:4503:1: rule__Generator__ReplacePatternsAssignment_3_2 : ( ruleReplacePatterns ) ;
    public final void rule__Generator__ReplacePatternsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4507:1: ( ( ruleReplacePatterns ) )
            // InternalXtextTest.g:4508:1: ( ruleReplacePatterns )
            {
            // InternalXtextTest.g:4508:1: ( ruleReplacePatterns )
            // InternalXtextTest.g:4509:1: ruleReplacePatterns
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
    // InternalXtextTest.g:4518:1: rule__Generator__ExceptionAssignment_4_2 : ( rulePackageID ) ;
    public final void rule__Generator__ExceptionAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4522:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:4523:1: ( rulePackageID )
            {
            // InternalXtextTest.g:4523:1: ( rulePackageID )
            // InternalXtextTest.g:4524:1: rulePackageID
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
    // InternalXtextTest.g:4533:1: rule__ReplacePatterns__RegexAssignment_0 : ( RULE_STRING ) ;
    public final void rule__ReplacePatterns__RegexAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4537:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:4538:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:4538:1: ( RULE_STRING )
            // InternalXtextTest.g:4539:1: RULE_STRING
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
    // InternalXtextTest.g:4548:1: rule__ReplacePatterns__ReplaceAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ReplacePatterns__ReplaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4552:1: ( ( RULE_STRING ) )
            // InternalXtextTest.g:4553:1: ( RULE_STRING )
            {
            // InternalXtextTest.g:4553:1: ( RULE_STRING )
            // InternalXtextTest.g:4554:1: RULE_STRING
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
    // InternalXtextTest.g:4563:1: rule__Before__MyclassAssignment_3 : ( rulePackageID ) ;
    public final void rule__Before__MyclassAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4567:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:4568:1: ( rulePackageID )
            {
            // InternalXtextTest.g:4568:1: ( rulePackageID )
            // InternalXtextTest.g:4569:1: rulePackageID
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
    // InternalXtextTest.g:4578:1: rule__Before__MethodAssignment_6 : ( rulePackageID ) ;
    public final void rule__Before__MethodAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4582:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:4583:1: ( rulePackageID )
            {
            // InternalXtextTest.g:4583:1: ( rulePackageID )
            // InternalXtextTest.g:4584:1: rulePackageID
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
    // InternalXtextTest.g:4593:1: rule__After__MyclassAssignment_3 : ( rulePackageID ) ;
    public final void rule__After__MyclassAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4597:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:4598:1: ( rulePackageID )
            {
            // InternalXtextTest.g:4598:1: ( rulePackageID )
            // InternalXtextTest.g:4599:1: rulePackageID
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
    // InternalXtextTest.g:4608:1: rule__After__MethodAssignment_6 : ( rulePackageID ) ;
    public final void rule__After__MethodAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalXtextTest.g:4612:1: ( ( rulePackageID ) )
            // InternalXtextTest.g:4613:1: ( rulePackageID )
            {
            // InternalXtextTest.g:4613:1: ( rulePackageID )
            // InternalXtextTest.g:4614:1: rulePackageID
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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000480L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000009100000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000000000C4100L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000040000100L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000010000L});

}