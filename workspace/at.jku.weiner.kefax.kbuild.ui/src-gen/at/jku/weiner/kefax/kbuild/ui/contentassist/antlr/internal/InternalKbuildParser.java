package at.jku.weiner.kefax.kbuild.ui.contentassist.antlr.internal; 

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
import at.jku.weiner.kefax.kbuild.services.KbuildGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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
    public String getGrammarFileName() { return "InternalKbuild.g"; }


     
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
    // InternalKbuild.g:62:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalKbuild.g:63:1: ( ruleModel EOF )
            // InternalKbuild.g:64:1: ruleModel EOF
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
    // InternalKbuild.g:71:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalKbuild.g:78:7: ( ( ( rule__Model__Group__0 ) ) )
            // InternalKbuild.g:80:1: ( ( rule__Model__Group__0 ) )
            {
            // InternalKbuild.g:80:1: ( ( rule__Model__Group__0 ) )
            // InternalKbuild.g:81:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalKbuild.g:82:1: ( rule__Model__Group__0 )
            // InternalKbuild.g:82:2: rule__Model__Group__0
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


    // $ANTLR start "entryRuleBuildEntry"
    // InternalKbuild.g:97:1: entryRuleBuildEntry : ruleBuildEntry EOF ;
    public final void entryRuleBuildEntry() throws RecognitionException {
        try {
            // InternalKbuild.g:98:1: ( ruleBuildEntry EOF )
            // InternalKbuild.g:99:1: ruleBuildEntry EOF
            {
             before(grammarAccess.getBuildEntryRule()); 
            pushFollow(FOLLOW_1);
            ruleBuildEntry();

            state._fsp--;

             after(grammarAccess.getBuildEntryRule()); 
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
    // $ANTLR end "entryRuleBuildEntry"


    // $ANTLR start "ruleBuildEntry"
    // InternalKbuild.g:106:1: ruleBuildEntry : ( ( rule__BuildEntry__Alternatives ) ) ;
    public final void ruleBuildEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalKbuild.g:113:7: ( ( ( rule__BuildEntry__Alternatives ) ) )
            // InternalKbuild.g:115:1: ( ( rule__BuildEntry__Alternatives ) )
            {
            // InternalKbuild.g:115:1: ( ( rule__BuildEntry__Alternatives ) )
            // InternalKbuild.g:116:1: ( rule__BuildEntry__Alternatives )
            {
             before(grammarAccess.getBuildEntryAccess().getAlternatives()); 
            // InternalKbuild.g:117:1: ( rule__BuildEntry__Alternatives )
            // InternalKbuild.g:117:2: rule__BuildEntry__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__BuildEntry__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBuildEntryAccess().getAlternatives()); 

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
    // $ANTLR end "ruleBuildEntry"


    // $ANTLR start "entryRuleEntry"
    // InternalKbuild.g:132:1: entryRuleEntry : ruleEntry EOF ;
    public final void entryRuleEntry() throws RecognitionException {
        try {
            // InternalKbuild.g:133:1: ( ruleEntry EOF )
            // InternalKbuild.g:134:1: ruleEntry EOF
            {
             before(grammarAccess.getEntryRule()); 
            pushFollow(FOLLOW_1);
            ruleEntry();

            state._fsp--;

             after(grammarAccess.getEntryRule()); 
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
    // $ANTLR end "entryRuleEntry"


    // $ANTLR start "ruleEntry"
    // InternalKbuild.g:141:1: ruleEntry : ( ( rule__Entry__Group__0 ) ) ;
    public final void ruleEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalKbuild.g:148:7: ( ( ( rule__Entry__Group__0 ) ) )
            // InternalKbuild.g:150:1: ( ( rule__Entry__Group__0 ) )
            {
            // InternalKbuild.g:150:1: ( ( rule__Entry__Group__0 ) )
            // InternalKbuild.g:151:1: ( rule__Entry__Group__0 )
            {
             before(grammarAccess.getEntryAccess().getGroup()); 
            // InternalKbuild.g:152:1: ( rule__Entry__Group__0 )
            // InternalKbuild.g:152:2: rule__Entry__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Entry__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getGroup()); 

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
    // $ANTLR end "ruleEntry"


    // $ANTLR start "entryRuleIf"
    // InternalKbuild.g:167:1: entryRuleIf : ruleIf EOF ;
    public final void entryRuleIf() throws RecognitionException {
        try {
            // InternalKbuild.g:168:1: ( ruleIf EOF )
            // InternalKbuild.g:169:1: ruleIf EOF
            {
             before(grammarAccess.getIfRule()); 
            pushFollow(FOLLOW_1);
            ruleIf();

            state._fsp--;

             after(grammarAccess.getIfRule()); 
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
    // $ANTLR end "entryRuleIf"


    // $ANTLR start "ruleIf"
    // InternalKbuild.g:176:1: ruleIf : ( ( rule__If__Group__0 ) ) ;
    public final void ruleIf() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalKbuild.g:183:7: ( ( ( rule__If__Group__0 ) ) )
            // InternalKbuild.g:185:1: ( ( rule__If__Group__0 ) )
            {
            // InternalKbuild.g:185:1: ( ( rule__If__Group__0 ) )
            // InternalKbuild.g:186:1: ( rule__If__Group__0 )
            {
             before(grammarAccess.getIfAccess().getGroup()); 
            // InternalKbuild.g:187:1: ( rule__If__Group__0 )
            // InternalKbuild.g:187:2: rule__If__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__If__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIfAccess().getGroup()); 

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
    // $ANTLR end "ruleIf"


    // $ANTLR start "entryRuleObject_Y"
    // InternalKbuild.g:202:1: entryRuleObject_Y : ruleObject_Y EOF ;
    public final void entryRuleObject_Y() throws RecognitionException {
        try {
            // InternalKbuild.g:203:1: ( ruleObject_Y EOF )
            // InternalKbuild.g:204:1: ruleObject_Y EOF
            {
             before(grammarAccess.getObject_YRule()); 
            pushFollow(FOLLOW_1);
            ruleObject_Y();

            state._fsp--;

             after(grammarAccess.getObject_YRule()); 
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
    // $ANTLR end "entryRuleObject_Y"


    // $ANTLR start "ruleObject_Y"
    // InternalKbuild.g:211:1: ruleObject_Y : ( ( rule__Object_Y__Group__0 ) ) ;
    public final void ruleObject_Y() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalKbuild.g:218:7: ( ( ( rule__Object_Y__Group__0 ) ) )
            // InternalKbuild.g:220:1: ( ( rule__Object_Y__Group__0 ) )
            {
            // InternalKbuild.g:220:1: ( ( rule__Object_Y__Group__0 ) )
            // InternalKbuild.g:221:1: ( rule__Object_Y__Group__0 )
            {
             before(grammarAccess.getObject_YAccess().getGroup()); 
            // InternalKbuild.g:222:1: ( rule__Object_Y__Group__0 )
            // InternalKbuild.g:222:2: rule__Object_Y__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Object_Y__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getObject_YAccess().getGroup()); 

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
    // $ANTLR end "ruleObject_Y"


    // $ANTLR start "entryRuleObject_M"
    // InternalKbuild.g:237:1: entryRuleObject_M : ruleObject_M EOF ;
    public final void entryRuleObject_M() throws RecognitionException {
        try {
            // InternalKbuild.g:238:1: ( ruleObject_M EOF )
            // InternalKbuild.g:239:1: ruleObject_M EOF
            {
             before(grammarAccess.getObject_MRule()); 
            pushFollow(FOLLOW_1);
            ruleObject_M();

            state._fsp--;

             after(grammarAccess.getObject_MRule()); 
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
    // $ANTLR end "entryRuleObject_M"


    // $ANTLR start "ruleObject_M"
    // InternalKbuild.g:246:1: ruleObject_M : ( ( rule__Object_M__Group__0 ) ) ;
    public final void ruleObject_M() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalKbuild.g:253:7: ( ( ( rule__Object_M__Group__0 ) ) )
            // InternalKbuild.g:255:1: ( ( rule__Object_M__Group__0 ) )
            {
            // InternalKbuild.g:255:1: ( ( rule__Object_M__Group__0 ) )
            // InternalKbuild.g:256:1: ( rule__Object_M__Group__0 )
            {
             before(grammarAccess.getObject_MAccess().getGroup()); 
            // InternalKbuild.g:257:1: ( rule__Object_M__Group__0 )
            // InternalKbuild.g:257:2: rule__Object_M__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Object_M__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getObject_MAccess().getGroup()); 

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
    // $ANTLR end "ruleObject_M"


    // $ANTLR start "entryRuleAssign"
    // InternalKbuild.g:272:1: entryRuleAssign : ruleAssign EOF ;
    public final void entryRuleAssign() throws RecognitionException {
        try {
            // InternalKbuild.g:273:1: ( ruleAssign EOF )
            // InternalKbuild.g:274:1: ruleAssign EOF
            {
             before(grammarAccess.getAssignRule()); 
            pushFollow(FOLLOW_1);
            ruleAssign();

            state._fsp--;

             after(grammarAccess.getAssignRule()); 
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
    // $ANTLR end "entryRuleAssign"


    // $ANTLR start "ruleAssign"
    // InternalKbuild.g:281:1: ruleAssign : ( ( rule__Assign__Group__0 ) ) ;
    public final void ruleAssign() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalKbuild.g:288:7: ( ( ( rule__Assign__Group__0 ) ) )
            // InternalKbuild.g:290:1: ( ( rule__Assign__Group__0 ) )
            {
            // InternalKbuild.g:290:1: ( ( rule__Assign__Group__0 ) )
            // InternalKbuild.g:291:1: ( rule__Assign__Group__0 )
            {
             before(grammarAccess.getAssignAccess().getGroup()); 
            // InternalKbuild.g:292:1: ( rule__Assign__Group__0 )
            // InternalKbuild.g:292:2: rule__Assign__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Assign__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignAccess().getGroup()); 

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
    // $ANTLR end "ruleAssign"


    // $ANTLR start "entryRuleAssignExtra"
    // InternalKbuild.g:307:1: entryRuleAssignExtra : ruleAssignExtra EOF ;
    public final void entryRuleAssignExtra() throws RecognitionException {
        try {
            // InternalKbuild.g:308:1: ( ruleAssignExtra EOF )
            // InternalKbuild.g:309:1: ruleAssignExtra EOF
            {
             before(grammarAccess.getAssignExtraRule()); 
            pushFollow(FOLLOW_1);
            ruleAssignExtra();

            state._fsp--;

             after(grammarAccess.getAssignExtraRule()); 
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
    // $ANTLR end "entryRuleAssignExtra"


    // $ANTLR start "ruleAssignExtra"
    // InternalKbuild.g:316:1: ruleAssignExtra : ( ( rule__AssignExtra__Group__0 ) ) ;
    public final void ruleAssignExtra() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalKbuild.g:323:7: ( ( ( rule__AssignExtra__Group__0 ) ) )
            // InternalKbuild.g:325:1: ( ( rule__AssignExtra__Group__0 ) )
            {
            // InternalKbuild.g:325:1: ( ( rule__AssignExtra__Group__0 ) )
            // InternalKbuild.g:326:1: ( rule__AssignExtra__Group__0 )
            {
             before(grammarAccess.getAssignExtraAccess().getGroup()); 
            // InternalKbuild.g:327:1: ( rule__AssignExtra__Group__0 )
            // InternalKbuild.g:327:2: rule__AssignExtra__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AssignExtra__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignExtraAccess().getGroup()); 

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
    // $ANTLR end "ruleAssignExtra"


    // $ANTLR start "entryRuleValues"
    // InternalKbuild.g:342:1: entryRuleValues : ruleValues EOF ;
    public final void entryRuleValues() throws RecognitionException {
        try {
            // InternalKbuild.g:343:1: ( ruleValues EOF )
            // InternalKbuild.g:344:1: ruleValues EOF
            {
             before(grammarAccess.getValuesRule()); 
            pushFollow(FOLLOW_1);
            ruleValues();

            state._fsp--;

             after(grammarAccess.getValuesRule()); 
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
    // $ANTLR end "entryRuleValues"


    // $ANTLR start "ruleValues"
    // InternalKbuild.g:351:1: ruleValues : ( ( rule__Values__Group__0 ) ) ;
    public final void ruleValues() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalKbuild.g:358:7: ( ( ( rule__Values__Group__0 ) ) )
            // InternalKbuild.g:360:1: ( ( rule__Values__Group__0 ) )
            {
            // InternalKbuild.g:360:1: ( ( rule__Values__Group__0 ) )
            // InternalKbuild.g:361:1: ( rule__Values__Group__0 )
            {
             before(grammarAccess.getValuesAccess().getGroup()); 
            // InternalKbuild.g:362:1: ( rule__Values__Group__0 )
            // InternalKbuild.g:362:2: rule__Values__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Values__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getValuesAccess().getGroup()); 

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
    // $ANTLR end "ruleValues"


    // $ANTLR start "entryRuleValue"
    // InternalKbuild.g:377:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // InternalKbuild.g:378:1: ( ruleValue EOF )
            // InternalKbuild.g:379:1: ruleValue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
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
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalKbuild.g:386:1: ruleValue : ( ( rule__Value__Alternatives ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalKbuild.g:393:7: ( ( ( rule__Value__Alternatives ) ) )
            // InternalKbuild.g:395:1: ( ( rule__Value__Alternatives ) )
            {
            // InternalKbuild.g:395:1: ( ( rule__Value__Alternatives ) )
            // InternalKbuild.g:396:1: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // InternalKbuild.g:397:1: ( rule__Value__Alternatives )
            // InternalKbuild.g:397:2: rule__Value__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Value__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getAlternatives()); 

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
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleVariable"
    // InternalKbuild.g:412:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // InternalKbuild.g:413:1: ( ruleVariable EOF )
            // InternalKbuild.g:414:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
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
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalKbuild.g:421:1: ruleVariable : ( ( rule__Variable__Alternatives ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalKbuild.g:428:7: ( ( ( rule__Variable__Alternatives ) ) )
            // InternalKbuild.g:430:1: ( ( rule__Variable__Alternatives ) )
            {
            // InternalKbuild.g:430:1: ( ( rule__Variable__Alternatives ) )
            // InternalKbuild.g:431:1: ( rule__Variable__Alternatives )
            {
             before(grammarAccess.getVariableAccess().getAlternatives()); 
            // InternalKbuild.g:432:1: ( rule__Variable__Alternatives )
            // InternalKbuild.g:432:2: rule__Variable__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getAlternatives()); 

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
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleShellCmd"
    // InternalKbuild.g:447:1: entryRuleShellCmd : ruleShellCmd EOF ;
    public final void entryRuleShellCmd() throws RecognitionException {
        try {
            // InternalKbuild.g:448:1: ( ruleShellCmd EOF )
            // InternalKbuild.g:449:1: ruleShellCmd EOF
            {
             before(grammarAccess.getShellCmdRule()); 
            pushFollow(FOLLOW_1);
            ruleShellCmd();

            state._fsp--;

             after(grammarAccess.getShellCmdRule()); 
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
    // $ANTLR end "entryRuleShellCmd"


    // $ANTLR start "ruleShellCmd"
    // InternalKbuild.g:456:1: ruleShellCmd : ( ( rule__ShellCmd__Alternatives ) ) ;
    public final void ruleShellCmd() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalKbuild.g:463:7: ( ( ( rule__ShellCmd__Alternatives ) ) )
            // InternalKbuild.g:465:1: ( ( rule__ShellCmd__Alternatives ) )
            {
            // InternalKbuild.g:465:1: ( ( rule__ShellCmd__Alternatives ) )
            // InternalKbuild.g:466:1: ( rule__ShellCmd__Alternatives )
            {
             before(grammarAccess.getShellCmdAccess().getAlternatives()); 
            // InternalKbuild.g:467:1: ( rule__ShellCmd__Alternatives )
            // InternalKbuild.g:467:2: rule__ShellCmd__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ShellCmd__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getShellCmdAccess().getAlternatives()); 

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
    // $ANTLR end "ruleShellCmd"


    // $ANTLR start "entryRuleShellPart"
    // InternalKbuild.g:482:1: entryRuleShellPart : ruleShellPart EOF ;
    public final void entryRuleShellPart() throws RecognitionException {
        try {
            // InternalKbuild.g:483:1: ( ruleShellPart EOF )
            // InternalKbuild.g:484:1: ruleShellPart EOF
            {
             before(grammarAccess.getShellPartRule()); 
            pushFollow(FOLLOW_1);
            ruleShellPart();

            state._fsp--;

             after(grammarAccess.getShellPartRule()); 
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
    // $ANTLR end "entryRuleShellPart"


    // $ANTLR start "ruleShellPart"
    // InternalKbuild.g:491:1: ruleShellPart : ( ( rule__ShellPart__Group__0 ) ) ;
    public final void ruleShellPart() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalKbuild.g:498:7: ( ( ( rule__ShellPart__Group__0 ) ) )
            // InternalKbuild.g:500:1: ( ( rule__ShellPart__Group__0 ) )
            {
            // InternalKbuild.g:500:1: ( ( rule__ShellPart__Group__0 ) )
            // InternalKbuild.g:501:1: ( rule__ShellPart__Group__0 )
            {
             before(grammarAccess.getShellPartAccess().getGroup()); 
            // InternalKbuild.g:502:1: ( rule__ShellPart__Group__0 )
            // InternalKbuild.g:502:2: rule__ShellPart__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ShellPart__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getShellPartAccess().getGroup()); 

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
    // $ANTLR end "ruleShellPart"


    // $ANTLR start "entryRuleVarSlashSym"
    // InternalKbuild.g:517:1: entryRuleVarSlashSym : ruleVarSlashSym EOF ;
    public final void entryRuleVarSlashSym() throws RecognitionException {
        try {
            // InternalKbuild.g:518:1: ( ruleVarSlashSym EOF )
            // InternalKbuild.g:519:1: ruleVarSlashSym EOF
            {
             before(grammarAccess.getVarSlashSymRule()); 
            pushFollow(FOLLOW_1);
            ruleVarSlashSym();

            state._fsp--;

             after(grammarAccess.getVarSlashSymRule()); 
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
    // $ANTLR end "entryRuleVarSlashSym"


    // $ANTLR start "ruleVarSlashSym"
    // InternalKbuild.g:526:1: ruleVarSlashSym : ( ( rule__VarSlashSym__Alternatives ) ) ;
    public final void ruleVarSlashSym() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalKbuild.g:533:7: ( ( ( rule__VarSlashSym__Alternatives ) ) )
            // InternalKbuild.g:535:1: ( ( rule__VarSlashSym__Alternatives ) )
            {
            // InternalKbuild.g:535:1: ( ( rule__VarSlashSym__Alternatives ) )
            // InternalKbuild.g:536:1: ( rule__VarSlashSym__Alternatives )
            {
             before(grammarAccess.getVarSlashSymAccess().getAlternatives()); 
            // InternalKbuild.g:537:1: ( rule__VarSlashSym__Alternatives )
            // InternalKbuild.g:537:2: rule__VarSlashSym__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__VarSlashSym__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVarSlashSymAccess().getAlternatives()); 

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
    // $ANTLR end "ruleVarSlashSym"


    // $ANTLR start "entryRuleEol"
    // InternalKbuild.g:552:1: entryRuleEol : ruleEol EOF ;
    public final void entryRuleEol() throws RecognitionException {
        try {
            // InternalKbuild.g:553:1: ( ruleEol EOF )
            // InternalKbuild.g:554:1: ruleEol EOF
            {
             before(grammarAccess.getEolRule()); 
            pushFollow(FOLLOW_1);
            ruleEol();

            state._fsp--;

             after(grammarAccess.getEolRule()); 
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
    // $ANTLR end "entryRuleEol"


    // $ANTLR start "ruleEol"
    // InternalKbuild.g:561:1: ruleEol : ( ( ( RULE_NLI ) ) ( ( RULE_NLI )* ) ) ;
    public final void ruleEol() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalKbuild.g:568:7: ( ( ( ( RULE_NLI ) ) ( ( RULE_NLI )* ) ) )
            // InternalKbuild.g:570:1: ( ( ( RULE_NLI ) ) ( ( RULE_NLI )* ) )
            {
            // InternalKbuild.g:570:1: ( ( ( RULE_NLI ) ) ( ( RULE_NLI )* ) )
            // InternalKbuild.g:571:1: ( ( RULE_NLI ) ) ( ( RULE_NLI )* )
            {
            // InternalKbuild.g:571:1: ( ( RULE_NLI ) )
            // InternalKbuild.g:572:1: ( RULE_NLI )
            {
             before(grammarAccess.getEolAccess().getNLITerminalRuleCall()); 
            // InternalKbuild.g:573:1: ( RULE_NLI )
            // InternalKbuild.g:573:3: RULE_NLI
            {
            match(input,RULE_NLI,FOLLOW_3); 

            }

             after(grammarAccess.getEolAccess().getNLITerminalRuleCall()); 

            }

            // InternalKbuild.g:576:1: ( ( RULE_NLI )* )
            // InternalKbuild.g:577:1: ( RULE_NLI )*
            {
             before(grammarAccess.getEolAccess().getNLITerminalRuleCall()); 
            // InternalKbuild.g:578:1: ( RULE_NLI )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_NLI) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalKbuild.g:578:3: RULE_NLI
            	    {
            	    match(input,RULE_NLI,FOLLOW_3); 

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
    // $ANTLR end "ruleEol"


    // $ANTLR start "rule__BuildEntry__Alternatives"
    // InternalKbuild.g:593:1: rule__BuildEntry__Alternatives : ( ( ( rule__BuildEntry__Group_0__0 ) ) | ( ( rule__BuildEntry__Group_1__0 ) ) | ( ( rule__BuildEntry__Group_2__0 ) ) | ( ( rule__BuildEntry__Group_3__0 ) ) | ( ( rule__BuildEntry__Group_4__0 ) ) | ( ( rule__BuildEntry__Group_5__0 ) ) | ( ( rule__BuildEntry__Group_6__0 ) ) | ( ( rule__BuildEntry__Group_7__0 ) ) );
    public final void rule__BuildEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:597:1: ( ( ( rule__BuildEntry__Group_0__0 ) ) | ( ( rule__BuildEntry__Group_1__0 ) ) | ( ( rule__BuildEntry__Group_2__0 ) ) | ( ( rule__BuildEntry__Group_3__0 ) ) | ( ( rule__BuildEntry__Group_4__0 ) ) | ( ( rule__BuildEntry__Group_5__0 ) ) | ( ( rule__BuildEntry__Group_6__0 ) ) | ( ( rule__BuildEntry__Group_7__0 ) ) )
            int alt2=8;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalKbuild.g:599:1: ( ( rule__BuildEntry__Group_0__0 ) )
                    {
                    // InternalKbuild.g:599:1: ( ( rule__BuildEntry__Group_0__0 ) )
                    // InternalKbuild.g:600:1: ( rule__BuildEntry__Group_0__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_0()); 
                    // InternalKbuild.g:601:1: ( rule__BuildEntry__Group_0__0 )
                    // InternalKbuild.g:601:2: rule__BuildEntry__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BuildEntry__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalKbuild.g:608:1: ( ( rule__BuildEntry__Group_1__0 ) )
                    {
                    // InternalKbuild.g:608:1: ( ( rule__BuildEntry__Group_1__0 ) )
                    // InternalKbuild.g:609:1: ( rule__BuildEntry__Group_1__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_1()); 
                    // InternalKbuild.g:610:1: ( rule__BuildEntry__Group_1__0 )
                    // InternalKbuild.g:610:2: rule__BuildEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BuildEntry__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalKbuild.g:617:1: ( ( rule__BuildEntry__Group_2__0 ) )
                    {
                    // InternalKbuild.g:617:1: ( ( rule__BuildEntry__Group_2__0 ) )
                    // InternalKbuild.g:618:1: ( rule__BuildEntry__Group_2__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_2()); 
                    // InternalKbuild.g:619:1: ( rule__BuildEntry__Group_2__0 )
                    // InternalKbuild.g:619:2: rule__BuildEntry__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BuildEntry__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalKbuild.g:626:1: ( ( rule__BuildEntry__Group_3__0 ) )
                    {
                    // InternalKbuild.g:626:1: ( ( rule__BuildEntry__Group_3__0 ) )
                    // InternalKbuild.g:627:1: ( rule__BuildEntry__Group_3__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_3()); 
                    // InternalKbuild.g:628:1: ( rule__BuildEntry__Group_3__0 )
                    // InternalKbuild.g:628:2: rule__BuildEntry__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BuildEntry__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalKbuild.g:635:1: ( ( rule__BuildEntry__Group_4__0 ) )
                    {
                    // InternalKbuild.g:635:1: ( ( rule__BuildEntry__Group_4__0 ) )
                    // InternalKbuild.g:636:1: ( rule__BuildEntry__Group_4__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_4()); 
                    // InternalKbuild.g:637:1: ( rule__BuildEntry__Group_4__0 )
                    // InternalKbuild.g:637:2: rule__BuildEntry__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BuildEntry__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalKbuild.g:644:1: ( ( rule__BuildEntry__Group_5__0 ) )
                    {
                    // InternalKbuild.g:644:1: ( ( rule__BuildEntry__Group_5__0 ) )
                    // InternalKbuild.g:645:1: ( rule__BuildEntry__Group_5__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_5()); 
                    // InternalKbuild.g:646:1: ( rule__BuildEntry__Group_5__0 )
                    // InternalKbuild.g:646:2: rule__BuildEntry__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BuildEntry__Group_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getGroup_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalKbuild.g:653:1: ( ( rule__BuildEntry__Group_6__0 ) )
                    {
                    // InternalKbuild.g:653:1: ( ( rule__BuildEntry__Group_6__0 ) )
                    // InternalKbuild.g:654:1: ( rule__BuildEntry__Group_6__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_6()); 
                    // InternalKbuild.g:655:1: ( rule__BuildEntry__Group_6__0 )
                    // InternalKbuild.g:655:2: rule__BuildEntry__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BuildEntry__Group_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getGroup_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalKbuild.g:662:1: ( ( rule__BuildEntry__Group_7__0 ) )
                    {
                    // InternalKbuild.g:662:1: ( ( rule__BuildEntry__Group_7__0 ) )
                    // InternalKbuild.g:663:1: ( rule__BuildEntry__Group_7__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_7()); 
                    // InternalKbuild.g:664:1: ( rule__BuildEntry__Group_7__0 )
                    // InternalKbuild.g:664:2: rule__BuildEntry__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:675:1: rule__BuildEntry__Alternatives_3_4 : ( ( ( rule__BuildEntry__ValueAssignment_3_4_0 ) ) | ( ( rule__BuildEntry__ValueAssignment_3_4_1 ) ) );
    public final void rule__BuildEntry__Alternatives_3_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:679:1: ( ( ( rule__BuildEntry__ValueAssignment_3_4_0 ) ) | ( ( rule__BuildEntry__ValueAssignment_3_4_1 ) ) )
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
                    // InternalKbuild.g:681:1: ( ( rule__BuildEntry__ValueAssignment_3_4_0 ) )
                    {
                    // InternalKbuild.g:681:1: ( ( rule__BuildEntry__ValueAssignment_3_4_0 ) )
                    // InternalKbuild.g:682:1: ( rule__BuildEntry__ValueAssignment_3_4_0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getValueAssignment_3_4_0()); 
                    // InternalKbuild.g:683:1: ( rule__BuildEntry__ValueAssignment_3_4_0 )
                    // InternalKbuild.g:683:2: rule__BuildEntry__ValueAssignment_3_4_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BuildEntry__ValueAssignment_3_4_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getValueAssignment_3_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalKbuild.g:690:1: ( ( rule__BuildEntry__ValueAssignment_3_4_1 ) )
                    {
                    // InternalKbuild.g:690:1: ( ( rule__BuildEntry__ValueAssignment_3_4_1 ) )
                    // InternalKbuild.g:691:1: ( rule__BuildEntry__ValueAssignment_3_4_1 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getValueAssignment_3_4_1()); 
                    // InternalKbuild.g:692:1: ( rule__BuildEntry__ValueAssignment_3_4_1 )
                    // InternalKbuild.g:692:2: rule__BuildEntry__ValueAssignment_3_4_1
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:703:1: rule__BuildEntry__Alternatives_5_1 : ( ( ( rule__BuildEntry__ValueAssignment_5_1_0 ) ) | ( ( rule__BuildEntry__ValueAssignment_5_1_1 ) ) );
    public final void rule__BuildEntry__Alternatives_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:707:1: ( ( ( rule__BuildEntry__ValueAssignment_5_1_0 ) ) | ( ( rule__BuildEntry__ValueAssignment_5_1_1 ) ) )
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
                    // InternalKbuild.g:709:1: ( ( rule__BuildEntry__ValueAssignment_5_1_0 ) )
                    {
                    // InternalKbuild.g:709:1: ( ( rule__BuildEntry__ValueAssignment_5_1_0 ) )
                    // InternalKbuild.g:710:1: ( rule__BuildEntry__ValueAssignment_5_1_0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getValueAssignment_5_1_0()); 
                    // InternalKbuild.g:711:1: ( rule__BuildEntry__ValueAssignment_5_1_0 )
                    // InternalKbuild.g:711:2: rule__BuildEntry__ValueAssignment_5_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BuildEntry__ValueAssignment_5_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBuildEntryAccess().getValueAssignment_5_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalKbuild.g:718:1: ( ( rule__BuildEntry__ValueAssignment_5_1_1 ) )
                    {
                    // InternalKbuild.g:718:1: ( ( rule__BuildEntry__ValueAssignment_5_1_1 ) )
                    // InternalKbuild.g:719:1: ( rule__BuildEntry__ValueAssignment_5_1_1 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getValueAssignment_5_1_1()); 
                    // InternalKbuild.g:720:1: ( rule__BuildEntry__ValueAssignment_5_1_1 )
                    // InternalKbuild.g:720:2: rule__BuildEntry__ValueAssignment_5_1_1
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:731:1: rule__BuildEntry__Alternatives_6_3 : ( ( RULE_SEMICOLON ) | ( ( rule__BuildEntry__Group_6_3_1__0 ) ) );
    public final void rule__BuildEntry__Alternatives_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:735:1: ( ( RULE_SEMICOLON ) | ( ( rule__BuildEntry__Group_6_3_1__0 ) ) )
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
                    // InternalKbuild.g:737:1: ( RULE_SEMICOLON )
                    {
                    // InternalKbuild.g:737:1: ( RULE_SEMICOLON )
                    // InternalKbuild.g:738:1: RULE_SEMICOLON
                    {
                     before(grammarAccess.getBuildEntryAccess().getSEMICOLONTerminalRuleCall_6_3_0()); 
                    match(input,RULE_SEMICOLON,FOLLOW_2); 
                     after(grammarAccess.getBuildEntryAccess().getSEMICOLONTerminalRuleCall_6_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalKbuild.g:746:1: ( ( rule__BuildEntry__Group_6_3_1__0 ) )
                    {
                    // InternalKbuild.g:746:1: ( ( rule__BuildEntry__Group_6_3_1__0 ) )
                    // InternalKbuild.g:747:1: ( rule__BuildEntry__Group_6_3_1__0 )
                    {
                     before(grammarAccess.getBuildEntryAccess().getGroup_6_3_1()); 
                    // InternalKbuild.g:748:1: ( rule__BuildEntry__Group_6_3_1__0 )
                    // InternalKbuild.g:748:2: rule__BuildEntry__Group_6_3_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:759:1: rule__If__Alternatives_1 : ( ( ( rule__If__Group_1_0__0 ) ) | ( ( rule__If__Group_1_1__0 ) ) );
    public final void rule__If__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:763:1: ( ( ( rule__If__Group_1_0__0 ) ) | ( ( rule__If__Group_1_1__0 ) ) )
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
                    // InternalKbuild.g:765:1: ( ( rule__If__Group_1_0__0 ) )
                    {
                    // InternalKbuild.g:765:1: ( ( rule__If__Group_1_0__0 ) )
                    // InternalKbuild.g:766:1: ( rule__If__Group_1_0__0 )
                    {
                     before(grammarAccess.getIfAccess().getGroup_1_0()); 
                    // InternalKbuild.g:767:1: ( rule__If__Group_1_0__0 )
                    // InternalKbuild.g:767:2: rule__If__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__If__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIfAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalKbuild.g:774:1: ( ( rule__If__Group_1_1__0 ) )
                    {
                    // InternalKbuild.g:774:1: ( ( rule__If__Group_1_1__0 ) )
                    // InternalKbuild.g:775:1: ( rule__If__Group_1_1__0 )
                    {
                     before(grammarAccess.getIfAccess().getGroup_1_1()); 
                    // InternalKbuild.g:776:1: ( rule__If__Group_1_1__0 )
                    // InternalKbuild.g:776:2: rule__If__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:787:1: rule__If__Alternatives_1_0_2 : ( ( RULE_Y ) | ( RULE_M ) );
    public final void rule__If__Alternatives_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:791:1: ( ( RULE_Y ) | ( RULE_M ) )
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
                    // InternalKbuild.g:793:1: ( RULE_Y )
                    {
                    // InternalKbuild.g:793:1: ( RULE_Y )
                    // InternalKbuild.g:794:1: RULE_Y
                    {
                     before(grammarAccess.getIfAccess().getYTerminalRuleCall_1_0_2_0()); 
                    match(input,RULE_Y,FOLLOW_2); 
                     after(grammarAccess.getIfAccess().getYTerminalRuleCall_1_0_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalKbuild.g:802:1: ( RULE_M )
                    {
                    // InternalKbuild.g:802:1: ( RULE_M )
                    // InternalKbuild.g:803:1: RULE_M
                    {
                     before(grammarAccess.getIfAccess().getMTerminalRuleCall_1_0_2_1()); 
                    match(input,RULE_M,FOLLOW_2); 
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
    // InternalKbuild.g:815:1: rule__If__Alternatives_5 : ( ( ( rule__If__ValueAssignment_5_0 ) ) | ( ( rule__If__ValueAssignment_5_1 ) ) | ( ( rule__If__ValueAssignment_5_2 ) ) | ( ( rule__If__ValueAssignment_5_3 ) ) );
    public final void rule__If__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:819:1: ( ( ( rule__If__ValueAssignment_5_0 ) ) | ( ( rule__If__ValueAssignment_5_1 ) ) | ( ( rule__If__ValueAssignment_5_2 ) ) | ( ( rule__If__ValueAssignment_5_3 ) ) )
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
                    // InternalKbuild.g:821:1: ( ( rule__If__ValueAssignment_5_0 ) )
                    {
                    // InternalKbuild.g:821:1: ( ( rule__If__ValueAssignment_5_0 ) )
                    // InternalKbuild.g:822:1: ( rule__If__ValueAssignment_5_0 )
                    {
                     before(grammarAccess.getIfAccess().getValueAssignment_5_0()); 
                    // InternalKbuild.g:823:1: ( rule__If__ValueAssignment_5_0 )
                    // InternalKbuild.g:823:2: rule__If__ValueAssignment_5_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__If__ValueAssignment_5_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIfAccess().getValueAssignment_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalKbuild.g:830:1: ( ( rule__If__ValueAssignment_5_1 ) )
                    {
                    // InternalKbuild.g:830:1: ( ( rule__If__ValueAssignment_5_1 ) )
                    // InternalKbuild.g:831:1: ( rule__If__ValueAssignment_5_1 )
                    {
                     before(grammarAccess.getIfAccess().getValueAssignment_5_1()); 
                    // InternalKbuild.g:832:1: ( rule__If__ValueAssignment_5_1 )
                    // InternalKbuild.g:832:2: rule__If__ValueAssignment_5_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__If__ValueAssignment_5_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getIfAccess().getValueAssignment_5_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalKbuild.g:839:1: ( ( rule__If__ValueAssignment_5_2 ) )
                    {
                    // InternalKbuild.g:839:1: ( ( rule__If__ValueAssignment_5_2 ) )
                    // InternalKbuild.g:840:1: ( rule__If__ValueAssignment_5_2 )
                    {
                     before(grammarAccess.getIfAccess().getValueAssignment_5_2()); 
                    // InternalKbuild.g:841:1: ( rule__If__ValueAssignment_5_2 )
                    // InternalKbuild.g:841:2: rule__If__ValueAssignment_5_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__If__ValueAssignment_5_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getIfAccess().getValueAssignment_5_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalKbuild.g:848:1: ( ( rule__If__ValueAssignment_5_3 ) )
                    {
                    // InternalKbuild.g:848:1: ( ( rule__If__ValueAssignment_5_3 ) )
                    // InternalKbuild.g:849:1: ( rule__If__ValueAssignment_5_3 )
                    {
                     before(grammarAccess.getIfAccess().getValueAssignment_5_3()); 
                    // InternalKbuild.g:850:1: ( rule__If__ValueAssignment_5_3 )
                    // InternalKbuild.g:850:2: rule__If__ValueAssignment_5_3
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:861:1: rule__If__Alternatives_7_3 : ( ( ( rule__If__ElsevalueAssignment_7_3_0 ) ) | ( ( rule__If__ElsevalueAssignment_7_3_1 ) ) );
    public final void rule__If__Alternatives_7_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:865:1: ( ( ( rule__If__ElsevalueAssignment_7_3_0 ) ) | ( ( rule__If__ElsevalueAssignment_7_3_1 ) ) )
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
                    // InternalKbuild.g:867:1: ( ( rule__If__ElsevalueAssignment_7_3_0 ) )
                    {
                    // InternalKbuild.g:867:1: ( ( rule__If__ElsevalueAssignment_7_3_0 ) )
                    // InternalKbuild.g:868:1: ( rule__If__ElsevalueAssignment_7_3_0 )
                    {
                     before(grammarAccess.getIfAccess().getElsevalueAssignment_7_3_0()); 
                    // InternalKbuild.g:869:1: ( rule__If__ElsevalueAssignment_7_3_0 )
                    // InternalKbuild.g:869:2: rule__If__ElsevalueAssignment_7_3_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__If__ElsevalueAssignment_7_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIfAccess().getElsevalueAssignment_7_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalKbuild.g:876:1: ( ( rule__If__ElsevalueAssignment_7_3_1 ) )
                    {
                    // InternalKbuild.g:876:1: ( ( rule__If__ElsevalueAssignment_7_3_1 ) )
                    // InternalKbuild.g:877:1: ( rule__If__ElsevalueAssignment_7_3_1 )
                    {
                     before(grammarAccess.getIfAccess().getElsevalueAssignment_7_3_1()); 
                    // InternalKbuild.g:878:1: ( rule__If__ElsevalueAssignment_7_3_1 )
                    // InternalKbuild.g:878:2: rule__If__ElsevalueAssignment_7_3_1
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:889:1: rule__AssignExtra__Alternatives_1 : ( ( RULE_PLUS ) | ( RULE_DPOINT ) );
    public final void rule__AssignExtra__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:893:1: ( ( RULE_PLUS ) | ( RULE_DPOINT ) )
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
                    // InternalKbuild.g:895:1: ( RULE_PLUS )
                    {
                    // InternalKbuild.g:895:1: ( RULE_PLUS )
                    // InternalKbuild.g:896:1: RULE_PLUS
                    {
                     before(grammarAccess.getAssignExtraAccess().getPLUSTerminalRuleCall_1_0()); 
                    match(input,RULE_PLUS,FOLLOW_2); 
                     after(grammarAccess.getAssignExtraAccess().getPLUSTerminalRuleCall_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalKbuild.g:904:1: ( RULE_DPOINT )
                    {
                    // InternalKbuild.g:904:1: ( RULE_DPOINT )
                    // InternalKbuild.g:905:1: RULE_DPOINT
                    {
                     before(grammarAccess.getAssignExtraAccess().getDPOINTTerminalRuleCall_1_1()); 
                    match(input,RULE_DPOINT,FOLLOW_2); 
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
    // InternalKbuild.g:917:1: rule__Value__Alternatives : ( ( ( rule__Value__Group_0__0 ) ) | ( ( rule__Value__Group_1__0 ) ) | ( ( rule__Value__Group_2__0 ) ) | ( ( rule__Value__Group_3__0 ) ) | ( ( rule__Value__Group_4__0 ) ) | ( ( rule__Value__Group_5__0 ) ) | ( ( rule__Value__Group_6__0 ) ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:921:1: ( ( ( rule__Value__Group_0__0 ) ) | ( ( rule__Value__Group_1__0 ) ) | ( ( rule__Value__Group_2__0 ) ) | ( ( rule__Value__Group_3__0 ) ) | ( ( rule__Value__Group_4__0 ) ) | ( ( rule__Value__Group_5__0 ) ) | ( ( rule__Value__Group_6__0 ) ) )
            int alt11=7;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalKbuild.g:923:1: ( ( rule__Value__Group_0__0 ) )
                    {
                    // InternalKbuild.g:923:1: ( ( rule__Value__Group_0__0 ) )
                    // InternalKbuild.g:924:1: ( rule__Value__Group_0__0 )
                    {
                     before(grammarAccess.getValueAccess().getGroup_0()); 
                    // InternalKbuild.g:925:1: ( rule__Value__Group_0__0 )
                    // InternalKbuild.g:925:2: rule__Value__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Value__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalKbuild.g:932:1: ( ( rule__Value__Group_1__0 ) )
                    {
                    // InternalKbuild.g:932:1: ( ( rule__Value__Group_1__0 ) )
                    // InternalKbuild.g:933:1: ( rule__Value__Group_1__0 )
                    {
                     before(grammarAccess.getValueAccess().getGroup_1()); 
                    // InternalKbuild.g:934:1: ( rule__Value__Group_1__0 )
                    // InternalKbuild.g:934:2: rule__Value__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Value__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalKbuild.g:941:1: ( ( rule__Value__Group_2__0 ) )
                    {
                    // InternalKbuild.g:941:1: ( ( rule__Value__Group_2__0 ) )
                    // InternalKbuild.g:942:1: ( rule__Value__Group_2__0 )
                    {
                     before(grammarAccess.getValueAccess().getGroup_2()); 
                    // InternalKbuild.g:943:1: ( rule__Value__Group_2__0 )
                    // InternalKbuild.g:943:2: rule__Value__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Value__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalKbuild.g:950:1: ( ( rule__Value__Group_3__0 ) )
                    {
                    // InternalKbuild.g:950:1: ( ( rule__Value__Group_3__0 ) )
                    // InternalKbuild.g:951:1: ( rule__Value__Group_3__0 )
                    {
                     before(grammarAccess.getValueAccess().getGroup_3()); 
                    // InternalKbuild.g:952:1: ( rule__Value__Group_3__0 )
                    // InternalKbuild.g:952:2: rule__Value__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Value__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalKbuild.g:959:1: ( ( rule__Value__Group_4__0 ) )
                    {
                    // InternalKbuild.g:959:1: ( ( rule__Value__Group_4__0 ) )
                    // InternalKbuild.g:960:1: ( rule__Value__Group_4__0 )
                    {
                     before(grammarAccess.getValueAccess().getGroup_4()); 
                    // InternalKbuild.g:961:1: ( rule__Value__Group_4__0 )
                    // InternalKbuild.g:961:2: rule__Value__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Value__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalKbuild.g:968:1: ( ( rule__Value__Group_5__0 ) )
                    {
                    // InternalKbuild.g:968:1: ( ( rule__Value__Group_5__0 ) )
                    // InternalKbuild.g:969:1: ( rule__Value__Group_5__0 )
                    {
                     before(grammarAccess.getValueAccess().getGroup_5()); 
                    // InternalKbuild.g:970:1: ( rule__Value__Group_5__0 )
                    // InternalKbuild.g:970:2: rule__Value__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Value__Group_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getGroup_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalKbuild.g:977:1: ( ( rule__Value__Group_6__0 ) )
                    {
                    // InternalKbuild.g:977:1: ( ( rule__Value__Group_6__0 ) )
                    // InternalKbuild.g:978:1: ( rule__Value__Group_6__0 )
                    {
                     before(grammarAccess.getValueAccess().getGroup_6()); 
                    // InternalKbuild.g:979:1: ( rule__Value__Group_6__0 )
                    // InternalKbuild.g:979:2: rule__Value__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:990:1: rule__Variable__Alternatives : ( ( ( rule__Variable__Group_0__0 ) ) | ( ( rule__Variable__Group_1__0 ) ) );
    public final void rule__Variable__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:994:1: ( ( ( rule__Variable__Group_0__0 ) ) | ( ( rule__Variable__Group_1__0 ) ) )
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
                    // InternalKbuild.g:996:1: ( ( rule__Variable__Group_0__0 ) )
                    {
                    // InternalKbuild.g:996:1: ( ( rule__Variable__Group_0__0 ) )
                    // InternalKbuild.g:997:1: ( rule__Variable__Group_0__0 )
                    {
                     before(grammarAccess.getVariableAccess().getGroup_0()); 
                    // InternalKbuild.g:998:1: ( rule__Variable__Group_0__0 )
                    // InternalKbuild.g:998:2: rule__Variable__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Variable__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVariableAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalKbuild.g:1005:1: ( ( rule__Variable__Group_1__0 ) )
                    {
                    // InternalKbuild.g:1005:1: ( ( rule__Variable__Group_1__0 ) )
                    // InternalKbuild.g:1006:1: ( rule__Variable__Group_1__0 )
                    {
                     before(grammarAccess.getVariableAccess().getGroup_1()); 
                    // InternalKbuild.g:1007:1: ( rule__Variable__Group_1__0 )
                    // InternalKbuild.g:1007:2: rule__Variable__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1018:1: rule__ShellCmd__Alternatives : ( ( ( rule__ShellCmd__Group_0__0 ) ) | ( ( rule__ShellCmd__Group_1__0 ) ) );
    public final void rule__ShellCmd__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1022:1: ( ( ( rule__ShellCmd__Group_0__0 ) ) | ( ( rule__ShellCmd__Group_1__0 ) ) )
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
                    // InternalKbuild.g:1024:1: ( ( rule__ShellCmd__Group_0__0 ) )
                    {
                    // InternalKbuild.g:1024:1: ( ( rule__ShellCmd__Group_0__0 ) )
                    // InternalKbuild.g:1025:1: ( rule__ShellCmd__Group_0__0 )
                    {
                     before(grammarAccess.getShellCmdAccess().getGroup_0()); 
                    // InternalKbuild.g:1026:1: ( rule__ShellCmd__Group_0__0 )
                    // InternalKbuild.g:1026:2: rule__ShellCmd__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ShellCmd__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getShellCmdAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalKbuild.g:1033:1: ( ( rule__ShellCmd__Group_1__0 ) )
                    {
                    // InternalKbuild.g:1033:1: ( ( rule__ShellCmd__Group_1__0 ) )
                    // InternalKbuild.g:1034:1: ( rule__ShellCmd__Group_1__0 )
                    {
                     before(grammarAccess.getShellCmdAccess().getGroup_1()); 
                    // InternalKbuild.g:1035:1: ( rule__ShellCmd__Group_1__0 )
                    // InternalKbuild.g:1035:2: rule__ShellCmd__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1046:1: rule__ShellPart__Alternatives_1 : ( ( ( rule__ShellPart__ValAssignment_1_0 ) ) | ( ( rule__ShellPart__CmdAssignment_1_1 ) ) | ( RULE_STRING ) | ( RULE_COMMA ) | ( RULE_SHELL_CHAR ) | ( ( rule__ShellPart__Group_1_5__0 ) ) );
    public final void rule__ShellPart__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1050:1: ( ( ( rule__ShellPart__ValAssignment_1_0 ) ) | ( ( rule__ShellPart__CmdAssignment_1_1 ) ) | ( RULE_STRING ) | ( RULE_COMMA ) | ( RULE_SHELL_CHAR ) | ( ( rule__ShellPart__Group_1_5__0 ) ) )
            int alt14=6;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // InternalKbuild.g:1052:1: ( ( rule__ShellPart__ValAssignment_1_0 ) )
                    {
                    // InternalKbuild.g:1052:1: ( ( rule__ShellPart__ValAssignment_1_0 ) )
                    // InternalKbuild.g:1053:1: ( rule__ShellPart__ValAssignment_1_0 )
                    {
                     before(grammarAccess.getShellPartAccess().getValAssignment_1_0()); 
                    // InternalKbuild.g:1054:1: ( rule__ShellPart__ValAssignment_1_0 )
                    // InternalKbuild.g:1054:2: rule__ShellPart__ValAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ShellPart__ValAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getShellPartAccess().getValAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalKbuild.g:1061:1: ( ( rule__ShellPart__CmdAssignment_1_1 ) )
                    {
                    // InternalKbuild.g:1061:1: ( ( rule__ShellPart__CmdAssignment_1_1 ) )
                    // InternalKbuild.g:1062:1: ( rule__ShellPart__CmdAssignment_1_1 )
                    {
                     before(grammarAccess.getShellPartAccess().getCmdAssignment_1_1()); 
                    // InternalKbuild.g:1063:1: ( rule__ShellPart__CmdAssignment_1_1 )
                    // InternalKbuild.g:1063:2: rule__ShellPart__CmdAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ShellPart__CmdAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getShellPartAccess().getCmdAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalKbuild.g:1070:1: ( RULE_STRING )
                    {
                    // InternalKbuild.g:1070:1: ( RULE_STRING )
                    // InternalKbuild.g:1071:1: RULE_STRING
                    {
                     before(grammarAccess.getShellPartAccess().getSTRINGTerminalRuleCall_1_2()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getShellPartAccess().getSTRINGTerminalRuleCall_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalKbuild.g:1079:1: ( RULE_COMMA )
                    {
                    // InternalKbuild.g:1079:1: ( RULE_COMMA )
                    // InternalKbuild.g:1080:1: RULE_COMMA
                    {
                     before(grammarAccess.getShellPartAccess().getCOMMATerminalRuleCall_1_3()); 
                    match(input,RULE_COMMA,FOLLOW_2); 
                     after(grammarAccess.getShellPartAccess().getCOMMATerminalRuleCall_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalKbuild.g:1088:1: ( RULE_SHELL_CHAR )
                    {
                    // InternalKbuild.g:1088:1: ( RULE_SHELL_CHAR )
                    // InternalKbuild.g:1089:1: RULE_SHELL_CHAR
                    {
                     before(grammarAccess.getShellPartAccess().getSHELL_CHARTerminalRuleCall_1_4()); 
                    match(input,RULE_SHELL_CHAR,FOLLOW_2); 
                     after(grammarAccess.getShellPartAccess().getSHELL_CHARTerminalRuleCall_1_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalKbuild.g:1097:1: ( ( rule__ShellPart__Group_1_5__0 ) )
                    {
                    // InternalKbuild.g:1097:1: ( ( rule__ShellPart__Group_1_5__0 ) )
                    // InternalKbuild.g:1098:1: ( rule__ShellPart__Group_1_5__0 )
                    {
                     before(grammarAccess.getShellPartAccess().getGroup_1_5()); 
                    // InternalKbuild.g:1099:1: ( rule__ShellPart__Group_1_5__0 )
                    // InternalKbuild.g:1099:2: rule__ShellPart__Group_1_5__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1110:1: rule__VarSlashSym__Alternatives : ( ( ruleVariable ) | ( ( rule__VarSlashSym__NameAssignment_1 ) ) | ( ( rule__VarSlashSym__NameAssignment_2 ) ) );
    public final void rule__VarSlashSym__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1114:1: ( ( ruleVariable ) | ( ( rule__VarSlashSym__NameAssignment_1 ) ) | ( ( rule__VarSlashSym__NameAssignment_2 ) ) )
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
                    // InternalKbuild.g:1116:1: ( ruleVariable )
                    {
                    // InternalKbuild.g:1116:1: ( ruleVariable )
                    // InternalKbuild.g:1117:1: ruleVariable
                    {
                     before(grammarAccess.getVarSlashSymAccess().getVariableParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleVariable();

                    state._fsp--;

                     after(grammarAccess.getVarSlashSymAccess().getVariableParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalKbuild.g:1125:1: ( ( rule__VarSlashSym__NameAssignment_1 ) )
                    {
                    // InternalKbuild.g:1125:1: ( ( rule__VarSlashSym__NameAssignment_1 ) )
                    // InternalKbuild.g:1126:1: ( rule__VarSlashSym__NameAssignment_1 )
                    {
                     before(grammarAccess.getVarSlashSymAccess().getNameAssignment_1()); 
                    // InternalKbuild.g:1127:1: ( rule__VarSlashSym__NameAssignment_1 )
                    // InternalKbuild.g:1127:2: rule__VarSlashSym__NameAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__VarSlashSym__NameAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getVarSlashSymAccess().getNameAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalKbuild.g:1134:1: ( ( rule__VarSlashSym__NameAssignment_2 ) )
                    {
                    // InternalKbuild.g:1134:1: ( ( rule__VarSlashSym__NameAssignment_2 ) )
                    // InternalKbuild.g:1135:1: ( rule__VarSlashSym__NameAssignment_2 )
                    {
                     before(grammarAccess.getVarSlashSymAccess().getNameAssignment_2()); 
                    // InternalKbuild.g:1136:1: ( rule__VarSlashSym__NameAssignment_2 )
                    // InternalKbuild.g:1136:2: rule__VarSlashSym__NameAssignment_2
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1149:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1153:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalKbuild.g:1154:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalKbuild.g:1161:1: rule__Model__Group__0__Impl : ( () ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1165:1: ( ( () ) )
            // InternalKbuild.g:1167:1: ( () )
            {
            // InternalKbuild.g:1167:1: ( () )
            // InternalKbuild.g:1168:1: ()
            {
             before(grammarAccess.getModelAccess().getModelAction_0()); 
            // InternalKbuild.g:1169:1: ()
            // InternalKbuild.g:1171:1: 
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
    // InternalKbuild.g:1183:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1187:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalKbuild.g:1188:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1195:1: rule__Model__Group__1__Impl : ( ( rule__Model__BuildEntryAssignment_1 )? ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1199:1: ( ( ( rule__Model__BuildEntryAssignment_1 )? ) )
            // InternalKbuild.g:1201:1: ( ( rule__Model__BuildEntryAssignment_1 )? )
            {
            // InternalKbuild.g:1201:1: ( ( rule__Model__BuildEntryAssignment_1 )? )
            // InternalKbuild.g:1202:1: ( rule__Model__BuildEntryAssignment_1 )?
            {
             before(grammarAccess.getModelAccess().getBuildEntryAssignment_1()); 
            // InternalKbuild.g:1203:1: ( rule__Model__BuildEntryAssignment_1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_STRING||(LA16_0>=RULE_SHELL_CHAR && LA16_0<=RULE_IFNDEF)||LA16_0==RULE_OBJ_START||(LA16_0>=RULE_OBJ_Y && LA16_0<=RULE_OBJ_M)||(LA16_0>=RULE_BACKSLASH && LA16_0<=RULE_SYMBOL)||(LA16_0>=RULE_DOLLAR && LA16_0<=RULE_INCLUDE)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalKbuild.g:1203:2: rule__Model__BuildEntryAssignment_1
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1215:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1219:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalKbuild.g:1220:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1227:1: rule__Model__Group__2__Impl : ( ( rule__Model__Group_2__0 )* ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1231:1: ( ( ( rule__Model__Group_2__0 )* ) )
            // InternalKbuild.g:1233:1: ( ( rule__Model__Group_2__0 )* )
            {
            // InternalKbuild.g:1233:1: ( ( rule__Model__Group_2__0 )* )
            // InternalKbuild.g:1234:1: ( rule__Model__Group_2__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_2()); 
            // InternalKbuild.g:1235:1: ( rule__Model__Group_2__0 )*
            loop17:
            do {
                int alt17=2;
                alt17 = dfa17.predict(input);
                switch (alt17) {
            	case 1 :
            	    // InternalKbuild.g:1235:2: rule__Model__Group_2__0
            	    {
            	    pushFollow(FOLLOW_3);
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
    // InternalKbuild.g:1247:1: rule__Model__Group__3 : rule__Model__Group__3__Impl ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1251:1: ( rule__Model__Group__3__Impl )
            // InternalKbuild.g:1252:2: rule__Model__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1258:1: rule__Model__Group__3__Impl : ( ruleEol ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1262:1: ( ( ruleEol ) )
            // InternalKbuild.g:1264:1: ( ruleEol )
            {
            // InternalKbuild.g:1264:1: ( ruleEol )
            // InternalKbuild.g:1265:1: ruleEol
            {
             before(grammarAccess.getModelAccess().getEolParserRuleCall_3()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1286:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1290:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // InternalKbuild.g:1291:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1298:1: rule__Model__Group_2__0__Impl : ( ruleEol ) ;
    public final void rule__Model__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1302:1: ( ( ruleEol ) )
            // InternalKbuild.g:1304:1: ( ruleEol )
            {
            // InternalKbuild.g:1304:1: ( ruleEol )
            // InternalKbuild.g:1305:1: ruleEol
            {
             before(grammarAccess.getModelAccess().getEolParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1318:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1322:1: ( rule__Model__Group_2__1__Impl )
            // InternalKbuild.g:1323:2: rule__Model__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1329:1: rule__Model__Group_2__1__Impl : ( ( rule__Model__BuildEntryAssignment_2_1 ) ) ;
    public final void rule__Model__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1333:1: ( ( ( rule__Model__BuildEntryAssignment_2_1 ) ) )
            // InternalKbuild.g:1335:1: ( ( rule__Model__BuildEntryAssignment_2_1 ) )
            {
            // InternalKbuild.g:1335:1: ( ( rule__Model__BuildEntryAssignment_2_1 ) )
            // InternalKbuild.g:1336:1: ( rule__Model__BuildEntryAssignment_2_1 )
            {
             before(grammarAccess.getModelAccess().getBuildEntryAssignment_2_1()); 
            // InternalKbuild.g:1337:1: ( rule__Model__BuildEntryAssignment_2_1 )
            // InternalKbuild.g:1337:2: rule__Model__BuildEntryAssignment_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1353:1: rule__BuildEntry__Group_0__0 : rule__BuildEntry__Group_0__0__Impl rule__BuildEntry__Group_0__1 ;
    public final void rule__BuildEntry__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1357:1: ( rule__BuildEntry__Group_0__0__Impl rule__BuildEntry__Group_0__1 )
            // InternalKbuild.g:1358:2: rule__BuildEntry__Group_0__0__Impl rule__BuildEntry__Group_0__1
            {
            pushFollow(FOLLOW_6);
            rule__BuildEntry__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1365:1: rule__BuildEntry__Group_0__0__Impl : ( () ) ;
    public final void rule__BuildEntry__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1369:1: ( ( () ) )
            // InternalKbuild.g:1371:1: ( () )
            {
            // InternalKbuild.g:1371:1: ( () )
            // InternalKbuild.g:1372:1: ()
            {
             before(grammarAccess.getBuildEntryAccess().getBuildEntryAction_0_0()); 
            // InternalKbuild.g:1373:1: ()
            // InternalKbuild.g:1375:1: 
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
    // InternalKbuild.g:1387:1: rule__BuildEntry__Group_0__1 : rule__BuildEntry__Group_0__1__Impl ;
    public final void rule__BuildEntry__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1391:1: ( rule__BuildEntry__Group_0__1__Impl )
            // InternalKbuild.g:1392:2: rule__BuildEntry__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1398:1: rule__BuildEntry__Group_0__1__Impl : ( ( rule__BuildEntry__ValueAssignment_0_1 ) ) ;
    public final void rule__BuildEntry__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1402:1: ( ( ( rule__BuildEntry__ValueAssignment_0_1 ) ) )
            // InternalKbuild.g:1404:1: ( ( rule__BuildEntry__ValueAssignment_0_1 ) )
            {
            // InternalKbuild.g:1404:1: ( ( rule__BuildEntry__ValueAssignment_0_1 ) )
            // InternalKbuild.g:1405:1: ( rule__BuildEntry__ValueAssignment_0_1 )
            {
             before(grammarAccess.getBuildEntryAccess().getValueAssignment_0_1()); 
            // InternalKbuild.g:1406:1: ( rule__BuildEntry__ValueAssignment_0_1 )
            // InternalKbuild.g:1406:2: rule__BuildEntry__ValueAssignment_0_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1422:1: rule__BuildEntry__Group_1__0 : rule__BuildEntry__Group_1__0__Impl rule__BuildEntry__Group_1__1 ;
    public final void rule__BuildEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1426:1: ( rule__BuildEntry__Group_1__0__Impl rule__BuildEntry__Group_1__1 )
            // InternalKbuild.g:1427:2: rule__BuildEntry__Group_1__0__Impl rule__BuildEntry__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__BuildEntry__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1434:1: rule__BuildEntry__Group_1__0__Impl : ( () ) ;
    public final void rule__BuildEntry__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1438:1: ( ( () ) )
            // InternalKbuild.g:1440:1: ( () )
            {
            // InternalKbuild.g:1440:1: ( () )
            // InternalKbuild.g:1441:1: ()
            {
             before(grammarAccess.getBuildEntryAccess().getIfEqAction_1_0()); 
            // InternalKbuild.g:1442:1: ()
            // InternalKbuild.g:1444:1: 
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
    // InternalKbuild.g:1456:1: rule__BuildEntry__Group_1__1 : rule__BuildEntry__Group_1__1__Impl rule__BuildEntry__Group_1__2 ;
    public final void rule__BuildEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1460:1: ( rule__BuildEntry__Group_1__1__Impl rule__BuildEntry__Group_1__2 )
            // InternalKbuild.g:1461:2: rule__BuildEntry__Group_1__1__Impl rule__BuildEntry__Group_1__2
            {
            pushFollow(FOLLOW_8);
            rule__BuildEntry__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1468:1: rule__BuildEntry__Group_1__1__Impl : ( RULE_IFEQ ) ;
    public final void rule__BuildEntry__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1472:1: ( ( RULE_IFEQ ) )
            // InternalKbuild.g:1474:1: ( RULE_IFEQ )
            {
            // InternalKbuild.g:1474:1: ( RULE_IFEQ )
            // InternalKbuild.g:1475:1: RULE_IFEQ
            {
             before(grammarAccess.getBuildEntryAccess().getIFEQTerminalRuleCall_1_1()); 
            match(input,RULE_IFEQ,FOLLOW_2); 
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
    // InternalKbuild.g:1488:1: rule__BuildEntry__Group_1__2 : rule__BuildEntry__Group_1__2__Impl ;
    public final void rule__BuildEntry__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1492:1: ( rule__BuildEntry__Group_1__2__Impl )
            // InternalKbuild.g:1493:2: rule__BuildEntry__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1499:1: rule__BuildEntry__Group_1__2__Impl : ( ( rule__BuildEntry__ValueAssignment_1_2 ) ) ;
    public final void rule__BuildEntry__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1503:1: ( ( ( rule__BuildEntry__ValueAssignment_1_2 ) ) )
            // InternalKbuild.g:1505:1: ( ( rule__BuildEntry__ValueAssignment_1_2 ) )
            {
            // InternalKbuild.g:1505:1: ( ( rule__BuildEntry__ValueAssignment_1_2 ) )
            // InternalKbuild.g:1506:1: ( rule__BuildEntry__ValueAssignment_1_2 )
            {
             before(grammarAccess.getBuildEntryAccess().getValueAssignment_1_2()); 
            // InternalKbuild.g:1507:1: ( rule__BuildEntry__ValueAssignment_1_2 )
            // InternalKbuild.g:1507:2: rule__BuildEntry__ValueAssignment_1_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1525:1: rule__BuildEntry__Group_2__0 : rule__BuildEntry__Group_2__0__Impl rule__BuildEntry__Group_2__1 ;
    public final void rule__BuildEntry__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1529:1: ( rule__BuildEntry__Group_2__0__Impl rule__BuildEntry__Group_2__1 )
            // InternalKbuild.g:1530:2: rule__BuildEntry__Group_2__0__Impl rule__BuildEntry__Group_2__1
            {
            pushFollow(FOLLOW_9);
            rule__BuildEntry__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1537:1: rule__BuildEntry__Group_2__0__Impl : ( () ) ;
    public final void rule__BuildEntry__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1541:1: ( ( () ) )
            // InternalKbuild.g:1543:1: ( () )
            {
            // InternalKbuild.g:1543:1: ( () )
            // InternalKbuild.g:1544:1: ()
            {
             before(grammarAccess.getBuildEntryAccess().getIfNEqAction_2_0()); 
            // InternalKbuild.g:1545:1: ()
            // InternalKbuild.g:1547:1: 
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
    // InternalKbuild.g:1559:1: rule__BuildEntry__Group_2__1 : rule__BuildEntry__Group_2__1__Impl rule__BuildEntry__Group_2__2 ;
    public final void rule__BuildEntry__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1563:1: ( rule__BuildEntry__Group_2__1__Impl rule__BuildEntry__Group_2__2 )
            // InternalKbuild.g:1564:2: rule__BuildEntry__Group_2__1__Impl rule__BuildEntry__Group_2__2
            {
            pushFollow(FOLLOW_8);
            rule__BuildEntry__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1571:1: rule__BuildEntry__Group_2__1__Impl : ( RULE_IFNEQ ) ;
    public final void rule__BuildEntry__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1575:1: ( ( RULE_IFNEQ ) )
            // InternalKbuild.g:1577:1: ( RULE_IFNEQ )
            {
            // InternalKbuild.g:1577:1: ( RULE_IFNEQ )
            // InternalKbuild.g:1578:1: RULE_IFNEQ
            {
             before(grammarAccess.getBuildEntryAccess().getIFNEQTerminalRuleCall_2_1()); 
            match(input,RULE_IFNEQ,FOLLOW_2); 
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
    // InternalKbuild.g:1591:1: rule__BuildEntry__Group_2__2 : rule__BuildEntry__Group_2__2__Impl ;
    public final void rule__BuildEntry__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1595:1: ( rule__BuildEntry__Group_2__2__Impl )
            // InternalKbuild.g:1596:2: rule__BuildEntry__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1602:1: rule__BuildEntry__Group_2__2__Impl : ( ( rule__BuildEntry__ValueAssignment_2_2 ) ) ;
    public final void rule__BuildEntry__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1606:1: ( ( ( rule__BuildEntry__ValueAssignment_2_2 ) ) )
            // InternalKbuild.g:1608:1: ( ( rule__BuildEntry__ValueAssignment_2_2 ) )
            {
            // InternalKbuild.g:1608:1: ( ( rule__BuildEntry__ValueAssignment_2_2 ) )
            // InternalKbuild.g:1609:1: ( rule__BuildEntry__ValueAssignment_2_2 )
            {
             before(grammarAccess.getBuildEntryAccess().getValueAssignment_2_2()); 
            // InternalKbuild.g:1610:1: ( rule__BuildEntry__ValueAssignment_2_2 )
            // InternalKbuild.g:1610:2: rule__BuildEntry__ValueAssignment_2_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1628:1: rule__BuildEntry__Group_3__0 : rule__BuildEntry__Group_3__0__Impl rule__BuildEntry__Group_3__1 ;
    public final void rule__BuildEntry__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1632:1: ( rule__BuildEntry__Group_3__0__Impl rule__BuildEntry__Group_3__1 )
            // InternalKbuild.g:1633:2: rule__BuildEntry__Group_3__0__Impl rule__BuildEntry__Group_3__1
            {
            pushFollow(FOLLOW_10);
            rule__BuildEntry__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1640:1: rule__BuildEntry__Group_3__0__Impl : ( () ) ;
    public final void rule__BuildEntry__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1644:1: ( ( () ) )
            // InternalKbuild.g:1646:1: ( () )
            {
            // InternalKbuild.g:1646:1: ( () )
            // InternalKbuild.g:1647:1: ()
            {
             before(grammarAccess.getBuildEntryAccess().getIfndefAction_3_0()); 
            // InternalKbuild.g:1648:1: ()
            // InternalKbuild.g:1650:1: 
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
    // InternalKbuild.g:1662:1: rule__BuildEntry__Group_3__1 : rule__BuildEntry__Group_3__1__Impl rule__BuildEntry__Group_3__2 ;
    public final void rule__BuildEntry__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1666:1: ( rule__BuildEntry__Group_3__1__Impl rule__BuildEntry__Group_3__2 )
            // InternalKbuild.g:1667:2: rule__BuildEntry__Group_3__1__Impl rule__BuildEntry__Group_3__2
            {
            pushFollow(FOLLOW_11);
            rule__BuildEntry__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1674:1: rule__BuildEntry__Group_3__1__Impl : ( RULE_IFNDEF ) ;
    public final void rule__BuildEntry__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1678:1: ( ( RULE_IFNDEF ) )
            // InternalKbuild.g:1680:1: ( RULE_IFNDEF )
            {
            // InternalKbuild.g:1680:1: ( RULE_IFNDEF )
            // InternalKbuild.g:1681:1: RULE_IFNDEF
            {
             before(grammarAccess.getBuildEntryAccess().getIFNDEFTerminalRuleCall_3_1()); 
            match(input,RULE_IFNDEF,FOLLOW_2); 
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
    // InternalKbuild.g:1694:1: rule__BuildEntry__Group_3__2 : rule__BuildEntry__Group_3__2__Impl rule__BuildEntry__Group_3__3 ;
    public final void rule__BuildEntry__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1698:1: ( rule__BuildEntry__Group_3__2__Impl rule__BuildEntry__Group_3__3 )
            // InternalKbuild.g:1699:2: rule__BuildEntry__Group_3__2__Impl rule__BuildEntry__Group_3__3
            {
            pushFollow(FOLLOW_12);
            rule__BuildEntry__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1706:1: rule__BuildEntry__Group_3__2__Impl : ( ( rule__BuildEntry__NameAssignment_3_2 ) ) ;
    public final void rule__BuildEntry__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1710:1: ( ( ( rule__BuildEntry__NameAssignment_3_2 ) ) )
            // InternalKbuild.g:1712:1: ( ( rule__BuildEntry__NameAssignment_3_2 ) )
            {
            // InternalKbuild.g:1712:1: ( ( rule__BuildEntry__NameAssignment_3_2 ) )
            // InternalKbuild.g:1713:1: ( rule__BuildEntry__NameAssignment_3_2 )
            {
             before(grammarAccess.getBuildEntryAccess().getNameAssignment_3_2()); 
            // InternalKbuild.g:1714:1: ( rule__BuildEntry__NameAssignment_3_2 )
            // InternalKbuild.g:1714:2: rule__BuildEntry__NameAssignment_3_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1726:1: rule__BuildEntry__Group_3__3 : rule__BuildEntry__Group_3__3__Impl rule__BuildEntry__Group_3__4 ;
    public final void rule__BuildEntry__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1730:1: ( rule__BuildEntry__Group_3__3__Impl rule__BuildEntry__Group_3__4 )
            // InternalKbuild.g:1731:2: rule__BuildEntry__Group_3__3__Impl rule__BuildEntry__Group_3__4
            {
            pushFollow(FOLLOW_13);
            rule__BuildEntry__Group_3__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1738:1: rule__BuildEntry__Group_3__3__Impl : ( ruleEol ) ;
    public final void rule__BuildEntry__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1742:1: ( ( ruleEol ) )
            // InternalKbuild.g:1744:1: ( ruleEol )
            {
            // InternalKbuild.g:1744:1: ( ruleEol )
            // InternalKbuild.g:1745:1: ruleEol
            {
             before(grammarAccess.getBuildEntryAccess().getEolParserRuleCall_3_3()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1758:1: rule__BuildEntry__Group_3__4 : rule__BuildEntry__Group_3__4__Impl rule__BuildEntry__Group_3__5 ;
    public final void rule__BuildEntry__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1762:1: ( rule__BuildEntry__Group_3__4__Impl rule__BuildEntry__Group_3__5 )
            // InternalKbuild.g:1763:2: rule__BuildEntry__Group_3__4__Impl rule__BuildEntry__Group_3__5
            {
            pushFollow(FOLLOW_12);
            rule__BuildEntry__Group_3__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1770:1: rule__BuildEntry__Group_3__4__Impl : ( ( rule__BuildEntry__Alternatives_3_4 ) ) ;
    public final void rule__BuildEntry__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1774:1: ( ( ( rule__BuildEntry__Alternatives_3_4 ) ) )
            // InternalKbuild.g:1776:1: ( ( rule__BuildEntry__Alternatives_3_4 ) )
            {
            // InternalKbuild.g:1776:1: ( ( rule__BuildEntry__Alternatives_3_4 ) )
            // InternalKbuild.g:1777:1: ( rule__BuildEntry__Alternatives_3_4 )
            {
             before(grammarAccess.getBuildEntryAccess().getAlternatives_3_4()); 
            // InternalKbuild.g:1778:1: ( rule__BuildEntry__Alternatives_3_4 )
            // InternalKbuild.g:1778:2: rule__BuildEntry__Alternatives_3_4
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1790:1: rule__BuildEntry__Group_3__5 : rule__BuildEntry__Group_3__5__Impl rule__BuildEntry__Group_3__6 ;
    public final void rule__BuildEntry__Group_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1794:1: ( rule__BuildEntry__Group_3__5__Impl rule__BuildEntry__Group_3__6 )
            // InternalKbuild.g:1795:2: rule__BuildEntry__Group_3__5__Impl rule__BuildEntry__Group_3__6
            {
            pushFollow(FOLLOW_14);
            rule__BuildEntry__Group_3__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1802:1: rule__BuildEntry__Group_3__5__Impl : ( ruleEol ) ;
    public final void rule__BuildEntry__Group_3__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1806:1: ( ( ruleEol ) )
            // InternalKbuild.g:1808:1: ( ruleEol )
            {
            // InternalKbuild.g:1808:1: ( ruleEol )
            // InternalKbuild.g:1809:1: ruleEol
            {
             before(grammarAccess.getBuildEntryAccess().getEolParserRuleCall_3_5()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1822:1: rule__BuildEntry__Group_3__6 : rule__BuildEntry__Group_3__6__Impl ;
    public final void rule__BuildEntry__Group_3__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1826:1: ( rule__BuildEntry__Group_3__6__Impl )
            // InternalKbuild.g:1827:2: rule__BuildEntry__Group_3__6__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1833:1: rule__BuildEntry__Group_3__6__Impl : ( RULE_ENDIF ) ;
    public final void rule__BuildEntry__Group_3__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1837:1: ( ( RULE_ENDIF ) )
            // InternalKbuild.g:1839:1: ( RULE_ENDIF )
            {
            // InternalKbuild.g:1839:1: ( RULE_ENDIF )
            // InternalKbuild.g:1840:1: RULE_ENDIF
            {
             before(grammarAccess.getBuildEntryAccess().getENDIFTerminalRuleCall_3_6()); 
            match(input,RULE_ENDIF,FOLLOW_2); 
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
    // InternalKbuild.g:1867:1: rule__BuildEntry__Group_4__0 : rule__BuildEntry__Group_4__0__Impl rule__BuildEntry__Group_4__1 ;
    public final void rule__BuildEntry__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1871:1: ( rule__BuildEntry__Group_4__0__Impl rule__BuildEntry__Group_4__1 )
            // InternalKbuild.g:1872:2: rule__BuildEntry__Group_4__0__Impl rule__BuildEntry__Group_4__1
            {
            pushFollow(FOLLOW_11);
            rule__BuildEntry__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1879:1: rule__BuildEntry__Group_4__0__Impl : ( () ) ;
    public final void rule__BuildEntry__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1883:1: ( ( () ) )
            // InternalKbuild.g:1885:1: ( () )
            {
            // InternalKbuild.g:1885:1: ( () )
            // InternalKbuild.g:1886:1: ()
            {
             before(grammarAccess.getBuildEntryAccess().getHostProgramAction_4_0()); 
            // InternalKbuild.g:1887:1: ()
            // InternalKbuild.g:1889:1: 
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
    // InternalKbuild.g:1901:1: rule__BuildEntry__Group_4__1 : rule__BuildEntry__Group_4__1__Impl rule__BuildEntry__Group_4__2 ;
    public final void rule__BuildEntry__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1905:1: ( rule__BuildEntry__Group_4__1__Impl rule__BuildEntry__Group_4__2 )
            // InternalKbuild.g:1906:2: rule__BuildEntry__Group_4__1__Impl rule__BuildEntry__Group_4__2
            {
            pushFollow(FOLLOW_15);
            rule__BuildEntry__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1913:1: rule__BuildEntry__Group_4__1__Impl : ( ( rule__BuildEntry__NameAssignment_4_1 ) ) ;
    public final void rule__BuildEntry__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1917:1: ( ( ( rule__BuildEntry__NameAssignment_4_1 ) ) )
            // InternalKbuild.g:1919:1: ( ( rule__BuildEntry__NameAssignment_4_1 ) )
            {
            // InternalKbuild.g:1919:1: ( ( rule__BuildEntry__NameAssignment_4_1 ) )
            // InternalKbuild.g:1920:1: ( rule__BuildEntry__NameAssignment_4_1 )
            {
             before(grammarAccess.getBuildEntryAccess().getNameAssignment_4_1()); 
            // InternalKbuild.g:1921:1: ( rule__BuildEntry__NameAssignment_4_1 )
            // InternalKbuild.g:1921:2: rule__BuildEntry__NameAssignment_4_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1933:1: rule__BuildEntry__Group_4__2 : rule__BuildEntry__Group_4__2__Impl rule__BuildEntry__Group_4__3 ;
    public final void rule__BuildEntry__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1937:1: ( rule__BuildEntry__Group_4__2__Impl rule__BuildEntry__Group_4__3 )
            // InternalKbuild.g:1938:2: rule__BuildEntry__Group_4__2__Impl rule__BuildEntry__Group_4__3
            {
            pushFollow(FOLLOW_15);
            rule__BuildEntry__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1945:1: rule__BuildEntry__Group_4__2__Impl : ( ( rule__BuildEntry__VariableAssignment_4_2 )? ) ;
    public final void rule__BuildEntry__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1949:1: ( ( ( rule__BuildEntry__VariableAssignment_4_2 )? ) )
            // InternalKbuild.g:1951:1: ( ( rule__BuildEntry__VariableAssignment_4_2 )? )
            {
            // InternalKbuild.g:1951:1: ( ( rule__BuildEntry__VariableAssignment_4_2 )? )
            // InternalKbuild.g:1952:1: ( rule__BuildEntry__VariableAssignment_4_2 )?
            {
             before(grammarAccess.getBuildEntryAccess().getVariableAssignment_4_2()); 
            // InternalKbuild.g:1953:1: ( rule__BuildEntry__VariableAssignment_4_2 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_DOLLAR) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalKbuild.g:1953:2: rule__BuildEntry__VariableAssignment_4_2
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1965:1: rule__BuildEntry__Group_4__3 : rule__BuildEntry__Group_4__3__Impl rule__BuildEntry__Group_4__4 ;
    public final void rule__BuildEntry__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1969:1: ( rule__BuildEntry__Group_4__3__Impl rule__BuildEntry__Group_4__4 )
            // InternalKbuild.g:1970:2: rule__BuildEntry__Group_4__3__Impl rule__BuildEntry__Group_4__4
            {
            pushFollow(FOLLOW_16);
            rule__BuildEntry__Group_4__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1977:1: rule__BuildEntry__Group_4__3__Impl : ( ( rule__BuildEntry__ValueAssignment_4_3 ) ) ;
    public final void rule__BuildEntry__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:1981:1: ( ( ( rule__BuildEntry__ValueAssignment_4_3 ) ) )
            // InternalKbuild.g:1983:1: ( ( rule__BuildEntry__ValueAssignment_4_3 ) )
            {
            // InternalKbuild.g:1983:1: ( ( rule__BuildEntry__ValueAssignment_4_3 ) )
            // InternalKbuild.g:1984:1: ( rule__BuildEntry__ValueAssignment_4_3 )
            {
             before(grammarAccess.getBuildEntryAccess().getValueAssignment_4_3()); 
            // InternalKbuild.g:1985:1: ( rule__BuildEntry__ValueAssignment_4_3 )
            // InternalKbuild.g:1985:2: rule__BuildEntry__ValueAssignment_4_3
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:1997:1: rule__BuildEntry__Group_4__4 : rule__BuildEntry__Group_4__4__Impl ;
    public final void rule__BuildEntry__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2001:1: ( rule__BuildEntry__Group_4__4__Impl )
            // InternalKbuild.g:2002:2: rule__BuildEntry__Group_4__4__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2008:1: rule__BuildEntry__Group_4__4__Impl : ( ( rule__BuildEntry__InnerAssignment_4_4 )? ) ;
    public final void rule__BuildEntry__Group_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2012:1: ( ( ( rule__BuildEntry__InnerAssignment_4_4 )? ) )
            // InternalKbuild.g:2014:1: ( ( rule__BuildEntry__InnerAssignment_4_4 )? )
            {
            // InternalKbuild.g:2014:1: ( ( rule__BuildEntry__InnerAssignment_4_4 )? )
            // InternalKbuild.g:2015:1: ( rule__BuildEntry__InnerAssignment_4_4 )?
            {
             before(grammarAccess.getBuildEntryAccess().getInnerAssignment_4_4()); 
            // InternalKbuild.g:2016:1: ( rule__BuildEntry__InnerAssignment_4_4 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_EQ) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalKbuild.g:2016:2: rule__BuildEntry__InnerAssignment_4_4
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2038:1: rule__BuildEntry__Group_5__0 : rule__BuildEntry__Group_5__0__Impl rule__BuildEntry__Group_5__1 ;
    public final void rule__BuildEntry__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2042:1: ( rule__BuildEntry__Group_5__0__Impl rule__BuildEntry__Group_5__1 )
            // InternalKbuild.g:2043:2: rule__BuildEntry__Group_5__0__Impl rule__BuildEntry__Group_5__1
            {
            pushFollow(FOLLOW_13);
            rule__BuildEntry__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2050:1: rule__BuildEntry__Group_5__0__Impl : ( () ) ;
    public final void rule__BuildEntry__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2054:1: ( ( () ) )
            // InternalKbuild.g:2056:1: ( () )
            {
            // InternalKbuild.g:2056:1: ( () )
            // InternalKbuild.g:2057:1: ()
            {
             before(grammarAccess.getBuildEntryAccess().getObjectAction_5_0()); 
            // InternalKbuild.g:2058:1: ()
            // InternalKbuild.g:2060:1: 
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
    // InternalKbuild.g:2072:1: rule__BuildEntry__Group_5__1 : rule__BuildEntry__Group_5__1__Impl ;
    public final void rule__BuildEntry__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2076:1: ( rule__BuildEntry__Group_5__1__Impl )
            // InternalKbuild.g:2077:2: rule__BuildEntry__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2083:1: rule__BuildEntry__Group_5__1__Impl : ( ( rule__BuildEntry__Alternatives_5_1 ) ) ;
    public final void rule__BuildEntry__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2087:1: ( ( ( rule__BuildEntry__Alternatives_5_1 ) ) )
            // InternalKbuild.g:2089:1: ( ( rule__BuildEntry__Alternatives_5_1 ) )
            {
            // InternalKbuild.g:2089:1: ( ( rule__BuildEntry__Alternatives_5_1 ) )
            // InternalKbuild.g:2090:1: ( rule__BuildEntry__Alternatives_5_1 )
            {
             before(grammarAccess.getBuildEntryAccess().getAlternatives_5_1()); 
            // InternalKbuild.g:2091:1: ( rule__BuildEntry__Alternatives_5_1 )
            // InternalKbuild.g:2091:2: rule__BuildEntry__Alternatives_5_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2107:1: rule__BuildEntry__Group_6__0 : rule__BuildEntry__Group_6__0__Impl rule__BuildEntry__Group_6__1 ;
    public final void rule__BuildEntry__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2111:1: ( rule__BuildEntry__Group_6__0__Impl rule__BuildEntry__Group_6__1 )
            // InternalKbuild.g:2112:2: rule__BuildEntry__Group_6__0__Impl rule__BuildEntry__Group_6__1
            {
            pushFollow(FOLLOW_17);
            rule__BuildEntry__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2119:1: rule__BuildEntry__Group_6__0__Impl : ( () ) ;
    public final void rule__BuildEntry__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2123:1: ( ( () ) )
            // InternalKbuild.g:2125:1: ( () )
            {
            // InternalKbuild.g:2125:1: ( () )
            // InternalKbuild.g:2126:1: ()
            {
             before(grammarAccess.getBuildEntryAccess().getTargetAction_6_0()); 
            // InternalKbuild.g:2127:1: ()
            // InternalKbuild.g:2129:1: 
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
    // InternalKbuild.g:2141:1: rule__BuildEntry__Group_6__1 : rule__BuildEntry__Group_6__1__Impl rule__BuildEntry__Group_6__2 ;
    public final void rule__BuildEntry__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2145:1: ( rule__BuildEntry__Group_6__1__Impl rule__BuildEntry__Group_6__2 )
            // InternalKbuild.g:2146:2: rule__BuildEntry__Group_6__1__Impl rule__BuildEntry__Group_6__2
            {
            pushFollow(FOLLOW_18);
            rule__BuildEntry__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2153:1: rule__BuildEntry__Group_6__1__Impl : ( ( rule__BuildEntry__TargetAssignment_6_1 ) ) ;
    public final void rule__BuildEntry__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2157:1: ( ( ( rule__BuildEntry__TargetAssignment_6_1 ) ) )
            // InternalKbuild.g:2159:1: ( ( rule__BuildEntry__TargetAssignment_6_1 ) )
            {
            // InternalKbuild.g:2159:1: ( ( rule__BuildEntry__TargetAssignment_6_1 ) )
            // InternalKbuild.g:2160:1: ( rule__BuildEntry__TargetAssignment_6_1 )
            {
             before(grammarAccess.getBuildEntryAccess().getTargetAssignment_6_1()); 
            // InternalKbuild.g:2161:1: ( rule__BuildEntry__TargetAssignment_6_1 )
            // InternalKbuild.g:2161:2: rule__BuildEntry__TargetAssignment_6_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2173:1: rule__BuildEntry__Group_6__2 : rule__BuildEntry__Group_6__2__Impl rule__BuildEntry__Group_6__3 ;
    public final void rule__BuildEntry__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2177:1: ( rule__BuildEntry__Group_6__2__Impl rule__BuildEntry__Group_6__3 )
            // InternalKbuild.g:2178:2: rule__BuildEntry__Group_6__2__Impl rule__BuildEntry__Group_6__3
            {
            pushFollow(FOLLOW_19);
            rule__BuildEntry__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2185:1: rule__BuildEntry__Group_6__2__Impl : ( RULE_DPOINT ) ;
    public final void rule__BuildEntry__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2189:1: ( ( RULE_DPOINT ) )
            // InternalKbuild.g:2191:1: ( RULE_DPOINT )
            {
            // InternalKbuild.g:2191:1: ( RULE_DPOINT )
            // InternalKbuild.g:2192:1: RULE_DPOINT
            {
             before(grammarAccess.getBuildEntryAccess().getDPOINTTerminalRuleCall_6_2()); 
            match(input,RULE_DPOINT,FOLLOW_2); 
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
    // InternalKbuild.g:2205:1: rule__BuildEntry__Group_6__3 : rule__BuildEntry__Group_6__3__Impl ;
    public final void rule__BuildEntry__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2209:1: ( rule__BuildEntry__Group_6__3__Impl )
            // InternalKbuild.g:2210:2: rule__BuildEntry__Group_6__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2216:1: rule__BuildEntry__Group_6__3__Impl : ( ( rule__BuildEntry__Alternatives_6_3 ) ) ;
    public final void rule__BuildEntry__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2220:1: ( ( ( rule__BuildEntry__Alternatives_6_3 ) ) )
            // InternalKbuild.g:2222:1: ( ( rule__BuildEntry__Alternatives_6_3 ) )
            {
            // InternalKbuild.g:2222:1: ( ( rule__BuildEntry__Alternatives_6_3 ) )
            // InternalKbuild.g:2223:1: ( rule__BuildEntry__Alternatives_6_3 )
            {
             before(grammarAccess.getBuildEntryAccess().getAlternatives_6_3()); 
            // InternalKbuild.g:2224:1: ( rule__BuildEntry__Alternatives_6_3 )
            // InternalKbuild.g:2224:2: rule__BuildEntry__Alternatives_6_3
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2244:1: rule__BuildEntry__Group_6_3_1__0 : rule__BuildEntry__Group_6_3_1__0__Impl rule__BuildEntry__Group_6_3_1__1 ;
    public final void rule__BuildEntry__Group_6_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2248:1: ( rule__BuildEntry__Group_6_3_1__0__Impl rule__BuildEntry__Group_6_3_1__1 )
            // InternalKbuild.g:2249:2: rule__BuildEntry__Group_6_3_1__0__Impl rule__BuildEntry__Group_6_3_1__1
            {
            pushFollow(FOLLOW_12);
            rule__BuildEntry__Group_6_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2256:1: rule__BuildEntry__Group_6_3_1__0__Impl : ( ( rule__BuildEntry__ValuesAssignment_6_3_1_0 ) ) ;
    public final void rule__BuildEntry__Group_6_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2260:1: ( ( ( rule__BuildEntry__ValuesAssignment_6_3_1_0 ) ) )
            // InternalKbuild.g:2262:1: ( ( rule__BuildEntry__ValuesAssignment_6_3_1_0 ) )
            {
            // InternalKbuild.g:2262:1: ( ( rule__BuildEntry__ValuesAssignment_6_3_1_0 ) )
            // InternalKbuild.g:2263:1: ( rule__BuildEntry__ValuesAssignment_6_3_1_0 )
            {
             before(grammarAccess.getBuildEntryAccess().getValuesAssignment_6_3_1_0()); 
            // InternalKbuild.g:2264:1: ( rule__BuildEntry__ValuesAssignment_6_3_1_0 )
            // InternalKbuild.g:2264:2: rule__BuildEntry__ValuesAssignment_6_3_1_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2276:1: rule__BuildEntry__Group_6_3_1__1 : rule__BuildEntry__Group_6_3_1__1__Impl ;
    public final void rule__BuildEntry__Group_6_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2280:1: ( rule__BuildEntry__Group_6_3_1__1__Impl )
            // InternalKbuild.g:2281:2: rule__BuildEntry__Group_6_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2287:1: rule__BuildEntry__Group_6_3_1__1__Impl : ( ( rule__BuildEntry__Group_6_3_1_1__0 )* ) ;
    public final void rule__BuildEntry__Group_6_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2291:1: ( ( ( rule__BuildEntry__Group_6_3_1_1__0 )* ) )
            // InternalKbuild.g:2293:1: ( ( rule__BuildEntry__Group_6_3_1_1__0 )* )
            {
            // InternalKbuild.g:2293:1: ( ( rule__BuildEntry__Group_6_3_1_1__0 )* )
            // InternalKbuild.g:2294:1: ( rule__BuildEntry__Group_6_3_1_1__0 )*
            {
             before(grammarAccess.getBuildEntryAccess().getGroup_6_3_1_1()); 
            // InternalKbuild.g:2295:1: ( rule__BuildEntry__Group_6_3_1_1__0 )*
            loop20:
            do {
                int alt20=2;
                alt20 = dfa20.predict(input);
                switch (alt20) {
            	case 1 :
            	    // InternalKbuild.g:2295:2: rule__BuildEntry__Group_6_3_1_1__0
            	    {
            	    pushFollow(FOLLOW_3);
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
    // InternalKbuild.g:2311:1: rule__BuildEntry__Group_6_3_1_1__0 : rule__BuildEntry__Group_6_3_1_1__0__Impl rule__BuildEntry__Group_6_3_1_1__1 ;
    public final void rule__BuildEntry__Group_6_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2315:1: ( rule__BuildEntry__Group_6_3_1_1__0__Impl rule__BuildEntry__Group_6_3_1_1__1 )
            // InternalKbuild.g:2316:2: rule__BuildEntry__Group_6_3_1_1__0__Impl rule__BuildEntry__Group_6_3_1_1__1
            {
            pushFollow(FOLLOW_20);
            rule__BuildEntry__Group_6_3_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2323:1: rule__BuildEntry__Group_6_3_1_1__0__Impl : ( ruleEol ) ;
    public final void rule__BuildEntry__Group_6_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2327:1: ( ( ruleEol ) )
            // InternalKbuild.g:2329:1: ( ruleEol )
            {
            // InternalKbuild.g:2329:1: ( ruleEol )
            // InternalKbuild.g:2330:1: ruleEol
            {
             before(grammarAccess.getBuildEntryAccess().getEolParserRuleCall_6_3_1_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2343:1: rule__BuildEntry__Group_6_3_1_1__1 : rule__BuildEntry__Group_6_3_1_1__1__Impl rule__BuildEntry__Group_6_3_1_1__2 ;
    public final void rule__BuildEntry__Group_6_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2347:1: ( rule__BuildEntry__Group_6_3_1_1__1__Impl rule__BuildEntry__Group_6_3_1_1__2 )
            // InternalKbuild.g:2348:2: rule__BuildEntry__Group_6_3_1_1__1__Impl rule__BuildEntry__Group_6_3_1_1__2
            {
            pushFollow(FOLLOW_17);
            rule__BuildEntry__Group_6_3_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2355:1: rule__BuildEntry__Group_6_3_1_1__1__Impl : ( ( ( RULE_TAB ) ) ( ( RULE_TAB )* ) ) ;
    public final void rule__BuildEntry__Group_6_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2359:1: ( ( ( ( RULE_TAB ) ) ( ( RULE_TAB )* ) ) )
            // InternalKbuild.g:2361:1: ( ( ( RULE_TAB ) ) ( ( RULE_TAB )* ) )
            {
            // InternalKbuild.g:2361:1: ( ( ( RULE_TAB ) ) ( ( RULE_TAB )* ) )
            // InternalKbuild.g:2362:1: ( ( RULE_TAB ) ) ( ( RULE_TAB )* )
            {
            // InternalKbuild.g:2362:1: ( ( RULE_TAB ) )
            // InternalKbuild.g:2363:1: ( RULE_TAB )
            {
             before(grammarAccess.getBuildEntryAccess().getTABTerminalRuleCall_6_3_1_1_1()); 
            // InternalKbuild.g:2364:1: ( RULE_TAB )
            // InternalKbuild.g:2364:3: RULE_TAB
            {
            match(input,RULE_TAB,FOLLOW_21); 

            }

             after(grammarAccess.getBuildEntryAccess().getTABTerminalRuleCall_6_3_1_1_1()); 

            }

            // InternalKbuild.g:2367:1: ( ( RULE_TAB )* )
            // InternalKbuild.g:2368:1: ( RULE_TAB )*
            {
             before(grammarAccess.getBuildEntryAccess().getTABTerminalRuleCall_6_3_1_1_1()); 
            // InternalKbuild.g:2369:1: ( RULE_TAB )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_TAB) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalKbuild.g:2369:3: RULE_TAB
            	    {
            	    match(input,RULE_TAB,FOLLOW_21); 

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
    // InternalKbuild.g:2382:1: rule__BuildEntry__Group_6_3_1_1__2 : rule__BuildEntry__Group_6_3_1_1__2__Impl ;
    public final void rule__BuildEntry__Group_6_3_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2386:1: ( rule__BuildEntry__Group_6_3_1_1__2__Impl )
            // InternalKbuild.g:2387:2: rule__BuildEntry__Group_6_3_1_1__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2393:1: rule__BuildEntry__Group_6_3_1_1__2__Impl : ( ( rule__BuildEntry__ValuesAssignment_6_3_1_1_2 ) ) ;
    public final void rule__BuildEntry__Group_6_3_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2397:1: ( ( ( rule__BuildEntry__ValuesAssignment_6_3_1_1_2 ) ) )
            // InternalKbuild.g:2399:1: ( ( rule__BuildEntry__ValuesAssignment_6_3_1_1_2 ) )
            {
            // InternalKbuild.g:2399:1: ( ( rule__BuildEntry__ValuesAssignment_6_3_1_1_2 ) )
            // InternalKbuild.g:2400:1: ( rule__BuildEntry__ValuesAssignment_6_3_1_1_2 )
            {
             before(grammarAccess.getBuildEntryAccess().getValuesAssignment_6_3_1_1_2()); 
            // InternalKbuild.g:2401:1: ( rule__BuildEntry__ValuesAssignment_6_3_1_1_2 )
            // InternalKbuild.g:2401:2: rule__BuildEntry__ValuesAssignment_6_3_1_1_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2419:1: rule__BuildEntry__Group_7__0 : rule__BuildEntry__Group_7__0__Impl rule__BuildEntry__Group_7__1 ;
    public final void rule__BuildEntry__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2423:1: ( rule__BuildEntry__Group_7__0__Impl rule__BuildEntry__Group_7__1 )
            // InternalKbuild.g:2424:2: rule__BuildEntry__Group_7__0__Impl rule__BuildEntry__Group_7__1
            {
            pushFollow(FOLLOW_5);
            rule__BuildEntry__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2431:1: rule__BuildEntry__Group_7__0__Impl : ( () ) ;
    public final void rule__BuildEntry__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2435:1: ( ( () ) )
            // InternalKbuild.g:2437:1: ( () )
            {
            // InternalKbuild.g:2437:1: ( () )
            // InternalKbuild.g:2438:1: ()
            {
             before(grammarAccess.getBuildEntryAccess().getMyVariableAction_7_0()); 
            // InternalKbuild.g:2439:1: ()
            // InternalKbuild.g:2441:1: 
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
    // InternalKbuild.g:2453:1: rule__BuildEntry__Group_7__1 : rule__BuildEntry__Group_7__1__Impl rule__BuildEntry__Group_7__2 ;
    public final void rule__BuildEntry__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2457:1: ( rule__BuildEntry__Group_7__1__Impl rule__BuildEntry__Group_7__2 )
            // InternalKbuild.g:2458:2: rule__BuildEntry__Group_7__1__Impl rule__BuildEntry__Group_7__2
            {
            pushFollow(FOLLOW_22);
            rule__BuildEntry__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2465:1: rule__BuildEntry__Group_7__1__Impl : ( ( rule__BuildEntry__NameAssignment_7_1 ) ) ;
    public final void rule__BuildEntry__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2469:1: ( ( ( rule__BuildEntry__NameAssignment_7_1 ) ) )
            // InternalKbuild.g:2471:1: ( ( rule__BuildEntry__NameAssignment_7_1 ) )
            {
            // InternalKbuild.g:2471:1: ( ( rule__BuildEntry__NameAssignment_7_1 ) )
            // InternalKbuild.g:2472:1: ( rule__BuildEntry__NameAssignment_7_1 )
            {
             before(grammarAccess.getBuildEntryAccess().getNameAssignment_7_1()); 
            // InternalKbuild.g:2473:1: ( rule__BuildEntry__NameAssignment_7_1 )
            // InternalKbuild.g:2473:2: rule__BuildEntry__NameAssignment_7_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2485:1: rule__BuildEntry__Group_7__2 : rule__BuildEntry__Group_7__2__Impl rule__BuildEntry__Group_7__3 ;
    public final void rule__BuildEntry__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2489:1: ( rule__BuildEntry__Group_7__2__Impl rule__BuildEntry__Group_7__3 )
            // InternalKbuild.g:2490:2: rule__BuildEntry__Group_7__2__Impl rule__BuildEntry__Group_7__3
            {
            pushFollow(FOLLOW_22);
            rule__BuildEntry__Group_7__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2497:1: rule__BuildEntry__Group_7__2__Impl : ( ( rule__BuildEntry__VariableAssignment_7_2 )? ) ;
    public final void rule__BuildEntry__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2501:1: ( ( ( rule__BuildEntry__VariableAssignment_7_2 )? ) )
            // InternalKbuild.g:2503:1: ( ( rule__BuildEntry__VariableAssignment_7_2 )? )
            {
            // InternalKbuild.g:2503:1: ( ( rule__BuildEntry__VariableAssignment_7_2 )? )
            // InternalKbuild.g:2504:1: ( rule__BuildEntry__VariableAssignment_7_2 )?
            {
             before(grammarAccess.getBuildEntryAccess().getVariableAssignment_7_2()); 
            // InternalKbuild.g:2505:1: ( rule__BuildEntry__VariableAssignment_7_2 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_DOLLAR) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalKbuild.g:2505:2: rule__BuildEntry__VariableAssignment_7_2
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2517:1: rule__BuildEntry__Group_7__3 : rule__BuildEntry__Group_7__3__Impl ;
    public final void rule__BuildEntry__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2521:1: ( rule__BuildEntry__Group_7__3__Impl )
            // InternalKbuild.g:2522:2: rule__BuildEntry__Group_7__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2528:1: rule__BuildEntry__Group_7__3__Impl : ( ( rule__BuildEntry__ValueAssignment_7_3 ) ) ;
    public final void rule__BuildEntry__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2532:1: ( ( ( rule__BuildEntry__ValueAssignment_7_3 ) ) )
            // InternalKbuild.g:2534:1: ( ( rule__BuildEntry__ValueAssignment_7_3 ) )
            {
            // InternalKbuild.g:2534:1: ( ( rule__BuildEntry__ValueAssignment_7_3 ) )
            // InternalKbuild.g:2535:1: ( rule__BuildEntry__ValueAssignment_7_3 )
            {
             before(grammarAccess.getBuildEntryAccess().getValueAssignment_7_3()); 
            // InternalKbuild.g:2536:1: ( rule__BuildEntry__ValueAssignment_7_3 )
            // InternalKbuild.g:2536:2: rule__BuildEntry__ValueAssignment_7_3
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2556:1: rule__Entry__Group__0 : rule__Entry__Group__0__Impl rule__Entry__Group__1 ;
    public final void rule__Entry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2560:1: ( rule__Entry__Group__0__Impl rule__Entry__Group__1 )
            // InternalKbuild.g:2561:2: rule__Entry__Group__0__Impl rule__Entry__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Entry__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2568:1: rule__Entry__Group__0__Impl : ( () ) ;
    public final void rule__Entry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2572:1: ( ( () ) )
            // InternalKbuild.g:2574:1: ( () )
            {
            // InternalKbuild.g:2574:1: ( () )
            // InternalKbuild.g:2575:1: ()
            {
             before(grammarAccess.getEntryAccess().getEntryAction_0()); 
            // InternalKbuild.g:2576:1: ()
            // InternalKbuild.g:2578:1: 
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
    // InternalKbuild.g:2590:1: rule__Entry__Group__1 : rule__Entry__Group__1__Impl rule__Entry__Group__2 ;
    public final void rule__Entry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2594:1: ( rule__Entry__Group__1__Impl rule__Entry__Group__2 )
            // InternalKbuild.g:2595:2: rule__Entry__Group__1__Impl rule__Entry__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Entry__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2602:1: rule__Entry__Group__1__Impl : ( RULE_OBJ_START ) ;
    public final void rule__Entry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2606:1: ( ( RULE_OBJ_START ) )
            // InternalKbuild.g:2608:1: ( RULE_OBJ_START )
            {
            // InternalKbuild.g:2608:1: ( RULE_OBJ_START )
            // InternalKbuild.g:2609:1: RULE_OBJ_START
            {
             before(grammarAccess.getEntryAccess().getOBJ_STARTTerminalRuleCall_1()); 
            match(input,RULE_OBJ_START,FOLLOW_2); 
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
    // InternalKbuild.g:2622:1: rule__Entry__Group__2 : rule__Entry__Group__2__Impl rule__Entry__Group__3 ;
    public final void rule__Entry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2626:1: ( rule__Entry__Group__2__Impl rule__Entry__Group__3 )
            // InternalKbuild.g:2627:2: rule__Entry__Group__2__Impl rule__Entry__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__Entry__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2634:1: rule__Entry__Group__2__Impl : ( ( rule__Entry__VariableAssignment_2 ) ) ;
    public final void rule__Entry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2638:1: ( ( ( rule__Entry__VariableAssignment_2 ) ) )
            // InternalKbuild.g:2640:1: ( ( rule__Entry__VariableAssignment_2 ) )
            {
            // InternalKbuild.g:2640:1: ( ( rule__Entry__VariableAssignment_2 ) )
            // InternalKbuild.g:2641:1: ( rule__Entry__VariableAssignment_2 )
            {
             before(grammarAccess.getEntryAccess().getVariableAssignment_2()); 
            // InternalKbuild.g:2642:1: ( rule__Entry__VariableAssignment_2 )
            // InternalKbuild.g:2642:2: rule__Entry__VariableAssignment_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2654:1: rule__Entry__Group__3 : rule__Entry__Group__3__Impl ;
    public final void rule__Entry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2658:1: ( rule__Entry__Group__3__Impl )
            // InternalKbuild.g:2659:2: rule__Entry__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2665:1: rule__Entry__Group__3__Impl : ( ( rule__Entry__ValueAssignment_3 ) ) ;
    public final void rule__Entry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2669:1: ( ( ( rule__Entry__ValueAssignment_3 ) ) )
            // InternalKbuild.g:2671:1: ( ( rule__Entry__ValueAssignment_3 ) )
            {
            // InternalKbuild.g:2671:1: ( ( rule__Entry__ValueAssignment_3 ) )
            // InternalKbuild.g:2672:1: ( rule__Entry__ValueAssignment_3 )
            {
             before(grammarAccess.getEntryAccess().getValueAssignment_3()); 
            // InternalKbuild.g:2673:1: ( rule__Entry__ValueAssignment_3 )
            // InternalKbuild.g:2673:2: rule__Entry__ValueAssignment_3
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2693:1: rule__If__Group__0 : rule__If__Group__0__Impl rule__If__Group__1 ;
    public final void rule__If__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2697:1: ( rule__If__Group__0__Impl rule__If__Group__1 )
            // InternalKbuild.g:2698:2: rule__If__Group__0__Impl rule__If__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__If__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2705:1: rule__If__Group__0__Impl : ( RULE_BRACE_START ) ;
    public final void rule__If__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2709:1: ( ( RULE_BRACE_START ) )
            // InternalKbuild.g:2711:1: ( RULE_BRACE_START )
            {
            // InternalKbuild.g:2711:1: ( RULE_BRACE_START )
            // InternalKbuild.g:2712:1: RULE_BRACE_START
            {
             before(grammarAccess.getIfAccess().getBRACE_STARTTerminalRuleCall_0()); 
            match(input,RULE_BRACE_START,FOLLOW_2); 
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
    // InternalKbuild.g:2725:1: rule__If__Group__1 : rule__If__Group__1__Impl rule__If__Group__2 ;
    public final void rule__If__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2729:1: ( rule__If__Group__1__Impl rule__If__Group__2 )
            // InternalKbuild.g:2730:2: rule__If__Group__1__Impl rule__If__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__If__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2737:1: rule__If__Group__1__Impl : ( ( rule__If__Alternatives_1 ) ) ;
    public final void rule__If__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2741:1: ( ( ( rule__If__Alternatives_1 ) ) )
            // InternalKbuild.g:2743:1: ( ( rule__If__Alternatives_1 ) )
            {
            // InternalKbuild.g:2743:1: ( ( rule__If__Alternatives_1 ) )
            // InternalKbuild.g:2744:1: ( rule__If__Alternatives_1 )
            {
             before(grammarAccess.getIfAccess().getAlternatives_1()); 
            // InternalKbuild.g:2745:1: ( rule__If__Alternatives_1 )
            // InternalKbuild.g:2745:2: rule__If__Alternatives_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2757:1: rule__If__Group__2 : rule__If__Group__2__Impl rule__If__Group__3 ;
    public final void rule__If__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2761:1: ( rule__If__Group__2__Impl rule__If__Group__3 )
            // InternalKbuild.g:2762:2: rule__If__Group__2__Impl rule__If__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__If__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2769:1: rule__If__Group__2__Impl : ( RULE_BRACE_END ) ;
    public final void rule__If__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2773:1: ( ( RULE_BRACE_END ) )
            // InternalKbuild.g:2775:1: ( RULE_BRACE_END )
            {
            // InternalKbuild.g:2775:1: ( RULE_BRACE_END )
            // InternalKbuild.g:2776:1: RULE_BRACE_END
            {
             before(grammarAccess.getIfAccess().getBRACE_ENDTerminalRuleCall_2()); 
            match(input,RULE_BRACE_END,FOLLOW_2); 
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
    // InternalKbuild.g:2789:1: rule__If__Group__3 : rule__If__Group__3__Impl rule__If__Group__4 ;
    public final void rule__If__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2793:1: ( rule__If__Group__3__Impl rule__If__Group__4 )
            // InternalKbuild.g:2794:2: rule__If__Group__3__Impl rule__If__Group__4
            {
            pushFollow(FOLLOW_26);
            rule__If__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2801:1: rule__If__Group__3__Impl : ( ruleEol ) ;
    public final void rule__If__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2805:1: ( ( ruleEol ) )
            // InternalKbuild.g:2807:1: ( ruleEol )
            {
            // InternalKbuild.g:2807:1: ( ruleEol )
            // InternalKbuild.g:2808:1: ruleEol
            {
             before(grammarAccess.getIfAccess().getEolParserRuleCall_3()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2821:1: rule__If__Group__4 : rule__If__Group__4__Impl rule__If__Group__5 ;
    public final void rule__If__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2825:1: ( rule__If__Group__4__Impl rule__If__Group__5 )
            // InternalKbuild.g:2826:2: rule__If__Group__4__Impl rule__If__Group__5
            {
            pushFollow(FOLLOW_26);
            rule__If__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2833:1: rule__If__Group__4__Impl : ( ( RULE_TAB )* ) ;
    public final void rule__If__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2837:1: ( ( ( RULE_TAB )* ) )
            // InternalKbuild.g:2839:1: ( ( RULE_TAB )* )
            {
            // InternalKbuild.g:2839:1: ( ( RULE_TAB )* )
            // InternalKbuild.g:2840:1: ( RULE_TAB )*
            {
             before(grammarAccess.getIfAccess().getTABTerminalRuleCall_4()); 
            // InternalKbuild.g:2841:1: ( RULE_TAB )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_TAB) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalKbuild.g:2841:3: RULE_TAB
            	    {
            	    match(input,RULE_TAB,FOLLOW_21); 

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
    // InternalKbuild.g:2853:1: rule__If__Group__5 : rule__If__Group__5__Impl rule__If__Group__6 ;
    public final void rule__If__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2857:1: ( rule__If__Group__5__Impl rule__If__Group__6 )
            // InternalKbuild.g:2858:2: rule__If__Group__5__Impl rule__If__Group__6
            {
            pushFollow(FOLLOW_12);
            rule__If__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2865:1: rule__If__Group__5__Impl : ( ( rule__If__Alternatives_5 ) ) ;
    public final void rule__If__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2869:1: ( ( ( rule__If__Alternatives_5 ) ) )
            // InternalKbuild.g:2871:1: ( ( rule__If__Alternatives_5 ) )
            {
            // InternalKbuild.g:2871:1: ( ( rule__If__Alternatives_5 ) )
            // InternalKbuild.g:2872:1: ( rule__If__Alternatives_5 )
            {
             before(grammarAccess.getIfAccess().getAlternatives_5()); 
            // InternalKbuild.g:2873:1: ( rule__If__Alternatives_5 )
            // InternalKbuild.g:2873:2: rule__If__Alternatives_5
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2885:1: rule__If__Group__6 : rule__If__Group__6__Impl rule__If__Group__7 ;
    public final void rule__If__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2889:1: ( rule__If__Group__6__Impl rule__If__Group__7 )
            // InternalKbuild.g:2890:2: rule__If__Group__6__Impl rule__If__Group__7
            {
            pushFollow(FOLLOW_27);
            rule__If__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2897:1: rule__If__Group__6__Impl : ( ruleEol ) ;
    public final void rule__If__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2901:1: ( ( ruleEol ) )
            // InternalKbuild.g:2903:1: ( ruleEol )
            {
            // InternalKbuild.g:2903:1: ( ruleEol )
            // InternalKbuild.g:2904:1: ruleEol
            {
             before(grammarAccess.getIfAccess().getEolParserRuleCall_6()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2917:1: rule__If__Group__7 : rule__If__Group__7__Impl rule__If__Group__8 ;
    public final void rule__If__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2921:1: ( rule__If__Group__7__Impl rule__If__Group__8 )
            // InternalKbuild.g:2922:2: rule__If__Group__7__Impl rule__If__Group__8
            {
            pushFollow(FOLLOW_27);
            rule__If__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2929:1: rule__If__Group__7__Impl : ( ( rule__If__Group_7__0 )? ) ;
    public final void rule__If__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2933:1: ( ( ( rule__If__Group_7__0 )? ) )
            // InternalKbuild.g:2935:1: ( ( rule__If__Group_7__0 )? )
            {
            // InternalKbuild.g:2935:1: ( ( rule__If__Group_7__0 )? )
            // InternalKbuild.g:2936:1: ( rule__If__Group_7__0 )?
            {
             before(grammarAccess.getIfAccess().getGroup_7()); 
            // InternalKbuild.g:2937:1: ( rule__If__Group_7__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ELSE) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalKbuild.g:2937:2: rule__If__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2949:1: rule__If__Group__8 : rule__If__Group__8__Impl ;
    public final void rule__If__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2953:1: ( rule__If__Group__8__Impl )
            // InternalKbuild.g:2954:2: rule__If__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:2960:1: rule__If__Group__8__Impl : ( RULE_ENDIF ) ;
    public final void rule__If__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:2964:1: ( ( RULE_ENDIF ) )
            // InternalKbuild.g:2966:1: ( RULE_ENDIF )
            {
            // InternalKbuild.g:2966:1: ( RULE_ENDIF )
            // InternalKbuild.g:2967:1: RULE_ENDIF
            {
             before(grammarAccess.getIfAccess().getENDIFTerminalRuleCall_8()); 
            match(input,RULE_ENDIF,FOLLOW_2); 
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
    // InternalKbuild.g:2998:1: rule__If__Group_1_0__0 : rule__If__Group_1_0__0__Impl rule__If__Group_1_0__1 ;
    public final void rule__If__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3002:1: ( rule__If__Group_1_0__0__Impl rule__If__Group_1_0__1 )
            // InternalKbuild.g:3003:2: rule__If__Group_1_0__0__Impl rule__If__Group_1_0__1
            {
            pushFollow(FOLLOW_28);
            rule__If__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3010:1: rule__If__Group_1_0__0__Impl : ( ruleVariable ) ;
    public final void rule__If__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3014:1: ( ( ruleVariable ) )
            // InternalKbuild.g:3016:1: ( ruleVariable )
            {
            // InternalKbuild.g:3016:1: ( ruleVariable )
            // InternalKbuild.g:3017:1: ruleVariable
            {
             before(grammarAccess.getIfAccess().getVariableParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3030:1: rule__If__Group_1_0__1 : rule__If__Group_1_0__1__Impl rule__If__Group_1_0__2 ;
    public final void rule__If__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3034:1: ( rule__If__Group_1_0__1__Impl rule__If__Group_1_0__2 )
            // InternalKbuild.g:3035:2: rule__If__Group_1_0__1__Impl rule__If__Group_1_0__2
            {
            pushFollow(FOLLOW_29);
            rule__If__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3042:1: rule__If__Group_1_0__1__Impl : ( RULE_COMMA ) ;
    public final void rule__If__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3046:1: ( ( RULE_COMMA ) )
            // InternalKbuild.g:3048:1: ( RULE_COMMA )
            {
            // InternalKbuild.g:3048:1: ( RULE_COMMA )
            // InternalKbuild.g:3049:1: RULE_COMMA
            {
             before(grammarAccess.getIfAccess().getCOMMATerminalRuleCall_1_0_1()); 
            match(input,RULE_COMMA,FOLLOW_2); 
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
    // InternalKbuild.g:3062:1: rule__If__Group_1_0__2 : rule__If__Group_1_0__2__Impl ;
    public final void rule__If__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3066:1: ( rule__If__Group_1_0__2__Impl )
            // InternalKbuild.g:3067:2: rule__If__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3073:1: rule__If__Group_1_0__2__Impl : ( ( rule__If__Alternatives_1_0_2 ) ) ;
    public final void rule__If__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3077:1: ( ( ( rule__If__Alternatives_1_0_2 ) ) )
            // InternalKbuild.g:3079:1: ( ( rule__If__Alternatives_1_0_2 ) )
            {
            // InternalKbuild.g:3079:1: ( ( rule__If__Alternatives_1_0_2 ) )
            // InternalKbuild.g:3080:1: ( rule__If__Alternatives_1_0_2 )
            {
             before(grammarAccess.getIfAccess().getAlternatives_1_0_2()); 
            // InternalKbuild.g:3081:1: ( rule__If__Alternatives_1_0_2 )
            // InternalKbuild.g:3081:2: rule__If__Alternatives_1_0_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3099:1: rule__If__Group_1_1__0 : rule__If__Group_1_1__0__Impl rule__If__Group_1_1__1 ;
    public final void rule__If__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3103:1: ( rule__If__Group_1_1__0__Impl rule__If__Group_1_1__1 )
            // InternalKbuild.g:3104:2: rule__If__Group_1_1__0__Impl rule__If__Group_1_1__1
            {
            pushFollow(FOLLOW_28);
            rule__If__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3111:1: rule__If__Group_1_1__0__Impl : ( ( rule__If__ShellAssignment_1_1_0 ) ) ;
    public final void rule__If__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3115:1: ( ( ( rule__If__ShellAssignment_1_1_0 ) ) )
            // InternalKbuild.g:3117:1: ( ( rule__If__ShellAssignment_1_1_0 ) )
            {
            // InternalKbuild.g:3117:1: ( ( rule__If__ShellAssignment_1_1_0 ) )
            // InternalKbuild.g:3118:1: ( rule__If__ShellAssignment_1_1_0 )
            {
             before(grammarAccess.getIfAccess().getShellAssignment_1_1_0()); 
            // InternalKbuild.g:3119:1: ( rule__If__ShellAssignment_1_1_0 )
            // InternalKbuild.g:3119:2: rule__If__ShellAssignment_1_1_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3131:1: rule__If__Group_1_1__1 : rule__If__Group_1_1__1__Impl ;
    public final void rule__If__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3135:1: ( rule__If__Group_1_1__1__Impl )
            // InternalKbuild.g:3136:2: rule__If__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3142:1: rule__If__Group_1_1__1__Impl : ( ( RULE_COMMA )? ) ;
    public final void rule__If__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3146:1: ( ( ( RULE_COMMA )? ) )
            // InternalKbuild.g:3148:1: ( ( RULE_COMMA )? )
            {
            // InternalKbuild.g:3148:1: ( ( RULE_COMMA )? )
            // InternalKbuild.g:3149:1: ( RULE_COMMA )?
            {
             before(grammarAccess.getIfAccess().getCOMMATerminalRuleCall_1_1_1()); 
            // InternalKbuild.g:3150:1: ( RULE_COMMA )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_COMMA) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalKbuild.g:3150:3: RULE_COMMA
                    {
                    match(input,RULE_COMMA,FOLLOW_2); 

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
    // InternalKbuild.g:3166:1: rule__If__Group_7__0 : rule__If__Group_7__0__Impl rule__If__Group_7__1 ;
    public final void rule__If__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3170:1: ( rule__If__Group_7__0__Impl rule__If__Group_7__1 )
            // InternalKbuild.g:3171:2: rule__If__Group_7__0__Impl rule__If__Group_7__1
            {
            pushFollow(FOLLOW_12);
            rule__If__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3178:1: rule__If__Group_7__0__Impl : ( RULE_ELSE ) ;
    public final void rule__If__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3182:1: ( ( RULE_ELSE ) )
            // InternalKbuild.g:3184:1: ( RULE_ELSE )
            {
            // InternalKbuild.g:3184:1: ( RULE_ELSE )
            // InternalKbuild.g:3185:1: RULE_ELSE
            {
             before(grammarAccess.getIfAccess().getELSETerminalRuleCall_7_0()); 
            match(input,RULE_ELSE,FOLLOW_2); 
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
    // InternalKbuild.g:3198:1: rule__If__Group_7__1 : rule__If__Group_7__1__Impl rule__If__Group_7__2 ;
    public final void rule__If__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3202:1: ( rule__If__Group_7__1__Impl rule__If__Group_7__2 )
            // InternalKbuild.g:3203:2: rule__If__Group_7__1__Impl rule__If__Group_7__2
            {
            pushFollow(FOLLOW_30);
            rule__If__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3210:1: rule__If__Group_7__1__Impl : ( ruleEol ) ;
    public final void rule__If__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3214:1: ( ( ruleEol ) )
            // InternalKbuild.g:3216:1: ( ruleEol )
            {
            // InternalKbuild.g:3216:1: ( ruleEol )
            // InternalKbuild.g:3217:1: ruleEol
            {
             before(grammarAccess.getIfAccess().getEolParserRuleCall_7_1()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3230:1: rule__If__Group_7__2 : rule__If__Group_7__2__Impl rule__If__Group_7__3 ;
    public final void rule__If__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3234:1: ( rule__If__Group_7__2__Impl rule__If__Group_7__3 )
            // InternalKbuild.g:3235:2: rule__If__Group_7__2__Impl rule__If__Group_7__3
            {
            pushFollow(FOLLOW_30);
            rule__If__Group_7__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3242:1: rule__If__Group_7__2__Impl : ( ( RULE_TAB )* ) ;
    public final void rule__If__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3246:1: ( ( ( RULE_TAB )* ) )
            // InternalKbuild.g:3248:1: ( ( RULE_TAB )* )
            {
            // InternalKbuild.g:3248:1: ( ( RULE_TAB )* )
            // InternalKbuild.g:3249:1: ( RULE_TAB )*
            {
             before(grammarAccess.getIfAccess().getTABTerminalRuleCall_7_2()); 
            // InternalKbuild.g:3250:1: ( RULE_TAB )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_TAB) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalKbuild.g:3250:3: RULE_TAB
            	    {
            	    match(input,RULE_TAB,FOLLOW_21); 

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
    // InternalKbuild.g:3262:1: rule__If__Group_7__3 : rule__If__Group_7__3__Impl rule__If__Group_7__4 ;
    public final void rule__If__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3266:1: ( rule__If__Group_7__3__Impl rule__If__Group_7__4 )
            // InternalKbuild.g:3267:2: rule__If__Group_7__3__Impl rule__If__Group_7__4
            {
            pushFollow(FOLLOW_12);
            rule__If__Group_7__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3274:1: rule__If__Group_7__3__Impl : ( ( rule__If__Alternatives_7_3 ) ) ;
    public final void rule__If__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3278:1: ( ( ( rule__If__Alternatives_7_3 ) ) )
            // InternalKbuild.g:3280:1: ( ( rule__If__Alternatives_7_3 ) )
            {
            // InternalKbuild.g:3280:1: ( ( rule__If__Alternatives_7_3 ) )
            // InternalKbuild.g:3281:1: ( rule__If__Alternatives_7_3 )
            {
             before(grammarAccess.getIfAccess().getAlternatives_7_3()); 
            // InternalKbuild.g:3282:1: ( rule__If__Alternatives_7_3 )
            // InternalKbuild.g:3282:2: rule__If__Alternatives_7_3
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3294:1: rule__If__Group_7__4 : rule__If__Group_7__4__Impl ;
    public final void rule__If__Group_7__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3298:1: ( rule__If__Group_7__4__Impl )
            // InternalKbuild.g:3299:2: rule__If__Group_7__4__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3305:1: rule__If__Group_7__4__Impl : ( ruleEol ) ;
    public final void rule__If__Group_7__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3309:1: ( ( ruleEol ) )
            // InternalKbuild.g:3311:1: ( ruleEol )
            {
            // InternalKbuild.g:3311:1: ( ruleEol )
            // InternalKbuild.g:3312:1: ruleEol
            {
             before(grammarAccess.getIfAccess().getEolParserRuleCall_7_4()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3335:1: rule__Object_Y__Group__0 : rule__Object_Y__Group__0__Impl rule__Object_Y__Group__1 ;
    public final void rule__Object_Y__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3339:1: ( rule__Object_Y__Group__0__Impl rule__Object_Y__Group__1 )
            // InternalKbuild.g:3340:2: rule__Object_Y__Group__0__Impl rule__Object_Y__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__Object_Y__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3347:1: rule__Object_Y__Group__0__Impl : ( () ) ;
    public final void rule__Object_Y__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3351:1: ( ( () ) )
            // InternalKbuild.g:3353:1: ( () )
            {
            // InternalKbuild.g:3353:1: ( () )
            // InternalKbuild.g:3354:1: ()
            {
             before(grammarAccess.getObject_YAccess().getObj_yAction_0()); 
            // InternalKbuild.g:3355:1: ()
            // InternalKbuild.g:3357:1: 
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
    // InternalKbuild.g:3369:1: rule__Object_Y__Group__1 : rule__Object_Y__Group__1__Impl rule__Object_Y__Group__2 ;
    public final void rule__Object_Y__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3373:1: ( rule__Object_Y__Group__1__Impl rule__Object_Y__Group__2 )
            // InternalKbuild.g:3374:2: rule__Object_Y__Group__1__Impl rule__Object_Y__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__Object_Y__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3381:1: rule__Object_Y__Group__1__Impl : ( RULE_OBJ_Y ) ;
    public final void rule__Object_Y__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3385:1: ( ( RULE_OBJ_Y ) )
            // InternalKbuild.g:3387:1: ( RULE_OBJ_Y )
            {
            // InternalKbuild.g:3387:1: ( RULE_OBJ_Y )
            // InternalKbuild.g:3388:1: RULE_OBJ_Y
            {
             before(grammarAccess.getObject_YAccess().getOBJ_YTerminalRuleCall_1()); 
            match(input,RULE_OBJ_Y,FOLLOW_2); 
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
    // InternalKbuild.g:3401:1: rule__Object_Y__Group__2 : rule__Object_Y__Group__2__Impl ;
    public final void rule__Object_Y__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3405:1: ( rule__Object_Y__Group__2__Impl )
            // InternalKbuild.g:3406:2: rule__Object_Y__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3412:1: rule__Object_Y__Group__2__Impl : ( ( rule__Object_Y__ValueAssignment_2 ) ) ;
    public final void rule__Object_Y__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3416:1: ( ( ( rule__Object_Y__ValueAssignment_2 ) ) )
            // InternalKbuild.g:3418:1: ( ( rule__Object_Y__ValueAssignment_2 ) )
            {
            // InternalKbuild.g:3418:1: ( ( rule__Object_Y__ValueAssignment_2 ) )
            // InternalKbuild.g:3419:1: ( rule__Object_Y__ValueAssignment_2 )
            {
             before(grammarAccess.getObject_YAccess().getValueAssignment_2()); 
            // InternalKbuild.g:3420:1: ( rule__Object_Y__ValueAssignment_2 )
            // InternalKbuild.g:3420:2: rule__Object_Y__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3438:1: rule__Object_M__Group__0 : rule__Object_M__Group__0__Impl rule__Object_M__Group__1 ;
    public final void rule__Object_M__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3442:1: ( rule__Object_M__Group__0__Impl rule__Object_M__Group__1 )
            // InternalKbuild.g:3443:2: rule__Object_M__Group__0__Impl rule__Object_M__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__Object_M__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3450:1: rule__Object_M__Group__0__Impl : ( () ) ;
    public final void rule__Object_M__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3454:1: ( ( () ) )
            // InternalKbuild.g:3456:1: ( () )
            {
            // InternalKbuild.g:3456:1: ( () )
            // InternalKbuild.g:3457:1: ()
            {
             before(grammarAccess.getObject_MAccess().getObj_mAction_0()); 
            // InternalKbuild.g:3458:1: ()
            // InternalKbuild.g:3460:1: 
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
    // InternalKbuild.g:3472:1: rule__Object_M__Group__1 : rule__Object_M__Group__1__Impl rule__Object_M__Group__2 ;
    public final void rule__Object_M__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3476:1: ( rule__Object_M__Group__1__Impl rule__Object_M__Group__2 )
            // InternalKbuild.g:3477:2: rule__Object_M__Group__1__Impl rule__Object_M__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__Object_M__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3484:1: rule__Object_M__Group__1__Impl : ( RULE_OBJ_M ) ;
    public final void rule__Object_M__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3488:1: ( ( RULE_OBJ_M ) )
            // InternalKbuild.g:3490:1: ( RULE_OBJ_M )
            {
            // InternalKbuild.g:3490:1: ( RULE_OBJ_M )
            // InternalKbuild.g:3491:1: RULE_OBJ_M
            {
             before(grammarAccess.getObject_MAccess().getOBJ_MTerminalRuleCall_1()); 
            match(input,RULE_OBJ_M,FOLLOW_2); 
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
    // InternalKbuild.g:3504:1: rule__Object_M__Group__2 : rule__Object_M__Group__2__Impl ;
    public final void rule__Object_M__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3508:1: ( rule__Object_M__Group__2__Impl )
            // InternalKbuild.g:3509:2: rule__Object_M__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3515:1: rule__Object_M__Group__2__Impl : ( ( rule__Object_M__ValueAssignment_2 ) ) ;
    public final void rule__Object_M__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3519:1: ( ( ( rule__Object_M__ValueAssignment_2 ) ) )
            // InternalKbuild.g:3521:1: ( ( rule__Object_M__ValueAssignment_2 ) )
            {
            // InternalKbuild.g:3521:1: ( ( rule__Object_M__ValueAssignment_2 ) )
            // InternalKbuild.g:3522:1: ( rule__Object_M__ValueAssignment_2 )
            {
             before(grammarAccess.getObject_MAccess().getValueAssignment_2()); 
            // InternalKbuild.g:3523:1: ( rule__Object_M__ValueAssignment_2 )
            // InternalKbuild.g:3523:2: rule__Object_M__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3541:1: rule__Assign__Group__0 : rule__Assign__Group__0__Impl rule__Assign__Group__1 ;
    public final void rule__Assign__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3545:1: ( rule__Assign__Group__0__Impl rule__Assign__Group__1 )
            // InternalKbuild.g:3546:2: rule__Assign__Group__0__Impl rule__Assign__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__Assign__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3553:1: rule__Assign__Group__0__Impl : ( RULE_EQ ) ;
    public final void rule__Assign__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3557:1: ( ( RULE_EQ ) )
            // InternalKbuild.g:3559:1: ( RULE_EQ )
            {
            // InternalKbuild.g:3559:1: ( RULE_EQ )
            // InternalKbuild.g:3560:1: RULE_EQ
            {
             before(grammarAccess.getAssignAccess().getEQTerminalRuleCall_0()); 
            match(input,RULE_EQ,FOLLOW_2); 
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
    // InternalKbuild.g:3573:1: rule__Assign__Group__1 : rule__Assign__Group__1__Impl rule__Assign__Group__2 ;
    public final void rule__Assign__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3577:1: ( rule__Assign__Group__1__Impl rule__Assign__Group__2 )
            // InternalKbuild.g:3578:2: rule__Assign__Group__1__Impl rule__Assign__Group__2
            {
            pushFollow(FOLLOW_32);
            rule__Assign__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3585:1: rule__Assign__Group__1__Impl : ( ( RULE_TAB )* ) ;
    public final void rule__Assign__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3589:1: ( ( ( RULE_TAB )* ) )
            // InternalKbuild.g:3591:1: ( ( RULE_TAB )* )
            {
            // InternalKbuild.g:3591:1: ( ( RULE_TAB )* )
            // InternalKbuild.g:3592:1: ( RULE_TAB )*
            {
             before(grammarAccess.getAssignAccess().getTABTerminalRuleCall_1()); 
            // InternalKbuild.g:3593:1: ( RULE_TAB )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_TAB) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalKbuild.g:3593:3: RULE_TAB
            	    {
            	    match(input,RULE_TAB,FOLLOW_21); 

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
    // InternalKbuild.g:3605:1: rule__Assign__Group__2 : rule__Assign__Group__2__Impl ;
    public final void rule__Assign__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3609:1: ( rule__Assign__Group__2__Impl )
            // InternalKbuild.g:3610:2: rule__Assign__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3616:1: rule__Assign__Group__2__Impl : ( ruleValues ) ;
    public final void rule__Assign__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3620:1: ( ( ruleValues ) )
            // InternalKbuild.g:3622:1: ( ruleValues )
            {
            // InternalKbuild.g:3622:1: ( ruleValues )
            // InternalKbuild.g:3623:1: ruleValues
            {
             before(grammarAccess.getAssignAccess().getValuesParserRuleCall_2()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3642:1: rule__AssignExtra__Group__0 : rule__AssignExtra__Group__0__Impl rule__AssignExtra__Group__1 ;
    public final void rule__AssignExtra__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3646:1: ( rule__AssignExtra__Group__0__Impl rule__AssignExtra__Group__1 )
            // InternalKbuild.g:3647:2: rule__AssignExtra__Group__0__Impl rule__AssignExtra__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__AssignExtra__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3654:1: rule__AssignExtra__Group__0__Impl : ( ( RULE_TAB )* ) ;
    public final void rule__AssignExtra__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3658:1: ( ( ( RULE_TAB )* ) )
            // InternalKbuild.g:3660:1: ( ( RULE_TAB )* )
            {
            // InternalKbuild.g:3660:1: ( ( RULE_TAB )* )
            // InternalKbuild.g:3661:1: ( RULE_TAB )*
            {
             before(grammarAccess.getAssignExtraAccess().getTABTerminalRuleCall_0()); 
            // InternalKbuild.g:3662:1: ( RULE_TAB )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_TAB) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalKbuild.g:3662:3: RULE_TAB
            	    {
            	    match(input,RULE_TAB,FOLLOW_21); 

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
    // InternalKbuild.g:3674:1: rule__AssignExtra__Group__1 : rule__AssignExtra__Group__1__Impl rule__AssignExtra__Group__2 ;
    public final void rule__AssignExtra__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3678:1: ( rule__AssignExtra__Group__1__Impl rule__AssignExtra__Group__2 )
            // InternalKbuild.g:3679:2: rule__AssignExtra__Group__1__Impl rule__AssignExtra__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__AssignExtra__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3686:1: rule__AssignExtra__Group__1__Impl : ( ( rule__AssignExtra__Alternatives_1 ) ) ;
    public final void rule__AssignExtra__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3690:1: ( ( ( rule__AssignExtra__Alternatives_1 ) ) )
            // InternalKbuild.g:3692:1: ( ( rule__AssignExtra__Alternatives_1 ) )
            {
            // InternalKbuild.g:3692:1: ( ( rule__AssignExtra__Alternatives_1 ) )
            // InternalKbuild.g:3693:1: ( rule__AssignExtra__Alternatives_1 )
            {
             before(grammarAccess.getAssignExtraAccess().getAlternatives_1()); 
            // InternalKbuild.g:3694:1: ( rule__AssignExtra__Alternatives_1 )
            // InternalKbuild.g:3694:2: rule__AssignExtra__Alternatives_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3706:1: rule__AssignExtra__Group__2 : rule__AssignExtra__Group__2__Impl ;
    public final void rule__AssignExtra__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3710:1: ( rule__AssignExtra__Group__2__Impl )
            // InternalKbuild.g:3711:2: rule__AssignExtra__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3717:1: rule__AssignExtra__Group__2__Impl : ( ruleAssign ) ;
    public final void rule__AssignExtra__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3721:1: ( ( ruleAssign ) )
            // InternalKbuild.g:3723:1: ( ruleAssign )
            {
            // InternalKbuild.g:3723:1: ( ruleAssign )
            // InternalKbuild.g:3724:1: ruleAssign
            {
             before(grammarAccess.getAssignExtraAccess().getAssignParserRuleCall_2()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3743:1: rule__Values__Group__0 : rule__Values__Group__0__Impl rule__Values__Group__1 ;
    public final void rule__Values__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3747:1: ( rule__Values__Group__0__Impl rule__Values__Group__1 )
            // InternalKbuild.g:3748:2: rule__Values__Group__0__Impl rule__Values__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__Values__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3755:1: rule__Values__Group__0__Impl : ( ( rule__Values__Group_0__0 )? ) ;
    public final void rule__Values__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3759:1: ( ( ( rule__Values__Group_0__0 )? ) )
            // InternalKbuild.g:3761:1: ( ( rule__Values__Group_0__0 )? )
            {
            // InternalKbuild.g:3761:1: ( ( rule__Values__Group_0__0 )? )
            // InternalKbuild.g:3762:1: ( rule__Values__Group_0__0 )?
            {
             before(grammarAccess.getValuesAccess().getGroup_0()); 
            // InternalKbuild.g:3763:1: ( rule__Values__Group_0__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_BACKSLASH) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalKbuild.g:3763:2: rule__Values__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3775:1: rule__Values__Group__1 : rule__Values__Group__1__Impl rule__Values__Group__2 ;
    public final void rule__Values__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3779:1: ( rule__Values__Group__1__Impl rule__Values__Group__2 )
            // InternalKbuild.g:3780:2: rule__Values__Group__1__Impl rule__Values__Group__2
            {
            pushFollow(FOLLOW_33);
            rule__Values__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3787:1: rule__Values__Group__1__Impl : ( ( ( rule__Values__ItemsAssignment_1 ) ) ( ( rule__Values__ItemsAssignment_1 )* ) ) ;
    public final void rule__Values__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3791:1: ( ( ( ( rule__Values__ItemsAssignment_1 ) ) ( ( rule__Values__ItemsAssignment_1 )* ) ) )
            // InternalKbuild.g:3793:1: ( ( ( rule__Values__ItemsAssignment_1 ) ) ( ( rule__Values__ItemsAssignment_1 )* ) )
            {
            // InternalKbuild.g:3793:1: ( ( ( rule__Values__ItemsAssignment_1 ) ) ( ( rule__Values__ItemsAssignment_1 )* ) )
            // InternalKbuild.g:3794:1: ( ( rule__Values__ItemsAssignment_1 ) ) ( ( rule__Values__ItemsAssignment_1 )* )
            {
            // InternalKbuild.g:3794:1: ( ( rule__Values__ItemsAssignment_1 ) )
            // InternalKbuild.g:3795:1: ( rule__Values__ItemsAssignment_1 )
            {
             before(grammarAccess.getValuesAccess().getItemsAssignment_1()); 
            // InternalKbuild.g:3796:1: ( rule__Values__ItemsAssignment_1 )
            // InternalKbuild.g:3796:2: rule__Values__ItemsAssignment_1
            {
            pushFollow(FOLLOW_34);
            rule__Values__ItemsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getValuesAccess().getItemsAssignment_1()); 

            }

            // InternalKbuild.g:3799:1: ( ( rule__Values__ItemsAssignment_1 )* )
            // InternalKbuild.g:3800:1: ( rule__Values__ItemsAssignment_1 )*
            {
             before(grammarAccess.getValuesAccess().getItemsAssignment_1()); 
            // InternalKbuild.g:3801:1: ( rule__Values__ItemsAssignment_1 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_STRING||LA30_0==RULE_SHELL_CHAR||LA30_0==RULE_SYMBOL||(LA30_0>=RULE_DOLLAR && LA30_0<=RULE_INCLUDE)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalKbuild.g:3801:2: rule__Values__ItemsAssignment_1
            	    {
            	    pushFollow(FOLLOW_34);
            	    rule__Values__ItemsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getValuesAccess().getItemsAssignment_1()); 

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
    // InternalKbuild.g:3814:1: rule__Values__Group__2 : rule__Values__Group__2__Impl ;
    public final void rule__Values__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3818:1: ( rule__Values__Group__2__Impl )
            // InternalKbuild.g:3819:2: rule__Values__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3825:1: rule__Values__Group__2__Impl : ( ( rule__Values__Group_2__0 )* ) ;
    public final void rule__Values__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3829:1: ( ( ( rule__Values__Group_2__0 )* ) )
            // InternalKbuild.g:3831:1: ( ( rule__Values__Group_2__0 )* )
            {
            // InternalKbuild.g:3831:1: ( ( rule__Values__Group_2__0 )* )
            // InternalKbuild.g:3832:1: ( rule__Values__Group_2__0 )*
            {
             before(grammarAccess.getValuesAccess().getGroup_2()); 
            // InternalKbuild.g:3833:1: ( rule__Values__Group_2__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_BACKSLASH) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalKbuild.g:3833:2: rule__Values__Group_2__0
            	    {
            	    pushFollow(FOLLOW_35);
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
    // InternalKbuild.g:3851:1: rule__Values__Group_0__0 : rule__Values__Group_0__0__Impl rule__Values__Group_0__1 ;
    public final void rule__Values__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3855:1: ( rule__Values__Group_0__0__Impl rule__Values__Group_0__1 )
            // InternalKbuild.g:3856:2: rule__Values__Group_0__0__Impl rule__Values__Group_0__1
            {
            pushFollow(FOLLOW_12);
            rule__Values__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3863:1: rule__Values__Group_0__0__Impl : ( RULE_BACKSLASH ) ;
    public final void rule__Values__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3867:1: ( ( RULE_BACKSLASH ) )
            // InternalKbuild.g:3869:1: ( RULE_BACKSLASH )
            {
            // InternalKbuild.g:3869:1: ( RULE_BACKSLASH )
            // InternalKbuild.g:3870:1: RULE_BACKSLASH
            {
             before(grammarAccess.getValuesAccess().getBACKSLASHTerminalRuleCall_0_0()); 
            match(input,RULE_BACKSLASH,FOLLOW_2); 
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
    // InternalKbuild.g:3883:1: rule__Values__Group_0__1 : rule__Values__Group_0__1__Impl rule__Values__Group_0__2 ;
    public final void rule__Values__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3887:1: ( rule__Values__Group_0__1__Impl rule__Values__Group_0__2 )
            // InternalKbuild.g:3888:2: rule__Values__Group_0__1__Impl rule__Values__Group_0__2
            {
            pushFollow(FOLLOW_20);
            rule__Values__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3895:1: rule__Values__Group_0__1__Impl : ( ruleEol ) ;
    public final void rule__Values__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3899:1: ( ( ruleEol ) )
            // InternalKbuild.g:3901:1: ( ruleEol )
            {
            // InternalKbuild.g:3901:1: ( ruleEol )
            // InternalKbuild.g:3902:1: ruleEol
            {
             before(grammarAccess.getValuesAccess().getEolParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3915:1: rule__Values__Group_0__2 : rule__Values__Group_0__2__Impl ;
    public final void rule__Values__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3919:1: ( rule__Values__Group_0__2__Impl )
            // InternalKbuild.g:3920:2: rule__Values__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3926:1: rule__Values__Group_0__2__Impl : ( ( RULE_TAB )* ) ;
    public final void rule__Values__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3930:1: ( ( ( RULE_TAB )* ) )
            // InternalKbuild.g:3932:1: ( ( RULE_TAB )* )
            {
            // InternalKbuild.g:3932:1: ( ( RULE_TAB )* )
            // InternalKbuild.g:3933:1: ( RULE_TAB )*
            {
             before(grammarAccess.getValuesAccess().getTABTerminalRuleCall_0_2()); 
            // InternalKbuild.g:3934:1: ( RULE_TAB )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_TAB) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalKbuild.g:3934:3: RULE_TAB
            	    {
            	    match(input,RULE_TAB,FOLLOW_21); 

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
    // InternalKbuild.g:3952:1: rule__Values__Group_2__0 : rule__Values__Group_2__0__Impl rule__Values__Group_2__1 ;
    public final void rule__Values__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3956:1: ( rule__Values__Group_2__0__Impl rule__Values__Group_2__1 )
            // InternalKbuild.g:3957:2: rule__Values__Group_2__0__Impl rule__Values__Group_2__1
            {
            pushFollow(FOLLOW_12);
            rule__Values__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3964:1: rule__Values__Group_2__0__Impl : ( RULE_BACKSLASH ) ;
    public final void rule__Values__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3968:1: ( ( RULE_BACKSLASH ) )
            // InternalKbuild.g:3970:1: ( RULE_BACKSLASH )
            {
            // InternalKbuild.g:3970:1: ( RULE_BACKSLASH )
            // InternalKbuild.g:3971:1: RULE_BACKSLASH
            {
             before(grammarAccess.getValuesAccess().getBACKSLASHTerminalRuleCall_2_0()); 
            match(input,RULE_BACKSLASH,FOLLOW_2); 
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
    // InternalKbuild.g:3984:1: rule__Values__Group_2__1 : rule__Values__Group_2__1__Impl rule__Values__Group_2__2 ;
    public final void rule__Values__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:3988:1: ( rule__Values__Group_2__1__Impl rule__Values__Group_2__2 )
            // InternalKbuild.g:3989:2: rule__Values__Group_2__1__Impl rule__Values__Group_2__2
            {
            pushFollow(FOLLOW_32);
            rule__Values__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:3996:1: rule__Values__Group_2__1__Impl : ( ruleEol ) ;
    public final void rule__Values__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4000:1: ( ( ruleEol ) )
            // InternalKbuild.g:4002:1: ( ruleEol )
            {
            // InternalKbuild.g:4002:1: ( ruleEol )
            // InternalKbuild.g:4003:1: ruleEol
            {
             before(grammarAccess.getValuesAccess().getEolParserRuleCall_2_1()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4016:1: rule__Values__Group_2__2 : rule__Values__Group_2__2__Impl rule__Values__Group_2__3 ;
    public final void rule__Values__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4020:1: ( rule__Values__Group_2__2__Impl rule__Values__Group_2__3 )
            // InternalKbuild.g:4021:2: rule__Values__Group_2__2__Impl rule__Values__Group_2__3
            {
            pushFollow(FOLLOW_32);
            rule__Values__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4028:1: rule__Values__Group_2__2__Impl : ( ( RULE_TAB )* ) ;
    public final void rule__Values__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4032:1: ( ( ( RULE_TAB )* ) )
            // InternalKbuild.g:4034:1: ( ( RULE_TAB )* )
            {
            // InternalKbuild.g:4034:1: ( ( RULE_TAB )* )
            // InternalKbuild.g:4035:1: ( RULE_TAB )*
            {
             before(grammarAccess.getValuesAccess().getTABTerminalRuleCall_2_2()); 
            // InternalKbuild.g:4036:1: ( RULE_TAB )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_TAB) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalKbuild.g:4036:3: RULE_TAB
            	    {
            	    match(input,RULE_TAB,FOLLOW_21); 

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
    // InternalKbuild.g:4048:1: rule__Values__Group_2__3 : rule__Values__Group_2__3__Impl ;
    public final void rule__Values__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4052:1: ( rule__Values__Group_2__3__Impl )
            // InternalKbuild.g:4053:2: rule__Values__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4059:1: rule__Values__Group_2__3__Impl : ( ( ( rule__Values__ItemsAssignment_2_3 ) ) ( ( rule__Values__ItemsAssignment_2_3 )* ) ) ;
    public final void rule__Values__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4063:1: ( ( ( ( rule__Values__ItemsAssignment_2_3 ) ) ( ( rule__Values__ItemsAssignment_2_3 )* ) ) )
            // InternalKbuild.g:4065:1: ( ( ( rule__Values__ItemsAssignment_2_3 ) ) ( ( rule__Values__ItemsAssignment_2_3 )* ) )
            {
            // InternalKbuild.g:4065:1: ( ( ( rule__Values__ItemsAssignment_2_3 ) ) ( ( rule__Values__ItemsAssignment_2_3 )* ) )
            // InternalKbuild.g:4066:1: ( ( rule__Values__ItemsAssignment_2_3 ) ) ( ( rule__Values__ItemsAssignment_2_3 )* )
            {
            // InternalKbuild.g:4066:1: ( ( rule__Values__ItemsAssignment_2_3 ) )
            // InternalKbuild.g:4067:1: ( rule__Values__ItemsAssignment_2_3 )
            {
             before(grammarAccess.getValuesAccess().getItemsAssignment_2_3()); 
            // InternalKbuild.g:4068:1: ( rule__Values__ItemsAssignment_2_3 )
            // InternalKbuild.g:4068:2: rule__Values__ItemsAssignment_2_3
            {
            pushFollow(FOLLOW_36);
            rule__Values__ItemsAssignment_2_3();

            state._fsp--;


            }

             after(grammarAccess.getValuesAccess().getItemsAssignment_2_3()); 

            }

            // InternalKbuild.g:4071:1: ( ( rule__Values__ItemsAssignment_2_3 )* )
            // InternalKbuild.g:4072:1: ( rule__Values__ItemsAssignment_2_3 )*
            {
             before(grammarAccess.getValuesAccess().getItemsAssignment_2_3()); 
            // InternalKbuild.g:4073:1: ( rule__Values__ItemsAssignment_2_3 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_STRING||LA34_0==RULE_SHELL_CHAR||LA34_0==RULE_SYMBOL||(LA34_0>=RULE_DOLLAR && LA34_0<=RULE_INCLUDE)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalKbuild.g:4073:2: rule__Values__ItemsAssignment_2_3
            	    {
            	    pushFollow(FOLLOW_36);
            	    rule__Values__ItemsAssignment_2_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getValuesAccess().getItemsAssignment_2_3()); 

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
    // InternalKbuild.g:4094:1: rule__Value__Group_0__0 : rule__Value__Group_0__0__Impl rule__Value__Group_0__1 ;
    public final void rule__Value__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4098:1: ( rule__Value__Group_0__0__Impl rule__Value__Group_0__1 )
            // InternalKbuild.g:4099:2: rule__Value__Group_0__0__Impl rule__Value__Group_0__1
            {
            pushFollow(FOLLOW_11);
            rule__Value__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4106:1: rule__Value__Group_0__0__Impl : ( () ) ;
    public final void rule__Value__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4110:1: ( ( () ) )
            // InternalKbuild.g:4112:1: ( () )
            {
            // InternalKbuild.g:4112:1: ( () )
            // InternalKbuild.g:4113:1: ()
            {
             before(grammarAccess.getValueAccess().getObjectFileAction_0_0()); 
            // InternalKbuild.g:4114:1: ()
            // InternalKbuild.g:4116:1: 
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
    // InternalKbuild.g:4128:1: rule__Value__Group_0__1 : rule__Value__Group_0__1__Impl rule__Value__Group_0__2 ;
    public final void rule__Value__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4132:1: ( rule__Value__Group_0__1__Impl rule__Value__Group_0__2 )
            // InternalKbuild.g:4133:2: rule__Value__Group_0__1__Impl rule__Value__Group_0__2
            {
            pushFollow(FOLLOW_37);
            rule__Value__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4140:1: rule__Value__Group_0__1__Impl : ( RULE_SYMBOL ) ;
    public final void rule__Value__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4144:1: ( ( RULE_SYMBOL ) )
            // InternalKbuild.g:4146:1: ( RULE_SYMBOL )
            {
            // InternalKbuild.g:4146:1: ( RULE_SYMBOL )
            // InternalKbuild.g:4147:1: RULE_SYMBOL
            {
             before(grammarAccess.getValueAccess().getSYMBOLTerminalRuleCall_0_1()); 
            match(input,RULE_SYMBOL,FOLLOW_2); 
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
    // InternalKbuild.g:4160:1: rule__Value__Group_0__2 : rule__Value__Group_0__2__Impl ;
    public final void rule__Value__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4164:1: ( rule__Value__Group_0__2__Impl )
            // InternalKbuild.g:4165:2: rule__Value__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4171:1: rule__Value__Group_0__2__Impl : ( RULE_OBJ_FILE ) ;
    public final void rule__Value__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4175:1: ( ( RULE_OBJ_FILE ) )
            // InternalKbuild.g:4177:1: ( RULE_OBJ_FILE )
            {
            // InternalKbuild.g:4177:1: ( RULE_OBJ_FILE )
            // InternalKbuild.g:4178:1: RULE_OBJ_FILE
            {
             before(grammarAccess.getValueAccess().getOBJ_FILETerminalRuleCall_0_2()); 
            match(input,RULE_OBJ_FILE,FOLLOW_2); 
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
    // InternalKbuild.g:4197:1: rule__Value__Group_1__0 : rule__Value__Group_1__0__Impl rule__Value__Group_1__1 ;
    public final void rule__Value__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4201:1: ( rule__Value__Group_1__0__Impl rule__Value__Group_1__1 )
            // InternalKbuild.g:4202:2: rule__Value__Group_1__0__Impl rule__Value__Group_1__1
            {
            pushFollow(FOLLOW_11);
            rule__Value__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4209:1: rule__Value__Group_1__0__Impl : ( () ) ;
    public final void rule__Value__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4213:1: ( ( () ) )
            // InternalKbuild.g:4215:1: ( () )
            {
            // InternalKbuild.g:4215:1: ( () )
            // InternalKbuild.g:4216:1: ()
            {
             before(grammarAccess.getValueAccess().getObjectSingleFileAction_1_0()); 
            // InternalKbuild.g:4217:1: ()
            // InternalKbuild.g:4219:1: 
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
    // InternalKbuild.g:4231:1: rule__Value__Group_1__1 : rule__Value__Group_1__1__Impl ;
    public final void rule__Value__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4235:1: ( rule__Value__Group_1__1__Impl )
            // InternalKbuild.g:4236:2: rule__Value__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4242:1: rule__Value__Group_1__1__Impl : ( ( rule__Value__NameAssignment_1_1 ) ) ;
    public final void rule__Value__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4246:1: ( ( ( rule__Value__NameAssignment_1_1 ) ) )
            // InternalKbuild.g:4248:1: ( ( rule__Value__NameAssignment_1_1 ) )
            {
            // InternalKbuild.g:4248:1: ( ( rule__Value__NameAssignment_1_1 ) )
            // InternalKbuild.g:4249:1: ( rule__Value__NameAssignment_1_1 )
            {
             before(grammarAccess.getValueAccess().getNameAssignment_1_1()); 
            // InternalKbuild.g:4250:1: ( rule__Value__NameAssignment_1_1 )
            // InternalKbuild.g:4250:2: rule__Value__NameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4266:1: rule__Value__Group_2__0 : rule__Value__Group_2__0__Impl rule__Value__Group_2__1 ;
    public final void rule__Value__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4270:1: ( rule__Value__Group_2__0__Impl rule__Value__Group_2__1 )
            // InternalKbuild.g:4271:2: rule__Value__Group_2__0__Impl rule__Value__Group_2__1
            {
            pushFollow(FOLLOW_23);
            rule__Value__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4278:1: rule__Value__Group_2__0__Impl : ( () ) ;
    public final void rule__Value__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4282:1: ( ( () ) )
            // InternalKbuild.g:4284:1: ( () )
            {
            // InternalKbuild.g:4284:1: ( () )
            // InternalKbuild.g:4285:1: ()
            {
             before(grammarAccess.getValueAccess().getObjectVariableAction_2_0()); 
            // InternalKbuild.g:4286:1: ()
            // InternalKbuild.g:4288:1: 
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
    // InternalKbuild.g:4300:1: rule__Value__Group_2__1 : rule__Value__Group_2__1__Impl rule__Value__Group_2__2 ;
    public final void rule__Value__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4304:1: ( rule__Value__Group_2__1__Impl rule__Value__Group_2__2 )
            // InternalKbuild.g:4305:2: rule__Value__Group_2__1__Impl rule__Value__Group_2__2
            {
            pushFollow(FOLLOW_38);
            rule__Value__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4312:1: rule__Value__Group_2__1__Impl : ( ( rule__Value__ValueAssignment_2_1 ) ) ;
    public final void rule__Value__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4316:1: ( ( ( rule__Value__ValueAssignment_2_1 ) ) )
            // InternalKbuild.g:4318:1: ( ( rule__Value__ValueAssignment_2_1 ) )
            {
            // InternalKbuild.g:4318:1: ( ( rule__Value__ValueAssignment_2_1 ) )
            // InternalKbuild.g:4319:1: ( rule__Value__ValueAssignment_2_1 )
            {
             before(grammarAccess.getValueAccess().getValueAssignment_2_1()); 
            // InternalKbuild.g:4320:1: ( rule__Value__ValueAssignment_2_1 )
            // InternalKbuild.g:4320:2: rule__Value__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4332:1: rule__Value__Group_2__2 : rule__Value__Group_2__2__Impl ;
    public final void rule__Value__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4336:1: ( rule__Value__Group_2__2__Impl )
            // InternalKbuild.g:4337:2: rule__Value__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4343:1: rule__Value__Group_2__2__Impl : ( ( rule__Value__AdditionalAssignment_2_2 )? ) ;
    public final void rule__Value__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4347:1: ( ( ( rule__Value__AdditionalAssignment_2_2 )? ) )
            // InternalKbuild.g:4349:1: ( ( rule__Value__AdditionalAssignment_2_2 )? )
            {
            // InternalKbuild.g:4349:1: ( ( rule__Value__AdditionalAssignment_2_2 )? )
            // InternalKbuild.g:4350:1: ( rule__Value__AdditionalAssignment_2_2 )?
            {
             before(grammarAccess.getValueAccess().getAdditionalAssignment_2_2()); 
            // InternalKbuild.g:4351:1: ( rule__Value__AdditionalAssignment_2_2 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_SLASH) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalKbuild.g:4351:2: rule__Value__AdditionalAssignment_2_2
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4369:1: rule__Value__Group_3__0 : rule__Value__Group_3__0__Impl rule__Value__Group_3__1 ;
    public final void rule__Value__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4373:1: ( rule__Value__Group_3__0__Impl rule__Value__Group_3__1 )
            // InternalKbuild.g:4374:2: rule__Value__Group_3__0__Impl rule__Value__Group_3__1
            {
            pushFollow(FOLLOW_24);
            rule__Value__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4381:1: rule__Value__Group_3__0__Impl : ( () ) ;
    public final void rule__Value__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4385:1: ( ( () ) )
            // InternalKbuild.g:4387:1: ( () )
            {
            // InternalKbuild.g:4387:1: ( () )
            // InternalKbuild.g:4388:1: ()
            {
             before(grammarAccess.getValueAccess().getObjectShellCmdAction_3_0()); 
            // InternalKbuild.g:4389:1: ()
            // InternalKbuild.g:4391:1: 
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
    // InternalKbuild.g:4403:1: rule__Value__Group_3__1 : rule__Value__Group_3__1__Impl ;
    public final void rule__Value__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4407:1: ( rule__Value__Group_3__1__Impl )
            // InternalKbuild.g:4408:2: rule__Value__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4414:1: rule__Value__Group_3__1__Impl : ( ( rule__Value__ValueAssignment_3_1 ) ) ;
    public final void rule__Value__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4418:1: ( ( ( rule__Value__ValueAssignment_3_1 ) ) )
            // InternalKbuild.g:4420:1: ( ( rule__Value__ValueAssignment_3_1 ) )
            {
            // InternalKbuild.g:4420:1: ( ( rule__Value__ValueAssignment_3_1 ) )
            // InternalKbuild.g:4421:1: ( rule__Value__ValueAssignment_3_1 )
            {
             before(grammarAccess.getValueAccess().getValueAssignment_3_1()); 
            // InternalKbuild.g:4422:1: ( rule__Value__ValueAssignment_3_1 )
            // InternalKbuild.g:4422:2: rule__Value__ValueAssignment_3_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4438:1: rule__Value__Group_4__0 : rule__Value__Group_4__0__Impl rule__Value__Group_4__1 ;
    public final void rule__Value__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4442:1: ( rule__Value__Group_4__0__Impl rule__Value__Group_4__1 )
            // InternalKbuild.g:4443:2: rule__Value__Group_4__0__Impl rule__Value__Group_4__1
            {
            pushFollow(FOLLOW_39);
            rule__Value__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4450:1: rule__Value__Group_4__0__Impl : ( () ) ;
    public final void rule__Value__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4454:1: ( ( () ) )
            // InternalKbuild.g:4456:1: ( () )
            {
            // InternalKbuild.g:4456:1: ( () )
            // InternalKbuild.g:4457:1: ()
            {
             before(grammarAccess.getValueAccess().getObjectStringAction_4_0()); 
            // InternalKbuild.g:4458:1: ()
            // InternalKbuild.g:4460:1: 
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
    // InternalKbuild.g:4472:1: rule__Value__Group_4__1 : rule__Value__Group_4__1__Impl ;
    public final void rule__Value__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4476:1: ( rule__Value__Group_4__1__Impl )
            // InternalKbuild.g:4477:2: rule__Value__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4483:1: rule__Value__Group_4__1__Impl : ( RULE_STRING ) ;
    public final void rule__Value__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4487:1: ( ( RULE_STRING ) )
            // InternalKbuild.g:4489:1: ( RULE_STRING )
            {
            // InternalKbuild.g:4489:1: ( RULE_STRING )
            // InternalKbuild.g:4490:1: RULE_STRING
            {
             before(grammarAccess.getValueAccess().getSTRINGTerminalRuleCall_4_1()); 
            match(input,RULE_STRING,FOLLOW_2); 
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
    // InternalKbuild.g:4507:1: rule__Value__Group_5__0 : rule__Value__Group_5__0__Impl rule__Value__Group_5__1 ;
    public final void rule__Value__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4511:1: ( rule__Value__Group_5__0__Impl rule__Value__Group_5__1 )
            // InternalKbuild.g:4512:2: rule__Value__Group_5__0__Impl rule__Value__Group_5__1
            {
            pushFollow(FOLLOW_40);
            rule__Value__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4519:1: rule__Value__Group_5__0__Impl : ( () ) ;
    public final void rule__Value__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4523:1: ( ( () ) )
            // InternalKbuild.g:4525:1: ( () )
            {
            // InternalKbuild.g:4525:1: ( () )
            // InternalKbuild.g:4526:1: ()
            {
             before(grammarAccess.getValueAccess().getObjectShellCharAction_5_0()); 
            // InternalKbuild.g:4527:1: ()
            // InternalKbuild.g:4529:1: 
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
    // InternalKbuild.g:4541:1: rule__Value__Group_5__1 : rule__Value__Group_5__1__Impl ;
    public final void rule__Value__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4545:1: ( rule__Value__Group_5__1__Impl )
            // InternalKbuild.g:4546:2: rule__Value__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4552:1: rule__Value__Group_5__1__Impl : ( ( rule__Value__ValueAssignment_5_1 ) ) ;
    public final void rule__Value__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4556:1: ( ( ( rule__Value__ValueAssignment_5_1 ) ) )
            // InternalKbuild.g:4558:1: ( ( rule__Value__ValueAssignment_5_1 ) )
            {
            // InternalKbuild.g:4558:1: ( ( rule__Value__ValueAssignment_5_1 ) )
            // InternalKbuild.g:4559:1: ( rule__Value__ValueAssignment_5_1 )
            {
             before(grammarAccess.getValueAccess().getValueAssignment_5_1()); 
            // InternalKbuild.g:4560:1: ( rule__Value__ValueAssignment_5_1 )
            // InternalKbuild.g:4560:2: rule__Value__ValueAssignment_5_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4576:1: rule__Value__Group_6__0 : rule__Value__Group_6__0__Impl rule__Value__Group_6__1 ;
    public final void rule__Value__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4580:1: ( rule__Value__Group_6__0__Impl rule__Value__Group_6__1 )
            // InternalKbuild.g:4581:2: rule__Value__Group_6__0__Impl rule__Value__Group_6__1
            {
            pushFollow(FOLLOW_17);
            rule__Value__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4588:1: rule__Value__Group_6__0__Impl : ( () ) ;
    public final void rule__Value__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4592:1: ( ( () ) )
            // InternalKbuild.g:4594:1: ( () )
            {
            // InternalKbuild.g:4594:1: ( () )
            // InternalKbuild.g:4595:1: ()
            {
             before(grammarAccess.getValueAccess().getObjectDirAction_6_0()); 
            // InternalKbuild.g:4596:1: ()
            // InternalKbuild.g:4598:1: 
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
    // InternalKbuild.g:4610:1: rule__Value__Group_6__1 : rule__Value__Group_6__1__Impl rule__Value__Group_6__2 ;
    public final void rule__Value__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4614:1: ( rule__Value__Group_6__1__Impl rule__Value__Group_6__2 )
            // InternalKbuild.g:4615:2: rule__Value__Group_6__1__Impl rule__Value__Group_6__2
            {
            pushFollow(FOLLOW_38);
            rule__Value__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4622:1: rule__Value__Group_6__1__Impl : ( RULE_SYMBOL ) ;
    public final void rule__Value__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4626:1: ( ( RULE_SYMBOL ) )
            // InternalKbuild.g:4628:1: ( RULE_SYMBOL )
            {
            // InternalKbuild.g:4628:1: ( RULE_SYMBOL )
            // InternalKbuild.g:4629:1: RULE_SYMBOL
            {
             before(grammarAccess.getValueAccess().getSYMBOLTerminalRuleCall_6_1()); 
            match(input,RULE_SYMBOL,FOLLOW_2); 
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
    // InternalKbuild.g:4642:1: rule__Value__Group_6__2 : rule__Value__Group_6__2__Impl ;
    public final void rule__Value__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4646:1: ( rule__Value__Group_6__2__Impl )
            // InternalKbuild.g:4647:2: rule__Value__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4653:1: rule__Value__Group_6__2__Impl : ( RULE_SLASH ) ;
    public final void rule__Value__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4657:1: ( ( RULE_SLASH ) )
            // InternalKbuild.g:4659:1: ( RULE_SLASH )
            {
            // InternalKbuild.g:4659:1: ( RULE_SLASH )
            // InternalKbuild.g:4660:1: RULE_SLASH
            {
             before(grammarAccess.getValueAccess().getSLASHTerminalRuleCall_6_2()); 
            match(input,RULE_SLASH,FOLLOW_2); 
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
    // InternalKbuild.g:4679:1: rule__Variable__Group_0__0 : rule__Variable__Group_0__0__Impl rule__Variable__Group_0__1 ;
    public final void rule__Variable__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4683:1: ( rule__Variable__Group_0__0__Impl rule__Variable__Group_0__1 )
            // InternalKbuild.g:4684:2: rule__Variable__Group_0__0__Impl rule__Variable__Group_0__1
            {
            pushFollow(FOLLOW_23);
            rule__Variable__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4691:1: rule__Variable__Group_0__0__Impl : ( () ) ;
    public final void rule__Variable__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4695:1: ( ( () ) )
            // InternalKbuild.g:4697:1: ( () )
            {
            // InternalKbuild.g:4697:1: ( () )
            // InternalKbuild.g:4698:1: ()
            {
             before(grammarAccess.getVariableAccess().getVariableAction_0_0()); 
            // InternalKbuild.g:4699:1: ()
            // InternalKbuild.g:4701:1: 
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
    // InternalKbuild.g:4713:1: rule__Variable__Group_0__1 : rule__Variable__Group_0__1__Impl rule__Variable__Group_0__2 ;
    public final void rule__Variable__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4717:1: ( rule__Variable__Group_0__1__Impl rule__Variable__Group_0__2 )
            // InternalKbuild.g:4718:2: rule__Variable__Group_0__1__Impl rule__Variable__Group_0__2
            {
            pushFollow(FOLLOW_11);
            rule__Variable__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4725:1: rule__Variable__Group_0__1__Impl : ( RULE_DOLLAR ) ;
    public final void rule__Variable__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4729:1: ( ( RULE_DOLLAR ) )
            // InternalKbuild.g:4731:1: ( RULE_DOLLAR )
            {
            // InternalKbuild.g:4731:1: ( RULE_DOLLAR )
            // InternalKbuild.g:4732:1: RULE_DOLLAR
            {
             before(grammarAccess.getVariableAccess().getDOLLARTerminalRuleCall_0_1()); 
            match(input,RULE_DOLLAR,FOLLOW_2); 
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
    // InternalKbuild.g:4745:1: rule__Variable__Group_0__2 : rule__Variable__Group_0__2__Impl ;
    public final void rule__Variable__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4749:1: ( rule__Variable__Group_0__2__Impl )
            // InternalKbuild.g:4750:2: rule__Variable__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4756:1: rule__Variable__Group_0__2__Impl : ( ( rule__Variable__NameAssignment_0_2 ) ) ;
    public final void rule__Variable__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4760:1: ( ( ( rule__Variable__NameAssignment_0_2 ) ) )
            // InternalKbuild.g:4762:1: ( ( rule__Variable__NameAssignment_0_2 ) )
            {
            // InternalKbuild.g:4762:1: ( ( rule__Variable__NameAssignment_0_2 ) )
            // InternalKbuild.g:4763:1: ( rule__Variable__NameAssignment_0_2 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_0_2()); 
            // InternalKbuild.g:4764:1: ( rule__Variable__NameAssignment_0_2 )
            // InternalKbuild.g:4764:2: rule__Variable__NameAssignment_0_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4782:1: rule__Variable__Group_1__0 : rule__Variable__Group_1__0__Impl rule__Variable__Group_1__1 ;
    public final void rule__Variable__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4786:1: ( rule__Variable__Group_1__0__Impl rule__Variable__Group_1__1 )
            // InternalKbuild.g:4787:2: rule__Variable__Group_1__0__Impl rule__Variable__Group_1__1
            {
            pushFollow(FOLLOW_8);
            rule__Variable__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4794:1: rule__Variable__Group_1__0__Impl : ( RULE_DOLLAR ) ;
    public final void rule__Variable__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4798:1: ( ( RULE_DOLLAR ) )
            // InternalKbuild.g:4800:1: ( RULE_DOLLAR )
            {
            // InternalKbuild.g:4800:1: ( RULE_DOLLAR )
            // InternalKbuild.g:4801:1: RULE_DOLLAR
            {
             before(grammarAccess.getVariableAccess().getDOLLARTerminalRuleCall_1_0()); 
            match(input,RULE_DOLLAR,FOLLOW_2); 
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
    // InternalKbuild.g:4814:1: rule__Variable__Group_1__1 : rule__Variable__Group_1__1__Impl rule__Variable__Group_1__2 ;
    public final void rule__Variable__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4818:1: ( rule__Variable__Group_1__1__Impl rule__Variable__Group_1__2 )
            // InternalKbuild.g:4819:2: rule__Variable__Group_1__1__Impl rule__Variable__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Variable__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4826:1: rule__Variable__Group_1__1__Impl : ( RULE_BRACE_START ) ;
    public final void rule__Variable__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4830:1: ( ( RULE_BRACE_START ) )
            // InternalKbuild.g:4832:1: ( RULE_BRACE_START )
            {
            // InternalKbuild.g:4832:1: ( RULE_BRACE_START )
            // InternalKbuild.g:4833:1: RULE_BRACE_START
            {
             before(grammarAccess.getVariableAccess().getBRACE_STARTTerminalRuleCall_1_1()); 
            match(input,RULE_BRACE_START,FOLLOW_2); 
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
    // InternalKbuild.g:4846:1: rule__Variable__Group_1__2 : rule__Variable__Group_1__2__Impl rule__Variable__Group_1__3 ;
    public final void rule__Variable__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4850:1: ( rule__Variable__Group_1__2__Impl rule__Variable__Group_1__3 )
            // InternalKbuild.g:4851:2: rule__Variable__Group_1__2__Impl rule__Variable__Group_1__3
            {
            pushFollow(FOLLOW_25);
            rule__Variable__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4858:1: rule__Variable__Group_1__2__Impl : ( ( rule__Variable__NameAssignment_1_2 ) ) ;
    public final void rule__Variable__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4862:1: ( ( ( rule__Variable__NameAssignment_1_2 ) ) )
            // InternalKbuild.g:4864:1: ( ( rule__Variable__NameAssignment_1_2 ) )
            {
            // InternalKbuild.g:4864:1: ( ( rule__Variable__NameAssignment_1_2 ) )
            // InternalKbuild.g:4865:1: ( rule__Variable__NameAssignment_1_2 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_1_2()); 
            // InternalKbuild.g:4866:1: ( rule__Variable__NameAssignment_1_2 )
            // InternalKbuild.g:4866:2: rule__Variable__NameAssignment_1_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4878:1: rule__Variable__Group_1__3 : rule__Variable__Group_1__3__Impl ;
    public final void rule__Variable__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4882:1: ( rule__Variable__Group_1__3__Impl )
            // InternalKbuild.g:4883:2: rule__Variable__Group_1__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4889:1: rule__Variable__Group_1__3__Impl : ( RULE_BRACE_END ) ;
    public final void rule__Variable__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4893:1: ( ( RULE_BRACE_END ) )
            // InternalKbuild.g:4895:1: ( RULE_BRACE_END )
            {
            // InternalKbuild.g:4895:1: ( RULE_BRACE_END )
            // InternalKbuild.g:4896:1: RULE_BRACE_END
            {
             before(grammarAccess.getVariableAccess().getBRACE_ENDTerminalRuleCall_1_3()); 
            match(input,RULE_BRACE_END,FOLLOW_2); 
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
    // InternalKbuild.g:4917:1: rule__ShellCmd__Group_0__0 : rule__ShellCmd__Group_0__0__Impl rule__ShellCmd__Group_0__1 ;
    public final void rule__ShellCmd__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4921:1: ( rule__ShellCmd__Group_0__0__Impl rule__ShellCmd__Group_0__1 )
            // InternalKbuild.g:4922:2: rule__ShellCmd__Group_0__0__Impl rule__ShellCmd__Group_0__1
            {
            pushFollow(FOLLOW_23);
            rule__ShellCmd__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4929:1: rule__ShellCmd__Group_0__0__Impl : ( () ) ;
    public final void rule__ShellCmd__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4933:1: ( ( () ) )
            // InternalKbuild.g:4935:1: ( () )
            {
            // InternalKbuild.g:4935:1: ( () )
            // InternalKbuild.g:4936:1: ()
            {
             before(grammarAccess.getShellCmdAccess().getShellCmdAction_0_0()); 
            // InternalKbuild.g:4937:1: ()
            // InternalKbuild.g:4939:1: 
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
    // InternalKbuild.g:4951:1: rule__ShellCmd__Group_0__1 : rule__ShellCmd__Group_0__1__Impl ;
    public final void rule__ShellCmd__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4955:1: ( rule__ShellCmd__Group_0__1__Impl )
            // InternalKbuild.g:4956:2: rule__ShellCmd__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4962:1: rule__ShellCmd__Group_0__1__Impl : ( ( rule__ShellCmd__Group_0_1__0 ) ) ;
    public final void rule__ShellCmd__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4966:1: ( ( ( rule__ShellCmd__Group_0_1__0 ) ) )
            // InternalKbuild.g:4968:1: ( ( rule__ShellCmd__Group_0_1__0 ) )
            {
            // InternalKbuild.g:4968:1: ( ( rule__ShellCmd__Group_0_1__0 ) )
            // InternalKbuild.g:4969:1: ( rule__ShellCmd__Group_0_1__0 )
            {
             before(grammarAccess.getShellCmdAccess().getGroup_0_1()); 
            // InternalKbuild.g:4970:1: ( rule__ShellCmd__Group_0_1__0 )
            // InternalKbuild.g:4970:2: rule__ShellCmd__Group_0_1__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4986:1: rule__ShellCmd__Group_0_1__0 : rule__ShellCmd__Group_0_1__0__Impl rule__ShellCmd__Group_0_1__1 ;
    public final void rule__ShellCmd__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:4990:1: ( rule__ShellCmd__Group_0_1__0__Impl rule__ShellCmd__Group_0_1__1 )
            // InternalKbuild.g:4991:2: rule__ShellCmd__Group_0_1__0__Impl rule__ShellCmd__Group_0_1__1
            {
            pushFollow(FOLLOW_8);
            rule__ShellCmd__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:4998:1: rule__ShellCmd__Group_0_1__0__Impl : ( RULE_DOLLAR ) ;
    public final void rule__ShellCmd__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5002:1: ( ( RULE_DOLLAR ) )
            // InternalKbuild.g:5004:1: ( RULE_DOLLAR )
            {
            // InternalKbuild.g:5004:1: ( RULE_DOLLAR )
            // InternalKbuild.g:5005:1: RULE_DOLLAR
            {
             before(grammarAccess.getShellCmdAccess().getDOLLARTerminalRuleCall_0_1_0()); 
            match(input,RULE_DOLLAR,FOLLOW_2); 
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
    // InternalKbuild.g:5018:1: rule__ShellCmd__Group_0_1__1 : rule__ShellCmd__Group_0_1__1__Impl rule__ShellCmd__Group_0_1__2 ;
    public final void rule__ShellCmd__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5022:1: ( rule__ShellCmd__Group_0_1__1__Impl rule__ShellCmd__Group_0_1__2 )
            // InternalKbuild.g:5023:2: rule__ShellCmd__Group_0_1__1__Impl rule__ShellCmd__Group_0_1__2
            {
            pushFollow(FOLLOW_11);
            rule__ShellCmd__Group_0_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5030:1: rule__ShellCmd__Group_0_1__1__Impl : ( RULE_BRACE_START ) ;
    public final void rule__ShellCmd__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5034:1: ( ( RULE_BRACE_START ) )
            // InternalKbuild.g:5036:1: ( RULE_BRACE_START )
            {
            // InternalKbuild.g:5036:1: ( RULE_BRACE_START )
            // InternalKbuild.g:5037:1: RULE_BRACE_START
            {
             before(grammarAccess.getShellCmdAccess().getBRACE_STARTTerminalRuleCall_0_1_1()); 
            match(input,RULE_BRACE_START,FOLLOW_2); 
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
    // InternalKbuild.g:5050:1: rule__ShellCmd__Group_0_1__2 : rule__ShellCmd__Group_0_1__2__Impl rule__ShellCmd__Group_0_1__3 ;
    public final void rule__ShellCmd__Group_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5054:1: ( rule__ShellCmd__Group_0_1__2__Impl rule__ShellCmd__Group_0_1__3 )
            // InternalKbuild.g:5055:2: rule__ShellCmd__Group_0_1__2__Impl rule__ShellCmd__Group_0_1__3
            {
            pushFollow(FOLLOW_41);
            rule__ShellCmd__Group_0_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5062:1: rule__ShellCmd__Group_0_1__2__Impl : ( ( rule__ShellCmd__NameAssignment_0_1_2 ) ) ;
    public final void rule__ShellCmd__Group_0_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5066:1: ( ( ( rule__ShellCmd__NameAssignment_0_1_2 ) ) )
            // InternalKbuild.g:5068:1: ( ( rule__ShellCmd__NameAssignment_0_1_2 ) )
            {
            // InternalKbuild.g:5068:1: ( ( rule__ShellCmd__NameAssignment_0_1_2 ) )
            // InternalKbuild.g:5069:1: ( rule__ShellCmd__NameAssignment_0_1_2 )
            {
             before(grammarAccess.getShellCmdAccess().getNameAssignment_0_1_2()); 
            // InternalKbuild.g:5070:1: ( rule__ShellCmd__NameAssignment_0_1_2 )
            // InternalKbuild.g:5070:2: rule__ShellCmd__NameAssignment_0_1_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5082:1: rule__ShellCmd__Group_0_1__3 : rule__ShellCmd__Group_0_1__3__Impl rule__ShellCmd__Group_0_1__4 ;
    public final void rule__ShellCmd__Group_0_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5086:1: ( rule__ShellCmd__Group_0_1__3__Impl rule__ShellCmd__Group_0_1__4 )
            // InternalKbuild.g:5087:2: rule__ShellCmd__Group_0_1__3__Impl rule__ShellCmd__Group_0_1__4
            {
            pushFollow(FOLLOW_25);
            rule__ShellCmd__Group_0_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5094:1: rule__ShellCmd__Group_0_1__3__Impl : ( ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 ) ) ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 )* ) ) ;
    public final void rule__ShellCmd__Group_0_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5098:1: ( ( ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 ) ) ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 )* ) ) )
            // InternalKbuild.g:5100:1: ( ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 ) ) ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 )* ) )
            {
            // InternalKbuild.g:5100:1: ( ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 ) ) ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 )* ) )
            // InternalKbuild.g:5101:1: ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 ) ) ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 )* )
            {
            // InternalKbuild.g:5101:1: ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 ) )
            // InternalKbuild.g:5102:1: ( rule__ShellCmd__ShellPartAssignment_0_1_3 )
            {
             before(grammarAccess.getShellCmdAccess().getShellPartAssignment_0_1_3()); 
            // InternalKbuild.g:5103:1: ( rule__ShellCmd__ShellPartAssignment_0_1_3 )
            // InternalKbuild.g:5103:2: rule__ShellCmd__ShellPartAssignment_0_1_3
            {
            pushFollow(FOLLOW_42);
            rule__ShellCmd__ShellPartAssignment_0_1_3();

            state._fsp--;


            }

             after(grammarAccess.getShellCmdAccess().getShellPartAssignment_0_1_3()); 

            }

            // InternalKbuild.g:5106:1: ( ( rule__ShellCmd__ShellPartAssignment_0_1_3 )* )
            // InternalKbuild.g:5107:1: ( rule__ShellCmd__ShellPartAssignment_0_1_3 )*
            {
             before(grammarAccess.getShellCmdAccess().getShellPartAssignment_0_1_3()); 
            // InternalKbuild.g:5108:1: ( rule__ShellCmd__ShellPartAssignment_0_1_3 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=RULE_STRING && LA36_0<=RULE_SHELL_CHAR)||(LA36_0>=RULE_BACKSLASH && LA36_0<=RULE_SYMBOL)||(LA36_0>=RULE_SLASH && LA36_0<=RULE_INCLUDE)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalKbuild.g:5108:2: rule__ShellCmd__ShellPartAssignment_0_1_3
            	    {
            	    pushFollow(FOLLOW_42);
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
    // InternalKbuild.g:5121:1: rule__ShellCmd__Group_0_1__4 : rule__ShellCmd__Group_0_1__4__Impl ;
    public final void rule__ShellCmd__Group_0_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5125:1: ( rule__ShellCmd__Group_0_1__4__Impl )
            // InternalKbuild.g:5126:2: rule__ShellCmd__Group_0_1__4__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5132:1: rule__ShellCmd__Group_0_1__4__Impl : ( RULE_BRACE_END ) ;
    public final void rule__ShellCmd__Group_0_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5136:1: ( ( RULE_BRACE_END ) )
            // InternalKbuild.g:5138:1: ( RULE_BRACE_END )
            {
            // InternalKbuild.g:5138:1: ( RULE_BRACE_END )
            // InternalKbuild.g:5139:1: RULE_BRACE_END
            {
             before(grammarAccess.getShellCmdAccess().getBRACE_ENDTerminalRuleCall_0_1_4()); 
            match(input,RULE_BRACE_END,FOLLOW_2); 
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
    // InternalKbuild.g:5162:1: rule__ShellCmd__Group_1__0 : rule__ShellCmd__Group_1__0__Impl rule__ShellCmd__Group_1__1 ;
    public final void rule__ShellCmd__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5166:1: ( rule__ShellCmd__Group_1__0__Impl rule__ShellCmd__Group_1__1 )
            // InternalKbuild.g:5167:2: rule__ShellCmd__Group_1__0__Impl rule__ShellCmd__Group_1__1
            {
            pushFollow(FOLLOW_24);
            rule__ShellCmd__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5174:1: rule__ShellCmd__Group_1__0__Impl : ( () ) ;
    public final void rule__ShellCmd__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5178:1: ( ( () ) )
            // InternalKbuild.g:5180:1: ( () )
            {
            // InternalKbuild.g:5180:1: ( () )
            // InternalKbuild.g:5181:1: ()
            {
             before(grammarAccess.getShellCmdAccess().getIncludeAction_1_0()); 
            // InternalKbuild.g:5182:1: ()
            // InternalKbuild.g:5184:1: 
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
    // InternalKbuild.g:5196:1: rule__ShellCmd__Group_1__1 : rule__ShellCmd__Group_1__1__Impl ;
    public final void rule__ShellCmd__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5200:1: ( rule__ShellCmd__Group_1__1__Impl )
            // InternalKbuild.g:5201:2: rule__ShellCmd__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5207:1: rule__ShellCmd__Group_1__1__Impl : ( RULE_INCLUDE ) ;
    public final void rule__ShellCmd__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5211:1: ( ( RULE_INCLUDE ) )
            // InternalKbuild.g:5213:1: ( RULE_INCLUDE )
            {
            // InternalKbuild.g:5213:1: ( RULE_INCLUDE )
            // InternalKbuild.g:5214:1: RULE_INCLUDE
            {
             before(grammarAccess.getShellCmdAccess().getINCLUDETerminalRuleCall_1_1()); 
            match(input,RULE_INCLUDE,FOLLOW_2); 
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
    // InternalKbuild.g:5231:1: rule__ShellPart__Group__0 : rule__ShellPart__Group__0__Impl rule__ShellPart__Group__1 ;
    public final void rule__ShellPart__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5235:1: ( rule__ShellPart__Group__0__Impl rule__ShellPart__Group__1 )
            // InternalKbuild.g:5236:2: rule__ShellPart__Group__0__Impl rule__ShellPart__Group__1
            {
            pushFollow(FOLLOW_41);
            rule__ShellPart__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5243:1: rule__ShellPart__Group__0__Impl : ( () ) ;
    public final void rule__ShellPart__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5247:1: ( ( () ) )
            // InternalKbuild.g:5249:1: ( () )
            {
            // InternalKbuild.g:5249:1: ( () )
            // InternalKbuild.g:5250:1: ()
            {
             before(grammarAccess.getShellPartAccess().getShellPartAction_0()); 
            // InternalKbuild.g:5251:1: ()
            // InternalKbuild.g:5253:1: 
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
    // InternalKbuild.g:5265:1: rule__ShellPart__Group__1 : rule__ShellPart__Group__1__Impl ;
    public final void rule__ShellPart__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5269:1: ( rule__ShellPart__Group__1__Impl )
            // InternalKbuild.g:5270:2: rule__ShellPart__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5276:1: rule__ShellPart__Group__1__Impl : ( ( rule__ShellPart__Alternatives_1 ) ) ;
    public final void rule__ShellPart__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5280:1: ( ( ( rule__ShellPart__Alternatives_1 ) ) )
            // InternalKbuild.g:5282:1: ( ( rule__ShellPart__Alternatives_1 ) )
            {
            // InternalKbuild.g:5282:1: ( ( rule__ShellPart__Alternatives_1 ) )
            // InternalKbuild.g:5283:1: ( rule__ShellPart__Alternatives_1 )
            {
             before(grammarAccess.getShellPartAccess().getAlternatives_1()); 
            // InternalKbuild.g:5284:1: ( rule__ShellPart__Alternatives_1 )
            // InternalKbuild.g:5284:2: rule__ShellPart__Alternatives_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5300:1: rule__ShellPart__Group_1_5__0 : rule__ShellPart__Group_1_5__0__Impl rule__ShellPart__Group_1_5__1 ;
    public final void rule__ShellPart__Group_1_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5304:1: ( rule__ShellPart__Group_1_5__0__Impl rule__ShellPart__Group_1_5__1 )
            // InternalKbuild.g:5305:2: rule__ShellPart__Group_1_5__0__Impl rule__ShellPart__Group_1_5__1
            {
            pushFollow(FOLLOW_12);
            rule__ShellPart__Group_1_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5312:1: rule__ShellPart__Group_1_5__0__Impl : ( RULE_BACKSLASH ) ;
    public final void rule__ShellPart__Group_1_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5316:1: ( ( RULE_BACKSLASH ) )
            // InternalKbuild.g:5318:1: ( RULE_BACKSLASH )
            {
            // InternalKbuild.g:5318:1: ( RULE_BACKSLASH )
            // InternalKbuild.g:5319:1: RULE_BACKSLASH
            {
             before(grammarAccess.getShellPartAccess().getBACKSLASHTerminalRuleCall_1_5_0()); 
            match(input,RULE_BACKSLASH,FOLLOW_2); 
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
    // InternalKbuild.g:5332:1: rule__ShellPart__Group_1_5__1 : rule__ShellPart__Group_1_5__1__Impl rule__ShellPart__Group_1_5__2 ;
    public final void rule__ShellPart__Group_1_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5336:1: ( rule__ShellPart__Group_1_5__1__Impl rule__ShellPart__Group_1_5__2 )
            // InternalKbuild.g:5337:2: rule__ShellPart__Group_1_5__1__Impl rule__ShellPart__Group_1_5__2
            {
            pushFollow(FOLLOW_20);
            rule__ShellPart__Group_1_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5344:1: rule__ShellPart__Group_1_5__1__Impl : ( ruleEol ) ;
    public final void rule__ShellPart__Group_1_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5348:1: ( ( ruleEol ) )
            // InternalKbuild.g:5350:1: ( ruleEol )
            {
            // InternalKbuild.g:5350:1: ( ruleEol )
            // InternalKbuild.g:5351:1: ruleEol
            {
             before(grammarAccess.getShellPartAccess().getEolParserRuleCall_1_5_1()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5364:1: rule__ShellPart__Group_1_5__2 : rule__ShellPart__Group_1_5__2__Impl ;
    public final void rule__ShellPart__Group_1_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5368:1: ( rule__ShellPart__Group_1_5__2__Impl )
            // InternalKbuild.g:5369:2: rule__ShellPart__Group_1_5__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5375:1: rule__ShellPart__Group_1_5__2__Impl : ( ( RULE_TAB )* ) ;
    public final void rule__ShellPart__Group_1_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5379:1: ( ( ( RULE_TAB )* ) )
            // InternalKbuild.g:5381:1: ( ( RULE_TAB )* )
            {
            // InternalKbuild.g:5381:1: ( ( RULE_TAB )* )
            // InternalKbuild.g:5382:1: ( RULE_TAB )*
            {
             before(grammarAccess.getShellPartAccess().getTABTerminalRuleCall_1_5_2()); 
            // InternalKbuild.g:5383:1: ( RULE_TAB )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_TAB) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalKbuild.g:5383:3: RULE_TAB
            	    {
            	    match(input,RULE_TAB,FOLLOW_21); 

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
    // InternalKbuild.g:5402:1: rule__Model__BuildEntryAssignment_1 : ( ruleBuildEntry ) ;
    public final void rule__Model__BuildEntryAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5406:1: ( ( ruleBuildEntry ) )
            // InternalKbuild.g:5407:1: ( ruleBuildEntry )
            {
            // InternalKbuild.g:5407:1: ( ruleBuildEntry )
            // InternalKbuild.g:5408:1: ruleBuildEntry
            {
             before(grammarAccess.getModelAccess().getBuildEntryBuildEntryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5417:1: rule__Model__BuildEntryAssignment_2_1 : ( ruleBuildEntry ) ;
    public final void rule__Model__BuildEntryAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5421:1: ( ( ruleBuildEntry ) )
            // InternalKbuild.g:5422:1: ( ruleBuildEntry )
            {
            // InternalKbuild.g:5422:1: ( ruleBuildEntry )
            // InternalKbuild.g:5423:1: ruleBuildEntry
            {
             before(grammarAccess.getModelAccess().getBuildEntryBuildEntryParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5432:1: rule__BuildEntry__ValueAssignment_0_1 : ( ruleEntry ) ;
    public final void rule__BuildEntry__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5436:1: ( ( ruleEntry ) )
            // InternalKbuild.g:5437:1: ( ruleEntry )
            {
            // InternalKbuild.g:5437:1: ( ruleEntry )
            // InternalKbuild.g:5438:1: ruleEntry
            {
             before(grammarAccess.getBuildEntryAccess().getValueEntryParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5447:1: rule__BuildEntry__ValueAssignment_1_2 : ( ruleIf ) ;
    public final void rule__BuildEntry__ValueAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5451:1: ( ( ruleIf ) )
            // InternalKbuild.g:5452:1: ( ruleIf )
            {
            // InternalKbuild.g:5452:1: ( ruleIf )
            // InternalKbuild.g:5453:1: ruleIf
            {
             before(grammarAccess.getBuildEntryAccess().getValueIfParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5462:1: rule__BuildEntry__ValueAssignment_2_2 : ( ruleIf ) ;
    public final void rule__BuildEntry__ValueAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5466:1: ( ( ruleIf ) )
            // InternalKbuild.g:5467:1: ( ruleIf )
            {
            // InternalKbuild.g:5467:1: ( ruleIf )
            // InternalKbuild.g:5468:1: ruleIf
            {
             before(grammarAccess.getBuildEntryAccess().getValueIfParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5477:1: rule__BuildEntry__NameAssignment_3_2 : ( RULE_SYMBOL ) ;
    public final void rule__BuildEntry__NameAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5481:1: ( ( RULE_SYMBOL ) )
            // InternalKbuild.g:5482:1: ( RULE_SYMBOL )
            {
            // InternalKbuild.g:5482:1: ( RULE_SYMBOL )
            // InternalKbuild.g:5483:1: RULE_SYMBOL
            {
             before(grammarAccess.getBuildEntryAccess().getNameSYMBOLTerminalRuleCall_3_2_0()); 
            match(input,RULE_SYMBOL,FOLLOW_2); 
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
    // InternalKbuild.g:5492:1: rule__BuildEntry__ValueAssignment_3_4_0 : ( ruleObject_Y ) ;
    public final void rule__BuildEntry__ValueAssignment_3_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5496:1: ( ( ruleObject_Y ) )
            // InternalKbuild.g:5497:1: ( ruleObject_Y )
            {
            // InternalKbuild.g:5497:1: ( ruleObject_Y )
            // InternalKbuild.g:5498:1: ruleObject_Y
            {
             before(grammarAccess.getBuildEntryAccess().getValueObject_YParserRuleCall_3_4_0_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5507:1: rule__BuildEntry__ValueAssignment_3_4_1 : ( ruleObject_M ) ;
    public final void rule__BuildEntry__ValueAssignment_3_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5511:1: ( ( ruleObject_M ) )
            // InternalKbuild.g:5512:1: ( ruleObject_M )
            {
            // InternalKbuild.g:5512:1: ( ruleObject_M )
            // InternalKbuild.g:5513:1: ruleObject_M
            {
             before(grammarAccess.getBuildEntryAccess().getValueObject_MParserRuleCall_3_4_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5522:1: rule__BuildEntry__NameAssignment_4_1 : ( RULE_SYMBOL ) ;
    public final void rule__BuildEntry__NameAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5526:1: ( ( RULE_SYMBOL ) )
            // InternalKbuild.g:5527:1: ( RULE_SYMBOL )
            {
            // InternalKbuild.g:5527:1: ( RULE_SYMBOL )
            // InternalKbuild.g:5528:1: RULE_SYMBOL
            {
             before(grammarAccess.getBuildEntryAccess().getNameSYMBOLTerminalRuleCall_4_1_0()); 
            match(input,RULE_SYMBOL,FOLLOW_2); 
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
    // InternalKbuild.g:5537:1: rule__BuildEntry__VariableAssignment_4_2 : ( ruleVariable ) ;
    public final void rule__BuildEntry__VariableAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5541:1: ( ( ruleVariable ) )
            // InternalKbuild.g:5542:1: ( ruleVariable )
            {
            // InternalKbuild.g:5542:1: ( ruleVariable )
            // InternalKbuild.g:5543:1: ruleVariable
            {
             before(grammarAccess.getBuildEntryAccess().getVariableVariableParserRuleCall_4_2_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5552:1: rule__BuildEntry__ValueAssignment_4_3 : ( ruleAssignExtra ) ;
    public final void rule__BuildEntry__ValueAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5556:1: ( ( ruleAssignExtra ) )
            // InternalKbuild.g:5557:1: ( ruleAssignExtra )
            {
            // InternalKbuild.g:5557:1: ( ruleAssignExtra )
            // InternalKbuild.g:5558:1: ruleAssignExtra
            {
             before(grammarAccess.getBuildEntryAccess().getValueAssignExtraParserRuleCall_4_3_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5567:1: rule__BuildEntry__InnerAssignment_4_4 : ( ruleAssign ) ;
    public final void rule__BuildEntry__InnerAssignment_4_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5571:1: ( ( ruleAssign ) )
            // InternalKbuild.g:5572:1: ( ruleAssign )
            {
            // InternalKbuild.g:5572:1: ( ruleAssign )
            // InternalKbuild.g:5573:1: ruleAssign
            {
             before(grammarAccess.getBuildEntryAccess().getInnerAssignParserRuleCall_4_4_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5582:1: rule__BuildEntry__ValueAssignment_5_1_0 : ( ruleObject_Y ) ;
    public final void rule__BuildEntry__ValueAssignment_5_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5586:1: ( ( ruleObject_Y ) )
            // InternalKbuild.g:5587:1: ( ruleObject_Y )
            {
            // InternalKbuild.g:5587:1: ( ruleObject_Y )
            // InternalKbuild.g:5588:1: ruleObject_Y
            {
             before(grammarAccess.getBuildEntryAccess().getValueObject_YParserRuleCall_5_1_0_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5597:1: rule__BuildEntry__ValueAssignment_5_1_1 : ( ruleObject_M ) ;
    public final void rule__BuildEntry__ValueAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5601:1: ( ( ruleObject_M ) )
            // InternalKbuild.g:5602:1: ( ruleObject_M )
            {
            // InternalKbuild.g:5602:1: ( ruleObject_M )
            // InternalKbuild.g:5603:1: ruleObject_M
            {
             before(grammarAccess.getBuildEntryAccess().getValueObject_MParserRuleCall_5_1_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5612:1: rule__BuildEntry__TargetAssignment_6_1 : ( ruleValues ) ;
    public final void rule__BuildEntry__TargetAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5616:1: ( ( ruleValues ) )
            // InternalKbuild.g:5617:1: ( ruleValues )
            {
            // InternalKbuild.g:5617:1: ( ruleValues )
            // InternalKbuild.g:5618:1: ruleValues
            {
             before(grammarAccess.getBuildEntryAccess().getTargetValuesParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5627:1: rule__BuildEntry__ValuesAssignment_6_3_1_0 : ( ruleValues ) ;
    public final void rule__BuildEntry__ValuesAssignment_6_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5631:1: ( ( ruleValues ) )
            // InternalKbuild.g:5632:1: ( ruleValues )
            {
            // InternalKbuild.g:5632:1: ( ruleValues )
            // InternalKbuild.g:5633:1: ruleValues
            {
             before(grammarAccess.getBuildEntryAccess().getValuesValuesParserRuleCall_6_3_1_0_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5642:1: rule__BuildEntry__ValuesAssignment_6_3_1_1_2 : ( ruleValues ) ;
    public final void rule__BuildEntry__ValuesAssignment_6_3_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5646:1: ( ( ruleValues ) )
            // InternalKbuild.g:5647:1: ( ruleValues )
            {
            // InternalKbuild.g:5647:1: ( ruleValues )
            // InternalKbuild.g:5648:1: ruleValues
            {
             before(grammarAccess.getBuildEntryAccess().getValuesValuesParserRuleCall_6_3_1_1_2_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5657:1: rule__BuildEntry__NameAssignment_7_1 : ( RULE_SYMBOL ) ;
    public final void rule__BuildEntry__NameAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5661:1: ( ( RULE_SYMBOL ) )
            // InternalKbuild.g:5662:1: ( RULE_SYMBOL )
            {
            // InternalKbuild.g:5662:1: ( RULE_SYMBOL )
            // InternalKbuild.g:5663:1: RULE_SYMBOL
            {
             before(grammarAccess.getBuildEntryAccess().getNameSYMBOLTerminalRuleCall_7_1_0()); 
            match(input,RULE_SYMBOL,FOLLOW_2); 
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
    // InternalKbuild.g:5672:1: rule__BuildEntry__VariableAssignment_7_2 : ( ruleVariable ) ;
    public final void rule__BuildEntry__VariableAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5676:1: ( ( ruleVariable ) )
            // InternalKbuild.g:5677:1: ( ruleVariable )
            {
            // InternalKbuild.g:5677:1: ( ruleVariable )
            // InternalKbuild.g:5678:1: ruleVariable
            {
             before(grammarAccess.getBuildEntryAccess().getVariableVariableParserRuleCall_7_2_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5687:1: rule__BuildEntry__ValueAssignment_7_3 : ( ruleAssign ) ;
    public final void rule__BuildEntry__ValueAssignment_7_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5691:1: ( ( ruleAssign ) )
            // InternalKbuild.g:5692:1: ( ruleAssign )
            {
            // InternalKbuild.g:5692:1: ( ruleAssign )
            // InternalKbuild.g:5693:1: ruleAssign
            {
             before(grammarAccess.getBuildEntryAccess().getValueAssignParserRuleCall_7_3_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5702:1: rule__Entry__VariableAssignment_2 : ( ruleVariable ) ;
    public final void rule__Entry__VariableAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5706:1: ( ( ruleVariable ) )
            // InternalKbuild.g:5707:1: ( ruleVariable )
            {
            // InternalKbuild.g:5707:1: ( ruleVariable )
            // InternalKbuild.g:5708:1: ruleVariable
            {
             before(grammarAccess.getEntryAccess().getVariableVariableParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5717:1: rule__Entry__ValueAssignment_3 : ( ruleAssignExtra ) ;
    public final void rule__Entry__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5721:1: ( ( ruleAssignExtra ) )
            // InternalKbuild.g:5722:1: ( ruleAssignExtra )
            {
            // InternalKbuild.g:5722:1: ( ruleAssignExtra )
            // InternalKbuild.g:5723:1: ruleAssignExtra
            {
             before(grammarAccess.getEntryAccess().getValueAssignExtraParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5732:1: rule__If__ShellAssignment_1_1_0 : ( ruleShellCmd ) ;
    public final void rule__If__ShellAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5736:1: ( ( ruleShellCmd ) )
            // InternalKbuild.g:5737:1: ( ruleShellCmd )
            {
            // InternalKbuild.g:5737:1: ( ruleShellCmd )
            // InternalKbuild.g:5738:1: ruleShellCmd
            {
             before(grammarAccess.getIfAccess().getShellShellCmdParserRuleCall_1_1_0_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5747:1: rule__If__ValueAssignment_5_0 : ( ruleObject_Y ) ;
    public final void rule__If__ValueAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5751:1: ( ( ruleObject_Y ) )
            // InternalKbuild.g:5752:1: ( ruleObject_Y )
            {
            // InternalKbuild.g:5752:1: ( ruleObject_Y )
            // InternalKbuild.g:5753:1: ruleObject_Y
            {
             before(grammarAccess.getIfAccess().getValueObject_YParserRuleCall_5_0_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5762:1: rule__If__ValueAssignment_5_1 : ( ruleObject_M ) ;
    public final void rule__If__ValueAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5766:1: ( ( ruleObject_M ) )
            // InternalKbuild.g:5767:1: ( ruleObject_M )
            {
            // InternalKbuild.g:5767:1: ( ruleObject_M )
            // InternalKbuild.g:5768:1: ruleObject_M
            {
             before(grammarAccess.getIfAccess().getValueObject_MParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5777:1: rule__If__ValueAssignment_5_2 : ( ruleEntry ) ;
    public final void rule__If__ValueAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5781:1: ( ( ruleEntry ) )
            // InternalKbuild.g:5782:1: ( ruleEntry )
            {
            // InternalKbuild.g:5782:1: ( ruleEntry )
            // InternalKbuild.g:5783:1: ruleEntry
            {
             before(grammarAccess.getIfAccess().getValueEntryParserRuleCall_5_2_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5792:1: rule__If__ValueAssignment_5_3 : ( ruleShellCmd ) ;
    public final void rule__If__ValueAssignment_5_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5796:1: ( ( ruleShellCmd ) )
            // InternalKbuild.g:5797:1: ( ruleShellCmd )
            {
            // InternalKbuild.g:5797:1: ( ruleShellCmd )
            // InternalKbuild.g:5798:1: ruleShellCmd
            {
             before(grammarAccess.getIfAccess().getValueShellCmdParserRuleCall_5_3_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5807:1: rule__If__ElsevalueAssignment_7_3_0 : ( ruleObject_Y ) ;
    public final void rule__If__ElsevalueAssignment_7_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5811:1: ( ( ruleObject_Y ) )
            // InternalKbuild.g:5812:1: ( ruleObject_Y )
            {
            // InternalKbuild.g:5812:1: ( ruleObject_Y )
            // InternalKbuild.g:5813:1: ruleObject_Y
            {
             before(grammarAccess.getIfAccess().getElsevalueObject_YParserRuleCall_7_3_0_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5822:1: rule__If__ElsevalueAssignment_7_3_1 : ( ruleObject_M ) ;
    public final void rule__If__ElsevalueAssignment_7_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5826:1: ( ( ruleObject_M ) )
            // InternalKbuild.g:5827:1: ( ruleObject_M )
            {
            // InternalKbuild.g:5827:1: ( ruleObject_M )
            // InternalKbuild.g:5828:1: ruleObject_M
            {
             before(grammarAccess.getIfAccess().getElsevalueObject_MParserRuleCall_7_3_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5837:1: rule__Object_Y__ValueAssignment_2 : ( ruleAssignExtra ) ;
    public final void rule__Object_Y__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5841:1: ( ( ruleAssignExtra ) )
            // InternalKbuild.g:5842:1: ( ruleAssignExtra )
            {
            // InternalKbuild.g:5842:1: ( ruleAssignExtra )
            // InternalKbuild.g:5843:1: ruleAssignExtra
            {
             before(grammarAccess.getObject_YAccess().getValueAssignExtraParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5852:1: rule__Object_M__ValueAssignment_2 : ( ruleAssignExtra ) ;
    public final void rule__Object_M__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5856:1: ( ( ruleAssignExtra ) )
            // InternalKbuild.g:5857:1: ( ruleAssignExtra )
            {
            // InternalKbuild.g:5857:1: ( ruleAssignExtra )
            // InternalKbuild.g:5858:1: ruleAssignExtra
            {
             before(grammarAccess.getObject_MAccess().getValueAssignExtraParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__Values__ItemsAssignment_1"
    // InternalKbuild.g:5867:1: rule__Values__ItemsAssignment_1 : ( ruleValue ) ;
    public final void rule__Values__ItemsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5871:1: ( ( ruleValue ) )
            // InternalKbuild.g:5872:1: ( ruleValue )
            {
            // InternalKbuild.g:5872:1: ( ruleValue )
            // InternalKbuild.g:5873:1: ruleValue
            {
             before(grammarAccess.getValuesAccess().getItemsValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValuesAccess().getItemsValueParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__ItemsAssignment_1"


    // $ANTLR start "rule__Values__ItemsAssignment_2_3"
    // InternalKbuild.g:5882:1: rule__Values__ItemsAssignment_2_3 : ( ruleValue ) ;
    public final void rule__Values__ItemsAssignment_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5886:1: ( ( ruleValue ) )
            // InternalKbuild.g:5887:1: ( ruleValue )
            {
            // InternalKbuild.g:5887:1: ( ruleValue )
            // InternalKbuild.g:5888:1: ruleValue
            {
             before(grammarAccess.getValuesAccess().getItemsValueParserRuleCall_2_3_0()); 
            pushFollow(FOLLOW_2);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValuesAccess().getItemsValueParserRuleCall_2_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Values__ItemsAssignment_2_3"


    // $ANTLR start "rule__Value__NameAssignment_1_1"
    // InternalKbuild.g:5897:1: rule__Value__NameAssignment_1_1 : ( RULE_SYMBOL ) ;
    public final void rule__Value__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5901:1: ( ( RULE_SYMBOL ) )
            // InternalKbuild.g:5902:1: ( RULE_SYMBOL )
            {
            // InternalKbuild.g:5902:1: ( RULE_SYMBOL )
            // InternalKbuild.g:5903:1: RULE_SYMBOL
            {
             before(grammarAccess.getValueAccess().getNameSYMBOLTerminalRuleCall_1_1_0()); 
            match(input,RULE_SYMBOL,FOLLOW_2); 
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
    // InternalKbuild.g:5912:1: rule__Value__ValueAssignment_2_1 : ( ruleVariable ) ;
    public final void rule__Value__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5916:1: ( ( ruleVariable ) )
            // InternalKbuild.g:5917:1: ( ruleVariable )
            {
            // InternalKbuild.g:5917:1: ( ruleVariable )
            // InternalKbuild.g:5918:1: ruleVariable
            {
             before(grammarAccess.getValueAccess().getValueVariableParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5927:1: rule__Value__AdditionalAssignment_2_2 : ( RULE_SLASH ) ;
    public final void rule__Value__AdditionalAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5931:1: ( ( RULE_SLASH ) )
            // InternalKbuild.g:5932:1: ( RULE_SLASH )
            {
            // InternalKbuild.g:5932:1: ( RULE_SLASH )
            // InternalKbuild.g:5933:1: RULE_SLASH
            {
             before(grammarAccess.getValueAccess().getAdditionalSLASHTerminalRuleCall_2_2_0()); 
            match(input,RULE_SLASH,FOLLOW_2); 
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
    // InternalKbuild.g:5942:1: rule__Value__ValueAssignment_3_1 : ( ruleShellCmd ) ;
    public final void rule__Value__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5946:1: ( ( ruleShellCmd ) )
            // InternalKbuild.g:5947:1: ( ruleShellCmd )
            {
            // InternalKbuild.g:5947:1: ( ruleShellCmd )
            // InternalKbuild.g:5948:1: ruleShellCmd
            {
             before(grammarAccess.getValueAccess().getValueShellCmdParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:5957:1: rule__Value__ValueAssignment_5_1 : ( RULE_SHELL_CHAR ) ;
    public final void rule__Value__ValueAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5961:1: ( ( RULE_SHELL_CHAR ) )
            // InternalKbuild.g:5962:1: ( RULE_SHELL_CHAR )
            {
            // InternalKbuild.g:5962:1: ( RULE_SHELL_CHAR )
            // InternalKbuild.g:5963:1: RULE_SHELL_CHAR
            {
             before(grammarAccess.getValueAccess().getValueSHELL_CHARTerminalRuleCall_5_1_0()); 
            match(input,RULE_SHELL_CHAR,FOLLOW_2); 
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
    // InternalKbuild.g:5972:1: rule__Variable__NameAssignment_0_2 : ( RULE_SYMBOL ) ;
    public final void rule__Variable__NameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5976:1: ( ( RULE_SYMBOL ) )
            // InternalKbuild.g:5977:1: ( RULE_SYMBOL )
            {
            // InternalKbuild.g:5977:1: ( RULE_SYMBOL )
            // InternalKbuild.g:5978:1: RULE_SYMBOL
            {
             before(grammarAccess.getVariableAccess().getNameSYMBOLTerminalRuleCall_0_2_0()); 
            match(input,RULE_SYMBOL,FOLLOW_2); 
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
    // InternalKbuild.g:5987:1: rule__Variable__NameAssignment_1_2 : ( RULE_SYMBOL ) ;
    public final void rule__Variable__NameAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:5991:1: ( ( RULE_SYMBOL ) )
            // InternalKbuild.g:5992:1: ( RULE_SYMBOL )
            {
            // InternalKbuild.g:5992:1: ( RULE_SYMBOL )
            // InternalKbuild.g:5993:1: RULE_SYMBOL
            {
             before(grammarAccess.getVariableAccess().getNameSYMBOLTerminalRuleCall_1_2_0()); 
            match(input,RULE_SYMBOL,FOLLOW_2); 
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
    // InternalKbuild.g:6002:1: rule__ShellCmd__NameAssignment_0_1_2 : ( RULE_SYMBOL ) ;
    public final void rule__ShellCmd__NameAssignment_0_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:6006:1: ( ( RULE_SYMBOL ) )
            // InternalKbuild.g:6007:1: ( RULE_SYMBOL )
            {
            // InternalKbuild.g:6007:1: ( RULE_SYMBOL )
            // InternalKbuild.g:6008:1: RULE_SYMBOL
            {
             before(grammarAccess.getShellCmdAccess().getNameSYMBOLTerminalRuleCall_0_1_2_0()); 
            match(input,RULE_SYMBOL,FOLLOW_2); 
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
    // InternalKbuild.g:6017:1: rule__ShellCmd__ShellPartAssignment_0_1_3 : ( ruleShellPart ) ;
    public final void rule__ShellCmd__ShellPartAssignment_0_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:6021:1: ( ( ruleShellPart ) )
            // InternalKbuild.g:6022:1: ( ruleShellPart )
            {
            // InternalKbuild.g:6022:1: ( ruleShellPart )
            // InternalKbuild.g:6023:1: ruleShellPart
            {
             before(grammarAccess.getShellCmdAccess().getShellPartShellPartParserRuleCall_0_1_3_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:6032:1: rule__ShellPart__ValAssignment_1_0 : ( ruleVarSlashSym ) ;
    public final void rule__ShellPart__ValAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:6036:1: ( ( ruleVarSlashSym ) )
            // InternalKbuild.g:6037:1: ( ruleVarSlashSym )
            {
            // InternalKbuild.g:6037:1: ( ruleVarSlashSym )
            // InternalKbuild.g:6038:1: ruleVarSlashSym
            {
             before(grammarAccess.getShellPartAccess().getValVarSlashSymParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:6047:1: rule__ShellPart__CmdAssignment_1_1 : ( ruleShellCmd ) ;
    public final void rule__ShellPart__CmdAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:6051:1: ( ( ruleShellCmd ) )
            // InternalKbuild.g:6052:1: ( ruleShellCmd )
            {
            // InternalKbuild.g:6052:1: ( ruleShellCmd )
            // InternalKbuild.g:6053:1: ruleShellCmd
            {
             before(grammarAccess.getShellPartAccess().getCmdShellCmdParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalKbuild.g:6062:1: rule__VarSlashSym__NameAssignment_1 : ( RULE_SLASH ) ;
    public final void rule__VarSlashSym__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:6066:1: ( ( RULE_SLASH ) )
            // InternalKbuild.g:6067:1: ( RULE_SLASH )
            {
            // InternalKbuild.g:6067:1: ( RULE_SLASH )
            // InternalKbuild.g:6068:1: RULE_SLASH
            {
             before(grammarAccess.getVarSlashSymAccess().getNameSLASHTerminalRuleCall_1_0()); 
            match(input,RULE_SLASH,FOLLOW_2); 
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
    // InternalKbuild.g:6077:1: rule__VarSlashSym__NameAssignment_2 : ( RULE_SYMBOL ) ;
    public final void rule__VarSlashSym__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalKbuild.g:6081:1: ( ( RULE_SYMBOL ) )
            // InternalKbuild.g:6082:1: ( RULE_SYMBOL )
            {
            // InternalKbuild.g:6082:1: ( RULE_SYMBOL )
            // InternalKbuild.g:6083:1: RULE_SYMBOL
            {
             before(grammarAccess.getVarSlashSymAccess().getNameSYMBOLTerminalRuleCall_2_0()); 
            match(input,RULE_SYMBOL,FOLLOW_2); 
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
            return "593:1: rule__BuildEntry__Alternatives : ( ( ( rule__BuildEntry__Group_0__0 ) ) | ( ( rule__BuildEntry__Group_1__0 ) ) | ( ( rule__BuildEntry__Group_2__0 ) ) | ( ( rule__BuildEntry__Group_3__0 ) ) | ( ( rule__BuildEntry__Group_4__0 ) ) | ( ( rule__BuildEntry__Group_5__0 ) ) | ( ( rule__BuildEntry__Group_6__0 ) ) | ( ( rule__BuildEntry__Group_7__0 ) ) );";
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
            return "917:1: rule__Value__Alternatives : ( ( ( rule__Value__Group_0__0 ) ) | ( ( rule__Value__Group_1__0 ) ) | ( ( rule__Value__Group_2__0 ) ) | ( ( rule__Value__Group_3__0 ) ) | ( ( rule__Value__Group_4__0 ) ) | ( ( rule__Value__Group_5__0 ) ) | ( ( rule__Value__Group_6__0 ) ) );";
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
            return "1046:1: rule__ShellPart__Alternatives_1 : ( ( ( rule__ShellPart__ValAssignment_1_0 ) ) | ( ( rule__ShellPart__CmdAssignment_1_1 ) ) | ( RULE_STRING ) | ( RULE_COMMA ) | ( RULE_SHELL_CHAR ) | ( ( rule__ShellPart__Group_1_5__0 ) ) );";
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
            return "()* loopback of 1235:1: ( rule__Model__Group_2__0 )*";
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
            return "()* loopback of 2295:1: ( rule__BuildEntry__Group_6_3_1_1__0 )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000066C4F410L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000066C4F400L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000020020300L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000066001400L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000066001420L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000060C60000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000C20000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000066021400L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000066001402L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000066021402L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000076001C00L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000076001C02L});

}