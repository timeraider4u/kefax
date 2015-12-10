package at.jku.isse.ecco.kefax.dotconfig.ui.contentassist.antlr.internal; 

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
import at.jku.isse.ecco.kefax.dotconfig.services.DotconfigGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDotconfigParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NLI", "RULE_S_HEX", "RULE_S_INT", "RULE_STRING", "RULE_EQ", "RULE_SYMBOL", "RULE_LOGIC_SYM", "RULE_SL_COMMENT_NOT", "RULE_WSS", "RULE_STR_D", "RULE_STR_S", "RULE_ESC", "RULE_SL_COMMENT"
    };
    public static final int RULE_STRING=7;
    public static final int RULE_S_INT=6;
    public static final int RULE_NLI=4;
    public static final int RULE_STR_D=13;
    public static final int RULE_LOGIC_SYM=10;
    public static final int RULE_SL_COMMENT_NOT=11;
    public static final int RULE_EQ=8;
    public static final int RULE_S_HEX=5;
    public static final int RULE_STR_S=14;
    public static final int RULE_ESC=15;
    public static final int RULE_SYMBOL=9;
    public static final int RULE_SL_COMMENT=16;
    public static final int EOF=-1;
    public static final int RULE_WSS=12;

    // delegates
    // delegators


        public InternalDotconfigParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDotconfigParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDotconfigParser.tokenNames; }
    public String getGrammarFileName() { return "../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g"; }


     
     	private DotconfigGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(DotconfigGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleDotConfigModel"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:60:1: entryRuleDotConfigModel : ruleDotConfigModel EOF ;
    public final void entryRuleDotConfigModel() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:61:1: ( ruleDotConfigModel EOF )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:62:1: ruleDotConfigModel EOF
            {
             before(grammarAccess.getDotConfigModelRule()); 
            pushFollow(FOLLOW_ruleDotConfigModel_in_entryRuleDotConfigModel61);
            ruleDotConfigModel();

            state._fsp--;

             after(grammarAccess.getDotConfigModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotConfigModel68); 

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
    // $ANTLR end "entryRuleDotConfigModel"


    // $ANTLR start "ruleDotConfigModel"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:69:1: ruleDotConfigModel : ( ( rule__DotConfigModel__Group__0 ) ) ;
    public final void ruleDotConfigModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:73:2: ( ( ( rule__DotConfigModel__Group__0 ) ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:74:1: ( ( rule__DotConfigModel__Group__0 ) )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:74:1: ( ( rule__DotConfigModel__Group__0 ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:75:1: ( rule__DotConfigModel__Group__0 )
            {
             before(grammarAccess.getDotConfigModelAccess().getGroup()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:76:1: ( rule__DotConfigModel__Group__0 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:76:2: rule__DotConfigModel__Group__0
            {
            pushFollow(FOLLOW_rule__DotConfigModel__Group__0_in_ruleDotConfigModel94);
            rule__DotConfigModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDotConfigModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDotConfigModel"


    // $ANTLR start "entryRuleConfig"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:88:1: entryRuleConfig : ruleConfig EOF ;
    public final void entryRuleConfig() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:89:1: ( ruleConfig EOF )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:90:1: ruleConfig EOF
            {
             before(grammarAccess.getConfigRule()); 
            pushFollow(FOLLOW_ruleConfig_in_entryRuleConfig121);
            ruleConfig();

            state._fsp--;

             after(grammarAccess.getConfigRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConfig128); 

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
    // $ANTLR end "entryRuleConfig"


    // $ANTLR start "ruleConfig"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:97:1: ruleConfig : ( ( rule__Config__Alternatives ) ) ;
    public final void ruleConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:101:2: ( ( ( rule__Config__Alternatives ) ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:102:1: ( ( rule__Config__Alternatives ) )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:102:1: ( ( rule__Config__Alternatives ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:103:1: ( rule__Config__Alternatives )
            {
             before(grammarAccess.getConfigAccess().getAlternatives()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:104:1: ( rule__Config__Alternatives )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:104:2: rule__Config__Alternatives
            {
            pushFollow(FOLLOW_rule__Config__Alternatives_in_ruleConfig154);
            rule__Config__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConfigAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConfig"


    // $ANTLR start "entryRulevalue"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:116:1: entryRulevalue : rulevalue EOF ;
    public final void entryRulevalue() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:117:1: ( rulevalue EOF )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:118:1: rulevalue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_rulevalue_in_entryRulevalue181);
            rulevalue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulevalue188); 

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
    // $ANTLR end "entryRulevalue"


    // $ANTLR start "rulevalue"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:125:1: rulevalue : ( ( rule__Value__Alternatives ) ) ;
    public final void rulevalue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:129:2: ( ( ( rule__Value__Alternatives ) ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:130:1: ( ( rule__Value__Alternatives ) )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:130:1: ( ( rule__Value__Alternatives ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:131:1: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:132:1: ( rule__Value__Alternatives )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:132:2: rule__Value__Alternatives
            {
            pushFollow(FOLLOW_rule__Value__Alternatives_in_rulevalue214);
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
    // $ANTLR end "rulevalue"


    // $ANTLR start "entryRuleEol"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:144:1: entryRuleEol : ruleEol EOF ;
    public final void entryRuleEol() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:145:1: ( ruleEol EOF )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:146:1: ruleEol EOF
            {
             before(grammarAccess.getEolRule()); 
            pushFollow(FOLLOW_ruleEol_in_entryRuleEol241);
            ruleEol();

            state._fsp--;

             after(grammarAccess.getEolRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEol248); 

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
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:153:1: ruleEol : ( ( ( RULE_NLI ) ) ( ( RULE_NLI )* ) ) ;
    public final void ruleEol() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:157:2: ( ( ( ( RULE_NLI ) ) ( ( RULE_NLI )* ) ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:158:1: ( ( ( RULE_NLI ) ) ( ( RULE_NLI )* ) )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:158:1: ( ( ( RULE_NLI ) ) ( ( RULE_NLI )* ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:159:1: ( ( RULE_NLI ) ) ( ( RULE_NLI )* )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:159:1: ( ( RULE_NLI ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:160:1: ( RULE_NLI )
            {
             before(grammarAccess.getEolAccess().getNLITerminalRuleCall()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:161:1: ( RULE_NLI )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:161:3: RULE_NLI
            {
            match(input,RULE_NLI,FOLLOW_RULE_NLI_in_ruleEol277); 

            }

             after(grammarAccess.getEolAccess().getNLITerminalRuleCall()); 

            }

            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:164:1: ( ( RULE_NLI )* )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:165:1: ( RULE_NLI )*
            {
             before(grammarAccess.getEolAccess().getNLITerminalRuleCall()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:166:1: ( RULE_NLI )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_NLI) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:166:3: RULE_NLI
            	    {
            	    match(input,RULE_NLI,FOLLOW_RULE_NLI_in_ruleEol290); 

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


    // $ANTLR start "rule__Config__Alternatives"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:179:1: rule__Config__Alternatives : ( ( ( rule__Config__Group_0__0 ) ) | ( ( rule__Config__Group_1__0 ) ) | ( ( rule__Config__Group_2__0 ) ) );
    public final void rule__Config__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:183:1: ( ( ( rule__Config__Group_0__0 ) ) | ( ( rule__Config__Group_1__0 ) ) | ( ( rule__Config__Group_2__0 ) ) )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_SYMBOL) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_EQ) ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3==RULE_LOGIC_SYM) ) {
                        alt2=2;
                    }
                    else if ( ((LA2_3>=RULE_S_HEX && LA2_3<=RULE_STRING)) ) {
                        alt2=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==RULE_SL_COMMENT_NOT) ) {
                alt2=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:184:1: ( ( rule__Config__Group_0__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:184:1: ( ( rule__Config__Group_0__0 ) )
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:185:1: ( rule__Config__Group_0__0 )
                    {
                     before(grammarAccess.getConfigAccess().getGroup_0()); 
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:186:1: ( rule__Config__Group_0__0 )
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:186:2: rule__Config__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Config__Group_0__0_in_rule__Config__Alternatives329);
                    rule__Config__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConfigAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:190:6: ( ( rule__Config__Group_1__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:190:6: ( ( rule__Config__Group_1__0 ) )
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:191:1: ( rule__Config__Group_1__0 )
                    {
                     before(grammarAccess.getConfigAccess().getGroup_1()); 
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:192:1: ( rule__Config__Group_1__0 )
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:192:2: rule__Config__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Config__Group_1__0_in_rule__Config__Alternatives347);
                    rule__Config__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConfigAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:196:6: ( ( rule__Config__Group_2__0 ) )
                    {
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:196:6: ( ( rule__Config__Group_2__0 ) )
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:197:1: ( rule__Config__Group_2__0 )
                    {
                     before(grammarAccess.getConfigAccess().getGroup_2()); 
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:198:1: ( rule__Config__Group_2__0 )
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:198:2: rule__Config__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Config__Group_2__0_in_rule__Config__Alternatives365);
                    rule__Config__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConfigAccess().getGroup_2()); 

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
    // $ANTLR end "rule__Config__Alternatives"


    // $ANTLR start "rule__Value__Alternatives"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:207:1: rule__Value__Alternatives : ( ( RULE_S_HEX ) | ( RULE_S_INT ) | ( RULE_STRING ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:211:1: ( ( RULE_S_HEX ) | ( RULE_S_INT ) | ( RULE_STRING ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_S_HEX:
                {
                alt3=1;
                }
                break;
            case RULE_S_INT:
                {
                alt3=2;
                }
                break;
            case RULE_STRING:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:212:1: ( RULE_S_HEX )
                    {
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:212:1: ( RULE_S_HEX )
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:213:1: RULE_S_HEX
                    {
                     before(grammarAccess.getValueAccess().getS_HEXTerminalRuleCall_0()); 
                    match(input,RULE_S_HEX,FOLLOW_RULE_S_HEX_in_rule__Value__Alternatives398); 
                     after(grammarAccess.getValueAccess().getS_HEXTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:218:6: ( RULE_S_INT )
                    {
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:218:6: ( RULE_S_INT )
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:219:1: RULE_S_INT
                    {
                     before(grammarAccess.getValueAccess().getS_INTTerminalRuleCall_1()); 
                    match(input,RULE_S_INT,FOLLOW_RULE_S_INT_in_rule__Value__Alternatives415); 
                     after(grammarAccess.getValueAccess().getS_INTTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:224:6: ( RULE_STRING )
                    {
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:224:6: ( RULE_STRING )
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:225:1: RULE_STRING
                    {
                     before(grammarAccess.getValueAccess().getSTRINGTerminalRuleCall_2()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Value__Alternatives432); 
                     after(grammarAccess.getValueAccess().getSTRINGTerminalRuleCall_2()); 

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


    // $ANTLR start "rule__DotConfigModel__Group__0"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:237:1: rule__DotConfigModel__Group__0 : rule__DotConfigModel__Group__0__Impl rule__DotConfigModel__Group__1 ;
    public final void rule__DotConfigModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:241:1: ( rule__DotConfigModel__Group__0__Impl rule__DotConfigModel__Group__1 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:242:2: rule__DotConfigModel__Group__0__Impl rule__DotConfigModel__Group__1
            {
            pushFollow(FOLLOW_rule__DotConfigModel__Group__0__Impl_in_rule__DotConfigModel__Group__0462);
            rule__DotConfigModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotConfigModel__Group__1_in_rule__DotConfigModel__Group__0465);
            rule__DotConfigModel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotConfigModel__Group__0"


    // $ANTLR start "rule__DotConfigModel__Group__0__Impl"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:249:1: rule__DotConfigModel__Group__0__Impl : ( () ) ;
    public final void rule__DotConfigModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:253:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:254:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:254:1: ( () )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:255:1: ()
            {
             before(grammarAccess.getDotConfigModelAccess().getDotConfigModelAction_0()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:256:1: ()
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:258:1: 
            {
            }

             after(grammarAccess.getDotConfigModelAccess().getDotConfigModelAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotConfigModel__Group__0__Impl"


    // $ANTLR start "rule__DotConfigModel__Group__1"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:268:1: rule__DotConfigModel__Group__1 : rule__DotConfigModel__Group__1__Impl rule__DotConfigModel__Group__2 ;
    public final void rule__DotConfigModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:272:1: ( rule__DotConfigModel__Group__1__Impl rule__DotConfigModel__Group__2 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:273:2: rule__DotConfigModel__Group__1__Impl rule__DotConfigModel__Group__2
            {
            pushFollow(FOLLOW_rule__DotConfigModel__Group__1__Impl_in_rule__DotConfigModel__Group__1523);
            rule__DotConfigModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotConfigModel__Group__2_in_rule__DotConfigModel__Group__1526);
            rule__DotConfigModel__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotConfigModel__Group__1"


    // $ANTLR start "rule__DotConfigModel__Group__1__Impl"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:280:1: rule__DotConfigModel__Group__1__Impl : ( ( rule__DotConfigModel__ConfigsAssignment_1 )? ) ;
    public final void rule__DotConfigModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:284:1: ( ( ( rule__DotConfigModel__ConfigsAssignment_1 )? ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:285:1: ( ( rule__DotConfigModel__ConfigsAssignment_1 )? )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:285:1: ( ( rule__DotConfigModel__ConfigsAssignment_1 )? )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:286:1: ( rule__DotConfigModel__ConfigsAssignment_1 )?
            {
             before(grammarAccess.getDotConfigModelAccess().getConfigsAssignment_1()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:287:1: ( rule__DotConfigModel__ConfigsAssignment_1 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_SYMBOL||LA4_0==RULE_SL_COMMENT_NOT) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:287:2: rule__DotConfigModel__ConfigsAssignment_1
                    {
                    pushFollow(FOLLOW_rule__DotConfigModel__ConfigsAssignment_1_in_rule__DotConfigModel__Group__1__Impl553);
                    rule__DotConfigModel__ConfigsAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDotConfigModelAccess().getConfigsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotConfigModel__Group__1__Impl"


    // $ANTLR start "rule__DotConfigModel__Group__2"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:297:1: rule__DotConfigModel__Group__2 : rule__DotConfigModel__Group__2__Impl rule__DotConfigModel__Group__3 ;
    public final void rule__DotConfigModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:301:1: ( rule__DotConfigModel__Group__2__Impl rule__DotConfigModel__Group__3 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:302:2: rule__DotConfigModel__Group__2__Impl rule__DotConfigModel__Group__3
            {
            pushFollow(FOLLOW_rule__DotConfigModel__Group__2__Impl_in_rule__DotConfigModel__Group__2584);
            rule__DotConfigModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotConfigModel__Group__3_in_rule__DotConfigModel__Group__2587);
            rule__DotConfigModel__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotConfigModel__Group__2"


    // $ANTLR start "rule__DotConfigModel__Group__2__Impl"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:309:1: rule__DotConfigModel__Group__2__Impl : ( ( rule__DotConfigModel__Group_2__0 )* ) ;
    public final void rule__DotConfigModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:313:1: ( ( ( rule__DotConfigModel__Group_2__0 )* ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:314:1: ( ( rule__DotConfigModel__Group_2__0 )* )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:314:1: ( ( rule__DotConfigModel__Group_2__0 )* )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:315:1: ( rule__DotConfigModel__Group_2__0 )*
            {
             before(grammarAccess.getDotConfigModelAccess().getGroup_2()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:316:1: ( rule__DotConfigModel__Group_2__0 )*
            loop5:
            do {
                int alt5=2;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:316:2: rule__DotConfigModel__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__DotConfigModel__Group_2__0_in_rule__DotConfigModel__Group__2__Impl614);
            	    rule__DotConfigModel__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getDotConfigModelAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotConfigModel__Group__2__Impl"


    // $ANTLR start "rule__DotConfigModel__Group__3"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:326:1: rule__DotConfigModel__Group__3 : rule__DotConfigModel__Group__3__Impl ;
    public final void rule__DotConfigModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:330:1: ( rule__DotConfigModel__Group__3__Impl )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:331:2: rule__DotConfigModel__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__DotConfigModel__Group__3__Impl_in_rule__DotConfigModel__Group__3645);
            rule__DotConfigModel__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotConfigModel__Group__3"


    // $ANTLR start "rule__DotConfigModel__Group__3__Impl"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:337:1: rule__DotConfigModel__Group__3__Impl : ( ( ruleEol )? ) ;
    public final void rule__DotConfigModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:341:1: ( ( ( ruleEol )? ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:342:1: ( ( ruleEol )? )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:342:1: ( ( ruleEol )? )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:343:1: ( ruleEol )?
            {
             before(grammarAccess.getDotConfigModelAccess().getEolParserRuleCall_3()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:344:1: ( ruleEol )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_NLI) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:344:3: ruleEol
                    {
                    pushFollow(FOLLOW_ruleEol_in_rule__DotConfigModel__Group__3__Impl673);
                    ruleEol();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDotConfigModelAccess().getEolParserRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotConfigModel__Group__3__Impl"


    // $ANTLR start "rule__DotConfigModel__Group_2__0"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:362:1: rule__DotConfigModel__Group_2__0 : rule__DotConfigModel__Group_2__0__Impl rule__DotConfigModel__Group_2__1 ;
    public final void rule__DotConfigModel__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:366:1: ( rule__DotConfigModel__Group_2__0__Impl rule__DotConfigModel__Group_2__1 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:367:2: rule__DotConfigModel__Group_2__0__Impl rule__DotConfigModel__Group_2__1
            {
            pushFollow(FOLLOW_rule__DotConfigModel__Group_2__0__Impl_in_rule__DotConfigModel__Group_2__0712);
            rule__DotConfigModel__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotConfigModel__Group_2__1_in_rule__DotConfigModel__Group_2__0715);
            rule__DotConfigModel__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotConfigModel__Group_2__0"


    // $ANTLR start "rule__DotConfigModel__Group_2__0__Impl"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:374:1: rule__DotConfigModel__Group_2__0__Impl : ( ruleEol ) ;
    public final void rule__DotConfigModel__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:378:1: ( ( ruleEol ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:379:1: ( ruleEol )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:379:1: ( ruleEol )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:380:1: ruleEol
            {
             before(grammarAccess.getDotConfigModelAccess().getEolParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleEol_in_rule__DotConfigModel__Group_2__0__Impl742);
            ruleEol();

            state._fsp--;

             after(grammarAccess.getDotConfigModelAccess().getEolParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotConfigModel__Group_2__0__Impl"


    // $ANTLR start "rule__DotConfigModel__Group_2__1"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:391:1: rule__DotConfigModel__Group_2__1 : rule__DotConfigModel__Group_2__1__Impl ;
    public final void rule__DotConfigModel__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:395:1: ( rule__DotConfigModel__Group_2__1__Impl )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:396:2: rule__DotConfigModel__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__DotConfigModel__Group_2__1__Impl_in_rule__DotConfigModel__Group_2__1771);
            rule__DotConfigModel__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotConfigModel__Group_2__1"


    // $ANTLR start "rule__DotConfigModel__Group_2__1__Impl"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:402:1: rule__DotConfigModel__Group_2__1__Impl : ( ( rule__DotConfigModel__ConfigsAssignment_2_1 ) ) ;
    public final void rule__DotConfigModel__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:406:1: ( ( ( rule__DotConfigModel__ConfigsAssignment_2_1 ) ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:407:1: ( ( rule__DotConfigModel__ConfigsAssignment_2_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:407:1: ( ( rule__DotConfigModel__ConfigsAssignment_2_1 ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:408:1: ( rule__DotConfigModel__ConfigsAssignment_2_1 )
            {
             before(grammarAccess.getDotConfigModelAccess().getConfigsAssignment_2_1()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:409:1: ( rule__DotConfigModel__ConfigsAssignment_2_1 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:409:2: rule__DotConfigModel__ConfigsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__DotConfigModel__ConfigsAssignment_2_1_in_rule__DotConfigModel__Group_2__1__Impl798);
            rule__DotConfigModel__ConfigsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDotConfigModelAccess().getConfigsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotConfigModel__Group_2__1__Impl"


    // $ANTLR start "rule__Config__Group_0__0"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:423:1: rule__Config__Group_0__0 : rule__Config__Group_0__0__Impl rule__Config__Group_0__1 ;
    public final void rule__Config__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:427:1: ( rule__Config__Group_0__0__Impl rule__Config__Group_0__1 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:428:2: rule__Config__Group_0__0__Impl rule__Config__Group_0__1
            {
            pushFollow(FOLLOW_rule__Config__Group_0__0__Impl_in_rule__Config__Group_0__0832);
            rule__Config__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Config__Group_0__1_in_rule__Config__Group_0__0835);
            rule__Config__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_0__0"


    // $ANTLR start "rule__Config__Group_0__0__Impl"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:435:1: rule__Config__Group_0__0__Impl : ( () ) ;
    public final void rule__Config__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:439:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:440:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:440:1: ( () )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:441:1: ()
            {
             before(grammarAccess.getConfigAccess().getConfigStringAction_0_0()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:442:1: ()
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:444:1: 
            {
            }

             after(grammarAccess.getConfigAccess().getConfigStringAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_0__0__Impl"


    // $ANTLR start "rule__Config__Group_0__1"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:454:1: rule__Config__Group_0__1 : rule__Config__Group_0__1__Impl rule__Config__Group_0__2 ;
    public final void rule__Config__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:458:1: ( rule__Config__Group_0__1__Impl rule__Config__Group_0__2 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:459:2: rule__Config__Group_0__1__Impl rule__Config__Group_0__2
            {
            pushFollow(FOLLOW_rule__Config__Group_0__1__Impl_in_rule__Config__Group_0__1893);
            rule__Config__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Config__Group_0__2_in_rule__Config__Group_0__1896);
            rule__Config__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_0__1"


    // $ANTLR start "rule__Config__Group_0__1__Impl"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:466:1: rule__Config__Group_0__1__Impl : ( ( rule__Config__NameAssignment_0_1 ) ) ;
    public final void rule__Config__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:470:1: ( ( ( rule__Config__NameAssignment_0_1 ) ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:471:1: ( ( rule__Config__NameAssignment_0_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:471:1: ( ( rule__Config__NameAssignment_0_1 ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:472:1: ( rule__Config__NameAssignment_0_1 )
            {
             before(grammarAccess.getConfigAccess().getNameAssignment_0_1()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:473:1: ( rule__Config__NameAssignment_0_1 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:473:2: rule__Config__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Config__NameAssignment_0_1_in_rule__Config__Group_0__1__Impl923);
            rule__Config__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getConfigAccess().getNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_0__1__Impl"


    // $ANTLR start "rule__Config__Group_0__2"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:483:1: rule__Config__Group_0__2 : rule__Config__Group_0__2__Impl rule__Config__Group_0__3 ;
    public final void rule__Config__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:487:1: ( rule__Config__Group_0__2__Impl rule__Config__Group_0__3 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:488:2: rule__Config__Group_0__2__Impl rule__Config__Group_0__3
            {
            pushFollow(FOLLOW_rule__Config__Group_0__2__Impl_in_rule__Config__Group_0__2953);
            rule__Config__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Config__Group_0__3_in_rule__Config__Group_0__2956);
            rule__Config__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_0__2"


    // $ANTLR start "rule__Config__Group_0__2__Impl"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:495:1: rule__Config__Group_0__2__Impl : ( RULE_EQ ) ;
    public final void rule__Config__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:499:1: ( ( RULE_EQ ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:500:1: ( RULE_EQ )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:500:1: ( RULE_EQ )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:501:1: RULE_EQ
            {
             before(grammarAccess.getConfigAccess().getEQTerminalRuleCall_0_2()); 
            match(input,RULE_EQ,FOLLOW_RULE_EQ_in_rule__Config__Group_0__2__Impl983); 
             after(grammarAccess.getConfigAccess().getEQTerminalRuleCall_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_0__2__Impl"


    // $ANTLR start "rule__Config__Group_0__3"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:512:1: rule__Config__Group_0__3 : rule__Config__Group_0__3__Impl ;
    public final void rule__Config__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:516:1: ( rule__Config__Group_0__3__Impl )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:517:2: rule__Config__Group_0__3__Impl
            {
            pushFollow(FOLLOW_rule__Config__Group_0__3__Impl_in_rule__Config__Group_0__31012);
            rule__Config__Group_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_0__3"


    // $ANTLR start "rule__Config__Group_0__3__Impl"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:523:1: rule__Config__Group_0__3__Impl : ( ( rule__Config__VAssignment_0_3 ) ) ;
    public final void rule__Config__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:527:1: ( ( ( rule__Config__VAssignment_0_3 ) ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:528:1: ( ( rule__Config__VAssignment_0_3 ) )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:528:1: ( ( rule__Config__VAssignment_0_3 ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:529:1: ( rule__Config__VAssignment_0_3 )
            {
             before(grammarAccess.getConfigAccess().getVAssignment_0_3()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:530:1: ( rule__Config__VAssignment_0_3 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:530:2: rule__Config__VAssignment_0_3
            {
            pushFollow(FOLLOW_rule__Config__VAssignment_0_3_in_rule__Config__Group_0__3__Impl1039);
            rule__Config__VAssignment_0_3();

            state._fsp--;


            }

             after(grammarAccess.getConfigAccess().getVAssignment_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_0__3__Impl"


    // $ANTLR start "rule__Config__Group_1__0"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:548:1: rule__Config__Group_1__0 : rule__Config__Group_1__0__Impl rule__Config__Group_1__1 ;
    public final void rule__Config__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:552:1: ( rule__Config__Group_1__0__Impl rule__Config__Group_1__1 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:553:2: rule__Config__Group_1__0__Impl rule__Config__Group_1__1
            {
            pushFollow(FOLLOW_rule__Config__Group_1__0__Impl_in_rule__Config__Group_1__01077);
            rule__Config__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Config__Group_1__1_in_rule__Config__Group_1__01080);
            rule__Config__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_1__0"


    // $ANTLR start "rule__Config__Group_1__0__Impl"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:560:1: rule__Config__Group_1__0__Impl : ( () ) ;
    public final void rule__Config__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:564:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:565:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:565:1: ( () )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:566:1: ()
            {
             before(grammarAccess.getConfigAccess().getConfigLogicAction_1_0()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:567:1: ()
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:569:1: 
            {
            }

             after(grammarAccess.getConfigAccess().getConfigLogicAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_1__0__Impl"


    // $ANTLR start "rule__Config__Group_1__1"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:579:1: rule__Config__Group_1__1 : rule__Config__Group_1__1__Impl rule__Config__Group_1__2 ;
    public final void rule__Config__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:583:1: ( rule__Config__Group_1__1__Impl rule__Config__Group_1__2 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:584:2: rule__Config__Group_1__1__Impl rule__Config__Group_1__2
            {
            pushFollow(FOLLOW_rule__Config__Group_1__1__Impl_in_rule__Config__Group_1__11138);
            rule__Config__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Config__Group_1__2_in_rule__Config__Group_1__11141);
            rule__Config__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_1__1"


    // $ANTLR start "rule__Config__Group_1__1__Impl"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:591:1: rule__Config__Group_1__1__Impl : ( ( rule__Config__NameAssignment_1_1 ) ) ;
    public final void rule__Config__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:595:1: ( ( ( rule__Config__NameAssignment_1_1 ) ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:596:1: ( ( rule__Config__NameAssignment_1_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:596:1: ( ( rule__Config__NameAssignment_1_1 ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:597:1: ( rule__Config__NameAssignment_1_1 )
            {
             before(grammarAccess.getConfigAccess().getNameAssignment_1_1()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:598:1: ( rule__Config__NameAssignment_1_1 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:598:2: rule__Config__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Config__NameAssignment_1_1_in_rule__Config__Group_1__1__Impl1168);
            rule__Config__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getConfigAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_1__1__Impl"


    // $ANTLR start "rule__Config__Group_1__2"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:608:1: rule__Config__Group_1__2 : rule__Config__Group_1__2__Impl rule__Config__Group_1__3 ;
    public final void rule__Config__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:612:1: ( rule__Config__Group_1__2__Impl rule__Config__Group_1__3 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:613:2: rule__Config__Group_1__2__Impl rule__Config__Group_1__3
            {
            pushFollow(FOLLOW_rule__Config__Group_1__2__Impl_in_rule__Config__Group_1__21198);
            rule__Config__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Config__Group_1__3_in_rule__Config__Group_1__21201);
            rule__Config__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_1__2"


    // $ANTLR start "rule__Config__Group_1__2__Impl"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:620:1: rule__Config__Group_1__2__Impl : ( RULE_EQ ) ;
    public final void rule__Config__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:624:1: ( ( RULE_EQ ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:625:1: ( RULE_EQ )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:625:1: ( RULE_EQ )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:626:1: RULE_EQ
            {
             before(grammarAccess.getConfigAccess().getEQTerminalRuleCall_1_2()); 
            match(input,RULE_EQ,FOLLOW_RULE_EQ_in_rule__Config__Group_1__2__Impl1228); 
             after(grammarAccess.getConfigAccess().getEQTerminalRuleCall_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_1__2__Impl"


    // $ANTLR start "rule__Config__Group_1__3"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:637:1: rule__Config__Group_1__3 : rule__Config__Group_1__3__Impl ;
    public final void rule__Config__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:641:1: ( rule__Config__Group_1__3__Impl )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:642:2: rule__Config__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__Config__Group_1__3__Impl_in_rule__Config__Group_1__31257);
            rule__Config__Group_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_1__3"


    // $ANTLR start "rule__Config__Group_1__3__Impl"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:648:1: rule__Config__Group_1__3__Impl : ( ( rule__Config__VAssignment_1_3 ) ) ;
    public final void rule__Config__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:652:1: ( ( ( rule__Config__VAssignment_1_3 ) ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:653:1: ( ( rule__Config__VAssignment_1_3 ) )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:653:1: ( ( rule__Config__VAssignment_1_3 ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:654:1: ( rule__Config__VAssignment_1_3 )
            {
             before(grammarAccess.getConfigAccess().getVAssignment_1_3()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:655:1: ( rule__Config__VAssignment_1_3 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:655:2: rule__Config__VAssignment_1_3
            {
            pushFollow(FOLLOW_rule__Config__VAssignment_1_3_in_rule__Config__Group_1__3__Impl1284);
            rule__Config__VAssignment_1_3();

            state._fsp--;


            }

             after(grammarAccess.getConfigAccess().getVAssignment_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_1__3__Impl"


    // $ANTLR start "rule__Config__Group_2__0"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:673:1: rule__Config__Group_2__0 : rule__Config__Group_2__0__Impl rule__Config__Group_2__1 ;
    public final void rule__Config__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:677:1: ( rule__Config__Group_2__0__Impl rule__Config__Group_2__1 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:678:2: rule__Config__Group_2__0__Impl rule__Config__Group_2__1
            {
            pushFollow(FOLLOW_rule__Config__Group_2__0__Impl_in_rule__Config__Group_2__01322);
            rule__Config__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Config__Group_2__1_in_rule__Config__Group_2__01325);
            rule__Config__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_2__0"


    // $ANTLR start "rule__Config__Group_2__0__Impl"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:685:1: rule__Config__Group_2__0__Impl : ( () ) ;
    public final void rule__Config__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:689:1: ( ( () ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:690:1: ( () )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:690:1: ( () )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:691:1: ()
            {
             before(grammarAccess.getConfigAccess().getConfigLogicAction_2_0()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:692:1: ()
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:694:1: 
            {
            }

             after(grammarAccess.getConfigAccess().getConfigLogicAction_2_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_2__0__Impl"


    // $ANTLR start "rule__Config__Group_2__1"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:704:1: rule__Config__Group_2__1 : rule__Config__Group_2__1__Impl ;
    public final void rule__Config__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:708:1: ( rule__Config__Group_2__1__Impl )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:709:2: rule__Config__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Config__Group_2__1__Impl_in_rule__Config__Group_2__11383);
            rule__Config__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_2__1"


    // $ANTLR start "rule__Config__Group_2__1__Impl"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:715:1: rule__Config__Group_2__1__Impl : ( ( rule__Config__NameAssignment_2_1 ) ) ;
    public final void rule__Config__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:719:1: ( ( ( rule__Config__NameAssignment_2_1 ) ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:720:1: ( ( rule__Config__NameAssignment_2_1 ) )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:720:1: ( ( rule__Config__NameAssignment_2_1 ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:721:1: ( rule__Config__NameAssignment_2_1 )
            {
             before(grammarAccess.getConfigAccess().getNameAssignment_2_1()); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:722:1: ( rule__Config__NameAssignment_2_1 )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:722:2: rule__Config__NameAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Config__NameAssignment_2_1_in_rule__Config__Group_2__1__Impl1410);
            rule__Config__NameAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getConfigAccess().getNameAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__Group_2__1__Impl"


    // $ANTLR start "rule__DotConfigModel__ConfigsAssignment_1"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:737:1: rule__DotConfigModel__ConfigsAssignment_1 : ( ruleConfig ) ;
    public final void rule__DotConfigModel__ConfigsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:741:1: ( ( ruleConfig ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:742:1: ( ruleConfig )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:742:1: ( ruleConfig )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:743:1: ruleConfig
            {
             before(grammarAccess.getDotConfigModelAccess().getConfigsConfigParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleConfig_in_rule__DotConfigModel__ConfigsAssignment_11449);
            ruleConfig();

            state._fsp--;

             after(grammarAccess.getDotConfigModelAccess().getConfigsConfigParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotConfigModel__ConfigsAssignment_1"


    // $ANTLR start "rule__DotConfigModel__ConfigsAssignment_2_1"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:752:1: rule__DotConfigModel__ConfigsAssignment_2_1 : ( ruleConfig ) ;
    public final void rule__DotConfigModel__ConfigsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:756:1: ( ( ruleConfig ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:757:1: ( ruleConfig )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:757:1: ( ruleConfig )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:758:1: ruleConfig
            {
             before(grammarAccess.getDotConfigModelAccess().getConfigsConfigParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleConfig_in_rule__DotConfigModel__ConfigsAssignment_2_11480);
            ruleConfig();

            state._fsp--;

             after(grammarAccess.getDotConfigModelAccess().getConfigsConfigParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotConfigModel__ConfigsAssignment_2_1"


    // $ANTLR start "rule__Config__NameAssignment_0_1"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:767:1: rule__Config__NameAssignment_0_1 : ( RULE_SYMBOL ) ;
    public final void rule__Config__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:771:1: ( ( RULE_SYMBOL ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:772:1: ( RULE_SYMBOL )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:772:1: ( RULE_SYMBOL )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:773:1: RULE_SYMBOL
            {
             before(grammarAccess.getConfigAccess().getNameSYMBOLTerminalRuleCall_0_1_0()); 
            match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_rule__Config__NameAssignment_0_11511); 
             after(grammarAccess.getConfigAccess().getNameSYMBOLTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__NameAssignment_0_1"


    // $ANTLR start "rule__Config__VAssignment_0_3"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:782:1: rule__Config__VAssignment_0_3 : ( rulevalue ) ;
    public final void rule__Config__VAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:786:1: ( ( rulevalue ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:787:1: ( rulevalue )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:787:1: ( rulevalue )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:788:1: rulevalue
            {
             before(grammarAccess.getConfigAccess().getVValueParserRuleCall_0_3_0()); 
            pushFollow(FOLLOW_rulevalue_in_rule__Config__VAssignment_0_31542);
            rulevalue();

            state._fsp--;

             after(grammarAccess.getConfigAccess().getVValueParserRuleCall_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__VAssignment_0_3"


    // $ANTLR start "rule__Config__NameAssignment_1_1"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:797:1: rule__Config__NameAssignment_1_1 : ( RULE_SYMBOL ) ;
    public final void rule__Config__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:801:1: ( ( RULE_SYMBOL ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:802:1: ( RULE_SYMBOL )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:802:1: ( RULE_SYMBOL )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:803:1: RULE_SYMBOL
            {
             before(grammarAccess.getConfigAccess().getNameSYMBOLTerminalRuleCall_1_1_0()); 
            match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_rule__Config__NameAssignment_1_11573); 
             after(grammarAccess.getConfigAccess().getNameSYMBOLTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__NameAssignment_1_1"


    // $ANTLR start "rule__Config__VAssignment_1_3"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:812:1: rule__Config__VAssignment_1_3 : ( RULE_LOGIC_SYM ) ;
    public final void rule__Config__VAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:816:1: ( ( RULE_LOGIC_SYM ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:817:1: ( RULE_LOGIC_SYM )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:817:1: ( RULE_LOGIC_SYM )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:818:1: RULE_LOGIC_SYM
            {
             before(grammarAccess.getConfigAccess().getVLOGIC_SYMTerminalRuleCall_1_3_0()); 
            match(input,RULE_LOGIC_SYM,FOLLOW_RULE_LOGIC_SYM_in_rule__Config__VAssignment_1_31604); 
             after(grammarAccess.getConfigAccess().getVLOGIC_SYMTerminalRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__VAssignment_1_3"


    // $ANTLR start "rule__Config__NameAssignment_2_1"
    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:827:1: rule__Config__NameAssignment_2_1 : ( RULE_SL_COMMENT_NOT ) ;
    public final void rule__Config__NameAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:831:1: ( ( RULE_SL_COMMENT_NOT ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:832:1: ( RULE_SL_COMMENT_NOT )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:832:1: ( RULE_SL_COMMENT_NOT )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:833:1: RULE_SL_COMMENT_NOT
            {
             before(grammarAccess.getConfigAccess().getNameSL_COMMENT_NOTTerminalRuleCall_2_1_0()); 
            match(input,RULE_SL_COMMENT_NOT,FOLLOW_RULE_SL_COMMENT_NOT_in_rule__Config__NameAssignment_2_11635); 
             after(grammarAccess.getConfigAccess().getNameSL_COMMENT_NOTTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Config__NameAssignment_2_1"

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\5\uffff";
    static final String DFA5_eofS =
        "\2\2\1\uffff\1\2\1\uffff";
    static final String DFA5_minS =
        "\2\4\1\uffff\1\4\1\uffff";
    static final String DFA5_maxS =
        "\1\4\1\13\1\uffff\1\13\1\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\2\1\uffff\1\1";
    static final String DFA5_specialS =
        "\5\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1",
            "\1\3\4\uffff\1\4\1\uffff\1\4",
            "",
            "\1\3\4\uffff\1\4\1\uffff\1\4",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "()* loopback of 316:1: ( rule__DotConfigModel__Group_2__0 )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleDotConfigModel_in_entryRuleDotConfigModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotConfigModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotConfigModel__Group__0_in_ruleDotConfigModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfig_in_entryRuleConfig121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConfig128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__Alternatives_in_ruleConfig154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulevalue_in_entryRulevalue181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulevalue188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Alternatives_in_rulevalue214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_entryRuleEol241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEol248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NLI_in_ruleEol277 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NLI_in_ruleEol290 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Config__Group_0__0_in_rule__Config__Alternatives329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__Group_1__0_in_rule__Config__Alternatives347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__Group_2__0_in_rule__Config__Alternatives365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_HEX_in_rule__Value__Alternatives398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_INT_in_rule__Value__Alternatives415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Value__Alternatives432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotConfigModel__Group__0__Impl_in_rule__DotConfigModel__Group__0462 = new BitSet(new long[]{0x0000000000000A10L});
    public static final BitSet FOLLOW_rule__DotConfigModel__Group__1_in_rule__DotConfigModel__Group__0465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotConfigModel__Group__1__Impl_in_rule__DotConfigModel__Group__1523 = new BitSet(new long[]{0x0000000000000A10L});
    public static final BitSet FOLLOW_rule__DotConfigModel__Group__2_in_rule__DotConfigModel__Group__1526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotConfigModel__ConfigsAssignment_1_in_rule__DotConfigModel__Group__1__Impl553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotConfigModel__Group__2__Impl_in_rule__DotConfigModel__Group__2584 = new BitSet(new long[]{0x0000000000000A10L});
    public static final BitSet FOLLOW_rule__DotConfigModel__Group__3_in_rule__DotConfigModel__Group__2587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotConfigModel__Group_2__0_in_rule__DotConfigModel__Group__2__Impl614 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__DotConfigModel__Group__3__Impl_in_rule__DotConfigModel__Group__3645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_rule__DotConfigModel__Group__3__Impl673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotConfigModel__Group_2__0__Impl_in_rule__DotConfigModel__Group_2__0712 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_rule__DotConfigModel__Group_2__1_in_rule__DotConfigModel__Group_2__0715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_rule__DotConfigModel__Group_2__0__Impl742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotConfigModel__Group_2__1__Impl_in_rule__DotConfigModel__Group_2__1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotConfigModel__ConfigsAssignment_2_1_in_rule__DotConfigModel__Group_2__1__Impl798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__Group_0__0__Impl_in_rule__Config__Group_0__0832 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__Config__Group_0__1_in_rule__Config__Group_0__0835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__Group_0__1__Impl_in_rule__Config__Group_0__1893 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Config__Group_0__2_in_rule__Config__Group_0__1896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__NameAssignment_0_1_in_rule__Config__Group_0__1__Impl923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__Group_0__2__Impl_in_rule__Config__Group_0__2953 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_rule__Config__Group_0__3_in_rule__Config__Group_0__2956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EQ_in_rule__Config__Group_0__2__Impl983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__Group_0__3__Impl_in_rule__Config__Group_0__31012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__VAssignment_0_3_in_rule__Config__Group_0__3__Impl1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__Group_1__0__Impl_in_rule__Config__Group_1__01077 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__Config__Group_1__1_in_rule__Config__Group_1__01080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__Group_1__1__Impl_in_rule__Config__Group_1__11138 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Config__Group_1__2_in_rule__Config__Group_1__11141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__NameAssignment_1_1_in_rule__Config__Group_1__1__Impl1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__Group_1__2__Impl_in_rule__Config__Group_1__21198 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__Config__Group_1__3_in_rule__Config__Group_1__21201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EQ_in_rule__Config__Group_1__2__Impl1228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__Group_1__3__Impl_in_rule__Config__Group_1__31257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__VAssignment_1_3_in_rule__Config__Group_1__3__Impl1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__Group_2__0__Impl_in_rule__Config__Group_2__01322 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_rule__Config__Group_2__1_in_rule__Config__Group_2__01325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__Group_2__1__Impl_in_rule__Config__Group_2__11383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Config__NameAssignment_2_1_in_rule__Config__Group_2__1__Impl1410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfig_in_rule__DotConfigModel__ConfigsAssignment_11449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfig_in_rule__DotConfigModel__ConfigsAssignment_2_11480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_rule__Config__NameAssignment_0_11511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulevalue_in_rule__Config__VAssignment_0_31542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_rule__Config__NameAssignment_1_11573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LOGIC_SYM_in_rule__Config__VAssignment_1_31604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SL_COMMENT_NOT_in_rule__Config__NameAssignment_2_11635 = new BitSet(new long[]{0x0000000000000002L});

}