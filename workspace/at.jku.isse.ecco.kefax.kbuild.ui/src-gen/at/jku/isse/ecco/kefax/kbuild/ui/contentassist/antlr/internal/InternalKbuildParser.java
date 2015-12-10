package at.jku.isse.ecco.kefax.kbuild.ui.contentassist.antlr.internal; 

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
import at.jku.isse.ecco.kefax.kbuild.services.KbuildGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalKbuildParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NLI", "RULE_SEMICOLON", "RULE_Y", "RULE_M", "RULE_PLUS", "RULE_DPOINT", "RULE_STRING", "RULE_COMMA", "RULE_SHELL_CHAR", "RULE_IFEQ", "RULE_IFNEQ", "RULE_IFNDEF", "RULE_ENDIF", "RULE_TAB", "RULE_OBJ_START", "RULE_BRACE_START", "RULE_BRACE_END", "RULE_ELSE", "RULE_OBJ_Y", "RULE_OBJ_M", "RULE_EQ", "RULE_BACKSLASH", "RULE_SYMBOL", "RULE_OBJ_FILE", "RULE_SLASH", "RULE_DOLLAR", "RULE_INCLUDE", "RULE_WSS", "RULE_SL_COMMENT", "RULE_QUOTE", "RULE_STR_ESC"
    };
    public static final int RULE_DPOINT=9;
    public static final int RULE_SHELL_CHAR=12;
    public static final int RULE_OBJ_Y=22;
    public static final int RULE_QUOTE=33;
    public static final int RULE_OBJ_M=23;
    public static final int RULE_SEMICOLON=5;
    public static final int RULE_STR_ESC=34;
    public static final int RULE_PLUS=8;
    public static final int RULE_IFNDEF=15;
    public static final int RULE_COMMA=11;
    public static final int RULE_TAB=17;
    public static final int RULE_BRACE_END=20;
    public static final int RULE_OBJ_START=18;
    public static final int RULE_SL_COMMENT=32;
    public static final int EOF=-1;
    public static final int RULE_OBJ_FILE=27;
    public static final int RULE_WSS=31;
    public static final int RULE_DOLLAR=29;
    public static final int RULE_STRING=10;
    public static final int RULE_IFEQ=13;
    public static final int RULE_IFNEQ=14;
    public static final int RULE_NLI=4;
    public static final int RULE_ENDIF=16;
    public static final int RULE_M=7;
    public static final int RULE_EQ=24;
    public static final int RULE_Y=6;
    public static final int RULE_INCLUDE=30;
    public static final int RULE_BACKSLASH=25;
    public static final int RULE_SLASH=28;
    public static final int RULE_SYMBOL=26;
    public static final int RULE_ELSE=21;
    public static final int RULE_BRACE_START=19;

    // delegates
    // delegators


        public InternalKbuildParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalKbuildParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalKbuildParser.tokenNames; }
    public String getGrammarFileName() { return "../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g"; }


     
     	private KbuildGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(KbuildGrammarAccess grammarAccess) {
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
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:61:1: ( ruleModel EOF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel68); 

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
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:69:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:73:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:74:1: ( ( rule__Model__Group__0 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:74:1: ( ( rule__Model__Group__0 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:75:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:76:1: ( rule__Model__Group__0 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:76:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel94);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleBuildEntry"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:88:1: entryRuleBuildEntry : ruleBuildEntry EOF ;
    public final void entryRuleBuildEntry() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:89:1: ( ruleBuildEntry EOF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:90:1: ruleBuildEntry EOF
            {
             before(grammarAccess.getBuildEntryRule()); 
            pushFollow(FOLLOW_ruleBuildEntry_in_entryRuleBuildEntry121);
            ruleBuildEntry();

            state._fsp--;

             after(grammarAccess.getBuildEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBuildEntry128); 

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
    // $ANTLR end "entryRuleBuildEntry"


    // $ANTLR start "ruleBuildEntry"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:97:1: ruleBuildEntry : ( ( rule__BuildEntry__Alternatives ) ) ;
    public final void ruleBuildEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:101:2: ( ( ( rule__BuildEntry__Alternatives ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:102:1: ( ( rule__BuildEntry__Alternatives ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:102:1: ( ( rule__BuildEntry__Alternatives ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:103:1: ( rule__BuildEntry__Alternatives )
            {
             before(grammarAccess.getBuildEntryAccess().getAlternatives()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:104:1: ( rule__BuildEntry__Alternatives )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:104:2: rule__BuildEntry__Alternatives
            {
            pushFollow(FOLLOW_rule__BuildEntry__Alternatives_in_ruleBuildEntry154);
            rule__BuildEntry__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBuildEntryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBuildEntry"


    // $ANTLR start "entryRuleEntry"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:116:1: entryRuleEntry : ruleEntry EOF ;
    public final void entryRuleEntry() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:117:1: ( ruleEntry EOF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:118:1: ruleEntry EOF
            {
             before(grammarAccess.getEntryRule()); 
            pushFollow(FOLLOW_ruleEntry_in_entryRuleEntry181);
            ruleEntry();

            state._fsp--;

             after(grammarAccess.getEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntry188); 

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
    // $ANTLR end "entryRuleEntry"


    // $ANTLR start "ruleEntry"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:125:1: ruleEntry : ( ( rule__Entry__Group__0 ) ) ;
    public final void ruleEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:129:2: ( ( ( rule__Entry__Group__0 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:130:1: ( ( rule__Entry__Group__0 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:130:1: ( ( rule__Entry__Group__0 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:131:1: ( rule__Entry__Group__0 )
            {
             before(grammarAccess.getEntryAccess().getGroup()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:132:1: ( rule__Entry__Group__0 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:132:2: rule__Entry__Group__0
            {
            pushFollow(FOLLOW_rule__Entry__Group__0_in_ruleEntry214);
            rule__Entry__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEntry"


    // $ANTLR start "entryRuleIf"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:144:1: entryRuleIf : ruleIf EOF ;
    public final void entryRuleIf() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:145:1: ( ruleIf EOF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:146:1: ruleIf EOF
            {
             before(grammarAccess.getIfRule()); 
            pushFollow(FOLLOW_ruleIf_in_entryRuleIf241);
            ruleIf();

            state._fsp--;

             after(grammarAccess.getIfRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIf248); 

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
    // $ANTLR end "entryRuleIf"


    // $ANTLR start "ruleIf"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:153:1: ruleIf : ( ( rule__If__Group__0 ) ) ;
    public final void ruleIf() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:157:2: ( ( ( rule__If__Group__0 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:158:1: ( ( rule__If__Group__0 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:158:1: ( ( rule__If__Group__0 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:159:1: ( rule__If__Group__0 )
            {
             before(grammarAccess.getIfAccess().getGroup()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:160:1: ( rule__If__Group__0 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:160:2: rule__If__Group__0
            {
            pushFollow(FOLLOW_rule__If__Group__0_in_ruleIf274);
            rule__If__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIfAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIf"


    // $ANTLR start "entryRuleObject_Y"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:172:1: entryRuleObject_Y : ruleObject_Y EOF ;
    public final void entryRuleObject_Y() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:173:1: ( ruleObject_Y EOF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:174:1: ruleObject_Y EOF
            {
             before(grammarAccess.getObject_YRule()); 
            pushFollow(FOLLOW_ruleObject_Y_in_entryRuleObject_Y301);
            ruleObject_Y();

            state._fsp--;

             after(grammarAccess.getObject_YRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObject_Y308); 

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
    // $ANTLR end "entryRuleObject_Y"


    // $ANTLR start "ruleObject_Y"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:181:1: ruleObject_Y : ( ( rule__Object_Y__Group__0 ) ) ;
    public final void ruleObject_Y() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:185:2: ( ( ( rule__Object_Y__Group__0 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:186:1: ( ( rule__Object_Y__Group__0 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:186:1: ( ( rule__Object_Y__Group__0 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:187:1: ( rule__Object_Y__Group__0 )
            {
             before(grammarAccess.getObject_YAccess().getGroup()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:188:1: ( rule__Object_Y__Group__0 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:188:2: rule__Object_Y__Group__0
            {
            pushFollow(FOLLOW_rule__Object_Y__Group__0_in_ruleObject_Y334);
            rule__Object_Y__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getObject_YAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObject_Y"


    // $ANTLR start "entryRuleObject_M"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:200:1: entryRuleObject_M : ruleObject_M EOF ;
    public final void entryRuleObject_M() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:201:1: ( ruleObject_M EOF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:202:1: ruleObject_M EOF
            {
             before(grammarAccess.getObject_MRule()); 
            pushFollow(FOLLOW_ruleObject_M_in_entryRuleObject_M361);
            ruleObject_M();

            state._fsp--;

             after(grammarAccess.getObject_MRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObject_M368); 

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
    // $ANTLR end "entryRuleObject_M"


    // $ANTLR start "ruleObject_M"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:209:1: ruleObject_M : ( ( rule__Object_M__Group__0 ) ) ;
    public final void ruleObject_M() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:213:2: ( ( ( rule__Object_M__Group__0 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:214:1: ( ( rule__Object_M__Group__0 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:214:1: ( ( rule__Object_M__Group__0 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:215:1: ( rule__Object_M__Group__0 )
            {
             before(grammarAccess.getObject_MAccess().getGroup()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:216:1: ( rule__Object_M__Group__0 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:216:2: rule__Object_M__Group__0
            {
            pushFollow(FOLLOW_rule__Object_M__Group__0_in_ruleObject_M394);
            rule__Object_M__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getObject_MAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObject_M"


    // $ANTLR start "entryRuleAssign"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:228:1: entryRuleAssign : ruleAssign EOF ;
    public final void entryRuleAssign() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:229:1: ( ruleAssign EOF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:230:1: ruleAssign EOF
            {
             before(grammarAccess.getAssignRule()); 
            pushFollow(FOLLOW_ruleAssign_in_entryRuleAssign421);
            ruleAssign();

            state._fsp--;

             after(grammarAccess.getAssignRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssign428); 

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
    // $ANTLR end "entryRuleAssign"


    // $ANTLR start "ruleAssign"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:237:1: ruleAssign : ( ( rule__Assign__Group__0 ) ) ;
    public final void ruleAssign() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:241:2: ( ( ( rule__Assign__Group__0 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:242:1: ( ( rule__Assign__Group__0 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:242:1: ( ( rule__Assign__Group__0 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:243:1: ( rule__Assign__Group__0 )
            {
             before(grammarAccess.getAssignAccess().getGroup()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:244:1: ( rule__Assign__Group__0 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:244:2: rule__Assign__Group__0
            {
            pushFollow(FOLLOW_rule__Assign__Group__0_in_ruleAssign454);
            rule__Assign__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssign"


    // $ANTLR start "entryRuleAssignExtra"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:256:1: entryRuleAssignExtra : ruleAssignExtra EOF ;
    public final void entryRuleAssignExtra() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:257:1: ( ruleAssignExtra EOF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:258:1: ruleAssignExtra EOF
            {
             before(grammarAccess.getAssignExtraRule()); 
            pushFollow(FOLLOW_ruleAssignExtra_in_entryRuleAssignExtra481);
            ruleAssignExtra();

            state._fsp--;

             after(grammarAccess.getAssignExtraRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignExtra488); 

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
    // $ANTLR end "entryRuleAssignExtra"


    // $ANTLR start "ruleAssignExtra"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:265:1: ruleAssignExtra : ( ( rule__AssignExtra__Group__0 ) ) ;
    public final void ruleAssignExtra() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:269:2: ( ( ( rule__AssignExtra__Group__0 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:270:1: ( ( rule__AssignExtra__Group__0 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:270:1: ( ( rule__AssignExtra__Group__0 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:271:1: ( rule__AssignExtra__Group__0 )
            {
             before(grammarAccess.getAssignExtraAccess().getGroup()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:272:1: ( rule__AssignExtra__Group__0 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:272:2: rule__AssignExtra__Group__0
            {
            pushFollow(FOLLOW_rule__AssignExtra__Group__0_in_ruleAssignExtra514);
            rule__AssignExtra__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignExtraAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignExtra"


    // $ANTLR start "entryRuleValues"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:284:1: entryRuleValues : ruleValues EOF ;
    public final void entryRuleValues() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:285:1: ( ruleValues EOF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:286:1: ruleValues EOF
            {
             before(grammarAccess.getValuesRule()); 
            pushFollow(FOLLOW_ruleValues_in_entryRuleValues541);
            ruleValues();

            state._fsp--;

             after(grammarAccess.getValuesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValues548); 

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
    // $ANTLR end "entryRuleValues"


    // $ANTLR start "ruleValues"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:293:1: ruleValues : ( ( rule__Values__Group__0 ) ) ;
    public final void ruleValues() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:297:2: ( ( ( rule__Values__Group__0 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:298:1: ( ( rule__Values__Group__0 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:298:1: ( ( rule__Values__Group__0 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:299:1: ( rule__Values__Group__0 )
            {
             before(grammarAccess.getValuesAccess().getGroup()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:300:1: ( rule__Values__Group__0 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:300:2: rule__Values__Group__0
            {
            pushFollow(FOLLOW_rule__Values__Group__0_in_ruleValues574);
            rule__Values__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getValuesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValues"


    // $ANTLR start "entryRuleValue"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:312:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:313:1: ( ruleValue EOF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:314:1: ruleValue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue601);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue608); 

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
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:321:1: ruleValue : ( ( rule__Value__Alternatives ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:325:2: ( ( ( rule__Value__Alternatives ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:326:1: ( ( rule__Value__Alternatives ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:326:1: ( ( rule__Value__Alternatives ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:327:1: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:328:1: ( rule__Value__Alternatives )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:328:2: rule__Value__Alternatives
            {
            pushFollow(FOLLOW_rule__Value__Alternatives_in_ruleValue634);
            rule__Value__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleVariable"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:340:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:341:1: ( ruleVariable EOF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:342:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable661);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable668); 

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
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:349:1: ruleVariable : ( ( rule__Variable__Alternatives ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:353:2: ( ( ( rule__Variable__Alternatives ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:354:1: ( ( rule__Variable__Alternatives ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:354:1: ( ( rule__Variable__Alternatives ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:355:1: ( rule__Variable__Alternatives )
            {
             before(grammarAccess.getVariableAccess().getAlternatives()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:356:1: ( rule__Variable__Alternatives )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:356:2: rule__Variable__Alternatives
            {
            pushFollow(FOLLOW_rule__Variable__Alternatives_in_ruleVariable694);
            rule__Variable__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleShellCmd"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:368:1: entryRuleShellCmd : ruleShellCmd EOF ;
    public final void entryRuleShellCmd() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:369:1: ( ruleShellCmd EOF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:370:1: ruleShellCmd EOF
            {
             before(grammarAccess.getShellCmdRule()); 
            pushFollow(FOLLOW_ruleShellCmd_in_entryRuleShellCmd721);
            ruleShellCmd();

            state._fsp--;

             after(grammarAccess.getShellCmdRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShellCmd728); 

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
    // $ANTLR end "entryRuleShellCmd"


    // $ANTLR start "ruleShellCmd"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:377:1: ruleShellCmd : ( ( rule__ShellCmd__Alternatives ) ) ;
    public final void ruleShellCmd() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:381:2: ( ( ( rule__ShellCmd__Alternatives ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:382:1: ( ( rule__ShellCmd__Alternatives ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:382:1: ( ( rule__ShellCmd__Alternatives ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:383:1: ( rule__ShellCmd__Alternatives )
            {
             before(grammarAccess.getShellCmdAccess().getAlternatives()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:384:1: ( rule__ShellCmd__Alternatives )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:384:2: rule__ShellCmd__Alternatives
            {
            pushFollow(FOLLOW_rule__ShellCmd__Alternatives_in_ruleShellCmd754);
            rule__ShellCmd__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getShellCmdAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleShellCmd"


    // $ANTLR start "entryRuleShellPart"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:396:1: entryRuleShellPart : ruleShellPart EOF ;
    public final void entryRuleShellPart() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:397:1: ( ruleShellPart EOF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:398:1: ruleShellPart EOF
            {
             before(grammarAccess.getShellPartRule()); 
            pushFollow(FOLLOW_ruleShellPart_in_entryRuleShellPart781);
            ruleShellPart();

            state._fsp--;

             after(grammarAccess.getShellPartRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShellPart788); 

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
    // $ANTLR end "entryRuleShellPart"


    // $ANTLR start "ruleShellPart"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:405:1: ruleShellPart : ( ( rule__ShellPart__Group__0 ) ) ;
    public final void ruleShellPart() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:409:2: ( ( ( rule__ShellPart__Group__0 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:410:1: ( ( rule__ShellPart__Group__0 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:410:1: ( ( rule__ShellPart__Group__0 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:411:1: ( rule__ShellPart__Group__0 )
            {
             before(grammarAccess.getShellPartAccess().getGroup()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:412:1: ( rule__ShellPart__Group__0 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:412:2: rule__ShellPart__Group__0
            {
            pushFollow(FOLLOW_rule__ShellPart__Group__0_in_ruleShellPart814);
            rule__ShellPart__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getShellPartAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleShellPart"


    // $ANTLR start "entryRuleVarSlashSym"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:424:1: entryRuleVarSlashSym : ruleVarSlashSym EOF ;
    public final void entryRuleVarSlashSym() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:425:1: ( ruleVarSlashSym EOF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:426:1: ruleVarSlashSym EOF
            {
             before(grammarAccess.getVarSlashSymRule()); 
            pushFollow(FOLLOW_ruleVarSlashSym_in_entryRuleVarSlashSym841);
            ruleVarSlashSym();

            state._fsp--;

             after(grammarAccess.getVarSlashSymRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarSlashSym848); 

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
    // $ANTLR end "entryRuleVarSlashSym"


    // $ANTLR start "ruleVarSlashSym"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:433:1: ruleVarSlashSym : ( ( rule__VarSlashSym__Alternatives ) ) ;
    public final void ruleVarSlashSym() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:437:2: ( ( ( rule__VarSlashSym__Alternatives ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:438:1: ( ( rule__VarSlashSym__Alternatives ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:438:1: ( ( rule__VarSlashSym__Alternatives ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:439:1: ( rule__VarSlashSym__Alternatives )
            {
             before(grammarAccess.getVarSlashSymAccess().getAlternatives()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:440:1: ( rule__VarSlashSym__Alternatives )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:440:2: rule__VarSlashSym__Alternatives
            {
            pushFollow(FOLLOW_rule__VarSlashSym__Alternatives_in_ruleVarSlashSym874);
            rule__VarSlashSym__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVarSlashSymAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVarSlashSym"


    // $ANTLR start "entryRuleEol"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:452:1: entryRuleEol : ruleEol EOF ;
    public final void entryRuleEol() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:453:1: ( ruleEol EOF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:454:1: ruleEol EOF
            {
             before(grammarAccess.getEolRule()); 
            pushFollow(FOLLOW_ruleEol_in_entryRuleEol901);
            ruleEol();

            state._fsp--;

             after(grammarAccess.getEolRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEol908); 

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
    // $ANTLR end "entryRuleEol"


    // $ANTLR start "ruleEol"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:461:1: ruleEol : ( ( ( RULE_NLI ) ) ( ( RULE_NLI )* ) ) ;
    public final void ruleEol() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:465:2: ( ( ( ( RULE_NLI ) ) ( ( RULE_NLI )* ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:466:1: ( ( ( RULE_NLI ) ) ( ( RULE_NLI )* ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:466:1: ( ( ( RULE_NLI ) ) ( ( RULE_NLI )* ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:467:1: ( ( RULE_NLI ) ) ( ( RULE_NLI )* )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:467:1: ( ( RULE_NLI ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:468:1: ( RULE_NLI )
            {
             before(grammarAccess.getEolAccess().getNLITerminalRuleCall()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:469:1: ( RULE_NLI )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:469:3: RULE_NLI
            {
            match(input,RULE_NLI,FOLLOW_RULE_NLI_in_ruleEol937); 

            }

             after(grammarAccess.getEolAccess().getNLITerminalRuleCall()); 

            }

            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:472:1: ( ( RULE_NLI )* )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:473:1: ( RULE_NLI )*
            {
             before(grammarAccess.getEolAccess().getNLITerminalRuleCall()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:474:1: ( RULE_NLI )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_NLI) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:474:3: RULE_NLI
            	    {
            	    match(input,RULE_NLI,FOLLOW_RULE_NLI_in_ruleEol950); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getEolAccess().getNLITerminalRuleCall()); 

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
    // $ANTLR end "ruleEol"


    // $ANTLR start "rule__BuildEntry__Alternatives"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:487:1: rule__BuildEntry__Alternatives : ( ( ( rule__BuildEntry__Group_0__0 ) ) | ( ( rule__BuildEntry__Group_1__0 ) ) | ( ( rule__BuildEntry__Group_2__0 ) ) | ( ( rule__BuildEntry__Group_3__0 ) ) | ( ( rule__BuildEntry__Group_4__0 ) ) | ( ( rule__BuildEntry__Group_5__0 ) ) | ( ( rule__BuildEntry__Group_6__0 ) ) | ( ( rule__BuildEntry__Group_7__0 ) ) );
    public final void rule__BuildEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:491:1: ( ( ( rule__BuildEntry__Group_0__0 ) ) | ( ( rule__BuildEntry__Group_1__0 ) ) | ( ( rule__BuildEntry__Group_2__0 ) ) | ( ( rule__BuildEntry__Group_3__0 ) ) | ( ( rule__BuildEntry__Group_4__0 ) ) | ( ( rule__BuildEntry__Group_5__0 ) ) | ( ( rule__BuildEntry__Group_6__0 ) ) | ( ( rule__BuildEntry__Group_7__0 ) ) )
            int alt2=8;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:492:1: ( ( rule__BuildEntry__Group_0__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:492:1: ( ( rule__BuildEntry__Group_0__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:493:1: ( rule__BuildEntry__Group_0__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_0()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:494:1: ( rule__BuildEntry__Group_0__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:494:2: rule__BuildEntry__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__BuildEntry__Group_0__0_in_rule__BuildEntry__Alternatives989);
                    rule__BuildEntry__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:498:6: ( ( rule__BuildEntry__Group_1__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:498:6: ( ( rule__BuildEntry__Group_1__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:499:1: ( rule__BuildEntry__Group_1__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_1()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:500:1: ( rule__BuildEntry__Group_1__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:500:2: rule__BuildEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__BuildEntry__Group_1__0_in_rule__BuildEntry__Alternatives1007);
                    rule__BuildEntry__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:504:6: ( ( rule__BuildEntry__Group_2__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:504:6: ( ( rule__BuildEntry__Group_2__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:505:1: ( rule__BuildEntry__Group_2__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_2()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:506:1: ( rule__BuildEntry__Group_2__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:506:2: rule__BuildEntry__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__BuildEntry__Group_2__0_in_rule__BuildEntry__Alternatives1025);
                    rule__BuildEntry__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:510:6: ( ( rule__BuildEntry__Group_3__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:510:6: ( ( rule__BuildEntry__Group_3__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:511:1: ( rule__BuildEntry__Group_3__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_3()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:512:1: ( rule__BuildEntry__Group_3__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:512:2: rule__BuildEntry__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__BuildEntry__Group_3__0_in_rule__BuildEntry__Alternatives1043);
                    rule__BuildEntry__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:516:6: ( ( rule__BuildEntry__Group_4__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:516:6: ( ( rule__BuildEntry__Group_4__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:517:1: ( rule__BuildEntry__Group_4__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_4()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:518:1: ( rule__BuildEntry__Group_4__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:518:2: rule__BuildEntry__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__BuildEntry__Group_4__0_in_rule__BuildEntry__Alternatives1061);
                    rule__BuildEntry__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:522:6: ( ( rule__BuildEntry__Group_5__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:522:6: ( ( rule__BuildEntry__Group_5__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:523:1: ( rule__BuildEntry__Group_5__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_5()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:524:1: ( rule__BuildEntry__Group_5__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:524:2: rule__BuildEntry__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__BuildEntry__Group_5__0_in_rule__BuildEntry__Alternatives1079);
                    rule__BuildEntry__Group_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getGroup_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:528:6: ( ( rule__BuildEntry__Group_6__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:528:6: ( ( rule__BuildEntry__Group_6__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:529:1: ( rule__BuildEntry__Group_6__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_6()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:530:1: ( rule__BuildEntry__Group_6__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:530:2: rule__BuildEntry__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__BuildEntry__Group_6__0_in_rule__BuildEntry__Alternatives1097);
                    rule__BuildEntry__Group_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getGroup_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:534:6: ( ( rule__BuildEntry__Group_7__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:534:6: ( ( rule__BuildEntry__Group_7__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:535:1: ( rule__BuildEntry__Group_7__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_7()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:536:1: ( rule__BuildEntry__Group_7__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:536:2: rule__BuildEntry__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__BuildEntry__Group_7__0_in_rule__BuildEntry__Alternatives1115);
                    rule__BuildEntry__Group_7__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getGroup_7()); 

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
    // $ANTLR end "rule__BuildEntry__Alternatives"


    // $ANTLR start "rule__BuildEntry__Alternatives_3_4"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:545:1: rule__BuildEntry__Alternatives_3_4 : ( ( ( rule__BuildEntry__ValueAssignment_3_4_0 ) ) | ( ( rule__BuildEntry__ValueAssignment_3_4_1 ) ) );
    public final void rule__BuildEntry__Alternatives_3_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:549:1: ( ( ( rule__BuildEntry__ValueAssignment_3_4_0 ) ) | ( ( rule__BuildEntry__ValueAssignment_3_4_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_OBJ_Y) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_OBJ_M) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:550:1: ( ( rule__BuildEntry__ValueAssignment_3_4_0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:550:1: ( ( rule__BuildEntry__ValueAssignment_3_4_0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:551:1: ( rule__BuildEntry__ValueAssignment_3_4_0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getValueAssignment_3_4_0()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:552:1: ( rule__BuildEntry__ValueAssignment_3_4_0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:552:2: rule__BuildEntry__ValueAssignment_3_4_0
                    {
                    pushFollow(FOLLOW_rule__BuildEntry__ValueAssignment_3_4_0_in_rule__BuildEntry__Alternatives_3_41148);
                    rule__BuildEntry__ValueAssignment_3_4_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getValueAssignment_3_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:556:6: ( ( rule__BuildEntry__ValueAssignment_3_4_1 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:556:6: ( ( rule__BuildEntry__ValueAssignment_3_4_1 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:557:1: ( rule__BuildEntry__ValueAssignment_3_4_1 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getValueAssignment_3_4_1()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:558:1: ( rule__BuildEntry__ValueAssignment_3_4_1 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:558:2: rule__BuildEntry__ValueAssignment_3_4_1
                    {
                    pushFollow(FOLLOW_rule__BuildEntry__ValueAssignment_3_4_1_in_rule__BuildEntry__Alternatives_3_41166);
                    rule__BuildEntry__ValueAssignment_3_4_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getValueAssignment_3_4_1()); 

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
    // $ANTLR end "rule__BuildEntry__Alternatives_3_4"


    // $ANTLR start "rule__BuildEntry__Alternatives_5_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:567:1: rule__BuildEntry__Alternatives_5_1 : ( ( ( rule__BuildEntry__ValueAssignment_5_1_0 ) ) | ( ( rule__BuildEntry__ValueAssignment_5_1_1 ) ) );
    public final void rule__BuildEntry__Alternatives_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:571:1: ( ( ( rule__BuildEntry__ValueAssignment_5_1_0 ) ) | ( ( rule__BuildEntry__ValueAssignment_5_1_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_OBJ_Y) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_OBJ_M) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:572:1: ( ( rule__BuildEntry__ValueAssignment_5_1_0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:572:1: ( ( rule__BuildEntry__ValueAssignment_5_1_0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:573:1: ( rule__BuildEntry__ValueAssignment_5_1_0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getValueAssignment_5_1_0()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:574:1: ( rule__BuildEntry__ValueAssignment_5_1_0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:574:2: rule__BuildEntry__ValueAssignment_5_1_0
                    {
                    pushFollow(FOLLOW_rule__BuildEntry__ValueAssignment_5_1_0_in_rule__BuildEntry__Alternatives_5_11199);
                    rule__BuildEntry__ValueAssignment_5_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getValueAssignment_5_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:578:6: ( ( rule__BuildEntry__ValueAssignment_5_1_1 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:578:6: ( ( rule__BuildEntry__ValueAssignment_5_1_1 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:579:1: ( rule__BuildEntry__ValueAssignment_5_1_1 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getValueAssignment_5_1_1()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:580:1: ( rule__BuildEntry__ValueAssignment_5_1_1 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:580:2: rule__BuildEntry__ValueAssignment_5_1_1
                    {
                    pushFollow(FOLLOW_rule__BuildEntry__ValueAssignment_5_1_1_in_rule__BuildEntry__Alternatives_5_11217);
                    rule__BuildEntry__ValueAssignment_5_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getValueAssignment_5_1_1()); 

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
    // $ANTLR end "rule__BuildEntry__Alternatives_5_1"


    // $ANTLR start "rule__BuildEntry__Alternatives_6_3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:589:1: rule__BuildEntry__Alternatives_6_3 : ( ( RULE_SEMICOLON ) | ( ( rule__BuildEntry__Group_6_3_1__0 ) ) );
    public final void rule__BuildEntry__Alternatives_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:593:1: ( ( RULE_SEMICOLON ) | ( ( rule__BuildEntry__Group_6_3_1__0 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_SEMICOLON) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_STRING||LA5_0==RULE_SHELL_CHAR||(LA5_0>=RULE_BACKSLASH && LA5_0<=RULE_SYMBOL)||(LA5_0>=RULE_DOLLAR && LA5_0<=RULE_INCLUDE)) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:594:1: ( RULE_SEMICOLON )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:594:1: ( RULE_SEMICOLON )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:595:1: RULE_SEMICOLON
                    {
                     before(grammarAccess.getBuildEntryAccess().getSEMICOLONTerminalRuleCall_6_3_0()); 
                    match(input,RULE_SEMICOLON,FOLLOW_RULE_SEMICOLON_in_rule__BuildEntry__Alternatives_6_31250); 
                     after(grammarAccess.getBuildEntryAccess().getSEMICOLONTerminalRuleCall_6_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:600:6: ( ( rule__BuildEntry__Group_6_3_1__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:600:6: ( ( rule__BuildEntry__Group_6_3_1__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:601:1: ( rule__BuildEntry__Group_6_3_1__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_6_3_1()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:602:1: ( rule__BuildEntry__Group_6_3_1__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:602:2: rule__BuildEntry__Group_6_3_1__0
                    {
                    pushFollow(FOLLOW_rule__BuildEntry__Group_6_3_1__0_in_rule__BuildEntry__Alternatives_6_31267);
                    rule__BuildEntry__Group_6_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getGroup_6_3_1()); 

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
    // $ANTLR end "rule__BuildEntry__Alternatives_6_3"


    // $ANTLR start "rule__If__Alternatives_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:611:1: rule__If__Alternatives_1 : ( ( ( rule__If__Group_1_0__0 ) ) | ( ( rule__If__Group_1_1__0 ) ) );
    public final void rule__If__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:615:1: ( ( ( rule__If__Group_1_0__0 ) ) | ( ( rule__If__Group_1_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_DOLLAR) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==RULE_BRACE_START) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==RULE_SYMBOL) ) {
                        int LA6_5 = input.LA(4);

                        if ( (LA6_5==RULE_BRACE_END) ) {
                            alt6=1;
                        }
                        else if ( ((LA6_5>=RULE_STRING && LA6_5<=RULE_SHELL_CHAR)||(LA6_5>=RULE_BACKSLASH && LA6_5<=RULE_SYMBOL)||(LA6_5>=RULE_SLASH && LA6_5<=RULE_INCLUDE)) ) {
                            alt6=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_1==RULE_SYMBOL) ) {
                    alt6=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA6_0==RULE_INCLUDE) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:616:1: ( ( rule__If__Group_1_0__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:616:1: ( ( rule__If__Group_1_0__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:617:1: ( rule__If__Group_1_0__0 )
                    {
                     before(grammarAccess.getIfAccess().getGroup_1_0()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:618:1: ( rule__If__Group_1_0__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:618:2: rule__If__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__If__Group_1_0__0_in_rule__If__Alternatives_11300);
                    rule__If__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIfAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:622:6: ( ( rule__If__Group_1_1__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:622:6: ( ( rule__If__Group_1_1__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:623:1: ( rule__If__Group_1_1__0 )
                    {
                     before(grammarAccess.getIfAccess().getGroup_1_1()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:624:1: ( rule__If__Group_1_1__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:624:2: rule__If__Group_1_1__0
                    {
                    pushFollow(FOLLOW_rule__If__Group_1_1__0_in_rule__If__Alternatives_11318);
                    rule__If__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIfAccess().getGroup_1_1()); 

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
    // $ANTLR end "rule__If__Alternatives_1"


    // $ANTLR start "rule__If__Alternatives_1_0_2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:633:1: rule__If__Alternatives_1_0_2 : ( ( RULE_Y ) | ( RULE_M ) );
    public final void rule__If__Alternatives_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:637:1: ( ( RULE_Y ) | ( RULE_M ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_Y) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_M) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:638:1: ( RULE_Y )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:638:1: ( RULE_Y )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:639:1: RULE_Y
                    {
                     before(grammarAccess.getIfAccess().getYTerminalRuleCall_1_0_2_0()); 
                    match(input,RULE_Y,FOLLOW_RULE_Y_in_rule__If__Alternatives_1_0_21351); 
                     after(grammarAccess.getIfAccess().getYTerminalRuleCall_1_0_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:644:6: ( RULE_M )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:644:6: ( RULE_M )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:645:1: RULE_M
                    {
                     before(grammarAccess.getIfAccess().getMTerminalRuleCall_1_0_2_1()); 
                    match(input,RULE_M,FOLLOW_RULE_M_in_rule__If__Alternatives_1_0_21368); 
                     after(grammarAccess.getIfAccess().getMTerminalRuleCall_1_0_2_1()); 

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
    // $ANTLR end "rule__If__Alternatives_1_0_2"


    // $ANTLR start "rule__If__Alternatives_5"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:655:1: rule__If__Alternatives_5 : ( ( ( rule__If__ValueAssignment_5_0 ) ) | ( ( rule__If__ValueAssignment_5_1 ) ) | ( ( rule__If__ValueAssignment_5_2 ) ) | ( ( rule__If__ValueAssignment_5_3 ) ) );
    public final void rule__If__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:659:1: ( ( ( rule__If__ValueAssignment_5_0 ) ) | ( ( rule__If__ValueAssignment_5_1 ) ) | ( ( rule__If__ValueAssignment_5_2 ) ) | ( ( rule__If__ValueAssignment_5_3 ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case RULE_OBJ_Y:
                {
                alt8=1;
                }
                break;
            case RULE_OBJ_M:
                {
                alt8=2;
                }
                break;
            case RULE_OBJ_START:
                {
                alt8=3;
                }
                break;
            case RULE_DOLLAR:
            case RULE_INCLUDE:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:660:1: ( ( rule__If__ValueAssignment_5_0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:660:1: ( ( rule__If__ValueAssignment_5_0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:661:1: ( rule__If__ValueAssignment_5_0 )
                    {
                     before(grammarAccess.getIfAccess().getValueAssignment_5_0()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:662:1: ( rule__If__ValueAssignment_5_0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:662:2: rule__If__ValueAssignment_5_0
                    {
                    pushFollow(FOLLOW_rule__If__ValueAssignment_5_0_in_rule__If__Alternatives_51400);
                    rule__If__ValueAssignment_5_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIfAccess().getValueAssignment_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:666:6: ( ( rule__If__ValueAssignment_5_1 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:666:6: ( ( rule__If__ValueAssignment_5_1 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:667:1: ( rule__If__ValueAssignment_5_1 )
                    {
                     before(grammarAccess.getIfAccess().getValueAssignment_5_1()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:668:1: ( rule__If__ValueAssignment_5_1 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:668:2: rule__If__ValueAssignment_5_1
                    {
                    pushFollow(FOLLOW_rule__If__ValueAssignment_5_1_in_rule__If__Alternatives_51418);
                    rule__If__ValueAssignment_5_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getIfAccess().getValueAssignment_5_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:672:6: ( ( rule__If__ValueAssignment_5_2 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:672:6: ( ( rule__If__ValueAssignment_5_2 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:673:1: ( rule__If__ValueAssignment_5_2 )
                    {
                     before(grammarAccess.getIfAccess().getValueAssignment_5_2()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:674:1: ( rule__If__ValueAssignment_5_2 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:674:2: rule__If__ValueAssignment_5_2
                    {
                    pushFollow(FOLLOW_rule__If__ValueAssignment_5_2_in_rule__If__Alternatives_51436);
                    rule__If__ValueAssignment_5_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getIfAccess().getValueAssignment_5_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:678:6: ( ( rule__If__ValueAssignment_5_3 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:678:6: ( ( rule__If__ValueAssignment_5_3 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:679:1: ( rule__If__ValueAssignment_5_3 )
                    {
                     before(grammarAccess.getIfAccess().getValueAssignment_5_3()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:680:1: ( rule__If__ValueAssignment_5_3 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:680:2: rule__If__ValueAssignment_5_3
                    {
                    pushFollow(FOLLOW_rule__If__ValueAssignment_5_3_in_rule__If__Alternatives_51454);
                    rule__If__ValueAssignment_5_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getIfAccess().getValueAssignment_5_3()); 

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
    // $ANTLR end "rule__If__Alternatives_5"


    // $ANTLR start "rule__If__Alternatives_7_3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:689:1: rule__If__Alternatives_7_3 : ( ( ( rule__If__ElsevalueAssignment_7_3_0 ) ) | ( ( rule__If__ElsevalueAssignment_7_3_1 ) ) );
    public final void rule__If__Alternatives_7_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:693:1: ( ( ( rule__If__ElsevalueAssignment_7_3_0 ) ) | ( ( rule__If__ElsevalueAssignment_7_3_1 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_OBJ_Y) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_OBJ_M) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:694:1: ( ( rule__If__ElsevalueAssignment_7_3_0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:694:1: ( ( rule__If__ElsevalueAssignment_7_3_0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:695:1: ( rule__If__ElsevalueAssignment_7_3_0 )
                    {
                     before(grammarAccess.getIfAccess().getElsevalueAssignment_7_3_0()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:696:1: ( rule__If__ElsevalueAssignment_7_3_0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:696:2: rule__If__ElsevalueAssignment_7_3_0
                    {
                    pushFollow(FOLLOW_rule__If__ElsevalueAssignment_7_3_0_in_rule__If__Alternatives_7_31487);
                    rule__If__ElsevalueAssignment_7_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIfAccess().getElsevalueAssignment_7_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:700:6: ( ( rule__If__ElsevalueAssignment_7_3_1 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:700:6: ( ( rule__If__ElsevalueAssignment_7_3_1 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:701:1: ( rule__If__ElsevalueAssignment_7_3_1 )
                    {
                     before(grammarAccess.getIfAccess().getElsevalueAssignment_7_3_1()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:702:1: ( rule__If__ElsevalueAssignment_7_3_1 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:702:2: rule__If__ElsevalueAssignment_7_3_1
                    {
                    pushFollow(FOLLOW_rule__If__ElsevalueAssignment_7_3_1_in_rule__If__Alternatives_7_31505);
                    rule__If__ElsevalueAssignment_7_3_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getIfAccess().getElsevalueAssignment_7_3_1()); 

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
    // $ANTLR end "rule__If__Alternatives_7_3"


    // $ANTLR start "rule__AssignExtra__Alternatives_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:711:1: rule__AssignExtra__Alternatives_1 : ( ( RULE_PLUS ) | ( RULE_DPOINT ) );
    public final void rule__AssignExtra__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:715:1: ( ( RULE_PLUS ) | ( RULE_DPOINT ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_PLUS) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_DPOINT) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:716:1: ( RULE_PLUS )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:716:1: ( RULE_PLUS )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:717:1: RULE_PLUS
                    {
                     before(grammarAccess.getAssignExtraAccess().getPLUSTerminalRuleCall_1_0()); 
                    match(input,RULE_PLUS,FOLLOW_RULE_PLUS_in_rule__AssignExtra__Alternatives_11538); 
                     after(grammarAccess.getAssignExtraAccess().getPLUSTerminalRuleCall_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:722:6: ( RULE_DPOINT )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:722:6: ( RULE_DPOINT )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:723:1: RULE_DPOINT
                    {
                     before(grammarAccess.getAssignExtraAccess().getDPOINTTerminalRuleCall_1_1()); 
                    match(input,RULE_DPOINT,FOLLOW_RULE_DPOINT_in_rule__AssignExtra__Alternatives_11555); 
                     after(grammarAccess.getAssignExtraAccess().getDPOINTTerminalRuleCall_1_1()); 

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
    // $ANTLR end "rule__AssignExtra__Alternatives_1"


    // $ANTLR start "rule__Value__Alternatives"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:733:1: rule__Value__Alternatives : ( ( ( rule__Value__Group_0__0 ) ) | ( ( rule__Value__Group_1__0 ) ) | ( ( rule__Value__Group_2__0 ) ) | ( ( rule__Value__Group_3__0 ) ) | ( ( rule__Value__Group_4__0 ) ) | ( ( rule__Value__Group_5__0 ) ) | ( ( rule__Value__Group_6__0 ) ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:737:1: ( ( ( rule__Value__Group_0__0 ) ) | ( ( rule__Value__Group_1__0 ) ) | ( ( rule__Value__Group_2__0 ) ) | ( ( rule__Value__Group_3__0 ) ) | ( ( rule__Value__Group_4__0 ) ) | ( ( rule__Value__Group_5__0 ) ) | ( ( rule__Value__Group_6__0 ) ) )
            int alt11=7;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:738:1: ( ( rule__Value__Group_0__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:738:1: ( ( rule__Value__Group_0__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:739:1: ( rule__Value__Group_0__0 )
                    {
                     before(grammarAccess.getValueAccess().getGroup_0()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:740:1: ( rule__Value__Group_0__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:740:2: rule__Value__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Value__Group_0__0_in_rule__Value__Alternatives1587);
                    rule__Value__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:744:6: ( ( rule__Value__Group_1__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:744:6: ( ( rule__Value__Group_1__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:745:1: ( rule__Value__Group_1__0 )
                    {
                     before(grammarAccess.getValueAccess().getGroup_1()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:746:1: ( rule__Value__Group_1__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:746:2: rule__Value__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Value__Group_1__0_in_rule__Value__Alternatives1605);
                    rule__Value__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:750:6: ( ( rule__Value__Group_2__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:750:6: ( ( rule__Value__Group_2__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:751:1: ( rule__Value__Group_2__0 )
                    {
                     before(grammarAccess.getValueAccess().getGroup_2()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:752:1: ( rule__Value__Group_2__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:752:2: rule__Value__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Value__Group_2__0_in_rule__Value__Alternatives1623);
                    rule__Value__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:756:6: ( ( rule__Value__Group_3__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:756:6: ( ( rule__Value__Group_3__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:757:1: ( rule__Value__Group_3__0 )
                    {
                     before(grammarAccess.getValueAccess().getGroup_3()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:758:1: ( rule__Value__Group_3__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:758:2: rule__Value__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Value__Group_3__0_in_rule__Value__Alternatives1641);
                    rule__Value__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:762:6: ( ( rule__Value__Group_4__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:762:6: ( ( rule__Value__Group_4__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:763:1: ( rule__Value__Group_4__0 )
                    {
                     before(grammarAccess.getValueAccess().getGroup_4()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:764:1: ( rule__Value__Group_4__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:764:2: rule__Value__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Value__Group_4__0_in_rule__Value__Alternatives1659);
                    rule__Value__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:768:6: ( ( rule__Value__Group_5__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:768:6: ( ( rule__Value__Group_5__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:769:1: ( rule__Value__Group_5__0 )
                    {
                     before(grammarAccess.getValueAccess().getGroup_5()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:770:1: ( rule__Value__Group_5__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:770:2: rule__Value__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Value__Group_5__0_in_rule__Value__Alternatives1677);
                    rule__Value__Group_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getGroup_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:774:6: ( ( rule__Value__Group_6__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:774:6: ( ( rule__Value__Group_6__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:775:1: ( rule__Value__Group_6__0 )
                    {
                     before(grammarAccess.getValueAccess().getGroup_6()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:776:1: ( rule__Value__Group_6__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:776:2: rule__Value__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__Value__Group_6__0_in_rule__Value__Alternatives1695);
                    rule__Value__Group_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getGroup_6()); 

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
    // $ANTLR end "rule__Value__Alternatives"


    // $ANTLR start "rule__Variable__Alternatives"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:785:1: rule__Variable__Alternatives : ( ( ( rule__Variable__Group_0__0 ) ) | ( ( rule__Variable__Group_1__0 ) ) );
    public final void rule__Variable__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:789:1: ( ( ( rule__Variable__Group_0__0 ) ) | ( ( rule__Variable__Group_1__0 ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_DOLLAR) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==RULE_BRACE_START) ) {
                    alt12=2;
                }
                else if ( (LA12_1==RULE_SYMBOL) ) {
                    alt12=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:790:1: ( ( rule__Variable__Group_0__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:790:1: ( ( rule__Variable__Group_0__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:791:1: ( rule__Variable__Group_0__0 )
                    {
                     before(grammarAccess.getVariableAccess().getGroup_0()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:792:1: ( rule__Variable__Group_0__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:792:2: rule__Variable__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Variable__Group_0__0_in_rule__Variable__Alternatives1728);
                    rule__Variable__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVariableAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:796:6: ( ( rule__Variable__Group_1__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:796:6: ( ( rule__Variable__Group_1__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:797:1: ( rule__Variable__Group_1__0 )
                    {
                     before(grammarAccess.getVariableAccess().getGroup_1()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:798:1: ( rule__Variable__Group_1__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:798:2: rule__Variable__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Variable__Group_1__0_in_rule__Variable__Alternatives1746);
                    rule__Variable__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVariableAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Variable__Alternatives"


    // $ANTLR start "rule__ShellCmd__Alternatives"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:807:1: rule__ShellCmd__Alternatives : ( ( ( rule__ShellCmd__Group_0__0 ) ) | ( ( rule__ShellCmd__Group_1__0 ) ) );
    public final void rule__ShellCmd__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:811:1: ( ( ( rule__ShellCmd__Group_0__0 ) ) | ( ( rule__ShellCmd__Group_1__0 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_DOLLAR) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_INCLUDE) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:812:1: ( ( rule__ShellCmd__Group_0__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:812:1: ( ( rule__ShellCmd__Group_0__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:813:1: ( rule__ShellCmd__Group_0__0 )
                    {
                     before(grammarAccess.getShellCmdAccess().getGroup_0()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:814:1: ( rule__ShellCmd__Group_0__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:814:2: rule__ShellCmd__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ShellCmd__Group_0__0_in_rule__ShellCmd__Alternatives1779);
                    rule__ShellCmd__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getShellCmdAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:818:6: ( ( rule__ShellCmd__Group_1__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:818:6: ( ( rule__ShellCmd__Group_1__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:819:1: ( rule__ShellCmd__Group_1__0 )
                    {
                     before(grammarAccess.getShellCmdAccess().getGroup_1()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:820:1: ( rule__ShellCmd__Group_1__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:820:2: rule__ShellCmd__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ShellCmd__Group_1__0_in_rule__ShellCmd__Alternatives1797);
                    rule__ShellCmd__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getShellCmdAccess().getGroup_1()); 

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
    // $ANTLR end "rule__ShellCmd__Alternatives"


    // $ANTLR start "rule__ShellPart__Alternatives_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:829:1: rule__ShellPart__Alternatives_1 : ( ( ( rule__ShellPart__ValAssignment_1_0 ) ) | ( ( rule__ShellPart__CmdAssignment_1_1 ) ) | ( RULE_STRING ) | ( RULE_COMMA ) | ( RULE_SHELL_CHAR ) | ( ( rule__ShellPart__Group_1_5__0 ) ) );
    public final void rule__ShellPart__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:833:1: ( ( ( rule__ShellPart__ValAssignment_1_0 ) ) | ( ( rule__ShellPart__CmdAssignment_1_1 ) ) | ( RULE_STRING ) | ( RULE_COMMA ) | ( RULE_SHELL_CHAR ) | ( ( rule__ShellPart__Group_1_5__0 ) ) )
            int alt14=6;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:834:1: ( ( rule__ShellPart__ValAssignment_1_0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:834:1: ( ( rule__ShellPart__ValAssignment_1_0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:835:1: ( rule__ShellPart__ValAssignment_1_0 )
                    {
                     before(grammarAccess.getShellPartAccess().getValAssignment_1_0()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:836:1: ( rule__ShellPart__ValAssignment_1_0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:836:2: rule__ShellPart__ValAssignment_1_0
                    {
                    pushFollow(FOLLOW_rule__ShellPart__ValAssignment_1_0_in_rule__ShellPart__Alternatives_11830);
                    rule__ShellPart__ValAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getShellPartAccess().getValAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:840:6: ( ( rule__ShellPart__CmdAssignment_1_1 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:840:6: ( ( rule__ShellPart__CmdAssignment_1_1 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:841:1: ( rule__ShellPart__CmdAssignment_1_1 )
                    {
                     before(grammarAccess.getShellPartAccess().getCmdAssignment_1_1()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:842:1: ( rule__ShellPart__CmdAssignment_1_1 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:842:2: rule__ShellPart__CmdAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__ShellPart__CmdAssignment_1_1_in_rule__ShellPart__Alternatives_11848);
                    rule__ShellPart__CmdAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getShellPartAccess().getCmdAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:846:6: ( RULE_STRING )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:846:6: ( RULE_STRING )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:847:1: RULE_STRING
                    {
                     before(grammarAccess.getShellPartAccess().getSTRINGTerminalRuleCall_1_2()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ShellPart__Alternatives_11866); 
                     after(grammarAccess.getShellPartAccess().getSTRINGTerminalRuleCall_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:852:6: ( RULE_COMMA )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:852:6: ( RULE_COMMA )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:853:1: RULE_COMMA
                    {
                     before(grammarAccess.getShellPartAccess().getCOMMATerminalRuleCall_1_3()); 
                    match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_rule__ShellPart__Alternatives_11883); 
                     after(grammarAccess.getShellPartAccess().getCOMMATerminalRuleCall_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:858:6: ( RULE_SHELL_CHAR )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:858:6: ( RULE_SHELL_CHAR )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:859:1: RULE_SHELL_CHAR
                    {
                     before(grammarAccess.getShellPartAccess().getSHELL_CHARTerminalRuleCall_1_4()); 
                    match(input,RULE_SHELL_CHAR,FOLLOW_RULE_SHELL_CHAR_in_rule__ShellPart__Alternatives_11900); 
                     after(grammarAccess.getShellPartAccess().getSHELL_CHARTerminalRuleCall_1_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:864:6: ( ( rule__ShellPart__Group_1_5__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:864:6: ( ( rule__ShellPart__Group_1_5__0 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:865:1: ( rule__ShellPart__Group_1_5__0 )
                    {
                     before(grammarAccess.getShellPartAccess().getGroup_1_5()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:866:1: ( rule__ShellPart__Group_1_5__0 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:866:2: rule__ShellPart__Group_1_5__0
                    {
                    pushFollow(FOLLOW_rule__ShellPart__Group_1_5__0_in_rule__ShellPart__Alternatives_11917);
                    rule__ShellPart__Group_1_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getShellPartAccess().getGroup_1_5()); 

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
    // $ANTLR end "rule__ShellPart__Alternatives_1"


    // $ANTLR start "rule__VarSlashSym__Alternatives"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:875:1: rule__VarSlashSym__Alternatives : ( ( ruleVariable ) | ( ( rule__VarSlashSym__NameAssignment_1 ) ) | ( ( rule__VarSlashSym__NameAssignment_2 ) ) );
    public final void rule__VarSlashSym__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:879:1: ( ( ruleVariable ) | ( ( rule__VarSlashSym__NameAssignment_1 ) ) | ( ( rule__VarSlashSym__NameAssignment_2 ) ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case RULE_DOLLAR:
                {
                alt15=1;
                }
                break;
            case RULE_SLASH:
                {
                alt15=2;
                }
                break;
            case RULE_SYMBOL:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:880:1: ( ruleVariable )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:880:1: ( ruleVariable )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:881:1: ruleVariable
                    {
                     before(grammarAccess.getVarSlashSymAccess().getVariableParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleVariable_in_rule__VarSlashSym__Alternatives1950);
                    ruleVariable();

                    state._fsp--;

                     after(grammarAccess.getVarSlashSymAccess().getVariableParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:886:6: ( ( rule__VarSlashSym__NameAssignment_1 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:886:6: ( ( rule__VarSlashSym__NameAssignment_1 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:887:1: ( rule__VarSlashSym__NameAssignment_1 )
                    {
                     before(grammarAccess.getVarSlashSymAccess().getNameAssignment_1()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:888:1: ( rule__VarSlashSym__NameAssignment_1 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:888:2: rule__VarSlashSym__NameAssignment_1
                    {
                    pushFollow(FOLLOW_rule__VarSlashSym__NameAssignment_1_in_rule__VarSlashSym__Alternatives1967);
                    rule__VarSlashSym__NameAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getVarSlashSymAccess().getNameAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:892:6: ( ( rule__VarSlashSym__NameAssignment_2 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:892:6: ( ( rule__VarSlashSym__NameAssignment_2 ) )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:893:1: ( rule__VarSlashSym__NameAssignment_2 )
                    {
                     before(grammarAccess.getVarSlashSymAccess().getNameAssignment_2()); 
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:894:1: ( rule__VarSlashSym__NameAssignment_2 )
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:894:2: rule__VarSlashSym__NameAssignment_2
                    {
                    pushFollow(FOLLOW_rule__VarSlashSym__NameAssignment_2_in_rule__VarSlashSym__Alternatives1985);
                    rule__VarSlashSym__NameAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getVarSlashSymAccess().getNameAssignment_2()); 

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
    // $ANTLR end "rule__VarSlashSym__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:905:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:909:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:910:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__02016);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02019);
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
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:917:1: rule__Model__Group__0__Impl : ( () ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:921:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:922:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:922:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:923:1: ()
            {
             before(grammarAccess.getModelAccess().getModelAction_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:924:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:926:1: 
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
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:936:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:940:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:941:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__12077);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__12080);
            rule__Model__Group__2();

            state._fsp--;


            }

        }
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
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:948:1: rule__Model__Group__1__Impl : ( ( rule__Model__BuildEntryAssignment_1 )? ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:952:1: ( ( ( rule__Model__BuildEntryAssignment_1 )? ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:953:1: ( ( rule__Model__BuildEntryAssignment_1 )? )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:953:1: ( ( rule__Model__BuildEntryAssignment_1 )? )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:954:1: ( rule__Model__BuildEntryAssignment_1 )?
            {
             before(grammarAccess.getModelAccess().getBuildEntryAssignment_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:955:1: ( rule__Model__BuildEntryAssignment_1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_STRING||(LA16_0>=RULE_SHELL_CHAR && LA16_0<=RULE_IFNDEF)||LA16_0==RULE_OBJ_START||(LA16_0>=RULE_OBJ_Y && LA16_0<=RULE_OBJ_M)||(LA16_0>=RULE_BACKSLASH && LA16_0<=RULE_SYMBOL)||(LA16_0>=RULE_DOLLAR && LA16_0<=RULE_INCLUDE)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:955:2: rule__Model__BuildEntryAssignment_1
                    {
                    pushFollow(FOLLOW_rule__Model__BuildEntryAssignment_1_in_rule__Model__Group__1__Impl2107);
                    rule__Model__BuildEntryAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getBuildEntryAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Model__Group__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:965:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:969:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:970:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__22138);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__3_in_rule__Model__Group__22141);
            rule__Model__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:977:1: rule__Model__Group__2__Impl : ( ( rule__Model__Group_2__0 )* ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:981:1: ( ( ( rule__Model__Group_2__0 )* ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:982:1: ( ( rule__Model__Group_2__0 )* )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:982:1: ( ( rule__Model__Group_2__0 )* )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:983:1: ( rule__Model__Group_2__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:984:1: ( rule__Model__Group_2__0 )*
            loop17:
            do {
                int alt17=2;
                alt17 = dfa17.predict(input);
                switch (alt17) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:984:2: rule__Model__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Model__Group_2__0_in_rule__Model__Group__2__Impl2168);
            	    rule__Model__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__Model__Group__3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:994:1: rule__Model__Group__3 : rule__Model__Group__3__Impl ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:998:1: ( rule__Model__Group__3__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:999:2: rule__Model__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__32199);
            rule__Model__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3"


    // $ANTLR start "rule__Model__Group__3__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1005:1: rule__Model__Group__3__Impl : ( ruleEol ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1009:1: ( ( ruleEol ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1010:1: ( ruleEol )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1010:1: ( ruleEol )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1011:1: ruleEol
            {
             before(grammarAccess.getModelAccess().getEolParserRuleCall_3()); 
            pushFollow(FOLLOW_ruleEol_in_rule__Model__Group__3__Impl2226);
            ruleEol();

            state._fsp--;

             after(grammarAccess.getModelAccess().getEolParserRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3__Impl"


    // $ANTLR start "rule__Model__Group_2__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1030:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1034:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1035:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
            {
            pushFollow(FOLLOW_rule__Model__Group_2__0__Impl_in_rule__Model__Group_2__02263);
            rule__Model__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group_2__1_in_rule__Model__Group_2__02266);
            rule__Model__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__0"


    // $ANTLR start "rule__Model__Group_2__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1042:1: rule__Model__Group_2__0__Impl : ( ruleEol ) ;
    public final void rule__Model__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1046:1: ( ( ruleEol ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1047:1: ( ruleEol )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1047:1: ( ruleEol )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1048:1: ruleEol
            {
             before(grammarAccess.getModelAccess().getEolParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleEol_in_rule__Model__Group_2__0__Impl2293);
            ruleEol();

            state._fsp--;

             after(grammarAccess.getModelAccess().getEolParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__0__Impl"


    // $ANTLR start "rule__Model__Group_2__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1059:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1063:1: ( rule__Model__Group_2__1__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1064:2: rule__Model__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group_2__1__Impl_in_rule__Model__Group_2__12322);
            rule__Model__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__1"


    // $ANTLR start "rule__Model__Group_2__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1070:1: rule__Model__Group_2__1__Impl : ( ( rule__Model__BuildEntryAssignment_2_1 ) ) ;
    public final void rule__Model__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1074:1: ( ( ( rule__Model__BuildEntryAssignment_2_1 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1075:1: ( ( rule__Model__BuildEntryAssignment_2_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1075:1: ( ( rule__Model__BuildEntryAssignment_2_1 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1076:1: ( rule__Model__BuildEntryAssignment_2_1 )
            {
             before(grammarAccess.getModelAccess().getBuildEntryAssignment_2_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1077:1: ( rule__Model__BuildEntryAssignment_2_1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1077:2: rule__Model__BuildEntryAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Model__BuildEntryAssignment_2_1_in_rule__Model__Group_2__1__Impl2349);
            rule__Model__BuildEntryAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getBuildEntryAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__1__Impl"


    // $ANTLR start "rule__BuildEntry__Group_0__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1091:1: rule__BuildEntry__Group_0__0 : rule__BuildEntry__Group_0__0__Impl rule__BuildEntry__Group_0__1 ;
    public final void rule__BuildEntry__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1095:1: ( rule__BuildEntry__Group_0__0__Impl rule__BuildEntry__Group_0__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1096:2: rule__BuildEntry__Group_0__0__Impl rule__BuildEntry__Group_0__1
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_0__0__Impl_in_rule__BuildEntry__Group_0__02383);
            rule__BuildEntry__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_0__1_in_rule__BuildEntry__Group_0__02386);
            rule__BuildEntry__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_0__0"


    // $ANTLR start "rule__BuildEntry__Group_0__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1103:1: rule__BuildEntry__Group_0__0__Impl : ( () ) ;
    public final void rule__BuildEntry__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1107:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1108:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1108:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1109:1: ()
            {
             before(grammarAccess.getBuildEntryAccess().getBuildEntryAction_0_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1110:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1112:1: 
            {
            }

             after(grammarAccess.getBuildEntryAccess().getBuildEntryAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_0__0__Impl"


    // $ANTLR start "rule__BuildEntry__Group_0__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1122:1: rule__BuildEntry__Group_0__1 : rule__BuildEntry__Group_0__1__Impl ;
    public final void rule__BuildEntry__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1126:1: ( rule__BuildEntry__Group_0__1__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1127:2: rule__BuildEntry__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_0__1__Impl_in_rule__BuildEntry__Group_0__12444);
            rule__BuildEntry__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_0__1"


    // $ANTLR start "rule__BuildEntry__Group_0__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1133:1: rule__BuildEntry__Group_0__1__Impl : ( ( rule__BuildEntry__ValueAssignment_0_1 ) ) ;
    public final void rule__BuildEntry__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1137:1: ( ( ( rule__BuildEntry__ValueAssignment_0_1 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1138:1: ( ( rule__BuildEntry__ValueAssignment_0_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1138:1: ( ( rule__BuildEntry__ValueAssignment_0_1 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1139:1: ( rule__BuildEntry__ValueAssignment_0_1 )
            {
             before(grammarAccess.getBuildEntryAccess().getValueAssignment_0_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1140:1: ( rule__BuildEntry__ValueAssignment_0_1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1140:2: rule__BuildEntry__ValueAssignment_0_1
            {
            pushFollow(FOLLOW_rule__BuildEntry__ValueAssignment_0_1_in_rule__BuildEntry__Group_0__1__Impl2471);
            rule__BuildEntry__ValueAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getBuildEntryAccess().getValueAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_0__1__Impl"


    // $ANTLR start "rule__BuildEntry__Group_1__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1154:1: rule__BuildEntry__Group_1__0 : rule__BuildEntry__Group_1__0__Impl rule__BuildEntry__Group_1__1 ;
    public final void rule__BuildEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1158:1: ( rule__BuildEntry__Group_1__0__Impl rule__BuildEntry__Group_1__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1159:2: rule__BuildEntry__Group_1__0__Impl rule__BuildEntry__Group_1__1
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_1__0__Impl_in_rule__BuildEntry__Group_1__02505);
            rule__BuildEntry__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_1__1_in_rule__BuildEntry__Group_1__02508);
            rule__BuildEntry__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_1__0"


    // $ANTLR start "rule__BuildEntry__Group_1__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1166:1: rule__BuildEntry__Group_1__0__Impl : ( () ) ;
    public final void rule__BuildEntry__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1170:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1171:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1171:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1172:1: ()
            {
             before(grammarAccess.getBuildEntryAccess().getIfEqAction_1_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1173:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1175:1: 
            {
            }

             after(grammarAccess.getBuildEntryAccess().getIfEqAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_1__0__Impl"


    // $ANTLR start "rule__BuildEntry__Group_1__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1185:1: rule__BuildEntry__Group_1__1 : rule__BuildEntry__Group_1__1__Impl rule__BuildEntry__Group_1__2 ;
    public final void rule__BuildEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1189:1: ( rule__BuildEntry__Group_1__1__Impl rule__BuildEntry__Group_1__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1190:2: rule__BuildEntry__Group_1__1__Impl rule__BuildEntry__Group_1__2
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_1__1__Impl_in_rule__BuildEntry__Group_1__12566);
            rule__BuildEntry__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_1__2_in_rule__BuildEntry__Group_1__12569);
            rule__BuildEntry__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_1__1"


    // $ANTLR start "rule__BuildEntry__Group_1__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1197:1: rule__BuildEntry__Group_1__1__Impl : ( RULE_IFEQ ) ;
    public final void rule__BuildEntry__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1201:1: ( ( RULE_IFEQ ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1202:1: ( RULE_IFEQ )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1202:1: ( RULE_IFEQ )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1203:1: RULE_IFEQ
            {
             before(grammarAccess.getBuildEntryAccess().getIFEQTerminalRuleCall_1_1()); 
            match(input,RULE_IFEQ,FOLLOW_RULE_IFEQ_in_rule__BuildEntry__Group_1__1__Impl2596); 
             after(grammarAccess.getBuildEntryAccess().getIFEQTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_1__1__Impl"


    // $ANTLR start "rule__BuildEntry__Group_1__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1214:1: rule__BuildEntry__Group_1__2 : rule__BuildEntry__Group_1__2__Impl ;
    public final void rule__BuildEntry__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1218:1: ( rule__BuildEntry__Group_1__2__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1219:2: rule__BuildEntry__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_1__2__Impl_in_rule__BuildEntry__Group_1__22625);
            rule__BuildEntry__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_1__2"


    // $ANTLR start "rule__BuildEntry__Group_1__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1225:1: rule__BuildEntry__Group_1__2__Impl : ( ( rule__BuildEntry__ValueAssignment_1_2 ) ) ;
    public final void rule__BuildEntry__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1229:1: ( ( ( rule__BuildEntry__ValueAssignment_1_2 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1230:1: ( ( rule__BuildEntry__ValueAssignment_1_2 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1230:1: ( ( rule__BuildEntry__ValueAssignment_1_2 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1231:1: ( rule__BuildEntry__ValueAssignment_1_2 )
            {
             before(grammarAccess.getBuildEntryAccess().getValueAssignment_1_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1232:1: ( rule__BuildEntry__ValueAssignment_1_2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1232:2: rule__BuildEntry__ValueAssignment_1_2
            {
            pushFollow(FOLLOW_rule__BuildEntry__ValueAssignment_1_2_in_rule__BuildEntry__Group_1__2__Impl2652);
            rule__BuildEntry__ValueAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getBuildEntryAccess().getValueAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_1__2__Impl"


    // $ANTLR start "rule__BuildEntry__Group_2__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1248:1: rule__BuildEntry__Group_2__0 : rule__BuildEntry__Group_2__0__Impl rule__BuildEntry__Group_2__1 ;
    public final void rule__BuildEntry__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1252:1: ( rule__BuildEntry__Group_2__0__Impl rule__BuildEntry__Group_2__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1253:2: rule__BuildEntry__Group_2__0__Impl rule__BuildEntry__Group_2__1
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_2__0__Impl_in_rule__BuildEntry__Group_2__02688);
            rule__BuildEntry__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_2__1_in_rule__BuildEntry__Group_2__02691);
            rule__BuildEntry__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_2__0"


    // $ANTLR start "rule__BuildEntry__Group_2__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1260:1: rule__BuildEntry__Group_2__0__Impl : ( () ) ;
    public final void rule__BuildEntry__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1264:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1265:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1265:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1266:1: ()
            {
             before(grammarAccess.getBuildEntryAccess().getIfNEqAction_2_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1267:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1269:1: 
            {
            }

             after(grammarAccess.getBuildEntryAccess().getIfNEqAction_2_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_2__0__Impl"


    // $ANTLR start "rule__BuildEntry__Group_2__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1279:1: rule__BuildEntry__Group_2__1 : rule__BuildEntry__Group_2__1__Impl rule__BuildEntry__Group_2__2 ;
    public final void rule__BuildEntry__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1283:1: ( rule__BuildEntry__Group_2__1__Impl rule__BuildEntry__Group_2__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1284:2: rule__BuildEntry__Group_2__1__Impl rule__BuildEntry__Group_2__2
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_2__1__Impl_in_rule__BuildEntry__Group_2__12749);
            rule__BuildEntry__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_2__2_in_rule__BuildEntry__Group_2__12752);
            rule__BuildEntry__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_2__1"


    // $ANTLR start "rule__BuildEntry__Group_2__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1291:1: rule__BuildEntry__Group_2__1__Impl : ( RULE_IFNEQ ) ;
    public final void rule__BuildEntry__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1295:1: ( ( RULE_IFNEQ ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1296:1: ( RULE_IFNEQ )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1296:1: ( RULE_IFNEQ )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1297:1: RULE_IFNEQ
            {
             before(grammarAccess.getBuildEntryAccess().getIFNEQTerminalRuleCall_2_1()); 
            match(input,RULE_IFNEQ,FOLLOW_RULE_IFNEQ_in_rule__BuildEntry__Group_2__1__Impl2779); 
             after(grammarAccess.getBuildEntryAccess().getIFNEQTerminalRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_2__1__Impl"


    // $ANTLR start "rule__BuildEntry__Group_2__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1308:1: rule__BuildEntry__Group_2__2 : rule__BuildEntry__Group_2__2__Impl ;
    public final void rule__BuildEntry__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1312:1: ( rule__BuildEntry__Group_2__2__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1313:2: rule__BuildEntry__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_2__2__Impl_in_rule__BuildEntry__Group_2__22808);
            rule__BuildEntry__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_2__2"


    // $ANTLR start "rule__BuildEntry__Group_2__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1319:1: rule__BuildEntry__Group_2__2__Impl : ( ( rule__BuildEntry__ValueAssignment_2_2 ) ) ;
    public final void rule__BuildEntry__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1323:1: ( ( ( rule__BuildEntry__ValueAssignment_2_2 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1324:1: ( ( rule__BuildEntry__ValueAssignment_2_2 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1324:1: ( ( rule__BuildEntry__ValueAssignment_2_2 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1325:1: ( rule__BuildEntry__ValueAssignment_2_2 )
            {
             before(grammarAccess.getBuildEntryAccess().getValueAssignment_2_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1326:1: ( rule__BuildEntry__ValueAssignment_2_2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1326:2: rule__BuildEntry__ValueAssignment_2_2
            {
            pushFollow(FOLLOW_rule__BuildEntry__ValueAssignment_2_2_in_rule__BuildEntry__Group_2__2__Impl2835);
            rule__BuildEntry__ValueAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getBuildEntryAccess().getValueAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_2__2__Impl"


    // $ANTLR start "rule__BuildEntry__Group_3__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1342:1: rule__BuildEntry__Group_3__0 : rule__BuildEntry__Group_3__0__Impl rule__BuildEntry__Group_3__1 ;
    public final void rule__BuildEntry__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1346:1: ( rule__BuildEntry__Group_3__0__Impl rule__BuildEntry__Group_3__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1347:2: rule__BuildEntry__Group_3__0__Impl rule__BuildEntry__Group_3__1
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_3__0__Impl_in_rule__BuildEntry__Group_3__02871);
            rule__BuildEntry__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_3__1_in_rule__BuildEntry__Group_3__02874);
            rule__BuildEntry__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_3__0"


    // $ANTLR start "rule__BuildEntry__Group_3__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1354:1: rule__BuildEntry__Group_3__0__Impl : ( () ) ;
    public final void rule__BuildEntry__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1358:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1359:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1359:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1360:1: ()
            {
             before(grammarAccess.getBuildEntryAccess().getIfndefAction_3_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1361:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1363:1: 
            {
            }

             after(grammarAccess.getBuildEntryAccess().getIfndefAction_3_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_3__0__Impl"


    // $ANTLR start "rule__BuildEntry__Group_3__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1373:1: rule__BuildEntry__Group_3__1 : rule__BuildEntry__Group_3__1__Impl rule__BuildEntry__Group_3__2 ;
    public final void rule__BuildEntry__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1377:1: ( rule__BuildEntry__Group_3__1__Impl rule__BuildEntry__Group_3__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1378:2: rule__BuildEntry__Group_3__1__Impl rule__BuildEntry__Group_3__2
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_3__1__Impl_in_rule__BuildEntry__Group_3__12932);
            rule__BuildEntry__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_3__2_in_rule__BuildEntry__Group_3__12935);
            rule__BuildEntry__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_3__1"


    // $ANTLR start "rule__BuildEntry__Group_3__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1385:1: rule__BuildEntry__Group_3__1__Impl : ( RULE_IFNDEF ) ;
    public final void rule__BuildEntry__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1389:1: ( ( RULE_IFNDEF ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1390:1: ( RULE_IFNDEF )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1390:1: ( RULE_IFNDEF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1391:1: RULE_IFNDEF
            {
             before(grammarAccess.getBuildEntryAccess().getIFNDEFTerminalRuleCall_3_1()); 
            match(input,RULE_IFNDEF,FOLLOW_RULE_IFNDEF_in_rule__BuildEntry__Group_3__1__Impl2962); 
             after(grammarAccess.getBuildEntryAccess().getIFNDEFTerminalRuleCall_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_3__1__Impl"


    // $ANTLR start "rule__BuildEntry__Group_3__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1402:1: rule__BuildEntry__Group_3__2 : rule__BuildEntry__Group_3__2__Impl rule__BuildEntry__Group_3__3 ;
    public final void rule__BuildEntry__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1406:1: ( rule__BuildEntry__Group_3__2__Impl rule__BuildEntry__Group_3__3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1407:2: rule__BuildEntry__Group_3__2__Impl rule__BuildEntry__Group_3__3
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_3__2__Impl_in_rule__BuildEntry__Group_3__22991);
            rule__BuildEntry__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_3__3_in_rule__BuildEntry__Group_3__22994);
            rule__BuildEntry__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_3__2"


    // $ANTLR start "rule__BuildEntry__Group_3__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1414:1: rule__BuildEntry__Group_3__2__Impl : ( ( rule__BuildEntry__NameAssignment_3_2 ) ) ;
    public final void rule__BuildEntry__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1418:1: ( ( ( rule__BuildEntry__NameAssignment_3_2 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1419:1: ( ( rule__BuildEntry__NameAssignment_3_2 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1419:1: ( ( rule__BuildEntry__NameAssignment_3_2 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1420:1: ( rule__BuildEntry__NameAssignment_3_2 )
            {
             before(grammarAccess.getBuildEntryAccess().getNameAssignment_3_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1421:1: ( rule__BuildEntry__NameAssignment_3_2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1421:2: rule__BuildEntry__NameAssignment_3_2
            {
            pushFollow(FOLLOW_rule__BuildEntry__NameAssignment_3_2_in_rule__BuildEntry__Group_3__2__Impl3021);
            rule__BuildEntry__NameAssignment_3_2();

            state._fsp--;


            }

             after(grammarAccess.getBuildEntryAccess().getNameAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_3__2__Impl"


    // $ANTLR start "rule__BuildEntry__Group_3__3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1431:1: rule__BuildEntry__Group_3__3 : rule__BuildEntry__Group_3__3__Impl rule__BuildEntry__Group_3__4 ;
    public final void rule__BuildEntry__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1435:1: ( rule__BuildEntry__Group_3__3__Impl rule__BuildEntry__Group_3__4 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1436:2: rule__BuildEntry__Group_3__3__Impl rule__BuildEntry__Group_3__4
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_3__3__Impl_in_rule__BuildEntry__Group_3__33051);
            rule__BuildEntry__Group_3__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_3__4_in_rule__BuildEntry__Group_3__33054);
            rule__BuildEntry__Group_3__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_3__3"


    // $ANTLR start "rule__BuildEntry__Group_3__3__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1443:1: rule__BuildEntry__Group_3__3__Impl : ( ruleEol ) ;
    public final void rule__BuildEntry__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1447:1: ( ( ruleEol ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1448:1: ( ruleEol )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1448:1: ( ruleEol )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1449:1: ruleEol
            {
             before(grammarAccess.getBuildEntryAccess().getEolParserRuleCall_3_3()); 
            pushFollow(FOLLOW_ruleEol_in_rule__BuildEntry__Group_3__3__Impl3081);
            ruleEol();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getEolParserRuleCall_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_3__3__Impl"


    // $ANTLR start "rule__BuildEntry__Group_3__4"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1460:1: rule__BuildEntry__Group_3__4 : rule__BuildEntry__Group_3__4__Impl rule__BuildEntry__Group_3__5 ;
    public final void rule__BuildEntry__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1464:1: ( rule__BuildEntry__Group_3__4__Impl rule__BuildEntry__Group_3__5 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1465:2: rule__BuildEntry__Group_3__4__Impl rule__BuildEntry__Group_3__5
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_3__4__Impl_in_rule__BuildEntry__Group_3__43110);
            rule__BuildEntry__Group_3__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_3__5_in_rule__BuildEntry__Group_3__43113);
            rule__BuildEntry__Group_3__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_3__4"


    // $ANTLR start "rule__BuildEntry__Group_3__4__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1472:1: rule__BuildEntry__Group_3__4__Impl : ( ( rule__BuildEntry__Alternatives_3_4 ) ) ;
    public final void rule__BuildEntry__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1476:1: ( ( ( rule__BuildEntry__Alternatives_3_4 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1477:1: ( ( rule__BuildEntry__Alternatives_3_4 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1477:1: ( ( rule__BuildEntry__Alternatives_3_4 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1478:1: ( rule__BuildEntry__Alternatives_3_4 )
            {
             before(grammarAccess.getBuildEntryAccess().getAlternatives_3_4()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1479:1: ( rule__BuildEntry__Alternatives_3_4 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1479:2: rule__BuildEntry__Alternatives_3_4
            {
            pushFollow(FOLLOW_rule__BuildEntry__Alternatives_3_4_in_rule__BuildEntry__Group_3__4__Impl3140);
            rule__BuildEntry__Alternatives_3_4();

            state._fsp--;


            }

             after(grammarAccess.getBuildEntryAccess().getAlternatives_3_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_3__4__Impl"


    // $ANTLR start "rule__BuildEntry__Group_3__5"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1489:1: rule__BuildEntry__Group_3__5 : rule__BuildEntry__Group_3__5__Impl rule__BuildEntry__Group_3__6 ;
    public final void rule__BuildEntry__Group_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1493:1: ( rule__BuildEntry__Group_3__5__Impl rule__BuildEntry__Group_3__6 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1494:2: rule__BuildEntry__Group_3__5__Impl rule__BuildEntry__Group_3__6
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_3__5__Impl_in_rule__BuildEntry__Group_3__53170);
            rule__BuildEntry__Group_3__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_3__6_in_rule__BuildEntry__Group_3__53173);
            rule__BuildEntry__Group_3__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_3__5"


    // $ANTLR start "rule__BuildEntry__Group_3__5__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1501:1: rule__BuildEntry__Group_3__5__Impl : ( ruleEol ) ;
    public final void rule__BuildEntry__Group_3__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1505:1: ( ( ruleEol ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1506:1: ( ruleEol )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1506:1: ( ruleEol )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1507:1: ruleEol
            {
             before(grammarAccess.getBuildEntryAccess().getEolParserRuleCall_3_5()); 
            pushFollow(FOLLOW_ruleEol_in_rule__BuildEntry__Group_3__5__Impl3200);
            ruleEol();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getEolParserRuleCall_3_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_3__5__Impl"


    // $ANTLR start "rule__BuildEntry__Group_3__6"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1518:1: rule__BuildEntry__Group_3__6 : rule__BuildEntry__Group_3__6__Impl ;
    public final void rule__BuildEntry__Group_3__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1522:1: ( rule__BuildEntry__Group_3__6__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1523:2: rule__BuildEntry__Group_3__6__Impl
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_3__6__Impl_in_rule__BuildEntry__Group_3__63229);
            rule__BuildEntry__Group_3__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_3__6"


    // $ANTLR start "rule__BuildEntry__Group_3__6__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1529:1: rule__BuildEntry__Group_3__6__Impl : ( RULE_ENDIF ) ;
    public final void rule__BuildEntry__Group_3__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1533:1: ( ( RULE_ENDIF ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1534:1: ( RULE_ENDIF )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1534:1: ( RULE_ENDIF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1535:1: RULE_ENDIF
            {
             before(grammarAccess.getBuildEntryAccess().getENDIFTerminalRuleCall_3_6()); 
            match(input,RULE_ENDIF,FOLLOW_RULE_ENDIF_in_rule__BuildEntry__Group_3__6__Impl3256); 
             after(grammarAccess.getBuildEntryAccess().getENDIFTerminalRuleCall_3_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_3__6__Impl"


    // $ANTLR start "rule__BuildEntry__Group_4__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1560:1: rule__BuildEntry__Group_4__0 : rule__BuildEntry__Group_4__0__Impl rule__BuildEntry__Group_4__1 ;
    public final void rule__BuildEntry__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1564:1: ( rule__BuildEntry__Group_4__0__Impl rule__BuildEntry__Group_4__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1565:2: rule__BuildEntry__Group_4__0__Impl rule__BuildEntry__Group_4__1
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_4__0__Impl_in_rule__BuildEntry__Group_4__03299);
            rule__BuildEntry__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_4__1_in_rule__BuildEntry__Group_4__03302);
            rule__BuildEntry__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_4__0"


    // $ANTLR start "rule__BuildEntry__Group_4__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1572:1: rule__BuildEntry__Group_4__0__Impl : ( () ) ;
    public final void rule__BuildEntry__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1576:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1577:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1577:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1578:1: ()
            {
             before(grammarAccess.getBuildEntryAccess().getHostProgramAction_4_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1579:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1581:1: 
            {
            }

             after(grammarAccess.getBuildEntryAccess().getHostProgramAction_4_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_4__0__Impl"


    // $ANTLR start "rule__BuildEntry__Group_4__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1591:1: rule__BuildEntry__Group_4__1 : rule__BuildEntry__Group_4__1__Impl rule__BuildEntry__Group_4__2 ;
    public final void rule__BuildEntry__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1595:1: ( rule__BuildEntry__Group_4__1__Impl rule__BuildEntry__Group_4__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1596:2: rule__BuildEntry__Group_4__1__Impl rule__BuildEntry__Group_4__2
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_4__1__Impl_in_rule__BuildEntry__Group_4__13360);
            rule__BuildEntry__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_4__2_in_rule__BuildEntry__Group_4__13363);
            rule__BuildEntry__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_4__1"


    // $ANTLR start "rule__BuildEntry__Group_4__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1603:1: rule__BuildEntry__Group_4__1__Impl : ( ( rule__BuildEntry__NameAssignment_4_1 ) ) ;
    public final void rule__BuildEntry__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1607:1: ( ( ( rule__BuildEntry__NameAssignment_4_1 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1608:1: ( ( rule__BuildEntry__NameAssignment_4_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1608:1: ( ( rule__BuildEntry__NameAssignment_4_1 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1609:1: ( rule__BuildEntry__NameAssignment_4_1 )
            {
             before(grammarAccess.getBuildEntryAccess().getNameAssignment_4_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1610:1: ( rule__BuildEntry__NameAssignment_4_1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1610:2: rule__BuildEntry__NameAssignment_4_1
            {
            pushFollow(FOLLOW_rule__BuildEntry__NameAssignment_4_1_in_rule__BuildEntry__Group_4__1__Impl3390);
            rule__BuildEntry__NameAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getBuildEntryAccess().getNameAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_4__1__Impl"


    // $ANTLR start "rule__BuildEntry__Group_4__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1620:1: rule__BuildEntry__Group_4__2 : rule__BuildEntry__Group_4__2__Impl rule__BuildEntry__Group_4__3 ;
    public final void rule__BuildEntry__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1624:1: ( rule__BuildEntry__Group_4__2__Impl rule__BuildEntry__Group_4__3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1625:2: rule__BuildEntry__Group_4__2__Impl rule__BuildEntry__Group_4__3
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_4__2__Impl_in_rule__BuildEntry__Group_4__23420);
            rule__BuildEntry__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_4__3_in_rule__BuildEntry__Group_4__23423);
            rule__BuildEntry__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_4__2"


    // $ANTLR start "rule__BuildEntry__Group_4__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1632:1: rule__BuildEntry__Group_4__2__Impl : ( ( rule__BuildEntry__VariableAssignment_4_2 )? ) ;
    public final void rule__BuildEntry__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1636:1: ( ( ( rule__BuildEntry__VariableAssignment_4_2 )? ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1637:1: ( ( rule__BuildEntry__VariableAssignment_4_2 )? )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1637:1: ( ( rule__BuildEntry__VariableAssignment_4_2 )? )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1638:1: ( rule__BuildEntry__VariableAssignment_4_2 )?
            {
             before(grammarAccess.getBuildEntryAccess().getVariableAssignment_4_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1639:1: ( rule__BuildEntry__VariableAssignment_4_2 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_DOLLAR) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1639:2: rule__BuildEntry__VariableAssignment_4_2
                    {
                    pushFollow(FOLLOW_rule__BuildEntry__VariableAssignment_4_2_in_rule__BuildEntry__Group_4__2__Impl3450);
                    rule__BuildEntry__VariableAssignment_4_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBuildEntryAccess().getVariableAssignment_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_4__2__Impl"


    // $ANTLR start "rule__BuildEntry__Group_4__3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1649:1: rule__BuildEntry__Group_4__3 : rule__BuildEntry__Group_4__3__Impl rule__BuildEntry__Group_4__4 ;
    public final void rule__BuildEntry__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1653:1: ( rule__BuildEntry__Group_4__3__Impl rule__BuildEntry__Group_4__4 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1654:2: rule__BuildEntry__Group_4__3__Impl rule__BuildEntry__Group_4__4
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_4__3__Impl_in_rule__BuildEntry__Group_4__33481);
            rule__BuildEntry__Group_4__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_4__4_in_rule__BuildEntry__Group_4__33484);
            rule__BuildEntry__Group_4__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_4__3"


    // $ANTLR start "rule__BuildEntry__Group_4__3__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1661:1: rule__BuildEntry__Group_4__3__Impl : ( ( rule__BuildEntry__ValueAssignment_4_3 ) ) ;
    public final void rule__BuildEntry__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1665:1: ( ( ( rule__BuildEntry__ValueAssignment_4_3 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1666:1: ( ( rule__BuildEntry__ValueAssignment_4_3 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1666:1: ( ( rule__BuildEntry__ValueAssignment_4_3 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1667:1: ( rule__BuildEntry__ValueAssignment_4_3 )
            {
             before(grammarAccess.getBuildEntryAccess().getValueAssignment_4_3()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1668:1: ( rule__BuildEntry__ValueAssignment_4_3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1668:2: rule__BuildEntry__ValueAssignment_4_3
            {
            pushFollow(FOLLOW_rule__BuildEntry__ValueAssignment_4_3_in_rule__BuildEntry__Group_4__3__Impl3511);
            rule__BuildEntry__ValueAssignment_4_3();

            state._fsp--;


            }

             after(grammarAccess.getBuildEntryAccess().getValueAssignment_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_4__3__Impl"


    // $ANTLR start "rule__BuildEntry__Group_4__4"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1678:1: rule__BuildEntry__Group_4__4 : rule__BuildEntry__Group_4__4__Impl ;
    public final void rule__BuildEntry__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1682:1: ( rule__BuildEntry__Group_4__4__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1683:2: rule__BuildEntry__Group_4__4__Impl
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_4__4__Impl_in_rule__BuildEntry__Group_4__43541);
            rule__BuildEntry__Group_4__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_4__4"


    // $ANTLR start "rule__BuildEntry__Group_4__4__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1689:1: rule__BuildEntry__Group_4__4__Impl : ( ( rule__BuildEntry__InnerAssignment_4_4 )? ) ;
    public final void rule__BuildEntry__Group_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1693:1: ( ( ( rule__BuildEntry__InnerAssignment_4_4 )? ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1694:1: ( ( rule__BuildEntry__InnerAssignment_4_4 )? )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1694:1: ( ( rule__BuildEntry__InnerAssignment_4_4 )? )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1695:1: ( rule__BuildEntry__InnerAssignment_4_4 )?
            {
             before(grammarAccess.getBuildEntryAccess().getInnerAssignment_4_4()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1696:1: ( rule__BuildEntry__InnerAssignment_4_4 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_EQ) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1696:2: rule__BuildEntry__InnerAssignment_4_4
                    {
                    pushFollow(FOLLOW_rule__BuildEntry__InnerAssignment_4_4_in_rule__BuildEntry__Group_4__4__Impl3568);
                    rule__BuildEntry__InnerAssignment_4_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBuildEntryAccess().getInnerAssignment_4_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_4__4__Impl"


    // $ANTLR start "rule__BuildEntry__Group_5__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1716:1: rule__BuildEntry__Group_5__0 : rule__BuildEntry__Group_5__0__Impl rule__BuildEntry__Group_5__1 ;
    public final void rule__BuildEntry__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1720:1: ( rule__BuildEntry__Group_5__0__Impl rule__BuildEntry__Group_5__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1721:2: rule__BuildEntry__Group_5__0__Impl rule__BuildEntry__Group_5__1
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_5__0__Impl_in_rule__BuildEntry__Group_5__03609);
            rule__BuildEntry__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_5__1_in_rule__BuildEntry__Group_5__03612);
            rule__BuildEntry__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_5__0"


    // $ANTLR start "rule__BuildEntry__Group_5__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1728:1: rule__BuildEntry__Group_5__0__Impl : ( () ) ;
    public final void rule__BuildEntry__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1732:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1733:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1733:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1734:1: ()
            {
             before(grammarAccess.getBuildEntryAccess().getObjectAction_5_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1735:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1737:1: 
            {
            }

             after(grammarAccess.getBuildEntryAccess().getObjectAction_5_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_5__0__Impl"


    // $ANTLR start "rule__BuildEntry__Group_5__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1747:1: rule__BuildEntry__Group_5__1 : rule__BuildEntry__Group_5__1__Impl ;
    public final void rule__BuildEntry__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1751:1: ( rule__BuildEntry__Group_5__1__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1752:2: rule__BuildEntry__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_5__1__Impl_in_rule__BuildEntry__Group_5__13670);
            rule__BuildEntry__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_5__1"


    // $ANTLR start "rule__BuildEntry__Group_5__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1758:1: rule__BuildEntry__Group_5__1__Impl : ( ( rule__BuildEntry__Alternatives_5_1 ) ) ;
    public final void rule__BuildEntry__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1762:1: ( ( ( rule__BuildEntry__Alternatives_5_1 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1763:1: ( ( rule__BuildEntry__Alternatives_5_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1763:1: ( ( rule__BuildEntry__Alternatives_5_1 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1764:1: ( rule__BuildEntry__Alternatives_5_1 )
            {
             before(grammarAccess.getBuildEntryAccess().getAlternatives_5_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1765:1: ( rule__BuildEntry__Alternatives_5_1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1765:2: rule__BuildEntry__Alternatives_5_1
            {
            pushFollow(FOLLOW_rule__BuildEntry__Alternatives_5_1_in_rule__BuildEntry__Group_5__1__Impl3697);
            rule__BuildEntry__Alternatives_5_1();

            state._fsp--;


            }

             after(grammarAccess.getBuildEntryAccess().getAlternatives_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_5__1__Impl"


    // $ANTLR start "rule__BuildEntry__Group_6__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1779:1: rule__BuildEntry__Group_6__0 : rule__BuildEntry__Group_6__0__Impl rule__BuildEntry__Group_6__1 ;
    public final void rule__BuildEntry__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1783:1: ( rule__BuildEntry__Group_6__0__Impl rule__BuildEntry__Group_6__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1784:2: rule__BuildEntry__Group_6__0__Impl rule__BuildEntry__Group_6__1
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_6__0__Impl_in_rule__BuildEntry__Group_6__03731);
            rule__BuildEntry__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_6__1_in_rule__BuildEntry__Group_6__03734);
            rule__BuildEntry__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6__0"


    // $ANTLR start "rule__BuildEntry__Group_6__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1791:1: rule__BuildEntry__Group_6__0__Impl : ( () ) ;
    public final void rule__BuildEntry__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1795:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1796:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1796:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1797:1: ()
            {
             before(grammarAccess.getBuildEntryAccess().getTargetAction_6_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1798:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1800:1: 
            {
            }

             after(grammarAccess.getBuildEntryAccess().getTargetAction_6_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6__0__Impl"


    // $ANTLR start "rule__BuildEntry__Group_6__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1810:1: rule__BuildEntry__Group_6__1 : rule__BuildEntry__Group_6__1__Impl rule__BuildEntry__Group_6__2 ;
    public final void rule__BuildEntry__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1814:1: ( rule__BuildEntry__Group_6__1__Impl rule__BuildEntry__Group_6__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1815:2: rule__BuildEntry__Group_6__1__Impl rule__BuildEntry__Group_6__2
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_6__1__Impl_in_rule__BuildEntry__Group_6__13792);
            rule__BuildEntry__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_6__2_in_rule__BuildEntry__Group_6__13795);
            rule__BuildEntry__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6__1"


    // $ANTLR start "rule__BuildEntry__Group_6__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1822:1: rule__BuildEntry__Group_6__1__Impl : ( ( rule__BuildEntry__TargetAssignment_6_1 ) ) ;
    public final void rule__BuildEntry__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1826:1: ( ( ( rule__BuildEntry__TargetAssignment_6_1 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1827:1: ( ( rule__BuildEntry__TargetAssignment_6_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1827:1: ( ( rule__BuildEntry__TargetAssignment_6_1 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1828:1: ( rule__BuildEntry__TargetAssignment_6_1 )
            {
             before(grammarAccess.getBuildEntryAccess().getTargetAssignment_6_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1829:1: ( rule__BuildEntry__TargetAssignment_6_1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1829:2: rule__BuildEntry__TargetAssignment_6_1
            {
            pushFollow(FOLLOW_rule__BuildEntry__TargetAssignment_6_1_in_rule__BuildEntry__Group_6__1__Impl3822);
            rule__BuildEntry__TargetAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getBuildEntryAccess().getTargetAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6__1__Impl"


    // $ANTLR start "rule__BuildEntry__Group_6__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1839:1: rule__BuildEntry__Group_6__2 : rule__BuildEntry__Group_6__2__Impl rule__BuildEntry__Group_6__3 ;
    public final void rule__BuildEntry__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1843:1: ( rule__BuildEntry__Group_6__2__Impl rule__BuildEntry__Group_6__3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1844:2: rule__BuildEntry__Group_6__2__Impl rule__BuildEntry__Group_6__3
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_6__2__Impl_in_rule__BuildEntry__Group_6__23852);
            rule__BuildEntry__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_6__3_in_rule__BuildEntry__Group_6__23855);
            rule__BuildEntry__Group_6__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6__2"


    // $ANTLR start "rule__BuildEntry__Group_6__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1851:1: rule__BuildEntry__Group_6__2__Impl : ( RULE_DPOINT ) ;
    public final void rule__BuildEntry__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1855:1: ( ( RULE_DPOINT ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1856:1: ( RULE_DPOINT )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1856:1: ( RULE_DPOINT )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1857:1: RULE_DPOINT
            {
             before(grammarAccess.getBuildEntryAccess().getDPOINTTerminalRuleCall_6_2()); 
            match(input,RULE_DPOINT,FOLLOW_RULE_DPOINT_in_rule__BuildEntry__Group_6__2__Impl3882); 
             after(grammarAccess.getBuildEntryAccess().getDPOINTTerminalRuleCall_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6__2__Impl"


    // $ANTLR start "rule__BuildEntry__Group_6__3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1868:1: rule__BuildEntry__Group_6__3 : rule__BuildEntry__Group_6__3__Impl ;
    public final void rule__BuildEntry__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1872:1: ( rule__BuildEntry__Group_6__3__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1873:2: rule__BuildEntry__Group_6__3__Impl
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_6__3__Impl_in_rule__BuildEntry__Group_6__33911);
            rule__BuildEntry__Group_6__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6__3"


    // $ANTLR start "rule__BuildEntry__Group_6__3__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1879:1: rule__BuildEntry__Group_6__3__Impl : ( ( rule__BuildEntry__Alternatives_6_3 ) ) ;
    public final void rule__BuildEntry__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1883:1: ( ( ( rule__BuildEntry__Alternatives_6_3 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1884:1: ( ( rule__BuildEntry__Alternatives_6_3 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1884:1: ( ( rule__BuildEntry__Alternatives_6_3 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1885:1: ( rule__BuildEntry__Alternatives_6_3 )
            {
             before(grammarAccess.getBuildEntryAccess().getAlternatives_6_3()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1886:1: ( rule__BuildEntry__Alternatives_6_3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1886:2: rule__BuildEntry__Alternatives_6_3
            {
            pushFollow(FOLLOW_rule__BuildEntry__Alternatives_6_3_in_rule__BuildEntry__Group_6__3__Impl3938);
            rule__BuildEntry__Alternatives_6_3();

            state._fsp--;


            }

             after(grammarAccess.getBuildEntryAccess().getAlternatives_6_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6__3__Impl"


    // $ANTLR start "rule__BuildEntry__Group_6_3_1__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1904:1: rule__BuildEntry__Group_6_3_1__0 : rule__BuildEntry__Group_6_3_1__0__Impl rule__BuildEntry__Group_6_3_1__1 ;
    public final void rule__BuildEntry__Group_6_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1908:1: ( rule__BuildEntry__Group_6_3_1__0__Impl rule__BuildEntry__Group_6_3_1__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1909:2: rule__BuildEntry__Group_6_3_1__0__Impl rule__BuildEntry__Group_6_3_1__1
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_6_3_1__0__Impl_in_rule__BuildEntry__Group_6_3_1__03976);
            rule__BuildEntry__Group_6_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_6_3_1__1_in_rule__BuildEntry__Group_6_3_1__03979);
            rule__BuildEntry__Group_6_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6_3_1__0"


    // $ANTLR start "rule__BuildEntry__Group_6_3_1__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1916:1: rule__BuildEntry__Group_6_3_1__0__Impl : ( ( rule__BuildEntry__ValuesAssignment_6_3_1_0 ) ) ;
    public final void rule__BuildEntry__Group_6_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1920:1: ( ( ( rule__BuildEntry__ValuesAssignment_6_3_1_0 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1921:1: ( ( rule__BuildEntry__ValuesAssignment_6_3_1_0 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1921:1: ( ( rule__BuildEntry__ValuesAssignment_6_3_1_0 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1922:1: ( rule__BuildEntry__ValuesAssignment_6_3_1_0 )
            {
             before(grammarAccess.getBuildEntryAccess().getValuesAssignment_6_3_1_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1923:1: ( rule__BuildEntry__ValuesAssignment_6_3_1_0 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1923:2: rule__BuildEntry__ValuesAssignment_6_3_1_0
            {
            pushFollow(FOLLOW_rule__BuildEntry__ValuesAssignment_6_3_1_0_in_rule__BuildEntry__Group_6_3_1__0__Impl4006);
            rule__BuildEntry__ValuesAssignment_6_3_1_0();

            state._fsp--;


            }

             after(grammarAccess.getBuildEntryAccess().getValuesAssignment_6_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6_3_1__0__Impl"


    // $ANTLR start "rule__BuildEntry__Group_6_3_1__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1933:1: rule__BuildEntry__Group_6_3_1__1 : rule__BuildEntry__Group_6_3_1__1__Impl ;
    public final void rule__BuildEntry__Group_6_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1937:1: ( rule__BuildEntry__Group_6_3_1__1__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1938:2: rule__BuildEntry__Group_6_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_6_3_1__1__Impl_in_rule__BuildEntry__Group_6_3_1__14036);
            rule__BuildEntry__Group_6_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6_3_1__1"


    // $ANTLR start "rule__BuildEntry__Group_6_3_1__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1944:1: rule__BuildEntry__Group_6_3_1__1__Impl : ( ( rule__BuildEntry__Group_6_3_1_1__0 )* ) ;
    public final void rule__BuildEntry__Group_6_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1948:1: ( ( ( rule__BuildEntry__Group_6_3_1_1__0 )* ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1949:1: ( ( rule__BuildEntry__Group_6_3_1_1__0 )* )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1949:1: ( ( rule__BuildEntry__Group_6_3_1_1__0 )* )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1950:1: ( rule__BuildEntry__Group_6_3_1_1__0 )*
            {
             before(grammarAccess.getBuildEntryAccess().getGroup_6_3_1_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1951:1: ( rule__BuildEntry__Group_6_3_1_1__0 )*
            loop20:
            do {
                int alt20=2;
                alt20 = dfa20.predict(input);
                switch (alt20) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1951:2: rule__BuildEntry__Group_6_3_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__BuildEntry__Group_6_3_1_1__0_in_rule__BuildEntry__Group_6_3_1__1__Impl4063);
            	    rule__BuildEntry__Group_6_3_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getBuildEntryAccess().getGroup_6_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6_3_1__1__Impl"


    // $ANTLR start "rule__BuildEntry__Group_6_3_1_1__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1965:1: rule__BuildEntry__Group_6_3_1_1__0 : rule__BuildEntry__Group_6_3_1_1__0__Impl rule__BuildEntry__Group_6_3_1_1__1 ;
    public final void rule__BuildEntry__Group_6_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1969:1: ( rule__BuildEntry__Group_6_3_1_1__0__Impl rule__BuildEntry__Group_6_3_1_1__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1970:2: rule__BuildEntry__Group_6_3_1_1__0__Impl rule__BuildEntry__Group_6_3_1_1__1
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_6_3_1_1__0__Impl_in_rule__BuildEntry__Group_6_3_1_1__04098);
            rule__BuildEntry__Group_6_3_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_6_3_1_1__1_in_rule__BuildEntry__Group_6_3_1_1__04101);
            rule__BuildEntry__Group_6_3_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6_3_1_1__0"


    // $ANTLR start "rule__BuildEntry__Group_6_3_1_1__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1977:1: rule__BuildEntry__Group_6_3_1_1__0__Impl : ( ruleEol ) ;
    public final void rule__BuildEntry__Group_6_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1981:1: ( ( ruleEol ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1982:1: ( ruleEol )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1982:1: ( ruleEol )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1983:1: ruleEol
            {
             before(grammarAccess.getBuildEntryAccess().getEolParserRuleCall_6_3_1_1_0()); 
            pushFollow(FOLLOW_ruleEol_in_rule__BuildEntry__Group_6_3_1_1__0__Impl4128);
            ruleEol();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getEolParserRuleCall_6_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6_3_1_1__0__Impl"


    // $ANTLR start "rule__BuildEntry__Group_6_3_1_1__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1994:1: rule__BuildEntry__Group_6_3_1_1__1 : rule__BuildEntry__Group_6_3_1_1__1__Impl rule__BuildEntry__Group_6_3_1_1__2 ;
    public final void rule__BuildEntry__Group_6_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1998:1: ( rule__BuildEntry__Group_6_3_1_1__1__Impl rule__BuildEntry__Group_6_3_1_1__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:1999:2: rule__BuildEntry__Group_6_3_1_1__1__Impl rule__BuildEntry__Group_6_3_1_1__2
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_6_3_1_1__1__Impl_in_rule__BuildEntry__Group_6_3_1_1__14157);
            rule__BuildEntry__Group_6_3_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_6_3_1_1__2_in_rule__BuildEntry__Group_6_3_1_1__14160);
            rule__BuildEntry__Group_6_3_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6_3_1_1__1"


    // $ANTLR start "rule__BuildEntry__Group_6_3_1_1__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2006:1: rule__BuildEntry__Group_6_3_1_1__1__Impl : ( ( ( RULE_TAB ) ) ( ( RULE_TAB )* ) ) ;
    public final void rule__BuildEntry__Group_6_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2010:1: ( ( ( ( RULE_TAB ) ) ( ( RULE_TAB )* ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2011:1: ( ( ( RULE_TAB ) ) ( ( RULE_TAB )* ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2011:1: ( ( ( RULE_TAB ) ) ( ( RULE_TAB )* ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2012:1: ( ( RULE_TAB ) ) ( ( RULE_TAB )* )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2012:1: ( ( RULE_TAB ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2013:1: ( RULE_TAB )
            {
             before(grammarAccess.getBuildEntryAccess().getTABTerminalRuleCall_6_3_1_1_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2014:1: ( RULE_TAB )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2014:3: RULE_TAB
            {
            match(input,RULE_TAB,FOLLOW_RULE_TAB_in_rule__BuildEntry__Group_6_3_1_1__1__Impl4190); 

            }

             after(grammarAccess.getBuildEntryAccess().getTABTerminalRuleCall_6_3_1_1_1()); 

            }

            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2017:1: ( ( RULE_TAB )* )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2018:1: ( RULE_TAB )*
            {
             before(grammarAccess.getBuildEntryAccess().getTABTerminalRuleCall_6_3_1_1_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2019:1: ( RULE_TAB )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_TAB) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2019:3: RULE_TAB
            	    {
            	    match(input,RULE_TAB,FOLLOW_RULE_TAB_in_rule__BuildEntry__Group_6_3_1_1__1__Impl4203); 

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getBuildEntryAccess().getTABTerminalRuleCall_6_3_1_1_1()); 

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
    // $ANTLR end "rule__BuildEntry__Group_6_3_1_1__1__Impl"


    // $ANTLR start "rule__BuildEntry__Group_6_3_1_1__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2030:1: rule__BuildEntry__Group_6_3_1_1__2 : rule__BuildEntry__Group_6_3_1_1__2__Impl ;
    public final void rule__BuildEntry__Group_6_3_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2034:1: ( rule__BuildEntry__Group_6_3_1_1__2__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2035:2: rule__BuildEntry__Group_6_3_1_1__2__Impl
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_6_3_1_1__2__Impl_in_rule__BuildEntry__Group_6_3_1_1__24236);
            rule__BuildEntry__Group_6_3_1_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6_3_1_1__2"


    // $ANTLR start "rule__BuildEntry__Group_6_3_1_1__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2041:1: rule__BuildEntry__Group_6_3_1_1__2__Impl : ( ( rule__BuildEntry__ValuesAssignment_6_3_1_1_2 ) ) ;
    public final void rule__BuildEntry__Group_6_3_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2045:1: ( ( ( rule__BuildEntry__ValuesAssignment_6_3_1_1_2 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2046:1: ( ( rule__BuildEntry__ValuesAssignment_6_3_1_1_2 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2046:1: ( ( rule__BuildEntry__ValuesAssignment_6_3_1_1_2 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2047:1: ( rule__BuildEntry__ValuesAssignment_6_3_1_1_2 )
            {
             before(grammarAccess.getBuildEntryAccess().getValuesAssignment_6_3_1_1_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2048:1: ( rule__BuildEntry__ValuesAssignment_6_3_1_1_2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2048:2: rule__BuildEntry__ValuesAssignment_6_3_1_1_2
            {
            pushFollow(FOLLOW_rule__BuildEntry__ValuesAssignment_6_3_1_1_2_in_rule__BuildEntry__Group_6_3_1_1__2__Impl4263);
            rule__BuildEntry__ValuesAssignment_6_3_1_1_2();

            state._fsp--;


            }

             after(grammarAccess.getBuildEntryAccess().getValuesAssignment_6_3_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_6_3_1_1__2__Impl"


    // $ANTLR start "rule__BuildEntry__Group_7__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2064:1: rule__BuildEntry__Group_7__0 : rule__BuildEntry__Group_7__0__Impl rule__BuildEntry__Group_7__1 ;
    public final void rule__BuildEntry__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2068:1: ( rule__BuildEntry__Group_7__0__Impl rule__BuildEntry__Group_7__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2069:2: rule__BuildEntry__Group_7__0__Impl rule__BuildEntry__Group_7__1
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_7__0__Impl_in_rule__BuildEntry__Group_7__04299);
            rule__BuildEntry__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_7__1_in_rule__BuildEntry__Group_7__04302);
            rule__BuildEntry__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_7__0"


    // $ANTLR start "rule__BuildEntry__Group_7__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2076:1: rule__BuildEntry__Group_7__0__Impl : ( () ) ;
    public final void rule__BuildEntry__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2080:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2081:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2081:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2082:1: ()
            {
             before(grammarAccess.getBuildEntryAccess().getMyVariableAction_7_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2083:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2085:1: 
            {
            }

             after(grammarAccess.getBuildEntryAccess().getMyVariableAction_7_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_7__0__Impl"


    // $ANTLR start "rule__BuildEntry__Group_7__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2095:1: rule__BuildEntry__Group_7__1 : rule__BuildEntry__Group_7__1__Impl rule__BuildEntry__Group_7__2 ;
    public final void rule__BuildEntry__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2099:1: ( rule__BuildEntry__Group_7__1__Impl rule__BuildEntry__Group_7__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2100:2: rule__BuildEntry__Group_7__1__Impl rule__BuildEntry__Group_7__2
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_7__1__Impl_in_rule__BuildEntry__Group_7__14360);
            rule__BuildEntry__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_7__2_in_rule__BuildEntry__Group_7__14363);
            rule__BuildEntry__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_7__1"


    // $ANTLR start "rule__BuildEntry__Group_7__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2107:1: rule__BuildEntry__Group_7__1__Impl : ( ( rule__BuildEntry__NameAssignment_7_1 ) ) ;
    public final void rule__BuildEntry__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2111:1: ( ( ( rule__BuildEntry__NameAssignment_7_1 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2112:1: ( ( rule__BuildEntry__NameAssignment_7_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2112:1: ( ( rule__BuildEntry__NameAssignment_7_1 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2113:1: ( rule__BuildEntry__NameAssignment_7_1 )
            {
             before(grammarAccess.getBuildEntryAccess().getNameAssignment_7_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2114:1: ( rule__BuildEntry__NameAssignment_7_1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2114:2: rule__BuildEntry__NameAssignment_7_1
            {
            pushFollow(FOLLOW_rule__BuildEntry__NameAssignment_7_1_in_rule__BuildEntry__Group_7__1__Impl4390);
            rule__BuildEntry__NameAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getBuildEntryAccess().getNameAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_7__1__Impl"


    // $ANTLR start "rule__BuildEntry__Group_7__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2124:1: rule__BuildEntry__Group_7__2 : rule__BuildEntry__Group_7__2__Impl rule__BuildEntry__Group_7__3 ;
    public final void rule__BuildEntry__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2128:1: ( rule__BuildEntry__Group_7__2__Impl rule__BuildEntry__Group_7__3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2129:2: rule__BuildEntry__Group_7__2__Impl rule__BuildEntry__Group_7__3
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_7__2__Impl_in_rule__BuildEntry__Group_7__24420);
            rule__BuildEntry__Group_7__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BuildEntry__Group_7__3_in_rule__BuildEntry__Group_7__24423);
            rule__BuildEntry__Group_7__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_7__2"


    // $ANTLR start "rule__BuildEntry__Group_7__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2136:1: rule__BuildEntry__Group_7__2__Impl : ( ( rule__BuildEntry__VariableAssignment_7_2 )? ) ;
    public final void rule__BuildEntry__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2140:1: ( ( ( rule__BuildEntry__VariableAssignment_7_2 )? ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2141:1: ( ( rule__BuildEntry__VariableAssignment_7_2 )? )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2141:1: ( ( rule__BuildEntry__VariableAssignment_7_2 )? )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2142:1: ( rule__BuildEntry__VariableAssignment_7_2 )?
            {
             before(grammarAccess.getBuildEntryAccess().getVariableAssignment_7_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2143:1: ( rule__BuildEntry__VariableAssignment_7_2 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_DOLLAR) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2143:2: rule__BuildEntry__VariableAssignment_7_2
                    {
                    pushFollow(FOLLOW_rule__BuildEntry__VariableAssignment_7_2_in_rule__BuildEntry__Group_7__2__Impl4450);
                    rule__BuildEntry__VariableAssignment_7_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBuildEntryAccess().getVariableAssignment_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_7__2__Impl"


    // $ANTLR start "rule__BuildEntry__Group_7__3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2153:1: rule__BuildEntry__Group_7__3 : rule__BuildEntry__Group_7__3__Impl ;
    public final void rule__BuildEntry__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2157:1: ( rule__BuildEntry__Group_7__3__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2158:2: rule__BuildEntry__Group_7__3__Impl
            {
            pushFollow(FOLLOW_rule__BuildEntry__Group_7__3__Impl_in_rule__BuildEntry__Group_7__34481);
            rule__BuildEntry__Group_7__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_7__3"


    // $ANTLR start "rule__BuildEntry__Group_7__3__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2164:1: rule__BuildEntry__Group_7__3__Impl : ( ( rule__BuildEntry__ValueAssignment_7_3 ) ) ;
    public final void rule__BuildEntry__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2168:1: ( ( ( rule__BuildEntry__ValueAssignment_7_3 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2169:1: ( ( rule__BuildEntry__ValueAssignment_7_3 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2169:1: ( ( rule__BuildEntry__ValueAssignment_7_3 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2170:1: ( rule__BuildEntry__ValueAssignment_7_3 )
            {
             before(grammarAccess.getBuildEntryAccess().getValueAssignment_7_3()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2171:1: ( rule__BuildEntry__ValueAssignment_7_3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2171:2: rule__BuildEntry__ValueAssignment_7_3
            {
            pushFollow(FOLLOW_rule__BuildEntry__ValueAssignment_7_3_in_rule__BuildEntry__Group_7__3__Impl4508);
            rule__BuildEntry__ValueAssignment_7_3();

            state._fsp--;


            }

             after(grammarAccess.getBuildEntryAccess().getValueAssignment_7_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__Group_7__3__Impl"


    // $ANTLR start "rule__Entry__Group__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2189:1: rule__Entry__Group__0 : rule__Entry__Group__0__Impl rule__Entry__Group__1 ;
    public final void rule__Entry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2193:1: ( rule__Entry__Group__0__Impl rule__Entry__Group__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2194:2: rule__Entry__Group__0__Impl rule__Entry__Group__1
            {
            pushFollow(FOLLOW_rule__Entry__Group__0__Impl_in_rule__Entry__Group__04546);
            rule__Entry__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Entry__Group__1_in_rule__Entry__Group__04549);
            rule__Entry__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__0"


    // $ANTLR start "rule__Entry__Group__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2201:1: rule__Entry__Group__0__Impl : ( () ) ;
    public final void rule__Entry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2205:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2206:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2206:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2207:1: ()
            {
             before(grammarAccess.getEntryAccess().getEntryAction_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2208:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2210:1: 
            {
            }

             after(grammarAccess.getEntryAccess().getEntryAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__0__Impl"


    // $ANTLR start "rule__Entry__Group__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2220:1: rule__Entry__Group__1 : rule__Entry__Group__1__Impl rule__Entry__Group__2 ;
    public final void rule__Entry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2224:1: ( rule__Entry__Group__1__Impl rule__Entry__Group__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2225:2: rule__Entry__Group__1__Impl rule__Entry__Group__2
            {
            pushFollow(FOLLOW_rule__Entry__Group__1__Impl_in_rule__Entry__Group__14607);
            rule__Entry__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Entry__Group__2_in_rule__Entry__Group__14610);
            rule__Entry__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__1"


    // $ANTLR start "rule__Entry__Group__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2232:1: rule__Entry__Group__1__Impl : ( RULE_OBJ_START ) ;
    public final void rule__Entry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2236:1: ( ( RULE_OBJ_START ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2237:1: ( RULE_OBJ_START )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2237:1: ( RULE_OBJ_START )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2238:1: RULE_OBJ_START
            {
             before(grammarAccess.getEntryAccess().getOBJ_STARTTerminalRuleCall_1()); 
            match(input,RULE_OBJ_START,FOLLOW_RULE_OBJ_START_in_rule__Entry__Group__1__Impl4637); 
             after(grammarAccess.getEntryAccess().getOBJ_STARTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__1__Impl"


    // $ANTLR start "rule__Entry__Group__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2249:1: rule__Entry__Group__2 : rule__Entry__Group__2__Impl rule__Entry__Group__3 ;
    public final void rule__Entry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2253:1: ( rule__Entry__Group__2__Impl rule__Entry__Group__3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2254:2: rule__Entry__Group__2__Impl rule__Entry__Group__3
            {
            pushFollow(FOLLOW_rule__Entry__Group__2__Impl_in_rule__Entry__Group__24666);
            rule__Entry__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Entry__Group__3_in_rule__Entry__Group__24669);
            rule__Entry__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__2"


    // $ANTLR start "rule__Entry__Group__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2261:1: rule__Entry__Group__2__Impl : ( ( rule__Entry__VariableAssignment_2 ) ) ;
    public final void rule__Entry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2265:1: ( ( ( rule__Entry__VariableAssignment_2 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2266:1: ( ( rule__Entry__VariableAssignment_2 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2266:1: ( ( rule__Entry__VariableAssignment_2 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2267:1: ( rule__Entry__VariableAssignment_2 )
            {
             before(grammarAccess.getEntryAccess().getVariableAssignment_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2268:1: ( rule__Entry__VariableAssignment_2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2268:2: rule__Entry__VariableAssignment_2
            {
            pushFollow(FOLLOW_rule__Entry__VariableAssignment_2_in_rule__Entry__Group__2__Impl4696);
            rule__Entry__VariableAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getVariableAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__2__Impl"


    // $ANTLR start "rule__Entry__Group__3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2278:1: rule__Entry__Group__3 : rule__Entry__Group__3__Impl ;
    public final void rule__Entry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2282:1: ( rule__Entry__Group__3__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2283:2: rule__Entry__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Entry__Group__3__Impl_in_rule__Entry__Group__34726);
            rule__Entry__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__3"


    // $ANTLR start "rule__Entry__Group__3__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2289:1: rule__Entry__Group__3__Impl : ( ( rule__Entry__ValueAssignment_3 ) ) ;
    public final void rule__Entry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2293:1: ( ( ( rule__Entry__ValueAssignment_3 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2294:1: ( ( rule__Entry__ValueAssignment_3 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2294:1: ( ( rule__Entry__ValueAssignment_3 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2295:1: ( rule__Entry__ValueAssignment_3 )
            {
             before(grammarAccess.getEntryAccess().getValueAssignment_3()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2296:1: ( rule__Entry__ValueAssignment_3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2296:2: rule__Entry__ValueAssignment_3
            {
            pushFollow(FOLLOW_rule__Entry__ValueAssignment_3_in_rule__Entry__Group__3__Impl4753);
            rule__Entry__ValueAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getValueAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__3__Impl"


    // $ANTLR start "rule__If__Group__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2314:1: rule__If__Group__0 : rule__If__Group__0__Impl rule__If__Group__1 ;
    public final void rule__If__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2318:1: ( rule__If__Group__0__Impl rule__If__Group__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2319:2: rule__If__Group__0__Impl rule__If__Group__1
            {
            pushFollow(FOLLOW_rule__If__Group__0__Impl_in_rule__If__Group__04791);
            rule__If__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__If__Group__1_in_rule__If__Group__04794);
            rule__If__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__0"


    // $ANTLR start "rule__If__Group__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2326:1: rule__If__Group__0__Impl : ( RULE_BRACE_START ) ;
    public final void rule__If__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2330:1: ( ( RULE_BRACE_START ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2331:1: ( RULE_BRACE_START )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2331:1: ( RULE_BRACE_START )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2332:1: RULE_BRACE_START
            {
             before(grammarAccess.getIfAccess().getBRACE_STARTTerminalRuleCall_0()); 
            match(input,RULE_BRACE_START,FOLLOW_RULE_BRACE_START_in_rule__If__Group__0__Impl4821); 
             after(grammarAccess.getIfAccess().getBRACE_STARTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__0__Impl"


    // $ANTLR start "rule__If__Group__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2343:1: rule__If__Group__1 : rule__If__Group__1__Impl rule__If__Group__2 ;
    public final void rule__If__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2347:1: ( rule__If__Group__1__Impl rule__If__Group__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2348:2: rule__If__Group__1__Impl rule__If__Group__2
            {
            pushFollow(FOLLOW_rule__If__Group__1__Impl_in_rule__If__Group__14850);
            rule__If__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__If__Group__2_in_rule__If__Group__14853);
            rule__If__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__1"


    // $ANTLR start "rule__If__Group__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2355:1: rule__If__Group__1__Impl : ( ( rule__If__Alternatives_1 ) ) ;
    public final void rule__If__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2359:1: ( ( ( rule__If__Alternatives_1 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2360:1: ( ( rule__If__Alternatives_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2360:1: ( ( rule__If__Alternatives_1 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2361:1: ( rule__If__Alternatives_1 )
            {
             before(grammarAccess.getIfAccess().getAlternatives_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2362:1: ( rule__If__Alternatives_1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2362:2: rule__If__Alternatives_1
            {
            pushFollow(FOLLOW_rule__If__Alternatives_1_in_rule__If__Group__1__Impl4880);
            rule__If__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getIfAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__1__Impl"


    // $ANTLR start "rule__If__Group__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2372:1: rule__If__Group__2 : rule__If__Group__2__Impl rule__If__Group__3 ;
    public final void rule__If__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2376:1: ( rule__If__Group__2__Impl rule__If__Group__3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2377:2: rule__If__Group__2__Impl rule__If__Group__3
            {
            pushFollow(FOLLOW_rule__If__Group__2__Impl_in_rule__If__Group__24910);
            rule__If__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__If__Group__3_in_rule__If__Group__24913);
            rule__If__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__2"


    // $ANTLR start "rule__If__Group__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2384:1: rule__If__Group__2__Impl : ( RULE_BRACE_END ) ;
    public final void rule__If__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2388:1: ( ( RULE_BRACE_END ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2389:1: ( RULE_BRACE_END )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2389:1: ( RULE_BRACE_END )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2390:1: RULE_BRACE_END
            {
             before(grammarAccess.getIfAccess().getBRACE_ENDTerminalRuleCall_2()); 
            match(input,RULE_BRACE_END,FOLLOW_RULE_BRACE_END_in_rule__If__Group__2__Impl4940); 
             after(grammarAccess.getIfAccess().getBRACE_ENDTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__2__Impl"


    // $ANTLR start "rule__If__Group__3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2401:1: rule__If__Group__3 : rule__If__Group__3__Impl rule__If__Group__4 ;
    public final void rule__If__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2405:1: ( rule__If__Group__3__Impl rule__If__Group__4 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2406:2: rule__If__Group__3__Impl rule__If__Group__4
            {
            pushFollow(FOLLOW_rule__If__Group__3__Impl_in_rule__If__Group__34969);
            rule__If__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__If__Group__4_in_rule__If__Group__34972);
            rule__If__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__3"


    // $ANTLR start "rule__If__Group__3__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2413:1: rule__If__Group__3__Impl : ( ruleEol ) ;
    public final void rule__If__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2417:1: ( ( ruleEol ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2418:1: ( ruleEol )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2418:1: ( ruleEol )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2419:1: ruleEol
            {
             before(grammarAccess.getIfAccess().getEolParserRuleCall_3()); 
            pushFollow(FOLLOW_ruleEol_in_rule__If__Group__3__Impl4999);
            ruleEol();

            state._fsp--;

             after(grammarAccess.getIfAccess().getEolParserRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__3__Impl"


    // $ANTLR start "rule__If__Group__4"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2430:1: rule__If__Group__4 : rule__If__Group__4__Impl rule__If__Group__5 ;
    public final void rule__If__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2434:1: ( rule__If__Group__4__Impl rule__If__Group__5 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2435:2: rule__If__Group__4__Impl rule__If__Group__5
            {
            pushFollow(FOLLOW_rule__If__Group__4__Impl_in_rule__If__Group__45028);
            rule__If__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__If__Group__5_in_rule__If__Group__45031);
            rule__If__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__4"


    // $ANTLR start "rule__If__Group__4__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2442:1: rule__If__Group__4__Impl : ( ( RULE_TAB )* ) ;
    public final void rule__If__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2446:1: ( ( ( RULE_TAB )* ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2447:1: ( ( RULE_TAB )* )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2447:1: ( ( RULE_TAB )* )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2448:1: ( RULE_TAB )*
            {
             before(grammarAccess.getIfAccess().getTABTerminalRuleCall_4()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2449:1: ( RULE_TAB )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_TAB) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2449:3: RULE_TAB
            	    {
            	    match(input,RULE_TAB,FOLLOW_RULE_TAB_in_rule__If__Group__4__Impl5059); 

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getIfAccess().getTABTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__4__Impl"


    // $ANTLR start "rule__If__Group__5"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2459:1: rule__If__Group__5 : rule__If__Group__5__Impl rule__If__Group__6 ;
    public final void rule__If__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2463:1: ( rule__If__Group__5__Impl rule__If__Group__6 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2464:2: rule__If__Group__5__Impl rule__If__Group__6
            {
            pushFollow(FOLLOW_rule__If__Group__5__Impl_in_rule__If__Group__55090);
            rule__If__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__If__Group__6_in_rule__If__Group__55093);
            rule__If__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__5"


    // $ANTLR start "rule__If__Group__5__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2471:1: rule__If__Group__5__Impl : ( ( rule__If__Alternatives_5 ) ) ;
    public final void rule__If__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2475:1: ( ( ( rule__If__Alternatives_5 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2476:1: ( ( rule__If__Alternatives_5 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2476:1: ( ( rule__If__Alternatives_5 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2477:1: ( rule__If__Alternatives_5 )
            {
             before(grammarAccess.getIfAccess().getAlternatives_5()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2478:1: ( rule__If__Alternatives_5 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2478:2: rule__If__Alternatives_5
            {
            pushFollow(FOLLOW_rule__If__Alternatives_5_in_rule__If__Group__5__Impl5120);
            rule__If__Alternatives_5();

            state._fsp--;


            }

             after(grammarAccess.getIfAccess().getAlternatives_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__5__Impl"


    // $ANTLR start "rule__If__Group__6"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2488:1: rule__If__Group__6 : rule__If__Group__6__Impl rule__If__Group__7 ;
    public final void rule__If__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2492:1: ( rule__If__Group__6__Impl rule__If__Group__7 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2493:2: rule__If__Group__6__Impl rule__If__Group__7
            {
            pushFollow(FOLLOW_rule__If__Group__6__Impl_in_rule__If__Group__65150);
            rule__If__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__If__Group__7_in_rule__If__Group__65153);
            rule__If__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__6"


    // $ANTLR start "rule__If__Group__6__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2500:1: rule__If__Group__6__Impl : ( ruleEol ) ;
    public final void rule__If__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2504:1: ( ( ruleEol ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2505:1: ( ruleEol )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2505:1: ( ruleEol )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2506:1: ruleEol
            {
             before(grammarAccess.getIfAccess().getEolParserRuleCall_6()); 
            pushFollow(FOLLOW_ruleEol_in_rule__If__Group__6__Impl5180);
            ruleEol();

            state._fsp--;

             after(grammarAccess.getIfAccess().getEolParserRuleCall_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__6__Impl"


    // $ANTLR start "rule__If__Group__7"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2517:1: rule__If__Group__7 : rule__If__Group__7__Impl rule__If__Group__8 ;
    public final void rule__If__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2521:1: ( rule__If__Group__7__Impl rule__If__Group__8 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2522:2: rule__If__Group__7__Impl rule__If__Group__8
            {
            pushFollow(FOLLOW_rule__If__Group__7__Impl_in_rule__If__Group__75209);
            rule__If__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__If__Group__8_in_rule__If__Group__75212);
            rule__If__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__7"


    // $ANTLR start "rule__If__Group__7__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2529:1: rule__If__Group__7__Impl : ( ( rule__If__Group_7__0 )? ) ;
    public final void rule__If__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2533:1: ( ( ( rule__If__Group_7__0 )? ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2534:1: ( ( rule__If__Group_7__0 )? )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2534:1: ( ( rule__If__Group_7__0 )? )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2535:1: ( rule__If__Group_7__0 )?
            {
             before(grammarAccess.getIfAccess().getGroup_7()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2536:1: ( rule__If__Group_7__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ELSE) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2536:2: rule__If__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__If__Group_7__0_in_rule__If__Group__7__Impl5239);
                    rule__If__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIfAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__7__Impl"


    // $ANTLR start "rule__If__Group__8"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2546:1: rule__If__Group__8 : rule__If__Group__8__Impl ;
    public final void rule__If__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2550:1: ( rule__If__Group__8__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2551:2: rule__If__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__If__Group__8__Impl_in_rule__If__Group__85270);
            rule__If__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__8"


    // $ANTLR start "rule__If__Group__8__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2557:1: rule__If__Group__8__Impl : ( RULE_ENDIF ) ;
    public final void rule__If__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2561:1: ( ( RULE_ENDIF ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2562:1: ( RULE_ENDIF )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2562:1: ( RULE_ENDIF )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2563:1: RULE_ENDIF
            {
             before(grammarAccess.getIfAccess().getENDIFTerminalRuleCall_8()); 
            match(input,RULE_ENDIF,FOLLOW_RULE_ENDIF_in_rule__If__Group__8__Impl5297); 
             after(grammarAccess.getIfAccess().getENDIFTerminalRuleCall_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__8__Impl"


    // $ANTLR start "rule__If__Group_1_0__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2592:1: rule__If__Group_1_0__0 : rule__If__Group_1_0__0__Impl rule__If__Group_1_0__1 ;
    public final void rule__If__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2596:1: ( rule__If__Group_1_0__0__Impl rule__If__Group_1_0__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2597:2: rule__If__Group_1_0__0__Impl rule__If__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__If__Group_1_0__0__Impl_in_rule__If__Group_1_0__05344);
            rule__If__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__If__Group_1_0__1_in_rule__If__Group_1_0__05347);
            rule__If__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1_0__0"


    // $ANTLR start "rule__If__Group_1_0__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2604:1: rule__If__Group_1_0__0__Impl : ( ruleVariable ) ;
    public final void rule__If__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2608:1: ( ( ruleVariable ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2609:1: ( ruleVariable )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2609:1: ( ruleVariable )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2610:1: ruleVariable
            {
             before(grammarAccess.getIfAccess().getVariableParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__If__Group_1_0__0__Impl5374);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getIfAccess().getVariableParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1_0__0__Impl"


    // $ANTLR start "rule__If__Group_1_0__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2621:1: rule__If__Group_1_0__1 : rule__If__Group_1_0__1__Impl rule__If__Group_1_0__2 ;
    public final void rule__If__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2625:1: ( rule__If__Group_1_0__1__Impl rule__If__Group_1_0__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2626:2: rule__If__Group_1_0__1__Impl rule__If__Group_1_0__2
            {
            pushFollow(FOLLOW_rule__If__Group_1_0__1__Impl_in_rule__If__Group_1_0__15403);
            rule__If__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__If__Group_1_0__2_in_rule__If__Group_1_0__15406);
            rule__If__Group_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1_0__1"


    // $ANTLR start "rule__If__Group_1_0__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2633:1: rule__If__Group_1_0__1__Impl : ( RULE_COMMA ) ;
    public final void rule__If__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2637:1: ( ( RULE_COMMA ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2638:1: ( RULE_COMMA )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2638:1: ( RULE_COMMA )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2639:1: RULE_COMMA
            {
             before(grammarAccess.getIfAccess().getCOMMATerminalRuleCall_1_0_1()); 
            match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_rule__If__Group_1_0__1__Impl5433); 
             after(grammarAccess.getIfAccess().getCOMMATerminalRuleCall_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1_0__1__Impl"


    // $ANTLR start "rule__If__Group_1_0__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2650:1: rule__If__Group_1_0__2 : rule__If__Group_1_0__2__Impl ;
    public final void rule__If__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2654:1: ( rule__If__Group_1_0__2__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2655:2: rule__If__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_rule__If__Group_1_0__2__Impl_in_rule__If__Group_1_0__25462);
            rule__If__Group_1_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1_0__2"


    // $ANTLR start "rule__If__Group_1_0__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2661:1: rule__If__Group_1_0__2__Impl : ( ( rule__If__Alternatives_1_0_2 ) ) ;
    public final void rule__If__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2665:1: ( ( ( rule__If__Alternatives_1_0_2 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2666:1: ( ( rule__If__Alternatives_1_0_2 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2666:1: ( ( rule__If__Alternatives_1_0_2 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2667:1: ( rule__If__Alternatives_1_0_2 )
            {
             before(grammarAccess.getIfAccess().getAlternatives_1_0_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2668:1: ( rule__If__Alternatives_1_0_2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2668:2: rule__If__Alternatives_1_0_2
            {
            pushFollow(FOLLOW_rule__If__Alternatives_1_0_2_in_rule__If__Group_1_0__2__Impl5489);
            rule__If__Alternatives_1_0_2();

            state._fsp--;


            }

             after(grammarAccess.getIfAccess().getAlternatives_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1_0__2__Impl"


    // $ANTLR start "rule__If__Group_1_1__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2684:1: rule__If__Group_1_1__0 : rule__If__Group_1_1__0__Impl rule__If__Group_1_1__1 ;
    public final void rule__If__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2688:1: ( rule__If__Group_1_1__0__Impl rule__If__Group_1_1__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2689:2: rule__If__Group_1_1__0__Impl rule__If__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__If__Group_1_1__0__Impl_in_rule__If__Group_1_1__05525);
            rule__If__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__If__Group_1_1__1_in_rule__If__Group_1_1__05528);
            rule__If__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1_1__0"


    // $ANTLR start "rule__If__Group_1_1__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2696:1: rule__If__Group_1_1__0__Impl : ( ( rule__If__ShellAssignment_1_1_0 ) ) ;
    public final void rule__If__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2700:1: ( ( ( rule__If__ShellAssignment_1_1_0 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2701:1: ( ( rule__If__ShellAssignment_1_1_0 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2701:1: ( ( rule__If__ShellAssignment_1_1_0 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2702:1: ( rule__If__ShellAssignment_1_1_0 )
            {
             before(grammarAccess.getIfAccess().getShellAssignment_1_1_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2703:1: ( rule__If__ShellAssignment_1_1_0 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2703:2: rule__If__ShellAssignment_1_1_0
            {
            pushFollow(FOLLOW_rule__If__ShellAssignment_1_1_0_in_rule__If__Group_1_1__0__Impl5555);
            rule__If__ShellAssignment_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getIfAccess().getShellAssignment_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1_1__0__Impl"


    // $ANTLR start "rule__If__Group_1_1__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2713:1: rule__If__Group_1_1__1 : rule__If__Group_1_1__1__Impl ;
    public final void rule__If__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2717:1: ( rule__If__Group_1_1__1__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2718:2: rule__If__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__If__Group_1_1__1__Impl_in_rule__If__Group_1_1__15585);
            rule__If__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1_1__1"


    // $ANTLR start "rule__If__Group_1_1__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2724:1: rule__If__Group_1_1__1__Impl : ( ( RULE_COMMA )? ) ;
    public final void rule__If__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2728:1: ( ( ( RULE_COMMA )? ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2729:1: ( ( RULE_COMMA )? )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2729:1: ( ( RULE_COMMA )? )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2730:1: ( RULE_COMMA )?
            {
             before(grammarAccess.getIfAccess().getCOMMATerminalRuleCall_1_1_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2731:1: ( RULE_COMMA )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_COMMA) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2731:3: RULE_COMMA
                    {
                    match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_rule__If__Group_1_1__1__Impl5613); 

                    }
                    break;

            }

             after(grammarAccess.getIfAccess().getCOMMATerminalRuleCall_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1_1__1__Impl"


    // $ANTLR start "rule__If__Group_7__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2745:1: rule__If__Group_7__0 : rule__If__Group_7__0__Impl rule__If__Group_7__1 ;
    public final void rule__If__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2749:1: ( rule__If__Group_7__0__Impl rule__If__Group_7__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2750:2: rule__If__Group_7__0__Impl rule__If__Group_7__1
            {
            pushFollow(FOLLOW_rule__If__Group_7__0__Impl_in_rule__If__Group_7__05648);
            rule__If__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__If__Group_7__1_in_rule__If__Group_7__05651);
            rule__If__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_7__0"


    // $ANTLR start "rule__If__Group_7__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2757:1: rule__If__Group_7__0__Impl : ( RULE_ELSE ) ;
    public final void rule__If__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2761:1: ( ( RULE_ELSE ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2762:1: ( RULE_ELSE )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2762:1: ( RULE_ELSE )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2763:1: RULE_ELSE
            {
             before(grammarAccess.getIfAccess().getELSETerminalRuleCall_7_0()); 
            match(input,RULE_ELSE,FOLLOW_RULE_ELSE_in_rule__If__Group_7__0__Impl5678); 
             after(grammarAccess.getIfAccess().getELSETerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_7__0__Impl"


    // $ANTLR start "rule__If__Group_7__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2774:1: rule__If__Group_7__1 : rule__If__Group_7__1__Impl rule__If__Group_7__2 ;
    public final void rule__If__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2778:1: ( rule__If__Group_7__1__Impl rule__If__Group_7__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2779:2: rule__If__Group_7__1__Impl rule__If__Group_7__2
            {
            pushFollow(FOLLOW_rule__If__Group_7__1__Impl_in_rule__If__Group_7__15707);
            rule__If__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__If__Group_7__2_in_rule__If__Group_7__15710);
            rule__If__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_7__1"


    // $ANTLR start "rule__If__Group_7__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2786:1: rule__If__Group_7__1__Impl : ( ruleEol ) ;
    public final void rule__If__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2790:1: ( ( ruleEol ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2791:1: ( ruleEol )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2791:1: ( ruleEol )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2792:1: ruleEol
            {
             before(grammarAccess.getIfAccess().getEolParserRuleCall_7_1()); 
            pushFollow(FOLLOW_ruleEol_in_rule__If__Group_7__1__Impl5737);
            ruleEol();

            state._fsp--;

             after(grammarAccess.getIfAccess().getEolParserRuleCall_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_7__1__Impl"


    // $ANTLR start "rule__If__Group_7__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2803:1: rule__If__Group_7__2 : rule__If__Group_7__2__Impl rule__If__Group_7__3 ;
    public final void rule__If__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2807:1: ( rule__If__Group_7__2__Impl rule__If__Group_7__3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2808:2: rule__If__Group_7__2__Impl rule__If__Group_7__3
            {
            pushFollow(FOLLOW_rule__If__Group_7__2__Impl_in_rule__If__Group_7__25766);
            rule__If__Group_7__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__If__Group_7__3_in_rule__If__Group_7__25769);
            rule__If__Group_7__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_7__2"


    // $ANTLR start "rule__If__Group_7__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2815:1: rule__If__Group_7__2__Impl : ( ( RULE_TAB )* ) ;
    public final void rule__If__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2819:1: ( ( ( RULE_TAB )* ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2820:1: ( ( RULE_TAB )* )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2820:1: ( ( RULE_TAB )* )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2821:1: ( RULE_TAB )*
            {
             before(grammarAccess.getIfAccess().getTABTerminalRuleCall_7_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2822:1: ( RULE_TAB )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_TAB) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2822:3: RULE_TAB
            	    {
            	    match(input,RULE_TAB,FOLLOW_RULE_TAB_in_rule__If__Group_7__2__Impl5797); 

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getIfAccess().getTABTerminalRuleCall_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_7__2__Impl"


    // $ANTLR start "rule__If__Group_7__3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2832:1: rule__If__Group_7__3 : rule__If__Group_7__3__Impl rule__If__Group_7__4 ;
    public final void rule__If__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2836:1: ( rule__If__Group_7__3__Impl rule__If__Group_7__4 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2837:2: rule__If__Group_7__3__Impl rule__If__Group_7__4
            {
            pushFollow(FOLLOW_rule__If__Group_7__3__Impl_in_rule__If__Group_7__35828);
            rule__If__Group_7__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__If__Group_7__4_in_rule__If__Group_7__35831);
            rule__If__Group_7__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_7__3"


    // $ANTLR start "rule__If__Group_7__3__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2844:1: rule__If__Group_7__3__Impl : ( ( rule__If__Alternatives_7_3 ) ) ;
    public final void rule__If__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2848:1: ( ( ( rule__If__Alternatives_7_3 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2849:1: ( ( rule__If__Alternatives_7_3 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2849:1: ( ( rule__If__Alternatives_7_3 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2850:1: ( rule__If__Alternatives_7_3 )
            {
             before(grammarAccess.getIfAccess().getAlternatives_7_3()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2851:1: ( rule__If__Alternatives_7_3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2851:2: rule__If__Alternatives_7_3
            {
            pushFollow(FOLLOW_rule__If__Alternatives_7_3_in_rule__If__Group_7__3__Impl5858);
            rule__If__Alternatives_7_3();

            state._fsp--;


            }

             after(grammarAccess.getIfAccess().getAlternatives_7_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_7__3__Impl"


    // $ANTLR start "rule__If__Group_7__4"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2861:1: rule__If__Group_7__4 : rule__If__Group_7__4__Impl ;
    public final void rule__If__Group_7__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2865:1: ( rule__If__Group_7__4__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2866:2: rule__If__Group_7__4__Impl
            {
            pushFollow(FOLLOW_rule__If__Group_7__4__Impl_in_rule__If__Group_7__45888);
            rule__If__Group_7__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_7__4"


    // $ANTLR start "rule__If__Group_7__4__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2872:1: rule__If__Group_7__4__Impl : ( ruleEol ) ;
    public final void rule__If__Group_7__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2876:1: ( ( ruleEol ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2877:1: ( ruleEol )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2877:1: ( ruleEol )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2878:1: ruleEol
            {
             before(grammarAccess.getIfAccess().getEolParserRuleCall_7_4()); 
            pushFollow(FOLLOW_ruleEol_in_rule__If__Group_7__4__Impl5915);
            ruleEol();

            state._fsp--;

             after(grammarAccess.getIfAccess().getEolParserRuleCall_7_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_7__4__Impl"


    // $ANTLR start "rule__Object_Y__Group__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2899:1: rule__Object_Y__Group__0 : rule__Object_Y__Group__0__Impl rule__Object_Y__Group__1 ;
    public final void rule__Object_Y__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2903:1: ( rule__Object_Y__Group__0__Impl rule__Object_Y__Group__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2904:2: rule__Object_Y__Group__0__Impl rule__Object_Y__Group__1
            {
            pushFollow(FOLLOW_rule__Object_Y__Group__0__Impl_in_rule__Object_Y__Group__05954);
            rule__Object_Y__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Object_Y__Group__1_in_rule__Object_Y__Group__05957);
            rule__Object_Y__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object_Y__Group__0"


    // $ANTLR start "rule__Object_Y__Group__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2911:1: rule__Object_Y__Group__0__Impl : ( () ) ;
    public final void rule__Object_Y__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2915:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2916:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2916:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2917:1: ()
            {
             before(grammarAccess.getObject_YAccess().getObj_yAction_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2918:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2920:1: 
            {
            }

             after(grammarAccess.getObject_YAccess().getObj_yAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object_Y__Group__0__Impl"


    // $ANTLR start "rule__Object_Y__Group__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2930:1: rule__Object_Y__Group__1 : rule__Object_Y__Group__1__Impl rule__Object_Y__Group__2 ;
    public final void rule__Object_Y__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2934:1: ( rule__Object_Y__Group__1__Impl rule__Object_Y__Group__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2935:2: rule__Object_Y__Group__1__Impl rule__Object_Y__Group__2
            {
            pushFollow(FOLLOW_rule__Object_Y__Group__1__Impl_in_rule__Object_Y__Group__16015);
            rule__Object_Y__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Object_Y__Group__2_in_rule__Object_Y__Group__16018);
            rule__Object_Y__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object_Y__Group__1"


    // $ANTLR start "rule__Object_Y__Group__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2942:1: rule__Object_Y__Group__1__Impl : ( RULE_OBJ_Y ) ;
    public final void rule__Object_Y__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2946:1: ( ( RULE_OBJ_Y ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2947:1: ( RULE_OBJ_Y )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2947:1: ( RULE_OBJ_Y )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2948:1: RULE_OBJ_Y
            {
             before(grammarAccess.getObject_YAccess().getOBJ_YTerminalRuleCall_1()); 
            match(input,RULE_OBJ_Y,FOLLOW_RULE_OBJ_Y_in_rule__Object_Y__Group__1__Impl6045); 
             after(grammarAccess.getObject_YAccess().getOBJ_YTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object_Y__Group__1__Impl"


    // $ANTLR start "rule__Object_Y__Group__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2959:1: rule__Object_Y__Group__2 : rule__Object_Y__Group__2__Impl ;
    public final void rule__Object_Y__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2963:1: ( rule__Object_Y__Group__2__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2964:2: rule__Object_Y__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Object_Y__Group__2__Impl_in_rule__Object_Y__Group__26074);
            rule__Object_Y__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object_Y__Group__2"


    // $ANTLR start "rule__Object_Y__Group__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2970:1: rule__Object_Y__Group__2__Impl : ( ( rule__Object_Y__ValueAssignment_2 ) ) ;
    public final void rule__Object_Y__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2974:1: ( ( ( rule__Object_Y__ValueAssignment_2 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2975:1: ( ( rule__Object_Y__ValueAssignment_2 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2975:1: ( ( rule__Object_Y__ValueAssignment_2 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2976:1: ( rule__Object_Y__ValueAssignment_2 )
            {
             before(grammarAccess.getObject_YAccess().getValueAssignment_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2977:1: ( rule__Object_Y__ValueAssignment_2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2977:2: rule__Object_Y__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__Object_Y__ValueAssignment_2_in_rule__Object_Y__Group__2__Impl6101);
            rule__Object_Y__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getObject_YAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object_Y__Group__2__Impl"


    // $ANTLR start "rule__Object_M__Group__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2993:1: rule__Object_M__Group__0 : rule__Object_M__Group__0__Impl rule__Object_M__Group__1 ;
    public final void rule__Object_M__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2997:1: ( rule__Object_M__Group__0__Impl rule__Object_M__Group__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:2998:2: rule__Object_M__Group__0__Impl rule__Object_M__Group__1
            {
            pushFollow(FOLLOW_rule__Object_M__Group__0__Impl_in_rule__Object_M__Group__06137);
            rule__Object_M__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Object_M__Group__1_in_rule__Object_M__Group__06140);
            rule__Object_M__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object_M__Group__0"


    // $ANTLR start "rule__Object_M__Group__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3005:1: rule__Object_M__Group__0__Impl : ( () ) ;
    public final void rule__Object_M__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3009:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3010:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3010:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3011:1: ()
            {
             before(grammarAccess.getObject_MAccess().getObj_mAction_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3012:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3014:1: 
            {
            }

             after(grammarAccess.getObject_MAccess().getObj_mAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object_M__Group__0__Impl"


    // $ANTLR start "rule__Object_M__Group__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3024:1: rule__Object_M__Group__1 : rule__Object_M__Group__1__Impl rule__Object_M__Group__2 ;
    public final void rule__Object_M__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3028:1: ( rule__Object_M__Group__1__Impl rule__Object_M__Group__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3029:2: rule__Object_M__Group__1__Impl rule__Object_M__Group__2
            {
            pushFollow(FOLLOW_rule__Object_M__Group__1__Impl_in_rule__Object_M__Group__16198);
            rule__Object_M__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Object_M__Group__2_in_rule__Object_M__Group__16201);
            rule__Object_M__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object_M__Group__1"


    // $ANTLR start "rule__Object_M__Group__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3036:1: rule__Object_M__Group__1__Impl : ( RULE_OBJ_M ) ;
    public final void rule__Object_M__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3040:1: ( ( RULE_OBJ_M ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3041:1: ( RULE_OBJ_M )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3041:1: ( RULE_OBJ_M )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3042:1: RULE_OBJ_M
            {
             before(grammarAccess.getObject_MAccess().getOBJ_MTerminalRuleCall_1()); 
            match(input,RULE_OBJ_M,FOLLOW_RULE_OBJ_M_in_rule__Object_M__Group__1__Impl6228); 
             after(grammarAccess.getObject_MAccess().getOBJ_MTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object_M__Group__1__Impl"


    // $ANTLR start "rule__Object_M__Group__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3053:1: rule__Object_M__Group__2 : rule__Object_M__Group__2__Impl ;
    public final void rule__Object_M__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3057:1: ( rule__Object_M__Group__2__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3058:2: rule__Object_M__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Object_M__Group__2__Impl_in_rule__Object_M__Group__26257);
            rule__Object_M__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object_M__Group__2"


    // $ANTLR start "rule__Object_M__Group__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3064:1: rule__Object_M__Group__2__Impl : ( ( rule__Object_M__ValueAssignment_2 ) ) ;
    public final void rule__Object_M__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3068:1: ( ( ( rule__Object_M__ValueAssignment_2 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3069:1: ( ( rule__Object_M__ValueAssignment_2 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3069:1: ( ( rule__Object_M__ValueAssignment_2 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3070:1: ( rule__Object_M__ValueAssignment_2 )
            {
             before(grammarAccess.getObject_MAccess().getValueAssignment_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3071:1: ( rule__Object_M__ValueAssignment_2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3071:2: rule__Object_M__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__Object_M__ValueAssignment_2_in_rule__Object_M__Group__2__Impl6284);
            rule__Object_M__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getObject_MAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object_M__Group__2__Impl"


    // $ANTLR start "rule__Assign__Group__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3087:1: rule__Assign__Group__0 : rule__Assign__Group__0__Impl rule__Assign__Group__1 ;
    public final void rule__Assign__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3091:1: ( rule__Assign__Group__0__Impl rule__Assign__Group__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3092:2: rule__Assign__Group__0__Impl rule__Assign__Group__1
            {
            pushFollow(FOLLOW_rule__Assign__Group__0__Impl_in_rule__Assign__Group__06320);
            rule__Assign__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Assign__Group__1_in_rule__Assign__Group__06323);
            rule__Assign__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assign__Group__0"


    // $ANTLR start "rule__Assign__Group__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3099:1: rule__Assign__Group__0__Impl : ( RULE_EQ ) ;
    public final void rule__Assign__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3103:1: ( ( RULE_EQ ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3104:1: ( RULE_EQ )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3104:1: ( RULE_EQ )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3105:1: RULE_EQ
            {
             before(grammarAccess.getAssignAccess().getEQTerminalRuleCall_0()); 
            match(input,RULE_EQ,FOLLOW_RULE_EQ_in_rule__Assign__Group__0__Impl6350); 
             after(grammarAccess.getAssignAccess().getEQTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assign__Group__0__Impl"


    // $ANTLR start "rule__Assign__Group__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3116:1: rule__Assign__Group__1 : rule__Assign__Group__1__Impl rule__Assign__Group__2 ;
    public final void rule__Assign__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3120:1: ( rule__Assign__Group__1__Impl rule__Assign__Group__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3121:2: rule__Assign__Group__1__Impl rule__Assign__Group__2
            {
            pushFollow(FOLLOW_rule__Assign__Group__1__Impl_in_rule__Assign__Group__16379);
            rule__Assign__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Assign__Group__2_in_rule__Assign__Group__16382);
            rule__Assign__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assign__Group__1"


    // $ANTLR start "rule__Assign__Group__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3128:1: rule__Assign__Group__1__Impl : ( ( RULE_TAB )* ) ;
    public final void rule__Assign__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3132:1: ( ( ( RULE_TAB )* ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3133:1: ( ( RULE_TAB )* )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3133:1: ( ( RULE_TAB )* )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3134:1: ( RULE_TAB )*
            {
             before(grammarAccess.getAssignAccess().getTABTerminalRuleCall_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3135:1: ( RULE_TAB )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_TAB) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3135:3: RULE_TAB
            	    {
            	    match(input,RULE_TAB,FOLLOW_RULE_TAB_in_rule__Assign__Group__1__Impl6410); 

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getAssignAccess().getTABTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assign__Group__1__Impl"


    // $ANTLR start "rule__Assign__Group__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3145:1: rule__Assign__Group__2 : rule__Assign__Group__2__Impl ;
    public final void rule__Assign__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3149:1: ( rule__Assign__Group__2__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3150:2: rule__Assign__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Assign__Group__2__Impl_in_rule__Assign__Group__26441);
            rule__Assign__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assign__Group__2"


    // $ANTLR start "rule__Assign__Group__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3156:1: rule__Assign__Group__2__Impl : ( ruleValues ) ;
    public final void rule__Assign__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3160:1: ( ( ruleValues ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3161:1: ( ruleValues )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3161:1: ( ruleValues )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3162:1: ruleValues
            {
             before(grammarAccess.getAssignAccess().getValuesParserRuleCall_2()); 
            pushFollow(FOLLOW_ruleValues_in_rule__Assign__Group__2__Impl6468);
            ruleValues();

            state._fsp--;

             after(grammarAccess.getAssignAccess().getValuesParserRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assign__Group__2__Impl"


    // $ANTLR start "rule__AssignExtra__Group__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3179:1: rule__AssignExtra__Group__0 : rule__AssignExtra__Group__0__Impl rule__AssignExtra__Group__1 ;
    public final void rule__AssignExtra__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3183:1: ( rule__AssignExtra__Group__0__Impl rule__AssignExtra__Group__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3184:2: rule__AssignExtra__Group__0__Impl rule__AssignExtra__Group__1
            {
            pushFollow(FOLLOW_rule__AssignExtra__Group__0__Impl_in_rule__AssignExtra__Group__06503);
            rule__AssignExtra__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssignExtra__Group__1_in_rule__AssignExtra__Group__06506);
            rule__AssignExtra__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignExtra__Group__0"


    // $ANTLR start "rule__AssignExtra__Group__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3191:1: rule__AssignExtra__Group__0__Impl : ( ( RULE_TAB )* ) ;
    public final void rule__AssignExtra__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3195:1: ( ( ( RULE_TAB )* ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3196:1: ( ( RULE_TAB )* )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3196:1: ( ( RULE_TAB )* )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3197:1: ( RULE_TAB )*
            {
             before(grammarAccess.getAssignExtraAccess().getTABTerminalRuleCall_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3198:1: ( RULE_TAB )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_TAB) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3198:3: RULE_TAB
            	    {
            	    match(input,RULE_TAB,FOLLOW_RULE_TAB_in_rule__AssignExtra__Group__0__Impl6534); 

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getAssignExtraAccess().getTABTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignExtra__Group__0__Impl"


    // $ANTLR start "rule__AssignExtra__Group__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3208:1: rule__AssignExtra__Group__1 : rule__AssignExtra__Group__1__Impl rule__AssignExtra__Group__2 ;
    public final void rule__AssignExtra__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3212:1: ( rule__AssignExtra__Group__1__Impl rule__AssignExtra__Group__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3213:2: rule__AssignExtra__Group__1__Impl rule__AssignExtra__Group__2
            {
            pushFollow(FOLLOW_rule__AssignExtra__Group__1__Impl_in_rule__AssignExtra__Group__16565);
            rule__AssignExtra__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssignExtra__Group__2_in_rule__AssignExtra__Group__16568);
            rule__AssignExtra__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignExtra__Group__1"


    // $ANTLR start "rule__AssignExtra__Group__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3220:1: rule__AssignExtra__Group__1__Impl : ( ( rule__AssignExtra__Alternatives_1 ) ) ;
    public final void rule__AssignExtra__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3224:1: ( ( ( rule__AssignExtra__Alternatives_1 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3225:1: ( ( rule__AssignExtra__Alternatives_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3225:1: ( ( rule__AssignExtra__Alternatives_1 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3226:1: ( rule__AssignExtra__Alternatives_1 )
            {
             before(grammarAccess.getAssignExtraAccess().getAlternatives_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3227:1: ( rule__AssignExtra__Alternatives_1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3227:2: rule__AssignExtra__Alternatives_1
            {
            pushFollow(FOLLOW_rule__AssignExtra__Alternatives_1_in_rule__AssignExtra__Group__1__Impl6595);
            rule__AssignExtra__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getAssignExtraAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignExtra__Group__1__Impl"


    // $ANTLR start "rule__AssignExtra__Group__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3237:1: rule__AssignExtra__Group__2 : rule__AssignExtra__Group__2__Impl ;
    public final void rule__AssignExtra__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3241:1: ( rule__AssignExtra__Group__2__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3242:2: rule__AssignExtra__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__AssignExtra__Group__2__Impl_in_rule__AssignExtra__Group__26625);
            rule__AssignExtra__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignExtra__Group__2"


    // $ANTLR start "rule__AssignExtra__Group__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3248:1: rule__AssignExtra__Group__2__Impl : ( ruleAssign ) ;
    public final void rule__AssignExtra__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3252:1: ( ( ruleAssign ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3253:1: ( ruleAssign )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3253:1: ( ruleAssign )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3254:1: ruleAssign
            {
             before(grammarAccess.getAssignExtraAccess().getAssignParserRuleCall_2()); 
            pushFollow(FOLLOW_ruleAssign_in_rule__AssignExtra__Group__2__Impl6652);
            ruleAssign();

            state._fsp--;

             after(grammarAccess.getAssignExtraAccess().getAssignParserRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignExtra__Group__2__Impl"


    // $ANTLR start "rule__Values__Group__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3271:1: rule__Values__Group__0 : rule__Values__Group__0__Impl rule__Values__Group__1 ;
    public final void rule__Values__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3275:1: ( rule__Values__Group__0__Impl rule__Values__Group__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3276:2: rule__Values__Group__0__Impl rule__Values__Group__1
            {
            pushFollow(FOLLOW_rule__Values__Group__0__Impl_in_rule__Values__Group__06687);
            rule__Values__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Values__Group__1_in_rule__Values__Group__06690);
            rule__Values__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group__0"


    // $ANTLR start "rule__Values__Group__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3283:1: rule__Values__Group__0__Impl : ( ( rule__Values__Group_0__0 )? ) ;
    public final void rule__Values__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3287:1: ( ( ( rule__Values__Group_0__0 )? ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3288:1: ( ( rule__Values__Group_0__0 )? )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3288:1: ( ( rule__Values__Group_0__0 )? )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3289:1: ( rule__Values__Group_0__0 )?
            {
             before(grammarAccess.getValuesAccess().getGroup_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3290:1: ( rule__Values__Group_0__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_BACKSLASH) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3290:2: rule__Values__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Values__Group_0__0_in_rule__Values__Group__0__Impl6717);
                    rule__Values__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getValuesAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group__0__Impl"


    // $ANTLR start "rule__Values__Group__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3300:1: rule__Values__Group__1 : rule__Values__Group__1__Impl rule__Values__Group__2 ;
    public final void rule__Values__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3304:1: ( rule__Values__Group__1__Impl rule__Values__Group__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3305:2: rule__Values__Group__1__Impl rule__Values__Group__2
            {
            pushFollow(FOLLOW_rule__Values__Group__1__Impl_in_rule__Values__Group__16748);
            rule__Values__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Values__Group__2_in_rule__Values__Group__16751);
            rule__Values__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group__1"


    // $ANTLR start "rule__Values__Group__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3312:1: rule__Values__Group__1__Impl : ( ( ( rule__Values__ValuesAssignment_1 ) ) ( ( rule__Values__ValuesAssignment_1 )* ) ) ;
    public final void rule__Values__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3316:1: ( ( ( ( rule__Values__ValuesAssignment_1 ) ) ( ( rule__Values__ValuesAssignment_1 )* ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3317:1: ( ( ( rule__Values__ValuesAssignment_1 ) ) ( ( rule__Values__ValuesAssignment_1 )* ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3317:1: ( ( ( rule__Values__ValuesAssignment_1 ) ) ( ( rule__Values__ValuesAssignment_1 )* ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3318:1: ( ( rule__Values__ValuesAssignment_1 ) ) ( ( rule__Values__ValuesAssignment_1 )* )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3318:1: ( ( rule__Values__ValuesAssignment_1 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3319:1: ( rule__Values__ValuesAssignment_1 )
            {
             before(grammarAccess.getValuesAccess().getValuesAssignment_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3320:1: ( rule__Values__ValuesAssignment_1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3320:2: rule__Values__ValuesAssignment_1
            {
            pushFollow(FOLLOW_rule__Values__ValuesAssignment_1_in_rule__Values__Group__1__Impl6780);
            rule__Values__ValuesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getValuesAccess().getValuesAssignment_1()); 

            }

            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3323:1: ( ( rule__Values__ValuesAssignment_1 )* )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3324:1: ( rule__Values__ValuesAssignment_1 )*
            {
             before(grammarAccess.getValuesAccess().getValuesAssignment_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3325:1: ( rule__Values__ValuesAssignment_1 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_STRING||LA30_0==RULE_SHELL_CHAR||LA30_0==RULE_SYMBOL||(LA30_0>=RULE_DOLLAR && LA30_0<=RULE_INCLUDE)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3325:2: rule__Values__ValuesAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Values__ValuesAssignment_1_in_rule__Values__Group__1__Impl6792);
            	    rule__Values__ValuesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getValuesAccess().getValuesAssignment_1()); 

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
    // $ANTLR end "rule__Values__Group__1__Impl"


    // $ANTLR start "rule__Values__Group__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3336:1: rule__Values__Group__2 : rule__Values__Group__2__Impl ;
    public final void rule__Values__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3340:1: ( rule__Values__Group__2__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3341:2: rule__Values__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Values__Group__2__Impl_in_rule__Values__Group__26825);
            rule__Values__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group__2"


    // $ANTLR start "rule__Values__Group__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3347:1: rule__Values__Group__2__Impl : ( ( rule__Values__Group_2__0 )* ) ;
    public final void rule__Values__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3351:1: ( ( ( rule__Values__Group_2__0 )* ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3352:1: ( ( rule__Values__Group_2__0 )* )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3352:1: ( ( rule__Values__Group_2__0 )* )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3353:1: ( rule__Values__Group_2__0 )*
            {
             before(grammarAccess.getValuesAccess().getGroup_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3354:1: ( rule__Values__Group_2__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_BACKSLASH) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3354:2: rule__Values__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Values__Group_2__0_in_rule__Values__Group__2__Impl6852);
            	    rule__Values__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getValuesAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group__2__Impl"


    // $ANTLR start "rule__Values__Group_0__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3370:1: rule__Values__Group_0__0 : rule__Values__Group_0__0__Impl rule__Values__Group_0__1 ;
    public final void rule__Values__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3374:1: ( rule__Values__Group_0__0__Impl rule__Values__Group_0__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3375:2: rule__Values__Group_0__0__Impl rule__Values__Group_0__1
            {
            pushFollow(FOLLOW_rule__Values__Group_0__0__Impl_in_rule__Values__Group_0__06889);
            rule__Values__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Values__Group_0__1_in_rule__Values__Group_0__06892);
            rule__Values__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group_0__0"


    // $ANTLR start "rule__Values__Group_0__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3382:1: rule__Values__Group_0__0__Impl : ( RULE_BACKSLASH ) ;
    public final void rule__Values__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3386:1: ( ( RULE_BACKSLASH ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3387:1: ( RULE_BACKSLASH )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3387:1: ( RULE_BACKSLASH )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3388:1: RULE_BACKSLASH
            {
             before(grammarAccess.getValuesAccess().getBACKSLASHTerminalRuleCall_0_0()); 
            match(input,RULE_BACKSLASH,FOLLOW_RULE_BACKSLASH_in_rule__Values__Group_0__0__Impl6919); 
             after(grammarAccess.getValuesAccess().getBACKSLASHTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group_0__0__Impl"


    // $ANTLR start "rule__Values__Group_0__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3399:1: rule__Values__Group_0__1 : rule__Values__Group_0__1__Impl rule__Values__Group_0__2 ;
    public final void rule__Values__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3403:1: ( rule__Values__Group_0__1__Impl rule__Values__Group_0__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3404:2: rule__Values__Group_0__1__Impl rule__Values__Group_0__2
            {
            pushFollow(FOLLOW_rule__Values__Group_0__1__Impl_in_rule__Values__Group_0__16948);
            rule__Values__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Values__Group_0__2_in_rule__Values__Group_0__16951);
            rule__Values__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group_0__1"


    // $ANTLR start "rule__Values__Group_0__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3411:1: rule__Values__Group_0__1__Impl : ( ruleEol ) ;
    public final void rule__Values__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3415:1: ( ( ruleEol ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3416:1: ( ruleEol )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3416:1: ( ruleEol )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3417:1: ruleEol
            {
             before(grammarAccess.getValuesAccess().getEolParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleEol_in_rule__Values__Group_0__1__Impl6978);
            ruleEol();

            state._fsp--;

             after(grammarAccess.getValuesAccess().getEolParserRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group_0__1__Impl"


    // $ANTLR start "rule__Values__Group_0__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3428:1: rule__Values__Group_0__2 : rule__Values__Group_0__2__Impl ;
    public final void rule__Values__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3432:1: ( rule__Values__Group_0__2__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3433:2: rule__Values__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Values__Group_0__2__Impl_in_rule__Values__Group_0__27007);
            rule__Values__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group_0__2"


    // $ANTLR start "rule__Values__Group_0__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3439:1: rule__Values__Group_0__2__Impl : ( ( RULE_TAB )* ) ;
    public final void rule__Values__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3443:1: ( ( ( RULE_TAB )* ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3444:1: ( ( RULE_TAB )* )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3444:1: ( ( RULE_TAB )* )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3445:1: ( RULE_TAB )*
            {
             before(grammarAccess.getValuesAccess().getTABTerminalRuleCall_0_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3446:1: ( RULE_TAB )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_TAB) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3446:3: RULE_TAB
            	    {
            	    match(input,RULE_TAB,FOLLOW_RULE_TAB_in_rule__Values__Group_0__2__Impl7035); 

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getValuesAccess().getTABTerminalRuleCall_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group_0__2__Impl"


    // $ANTLR start "rule__Values__Group_2__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3462:1: rule__Values__Group_2__0 : rule__Values__Group_2__0__Impl rule__Values__Group_2__1 ;
    public final void rule__Values__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3466:1: ( rule__Values__Group_2__0__Impl rule__Values__Group_2__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3467:2: rule__Values__Group_2__0__Impl rule__Values__Group_2__1
            {
            pushFollow(FOLLOW_rule__Values__Group_2__0__Impl_in_rule__Values__Group_2__07072);
            rule__Values__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Values__Group_2__1_in_rule__Values__Group_2__07075);
            rule__Values__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group_2__0"


    // $ANTLR start "rule__Values__Group_2__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3474:1: rule__Values__Group_2__0__Impl : ( RULE_BACKSLASH ) ;
    public final void rule__Values__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3478:1: ( ( RULE_BACKSLASH ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3479:1: ( RULE_BACKSLASH )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3479:1: ( RULE_BACKSLASH )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3480:1: RULE_BACKSLASH
            {
             before(grammarAccess.getValuesAccess().getBACKSLASHTerminalRuleCall_2_0()); 
            match(input,RULE_BACKSLASH,FOLLOW_RULE_BACKSLASH_in_rule__Values__Group_2__0__Impl7102); 
             after(grammarAccess.getValuesAccess().getBACKSLASHTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group_2__0__Impl"


    // $ANTLR start "rule__Values__Group_2__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3491:1: rule__Values__Group_2__1 : rule__Values__Group_2__1__Impl rule__Values__Group_2__2 ;
    public final void rule__Values__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3495:1: ( rule__Values__Group_2__1__Impl rule__Values__Group_2__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3496:2: rule__Values__Group_2__1__Impl rule__Values__Group_2__2
            {
            pushFollow(FOLLOW_rule__Values__Group_2__1__Impl_in_rule__Values__Group_2__17131);
            rule__Values__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Values__Group_2__2_in_rule__Values__Group_2__17134);
            rule__Values__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group_2__1"


    // $ANTLR start "rule__Values__Group_2__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3503:1: rule__Values__Group_2__1__Impl : ( ruleEol ) ;
    public final void rule__Values__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3507:1: ( ( ruleEol ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3508:1: ( ruleEol )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3508:1: ( ruleEol )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3509:1: ruleEol
            {
             before(grammarAccess.getValuesAccess().getEolParserRuleCall_2_1()); 
            pushFollow(FOLLOW_ruleEol_in_rule__Values__Group_2__1__Impl7161);
            ruleEol();

            state._fsp--;

             after(grammarAccess.getValuesAccess().getEolParserRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group_2__1__Impl"


    // $ANTLR start "rule__Values__Group_2__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3520:1: rule__Values__Group_2__2 : rule__Values__Group_2__2__Impl rule__Values__Group_2__3 ;
    public final void rule__Values__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3524:1: ( rule__Values__Group_2__2__Impl rule__Values__Group_2__3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3525:2: rule__Values__Group_2__2__Impl rule__Values__Group_2__3
            {
            pushFollow(FOLLOW_rule__Values__Group_2__2__Impl_in_rule__Values__Group_2__27190);
            rule__Values__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Values__Group_2__3_in_rule__Values__Group_2__27193);
            rule__Values__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group_2__2"


    // $ANTLR start "rule__Values__Group_2__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3532:1: rule__Values__Group_2__2__Impl : ( ( RULE_TAB )* ) ;
    public final void rule__Values__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3536:1: ( ( ( RULE_TAB )* ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3537:1: ( ( RULE_TAB )* )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3537:1: ( ( RULE_TAB )* )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3538:1: ( RULE_TAB )*
            {
             before(grammarAccess.getValuesAccess().getTABTerminalRuleCall_2_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3539:1: ( RULE_TAB )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_TAB) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3539:3: RULE_TAB
            	    {
            	    match(input,RULE_TAB,FOLLOW_RULE_TAB_in_rule__Values__Group_2__2__Impl7221); 

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getValuesAccess().getTABTerminalRuleCall_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group_2__2__Impl"


    // $ANTLR start "rule__Values__Group_2__3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3549:1: rule__Values__Group_2__3 : rule__Values__Group_2__3__Impl ;
    public final void rule__Values__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3553:1: ( rule__Values__Group_2__3__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3554:2: rule__Values__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__Values__Group_2__3__Impl_in_rule__Values__Group_2__37252);
            rule__Values__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__Group_2__3"


    // $ANTLR start "rule__Values__Group_2__3__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3560:1: rule__Values__Group_2__3__Impl : ( ( ( rule__Values__ValuesAssignment_2_3 ) ) ( ( rule__Values__ValuesAssignment_2_3 )* ) ) ;
    public final void rule__Values__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3564:1: ( ( ( ( rule__Values__ValuesAssignment_2_3 ) ) ( ( rule__Values__ValuesAssignment_2_3 )* ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3565:1: ( ( ( rule__Values__ValuesAssignment_2_3 ) ) ( ( rule__Values__ValuesAssignment_2_3 )* ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3565:1: ( ( ( rule__Values__ValuesAssignment_2_3 ) ) ( ( rule__Values__ValuesAssignment_2_3 )* ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3566:1: ( ( rule__Values__ValuesAssignment_2_3 ) ) ( ( rule__Values__ValuesAssignment_2_3 )* )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3566:1: ( ( rule__Values__ValuesAssignment_2_3 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3567:1: ( rule__Values__ValuesAssignment_2_3 )
            {
             before(grammarAccess.getValuesAccess().getValuesAssignment_2_3()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3568:1: ( rule__Values__ValuesAssignment_2_3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3568:2: rule__Values__ValuesAssignment_2_3
            {
            pushFollow(FOLLOW_rule__Values__ValuesAssignment_2_3_in_rule__Values__Group_2__3__Impl7281);
            rule__Values__ValuesAssignment_2_3();

            state._fsp--;


            }

             after(grammarAccess.getValuesAccess().getValuesAssignment_2_3()); 

            }

            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3571:1: ( ( rule__Values__ValuesAssignment_2_3 )* )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3572:1: ( rule__Values__ValuesAssignment_2_3 )*
            {
             before(grammarAccess.getValuesAccess().getValuesAssignment_2_3()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3573:1: ( rule__Values__ValuesAssignment_2_3 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_STRING||LA34_0==RULE_SHELL_CHAR||LA34_0==RULE_SYMBOL||(LA34_0>=RULE_DOLLAR && LA34_0<=RULE_INCLUDE)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3573:2: rule__Values__ValuesAssignment_2_3
            	    {
            	    pushFollow(FOLLOW_rule__Values__ValuesAssignment_2_3_in_rule__Values__Group_2__3__Impl7293);
            	    rule__Values__ValuesAssignment_2_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getValuesAccess().getValuesAssignment_2_3()); 

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
    // $ANTLR end "rule__Values__Group_2__3__Impl"


    // $ANTLR start "rule__Value__Group_0__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3592:1: rule__Value__Group_0__0 : rule__Value__Group_0__0__Impl rule__Value__Group_0__1 ;
    public final void rule__Value__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3596:1: ( rule__Value__Group_0__0__Impl rule__Value__Group_0__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3597:2: rule__Value__Group_0__0__Impl rule__Value__Group_0__1
            {
            pushFollow(FOLLOW_rule__Value__Group_0__0__Impl_in_rule__Value__Group_0__07334);
            rule__Value__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Value__Group_0__1_in_rule__Value__Group_0__07337);
            rule__Value__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_0__0"


    // $ANTLR start "rule__Value__Group_0__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3604:1: rule__Value__Group_0__0__Impl : ( () ) ;
    public final void rule__Value__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3608:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3609:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3609:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3610:1: ()
            {
             before(grammarAccess.getValueAccess().getObjectFileAction_0_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3611:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3613:1: 
            {
            }

             after(grammarAccess.getValueAccess().getObjectFileAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_0__0__Impl"


    // $ANTLR start "rule__Value__Group_0__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3623:1: rule__Value__Group_0__1 : rule__Value__Group_0__1__Impl rule__Value__Group_0__2 ;
    public final void rule__Value__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3627:1: ( rule__Value__Group_0__1__Impl rule__Value__Group_0__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3628:2: rule__Value__Group_0__1__Impl rule__Value__Group_0__2
            {
            pushFollow(FOLLOW_rule__Value__Group_0__1__Impl_in_rule__Value__Group_0__17395);
            rule__Value__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Value__Group_0__2_in_rule__Value__Group_0__17398);
            rule__Value__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_0__1"


    // $ANTLR start "rule__Value__Group_0__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3635:1: rule__Value__Group_0__1__Impl : ( RULE_SYMBOL ) ;
    public final void rule__Value__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3639:1: ( ( RULE_SYMBOL ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3640:1: ( RULE_SYMBOL )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3640:1: ( RULE_SYMBOL )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3641:1: RULE_SYMBOL
            {
             before(grammarAccess.getValueAccess().getSYMBOLTerminalRuleCall_0_1()); 
            match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_rule__Value__Group_0__1__Impl7425); 
             after(grammarAccess.getValueAccess().getSYMBOLTerminalRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_0__1__Impl"


    // $ANTLR start "rule__Value__Group_0__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3652:1: rule__Value__Group_0__2 : rule__Value__Group_0__2__Impl ;
    public final void rule__Value__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3656:1: ( rule__Value__Group_0__2__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3657:2: rule__Value__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Value__Group_0__2__Impl_in_rule__Value__Group_0__27454);
            rule__Value__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_0__2"


    // $ANTLR start "rule__Value__Group_0__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3663:1: rule__Value__Group_0__2__Impl : ( RULE_OBJ_FILE ) ;
    public final void rule__Value__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3667:1: ( ( RULE_OBJ_FILE ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3668:1: ( RULE_OBJ_FILE )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3668:1: ( RULE_OBJ_FILE )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3669:1: RULE_OBJ_FILE
            {
             before(grammarAccess.getValueAccess().getOBJ_FILETerminalRuleCall_0_2()); 
            match(input,RULE_OBJ_FILE,FOLLOW_RULE_OBJ_FILE_in_rule__Value__Group_0__2__Impl7481); 
             after(grammarAccess.getValueAccess().getOBJ_FILETerminalRuleCall_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_0__2__Impl"


    // $ANTLR start "rule__Value__Group_1__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3686:1: rule__Value__Group_1__0 : rule__Value__Group_1__0__Impl rule__Value__Group_1__1 ;
    public final void rule__Value__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3690:1: ( rule__Value__Group_1__0__Impl rule__Value__Group_1__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3691:2: rule__Value__Group_1__0__Impl rule__Value__Group_1__1
            {
            pushFollow(FOLLOW_rule__Value__Group_1__0__Impl_in_rule__Value__Group_1__07516);
            rule__Value__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Value__Group_1__1_in_rule__Value__Group_1__07519);
            rule__Value__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_1__0"


    // $ANTLR start "rule__Value__Group_1__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3698:1: rule__Value__Group_1__0__Impl : ( () ) ;
    public final void rule__Value__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3702:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3703:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3703:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3704:1: ()
            {
             before(grammarAccess.getValueAccess().getObjectSingleFileAction_1_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3705:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3707:1: 
            {
            }

             after(grammarAccess.getValueAccess().getObjectSingleFileAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_1__0__Impl"


    // $ANTLR start "rule__Value__Group_1__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3717:1: rule__Value__Group_1__1 : rule__Value__Group_1__1__Impl ;
    public final void rule__Value__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3721:1: ( rule__Value__Group_1__1__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3722:2: rule__Value__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Value__Group_1__1__Impl_in_rule__Value__Group_1__17577);
            rule__Value__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_1__1"


    // $ANTLR start "rule__Value__Group_1__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3728:1: rule__Value__Group_1__1__Impl : ( ( rule__Value__NameAssignment_1_1 ) ) ;
    public final void rule__Value__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3732:1: ( ( ( rule__Value__NameAssignment_1_1 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3733:1: ( ( rule__Value__NameAssignment_1_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3733:1: ( ( rule__Value__NameAssignment_1_1 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3734:1: ( rule__Value__NameAssignment_1_1 )
            {
             before(grammarAccess.getValueAccess().getNameAssignment_1_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3735:1: ( rule__Value__NameAssignment_1_1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3735:2: rule__Value__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Value__NameAssignment_1_1_in_rule__Value__Group_1__1__Impl7604);
            rule__Value__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_1__1__Impl"


    // $ANTLR start "rule__Value__Group_2__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3749:1: rule__Value__Group_2__0 : rule__Value__Group_2__0__Impl rule__Value__Group_2__1 ;
    public final void rule__Value__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3753:1: ( rule__Value__Group_2__0__Impl rule__Value__Group_2__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3754:2: rule__Value__Group_2__0__Impl rule__Value__Group_2__1
            {
            pushFollow(FOLLOW_rule__Value__Group_2__0__Impl_in_rule__Value__Group_2__07638);
            rule__Value__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Value__Group_2__1_in_rule__Value__Group_2__07641);
            rule__Value__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_2__0"


    // $ANTLR start "rule__Value__Group_2__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3761:1: rule__Value__Group_2__0__Impl : ( () ) ;
    public final void rule__Value__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3765:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3766:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3766:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3767:1: ()
            {
             before(grammarAccess.getValueAccess().getObjectVariableAction_2_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3768:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3770:1: 
            {
            }

             after(grammarAccess.getValueAccess().getObjectVariableAction_2_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_2__0__Impl"


    // $ANTLR start "rule__Value__Group_2__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3780:1: rule__Value__Group_2__1 : rule__Value__Group_2__1__Impl rule__Value__Group_2__2 ;
    public final void rule__Value__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3784:1: ( rule__Value__Group_2__1__Impl rule__Value__Group_2__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3785:2: rule__Value__Group_2__1__Impl rule__Value__Group_2__2
            {
            pushFollow(FOLLOW_rule__Value__Group_2__1__Impl_in_rule__Value__Group_2__17699);
            rule__Value__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Value__Group_2__2_in_rule__Value__Group_2__17702);
            rule__Value__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_2__1"


    // $ANTLR start "rule__Value__Group_2__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3792:1: rule__Value__Group_2__1__Impl : ( ( rule__Value__ValueAssignment_2_1 ) ) ;
    public final void rule__Value__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3796:1: ( ( ( rule__Value__ValueAssignment_2_1 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3797:1: ( ( rule__Value__ValueAssignment_2_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3797:1: ( ( rule__Value__ValueAssignment_2_1 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3798:1: ( rule__Value__ValueAssignment_2_1 )
            {
             before(grammarAccess.getValueAccess().getValueAssignment_2_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3799:1: ( rule__Value__ValueAssignment_2_1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3799:2: rule__Value__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Value__ValueAssignment_2_1_in_rule__Value__Group_2__1__Impl7729);
            rule__Value__ValueAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getValueAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_2__1__Impl"


    // $ANTLR start "rule__Value__Group_2__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3809:1: rule__Value__Group_2__2 : rule__Value__Group_2__2__Impl ;
    public final void rule__Value__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3813:1: ( rule__Value__Group_2__2__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3814:2: rule__Value__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Value__Group_2__2__Impl_in_rule__Value__Group_2__27759);
            rule__Value__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_2__2"


    // $ANTLR start "rule__Value__Group_2__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3820:1: rule__Value__Group_2__2__Impl : ( ( rule__Value__AdditionalAssignment_2_2 )? ) ;
    public final void rule__Value__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3824:1: ( ( ( rule__Value__AdditionalAssignment_2_2 )? ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3825:1: ( ( rule__Value__AdditionalAssignment_2_2 )? )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3825:1: ( ( rule__Value__AdditionalAssignment_2_2 )? )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3826:1: ( rule__Value__AdditionalAssignment_2_2 )?
            {
             before(grammarAccess.getValueAccess().getAdditionalAssignment_2_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3827:1: ( rule__Value__AdditionalAssignment_2_2 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_SLASH) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3827:2: rule__Value__AdditionalAssignment_2_2
                    {
                    pushFollow(FOLLOW_rule__Value__AdditionalAssignment_2_2_in_rule__Value__Group_2__2__Impl7786);
                    rule__Value__AdditionalAssignment_2_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getValueAccess().getAdditionalAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_2__2__Impl"


    // $ANTLR start "rule__Value__Group_3__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3843:1: rule__Value__Group_3__0 : rule__Value__Group_3__0__Impl rule__Value__Group_3__1 ;
    public final void rule__Value__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3847:1: ( rule__Value__Group_3__0__Impl rule__Value__Group_3__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3848:2: rule__Value__Group_3__0__Impl rule__Value__Group_3__1
            {
            pushFollow(FOLLOW_rule__Value__Group_3__0__Impl_in_rule__Value__Group_3__07823);
            rule__Value__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Value__Group_3__1_in_rule__Value__Group_3__07826);
            rule__Value__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_3__0"


    // $ANTLR start "rule__Value__Group_3__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3855:1: rule__Value__Group_3__0__Impl : ( () ) ;
    public final void rule__Value__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3859:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3860:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3860:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3861:1: ()
            {
             before(grammarAccess.getValueAccess().getObjectShellCmdAction_3_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3862:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3864:1: 
            {
            }

             after(grammarAccess.getValueAccess().getObjectShellCmdAction_3_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_3__0__Impl"


    // $ANTLR start "rule__Value__Group_3__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3874:1: rule__Value__Group_3__1 : rule__Value__Group_3__1__Impl ;
    public final void rule__Value__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3878:1: ( rule__Value__Group_3__1__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3879:2: rule__Value__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Value__Group_3__1__Impl_in_rule__Value__Group_3__17884);
            rule__Value__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_3__1"


    // $ANTLR start "rule__Value__Group_3__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3885:1: rule__Value__Group_3__1__Impl : ( ( rule__Value__ValueAssignment_3_1 ) ) ;
    public final void rule__Value__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3889:1: ( ( ( rule__Value__ValueAssignment_3_1 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3890:1: ( ( rule__Value__ValueAssignment_3_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3890:1: ( ( rule__Value__ValueAssignment_3_1 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3891:1: ( rule__Value__ValueAssignment_3_1 )
            {
             before(grammarAccess.getValueAccess().getValueAssignment_3_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3892:1: ( rule__Value__ValueAssignment_3_1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3892:2: rule__Value__ValueAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Value__ValueAssignment_3_1_in_rule__Value__Group_3__1__Impl7911);
            rule__Value__ValueAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getValueAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_3__1__Impl"


    // $ANTLR start "rule__Value__Group_4__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3906:1: rule__Value__Group_4__0 : rule__Value__Group_4__0__Impl rule__Value__Group_4__1 ;
    public final void rule__Value__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3910:1: ( rule__Value__Group_4__0__Impl rule__Value__Group_4__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3911:2: rule__Value__Group_4__0__Impl rule__Value__Group_4__1
            {
            pushFollow(FOLLOW_rule__Value__Group_4__0__Impl_in_rule__Value__Group_4__07945);
            rule__Value__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Value__Group_4__1_in_rule__Value__Group_4__07948);
            rule__Value__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_4__0"


    // $ANTLR start "rule__Value__Group_4__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3918:1: rule__Value__Group_4__0__Impl : ( () ) ;
    public final void rule__Value__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3922:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3923:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3923:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3924:1: ()
            {
             before(grammarAccess.getValueAccess().getObjectStringAction_4_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3925:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3927:1: 
            {
            }

             after(grammarAccess.getValueAccess().getObjectStringAction_4_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_4__0__Impl"


    // $ANTLR start "rule__Value__Group_4__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3937:1: rule__Value__Group_4__1 : rule__Value__Group_4__1__Impl ;
    public final void rule__Value__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3941:1: ( rule__Value__Group_4__1__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3942:2: rule__Value__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Value__Group_4__1__Impl_in_rule__Value__Group_4__18006);
            rule__Value__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_4__1"


    // $ANTLR start "rule__Value__Group_4__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3948:1: rule__Value__Group_4__1__Impl : ( RULE_STRING ) ;
    public final void rule__Value__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3952:1: ( ( RULE_STRING ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3953:1: ( RULE_STRING )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3953:1: ( RULE_STRING )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3954:1: RULE_STRING
            {
             before(grammarAccess.getValueAccess().getSTRINGTerminalRuleCall_4_1()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Value__Group_4__1__Impl8033); 
             after(grammarAccess.getValueAccess().getSTRINGTerminalRuleCall_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_4__1__Impl"


    // $ANTLR start "rule__Value__Group_5__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3969:1: rule__Value__Group_5__0 : rule__Value__Group_5__0__Impl rule__Value__Group_5__1 ;
    public final void rule__Value__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3973:1: ( rule__Value__Group_5__0__Impl rule__Value__Group_5__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3974:2: rule__Value__Group_5__0__Impl rule__Value__Group_5__1
            {
            pushFollow(FOLLOW_rule__Value__Group_5__0__Impl_in_rule__Value__Group_5__08066);
            rule__Value__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Value__Group_5__1_in_rule__Value__Group_5__08069);
            rule__Value__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_5__0"


    // $ANTLR start "rule__Value__Group_5__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3981:1: rule__Value__Group_5__0__Impl : ( () ) ;
    public final void rule__Value__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3985:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3986:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3986:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3987:1: ()
            {
             before(grammarAccess.getValueAccess().getObjectShellCharAction_5_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3988:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:3990:1: 
            {
            }

             after(grammarAccess.getValueAccess().getObjectShellCharAction_5_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_5__0__Impl"


    // $ANTLR start "rule__Value__Group_5__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4000:1: rule__Value__Group_5__1 : rule__Value__Group_5__1__Impl ;
    public final void rule__Value__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4004:1: ( rule__Value__Group_5__1__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4005:2: rule__Value__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__Value__Group_5__1__Impl_in_rule__Value__Group_5__18127);
            rule__Value__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_5__1"


    // $ANTLR start "rule__Value__Group_5__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4011:1: rule__Value__Group_5__1__Impl : ( ( rule__Value__ValueAssignment_5_1 ) ) ;
    public final void rule__Value__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4015:1: ( ( ( rule__Value__ValueAssignment_5_1 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4016:1: ( ( rule__Value__ValueAssignment_5_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4016:1: ( ( rule__Value__ValueAssignment_5_1 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4017:1: ( rule__Value__ValueAssignment_5_1 )
            {
             before(grammarAccess.getValueAccess().getValueAssignment_5_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4018:1: ( rule__Value__ValueAssignment_5_1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4018:2: rule__Value__ValueAssignment_5_1
            {
            pushFollow(FOLLOW_rule__Value__ValueAssignment_5_1_in_rule__Value__Group_5__1__Impl8154);
            rule__Value__ValueAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getValueAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_5__1__Impl"


    // $ANTLR start "rule__Value__Group_6__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4032:1: rule__Value__Group_6__0 : rule__Value__Group_6__0__Impl rule__Value__Group_6__1 ;
    public final void rule__Value__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4036:1: ( rule__Value__Group_6__0__Impl rule__Value__Group_6__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4037:2: rule__Value__Group_6__0__Impl rule__Value__Group_6__1
            {
            pushFollow(FOLLOW_rule__Value__Group_6__0__Impl_in_rule__Value__Group_6__08188);
            rule__Value__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Value__Group_6__1_in_rule__Value__Group_6__08191);
            rule__Value__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_6__0"


    // $ANTLR start "rule__Value__Group_6__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4044:1: rule__Value__Group_6__0__Impl : ( () ) ;
    public final void rule__Value__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4048:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4049:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4049:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4050:1: ()
            {
             before(grammarAccess.getValueAccess().getObjectDirAction_6_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4051:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4053:1: 
            {
            }

             after(grammarAccess.getValueAccess().getObjectDirAction_6_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_6__0__Impl"


    // $ANTLR start "rule__Value__Group_6__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4063:1: rule__Value__Group_6__1 : rule__Value__Group_6__1__Impl rule__Value__Group_6__2 ;
    public final void rule__Value__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4067:1: ( rule__Value__Group_6__1__Impl rule__Value__Group_6__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4068:2: rule__Value__Group_6__1__Impl rule__Value__Group_6__2
            {
            pushFollow(FOLLOW_rule__Value__Group_6__1__Impl_in_rule__Value__Group_6__18249);
            rule__Value__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Value__Group_6__2_in_rule__Value__Group_6__18252);
            rule__Value__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_6__1"


    // $ANTLR start "rule__Value__Group_6__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4075:1: rule__Value__Group_6__1__Impl : ( RULE_SYMBOL ) ;
    public final void rule__Value__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4079:1: ( ( RULE_SYMBOL ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4080:1: ( RULE_SYMBOL )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4080:1: ( RULE_SYMBOL )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4081:1: RULE_SYMBOL
            {
             before(grammarAccess.getValueAccess().getSYMBOLTerminalRuleCall_6_1()); 
            match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_rule__Value__Group_6__1__Impl8279); 
             after(grammarAccess.getValueAccess().getSYMBOLTerminalRuleCall_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_6__1__Impl"


    // $ANTLR start "rule__Value__Group_6__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4092:1: rule__Value__Group_6__2 : rule__Value__Group_6__2__Impl ;
    public final void rule__Value__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4096:1: ( rule__Value__Group_6__2__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4097:2: rule__Value__Group_6__2__Impl
            {
            pushFollow(FOLLOW_rule__Value__Group_6__2__Impl_in_rule__Value__Group_6__28308);
            rule__Value__Group_6__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_6__2"


    // $ANTLR start "rule__Value__Group_6__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4103:1: rule__Value__Group_6__2__Impl : ( RULE_SLASH ) ;
    public final void rule__Value__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4107:1: ( ( RULE_SLASH ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4108:1: ( RULE_SLASH )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4108:1: ( RULE_SLASH )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4109:1: RULE_SLASH
            {
             before(grammarAccess.getValueAccess().getSLASHTerminalRuleCall_6_2()); 
            match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_rule__Value__Group_6__2__Impl8335); 
             after(grammarAccess.getValueAccess().getSLASHTerminalRuleCall_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_6__2__Impl"


    // $ANTLR start "rule__Variable__Group_0__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4126:1: rule__Variable__Group_0__0 : rule__Variable__Group_0__0__Impl rule__Variable__Group_0__1 ;
    public final void rule__Variable__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4130:1: ( rule__Variable__Group_0__0__Impl rule__Variable__Group_0__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4131:2: rule__Variable__Group_0__0__Impl rule__Variable__Group_0__1
            {
            pushFollow(FOLLOW_rule__Variable__Group_0__0__Impl_in_rule__Variable__Group_0__08370);
            rule__Variable__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_0__1_in_rule__Variable__Group_0__08373);
            rule__Variable__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_0__0"


    // $ANTLR start "rule__Variable__Group_0__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4138:1: rule__Variable__Group_0__0__Impl : ( () ) ;
    public final void rule__Variable__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4142:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4143:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4143:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4144:1: ()
            {
             before(grammarAccess.getVariableAccess().getVariableAction_0_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4145:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4147:1: 
            {
            }

             after(grammarAccess.getVariableAccess().getVariableAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_0__0__Impl"


    // $ANTLR start "rule__Variable__Group_0__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4157:1: rule__Variable__Group_0__1 : rule__Variable__Group_0__1__Impl rule__Variable__Group_0__2 ;
    public final void rule__Variable__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4161:1: ( rule__Variable__Group_0__1__Impl rule__Variable__Group_0__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4162:2: rule__Variable__Group_0__1__Impl rule__Variable__Group_0__2
            {
            pushFollow(FOLLOW_rule__Variable__Group_0__1__Impl_in_rule__Variable__Group_0__18431);
            rule__Variable__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_0__2_in_rule__Variable__Group_0__18434);
            rule__Variable__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_0__1"


    // $ANTLR start "rule__Variable__Group_0__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4169:1: rule__Variable__Group_0__1__Impl : ( RULE_DOLLAR ) ;
    public final void rule__Variable__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4173:1: ( ( RULE_DOLLAR ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4174:1: ( RULE_DOLLAR )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4174:1: ( RULE_DOLLAR )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4175:1: RULE_DOLLAR
            {
             before(grammarAccess.getVariableAccess().getDOLLARTerminalRuleCall_0_1()); 
            match(input,RULE_DOLLAR,FOLLOW_RULE_DOLLAR_in_rule__Variable__Group_0__1__Impl8461); 
             after(grammarAccess.getVariableAccess().getDOLLARTerminalRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_0__1__Impl"


    // $ANTLR start "rule__Variable__Group_0__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4186:1: rule__Variable__Group_0__2 : rule__Variable__Group_0__2__Impl ;
    public final void rule__Variable__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4190:1: ( rule__Variable__Group_0__2__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4191:2: rule__Variable__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Variable__Group_0__2__Impl_in_rule__Variable__Group_0__28490);
            rule__Variable__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_0__2"


    // $ANTLR start "rule__Variable__Group_0__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4197:1: rule__Variable__Group_0__2__Impl : ( ( rule__Variable__NameAssignment_0_2 ) ) ;
    public final void rule__Variable__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4201:1: ( ( ( rule__Variable__NameAssignment_0_2 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4202:1: ( ( rule__Variable__NameAssignment_0_2 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4202:1: ( ( rule__Variable__NameAssignment_0_2 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4203:1: ( rule__Variable__NameAssignment_0_2 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_0_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4204:1: ( rule__Variable__NameAssignment_0_2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4204:2: rule__Variable__NameAssignment_0_2
            {
            pushFollow(FOLLOW_rule__Variable__NameAssignment_0_2_in_rule__Variable__Group_0__2__Impl8517);
            rule__Variable__NameAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getNameAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_0__2__Impl"


    // $ANTLR start "rule__Variable__Group_1__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4220:1: rule__Variable__Group_1__0 : rule__Variable__Group_1__0__Impl rule__Variable__Group_1__1 ;
    public final void rule__Variable__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4224:1: ( rule__Variable__Group_1__0__Impl rule__Variable__Group_1__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4225:2: rule__Variable__Group_1__0__Impl rule__Variable__Group_1__1
            {
            pushFollow(FOLLOW_rule__Variable__Group_1__0__Impl_in_rule__Variable__Group_1__08553);
            rule__Variable__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_1__1_in_rule__Variable__Group_1__08556);
            rule__Variable__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_1__0"


    // $ANTLR start "rule__Variable__Group_1__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4232:1: rule__Variable__Group_1__0__Impl : ( RULE_DOLLAR ) ;
    public final void rule__Variable__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4236:1: ( ( RULE_DOLLAR ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4237:1: ( RULE_DOLLAR )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4237:1: ( RULE_DOLLAR )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4238:1: RULE_DOLLAR
            {
             before(grammarAccess.getVariableAccess().getDOLLARTerminalRuleCall_1_0()); 
            match(input,RULE_DOLLAR,FOLLOW_RULE_DOLLAR_in_rule__Variable__Group_1__0__Impl8583); 
             after(grammarAccess.getVariableAccess().getDOLLARTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_1__0__Impl"


    // $ANTLR start "rule__Variable__Group_1__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4249:1: rule__Variable__Group_1__1 : rule__Variable__Group_1__1__Impl rule__Variable__Group_1__2 ;
    public final void rule__Variable__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4253:1: ( rule__Variable__Group_1__1__Impl rule__Variable__Group_1__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4254:2: rule__Variable__Group_1__1__Impl rule__Variable__Group_1__2
            {
            pushFollow(FOLLOW_rule__Variable__Group_1__1__Impl_in_rule__Variable__Group_1__18612);
            rule__Variable__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_1__2_in_rule__Variable__Group_1__18615);
            rule__Variable__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_1__1"


    // $ANTLR start "rule__Variable__Group_1__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4261:1: rule__Variable__Group_1__1__Impl : ( RULE_BRACE_START ) ;
    public final void rule__Variable__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4265:1: ( ( RULE_BRACE_START ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4266:1: ( RULE_BRACE_START )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4266:1: ( RULE_BRACE_START )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4267:1: RULE_BRACE_START
            {
             before(grammarAccess.getVariableAccess().getBRACE_STARTTerminalRuleCall_1_1()); 
            match(input,RULE_BRACE_START,FOLLOW_RULE_BRACE_START_in_rule__Variable__Group_1__1__Impl8642); 
             after(grammarAccess.getVariableAccess().getBRACE_STARTTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_1__1__Impl"


    // $ANTLR start "rule__Variable__Group_1__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4278:1: rule__Variable__Group_1__2 : rule__Variable__Group_1__2__Impl rule__Variable__Group_1__3 ;
    public final void rule__Variable__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4282:1: ( rule__Variable__Group_1__2__Impl rule__Variable__Group_1__3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4283:2: rule__Variable__Group_1__2__Impl rule__Variable__Group_1__3
            {
            pushFollow(FOLLOW_rule__Variable__Group_1__2__Impl_in_rule__Variable__Group_1__28671);
            rule__Variable__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_1__3_in_rule__Variable__Group_1__28674);
            rule__Variable__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_1__2"


    // $ANTLR start "rule__Variable__Group_1__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4290:1: rule__Variable__Group_1__2__Impl : ( ( rule__Variable__NameAssignment_1_2 ) ) ;
    public final void rule__Variable__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4294:1: ( ( ( rule__Variable__NameAssignment_1_2 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4295:1: ( ( rule__Variable__NameAssignment_1_2 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4295:1: ( ( rule__Variable__NameAssignment_1_2 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4296:1: ( rule__Variable__NameAssignment_1_2 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_1_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4297:1: ( rule__Variable__NameAssignment_1_2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4297:2: rule__Variable__NameAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Variable__NameAssignment_1_2_in_rule__Variable__Group_1__2__Impl8701);
            rule__Variable__NameAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getNameAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_1__2__Impl"


    // $ANTLR start "rule__Variable__Group_1__3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4307:1: rule__Variable__Group_1__3 : rule__Variable__Group_1__3__Impl ;
    public final void rule__Variable__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4311:1: ( rule__Variable__Group_1__3__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4312:2: rule__Variable__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__Variable__Group_1__3__Impl_in_rule__Variable__Group_1__38731);
            rule__Variable__Group_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_1__3"


    // $ANTLR start "rule__Variable__Group_1__3__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4318:1: rule__Variable__Group_1__3__Impl : ( RULE_BRACE_END ) ;
    public final void rule__Variable__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4322:1: ( ( RULE_BRACE_END ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4323:1: ( RULE_BRACE_END )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4323:1: ( RULE_BRACE_END )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4324:1: RULE_BRACE_END
            {
             before(grammarAccess.getVariableAccess().getBRACE_ENDTerminalRuleCall_1_3()); 
            match(input,RULE_BRACE_END,FOLLOW_RULE_BRACE_END_in_rule__Variable__Group_1__3__Impl8758); 
             after(grammarAccess.getVariableAccess().getBRACE_ENDTerminalRuleCall_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_1__3__Impl"


    // $ANTLR start "rule__ShellCmd__Group_0__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4343:1: rule__ShellCmd__Group_0__0 : rule__ShellCmd__Group_0__0__Impl rule__ShellCmd__Group_0__1 ;
    public final void rule__ShellCmd__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4347:1: ( rule__ShellCmd__Group_0__0__Impl rule__ShellCmd__Group_0__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4348:2: rule__ShellCmd__Group_0__0__Impl rule__ShellCmd__Group_0__1
            {
            pushFollow(FOLLOW_rule__ShellCmd__Group_0__0__Impl_in_rule__ShellCmd__Group_0__08795);
            rule__ShellCmd__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ShellCmd__Group_0__1_in_rule__ShellCmd__Group_0__08798);
            rule__ShellCmd__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_0__0"


    // $ANTLR start "rule__ShellCmd__Group_0__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4355:1: rule__ShellCmd__Group_0__0__Impl : ( () ) ;
    public final void rule__ShellCmd__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4359:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4360:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4360:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4361:1: ()
            {
             before(grammarAccess.getShellCmdAccess().getShellCmdAction_0_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4362:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4364:1: 
            {
            }

             after(grammarAccess.getShellCmdAccess().getShellCmdAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_0__0__Impl"


    // $ANTLR start "rule__ShellCmd__Group_0__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4374:1: rule__ShellCmd__Group_0__1 : rule__ShellCmd__Group_0__1__Impl ;
    public final void rule__ShellCmd__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4378:1: ( rule__ShellCmd__Group_0__1__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4379:2: rule__ShellCmd__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ShellCmd__Group_0__1__Impl_in_rule__ShellCmd__Group_0__18856);
            rule__ShellCmd__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_0__1"


    // $ANTLR start "rule__ShellCmd__Group_0__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4385:1: rule__ShellCmd__Group_0__1__Impl : ( ( rule__ShellCmd__Group_0_1__0 ) ) ;
    public final void rule__ShellCmd__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4389:1: ( ( ( rule__ShellCmd__Group_0_1__0 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4390:1: ( ( rule__ShellCmd__Group_0_1__0 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4390:1: ( ( rule__ShellCmd__Group_0_1__0 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4391:1: ( rule__ShellCmd__Group_0_1__0 )
            {
             before(grammarAccess.getShellCmdAccess().getGroup_0_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4392:1: ( rule__ShellCmd__Group_0_1__0 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4392:2: rule__ShellCmd__Group_0_1__0
            {
            pushFollow(FOLLOW_rule__ShellCmd__Group_0_1__0_in_rule__ShellCmd__Group_0__1__Impl8883);
            rule__ShellCmd__Group_0_1__0();

            state._fsp--;


            }

             after(grammarAccess.getShellCmdAccess().getGroup_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_0__1__Impl"


    // $ANTLR start "rule__ShellCmd__Group_0_1__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4406:1: rule__ShellCmd__Group_0_1__0 : rule__ShellCmd__Group_0_1__0__Impl rule__ShellCmd__Group_0_1__1 ;
    public final void rule__ShellCmd__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4410:1: ( rule__ShellCmd__Group_0_1__0__Impl rule__ShellCmd__Group_0_1__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4411:2: rule__ShellCmd__Group_0_1__0__Impl rule__ShellCmd__Group_0_1__1
            {
            pushFollow(FOLLOW_rule__ShellCmd__Group_0_1__0__Impl_in_rule__ShellCmd__Group_0_1__08917);
            rule__ShellCmd__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ShellCmd__Group_0_1__1_in_rule__ShellCmd__Group_0_1__08920);
            rule__ShellCmd__Group_0_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_0_1__0"


    // $ANTLR start "rule__ShellCmd__Group_0_1__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4418:1: rule__ShellCmd__Group_0_1__0__Impl : ( RULE_DOLLAR ) ;
    public final void rule__ShellCmd__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4422:1: ( ( RULE_DOLLAR ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4423:1: ( RULE_DOLLAR )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4423:1: ( RULE_DOLLAR )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4424:1: RULE_DOLLAR
            {
             before(grammarAccess.getShellCmdAccess().getDOLLARTerminalRuleCall_0_1_0()); 
            match(input,RULE_DOLLAR,FOLLOW_RULE_DOLLAR_in_rule__ShellCmd__Group_0_1__0__Impl8947); 
             after(grammarAccess.getShellCmdAccess().getDOLLARTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_0_1__0__Impl"


    // $ANTLR start "rule__ShellCmd__Group_0_1__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4435:1: rule__ShellCmd__Group_0_1__1 : rule__ShellCmd__Group_0_1__1__Impl rule__ShellCmd__Group_0_1__2 ;
    public final void rule__ShellCmd__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4439:1: ( rule__ShellCmd__Group_0_1__1__Impl rule__ShellCmd__Group_0_1__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4440:2: rule__ShellCmd__Group_0_1__1__Impl rule__ShellCmd__Group_0_1__2
            {
            pushFollow(FOLLOW_rule__ShellCmd__Group_0_1__1__Impl_in_rule__ShellCmd__Group_0_1__18976);
            rule__ShellCmd__Group_0_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ShellCmd__Group_0_1__2_in_rule__ShellCmd__Group_0_1__18979);
            rule__ShellCmd__Group_0_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_0_1__1"


    // $ANTLR start "rule__ShellCmd__Group_0_1__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4447:1: rule__ShellCmd__Group_0_1__1__Impl : ( RULE_BRACE_START ) ;
    public final void rule__ShellCmd__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4451:1: ( ( RULE_BRACE_START ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4452:1: ( RULE_BRACE_START )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4452:1: ( RULE_BRACE_START )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4453:1: RULE_BRACE_START
            {
             before(grammarAccess.getShellCmdAccess().getBRACE_STARTTerminalRuleCall_0_1_1()); 
            match(input,RULE_BRACE_START,FOLLOW_RULE_BRACE_START_in_rule__ShellCmd__Group_0_1__1__Impl9006); 
             after(grammarAccess.getShellCmdAccess().getBRACE_STARTTerminalRuleCall_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_0_1__1__Impl"


    // $ANTLR start "rule__ShellCmd__Group_0_1__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4464:1: rule__ShellCmd__Group_0_1__2 : rule__ShellCmd__Group_0_1__2__Impl rule__ShellCmd__Group_0_1__3 ;
    public final void rule__ShellCmd__Group_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4468:1: ( rule__ShellCmd__Group_0_1__2__Impl rule__ShellCmd__Group_0_1__3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4469:2: rule__ShellCmd__Group_0_1__2__Impl rule__ShellCmd__Group_0_1__3
            {
            pushFollow(FOLLOW_rule__ShellCmd__Group_0_1__2__Impl_in_rule__ShellCmd__Group_0_1__29035);
            rule__ShellCmd__Group_0_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ShellCmd__Group_0_1__3_in_rule__ShellCmd__Group_0_1__29038);
            rule__ShellCmd__Group_0_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_0_1__2"


    // $ANTLR start "rule__ShellCmd__Group_0_1__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4476:1: rule__ShellCmd__Group_0_1__2__Impl : ( ( rule__ShellCmd__NameAssignment_0_1_2 ) ) ;
    public final void rule__ShellCmd__Group_0_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4480:1: ( ( ( rule__ShellCmd__NameAssignment_0_1_2 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4481:1: ( ( rule__ShellCmd__NameAssignment_0_1_2 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4481:1: ( ( rule__ShellCmd__NameAssignment_0_1_2 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4482:1: ( rule__ShellCmd__NameAssignment_0_1_2 )
            {
             before(grammarAccess.getShellCmdAccess().getNameAssignment_0_1_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4483:1: ( rule__ShellCmd__NameAssignment_0_1_2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4483:2: rule__ShellCmd__NameAssignment_0_1_2
            {
            pushFollow(FOLLOW_rule__ShellCmd__NameAssignment_0_1_2_in_rule__ShellCmd__Group_0_1__2__Impl9065);
            rule__ShellCmd__NameAssignment_0_1_2();

            state._fsp--;


            }

             after(grammarAccess.getShellCmdAccess().getNameAssignment_0_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_0_1__2__Impl"


    // $ANTLR start "rule__ShellCmd__Group_0_1__3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4493:1: rule__ShellCmd__Group_0_1__3 : rule__ShellCmd__Group_0_1__3__Impl rule__ShellCmd__Group_0_1__4 ;
    public final void rule__ShellCmd__Group_0_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4497:1: ( rule__ShellCmd__Group_0_1__3__Impl rule__ShellCmd__Group_0_1__4 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4498:2: rule__ShellCmd__Group_0_1__3__Impl rule__ShellCmd__Group_0_1__4
            {
            pushFollow(FOLLOW_rule__ShellCmd__Group_0_1__3__Impl_in_rule__ShellCmd__Group_0_1__39095);
            rule__ShellCmd__Group_0_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ShellCmd__Group_0_1__4_in_rule__ShellCmd__Group_0_1__39098);
            rule__ShellCmd__Group_0_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_0_1__3"


    // $ANTLR start "rule__ShellCmd__Group_0_1__3__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4505:1: rule__ShellCmd__Group_0_1__3__Impl : ( ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 ) ) ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 )* ) ) ;
    public final void rule__ShellCmd__Group_0_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4509:1: ( ( ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 ) ) ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 )* ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4510:1: ( ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 ) ) ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 )* ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4510:1: ( ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 ) ) ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 )* ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4511:1: ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 ) ) ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 )* )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4511:1: ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4512:1: ( rule__ShellCmd__ShellPartAssignment_0_1_3 )
            {
             before(grammarAccess.getShellCmdAccess().getShellPartAssignment_0_1_3()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4513:1: ( rule__ShellCmd__ShellPartAssignment_0_1_3 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4513:2: rule__ShellCmd__ShellPartAssignment_0_1_3
            {
            pushFollow(FOLLOW_rule__ShellCmd__ShellPartAssignment_0_1_3_in_rule__ShellCmd__Group_0_1__3__Impl9127);
            rule__ShellCmd__ShellPartAssignment_0_1_3();

            state._fsp--;


            }

             after(grammarAccess.getShellCmdAccess().getShellPartAssignment_0_1_3()); 

            }

            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4516:1: ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 )* )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4517:1: ( rule__ShellCmd__ShellPartAssignment_0_1_3 )*
            {
             before(grammarAccess.getShellCmdAccess().getShellPartAssignment_0_1_3()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4518:1: ( rule__ShellCmd__ShellPartAssignment_0_1_3 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=RULE_STRING && LA36_0<=RULE_SHELL_CHAR)||(LA36_0>=RULE_BACKSLASH && LA36_0<=RULE_SYMBOL)||(LA36_0>=RULE_SLASH && LA36_0<=RULE_INCLUDE)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4518:2: rule__ShellCmd__ShellPartAssignment_0_1_3
            	    {
            	    pushFollow(FOLLOW_rule__ShellCmd__ShellPartAssignment_0_1_3_in_rule__ShellCmd__Group_0_1__3__Impl9139);
            	    rule__ShellCmd__ShellPartAssignment_0_1_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getShellCmdAccess().getShellPartAssignment_0_1_3()); 

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
    // $ANTLR end "rule__ShellCmd__Group_0_1__3__Impl"


    // $ANTLR start "rule__ShellCmd__Group_0_1__4"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4529:1: rule__ShellCmd__Group_0_1__4 : rule__ShellCmd__Group_0_1__4__Impl ;
    public final void rule__ShellCmd__Group_0_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4533:1: ( rule__ShellCmd__Group_0_1__4__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4534:2: rule__ShellCmd__Group_0_1__4__Impl
            {
            pushFollow(FOLLOW_rule__ShellCmd__Group_0_1__4__Impl_in_rule__ShellCmd__Group_0_1__49172);
            rule__ShellCmd__Group_0_1__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_0_1__4"


    // $ANTLR start "rule__ShellCmd__Group_0_1__4__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4540:1: rule__ShellCmd__Group_0_1__4__Impl : ( RULE_BRACE_END ) ;
    public final void rule__ShellCmd__Group_0_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4544:1: ( ( RULE_BRACE_END ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4545:1: ( RULE_BRACE_END )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4545:1: ( RULE_BRACE_END )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4546:1: RULE_BRACE_END
            {
             before(grammarAccess.getShellCmdAccess().getBRACE_ENDTerminalRuleCall_0_1_4()); 
            match(input,RULE_BRACE_END,FOLLOW_RULE_BRACE_END_in_rule__ShellCmd__Group_0_1__4__Impl9199); 
             after(grammarAccess.getShellCmdAccess().getBRACE_ENDTerminalRuleCall_0_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_0_1__4__Impl"


    // $ANTLR start "rule__ShellCmd__Group_1__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4567:1: rule__ShellCmd__Group_1__0 : rule__ShellCmd__Group_1__0__Impl rule__ShellCmd__Group_1__1 ;
    public final void rule__ShellCmd__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4571:1: ( rule__ShellCmd__Group_1__0__Impl rule__ShellCmd__Group_1__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4572:2: rule__ShellCmd__Group_1__0__Impl rule__ShellCmd__Group_1__1
            {
            pushFollow(FOLLOW_rule__ShellCmd__Group_1__0__Impl_in_rule__ShellCmd__Group_1__09238);
            rule__ShellCmd__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ShellCmd__Group_1__1_in_rule__ShellCmd__Group_1__09241);
            rule__ShellCmd__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_1__0"


    // $ANTLR start "rule__ShellCmd__Group_1__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4579:1: rule__ShellCmd__Group_1__0__Impl : ( () ) ;
    public final void rule__ShellCmd__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4583:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4584:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4584:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4585:1: ()
            {
             before(grammarAccess.getShellCmdAccess().getIncludeAction_1_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4586:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4588:1: 
            {
            }

             after(grammarAccess.getShellCmdAccess().getIncludeAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_1__0__Impl"


    // $ANTLR start "rule__ShellCmd__Group_1__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4598:1: rule__ShellCmd__Group_1__1 : rule__ShellCmd__Group_1__1__Impl ;
    public final void rule__ShellCmd__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4602:1: ( rule__ShellCmd__Group_1__1__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4603:2: rule__ShellCmd__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ShellCmd__Group_1__1__Impl_in_rule__ShellCmd__Group_1__19299);
            rule__ShellCmd__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_1__1"


    // $ANTLR start "rule__ShellCmd__Group_1__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4609:1: rule__ShellCmd__Group_1__1__Impl : ( RULE_INCLUDE ) ;
    public final void rule__ShellCmd__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4613:1: ( ( RULE_INCLUDE ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4614:1: ( RULE_INCLUDE )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4614:1: ( RULE_INCLUDE )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4615:1: RULE_INCLUDE
            {
             before(grammarAccess.getShellCmdAccess().getINCLUDETerminalRuleCall_1_1()); 
            match(input,RULE_INCLUDE,FOLLOW_RULE_INCLUDE_in_rule__ShellCmd__Group_1__1__Impl9326); 
             after(grammarAccess.getShellCmdAccess().getINCLUDETerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__Group_1__1__Impl"


    // $ANTLR start "rule__ShellPart__Group__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4630:1: rule__ShellPart__Group__0 : rule__ShellPart__Group__0__Impl rule__ShellPart__Group__1 ;
    public final void rule__ShellPart__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4634:1: ( rule__ShellPart__Group__0__Impl rule__ShellPart__Group__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4635:2: rule__ShellPart__Group__0__Impl rule__ShellPart__Group__1
            {
            pushFollow(FOLLOW_rule__ShellPart__Group__0__Impl_in_rule__ShellPart__Group__09359);
            rule__ShellPart__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ShellPart__Group__1_in_rule__ShellPart__Group__09362);
            rule__ShellPart__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellPart__Group__0"


    // $ANTLR start "rule__ShellPart__Group__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4642:1: rule__ShellPart__Group__0__Impl : ( () ) ;
    public final void rule__ShellPart__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4646:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4647:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4647:1: ( () )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4648:1: ()
            {
             before(grammarAccess.getShellPartAccess().getShellPartAction_0()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4649:1: ()
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4651:1: 
            {
            }

             after(grammarAccess.getShellPartAccess().getShellPartAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellPart__Group__0__Impl"


    // $ANTLR start "rule__ShellPart__Group__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4661:1: rule__ShellPart__Group__1 : rule__ShellPart__Group__1__Impl ;
    public final void rule__ShellPart__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4665:1: ( rule__ShellPart__Group__1__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4666:2: rule__ShellPart__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ShellPart__Group__1__Impl_in_rule__ShellPart__Group__19420);
            rule__ShellPart__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellPart__Group__1"


    // $ANTLR start "rule__ShellPart__Group__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4672:1: rule__ShellPart__Group__1__Impl : ( ( rule__ShellPart__Alternatives_1 ) ) ;
    public final void rule__ShellPart__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4676:1: ( ( ( rule__ShellPart__Alternatives_1 ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4677:1: ( ( rule__ShellPart__Alternatives_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4677:1: ( ( rule__ShellPart__Alternatives_1 ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4678:1: ( rule__ShellPart__Alternatives_1 )
            {
             before(grammarAccess.getShellPartAccess().getAlternatives_1()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4679:1: ( rule__ShellPart__Alternatives_1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4679:2: rule__ShellPart__Alternatives_1
            {
            pushFollow(FOLLOW_rule__ShellPart__Alternatives_1_in_rule__ShellPart__Group__1__Impl9447);
            rule__ShellPart__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getShellPartAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellPart__Group__1__Impl"


    // $ANTLR start "rule__ShellPart__Group_1_5__0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4693:1: rule__ShellPart__Group_1_5__0 : rule__ShellPart__Group_1_5__0__Impl rule__ShellPart__Group_1_5__1 ;
    public final void rule__ShellPart__Group_1_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4697:1: ( rule__ShellPart__Group_1_5__0__Impl rule__ShellPart__Group_1_5__1 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4698:2: rule__ShellPart__Group_1_5__0__Impl rule__ShellPart__Group_1_5__1
            {
            pushFollow(FOLLOW_rule__ShellPart__Group_1_5__0__Impl_in_rule__ShellPart__Group_1_5__09481);
            rule__ShellPart__Group_1_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ShellPart__Group_1_5__1_in_rule__ShellPart__Group_1_5__09484);
            rule__ShellPart__Group_1_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellPart__Group_1_5__0"


    // $ANTLR start "rule__ShellPart__Group_1_5__0__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4705:1: rule__ShellPart__Group_1_5__0__Impl : ( RULE_BACKSLASH ) ;
    public final void rule__ShellPart__Group_1_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4709:1: ( ( RULE_BACKSLASH ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4710:1: ( RULE_BACKSLASH )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4710:1: ( RULE_BACKSLASH )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4711:1: RULE_BACKSLASH
            {
             before(grammarAccess.getShellPartAccess().getBACKSLASHTerminalRuleCall_1_5_0()); 
            match(input,RULE_BACKSLASH,FOLLOW_RULE_BACKSLASH_in_rule__ShellPart__Group_1_5__0__Impl9511); 
             after(grammarAccess.getShellPartAccess().getBACKSLASHTerminalRuleCall_1_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellPart__Group_1_5__0__Impl"


    // $ANTLR start "rule__ShellPart__Group_1_5__1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4722:1: rule__ShellPart__Group_1_5__1 : rule__ShellPart__Group_1_5__1__Impl rule__ShellPart__Group_1_5__2 ;
    public final void rule__ShellPart__Group_1_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4726:1: ( rule__ShellPart__Group_1_5__1__Impl rule__ShellPart__Group_1_5__2 )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4727:2: rule__ShellPart__Group_1_5__1__Impl rule__ShellPart__Group_1_5__2
            {
            pushFollow(FOLLOW_rule__ShellPart__Group_1_5__1__Impl_in_rule__ShellPart__Group_1_5__19540);
            rule__ShellPart__Group_1_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ShellPart__Group_1_5__2_in_rule__ShellPart__Group_1_5__19543);
            rule__ShellPart__Group_1_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellPart__Group_1_5__1"


    // $ANTLR start "rule__ShellPart__Group_1_5__1__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4734:1: rule__ShellPart__Group_1_5__1__Impl : ( ruleEol ) ;
    public final void rule__ShellPart__Group_1_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4738:1: ( ( ruleEol ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4739:1: ( ruleEol )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4739:1: ( ruleEol )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4740:1: ruleEol
            {
             before(grammarAccess.getShellPartAccess().getEolParserRuleCall_1_5_1()); 
            pushFollow(FOLLOW_ruleEol_in_rule__ShellPart__Group_1_5__1__Impl9570);
            ruleEol();

            state._fsp--;

             after(grammarAccess.getShellPartAccess().getEolParserRuleCall_1_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellPart__Group_1_5__1__Impl"


    // $ANTLR start "rule__ShellPart__Group_1_5__2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4751:1: rule__ShellPart__Group_1_5__2 : rule__ShellPart__Group_1_5__2__Impl ;
    public final void rule__ShellPart__Group_1_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4755:1: ( rule__ShellPart__Group_1_5__2__Impl )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4756:2: rule__ShellPart__Group_1_5__2__Impl
            {
            pushFollow(FOLLOW_rule__ShellPart__Group_1_5__2__Impl_in_rule__ShellPart__Group_1_5__29599);
            rule__ShellPart__Group_1_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellPart__Group_1_5__2"


    // $ANTLR start "rule__ShellPart__Group_1_5__2__Impl"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4762:1: rule__ShellPart__Group_1_5__2__Impl : ( ( RULE_TAB )* ) ;
    public final void rule__ShellPart__Group_1_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4766:1: ( ( ( RULE_TAB )* ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4767:1: ( ( RULE_TAB )* )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4767:1: ( ( RULE_TAB )* )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4768:1: ( RULE_TAB )*
            {
             before(grammarAccess.getShellPartAccess().getTABTerminalRuleCall_1_5_2()); 
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4769:1: ( RULE_TAB )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_TAB) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4769:3: RULE_TAB
            	    {
            	    match(input,RULE_TAB,FOLLOW_RULE_TAB_in_rule__ShellPart__Group_1_5__2__Impl9627); 

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getShellPartAccess().getTABTerminalRuleCall_1_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellPart__Group_1_5__2__Impl"


    // $ANTLR start "rule__Model__BuildEntryAssignment_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4786:1: rule__Model__BuildEntryAssignment_1 : ( ruleBuildEntry ) ;
    public final void rule__Model__BuildEntryAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4790:1: ( ( ruleBuildEntry ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4791:1: ( ruleBuildEntry )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4791:1: ( ruleBuildEntry )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4792:1: ruleBuildEntry
            {
             before(grammarAccess.getModelAccess().getBuildEntryBuildEntryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBuildEntry_in_rule__Model__BuildEntryAssignment_19669);
            ruleBuildEntry();

            state._fsp--;

             after(grammarAccess.getModelAccess().getBuildEntryBuildEntryParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__BuildEntryAssignment_1"


    // $ANTLR start "rule__Model__BuildEntryAssignment_2_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4801:1: rule__Model__BuildEntryAssignment_2_1 : ( ruleBuildEntry ) ;
    public final void rule__Model__BuildEntryAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4805:1: ( ( ruleBuildEntry ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4806:1: ( ruleBuildEntry )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4806:1: ( ruleBuildEntry )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4807:1: ruleBuildEntry
            {
             before(grammarAccess.getModelAccess().getBuildEntryBuildEntryParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleBuildEntry_in_rule__Model__BuildEntryAssignment_2_19700);
            ruleBuildEntry();

            state._fsp--;

             after(grammarAccess.getModelAccess().getBuildEntryBuildEntryParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__BuildEntryAssignment_2_1"


    // $ANTLR start "rule__BuildEntry__ValueAssignment_0_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4816:1: rule__BuildEntry__ValueAssignment_0_1 : ( ruleEntry ) ;
    public final void rule__BuildEntry__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4820:1: ( ( ruleEntry ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4821:1: ( ruleEntry )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4821:1: ( ruleEntry )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4822:1: ruleEntry
            {
             before(grammarAccess.getBuildEntryAccess().getValueEntryParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleEntry_in_rule__BuildEntry__ValueAssignment_0_19731);
            ruleEntry();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getValueEntryParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__ValueAssignment_0_1"


    // $ANTLR start "rule__BuildEntry__ValueAssignment_1_2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4831:1: rule__BuildEntry__ValueAssignment_1_2 : ( ruleIf ) ;
    public final void rule__BuildEntry__ValueAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4835:1: ( ( ruleIf ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4836:1: ( ruleIf )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4836:1: ( ruleIf )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4837:1: ruleIf
            {
             before(grammarAccess.getBuildEntryAccess().getValueIfParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleIf_in_rule__BuildEntry__ValueAssignment_1_29762);
            ruleIf();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getValueIfParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__ValueAssignment_1_2"


    // $ANTLR start "rule__BuildEntry__ValueAssignment_2_2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4846:1: rule__BuildEntry__ValueAssignment_2_2 : ( ruleIf ) ;
    public final void rule__BuildEntry__ValueAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4850:1: ( ( ruleIf ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4851:1: ( ruleIf )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4851:1: ( ruleIf )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4852:1: ruleIf
            {
             before(grammarAccess.getBuildEntryAccess().getValueIfParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_ruleIf_in_rule__BuildEntry__ValueAssignment_2_29793);
            ruleIf();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getValueIfParserRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__ValueAssignment_2_2"


    // $ANTLR start "rule__BuildEntry__NameAssignment_3_2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4861:1: rule__BuildEntry__NameAssignment_3_2 : ( RULE_SYMBOL ) ;
    public final void rule__BuildEntry__NameAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4865:1: ( ( RULE_SYMBOL ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4866:1: ( RULE_SYMBOL )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4866:1: ( RULE_SYMBOL )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4867:1: RULE_SYMBOL
            {
             before(grammarAccess.getBuildEntryAccess().getNameSYMBOLTerminalRuleCall_3_2_0()); 
            match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_rule__BuildEntry__NameAssignment_3_29824); 
             after(grammarAccess.getBuildEntryAccess().getNameSYMBOLTerminalRuleCall_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__NameAssignment_3_2"


    // $ANTLR start "rule__BuildEntry__ValueAssignment_3_4_0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4876:1: rule__BuildEntry__ValueAssignment_3_4_0 : ( ruleObject_Y ) ;
    public final void rule__BuildEntry__ValueAssignment_3_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4880:1: ( ( ruleObject_Y ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4881:1: ( ruleObject_Y )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4881:1: ( ruleObject_Y )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4882:1: ruleObject_Y
            {
             before(grammarAccess.getBuildEntryAccess().getValueObject_YParserRuleCall_3_4_0_0()); 
            pushFollow(FOLLOW_ruleObject_Y_in_rule__BuildEntry__ValueAssignment_3_4_09855);
            ruleObject_Y();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getValueObject_YParserRuleCall_3_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__ValueAssignment_3_4_0"


    // $ANTLR start "rule__BuildEntry__ValueAssignment_3_4_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4891:1: rule__BuildEntry__ValueAssignment_3_4_1 : ( ruleObject_M ) ;
    public final void rule__BuildEntry__ValueAssignment_3_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4895:1: ( ( ruleObject_M ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4896:1: ( ruleObject_M )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4896:1: ( ruleObject_M )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4897:1: ruleObject_M
            {
             before(grammarAccess.getBuildEntryAccess().getValueObject_MParserRuleCall_3_4_1_0()); 
            pushFollow(FOLLOW_ruleObject_M_in_rule__BuildEntry__ValueAssignment_3_4_19886);
            ruleObject_M();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getValueObject_MParserRuleCall_3_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__ValueAssignment_3_4_1"


    // $ANTLR start "rule__BuildEntry__NameAssignment_4_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4906:1: rule__BuildEntry__NameAssignment_4_1 : ( RULE_SYMBOL ) ;
    public final void rule__BuildEntry__NameAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4910:1: ( ( RULE_SYMBOL ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4911:1: ( RULE_SYMBOL )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4911:1: ( RULE_SYMBOL )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4912:1: RULE_SYMBOL
            {
             before(grammarAccess.getBuildEntryAccess().getNameSYMBOLTerminalRuleCall_4_1_0()); 
            match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_rule__BuildEntry__NameAssignment_4_19917); 
             after(grammarAccess.getBuildEntryAccess().getNameSYMBOLTerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__NameAssignment_4_1"


    // $ANTLR start "rule__BuildEntry__VariableAssignment_4_2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4921:1: rule__BuildEntry__VariableAssignment_4_2 : ( ruleVariable ) ;
    public final void rule__BuildEntry__VariableAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4925:1: ( ( ruleVariable ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4926:1: ( ruleVariable )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4926:1: ( ruleVariable )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4927:1: ruleVariable
            {
             before(grammarAccess.getBuildEntryAccess().getVariableVariableParserRuleCall_4_2_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__BuildEntry__VariableAssignment_4_29948);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getVariableVariableParserRuleCall_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__VariableAssignment_4_2"


    // $ANTLR start "rule__BuildEntry__ValueAssignment_4_3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4936:1: rule__BuildEntry__ValueAssignment_4_3 : ( ruleAssignExtra ) ;
    public final void rule__BuildEntry__ValueAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4940:1: ( ( ruleAssignExtra ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4941:1: ( ruleAssignExtra )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4941:1: ( ruleAssignExtra )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4942:1: ruleAssignExtra
            {
             before(grammarAccess.getBuildEntryAccess().getValueAssignExtraParserRuleCall_4_3_0()); 
            pushFollow(FOLLOW_ruleAssignExtra_in_rule__BuildEntry__ValueAssignment_4_39979);
            ruleAssignExtra();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getValueAssignExtraParserRuleCall_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__ValueAssignment_4_3"


    // $ANTLR start "rule__BuildEntry__InnerAssignment_4_4"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4951:1: rule__BuildEntry__InnerAssignment_4_4 : ( ruleAssign ) ;
    public final void rule__BuildEntry__InnerAssignment_4_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4955:1: ( ( ruleAssign ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4956:1: ( ruleAssign )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4956:1: ( ruleAssign )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4957:1: ruleAssign
            {
             before(grammarAccess.getBuildEntryAccess().getInnerAssignParserRuleCall_4_4_0()); 
            pushFollow(FOLLOW_ruleAssign_in_rule__BuildEntry__InnerAssignment_4_410010);
            ruleAssign();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getInnerAssignParserRuleCall_4_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__InnerAssignment_4_4"


    // $ANTLR start "rule__BuildEntry__ValueAssignment_5_1_0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4966:1: rule__BuildEntry__ValueAssignment_5_1_0 : ( ruleObject_Y ) ;
    public final void rule__BuildEntry__ValueAssignment_5_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4970:1: ( ( ruleObject_Y ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4971:1: ( ruleObject_Y )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4971:1: ( ruleObject_Y )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4972:1: ruleObject_Y
            {
             before(grammarAccess.getBuildEntryAccess().getValueObject_YParserRuleCall_5_1_0_0()); 
            pushFollow(FOLLOW_ruleObject_Y_in_rule__BuildEntry__ValueAssignment_5_1_010041);
            ruleObject_Y();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getValueObject_YParserRuleCall_5_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__ValueAssignment_5_1_0"


    // $ANTLR start "rule__BuildEntry__ValueAssignment_5_1_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4981:1: rule__BuildEntry__ValueAssignment_5_1_1 : ( ruleObject_M ) ;
    public final void rule__BuildEntry__ValueAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4985:1: ( ( ruleObject_M ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4986:1: ( ruleObject_M )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4986:1: ( ruleObject_M )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4987:1: ruleObject_M
            {
             before(grammarAccess.getBuildEntryAccess().getValueObject_MParserRuleCall_5_1_1_0()); 
            pushFollow(FOLLOW_ruleObject_M_in_rule__BuildEntry__ValueAssignment_5_1_110072);
            ruleObject_M();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getValueObject_MParserRuleCall_5_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__ValueAssignment_5_1_1"


    // $ANTLR start "rule__BuildEntry__TargetAssignment_6_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:4996:1: rule__BuildEntry__TargetAssignment_6_1 : ( ruleValues ) ;
    public final void rule__BuildEntry__TargetAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5000:1: ( ( ruleValues ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5001:1: ( ruleValues )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5001:1: ( ruleValues )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5002:1: ruleValues
            {
             before(grammarAccess.getBuildEntryAccess().getTargetValuesParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_ruleValues_in_rule__BuildEntry__TargetAssignment_6_110103);
            ruleValues();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getTargetValuesParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__TargetAssignment_6_1"


    // $ANTLR start "rule__BuildEntry__ValuesAssignment_6_3_1_0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5011:1: rule__BuildEntry__ValuesAssignment_6_3_1_0 : ( ruleValues ) ;
    public final void rule__BuildEntry__ValuesAssignment_6_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5015:1: ( ( ruleValues ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5016:1: ( ruleValues )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5016:1: ( ruleValues )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5017:1: ruleValues
            {
             before(grammarAccess.getBuildEntryAccess().getValuesValuesParserRuleCall_6_3_1_0_0()); 
            pushFollow(FOLLOW_ruleValues_in_rule__BuildEntry__ValuesAssignment_6_3_1_010134);
            ruleValues();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getValuesValuesParserRuleCall_6_3_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__ValuesAssignment_6_3_1_0"


    // $ANTLR start "rule__BuildEntry__ValuesAssignment_6_3_1_1_2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5026:1: rule__BuildEntry__ValuesAssignment_6_3_1_1_2 : ( ruleValues ) ;
    public final void rule__BuildEntry__ValuesAssignment_6_3_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5030:1: ( ( ruleValues ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5031:1: ( ruleValues )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5031:1: ( ruleValues )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5032:1: ruleValues
            {
             before(grammarAccess.getBuildEntryAccess().getValuesValuesParserRuleCall_6_3_1_1_2_0()); 
            pushFollow(FOLLOW_ruleValues_in_rule__BuildEntry__ValuesAssignment_6_3_1_1_210165);
            ruleValues();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getValuesValuesParserRuleCall_6_3_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__ValuesAssignment_6_3_1_1_2"


    // $ANTLR start "rule__BuildEntry__NameAssignment_7_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5041:1: rule__BuildEntry__NameAssignment_7_1 : ( RULE_SYMBOL ) ;
    public final void rule__BuildEntry__NameAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5045:1: ( ( RULE_SYMBOL ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5046:1: ( RULE_SYMBOL )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5046:1: ( RULE_SYMBOL )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5047:1: RULE_SYMBOL
            {
             before(grammarAccess.getBuildEntryAccess().getNameSYMBOLTerminalRuleCall_7_1_0()); 
            match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_rule__BuildEntry__NameAssignment_7_110196); 
             after(grammarAccess.getBuildEntryAccess().getNameSYMBOLTerminalRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__NameAssignment_7_1"


    // $ANTLR start "rule__BuildEntry__VariableAssignment_7_2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5056:1: rule__BuildEntry__VariableAssignment_7_2 : ( ruleVariable ) ;
    public final void rule__BuildEntry__VariableAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5060:1: ( ( ruleVariable ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5061:1: ( ruleVariable )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5061:1: ( ruleVariable )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5062:1: ruleVariable
            {
             before(grammarAccess.getBuildEntryAccess().getVariableVariableParserRuleCall_7_2_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__BuildEntry__VariableAssignment_7_210227);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getVariableVariableParserRuleCall_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__VariableAssignment_7_2"


    // $ANTLR start "rule__BuildEntry__ValueAssignment_7_3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5071:1: rule__BuildEntry__ValueAssignment_7_3 : ( ruleAssign ) ;
    public final void rule__BuildEntry__ValueAssignment_7_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5075:1: ( ( ruleAssign ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5076:1: ( ruleAssign )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5076:1: ( ruleAssign )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5077:1: ruleAssign
            {
             before(grammarAccess.getBuildEntryAccess().getValueAssignParserRuleCall_7_3_0()); 
            pushFollow(FOLLOW_ruleAssign_in_rule__BuildEntry__ValueAssignment_7_310258);
            ruleAssign();

            state._fsp--;

             after(grammarAccess.getBuildEntryAccess().getValueAssignParserRuleCall_7_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BuildEntry__ValueAssignment_7_3"


    // $ANTLR start "rule__Entry__VariableAssignment_2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5086:1: rule__Entry__VariableAssignment_2 : ( ruleVariable ) ;
    public final void rule__Entry__VariableAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5090:1: ( ( ruleVariable ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5091:1: ( ruleVariable )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5091:1: ( ruleVariable )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5092:1: ruleVariable
            {
             before(grammarAccess.getEntryAccess().getVariableVariableParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__Entry__VariableAssignment_210289);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getEntryAccess().getVariableVariableParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__VariableAssignment_2"


    // $ANTLR start "rule__Entry__ValueAssignment_3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5101:1: rule__Entry__ValueAssignment_3 : ( ruleAssignExtra ) ;
    public final void rule__Entry__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5105:1: ( ( ruleAssignExtra ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5106:1: ( ruleAssignExtra )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5106:1: ( ruleAssignExtra )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5107:1: ruleAssignExtra
            {
             before(grammarAccess.getEntryAccess().getValueAssignExtraParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleAssignExtra_in_rule__Entry__ValueAssignment_310320);
            ruleAssignExtra();

            state._fsp--;

             after(grammarAccess.getEntryAccess().getValueAssignExtraParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__ValueAssignment_3"


    // $ANTLR start "rule__If__ShellAssignment_1_1_0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5116:1: rule__If__ShellAssignment_1_1_0 : ( ruleShellCmd ) ;
    public final void rule__If__ShellAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5120:1: ( ( ruleShellCmd ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5121:1: ( ruleShellCmd )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5121:1: ( ruleShellCmd )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5122:1: ruleShellCmd
            {
             before(grammarAccess.getIfAccess().getShellShellCmdParserRuleCall_1_1_0_0()); 
            pushFollow(FOLLOW_ruleShellCmd_in_rule__If__ShellAssignment_1_1_010351);
            ruleShellCmd();

            state._fsp--;

             after(grammarAccess.getIfAccess().getShellShellCmdParserRuleCall_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__ShellAssignment_1_1_0"


    // $ANTLR start "rule__If__ValueAssignment_5_0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5131:1: rule__If__ValueAssignment_5_0 : ( ruleObject_Y ) ;
    public final void rule__If__ValueAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5135:1: ( ( ruleObject_Y ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5136:1: ( ruleObject_Y )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5136:1: ( ruleObject_Y )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5137:1: ruleObject_Y
            {
             before(grammarAccess.getIfAccess().getValueObject_YParserRuleCall_5_0_0()); 
            pushFollow(FOLLOW_ruleObject_Y_in_rule__If__ValueAssignment_5_010382);
            ruleObject_Y();

            state._fsp--;

             after(grammarAccess.getIfAccess().getValueObject_YParserRuleCall_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__ValueAssignment_5_0"


    // $ANTLR start "rule__If__ValueAssignment_5_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5146:1: rule__If__ValueAssignment_5_1 : ( ruleObject_M ) ;
    public final void rule__If__ValueAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5150:1: ( ( ruleObject_M ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5151:1: ( ruleObject_M )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5151:1: ( ruleObject_M )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5152:1: ruleObject_M
            {
             before(grammarAccess.getIfAccess().getValueObject_MParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleObject_M_in_rule__If__ValueAssignment_5_110413);
            ruleObject_M();

            state._fsp--;

             after(grammarAccess.getIfAccess().getValueObject_MParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__ValueAssignment_5_1"


    // $ANTLR start "rule__If__ValueAssignment_5_2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5161:1: rule__If__ValueAssignment_5_2 : ( ruleEntry ) ;
    public final void rule__If__ValueAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5165:1: ( ( ruleEntry ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5166:1: ( ruleEntry )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5166:1: ( ruleEntry )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5167:1: ruleEntry
            {
             before(grammarAccess.getIfAccess().getValueEntryParserRuleCall_5_2_0()); 
            pushFollow(FOLLOW_ruleEntry_in_rule__If__ValueAssignment_5_210444);
            ruleEntry();

            state._fsp--;

             after(grammarAccess.getIfAccess().getValueEntryParserRuleCall_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__ValueAssignment_5_2"


    // $ANTLR start "rule__If__ValueAssignment_5_3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5176:1: rule__If__ValueAssignment_5_3 : ( ruleShellCmd ) ;
    public final void rule__If__ValueAssignment_5_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5180:1: ( ( ruleShellCmd ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5181:1: ( ruleShellCmd )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5181:1: ( ruleShellCmd )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5182:1: ruleShellCmd
            {
             before(grammarAccess.getIfAccess().getValueShellCmdParserRuleCall_5_3_0()); 
            pushFollow(FOLLOW_ruleShellCmd_in_rule__If__ValueAssignment_5_310475);
            ruleShellCmd();

            state._fsp--;

             after(grammarAccess.getIfAccess().getValueShellCmdParserRuleCall_5_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__ValueAssignment_5_3"


    // $ANTLR start "rule__If__ElsevalueAssignment_7_3_0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5191:1: rule__If__ElsevalueAssignment_7_3_0 : ( ruleObject_Y ) ;
    public final void rule__If__ElsevalueAssignment_7_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5195:1: ( ( ruleObject_Y ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5196:1: ( ruleObject_Y )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5196:1: ( ruleObject_Y )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5197:1: ruleObject_Y
            {
             before(grammarAccess.getIfAccess().getElsevalueObject_YParserRuleCall_7_3_0_0()); 
            pushFollow(FOLLOW_ruleObject_Y_in_rule__If__ElsevalueAssignment_7_3_010506);
            ruleObject_Y();

            state._fsp--;

             after(grammarAccess.getIfAccess().getElsevalueObject_YParserRuleCall_7_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__ElsevalueAssignment_7_3_0"


    // $ANTLR start "rule__If__ElsevalueAssignment_7_3_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5206:1: rule__If__ElsevalueAssignment_7_3_1 : ( ruleObject_M ) ;
    public final void rule__If__ElsevalueAssignment_7_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5210:1: ( ( ruleObject_M ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5211:1: ( ruleObject_M )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5211:1: ( ruleObject_M )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5212:1: ruleObject_M
            {
             before(grammarAccess.getIfAccess().getElsevalueObject_MParserRuleCall_7_3_1_0()); 
            pushFollow(FOLLOW_ruleObject_M_in_rule__If__ElsevalueAssignment_7_3_110537);
            ruleObject_M();

            state._fsp--;

             after(grammarAccess.getIfAccess().getElsevalueObject_MParserRuleCall_7_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__ElsevalueAssignment_7_3_1"


    // $ANTLR start "rule__Object_Y__ValueAssignment_2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5221:1: rule__Object_Y__ValueAssignment_2 : ( ruleAssignExtra ) ;
    public final void rule__Object_Y__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5225:1: ( ( ruleAssignExtra ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5226:1: ( ruleAssignExtra )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5226:1: ( ruleAssignExtra )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5227:1: ruleAssignExtra
            {
             before(grammarAccess.getObject_YAccess().getValueAssignExtraParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleAssignExtra_in_rule__Object_Y__ValueAssignment_210568);
            ruleAssignExtra();

            state._fsp--;

             after(grammarAccess.getObject_YAccess().getValueAssignExtraParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object_Y__ValueAssignment_2"


    // $ANTLR start "rule__Object_M__ValueAssignment_2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5236:1: rule__Object_M__ValueAssignment_2 : ( ruleAssignExtra ) ;
    public final void rule__Object_M__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5240:1: ( ( ruleAssignExtra ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5241:1: ( ruleAssignExtra )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5241:1: ( ruleAssignExtra )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5242:1: ruleAssignExtra
            {
             before(grammarAccess.getObject_MAccess().getValueAssignExtraParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleAssignExtra_in_rule__Object_M__ValueAssignment_210599);
            ruleAssignExtra();

            state._fsp--;

             after(grammarAccess.getObject_MAccess().getValueAssignExtraParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object_M__ValueAssignment_2"


    // $ANTLR start "rule__Values__ValuesAssignment_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5251:1: rule__Values__ValuesAssignment_1 : ( ruleValue ) ;
    public final void rule__Values__ValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5255:1: ( ( ruleValue ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5256:1: ( ruleValue )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5256:1: ( ruleValue )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5257:1: ruleValue
            {
             before(grammarAccess.getValuesAccess().getValuesValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__Values__ValuesAssignment_110630);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValuesAccess().getValuesValueParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__ValuesAssignment_1"


    // $ANTLR start "rule__Values__ValuesAssignment_2_3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5266:1: rule__Values__ValuesAssignment_2_3 : ( ruleValue ) ;
    public final void rule__Values__ValuesAssignment_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5270:1: ( ( ruleValue ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5271:1: ( ruleValue )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5271:1: ( ruleValue )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5272:1: ruleValue
            {
             before(grammarAccess.getValuesAccess().getValuesValueParserRuleCall_2_3_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__Values__ValuesAssignment_2_310661);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValuesAccess().getValuesValueParserRuleCall_2_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__ValuesAssignment_2_3"


    // $ANTLR start "rule__Value__NameAssignment_1_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5281:1: rule__Value__NameAssignment_1_1 : ( RULE_SYMBOL ) ;
    public final void rule__Value__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5285:1: ( ( RULE_SYMBOL ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5286:1: ( RULE_SYMBOL )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5286:1: ( RULE_SYMBOL )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5287:1: RULE_SYMBOL
            {
             before(grammarAccess.getValueAccess().getNameSYMBOLTerminalRuleCall_1_1_0()); 
            match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_rule__Value__NameAssignment_1_110692); 
             after(grammarAccess.getValueAccess().getNameSYMBOLTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__NameAssignment_1_1"


    // $ANTLR start "rule__Value__ValueAssignment_2_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5296:1: rule__Value__ValueAssignment_2_1 : ( ruleVariable ) ;
    public final void rule__Value__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5300:1: ( ( ruleVariable ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5301:1: ( ruleVariable )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5301:1: ( ruleVariable )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5302:1: ruleVariable
            {
             before(grammarAccess.getValueAccess().getValueVariableParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__Value__ValueAssignment_2_110723);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getValueAccess().getValueVariableParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__ValueAssignment_2_1"


    // $ANTLR start "rule__Value__AdditionalAssignment_2_2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5311:1: rule__Value__AdditionalAssignment_2_2 : ( RULE_SLASH ) ;
    public final void rule__Value__AdditionalAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5315:1: ( ( RULE_SLASH ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5316:1: ( RULE_SLASH )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5316:1: ( RULE_SLASH )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5317:1: RULE_SLASH
            {
             before(grammarAccess.getValueAccess().getAdditionalSLASHTerminalRuleCall_2_2_0()); 
            match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_rule__Value__AdditionalAssignment_2_210754); 
             after(grammarAccess.getValueAccess().getAdditionalSLASHTerminalRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__AdditionalAssignment_2_2"


    // $ANTLR start "rule__Value__ValueAssignment_3_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5326:1: rule__Value__ValueAssignment_3_1 : ( ruleShellCmd ) ;
    public final void rule__Value__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5330:1: ( ( ruleShellCmd ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5331:1: ( ruleShellCmd )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5331:1: ( ruleShellCmd )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5332:1: ruleShellCmd
            {
             before(grammarAccess.getValueAccess().getValueShellCmdParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleShellCmd_in_rule__Value__ValueAssignment_3_110785);
            ruleShellCmd();

            state._fsp--;

             after(grammarAccess.getValueAccess().getValueShellCmdParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__ValueAssignment_3_1"


    // $ANTLR start "rule__Value__ValueAssignment_5_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5341:1: rule__Value__ValueAssignment_5_1 : ( RULE_SHELL_CHAR ) ;
    public final void rule__Value__ValueAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5345:1: ( ( RULE_SHELL_CHAR ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5346:1: ( RULE_SHELL_CHAR )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5346:1: ( RULE_SHELL_CHAR )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5347:1: RULE_SHELL_CHAR
            {
             before(grammarAccess.getValueAccess().getValueSHELL_CHARTerminalRuleCall_5_1_0()); 
            match(input,RULE_SHELL_CHAR,FOLLOW_RULE_SHELL_CHAR_in_rule__Value__ValueAssignment_5_110816); 
             after(grammarAccess.getValueAccess().getValueSHELL_CHARTerminalRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__ValueAssignment_5_1"


    // $ANTLR start "rule__Variable__NameAssignment_0_2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5356:1: rule__Variable__NameAssignment_0_2 : ( RULE_SYMBOL ) ;
    public final void rule__Variable__NameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5360:1: ( ( RULE_SYMBOL ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5361:1: ( RULE_SYMBOL )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5361:1: ( RULE_SYMBOL )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5362:1: RULE_SYMBOL
            {
             before(grammarAccess.getVariableAccess().getNameSYMBOLTerminalRuleCall_0_2_0()); 
            match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_rule__Variable__NameAssignment_0_210847); 
             after(grammarAccess.getVariableAccess().getNameSYMBOLTerminalRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__NameAssignment_0_2"


    // $ANTLR start "rule__Variable__NameAssignment_1_2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5371:1: rule__Variable__NameAssignment_1_2 : ( RULE_SYMBOL ) ;
    public final void rule__Variable__NameAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5375:1: ( ( RULE_SYMBOL ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5376:1: ( RULE_SYMBOL )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5376:1: ( RULE_SYMBOL )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5377:1: RULE_SYMBOL
            {
             before(grammarAccess.getVariableAccess().getNameSYMBOLTerminalRuleCall_1_2_0()); 
            match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_rule__Variable__NameAssignment_1_210878); 
             after(grammarAccess.getVariableAccess().getNameSYMBOLTerminalRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__NameAssignment_1_2"


    // $ANTLR start "rule__ShellCmd__NameAssignment_0_1_2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5386:1: rule__ShellCmd__NameAssignment_0_1_2 : ( RULE_SYMBOL ) ;
    public final void rule__ShellCmd__NameAssignment_0_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5390:1: ( ( RULE_SYMBOL ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5391:1: ( RULE_SYMBOL )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5391:1: ( RULE_SYMBOL )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5392:1: RULE_SYMBOL
            {
             before(grammarAccess.getShellCmdAccess().getNameSYMBOLTerminalRuleCall_0_1_2_0()); 
            match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_rule__ShellCmd__NameAssignment_0_1_210909); 
             after(grammarAccess.getShellCmdAccess().getNameSYMBOLTerminalRuleCall_0_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__NameAssignment_0_1_2"


    // $ANTLR start "rule__ShellCmd__ShellPartAssignment_0_1_3"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5401:1: rule__ShellCmd__ShellPartAssignment_0_1_3 : ( ruleShellPart ) ;
    public final void rule__ShellCmd__ShellPartAssignment_0_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5405:1: ( ( ruleShellPart ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5406:1: ( ruleShellPart )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5406:1: ( ruleShellPart )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5407:1: ruleShellPart
            {
             before(grammarAccess.getShellCmdAccess().getShellPartShellPartParserRuleCall_0_1_3_0()); 
            pushFollow(FOLLOW_ruleShellPart_in_rule__ShellCmd__ShellPartAssignment_0_1_310940);
            ruleShellPart();

            state._fsp--;

             after(grammarAccess.getShellCmdAccess().getShellPartShellPartParserRuleCall_0_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellCmd__ShellPartAssignment_0_1_3"


    // $ANTLR start "rule__ShellPart__ValAssignment_1_0"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5416:1: rule__ShellPart__ValAssignment_1_0 : ( ruleVarSlashSym ) ;
    public final void rule__ShellPart__ValAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5420:1: ( ( ruleVarSlashSym ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5421:1: ( ruleVarSlashSym )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5421:1: ( ruleVarSlashSym )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5422:1: ruleVarSlashSym
            {
             before(grammarAccess.getShellPartAccess().getValVarSlashSymParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_ruleVarSlashSym_in_rule__ShellPart__ValAssignment_1_010971);
            ruleVarSlashSym();

            state._fsp--;

             after(grammarAccess.getShellPartAccess().getValVarSlashSymParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellPart__ValAssignment_1_0"


    // $ANTLR start "rule__ShellPart__CmdAssignment_1_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5431:1: rule__ShellPart__CmdAssignment_1_1 : ( ruleShellCmd ) ;
    public final void rule__ShellPart__CmdAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5435:1: ( ( ruleShellCmd ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5436:1: ( ruleShellCmd )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5436:1: ( ruleShellCmd )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5437:1: ruleShellCmd
            {
             before(grammarAccess.getShellPartAccess().getCmdShellCmdParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleShellCmd_in_rule__ShellPart__CmdAssignment_1_111002);
            ruleShellCmd();

            state._fsp--;

             after(grammarAccess.getShellPartAccess().getCmdShellCmdParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShellPart__CmdAssignment_1_1"


    // $ANTLR start "rule__VarSlashSym__NameAssignment_1"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5446:1: rule__VarSlashSym__NameAssignment_1 : ( RULE_SLASH ) ;
    public final void rule__VarSlashSym__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5450:1: ( ( RULE_SLASH ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5451:1: ( RULE_SLASH )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5451:1: ( RULE_SLASH )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5452:1: RULE_SLASH
            {
             before(grammarAccess.getVarSlashSymAccess().getNameSLASHTerminalRuleCall_1_0()); 
            match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_rule__VarSlashSym__NameAssignment_111033); 
             after(grammarAccess.getVarSlashSymAccess().getNameSLASHTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarSlashSym__NameAssignment_1"


    // $ANTLR start "rule__VarSlashSym__NameAssignment_2"
    // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5461:1: rule__VarSlashSym__NameAssignment_2 : ( RULE_SYMBOL ) ;
    public final void rule__VarSlashSym__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5465:1: ( ( RULE_SYMBOL ) )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5466:1: ( RULE_SYMBOL )
            {
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5466:1: ( RULE_SYMBOL )
            // ../at.jku.isse.ecco.kefax.kbuild.ui/src-gen/at/jku/isse/ecco/kefax/kbuild/ui/contentassist/antlr/internal/InternalKbuild.g:5467:1: RULE_SYMBOL
            {
             before(grammarAccess.getVarSlashSymAccess().getNameSYMBOLTerminalRuleCall_2_0()); 
            match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_rule__VarSlashSym__NameAssignment_211064); 
             after(grammarAccess.getVarSlashSymAccess().getNameSYMBOLTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarSlashSym__NameAssignment_2"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA2_eotS =
        "\20\uffff";
    static final String DFA2_eofS =
        "\20\uffff";
    static final String DFA2_minS =
        "\1\12\4\uffff\1\10\2\uffff\1\23\2\uffff\1\5\1\32\1\10\1\12\1\10";
    static final String DFA2_maxS =
        "\1\36\4\uffff\1\36\2\uffff\1\32\2\uffff\1\36\1\32\3\36";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\6\1\7\1\uffff\1\10\1\5\5\uffff";
    static final String DFA2_specialS =
        "\20\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\7\1\uffff\1\7\1\2\1\3\1\4\2\uffff\1\1\3\uffff\2\6\1\uffff\1\7\1\5\2\uffff\2\7",
            "",
            "",
            "",
            "",
            "\1\12\1\13\1\7\1\uffff\1\7\4\uffff\1\12\6\uffff\1\11\4\7\1\10\1\7",
            "",
            "",
            "\1\14\6\uffff\1\15",
            "",
            "",
            "\1\7\4\uffff\1\7\1\uffff\1\7\13\uffff\1\12\2\7\2\uffff\2\7",
            "\1\16",
            "\1\12\1\13\1\7\1\uffff\1\7\4\uffff\1\12\6\uffff\1\11\2\7\1\uffff\3\7",
            "\3\7\7\uffff\1\17\4\uffff\2\7\1\uffff\3\7",
            "\1\12\1\13\1\7\1\uffff\1\7\4\uffff\1\12\6\uffff\1\11\2\7\1\uffff\3\7"
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "487:1: rule__BuildEntry__Alternatives : ( ( ( rule__BuildEntry__Group_0__0 ) ) | ( ( rule__BuildEntry__Group_1__0 ) ) | ( ( rule__BuildEntry__Group_2__0 ) ) | ( ( rule__BuildEntry__Group_3__0 ) ) | ( ( rule__BuildEntry__Group_4__0 ) ) | ( ( rule__BuildEntry__Group_5__0 ) ) | ( ( rule__BuildEntry__Group_6__0 ) ) | ( ( rule__BuildEntry__Group_7__0 ) ) );";
        }
    }
    static final String DFA11_eotS =
        "\14\uffff";
    static final String DFA11_eofS =
        "\1\uffff\1\6\12\uffff";
    static final String DFA11_minS =
        "\1\12\1\4\1\23\7\uffff\1\32\1\12";
    static final String DFA11_maxS =
        "\2\36\1\32\7\uffff\1\32\1\36";
    static final String DFA11_acceptS =
        "\3\uffff\1\4\1\5\1\6\1\2\1\1\1\7\1\3\2\uffff";
    static final String DFA11_specialS =
        "\14\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\4\1\uffff\1\5\15\uffff\1\1\2\uffff\1\2\1\3",
            "\1\6\4\uffff\2\6\1\uffff\1\6\13\uffff\3\6\1\7\1\10\2\6",
            "\1\12\6\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\13",
            "\3\3\7\uffff\1\11\4\uffff\2\3\1\uffff\3\3"
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "733:1: rule__Value__Alternatives : ( ( ( rule__Value__Group_0__0 ) ) | ( ( rule__Value__Group_1__0 ) ) | ( ( rule__Value__Group_2__0 ) ) | ( ( rule__Value__Group_3__0 ) ) | ( ( rule__Value__Group_4__0 ) ) | ( ( rule__Value__Group_5__0 ) ) | ( ( rule__Value__Group_6__0 ) ) );";
        }
    }
    static final String DFA14_eotS =
        "\12\uffff";
    static final String DFA14_eofS =
        "\12\uffff";
    static final String DFA14_minS =
        "\1\12\1\23\6\uffff\1\32\1\12";
    static final String DFA14_maxS =
        "\1\36\1\32\6\uffff\1\32\1\36";
    static final String DFA14_acceptS =
        "\2\uffff\1\1\1\2\1\3\1\4\1\5\1\6\2\uffff";
    static final String DFA14_specialS =
        "\12\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\4\1\5\1\6\14\uffff\1\7\1\2\1\uffff\1\2\1\1\1\3",
            "\1\10\6\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\11",
            "\3\3\7\uffff\1\2\4\uffff\2\3\1\uffff\3\3"
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "829:1: rule__ShellPart__Alternatives_1 : ( ( ( rule__ShellPart__ValAssignment_1_0 ) ) | ( ( rule__ShellPart__CmdAssignment_1_1 ) ) | ( RULE_STRING ) | ( RULE_COMMA ) | ( RULE_SHELL_CHAR ) | ( ( rule__ShellPart__Group_1_5__0 ) ) );";
        }
    }
    static final String DFA17_eotS =
        "\5\uffff";
    static final String DFA17_eofS =
        "\1\uffff\2\3\2\uffff";
    static final String DFA17_minS =
        "\3\4\2\uffff";
    static final String DFA17_maxS =
        "\1\4\2\36\2\uffff";
    static final String DFA17_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA17_specialS =
        "\5\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\1",
            "\1\2\5\uffff\1\4\1\uffff\4\4\2\uffff\1\4\3\uffff\2\4\1\uffff\2\4\2\uffff\2\4",
            "\1\2\5\uffff\1\4\1\uffff\4\4\2\uffff\1\4\3\uffff\2\4\1\uffff\2\4\2\uffff\2\4",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "()* loopback of 984:1: ( rule__Model__Group_2__0 )*";
        }
    }
    static final String DFA20_eotS =
        "\5\uffff";
    static final String DFA20_eofS =
        "\1\1\1\uffff\2\1\1\uffff";
    static final String DFA20_minS =
        "\1\4\1\uffff\2\4\1\uffff";
    static final String DFA20_maxS =
        "\1\4\1\uffff\2\36\1\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\2\2\uffff\1\1";
    static final String DFA20_specialS =
        "\5\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\2",
            "",
            "\1\3\5\uffff\1\1\1\uffff\4\1\1\uffff\1\4\1\1\3\uffff\2\1\1\uffff\2\1\2\uffff\2\1",
            "\1\3\5\uffff\1\1\1\uffff\4\1\1\uffff\1\4\1\1\3\uffff\2\1\1\uffff\2\1\2\uffff\2\1",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "()* loopback of 1951:1: ( rule__BuildEntry__Group_6_3_1_1__0 )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuildEntry_in_entryRuleBuildEntry121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBuildEntry128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Alternatives_in_ruleBuildEntry154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntry_in_entryRuleEntry181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntry188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entry__Group__0_in_ruleEntry214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIf_in_entryRuleIf241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIf248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group__0_in_ruleIf274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObject_Y_in_entryRuleObject_Y301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObject_Y308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Object_Y__Group__0_in_ruleObject_Y334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObject_M_in_entryRuleObject_M361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObject_M368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Object_M__Group__0_in_ruleObject_M394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssign_in_entryRuleAssign421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssign428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Assign__Group__0_in_ruleAssign454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignExtra_in_entryRuleAssignExtra481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignExtra488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignExtra__Group__0_in_ruleAssignExtra514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValues_in_entryRuleValues541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValues548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Values__Group__0_in_ruleValues574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Alternatives_in_ruleValue634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Alternatives_in_ruleVariable694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShellCmd_in_entryRuleShellCmd721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShellCmd728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellCmd__Alternatives_in_ruleShellCmd754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShellPart_in_entryRuleShellPart781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShellPart788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellPart__Group__0_in_ruleShellPart814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarSlashSym_in_entryRuleVarSlashSym841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarSlashSym848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarSlashSym__Alternatives_in_ruleVarSlashSym874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_entryRuleEol901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEol908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NLI_in_ruleEol937 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NLI_in_ruleEol950 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_0__0_in_rule__BuildEntry__Alternatives989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_1__0_in_rule__BuildEntry__Alternatives1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_2__0_in_rule__BuildEntry__Alternatives1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_3__0_in_rule__BuildEntry__Alternatives1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_4__0_in_rule__BuildEntry__Alternatives1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_5__0_in_rule__BuildEntry__Alternatives1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6__0_in_rule__BuildEntry__Alternatives1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_7__0_in_rule__BuildEntry__Alternatives1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__ValueAssignment_3_4_0_in_rule__BuildEntry__Alternatives_3_41148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__ValueAssignment_3_4_1_in_rule__BuildEntry__Alternatives_3_41166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__ValueAssignment_5_1_0_in_rule__BuildEntry__Alternatives_5_11199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__ValueAssignment_5_1_1_in_rule__BuildEntry__Alternatives_5_11217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SEMICOLON_in_rule__BuildEntry__Alternatives_6_31250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6_3_1__0_in_rule__BuildEntry__Alternatives_6_31267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group_1_0__0_in_rule__If__Alternatives_11300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group_1_1__0_in_rule__If__Alternatives_11318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_Y_in_rule__If__Alternatives_1_0_21351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_M_in_rule__If__Alternatives_1_0_21368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__ValueAssignment_5_0_in_rule__If__Alternatives_51400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__ValueAssignment_5_1_in_rule__If__Alternatives_51418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__ValueAssignment_5_2_in_rule__If__Alternatives_51436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__ValueAssignment_5_3_in_rule__If__Alternatives_51454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__ElsevalueAssignment_7_3_0_in_rule__If__Alternatives_7_31487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__ElsevalueAssignment_7_3_1_in_rule__If__Alternatives_7_31505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PLUS_in_rule__AssignExtra__Alternatives_11538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DPOINT_in_rule__AssignExtra__Alternatives_11555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_0__0_in_rule__Value__Alternatives1587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_1__0_in_rule__Value__Alternatives1605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_2__0_in_rule__Value__Alternatives1623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_3__0_in_rule__Value__Alternatives1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_4__0_in_rule__Value__Alternatives1659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_5__0_in_rule__Value__Alternatives1677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_6__0_in_rule__Value__Alternatives1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_0__0_in_rule__Variable__Alternatives1728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_1__0_in_rule__Variable__Alternatives1746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_0__0_in_rule__ShellCmd__Alternatives1779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_1__0_in_rule__ShellCmd__Alternatives1797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellPart__ValAssignment_1_0_in_rule__ShellPart__Alternatives_11830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellPart__CmdAssignment_1_1_in_rule__ShellPart__Alternatives_11848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ShellPart__Alternatives_11866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COMMA_in_rule__ShellPart__Alternatives_11883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SHELL_CHAR_in_rule__ShellPart__Alternatives_11900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellPart__Group_1_5__0_in_rule__ShellPart__Alternatives_11917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__VarSlashSym__Alternatives1950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarSlashSym__NameAssignment_1_in_rule__VarSlashSym__Alternatives1967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarSlashSym__NameAssignment_2_in_rule__VarSlashSym__Alternatives1985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__02016 = new BitSet(new long[]{0x0000000066C4F410L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__12077 = new BitSet(new long[]{0x0000000066C4F410L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__12080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__BuildEntryAssignment_1_in_rule__Model__Group__1__Impl2107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__22138 = new BitSet(new long[]{0x0000000066C4F410L});
    public static final BitSet FOLLOW_rule__Model__Group__3_in_rule__Model__Group__22141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_2__0_in_rule__Model__Group__2__Impl2168 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__32199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_rule__Model__Group__3__Impl2226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_2__0__Impl_in_rule__Model__Group_2__02263 = new BitSet(new long[]{0x0000000066C4F400L});
    public static final BitSet FOLLOW_rule__Model__Group_2__1_in_rule__Model__Group_2__02266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_rule__Model__Group_2__0__Impl2293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_2__1__Impl_in_rule__Model__Group_2__12322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__BuildEntryAssignment_2_1_in_rule__Model__Group_2__1__Impl2349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_0__0__Impl_in_rule__BuildEntry__Group_0__02383 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_0__1_in_rule__BuildEntry__Group_0__02386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_0__1__Impl_in_rule__BuildEntry__Group_0__12444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__ValueAssignment_0_1_in_rule__BuildEntry__Group_0__1__Impl2471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_1__0__Impl_in_rule__BuildEntry__Group_1__02505 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_1__1_in_rule__BuildEntry__Group_1__02508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_1__1__Impl_in_rule__BuildEntry__Group_1__12566 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_1__2_in_rule__BuildEntry__Group_1__12569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IFEQ_in_rule__BuildEntry__Group_1__1__Impl2596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_1__2__Impl_in_rule__BuildEntry__Group_1__22625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__ValueAssignment_1_2_in_rule__BuildEntry__Group_1__2__Impl2652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_2__0__Impl_in_rule__BuildEntry__Group_2__02688 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_2__1_in_rule__BuildEntry__Group_2__02691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_2__1__Impl_in_rule__BuildEntry__Group_2__12749 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_2__2_in_rule__BuildEntry__Group_2__12752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IFNEQ_in_rule__BuildEntry__Group_2__1__Impl2779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_2__2__Impl_in_rule__BuildEntry__Group_2__22808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__ValueAssignment_2_2_in_rule__BuildEntry__Group_2__2__Impl2835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_3__0__Impl_in_rule__BuildEntry__Group_3__02871 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_3__1_in_rule__BuildEntry__Group_3__02874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_3__1__Impl_in_rule__BuildEntry__Group_3__12932 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_3__2_in_rule__BuildEntry__Group_3__12935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IFNDEF_in_rule__BuildEntry__Group_3__1__Impl2962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_3__2__Impl_in_rule__BuildEntry__Group_3__22991 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_3__3_in_rule__BuildEntry__Group_3__22994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__NameAssignment_3_2_in_rule__BuildEntry__Group_3__2__Impl3021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_3__3__Impl_in_rule__BuildEntry__Group_3__33051 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_3__4_in_rule__BuildEntry__Group_3__33054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_rule__BuildEntry__Group_3__3__Impl3081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_3__4__Impl_in_rule__BuildEntry__Group_3__43110 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_3__5_in_rule__BuildEntry__Group_3__43113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Alternatives_3_4_in_rule__BuildEntry__Group_3__4__Impl3140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_3__5__Impl_in_rule__BuildEntry__Group_3__53170 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_3__6_in_rule__BuildEntry__Group_3__53173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_rule__BuildEntry__Group_3__5__Impl3200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_3__6__Impl_in_rule__BuildEntry__Group_3__63229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ENDIF_in_rule__BuildEntry__Group_3__6__Impl3256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_4__0__Impl_in_rule__BuildEntry__Group_4__03299 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_4__1_in_rule__BuildEntry__Group_4__03302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_4__1__Impl_in_rule__BuildEntry__Group_4__13360 = new BitSet(new long[]{0x0000000020020300L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_4__2_in_rule__BuildEntry__Group_4__13363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__NameAssignment_4_1_in_rule__BuildEntry__Group_4__1__Impl3390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_4__2__Impl_in_rule__BuildEntry__Group_4__23420 = new BitSet(new long[]{0x0000000020020300L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_4__3_in_rule__BuildEntry__Group_4__23423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__VariableAssignment_4_2_in_rule__BuildEntry__Group_4__2__Impl3450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_4__3__Impl_in_rule__BuildEntry__Group_4__33481 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_4__4_in_rule__BuildEntry__Group_4__33484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__ValueAssignment_4_3_in_rule__BuildEntry__Group_4__3__Impl3511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_4__4__Impl_in_rule__BuildEntry__Group_4__43541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__InnerAssignment_4_4_in_rule__BuildEntry__Group_4__4__Impl3568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_5__0__Impl_in_rule__BuildEntry__Group_5__03609 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_5__1_in_rule__BuildEntry__Group_5__03612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_5__1__Impl_in_rule__BuildEntry__Group_5__13670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Alternatives_5_1_in_rule__BuildEntry__Group_5__1__Impl3697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6__0__Impl_in_rule__BuildEntry__Group_6__03731 = new BitSet(new long[]{0x0000000066001400L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6__1_in_rule__BuildEntry__Group_6__03734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6__1__Impl_in_rule__BuildEntry__Group_6__13792 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6__2_in_rule__BuildEntry__Group_6__13795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__TargetAssignment_6_1_in_rule__BuildEntry__Group_6__1__Impl3822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6__2__Impl_in_rule__BuildEntry__Group_6__23852 = new BitSet(new long[]{0x0000000066001420L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6__3_in_rule__BuildEntry__Group_6__23855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DPOINT_in_rule__BuildEntry__Group_6__2__Impl3882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6__3__Impl_in_rule__BuildEntry__Group_6__33911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Alternatives_6_3_in_rule__BuildEntry__Group_6__3__Impl3938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6_3_1__0__Impl_in_rule__BuildEntry__Group_6_3_1__03976 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6_3_1__1_in_rule__BuildEntry__Group_6_3_1__03979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__ValuesAssignment_6_3_1_0_in_rule__BuildEntry__Group_6_3_1__0__Impl4006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6_3_1__1__Impl_in_rule__BuildEntry__Group_6_3_1__14036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6_3_1_1__0_in_rule__BuildEntry__Group_6_3_1__1__Impl4063 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6_3_1_1__0__Impl_in_rule__BuildEntry__Group_6_3_1_1__04098 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6_3_1_1__1_in_rule__BuildEntry__Group_6_3_1_1__04101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_rule__BuildEntry__Group_6_3_1_1__0__Impl4128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6_3_1_1__1__Impl_in_rule__BuildEntry__Group_6_3_1_1__14157 = new BitSet(new long[]{0x0000000066001400L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6_3_1_1__2_in_rule__BuildEntry__Group_6_3_1_1__14160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TAB_in_rule__BuildEntry__Group_6_3_1_1__1__Impl4190 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_RULE_TAB_in_rule__BuildEntry__Group_6_3_1_1__1__Impl4203 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_6_3_1_1__2__Impl_in_rule__BuildEntry__Group_6_3_1_1__24236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__ValuesAssignment_6_3_1_1_2_in_rule__BuildEntry__Group_6_3_1_1__2__Impl4263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_7__0__Impl_in_rule__BuildEntry__Group_7__04299 = new BitSet(new long[]{0x0000000066C4F400L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_7__1_in_rule__BuildEntry__Group_7__04302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_7__1__Impl_in_rule__BuildEntry__Group_7__14360 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_7__2_in_rule__BuildEntry__Group_7__14363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__NameAssignment_7_1_in_rule__BuildEntry__Group_7__1__Impl4390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_7__2__Impl_in_rule__BuildEntry__Group_7__24420 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_7__3_in_rule__BuildEntry__Group_7__24423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__VariableAssignment_7_2_in_rule__BuildEntry__Group_7__2__Impl4450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__Group_7__3__Impl_in_rule__BuildEntry__Group_7__34481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuildEntry__ValueAssignment_7_3_in_rule__BuildEntry__Group_7__3__Impl4508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entry__Group__0__Impl_in_rule__Entry__Group__04546 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Entry__Group__1_in_rule__Entry__Group__04549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entry__Group__1__Impl_in_rule__Entry__Group__14607 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Entry__Group__2_in_rule__Entry__Group__14610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OBJ_START_in_rule__Entry__Group__1__Impl4637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entry__Group__2__Impl_in_rule__Entry__Group__24666 = new BitSet(new long[]{0x0000000020020300L});
    public static final BitSet FOLLOW_rule__Entry__Group__3_in_rule__Entry__Group__24669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entry__VariableAssignment_2_in_rule__Entry__Group__2__Impl4696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entry__Group__3__Impl_in_rule__Entry__Group__34726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entry__ValueAssignment_3_in_rule__Entry__Group__3__Impl4753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group__0__Impl_in_rule__If__Group__04791 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_rule__If__Group__1_in_rule__If__Group__04794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BRACE_START_in_rule__If__Group__0__Impl4821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group__1__Impl_in_rule__If__Group__14850 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__If__Group__2_in_rule__If__Group__14853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Alternatives_1_in_rule__If__Group__1__Impl4880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group__2__Impl_in_rule__If__Group__24910 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__If__Group__3_in_rule__If__Group__24913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BRACE_END_in_rule__If__Group__2__Impl4940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group__3__Impl_in_rule__If__Group__34969 = new BitSet(new long[]{0x0000000060C60000L});
    public static final BitSet FOLLOW_rule__If__Group__4_in_rule__If__Group__34972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_rule__If__Group__3__Impl4999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group__4__Impl_in_rule__If__Group__45028 = new BitSet(new long[]{0x0000000060C60000L});
    public static final BitSet FOLLOW_rule__If__Group__5_in_rule__If__Group__45031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TAB_in_rule__If__Group__4__Impl5059 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__If__Group__5__Impl_in_rule__If__Group__55090 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__If__Group__6_in_rule__If__Group__55093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Alternatives_5_in_rule__If__Group__5__Impl5120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group__6__Impl_in_rule__If__Group__65150 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_rule__If__Group__7_in_rule__If__Group__65153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_rule__If__Group__6__Impl5180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group__7__Impl_in_rule__If__Group__75209 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_rule__If__Group__8_in_rule__If__Group__75212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group_7__0_in_rule__If__Group__7__Impl5239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group__8__Impl_in_rule__If__Group__85270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ENDIF_in_rule__If__Group__8__Impl5297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group_1_0__0__Impl_in_rule__If__Group_1_0__05344 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__If__Group_1_0__1_in_rule__If__Group_1_0__05347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__If__Group_1_0__0__Impl5374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group_1_0__1__Impl_in_rule__If__Group_1_0__15403 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_rule__If__Group_1_0__2_in_rule__If__Group_1_0__15406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COMMA_in_rule__If__Group_1_0__1__Impl5433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group_1_0__2__Impl_in_rule__If__Group_1_0__25462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Alternatives_1_0_2_in_rule__If__Group_1_0__2__Impl5489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group_1_1__0__Impl_in_rule__If__Group_1_1__05525 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__If__Group_1_1__1_in_rule__If__Group_1_1__05528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__ShellAssignment_1_1_0_in_rule__If__Group_1_1__0__Impl5555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group_1_1__1__Impl_in_rule__If__Group_1_1__15585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COMMA_in_rule__If__Group_1_1__1__Impl5613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group_7__0__Impl_in_rule__If__Group_7__05648 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__If__Group_7__1_in_rule__If__Group_7__05651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ELSE_in_rule__If__Group_7__0__Impl5678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group_7__1__Impl_in_rule__If__Group_7__15707 = new BitSet(new long[]{0x0000000000C20000L});
    public static final BitSet FOLLOW_rule__If__Group_7__2_in_rule__If__Group_7__15710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_rule__If__Group_7__1__Impl5737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group_7__2__Impl_in_rule__If__Group_7__25766 = new BitSet(new long[]{0x0000000000C20000L});
    public static final BitSet FOLLOW_rule__If__Group_7__3_in_rule__If__Group_7__25769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TAB_in_rule__If__Group_7__2__Impl5797 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__If__Group_7__3__Impl_in_rule__If__Group_7__35828 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__If__Group_7__4_in_rule__If__Group_7__35831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Alternatives_7_3_in_rule__If__Group_7__3__Impl5858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__If__Group_7__4__Impl_in_rule__If__Group_7__45888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_rule__If__Group_7__4__Impl5915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Object_Y__Group__0__Impl_in_rule__Object_Y__Group__05954 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Object_Y__Group__1_in_rule__Object_Y__Group__05957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Object_Y__Group__1__Impl_in_rule__Object_Y__Group__16015 = new BitSet(new long[]{0x0000000020020300L});
    public static final BitSet FOLLOW_rule__Object_Y__Group__2_in_rule__Object_Y__Group__16018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OBJ_Y_in_rule__Object_Y__Group__1__Impl6045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Object_Y__Group__2__Impl_in_rule__Object_Y__Group__26074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Object_Y__ValueAssignment_2_in_rule__Object_Y__Group__2__Impl6101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Object_M__Group__0__Impl_in_rule__Object_M__Group__06137 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_rule__Object_M__Group__1_in_rule__Object_M__Group__06140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Object_M__Group__1__Impl_in_rule__Object_M__Group__16198 = new BitSet(new long[]{0x0000000020020300L});
    public static final BitSet FOLLOW_rule__Object_M__Group__2_in_rule__Object_M__Group__16201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OBJ_M_in_rule__Object_M__Group__1__Impl6228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Object_M__Group__2__Impl_in_rule__Object_M__Group__26257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Object_M__ValueAssignment_2_in_rule__Object_M__Group__2__Impl6284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Assign__Group__0__Impl_in_rule__Assign__Group__06320 = new BitSet(new long[]{0x0000000066021400L});
    public static final BitSet FOLLOW_rule__Assign__Group__1_in_rule__Assign__Group__06323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EQ_in_rule__Assign__Group__0__Impl6350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Assign__Group__1__Impl_in_rule__Assign__Group__16379 = new BitSet(new long[]{0x0000000066021400L});
    public static final BitSet FOLLOW_rule__Assign__Group__2_in_rule__Assign__Group__16382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TAB_in_rule__Assign__Group__1__Impl6410 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__Assign__Group__2__Impl_in_rule__Assign__Group__26441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValues_in_rule__Assign__Group__2__Impl6468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignExtra__Group__0__Impl_in_rule__AssignExtra__Group__06503 = new BitSet(new long[]{0x0000000020020300L});
    public static final BitSet FOLLOW_rule__AssignExtra__Group__1_in_rule__AssignExtra__Group__06506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TAB_in_rule__AssignExtra__Group__0__Impl6534 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__AssignExtra__Group__1__Impl_in_rule__AssignExtra__Group__16565 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__AssignExtra__Group__2_in_rule__AssignExtra__Group__16568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignExtra__Alternatives_1_in_rule__AssignExtra__Group__1__Impl6595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignExtra__Group__2__Impl_in_rule__AssignExtra__Group__26625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssign_in_rule__AssignExtra__Group__2__Impl6652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Values__Group__0__Impl_in_rule__Values__Group__06687 = new BitSet(new long[]{0x0000000066001400L});
    public static final BitSet FOLLOW_rule__Values__Group__1_in_rule__Values__Group__06690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Values__Group_0__0_in_rule__Values__Group__0__Impl6717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Values__Group__1__Impl_in_rule__Values__Group__16748 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__Values__Group__2_in_rule__Values__Group__16751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Values__ValuesAssignment_1_in_rule__Values__Group__1__Impl6780 = new BitSet(new long[]{0x0000000066001402L});
    public static final BitSet FOLLOW_rule__Values__ValuesAssignment_1_in_rule__Values__Group__1__Impl6792 = new BitSet(new long[]{0x0000000066001402L});
    public static final BitSet FOLLOW_rule__Values__Group__2__Impl_in_rule__Values__Group__26825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Values__Group_2__0_in_rule__Values__Group__2__Impl6852 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__Values__Group_0__0__Impl_in_rule__Values__Group_0__06889 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Values__Group_0__1_in_rule__Values__Group_0__06892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BACKSLASH_in_rule__Values__Group_0__0__Impl6919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Values__Group_0__1__Impl_in_rule__Values__Group_0__16948 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Values__Group_0__2_in_rule__Values__Group_0__16951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_rule__Values__Group_0__1__Impl6978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Values__Group_0__2__Impl_in_rule__Values__Group_0__27007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TAB_in_rule__Values__Group_0__2__Impl7035 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__Values__Group_2__0__Impl_in_rule__Values__Group_2__07072 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Values__Group_2__1_in_rule__Values__Group_2__07075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BACKSLASH_in_rule__Values__Group_2__0__Impl7102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Values__Group_2__1__Impl_in_rule__Values__Group_2__17131 = new BitSet(new long[]{0x0000000066021400L});
    public static final BitSet FOLLOW_rule__Values__Group_2__2_in_rule__Values__Group_2__17134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_rule__Values__Group_2__1__Impl7161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Values__Group_2__2__Impl_in_rule__Values__Group_2__27190 = new BitSet(new long[]{0x0000000066021400L});
    public static final BitSet FOLLOW_rule__Values__Group_2__3_in_rule__Values__Group_2__27193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TAB_in_rule__Values__Group_2__2__Impl7221 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__Values__Group_2__3__Impl_in_rule__Values__Group_2__37252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Values__ValuesAssignment_2_3_in_rule__Values__Group_2__3__Impl7281 = new BitSet(new long[]{0x0000000066021402L});
    public static final BitSet FOLLOW_rule__Values__ValuesAssignment_2_3_in_rule__Values__Group_2__3__Impl7293 = new BitSet(new long[]{0x0000000066021402L});
    public static final BitSet FOLLOW_rule__Value__Group_0__0__Impl_in_rule__Value__Group_0__07334 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Value__Group_0__1_in_rule__Value__Group_0__07337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_0__1__Impl_in_rule__Value__Group_0__17395 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Value__Group_0__2_in_rule__Value__Group_0__17398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_rule__Value__Group_0__1__Impl7425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_0__2__Impl_in_rule__Value__Group_0__27454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OBJ_FILE_in_rule__Value__Group_0__2__Impl7481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_1__0__Impl_in_rule__Value__Group_1__07516 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Value__Group_1__1_in_rule__Value__Group_1__07519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_1__1__Impl_in_rule__Value__Group_1__17577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__NameAssignment_1_1_in_rule__Value__Group_1__1__Impl7604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_2__0__Impl_in_rule__Value__Group_2__07638 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Value__Group_2__1_in_rule__Value__Group_2__07641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_2__1__Impl_in_rule__Value__Group_2__17699 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Value__Group_2__2_in_rule__Value__Group_2__17702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__ValueAssignment_2_1_in_rule__Value__Group_2__1__Impl7729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_2__2__Impl_in_rule__Value__Group_2__27759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__AdditionalAssignment_2_2_in_rule__Value__Group_2__2__Impl7786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_3__0__Impl_in_rule__Value__Group_3__07823 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_rule__Value__Group_3__1_in_rule__Value__Group_3__07826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_3__1__Impl_in_rule__Value__Group_3__17884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__ValueAssignment_3_1_in_rule__Value__Group_3__1__Impl7911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_4__0__Impl_in_rule__Value__Group_4__07945 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__Value__Group_4__1_in_rule__Value__Group_4__07948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_4__1__Impl_in_rule__Value__Group_4__18006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Value__Group_4__1__Impl8033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_5__0__Impl_in_rule__Value__Group_5__08066 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Value__Group_5__1_in_rule__Value__Group_5__08069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_5__1__Impl_in_rule__Value__Group_5__18127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__ValueAssignment_5_1_in_rule__Value__Group_5__1__Impl8154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_6__0__Impl_in_rule__Value__Group_6__08188 = new BitSet(new long[]{0x0000000066001400L});
    public static final BitSet FOLLOW_rule__Value__Group_6__1_in_rule__Value__Group_6__08191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_6__1__Impl_in_rule__Value__Group_6__18249 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Value__Group_6__2_in_rule__Value__Group_6__18252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_rule__Value__Group_6__1__Impl8279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_6__2__Impl_in_rule__Value__Group_6__28308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_rule__Value__Group_6__2__Impl8335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_0__0__Impl_in_rule__Variable__Group_0__08370 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Variable__Group_0__1_in_rule__Variable__Group_0__08373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_0__1__Impl_in_rule__Variable__Group_0__18431 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Variable__Group_0__2_in_rule__Variable__Group_0__18434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOLLAR_in_rule__Variable__Group_0__1__Impl8461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_0__2__Impl_in_rule__Variable__Group_0__28490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__NameAssignment_0_2_in_rule__Variable__Group_0__2__Impl8517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_1__0__Impl_in_rule__Variable__Group_1__08553 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Variable__Group_1__1_in_rule__Variable__Group_1__08556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOLLAR_in_rule__Variable__Group_1__0__Impl8583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_1__1__Impl_in_rule__Variable__Group_1__18612 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Variable__Group_1__2_in_rule__Variable__Group_1__18615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BRACE_START_in_rule__Variable__Group_1__1__Impl8642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_1__2__Impl_in_rule__Variable__Group_1__28671 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Variable__Group_1__3_in_rule__Variable__Group_1__28674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__NameAssignment_1_2_in_rule__Variable__Group_1__2__Impl8701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_1__3__Impl_in_rule__Variable__Group_1__38731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BRACE_END_in_rule__Variable__Group_1__3__Impl8758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_0__0__Impl_in_rule__ShellCmd__Group_0__08795 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_0__1_in_rule__ShellCmd__Group_0__08798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_0__1__Impl_in_rule__ShellCmd__Group_0__18856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_0_1__0_in_rule__ShellCmd__Group_0__1__Impl8883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_0_1__0__Impl_in_rule__ShellCmd__Group_0_1__08917 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_0_1__1_in_rule__ShellCmd__Group_0_1__08920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOLLAR_in_rule__ShellCmd__Group_0_1__0__Impl8947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_0_1__1__Impl_in_rule__ShellCmd__Group_0_1__18976 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_0_1__2_in_rule__ShellCmd__Group_0_1__18979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BRACE_START_in_rule__ShellCmd__Group_0_1__1__Impl9006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_0_1__2__Impl_in_rule__ShellCmd__Group_0_1__29035 = new BitSet(new long[]{0x0000000076001C00L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_0_1__3_in_rule__ShellCmd__Group_0_1__29038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellCmd__NameAssignment_0_1_2_in_rule__ShellCmd__Group_0_1__2__Impl9065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_0_1__3__Impl_in_rule__ShellCmd__Group_0_1__39095 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_0_1__4_in_rule__ShellCmd__Group_0_1__39098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellCmd__ShellPartAssignment_0_1_3_in_rule__ShellCmd__Group_0_1__3__Impl9127 = new BitSet(new long[]{0x0000000076001C02L});
    public static final BitSet FOLLOW_rule__ShellCmd__ShellPartAssignment_0_1_3_in_rule__ShellCmd__Group_0_1__3__Impl9139 = new BitSet(new long[]{0x0000000076001C02L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_0_1__4__Impl_in_rule__ShellCmd__Group_0_1__49172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BRACE_END_in_rule__ShellCmd__Group_0_1__4__Impl9199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_1__0__Impl_in_rule__ShellCmd__Group_1__09238 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_1__1_in_rule__ShellCmd__Group_1__09241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellCmd__Group_1__1__Impl_in_rule__ShellCmd__Group_1__19299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INCLUDE_in_rule__ShellCmd__Group_1__1__Impl9326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellPart__Group__0__Impl_in_rule__ShellPart__Group__09359 = new BitSet(new long[]{0x0000000076001C00L});
    public static final BitSet FOLLOW_rule__ShellPart__Group__1_in_rule__ShellPart__Group__09362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellPart__Group__1__Impl_in_rule__ShellPart__Group__19420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellPart__Alternatives_1_in_rule__ShellPart__Group__1__Impl9447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellPart__Group_1_5__0__Impl_in_rule__ShellPart__Group_1_5__09481 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ShellPart__Group_1_5__1_in_rule__ShellPart__Group_1_5__09484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BACKSLASH_in_rule__ShellPart__Group_1_5__0__Impl9511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellPart__Group_1_5__1__Impl_in_rule__ShellPart__Group_1_5__19540 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__ShellPart__Group_1_5__2_in_rule__ShellPart__Group_1_5__19543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_rule__ShellPart__Group_1_5__1__Impl9570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShellPart__Group_1_5__2__Impl_in_rule__ShellPart__Group_1_5__29599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TAB_in_rule__ShellPart__Group_1_5__2__Impl9627 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleBuildEntry_in_rule__Model__BuildEntryAssignment_19669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuildEntry_in_rule__Model__BuildEntryAssignment_2_19700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntry_in_rule__BuildEntry__ValueAssignment_0_19731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIf_in_rule__BuildEntry__ValueAssignment_1_29762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIf_in_rule__BuildEntry__ValueAssignment_2_29793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_rule__BuildEntry__NameAssignment_3_29824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObject_Y_in_rule__BuildEntry__ValueAssignment_3_4_09855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObject_M_in_rule__BuildEntry__ValueAssignment_3_4_19886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_rule__BuildEntry__NameAssignment_4_19917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__BuildEntry__VariableAssignment_4_29948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignExtra_in_rule__BuildEntry__ValueAssignment_4_39979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssign_in_rule__BuildEntry__InnerAssignment_4_410010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObject_Y_in_rule__BuildEntry__ValueAssignment_5_1_010041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObject_M_in_rule__BuildEntry__ValueAssignment_5_1_110072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValues_in_rule__BuildEntry__TargetAssignment_6_110103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValues_in_rule__BuildEntry__ValuesAssignment_6_3_1_010134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValues_in_rule__BuildEntry__ValuesAssignment_6_3_1_1_210165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_rule__BuildEntry__NameAssignment_7_110196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__BuildEntry__VariableAssignment_7_210227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssign_in_rule__BuildEntry__ValueAssignment_7_310258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Entry__VariableAssignment_210289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignExtra_in_rule__Entry__ValueAssignment_310320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShellCmd_in_rule__If__ShellAssignment_1_1_010351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObject_Y_in_rule__If__ValueAssignment_5_010382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObject_M_in_rule__If__ValueAssignment_5_110413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntry_in_rule__If__ValueAssignment_5_210444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShellCmd_in_rule__If__ValueAssignment_5_310475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObject_Y_in_rule__If__ElsevalueAssignment_7_3_010506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObject_M_in_rule__If__ElsevalueAssignment_7_3_110537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignExtra_in_rule__Object_Y__ValueAssignment_210568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignExtra_in_rule__Object_M__ValueAssignment_210599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__Values__ValuesAssignment_110630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__Values__ValuesAssignment_2_310661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_rule__Value__NameAssignment_1_110692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Value__ValueAssignment_2_110723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_rule__Value__AdditionalAssignment_2_210754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShellCmd_in_rule__Value__ValueAssignment_3_110785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SHELL_CHAR_in_rule__Value__ValueAssignment_5_110816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_rule__Variable__NameAssignment_0_210847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_rule__Variable__NameAssignment_1_210878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_rule__ShellCmd__NameAssignment_0_1_210909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShellPart_in_rule__ShellCmd__ShellPartAssignment_0_1_310940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarSlashSym_in_rule__ShellPart__ValAssignment_1_010971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShellCmd_in_rule__ShellPart__CmdAssignment_1_111002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_rule__VarSlashSym__NameAssignment_111033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_rule__VarSlashSym__NameAssignment_211064 = new BitSet(new long[]{0x0000000000000002L});

}