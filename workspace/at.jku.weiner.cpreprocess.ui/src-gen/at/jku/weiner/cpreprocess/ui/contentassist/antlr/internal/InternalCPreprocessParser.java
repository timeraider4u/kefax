package at.jku.weiner.cpreprocess.ui.contentassist.antlr.internal; 

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
import at.jku.weiner.cpreprocess.services.CPreprocessGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalCPreprocessParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NEWLINE", "RULE_MYCODE", "RULE_HASH", "RULE_BACKSLASH", "RULE_WHITESPACE", "'include'"
    };
    public static final int RULE_NEWLINE=4;
    public static final int RULE_BACKSLASH=7;
    public static final int RULE_HASH=6;
    public static final int RULE_WHITESPACE=8;
    public static final int RULE_MYCODE=5;
    public static final int EOF=-1;
    public static final int T__9=9;

    // delegates
    // delegators


        public InternalCPreprocessParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCPreprocessParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCPreprocessParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCPreprocess.g"; }


     
     	private CPreprocessGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(CPreprocessGrammarAccess grammarAccess) {
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
    // InternalCPreprocess.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalCPreprocess.g:62:1: ( ruleModel EOF )
            // InternalCPreprocess.g:63:1: ruleModel EOF
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
    // InternalCPreprocess.g:70:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalCPreprocess.g:77:7: ( ( ( rule__Model__Group__0 ) ) )
            // InternalCPreprocess.g:79:1: ( ( rule__Model__Group__0 ) )
            {
            // InternalCPreprocess.g:79:1: ( ( rule__Model__Group__0 ) )
            // InternalCPreprocess.g:80:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalCPreprocess.g:81:1: ( rule__Model__Group__0 )
            // InternalCPreprocess.g:81:2: rule__Model__Group__0
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


    // $ANTLR start "entryRuleTranslationUnit"
    // InternalCPreprocess.g:95:1: entryRuleTranslationUnit : ruleTranslationUnit EOF ;
    public final void entryRuleTranslationUnit() throws RecognitionException {
        try {
            // InternalCPreprocess.g:96:1: ( ruleTranslationUnit EOF )
            // InternalCPreprocess.g:97:1: ruleTranslationUnit EOF
            {
             before(grammarAccess.getTranslationUnitRule()); 
            pushFollow(FOLLOW_1);
            ruleTranslationUnit();

            state._fsp--;

             after(grammarAccess.getTranslationUnitRule()); 
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
    // $ANTLR end "entryRuleTranslationUnit"


    // $ANTLR start "ruleTranslationUnit"
    // InternalCPreprocess.g:104:1: ruleTranslationUnit : ( ( rule__TranslationUnit__Group__0 ) ) ;
    public final void ruleTranslationUnit() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalCPreprocess.g:111:7: ( ( ( rule__TranslationUnit__Group__0 ) ) )
            // InternalCPreprocess.g:113:1: ( ( rule__TranslationUnit__Group__0 ) )
            {
            // InternalCPreprocess.g:113:1: ( ( rule__TranslationUnit__Group__0 ) )
            // InternalCPreprocess.g:114:1: ( rule__TranslationUnit__Group__0 )
            {
             before(grammarAccess.getTranslationUnitAccess().getGroup()); 
            // InternalCPreprocess.g:115:1: ( rule__TranslationUnit__Group__0 )
            // InternalCPreprocess.g:115:2: rule__TranslationUnit__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TranslationUnit__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTranslationUnitAccess().getGroup()); 

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
    // $ANTLR end "ruleTranslationUnit"


    // $ANTLR start "entryRuleIncludeDirective"
    // InternalCPreprocess.g:131:1: entryRuleIncludeDirective : ruleIncludeDirective EOF ;
    public final void entryRuleIncludeDirective() throws RecognitionException {
        try {
            // InternalCPreprocess.g:132:1: ( ruleIncludeDirective EOF )
            // InternalCPreprocess.g:133:1: ruleIncludeDirective EOF
            {
             before(grammarAccess.getIncludeDirectiveRule()); 
            pushFollow(FOLLOW_1);
            ruleIncludeDirective();

            state._fsp--;

             after(grammarAccess.getIncludeDirectiveRule()); 
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
    // $ANTLR end "entryRuleIncludeDirective"


    // $ANTLR start "ruleIncludeDirective"
    // InternalCPreprocess.g:140:1: ruleIncludeDirective : ( ( rule__IncludeDirective__Group__0 ) ) ;
    public final void ruleIncludeDirective() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalCPreprocess.g:147:7: ( ( ( rule__IncludeDirective__Group__0 ) ) )
            // InternalCPreprocess.g:149:1: ( ( rule__IncludeDirective__Group__0 ) )
            {
            // InternalCPreprocess.g:149:1: ( ( rule__IncludeDirective__Group__0 ) )
            // InternalCPreprocess.g:150:1: ( rule__IncludeDirective__Group__0 )
            {
             before(grammarAccess.getIncludeDirectiveAccess().getGroup()); 
            // InternalCPreprocess.g:151:1: ( rule__IncludeDirective__Group__0 )
            // InternalCPreprocess.g:151:2: rule__IncludeDirective__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IncludeDirective__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIncludeDirectiveAccess().getGroup()); 

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
    // $ANTLR end "ruleIncludeDirective"


    // $ANTLR start "entryRuleNewLineLine"
    // InternalCPreprocess.g:165:1: entryRuleNewLineLine : ruleNewLineLine EOF ;
    public final void entryRuleNewLineLine() throws RecognitionException {
        try {
            // InternalCPreprocess.g:166:1: ( ruleNewLineLine EOF )
            // InternalCPreprocess.g:167:1: ruleNewLineLine EOF
            {
             before(grammarAccess.getNewLineLineRule()); 
            pushFollow(FOLLOW_1);
            ruleNewLineLine();

            state._fsp--;

             after(grammarAccess.getNewLineLineRule()); 
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
    // $ANTLR end "entryRuleNewLineLine"


    // $ANTLR start "ruleNewLineLine"
    // InternalCPreprocess.g:174:1: ruleNewLineLine : ( ( rule__NewLineLine__Group__0 ) ) ;
    public final void ruleNewLineLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalCPreprocess.g:181:7: ( ( ( rule__NewLineLine__Group__0 ) ) )
            // InternalCPreprocess.g:183:1: ( ( rule__NewLineLine__Group__0 ) )
            {
            // InternalCPreprocess.g:183:1: ( ( rule__NewLineLine__Group__0 ) )
            // InternalCPreprocess.g:184:1: ( rule__NewLineLine__Group__0 )
            {
             before(grammarAccess.getNewLineLineAccess().getGroup()); 
            // InternalCPreprocess.g:185:1: ( rule__NewLineLine__Group__0 )
            // InternalCPreprocess.g:185:2: rule__NewLineLine__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NewLineLine__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNewLineLineAccess().getGroup()); 

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
    // $ANTLR end "ruleNewLineLine"


    // $ANTLR start "entryRuleCode"
    // InternalCPreprocess.g:199:1: entryRuleCode : ruleCode EOF ;
    public final void entryRuleCode() throws RecognitionException {
        try {
            // InternalCPreprocess.g:200:1: ( ruleCode EOF )
            // InternalCPreprocess.g:201:1: ruleCode EOF
            {
             before(grammarAccess.getCodeRule()); 
            pushFollow(FOLLOW_1);
            ruleCode();

            state._fsp--;

             after(grammarAccess.getCodeRule()); 
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
    // $ANTLR end "entryRuleCode"


    // $ANTLR start "ruleCode"
    // InternalCPreprocess.g:208:1: ruleCode : ( ( rule__Code__Group__0 ) ) ;
    public final void ruleCode() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalCPreprocess.g:215:7: ( ( ( rule__Code__Group__0 ) ) )
            // InternalCPreprocess.g:217:1: ( ( rule__Code__Group__0 ) )
            {
            // InternalCPreprocess.g:217:1: ( ( rule__Code__Group__0 ) )
            // InternalCPreprocess.g:218:1: ( rule__Code__Group__0 )
            {
             before(grammarAccess.getCodeAccess().getGroup()); 
            // InternalCPreprocess.g:219:1: ( rule__Code__Group__0 )
            // InternalCPreprocess.g:219:2: rule__Code__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Code__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCodeAccess().getGroup()); 

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
    // $ANTLR end "ruleCode"


    // $ANTLR start "rule__TranslationUnit__Alternatives_1"
    // InternalCPreprocess.g:233:1: rule__TranslationUnit__Alternatives_1 : ( ( ( rule__TranslationUnit__LinesAssignment_1_0 ) ) | ( ( rule__TranslationUnit__LinesAssignment_1_1 ) ) );
    public final void rule__TranslationUnit__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:237:1: ( ( ( rule__TranslationUnit__LinesAssignment_1_0 ) ) | ( ( rule__TranslationUnit__LinesAssignment_1_1 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_NEWLINE) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_MYCODE) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalCPreprocess.g:239:1: ( ( rule__TranslationUnit__LinesAssignment_1_0 ) )
                    {
                    // InternalCPreprocess.g:239:1: ( ( rule__TranslationUnit__LinesAssignment_1_0 ) )
                    // InternalCPreprocess.g:240:1: ( rule__TranslationUnit__LinesAssignment_1_0 )
                    {
                     before(grammarAccess.getTranslationUnitAccess().getLinesAssignment_1_0()); 
                    // InternalCPreprocess.g:241:1: ( rule__TranslationUnit__LinesAssignment_1_0 )
                    // InternalCPreprocess.g:241:2: rule__TranslationUnit__LinesAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TranslationUnit__LinesAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTranslationUnitAccess().getLinesAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalCPreprocess.g:248:1: ( ( rule__TranslationUnit__LinesAssignment_1_1 ) )
                    {
                    // InternalCPreprocess.g:248:1: ( ( rule__TranslationUnit__LinesAssignment_1_1 ) )
                    // InternalCPreprocess.g:249:1: ( rule__TranslationUnit__LinesAssignment_1_1 )
                    {
                     before(grammarAccess.getTranslationUnitAccess().getLinesAssignment_1_1()); 
                    // InternalCPreprocess.g:250:1: ( rule__TranslationUnit__LinesAssignment_1_1 )
                    // InternalCPreprocess.g:250:2: rule__TranslationUnit__LinesAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__TranslationUnit__LinesAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getTranslationUnitAccess().getLinesAssignment_1_1()); 

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
    // $ANTLR end "rule__TranslationUnit__Alternatives_1"


    // $ANTLR start "rule__Model__Group__0"
    // InternalCPreprocess.g:263:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:267:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalCPreprocess.g:268:2: rule__Model__Group__0__Impl rule__Model__Group__1
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
    // InternalCPreprocess.g:275:1: rule__Model__Group__0__Impl : ( () ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:279:1: ( ( () ) )
            // InternalCPreprocess.g:281:1: ( () )
            {
            // InternalCPreprocess.g:281:1: ( () )
            // InternalCPreprocess.g:282:1: ()
            {
             before(grammarAccess.getModelAccess().getModelAction_0()); 
            // InternalCPreprocess.g:283:1: ()
            // InternalCPreprocess.g:285:1: 
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
    // InternalCPreprocess.g:297:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:301:1: ( rule__Model__Group__1__Impl )
            // InternalCPreprocess.g:302:2: rule__Model__Group__1__Impl
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
    // InternalCPreprocess.g:308:1: rule__Model__Group__1__Impl : ( ( rule__Model__UnitsAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:312:1: ( ( ( rule__Model__UnitsAssignment_1 ) ) )
            // InternalCPreprocess.g:314:1: ( ( rule__Model__UnitsAssignment_1 ) )
            {
            // InternalCPreprocess.g:314:1: ( ( rule__Model__UnitsAssignment_1 ) )
            // InternalCPreprocess.g:315:1: ( rule__Model__UnitsAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getUnitsAssignment_1()); 
            // InternalCPreprocess.g:316:1: ( rule__Model__UnitsAssignment_1 )
            // InternalCPreprocess.g:316:2: rule__Model__UnitsAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Model__UnitsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getUnitsAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__TranslationUnit__Group__0"
    // InternalCPreprocess.g:332:1: rule__TranslationUnit__Group__0 : rule__TranslationUnit__Group__0__Impl rule__TranslationUnit__Group__1 ;
    public final void rule__TranslationUnit__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:336:1: ( rule__TranslationUnit__Group__0__Impl rule__TranslationUnit__Group__1 )
            // InternalCPreprocess.g:337:2: rule__TranslationUnit__Group__0__Impl rule__TranslationUnit__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__TranslationUnit__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TranslationUnit__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TranslationUnit__Group__0"


    // $ANTLR start "rule__TranslationUnit__Group__0__Impl"
    // InternalCPreprocess.g:344:1: rule__TranslationUnit__Group__0__Impl : ( () ) ;
    public final void rule__TranslationUnit__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:348:1: ( ( () ) )
            // InternalCPreprocess.g:350:1: ( () )
            {
            // InternalCPreprocess.g:350:1: ( () )
            // InternalCPreprocess.g:351:1: ()
            {
             before(grammarAccess.getTranslationUnitAccess().getTranslationUnitAction_0()); 
            // InternalCPreprocess.g:352:1: ()
            // InternalCPreprocess.g:354:1: 
            {
            }

             after(grammarAccess.getTranslationUnitAccess().getTranslationUnitAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TranslationUnit__Group__0__Impl"


    // $ANTLR start "rule__TranslationUnit__Group__1"
    // InternalCPreprocess.g:366:1: rule__TranslationUnit__Group__1 : rule__TranslationUnit__Group__1__Impl ;
    public final void rule__TranslationUnit__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:370:1: ( rule__TranslationUnit__Group__1__Impl )
            // InternalCPreprocess.g:371:2: rule__TranslationUnit__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TranslationUnit__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TranslationUnit__Group__1"


    // $ANTLR start "rule__TranslationUnit__Group__1__Impl"
    // InternalCPreprocess.g:377:1: rule__TranslationUnit__Group__1__Impl : ( ( rule__TranslationUnit__Alternatives_1 )* ) ;
    public final void rule__TranslationUnit__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:381:1: ( ( ( rule__TranslationUnit__Alternatives_1 )* ) )
            // InternalCPreprocess.g:383:1: ( ( rule__TranslationUnit__Alternatives_1 )* )
            {
            // InternalCPreprocess.g:383:1: ( ( rule__TranslationUnit__Alternatives_1 )* )
            // InternalCPreprocess.g:384:1: ( rule__TranslationUnit__Alternatives_1 )*
            {
             before(grammarAccess.getTranslationUnitAccess().getAlternatives_1()); 
            // InternalCPreprocess.g:385:1: ( rule__TranslationUnit__Alternatives_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_NEWLINE && LA2_0<=RULE_MYCODE)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCPreprocess.g:385:2: rule__TranslationUnit__Alternatives_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__TranslationUnit__Alternatives_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getTranslationUnitAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TranslationUnit__Group__1__Impl"


    // $ANTLR start "rule__IncludeDirective__Group__0"
    // InternalCPreprocess.g:402:1: rule__IncludeDirective__Group__0 : rule__IncludeDirective__Group__0__Impl rule__IncludeDirective__Group__1 ;
    public final void rule__IncludeDirective__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:406:1: ( rule__IncludeDirective__Group__0__Impl rule__IncludeDirective__Group__1 )
            // InternalCPreprocess.g:407:2: rule__IncludeDirective__Group__0__Impl rule__IncludeDirective__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__IncludeDirective__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IncludeDirective__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDirective__Group__0"


    // $ANTLR start "rule__IncludeDirective__Group__0__Impl"
    // InternalCPreprocess.g:414:1: rule__IncludeDirective__Group__0__Impl : ( () ) ;
    public final void rule__IncludeDirective__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:418:1: ( ( () ) )
            // InternalCPreprocess.g:420:1: ( () )
            {
            // InternalCPreprocess.g:420:1: ( () )
            // InternalCPreprocess.g:421:1: ()
            {
             before(grammarAccess.getIncludeDirectiveAccess().getIncludeDirectiveAction_0()); 
            // InternalCPreprocess.g:422:1: ()
            // InternalCPreprocess.g:424:1: 
            {
            }

             after(grammarAccess.getIncludeDirectiveAccess().getIncludeDirectiveAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDirective__Group__0__Impl"


    // $ANTLR start "rule__IncludeDirective__Group__1"
    // InternalCPreprocess.g:436:1: rule__IncludeDirective__Group__1 : rule__IncludeDirective__Group__1__Impl rule__IncludeDirective__Group__2 ;
    public final void rule__IncludeDirective__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:440:1: ( rule__IncludeDirective__Group__1__Impl rule__IncludeDirective__Group__2 )
            // InternalCPreprocess.g:441:2: rule__IncludeDirective__Group__1__Impl rule__IncludeDirective__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__IncludeDirective__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IncludeDirective__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDirective__Group__1"


    // $ANTLR start "rule__IncludeDirective__Group__1__Impl"
    // InternalCPreprocess.g:448:1: rule__IncludeDirective__Group__1__Impl : ( 'include' ) ;
    public final void rule__IncludeDirective__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:452:1: ( ( 'include' ) )
            // InternalCPreprocess.g:454:1: ( 'include' )
            {
            // InternalCPreprocess.g:454:1: ( 'include' )
            // InternalCPreprocess.g:455:1: 'include'
            {
             before(grammarAccess.getIncludeDirectiveAccess().getIncludeKeyword_1()); 
            match(input,9,FOLLOW_2); 
             after(grammarAccess.getIncludeDirectiveAccess().getIncludeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDirective__Group__1__Impl"


    // $ANTLR start "rule__IncludeDirective__Group__2"
    // InternalCPreprocess.g:470:1: rule__IncludeDirective__Group__2 : rule__IncludeDirective__Group__2__Impl ;
    public final void rule__IncludeDirective__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:474:1: ( rule__IncludeDirective__Group__2__Impl )
            // InternalCPreprocess.g:475:2: rule__IncludeDirective__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IncludeDirective__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDirective__Group__2"


    // $ANTLR start "rule__IncludeDirective__Group__2__Impl"
    // InternalCPreprocess.g:481:1: rule__IncludeDirective__Group__2__Impl : ( ( rule__IncludeDirective__StringAssignment_2 ) ) ;
    public final void rule__IncludeDirective__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:485:1: ( ( ( rule__IncludeDirective__StringAssignment_2 ) ) )
            // InternalCPreprocess.g:487:1: ( ( rule__IncludeDirective__StringAssignment_2 ) )
            {
            // InternalCPreprocess.g:487:1: ( ( rule__IncludeDirective__StringAssignment_2 ) )
            // InternalCPreprocess.g:488:1: ( rule__IncludeDirective__StringAssignment_2 )
            {
             before(grammarAccess.getIncludeDirectiveAccess().getStringAssignment_2()); 
            // InternalCPreprocess.g:489:1: ( rule__IncludeDirective__StringAssignment_2 )
            // InternalCPreprocess.g:489:2: rule__IncludeDirective__StringAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__IncludeDirective__StringAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getIncludeDirectiveAccess().getStringAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDirective__Group__2__Impl"


    // $ANTLR start "rule__NewLineLine__Group__0"
    // InternalCPreprocess.g:507:1: rule__NewLineLine__Group__0 : rule__NewLineLine__Group__0__Impl rule__NewLineLine__Group__1 ;
    public final void rule__NewLineLine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:511:1: ( rule__NewLineLine__Group__0__Impl rule__NewLineLine__Group__1 )
            // InternalCPreprocess.g:512:2: rule__NewLineLine__Group__0__Impl rule__NewLineLine__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__NewLineLine__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NewLineLine__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NewLineLine__Group__0"


    // $ANTLR start "rule__NewLineLine__Group__0__Impl"
    // InternalCPreprocess.g:519:1: rule__NewLineLine__Group__0__Impl : ( () ) ;
    public final void rule__NewLineLine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:523:1: ( ( () ) )
            // InternalCPreprocess.g:525:1: ( () )
            {
            // InternalCPreprocess.g:525:1: ( () )
            // InternalCPreprocess.g:526:1: ()
            {
             before(grammarAccess.getNewLineLineAccess().getNewLineLineAction_0()); 
            // InternalCPreprocess.g:527:1: ()
            // InternalCPreprocess.g:529:1: 
            {
            }

             after(grammarAccess.getNewLineLineAccess().getNewLineLineAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NewLineLine__Group__0__Impl"


    // $ANTLR start "rule__NewLineLine__Group__1"
    // InternalCPreprocess.g:541:1: rule__NewLineLine__Group__1 : rule__NewLineLine__Group__1__Impl ;
    public final void rule__NewLineLine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:545:1: ( rule__NewLineLine__Group__1__Impl )
            // InternalCPreprocess.g:546:2: rule__NewLineLine__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NewLineLine__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NewLineLine__Group__1"


    // $ANTLR start "rule__NewLineLine__Group__1__Impl"
    // InternalCPreprocess.g:552:1: rule__NewLineLine__Group__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__NewLineLine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:556:1: ( ( RULE_NEWLINE ) )
            // InternalCPreprocess.g:558:1: ( RULE_NEWLINE )
            {
            // InternalCPreprocess.g:558:1: ( RULE_NEWLINE )
            // InternalCPreprocess.g:559:1: RULE_NEWLINE
            {
             before(grammarAccess.getNewLineLineAccess().getNEWLINETerminalRuleCall_1()); 
            match(input,RULE_NEWLINE,FOLLOW_2); 
             after(grammarAccess.getNewLineLineAccess().getNEWLINETerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NewLineLine__Group__1__Impl"


    // $ANTLR start "rule__Code__Group__0"
    // InternalCPreprocess.g:576:1: rule__Code__Group__0 : rule__Code__Group__0__Impl rule__Code__Group__1 ;
    public final void rule__Code__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:580:1: ( rule__Code__Group__0__Impl rule__Code__Group__1 )
            // InternalCPreprocess.g:581:2: rule__Code__Group__0__Impl rule__Code__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Code__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Code__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Code__Group__0"


    // $ANTLR start "rule__Code__Group__0__Impl"
    // InternalCPreprocess.g:588:1: rule__Code__Group__0__Impl : ( () ) ;
    public final void rule__Code__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:592:1: ( ( () ) )
            // InternalCPreprocess.g:594:1: ( () )
            {
            // InternalCPreprocess.g:594:1: ( () )
            // InternalCPreprocess.g:595:1: ()
            {
             before(grammarAccess.getCodeAccess().getCodeAction_0()); 
            // InternalCPreprocess.g:596:1: ()
            // InternalCPreprocess.g:598:1: 
            {
            }

             after(grammarAccess.getCodeAccess().getCodeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Code__Group__0__Impl"


    // $ANTLR start "rule__Code__Group__1"
    // InternalCPreprocess.g:610:1: rule__Code__Group__1 : rule__Code__Group__1__Impl rule__Code__Group__2 ;
    public final void rule__Code__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:614:1: ( rule__Code__Group__1__Impl rule__Code__Group__2 )
            // InternalCPreprocess.g:615:2: rule__Code__Group__1__Impl rule__Code__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__Code__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Code__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Code__Group__1"


    // $ANTLR start "rule__Code__Group__1__Impl"
    // InternalCPreprocess.g:622:1: rule__Code__Group__1__Impl : ( ( rule__Code__CodeAssignment_1 ) ) ;
    public final void rule__Code__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:626:1: ( ( ( rule__Code__CodeAssignment_1 ) ) )
            // InternalCPreprocess.g:628:1: ( ( rule__Code__CodeAssignment_1 ) )
            {
            // InternalCPreprocess.g:628:1: ( ( rule__Code__CodeAssignment_1 ) )
            // InternalCPreprocess.g:629:1: ( rule__Code__CodeAssignment_1 )
            {
             before(grammarAccess.getCodeAccess().getCodeAssignment_1()); 
            // InternalCPreprocess.g:630:1: ( rule__Code__CodeAssignment_1 )
            // InternalCPreprocess.g:630:2: rule__Code__CodeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Code__CodeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCodeAccess().getCodeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Code__Group__1__Impl"


    // $ANTLR start "rule__Code__Group__2"
    // InternalCPreprocess.g:642:1: rule__Code__Group__2 : rule__Code__Group__2__Impl ;
    public final void rule__Code__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:646:1: ( rule__Code__Group__2__Impl )
            // InternalCPreprocess.g:647:2: rule__Code__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Code__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Code__Group__2"


    // $ANTLR start "rule__Code__Group__2__Impl"
    // InternalCPreprocess.g:653:1: rule__Code__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Code__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:657:1: ( ( RULE_NEWLINE ) )
            // InternalCPreprocess.g:659:1: ( RULE_NEWLINE )
            {
            // InternalCPreprocess.g:659:1: ( RULE_NEWLINE )
            // InternalCPreprocess.g:660:1: RULE_NEWLINE
            {
             before(grammarAccess.getCodeAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_2); 
             after(grammarAccess.getCodeAccess().getNEWLINETerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Code__Group__2__Impl"


    // $ANTLR start "rule__Model__UnitsAssignment_1"
    // InternalCPreprocess.g:680:1: rule__Model__UnitsAssignment_1 : ( ruleTranslationUnit ) ;
    public final void rule__Model__UnitsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:684:1: ( ( ruleTranslationUnit ) )
            // InternalCPreprocess.g:685:1: ( ruleTranslationUnit )
            {
            // InternalCPreprocess.g:685:1: ( ruleTranslationUnit )
            // InternalCPreprocess.g:686:1: ruleTranslationUnit
            {
             before(grammarAccess.getModelAccess().getUnitsTranslationUnitParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTranslationUnit();

            state._fsp--;

             after(grammarAccess.getModelAccess().getUnitsTranslationUnitParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__UnitsAssignment_1"


    // $ANTLR start "rule__TranslationUnit__LinesAssignment_1_0"
    // InternalCPreprocess.g:695:1: rule__TranslationUnit__LinesAssignment_1_0 : ( ruleNewLineLine ) ;
    public final void rule__TranslationUnit__LinesAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:699:1: ( ( ruleNewLineLine ) )
            // InternalCPreprocess.g:700:1: ( ruleNewLineLine )
            {
            // InternalCPreprocess.g:700:1: ( ruleNewLineLine )
            // InternalCPreprocess.g:701:1: ruleNewLineLine
            {
             before(grammarAccess.getTranslationUnitAccess().getLinesNewLineLineParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleNewLineLine();

            state._fsp--;

             after(grammarAccess.getTranslationUnitAccess().getLinesNewLineLineParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TranslationUnit__LinesAssignment_1_0"


    // $ANTLR start "rule__TranslationUnit__LinesAssignment_1_1"
    // InternalCPreprocess.g:710:1: rule__TranslationUnit__LinesAssignment_1_1 : ( ruleCode ) ;
    public final void rule__TranslationUnit__LinesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:714:1: ( ( ruleCode ) )
            // InternalCPreprocess.g:715:1: ( ruleCode )
            {
            // InternalCPreprocess.g:715:1: ( ruleCode )
            // InternalCPreprocess.g:716:1: ruleCode
            {
             before(grammarAccess.getTranslationUnitAccess().getLinesCodeParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCode();

            state._fsp--;

             after(grammarAccess.getTranslationUnitAccess().getLinesCodeParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TranslationUnit__LinesAssignment_1_1"


    // $ANTLR start "rule__IncludeDirective__StringAssignment_2"
    // InternalCPreprocess.g:726:1: rule__IncludeDirective__StringAssignment_2 : ( RULE_NEWLINE ) ;
    public final void rule__IncludeDirective__StringAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:730:1: ( ( RULE_NEWLINE ) )
            // InternalCPreprocess.g:731:1: ( RULE_NEWLINE )
            {
            // InternalCPreprocess.g:731:1: ( RULE_NEWLINE )
            // InternalCPreprocess.g:732:1: RULE_NEWLINE
            {
             before(grammarAccess.getIncludeDirectiveAccess().getStringNEWLINETerminalRuleCall_2_0()); 
            match(input,RULE_NEWLINE,FOLLOW_2); 
             after(grammarAccess.getIncludeDirectiveAccess().getStringNEWLINETerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDirective__StringAssignment_2"


    // $ANTLR start "rule__Code__CodeAssignment_1"
    // InternalCPreprocess.g:741:1: rule__Code__CodeAssignment_1 : ( RULE_MYCODE ) ;
    public final void rule__Code__CodeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCPreprocess.g:745:1: ( ( RULE_MYCODE ) )
            // InternalCPreprocess.g:746:1: ( RULE_MYCODE )
            {
            // InternalCPreprocess.g:746:1: ( RULE_MYCODE )
            // InternalCPreprocess.g:747:1: RULE_MYCODE
            {
             before(grammarAccess.getCodeAccess().getCodeMYCODETerminalRuleCall_1_0()); 
            match(input,RULE_MYCODE,FOLLOW_2); 
             after(grammarAccess.getCodeAccess().getCodeMYCODETerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Code__CodeAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});

}